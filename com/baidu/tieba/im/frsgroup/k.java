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
public final class k extends com.baidu.adp.a.f {
    private FrsGroupActivity a;
    private View c;
    private View d;
    private TextView e;
    private NavigationBar f;
    private RadioGroup g;
    private RadioButton h;
    private RadioButton i;
    private RadioButton j;
    private ViewGroup k;
    private ViewGroup l;
    private ViewGroup m;
    private Fragment[] n;
    private String[] o;
    private ViewGroup[] p;
    private ProgressBar q;
    private boolean r;
    private NoNetworkView s;

    public k(FrsGroupActivity frsGroupActivity) {
        super(frsGroupActivity);
        this.a = frsGroupActivity;
        frsGroupActivity.setContentView(com.baidu.tieba.im.i.im_frsgroup_activity);
        this.c = frsGroupActivity.findViewById(com.baidu.tieba.im.h.view_root);
        this.f = (NavigationBar) frsGroupActivity.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.d = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f.a(this.a.getString(com.baidu.tieba.im.j.frsgroup_title));
        this.e = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(com.baidu.tieba.im.j.frsgroup_create));
        this.d.setOnClickListener(frsGroupActivity);
        this.e.setOnClickListener(frsGroupActivity);
        this.s = (NoNetworkView) frsGroupActivity.findViewById(com.baidu.tieba.im.h.view_no_network);
        this.g = (RadioGroup) frsGroupActivity.findViewById(com.baidu.tieba.im.h.raidos_change);
        this.h = (RadioButton) frsGroupActivity.findViewById(com.baidu.tieba.im.h.radio_recommend);
        this.h.setChecked(true);
        this.i = (RadioButton) frsGroupActivity.findViewById(com.baidu.tieba.im.h.radio_hot);
        this.j = (RadioButton) frsGroupActivity.findViewById(com.baidu.tieba.im.h.radio_official);
        this.k = (ViewGroup) frsGroupActivity.findViewById(com.baidu.tieba.im.h.radio_recommend_line);
        this.l = (ViewGroup) frsGroupActivity.findViewById(com.baidu.tieba.im.h.radio_hot_line);
        this.m = (ViewGroup) frsGroupActivity.findViewById(com.baidu.tieba.im.h.radio_official_line);
        this.q = (ProgressBar) frsGroupActivity.findViewById(com.baidu.tieba.im.h.progress_loading);
        this.n = new Fragment[3];
        this.o = new String[3];
        this.o[0] = "f1";
        this.o[1] = "f2";
        this.o[2] = "f3";
        this.p = new ViewGroup[3];
        this.p[0] = this.k;
        this.p[1] = this.l;
        this.p[2] = this.m;
    }

    public final void a(int i) {
        for (int i2 = this.r ? 0 : 1; i2 < 3; i2++) {
            if (i == i2) {
                this.p[i2].setVisibility(0);
            } else {
                this.p[i2].setVisibility(4);
            }
        }
    }

    public final String[] a() {
        return this.o;
    }

    public final void b(int i) {
        switch (i) {
            case 1:
                this.h.setChecked(true);
                return;
            case 2:
                this.i.setChecked(true);
                return;
            case 3:
                this.j.setChecked(true);
                return;
            default:
                return;
        }
    }

    public final void d() {
        this.g.setOnCheckedChangeListener(this.a);
    }

    public final void e() {
        for (int i = 0; i < 3; i++) {
            this.n[i] = new b();
        }
    }

    public final void c(int i) {
        this.a.b().a(i == 1);
        this.a.b().a(this.c);
        this.f.b(i);
        if (this.s != null) {
            this.s.a(i);
        }
    }

    @Override // com.baidu.adp.a.f
    public final void c() {
        super.c();
        if (this.n != null) {
            FragmentTransaction beginTransaction = this.a.getSupportFragmentManager().beginTransaction();
            for (int i = 0; i < this.n.length; i++) {
                beginTransaction.remove(this.n[i]);
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public final Fragment[] f() {
        return this.n;
    }

    public final void a(boolean z) {
        this.r = z;
        if (z) {
            this.g.check(com.baidu.tieba.im.h.radio_recommend);
            this.h.setVisibility(0);
            this.k.setVisibility(0);
            return;
        }
        this.g.check(com.baidu.tieba.im.h.radio_hot);
        this.h.setVisibility(8);
        this.k.setVisibility(8);
    }

    public final void b(boolean z) {
        this.e.setEnabled(true);
    }

    public final void c(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
    }

    public final View g() {
        return this.d;
    }

    public final void d(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public final TextView h() {
        return this.e;
    }
}
