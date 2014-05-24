package com.baidu.tieba.im.frsgroup;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.c {
    private FrsGroupActivity a;
    private View b;
    private View c;
    private TextView d;
    private NavigationBar e;
    private RadioGroup f;
    private RadioButton g;
    private RadioButton h;
    private RadioButton i;
    private ViewGroup j;
    private ViewGroup k;
    private ViewGroup l;
    private Fragment[] m;
    private String[] n;
    private ViewGroup[] o;
    private ProgressBar p;
    private boolean q;
    private NoNetworkView r;

    public k(FrsGroupActivity frsGroupActivity) {
        super(frsGroupActivity);
        this.a = frsGroupActivity;
        frsGroupActivity.setContentView(com.baidu.tieba.w.im_frsgroup_activity);
        a(frsGroupActivity);
        b(frsGroupActivity);
    }

    private void a(FrsGroupActivity frsGroupActivity) {
        this.b = frsGroupActivity.findViewById(com.baidu.tieba.v.view_root);
        this.e = (NavigationBar) frsGroupActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.c = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.a(this.a.getString(com.baidu.tieba.y.frsgroup_title));
        this.d = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(com.baidu.tieba.y.frsgroup_create));
        this.c.setOnClickListener(frsGroupActivity);
        this.d.setOnClickListener(frsGroupActivity);
        this.r = (NoNetworkView) frsGroupActivity.findViewById(com.baidu.tieba.v.view_no_network);
    }

    private void b(FrsGroupActivity frsGroupActivity) {
        this.f = (RadioGroup) frsGroupActivity.findViewById(com.baidu.tieba.v.raidos_change);
        this.g = (RadioButton) frsGroupActivity.findViewById(com.baidu.tieba.v.radio_recommend);
        this.g.setChecked(true);
        this.h = (RadioButton) frsGroupActivity.findViewById(com.baidu.tieba.v.radio_hot);
        this.i = (RadioButton) frsGroupActivity.findViewById(com.baidu.tieba.v.radio_official);
        this.j = (ViewGroup) frsGroupActivity.findViewById(com.baidu.tieba.v.radio_recommend_line);
        this.k = (ViewGroup) frsGroupActivity.findViewById(com.baidu.tieba.v.radio_hot_line);
        this.l = (ViewGroup) frsGroupActivity.findViewById(com.baidu.tieba.v.radio_official_line);
        this.p = (ProgressBar) frsGroupActivity.findViewById(com.baidu.tieba.v.progress_loading);
        this.m = new Fragment[3];
        this.n = new String[3];
        this.n[0] = "f1";
        this.n[1] = "f2";
        this.n[2] = "f3";
        this.o = new ViewGroup[3];
        this.o[0] = this.j;
        this.o[1] = this.k;
        this.o[2] = this.l;
    }

    public void a(int i) {
        for (int i2 = this.q ? 0 : 1; i2 < 3; i2++) {
            if (i == i2) {
                this.o[i2].setVisibility(0);
            } else {
                this.o[i2].setVisibility(4);
            }
        }
    }

    public String[] a() {
        return this.n;
    }

    public void b(int i) {
        switch (i) {
            case 1:
                this.g.setChecked(true);
                return;
            case 2:
                this.h.setChecked(true);
                return;
            case 3:
                this.i.setChecked(true);
                return;
            default:
                return;
        }
    }

    public void b() {
        this.f.setOnCheckedChangeListener(this.a);
    }

    public void c() {
        for (int i = 0; i < 3; i++) {
            this.m[i] = new b();
        }
    }

    public void c(int i) {
        this.a.a().a(i == 1);
        this.a.a().a(this.b);
        this.e.c(i);
        if (this.r != null) {
            this.r.a(i);
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        super.destroy();
        if (this.m != null) {
            FragmentTransaction beginTransaction = this.a.getSupportFragmentManager().beginTransaction();
            for (int i = 0; i < this.m.length; i++) {
                beginTransaction.remove(this.m[i]);
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public Fragment[] d() {
        return this.m;
    }

    public void a(boolean z) {
        this.q = z;
        if (z) {
            this.f.check(com.baidu.tieba.v.radio_recommend);
            this.g.setVisibility(0);
            this.j.setVisibility(0);
            return;
        }
        this.f.check(com.baidu.tieba.v.radio_hot);
        this.g.setVisibility(8);
        this.j.setVisibility(8);
    }

    public void b(boolean z) {
        this.d.setEnabled(z);
    }

    public void c(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
    }

    public View e() {
        return this.c;
    }

    public void d(boolean z) {
        this.p.setVisibility(z ? 0 : 8);
    }

    public TextView f() {
        return this.d;
    }
}
