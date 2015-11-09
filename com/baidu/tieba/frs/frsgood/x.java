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
    private static /* synthetic */ int[] aXl;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aMY;
    private FrsGoodActivity aWx;
    private com.baidu.tbadk.core.data.j aXa;
    private View aXc;
    private PbListView aXe;
    private bq bao;
    private NavigationBar mNavigationBar;
    private boolean aWD = false;
    private NoPressedRelativeLayout aWE = null;
    private BdTypeListView aWL = null;
    private com.baidu.tbadk.core.dialog.c aWO = null;
    private com.baidu.tbadk.core.view.r mPullView = null;
    private com.baidu.tieba.tbadkCore.t aWV = null;
    com.baidu.tbadk.core.dialog.c aWW = null;
    Animation aWX = null;
    private c.b aWZ = null;
    private BannerView aJm = null;
    private boolean aXb = false;
    BannerView.a aXh = new y(this);
    BannerView.a aXi = new z(this);
    View aXj = null;

    static /* synthetic */ int[] Mt() {
        int[] iArr = aXl;
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
            aXl = iArr;
        }
        return iArr;
    }

    public x(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.aWx = null;
        this.aWx = frsGoodActivity;
        initUI();
    }

    private void initUI() {
        this.aWE = (NoPressedRelativeLayout) this.aWx.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aWx.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.aWx.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(i.h.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aXc = this.aWx.findViewById(i.f.frs_list_content);
        this.aWL = (BdTypeListView) this.aWx.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.aWx.getPageContext());
        this.aWL.setDivider(null);
        this.aWL.setPullRefresh(this.mPullView);
        this.aWL.setDividerHeight(0);
        this.aWL.setRecyclerListener(new aa(this));
        this.aXe = new PbListView(this.aWx.getPageContext().getPageActivity());
        this.aXe.np();
        this.aXe.cM(i.c.cp_bg_line_c);
        this.aWL.setOnSrollToBottomListener(this.aWx);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new ab(this)));
        this.bao = new bq(this.aWx, this.aWL, at.uK().uM());
        this.aMY = (NoNetworkView) this.aWx.findViewById(i.f.view_no_network);
        ce(false);
    }

    private void Hv() {
        if (this.aJm == null) {
            this.aJm = new BannerView(this.aWx.getPageContext().getPageActivity());
            this.aJm.setLayoutParams(new AbsListView.LayoutParams(-1, this.aWx.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aJm.setVisibility(8);
            this.aJm.setBannerViewClickListener(this.aXi);
            this.aJm.setBannerViewEvent(new ac(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LS() {
        if (this.aXa != null) {
            String value = this.aXa.getValue();
            if (this.aXa.rz() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aWx.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aXa.rz() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWx.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aXa.rz() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.abF != UtilHelper.NativePageType.NONE) {
                    switch (Mt()[isNativeAddress.abF.ordinal()]) {
                        case 2:
                            this.aWx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWx.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWx.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                az.uX().b(this.aWx.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWx.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aXa.rz() == 4) {
                this.aWx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWx.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.w wVar, boolean z) {
        String string = this.aWx.getPageContext().getPageActivity().getString(i.h.view);
        String string2 = this.aWx.getPageContext().getPageActivity().getString(i.h.view_host);
        String string3 = this.aWx.getPageContext().getPageActivity().getString(i.h.view_reverse);
        this.aWW = new com.baidu.tbadk.core.dialog.c(this.aWx.getPageContext().getPageActivity());
        this.aWW.bI(i.h.operation);
        if (z) {
            this.aWW.a(new String[]{string, string3}, this.aWZ);
        } else {
            this.aWW.a(new String[]{string, string2, string3}, this.aWZ);
        }
        this.aWW.d(this.aWx.getPageContext());
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aWL.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.bao.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bao.a(wVar);
    }

    public void c(c.b bVar) {
        this.aWZ = bVar;
    }

    public void LZ() {
        if (this.aWW != null) {
            this.aWW.sU();
        }
    }

    public void onDestroy() {
        this.bao.onDestory();
        this.aWL.setOnSrollToBottomListener(null);
    }

    public void ce(boolean z) {
        this.aWD = z;
        if (!z) {
            this.aWL.completePullRefresh();
        }
    }

    public void Mb() {
        this.aWL.setVisibility(0);
    }

    public void Mc() {
        if (this.bao != null) {
            this.bao.notifyDataSetChanged();
        }
    }

    public void cf(boolean z) {
        this.bao.cc(z);
    }

    public void cg(boolean z) {
        this.bao.cd(z);
    }

    private void Md() {
        if (this.aWO == null) {
            String[] strArr = {this.aWx.getPageContext().getPageActivity().getString(i.h.take_photo), this.aWx.getPageContext().getPageActivity().getString(i.h.album)};
            this.aWO = new com.baidu.tbadk.core.dialog.c(this.aWx.getPageContext().getPageActivity());
            this.aWO.cv(this.aWx.getPageContext().getPageActivity().getString(i.h.operation));
            this.aWO.a(strArr, new ad(this));
            this.aWO.d(this.aWx.getPageContext());
        }
    }

    public void Me() {
        Md();
        if (this.aWO != null) {
            this.aWO.sU();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cd cdVar = new cd();
            arrayList = new ArrayList<>();
            arrayList.add(cdVar);
        }
        this.bao.a(arrayList, oVar, fF(i), fG(i2));
    }

    public BdListView getListView() {
        return this.aWL;
    }

    private boolean fF(int i) {
        return i > 1;
    }

    private boolean fG(int i) {
        return i == 1;
    }

    public void Na() {
        this.bao.cc(false);
        this.bao.cd(false);
        this.bao.notifyDataSetInvalidated();
    }

    public void fS(int i) {
        this.aWL.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aXb && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aXa = forumData.getFrsBannerData();
            Hv();
            this.aJm.reset();
            this.aWL.removeHeaderView(this.aJm);
            if (this.aXa.getType() == 1 && !TextUtils.isEmpty(this.aXa.rA())) {
                this.aJm.b(this.aWx.getPageContext(), this.aXa.rA());
                if (this.aXa.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWx.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Mg() {
        if (this.aJm != null) {
            this.aXb = false;
            this.aWL.removeHeaderView(this.aJm);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.bao != null) {
            this.bao.LH();
            this.bao.notifyDataSetChanged();
            this.bao.onChangeSkinType(i);
        }
        this.aWx.getLayoutMode().ad(i == 1);
        this.aWx.getLayoutMode().k(this.aWE);
        this.mNavigationBar.onChangeSkinType(this.aWx.getPageContext(), i);
        if (this.aMY != null) {
            this.aMY.onChangeSkinType(this.aWx.getPageContext(), i);
        }
        if (this.aJm != null) {
            this.aJm.oP();
        }
        if (this.aXe != null) {
            this.aXe.cN(i);
        }
    }

    public void nx() {
        this.aWL.nx();
    }

    public int Mi() {
        return 0;
    }

    public bq Nb() {
        return this.bao;
    }

    public NoPressedRelativeLayout Nc() {
        return this.aWE;
    }

    public View Mm() {
        return this.aXc;
    }

    public void Mp() {
        if (com.baidu.tbadk.performanceLog.y.DR().DS()) {
            int lastVisiblePosition = this.aWL.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWL.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cl) {
                        cl clVar = (cl) childAt.getTag();
                        if (clVar.aTr != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = clVar.aTr.getPerfLog();
                            perfLog.ex(1000);
                            perfLog.awg = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                clVar.aTr.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            clVar.aTr.vs();
                        }
                        if (clVar.aTn != null && (clVar.aTn instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = clVar.aTn;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.ex(1000);
                                    perfLog2.awg = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vs();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bm) {
                        bm bmVar = (bm) childAt.getTag();
                        if (bmVar.aVV != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bmVar.aVV.getPerfLog();
                            perfLog3.ex(1000);
                            perfLog3.awg = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bmVar.aVV.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bmVar.aVV.vs();
                        }
                        if (bmVar.aWm != null && (bmVar.aWm instanceof TbImageView)) {
                            TbImageView tbImageView2 = bmVar.aWm;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.ex(1000);
                            perfLog4.awg = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vs();
                        }
                    }
                    if (childAt.getTag() instanceof br) {
                        br brVar = (br) childAt.getTag();
                        if (brVar.aWB != null && brVar.aWB.aGQ != null && (brVar.aWB.aGQ instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = brVar.aWB.aGQ.getPerfLog();
                            perfLog5.ex(1000);
                            perfLog5.awg = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                brVar.aWB.aGQ.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            brVar.aWB.aGQ.vs();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (brVar.aGL != null) {
                            arrayList.add(brVar.aGL);
                        }
                        if (brVar.aGM != null) {
                            arrayList.add(brVar.aGM);
                        }
                        if (brVar.aGN != null) {
                            arrayList.add(brVar.aGN);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.ex(1000);
                                perfLog6.awg = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vs();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Mq() {
        this.aWL.setNextPage(this.aXe);
        this.aXe.startLoadData();
    }

    public void Mr() {
        this.aWL.setNextPage(this.aXe);
        this.aXe.vz();
        this.aXe.setText(this.aWx.getResources().getString(i.h.list_no_more));
    }

    public void Ms() {
        this.aWL.setNextPage(null);
    }

    public BdTypeListView Nd() {
        return this.aWL;
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aMY.a(aVar);
        }
    }
}
