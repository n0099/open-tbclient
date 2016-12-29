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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.entelechy.b.e;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ax {
    private static /* synthetic */ int[] bAu;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private PbListView aMJ;
    private com.baidu.tieba.play.aa aMd;
    private com.baidu.tbadk.core.data.v anZ;
    private View bAc;
    private View bAe;
    private View bAg;
    private e bAh;
    private com.baidu.tieba.frs.entelechy.b.c bAi;
    private GifView bAj;
    private TbImageView bAk;
    private HashSet<String> bAl;
    private com.baidu.tieba.frs.view.u bAm;
    private int bAn;
    private int bAo;
    private a bAp;
    private ObservedChangeLinearLayout bAq;
    private NoNetworkView bpG;
    private CommonTipView brb;
    private FrsActivity bzH;
    private View bzJ;
    private ViewStub bzK;
    private com.baidu.tieba.frs.entelechy.a.am bzP;
    private View bzR;
    private ImageView bzS;
    private TextView bzT;
    private View bzV;
    private View.OnClickListener bzZ;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.ac mPullView;
    private boolean bzG = false;
    private NoPressedRelativeLayout bzI = null;
    private FrameLayout bzL = null;
    private TbImageView bzM = null;
    private TbImageView bzN = null;
    private BdExpandListView bzO = null;
    private com.baidu.tbadk.core.dialog.c bzQ = null;
    private boolean bzU = false;
    private TextView bzW = null;
    private ImageView bzX = null;
    private com.baidu.tbadk.core.dialog.c bzY = null;
    private c.b bAa = null;
    private NoNetworkView.a aSE = null;
    private BannerView bAb = null;
    private boolean bAd = false;
    private boolean mHasMore = true;
    private int bAf = 0;
    private boolean aMf = false;
    private int aMh = 0;
    private int aMg = 0;
    private View bst = null;
    private boolean bAr = true;
    BannerView.a bAs = new ay(this);
    private Runnable bAt = new az(this);

    static /* synthetic */ int[] XN() {
        int[] iArr = bAu;
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
            bAu = iArr;
        }
        return iArr;
    }

    public ObservedChangeLinearLayout WU() {
        return this.bAq;
    }

    public View WV() {
        return this.bst;
    }

    public ax(FrsActivity frsActivity, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.bzH = null;
        this.bzZ = null;
        this.bzH = frsActivity;
        this.bzZ = onClickListener;
        a(aVar);
        this.bAl = new HashSet<>();
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.bzH.getPageContext());
        this.bzI = (NoPressedRelativeLayout) this.bzH.findViewById(r.g.frs);
        this.bAe = this.bzH.findViewById(r.g.frs_list_content);
        this.mNavigationBar = (NavigationBar) this.bzH.findViewById(r.g.view_navigation_bar);
        this.bAc = this.bzH.findViewById(r.g.frs_navi_line);
        com.baidu.tieba.frs.entelechy.b.b YA = aVar.YA();
        if (YA != null) {
            YA.ad(this.bAc);
        }
        this.bzJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bzJ.setOnClickListener(this.bzZ);
        this.mBackImageView = (ImageView) this.bzJ.findViewById(r.g.widget_navi_back_button);
        this.bzR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.frs_item_drifting_bottle_layout, (View.OnClickListener) null);
        this.bzS = (ImageView) this.bzR.findViewById(r.g.frs_top_drifting_bottle);
        this.bzT = (TextView) this.bzR.findViewById(r.g.frs_drifting_bottle_mes_text);
        this.bzT.setText("1");
        this.bzR.setVisibility(8);
        this.bzS.setOnClickListener(this.bzZ);
        this.bzV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.nb_item_frs_more, (View.OnClickListener) null);
        this.bzX = (ImageView) this.bzV.findViewById(r.g.frs_top_more);
        this.bzX.setContentDescription(this.bzH.getResources().getString(r.j.more));
        this.bAn = r.f.btn_more_selector_s;
        this.bAo = r.f.btn_more_selector;
        this.bzW = (TextView) this.bzV.findViewById(r.g.frs_more_mes_text);
        this.bzX.setOnClickListener(this.bzZ);
        dD(false);
        this.bzO = (BdExpandListView) this.bzH.findViewById(r.g.frs_lv_thread);
        this.bzO.setFadingEdgeLength(0);
        this.bzO.setOverScrollMode(2);
        this.bzI.setBottomOrderView(this.bzO);
        this.bzO.setOnTouchListener(this.bzH.aJN);
        this.bzO.setDivider(null);
        if (YA != null) {
            this.bAg = YA.a(this.bzH.getActivity(), this.bzO);
        }
        this.bzO.setDividerHeight(0);
        this.bzO.setRecyclerListener(new ba(this));
        this.aMJ = new PbListView(this.bzH.getPageContext().getPageActivity());
        this.aMJ.kk();
        this.aMJ.dj(r.d.cp_bg_line_c);
        this.bzO.setOnSrollToBottomListener(this.bzH);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new bb(this)));
        this.bzP = aVar.a(this.bzH, this.bzO, com.baidu.tbadk.core.util.aw.vm().vo());
        dw(false);
        this.bpG = (NoNetworkView) this.bzH.findViewById(r.g.view_no_network);
        WX();
        this.bAh = aVar.c(this.bzH, this.bzI);
        this.bAi = aVar.b(this.bzH, this.bzI);
        this.bAq = (ObservedChangeLinearLayout) this.bzH.findViewById(r.g.navigation_bar_wrapperLayout);
        this.bAq.setOnSizeChangeListener(new bc(this));
        this.bst = this.bzH.findViewById(r.g.statebar_view);
        this.aMd = new com.baidu.tieba.play.aa(this.bzH.getPageContext(), this.bzO);
        this.bzO.setPullRefresh(this.mPullView);
    }

    public com.baidu.tieba.play.aa JI() {
        return this.aMd;
    }

    public com.baidu.tieba.frs.entelechy.b.c WW() {
        return this.bAi;
    }

    public void du(boolean z) {
        if (this.bAh != null) {
            this.bAh.du(z);
        }
    }

    public void o(boolean z, boolean z2) {
        if (this.bAi != null) {
            this.bAi.o(z, z2);
        }
    }

    public void dv(boolean z) {
        if (this.bAi != null) {
            this.bAi.dP(z);
        }
    }

    private void WX() {
        this.bAj = (GifView) this.bzH.findViewById(r.g.gif_real_time);
        this.bAk = (TbImageView) this.bzH.findViewById(r.g.tbimg_real_time);
        this.bAj.setLayerType(1, null);
        this.bAk.setLayerType(1, null);
    }

    public void WY() {
        if (this.bzH.WF().aIk() != null && this.bzH.WF().aIk().getRealTimeData() != null) {
            com.baidu.tbadk.core.data.av realTimeData = this.bzH.WF().aIk().getRealTimeData();
            String forumId = this.bzH.getForumId();
            if (realTimeData != null && !StringUtils.isNull(realTimeData.getIcon()) && this.bAm == null) {
                this.bAm = new com.baidu.tieba.frs.view.u(realTimeData, this, this.bzH.getPageContext(), forumId);
                this.bAm.show();
            }
        }
    }

    public com.baidu.tieba.frs.view.u WZ() {
        return this.bAm;
    }

    private void a(com.baidu.tbadk.core.data.v vVar) {
        if (this.bAb == null && this.bzH != null && this.bzH.Wb() != null) {
            this.bAb = new BannerView(this.bzH.getPageContext().getPageActivity());
            this.bAb.setVisibility(8);
            this.bAb.setBannerViewClickListener(this.bAs);
            this.bAb.setBannerViewEvent(new bd(this));
        }
    }

    private void aF(String str, String str2) {
        if (!StringUtils.isNULL(str)) {
            a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.bzH.getForumId(), this.bzH.getForumName(), null);
            a.bY("obj_url", str2);
            a.save();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Xa() {
        if (this.anZ != null) {
            String value = this.anZ.getValue();
            String pA = this.anZ.pA();
            if (this.anZ.pV() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(this.bzH.getPageContext().getPageActivity(), value, false, "frs_banner")));
                aF(pA, value);
            } else if (this.anZ.pV() == 2) {
                if (value.contains("http://tieba.baidu.com/p/") || value.contains("http://tieba.baidu.com/p/")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(this.bzH.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                            createNormalCfg.setVideo_source("frs");
                            this.bzH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                            aF(pA, value);
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.anZ.pV() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.acf != UtilHelper.NativePageType.NONE) {
                    switch (XN()[isNativeAddress.acf.ordinal()]) {
                        case 2:
                            this.bzH.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bzH.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            break;
                        case 3:
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.bzH.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setVideo_source("frs");
                            this.bzH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                            break;
                    }
                } else {
                    com.baidu.tbadk.core.util.bc.vz().c(this.bzH.getPageContext(), new String[]{value});
                    if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                        TiebaStatic.eventStat(this.bzH.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                    }
                }
                aF(pA, value);
            } else if (this.anZ.pV() == 4) {
                this.bzH.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bzH.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
                aF(pA, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Xb() {
        return this.bzX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Xc() {
        return this.bzV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Xd() {
        return this.bzS;
    }

    public TextView Xe() {
        return this.bzT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Xf() {
        return this.bzR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View Xg() {
        return this.bzJ;
    }

    public void g(NoNetworkView.a aVar) {
        this.aSE = aVar;
        if (this.bpG != null) {
            this.bpG.a(this.aSE);
        }
    }

    public void dw(boolean z) {
        this.bzG = z;
        if (z) {
            if (this.bAi != null) {
                this.bAi.Zb();
                return;
            }
            return;
        }
        ((com.baidu.adp.widget.ListView.e) this.bzO.getAdapter()).notifyDataSetChanged();
        if (this.bAi != null) {
            this.bAi.Zc();
        }
    }

    public void dx(boolean z) {
        if (this.bAi != null) {
            if (z) {
                o(true, true);
            } else {
                o(true, false);
            }
        }
    }

    public void dy(boolean z) {
        if (this.bAi != null) {
            if (z) {
                o(false, true);
            } else {
                o(false, false);
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.bg bgVar, boolean z) {
        String string = this.bzH.getPageContext().getPageActivity().getString(r.j.view);
        String string2 = this.bzH.getPageContext().getPageActivity().getString(r.j.view_host);
        String string3 = this.bzH.getPageContext().getPageActivity().getString(r.j.view_reverse);
        this.bzY = new com.baidu.tbadk.core.dialog.c(this.bzH.getPageContext().getPageActivity());
        this.bzY.ce(r.j.operation);
        if (z) {
            this.bzY.a(new String[]{string, string3}, this.bAa);
        } else {
            this.bzY.a(new String[]{string, string2, string3}, this.bAa);
        }
        this.bzY.d(this.bzH.getPageContext());
    }

    public void a(BdExpandListView.a aVar) {
        if (this.bzO instanceof BdExpandListView) {
            this.bzO.setPersonListRefreshListener(aVar);
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
        this.bzO.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bzP.a(wVar);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.bzP.a(xVar);
    }

    public void setForumName(String str) {
        this.bzP.setForumName(str);
        this.mForumName = str;
    }

    public void a(c.b bVar) {
        this.bAa = bVar;
    }

    public void Xh() {
        if (this.bzY != null) {
            this.bzY.te();
        }
    }

    public void onDestroy() {
        if (this.aMd != null) {
            this.aMd.destroy();
        }
        this.bzP.onDestory();
        this.bzO.setOnSrollToBottomListener(null);
        TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.bAt);
        if (this.brb != null) {
            this.brb.onDestroy();
        }
        this.bAl.clear();
        if (this.bAh != null) {
            this.bAh.Zg();
        }
        if (this.bst != null) {
            this.bst.setBackgroundDrawable(null);
        }
        if (this.bAp != null) {
            this.bAp.VY();
        }
    }

    public boolean Xi() {
        if (this.bAh != null) {
            return this.bAh.Xi();
        }
        return false;
    }

    public boolean WG() {
        return this.bzG;
    }

    public void JF() {
        this.bzO.setVisibility(0);
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mNavigationBar.setTitleText("");
            return;
        }
        this.mNavigationBar.setTitleText(String.valueOf(str) + this.bzH.getActivity().getString(r.j.forum));
        com.baidu.tbadk.core.l.oJ().cf(str);
    }

    public void Xj() {
        if (this.bzP != null) {
            this.bzP.notifyDataSetChanged();
        }
    }

    private void Xk() {
        if (this.bzQ == null) {
            String[] strArr = {this.bzH.getPageContext().getPageActivity().getString(r.j.take_photo), this.bzH.getPageContext().getPageActivity().getString(r.j.album)};
            this.bzQ = new com.baidu.tbadk.core.dialog.c(this.bzH.getPageContext().getPageActivity());
            this.bzQ.cH(this.bzH.getPageContext().getPageActivity().getString(r.j.operation));
            this.bzQ.a(strArr, new be(this));
            this.bzQ.d(this.bzH.getPageContext());
        }
    }

    public void Xl() {
        Xk();
        if (this.bzQ != null) {
            this.bzQ.te();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.o oVar) {
        if (com.baidu.tbadk.core.util.x.t(arrayList)) {
            bg bgVar = new bg();
            arrayList = new ArrayList<>();
            arrayList.add(bgVar);
            if (this.bzH != null && this.bzH.Wh() != null && this.bzH.Wh().aaM() == 0) {
                bgVar.hi(this.bzH.Wh().aaU());
            }
        }
        this.bzP.b(arrayList, oVar);
        if (this.aMd != null) {
            this.aMd.a(this.aMh, this.aMg, this.aMf, true);
        }
    }

    public BdTypeListView Xm() {
        return this.bzO;
    }

    public void Xn() {
        this.bzP.notifyDataSetChanged();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(ForumData forumData, UserData userData, int i) {
        if (forumData == null || forumData.getFrsBannerData() == null) {
            Xo();
        } else if (!forumData.getFrsBannerData().isValid()) {
            Xo();
        } else {
            this.anZ = forumData.getFrsBannerData();
            if (!this.bAd) {
                a(this.anZ);
                this.bzO.removeHeaderView(this.bAb);
                if (this.anZ.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bzH.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bzH.Wb() != null) {
                this.bzH.Wb().b(this.bzH, this.bzO, this.bAb);
            }
            this.bAb.setBannerData(this.anZ);
            this.bAb.reset();
            if (this.anZ.getType() == 1 && !TextUtils.isEmpty(this.anZ.pW())) {
                this.bAb.c(this.bzH.getPageContext(), this.anZ.pW());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(String str) {
        if (!StringUtils.isNULL(str)) {
            a.C0074a a = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.bzH.getForumId(), this.bzH.getForumName(), null);
            a.bY("obj_url", this.anZ.pW());
            a.save();
        }
    }

    public void Xo() {
        if (this.bAb != null) {
            this.bAd = false;
            this.bzO.removeHeaderView(this.bAb);
            this.bAb = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_DISMISS_DIVIDER_BOTTOM_HEADER, false));
        }
    }

    public void onPause() {
        if (this.bAh != null) {
            this.bAh.Zh();
        }
    }

    public void onResume() {
        if (this.bAh != null) {
            this.bAh.Zi();
        }
    }

    public void release() {
        if (this.bpG != null && this.aSE != null) {
            this.bpG.b(this.aSE);
        }
    }

    public void Xp() {
        this.bzW.setVisibility(8);
    }

    public void a(bq bqVar) {
        long j;
        if (!FrsActivityStatic.bzr || bqVar == null) {
            this.bzW.setVisibility(8);
            return;
        }
        if (FrsActivityStatic.bzs) {
            j = bqVar.XU() - bqVar.XV();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.yV().zp()) {
                j -= bqVar.XW();
            }
        } else {
            j = 0;
        }
        if (j > 0 && this.bzX.getVisibility() == 0) {
            this.bzW.setVisibility(0);
            if (j < 10) {
                this.bzW.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.ar.k(this.bzW, r.f.icon_news_head_prompt_one);
                return;
            } else if (j < 100) {
                this.bzW.setText(String.valueOf(j));
                com.baidu.tbadk.core.util.ar.k(this.bzW, r.f.icon_news_head_prompt_two);
                return;
            } else {
                this.bzW.setText("   ");
                com.baidu.tbadk.core.util.ar.k(this.bzW, r.f.icon_news_head_prompt_more);
                return;
            }
        }
        this.bzW.setVisibility(8);
    }

    public void onChangeSkinType(int i) {
        if (this.bAk != null) {
            this.bAk.invalidate();
        }
        if (this.bzP != null) {
            this.bzP.YT();
            this.bzP.notifyDataSetChanged();
        }
        this.bzH.Ww();
        this.bzH.getLayoutMode().ai(i == 1);
        this.bzH.getLayoutMode().x(this.bzI);
        if (this.bzI != null) {
            com.baidu.tbadk.core.util.ar.e(this.bzI, r.d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bzH.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ar.cR(r.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.ar.e(this.bAc, r.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ar.l(this.mNavigationBar.getBottomLine(), r.d.cp_bg_line_b);
        }
        if (this.bpG != null) {
            this.bpG.onChangeSkinType(this.bzH.getPageContext(), i);
        }
        if (this.bAb != null) {
            this.bAb.lR();
        }
        if (this.aMJ != null) {
            this.aMJ.dk(i);
        }
        dD(false);
        if (this.bAi != null) {
            this.bAi.onChangeSkinType(i);
        }
        if (this.bAh != null) {
            this.bAh.onChangeSkinType(i);
        }
        if (this.bst != null) {
            UtilHelper.setStatusBarBackground(this.bst, i);
        }
        if (this.aMd != null) {
            this.aMd.a(this.aMh, this.aMg, this.aMf, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        if (this.bzT != null) {
            com.baidu.tbadk.core.util.ar.k(this.bzT, r.f.icon_news_head_prompt_one);
        }
    }

    public void kv() {
        this.bzO.kv();
    }

    public void Xq() {
        this.bzO.l(2000L);
    }

    public boolean Xr() {
        return this.bzK != null && this.bzN.getVisibility() == 0;
    }

    public void Xs() {
        if (this.bzK != null) {
            this.bzL.setVisibility(0);
            this.bzN.setVisibility(8);
            this.bzM.setVisibility(0);
            TbadkCoreApplication.m9getInst().handler.postDelayed(this.bAt, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bn bnVar) {
        if (this.bzK == null) {
            this.bzK = (ViewStub) this.bzH.findViewById(r.g.yule_game_egg_view_stub);
            this.bzK.setVisibility(0);
            this.bzL = (FrameLayout) this.bzH.findViewById(r.g.game_activity_egg_layout);
            this.bzM = (TbImageView) this.bzH.findViewById(r.g.game_activity_egg);
            this.bzN = (TbImageView) this.bzH.findViewById(r.g.game_activity_egg_s);
            this.bzM.setDefaultBgResource(r.d.common_color_10022);
            this.bzM.setDefaultResource(0);
            this.bzN.setDefaultBgResource(r.d.common_color_10022);
            this.bzN.setDefaultResource(0);
            this.bzL.setOnClickListener(this.bzZ);
        }
        this.bzL.setVisibility(0);
        String sR = bnVar.sR();
        String sS = bnVar.sS();
        this.bzM.c(sR, 10, false);
        this.bzN.c(sS, 10, false);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.bAt, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void Xt() {
        if (this.bzK != null) {
            this.bzL.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.am Xu() {
        return this.bzP;
    }

    public ViewGroup Xv() {
        return this.bzI;
    }

    public View Xw() {
        return this.bAe;
    }

    public void dz(boolean z) {
        this.bzR.setVisibility(z ? 0 : 8);
        this.bzV.setVisibility(z ? 0 : 8);
    }

    public void dA(boolean z) {
        if (this.bAi != null) {
            this.bAi.dQ(z);
        }
    }

    public void Xx() {
        if (com.baidu.tbadk.performanceLog.aa.FU().FV()) {
            int lastVisiblePosition = this.bzO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bzO.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof bi)) {
                    bi biVar = (bi) childAt.getTag();
                    if (biVar.bAJ != null) {
                        com.baidu.tbadk.performanceLog.u perfLog = biVar.bAJ.getPerfLog();
                        perfLog.fg(1000);
                        perfLog.aBW = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            biVar.bAJ.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getContext())) {
                            }
                        }
                        biVar.bAJ.vW();
                    }
                    if (biVar.bAH != null && (biVar.bAH instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = biVar.bAH;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fg(1000);
                                perfLog2.aBW = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getContext())) {
                                    }
                                }
                                tbImageView.vW();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar Ja() {
        return this.mNavigationBar;
    }

    public void Xy() {
        this.mHasMore = true;
        this.bzO.setNextPage(this.aMJ);
        this.aMJ.wp();
    }

    public void Jh() {
        this.mHasMore = false;
        if (this.bAf > 0) {
            this.aMJ.dl(this.bAf);
        }
        this.bzO.setNextPage(this.aMJ);
        this.aMJ.wq();
        this.aMJ.setText(this.bzH.getResources().getString(r.j.list_no_more));
    }

    public void Xz() {
        this.mHasMore = false;
        this.bzO.setNextPage(null);
        this.aMJ.wt();
    }

    public void XA() {
        this.aMJ.wt();
    }

    public boolean XB() {
        return this.aMJ.getView().getParent() != null && this.mHasMore;
    }

    public void hf(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("frs_login_tip", true)) {
                if (this.brb == null) {
                    this.brb = new CommonTipView(this.bzH.getActivity());
                }
                this.brb.setText(r.j.frs_login_tip);
                this.brb.a((FrameLayout) Xw(), TbadkCoreApplication.m9getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("frs_login_tip", false);
            }
        }
    }

    public TbImageView XC() {
        return this.bAk;
    }

    public GifView XD() {
        return this.bAj;
    }

    public void dB(boolean z) {
        if (this.aMd != null) {
            if (z) {
                this.aMd.ki(false);
                this.aMd.alQ();
                return;
            }
            this.aMd.ki(true);
            this.aMd.a(this.aMh, this.aMg, this.aMf, true);
        }
    }

    public void ac(int i, int i2) {
        if (this.aMd != null) {
            this.aMd.a(i, i2, this.aMf, 1);
        }
    }

    public void ad(int i, int i2) {
        this.aMh = i;
        this.aMg = i2;
    }

    public void dC(boolean z) {
        this.aMf = z;
    }

    public void XE() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(r.f.btn_sml_back_selector_s, r.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.ar.k(this.mBackImageView, r.f.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.ar.k(this.bzS, r.f.frs_star_navigation_bg);
            com.baidu.tbadk.core.util.ar.k(this.bzX, r.f.frs_star_navigation_bg);
        }
        int i = r.f.btn_sml_more_selector_s;
        this.bAo = i;
        this.bAn = i;
        com.baidu.tbadk.core.util.ar.b(this.bzX, this.bAn, this.bAo);
        if (this.bzU) {
            com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.d_btn_newbottle_selector, r.f.d_btn_newbottle_selector);
        } else {
            com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.d_btn_bottle_selector, r.f.d_btn_bottle_selector);
        }
    }

    public void XF() {
        dD(true);
    }

    private void XG() {
        float f;
        if (this.mNavigationBar != null) {
            float alpha = this.mNavigationBar.getBarBgView() != null ? this.mNavigationBar.getBarBgView().getAlpha() : 0.0f;
            if (this.mNavigationBar.mTextTitle != null) {
                this.mNavigationBar.mTextTitle.setAlpha(alpha);
            }
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.bzX != null) {
                    this.bzX.setAlpha(f);
                }
                if (this.bzS != null) {
                    this.bzS.setAlpha(f);
                }
            }
        }
    }

    private void dD(boolean z) {
        boolean m = com.baidu.tieba.frs.h.s.m(this.bzH.WF());
        boolean l = com.baidu.tieba.frs.h.s.l(this.bzH.WF());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.bAr) {
                    this.bAr = true;
                    com.baidu.tbadk.core.util.ar.b(this.mBackImageView, r.f.btn_sml_back_selector_s, r.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.ar.b(this.bzX, r.f.btn_sml_more_selector_s, r.f.btn_sml_more_selector_s);
                    if (this.bzU) {
                        com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.d_btn_newbottle_selector, r.f.d_btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.d_btn_bottle_selector, r.f.d_btn_bottle_selector);
                    }
                    if (m && !l) {
                        com.baidu.tbadk.core.util.ar.k(this.mBackImageView, r.f.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.ar.k(this.bzX, r.f.frs_star_navigation_bg);
                        com.baidu.tbadk.core.util.ar.k(this.bzS, r.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.bAr) {
                this.bAr = false;
                com.baidu.tbadk.core.util.ar.b(this.mBackImageView, r.f.icon_return_bg_s, r.f.icon_return_bg);
                if (m) {
                    com.baidu.tbadk.core.util.ar.b(this.bzX, r.f.btn_more_selector_s, r.f.btn_more_selector);
                    if (this.bzU) {
                        com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.btn_newbottle_selector, r.f.btn_newbottle_selector_w);
                    } else {
                        com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.btn_bottle_selector, r.f.btn_bottle_selector_w);
                    }
                    this.mBackImageView.setBackgroundDrawable(null);
                    this.bzX.setBackgroundDrawable(null);
                    this.bzS.setBackgroundDrawable(null);
                } else {
                    com.baidu.tbadk.core.util.ar.b(this.bzX, this.bAn, this.bAo);
                    if (this.bzU) {
                        com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.btn_newbottle_selector, r.f.btn_newbottle_selector);
                    } else {
                        com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.btn_bottle_selector, r.f.btn_bottle_selector);
                    }
                }
            }
        }
        XG();
    }

    public void XH() {
        if (!this.bzO.bfd()) {
            this.bzO.setStarForum(true);
            this.mPullView = new com.baidu.tbadk.core.view.ac(this.bzH.getPageContext());
            this.mPullView.setTag(this.bzH.getUniqueId());
            this.bzO.setPullRefresh(this.mPullView);
        }
    }

    public void XI() {
        this.bzO.setStarForum(false);
        this.bzO.setPullRefresh(null);
    }

    public BannerView XJ() {
        return this.bAb;
    }

    public void dE(boolean z) {
        this.bzU = z;
    }

    public boolean XK() {
        return this.bzU;
    }

    public void XL() {
        if (this.bAp != null) {
            this.bAp.VY();
        }
    }

    public void XM() {
        if (this.bzH == null || this.bzH.WF() == null || !this.bzH.WF().isShowDriftingBottle() || com.baidu.adp.lib.c.e.dN().ac("android_bottle_enable") == 0 || !TbadkCoreApplication.isLogin()) {
            this.bzR.setVisibility(8);
            return;
        }
        if (this.bAp == null) {
            this.bAp = new a(this.bzH.getPageContext(), this.bzS);
        }
        this.bAp.iz(this.bzH.getPageContext().getString(r.j.frs_bottle_tip));
        this.bzR.setVisibility(0);
        long j = com.baidu.tbadk.core.sharedPref.b.tW().getLong("drifting_bottle_tid" + TbadkCoreApplication.getCurrentAccount(), 0L);
        long beF = this.bzH.WF().beF();
        this.bzU = j != beF;
        if (beF == 0) {
            this.bzU = false;
        }
        if (this.bzU) {
            String str = "";
            if (this.bzH.WF().getUserData() != null && !StringUtils.isNull(this.bzH.WF().getUserData().getUserId())) {
                str = this.bzH.WF().getUserData().getUserId();
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11945").ab(SapiAccountManager.SESSION_UID, str).g("tid", this.bzH.WF().beF()));
            if (this.bzH.Wv()) {
                com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.btn_newbottle_selector, r.f.btn_newbottle_selector);
            } else {
                com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.d_btn_newbottle_selector, r.f.d_btn_newbottle_selector);
            }
            com.baidu.tbadk.core.util.ar.k(this.bzT, r.f.icon_news_head_prompt_one);
            this.bzT.setVisibility(0);
            return;
        }
        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11943"));
        if (this.bzH.Wv()) {
            com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.btn_bottle_selector, r.f.btn_bottle_selector);
        } else {
            com.baidu.tbadk.core.util.ar.b(this.bzS, r.f.d_btn_bottle_selector, r.f.d_btn_bottle_selector);
        }
        this.bzT.setVisibility(4);
    }

    public void hg(int i) {
        if (Xm() != null && Xm().getChildAt(0) != null) {
            Xm().setSelectionFromTop(Xm().getFirstVisiblePosition(), Xm().getChildAt(0).getTop() - i);
        }
    }

    public void hh(int i) {
        if (this.bzO != null && this.bzO.getChildCount() >= 0) {
            if (this.bzO.getFirstVisiblePosition() > 8) {
                this.bzO.setSelection(8);
            }
            this.bzO.smoothScrollToPosition(i);
        }
    }
}
