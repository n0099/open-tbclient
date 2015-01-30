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
    private ArrayList<String> Up;
    private com.baidu.tbadk.widget.g Us;
    private boolean Uz;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener Uq = null;
    private com.baidu.tbadk.widget.h Ur = null;
    private int Ut = 0;
    private boolean Uu = false;
    private String Uv = null;
    private int Uw = 0;
    private boolean Ux = false;
    private boolean Uy = false;

    public s(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.g gVar) {
        this.mContext = null;
        this.Up = null;
        this.Us = null;
        this.mContext = context;
        this.Up = arrayList;
        this.Us = gVar;
    }

    public void s(ArrayList<String> arrayList) {
        this.Up = arrayList;
        notifyDataSetChanged();
    }

    public void setNextTitle(String str) {
        this.Uv = str;
    }

    public void setHasNext(boolean z) {
        this.Uu = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.Uu;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.Up != null) {
            i = this.Up.size();
            if (this.Uu) {
                i++;
            }
        }
        return i + this.Uw;
    }

    public void setTempSize(int i) {
        this.Uw = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Uq = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.Ut = i;
    }

    public void a(com.baidu.tbadk.widget.h hVar) {
        this.Ur = hVar;
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
        if (i == this.Up.size()) {
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.big_image_next, null);
            ((ImageView) inflate.findViewById(com.baidu.tieba.w.image)).setImageDrawable(bc.getDrawable(com.baidu.tieba.v.big_image_next_default));
            ((TextView) inflate.findViewById(com.baidu.tieba.w.thread_name)).setText(this.Uv);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        ax axVar = new ax(this.mContext);
        String str = i < this.Up.size() ? this.Up.get(i) : null;
        axVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        axVar.setImageOnClickListener(this.mOnClickListener);
        axVar.setImageOnLongClickListener(this.Uq);
        axVar.setIsCdn(this.Ux);
        axVar.setOnSizeChangedListener(this.Ur);
        ((ViewPager) viewGroup).addView(axVar, 0);
        axVar.n(str, this.Uy);
        axVar.setGifMaxUseableMem(this.Ut);
        axVar.setTag(String.valueOf(i));
        axVar.setGifSetListener(this.Us);
        axVar.setHeadImage(this.Uz);
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
            if (imageView != currentView || i == this.Up.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((ax) obj).aB(this.Uy);
                pVar.setCurrentView(imageView);
                if (((ax) obj).getImageType() == 1) {
                    this.Us.a(imageView);
                }
            }
        }
    }

    public void setAllowLocalUrl(boolean z) {
        this.Uy = z;
    }

    public void setIsCdn(boolean z) {
        this.Ux = z;
    }

    public void setHeadImage(boolean z) {
        this.Uz = z;
    }
}
