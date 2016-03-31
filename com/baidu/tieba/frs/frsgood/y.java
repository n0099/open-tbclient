package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dp;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class y {
    private static /* synthetic */ int[] bpd;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView baT;
    private PbListView bcf;
    private FrsGoodActivity bnM;
    private com.baidu.tbadk.core.data.p boT;
    private View boV;
    private cn bss;
    private NavigationBar mNavigationBar;
    private boolean bos = false;
    private NoPressedRelativeLayout bot = null;
    private BdTypeListView boD = null;
    private com.baidu.tbadk.core.dialog.c boG = null;
    private com.baidu.tbadk.core.view.u mPullView = null;
    private com.baidu.tieba.tbadkCore.t boN = null;
    com.baidu.tbadk.core.dialog.c boO = null;
    Animation boP = null;
    private c.b boR = null;
    private BannerView boS = null;
    private boolean boU = false;
    BannerView.a boZ = new z(this);
    BannerView.a bpa = new aa(this);
    View bpb = null;

    static /* synthetic */ int[] Sk() {
        int[] iArr = bpd;
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
            bpd = iArr;
        }
        return iArr;
    }

    public y(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.bnM = null;
        this.bnM = frsGoodActivity;
        pU();
    }

    private void pU() {
        this.bot = (NoPressedRelativeLayout) this.bnM.findViewById(t.g.frs);
        this.mNavigationBar = (NavigationBar) this.bnM.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.bnM.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(t.j.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.boV = this.bnM.findViewById(t.g.frs_list_content);
        this.boD = (BdTypeListView) this.bnM.findViewById(t.g.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.u(this.bnM.getPageContext());
        this.boD.setDivider(null);
        this.boD.setPullRefresh(this.mPullView);
        this.boD.setDividerHeight(0);
        this.boD.setRecyclerListener(new ab(this));
        this.bcf = new PbListView(this.bnM.getPageContext().getPageActivity());
        this.bcf.mZ();
        this.bcf.di(t.d.cp_bg_line_c);
        this.boD.setOnSrollToBottomListener(this.bnM);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new ac(this)));
        this.bss = new cn(this.bnM, this.boD, az.wz().wB());
        this.baT = (NoNetworkView) this.bnM.findViewById(t.g.view_no_network);
        cE(false);
    }

    private void RE() {
        if (this.boS == null) {
            this.boS = new BannerView(this.bnM.getPageContext().getPageActivity());
            this.boS.setLayoutParams(new AbsListView.LayoutParams(-1, this.bnM.getResources().getDimensionPixelSize(t.e.frs_header_banner_height)));
            this.boS.setVisibility(8);
            this.boS.setBannerViewClickListener(this.bpa);
            this.boS.setBannerViewEvent(new ad(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void RF() {
        if (this.boT != null) {
            String value = this.boT.getValue();
            if (this.boT.rD() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.bnM.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.boT.rD() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.bnM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bnM.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.boT.rD() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.acN != UtilHelper.NativePageType.NONE) {
                    switch (Sk()[isNativeAddress.acN.ordinal()]) {
                        case 2:
                            this.bnM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bnM.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.bnM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bnM.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                bg.wM().c(this.bnM.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bnM.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.boT.rD() == 4) {
                this.bnM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bnM.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(as asVar, boolean z) {
        String string = this.bnM.getPageContext().getPageActivity().getString(t.j.view);
        String string2 = this.bnM.getPageContext().getPageActivity().getString(t.j.view_host);
        String string3 = this.bnM.getPageContext().getPageActivity().getString(t.j.view_reverse);
        this.boO = new com.baidu.tbadk.core.dialog.c(this.bnM.getPageContext().getPageActivity());
        this.boO.cd(t.j.operation);
        if (z) {
            this.boO.a(new String[]{string, string3}, this.boR);
        } else {
            this.boO.a(new String[]{string, string2, string3}, this.boR);
        }
        this.boO.d(this.bnM.getPageContext());
    }

    public void a(s.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.boD.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.bss.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bss.a(wVar);
    }

    public void a(c.b bVar) {
        this.boR = bVar;
    }

    public void RN() {
        if (this.boO != null) {
            this.boO.us();
        }
    }

    public void onDestroy() {
        this.bss.onDestory();
        this.boD.setOnSrollToBottomListener(null);
    }

    public void cE(boolean z) {
        this.bos = z;
        if (!z) {
            this.boD.nj();
        }
    }

    public void Mu() {
        this.boD.setVisibility(0);
    }

    public void RP() {
        if (this.bss != null) {
            this.bss.notifyDataSetChanged();
        }
    }

    public void cF(boolean z) {
        this.bss.cC(z);
    }

    public void cG(boolean z) {
        this.bss.cD(z);
    }

    private void RQ() {
        if (this.boG == null) {
            String[] strArr = {this.bnM.getPageContext().getPageActivity().getString(t.j.take_photo), this.bnM.getPageContext().getPageActivity().getString(t.j.album)};
            this.boG = new com.baidu.tbadk.core.dialog.c(this.bnM.getPageContext().getPageActivity());
            this.boG.cD(this.bnM.getPageContext().getPageActivity().getString(t.j.operation));
            this.boG.a(strArr, new ae(this));
            this.boG.d(this.bnM.getPageContext());
        }
    }

    public void RR() {
        RQ();
        if (this.boG != null) {
            this.boG.us();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            di diVar = new di();
            arrayList = new ArrayList<>();
            arrayList.add(diVar);
        }
        this.bss.a(arrayList, oVar, gL(i), gM(i2));
    }

    public BdListView Mg() {
        return this.boD;
    }

    private boolean gL(int i) {
        return i > 1;
    }

    private boolean gM(int i) {
        return i == 1;
    }

    public void SL() {
        this.bss.cC(false);
        this.bss.cD(false);
        this.bss.notifyDataSetInvalidated();
    }

    public void gV(int i) {
        this.boD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.boU && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.boT = forumData.getFrsBannerData();
            RE();
            this.boS.reset();
            this.boD.removeHeaderView(this.boS);
            if (this.boT.getType() == 1 && !TextUtils.isEmpty(this.boT.rE())) {
                this.boS.c(this.bnM.getPageContext(), this.boT.rE());
                if (this.boT.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bnM.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void RT() {
        if (this.boS != null) {
            this.boU = false;
            this.boD.removeHeaderView(this.boS);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        if (this.bss != null) {
            this.bss.Rn();
            this.bss.notifyDataSetChanged();
            this.bss.onChangeSkinType(i);
        }
        this.bnM.getLayoutMode().ab(i == 1);
        this.bnM.getLayoutMode().x(this.bot);
        this.mNavigationBar.onChangeSkinType(this.bnM.getPageContext(), i);
        if (this.baT != null) {
            this.baT.onChangeSkinType(this.bnM.getPageContext(), i);
        }
        if (this.boS != null) {
            this.boS.oH();
        }
        if (this.bcf != null) {
            this.bcf.dj(i);
        }
    }

    public void nk() {
        this.boD.nk();
    }

    public int RV() {
        return 0;
    }

    public cn SM() {
        return this.bss;
    }

    public NoPressedRelativeLayout SN() {
        return this.bot;
    }

    public View Sc() {
        return this.boV;
    }

    public void Sf() {
        if (com.baidu.tbadk.performanceLog.aa.GU().GV()) {
            int lastVisiblePosition = this.boD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.boD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof dp) {
                        dp dpVar = (dp) childAt.getTag();
                        if (dpVar.bjG != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = dpVar.bjG.getPerfLog();
                            perfLog.fh(1000);
                            perfLog.aBs = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                dpVar.bjG.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            dpVar.bjG.xi();
                        }
                        if (dpVar.bjE != null && (dpVar.bjE instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = dpVar.bjE;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.fh(1000);
                                    perfLog2.aBs = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.xi();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bv) {
                        bv bvVar = (bv) childAt.getTag();
                        if (bvVar.bmz != null) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = bvVar.bmz.getPerfLog();
                            perfLog3.fh(1000);
                            perfLog3.aBs = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bvVar.bmz.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bvVar.bmz.xi();
                        }
                        if (bvVar.bmU != null && (bvVar.bmU instanceof TbImageView)) {
                            TbImageView tbImageView2 = bvVar.bmU;
                            com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.fh(1000);
                            perfLog4.aBs = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.xi();
                        }
                    }
                    if (childAt.getTag() instanceof co) {
                        co coVar = (co) childAt.getTag();
                        if (coVar.bnR != null && coVar.bnR.aPn != null && (coVar.bnR.aPn instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog5 = coVar.bnR.aPn.getPerfLog();
                            perfLog5.fh(1000);
                            perfLog5.aBs = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                coVar.bnR.aPn.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            coVar.bnR.aPn.xi();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (coVar.aPi != null) {
                            arrayList.add(coVar.aPi);
                        }
                        if (coVar.aPj != null) {
                            arrayList.add(coVar.aPj);
                        }
                        if (coVar.aPk != null) {
                            arrayList.add(coVar.aPk);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.fh(1000);
                                perfLog6.aBs = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.xi();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Sg() {
        this.boD.setNextPage(this.bcf);
        this.bcf.xu();
    }

    public void Sh() {
        this.boD.setNextPage(this.bcf);
        this.bcf.xv();
        this.bcf.setText(this.bnM.getResources().getString(t.j.list_no_more));
    }

    public void Si() {
        this.boD.setNextPage(null);
    }

    public BdTypeListView SO() {
        return this.boD;
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.baT.a(aVar);
        }
    }
}
