package com.baidu.tieba.im.frsgroup;

import android.support.v4.app.Fragment;
import android.support.v4.app.ae;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private FrsGroupActivity f1708a;
    private View c;
    private ImageView d;
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

    public g(FrsGroupActivity frsGroupActivity) {
        super(frsGroupActivity);
        this.f1708a = frsGroupActivity;
        frsGroupActivity.setContentView(R.layout.im_frsgroup_activity);
        a(frsGroupActivity);
        b(frsGroupActivity);
    }

    private void a(FrsGroupActivity frsGroupActivity) {
        this.c = frsGroupActivity.findViewById(R.id.view_root);
        this.f = (NavigationBar) frsGroupActivity.findViewById(R.id.view_navigation_bar);
        this.f.a(this.f1708a.getString(R.string.frsgroup_title));
        this.d = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f1708a.getString(R.string.frsgroup_create));
        this.d.setOnClickListener(frsGroupActivity);
        this.e.setOnClickListener(frsGroupActivity);
    }

    private void b(FrsGroupActivity frsGroupActivity) {
        this.g = (RadioGroup) frsGroupActivity.findViewById(R.id.raidos_change);
        this.h = (RadioButton) frsGroupActivity.findViewById(R.id.radio_recommend);
        this.h.setChecked(true);
        this.i = (RadioButton) frsGroupActivity.findViewById(R.id.radio_hot);
        this.j = (RadioButton) frsGroupActivity.findViewById(R.id.radio_official);
        this.k = (ViewGroup) frsGroupActivity.findViewById(R.id.radio_recommend_line);
        this.l = (ViewGroup) frsGroupActivity.findViewById(R.id.radio_hot_line);
        this.m = (ViewGroup) frsGroupActivity.findViewById(R.id.radio_official_line);
        this.q = (ProgressBar) frsGroupActivity.findViewById(R.id.progress_loading);
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

    public void a(int i) {
        for (int i2 = this.r ? 0 : 1; i2 < 3; i2++) {
            if (i == i2) {
                this.p[i2].setVisibility(0);
            } else {
                this.p[i2].setVisibility(4);
            }
        }
    }

    public String[] a() {
        return this.o;
    }

    public void b(int i) {
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

    public void e() {
        this.g.setOnCheckedChangeListener(this.f1708a);
    }

    public void f() {
        for (int i = 0; i < 3; i++) {
            this.n[i] = new FrsGroupListFragment();
        }
    }

    public void c(int i) {
        this.f1708a.a().a(i == 1);
        this.f1708a.a().a(this.c);
        this.f.c(i);
    }

    @Override // com.baidu.adp.a.e
    public void c() {
        super.c();
        if (this.n != null) {
            ae a2 = this.f1708a.getSupportFragmentManager().a();
            for (int i = 0; i < this.n.length; i++) {
                a2.a(this.n[i]);
            }
            a2.b();
        }
    }

    public Fragment[] g() {
        return this.n;
    }

    public void a(boolean z) {
        this.r = z;
        if (z) {
            this.g.check(R.id.radio_recommend);
            this.h.setVisibility(0);
            this.k.setVisibility(0);
            return;
        }
        this.g.check(R.id.radio_hot);
        this.h.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void b(boolean z) {
        this.e.setEnabled(z);
    }

    public void c(boolean z) {
        this.h.setVisibility(z ? 0 : 8);
    }

    public ImageView h() {
        return this.d;
    }

    public void d(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public TextView i() {
        return this.e;
    }
}
