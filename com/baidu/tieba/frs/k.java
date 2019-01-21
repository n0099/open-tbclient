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
    private AppBarLayout QZ;
    private PbListView bPn;
    private BdSwipeRefreshLayout bSa;
    private com.baidu.tieba.frs.entelechy.b.d dNA;
    private com.baidu.tieba.frs.entelechy.b.c dNB;
    private com.baidu.tieba.frs.vc.j dNC;
    private GifView dND;
    private TbImageView dNE;
    private HashSet<String> dNF;
    private com.baidu.tieba.play.m dNG;
    private ObservedChangeLinearLayout dNJ;
    private com.baidu.tieba.frs.entelechy.b.a dNK;
    private com.baidu.tieba.video.f dNL;
    private AppBarLayoutStickyBehavior dNM;
    private FrsHeaderViewContainer dNN;
    private CollapsingToolbarLayout dNO;
    private com.baidu.tieba.frs.vc.f dNS;
    private FrsMultiDelBottomMenuView dNT;
    private NavigationBarCoverTip dNU;
    private TextView dNV;
    private boolean dNY;
    private FrsFragment dNc;
    private View dNg;
    private ImageView dNh;
    private com.baidu.tieba.c.b dNi;
    private ViewStub dNj;
    private com.baidu.tieba.frs.entelechy.a.q dNo;
    private FloatingAnimationView dNp;
    private com.baidu.tieba.c.c dNq;
    private View.OnClickListener dNs;
    private View dNu;
    private View dNv;
    private int dNx;
    private View dNz;
    private NoNetworkView drP;
    private CommonTipView dtu;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dNb = false;
    private NoPressedRelativeLayout dNd = null;
    private CoordinatorLayout dNe = null;
    private View dNf = null;
    private FrameLayout dNk = null;
    private TbImageView dNl = null;
    private TbImageView dNm = null;
    private BdTypeRecyclerView dNn = null;
    private com.baidu.tbadk.core.dialog.b dNr = null;
    private NoNetworkView.a dJn = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener dNt = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dNn != null && k.this.dNn.getAdapter() != null) {
                k.this.dNn.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dNw = true;
    private boolean mHasMore = true;
    private boolean dNy = false;
    private int dMT = 0;
    private int bNQ = 0;
    private View dNH = null;
    private View dNI = null;
    private boolean cHR = false;
    private boolean mIsNeedRefresh = true;
    private boolean dNP = true;
    private int dNQ = -1;
    private int dNR = -1;
    private AppBarLayout.OnOffsetChangedListener dNW = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dNR != i && Math.abs(i) >= 0 && k.this.aCH() != -1) {
                if (Math.abs(i) >= k.this.aCH()) {
                    if (k.this.dNP) {
                        k.this.dNP = false;
                        k.this.gB(k.this.dNP);
                    }
                } else if (!k.this.dNP) {
                    k.this.dNP = true;
                    k.this.gB(k.this.dNP);
                }
                int aCD = k.this.aCD() + k.this.aCC() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - aCD;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dNR - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.mn(Math.abs(aCD - totalScrollRange2));
                        if (k.this.dNI != null) {
                            k.this.dNI.setVisibility(0);
                        }
                    } else if (k.this.dNI != null) {
                        if (k.this.aCB() != UtilHelper.getStatusBarHeight()) {
                            k.this.mn(0);
                        }
                        k.this.dNI.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.cHR) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.aDi();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.dNR = i;
                }
            }
        }
    };
    private Runnable dNX = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dNj != null) {
                k.this.dNk.setVisibility(0);
                k.this.dNm.setVisibility(0);
                k.this.dNl.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dNZ = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.QZ.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout aCy() {
        return this.dNJ;
    }

    public View aCz() {
        return this.dNH;
    }

    public View aCA() {
        return this.dNI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCB() {
        if (this.dNH == null) {
            return 0;
        }
        return this.dNH.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCC() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCD() {
        if (this.drP == null || com.baidu.adp.lib.util.j.kV()) {
            return 0;
        }
        return this.drP.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(int i) {
        View aCz = aCz();
        View aCA = aCA();
        if (UtilHelper.canUseStyleImmersiveSticky() && aCz != null && aCA != null && aCz.getLayoutParams() != null && aCA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = aCz.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            aCz.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = aCA.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            aCA.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dNc = null;
        this.dNs = null;
        this.dNx = 0;
        this.dNc = frsFragment;
        this.dNs = onClickListener;
        a(aVar, z);
        this.dNF = new HashSet<>();
        this.dNx = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dNS = fVar;
    }

    private boolean aCE() {
        return this.dNS != null && this.dNS.aIr();
    }

    private void vB() {
        this.dNc.registerListener(this.dNZ);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        vB();
        this.dNK = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dNc.getPageContext());
        }
        this.mPullView.setTag(this.dNc.getUniqueId());
        if (this.dNd == null) {
            this.dNd = (NoPressedRelativeLayout) this.dNc.mRootView.findViewById(e.g.frs);
        }
        if (this.dNf == null) {
            this.dNf = this.dNc.mRootView.findViewById(e.g.frs_content_container);
        }
        if (this.dNe == null) {
            this.dNe = (CoordinatorLayout) this.dNc.mRootView.findViewById(e.g.frs_nested_scroll_layout);
        }
        if (this.dNv == null) {
            this.dNv = this.dNc.mRootView.findViewById(e.g.frs_list_content);
        }
        if (this.dNO == null) {
            this.dNO = (CollapsingToolbarLayout) this.dNc.mRootView.findViewById(e.g.frs_collapse_layout);
        }
        if (this.dNN == null) {
            this.dNN = (FrsHeaderViewContainer) this.dNc.mRootView.findViewById(e.g.header_view_container);
        }
        if (this.dNJ == null) {
            this.dNJ = (ObservedChangeLinearLayout) this.dNc.mRootView.findViewById(e.g.navigation_bar_wrapperLayout);
            this.dNJ.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dNO.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dNc.mRootView.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dNc.aCn()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dNu == null) {
            this.dNu = this.dNc.mRootView.findViewById(e.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aEz = aVar.aEz();
            if (aEz != null) {
                aEz.aP(this.dNu);
            }
        }
        if (this.dNg == null) {
            this.dNg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dNg.setOnClickListener(this.dNs);
            this.mBackImageView = (ImageView) this.dNg.findViewById(e.g.widget_navi_back_button);
        }
        if (this.dNh == null) {
            this.dNh = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dNh.setOnClickListener(this.dNs);
        }
        if (this.dNi == null) {
            this.dNi = new com.baidu.tieba.c.b(this.dNc.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dNi.getView(), (View.OnClickListener) null);
            this.dNi.getView().setOnClickListener(this.dNs);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dNc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        if (this.bSa == null) {
            this.bSa = (BdSwipeRefreshLayout) this.dNc.mRootView.findViewById(e.g.frs_pull_refresh_layout);
            this.bSa.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.j(this.bSa, e.d.cp_bg_line_c);
        }
        if (this.dNn == null) {
            this.dNn = (BdTypeRecyclerView) this.dNc.mRootView.findViewById(e.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int dOc = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.dOc--;
                if (this.dOc == 0) {
                    k.this.dNn.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.dOc++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dNn.setItemAnimator(defaultItemAnimator);
        this.dNn.setLayoutManager(new LinearLayoutManager(this.dNn.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.dNn.setScrollable(this.dNc);
        this.dNn.setFadingEdgeLength(0);
        this.dNn.setOverScrollMode(2);
        this.dNd.setBottomOrderView(this.dNn);
        this.dNn.setOnTouchListener(this.dNc.bjD);
        this.dNn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dNG != null) {
                    k.this.dNG.bm(view);
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
        if (this.bPn == null) {
            this.bPn = new PbListView(this.dNc.getPageContext().getPageActivity());
            this.bPn.getView();
        }
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.setHeight(com.baidu.adp.lib.util.l.h(this.dNc.getActivity(), e.C0210e.tbds182));
        this.bPn.Fm();
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
        this.bPn.ew(e.d.cp_cont_e);
        this.dNn.setOnSrollToBottomListener(this.dNc);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dNc.aCk();
                if (k.this.dNc != null && k.this.QZ != null) {
                    k.this.dNc.aCp();
                    k.this.QZ.setExpanded(true);
                    if (k.this.dNG != null) {
                        k.this.dNG.b(k.this.dMT, k.this.bNQ, false, true);
                    }
                }
            }
        });
        boolean Eg = com.baidu.tbadk.core.util.aq.Ee().Eg();
        if (this.dNo == null) {
            this.dNo = aVar.a(this.dNc, this.dNn, Eg);
        }
        dl(false);
        if (!z) {
            if (this.drP == null) {
                this.drP = new NoNetworkView(this.dNc.getActivity());
                this.drP.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dNJ.addView(this.drP);
            }
            if (com.baidu.adp.lib.util.j.kK()) {
                this.drP.setVisibility(8);
            } else {
                this.drP.setVisibility(0);
            }
            this.drP.onChangeSkinType(this.dNc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aCO();
        if (this.dNA == null) {
            this.dNA = aVar.c(this.dNc, this.dNd);
        }
        if (this.dNB == null) {
            this.dNB = aVar.b(this.dNc, this.dNd);
            gE(true);
        }
        if (this.dNH == null) {
            this.dNH = this.dNc.mRootView.findViewById(e.g.statebar_view);
        }
        if (this.dNI == null) {
            this.dNI = this.dNc.mRootView.findViewById(e.g.statebar_view_holder);
        }
        if (this.dNG == null) {
            this.dNG = new com.baidu.tieba.play.m(this.dNc.getPageContext(), this.dNn);
        }
        this.dNG.setUniqueId(this.dNc.getUniqueId());
        this.dNU = (NavigationBarCoverTip) this.dNc.mRootView.findViewById(e.g.navigation_cover_tip);
        if (this.dNC == null) {
            this.dNC = new com.baidu.tieba.frs.vc.j(this.dNc, this.dNU);
        }
        if (this.QZ == null) {
            this.QZ = (AppBarLayout) this.dNc.mRootView.findViewById(e.g.frs_app_bar_layout);
            this.QZ.addOnOffsetChangedListener(this.dNW);
            this.dNP = true;
            this.dNQ = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.QZ.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dNM = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.dNT = (FrsMultiDelBottomMenuView) this.dNc.mRootView.findViewById(e.g.frs_multi_delete_menu_view);
        this.dNT.setPageContext(this.dNc.getPageContext());
        this.dNp = (FloatingAnimationView) this.dNc.mRootView.findViewById(e.g.redpacket_view);
        this.dNp.setPageId(this.dNc.getUniqueId());
        this.dNq = new com.baidu.tieba.c.c(this.dNc.getTbPageContext(), this.dNp, 2);
    }

    public void gA(boolean z) {
        if (z && this.dNq != null) {
            this.dNq.asu();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dNq != null) {
            this.dNq.a(mVar);
        }
    }

    private void aCF() {
        ViewGroup.LayoutParams layoutParams;
        this.cHR = aCE();
        if (this.dNN != null && (layoutParams = this.dNN.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cHR) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds88) + aCC(), 0, 0);
            }
            this.dNN.requestLayout();
        }
    }

    public void aCG() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dNJ != null) {
            aCF();
            if (this.cHR) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dNH != null) {
                    this.dNH.setAlpha(1.0f);
                }
                if (this.dNI != null) {
                    this.dNI.setAlpha(1.0f);
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
    public void gB(boolean z) {
        if (z && this.dNc != null && this.dNc.aBR() != null) {
            this.dNc.aBR().aIv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCH() {
        int i;
        if (this.QZ == null) {
            return this.dNQ;
        }
        if (this.dNQ != -1) {
            return this.dNQ;
        }
        int childCount = this.QZ.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.QZ.getChildAt(childCount);
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
        this.dNQ = Math.max(0, this.QZ.getTotalScrollRange() - Math.abs(i2));
        return this.dNQ;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dNz != null && this.dNz.getLayoutParams() != null) {
            this.dNz.getLayoutParams().height = i;
            this.dNz.setLayoutParams(this.dNz.getLayoutParams());
        }
    }

    public void ov(String str) {
        if (this.dNC != null) {
            this.dNC.ov(str);
        }
    }

    public View aCI() {
        return this.dNz;
    }

    public com.baidu.tieba.play.m aCJ() {
        return this.dNG;
    }

    public com.baidu.tieba.frs.entelechy.b.c aCK() {
        return this.dNB;
    }

    public void gC(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.I(this.dNc.aCl().bDu());
        if (this.dNA != null) {
            this.dNA.gC(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aCL() {
        return this.dNA;
    }

    public void B(boolean z, boolean z2) {
        if (this.mIsNeedRefresh && this.dNB != null) {
            this.dNB.B(z, z2);
        }
    }

    public void gD(boolean z) {
        this.mIsNeedRefresh = z;
        if (!this.mIsNeedRefresh && this.dNB != null) {
            this.dNB.B(false, false);
        }
    }

    public void aCM() {
        if (this.mIsNeedRefresh && this.dNB != null) {
            this.dNB.B(false, false);
        }
        this.dNh.setVisibility(8);
        gC(false);
        this.dNn.setVisibility(8);
        this.dNN.setVisibility(8);
    }

    public void aCN() {
        if (this.mIsNeedRefresh && this.dNB != null) {
            this.dNB.B(true, false);
        }
        this.dNh.setVisibility(0);
        gC(this.dNc.aCs());
        this.dNn.setVisibility(0);
        this.dNN.setVisibility(0);
    }

    public void gE(boolean z) {
        if (this.dNB != null) {
            this.dNB.hh(z);
        }
    }

    private void aCO() {
        if (this.dND == null) {
            this.dND = (GifView) this.dNc.mRootView.findViewById(e.g.gif_real_time);
            this.dNE = (TbImageView) this.dNc.mRootView.findViewById(e.g.tbimg_real_time);
            this.dNE.setPageId(this.dNc.getUniqueId());
            this.dND.setLayerType(1, null);
            this.dNE.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aCP() {
        return this.dNg;
    }

    public void h(NoNetworkView.a aVar) {
        this.dJn = aVar;
        if (this.drP != null) {
            this.drP.a(this.dJn);
        }
    }

    public void dl(boolean z) {
        this.dNb = z;
        if (z) {
            if (this.dNB != null) {
                this.dNB.aFj();
                return;
            }
            return;
        }
        this.dNn.getAdapter().notifyDataSetChanged();
        if (this.dNB != null) {
            this.dNB.aFk();
        }
    }

    public void gF(boolean z) {
        if (this.dNB != null) {
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
        this.dNn.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dNo.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dNo.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dNG != null) {
            this.dNG.destroy();
        }
        if (this.dNC != null) {
            this.dNC.onDestory();
        }
        if (this.dNT != null) {
            this.dNT.setPageContext(null);
        }
        this.dNo.onDestory();
        this.dNn.setOnSrollToBottomListener(null);
        this.dNn.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dNX);
        if (this.dtu != null) {
            this.dtu.onDestroy();
        }
        this.dNF.clear();
        if (this.dNA != null) {
            this.dNA.aFl();
        }
        if (this.dNL != null) {
            this.dNL.aEp();
        }
        if (this.dNq != null) {
            this.dNq.onDestroy();
        }
        if (this.dNU != null) {
            this.dNU.onDestroy();
        }
        if (this.dNT != null) {
            this.dNT.onDestroy();
        }
    }

    public boolean aCQ() {
        if (this.QZ == null || this.dNM == null || !this.dNM.isSticky()) {
            return this.dNA != null && this.dNA.aCQ();
        }
        if (this.dNn != null) {
            this.dNn.setSelection(0);
        }
        this.dNM.expandedAppBarLayout(this.QZ);
        return true;
    }

    public boolean aCm() {
        return this.dNb;
    }

    public void anM() {
        this.dNn.setVisibility(0);
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
            com.baidu.tbadk.core.i.xR().ej(str);
        }
    }

    public void aCR() {
        if (this.dNo != null) {
            this.dNo.notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.dNo instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dNo).notifyDataChanged();
        }
    }

    private void aCS() {
        if (this.dNr == null && this.dNc.getPageContext() != null) {
            String[] strArr = {this.dNc.getPageContext().getPageActivity().getString(e.j.take_photo), this.dNc.getPageContext().getPageActivity().getString(e.j.album)};
            this.dNr = new com.baidu.tbadk.core.dialog.b(this.dNc.getPageContext().getPageActivity());
            this.dNr.eL(this.dNc.getPageContext().getPageActivity().getString(e.j.operation));
            this.dNr.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dNc.takePhoto();
                    } else if (i == 1 && k.this.dNc.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.x(k.this.dNc.getPageContext().getPageActivity());
                    }
                }
            });
            this.dNr.d(this.dNc.getPageContext());
        }
    }

    public void aCT() {
        aCS();
        if (this.dNr != null) {
            this.dNr.BV();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.I(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dNc != null && this.dNc.aBP() != null && this.dNc.aBP().aHw() == 0) {
                mVar.mw(this.dNc.aBP().aHE());
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
        this.dNo.b(arrayList, lVar);
        if (this.dNG != null && this.dMT != 0) {
            this.dNG.b(this.dMT, this.bNQ, this.dNy, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dNn;
    }

    public void aCU() {
        this.dNo.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dNc.getPageContext(), 1);
        aVar.a(this.dNn);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dNc.getForumName());
        hashMap.put("forum_id", this.dNc.getForumId());
        aVar.setParams(hashMap);
        aVar.Q(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dNA != null) {
            this.dNA.aFm();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        mo(TbadkCoreApplication.getInst().getSkinType());
        aDi();
        if (this.dNA != null) {
            this.dNA.aFn();
        }
    }

    public void release() {
        if (this.drP != null && this.dJn != null) {
            this.drP.b(this.dJn);
        }
    }

    public ImageView aCV() {
        return this.dNh;
    }

    public View aCW() {
        if (this.dNi != null) {
            return this.dNi.getView();
        }
        return null;
    }

    public void p(int i, boolean z) {
        if (this.dNi != null) {
            this.dNi.h(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dNc, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dNc.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dNE != null) {
            this.dNE.invalidate();
        }
        if (this.dNo != null) {
            this.dNo.aEZ();
            this.dNo.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dNc.getPageContext(), this.dNd);
        mo(i);
        if (this.drP != null) {
            this.drP.onChangeSkinType(this.dNc.getPageContext(), i);
        }
        if (this.bPn != null) {
            this.bPn.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
            this.bPn.ey(i);
        }
        aDi();
        if (this.dNB != null) {
            this.dNB.onChangeSkinType(i);
        }
        if (this.dNA != null) {
            this.dNA.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dNT != null) {
            this.dNT.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.j(this.bSa, e.d.cp_bg_line_e);
    }

    private void mo(int i) {
        if (this.dNc != null) {
            Pair<Integer, Integer> pair = this.dNc.dLF;
            if (pair != null) {
                a(i, pair);
            } else {
                mp(i);
            }
        }
    }

    private void mp(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.al.dP(e.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dNc.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.al.e(this.dNu, e.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
            int i2 = e.d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.ap.Ed().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.Ed().c(this.dNh, e.f.icon_topbar_search_n_svg, i2);
            if (this.dNi != null) {
                this.dNi.lf(i2);
                this.dNi.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dNH, i);
        UtilHelper.setStatusBarBackground(this.dNI, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dNc.getPageContext(), i);
                com.baidu.tbadk.core.util.al.e(this.dNu, e.d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dNH, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dNI, pair);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.ap.Ed().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.Ed().c(this.dNh, e.f.icon_topbar_search_n_svg, i2);
            if (this.dNi != null) {
                this.dNi.lf(i2);
                this.dNi.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dNn != null) {
            this.dNn.setSelection(0);
        }
        if (this.QZ != null) {
            this.QZ.setExpanded(true);
        }
        if (this.bSa != null && this.bSa.isEnabled()) {
            this.bSa.setRefreshing(true);
        }
    }

    public void gG(boolean z) {
        if (z) {
            this.bSa.setRefreshing(false);
        } else {
            this.bSa.pl();
        }
    }

    public void gH(boolean z) {
        this.bSa.setEnabled(z);
    }

    public void gI(boolean z) {
        this.dNw = z;
        if (this.dNw) {
            this.bPn.setText(this.dNc.getResources().getString(e.j.load_more));
            if (this.dNn.getChildAt(this.dNn.getChildCount() - 1) == this.bPn.getView()) {
                this.bPn.Fp();
                this.dNc.aaA();
                return;
            }
            this.bPn.Fq();
            return;
        }
        this.bPn.setText(this.dNc.getResources().getString(e.j.load_more_must_after_delete));
        this.bPn.Fq();
    }

    public boolean aCX() {
        if (this.dNw) {
            return false;
        }
        this.bPn.setText(this.dNc.getResources().getString(e.j.load_more_must_after_delete));
        this.bPn.Fq();
        return true;
    }

    public boolean aCY() {
        return this.dNj != null && this.dNm.getVisibility() == 0;
    }

    public void aCZ() {
        if (this.dNj != null) {
            this.dNk.setVisibility(0);
            this.dNm.setVisibility(8);
            this.dNl.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dNX, 5000L);
        }
    }

    public void a(bi biVar) {
        if (this.dNj == null) {
            this.dNj = (ViewStub) this.dNc.mRootView.findViewById(e.g.yule_game_egg_view_stub);
            this.dNj.setVisibility(0);
            this.dNk = (FrameLayout) this.dNc.mRootView.findViewById(e.g.game_activity_egg_layout);
            this.dNl = (TbImageView) this.dNc.mRootView.findViewById(e.g.game_activity_egg);
            this.dNm = (TbImageView) this.dNc.mRootView.findViewById(e.g.game_activity_egg_s);
            this.dNl.setPageId(this.dNc.getUniqueId());
            this.dNm.setPageId(this.dNc.getUniqueId());
            this.dNl.setDefaultBgResource(e.d.common_color_10022);
            this.dNl.setDefaultResource(0);
            this.dNm.setDefaultBgResource(e.d.common_color_10022);
            this.dNm.setDefaultResource(0);
            this.dNk.setOnClickListener(this.dNs);
        }
        this.dNk.setVisibility(0);
        String BI = biVar.BI();
        String BJ = biVar.BJ();
        this.dNl.startLoad(BI, 10, false);
        this.dNm.startLoad(BJ, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dNX, 5000L);
    }

    public void aDa() {
        if (this.dNj != null) {
            this.dNk.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aDb() {
        return this.dNo;
    }

    public RelativeLayout aDc() {
        return this.dNd;
    }

    public View aDd() {
        return this.dNv;
    }

    public void mq(int i) {
        if (this.dNf != null) {
            this.dNf.setVisibility(i);
        }
    }

    public void aDe() {
        if (com.baidu.tbadk.l.m.PD().PE()) {
            int lastVisiblePosition = this.dNn.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dNn.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dOi != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dOi.getPerfLog();
                        perfLog.gj(1000);
                        perfLog.bgB = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dOi.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dOi.startLogPerf();
                    }
                    if (oVar.dOh != null && (oVar.dOh instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dOh;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.gj(1000);
                                perfLog2.bgB = true;
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

    public NavigationBar act() {
        return this.mNavigationBar;
    }

    public void aby() {
        this.mHasMore = true;
        this.dNn.setNextPage(this.bPn);
        if (this.dNx > 0) {
            this.bPn.ez(this.dNx);
        }
        this.bPn.setOnClickListener(null);
        this.bPn.Fp();
    }

    public void abz() {
        this.mHasMore = false;
        this.dNn.setNextPage(this.bPn);
        if (this.dNx > 0) {
            this.bPn.ez(this.dNx);
        }
        this.bPn.setOnClickListener(null);
        this.bPn.Fq();
        this.bPn.setText(this.dNc.getResources().getString(e.j.list_has_no_more));
    }

    public void aDf() {
        this.mHasMore = true;
        this.dNn.setNextPage(this.bPn);
        this.bPn.setOnClickListener(this.dNs);
        if (this.dNx > 0) {
            this.bPn.ez(this.dNx);
        }
        this.bPn.Fq();
        this.bPn.setText(this.dNc.getResources().getString(e.j.list_click_load_more));
    }

    public View aDg() {
        if (this.bPn == null) {
            return null;
        }
        return this.bPn.getView();
    }

    public void mr(int i) {
        if (this.dNT != null) {
            this.dNT.setVisibility(i);
        }
    }

    public void ms(int i) {
        if (this.dNT != null) {
            this.dNT.setSelectNumber(i);
        }
    }

    public void abA() {
        this.mHasMore = false;
        this.dNn.setNextPage(null);
    }

    public boolean arM() {
        return this.bPn.getView().getParent() != null && this.mHasMore;
    }

    public void mt(int i) {
        this.dNx = i;
    }

    public void mu(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dtu == null) {
                    this.dtu = new CommonTipView(this.dNc.getActivity());
                }
                this.dtu.setText(e.j.frs_login_tip);
                this.dtu.show((FrameLayout) aDd(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void gJ(boolean z) {
        if (this.dNG != null) {
            if (z) {
                this.dNG.jC(false);
                this.dNG.baq();
                return;
            }
            this.dNG.jC(true);
            this.dNG.b(this.dMT, this.bNQ, this.dNy, true);
        }
    }

    public void aL(int i, int i2) {
        if (this.dNG != null) {
            this.dNG.a(i, i2, this.dNy, 1);
        }
    }

    public void aM(int i, int i2) {
        this.dMT = i;
        this.bNQ = i2;
    }

    public void gK(boolean z) {
        this.dNy = z;
    }

    private void aDh() {
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
            if (this.dNH != null) {
                this.dNH.setAlpha(alpha);
            }
            if (this.dNI != null) {
                this.dNI.setAlpha(alpha);
            }
            if (this.dNu != null) {
                this.dNu.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDi() {
        if (this.dNc.dLF == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cHR) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.al.a(this.dNh, e.f.icon_sml_search_bg, e.f.icon_sml_search_bg);
                if (this.dNi != null) {
                    com.baidu.tbadk.core.util.al.a(this.dNi.asr(), e.f.icon_topbar_white_remind, e.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.icon_return_bg_s, e.f.icon_return_bg);
                com.baidu.tbadk.core.util.al.a(this.dNh, e.f.icon_search_bg_s, e.f.icon_search_bg);
                if (this.dNi != null) {
                    com.baidu.tbadk.core.util.al.a(this.dNi.asr(), e.f.icon_topbar_remind, e.f.icon_topbar_remind);
                }
            }
            aDh();
        }
    }

    public void gL(boolean z) {
    }

    public void mv(int i) {
        if (this.dNn != null && this.dNn.getChildCount() >= 0) {
            if (this.dNn.getFirstVisiblePosition() > 8) {
                this.dNn.scrollToPosition(8);
            }
            this.dNn.smoothScrollToPosition(i);
        }
    }

    public void aDj() {
        a(this.dNK, this.dNc.aCn());
        if (this.dNo != null) {
            this.dNo.aFd();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dNL == null) {
                this.dNL = new com.baidu.tieba.video.f(this.dNc.getActivity(), this.dNd);
            }
            this.dNL.h(postWriteCallBackData);
        }
    }

    public void aDk() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dNY && this.dNc.getActivity() != null && this.dNc.getPageContext() != null) {
            View view = null;
            if (this.dNn != null && (headerViewsCount = this.dNn.getHeaderViewsCount()) < this.dNn.getChildCount()) {
                view = this.dNn.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aw(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(e.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.tips)).setText(e.j.frs_video_activity_guide_tip);
                        k.this.dNc.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.h(k.this.dNc.getActivity(), e.C0210e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.dNc.getActivity(), e.C0210e.ds6);
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
                iT.n(this.dNc.getActivity());
                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iT != null) {
                            iT.dismiss();
                        }
                    }
                }, 4000L);
                this.dNY = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.dNT != null) {
            this.dNT.setDeleteCallback(aVar);
        }
    }

    public void aDl() {
        if (this.dNT != null) {
            this.dNT.aDl();
        }
    }

    public void UX() {
        if (this.dNT != null) {
            this.dNT.UX();
        }
    }

    public void ad(String str, int i) {
        if (this.dNV == null) {
            this.dNV = new TextView(this.dNc.getActivity());
            this.dNV.setGravity(19);
            this.dNV.setPadding(com.baidu.adp.lib.util.l.h(this.dNc.getActivity(), e.C0210e.ds34), 0, com.baidu.adp.lib.util.l.h(this.dNc.getActivity(), e.C0210e.ds34), 0);
            this.dNV.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.dNc.getActivity(), e.C0210e.tbds112)));
            this.dNV.setTextSize(0, com.baidu.adp.lib.util.l.h(this.dNc.getActivity(), e.C0210e.fontsize30));
            this.dNV.setMaxLines(2);
            this.dNV.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.dNV.setTextColor(ContextCompat.getColor(this.dNc.getActivity(), e.d.cp_cont_i));
        }
        this.dNU.setBackgroundColor(i);
        this.dNV.setText(str);
        this.dNU.a(this.dNc.getActivity(), this.dNV, UIMsg.m_AppUI.MSG_APP_GPS);
    }
}
