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
    private PbListView bOB;
    private BdSwipeRefreshLayout bRo;
    private com.baidu.tieba.frs.entelechy.a.q dME;
    private FloatingAnimationView dMF;
    private com.baidu.tieba.c.c dMG;
    private View.OnClickListener dMI;
    private View dMK;
    private View dML;
    private int dMN;
    private View dMP;
    private com.baidu.tieba.frs.entelechy.b.d dMQ;
    private com.baidu.tieba.frs.entelechy.b.c dMR;
    private com.baidu.tieba.frs.vc.j dMS;
    private GifView dMT;
    private TbImageView dMU;
    private HashSet<String> dMV;
    private com.baidu.tieba.play.m dMW;
    private ObservedChangeLinearLayout dMZ;
    private FrsFragment dMs;
    private View dMw;
    private ImageView dMx;
    private com.baidu.tieba.c.b dMy;
    private ViewStub dMz;
    private com.baidu.tieba.frs.entelechy.b.a dNa;
    private com.baidu.tieba.video.f dNb;
    private AppBarLayoutStickyBehavior dNc;
    private FrsHeaderViewContainer dNd;
    private CollapsingToolbarLayout dNe;
    private com.baidu.tieba.frs.vc.f dNi;
    private FrsMultiDelBottomMenuView dNj;
    private NavigationBarCoverTip dNk;
    private TextView dNl;
    private boolean dNo;
    private NoNetworkView drf;
    private CommonTipView dsK;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dMr = false;
    private NoPressedRelativeLayout dMt = null;
    private CoordinatorLayout dMu = null;
    private View dMv = null;
    private FrameLayout dMA = null;
    private TbImageView dMB = null;
    private TbImageView dMC = null;
    private BdTypeRecyclerView dMD = null;
    private com.baidu.tbadk.core.dialog.b dMH = null;
    private NoNetworkView.a dID = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener dMJ = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dMD != null && k.this.dMD.getAdapter() != null) {
                k.this.dMD.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dMM = true;
    private boolean mHasMore = true;
    private boolean dMO = false;
    private int dMj = 0;
    private int bNd = 0;
    private View dMX = null;
    private View dMY = null;
    private boolean cHf = false;
    private boolean mIsNeedRefresh = true;
    private boolean dNf = true;
    private int dNg = -1;
    private int dNh = -1;
    private AppBarLayout.OnOffsetChangedListener dNm = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dNh != i && Math.abs(i) >= 0 && k.this.aCk() != -1) {
                if (Math.abs(i) >= k.this.aCk()) {
                    if (k.this.dNf) {
                        k.this.dNf = false;
                        k.this.gy(k.this.dNf);
                    }
                } else if (!k.this.dNf) {
                    k.this.dNf = true;
                    k.this.gy(k.this.dNf);
                }
                int aCg = k.this.aCg() + k.this.aCf() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - aCg;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dNh - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.mm(Math.abs(aCg - totalScrollRange2));
                        if (k.this.dMY != null) {
                            k.this.dMY.setVisibility(0);
                        }
                    } else if (k.this.dMY != null) {
                        if (k.this.aCe() != UtilHelper.getStatusBarHeight()) {
                            k.this.mm(0);
                        }
                        k.this.dMY.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.cHf) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.aCL();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.dNh = i;
                }
            }
        }
    };
    private Runnable dNn = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dMz != null) {
                k.this.dMA.setVisibility(0);
                k.this.dMC.setVisibility(0);
                k.this.dMB.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dNp = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.QP.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout aCb() {
        return this.dMZ;
    }

    public View aCc() {
        return this.dMX;
    }

    public View aCd() {
        return this.dMY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCe() {
        if (this.dMX == null) {
            return 0;
        }
        return this.dMX.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCf() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCg() {
        if (this.drf == null || com.baidu.adp.lib.util.j.kV()) {
            return 0;
        }
        return this.drf.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm(int i) {
        View aCc = aCc();
        View aCd = aCd();
        if (UtilHelper.canUseStyleImmersiveSticky() && aCc != null && aCd != null && aCc.getLayoutParams() != null && aCd.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = aCc.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            aCc.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = aCd.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            aCd.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dMs = null;
        this.dMI = null;
        this.dMN = 0;
        this.dMs = frsFragment;
        this.dMI = onClickListener;
        a(aVar, z);
        this.dMV = new HashSet<>();
        this.dMN = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dNi = fVar;
    }

    private boolean aCh() {
        return this.dNi != null && this.dNi.aHU();
    }

    private void vx() {
        this.dMs.registerListener(this.dNp);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        vx();
        this.dNa = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dMs.getPageContext());
        }
        this.mPullView.setTag(this.dMs.getUniqueId());
        if (this.dMt == null) {
            this.dMt = (NoPressedRelativeLayout) this.dMs.mRootView.findViewById(e.g.frs);
        }
        if (this.dMv == null) {
            this.dMv = this.dMs.mRootView.findViewById(e.g.frs_content_container);
        }
        if (this.dMu == null) {
            this.dMu = (CoordinatorLayout) this.dMs.mRootView.findViewById(e.g.frs_nested_scroll_layout);
        }
        if (this.dML == null) {
            this.dML = this.dMs.mRootView.findViewById(e.g.frs_list_content);
        }
        if (this.dNe == null) {
            this.dNe = (CollapsingToolbarLayout) this.dMs.mRootView.findViewById(e.g.frs_collapse_layout);
        }
        if (this.dNd == null) {
            this.dNd = (FrsHeaderViewContainer) this.dMs.mRootView.findViewById(e.g.header_view_container);
        }
        if (this.dMZ == null) {
            this.dMZ = (ObservedChangeLinearLayout) this.dMs.mRootView.findViewById(e.g.navigation_bar_wrapperLayout);
            this.dMZ.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dNe.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dMs.mRootView.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dMs.aBQ()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dMK == null) {
            this.dMK = this.dMs.mRootView.findViewById(e.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aEc = aVar.aEc();
            if (aEc != null) {
                aEc.aP(this.dMK);
            }
        }
        if (this.dMw == null) {
            this.dMw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dMw.setOnClickListener(this.dMI);
            this.mBackImageView = (ImageView) this.dMw.findViewById(e.g.widget_navi_back_button);
        }
        if (this.dMx == null) {
            this.dMx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dMx.setOnClickListener(this.dMI);
        }
        if (this.dMy == null) {
            this.dMy = new com.baidu.tieba.c.b(this.dMs.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dMy.getView(), (View.OnClickListener) null);
            this.dMy.getView().setOnClickListener(this.dMI);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dMs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        if (this.bRo == null) {
            this.bRo = (BdSwipeRefreshLayout) this.dMs.mRootView.findViewById(e.g.frs_pull_refresh_layout);
            this.bRo.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.j(this.bRo, e.d.cp_bg_line_c);
        }
        if (this.dMD == null) {
            this.dMD = (BdTypeRecyclerView) this.dMs.mRootView.findViewById(e.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int dNs = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.dNs--;
                if (this.dNs == 0) {
                    k.this.dMD.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.dNs++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dMD.setItemAnimator(defaultItemAnimator);
        this.dMD.setLayoutManager(new LinearLayoutManager(this.dMD.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.dMD.setScrollable(this.dMs);
        this.dMD.setFadingEdgeLength(0);
        this.dMD.setOverScrollMode(2);
        this.dMt.setBottomOrderView(this.dMD);
        this.dMD.setOnTouchListener(this.dMs.biP);
        this.dMD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dMW != null) {
                    k.this.dMW.bm(view);
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
        if (this.bOB == null) {
            this.bOB = new PbListView(this.dMs.getPageContext().getPageActivity());
            this.bOB.getView();
        }
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.setHeight(com.baidu.adp.lib.util.l.h(this.dMs.getActivity(), e.C0210e.tbds182));
        this.bOB.EZ();
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
        this.bOB.ew(e.d.cp_cont_e);
        this.dMD.setOnSrollToBottomListener(this.dMs);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dMs.aBN();
                if (k.this.dMs != null && k.this.QP != null) {
                    k.this.dMs.aBS();
                    k.this.QP.setExpanded(true);
                    if (k.this.dMW != null) {
                        k.this.dMW.b(k.this.dMj, k.this.bNd, false, true);
                    }
                }
            }
        });
        boolean DT = com.baidu.tbadk.core.util.aq.DR().DT();
        if (this.dME == null) {
            this.dME = aVar.a(this.dMs, this.dMD, DT);
        }
        di(false);
        if (!z) {
            if (this.drf == null) {
                this.drf = new NoNetworkView(this.dMs.getActivity());
                this.drf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dMZ.addView(this.drf);
            }
            if (com.baidu.adp.lib.util.j.kK()) {
                this.drf.setVisibility(8);
            } else {
                this.drf.setVisibility(0);
            }
            this.drf.onChangeSkinType(this.dMs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aCr();
        if (this.dMQ == null) {
            this.dMQ = aVar.c(this.dMs, this.dMt);
        }
        if (this.dMR == null) {
            this.dMR = aVar.b(this.dMs, this.dMt);
            gB(true);
        }
        if (this.dMX == null) {
            this.dMX = this.dMs.mRootView.findViewById(e.g.statebar_view);
        }
        if (this.dMY == null) {
            this.dMY = this.dMs.mRootView.findViewById(e.g.statebar_view_holder);
        }
        if (this.dMW == null) {
            this.dMW = new com.baidu.tieba.play.m(this.dMs.getPageContext(), this.dMD);
        }
        this.dMW.setUniqueId(this.dMs.getUniqueId());
        this.dNk = (NavigationBarCoverTip) this.dMs.mRootView.findViewById(e.g.navigation_cover_tip);
        if (this.dMS == null) {
            this.dMS = new com.baidu.tieba.frs.vc.j(this.dMs, this.dNk);
        }
        if (this.QP == null) {
            this.QP = (AppBarLayout) this.dMs.mRootView.findViewById(e.g.frs_app_bar_layout);
            this.QP.addOnOffsetChangedListener(this.dNm);
            this.dNf = true;
            this.dNg = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.QP.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dNc = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.dNj = (FrsMultiDelBottomMenuView) this.dMs.mRootView.findViewById(e.g.frs_multi_delete_menu_view);
        this.dNj.setPageContext(this.dMs.getPageContext());
        this.dMF = (FloatingAnimationView) this.dMs.mRootView.findViewById(e.g.redpacket_view);
        this.dMF.setPageId(this.dMs.getUniqueId());
        this.dMG = new com.baidu.tieba.c.c(this.dMs.getTbPageContext(), this.dMF, 2);
    }

    public void gx(boolean z) {
        if (z && this.dMG != null) {
            this.dMG.arW();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dMG != null) {
            this.dMG.a(mVar);
        }
    }

    private void aCi() {
        ViewGroup.LayoutParams layoutParams;
        this.cHf = aCh();
        if (this.dNd != null && (layoutParams = this.dNd.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cHf) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds88) + aCf(), 0, 0);
            }
            this.dNd.requestLayout();
        }
    }

    public void aCj() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dMZ != null) {
            aCi();
            if (this.cHf) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dMX != null) {
                    this.dMX.setAlpha(1.0f);
                }
                if (this.dMY != null) {
                    this.dMY.setAlpha(1.0f);
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
    public void gy(boolean z) {
        if (z && this.dMs != null && this.dMs.aBu() != null) {
            this.dMs.aBu().aHY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aCk() {
        int i;
        if (this.QP == null) {
            return this.dNg;
        }
        if (this.dNg != -1) {
            return this.dNg;
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
        this.dNg = Math.max(0, this.QP.getTotalScrollRange() - Math.abs(i2));
        return this.dNg;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dMP != null && this.dMP.getLayoutParams() != null) {
            this.dMP.getLayoutParams().height = i;
            this.dMP.setLayoutParams(this.dMP.getLayoutParams());
        }
    }

    public void od(String str) {
        if (this.dMS != null) {
            this.dMS.od(str);
        }
    }

    public View aCl() {
        return this.dMP;
    }

    public com.baidu.tieba.play.m aCm() {
        return this.dMW;
    }

    public com.baidu.tieba.frs.entelechy.b.c aCn() {
        return this.dMR;
    }

    public void gz(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.I(this.dMs.aBO().bCL());
        if (this.dMQ != null) {
            this.dMQ.gz(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aCo() {
        return this.dMQ;
    }

    public void B(boolean z, boolean z2) {
        if (this.mIsNeedRefresh && this.dMR != null) {
            this.dMR.B(z, z2);
        }
    }

    public void gA(boolean z) {
        this.mIsNeedRefresh = z;
        if (!this.mIsNeedRefresh && this.dMR != null) {
            this.dMR.B(false, false);
        }
    }

    public void aCp() {
        if (this.mIsNeedRefresh && this.dMR != null) {
            this.dMR.B(false, false);
        }
        this.dMx.setVisibility(8);
        gz(false);
        this.dMD.setVisibility(8);
        this.dNd.setVisibility(8);
    }

    public void aCq() {
        if (this.mIsNeedRefresh && this.dMR != null) {
            this.dMR.B(true, false);
        }
        this.dMx.setVisibility(0);
        gz(this.dMs.aBV());
        this.dMD.setVisibility(0);
        this.dNd.setVisibility(0);
    }

    public void gB(boolean z) {
        if (this.dMR != null) {
            this.dMR.he(z);
        }
    }

    private void aCr() {
        if (this.dMT == null) {
            this.dMT = (GifView) this.dMs.mRootView.findViewById(e.g.gif_real_time);
            this.dMU = (TbImageView) this.dMs.mRootView.findViewById(e.g.tbimg_real_time);
            this.dMU.setPageId(this.dMs.getUniqueId());
            this.dMT.setLayerType(1, null);
            this.dMU.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aCs() {
        return this.dMw;
    }

    public void h(NoNetworkView.a aVar) {
        this.dID = aVar;
        if (this.drf != null) {
            this.drf.a(this.dID);
        }
    }

    public void di(boolean z) {
        this.dMr = z;
        if (z) {
            if (this.dMR != null) {
                this.dMR.aEM();
                return;
            }
            return;
        }
        this.dMD.getAdapter().notifyDataSetChanged();
        if (this.dMR != null) {
            this.dMR.aEN();
        }
    }

    public void gC(boolean z) {
        if (this.dMR != null) {
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
        this.dMD.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dME.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dME.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dMW != null) {
            this.dMW.destroy();
        }
        if (this.dMS != null) {
            this.dMS.onDestory();
        }
        if (this.dNj != null) {
            this.dNj.setPageContext(null);
        }
        this.dME.onDestory();
        this.dMD.setOnSrollToBottomListener(null);
        this.dMD.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dNn);
        if (this.dsK != null) {
            this.dsK.onDestroy();
        }
        this.dMV.clear();
        if (this.dMQ != null) {
            this.dMQ.aEO();
        }
        if (this.dNb != null) {
            this.dNb.aDS();
        }
        if (this.dMG != null) {
            this.dMG.onDestroy();
        }
        if (this.dNk != null) {
            this.dNk.onDestroy();
        }
        if (this.dNj != null) {
            this.dNj.onDestroy();
        }
    }

    public boolean aCt() {
        if (this.QP == null || this.dNc == null || !this.dNc.isSticky()) {
            return this.dMQ != null && this.dMQ.aCt();
        }
        if (this.dMD != null) {
            this.dMD.setSelection(0);
        }
        this.dNc.expandedAppBarLayout(this.QP);
        return true;
    }

    public boolean aBP() {
        return this.dMr;
    }

    public void anp() {
        this.dMD.setVisibility(0);
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
            com.baidu.tbadk.core.i.xE().ea(str);
        }
    }

    public void aCu() {
        if (this.dME != null) {
            this.dME.notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.dME instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dME).notifyDataChanged();
        }
    }

    private void aCv() {
        if (this.dMH == null && this.dMs.getPageContext() != null) {
            String[] strArr = {this.dMs.getPageContext().getPageActivity().getString(e.j.take_photo), this.dMs.getPageContext().getPageActivity().getString(e.j.album)};
            this.dMH = new com.baidu.tbadk.core.dialog.b(this.dMs.getPageContext().getPageActivity());
            this.dMH.eC(this.dMs.getPageContext().getPageActivity().getString(e.j.operation));
            this.dMH.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dMs.takePhoto();
                    } else if (i == 1 && k.this.dMs.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.w(k.this.dMs.getPageContext().getPageActivity());
                    }
                }
            });
            this.dMH.d(this.dMs.getPageContext());
        }
    }

    public void aCw() {
        aCv();
        if (this.dMH != null) {
            this.dMH.BI();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.I(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dMs != null && this.dMs.aBs() != null && this.dMs.aBs().aGZ() == 0) {
                mVar.mv(this.dMs.aBs().aHh());
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
        this.dME.b(arrayList, lVar);
        if (this.dMW != null && this.dMj != 0) {
            this.dMW.b(this.dMj, this.bNd, this.dMO, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dMD;
    }

    public void aCx() {
        this.dME.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dMs.getPageContext(), 1);
        aVar.a(this.dMD);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dMs.getForumName());
        hashMap.put("forum_id", this.dMs.getForumId());
        aVar.setParams(hashMap);
        aVar.Q(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dMQ != null) {
            this.dMQ.aEP();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        mn(TbadkCoreApplication.getInst().getSkinType());
        aCL();
        if (this.dMQ != null) {
            this.dMQ.aEQ();
        }
    }

    public void release() {
        if (this.drf != null && this.dID != null) {
            this.drf.b(this.dID);
        }
    }

    public ImageView aCy() {
        return this.dMx;
    }

    public View aCz() {
        if (this.dMy != null) {
            return this.dMy.getView();
        }
        return null;
    }

    public void p(int i, boolean z) {
        if (this.dMy != null) {
            this.dMy.h(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dMs, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dMs.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dMU != null) {
            this.dMU.invalidate();
        }
        if (this.dME != null) {
            this.dME.aEC();
            this.dME.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dMs.getPageContext(), this.dMt);
        mn(i);
        if (this.drf != null) {
            this.drf.onChangeSkinType(this.dMs.getPageContext(), i);
        }
        if (this.bOB != null) {
            this.bOB.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
            this.bOB.ey(i);
        }
        aCL();
        if (this.dMR != null) {
            this.dMR.onChangeSkinType(i);
        }
        if (this.dMQ != null) {
            this.dMQ.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dNj != null) {
            this.dNj.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.j(this.bRo, e.d.cp_bg_line_e);
    }

    private void mn(int i) {
        if (this.dMs != null) {
            Pair<Integer, Integer> pair = this.dMs.dKV;
            if (pair != null) {
                a(i, pair);
            } else {
                mo(i);
            }
        }
    }

    private void mo(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.al.dP(e.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dMs.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.al.e(this.dMK, e.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
            int i2 = e.d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.ap.DQ().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.DQ().c(this.dMx, e.f.icon_topbar_search_n_svg, i2);
            if (this.dMy != null) {
                this.dMy.le(i2);
                this.dMy.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dMX, i);
        UtilHelper.setStatusBarBackground(this.dMY, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dMs.getPageContext(), i);
                com.baidu.tbadk.core.util.al.e(this.dMK, e.d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dMX, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dMY, pair);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.ap.DQ().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.DQ().c(this.dMx, e.f.icon_topbar_search_n_svg, i2);
            if (this.dMy != null) {
                this.dMy.le(i2);
                this.dMy.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dMD != null) {
            this.dMD.setSelection(0);
        }
        if (this.QP != null) {
            this.QP.setExpanded(true);
        }
        if (this.bRo != null && this.bRo.isEnabled()) {
            this.bRo.setRefreshing(true);
        }
    }

    public void gD(boolean z) {
        if (z) {
            this.bRo.setRefreshing(false);
        } else {
            this.bRo.ph();
        }
    }

    public void gE(boolean z) {
        this.bRo.setEnabled(z);
    }

    public void gF(boolean z) {
        this.dMM = z;
        if (this.dMM) {
            this.bOB.setText(this.dMs.getResources().getString(e.j.load_more));
            if (this.dMD.getChildAt(this.dMD.getChildCount() - 1) == this.bOB.getView()) {
                this.bOB.Fc();
                this.dMs.aad();
                return;
            }
            this.bOB.Fd();
            return;
        }
        this.bOB.setText(this.dMs.getResources().getString(e.j.load_more_must_after_delete));
        this.bOB.Fd();
    }

    public boolean aCA() {
        if (this.dMM) {
            return false;
        }
        this.bOB.setText(this.dMs.getResources().getString(e.j.load_more_must_after_delete));
        this.bOB.Fd();
        return true;
    }

    public boolean aCB() {
        return this.dMz != null && this.dMC.getVisibility() == 0;
    }

    public void aCC() {
        if (this.dMz != null) {
            this.dMA.setVisibility(0);
            this.dMC.setVisibility(8);
            this.dMB.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dNn, 5000L);
        }
    }

    public void a(bi biVar) {
        if (this.dMz == null) {
            this.dMz = (ViewStub) this.dMs.mRootView.findViewById(e.g.yule_game_egg_view_stub);
            this.dMz.setVisibility(0);
            this.dMA = (FrameLayout) this.dMs.mRootView.findViewById(e.g.game_activity_egg_layout);
            this.dMB = (TbImageView) this.dMs.mRootView.findViewById(e.g.game_activity_egg);
            this.dMC = (TbImageView) this.dMs.mRootView.findViewById(e.g.game_activity_egg_s);
            this.dMB.setPageId(this.dMs.getUniqueId());
            this.dMC.setPageId(this.dMs.getUniqueId());
            this.dMB.setDefaultBgResource(e.d.common_color_10022);
            this.dMB.setDefaultResource(0);
            this.dMC.setDefaultBgResource(e.d.common_color_10022);
            this.dMC.setDefaultResource(0);
            this.dMA.setOnClickListener(this.dMI);
        }
        this.dMA.setVisibility(0);
        String Bv = biVar.Bv();
        String Bw = biVar.Bw();
        this.dMB.startLoad(Bv, 10, false);
        this.dMC.startLoad(Bw, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dNn, 5000L);
    }

    public void aCD() {
        if (this.dMz != null) {
            this.dMA.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aCE() {
        return this.dME;
    }

    public RelativeLayout aCF() {
        return this.dMt;
    }

    public View aCG() {
        return this.dML;
    }

    public void mp(int i) {
        if (this.dMv != null) {
            this.dMv.setVisibility(i);
        }
    }

    public void aCH() {
        if (com.baidu.tbadk.l.m.Pl().Pm()) {
            int lastVisiblePosition = this.dMD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dMD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dNy != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dNy.getPerfLog();
                        perfLog.gj(1000);
                        perfLog.bfP = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dNy.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dNy.startLogPerf();
                    }
                    if (oVar.dNx != null && (oVar.dNx instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dNx;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.gj(1000);
                                perfLog2.bfP = true;
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

    public NavigationBar abW() {
        return this.mNavigationBar;
    }

    public void abb() {
        this.mHasMore = true;
        this.dMD.setNextPage(this.bOB);
        if (this.dMN > 0) {
            this.bOB.ez(this.dMN);
        }
        this.bOB.setOnClickListener(null);
        this.bOB.Fc();
    }

    public void abc() {
        this.mHasMore = false;
        this.dMD.setNextPage(this.bOB);
        if (this.dMN > 0) {
            this.bOB.ez(this.dMN);
        }
        this.bOB.setOnClickListener(null);
        this.bOB.Fd();
        this.bOB.setText(this.dMs.getResources().getString(e.j.list_has_no_more));
    }

    public void aCI() {
        this.mHasMore = true;
        this.dMD.setNextPage(this.bOB);
        this.bOB.setOnClickListener(this.dMI);
        if (this.dMN > 0) {
            this.bOB.ez(this.dMN);
        }
        this.bOB.Fd();
        this.bOB.setText(this.dMs.getResources().getString(e.j.list_click_load_more));
    }

    public View aCJ() {
        if (this.bOB == null) {
            return null;
        }
        return this.bOB.getView();
    }

    public void mq(int i) {
        if (this.dNj != null) {
            this.dNj.setVisibility(i);
        }
    }

    public void mr(int i) {
        if (this.dNj != null) {
            this.dNj.setSelectNumber(i);
        }
    }

    public void abd() {
        this.mHasMore = false;
        this.dMD.setNextPage(null);
    }

    public boolean aro() {
        return this.bOB.getView().getParent() != null && this.mHasMore;
    }

    public void ms(int i) {
        this.dMN = i;
    }

    public void mt(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dsK == null) {
                    this.dsK = new CommonTipView(this.dMs.getActivity());
                }
                this.dsK.setText(e.j.frs_login_tip);
                this.dsK.show((FrameLayout) aCG(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void gG(boolean z) {
        if (this.dMW != null) {
            if (z) {
                this.dMW.jC(false);
                this.dMW.aZQ();
                return;
            }
            this.dMW.jC(true);
            this.dMW.b(this.dMj, this.bNd, this.dMO, true);
        }
    }

    public void aL(int i, int i2) {
        if (this.dMW != null) {
            this.dMW.a(i, i2, this.dMO, 1);
        }
    }

    public void aM(int i, int i2) {
        this.dMj = i;
        this.bNd = i2;
    }

    public void gH(boolean z) {
        this.dMO = z;
    }

    private void aCK() {
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
            if (this.dMX != null) {
                this.dMX.setAlpha(alpha);
            }
            if (this.dMY != null) {
                this.dMY.setAlpha(alpha);
            }
            if (this.dMK != null) {
                this.dMK.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCL() {
        if (this.dMs.dKV == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cHf) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.al.a(this.dMx, e.f.icon_sml_search_bg, e.f.icon_sml_search_bg);
                if (this.dMy != null) {
                    com.baidu.tbadk.core.util.al.a(this.dMy.arT(), e.f.icon_topbar_white_remind, e.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.icon_return_bg_s, e.f.icon_return_bg);
                com.baidu.tbadk.core.util.al.a(this.dMx, e.f.icon_search_bg_s, e.f.icon_search_bg);
                if (this.dMy != null) {
                    com.baidu.tbadk.core.util.al.a(this.dMy.arT(), e.f.icon_topbar_remind, e.f.icon_topbar_remind);
                }
            }
            aCK();
        }
    }

    public void gI(boolean z) {
    }

    public void mu(int i) {
        if (this.dMD != null && this.dMD.getChildCount() >= 0) {
            if (this.dMD.getFirstVisiblePosition() > 8) {
                this.dMD.scrollToPosition(8);
            }
            this.dMD.smoothScrollToPosition(i);
        }
    }

    public void aCM() {
        a(this.dNa, this.dMs.aBQ());
        if (this.dME != null) {
            this.dME.aEG();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dNb == null) {
                this.dNb = new com.baidu.tieba.video.f(this.dMs.getActivity(), this.dMt);
            }
            this.dNb.h(postWriteCallBackData);
        }
    }

    public void aCN() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dNo && this.dMs.getActivity() != null && this.dMs.getPageContext() != null) {
            View view = null;
            if (this.dMD != null && (headerViewsCount = this.dMD.getHeaderViewsCount()) < this.dMD.getChildCount()) {
                view = this.dMD.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aw(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(e.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.tips)).setText(e.j.frs_video_activity_guide_tip);
                        k.this.dMs.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.h(k.this.dMs.getActivity(), e.C0210e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.dMs.getActivity(), e.C0210e.ds6);
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
                iT.n(this.dMs.getActivity());
                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iT != null) {
                            iT.dismiss();
                        }
                    }
                }, 4000L);
                this.dNo = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.dNj != null) {
            this.dNj.setDeleteCallback(aVar);
        }
    }

    public void aCO() {
        if (this.dNj != null) {
            this.dNj.aCO();
        }
    }

    public void UB() {
        if (this.dNj != null) {
            this.dNj.UB();
        }
    }

    public void ad(String str, int i) {
        if (this.dNl == null) {
            this.dNl = new TextView(this.dMs.getActivity());
            this.dNl.setGravity(19);
            this.dNl.setPadding(com.baidu.adp.lib.util.l.h(this.dMs.getActivity(), e.C0210e.ds34), 0, com.baidu.adp.lib.util.l.h(this.dMs.getActivity(), e.C0210e.ds34), 0);
            this.dNl.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.dMs.getActivity(), e.C0210e.tbds112)));
            this.dNl.setTextSize(0, com.baidu.adp.lib.util.l.h(this.dMs.getActivity(), e.C0210e.fontsize30));
            this.dNl.setMaxLines(2);
            this.dNl.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.dNl.setTextColor(ContextCompat.getColor(this.dMs.getActivity(), e.d.cp_cont_i));
        }
        this.dNk.setBackgroundColor(i);
        this.dNl.setText(str);
        this.dNk.a(this.dMs.getActivity(), this.dNl, UIMsg.m_AppUI.MSG_APP_GPS);
    }
}
