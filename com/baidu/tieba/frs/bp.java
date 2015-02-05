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
    private static /* synthetic */ int[] aGf;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private PbEditor aCC;
    private FrsActivity aEa;
    private ImageView aFA;
    private View.OnClickListener aFH;
    private int aFJ;
    private int aFK;
    private TextView aFL;
    private com.baidu.tbadk.coreExtra.view.q aFM;
    private LinearLayout aFN;
    private com.baidu.tbadk.core.data.j aFO;
    private View aFP;
    private com.baidu.adp.lib.guide.d aFR;
    private FrsOfficalBanner aFS;
    private Runnable aFU;
    private View aFV;
    private com.baidu.tieba.tbadkCore.e aFY;
    private CustomMessageListener aFZ;
    private View aFh;
    private ay aFm;
    private View aFv;
    private View aFw;
    private View aFx;
    private ImageView aFy;
    private ImageView aFz;
    private NoNetworkView axO;
    private int mIsLike;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private TextView mTitle;
    private boolean aFe = false;
    private RelativeLayout Qx = null;
    private FrameLayout aFf = null;
    private ImageView aFg = null;
    private FrameLayout aFi = null;
    private ImageView aFj = null;
    private ImageView aFk = null;
    private BdTypeListView aFl = null;
    private TextView aFn = null;
    private AlertDialog aFo = null;
    private FrsHeaderView aFp = null;
    private com.baidu.tieba.frs.view.o aFq = null;
    private com.baidu.tieba.frs.view.e aFr = null;
    private bi aFs = null;
    private TextView aFt = null;
    private View aFu = null;
    private int mSkinType = 0;
    private com.baidu.tbadk.core.view.ak mPullView = null;
    private dc aFB = null;
    private com.baidu.tieba.tbadkCore.z aFC = null;
    private SlidingMenu aFD = null;
    private String aFE = null;
    AlertDialog aFF = null;
    Animation aFG = null;
    private DialogInterface.OnClickListener aFI = null;
    private com.baidu.tbadk.core.view.ad aDL = null;
    private BannerView atP = null;
    private boolean aFQ = false;
    private boolean aFT = false;
    private boolean aFW = false;
    private boolean aFX = false;
    com.baidu.tbadk.coreExtra.view.b aGa = new bq(this);
    com.baidu.tbadk.coreExtra.view.b aGb = new bv(this);
    View aGc = null;
    private View.OnTouchListener aGd = new bw(this);
    private com.baidu.tieba.tbadkCore.bubble.y aGe = new bx(this);
    private com.baidu.tieba.tbadkCore.af aCD = null;

    static /* synthetic */ int[] Hh() {
        int[] iArr = aGf;
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
            aGf = iArr;
        }
        return iArr;
    }

    public bp(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aEa = null;
        this.aFH = null;
        this.aEa = frsActivity;
        this.aFH = onClickListener;
        initUI();
    }

    public void f(com.baidu.tieba.tbadkCore.e eVar) {
        this.aFY = eVar;
        this.aFL.setVisibility(8);
        if (this.aFM != null && this.aFM.getVisibility() != 0 && eVar != null && eVar.aeI() != null && eVar.aeI().getAnchorPower() != null && eVar.aeI().getAnchorPower().have_power.intValue() != 0 && TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            this.aFL.setVisibility(0);
        }
    }

    private void initUI() {
        this.Qx = (RelativeLayout) this.aEa.findViewById(com.baidu.tieba.w.frs);
        this.aFD = new SlidingMenu(this.aEa.getPageContext().getPageActivity());
        this.aFD.setMode(1);
        this.aFD.setTouchModeAbove(1);
        this.aFD.setBehindOffset(com.baidu.adp.lib.util.l.dip2px(this.aEa.getPageContext().getPageActivity(), 48.0f));
        this.aFD.setBehindScrollScale(0.5f);
        this.aFD.setFadeDegree(0.35f);
        this.aFD.attachToActivity(this.aEa.getPageContext().getPageActivity(), 1);
        this.mNavigationBar = (NavigationBar) this.aEa.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.aFS = (FrsOfficalBanner) this.aEa.findViewById(com.baidu.tieba.w.frs_offical_banner);
        this.aFS.setBannerViewClickListener(this.aGb);
        this.aFh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aFh.setOnClickListener(this.aFH);
        this.aFP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.x.frs_icon_bottom_title, (View.OnClickListener) null);
        this.mTitle = (TextView) this.aFP.findViewById(com.baidu.tieba.w.navigationTitle_frs);
        this.aFA = (ImageView) this.aFP.findViewById(com.baidu.tieba.w.icon_bottom_title_image);
        this.aFP.setOnClickListener(this.aFH);
        this.aFN = (LinearLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_frs_live, (View.OnClickListener) null);
        this.aFL = (TextView) this.aFN.findViewById(com.baidu.tieba.w.nb_item_live_text_btn);
        this.aFL.setOnClickListener(this.aFH);
        if (this.aFZ == null) {
            this.aFZ = new by(this, 0);
            this.aEa.registerListener(2001269, this.aFZ);
        }
        this.aEa.sendMessage(new CustomMessage(2001269, this.aEa.getPageContext().getPageActivity()));
        this.aFV = this.aEa.findViewById(com.baidu.tieba.w.frs_list_content);
        this.aFg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.widget_nb_item_edit, this.aFH);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.x.nb_item_frs_more, (View.OnClickListener) null);
        this.aFu = addCustomView.findViewById(com.baidu.tieba.w.frs_top_more);
        this.aFu.setOnClickListener(this.aFH);
        this.aFt = (TextView) addCustomView.findViewById(com.baidu.tieba.w.frs_more_mes_text);
        this.aFi = (FrameLayout) this.aEa.findViewById(com.baidu.tieba.w.refresh_layout);
        this.aFj = (ImageView) this.aEa.findViewById(com.baidu.tieba.w.refresh_bg);
        this.aFk = (ImageView) this.aEa.findViewById(com.baidu.tieba.w.refresh_icon);
        this.aFl = (BdTypeListView) this.aEa.findViewById(com.baidu.tieba.w.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.ak(this.aEa.getPageContext());
        this.aFl.setDivider(null);
        this.aFl.setOnScrollToPullListener(new ca(this));
        this.aFl.setPullRefresh(this.mPullView);
        this.aFl.setDividerHeight(0);
        this.aFl.setRecyclerListener(new cb(this));
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ah(new cc(this)));
        this.aFm = new ay(this.aEa, this.aFl, com.baidu.tbadk.core.util.bg.pB().pD());
        this.aFn = (TextView) this.aEa.findViewById(com.baidu.tieba.w.frs_noexist_post);
        this.aFn.setVisibility(8);
        this.aFi.setOnClickListener(this.aFH);
        this.aFi.setOnTouchListener(this.aGd);
        this.axO = (NoNetworkView) this.aEa.findViewById(com.baidu.tieba.w.view_no_network);
        bP(false);
        this.aFW = TbadkSettings.getInst().loadBoolean(FrsActivity.aCG, false);
    }

    private void Da() {
        if (this.atP == null) {
            this.atP = new BannerView(this.aEa.getPageContext().getPageActivity());
            this.atP.setLayoutParams(new AbsListView.LayoutParams(-1, this.aEa.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_banner_height)));
            this.atP.setVisibility(8);
            this.atP.setBannerViewClickListener(this.aGb);
            this.atP.setBannerViewEvent(new cd(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Gt() {
        if (TextUtils.equals(this.aFE, "frs_page")) {
            TiebaStatic.eventStat(this.aEa.getPageContext().getPageActivity(), "top_banner_ck", "click");
        }
        if (this.aFO != null) {
            String value = this.aFO.getValue();
            if (this.aFO.mD() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.aEa.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aFO.mD() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aEa.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aEa.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aFO.mD() == 3) {
                new com.baidu.tbadk.core.util.bt();
                com.baidu.tbadk.core.util.bt isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.JU != UtilHelper.NativePageType.NONE) {
                    switch (Hh()[isNativeAddress.JU.ordinal()]) {
                        case 2:
                            this.aEa.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aEa.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aEa.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aEa.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.core.util.bm.pO().b(this.aEa.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aEa.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601");
                }
            } else if (this.aFO.mD() == 4) {
                this.aEa.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aEa.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void Gu() {
        this.aGc = com.baidu.adp.lib.g.b.ei().inflate(this.aEa.getPageContext().getPageActivity(), com.baidu.tieba.x.frs_pop_more_window, null);
        this.aFv = this.aGc.findViewById(com.baidu.tieba.w.frs_pop_more_window_all_threads_layout);
        this.aFv.setOnClickListener(this.aFH);
        this.aFy = (ImageView) this.aGc.findViewById(com.baidu.tieba.w.choose_all_threads);
        this.aFy.setVisibility(0);
        this.aFw = this.aGc.findViewById(com.baidu.tieba.w.frs_pop_more_window_good_threads_layout);
        this.aFw.setOnClickListener(this.aFH);
        this.aFz = (ImageView) this.aGc.findViewById(com.baidu.tieba.w.choose_good_threads);
        this.aFx = this.aGc.findViewById(com.baidu.tieba.w.frs_pop_more_window_add_shortcut_layout);
        this.aFx.setOnClickListener(this.aFH);
        if ("M351".equals(Build.MODEL)) {
            this.aFx.setVisibility(8);
        } else {
            this.aFx.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aEa.getPageContext().getPageActivity(), this.aGc, this.mNavigationBar, this.aEa.getResources().getDrawable(com.baidu.tieba.v.bg_pull_down_n), null);
    }

    public void bO(boolean z) {
        if (this.mPopWindow == null) {
            Gu();
        }
        bS(z);
        this.aEa.getLayoutMode().h(this.aGc);
        com.baidu.adp.lib.g.k.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void Gv() {
        com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aEa.getPageContext().getPageActivity());
    }

    public void Gw() {
        if (TbadkCoreApplication.m255getInst().isFirstGoFrs()) {
            TbadkCoreApplication.m255getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(this.mNavigationBar).N(0).v(false);
            gVar.a(new br(this));
            this.aFR = gVar.dx();
            this.aFR.i(this.aEa.getPageContext().getPageActivity());
        }
    }

    public void Gx() {
        if ("normal_page".equals(this.aFE)) {
            if (this.aFp != null) {
                this.aFp.Gx();
            }
        } else if ("frs_page".equals(this.aFE) && this.aFq != null) {
            this.aFq.Gx();
        }
    }

    public View Gy() {
        return this.aFP;
    }

    public View Gz() {
        return this.aFv;
    }

    public View GA() {
        return this.aFw;
    }

    public View GB() {
        return this.aFx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView GC() {
        return this.aFg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getMoreButton() {
        return this.aFu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View GD() {
        return this.aFh;
    }

    public boolean GE() {
        if ("normal_page".equals(this.aFE)) {
            if (this.aFp != null) {
                return this.aFp.GE();
            }
        } else if ("frs_page".equals(this.aFE) && this.aFq != null) {
            return this.aFq.GE();
        }
        return false;
    }

    public void f(com.baidu.tbadk.core.view.ad adVar) {
        this.aDL = adVar;
        if (this.axO != null) {
            this.axO.a(this.aDL);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.aFD.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.aFD.setOnOpenedListener(onOpenedListener);
    }

    public dc GF() {
        if (this.aFB == null) {
            this.aFB = new dc(this.aEa.getPageContext());
            this.aFD.setMenu(this.aFB.getView());
            this.aFB.o(this.aFH);
            this.aFB.changeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.aFB.init();
        }
        return this.aFB;
    }

    public SlidingMenu GG() {
        return this.aFD;
    }

    public void showMenu(boolean z) {
        this.aFD.showMenu(z);
    }

    public void a(com.baidu.tbadk.core.data.x xVar, boolean z) {
        String string = this.aEa.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view);
        String string2 = this.aEa.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view_host);
        String string3 = this.aEa.getPageContext().getPageActivity().getString(com.baidu.tieba.z.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aEa.getPageContext().getPageActivity());
        builder.setTitle(com.baidu.tieba.z.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.aFI);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.aFI);
        }
        this.aFF = builder.create();
        this.aFF.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.g gVar) {
        this.mPullView.a(gVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aFl.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        this.aFm.a(anVar);
    }

    public void a(com.baidu.adp.widget.ListView.ao aoVar) {
        this.aFm.a(aoVar);
    }

    public void k(View.OnClickListener onClickListener) {
        this.aFm.k(onClickListener);
    }

    public void m(View.OnClickListener onClickListener) {
        this.aFm.l(onClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.aFI = onClickListener;
    }

    public void GH() {
        if (this.aFF != null) {
            com.baidu.adp.lib.g.k.a(this.aFF, this.aEa.getPageContext());
        }
    }

    public void onDestroy() {
        if (this.aFp != null) {
            this.aFp.onDestory();
        }
        if (this.aFq != null) {
            this.aFq.onDestory();
        }
        if (this.aFU != null) {
            this.aEa.mHandler.removeCallbacks(this.aFU);
        }
        if (this.aCD != null) {
            this.aEa.mHandler.removeCallbacks(this.aCD);
        }
        if (this.aFZ != null) {
            this.aFZ = null;
        }
    }

    private Animation GI() {
        if (this.aFG == null) {
            this.aFG = AnimationUtils.loadAnimation(this.aEa.getPageContext().getPageActivity(), com.baidu.tieba.q.refresh_rotate);
            this.aFG.setInterpolator(new LinearInterpolator());
            this.aFG.setFillAfter(true);
        }
        return this.aFG;
    }

    public void bP(boolean z) {
        this.aFe = z;
        if (z) {
            this.aFi.setOnTouchListener(null);
            com.baidu.tieba.tbadkCore.a.a(this.aEa, this.aFk, GI(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.bc.c(this.aFj, com.baidu.tieba.v.pic_fresh_s);
            return;
        }
        this.aFi.setOnTouchListener(this.aGd);
        this.aFl.jB();
        this.aFk.clearAnimation();
        com.baidu.tbadk.core.util.bc.c(this.aFj, com.baidu.tieba.v.pic_fresh_n);
    }

    public boolean GJ() {
        return this.aFe;
    }

    public FrsHeaderView GK() {
        return this.aFp;
    }

    public com.baidu.tieba.frs.view.o GL() {
        return this.aFq;
    }

    public void GM() {
        this.aFl.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTitle.setText("");
            this.aFA.setVisibility(4);
            return;
        }
        this.mTitle.setText(String.valueOf(str) + this.aEa.getPageContext().getPageActivity().getString(com.baidu.tieba.z.forum));
        this.aFA.setVisibility(0);
    }

    public void GN() {
        if (this.aFm != null) {
            this.aFm.notifyDataSetChanged();
        }
    }

    public void N(int i, int i2) {
        this.mIsLike = i2;
        GQ();
        this.aFE = "normal_page";
        if (this.aFp == null) {
            this.aFp = new FrsHeaderView(this.aEa, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aFp.changeSkinType(this.mSkinType);
            this.aFp.o(this.aFH);
        }
        this.aFl.addHeaderView(this.aFp.getView());
        GO();
    }

    public void O(int i, int i2) {
        this.mIsLike = i2;
        GQ();
        this.aFE = "frs_page";
        eR(i);
        this.aFl.addHeaderView(this.aFq.getView());
        GO();
    }

    private void GO() {
        if (this.aFU == null) {
            this.aFU = new bs(this);
        }
        this.aEa.mHandler.postDelayed(this.aFU, 4000L);
    }

    private void eR(int i) {
        if (this.aFq == null) {
            this.aFq = new com.baidu.tieba.frs.view.o(this.aEa.getPageContext(), null, null, i);
            this.aFq.changeSkinType(this.mSkinType);
            this.aFq.setBannerViewClickListener(this.aGa);
            this.aFq.o(this.aFH);
        }
    }

    public void GP() {
        GQ();
        this.aFE = "good_page";
        if (this.aFr == null) {
            this.aFr = new com.baidu.tieba.frs.view.e(this.aEa.getPageContext().getPageActivity());
            this.aFr.changeSkinType(this.mSkinType);
        }
        this.aFl.addHeaderView(this.aFr.getView());
    }

    private void GQ() {
        if ("normal_page".equals(this.aFE) && this.aFp != null) {
            this.aFl.removeHeaderView(this.aFp.getView());
        } else if ("frs_page".equals(this.aFE) && this.aFq != null) {
            this.aFl.removeHeaderView(this.aFq.getView());
        } else if ("good_page".equals(this.aFE) && this.aFr != null) {
            this.aFl.removeHeaderView(this.aFr.getView());
        }
    }

    public void GR() {
        if (this.aFp != null) {
            this.aFp.Hz().setVisibility(0);
        }
    }

    public void GS() {
        if (this.aFp != null) {
            this.aFp.Hz().setVisibility(8);
        }
    }

    public void GT() {
        if (this.aFq != null) {
            this.aFq.Hz().setVisibility(0);
        }
    }

    public void GU() {
        if (this.aFq != null) {
            this.aFq.Hz().setVisibility(8);
        }
    }

    public boolean GV() {
        if ("normal_page".equals(this.aFE) && this.aFp != null) {
            return this.aFp.GV();
        }
        if ("frs_page".equals(this.aFE) && this.aFq != null) {
            return this.aFq.GV();
        }
        return false;
    }

    public boolean GW() {
        if ("normal_page".equals(this.aFE) && this.aFp != null) {
            return this.aFp.Hs();
        }
        if ("frs_page".equals(this.aFE) && this.aFq != null) {
            return this.aFq.Hs();
        }
        return false;
    }

    public void bQ(boolean z) {
        this.aFm.bK(z);
    }

    public void bR(boolean z) {
        this.aFm.bL(z);
    }

    private void GX() {
        if (this.aFo == null) {
            String[] strArr = {this.aEa.getPageContext().getPageActivity().getString(com.baidu.tieba.z.take_photo), this.aEa.getPageContext().getPageActivity().getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aEa.getPageContext().getPageActivity());
            builder.setTitle(this.aEa.getPageContext().getPageActivity().getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new bt(this));
            this.aFo = builder.create();
            this.aFo.setCanceledOnTouchOutside(true);
        }
    }

    public void GY() {
        GX();
        if (this.aFo != null) {
            com.baidu.adp.lib.g.k.a(this.aFo, this.aEa.getPageContext());
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
        this.aFm.a(arrayList, eVar, eS(i), eT(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aFn.setText(com.baidu.tieba.z.frs_nodata);
            this.aFn.setVisibility(0);
            return;
        }
        this.aFn.setVisibility(8);
    }

    public BdListView getListView() {
        return this.aFl;
    }

    private boolean eS(int i) {
        return i > 1;
    }

    private boolean eT(int i) {
        return i == 1;
    }

    public void GZ() {
        this.aFm.bK(false);
        this.aFm.bL(false);
        this.aFm.notifyDataSetInvalidated();
    }

    public void eU(int i) {
        this.aFl.setSelection(i);
    }

    public void a(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        float a = a(forumData);
        if (this.aFq != null) {
            this.aFq.c(forumData, eVar);
            this.aFq.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            this.aFq.fc(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.aFq.bY(false);
            }
        }
    }

    public void a(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aFq != null && signData != null) {
            this.aFq.c(forumData, eVar);
            this.aFq.fc(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aFq.Hs()) {
                a(this.aFq, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aFK);
                    forumData.setLevelupScore(this.aFJ);
                }
                this.aFq.c(forumData, eVar);
                this.aFq.c(this.aFq.Hy(), true);
            }
        }
    }

    private void bS(boolean z) {
        if (this.aFy != null && this.aFz != null) {
            if (z) {
                this.aFy.setVisibility(4);
                this.aFz.setVisibility(0);
                return;
            }
            this.aFy.setVisibility(0);
            this.aFz.setVisibility(4);
        }
    }

    public void eV(int i) {
        if (this.aFq != null) {
            this.aFq.fc(i);
        }
    }

    public void a(int i, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar, boolean z) {
        if (this.aFq != null) {
            this.aFq.c(forumData, eVar);
            this.aFq.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aFq.bY(false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData) {
        if (!this.aFQ && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aFO = forumData.getFrsBannerData();
            Da();
            this.atP.reset();
            this.aFl.removeHeaderView(this.atP);
            if (this.aFO.getType() == 2) {
                if (this.aFq == null) {
                    eR(userData.getIsMem());
                }
                this.aFS.setText(this.aFO.mF());
                this.aFS.setVisibility(0);
                this.aFT = true;
            } else if (this.aFO.getType() == 1 && !TextUtils.isEmpty(this.aFO.mE())) {
                this.atP.b(this.aEa.getPageContext(), this.aFO.mE());
                if (this.aFO.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aEa.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601");
                }
            }
        }
    }

    public void Ha() {
        if (this.atP != null) {
            this.aFQ = false;
            this.aFl.removeHeaderView(this.atP);
        }
    }

    public void b(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        float a = a(forumData);
        if (this.aFp != null) {
            this.aFp.c(forumData, eVar);
            this.aFp.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), a, false);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aFp.bY(false);
                return;
            }
            this.aFp.bY(true);
            this.aFp.fc(forumData.getSignData().getSigned());
        }
    }

    public void eW(int i) {
        if (this.aFp != null) {
            this.aFp.fc(i);
        }
    }

    public void b(SignData signData, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (this.aFp != null && signData != null) {
            this.aFp.c(forumData, eVar);
            this.aFp.fc(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aFp.Hs()) {
                a(this.aFp, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aFK);
                    forumData.setLevelupScore(this.aFJ);
                }
                this.aFp.c(forumData, eVar);
                this.aFp.c(this.aFp.Hy(), true);
            }
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aFJ - this.aFK) {
                z = true;
                this.aFJ = signData.getLevelUpScore();
            }
            this.aFK = bonusPoint + this.aFK;
            if (this.aFK > this.aFJ) {
                this.aFK = this.aFJ;
            }
            if (this.aFJ != 0) {
                f = this.aFK / this.aFJ;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void b(int i, ForumData forumData, com.baidu.tieba.tbadkCore.e eVar, boolean z) {
        if (this.aFp != null) {
            this.aFp.c(forumData, eVar);
            if (forumData != null) {
                this.aFp.a(i, forumData.getLevelName(), forumData.getUser_level(), a(forumData), z);
                if (forumData.getSignData().getForumRank() == -2) {
                    this.aFp.bY(false);
                }
            }
        }
    }

    public void eX(int i) {
        if (this.aFp != null) {
            this.aFp.fb(i);
        }
    }

    public void eY(int i) {
        if (this.aFq != null) {
            this.aFq.fb(i);
        }
    }

    private float a(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aFJ = forumData.getLevelupScore();
        this.aFK = forumData.getCurScore();
        if (this.aFJ > 0) {
            return this.aFK / this.aFJ;
        }
        return 0.0f;
    }

    public void Hb() {
        if (this.aFp != null) {
            this.aFp.Hu();
        }
    }

    public void Hc() {
        if (this.aFq != null) {
            this.aFq.Hu();
        }
    }

    public void setIsMem(int i) {
        if (this.aFp != null) {
            this.aFp.setIsMem(i);
        }
        if (this.aFq != null) {
            this.aFq.setIsMem(i);
        }
    }

    public void w(View view) {
        if (this.aFp != null) {
            this.aFp.c(view, false);
        }
    }

    public void x(View view) {
        if (this.aFq != null) {
            this.aFq.c(view, false);
        }
    }

    public void onPause() {
        if (this.aFC != null) {
            com.baidu.adp.lib.g.k.a(this.mPopWindow, this.aEa.getPageContext().getPageActivity());
        }
    }

    public void release() {
        if (this.axO != null && this.aDL != null) {
            this.axO.b(this.aDL);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.k> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        GP();
        if (this.aFs == null) {
            this.aFs = new bi(this.aEa.getPageContext().getPageActivity(), arrayList);
            this.aFr.a(this.aFs);
            this.aFr.c(onItemClickListener);
            return;
        }
        this.aFs.s(arrayList);
        this.aFs.notifyDataSetChanged();
    }

    public void eN(int i) {
        if (this.aFs != null) {
            this.aFs.eN(i);
        }
    }

    public void Hd() {
        this.aFt.setVisibility(8);
    }

    public void a(cy cyVar, boolean z, boolean z2, boolean z3) {
        if (this.aFB != null) {
            GF().a(cyVar, z2, z3);
        }
        if (!z) {
            this.aFt.setVisibility(8);
            return;
        }
        long Hm = z2 ? cyVar.Hm() + 0 : 0L;
        if (z3) {
            Hm += cyVar.Hl();
        }
        if (Hm > 0 && this.aFu.getVisibility() == 0) {
            this.aFt.setVisibility(0);
            if (Hm < 10) {
                this.aFt.setText(String.valueOf(Hm));
                com.baidu.tbadk.core.util.bc.i((View) this.aFt, com.baidu.tieba.v.icon_news_head_prompt_one);
                return;
            } else if (Hm < 100) {
                this.aFt.setText(String.valueOf(Hm));
                com.baidu.tbadk.core.util.bc.i((View) this.aFt, com.baidu.tieba.v.icon_news_head_prompt_two);
                return;
            } else {
                this.aFt.setText("   ");
                com.baidu.tbadk.core.util.bc.i((View) this.aFt, com.baidu.tieba.v.icon_news_head_prompt_more);
                return;
            }
        }
        this.aFt.setVisibility(8);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v15, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.aFq != null) {
            this.aFq.changeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.cs(i);
        }
        if (this.aFm != null) {
            this.aFm.Gl();
            this.aFm.notifyDataSetChanged();
            this.aFm.onChangeSkinType(i);
        }
        if (this.aFs != null) {
            this.aFs.notifyDataSetChanged();
        }
        if (this.aFr != null) {
            this.aFr.changeSkinType(i);
        }
        if (this.aFB != null) {
            this.aFB.changeSkinType(i);
        }
        if (this.aFp != null) {
            this.aFp.changeSkinType(i);
        }
        this.aEa.FP();
        this.aEa.getLayoutMode().ab(i == 1);
        this.aEa.getLayoutMode().h(this.Qx);
        this.mNavigationBar.onChangeSkinType(this.aEa.getPageContext(), i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aEa, i, com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.bg_pull_down_n));
        }
        if (this.axO != null) {
            this.axO.onChangeSkinType(this.aEa.getPageContext(), i);
        }
        if (this.aCC != null) {
            Fz().b(this.aEa.getPageContext(), i);
        }
        if (this.atP != null) {
            this.atP.kx();
        }
        if (this.aFM != null) {
            this.aFM.onChangeSkinType(this.aEa.getPageContext(), i);
        }
    }

    public void He() {
        this.Qx.removeView(this.aFf);
        this.aFf = null;
    }

    public void bT(boolean z) {
        if (z) {
            this.aFj.setAlpha(128);
            this.aFk.setAlpha(128);
            return;
        }
        this.aFj.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aFk.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void jC() {
        this.aFl.jC();
    }

    public int Fh() {
        return com.baidu.tieba.w.user_icon_box;
    }

    public void bU(boolean z) {
        GF().bW(z);
    }

    public void setIsManager(boolean z) {
        GF().setIsManager(z);
    }

    public void FB() {
        if (Fz() != null) {
            Fz().W(Fz().getEditText());
            Fz().hide();
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.x xVar, int i2) {
        if (Fz() != null) {
            Fz().yL();
            Fz().refresh();
            if (Fz().afI()) {
                Fz().ZZ();
            } else {
                Fz().getEditText().requestFocus();
                Fz().V(Fz().getEditText());
            }
            L(i, i2);
            com.baidu.tieba.tbadkCore.bubble.m.a(this.aEa, Fz().getEditorToolButtonContainer(), false, this.aGe);
        }
    }

    protected void L(int i, int i2) {
        if (Fz() != null) {
            this.aCD = new com.baidu.tieba.tbadkCore.af(this.aEa.getPageContext().getPageActivity(), i, i2, Fz(), this.aFl, this.mNavigationBar.getHeight());
            this.aEa.mHandler.postDelayed(this.aCD, 300L);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null && Fz() != null) {
            Fz().a(this.aEa.getPageContext(), new bu(this, wVar));
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (Fz() != null) {
            Fz().bWj.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (Fz() != null) {
            Fz().bWj.setBaobaoUris(writeImagesInfo);
        }
    }

    public void A(ArrayList<String> arrayList) {
        if (Fz() != null) {
            Fz().A(arrayList);
        }
    }

    public String FG() {
        return Fz() != null ? Fz().getContent() : "";
    }

    public VoiceData.VoiceModel getAudioData() {
        if (Fz() != null) {
            return Fz().getAudioData();
        }
        return null;
    }

    public void FH() {
        if (Fz() != null) {
            Fz().FH();
        }
    }

    public void FI() {
        if (Fz() != null) {
            Fz().FI();
        }
    }

    public void bG(boolean z) {
        if (Fz() != null && z) {
            Fz().getEditText().setText("");
            Fz().agb();
            Fz().clearData();
        }
    }

    public void bV(boolean z) {
        PbEditor Fz = Fz();
        if (Fz != null) {
            if (z) {
                Fz.YP();
            } else {
                Fz.YO();
            }
        }
    }

    public void fz(String str) {
        if (Fz() != null) {
            Fz().setContent(str);
        }
    }

    public void eZ(int i) {
        if (i > 1) {
            if (this.aFp != null) {
                this.aFp.bZ(false);
            }
            if (this.aFq != null) {
                this.aFq.bZ(false);
                return;
            }
            return;
        }
        if (this.aFp != null) {
            this.aFp.bZ(true);
        }
        if (this.aFq != null) {
            this.aFq.bZ(true);
        }
    }

    public boolean FD() {
        if (Fz() != null) {
            return Fz().FD();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public PbEditor Fz() {
        if (this.aEa == null) {
            return null;
        }
        if (this.aCC == null) {
            this.aCC = new PbEditor(this.aEa.getPageContext().getPageActivity());
            this.aCC.setOrientation(1);
            this.aCC.aK(false);
            ((LinearLayout) this.aEa.findViewById(com.baidu.tieba.w.frs_editor_container)).addView(this.aCC, new ViewGroup.LayoutParams(-1, -2));
            this.aCC.setVisibility(8);
            this.aEa.Gc();
            this.aCC.b(this.aEa.getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        }
        return this.aCC;
    }

    public ay Hf() {
        return this.aFm;
    }

    public View getRootView() {
        return this.Qx;
    }

    public void fa(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aEa.findViewById(com.baidu.tieba.w.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }

    public void Hg() {
        if (com.baidu.tbadk.performanceLog.ac.zs().zt()) {
            int lastVisiblePosition = this.aFl.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aFl.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cm) {
                        cm cmVar = (cm) childAt.getTag();
                        if (cmVar.aCm != null) {
                            com.baidu.tbadk.performanceLog.v perfLog = cmVar.aCm.getPerfLog();
                            perfLog.dX(1000);
                            perfLog.agI = true;
                            perfLog.agH = this.aEa.aDw;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                cmVar.aCm.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            cmVar.aCm.qz();
                        }
                        if (cmVar.aCi != null && (cmVar.aCi instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = cmVar.aCi;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.v perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.dX(1000);
                                    perfLog2.agI = true;
                                    perfLog2.agH = this.aEa.aDw;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.qz();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bg) {
                        bg bgVar = (bg) childAt.getTag();
                        if (bgVar.aEz != null) {
                            com.baidu.tbadk.performanceLog.v perfLog3 = bgVar.aEz.getPerfLog();
                            perfLog3.dX(1000);
                            perfLog3.agI = true;
                            perfLog3.agH = this.aEa.aDw;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bgVar.aEz.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            bgVar.aEz.qz();
                        }
                        if (bgVar.aED != null && (bgVar.aED instanceof TbImageView)) {
                            TbImageView tbImageView2 = bgVar.aED;
                            com.baidu.tbadk.performanceLog.v perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.dX(1000);
                            perfLog4.agI = true;
                            perfLog4.agH = this.aEa.aDw;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            tbImageView2.qz();
                        }
                    }
                    if (childAt.getTag() instanceof cw) {
                        cw cwVar = (cw) childAt.getTag();
                        if (cwVar.aGP != null && cwVar.aGP.aHa != null && (cwVar.aGP.aHa instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.v perfLog5 = cwVar.aGP.aHa.getPerfLog();
                            perfLog5.dX(1000);
                            perfLog5.agI = true;
                            perfLog5.agH = this.aEa.aDw;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                cwVar.aGP.aHa.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                }
                            }
                            cwVar.aGP.aHa.qz();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (cwVar.aGU != null) {
                            arrayList.add(cwVar.aGU);
                        }
                        if (cwVar.aGV != null) {
                            arrayList.add(cwVar.aGV);
                        }
                        if (cwVar.aGW != null) {
                            arrayList.add(cwVar.aGW);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.v perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.dX(1000);
                                perfLog6.agI = true;
                                perfLog6.agH = this.aEa.aDw;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getContext())) {
                                    }
                                }
                                tbImageView3.qz();
                            }
                        }
                    }
                }
            }
        }
    }
}
