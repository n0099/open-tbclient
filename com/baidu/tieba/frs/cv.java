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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.UtilHelper;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class cv {
    private static final Pattern aj = Pattern.compile("(/p/){1}(\\d+)");
    private static /* synthetic */ int[] aw;
    private com.baidu.tbadk.core.view.n G;
    private View H;
    private View I;
    private View J;
    private View K;
    private ImageView L;
    private ImageView M;
    private ImageView N;
    private TextView P;
    private ImageView Q;
    private View.OnClickListener W;
    private int Z;
    private int aa;
    private int ab;
    private NoNetworkView ad;
    private NavigationBar ae;
    private Button af;
    private LivePlayingImageView ag;
    private View ah;
    private com.baidu.tbadk.core.data.g ai;
    private View ak;
    private boolean al;
    private Handler am;
    private int an;
    private com.baidu.adp.lib.guide.d ap;
    private FrsOfficalBanner aq;
    private g as;
    public PbEditor c;
    private FrsActivity j;
    private View n;
    private boolean i = false;
    private RelativeLayout k = null;
    private FrameLayout l = null;
    private ImageView m = null;
    private Button o = null;
    private FrameLayout p = null;
    private ImageView q = null;
    private ImageView r = null;
    private BdListView s = null;
    private bd t = null;
    private TextView u = null;
    private LinearLayout v = null;
    private TextView w = null;
    private TextView x = null;
    private ImageView y = null;
    private AlertDialog z = null;
    private FrsHeaderView A = null;
    private com.baidu.tieba.frs.view.n B = null;
    private com.baidu.tieba.frs.view.b C = null;
    private bv D = null;
    private TextView E = null;
    private View F = null;
    private int O = 0;
    private com.baidu.tbadk.core.view.v R = null;
    private dw S = null;
    private com.baidu.tieba.view.t T = null;
    private SlidingMenu U = null;
    private String V = null;
    AlertDialog a = null;
    Animation b = null;
    private DialogInterface.OnClickListener X = null;
    private com.baidu.tbadk.core.view.r Y = null;
    private BannerView ac = null;
    private boolean ao = false;
    private boolean ar = false;
    final Runnable d = new cw(this);
    final Runnable e = new db(this);
    com.baidu.tbadk.coreExtra.view.c f = new dc(this);
    com.baidu.tbadk.coreExtra.view.c g = new dd(this);
    View h = null;
    private View.OnTouchListener at = new de(this);
    private com.baidu.tieba.bubble.t au = new df(this);
    private dj av = null;

    static /* synthetic */ int[] ac() {
        int[] iArr = aw;
        if (iArr == null) {
            iArr = new int[UtilHelper.NativePageType.valuesCustom().length];
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UtilHelper.NativePageType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UtilHelper.NativePageType.PB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            aw = iArr;
        }
        return iArr;
    }

    public cv(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.j = null;
        this.W = null;
        this.al = false;
        this.am = null;
        this.j = frsActivity;
        this.W = onClickListener;
        this.am = new Handler();
        ad();
        this.al = TbadkApplication.m252getInst().isFirstGoFrs();
        if (this.al) {
            TbadkApplication.m252getInst().setFirstGoFrs(false);
            this.am.postDelayed(this.d, 2000L);
        }
    }

    public void a(g gVar) {
        this.as = gVar;
        this.af.setVisibility(8);
        if (this.ag.getVisibility() != 0 && gVar != null && gVar.i() != null && gVar.i().getAnchorPower() != null && gVar.i().getAnchorPower().have_power.intValue() != 0) {
            this.af.setVisibility(0);
        }
    }

    private void ad() {
        this.S = new dw(this.j);
        this.k = (RelativeLayout) this.j.findViewById(com.baidu.tieba.u.frs);
        ae();
        this.U = new SlidingMenu(this.j);
        this.U.setMode(1);
        this.U.setTouchModeAbove(1);
        this.U.setBehindOffset(com.baidu.adp.lib.util.j.a((Context) this.j, 48.0f));
        this.U.setBehindScrollScale(0.5f);
        this.U.setFadeDegree(0.35f);
        this.U.attachToActivity(this.j, 1);
        this.U.setMenu(this.S.a());
        this.ae = (NavigationBar) this.j.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.aq = (FrsOfficalBanner) this.j.findViewById(com.baidu.tieba.u.frs_offical_banner);
        this.aq.setBannerViewClickListener(this.g);
        this.n = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.n.setOnClickListener(this.W);
        this.ak = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.v.frs_icon_bottom_title, (View.OnClickListener) null);
        this.P = (TextView) this.ak.findViewById(com.baidu.tieba.u.navigationTitle_frs);
        this.Q = (ImageView) this.ak.findViewById(com.baidu.tieba.u.icon_bottom_title_image);
        this.ak.setOnClickListener(this.W);
        ag();
        this.ah = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_frs_live, (View.OnClickListener) null);
        this.af = (Button) this.ah.findViewById(com.baidu.tieba.u.nb_item_live_text_btn);
        this.af.setOnClickListener(this.W);
        this.ag = (LivePlayingImageView) this.ah.findViewById(com.baidu.tieba.u.live_playing);
        this.ag.setStatisticsKey("frs_live_icon");
        this.ag.setVisibleChangeCallback(new dg(this));
        this.m = (ImageView) this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.widget_nb_item_edit, this.W);
        View a = this.ae.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.nb_item_frs_more, (View.OnClickListener) null);
        this.F = a.findViewById(com.baidu.tieba.u.frs_top_more);
        this.F.setOnClickListener(this.W);
        this.E = (TextView) a.findViewById(com.baidu.tieba.u.frs_more_mes_text);
        this.p = (FrameLayout) this.j.findViewById(com.baidu.tieba.u.refresh_layout);
        this.q = (ImageView) this.j.findViewById(com.baidu.tieba.u.refresh_bg);
        this.r = (ImageView) this.j.findViewById(com.baidu.tieba.u.refresh_icon);
        this.s = (BdListView) this.j.findViewById(com.baidu.tieba.u.frs_lv_thread);
        this.R = new com.baidu.tbadk.core.view.v(this.j);
        this.s.setDivider(null);
        this.s.setOnScrollToPullListener(new dh(this));
        this.s.setPullRefresh(this.R);
        this.s.setDividerHeight(0);
        this.s.setRecyclerListener(new di(this));
        this.t = new bd(this.j, null, com.baidu.adp.lib.util.j.b(this.j), com.baidu.tbadk.core.util.bb.a().b());
        this.b = AnimationUtils.loadAnimation(this.j, com.baidu.tieba.o.refresh_rotate);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setFillAfter(true);
        this.y = (ImageView) this.j.findViewById(com.baidu.tieba.u.frs_noexit_image);
        this.u = (TextView) this.j.findViewById(com.baidu.tieba.u.frs_noexist);
        this.u.setVisibility(8);
        this.w = (TextView) this.j.findViewById(com.baidu.tieba.u.frs_noexist_text);
        this.x = (TextView) this.j.findViewById(com.baidu.tieba.u.frs_noexit_remind_create_text);
        this.v = (LinearLayout) this.j.findViewById(com.baidu.tieba.u.frs_noexist_layout);
        this.o = (Button) this.j.findViewById(com.baidu.tieba.u.frs_bt_create);
        this.S.a(this.W);
        this.p.setOnClickListener(this.W);
        this.o.setOnClickListener(this.W);
        this.p.setOnTouchListener(this.at);
        this.ad = (NoNetworkView) this.j.findViewById(com.baidu.tieba.u.view_no_network);
        b(false);
        this.c = (PbEditor) this.j.findViewById(com.baidu.tieba.u.frs_editor);
    }

    private void ae() {
        this.ac = new BannerView(this.j);
        this.ac.setLayoutParams(new AbsListView.LayoutParams(-1, this.j.getResources().getDimensionPixelSize(com.baidu.tieba.s.frs_header_banner_height)));
        this.ac.setVisibility(8);
        this.ac.setBannerViewClickListener(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af() {
        String c = this.ai.c();
        if (this.ai != null) {
            if (this.ai.a() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.o(this.j, c, false, "frs_banner")));
            } else if (this.ai.a() == 2) {
                if (c.contains("tieba.baidu.com")) {
                    Matcher matcher = aj.matcher(c);
                    if (matcher.find()) {
                        try {
                            this.j.sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bc(this.j).a(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.ai.a() == 3) {
                new com.baidu.tbadk.core.util.bo();
                com.baidu.tbadk.core.util.bo isNativeAddress = UtilHelper.isNativeAddress(c);
                if (isNativeAddress.b != UtilHelper.NativePageType.NONE) {
                    switch (ac()[isNativeAddress.b.ordinal()]) {
                        case 2:
                            this.j.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.j).a(isNativeAddress.a, "frs_banner")));
                            return;
                        case 3:
                            this.j.sendMessage(new CustomMessage(2004001, new com.baidu.tbadk.core.atomData.bc(this.j).a(isNativeAddress.a, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.browser.a.a(this.j, c);
            } else if (this.ai.a() == 4) {
                this.j.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.s(this.j).a(c, "frs_banner")));
            }
        }
    }

    private void ag() {
        this.h = com.baidu.adp.lib.e.b.a().a(this.j, com.baidu.tieba.v.frs_pop_more_window, null);
        this.H = this.h.findViewById(com.baidu.tieba.u.frs_pop_more_window_all_threads_layout);
        this.H.setOnClickListener(this.W);
        this.L = (ImageView) this.h.findViewById(com.baidu.tieba.u.choose_all_threads);
        this.L.setVisibility(0);
        this.I = this.h.findViewById(com.baidu.tieba.u.frs_pop_more_window_good_threads_layout);
        this.I.setOnClickListener(this.W);
        this.M = (ImageView) this.h.findViewById(com.baidu.tieba.u.choose_good_threads);
        this.J = this.h.findViewById(com.baidu.tieba.u.frs_pop_more_window_image_threads_layout);
        this.J.setOnClickListener(this.W);
        this.N = (ImageView) this.h.findViewById(com.baidu.tieba.u.choose_image_threads);
        this.K = this.h.findViewById(com.baidu.tieba.u.frs_pop_more_window_add_shortcut_layout);
        this.K.setOnClickListener(this.W);
        View findViewById = this.h.findViewById(com.baidu.tieba.u.more_pop_item_line_thread);
        if (TbadkApplication.m252getInst().isFrsImageActivityOpen()) {
            this.J.setVisibility(0);
            findViewById.setVisibility(0);
        } else {
            this.J.setVisibility(8);
            findViewById.setVisibility(8);
        }
        if ("M351".equals(Build.MODEL)) {
            this.K.setVisibility(8);
        } else {
            this.K.setVisibility(0);
        }
        this.G = new com.baidu.tbadk.core.view.n(this.j, this.h, this.ae, this.j.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_n), new cx(this));
    }

    public void a() {
        if (this.G != null) {
            this.j.getLayoutMode().a(this.h);
            com.baidu.adp.lib.e.e.a(this.G, this.ae, 0, 0);
        }
    }

    public void b() {
        com.baidu.adp.lib.e.e.a(this.G, this.j);
    }

    public void c() {
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(this.ae).a(0).b(false);
        gVar.a(new cy(this));
        this.ap = gVar.a();
        this.ap.a(this.j);
    }

    public void d() {
        if ("normal_page".equals(this.V)) {
            if (this.A != null) {
                this.A.d();
            }
        } else if ("frs_page".equals(this.V) && this.B != null) {
            this.B.f();
        }
    }

    public View e() {
        return this.ak;
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

    public View i() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView j() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View k() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View l() {
        return this.n;
    }

    public boolean m() {
        if ("normal_page".equals(this.V)) {
            if (this.A != null) {
                return this.A.i();
            }
        } else if ("frs_page".equals(this.V) && this.B != null) {
            return this.B.j();
        }
        return false;
    }

    public void a(com.baidu.tbadk.core.view.r rVar) {
        this.Y = rVar;
        if (this.ad != null) {
            this.ad.a(this.Y);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.U.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.U.setOnOpenedListener(onOpenedListener);
    }

    public dw n() {
        return this.S;
    }

    public SlidingMenu o() {
        return this.U;
    }

    public void a(boolean z) {
        this.U.showMenu(z);
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
        String string = this.j.getString(com.baidu.tieba.x.view);
        String string2 = this.j.getString(com.baidu.tieba.x.view_host);
        String string3 = this.j.getString(com.baidu.tieba.x.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.j);
        builder.setTitle(com.baidu.tieba.x.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.X);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.X);
        }
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.d dVar) {
        this.R.a(dVar);
    }

    public void a(AbsListView.OnScrollListener onScrollListener) {
        this.s.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.s.setOnSrollToBottomListener(xVar);
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.s.setOnSrollToTopListener(zVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.s.setOnItemClickListener(onItemClickListener);
    }

    public void a(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.s.setOnItemLongClickListener(onItemLongClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.X = onClickListener;
    }

    public void s() {
        if (this.a != null) {
            com.baidu.adp.lib.e.e.a(this.a, this.j);
        }
    }

    public void t() {
        if (this.y != null) {
            this.y.setBackgroundDrawable(null);
        }
        if (this.A != null) {
            this.A.l();
        }
        if (this.B != null) {
            this.B.n();
        }
        if (this.d != null) {
            this.am.removeCallbacks(this.d);
        }
        if (this.av != null) {
            this.am.removeCallbacks(this.av);
        }
    }

    public void b(boolean z) {
        this.i = z;
        if (z) {
            if (this.b != null) {
                this.p.setOnTouchListener(null);
                this.r.startAnimation(this.b);
                if (this.O == 1) {
                    this.q.setImageResource(com.baidu.tieba.t.pic_fresh_s_1);
                    return;
                } else {
                    this.q.setImageResource(com.baidu.tieba.t.pic_fresh_s);
                    return;
                }
            }
            return;
        }
        this.p.setOnTouchListener(this.at);
        this.s.d();
        this.r.clearAnimation();
        if (this.O == 1) {
            this.q.setImageResource(com.baidu.tieba.t.pic_fresh_n_1);
        } else {
            this.q.setImageResource(com.baidu.tieba.t.pic_fresh_n);
        }
    }

    public boolean u() {
        return this.i;
    }

    public bd v() {
        return this.t;
    }

    public FrsHeaderView w() {
        return this.A;
    }

    public com.baidu.tieba.frs.view.n x() {
        return this.B;
    }

    public void a(String str) {
        this.u.setText(com.baidu.tieba.x.frs_noforum);
        SpannableString spannableString = new SpannableString(String.valueOf(str) + this.j.getString(com.baidu.tieba.x.frs_remind_noforum));
        if (this.O == 1) {
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.j.getResources().getColor(com.baidu.tieba.r.noexit_create_bar_name_text_1)), 0, str.length(), 33);
            }
            this.y.setImageResource(com.baidu.tieba.t.pic_emotion03_1);
        } else {
            if (str != null && str.length() != 0) {
                spannableString.setSpan(new ForegroundColorSpan(this.j.getResources().getColor(com.baidu.tieba.r.noexit_create_bar_name_text)), 0, str.length(), 33);
            }
            this.y.setImageResource(com.baidu.tieba.t.pic_emotion03);
        }
        this.v.setVisibility(0);
        this.w.setText(spannableString);
        this.P.setText(com.baidu.tieba.x.frs_create_forum);
        this.Q.setVisibility(8);
        this.ak.setClickable(false);
        this.s.setVisibility(8);
        this.m.setVisibility(4);
        this.m.setClickable(false);
        this.p.setVisibility(4);
        this.F.setVisibility(8);
        this.E.setVisibility(8);
        this.U.setTouchModeAbove(2);
        this.ah.setVisibility(8);
    }

    public void y() {
        this.s.setVisibility(0);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.P.setText("");
            this.Q.setVisibility(4);
            return;
        }
        this.P.setText(String.valueOf(str) + this.j.getString(com.baidu.tieba.x.forum));
        this.Q.setVisibility(0);
    }

    public void z() {
        if (this.t != null) {
            this.t.notifyDataSetChanged();
        }
    }

    public void a(int i, int i2) {
        this.an = i2;
        ah();
        this.V = "normal_page";
        if (this.A == null) {
            this.A = new FrsHeaderView(this.j, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.A.b(this.O);
            this.A.a(this.W);
        }
        this.s.addHeaderView(this.A.c());
        this.am.postDelayed(this.e, 4000L);
    }

    public void b(int i, int i2) {
        this.an = i2;
        ah();
        this.V = "frs_page";
        m(i);
        this.s.addHeaderView(this.B.e());
        this.am.postDelayed(this.e, 4000L);
    }

    private void m(int i) {
        if (this.B == null) {
            this.B = new com.baidu.tieba.frs.view.n(this.j, null, null, i);
            this.B.a(this.O);
            this.B.a(this.f);
            this.B.a(this.W);
        }
    }

    public void A() {
        if (!"good_page".equals(this.V)) {
            ah();
            this.V = "good_page";
            if (this.C == null) {
                this.C = new com.baidu.tieba.frs.view.b(this.j);
                this.C.a(this.O);
            }
            this.s.addHeaderView(this.C.a());
        }
    }

    private void ah() {
        if ("normal_page".equals(this.V) && this.A != null) {
            this.s.removeHeaderView(this.A.c());
        } else if ("frs_page".equals(this.V) && this.B != null) {
            this.s.removeHeaderView(this.B.e());
        } else if ("good_page".equals(this.V) && this.C != null) {
            this.s.removeHeaderView(this.C.a());
        }
    }

    public void B() {
        if (this.A != null) {
            this.A.h().setVisibility(0);
        }
    }

    public void C() {
        if (this.A != null) {
            this.A.h().setVisibility(8);
        }
    }

    public void D() {
        if (this.B != null) {
            this.B.m().setVisibility(0);
        }
    }

    public void E() {
        if (this.B != null) {
            this.B.m().setVisibility(8);
        }
    }

    public boolean F() {
        if ("normal_page".equals(this.V) && this.A != null) {
            return this.A.e();
        }
        if ("frs_page".equals(this.V) && this.B != null) {
            return this.B.g();
        }
        return false;
    }

    public boolean G() {
        if ("normal_page".equals(this.V) && this.A != null) {
            return this.A.f();
        }
        if ("frs_page".equals(this.V) && this.B != null) {
            return this.B.h();
        }
        return false;
    }

    public void H() {
        this.s.setAdapter((ListAdapter) this.t);
    }

    public void c(boolean z) {
        this.t.b(z);
    }

    public void d(boolean z) {
        this.t.c(z);
    }

    private void ai() {
        if (this.z == null) {
            String[] strArr = {this.j.getString(com.baidu.tieba.x.take_photo), this.j.getString(com.baidu.tieba.x.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.j);
            builder.setTitle(this.j.getString(com.baidu.tieba.x.operation));
            builder.setItems(strArr, new cz(this));
            this.z = builder.create();
            this.z.setCanceledOnTouchOutside(true);
        }
    }

    public void I() {
        ai();
        if (this.z != null) {
            com.baidu.adp.lib.e.e.a(this.z, this.j);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.n> arrayList, int i, g gVar) {
        this.t.a(arrayList, gVar);
        if (arrayList == null || arrayList.size() <= 0) {
            this.u.setText(com.baidu.tieba.x.frs_nodata);
            this.u.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
    }

    public View a(int i) {
        return this.s.findViewById(i);
    }

    public BdListView J() {
        return this.s;
    }

    public void b(int i) {
        if (i > 1) {
            this.t.d(true);
        } else {
            this.t.d(false);
        }
    }

    public void c(int i) {
        if (i == 1) {
            this.t.e(true);
        } else {
            this.t.e(false);
        }
    }

    public void K() {
        this.t.b(false);
        this.t.c(false);
        this.t.notifyDataSetInvalidated();
    }

    public void d(int i) {
        this.s.setSelection(i);
    }

    public void a(ForumData forumData, g gVar) {
        float a = a(forumData);
        if (this.B != null) {
            this.B.a(forumData, gVar);
            this.B.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            this.B.d(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.B.a(false);
            }
        }
    }

    public void a(int i, int i2, ForumData forumData, g gVar) {
        if (this.B != null) {
            this.B.a(forumData, gVar);
            this.B.d(i);
            if (this.ab >= 0 && i2 > 0 && this.B.h()) {
                forumData.setCurScore(forumData.getCurScore() + i2);
                this.B.a(forumData, gVar);
                this.B.a(n(i2));
                this.B.a(this.B.i(), true);
            }
        }
    }

    public void e(boolean z) {
        if (z) {
            this.L.setVisibility(4);
            this.M.setVisibility(0);
            this.N.setVisibility(4);
            return;
        }
        this.L.setVisibility(0);
        this.M.setVisibility(4);
        this.N.setVisibility(4);
    }

    public void e(int i) {
        if (this.B != null) {
            this.B.d(i);
        }
    }

    public void a(int i, ForumData forumData, g gVar, boolean z) {
        if (this.B != null) {
            this.B.a(forumData, gVar);
            this.B.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.B.a(false);
            }
        }
    }

    public void a(ForumData forumData, UserData userData) {
        if (!this.ao) {
            this.ac.a();
            this.s.removeHeaderView(this.ac);
            this.ai = forumData.getFrsBannerData();
            if (this.ai != null && !TextUtils.isEmpty(this.ai.b())) {
                if (this.ai.d() == 2) {
                    if (this.B == null) {
                        m(userData.getIsMem());
                    }
                    this.aq.setText(this.ai.e());
                    this.B.a(this.ai.e());
                    this.ar = true;
                } else if (this.ai.d() == 1) {
                    this.ac.setData(this.ai.b());
                    if (this.ac.a) {
                        this.ao = true;
                        this.s.addHeaderView(this.ac);
                    }
                }
            }
        }
    }

    public void L() {
        if (this.ac != null) {
            this.ao = false;
            this.s.removeHeaderView(this.ac);
        }
    }

    public void b(ForumData forumData, g gVar) {
        float a = a(forumData);
        if (this.A != null) {
            this.A.a(forumData, gVar);
            this.A.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            if (forumData.getSignData().getForumRank() == -2) {
                this.A.a(false);
                return;
            }
            this.A.a(true);
            this.A.d(forumData.getSignData().getSigned());
        }
    }

    public void f(int i) {
        if (this.A != null) {
            this.A.d(i);
        }
    }

    public void b(int i, int i2, ForumData forumData, g gVar) {
        if (this.A != null) {
            this.A.a(forumData, gVar);
            this.A.d(i);
            if (this.ab >= 0 && i2 > 0 && this.A.f()) {
                forumData.setCurScore(forumData.getCurScore() + i2);
                this.A.a(forumData, gVar);
                this.A.a(n(i2));
                this.A.a(this.A.g(), true);
            }
        }
    }

    public void b(int i, ForumData forumData, g gVar, boolean z) {
        if (this.A != null) {
            this.A.a(forumData, gVar);
            if (forumData != null) {
                this.A.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData().getForumRank() == -2) {
                    this.A.a(false);
                }
            }
        }
    }

    public void g(int i) {
        if (this.A != null) {
            this.A.c(i);
        }
    }

    public void h(int i) {
        if (this.B != null) {
            this.B.c(i);
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.Z = forumData.getLevelupScore();
        this.aa = forumData.getCurScore();
        this.ab = this.Z - this.aa;
        if (this.Z > 0) {
            return this.aa / this.Z;
        }
        return 0.0f;
    }

    private float n(int i) {
        if (this.ab < 0 || i <= 0) {
            return 0.0f;
        }
        if (i >= this.ab) {
            return 1.0f;
        }
        return (this.aa + i) / this.Z;
    }

    public void M() {
        if (this.A != null) {
            this.A.b();
        }
    }

    public void N() {
        if (this.B != null) {
            this.B.d();
        }
    }

    public void i(int i) {
        if (this.A != null) {
            this.A.a(i);
        }
        if (this.B != null) {
            this.B.b(i);
        }
    }

    public void a(View view) {
        if (this.A != null) {
            this.A.a(view, false);
        }
    }

    public void b(View view) {
        if (this.B != null) {
            this.B.a(view, false);
        }
    }

    public void O() {
        if (this.T != null) {
            com.baidu.adp.lib.e.e.a(this.G, this.j);
        }
    }

    public void P() {
        if (this.ad != null && this.Y != null) {
            this.ad.b(this.Y);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        A();
        if (this.D == null) {
            this.D = new bv(this.j, arrayList);
            this.C.a(this.D);
            this.C.a(onItemClickListener);
            return;
        }
        this.D.a(arrayList);
        this.D.notifyDataSetChanged();
    }

    public void j(int i) {
        if (this.D != null) {
            this.D.a(i);
        }
    }

    public void Q() {
        this.E.setVisibility(8);
    }

    public void a(dk dkVar, boolean z, boolean z2, boolean z3) {
        this.S.a(dkVar, z2, z3);
        if (!z) {
            this.E.setVisibility(8);
            return;
        }
        long b = z2 ? dkVar.b() + 0 : 0L;
        if (z3) {
            b += dkVar.a();
        }
        boolean z4 = TbadkApplication.m252getInst().getSkinType() == 1;
        if (b > 0 && this.F.getVisibility() == 0) {
            this.E.setVisibility(0);
            if (b < 10) {
                this.E.setText(String.valueOf(b));
                this.E.setBackgroundResource(z4 ? com.baidu.tieba.t.icon_news_head_prompt_one_1 : com.baidu.tieba.t.icon_news_head_prompt_one);
                return;
            } else if (b < 100) {
                this.E.setText(String.valueOf(b));
                this.E.setBackgroundResource(z4 ? com.baidu.tieba.t.icon_news_head_prompt_two_1 : com.baidu.tieba.t.icon_news_head_prompt_two);
                return;
            } else {
                this.E.setText("   ");
                this.E.setBackgroundResource(z4 ? com.baidu.tieba.t.icon_news_head_prompt_more_1 : com.baidu.tieba.t.icon_news_head_prompt_more);
                return;
            }
        }
        this.E.setVisibility(8);
    }

    public void k(int i) {
        this.O = i;
        if (this.B != null) {
            this.B.a(i);
        }
        if (this.R != null) {
            this.R.a(i);
        }
        if (this.t != null) {
            this.t.d();
            this.t.notifyDataSetChanged();
        }
        if (this.D != null) {
            this.D.notifyDataSetChanged();
        }
        if (this.C != null) {
            this.C.a(i);
        }
        this.S.a(i);
        if (this.A != null) {
            this.A.b(i);
        }
        this.j.f();
        this.j.getLayoutMode().a(i == 1);
        this.j.getLayoutMode().a((View) this.k);
        this.ae.c(i);
        this.G.a(this.j, i, this.j.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_n), this.j.getResources().getDrawable(com.baidu.tieba.t.bg_pull_down_n_1));
        if (this.ad != null) {
            this.ad.a(i);
        }
        if (this.c != null) {
            this.c.c(i);
        }
    }

    public void R() {
        this.k.removeView(this.l);
        this.l = null;
    }

    public void f(boolean z) {
        if (z) {
            this.q.setAlpha(128);
            this.r.setAlpha(128);
            return;
        }
        this.q.setAlpha(MotionEventCompat.ACTION_MASK);
        this.r.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void S() {
        this.s.e();
    }

    public int T() {
        return com.baidu.tieba.u.user_icon_box;
    }

    public void g(boolean z) {
        this.S.a(z);
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
        com.baidu.tieba.bubble.h.a(this.j, this.c, false, this.au);
    }

    protected void c(int i, int i2) {
        this.av = new dj(this.j, i, i2, this.c, this.s, this.ae.getHeight());
        this.am.postDelayed(this.av, 300L);
    }

    public void a(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.c.setOnActionListener(new da(this, wVar));
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
        this.j.hideProgressBar();
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
            if (this.A != null) {
                this.A.b(false);
            }
            if (this.B != null) {
                this.B.b(false);
                return;
            }
            return;
        }
        if (this.A != null) {
            this.A.b(true);
        }
        if (this.B != null) {
            this.B.b(true);
        }
    }

    public boolean ab() {
        return this.c.l();
    }
}
