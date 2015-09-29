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
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class x {
    private static /* synthetic */ int[] aWR;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aMF;
    private com.baidu.tbadk.core.data.i aWH;
    private View aWJ;
    private PbListView aWL;
    private FrsGoodActivity aWe;
    private bq aZK;
    private NavigationBar mNavigationBar;
    private boolean aWk = false;
    private NoPressedRelativeLayout aWl = null;
    private BdTypeListView aWs = null;
    private com.baidu.tbadk.core.dialog.c aWv = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private com.baidu.tieba.tbadkCore.t aWC = null;
    com.baidu.tbadk.core.dialog.c aWD = null;
    Animation aWE = null;
    private c.b aWG = null;
    private BannerView aKh = null;
    private boolean aWI = false;
    BannerView.a aWN = new y(this);
    BannerView.a aWO = new z(this);
    View aWP = null;

    static /* synthetic */ int[] Mh() {
        int[] iArr = aWR;
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
            aWR = iArr;
        }
        return iArr;
    }

    public x(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.aWe = null;
        this.aWe = frsGoodActivity;
        initUI();
    }

    private void initUI() {
        this.aWl = (NoPressedRelativeLayout) this.aWe.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aWe.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.aWe.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(i.h.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aWJ = this.aWe.findViewById(i.f.frs_list_content);
        this.aWs = (BdTypeListView) this.aWe.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aWe.getPageContext());
        this.aWs.setDivider(null);
        this.aWs.setPullRefresh(this.mPullView);
        this.aWs.setDividerHeight(0);
        this.aWs.setRecyclerListener(new aa(this));
        this.aWL = new PbListView(this.aWe.getPageContext().getPageActivity());
        this.aWL.no();
        this.aWL.cM(i.c.cp_bg_line_c);
        this.aWs.setOnSrollToBottomListener(this.aWe);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new ab(this)));
        this.aZK = new bq(this.aWe, this.aWs, as.uI().uK());
        this.aMF = (NoNetworkView) this.aWe.findViewById(i.f.view_no_network);
        cc(false);
    }

    private void HC() {
        if (this.aKh == null) {
            this.aKh = new BannerView(this.aWe.getPageContext().getPageActivity());
            this.aKh.setLayoutParams(new AbsListView.LayoutParams(-1, this.aWe.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aKh.setVisibility(8);
            this.aKh.setBannerViewClickListener(this.aWO);
            this.aKh.setBannerViewEvent(new ac(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LG() {
        if (this.aWH != null) {
            String value = this.aWH.getValue();
            if (this.aWH.rB() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aWe.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aWH.rB() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aWe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWe.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aWH.rB() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.abx != UtilHelper.NativePageType.NONE) {
                    switch (Mh()[isNativeAddress.abx.ordinal()]) {
                        case 2:
                            this.aWe.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWe.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aWe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWe.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                ay.uV().b(this.aWe.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWe.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aWH.rB() == 4) {
                this.aWe.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWe.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.v vVar, boolean z) {
        String string = this.aWe.getPageContext().getPageActivity().getString(i.h.view);
        String string2 = this.aWe.getPageContext().getPageActivity().getString(i.h.view_host);
        String string3 = this.aWe.getPageContext().getPageActivity().getString(i.h.view_reverse);
        this.aWD = new com.baidu.tbadk.core.dialog.c(this.aWe.getPageContext().getPageActivity());
        this.aWD.bI(i.h.operation);
        if (z) {
            this.aWD.a(new String[]{string, string3}, this.aWG);
        } else {
            this.aWD.a(new String[]{string, string2, string3}, this.aWG);
        }
        this.aWD.d(this.aWe.getPageContext());
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aWs.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.aZK.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.aZK.a(wVar);
    }

    public void c(c.b bVar) {
        this.aWG = bVar;
    }

    public void LN() {
        if (this.aWD != null) {
            this.aWD.sU();
        }
    }

    public void onDestroy() {
        this.aZK.onDestory();
        this.aWs.setOnSrollToBottomListener(null);
    }

    public void cc(boolean z) {
        this.aWk = z;
        if (!z) {
            this.aWs.completePullRefresh();
        }
    }

    public void LP() {
        this.aWs.setVisibility(0);
    }

    public void LQ() {
        if (this.aZK != null) {
            this.aZK.notifyDataSetChanged();
        }
    }

    public void cd(boolean z) {
        this.aZK.ca(z);
    }

    public void ce(boolean z) {
        this.aZK.cb(z);
    }

    private void LR() {
        if (this.aWv == null) {
            String[] strArr = {this.aWe.getPageContext().getPageActivity().getString(i.h.take_photo), this.aWe.getPageContext().getPageActivity().getString(i.h.album)};
            this.aWv = new com.baidu.tbadk.core.dialog.c(this.aWe.getPageContext().getPageActivity());
            this.aWv.cu(this.aWe.getPageContext().getPageActivity().getString(i.h.operation));
            this.aWv.a(strArr, new ad(this));
            this.aWv.d(this.aWe.getPageContext());
        }
    }

    public void LS() {
        LR();
        if (this.aWv != null) {
            this.aWv.sU();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cd cdVar = new cd();
            arrayList = new ArrayList<>();
            arrayList.add(cdVar);
        }
        this.aZK.a(arrayList, oVar, fx(i), fy(i2));
    }

    public BdListView getListView() {
        return this.aWs;
    }

    private boolean fx(int i) {
        return i > 1;
    }

    private boolean fy(int i) {
        return i == 1;
    }

    public void LT() {
        this.aZK.ca(false);
        this.aZK.cb(false);
        this.aZK.notifyDataSetInvalidated();
    }

    public void fz(int i) {
        this.aWs.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aWI && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aWH = forumData.getFrsBannerData();
            HC();
            this.aKh.reset();
            this.aWs.removeHeaderView(this.aKh);
            if (this.aWH.getType() == 1 && !TextUtils.isEmpty(this.aWH.rC())) {
                this.aKh.b(this.aWe.getPageContext(), this.aWH.rC());
                if (this.aWH.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWe.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void LU() {
        if (this.aKh != null) {
            this.aWI = false;
            this.aWs.removeHeaderView(this.aKh);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aZK != null) {
            this.aZK.Lv();
            this.aZK.notifyDataSetChanged();
            this.aZK.onChangeSkinType(i);
        }
        this.aWe.getLayoutMode().ad(i == 1);
        this.aWe.getLayoutMode().k(this.aWl);
        this.mNavigationBar.onChangeSkinType(this.aWe.getPageContext(), i);
        if (this.aMF != null) {
            this.aMF.onChangeSkinType(this.aWe.getPageContext(), i);
        }
        if (this.aKh != null) {
            this.aKh.oO();
        }
        if (this.aWL != null) {
            this.aWL.cN(i);
        }
    }

    public void nw() {
        this.aWs.nw();
    }

    public int LW() {
        return 0;
    }

    public bq MN() {
        return this.aZK;
    }

    public NoPressedRelativeLayout MO() {
        return this.aWl;
    }

    public View Ma() {
        return this.aWJ;
    }

    public void Md() {
        if (com.baidu.tbadk.performanceLog.y.Eb().Ec()) {
            int lastVisiblePosition = this.aWs.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWs.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cl) {
                        cl clVar = (cl) childAt.getTag();
                        if (clVar.aSY != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = clVar.aSY.getPerfLog();
                            perfLog.ez(1000);
                            perfLog.axq = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                clVar.aSY.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            clVar.aSY.vr();
                        }
                        if (clVar.aSU != null && (clVar.aSU instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = clVar.aSU;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.ez(1000);
                                    perfLog2.axq = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vr();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bm) {
                        bm bmVar = (bm) childAt.getTag();
                        if (bmVar.aVC != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bmVar.aVC.getPerfLog();
                            perfLog3.ez(1000);
                            perfLog3.axq = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bmVar.aVC.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bmVar.aVC.vr();
                        }
                        if (bmVar.aVT != null && (bmVar.aVT instanceof TbImageView)) {
                            TbImageView tbImageView2 = bmVar.aVT;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.ez(1000);
                            perfLog4.axq = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vr();
                        }
                    }
                    if (childAt.getTag() instanceof br) {
                        br brVar = (br) childAt.getTag();
                        if (brVar.aWi != null && brVar.aWi.aHL != null && (brVar.aWi.aHL instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = brVar.aWi.aHL.getPerfLog();
                            perfLog5.ez(1000);
                            perfLog5.axq = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                brVar.aWi.aHL.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            brVar.aWi.aHL.vr();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (brVar.aHG != null) {
                            arrayList.add(brVar.aHG);
                        }
                        if (brVar.aHH != null) {
                            arrayList.add(brVar.aHH);
                        }
                        if (brVar.aHI != null) {
                            arrayList.add(brVar.aHI);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.ez(1000);
                                perfLog6.axq = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vr();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Me() {
        this.aWs.setNextPage(this.aWL);
        this.aWL.startLoadData();
    }

    public void Mf() {
        this.aWs.setNextPage(this.aWL);
        this.aWL.vy();
        this.aWL.setText(this.aWe.getResources().getString(i.h.list_no_more));
    }

    public void Mg() {
        this.aWs.setNextPage(null);
    }

    public BdTypeListView MP() {
        return this.aWs;
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aMF.a(aVar);
        }
    }
}
