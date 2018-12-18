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
    private PbListView bOy;
    private BdSwipeRefreshLayout bRl;
    private FrsFragment dJE;
    private View dJI;
    private ImageView dJJ;
    private com.baidu.tieba.c.b dJK;
    private ViewStub dJL;
    private com.baidu.tieba.frs.entelechy.a.q dJQ;
    private FloatingAnimationView dJR;
    private com.baidu.tieba.c.c dJS;
    private View.OnClickListener dJU;
    private View dJW;
    private View dJX;
    private int dJZ;
    private boolean dKA;
    private View dKb;
    private com.baidu.tieba.frs.entelechy.b.d dKc;
    private com.baidu.tieba.frs.entelechy.b.c dKd;
    private com.baidu.tieba.frs.vc.j dKe;
    private GifView dKf;
    private TbImageView dKg;
    private HashSet<String> dKh;
    private com.baidu.tieba.play.m dKi;
    private ObservedChangeLinearLayout dKl;
    private com.baidu.tieba.frs.entelechy.b.a dKm;
    private com.baidu.tieba.video.f dKn;
    private AppBarLayoutStickyBehavior dKo;
    private FrsHeaderViewContainer dKp;
    private CollapsingToolbarLayout dKq;
    private com.baidu.tieba.frs.vc.f dKu;
    private FrsMultiDelBottomMenuView dKv;
    private NavigationBarCoverTip dKw;
    private TextView dKx;
    private NoNetworkView dop;
    private CommonTipView dpU;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dJD = false;
    private NoPressedRelativeLayout dJF = null;
    private CoordinatorLayout dJG = null;
    private View dJH = null;
    private FrameLayout dJM = null;
    private TbImageView dJN = null;
    private TbImageView dJO = null;
    private BdTypeRecyclerView dJP = null;
    private com.baidu.tbadk.core.dialog.b dJT = null;
    private NoNetworkView.a dFP = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener dJV = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dJP != null && k.this.dJP.getAdapter() != null) {
                k.this.dJP.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dJY = true;
    private boolean mHasMore = true;
    private boolean dKa = false;
    private int dJv = 0;
    private int bNa = 0;
    private View dKj = null;
    private View dKk = null;
    private boolean cGf = false;
    private boolean mIsNeedRefresh = true;
    private boolean dKr = true;
    private int dKs = -1;
    private int dKt = -1;
    private AppBarLayout.OnOffsetChangedListener dKy = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dKt != i && Math.abs(i) >= 0 && k.this.aBv() != -1) {
                if (Math.abs(i) >= k.this.aBv()) {
                    if (k.this.dKr) {
                        k.this.dKr = false;
                        k.this.gv(k.this.dKr);
                    }
                } else if (!k.this.dKr) {
                    k.this.dKr = true;
                    k.this.gv(k.this.dKr);
                }
                int aBr = k.this.aBr() + k.this.aBq() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - aBr;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dKt - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.lZ(Math.abs(aBr - totalScrollRange2));
                        if (k.this.dKk != null) {
                            k.this.dKk.setVisibility(0);
                        }
                    } else if (k.this.dKk != null) {
                        if (k.this.aBp() != UtilHelper.getStatusBarHeight()) {
                            k.this.lZ(0);
                        }
                        k.this.dKk.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.cGf) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.aBW();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.dKt = i;
                }
            }
        }
    };
    private Runnable dKz = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dJL != null) {
                k.this.dJM.setVisibility(0);
                k.this.dJO.setVisibility(0);
                k.this.dJN.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dKB = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.QP.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout aBm() {
        return this.dKl;
    }

    public View aBn() {
        return this.dKj;
    }

    public View aBo() {
        return this.dKk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBp() {
        if (this.dKj == null) {
            return 0;
        }
        return this.dKj.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBq() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBr() {
        if (this.dop == null || com.baidu.adp.lib.util.j.kV()) {
            return 0;
        }
        return this.dop.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(int i) {
        View aBn = aBn();
        View aBo = aBo();
        if (UtilHelper.canUseStyleImmersiveSticky() && aBn != null && aBo != null && aBn.getLayoutParams() != null && aBo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = aBn.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            aBn.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = aBo.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            aBo.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dJE = null;
        this.dJU = null;
        this.dJZ = 0;
        this.dJE = frsFragment;
        this.dJU = onClickListener;
        a(aVar, z);
        this.dKh = new HashSet<>();
        this.dJZ = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dKu = fVar;
    }

    private boolean aBs() {
        return this.dKu != null && this.dKu.aHf();
    }

    private void vx() {
        this.dJE.registerListener(this.dKB);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        vx();
        this.dKm = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dJE.getPageContext());
        }
        this.mPullView.setTag(this.dJE.getUniqueId());
        if (this.dJF == null) {
            this.dJF = (NoPressedRelativeLayout) this.dJE.mRootView.findViewById(e.g.frs);
        }
        if (this.dJH == null) {
            this.dJH = this.dJE.mRootView.findViewById(e.g.frs_content_container);
        }
        if (this.dJG == null) {
            this.dJG = (CoordinatorLayout) this.dJE.mRootView.findViewById(e.g.frs_nested_scroll_layout);
        }
        if (this.dJX == null) {
            this.dJX = this.dJE.mRootView.findViewById(e.g.frs_list_content);
        }
        if (this.dKq == null) {
            this.dKq = (CollapsingToolbarLayout) this.dJE.mRootView.findViewById(e.g.frs_collapse_layout);
        }
        if (this.dKp == null) {
            this.dKp = (FrsHeaderViewContainer) this.dJE.mRootView.findViewById(e.g.header_view_container);
        }
        if (this.dKl == null) {
            this.dKl = (ObservedChangeLinearLayout) this.dJE.mRootView.findViewById(e.g.navigation_bar_wrapperLayout);
            this.dKl.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dKq.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dJE.mRootView.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dJE.aBb()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dJW == null) {
            this.dJW = this.dJE.mRootView.findViewById(e.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b aDn = aVar.aDn();
            if (aDn != null) {
                aDn.aM(this.dJW);
            }
        }
        if (this.dJI == null) {
            this.dJI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dJI.setOnClickListener(this.dJU);
            this.mBackImageView = (ImageView) this.dJI.findViewById(e.g.widget_navi_back_button);
        }
        if (this.dJJ == null) {
            this.dJJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dJJ.setOnClickListener(this.dJU);
        }
        if (this.dJK == null) {
            this.dJK = new com.baidu.tieba.c.b(this.dJE.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dJK.getView(), (View.OnClickListener) null);
            this.dJK.getView().setOnClickListener(this.dJU);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dJE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        if (this.bRl == null) {
            this.bRl = (BdSwipeRefreshLayout) this.dJE.mRootView.findViewById(e.g.frs_pull_refresh_layout);
            this.bRl.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.j(this.bRl, e.d.cp_bg_line_c);
        }
        if (this.dJP == null) {
            this.dJP = (BdTypeRecyclerView) this.dJE.mRootView.findViewById(e.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int dKE = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.dKE--;
                if (this.dKE == 0) {
                    k.this.dJP.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.dKE++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dJP.setItemAnimator(defaultItemAnimator);
        this.dJP.setLayoutManager(new LinearLayoutManager(this.dJP.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.dJP.setScrollable(this.dJE);
        this.dJP.setFadingEdgeLength(0);
        this.dJP.setOverScrollMode(2);
        this.dJF.setBottomOrderView(this.dJP);
        this.dJP.setOnTouchListener(this.dJE.biM);
        this.dJP.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dKi != null) {
                    k.this.dKi.bj(view);
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
        if (this.bOy == null) {
            this.bOy = new PbListView(this.dJE.getPageContext().getPageActivity());
            this.bOy.getView();
        }
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.setHeight(com.baidu.adp.lib.util.l.h(this.dJE.getActivity(), e.C0210e.tbds182));
        this.bOy.EZ();
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
        this.bOy.ew(e.d.cp_cont_e);
        this.dJP.setOnSrollToBottomListener(this.dJE);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dJE.aAY();
                if (k.this.dJE != null && k.this.QP != null) {
                    k.this.dJE.aBd();
                    k.this.QP.setExpanded(true);
                    if (k.this.dKi != null) {
                        k.this.dKi.b(k.this.dJv, k.this.bNa, false, true);
                    }
                }
            }
        });
        boolean DT = com.baidu.tbadk.core.util.aq.DR().DT();
        if (this.dJQ == null) {
            this.dJQ = aVar.a(this.dJE, this.dJP, DT);
        }
        di(false);
        if (!z) {
            if (this.dop == null) {
                this.dop = new NoNetworkView(this.dJE.getActivity());
                this.dop.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dKl.addView(this.dop);
            }
            if (com.baidu.adp.lib.util.j.kK()) {
                this.dop.setVisibility(8);
            } else {
                this.dop.setVisibility(0);
            }
            this.dop.onChangeSkinType(this.dJE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aBC();
        if (this.dKc == null) {
            this.dKc = aVar.c(this.dJE, this.dJF);
        }
        if (this.dKd == null) {
            this.dKd = aVar.b(this.dJE, this.dJF);
            gy(true);
        }
        if (this.dKj == null) {
            this.dKj = this.dJE.mRootView.findViewById(e.g.statebar_view);
        }
        if (this.dKk == null) {
            this.dKk = this.dJE.mRootView.findViewById(e.g.statebar_view_holder);
        }
        if (this.dKi == null) {
            this.dKi = new com.baidu.tieba.play.m(this.dJE.getPageContext(), this.dJP);
        }
        this.dKi.setUniqueId(this.dJE.getUniqueId());
        this.dKw = (NavigationBarCoverTip) this.dJE.mRootView.findViewById(e.g.navigation_cover_tip);
        if (this.dKe == null) {
            this.dKe = new com.baidu.tieba.frs.vc.j(this.dJE, this.dKw);
        }
        if (this.QP == null) {
            this.QP = (AppBarLayout) this.dJE.mRootView.findViewById(e.g.frs_app_bar_layout);
            this.QP.addOnOffsetChangedListener(this.dKy);
            this.dKr = true;
            this.dKs = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.QP.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dKo = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.dKv = (FrsMultiDelBottomMenuView) this.dJE.mRootView.findViewById(e.g.frs_multi_delete_menu_view);
        this.dKv.setPageContext(this.dJE.getPageContext());
        this.dJR = (FloatingAnimationView) this.dJE.mRootView.findViewById(e.g.redpacket_view);
        this.dJR.setPageId(this.dJE.getUniqueId());
        this.dJS = new com.baidu.tieba.c.c(this.dJE.getTbPageContext(), this.dJR, 2);
    }

    public void gu(boolean z) {
        if (z && this.dJS != null) {
            this.dJS.arh();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dJS != null) {
            this.dJS.a(mVar);
        }
    }

    private void aBt() {
        ViewGroup.LayoutParams layoutParams;
        this.cGf = aBs();
        if (this.dKp != null && (layoutParams = this.dKp.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cGf) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds88) + aBq(), 0, 0);
            }
            this.dKp.requestLayout();
        }
    }

    public void aBu() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dKl != null) {
            aBt();
            if (this.cGf) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dKj != null) {
                    this.dKj.setAlpha(1.0f);
                }
                if (this.dKk != null) {
                    this.dKk.setAlpha(1.0f);
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
    public void gv(boolean z) {
        if (z && this.dJE != null && this.dJE.aAF() != null) {
            this.dJE.aAF().aHj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aBv() {
        int i;
        if (this.QP == null) {
            return this.dKs;
        }
        if (this.dKs != -1) {
            return this.dKs;
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
        this.dKs = Math.max(0, this.QP.getTotalScrollRange() - Math.abs(i2));
        return this.dKs;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dKb != null && this.dKb.getLayoutParams() != null) {
            this.dKb.getLayoutParams().height = i;
            this.dKb.setLayoutParams(this.dKb.getLayoutParams());
        }
    }

    public void oa(String str) {
        if (this.dKe != null) {
            this.dKe.oa(str);
        }
    }

    public View aBw() {
        return this.dKb;
    }

    public com.baidu.tieba.play.m aBx() {
        return this.dKi;
    }

    public com.baidu.tieba.frs.entelechy.b.c aBy() {
        return this.dKd;
    }

    public void gw(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.I(this.dJE.aAZ().bBT());
        if (this.dKc != null) {
            this.dKc.gw(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aBz() {
        return this.dKc;
    }

    public void B(boolean z, boolean z2) {
        if (this.mIsNeedRefresh && this.dKd != null) {
            this.dKd.B(z, z2);
        }
    }

    public void gx(boolean z) {
        this.mIsNeedRefresh = z;
        if (!this.mIsNeedRefresh && this.dKd != null) {
            this.dKd.B(false, false);
        }
    }

    public void aBA() {
        if (this.mIsNeedRefresh && this.dKd != null) {
            this.dKd.B(false, false);
        }
        this.dJJ.setVisibility(8);
        gw(false);
        this.dJP.setVisibility(8);
        this.dKp.setVisibility(8);
    }

    public void aBB() {
        if (this.mIsNeedRefresh && this.dKd != null) {
            this.dKd.B(true, false);
        }
        this.dJJ.setVisibility(0);
        gw(this.dJE.aBg());
        this.dJP.setVisibility(0);
        this.dKp.setVisibility(0);
    }

    public void gy(boolean z) {
        if (this.dKd != null) {
            this.dKd.hb(z);
        }
    }

    private void aBC() {
        if (this.dKf == null) {
            this.dKf = (GifView) this.dJE.mRootView.findViewById(e.g.gif_real_time);
            this.dKg = (TbImageView) this.dJE.mRootView.findViewById(e.g.tbimg_real_time);
            this.dKg.setPageId(this.dJE.getUniqueId());
            this.dKf.setLayerType(1, null);
            this.dKg.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aBD() {
        return this.dJI;
    }

    public void h(NoNetworkView.a aVar) {
        this.dFP = aVar;
        if (this.dop != null) {
            this.dop.a(this.dFP);
        }
    }

    public void di(boolean z) {
        this.dJD = z;
        if (z) {
            if (this.dKd != null) {
                this.dKd.aDX();
                return;
            }
            return;
        }
        this.dJP.getAdapter().notifyDataSetChanged();
        if (this.dKd != null) {
            this.dKd.aDY();
        }
    }

    public void gz(boolean z) {
        if (this.dKd != null) {
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
        this.dJP.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dJQ.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dJQ.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dKi != null) {
            this.dKi.destroy();
        }
        if (this.dKe != null) {
            this.dKe.onDestory();
        }
        if (this.dKv != null) {
            this.dKv.setPageContext(null);
        }
        this.dJQ.onDestory();
        this.dJP.setOnSrollToBottomListener(null);
        this.dJP.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dKz);
        if (this.dpU != null) {
            this.dpU.onDestroy();
        }
        this.dKh.clear();
        if (this.dKc != null) {
            this.dKc.aDZ();
        }
        if (this.dKn != null) {
            this.dKn.aDd();
        }
        if (this.dJS != null) {
            this.dJS.onDestroy();
        }
        if (this.dKw != null) {
            this.dKw.onDestroy();
        }
        if (this.dKv != null) {
            this.dKv.onDestroy();
        }
    }

    public boolean aBE() {
        if (this.QP == null || this.dKo == null || !this.dKo.isSticky()) {
            return this.dKc != null && this.dKc.aBE();
        }
        if (this.dJP != null) {
            this.dJP.setSelection(0);
        }
        this.dKo.expandedAppBarLayout(this.QP);
        return true;
    }

    public boolean aBa() {
        return this.dJD;
    }

    public void amN() {
        this.dJP.setVisibility(0);
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

    public void aBF() {
        if (this.dJQ != null) {
            this.dJQ.notifyDataSetChanged();
        }
    }

    public void notifyDataChanged() {
        if (this.dJQ instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dJQ).notifyDataChanged();
        }
    }

    private void aBG() {
        if (this.dJT == null && this.dJE.getPageContext() != null) {
            String[] strArr = {this.dJE.getPageContext().getPageActivity().getString(e.j.take_photo), this.dJE.getPageContext().getPageActivity().getString(e.j.album)};
            this.dJT = new com.baidu.tbadk.core.dialog.b(this.dJE.getPageContext().getPageActivity());
            this.dJT.eC(this.dJE.getPageContext().getPageActivity().getString(e.j.operation));
            this.dJT.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dJE.takePhoto();
                    } else if (i == 1 && k.this.dJE.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.w(k.this.dJE.getPageContext().getPageActivity());
                    }
                }
            });
            this.dJT.d(this.dJE.getPageContext());
        }
    }

    public void aBH() {
        aBG();
        if (this.dJT != null) {
            this.dJT.BI();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.I(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dJE != null && this.dJE.aAD() != null && this.dJE.aAD().aGk() == 0) {
                mVar.mi(this.dJE.aAD().aGs());
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
        this.dJQ.b(arrayList, lVar);
        if (this.dKi != null && this.dJv != 0) {
            this.dKi.b(this.dJv, this.bNa, this.dKa, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dJP;
    }

    public void aBI() {
        this.dJQ.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dJE.getPageContext(), 1);
        aVar.a(this.dJP);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dJE.getForumName());
        hashMap.put("forum_id", this.dJE.getForumId());
        aVar.setParams(hashMap);
        aVar.Q(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dKc != null) {
            this.dKc.aEa();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        ma(TbadkCoreApplication.getInst().getSkinType());
        aBW();
        if (this.dKc != null) {
            this.dKc.aEb();
        }
    }

    public void release() {
        if (this.dop != null && this.dFP != null) {
            this.dop.b(this.dFP);
        }
    }

    public ImageView aBJ() {
        return this.dJJ;
    }

    public View aBK() {
        if (this.dJK != null) {
            return this.dJK.getView();
        }
        return null;
    }

    public void p(int i, boolean z) {
        if (this.dJK != null) {
            this.dJK.h(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dJE, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dJE.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dKg != null) {
            this.dKg.invalidate();
        }
        if (this.dJQ != null) {
            this.dJQ.aDN();
            this.dJQ.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dJE.getPageContext(), this.dJF);
        ma(i);
        if (this.dop != null) {
            this.dop.onChangeSkinType(this.dJE.getPageContext(), i);
        }
        if (this.bOy != null) {
            this.bOy.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
            this.bOy.ey(i);
        }
        aBW();
        if (this.dKd != null) {
            this.dKd.onChangeSkinType(i);
        }
        if (this.dKc != null) {
            this.dKc.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dKv != null) {
            this.dKv.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.j(this.bRl, e.d.cp_bg_line_e);
    }

    private void ma(int i) {
        if (this.dJE != null) {
            Pair<Integer, Integer> pair = this.dJE.dIh;
            if (pair != null) {
                a(i, pair);
            } else {
                mb(i);
            }
        }
    }

    private void mb(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.al.dP(e.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dJE.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.al.e(this.dJW, e.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
            int i2 = e.d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.ap.DQ().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.DQ().c(this.dJJ, e.f.icon_topbar_search_n_svg, i2);
            if (this.dJK != null) {
                this.dJK.kR(i2);
                this.dJK.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dKj, i);
        UtilHelper.setStatusBarBackground(this.dKk, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dJE.getPageContext(), i);
                com.baidu.tbadk.core.util.al.e(this.dJW, e.d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dKj, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dKk, pair);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.ap.DQ().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.DQ().c(this.dJJ, e.f.icon_topbar_search_n_svg, i2);
            if (this.dJK != null) {
                this.dJK.kR(i2);
                this.dJK.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dJP != null) {
            this.dJP.setSelection(0);
        }
        if (this.QP != null) {
            this.QP.setExpanded(true);
        }
        if (this.bRl != null && this.bRl.isEnabled()) {
            this.bRl.setRefreshing(true);
        }
    }

    public void gA(boolean z) {
        if (z) {
            this.bRl.setRefreshing(false);
        } else {
            this.bRl.ph();
        }
    }

    public void gB(boolean z) {
        this.bRl.setEnabled(z);
    }

    public void gC(boolean z) {
        this.dJY = z;
        if (this.dJY) {
            this.bOy.setText(this.dJE.getResources().getString(e.j.load_more));
            if (this.dJP.getChildAt(this.dJP.getChildCount() - 1) == this.bOy.getView()) {
                this.bOy.Fc();
                this.dJE.aab();
                return;
            }
            this.bOy.Fd();
            return;
        }
        this.bOy.setText(this.dJE.getResources().getString(e.j.load_more_must_after_delete));
        this.bOy.Fd();
    }

    public boolean aBL() {
        if (this.dJY) {
            return false;
        }
        this.bOy.setText(this.dJE.getResources().getString(e.j.load_more_must_after_delete));
        this.bOy.Fd();
        return true;
    }

    public boolean aBM() {
        return this.dJL != null && this.dJO.getVisibility() == 0;
    }

    public void aBN() {
        if (this.dJL != null) {
            this.dJM.setVisibility(0);
            this.dJO.setVisibility(8);
            this.dJN.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dKz, 5000L);
        }
    }

    public void a(bi biVar) {
        if (this.dJL == null) {
            this.dJL = (ViewStub) this.dJE.mRootView.findViewById(e.g.yule_game_egg_view_stub);
            this.dJL.setVisibility(0);
            this.dJM = (FrameLayout) this.dJE.mRootView.findViewById(e.g.game_activity_egg_layout);
            this.dJN = (TbImageView) this.dJE.mRootView.findViewById(e.g.game_activity_egg);
            this.dJO = (TbImageView) this.dJE.mRootView.findViewById(e.g.game_activity_egg_s);
            this.dJN.setPageId(this.dJE.getUniqueId());
            this.dJO.setPageId(this.dJE.getUniqueId());
            this.dJN.setDefaultBgResource(e.d.common_color_10022);
            this.dJN.setDefaultResource(0);
            this.dJO.setDefaultBgResource(e.d.common_color_10022);
            this.dJO.setDefaultResource(0);
            this.dJM.setOnClickListener(this.dJU);
        }
        this.dJM.setVisibility(0);
        String Bv = biVar.Bv();
        String Bw = biVar.Bw();
        this.dJN.startLoad(Bv, 10, false);
        this.dJO.startLoad(Bw, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dKz, 5000L);
    }

    public void aBO() {
        if (this.dJL != null) {
            this.dJM.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aBP() {
        return this.dJQ;
    }

    public RelativeLayout aBQ() {
        return this.dJF;
    }

    public View aBR() {
        return this.dJX;
    }

    public void mc(int i) {
        if (this.dJH != null) {
            this.dJH.setVisibility(i);
        }
    }

    public void aBS() {
        if (com.baidu.tbadk.l.m.Pk().Pl()) {
            int lastVisiblePosition = this.dJP.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dJP.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dKK != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.dKK.getPerfLog();
                        perfLog.gi(1000);
                        perfLog.bfM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dKK.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dKK.startLogPerf();
                    }
                    if (oVar.dKJ != null && (oVar.dKJ instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dKJ;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.gi(1000);
                                perfLog2.bfM = true;
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

    public NavigationBar abU() {
        return this.mNavigationBar;
    }

    public void aaZ() {
        this.mHasMore = true;
        this.dJP.setNextPage(this.bOy);
        if (this.dJZ > 0) {
            this.bOy.ez(this.dJZ);
        }
        this.bOy.setOnClickListener(null);
        this.bOy.Fc();
    }

    public void aba() {
        this.mHasMore = false;
        this.dJP.setNextPage(this.bOy);
        if (this.dJZ > 0) {
            this.bOy.ez(this.dJZ);
        }
        this.bOy.setOnClickListener(null);
        this.bOy.Fd();
        this.bOy.setText(this.dJE.getResources().getString(e.j.list_has_no_more));
    }

    public void aBT() {
        this.mHasMore = true;
        this.dJP.setNextPage(this.bOy);
        this.bOy.setOnClickListener(this.dJU);
        if (this.dJZ > 0) {
            this.bOy.ez(this.dJZ);
        }
        this.bOy.Fd();
        this.bOy.setText(this.dJE.getResources().getString(e.j.list_click_load_more));
    }

    public View aBU() {
        if (this.bOy == null) {
            return null;
        }
        return this.bOy.getView();
    }

    public void md(int i) {
        if (this.dKv != null) {
            this.dKv.setVisibility(i);
        }
    }

    public void me(int i) {
        if (this.dKv != null) {
            this.dKv.setSelectNumber(i);
        }
    }

    public void abb() {
        this.mHasMore = false;
        this.dJP.setNextPage(null);
    }

    public boolean aqz() {
        return this.bOy.getView().getParent() != null && this.mHasMore;
    }

    public void mf(int i) {
        this.dJZ = i;
    }

    public void mg(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dpU == null) {
                    this.dpU = new CommonTipView(this.dJE.getActivity());
                }
                this.dpU.setText(e.j.frs_login_tip);
                this.dpU.show((FrameLayout) aBR(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void gD(boolean z) {
        if (this.dKi != null) {
            if (z) {
                this.dKi.jz(false);
                this.dKi.aZc();
                return;
            }
            this.dKi.jz(true);
            this.dKi.b(this.dJv, this.bNa, this.dKa, true);
        }
    }

    public void aK(int i, int i2) {
        if (this.dKi != null) {
            this.dKi.a(i, i2, this.dKa, 1);
        }
    }

    public void aL(int i, int i2) {
        this.dJv = i;
        this.bNa = i2;
    }

    public void gE(boolean z) {
        this.dKa = z;
    }

    private void aBV() {
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
            if (this.dKj != null) {
                this.dKj.setAlpha(alpha);
            }
            if (this.dKk != null) {
                this.dKk.setAlpha(alpha);
            }
            if (this.dJW != null) {
                this.dJW.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBW() {
        if (this.dJE.dIh == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cGf) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.al.a(this.dJJ, e.f.icon_sml_search_bg, e.f.icon_sml_search_bg);
                if (this.dJK != null) {
                    com.baidu.tbadk.core.util.al.a(this.dJK.are(), e.f.icon_topbar_white_remind, e.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.icon_return_bg_s, e.f.icon_return_bg);
                com.baidu.tbadk.core.util.al.a(this.dJJ, e.f.icon_search_bg_s, e.f.icon_search_bg);
                if (this.dJK != null) {
                    com.baidu.tbadk.core.util.al.a(this.dJK.are(), e.f.icon_topbar_remind, e.f.icon_topbar_remind);
                }
            }
            aBV();
        }
    }

    public void gF(boolean z) {
    }

    public void mh(int i) {
        if (this.dJP != null && this.dJP.getChildCount() >= 0) {
            if (this.dJP.getFirstVisiblePosition() > 8) {
                this.dJP.scrollToPosition(8);
            }
            this.dJP.smoothScrollToPosition(i);
        }
    }

    public void aBX() {
        a(this.dKm, this.dJE.aBb());
        if (this.dJQ != null) {
            this.dJQ.aDR();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dKn == null) {
                this.dKn = new com.baidu.tieba.video.f(this.dJE.getActivity(), this.dJF);
            }
            this.dKn.h(postWriteCallBackData);
        }
    }

    public void aBY() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dKA && this.dJE.getActivity() != null && this.dJE.getPageContext() != null) {
            View view = null;
            if (this.dJP != null && (headerViewsCount = this.dJP.getHeaderViewsCount()) < this.dJP.getChildCount()) {
                view = this.dJP.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aw(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(e.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.tips)).setText(e.j.frs_video_activity_guide_tip);
                        k.this.dJE.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.h(k.this.dJE.getActivity(), e.C0210e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.dJE.getActivity(), e.C0210e.ds6);
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
                iT.n(this.dJE.getActivity());
                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iT != null) {
                            iT.dismiss();
                        }
                    }
                }, 4000L);
                this.dKA = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.dKv != null) {
            this.dKv.setDeleteCallback(aVar);
        }
    }

    public void aBZ() {
        if (this.dKv != null) {
            this.dKv.aBZ();
        }
    }

    public void Uz() {
        if (this.dKv != null) {
            this.dKv.Uz();
        }
    }

    public void ac(String str, int i) {
        if (this.dKx == null) {
            this.dKx = new TextView(this.dJE.getActivity());
            this.dKx.setGravity(19);
            this.dKx.setPadding(com.baidu.adp.lib.util.l.h(this.dJE.getActivity(), e.C0210e.ds34), 0, com.baidu.adp.lib.util.l.h(this.dJE.getActivity(), e.C0210e.ds34), 0);
            this.dKx.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.dJE.getActivity(), e.C0210e.tbds112)));
            this.dKx.setTextSize(0, com.baidu.adp.lib.util.l.h(this.dJE.getActivity(), e.C0210e.fontsize30));
            this.dKx.setMaxLines(2);
            this.dKx.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.dKx.setTextColor(ContextCompat.getColor(this.dJE.getActivity(), e.d.cp_cont_i));
        }
        this.dKw.setBackgroundColor(i);
        this.dKx.setText(str);
        this.dKw.a(this.dJE.getActivity(), this.dKx, UIMsg.m_AppUI.MSG_APP_GPS);
    }
}
