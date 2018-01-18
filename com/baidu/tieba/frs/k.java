package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class k {
    private AppBarLayout awP;
    private PbListView bYR;
    private View dCB;
    private ImageView dCC;
    private ViewStub dCD;
    private u dCI;
    private BdSwipeRefreshLayout dCJ;
    private View.OnClickListener dCL;
    private View dCM;
    private View dCN;
    private int dCO;
    private View dCQ;
    private com.baidu.tieba.frs.entelechy.b.d dCR;
    private com.baidu.tieba.frs.entelechy.b.c dCS;
    private com.baidu.tieba.frs.f.j dCT;
    private GifView dCU;
    private TbImageView dCV;
    private HashSet<String> dCW;
    private com.baidu.tieba.play.m dCX;
    private ObservedChangeLinearLayout dCZ;
    private i dCx;
    private com.baidu.tieba.frs.entelechy.b.a dDa;
    private com.baidu.tieba.video.e dDc;
    private AppBarLayoutStickyBehavior dDd;
    private FrsHeaderViewContainer dDe;
    private CollapsingToolbarLayout dDf;
    private boolean dDh;
    private NoNetworkView dmi;
    private CommonTipView dnF;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private View mStatusBarView;
    private boolean dCw = false;
    private NoPressedRelativeLayout dCy = null;
    private CoordinatorLayout dCz = null;
    private View dCA = null;
    private FrameLayout dCE = null;
    private TbImageView dCF = null;
    private TbImageView dCG = null;
    private BdTypeRecyclerView dCH = null;
    private com.baidu.tbadk.core.dialog.b dCK = null;
    private NoNetworkView.a dzq = null;
    private boolean mHasMore = true;
    private boolean dCP = false;
    private int dCq = 0;
    private int bXr = 0;
    private View dCY = null;
    private boolean cFy = true;
    private boolean dDb = true;
    private Runnable dDg = new Runnable() { // from class: com.baidu.tieba.frs.k.5
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dCD != null) {
                k.this.dCE.setVisibility(0);
                k.this.dCG.setVisibility(0);
                k.this.dCF.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dDi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.k.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.awP.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout auw() {
        return this.dCZ;
    }

    public View aux() {
        return this.dCY;
    }

    public k(i iVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.dCx = null;
        this.dCL = null;
        this.dCO = 0;
        this.dCx = iVar;
        this.dCL = onClickListener;
        a(aVar, z);
        this.dCW = new HashSet<>();
        this.dCO = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.dCx.registerListener(this.dDi);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.dDa = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dCx.getPageContext());
        }
        this.mPullView.setTag(this.dCx.getUniqueId());
        if (this.dCy == null) {
            this.dCy = (NoPressedRelativeLayout) this.dCx.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.t(this.dCy, d.C0107d.cp_bg_line_d);
        if (this.dCA == null) {
            this.dCA = this.dCx.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.dCz == null) {
            this.dCz = (CoordinatorLayout) this.dCx.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.dCN == null) {
            this.dCN = this.dCx.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.dDf == null) {
            this.dDf = (CollapsingToolbarLayout) this.dCx.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.dDe == null) {
            this.dDe = (FrsHeaderViewContainer) this.dCx.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.dCZ == null) {
            this.dCZ = (ObservedChangeLinearLayout) this.dCx.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.dCZ.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        ViewGroup.LayoutParams layoutParams = k.this.dDe.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, i2, 0, 0);
                            k.this.dDe.requestLayout();
                        }
                        k.this.dDf.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dCx.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dCx.aut()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dCM == null) {
            this.dCM = this.dCx.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b avR = aVar.avR();
            if (avR != null) {
                avR.bN(this.dCM);
            }
        }
        if (this.dCB == null) {
            this.dCB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dCB.setOnClickListener(this.dCL);
            this.mBackImageView = (ImageView) this.dCB.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dCC == null) {
            this.dCC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dCC.setOnClickListener(this.dCL);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dCx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0107d.cp_bg_line_b);
        }
        if (this.dCJ == null) {
            this.dCJ = (BdSwipeRefreshLayout) this.dCx.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.dCJ.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.aj.t(this.dCJ, d.C0107d.cp_bg_line_c);
        }
        if (this.dCH == null) {
            this.dCH = (BdTypeRecyclerView) this.dCx.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.dCH.getItemAnimator()).setSupportsChangeAnimations(false);
        this.dCH.setLayoutManager(new LinearLayoutManager(this.dCH.getContext()));
        this.dCH.setScrollable(this.dCx);
        this.dCH.setFadingEdgeLength(0);
        this.dCH.setOverScrollMode(2);
        this.dCy.setBottomOrderView(this.dCH);
        this.dCH.setOnTouchListener(this.dCx.bBl);
        this.dCH.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.2
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dCX != null) {
                    k.this.dCX.ch(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        });
        if (this.bYR == null) {
            this.bYR = new PbListView(this.dCx.getPageContext().getPageActivity());
            this.bYR.getView();
        }
        this.bYR.gu(d.C0107d.cp_bg_line_e);
        this.bYR.setHeight(com.baidu.adp.lib.util.l.s(this.dCx.getActivity(), d.e.tbds182));
        this.bYR.DH();
        this.bYR.setTextSize(d.e.tbfontsize33);
        this.bYR.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_cont_d));
        this.bYR.gt(d.C0107d.cp_cont_e);
        this.dCH.setOnSrollToBottomListener(this.dCx);
        this.mNavigationBar.setOnTouchListener(new t(new t.a() { // from class: com.baidu.tieba.frs.k.3
            @Override // com.baidu.tieba.tbadkCore.t.a
            public void ava() {
                k.this.dCx.auo();
            }

            @Override // com.baidu.tieba.tbadkCore.t.a
            public void avb() {
                if (k.this.dCx != null && k.this.awP != null) {
                    k.this.dCx.auv();
                    k.this.awP.setExpanded(true);
                    if (k.this.dCX != null) {
                        k.this.dCX.c(k.this.dCq, k.this.bXr, false, true);
                    }
                }
            }
        }));
        boolean CL = com.baidu.tbadk.core.util.an.CJ().CL();
        if (this.dCI == null) {
            this.dCI = aVar.a(this.dCx, this.dCH, CL);
        }
        cL(false);
        if (!z) {
            if (this.dmi == null) {
                this.dmi = new NoNetworkView(this.dCx.getActivity());
                this.dmi.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dCZ.addView(this.dmi);
            }
            if (com.baidu.adp.lib.util.j.ow()) {
                this.dmi.setVisibility(8);
            } else {
                this.dmi.setVisibility(0);
            }
            this.dmi.onChangeSkinType(this.dCx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        auE();
        if (this.dCR == null) {
            this.dCR = aVar.c(this.dCx, this.dCy);
        }
        if (this.dCS == null) {
            this.dCS = aVar.b(this.dCx, this.dCy);
            fE(true);
        }
        if (this.dCY == null) {
            this.dCY = this.dCx.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.dCX == null) {
            this.dCX = new com.baidu.tieba.play.m(this.dCx.getPageContext(), this.dCH);
        }
        this.dCX.setUniqueId(this.dCx.getUniqueId());
        if (this.dCT == null) {
            this.dCT = new com.baidu.tieba.frs.f.j(this.dCx, (NavigationBarCoverTip) this.dCx.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.awP == null) {
            this.awP = (AppBarLayout) this.dCx.mRootView.findViewById(d.g.frs_app_bar_layout);
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.awP.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dDd = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    public void setHeaderViewHeight(int i) {
        if (this.dCQ != null && this.dCQ.getLayoutParams() != null) {
            this.dCQ.getLayoutParams().height = i;
            this.dCQ.setLayoutParams(this.dCQ.getLayoutParams());
        }
    }

    public void ls(String str) {
        if (this.dCT != null) {
            this.dCT.ls(str);
        }
    }

    public View auy() {
        return this.dCQ;
    }

    public com.baidu.tieba.play.m auz() {
        return this.dCX;
    }

    public com.baidu.tieba.frs.entelechy.b.c auA() {
        return this.dCS;
    }

    public void fC(boolean z) {
        boolean z2 = z && v.E(this.dCx.auq().buj());
        if (this.dCR != null) {
            this.dCR.fC(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d auB() {
        return this.dCR;
    }

    public void x(boolean z, boolean z2) {
        if (this.dDb && this.dCS != null) {
            this.dCS.x(z, z2);
        }
    }

    public void fD(boolean z) {
        this.dDb = z;
        if (!this.dDb && this.dCS != null) {
            this.dCS.x(false, false);
        }
    }

    public void auC() {
        if (this.dDb && this.dCS != null) {
            this.dCS.x(false, false);
        }
        this.dCC.setVisibility(8);
        fC(false);
        this.dCH.setVisibility(8);
        this.dDe.setVisibility(8);
    }

    public void auD() {
        if (this.dDb && this.dCS != null) {
            this.dCS.x(true, false);
        }
        this.dCC.setVisibility(0);
        fC(true);
        this.dCH.setVisibility(0);
        this.dDe.setVisibility(0);
    }

    public void fE(boolean z) {
        if (this.dCS != null) {
            this.dCS.fU(z);
        }
    }

    private void auE() {
        if (this.dCU == null) {
            this.dCU = (GifView) this.dCx.mRootView.findViewById(d.g.gif_real_time);
            this.dCV = (TbImageView) this.dCx.mRootView.findViewById(d.g.tbimg_real_time);
            this.dCV.setPageId(this.dCx.getUniqueId());
            this.dCU.setLayerType(1, null);
            this.dCV.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View auF() {
        return this.dCB;
    }

    public void h(NoNetworkView.a aVar) {
        this.dzq = aVar;
        if (this.dmi != null) {
            this.dmi.a(this.dzq);
        }
    }

    public void cL(boolean z) {
        this.dCw = z;
        if (z) {
            if (this.dCS != null) {
                this.dCS.awv();
                return;
            }
            return;
        }
        this.dCH.getAdapter().notifyDataSetChanged();
        if (this.dCS != null) {
            this.dCS.aww();
        }
    }

    public void fF(boolean z) {
        if (this.dCS != null) {
            if (z) {
                x(false, true);
            } else {
                x(false, false);
            }
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(j.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(j.a aVar) {
        this.mPullView.a(aVar);
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dCH.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.o oVar) {
        this.dCI.setOnAdapterItemClickListener(oVar);
    }

    public void setForumName(String str) {
        this.dCI.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dCX != null) {
            this.dCX.destroy();
        }
        if (this.dCT != null) {
            this.dCT.onDestory();
        }
        this.dCI.onDestory();
        this.dCH.setOnSrollToBottomListener(null);
        this.dCH.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dDg);
        if (this.dnF != null) {
            this.dnF.onDestroy();
        }
        this.dCW.clear();
        if (this.dCR != null) {
            this.dCR.awx();
        }
        if (this.dCY != null) {
            this.dCY.setBackgroundDrawable(null);
        }
        if (this.dDc != null) {
            this.dDc.avN();
        }
    }

    public boolean auG() {
        if (this.awP == null || this.dDd == null || !this.dDd.isSticky()) {
            return this.dCR != null && this.dCR.auG();
        }
        if (this.dCH != null) {
            this.dCH.setSelection(0);
        }
        this.dDd.expandedAppBarLayout(this.awP);
        return true;
    }

    public boolean aur() {
        return this.dCw;
    }

    public void WN() {
        this.dCH.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.mNavigationBar.getCenterTextTitleText())) {
            if (TextUtils.isEmpty(str)) {
                this.mNavigationBar.setCenterTextTitle("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.mNavigationBar.setCenterTextTitle(str2);
            com.baidu.tbadk.core.i.wA().cz(str);
        }
    }

    public void auH() {
        if (this.dCI != null) {
            this.dCI.notifyDataSetChanged();
        }
    }

    public void alO() {
        if (this.dCI instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dCI).alO();
        }
    }

    private void auI() {
        if (this.dCK == null && this.dCx.getPageContext() != null) {
            String[] strArr = {this.dCx.getPageContext().getPageActivity().getString(d.j.take_photo), this.dCx.getPageContext().getPageActivity().getString(d.j.album)};
            this.dCK = new com.baidu.tbadk.core.dialog.b(this.dCx.getPageContext().getPageActivity());
            this.dCK.da(this.dCx.getPageContext().getPageActivity().getString(d.j.operation));
            this.dCK.a(strArr, new b.InterfaceC0073b() { // from class: com.baidu.tieba.frs.k.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dCx.aus();
                    } else if (i == 1 && k.this.dCx.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(k.this.dCx.getPageContext().getPageActivity());
                    }
                }
            });
            this.dCK.d(this.dCx.getPageContext());
        }
    }

    public void auJ() {
        auI();
        if (this.dCK != null) {
            this.dCK.AD();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (v.E(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dCx != null && this.dCx.atT() != null && this.dCx.atT().ayi() == 0) {
                mVar.mY(this.dCx.atT().ayq());
            }
        }
        if (v.D(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
                if (iVar instanceof bd) {
                    ((bd) iVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.dCI.b(arrayList, lVar);
        if (this.dCX != null) {
            this.dCX.c(this.dCq, this.bXr, this.dCP, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dCH;
    }

    public void auK() {
        this.dCI.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dCx.getPageContext(), 1);
        aVar.a(this.dCH);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dCx.getForumName());
        hashMap.put("forum_id", this.dCx.getForumId());
        aVar.setParams(hashMap);
        aVar.aM(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.dCR != null) {
            this.dCR.awy();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.dCR != null) {
            this.dCR.awz();
        }
    }

    public void release() {
        if (this.dmi != null && this.dzq != null) {
            this.dmi.b(this.dzq);
        }
    }

    public ImageView auL() {
        return this.dCC;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dCx, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dCx.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.dCV != null) {
            this.dCV.invalidate();
        }
        if (this.dCI != null) {
            this.dCI.awk();
            this.dCI.notifyDataSetChanged();
        }
        this.dCx.getPageContext().getLayoutMode().aM(i == 1);
        this.dCx.getPageContext().getLayoutMode().aM(this.dCy);
        if (this.dCy != null) {
            com.baidu.tbadk.core.util.aj.g(this.dCy, d.C0107d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dCx.getPageContext(), i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.g(this.dCM, d.C0107d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0107d.cp_bg_line_b);
        }
        if (this.mStatusBarView != null) {
            this.mStatusBarView.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)));
        }
        if (this.dmi != null) {
            this.dmi.onChangeSkinType(this.dCx.getPageContext(), i);
        }
        if (this.bYR != null) {
            this.bYR.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0107d.cp_cont_d));
            this.bYR.gv(i);
        }
        fJ(false);
        if (this.dCS != null) {
            this.dCS.onChangeSkinType(i);
        }
        if (this.dCR != null) {
            this.dCR.onChangeSkinType(i);
        }
        if (this.dCY != null) {
            UtilHelper.setStatusBarBackground(this.dCY, i);
        }
        if (this.dCX != null) {
            this.dCX.c(this.dCq, this.bXr, this.dCP, true);
        }
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
        com.baidu.tbadk.core.util.aj.t(this.dCJ, d.C0107d.cp_bg_line_c);
        com.baidu.tbadk.core.util.aj.t(this.dCH, d.C0107d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.dCH != null && this.dCH.getFirstVisiblePosition() != 0) {
            this.dCH.setSelection(0);
        }
        this.dCJ.setRefreshing(true);
    }

    public void fG(boolean z) {
        if (z) {
            this.dCJ.setRefreshing(false);
        } else {
            this.dCJ.sW();
        }
    }

    public boolean auM() {
        return this.dCD != null && this.dCG.getVisibility() == 0;
    }

    public void auN() {
        if (this.dCD != null) {
            this.dCE.setVisibility(0);
            this.dCG.setVisibility(8);
            this.dCF.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dDg, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bl blVar) {
        if (this.dCD == null) {
            this.dCD = (ViewStub) this.dCx.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.dCD.setVisibility(0);
            this.dCE = (FrameLayout) this.dCx.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.dCF = (TbImageView) this.dCx.mRootView.findViewById(d.g.game_activity_egg);
            this.dCG = (TbImageView) this.dCx.mRootView.findViewById(d.g.game_activity_egg_s);
            this.dCF.setPageId(this.dCx.getUniqueId());
            this.dCG.setPageId(this.dCx.getUniqueId());
            this.dCF.setDefaultBgResource(d.C0107d.common_color_10022);
            this.dCF.setDefaultResource(0);
            this.dCG.setDefaultBgResource(d.C0107d.common_color_10022);
            this.dCG.setDefaultResource(0);
            this.dCE.setOnClickListener(this.dCL);
        }
        this.dCE.setVisibility(0);
        String Aq = blVar.Aq();
        String Ar = blVar.Ar();
        this.dCF.startLoad(Aq, 10, false);
        this.dCG.startLoad(Ar, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dDg, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void auO() {
        if (this.dCD != null) {
            this.dCE.setVisibility(8);
        }
    }

    public u auP() {
        return this.dCI;
    }

    public ViewGroup aem() {
        return this.dCy;
    }

    public View auQ() {
        return this.dCN;
    }

    public void mU(int i) {
        if (this.dCA != null) {
            this.dCA.setVisibility(i);
        }
    }

    public void auR() {
        if (com.baidu.tbadk.k.r.NO().NP()) {
            int lastVisiblePosition = this.dCH.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dCH.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dDq != null) {
                        com.baidu.tbadk.k.l perfLog = oVar.dDq.getPerfLog();
                        perfLog.im(1000);
                        perfLog.byn = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dDq.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dDq.startLogPerf();
                    }
                    if (oVar.dDp != null && (oVar.dDp instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dDp;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.im(1000);
                                perfLog2.byn = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                                    }
                                }
                                tbImageView.startLogPerf();
                            }
                        }
                    }
                }
            }
        }
    }

    public NavigationBar aup() {
        return this.mNavigationBar;
    }

    public void auS() {
        this.mHasMore = true;
        this.dCH.setNextPage(this.bYR);
        if (this.dCO > 0) {
            this.bYR.gw(this.dCO);
        }
        this.bYR.setOnClickListener(null);
        this.bYR.DK();
    }

    public void auT() {
        this.mHasMore = false;
        this.dCH.setNextPage(this.bYR);
        if (this.dCO > 0) {
            this.bYR.gw(this.dCO);
        }
        this.bYR.setOnClickListener(null);
        this.bYR.DL();
        this.bYR.setText(this.dCx.getResources().getString(d.j.list_no_more));
    }

    public void auU() {
        this.mHasMore = true;
        this.dCH.setNextPage(this.bYR);
        this.bYR.setOnClickListener(this.dCL);
        if (this.dCO > 0) {
            this.bYR.gw(this.dCO);
        }
        this.bYR.DL();
        this.bYR.setText(this.dCx.getResources().getString(d.j.list_click_load_more));
    }

    public View auV() {
        if (this.bYR == null) {
            return null;
        }
        return this.bYR.getView();
    }

    public void alP() {
        this.mHasMore = false;
        this.dCH.setNextPage(null);
    }

    public boolean alF() {
        return this.bYR.getView().getParent() != null && this.mHasMore;
    }

    public void mV(int i) {
        this.dCO = i;
    }

    public void mW(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dnF == null) {
                    this.dnF = new CommonTipView(this.dCx.getActivity());
                }
                this.dnF.setText(d.j.frs_login_tip);
                this.dnF.show((FrameLayout) auQ(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fH(boolean z) {
        if (this.dCX != null) {
            if (z) {
                this.dCX.il(false);
                this.dCX.aCB();
                return;
            }
            this.dCX.il(true);
            this.dCX.c(this.dCq, this.bXr, this.dCP, true);
        }
    }

    public void bw(int i, int i2) {
        if (this.dCX != null) {
            this.dCX.a(i, i2, this.dCP, 1);
        }
    }

    public void bx(int i, int i2) {
        this.dCq = i;
        this.bXr = i2;
    }

    public void fI(boolean z) {
        this.dCP = z;
    }

    public void auW() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.s(this.mBackImageView, d.f.frs_star_navigation_bg);
        }
    }

    private void auX() {
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
            if (f >= 0.0f && f <= 1.0f && this.mBackImageView != null) {
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void fJ(boolean z) {
        boolean i = com.baidu.tieba.frs.f.f.i(this.dCx.auq());
        boolean h = com.baidu.tieba.frs.f.f.h(this.dCx.auq());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.cFy) {
                    this.cFy = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.dCC, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.s(this.mBackImageView, d.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.cFy) {
                this.cFy = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.dCC, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        auX();
    }

    public void fK(boolean z) {
    }

    public void mX(int i) {
        if (this.dCH != null && this.dCH.getChildCount() >= 0) {
            if (this.dCH.getFirstVisiblePosition() > 8) {
                this.dCH.scrollToPosition(8);
            }
            this.dCH.smoothScrollToPosition(i);
        }
    }

    public void auY() {
        a(this.dDa, this.dCx.aut());
        if (this.dCI != null) {
            this.dCI.awp();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dDc == null) {
                this.dDc = new com.baidu.tieba.video.e(this.dCx.getActivity(), this.dCy);
            }
            this.dDc.g(postWriteCallBackData);
        }
    }

    public void auZ() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dDh && this.dCx.getActivity() != null && this.dCx.getPageContext() != null) {
            View view = null;
            if (this.dCH != null && (headerViewsCount = this.dCH.getHeaderViewsCount()) < this.dCH.getChildCount()) {
                view = this.dCH.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.aG(view).cW(0).ag(true).ah(false).af(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.6
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.dCx.getPageContext().getLayoutMode().aM(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int mA() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int mB() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.s(k.this.dCx.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.s(k.this.dCx.getActivity(), d.e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.7
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void bL() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mC = dVar.mC();
                mC.ae(false);
                mC.j(this.dCx.getActivity());
                com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mC != null) {
                            mC.dismiss();
                        }
                    }
                }, 4000L);
                this.dDh = true;
            }
        }
    }
}
