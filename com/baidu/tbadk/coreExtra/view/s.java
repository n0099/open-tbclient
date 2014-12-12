package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private ArrayList<String> TK;
    private com.baidu.tbadk.widget.g TN;
    private boolean TU;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener TL = null;
    private com.baidu.tbadk.widget.h TM = null;
    private int TO = 0;
    private boolean TP = false;
    private String TQ = null;
    private int TR = 0;
    private boolean TS = false;
    private boolean TT = false;

    public s(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.g gVar) {
        this.mContext = null;
        this.TK = null;
        this.TN = null;
        this.mContext = context;
        this.TK = arrayList;
        this.TN = gVar;
    }

    public void r(ArrayList<String> arrayList) {
        this.TK = arrayList;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.TQ = str;
    }

    public void setHasNext(boolean z) {
        this.TP = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.TP;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.TK != null) {
            i = this.TK.size();
            if (this.TP) {
                i++;
            }
        }
        return i + this.TR;
    }

    public void setTempSize(int i) {
        this.TR = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.TL = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.TO = i;
    }

    public void a(com.baidu.tbadk.widget.h hVar) {
        this.TM = hVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof ay) {
            ((ay) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.TK.size()) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.big_image_next, null);
            ((ImageView) inflate.findViewById(com.baidu.tieba.w.image)).setImageDrawable(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.big_image_next_default));
            ((TextView) inflate.findViewById(com.baidu.tieba.w.thread_name)).setText(this.TQ);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        ay ayVar = new ay(this.mContext);
        String str = i < this.TK.size() ? this.TK.get(i) : null;
        ayVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        ayVar.setImageOnClickListener(this.mOnClickListener);
        ayVar.setImageOnLongClickListener(this.TL);
        ayVar.setIsCdn(this.TS);
        ayVar.setOnSizeChangedListener(this.TM);
        ((ViewPager) viewGroup).addView(ayVar, 0);
        ayVar.n(str, this.TT);
        ayVar.setGifMaxUseableMem(this.TO);
        ayVar.setTag(String.valueOf(i));
        ayVar.setGifSetListener(this.TN);
        ayVar.setHeadImage(this.TU);
        return ayVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof ay) {
            p pVar = (p) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((ay) obj).getImageView();
            if (pVar.getSelectedView() == null) {
                pVar.setSelectedView(imageView);
                ViewParent parent = pVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = pVar.getCurrentView();
            if (imageView != currentView || i == this.TK.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((ay) obj).az(this.TT);
                pVar.setCurrentView(imageView);
                if (((ay) obj).getImageType() == 1) {
                    this.TN.a(imageView);
                }
            }
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.TT = z;
    }

    public void setIsCdn(boolean z) {
        this.TS = z;
    }

    public void setHeadImage(boolean z) {
        this.TU = z;
    }
}
