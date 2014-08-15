package com.baidu.tieba.im.live.livelist;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.f {
    private HotLiveListActivity a;
    private View b;
    private NavigationBar c;
    private RadioGroup d;
    private RadioButton e;
    private RadioButton f;
    private RadioButton g;
    private ViewGroup h;
    private ViewGroup i;
    private ViewGroup j;
    private ViewPager k;
    private boolean l;
    private z[] m;
    private String[] n;
    private ViewGroup[] o;
    private NoNetworkView p;

    public ad(HotLiveListActivity hotLiveListActivity, boolean z) {
        super(hotLiveListActivity);
        this.a = hotLiveListActivity;
        this.l = z;
        hotLiveListActivity.setContentView(com.baidu.tieba.v.live_hot_list_activity);
        a(hotLiveListActivity);
        b(hotLiveListActivity);
        c(hotLiveListActivity);
    }

    public z a() {
        return this.m[this.k.getCurrentItem()];
    }

    private void a(HotLiveListActivity hotLiveListActivity) {
        this.b = hotLiveListActivity.findViewById(com.baidu.tieba.u.view_root);
        this.c = (NavigationBar) hotLiveListActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(this.a.getString(com.baidu.tieba.x.group_tab_living_btn));
        this.p = (NoNetworkView) hotLiveListActivity.findViewById(com.baidu.tieba.u.view_no_network);
    }

    private void b(HotLiveListActivity hotLiveListActivity) {
        this.d = (RadioGroup) hotLiveListActivity.findViewById(com.baidu.tieba.u.raidos_change);
        this.e = (RadioButton) hotLiveListActivity.findViewById(com.baidu.tieba.u.radio_living);
        this.e.setChecked(true);
        this.f = (RadioButton) hotLiveListActivity.findViewById(com.baidu.tieba.u.radio_review);
        this.g = (RadioButton) hotLiveListActivity.findViewById(com.baidu.tieba.u.radio_foreshow);
        this.h = (ViewGroup) hotLiveListActivity.findViewById(com.baidu.tieba.u.radio_living_line);
        this.i = (ViewGroup) hotLiveListActivity.findViewById(com.baidu.tieba.u.radio_review_line);
        this.j = (ViewGroup) hotLiveListActivity.findViewById(com.baidu.tieba.u.radio_foreshow_line);
        if (!this.l) {
            this.f.setVisibility(8);
            this.i.setVisibility(8);
        }
        this.m = new z[this.l ? 3 : 2];
        this.n = new String[this.l ? 3 : 2];
        this.n[0] = "f1";
        this.n[1] = "f2";
        if (this.l) {
            this.n[2] = "f3";
        }
        this.o = new ViewGroup[this.l ? 3 : 2];
        if (this.l) {
            this.o[0] = this.h;
            this.o[1] = this.i;
            this.o[2] = this.j;
            return;
        }
        this.o[0] = this.h;
        this.o[1] = this.j;
    }

    private void c(HotLiveListActivity hotLiveListActivity) {
        int i = this.l ? 3 : 2;
        for (int i2 = 0; i2 < i; i2++) {
            this.m[i2] = new z();
            this.m[i2].a(this.n[i2]);
        }
        this.k = (ViewPager) this.a.findViewById(com.baidu.tieba.u.viewpage);
        this.k.setAdapter(new ae(this.a.getSupportFragmentManager(), this.m));
        this.k.setOnPageChangeListener(this.a);
        this.k.setOffscreenPageLimit(2);
    }

    public void a(int i) {
        int i2 = this.l ? 3 : 2;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i == i3) {
                this.o[i3].setVisibility(0);
            } else {
                this.o[i3].setVisibility(4);
            }
        }
    }

    public String b(int i) {
        int i2 = 0;
        if (this.l) {
            i2 = i - 1;
        } else if (i != 1 && i == 3) {
            i2 = 1;
        }
        return this.n[i2];
    }

    public void c(int i) {
        switch (i) {
            case 1:
                this.e.setChecked(true);
                return;
            case 2:
                this.f.setChecked(true);
                return;
            case 3:
                this.g.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void b() {
        this.d.setOnCheckedChangeListener(this.a);
    }

    public void d(int i) {
        this.a.c().a(i == 1);
        this.a.c().a(this.b);
        this.c.c(i);
        if (this.p != null) {
            this.p.a(i);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        super.destroy();
    }

    public void c() {
        this.d.check(com.baidu.tieba.u.radio_living);
    }

    public ViewPager d() {
        return this.k;
    }
}
