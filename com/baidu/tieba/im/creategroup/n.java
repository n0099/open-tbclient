package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ag;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoSwipeableViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.e {
    private int A;
    private int B;
    private boolean C;
    private String D;
    private String E;
    private String F;
    private String G;
    private int H;
    CreateGroupStepActivity a;
    CreateGroupStepAdapter c;
    ProgressBar d;
    int e;
    int f;
    String g;
    d h;
    g i;
    f j;
    c k;
    h l;
    b m;
    private boolean n;
    private boolean o;
    private int p;
    private NavigationBar q;
    private View r;
    private ImageView s;
    private TextView t;
    private AlertDialog u;
    private NoSwipeableViewPager v;
    private ag w;
    private int x;
    private int y;
    private int z;

    public void a(String str) {
        this.F = str;
    }

    public void b(String str) {
        this.G = str;
    }

    public String a() {
        return this.F;
    }

    public String e() {
        return this.G;
    }

    public View f() {
        return this.s;
    }

    public int g() {
        return this.p;
    }

    public View h() {
        return this.t;
    }

    public View i() {
        if (this.h != null) {
            return this.h.c();
        }
        if (this.i != null) {
            return this.i.c();
        }
        return null;
    }

    public View j() {
        return this.l.e();
    }

    public View k() {
        return this.l.d();
    }

    public boolean l() {
        return this.o;
    }

    public void m() {
        this.m.e();
        R();
    }

    public void c(String str) {
        this.D = str;
    }

    public String n() {
        return this.D;
    }

    public void d(String str) {
        this.E = str;
        this.m.a(str);
        R();
    }

    public String o() {
        return this.E;
    }

    public void e(String str) {
        this.m.b(str);
        R();
    }

    public boolean p() {
        return this.C;
    }

    public void a(boolean z) {
        this.C = z;
    }

    public void q() {
        this.m.f();
        R();
    }

    public void r() {
        this.m.g();
        R();
    }

    public View s() {
        return this.m.c();
    }

    public int t() {
        return this.m.d();
    }

    public View u() {
        return this.j.d();
    }

    public int v() {
        return this.f;
    }

    public String w() {
        return this.j.c().getText().toString();
    }

    public String x() {
        return this.k.c().getText().toString();
    }

    public void f(String str) {
        this.g = str;
    }

    public String y() {
        return this.g;
    }

    public int z() {
        return this.e;
    }

    public boolean A() {
        return this.j != null && this.p == this.j.b();
    }

    public boolean B() {
        return this.k != null && this.p == this.k.b();
    }

    public boolean C() {
        return this.l != null && this.p == this.l.b();
    }

    public boolean D() {
        return this.m != null && this.p == this.m.b();
    }

    public boolean E() {
        return this.c != null && this.p == this.c.getCount();
    }

    public String F() {
        if (this.c.a(this.p - 1) != null) {
            return this.c.a(this.p - 1).m();
        }
        return null;
    }

    public void G() {
        this.l.e().setText(R.string.group_create_modify_photo_tip);
    }

    public void H() {
        this.l.c();
    }

    public void I() {
        this.j.e();
    }

    public n(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        super(createGroupStepActivity);
        this.n = true;
        this.o = false;
        this.a = null;
        this.c = null;
        this.d = null;
        this.p = 1;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.e = 4;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.v = null;
        this.w = null;
        this.C = false;
        this.D = "";
        this.E = "";
        this.F = null;
        this.G = null;
        a(createGroupStepActivity, i, i2, i3, i4);
        S();
        T();
    }

    private void S() {
        this.w = new ag(this.a);
        J();
    }

    public void J() {
        this.w.a();
    }

    public void K() {
        if (this.w != null) {
            this.w.b();
        }
    }

    private void T() {
        this.s.setOnClickListener(this.a);
        this.t.setOnClickListener(this.a);
        this.j.c().setFilters(new InputFilter[]{new com.baidu.tieba.im.d.a(20)});
        this.j.c().addTextChangedListener(this.a);
        this.k.c().addTextChangedListener(this.a);
        this.l.e().setOnClickListener(this.a);
        this.l.d().setOnClickListener(this.a);
        this.m.c().setOnClickListener(this.a);
        if (this.i != null) {
            this.i.c().setOnClickListener(this.a);
        }
        if (this.h != null) {
            this.h.c().setOnClickListener(this.a);
        }
    }

    public void b(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
        this.o = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        this.a = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.r = createGroupStepActivity.findViewById(R.id.parent);
        this.d = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.v = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.c = new CreateGroupStepAdapter(this.a);
        b(createGroupStepActivity, i, i2, i3, i4);
        this.v.setAdapter(this.c);
        this.q = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        V();
        this.q.setSystemClickable(false);
        this.s = this.q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.t = this.q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.group_create_step_tip));
        c(false);
        Q();
    }

    private void b(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3, int i4) {
        if (i == 1) {
            this.B = 1;
            this.A = 2;
            this.x = 3;
            this.y = 4;
            this.z = 5;
            this.h = new d(createGroupStepActivity, this.B, i2);
            this.m = new b(createGroupStepActivity, this.A, 1, 5);
            this.j = new f(createGroupStepActivity, this.x, 2, 5);
            this.k = new c(createGroupStepActivity, this.y, 3, 5);
            this.l = new h(createGroupStepActivity, this.z, 4, 5);
            this.c.a(this.h);
            this.c.a(this.m);
            this.c.a(this.j);
            this.c.a(this.k);
            this.c.a(this.l);
            this.H = 5;
        } else if (i == 2) {
            this.B = 1;
            this.x = 2;
            this.y = 3;
            this.z = 4;
            this.A = 5;
            this.i = new g(createGroupStepActivity, this.B, i3);
            this.j = new f(createGroupStepActivity, this.x, 1, 5);
            this.k = new c(createGroupStepActivity, this.y, 2, 5);
            this.l = new h(createGroupStepActivity, this.z, 3, 5);
            this.m = new b(createGroupStepActivity, this.A, 4, 5);
            this.c.a(this.i);
            this.c.a(this.j);
            this.c.a(this.k);
            this.c.a(this.l);
            this.c.a(this.m);
            this.H = 5;
        } else {
            this.x = 1;
            this.y = 2;
            this.z = 3;
            this.A = 4;
            this.j = new f(createGroupStepActivity, this.x, 1, 4);
            this.k = new c(createGroupStepActivity, this.y, 2, 4);
            this.l = new h(createGroupStepActivity, this.z, 3, 4);
            this.m = new b(createGroupStepActivity, this.A, 4, 4);
            this.c.a(this.j);
            this.c.a(this.k);
            this.c.a(this.l);
            this.c.a(this.m);
            this.H = 4;
        }
    }

    private void c(boolean z) {
        this.n = z;
        U();
    }

    public boolean L() {
        return this.n;
    }

    private void U() {
        if (TiebaApplication.h().al() == 1) {
            if (this.n) {
                bs.e((View) this.t, (int) R.drawable.navi_done_text_bg_1);
                this.t.setTextColor(this.a.getResources().getColorStateList(R.color.navi_done_text_1));
                return;
            }
            bs.e((View) this.t, (int) R.drawable.btn_titlebar_finish_d_1);
            this.t.setTextColor(this.a.getResources().getColor(R.color.navi_done_text_d_1));
        } else if (this.n) {
            bs.e((View) this.t, (int) R.drawable.navi_done_text_bg);
            this.t.setTextColor(this.a.getResources().getColorStateList(R.color.navi_done_text));
        } else {
            bs.e((View) this.t, (int) R.drawable.btn_titlebar_finish_d);
            this.t.setTextColor(this.a.getResources().getColor(R.color.navi_done_text_d));
        }
    }

    public void M() {
        if (this.p > 1) {
            this.p--;
            O();
        }
    }

    public void N() {
        if (this.p < this.H) {
            this.p++;
            O();
        }
    }

    public void O() {
        this.v.setCurrentItem(this.p - 1);
        V();
        Q();
        R();
        this.j.c().clearFocus();
        this.k.c().clearFocus();
        a(this.j.c());
        a(this.k.c());
        if (C() && l()) {
            h().setEnabled(false);
        } else {
            h().setEnabled(true);
        }
    }

    public void P() {
        String[] strArr = {this.a.getResources().getString(R.string.take_photo), this.a.getResources().getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getResources().getString(R.string.operation));
        builder.setItems(strArr, new o(this));
        if (this.u == null) {
            this.u = builder.create();
        }
        this.u.show();
    }

    public void g(String str) {
        if (!this.t.getText().toString().equals(str)) {
            this.t.setText(str);
        }
    }

    private void V() {
        if (this.c.a(this.p - 1) != null) {
            this.q.a(this.c.a(this.p - 1).j());
        }
    }

    public void Q() {
        for (x xVar : this.c.a()) {
            if (xVar.b() == this.p) {
                xVar.i();
                if (!xVar.n()) {
                    this.t.setVisibility(8);
                } else {
                    this.t.setVisibility(0);
                }
                g(xVar.k());
            } else {
                xVar.h();
            }
        }
        if (this.c.a(this.p - 1) != null && this.c.a(this.p - 1).l()) {
            c(true);
        }
    }

    public void R() {
        if (A()) {
            a(this.j.c().getText().length(), this.j.f(), 2, 20);
        } else if (B()) {
            int length = this.k.c().getText().length();
            a(length, 15, 300);
            int i = 300 - length;
            this.k.d().setText(String.valueOf(i));
            if (i <= 50) {
                this.k.d().setVisibility(0);
            } else {
                this.k.d().setVisibility(8);
            }
            if (i == 0) {
                this.k.d().setTextColor(this.a.getResources().getColor(R.color.group_create_info_count_color));
            } else {
                this.k.e();
            }
        } else if (D()) {
            if (this.m.d() != 3) {
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
            this.j.a(false);
        } else {
            this.j.a(true);
        }
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.r);
        bs.a(this.r, i);
        this.q.c(i);
        U();
    }

    public void a(EditText editText) {
        ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
