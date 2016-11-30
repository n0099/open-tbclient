package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
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
import com.baidu.tbadk.core.view.z;
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
public class au {
    private static /* synthetic */ int[] bUj;
    private com.baidu.tieba.play.aa aMM;
    private PbListView aNs;
    private com.baidu.tbadk.core.data.w aox;
    private CommonTipView bKX;
    private FrsActivity bTA;
    private View bTC;
    private ViewStub bTD;
    private com.baidu.tieba.frs.entelechy.a.aj bTI;
    private View bTK;
    private View.OnClickListener bTO;
    private View bTR;
    private View bTT;
    private View bTV;
    private com.baidu.tieba.frs.entelechy.b.e bTW;
    private com.baidu.tieba.frs.entelechy.b.c bTX;
    private GifView bTY;
    private TbImageView bTZ;
    private HashSet<String> bUa;
    private com.baidu.tieba.frs.view.u bUb;
    private int bUc;
    private int bUd;
    private ObservedChangeLinearLayout bUf;
    private NoNetworkView bpe;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ac mPullView;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    public static int bUe = 3;
    private boolean bTz = false;
    private NoPressedRelativeLayout bTB = null;
    private FrameLayout bTE = null;
    private TbImageView bTF = null;
    private TbImageView bTG = null;
    private BdExpandListView bTH = null;
    private com.baidu.tbadk.core.dialog.c bTJ = null;
    private TextView bTL = null;
    private ImageView bTM = null;
    private com.baidu.tbadk.core.dialog.c bTN = null;
    private c.b bTP = null;
    private NoNetworkView.a aTn = null;
    private BannerView bTQ = null;
    private boolean bTS = false;
    private boolean mHasMore = true;
    private int bTU = 0;
    private boolean aMO = false;
    private int aMQ = 0;
    private int aMP = 0;
    private View bMp = null;
    private boolean bUg = true;
    BannerView.a bUh = new av(this);
    private Runnable bUi = new aw(this);

    static /* synthetic */ int[] adu() {
        int[] iArr = bUj;
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
            bUj = iArr;
        }
        return iArr;
    }

    public ObservedChangeLinearLayout acH() {
        return this.bUf;
    }

    public View acI() {
        return this.bMp;
    }

    public au(FrsActivity frsActivity, View.OnClickListener onClickListener, a aVar) {
        this.bTA = null;
        this.bTO = null;
        this.bTA = frsActivity;
        this.bTO = onClickListener;
        a(aVar);
        this.bUa = new HashSet<>();
    }

    private void a(a aVar) {
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.bTA.getPageContext());
        this.bTB = (NoPressedRelativeLayout) this.bTA.findViewById(r.g.frs);
        this.mNavigationBar = (NavigationBar) this.bTA.findViewById(r.g.view_navigation_bar);
        this.bTR = this.bTA.findViewById(r.g.frs_navi_line);
        b aeh = aVar.aeh();
        if (aeh != null) {
            aeh.ad(this.bTR);
        }
        this.bTC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bTC.setOnClickListener(this.bTO);
        this.mBackImageView = (ImageView) this.bTC.findViewById(r.g.widget_navi_back_button);
        this.bTT = this.bTA.findViewById(r.g.frs_list_content);
        this.bTK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bTM = (ImageView) this.bTK.findViewById(r.g.frs_top_more);
        this.bTM.setContentDescription(this.bTA.getResources().getString(r.j.more));
        this.bUc = r.f.btn_more_selector_s;
        this.bUd = r.f.btn_more_selector;
        dV(false);
        this.bTM.setOnClickListener(this.bTO);
        this.bTL = (TextView) this.bTK.findViewById(r.g.frs_more_mes_text);
        this.bTH = (BdExpandListView) this.bTA.findViewById(r.g.frs_lv_thread);
        this.bTH.setFadingEdgeLength(0);
        this.bTH.setOverScrollMode(2);
        this.bTB.setBottomOrderView(this.bTH);
        this.bTH.setOnTouchListener(this.bTA.aKw);
        this.bTH.setDivider(null);
        if (aeh != null) {
            this.bTV = aeh.a(this.bTA.getActivity(), this.bTH);
        }
        this.bTH.setDividerHeight(0);
        this.bTH.setRecyclerListener(new ax(this));
        this.aNs = new PbListView(this.bTA.getPageContext().getPageActivity());
        this.aNs.kk();
        this.aNs.dh(r.d.cp_bg_line_c);
        this.bTH.setOnSrollToBottomListener(this.bTA);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ab(new ay(this)));
        this.bTI = aVar.a(this.bTA, this.bTH, com.baidu.tbadk.core.util.ay.vC().vE());
        dO(false);
        this.bpe = (NoNetworkView) this.bTA.findViewById(r.g.view_no_network);
        acK();
        this.bTW = aVar.c(this.bTA, this.bTB);
        this.bTX = aVar.b(this.bTA, this.bTB);
        this.bUf = (ObservedChangeLinearLayout) this.bTA.findViewById(r.g.navigation_bar_wrapperLayout);
        this.bUf.setOnSizeChangeListener(new az(this));
        this.bMp = this.bTA.findViewById(r.g.statebar_view);
        this.aMM = new com.baidu.tieba.play.aa(this.bTA.getPageContext(), this.bTH);
        this.bTH.setPullRefresh(this.mPullView);
    }

    public com.baidu.tieba.play.aa Kp() {
        return this.aMM;
    }

    public com.baidu.tieba.frs.entelechy.b.c acJ() {
        return this.bTX;
    }

    public void dM(boolean z) {
        if (this.bTW != null) {
            this.bTW.dM(z);
        }
    }

    public void n(boolean z, boolean z2) {
        if (this.bTX != null) {
            this.bTX.n(z, z2);
        }
    }

    public void dN(boolean z) {
        if (this.bTX != null) {
            this.bTX.ef(z);
        }
    }

    private void acK() {
        this.bTY = (GifView) this.bTA.findViewById(r.g.gif_real_time);
        this.bTZ = (TbImageView) this.bTA.findViewById(r.g.tbimg_real_time);
        this.bTY.setLayerType(1, null);
        this.bTZ.setLayerType(1, null);
    }

    public void acL() {
        if (this.bTA.acr().aOk() != null && this.bTA.acr().aOk().getRealTimeData() != null) {
            com.baidu.tbadk.core.data.ax realTimeData = this.bTA.acr().aOk().getRealTimeData();
            String forumId = this.bTA.getForumId();
            if (realTimeData != null && !StringUtils.isNull(realTimeData.getIcon()) && this.bUb == null) {
                this.bUb = new com.baidu.tieba.frs.view.u(realTimeData, this, this.bTA.getPageContext(), forumId);
                this.bUb.show();
            }
        }
    }

    public com.baidu.tieba.frs.view.u acM() {
        return this.bUb;
    }

    private void a(com.baidu.tbadk.core.data.w wVar) {
        if (this.bTQ == null && this.bTA != null && this.bTA.abM() != null) {
            this.bTQ = new BannerView(this.bTA.getPageContext().getPageActivity());
            this.bTQ.setVisibility(8);
            this.bTQ.setBannerViewClickListener(this.bUh);
            this.bTQ.setBannerViewEvent(new ba(this));
        }
    }

    private void aL(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.bTA.getForumId(), this.bTA.getForumName(), null);
            a.bV("obj_url", str2);
            a.save();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void acN() {
        if (this.aox != null) {
            String value = this.aox.getValue();
            String pA = this.aox.pA();
            if (this.aox.pU() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.bTA.getPageContext().getPageActivity(), value, false, "frs_banner")));
                aL(pA, value);
            } else if (this.aox.pU() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.bTA.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.bTA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            aL(pA, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aox.pU() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.acM != UtilHelper.NativePageType.NONE) {
                    switch (adu()[isNativeAddress.acM.ordinal()]) {
                        case 2:
                            this.bTA.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bTA.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case 3:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.bTA.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.bTA.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            break;
                    }
                } else {
                    com.baidu.tbadk.core.util.bf.vP().c(this.bTA.getPageContext(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.bTA.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                aL(pA, value);
            } else if (this.aox.pU() == 4) {
                this.bTA.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bTA.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                aL(pA, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View acO() {
        return this.bTM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View acP() {
        return this.bTK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View acQ() {
        return this.bTC;
    }

    public void g(NoNetworkView.a aVar) {
        this.aTn = aVar;
        if (this.bpe != null) {
            this.bpe.a(this.aTn);
        }
    }

    public void dO(boolean z) {
        this.bTz = z;
        if (z) {
            if (this.bTX != null) {
                this.bTX.aeG();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bTH.getAdapter()).notifyDataSetChanged();
        if (this.bTX != null) {
            this.bTX.aeH();
        }
    }

    public void dP(boolean z) {
        if (this.bTX != null) {
            if (z) {
                n(true, true);
            } else {
                n(true, false);
            }
        }
    }

    public void dQ(boolean z) {
        if (this.bTX != null) {
            if (z) {
                n(false, true);
            } else {
                n(false, false);
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.bk bkVar, boolean z) {
        String string = this.bTA.getPageContext().getPageActivity().getString(r.j.view);
        String string2 = this.bTA.getPageContext().getPageActivity().getString(r.j.view_host);
        String string3 = this.bTA.getPageContext().getPageActivity().getString(r.j.view_reverse);
        this.bTN = new com.baidu.tbadk.core.dialog.c(this.bTA.getPageContext().getPageActivity());
        this.bTN.cd(r.j.operation);
        if (z) {
            this.bTN.a(new String[]{string, string3}, this.bTP);
        } else {
            this.bTN.a(new String[]{string, string2, string3}, this.bTP);
        }
        this.bTN.d(this.bTA.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bTH instanceof BdExpandListView) {
            this.bTH.setPersonListRefreshListener(aVar);
        }
    }

    public void a(z.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(z.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(z.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bTH.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bTI.a(wVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bTI.a(xVar);
    }

    public void setForumName(String str) {
        this.bTI.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bTP = bVar;
    }

    public void acR() {
        if (this.bTN != null) {
            this.bTN.tt();
        }
    }

    public void onDestroy() {
        if (this.aMM != null) {
            this.aMM.destroy();
        }
        this.bTI.onDestory();
        this.bTH.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bUi);
        if (this.bKX != null) {
            this.bKX.onDestroy();
        }
        this.bUa.clear();
        if (this.bTW != null) {
            this.bTW.aeL();
        }
        if (this.bMp != null) {
            this.bMp.setBackgroundDrawable(null);
        }
    }

    public boolean acS() {
        if (this.bTW != null) {
            return this.bTW.acS();
        }
        return false;
    }

    public boolean acs() {
        return this.bTz;
    }

    public void Km() {
        this.bTH.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bTA.getActivity().getString(r.j.forum));
        com.baidu.tbadk.core.l.oJ().ce(str);
    }

    public void acT() {
        if (this.bTI != null) {
            this.bTI.notifyDataSetChanged();
        }
    }

    private void acU() {
        if (this.bTJ == null) {
            String[] strArr = {this.bTA.getPageContext().getPageActivity().getString(r.j.take_photo), this.bTA.getPageContext().getPageActivity().getString(r.j.album)};
            this.bTJ = new com.baidu.tbadk.core.dialog.c(this.bTA.getPageContext().getPageActivity());
            this.bTJ.cG(this.bTA.getPageContext().getPageActivity().getString(r.j.operation));
            this.bTJ.a(strArr, new bb(this));
            this.bTJ.d(this.bTA.getPageContext());
        }
    }

    public void acV() {
        acU();
        if (this.bTJ != null) {
            this.bTJ.tt();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.p pVar) {
        if (com.baidu.tbadk.core.util.x.t(arrayList)) {
            bd bdVar = new bd();
            arrayList = new ArrayList<>();
            arrayList.add(bdVar);
            if (this.bTA != null && this.bTA.abS() != null && this.bTA.abS().agq() == 0) {
                bdVar.hX(this.bTA.abS().agx());
            }
        }
        this.bTI.b(arrayList, pVar);
        if (this.aMM != null) {
            this.aMM.a(this.aMQ, this.aMP, this.aMO, true);
        }
    }

    public BdTypeListView acW() {
        return this.bTH;
    }

    public void acX() {
        this.bTI.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData == null || forumData.getFrsBannerData() == null) {
            acY();
        } else if (!forumData.getFrsBannerData().isValid()) {
            acY();
        } else {
            this.aox = forumData.getFrsBannerData();
            if (!this.bTS) {
                a(this.aox);
                this.bTH.removeHeaderView(this.bTQ);
                if (this.aox.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bTA.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bTA.abM() != null) {
                this.bTA.abM().b(this.bTA, this.bTH, this.bTQ);
            }
            this.bTQ.setBannerData(this.aox);
            this.bTQ.reset();
            if (this.aox.getType() == 1 && !TextUtils.isEmpty(this.aox.pV())) {
                this.bTQ.c(this.bTA.getPageContext(), this.aox.pV());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jW(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0080a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.bTA.getForumId(), this.bTA.getForumName(), null);
            a.bV("obj_url", this.aox.pV());
            a.save();
        }
    }

    public void acY() {
        if (this.bTQ != null) {
            this.bTS = false;
            this.bTH.removeHeaderView(this.bTQ);
            this.bTQ = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER, false));
        }
    }

    public void onPause() {
        if (this.bTW != null) {
            this.bTW.aeM();
        }
    }

    public void onResume() {
        if (this.bTW != null) {
            this.bTW.aeN();
        }
    }

    public void release() {
        if (this.bpe != null && this.aTn != null) {
            this.bpe.b(this.aTn);
        }
    }

    public void acZ() {
        this.bTL.setVisibility(8);
    }

    public void a(br brVar) {
        long j;
        if (!FrsActivityStatic.bTg || brVar == null) {
            this.bTL.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bTh) {
            j = brVar.adB() - brVar.adC();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zC()) {
                j -= brVar.adD();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bTM.getVisibility() == 0) {
            this.bTL.setVisibility(0);
            if (j < 10) {
                this.bTL.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.at.k(this.bTL, r.f.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bTL.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.at.k(this.bTL, r.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bTL.setText("   ");
                com.baidu.tbadk.core.util.at.k(this.bTL, r.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bTL.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.bTZ != null) {
            this.bTZ.invalidate();
        }
        if (this.bTI != null) {
            this.bTI.aez();
            this.bTI.notifyDataSetChanged();
        }
        this.bTA.aci();
        this.bTA.getLayoutMode().ai(i == 1);
        this.bTA.getLayoutMode().x(this.bTB);
        if (this.bTB != null) {
            com.baidu.tbadk.core.util.at.e(this.bTB, r.d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bTA.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.at.cP(r.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.at.e(this.bTR, r.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.at.l(this.mNavigationBar.getBottomLine(), r.d.cp_bg_line_b);
        }
        if (this.bpe != null) {
            this.bpe.onChangeSkinType(this.bTA.getPageContext(), i);
        }
        if (this.bTQ != null) {
            this.bTQ.lR();
        }
        if (this.aNs != null) {
            this.aNs.di(i);
        }
        dV(false);
        if (this.bTX != null) {
            this.bTX.onChangeSkinType(i);
        }
        if (this.bTW != null) {
            this.bTW.onChangeSkinType(i);
        }
        if (this.bMp != null) {
            UtilHelper.setStatusBarBackground(this.bMp, i);
        }
        if (this.aMM != null) {
            this.aMM.a(this.aMQ, this.aMP, this.aMO, true);
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
    }

    public void kv() {
        this.bTH.kv();
    }

    public void ada() {
        this.bTH.l(2000L);
    }

    public boolean adb() {
        return this.bTD != null && this.bTG.getVisibility() == 0;
    }

    public void adc() {
        if (this.bTD != null) {
            this.bTE.setVisibility(0);
            this.bTG.setVisibility(8);
            this.bTF.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bUi, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(com.baidu.tbadk.core.data.bs bsVar) {
        if (this.bTD == null) {
            this.bTD = (ViewStub) this.bTA.findViewById(r.g.yule_game_egg_view_stub);
            this.bTD.setVisibility(0);
            this.bTE = (FrameLayout) this.bTA.findViewById(r.g.game_activity_egg_layout);
            this.bTF = (TbImageView) this.bTA.findViewById(r.g.game_activity_egg);
            this.bTG = (TbImageView) this.bTA.findViewById(r.g.game_activity_egg_s);
            this.bTF.setDefaultBgResource(r.d.common_color_10022);
            this.bTF.setDefaultResource(0);
            this.bTG.setDefaultBgResource(r.d.common_color_10022);
            this.bTG.setDefaultResource(0);
            this.bTE.setOnClickListener(this.bTO);
        }
        this.bTE.setVisibility(0);
        String tg = bsVar.tg();
        String th = bsVar.th();
        this.bTF.c(tg, 10, false);
        this.bTG.c(th, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bUi, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void add() {
        if (this.bTD != null) {
            this.bTE.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.aj ade() {
        return this.bTI;
    }

    public ViewGroup adf() {
        return this.bTB;
    }

    public View adg() {
        return this.bTT;
    }

    public void dR(boolean z) {
        this.bTK.setVisibility(z ? 0 : 8);
    }

    public void dS(boolean z) {
        if (this.bTX != null) {
            this.bTX.eg(z);
        }
    }

    public void adh() {
        if (com.baidu.tbadk.performanceLog.aa.Gu().Gv()) {
            int lastVisiblePosition = this.bTH.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bTH.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof bf) {
                        bf bfVar = (bf) childAt.getTag();
                        if (bfVar.bUx != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = bfVar.bUx.getPerfLog();
                            perfLog.fg(1000);
                            perfLog.aCC = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                bfVar.bUx.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            bfVar.bUx.wm();
                        }
                        if (bfVar.bUv != null && (bfVar.bUv instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = bfVar.bUv;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.fg(1000);
                                    perfLog2.aCC = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.wm();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof at) {
                        at atVar = (at) childAt.getTag();
                        if (atVar.bTx != null && atVar.bTx.aYe != null && (atVar.bTx.aYe instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = atVar.bTx.aYe.getPerfLog();
                            perfLog3.fg(1000);
                            perfLog3.aCC = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                atVar.bTx.aYe.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                }
                            }
                            atVar.bTx.aYe.wm();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (atVar.aXZ != null) {
                            arrayList.add(atVar.aXZ);
                        }
                        if (atVar.aYa != null) {
                            arrayList.add(atVar.aYa);
                        }
                        if (atVar.aYb != null) {
                            arrayList.add(atVar.aYb);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView2 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                                perfLog4.fg(1000);
                                perfLog4.aCC = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr4 = new int[2];
                                    tbImageView2.getLocationOnScreen(iArr4);
                                    if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView2.wm();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar JF() {
        return this.mNavigationBar;
    }

    public void adi() {
        this.mHasMore = true;
        this.bTH.setNextPage(this.aNs);
        this.aNs.wF();
    }

    public void JM() {
        this.mHasMore = false;
        if (this.bTU > 0) {
            this.aNs.dj(this.bTU);
        }
        this.bTH.setNextPage(this.aNs);
        this.aNs.wG();
        this.aNs.setText(this.bTA.getResources().getString(r.j.list_no_more));
    }

    public void adj() {
        this.mHasMore = false;
        this.bTH.setNextPage(null);
        this.aNs.wJ();
    }

    public void adk() {
        this.aNs.wJ();
    }

    public boolean adl() {
        return this.aNs.getView().getParent() != null && this.mHasMore;
    }

    public void hV(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.um().getBoolean("frs_login_tip", true)) {
                if (this.bKX == null) {
                    this.bKX = new CommonTipView(this.bTA.getActivity());
                }
                this.bKX.setText(r.j.frs_login_tip);
                this.bKX.a((FrameLayout) adg(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("frs_login_tip", false);
            }
        }
    }

    public TbImageView adm() {
        return this.bTZ;
    }

    public GifView adn() {
        return this.bTY;
    }

    public void dT(boolean z) {
        if (this.aMM != null) {
            if (z) {
                this.aMM.ky(false);
                this.aMM.aro();
                return;
            }
            this.aMM.ky(true);
            this.aMM.a(this.aMQ, this.aMP, this.aMO, true);
        }
    }

    public void ah(int i, int i2) {
        if (this.aMM != null) {
            this.aMM.a(i, i2, this.aMO, 1);
        }
    }

    public void ai(int i, int i2) {
        this.aMQ = i;
        this.aMP = i2;
    }

    public void dU(boolean z) {
        this.aMO = z;
    }

    public void ado() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(r.f.btn_sml_back_selector_s, r.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.at.k(this.mBackImageView, r.f.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.at.k(this.bTM, r.f.frs_star_navigation_bg);
        }
        int i = r.f.btn_sml_more_selector_s;
        this.bUd = i;
        this.bUc = i;
        com.baidu.tbadk.core.util.at.b(this.bTM, this.bUc, this.bUd);
    }

    public void adp() {
        dV(true);
    }

    private void adq() {
        float f;
        if (this.mNavigationBar != null && this.mNavigationBar.mTextTitle != null && this.mNavigationBar.getBarBgView() != null && this.bTM != null && this.mBackImageView != null) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            this.mNavigationBar.mTextTitle.setAlpha(alpha);
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                this.bTM.setAlpha(f);
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void dV(boolean z) {
        boolean m = com.baidu.tieba.frs.j.n.m(this.bTA.acr());
        boolean l = com.baidu.tieba.frs.j.n.l(this.bTA.acr());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bUg) {
                    this.bUg = true;
                    if (m && !l) {
                        com.baidu.tbadk.core.util.at.b(this.mBackImageView, r.f.btn_sml_back_selector_s, r.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.at.b(this.bTM, r.f.btn_sml_more_selector_s, r.f.btn_sml_more_selector_s);
                        com.baidu.tbadk.core.util.at.k(this.mBackImageView, r.f.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.at.k(this.bTM, r.f.frs_star_navigation_bg);
                    } else {
                        com.baidu.tbadk.core.util.at.b(this.mBackImageView, r.f.btn_sml_back_selector_s, r.f.btn_sml_back_selector_s);
                        com.baidu.tbadk.core.util.at.b(this.bTM, r.f.btn_sml_more_selector_s, r.f.btn_sml_more_selector_s);
                    }
                }
            } else if (!z || this.bUg) {
                this.bUg = false;
                if (m) {
                    com.baidu.tbadk.core.util.at.b(this.mBackImageView, r.f.icon_return_bg_s, r.f.icon_return_bg);
                    com.baidu.tbadk.core.util.at.b(this.bTM, r.f.btn_more_selector_s, r.f.btn_more_selector);
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bTM.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.at.b(this.mBackImageView, r.f.icon_return_bg_s, r.f.icon_return_bg);
                    com.baidu.tbadk.core.util.at.b(this.bTM, this.bUc, this.bUd);
                }
            }
        }
        adq();
    }

    public void adr() {
        if (!this.bTH.blo()) {
            this.bTH.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.ac(this.bTA.getPageContext());
            this.mPullView.setTag(this.bTA.getUniqueId());
            this.bTH.setPullRefresh(this.mPullView);
        }
    }

    public void ads() {
        this.bTH.setStarForum(false);
        this.bTH.setPullRefresh(null);
    }

    public BannerView adt() {
        return this.bTQ;
    }

    public void hW(int i) {
        if (acW() != null && acW().getChildAt(0) != null) {
            acW().setSelectionFromTop(acW().getFirstVisiblePosition(), acW().getChildAt(0).getTop() - i);
        }
    }
}
