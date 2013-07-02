package com.baidu.tieba.home;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class z extends BaseAdapter implements com.baidu.tieba.view.v {
    LayoutInflater a;
    private Activity b;
    private int c;
    private com.baidu.tieba.data.aq d;
    private ViewPager e;
    private RecommendPagerAdapter f;
    private com.baidu.tieba.data.bc g;
    private ViewPager h;
    private TopicPagerAdapter i;
    private LinearLayout j;
    private m k;

    public z(Activity activity, m mVar) {
        this.k = mVar;
        this.b = activity;
        a();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int count = this.f != null ? this.f.getCount() + 0 : 0;
        if (this.i != null) {
            count += this.i.getCount();
        }
        return count > 0 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.j;
    }

    private void a() {
        this.c = TiebaApplication.f().at();
        this.a = LayoutInflater.from(this.b);
        this.j = (LinearLayout) this.a.inflate(R.layout.frs_activity_card, (ViewGroup) null);
        this.e = (ViewPager) this.j.findViewById(R.id.frs_card);
        this.e.setOnPageChangeListener(new aa(this));
        int a = (int) ((((com.baidu.tieba.util.ab.a(TiebaApplication.f().getApplicationContext()) - com.baidu.tieba.util.ab.a(this.b, 28.0f)) / 2) * this.b.getResources().getDimension(R.dimen.ad_image_height)) / this.b.getResources().getDimension(R.dimen.ad_image_width));
        this.h = (ViewPager) this.j.findViewById(R.id.frs_ad_button);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.height = a;
        this.h.setLayoutParams(layoutParams);
        this.h.setOnPageChangeListener(new ab(this));
    }

    public void a(com.baidu.tieba.data.aq aqVar, com.baidu.tieba.data.bc bcVar) {
        if (aqVar != null) {
            this.d = aqVar;
            this.f = new RecommendPagerAdapter(this.b, this.k);
            this.f.a(aqVar.a(), aqVar.b());
            this.e.setAdapter(this.f);
            this.e.a(1, false);
        }
        if (bcVar != null) {
            this.g = bcVar;
            this.i = new TopicPagerAdapter(this.b);
            this.i.a(bcVar.a());
            this.h.setAdapter(this.i);
            this.h.a(1, false);
        }
        notifyDataSetChanged();
    }

    public void a(int i) {
        int at = TiebaApplication.f().at();
        if (this.c != at) {
            a(this.d, this.g);
        }
        this.c = at;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.view.v
    public void c() {
        if (this.f != null) {
            this.f.c();
        }
        if (this.i != null) {
            this.i.c();
        }
    }

    @Override // com.baidu.tieba.view.v
    public void a(View view, int i, int i2) {
        if (this.f != null) {
            this.f.a(this.e, 0, 0);
        }
        if (this.i != null) {
            this.i.a(this.e, 0, 0);
        }
    }
}
