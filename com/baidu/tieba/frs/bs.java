package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.MotionEventCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.util.cd;
import com.baidu.tieba.view.FrsHeaderView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.cs;
import com.slidingmenu.lib.R;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public final class bs {
    private View A;
    private cs C;
    private ca D;
    private SlidingMenu F;
    private View.OnClickListener H;
    private int K;
    private int L;
    private int M;
    private com.baidu.tieba.view.ae O;
    private NoNetworkView P;
    private NavigationBar Q;
    Animation b;
    private com.baidu.tieba.f d;
    private RelativeLayout e;
    private ImageView g;
    private TextView h;
    private ImageView i;
    private Button j;
    private FrameLayout k;
    private ImageView l;
    private ImageView m;
    private BdListView n;
    private al o;
    private TextView p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private AlertDialog u;
    private FrsHeaderView v;
    private com.baidu.tieba.view.ar w;
    private com.baidu.tieba.view.an x;
    private TextView z;
    private boolean c = false;
    private FrameLayout f = null;
    private au y = null;
    private int B = 0;
    private com.baidu.tieba.view.bn E = null;
    private String G = null;
    AlertDialog a = null;
    private DialogInterface.OnClickListener I = null;
    private com.baidu.tieba.view.by J = null;
    private boolean N = false;
    private View.OnTouchListener R = new bt(this);

    public bs(com.baidu.tieba.f fVar, View.OnClickListener onClickListener) {
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.C = null;
        this.D = null;
        this.F = null;
        this.b = null;
        this.H = null;
        this.O = null;
        this.d = fVar;
        this.H = onClickListener;
        this.d.setContentView(R.layout.frs_activity);
        this.D = new ca(this.d);
        this.D.a(R.id.show_all);
        this.e = (RelativeLayout) this.d.findViewById(R.id.frs);
        this.O = new com.baidu.tieba.view.ae(this.d);
        this.O.setLayoutParams(new AbsListView.LayoutParams(-1, this.d.getResources().getDimensionPixelSize(R.dimen.frs_header_banner_height)));
        this.O.setVisibility(8);
        this.O.setBannerCloseListener(new bu(this));
        this.F = new SlidingMenu(this.d);
        this.F.setMode(1);
        this.F.setTouchModeAbove(1);
        this.F.setBehindOffset(BdUtilHelper.a((Context) this.d, 48.0f));
        this.F.setBehindScrollScale(0.5f);
        this.F.setFadeDegree(0.35f);
        this.F.attachToActivity(this.d, 1);
        this.F.setMenu(this.D.a());
        this.Q = (NavigationBar) this.d.findViewById(R.id.view_navigation_bar);
        this.h = this.Q.a("");
        this.g = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.H);
        this.i = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, NavigationBar.ControlType.EDIT_BUTTON, this.H);
        View a = this.Q.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_frs_more, (View.OnClickListener) null);
        this.A = a.findViewById(R.id.frs_top_more);
        this.A.setOnClickListener(this.H);
        this.z = (TextView) a.findViewById(R.id.frs_more_mes_text);
        this.k = (FrameLayout) this.d.findViewById(R.id.refresh_layout);
        this.l = (ImageView) this.d.findViewById(R.id.refresh_bg);
        this.m = (ImageView) this.d.findViewById(R.id.refresh_icon);
        String[] strArr = {this.d.getString(R.string.take_photo), this.d.getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(this.d.getString(R.string.operation));
        builder.setItems(strArr, new bv(this));
        if (this.u == null) {
            this.u = builder.create();
            this.u.setCanceledOnTouchOutside(true);
        }
        this.n = (BdListView) this.d.findViewById(R.id.frs_lv_thread);
        this.C = new cs(this.d);
        this.n.setPullRefresh(this.C);
        this.n.setDivider(null);
        this.n.setDividerHeight(0);
        this.n.setRecyclerListener(new bw(this));
        com.baidu.tieba.f fVar2 = this.d;
        FrsHeaderView.PAGE page = FrsHeaderView.PAGE.FRS_LIST;
        this.v = new FrsHeaderView(fVar2, null, null);
        this.w = new com.baidu.tieba.view.ar(this.d, null, null);
        this.x = new com.baidu.tieba.view.an(this.d);
        this.o = new al(this.d, null, BdUtilHelper.b(this.d), com.baidu.tieba.util.bv.a().b());
        this.b = AnimationUtils.loadAnimation(this.d, R.anim.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.t = (ImageView) this.d.findViewById(R.id.frs_noexit_image);
        this.p = (TextView) this.d.findViewById(R.id.frs_noexist);
        this.p.setVisibility(8);
        this.r = (TextView) this.d.findViewById(R.id.frs_noexist_text);
        this.s = (TextView) this.d.findViewById(R.id.frs_noexit_remind_create_text);
        this.q = (LinearLayout) this.d.findViewById(R.id.frs_noexist_layout);
        this.j = (Button) this.d.findViewById(R.id.frs_bt_create);
        this.D.a(this.H);
        this.k.setOnClickListener(this.H);
        this.v.a(this.H);
        this.w.a(this.H);
        this.h.setOnClickListener(this.H);
        this.j.setOnClickListener(this.H);
        this.k.setOnTouchListener(this.R);
        this.P = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        c(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final TextView a() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImageView b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImageView c() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View d() {
        return this.A;
    }

    public final boolean e() {
        if ("normal_page".equals(this.G)) {
            return this.v.h();
        }
        if ("frs_page".equals(this.G)) {
            return this.w.g();
        }
        return false;
    }

    public final void a(com.baidu.tieba.view.by byVar) {
        this.J = byVar;
        if (this.P != null) {
            this.P.a(this.J);
        }
    }

    public final void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.F.setOnClosedListener(onClosedListener);
    }

    public final void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.F.setOnOpenedListener(onOpenedListener);
    }

    public final ca f() {
        return this.D;
    }

    public final SlidingMenu g() {
        return this.F;
    }

    public final void a(boolean z) {
        this.F.showMenu(true);
    }

    public final void h() {
        this.P.setVisibility(0);
    }

    public final void i() {
        this.P.setVisibility(8);
    }

    public final NoNetworkView j() {
        return this.P;
    }

    public final void b(boolean z) {
        String string = this.d.getString(R.string.view);
        String string2 = this.d.getString(R.string.view_host);
        String string3 = this.d.getString(R.string.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.d);
        builder.setTitle(R.string.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.I);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.I);
        }
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public final void a(com.baidu.adp.widget.ListView.b bVar) {
        this.C.a(bVar);
    }

    public final void a(AbsListView.OnScrollListener onScrollListener) {
        this.n.setOnScrollListener(onScrollListener);
    }

    public final void a(com.baidu.adp.widget.ListView.r rVar) {
        this.n.setOnSrollToBottomListener(rVar);
    }

    public final void a(com.baidu.adp.widget.ListView.t tVar) {
        this.n.setOnSrollToTopListener(tVar);
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.n.setOnItemClickListener(onItemClickListener);
    }

    public final void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.n.setOnItemLongClickListener(onItemLongClickListener);
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.I = onClickListener;
    }

    public final void a(String str) {
        this.d.showToast(str);
    }

    public final void k() {
        if (this.O != null) {
            this.O.a();
        }
        if (this.t != null) {
            this.t.setBackgroundDrawable(null);
        }
    }

    public final void c(boolean z) {
        this.c = z;
        if (z) {
            if (this.b != null) {
                this.k.setOnTouchListener(null);
                this.m.startAnimation(this.b);
                if (this.B == 1) {
                    this.l.setImageResource(R.drawable.pic_fresh_s_1);
                    return;
                } else {
                    this.l.setImageResource(R.drawable.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.k.setOnTouchListener(this.R);
        this.n.a();
        this.m.clearAnimation();
        if (this.B == 1) {
            this.l.setImageResource(R.drawable.pic_fresh_n_1);
        } else {
            this.l.setImageResource(R.drawable.pic_fresh_n);
        }
    }

    public final boolean l() {
        return this.c;
    }

    public final al m() {
        return this.o;
    }

    public final FrsHeaderView n() {
        return this.v;
    }

    public final com.baidu.tieba.view.ar o() {
        return this.w;
    }

    public final void b(String str) {
        this.p.setText(R.string.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.d.getString(R.string.frs_remind_noforum));
        if (this.B == 1) {
            this.r.setTextColor(this.d.getResources().getColor(R.color.noexit_create_tip_text_1));
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.d.getResources().getColor(R.color.noexit_create_bar_name_text_1)), 0, str.length(), 33);
            }
            this.s.setTextColor(this.d.getResources().getColor(R.color.noexit_create_tip2_text_1));
            this.t.setImageResource(R.drawable.individual_center_found_1);
        } else {
            this.r.setTextColor(-16777216);
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.d.getResources().getColor(R.color.noexit_create_bar_name_text)), 0, str.length(), 33);
            }
            this.t.setImageResource(R.drawable.individual_center_found);
        }
        this.q.setVisibility(0);
        this.r.setText(spannableString);
        this.h.setText(R.string.frs_create_forum);
        this.n.setVisibility(8);
        this.i.setVisibility(4);
        this.i.setClickable(false);
        this.k.setVisibility(4);
        this.A.setVisibility(8);
        this.z.setVisibility(8);
        this.F.setTouchModeAbove(2);
    }

    public final void p() {
        this.n.setVisibility(0);
    }

    public final void c(String str) {
        this.h.setText(String.valueOf(str) + this.d.getString(R.string.forum));
    }

    public final void q() {
        if (this.o != null) {
            this.o.notifyDataSetChanged();
        }
    }

    public final void r() {
        I();
        this.G = "normal_page";
        this.n.addHeaderView(this.v.c());
    }

    public final void s() {
        I();
        this.G = "frs_page";
        this.n.addHeaderView(this.w.c());
    }

    private void I() {
        if ("normal_page".equals(this.G)) {
            this.n.removeHeaderView(this.v.c());
        } else if ("frs_page".equals(this.G)) {
            this.n.removeHeaderView(this.w.c());
        } else if ("good_page".equals(this.G)) {
            this.n.removeHeaderView(this.x.a());
        }
    }

    public final void t() {
        if (this.v != null) {
            this.v.g().setVisibility(0);
        }
    }

    public final void u() {
        if (this.v != null) {
            this.v.g().setVisibility(8);
        }
    }

    public final void v() {
        if (this.w != null) {
            this.w.j().setVisibility(0);
        }
    }

    public final void w() {
        if (this.w != null) {
            this.w.j().setVisibility(8);
        }
    }

    public final boolean x() {
        if ("normal_page".equals(this.G)) {
            return this.v.d();
        }
        if ("frs_page".equals(this.G)) {
            return this.w.d();
        }
        return false;
    }

    public final boolean y() {
        if ("normal_page".equals(this.G)) {
            return this.v.e();
        }
        if ("frs_page".equals(this.G)) {
            return this.w.e();
        }
        return false;
    }

    public final void z() {
        this.n.setAdapter((ListAdapter) this.o);
    }

    public final void d(boolean z) {
        this.o.b(z);
    }

    public final void e(boolean z) {
        this.o.c(z);
    }

    public final void A() {
        this.u.show();
    }

    public final void a(ArrayList<com.baidu.tieba.data.az> arrayList) {
        this.o.a(arrayList);
        if (arrayList == null || arrayList.size() <= 0) {
            this.p.setText(R.string.frs_nodata);
            this.p.setVisibility(0);
            return;
        }
        this.p.setVisibility(8);
    }

    public final View d(String str) {
        return this.n.findViewWithTag(str);
    }

    public final View a(int i) {
        return this.n.findViewById(R.id.open_timer);
    }

    public final BdListView B() {
        return this.n;
    }

    public final void b(int i) {
        if (i > 1) {
            this.o.d(true);
        } else {
            this.o.d(false);
        }
    }

    public final void c(int i) {
        if (i == 1) {
            this.o.e(true);
        } else {
            this.o.e(false);
        }
    }

    public final void C() {
        this.o.b(false);
        this.o.c(false);
        this.o.notifyDataSetInvalidated();
    }

    public final void d(int i) {
        this.n.setSelection(i);
    }

    public final void a(ForumData forumData, com.baidu.tieba.model.z zVar) {
        if (this.w != null) {
            this.w.a(forumData, zVar);
        }
        this.w.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.w.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.w.a(false);
        }
    }

    public final void a(int i, int i2, ForumData forumData, com.baidu.tieba.model.z zVar) {
        this.w.a(forumData, zVar);
        this.w.c(i);
        if (this.M >= 0 && i2 > 0 && this.w.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.w.a(forumData, zVar);
            this.w.a(k(i2));
            this.w.a(this.w.f());
        }
    }

    public final void e(int i) {
        this.w.c(1);
    }

    public final void a(int i, ForumData forumData, com.baidu.tieba.model.z zVar, boolean z) {
        if (this.w != null) {
            this.w.a(forumData, zVar);
        }
        this.w.a(1, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
        if (forumData.getSignData().getForumRank() == -2) {
            this.w.a(false);
        }
    }

    public final void a(ForumData forumData) {
        if (J() && forumData.getFrsBannerData() != null && !this.N && !TextUtils.isEmpty(forumData.getFrsBannerData().b())) {
            this.O.setData(forumData.getFrsBannerData());
            this.n.addHeaderView(this.O);
            this.N = true;
        }
    }

    public final void D() {
        if (this.N) {
            this.n.removeHeaderView(this.O);
        }
    }

    public final void b(ForumData forumData, com.baidu.tieba.model.z zVar) {
        if (this.v != null) {
            this.v.a(forumData, zVar);
        }
        this.v.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.v.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.v.a(false);
        }
    }

    public final void f(int i) {
        this.v.c(1);
    }

    public final void b(int i, int i2, ForumData forumData, com.baidu.tieba.model.z zVar) {
        this.v.a(forumData, zVar);
        this.v.c(i);
        if (this.M >= 0 && i2 > 0 && this.v.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.v.a(forumData, zVar);
            this.v.a(k(i2));
            this.v.a(this.v.f());
        }
    }

    public final void b(int i, ForumData forumData, com.baidu.tieba.model.z zVar, boolean z) {
        if (this.v != null) {
            this.v.a(forumData, zVar);
        }
        if (forumData != null) {
            this.v.a(1, forumData.getLevelName(), forumData.getUser_level(), b(forumData), true);
            if (forumData.getSignData().getForumRank() == -2) {
                this.v.a(false);
            }
        }
    }

    public final void g(int i) {
        if (this.v != null) {
            this.v.b(0);
        }
    }

    public final void h(int i) {
        if (this.w != null) {
            this.w.b(0);
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.K = forumData.getLevelupScore();
        this.L = forumData.getCurScore();
        this.M = this.K - this.L;
        if (this.K > 0) {
            return this.L / this.K;
        }
        return 0.0f;
    }

    private float k(int i) {
        if (this.M < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.M) {
            return 1.0f;
        }
        return (this.L + i) / this.K;
    }

    public final void a(View view) {
        if (this.v != null) {
            this.v.a(view);
        }
    }

    public final void b(View view) {
        if (this.w != null) {
            this.w.a(view);
        }
    }

    public final void E() {
        if (this.E != null) {
            this.E.dismiss();
        }
        this.o.a().c();
        this.w.a().c();
    }

    public final void F() {
        if (this.P != null && this.J != null) {
            this.P.b(this.J);
        }
    }

    public final void a(ArrayList<com.baidu.tieba.data.z> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (!"good_page".equals(this.G)) {
            I();
            this.G = "good_page";
            this.n.addHeaderView(this.x.a());
        }
        if (this.y == null) {
            this.y = new au(this.d, arrayList);
            this.x.a(this.y);
            this.x.a(onItemClickListener);
            this.D.a(R.id.show_good);
            return;
        }
        this.y.a(arrayList);
        this.y.notifyDataSetChanged();
        this.D.a(R.id.show_good);
    }

    public final void i(int i) {
        if (this.y != null) {
            this.y.a(i);
        }
    }

    public final void a(com.baidu.tieba.model.ae aeVar) {
        this.D.a(aeVar);
        long a = aeVar.a() + aeVar.b();
        boolean z = TiebaApplication.g().ae() == 1;
        if (a > 0 && this.A.getVisibility() == 0) {
            this.z.setVisibility(0);
            if (a < 10) {
                this.z.setText(String.valueOf(a));
                this.z.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.z.setText(String.valueOf(a));
                this.z.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
                return;
            } else {
                this.z.setText("   ");
                this.z.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
                return;
            }
        }
        this.z.setVisibility(8);
    }

    public final void j(int i) {
        this.B = i;
        this.w.a(i);
        if (this.C != null) {
            this.C.a(i);
        }
        if (this.o != null) {
            this.o.e();
            this.o.notifyDataSetChanged();
        }
        if (this.y != null) {
            this.y.notifyDataSetChanged();
        }
        this.x.a(i);
        this.D.b(i);
        this.v.a(i);
        if (this.d instanceof FrsActivity) {
            ((FrsActivity) this.d).g();
        }
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a(this.e);
        this.Q.b(i);
        if (this.P != null) {
            this.P.a(i);
        }
    }

    public final void G() {
        this.e.removeView(this.f);
        this.f = null;
    }

    public final void f(boolean z) {
        if (z) {
            this.l.setAlpha(128);
            this.m.setAlpha(128);
            return;
        }
        this.l.setAlpha(MotionEventCompat.ACTION_MASK);
        this.m.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public final void H() {
        this.n.b();
    }

    private static boolean J() {
        long aS = TiebaApplication.g().aS();
        if (aS == 0) {
            return true;
        }
        try {
            return cd.a(cd.a(), new Date(aS)) >= 72;
        } catch (Exception e) {
            return true;
        }
    }

    public final void g(boolean z) {
        this.D.a(z);
    }
}
