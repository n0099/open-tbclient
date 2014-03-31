package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public final class cm {
    private com.baidu.tieba.frs.view.f A;
    private TextView C;
    private View D;
    private com.baidu.tbadk.core.view.i E;
    private View F;
    private View G;
    private View H;
    private View I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private TextView N;
    private ImageView O;
    private com.baidu.tbadk.core.view.q P;
    private df Q;
    private SlidingMenu S;
    private View.OnClickListener U;
    private int X;
    private int Y;
    private int Z;
    private com.baidu.tieba.frs.view.a ab;
    private NoNetworkView ac;
    private NavigationBar ad;
    private View ae;
    Animation b;
    public PbEditor c;
    View d;
    private com.baidu.tbadk.a f;
    private RelativeLayout g;
    private ImageView k;
    private View l;
    private Button m;
    private FrameLayout n;
    private ImageView o;
    private ImageView p;
    private BdListView q;
    private ay r;
    private TextView s;
    private LinearLayout t;
    private TextView u;
    private TextView v;
    private ImageView w;
    private AlertDialog x;
    private FrsHeaderView y;
    private com.baidu.tieba.frs.view.n z;
    private boolean e = false;
    private FrameLayout h = null;
    private ImageView i = null;
    private TextView j = null;
    private bm B = null;
    private int M = 0;
    private com.baidu.tieba.view.t R = null;
    private String T = null;
    AlertDialog a = null;
    private DialogInterface.OnClickListener V = null;
    private com.baidu.tbadk.core.view.m W = null;
    private boolean aa = false;
    private View.OnTouchListener af = new cn(this);

    public cm(com.baidu.tbadk.a aVar, View.OnClickListener onClickListener) {
        this.f = null;
        this.g = null;
        this.k = null;
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
        this.y = null;
        this.z = null;
        this.A = null;
        this.C = null;
        this.D = null;
        this.P = null;
        this.Q = null;
        this.S = null;
        this.b = null;
        this.U = null;
        this.ab = null;
        this.d = null;
        this.f = aVar;
        this.U = onClickListener;
        this.f.setContentView(com.baidu.tieba.a.i.frs_activity);
        this.Q = new df(this.f);
        this.g = (RelativeLayout) this.f.findViewById(com.baidu.tieba.a.h.frs);
        this.ab = new com.baidu.tieba.frs.view.a(this.f);
        this.ab.setLayoutParams(new AbsListView.LayoutParams(-1, this.f.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_banner_height)));
        this.ab.setVisibility(8);
        this.ab.setBannerCloseListener(new co(this));
        this.S = new SlidingMenu(this.f);
        this.S.setMode(1);
        this.S.setTouchModeAbove(1);
        this.S.setBehindOffset(com.baidu.adp.lib.util.i.a((Context) this.f, 48.0f));
        this.S.setBehindScrollScale(0.5f);
        this.S.setFadeDegree(0.35f);
        this.S.attachToActivity(this.f, 1);
        this.S.setMenu(this.Q.a());
        this.ad = (NavigationBar) this.f.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.l = this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ae = this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.a.i.frs_icon_bottom_title, (View.OnClickListener) null);
        this.N = (TextView) this.ae.findViewById(com.baidu.tieba.a.h.navigationTitle_frs);
        this.O = (ImageView) this.ae.findViewById(com.baidu.tieba.a.h.icon_bottom_title_image);
        this.ae.setOnClickListener(this.U);
        this.d = this.f.getLayoutInflater().inflate(com.baidu.tieba.a.i.frs_pop_more_window, (ViewGroup) null);
        this.E = new com.baidu.tbadk.core.view.i(this.f, this.d, this.ad, this.f.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n), new cr(this));
        this.F = this.d.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_all_threads_layout);
        this.F.setOnClickListener(this.U);
        this.J = (ImageView) this.d.findViewById(com.baidu.tieba.a.h.choose_all_threads);
        this.J.setVisibility(0);
        this.G = this.d.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_good_threads_layout);
        this.G.setOnClickListener(this.U);
        this.K = (ImageView) this.d.findViewById(com.baidu.tieba.a.h.choose_good_threads);
        this.H = this.d.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_image_threads_layout);
        this.H.setOnClickListener(this.U);
        this.L = (ImageView) this.d.findViewById(com.baidu.tieba.a.h.choose_image_threads);
        this.I = this.d.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_add_shortcut_layout);
        this.I.setOnClickListener(this.U);
        this.k = (ImageView) this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.widget_nb_item_edit, this.U);
        View a = this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.nb_item_frs_more, (View.OnClickListener) null);
        this.D = a.findViewById(com.baidu.tieba.a.h.frs_top_more);
        this.D.setOnClickListener(this.U);
        this.C = (TextView) a.findViewById(com.baidu.tieba.a.h.frs_more_mes_text);
        this.n = (FrameLayout) this.f.findViewById(com.baidu.tieba.a.h.refresh_layout);
        this.o = (ImageView) this.f.findViewById(com.baidu.tieba.a.h.refresh_bg);
        this.p = (ImageView) this.f.findViewById(com.baidu.tieba.a.h.refresh_icon);
        String[] strArr = {this.f.getString(com.baidu.tieba.a.k.take_photo), this.f.getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f);
        builder.setTitle(this.f.getString(com.baidu.tieba.a.k.operation));
        builder.setItems(strArr, new cp(this));
        if (this.x == null) {
            this.x = builder.create();
            this.x.setCanceledOnTouchOutside(true);
        }
        this.q = (BdListView) this.f.findViewById(com.baidu.tieba.a.h.frs_lv_thread);
        this.P = new com.baidu.tbadk.core.view.q(this.f);
        this.q.setPullRefresh(this.P);
        this.q.setDivider(null);
        this.q.setDividerHeight(0);
        this.q.setRecyclerListener(new cq(this));
        com.baidu.tbadk.a aVar2 = this.f;
        FrsHeaderView.PAGE page = FrsHeaderView.PAGE.FRS_LIST;
        this.y = new FrsHeaderView(aVar2, null, null);
        this.z = new com.baidu.tieba.frs.view.n(this.f, null, null);
        this.A = new com.baidu.tieba.frs.view.f(this.f);
        this.r = new ay(this.f, null, com.baidu.adp.lib.util.i.b(this.f), com.baidu.tbadk.core.util.bd.a().b());
        this.b = AnimationUtils.loadAnimation(this.f, com.baidu.tieba.a.b.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.w = (ImageView) this.f.findViewById(com.baidu.tieba.a.h.frs_noexit_image);
        this.s = (TextView) this.f.findViewById(com.baidu.tieba.a.h.frs_noexist);
        this.s.setVisibility(8);
        this.u = (TextView) this.f.findViewById(com.baidu.tieba.a.h.frs_noexist_text);
        this.v = (TextView) this.f.findViewById(com.baidu.tieba.a.h.frs_noexit_remind_create_text);
        this.t = (LinearLayout) this.f.findViewById(com.baidu.tieba.a.h.frs_noexist_layout);
        this.m = (Button) this.f.findViewById(com.baidu.tieba.a.h.frs_bt_create);
        this.Q.a(this.U);
        this.n.setOnClickListener(this.U);
        this.y.a(this.U);
        this.z.a(this.U);
        this.m.setOnClickListener(this.U);
        this.n.setOnTouchListener(this.af);
        this.ac = (NoNetworkView) this.f.findViewById(com.baidu.tieba.a.h.view_no_network);
        c(false);
        this.c = (PbEditor) this.f.findViewById(com.baidu.tieba.a.h.frs_editor);
    }

    public final void a() {
        if (this.E != null) {
            this.f.getLayoutMode().a(this.d);
            this.E.showAsDropDown(this.ad, 0, 0);
        }
    }

    public final void b() {
        this.E.dismiss();
    }

    public final View c() {
        return this.ae;
    }

    public final View d() {
        return this.F;
    }

    public final View e() {
        return this.G;
    }

    public final View f() {
        return this.H;
    }

    public final View g() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImageView h() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImageView i() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View j() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View k() {
        return this.l;
    }

    public final boolean l() {
        if ("normal_page".equals(this.T)) {
            return this.y.h();
        }
        if ("frs_page".equals(this.T)) {
            return this.z.g();
        }
        return false;
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.W = mVar;
        if (this.ac != null) {
            this.ac.a(this.W);
        }
    }

    public final void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.S.setOnClosedListener(onClosedListener);
    }

    public final void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.S.setOnOpenedListener(onOpenedListener);
    }

    public final df m() {
        return this.Q;
    }

    public final SlidingMenu n() {
        return this.S;
    }

    public final void a(boolean z) {
        this.S.showMenu(true);
    }

    public final void o() {
        this.ac.setVisibility(0);
    }

    public final void p() {
        this.ac.setVisibility(8);
    }

    public final NoNetworkView q() {
        return this.ac;
    }

    public final void b(boolean z) {
        String string = this.f.getString(com.baidu.tieba.a.k.view);
        String string2 = this.f.getString(com.baidu.tieba.a.k.view_host);
        String string3 = this.f.getString(com.baidu.tieba.a.k.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f);
        builder.setTitle(com.baidu.tieba.a.k.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.V);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.V);
        }
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.P.a(dVar);
    }

    public final void a(AbsListView.OnScrollListener onScrollListener) {
        this.q.setOnScrollListener(onScrollListener);
    }

    public final void a(com.baidu.adp.widget.ListView.t tVar) {
        this.q.setOnSrollToBottomListener(tVar);
    }

    public final void a(com.baidu.adp.widget.ListView.v vVar) {
        this.q.setOnSrollToTopListener(vVar);
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.q.setOnItemClickListener(onItemClickListener);
    }

    public final void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.q.setOnItemLongClickListener(onItemLongClickListener);
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.V = onClickListener;
    }

    public final void a(String str) {
        this.f.showToast(str);
    }

    public final void r() {
        if (this.ab != null) {
            this.ab.a();
        }
        if (this.w != null) {
            this.w.setBackgroundDrawable(null);
        }
    }

    public final void c(boolean z) {
        this.e = z;
        if (z) {
            if (this.b != null) {
                this.n.setOnTouchListener(null);
                this.p.startAnimation(this.b);
                if (this.M == 1) {
                    this.o.setImageResource(com.baidu.tieba.a.g.pic_fresh_s_1);
                    return;
                } else {
                    this.o.setImageResource(com.baidu.tieba.a.g.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.n.setOnTouchListener(this.af);
        this.q.b();
        this.p.clearAnimation();
        if (this.M == 1) {
            this.o.setImageResource(com.baidu.tieba.a.g.pic_fresh_n_1);
        } else {
            this.o.setImageResource(com.baidu.tieba.a.g.pic_fresh_n);
        }
    }

    public final boolean s() {
        return this.e;
    }

    public final ay t() {
        return this.r;
    }

    public final FrsHeaderView u() {
        return this.y;
    }

    public final com.baidu.tieba.frs.view.n v() {
        return this.z;
    }

    public final void b(String str) {
        this.s.setText(com.baidu.tieba.a.k.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.f.getString(com.baidu.tieba.a.k.frs_remind_noforum));
        if (this.M == 1) {
            this.u.setTextColor(this.f.getResources().getColor(com.baidu.tieba.a.e.noexit_create_tip_text_1));
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.f.getResources().getColor(com.baidu.tieba.a.e.noexit_create_bar_name_text_1)), 0, str.length(), 33);
            }
            this.v.setTextColor(this.f.getResources().getColor(com.baidu.tieba.a.e.noexit_create_tip2_text_1));
            this.w.setImageResource(com.baidu.tieba.a.g.individual_center_found_1);
        } else {
            this.u.setTextColor(-16777216);
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.f.getResources().getColor(com.baidu.tieba.a.e.noexit_create_bar_name_text)), 0, str.length(), 33);
            }
            this.w.setImageResource(com.baidu.tieba.a.g.individual_center_found);
        }
        this.t.setVisibility(0);
        this.u.setText(spannableString);
        this.N.setText(com.baidu.tieba.a.k.frs_create_forum);
        this.O.setVisibility(8);
        this.ae.setClickable(false);
        this.q.setVisibility(8);
        this.k.setVisibility(4);
        this.k.setClickable(false);
        this.n.setVisibility(4);
        this.D.setVisibility(8);
        this.C.setVisibility(8);
        this.S.setTouchModeAbove(2);
    }

    public final void w() {
        this.q.setVisibility(0);
    }

    public final void c(String str) {
        this.N.setText(String.valueOf(str) + this.f.getString(com.baidu.tieba.a.k.forum));
        this.O.setVisibility(0);
    }

    public final void x() {
        if (this.r != null) {
            this.r.notifyDataSetChanged();
        }
    }

    public final void y() {
        U();
        this.T = "normal_page";
        this.q.addHeaderView(this.y.c());
    }

    public final void z() {
        U();
        this.T = "frs_page";
        this.q.addHeaderView(this.z.c());
    }

    private void U() {
        if ("normal_page".equals(this.T)) {
            this.q.removeHeaderView(this.y.c());
        } else if ("frs_page".equals(this.T)) {
            this.q.removeHeaderView(this.z.c());
        } else if ("good_page".equals(this.T)) {
            this.q.removeHeaderView(this.A.a());
        }
    }

    public final void A() {
        if (this.y != null) {
            this.y.g().setVisibility(0);
        }
    }

    public final void B() {
        if (this.y != null) {
            this.y.g().setVisibility(8);
        }
    }

    public final void C() {
        if (this.z != null) {
            this.z.j().setVisibility(0);
        }
    }

    public final void D() {
        if (this.z != null) {
            this.z.j().setVisibility(8);
        }
    }

    public final boolean E() {
        if ("normal_page".equals(this.T)) {
            return this.y.d();
        }
        if ("frs_page".equals(this.T)) {
            return this.z.d();
        }
        return false;
    }

    public final boolean F() {
        if ("normal_page".equals(this.T)) {
            return this.y.e();
        }
        if ("frs_page".equals(this.T)) {
            return this.z.e();
        }
        return false;
    }

    public final void G() {
        this.q.setAdapter((ListAdapter) this.r);
    }

    public final void d(boolean z) {
        this.r.b(z);
    }

    public final void e(boolean z) {
        this.r.c(z);
    }

    public final void H() {
        this.x.show();
    }

    public final void a(ArrayList<com.baidu.tbadk.core.data.o> arrayList, g gVar) {
        this.r.a(arrayList, gVar);
        if (arrayList == null || arrayList.size() <= 0) {
            this.s.setText(com.baidu.tieba.a.k.frs_nodata);
            this.s.setVisibility(0);
            return;
        }
        this.s.setVisibility(8);
    }

    public final View d(String str) {
        return this.q.findViewWithTag(str);
    }

    public final View a(int i) {
        return this.q.findViewById(i);
    }

    public final BdListView I() {
        return this.q;
    }

    public final void b(int i) {
        if (i > 1) {
            this.r.d(true);
        } else {
            this.r.d(false);
        }
    }

    public final void c(int i) {
        if (i == 1) {
            this.r.e(true);
        } else {
            this.r.e(false);
        }
    }

    public final void J() {
        this.r.b(false);
        this.r.c(false);
        this.r.notifyDataSetInvalidated();
    }

    public final void d(int i) {
        this.q.setSelection(i);
    }

    public final void a(ForumData forumData, g gVar) {
        if (this.z != null) {
            this.z.a(forumData, gVar);
        }
        this.z.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.z.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.z.a(false);
        }
    }

    public final void a(int i, int i2, ForumData forumData, g gVar) {
        this.z.a(forumData, gVar);
        this.z.c(i);
        if (this.Z >= 0 && i2 > 0 && this.z.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.z.a(forumData, gVar);
            this.z.a(k(i2));
            this.z.a(this.z.f());
        }
    }

    public final void e(int i) {
        this.z.c(1);
    }

    public final void a(int i, ForumData forumData, g gVar, boolean z) {
        if (this.z != null) {
            this.z.a(forumData, gVar);
        }
        this.z.a(1, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
        if (forumData.getSignData().getForumRank() == -2) {
            this.z.a(false);
        }
    }

    public final void a(ForumData forumData) {
        if (V() && forumData.getFrsBannerData() != null && !this.aa && !TextUtils.isEmpty(forumData.getFrsBannerData().b())) {
            this.ab.setData(forumData.getFrsBannerData());
            this.q.addHeaderView(this.ab);
            this.aa = true;
        }
    }

    public final void K() {
        if (this.aa) {
            this.q.removeHeaderView(this.ab);
        }
    }

    public final void b(ForumData forumData, g gVar) {
        if (this.y != null) {
            this.y.a(forumData, gVar);
        }
        this.y.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.y.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.y.a(false);
        }
    }

    public final void f(int i) {
        this.y.c(1);
    }

    public final void b(int i, int i2, ForumData forumData, g gVar) {
        this.y.a(forumData, gVar);
        this.y.c(i);
        if (this.Z >= 0 && i2 > 0 && this.y.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.y.a(forumData, gVar);
            this.y.a(k(i2));
            this.y.a(this.y.f());
        }
    }

    public final void b(int i, ForumData forumData, g gVar, boolean z) {
        if (this.y != null) {
            this.y.a(forumData, gVar);
        }
        if (forumData != null) {
            this.y.a(1, forumData.getLevelName(), forumData.getUser_level(), b(forumData), true);
            if (forumData.getSignData().getForumRank() == -2) {
                this.y.a(false);
            }
        }
    }

    public final void g(int i) {
        if (this.y != null) {
            this.y.b(0);
        }
    }

    public final void h(int i) {
        if (this.z != null) {
            this.z.b(0);
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.X = forumData.getLevelupScore();
        this.Y = forumData.getCurScore();
        this.Z = this.X - this.Y;
        if (this.X > 0) {
            return this.Y / this.X;
        }
        return 0.0f;
    }

    private float k(int i) {
        if (this.Z < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.Z) {
            return 1.0f;
        }
        return (this.Y + i) / this.X;
    }

    public final void a(View view) {
        if (this.y != null) {
            this.y.a(view);
        }
    }

    public final void b(View view) {
        if (this.z != null) {
            this.z.a(view);
        }
    }

    public final void L() {
        if (this.R != null) {
            this.R.dismiss();
        }
        this.r.a().c();
        this.z.a().c();
    }

    public final void M() {
        if (this.ac != null && this.W != null) {
            this.ac.b(this.W);
        }
    }

    public final void a(ArrayList<com.baidu.tbadk.core.data.g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (!"good_page".equals(this.T)) {
            U();
            this.T = "good_page";
            this.q.addHeaderView(this.A.a());
        }
        if (this.B == null) {
            this.B = new bm(this.f, arrayList);
            this.A.a(this.B);
            this.A.a(onItemClickListener);
            return;
        }
        this.B.a(arrayList);
        this.B.notifyDataSetChanged();
    }

    public final void i(int i) {
        if (this.B != null) {
            this.B.a(i);
        }
    }

    public final void a(cu cuVar) {
        this.Q.a(cuVar);
        long a = cuVar.a() + cuVar.b();
        boolean z = TbadkApplication.j().l() == 1;
        if (a > 0 && this.D.getVisibility() == 0) {
            this.C.setVisibility(0);
            if (a < 10) {
                this.C.setText(String.valueOf(a));
                this.C.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_one_1 : com.baidu.tieba.a.g.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.C.setText(String.valueOf(a));
                this.C.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_two_1 : com.baidu.tieba.a.g.icon_news_head_prompt_two);
                return;
            } else {
                this.C.setText("   ");
                this.C.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_more_1 : com.baidu.tieba.a.g.icon_news_head_prompt_more);
                return;
            }
        }
        this.C.setVisibility(8);
    }

    public final void j(int i) {
        this.M = i;
        this.z.a(i);
        if (this.P != null) {
            this.P.a(i);
        }
        if (this.r != null) {
            this.r.e();
            this.r.notifyDataSetChanged();
        }
        if (this.B != null) {
            this.B.notifyDataSetChanged();
        }
        this.A.a(i);
        this.Q.a(i);
        this.y.a(i);
        if (this.f instanceof FrsActivity) {
            ((FrsActivity) this.f).g();
        }
        this.f.getLayoutMode().a(i == 1);
        this.f.getLayoutMode().a(this.g);
        this.ad.b(i);
        this.E.a(this.f, i, this.f.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n), this.f.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n_1));
        if (this.ac != null) {
            this.ac.a(i);
        }
        if (this.c != null) {
            this.c.c(i);
        }
    }

    public final void N() {
        this.g.removeView(this.h);
        this.h = null;
    }

    public final void f(boolean z) {
        if (z) {
            this.o.setAlpha(128);
            this.p.setAlpha(128);
            return;
        }
        this.o.setAlpha(MotionEventCompat.ACTION_MASK);
        this.p.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public final void O() {
        this.q.c();
    }

    private static boolean V() {
        com.baidu.tieba.r.c();
        long J = com.baidu.tieba.r.J();
        if (J == 0) {
            return true;
        }
        try {
            return com.baidu.tbadk.core.util.bf.a(com.baidu.tbadk.core.util.bf.a(), new Date(J)) >= 72;
        } catch (Exception e) {
            return true;
        }
    }

    public final void g(boolean z) {
        this.Q.a(z);
    }

    public final void P() {
        this.c.b(this.c.getEditText());
        this.c.m();
    }

    public final void a(int i, int i2) {
        this.c.l();
        if (this.c.h()) {
            this.c.j();
        } else {
            this.c.getEditText().requestFocus();
            this.c.a(this.c.getEditText());
        }
        new Handler().postDelayed(new cs(this, i, i2), 300L);
    }

    public final void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.c.c.a(writeImagesInfo, z);
    }

    public final void Q() {
        this.f.showProgressBar();
    }

    public final void h(boolean z) {
        this.f.hideProgressBar();
        if (z) {
            this.c.getEditText().setText("");
            this.c.b();
            this.c.k();
        }
    }

    public final void e(String str) {
        this.c.setContent(str);
    }

    public final ImageView R() {
        return this.J;
    }

    public final ImageView S() {
        return this.K;
    }

    public final ImageView T() {
        return this.L;
    }
}
