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
    private static /* synthetic */ int[] aDC;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private TextView JN;
    private FrsActivity aBz;
    private View aCH;
    private bd aCM;
    private View aCU;
    private View aCV;
    private View aCW;
    private ImageView aCX;
    private ImageView aCY;
    private ImageView aCZ;
    private View.OnClickListener aDg;
    private int aDi;
    private int aDj;
    private TextView aDl;
    private LivePlayingImageView aDm;
    private View aDn;
    private com.baidu.tbadk.core.data.g aDo;
    private View aDp;
    private com.baidu.adp.lib.guide.d aDr;
    private FrsOfficalBanner aDs;
    private Runnable aDu;
    private View aDv;
    private b aDw;
    private NoNetworkView atH;
    private PbEditor azJ;
    private int mIsLike;
    private NavigationBar mNavigationBar;
    private MorePopupWindow mPopWindow;
    private boolean aCE = false;
    private RelativeLayout KP = null;
    private FrameLayout aCF = null;
    private ImageView aCG = null;
    private FrameLayout aCI = null;
    private ImageView aCJ = null;
    private ImageView aCK = null;
    private BdTypeListView aCL = null;
    private TextView aCN = null;
    private AlertDialog ayP = null;
    private FrsHeaderView aCO = null;
    private com.baidu.tieba.frs.view.r aCP = null;
    private com.baidu.tieba.frs.view.e aCQ = null;
    private bn aCR = null;
    private TextView aCS = null;
    private View aCT = null;
    private int mSkinType = 0;
    private com.baidu.tbadk.core.view.y Yg = null;
    private di aDa = null;
    private com.baidu.tieba.view.t aDb = null;
    private SlidingMenu aDc = null;
    private String aDd = null;
    AlertDialog aDe = null;
    Animation aDf = null;
    private DialogInterface.OnClickListener aDh = null;
    private com.baidu.tbadk.core.view.u aBm = null;
    private BannerView aDk = null;
    private boolean aDq = false;
    private boolean aDt = false;
    com.baidu.tbadk.coreExtra.view.b aDx = new bv(this);
    com.baidu.tbadk.coreExtra.view.b aDy = new bz(this);
    View aDz = null;
    private View.OnTouchListener aDA = new ca(this);
    private com.baidu.tieba.bubble.t aDB = new cb(this);
    private ch azK = null;

    static /* synthetic */ int[] GK() {
        int[] iArr = aDC;
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
            aDC = iArr;
        }
        return iArr;
    }

    public bu(FrsActivity frsActivity, View.OnClickListener onClickListener) {
        this.aBz = null;
        this.aDg = null;
        this.aBz = frsActivity;
        this.aDg = onClickListener;
        initUI();
    }

    public void i(b bVar) {
        this.aDw = bVar;
        this.aDl.setVisibility(8);
        if (this.aDm.getVisibility() != 0 && bVar != null && bVar.zL() != null && bVar.zL().getAnchorPower() != null && bVar.zL().getAnchorPower().have_power.intValue() != 0) {
            this.aDl.setVisibility(0);
        }
    }

    private void initUI() {
        this.KP = (RelativeLayout) this.aBz.findViewById(com.baidu.tieba.v.frs);
        this.aDc = new SlidingMenu(this.aBz);
        this.aDc.setMode(1);
        this.aDc.setTouchModeAbove(1);
        this.aDc.setBehindOffset(com.baidu.adp.lib.util.m.dip2px(this.aBz, 48.0f));
        this.aDc.setBehindScrollScale(0.5f);
        this.aDc.setFadeDegree(0.35f);
        this.aDc.attachToActivity(this.aBz, 1);
        this.mNavigationBar = (NavigationBar) this.aBz.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aDs = (FrsOfficalBanner) this.aBz.findViewById(com.baidu.tieba.v.frs_offical_banner);
        this.aDs.setBannerViewClickListener(this.aDy);
        this.aCH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aCH.setOnClickListener(this.aDg);
        this.aDp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, com.baidu.tieba.w.frs_icon_bottom_title, (View.OnClickListener) null);
        this.JN = (TextView) this.aDp.findViewById(com.baidu.tieba.v.navigationTitle_frs);
        this.aCZ = (ImageView) this.aDp.findViewById(com.baidu.tieba.v.icon_bottom_title_image);
        this.aDp.setOnClickListener(this.aDg);
        this.aDn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_live, (View.OnClickListener) null);
        this.aDl = (TextView) this.aDn.findViewById(com.baidu.tieba.v.nb_item_live_text_btn);
        this.aDl.setOnClickListener(this.aDg);
        this.aDm = (LivePlayingImageView) this.aDn.findViewById(com.baidu.tieba.v.live_playing);
        this.aDm.setStatisticsKey("frs_live_icon");
        this.aDm.setVisibleChangeCallback(new cc(this));
        this.aDv = this.aBz.findViewById(com.baidu.tieba.v.frs_list_content);
        this.aCG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.widget_nb_item_edit, this.aDg);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.nb_item_frs_more, (View.OnClickListener) null);
        this.aCT = addCustomView.findViewById(com.baidu.tieba.v.frs_top_more);
        this.aCT.setOnClickListener(this.aDg);
        this.aCS = (TextView) addCustomView.findViewById(com.baidu.tieba.v.frs_more_mes_text);
        this.aCI = (FrameLayout) this.aBz.findViewById(com.baidu.tieba.v.refresh_layout);
        this.aCJ = (ImageView) this.aBz.findViewById(com.baidu.tieba.v.refresh_bg);
        this.aCK = (ImageView) this.aBz.findViewById(com.baidu.tieba.v.refresh_icon);
        this.aCL = (BdTypeListView) this.aBz.findViewById(com.baidu.tieba.v.frs_lv_thread);
        this.Yg = new com.baidu.tbadk.core.view.y(this.aBz);
        this.aCL.setDivider(null);
        this.aCL.setOnScrollToPullListener(new cd(this));
        this.aCL.setPullRefresh(this.Yg);
        this.aCL.setDividerHeight(0);
        this.aCL.setRecyclerListener(new ce(this));
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.c.a(new cf(this)));
        this.aCM = new bd(this.aBz, this.aCL, com.baidu.tbadk.core.util.ba.mD().mF());
        this.aCN = (TextView) this.aBz.findViewById(com.baidu.tieba.v.frs_noexist_post);
        this.aCN.setVisibility(8);
        this.aCI.setOnClickListener(this.aDg);
        this.aCI.setOnTouchListener(this.aDA);
        this.atH = (NoNetworkView) this.aBz.findViewById(com.baidu.tieba.v.view_no_network);
        cb(false);
    }

    private void FW() {
        if (this.aDk == null) {
            this.aDk = new BannerView(this.aBz);
            this.aDk.setLayoutParams(new AbsListView.LayoutParams(-1, this.aBz.getResources().getDimensionPixelSize(com.baidu.tieba.t.frs_header_banner_height)));
            this.aDk.setVisibility(8);
            this.aDk.setBannerViewClickListener(this.aDy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FX() {
        if (TextUtils.equals(this.aDd, "frs_page")) {
            TiebaStatic.eventStat(this.aBz, "top_banner_ck", "click");
        }
        if (this.aDo != null) {
            String value = this.aDo.getValue();
            if (this.aDo.jT() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.aBz, value, false, "frs_banner")));
            } else if (this.aDo.jT() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aBz.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aBz).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aDo.jT() == 3) {
                new com.baidu.tbadk.core.util.bn();
                com.baidu.tbadk.core.util.bn isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.Fv != UtilHelper.NativePageType.NONE) {
                    switch (GK()[isNativeAddress.Fv.ordinal()]) {
                        case 2:
                            this.aBz.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aBz).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aBz.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.aBz).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                com.baidu.tbadk.browser.a.i(this.aBz, value);
            } else if (this.aDo.jT() == 4) {
                this.aBz.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.aBz).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    private void FY() {
        this.aDz = com.baidu.adp.lib.g.b.ek().inflate(this.aBz, com.baidu.tieba.w.frs_pop_more_window, null);
        this.aCU = this.aDz.findViewById(com.baidu.tieba.v.frs_pop_more_window_all_threads_layout);
        this.aCU.setOnClickListener(this.aDg);
        this.aCX = (ImageView) this.aDz.findViewById(com.baidu.tieba.v.choose_all_threads);
        this.aCX.setVisibility(0);
        this.aCV = this.aDz.findViewById(com.baidu.tieba.v.frs_pop_more_window_good_threads_layout);
        this.aCV.setOnClickListener(this.aDg);
        this.aCY = (ImageView) this.aDz.findViewById(com.baidu.tieba.v.choose_good_threads);
        this.aCW = this.aDz.findViewById(com.baidu.tieba.v.frs_pop_more_window_add_shortcut_layout);
        this.aCW.setOnClickListener(this.aDg);
        if ("M351".equals(Build.MODEL)) {
            this.aCW.setVisibility(8);
        } else {
            this.aCW.setVisibility(0);
        }
        this.mPopWindow = new MorePopupWindow(this.aBz, this.aDz, this.mNavigationBar, this.aBz.getResources().getDrawable(com.baidu.tieba.u.bg_pull_down_n), null);
    }

    public void ca(boolean z) {
        if (this.mPopWindow == null) {
            FY();
        }
        ce(z);
        this.aBz.getLayoutMode().h(this.aDz);
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.mPopWindow, this.mNavigationBar, 0, 0);
    }

    public void FZ() {
        com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aBz);
    }

    public void Ga() {
        if (TbadkApplication.m251getInst().isFirstGoFrs()) {
            TbadkApplication.m251getInst().setFirstGoFrs(false);
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(this.mNavigationBar).A(0).r(false);
            gVar.a(new cg(this));
            this.aDr = gVar.dA();
            this.aDr.c(this.aBz);
        }
    }

    public void Gb() {
        if ("normal_page".equals(this.aDd)) {
            if (this.aCO != null) {
                this.aCO.Gb();
            }
        } else if ("frs_page".equals(this.aDd) && this.aCP != null) {
            this.aCP.Gb();
        }
    }

    public View Gc() {
        return this.aDp;
    }

    public View Gd() {
        return this.aCU;
    }

    public View Ge() {
        return this.aCV;
    }

    public View Gf() {
        return this.aCW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageView Gg() {
        return this.aCG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Gh() {
        return this.aCT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Gi() {
        return this.aCH;
    }

    public boolean Gj() {
        if ("normal_page".equals(this.aDd)) {
            if (this.aCO != null) {
                return this.aCO.Gj();
            }
        } else if ("frs_page".equals(this.aDd) && this.aCP != null) {
            return this.aCP.Gj();
        }
        return false;
    }

    public void f(com.baidu.tbadk.core.view.u uVar) {
        this.aBm = uVar;
        if (this.atH != null) {
            this.atH.a(this.aBm);
        }
    }

    public void a(SlidingMenu.OnClosedListener onClosedListener) {
        this.aDc.setOnClosedListener(onClosedListener);
    }

    public void a(SlidingMenu.OnOpenedListener onOpenedListener) {
        this.aDc.setOnOpenedListener(onOpenedListener);
    }

    public di Gk() {
        if (this.aDa == null) {
            this.aDa = new di(this.aBz);
            this.aDc.setMenu(this.aDa.getView());
            this.aDa.o(this.aDg);
            this.aDa.changeSkinType(TbadkApplication.m251getInst().getSkinType());
            this.aDa.init();
        }
        return this.aDa;
    }

    public SlidingMenu getSlidingMenu() {
        return this.aDc;
    }

    public void showMenu(boolean z) {
        this.aDc.showMenu(z);
    }

    public void a(com.baidu.tbadk.core.data.q qVar, boolean z) {
        String string = this.aBz.getString(com.baidu.tieba.y.view);
        String string2 = this.aBz.getString(com.baidu.tieba.y.view_host);
        String string3 = this.aBz.getString(com.baidu.tieba.y.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.aBz);
        builder.setTitle(com.baidu.tieba.y.operation);
        if (z) {
            builder.setItems(new String[]{string, string3}, this.aDh);
        } else {
            builder.setItems(new String[]{string, string2, string3}, this.aDh);
        }
        this.aDe = builder.create();
        this.aDe.setCanceledOnTouchOutside(true);
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aCL.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.am amVar) {
        this.aCM.a(amVar);
    }

    public void a(com.baidu.adp.widget.ListView.an anVar) {
        this.aCM.a(anVar);
    }

    public void k(View.OnClickListener onClickListener) {
        this.aCM.k(onClickListener);
    }

    public void m(View.OnClickListener onClickListener) {
        this.aCM.l(onClickListener);
    }

    public void a(DialogInterface.OnClickListener onClickListener) {
        this.aDh = onClickListener;
    }

    public void Gl() {
        if (this.aDe != null) {
            com.baidu.adp.lib.g.j.a(this.aDe, this.aBz);
        }
    }

    public void onDestroy() {
        if (this.aCO != null) {
            this.aCO.onDestory();
        }
        if (this.aCP != null) {
            this.aCP.onDestory();
        }
        if (this.aDu != null) {
            this.aBz.mHandler.removeCallbacks(this.aDu);
        }
        if (this.azK != null) {
            this.aBz.mHandler.removeCallbacks(this.azK);
        }
    }

    private Animation Gm() {
        if (this.aDf == null) {
            this.aDf = AnimationUtils.loadAnimation(this.aBz, com.baidu.tieba.p.refresh_rotate);
            this.aDf.setInterpolator(new LinearInterpolator());
            this.aDf.setFillAfter(true);
        }
        return this.aDf;
    }

    public void cb(boolean z) {
        this.aCE = z;
        if (z) {
            this.aCI.setOnTouchListener(null);
            com.baidu.tbadk.core.a.a(this.aBz, this.aCK, Gm(), (Animation.AnimationListener) null);
            com.baidu.tbadk.core.util.aw.c(this.aCJ, com.baidu.tieba.u.pic_fresh_s);
            return;
        }
        this.aCI.setOnTouchListener(this.aDA);
        this.aCL.hN();
        this.aCK.clearAnimation();
        com.baidu.tbadk.core.util.aw.c(this.aCJ, com.baidu.tieba.u.pic_fresh_n);
    }

    public boolean Gn() {
        return this.aCE;
    }

    public FrsHeaderView Go() {
        return this.aCO;
    }

    public com.baidu.tieba.frs.view.r Gp() {
        return this.aCP;
    }

    public void Gq() {
        this.aCL.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.JN.setText("");
            this.aCZ.setVisibility(4);
            return;
        }
        this.JN.setText(String.valueOf(str) + this.aBz.getString(com.baidu.tieba.y.forum));
        this.aCZ.setVisibility(0);
    }

    public void Gr() {
        if (this.aCM != null) {
            this.aCM.notifyDataSetChanged();
        }
    }

    public void K(int i, int i2) {
        this.mIsLike = i2;
        Gu();
        this.aDd = "normal_page";
        if (this.aCO == null) {
            this.aCO = new FrsHeaderView(this.aBz, FrsHeaderView.PAGE.FRS_LIST, null, null, i);
            this.aCO.changeSkinType(this.mSkinType);
            this.aCO.o(this.aDg);
        }
        this.aCL.addHeaderView(this.aCO.getView());
        Gs();
    }

    public void L(int i, int i2) {
        this.mIsLike = i2;
        Gu();
        this.aDd = "frs_page";
        eN(i);
        this.aCL.addHeaderView(this.aCP.getView());
        Gs();
    }

    private void Gs() {
        if (this.aDu == null) {
            this.aDu = new bw(this);
        }
        this.aBz.mHandler.postDelayed(this.aDu, 4000L);
    }

    private void eN(int i) {
        if (this.aCP == null) {
            this.aCP = new com.baidu.tieba.frs.view.r(this.aBz, null, null, i);
            this.aCP.changeSkinType(this.mSkinType);
            this.aCP.setBannerViewClickListener(this.aDx);
            this.aCP.o(this.aDg);
        }
    }

    public void Gt() {
        Gu();
        this.aDd = "good_page";
        if (this.aCQ == null) {
            this.aCQ = new com.baidu.tieba.frs.view.e(this.aBz);
            this.aCQ.changeSkinType(this.mSkinType);
        }
        this.aCL.addHeaderView(this.aCQ.getView());
    }

    private void Gu() {
        if ("normal_page".equals(this.aDd) && this.aCO != null) {
            this.aCL.removeHeaderView(this.aCO.getView());
        } else if ("frs_page".equals(this.aDd) && this.aCP != null) {
            this.aCL.removeHeaderView(this.aCP.getView());
        } else if ("good_page".equals(this.aDd) && this.aCQ != null) {
            this.aCL.removeHeaderView(this.aCQ.getView());
        }
    }

    public void Gv() {
        if (this.aCO != null) {
            this.aCO.GZ().setVisibility(0);
        }
    }

    public void Gw() {
        if (this.aCO != null) {
            this.aCO.GZ().setVisibility(8);
        }
    }

    public void Gx() {
        if (this.aCP != null) {
            this.aCP.GZ().setVisibility(0);
        }
    }

    public void Gy() {
        if (this.aCP != null) {
            this.aCP.GZ().setVisibility(8);
        }
    }

    public boolean Gz() {
        if ("normal_page".equals(this.aDd) && this.aCO != null) {
            return this.aCO.Gz();
        }
        if ("frs_page".equals(this.aDd) && this.aCP != null) {
            return this.aCP.Gz();
        }
        return false;
    }

    public boolean GA() {
        if ("normal_page".equals(this.aDd) && this.aCO != null) {
            return this.aCO.GT();
        }
        if ("frs_page".equals(this.aDd) && this.aCP != null) {
            return this.aCP.GT();
        }
        return false;
    }

    public void cc(boolean z) {
        this.aCM.bW(z);
    }

    public void cd(boolean z) {
        this.aCM.bX(z);
    }

    private void GB() {
        if (this.ayP == null) {
            String[] strArr = {this.aBz.getString(com.baidu.tieba.y.take_photo), this.aBz.getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aBz);
            builder.setTitle(this.aBz.getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new bx(this));
            this.ayP = builder.create();
            this.ayP.setCanceledOnTouchOutside(true);
        }
    }

    public void GC() {
        GB();
        if (this.ayP != null) {
            com.baidu.adp.lib.g.j.a(this.ayP, this.aBz);
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
        this.aCM.a(arrayList, bVar, eO(i), eP(i2));
        if (arrayList == null || arrayList.size() <= 0) {
            this.aCN.setText(com.baidu.tieba.y.frs_nodata);
            this.aCN.setVisibility(0);
            return;
        }
        this.aCN.setVisibility(8);
    }

    public BdListView uf() {
        return this.aCL;
    }

    private boolean eO(int i) {
        return i > 1;
    }

    private boolean eP(int i) {
        return i == 1;
    }

    public void GD() {
        this.aCM.bW(false);
        this.aCM.bX(false);
        this.aCM.notifyDataSetInvalidated();
    }

    public void eQ(int i) {
        this.aCL.setSelection(i);
    }

    public void a(ForumData forumData, b bVar) {
        float b = b(forumData);
        if (this.aCP != null) {
            this.aCP.c(forumData, bVar);
            this.aCP.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
            this.aCP.eY(forumData.getSignData().getSigned());
            if (forumData.getSignData().getForumRank() == -2) {
                this.aCP.ci(false);
            }
        }
    }

    public void a(SignData signData, ForumData forumData, b bVar) {
        if (this.aCP != null && signData != null) {
            this.aCP.c(forumData, bVar);
            this.aCP.eY(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aCP.GT()) {
                a(this.aCP, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aDj);
                    forumData.setLevelupScore(this.aDi);
                }
                this.aCP.c(forumData, bVar);
                this.aCP.e(this.aCP.GY(), true);
            }
        }
    }

    private void ce(boolean z) {
        if (this.aCX != null && this.aCY != null) {
            if (z) {
                this.aCX.setVisibility(4);
                this.aCY.setVisibility(0);
                return;
            }
            this.aCX.setVisibility(0);
            this.aCY.setVisibility(4);
        }
    }

    public void eR(int i) {
        if (this.aCP != null) {
            this.aCP.eY(i);
        }
    }

    public void a(int i, ForumData forumData, b bVar, boolean z) {
        if (this.aCP != null) {
            this.aCP.c(forumData, bVar);
            this.aCP.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aCP.ci(false);
            }
        }
    }

    public void a(ForumData forumData, UserData userData) {
        if (!this.aDq && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aDo = forumData.getFrsBannerData();
            FW();
            this.aDk.reset();
            this.aCL.removeHeaderView(this.aDk);
            if (this.aDo.getType() == 2) {
                if (this.aCP == null) {
                    eN(userData.getIsMem());
                }
                this.aDs.setText(this.aDo.jV());
                this.aDs.setVisibility(0);
                this.aDt = true;
            } else if (this.aDo.getType() == 1 && !TextUtils.isEmpty(this.aDo.jU())) {
                this.aDk.setData(this.aDo.jU());
                if (this.aDk.pT()) {
                    this.aDq = true;
                    this.aCL.addHeaderView(this.aDk);
                }
            }
        }
    }

    public void GE() {
        if (this.aDk != null) {
            this.aDq = false;
            this.aCL.removeHeaderView(this.aDk);
        }
    }

    public void b(ForumData forumData, b bVar) {
        float b = b(forumData);
        if (this.aCO != null) {
            this.aCO.c(forumData, bVar);
            this.aCO.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
            if (forumData.getSignData().getForumRank() == -2) {
                this.aCO.ci(false);
                return;
            }
            this.aCO.ci(true);
            this.aCO.eY(forumData.getSignData().getSigned());
        }
    }

    public void eS(int i) {
        if (this.aCO != null) {
            this.aCO.eY(i);
        }
    }

    public void b(SignData signData, ForumData forumData, b bVar) {
        if (this.aCO != null && signData != null) {
            this.aCO.c(forumData, bVar);
            this.aCO.eY(signData.getSigned());
            if (signData.getBonusPoint() > 0 && this.aCO.GT()) {
                a(this.aCO, signData);
                if (forumData != null) {
                    forumData.setCurScore(this.aDj);
                    forumData.setLevelupScore(this.aDi);
                }
                this.aCO.c(forumData, bVar);
                this.aCO.e(this.aCO.GY(), true);
            }
        }
    }

    private void a(com.baidu.tieba.frs.view.a aVar, SignData signData) {
        if (aVar != null && signData != null) {
            int bonusPoint = signData.getBonusPoint();
            boolean z = false;
            float f = 0.0f;
            if (bonusPoint >= this.aDi - this.aDj) {
                z = true;
                this.aDi = signData.getLevelUpScore();
            }
            this.aDj = bonusPoint + this.aDj;
            if (this.aDj > this.aDi) {
                this.aDj = this.aDi;
            }
            if (this.aDi != 0) {
                f = this.aDj / this.aDi;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            aVar.a(z, f);
        }
    }

    public void b(int i, ForumData forumData, b bVar, boolean z) {
        if (this.aCO != null) {
            this.aCO.c(forumData, bVar);
            if (forumData != null) {
                this.aCO.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData().getForumRank() == -2) {
                    this.aCO.ci(false);
                }
            }
        }
    }

    public void eT(int i) {
        if (this.aCO != null) {
            this.aCO.eX(i);
        }
    }

    public void eU(int i) {
        if (this.aCP != null) {
            this.aCP.eX(i);
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.aDi = forumData.getLevelupScore();
        this.aDj = forumData.getCurScore();
        if (this.aDi > 0) {
            return this.aDj / this.aDi;
        }
        return 0.0f;
    }

    public void GF() {
        if (this.aCO != null) {
            this.aCO.GV();
        }
    }

    public void GG() {
        if (this.aCP != null) {
            this.aCP.GV();
        }
    }

    public void setIsMem(int i) {
        if (this.aCO != null) {
            this.aCO.setIsMem(i);
        }
        if (this.aCP != null) {
            this.aCP.setIsMem(i);
        }
    }

    public void B(View view) {
        if (this.aCO != null) {
            this.aCO.e(view, false);
        }
    }

    public void C(View view) {
        if (this.aCP != null) {
            this.aCP.e(view, false);
        }
    }

    public void onPause() {
        if (this.aDb != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow, this.aBz);
        }
    }

    public void release() {
        if (this.atH != null && this.aBm != null) {
            this.atH.b(this.aBm);
        }
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.h> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        Gt();
        if (this.aCR == null) {
            this.aCR = new bn(this.aBz, arrayList);
            this.aCQ.a(this.aCR);
            this.aCQ.c(onItemClickListener);
            return;
        }
        this.aCR.setData(arrayList);
        this.aCR.notifyDataSetChanged();
    }

    public void eJ(int i) {
        if (this.aCR != null) {
            this.aCR.eJ(i);
        }
    }

    public void GH() {
        this.aCS.setVisibility(8);
    }

    public void a(cz czVar, boolean z, boolean z2, boolean z3) {
        if (this.aDa != null) {
            Gk().a(czVar, z2, z3);
        }
        if (!z) {
            this.aCS.setVisibility(8);
            return;
        }
        long GO = z2 ? czVar.GO() + 0 : 0L;
        if (z3) {
            GO += czVar.GN();
        }
        if (GO > 0 && this.aCT.getVisibility() == 0) {
            this.aCS.setVisibility(0);
            if (GO < 10) {
                this.aCS.setText(String.valueOf(GO));
                com.baidu.tbadk.core.util.aw.h((View) this.aCS, com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            } else if (GO < 100) {
                this.aCS.setText(String.valueOf(GO));
                com.baidu.tbadk.core.util.aw.h((View) this.aCS, com.baidu.tieba.u.icon_news_head_prompt_two);
                return;
            } else {
                this.aCS.setText("   ");
                com.baidu.tbadk.core.util.aw.h((View) this.aCS, com.baidu.tieba.u.icon_news_head_prompt_more);
                return;
            }
        }
        this.aCS.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (this.aCP != null) {
            this.aCP.changeSkinType(i);
        }
        if (this.Yg != null) {
            this.Yg.bM(i);
        }
        if (this.aCM != null) {
            this.aCM.FP();
            this.aCM.notifyDataSetChanged();
            this.aCM.onChangeSkinType(i);
        }
        if (this.aCR != null) {
            this.aCR.notifyDataSetChanged();
        }
        if (this.aCQ != null) {
            this.aCQ.changeSkinType(i);
        }
        if (this.aDa != null) {
            this.aDa.changeSkinType(i);
        }
        if (this.aCO != null) {
            this.aCO.changeSkinType(i);
        }
        this.aBz.Fs();
        this.aBz.getLayoutMode().L(i == 1);
        this.aBz.getLayoutMode().h(this.KP);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.mPopWindow != null) {
            this.mPopWindow.onChangeSkinType(this.aBz, i, com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.bg_pull_down_n));
        }
        if (this.atH != null) {
            this.atH.onChangeSkinType(i);
        }
        if (this.azJ != null) {
            EQ().changeSkinType(i);
        }
        if (this.aDk != null) {
            this.aDk.pU();
        }
    }

    public void GI() {
        this.KP.removeView(this.aCF);
        this.aCF = null;
    }

    public void cf(boolean z) {
        if (z) {
            this.aCJ.setAlpha(128);
            this.aCK.setAlpha(128);
            return;
        }
        this.aCJ.setAlpha(MotionEventCompat.ACTION_MASK);
        this.aCK.setAlpha(MotionEventCompat.ACTION_MASK);
    }

    public void hO() {
        this.aCL.hO();
    }

    public int Ew() {
        return com.baidu.tieba.v.user_icon_box;
    }

    public void setIsManager(boolean z) {
        Gk().setIsManager(z);
    }

    public void ER() {
        if (EQ() != null) {
            EQ().w(EQ().getEditText());
            EQ().hide();
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.q qVar, int i2) {
        if (EQ() != null) {
            EQ().Bc();
            EQ().refresh();
            if (EQ().BD()) {
                EQ().Ch();
            } else {
                EQ().getEditText().requestFocus();
                EQ().v(EQ().getEditText());
            }
            I(i, i2);
            com.baidu.tieba.bubble.h.a(this.aBz, EQ().getEditorToolButtonContainer(), false, this.aDB);
        }
    }

    protected void I(int i, int i2) {
        if (EQ() != null) {
            this.azK = new ch(this.aBz, i, i2, EQ(), this.aCL, this.mNavigationBar.getHeight());
            this.aBz.mHandler.postDelayed(this.azK, 300L);
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null && EQ() != null) {
            EQ().setOnActionListener(new by(this, wVar));
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        if (EQ() != null) {
            EQ().arn.a(writeImagesInfo, z);
        }
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        if (EQ() != null) {
            EQ().arn.setBaobaoUris(writeImagesInfo);
        }
    }

    public void p(ArrayList<String> arrayList) {
        if (EQ() != null) {
            EQ().p(arrayList);
        }
    }

    public String EW() {
        return EQ() != null ? EQ().getContent() : "";
    }

    public VoiceData.VoiceModel getAudioData() {
        if (EQ() != null) {
            return EQ().getAudioData();
        }
        return null;
    }

    public void BR() {
        if (EQ() != null) {
            EQ().BR();
        }
    }

    public void BS() {
        if (EQ() != null) {
            EQ().BS();
        }
    }

    public void bQ(boolean z) {
        if (EQ() != null && z) {
            EQ().getEditText().setText("");
            EQ().Ca();
            EQ().clearData();
        }
    }

    public void cg(boolean z) {
        PbEditor EQ = EQ();
        if (EQ != null) {
            if (z) {
                EQ.Bu();
            } else {
                EQ.Bv();
            }
        }
    }

    public void fc(String str) {
        if (EQ() != null) {
            EQ().setContent(str);
        }
    }

    public void eV(int i) {
        if (i > 1) {
            if (this.aCO != null) {
                this.aCO.cj(false);
            }
            if (this.aCP != null) {
                this.aCP.cj(false);
                return;
            }
            return;
        }
        if (this.aCO != null) {
            this.aCO.cj(true);
        }
        if (this.aCP != null) {
            this.aCP.cj(true);
        }
    }

    public boolean Cj() {
        if (EQ() != null) {
            return EQ().Cj();
        }
        return false;
    }

    public PbEditor EQ() {
        if (this.aBz == null) {
            return null;
        }
        if (this.azJ == null) {
            this.azJ = new PbEditor(this.aBz);
            this.azJ.setOrientation(1);
            this.azJ.au(false);
            ((LinearLayout) this.aBz.findViewById(com.baidu.tieba.v.frs_editor_container)).addView(this.azJ, new ViewGroup.LayoutParams(-1, -2));
            this.azJ.setVisibility(8);
            this.aBz.FG();
            this.azJ.changeSkinType(TbadkApplication.m251getInst().getSkinType());
        }
        return this.azJ;
    }

    public bd GJ() {
        return this.aCM;
    }

    public View getRootView() {
        return this.KP;
    }

    public void eW(int i) {
        LinearLayout linearLayout = (LinearLayout) this.aBz.findViewById(com.baidu.tieba.v.frs_editor_container);
        if (i != linearLayout.getVisibility()) {
            linearLayout.setVisibility(i);
        }
    }
}
