package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupAddressData;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoSwipeableViewPager;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    CreateGroupStepActivity f1498a;
    CreateGroupStepAdapter c;
    ProgressBar d;
    int e;
    int f;
    String g;
    GroupAddressData h;
    c i;
    a j;
    d k;
    com.baidu.adp.lib.c.d l;
    private boolean m;
    private boolean n;
    private int o;
    private NavigationBar p;
    private View q;
    private ImageView r;
    private Button s;
    private AlertDialog t;
    private NoSwipeableViewPager u;

    public View a() {
        return this.r;
    }

    public int e() {
        return this.o;
    }

    public View f() {
        return this.s;
    }

    public View g() {
        return this.k.h();
    }

    public View h() {
        return this.k.e();
    }

    public boolean i() {
        return this.n;
    }

    public boolean j() {
        EditText d = this.i.d();
        return com.baidu.tieba.im.d.f.b(d) || d.length() >= 3;
    }

    public int k() {
        return this.f;
    }

    public String l() {
        return this.i.d().getText().toString();
    }

    public String m() {
        return this.j.d().getText().toString();
    }

    public void a(String str) {
        this.g = str;
    }

    public String n() {
        return this.g;
    }

    public GroupAddressData o() {
        return this.h;
    }

    public int p() {
        return this.e;
    }

    public void q() {
        this.k.h().setText(R.string.group_create_modify_photo_tip);
    }

    public void r() {
        this.k.d();
    }

    public j(CreateGroupStepActivity createGroupStepActivity) {
        super(createGroupStepActivity);
        this.m = true;
        this.n = false;
        this.f1498a = null;
        this.c = null;
        this.d = null;
        this.o = 1;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.e = 4;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.u = null;
        this.l = new k(this);
        a(createGroupStepActivity);
        z();
        A();
    }

    private void z() {
        this.h = new GroupAddressData();
        com.baidu.adp.lib.c.a.a().a(true, this.l);
    }

    private void A() {
        this.r.setOnClickListener(this.f1498a);
        this.s.setOnClickListener(this.f1498a);
        this.i.d().addTextChangedListener(this.f1498a);
        this.j.d().addTextChangedListener(this.f1498a);
        this.k.h().setOnClickListener(this.f1498a);
        this.k.e().setOnClickListener(this.f1498a);
    }

    public void a(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
        this.n = z;
    }

    private void a(CreateGroupStepActivity createGroupStepActivity) {
        this.f1498a = createGroupStepActivity;
        createGroupStepActivity.setContentView(R.layout.create_group_step_activity);
        this.q = createGroupStepActivity.findViewById(R.id.parent);
        this.d = (ProgressBar) createGroupStepActivity.findViewById(R.id.progress);
        this.u = (NoSwipeableViewPager) createGroupStepActivity.findViewById(R.id.pagercontent);
        this.c = new CreateGroupStepAdapter(this.f1498a);
        CreateGroupStepAdapter createGroupStepAdapter = this.c;
        c cVar = new c(this.f1498a);
        this.i = cVar;
        createGroupStepAdapter.a(cVar);
        CreateGroupStepAdapter createGroupStepAdapter2 = this.c;
        a aVar = new a(this.f1498a);
        this.j = aVar;
        createGroupStepAdapter2.a(aVar);
        CreateGroupStepAdapter createGroupStepAdapter3 = this.c;
        d dVar = new d(this.f1498a);
        this.k = dVar;
        createGroupStepAdapter3.a(dVar);
        this.u.setAdapter(this.c);
        this.p = (NavigationBar) createGroupStepActivity.findViewById(R.id.view_navigation_bar);
        C();
        this.p.setSystemClickable(false);
        this.r = this.p.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.s = this.p.b(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, createGroupStepActivity.getResources().getString(R.string.group_create_step_tip));
        b(false);
        x();
    }

    private void b(boolean z) {
        this.m = z;
        B();
    }

    public boolean s() {
        return this.m;
    }

    private void B() {
        if (TiebaApplication.g().as() == 1) {
            if (this.m) {
                bb.e((View) this.s, (int) R.drawable.btn_step_1);
                this.s.setTextColor(this.f1498a.getResources().getColorStateList(R.drawable.btn_step_color_1));
                return;
            }
            this.s.setTextColor(this.f1498a.getResources().getColor(R.color.widget_nb_txtbtn_color_n_1));
            bb.e((View) this.s, (int) R.drawable.but_head_bar_d_1);
        } else if (this.m) {
            bb.e((View) this.s, (int) R.drawable.btn_step);
            this.s.setTextColor(this.f1498a.getResources().getColorStateList(R.drawable.btn_step_color));
        } else {
            bb.e((View) this.s, (int) R.drawable.but_head_bar_d);
            this.s.setTextColor(this.f1498a.getResources().getColor(R.color.widget_nb_txtbtn_color_n));
        }
    }

    public void t() {
        if (this.o > 1) {
            this.o--;
            v();
        }
    }

    public void u() {
        if (this.o < 3) {
            this.o++;
            v();
        }
    }

    public void v() {
        this.u.setCurrentItem(this.o - 1);
        C();
        x();
        y();
        this.i.d().clearFocus();
        this.j.d().clearFocus();
        a(this.i.d());
        a(this.j.d());
        if (this.o == 3 && i()) {
            f().setEnabled(false);
        } else {
            f().setEnabled(true);
        }
    }

    public void w() {
        String[] strArr = {this.f1498a.getResources().getString(R.string.take_photo), this.f1498a.getResources().getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1498a);
        builder.setTitle(this.f1498a.getResources().getString(R.string.operation));
        builder.setItems(strArr, new l(this));
        if (this.t == null) {
            this.t = builder.create();
        }
        this.t.show();
    }

    public void a(int i) {
        if (!this.s.getText().toString().equals(this.b.getString(i))) {
            this.s.setText(i);
        }
    }

    private void C() {
        this.p.a(this.f1498a.getResources().getString(this.c.a(this.o - 1).c()));
    }

    public void x() {
        for (q qVar : this.c.a()) {
            if (qVar.b() == this.o) {
                qVar.i();
                a(qVar.a());
            } else {
                qVar.g();
            }
        }
        if (this.o == 3) {
            b(true);
        }
    }

    public void y() {
        if (this.o == 1) {
            a(this.i.d().getText().length(), this.i.e(), 2, 20);
        } else if (this.o == 2) {
            int length = this.j.d().getText().length();
            a(length, 15, 300);
            int i = 300 - length;
            this.j.e().setText(String.valueOf(i));
            if (i <= 50) {
                this.j.e().setVisibility(0);
            } else {
                this.j.e().setVisibility(8);
            }
            if (i == 0) {
                this.j.e().setTextColor(this.f1498a.getResources().getColor(R.color.group_create_info_count_color));
            } else {
                this.j.h();
            }
        }
    }

    private void a(int i, int i2, int i3) {
        if (i >= i2 && i <= i3) {
            b(true);
        } else {
            b(false);
        }
    }

    private void a(int i, float f, int i2, int i3) {
        if (i == 1) {
            b(false);
        } else if (f >= i2 && f <= i3) {
            b(true);
        } else {
            b(false);
        }
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public void b(int i) {
        this.f1498a.m().a(i == 1);
        this.f1498a.m().a(this.q);
        bb.a(this.q, i);
        this.p.b(i);
        B();
    }

    public void a(EditText editText) {
        ((InputMethodManager) this.f1498a.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
