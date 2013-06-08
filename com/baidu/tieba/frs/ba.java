package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.bouncycastle.DERTags;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba {
    private View.OnClickListener G;
    private DialogInterface.OnClickListener H;
    private int I;
    private int J;
    private int K;
    private com.baidu.tieba.e d;
    private boolean c = false;
    private RelativeLayout e = null;
    private FrameLayout f = null;
    private LinearLayout g = null;
    private ImageView h = null;
    private TextView i = null;
    private ImageButton j = null;
    private Button k = null;
    private RelativeLayout l = null;
    private ImageView m = null;
    private ImageView n = null;
    private BdListView o = null;
    private ad p = null;
    private TextView q = null;
    private LinearLayout r = null;
    private TextView s = null;
    private AlertDialog t = null;
    private com.baidu.tieba.view.o u = null;
    private com.baidu.tieba.view.s v = null;
    private com.baidu.tieba.view.n w = null;
    private ag x = null;
    private TextView y = null;
    private ImageButton z = null;
    private int A = 0;
    private com.baidu.tieba.view.r B = null;
    private bd C = null;
    private com.baidu.tieba.view.ac D = null;
    private SlidingMenu E = null;
    private String F = null;
    AlertDialog a = null;
    Animation b = null;
    private View.OnTouchListener L = new bb(this);

    public ba(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.d = null;
        this.G = null;
        this.d = frsActivity;
        this.G = onClickListener;
        y();
    }

    private void y() {
        this.d.setContentView(R.layout.frs_activity);
        this.C = new bd(this.d);
        this.C.a(R.id.show_all);
        this.e = (RelativeLayout) this.d.findViewById(R.id.frs);
        this.g = (LinearLayout) this.d.findViewById(R.id.frs_title);
        this.f = (FrameLayout) this.d.findViewById(R.id.frs_list_content);
        this.E = new SlidingMenu(this.d);
        this.E.setMode(1);
        this.E.setTouchModeAbove(1);
        this.E.setBehindOffset(com.baidu.tieba.d.ag.a(this.d, 48.0f));
        this.E.setBehindScrollScale(0.5f);
        this.E.setFadeDegree(0.35f);
        this.E.attachToActivity(this.d, 1);
        this.E.setMenu(this.C.a());
        this.i = (TextView) this.d.findViewById(R.id.frs_top_title);
        this.h = (ImageView) this.d.findViewById(R.id.frs_bt_back);
        this.j = (ImageButton) this.d.findViewById(R.id.frs_top_edit);
        this.z = (ImageButton) this.d.findViewById(R.id.frs_top_more);
        this.l = (RelativeLayout) this.d.findViewById(R.id.refresh_layout);
        this.m = (ImageView) this.d.findViewById(R.id.refresh_bg);
        this.n = (ImageView) this.d.findViewById(R.id.refresh_icon);
        this.y = (TextView) this.d.findViewById(R.id.frs_more_mes_text);
        String[] strArr = {this.d.getString(R.string.take_photo), this.d.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(this.d.getString(R.string.operation));
        builder.setItems(strArr, new bc(this));
        if (this.t == null) {
            this.t = builder.create();
            this.t.setCanceledOnTouchOutside(true);
        }
        this.o = (BdListView) this.d.findViewById(R.id.frs_lv_thread);
        this.B = new com.baidu.tieba.view.r(this.d);
        this.o.setPullRefresh(this.B);
        this.o.setDivider(null);
        this.o.setDividerHeight(0);
        this.u = new com.baidu.tieba.view.o(this.d, com.baidu.tieba.view.p.FRS_LIST, null, null);
        this.v = new com.baidu.tieba.view.s(this.d, null, null);
        this.w = new com.baidu.tieba.view.n(this.d);
        this.p = new ad(this.d, null, com.baidu.tieba.d.ag.a((Context) this.d), false);
        this.b = AnimationUtils.loadAnimation(this.d, R.anim.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.q = (TextView) this.d.findViewById(R.id.frs_noexist);
        this.q.setVisibility(8);
        this.s = (TextView) this.d.findViewById(R.id.frs_noexist_text);
        this.r = (LinearLayout) this.d.findViewById(R.id.frs_noexist_layout);
        this.k = (Button) this.d.findViewById(R.id.frs_bt_create);
        this.C.a(this.G);
        this.h.setOnClickListener(this.G);
        this.j.setOnClickListener(this.G);
        this.z.setOnClickListener(this.G);
        this.j.setScaleType(ImageView.ScaleType.CENTER);
        this.z.setScaleType(ImageView.ScaleType.CENTER);
        this.l.setOnClickListener(this.G);
        this.k.setOnClickListener(this.G);
        this.u.a(this.G);
        this.v.a(this.G);
        this.i.setOnClickListener(this.G);
        this.l.setOnTouchListener(this.L);
        b(false);
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.E.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.E.setOnOpenedListener(onOpenedListener);
    }

    public bd a() {
        return this.C;
    }

    public SlidingMenu b() {
        return this.E;
    }

    public void a(boolean z) {
        this.E.showMenu(z);
    }

    public void a(com.baidu.tieba.a.bc bcVar, boolean z) {
        String string = this.d.getString(R.string.view);
        String string2 = this.d.getString(R.string.view_host);
        String string3 = this.d.getString(R.string.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(R.string.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.H);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.H);
        }
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public int c() {
        if (this.o != null) {
            return this.o.getFirstVisiblePosition();
        }
        return -1;
    }

    public int d() {
        if (this.o != null) {
            return this.o.getLastVisiblePosition();
        }
        return -1;
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.B.a(bVar);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.o.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.o.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.o.setOnSrollToTopListener(sVar);
    }

    public void a(View.OnClickListener onClickListener) {
        this.p.a(onClickListener);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.o.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.o.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.H = onClickListener;
    }

    public void e() {
        if (this.a != null) {
            this.a.show();
        }
    }

    public void a(String str) {
        this.d.a(str);
    }

    public void b(boolean z) {
        this.c = z;
        if (z) {
            if (this.b != null) {
                this.l.setOnTouchListener(null);
                this.n.startAnimation(this.b);
                if (this.A == 1) {
                    this.m.setImageResource(R.drawable.pic_fresh_s_1);
                    return;
                } else {
                    this.m.setImageResource(R.drawable.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.l.setOnTouchListener(this.L);
        this.o.a();
        this.n.clearAnimation();
        if (this.A == 1) {
            this.m.setImageResource(R.drawable.pic_fresh_n_1);
        } else {
            this.m.setImageResource(R.drawable.pic_fresh_n);
        }
    }

    public boolean f() {
        return this.c;
    }

    public ad g() {
        return this.p;
    }

    public com.baidu.tieba.view.o h() {
        return this.u;
    }

    public com.baidu.tieba.view.s i() {
        return this.v;
    }

    public void b(String str) {
        this.q.setText(R.string.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.d.getString(R.string.frs_remind_noforum));
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, str.length(), 33);
        this.r.setVisibility(0);
        this.s.setText(spannableString);
        this.i.setText(R.string.frs_create_forum);
        this.o.setVisibility(8);
        this.j.setVisibility(4);
        this.j.setClickable(false);
        this.l.setVisibility(4);
    }

    public void j() {
        this.o.setVisibility(0);
        this.p.a(TiebaApplication.d().ap());
    }

    public void c(String str) {
        this.i.setText(String.valueOf(str) + this.d.getString(R.string.forum));
    }

    public void k() {
        if (this.p != null) {
            this.p.notifyDataSetChanged();
        }
    }

    public void l() {
        z();
        this.F = "normal_page";
        this.o.addHeaderView(this.u.c());
    }

    public void m() {
        z();
        this.F = "frs_page";
        this.o.addHeaderView(this.v.c());
    }

    public void n() {
        if (this.F != "good_page") {
            z();
            this.F = "good_page";
            this.o.addHeaderView(this.w.a());
        }
    }

    private void z() {
        if (this.F == "normal_page") {
            this.o.removeHeaderView(this.u.c());
        } else if (this.F == "frs_page") {
            this.o.removeHeaderView(this.v.c());
        } else if (this.F == "good_page") {
            this.o.removeHeaderView(this.w.a());
        }
    }

    public boolean o() {
        if (this.F == "normal_page") {
            return this.u.d();
        }
        if (this.F == "frs_page") {
            return this.v.d();
        }
        return false;
    }

    public boolean p() {
        if (this.F == "normal_page") {
            return this.u.f();
        }
        if (this.F == "frs_page") {
            return this.v.e();
        }
        return false;
    }

    public void q() {
        this.o.setAdapter((ListAdapter) this.p);
    }

    public void c(boolean z) {
        this.p.c(z);
    }

    public void d(boolean z) {
        this.p.d(z);
    }

    public void r() {
        this.t.show();
    }

    public void a(ArrayList arrayList, int i) {
        this.p.a(arrayList);
        if (arrayList == null || arrayList.size() <= 0) {
            this.q.setText(R.string.frs_nodata);
            this.q.setVisibility(0);
            return;
        }
        this.q.setVisibility(8);
    }

    public View d(String str) {
        return this.o.findViewWithTag(str);
    }

    public View a(int i) {
        return this.o.findViewById(i);
    }

    public void b(int i) {
        if (i > 1) {
            this.p.e(true);
        } else {
            this.p.e(false);
        }
    }

    public void c(int i) {
        if (i == 1) {
            this.p.f(true);
        } else {
            this.p.f(false);
        }
    }

    public void s() {
        this.p.c(false);
        this.p.d(false);
        this.p.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.o.setSelection(i);
    }

    public void a(com.baidu.tieba.a.s sVar, com.baidu.tieba.a.u uVar) {
        if (this.v != null) {
            this.v.a(sVar, uVar);
        }
        this.v.a(sVar.e(), sVar.i(), sVar.f(), b(sVar));
        this.v.c(sVar.g().b());
        if (sVar.g().a() == -2) {
            this.v.a(false);
        }
    }

    public void a(int i, int i2) {
        this.v.c(i);
        if (this.K >= 0 && i2 > 0 && this.v.e()) {
            this.v.a(k(i2));
        }
    }

    public void e(int i) {
        this.v.c(i);
    }

    public void a(int i, com.baidu.tieba.a.s sVar, com.baidu.tieba.a.u uVar) {
        if (this.v != null) {
            this.v.a(sVar, uVar);
        }
        this.v.a(i, sVar.i(), sVar.f(), b(sVar));
        if (sVar.g().a() == -2) {
            this.v.a(false);
        }
    }

    public void a(com.baidu.tieba.a.s sVar) {
        if (this.u != null) {
            this.u.a(sVar);
        }
        this.u.a(sVar.e(), sVar.i(), sVar.f(), b(sVar));
        this.u.c(sVar.g().b());
        if (sVar.g().a() == -2) {
            this.u.a(false);
        }
    }

    public void f(int i) {
        this.u.c(i);
    }

    public void b(int i, int i2) {
        this.u.c(i);
        if (this.K >= 0 && i2 > 0 && this.u.f()) {
            this.u.a(k(i2));
        }
    }

    public void a(int i, com.baidu.tieba.a.s sVar) {
        if (this.u != null) {
            this.u.a(sVar);
        }
        if (sVar != null) {
            this.u.a(i, sVar.i(), sVar.f(), b(sVar));
            if (sVar.g().a() == -2) {
                this.u.a(false);
            }
        }
    }

    public void g(int i) {
        if (this.u != null) {
            this.u.b(i);
        }
    }

    public void h(int i) {
        if (this.v != null) {
            this.v.b(i);
        }
    }

    private float b(com.baidu.tieba.a.s sVar) {
        if (sVar == null) {
            return 0.0f;
        }
        this.I = sVar.o();
        this.J = sVar.n();
        this.K = this.I - this.J;
        if (this.I > 0) {
            return this.J / this.I;
        }
        return 0.0f;
    }

    private float k(int i) {
        if (this.K < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.K) {
            return 1.0f;
        }
        return (this.J + i) / this.I;
    }

    public void t() {
        if (this.D != null) {
            this.D.dismiss();
        }
        g().a().b();
        i().a().b();
    }

    public void u() {
        if (this.p != null) {
            this.p.d();
        }
        if (this.u != null) {
            this.u.e();
        }
        if (this.v != null) {
            this.v.f();
        }
        if (this.w != null) {
            this.w.b();
        }
    }

    public void a(ArrayList arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        n();
        if (this.x == null) {
            this.x = new ag(this.d, arrayList);
            this.w.a(this.x);
            this.w.a(onItemClickListener);
            this.C.a(R.id.show_good);
            return;
        }
        this.x.a(arrayList);
        this.x.notifyDataSetChanged();
        this.C.a(R.id.show_good);
    }

    public void v() {
        if (this.D != null) {
            this.D.a();
        }
    }

    public void a(com.baidu.adp.widget.a.b bVar, boolean z) {
        if (this.D == null) {
            this.D = new com.baidu.tieba.view.ac(this.d, this.e.getWidth(), this.e.getHeight());
        }
        if (this.D.isShowing()) {
            this.D.a(bVar);
        } else {
            this.D.a(bVar, z);
        }
    }

    public com.baidu.tieba.view.ac w() {
        return this.D;
    }

    public void x() {
        if (this.D != null) {
            this.D.a(null);
        }
    }

    public void i(int i) {
        if (this.x != null) {
            this.x.a(i);
        }
    }

    public void a(com.baidu.tieba.c.x xVar) {
        this.C.a(xVar);
        long a = xVar.a() + xVar.b();
        if (a > 0) {
            this.y.setVisibility(0);
            this.y.setText(String.valueOf(a <= 99 ? a : 99L));
            return;
        }
        this.y.setVisibility(4);
    }

    public void j(int i) {
        this.A = i;
        com.baidu.tieba.d.ac.b(this.f, i);
        com.baidu.tieba.d.ac.b((View) this.o, i);
        com.baidu.tieba.d.ac.d(this.g, i);
        com.baidu.tieba.d.ac.a(this.h, i);
        this.u.a(i);
        this.v.a(i);
        this.w.a(i);
        this.C.b(i);
        if (this.p != null) {
            this.p.notifyDataSetChanged();
        }
        if (this.x != null) {
            this.x.notifyDataSetChanged();
        }
        if (this.B != null) {
            this.B.a(i);
        }
        if (i == 1) {
            this.y.setTextColor(-2960686);
            this.y.setBackgroundResource(R.drawable.icon_point_1);
            this.i.setTextColor(-5524539);
            this.j.setImageResource(R.drawable.icon_edit_n_1);
            this.j.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.z.setImageResource(R.drawable.btn_more_n_1);
            this.z.setBackgroundResource(R.drawable.title_icon_bg_1);
            this.m.setImageResource(R.drawable.pic_fresh_n_1);
            this.n.setImageResource(R.drawable.pic_icon_fresh_1);
            return;
        }
        this.y.setTextColor(-1);
        this.y.setBackgroundResource(R.drawable.icon_point);
        this.i.setTextColor(-1);
        this.j.setImageResource(R.drawable.icon_edit_n);
        this.j.setBackgroundResource(R.drawable.title_icon_bg);
        this.z.setImageResource(R.drawable.btn_more_n);
        this.z.setBackgroundResource(R.drawable.title_icon_bg);
        this.m.setImageResource(R.drawable.pic_fresh_n);
        this.n.setImageResource(R.drawable.pic_icon_fresh);
    }

    public void e(boolean z) {
        if (z) {
            this.m.setAlpha(DERTags.TAGGED);
            this.n.setAlpha(DERTags.TAGGED);
            return;
        }
        this.m.setAlpha(255);
        this.n.setAlpha(255);
    }
}
