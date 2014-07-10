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
public class r extends PagerAdapter {
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

    public r(Context context, ArrayList<String> arrayList, com.baidu.tbadk.widget.e eVar) {
        this.a = null;
        this.b = null;
        this.f = null;
        this.a = context;
        this.b = arrayList;
        this.f = eVar;
    }

    public void a(ArrayList<String> arrayList) {
        this.b = arrayList;
        notifyDataSetChanged();
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(boolean z) {
        this.h = z;
        notifyDataSetChanged();
    }

    public boolean a() {
        return this.h;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.b != null) {
            i = this.b.size();
            if (this.h) {
                i++;
            }
        }
        return i + this.j;
    }

    public void a(int i) {
        this.j = i;
        notifyDataSetChanged();
    }

    public void a(View.OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.d = onLongClickListener;
    }

    public void b(int i) {
        this.g = i;
    }

    public void a(com.baidu.tbadk.widget.f fVar) {
        this.e = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof av) {
            ((av) obj).c();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.b.size()) {
            View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.big_image_next, (ViewGroup) null);
            ((TextView) inflate.findViewById(com.baidu.tieba.v.thread_name)).setText(this.i);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.c);
            inflate.setOnLongClickListener(this.d);
            return inflate;
        }
        av avVar = new av(this.a);
        String str = i < this.b.size() ? this.b.get(i) : null;
        avVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        avVar.setImageOnClickListener(this.c);
        avVar.setImageOnLongClickListener(this.d);
        avVar.setIsCdn(this.k);
        avVar.setOnSizeChangedListener(this.e);
        ((ViewPager) viewGroup).addView(avVar, 0);
        avVar.a(str, this.l);
        avVar.setGifMaxUseableMem(this.g);
        avVar.setTag(String.valueOf(i));
        avVar.setGifSetListener(this.f);
        avVar.setHeadImage(this.m);
        return avVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof av) {
            q qVar = (q) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((av) obj).getImageView();
            if (qVar.getSelectedView() == null) {
                qVar.setSelectedView(imageView);
                ViewParent parent = qVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = qVar.getCurrentView();
            if (imageView != currentView) {
                if (currentView != null) {
                    currentView.o();
                }
                ((av) obj).a(this.l);
                qVar.setCurrentView(imageView);
                if (((av) obj).getImageType() == 1) {
                    this.f.a(imageView);
                }
            }
        }
    }

    public void b(boolean z) {
        this.l = z;
    }

    public void c(boolean z) {
        this.k = z;
    }

    public void d(boolean z) {
        this.m = z;
    }
}
