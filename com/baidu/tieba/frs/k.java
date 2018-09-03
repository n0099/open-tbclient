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
import com.baidu.tieba.f;
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
    private PbListView bvC;
    private BdSwipeRefreshLayout byp;
    private NoNetworkView cSv;
    private CommonTipView cUg;
    private FrsFragment dnP;
    private View dnT;
    private ImageView dnU;
    private com.baidu.tieba.c.b dnV;
    private ViewStub dnW;
    private com.baidu.tieba.video.f doA;
    private AppBarLayoutStickyBehavior doB;
    private FrsHeaderViewContainer doC;
    private CollapsingToolbarLayout doD;
    private com.baidu.tieba.frs.vc.f doH;
    private FrsMultiDelBottomMenuView doI;
    private NavigationBarCoverTip doJ;
    private TextView doK;
    private boolean doN;
    private com.baidu.tieba.frs.entelechy.a.q dob;
    private FloatingAnimationView dod;
    private com.baidu.tieba.c.c doe;
    private View.OnClickListener dog;
    private View doi;
    private View doj;
    private int dol;
    private View don;
    private com.baidu.tieba.frs.entelechy.b.d doo;
    private com.baidu.tieba.frs.entelechy.b.c dop;
    private com.baidu.tieba.frs.vc.i doq;
    private GifView dor;
    private TbImageView dos;
    private HashSet<String> dot;
    private com.baidu.tieba.play.m dou;
    private ObservedChangeLinearLayout dox;
    private com.baidu.tieba.frs.entelechy.b.a doy;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean dnO = false;
    private NoPressedRelativeLayout dnQ = null;
    private CoordinatorLayout dnR = null;
    private View dnS = null;
    private FrameLayout dnX = null;
    private TbImageView dnY = null;
    private TbImageView dnZ = null;
    private BdTypeRecyclerView doa = null;
    private com.baidu.tbadk.core.dialog.b dof = null;
    private NoNetworkView.a dkd = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener doh = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.doa != null && k.this.doa.getAdapter() != null) {
                k.this.doa.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dok = true;
    private boolean mHasMore = true;
    private boolean dom = false;
    private int dnG = 0;
    private int buc = 0;
    private View dov = null;
    private View dow = null;
    private boolean cmF = false;
    private boolean doz = true;
    private boolean doE = true;
    private int doF = -1;
    private int doG = -1;
    private AppBarLayout.OnOffsetChangedListener doL = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.doG != i && Math.abs(i) >= 0 && k.this.auZ() != -1) {
                if (Math.abs(i) >= k.this.auZ()) {
                    if (k.this.doE) {
                        k.this.doE = false;
                        k.this.fB(k.this.doE);
                    }
                } else if (!k.this.doE) {
                    k.this.doE = true;
                    k.this.fB(k.this.doE);
                }
                int auT = k.this.auT() + k.this.auS() + k.this.auU();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - auT;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.doG - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.ku(Math.abs(auT - totalScrollRange2));
                        if (k.this.dow != null) {
                            k.this.dow.setVisibility(0);
                        }
                    } else if (k.this.dow != null) {
                        if (k.this.auR() != UtilHelper.getStatusBarHeight()) {
                            k.this.ku(0);
                        }
                        k.this.dow.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.cmF) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.avz();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.doG = i;
                }
            }
        }
    };
    private Runnable doM = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dnW != null) {
                k.this.dnX.setVisibility(0);
                k.this.dnZ.setVisibility(0);
                k.this.dnY.setVisibility(8);
            }
        }
    };
    private CustomMessageListener doO = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.NV.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout auO() {
        return this.dox;
    }

    public View auP() {
        return this.dov;
    }

    public View auQ() {
        return this.dow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auR() {
        if (this.dov == null) {
            return 0;
        }
        return this.dov.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auS() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auT() {
        if (this.cSv == null || com.baidu.adp.lib.util.j.jE()) {
            return 0;
        }
        return this.cSv.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auU() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ku(int i) {
        View auP = auP();
        View auQ = auQ();
        if (UtilHelper.canUseStyleImmersiveSticky() && auP != null && auQ != null && auP.getLayoutParams() != null && auQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = auP.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            auP.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = auQ.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            auQ.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dnP = null;
        this.dog = null;
        this.dol = 0;
        this.dnP = frsFragment;
        this.dog = onClickListener;
        a(aVar, z);
        this.dot = new HashSet<>();
        this.dol = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.doH = fVar;
    }

    private boolean auV() {
        return this.doH != null && this.doH.aAw();
    }

    private void auW() {
        this.dnP.registerListener(this.doO);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        auW();
        this.doy = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.dnP.getPageContext());
        }
        this.mPullView.setTag(this.dnP.getUniqueId());
        if (this.dnQ == null) {
            this.dnQ = (NoPressedRelativeLayout) this.dnP.mRootView.findViewById(f.g.frs);
        }
        if (this.dnS == null) {
            this.dnS = this.dnP.mRootView.findViewById(f.g.frs_content_container);
        }
        if (this.dnR == null) {
            this.dnR = (CoordinatorLayout) this.dnP.mRootView.findViewById(f.g.frs_nested_scroll_layout);
        }
        if (this.doj == null) {
            this.doj = this.dnP.mRootView.findViewById(f.g.frs_list_content);
        }
        if (this.doD == null) {
            this.doD = (CollapsingToolbarLayout) this.dnP.mRootView.findViewById(f.g.frs_collapse_layout);
        }
        if (this.doC == null) {
            this.doC = (FrsHeaderViewContainer) this.dnP.mRootView.findViewById(f.g.header_view_container);
        }
        if (this.dox == null) {
            this.dox = (ObservedChangeLinearLayout) this.dnP.mRootView.findViewById(f.g.navigation_bar_wrapperLayout);
            this.dox.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.doD.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dnP.mRootView.findViewById(f.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dnP.auE()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.doi == null) {
            this.doi = this.dnP.mRootView.findViewById(f.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b awB = aVar.awB();
            if (awB != null) {
                awB.aw(this.doi);
            }
        }
        if (this.dnT == null) {
            this.dnT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dnT.setOnClickListener(this.dog);
            this.mBackImageView = (ImageView) this.dnT.findViewById(f.g.widget_navi_back_button);
        }
        if (this.dnU == null) {
            this.dnU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dnU.setOnClickListener(this.dog);
        }
        if (this.dnV == null) {
            this.dnV = new com.baidu.tieba.c.b(this.dnP.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dnV.getView(), (View.OnClickListener) null);
            this.dnV.getView().setOnClickListener(this.dog);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dnP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), f.d.cp_bg_line_b);
        }
        if (this.byp == null) {
            this.byp = (BdSwipeRefreshLayout) this.dnP.mRootView.findViewById(f.g.frs_pull_refresh_layout);
            this.byp.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.j(this.byp, f.d.cp_bg_line_c);
        }
        if (this.doa == null) {
            this.doa = (BdTypeRecyclerView) this.dnP.mRootView.findViewById(f.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int doR = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.doR--;
                if (this.doR == 0) {
                    k.this.doa.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.doR++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.doa.setItemAnimator(defaultItemAnimator);
        this.doa.setLayoutManager(new LinearLayoutManager(this.doa.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        this.doa.setScrollable(this.dnP);
        this.doa.setFadingEdgeLength(0);
        this.doa.setOverScrollMode(2);
        this.dnQ.setBottomOrderView(this.doa);
        this.doa.setOnTouchListener(this.dnP.aWF);
        this.doa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dou != null) {
                    k.this.dou.aT(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(f.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(f.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        });
        if (this.bvC == null) {
            this.bvC = new PbListView(this.dnP.getPageContext().getPageActivity());
            this.bvC.getView();
        }
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.setHeight(com.baidu.adp.lib.util.l.f(this.dnP.getActivity(), f.e.tbds182));
        this.bvC.As();
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.setTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_cont_d));
        this.bvC.dz(f.d.cp_cont_e);
        this.doa.setOnSrollToBottomListener(this.dnP);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dnP.auB();
                if (k.this.dnP != null && k.this.NV != null) {
                    k.this.dnP.auG();
                    k.this.NV.setExpanded(true);
                    if (k.this.dou != null) {
                        k.this.dou.b(k.this.dnG, k.this.buc, false, true);
                    }
                }
            }
        });
        boolean zw = com.baidu.tbadk.core.util.ar.zu().zw();
        if (this.dob == null) {
            this.dob = aVar.a(this.dnP, this.doa, zw);
        }
        cq(false);
        if (!z) {
            if (this.cSv == null) {
                this.cSv = new NoNetworkView(this.dnP.getActivity());
                this.cSv.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dox.addView(this.cSv);
            }
            if (com.baidu.adp.lib.util.j.js()) {
                this.cSv.setVisibility(8);
            } else {
                this.cSv.setVisibility(0);
            }
            this.cSv.onChangeSkinType(this.dnP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        avg();
        if (this.doo == null) {
            this.doo = aVar.c(this.dnP, this.dnQ);
        }
        if (this.dop == null) {
            this.dop = aVar.b(this.dnP, this.dnQ);
            fE(true);
        }
        if (this.dov == null) {
            this.dov = this.dnP.mRootView.findViewById(f.g.statebar_view);
        }
        if (this.dow == null) {
            this.dow = this.dnP.mRootView.findViewById(f.g.statebar_view_holder);
        }
        if (this.dou == null) {
            this.dou = new com.baidu.tieba.play.m(this.dnP.getPageContext(), this.doa);
        }
        this.dou.setUniqueId(this.dnP.getUniqueId());
        this.doJ = (NavigationBarCoverTip) this.dnP.mRootView.findViewById(f.g.navigation_cover_tip);
        if (this.doq == null) {
            this.doq = new com.baidu.tieba.frs.vc.i(this.dnP, this.doJ);
        }
        if (this.NV == null) {
            this.NV = (AppBarLayout) this.dnP.mRootView.findViewById(f.g.frs_app_bar_layout);
            this.NV.addOnOffsetChangedListener(this.doL);
            this.doE = true;
            this.doF = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.NV.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.doB = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.doI = (FrsMultiDelBottomMenuView) this.dnP.mRootView.findViewById(f.g.frs_multi_delete_menu_view);
        this.doI.setPageContext(this.dnP.getPageContext());
        this.dod = (FloatingAnimationView) this.dnP.mRootView.findViewById(f.g.redpacket_view);
        this.dod.setPageId(this.dnP.getUniqueId());
        this.doe = new com.baidu.tieba.c.c(this.dnP.aiB(), this.dod, 2);
    }

    public void fA(boolean z) {
        if (z && this.doe != null) {
            this.doe.akJ();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.doe != null) {
            this.doe.a(mVar);
        }
    }

    private void auX() {
        ViewGroup.LayoutParams layoutParams;
        this.cmF = auV();
        if (this.doC != null && (layoutParams = this.doC.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cmF) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds88) + auS(), 0, 0);
            }
            this.doC.requestLayout();
        }
    }

    public void auY() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dox != null) {
            auX();
            if (this.cmF) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dov != null) {
                    this.dov.setAlpha(1.0f);
                }
                if (this.dow != null) {
                    this.dow.setAlpha(1.0f);
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
        if (z && this.dnP != null && this.dnP.aui() != null) {
            this.dnP.aui().aAA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auZ() {
        int i;
        if (this.NV == null) {
            return this.doF;
        }
        if (this.doF != -1) {
            return this.doF;
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
        this.doF = Math.max(0, this.NV.getTotalScrollRange() - Math.abs(i2));
        return this.doF;
    }

    public void setHeaderViewHeight(int i) {
        if (this.don != null && this.don.getLayoutParams() != null) {
            this.don.getLayoutParams().height = i;
            this.don.setLayoutParams(this.don.getLayoutParams());
        }
    }

    public void mw(String str) {
        if (this.doq != null) {
            this.doq.mw(str);
        }
    }

    public View ava() {
        return this.don;
    }

    public com.baidu.tieba.play.m avb() {
        return this.dou;
    }

    public com.baidu.tieba.frs.entelechy.b.c avc() {
        return this.dop;
    }

    public void fC(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.w.z(this.dnP.auC().buJ());
        if (this.doo != null) {
            this.doo.fC(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d avd() {
        return this.doo;
    }

    public void w(boolean z, boolean z2) {
        if (this.doz && this.dop != null) {
            this.dop.w(z, z2);
        }
    }

    public void fD(boolean z) {
        this.doz = z;
        if (!this.doz && this.dop != null) {
            this.dop.w(false, false);
        }
    }

    public void ave() {
        if (this.doz && this.dop != null) {
            this.dop.w(false, false);
        }
        this.dnU.setVisibility(8);
        fC(false);
        this.doa.setVisibility(8);
        this.doC.setVisibility(8);
    }

    public void avf() {
        if (this.doz && this.dop != null) {
            this.dop.w(true, false);
        }
        this.dnU.setVisibility(0);
        fC(this.dnP.auJ());
        this.doa.setVisibility(0);
        this.doC.setVisibility(0);
    }

    public void fE(boolean z) {
        if (this.dop != null) {
            this.dop.ga(z);
        }
    }

    private void avg() {
        if (this.dor == null) {
            this.dor = (GifView) this.dnP.mRootView.findViewById(f.g.gif_real_time);
            this.dos = (TbImageView) this.dnP.mRootView.findViewById(f.g.tbimg_real_time);
            this.dos.setPageId(this.dnP.getUniqueId());
            this.dor.setLayerType(1, null);
            this.dos.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View avh() {
        return this.dnT;
    }

    public void h(NoNetworkView.a aVar) {
        this.dkd = aVar;
        if (this.cSv != null) {
            this.cSv.a(this.dkd);
        }
    }

    public void cq(boolean z) {
        this.dnO = z;
        if (z) {
            if (this.dop != null) {
                this.dop.axk();
                return;
            }
            return;
        }
        this.doa.getAdapter().notifyDataSetChanged();
        if (this.dop != null) {
            this.dop.axl();
        }
    }

    public void fF(boolean z) {
        if (this.dop != null) {
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
        this.doa.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dob.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dob.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dou != null) {
            this.dou.destroy();
        }
        if (this.doq != null) {
            this.doq.onDestory();
        }
        if (this.doI != null) {
            this.doI.setPageContext(null);
        }
        this.dob.onDestory();
        this.doa.setOnSrollToBottomListener(null);
        this.doa.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.doM);
        if (this.cUg != null) {
            this.cUg.onDestroy();
        }
        this.dot.clear();
        if (this.doo != null) {
            this.doo.axm();
        }
        if (this.doA != null) {
            this.doA.awr();
        }
        if (this.doe != null) {
            this.doe.onDestroy();
        }
        if (this.doJ != null) {
            this.doJ.onDestroy();
        }
        if (this.doI != null) {
            this.doI.onDestroy();
        }
    }

    public boolean avi() {
        if (this.NV == null || this.doB == null || !this.doB.isSticky()) {
            return this.doo != null && this.doo.avi();
        }
        if (this.doa != null) {
            this.doa.setSelection(0);
        }
        this.doB.expandedAppBarLayout(this.NV);
        return true;
    }

    public boolean auD() {
        return this.dnO;
    }

    public void agP() {
        this.doa.setVisibility(0);
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
            com.baidu.tbadk.core.i.td().da(str);
        }
    }

    public void avj() {
        if (this.dob != null) {
            this.dob.notifyDataSetChanged();
        }
    }

    public void akf() {
        if (this.dob instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dob).akf();
        }
    }

    private void avk() {
        if (this.dof == null && this.dnP.getPageContext() != null) {
            String[] strArr = {this.dnP.getPageContext().getPageActivity().getString(f.j.take_photo), this.dnP.getPageContext().getPageActivity().getString(f.j.album)};
            this.dof = new com.baidu.tbadk.core.dialog.b(this.dnP.getPageContext().getPageActivity());
            this.dof.dC(this.dnP.getPageContext().getPageActivity().getString(f.j.operation));
            this.dof.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dnP.takePhoto();
                    } else if (i == 1 && k.this.dnP.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.r(k.this.dnP.getPageContext().getPageActivity());
                    }
                }
            });
            this.dof.d(this.dnP.getPageContext());
        }
    }

    public void avl() {
        avk();
        if (this.dof != null) {
            this.dof.xh();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.w.z(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dnP != null && this.dnP.aug() != null && this.dnP.aug().azA() == 0) {
                mVar.kD(this.dnP.aug().azI());
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
        this.dob.b(arrayList, lVar);
        if (this.dou != null && this.dnG != 0) {
            this.dou.b(this.dnG, this.buc, this.dom, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.doa;
    }

    public void avm() {
        this.dob.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dnP.getPageContext(), 1);
        aVar.a(this.doa);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dnP.getForumName());
        hashMap.put("forum_id", this.dnP.getForumId());
        aVar.setParams(hashMap);
        aVar.K(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.doo != null) {
            this.doo.axn();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        kv(TbadkCoreApplication.getInst().getSkinType());
        avz();
        if (this.doo != null) {
            this.doo.axo();
        }
    }

    public void release() {
        if (this.cSv != null && this.dkd != null) {
            this.cSv.b(this.dkd);
        }
    }

    public ImageView avn() {
        return this.dnU;
    }

    public View avo() {
        if (this.dnV != null) {
            return this.dnV.getView();
        }
        return null;
    }

    public void o(int i, boolean z) {
        if (this.dnV != null) {
            this.dnV.f(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dnP, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dnP.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dos != null) {
            this.dos.invalidate();
        }
        if (this.dob != null) {
            this.dob.awZ();
            this.dob.notifyDataSetChanged();
        }
        com.baidu.tbadk.o.a.a(this.dnP.getPageContext(), this.dnQ);
        kv(i);
        if (this.cSv != null) {
            this.cSv.onChangeSkinType(this.dnP.getPageContext(), i);
        }
        if (this.bvC != null) {
            this.bvC.setTextColor(com.baidu.tbadk.core.util.am.getColor(f.d.cp_cont_d));
            this.bvC.dB(i);
        }
        avz();
        if (this.dop != null) {
            this.dop.onChangeSkinType(i);
        }
        if (this.doo != null) {
            this.doo.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.doI != null) {
            this.doI.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.j(this.byp, f.d.cp_bg_line_e);
    }

    private void kv(int i) {
        if (this.dnP != null) {
            Pair<Integer, Integer> pair = this.dnP.dmt;
            if (pair != null) {
                a(i, pair);
            } else {
                kw(i);
            }
        }
    }

    private void kw(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.am.cU(f.C0146f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dnP.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.am.e(this.doi, f.d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), f.d.cp_bg_line_b);
            int i2 = f.d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.aq.zt().c(this.mBackImageView, f.C0146f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.aq.zt().c(this.dnU, f.C0146f.icon_topbar_search_n_svg, i2);
            if (this.dnV != null) {
                this.dnV.jl(i2);
                this.dnV.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dov, i);
        UtilHelper.setStatusBarBackground(this.dow, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dnP.getPageContext(), i);
                com.baidu.tbadk.core.util.am.e(this.doi, f.d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), f.d.cp_bg_line_b);
                com.baidu.tbadk.core.util.am.c(this.mNavigationBar.mCenterText, f.d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dov, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dow, pair);
            int i2 = f.d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.aq.zt().c(this.mBackImageView, f.C0146f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.aq.zt().c(this.dnU, f.C0146f.icon_topbar_search_n_svg, i2);
            if (this.dnV != null) {
                this.dnV.jl(i2);
                this.dnV.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.doa != null) {
            this.doa.setSelection(0);
        }
        if (this.NV != null) {
            this.NV.setExpanded(true);
        }
        if (this.byp != null && this.byp.isEnabled()) {
            this.byp.setRefreshing(true);
        }
    }

    public void fG(boolean z) {
        if (z) {
            this.byp.setRefreshing(false);
        } else {
            this.byp.nW();
        }
    }

    public void fH(boolean z) {
        this.byp.setEnabled(z);
    }

    public void fI(boolean z) {
        this.dok = z;
        if (this.dok) {
            this.bvC.setText(this.dnP.getResources().getString(f.j.load_more));
            if (this.doa.getChildAt(this.doa.getChildCount() - 1) == this.bvC.getView()) {
                this.bvC.Av();
                this.dnP.Tq();
                return;
            }
            this.bvC.Aw();
            return;
        }
        this.bvC.setText(this.dnP.getResources().getString(f.j.load_more_must_after_delete));
        this.bvC.Aw();
    }

    public boolean avp() {
        if (this.dok) {
            return false;
        }
        this.bvC.setText(this.dnP.getResources().getString(f.j.load_more_must_after_delete));
        this.bvC.Aw();
        return true;
    }

    public boolean avq() {
        return this.dnW != null && this.dnZ.getVisibility() == 0;
    }

    public void avr() {
        if (this.dnW != null) {
            this.dnX.setVisibility(0);
            this.dnZ.setVisibility(8);
            this.dnY.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.doM, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bi biVar) {
        if (this.dnW == null) {
            this.dnW = (ViewStub) this.dnP.mRootView.findViewById(f.g.yule_game_egg_view_stub);
            this.dnW.setVisibility(0);
            this.dnX = (FrameLayout) this.dnP.mRootView.findViewById(f.g.game_activity_egg_layout);
            this.dnY = (TbImageView) this.dnP.mRootView.findViewById(f.g.game_activity_egg);
            this.dnZ = (TbImageView) this.dnP.mRootView.findViewById(f.g.game_activity_egg_s);
            this.dnY.setPageId(this.dnP.getUniqueId());
            this.dnZ.setPageId(this.dnP.getUniqueId());
            this.dnY.setDefaultBgResource(f.d.common_color_10022);
            this.dnY.setDefaultResource(0);
            this.dnZ.setDefaultBgResource(f.d.common_color_10022);
            this.dnZ.setDefaultResource(0);
            this.dnX.setOnClickListener(this.dog);
        }
        this.dnX.setVisibility(0);
        String wU = biVar.wU();
        String wV = biVar.wV();
        this.dnY.startLoad(wU, 10, false);
        this.dnZ.startLoad(wV, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.doM, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void avs() {
        if (this.dnW != null) {
            this.dnX.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q avt() {
        return this.dob;
    }

    public ViewGroup aef() {
        return this.dnQ;
    }

    public View avu() {
        return this.doj;
    }

    public void kx(int i) {
        if (this.dnS != null) {
            this.dnS.setVisibility(i);
        }
    }

    public void avv() {
        if (com.baidu.tbadk.l.m.KJ().KK()) {
            int lastVisiblePosition = this.doa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.doa.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.doX != null) {
                        com.baidu.tbadk.l.h perfLog = oVar.doX.getPerfLog();
                        perfLog.fl(1000);
                        perfLog.aTK = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.doX.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.doX.startLogPerf();
                    }
                    if (oVar.doW != null && (oVar.doW instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.doW;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.l.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fl(1000);
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

    public NavigationBar Vj() {
        return this.mNavigationBar;
    }

    public void Uo() {
        this.mHasMore = true;
        this.doa.setNextPage(this.bvC);
        if (this.dol > 0) {
            this.bvC.dC(this.dol);
        }
        this.bvC.setOnClickListener(null);
        this.bvC.Av();
    }

    public void Up() {
        this.mHasMore = false;
        this.doa.setNextPage(this.bvC);
        if (this.dol > 0) {
            this.bvC.dC(this.dol);
        }
        this.bvC.setOnClickListener(null);
        this.bvC.Aw();
        this.bvC.setText(this.dnP.getResources().getString(f.j.list_has_no_more));
    }

    public void avw() {
        this.mHasMore = true;
        this.doa.setNextPage(this.bvC);
        this.bvC.setOnClickListener(this.dog);
        if (this.dol > 0) {
            this.bvC.dC(this.dol);
        }
        this.bvC.Aw();
        this.bvC.setText(this.dnP.getResources().getString(f.j.list_click_load_more));
    }

    public View avx() {
        if (this.bvC == null) {
            return null;
        }
        return this.bvC.getView();
    }

    public void ky(int i) {
        if (this.doI != null) {
            this.doI.setVisibility(i);
        }
    }

    public void kz(int i) {
        if (this.doI != null) {
            this.doI.setSelectNumber(i);
        }
    }

    public void Uq() {
        this.mHasMore = false;
        this.doa.setNextPage(null);
    }

    public boolean ajX() {
        return this.bvC.getView().getParent() != null && this.mHasMore;
    }

    public void kA(int i) {
        this.dol = i;
    }

    public void kB(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cUg == null) {
                    this.cUg = new CommonTipView(this.dnP.getActivity());
                }
                this.cUg.setText(f.j.frs_login_tip);
                this.cUg.show((FrameLayout) avu(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fJ(boolean z) {
        if (this.dou != null) {
            if (z) {
                this.dou.iw(false);
                this.dou.aSn();
                return;
            }
            this.dou.iw(true);
            this.dou.b(this.dnG, this.buc, this.dom, true);
        }
    }

    public void aB(int i, int i2) {
        if (this.dou != null) {
            this.dou.a(i, i2, this.dom, 1);
        }
    }

    public void aC(int i, int i2) {
        this.dnG = i;
        this.buc = i2;
    }

    public void fK(boolean z) {
        this.dom = z;
    }

    private void avy() {
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
            if (this.dov != null) {
                this.dov.setAlpha(alpha);
            }
            if (this.dow != null) {
                this.dow.setAlpha(alpha);
            }
            if (this.doi != null) {
                this.doi.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avz() {
        if (this.dnP.dmt == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cmF) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.am.a(this.mBackImageView, f.C0146f.btn_sml_back_selector_s, f.C0146f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.am.a(this.dnU, f.C0146f.icon_sml_search_bg, f.C0146f.icon_sml_search_bg);
                if (this.dnV != null) {
                    com.baidu.tbadk.core.util.am.a(this.dnV.akG(), f.C0146f.icon_topbar_white_remind, f.C0146f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.am.a(this.mBackImageView, f.C0146f.icon_return_bg_s, f.C0146f.icon_return_bg);
                com.baidu.tbadk.core.util.am.a(this.dnU, f.C0146f.icon_search_bg_s, f.C0146f.icon_search_bg);
                if (this.dnV != null) {
                    com.baidu.tbadk.core.util.am.a(this.dnV.akG(), f.C0146f.icon_topbar_remind, f.C0146f.icon_topbar_remind);
                }
            }
            avy();
        }
    }

    public void fL(boolean z) {
    }

    public void kC(int i) {
        if (this.doa != null && this.doa.getChildCount() >= 0) {
            if (this.doa.getFirstVisiblePosition() > 8) {
                this.doa.scrollToPosition(8);
            }
            this.doa.smoothScrollToPosition(i);
        }
    }

    public void avA() {
        a(this.doy, this.dnP.auE());
        if (this.dob != null) {
            this.dob.axd();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.doA == null) {
                this.doA = new com.baidu.tieba.video.f(this.dnP.getActivity(), this.dnQ);
            }
            this.doA.h(postWriteCallBackData);
        }
    }

    public void avB() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.doN && this.dnP.getActivity() != null && this.dnP.getPageContext() != null) {
            View view = null;
            if (this.doa != null && (headerViewsCount = this.doa.getHeaderViewsCount()) < this.doa.getChildCount()) {
                view = this.doa.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).X(0).E(true).F(false).D(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(f.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(f.g.tips)).setText(f.j.frs_video_activity_guide_tip);
                        k.this.dnP.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.f(k.this.dnP.getActivity(), f.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.f(k.this.dnP.getActivity(), f.e.ds6);
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
                hy.j(this.dnP.getActivity());
                com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hy != null) {
                            hy.dismiss();
                        }
                    }
                }, 4000L);
                this.doN = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.doI != null) {
            this.doI.setDeleteCallback(aVar);
        }
    }

    public void avC() {
        if (this.doI != null) {
            this.doI.avC();
        }
    }

    public void PB() {
        if (this.doI != null) {
            this.doI.PB();
        }
    }

    public void S(String str, int i) {
        if (this.doK == null) {
            this.doK = new TextView(this.dnP.getActivity());
            this.doK.setGravity(19);
            this.doK.setPadding(com.baidu.adp.lib.util.l.f(this.dnP.getActivity(), f.e.ds34), 0, com.baidu.adp.lib.util.l.f(this.dnP.getActivity(), f.e.ds34), 0);
            this.doK.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.f(this.dnP.getActivity(), f.e.tbds112)));
            this.doK.setTextSize(0, com.baidu.adp.lib.util.l.f(this.dnP.getActivity(), f.e.fontsize30));
            this.doK.setMaxLines(2);
            this.doK.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.doK.setTextColor(ContextCompat.getColor(this.dnP.getActivity(), f.d.cp_cont_i));
        }
        this.doJ.setBackgroundColor(i);
        this.doK.setText(str);
        this.doJ.a(this.dnP.getActivity(), this.doK, 5000);
    }
}
