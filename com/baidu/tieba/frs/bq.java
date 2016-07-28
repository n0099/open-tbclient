package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.entelechy.b.a;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.u;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bq {
    private static /* synthetic */ int[] bGV;
    private com.baidu.tieba.play.f aJx;
    private com.baidu.tbadk.core.data.s bGA;
    private View bGC;
    private View bGE;
    private com.baidu.tieba.frs.entelechy.b.e bGF;
    private com.baidu.tieba.frs.entelechy.b.c bGG;
    private GifView bGH;
    private TbImageView bGI;
    private HashSet<String> bGJ;
    private com.baidu.tieba.frs.view.t bGK;
    private int bGL;
    private int bGM;
    private ObservedChangeLinearLayout bGP;
    private FrsActivity bGh;
    private View bGj;
    private ViewStub bGk;
    private com.baidu.tieba.frs.entelechy.a.ai bGp;
    private View bGr;
    private View.OnClickListener bGw;
    private View bGz;
    private PbListView bjZ;
    private NoNetworkView bmB;
    private CommonTipView bwO;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mPullView;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    public static int bGO = 3;
    private boolean bGg = false;
    private NoPressedRelativeLayout bGi = null;
    private FrameLayout bGl = null;
    private TbImageView bGm = null;
    private TbImageView bGn = null;
    private BdExpandListView bGo = null;
    private com.baidu.tbadk.core.dialog.c bGq = null;
    private TextView bGs = null;
    private ImageView bGt = null;
    com.baidu.tbadk.core.dialog.c bGu = null;
    Animation bGv = null;
    private c.b bGx = null;
    private NoNetworkView.a bCV = null;
    private BannerView bGy = null;
    private boolean bGB = false;
    private boolean mHasMore = true;
    private int bGD = 0;
    private boolean aLm = false;
    private int aLr = 0;
    private int aLq = 0;
    private View bGN = null;
    private boolean bGQ = true;
    BannerView.a bGR = new br(this);
    private Runnable bGS = new bs(this);
    private com.baidu.adp.lib.guide.d Ff = null;
    private Handler mHandler = null;
    private Runnable bGT = new bt(this);
    private Runnable bGU = new bv(this);

    static /* synthetic */ int[] Xf() {
        int[] iArr = bGV;
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
            bGV = iArr;
        }
        return iArr;
    }

    public ObservedChangeLinearLayout Wp() {
        return this.bGP;
    }

    public View Wq() {
        return this.bGN;
    }

    public bq(FrsActivity frsActivity, View.OnClickListener onClickListener, a aVar) {
        this.bGh = null;
        this.bGw = null;
        this.bGh = frsActivity;
        this.bGw = onClickListener;
        a(aVar);
        this.bGJ = new HashSet<>();
    }

    private void a(a aVar) {
        this.bGi = (NoPressedRelativeLayout) this.bGh.findViewById(u.g.frs);
        this.mNavigationBar = (NavigationBar) this.bGh.findViewById(u.g.view_navigation_bar);
        this.bGz = this.bGh.findViewById(u.g.frs_navi_line);
        b XT = aVar.XT();
        if (XT != null) {
            XT.ad(this.bGz);
        }
        this.bGj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bGj.setOnClickListener(this.bGw);
        this.mBackImageView = (ImageView) this.bGj.findViewById(u.g.widget_navi_back_button);
        this.bGC = this.bGh.findViewById(u.g.frs_list_content);
        this.bGr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bGt = (ImageView) this.bGr.findViewById(u.g.frs_top_more);
        this.bGt.setContentDescription(this.bGh.getResources().getString(u.j.more));
        this.bGL = u.f.btn_more_selector_s;
        this.bGM = u.f.btn_more_selector;
        dp(false);
        this.bGt.setOnClickListener(this.bGw);
        this.bGs = (TextView) this.bGr.findViewById(u.g.frs_more_mes_text);
        this.bGo = (BdExpandListView) this.bGh.findViewById(u.g.frs_lv_thread);
        this.bGi.setBottomOrderView(this.bGo);
        this.bGo.setOnTouchListener(this.bGh.aGS);
        this.bGo.setDivider(null);
        if (XT != null) {
            this.bGE = XT.a(this.bGh.getActivity(), this.bGo);
        }
        this.bGo.setDividerHeight(0);
        this.bGo.setRecyclerListener(new bw(this));
        this.bjZ = new PbListView(this.bGh.getPageContext().getPageActivity());
        this.bjZ.jp();
        this.bjZ.cS(u.d.cp_bg_line_c);
        this.bGo.setOnSrollToBottomListener(this.bGh);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ac(new bx(this)));
        this.bGp = aVar.a(this.bGh, this.bGo, com.baidu.tbadk.core.util.bb.ue().ug());
        dj(false);
        this.bmB = (NoNetworkView) this.bGh.findViewById(u.g.view_no_network);
        Ws();
        this.bGF = aVar.c(this.bGh, this.bGi);
        this.bGG = aVar.b(this.bGh, this.bGi);
        this.bGP = (ObservedChangeLinearLayout) this.bGh.findViewById(u.g.navigation_bar_wrapperLayout);
        this.bGP.setOnSizeChangeListener(new by(this));
        this.bGN = this.bGh.findViewById(u.g.statebar_view);
        this.aJx = new com.baidu.tieba.play.f(this.bGh.getPageContext(), this.bGo);
    }

    public com.baidu.tieba.play.f Ij() {
        return this.aJx;
    }

    public com.baidu.tieba.frs.entelechy.b.c Wr() {
        return this.bGG;
    }

    public void dh(boolean z) {
        if (this.bGF != null) {
            this.bGF.dh(z);
        }
    }

    public void j(boolean z, boolean z2) {
        if (this.bGG != null) {
            this.bGG.j(z, z2);
        }
    }

    public void di(boolean z) {
        if (this.bGG != null) {
            this.bGG.dy(z);
        }
    }

    private void Ws() {
        this.bGH = (GifView) this.bGh.findViewById(u.g.gif_real_time);
        this.bGI = (TbImageView) this.bGh.findViewById(u.g.tbimg_real_time);
        this.bGH.setLayerType(1, null);
        this.bGI.setLayerType(1, null);
    }

    public void Wt() {
        com.baidu.tbadk.core.data.ar realTimeData;
        if (this.bGh.VU().aGX() != null && this.bGh.VU().aGX().getRealTimeData() != null && (realTimeData = this.bGh.VU().aGX().getRealTimeData()) != null && !StringUtils.isNull(realTimeData.getIcon()) && this.bGK == null) {
            this.bGK = new com.baidu.tieba.frs.view.t(realTimeData, this, this.bGh.getPageContext());
            this.bGK.show();
        }
    }

    public com.baidu.tieba.frs.view.t Wu() {
        return this.bGK;
    }

    private void Wv() {
        if (this.bGy == null && this.bGh != null && this.bGh.Wi() != null) {
            this.bGy = this.bGh.Wi().at(this.bGh.getPageContext().getPageActivity());
            this.bGy.setVisibility(8);
            this.bGy.setBannerViewClickListener(this.bGR);
            this.bGy.setBannerViewEvent(new bz(this));
        }
    }

    private void aI(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.bGh.getForumId(), this.bGh.getForumName(), null);
            a.bR("obj_url", str2);
            a.save();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Ww() {
        if (this.bGA != null) {
            String value = this.bGA.getValue();
            String oA = this.bGA.oA();
            if (this.bGA.oD() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.bGh.getPageContext().getPageActivity(), value, false, "frs_banner")));
                aI(oA, value);
            } else if (this.bGA.oD() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.bGh.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.bGh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            aI(oA, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bGA.oD() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.Zm != UtilHelper.NativePageType.NONE) {
                    switch (Xf()[isNativeAddress.Zm.ordinal()]) {
                        case 2:
                            this.bGh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bGh.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case 3:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.bGh.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.bGh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            break;
                    }
                } else {
                    com.baidu.tbadk.core.util.bi.us().c(this.bGh.getPageContext(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.bGh.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                aI(oA, value);
            } else if (this.bGA.oD() == 4) {
                this.bGh.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bGh.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                aI(oA, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Wx() {
        return this.bGt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Wy() {
        return this.bGr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Wz() {
        return this.bGj;
    }

    public void g(NoNetworkView.a aVar) {
        this.bCV = aVar;
        if (this.bmB != null) {
            this.bmB.a(this.bCV);
        }
    }

    public void dj(boolean z) {
        this.bGg = z;
        if (z) {
            if (this.bGG != null) {
                this.bGG.Yt();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bGo.getAdapter()).notifyDataSetChanged();
        if (this.bGG != null) {
            this.bGG.Yu();
        }
    }

    public void dk(boolean z) {
        if (this.bGG != null) {
            if (z) {
                j(true, true);
            } else {
                j(true, false);
            }
        }
    }

    public void dl(boolean z) {
        if (this.bGG != null) {
            if (z) {
                j(false, true);
            } else {
                j(false, false);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.be beVar, boolean z) {
        String string = this.bGh.getPageContext().getPageActivity().getString(u.j.view);
        String string2 = this.bGh.getPageContext().getPageActivity().getString(u.j.view_host);
        String string3 = this.bGh.getPageContext().getPageActivity().getString(u.j.view_reverse);
        this.bGu = new com.baidu.tbadk.core.dialog.c(this.bGh.getPageContext().getPageActivity());
        this.bGu.bP(u.j.operation);
        if (z) {
            this.bGu.a(new String[]{string, string3}, this.bGx);
        } else {
            this.bGu.a(new String[]{string, string2, string3}, this.bGx);
        }
        this.bGu.d(this.bGh.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bGo instanceof BdExpandListView) {
            this.bGo.setPersonListRefreshListener(aVar);
        }
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(t.d dVar) {
        this.mPullView.a(dVar);
    }

    public void a(t.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bGo.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bGp.a(wVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bGp.a(xVar);
    }

    public void setForumName(String str) {
        this.bGp.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bGx = bVar;
    }

    public void WA() {
        if (this.bGu != null) {
            this.bGu.rV();
        }
    }

    public void onDestroy() {
        this.bGp.onDestory();
        this.bGo.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m10getInst().handler.removeCallbacks(this.bGS);
        if (this.bwO != null) {
            this.bwO.onDestroy();
        }
        this.bGJ.clear();
        if (this.bGF != null) {
            this.bGF.Yx();
        }
        if (this.bGN != null) {
            this.bGN.setBackgroundDrawable(null);
        }
    }

    public boolean WB() {
        if (this.bGF != null) {
            return this.bGF.WB();
        }
        return false;
    }

    public boolean VV() {
        return this.bGg;
    }

    public void Mb() {
        this.bGo.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bGh.getActivity().getString(u.j.forum));
        com.baidu.tbadk.core.l.nL().cc(str);
    }

    public void WC() {
        if (this.bGp != null) {
            this.bGp.notifyDataSetChanged();
        }
    }

    private void WD() {
        if (this.bGq == null) {
            String[] strArr = {this.bGh.getPageContext().getPageActivity().getString(u.j.take_photo), this.bGh.getPageContext().getPageActivity().getString(u.j.album)};
            this.bGq = new com.baidu.tbadk.core.dialog.c(this.bGh.getPageContext().getPageActivity());
            this.bGq.cA(this.bGh.getPageContext().getPageActivity().getString(u.j.operation));
            this.bGq.a(strArr, new ca(this));
            this.bGq.d(this.bGh.getPageContext());
        }
    }

    public void WE() {
        WD();
        if (this.bGq != null) {
            this.bGq.rV();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, int i, com.baidu.tieba.tbadkCore.p pVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cc ccVar = new cc();
            arrayList = new ArrayList<>();
            arrayList.add(ccVar);
            if (this.bGh != null && this.bGh.VY() != null && this.bGh.VY().ZZ() == 0) {
                ccVar.hr(this.bGh.VY().Xi());
            }
        }
        this.bGp.a(arrayList, pVar);
        if (this.aJx != null) {
            this.aJx.a(this.aLr, this.aLq, this.aLm, true);
        }
    }

    public BdTypeListView getListView() {
        return this.bGo;
    }

    public void WF() {
        this.bGp.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData == null || forumData.getFrsBannerData() == null) {
            WG();
        } else if (!forumData.getFrsBannerData().isValid()) {
            WG();
        } else {
            this.bGA = forumData.getFrsBannerData();
            if (!this.bGB) {
                Wv();
                this.bGo.removeHeaderView(this.bGy);
                if (this.bGA.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bGh.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bGh.Wi() != null) {
                this.bGh.Wi().b(this.bGo, this.bGy);
            }
            this.bGy.reset();
            if (this.bGA.getType() == 1 && !TextUtils.isEmpty(this.bGA.oE())) {
                this.bGy.c(this.bGh.getPageContext(), this.bGA.oE());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jd(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.bGh.getForumId(), this.bGh.getForumName(), null);
            a.bR("obj_url", this.bGA.oE());
            a.save();
        }
    }

    public void WG() {
        if (this.bGy != null) {
            this.bGB = false;
            this.bGo.removeHeaderView(this.bGy);
            this.bGy = null;
        }
    }

    public void onPause() {
        if (this.bGF != null) {
            this.bGF.Yy();
        }
    }

    public void release() {
        if (this.bmB != null && this.bCV != null) {
            this.bmB.b(this.bCV);
        }
    }

    public void WH() {
        this.bGs.setVisibility(8);
    }

    public void a(cx cxVar) {
        long j;
        if (!FrsActivityStatic.bEX || cxVar == null) {
            this.bGs.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bEY) {
            j = cxVar.Xl() - cxVar.Xm();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xK().yf()) {
                j -= cxVar.Xn();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bGt.getVisibility() == 0) {
            this.bGs.setVisibility(0);
            if (j < 10) {
                this.bGs.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.av.k(this.bGs, u.f.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bGs.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.av.k(this.bGs, u.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bGs.setText("   ");
                com.baidu.tbadk.core.util.av.k(this.bGs, u.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bGs.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.bGI != null) {
            this.bGI.invalidate();
        }
        if (this.bGp != null) {
            this.bGp.Ym();
            this.bGp.notifyDataSetChanged();
        }
        this.bGh.VG();
        this.bGh.getLayoutMode().af(i == 1);
        this.bGh.getLayoutMode().w(this.bGi);
        if (this.bGi != null) {
            com.baidu.tbadk.core.util.av.e(this.bGi, u.d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bGh.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.av.cB(u.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.av.e(this.bGz, u.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.av.l(this.mNavigationBar.getBottomLine(), u.d.cp_bg_line_b);
        }
        if (this.bmB != null) {
            this.bmB.onChangeSkinType(this.bGh.getPageContext(), i);
        }
        if (this.bGy != null) {
            this.bGy.kT();
        }
        if (this.bjZ != null) {
            this.bjZ.cT(i);
        }
        dp(false);
        if (this.bGG != null) {
            this.bGG.onChangeSkinType(i);
        }
        if (this.bGF != null) {
            this.bGF.onChangeSkinType(i);
        }
        if (this.bGN != null) {
            UtilHelper.setStatusBarBackground(this.bGN, i);
        }
    }

    public void jA() {
        this.bGo.jA();
    }

    public void WI() {
        this.bGo.l(2000L);
    }

    public int WJ() {
        return 0;
    }

    public boolean WK() {
        return this.bGk != null && this.bGn.getVisibility() == 0;
    }

    public void WL() {
        if (this.bGk != null) {
            this.bGl.setVisibility(0);
            this.bGn.setVisibility(8);
            this.bGm.setVisibility(0);
            TbadkCoreApplication.m10getInst().handler.postDelayed(this.bGS, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bk bkVar) {
        if (this.bGk == null) {
            this.bGk = (ViewStub) this.bGh.findViewById(u.g.yule_game_egg_view_stub);
            this.bGk.setVisibility(0);
            this.bGl = (FrameLayout) this.bGh.findViewById(u.g.game_activity_egg_layout);
            this.bGm = (TbImageView) this.bGh.findViewById(u.g.game_activity_egg);
            this.bGn = (TbImageView) this.bGh.findViewById(u.g.game_activity_egg_s);
            this.bGm.setDefaultBgResource(u.d.common_color_10022);
            this.bGm.setDefaultResource(0);
            this.bGn.setDefaultBgResource(u.d.common_color_10022);
            this.bGn.setDefaultResource(0);
            this.bGl.setOnClickListener(this.bGw);
        }
        this.bGl.setVisibility(0);
        String rI = bkVar.rI();
        String rJ = bkVar.rJ();
        this.bGm.c(rI, 10, false);
        this.bGn.c(rJ, 10, false);
        TbadkCoreApplication.m10getInst().handler.postDelayed(this.bGS, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void WM() {
        if (this.bGk != null) {
            this.bGl.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.ai WN() {
        return this.bGp;
    }

    public View getRootView() {
        return this.bGi;
    }

    public View WO() {
        return this.bGC;
    }

    public void dm(boolean z) {
        this.bGr.setVisibility(z ? 0 : 8);
    }

    public void WP() {
        if (com.baidu.tbadk.performanceLog.aa.EV().EW()) {
            int lastVisiblePosition = this.bGo.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bGo.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof ce) {
                        ce ceVar = (ce) childAt.getTag();
                        if (ceVar.bHl != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = ceVar.bHl.getPerfLog();
                            perfLog.eQ(1000);
                            perfLog.azb = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                ceVar.bHl.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getContext())) {
                                }
                            }
                            ceVar.bHl.uS();
                        }
                        if (ceVar.bHj != null && (ceVar.bHj instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = ceVar.bHj;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eQ(1000);
                                    perfLog2.azb = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.uS();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bh) {
                        bh bhVar = (bh) childAt.getTag();
                        if (bhVar.bFu != null) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = bhVar.bFu.getPerfLog();
                            perfLog3.eQ(1000);
                            perfLog3.azb = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bhVar.bFu.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getContext())) {
                                }
                            }
                            bhVar.bFu.uS();
                        }
                        if (bhVar.bFz != null && (bhVar.bFz instanceof TbImageView)) {
                            TbImageView tbImageView2 = bhVar.bFz;
                            com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eQ(1000);
                            perfLog4.azb = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getContext())) {
                                }
                            }
                            tbImageView2.uS();
                        }
                    }
                    if (childAt.getTag() instanceof bp) {
                        bp bpVar = (bp) childAt.getTag();
                        if (bpVar.bGe != null && bpVar.bGe.aPP != null && (bpVar.bGe.aPP instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog5 = bpVar.bGe.aPP.getPerfLog();
                            perfLog5.eQ(1000);
                            perfLog5.azb = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                bpVar.bGe.aPP.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getContext())) {
                                }
                            }
                            bpVar.bGe.aPP.uS();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (bpVar.aPK != null) {
                            arrayList.add(bpVar.aPK);
                        }
                        if (bpVar.aPL != null) {
                            arrayList.add(bpVar.aPL);
                        }
                        if (bpVar.aPM != null) {
                            arrayList.add(bpVar.aPM);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eQ(1000);
                                perfLog6.azb = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getContext())) {
                                    }
                                }
                                tbImageView3.uS();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar WQ() {
        return this.mNavigationBar;
    }

    public void WR() {
        this.mHasMore = true;
        this.bGo.setNextPage(this.bjZ);
        this.bjZ.vh();
    }

    public void WS() {
        this.mHasMore = false;
        if (this.bGD > 0) {
            this.bjZ.cU(this.bGD);
        }
        this.bGo.setNextPage(this.bjZ);
        this.bjZ.vi();
        this.bjZ.setText(this.bGh.getResources().getString(u.j.list_no_more));
    }

    public void WT() {
        this.mHasMore = false;
        this.bGo.setNextPage(null);
        this.bjZ.vk();
    }

    public void WU() {
        this.bjZ.vk();
    }

    public boolean WV() {
        return this.bjZ.getView().getParent() != null && this.mHasMore;
    }

    public void hp(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("frs_login_tip", true)) {
                if (this.bwO == null) {
                    this.bwO = new CommonTipView(this.bGh.getActivity());
                }
                this.bwO.setText(u.j.frs_login_tip);
                this.bwO.a((FrameLayout) WO(), TbadkCoreApplication.m10getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("frs_login_tip", false);
            }
        }
    }

    public TbImageView WW() {
        return this.bGI;
    }

    public GifView WX() {
        return this.bGH;
    }

    public void dn(boolean z) {
        if (this.aJx != null) {
            if (z) {
                this.aJx.aWB();
            } else {
                this.aJx.a(this.aLr, this.aLq, this.aLm, true);
            }
        }
    }

    public void aa(int i, int i2) {
        if (this.aJx != null) {
            this.aJx.a(i, i2, this.aLm, 1);
        }
    }

    public void ab(int i, int i2) {
        this.aLr = i;
        this.aLq = i2;
    }

    /* renamed from: do  reason: not valid java name */
    public void m16do(boolean z) {
        this.aLm = z;
    }

    public void WY() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setmBackImageViewBg(u.f.btn_sml_back_selector_s, u.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.av.k(this.mBackImageView, u.f.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.av.k(this.bGt, u.f.frs_star_navigation_bg);
        }
        int i = u.f.btn_sml_more_selector_s;
        this.bGM = i;
        this.bGL = i;
        com.baidu.tbadk.core.util.av.b(this.bGt, this.bGL, this.bGM);
    }

    public void WZ() {
        dp(true);
    }

    private void Xa() {
        float f;
        if (this.mNavigationBar != null && this.mNavigationBar.mTextTitle != null && this.mNavigationBar.getBarBgView() != null && this.bGt != null && this.mBackImageView != null) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            this.mNavigationBar.mTextTitle.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.bGt.setAlpha(f);
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void dp(boolean z) {
        boolean h = com.baidu.tieba.frs.j.p.h(this.bGh.VU());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bGQ) {
                    this.bGQ = true;
                    if (h) {
                        com.baidu.tbadk.core.util.av.b(this.mBackImageView, u.f.btn_sml_back_selector_s, u.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.av.b(this.bGt, u.f.btn_sml_more_selector_s, u.f.btn_sml_more_selector_s);
                        com.baidu.tbadk.core.util.av.k(this.mBackImageView, u.f.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.av.k(this.bGt, u.f.frs_star_navigation_bg);
                    } else {
                        com.baidu.tbadk.core.util.av.b(this.mBackImageView, u.f.btn_sml_back_selector_s, u.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.av.b(this.bGt, u.f.btn_sml_more_selector_s, u.f.btn_sml_more_selector_s);
                    }
                }
            } else if (!z || this.bGQ) {
                this.bGQ = false;
                if (h) {
                    com.baidu.tbadk.core.util.av.b(this.mBackImageView, u.f.icon_return_bg_s, u.f.icon_return_bg);
                    com.baidu.tbadk.core.util.av.b(this.bGt, u.f.btn_more_selector_s, u.f.btn_more_selector);
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bGt.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.av.b(this.mBackImageView, u.f.icon_return_bg_s, u.f.icon_return_bg);
                    com.baidu.tbadk.core.util.av.b(this.bGt, this.bGL, this.bGM);
                }
            }
        }
        Xa();
    }

    public void Xb() {
        if (!this.bGo.bmA()) {
            this.bGo.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.w(this.bGh.getPageContext());
            this.mPullView.setTag(this.bGh.getUniqueId());
            this.bGo.setPullRefresh(this.mPullView);
        }
    }

    public void hq(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void Xc() {
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.sN().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", 0) < bGO && !com.baidu.tbadk.core.sharedPref.b.sN().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "forum_has_show_frequently_forum_tips" + this.mForumName, false)) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bGT, 2000L);
        }
    }

    public void Xd() {
        com.baidu.tbadk.core.sharedPref.b.sN().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", com.baidu.tbadk.core.sharedPref.b.sN().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", 0) + 1);
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "forum_has_show_frequently_forum_tips" + this.mForumName, true);
    }

    public void Xe() {
        if (this.Ff != null) {
            this.Ff.dismiss();
        }
    }
}
