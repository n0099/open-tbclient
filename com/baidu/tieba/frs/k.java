package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.FloatingAnimationView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class k {
    private AppBarLayout QP;
    private PbListView bKJ;
    private BdSwipeRefreshLayout bNu;
    private int dDA;
    private View dDC;
    private com.baidu.tieba.frs.entelechy.b.d dDD;
    private com.baidu.tieba.frs.entelechy.b.c dDE;
    private com.baidu.tieba.frs.vc.j dDF;
    private GifView dDG;
    private TbImageView dDH;
    private HashSet<String> dDI;
    private com.baidu.tieba.play.m dDJ;
    private ObservedChangeLinearLayout dDM;
    private com.baidu.tieba.frs.entelechy.b.a dDN;
    private com.baidu.tieba.video.f dDO;
    private AppBarLayoutStickyBehavior dDP;
    private FrsHeaderViewContainer dDQ;
    private CollapsingToolbarLayout dDR;
    private com.baidu.tieba.frs.vc.f dDV;
    private FrsMultiDelBottomMenuView dDW;
    private NavigationBarCoverTip dDX;
    private TextView dDY;
    private FrsFragment dDf;
    private View dDj;
    private ImageView dDk;
    private com.baidu.tieba.c.b dDl;
    private ViewStub dDm;
    private com.baidu.tieba.frs.entelechy.a.q dDr;
    private FloatingAnimationView dDs;
    private com.baidu.tieba.c.c dDt;
    private View.OnClickListener dDv;
    private View dDx;
    private View dDy;
    private boolean dEb;
    private NoNetworkView dhH;
    private CommonTipView djr;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dDe = false;
    private NoPressedRelativeLayout dDg = null;
    private CoordinatorLayout dDh = null;
    private View dDi = null;
    private FrameLayout dDn = null;
    private TbImageView dDo = null;
    private TbImageView dDp = null;
    private BdTypeRecyclerView dDq = null;
    private com.baidu.tbadk.core.dialog.b dDu = null;
    private NoNetworkView.a dzq = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener dDw = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dDq != null && k.this.dDq.getAdapter() != null) {
                k.this.dDq.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dDz = true;
    private boolean mHasMore = true;
    private boolean dDB = false;
    private int dCW = 0;
    private int bJl = 0;
    private View dDK = null;
    private View dDL = null;
    private boolean cCi = false;
    private boolean mIsNeedRefresh = true;
    private boolean dDS = true;
    private int dDT = -1;
    private int dDU = -1;
    private AppBarLayout.OnOffsetChangedListener dDZ = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dDU != i && Math.abs(i) >= 0 && k.this.azL() != -1) {
                if (Math.abs(i) >= k.this.azL()) {
                    if (k.this.dDS) {
                        k.this.dDS = false;
                        k.this.gu(k.this.dDS);
                    }
                } else if (!k.this.dDS) {
                    k.this.dDS = true;
                    k.this.gu(k.this.dDS);
                }
                int azG = k.this.azG() + k.this.azF() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - azG;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dDU - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.lJ(Math.abs(azG - totalScrollRange2));
                        if (k.this.dDL != null) {
                            k.this.dDL.setVisibility(0);
                        }
                    } else if (k.this.dDL != null) {
                        if (k.this.azE() != UtilHelper.getStatusBarHeight()) {
                            k.this.lJ(0);
                        }
                        k.this.dDL.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.cCi) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.aAm();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.dDU = i;
                }
            }
        }
    };
    private Runnable dEa = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dDm != null) {
                k.this.dDn.setVisibility(0);
                k.this.dDp.setVisibility(0);
                k.this.dDo.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dEc = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.QP.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout azB() {
        return this.dDM;
    }

    public View azC() {
        return this.dDK;
    }

    public View azD() {
        return this.dDL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int azE() {
        if (this.dDK == null) {
            return 0;
        }
        return this.dDK.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int azF() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int azG() {
        if (this.dhH == null || com.baidu.adp.lib.util.j.kV()) {
            return 0;
        }
        return this.dhH.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(int i) {
        View azC = azC();
        View azD = azD();
        if (UtilHelper.canUseStyleImmersiveSticky() && azC != null && azD != null && azC.getLayoutParams() != null && azD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = azC.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            azC.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = azD.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            azD.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dDf = null;
        this.dDv = null;
        this.dDA = 0;
        this.dDf = frsFragment;
        this.dDv = onClickListener;
        a(aVar, z);
        this.dDI = new HashSet<>();
        this.dDA = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dDV = fVar;
    }

    private boolean azH() {
        return this.dDV != null && this.dDV.aFt();
    }

    private void azI() {
        this.dDf.registerListener(this.dEc);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        azI();
        this.dDN = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dDf.getPageContext());
        }
        this.mPullView.setTag(this.dDf.getUniqueId());
        if (this.dDg == null) {
            this.dDg = (NoPressedRelativeLayout) this.dDf.mRootView.findViewById(e.g.frs);
        }
        if (this.dDi == null) {
            this.dDi = this.dDf.mRootView.findViewById(e.g.frs_content_container);
        }
        if (this.dDh == null) {
            this.dDh = (CoordinatorLayout) this.dDf.mRootView.findViewById(e.g.frs_nested_scroll_layout);
        }
        if (this.dDy == null) {
            this.dDy = this.dDf.mRootView.findViewById(e.g.frs_list_content);
        }
        if (this.dDR == null) {
            this.dDR = (CollapsingToolbarLayout) this.dDf.mRootView.findViewById(e.g.frs_collapse_layout);
        }
        if (this.dDQ == null) {
            this.dDQ = (FrsHeaderViewContainer) this.dDf.mRootView.findViewById(e.g.header_view_container);
        }
        if (this.dDM == null) {
            this.dDM = (ObservedChangeLinearLayout) this.dDf.mRootView.findViewById(e.g.navigation_bar_wrapperLayout);
            this.dDM.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dDR.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dDf.mRootView.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dDf.azr()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dDx == null) {
            this.dDx = this.dDf.mRootView.findViewById(e.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aBD = aVar.aBD();
            if (aBD != null) {
                aBD.aM(this.dDx);
            }
        }
        if (this.dDj == null) {
            this.dDj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dDj.setOnClickListener(this.dDv);
            this.mBackImageView = (ImageView) this.dDj.findViewById(e.g.widget_navi_back_button);
        }
        if (this.dDk == null) {
            this.dDk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dDk.setOnClickListener(this.dDv);
        }
        if (this.dDl == null) {
            this.dDl = new com.baidu.tieba.c.b(this.dDf.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dDl.getView(), (View.OnClickListener) null);
            this.dDl.getView().setOnClickListener(this.dDv);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dDf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        if (this.bNu == null) {
            this.bNu = (BdSwipeRefreshLayout) this.dDf.mRootView.findViewById(e.g.frs_pull_refresh_layout);
            this.bNu.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.j(this.bNu, e.d.cp_bg_line_c);
        }
        if (this.dDq == null) {
            this.dDq = (BdTypeRecyclerView) this.dDf.mRootView.findViewById(e.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int dEf = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.dEf--;
                if (this.dEf == 0) {
                    k.this.dDq.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.dEf++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dDq.setItemAnimator(defaultItemAnimator);
        this.dDq.setLayoutManager(new LinearLayoutManager(this.dDq.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.dDq.setScrollable(this.dDf);
        this.dDq.setFadingEdgeLength(0);
        this.dDq.setOverScrollMode(2);
        this.dDg.setBottomOrderView(this.dDq);
        this.dDq.setOnTouchListener(this.dDf.bfm);
        this.dDq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dDJ != null) {
                    k.this.dDJ.bj(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(e.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(e.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        });
        if (this.bKJ == null) {
            this.bKJ = new PbListView(this.dDf.getPageContext().getPageActivity());
            this.bKJ.getView();
        }
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.setHeight(com.baidu.adp.lib.util.l.h(this.dDf.getActivity(), e.C0200e.tbds182));
        this.bKJ.DV();
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
        this.bKJ.ei(e.d.cp_cont_e);
        this.dDq.setOnSrollToBottomListener(this.dDf);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dDf.azo();
                if (k.this.dDf != null && k.this.QP != null) {
                    k.this.dDf.azt();
                    k.this.QP.setExpanded(true);
                    if (k.this.dDJ != null) {
                        k.this.dDJ.b(k.this.dCW, k.this.bJl, false, true);
                    }
                }
            }
        });
        boolean CP = com.baidu.tbadk.core.util.aq.CN().CP();
        if (this.dDr == null) {
            this.dDr = aVar.a(this.dDf, this.dDq, CP);
        }
        dh(false);
        if (!z) {
            if (this.dhH == null) {
                this.dhH = new NoNetworkView(this.dDf.getActivity());
                this.dhH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dDM.addView(this.dhH);
            }
            if (com.baidu.adp.lib.util.j.kK()) {
                this.dhH.setVisibility(8);
            } else {
                this.dhH.setVisibility(0);
            }
            this.dhH.onChangeSkinType(this.dDf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        azS();
        if (this.dDD == null) {
            this.dDD = aVar.c(this.dDf, this.dDg);
        }
        if (this.dDE == null) {
            this.dDE = aVar.b(this.dDf, this.dDg);
            gx(true);
        }
        if (this.dDK == null) {
            this.dDK = this.dDf.mRootView.findViewById(e.g.statebar_view);
        }
        if (this.dDL == null) {
            this.dDL = this.dDf.mRootView.findViewById(e.g.statebar_view_holder);
        }
        if (this.dDJ == null) {
            this.dDJ = new com.baidu.tieba.play.m(this.dDf.getPageContext(), this.dDq);
        }
        this.dDJ.setUniqueId(this.dDf.getUniqueId());
        this.dDX = (NavigationBarCoverTip) this.dDf.mRootView.findViewById(e.g.navigation_cover_tip);
        if (this.dDF == null) {
            this.dDF = new com.baidu.tieba.frs.vc.j(this.dDf, this.dDX);
        }
        if (this.QP == null) {
            this.QP = (AppBarLayout) this.dDf.mRootView.findViewById(e.g.frs_app_bar_layout);
            this.QP.addOnOffsetChangedListener(this.dDZ);
            this.dDS = true;
            this.dDT = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.QP.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dDP = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.dDW = (FrsMultiDelBottomMenuView) this.dDf.mRootView.findViewById(e.g.frs_multi_delete_menu_view);
        this.dDW.setPageContext(this.dDf.getPageContext());
        this.dDs = (FloatingAnimationView) this.dDf.mRootView.findViewById(e.g.redpacket_view);
        this.dDs.setPageId(this.dDf.getUniqueId());
        this.dDt = new com.baidu.tieba.c.c(this.dDf.getTbPageContext(), this.dDs, 2);
    }

    public void gt(boolean z) {
        if (z && this.dDt != null) {
            this.dDt.apv();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dDt != null) {
            this.dDt.a(mVar);
        }
    }

    private void azJ() {
        ViewGroup.LayoutParams layoutParams;
        this.cCi = azH();
        if (this.dDQ != null && (layoutParams = this.dDQ.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cCi) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds88) + azF(), 0, 0);
            }
            this.dDQ.requestLayout();
        }
    }

    public void azK() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dDM != null) {
            azJ();
            if (this.cCi) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dDK != null) {
                    this.dDK.setAlpha(1.0f);
                }
                if (this.dDL != null) {
                    this.dDL.setAlpha(1.0f);
                }
                if (this.mNavigationBar.mCenterText != null) {
                    this.mNavigationBar.mCenterText.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gu(boolean z) {
        if (z && this.dDf != null && this.dDf.ayV() != null) {
            this.dDf.ayV().aFx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int azL() {
        int i;
        if (this.QP == null) {
            return this.dDT;
        }
        if (this.dDT != -1) {
            return this.dDT;
        }
        int childCount = this.QP.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.QP.getChildAt(childCount);
            if (childAt == null) {
                i = i2;
            } else {
                int scrollFlags = ((AppBarLayout.LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 5) == 5) {
                    if ((scrollFlags & 8) != 0) {
                        i = ViewCompat.getMinimumHeight(childAt) + i2;
                    }
                } else if (i2 > 0) {
                    break;
                }
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        this.dDT = Math.max(0, this.QP.getTotalScrollRange() - Math.abs(i2));
        return this.dDT;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dDC != null && this.dDC.getLayoutParams() != null) {
            this.dDC.getLayoutParams().height = i;
            this.dDC.setLayoutParams(this.dDC.getLayoutParams());
        }
    }

    public void nB(String str) {
        if (this.dDF != null) {
            this.dDF.nB(str);
        }
    }

    public View azM() {
        return this.dDC;
    }

    public com.baidu.tieba.play.m azN() {
        return this.dDJ;
    }

    public com.baidu.tieba.frs.entelechy.b.c azO() {
        return this.dDE;
    }

    public void gv(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.I(this.dDf.azp().bAa());
        if (this.dDD != null) {
            this.dDD.gv(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d azP() {
        return this.dDD;
    }

    public void B(boolean z, boolean z2) {
        if (this.mIsNeedRefresh && this.dDE != null) {
            this.dDE.B(z, z2);
        }
    }

    public void gw(boolean z) {
        this.mIsNeedRefresh = z;
        if (!this.mIsNeedRefresh && this.dDE != null) {
            this.dDE.B(false, false);
        }
    }

    public void azQ() {
        if (this.mIsNeedRefresh && this.dDE != null) {
            this.dDE.B(false, false);
        }
        this.dDk.setVisibility(8);
        gv(false);
        this.dDq.setVisibility(8);
        this.dDQ.setVisibility(8);
    }

    public void azR() {
        if (this.mIsNeedRefresh && this.dDE != null) {
            this.dDE.B(true, false);
        }
        this.dDk.setVisibility(0);
        gv(this.dDf.azw());
        this.dDq.setVisibility(0);
        this.dDQ.setVisibility(0);
    }

    public void gx(boolean z) {
        if (this.dDE != null) {
            this.dDE.gZ(z);
        }
    }

    private void azS() {
        if (this.dDG == null) {
            this.dDG = (GifView) this.dDf.mRootView.findViewById(e.g.gif_real_time);
            this.dDH = (TbImageView) this.dDf.mRootView.findViewById(e.g.tbimg_real_time);
            this.dDH.setPageId(this.dDf.getUniqueId());
            this.dDG.setLayerType(1, null);
            this.dDH.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View azT() {
        return this.dDj;
    }

    public void h(NoNetworkView.a aVar) {
        this.dzq = aVar;
        if (this.dhH != null) {
            this.dhH.a(this.dzq);
        }
    }

    public void dh(boolean z) {
        this.dDe = z;
        if (z) {
            if (this.dDE != null) {
                this.dDE.aCl();
                return;
            }
            return;
        }
        this.dDq.getAdapter().notifyDataSetChanged();
        if (this.dDE != null) {
            this.dDE.aCm();
        }
    }

    public void gy(boolean z) {
        if (this.dDE != null) {
            if (z) {
                B(false, true);
            } else {
                B(false, false);
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
        this.dDq.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dDr.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dDr.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dDJ != null) {
            this.dDJ.destroy();
        }
        if (this.dDF != null) {
            this.dDF.onDestory();
        }
        if (this.dDW != null) {
            this.dDW.setPageContext(null);
        }
        this.dDr.onDestory();
        this.dDq.setOnSrollToBottomListener(null);
        this.dDq.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dEa);
        if (this.djr != null) {
            this.djr.onDestroy();
        }
        this.dDI.clear();
        if (this.dDD != null) {
            this.dDD.aCn();
        }
        if (this.dDO != null) {
            this.dDO.aBt();
        }
        if (this.dDt != null) {
            this.dDt.onDestroy();
        }
        if (this.dDX != null) {
            this.dDX.onDestroy();
        }
        if (this.dDW != null) {
            this.dDW.onDestroy();
        }
    }

    public boolean azU() {
        if (this.QP == null || this.dDP == null || !this.dDP.isSticky()) {
            return this.dDD != null && this.dDD.azU();
        }
        if (this.dDq != null) {
            this.dDq.setSelection(0);
        }
        this.dDP.expandedAppBarLayout(this.QP);
        return true;
    }

    public boolean azq() {
        return this.dDe;
    }

    public void alG() {
        this.dDq.setVisibility(0);
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
            com.baidu.tbadk.core.i.wA().dI(str);
        }
    }

    public void azV() {
        if (this.dDr != null) {
            this.dDr.notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.dDr instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dDr).notifyDataChanged();
        }
    }

    private void azW() {
        if (this.dDu == null && this.dDf.getPageContext() != null) {
            String[] strArr = {this.dDf.getPageContext().getPageActivity().getString(e.j.take_photo), this.dDf.getPageContext().getPageActivity().getString(e.j.album)};
            this.dDu = new com.baidu.tbadk.core.dialog.b(this.dDf.getPageContext().getPageActivity());
            this.dDu.ek(this.dDf.getPageContext().getPageActivity().getString(e.j.operation));
            this.dDu.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dDf.takePhoto();
                    } else if (i == 1 && k.this.dDf.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.w(k.this.dDf.getPageContext().getPageActivity());
                    }
                }
            });
            this.dDu.d(this.dDf.getPageContext());
        }
    }

    public void azX() {
        azW();
        if (this.dDu != null) {
            this.dDu.AE();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.I(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dDf != null && this.dDf.ayT() != null && this.dDf.ayT().aEy() == 0) {
                mVar.lS(this.dDf.ayT().aEG());
            }
        }
        if (com.baidu.tbadk.core.util.v.H(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
                if (hVar instanceof bb) {
                    ((bb) hVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.dDr.b(arrayList, lVar);
        if (this.dDJ != null && this.dCW != 0) {
            this.dDJ.b(this.dCW, this.bJl, this.dDB, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dDq;
    }

    public void azY() {
        this.dDr.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dDf.getPageContext(), 1);
        aVar.a(this.dDq);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dDf.getForumName());
        hashMap.put("forum_id", this.dDf.getForumId());
        aVar.setParams(hashMap);
        aVar.Q(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dDD != null) {
            this.dDD.aCo();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        lK(TbadkCoreApplication.getInst().getSkinType());
        aAm();
        if (this.dDD != null) {
            this.dDD.aCp();
        }
    }

    public void release() {
        if (this.dhH != null && this.dzq != null) {
            this.dhH.b(this.dzq);
        }
    }

    public ImageView azZ() {
        return this.dDk;
    }

    public View aAa() {
        if (this.dDl != null) {
            return this.dDl.getView();
        }
        return null;
    }

    public void p(int i, boolean z) {
        if (this.dDl != null) {
            this.dDl.g(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dDf, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dDf.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dDH != null) {
            this.dDH.invalidate();
        }
        if (this.dDr != null) {
            this.dDr.aCb();
            this.dDr.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dDf.getPageContext(), this.dDg);
        lK(i);
        if (this.dhH != null) {
            this.dhH.onChangeSkinType(this.dDf.getPageContext(), i);
        }
        if (this.bKJ != null) {
            this.bKJ.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
            this.bKJ.ek(i);
        }
        aAm();
        if (this.dDE != null) {
            this.dDE.onChangeSkinType(i);
        }
        if (this.dDD != null) {
            this.dDD.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.dDW != null) {
            this.dDW.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.j(this.bNu, e.d.cp_bg_line_e);
    }

    private void lK(int i) {
        if (this.dDf != null) {
            Pair<Integer, Integer> pair = this.dDf.dBI;
            if (pair != null) {
                a(i, pair);
            } else {
                lL(i);
            }
        }
    }

    private void lL(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.al.dB(e.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dDf.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.al.e(this.dDx, e.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
            int i2 = e.d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.ap.CM().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.CM().c(this.dDk, e.f.icon_topbar_search_n_svg, i2);
            if (this.dDl != null) {
                this.dDl.kB(i2);
                this.dDl.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dDK, i);
        UtilHelper.setStatusBarBackground(this.dDL, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dDf.getPageContext(), i);
                com.baidu.tbadk.core.util.al.e(this.dDx, e.d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dDK, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dDL, pair);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.ap.CM().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.CM().c(this.dDk, e.f.icon_topbar_search_n_svg, i2);
            if (this.dDl != null) {
                this.dDl.kB(i2);
                this.dDl.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dDq != null) {
            this.dDq.setSelection(0);
        }
        if (this.QP != null) {
            this.QP.setExpanded(true);
        }
        if (this.bNu != null && this.bNu.isEnabled()) {
            this.bNu.setRefreshing(true);
        }
    }

    public void gz(boolean z) {
        if (z) {
            this.bNu.setRefreshing(false);
        } else {
            this.bNu.pi();
        }
    }

    public void gA(boolean z) {
        this.bNu.setEnabled(z);
    }

    public void gB(boolean z) {
        this.dDz = z;
        if (this.dDz) {
            this.bKJ.setText(this.dDf.getResources().getString(e.j.load_more));
            if (this.dDq.getChildAt(this.dDq.getChildCount() - 1) == this.bKJ.getView()) {
                this.bKJ.DY();
                this.dDf.YV();
                return;
            }
            this.bKJ.DZ();
            return;
        }
        this.bKJ.setText(this.dDf.getResources().getString(e.j.load_more_must_after_delete));
        this.bKJ.DZ();
    }

    public boolean aAb() {
        if (this.dDz) {
            return false;
        }
        this.bKJ.setText(this.dDf.getResources().getString(e.j.load_more_must_after_delete));
        this.bKJ.DZ();
        return true;
    }

    public boolean aAc() {
        return this.dDm != null && this.dDp.getVisibility() == 0;
    }

    public void aAd() {
        if (this.dDm != null) {
            this.dDn.setVisibility(0);
            this.dDp.setVisibility(8);
            this.dDo.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dEa, 5000L);
        }
    }

    public void a(bi biVar) {
        if (this.dDm == null) {
            this.dDm = (ViewStub) this.dDf.mRootView.findViewById(e.g.yule_game_egg_view_stub);
            this.dDm.setVisibility(0);
            this.dDn = (FrameLayout) this.dDf.mRootView.findViewById(e.g.game_activity_egg_layout);
            this.dDo = (TbImageView) this.dDf.mRootView.findViewById(e.g.game_activity_egg);
            this.dDp = (TbImageView) this.dDf.mRootView.findViewById(e.g.game_activity_egg_s);
            this.dDo.setPageId(this.dDf.getUniqueId());
            this.dDp.setPageId(this.dDf.getUniqueId());
            this.dDo.setDefaultBgResource(e.d.common_color_10022);
            this.dDo.setDefaultResource(0);
            this.dDp.setDefaultBgResource(e.d.common_color_10022);
            this.dDp.setDefaultResource(0);
            this.dDn.setOnClickListener(this.dDv);
        }
        this.dDn.setVisibility(0);
        String Ar = biVar.Ar();
        String As = biVar.As();
        this.dDo.startLoad(Ar, 10, false);
        this.dDp.startLoad(As, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dEa, 5000L);
    }

    public void aAe() {
        if (this.dDm != null) {
            this.dDn.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aAf() {
        return this.dDr;
    }

    public RelativeLayout aAg() {
        return this.dDg;
    }

    public View aAh() {
        return this.dDy;
    }

    public void lM(int i) {
        if (this.dDi != null) {
            this.dDi.setVisibility(i);
        }
    }

    public void aAi() {
        if (com.baidu.tbadk.l.m.Og().Oh()) {
            int lastVisiblePosition = this.dDq.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dDq.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dEl != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dEl.getPerfLog();
                        perfLog.fU(1000);
                        perfLog.bcm = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dEl.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dEl.startLogPerf();
                    }
                    if (oVar.dEk != null && (oVar.dEk instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dEk;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fU(1000);
                                perfLog2.bcm = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar aaO() {
        return this.mNavigationBar;
    }

    public void ZT() {
        this.mHasMore = true;
        this.dDq.setNextPage(this.bKJ);
        if (this.dDA > 0) {
            this.bKJ.el(this.dDA);
        }
        this.bKJ.setOnClickListener(null);
        this.bKJ.DY();
    }

    public void ZU() {
        this.mHasMore = false;
        this.dDq.setNextPage(this.bKJ);
        if (this.dDA > 0) {
            this.bKJ.el(this.dDA);
        }
        this.bKJ.setOnClickListener(null);
        this.bKJ.DZ();
        this.bKJ.setText(this.dDf.getResources().getString(e.j.list_has_no_more));
    }

    public void aAj() {
        this.mHasMore = true;
        this.dDq.setNextPage(this.bKJ);
        this.bKJ.setOnClickListener(this.dDv);
        if (this.dDA > 0) {
            this.bKJ.el(this.dDA);
        }
        this.bKJ.DZ();
        this.bKJ.setText(this.dDf.getResources().getString(e.j.list_click_load_more));
    }

    public View aAk() {
        if (this.bKJ == null) {
            return null;
        }
        return this.bKJ.getView();
    }

    public void lN(int i) {
        if (this.dDW != null) {
            this.dDW.setVisibility(i);
        }
    }

    public void lO(int i) {
        if (this.dDW != null) {
            this.dDW.setSelectNumber(i);
        }
    }

    public void ZV() {
        this.mHasMore = false;
        this.dDq.setNextPage(null);
    }

    public boolean aoM() {
        return this.bKJ.getView().getParent() != null && this.mHasMore;
    }

    public void lP(int i) {
        this.dDA = i;
    }

    public void lQ(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.djr == null) {
                    this.djr = new CommonTipView(this.dDf.getActivity());
                }
                this.djr.setText(e.j.frs_login_tip);
                this.djr.show((FrameLayout) aAh(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void gC(boolean z) {
        if (this.dDJ != null) {
            if (z) {
                this.dDJ.jw(false);
                this.dDJ.aXl();
                return;
            }
            this.dDJ.jw(true);
            this.dDJ.b(this.dCW, this.bJl, this.dDB, true);
        }
    }

    public void aK(int i, int i2) {
        if (this.dDJ != null) {
            this.dDJ.a(i, i2, this.dDB, 1);
        }
    }

    public void aL(int i, int i2) {
        this.dCW = i;
        this.bJl = i2;
    }

    public void gD(boolean z) {
        this.dDB = z;
    }

    private void aAl() {
        float f;
        if (this.mNavigationBar != null) {
            float alpha = this.mNavigationBar.getBarBgView() != null ? this.mNavigationBar.getBarBgView().getAlpha() : 0.0f;
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (Float.compare(f, 0.0f) < 0) {
                f = 0.0f;
            }
            if (Float.compare(f, 1.0f) > 0) {
                f = 1.0f;
            }
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f && this.mBackImageView != null) {
                this.mBackImageView.setAlpha(f);
            }
            if (this.dDK != null) {
                this.dDK.setAlpha(alpha);
            }
            if (this.dDL != null) {
                this.dDL.setAlpha(alpha);
            }
            if (this.dDx != null) {
                this.dDx.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAm() {
        if (this.dDf.dBI == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cCi) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.al.a(this.dDk, e.f.icon_sml_search_bg, e.f.icon_sml_search_bg);
                if (this.dDl != null) {
                    com.baidu.tbadk.core.util.al.a(this.dDl.aps(), e.f.icon_topbar_white_remind, e.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.icon_return_bg_s, e.f.icon_return_bg);
                com.baidu.tbadk.core.util.al.a(this.dDk, e.f.icon_search_bg_s, e.f.icon_search_bg);
                if (this.dDl != null) {
                    com.baidu.tbadk.core.util.al.a(this.dDl.aps(), e.f.icon_topbar_remind, e.f.icon_topbar_remind);
                }
            }
            aAl();
        }
    }

    public void gE(boolean z) {
    }

    public void lR(int i) {
        if (this.dDq != null && this.dDq.getChildCount() >= 0) {
            if (this.dDq.getFirstVisiblePosition() > 8) {
                this.dDq.scrollToPosition(8);
            }
            this.dDq.smoothScrollToPosition(i);
        }
    }

    public void aAn() {
        a(this.dDN, this.dDf.azr());
        if (this.dDr != null) {
            this.dDr.aCf();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dDO == null) {
                this.dDO = new com.baidu.tieba.video.f(this.dDf.getActivity(), this.dDg);
            }
            this.dDO.h(postWriteCallBackData);
        }
    }

    public void aAo() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dEb && this.dDf.getActivity() != null && this.dDf.getPageContext() != null) {
            View view = null;
            if (this.dDq != null && (headerViewsCount = this.dDq.getHeaderViewsCount()) < this.dDq.getChildCount()) {
                view = this.dDq.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aw(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(e.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.tips)).setText(e.j.frs_video_activity_guide_tip);
                        k.this.dDf.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iR() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iS() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.h(k.this.dDf.getActivity(), e.C0200e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.dDf.getActivity(), e.C0200e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c iT = dVar.iT();
                iT.Z(false);
                iT.n(this.dDf.getActivity());
                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iT != null) {
                            iT.dismiss();
                        }
                    }
                }, 4000L);
                this.dEb = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.dDW != null) {
            this.dDW.setDeleteCallback(aVar);
        }
    }

    public void aAp() {
        if (this.dDW != null) {
            this.dDW.aAp();
        }
    }

    public void Tt() {
        if (this.dDW != null) {
            this.dDW.Tt();
        }
    }

    public void ab(String str, int i) {
        if (this.dDY == null) {
            this.dDY = new TextView(this.dDf.getActivity());
            this.dDY.setGravity(19);
            this.dDY.setPadding(com.baidu.adp.lib.util.l.h(this.dDf.getActivity(), e.C0200e.ds34), 0, com.baidu.adp.lib.util.l.h(this.dDf.getActivity(), e.C0200e.ds34), 0);
            this.dDY.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.dDf.getActivity(), e.C0200e.tbds112)));
            this.dDY.setTextSize(0, com.baidu.adp.lib.util.l.h(this.dDf.getActivity(), e.C0200e.fontsize30));
            this.dDY.setMaxLines(2);
            this.dDY.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.dDY.setTextColor(ContextCompat.getColor(this.dDf.getActivity(), e.d.cp_cont_i));
        }
        this.dDX.setBackgroundColor(i);
        this.dDY.setText(str);
        this.dDX.a(this.dDf.getActivity(), this.dDY, UIMsg.m_AppUI.MSG_APP_GPS);
    }
}
