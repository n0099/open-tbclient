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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class x {
    private static /* synthetic */ int[] aXx;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aNK;
    private FrsGoodActivity aWL;
    private com.baidu.tbadk.core.data.j aXn;
    private View aXp;
    private PbListView aXr;
    private bg aZR;
    private NavigationBar mNavigationBar;
    private boolean aWR = false;
    private NoPressedRelativeLayout aWS = null;
    private BdTypeListView aWY = null;
    private com.baidu.tbadk.core.dialog.c aXb = null;
    private com.baidu.tbadk.core.view.z mPullView = null;
    private com.baidu.tieba.tbadkCore.t aXi = null;
    com.baidu.tbadk.core.dialog.c aXj = null;
    Animation aXk = null;
    private c.b aXm = null;
    private BannerView aLp = null;
    private boolean aXo = false;
    BannerView.a aXt = new y(this);
    BannerView.a aXu = new z(this);
    View aXv = null;

    static /* synthetic */ int[] Mi() {
        int[] iArr = aXx;
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
            aXx = iArr;
        }
        return iArr;
    }

    public x(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.aWL = null;
        this.aWL = frsGoodActivity;
        initUI();
    }

    private void initUI() {
        this.aWS = (NoPressedRelativeLayout) this.aWL.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aWL.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.aWL.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(i.h.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aXp = this.aWL.findViewById(i.f.frs_list_content);
        this.aWY = (BdTypeListView) this.aWL.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.z(this.aWL.getPageContext());
        this.aWY.setDivider(null);
        this.aWY.setPullRefresh(this.mPullView);
        this.aWY.setDividerHeight(0);
        this.aWY.setRecyclerListener(new aa(this));
        this.aXr = new PbListView(this.aWL.getPageContext().getPageActivity());
        this.aXr.nn();
        this.aXr.cL(i.c.cp_bg_line_c);
        this.aWY.setOnSrollToBottomListener(this.aWL);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new ab(this)));
        this.aZR = new bg(this.aWL, this.aWY, ar.uK().uM());
        this.aNK = (NoNetworkView) this.aWL.findViewById(i.f.view_no_network);
        cf(false);
    }

    private void HI() {
        if (this.aLp == null) {
            this.aLp = new BannerView(this.aWL.getPageContext().getPageActivity());
            this.aLp.setLayoutParams(new AbsListView.LayoutParams(-1, this.aWL.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aLp.setVisibility(8);
            this.aLp.setBannerViewClickListener(this.aXu);
            this.aLp.setBannerViewEvent(new ac(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LH() {
        if (this.aXn != null) {
            String value = this.aXn.getValue();
            if (this.aXn.rG() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aWL.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aXn.rG() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aWL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWL.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aXn.rG() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.aby != UtilHelper.NativePageType.NONE) {
                    switch (Mi()[isNativeAddress.aby.ordinal()]) {
                        case 2:
                            this.aWL.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWL.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aWL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWL.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                ax.uX().b(this.aWL.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWL.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aXn.rG() == 4) {
                this.aWL.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWL.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.x xVar, boolean z) {
        String string = this.aWL.getPageContext().getPageActivity().getString(i.h.view);
        String string2 = this.aWL.getPageContext().getPageActivity().getString(i.h.view_host);
        String string3 = this.aWL.getPageContext().getPageActivity().getString(i.h.view_reverse);
        this.aXj = new com.baidu.tbadk.core.dialog.c(this.aWL.getPageContext().getPageActivity());
        this.aXj.bI(i.h.operation);
        if (z) {
            this.aXj.a(new String[]{string, string3}, this.aXm);
        } else {
            this.aXj.a(new String[]{string, string2, string3}, this.aXm);
        }
        this.aXj.d(this.aWL.getPageContext());
    }

    public void a(x.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aWY.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.aZR.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.aZR.a(wVar);
    }

    public void b(c.b bVar) {
        this.aXm = bVar;
    }

    public void LO() {
        if (this.aXj != null) {
            this.aXj.sX();
        }
    }

    public void onDestroy() {
        this.aZR.onDestory();
        this.aWY.setOnSrollToBottomListener(null);
    }

    public void cf(boolean z) {
        this.aWR = z;
        if (!z) {
            this.aWY.completePullRefresh();
        }
    }

    public void LQ() {
        this.aWY.setVisibility(0);
    }

    public void LR() {
        if (this.aZR != null) {
            this.aZR.notifyDataSetChanged();
        }
    }

    public void cg(boolean z) {
        this.aZR.cd(z);
    }

    public void ch(boolean z) {
        this.aZR.ce(z);
    }

    private void LS() {
        if (this.aXb == null) {
            String[] strArr = {this.aWL.getPageContext().getPageActivity().getString(i.h.take_photo), this.aWL.getPageContext().getPageActivity().getString(i.h.album)};
            this.aXb = new com.baidu.tbadk.core.dialog.c(this.aWL.getPageContext().getPageActivity());
            this.aXb.cu(this.aWL.getPageContext().getPageActivity().getString(i.h.operation));
            this.aXb.a(strArr, new ad(this));
            this.aXb.d(this.aWL.getPageContext());
        }
    }

    public void LT() {
        LS();
        if (this.aXb != null) {
            this.aXb.sX();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            bt btVar = new bt();
            arrayList = new ArrayList<>();
            arrayList.add(btVar);
        }
        this.aZR.a(arrayList, oVar, fs(i), ft(i2));
    }

    public BdListView getListView() {
        return this.aWY;
    }

    private boolean fs(int i) {
        return i > 1;
    }

    private boolean ft(int i) {
        return i == 1;
    }

    public void LU() {
        this.aZR.cd(false);
        this.aZR.ce(false);
        this.aZR.notifyDataSetInvalidated();
    }

    public void fu(int i) {
        this.aWY.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aXo && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aXn = forumData.getFrsBannerData();
            HI();
            this.aLp.reset();
            this.aWY.removeHeaderView(this.aLp);
            if (this.aXn.getType() == 1 && !TextUtils.isEmpty(this.aXn.rH())) {
                this.aLp.b(this.aWL.getPageContext(), this.aXn.rH());
                if (this.aXn.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWL.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void LV() {
        if (this.aLp != null) {
            this.aXo = false;
            this.aWY.removeHeaderView(this.aLp);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cM(i);
        }
        if (this.aZR != null) {
            this.aZR.Lx();
            this.aZR.notifyDataSetChanged();
            this.aZR.onChangeSkinType(i);
        }
        this.aWL.getLayoutMode().ad(i == 1);
        this.aWL.getLayoutMode().k(this.aWS);
        this.mNavigationBar.onChangeSkinType(this.aWL.getPageContext(), i);
        if (this.aNK != null) {
            this.aNK.onChangeSkinType(this.aWL.getPageContext(), i);
        }
        if (this.aLp != null) {
            this.aLp.oN();
        }
        if (this.aXr != null) {
            this.aXr.cM(i);
        }
    }

    public void nv() {
        this.aWY.nv();
    }

    public int LX() {
        return 0;
    }

    public bg MO() {
        return this.aZR;
    }

    public NoPressedRelativeLayout MP() {
        return this.aWS;
    }

    public View Mb() {
        return this.aXp;
    }

    public void Me() {
        if (com.baidu.tbadk.performanceLog.y.Eo().Ep()) {
            int lastVisiblePosition = this.aWY.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWY.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cb) {
                        cb cbVar = (cb) childAt.getTag();
                        if (cbVar.aUc != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = cbVar.aUc.getPerfLog();
                            perfLog.ey(1000);
                            perfLog.ayR = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                cbVar.aUc.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            cbVar.aUc.vz();
                        }
                        if (cbVar.aTY != null && (cbVar.aTY instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = cbVar.aTY;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.ey(1000);
                                    perfLog2.ayR = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vz();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bc) {
                        bc bcVar = (bc) childAt.getTag();
                        if (bcVar.aWv != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bcVar.aWv.getPerfLog();
                            perfLog3.ey(1000);
                            perfLog3.ayR = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bcVar.aWv.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bcVar.aWv.vz();
                        }
                        if (bcVar.aWz != null && (bcVar.aWz instanceof TbImageView)) {
                            TbImageView tbImageView2 = bcVar.aWz;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.ey(1000);
                            perfLog4.ayR = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vz();
                        }
                    }
                    if (childAt.getTag() instanceof bh) {
                        bh bhVar = (bh) childAt.getTag();
                        if (bhVar.aWP != null && bhVar.aWP.aIT != null && (bhVar.aWP.aIT instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = bhVar.aWP.aIT.getPerfLog();
                            perfLog5.ey(1000);
                            perfLog5.ayR = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                bhVar.aWP.aIT.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bhVar.aWP.aIT.vz();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (bhVar.aIO != null) {
                            arrayList.add(bhVar.aIO);
                        }
                        if (bhVar.aIP != null) {
                            arrayList.add(bhVar.aIP);
                        }
                        if (bhVar.aIQ != null) {
                            arrayList.add(bhVar.aIQ);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.ey(1000);
                                perfLog6.ayR = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vz();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Mf() {
        this.aWY.setNextPage(this.aXr);
        this.aXr.startLoadData();
    }

    public void Mg() {
        this.aWY.setNextPage(this.aXr);
        this.aXr.vG();
        this.aXr.setText(this.aWL.getResources().getString(i.h.list_no_more));
    }

    public void Mh() {
        this.aWY.setNextPage(null);
    }

    public BdTypeListView MQ() {
        return this.aWY;
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aNK.a(aVar);
        }
    }
}
