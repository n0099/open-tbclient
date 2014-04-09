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
    private com.baidu.tieba.frs.view.n A;
    private com.baidu.tieba.frs.view.f B;
    private TextView D;
    private View E;
    private com.baidu.tbadk.core.view.i F;
    private View G;
    private View H;
    private View I;
    private View J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private TextView O;
    private ImageView P;
    private com.baidu.tbadk.core.view.q Q;
    private dh R;
    private SlidingMenu T;
    private View.OnClickListener V;
    private int Y;
    private int Z;
    private int aa;
    private com.baidu.tieba.frs.view.a ac;
    private NoNetworkView ad;
    private NavigationBar ae;
    private View af;
    private boolean ag;
    private Handler ah;
    Animation b;
    public PbEditor c;
    View e;
    private com.baidu.tbadk.a g;
    private RelativeLayout h;
    private ImageView l;
    private View m;
    private Button n;
    private FrameLayout o;
    private ImageView p;
    private ImageView q;
    private BdListView r;
    private ay s;
    private TextView t;
    private LinearLayout u;
    private TextView v;
    private TextView w;
    private ImageView x;
    private AlertDialog y;
    private FrsHeaderView z;
    private boolean f = false;
    private FrameLayout i = null;
    private ImageView j = null;
    private TextView k = null;
    private bm C = null;
    private int N = 0;
    private com.baidu.tieba.view.r S = null;
    private String U = null;
    AlertDialog a = null;
    private DialogInterface.OnClickListener W = null;
    private com.baidu.tbadk.core.view.m X = null;
    private boolean ab = false;
    final Runnable d = new cn(this);
    private View.OnTouchListener ai = new co(this);

    public cm(com.baidu.tbadk.a aVar, View.OnClickListener onClickListener) {
        this.g = null;
        this.h = null;
        this.l = null;
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
        this.B = null;
        this.D = null;
        this.E = null;
        this.Q = null;
        this.R = null;
        this.T = null;
        this.b = null;
        this.V = null;
        this.ac = null;
        this.ag = false;
        this.ah = null;
        this.e = null;
        this.g = aVar;
        this.V = onClickListener;
        this.ah = new Handler();
        this.g.setContentView(com.baidu.tieba.a.i.frs_activity);
        this.R = new dh(this.g);
        this.h = (RelativeLayout) this.g.findViewById(com.baidu.tieba.a.h.frs);
        this.ac = new com.baidu.tieba.frs.view.a(this.g);
        this.ac.setLayoutParams(new AbsListView.LayoutParams(-1, this.g.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.frs_header_banner_height)));
        this.ac.setVisibility(8);
        this.ac.setBannerCloseListener(new cp(this));
        this.T = new SlidingMenu(this.g);
        this.T.setMode(1);
        this.T.setTouchModeAbove(1);
        this.T.setBehindOffset(com.baidu.adp.lib.util.i.a((Context) this.g, 48.0f));
        this.T.setBehindScrollScale(0.5f);
        this.T.setFadeDegree(0.35f);
        this.T.attachToActivity(this.g, 1);
        this.T.setMenu(this.R.a());
        this.ae = (NavigationBar) this.g.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.m = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.af = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.a.i.frs_icon_bottom_title, (View.OnClickListener) null);
        this.O = (TextView) this.af.findViewById(com.baidu.tieba.a.h.navigationTitle_frs);
        this.P = (ImageView) this.af.findViewById(com.baidu.tieba.a.h.icon_bottom_title_image);
        this.af.setOnClickListener(this.V);
        this.e = this.g.getLayoutInflater().inflate(com.baidu.tieba.a.i.frs_pop_more_window, (ViewGroup) null);
        this.F = new com.baidu.tbadk.core.view.i(this.g, this.e, this.ae, this.g.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n), new cs(this));
        this.G = this.e.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_all_threads_layout);
        this.G.setOnClickListener(this.V);
        this.K = (ImageView) this.e.findViewById(com.baidu.tieba.a.h.choose_all_threads);
        this.K.setVisibility(0);
        this.H = this.e.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_good_threads_layout);
        this.H.setOnClickListener(this.V);
        this.L = (ImageView) this.e.findViewById(com.baidu.tieba.a.h.choose_good_threads);
        this.I = this.e.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_image_threads_layout);
        this.I.setOnClickListener(this.V);
        this.M = (ImageView) this.e.findViewById(com.baidu.tieba.a.h.choose_image_threads);
        this.J = this.e.findViewById(com.baidu.tieba.a.h.frs_pop_more_window_add_shortcut_layout);
        this.J.setOnClickListener(this.V);
        this.l = (ImageView) this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.widget_nb_item_edit, this.V);
        View a = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.a.i.nb_item_frs_more, (View.OnClickListener) null);
        this.E = a.findViewById(com.baidu.tieba.a.h.frs_top_more);
        this.E.setOnClickListener(this.V);
        this.D = (TextView) a.findViewById(com.baidu.tieba.a.h.frs_more_mes_text);
        this.o = (FrameLayout) this.g.findViewById(com.baidu.tieba.a.h.refresh_layout);
        this.p = (ImageView) this.g.findViewById(com.baidu.tieba.a.h.refresh_bg);
        this.q = (ImageView) this.g.findViewById(com.baidu.tieba.a.h.refresh_icon);
        String[] strArr = {this.g.getString(com.baidu.tieba.a.k.take_photo), this.g.getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(this.g.getString(com.baidu.tieba.a.k.operation));
        builder.setItems(strArr, new cq(this));
        if (this.y == null) {
            this.y = builder.create();
            this.y.setCanceledOnTouchOutside(true);
        }
        this.r = (BdListView) this.g.findViewById(com.baidu.tieba.a.h.frs_lv_thread);
        this.Q = new com.baidu.tbadk.core.view.q(this.g);
        this.r.setPullRefresh(this.Q);
        this.r.setDivider(null);
        this.r.setDividerHeight(0);
        this.r.setRecyclerListener(new cr(this));
        com.baidu.tbadk.a aVar2 = this.g;
        FrsHeaderView.PAGE page = FrsHeaderView.PAGE.FRS_LIST;
        this.z = new FrsHeaderView(aVar2, null, null);
        this.A = new com.baidu.tieba.frs.view.n(this.g, null, null);
        this.B = new com.baidu.tieba.frs.view.f(this.g);
        this.s = new ay(this.g, null, com.baidu.adp.lib.util.i.b(this.g), com.baidu.tbadk.core.util.bd.a().b());
        this.b = AnimationUtils.loadAnimation(this.g, com.baidu.tieba.a.b.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.x = (ImageView) this.g.findViewById(com.baidu.tieba.a.h.frs_noexit_image);
        this.t = (TextView) this.g.findViewById(com.baidu.tieba.a.h.frs_noexist);
        this.t.setVisibility(8);
        this.v = (TextView) this.g.findViewById(com.baidu.tieba.a.h.frs_noexist_text);
        this.w = (TextView) this.g.findViewById(com.baidu.tieba.a.h.frs_noexit_remind_create_text);
        this.u = (LinearLayout) this.g.findViewById(com.baidu.tieba.a.h.frs_noexist_layout);
        this.n = (Button) this.g.findViewById(com.baidu.tieba.a.h.frs_bt_create);
        this.R.a(this.V);
        this.o.setOnClickListener(this.V);
        this.z.a(this.V);
        this.A.a(this.V);
        this.n.setOnClickListener(this.V);
        this.o.setOnTouchListener(this.ai);
        this.ad = (NoNetworkView) this.g.findViewById(com.baidu.tieba.a.h.view_no_network);
        c(false);
        this.c = (PbEditor) this.g.findViewById(com.baidu.tieba.a.h.frs_editor);
        this.ag = TbadkApplication.j().ac();
        if (this.ag) {
            TbadkApplication.j().f(false);
            this.ah.postDelayed(this.d, 2000L);
        }
    }

    public final void a() {
        if (this.F != null) {
            this.g.getLayoutMode().a(this.e);
            this.F.showAsDropDown(this.ae, 0, 0);
        }
    }

    public final void b() {
        this.F.dismiss();
    }

    public final void c() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.ae).a(0).b(false);
        gVar.a(new ct(this));
        gVar.a().a(this.g);
    }

    public final View d() {
        return this.af;
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

    public final View h() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImageView i() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImageView j() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View k() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View l() {
        return this.m;
    }

    public final boolean m() {
        if ("normal_page".equals(this.U)) {
            return this.z.h();
        }
        if ("frs_page".equals(this.U)) {
            return this.A.g();
        }
        return false;
    }

    public final void a(com.baidu.tbadk.core.view.m mVar) {
        this.X = mVar;
        if (this.ad != null) {
            this.ad.a(this.X);
        }
    }

    public final void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.T.setOnClosedListener(onClosedListener);
    }

    public final void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.T.setOnOpenedListener(onOpenedListener);
    }

    public final dh n() {
        return this.R;
    }

    public final SlidingMenu o() {
        return this.T;
    }

    public final void a(boolean z) {
        this.T.showMenu(true);
    }

    public final void p() {
        this.ad.setVisibility(0);
    }

    public final void q() {
        this.ad.setVisibility(8);
    }

    public final NoNetworkView r() {
        return this.ad;
    }

    public final void b(boolean z) {
        String string = this.g.getString(com.baidu.tieba.a.k.view);
        String string2 = this.g.getString(com.baidu.tieba.a.k.view_host);
        String string3 = this.g.getString(com.baidu.tieba.a.k.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(com.baidu.tieba.a.k.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.W);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.W);
        }
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public final void a(com.baidu.adp.widget.ListView.d dVar) {
        this.Q.a(dVar);
    }

    public final void a(AbsListView.OnScrollListener onScrollListener) {
        this.r.setOnScrollListener(onScrollListener);
    }

    public final void a(com.baidu.adp.widget.ListView.t tVar) {
        this.r.setOnSrollToBottomListener(tVar);
    }

    public final void a(com.baidu.adp.widget.ListView.v vVar) {
        this.r.setOnSrollToTopListener(vVar);
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.r.setOnItemClickListener(onItemClickListener);
    }

    public final void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.r.setOnItemLongClickListener(onItemLongClickListener);
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        this.W = onClickListener;
    }

    public final void a(String str) {
        this.g.showToast(str);
    }

    public final void s() {
        if (this.ac != null) {
            this.ac.a();
        }
        if (this.x != null) {
            this.x.setBackgroundDrawable(null);
        }
        if (this.z != null) {
            this.z.k();
        }
        if (this.A != null) {
            this.A.k();
        }
    }

    public final void c(boolean z) {
        this.f = z;
        if (z) {
            if (this.b != null) {
                this.o.setOnTouchListener(null);
                this.q.startAnimation(this.b);
                if (this.N == 1) {
                    this.p.setImageResource(com.baidu.tieba.a.g.pic_fresh_s_1);
                    return;
                } else {
                    this.p.setImageResource(com.baidu.tieba.a.g.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.o.setOnTouchListener(this.ai);
        this.r.b();
        this.q.clearAnimation();
        if (this.N == 1) {
            this.p.setImageResource(com.baidu.tieba.a.g.pic_fresh_n_1);
        } else {
            this.p.setImageResource(com.baidu.tieba.a.g.pic_fresh_n);
        }
    }

    public final boolean t() {
        return this.f;
    }

    public final ay u() {
        return this.s;
    }

    public final FrsHeaderView v() {
        return this.z;
    }

    public final com.baidu.tieba.frs.view.n w() {
        return this.A;
    }

    public final void b(String str) {
        this.t.setText(com.baidu.tieba.a.k.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.g.getString(com.baidu.tieba.a.k.frs_remind_noforum));
        if (this.N == 1) {
            this.v.setTextColor(this.g.getResources().getColor(com.baidu.tieba.a.e.noexit_create_tip_text_1));
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.g.getResources().getColor(com.baidu.tieba.a.e.noexit_create_bar_name_text_1)), 0, str.length(), 33);
            }
            this.w.setTextColor(this.g.getResources().getColor(com.baidu.tieba.a.e.noexit_create_tip2_text_1));
            this.x.setImageResource(com.baidu.tieba.a.g.individual_center_found_1);
        } else {
            this.v.setTextColor(-16777216);
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.g.getResources().getColor(com.baidu.tieba.a.e.noexit_create_bar_name_text)), 0, str.length(), 33);
            }
            this.x.setImageResource(com.baidu.tieba.a.g.individual_center_found);
        }
        this.u.setVisibility(0);
        this.v.setText(spannableString);
        this.O.setText(com.baidu.tieba.a.k.frs_create_forum);
        this.P.setVisibility(8);
        this.af.setClickable(false);
        this.r.setVisibility(8);
        this.l.setVisibility(4);
        this.l.setClickable(false);
        this.o.setVisibility(4);
        this.E.setVisibility(8);
        this.D.setVisibility(8);
        this.T.setTouchModeAbove(2);
    }

    public final void x() {
        this.r.setVisibility(0);
    }

    public final void c(String str) {
        this.O.setText(String.valueOf(str) + this.g.getString(com.baidu.tieba.a.k.forum));
        this.P.setVisibility(0);
    }

    public final void y() {
        if (this.s != null) {
            this.s.notifyDataSetChanged();
        }
    }

    public final void z() {
        V();
        this.U = "normal_page";
        this.r.addHeaderView(this.z.c());
    }

    public final void A() {
        V();
        this.U = "frs_page";
        this.r.addHeaderView(this.A.c());
    }

    private void V() {
        if ("normal_page".equals(this.U)) {
            this.r.removeHeaderView(this.z.c());
        } else if ("frs_page".equals(this.U)) {
            this.r.removeHeaderView(this.A.c());
        } else if ("good_page".equals(this.U)) {
            this.r.removeHeaderView(this.B.a());
        }
    }

    public final void B() {
        if (this.z != null) {
            this.z.g().setVisibility(0);
        }
    }

    public final void C() {
        if (this.z != null) {
            this.z.g().setVisibility(8);
        }
    }

    public final void D() {
        if (this.A != null) {
            this.A.j().setVisibility(0);
        }
    }

    public final void E() {
        if (this.A != null) {
            this.A.j().setVisibility(8);
        }
    }

    public final boolean F() {
        if ("normal_page".equals(this.U)) {
            return this.z.d();
        }
        if ("frs_page".equals(this.U)) {
            return this.A.d();
        }
        return false;
    }

    public final boolean G() {
        if ("normal_page".equals(this.U)) {
            return this.z.e();
        }
        if ("frs_page".equals(this.U)) {
            return this.A.e();
        }
        return false;
    }

    public final void H() {
        this.r.setAdapter((ListAdapter) this.s);
    }

    public final void d(boolean z) {
        this.s.b(z);
    }

    public final void e(boolean z) {
        this.s.c(z);
    }

    public final void I() {
        this.y.show();
    }

    public final void a(ArrayList<com.baidu.tbadk.core.data.o> arrayList, g gVar) {
        this.s.a(arrayList, gVar);
        if (arrayList == null || arrayList.size() <= 0) {
            this.t.setText(com.baidu.tieba.a.k.frs_nodata);
            this.t.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
    }

    public final View d(String str) {
        return this.r.findViewWithTag(str);
    }

    public final View a(int i) {
        return this.r.findViewById(i);
    }

    public final BdListView J() {
        return this.r;
    }

    public final void b(int i) {
        if (i > 1) {
            this.s.d(true);
        } else {
            this.s.d(false);
        }
    }

    public final void c(int i) {
        if (i == 1) {
            this.s.e(true);
        } else {
            this.s.e(false);
        }
    }

    public final void K() {
        this.s.b(false);
        this.s.c(false);
        this.s.notifyDataSetInvalidated();
    }

    public final void d(int i) {
        this.r.setSelection(i);
    }

    public final void a(ForumData forumData, g gVar) {
        if (this.A != null) {
            this.A.a(forumData, gVar);
        }
        this.A.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.A.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.A.a(false);
        }
    }

    public final void a(int i, int i2, ForumData forumData, g gVar) {
        this.A.a(forumData, gVar);
        this.A.c(i);
        if (this.aa >= 0 && i2 > 0 && this.A.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.A.a(forumData, gVar);
            this.A.a(k(i2));
            this.A.a(this.A.f());
        }
    }

    public final void e(int i) {
        this.A.c(1);
    }

    public final void a(int i, ForumData forumData, g gVar, boolean z) {
        if (this.A != null) {
            this.A.a(forumData, gVar);
        }
        this.A.a(1, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
        if (forumData.getSignData().getForumRank() == -2) {
            this.A.a(false);
        }
    }

    public final void a(ForumData forumData) {
        if (W() && forumData.getFrsBannerData() != null && !this.ab && !TextUtils.isEmpty(forumData.getFrsBannerData().b())) {
            this.ac.setData(forumData.getFrsBannerData());
            this.r.addHeaderView(this.ac);
            this.ab = true;
        }
    }

    public final void L() {
        if (this.ab) {
            this.r.removeHeaderView(this.ac);
        }
    }

    public final void b(ForumData forumData, g gVar) {
        if (this.z != null) {
            this.z.a(forumData, gVar);
        }
        this.z.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.z.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.z.a(false);
        }
    }

    public final void f(int i) {
        this.z.c(1);
    }

    public final void b(int i, int i2, ForumData forumData, g gVar) {
        this.z.a(forumData, gVar);
        this.z.c(i);
        if (this.aa >= 0 && i2 > 0 && this.z.e()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.z.a(forumData, gVar);
            this.z.a(k(i2));
            this.z.a(this.z.f());
        }
    }

    public final void b(int i, ForumData forumData, g gVar, boolean z) {
        if (this.z != null) {
            this.z.a(forumData, gVar);
        }
        if (forumData != null) {
            this.z.a(1, forumData.getLevelName(), forumData.getUser_level(), b(forumData), true);
            if (forumData.getSignData().getForumRank() == -2) {
                this.z.a(false);
            }
        }
    }

    public final void g(int i) {
        if (this.z != null) {
            this.z.b(0);
        }
    }

    public final void h(int i) {
        if (this.A != null) {
            this.A.b(0);
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.Y = forumData.getLevelupScore();
        this.Z = forumData.getCurScore();
        this.aa = this.Y - this.Z;
        if (this.Y > 0) {
            return this.Z / this.Y;
        }
        return 0.0f;
    }

    private float k(int i) {
        if (this.aa < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.aa) {
            return 1.0f;
        }
        return (this.Z + i) / this.Y;
    }

    public final void a(View view) {
        if (this.z != null) {
            this.z.a(view);
        }
    }

    public final void b(View view) {
        if (this.A != null) {
            this.A.a(view);
        }
    }

    public final void M() {
        if (this.S != null) {
            this.S.dismiss();
        }
        this.s.a().c();
        this.A.a().c();
    }

    public final void N() {
        if (this.ad != null && this.X != null) {
            this.ad.b(this.X);
        }
    }

    public final void a(ArrayList<com.baidu.tbadk.core.data.g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        if (!"good_page".equals(this.U)) {
            V();
            this.U = "good_page";
            this.r.addHeaderView(this.B.a());
        }
        if (this.C == null) {
            this.C = new bm(this.g, arrayList);
            this.B.a(this.C);
            this.B.a(onItemClickListener);
            return;
        }
        this.C.a(arrayList);
        this.C.notifyDataSetChanged();
    }

    public final void i(int i) {
        if (this.C != null) {
            this.C.a(i);
        }
    }

    public final void a(cw cwVar) {
        this.R.a(cwVar);
        long a = cwVar.a() + cwVar.b();
        boolean z = TbadkApplication.j().l() == 1;
        if (a > 0 && this.E.getVisibility() == 0) {
            this.D.setVisibility(0);
            if (a < 10) {
                this.D.setText(String.valueOf(a));
                this.D.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_one_1 : com.baidu.tieba.a.g.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.D.setText(String.valueOf(a));
                this.D.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_two_1 : com.baidu.tieba.a.g.icon_news_head_prompt_two);
                return;
            } else {
                this.D.setText("   ");
                this.D.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_more_1 : com.baidu.tieba.a.g.icon_news_head_prompt_more);
                return;
            }
        }
        this.D.setVisibility(8);
    }

    public final void j(int i) {
        this.N = i;
        this.A.a(i);
        if (this.Q != null) {
            this.Q.a(i);
        }
        if (this.s != null) {
            this.s.e();
            this.s.notifyDataSetChanged();
        }
        if (this.C != null) {
            this.C.notifyDataSetChanged();
        }
        this.B.a(i);
        this.R.a(i);
        this.z.a(i);
        if (this.g instanceof FrsActivity) {
            ((FrsActivity) this.g).g();
        }
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a(this.h);
        this.ae.b(i);
        this.F.a(this.g, i, this.g.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n), this.g.getResources().getDrawable(com.baidu.tieba.a.g.bg_pull_down_n_1));
        if (this.ad != null) {
            this.ad.a(i);
        }
        if (this.c != null) {
            this.c.c(i);
        }
    }

    public final void O() {
        this.h.removeView(this.i);
        this.i = null;
    }

    public final void f(boolean z) {
        if (z) {
            this.p.setAlpha(128);
            this.q.setAlpha(128);
            return;
        }
        this.p.setAlpha(MotionEventCompat.ACTION_MASK);
        this.q.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public final void P() {
        this.r.c();
    }

    private static boolean W() {
        com.baidu.tieba.p.c();
        long F = com.baidu.tieba.p.F();
        if (F == 0) {
            return true;
        }
        try {
            return com.baidu.tbadk.core.util.bf.a(com.baidu.tbadk.core.util.bf.a(), new Date(F)) >= 72;
        } catch (Exception e) {
            return true;
        }
    }

    public final void g(boolean z) {
        this.R.a(z);
    }

    public final void Q() {
        this.c.b(this.c.getEditText());
        this.c.m();
    }

    public final void a(int i, int i2) {
        this.c.l();
        this.c.s();
        if (this.c.h()) {
            this.c.j();
        } else {
            this.c.getEditText().requestFocus();
            this.c.a(this.c.getEditText());
        }
        new Handler().postDelayed(new cu(this, i, i2), 300L);
    }

    public final void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.c.c.a(writeImagesInfo, z);
    }

    public final void R() {
        this.g.showProgressBar();
    }

    public final void h(boolean z) {
        this.g.hideProgressBar();
        if (z) {
            this.c.getEditText().setText("");
            this.c.b();
            this.c.k();
        }
    }

    public final void e(String str) {
        this.c.setContent(str);
    }

    public final ImageView S() {
        return this.K;
    }

    public final ImageView T() {
        return this.L;
    }

    public final ImageView U() {
        return this.M;
    }
}
