package com.baidu.tieba.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.bp;
import com.baidu.tieba.view.ADImageViewDrawer;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TopicPagerAdapter extends android.support.v4.view.ae implements com.baidu.tbadk.a.d, com.baidu.tieba.view.z {

    /* renamed from: a  reason: collision with root package name */
    int f1111a = 0;
    ArrayList b = new ArrayList();
    LayoutInflater c;
    public int d;
    public int e;
    private com.baidu.tieba.util.a f;
    private Activity g;
    private ArrayList h;
    private View i;

    public TopicPagerAdapter(Activity activity) {
        this.g = activity;
        this.d = (com.baidu.tieba.util.am.a((Context) activity) - com.baidu.tieba.util.am.a((Context) activity, 28.0f)) / 2;
        this.e = (int) ((this.d * activity.getResources().getDimension(R.dimen.ad_image_height)) / activity.getResources().getDimension(R.dimen.ad_image_width));
        this.c = LayoutInflater.from(activity);
        this.f = new com.baidu.tieba.util.a(activity);
        this.f.a(this.d, this.e);
    }

    @Override // android.support.v4.view.ae
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.b.get(i));
    }

    public void a(ArrayList arrayList) {
        a();
        this.h = arrayList;
        if (arrayList != null) {
            if (arrayList.size() % 2 != 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            this.f1111a = arrayList.size() / 2;
        }
        if (this.f1111a > 0) {
            View inflate = this.c.inflate(R.layout.viewpager_topic, (ViewGroup) null);
            a(inflate, (bp) arrayList.get((this.f1111a - 1) * 2), (bp) arrayList.get(((this.f1111a - 1) * 2) + 1));
            this.b.add(inflate);
            for (int i = 0; i < this.f1111a; i++) {
                View inflate2 = this.c.inflate(R.layout.viewpager_topic, (ViewGroup) null);
                a(inflate2, (bp) arrayList.get(i * 2), (bp) arrayList.get((i * 2) + 1));
                this.b.add(inflate2);
            }
            View inflate3 = this.c.inflate(R.layout.viewpager_topic, (ViewGroup) null);
            a(inflate3, (bp) arrayList.get(0), (bp) arrayList.get(1));
            this.b.add(inflate3);
            notifyDataSetChanged();
        }
    }

    @Override // android.support.v4.view.ae
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.b.get(i));
        return this.b.get(i);
    }

    private void a(View view, bp bpVar, bp bpVar2) {
        int i = R.drawable.bg_ad_banner_shadow_1;
        boolean z = TiebaApplication.f().au() == 1;
        ADImageViewDrawer aDImageViewDrawer = (ADImageViewDrawer) view.findViewById(R.id.ad1);
        aDImageViewDrawer.setTag(bpVar.f1006a);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aDImageViewDrawer.getLayoutParams();
        layoutParams.width = this.d;
        layoutParams.height = this.e;
        aDImageViewDrawer.setLayoutParams(layoutParams);
        this.f.a(bpVar.f1006a, new be(this, aDImageViewDrawer));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout1);
        linearLayout.setBackgroundResource(z ? R.drawable.bg_ad_banner_shadow_1 : R.drawable.bg_ad_banner_shadow);
        linearLayout.setOnClickListener(new bf(this, bpVar));
        ADImageViewDrawer aDImageViewDrawer2 = (ADImageViewDrawer) view.findViewById(R.id.ad2);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aDImageViewDrawer2.getLayoutParams();
        layoutParams2.width = this.d;
        layoutParams2.height = this.e;
        aDImageViewDrawer2.setLayoutParams(layoutParams2);
        aDImageViewDrawer2.setTag(bpVar2.f1006a);
        this.f.a(bpVar2.f1006a, new bg(this, aDImageViewDrawer2));
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout2);
        if (!z) {
            i = R.drawable.bg_ad_banner_shadow;
        }
        linearLayout2.setBackgroundResource(i);
        linearLayout2.setOnClickListener(new bh(this, bpVar2));
    }

    @Override // android.support.v4.view.ae
    public int getCount() {
        return this.b.size();
    }

    @Override // android.support.v4.view.ae
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    private void a() {
        this.b.clear();
        this.f1111a = 0;
        this.h = null;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.view.z
    public void c() {
        if (this.f != null) {
            this.f.b();
        }
    }

    @Override // com.baidu.tieba.view.z
    public void a(View view, int i, int i2) {
        this.i = view;
        if (this.f != null && this.h != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < this.h.size()) {
                    this.f.a(((bp) this.h.get(i4)).f1006a, this);
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        View findViewWithTag;
        if (this.i != null && (findViewWithTag = this.i.findViewWithTag(str)) != null) {
            findViewWithTag.invalidate();
        }
    }
}
