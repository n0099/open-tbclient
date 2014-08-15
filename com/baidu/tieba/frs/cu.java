package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.coreExtra.view.LivePlayingImageView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.FrsOfficalBanner;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class cu {
    private static final Pattern ai = Pattern.compile("(/p/){1}(\\d+)");
    private com.baidu.tbadk.core.view.m F;
    private View G;
    private View H;
    private View I;
    private View J;
    private ImageView K;
    private ImageView L;
    private ImageView M;
    private TextView O;
    private ImageView P;
    private View.OnClickListener V;
    private int Y;
    private int Z;
    private int aa;
    private NoNetworkView ac;
    private NavigationBar ad;
    private Button ae;
    private LivePlayingImageView af;
    private View ag;
    private com.baidu.tbadk.core.data.g ah;
    private View aj;
    private boolean ak;
    private Handler al;
    private int am;
    private com.baidu.adp.lib.guide.d ao;
    private FrsOfficalBanner ap;
    private g aq;
    public PbEditor c;
    private FrsActivity i;
    private View m;
    private boolean h = false;
    private RelativeLayout j = null;
    private FrameLayout k = null;
    private ImageView l = null;
    private Button n = null;
    private FrameLayout o = null;
    private ImageView p = null;
    private ImageView q = null;
    private BdListView r = null;
    private bc s = null;
    private TextView t = null;
    private LinearLayout u = null;
    private TextView v = null;
    private TextView w = null;
    private ImageView x = null;
    private AlertDialog y = null;
    private FrsHeaderView z = null;
    private com.baidu.tieba.frs.view.n A = null;
    private com.baidu.tieba.frs.view.b B = null;
    private bu C = null;
    private TextView D = null;
    private View E = null;
    private int N = 0;
    private com.baidu.tbadk.core.view.u Q = null;
    private du R = null;
    private com.baidu.tieba.view.t S = null;
    private SlidingMenu T = null;
    private String U = null;
    AlertDialog a = null;
    Animation b = null;
    private DialogInterface.OnClickListener W = null;
    private com.baidu.tbadk.core.view.q X = null;
    private BannerView ab = null;
    private boolean an = false;
    final Runnable d = new cv(this);
    final Runnable e = new cz(this);
    com.baidu.tbadk.coreExtra.view.c f = new da(this);
    View g = null;
    private View.OnTouchListener ar = new db(this);
    private boolean as = false;
    private com.baidu.tieba.bubble.t at = new dc(this);
    private dh au = null;

    public cu(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.i = null;
        this.V = null;
        this.ak = false;
        this.al = null;
        this.i = frsActivity;
        this.V = onClickListener;
        this.al = new Handler();
        ad();
        this.ak = TbadkApplication.m252getInst().isFirstGoFrs();
        if (this.ak) {
            TbadkApplication.m252getInst().setFirstGoFrs(false);
            this.al.postDelayed(this.d, 2000L);
        }
    }

    public void a(g gVar) {
        this.aq = gVar;
        this.ae.setVisibility(8);
        if (this.af.getVisibility() != 0 && gVar != null && gVar.i() != null && gVar.i().getAnchorPower() != null && gVar.i().getAnchorPower().have_power.intValue() != 0) {
            this.ae.setVisibility(0);
        }
    }

    private void ad() {
        this.R = new du(this.i);
        this.j = (RelativeLayout) this.i.findViewById(com.baidu.tieba.u.frs);
        ae();
        this.T = new SlidingMenu(this.i);
        this.T.setMode(1);
        this.T.setTouchModeAbove(1);
        this.T.setBehindOffset(com.baidu.adp.lib.util.j.a((Context) this.i, 48.0f));
        this.T.setBehindScrollScale(0.5f);
        this.T.setFadeDegree(0.35f);
        this.T.attachToActivity(this.i, 1);
        this.T.setMenu(this.R.a());
        this.ad = (NavigationBar) this.i.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.ap = (FrsOfficalBanner) this.i.findViewById(com.baidu.tieba.u.frs_offical_banner);
        this.ap.setBannerViewClickListener(this.f);
        this.m = this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m.setOnClickListener(this.V);
        this.aj = this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.v.frs_icon_bottom_title, (View.OnClickListener) null);
        this.O = (TextView) this.aj.findViewById(com.baidu.tieba.u.navigationTitle_frs);
        this.P = (ImageView) this.aj.findViewById(com.baidu.tieba.u.icon_bottom_title_image);
        this.aj.setOnClickListener(this.V);
        af();
        this.ag = this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_frs_live, (View.OnClickListener) null);
        this.ae = (Button) this.ag.findViewById(com.baidu.tieba.u.nb_item_live_text_btn);
        this.ae.setOnClickListener(this.V);
        this.af = (LivePlayingImageView) this.ag.findViewById(com.baidu.tieba.u.live_playing);
        this.af.setStatisticsKey("frs_live_icon");
        this.af.setVisibleChangeCallback(new dd(this));
        this.l = (ImageView) this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_edit, this.V);
        View a = this.ad.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_frs_more, (View.OnClickListener) null);
        this.E = a.findViewById(com.baidu.tieba.u.frs_top_more);
        this.E.setOnClickListener(this.V);
        this.D = (TextView) a.findViewById(com.baidu.tieba.u.frs_more_mes_text);
        this.o = (FrameLayout) this.i.findViewById(com.baidu.tieba.u.refresh_layout);
        this.p = (ImageView) this.i.findViewById(com.baidu.tieba.u.refresh_bg);
        this.q = (ImageView) this.i.findViewById(com.baidu.tieba.u.refresh_icon);
        this.r = (BdListView) this.i.findViewById(com.baidu.tieba.u.frs_lv_thread);
        this.Q = new com.baidu.tbadk.core.view.u(this.i);
        this.r.setDivider(null);
        this.r.setOnScrollToPullListener(new de(this));
        this.r.setPullRefresh(this.Q);
        this.r.setDividerHeight(0);
        this.r.setRecyclerListener(new df(this));
        this.s = new bc(this.i, null, com.baidu.adp.lib.util.j.b(this.i), com.baidu.tbadk.core.util.bb.a().b());
        this.b = AnimationUtils.loadAnimation(this.i, com.baidu.tieba.o.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.x = (ImageView) this.i.findViewById(com.baidu.tieba.u.frs_noexit_image);
        this.t = (TextView) this.i.findViewById(com.baidu.tieba.u.frs_noexist);
        this.t.setVisibility(8);
        this.v = (TextView) this.i.findViewById(com.baidu.tieba.u.frs_noexist_text);
        this.w = (TextView) this.i.findViewById(com.baidu.tieba.u.frs_noexit_remind_create_text);
        this.u = (LinearLayout) this.i.findViewById(com.baidu.tieba.u.frs_noexist_layout);
        this.n = (Button) this.i.findViewById(com.baidu.tieba.u.frs_bt_create);
        this.R.a(this.V);
        this.o.setOnClickListener(this.V);
        this.n.setOnClickListener(this.V);
        this.o.setOnTouchListener(this.ar);
        this.ac = (NoNetworkView) this.i.findViewById(com.baidu.tieba.u.view_no_network);
        b(false);
        this.c = (PbEditor) this.i.findViewById(com.baidu.tieba.u.frs_editor);
    }

    private void ae() {
        this.ab = new BannerView(this.i);
        this.ab.setLayoutParams(new AbsListView.LayoutParams(-1, this.i.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_banner_height)));
        this.ab.setVisibility(8);
        this.ab.setBannerViewClickListener(this.f);
    }

    private void af() {
        this.g = this.i.getLayoutInflater().inflate(com.baidu.tieba.v.frs_pop_more_window, (ViewGroup) null);
        this.G = this.g.findViewById(com.baidu.tieba.u.frs_pop_more_window_all_threads_layout);
        this.G.setOnClickListener(this.V);
        this.K = (ImageView) this.g.findViewById(com.baidu.tieba.u.choose_all_threads);
        this.K.setVisibility(0);
        this.H = this.g.findViewById(com.baidu.tieba.u.frs_pop_more_window_good_threads_layout);
        this.H.setOnClickListener(this.V);
        this.L = (ImageView) this.g.findViewById(com.baidu.tieba.u.choose_good_threads);
        this.I = this.g.findViewById(com.baidu.tieba.u.frs_pop_more_window_image_threads_layout);
        this.I.setOnClickListener(this.V);
        this.M = (ImageView) this.g.findViewById(com.baidu.tieba.u.choose_image_threads);
        this.J = this.g.findViewById(com.baidu.tieba.u.frs_pop_more_window_add_shortcut_layout);
        this.J.setOnClickListener(this.V);
        View findViewById = this.g.findViewById(com.baidu.tieba.u.more_pop_item_line_thread);
        if (TbadkApplication.m252getInst().isFrsImageActivityOpen()) {
            this.I.setVisibility(0);
            findViewById.setVisibility(0);
        } else {
            this.I.setVisibility(8);
            findViewById.setVisibility(8);
        }
        if ("M351".equals(Build.MODEL)) {
            this.J.setVisibility(8);
        } else {
            this.J.setVisibility(0);
        }
        this.F = new com.baidu.tbadk.core.view.m(this.i, this.g, this.ad, this.i.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_n), new dg(this));
    }

    public void a() {
        if (this.F != null) {
            this.i.getLayoutMode().a(this.g);
            com.baidu.adp.lib.e.d.a(this.F, this.ad, 0, 0);
        }
    }

    public void b() {
        com.baidu.adp.lib.e.d.a(this.F, this.i);
    }

    public void c() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.ad).a(0).b(false);
        gVar.a(new cw(this));
        this.ao = gVar.a();
        this.ao.a(this.i);
    }

    public void d() {
        if ("normal_page".equals(this.U)) {
            if (this.z != null) {
                this.z.d();
            }
        } else if ("frs_page".equals(this.U) && this.A != null) {
            this.A.f();
        }
    }

    public View e() {
        return this.aj;
    }

    public View f() {
        return this.G;
    }

    public View g() {
        return this.H;
    }

    public View h() {
        return this.I;
    }

    public View i() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView j() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View k() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View l() {
        return this.m;
    }

    public boolean m() {
        if ("normal_page".equals(this.U)) {
            if (this.z != null) {
                return this.z.i();
            }
        } else if ("frs_page".equals(this.U) && this.A != null) {
            return this.A.j();
        }
        return false;
    }

    public void a(com.baidu.tbadk.core.view.q qVar) {
        this.X = qVar;
        if (this.ac != null) {
            this.ac.a(this.X);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.T.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.T.setOnOpenedListener(onOpenedListener);
    }

    public du n() {
        return this.R;
    }

    public SlidingMenu o() {
        return this.T;
    }

    public void a(boolean z) {
        this.T.showMenu(z);
    }

    public void p() {
        this.ac.setVisibility(0);
    }

    public void q() {
        this.ac.setVisibility(8);
    }

    public NoNetworkView r() {
        return this.ac;
    }

    public void a(com.baidu.tbadk.core.data.n nVar, boolean z) {
        String string = this.i.getString(com.baidu.tieba.x.view);
        String string2 = this.i.getString(com.baidu.tieba.x.view_host);
        String string3 = this.i.getString(com.baidu.tieba.x.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.i);
        builder.setTitle(com.baidu.tieba.x.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.W);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.W);
        }
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.Q.a(dVar);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.r.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.r.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.r.setOnSrollToTopListener(zVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.r.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.r.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.W = onClickListener;
    }

    public void s() {
        if (this.a != null) {
            com.baidu.adp.lib.e.d.a(this.a, this.i);
        }
    }

    public void t() {
        if (this.x != null) {
            this.x.setBackgroundDrawable(null);
        }
        if (this.z != null) {
            this.z.l();
        }
        if (this.A != null) {
            this.A.n();
        }
        if (this.d != null) {
            this.al.removeCallbacks(this.d);
        }
        if (this.au != null) {
            this.al.removeCallbacks(this.au);
        }
    }

    public void b(boolean z) {
        this.h = z;
        if (z) {
            if (this.b != null) {
                this.o.setOnTouchListener(null);
                this.q.startAnimation(this.b);
                if (this.N == 1) {
                    this.p.setImageResource(com.baidu.tieba.t.pic_fresh_s_1);
                    return;
                } else {
                    this.p.setImageResource(com.baidu.tieba.t.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.o.setOnTouchListener(this.ar);
        this.r.d();
        this.q.clearAnimation();
        if (this.N == 1) {
            this.p.setImageResource(com.baidu.tieba.t.pic_fresh_n_1);
        } else {
            this.p.setImageResource(com.baidu.tieba.t.pic_fresh_n);
        }
    }

    public boolean u() {
        return this.h;
    }

    public bc v() {
        return this.s;
    }

    public FrsHeaderView w() {
        return this.z;
    }

    public com.baidu.tieba.frs.view.n x() {
        return this.A;
    }

    public void a(String str) {
        this.t.setText(com.baidu.tieba.x.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.i.getString(com.baidu.tieba.x.frs_remind_noforum));
        if (this.N == 1) {
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.i.getResources().getColor(com.baidu.tieba.r.noexit_create_bar_name_text_1)), 0, str.length(), 33);
            }
            this.x.setImageResource(com.baidu.tieba.t.pic_emotion03_1);
        } else {
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.i.getResources().getColor(com.baidu.tieba.r.noexit_create_bar_name_text)), 0, str.length(), 33);
            }
            this.x.setImageResource(com.baidu.tieba.t.pic_emotion03);
        }
        this.u.setVisibility(0);
        this.v.setText(spannableString);
        this.O.setText(com.baidu.tieba.x.frs_create_forum);
        this.P.setVisibility(8);
        this.aj.setClickable(false);
        this.r.setVisibility(8);
        this.l.setVisibility(4);
        this.l.setClickable(false);
        this.o.setVisibility(4);
        this.E.setVisibility(8);
        this.D.setVisibility(8);
        this.T.setTouchModeAbove(2);
        this.ag.setVisibility(8);
    }

    public void y() {
        this.r.setVisibility(0);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.O.setText("");
            this.P.setVisibility(4);
            return;
        }
        this.O.setText(String.valueOf(str) + this.i.getString(com.baidu.tieba.x.forum));
        this.P.setVisibility(0);
    }

    public void z() {
        if (this.s != null) {
            this.s.notifyDataSetChanged();
        }
    }

    public void a(int i, int i2) {
        this.am = i2;
        ag();
        this.U = "normal_page";
        if (this.z == null) {
            this.z = new FrsHeaderView(this.i, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.z.b(this.N);
            this.z.a(this.V);
        }
        this.r.addHeaderView(this.z.c());
        this.al.postDelayed(this.e, 4000L);
    }

    public void b(int i, int i2) {
        this.am = i2;
        ag();
        this.U = "frs_page";
        m(i);
        this.r.addHeaderView(this.A.e());
        this.al.postDelayed(this.e, 4000L);
    }

    private void m(int i) {
        if (this.A == null) {
            this.A = new com.baidu.tieba.frs.view.n(this.i, null, null, i);
            this.A.a(this.N);
            this.A.a(this.f);
            this.A.a(this.V);
        }
    }

    public void A() {
        if (!"good_page".equals(this.U)) {
            ag();
            this.U = "good_page";
            if (this.B == null) {
                this.B = new com.baidu.tieba.frs.view.b(this.i);
                this.B.a(this.N);
            }
            this.r.addHeaderView(this.B.a());
        }
    }

    private void ag() {
        if ("normal_page".equals(this.U) && this.z != null) {
            this.r.removeHeaderView(this.z.c());
        } else if ("frs_page".equals(this.U) && this.A != null) {
            this.r.removeHeaderView(this.A.e());
        } else if ("good_page".equals(this.U) && this.B != null) {
            this.r.removeHeaderView(this.B.a());
        }
    }

    public void B() {
        if (this.z != null) {
            this.z.h().setVisibility(0);
        }
    }

    public void C() {
        if (this.z != null) {
            this.z.h().setVisibility(8);
        }
    }

    public void D() {
        if (this.A != null) {
            this.A.m().setVisibility(0);
        }
    }

    public void E() {
        if (this.A != null) {
            this.A.m().setVisibility(8);
        }
    }

    public boolean F() {
        if ("normal_page".equals(this.U) && this.z != null) {
            return this.z.e();
        }
        if ("frs_page".equals(this.U) && this.A != null) {
            return this.A.g();
        }
        return false;
    }

    public boolean G() {
        if ("normal_page".equals(this.U) && this.z != null) {
            return this.z.f();
        }
        if ("frs_page".equals(this.U) && this.A != null) {
            return this.A.h();
        }
        return false;
    }

    public void H() {
        this.r.setAdapter((ListAdapter) this.s);
    }

    public void c(boolean z) {
        this.s.b(z);
    }

    public void d(boolean z) {
        this.s.c(z);
    }

    private void ah() {
        if (this.y == null) {
            String[] strArr = {this.i.getString(com.baidu.tieba.x.take_photo), this.i.getString(com.baidu.tieba.x.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.i);
            builder.setTitle(this.i.getString(com.baidu.tieba.x.operation));
            builder.setItems(strArr, new cx(this));
            this.y = builder.create();
            this.y.setCanceledOnTouchOutside(true);
        }
    }

    public void I() {
        ah();
        if (this.y != null) {
            com.baidu.adp.lib.e.d.a(this.y, this.i);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.n> arrayList, int i, g gVar) {
        this.s.a(arrayList, gVar);
        if (arrayList == null || arrayList.size() <= 0) {
            this.t.setText(com.baidu.tieba.x.frs_nodata);
            this.t.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
    }

    public View a(int i) {
        return this.r.findViewById(i);
    }

    public BdListView J() {
        return this.r;
    }

    public void b(int i) {
        if (i > 1) {
            this.s.d(true);
        } else {
            this.s.d(false);
        }
    }

    public void c(int i) {
        if (i == 1) {
            this.s.e(true);
        } else {
            this.s.e(false);
        }
    }

    public void K() {
        this.s.b(false);
        this.s.c(false);
        this.s.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.r.setSelection(i);
    }

    public void a(ForumData forumData, g gVar) {
        float a = a(forumData);
        if (this.A != null) {
            this.A.a(forumData, gVar);
            this.A.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            this.A.d(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.A.a(false);
            }
        }
    }

    public void a(int i, int i2, ForumData forumData, g gVar) {
        if (this.A != null) {
            this.A.a(forumData, gVar);
            this.A.d(i);
            if (this.aa >= 0 && i2 > 0 && this.A.h()) {
                forumData.setCurScore(forumData.getCurScore() + i2);
                this.A.a(forumData, gVar);
                this.A.a(n(i2));
                this.A.a(this.A.i(), true);
            }
        }
    }

    public void e(boolean z) {
        if (z) {
            this.K.setVisibility(4);
            this.L.setVisibility(0);
            this.M.setVisibility(4);
            return;
        }
        this.K.setVisibility(0);
        this.L.setVisibility(4);
        this.M.setVisibility(4);
    }

    public void e(int i) {
        if (this.A != null) {
            this.A.d(i);
        }
    }

    public void a(int i, ForumData forumData, g gVar, boolean z) {
        if (this.A != null) {
            this.A.a(forumData, gVar);
            this.A.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.A.a(false);
            }
        }
    }

    public void a(ForumData forumData, UserData userData) {
        if (!this.an) {
            this.ab.a();
            this.r.removeHeaderView(this.ab);
            this.ah = forumData.getFrsBannerData();
            if (this.ah != null && !TextUtils.isEmpty(this.ah.b())) {
                if (this.ah.d() == 2) {
                    if (this.A == null) {
                        m(userData.getIsMem());
                    }
                    this.ap.setText(this.ah.e());
                    this.A.a(this.ah.e());
                    this.as = true;
                } else if (this.ah.d() == 1) {
                    this.ab.setData(this.ah.b());
                    if (this.ab.a) {
                        this.an = true;
                        this.r.addHeaderView(this.ab);
                    }
                }
            }
        }
    }

    public void L() {
        if (this.ab != null) {
            this.an = false;
            this.r.removeHeaderView(this.ab);
        }
    }

    public void b(ForumData forumData, g gVar) {
        float a = a(forumData);
        if (this.z != null) {
            this.z.a(forumData, gVar);
            this.z.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            if (forumData.getSignData().getForumRank() == -2) {
                this.z.a(false);
                return;
            }
            this.z.a(true);
            this.z.d(forumData.getSignData().getSigned());
        }
    }

    public void f(int i) {
        if (this.z != null) {
            this.z.d(i);
        }
    }

    public void b(int i, int i2, ForumData forumData, g gVar) {
        if (this.z != null) {
            this.z.a(forumData, gVar);
            this.z.d(i);
            if (this.aa >= 0 && i2 > 0 && this.z.f()) {
                forumData.setCurScore(forumData.getCurScore() + i2);
                this.z.a(forumData, gVar);
                this.z.a(n(i2));
                this.z.a(this.z.g(), true);
            }
        }
    }

    public void b(int i, ForumData forumData, g gVar, boolean z) {
        if (this.z != null) {
            this.z.a(forumData, gVar);
            if (forumData != null) {
                this.z.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData().getForumRank() == -2) {
                    this.z.a(false);
                }
            }
        }
    }

    public void g(int i) {
        if (this.z != null) {
            this.z.c(i);
        }
    }

    public void h(int i) {
        if (this.A != null) {
            this.A.c(i);
        }
    }

    private float a(ForumData forumData) {
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

    private float n(int i) {
        if (this.aa < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.aa) {
            return 1.0f;
        }
        return (this.Z + i) / this.Y;
    }

    public void M() {
        if (this.z != null) {
            this.z.b();
        }
    }

    public void N() {
        if (this.A != null) {
            this.A.d();
        }
    }

    public void i(int i) {
        if (this.z != null) {
            this.z.a(i);
        }
        if (this.A != null) {
            this.A.b(i);
        }
    }

    public void a(View view) {
        if (this.z != null) {
            this.z.a(view, false);
        }
    }

    public void b(View view) {
        if (this.A != null) {
            this.A.a(view, false);
        }
    }

    public void O() {
        if (this.S != null) {
            com.baidu.adp.lib.e.d.a(this.F, this.i);
        }
    }

    public void P() {
        if (this.ac != null && this.X != null) {
            this.ac.b(this.X);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        A();
        if (this.C == null) {
            this.C = new bu(this.i, arrayList);
            this.B.a(this.C);
            this.B.a(onItemClickListener);
            return;
        }
        this.C.a(arrayList);
        this.C.notifyDataSetChanged();
    }

    public void j(int i) {
        if (this.C != null) {
            this.C.a(i);
        }
    }

    public void Q() {
        this.D.setVisibility(8);
    }

    public void a(di diVar, boolean z, boolean z2, boolean z3) {
        this.R.a(diVar, z2, z3);
        if (!z) {
            this.D.setVisibility(8);
            return;
        }
        long b = z2 ? diVar.b() + 0 : 0L;
        if (z3) {
            b += diVar.a();
        }
        boolean z4 = TbadkApplication.m252getInst().getSkinType() == 1;
        if (b > 0 && this.E.getVisibility() == 0) {
            this.D.setVisibility(0);
            if (b < 10) {
                this.D.setText(String.valueOf(b));
                this.D.setBackgroundResource(z4 ? com.baidu.tieba.t.icon_news_head_prompt_one_1 : com.baidu.tieba.t.icon_news_head_prompt_one);
                return;
            } else if (b < 100) {
                this.D.setText(String.valueOf(b));
                this.D.setBackgroundResource(z4 ? com.baidu.tieba.t.icon_news_head_prompt_two_1 : com.baidu.tieba.t.icon_news_head_prompt_two);
                return;
            } else {
                this.D.setText("   ");
                this.D.setBackgroundResource(z4 ? com.baidu.tieba.t.icon_news_head_prompt_more_1 : com.baidu.tieba.t.icon_news_head_prompt_more);
                return;
            }
        }
        this.D.setVisibility(8);
    }

    public void k(int i) {
        this.N = i;
        if (this.A != null) {
            this.A.a(i);
        }
        if (this.Q != null) {
            this.Q.a(i);
        }
        if (this.s != null) {
            this.s.d();
            this.s.notifyDataSetChanged();
        }
        if (this.C != null) {
            this.C.notifyDataSetChanged();
        }
        if (this.B != null) {
            this.B.a(i);
        }
        this.R.a(i);
        if (this.z != null) {
            this.z.b(i);
        }
        this.i.f();
        this.i.getLayoutMode().a(i == 1);
        this.i.getLayoutMode().a((View) this.j);
        this.ad.c(i);
        this.F.a(this.i, i, this.i.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_n), this.i.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_n_1));
        if (this.ac != null) {
            this.ac.a(i);
        }
        if (this.c != null) {
            this.c.c(i);
        }
    }

    public void R() {
        this.j.removeView(this.k);
        this.k = null;
    }

    public void f(boolean z) {
        if (z) {
            this.p.setAlpha(128);
            this.q.setAlpha(128);
            return;
        }
        this.p.setAlpha(MotionEventCompat.ACTION_MASK);
        this.q.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void S() {
        this.r.e();
    }

    public int T() {
        return com.baidu.tieba.u.user_icon_box;
    }

    public void g(boolean z) {
        this.R.a(z);
    }

    public void U() {
        this.c.b(this.c.getEditText());
        this.c.o();
    }

    public void a(int i, com.baidu.tbadk.core.data.n nVar, int i2) {
        this.c.n();
        this.c.u();
        if (this.c.h()) {
            this.c.k();
        } else {
            this.c.getEditText().requestFocus();
            this.c.a(this.c.getEditText());
        }
        c(i, i2);
        com.baidu.tieba.bubble.h.a(this.i, this.c, false, this.at);
    }

    protected void c(int i, int i2) {
        this.au = new dh(this.i, i, i2, this.c, this.r, this.ad.getHeight());
        this.al.postDelayed(this.au, 300L);
    }

    public void a(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.c.setOnActionListener(new cy(this, wVar));
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.c.c.a(writeImagesInfo, z);
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.c.c.setBaobaoUris(writeImagesInfo);
    }

    public void a(ArrayList<String> arrayList) {
        this.c.a(arrayList);
    }

    public String V() {
        return this.c.getContent();
    }

    public VoiceData.VoiceModel W() {
        return this.c.getAudioData();
    }

    public void X() {
        this.c.t();
    }

    public void Y() {
        this.c.s();
    }

    public void h(boolean z) {
        this.i.hideProgressBar();
        if (z) {
            this.c.getEditText().setText("");
            this.c.b();
            this.c.m();
        }
    }

    public void Z() {
        this.c.q();
    }

    public void aa() {
        this.c.r();
    }

    public void c(String str) {
        this.c.setContent(str);
    }

    public void l(int i) {
        if (i > 1) {
            if (this.z != null) {
                this.z.b(false);
            }
            if (this.A != null) {
                this.A.b(false);
                return;
            }
            return;
        }
        if (this.z != null) {
            this.z.b(true);
        }
        if (this.A != null) {
            this.A.b(true);
        }
    }

    public boolean ab() {
        return this.c.l();
    }
}
