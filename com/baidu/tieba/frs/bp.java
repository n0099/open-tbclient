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
public class bp {
    private static /* synthetic */ int[] aGi;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private PbEditor aCF;
    private FrsActivity aEd;
    private View aFA;
    private ImageView aFB;
    private ImageView aFC;
    private ImageView aFD;
    private View.OnClickListener aFK;
    private int aFM;
    private int aFN;
    private TextView aFO;
    private com.baidu.tbadk.coreExtra.view.q aFP;
    private LinearLayout aFQ;
    private com.baidu.tbadk.core.data.j aFR;
    private View aFS;
    private com.baidu.adp.lib.guide.d aFU;
    private FrsOfficalBanner aFV;
    private Runnable aFX;
    private View aFY;
    private View aFk;
    private ay aFp;
    private View aFy;
    private View aFz;
    private com.baidu.tieba.tbadkCore.e aGb;
    private CustomMessageListener aGc;
    private NoNetworkView axR;
    private int mIsLike;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private TextView mTitle;
    private boolean aFh = false;
    private RelativeLayout QB = null;
    private FrameLayout aFi = null;
    private ImageView aFj = null;
    private FrameLayout aFl = null;
    private ImageView aFm = null;
    private ImageView aFn = null;
    private BdTypeListView aFo = null;
    private TextView aFq = null;
    private AlertDialog aFr = null;
    private FrsHeaderView aFs = null;
    private com.baidu.tieba.frs.view.o aFt = null;
    private com.baidu.tieba.frs.view.e aFu = null;
    private bi aFv = null;
    private TextView aFw = null;
    private View aFx = null;
    private int mSkinType = 0;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private dc aFE = null;
    private com.baidu.tieba.tbadkCore.z aFF = null;
    private SlidingMenu aFG = null;
    private String aFH = null;
    AlertDialog aFI = null;
    Animation aFJ = null;
    private DialogInterface.OnClickListener aFL = null;
    private com.baidu.tbadk.core.view.ad aDO = null;
    private BannerView atS = null;
    private boolean aFT = false;
    private boolean aFW = false;
    private boolean aFZ = false;
    private boolean aGa = false;
    com.baidu.tbadk.coreExtra.view.b aGd = new bq(this);
    com.baidu.tbadk.coreExtra.view.b aGe = new bv(this);
    View aGf = null;
    private View.OnTouchListener aGg = new bw(this);
    private com.baidu.tieba.tbadkCore.bubble.y aGh = new bx(this);
    private com.baidu.tieba.tbadkCore.af aCG = null;

    static /* synthetic */ int[] Hn() {
        int[] iArr = aGi;
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
            aGi = iArr;
        }
        return iArr;
    }

    public bp(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aEd = null;
        this.aFK = null;
        this.aEd = frsActivity;
        this.aFK = onClickListener;
        initUI();
    }

    public void f(com.baidu.tieba.tbadkCore.e eVar) {
        this.aGb = eVar;
        this.aFO.setVisibility(8);
        if (this.aFP != null && this.aFP.getVisibility() != 0 && eVar != null && eVar.aeN() != null && eVar.aeN().getAnchorPower() != null && eVar.aeN().getAnchorPower().have_power.intValue() != 0 && TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aFO.setVisibility(0);
        }
    }

    private void initUI() {
        this.QB = (RelativeLayout) this.aEd.findViewById(com.baidu.tieba.w.frs);
        this.aFG = new SlidingMenu(this.aEd.getPageContext().getPageActivity());
        this.aFG.setMode(1);
        this.aFG.setTouchModeAbove(1);
        this.aFG.setBehindOffset(com.baidu.adp.lib.util.l.dip2px(this.aEd.getPageContext().getPageActivity(), 48.0f));
        this.aFG.setBehindScrollScale(0.5f);
        this.aFG.setFadeDegree(0.35f);
        this.aFG.attachToActivity(this.aEd.getPageContext().getPageActivity(), 1);
        this.mNavigationBar = (NavigationBar) this.aEd.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.aFV = (FrsOfficalBanner) this.aEd.findViewById(com.baidu.tieba.w.frs_offical_banner);
        this.aFV.setBannerViewClickListener(this.aGe);
        this.aFk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aFk.setOnClickListener(this.aFK);
        this.aFS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.x.frs_icon_bottom_title, (View.OnClickListener) null);
        this.mTitle = (TextView) this.aFS.findViewById(com.baidu.tieba.w.navigationTitle_frs);
        this.aFD = (ImageView) this.aFS.findViewById(com.baidu.tieba.w.icon_bottom_title_image);
        this.aFS.setOnClickListener(this.aFK);
        this.aFQ = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_frs_live, (View.OnClickListener) null);
        this.aFO = (TextView) this.aFQ.findViewById(com.baidu.tieba.w.nb_item_live_text_btn);
        this.aFO.setOnClickListener(this.aFK);
        if (this.aGc == null) {
            this.aGc = new by(this, 0);
            this.aEd.registerListener(2001269, this.aGc);
        }
        this.aEd.sendMessage(new CustomMessage(2001269, this.aEd.getPageContext().getPageActivity()));
        this.aFY = this.aEd.findViewById(com.baidu.tieba.w.frs_list_content);
        this.aFj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_edit, this.aFK);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_frs_more, (View.OnClickListener) null);
        this.aFx = addCustomView.findViewById(com.baidu.tieba.w.frs_top_more);
        this.aFx.setOnClickListener(this.aFK);
        this.aFw = (TextView) addCustomView.findViewById(com.baidu.tieba.w.frs_more_mes_text);
        this.aFl = (FrameLayout) this.aEd.findViewById(com.baidu.tieba.w.refresh_layout);
        this.aFm = (ImageView) this.aEd.findViewById(com.baidu.tieba.w.refresh_bg);
        this.aFn = (ImageView) this.aEd.findViewById(com.baidu.tieba.w.refresh_icon);
        this.aFo = (BdTypeListView) this.aEd.findViewById(com.baidu.tieba.w.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.ak(this.aEd.getPageContext());
        this.aFo.setDivider(null);
        this.aFo.setOnScrollToPullListener(new ca(this));
        this.aFo.setPullRefresh(this.mPullView);
        this.aFo.setDividerHeight(0);
        this.aFo.setRecyclerListener(new cb(this));
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ah(new cc(this)));
        this.aFp = new ay(this.aEd, this.aFo, com.baidu.tbadk.core.util.bg.pI().pK());
        this.aFq = (TextView) this.aEd.findViewById(com.baidu.tieba.w.frs_noexist_post);
        this.aFq.setVisibility(8);
        this.aFl.setOnClickListener(this.aFK);
        this.aFl.setOnTouchListener(this.aGg);
        this.axR = (NoNetworkView) this.aEd.findViewById(com.baidu.tieba.w.view_no_network);
        bP(false);
        this.aFZ = TbadkSettings.getInst().loadBoolean(FrsActivity.aCJ, false);
    }

    private void Dg() {
        if (this.atS == null) {
            this.atS = new BannerView(this.aEd.getPageContext().getPageActivity());
            this.atS.setLayoutParams(new AbsListView.LayoutParams(-1, this.aEd.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_banner_height)));
            this.atS.setVisibility(8);
            this.atS.setBannerViewClickListener(this.aGe);
            this.atS.setBannerViewEvent(new cd(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Gz() {
        if (TextUtils.equals(this.aFH, "frs_page")) {
            TiebaStatic.eventStat(this.aEd.getPageContext().getPageActivity(), "top_banner_ck", "click");
        }
        if (this.aFR != null) {
            String value = this.aFR.getValue();
            if (this.aFR.mK() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.aEd.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aFR.mK() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aEd.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aEd.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aFR.mK() == 3) {
                new com.baidu.tbadk.core.util.bt();
                com.baidu.tbadk.core.util.bt isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.JX != UtilHelper.NativePageType.NONE) {
                    switch (Hn()[isNativeAddress.JX.ordinal()]) {
                        case 2:
                            this.aEd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aEd.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aEd.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aEd.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bm.pV().b(this.aEd.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aEd.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601");
                }
            } else if (this.aFR.mK() == 4) {
                this.aEd.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aEd.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void GA() {
        this.aGf = com.baidu.adp.lib.g.b.ei().inflate(this.aEd.getPageContext().getPageActivity(), com.baidu.tieba.x.frs_pop_more_window, null);
        this.aFy = this.aGf.findViewById(com.baidu.tieba.w.frs_pop_more_window_all_threads_layout);
        this.aFy.setOnClickListener(this.aFK);
        this.aFB = (ImageView) this.aGf.findViewById(com.baidu.tieba.w.choose_all_threads);
        this.aFB.setVisibility(0);
        this.aFz = this.aGf.findViewById(com.baidu.tieba.w.frs_pop_more_window_good_threads_layout);
        this.aFz.setOnClickListener(this.aFK);
        this.aFC = (ImageView) this.aGf.findViewById(com.baidu.tieba.w.choose_good_threads);
        this.aFA = this.aGf.findViewById(com.baidu.tieba.w.frs_pop_more_window_add_shortcut_layout);
        this.aFA.setOnClickListener(this.aFK);
        if ("M351".equals(Build.MODEL)) {
            this.aFA.setVisibility(8);
        } else {
            this.aFA.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aEd.getPageContext().getPageActivity(), this.aGf, this.mNavigationBar, this.aEd.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_n), null);
    }

    public void bO(boolean z) {
        if (this.mPopWindow == null) {
            GA();
        }
        bS(z);
        this.aEd.getLayoutMode().h(this.aGf);
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void GB() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aEd.getPageContext().getPageActivity());
    }

    public void GC() {
        if (TbadkCoreApplication.m255getInst().isFirstGoFrs()) {
            TbadkCoreApplication.m255getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(this.mNavigationBar).N(0).v(false);
            gVar.a(new br(this));
            this.aFU = gVar.dx();
            this.aFU.i(this.aEd.getPageContext().getPageActivity());
        }
    }

    public void GD() {
        if ("normal_page".equals(this.aFH)) {
            if (this.aFs != null) {
                this.aFs.GD();
            }
        } else if ("frs_page".equals(this.aFH) && this.aFt != null) {
            this.aFt.GD();
        }
    }

    public View GE() {
        return this.aFS;
    }

    public View GF() {
        return this.aFy;
    }

    public View GG() {
        return this.aFz;
    }

    public View GH() {
        return this.aFA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView GI() {
        return this.aFj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aFx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View GJ() {
        return this.aFk;
    }

    public boolean GK() {
        if ("normal_page".equals(this.aFH)) {
            if (this.aFs != null) {
                return this.aFs.GK();
            }
        } else if ("frs_page".equals(this.aFH) && this.aFt != null) {
            return this.aFt.GK();
        }
        return false;
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aDO = adVar;
        if (this.axR != null) {
            this.axR.a(this.aDO);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.aFG.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.aFG.setOnOpenedListener(onOpenedListener);
    }

    public dc GL() {
        if (this.aFE == null) {
            this.aFE = new dc(this.aEd.getPageContext());
            this.aFG.setMenu(this.aFE.getView());
            this.aFE.o(this.aFK);
            this.aFE.changeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.aFE.init();
        }
        return this.aFE;
    }

    public SlidingMenu GM() {
        return this.aFG;
    }

    public void showMenu(boolean z) {
        this.aFG.showMenu(z);
    }

    public void a(com.baidu.tbadk.core.data.x xVar, boolean z) {
        String string = this.aEd.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view);
        String string2 = this.aEd.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view_host);
        String string3 = this.aEd.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aEd.getPageContext().getPageActivity());
        builder.setTitle(com.baidu.tieba.z.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.aFL);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.aFL);
        }
        this.aFI = builder.create();
        this.aFI.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aFo.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        this.aFp.a(anVar);
    }

    public void a(com.baidu.adp.widget.ListView.ao aoVar) {
        this.aFp.a(aoVar);
    }

    public void k(View.OnClickListener onClickListener) {
        this.aFp.k(onClickListener);
    }

    public void m(View.OnClickListener onClickListener) {
        this.aFp.l(onClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.aFL = onClickListener;
    }

    public void GN() {
        if (this.aFI != null) {
            com.baidu.adp.lib.g.k.a(this.aFI, this.aEd.getPageContext());
        }
    }

    public void onDestroy() {
        if (this.aFs != null) {
            this.aFs.onDestory();
        }
        if (this.aFt != null) {
            this.aFt.onDestory();
        }
        if (this.aFX != null) {
            this.aEd.mHandler.removeCallbacks(this.aFX);
        }
        if (this.aCG != null) {
            this.aEd.mHandler.removeCallbacks(this.aCG);
        }
        if (this.aGc != null) {
            this.aGc = null;
        }
    }

    private Animation GO() {
        if (this.aFJ == null) {
            this.aFJ = AnimationUtils.loadAnimation(this.aEd.getPageContext().getPageActivity(), com.baidu.tieba.q.refresh_rotate);
            this.aFJ.setInterpolator(new LinearInterpolator());
            this.aFJ.setFillAfter(true);
        }
        return this.aFJ;
    }

    public void bP(boolean z) {
        this.aFh = z;
        if (z) {
            this.aFl.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aEd, this.aFn, GO(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.bc.c(this.aFm, com.baidu.tieba.v.pic_fresh_s);
            return;
        }
        this.aFl.setOnTouchListener(this.aGg);
        this.aFo.jI();
        this.aFn.clearAnimation();
        com.baidu.tbadk.core.util.bc.c(this.aFm, com.baidu.tieba.v.pic_fresh_n);
    }

    public boolean GP() {
        return this.aFh;
    }

    public FrsHeaderView GQ() {
        return this.aFs;
    }

    public com.baidu.tieba.frs.view.o GR() {
        return this.aFt;
    }

    public void GS() {
        this.aFo.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setText("");
            this.aFD.setVisibility(4);
            return;
        }
        this.mTitle.setText(String.valueOf(str) + this.aEd.getPageContext().getPageActivity().getString(com.baidu.tieba.z.forum));
        this.aFD.setVisibility(0);
    }

    public void GT() {
        if (this.aFp != null) {
            this.aFp.notifyDataSetChanged();
        }
    }

    public void M(int i, int i2) {
        this.mIsLike = i2;
        GW();
        this.aFH = "normal_page";
        if (this.aFs == null) {
            this.aFs = new FrsHeaderView(this.aEd, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aFs.changeSkinType(this.mSkinType);
            this.aFs.o(this.aFK);
        }
        this.aFo.addHeaderView(this.aFs.getView());
        GU();
    }

    public void N(int i, int i2) {
        this.mIsLike = i2;
        GW();
        this.aFH = "frs_page";
        eR(i);
        this.aFo.addHeaderView(this.aFt.getView());
        GU();
    }

    private void GU() {
        if (this.aFX == null) {
            this.aFX = new bs(this);
        }
        this.aEd.mHandler.postDelayed(this.aFX, 4000L);
    }

    private void eR(int i) {
        if (this.aFt == null) {
            this.aFt = new com.baidu.tieba.frs.view.o(this.aEd.getPageContext(), null, null, i);
            this.aFt.changeSkinType(this.mSkinType);
            this.aFt.setBannerViewClickListener(this.aGd);
            this.aFt.o(this.aFK);
        }
    }

    public void GV() {
        GW();
        this.aFH = "good_page";
        if (this.aFu == null) {
            this.aFu = new com.baidu.tieba.frs.view.e(this.aEd.getPageContext().getPageActivity());
            this.aFu.changeSkinType(this.mSkinType);
        }
        this.aFo.addHeaderView(this.aFu.getView());
    }

    private void GW() {
        if ("normal_page".equals(this.aFH) && this.aFs != null) {
            this.aFo.removeHeaderView(this.aFs.getView());
        } else if ("frs_page".equals(this.aFH) && this.aFt != null) {
            this.aFo.removeHeaderView(this.aFt.getView());
        } else if ("good_page".equals(this.aFH) && this.aFu != null) {
            this.aFo.removeHeaderView(this.aFu.getView());
        }
    }

    public void GX() {
        if (this.aFs != null) {
            this.aFs.HF().setVisibility(0);
        }
    }

    public void GY() {
        if (this.aFs != null) {
            this.aFs.HF().setVisibility(8);
        }
    }

    public void GZ() {
        if (this.aFt != null) {
            this.aFt.HF().setVisibility(0);
        }
    }

    public void Ha() {
        if (this.aFt != null) {
            this.aFt.HF().setVisibility(8);
        }
    }

    public boolean Hb() {
        if ("normal_page".equals(this.aFH) && this.aFs != null) {
            return this.aFs.Hb();
        }
        if ("frs_page".equals(this.aFH) && this.aFt != null) {
            return this.aFt.Hb();
        }
        return false;
    }

    public boolean Hc() {
        if ("normal_page".equals(this.aFH) && this.aFs != null) {
            return this.aFs.Hy();
        }
        if ("frs_page".equals(this.aFH) && this.aFt != null) {
            return this.aFt.Hy();
        }
        return false;
    }

    public void bQ(boolean z) {
        this.aFp.bK(z);
    }

    public void bR(boolean z) {
        this.aFp.bL(z);
    }

    private void Hd() {
        if (this.aFr == null) {
            String[] strArr = {this.aEd.getPageContext().getPageActivity().getString(com.baidu.tieba.z.take_photo), this.aEd.getPageContext().getPageActivity().getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aEd.getPageContext().getPageActivity());
            builder.setTitle(this.aEd.getPageContext().getPageActivity().getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new bt(this));
            this.aFr = builder.create();
            this.aFr.setCanceledOnTouchOutside(true);
        }
    }

    public void He() {
        Hd();
        if (this.aFr != null) {
            com.baidu.adp.lib.g.k.a(this.aFr, this.aEd.getPageContext());
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.am> arrayList, int i, com.baidu.tieba.tbadkCore.e eVar, int i2) {
        int i3;
        if (i > 1 && arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                com.baidu.adp.widget.ListView.am amVar = arrayList.get(i4);
                if (amVar instanceof com.baidu.tbadk.core.data.m) {
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
        this.aFp.a(arrayList, eVar, eS(i), eT(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aFq.setText(com.baidu.tieba.z.frs_nodata);
            this.aFq.setVisibility(0);
            return;
        }
        this.aFq.setVisibility(8);
    }

    public BdListView getListView() {
        return this.aFo;
    }

    private boolean eS(int i) {
        return i > 1;
    }

    private boolean eT(int i) {
        return i == 1;
    }

    public void Hf() {
        this.aFp.bK(false);
        this.aFp.bL(false);
        this.aFp.notifyDataSetInvalidated();
    }

    public void eU(int i) {
        this.aFo.setSelection(i);
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        float a = a(forumData);
        if (this.aFt != null) {
            this.aFt.c(forumData, eVar);
            this.aFt.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            this.aFt.fc(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.aFt.bY(false);
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aFt != null && signData != null) {
            this.aFt.c(forumData, eVar);
            this.aFt.fc(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aFt.Hy()) {
                a(this.aFt, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aFN);
                    forumData.setLevelupScore(this.aFM);
                }
                this.aFt.c(forumData, eVar);
                this.aFt.c(this.aFt.HE(), true);
            }
        }
    }

    private void bS(boolean z) {
        if (this.aFB != null && this.aFC != null) {
            if (z) {
                this.aFB.setVisibility(4);
                this.aFC.setVisibility(0);
                return;
            }
            this.aFB.setVisibility(0);
            this.aFC.setVisibility(4);
        }
    }

    public void eV(int i) {
        if (this.aFt != null) {
            this.aFt.fc(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar, boolean z) {
        if (this.aFt != null) {
            this.aFt.c(forumData, eVar);
            this.aFt.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aFt.bY(false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData) {
        if (!this.aFT && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aFR = forumData.getFrsBannerData();
            Dg();
            this.atS.reset();
            this.aFo.removeHeaderView(this.atS);
            if (this.aFR.getType() == 2) {
                if (this.aFt == null) {
                    eR(userData.getIsMem());
                }
                this.aFV.setText(this.aFR.mM());
                this.aFV.setVisibility(0);
                this.aFW = true;
            } else if (this.aFR.getType() == 1 && !TextUtils.isEmpty(this.aFR.mL())) {
                this.atS.b(this.aEd.getPageContext(), this.aFR.mL());
                if (this.aFR.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aEd.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601");
                }
            }
        }
    }

    public void Hg() {
        if (this.atS != null) {
            this.aFT = false;
            this.aFo.removeHeaderView(this.atS);
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        float a = a(forumData);
        if (this.aFs != null) {
            this.aFs.c(forumData, eVar);
            this.aFs.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aFs.bY(false);
                return;
            }
            this.aFs.bY(true);
            this.aFs.fc(forumData.getSignData().getSigned());
        }
    }

    public void eW(int i) {
        if (this.aFs != null) {
            this.aFs.fc(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aFs != null && signData != null) {
            this.aFs.c(forumData, eVar);
            this.aFs.fc(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aFs.Hy()) {
                a(this.aFs, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aFN);
                    forumData.setLevelupScore(this.aFM);
                }
                this.aFs.c(forumData, eVar);
                this.aFs.c(this.aFs.HE(), true);
            }
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aFM - this.aFN) {
                z = true;
                this.aFM = signData.getLevelUpScore();
            }
            this.aFN = bonusPoint + this.aFN;
            if (this.aFN > this.aFM) {
                this.aFN = this.aFM;
            }
            if (this.aFM != 0) {
                f = this.aFN / this.aFM;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar, boolean z) {
        if (this.aFs != null) {
            this.aFs.c(forumData, eVar);
            if (forumData != null) {
                this.aFs.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData().getForumRank() == -2) {
                    this.aFs.bY(false);
                }
            }
        }
    }

    public void eX(int i) {
        if (this.aFs != null) {
            this.aFs.fb(i);
        }
    }

    public void eY(int i) {
        if (this.aFt != null) {
            this.aFt.fb(i);
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aFM = forumData.getLevelupScore();
        this.aFN = forumData.getCurScore();
        if (this.aFM > 0) {
            return this.aFN / this.aFM;
        }
        return 0.0f;
    }

    public void Hh() {
        if (this.aFs != null) {
            this.aFs.HA();
        }
    }

    public void Hi() {
        if (this.aFt != null) {
            this.aFt.HA();
        }
    }

    public void setIsMem(int i) {
        if (this.aFs != null) {
            this.aFs.setIsMem(i);
        }
        if (this.aFt != null) {
            this.aFt.setIsMem(i);
        }
    }

    public void w(View view) {
        if (this.aFs != null) {
            this.aFs.c(view, false);
        }
    }

    public void x(View view) {
        if (this.aFt != null) {
            this.aFt.c(view, false);
        }
    }

    public void onPause() {
        if (this.aFF != null) {
            com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aEd.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.axR != null && this.aDO != null) {
            this.axR.b(this.aDO);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        GV();
        if (this.aFv == null) {
            this.aFv = new bi(this.aEd.getPageContext().getPageActivity(), arrayList);
            this.aFu.a(this.aFv);
            this.aFu.c(onItemClickListener);
            return;
        }
        this.aFv.s(arrayList);
        this.aFv.notifyDataSetChanged();
    }

    public void eN(int i) {
        if (this.aFv != null) {
            this.aFv.eN(i);
        }
    }

    public void Hj() {
        this.aFw.setVisibility(8);
    }

    public void a(cy cyVar, boolean z, boolean z2, boolean z3) {
        if (this.aFE != null) {
            GL().a(cyVar, z2, z3);
        }
        if (!z) {
            this.aFw.setVisibility(8);
            return;
        }
        long Hs = z2 ? cyVar.Hs() + 0 : 0L;
        if (z3) {
            Hs += cyVar.Hr();
        }
        if (Hs > 0 && this.aFx.getVisibility() == 0) {
            this.aFw.setVisibility(0);
            if (Hs < 10) {
                this.aFw.setText(String.valueOf(Hs));
                com.baidu.tbadk.core.util.bc.i((View) this.aFw, com.baidu.tieba.v.icon_news_head_prompt_one);
                return;
            } else if (Hs < 100) {
                this.aFw.setText(String.valueOf(Hs));
                com.baidu.tbadk.core.util.bc.i((View) this.aFw, com.baidu.tieba.v.icon_news_head_prompt_two);
                return;
            } else {
                this.aFw.setText("   ");
                com.baidu.tbadk.core.util.bc.i((View) this.aFw, com.baidu.tieba.v.icon_news_head_prompt_more);
                return;
            }
        }
        this.aFw.setVisibility(8);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.aFt != null) {
            this.aFt.changeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.cs(i);
        }
        if (this.aFp != null) {
            this.aFp.Gr();
            this.aFp.notifyDataSetChanged();
            this.aFp.onChangeSkinType(i);
        }
        if (this.aFv != null) {
            this.aFv.notifyDataSetChanged();
        }
        if (this.aFu != null) {
            this.aFu.changeSkinType(i);
        }
        if (this.aFE != null) {
            this.aFE.changeSkinType(i);
        }
        if (this.aFs != null) {
            this.aFs.changeSkinType(i);
        }
        this.aEd.FV();
        this.aEd.getLayoutMode().ab(i == 1);
        this.aEd.getLayoutMode().h(this.QB);
        this.mNavigationBar.onChangeSkinType(this.aEd.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aEd, i, com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.bg_pull_down_n));
        }
        if (this.axR != null) {
            this.axR.onChangeSkinType(this.aEd.getPageContext(), i);
        }
        if (this.aCF != null) {
            FF().b(this.aEd.getPageContext(), i);
        }
        if (this.atS != null) {
            this.atS.kE();
        }
        if (this.aFP != null) {
            this.aFP.onChangeSkinType(this.aEd.getPageContext(), i);
        }
    }

    public void Hk() {
        this.QB.removeView(this.aFi);
        this.aFi = null;
    }

    public void bT(boolean z) {
        if (z) {
            this.aFm.setAlpha(128);
            this.aFn.setAlpha(128);
            return;
        }
        this.aFm.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aFn.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void jJ() {
        this.aFo.jJ();
    }

    public int Fn() {
        return com.baidu.tieba.w.user_icon_box;
    }

    public void bU(boolean z) {
        GL().bW(z);
    }

    public void setIsManager(boolean z) {
        GL().setIsManager(z);
    }

    public void FH() {
        if (FF() != null) {
            FF().W(FF().getEditText());
            FF().hide();
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.x xVar, int i2) {
        if (FF() != null) {
            FF().yR();
            FF().refresh();
            if (FF().afN()) {
                FF().aae();
            } else {
                FF().getEditText().requestFocus();
                FF().V(FF().getEditText());
            }
            K(i, i2);
            com.baidu.tieba.tbadkCore.bubble.m.a(this.aEd, FF().getEditorToolButtonContainer(), false, this.aGh);
        }
    }

    protected void K(int i, int i2) {
        if (FF() != null) {
            this.aCG = new com.baidu.tieba.tbadkCore.af(this.aEd.getPageContext().getPageActivity(), i, i2, FF(), this.aFo, this.mNavigationBar.getHeight());
            this.aEd.mHandler.postDelayed(this.aCG, 300L);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null && FF() != null) {
            FF().a(this.aEd.getPageContext(), new bu(this, wVar));
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (FF() != null) {
            FF().bWk.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (FF() != null) {
            FF().bWk.setBaobaoUris(writeImagesInfo);
        }
    }

    public void A(ArrayList<String> arrayList) {
        if (FF() != null) {
            FF().A(arrayList);
        }
    }

    public String FM() {
        return FF() != null ? FF().getContent() : "";
    }

    public VoiceData.VoiceModel getAudioData() {
        if (FF() != null) {
            return FF().getAudioData();
        }
        return null;
    }

    public void FN() {
        if (FF() != null) {
            FF().FN();
        }
    }

    public void FO() {
        if (FF() != null) {
            FF().FO();
        }
    }

    public void bG(boolean z) {
        if (FF() != null && z) {
            FF().getEditText().setText("");
            FF().agg();
            FF().clearData();
        }
    }

    public void bV(boolean z) {
        PbEditor FF = FF();
        if (FF != null) {
            if (z) {
                FF.YU();
            } else {
                FF.YT();
            }
        }
    }

    public void fC(String str) {
        if (FF() != null) {
            FF().setContent(str);
        }
    }

    public void eZ(int i) {
        if (i > 1) {
            if (this.aFs != null) {
                this.aFs.bZ(false);
            }
            if (this.aFt != null) {
                this.aFt.bZ(false);
                return;
            }
            return;
        }
        if (this.aFs != null) {
            this.aFs.bZ(true);
        }
        if (this.aFt != null) {
            this.aFt.bZ(true);
        }
    }

    public boolean FJ() {
        if (FF() != null) {
            return FF().FJ();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public PbEditor FF() {
        if (this.aEd == null) {
            return null;
        }
        if (this.aCF == null) {
            this.aCF = new PbEditor(this.aEd.getPageContext().getPageActivity());
            this.aCF.setOrientation(1);
            this.aCF.aK(false);
            ((LinearLayout) this.aEd.findViewById(com.baidu.tieba.w.frs_editor_container)).addView(this.aCF, new ViewGroup.LayoutParams(-1, -2));
            this.aCF.setVisibility(8);
            this.aEd.Gi();
            this.aCF.b(this.aEd.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        }
        return this.aCF;
    }

    public ay Hl() {
        return this.aFp;
    }

    public View getRootView() {
        return this.QB;
    }

    public void fa(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aEd.findViewById(com.baidu.tieba.w.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Hm() {
        if (com.baidu.tbadk.performanceLog.ac.zy().zz()) {
            int lastVisiblePosition = this.aFo.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aFo.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cm) {
                        cm cmVar = (cm) childAt.getTag();
                        if (cmVar.aCp != null) {
                            com.baidu.tbadk.performanceLog.v perfLog = cmVar.aCp.getPerfLog();
                            perfLog.dX(1000);
                            perfLog.agL = true;
                            perfLog.agK = this.aEd.aDz;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                cmVar.aCp.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            cmVar.aCp.qF();
                        }
                        if (cmVar.aCl != null && (cmVar.aCl instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = cmVar.aCl;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.v perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.dX(1000);
                                    perfLog2.agL = true;
                                    perfLog2.agK = this.aEd.aDz;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.qF();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bg) {
                        bg bgVar = (bg) childAt.getTag();
                        if (bgVar.aEC != null) {
                            com.baidu.tbadk.performanceLog.v perfLog3 = bgVar.aEC.getPerfLog();
                            perfLog3.dX(1000);
                            perfLog3.agL = true;
                            perfLog3.agK = this.aEd.aDz;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bgVar.aEC.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            bgVar.aEC.qF();
                        }
                        if (bgVar.aEG != null && (bgVar.aEG instanceof TbImageView)) {
                            TbImageView tbImageView2 = bgVar.aEG;
                            com.baidu.tbadk.performanceLog.v perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.dX(1000);
                            perfLog4.agL = true;
                            perfLog4.agK = this.aEd.aDz;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            tbImageView2.qF();
                        }
                    }
                    if (childAt.getTag() instanceof cw) {
                        cw cwVar = (cw) childAt.getTag();
                        if (cwVar.aGS != null && cwVar.aGS.aHd != null && (cwVar.aGS.aHd instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.v perfLog5 = cwVar.aGS.aHd.getPerfLog();
                            perfLog5.dX(1000);
                            perfLog5.agL = true;
                            perfLog5.agK = this.aEd.aDz;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                cwVar.aGS.aHd.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            cwVar.aGS.aHd.qF();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (cwVar.aGX != null) {
                            arrayList.add(cwVar.aGX);
                        }
                        if (cwVar.aGY != null) {
                            arrayList.add(cwVar.aGY);
                        }
                        if (cwVar.aGZ != null) {
                            arrayList.add(cwVar.aGZ);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.v perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.dX(1000);
                                perfLog6.agL = true;
                                perfLog6.agK = this.aEd.aDz;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                    }
                                }
                                tbImageView3.qF();
                            }
                        }
                    }
                }
            }
        }
    }
}
