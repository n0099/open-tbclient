package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bq {
    private static /* synthetic */ int[] aFf;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private PbEditor aBE;
    private FrsActivity aDc;
    private ImageView aEA;
    private View.OnClickListener aEH;
    private int aEJ;
    private int aEK;
    private TextView aEL;
    private com.baidu.tbadk.coreExtra.view.q aEM;
    private LinearLayout aEN;
    private com.baidu.tbadk.core.data.i aEO;
    private View aEP;
    private com.baidu.adp.lib.guide.d aER;
    private FrsOfficalBanner aES;
    private Runnable aEU;
    private View aEV;
    private com.baidu.tieba.tbadkCore.e aEY;
    private CustomMessageListener aEZ;
    private View aEi;
    private az aEn;
    private View aEv;
    private View aEw;
    private View aEx;
    private ImageView aEy;
    private ImageView aEz;
    private NoNetworkView awR;
    private int mIsLike;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private TextView mTitle;
    private boolean aEf = false;
    private RelativeLayout Qa = null;
    private FrameLayout aEg = null;
    private ImageView aEh = null;
    private FrameLayout aEj = null;
    private ImageView aEk = null;
    private ImageView aEl = null;
    private BdTypeListView aEm = null;
    private TextView aEo = null;
    private AlertDialog aAR = null;
    private FrsHeaderView aEp = null;
    private com.baidu.tieba.frs.view.o aEq = null;
    private com.baidu.tieba.frs.view.e aEr = null;
    private bj aEs = null;
    private TextView aEt = null;
    private View aEu = null;
    private int mSkinType = 0;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private db aEB = null;
    private com.baidu.tieba.tbadkCore.z aEC = null;
    private SlidingMenu aED = null;
    private String aEE = null;
    AlertDialog aEF = null;
    Animation aEG = null;
    private DialogInterface.OnClickListener aEI = null;
    private com.baidu.tbadk.core.view.ad aCN = null;
    private BannerView asL = null;
    private boolean aEQ = false;
    private boolean aET = false;
    private boolean aEW = false;
    private boolean aEX = false;
    com.baidu.tbadk.coreExtra.view.b aFa = new br(this);
    com.baidu.tbadk.coreExtra.view.b aFb = new bw(this);
    View aFc = null;
    private View.OnTouchListener aFd = new bx(this);
    private com.baidu.tieba.tbadkCore.bubble.y aFe = new by(this);
    private com.baidu.tieba.tbadkCore.af aBF = null;

    static /* synthetic */ int[] GQ() {
        int[] iArr = aFf;
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
            aFf = iArr;
        }
        return iArr;
    }

    public bq(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aDc = null;
        this.aEH = null;
        this.aDc = frsActivity;
        this.aEH = onClickListener;
        initUI();
    }

    public void f(com.baidu.tieba.tbadkCore.e eVar) {
        this.aEY = eVar;
        this.aEL.setVisibility(8);
        if (this.aEM != null && this.aEM.getVisibility() != 0 && eVar != null && eVar.aej() != null && eVar.aej().getAnchorPower() != null && eVar.aej().getAnchorPower().have_power.intValue() != 0 && TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aEL.setVisibility(0);
        }
    }

    private void initUI() {
        this.Qa = (RelativeLayout) this.aDc.findViewById(com.baidu.tieba.w.frs);
        this.aED = new SlidingMenu(this.aDc.getPageContext().getPageActivity());
        this.aED.setMode(1);
        this.aED.setTouchModeAbove(1);
        this.aED.setBehindOffset(com.baidu.adp.lib.util.l.dip2px(this.aDc.getPageContext().getPageActivity(), 48.0f));
        this.aED.setBehindScrollScale(0.5f);
        this.aED.setFadeDegree(0.35f);
        this.aED.attachToActivity(this.aDc.getPageContext().getPageActivity(), 1);
        this.mNavigationBar = (NavigationBar) this.aDc.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.aES = (FrsOfficalBanner) this.aDc.findViewById(com.baidu.tieba.w.frs_offical_banner);
        this.aES.setBannerViewClickListener(this.aFb);
        this.aEi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aEi.setOnClickListener(this.aEH);
        this.aEP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.x.frs_icon_bottom_title, (View.OnClickListener) null);
        this.mTitle = (TextView) this.aEP.findViewById(com.baidu.tieba.w.navigationTitle_frs);
        this.aEA = (ImageView) this.aEP.findViewById(com.baidu.tieba.w.icon_bottom_title_image);
        this.aEP.setOnClickListener(this.aEH);
        this.aEN = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_frs_live, (View.OnClickListener) null);
        this.aEL = (TextView) this.aEN.findViewById(com.baidu.tieba.w.nb_item_live_text_btn);
        this.aEL.setOnClickListener(this.aEH);
        if (this.aEZ == null) {
            this.aEZ = new bz(this, 0);
            this.aDc.registerListener(2001269, this.aEZ);
        }
        this.aDc.sendMessage(new CustomMessage(2001269, this.aDc.getPageContext().getPageActivity()));
        this.aEV = this.aDc.findViewById(com.baidu.tieba.w.frs_list_content);
        this.aEh = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_edit, this.aEH);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_frs_more, (View.OnClickListener) null);
        this.aEu = addCustomView.findViewById(com.baidu.tieba.w.frs_top_more);
        this.aEu.setOnClickListener(this.aEH);
        this.aEt = (TextView) addCustomView.findViewById(com.baidu.tieba.w.frs_more_mes_text);
        this.aEj = (FrameLayout) this.aDc.findViewById(com.baidu.tieba.w.refresh_layout);
        this.aEk = (ImageView) this.aDc.findViewById(com.baidu.tieba.w.refresh_bg);
        this.aEl = (ImageView) this.aDc.findViewById(com.baidu.tieba.w.refresh_icon);
        this.aEm = (BdTypeListView) this.aDc.findViewById(com.baidu.tieba.w.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.ak(this.aDc.getPageContext().getPageActivity());
        this.aEm.setDivider(null);
        this.aEm.setOnScrollToPullListener(new cb(this));
        this.aEm.setPullRefresh(this.mPullView);
        this.aEm.setDividerHeight(0);
        this.aEm.setRecyclerListener(new cc(this));
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ah(new cd(this)));
        this.aEn = new az(this.aDc, this.aEm, com.baidu.tbadk.core.util.bb.px().pz());
        this.aEo = (TextView) this.aDc.findViewById(com.baidu.tieba.w.frs_noexist_post);
        this.aEo.setVisibility(8);
        this.aEj.setOnClickListener(this.aEH);
        this.aEj.setOnTouchListener(this.aFd);
        this.awR = (NoNetworkView) this.aDc.findViewById(com.baidu.tieba.w.view_no_network);
        bM(false);
        this.aEW = TbadkSettings.getInst().loadBoolean(FrsActivity.aBI, false);
    }

    private void CH() {
        if (this.asL == null) {
            this.asL = new BannerView(this.aDc.getPageContext().getPageActivity());
            this.asL.setLayoutParams(new AbsListView.LayoutParams(-1, this.aDc.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_banner_height)));
            this.asL.setVisibility(8);
            this.asL.setBannerViewClickListener(this.aFb);
            this.asL.setBannerViewEvent(new ce(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Gc() {
        if (TextUtils.equals(this.aEE, "frs_page")) {
            TiebaStatic.eventStat(this.aDc.getPageContext().getPageActivity(), "top_banner_ck", "click");
        }
        if (this.aEO != null) {
            String value = this.aEO.getValue();
            if (this.aEO.mI() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.aDc.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aEO.mI() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aDc.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aDc.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aEO.mI() == 3) {
                new com.baidu.tbadk.core.util.bo();
                com.baidu.tbadk.core.util.bo isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.JE != UtilHelper.NativePageType.NONE) {
                    switch (GQ()[isNativeAddress.JE.ordinal()]) {
                        case 2:
                            this.aDc.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aDc.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aDc.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aDc.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bh.pK().b(this.aDc.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aDc.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601");
                }
            } else if (this.aEO.mI() == 4) {
                this.aDc.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aDc.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void Gd() {
        this.aFc = com.baidu.adp.lib.g.b.ek().inflate(this.aDc.getPageContext().getPageActivity(), com.baidu.tieba.x.frs_pop_more_window, null);
        this.aEv = this.aFc.findViewById(com.baidu.tieba.w.frs_pop_more_window_all_threads_layout);
        this.aEv.setOnClickListener(this.aEH);
        this.aEy = (ImageView) this.aFc.findViewById(com.baidu.tieba.w.choose_all_threads);
        this.aEy.setVisibility(0);
        this.aEw = this.aFc.findViewById(com.baidu.tieba.w.frs_pop_more_window_good_threads_layout);
        this.aEw.setOnClickListener(this.aEH);
        this.aEz = (ImageView) this.aFc.findViewById(com.baidu.tieba.w.choose_good_threads);
        this.aEx = this.aFc.findViewById(com.baidu.tieba.w.frs_pop_more_window_add_shortcut_layout);
        this.aEx.setOnClickListener(this.aEH);
        if ("M351".equals(Build.MODEL)) {
            this.aEx.setVisibility(8);
        } else {
            this.aEx.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aDc.getPageContext().getPageActivity(), this.aFc, this.mNavigationBar, this.aDc.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_n), null);
    }

    public void bL(boolean z) {
        if (this.mPopWindow == null) {
            Gd();
        }
        bP(z);
        this.aDc.getLayoutMode().h(this.aFc);
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void Ge() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aDc.getPageContext().getPageActivity());
    }

    public void Gf() {
        if (TbadkCoreApplication.m255getInst().isFirstGoFrs()) {
            TbadkCoreApplication.m255getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(this.mNavigationBar).I(0).v(false);
            gVar.a(new bs(this));
            this.aER = gVar.dz();
            this.aER.i(this.aDc.getPageContext().getPageActivity());
        }
    }

    public void Gg() {
        if ("normal_page".equals(this.aEE)) {
            if (this.aEp != null) {
                this.aEp.Gg();
            }
        } else if ("frs_page".equals(this.aEE) && this.aEq != null) {
            this.aEq.Gg();
        }
    }

    public View Gh() {
        return this.aEP;
    }

    public View Gi() {
        return this.aEv;
    }

    public View Gj() {
        return this.aEw;
    }

    public View Gk() {
        return this.aEx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView Gl() {
        return this.aEh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aEu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Gm() {
        return this.aEi;
    }

    public boolean Gn() {
        if ("normal_page".equals(this.aEE)) {
            if (this.aEp != null) {
                return this.aEp.Gn();
            }
        } else if ("frs_page".equals(this.aEE) && this.aEq != null) {
            return this.aEq.Gn();
        }
        return false;
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aCN = adVar;
        if (this.awR != null) {
            this.awR.a(this.aCN);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.aED.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.aED.setOnOpenedListener(onOpenedListener);
    }

    public db Go() {
        if (this.aEB == null) {
            this.aEB = new db(this.aDc.getPageContext());
            this.aED.setMenu(this.aEB.getView());
            this.aEB.n(this.aEH);
            this.aEB.changeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.aEB.init();
        }
        return this.aEB;
    }

    public SlidingMenu Gp() {
        return this.aED;
    }

    public void showMenu(boolean z) {
        this.aED.showMenu(z);
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aDc.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view);
        String string2 = this.aDc.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view_host);
        String string3 = this.aDc.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aDc.getPageContext().getPageActivity());
        builder.setTitle(com.baidu.tieba.z.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.aEI);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.aEI);
        }
        this.aEF = builder.create();
        this.aEF.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aEm.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        this.aEn.a(anVar);
    }

    public void a(com.baidu.adp.widget.ListView.ao aoVar) {
        this.aEn.a(aoVar);
    }

    public void j(View.OnClickListener onClickListener) {
        this.aEn.j(onClickListener);
    }

    public void l(View.OnClickListener onClickListener) {
        this.aEn.k(onClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.aEI = onClickListener;
    }

    public void Gq() {
        if (this.aEF != null) {
            com.baidu.adp.lib.g.k.a(this.aEF, this.aDc.getPageContext());
        }
    }

    public void onDestroy() {
        if (this.aEp != null) {
            this.aEp.onDestory();
        }
        if (this.aEq != null) {
            this.aEq.onDestory();
        }
        if (this.aEU != null) {
            this.aDc.mHandler.removeCallbacks(this.aEU);
        }
        if (this.aBF != null) {
            this.aDc.mHandler.removeCallbacks(this.aBF);
        }
        if (this.aEZ != null) {
            this.aEZ = null;
        }
    }

    private Animation Gr() {
        if (this.aEG == null) {
            this.aEG = AnimationUtils.loadAnimation(this.aDc.getPageContext().getPageActivity(), com.baidu.tieba.q.refresh_rotate);
            this.aEG.setInterpolator(new LinearInterpolator());
            this.aEG.setFillAfter(true);
        }
        return this.aEG;
    }

    public void bM(boolean z) {
        this.aEf = z;
        if (z) {
            this.aEj.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aDc, this.aEl, Gr(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.ax.c(this.aEk, com.baidu.tieba.v.pic_fresh_s);
            return;
        }
        this.aEj.setOnTouchListener(this.aFd);
        this.aEm.jJ();
        this.aEl.clearAnimation();
        com.baidu.tbadk.core.util.ax.c(this.aEk, com.baidu.tieba.v.pic_fresh_n);
    }

    public boolean Gs() {
        return this.aEf;
    }

    public FrsHeaderView Gt() {
        return this.aEp;
    }

    public com.baidu.tieba.frs.view.o Gu() {
        return this.aEq;
    }

    public void Gv() {
        this.aEm.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setText("");
            this.aEA.setVisibility(4);
            return;
        }
        this.mTitle.setText(String.valueOf(str) + this.aDc.getPageContext().getPageActivity().getString(com.baidu.tieba.z.forum));
        this.aEA.setVisibility(0);
    }

    public void Gw() {
        if (this.aEn != null) {
            this.aEn.notifyDataSetChanged();
        }
    }

    public void L(int i, int i2) {
        this.mIsLike = i2;
        Gz();
        this.aEE = "normal_page";
        if (this.aEp == null) {
            this.aEp = new FrsHeaderView(this.aDc, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aEp.changeSkinType(this.mSkinType);
            this.aEp.n(this.aEH);
        }
        this.aEm.addHeaderView(this.aEp.getView());
        Gx();
    }

    public void M(int i, int i2) {
        this.mIsLike = i2;
        Gz();
        this.aEE = "frs_page";
        eL(i);
        this.aEm.addHeaderView(this.aEq.getView());
        Gx();
    }

    private void Gx() {
        if (this.aEU == null) {
            this.aEU = new bt(this);
        }
        this.aDc.mHandler.postDelayed(this.aEU, 4000L);
    }

    private void eL(int i) {
        if (this.aEq == null) {
            this.aEq = new com.baidu.tieba.frs.view.o(this.aDc.getPageContext(), null, null, i);
            this.aEq.changeSkinType(this.mSkinType);
            this.aEq.setBannerViewClickListener(this.aFa);
            this.aEq.n(this.aEH);
        }
    }

    public void Gy() {
        Gz();
        this.aEE = "good_page";
        if (this.aEr == null) {
            this.aEr = new com.baidu.tieba.frs.view.e(this.aDc.getPageContext().getPageActivity());
            this.aEr.changeSkinType(this.mSkinType);
        }
        this.aEm.addHeaderView(this.aEr.getView());
    }

    private void Gz() {
        if ("normal_page".equals(this.aEE) && this.aEp != null) {
            this.aEm.removeHeaderView(this.aEp.getView());
        } else if ("frs_page".equals(this.aEE) && this.aEq != null) {
            this.aEm.removeHeaderView(this.aEq.getView());
        } else if ("good_page".equals(this.aEE) && this.aEr != null) {
            this.aEm.removeHeaderView(this.aEr.getView());
        }
    }

    public void GA() {
        if (this.aEp != null) {
            this.aEp.Hh().setVisibility(0);
        }
    }

    public void GB() {
        if (this.aEp != null) {
            this.aEp.Hh().setVisibility(8);
        }
    }

    public void GC() {
        if (this.aEq != null) {
            this.aEq.Hh().setVisibility(0);
        }
    }

    public void GD() {
        if (this.aEq != null) {
            this.aEq.Hh().setVisibility(8);
        }
    }

    public boolean GE() {
        if ("normal_page".equals(this.aEE) && this.aEp != null) {
            return this.aEp.GE();
        }
        if ("frs_page".equals(this.aEE) && this.aEq != null) {
            return this.aEq.GE();
        }
        return false;
    }

    public boolean GF() {
        if ("normal_page".equals(this.aEE) && this.aEp != null) {
            return this.aEp.Ha();
        }
        if ("frs_page".equals(this.aEE) && this.aEq != null) {
            return this.aEq.Ha();
        }
        return false;
    }

    public void bN(boolean z) {
        this.aEn.bH(z);
    }

    public void bO(boolean z) {
        this.aEn.bI(z);
    }

    private void GG() {
        if (this.aAR == null) {
            String[] strArr = {this.aDc.getPageContext().getPageActivity().getString(com.baidu.tieba.z.take_photo), this.aDc.getPageContext().getPageActivity().getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aDc.getPageContext().getPageActivity());
            builder.setTitle(this.aDc.getPageContext().getPageActivity().getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new bu(this));
            this.aAR = builder.create();
            this.aAR.setCanceledOnTouchOutside(true);
        }
    }

    public void GH() {
        GG();
        if (this.aAR != null) {
            com.baidu.adp.lib.g.k.a(this.aAR, this.aDc.getPageContext());
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.am> arrayList, int i, com.baidu.tieba.tbadkCore.e eVar, int i2) {
        int i3;
        if (i > 1 && arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                com.baidu.adp.widget.ListView.am amVar = arrayList.get(i4);
                if (amVar instanceof com.baidu.tbadk.core.data.l) {
                    arrayList.remove(amVar);
                    i4--;
                    i3 = size - 1;
                } else {
                    i3 = size;
                }
                i4++;
                size = i3;
            }
        }
        this.aEn.a(arrayList, eVar, eM(i), eN(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aEo.setText(com.baidu.tieba.z.frs_nodata);
            this.aEo.setVisibility(0);
            return;
        }
        this.aEo.setVisibility(8);
    }

    public BdListView getListView() {
        return this.aEm;
    }

    private boolean eM(int i) {
        return i > 1;
    }

    private boolean eN(int i) {
        return i == 1;
    }

    public void GI() {
        this.aEn.bH(false);
        this.aEn.bI(false);
        this.aEn.notifyDataSetInvalidated();
    }

    public void eO(int i) {
        this.aEm.setSelection(i);
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        float a = a(forumData);
        if (this.aEq != null) {
            this.aEq.c(forumData, eVar);
            this.aEq.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            this.aEq.eW(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.aEq.bV(false);
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aEq != null && signData != null) {
            this.aEq.c(forumData, eVar);
            this.aEq.eW(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aEq.Ha()) {
                a(this.aEq, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aEK);
                    forumData.setLevelupScore(this.aEJ);
                }
                this.aEq.c(forumData, eVar);
                this.aEq.c(this.aEq.Hg(), true);
            }
        }
    }

    private void bP(boolean z) {
        if (this.aEy != null && this.aEz != null) {
            if (z) {
                this.aEy.setVisibility(4);
                this.aEz.setVisibility(0);
                return;
            }
            this.aEy.setVisibility(0);
            this.aEz.setVisibility(4);
        }
    }

    public void eP(int i) {
        if (this.aEq != null) {
            this.aEq.eW(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar, boolean z) {
        if (this.aEq != null) {
            this.aEq.c(forumData, eVar);
            this.aEq.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aEq.bV(false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData) {
        if (!this.aEQ && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aEO = forumData.getFrsBannerData();
            CH();
            this.asL.reset();
            this.aEm.removeHeaderView(this.asL);
            if (this.aEO.getType() == 2) {
                if (this.aEq == null) {
                    eL(userData.getIsMem());
                }
                this.aES.setText(this.aEO.mK());
                this.aES.setVisibility(0);
                this.aET = true;
            } else if (this.aEO.getType() == 1 && !TextUtils.isEmpty(this.aEO.mJ())) {
                this.asL.b(this.aDc.getPageContext(), this.aEO.mJ());
                if (this.aEO.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aDc.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601");
                }
            }
        }
    }

    public void GJ() {
        if (this.asL != null) {
            this.aEQ = false;
            this.aEm.removeHeaderView(this.asL);
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        float a = a(forumData);
        if (this.aEp != null) {
            this.aEp.c(forumData, eVar);
            this.aEp.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aEp.bV(false);
                return;
            }
            this.aEp.bV(true);
            this.aEp.eW(forumData.getSignData().getSigned());
        }
    }

    public void eQ(int i) {
        if (this.aEp != null) {
            this.aEp.eW(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aEp != null && signData != null) {
            this.aEp.c(forumData, eVar);
            this.aEp.eW(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aEp.Ha()) {
                a(this.aEp, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aEK);
                    forumData.setLevelupScore(this.aEJ);
                }
                this.aEp.c(forumData, eVar);
                this.aEp.c(this.aEp.Hg(), true);
            }
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aEJ - this.aEK) {
                z = true;
                this.aEJ = signData.getLevelUpScore();
            }
            this.aEK = bonusPoint + this.aEK;
            if (this.aEK > this.aEJ) {
                this.aEK = this.aEJ;
            }
            if (this.aEJ != 0) {
                f = this.aEK / this.aEJ;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar, boolean z) {
        if (this.aEp != null) {
            this.aEp.c(forumData, eVar);
            if (forumData != null) {
                this.aEp.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData().getForumRank() == -2) {
                    this.aEp.bV(false);
                }
            }
        }
    }

    public void eR(int i) {
        if (this.aEp != null) {
            this.aEp.eV(i);
        }
    }

    public void eS(int i) {
        if (this.aEq != null) {
            this.aEq.eV(i);
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aEJ = forumData.getLevelupScore();
        this.aEK = forumData.getCurScore();
        if (this.aEJ > 0) {
            return this.aEK / this.aEJ;
        }
        return 0.0f;
    }

    public void GK() {
        if (this.aEp != null) {
            this.aEp.Hc();
        }
    }

    public void GL() {
        if (this.aEq != null) {
            this.aEq.Hc();
        }
    }

    public void setIsMem(int i) {
        if (this.aEp != null) {
            this.aEp.setIsMem(i);
        }
        if (this.aEq != null) {
            this.aEq.setIsMem(i);
        }
    }

    public void w(View view) {
        if (this.aEp != null) {
            this.aEp.c(view, false);
        }
    }

    public void x(View view) {
        if (this.aEq != null) {
            this.aEq.c(view, false);
        }
    }

    public void onPause() {
        if (this.aEC != null) {
            com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aDc.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.awR != null && this.aCN != null) {
            this.awR.b(this.aCN);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.j> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Gy();
        if (this.aEs == null) {
            this.aEs = new bj(this.aDc.getPageContext().getPageActivity(), arrayList);
            this.aEr.a(this.aEs);
            this.aEr.c(onItemClickListener);
            return;
        }
        this.aEs.r(arrayList);
        this.aEs.notifyDataSetChanged();
    }

    public void eH(int i) {
        if (this.aEs != null) {
            this.aEs.eH(i);
        }
    }

    public void GM() {
        this.aEt.setVisibility(8);
    }

    public void a(cx cxVar, boolean z, boolean z2, boolean z3) {
        if (this.aEB != null) {
            Go().a(cxVar, z2, z3);
        }
        if (!z) {
            this.aEt.setVisibility(8);
            return;
        }
        long GU = z2 ? cxVar.GU() + 0 : 0L;
        if (z3) {
            GU += cxVar.GT();
        }
        if (GU > 0 && this.aEu.getVisibility() == 0) {
            this.aEt.setVisibility(0);
            if (GU < 10) {
                this.aEt.setText(String.valueOf(GU));
                com.baidu.tbadk.core.util.ax.i((View) this.aEt, com.baidu.tieba.v.icon_news_head_prompt_one);
                return;
            } else if (GU < 100) {
                this.aEt.setText(String.valueOf(GU));
                com.baidu.tbadk.core.util.ax.i((View) this.aEt, com.baidu.tieba.v.icon_news_head_prompt_two);
                return;
            } else {
                this.aEt.setText("   ");
                com.baidu.tbadk.core.util.ax.i((View) this.aEt, com.baidu.tieba.v.icon_news_head_prompt_more);
                return;
            }
        }
        this.aEt.setVisibility(8);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.aEq != null) {
            this.aEq.changeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.cl(i);
        }
        if (this.aEn != null) {
            this.aEn.FU();
            this.aEn.notifyDataSetChanged();
            this.aEn.onChangeSkinType(i);
        }
        if (this.aEs != null) {
            this.aEs.notifyDataSetChanged();
        }
        if (this.aEr != null) {
            this.aEr.changeSkinType(i);
        }
        if (this.aEB != null) {
            this.aEB.changeSkinType(i);
        }
        if (this.aEp != null) {
            this.aEp.changeSkinType(i);
        }
        this.aDc.Fx();
        this.aDc.getLayoutMode().ab(i == 1);
        this.aDc.getLayoutMode().h(this.Qa);
        this.mNavigationBar.onChangeSkinType(this.aDc.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aDc, i, com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.bg_pull_down_n));
        }
        if (this.awR != null) {
            this.awR.onChangeSkinType(this.aDc.getPageContext(), i);
        }
        if (this.aBE != null) {
            Fh().b(this.aDc.getPageContext(), i);
        }
        if (this.asL != null) {
            this.asL.kE();
        }
        if (this.aEM != null) {
            this.aEM.onChangeSkinType(this.aDc.getPageContext(), i);
        }
    }

    public void GN() {
        this.Qa.removeView(this.aEg);
        this.aEg = null;
    }

    public void bQ(boolean z) {
        if (z) {
            this.aEk.setAlpha(128);
            this.aEl.setAlpha(128);
            return;
        }
        this.aEk.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aEl.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void jK() {
        this.aEm.jK();
    }

    public int EO() {
        return com.baidu.tieba.w.user_icon_box;
    }

    public void bR(boolean z) {
        Go().bT(z);
    }

    public void setIsManager(boolean z) {
        Go().setIsManager(z);
    }

    public void Fj() {
        if (Fh() != null) {
            Fh().U(Fh().getEditText());
            Fh().hide();
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.w wVar, int i2) {
        if (Fh() != null) {
            Fh().yB();
            Fh().refresh();
            if (Fh().afj()) {
                Fh().Zz();
            } else {
                Fh().getEditText().requestFocus();
                Fh().T(Fh().getEditText());
            }
            J(i, i2);
            com.baidu.tieba.tbadkCore.bubble.m.a(this.aDc, Fh().getEditorToolButtonContainer(), false, this.aFe);
        }
    }

    protected void J(int i, int i2) {
        if (Fh() != null) {
            this.aBF = new com.baidu.tieba.tbadkCore.af(this.aDc.getPageContext().getPageActivity(), i, i2, Fh(), this.aEm, this.mNavigationBar.getHeight());
            this.aDc.mHandler.postDelayed(this.aBF, 300L);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null && Fh() != null) {
            Fh().a(this.aDc.getPageContext(), new bv(this, wVar));
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (Fh() != null) {
            Fh().bUs.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (Fh() != null) {
            Fh().bUs.setBaobaoUris(writeImagesInfo);
        }
    }

    public void z(ArrayList<String> arrayList) {
        if (Fh() != null) {
            Fh().z(arrayList);
        }
    }

    public String Fo() {
        return Fh() != null ? Fh().getContent() : "";
    }

    public VoiceData.VoiceModel getAudioData() {
        if (Fh() != null) {
            return Fh().getAudioData();
        }
        return null;
    }

    public void Fp() {
        if (Fh() != null) {
            Fh().Fp();
        }
    }

    public void Fq() {
        if (Fh() != null) {
            Fh().Fq();
        }
    }

    public void bD(boolean z) {
        if (Fh() != null && z) {
            Fh().getEditText().setText("");
            Fh().afC();
            Fh().clearData();
        }
    }

    public void bS(boolean z) {
        PbEditor Fh = Fh();
        if (Fh != null) {
            if (z) {
                Fh.Yp();
            } else {
                Fh.Yo();
            }
        }
    }

    public void fx(String str) {
        if (Fh() != null) {
            Fh().setContent(str);
        }
    }

    public void eT(int i) {
        if (i > 1) {
            if (this.aEp != null) {
                this.aEp.bW(false);
            }
            if (this.aEq != null) {
                this.aEq.bW(false);
                return;
            }
            return;
        }
        if (this.aEp != null) {
            this.aEp.bW(true);
        }
        if (this.aEq != null) {
            this.aEq.bW(true);
        }
    }

    public boolean Fl() {
        if (Fh() != null) {
            return Fh().Fl();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public PbEditor Fh() {
        if (this.aDc == null) {
            return null;
        }
        if (this.aBE == null) {
            this.aBE = new PbEditor(this.aDc.getPageContext().getPageActivity());
            this.aBE.setOrientation(1);
            this.aBE.aI(false);
            ((LinearLayout) this.aDc.findViewById(com.baidu.tieba.w.frs_editor_container)).addView(this.aBE, new ViewGroup.LayoutParams(-1, -2));
            this.aBE.setVisibility(8);
            this.aDc.FK();
            this.aBE.b(this.aDc.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        }
        return this.aBE;
    }

    public az GO() {
        return this.aEn;
    }

    public View getRootView() {
        return this.Qa;
    }

    public void eU(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aDc.findViewById(com.baidu.tieba.w.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void GP() {
        if (com.baidu.tbadk.performanceLog.ac.zh().zi()) {
            int lastVisiblePosition = this.aEm.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aEm.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cl) {
                        cl clVar = (cl) childAt.getTag();
                        if (clVar.aBo != null) {
                            com.baidu.tbadk.performanceLog.v perfLog = clVar.aBo.getPerfLog();
                            perfLog.dR(1000);
                            perfLog.agn = true;
                            perfLog.agm = this.aDc.aCy;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                clVar.aBo.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            clVar.aBo.qu();
                        }
                        if (clVar.aBk != null && (clVar.aBk instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = clVar.aBk;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.v perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.dR(1000);
                                    perfLog2.agn = true;
                                    perfLog2.agm = this.aDc.aCy;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.qu();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bh) {
                        bh bhVar = (bh) childAt.getTag();
                        if (bhVar.aDB != null) {
                            com.baidu.tbadk.performanceLog.v perfLog3 = bhVar.aDB.getPerfLog();
                            perfLog3.dR(1000);
                            perfLog3.agn = true;
                            perfLog3.agm = this.aDc.aCy;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bhVar.aDB.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            bhVar.aDB.qu();
                        }
                        if (bhVar.aDF != null && (bhVar.aDF instanceof TbImageView)) {
                            TbImageView tbImageView2 = bhVar.aDF;
                            com.baidu.tbadk.performanceLog.v perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.dR(1000);
                            perfLog4.agn = true;
                            perfLog4.agm = this.aDc.aCy;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            tbImageView2.qu();
                        }
                    }
                    if (childAt.getTag() instanceof cv) {
                        cv cvVar = (cv) childAt.getTag();
                        if (cvVar.aFI != null && cvVar.aFI.aFT != null && (cvVar.aFI.aFT instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.v perfLog5 = cvVar.aFI.aFT.getPerfLog();
                            perfLog5.dR(1000);
                            perfLog5.agn = true;
                            perfLog5.agm = this.aDc.aCy;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                cvVar.aFI.aFT.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            cvVar.aFI.aFT.qu();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (cvVar.aFN != null) {
                            arrayList.add(cvVar.aFN);
                        }
                        if (cvVar.aFO != null) {
                            arrayList.add(cvVar.aFO);
                        }
                        if (cvVar.aFP != null) {
                            arrayList.add(cvVar.aFP);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.v perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.dR(1000);
                                perfLog6.agn = true;
                                perfLog6.agm = this.aDc.aCy;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                    }
                                }
                                tbImageView3.qu();
                            }
                        }
                    }
                }
            }
        }
    }
}
