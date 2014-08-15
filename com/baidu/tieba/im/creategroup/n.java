package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.view.NoSwipeableViewPager;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f {
    private int A;
    private boolean B;
    private String C;
    private String D;
    private String E;
    private String F;
    private int G;
    CreateGroupStepActivity a;
    m b;
    ProgressBar c;
    int d;
    int e;
    String f;
    d g;
    g h;
    f i;
    c j;
    h k;
    b l;
    private boolean m;
    private boolean n;
    private int o;
    private NavigationBar p;
    private View q;
    private View r;
    private TextView s;
    private AlertDialog t;
    private NoSwipeableViewPager u;
    private com.baidu.tieba.im.d.e v;
    private int w;
    private int x;
    private int y;
    private int z;

    public void a(String str) {
        this.E = str;
    }

    public void b(String str) {
        this.F = str;
    }

    public String a() {
        return this.E;
    }

    public String b() {
        return this.F;
    }

    public View c() {
        return this.r;
    }

    public int d() {
        return this.o;
    }

    public View e() {
        return this.s;
    }

    public View f() {
        if (this.g != null) {
            return this.g.c();
        }
        if (this.h != null) {
            return this.h.c();
        }
        return null;
    }

    public View g() {
        return this.k.e();
    }

    public View h() {
        return this.k.d();
    }

    public boolean i() {
        return this.n;
    }

    public void j() {
        this.l.e();
        O();
    }

    public void c(String str) {
        this.C = str;
    }

    public String k() {
        return this.C;
    }

    public void d(String str) {
        this.D = str;
        this.l.a(str);
        O();
    }

    public String l() {
        return this.D;
    }

    public void e(String str) {
        this.l.b(str);
        O();
    }

    public boolean m() {
        return this.B;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public void n() {
        this.l.f();
        O();
    }

    public void o() {
        this.l.g();
        O();
    }

    public View p() {
        return this.l.c();
    }

    public int q() {
        return this.l.d();
    }

    public View r() {
        return this.i.d();
    }

    public int s() {
        return this.e;
    }

    public String t() {
        return this.i.c().getText().toString();
    }

    public String u() {
        return this.j.c().getText().toString();
    }

    public void f(String str) {
        this.f = str;
    }

    public String v() {
        return this.f;
    }

    public int w() {
        return this.d;
    }

    public boolean x() {
        return this.i != null && this.o == this.i.b();
    }

    public boolean y() {
        return this.j != null && this.o == this.j.b();
    }

    public boolean z() {
        return this.k != null && this.o == this.k.b();
    }

    public boolean A() {
        return this.l != null && this.o == this.l.b();
    }

    public boolean B() {
        return this.b != null && this.o == this.b.getCount();
    }

    public String C() {
        if (this.b.a(this.o - 1) != null) {
            return this.b.a(this.o - 1).m();
        }
        return null;
    }

    public void D() {
        this.k.e().setText(com.baidu.tieba.x.group_create_modify_photo_tip);
    }

    public void E() {
        this.k.c();
    }

    public void F() {
        this.i.e();
    }

    public n(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity);
        this.m = true;
        this.n = false;
        this.a = null;
        this.b = null;
        this.c = null;
        this.o = 1;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.d = 4;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.u = null;
        this.v = null;
        this.B = false;
        this.C = "";
        this.D = "";
        this.E = null;
        this.F = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        P();
        Q();
    }

    private void P() {
        this.v = new com.baidu.tieba.im.d.e(this.a);
        this.v.a(this.a.getUniqueId());
        G();
    }

    public void G() {
        this.v.a();
    }

    public void H() {
        if (this.v != null) {
            this.v.b();
        }
    }

    private void Q() {
        this.r.setOnClickListener(this.a);
        this.s.setOnClickListener(this.a);
        this.i.c().setFilters(new InputFilter[]{new com.baidu.tieba.im.d.a(20)});
        this.i.c().addTextChangedListener(this.a);
        this.j.c().addTextChangedListener(this.a);
        this.k.e().setOnClickListener(this.a);
        this.k.d().setOnClickListener(this.a);
        this.l.c().setOnClickListener(this.a);
        if (this.h != null) {
            this.h.c().setOnClickListener(this.a);
        }
        if (this.g != null) {
            this.g.c().setOnClickListener(this.a);
        }
    }

    public void b(boolean z) {
        this.c.setVisibility(z ? 0 : 8);
        this.n = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.a = createGroupStepActivity;
        createGroupStepActivity.setContentView(com.baidu.tieba.v.create_group_step_activity);
        this.q = createGroupStepActivity.findViewById(com.baidu.tieba.u.parent);
        this.c = (ProgressBar) createGroupStepActivity.findViewById(com.baidu.tieba.u.progress);
        this.u = (NoSwipeableViewPager) createGroupStepActivity.findViewById(com.baidu.tieba.u.pagercontent);
        this.b = new m(this.a);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.u.setAdapter(this.b);
        this.p = (NavigationBar) createGroupStepActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.p.setSystemClickable(false);
        this.r = this.p.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        S();
        this.s = this.p.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(com.baidu.tieba.x.group_create_step_tip));
        c(false);
        N();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.A = 1;
            this.z = 2;
            this.w = 3;
            this.x = 4;
            this.y = 5;
            this.g = new d(createGroupStepActivity, this.A, i2);
            this.l = new b(createGroupStepActivity, this.z, 1, 5);
            this.i = new f(createGroupStepActivity, this.w, 2, 5);
            this.j = new c(createGroupStepActivity, this.x, 3, 5);
            this.k = new h(createGroupStepActivity, this.y, 4, 5);
            this.b.a(this.g);
            this.b.a(this.l);
            this.b.a(this.i);
            this.b.a(this.j);
            this.b.a(this.k);
            this.G = 5;
        } else if (i == 2) {
            this.A = 1;
            this.w = 2;
            this.x = 3;
            this.y = 4;
            this.z = 5;
            this.h = new g(createGroupStepActivity, this.A, i3);
            this.i = new f(createGroupStepActivity, this.w, 1, 5);
            this.j = new c(createGroupStepActivity, this.x, 2, 5);
            this.k = new h(createGroupStepActivity, this.y, 3, 5);
            this.l = new b(createGroupStepActivity, this.z, 4, 5);
            this.b.a(this.h);
            this.b.a(this.i);
            this.b.a(this.j);
            this.b.a(this.k);
            this.b.a(this.l);
            this.G = 5;
        } else {
            this.w = 1;
            this.x = 2;
            this.y = 3;
            this.z = 4;
            this.i = new f(createGroupStepActivity, this.w, 1, 4);
            this.j = new c(createGroupStepActivity, this.x, 2, 4);
            this.k = new h(createGroupStepActivity, this.y, 3, 4);
            this.l = new b(createGroupStepActivity, this.z, 4, 4);
            this.b.a(this.i);
            this.b.a(this.j);
            this.b.a(this.k);
            this.b.a(this.l);
            this.G = 4;
        }
    }

    private void c(boolean z) {
        this.m = z;
        R();
    }

    public boolean I() {
        return this.m;
    }

    private void R() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            if (this.m) {
                ay.e((View) this.s, com.baidu.tieba.t.navi_done_text_bg_1);
                this.s.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.r.navi_done_text_1));
                return;
            }
            ay.e((View) this.s, com.baidu.tieba.t.btn_titlebar_finish_d_1);
            this.s.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.navi_done_text_d_1));
        } else if (this.m) {
            ay.e((View) this.s, com.baidu.tieba.t.navi_done_text_bg);
            this.s.setTextColor(this.a.getResources().getColorStateList(com.baidu.tieba.r.navi_done_text));
        } else {
            ay.e((View) this.s, com.baidu.tieba.t.btn_titlebar_finish_d);
            this.s.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.navi_done_text_d));
        }
    }

    public void J() {
        if (this.o > 1) {
            this.o--;
            L();
        }
    }

    public void K() {
        if (this.o < this.G) {
            this.o++;
            L();
        }
    }

    public void L() {
        this.u.setCurrentItem(this.o - 1);
        S();
        N();
        O();
        this.i.c().clearFocus();
        this.j.c().clearFocus();
        a(this.i.c());
        a(this.j.c());
        if (z() && i()) {
            e().setEnabled(false);
        } else {
            e().setEnabled(true);
        }
    }

    public void M() {
        String[] strArr = {this.a.getResources().getString(com.baidu.tieba.x.take_photo), this.a.getResources().getString(com.baidu.tieba.x.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getResources().getString(com.baidu.tieba.x.operation));
        builder.setItems(strArr, new o(this));
        if (this.t == null) {
            this.t = builder.create();
        }
        com.baidu.adp.lib.e.d.a(this.t, this.a);
    }

    public void g(String str) {
        if (!this.s.getText().toString().equals(str)) {
            this.s.setText(str);
        }
    }

    private void S() {
        if (this.b.a(this.o - 1) != null) {
            this.p.a(this.b.a(this.o - 1).j());
        }
    }

    public void N() {
        for (x xVar : this.b.a()) {
            if (xVar.b() == this.o) {
                xVar.i();
                if (!xVar.n()) {
                    this.s.setVisibility(8);
                } else {
                    this.s.setVisibility(0);
                }
                g(xVar.k());
            } else {
                xVar.h();
            }
        }
        if (this.b.a(this.o - 1) != null && this.b.a(this.o - 1).l()) {
            c(true);
        }
    }

    public void O() {
        if (x()) {
            a(this.i.c().getText().length(), this.i.f(), 2, 20);
        } else if (y()) {
            int e = this.j.e();
            a(e, 15, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
            int i = 300 - e;
            this.j.d().setText(String.valueOf(i));
            if (i <= 50) {
                this.j.d().setVisibility(0);
            } else {
                this.j.d().setVisibility(8);
            }
            if (i == 0) {
                this.j.d().setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.group_create_info_count_color));
            } else if (i < 0) {
                this.j.a(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
            } else {
                this.j.f();
            }
        } else if (A()) {
            if (this.l.d() != 3) {
                c(true);
            } else {
                c(false);
            }
        }
    }

    private void a(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            c(true);
        } else {
            c(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            c(false);
        } else if (f >= i2 && f <= i3) {
            c(true);
        } else {
            c(false);
        }
        if (i < 1) {
            this.i.a(false);
        } else {
            this.i.a(true);
        }
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.q);
        ay.a(this.q, i);
        this.p.c(i);
        R();
    }

    public void a(EditText editText) {
        ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
