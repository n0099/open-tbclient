package com.baidu.tieba.im.frsgroup;

import android.support.v4.app.Fragment;
import android.support.v4.app.ae;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private FrsGroupActivity f1650a;
    private View c;
    private ImageView d;
    private TextView e;
    private NavigationBar f;
    private RadioGroup g;
    private RadioButton h;
    private RadioButton i;
    private RadioButton j;
    private Fragment[] k;
    private String[] l;
    private ProgressBar m;
    private boolean n;

    public g(FrsGroupActivity frsGroupActivity) {
        super(frsGroupActivity);
        this.f1650a = frsGroupActivity;
        frsGroupActivity.setContentView(R.layout.im_frsgroup_activity);
        a(frsGroupActivity);
        b(frsGroupActivity);
    }

    private void a(FrsGroupActivity frsGroupActivity) {
        this.c = frsGroupActivity.findViewById(R.id.view_root);
        this.f = (NavigationBar) frsGroupActivity.findViewById(R.id.view_navigation_bar);
        this.f.a(this.f1650a.getString(R.string.frsgroup_title));
        this.d = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e = this.f.b(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f1650a.getString(R.string.frsgroup_create));
        this.d.setOnClickListener(frsGroupActivity);
        this.e.setOnClickListener(frsGroupActivity);
    }

    private void b(FrsGroupActivity frsGroupActivity) {
        this.g = (RadioGroup) frsGroupActivity.findViewById(R.id.raidos_change);
        this.h = (RadioButton) frsGroupActivity.findViewById(R.id.radio_recommend);
        this.h.setChecked(true);
        this.i = (RadioButton) frsGroupActivity.findViewById(R.id.radio_hot);
        this.j = (RadioButton) frsGroupActivity.findViewById(R.id.radio_official);
        this.m = (ProgressBar) frsGroupActivity.findViewById(R.id.progress_loading);
        this.k = new Fragment[3];
        this.l = new String[3];
        this.l[0] = "f1";
        this.l[1] = "f2";
        this.l[2] = "f3";
    }

    public String[] a() {
        return this.l;
    }

    public void a(int i) {
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
        this.g.setOnCheckedChangeListener(this.f1650a);
    }

    public void f() {
        for (int i = 0; i < 3; i++) {
            this.k[i] = new FrsGroupListFragment();
        }
    }

    public void b(int i) {
        this.f1650a.a().a(i == 1);
        this.f1650a.a().a(this.c);
        this.f.c(i);
        if (i == 1) {
            this.c.setBackgroundColor(this.f1650a.getResources().getColor(R.color.frsgruop_container_bg_1));
            bd.e(this.g, (int) R.drawable.bg_pop_most_1);
            this.j.setBackgroundResource(R.drawable.radio_commen_bg_right_1);
            this.h.setBackgroundResource(R.drawable.radio_commen_bg_left_1);
            if (this.n) {
                this.i.setBackgroundResource(R.drawable.radio_commen_bg_middle_1);
                return;
            } else {
                this.i.setBackgroundResource(R.drawable.radio_commen_bg_left_1);
                return;
            }
        }
        this.c.setBackgroundColor(this.f1650a.getResources().getColor(R.color.frsgroup_container_bg));
        bd.e(this.g, (int) R.drawable.bg_pop_most);
        this.j.setBackgroundResource(R.drawable.radio_commen_bg_right);
        this.h.setBackgroundResource(R.drawable.radio_commen_bg_left);
        if (this.n) {
            this.i.setBackgroundResource(R.drawable.radio_commen_bg_middle);
        } else {
            this.i.setBackgroundResource(R.drawable.radio_commen_bg_left);
        }
    }

    @Override // com.baidu.adp.a.e
    public void c() {
        super.c();
        if (this.k != null) {
            ae a2 = this.f1650a.getSupportFragmentManager().a();
            for (int i = 0; i < this.k.length; i++) {
                a2.a(this.k[i]);
            }
            a2.b();
        }
    }

    public Fragment[] g() {
        return this.k;
    }

    public void a(boolean z) {
        this.n = z;
        if (z) {
            this.g.check(R.id.radio_recommend);
            this.h.setVisibility(0);
            return;
        }
        this.g.check(R.id.radio_hot);
        this.h.setVisibility(8);
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
        this.m.setVisibility(z ? 0 : 8);
    }

    public TextView i() {
        return this.e;
    }
}
