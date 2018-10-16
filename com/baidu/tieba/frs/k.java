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
    private AppBarLayout QN;
    private PbListView bJY;
    private BdSwipeRefreshLayout bMJ;
    private FrsFragment dBO;
    private View dBS;
    private ImageView dBT;
    private com.baidu.tieba.c.b dBU;
    private ViewStub dBV;
    private FrsHeaderViewContainer dCA;
    private CollapsingToolbarLayout dCB;
    private com.baidu.tieba.frs.vc.f dCF;
    private FrsMultiDelBottomMenuView dCG;
    private NavigationBarCoverTip dCH;
    private TextView dCI;
    private boolean dCL;
    private com.baidu.tieba.frs.entelechy.a.q dCa;
    private FloatingAnimationView dCb;
    private com.baidu.tieba.c.c dCc;
    private View.OnClickListener dCe;
    private View dCg;
    private View dCh;
    private int dCj;
    private View dCl;
    private com.baidu.tieba.frs.entelechy.b.d dCm;
    private com.baidu.tieba.frs.entelechy.b.c dCn;
    private com.baidu.tieba.frs.vc.i dCo;
    private GifView dCp;
    private TbImageView dCq;
    private HashSet<String> dCr;
    private com.baidu.tieba.play.m dCs;
    private ObservedChangeLinearLayout dCv;
    private com.baidu.tieba.frs.entelechy.b.a dCw;
    private com.baidu.tieba.video.f dCy;
    private AppBarLayoutStickyBehavior dCz;
    private NoNetworkView dgC;
    private CommonTipView dim;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dBN = false;
    private NoPressedRelativeLayout dBP = null;
    private CoordinatorLayout dBQ = null;
    private View dBR = null;
    private FrameLayout dBW = null;
    private TbImageView dBX = null;
    private TbImageView dBY = null;
    private BdTypeRecyclerView dBZ = null;
    private com.baidu.tbadk.core.dialog.b dCd = null;
    private NoNetworkView.a dxY = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener dCf = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dBZ != null && k.this.dBZ.getAdapter() != null) {
                k.this.dBZ.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dCi = true;
    private boolean mHasMore = true;
    private boolean dCk = false;
    private int dBF = 0;
    private int bIA = 0;
    private View dCt = null;
    private View dCu = null;
    private boolean cBa = false;
    private boolean dCx = true;
    private boolean dCC = true;
    private int dCD = -1;
    private int dCE = -1;
    private AppBarLayout.OnOffsetChangedListener dCJ = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dCE != i && Math.abs(i) >= 0 && k.this.aAn() != -1) {
                if (Math.abs(i) >= k.this.aAn()) {
                    if (k.this.dCC) {
                        k.this.dCC = false;
                        k.this.gk(k.this.dCC);
                    }
                } else if (!k.this.dCC) {
                    k.this.dCC = true;
                    k.this.gk(k.this.dCC);
                }
                int aAi = k.this.aAi() + k.this.aAh() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - aAi;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dCE - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.lr(Math.abs(aAi - totalScrollRange2));
                        if (k.this.dCu != null) {
                            k.this.dCu.setVisibility(0);
                        }
                    } else if (k.this.dCu != null) {
                        if (k.this.aAg() != UtilHelper.getStatusBarHeight()) {
                            k.this.lr(0);
                        }
                        k.this.dCu.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.cBa) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.aAO();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.dCE = i;
                }
            }
        }
    };
    private Runnable dCK = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dBV != null) {
                k.this.dBW.setVisibility(0);
                k.this.dBY.setVisibility(0);
                k.this.dBX.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dCM = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.QN.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout aAd() {
        return this.dCv;
    }

    public View aAe() {
        return this.dCt;
    }

    public View aAf() {
        return this.dCu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aAg() {
        if (this.dCt == null) {
            return 0;
        }
        return this.dCt.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aAh() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aAi() {
        if (this.dgC == null || com.baidu.adp.lib.util.j.kX()) {
            return 0;
        }
        return this.dgC.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(int i) {
        View aAe = aAe();
        View aAf = aAf();
        if (UtilHelper.canUseStyleImmersiveSticky() && aAe != null && aAf != null && aAe.getLayoutParams() != null && aAf.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = aAe.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            aAe.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = aAf.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            aAf.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dBO = null;
        this.dCe = null;
        this.dCj = 0;
        this.dBO = frsFragment;
        this.dCe = onClickListener;
        a(aVar, z);
        this.dCr = new HashSet<>();
        this.dCj = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dCF = fVar;
    }

    private boolean aAj() {
        return this.dCF != null && this.dCF.aFX();
    }

    private void aAk() {
        this.dBO.registerListener(this.dCM);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        aAk();
        this.dCw = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dBO.getPageContext());
        }
        this.mPullView.setTag(this.dBO.getUniqueId());
        if (this.dBP == null) {
            this.dBP = (NoPressedRelativeLayout) this.dBO.mRootView.findViewById(e.g.frs);
        }
        if (this.dBR == null) {
            this.dBR = this.dBO.mRootView.findViewById(e.g.frs_content_container);
        }
        if (this.dBQ == null) {
            this.dBQ = (CoordinatorLayout) this.dBO.mRootView.findViewById(e.g.frs_nested_scroll_layout);
        }
        if (this.dCh == null) {
            this.dCh = this.dBO.mRootView.findViewById(e.g.frs_list_content);
        }
        if (this.dCB == null) {
            this.dCB = (CollapsingToolbarLayout) this.dBO.mRootView.findViewById(e.g.frs_collapse_layout);
        }
        if (this.dCA == null) {
            this.dCA = (FrsHeaderViewContainer) this.dBO.mRootView.findViewById(e.g.header_view_container);
        }
        if (this.dCv == null) {
            this.dCv = (ObservedChangeLinearLayout) this.dBO.mRootView.findViewById(e.g.navigation_bar_wrapperLayout);
            this.dCv.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dCB.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dBO.mRootView.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dBO.azT()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dCg == null) {
            this.dCg = this.dBO.mRootView.findViewById(e.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aCi = aVar.aCi();
            if (aCi != null) {
                aCi.aK(this.dCg);
            }
        }
        if (this.dBS == null) {
            this.dBS = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dBS.setOnClickListener(this.dCe);
            this.mBackImageView = (ImageView) this.dBS.findViewById(e.g.widget_navi_back_button);
        }
        if (this.dBT == null) {
            this.dBT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dBT.setOnClickListener(this.dCe);
        }
        if (this.dBU == null) {
            this.dBU = new com.baidu.tieba.c.b(this.dBO.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dBU.getView(), (View.OnClickListener) null);
            this.dBU.getView().setOnClickListener(this.dCe);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dBO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        if (this.bMJ == null) {
            this.bMJ = (BdSwipeRefreshLayout) this.dBO.mRootView.findViewById(e.g.frs_pull_refresh_layout);
            this.bMJ.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.j(this.bMJ, e.d.cp_bg_line_c);
        }
        if (this.dBZ == null) {
            this.dBZ = (BdTypeRecyclerView) this.dBO.mRootView.findViewById(e.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int dCP = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.dCP--;
                if (this.dCP == 0) {
                    k.this.dBZ.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.dCP++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dBZ.setItemAnimator(defaultItemAnimator);
        this.dBZ.setLayoutManager(new LinearLayoutManager(this.dBZ.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.dBZ.setScrollable(this.dBO);
        this.dBZ.setFadingEdgeLength(0);
        this.dBZ.setOverScrollMode(2);
        this.dBP.setBottomOrderView(this.dBZ);
        this.dBZ.setOnTouchListener(this.dBO.bez);
        this.dBZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dCs != null) {
                    k.this.dCs.bh(view);
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
        if (this.bJY == null) {
            this.bJY = new PbListView(this.dBO.getPageContext().getPageActivity());
            this.bJY.getView();
        }
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(com.baidu.adp.lib.util.l.h(this.dBO.getActivity(), e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
        this.bJY.dU(e.d.cp_cont_e);
        this.dBZ.setOnSrollToBottomListener(this.dBO);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dBO.azQ();
                if (k.this.dBO != null && k.this.QN != null) {
                    k.this.dBO.azV();
                    k.this.QN.setExpanded(true);
                    if (k.this.dCs != null) {
                        k.this.dCs.b(k.this.dBF, k.this.bIA, false, true);
                    }
                }
            }
        });
        boolean CI = com.baidu.tbadk.core.util.aq.CG().CI();
        if (this.dCa == null) {
            this.dCa = aVar.a(this.dBO, this.dBZ, CI);
        }
        cQ(false);
        if (!z) {
            if (this.dgC == null) {
                this.dgC = new NoNetworkView(this.dBO.getActivity());
                this.dgC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dCv.addView(this.dgC);
            }
            if (com.baidu.adp.lib.util.j.kM()) {
                this.dgC.setVisibility(8);
            } else {
                this.dgC.setVisibility(0);
            }
            this.dgC.onChangeSkinType(this.dBO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aAu();
        if (this.dCm == null) {
            this.dCm = aVar.c(this.dBO, this.dBP);
        }
        if (this.dCn == null) {
            this.dCn = aVar.b(this.dBO, this.dBP);
            gn(true);
        }
        if (this.dCt == null) {
            this.dCt = this.dBO.mRootView.findViewById(e.g.statebar_view);
        }
        if (this.dCu == null) {
            this.dCu = this.dBO.mRootView.findViewById(e.g.statebar_view_holder);
        }
        if (this.dCs == null) {
            this.dCs = new com.baidu.tieba.play.m(this.dBO.getPageContext(), this.dBZ);
        }
        this.dCs.setUniqueId(this.dBO.getUniqueId());
        this.dCH = (NavigationBarCoverTip) this.dBO.mRootView.findViewById(e.g.navigation_cover_tip);
        if (this.dCo == null) {
            this.dCo = new com.baidu.tieba.frs.vc.i(this.dBO, this.dCH);
        }
        if (this.QN == null) {
            this.QN = (AppBarLayout) this.dBO.mRootView.findViewById(e.g.frs_app_bar_layout);
            this.QN.addOnOffsetChangedListener(this.dCJ);
            this.dCC = true;
            this.dCD = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.QN.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dCz = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.dCG = (FrsMultiDelBottomMenuView) this.dBO.mRootView.findViewById(e.g.frs_multi_delete_menu_view);
        this.dCG.setPageContext(this.dBO.getPageContext());
        this.dCb = (FloatingAnimationView) this.dBO.mRootView.findViewById(e.g.redpacket_view);
        this.dCb.setPageId(this.dBO.getUniqueId());
        this.dCc = new com.baidu.tieba.c.c(this.dBO.getTbPageContext(), this.dCb, 2);
    }

    public void gj(boolean z) {
        if (z && this.dCc != null) {
            this.dCc.apT();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dCc != null) {
            this.dCc.a(mVar);
        }
    }

    private void aAl() {
        ViewGroup.LayoutParams layoutParams;
        this.cBa = aAj();
        if (this.dCA != null && (layoutParams = this.dCA.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cBa) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds88) + aAh(), 0, 0);
            }
            this.dCA.requestLayout();
        }
    }

    public void aAm() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dCv != null) {
            aAl();
            if (this.cBa) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dCt != null) {
                    this.dCt.setAlpha(1.0f);
                }
                if (this.dCu != null) {
                    this.dCu.setAlpha(1.0f);
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
    public void gk(boolean z) {
        if (z && this.dBO != null && this.dBO.azx() != null) {
            this.dBO.azx().aGb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aAn() {
        int i;
        if (this.QN == null) {
            return this.dCD;
        }
        if (this.dCD != -1) {
            return this.dCD;
        }
        int childCount = this.QN.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.QN.getChildAt(childCount);
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
        this.dCD = Math.max(0, this.QN.getTotalScrollRange() - Math.abs(i2));
        return this.dCD;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dCl != null && this.dCl.getLayoutParams() != null) {
            this.dCl.getLayoutParams().height = i;
            this.dCl.setLayoutParams(this.dCl.getLayoutParams());
        }
    }

    public void nA(String str) {
        if (this.dCo != null) {
            this.dCo.nA(str);
        }
    }

    public View aAo() {
        return this.dCl;
    }

    public com.baidu.tieba.play.m aAp() {
        return this.dCs;
    }

    public com.baidu.tieba.frs.entelechy.b.c aAq() {
        return this.dCn;
    }

    public void gl(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.J(this.dBO.azR().bAE());
        if (this.dCm != null) {
            this.dCm.gl(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aAr() {
        return this.dCm;
    }

    public void z(boolean z, boolean z2) {
        if (this.dCx && this.dCn != null) {
            this.dCn.z(z, z2);
        }
    }

    public void gm(boolean z) {
        this.dCx = z;
        if (!this.dCx && this.dCn != null) {
            this.dCn.z(false, false);
        }
    }

    public void aAs() {
        if (this.dCx && this.dCn != null) {
            this.dCn.z(false, false);
        }
        this.dBT.setVisibility(8);
        gl(false);
        this.dBZ.setVisibility(8);
        this.dCA.setVisibility(8);
    }

    public void aAt() {
        if (this.dCx && this.dCn != null) {
            this.dCn.z(true, false);
        }
        this.dBT.setVisibility(0);
        gl(this.dBO.azY());
        this.dBZ.setVisibility(0);
        this.dCA.setVisibility(0);
    }

    public void gn(boolean z) {
        if (this.dCn != null) {
            this.dCn.gQ(z);
        }
    }

    private void aAu() {
        if (this.dCp == null) {
            this.dCp = (GifView) this.dBO.mRootView.findViewById(e.g.gif_real_time);
            this.dCq = (TbImageView) this.dBO.mRootView.findViewById(e.g.tbimg_real_time);
            this.dCq.setPageId(this.dBO.getUniqueId());
            this.dCp.setLayerType(1, null);
            this.dCq.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aAv() {
        return this.dBS;
    }

    public void h(NoNetworkView.a aVar) {
        this.dxY = aVar;
        if (this.dgC != null) {
            this.dgC.a(this.dxY);
        }
    }

    public void cQ(boolean z) {
        this.dBN = z;
        if (z) {
            if (this.dCn != null) {
                this.dCn.aCQ();
                return;
            }
            return;
        }
        this.dBZ.getAdapter().notifyDataSetChanged();
        if (this.dCn != null) {
            this.dCn.aCR();
        }
    }

    public void go(boolean z) {
        if (this.dCn != null) {
            if (z) {
                z(false, true);
            } else {
                z(false, false);
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
        this.dBZ.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dCa.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dCa.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dCs != null) {
            this.dCs.destroy();
        }
        if (this.dCo != null) {
            this.dCo.onDestory();
        }
        if (this.dCG != null) {
            this.dCG.setPageContext(null);
        }
        this.dCa.onDestory();
        this.dBZ.setOnSrollToBottomListener(null);
        this.dBZ.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dCK);
        if (this.dim != null) {
            this.dim.onDestroy();
        }
        this.dCr.clear();
        if (this.dCm != null) {
            this.dCm.aCS();
        }
        if (this.dCy != null) {
            this.dCy.aBV();
        }
        if (this.dCc != null) {
            this.dCc.onDestroy();
        }
        if (this.dCH != null) {
            this.dCH.onDestroy();
        }
        if (this.dCG != null) {
            this.dCG.onDestroy();
        }
    }

    public boolean aAw() {
        if (this.QN == null || this.dCz == null || !this.dCz.isSticky()) {
            return this.dCm != null && this.dCm.aAw();
        }
        if (this.dBZ != null) {
            this.dBZ.setSelection(0);
        }
        this.dCz.expandedAppBarLayout(this.QN);
        return true;
    }

    public boolean azS() {
        return this.dBN;
    }

    public void amg() {
        this.dBZ.setVisibility(0);
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
            com.baidu.tbadk.core.i.ws().dI(str);
        }
    }

    public void aAx() {
        if (this.dCa != null) {
            this.dCa.notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.dCa instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dCa).notifyDataChanged();
        }
    }

    private void aAy() {
        if (this.dCd == null && this.dBO.getPageContext() != null) {
            String[] strArr = {this.dBO.getPageContext().getPageActivity().getString(e.j.take_photo), this.dBO.getPageContext().getPageActivity().getString(e.j.album)};
            this.dCd = new com.baidu.tbadk.core.dialog.b(this.dBO.getPageContext().getPageActivity());
            this.dCd.ek(this.dBO.getPageContext().getPageActivity().getString(e.j.operation));
            this.dCd.a(strArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dBO.takePhoto();
                    } else if (i == 1 && k.this.dBO.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.w(k.this.dBO.getPageContext().getPageActivity());
                    }
                }
            });
            this.dCd.d(this.dBO.getPageContext());
        }
    }

    public void aAz() {
        aAy();
        if (this.dCd != null) {
            this.dCd.Ax();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.J(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dBO != null && this.dBO.azv() != null && this.dBO.azv().aFc() == 0) {
                mVar.lA(this.dBO.azv().aFk());
            }
        }
        if (com.baidu.tbadk.core.util.v.I(arrayList) > 0) {
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
        this.dCa.b(arrayList, lVar);
        if (this.dCs != null && this.dBF != 0) {
            this.dCs.b(this.dBF, this.bIA, this.dCk, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dBZ;
    }

    public void aAA() {
        this.dCa.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dBO.getPageContext(), 1);
        aVar.a(this.dBZ);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dBO.getForumName());
        hashMap.put("forum_id", this.dBO.getForumId());
        aVar.setParams(hashMap);
        aVar.R(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dCm != null) {
            this.dCm.aCT();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        ls(TbadkCoreApplication.getInst().getSkinType());
        aAO();
        if (this.dCm != null) {
            this.dCm.aCU();
        }
    }

    public void release() {
        if (this.dgC != null && this.dxY != null) {
            this.dgC.b(this.dxY);
        }
    }

    public ImageView aAB() {
        return this.dBT;
    }

    public View aAC() {
        if (this.dBU != null) {
            return this.dBU.getView();
        }
        return null;
    }

    public void p(int i, boolean z) {
        if (this.dBU != null) {
            this.dBU.g(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dBO, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dBO.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dCq != null) {
            this.dCq.invalidate();
        }
        if (this.dCa != null) {
            this.dCa.aCG();
            this.dCa.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dBO.getPageContext(), this.dBP);
        ls(i);
        if (this.dgC != null) {
            this.dgC.onChangeSkinType(this.dBO.getPageContext(), i);
        }
        if (this.bJY != null) {
            this.bJY.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
            this.bJY.dW(i);
        }
        aAO();
        if (this.dCn != null) {
            this.dCn.onChangeSkinType(i);
        }
        if (this.dCm != null) {
            this.dCm.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.dCG != null) {
            this.dCG.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.j(this.bMJ, e.d.cp_bg_line_e);
    }

    private void ls(int i) {
        if (this.dBO != null) {
            Pair<Integer, Integer> pair = this.dBO.dAr;
            if (pair != null) {
                a(i, pair);
            } else {
                lt(i);
            }
        }
    }

    private void lt(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.al.dn(e.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dBO.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.al.e(this.dCg, e.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
            int i2 = e.d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.ap.CF().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.CF().c(this.dBT, e.f.icon_topbar_search_n_svg, i2);
            if (this.dBU != null) {
                this.dBU.ki(i2);
                this.dBU.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dCt, i);
        UtilHelper.setStatusBarBackground(this.dCu, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dBO.getPageContext(), i);
                com.baidu.tbadk.core.util.al.e(this.dCg, e.d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dCt, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dCu, pair);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.ap.CF().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.CF().c(this.dBT, e.f.icon_topbar_search_n_svg, i2);
            if (this.dBU != null) {
                this.dBU.ki(i2);
                this.dBU.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dBZ != null) {
            this.dBZ.setSelection(0);
        }
        if (this.QN != null) {
            this.QN.setExpanded(true);
        }
        if (this.bMJ != null && this.bMJ.isEnabled()) {
            this.bMJ.setRefreshing(true);
        }
    }

    public void gp(boolean z) {
        if (z) {
            this.bMJ.setRefreshing(false);
        } else {
            this.bMJ.pk();
        }
    }

    public void gq(boolean z) {
        this.bMJ.setEnabled(z);
    }

    public void gr(boolean z) {
        this.dCi = z;
        if (this.dCi) {
            this.bJY.setText(this.dBO.getResources().getString(e.j.load_more));
            if (this.dBZ.getChildAt(this.dBZ.getChildCount() - 1) == this.bJY.getView()) {
                this.bJY.DO();
                this.dBO.YK();
                return;
            }
            this.bJY.DP();
            return;
        }
        this.bJY.setText(this.dBO.getResources().getString(e.j.load_more_must_after_delete));
        this.bJY.DP();
    }

    public boolean aAD() {
        if (this.dCi) {
            return false;
        }
        this.bJY.setText(this.dBO.getResources().getString(e.j.load_more_must_after_delete));
        this.bJY.DP();
        return true;
    }

    public boolean aAE() {
        return this.dBV != null && this.dBY.getVisibility() == 0;
    }

    public void aAF() {
        if (this.dBV != null) {
            this.dBW.setVisibility(0);
            this.dBY.setVisibility(8);
            this.dBX.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dCK, 5000L);
        }
    }

    public void a(bi biVar) {
        if (this.dBV == null) {
            this.dBV = (ViewStub) this.dBO.mRootView.findViewById(e.g.yule_game_egg_view_stub);
            this.dBV.setVisibility(0);
            this.dBW = (FrameLayout) this.dBO.mRootView.findViewById(e.g.game_activity_egg_layout);
            this.dBX = (TbImageView) this.dBO.mRootView.findViewById(e.g.game_activity_egg);
            this.dBY = (TbImageView) this.dBO.mRootView.findViewById(e.g.game_activity_egg_s);
            this.dBX.setPageId(this.dBO.getUniqueId());
            this.dBY.setPageId(this.dBO.getUniqueId());
            this.dBX.setDefaultBgResource(e.d.common_color_10022);
            this.dBX.setDefaultResource(0);
            this.dBY.setDefaultBgResource(e.d.common_color_10022);
            this.dBY.setDefaultResource(0);
            this.dBW.setOnClickListener(this.dCe);
        }
        this.dBW.setVisibility(0);
        String Ak = biVar.Ak();
        String Al = biVar.Al();
        this.dBX.startLoad(Ak, 10, false);
        this.dBY.startLoad(Al, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dCK, 5000L);
    }

    public void aAG() {
        if (this.dBV != null) {
            this.dBW.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aAH() {
        return this.dCa;
    }

    public RelativeLayout aAI() {
        return this.dBP;
    }

    public View aAJ() {
        return this.dCh;
    }

    public void lu(int i) {
        if (this.dBR != null) {
            this.dBR.setVisibility(i);
        }
    }

    public void aAK() {
        if (com.baidu.tbadk.l.m.NX().NY()) {
            int lastVisiblePosition = this.dBZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dBZ.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dCV != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dCV.getPerfLog();
                        perfLog.fG(1000);
                        perfLog.bbz = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dCV.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dCV.startLogPerf();
                    }
                    if (oVar.dCU != null && (oVar.dCU instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dCU;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fG(1000);
                                perfLog2.bbz = true;
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

    public NavigationBar aaD() {
        return this.mNavigationBar;
    }

    public void ZI() {
        this.mHasMore = true;
        this.dBZ.setNextPage(this.bJY);
        if (this.dCj > 0) {
            this.bJY.dX(this.dCj);
        }
        this.bJY.setOnClickListener(null);
        this.bJY.DO();
    }

    public void ZJ() {
        this.mHasMore = false;
        this.dBZ.setNextPage(this.bJY);
        if (this.dCj > 0) {
            this.bJY.dX(this.dCj);
        }
        this.bJY.setOnClickListener(null);
        this.bJY.DP();
        this.bJY.setText(this.dBO.getResources().getString(e.j.list_has_no_more));
    }

    public void aAL() {
        this.mHasMore = true;
        this.dBZ.setNextPage(this.bJY);
        this.bJY.setOnClickListener(this.dCe);
        if (this.dCj > 0) {
            this.bJY.dX(this.dCj);
        }
        this.bJY.DP();
        this.bJY.setText(this.dBO.getResources().getString(e.j.list_click_load_more));
    }

    public View aAM() {
        if (this.bJY == null) {
            return null;
        }
        return this.bJY.getView();
    }

    public void lv(int i) {
        if (this.dCG != null) {
            this.dCG.setVisibility(i);
        }
    }

    public void lw(int i) {
        if (this.dCG != null) {
            this.dCG.setSelectNumber(i);
        }
    }

    public void ZK() {
        this.mHasMore = false;
        this.dBZ.setNextPage(null);
    }

    public boolean apl() {
        return this.bJY.getView().getParent() != null && this.mHasMore;
    }

    public void lx(int i) {
        this.dCj = i;
    }

    public void ly(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dim == null) {
                    this.dim = new CommonTipView(this.dBO.getActivity());
                }
                this.dim.setText(e.j.frs_login_tip);
                this.dim.show((FrameLayout) aAJ(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void gs(boolean z) {
        if (this.dCs != null) {
            if (z) {
                this.dCs.jm(false);
                this.dCs.aXO();
                return;
            }
            this.dCs.jm(true);
            this.dCs.b(this.dBF, this.bIA, this.dCk, true);
        }
    }

    public void aI(int i, int i2) {
        if (this.dCs != null) {
            this.dCs.a(i, i2, this.dCk, 1);
        }
    }

    public void aJ(int i, int i2) {
        this.dBF = i;
        this.bIA = i2;
    }

    public void gt(boolean z) {
        this.dCk = z;
    }

    private void aAN() {
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
            if (this.dCt != null) {
                this.dCt.setAlpha(alpha);
            }
            if (this.dCu != null) {
                this.dCu.setAlpha(alpha);
            }
            if (this.dCg != null) {
                this.dCg.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAO() {
        if (this.dBO.dAr == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cBa) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.al.a(this.dBT, e.f.icon_sml_search_bg, e.f.icon_sml_search_bg);
                if (this.dBU != null) {
                    com.baidu.tbadk.core.util.al.a(this.dBU.apQ(), e.f.icon_topbar_white_remind, e.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.icon_return_bg_s, e.f.icon_return_bg);
                com.baidu.tbadk.core.util.al.a(this.dBT, e.f.icon_search_bg_s, e.f.icon_search_bg);
                if (this.dBU != null) {
                    com.baidu.tbadk.core.util.al.a(this.dBU.apQ(), e.f.icon_topbar_remind, e.f.icon_topbar_remind);
                }
            }
            aAN();
        }
    }

    public void gu(boolean z) {
    }

    public void lz(int i) {
        if (this.dBZ != null && this.dBZ.getChildCount() >= 0) {
            if (this.dBZ.getFirstVisiblePosition() > 8) {
                this.dBZ.scrollToPosition(8);
            }
            this.dBZ.smoothScrollToPosition(i);
        }
    }

    public void aAP() {
        a(this.dCw, this.dBO.azT());
        if (this.dCa != null) {
            this.dCa.aCK();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dCy == null) {
                this.dCy = new com.baidu.tieba.video.f(this.dBO.getActivity(), this.dBP);
            }
            this.dCy.h(postWriteCallBackData);
        }
    }

    public void aAQ() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dCL && this.dBO.getActivity() != null && this.dBO.getPageContext() != null) {
            View view = null;
            if (this.dBZ != null && (headerViewsCount = this.dBZ.getHeaderViewsCount()) < this.dBZ.getChildCount()) {
                view = this.dBZ.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).af(0).O(true).P(false).N(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(e.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.tips)).setText(e.j.frs_video_activity_guide_tip);
                        k.this.dBO.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iS() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iT() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.h(k.this.dBO.getActivity(), e.C0175e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.dBO.getActivity(), e.C0175e.ds6);
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
                final com.baidu.adp.lib.guide.c iU = dVar.iU();
                iU.L(false);
                iU.n(this.dBO.getActivity());
                com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iU != null) {
                            iU.dismiss();
                        }
                    }
                }, 4000L);
                this.dCL = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.dCG != null) {
            this.dCG.setDeleteCallback(aVar);
        }
    }

    public void aAR() {
        if (this.dCG != null) {
            this.dCG.aAR();
        }
    }

    public void Tk() {
        if (this.dCG != null) {
            this.dCG.Tk();
        }
    }

    public void ab(String str, int i) {
        if (this.dCI == null) {
            this.dCI = new TextView(this.dBO.getActivity());
            this.dCI.setGravity(19);
            this.dCI.setPadding(com.baidu.adp.lib.util.l.h(this.dBO.getActivity(), e.C0175e.ds34), 0, com.baidu.adp.lib.util.l.h(this.dBO.getActivity(), e.C0175e.ds34), 0);
            this.dCI.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.dBO.getActivity(), e.C0175e.tbds112)));
            this.dCI.setTextSize(0, com.baidu.adp.lib.util.l.h(this.dBO.getActivity(), e.C0175e.fontsize30));
            this.dCI.setMaxLines(2);
            this.dCI.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.dCI.setTextColor(ContextCompat.getColor(this.dBO.getActivity(), e.d.cp_cont_i));
        }
        this.dCH.setBackgroundColor(i);
        this.dCI.setText(str);
        this.dCH.a(this.dBO.getActivity(), this.dCI, 5000);
    }
}
