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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.coreExtra.view.LivePlayingImageView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ct {
    private static final Pattern aj = Pattern.compile("(/p/){1}(\\d+)");
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
    private View.OnClickListener V;
    private int Y;
    private int Z;
    private int aa;
    private NoNetworkView ad;
    private NavigationBar ae;
    private Button af;
    private LivePlayingImageView ag;
    private View ah;
    private com.baidu.tbadk.core.data.f ai;
    private View ak;
    private boolean al;
    private Handler am;
    private g an;
    public PbEditor c;
    private BaseActivity g;
    private View m;
    private boolean f = false;
    private RelativeLayout h = null;
    private FrameLayout i = null;
    private ImageView j = null;
    private TextView k = null;
    private ImageView l = null;
    private Button n = null;
    private FrameLayout o = null;
    private ImageView p = null;
    private ImageView q = null;
    private BdListView r = null;
    private az s = null;
    private TextView t = null;
    private LinearLayout u = null;
    private TextView v = null;
    private TextView w = null;
    private ImageView x = null;
    private AlertDialog y = null;
    private FrsHeaderView z = null;
    private com.baidu.tieba.frs.view.j A = null;
    private com.baidu.tieba.frs.view.b B = null;
    private bs C = null;
    private TextView D = null;
    private View E = null;
    private int N = 0;
    private com.baidu.tbadk.core.view.q Q = null;
    private dq R = null;
    private com.baidu.tieba.view.u S = null;
    private SlidingMenu T = null;
    private String U = null;
    AlertDialog a = null;
    Animation b = null;
    private DialogInterface.OnClickListener W = null;
    private com.baidu.tbadk.core.view.m X = null;
    private boolean ab = false;
    private BannerView ac = null;
    final Runnable d = new cu(this);
    View e = null;
    private View.OnTouchListener ao = new cv(this);
    private dd ap = null;

    public ct(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.g = null;
        this.V = null;
        this.al = false;
        this.am = null;
        this.g = baseActivity;
        this.V = onClickListener;
        this.am = new Handler();
        ag();
        this.al = TbadkApplication.m252getInst().isFirstGoFrs();
        if (this.al) {
            TbadkApplication.m252getInst().setFirstGoFrs(false);
            this.am.postDelayed(this.d, 2000L);
        }
    }

    public void a(g gVar) {
        this.an = gVar;
        this.af.setVisibility(8);
        if (this.ag.getVisibility() != 0 && gVar != null && gVar.g() != null && gVar.g().getAnchorPower() != null && gVar.g().getAnchorPower().have_power.intValue() != 0) {
            this.af.setVisibility(0);
        }
    }

    private void ag() {
        this.g.setContentView(com.baidu.tieba.w.frs_activity);
        this.R = new dq(this.g);
        this.h = (RelativeLayout) this.g.findViewById(com.baidu.tieba.v.frs);
        ah();
        this.T = new SlidingMenu(this.g);
        this.T.setMode(1);
        this.T.setTouchModeAbove(1);
        this.T.setBehindOffset(com.baidu.adp.lib.util.k.a((Context) this.g, 48.0f));
        this.T.setBehindScrollScale(0.5f);
        this.T.setFadeDegree(0.35f);
        this.T.attachToActivity(this.g, 1);
        this.T.setMenu(this.R.a());
        this.ae = (NavigationBar) this.g.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.m = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.m.setOnClickListener(this.V);
        this.ak = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.frs_icon_bottom_title, (View.OnClickListener) null);
        this.O = (TextView) this.ak.findViewById(com.baidu.tieba.v.navigationTitle_frs);
        this.P = (ImageView) this.ak.findViewById(com.baidu.tieba.v.icon_bottom_title_image);
        this.ak.setOnClickListener(this.V);
        ai();
        this.ah = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_live, (View.OnClickListener) null);
        this.af = (Button) this.ah.findViewById(com.baidu.tieba.v.nb_item_live_text_btn);
        this.af.setOnClickListener(this.V);
        this.ag = (LivePlayingImageView) this.ah.findViewById(com.baidu.tieba.v.live_playing);
        this.ag.setStatisticsKey("frs_live_icon");
        this.ag.setVisibleChangeCallback(new cw(this));
        this.l = (ImageView) this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_edit, this.V);
        View a = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_more, (View.OnClickListener) null);
        this.E = a.findViewById(com.baidu.tieba.v.frs_top_more);
        this.E.setOnClickListener(this.V);
        this.D = (TextView) a.findViewById(com.baidu.tieba.v.frs_more_mes_text);
        this.o = (FrameLayout) this.g.findViewById(com.baidu.tieba.v.refresh_layout);
        this.p = (ImageView) this.g.findViewById(com.baidu.tieba.v.refresh_bg);
        this.q = (ImageView) this.g.findViewById(com.baidu.tieba.v.refresh_icon);
        String[] strArr = {this.g.getString(com.baidu.tieba.y.take_photo), this.g.getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(this.g.getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new cx(this));
        if (this.y == null) {
            this.y = builder.create();
            this.y.setCanceledOnTouchOutside(true);
        }
        this.r = (BdListView) this.g.findViewById(com.baidu.tieba.v.frs_lv_thread);
        this.Q = new com.baidu.tbadk.core.view.q(this.g);
        this.r.setPullRefresh(this.Q);
        this.r.setDivider(null);
        this.r.setDividerHeight(0);
        this.r.setRecyclerListener(new cy(this));
        this.z = new FrsHeaderView(this.g, FrsHeaderView.PAGE.FRS_LIST, null, null);
        this.A = new com.baidu.tieba.frs.view.j(this.g, null, null);
        this.B = new com.baidu.tieba.frs.view.b(this.g);
        this.s = new az(this.g, null, com.baidu.adp.lib.util.k.b(this.g), com.baidu.tbadk.core.util.bf.a().b());
        this.b = AnimationUtils.loadAnimation(this.g, com.baidu.tieba.p.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.x = (ImageView) this.g.findViewById(com.baidu.tieba.v.frs_noexit_image);
        this.t = (TextView) this.g.findViewById(com.baidu.tieba.v.frs_noexist);
        this.t.setVisibility(8);
        this.v = (TextView) this.g.findViewById(com.baidu.tieba.v.frs_noexist_text);
        this.w = (TextView) this.g.findViewById(com.baidu.tieba.v.frs_noexit_remind_create_text);
        this.u = (LinearLayout) this.g.findViewById(com.baidu.tieba.v.frs_noexist_layout);
        this.n = (Button) this.g.findViewById(com.baidu.tieba.v.frs_bt_create);
        this.R.a(this.V);
        this.o.setOnClickListener(this.V);
        this.z.a(this.V);
        this.A.a(this.V);
        this.n.setOnClickListener(this.V);
        this.o.setOnTouchListener(this.ao);
        this.ad = (NoNetworkView) this.g.findViewById(com.baidu.tieba.v.view_no_network);
        b(false);
        this.c = (PbEditor) this.g.findViewById(com.baidu.tieba.v.frs_editor);
    }

    private void ah() {
        this.ac = new BannerView(this.g);
        this.ac.setLayoutParams(new AbsListView.LayoutParams(-1, this.g.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_banner_height)));
        this.ac.setVisibility(8);
        this.ac.setBannerViewClickListener(new cz(this));
    }

    private void ai() {
        this.e = this.g.getLayoutInflater().inflate(com.baidu.tieba.w.frs_pop_more_window, (ViewGroup) null);
        this.F = new com.baidu.tbadk.core.view.i(this.g, this.e, this.ae, this.g.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), new da(this));
        this.G = this.e.findViewById(com.baidu.tieba.v.frs_pop_more_window_all_threads_layout);
        this.G.setOnClickListener(this.V);
        this.K = (ImageView) this.e.findViewById(com.baidu.tieba.v.choose_all_threads);
        this.K.setVisibility(0);
        this.H = this.e.findViewById(com.baidu.tieba.v.frs_pop_more_window_good_threads_layout);
        this.H.setOnClickListener(this.V);
        this.L = (ImageView) this.e.findViewById(com.baidu.tieba.v.choose_good_threads);
        this.I = this.e.findViewById(com.baidu.tieba.v.frs_pop_more_window_image_threads_layout);
        this.I.setOnClickListener(this.V);
        this.M = (ImageView) this.e.findViewById(com.baidu.tieba.v.choose_image_threads);
        this.J = this.e.findViewById(com.baidu.tieba.v.frs_pop_more_window_add_shortcut_layout);
        this.J.setOnClickListener(this.V);
    }

    public void a() {
        if (this.F != null) {
            this.g.getLayoutMode().a(this.e);
            this.F.showAsDropDown(this.ae, 0, 0);
        }
    }

    public void b() {
        this.F.dismiss();
    }

    public void c() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.ae).a(0).b(false);
        gVar.a(new db(this));
        gVar.a().a(this.g);
    }

    public View d() {
        return this.ak;
    }

    public View e() {
        return this.G;
    }

    public View f() {
        return this.H;
    }

    public View g() {
        return this.I;
    }

    public View h() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView i() {
        return this.j;
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
            return this.z.f();
        }
        if ("frs_page".equals(this.U)) {
            return this.A.e();
        }
        return false;
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.X = mVar;
        if (this.ad != null) {
            this.ad.a(this.X);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.T.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.T.setOnOpenedListener(onOpenedListener);
    }

    public dq n() {
        return this.R;
    }

    public SlidingMenu o() {
        return this.T;
    }

    public void a(boolean z) {
        this.T.showMenu(z);
    }

    public void p() {
        this.ad.setVisibility(0);
    }

    public void q() {
        this.ad.setVisibility(8);
    }

    public NoNetworkView r() {
        return this.ad;
    }

    public void a(com.baidu.tbadk.core.data.n nVar, boolean z) {
        String string = this.g.getString(com.baidu.tieba.y.view);
        String string2 = this.g.getString(com.baidu.tieba.y.view_host);
        String string3 = this.g.getString(com.baidu.tieba.y.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(com.baidu.tieba.y.operation);
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
            this.a.show();
        }
    }

    public void a(String str) {
        this.g.showToast(str);
    }

    public void t() {
        if (this.ac != null) {
            this.ac.a();
        }
        if (this.x != null) {
            this.x.setBackgroundDrawable(null);
        }
        if (this.z != null) {
            this.z.i();
        }
        if (this.A != null) {
            this.A.i();
        }
        if (this.d != null) {
            this.am.removeCallbacks(this.d);
        }
        if (this.ap != null) {
            this.am.removeCallbacks(this.ap);
        }
    }

    public void b(boolean z) {
        this.f = z;
        if (z) {
            if (this.b != null) {
                this.o.setOnTouchListener(null);
                this.q.startAnimation(this.b);
                if (this.N == 1) {
                    this.p.setImageResource(com.baidu.tieba.u.pic_fresh_s_1);
                    return;
                } else {
                    this.p.setImageResource(com.baidu.tieba.u.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.o.setOnTouchListener(this.ao);
        this.r.c();
        this.q.clearAnimation();
        if (this.N == 1) {
            this.p.setImageResource(com.baidu.tieba.u.pic_fresh_n_1);
        } else {
            this.p.setImageResource(com.baidu.tieba.u.pic_fresh_n);
        }
    }

    public boolean u() {
        return this.f;
    }

    public az v() {
        return this.s;
    }

    public FrsHeaderView w() {
        return this.z;
    }

    public com.baidu.tieba.frs.view.j x() {
        return this.A;
    }

    public void b(String str) {
        this.t.setText(com.baidu.tieba.y.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.g.getString(com.baidu.tieba.y.frs_remind_noforum));
        if (this.N == 1) {
            this.v.setTextColor(this.g.getResources().getColor(com.baidu.tieba.s.noexit_create_tip_text_1));
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.g.getResources().getColor(com.baidu.tieba.s.noexit_create_bar_name_text_1)), 0, str.length(), 33);
            }
            this.w.setTextColor(this.g.getResources().getColor(com.baidu.tieba.s.noexit_create_tip2_text_1));
            this.x.setImageResource(com.baidu.tieba.u.individual_center_found_1);
        } else {
            this.v.setTextColor(-16777216);
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.g.getResources().getColor(com.baidu.tieba.s.noexit_create_bar_name_text)), 0, str.length(), 33);
            }
            this.x.setImageResource(com.baidu.tieba.u.individual_center_found);
        }
        this.u.setVisibility(0);
        this.v.setText(spannableString);
        this.O.setText(com.baidu.tieba.y.frs_create_forum);
        this.P.setVisibility(8);
        this.ak.setClickable(false);
        this.r.setVisibility(8);
        this.l.setVisibility(4);
        this.l.setClickable(false);
        this.o.setVisibility(4);
        this.E.setVisibility(8);
        this.D.setVisibility(8);
        this.T.setTouchModeAbove(2);
        this.ah.setVisibility(8);
    }

    public void y() {
        this.r.setVisibility(0);
    }

    public void c(String str) {
        this.O.setText(String.valueOf(str) + this.g.getString(com.baidu.tieba.y.forum));
        this.P.setVisibility(0);
    }

    public void z() {
        if (this.s != null) {
            this.s.notifyDataSetChanged();
        }
    }

    public void A() {
        aj();
        this.U = "normal_page";
        this.r.addHeaderView(this.z.a());
    }

    public void B() {
        aj();
        this.U = "frs_page";
        this.r.addHeaderView(this.A.a());
    }

    public void C() {
        if (!"good_page".equals(this.U)) {
            aj();
            this.U = "good_page";
            this.r.addHeaderView(this.B.a());
        }
    }

    private void aj() {
        if ("normal_page".equals(this.U)) {
            this.r.removeHeaderView(this.z.a());
        } else if ("frs_page".equals(this.U)) {
            this.r.removeHeaderView(this.A.a());
        } else if ("good_page".equals(this.U)) {
            this.r.removeHeaderView(this.B.a());
        }
    }

    public void D() {
        if (this.z != null) {
            this.z.e().setVisibility(0);
        }
    }

    public void E() {
        if (this.z != null) {
            this.z.e().setVisibility(8);
        }
    }

    public void F() {
        if (this.A != null) {
            this.A.h().setVisibility(0);
        }
    }

    public void G() {
        if (this.A != null) {
            this.A.h().setVisibility(8);
        }
    }

    public boolean H() {
        if ("normal_page".equals(this.U)) {
            return this.z.b();
        }
        if ("frs_page".equals(this.U)) {
            return this.A.b();
        }
        return false;
    }

    public boolean I() {
        if ("normal_page".equals(this.U)) {
            return this.z.c();
        }
        if ("frs_page".equals(this.U)) {
            return this.A.c();
        }
        return false;
    }

    public void J() {
        this.r.setAdapter((ListAdapter) this.s);
    }

    public void c(boolean z) {
        this.s.b(z);
    }

    public void d(boolean z) {
        this.s.c(z);
    }

    public void K() {
        this.y.show();
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.n> arrayList, int i, g gVar) {
        this.s.a(arrayList, gVar);
        if (arrayList == null || arrayList.size() <= 0) {
            this.t.setText(com.baidu.tieba.y.frs_nodata);
            this.t.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
    }

    public View a(int i) {
        return this.r.findViewById(i);
    }

    public BdListView L() {
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

    public void M() {
        this.s.b(false);
        this.s.c(false);
        this.s.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.r.setSelection(i);
    }

    public void a(ForumData forumData, g gVar) {
        if (this.A != null) {
            this.A.a(forumData, gVar);
        }
        this.A.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.A.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.A.a(false);
        }
    }

    public void a(int i, int i2, ForumData forumData, g gVar) {
        this.A.a(forumData, gVar);
        this.A.c(i);
        if (this.aa >= 0 && i2 > 0 && this.A.c()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.A.a(forumData, gVar);
            this.A.a(l(i2));
            this.A.a(this.A.d());
        }
    }

    public void e(int i) {
        this.A.c(i);
    }

    public void a(int i, ForumData forumData, g gVar, boolean z) {
        if (this.A != null) {
            this.A.a(forumData, gVar);
        }
        this.A.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
        if (forumData.getSignData().getForumRank() == -2) {
            this.A.a(false);
        }
    }

    public void a(ForumData forumData) {
        this.ai = forumData.getFrsBannerData();
        if (this.ai != null && !this.ab && !TextUtils.isEmpty(this.ai.b())) {
            this.ac.a(this.ai.b(), "banner_date", 259200000L);
            if (this.ac.a) {
                this.r.addHeaderView(this.ac);
            }
            this.ab = true;
        }
    }

    public void N() {
        if (this.ab && this.ac != null) {
            this.r.removeHeaderView(this.ac);
        }
    }

    public void b(ForumData forumData, g gVar) {
        if (this.z != null) {
            this.z.a(forumData, gVar);
        }
        this.z.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b(forumData), false);
        this.z.c(forumData.getSignData().getSigned());
        if (forumData.getSignData().getForumRank() == -2) {
            this.z.a(false);
        }
    }

    public void f(int i) {
        this.z.c(i);
    }

    public void b(int i, int i2, ForumData forumData, g gVar) {
        this.z.a(forumData, gVar);
        this.z.c(i);
        if (this.aa >= 0 && i2 > 0 && this.z.c()) {
            forumData.setCurScore(forumData.getCurScore() + i2);
            this.z.a(forumData, gVar);
            this.z.a(l(i2));
            this.z.a(this.z.d());
        }
    }

    public void b(int i, ForumData forumData, g gVar, boolean z) {
        if (this.z != null) {
            this.z.a(forumData, gVar);
        }
        if (forumData != null) {
            this.z.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.z.a(false);
            }
        }
    }

    public void g(int i) {
        if (this.z != null) {
            this.z.b(i);
        }
    }

    public void h(int i) {
        if (this.A != null) {
            this.A.b(i);
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

    private float l(int i) {
        if (this.aa < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.aa) {
            return 1.0f;
        }
        return (this.Z + i) / this.Y;
    }

    public void a(View view) {
        if (this.z != null) {
            this.z.a(view);
        }
    }

    public void b(View view) {
        if (this.A != null) {
            this.A.a(view);
        }
    }

    public void O() {
        if (this.S != null) {
            this.S.dismiss();
        }
    }

    public void P() {
        if (this.ad != null && this.X != null) {
            this.ad.b(this.X);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        C();
        if (this.C == null) {
            this.C = new bs(this.g, arrayList);
            this.B.a(this.C);
            this.B.a(onItemClickListener);
            return;
        }
        this.C.a(arrayList);
        this.C.notifyDataSetChanged();
    }

    public void i(int i) {
        if (this.C != null) {
            this.C.a(i);
        }
    }

    public void Q() {
        this.D.setVisibility(8);
    }

    public void a(de deVar, boolean z, boolean z2) {
        this.R.a(deVar, z2);
        if (!z) {
            this.D.setVisibility(8);
            return;
        }
        long a = deVar.a() + deVar.b();
        boolean z3 = TbadkApplication.m252getInst().getSkinType() == 1;
        if (a > 0 && this.E.getVisibility() == 0) {
            this.D.setVisibility(0);
            if (a < 10) {
                this.D.setText(String.valueOf(a));
                this.D.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_one_1 : com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.D.setText(String.valueOf(a));
                this.D.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_two_1 : com.baidu.tieba.u.icon_news_head_prompt_two);
                return;
            } else {
                this.D.setText("   ");
                this.D.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_more_1 : com.baidu.tieba.u.icon_news_head_prompt_more);
                return;
            }
        }
        this.D.setVisibility(8);
    }

    public void j(int i) {
        this.N = i;
        this.A.a(i);
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
        this.B.a(i);
        this.R.a(i);
        this.z.a(i);
        if (this.g instanceof FrsActivity) {
            ((FrsActivity) this.g).f();
        }
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a((View) this.h);
        this.ae.c(i);
        this.F.a(this.g, i, this.g.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), this.g.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n_1));
        if (this.ad != null) {
            this.ad.a(i);
        }
        if (this.c != null) {
            this.c.c(i);
        }
    }

    public void R() {
        this.h.removeView(this.i);
        this.i = null;
    }

    public void e(boolean z) {
        if (z) {
            this.p.setAlpha(128);
            this.q.setAlpha(128);
            return;
        }
        this.p.setAlpha(MotionEventCompat.ACTION_MASK);
        this.q.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void S() {
        this.r.d();
    }

    public int T() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public void f(boolean z) {
        this.R.a(z);
    }

    public void U() {
        this.c.b(this.c.getEditText());
        this.c.n();
    }

    public void a(int i, com.baidu.tbadk.core.data.n nVar, int i2) {
        this.c.m();
        this.c.t();
        if (this.c.h()) {
            this.c.k();
        } else {
            this.c.getEditText().requestFocus();
            this.c.a(this.c.getEditText());
        }
        a(i, i2);
    }

    protected void a(int i, int i2) {
        this.ap = new dd(this.g, i, i2, this.c, this.r, this.ae.getHeight());
        this.am.postDelayed(this.ap, 300L);
    }

    public void a(com.baidu.tbadk.editortool.x xVar) {
        if (xVar != null) {
            this.c.setOnActionListener(new dc(this, xVar));
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        this.c.c.a(writeImagesInfo, z);
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
        this.c.s();
    }

    public void Y() {
        this.c.r();
    }

    public void Z() {
        this.g.showProgressBar();
    }

    public void g(boolean z) {
        this.g.hideProgressBar();
        if (z) {
            this.c.getEditText().setText("");
            this.c.b();
            this.c.l();
        }
    }

    public void aa() {
        this.c.p();
    }

    public void ab() {
        this.c.q();
    }

    public void d(String str) {
        this.c.setContent(str);
    }

    public ImageView ac() {
        return this.K;
    }

    public ImageView ad() {
        return this.L;
    }

    public ImageView ae() {
        return this.M;
    }

    public void k(int i) {
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
}
