package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class o extends PagerAdapter {
    private Context a;
    private ArrayList<String> b;
    private com.baidu.tbadk.widget.e f;
    private boolean m;
    private View.OnClickListener c = null;
    private View.OnLongClickListener d = null;
    private com.baidu.tbadk.widget.f e = null;
    private int g = 0;
    private boolean h = false;
    private String i = null;
    private int j = 0;
    private boolean k = false;
    private boolean l = false;

    public o(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.e eVar) {
        this.a = null;
        this.b = null;
        this.f = null;
        this.a = context;
        this.b = null;
        this.f = eVar;
    }

    public final void a(ArrayList<String> arrayList) {
        this.b = arrayList;
        notifyDataSetChanged();
    }

    public final void a(String str) {
        this.i = str;
    }

    public final void a(boolean z) {
        this.h = z;
        notifyDataSetChanged();
    }

    public final boolean a() {
        return this.h;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        int i = 0;
        if (this.b != null) {
            i = this.b.size();
            if (this.h) {
                i++;
            }
        }
        return i + this.j;
    }

    public final void a(int i) {
        this.j = i;
        notifyDataSetChanged();
    }

    public final void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        this.d = onLongClickListener;
    }

    public final void b(int i) {
        this.g = i;
    }

    public final void a(com.baidu.tbadk.widget.f fVar) {
        this.e = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof ah) {
            ((ah) obj).a();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tbadk.k.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(com.baidu.tbadk.j.thread_name)).setText(this.i);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            inflate.setOnLongClickListener(this.d);
            return inflate;
        }
        ah ahVar = new ah(this.a);
        String str = i < this.b.size() ? this.b.get(i) : null;
        ahVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        ahVar.setImageOnClickListener(this.c);
        ahVar.setImageOnLongClickListener(this.d);
        ahVar.setIsCdn(this.k);
        ahVar.setOnSizeChangedListener(this.e);
        ((ViewPager) viewGroup).addView(ahVar, 0);
        ahVar.a(str, this.l);
        ahVar.setGifMaxUseableMem(this.g);
        ahVar.setTag(String.valueOf(i));
        ahVar.setGifSetListener(this.f);
        ahVar.setHeadImage(this.m);
        return ahVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof ah) {
            n nVar = (n) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((ah) obj).getImageView();
            if (nVar.getSelectedView() == null) {
                nVar.setSelectedView(imageView);
                ViewParent parent = nVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = nVar.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.n();
                }
                ((ah) obj).a(this.l);
                nVar.setCurrentView(imageView);
                if (((ah) obj).getImageType() == 1) {
                    this.f.a(imageView);
                }
            }
        }
    }

    public final void b(boolean z) {
        this.l = z;
    }

    public final void c(boolean z) {
        this.k = z;
    }

    public final void d(boolean z) {
        this.m = z;
    }
}
