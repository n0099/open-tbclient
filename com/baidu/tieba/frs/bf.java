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
    private static /* synthetic */ int[] aOm;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aFY;
    private com.baidu.tieba.tbadkCore.w aLm;
    private FrsActivity aMl;
    private View aNA;
    private am aNF;
    private View aNI;
    private View aNL;
    private View aNM;
    private View aNN;
    private ImageView aNO;
    private ImageView aNP;
    private ImageView aNQ;
    private View.OnClickListener aNV;
    private ImageView aNX;
    private com.baidu.tbadk.coreExtra.view.q aNY;
    private LinearLayout aNZ;
    private com.baidu.tbadk.core.data.k aOa;
    private View aOb;
    private FrsOfficalBanner aOd;
    private View aOe;
    private PbListView aOg;
    private CustomMessageListener aOh;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private TextView mTitle;
    private boolean aNx = false;
    private NoPressedRelativeLayout aNy = null;
    private ImageView aNz = null;
    private FrameLayout aNB = null;
    private ImageView aNC = null;
    private ImageView aND = null;
    private BdTypeListView aNE = null;
    private TextView aNG = null;
    private com.baidu.tbadk.core.dialog.e aNH = null;
    private TextView aNJ = null;
    private View aNK = null;
    private com.baidu.tbadk.core.view.al mPullView = null;
    private com.baidu.tieba.tbadkCore.ac aNR = null;
    private String aNS = null;
    com.baidu.tbadk.core.dialog.e aNT = null;
    Animation aNU = null;
    private com.baidu.tbadk.core.dialog.h aNW = null;
    private com.baidu.tbadk.core.view.ad aLP = null;
    private BannerView aDF = null;
    private boolean aOc = false;
    private boolean aOf = false;
    com.baidu.tbadk.coreExtra.view.b aOi = new bg(this);
    com.baidu.tbadk.coreExtra.view.b aOj = new bh(this);
    View aOk = null;
    private View.OnTouchListener aOl = new bi(this);

    static /* synthetic */ int[] LF() {
        int[] iArr = aOm;
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
            aOm = iArr;
        }
        return iArr;
    }

    public bf(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aMl = null;
        this.aNV = null;
        this.aMl = frsActivity;
        this.aNV = onClickListener;
        initUI();
    }

    public void b(com.baidu.tieba.tbadkCore.w wVar) {
        this.aLm = wVar;
        this.aNX.setVisibility(8);
        if (this.aNY != null && this.aNY.getVisibility() != 0 && wVar != null && wVar.aas() != null && wVar.aas().getAnchorPower() != null && wVar.aas().getAnchorPower().have_power.intValue() != 0 && TbadkCoreApplication.m411getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aNX.setVisibility(0);
        }
    }

    private void initUI() {
        this.aNy = (NoPressedRelativeLayout) this.aMl.findViewById(com.baidu.tieba.q.frs);
        this.mNavigationBar = (NavigationBar) this.aMl.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.aOd = (FrsOfficalBanner) this.aMl.findViewById(com.baidu.tieba.q.frs_offical_banner);
        this.aOd.setBannerViewClickListener(this.aOj);
        this.aNA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aNA.setOnClickListener(this.aNV);
        this.aOb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.r.frs_icon_bottom_title, (View.OnClickListener) null);
        this.mTitle = (TextView) this.aOb.findViewById(com.baidu.tieba.q.navigationTitle_frs);
        this.aNQ = (ImageView) this.aOb.findViewById(com.baidu.tieba.q.icon_bottom_title_image);
        this.aOb.setOnClickListener(this.aNV);
        this.aNZ = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.nb_item_frs_live, (View.OnClickListener) null);
        this.aNX = (ImageView) this.aNZ.findViewById(com.baidu.tieba.q.nb_item_live_text_btn);
        this.aNX.setOnClickListener(this.aNV);
        if (this.aOh == null) {
            this.aOh = new bj(this, 0);
            this.aMl.registerListener(2001269, this.aOh);
        }
        this.aMl.sendMessage(new CustomMessage(2001269, this.aMl.getPageContext().getPageActivity()));
        this.aOe = this.aMl.findViewById(com.baidu.tieba.q.frs_list_content);
        this.aNz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.widget_nb_item_edit, this.aNV);
        this.aNI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.nb_item_frs_more, (View.OnClickListener) null);
        this.aNK = this.aNI.findViewById(com.baidu.tieba.q.frs_top_more);
        this.aNK.setOnClickListener(this.aNV);
        this.aNJ = (TextView) this.aNI.findViewById(com.baidu.tieba.q.frs_more_mes_text);
        this.aNB = (FrameLayout) this.aMl.findViewById(com.baidu.tieba.q.refresh_layout);
        this.aNC = (ImageView) this.aMl.findViewById(com.baidu.tieba.q.refresh_bg);
        this.aND = (ImageView) this.aMl.findViewById(com.baidu.tieba.q.refresh_icon);
        this.aNE = (BdTypeListView) this.aMl.findViewById(com.baidu.tieba.q.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.al(this.aMl.getPageContext());
        this.aNE.setDivider(null);
        this.aNE.setPullRefresh(this.mPullView);
        this.aNE.setDividerHeight(0);
        this.aNE.setRecyclerListener(new bl(this));
        this.aOg = new PbListView(this.aMl.getPageContext().getPageActivity());
        this.aOg.ng();
        this.aOg.cx(com.baidu.tieba.n.cp_bg_line_c);
        this.aNE.setOnSrollToBottomListener(this.aMl);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ak(new bm(this)));
        this.aNF = new am(this.aMl, this.aNE, com.baidu.tbadk.core.util.bc.tB().tD());
        this.aNG = (TextView) this.aMl.findViewById(com.baidu.tieba.q.frs_noexist_post);
        this.aNG.setVisibility(8);
        this.aNB.setOnClickListener(this.aNV);
        this.aNB.setOnTouchListener(this.aOl);
        this.aFY = (NoNetworkView) this.aMl.findViewById(com.baidu.tieba.q.view_no_network);
        bY(false);
    }

    private void Hd() {
        if (this.aDF == null) {
            this.aDF = new BannerView(this.aMl.getPageContext().getPageActivity());
            this.aDF.setLayoutParams(new AbsListView.LayoutParams(-1, this.aMl.getResources().getDimensionPixelSize(com.baidu.tieba.o.frs_header_banner_height)));
            this.aDF.setVisibility(8);
            this.aDF.setBannerViewClickListener(this.aOj);
            this.aDF.setBannerViewEvent(new bn(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Lc() {
        if (TextUtils.equals(this.aNS, "frs_page")) {
            TiebaStatic.eventStat(this.aMl.getPageContext().getPageActivity(), "top_banner_ck", "click");
        }
        if (this.aOa != null) {
            String value = this.aOa.getValue();
            if (this.aOa.qE() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.aMl.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aOa.qE() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aMl.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aMl.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aOa.qE() == 3) {
                new com.baidu.tbadk.core.util.bp();
                com.baidu.tbadk.core.util.bp isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.Wp != UtilHelper.NativePageType.NONE) {
                    switch (LF()[isNativeAddress.Wp.ordinal()]) {
                        case 2:
                            this.aMl.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aMl.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aMl.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aMl.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bi.tO().b(this.aMl.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aMl.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aOa.qE() == 4) {
                this.aMl.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aMl.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void Ld() {
        this.aOk = com.baidu.adp.lib.g.b.hr().inflate(this.aMl.getPageContext().getPageActivity(), com.baidu.tieba.r.frs_pop_more_window, null);
        this.aNL = this.aOk.findViewById(com.baidu.tieba.q.frs_pop_more_window_all_threads_layout);
        this.aNL.setOnClickListener(this.aNV);
        this.aNO = (ImageView) this.aOk.findViewById(com.baidu.tieba.q.choose_all_threads);
        this.aNO.setVisibility(0);
        this.aNM = this.aOk.findViewById(com.baidu.tieba.q.frs_pop_more_window_good_threads_layout);
        this.aNM.setOnClickListener(this.aNV);
        this.aNP = (ImageView) this.aOk.findViewById(com.baidu.tieba.q.choose_good_threads);
        this.aNN = this.aOk.findViewById(com.baidu.tieba.q.frs_pop_more_window_add_shortcut_layout);
        this.aNN.setOnClickListener(this.aNV);
        if ("M351".equals(Build.MODEL)) {
            this.aNN.setVisibility(8);
        } else {
            this.aNN.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aMl.getPageContext().getPageActivity(), this.aOk, this.mNavigationBar, this.aMl.getResources().getDrawable(com.baidu.tieba.p.bg_pull_down_n), null);
    }

    public void bX(boolean z) {
        if (this.mPopWindow == null) {
            Ld();
        }
        cb(z);
        this.aMl.getLayoutMode().j(this.aOk);
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void Le() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aMl.getPageContext().getPageActivity());
    }

    public View Lf() {
        return this.aOb;
    }

    public View Lg() {
        return this.aNL;
    }

    public View Lh() {
        return this.aNM;
    }

    public View Li() {
        return this.aNN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView Lj() {
        return this.aNz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aNK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Lk() {
        return this.aNA;
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aLP = adVar;
        if (this.aFY != null) {
            this.aFY.a(this.aLP);
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aMl.getPageContext().getPageActivity().getString(com.baidu.tieba.t.view);
        String string2 = this.aMl.getPageContext().getPageActivity().getString(com.baidu.tieba.t.view_host);
        String string3 = this.aMl.getPageContext().getPageActivity().getString(com.baidu.tieba.t.view_reverse);
        this.aNT = new com.baidu.tbadk.core.dialog.e(this.aMl.getPageContext().getPageActivity());
        this.aNT.bx(com.baidu.tieba.t.operation);
        if (z) {
            this.aNT.a(new String[]{string, string3}, this.aNW);
        } else {
            this.aNT.a(new String[]{string, string2, string3}, this.aNW);
        }
        this.aNT.d(this.aMl.getPageContext());
    }

    public void a(com.baidu.tbadk.core.view.aj ajVar) {
        this.mPullView.a(ajVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aNE.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.aj ajVar) {
        this.aNF.a(ajVar);
    }

    public void a(com.baidu.adp.widget.ListView.ak akVar) {
        this.aNF.a(akVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aNF.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aNF.k(onClickListener);
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar) {
        this.aNW = hVar;
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.aNE.setOnScrollToPullListener(zVar);
    }

    public void Ll() {
        if (this.aNT != null) {
            this.aNT.rN();
        }
    }

    public void onDestroy() {
        if (this.aOh != null) {
            this.aOh = null;
        }
    }

    private Animation Lm() {
        if (this.aNU == null) {
            this.aNU = AnimationUtils.loadAnimation(this.aMl.getPageContext().getPageActivity(), com.baidu.tieba.k.refresh_rotate);
            this.aNU.setInterpolator(new LinearInterpolator());
            this.aNU.setFillAfter(true);
        }
        return this.aNU;
    }

    public void bY(boolean z) {
        this.aNx = z;
        if (z) {
            this.aNB.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aMl, this.aND, Lm(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.ay.c(this.aNC, com.baidu.tieba.p.pic_fresh_s);
            return;
        }
        this.aNB.setOnTouchListener(this.aOl);
        this.aNE.completePullRefresh();
        this.aND.clearAnimation();
        com.baidu.tbadk.core.util.ay.c(this.aNC, com.baidu.tieba.p.pic_fresh_n);
    }

    public boolean KG() {
        return this.aNx;
    }

    public void Ln() {
        this.aNE.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setText("");
            this.aNQ.setVisibility(4);
            return;
        }
        this.mTitle.setText(String.valueOf(str) + this.aMl.getPageContext().getPageActivity().getString(com.baidu.tieba.t.forum));
        if (this.aMl.isLogin()) {
            this.aNQ.setVisibility(0);
        } else {
            this.aNQ.setVisibility(4);
        }
    }

    public void Lo() {
        if (this.aNF != null) {
            this.aNF.notifyDataSetChanged();
        }
    }

    public void bZ(boolean z) {
        this.aNF.bV(z);
    }

    public void ca(boolean z) {
        this.aNF.bW(z);
    }

    private void Lp() {
        if (this.aNH == null) {
            String[] strArr = {this.aMl.getPageContext().getPageActivity().getString(com.baidu.tieba.t.take_photo), this.aMl.getPageContext().getPageActivity().getString(com.baidu.tieba.t.album)};
            this.aNH = new com.baidu.tbadk.core.dialog.e(this.aMl.getPageContext().getPageActivity());
            this.aNH.co(this.aMl.getPageContext().getPageActivity().getString(com.baidu.tieba.t.operation));
            this.aNH.a(strArr, new bo(this));
            this.aNH.d(this.aMl.getPageContext());
        }
    }

    public void Lq() {
        Lp();
        if (this.aNH != null) {
            this.aNH.rN();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList, int i, com.baidu.tieba.tbadkCore.w wVar, int i2) {
        this.aNF.a(arrayList, wVar, fa(i), fb(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aNG.setText(com.baidu.tieba.t.frs_nodata);
            this.aNG.setVisibility(0);
            return;
        }
        this.aNG.setVisibility(8);
    }

    public BdListView getListView() {
        return this.aNE;
    }

    private boolean fa(int i) {
        return i > 1;
    }

    private boolean fb(int i) {
        return i == 1;
    }

    public void Lr() {
        this.aNF.bV(false);
        this.aNF.bW(false);
        this.aNF.notifyDataSetInvalidated();
    }

    public void fc(int i) {
        this.aNE.setSelection(i);
    }

    private void cb(boolean z) {
        if (this.aNO != null && this.aNP != null) {
            if (z) {
                this.aNO.setVisibility(4);
                this.aNP.setVisibility(0);
                return;
            }
            this.aNO.setVisibility(0);
            this.aNP.setVisibility(4);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData) {
        if (!this.aOc && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aOa = forumData.getFrsBannerData();
            Hd();
            this.aDF.reset();
            this.aNE.removeHeaderView(this.aDF);
            if (this.aOa.getType() == 2) {
                this.aOd.setText(this.aOa.qG());
                this.aOd.setVisibility(0);
            } else if (this.aOa.getType() == 1 && !TextUtils.isEmpty(this.aOa.qF())) {
                this.aDF.b(this.aMl.getPageContext(), this.aOa.qF());
                if (this.aOa.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aMl.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Ls() {
        if (this.aDF != null) {
            this.aOc = false;
            this.aNE.removeHeaderView(this.aDF);
        }
    }

    public void onPause() {
        if (this.aNR != null) {
            com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aMl.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.aFY != null && this.aLP != null) {
            this.aFY.b(this.aLP);
        }
    }

    public void Lt() {
        this.aNJ.setVisibility(8);
    }

    public void a(ce ceVar) {
        if (!FrsActivityStatic.aMg || ceVar == null) {
            this.aNJ.setVisibility(8);
            return;
        }
        long LK = FrsActivityStatic.aMh ? ceVar.LK() + 0 : 0L;
        if (FrsActivityStatic.aMi) {
            LK += ceVar.LJ();
        }
        if (LK > 0 && this.aNK.getVisibility() == 0) {
            this.aNJ.setVisibility(0);
            if (LK < 10) {
                this.aNJ.setText(String.valueOf(LK));
                com.baidu.tbadk.core.util.ay.i((View) this.aNJ, com.baidu.tieba.p.icon_news_head_prompt_one);
                return;
            } else if (LK < 100) {
                this.aNJ.setText(String.valueOf(LK));
                com.baidu.tbadk.core.util.ay.i((View) this.aNJ, com.baidu.tieba.p.icon_news_head_prompt_two);
                return;
            } else {
                this.aNJ.setText("   ");
                com.baidu.tbadk.core.util.ay.i((View) this.aNJ, com.baidu.tieba.p.icon_news_head_prompt_more);
                return;
            }
        }
        this.aNJ.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cy(i);
        }
        if (this.aNF != null) {
            this.aNF.KT();
            this.aNF.notifyDataSetChanged();
            this.aNF.onChangeSkinType(i);
        }
        this.aMl.Kv();
        this.aMl.getLayoutMode().ab(i == 1);
        this.aMl.getLayoutMode().j(this.aNy);
        this.mNavigationBar.onChangeSkinType(this.aMl.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aMl, i, com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.bg_pull_down_n));
        }
        if (this.aFY != null) {
            this.aFY.onChangeSkinType(this.aMl.getPageContext(), i);
        }
        if (this.aDF != null) {
            this.aDF.oG();
        }
        if (this.aNY != null) {
            this.aNY.onChangeSkinType(this.aMl.getPageContext(), i);
        }
        if (this.aOg != null) {
            this.aOg.cy(i);
        }
    }

    public void cc(boolean z) {
        if (z) {
            this.aNC.setAlpha(128);
            this.aND.setAlpha(128);
            return;
        }
        this.aNC.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aND.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void no() {
        this.aNE.no();
    }

    public int Lu() {
        return 0;
    }

    public void Lv() {
        this.aNB.setVisibility(0);
    }

    public void Lw() {
        this.aNB.setVisibility(8);
    }

    public am Lx() {
        return this.aNF;
    }

    public View getRootView() {
        return this.aNy;
    }

    public void fd(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aMl.findViewById(com.baidu.tieba.q.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Ly() {
        this.aOb.setClickable(false);
        this.aNI.setVisibility(8);
    }

    public void Lz() {
        this.aOb.setClickable(true);
        this.aNI.setVisibility(0);
    }

    public void LA() {
        if (com.baidu.tbadk.performanceLog.ah.DC().DD()) {
            int lastVisiblePosition = this.aNE.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aNE.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof bv) {
                        bv bvVar = (bv) childAt.getTag();
                        if (bvVar.aKz != null) {
                            com.baidu.tbadk.performanceLog.z perfLog = bvVar.aKz.getPerfLog();
                            perfLog.el(1000);
                            perfLog.aqw = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                bvVar.aKz.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bvVar.aKz.uq();
                        }
                        if (bvVar.aKv != null && (bvVar.aKv instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = bvVar.aKv;
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
                        if (auVar.aMO != null) {
                            com.baidu.tbadk.performanceLog.z perfLog3 = auVar.aMO.getPerfLog();
                            perfLog3.el(1000);
                            perfLog3.aqw = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                auVar.aMO.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            auVar.aMO.uq();
                        }
                        if (auVar.aMS != null && (auVar.aMS instanceof TbImageView)) {
                            TbImageView tbImageView2 = auVar.aMS;
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
                        if (ayVar.aNd != null && ayVar.aNd.aBl != null && (ayVar.aNd.aBl instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.z perfLog5 = ayVar.aNd.aBl.getPerfLog();
                            perfLog5.el(1000);
                            perfLog5.aqw = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                ayVar.aNd.aBl.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            ayVar.aNd.aBl.uq();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (ayVar.aBg != null) {
                            arrayList.add(ayVar.aBg);
                        }
                        if (ayVar.aBh != null) {
                            arrayList.add(ayVar.aBh);
                        }
                        if (ayVar.aBi != null) {
                            arrayList.add(ayVar.aBi);
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

    public FrsOfficalBanner LB() {
        return this.aOd;
    }

    public void LC() {
        this.aNE.setNextPage(this.aOg);
        this.aOg.startLoadData();
    }

    public void LD() {
        this.aNE.setNextPage(this.aOg);
        this.aOg.ux();
        this.aOg.setText(this.aMl.getResources().getString(com.baidu.tieba.t.list_no_more));
    }

    public void LE() {
        this.aNE.setNextPage(null);
    }
}
