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
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class x {
    private static /* synthetic */ int[] aXB;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aNx;
    private FrsGoodActivity aWu;
    private com.baidu.tbadk.core.data.j aXq;
    private View aXs;
    private PbListView aXu;
    private bf aZy;
    private NavigationBar mNavigationBar;
    private boolean aWR = false;
    private NoPressedRelativeLayout aWS = null;
    private BdTypeListView aWY = null;
    private com.baidu.tbadk.core.dialog.c aXb = null;
    private com.baidu.tbadk.core.view.z mPullView = null;
    private com.baidu.tieba.tbadkCore.s aXi = null;
    com.baidu.tbadk.core.dialog.c aXj = null;
    Animation aXk = null;
    private c.b aXm = null;
    private BannerView aLc = null;
    private boolean aXr = false;
    BannerView.a aXx = new y(this);
    BannerView.a aXy = new z(this);
    View aXz = null;

    static /* synthetic */ int[] Mr() {
        int[] iArr = aXB;
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
            aXB = iArr;
        }
        return iArr;
    }

    public x(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.aWu = null;
        this.aWu = frsGoodActivity;
        initUI();
    }

    private void initUI() {
        this.aWS = (NoPressedRelativeLayout) this.aWu.findViewById(i.f.frs);
        this.mNavigationBar = (NavigationBar) this.aWu.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.aWu.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(i.C0057i.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aXs = this.aWu.findViewById(i.f.frs_list_content);
        this.aWY = (BdTypeListView) this.aWu.findViewById(i.f.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.z(this.aWu.getPageContext());
        this.aWY.setDivider(null);
        this.aWY.setPullRefresh(this.mPullView);
        this.aWY.setDividerHeight(0);
        this.aWY.setRecyclerListener(new aa(this));
        this.aXu = new PbListView(this.aWu.getPageContext().getPageActivity());
        this.aXu.nq();
        this.aXu.cF(i.c.cp_bg_line_c);
        this.aWY.setOnSrollToBottomListener(this.aWu);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.z(new ab(this)));
        this.aZy = new bf(this.aWu, this.aWY, ar.uE().uG());
        this.aNx = (NoNetworkView) this.aWu.findViewById(i.f.view_no_network);
        ca(false);
    }

    private void HU() {
        if (this.aLc == null) {
            this.aLc = new BannerView(this.aWu.getPageContext().getPageActivity());
            this.aLc.setLayoutParams(new AbsListView.LayoutParams(-1, this.aWu.getResources().getDimensionPixelSize(i.d.frs_header_banner_height)));
            this.aLc.setVisibility(8);
            this.aLc.setBannerViewClickListener(this.aXy);
            this.aLc.setBannerViewEvent(new ac(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void LQ() {
        if (this.aXq != null) {
            String value = this.aXq.getValue();
            if (this.aXq.rH() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.aWu.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.aXq.rH() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.aWu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWu.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.aXq.rH() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.abo != UtilHelper.NativePageType.NONE) {
                    switch (Mr()[isNativeAddress.abo.ordinal()]) {
                        case 2:
                            this.aWu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWu.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.aWu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aWu.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                ax.uR().b(this.aWu.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWu.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.aXq.rH() == 4) {
                this.aWu.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aWu.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.v vVar, boolean z) {
        String string = this.aWu.getPageContext().getPageActivity().getString(i.C0057i.view);
        String string2 = this.aWu.getPageContext().getPageActivity().getString(i.C0057i.view_host);
        String string3 = this.aWu.getPageContext().getPageActivity().getString(i.C0057i.view_reverse);
        this.aXj = new com.baidu.tbadk.core.dialog.c(this.aWu.getPageContext().getPageActivity());
        this.aXj.bF(i.C0057i.operation);
        if (z) {
            this.aXj.a(new String[]{string, string3}, this.aXm);
        } else {
            this.aXj.a(new String[]{string, string2, string3}, this.aXm);
        }
        this.aXj.d(this.aWu.getPageContext());
    }

    public void a(x.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aWY.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.aZy.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.aZy.a(wVar);
    }

    public void a(c.b bVar) {
        this.aXm = bVar;
    }

    public void LX() {
        if (this.aXj != null) {
            this.aXj.sS();
        }
    }

    public void onDestroy() {
        this.aZy.onDestory();
        this.aWY.setOnSrollToBottomListener(null);
    }

    public void ca(boolean z) {
        this.aWR = z;
        if (!z) {
            this.aWY.completePullRefresh();
        }
    }

    public void LZ() {
        this.aWY.setVisibility(0);
    }

    public void Ma() {
        if (this.aZy != null) {
            this.aZy.notifyDataSetChanged();
        }
    }

    public void cb(boolean z) {
        this.aZy.bY(z);
    }

    public void cc(boolean z) {
        this.aZy.bZ(z);
    }

    private void Mb() {
        if (this.aXb == null) {
            String[] strArr = {this.aWu.getPageContext().getPageActivity().getString(i.C0057i.take_photo), this.aWu.getPageContext().getPageActivity().getString(i.C0057i.album)};
            this.aXb = new com.baidu.tbadk.core.dialog.c(this.aWu.getPageContext().getPageActivity());
            this.aXb.co(this.aWu.getPageContext().getPageActivity().getString(i.C0057i.operation));
            this.aXb.a(strArr, new ad(this));
            this.aXb.d(this.aWu.getPageContext());
        }
    }

    public void Mc() {
        Mb();
        if (this.aXb != null) {
            this.aXb.sS();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.n nVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            bx bxVar = new bx();
            arrayList = new ArrayList<>();
            arrayList.add(bxVar);
        }
        this.aZy.a(arrayList, nVar, fn(i), fo(i2));
    }

    public BdListView getListView() {
        return this.aWY;
    }

    private boolean fn(int i) {
        return i > 1;
    }

    private boolean fo(int i) {
        return i == 1;
    }

    public void Md() {
        this.aZy.bY(false);
        this.aZy.bZ(false);
        this.aZy.notifyDataSetInvalidated();
    }

    public void fp(int i) {
        this.aWY.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.aXr && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.aXq = forumData.getFrsBannerData();
            HU();
            this.aLc.reset();
            this.aWY.removeHeaderView(this.aLc);
            if (this.aXq.getType() == 1 && !TextUtils.isEmpty(this.aXq.rI())) {
                this.aLc.b(this.aWu.getPageContext(), this.aXq.rI());
                if (this.aXq.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.aWu.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Me() {
        if (this.aLc != null) {
            this.aXr = false;
            this.aWY.removeHeaderView(this.aLc);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cG(i);
        }
        if (this.aZy != null) {
            this.aZy.LG();
            this.aZy.notifyDataSetChanged();
            this.aZy.onChangeSkinType(i);
        }
        this.aWu.getLayoutMode().ad(i == 1);
        this.aWu.getLayoutMode().k(this.aWS);
        this.mNavigationBar.onChangeSkinType(this.aWu.getPageContext(), i);
        if (this.aNx != null) {
            this.aNx.onChangeSkinType(this.aWu.getPageContext(), i);
        }
        if (this.aLc != null) {
            this.aLc.oQ();
        }
        if (this.aXu != null) {
            this.aXu.cG(i);
        }
    }

    public void ny() {
        this.aWY.ny();
    }

    public int Mg() {
        return 0;
    }

    public bf MO() {
        return this.aZy;
    }

    public NoPressedRelativeLayout MP() {
        return this.aWS;
    }

    public View Mk() {
        return this.aXs;
    }

    public void Mn() {
        if (com.baidu.tbadk.performanceLog.y.Ee().Ef()) {
            int lastVisiblePosition = this.aWY.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.aWY.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof cf) {
                        cf cfVar = (cf) childAt.getTag();
                        if (cfVar.aTO != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = cfVar.aTO.getPerfLog();
                            perfLog.eq(1000);
                            perfLog.axj = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                cfVar.aTO.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            cfVar.aTO.vu();
                        }
                        if (cfVar.aTK != null && (cfVar.aTK instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = cfVar.aTK;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eq(1000);
                                    perfLog2.axj = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vu();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bb) {
                        bb bbVar = (bb) childAt.getTag();
                        if (bbVar.aWe != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = bbVar.aWe.getPerfLog();
                            perfLog3.eq(1000);
                            perfLog3.axj = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                bbVar.aWe.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bbVar.aWe.vu();
                        }
                        if (bbVar.aWi != null && (bbVar.aWi instanceof TbImageView)) {
                            TbImageView tbImageView2 = bbVar.aWi;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eq(1000);
                            perfLog4.axj = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vu();
                        }
                    }
                    if (childAt.getTag() instanceof bg) {
                        bg bgVar = (bg) childAt.getTag();
                        if (bgVar.aWx != null && bgVar.aWx.aIG != null && (bgVar.aWx.aIG instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = bgVar.aWx.aIG.getPerfLog();
                            perfLog5.eq(1000);
                            perfLog5.axj = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                bgVar.aWx.aIG.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            bgVar.aWx.aIG.vu();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (bgVar.aIB != null) {
                            arrayList.add(bgVar.aIB);
                        }
                        if (bgVar.aIC != null) {
                            arrayList.add(bgVar.aIC);
                        }
                        if (bgVar.aID != null) {
                            arrayList.add(bgVar.aID);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eq(1000);
                                perfLog6.axj = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vu();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Mo() {
        this.aWY.setNextPage(this.aXu);
        this.aXu.startLoadData();
    }

    public void Mp() {
        this.aWY.setNextPage(this.aXu);
        this.aXu.vB();
        this.aXu.setText(this.aWu.getResources().getString(i.C0057i.list_no_more));
    }

    public void Mq() {
        this.aWY.setNextPage(null);
    }

    public BdTypeListView MQ() {
        return this.aWY;
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aNx.a(aVar);
        }
    }
}
