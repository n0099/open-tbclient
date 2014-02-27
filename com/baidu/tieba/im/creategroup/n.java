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
import com.baidu.tieba.util.ai;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoSwipeableViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class n extends com.baidu.adp.a.e {
    private int A;
    private int B;
    private boolean C;
    private String D;
    private String E;
    private String F;
    private String G;
    private int H;
    CreateGroupStepActivity a;
    m c;
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
    private ai w;
    private int x;
    private int y;
    private int z;

    public final void a(String str) {
        this.F = str;
    }

    public final void b(String str) {
        this.G = str;
    }

    public final String a() {
        return this.F;
    }

    public final String d() {
        return this.G;
    }

    public final View e() {
        return this.s;
    }

    public final int f() {
        return this.p;
    }

    public final View g() {
        return this.t;
    }

    public final boolean h() {
        return this.o;
    }

    public final void i() {
        this.m.d();
        u();
    }

    public final void c(String str) {
        this.D = str;
    }

    public final String j() {
        return this.D;
    }

    public final void d(String str) {
        this.E = str;
        this.m.a(str);
        u();
    }

    public final String k() {
        return this.E;
    }

    public final boolean l() {
        return this.C;
    }

    public final void a(boolean z) {
        this.C = z;
    }

    public final boolean m() {
        return this.c != null && this.p == this.c.getCount();
    }

    public final String n() {
        if (this.c.a(this.p - 1) != null) {
            return this.c.a(this.p - 1).l();
        }
        return null;
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
        this.a = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.r = createGroupStepActivity.findViewById(R.id.parent);
        this.d = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.v = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.c = new m(this.a);
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
        this.v.setAdapter(this.c);
        this.q = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        x();
        this.q.setSystemClickable(false);
        this.s = this.q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.t = this.q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.group_create_step_tip));
        c(false);
        y();
        this.w = new ai(this.a);
        this.w.a();
        this.s.setOnClickListener(this.a);
        this.t.setOnClickListener(this.a);
        this.j.d.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
        this.j.d.addTextChangedListener(this.a);
        this.k.d.addTextChangedListener(this.a);
        this.l.e.setOnClickListener(this.a);
        this.l.d.setOnClickListener(this.a);
        this.m.d.setOnClickListener(this.a);
        if (this.i != null) {
            this.i.c().setOnClickListener(this.a);
        }
        if (this.h != null) {
            this.h.c().setOnClickListener(this.a);
        }
    }

    public final void o() {
        this.w.a();
    }

    public final void p() {
        if (this.w != null) {
            this.w.b();
        }
    }

    public final void b(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
        this.o = z;
    }

    private void c(boolean z) {
        this.n = z;
        v();
    }

    public final boolean q() {
        return this.n;
    }

    private void v() {
        if (TiebaApplication.g().ae() == 1) {
            if (this.n) {
                bq.e((View) this.t, (int) R.drawable.navi_done_text_bg_1);
                this.t.setTextColor(this.a.getResources().getColorStateList(R.color.navi_done_text_1));
                return;
            }
            bq.e((View) this.t, (int) R.drawable.btn_titlebar_finish_d_1);
            this.t.setTextColor(this.a.getResources().getColor(R.color.navi_done_text_d_1));
        } else if (this.n) {
            bq.e((View) this.t, (int) R.drawable.navi_done_text_bg);
            this.t.setTextColor(this.a.getResources().getColorStateList(R.color.navi_done_text));
        } else {
            bq.e((View) this.t, (int) R.drawable.btn_titlebar_finish_d);
            this.t.setTextColor(this.a.getResources().getColor(R.color.navi_done_text_d));
        }
    }

    public final void r() {
        if (this.p > 1) {
            this.p--;
            w();
        }
    }

    public final void s() {
        if (this.p < this.H) {
            this.p++;
            w();
        }
    }

    private void w() {
        this.v.setCurrentItem(this.p - 1);
        x();
        y();
        u();
        this.j.d.clearFocus();
        this.k.d.clearFocus();
        a(this.j.d);
        a(this.k.d);
        if ((this.l != null ? this.p == this.l.b() : false) && this.o) {
            this.t.setEnabled(false);
        } else {
            this.t.setEnabled(true);
        }
    }

    public final void t() {
        String[] strArr = {this.a.getResources().getString(R.string.take_photo), this.a.getResources().getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getResources().getString(R.string.operation));
        builder.setItems(strArr, new o(this));
        if (this.u == null) {
            this.u = builder.create();
        }
        this.u.show();
    }

    private void x() {
        if (this.c.a(this.p - 1) != null) {
            this.q.a(this.c.a(this.p - 1).i());
        }
    }

    private void y() {
        for (x xVar : this.c.a()) {
            if (xVar.b() == this.p) {
                xVar.h();
                if (!xVar.m()) {
                    this.t.setVisibility(8);
                } else {
                    this.t.setVisibility(0);
                }
                String j = xVar.j();
                if (!this.t.getText().toString().equals(j)) {
                    this.t.setText(j);
                }
            } else {
                xVar.g();
            }
        }
        if (this.c.a(this.p - 1) != null && this.c.a(this.p - 1).k()) {
            c(true);
        }
    }

    public final void u() {
        if (this.j != null ? this.p == this.j.b() : false) {
            float a = com.baidu.tieba.im.util.o.a(this.j.d);
            int length = this.j.d.getText().length();
            if (length == 1 || a < 2.0f || a > 20.0f) {
                c(false);
            } else {
                c(true);
            }
            if (length <= 0) {
                this.j.a(false);
                return;
            } else {
                this.j.a(true);
                return;
            }
        }
        if (this.k != null ? this.p == this.k.b() : false) {
            int length2 = this.k.d.getText().length();
            if (length2 < 15 || length2 > 300) {
                c(false);
            } else {
                c(true);
            }
            int i = 300 - length2;
            this.k.e.setText(String.valueOf(i));
            if (i <= 50) {
                this.k.e.setVisibility(0);
            } else {
                this.k.e.setVisibility(8);
            }
            if (i == 0) {
                this.k.e.setTextColor(this.a.getResources().getColor(R.color.group_create_info_count_color));
                return;
            }
            c cVar = this.k;
            cVar.a.getLayoutMode().a(TiebaApplication.g().ae() == 1);
            cVar.a.getLayoutMode().a(cVar.e);
            return;
        }
        if (this.m != null ? this.p == this.m.b() : false) {
            if (this.m.c() != 3) {
                c(true);
            } else {
                c(false);
            }
        }
    }

    public final void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.r);
        bq.a(this.r, i);
        this.q.b(i);
        v();
    }

    private void a(EditText editText) {
        ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
