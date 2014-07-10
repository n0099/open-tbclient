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
    private static final Pattern ag = Pattern.compile("(/p/){1}(\\d+)");
    private com.baidu.tbadk.core.view.i D;
    private View E;
    private View F;
    private View G;
    private View H;
    private ImageView I;
    private ImageView J;
    private ImageView K;
    private TextView M;
    private ImageView N;
    private View.OnClickListener T;
    private int W;
    private int X;
    private int Y;
    private NoNetworkView aa;
    private NavigationBar ab;
    private Button ac;
    private LivePlayingImageView ad;
    private View ae;
    private com.baidu.tbadk.core.data.f af;
    private View ah;
    private boolean ai;
    private Handler aj;
    private g al;
    public PbEditor c;
    private BaseActivity g;
    private View k;
    private boolean f = false;
    private RelativeLayout h = null;
    private FrameLayout i = null;
    private ImageView j = null;
    private Button l = null;
    private FrameLayout m = null;
    private ImageView n = null;
    private ImageView o = null;
    private BdListView p = null;
    private az q = null;
    private TextView r = null;
    private LinearLayout s = null;
    private TextView t = null;
    private TextView u = null;
    private ImageView v = null;
    private AlertDialog w = null;
    private FrsHeaderView x = null;
    private com.baidu.tieba.frs.view.j y = null;
    private com.baidu.tieba.frs.view.b z = null;
    private bt A = null;
    private TextView B = null;
    private View C = null;
    private int L = 0;
    private com.baidu.tbadk.core.view.q O = null;
    private dr P = null;
    private com.baidu.tieba.view.v Q = null;
    private SlidingMenu R = null;
    private String S = null;
    AlertDialog a = null;
    Animation b = null;
    private DialogInterface.OnClickListener U = null;
    private com.baidu.tbadk.core.view.m V = null;
    private BannerView Z = null;
    private boolean ak = false;
    final Runnable d = new cu(this);
    View e = null;
    private View.OnTouchListener am = new cw(this);
    private com.baidu.tieba.bubble.t an = new cx(this);
    private de ao = null;

    public ct(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        this.g = null;
        this.T = null;
        this.ai = false;
        this.aj = null;
        this.g = baseActivity;
        this.T = onClickListener;
        this.aj = new Handler();
        ag();
        this.ai = TbadkApplication.m252getInst().isFirstGoFrs();
        if (this.ai) {
            TbadkApplication.m252getInst().setFirstGoFrs(false);
            this.aj.postDelayed(this.d, 2000L);
        }
    }

    public void a(g gVar) {
        this.al = gVar;
        this.ac.setVisibility(8);
        if (this.ad.getVisibility() != 0 && gVar != null && gVar.g() != null && gVar.g().getAnchorPower() != null && gVar.g().getAnchorPower().have_power.intValue() != 0) {
            this.ac.setVisibility(0);
        }
    }

    private void ag() {
        this.g.setContentView(com.baidu.tieba.w.frs_activity);
        this.P = new dr(this.g);
        this.h = (RelativeLayout) this.g.findViewById(com.baidu.tieba.v.frs);
        ah();
        this.R = new SlidingMenu(this.g);
        this.R.setMode(1);
        this.R.setTouchModeAbove(1);
        this.R.setBehindOffset(com.baidu.adp.lib.util.j.a((Context) this.g, 48.0f));
        this.R.setBehindScrollScale(0.5f);
        this.R.setFadeDegree(0.35f);
        this.R.attachToActivity(this.g, 1);
        this.R.setMenu(this.P.a());
        this.ab = (NavigationBar) this.g.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.k = this.ab.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k.setOnClickListener(this.T);
        this.ah = this.ab.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.frs_icon_bottom_title, (View.OnClickListener) null);
        this.M = (TextView) this.ah.findViewById(com.baidu.tieba.v.navigationTitle_frs);
        this.N = (ImageView) this.ah.findViewById(com.baidu.tieba.v.icon_bottom_title_image);
        this.ah.setOnClickListener(this.T);
        ai();
        this.ae = this.ab.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_live, (View.OnClickListener) null);
        this.ac = (Button) this.ae.findViewById(com.baidu.tieba.v.nb_item_live_text_btn);
        this.ac.setOnClickListener(this.T);
        this.ad = (LivePlayingImageView) this.ae.findViewById(com.baidu.tieba.v.live_playing);
        this.ad.setStatisticsKey("frs_live_icon");
        this.ad.setVisibleChangeCallback(new cy(this));
        this.j = (ImageView) this.ab.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_edit, this.T);
        View a = this.ab.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_more, (View.OnClickListener) null);
        this.C = a.findViewById(com.baidu.tieba.v.frs_top_more);
        this.C.setOnClickListener(this.T);
        this.B = (TextView) a.findViewById(com.baidu.tieba.v.frs_more_mes_text);
        this.m = (FrameLayout) this.g.findViewById(com.baidu.tieba.v.refresh_layout);
        this.n = (ImageView) this.g.findViewById(com.baidu.tieba.v.refresh_bg);
        this.o = (ImageView) this.g.findViewById(com.baidu.tieba.v.refresh_icon);
        this.p = (BdListView) this.g.findViewById(com.baidu.tieba.v.frs_lv_thread);
        this.O = new com.baidu.tbadk.core.view.q(this.g);
        this.p.setPullRefresh(this.O);
        this.p.setDivider(null);
        this.p.setDividerHeight(0);
        this.p.setRecyclerListener(new cz(this));
        this.q = new az(this.g, null, com.baidu.adp.lib.util.j.b(this.g), com.baidu.tbadk.core.util.bn.a().b());
        this.b = AnimationUtils.loadAnimation(this.g, com.baidu.tieba.p.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.v = (ImageView) this.g.findViewById(com.baidu.tieba.v.frs_noexit_image);
        this.r = (TextView) this.g.findViewById(com.baidu.tieba.v.frs_noexist);
        this.r.setVisibility(8);
        this.t = (TextView) this.g.findViewById(com.baidu.tieba.v.frs_noexist_text);
        this.u = (TextView) this.g.findViewById(com.baidu.tieba.v.frs_noexit_remind_create_text);
        this.s = (LinearLayout) this.g.findViewById(com.baidu.tieba.v.frs_noexist_layout);
        this.l = (Button) this.g.findViewById(com.baidu.tieba.v.frs_bt_create);
        this.P.a(this.T);
        this.m.setOnClickListener(this.T);
        this.l.setOnClickListener(this.T);
        this.m.setOnTouchListener(this.am);
        this.aa = (NoNetworkView) this.g.findViewById(com.baidu.tieba.v.view_no_network);
        b(false);
        this.c = (PbEditor) this.g.findViewById(com.baidu.tieba.v.frs_editor);
    }

    private void ah() {
        this.Z = new BannerView(this.g);
        this.Z.setLayoutParams(new AbsListView.LayoutParams(-1, this.g.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_banner_height)));
        this.Z.setVisibility(8);
        this.Z.setBannerViewClickListener(new da(this));
    }

    private void ai() {
        this.e = this.g.getLayoutInflater().inflate(com.baidu.tieba.w.frs_pop_more_window, (ViewGroup) null);
        this.E = this.e.findViewById(com.baidu.tieba.v.frs_pop_more_window_all_threads_layout);
        this.E.setOnClickListener(this.T);
        this.I = (ImageView) this.e.findViewById(com.baidu.tieba.v.choose_all_threads);
        this.I.setVisibility(0);
        this.F = this.e.findViewById(com.baidu.tieba.v.frs_pop_more_window_good_threads_layout);
        this.F.setOnClickListener(this.T);
        this.J = (ImageView) this.e.findViewById(com.baidu.tieba.v.choose_good_threads);
        this.G = this.e.findViewById(com.baidu.tieba.v.frs_pop_more_window_image_threads_layout);
        this.G.setOnClickListener(this.T);
        this.K = (ImageView) this.e.findViewById(com.baidu.tieba.v.choose_image_threads);
        this.H = this.e.findViewById(com.baidu.tieba.v.frs_pop_more_window_add_shortcut_layout);
        this.H.setOnClickListener(this.T);
        View findViewById = this.e.findViewById(com.baidu.tieba.v.more_pop_item_line_thread);
        if (TbadkApplication.m252getInst().isFrsImageActivityOpen()) {
            this.G.setVisibility(0);
            findViewById.setVisibility(0);
        } else {
            this.G.setVisibility(8);
            findViewById.setVisibility(8);
        }
        if ("M351".equals(Build.MODEL)) {
            this.H.setVisibility(8);
        } else {
            this.H.setVisibility(0);
        }
        this.D = new com.baidu.tbadk.core.view.i(this.g, this.e, this.ab, this.g.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), new db(this));
    }

    public void a() {
        if (this.D != null) {
            this.g.getLayoutMode().a(this.e);
            this.D.showAsDropDown(this.ab, 0, 0);
        }
    }

    public void b() {
        this.D.dismiss();
    }

    public void c() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.ab).a(0).b(false);
        gVar.a(new dc(this));
        gVar.a().a(this.g);
    }

    public View d() {
        return this.ah;
    }

    public View e() {
        return this.E;
    }

    public View f() {
        return this.F;
    }

    public View g() {
        return this.G;
    }

    public View h() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView i() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View j() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View k() {
        return this.k;
    }

    public boolean l() {
        if ("normal_page".equals(this.S)) {
            if (this.x != null) {
                return this.x.f();
            }
        } else if ("frs_page".equals(this.S) && this.y != null) {
            return this.y.e();
        }
        return false;
    }

    public void a(com.baidu.tbadk.core.view.m mVar) {
        this.V = mVar;
        if (this.aa != null) {
            this.aa.a(this.V);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.R.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.R.setOnOpenedListener(onOpenedListener);
    }

    public dr m() {
        return this.P;
    }

    public SlidingMenu n() {
        return this.R;
    }

    public void a(boolean z) {
        this.R.showMenu(z);
    }

    public void o() {
        this.aa.setVisibility(0);
    }

    public void p() {
        this.aa.setVisibility(8);
    }

    public NoNetworkView q() {
        return this.aa;
    }

    public void a(com.baidu.tbadk.core.data.m mVar, boolean z) {
        String string = this.g.getString(com.baidu.tieba.y.view);
        String string2 = this.g.getString(com.baidu.tieba.y.view_host);
        String string3 = this.g.getString(com.baidu.tieba.y.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(com.baidu.tieba.y.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.U);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.U);
        }
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.O.a(dVar);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.p.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.p.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.p.setOnSrollToTopListener(zVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.p.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.p.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.U = onClickListener;
    }

    public void r() {
        if (this.a != null) {
            this.a.show();
        }
    }

    public void a(String str) {
        this.g.showToast(str);
    }

    public void s() {
        if (this.Z != null) {
            this.Z.a();
        }
        if (this.v != null) {
            this.v.setBackgroundDrawable(null);
        }
        if (this.x != null) {
            this.x.i();
        }
        if (this.y != null) {
            this.y.i();
        }
        if (this.d != null) {
            this.aj.removeCallbacks(this.d);
        }
        if (this.ao != null) {
            this.aj.removeCallbacks(this.ao);
        }
    }

    public void b(boolean z) {
        this.f = z;
        if (z) {
            if (this.b != null) {
                this.m.setOnTouchListener(null);
                this.o.startAnimation(this.b);
                if (this.L == 1) {
                    this.n.setImageResource(com.baidu.tieba.u.pic_fresh_s_1);
                    return;
                } else {
                    this.n.setImageResource(com.baidu.tieba.u.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.m.setOnTouchListener(this.am);
        this.p.d();
        this.o.clearAnimation();
        if (this.L == 1) {
            this.n.setImageResource(com.baidu.tieba.u.pic_fresh_n_1);
        } else {
            this.n.setImageResource(com.baidu.tieba.u.pic_fresh_n);
        }
    }

    public boolean t() {
        return this.f;
    }

    public az u() {
        return this.q;
    }

    public FrsHeaderView v() {
        return this.x;
    }

    public com.baidu.tieba.frs.view.j w() {
        return this.y;
    }

    public void b(String str) {
        this.r.setText(com.baidu.tieba.y.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.g.getString(com.baidu.tieba.y.frs_remind_noforum));
        if (this.L == 1) {
            this.t.setTextColor(this.g.getResources().getColor(com.baidu.tieba.s.noexit_create_tip_text_1));
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.g.getResources().getColor(com.baidu.tieba.s.noexit_create_bar_name_text_1)), 0, str.length(), 33);
            }
            this.u.setTextColor(this.g.getResources().getColor(com.baidu.tieba.s.noexit_create_tip2_text_1));
            this.v.setImageResource(com.baidu.tieba.u.individual_center_found_1);
        } else {
            this.t.setTextColor(-16777216);
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.g.getResources().getColor(com.baidu.tieba.s.noexit_create_bar_name_text)), 0, str.length(), 33);
            }
            this.v.setImageResource(com.baidu.tieba.u.individual_center_found);
        }
        this.s.setVisibility(0);
        this.t.setText(spannableString);
        this.M.setText(com.baidu.tieba.y.frs_create_forum);
        this.N.setVisibility(8);
        this.ah.setClickable(false);
        this.p.setVisibility(8);
        this.j.setVisibility(4);
        this.j.setClickable(false);
        this.m.setVisibility(4);
        this.C.setVisibility(8);
        this.B.setVisibility(8);
        this.R.setTouchModeAbove(2);
        this.ae.setVisibility(8);
    }

    public void x() {
        this.p.setVisibility(0);
    }

    public void c(String str) {
        this.M.setText(String.valueOf(str) + this.g.getString(com.baidu.tieba.y.forum));
        this.N.setVisibility(0);
    }

    public void y() {
        if (this.q != null) {
            this.q.notifyDataSetChanged();
        }
    }

    public void z() {
        aj();
        this.S = "normal_page";
        if (this.x == null) {
            this.x = new FrsHeaderView(this.g, FrsHeaderView.PAGE.FRS_LIST, null, null);
            this.x.a(this.L);
            this.x.a(this.T);
        }
        this.p.addHeaderView(this.x.a());
    }

    public void A() {
        aj();
        this.S = "frs_page";
        if (this.y == null) {
            this.y = new com.baidu.tieba.frs.view.j(this.g, null, null);
            this.y.a(this.L);
            this.y.a(this.T);
        }
        this.p.addHeaderView(this.y.a());
    }

    public void B() {
        if (!"good_page".equals(this.S)) {
            aj();
            this.S = "good_page";
            if (this.z == null) {
                this.z = new com.baidu.tieba.frs.view.b(this.g);
                this.z.a(this.L);
            }
            this.p.addHeaderView(this.z.a());
        }
    }

    private void aj() {
        if ("normal_page".equals(this.S) && this.x != null) {
            this.p.removeHeaderView(this.x.a());
        } else if ("frs_page".equals(this.S) && this.y != null) {
            this.p.removeHeaderView(this.y.a());
        } else if ("good_page".equals(this.S) && this.z != null) {
            this.p.removeHeaderView(this.z.a());
        }
    }

    public void C() {
        if (this.x != null) {
            this.x.e().setVisibility(0);
        }
    }

    public void D() {
        if (this.x != null) {
            this.x.e().setVisibility(8);
        }
    }

    public void E() {
        if (this.y != null) {
            this.y.h().setVisibility(0);
        }
    }

    public void F() {
        if (this.y != null) {
            this.y.h().setVisibility(8);
        }
    }

    public boolean G() {
        if ("normal_page".equals(this.S) && this.x != null) {
            return this.x.b();
        }
        if ("frs_page".equals(this.S) && this.y != null) {
            return this.y.b();
        }
        return false;
    }

    public boolean H() {
        if ("normal_page".equals(this.S) && this.x != null) {
            return this.x.c();
        }
        if ("frs_page".equals(this.S) && this.y != null) {
            return this.y.c();
        }
        return false;
    }

    public void I() {
        this.p.setAdapter((ListAdapter) this.q);
    }

    public void c(boolean z) {
        this.q.b(z);
    }

    public void d(boolean z) {
        this.q.c(z);
    }

    private void ak() {
        if (this.w == null) {
            String[] strArr = {this.g.getString(com.baidu.tieba.y.take_photo), this.g.getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
            builder.setTitle(this.g.getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new dd(this));
            this.w = builder.create();
            this.w.setCanceledOnTouchOutside(true);
        }
    }

    public void J() {
        ak();
        if (this.w != null) {
            this.w.show();
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.m> arrayList, int i, g gVar) {
        this.q.a(arrayList, gVar);
        if (arrayList == null || arrayList.size() <= 0) {
            this.r.setText(com.baidu.tieba.y.frs_nodata);
            this.r.setVisibility(0);
            return;
        }
        this.r.setVisibility(8);
    }

    public View a(int i) {
        return this.p.findViewById(i);
    }

    public BdListView K() {
        return this.p;
    }

    public void b(int i) {
        if (i > 1) {
            this.q.d(true);
        } else {
            this.q.d(false);
        }
    }

    public void c(int i) {
        if (i == 1) {
            this.q.e(true);
        } else {
            this.q.e(false);
        }
    }

    public void L() {
        this.q.b(false);
        this.q.c(false);
        this.q.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.p.setSelection(i);
    }

    public void a(ForumData forumData, g gVar) {
        float b = b(forumData);
        if (this.y != null) {
            this.y.a(forumData, gVar);
            this.y.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
            this.y.c(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.y.a(false);
            }
        }
    }

    public void a(int i, int i2, ForumData forumData, g gVar) {
        if (this.y != null) {
            this.y.a(forumData, gVar);
            this.y.c(i);
            if (this.Y >= 0 && i2 > 0 && this.y.c()) {
                forumData.setCurScore(forumData.getCurScore() + i2);
                this.y.a(forumData, gVar);
                this.y.a(l(i2));
                this.y.a(this.y.d());
            }
        }
    }

    public void e(int i) {
        if (this.y != null) {
            this.y.c(i);
        }
    }

    public void a(int i, ForumData forumData, g gVar, boolean z) {
        if (this.y != null) {
            this.y.a(forumData, gVar);
            this.y.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.y.a(false);
            }
        }
    }

    public void a(ForumData forumData) {
        if (!this.ak) {
            this.Z.b();
            this.p.removeHeaderView(this.Z);
            this.af = forumData.getFrsBannerData();
            if (this.af != null && !TextUtils.isEmpty(this.af.b())) {
                this.Z.setData(this.af.b());
                if (this.Z.a) {
                    this.ak = true;
                    this.p.addHeaderView(this.Z);
                }
            }
        }
    }

    public void M() {
        if (this.Z != null) {
            this.ak = false;
            this.p.removeHeaderView(this.Z);
        }
    }

    public void b(ForumData forumData, g gVar) {
        float b = b(forumData);
        if (this.x != null) {
            this.x.a(forumData, gVar);
            this.x.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
            this.x.c(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.x.a(false);
            }
        }
    }

    public void f(int i) {
        if (this.x != null) {
            this.x.c(i);
        }
    }

    public void b(int i, int i2, ForumData forumData, g gVar) {
        if (this.x != null) {
            this.x.a(forumData, gVar);
            this.x.c(i);
            if (this.Y >= 0 && i2 > 0 && this.x.c()) {
                forumData.setCurScore(forumData.getCurScore() + i2);
                this.x.a(forumData, gVar);
                this.x.a(l(i2));
                this.x.a(this.x.d());
            }
        }
    }

    public void b(int i, ForumData forumData, g gVar, boolean z) {
        if (this.x != null) {
            this.x.a(forumData, gVar);
            if (forumData != null) {
                this.x.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData().getForumRank() == -2) {
                    this.x.a(false);
                }
            }
        }
    }

    public void g(int i) {
        if (this.x != null) {
            this.x.b(i);
        }
    }

    public void h(int i) {
        if (this.y != null) {
            this.y.b(i);
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.W = forumData.getLevelupScore();
        this.X = forumData.getCurScore();
        this.Y = this.W - this.X;
        if (this.W > 0) {
            return this.X / this.W;
        }
        return 0.0f;
    }

    private float l(int i) {
        if (this.Y < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.Y) {
            return 1.0f;
        }
        return (this.X + i) / this.W;
    }

    public void a(View view) {
        if (this.x != null) {
            this.x.a(view);
        }
    }

    public void b(View view) {
        if (this.y != null) {
            this.y.a(view);
        }
    }

    public void N() {
        if (this.Q != null) {
            this.Q.dismiss();
        }
    }

    public void O() {
        if (this.aa != null && this.V != null) {
            this.aa.b(this.V);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.g> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        B();
        if (this.A == null) {
            this.A = new bt(this.g, arrayList);
            this.z.a(this.A);
            this.z.a(onItemClickListener);
            return;
        }
        this.A.a(arrayList);
        this.A.notifyDataSetChanged();
    }

    public void i(int i) {
        if (this.A != null) {
            this.A.a(i);
        }
    }

    public void P() {
        this.B.setVisibility(8);
    }

    public void a(df dfVar, boolean z, boolean z2) {
        this.P.a(dfVar, z2);
        if (!z) {
            this.B.setVisibility(8);
            return;
        }
        long a = dfVar.a() + dfVar.b();
        boolean z3 = TbadkApplication.m252getInst().getSkinType() == 1;
        if (a > 0 && this.C.getVisibility() == 0) {
            this.B.setVisibility(0);
            if (a < 10) {
                this.B.setText(String.valueOf(a));
                this.B.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_one_1 : com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.B.setText(String.valueOf(a));
                this.B.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_two_1 : com.baidu.tieba.u.icon_news_head_prompt_two);
                return;
            } else {
                this.B.setText("   ");
                this.B.setBackgroundResource(z3 ? com.baidu.tieba.u.icon_news_head_prompt_more_1 : com.baidu.tieba.u.icon_news_head_prompt_more);
                return;
            }
        }
        this.B.setVisibility(8);
    }

    public void j(int i) {
        this.L = i;
        if (this.y != null) {
            this.y.a(i);
        }
        if (this.O != null) {
            this.O.a(i);
        }
        if (this.q != null) {
            this.q.d();
            this.q.notifyDataSetChanged();
        }
        if (this.A != null) {
            this.A.notifyDataSetChanged();
        }
        if (this.z != null) {
            this.z.a(i);
        }
        this.P.a(i);
        if (this.x != null) {
            this.x.a(i);
        }
        if (this.g instanceof FrsActivity) {
            ((FrsActivity) this.g).g();
        }
        this.g.getLayoutMode().a(i == 1);
        this.g.getLayoutMode().a((View) this.h);
        this.ab.c(i);
        this.D.a(this.g, i, this.g.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), this.g.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n_1));
        if (this.aa != null) {
            this.aa.a(i);
        }
        if (this.c != null) {
            this.c.c(i);
        }
    }

    public void Q() {
        this.h.removeView(this.i);
        this.i = null;
    }

    public void e(boolean z) {
        if (z) {
            this.n.setAlpha(128);
            this.o.setAlpha(128);
            return;
        }
        this.n.setAlpha(MotionEventCompat.ACTION_MASK);
        this.o.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void R() {
        this.p.e();
    }

    public int S() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public void f(boolean z) {
        this.P.a(z);
    }

    public void T() {
        this.c.b(this.c.getEditText());
        this.c.o();
    }

    public void a(int i, com.baidu.tbadk.core.data.m mVar, int i2) {
        this.c.n();
        this.c.u();
        if (this.c.h()) {
            this.c.k();
        } else {
            this.c.getEditText().requestFocus();
            this.c.a(this.c.getEditText());
        }
        a(i, i2);
        com.baidu.tieba.bubble.h.a(this.g, this.c, false, this.an);
    }

    protected void a(int i, int i2) {
        this.ao = new de(this.g, i, i2, this.c, this.p, this.ab.getHeight());
        this.aj.postDelayed(this.ao, 300L);
    }

    public void a(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.c.setOnActionListener(new cv(this, wVar));
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

    public String U() {
        return this.c.getContent();
    }

    public VoiceData.VoiceModel V() {
        return this.c.getAudioData();
    }

    public void W() {
        this.c.t();
    }

    public void X() {
        this.c.s();
    }

    public void Y() {
        this.g.showProgressBar();
    }

    public void g(boolean z) {
        this.g.hideProgressBar();
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

    public void d(String str) {
        this.c.setContent(str);
    }

    public ImageView ab() {
        return this.I;
    }

    public ImageView ac() {
        return this.J;
    }

    public ImageView ad() {
        return this.K;
    }

    public void k(int i) {
        if (i > 1) {
            if (this.x != null) {
                this.x.b(false);
            }
            if (this.y != null) {
                this.y.b(false);
                return;
            }
            return;
        }
        if (this.x != null) {
            this.x.b(true);
        }
        if (this.y != null) {
            this.y.b(true);
        }
    }

    public boolean ae() {
        return this.c.l();
    }
}
