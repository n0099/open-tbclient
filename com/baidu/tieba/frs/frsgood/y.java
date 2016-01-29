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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class y {
    private static /* synthetic */ int[] bjU;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aWk;
    private PbListView aXw;
    private com.baidu.tbadk.core.data.m bjJ;
    private View bjL;
    private FrsGoodActivity bjc;
    private cl bnv;
    private NavigationBar mNavigationBar;
    private boolean bji = false;
    private NoPressedRelativeLayout bjj = null;
    private BdTypeListView bjt = null;
    private com.baidu.tbadk.core.dialog.c bjw = null;
    private com.baidu.tbadk.core.view.t mPullView = null;
    private com.baidu.tieba.tbadkCore.t bjD = null;
    com.baidu.tbadk.core.dialog.c bjE = null;
    Animation bjF = null;
    private c.b bjH = null;
    private BannerView bjI = null;
    private boolean bjK = false;
    BannerView.a bjP = new z(this);
    BannerView.a bjQ = new aa(this);
    View bjR = null;

    static /* synthetic */ int[] Qr() {
        int[] iArr = bjU;
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
            bjU = iArr;
        }
        return iArr;
    }

    public y(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.bjc = null;
        this.bjc = frsGoodActivity;
        qD();
    }

    private void qD() {
        this.bjj = (NoPressedRelativeLayout) this.bjc.findViewById(t.g.frs);
        this.mNavigationBar = (NavigationBar) this.bjc.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.bjc.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(t.j.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bjL = this.bjc.findViewById(t.g.frs_list_content);
        this.bjt = (BdTypeListView) this.bjc.findViewById(t.g.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.bjc.getPageContext());
        this.bjt.setDivider(null);
        this.bjt.setPullRefresh(this.mPullView);
        this.bjt.setDividerHeight(0);
        this.bjt.setRecyclerListener(new ab(this));
        this.aXw = new PbListView(this.bjc.getPageContext().getPageActivity());
        this.aXw.ni();
        this.aXw.df(t.d.cp_bg_line_c);
        this.bjt.setOnSrollToBottomListener(this.bjc);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.aa(new ac(this)));
        this.bnv = new cl(this.bjc, this.bjt, ax.wg().wi());
        this.aWk = (NoNetworkView) this.bjc.findViewById(t.g.view_no_network);
        cs(false);
    }

    private void PL() {
        if (this.bjI == null) {
            this.bjI = new BannerView(this.bjc.getPageContext().getPageActivity());
            this.bjI.setLayoutParams(new AbsListView.LayoutParams(-1, this.bjc.getResources().getDimensionPixelSize(t.e.frs_header_banner_height)));
            this.bjI.setVisibility(8);
            this.bjI.setBannerViewClickListener(this.bjQ);
            this.bjI.setBannerViewEvent(new ad(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void PM() {
        if (this.bjJ != null) {
            String value = this.bjJ.getValue();
            if (this.bjJ.sa() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.bjc.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.bjJ.sa() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.bjc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bjc.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bjJ.sa() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.ady != UtilHelper.NativePageType.NONE) {
                    switch (Qr()[isNativeAddress.ady.ordinal()]) {
                        case 2:
                            this.bjc.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bjc.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.bjc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bjc.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                be.wt().c(this.bjc.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bjc.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bjJ.sa() == 4) {
                this.bjc.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bjc.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.ah ahVar, boolean z) {
        String string = this.bjc.getPageContext().getPageActivity().getString(t.j.view);
        String string2 = this.bjc.getPageContext().getPageActivity().getString(t.j.view_host);
        String string3 = this.bjc.getPageContext().getPageActivity().getString(t.j.view_reverse);
        this.bjE = new com.baidu.tbadk.core.dialog.c(this.bjc.getPageContext().getPageActivity());
        this.bjE.cb(t.j.operation);
        if (z) {
            this.bjE.a(new String[]{string, string3}, this.bjH);
        } else {
            this.bjE.a(new String[]{string, string2, string3}, this.bjH);
        }
        this.bjE.d(this.bjc.getPageContext());
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bjt.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.bnv.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bnv.a(wVar);
    }

    public void a(c.b bVar) {
        this.bjH = bVar;
    }

    public void PU() {
        if (this.bjE != null) {
            this.bjE.un();
        }
    }

    public void onDestroy() {
        this.bnv.onDestory();
        this.bjt.setOnSrollToBottomListener(null);
    }

    public void cs(boolean z) {
        this.bji = z;
        if (!z) {
            this.bjt.nr();
        }
    }

    public void KZ() {
        this.bjt.setVisibility(0);
    }

    public void PW() {
        if (this.bnv != null) {
            this.bnv.notifyDataSetChanged();
        }
    }

    public void ct(boolean z) {
        this.bnv.cq(z);
    }

    public void cu(boolean z) {
        this.bnv.cr(z);
    }

    private void PX() {
        if (this.bjw == null) {
            String[] strArr = {this.bjc.getPageContext().getPageActivity().getString(t.j.take_photo), this.bjc.getPageContext().getPageActivity().getString(t.j.album)};
            this.bjw = new com.baidu.tbadk.core.dialog.c(this.bjc.getPageContext().getPageActivity());
            this.bjw.cF(this.bjc.getPageContext().getPageActivity().getString(t.j.operation));
            this.bjw.a(strArr, new ae(this));
            this.bjw.d(this.bjc.getPageContext());
        }
    }

    public void PY() {
        PX();
        if (this.bjw != null) {
            this.bjw.un();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.o oVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            dd ddVar = new dd();
            arrayList = new ArrayList<>();
            arrayList.add(ddVar);
        }
        this.bnv.a(arrayList, oVar, gu(i), gv(i2));
    }

    public BdListView KM() {
        return this.bjt;
    }

    private boolean gu(int i) {
        return i > 1;
    }

    private boolean gv(int i) {
        return i == 1;
    }

    public void QX() {
        this.bnv.cq(false);
        this.bnv.cr(false);
        this.bnv.notifyDataSetInvalidated();
    }

    public void gE(int i) {
        this.bjt.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.bjK && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bjJ = forumData.getFrsBannerData();
            PL();
            this.bjI.reset();
            this.bjt.removeHeaderView(this.bjI);
            if (this.bjJ.getType() == 1 && !TextUtils.isEmpty(this.bjJ.sb())) {
                this.bjI.c(this.bjc.getPageContext(), this.bjJ.sb());
                if (this.bjJ.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bjc.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Qa() {
        if (this.bjI != null) {
            this.bjK = false;
            this.bjt.removeHeaderView(this.bjI);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.bnv != null) {
            this.bnv.Py();
            this.bnv.notifyDataSetChanged();
            this.bnv.onChangeSkinType(i);
        }
        this.bjc.getLayoutMode().ac(i == 1);
        this.bjc.getLayoutMode().x(this.bjj);
        this.mNavigationBar.onChangeSkinType(this.bjc.getPageContext(), i);
        if (this.aWk != null) {
            this.aWk.onChangeSkinType(this.bjc.getPageContext(), i);
        }
        if (this.bjI != null) {
            this.bjI.oO();
        }
        if (this.aXw != null) {
            this.aXw.dg(i);
        }
    }

    public void ns() {
        this.bjt.ns();
    }

    public int Qc() {
        return 0;
    }

    public cl QY() {
        return this.bnv;
    }

    public NoPressedRelativeLayout QZ() {
        return this.bjj;
    }

    public View Qj() {
        return this.bjL;
    }

    public void Qm() {
        if (com.baidu.tbadk.performanceLog.aa.FY().FZ()) {
            int lastVisiblePosition = this.bjt.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bjt.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof dj) {
                        dj djVar = (dj) childAt.getTag();
                        if (djVar.beU != null) {
                            com.baidu.tbadk.performanceLog.u perfLog = djVar.beU.getPerfLog();
                            perfLog.eZ(1000);
                            perfLog.aAD = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                djVar.beU.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            djVar.beU.wQ();
                        }
                        if (djVar.beS != null && (djVar.beS instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = djVar.beS;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.u perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eZ(1000);
                                    perfLog2.aAD = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.wQ();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bt) {
                        bt btVar = (bt) childAt.getTag();
                        if (btVar.bhM != null) {
                            com.baidu.tbadk.performanceLog.u perfLog3 = btVar.bhM.getPerfLog();
                            perfLog3.eZ(1000);
                            perfLog3.aAD = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                btVar.bhM.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            btVar.bhM.wQ();
                        }
                        if (btVar.bij != null && (btVar.bij instanceof TbImageView)) {
                            TbImageView tbImageView2 = btVar.bij;
                            com.baidu.tbadk.performanceLog.u perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eZ(1000);
                            perfLog4.aAD = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.wQ();
                        }
                    }
                    if (childAt.getTag() instanceof cm) {
                        cm cmVar = (cm) childAt.getTag();
                        if (cmVar.bjg != null && cmVar.bjg.aMs != null && (cmVar.bjg.aMs instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.u perfLog5 = cmVar.bjg.aMs.getPerfLog();
                            perfLog5.eZ(1000);
                            perfLog5.aAD = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                cmVar.bjg.aMs.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            cmVar.bjg.aMs.wQ();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (cmVar.aMn != null) {
                            arrayList.add(cmVar.aMn);
                        }
                        if (cmVar.aMo != null) {
                            arrayList.add(cmVar.aMo);
                        }
                        if (cmVar.aMp != null) {
                            arrayList.add(cmVar.aMp);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.u perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eZ(1000);
                                perfLog6.aAD = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.wQ();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Qn() {
        this.bjt.setNextPage(this.aXw);
        this.aXw.xb();
    }

    public void Qo() {
        this.bjt.setNextPage(this.aXw);
        this.aXw.xc();
        this.aXw.setText(this.bjc.getResources().getString(t.j.list_no_more));
    }

    public void Qp() {
        this.bjt.setNextPage(null);
    }

    public BdTypeListView Ra() {
        return this.bjt;
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aWk.a(aVar);
        }
    }
}
