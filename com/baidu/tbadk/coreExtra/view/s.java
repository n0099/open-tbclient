package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class s extends PagerAdapter {
    private com.baidu.tbadk.widget.g aeA;
    private boolean aeH;
    private ArrayList<String> aew;
    private HashMap<String, ImageUrlData> aex;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener aey = null;
    private com.baidu.tbadk.widget.h aez = null;
    private int aeB = 0;
    private boolean aeC = false;
    private String aeD = null;
    private int aeE = 0;
    private boolean aeF = false;
    private boolean aeG = false;

    public s(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.g gVar) {
        this.mContext = null;
        this.aew = null;
        this.aeA = null;
        this.mContext = context;
        this.aew = arrayList;
        this.aeA = gVar;
    }

    public void p(ArrayList<String> arrayList) {
        this.aew = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.aex = hashMap;
    }

    public void setNextTitle(String str) {
        this.aeD = str;
    }

    public void setHasNext(boolean z) {
        this.aeC = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.aeC;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.aew != null) {
            i = this.aew.size();
            if (this.aeC) {
                i++;
            }
        }
        return i + this.aeE;
    }

    public void setTempSize(int i) {
        this.aeE = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aey = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.aeB = i;
    }

    public void a(com.baidu.tbadk.widget.h hVar) {
        this.aez = hVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof at) {
            ((at) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.aew.size()) {
            View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.big_image_next, null);
            ((ImageView) inflate.findViewById(com.baidu.tieba.v.image)).setImageDrawable(ba.getDrawable(com.baidu.tieba.u.big_image_next_default));
            ((TextView) inflate.findViewById(com.baidu.tieba.v.thread_name)).setText(this.aeD);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        at atVar = new at(this.mContext);
        String str = i < this.aew.size() ? this.aew.get(i) : null;
        atVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        atVar.setImageOnClickListener(this.mOnClickListener);
        atVar.setImageOnLongClickListener(this.aey);
        atVar.setIsCdn(this.aeF);
        atVar.setOnSizeChangedListener(this.aez);
        ((ViewPager) viewGroup).addView(atVar, 0);
        atVar.setAssistUrl(dP(str));
        atVar.n(str, this.aeG);
        atVar.setGifMaxUseableMem(this.aeB);
        atVar.setTag(String.valueOf(i));
        atVar.setGifSetListener(this.aeA);
        atVar.setHeadImage(this.aeH);
        return atVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof at) {
            p pVar = (p) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((at) obj).getImageView();
            if (pVar.getSelectedView() == null) {
                pVar.setSelectedView(imageView);
                ViewParent parent = pVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = pVar.getCurrentView();
            if (imageView != currentView || i == this.aew.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((at) obj).aH(this.aeG);
                pVar.setCurrentView(imageView);
                if (((at) obj).getImageType() == 1) {
                    this.aeA.a(imageView);
                }
            }
        }
    }

    private ImageUrlData dP(String str) {
        if (TextUtils.isEmpty(str) || this.aex == null) {
            return null;
        }
        return this.aex.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.aeG = z;
    }

    public void setIsCdn(boolean z) {
        this.aeF = z;
    }

    public void setHeadImage(boolean z) {
        this.aeH = z;
    }
}
