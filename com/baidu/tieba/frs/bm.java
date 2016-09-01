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
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.entelechy.b.a;
import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.t;
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
    private static /* synthetic */ int[] bSb;
    private com.baidu.tieba.play.i aNV;
    private com.baidu.tbadk.core.data.t anV;
    private CommonTipView bIc;
    private View.OnClickListener bRE;
    private View bRH;
    private View bRJ;
    private View bRL;
    private com.baidu.tieba.frs.entelechy.b.e bRM;
    private com.baidu.tieba.frs.entelechy.b.c bRN;
    private GifView bRO;
    private TbImageView bRP;
    private HashSet<String> bRQ;
    private com.baidu.tieba.frs.view.t bRR;
    private int bRS;
    private int bRT;
    private ObservedChangeLinearLayout bRV;
    private FrsActivity bRp;
    private View bRr;
    private ViewStub bRs;
    private com.baidu.tieba.frs.entelechy.a.af bRx;
    private View bRz;
    private NoNetworkView blV;
    private PbListView bvo;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mPullView;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    public static int bRU = 3;
    private boolean bRo = false;
    private NoPressedRelativeLayout bRq = null;
    private FrameLayout bRt = null;
    private TbImageView bRu = null;
    private TbImageView bRv = null;
    private BdExpandListView bRw = null;
    private com.baidu.tbadk.core.dialog.c bRy = null;
    private TextView bRA = null;
    private ImageView bRB = null;
    com.baidu.tbadk.core.dialog.c bRC = null;
    Animation bRD = null;
    private c.b bRF = null;
    private NoNetworkView.a bOz = null;
    private BannerView bRG = null;
    private boolean bRI = false;
    private boolean mHasMore = true;
    private int bRK = 0;
    private boolean aPX = false;
    private int aQc = 0;
    private int aQb = 0;
    private View bJv = null;
    private boolean bRW = true;
    BannerView.a bRX = new bn(this);
    private Runnable bRY = new bo(this);
    private com.baidu.adp.lib.guide.d Hs = null;
    private Handler mHandler = null;
    private Runnable bRZ = new bp(this);
    private Runnable bSa = new br(this);

    static /* synthetic */ int[] acc() {
        int[] iArr = bSb;
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
            bSb = iArr;
        }
        return iArr;
    }

    public ObservedChangeLinearLayout abm() {
        return this.bRV;
    }

    public View abn() {
        return this.bJv;
    }

    public bm(FrsActivity frsActivity, View.OnClickListener onClickListener, a aVar) {
        this.bRp = null;
        this.bRE = null;
        this.bRp = frsActivity;
        this.bRE = onClickListener;
        a(aVar);
        this.bRQ = new HashSet<>();
    }

    private void a(a aVar) {
        this.bRq = (NoPressedRelativeLayout) this.bRp.findViewById(t.g.frs);
        this.mNavigationBar = (NavigationBar) this.bRp.findViewById(t.g.view_navigation_bar);
        this.bRH = this.bRp.findViewById(t.g.frs_navi_line);
        b acI = aVar.acI();
        if (acI != null) {
            acI.ad(this.bRH);
        }
        this.bRr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bRr.setOnClickListener(this.bRE);
        this.mBackImageView = (ImageView) this.bRr.findViewById(t.g.widget_navi_back_button);
        this.bRJ = this.bRp.findViewById(t.g.frs_list_content);
        this.bRz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bRB = (ImageView) this.bRz.findViewById(t.g.frs_top_more);
        this.bRB.setContentDescription(this.bRp.getResources().getString(t.j.more));
        this.bRS = t.f.btn_more_selector_s;
        this.bRT = t.f.btn_more_selector;
        dN(false);
        this.bRB.setOnClickListener(this.bRE);
        this.bRA = (TextView) this.bRz.findViewById(t.g.frs_more_mes_text);
        this.bRw = (BdExpandListView) this.bRp.findViewById(t.g.frs_lv_thread);
        this.bRq.setBottomOrderView(this.bRw);
        this.bRw.setOnTouchListener(this.bRp.aKe);
        this.bRw.setDivider(null);
        if (acI != null) {
            this.bRL = acI.a(this.bRp.getActivity(), this.bRw);
        }
        this.bRw.setDividerHeight(0);
        this.bRw.setRecyclerListener(new bs(this));
        this.bvo = new PbListView(this.bRp.getPageContext().getPageActivity());
        this.bvo.kk();
        this.bvo.dg(t.d.cp_bg_line_c);
        this.bRw.setOnSrollToBottomListener(this.bRp);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ab(new bt(this)));
        this.bRx = aVar.a(this.bRp, this.bRw, com.baidu.tbadk.core.util.bb.vk().vm());
        dH(false);
        this.blV = (NoNetworkView) this.bRp.findViewById(t.g.view_no_network);
        abp();
        this.bRM = aVar.c(this.bRp, this.bRq);
        this.bRN = aVar.b(this.bRp, this.bRq);
        this.bRV = (ObservedChangeLinearLayout) this.bRp.findViewById(t.g.navigation_bar_wrapperLayout);
        this.bRV.setOnSizeChangeListener(new bu(this));
        this.bJv = this.bRp.findViewById(t.g.statebar_view);
        this.aNV = new com.baidu.tieba.play.i(this.bRp.getPageContext(), this.bRw);
    }

    public com.baidu.tieba.play.i Ki() {
        return this.aNV;
    }

    public com.baidu.tieba.frs.entelechy.b.c abo() {
        return this.bRN;
    }

    public void dF(boolean z) {
        if (this.bRM != null) {
            this.bRM.dF(z);
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.bRN != null) {
            this.bRN.n(z, z2);
        }
    }

    public void dG(boolean z) {
        if (this.bRN != null) {
            this.bRN.dU(z);
        }
    }

    private void abp() {
        this.bRO = (GifView) this.bRp.findViewById(t.g.gif_real_time);
        this.bRP = (TbImageView) this.bRp.findViewById(t.g.tbimg_real_time);
        this.bRO.setLayerType(1, null);
        this.bRP.setLayerType(1, null);
    }

    public void abq() {
        com.baidu.tbadk.core.data.at realTimeData;
        if (this.bRp.aaR().aLP() != null && this.bRp.aaR().aLP().getRealTimeData() != null && (realTimeData = this.bRp.aaR().aLP().getRealTimeData()) != null && !StringUtils.isNull(realTimeData.getIcon()) && this.bRR == null) {
            this.bRR = new com.baidu.tieba.frs.view.t(realTimeData, this, this.bRp.getPageContext());
            this.bRR.show();
        }
    }

    public com.baidu.tieba.frs.view.t abr() {
        return this.bRR;
    }

    private void a(com.baidu.tbadk.core.data.t tVar) {
        if (this.bRG == null && this.bRp != null && this.bRp.abf() != null) {
            this.bRG = new BannerView(this.bRp.getPageContext().getPageActivity());
            this.bRG.setVisibility(8);
            this.bRG.setBannerViewClickListener(this.bRX);
            this.bRG.setBannerData(tVar);
            this.bRG.setBannerViewEvent(new bv(this));
        }
    }

    private void aJ(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.bRp.getForumId(), this.bRp.getForumName(), null);
            a.bS("obj_url", str2);
            a.save();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void abs() {
        if (this.anV != null) {
            String value = this.anV.getValue();
            String pw = this.anV.pw();
            if (this.anV.pG() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.bRp.getPageContext().getPageActivity(), value, false, "frs_banner")));
                aJ(pw, value);
            } else if (this.anV.pG() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.bRp.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.bRp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            aJ(pw, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.anV.pG() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.acb != UtilHelper.NativePageType.NONE) {
                    switch (acc()[isNativeAddress.acb.ordinal()]) {
                        case 2:
                            this.bRp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bRp.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case 3:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.bRp.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.bRp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            break;
                    }
                } else {
                    com.baidu.tbadk.core.util.bi.vx().c(this.bRp.getPageContext(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.bRp.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                aJ(pw, value);
            } else if (this.anV.pG() == 4) {
                this.bRp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bRp.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                aJ(pw, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View abt() {
        return this.bRB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View abu() {
        return this.bRz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View abv() {
        return this.bRr;
    }

    public void g(NoNetworkView.a aVar) {
        this.bOz = aVar;
        if (this.blV != null) {
            this.blV.a(this.bOz);
        }
    }

    public void dH(boolean z) {
        this.bRo = z;
        if (z) {
            if (this.bRN != null) {
                this.bRN.adf();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bRw.getAdapter()).notifyDataSetChanged();
        if (this.bRN != null) {
            this.bRN.adg();
        }
    }

    public void dI(boolean z) {
        if (this.bRN != null) {
            if (z) {
                n(true, true);
            } else {
                n(true, false);
            }
        }
    }

    public void dJ(boolean z) {
        if (this.bRN != null) {
            if (z) {
                n(false, true);
            } else {
                n(false, false);
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.bg bgVar, boolean z) {
        String string = this.bRp.getPageContext().getPageActivity().getString(t.j.view);
        String string2 = this.bRp.getPageContext().getPageActivity().getString(t.j.view_host);
        String string3 = this.bRp.getPageContext().getPageActivity().getString(t.j.view_reverse);
        this.bRC = new com.baidu.tbadk.core.dialog.c(this.bRp.getPageContext().getPageActivity());
        this.bRC.cc(t.j.operation);
        if (z) {
            this.bRC.a(new String[]{string, string3}, this.bRF);
        } else {
            this.bRC.a(new String[]{string, string2, string3}, this.bRF);
        }
        this.bRC.d(this.bRp.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bRw instanceof BdExpandListView) {
            this.bRw.setPersonListRefreshListener(aVar);
        }
    }

    public void a(t.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(t.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(t.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bRw.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bRx.a(wVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bRx.a(xVar);
    }

    public void setForumName(String str) {
        this.bRx.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bRF = bVar;
    }

    public void abw() {
        if (this.bRC != null) {
            this.bRC.ta();
        }
    }

    public void onDestroy() {
        if (this.aNV != null) {
            this.aNV.destroy();
        }
        this.bRx.onDestory();
        this.bRw.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bRY);
        if (this.bIc != null) {
            this.bIc.onDestroy();
        }
        this.bRQ.clear();
        if (this.bRM != null) {
            this.bRM.adj();
        }
        if (this.bJv != null) {
            this.bJv.setBackgroundDrawable(null);
        }
    }

    public boolean abx() {
        if (this.bRM != null) {
            return this.bRM.abx();
        }
        return false;
    }

    public boolean aaS() {
        return this.bRo;
    }

    public void OG() {
        this.bRw.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bRp.getActivity().getString(t.j.forum));
        com.baidu.tbadk.core.l.oG().cd(str);
    }

    public void aby() {
        if (this.bRx != null) {
            this.bRx.notifyDataSetChanged();
        }
    }

    private void abz() {
        if (this.bRy == null) {
            String[] strArr = {this.bRp.getPageContext().getPageActivity().getString(t.j.take_photo), this.bRp.getPageContext().getPageActivity().getString(t.j.album)};
            this.bRy = new com.baidu.tbadk.core.dialog.c(this.bRp.getPageContext().getPageActivity());
            this.bRy.cC(this.bRp.getPageContext().getPageActivity().getString(t.j.operation));
            this.bRy.a(strArr, new bw(this));
            this.bRy.d(this.bRp.getPageContext());
        }
    }

    public void abA() {
        abz();
        if (this.bRy != null) {
            this.bRy.ta();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, int i, com.baidu.tieba.tbadkCore.p pVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            by byVar = new by();
            arrayList = new ArrayList<>();
            arrayList.add(byVar);
            if (this.bRp != null && this.bRp.aaV() != null && this.bRp.aaV().aeK() == 0) {
                byVar.hU(this.bRp.aaV().acf());
            }
        }
        this.bRx.a(arrayList, pVar);
        if (this.aNV != null) {
            this.aNV.a(this.aQc, this.aQb, this.aPX, true);
        }
    }

    public BdTypeListView getListView() {
        return this.bRw;
    }

    public void abB() {
        this.bRx.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData == null || forumData.getFrsBannerData() == null) {
            abC();
        } else if (!forumData.getFrsBannerData().isValid()) {
            abC();
        } else {
            this.anV = forumData.getFrsBannerData();
            if (!this.bRI) {
                a(this.anV);
                this.bRw.removeHeaderView(this.bRG);
                if (this.anV.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bRp.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bRp.abf() != null) {
                this.bRp.abf().b(this.bRw, this.bRG);
            }
            this.bRG.reset();
            if (this.anV.getType() == 1 && !TextUtils.isEmpty(this.anV.pH())) {
                this.bRG.c(this.bRp.getPageContext(), this.anV.pH());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0076a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.bRp.getForumId(), this.bRp.getForumName(), null);
            a.bS("obj_url", this.anV.pH());
            a.save();
        }
    }

    public void abC() {
        if (this.bRG != null) {
            this.bRI = false;
            this.bRw.removeHeaderView(this.bRG);
            this.bRG = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER, false));
        }
    }

    public void onPause() {
        if (this.bRM != null) {
            this.bRM.adk();
        }
    }

    public void release() {
        if (this.blV != null && this.bOz != null) {
            this.blV.b(this.bOz);
        }
    }

    public void abD() {
        this.bRA.setVisibility(8);
    }

    public void a(ct ctVar) {
        long j;
        if (!FrsActivityStatic.bQB || ctVar == null) {
            this.bRA.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bQC) {
            j = ctVar.aci() - ctVar.acj();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yX().zs()) {
                j -= ctVar.ack();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bRB.getVisibility() == 0) {
            this.bRA.setVisibility(0);
            if (j < 10) {
                this.bRA.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.av.k(this.bRA, t.f.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bRA.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.av.k(this.bRA, t.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bRA.setText("   ");
                com.baidu.tbadk.core.util.av.k(this.bRA, t.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bRA.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.bRP != null) {
            this.bRP.invalidate();
        }
        if (this.bRx != null) {
            this.bRx.acY();
            this.bRx.notifyDataSetChanged();
        }
        this.bRp.aaB();
        this.bRp.getLayoutMode().ah(i == 1);
        this.bRp.getLayoutMode().x(this.bRq);
        if (this.bRq != null) {
            com.baidu.tbadk.core.util.av.e(this.bRq, t.d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bRp.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.av.cO(t.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.av.e(this.bRH, t.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.av.l(this.mNavigationBar.getBottomLine(), t.d.cp_bg_line_b);
        }
        if (this.blV != null) {
            this.blV.onChangeSkinType(this.bRp.getPageContext(), i);
        }
        if (this.bRG != null) {
            this.bRG.lO();
        }
        if (this.bvo != null) {
            this.bvo.dh(i);
        }
        dN(false);
        if (this.bRN != null) {
            this.bRN.onChangeSkinType(i);
        }
        if (this.bRM != null) {
            this.bRM.onChangeSkinType(i);
        }
        if (this.bJv != null) {
            UtilHelper.setStatusBarBackground(this.bJv, i);
        }
    }

    public void kv() {
        this.bRw.kv();
    }

    public void abE() {
        this.bRw.l(2000L);
    }

    public int abF() {
        return 0;
    }

    public boolean abG() {
        return this.bRs != null && this.bRv.getVisibility() == 0;
    }

    public void abH() {
        if (this.bRs != null) {
            this.bRt.setVisibility(0);
            this.bRv.setVisibility(8);
            this.bRu.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bRY, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bo boVar) {
        if (this.bRs == null) {
            this.bRs = (ViewStub) this.bRp.findViewById(t.g.yule_game_egg_view_stub);
            this.bRs.setVisibility(0);
            this.bRt = (FrameLayout) this.bRp.findViewById(t.g.game_activity_egg_layout);
            this.bRu = (TbImageView) this.bRp.findViewById(t.g.game_activity_egg);
            this.bRv = (TbImageView) this.bRp.findViewById(t.g.game_activity_egg_s);
            this.bRu.setDefaultBgResource(t.d.common_color_10022);
            this.bRu.setDefaultResource(0);
            this.bRv.setDefaultBgResource(t.d.common_color_10022);
            this.bRv.setDefaultResource(0);
            this.bRt.setOnClickListener(this.bRE);
        }
        this.bRt.setVisibility(0);
        String sN = boVar.sN();
        String sO = boVar.sO();
        this.bRu.c(sN, 10, false);
        this.bRv.c(sO, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bRY, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void abI() {
        if (this.bRs != null) {
            this.bRt.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.af abJ() {
        return this.bRx;
    }

    public View getRootView() {
        return this.bRq;
    }

    public View abK() {
        return this.bRJ;
    }

    public void dK(boolean z) {
        this.bRz.setVisibility(z ? 0 : 8);
    }

    public void abL() {
        if (com.baidu.tbadk.performanceLog.aa.Gp().Gq()) {
            int lastVisiblePosition = this.bRw.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bRw.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof ca) {
                        ca caVar = (ca) childAt.getTag();
                        if (caVar.bSr != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = caVar.bSr.getPerfLog();
                            perfLog.fe(1000);
                            perfLog.aCi = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                caVar.bSr.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            caVar.bSr.vU();
                        }
                        if (caVar.bSp != null && (caVar.bSp instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = caVar.bSp;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.fe(1000);
                                    perfLog2.aCi = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vU();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bl) {
                        bl blVar = (bl) childAt.getTag();
                        if (blVar.bRm != null && blVar.bRm.aVj != null && (blVar.bRm.aVj instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = blVar.bRm.aVj.getPerfLog();
                            perfLog3.fe(1000);
                            perfLog3.aCi = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                blVar.bRm.aVj.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            blVar.bRm.aVj.vU();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (blVar.aVe != null) {
                            arrayList.add(blVar.aVe);
                        }
                        if (blVar.aVf != null) {
                            arrayList.add(blVar.aVf);
                        }
                        if (blVar.aVg != null) {
                            arrayList.add(blVar.aVg);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView2 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                                perfLog4.fe(1000);
                                perfLog4.aCi = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr4 = new int[2];
                                    tbImageView2.getLocationOnScreen(iArr4);
                                    if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView2.vU();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar abM() {
        return this.mNavigationBar;
    }

    public void abN() {
        this.mHasMore = true;
        this.bRw.setNextPage(this.bvo);
        this.bvo.wl();
    }

    public void abO() {
        this.mHasMore = false;
        if (this.bRK > 0) {
            this.bvo.di(this.bRK);
        }
        this.bRw.setNextPage(this.bvo);
        this.bvo.wm();
        this.bvo.setText(this.bRp.getResources().getString(t.j.list_no_more));
    }

    public void abP() {
        this.mHasMore = false;
        this.bRw.setNextPage(null);
        this.bvo.wo();
    }

    public void abQ() {
        this.bvo.wo();
    }

    public boolean abR() {
        return this.bvo.getView().getParent() != null && this.mHasMore;
    }

    public void hS(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("frs_login_tip", true)) {
                if (this.bIc == null) {
                    this.bIc = new CommonTipView(this.bRp.getActivity());
                }
                this.bIc.setText(t.j.frs_login_tip);
                this.bIc.a((FrameLayout) abK(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("frs_login_tip", false);
            }
        }
    }

    public TbImageView abS() {
        return this.bRP;
    }

    public GifView abT() {
        return this.bRO;
    }

    public void dL(boolean z) {
        if (this.aNV != null) {
            if (z) {
                this.aNV.aZR();
            } else {
                this.aNV.a(this.aQc, this.aQb, this.aPX, true);
            }
        }
    }

    public void af(int i, int i2) {
        if (this.aNV != null) {
            this.aNV.a(i, i2, this.aPX, 1);
        }
    }

    public void ag(int i, int i2) {
        this.aQc = i;
        this.aQb = i2;
    }

    public void dM(boolean z) {
        this.aPX = z;
    }

    public void abU() {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.setmBackImageViewBg(t.f.btn_sml_back_selector_s, t.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.av.k(this.mBackImageView, t.f.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.av.k(this.bRB, t.f.frs_star_navigation_bg);
        }
        int i = t.f.btn_sml_more_selector_s;
        this.bRT = i;
        this.bRS = i;
        com.baidu.tbadk.core.util.av.b(this.bRB, this.bRS, this.bRT);
    }

    public void abV() {
        dN(true);
    }

    private void abW() {
        float f;
        if (this.mNavigationBar != null && this.mNavigationBar.mTextTitle != null && this.mNavigationBar.getBarBgView() != null && this.bRB != null && this.mBackImageView != null) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            this.mNavigationBar.mTextTitle.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.bRB.setAlpha(f);
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void dN(boolean z) {
        boolean j = com.baidu.tieba.frs.i.p.j(this.bRp.aaR());
        boolean i = com.baidu.tieba.frs.i.p.i(this.bRp.aaR());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bRW) {
                    this.bRW = true;
                    if (j && !i) {
                        com.baidu.tbadk.core.util.av.b(this.mBackImageView, t.f.btn_sml_back_selector_s, t.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.av.b(this.bRB, t.f.btn_sml_more_selector_s, t.f.btn_sml_more_selector_s);
                        com.baidu.tbadk.core.util.av.k(this.mBackImageView, t.f.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.av.k(this.bRB, t.f.frs_star_navigation_bg);
                    } else {
                        com.baidu.tbadk.core.util.av.b(this.mBackImageView, t.f.btn_sml_back_selector_s, t.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.av.b(this.bRB, t.f.btn_sml_more_selector_s, t.f.btn_sml_more_selector_s);
                    }
                }
            } else if (!z || this.bRW) {
                this.bRW = false;
                if (j) {
                    com.baidu.tbadk.core.util.av.b(this.mBackImageView, t.f.icon_return_bg_s, t.f.icon_return_bg);
                    com.baidu.tbadk.core.util.av.b(this.bRB, t.f.btn_more_selector_s, t.f.btn_more_selector);
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bRB.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.av.b(this.mBackImageView, t.f.icon_return_bg_s, t.f.icon_return_bg);
                    com.baidu.tbadk.core.util.av.b(this.bRB, this.bRS, this.bRT);
                }
            }
        }
        abW();
    }

    public void abX() {
        if (!this.bRw.bqj()) {
            this.bRw.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.w(this.bRp.getPageContext());
            this.mPullView.setTag(this.bRp.getUniqueId());
            this.bRw.setPullRefresh(this.mPullView);
        }
    }

    public void abY() {
        this.bRw.setStarForum(false);
        this.bRw.setPullRefresh(null);
    }

    public void hT(int i) {
        if (getListView() != null && getListView().getChildAt(0) != null) {
            getListView().setSelectionFromTop(getListView().getFirstVisiblePosition(), getListView().getChildAt(0).getTop() - i);
        }
    }

    public void abZ() {
        if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.tS().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", 0) < bRU && !com.baidu.tbadk.core.sharedPref.b.tS().getBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "forum_has_show_frequently_forum_tips" + this.mForumName, false)) {
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.bRZ, 2000L);
        }
    }

    public void aca() {
        com.baidu.tbadk.core.sharedPref.b.tS().putInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", com.baidu.tbadk.core.sharedPref.b.tS().getInt(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frequently_forum_tips_count", 0) + 1);
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "forum_has_show_frequently_forum_tips" + this.mForumName, true);
    }

    public void acb() {
        if (this.Hs != null) {
            this.Hs.dismiss();
        }
    }
}
