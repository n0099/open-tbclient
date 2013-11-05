package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.FrsHeaderView;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.zeus.bouncycastle.DERTags;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ba {
    private View.OnClickListener E;
    private int H;
    private int I;
    private int J;
    private NoNetworkView K;
    private bf L;
    private com.baidu.tieba.j d;
    private boolean c = false;
    private RelativeLayout e = null;
    private ImageView f = null;
    private TextView g = null;
    private ImageButton h = null;
    private Button i = null;
    private RelativeLayout j = null;
    private ImageView k = null;
    private ImageView l = null;
    private BdListView m = null;
    private ad n = null;
    private TextView o = null;
    private LinearLayout p = null;
    private TextView q = null;
    private AlertDialog r = null;
    private FrsHeaderView s = null;
    private com.baidu.tieba.view.ac t = null;
    private com.baidu.tieba.view.x u = null;
    private ag v = null;
    private TextView w = null;
    private ImageButton x = null;
    private int y = 0;
    private com.baidu.tieba.view.ab z = null;
    private bh A = null;
    private com.baidu.tieba.view.am B = null;
    private SlidingMenu C = null;
    private String D = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1270a = null;
    Animation b = null;
    private DialogInterface.OnClickListener F = null;
    private com.baidu.tieba.view.az G = null;
    private View.OnTouchListener M = new bd(this);

    public ba(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.d = null;
        this.E = null;
        this.d = frsActivity;
        this.E = onClickListener;
        B();
    }

    private void B() {
        this.d.setContentView(R.layout.frs_activity);
        this.A = new bh(this.d);
        this.A.a(R.id.show_all);
        this.e = (RelativeLayout) this.d.findViewById(R.id.frs);
        this.C = new SlidingMenu(this.d);
        this.C.setMode(1);
        this.C.setTouchModeAbove(1);
        this.C.setBehindOffset(UtilHelper.a((Context) this.d, 48.0f));
        this.C.setBehindScrollScale(0.5f);
        this.C.setFadeDegree(0.35f);
        this.C.attachToActivity(this.d, 1);
        this.C.setMenu(this.A.a());
        this.g = (TextView) this.d.findViewById(R.id.frs_top_title);
        this.f = (ImageView) this.d.findViewById(R.id.frs_bt_back);
        this.h = (ImageButton) this.d.findViewById(R.id.frs_top_edit);
        this.x = (ImageButton) this.d.findViewById(R.id.frs_top_more);
        this.j = (RelativeLayout) this.d.findViewById(R.id.refresh_layout);
        this.k = (ImageView) this.d.findViewById(R.id.refresh_bg);
        this.l = (ImageView) this.d.findViewById(R.id.refresh_icon);
        this.w = (TextView) this.d.findViewById(R.id.frs_more_mes_text);
        String[] strArr = {this.d.getString(R.string.take_photo), this.d.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(this.d.getString(R.string.operation));
        builder.setItems(strArr, new bb(this));
        if (this.r == null) {
            this.r = builder.create();
            this.r.setCanceledOnTouchOutside(true);
        }
        this.m = (BdListView) this.d.findViewById(R.id.frs_lv_thread);
        this.z = new com.baidu.tieba.view.ab(this.d);
        this.m.setPullRefresh(this.z);
        this.m.setDivider(null);
        this.m.setDividerHeight(0);
        this.m.setRecyclerListener(new bc(this));
        this.s = new FrsHeaderView(this.d, FrsHeaderView.PAGE.FRS_LIST, null, null);
        this.t = new com.baidu.tieba.view.ac(this.d, null, null);
        this.u = new com.baidu.tieba.view.x(this.d);
        this.n = new ad(this.d, null, UtilHelper.a((Context) this.d), com.baidu.tieba.util.bd.a().b());
        this.b = AnimationUtils.loadAnimation(this.d, R.anim.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.o = (TextView) this.d.findViewById(R.id.frs_noexist);
        this.o.setVisibility(8);
        this.q = (TextView) this.d.findViewById(R.id.frs_noexist_text);
        this.p = (LinearLayout) this.d.findViewById(R.id.frs_noexist_layout);
        this.i = (Button) this.d.findViewById(R.id.frs_bt_create);
        this.A.a(this.E);
        this.f.setOnClickListener(this.E);
        this.h.setOnClickListener(this.E);
        this.x.setOnClickListener(this.E);
        this.h.setScaleType(ImageView.ScaleType.CENTER);
        this.x.setScaleType(ImageView.ScaleType.CENTER);
        this.j.setOnClickListener(this.E);
        this.i.setOnClickListener(this.E);
        this.s.a(this.E);
        this.t.a(this.E);
        this.g.setOnClickListener(this.E);
        this.j.setOnTouchListener(this.M);
        this.K = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        b(false);
        if (!com.baidu.tieba.im.l.b().e()) {
            this.L = new bf(this.d);
        }
    }

    public void a(com.baidu.tieba.view.az azVar) {
        this.G = azVar;
        if (this.K != null) {
            this.K.a(this.G);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.C.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.C.setOnOpenedListener(onOpenedListener);
    }

    public bh a() {
        return this.A;
    }

    public SlidingMenu b() {
        return this.C;
    }

    public void a(boolean z) {
        this.C.showMenu(z);
    }

    public void c() {
        this.K.setVisibility(0);
    }

    public void d() {
        this.K.setVisibility(8);
    }

    public NoNetworkView e() {
        return this.K;
    }

    public void a(com.baidu.tieba.data.bf bfVar, boolean z) {
        String string = this.d.getString(R.string.view);
        String string2 = this.d.getString(R.string.view_host);
        String string3 = this.d.getString(R.string.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(R.string.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.F);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.F);
        }
        this.f1270a = builder.create();
        this.f1270a.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.b bVar) {
        this.z.a(bVar);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.m.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.r rVar) {
        this.m.setOnSrollToBottomListener(rVar);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.m.setOnSrollToTopListener(sVar);
    }

    public void a(View.OnClickListener onClickListener) {
        this.n.a(onClickListener);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.m.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.m.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.F = onClickListener;
    }

    public void f() {
        if (this.f1270a != null) {
            this.f1270a.show();
        }
    }

    public void a(String str) {
        this.d.a(str);
    }

    public void b(boolean z) {
        this.c = z;
        if (z) {
            if (this.b != null) {
                this.j.setOnTouchListener(null);
                this.l.startAnimation(this.b);
                if (this.y == 1) {
                    this.k.setImageResource(R.drawable.pic_fresh_s_1);
                    return;
                } else {
                    this.k.setImageResource(R.drawable.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.j.setOnTouchListener(this.M);
        this.m.a();
        this.l.clearAnimation();
        if (this.y == 1) {
            this.k.setImageResource(R.drawable.pic_fresh_n_1);
        } else {
            this.k.setImageResource(R.drawable.pic_fresh_n);
        }
    }

    public boolean g() {
        return this.c;
    }

    public ad h() {
        return this.n;
    }

    public FrsHeaderView i() {
        return this.s;
    }

    public com.baidu.tieba.view.ac j() {
        return this.t;
    }

    public void b(String str) {
        this.o.setText(R.string.frs_noforum);
        SpannableString spannableString = new SpannableString(str + this.d.getString(R.string.frs_remind_noforum));
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), 0, str.length(), 33);
        this.p.setVisibility(0);
        this.q.setText(spannableString);
        this.g.setText(R.string.frs_create_forum);
        this.m.setVisibility(8);
        this.h.setVisibility(4);
        this.h.setClickable(false);
        this.j.setVisibility(4);
        this.x.setVisibility(8);
        this.C.setTouchModeAbove(2);
    }

    public void k() {
        this.m.setVisibility(0);
        this.n.a(TiebaApplication.g().ar());
    }

    public void c(String str) {
        this.g.setText(str + this.d.getString(R.string.forum));
    }

    public void l() {
        if (this.n != null) {
            this.n.notifyDataSetChanged();
        }
    }

    public void m() {
        C();
        this.D = "normal_page";
        this.m.addHeaderView(this.s.c());
    }

    public void n() {
        C();
        this.D = "frs_page";
        this.m.addHeaderView(this.t.c());
    }

    public void o() {
        if (!"good_page".equals(this.D)) {
            C();
            this.D = "good_page";
            this.m.addHeaderView(this.u.a());
        }
    }

    private void C() {
        if ("normal_page".equals(this.D)) {
            this.m.removeHeaderView(this.s.c());
        } else if ("frs_page".equals(this.D)) {
            this.m.removeHeaderView(this.t.c());
        } else if ("good_page".equals(this.D)) {
            this.m.removeHeaderView(this.u.a());
        }
    }

    public boolean p() {
        if ("normal_page".equals(this.D)) {
            return this.s.d();
        }
        if ("frs_page".equals(this.D)) {
            return this.t.d();
        }
        return false;
    }

    public boolean q() {
        if ("normal_page".equals(this.D)) {
            return this.s.e();
        }
        if ("frs_page".equals(this.D)) {
            return this.t.e();
        }
        return false;
    }

    public void c(boolean z) {
        if ("normal_page".equals(this.D)) {
            this.s.b(z);
        } else if ("frs_page".equals(this.D)) {
            this.t.b(z);
        }
    }

    public void r() {
        this.m.setAdapter((ListAdapter) this.n);
    }

    public void d(boolean z) {
        this.n.c(z);
    }

    public void e(boolean z) {
        this.n.d(z);
    }

    public void s() {
        this.r.show();
    }

    public void a(ArrayList<com.baidu.tieba.data.bf> arrayList, com.baidu.tieba.model.ak akVar, int i) {
        this.n.a(arrayList, akVar);
        if (arrayList == null || arrayList.size() <= 0) {
            this.o.setText(R.string.frs_nodata);
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
        if (!com.baidu.tieba.im.l.b().e() && this.m.c()) {
            a((akVar == null || akVar.e() == null || akVar.e().a() == 0) ? false : true, akVar.i() != null ? akVar.i().a() : 0);
        }
    }

    public void a(boolean z, int i) {
        if (this.L != null && !com.baidu.tieba.im.l.b().e()) {
            new Handler().postDelayed(new be(this, z, i), 500L);
        }
    }

    public View d(String str) {
        return this.m.findViewWithTag(str);
    }

    public View a(int i) {
        return this.m.findViewById(i);
    }

    public BdListView t() {
        return this.m;
    }

    public void b(int i) {
        if (i > 1) {
            this.n.e(true);
        } else {
            this.n.e(false);
        }
    }

    public void c(int i) {
        if (i == 1) {
            this.n.f(true);
        } else {
            this.n.f(false);
        }
    }

    public void u() {
        this.n.c(false);
        this.n.d(false);
        this.n.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.m.setSelection(i);
    }

    public void a(ForumData forumData, com.baidu.tieba.data.z zVar) {
        if (this.t != null) {
            this.t.a(forumData, zVar);
        }
        this.t.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData));
        this.t.b(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.t.a(false);
        }
    }

    public void a(int i, int i2) {
        this.t.b(i);
        if (this.J >= 0 && i2 > 0 && this.t.e()) {
            this.t.a(i(i2));
        }
    }

    public void e(int i) {
        this.t.b(i);
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.data.z zVar) {
        if (this.t != null) {
            this.t.a(forumData, zVar);
        }
        this.t.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData));
        if (forumData.getSignData().getForumRank() == -2) {
            this.t.a(false);
        }
    }

    public void a(ForumData forumData) {
        if (this.s != null) {
            this.s.a(forumData);
        }
        this.s.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData));
        this.s.b(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.s.a(false);
        }
    }

    public void f(int i) {
        this.s.b(i);
    }

    public void b(int i, int i2) {
        this.s.b(i);
        if (this.J >= 0 && i2 > 0 && this.s.e()) {
            this.s.a(i(i2));
        }
    }

    public void a(int i, ForumData forumData) {
        if (this.s != null) {
            this.s.a(forumData);
        }
        if (forumData != null) {
            this.s.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData));
            if (forumData.getSignData().getForumRank() == -2) {
                this.s.a(false);
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.H = forumData.getLevelupScore();
        this.I = forumData.getCurScore();
        this.J = this.H - this.I;
        if (this.H > 0) {
            return this.I / this.H;
        }
        return 0.0f;
    }

    private float i(int i) {
        if (this.J < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.J) {
            return 1.0f;
        }
        return (this.I + i) / this.H;
    }

    public void v() {
        if (this.B != null) {
            this.B.dismiss();
        }
        h().a().b();
        j().a().b();
    }

    public void w() {
        if (this.n != null) {
            this.n.d();
        }
        if (this.K != null && this.G != null) {
            this.K.b(this.G);
        }
    }

    public void a(ArrayList<com.baidu.tieba.data.aa> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        o();
        if (this.v == null) {
            this.v = new ag(this.d, arrayList);
            this.u.a(this.v);
            this.u.a(onItemClickListener);
            this.A.a(R.id.show_good);
            return;
        }
        this.v.a(arrayList);
        this.v.notifyDataSetChanged();
        this.A.a(R.id.show_good);
    }

    public void x() {
        if (this.B != null) {
            this.B.a();
        }
    }

    public void a(com.baidu.adp.widget.ImageView.e eVar, boolean z) {
        if (this.B == null) {
            this.B = new com.baidu.tieba.view.am(this.d, this.e.getWidth(), this.e.getHeight());
        }
        if (this.B.isShowing()) {
            this.B.a(eVar);
        } else {
            this.B.a(eVar, z);
        }
    }

    public com.baidu.tieba.view.am y() {
        return this.B;
    }

    public void z() {
        if (this.B != null) {
            this.B.a(null);
        }
    }

    public void g(int i) {
        if (this.v != null) {
            this.v.a(i);
        }
    }

    public void a(com.baidu.tieba.model.ap apVar) {
        this.A.a(apVar);
        long a2 = apVar.a() + apVar.b();
        if (a2 > 0) {
            this.w.setVisibility(0);
            this.w.setText(String.valueOf(a2 <= 99 ? a2 : 99L));
            return;
        }
        this.w.setVisibility(4);
    }

    public void h(int i) {
        this.y = i;
        this.t.a(i);
        if (this.z != null) {
            this.z.a(i);
        }
        this.u.a(i);
        this.A.b(i);
        this.s.a(i);
        this.d.m().a(i == 1);
        this.d.m().a(this.e);
    }

    public void f(boolean z) {
        if (z) {
            this.k.setAlpha(DERTags.TAGGED);
            this.l.setAlpha(DERTags.TAGGED);
            return;
        }
        this.k.setAlpha(Util.MASK_8BIT);
        this.l.setAlpha(Util.MASK_8BIT);
    }

    public void A() {
        this.m.b();
    }
}
