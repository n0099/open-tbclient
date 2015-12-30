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
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cw;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class x {
    private static /* synthetic */ int[] bhf;
    private static final Pattern pbPattern0 = Pattern.compile("(/p/){1}(\\d+)");
    private NoNetworkView aUd;
    private PbListView aVj;
    private com.baidu.tbadk.core.data.j bgV;
    private View bgX;
    private FrsGoodActivity bgr;
    private ce bky;
    private NavigationBar mNavigationBar;
    private boolean bgy = false;
    private NoPressedRelativeLayout bgz = null;
    private BdTypeListView bgG = null;
    private com.baidu.tbadk.core.dialog.c bgJ = null;
    private com.baidu.tbadk.core.view.t mPullView = null;
    private com.baidu.tieba.tbadkCore.u bgQ = null;
    com.baidu.tbadk.core.dialog.c bgR = null;
    Animation bgS = null;
    private c.b bgU = null;
    private BannerView aRF = null;
    private boolean bgW = false;
    BannerView.a bhb = new y(this);
    BannerView.a bhc = new z(this);
    View bhd = null;

    static /* synthetic */ int[] Oo() {
        int[] iArr = bhf;
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
            bhf = iArr;
        }
        return iArr;
    }

    public x(FrsGoodActivity frsGoodActivity, View.OnClickListener onClickListener) {
        this.bgr = null;
        this.bgr = frsGoodActivity;
        initUI();
    }

    private void initUI() {
        this.bgz = (NoPressedRelativeLayout) this.bgr.findViewById(n.g.frs);
        this.mNavigationBar = (NavigationBar) this.bgr.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar = (NavigationBar) this.bgr.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(n.j.frs_good);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bgX = this.bgr.findViewById(n.g.frs_list_content);
        this.bgG = (BdTypeListView) this.bgr.findViewById(n.g.frs_lv_thread);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.bgr.getPageContext());
        this.bgG.setDivider(null);
        this.bgG.setPullRefresh(this.mPullView);
        this.bgG.setDividerHeight(0);
        this.bgG.setRecyclerListener(new aa(this));
        this.aVj = new PbListView(this.bgr.getPageContext().getPageActivity());
        this.aVj.mT();
        this.aVj.cO(n.d.cp_bg_line_c);
        this.bgG.setOnSrollToBottomListener(this.bgr);
        this.mNavigationBar.setOnTouchListener(new com.baidu.tieba.tbadkCore.ab(new ab(this)));
        this.bky = new ce(this.bgr, this.bgG, ay.va().vc());
        this.aUd = (NoNetworkView) this.bgr.findViewById(n.g.view_no_network);
        cs(false);
    }

    private void Jf() {
        if (this.aRF == null) {
            this.aRF = new BannerView(this.bgr.getPageContext().getPageActivity());
            this.aRF.setLayoutParams(new AbsListView.LayoutParams(-1, this.bgr.getResources().getDimensionPixelSize(n.e.frs_header_banner_height)));
            this.aRF.setVisibility(8);
            this.aRF.setBannerViewClickListener(this.bhc);
            this.aRF.setBannerViewEvent(new ac(this));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void NM() {
        if (this.bgV != null) {
            String value = this.bgV.getValue();
            if (this.bgV.rw() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEPACKAGEDETAIL, new FacePackageDetailActivityConfig(this.bgr.getPageContext().getPageActivity(), value, false, "frs_banner")));
            } else if (this.bgV.rw() == 2) {
                if (value.contains("tieba.baidu.com")) {
                    Matcher matcher = pbPattern0.matcher(value);
                    if (matcher.find()) {
                        try {
                            this.bgr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bgr.getPageContext().getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner")));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (this.bgV.rw() == 3) {
                new UtilHelper.a();
                UtilHelper.a isNativeAddress = UtilHelper.isNativeAddress(value);
                if (isNativeAddress.adb != UtilHelper.NativePageType.NONE) {
                    switch (Oo()[isNativeAddress.adb.ordinal()]) {
                        case 2:
                            this.bgr.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bgr.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                            return;
                        case 3:
                            this.bgr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bgr.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner")));
                            return;
                        default:
                            return;
                    }
                }
                bf.vn().b(this.bgr.getPageContext(), new String[]{value});
                if (!StringUtils.isNull(value) && value.startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bgr.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else if (this.bgV.rw() == 4) {
                this.bgr.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.bgr.getPageContext().getPageActivity()).createNormalCfg(value, "frs_banner")));
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.z zVar, boolean z) {
        String string = this.bgr.getPageContext().getPageActivity().getString(n.j.view);
        String string2 = this.bgr.getPageContext().getPageActivity().getString(n.j.view_host);
        String string3 = this.bgr.getPageContext().getPageActivity().getString(n.j.view_reverse);
        this.bgR = new com.baidu.tbadk.core.dialog.c(this.bgr.getPageContext().getPageActivity());
        this.bgR.bJ(n.j.operation);
        if (z) {
            this.bgR.a(new String[]{string, string3}, this.bgU);
        } else {
            this.bgR.a(new String[]{string, string2, string3}, this.bgU);
        }
        this.bgR.d(this.bgr.getPageContext());
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bgG.setOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.bky.a(vVar);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.bky.a(wVar);
    }

    public void c(c.b bVar) {
        this.bgU = bVar;
    }

    public void NT() {
        if (this.bgR != null) {
            this.bgR.tj();
        }
    }

    public void onDestroy() {
        this.bky.onDestory();
        this.bgG.setOnSrollToBottomListener(null);
    }

    public void cs(boolean z) {
        this.bgy = z;
        if (!z) {
            this.bgG.completePullRefresh();
        }
    }

    public void NV() {
        this.bgG.setVisibility(0);
    }

    public void NW() {
        if (this.bky != null) {
            this.bky.notifyDataSetChanged();
        }
    }

    public void ct(boolean z) {
        this.bky.cq(z);
    }

    public void cu(boolean z) {
        this.bky.cr(z);
    }

    private void NX() {
        if (this.bgJ == null) {
            String[] strArr = {this.bgr.getPageContext().getPageActivity().getString(n.j.take_photo), this.bgr.getPageContext().getPageActivity().getString(n.j.album)};
            this.bgJ = new com.baidu.tbadk.core.dialog.c(this.bgr.getPageContext().getPageActivity());
            this.bgJ.cG(this.bgr.getPageContext().getPageActivity().getString(n.j.operation));
            this.bgJ.a(strArr, new ad(this));
            this.bgJ.d(this.bgr.getPageContext());
        }
    }

    public void NY() {
        NX();
        if (this.bgJ != null) {
            this.bgJ.tj();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.u> arrayList, int i, com.baidu.tieba.tbadkCore.p pVar, int i2) {
        if (arrayList == null || arrayList.size() <= 0) {
            cw cwVar = new cw();
            arrayList = new ArrayList<>();
            arrayList.add(cwVar);
        }
        this.bky.a(arrayList, pVar, fX(i), fY(i2));
    }

    public BdListView getListView() {
        return this.bgG;
    }

    private boolean fX(int i) {
        return i > 1;
    }

    private boolean fY(int i) {
        return i == 1;
    }

    public void OU() {
        this.bky.cq(false);
        this.bky.cr(false);
        this.bky.notifyDataSetInvalidated();
    }

    public void gh(int i) {
        this.bgG.setSelection(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(ForumData forumData, UserData userData) {
        if (!this.bgW && forumData != null && forumData.getFrsBannerData() != null && forumData.getFrsBannerData().isValid()) {
            this.bgV = forumData.getFrsBannerData();
            Jf();
            this.aRF.reset();
            this.bgG.removeHeaderView(this.aRF);
            if (this.bgV.getType() == 1 && !TextUtils.isEmpty(this.bgV.rx())) {
                this.aRF.c(this.bgr.getPageContext(), this.bgV.rx());
                if (this.bgV.getValue().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.bgr.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
        }
    }

    public void Oa() {
        if (this.aRF != null) {
            this.bgW = false;
            this.bgG.removeHeaderView(this.aRF);
        }
    }

    public void release() {
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.bky != null) {
            this.bky.Ny();
            this.bky.notifyDataSetChanged();
            this.bky.onChangeSkinType(i);
        }
        this.bgr.getLayoutMode().ac(i == 1);
        this.bgr.getLayoutMode().k(this.bgz);
        this.mNavigationBar.onChangeSkinType(this.bgr.getPageContext(), i);
        if (this.aUd != null) {
            this.aUd.onChangeSkinType(this.bgr.getPageContext(), i);
        }
        if (this.aRF != null) {
            this.aRF.ot();
        }
        if (this.aVj != null) {
            this.aVj.cP(i);
        }
    }

    public void nb() {
        this.bgG.nb();
    }

    public int Oc() {
        return 0;
    }

    public ce OV() {
        return this.bky;
    }

    public NoPressedRelativeLayout OW() {
        return this.bgz;
    }

    public View Og() {
        return this.bgX;
    }

    public void Oj() {
        if (com.baidu.tbadk.performanceLog.y.EH().EI()) {
            int lastVisiblePosition = this.bgG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.bgG.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null) {
                    if (childAt.getTag() instanceof de) {
                        de deVar = (de) childAt.getTag();
                        if (deVar.bcC != null) {
                            com.baidu.tbadk.performanceLog.s perfLog = deVar.bcC.getPerfLog();
                            perfLog.eF(1000);
                            perfLog.azO = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr = new int[2];
                                deVar.bcC.getLocationOnScreen(iArr);
                                if (iArr[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            deVar.bcC.vI();
                        }
                        if (deVar.bcA != null && (deVar.bcA instanceof ViewGroup)) {
                            FrsCommonImageLayout frsCommonImageLayout = deVar.bcA;
                            for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                                View childAt2 = frsCommonImageLayout.getChildAt(i2);
                                if (childAt2 instanceof TbImageView) {
                                    TbImageView tbImageView = (TbImageView) childAt2;
                                    com.baidu.tbadk.performanceLog.s perfLog2 = tbImageView.getPerfLog();
                                    perfLog2.eF(1000);
                                    perfLog2.azO = true;
                                    if (lastVisiblePosition == i) {
                                        int[] iArr2 = new int[2];
                                        childAt2.getLocationOnScreen(iArr2);
                                        if (iArr2[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                        }
                                    }
                                    tbImageView.vI();
                                }
                            }
                        }
                    }
                    if (childAt.getTag() instanceof bo) {
                        bo boVar = (bo) childAt.getTag();
                        if (boVar.bfk != null) {
                            com.baidu.tbadk.performanceLog.s perfLog3 = boVar.bfk.getPerfLog();
                            perfLog3.eF(1000);
                            perfLog3.azO = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr3 = new int[2];
                                boVar.bfk.getLocationOnScreen(iArr3);
                                if (iArr3[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            boVar.bfk.vI();
                        }
                        if (boVar.bfC != null && (boVar.bfC instanceof TbImageView)) {
                            TbImageView tbImageView2 = boVar.bfC;
                            com.baidu.tbadk.performanceLog.s perfLog4 = tbImageView2.getPerfLog();
                            perfLog4.eF(1000);
                            perfLog4.azO = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr4 = new int[2];
                                tbImageView2.getLocationOnScreen(iArr4);
                                if (iArr4[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            tbImageView2.vI();
                        }
                    }
                    if (childAt.getTag() instanceof cf) {
                        cf cfVar = (cf) childAt.getTag();
                        if (cfVar.bgw != null && cfVar.bgw.aLn != null && (cfVar.bgw.aLn instanceof HeadImageView)) {
                            com.baidu.tbadk.performanceLog.s perfLog5 = cfVar.bgw.aLn.getPerfLog();
                            perfLog5.eF(1000);
                            perfLog5.azO = true;
                            if (lastVisiblePosition == i) {
                                int[] iArr5 = new int[2];
                                cfVar.bgw.aLn.getLocationOnScreen(iArr5);
                                if (iArr5[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                }
                            }
                            cfVar.bgw.aLn.vI();
                        }
                        ArrayList arrayList = new ArrayList();
                        if (cfVar.aLi != null) {
                            arrayList.add(cfVar.aLi);
                        }
                        if (cfVar.aLj != null) {
                            arrayList.add(cfVar.aLj);
                        }
                        if (cfVar.aLk != null) {
                            arrayList.add(cfVar.aLk);
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TbImageView tbImageView3 = (TbImageView) it.next();
                                com.baidu.tbadk.performanceLog.s perfLog6 = tbImageView3.getPerfLog();
                                perfLog6.eF(1000);
                                perfLog6.azO = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr6 = new int[2];
                                    tbImageView3.getLocationOnScreen(iArr6);
                                    if (iArr6[1] > com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getContext())) {
                                    }
                                }
                                tbImageView3.vI();
                            }
                        }
                    }
                }
            }
        }
    }

    public void Ok() {
        this.bgG.setNextPage(this.aVj);
        this.aVj.startLoadData();
    }

    public void Ol() {
        this.bgG.setNextPage(this.aVj);
        this.aVj.vP();
        this.aVj.setText(this.bgr.getResources().getString(n.j.list_no_more));
    }

    public void Om() {
        this.bgG.setNextPage(null);
    }

    public BdTypeListView OX() {
        return this.bgG;
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.aUd.a(aVar);
        }
    }
}
