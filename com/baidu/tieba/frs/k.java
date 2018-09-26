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
/* loaded from: classes2.dex */
public class k {
    private AppBarLayout Qy;
    private PbListView bBr;
    private BdSwipeRefreshLayout bEe;
    private NoNetworkView cYm;
    private CommonTipView cZX;
    private FrsFragment dtN;
    private View dtR;
    private ImageView dtS;
    private com.baidu.tieba.c.b dtT;
    private ViewStub dtU;
    private com.baidu.tieba.frs.entelechy.a.q dtZ;
    private CollapsingToolbarLayout duA;
    private com.baidu.tieba.frs.vc.f duE;
    private FrsMultiDelBottomMenuView duF;
    private NavigationBarCoverTip duG;
    private TextView duH;
    private boolean duK;
    private FloatingAnimationView dua;
    private com.baidu.tieba.c.c dub;
    private View.OnClickListener dud;
    private View duf;
    private View dug;
    private int dui;
    private View duk;
    private com.baidu.tieba.frs.entelechy.b.d dul;
    private com.baidu.tieba.frs.entelechy.b.c dum;
    private com.baidu.tieba.frs.vc.i dun;
    private GifView duo;
    private TbImageView dup;
    private HashSet<String> duq;
    private com.baidu.tieba.play.m dur;
    private ObservedChangeLinearLayout duu;
    private com.baidu.tieba.frs.entelechy.b.a duv;
    private com.baidu.tieba.video.f dux;
    private AppBarLayoutStickyBehavior duy;
    private FrsHeaderViewContainer duz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dtM = false;
    private NoPressedRelativeLayout dtO = null;
    private CoordinatorLayout dtP = null;
    private View dtQ = null;
    private FrameLayout dtV = null;
    private TbImageView dtW = null;
    private TbImageView dtX = null;
    private BdTypeRecyclerView dtY = null;
    private com.baidu.tbadk.core.dialog.b duc = null;
    private NoNetworkView.a dpW = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener due = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dtY != null && k.this.dtY.getAdapter() != null) {
                k.this.dtY.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean duh = true;
    private boolean mHasMore = true;
    private boolean duj = false;
    private int dtE = 0;
    private int bzS = 0;
    private View dus = null;
    private View dut = null;
    private boolean csx = false;
    private boolean duw = true;
    private boolean duB = true;
    private int duC = -1;
    private int duD = -1;
    private AppBarLayout.OnOffsetChangedListener duI = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.duD != i && Math.abs(i) >= 0 && k.this.awS() != -1) {
                if (Math.abs(i) >= k.this.awS()) {
                    if (k.this.duB) {
                        k.this.duB = false;
                        k.this.fS(k.this.duB);
                    }
                } else if (!k.this.duB) {
                    k.this.duB = true;
                    k.this.fS(k.this.duB);
                }
                int awM = k.this.awM() + k.this.awL() + k.this.awN();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - awM;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.duD - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.kT(Math.abs(awM - totalScrollRange2));
                        if (k.this.dut != null) {
                            k.this.dut.setVisibility(0);
                        }
                    } else if (k.this.dut != null) {
                        if (k.this.awK() != UtilHelper.getStatusBarHeight()) {
                            k.this.kT(0);
                        }
                        k.this.dut.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.csx) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.axt();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.duD = i;
                }
            }
        }
    };
    private Runnable duJ = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dtU != null) {
                k.this.dtV.setVisibility(0);
                k.this.dtX.setVisibility(0);
                k.this.dtW.setVisibility(8);
            }
        }
    };
    private CustomMessageListener duL = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.Qy.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout awH() {
        return this.duu;
    }

    public View awI() {
        return this.dus;
    }

    public View awJ() {
        return this.dut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awK() {
        if (this.dus == null) {
            return 0;
        }
        return this.dus.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awL() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awM() {
        if (this.cYm == null || com.baidu.adp.lib.util.j.kK()) {
            return 0;
        }
        return this.cYm.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awN() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kT(int i) {
        View awI = awI();
        View awJ = awJ();
        if (UtilHelper.canUseStyleImmersiveSticky() && awI != null && awJ != null && awI.getLayoutParams() != null && awJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = awI.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            awI.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = awJ.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            awJ.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dtN = null;
        this.dud = null;
        this.dui = 0;
        this.dtN = frsFragment;
        this.dud = onClickListener;
        a(aVar, z);
        this.duq = new HashSet<>();
        this.dui = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.duE = fVar;
    }

    private boolean awO() {
        return this.duE != null && this.duE.aCF();
    }

    private void awP() {
        this.dtN.registerListener(this.duL);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        awP();
        this.duv = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dtN.getPageContext());
        }
        this.mPullView.setTag(this.dtN.getUniqueId());
        if (this.dtO == null) {
            this.dtO = (NoPressedRelativeLayout) this.dtN.mRootView.findViewById(e.g.frs);
        }
        if (this.dtQ == null) {
            this.dtQ = this.dtN.mRootView.findViewById(e.g.frs_content_container);
        }
        if (this.dtP == null) {
            this.dtP = (CoordinatorLayout) this.dtN.mRootView.findViewById(e.g.frs_nested_scroll_layout);
        }
        if (this.dug == null) {
            this.dug = this.dtN.mRootView.findViewById(e.g.frs_list_content);
        }
        if (this.duA == null) {
            this.duA = (CollapsingToolbarLayout) this.dtN.mRootView.findViewById(e.g.frs_collapse_layout);
        }
        if (this.duz == null) {
            this.duz = (FrsHeaderViewContainer) this.dtN.mRootView.findViewById(e.g.header_view_container);
        }
        if (this.duu == null) {
            this.duu = (ObservedChangeLinearLayout) this.dtN.mRootView.findViewById(e.g.navigation_bar_wrapperLayout);
            this.duu.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.duA.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dtN.mRootView.findViewById(e.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dtN.awx()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.duf == null) {
            this.duf = this.dtN.mRootView.findViewById(e.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b ayP = aVar.ayP();
            if (ayP != null) {
                ayP.aK(this.duf);
            }
        }
        if (this.dtR == null) {
            this.dtR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dtR.setOnClickListener(this.dud);
            this.mBackImageView = (ImageView) this.dtR.findViewById(e.g.widget_navi_back_button);
        }
        if (this.dtS == null) {
            this.dtS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dtS.setOnClickListener(this.dud);
        }
        if (this.dtT == null) {
            this.dtT = new com.baidu.tieba.c.b(this.dtN.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dtT.getView(), (View.OnClickListener) null);
            this.dtT.getView().setOnClickListener(this.dud);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dtN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
        }
        if (this.bEe == null) {
            this.bEe = (BdSwipeRefreshLayout) this.dtN.mRootView.findViewById(e.g.frs_pull_refresh_layout);
            this.bEe.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.j(this.bEe, e.d.cp_bg_line_c);
        }
        if (this.dtY == null) {
            this.dtY = (BdTypeRecyclerView) this.dtN.mRootView.findViewById(e.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int duO = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.duO--;
                if (this.duO == 0) {
                    k.this.dtY.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.duO++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dtY.setItemAnimator(defaultItemAnimator);
        this.dtY.setLayoutManager(new LinearLayoutManager(this.dtY.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.dtY.setScrollable(this.dtN);
        this.dtY.setFadingEdgeLength(0);
        this.dtY.setOverScrollMode(2);
        this.dtO.setBottomOrderView(this.dtY);
        this.dtY.setOnTouchListener(this.dtN.aZX);
        this.dtY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dur != null) {
                    k.this.dur.bh(view);
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
        if (this.bBr == null) {
            this.bBr = new PbListView(this.dtN.getPageContext().getPageActivity());
            this.bBr.getView();
        }
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.setHeight(com.baidu.adp.lib.util.l.h(this.dtN.getActivity(), e.C0141e.tbds182));
        this.bBr.BF();
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
        this.bBr.dK(e.d.cp_cont_e);
        this.dtY.setOnSrollToBottomListener(this.dtN);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dtN.awu();
                if (k.this.dtN != null && k.this.Qy != null) {
                    k.this.dtN.awz();
                    k.this.Qy.setExpanded(true);
                    if (k.this.dur != null) {
                        k.this.dur.b(k.this.dtE, k.this.bzS, false, true);
                    }
                }
            }
        });
        boolean AB = com.baidu.tbadk.core.util.aq.Az().AB();
        if (this.dtZ == null) {
            this.dtZ = aVar.a(this.dtN, this.dtY, AB);
        }
        cH(false);
        if (!z) {
            if (this.cYm == null) {
                this.cYm = new NoNetworkView(this.dtN.getActivity());
                this.cYm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.duu.addView(this.cYm);
            }
            if (com.baidu.adp.lib.util.j.ky()) {
                this.cYm.setVisibility(8);
            } else {
                this.cYm.setVisibility(0);
            }
            this.cYm.onChangeSkinType(this.dtN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        awZ();
        if (this.dul == null) {
            this.dul = aVar.c(this.dtN, this.dtO);
        }
        if (this.dum == null) {
            this.dum = aVar.b(this.dtN, this.dtO);
            fV(true);
        }
        if (this.dus == null) {
            this.dus = this.dtN.mRootView.findViewById(e.g.statebar_view);
        }
        if (this.dut == null) {
            this.dut = this.dtN.mRootView.findViewById(e.g.statebar_view_holder);
        }
        if (this.dur == null) {
            this.dur = new com.baidu.tieba.play.m(this.dtN.getPageContext(), this.dtY);
        }
        this.dur.setUniqueId(this.dtN.getUniqueId());
        this.duG = (NavigationBarCoverTip) this.dtN.mRootView.findViewById(e.g.navigation_cover_tip);
        if (this.dun == null) {
            this.dun = new com.baidu.tieba.frs.vc.i(this.dtN, this.duG);
        }
        if (this.Qy == null) {
            this.Qy = (AppBarLayout) this.dtN.mRootView.findViewById(e.g.frs_app_bar_layout);
            this.Qy.addOnOffsetChangedListener(this.duI);
            this.duB = true;
            this.duC = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Qy.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.duy = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.duF = (FrsMultiDelBottomMenuView) this.dtN.mRootView.findViewById(e.g.frs_multi_delete_menu_view);
        this.duF.setPageContext(this.dtN.getPageContext());
        this.dua = (FloatingAnimationView) this.dtN.mRootView.findViewById(e.g.redpacket_view);
        this.dua.setPageId(this.dtN.getUniqueId());
        this.dub = new com.baidu.tieba.c.c(this.dtN.getTbPageContext(), this.dua, 2);
    }

    public void fR(boolean z) {
        if (z && this.dub != null) {
            this.dub.amu();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dub != null) {
            this.dub.a(mVar);
        }
    }

    private void awQ() {
        ViewGroup.LayoutParams layoutParams;
        this.csx = awO();
        if (this.duz != null && (layoutParams = this.duz.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.csx) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds88) + awL(), 0, 0);
            }
            this.duz.requestLayout();
        }
    }

    public void awR() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.duu != null) {
            awQ();
            if (this.csx) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dus != null) {
                    this.dus.setAlpha(1.0f);
                }
                if (this.dut != null) {
                    this.dut.setAlpha(1.0f);
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
    public void fS(boolean z) {
        if (z && this.dtN != null && this.dtN.awb() != null) {
            this.dtN.awb().aCJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awS() {
        int i;
        if (this.Qy == null) {
            return this.duC;
        }
        if (this.duC != -1) {
            return this.duC;
        }
        int childCount = this.Qy.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Qy.getChildAt(childCount);
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
        this.duC = Math.max(0, this.Qy.getTotalScrollRange() - Math.abs(i2));
        return this.duC;
    }

    public void setHeaderViewHeight(int i) {
        if (this.duk != null && this.duk.getLayoutParams() != null) {
            this.duk.getLayoutParams().height = i;
            this.duk.setLayoutParams(this.duk.getLayoutParams());
        }
    }

    public void mY(String str) {
        if (this.dun != null) {
            this.dun.mY(str);
        }
    }

    public View awT() {
        return this.duk;
    }

    public com.baidu.tieba.play.m awU() {
        return this.dur;
    }

    public com.baidu.tieba.frs.entelechy.b.c awV() {
        return this.dum;
    }

    public void fT(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.z(this.dtN.awv().bxp());
        if (this.dul != null) {
            this.dul.fT(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d awW() {
        return this.dul;
    }

    public void y(boolean z, boolean z2) {
        if (this.duw && this.dum != null) {
            this.dum.y(z, z2);
        }
    }

    public void fU(boolean z) {
        this.duw = z;
        if (!this.duw && this.dum != null) {
            this.dum.y(false, false);
        }
    }

    public void awX() {
        if (this.duw && this.dum != null) {
            this.dum.y(false, false);
        }
        this.dtS.setVisibility(8);
        fT(false);
        this.dtY.setVisibility(8);
        this.duz.setVisibility(8);
    }

    public void awY() {
        if (this.duw && this.dum != null) {
            this.dum.y(true, false);
        }
        this.dtS.setVisibility(0);
        fT(this.dtN.awC());
        this.dtY.setVisibility(0);
        this.duz.setVisibility(0);
    }

    public void fV(boolean z) {
        if (this.dum != null) {
            this.dum.gy(z);
        }
    }

    private void awZ() {
        if (this.duo == null) {
            this.duo = (GifView) this.dtN.mRootView.findViewById(e.g.gif_real_time);
            this.dup = (TbImageView) this.dtN.mRootView.findViewById(e.g.tbimg_real_time);
            this.dup.setPageId(this.dtN.getUniqueId());
            this.duo.setLayerType(1, null);
            this.dup.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View axa() {
        return this.dtR;
    }

    public void h(NoNetworkView.a aVar) {
        this.dpW = aVar;
        if (this.cYm != null) {
            this.cYm.a(this.dpW);
        }
    }

    public void cH(boolean z) {
        this.dtM = z;
        if (z) {
            if (this.dum != null) {
                this.dum.azx();
                return;
            }
            return;
        }
        this.dtY.getAdapter().notifyDataSetChanged();
        if (this.dum != null) {
            this.dum.azy();
        }
    }

    public void fW(boolean z) {
        if (this.dum != null) {
            if (z) {
                y(false, true);
            } else {
                y(false, false);
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
        this.dtY.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dtZ.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dtZ.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dur != null) {
            this.dur.destroy();
        }
        if (this.dun != null) {
            this.dun.onDestory();
        }
        if (this.duF != null) {
            this.duF.setPageContext(null);
        }
        this.dtZ.onDestory();
        this.dtY.setOnSrollToBottomListener(null);
        this.dtY.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.duJ);
        if (this.cZX != null) {
            this.cZX.onDestroy();
        }
        this.duq.clear();
        if (this.dul != null) {
            this.dul.azz();
        }
        if (this.dux != null) {
            this.dux.ayC();
        }
        if (this.dub != null) {
            this.dub.onDestroy();
        }
        if (this.duG != null) {
            this.duG.onDestroy();
        }
        if (this.duF != null) {
            this.duF.onDestroy();
        }
    }

    public boolean axb() {
        if (this.Qy == null || this.duy == null || !this.duy.isSticky()) {
            return this.dul != null && this.dul.axb();
        }
        if (this.dtY != null) {
            this.dtY.setSelection(0);
        }
        this.duy.expandedAppBarLayout(this.Qy);
        return true;
    }

    public boolean aww() {
        return this.dtM;
    }

    public void aiB() {
        this.dtY.setVisibility(0);
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
            com.baidu.tbadk.core.i.uj().ds(str);
        }
    }

    public void axc() {
        if (this.dtZ != null) {
            this.dtZ.notifyDataSetChanged();
        }
    }

    public void alQ() {
        if (this.dtZ instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dtZ).alQ();
        }
    }

    private void axd() {
        if (this.duc == null && this.dtN.getPageContext() != null) {
            String[] strArr = {this.dtN.getPageContext().getPageActivity().getString(e.j.take_photo), this.dtN.getPageContext().getPageActivity().getString(e.j.album)};
            this.duc = new com.baidu.tbadk.core.dialog.b(this.dtN.getPageContext().getPageActivity());
            this.duc.dU(this.dtN.getPageContext().getPageActivity().getString(e.j.operation));
            this.duc.a(strArr, new b.InterfaceC0100b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dtN.takePhoto();
                    } else if (i == 1 && k.this.dtN.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.u(k.this.dtN.getPageContext().getPageActivity());
                    }
                }
            });
            this.duc.d(this.dtN.getPageContext());
        }
    }

    public void axe() {
        axd();
        if (this.duc != null) {
            this.duc.yo();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.z(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dtN != null && this.dtN.avZ() != null && this.dtN.avZ().aBJ() == 0) {
                mVar.lc(this.dtN.avZ().aBR());
            }
        }
        if (com.baidu.tbadk.core.util.v.y(arrayList) > 0) {
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
        this.dtZ.b(arrayList, lVar);
        if (this.dur != null && this.dtE != 0) {
            this.dur.b(this.dtE, this.bzS, this.duj, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dtY;
    }

    public void axf() {
        this.dtZ.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dtN.getPageContext(), 1);
        aVar.a(this.dtY);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dtN.getForumName());
        hashMap.put("forum_id", this.dtN.getForumId());
        aVar.setParams(hashMap);
        aVar.N(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dul != null) {
            this.dul.azA();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        kU(TbadkCoreApplication.getInst().getSkinType());
        axt();
        if (this.dul != null) {
            this.dul.azB();
        }
    }

    public void release() {
        if (this.cYm != null && this.dpW != null) {
            this.cYm.b(this.dpW);
        }
    }

    public ImageView axg() {
        return this.dtS;
    }

    public View axh() {
        if (this.dtT != null) {
            return this.dtT.getView();
        }
        return null;
    }

    public void p(int i, boolean z) {
        if (this.dtT != null) {
            this.dtT.f(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dtN, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dtN.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dup != null) {
            this.dup.invalidate();
        }
        if (this.dtZ != null) {
            this.dtZ.azn();
            this.dtZ.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dtN.getPageContext(), this.dtO);
        kU(i);
        if (this.cYm != null) {
            this.cYm.onChangeSkinType(this.dtN.getPageContext(), i);
        }
        if (this.bBr != null) {
            this.bBr.setTextColor(com.baidu.tbadk.core.util.al.getColor(e.d.cp_cont_d));
            this.bBr.dM(i);
        }
        axt();
        if (this.dum != null) {
            this.dum.onChangeSkinType(i);
        }
        if (this.dul != null) {
            this.dul.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.duF != null) {
            this.duF.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.j(this.bEe, e.d.cp_bg_line_e);
    }

    private void kU(int i) {
        if (this.dtN != null) {
            Pair<Integer, Integer> pair = this.dtN.dsq;
            if (pair != null) {
                a(i, pair);
            } else {
                kV(i);
            }
        }
    }

    private void kV(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.al.dd(e.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dtN.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.al.e(this.duf, e.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
            int i2 = e.d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.ap.Ay().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.Ay().c(this.dtS, e.f.icon_topbar_search_n_svg, i2);
            if (this.dtT != null) {
                this.dtT.jK(i2);
                this.dtT.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dus, i);
        UtilHelper.setStatusBarBackground(this.dut, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dtN.getPageContext(), i);
                com.baidu.tbadk.core.util.al.e(this.duf, e.d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), e.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.c(this.mNavigationBar.mCenterText, e.d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dus, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dut, pair);
            int i2 = e.d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.ap.Ay().c(this.mBackImageView, e.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.Ay().c(this.dtS, e.f.icon_topbar_search_n_svg, i2);
            if (this.dtT != null) {
                this.dtT.jK(i2);
                this.dtT.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dtY != null) {
            this.dtY.setSelection(0);
        }
        if (this.Qy != null) {
            this.Qy.setExpanded(true);
        }
        if (this.bEe != null && this.bEe.isEnabled()) {
            this.bEe.setRefreshing(true);
        }
    }

    public void fX(boolean z) {
        if (z) {
            this.bEe.setRefreshing(false);
        } else {
            this.bEe.pc();
        }
    }

    public void fY(boolean z) {
        this.bEe.setEnabled(z);
    }

    public void fZ(boolean z) {
        this.duh = z;
        if (this.duh) {
            this.bBr.setText(this.dtN.getResources().getString(e.j.load_more));
            if (this.dtY.getChildAt(this.dtY.getChildCount() - 1) == this.bBr.getView()) {
                this.bBr.BI();
                this.dtN.Vd();
                return;
            }
            this.bBr.BJ();
            return;
        }
        this.bBr.setText(this.dtN.getResources().getString(e.j.load_more_must_after_delete));
        this.bBr.BJ();
    }

    public boolean axi() {
        if (this.duh) {
            return false;
        }
        this.bBr.setText(this.dtN.getResources().getString(e.j.load_more_must_after_delete));
        this.bBr.BJ();
        return true;
    }

    public boolean axj() {
        return this.dtU != null && this.dtX.getVisibility() == 0;
    }

    public void axk() {
        if (this.dtU != null) {
            this.dtV.setVisibility(0);
            this.dtX.setVisibility(8);
            this.dtW.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.duJ, 5000L);
        }
    }

    public void a(bi biVar) {
        if (this.dtU == null) {
            this.dtU = (ViewStub) this.dtN.mRootView.findViewById(e.g.yule_game_egg_view_stub);
            this.dtU.setVisibility(0);
            this.dtV = (FrameLayout) this.dtN.mRootView.findViewById(e.g.game_activity_egg_layout);
            this.dtW = (TbImageView) this.dtN.mRootView.findViewById(e.g.game_activity_egg);
            this.dtX = (TbImageView) this.dtN.mRootView.findViewById(e.g.game_activity_egg_s);
            this.dtW.setPageId(this.dtN.getUniqueId());
            this.dtX.setPageId(this.dtN.getUniqueId());
            this.dtW.setDefaultBgResource(e.d.common_color_10022);
            this.dtW.setDefaultResource(0);
            this.dtX.setDefaultBgResource(e.d.common_color_10022);
            this.dtX.setDefaultResource(0);
            this.dtV.setOnClickListener(this.dud);
        }
        this.dtV.setVisibility(0);
        String yb = biVar.yb();
        String yc = biVar.yc();
        this.dtW.startLoad(yb, 10, false);
        this.dtX.startLoad(yc, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.duJ, 5000L);
    }

    public void axl() {
        if (this.dtU != null) {
            this.dtV.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q axm() {
        return this.dtZ;
    }

    public RelativeLayout axn() {
        return this.dtO;
    }

    public View axo() {
        return this.dug;
    }

    public void kW(int i) {
        if (this.dtQ != null) {
            this.dtQ.setVisibility(i);
        }
    }

    public void axp() {
        if (com.baidu.tbadk.l.m.LZ().Ma()) {
            int lastVisiblePosition = this.dtY.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dtY.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.duU != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.duU.getPerfLog();
                        perfLog.fx(1000);
                        perfLog.aWZ = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.duU.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.duU.startLogPerf();
                    }
                    if (oVar.duT != null && (oVar.duT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.duT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fx(1000);
                                perfLog2.aWZ = true;
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

    public NavigationBar WW() {
        return this.mNavigationBar;
    }

    public void Wb() {
        this.mHasMore = true;
        this.dtY.setNextPage(this.bBr);
        if (this.dui > 0) {
            this.bBr.dN(this.dui);
        }
        this.bBr.setOnClickListener(null);
        this.bBr.BI();
    }

    public void Wc() {
        this.mHasMore = false;
        this.dtY.setNextPage(this.bBr);
        if (this.dui > 0) {
            this.bBr.dN(this.dui);
        }
        this.bBr.setOnClickListener(null);
        this.bBr.BJ();
        this.bBr.setText(this.dtN.getResources().getString(e.j.list_has_no_more));
    }

    public void axq() {
        this.mHasMore = true;
        this.dtY.setNextPage(this.bBr);
        this.bBr.setOnClickListener(this.dud);
        if (this.dui > 0) {
            this.bBr.dN(this.dui);
        }
        this.bBr.BJ();
        this.bBr.setText(this.dtN.getResources().getString(e.j.list_click_load_more));
    }

    public View axr() {
        if (this.bBr == null) {
            return null;
        }
        return this.bBr.getView();
    }

    public void kX(int i) {
        if (this.duF != null) {
            this.duF.setVisibility(i);
        }
    }

    public void kY(int i) {
        if (this.duF != null) {
            this.duF.setSelectNumber(i);
        }
    }

    public void Wd() {
        this.mHasMore = false;
        this.dtY.setNextPage(null);
    }

    public boolean alI() {
        return this.bBr.getView().getParent() != null && this.mHasMore;
    }

    public void kZ(int i) {
        this.dui = i;
    }

    public void la(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cZX == null) {
                    this.cZX = new CommonTipView(this.dtN.getActivity());
                }
                this.cZX.setText(e.j.frs_login_tip);
                this.cZX.show((FrameLayout) axo(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void ga(boolean z) {
        if (this.dur != null) {
            if (z) {
                this.dur.iU(false);
                this.dur.aUB();
                return;
            }
            this.dur.iU(true);
            this.dur.b(this.dtE, this.bzS, this.duj, true);
        }
    }

    public void aF(int i, int i2) {
        if (this.dur != null) {
            this.dur.a(i, i2, this.duj, 1);
        }
    }

    public void aG(int i, int i2) {
        this.dtE = i;
        this.bzS = i2;
    }

    public void gb(boolean z) {
        this.duj = z;
    }

    private void axs() {
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
            if (this.dus != null) {
                this.dus.setAlpha(alpha);
            }
            if (this.dut != null) {
                this.dut.setAlpha(alpha);
            }
            if (this.duf != null) {
                this.duf.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axt() {
        if (this.dtN.dsq == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.csx) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.btn_sml_back_selector_s, e.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.al.a(this.dtS, e.f.icon_sml_search_bg, e.f.icon_sml_search_bg);
                if (this.dtT != null) {
                    com.baidu.tbadk.core.util.al.a(this.dtT.amr(), e.f.icon_topbar_white_remind, e.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, e.f.icon_return_bg_s, e.f.icon_return_bg);
                com.baidu.tbadk.core.util.al.a(this.dtS, e.f.icon_search_bg_s, e.f.icon_search_bg);
                if (this.dtT != null) {
                    com.baidu.tbadk.core.util.al.a(this.dtT.amr(), e.f.icon_topbar_remind, e.f.icon_topbar_remind);
                }
            }
            axs();
        }
    }

    public void gc(boolean z) {
    }

    public void lb(int i) {
        if (this.dtY != null && this.dtY.getChildCount() >= 0) {
            if (this.dtY.getFirstVisiblePosition() > 8) {
                this.dtY.scrollToPosition(8);
            }
            this.dtY.smoothScrollToPosition(i);
        }
    }

    public void axu() {
        a(this.duv, this.dtN.awx());
        if (this.dtZ != null) {
            this.dtZ.azr();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dux == null) {
                this.dux = new com.baidu.tieba.video.f(this.dtN.getActivity(), this.dtO);
            }
            this.dux.h(postWriteCallBackData);
        }
    }

    public void axv() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.duK && this.dtN.getActivity() != null && this.dtN.getPageContext() != null) {
            View view = null;
            if (this.dtY != null && (headerViewsCount = this.dtY.getHeaderViewsCount()) < this.dtY.getChildCount()) {
                view = this.dtY.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).af(0).O(true).P(false).N(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(e.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(e.g.tips)).setText(e.j.frs_video_activity_guide_tip);
                        k.this.dtN.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iC() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iD() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.h(k.this.dtN.getActivity(), e.C0141e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.dtN.getActivity(), e.C0141e.ds6);
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
                final com.baidu.adp.lib.guide.c iE = dVar.iE();
                iE.L(false);
                iE.n(this.dtN.getActivity());
                com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iE != null) {
                            iE.dismiss();
                        }
                    }
                }, 4000L);
                this.duK = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.duF != null) {
            this.duF.setDeleteCallback(aVar);
        }
    }

    public void axw() {
        if (this.duF != null) {
            this.duF.axw();
        }
    }

    public void Ro() {
        if (this.duF != null) {
            this.duF.Ro();
        }
    }

    public void X(String str, int i) {
        if (this.duH == null) {
            this.duH = new TextView(this.dtN.getActivity());
            this.duH.setGravity(19);
            this.duH.setPadding(com.baidu.adp.lib.util.l.h(this.dtN.getActivity(), e.C0141e.ds34), 0, com.baidu.adp.lib.util.l.h(this.dtN.getActivity(), e.C0141e.ds34), 0);
            this.duH.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.dtN.getActivity(), e.C0141e.tbds112)));
            this.duH.setTextSize(0, com.baidu.adp.lib.util.l.h(this.dtN.getActivity(), e.C0141e.fontsize30));
            this.duH.setMaxLines(2);
            this.duH.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.duH.setTextColor(ContextCompat.getColor(this.dtN.getActivity(), e.d.cp_cont_i));
        }
        this.duG.setBackgroundColor(i);
        this.duH.setText(str);
        this.duG.a(this.dtN.getActivity(), this.duH, 5000);
    }
}
