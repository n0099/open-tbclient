package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q extends PagerAdapter {
    private ArrayList<String> NT;
    private com.baidu.tbadk.widget.e NW;
    private boolean Od;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener NU = null;
    private com.baidu.tbadk.widget.f NV = null;
    private int NX = 0;
    private boolean NY = false;
    private String NZ = null;
    private int Oa = 0;
    private boolean Ob = false;
    private boolean Oc = false;

    public q(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.e eVar) {
        this.mContext = null;
        this.NT = null;
        this.NW = null;
        this.mContext = context;
        this.NT = arrayList;
        this.NW = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        this.NT = arrayList;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.NZ = str;
    }

    public void setHasNext(boolean z) {
        this.NY = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.NY;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.NT != null) {
            i = this.NT.size();
            if (this.NY) {
                i++;
            }
        }
        return i + this.Oa;
    }

    public void setTempSize(int i) {
        this.Oa = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.NU = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.NX = i;
    }

    public void a(com.baidu.tbadk.widget.f fVar) {
        this.NV = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof au) {
            ((au) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.NT.size()) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.big_image_next, null);
            ((TextView) inflate.findViewById(com.baidu.tieba.v.thread_name)).setText(this.NZ);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            inflate.setOnLongClickListener(this.NU);
            return inflate;
        }
        au auVar = new au(this.mContext);
        String str = i < this.NT.size() ? this.NT.get(i) : null;
        auVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        auVar.setImageOnClickListener(this.mOnClickListener);
        auVar.setImageOnLongClickListener(this.NU);
        auVar.setIsCdn(this.Ob);
        auVar.setOnSizeChangedListener(this.NV);
        ((ViewPager) viewGroup).addView(auVar, 0);
        auVar.k(str, this.Oc);
        auVar.setGifMaxUseableMem(this.NX);
        auVar.setTag(String.valueOf(i));
        auVar.setGifSetListener(this.NW);
        auVar.setHeadImage(this.Od);
        return auVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof au) {
            p pVar = (p) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((au) obj).getImageView();
            if (pVar.getSelectedView() == null) {
                pVar.setSelectedView(imageView);
                ViewParent parent = pVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = pVar.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.vo();
                }
                ((au) obj).al(this.Oc);
                pVar.setCurrentView(imageView);
                if (((au) obj).getImageType() == 1) {
                    this.NW.a(imageView);
                }
            }
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.Oc = z;
    }

    public void setIsCdn(boolean z) {
        this.Ob = z;
    }

    public void setHeadImage(boolean z) {
        this.Od = z;
    }
}
