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
import com.baidu.tieba.util.aa;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoSwipeableViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    CreateGroupStepActivity f1628a;
    CreateGroupStepAdapter c;
    ProgressBar d;
    int e;
    int f;
    String g;
    e h;
    c i;
    f j;
    b k;
    private boolean l;
    private boolean m;
    private int n;
    private NavigationBar o;
    private View p;
    private ImageView q;
    private TextView r;
    private AlertDialog s;
    private NoSwipeableViewPager t;
    private aa u;
    private boolean v;
    private String w;
    private String x;
    private String y;
    private String z;

    public void a(String str) {
        this.y = str;
    }

    public void b(String str) {
        this.z = str;
    }

    public String a() {
        return this.y;
    }

    public String e() {
        return this.z;
    }

    public View f() {
        return this.q;
    }

    public int g() {
        return this.n;
    }

    public View h() {
        return this.r;
    }

    public View i() {
        return this.j.g();
    }

    public View j() {
        return this.j.f();
    }

    public boolean k() {
        return this.m;
    }

    public void l() {
        this.k.g();
        L();
    }

    public void c(String str) {
        this.w = str;
    }

    public String m() {
        return this.w;
    }

    public void d(String str) {
        this.x = str;
        this.k.a(str);
        L();
    }

    public String n() {
        return this.x;
    }

    public void e(String str) {
        this.k.b(str);
        L();
    }

    public boolean o() {
        return this.v;
    }

    public void a(boolean z) {
        this.v = z;
    }

    public void p() {
        this.k.h();
        L();
    }

    public void q() {
        this.k.i();
        L();
    }

    public View r() {
        return this.k.e();
    }

    public int s() {
        return this.k.f();
    }

    public View t() {
        return this.h.f();
    }

    public boolean u() {
        EditText e = this.h.e();
        return com.baidu.tieba.im.e.g.b(e) || e.length() >= 3;
    }

    public int v() {
        return this.f;
    }

    public String w() {
        return this.h.e().getText().toString();
    }

    public String x() {
        return this.i.e().getText().toString();
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

    public void A() {
        this.j.g().setText(R.string.group_create_modify_photo_tip);
    }

    public void B() {
        this.j.e();
    }

    public void C() {
        this.h.g();
    }

    public l(CreateGroupStepActivity createGroupStepActivity) {
        super(createGroupStepActivity);
        this.l = true;
        this.m = false;
        this.f1628a = null;
        this.c = null;
        this.d = null;
        this.n = 1;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.e = 4;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.t = null;
        this.u = null;
        this.v = false;
        this.w = "";
        this.x = "";
        this.y = null;
        this.z = null;
        a(createGroupStepActivity);
        M();
        N();
    }

    private void M() {
        this.u = new aa(this.f1628a);
        D();
    }

    public void D() {
        this.u.a();
    }

    public void E() {
        if (this.u != null) {
            this.u.b();
        }
    }

    private void N() {
        this.q.setOnClickListener(this.f1628a);
        this.r.setOnClickListener(this.f1628a);
        this.h.e().setFilters(new InputFilter[]{new com.baidu.tieba.im.e.a(20)});
        this.h.e().addTextChangedListener(this.f1628a);
        this.i.e().addTextChangedListener(this.f1628a);
        this.j.g().setOnClickListener(this.f1628a);
        this.j.f().setOnClickListener(this.f1628a);
        this.k.e().setOnClickListener(this.f1628a);
    }

    public void b(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
        this.m = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity) {
        this.f1628a = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.p = createGroupStepActivity.findViewById(R.id.parent);
        this.d = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.t = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.c = new CreateGroupStepAdapter(this.f1628a);
        CreateGroupStepAdapter createGroupStepAdapter = this.c;
        e eVar = new e(this.f1628a);
        this.h = eVar;
        createGroupStepAdapter.a(eVar);
        CreateGroupStepAdapter createGroupStepAdapter2 = this.c;
        c cVar = new c(this.f1628a);
        this.i = cVar;
        createGroupStepAdapter2.a(cVar);
        CreateGroupStepAdapter createGroupStepAdapter3 = this.c;
        f fVar = new f(this.f1628a);
        this.j = fVar;
        createGroupStepAdapter3.a(fVar);
        CreateGroupStepAdapter createGroupStepAdapter4 = this.c;
        b bVar = new b(this.f1628a);
        this.k = bVar;
        createGroupStepAdapter4.a(bVar);
        this.t.setAdapter(this.c);
        this.o = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        P();
        this.o.setSystemClickable(false);
        this.q = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.r = this.o.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.group_create_step_tip));
        c(false);
        K();
    }

    private void c(boolean z) {
        this.l = z;
        O();
    }

    public boolean F() {
        return this.l;
    }

    private void O() {
        if (TiebaApplication.h().an() == 1) {
            if (this.l) {
                ba.e((View) this.r, (int) R.drawable.navi_done_text_bg_1);
                this.r.setTextColor(this.f1628a.getResources().getColorStateList(R.color.navi_done_text_1));
                return;
            }
            ba.e((View) this.r, (int) R.drawable.btn_titlebar_finish_d_1);
            this.r.setTextColor(this.f1628a.getResources().getColor(R.color.navi_done_text_d_1));
        } else if (this.l) {
            ba.e((View) this.r, (int) R.drawable.navi_done_text_bg);
            this.r.setTextColor(this.f1628a.getResources().getColorStateList(R.color.navi_done_text));
        } else {
            ba.e((View) this.r, (int) R.drawable.btn_titlebar_finish_d);
            this.r.setTextColor(this.f1628a.getResources().getColor(R.color.navi_done_text_d));
        }
    }

    public void G() {
        if (this.n > 1) {
            this.n--;
            I();
        }
    }

    public void H() {
        if (this.n < 4) {
            this.n++;
            I();
        }
    }

    public void I() {
        this.t.setCurrentItem(this.n - 1);
        P();
        K();
        L();
        this.h.e().clearFocus();
        this.i.e().clearFocus();
        a(this.h.e());
        a(this.i.e());
        if (this.n == 3 && k()) {
            h().setEnabled(false);
        } else {
            h().setEnabled(true);
        }
    }

    public void J() {
        String[] strArr = {this.f1628a.getResources().getString(R.string.take_photo), this.f1628a.getResources().getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1628a);
        builder.setTitle(this.f1628a.getResources().getString(R.string.operation));
        builder.setItems(strArr, new m(this));
        if (this.s == null) {
            this.s = builder.create();
        }
        this.s.show();
    }

    public void a(int i) {
        if (!this.r.getText().toString().equals(this.b.getString(i))) {
            this.r.setText(i);
        }
    }

    private void P() {
        this.o.a(this.f1628a.getResources().getString(this.c.a(this.n - 1).d()));
    }

    public void K() {
        for (v vVar : this.c.a()) {
            if (vVar.b() == this.n) {
                vVar.k();
                a(vVar.c());
            } else {
                vVar.j();
            }
        }
        if (this.n == 3 || this.n == 4) {
            c(true);
        }
    }

    public void L() {
        if (this.n == 1) {
            a(this.h.e().getText().length(), this.h.h(), 2, 20);
        } else if (this.n == 2) {
            int length = this.i.e().getText().length();
            a(length, 15, 300);
            int i = 300 - length;
            this.i.f().setText(String.valueOf(i));
            if (i <= 50) {
                this.i.f().setVisibility(0);
            } else {
                this.i.f().setVisibility(8);
            }
            if (i == 0) {
                this.i.f().setTextColor(this.f1628a.getResources().getColor(R.color.group_create_info_count_color));
            } else {
                this.i.g();
            }
        } else if (this.n == 4) {
            if (this.k.f() != 3) {
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
            this.h.a(false);
        } else {
            this.h.a(true);
        }
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public void b(int i) {
        this.f1628a.getLayoutMode().a(i == 1);
        this.f1628a.getLayoutMode().a(this.p);
        ba.a(this.p, i);
        this.o.c(i);
        O();
    }

    public void a(EditText editText) {
        ((InputMethodManager) this.f1628a.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
