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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.entelechy.b.a;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class bm {
    private static /* synthetic */ int[] bRU;
    private PbListView aMn;
    private com.baidu.tieba.play.k aMo;
    private com.baidu.tbadk.core.data.u anD;
    private CommonTipView bIe;
    private View bRA;
    private View bRC;
    private View bRE;
    private com.baidu.tieba.frs.entelechy.b.e bRF;
    private com.baidu.tieba.frs.entelechy.b.c bRG;
    private GifView bRH;
    private TbImageView bRI;
    private HashSet<String> bRJ;
    private com.baidu.tieba.frs.view.t bRK;
    private int bRL;
    private int bRM;
    private ObservedChangeLinearLayout bRO;
    private FrsActivity bRi;
    private View bRk;
    private ViewStub bRl;
    private com.baidu.tieba.frs.entelechy.a.af bRq;
    private View bRs;
    private View.OnClickListener bRx;
    private NoNetworkView bmi;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ab mPullView;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    public static int bRN = 3;
    private boolean bRh = false;
    private NoPressedRelativeLayout bRj = null;
    private FrameLayout bRm = null;
    private TbImageView bRn = null;
    private TbImageView bRo = null;
    private BdExpandListView bRp = null;
    private com.baidu.tbadk.core.dialog.c bRr = null;
    private TextView bRt = null;
    private ImageView bRu = null;
    com.baidu.tbadk.core.dialog.c bRv = null;
    Animation bRw = null;
    private c.b bRy = null;
    private NoNetworkView.a aRn = null;
    private BannerView bRz = null;
    private boolean bRB = false;
    private boolean mHasMore = true;
    private int bRD = 0;
    private boolean aMq = false;
    private int aMt = 0;
    private int aMs = 0;
    private View bJw = null;
    private boolean bRP = true;
    BannerView.a bRQ = new bn(this);
    private Runnable bRR = new bo(this);
    private com.baidu.adp.lib.guide.d Hs = null;
    private Handler mHandler = null;
    private Runnable bRS = new bp(this);
    private Runnable bRT = new br(this);

    static /* synthetic */ int[] acp() {
        int[] iArr = bRU;
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
            bRU = iArr;
        }
        return iArr;
    }

    public ObservedChangeLinearLayout aby() {
        return this.bRO;
    }

    public View abz() {
        return this.bJw;
    }

    public bm(FrsActivity frsActivity, View.OnClickListener onClickListener, a aVar) {
        this.bRi = null;
        this.bRx = null;
        this.bRi = frsActivity;
        this.bRx = onClickListener;
        a(aVar);
        this.bRJ = new HashSet<>();
    }

    private void a(a aVar) {
        this.bRj = (NoPressedRelativeLayout) this.bRi.findViewById(r.g.frs);
        this.mNavigationBar = (NavigationBar) this.bRi.findViewById(r.g.view_navigation_bar);
        this.bRA = this.bRi.findViewById(r.g.frs_navi_line);
        b acU = aVar.acU();
        if (acU != null) {
            acU.ac(this.bRA);
        }
        this.bRk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bRk.setOnClickListener(this.bRx);
        this.mBackImageView = (ImageView) this.bRk.findViewById(r.g.widget_navi_back_button);
        this.bRC = this.bRi.findViewById(r.g.frs_list_content);
        this.bRs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bRu = (ImageView) this.bRs.findViewById(r.g.frs_top_more);
        this.bRu.setContentDescription(this.bRi.getResources().getString(r.j.more));
        this.bRL = r.f.btn_more_selector_s;
        this.bRM = r.f.btn_more_selector;
        dO(false);
        this.bRu.setOnClickListener(this.bRx);
        this.bRt = (TextView) this.bRs.findViewById(r.g.frs_more_mes_text);
        this.bRp = (BdExpandListView) this.bRi.findViewById(r.g.frs_lv_thread);
        this.bRj.setBottomOrderView(this.bRp);
        this.bRp.setOnTouchListener(this.bRi.aJD);
        this.bRp.setDivider(null);
        if (acU != null) {
            this.bRE = acU.a(this.bRi.getActivity(), this.bRp);
        }
        this.bRp.setDividerHeight(0);
        this.bRp.setRecyclerListener(new bs(this));
        this.aMn = new PbListView(this.bRi.getPageContext().getPageActivity());
        this.aMn.kk();
        this.aMn.dg(r.d.cp_bg_line_c);
        this.bRp.setOnSrollToBottomListener(this.bRi);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ab(new bt(this)));
        this.bRq = aVar.a(this.bRi, this.bRp, com.baidu.tbadk.core.util.ba.vy().vA());
        dI(false);
        this.bmi = (NoNetworkView) this.bRi.findViewById(r.g.view_no_network);
        abB();
        this.bRF = aVar.c(this.bRi, this.bRj);
        this.bRG = aVar.b(this.bRi, this.bRj);
        this.bRO = (ObservedChangeLinearLayout) this.bRi.findViewById(r.g.navigation_bar_wrapperLayout);
        this.bRO.setOnSizeChangeListener(new bu(this));
        this.bJw = this.bRi.findViewById(r.g.statebar_view);
        this.aMo = new com.baidu.tieba.play.k(this.bRi.getPageContext(), this.bRp);
    }

    public com.baidu.tieba.play.k JP() {
        return this.aMo;
    }

    public com.baidu.tieba.frs.entelechy.b.c abA() {
        return this.bRG;
    }

    public void dG(boolean z) {
        if (this.bRF != null) {
            this.bRF.dG(z);
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.bRG != null) {
            this.bRG.n(z, z2);
        }
    }

    public void dH(boolean z) {
        if (this.bRG != null) {
            this.bRG.dV(z);
        }
    }

    private void abB() {
        this.bRH = (GifView) this.bRi.findViewById(r.g.gif_real_time);
        this.bRI = (TbImageView) this.bRi.findViewById(r.g.tbimg_real_time);
        this.bRH.setLayerType(1, null);
        this.bRI.setLayerType(1, null);
    }

    public void abC() {
        com.baidu.tbadk.core.data.av realTimeData;
        if (this.bRi.abe().aMr() != null && this.bRi.abe().aMr().getRealTimeData() != null && (realTimeData = this.bRi.abe().aMr().getRealTimeData()) != null && !StringUtils.isNull(realTimeData.getIcon()) && this.bRK == null) {
            this.bRK = new com.baidu.tieba.frs.view.t(realTimeData, this, this.bRi.getPageContext());
            this.bRK.show();
        }
    }

    public com.baidu.tieba.frs.view.t abD() {
        return this.bRK;
    }

    private void a(com.baidu.tbadk.core.data.u uVar) {
        if (this.bRz == null && this.bRi != null && this.bRi.abr() != null) {
            this.bRz = new BannerView(this.bRi.getPageContext().getPageActivity());
            this.bRz.setVisibility(8);
            this.bRz.setBannerViewClickListener(this.bRQ);
            this.bRz.setBannerData(uVar);
            this.bRz.setBannerViewEvent(new bv(this));
        }
    }

    private void aK(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.bRi.getForumId(), this.bRi.getForumName(), null);
            a.bT("obj_url", str2);
            a.save();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void abE() {
        if (this.anD != null) {
            String value = this.anD.getValue();
            String px = this.anD.px();
            if (this.anD.pR() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.bRi.getPageContext().getPageActivity(), value, false, "frs_banner")));
                aK(px, value);
            } else if (this.anD.pR() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.bRi.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.bRi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            aK(px, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.anD.pR() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aco != UtilHelper.NativePageType.NONE) {
                    switch (acp()[isNativeAddress.aco.ordinal()]) {
                        case 2:
                            this.bRi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bRi.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case 3:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.bRi.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.bRi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            break;
                    }
                } else {
                    com.baidu.tbadk.core.util.bh.vL().c(this.bRi.getPageContext(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.bRi.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                aK(px, value);
            } else if (this.anD.pR() == 4) {
                this.bRi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bRi.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                aK(px, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View abF() {
        return this.bRu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View abG() {
        return this.bRs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View abH() {
        return this.bRk;
    }

    public void g(NoNetworkView.a aVar) {
        this.aRn = aVar;
        if (this.bmi != null) {
            this.bmi.a(this.aRn);
        }
    }

    public void dI(boolean z) {
        this.bRh = z;
        if (z) {
            if (this.bRG != null) {
                this.bRG.adt();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bRp.getAdapter()).notifyDataSetChanged();
        if (this.bRG != null) {
            this.bRG.adu();
        }
    }

    public void dJ(boolean z) {
        if (this.bRG != null) {
            if (z) {
                n(true, true);
            } else {
                n(true, false);
            }
        }
    }

    public void dK(boolean z) {
        if (this.bRG != null) {
            if (z) {
                n(false, true);
            } else {
                n(false, false);
            }
        }
    }

    public void c(com.baidu.tbadk.core.data.bi biVar, boolean z) {
        String string = this.bRi.getPageContext().getPageActivity().getString(r.j.view);
        String string2 = this.bRi.getPageContext().getPageActivity().getString(r.j.view_host);
        String string3 = this.bRi.getPageContext().getPageActivity().getString(r.j.view_reverse);
        this.bRv = new com.baidu.tbadk.core.dialog.c(this.bRi.getPageContext().getPageActivity());
        this.bRv.cc(r.j.operation);
        if (z) {
            this.bRv.a(new String[]{string, string3}, this.bRy);
        } else {
            this.bRv.a(new String[]{string, string2, string3}, this.bRy);
        }
        this.bRv.d(this.bRi.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bRp instanceof BdExpandListView) {
            this.bRp.setPersonListRefreshListener(aVar);
        }
    }

    public void a(y.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(y.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(y.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bRp.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bRq.a(wVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bRq.a(xVar);
    }

    public void setForumName(String str) {
        this.bRq.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bRy = bVar;
    }

    public void abI() {
        if (this.bRv != null) {
            this.bRv.tp();
        }
    }

    public void onDestroy() {
        if (this.aMo != null) {
            this.aMo.destroy();
        }
        this.bRq.onDestory();
        this.bRp.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bRR);
        if (this.bIe != null) {
            this.bIe.onDestroy();
        }
        this.bRJ.clear();
        if (this.bRF != null) {
            this.bRF.adx();
        }
        if (this.bJw != null) {
            this.bJw.setBackgroundDrawable(null);
        }
    }

    public boolean abJ() {
        if (this.bRF != null) {
            return this.bRF.abJ();
        }
        return false;
    }

    public boolean abf() {
        return this.bRh;
    }

    public void JK() {
        this.bRp.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bRi.getActivity().getString(r.j.forum));
        com.baidu.tbadk.core.l.oH().cd(str);
    }

    public void abK() {
        if (this.bRq != null) {
            this.bRq.notifyDataSetChanged();
        }
    }

    private void abL() {
        if (this.bRr == null) {
            String[] strArr = {this.bRi.getPageContext().getPageActivity().getString(r.j.take_photo), this.bRi.getPageContext().getPageActivity().getString(r.j.album)};
            this.bRr = new com.baidu.tbadk.core.dialog.c(this.bRi.getPageContext().getPageActivity());
            this.bRr.cE(this.bRi.getPageContext().getPageActivity().getString(r.j.operation));
            this.bRr.a(strArr, new bw(this));
            this.bRr.d(this.bRi.getPageContext());
        }
    }

    public void abM() {
        abL();
        if (this.bRr != null) {
            this.bRr.tp();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, int i, com.baidu.tieba.tbadkCore.p pVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            by byVar = new by();
            arrayList = new ArrayList<>();
            arrayList.add(byVar);
            if (this.bRi != null && this.bRi.abi() != null && this.bRi.abi().aeY() == 0) {
                byVar.hY(this.bRi.abi().acs());
            }
        }
        this.bRq.a(arrayList, pVar);
        if (this.aMo != null) {
            this.aMo.a(this.aMt, this.aMs, this.aMq, true);
        }
    }

    public BdTypeListView abN() {
        return this.bRp;
    }

    public void abO() {
        this.bRq.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData == null || forumData.getFrsBannerData() == null) {
            abP();
        } else if (!forumData.getFrsBannerData().isValid()) {
            abP();
        } else {
            this.anD = forumData.getFrsBannerData();
            if (!this.bRB) {
                a(this.anD);
                this.bRp.removeHeaderView(this.bRz);
                if (this.anD.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bRi.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bRi.abr() != null) {
                this.bRi.abr().b(this.bRp, this.bRz);
            }
            this.bRz.reset();
            if (this.anD.getType() == 1 && !TextUtils.isEmpty(this.anD.pS())) {
                this.bRz.c(this.bRi.getPageContext(), this.anD.pS());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0079a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.bRi.getForumId(), this.bRi.getForumName(), null);
            a.bT("obj_url", this.anD.pS());
            a.save();
        }
    }

    public void abP() {
        if (this.bRz != null) {
            this.bRB = false;
            this.bRp.removeHeaderView(this.bRz);
            this.bRz = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER, false));
        }
    }

    public void onPause() {
        if (this.bRF != null) {
            this.bRF.ady();
        }
    }

    public void release() {
        if (this.bmi != null && this.aRn != null) {
            this.bmi.b(this.aRn);
        }
    }

    public void abQ() {
        this.bRt.setVisibility(8);
    }

    public void a(ct ctVar) {
        long j;
        if (!FrsActivityStatic.bQu || ctVar == null) {
            this.bRt.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bQv) {
            j = ctVar.acv() - ctVar.acw();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.za().zv()) {
                j -= ctVar.acx();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bRu.getVisibility() == 0) {
            this.bRt.setVisibility(0);
            if (j < 10) {
                this.bRt.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.av.k(this.bRt, r.f.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bRt.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.av.k(this.bRt, r.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bRt.setText("   ");
                com.baidu.tbadk.core.util.av.k(this.bRt, r.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bRt.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.bRI != null) {
            this.bRI.invalidate();
        }
        if (this.bRq != null) {
            this.bRq.adm();
            this.bRq.notifyDataSetChanged();
        }
        this.bRi.aaP();
        this.bRi.getLayoutMode().ah(i == 1);
        this.bRi.getLayoutMode().x(this.bRj);
        if (this.bRj != null) {
            com.baidu.tbadk.core.util.av.e(this.bRj, r.d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bRi.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.av.cO(r.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.av.e(this.bRA, r.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.av.l(this.mNavigationBar.getBottomLine(), r.d.cp_bg_line_b);
        }
        if (this.bmi != null) {
            this.bmi.onChangeSkinType(this.bRi.getPageContext(), i);
        }
        if (this.bRz != null) {
            this.bRz.lO();
        }
        if (this.aMn != null) {
            this.aMn.dh(i);
        }
        dO(false);
        if (this.bRG != null) {
            this.bRG.onChangeSkinType(i);
        }
        if (this.bRF != null) {
            this.bRF.onChangeSkinType(i);
        }
        if (this.bJw != null) {
            UtilHelper.setStatusBarBackground(this.bJw, i);
        }
        if (this.aMo != null) {
            this.aMo.a(this.aMt, this.aMs, this.aMq, true);
        }
    }

    public void kv() {
        this.bRp.kv();
    }

    public void abR() {
        this.bRp.l(2000L);
    }

    public int abS() {
        return 0;
    }

    public boolean abT() {
        return this.bRl != null && this.bRo.getVisibility() == 0;
    }

    public void abU() {
        if (this.bRl != null) {
            this.bRm.setVisibility(0);
            this.bRo.setVisibility(8);
            this.bRn.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bRR, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bq bqVar) {
        if (this.bRl == null) {
            this.bRl = (ViewStub) this.bRi.findViewById(r.g.yule_game_egg_view_stub);
            this.bRl.setVisibility(0);
            this.bRm = (FrameLayout) this.bRi.findViewById(r.g.game_activity_egg_layout);
            this.bRn = (TbImageView) this.bRi.findViewById(r.g.game_activity_egg);
            this.bRo = (TbImageView) this.bRi.findViewById(r.g.game_activity_egg_s);
            this.bRn.setDefaultBgResource(r.d.common_color_10022);
            this.bRn.setDefaultResource(0);
            this.bRo.setDefaultBgResource(r.d.common_color_10022);
            this.bRo.setDefaultResource(0);
            this.bRm.setOnClickListener(this.bRx);
        }
        this.bRm.setVisibility(0);
        String tc = bqVar.tc();
        String td = bqVar.td();
        this.bRn.c(tc, 10, false);
        this.bRo.c(td, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bRR, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void abV() {
        if (this.bRl != null) {
            this.bRm.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.af abW() {
        return this.bRq;
    }

    public View getRootView() {
        return this.bRj;
    }

    public View abX() {
        return this.bRC;
    }

    public void dL(boolean z) {
        this.bRs.setVisibility(z ? 0 : 8);
    }

    public void abY() {
        if (com.baidu.tbadk.performanceLog.aa.Go().Gp()) {
            int lastVisiblePosition = this.bRp.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bRp.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof ca) {
                        ca caVar = (ca) childAt.getTag();
                        if (caVar.bSk != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = caVar.bSk.getPerfLog();
                            perfLog.fd(1000);
                            perfLog.aBL = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                caVar.bSk.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            caVar.bSk.wi();
                        }
                        if (caVar.bSi != null && (caVar.bSi instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = caVar.bSi;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.fd(1000);
                                    perfLog2.aBL = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.wi();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bl) {
                        bl blVar = (bl) childAt.getTag();
                        if (blVar.bRf != null && blVar.bRf.aVS != null && (blVar.bRf.aVS instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = blVar.bRf.aVS.getPerfLog();
                            perfLog3.fd(1000);
                            perfLog3.aBL = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                blVar.bRf.aVS.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            blVar.bRf.aVS.wi();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (blVar.aVN != null) {
                            arrayList.add(blVar.aVN);
                        }
                        if (blVar.aVO != null) {
                            arrayList.add(blVar.aVO);
                        }
                        if (blVar.aVP != null) {
                            arrayList.add(blVar.aVP);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView2 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                                perfLog4.fd(1000);
                                perfLog4.aBL = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr4 = new int[2];
                                    tbImageView2.getLocationOnScreen(iArr4);
                                    if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView2.wi();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar abZ() {
        return this.mNavigationBar;
    }

    public void aca() {
        this.mHasMore = true;
        this.bRp.setNextPage(this.aMn);
        this.aMn.wB();
    }

    public void acb() {
        this.mHasMore = false;
        if (this.bRD > 0) {
            this.aMn.di(this.bRD);
        }
        this.bRp.setNextPage(this.aMn);
        this.aMn.wC();
        this.aMn.setText(this.bRi.getResources().getString(r.j.list_no_more));
    }

    public void acc() {
        this.mHasMore = false;
        this.bRp.setNextPage(null);
        this.aMn.wE();
    }

    public void acd() {
        this.aMn.wE();
    }

    public boolean ace() {
        return this.aMn.getView().getParent() != null && this.mHasMore;
    }

    public void hW(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("frs_login_tip", true)) {
                if (this.bIe == null) {
                    this.bIe = new CommonTipView(this.bRi.getActivity());
                }
                this.bIe.setText(r.j.frs_login_tip);
                this.bIe.a((FrameLayout) abX(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("frs_login_tip", false);
            }
        }
    }

    public TbImageView acf() {
        return this.bRI;
    }

    public GifView acg() {
        return this.bRH;
    }

    public void dM(boolean z) {
        if (this.aMo != null) {
            if (z) {
                this.aMo.bap();
            } else {
                this.aMo.a(this.aMt, this.aMs, this.aMq, true);
            }
        }
    }

    public void ag(int i, int i2) {
        if (this.aMo != null) {
            this.aMo.a(i, i2, this.aMq, 1);
        }
    }

    public void ah(int i, int i2) {
        this.aMt = i;
        this.aMs = i2;
    }

    public void dN(boolean z) {
        this.aMq = z;
    }

    public void ach() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setmBackImageViewBg(r.f.btn_sml_back_selector_s, r.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.av.k(this.mBackImageView, r.f.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.av.k(this.bRu, r.f.frs_star_navigation_bg);
        }
        int i = r.f.btn_sml_more_selector_s;
        this.bRM = i;
        this.bRL = i;
        com.baidu.tbadk.core.util.av.b(this.bRu, this.bRL, this.bRM);
    }

    public void aci() {
        dO(true);
    }

    private void acj() {
        float f;
        if (this.mNavigationBar != null && this.mNavigationBar.mTextTitle != null && this.mNavigationBar.getBarBgView() != null && this.bRu != null && this.mBackImageView != null) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            this.mNavigationBar.mTextTitle.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.bRu.setAlpha(f);
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void dO(boolean z) {
        boolean j = com.baidu.tieba.frs.i.p.j(this.bRi.abe());
        boolean i = com.baidu.tieba.frs.i.p.i(this.bRi.abe());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bRP) {
                    this.bRP = true;
                    if (j && !i) {
                        com.baidu.tbadk.core.util.av.b(this.mBackImageView, r.f.btn_sml_back_selector_s, r.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.av.b(this.bRu, r.f.btn_sml_more_selector_s, r.f.btn_sml_more_selector_s);
                        com.baidu.tbadk.core.util.av.k(this.mBackImageView, r.f.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.av.k(this.bRu, r.f.frs_star_navigation_bg);
                    } else {
                        com.baidu.tbadk.core.util.av.b(this.mBackImageView, r.f.btn_sml_back_selector_s, r.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.av.b(this.bRu, r.f.btn_sml_more_selector_s, r.f.btn_sml_more_selector_s);
                    }
                }
            } else if (!z || this.bRP) {
                this.bRP = false;
                if (j) {
                    com.baidu.tbadk.core.util.av.b(this.mBackImageView, r.f.icon_return_bg_s, r.f.icon_return_bg);
                    com.baidu.tbadk.core.util.av.b(this.bRu, r.f.btn_more_selector_s, r.f.btn_more_selector);
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bRu.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.av.b(this.mBackImageView, r.f.icon_return_bg_s, r.f.icon_return_bg);
                    com.baidu.tbadk.core.util.av.b(this.bRu, this.bRL, this.bRM);
                }
            }
        }
        acj();
    }

    public void ack() {
        if (!this.bRp.bqN()) {
            this.bRp.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.ab(this.bRi.getPageContext());
            this.mPullView.setTag(this.bRi.getUniqueId());
            this.bRp.setPullRefresh(this.mPullView);
        }
    }

    public void acl() {
        this.bRp.setStarForum(false);
        this.bRp.setPullRefresh(null);
    }

    public void hX(int i) {
        if (abN() != null && abN().getChildAt(0) != null) {
            abN().setSelectionFromTop(abN().getFirstVisiblePosition(), abN().getChildAt(0).getTop() - i);
        }
    }

    public void acm() {
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.uh().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", 0) < bRN && !com.baidu.tbadk.core.sharedPref.b.uh().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "forum_has_show_frequently_forum_tips" + this.mForumName, false)) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bRS, 2000L);
        }
    }

    public void acn() {
        com.baidu.tbadk.core.sharedPref.b.uh().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", com.baidu.tbadk.core.sharedPref.b.uh().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", 0) + 1);
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "forum_has_show_frequently_forum_tips" + this.mForumName, true);
    }

    public void aco() {
        if (this.Hs != null) {
            this.Hs.dismiss();
        }
    }
}
