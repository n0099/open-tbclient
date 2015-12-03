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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class x {
    private static /* synthetic */ int[] bdf;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aQl;
    private PbListView aRt;
    private com.baidu.tbadk.core.data.j bcV;
    private View bcX;
    private FrsGoodActivity bcs;
    private cb bgH;
    private NavigationBar mNavigationBar;
    private boolean bcy = false;
    private NoPressedRelativeLayout bcz = null;
    private BdTypeListView bcG = null;
    private com.baidu.tbadk.core.dialog.c bcJ = null;
    private com.baidu.tbadk.core.view.s mPullView = null;
    private com.baidu.tieba.tbadkCore.u bcQ = null;
    com.baidu.tbadk.core.dialog.c bcR = null;
    Animation bcS = null;
    private c.b bcU = null;
    private BannerView aNN = null;
    private boolean bcW = false;
    BannerView.a bdb = new y(this);
    BannerView.a bdc = new z(this);
    View bdd = null;

    static /* synthetic */ int[] NV() {
        int[] iArr = bdf;
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
            bdf = iArr;
        }
        return iArr;
    }

    public x(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.bcs = null;
        this.bcs = frsGoodActivity;
        initUI();
    }

    private void initUI() {
        this.bcz = (NoPressedRelativeLayout) this.bcs.findViewById(n.f.frs);
        this.mNavigationBar = (NavigationBar) this.bcs.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.bcs.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(n.i.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bcX = this.bcs.findViewById(n.f.frs_list_content);
        this.bcG = (BdTypeListView) this.bcs.findViewById(n.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.s(this.bcs.getPageContext());
        this.bcG.setDivider(null);
        this.bcG.setPullRefresh(this.mPullView);
        this.bcG.setDividerHeight(0);
        this.bcG.setRecyclerListener(new aa(this));
        this.aRt = new PbListView(this.bcs.getPageContext().getPageActivity());
        this.aRt.nv();
        this.aRt.cU(n.c.cp_bg_line_c);
        this.bcG.setOnSrollToBottomListener(this.bcs);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ab(new ab(this)));
        this.bgH = new cb(this.bcs, this.bcG, ay.vq().vs());
        this.aQl = (NoNetworkView) this.bcs.findViewById(n.f.view_no_network);
        cr(false);
    }

    private void IO() {
        if (this.aNN == null) {
            this.aNN = new BannerView(this.bcs.getPageContext().getPageActivity());
            this.aNN.setLayoutParams(new AbsListView.LayoutParams(-1, this.bcs.getResources().getDimensionPixelSize(n.d.frs_header_banner_height)));
            this.aNN.setVisibility(8);
            this.aNN.setBannerViewClickListener(this.bdc);
            this.aNN.setBannerViewEvent(new ac(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Nt() {
        if (this.bcV != null) {
            String value = this.bcV.getValue();
            if (this.bcV.rN() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.bcs.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.bcV.rN() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.bcs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bcs.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bcV.rN() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.acx != UtilHelper.NativePageType.NONE) {
                    switch (NV()[isNativeAddress.acx.ordinal()]) {
                        case 2:
                            this.bcs.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bcs.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.bcs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bcs.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                bf.vD().b(this.bcs.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bcs.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bcV.rN() == 4) {
                this.bcs.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bcs.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.z zVar, boolean z) {
        String string = this.bcs.getPageContext().getPageActivity().getString(n.i.view);
        String string2 = this.bcs.getPageContext().getPageActivity().getString(n.i.view_host);
        String string3 = this.bcs.getPageContext().getPageActivity().getString(n.i.view_reverse);
        this.bcR = new com.baidu.tbadk.core.dialog.c(this.bcs.getPageContext().getPageActivity());
        this.bcR.bQ(n.i.operation);
        if (z) {
            this.bcR.a(new String[]{string, string3}, this.bcU);
        } else {
            this.bcR.a(new String[]{string, string2, string3}, this.bcU);
        }
        this.bcR.d(this.bcs.getPageContext());
    }

    public void a(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bcG.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.bgH.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bgH.a(wVar);
    }

    public void c(c.b bVar) {
        this.bcU = bVar;
    }

    public void NA() {
        if (this.bcR != null) {
            this.bcR.tz();
        }
    }

    public void onDestroy() {
        this.bgH.onDestory();
        this.bcG.setOnSrollToBottomListener(null);
    }

    public void cr(boolean z) {
        this.bcy = z;
        if (!z) {
            this.bcG.completePullRefresh();
        }
    }

    public void NC() {
        this.bcG.setVisibility(0);
    }

    public void ND() {
        if (this.bgH != null) {
            this.bgH.notifyDataSetChanged();
        }
    }

    public void cs(boolean z) {
        this.bgH.cp(z);
    }

    public void ct(boolean z) {
        this.bgH.cq(z);
    }

    private void NE() {
        if (this.bcJ == null) {
            String[] strArr = {this.bcs.getPageContext().getPageActivity().getString(n.i.take_photo), this.bcs.getPageContext().getPageActivity().getString(n.i.album)};
            this.bcJ = new com.baidu.tbadk.core.dialog.c(this.bcs.getPageContext().getPageActivity());
            this.bcJ.cD(this.bcs.getPageContext().getPageActivity().getString(n.i.operation));
            this.bcJ.a(strArr, new ad(this));
            this.bcJ.d(this.bcs.getPageContext());
        }
    }

    public void NF() {
        NE();
        if (this.bcJ != null) {
            this.bcJ.tz();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.p pVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            ct ctVar = new ct();
            arrayList = new ArrayList<>();
            arrayList.add(ctVar);
        }
        this.bgH.a(arrayList, pVar, gc(i), gd(i2));
    }

    public BdListView getListView() {
        return this.bcG;
    }

    private boolean gc(int i) {
        return i > 1;
    }

    private boolean gd(int i) {
        return i == 1;
    }

    public void OC() {
        this.bgH.cp(false);
        this.bgH.cq(false);
        this.bgH.notifyDataSetInvalidated();
    }

    public void go(int i) {
        this.bcG.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.bcW && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bcV = forumData.getFrsBannerData();
            IO();
            this.aNN.reset();
            this.bcG.removeHeaderView(this.aNN);
            if (this.bcV.getType() == 1 && !TextUtils.isEmpty(this.bcV.rO())) {
                this.aNN.c(this.bcs.getPageContext(), this.bcV.rO());
                if (this.bcV.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bcs.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void NH() {
        if (this.aNN != null) {
            this.bcW = false;
            this.bcG.removeHeaderView(this.aNN);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.bgH != null) {
            this.bgH.Nf();
            this.bgH.notifyDataSetChanged();
            this.bgH.onChangeSkinType(i);
        }
        this.bcs.getLayoutMode().af(i == 1);
        this.bcs.getLayoutMode().k(this.bcz);
        this.mNavigationBar.onChangeSkinType(this.bcs.getPageContext(), i);
        if (this.aQl != null) {
            this.aQl.onChangeSkinType(this.bcs.getPageContext(), i);
        }
        if (this.aNN != null) {
            this.aNN.oV();
        }
        if (this.aRt != null) {
            this.aRt.cV(i);
        }
    }

    public void nD() {
        this.bcG.nD();
    }

    public int NJ() {
        return 0;
    }

    public cb OD() {
        return this.bgH;
    }

    public NoPressedRelativeLayout OE() {
        return this.bcz;
    }

    public View NN() {
        return this.bcX;
    }

    public void NQ() {
        if (com.baidu.tbadk.performanceLog.y.ES().ET()) {
            int lastVisiblePosition = this.bcG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bcG.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof db) {
                        db dbVar = (db) childAt.getTag();
                        if (dbVar.aYF != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = dbVar.aYF.getPerfLog();
                            perfLog.eL(1000);
                            perfLog.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                dbVar.aYF.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            dbVar.aYF.vY();
                        }
                        if (dbVar.aYB != null && (dbVar.aYB instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = dbVar.aYB;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eL(1000);
                                    perfLog2.ayl = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vY();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bl) {
                        bl blVar = (bl) childAt.getTag();
                        if (blVar.bbl != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = blVar.bbl.getPerfLog();
                            perfLog3.eL(1000);
                            perfLog3.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                blVar.bbl.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            blVar.bbl.vY();
                        }
                        if (blVar.bbD != null && (blVar.bbD instanceof TbImageView)) {
                            TbImageView tbImageView2 = blVar.bbD;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eL(1000);
                            perfLog4.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vY();
                        }
                    }
                    if (childAt.getTag() instanceof cc) {
                        cc ccVar = (cc) childAt.getTag();
                        if (ccVar.bcw != null && ccVar.bcw.aJP != null && (ccVar.bcw.aJP instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = ccVar.bcw.aJP.getPerfLog();
                            perfLog5.eL(1000);
                            perfLog5.ayl = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                ccVar.bcw.aJP.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            ccVar.bcw.aJP.vY();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (ccVar.aJK != null) {
                            arrayList.add(ccVar.aJK);
                        }
                        if (ccVar.aJL != null) {
                            arrayList.add(ccVar.aJL);
                        }
                        if (ccVar.aJM != null) {
                            arrayList.add(ccVar.aJM);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eL(1000);
                                perfLog6.ayl = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vY();
                            }
                        }
                    }
                }
            }
        }
    }

    public void NR() {
        this.bcG.setNextPage(this.aRt);
        this.aRt.startLoadData();
    }

    public void NS() {
        this.bcG.setNextPage(this.aRt);
        this.aRt.wf();
        this.aRt.setText(this.bcs.getResources().getString(n.i.list_no_more));
    }

    public void NT() {
        this.bcG.setNextPage(null);
    }

    public BdTypeListView OF() {
        return this.bcG;
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aQl.a(aVar);
        }
    }
}
