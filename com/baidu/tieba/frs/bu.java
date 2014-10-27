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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MorePopupWindow;
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
public class bu {
    private static /* synthetic */ int[] aDs;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private TextView JM;
    private FrsActivity aBp;
    private bd aCC;
    private View aCK;
    private View aCL;
    private View aCM;
    private ImageView aCN;
    private ImageView aCO;
    private ImageView aCP;
    private View.OnClickListener aCW;
    private int aCY;
    private int aCZ;
    private View aCx;
    private TextView aDb;
    private LivePlayingImageView aDc;
    private View aDd;
    private com.baidu.tbadk.core.data.g aDe;
    private View aDf;
    private com.baidu.adp.lib.guide.d aDh;
    private FrsOfficalBanner aDi;
    private Runnable aDk;
    private View aDl;
    private b aDm;
    private NoNetworkView aty;
    private PbEditor azA;
    private int mIsLike;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private boolean aCu = false;
    private RelativeLayout KO = null;
    private FrameLayout aCv = null;
    private ImageView aCw = null;
    private FrameLayout aCy = null;
    private ImageView aCz = null;
    private ImageView aCA = null;
    private BdTypeListView aCB = null;
    private TextView aCD = null;
    private AlertDialog ayG = null;
    private FrsHeaderView aCE = null;
    private com.baidu.tieba.frs.view.r aCF = null;
    private com.baidu.tieba.frs.view.e aCG = null;
    private bn aCH = null;
    private TextView aCI = null;
    private View aCJ = null;
    private int mSkinType = 0;
    private com.baidu.tbadk.core.view.y Yc = null;
    private di aCQ = null;
    private com.baidu.tieba.view.t aCR = null;
    private SlidingMenu aCS = null;
    private String aCT = null;
    AlertDialog aCU = null;
    Animation aCV = null;
    private DialogInterface.OnClickListener aCX = null;
    private com.baidu.tbadk.core.view.u aBc = null;
    private BannerView aDa = null;
    private boolean aDg = false;
    private boolean aDj = false;
    com.baidu.tbadk.coreExtra.view.b aDn = new bv(this);
    com.baidu.tbadk.coreExtra.view.b aDo = new bz(this);
    View aDp = null;
    private View.OnTouchListener aDq = new ca(this);
    private com.baidu.tieba.bubble.t aDr = new cb(this);
    private ch azB = null;

    static /* synthetic */ int[] GI() {
        int[] iArr = aDs;
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
            aDs = iArr;
        }
        return iArr;
    }

    public bu(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aBp = null;
        this.aCW = null;
        this.aBp = frsActivity;
        this.aCW = onClickListener;
        initUI();
    }

    public void i(b bVar) {
        this.aDm = bVar;
        this.aDb.setVisibility(8);
        if (this.aDc.getVisibility() != 0 && bVar != null && bVar.zJ() != null && bVar.zJ().getAnchorPower() != null && bVar.zJ().getAnchorPower().have_power.intValue() != 0) {
            this.aDb.setVisibility(0);
        }
    }

    private void initUI() {
        this.KO = (RelativeLayout) this.aBp.findViewById(com.baidu.tieba.v.frs);
        this.aCS = new SlidingMenu(this.aBp);
        this.aCS.setMode(1);
        this.aCS.setTouchModeAbove(1);
        this.aCS.setBehindOffset(com.baidu.adp.lib.util.m.dip2px(this.aBp, 48.0f));
        this.aCS.setBehindScrollScale(0.5f);
        this.aCS.setFadeDegree(0.35f);
        this.aCS.attachToActivity(this.aBp, 1);
        this.mNavigationBar = (NavigationBar) this.aBp.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aDi = (FrsOfficalBanner) this.aBp.findViewById(com.baidu.tieba.v.frs_offical_banner);
        this.aDi.setBannerViewClickListener(this.aDo);
        this.aCx = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aCx.setOnClickListener(this.aCW);
        this.aDf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.frs_icon_bottom_title, (View.OnClickListener) null);
        this.JM = (TextView) this.aDf.findViewById(com.baidu.tieba.v.navigationTitle_frs);
        this.aCP = (ImageView) this.aDf.findViewById(com.baidu.tieba.v.icon_bottom_title_image);
        this.aDf.setOnClickListener(this.aCW);
        this.aDd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_live, (View.OnClickListener) null);
        this.aDb = (TextView) this.aDd.findViewById(com.baidu.tieba.v.nb_item_live_text_btn);
        this.aDb.setOnClickListener(this.aCW);
        this.aDc = (LivePlayingImageView) this.aDd.findViewById(com.baidu.tieba.v.live_playing);
        this.aDc.setStatisticsKey("frs_live_icon");
        this.aDc.setVisibleChangeCallback(new cc(this));
        this.aDl = this.aBp.findViewById(com.baidu.tieba.v.frs_list_content);
        this.aCw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_edit, this.aCW);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_more, (View.OnClickListener) null);
        this.aCJ = addCustomView.findViewById(com.baidu.tieba.v.frs_top_more);
        this.aCJ.setOnClickListener(this.aCW);
        this.aCI = (TextView) addCustomView.findViewById(com.baidu.tieba.v.frs_more_mes_text);
        this.aCy = (FrameLayout) this.aBp.findViewById(com.baidu.tieba.v.refresh_layout);
        this.aCz = (ImageView) this.aBp.findViewById(com.baidu.tieba.v.refresh_bg);
        this.aCA = (ImageView) this.aBp.findViewById(com.baidu.tieba.v.refresh_icon);
        this.aCB = (BdTypeListView) this.aBp.findViewById(com.baidu.tieba.v.frs_lv_thread);
        this.Yc = new com.baidu.tbadk.core.view.y(this.aBp);
        this.aCB.setDivider(null);
        this.aCB.setOnScrollToPullListener(new cd(this));
        this.aCB.setPullRefresh(this.Yc);
        this.aCB.setDividerHeight(0);
        this.aCB.setRecyclerListener(new ce(this));
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.c.a(new cf(this)));
        this.aCC = new bd(this.aBp, this.aCB, com.baidu.tbadk.core.util.az.mD().mF());
        this.aCD = (TextView) this.aBp.findViewById(com.baidu.tieba.v.frs_noexist_post);
        this.aCD.setVisibility(8);
        this.aCy.setOnClickListener(this.aCW);
        this.aCy.setOnTouchListener(this.aDq);
        this.aty = (NoNetworkView) this.aBp.findViewById(com.baidu.tieba.v.view_no_network);
        cb(false);
    }

    private void FU() {
        if (this.aDa == null) {
            this.aDa = new BannerView(this.aBp);
            this.aDa.setLayoutParams(new AbsListView.LayoutParams(-1, this.aBp.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_banner_height)));
            this.aDa.setVisibility(8);
            this.aDa.setBannerViewClickListener(this.aDo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FV() {
        if (TextUtils.equals(this.aCT, "frs_page")) {
            TiebaStatic.eventStat(this.aBp, "top_banner_ck", "click");
        }
        if (this.aDe != null) {
            String value = this.aDe.getValue();
            if (this.aDe.jT() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.aBp, value, false, "frs_banner")));
            } else if (this.aDe.jT() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aBp.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aBp).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aDe.jT() == 3) {
                new com.baidu.tbadk.core.util.bm();
                com.baidu.tbadk.core.util.bm isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.Fu != UtilHelper.NativePageType.NONE) {
                    switch (GI()[isNativeAddress.Fu.ordinal()]) {
                        case 2:
                            this.aBp.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aBp).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aBp.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aBp).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.browser.a.i(this.aBp, value);
            } else if (this.aDe.jT() == 4) {
                this.aBp.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aBp).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void FW() {
        this.aDp = com.baidu.adp.lib.g.b.ek().inflate(this.aBp, com.baidu.tieba.w.frs_pop_more_window, null);
        this.aCK = this.aDp.findViewById(com.baidu.tieba.v.frs_pop_more_window_all_threads_layout);
        this.aCK.setOnClickListener(this.aCW);
        this.aCN = (ImageView) this.aDp.findViewById(com.baidu.tieba.v.choose_all_threads);
        this.aCN.setVisibility(0);
        this.aCL = this.aDp.findViewById(com.baidu.tieba.v.frs_pop_more_window_good_threads_layout);
        this.aCL.setOnClickListener(this.aCW);
        this.aCO = (ImageView) this.aDp.findViewById(com.baidu.tieba.v.choose_good_threads);
        this.aCM = this.aDp.findViewById(com.baidu.tieba.v.frs_pop_more_window_add_shortcut_layout);
        this.aCM.setOnClickListener(this.aCW);
        if ("M351".equals(Build.MODEL)) {
            this.aCM.setVisibility(8);
        } else {
            this.aCM.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aBp, this.aDp, this.mNavigationBar, this.aBp.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), null);
    }

    public void ca(boolean z) {
        if (this.mPopWindow == null) {
            FW();
        }
        ce(z);
        this.aBp.getLayoutMode().h(this.aDp);
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void FX() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aBp);
    }

    public void FY() {
        if (TbadkApplication.m251getInst().isFirstGoFrs()) {
            TbadkApplication.m251getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(this.mNavigationBar).A(0).r(false);
            gVar.a(new cg(this));
            this.aDh = gVar.dA();
            this.aDh.c(this.aBp);
        }
    }

    public void FZ() {
        if ("normal_page".equals(this.aCT)) {
            if (this.aCE != null) {
                this.aCE.FZ();
            }
        } else if ("frs_page".equals(this.aCT) && this.aCF != null) {
            this.aCF.FZ();
        }
    }

    public View Ga() {
        return this.aDf;
    }

    public View Gb() {
        return this.aCK;
    }

    public View Gc() {
        return this.aCL;
    }

    public View Gd() {
        return this.aCM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView Ge() {
        return this.aCw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Gf() {
        return this.aCJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Gg() {
        return this.aCx;
    }

    public boolean Gh() {
        if ("normal_page".equals(this.aCT)) {
            if (this.aCE != null) {
                return this.aCE.Gh();
            }
        } else if ("frs_page".equals(this.aCT) && this.aCF != null) {
            return this.aCF.Gh();
        }
        return false;
    }

    public void f(com.baidu.tbadk.core.view.u uVar) {
        this.aBc = uVar;
        if (this.aty != null) {
            this.aty.a(this.aBc);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.aCS.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.aCS.setOnOpenedListener(onOpenedListener);
    }

    public di Gi() {
        if (this.aCQ == null) {
            this.aCQ = new di(this.aBp);
            this.aCS.setMenu(this.aCQ.getView());
            this.aCQ.o(this.aCW);
            this.aCQ.changeSkinType(TbadkApplication.m251getInst().getSkinType());
            this.aCQ.init();
        }
        return this.aCQ;
    }

    public SlidingMenu getSlidingMenu() {
        return this.aCS;
    }

    public void showMenu(boolean z) {
        this.aCS.showMenu(z);
    }

    public void a(com.baidu.tbadk.core.data.q qVar, boolean z) {
        String string = this.aBp.getString(com.baidu.tieba.y.view);
        String string2 = this.aBp.getString(com.baidu.tieba.y.view_host);
        String string3 = this.aBp.getString(com.baidu.tieba.y.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aBp);
        builder.setTitle(com.baidu.tieba.y.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.aCX);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.aCX);
        }
        this.aCU = builder.create();
        this.aCU.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aCB.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.am amVar) {
        this.aCC.a(amVar);
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        this.aCC.a(anVar);
    }

    public void k(View.OnClickListener onClickListener) {
        this.aCC.k(onClickListener);
    }

    public void m(View.OnClickListener onClickListener) {
        this.aCC.l(onClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.aCX = onClickListener;
    }

    public void Gj() {
        if (this.aCU != null) {
            com.baidu.adp.lib.g.j.a(this.aCU, this.aBp);
        }
    }

    public void onDestroy() {
        if (this.aCE != null) {
            this.aCE.onDestory();
        }
        if (this.aCF != null) {
            this.aCF.onDestory();
        }
        if (this.aDk != null) {
            this.aBp.mHandler.removeCallbacks(this.aDk);
        }
        if (this.azB != null) {
            this.aBp.mHandler.removeCallbacks(this.azB);
        }
    }

    private Animation Gk() {
        if (this.aCV == null) {
            this.aCV = AnimationUtils.loadAnimation(this.aBp, com.baidu.tieba.p.refresh_rotate);
            this.aCV.setInterpolator(new LinearInterpolator());
            this.aCV.setFillAfter(true);
        }
        return this.aCV;
    }

    public void cb(boolean z) {
        this.aCu = z;
        if (z) {
            this.aCy.setOnTouchListener(null);
            com.baidu.tbadk.core.a.a(this.aBp, this.aCA, Gk(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.aw.c(this.aCz, com.baidu.tieba.u.pic_fresh_s);
            return;
        }
        this.aCy.setOnTouchListener(this.aDq);
        this.aCB.hN();
        this.aCA.clearAnimation();
        com.baidu.tbadk.core.util.aw.c(this.aCz, com.baidu.tieba.u.pic_fresh_n);
    }

    public boolean Gl() {
        return this.aCu;
    }

    public FrsHeaderView Gm() {
        return this.aCE;
    }

    public com.baidu.tieba.frs.view.r Gn() {
        return this.aCF;
    }

    public void Go() {
        this.aCB.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.JM.setText("");
            this.aCP.setVisibility(4);
            return;
        }
        this.JM.setText(String.valueOf(str) + this.aBp.getString(com.baidu.tieba.y.forum));
        this.aCP.setVisibility(0);
    }

    public void Gp() {
        if (this.aCC != null) {
            this.aCC.notifyDataSetChanged();
        }
    }

    public void K(int i, int i2) {
        this.mIsLike = i2;
        Gs();
        this.aCT = "normal_page";
        if (this.aCE == null) {
            this.aCE = new FrsHeaderView(this.aBp, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aCE.changeSkinType(this.mSkinType);
            this.aCE.o(this.aCW);
        }
        this.aCB.addHeaderView(this.aCE.getView());
        Gq();
    }

    public void L(int i, int i2) {
        this.mIsLike = i2;
        Gs();
        this.aCT = "frs_page";
        eN(i);
        this.aCB.addHeaderView(this.aCF.getView());
        Gq();
    }

    private void Gq() {
        if (this.aDk == null) {
            this.aDk = new bw(this);
        }
        this.aBp.mHandler.postDelayed(this.aDk, 4000L);
    }

    private void eN(int i) {
        if (this.aCF == null) {
            this.aCF = new com.baidu.tieba.frs.view.r(this.aBp, null, null, i);
            this.aCF.changeSkinType(this.mSkinType);
            this.aCF.setBannerViewClickListener(this.aDn);
            this.aCF.o(this.aCW);
        }
    }

    public void Gr() {
        Gs();
        this.aCT = "good_page";
        if (this.aCG == null) {
            this.aCG = new com.baidu.tieba.frs.view.e(this.aBp);
            this.aCG.changeSkinType(this.mSkinType);
        }
        this.aCB.addHeaderView(this.aCG.getView());
    }

    private void Gs() {
        if ("normal_page".equals(this.aCT) && this.aCE != null) {
            this.aCB.removeHeaderView(this.aCE.getView());
        } else if ("frs_page".equals(this.aCT) && this.aCF != null) {
            this.aCB.removeHeaderView(this.aCF.getView());
        } else if ("good_page".equals(this.aCT) && this.aCG != null) {
            this.aCB.removeHeaderView(this.aCG.getView());
        }
    }

    public void Gt() {
        if (this.aCE != null) {
            this.aCE.GX().setVisibility(0);
        }
    }

    public void Gu() {
        if (this.aCE != null) {
            this.aCE.GX().setVisibility(8);
        }
    }

    public void Gv() {
        if (this.aCF != null) {
            this.aCF.GX().setVisibility(0);
        }
    }

    public void Gw() {
        if (this.aCF != null) {
            this.aCF.GX().setVisibility(8);
        }
    }

    public boolean Gx() {
        if ("normal_page".equals(this.aCT) && this.aCE != null) {
            return this.aCE.Gx();
        }
        if ("frs_page".equals(this.aCT) && this.aCF != null) {
            return this.aCF.Gx();
        }
        return false;
    }

    public boolean Gy() {
        if ("normal_page".equals(this.aCT) && this.aCE != null) {
            return this.aCE.GR();
        }
        if ("frs_page".equals(this.aCT) && this.aCF != null) {
            return this.aCF.GR();
        }
        return false;
    }

    public void cc(boolean z) {
        this.aCC.bW(z);
    }

    public void cd(boolean z) {
        this.aCC.bX(z);
    }

    private void Gz() {
        if (this.ayG == null) {
            String[] strArr = {this.aBp.getString(com.baidu.tieba.y.take_photo), this.aBp.getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aBp);
            builder.setTitle(this.aBp.getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new bx(this));
            this.ayG = builder.create();
            this.ayG.setCanceledOnTouchOutside(true);
        }
    }

    public void GA() {
        Gz();
        if (this.ayG != null) {
            com.baidu.adp.lib.g.j.a(this.ayG, this.aBp);
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.al> arrayList, int i, b bVar, int i2) {
        int i3;
        if (i > 1 && arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                com.baidu.adp.widget.ListView.al alVar = arrayList.get(i4);
                if (alVar instanceof com.baidu.tbadk.core.data.i) {
                    arrayList.remove(alVar);
                    i4--;
                    i3 = size - 1;
                } else {
                    i3 = size;
                }
                i4++;
                size = i3;
            }
        }
        this.aCC.a(arrayList, bVar, eO(i), eP(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aCD.setText(com.baidu.tieba.y.frs_nodata);
            this.aCD.setVisibility(0);
            return;
        }
        this.aCD.setVisibility(8);
    }

    public BdListView ud() {
        return this.aCB;
    }

    private boolean eO(int i) {
        return i > 1;
    }

    private boolean eP(int i) {
        return i == 1;
    }

    public void GB() {
        this.aCC.bW(false);
        this.aCC.bX(false);
        this.aCC.notifyDataSetInvalidated();
    }

    public void eQ(int i) {
        this.aCB.setSelection(i);
    }

    public void a(ForumData forumData, b bVar) {
        float b = b(forumData);
        if (this.aCF != null) {
            this.aCF.c(forumData, bVar);
            this.aCF.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
            this.aCF.eY(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.aCF.ci(false);
            }
        }
    }

    public void a(SignData signData, ForumData forumData, b bVar) {
        if (this.aCF != null && signData != null) {
            this.aCF.c(forumData, bVar);
            this.aCF.eY(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aCF.GR()) {
                a(this.aCF, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aCZ);
                    forumData.setLevelupScore(this.aCY);
                }
                this.aCF.c(forumData, bVar);
                this.aCF.e(this.aCF.GW(), true);
            }
        }
    }

    private void ce(boolean z) {
        if (this.aCN != null && this.aCO != null) {
            if (z) {
                this.aCN.setVisibility(4);
                this.aCO.setVisibility(0);
                return;
            }
            this.aCN.setVisibility(0);
            this.aCO.setVisibility(4);
        }
    }

    public void eR(int i) {
        if (this.aCF != null) {
            this.aCF.eY(i);
        }
    }

    public void a(int i, ForumData forumData, b bVar, boolean z) {
        if (this.aCF != null) {
            this.aCF.c(forumData, bVar);
            this.aCF.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aCF.ci(false);
            }
        }
    }

    public void a(ForumData forumData, UserData userData) {
        if (!this.aDg && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aDe = forumData.getFrsBannerData();
            FU();
            this.aDa.reset();
            this.aCB.removeHeaderView(this.aDa);
            if (this.aDe.getType() == 2) {
                if (this.aCF == null) {
                    eN(userData.getIsMem());
                }
                this.aDi.setText(this.aDe.jV());
                this.aDi.setVisibility(0);
                this.aDj = true;
            } else if (this.aDe.getType() == 1 && !TextUtils.isEmpty(this.aDe.jU())) {
                this.aDa.setData(this.aDe.jU());
                if (this.aDa.pR()) {
                    this.aDg = true;
                    this.aCB.addHeaderView(this.aDa);
                }
            }
        }
    }

    public void GC() {
        if (this.aDa != null) {
            this.aDg = false;
            this.aCB.removeHeaderView(this.aDa);
        }
    }

    public void b(ForumData forumData, b bVar) {
        float b = b(forumData);
        if (this.aCE != null) {
            this.aCE.c(forumData, bVar);
            this.aCE.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aCE.ci(false);
                return;
            }
            this.aCE.ci(true);
            this.aCE.eY(forumData.getSignData().getSigned());
        }
    }

    public void eS(int i) {
        if (this.aCE != null) {
            this.aCE.eY(i);
        }
    }

    public void b(SignData signData, ForumData forumData, b bVar) {
        if (this.aCE != null && signData != null) {
            this.aCE.c(forumData, bVar);
            this.aCE.eY(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aCE.GR()) {
                a(this.aCE, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aCZ);
                    forumData.setLevelupScore(this.aCY);
                }
                this.aCE.c(forumData, bVar);
                this.aCE.e(this.aCE.GW(), true);
            }
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aCY - this.aCZ) {
                z = true;
                this.aCY = signData.getLevelUpScore();
            }
            this.aCZ = bonusPoint + this.aCZ;
            if (this.aCZ > this.aCY) {
                this.aCZ = this.aCY;
            }
            if (this.aCY != 0) {
                f = this.aCZ / this.aCY;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void b(int i, ForumData forumData, b bVar, boolean z) {
        if (this.aCE != null) {
            this.aCE.c(forumData, bVar);
            if (forumData != null) {
                this.aCE.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData().getForumRank() == -2) {
                    this.aCE.ci(false);
                }
            }
        }
    }

    public void eT(int i) {
        if (this.aCE != null) {
            this.aCE.eX(i);
        }
    }

    public void eU(int i) {
        if (this.aCF != null) {
            this.aCF.eX(i);
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aCY = forumData.getLevelupScore();
        this.aCZ = forumData.getCurScore();
        if (this.aCY > 0) {
            return this.aCZ / this.aCY;
        }
        return 0.0f;
    }

    public void GD() {
        if (this.aCE != null) {
            this.aCE.GT();
        }
    }

    public void GE() {
        if (this.aCF != null) {
            this.aCF.GT();
        }
    }

    public void setIsMem(int i) {
        if (this.aCE != null) {
            this.aCE.setIsMem(i);
        }
        if (this.aCF != null) {
            this.aCF.setIsMem(i);
        }
    }

    public void B(View view) {
        if (this.aCE != null) {
            this.aCE.e(view, false);
        }
    }

    public void C(View view) {
        if (this.aCF != null) {
            this.aCF.e(view, false);
        }
    }

    public void onPause() {
        if (this.aCR != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aBp);
        }
    }

    public void release() {
        if (this.aty != null && this.aBc != null) {
            this.aty.b(this.aBc);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Gr();
        if (this.aCH == null) {
            this.aCH = new bn(this.aBp, arrayList);
            this.aCG.a(this.aCH);
            this.aCG.c(onItemClickListener);
            return;
        }
        this.aCH.setData(arrayList);
        this.aCH.notifyDataSetChanged();
    }

    public void eJ(int i) {
        if (this.aCH != null) {
            this.aCH.eJ(i);
        }
    }

    public void GF() {
        this.aCI.setVisibility(8);
    }

    public void a(cz czVar, boolean z, boolean z2, boolean z3) {
        if (this.aCQ != null) {
            Gi().a(czVar, z2, z3);
        }
        if (!z) {
            this.aCI.setVisibility(8);
            return;
        }
        long GM = z2 ? czVar.GM() + 0 : 0L;
        if (z3) {
            GM += czVar.GL();
        }
        if (GM > 0 && this.aCJ.getVisibility() == 0) {
            this.aCI.setVisibility(0);
            if (GM < 10) {
                this.aCI.setText(String.valueOf(GM));
                com.baidu.tbadk.core.util.aw.h((View) this.aCI, com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            } else if (GM < 100) {
                this.aCI.setText(String.valueOf(GM));
                com.baidu.tbadk.core.util.aw.h((View) this.aCI, com.baidu.tieba.u.icon_news_head_prompt_two);
                return;
            } else {
                this.aCI.setText("   ");
                com.baidu.tbadk.core.util.aw.h((View) this.aCI, com.baidu.tieba.u.icon_news_head_prompt_more);
                return;
            }
        }
        this.aCI.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.aCF != null) {
            this.aCF.changeSkinType(i);
        }
        if (this.Yc != null) {
            this.Yc.bM(i);
        }
        if (this.aCC != null) {
            this.aCC.FN();
            this.aCC.notifyDataSetChanged();
            this.aCC.onChangeSkinType(i);
        }
        if (this.aCH != null) {
            this.aCH.notifyDataSetChanged();
        }
        if (this.aCG != null) {
            this.aCG.changeSkinType(i);
        }
        if (this.aCQ != null) {
            this.aCQ.changeSkinType(i);
        }
        if (this.aCE != null) {
            this.aCE.changeSkinType(i);
        }
        this.aBp.Fq();
        this.aBp.getLayoutMode().L(i == 1);
        this.aBp.getLayoutMode().h(this.KO);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aBp, i, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.bg_pull_down_n));
        }
        if (this.aty != null) {
            this.aty.onChangeSkinType(i);
        }
        if (this.azA != null) {
            EO().changeSkinType(i);
        }
        if (this.aDa != null) {
            this.aDa.pS();
        }
    }

    public void GG() {
        this.KO.removeView(this.aCv);
        this.aCv = null;
    }

    public void cf(boolean z) {
        if (z) {
            this.aCz.setAlpha(128);
            this.aCA.setAlpha(128);
            return;
        }
        this.aCz.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aCA.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void hO() {
        this.aCB.hO();
    }

    public int Eu() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public void setIsManager(boolean z) {
        Gi().setIsManager(z);
    }

    public void EP() {
        if (EO() != null) {
            EO().w(EO().getEditText());
            EO().hide();
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.q qVar, int i2) {
        if (EO() != null) {
            EO().Ba();
            EO().refresh();
            if (EO().BB()) {
                EO().Cf();
            } else {
                EO().getEditText().requestFocus();
                EO().v(EO().getEditText());
            }
            I(i, i2);
            com.baidu.tieba.bubble.h.a(this.aBp, EO().getEditorToolButtonContainer(), false, this.aDr);
        }
    }

    protected void I(int i, int i2) {
        if (EO() != null) {
            this.azB = new ch(this.aBp, i, i2, EO(), this.aCB, this.mNavigationBar.getHeight());
            this.aBp.mHandler.postDelayed(this.azB, 300L);
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null && EO() != null) {
            EO().setOnActionListener(new by(this, wVar));
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (EO() != null) {
            EO().are.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (EO() != null) {
            EO().are.setBaobaoUris(writeImagesInfo);
        }
    }

    public void o(ArrayList<String> arrayList) {
        if (EO() != null) {
            EO().o(arrayList);
        }
    }

    public String EU() {
        return EO() != null ? EO().getContent() : "";
    }

    public VoiceData.VoiceModel getAudioData() {
        if (EO() != null) {
            return EO().getAudioData();
        }
        return null;
    }

    public void BP() {
        if (EO() != null) {
            EO().BP();
        }
    }

    public void BQ() {
        if (EO() != null) {
            EO().BQ();
        }
    }

    public void bQ(boolean z) {
        if (EO() != null && z) {
            EO().getEditText().setText("");
            EO().BY();
            EO().clearData();
        }
    }

    public void cg(boolean z) {
        PbEditor EO = EO();
        if (EO != null) {
            if (z) {
                EO.Bs();
            } else {
                EO.Bt();
            }
        }
    }

    public void fc(String str) {
        if (EO() != null) {
            EO().setContent(str);
        }
    }

    public void eV(int i) {
        if (i > 1) {
            if (this.aCE != null) {
                this.aCE.cj(false);
            }
            if (this.aCF != null) {
                this.aCF.cj(false);
                return;
            }
            return;
        }
        if (this.aCE != null) {
            this.aCE.cj(true);
        }
        if (this.aCF != null) {
            this.aCF.cj(true);
        }
    }

    public boolean Ch() {
        if (EO() != null) {
            return EO().Ch();
        }
        return false;
    }

    public PbEditor EO() {
        if (this.aBp == null) {
            return null;
        }
        if (this.azA == null) {
            this.azA = new PbEditor(this.aBp);
            this.azA.setOrientation(1);
            this.azA.au(false);
            ((LinearLayout) this.aBp.findViewById(com.baidu.tieba.v.frs_editor_container)).addView(this.azA, new ViewGroup.LayoutParams(-1, -2));
            this.azA.setVisibility(8);
            this.aBp.FE();
            this.azA.changeSkinType(TbadkApplication.m251getInst().getSkinType());
        }
        return this.azA;
    }

    public bd GH() {
        return this.aCC;
    }

    public View getRootView() {
        return this.KO;
    }

    public void eW(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aBp.findViewById(com.baidu.tieba.v.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }
}
