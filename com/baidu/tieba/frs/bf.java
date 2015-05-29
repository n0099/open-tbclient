package com.baidu.tieba.frs;

import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bf {
    private static /* synthetic */ int[] aOl;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aFX;
    private com.baidu.tieba.tbadkCore.w aLl;
    private FrsActivity aMk;
    private am aNE;
    private View aNH;
    private View aNK;
    private View aNL;
    private View aNM;
    private ImageView aNN;
    private ImageView aNO;
    private ImageView aNP;
    private View.OnClickListener aNU;
    private ImageView aNW;
    private com.baidu.tbadk.coreExtra.view.q aNX;
    private LinearLayout aNY;
    private com.baidu.tbadk.core.data.k aNZ;
    private View aNz;
    private View aOa;
    private FrsOfficalBanner aOc;
    private View aOd;
    private PbListView aOf;
    private CustomMessageListener aOg;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private TextView mTitle;
    private boolean aNw = false;
    private NoPressedRelativeLayout aNx = null;
    private ImageView aNy = null;
    private FrameLayout aNA = null;
    private ImageView aNB = null;
    private ImageView aNC = null;
    private BdTypeListView aND = null;
    private TextView aNF = null;
    private com.baidu.tbadk.core.dialog.e aNG = null;
    private TextView aNI = null;
    private View aNJ = null;
    private com.baidu.tbadk.core.view.al mPullView = null;
    private com.baidu.tieba.tbadkCore.ac aNQ = null;
    private String aNR = null;
    com.baidu.tbadk.core.dialog.e aNS = null;
    Animation aNT = null;
    private com.baidu.tbadk.core.dialog.h aNV = null;
    private com.baidu.tbadk.core.view.ad aLO = null;
    private BannerView aDE = null;
    private boolean aOb = false;
    private boolean aOe = false;
    com.baidu.tbadk.coreExtra.view.b aOh = new bg(this);
    com.baidu.tbadk.coreExtra.view.b aOi = new bh(this);
    View aOj = null;
    private View.OnTouchListener aOk = new bi(this);

    static /* synthetic */ int[] LE() {
        int[] iArr = aOl;
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
            aOl = iArr;
        }
        return iArr;
    }

    public bf(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aMk = null;
        this.aNU = null;
        this.aMk = frsActivity;
        this.aNU = onClickListener;
        initUI();
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.aLl = wVar;
        this.aNW.setVisibility(8);
        if (this.aNX != null && this.aNX.getVisibility() != 0 && wVar != null && wVar.aar() != null && wVar.aar().getAnchorPower() != null && wVar.aar().getAnchorPower().have_power.intValue() != 0 && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aNW.setVisibility(0);
        }
    }

    private void initUI() {
        this.aNx = (NoPressedRelativeLayout) this.aMk.findViewById(com.baidu.tieba.q.frs);
        this.mNavigationBar = (NavigationBar) this.aMk.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.aOc = (FrsOfficalBanner) this.aMk.findViewById(com.baidu.tieba.q.frs_offical_banner);
        this.aOc.setBannerViewClickListener(this.aOi);
        this.aNz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aNz.setOnClickListener(this.aNU);
        this.aOa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.frs_icon_bottom_title, (View.OnClickListener) null);
        this.mTitle = (TextView) this.aOa.findViewById(com.baidu.tieba.q.navigationTitle_frs);
        this.aNP = (ImageView) this.aOa.findViewById(com.baidu.tieba.q.icon_bottom_title_image);
        this.aOa.setOnClickListener(this.aNU);
        this.aNY = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.nb_item_frs_live, (View.OnClickListener) null);
        this.aNW = (ImageView) this.aNY.findViewById(com.baidu.tieba.q.nb_item_live_text_btn);
        this.aNW.setOnClickListener(this.aNU);
        if (this.aOg == null) {
            this.aOg = new bj(this, 0);
            this.aMk.registerListener(2001269, this.aOg);
        }
        this.aMk.sendMessage(new CustomMessage(2001269, this.aMk.getPageContext().getPageActivity()));
        this.aOd = this.aMk.findViewById(com.baidu.tieba.q.frs_list_content);
        this.aNy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_edit, this.aNU);
        this.aNH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.nb_item_frs_more, (View.OnClickListener) null);
        this.aNJ = this.aNH.findViewById(com.baidu.tieba.q.frs_top_more);
        this.aNJ.setOnClickListener(this.aNU);
        this.aNI = (TextView) this.aNH.findViewById(com.baidu.tieba.q.frs_more_mes_text);
        this.aNA = (FrameLayout) this.aMk.findViewById(com.baidu.tieba.q.refresh_layout);
        this.aNB = (ImageView) this.aMk.findViewById(com.baidu.tieba.q.refresh_bg);
        this.aNC = (ImageView) this.aMk.findViewById(com.baidu.tieba.q.refresh_icon);
        this.aND = (BdTypeListView) this.aMk.findViewById(com.baidu.tieba.q.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.al(this.aMk.getPageContext());
        this.aND.setDivider(null);
        this.aND.setPullRefresh(this.mPullView);
        this.aND.setDividerHeight(0);
        this.aND.setRecyclerListener(new bl(this));
        this.aOf = new PbListView(this.aMk.getPageContext().getPageActivity());
        this.aOf.ng();
        this.aOf.cx(com.baidu.tieba.n.cp_bg_line_c);
        this.aND.setOnSrollToBottomListener(this.aMk);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ak(new bm(this)));
        this.aNE = new am(this.aMk, this.aND, com.baidu.tbadk.core.util.bc.tB().tD());
        this.aNF = (TextView) this.aMk.findViewById(com.baidu.tieba.q.frs_noexist_post);
        this.aNF.setVisibility(8);
        this.aNA.setOnClickListener(this.aNU);
        this.aNA.setOnTouchListener(this.aOk);
        this.aFX = (NoNetworkView) this.aMk.findViewById(com.baidu.tieba.q.view_no_network);
        bY(false);
    }

    private void Hc() {
        if (this.aDE == null) {
            this.aDE = new BannerView(this.aMk.getPageContext().getPageActivity());
            this.aDE.setLayoutParams(new AbsListView.LayoutParams(-1, this.aMk.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_banner_height)));
            this.aDE.setVisibility(8);
            this.aDE.setBannerViewClickListener(this.aOi);
            this.aDE.setBannerViewEvent(new bn(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Lb() {
        if (TextUtils.equals(this.aNR, "frs_page")) {
            TiebaStatic.eventStat(this.aMk.getPageContext().getPageActivity(), "top_banner_ck", "click");
        }
        if (this.aNZ != null) {
            String value = this.aNZ.getValue();
            if (this.aNZ.qE() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.aMk.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aNZ.qE() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aMk.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aMk.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aNZ.qE() == 3) {
                new com.baidu.tbadk.core.util.bp();
                com.baidu.tbadk.core.util.bp isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.Wp != UtilHelper.NativePageType.NONE) {
                    switch (LE()[isNativeAddress.Wp.ordinal()]) {
                        case 2:
                            this.aMk.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aMk.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aMk.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aMk.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bi.tO().b(this.aMk.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aMk.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aNZ.qE() == 4) {
                this.aMk.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aMk.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void Lc() {
        this.aOj = com.baidu.adp.lib.g.b.hr().inflate(this.aMk.getPageContext().getPageActivity(), com.baidu.tieba.r.frs_pop_more_window, null);
        this.aNK = this.aOj.findViewById(com.baidu.tieba.q.frs_pop_more_window_all_threads_layout);
        this.aNK.setOnClickListener(this.aNU);
        this.aNN = (ImageView) this.aOj.findViewById(com.baidu.tieba.q.choose_all_threads);
        this.aNN.setVisibility(0);
        this.aNL = this.aOj.findViewById(com.baidu.tieba.q.frs_pop_more_window_good_threads_layout);
        this.aNL.setOnClickListener(this.aNU);
        this.aNO = (ImageView) this.aOj.findViewById(com.baidu.tieba.q.choose_good_threads);
        this.aNM = this.aOj.findViewById(com.baidu.tieba.q.frs_pop_more_window_add_shortcut_layout);
        this.aNM.setOnClickListener(this.aNU);
        if ("M351".equals(Build.MODEL)) {
            this.aNM.setVisibility(8);
        } else {
            this.aNM.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aMk.getPageContext().getPageActivity(), this.aOj, this.mNavigationBar, this.aMk.getResources().getDrawable(com.baidu.tieba.p.bg_pull_down_n), null);
    }

    public void bX(boolean z) {
        if (this.mPopWindow == null) {
            Lc();
        }
        cb(z);
        this.aMk.getLayoutMode().j(this.aOj);
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void Ld() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aMk.getPageContext().getPageActivity());
    }

    public View Le() {
        return this.aOa;
    }

    public View Lf() {
        return this.aNK;
    }

    public View Lg() {
        return this.aNL;
    }

    public View Lh() {
        return this.aNM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView Li() {
        return this.aNy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aNJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Lj() {
        return this.aNz;
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aLO = adVar;
        if (this.aFX != null) {
            this.aFX.a(this.aLO);
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aMk.getPageContext().getPageActivity().getString(com.baidu.tieba.t.view);
        String string2 = this.aMk.getPageContext().getPageActivity().getString(com.baidu.tieba.t.view_host);
        String string3 = this.aMk.getPageContext().getPageActivity().getString(com.baidu.tieba.t.view_reverse);
        this.aNS = new com.baidu.tbadk.core.dialog.e(this.aMk.getPageContext().getPageActivity());
        this.aNS.bx(com.baidu.tieba.t.operation);
        if (z) {
            this.aNS.a(new String[]{string, string3}, this.aNV);
        } else {
            this.aNS.a(new String[]{string, string2, string3}, this.aNV);
        }
        this.aNS.d(this.aMk.getPageContext());
    }

    public void a(com.baidu.tbadk.core.view.aj ajVar) {
        this.mPullView.a(ajVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aND.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.aj ajVar) {
        this.aNE.a(ajVar);
    }

    public void a(com.baidu.adp.widget.ListView.ak akVar) {
        this.aNE.a(akVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aNE.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aNE.k(onClickListener);
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar) {
        this.aNV = hVar;
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.aND.setOnScrollToPullListener(zVar);
    }

    public void Lk() {
        if (this.aNS != null) {
            this.aNS.rN();
        }
    }

    public void onDestroy() {
        if (this.aOg != null) {
            this.aOg = null;
        }
    }

    private Animation Ll() {
        if (this.aNT == null) {
            this.aNT = AnimationUtils.loadAnimation(this.aMk.getPageContext().getPageActivity(), com.baidu.tieba.k.refresh_rotate);
            this.aNT.setInterpolator(new LinearInterpolator());
            this.aNT.setFillAfter(true);
        }
        return this.aNT;
    }

    public void bY(boolean z) {
        this.aNw = z;
        if (z) {
            this.aNA.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aMk, this.aNC, Ll(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.ay.c(this.aNB, com.baidu.tieba.p.pic_fresh_s);
            return;
        }
        this.aNA.setOnTouchListener(this.aOk);
        this.aND.completePullRefresh();
        this.aNC.clearAnimation();
        com.baidu.tbadk.core.util.ay.c(this.aNB, com.baidu.tieba.p.pic_fresh_n);
    }

    public boolean KF() {
        return this.aNw;
    }

    public void Lm() {
        this.aND.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setText("");
            this.aNP.setVisibility(4);
            return;
        }
        this.mTitle.setText(String.valueOf(str) + this.aMk.getPageContext().getPageActivity().getString(com.baidu.tieba.t.forum));
        if (this.aMk.isLogin()) {
            this.aNP.setVisibility(0);
        } else {
            this.aNP.setVisibility(4);
        }
    }

    public void Ln() {
        if (this.aNE != null) {
            this.aNE.notifyDataSetChanged();
        }
    }

    public void bZ(boolean z) {
        this.aNE.bV(z);
    }

    public void ca(boolean z) {
        this.aNE.bW(z);
    }

    private void Lo() {
        if (this.aNG == null) {
            String[] strArr = {this.aMk.getPageContext().getPageActivity().getString(com.baidu.tieba.t.take_photo), this.aMk.getPageContext().getPageActivity().getString(com.baidu.tieba.t.album)};
            this.aNG = new com.baidu.tbadk.core.dialog.e(this.aMk.getPageContext().getPageActivity());
            this.aNG.co(this.aMk.getPageContext().getPageActivity().getString(com.baidu.tieba.t.operation));
            this.aNG.a(strArr, new bo(this));
            this.aNG.d(this.aMk.getPageContext());
        }
    }

    public void Lp() {
        Lo();
        if (this.aNG != null) {
            this.aNG.rN();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, int i, com.baidu.tieba.tbadkCore.w wVar, int i2) {
        this.aNE.a(arrayList, wVar, fa(i), fb(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aNF.setText(com.baidu.tieba.t.frs_nodata);
            this.aNF.setVisibility(0);
            return;
        }
        this.aNF.setVisibility(8);
    }

    public BdListView getListView() {
        return this.aND;
    }

    private boolean fa(int i) {
        return i > 1;
    }

    private boolean fb(int i) {
        return i == 1;
    }

    public void Lq() {
        this.aNE.bV(false);
        this.aNE.bW(false);
        this.aNE.notifyDataSetInvalidated();
    }

    public void fc(int i) {
        this.aND.setSelection(i);
    }

    private void cb(boolean z) {
        if (this.aNN != null && this.aNO != null) {
            if (z) {
                this.aNN.setVisibility(4);
                this.aNO.setVisibility(0);
                return;
            }
            this.aNN.setVisibility(0);
            this.aNO.setVisibility(4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData) {
        if (!this.aOb && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aNZ = forumData.getFrsBannerData();
            Hc();
            this.aDE.reset();
            this.aND.removeHeaderView(this.aDE);
            if (this.aNZ.getType() == 2) {
                this.aOc.setText(this.aNZ.qG());
                this.aOc.setVisibility(0);
            } else if (this.aNZ.getType() == 1 && !TextUtils.isEmpty(this.aNZ.qF())) {
                this.aDE.b(this.aMk.getPageContext(), this.aNZ.qF());
                if (this.aNZ.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aMk.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Lr() {
        if (this.aDE != null) {
            this.aOb = false;
            this.aND.removeHeaderView(this.aDE);
        }
    }

    public void onPause() {
        if (this.aNQ != null) {
            com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aMk.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aFX != null && this.aLO != null) {
            this.aFX.b(this.aLO);
        }
    }

    public void Ls() {
        this.aNI.setVisibility(8);
    }

    public void a(ce ceVar) {
        if (!FrsActivityStatic.aMf || ceVar == null) {
            this.aNI.setVisibility(8);
            return;
        }
        long LJ = FrsActivityStatic.aMg ? ceVar.LJ() + 0 : 0L;
        if (FrsActivityStatic.aMh) {
            LJ += ceVar.LI();
        }
        if (LJ > 0 && this.aNJ.getVisibility() == 0) {
            this.aNI.setVisibility(0);
            if (LJ < 10) {
                this.aNI.setText(String.valueOf(LJ));
                com.baidu.tbadk.core.util.ay.i((View) this.aNI, com.baidu.tieba.p.icon_news_head_prompt_one);
                return;
            } else if (LJ < 100) {
                this.aNI.setText(String.valueOf(LJ));
                com.baidu.tbadk.core.util.ay.i((View) this.aNI, com.baidu.tieba.p.icon_news_head_prompt_two);
                return;
            } else {
                this.aNI.setText("   ");
                com.baidu.tbadk.core.util.ay.i((View) this.aNI, com.baidu.tieba.p.icon_news_head_prompt_more);
                return;
            }
        }
        this.aNI.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cy(i);
        }
        if (this.aNE != null) {
            this.aNE.KS();
            this.aNE.notifyDataSetChanged();
            this.aNE.onChangeSkinType(i);
        }
        this.aMk.Ku();
        this.aMk.getLayoutMode().ab(i == 1);
        this.aMk.getLayoutMode().j(this.aNx);
        this.mNavigationBar.onChangeSkinType(this.aMk.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aMk, i, com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.bg_pull_down_n));
        }
        if (this.aFX != null) {
            this.aFX.onChangeSkinType(this.aMk.getPageContext(), i);
        }
        if (this.aDE != null) {
            this.aDE.oG();
        }
        if (this.aNX != null) {
            this.aNX.onChangeSkinType(this.aMk.getPageContext(), i);
        }
        if (this.aOf != null) {
            this.aOf.cy(i);
        }
    }

    public void cc(boolean z) {
        if (z) {
            this.aNB.setAlpha(128);
            this.aNC.setAlpha(128);
            return;
        }
        this.aNB.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aNC.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void no() {
        this.aND.no();
    }

    public int Lt() {
        return 0;
    }

    public void Lu() {
        this.aNA.setVisibility(0);
    }

    public void Lv() {
        this.aNA.setVisibility(8);
    }

    public am Lw() {
        return this.aNE;
    }

    public View getRootView() {
        return this.aNx;
    }

    public void fd(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aMk.findViewById(com.baidu.tieba.q.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Lx() {
        this.aOa.setClickable(false);
        this.aNH.setVisibility(8);
    }

    public void Ly() {
        this.aOa.setClickable(true);
        this.aNH.setVisibility(0);
    }

    public void Lz() {
        if (com.baidu.tbadk.performanceLog.ah.DB().DC()) {
            int lastVisiblePosition = this.aND.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aND.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof bv) {
                        bv bvVar = (bv) childAt.getTag();
                        if (bvVar.aKy != null) {
                            com.baidu.tbadk.performanceLog.z perfLog = bvVar.aKy.getPerfLog();
                            perfLog.el(1000);
                            perfLog.aqw = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                bvVar.aKy.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bvVar.aKy.uq();
                        }
                        if (bvVar.aKu != null && (bvVar.aKu instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = bvVar.aKu;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.z perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.el(1000);
                                    perfLog2.aqw = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.uq();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof au) {
                        au auVar = (au) childAt.getTag();
                        if (auVar.aMN != null) {
                            com.baidu.tbadk.performanceLog.z perfLog3 = auVar.aMN.getPerfLog();
                            perfLog3.el(1000);
                            perfLog3.aqw = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                auVar.aMN.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            auVar.aMN.uq();
                        }
                        if (auVar.aMR != null && (auVar.aMR instanceof TbImageView)) {
                            TbImageView tbImageView2 = auVar.aMR;
                            com.baidu.tbadk.performanceLog.z perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.el(1000);
                            perfLog4.aqw = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.uq();
                        }
                    }
                    if (childAt.getTag() instanceof ay) {
                        ay ayVar = (ay) childAt.getTag();
                        if (ayVar.aNc != null && ayVar.aNc.aBk != null && (ayVar.aNc.aBk instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.z perfLog5 = ayVar.aNc.aBk.getPerfLog();
                            perfLog5.el(1000);
                            perfLog5.aqw = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                ayVar.aNc.aBk.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            ayVar.aNc.aBk.uq();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (ayVar.aBf != null) {
                            arrayList.add(ayVar.aBf);
                        }
                        if (ayVar.aBg != null) {
                            arrayList.add(ayVar.aBg);
                        }
                        if (ayVar.aBh != null) {
                            arrayList.add(ayVar.aBh);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.z perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.el(1000);
                                perfLog6.aqw = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.uq();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar getNavigationBar() {
        return this.mNavigationBar;
    }

    public FrsOfficalBanner LA() {
        return this.aOc;
    }

    public void LB() {
        this.aND.setNextPage(this.aOf);
        this.aOf.startLoadData();
    }

    public void LC() {
        this.aND.setNextPage(this.aOf);
        this.aOf.ux();
        this.aOf.setText(this.aMk.getResources().getString(com.baidu.tieba.t.list_no_more));
    }

    public void LD() {
        this.aND.setNextPage(null);
    }
}
