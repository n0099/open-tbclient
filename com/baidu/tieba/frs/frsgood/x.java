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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.az;
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
    private static /* synthetic */ int[] aXc;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aMQ;
    private com.baidu.tbadk.core.data.j aWS;
    private View aWU;
    private PbListView aWW;
    private FrsGoodActivity aWp;
    private bq aZV;
    private NavigationBar mNavigationBar;
    private boolean aWv = false;
    private NoPressedRelativeLayout aWw = null;
    private BdTypeListView aWD = null;
    private com.baidu.tbadk.core.dialog.c aWG = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private com.baidu.tieba.tbadkCore.t aWN = null;
    com.baidu.tbadk.core.dialog.c aWO = null;
    Animation aWP = null;
    private c.b aWR = null;
    private BannerView aKs = null;
    private boolean aWT = false;
    BannerView.a aWY = new y(this);
    BannerView.a aWZ = new z(this);
    View aXa = null;

    static /* synthetic */ int[] Md() {
        int[] iArr = aXc;
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
            aXc = iArr;
        }
        return iArr;
    }

    public x(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.aWp = null;
        this.aWp = frsGoodActivity;
        initUI();
    }

    private void initUI() {
        this.aWw = (NoPressedRelativeLayout) this.aWp.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aWp.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.aWp.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(i.h.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aWU = this.aWp.findViewById(i.f.frs_list_content);
        this.aWD = (BdTypeListView) this.aWp.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aWp.getPageContext());
        this.aWD.setDivider(null);
        this.aWD.setPullRefresh(this.mPullView);
        this.aWD.setDividerHeight(0);
        this.aWD.setRecyclerListener(new aa(this));
        this.aWW = new PbListView(this.aWp.getPageContext().getPageActivity());
        this.aWW.no();
        this.aWW.cM(i.c.cp_bg_line_c);
        this.aWD.setOnSrollToBottomListener(this.aWp);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new ab(this)));
        this.aZV = new bq(this.aWp, this.aWD, at.uG().uI());
        this.aMQ = (NoNetworkView) this.aWp.findViewById(i.f.view_no_network);
        cc(false);
    }

    private void Hy() {
        if (this.aKs == null) {
            this.aKs = new BannerView(this.aWp.getPageContext().getPageActivity());
            this.aKs.setLayoutParams(new AbsListView.LayoutParams(-1, this.aWp.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aKs.setVisibility(8);
            this.aKs.setBannerViewClickListener(this.aWZ);
            this.aKs.setBannerViewEvent(new ac(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LC() {
        if (this.aWS != null) {
            String value = this.aWS.getValue();
            if (this.aWS.ry() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aWp.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aWS.ry() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aWp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWp.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aWS.ry() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.abA != UtilHelper.NativePageType.NONE) {
                    switch (Md()[isNativeAddress.abA.ordinal()]) {
                        case 2:
                            this.aWp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWp.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aWp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWp.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                az.uT().b(this.aWp.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWp.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aWS.ry() == 4) {
                this.aWp.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWp.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aWp.getPageContext().getPageActivity().getString(i.h.view);
        String string2 = this.aWp.getPageContext().getPageActivity().getString(i.h.view_host);
        String string3 = this.aWp.getPageContext().getPageActivity().getString(i.h.view_reverse);
        this.aWO = new com.baidu.tbadk.core.dialog.c(this.aWp.getPageContext().getPageActivity());
        this.aWO.bI(i.h.operation);
        if (z) {
            this.aWO.a(new String[]{string, string3}, this.aWR);
        } else {
            this.aWO.a(new String[]{string, string2, string3}, this.aWR);
        }
        this.aWO.d(this.aWp.getPageContext());
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aWD.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.aZV.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.aZV.a(wVar);
    }

    public void c(c.b bVar) {
        this.aWR = bVar;
    }

    public void LJ() {
        if (this.aWO != null) {
            this.aWO.sR();
        }
    }

    public void onDestroy() {
        this.aZV.onDestory();
        this.aWD.setOnSrollToBottomListener(null);
    }

    public void cc(boolean z) {
        this.aWv = z;
        if (!z) {
            this.aWD.completePullRefresh();
        }
    }

    public void LL() {
        this.aWD.setVisibility(0);
    }

    public void LM() {
        if (this.aZV != null) {
            this.aZV.notifyDataSetChanged();
        }
    }

    public void cd(boolean z) {
        this.aZV.ca(z);
    }

    public void ce(boolean z) {
        this.aZV.cb(z);
    }

    private void LN() {
        if (this.aWG == null) {
            String[] strArr = {this.aWp.getPageContext().getPageActivity().getString(i.h.take_photo), this.aWp.getPageContext().getPageActivity().getString(i.h.album)};
            this.aWG = new com.baidu.tbadk.core.dialog.c(this.aWp.getPageContext().getPageActivity());
            this.aWG.cv(this.aWp.getPageContext().getPageActivity().getString(i.h.operation));
            this.aWG.a(strArr, new ad(this));
            this.aWG.d(this.aWp.getPageContext());
        }
    }

    public void LO() {
        LN();
        if (this.aWG != null) {
            this.aWG.sR();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cd cdVar = new cd();
            arrayList = new ArrayList<>();
            arrayList.add(cdVar);
        }
        this.aZV.a(arrayList, oVar, fx(i), fy(i2));
    }

    public BdListView getListView() {
        return this.aWD;
    }

    private boolean fx(int i) {
        return i > 1;
    }

    private boolean fy(int i) {
        return i == 1;
    }

    public void LP() {
        this.aZV.ca(false);
        this.aZV.cb(false);
        this.aZV.notifyDataSetInvalidated();
    }

    public void fz(int i) {
        this.aWD.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aWT && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aWS = forumData.getFrsBannerData();
            Hy();
            this.aKs.reset();
            this.aWD.removeHeaderView(this.aKs);
            if (this.aWS.getType() == 1 && !TextUtils.isEmpty(this.aWS.rz())) {
                this.aKs.b(this.aWp.getPageContext(), this.aWS.rz());
                if (this.aWS.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWp.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void LQ() {
        if (this.aKs != null) {
            this.aWT = false;
            this.aWD.removeHeaderView(this.aKs);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aZV != null) {
            this.aZV.Lr();
            this.aZV.notifyDataSetChanged();
            this.aZV.onChangeSkinType(i);
        }
        this.aWp.getLayoutMode().ad(i == 1);
        this.aWp.getLayoutMode().k(this.aWw);
        this.mNavigationBar.onChangeSkinType(this.aWp.getPageContext(), i);
        if (this.aMQ != null) {
            this.aMQ.onChangeSkinType(this.aWp.getPageContext(), i);
        }
        if (this.aKs != null) {
            this.aKs.oO();
        }
        if (this.aWW != null) {
            this.aWW.cN(i);
        }
    }

    public void nw() {
        this.aWD.nw();
    }

    public int LS() {
        return 0;
    }

    public bq MJ() {
        return this.aZV;
    }

    public NoPressedRelativeLayout MK() {
        return this.aWw;
    }

    public View LW() {
        return this.aWU;
    }

    public void LZ() {
        if (com.baidu.tbadk.performanceLog.y.DY().DZ()) {
            int lastVisiblePosition = this.aWD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cl) {
                        cl clVar = (cl) childAt.getTag();
                        if (clVar.aTj != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = clVar.aTj.getPerfLog();
                            perfLog.ez(1000);
                            perfLog.axr = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                clVar.aTj.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            clVar.aTj.vo();
                        }
                        if (clVar.aTf != null && (clVar.aTf instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = clVar.aTf;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.ez(1000);
                                    perfLog2.axr = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vo();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bm) {
                        bm bmVar = (bm) childAt.getTag();
                        if (bmVar.aVN != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bmVar.aVN.getPerfLog();
                            perfLog3.ez(1000);
                            perfLog3.axr = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bmVar.aVN.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bmVar.aVN.vo();
                        }
                        if (bmVar.aWe != null && (bmVar.aWe instanceof TbImageView)) {
                            TbImageView tbImageView2 = bmVar.aWe;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.ez(1000);
                            perfLog4.axr = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vo();
                        }
                    }
                    if (childAt.getTag() instanceof br) {
                        br brVar = (br) childAt.getTag();
                        if (brVar.aWt != null && brVar.aWt.aHW != null && (brVar.aWt.aHW instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = brVar.aWt.aHW.getPerfLog();
                            perfLog5.ez(1000);
                            perfLog5.axr = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                brVar.aWt.aHW.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            brVar.aWt.aHW.vo();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (brVar.aHR != null) {
                            arrayList.add(brVar.aHR);
                        }
                        if (brVar.aHS != null) {
                            arrayList.add(brVar.aHS);
                        }
                        if (brVar.aHT != null) {
                            arrayList.add(brVar.aHT);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.ez(1000);
                                perfLog6.axr = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vo();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Ma() {
        this.aWD.setNextPage(this.aWW);
        this.aWW.startLoadData();
    }

    public void Mb() {
        this.aWD.setNextPage(this.aWW);
        this.aWW.vv();
        this.aWW.setText(this.aWp.getResources().getString(i.h.list_no_more));
    }

    public void Mc() {
        this.aWD.setNextPage(null);
    }

    public BdTypeListView ML() {
        return this.aWD;
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aMQ.a(aVar);
        }
    }
}
