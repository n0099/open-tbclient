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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsHeaderView;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.zeus.bouncycastle.DERTags;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bb {
    private View.OnClickListener G;
    private int J;
    private int K;
    private int L;
    private NoNetworkView M;
    private com.baidu.tieba.g d;
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
    private af p = null;
    private TextView q = null;
    private LinearLayout r = null;
    private TextView s = null;
    private AlertDialog t = null;
    private FrsHeaderView u = null;
    private com.baidu.tieba.view.ab v = null;
    private com.baidu.tieba.view.w w = null;
    private ai x = null;
    private TextView y = null;
    private ImageButton z = null;
    private int A = 0;
    private com.baidu.tieba.view.aa B = null;
    private bh C = null;
    private com.baidu.tieba.view.al D = null;
    private SlidingMenu E = null;
    private String F = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1090a = null;
    Animation b = null;
    private DialogInterface.OnClickListener H = null;
    private com.baidu.tieba.view.ax I = null;
    private View.OnTouchListener N = new bc(this);

    public bb(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.d = null;
        this.G = null;
        this.d = frsActivity;
        this.G = onClickListener;
        C();
    }

    private void C() {
        this.d.setContentView(R.layout.frs_activity);
        this.C = new bh(this.d);
        this.C.a(R.id.show_all);
        this.e = (RelativeLayout) this.d.findViewById(R.id.frs);
        this.g = (LinearLayout) this.d.findViewById(R.id.frs_title);
        this.f = (FrameLayout) this.d.findViewById(R.id.frs_list_content);
        this.E = new SlidingMenu(this.d);
        this.E.setMode(1);
        this.E.setTouchModeAbove(1);
        this.E.setBehindOffset(UtilHelper.a((Context) this.d, 48.0f));
        this.E.setBehindScrollScale(0.5f);
        this.E.setFadeDegree(0.35f);
        this.E.attachToActivity(this.d, 1);
        this.E.setMenu(this.C.b());
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
        builder.setItems(strArr, new bd(this));
        if (this.t == null) {
            this.t = builder.create();
            this.t.setCanceledOnTouchOutside(true);
        }
        this.o = (BdListView) this.d.findViewById(R.id.frs_lv_thread);
        this.B = new com.baidu.tieba.view.aa(this.d);
        this.o.setPullRefresh(this.B);
        this.o.setDivider(null);
        this.o.setDividerHeight(0);
        this.u = new FrsHeaderView(this.d, FrsHeaderView.PAGE.FRS_LIST, null, null);
        this.v = new com.baidu.tieba.view.ab(this.d, null, null);
        this.w = new com.baidu.tieba.view.w(this.d);
        this.p = new af(this.d, null, UtilHelper.a((Context) this.d), TiebaApplication.g().aZ());
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
        this.l.setOnTouchListener(this.N);
        this.M = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        b(false);
    }

    public void a(com.baidu.tieba.view.ax axVar) {
        this.I = axVar;
        if (this.M != null) {
            this.M.a(this.I);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.E.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.E.setOnOpenedListener(onOpenedListener);
    }

    public bh a() {
        return this.C;
    }

    public SlidingMenu b() {
        return this.E;
    }

    public void a(boolean z) {
        this.E.showMenu(z);
    }

    public void c() {
        this.M.setVisibility(0);
    }

    public void d() {
        this.M.setVisibility(8);
    }

    public void a(com.baidu.tieba.data.bh bhVar, boolean z) {
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
        this.f1090a = builder.create();
        this.f1090a.setCanceledOnTouchOutside(true);
    }

    public int e() {
        if (this.o != null) {
            return this.o.getFirstVisiblePosition();
        }
        return -1;
    }

    public int f() {
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

    public void g() {
        if (this.f1090a != null) {
            this.f1090a.show();
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
        this.l.setOnTouchListener(this.N);
        this.o.a();
        this.n.clearAnimation();
        if (this.A == 1) {
            this.m.setImageResource(R.drawable.pic_fresh_n_1);
        } else {
            this.m.setImageResource(R.drawable.pic_fresh_n);
        }
    }

    public boolean h() {
        return this.c;
    }

    public af i() {
        return this.p;
    }

    public FrsHeaderView j() {
        return this.u;
    }

    public com.baidu.tieba.view.ab k() {
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

    public void l() {
        this.o.setVisibility(0);
        this.p.a(TiebaApplication.g().al());
    }

    public void c(String str) {
        this.i.setText(String.valueOf(str) + this.d.getString(R.string.forum));
    }

    public void m() {
        if (this.p != null) {
            this.p.notifyDataSetChanged();
        }
    }

    public void n() {
        D();
        this.F = "normal_page";
        this.o.addHeaderView(this.u.c());
    }

    public void o() {
        D();
        this.F = "frs_page";
        this.o.addHeaderView(this.v.c());
    }

    public void p() {
        if (this.F != "good_page") {
            D();
            this.F = "good_page";
            this.o.addHeaderView(this.w.a());
        }
    }

    private void D() {
        if (this.F == "normal_page") {
            this.o.removeHeaderView(this.u.c());
        } else if (this.F == "frs_page") {
            this.o.removeHeaderView(this.v.c());
        } else if (this.F == "good_page") {
            this.o.removeHeaderView(this.w.a());
        }
    }

    public boolean q() {
        if (this.F == "normal_page") {
            return this.u.d();
        }
        if (this.F == "frs_page") {
            return this.v.d();
        }
        return false;
    }

    public boolean r() {
        if (this.F == "normal_page") {
            return this.u.h();
        }
        if (this.F == "frs_page") {
            return this.v.e();
        }
        return false;
    }

    public void c(boolean z) {
        if (this.F == "normal_page") {
            this.u.b(z);
        } else if (this.F == "frs_page") {
            this.v.b(z);
        }
    }

    public void s() {
        this.o.setAdapter((ListAdapter) this.p);
    }

    public void d(boolean z) {
        this.p.c(z);
    }

    public void e(boolean z) {
        this.p.d(z);
    }

    public void t() {
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

    public void u() {
        this.p.c(false);
        this.p.d(false);
        this.p.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.o.setSelection(i);
    }

    public void a(com.baidu.tieba.data.v vVar, com.baidu.tieba.data.z zVar) {
        if (this.v != null) {
            this.v.a(vVar, zVar);
        }
        this.v.a(vVar.e(), vVar.k(), vVar.h(), b(vVar));
        this.v.c(vVar.i().b());
        if (vVar.i().a() == -2) {
            this.v.a(false);
        }
    }

    public void a(int i, int i2) {
        this.v.c(i);
        if (this.L >= 0 && i2 > 0 && this.v.e()) {
            this.v.a(k(i2));
        }
    }

    public void e(int i) {
        this.v.c(i);
    }

    public void a(int i, com.baidu.tieba.data.v vVar, com.baidu.tieba.data.z zVar) {
        if (this.v != null) {
            this.v.a(vVar, zVar);
        }
        this.v.a(i, vVar.k(), vVar.h(), b(vVar));
        if (vVar.i().a() == -2) {
            this.v.a(false);
        }
    }

    public void a(com.baidu.tieba.data.v vVar) {
        if (this.u != null) {
            this.u.a(vVar);
        }
        this.u.a(vVar.e(), vVar.k(), vVar.h(), b(vVar));
        this.u.c(vVar.i().b());
        if (vVar.i().a() == -2) {
            this.u.a(false);
        }
    }

    public void f(int i) {
        this.u.c(i);
    }

    public void b(int i, int i2) {
        this.u.c(i);
        if (this.L >= 0 && i2 > 0 && this.u.h()) {
            this.u.a(k(i2));
        }
    }

    public void a(int i, com.baidu.tieba.data.v vVar) {
        if (this.u != null) {
            this.u.a(vVar);
        }
        if (vVar != null) {
            this.u.a(i, vVar.k(), vVar.h(), b(vVar));
            if (vVar.i().a() == -2) {
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

    private float b(com.baidu.tieba.data.v vVar) {
        if (vVar == null) {
            return 0.0f;
        }
        this.J = vVar.q();
        this.K = vVar.p();
        this.L = this.J - this.K;
        if (this.J > 0) {
            return this.K / this.J;
        }
        return 0.0f;
    }

    private float k(int i) {
        if (this.L < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.L) {
            return 1.0f;
        }
        return (this.K + i) / this.J;
    }

    public void v() {
        if (this.D != null) {
            this.D.dismiss();
        }
        if (this.F == "normal_page") {
            this.u.f();
        } else if (this.F == "frs_page") {
            this.v.g();
        }
        i().a().b();
        k().a().b();
    }

    public void w() {
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
        if (this.M != null && this.I != null) {
            this.M.b(this.I);
        }
    }

    public void a(ArrayList arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        p();
        if (this.x == null) {
            this.x = new ai(this.d, arrayList);
            this.w.a(this.x);
            this.w.a(onItemClickListener);
            this.C.a(R.id.show_good);
            return;
        }
        this.x.a(arrayList);
        this.x.notifyDataSetChanged();
        this.C.a(R.id.show_good);
    }

    public void x() {
        if (this.D != null) {
            this.D.a();
        }
    }

    public void a(com.baidu.adp.widget.a.b bVar, boolean z) {
        if (this.D == null) {
            this.D = new com.baidu.tieba.view.al(this.d, this.e.getWidth(), this.e.getHeight());
        }
        if (this.D.isShowing()) {
            this.D.a(bVar);
        } else {
            this.D.a(bVar, z);
        }
    }

    public com.baidu.tieba.view.al y() {
        return this.D;
    }

    public void z() {
        if (this.D != null) {
            this.D.a(null);
        }
    }

    public void i(int i) {
        if (this.x != null) {
            this.x.a(i);
        }
    }

    public void a(com.baidu.tieba.model.af afVar) {
        this.C.a(afVar);
        long a2 = afVar.a() + afVar.b();
        if (a2 > 0) {
            this.y.setVisibility(0);
            this.y.setText(String.valueOf(a2 <= 99 ? a2 : 99L));
            return;
        }
        this.y.setVisibility(4);
    }

    public void j(int i) {
        this.A = i;
        com.baidu.tieba.util.ao.b(this.f, i);
        com.baidu.tieba.util.ao.b(this.o, i);
        com.baidu.tieba.util.ao.d(this.g, i);
        com.baidu.tieba.util.ao.a(this.h, i);
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
        } else {
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
        this.M.a(i);
    }

    public void f(boolean z) {
        if (z) {
            this.m.setAlpha(DERTags.TAGGED);
            this.n.setAlpha(DERTags.TAGGED);
            return;
        }
        this.m.setAlpha(Util.MASK_8BIT);
        this.n.setAlpha(Util.MASK_8BIT);
    }

    public void A() {
        if (this.F == "normal_page") {
            this.u.g();
        } else if (this.F == "frs_page") {
            this.v.h();
        }
    }

    public void B() {
        this.o.b();
    }
}
