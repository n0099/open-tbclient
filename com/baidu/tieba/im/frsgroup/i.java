package com.baidu.tieba.im.frsgroup;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    private FrsGroupActivity f1564a;
    private View c;
    private ImageView d;
    private Button e;
    private RadioGroup f;
    private RadioButton g;
    private RadioButton h;
    private RadioButton i;
    private Fragment[] j;
    private String[] k;
    private ProgressBar l;
    private boolean m;

    public i(FrsGroupActivity frsGroupActivity) {
        super(frsGroupActivity);
        this.f1564a = frsGroupActivity;
        frsGroupActivity.setContentView(R.layout.im_frsgroup_activity);
        a(frsGroupActivity);
        b(frsGroupActivity);
    }

    private void a(FrsGroupActivity frsGroupActivity) {
        this.c = frsGroupActivity.findViewById(R.id.view_root);
        this.d = (ImageView) frsGroupActivity.findViewById(R.id.title_back);
        this.e = (Button) frsGroupActivity.findViewById(R.id.btn_create);
        this.d.setOnClickListener(frsGroupActivity);
        this.e.setOnClickListener(frsGroupActivity);
    }

    private void b(FrsGroupActivity frsGroupActivity) {
        this.f = (RadioGroup) frsGroupActivity.findViewById(R.id.raidos_change);
        this.g = (RadioButton) frsGroupActivity.findViewById(R.id.radio_recommend);
        this.h = (RadioButton) frsGroupActivity.findViewById(R.id.radio_hot);
        this.i = (RadioButton) frsGroupActivity.findViewById(R.id.radio_official);
        this.l = (ProgressBar) frsGroupActivity.findViewById(R.id.progress_loading);
        this.j = new Fragment[3];
        this.k = new String[3];
        this.k[0] = "f1";
        this.k[1] = "f2";
        this.k[2] = "f3";
    }

    public String[] a() {
        return this.k;
    }

    public void a(int i) {
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

    public void e() {
        this.f.setOnCheckedChangeListener(this.f1564a);
    }

    public void f() {
        for (int i = 0; i < 3; i++) {
            this.j[i] = new FrsGroupListFragment();
        }
    }

    public void b(int i) {
        this.f1564a.a().a(i == 1);
        this.f1564a.a().a(this.c);
        if (i == 1) {
            this.c.setBackgroundColor(this.f1564a.getResources().getColor(R.color.frsgruop_container_bg_1));
            bb.e(this.f, (int) R.drawable.bg_pop_most_1);
            this.i.setBackgroundResource(R.drawable.radio_commen_bg_right_1);
            this.g.setBackgroundResource(R.drawable.radio_commen_bg_left_1);
            if (this.m) {
                this.h.setBackgroundResource(R.drawable.radio_commen_bg_middle_1);
                return;
            } else {
                this.h.setBackgroundResource(R.drawable.radio_commen_bg_left_1);
                return;
            }
        }
        this.c.setBackgroundColor(this.f1564a.getResources().getColor(R.color.frsgroup_container_bg));
        bb.e(this.f, (int) R.drawable.bg_pop_most);
        this.i.setBackgroundResource(R.drawable.radio_commen_bg_right);
        this.g.setBackgroundResource(R.drawable.radio_commen_bg_left);
        if (this.m) {
            this.h.setBackgroundResource(R.drawable.radio_commen_bg_middle);
        } else {
            this.h.setBackgroundResource(R.drawable.radio_commen_bg_left);
        }
    }

    @Override // com.baidu.adp.a.e
    public void c() {
        super.c();
        if (this.j != null) {
            android.support.v4.app.ae a2 = this.f1564a.getSupportFragmentManager().a();
            for (int i = 0; i < this.j.length; i++) {
                a2.a(this.j[i]);
            }
            a2.b();
        }
    }

    public Fragment[] g() {
        return this.j;
    }

    public void a(boolean z) {
        this.m = z;
        if (z) {
            this.f.check(R.id.radio_recommend);
            return;
        }
        this.f.check(R.id.radio_hot);
        this.h.setBackgroundResource(R.drawable.radio_commen_bg_left);
    }

    public void b(boolean z) {
        this.e.setEnabled(z);
    }

    public void c(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
    }

    public ImageView h() {
        return this.d;
    }

    public void d(boolean z) {
        this.l.setVisibility(z ? 0 : 8);
    }

    public Button i() {
        return this.e;
    }

    public void j() {
        if (TiebaApplication.g().as() != 1) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(R.id.btn_create).a(150).a(true);
            j jVar = new j(this);
            gVar.a(jVar).a(new k(this));
            gVar.a().a(this.f1564a);
        }
    }
}
