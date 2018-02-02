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
    private AppBarLayout awS;
    private PbListView bYZ;
    private i dCS;
    private View dCW;
    private ImageView dCX;
    private ViewStub dCY;
    private CollapsingToolbarLayout dDA;
    private boolean dDC;
    private u dDd;
    private BdSwipeRefreshLayout dDe;
    private View.OnClickListener dDg;
    private View dDh;
    private View dDi;
    private int dDj;
    private View dDl;
    private com.baidu.tieba.frs.entelechy.b.d dDm;
    private com.baidu.tieba.frs.entelechy.b.c dDn;
    private com.baidu.tieba.frs.f.j dDo;
    private GifView dDp;
    private TbImageView dDq;
    private HashSet<String> dDr;
    private com.baidu.tieba.play.m dDs;
    private ObservedChangeLinearLayout dDu;
    private com.baidu.tieba.frs.entelechy.b.a dDv;
    private com.baidu.tieba.video.e dDx;
    private AppBarLayoutStickyBehavior dDy;
    private FrsHeaderViewContainer dDz;
    private NoNetworkView dmD;
    private CommonTipView doa;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private View mStatusBarView;
    private boolean dCR = false;
    private NoPressedRelativeLayout dCT = null;
    private CoordinatorLayout dCU = null;
    private View dCV = null;
    private FrameLayout dCZ = null;
    private TbImageView dDa = null;
    private TbImageView dDb = null;
    private BdTypeRecyclerView dDc = null;
    private com.baidu.tbadk.core.dialog.b dDf = null;
    private NoNetworkView.a dzL = null;
    private boolean mHasMore = true;
    private boolean dDk = false;
    private int dCL = 0;
    private int bXz = 0;
    private View dDt = null;
    private boolean cFL = true;
    private boolean dDw = true;
    private Runnable dDB = new Runnable() { // from class: com.baidu.tieba.frs.k.5
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dCY != null) {
                k.this.dCZ.setVisibility(0);
                k.this.dDb.setVisibility(0);
                k.this.dDa.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dDD = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.k.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.awS.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout auB() {
        return this.dDu;
    }

    public View auC() {
        return this.dDt;
    }

    public k(i iVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.dCS = null;
        this.dDg = null;
        this.dDj = 0;
        this.dCS = iVar;
        this.dDg = onClickListener;
        a(aVar, z);
        this.dDr = new HashSet<>();
        this.dDj = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.dCS.registerListener(this.dDD);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.dDv = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dCS.getPageContext());
        }
        this.mPullView.setTag(this.dCS.getUniqueId());
        if (this.dCT == null) {
            this.dCT = (NoPressedRelativeLayout) this.dCS.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.t(this.dCT, d.C0108d.cp_bg_line_d);
        if (this.dCV == null) {
            this.dCV = this.dCS.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.dCU == null) {
            this.dCU = (CoordinatorLayout) this.dCS.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.dDi == null) {
            this.dDi = this.dCS.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.dDA == null) {
            this.dDA = (CollapsingToolbarLayout) this.dCS.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.dDz == null) {
            this.dDz = (FrsHeaderViewContainer) this.dCS.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.dDu == null) {
            this.dDu = (ObservedChangeLinearLayout) this.dCS.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.dDu.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        ViewGroup.LayoutParams layoutParams = k.this.dDz.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, i2, 0, 0);
                            k.this.dDz.requestLayout();
                        }
                        k.this.dDA.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dCS.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dCS.auy()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dDh == null) {
            this.dDh = this.dCS.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b avW = aVar.avW();
            if (avW != null) {
                avW.bN(this.dDh);
            }
        }
        if (this.dCW == null) {
            this.dCW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dCW.setOnClickListener(this.dDg);
            this.mBackImageView = (ImageView) this.dCW.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dCX == null) {
            this.dCX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dCX.setOnClickListener(this.dDg);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dCS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0108d.cp_bg_line_b);
        }
        if (this.dDe == null) {
            this.dDe = (BdSwipeRefreshLayout) this.dCS.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.dDe.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.aj.t(this.dDe, d.C0108d.cp_bg_line_c);
        }
        if (this.dDc == null) {
            this.dDc = (BdTypeRecyclerView) this.dCS.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.dDc.getItemAnimator()).setSupportsChangeAnimations(false);
        this.dDc.setLayoutManager(new LinearLayoutManager(this.dDc.getContext()));
        this.dDc.setScrollable(this.dCS);
        this.dDc.setFadingEdgeLength(0);
        this.dDc.setOverScrollMode(2);
        this.dCT.setBottomOrderView(this.dDc);
        this.dDc.setOnTouchListener(this.dCS.bBt);
        this.dDc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.2
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dDs != null) {
                    k.this.dDs.ch(view);
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
        if (this.bYZ == null) {
            this.bYZ = new PbListView(this.dCS.getPageContext().getPageActivity());
            this.bYZ.getView();
        }
        this.bYZ.gu(d.C0108d.cp_bg_line_e);
        this.bYZ.setHeight(com.baidu.adp.lib.util.l.s(this.dCS.getActivity(), d.e.tbds182));
        this.bYZ.DJ();
        this.bYZ.setTextSize(d.e.tbfontsize33);
        this.bYZ.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_d));
        this.bYZ.gt(d.C0108d.cp_cont_e);
        this.dDc.setOnSrollToBottomListener(this.dCS);
        this.mNavigationBar.setOnTouchListener(new t(new t.a() { // from class: com.baidu.tieba.frs.k.3
            @Override // com.baidu.tieba.tbadkCore.t.a
            public void avf() {
                k.this.dCS.aut();
            }

            @Override // com.baidu.tieba.tbadkCore.t.a
            public void avg() {
                if (k.this.dCS != null && k.this.awS != null) {
                    k.this.dCS.auA();
                    k.this.awS.setExpanded(true);
                    if (k.this.dDs != null) {
                        k.this.dDs.c(k.this.dCL, k.this.bXz, false, true);
                    }
                }
            }
        }));
        boolean CM = com.baidu.tbadk.core.util.an.CK().CM();
        if (this.dDd == null) {
            this.dDd = aVar.a(this.dCS, this.dDc, CM);
        }
        cM(false);
        if (!z) {
            if (this.dmD == null) {
                this.dmD = new NoNetworkView(this.dCS.getActivity());
                this.dmD.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dDu.addView(this.dmD);
            }
            if (com.baidu.adp.lib.util.j.ox()) {
                this.dmD.setVisibility(8);
            } else {
                this.dmD.setVisibility(0);
            }
            this.dmD.onChangeSkinType(this.dCS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        auJ();
        if (this.dDm == null) {
            this.dDm = aVar.c(this.dCS, this.dCT);
        }
        if (this.dDn == null) {
            this.dDn = aVar.b(this.dCS, this.dCT);
            fH(true);
        }
        if (this.dDt == null) {
            this.dDt = this.dCS.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.dDs == null) {
            this.dDs = new com.baidu.tieba.play.m(this.dCS.getPageContext(), this.dDc);
        }
        this.dDs.setUniqueId(this.dCS.getUniqueId());
        if (this.dDo == null) {
            this.dDo = new com.baidu.tieba.frs.f.j(this.dCS, (NavigationBarCoverTip) this.dCS.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.awS == null) {
            this.awS = (AppBarLayout) this.dCS.mRootView.findViewById(d.g.frs_app_bar_layout);
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.awS.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dDy = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    public void setHeaderViewHeight(int i) {
        if (this.dDl != null && this.dDl.getLayoutParams() != null) {
            this.dDl.getLayoutParams().height = i;
            this.dDl.setLayoutParams(this.dDl.getLayoutParams());
        }
    }

    public void lA(String str) {
        if (this.dDo != null) {
            this.dDo.lA(str);
        }
    }

    public View auD() {
        return this.dDl;
    }

    public com.baidu.tieba.play.m auE() {
        return this.dDs;
    }

    public com.baidu.tieba.frs.entelechy.b.c auF() {
        return this.dDn;
    }

    public void fF(boolean z) {
        boolean z2 = z && v.E(this.dCS.auv().bul());
        if (this.dDm != null) {
            this.dDm.fF(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d auG() {
        return this.dDm;
    }

    public void x(boolean z, boolean z2) {
        if (this.dDw && this.dDn != null) {
            this.dDn.x(z, z2);
        }
    }

    public void fG(boolean z) {
        this.dDw = z;
        if (!this.dDw && this.dDn != null) {
            this.dDn.x(false, false);
        }
    }

    public void auH() {
        if (this.dDw && this.dDn != null) {
            this.dDn.x(false, false);
        }
        this.dCX.setVisibility(8);
        fF(false);
        this.dDc.setVisibility(8);
        this.dDz.setVisibility(8);
    }

    public void auI() {
        if (this.dDw && this.dDn != null) {
            this.dDn.x(true, false);
        }
        this.dCX.setVisibility(0);
        fF(true);
        this.dDc.setVisibility(0);
        this.dDz.setVisibility(0);
    }

    public void fH(boolean z) {
        if (this.dDn != null) {
            this.dDn.fX(z);
        }
    }

    private void auJ() {
        if (this.dDp == null) {
            this.dDp = (GifView) this.dCS.mRootView.findViewById(d.g.gif_real_time);
            this.dDq = (TbImageView) this.dCS.mRootView.findViewById(d.g.tbimg_real_time);
            this.dDq.setPageId(this.dCS.getUniqueId());
            this.dDp.setLayerType(1, null);
            this.dDq.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View auK() {
        return this.dCW;
    }

    public void h(NoNetworkView.a aVar) {
        this.dzL = aVar;
        if (this.dmD != null) {
            this.dmD.a(this.dzL);
        }
    }

    public void cM(boolean z) {
        this.dCR = z;
        if (z) {
            if (this.dDn != null) {
                this.dDn.awA();
                return;
            }
            return;
        }
        this.dDc.getAdapter().notifyDataSetChanged();
        if (this.dDn != null) {
            this.dDn.awB();
        }
    }

    public void fI(boolean z) {
        if (this.dDn != null) {
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
        this.dDc.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.o oVar) {
        this.dDd.setOnAdapterItemClickListener(oVar);
    }

    public void setForumName(String str) {
        this.dDd.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dDs != null) {
            this.dDs.destroy();
        }
        if (this.dDo != null) {
            this.dDo.onDestory();
        }
        this.dDd.onDestory();
        this.dDc.setOnSrollToBottomListener(null);
        this.dDc.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dDB);
        if (this.doa != null) {
            this.doa.onDestroy();
        }
        this.dDr.clear();
        if (this.dDm != null) {
            this.dDm.awC();
        }
        if (this.dDt != null) {
            this.dDt.setBackgroundDrawable(null);
        }
        if (this.dDx != null) {
            this.dDx.avS();
        }
    }

    public boolean auL() {
        if (this.awS == null || this.dDy == null || !this.dDy.isSticky()) {
            return this.dDm != null && this.dDm.auL();
        }
        if (this.dDc != null) {
            this.dDc.setSelection(0);
        }
        this.dDy.expandedAppBarLayout(this.awS);
        return true;
    }

    public boolean auw() {
        return this.dCR;
    }

    public void WP() {
        this.dDc.setVisibility(0);
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
            com.baidu.tbadk.core.i.wB().cz(str);
        }
    }

    public void auM() {
        if (this.dDd != null) {
            this.dDd.notifyDataSetChanged();
        }
    }

    public void alT() {
        if (this.dDd instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dDd).alT();
        }
    }

    private void auN() {
        if (this.dDf == null && this.dCS.getPageContext() != null) {
            String[] strArr = {this.dCS.getPageContext().getPageActivity().getString(d.j.take_photo), this.dCS.getPageContext().getPageActivity().getString(d.j.album)};
            this.dDf = new com.baidu.tbadk.core.dialog.b(this.dCS.getPageContext().getPageActivity());
            this.dDf.da(this.dCS.getPageContext().getPageActivity().getString(d.j.operation));
            this.dDf.a(strArr, new b.InterfaceC0073b() { // from class: com.baidu.tieba.frs.k.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dCS.aux();
                    } else if (i == 1 && k.this.dCS.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(k.this.dCS.getPageContext().getPageActivity());
                    }
                }
            });
            this.dDf.d(this.dCS.getPageContext());
        }
    }

    public void auO() {
        auN();
        if (this.dDf != null) {
            this.dDf.AE();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (v.E(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dCS != null && this.dCS.atY() != null && this.dCS.atY().ayn() == 0) {
                mVar.mY(this.dCS.atY().ayv());
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
        this.dDd.b(arrayList, lVar);
        if (this.dDs != null) {
            this.dDs.c(this.dCL, this.bXz, this.dDk, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dDc;
    }

    public void auP() {
        this.dDd.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dCS.getPageContext(), 1);
        aVar.a(this.dDc);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dCS.getForumName());
        hashMap.put("forum_id", this.dCS.getForumId());
        aVar.setParams(hashMap);
        aVar.aM(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.dDm != null) {
            this.dDm.awD();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.dDm != null) {
            this.dDm.awE();
        }
    }

    public void release() {
        if (this.dmD != null && this.dzL != null) {
            this.dmD.b(this.dzL);
        }
    }

    public ImageView auQ() {
        return this.dCX;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dCS, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dCS.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.dDq != null) {
            this.dDq.invalidate();
        }
        if (this.dDd != null) {
            this.dDd.awp();
            this.dDd.notifyDataSetChanged();
        }
        this.dCS.getPageContext().getLayoutMode().aN(i == 1);
        this.dCS.getPageContext().getLayoutMode().aM(this.dCT);
        if (this.dCT != null) {
            com.baidu.tbadk.core.util.aj.g(this.dCT, d.C0108d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dCS.getPageContext(), i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.g(this.dDh, d.C0108d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0108d.cp_bg_line_b);
        }
        if (this.mStatusBarView != null) {
            this.mStatusBarView.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)));
        }
        if (this.dmD != null) {
            this.dmD.onChangeSkinType(this.dCS.getPageContext(), i);
        }
        if (this.bYZ != null) {
            this.bYZ.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_d));
            this.bYZ.gv(i);
        }
        fM(false);
        if (this.dDn != null) {
            this.dDn.onChangeSkinType(i);
        }
        if (this.dDm != null) {
            this.dDm.onChangeSkinType(i);
        }
        if (this.dDt != null) {
            UtilHelper.setStatusBarBackground(this.dDt, i);
        }
        if (this.dDs != null) {
            this.dDs.c(this.dCL, this.bXz, this.dDk, true);
        }
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
        com.baidu.tbadk.core.util.aj.t(this.dDe, d.C0108d.cp_bg_line_c);
        com.baidu.tbadk.core.util.aj.t(this.dDc, d.C0108d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.dDc != null && this.dDc.getFirstVisiblePosition() != 0) {
            this.dDc.setSelection(0);
        }
        this.dDe.setRefreshing(true);
    }

    public void fJ(boolean z) {
        if (z) {
            this.dDe.setRefreshing(false);
        } else {
            this.dDe.sX();
        }
    }

    public boolean auR() {
        return this.dCY != null && this.dDb.getVisibility() == 0;
    }

    public void auS() {
        if (this.dCY != null) {
            this.dCZ.setVisibility(0);
            this.dDb.setVisibility(8);
            this.dDa.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dDB, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bl blVar) {
        if (this.dCY == null) {
            this.dCY = (ViewStub) this.dCS.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.dCY.setVisibility(0);
            this.dCZ = (FrameLayout) this.dCS.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.dDa = (TbImageView) this.dCS.mRootView.findViewById(d.g.game_activity_egg);
            this.dDb = (TbImageView) this.dCS.mRootView.findViewById(d.g.game_activity_egg_s);
            this.dDa.setPageId(this.dCS.getUniqueId());
            this.dDb.setPageId(this.dCS.getUniqueId());
            this.dDa.setDefaultBgResource(d.C0108d.common_color_10022);
            this.dDa.setDefaultResource(0);
            this.dDb.setDefaultBgResource(d.C0108d.common_color_10022);
            this.dDb.setDefaultResource(0);
            this.dCZ.setOnClickListener(this.dDg);
        }
        this.dCZ.setVisibility(0);
        String Ar = blVar.Ar();
        String As = blVar.As();
        this.dDa.startLoad(Ar, 10, false);
        this.dDb.startLoad(As, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dDB, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void auT() {
        if (this.dCY != null) {
            this.dCZ.setVisibility(8);
        }
    }

    public u auU() {
        return this.dDd;
    }

    public ViewGroup aep() {
        return this.dCT;
    }

    public View auV() {
        return this.dDi;
    }

    public void mU(int i) {
        if (this.dCV != null) {
            this.dCV.setVisibility(i);
        }
    }

    public void auW() {
        if (com.baidu.tbadk.k.r.NQ().NR()) {
            int lastVisiblePosition = this.dDc.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dDc.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dDL != null) {
                        com.baidu.tbadk.k.l perfLog = oVar.dDL.getPerfLog();
                        perfLog.im(1000);
                        perfLog.byw = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dDL.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dDL.startLogPerf();
                    }
                    if (oVar.dDK != null && (oVar.dDK instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dDK;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.im(1000);
                                perfLog2.byw = true;
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

    public NavigationBar auu() {
        return this.mNavigationBar;
    }

    public void auX() {
        this.mHasMore = true;
        this.dDc.setNextPage(this.bYZ);
        if (this.dDj > 0) {
            this.bYZ.gw(this.dDj);
        }
        this.bYZ.setOnClickListener(null);
        this.bYZ.DM();
    }

    public void auY() {
        this.mHasMore = false;
        this.dDc.setNextPage(this.bYZ);
        if (this.dDj > 0) {
            this.bYZ.gw(this.dDj);
        }
        this.bYZ.setOnClickListener(null);
        this.bYZ.DN();
        this.bYZ.setText(this.dCS.getResources().getString(d.j.list_no_more));
    }

    public void auZ() {
        this.mHasMore = true;
        this.dDc.setNextPage(this.bYZ);
        this.bYZ.setOnClickListener(this.dDg);
        if (this.dDj > 0) {
            this.bYZ.gw(this.dDj);
        }
        this.bYZ.DN();
        this.bYZ.setText(this.dCS.getResources().getString(d.j.list_click_load_more));
    }

    public View ava() {
        if (this.bYZ == null) {
            return null;
        }
        return this.bYZ.getView();
    }

    public void alU() {
        this.mHasMore = false;
        this.dDc.setNextPage(null);
    }

    public boolean alK() {
        return this.bYZ.getView().getParent() != null && this.mHasMore;
    }

    public void mV(int i) {
        this.dDj = i;
    }

    public void mW(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.doa == null) {
                    this.doa = new CommonTipView(this.dCS.getActivity());
                }
                this.doa.setText(d.j.frs_login_tip);
                this.doa.show((FrameLayout) auV(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fK(boolean z) {
        if (this.dDs != null) {
            if (z) {
                this.dDs.io(false);
                this.dDs.aCG();
                return;
            }
            this.dDs.io(true);
            this.dDs.c(this.dCL, this.bXz, this.dDk, true);
        }
    }

    public void bw(int i, int i2) {
        if (this.dDs != null) {
            this.dDs.a(i, i2, this.dDk, 1);
        }
    }

    public void bx(int i, int i2) {
        this.dCL = i;
        this.bXz = i2;
    }

    public void fL(boolean z) {
        this.dDk = z;
    }

    public void avb() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.s(this.mBackImageView, d.f.frs_star_navigation_bg);
        }
    }

    private void avc() {
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

    private void fM(boolean z) {
        boolean i = com.baidu.tieba.frs.f.f.i(this.dCS.auv());
        boolean h = com.baidu.tieba.frs.f.f.h(this.dCS.auv());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.cFL) {
                    this.cFL = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.dCX, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.s(this.mBackImageView, d.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.cFL) {
                this.cFL = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.dCX, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        avc();
    }

    public void fN(boolean z) {
    }

    public void mX(int i) {
        if (this.dDc != null && this.dDc.getChildCount() >= 0) {
            if (this.dDc.getFirstVisiblePosition() > 8) {
                this.dDc.scrollToPosition(8);
            }
            this.dDc.smoothScrollToPosition(i);
        }
    }

    public void avd() {
        a(this.dDv, this.dCS.auy());
        if (this.dDd != null) {
            this.dDd.awu();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dDx == null) {
                this.dDx = new com.baidu.tieba.video.e(this.dCS.getActivity(), this.dCT);
            }
            this.dDx.g(postWriteCallBackData);
        }
    }

    public void ave() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dDC && this.dCS.getActivity() != null && this.dCS.getPageContext() != null) {
            View view = null;
            if (this.dDc != null && (headerViewsCount = this.dDc.getHeaderViewsCount()) < this.dDc.getChildCount()) {
                view = this.dDc.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.aG(view).cW(0).ah(true).ai(false).ag(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.6
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.dCS.getPageContext().getLayoutMode().aM(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int mB() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int mC() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.s(k.this.dCS.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.s(k.this.dCS.getActivity(), d.e.ds6);
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
                final com.baidu.adp.lib.guide.c mD = dVar.mD();
                mD.af(false);
                mD.j(this.dCS.getActivity());
                com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mD != null) {
                            mD.dismiss();
                        }
                    }
                }, 4000L);
                this.dDC = true;
            }
        }
    }
}
