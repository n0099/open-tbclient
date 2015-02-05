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
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private ArrayList<String> Um;
    private com.baidu.tbadk.widget.g Up;
    private boolean Uw;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener Un = null;
    private com.baidu.tbadk.widget.h Uo = null;
    private int Uq = 0;
    private boolean Ur = false;
    private String Us = null;
    private int Ut = 0;
    private boolean Uu = false;
    private boolean Uv = false;

    public s(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.g gVar) {
        this.mContext = null;
        this.Um = null;
        this.Up = null;
        this.mContext = context;
        this.Um = arrayList;
        this.Up = gVar;
    }

    public void s(ArrayList<String> arrayList) {
        this.Um = arrayList;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.Us = str;
    }

    public void setHasNext(boolean z) {
        this.Ur = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.Ur;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.Um != null) {
            i = this.Um.size();
            if (this.Ur) {
                i++;
            }
        }
        return i + this.Ut;
    }

    public void setTempSize(int i) {
        this.Ut = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Un = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.Uq = i;
    }

    public void a(com.baidu.tbadk.widget.h hVar) {
        this.Uo = hVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof ax) {
            ((ax) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.Um.size()) {
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.big_image_next, null);
            ((ImageView) inflate.findViewById(com.baidu.tieba.w.image)).setImageDrawable(bc.getDrawable(com.baidu.tieba.v.big_image_next_default));
            ((TextView) inflate.findViewById(com.baidu.tieba.w.thread_name)).setText(this.Us);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        ax axVar = new ax(this.mContext);
        String str = i < this.Um.size() ? this.Um.get(i) : null;
        axVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        axVar.setImageOnClickListener(this.mOnClickListener);
        axVar.setImageOnLongClickListener(this.Un);
        axVar.setIsCdn(this.Uu);
        axVar.setOnSizeChangedListener(this.Uo);
        ((ViewPager) viewGroup).addView(axVar, 0);
        axVar.n(str, this.Uv);
        axVar.setGifMaxUseableMem(this.Uq);
        axVar.setTag(String.valueOf(i));
        axVar.setGifSetListener(this.Up);
        axVar.setHeadImage(this.Uw);
        return axVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof ax) {
            p pVar = (p) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((ax) obj).getImageView();
            if (pVar.getSelectedView() == null) {
                pVar.setSelectedView(imageView);
                ViewParent parent = pVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = pVar.getCurrentView();
            if (imageView != currentView || i == this.Um.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((ax) obj).aB(this.Uv);
                pVar.setCurrentView(imageView);
                if (((ax) obj).getImageType() == 1) {
                    this.Up.a(imageView);
                }
            }
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.Uv = z;
    }

    public void setIsCdn(boolean z) {
        this.Uu = z;
    }

    public void setHeadImage(boolean z) {
        this.Uw = z;
    }
}
