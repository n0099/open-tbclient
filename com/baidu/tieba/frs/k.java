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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.d;
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
    private AppBarLayout NV;
    private PbListView bvA;
    private BdSwipeRefreshLayout byn;
    private NoNetworkView cSy;
    private CommonTipView cUk;
    private FrsFragment dnR;
    private View dnV;
    private ImageView dnW;
    private com.baidu.tieba.c.b dnX;
    private ViewStub dnY;
    private com.baidu.tieba.frs.entelechy.b.a doA;
    private com.baidu.tieba.video.f doC;
    private AppBarLayoutStickyBehavior doD;
    private FrsHeaderViewContainer doE;
    private CollapsingToolbarLayout doF;
    private com.baidu.tieba.frs.vc.f doJ;
    private FrsMultiDelBottomMenuView doK;
    private NavigationBarCoverTip doL;
    private TextView doM;
    private boolean doP;
    private com.baidu.tieba.frs.entelechy.a.q doe;
    private FloatingAnimationView dof;
    private com.baidu.tieba.c.c dog;
    private View.OnClickListener doi;
    private View dok;
    private View dol;
    private int don;
    private View dop;
    private com.baidu.tieba.frs.entelechy.b.d doq;
    private com.baidu.tieba.frs.entelechy.b.c dor;
    private com.baidu.tieba.frs.vc.i dos;
    private GifView dot;
    private TbImageView dou;
    private HashSet<String> dov;
    private com.baidu.tieba.play.m dow;
    private ObservedChangeLinearLayout doz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean dnQ = false;
    private NoPressedRelativeLayout dnS = null;
    private CoordinatorLayout dnT = null;
    private View dnU = null;
    private FrameLayout dnZ = null;
    private TbImageView doa = null;
    private TbImageView dob = null;
    private BdTypeRecyclerView dod = null;
    private com.baidu.tbadk.core.dialog.b doh = null;
    private NoNetworkView.a dkf = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener doj = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dod != null && k.this.dod.getAdapter() != null) {
                k.this.dod.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dom = true;
    private boolean mHasMore = true;
    private boolean doo = false;
    private int dnI = 0;
    private int bua = 0;
    private View dox = null;
    private View doy = null;
    private boolean cmI = false;
    private boolean doB = true;
    private boolean doG = true;
    private int doH = -1;
    private int doI = -1;
    private AppBarLayout.OnOffsetChangedListener doN = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.doI != i && Math.abs(i) >= 0 && k.this.ava() != -1) {
                if (Math.abs(i) >= k.this.ava()) {
                    if (k.this.doG) {
                        k.this.doG = false;
                        k.this.fB(k.this.doG);
                    }
                } else if (!k.this.doG) {
                    k.this.doG = true;
                    k.this.fB(k.this.doG);
                }
                int auU = k.this.auU() + k.this.auT() + k.this.auV();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - auU;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.doI - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.kv(Math.abs(auU - totalScrollRange2));
                        if (k.this.doy != null) {
                            k.this.doy.setVisibility(0);
                        }
                    } else if (k.this.doy != null) {
                        if (k.this.auS() != UtilHelper.getStatusBarHeight()) {
                            k.this.kv(0);
                        }
                        k.this.doy.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.cmI) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.avA();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.doI = i;
                }
            }
        }
    };
    private Runnable doO = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dnY != null) {
                k.this.dnZ.setVisibility(0);
                k.this.dob.setVisibility(0);
                k.this.doa.setVisibility(8);
            }
        }
    };
    private CustomMessageListener doQ = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.NV.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout auP() {
        return this.doz;
    }

    public View auQ() {
        return this.dox;
    }

    public View auR() {
        return this.doy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auS() {
        if (this.dox == null) {
            return 0;
        }
        return this.dox.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auT() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auU() {
        if (this.cSy == null || com.baidu.adp.lib.util.j.jE()) {
            return 0;
        }
        return this.cSy.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auV() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(int i) {
        View auQ = auQ();
        View auR = auR();
        if (UtilHelper.canUseStyleImmersiveSticky() && auQ != null && auR != null && auQ.getLayoutParams() != null && auR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = auQ.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            auQ.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = auR.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            auR.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dnR = null;
        this.doi = null;
        this.don = 0;
        this.dnR = frsFragment;
        this.doi = onClickListener;
        a(aVar, z);
        this.dov = new HashSet<>();
        this.don = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.doJ = fVar;
    }

    private boolean auW() {
        return this.doJ != null && this.doJ.aAz();
    }

    private void auX() {
        this.dnR.registerListener(this.doQ);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        auX();
        this.doA = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.dnR.getPageContext());
        }
        this.mPullView.setTag(this.dnR.getUniqueId());
        if (this.dnS == null) {
            this.dnS = (NoPressedRelativeLayout) this.dnR.mRootView.findViewById(d.g.frs);
        }
        if (this.dnU == null) {
            this.dnU = this.dnR.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.dnT == null) {
            this.dnT = (CoordinatorLayout) this.dnR.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.dol == null) {
            this.dol = this.dnR.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.doF == null) {
            this.doF = (CollapsingToolbarLayout) this.dnR.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.doE == null) {
            this.doE = (FrsHeaderViewContainer) this.dnR.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.doz == null) {
            this.doz = (ObservedChangeLinearLayout) this.dnR.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.doz.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.doF.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dnR.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dnR.auF()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dok == null) {
            this.dok = this.dnR.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b awC = aVar.awC();
            if (awC != null) {
                awC.aw(this.dok);
            }
        }
        if (this.dnV == null) {
            this.dnV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dnV.setOnClickListener(this.doi);
            this.mBackImageView = (ImageView) this.dnV.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dnW == null) {
            this.dnW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dnW.setOnClickListener(this.doi);
        }
        if (this.dnX == null) {
            this.dnX = new com.baidu.tieba.c.b(this.dnR.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dnX.getView(), (View.OnClickListener) null);
            this.dnX.getView().setOnClickListener(this.doi);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dnR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
        }
        if (this.byn == null) {
            this.byn = (BdSwipeRefreshLayout) this.dnR.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.byn.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.j(this.byn, d.C0140d.cp_bg_line_c);
        }
        if (this.dod == null) {
            this.dod = (BdTypeRecyclerView) this.dnR.mRootView.findViewById(d.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int doT = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.doT--;
                if (this.doT == 0) {
                    k.this.dod.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.doT++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dod.setItemAnimator(defaultItemAnimator);
        this.dod.setLayoutManager(new LinearLayoutManager(this.dod.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.dod.setScrollable(this.dnR);
        this.dod.setFadingEdgeLength(0);
        this.dod.setOverScrollMode(2);
        this.dnS.setBottomOrderView(this.dod);
        this.dod.setOnTouchListener(this.dnR.aWF);
        this.dod.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dow != null) {
                    k.this.dow.aT(view);
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
        if (this.bvA == null) {
            this.bvA = new PbListView(this.dnR.getPageContext().getPageActivity());
            this.bvA.getView();
        }
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.setHeight(com.baidu.adp.lib.util.l.f(this.dnR.getActivity(), d.e.tbds182));
        this.bvA.Au();
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.setTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_cont_d));
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.dod.setOnSrollToBottomListener(this.dnR);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dnR.auC();
                if (k.this.dnR != null && k.this.NV != null) {
                    k.this.dnR.auH();
                    k.this.NV.setExpanded(true);
                    if (k.this.dow != null) {
                        k.this.dow.b(k.this.dnI, k.this.bua, false, true);
                    }
                }
            }
        });
        boolean zy = com.baidu.tbadk.core.util.ar.zw().zy();
        if (this.doe == null) {
            this.doe = aVar.a(this.dnR, this.dod, zy);
        }
        cp(false);
        if (!z) {
            if (this.cSy == null) {
                this.cSy = new NoNetworkView(this.dnR.getActivity());
                this.cSy.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.doz.addView(this.cSy);
            }
            if (com.baidu.adp.lib.util.j.js()) {
                this.cSy.setVisibility(8);
            } else {
                this.cSy.setVisibility(0);
            }
            this.cSy.onChangeSkinType(this.dnR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        avh();
        if (this.doq == null) {
            this.doq = aVar.c(this.dnR, this.dnS);
        }
        if (this.dor == null) {
            this.dor = aVar.b(this.dnR, this.dnS);
            fE(true);
        }
        if (this.dox == null) {
            this.dox = this.dnR.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.doy == null) {
            this.doy = this.dnR.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.dow == null) {
            this.dow = new com.baidu.tieba.play.m(this.dnR.getPageContext(), this.dod);
        }
        this.dow.setUniqueId(this.dnR.getUniqueId());
        this.doL = (NavigationBarCoverTip) this.dnR.mRootView.findViewById(d.g.navigation_cover_tip);
        if (this.dos == null) {
            this.dos = new com.baidu.tieba.frs.vc.i(this.dnR, this.doL);
        }
        if (this.NV == null) {
            this.NV = (AppBarLayout) this.dnR.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.NV.addOnOffsetChangedListener(this.doN);
            this.doG = true;
            this.doH = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.NV.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.doD = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.doK = (FrsMultiDelBottomMenuView) this.dnR.mRootView.findViewById(d.g.frs_multi_delete_menu_view);
        this.doK.setPageContext(this.dnR.getPageContext());
        this.dof = (FloatingAnimationView) this.dnR.mRootView.findViewById(d.g.redpacket_view);
        this.dof.setPageId(this.dnR.getUniqueId());
        this.dog = new com.baidu.tieba.c.c(this.dnR.aiy(), this.dof, 2);
    }

    public void fA(boolean z) {
        if (z && this.dog != null) {
            this.dog.akH();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dog != null) {
            this.dog.a(mVar);
        }
    }

    private void auY() {
        ViewGroup.LayoutParams layoutParams;
        this.cmI = auW();
        if (this.doE != null && (layoutParams = this.doE.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cmI) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds88) + auT(), 0, 0);
            }
            this.doE.requestLayout();
        }
    }

    public void auZ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.doz != null) {
            auY();
            if (this.cmI) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dox != null) {
                    this.dox.setAlpha(1.0f);
                }
                if (this.doy != null) {
                    this.doy.setAlpha(1.0f);
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
    public void fB(boolean z) {
        if (z && this.dnR != null && this.dnR.auj() != null) {
            this.dnR.auj().aAD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ava() {
        int i;
        if (this.NV == null) {
            return this.doH;
        }
        if (this.doH != -1) {
            return this.doH;
        }
        int childCount = this.NV.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.NV.getChildAt(childCount);
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
        this.doH = Math.max(0, this.NV.getTotalScrollRange() - Math.abs(i2));
        return this.doH;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dop != null && this.dop.getLayoutParams() != null) {
            this.dop.getLayoutParams().height = i;
            this.dop.setLayoutParams(this.dop.getLayoutParams());
        }
    }

    public void mu(String str) {
        if (this.dos != null) {
            this.dos.mu(str);
        }
    }

    public View avb() {
        return this.dop;
    }

    public com.baidu.tieba.play.m avc() {
        return this.dow;
    }

    public com.baidu.tieba.frs.entelechy.b.c avd() {
        return this.dor;
    }

    public void fC(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.w.z(this.dnR.auD().buI());
        if (this.doq != null) {
            this.doq.fC(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d ave() {
        return this.doq;
    }

    public void w(boolean z, boolean z2) {
        if (this.doB && this.dor != null) {
            this.dor.w(z, z2);
        }
    }

    public void fD(boolean z) {
        this.doB = z;
        if (!this.doB && this.dor != null) {
            this.dor.w(false, false);
        }
    }

    public void avf() {
        if (this.doB && this.dor != null) {
            this.dor.w(false, false);
        }
        this.dnW.setVisibility(8);
        fC(false);
        this.dod.setVisibility(8);
        this.doE.setVisibility(8);
    }

    public void avg() {
        if (this.doB && this.dor != null) {
            this.dor.w(true, false);
        }
        this.dnW.setVisibility(0);
        fC(this.dnR.auK());
        this.dod.setVisibility(0);
        this.doE.setVisibility(0);
    }

    public void fE(boolean z) {
        if (this.dor != null) {
            this.dor.ga(z);
        }
    }

    private void avh() {
        if (this.dot == null) {
            this.dot = (GifView) this.dnR.mRootView.findViewById(d.g.gif_real_time);
            this.dou = (TbImageView) this.dnR.mRootView.findViewById(d.g.tbimg_real_time);
            this.dou.setPageId(this.dnR.getUniqueId());
            this.dot.setLayerType(1, null);
            this.dou.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View avi() {
        return this.dnV;
    }

    public void h(NoNetworkView.a aVar) {
        this.dkf = aVar;
        if (this.cSy != null) {
            this.cSy.a(this.dkf);
        }
    }

    public void cp(boolean z) {
        this.dnQ = z;
        if (z) {
            if (this.dor != null) {
                this.dor.axl();
                return;
            }
            return;
        }
        this.dod.getAdapter().notifyDataSetChanged();
        if (this.dor != null) {
            this.dor.axm();
        }
    }

    public void fF(boolean z) {
        if (this.dor != null) {
            if (z) {
                w(false, true);
            } else {
                w(false, false);
            }
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(g.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(g.a aVar) {
        this.mPullView.a(aVar);
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dod.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.doe.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.doe.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dow != null) {
            this.dow.destroy();
        }
        if (this.dos != null) {
            this.dos.onDestory();
        }
        if (this.doK != null) {
            this.doK.setPageContext(null);
        }
        this.doe.onDestory();
        this.dod.setOnSrollToBottomListener(null);
        this.dod.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.doO);
        if (this.cUk != null) {
            this.cUk.onDestroy();
        }
        this.dov.clear();
        if (this.doq != null) {
            this.doq.axn();
        }
        if (this.doC != null) {
            this.doC.aws();
        }
        if (this.dog != null) {
            this.dog.onDestroy();
        }
        if (this.doL != null) {
            this.doL.onDestroy();
        }
        if (this.doK != null) {
            this.doK.onDestroy();
        }
    }

    public boolean avj() {
        if (this.NV == null || this.doD == null || !this.doD.isSticky()) {
            return this.doq != null && this.doq.avj();
        }
        if (this.dod != null) {
            this.dod.setSelection(0);
        }
        this.doD.expandedAppBarLayout(this.NV);
        return true;
    }

    public boolean auE() {
        return this.dnQ;
    }

    public void agN() {
        this.dod.setVisibility(0);
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
            com.baidu.tbadk.core.i.te().cZ(str);
        }
    }

    public void avk() {
        if (this.doe != null) {
            this.doe.notifyDataSetChanged();
        }
    }

    public void akd() {
        if (this.doe instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.doe).akd();
        }
    }

    private void avl() {
        if (this.doh == null && this.dnR.getPageContext() != null) {
            String[] strArr = {this.dnR.getPageContext().getPageActivity().getString(d.j.take_photo), this.dnR.getPageContext().getPageActivity().getString(d.j.album)};
            this.doh = new com.baidu.tbadk.core.dialog.b(this.dnR.getPageContext().getPageActivity());
            this.doh.dC(this.dnR.getPageContext().getPageActivity().getString(d.j.operation));
            this.doh.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dnR.takePhoto();
                    } else if (i == 1 && k.this.dnR.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.r(k.this.dnR.getPageContext().getPageActivity());
                    }
                }
            });
            this.doh.d(this.dnR.getPageContext());
        }
    }

    public void avm() {
        avl();
        if (this.doh != null) {
            this.doh.xi();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.w.z(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dnR != null && this.dnR.auh() != null && this.dnR.auh().azD() == 0) {
                mVar.kE(this.dnR.auh().azL());
            }
        }
        if (com.baidu.tbadk.core.util.w.y(arrayList) > 0) {
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
        this.doe.b(arrayList, lVar);
        if (this.dow != null && this.dnI != 0) {
            this.dow.b(this.dnI, this.bua, this.doo, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dod;
    }

    public void avn() {
        this.doe.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dnR.getPageContext(), 1);
        aVar.a(this.dod);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dnR.getForumName());
        hashMap.put("forum_id", this.dnR.getForumId());
        aVar.setParams(hashMap);
        aVar.K(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.doq != null) {
            this.doq.axo();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        kw(TbadkCoreApplication.getInst().getSkinType());
        avA();
        if (this.doq != null) {
            this.doq.axp();
        }
    }

    public void release() {
        if (this.cSy != null && this.dkf != null) {
            this.cSy.b(this.dkf);
        }
    }

    public ImageView avo() {
        return this.dnW;
    }

    public View avp() {
        if (this.dnX != null) {
            return this.dnX.getView();
        }
        return null;
    }

    public void o(int i, boolean z) {
        if (this.dnX != null) {
            this.dnX.f(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dnR, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dnR.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dou != null) {
            this.dou.invalidate();
        }
        if (this.doe != null) {
            this.doe.axa();
            this.doe.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dnR.getPageContext(), this.dnS);
        kw(i);
        if (this.cSy != null) {
            this.cSy.onChangeSkinType(this.dnR.getPageContext(), i);
        }
        if (this.bvA != null) {
            this.bvA.setTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0140d.cp_cont_d));
            this.bvA.dC(i);
        }
        avA();
        if (this.dor != null) {
            this.dor.onChangeSkinType(i);
        }
        if (this.doq != null) {
            this.doq.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.doK != null) {
            this.doK.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.j(this.byn, d.C0140d.cp_bg_line_e);
    }

    private void kw(int i) {
        if (this.dnR != null) {
            Pair<Integer, Integer> pair = this.dnR.dmv;
            if (pair != null) {
                a(i, pair);
            } else {
                kx(i);
            }
        }
    }

    private void kx(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.am.cU(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dnR.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.am.e(this.dok, d.C0140d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
            int i2 = d.C0140d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.aq.zv().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.aq.zv().c(this.dnW, d.f.icon_topbar_search_n_svg, i2);
            if (this.dnX != null) {
                this.dnX.jm(i2);
                this.dnX.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dox, i);
        UtilHelper.setStatusBarBackground(this.doy, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dnR.getPageContext(), i);
                com.baidu.tbadk.core.util.am.e(this.dok, d.C0140d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
                com.baidu.tbadk.core.util.am.c(this.mNavigationBar.mCenterText, d.C0140d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dox, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.doy, pair);
            int i2 = d.C0140d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.aq.zv().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.aq.zv().c(this.dnW, d.f.icon_topbar_search_n_svg, i2);
            if (this.dnX != null) {
                this.dnX.jm(i2);
                this.dnX.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dod != null) {
            this.dod.setSelection(0);
        }
        if (this.NV != null) {
            this.NV.setExpanded(true);
        }
        if (this.byn != null && this.byn.isEnabled()) {
            this.byn.setRefreshing(true);
        }
    }

    public void fG(boolean z) {
        if (z) {
            this.byn.setRefreshing(false);
        } else {
            this.byn.nZ();
        }
    }

    public void fH(boolean z) {
        this.byn.setEnabled(z);
    }

    public void fI(boolean z) {
        this.dom = z;
        if (this.dom) {
            this.bvA.setText(this.dnR.getResources().getString(d.j.load_more));
            if (this.dod.getChildAt(this.dod.getChildCount() - 1) == this.bvA.getView()) {
                this.bvA.Ax();
                this.dnR.Tn();
                return;
            }
            this.bvA.Ay();
            return;
        }
        this.bvA.setText(this.dnR.getResources().getString(d.j.load_more_must_after_delete));
        this.bvA.Ay();
    }

    public boolean avq() {
        if (this.dom) {
            return false;
        }
        this.bvA.setText(this.dnR.getResources().getString(d.j.load_more_must_after_delete));
        this.bvA.Ay();
        return true;
    }

    public boolean avr() {
        return this.dnY != null && this.dob.getVisibility() == 0;
    }

    public void avs() {
        if (this.dnY != null) {
            this.dnZ.setVisibility(0);
            this.dob.setVisibility(8);
            this.doa.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.doO, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bi biVar) {
        if (this.dnY == null) {
            this.dnY = (ViewStub) this.dnR.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.dnY.setVisibility(0);
            this.dnZ = (FrameLayout) this.dnR.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.doa = (TbImageView) this.dnR.mRootView.findViewById(d.g.game_activity_egg);
            this.dob = (TbImageView) this.dnR.mRootView.findViewById(d.g.game_activity_egg_s);
            this.doa.setPageId(this.dnR.getUniqueId());
            this.dob.setPageId(this.dnR.getUniqueId());
            this.doa.setDefaultBgResource(d.C0140d.common_color_10022);
            this.doa.setDefaultResource(0);
            this.dob.setDefaultBgResource(d.C0140d.common_color_10022);
            this.dob.setDefaultResource(0);
            this.dnZ.setOnClickListener(this.doi);
        }
        this.dnZ.setVisibility(0);
        String wV = biVar.wV();
        String wW = biVar.wW();
        this.doa.startLoad(wV, 10, false);
        this.dob.startLoad(wW, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.doO, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void avt() {
        if (this.dnY != null) {
            this.dnZ.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q avu() {
        return this.doe;
    }

    public ViewGroup aed() {
        return this.dnS;
    }

    public View avv() {
        return this.dol;
    }

    public void ky(int i) {
        if (this.dnU != null) {
            this.dnU.setVisibility(i);
        }
    }

    public void avw() {
        if (com.baidu.tbadk.l.m.KF().KG()) {
            int lastVisiblePosition = this.dod.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dod.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.doZ != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.doZ.getPerfLog();
                        perfLog.fm(1000);
                        perfLog.aTK = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.doZ.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.doZ.startLogPerf();
                    }
                    if (oVar.doY != null && (oVar.doY instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.doY;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fm(1000);
                                perfLog2.aTK = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar Vf() {
        return this.mNavigationBar;
    }

    public void Ul() {
        this.mHasMore = true;
        this.dod.setNextPage(this.bvA);
        if (this.don > 0) {
            this.bvA.dD(this.don);
        }
        this.bvA.setOnClickListener(null);
        this.bvA.Ax();
    }

    public void Um() {
        this.mHasMore = false;
        this.dod.setNextPage(this.bvA);
        if (this.don > 0) {
            this.bvA.dD(this.don);
        }
        this.bvA.setOnClickListener(null);
        this.bvA.Ay();
        this.bvA.setText(this.dnR.getResources().getString(d.j.list_has_no_more));
    }

    public void avx() {
        this.mHasMore = true;
        this.dod.setNextPage(this.bvA);
        this.bvA.setOnClickListener(this.doi);
        if (this.don > 0) {
            this.bvA.dD(this.don);
        }
        this.bvA.Ay();
        this.bvA.setText(this.dnR.getResources().getString(d.j.list_click_load_more));
    }

    public View avy() {
        if (this.bvA == null) {
            return null;
        }
        return this.bvA.getView();
    }

    public void kz(int i) {
        if (this.doK != null) {
            this.doK.setVisibility(i);
        }
    }

    public void kA(int i) {
        if (this.doK != null) {
            this.doK.setSelectNumber(i);
        }
    }

    public void Un() {
        this.mHasMore = false;
        this.dod.setNextPage(null);
    }

    public boolean ajU() {
        return this.bvA.getView().getParent() != null && this.mHasMore;
    }

    public void kB(int i) {
        this.don = i;
    }

    public void kC(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cUk == null) {
                    this.cUk = new CommonTipView(this.dnR.getActivity());
                }
                this.cUk.setText(d.j.frs_login_tip);
                this.cUk.show((FrameLayout) avv(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fJ(boolean z) {
        if (this.dow != null) {
            if (z) {
                this.dow.iw(false);
                this.dow.aSq();
                return;
            }
            this.dow.iw(true);
            this.dow.b(this.dnI, this.bua, this.doo, true);
        }
    }

    public void aB(int i, int i2) {
        if (this.dow != null) {
            this.dow.a(i, i2, this.doo, 1);
        }
    }

    public void aC(int i, int i2) {
        this.dnI = i;
        this.bua = i2;
    }

    public void fK(boolean z) {
        this.doo = z;
    }

    private void avz() {
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
            if (this.dox != null) {
                this.dox.setAlpha(alpha);
            }
            if (this.doy != null) {
                this.doy.setAlpha(alpha);
            }
            if (this.dok != null) {
                this.dok.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avA() {
        if (this.dnR.dmv == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cmI) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.am.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.am.a(this.dnW, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.dnX != null) {
                    com.baidu.tbadk.core.util.am.a(this.dnX.akE(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.am.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.am.a(this.dnW, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.dnX != null) {
                    com.baidu.tbadk.core.util.am.a(this.dnX.akE(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            avz();
        }
    }

    public void fL(boolean z) {
    }

    public void kD(int i) {
        if (this.dod != null && this.dod.getChildCount() >= 0) {
            if (this.dod.getFirstVisiblePosition() > 8) {
                this.dod.scrollToPosition(8);
            }
            this.dod.smoothScrollToPosition(i);
        }
    }

    public void avB() {
        a(this.doA, this.dnR.auF());
        if (this.doe != null) {
            this.doe.axe();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.doC == null) {
                this.doC = new com.baidu.tieba.video.f(this.dnR.getActivity(), this.dnS);
            }
            this.doC.h(postWriteCallBackData);
        }
    }

    public void avC() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.doP && this.dnR.getActivity() != null && this.dnR.getPageContext() != null) {
            View view = null;
            if (this.dod != null && (headerViewsCount = this.dod.getHeaderViewsCount()) < this.dod.getChildCount()) {
                view = this.dod.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).X(0).E(true).F(false).D(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.dnR.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hw() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hx() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.f(k.this.dnR.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.f(k.this.dnR.getActivity(), d.e.ds6);
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
                final com.baidu.adp.lib.guide.c hy = dVar.hy();
                hy.B(false);
                hy.k(this.dnR.getActivity());
                com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hy != null) {
                            hy.dismiss();
                        }
                    }
                }, 4000L);
                this.doP = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.doK != null) {
            this.doK.setDeleteCallback(aVar);
        }
    }

    public void avD() {
        if (this.doK != null) {
            this.doK.avD();
        }
    }

    public void Pv() {
        if (this.doK != null) {
            this.doK.Pv();
        }
    }

    public void S(String str, int i) {
        if (this.doM == null) {
            this.doM = new TextView(this.dnR.getActivity());
            this.doM.setGravity(19);
            this.doM.setPadding(com.baidu.adp.lib.util.l.f(this.dnR.getActivity(), d.e.ds34), 0, com.baidu.adp.lib.util.l.f(this.dnR.getActivity(), d.e.ds34), 0);
            this.doM.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.dnR.getActivity(), d.e.tbds112)));
            this.doM.setTextSize(0, com.baidu.adp.lib.util.l.f(this.dnR.getActivity(), d.e.fontsize30));
            this.doM.setMaxLines(2);
            this.doM.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.doM.setTextColor(ContextCompat.getColor(this.dnR.getActivity(), d.C0140d.cp_cont_i));
        }
        this.doL.setBackgroundColor(i);
        this.doM.setText(str);
        this.doL.a(this.dnR.getActivity(), this.doM, 5000);
    }
}
