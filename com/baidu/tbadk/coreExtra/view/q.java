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
    private ArrayList<String> NX;
    private com.baidu.tbadk.widget.e Oa;
    private boolean Oh;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener NY = null;
    private com.baidu.tbadk.widget.f NZ = null;
    private int Ob = 0;
    private boolean Oc = false;
    private String Od = null;
    private int Oe = 0;
    private boolean Of = false;
    private boolean Og = false;

    public q(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.e eVar) {
        this.mContext = null;
        this.NX = null;
        this.Oa = null;
        this.mContext = context;
        this.NX = arrayList;
        this.Oa = eVar;
    }

    public void setData(ArrayList<String> arrayList) {
        this.NX = arrayList;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.Od = str;
    }

    public void setHasNext(boolean z) {
        this.Oc = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.Oc;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.NX != null) {
            i = this.NX.size();
            if (this.Oc) {
                i++;
            }
        }
        return i + this.Oe;
    }

    public void setTempSize(int i) {
        this.Oe = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.NY = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.Ob = i;
    }

    public void a(com.baidu.tbadk.widget.f fVar) {
        this.NZ = fVar;
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
        if (i == this.NX.size()) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.big_image_next, null);
            ((TextView) inflate.findViewById(com.baidu.tieba.v.thread_name)).setText(this.Od);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        au auVar = new au(this.mContext);
        String str = i < this.NX.size() ? this.NX.get(i) : null;
        auVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        auVar.setImageOnClickListener(this.mOnClickListener);
        auVar.setImageOnLongClickListener(this.NY);
        auVar.setIsCdn(this.Of);
        auVar.setOnSizeChangedListener(this.NZ);
        ((ViewPager) viewGroup).addView(auVar, 0);
        auVar.k(str, this.Og);
        auVar.setGifMaxUseableMem(this.Ob);
        auVar.setTag(String.valueOf(i));
        auVar.setGifSetListener(this.Oa);
        auVar.setHeadImage(this.Oh);
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
                    currentView.vq();
                }
                ((au) obj).al(this.Og);
                pVar.setCurrentView(imageView);
                if (((au) obj).getImageType() == 1) {
                    this.Oa.a(imageView);
                }
            }
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.Og = z;
    }

    public void setIsCdn(boolean z) {
        this.Of = z;
    }

    public void setHeadImage(boolean z) {
        this.Oh = z;
    }
}
