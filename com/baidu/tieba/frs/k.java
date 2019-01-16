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
    private PbListView bPm;
    private BdSwipeRefreshLayout bRZ;
    private com.baidu.tieba.frs.entelechy.b.c dNA;
    private com.baidu.tieba.frs.vc.j dNB;
    private GifView dNC;
    private TbImageView dND;
    private HashSet<String> dNE;
    private com.baidu.tieba.play.m dNF;
    private ObservedChangeLinearLayout dNI;
    private com.baidu.tieba.frs.entelechy.b.a dNJ;
    private com.baidu.tieba.video.f dNK;
    private AppBarLayoutStickyBehavior dNL;
    private FrsHeaderViewContainer dNM;
    private CollapsingToolbarLayout dNN;
    private com.baidu.tieba.frs.vc.f dNR;
    private FrsMultiDelBottomMenuView dNS;
    private NavigationBarCoverTip dNT;
    private TextView dNU;
    private boolean dNX;
    private FrsFragment dNb;
    private View dNf;
    private ImageView dNg;
    private com.baidu.tieba.c.b dNh;
    private ViewStub dNi;
    private com.baidu.tieba.frs.entelechy.a.q dNn;
    private FloatingAnimationView dNo;
    private com.baidu.tieba.c.c dNp;
    private View.OnClickListener dNr;
    private View dNt;
    private View dNu;
    private int dNw;
    private View dNy;
    private com.baidu.tieba.frs.entelechy.b.d dNz;
    private NoNetworkView drO;
    private CommonTipView dtt;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dNa = false;
    private NoPressedRelativeLayout dNc = null;
    private CoordinatorLayout dNd = null;
    private View dNe = null;
    private FrameLayout dNj = null;
    private TbImageView dNk = null;
    private TbImageView dNl = null;
    private BdTypeRecyclerView dNm = null;
    private com.baidu.tbadk.core.dialog.b dNq = null;
    private NoNetworkView.a dJm = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener dNs = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dNm != null && k.this.dNm.getAdapter() != null) {
                k.this.dNm.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dNv = true;
    private boolean mHasMore = true;
    private boolean dNx = false;
    private int dMS = 0;
    private int bNP = 0;
    private View dNG = null;
    private View dNH = null;
    private boolean cHQ = false;
    private boolean mIsNeedRefresh = true;
    private boolean dNO = true;
    private int dNP = -1;
    private int dNQ = -1;
    private AppBarLayout.OnOffsetChangedListener dNV = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dNQ != i && Math.abs(i) >= 0 && k.this.aCH() != -1) {
                if (Math.abs(i) >= k.this.aCH()) {
                    if (k.this.dNO) {
                        k.this.dNO = false;
                        k.this.gB(k.this.dNO);
                    }
                } else if (!k.this.dNO) {
                    k.this.dNO = true;
                    k.this.gB(k.this.dNO);
                }
                int aCD = k.this.aCD() + k.this.aCC() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - aCD;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dNQ - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.mn(Math.abs(aCD - totalScrollRange2));
                        if (k.this.dNH != null) {
                            k.this.dNH.setVisibility(0);
                        }
                    } else if (k.this.dNH != null) {
                        if (k.this.aCB() != UtilHelper.getStatusBarHeight()) {
                            k.this.mn(0);
                        }
                        k.this.dNH.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.cHQ) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.aDi();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.dNQ = i;
                }
            }
        }
    };
    private Runnable dNW = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dNi != null) {
                k.this.dNj.setVisibility(0);
                k.this.dNl.setVisibility(0);
                k.this.dNk.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dNY = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.QZ.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout aCy() {
        return this.dNI;
    }

    public View aCz() {
        return this.dNG;
    }

    public View aCA() {
        return this.dNH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCB() {
        if (this.dNG == null) {
            return 0;
        }
        return this.dNG.getHeight();
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
        if (this.drO == null || com.baidu.adp.lib.util.j.kV()) {
            return 0;
        }
        return this.drO.getHeight();
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
        this.dNb = null;
        this.dNr = null;
        this.dNw = 0;
        this.dNb = frsFragment;
        this.dNr = onClickListener;
        a(aVar, z);
        this.dNE = new HashSet<>();
        this.dNw = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dNR = fVar;
    }

    private boolean aCE() {
        return this.dNR != null && this.dNR.aIr();
    }

    private void vB() {
        this.dNb.registerListener(this.dNY);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        vB();
        this.dNJ = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dNb.getPageContext());
        }
        this.mPullView.setTag(this.dNb.getUniqueId());
        if (this.dNc == null) {
            this.dNc = (NoPressedRelativeLayout) this.dNb.mRootView.findViewById(e.g.frs);
        }
        if (this.dNe == null) {
            this.dNe = this.dNb.mRootView.findViewById(e.g.frs_content_container);
        }
        if (this.dNd == null) {
            this.dNd = (CoordinatorLayout) this.dNb.mRootView.findViewById(e.g.frs_nested_scroll_layout);
        }
        if (this.dNu == null) {
            this.dNu = this.dNb.mRootView.findViewById(e.g.frs_list_content);
        }
        if (this.dNN == null) {
            this.dNN = (CollapsingToolbarLayout) this.dNb.mRootView.findViewById(e.g.frs_collapse_layout);
        }
        if (this.dNM == null) {
            this.dNM = (FrsHeaderViewContainer) this.dNb.mRootView.findViewById(e.g.header_view_container);
        }
        if (this.dNI == null) {
            this.dNI = (ObservedChangeLinearLayout) this.dNb.mRootView.findViewById(e.g.navigation_bar_wrapperLayout);
            this.dNI.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dNN.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dNb.mRootView.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dNb.aCn()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dNt == null) {
            this.dNt = this.dNb.mRootView.findViewById(e.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aEz = aVar.aEz();
            if (aEz != null) {
                aEz.aP(this.dNt);
            }
        }
        if (this.dNf == null) {
            this.dNf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dNf.setOnClickListener(this.dNr);
            this.mBackImageView = (ImageView) this.dNf.findViewById(e.g.widget_navi_back_button);
        }
        if (this.dNg == null) {
            this.dNg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dNg.setOnClickListener(this.dNr);
        }
        if (this.dNh == null) {
            this.dNh = new com.baidu.tieba.c.b(this.dNb.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dNh.getView(), (View.OnClickListener) null);
            this.dNh.getView().setOnClickListener(this.dNr);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dNb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        if (this.bRZ == null) {
            this.bRZ = (BdSwipeRefreshLayout) this.dNb.mRootView.findViewById(e.g.frs_pull_refresh_layout);
            this.bRZ.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.j(this.bRZ, e.d.cp_bg_line_c);
        }
        if (this.dNm == null) {
            this.dNm = (BdTypeRecyclerView) this.dNb.mRootView.findViewById(e.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int dOb = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.dOb--;
                if (this.dOb == 0) {
                    k.this.dNm.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.dOb++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dNm.setItemAnimator(defaultItemAnimator);
        this.dNm.setLayoutManager(new LinearLayoutManager(this.dNm.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.dNm.setScrollable(this.dNb);
        this.dNm.setFadingEdgeLength(0);
        this.dNm.setOverScrollMode(2);
        this.dNc.setBottomOrderView(this.dNm);
        this.dNm.setOnTouchListener(this.dNb.bjC);
        this.dNm.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dNF != null) {
                    k.this.dNF.bm(view);
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
        if (this.bPm == null) {
            this.bPm = new PbListView(this.dNb.getPageContext().getPageActivity());
            this.bPm.getView();
        }
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.setHeight(com.baidu.adp.lib.util.l.h(this.dNb.getActivity(), e.C0210e.tbds182));
        this.bPm.Fm();
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
        this.bPm.ew(e.d.cp_cont_e);
        this.dNm.setOnSrollToBottomListener(this.dNb);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dNb.aCk();
                if (k.this.dNb != null && k.this.QZ != null) {
                    k.this.dNb.aCp();
                    k.this.QZ.setExpanded(true);
                    if (k.this.dNF != null) {
                        k.this.dNF.b(k.this.dMS, k.this.bNP, false, true);
                    }
                }
            }
        });
        boolean Eg = com.baidu.tbadk.core.util.aq.Ee().Eg();
        if (this.dNn == null) {
            this.dNn = aVar.a(this.dNb, this.dNm, Eg);
        }
        dl(false);
        if (!z) {
            if (this.drO == null) {
                this.drO = new NoNetworkView(this.dNb.getActivity());
                this.drO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dNI.addView(this.drO);
            }
            if (com.baidu.adp.lib.util.j.kK()) {
                this.drO.setVisibility(8);
            } else {
                this.drO.setVisibility(0);
            }
            this.drO.onChangeSkinType(this.dNb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aCO();
        if (this.dNz == null) {
            this.dNz = aVar.c(this.dNb, this.dNc);
        }
        if (this.dNA == null) {
            this.dNA = aVar.b(this.dNb, this.dNc);
            gE(true);
        }
        if (this.dNG == null) {
            this.dNG = this.dNb.mRootView.findViewById(e.g.statebar_view);
        }
        if (this.dNH == null) {
            this.dNH = this.dNb.mRootView.findViewById(e.g.statebar_view_holder);
        }
        if (this.dNF == null) {
            this.dNF = new com.baidu.tieba.play.m(this.dNb.getPageContext(), this.dNm);
        }
        this.dNF.setUniqueId(this.dNb.getUniqueId());
        this.dNT = (NavigationBarCoverTip) this.dNb.mRootView.findViewById(e.g.navigation_cover_tip);
        if (this.dNB == null) {
            this.dNB = new com.baidu.tieba.frs.vc.j(this.dNb, this.dNT);
        }
        if (this.QZ == null) {
            this.QZ = (AppBarLayout) this.dNb.mRootView.findViewById(e.g.frs_app_bar_layout);
            this.QZ.addOnOffsetChangedListener(this.dNV);
            this.dNO = true;
            this.dNP = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.QZ.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dNL = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.dNS = (FrsMultiDelBottomMenuView) this.dNb.mRootView.findViewById(e.g.frs_multi_delete_menu_view);
        this.dNS.setPageContext(this.dNb.getPageContext());
        this.dNo = (FloatingAnimationView) this.dNb.mRootView.findViewById(e.g.redpacket_view);
        this.dNo.setPageId(this.dNb.getUniqueId());
        this.dNp = new com.baidu.tieba.c.c(this.dNb.getTbPageContext(), this.dNo, 2);
    }

    public void gA(boolean z) {
        if (z && this.dNp != null) {
            this.dNp.asu();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dNp != null) {
            this.dNp.a(mVar);
        }
    }

    private void aCF() {
        ViewGroup.LayoutParams layoutParams;
        this.cHQ = aCE();
        if (this.dNM != null && (layoutParams = this.dNM.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cHQ) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds88) + aCC(), 0, 0);
            }
            this.dNM.requestLayout();
        }
    }

    public void aCG() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dNI != null) {
            aCF();
            if (this.cHQ) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dNG != null) {
                    this.dNG.setAlpha(1.0f);
                }
                if (this.dNH != null) {
                    this.dNH.setAlpha(1.0f);
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
        if (z && this.dNb != null && this.dNb.aBR() != null) {
            this.dNb.aBR().aIv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCH() {
        int i;
        if (this.QZ == null) {
            return this.dNP;
        }
        if (this.dNP != -1) {
            return this.dNP;
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
        this.dNP = Math.max(0, this.QZ.getTotalScrollRange() - Math.abs(i2));
        return this.dNP;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dNy != null && this.dNy.getLayoutParams() != null) {
            this.dNy.getLayoutParams().height = i;
            this.dNy.setLayoutParams(this.dNy.getLayoutParams());
        }
    }

    public void ov(String str) {
        if (this.dNB != null) {
            this.dNB.ov(str);
        }
    }

    public View aCI() {
        return this.dNy;
    }

    public com.baidu.tieba.play.m aCJ() {
        return this.dNF;
    }

    public com.baidu.tieba.frs.entelechy.b.c aCK() {
        return this.dNA;
    }

    public void gC(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.I(this.dNb.aCl().bDu());
        if (this.dNz != null) {
            this.dNz.gC(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aCL() {
        return this.dNz;
    }

    public void B(boolean z, boolean z2) {
        if (this.mIsNeedRefresh && this.dNA != null) {
            this.dNA.B(z, z2);
        }
    }

    public void gD(boolean z) {
        this.mIsNeedRefresh = z;
        if (!this.mIsNeedRefresh && this.dNA != null) {
            this.dNA.B(false, false);
        }
    }

    public void aCM() {
        if (this.mIsNeedRefresh && this.dNA != null) {
            this.dNA.B(false, false);
        }
        this.dNg.setVisibility(8);
        gC(false);
        this.dNm.setVisibility(8);
        this.dNM.setVisibility(8);
    }

    public void aCN() {
        if (this.mIsNeedRefresh && this.dNA != null) {
            this.dNA.B(true, false);
        }
        this.dNg.setVisibility(0);
        gC(this.dNb.aCs());
        this.dNm.setVisibility(0);
        this.dNM.setVisibility(0);
    }

    public void gE(boolean z) {
        if (this.dNA != null) {
            this.dNA.hh(z);
        }
    }

    private void aCO() {
        if (this.dNC == null) {
            this.dNC = (GifView) this.dNb.mRootView.findViewById(e.g.gif_real_time);
            this.dND = (TbImageView) this.dNb.mRootView.findViewById(e.g.tbimg_real_time);
            this.dND.setPageId(this.dNb.getUniqueId());
            this.dNC.setLayerType(1, null);
            this.dND.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aCP() {
        return this.dNf;
    }

    public void h(NoNetworkView.a aVar) {
        this.dJm = aVar;
        if (this.drO != null) {
            this.drO.a(this.dJm);
        }
    }

    public void dl(boolean z) {
        this.dNa = z;
        if (z) {
            if (this.dNA != null) {
                this.dNA.aFj();
                return;
            }
            return;
        }
        this.dNm.getAdapter().notifyDataSetChanged();
        if (this.dNA != null) {
            this.dNA.aFk();
        }
    }

    public void gF(boolean z) {
        if (this.dNA != null) {
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
        this.dNm.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dNn.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dNn.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dNF != null) {
            this.dNF.destroy();
        }
        if (this.dNB != null) {
            this.dNB.onDestory();
        }
        if (this.dNS != null) {
            this.dNS.setPageContext(null);
        }
        this.dNn.onDestory();
        this.dNm.setOnSrollToBottomListener(null);
        this.dNm.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dNW);
        if (this.dtt != null) {
            this.dtt.onDestroy();
        }
        this.dNE.clear();
        if (this.dNz != null) {
            this.dNz.aFl();
        }
        if (this.dNK != null) {
            this.dNK.aEp();
        }
        if (this.dNp != null) {
            this.dNp.onDestroy();
        }
        if (this.dNT != null) {
            this.dNT.onDestroy();
        }
        if (this.dNS != null) {
            this.dNS.onDestroy();
        }
    }

    public boolean aCQ() {
        if (this.QZ == null || this.dNL == null || !this.dNL.isSticky()) {
            return this.dNz != null && this.dNz.aCQ();
        }
        if (this.dNm != null) {
            this.dNm.setSelection(0);
        }
        this.dNL.expandedAppBarLayout(this.QZ);
        return true;
    }

    public boolean aCm() {
        return this.dNa;
    }

    public void anM() {
        this.dNm.setVisibility(0);
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
        if (this.dNn != null) {
            this.dNn.notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.dNn instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dNn).notifyDataChanged();
        }
    }

    private void aCS() {
        if (this.dNq == null && this.dNb.getPageContext() != null) {
            String[] strArr = {this.dNb.getPageContext().getPageActivity().getString(e.j.take_photo), this.dNb.getPageContext().getPageActivity().getString(e.j.album)};
            this.dNq = new com.baidu.tbadk.core.dialog.b(this.dNb.getPageContext().getPageActivity());
            this.dNq.eL(this.dNb.getPageContext().getPageActivity().getString(e.j.operation));
            this.dNq.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dNb.takePhoto();
                    } else if (i == 1 && k.this.dNb.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.x(k.this.dNb.getPageContext().getPageActivity());
                    }
                }
            });
            this.dNq.d(this.dNb.getPageContext());
        }
    }

    public void aCT() {
        aCS();
        if (this.dNq != null) {
            this.dNq.BV();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.I(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dNb != null && this.dNb.aBP() != null && this.dNb.aBP().aHw() == 0) {
                mVar.mw(this.dNb.aBP().aHE());
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
        this.dNn.b(arrayList, lVar);
        if (this.dNF != null && this.dMS != 0) {
            this.dNF.b(this.dMS, this.bNP, this.dNx, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dNm;
    }

    public void aCU() {
        this.dNn.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dNb.getPageContext(), 1);
        aVar.a(this.dNm);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dNb.getForumName());
        hashMap.put("forum_id", this.dNb.getForumId());
        aVar.setParams(hashMap);
        aVar.Q(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dNz != null) {
            this.dNz.aFm();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        mo(TbadkCoreApplication.getInst().getSkinType());
        aDi();
        if (this.dNz != null) {
            this.dNz.aFn();
        }
    }

    public void release() {
        if (this.drO != null && this.dJm != null) {
            this.drO.b(this.dJm);
        }
    }

    public ImageView aCV() {
        return this.dNg;
    }

    public View aCW() {
        if (this.dNh != null) {
            return this.dNh.getView();
        }
        return null;
    }

    public void p(int i, boolean z) {
        if (this.dNh != null) {
            this.dNh.h(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dNb, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dNb.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dND != null) {
            this.dND.invalidate();
        }
        if (this.dNn != null) {
            this.dNn.aEZ();
            this.dNn.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dNb.getPageContext(), this.dNc);
        mo(i);
        if (this.drO != null) {
            this.drO.onChangeSkinType(this.dNb.getPageContext(), i);
        }
        if (this.bPm != null) {
            this.bPm.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
            this.bPm.ey(i);
        }
        aDi();
        if (this.dNA != null) {
            this.dNA.onChangeSkinType(i);
        }
        if (this.dNz != null) {
            this.dNz.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dNS != null) {
            this.dNS.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.j(this.bRZ, e.d.cp_bg_line_e);
    }

    private void mo(int i) {
        if (this.dNb != null) {
            Pair<Integer, Integer> pair = this.dNb.dLE;
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
            this.mNavigationBar.onChangeSkinType(this.dNb.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.al.e(this.dNt, e.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
            int i2 = e.d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.ap.Ed().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.Ed().c(this.dNg, e.f.icon_topbar_search_n_svg, i2);
            if (this.dNh != null) {
                this.dNh.lf(i2);
                this.dNh.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dNG, i);
        UtilHelper.setStatusBarBackground(this.dNH, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dNb.getPageContext(), i);
                com.baidu.tbadk.core.util.al.e(this.dNt, e.d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dNG, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dNH, pair);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.ap.Ed().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.Ed().c(this.dNg, e.f.icon_topbar_search_n_svg, i2);
            if (this.dNh != null) {
                this.dNh.lf(i2);
                this.dNh.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dNm != null) {
            this.dNm.setSelection(0);
        }
        if (this.QZ != null) {
            this.QZ.setExpanded(true);
        }
        if (this.bRZ != null && this.bRZ.isEnabled()) {
            this.bRZ.setRefreshing(true);
        }
    }

    public void gG(boolean z) {
        if (z) {
            this.bRZ.setRefreshing(false);
        } else {
            this.bRZ.pl();
        }
    }

    public void gH(boolean z) {
        this.bRZ.setEnabled(z);
    }

    public void gI(boolean z) {
        this.dNv = z;
        if (this.dNv) {
            this.bPm.setText(this.dNb.getResources().getString(e.j.load_more));
            if (this.dNm.getChildAt(this.dNm.getChildCount() - 1) == this.bPm.getView()) {
                this.bPm.Fp();
                this.dNb.aaA();
                return;
            }
            this.bPm.Fq();
            return;
        }
        this.bPm.setText(this.dNb.getResources().getString(e.j.load_more_must_after_delete));
        this.bPm.Fq();
    }

    public boolean aCX() {
        if (this.dNv) {
            return false;
        }
        this.bPm.setText(this.dNb.getResources().getString(e.j.load_more_must_after_delete));
        this.bPm.Fq();
        return true;
    }

    public boolean aCY() {
        return this.dNi != null && this.dNl.getVisibility() == 0;
    }

    public void aCZ() {
        if (this.dNi != null) {
            this.dNj.setVisibility(0);
            this.dNl.setVisibility(8);
            this.dNk.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dNW, 5000L);
        }
    }

    public void a(bi biVar) {
        if (this.dNi == null) {
            this.dNi = (ViewStub) this.dNb.mRootView.findViewById(e.g.yule_game_egg_view_stub);
            this.dNi.setVisibility(0);
            this.dNj = (FrameLayout) this.dNb.mRootView.findViewById(e.g.game_activity_egg_layout);
            this.dNk = (TbImageView) this.dNb.mRootView.findViewById(e.g.game_activity_egg);
            this.dNl = (TbImageView) this.dNb.mRootView.findViewById(e.g.game_activity_egg_s);
            this.dNk.setPageId(this.dNb.getUniqueId());
            this.dNl.setPageId(this.dNb.getUniqueId());
            this.dNk.setDefaultBgResource(e.d.common_color_10022);
            this.dNk.setDefaultResource(0);
            this.dNl.setDefaultBgResource(e.d.common_color_10022);
            this.dNl.setDefaultResource(0);
            this.dNj.setOnClickListener(this.dNr);
        }
        this.dNj.setVisibility(0);
        String BI = biVar.BI();
        String BJ = biVar.BJ();
        this.dNk.startLoad(BI, 10, false);
        this.dNl.startLoad(BJ, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dNW, 5000L);
    }

    public void aDa() {
        if (this.dNi != null) {
            this.dNj.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aDb() {
        return this.dNn;
    }

    public RelativeLayout aDc() {
        return this.dNc;
    }

    public View aDd() {
        return this.dNu;
    }

    public void mq(int i) {
        if (this.dNe != null) {
            this.dNe.setVisibility(i);
        }
    }

    public void aDe() {
        if (com.baidu.tbadk.l.m.PD().PE()) {
            int lastVisiblePosition = this.dNm.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dNm.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dOh != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dOh.getPerfLog();
                        perfLog.gj(1000);
                        perfLog.bgA = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dOh.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dOh.startLogPerf();
                    }
                    if (oVar.dOg != null && (oVar.dOg instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dOg;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.gj(1000);
                                perfLog2.bgA = true;
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
        this.dNm.setNextPage(this.bPm);
        if (this.dNw > 0) {
            this.bPm.ez(this.dNw);
        }
        this.bPm.setOnClickListener(null);
        this.bPm.Fp();
    }

    public void abz() {
        this.mHasMore = false;
        this.dNm.setNextPage(this.bPm);
        if (this.dNw > 0) {
            this.bPm.ez(this.dNw);
        }
        this.bPm.setOnClickListener(null);
        this.bPm.Fq();
        this.bPm.setText(this.dNb.getResources().getString(e.j.list_has_no_more));
    }

    public void aDf() {
        this.mHasMore = true;
        this.dNm.setNextPage(this.bPm);
        this.bPm.setOnClickListener(this.dNr);
        if (this.dNw > 0) {
            this.bPm.ez(this.dNw);
        }
        this.bPm.Fq();
        this.bPm.setText(this.dNb.getResources().getString(e.j.list_click_load_more));
    }

    public View aDg() {
        if (this.bPm == null) {
            return null;
        }
        return this.bPm.getView();
    }

    public void mr(int i) {
        if (this.dNS != null) {
            this.dNS.setVisibility(i);
        }
    }

    public void ms(int i) {
        if (this.dNS != null) {
            this.dNS.setSelectNumber(i);
        }
    }

    public void abA() {
        this.mHasMore = false;
        this.dNm.setNextPage(null);
    }

    public boolean arM() {
        return this.bPm.getView().getParent() != null && this.mHasMore;
    }

    public void mt(int i) {
        this.dNw = i;
    }

    public void mu(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dtt == null) {
                    this.dtt = new CommonTipView(this.dNb.getActivity());
                }
                this.dtt.setText(e.j.frs_login_tip);
                this.dtt.show((FrameLayout) aDd(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void gJ(boolean z) {
        if (this.dNF != null) {
            if (z) {
                this.dNF.jC(false);
                this.dNF.baq();
                return;
            }
            this.dNF.jC(true);
            this.dNF.b(this.dMS, this.bNP, this.dNx, true);
        }
    }

    public void aL(int i, int i2) {
        if (this.dNF != null) {
            this.dNF.a(i, i2, this.dNx, 1);
        }
    }

    public void aM(int i, int i2) {
        this.dMS = i;
        this.bNP = i2;
    }

    public void gK(boolean z) {
        this.dNx = z;
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
            if (this.dNG != null) {
                this.dNG.setAlpha(alpha);
            }
            if (this.dNH != null) {
                this.dNH.setAlpha(alpha);
            }
            if (this.dNt != null) {
                this.dNt.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDi() {
        if (this.dNb.dLE == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cHQ) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.al.a(this.dNg, e.f.icon_sml_search_bg, e.f.icon_sml_search_bg);
                if (this.dNh != null) {
                    com.baidu.tbadk.core.util.al.a(this.dNh.asr(), e.f.icon_topbar_white_remind, e.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.icon_return_bg_s, e.f.icon_return_bg);
                com.baidu.tbadk.core.util.al.a(this.dNg, e.f.icon_search_bg_s, e.f.icon_search_bg);
                if (this.dNh != null) {
                    com.baidu.tbadk.core.util.al.a(this.dNh.asr(), e.f.icon_topbar_remind, e.f.icon_topbar_remind);
                }
            }
            aDh();
        }
    }

    public void gL(boolean z) {
    }

    public void mv(int i) {
        if (this.dNm != null && this.dNm.getChildCount() >= 0) {
            if (this.dNm.getFirstVisiblePosition() > 8) {
                this.dNm.scrollToPosition(8);
            }
            this.dNm.smoothScrollToPosition(i);
        }
    }

    public void aDj() {
        a(this.dNJ, this.dNb.aCn());
        if (this.dNn != null) {
            this.dNn.aFd();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dNK == null) {
                this.dNK = new com.baidu.tieba.video.f(this.dNb.getActivity(), this.dNc);
            }
            this.dNK.h(postWriteCallBackData);
        }
    }

    public void aDk() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dNX && this.dNb.getActivity() != null && this.dNb.getPageContext() != null) {
            View view = null;
            if (this.dNm != null && (headerViewsCount = this.dNm.getHeaderViewsCount()) < this.dNm.getChildCount()) {
                view = this.dNm.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aw(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(e.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.tips)).setText(e.j.frs_video_activity_guide_tip);
                        k.this.dNb.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.h(k.this.dNb.getActivity(), e.C0210e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.dNb.getActivity(), e.C0210e.ds6);
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
                iT.n(this.dNb.getActivity());
                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iT != null) {
                            iT.dismiss();
                        }
                    }
                }, 4000L);
                this.dNX = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.dNS != null) {
            this.dNS.setDeleteCallback(aVar);
        }
    }

    public void aDl() {
        if (this.dNS != null) {
            this.dNS.aDl();
        }
    }

    public void UX() {
        if (this.dNS != null) {
            this.dNS.UX();
        }
    }

    public void ad(String str, int i) {
        if (this.dNU == null) {
            this.dNU = new TextView(this.dNb.getActivity());
            this.dNU.setGravity(19);
            this.dNU.setPadding(com.baidu.adp.lib.util.l.h(this.dNb.getActivity(), e.C0210e.ds34), 0, com.baidu.adp.lib.util.l.h(this.dNb.getActivity(), e.C0210e.ds34), 0);
            this.dNU.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.dNb.getActivity(), e.C0210e.tbds112)));
            this.dNU.setTextSize(0, com.baidu.adp.lib.util.l.h(this.dNb.getActivity(), e.C0210e.fontsize30));
            this.dNU.setMaxLines(2);
            this.dNU.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.dNU.setTextColor(ContextCompat.getColor(this.dNb.getActivity(), e.d.cp_cont_i));
        }
        this.dNT.setBackgroundColor(i);
        this.dNU.setText(str);
        this.dNT.a(this.dNb.getActivity(), this.dNU, UIMsg.m_AppUI.MSG_APP_GPS);
    }
}
