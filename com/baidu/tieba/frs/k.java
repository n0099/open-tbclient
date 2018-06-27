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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.bj;
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
    private AppBarLayout NY;
    private PbListView buU;
    private BdSwipeRefreshLayout bxI;
    private NoNetworkView cPM;
    private CommonTipView cRx;
    private com.baidu.tieba.frs.vc.i dlA;
    private GifView dlB;
    private TbImageView dlC;
    private HashSet<String> dlD;
    private com.baidu.tieba.play.m dlE;
    private ObservedChangeLinearLayout dlH;
    private com.baidu.tieba.frs.entelechy.b.a dlI;
    private com.baidu.tieba.video.e dlK;
    private AppBarLayoutStickyBehavior dlL;
    private FrsHeaderViewContainer dlM;
    private CollapsingToolbarLayout dlN;
    private com.baidu.tieba.frs.vc.f dlR;
    private FrsMultiDelBottomMenuView dlS;
    private NavigationBarCoverTip dlT;
    private TextView dlU;
    private boolean dlX;
    private FrsFragment dla;
    private View dle;
    private ImageView dlf;
    private com.baidu.tieba.c.b dlg;
    private ViewStub dlh;
    private com.baidu.tieba.frs.entelechy.a.q dlm;
    private FloatingAnimationView dln;
    private com.baidu.tieba.c.c dlo;
    private View.OnClickListener dlq;
    private View dls;
    private View dlt;
    private int dlv;
    private View dlx;
    private com.baidu.tieba.frs.entelechy.b.d dly;
    private com.baidu.tieba.frs.entelechy.b.c dlz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean dkZ = false;
    private NoPressedRelativeLayout dlb = null;
    private CoordinatorLayout dlc = null;
    private View dld = null;
    private FrameLayout dli = null;
    private TbImageView dlj = null;
    private TbImageView dlk = null;
    private BdTypeRecyclerView dll = null;
    private com.baidu.tbadk.core.dialog.b dlp = null;
    private NoNetworkView.a dhp = null;
    private RecyclerView.ItemAnimator.ItemAnimatorFinishedListener dlr = new RecyclerView.ItemAnimator.ItemAnimatorFinishedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.v7.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener
        public void onAnimationsFinished() {
            if (k.this.dll != null && k.this.dll.getAdapter() != null) {
                k.this.dll.getAdapter().notifyDataSetChanged();
            }
        }
    };
    private boolean dlu = true;
    private boolean mHasMore = true;
    private boolean dlw = false;
    private int dkR = 0;
    private int btu = 0;
    private View dlF = null;
    private View dlG = null;
    private boolean ckU = false;
    private boolean dlJ = true;
    private boolean dlO = true;
    private int dlP = -1;
    private int dlQ = -1;
    private AppBarLayout.OnOffsetChangedListener dlV = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.5
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dlQ != i && Math.abs(i) >= 0 && k.this.auw() != -1) {
                if (Math.abs(i) >= k.this.auw()) {
                    if (k.this.dlO) {
                        k.this.dlO = false;
                        k.this.fz(k.this.dlO);
                    }
                } else if (!k.this.dlO) {
                    k.this.dlO = true;
                    k.this.fz(k.this.dlO);
                }
                int auq = k.this.auq() + k.this.aup() + k.this.aur();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - auq;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dlQ - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.kk(Math.abs(auq - totalScrollRange2));
                        if (k.this.dlG != null) {
                            k.this.dlG.setVisibility(0);
                        }
                    } else if (k.this.dlG != null) {
                        if (k.this.auo() != UtilHelper.getStatusBarHeight()) {
                            k.this.kk(0);
                        }
                        k.this.dlG.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.ckU) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.auW();
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.dlQ = i;
                }
            }
        }
    };
    private Runnable dlW = new Runnable() { // from class: com.baidu.tieba.frs.k.11
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dlh != null) {
                k.this.dli.setVisibility(0);
                k.this.dlk.setVisibility(0);
                k.this.dlj.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dlY = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.NY.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout aul() {
        return this.dlH;
    }

    public View aum() {
        return this.dlF;
    }

    public View aun() {
        return this.dlG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auo() {
        if (this.dlF == null) {
            return 0;
        }
        return this.dlF.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aup() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auq() {
        if (this.cPM == null || com.baidu.adp.lib.util.j.jD()) {
            return 0;
        }
        return this.cPM.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aur() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(int i) {
        View aum = aum();
        View aun = aun();
        if (UtilHelper.canUseStyleImmersiveSticky() && aum != null && aun != null && aum.getLayoutParams() != null && aun.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = aum.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            aum.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = aun.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            aun.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.dla = null;
        this.dlq = null;
        this.dlv = 0;
        this.dla = frsFragment;
        this.dlq = onClickListener;
        a(aVar, z);
        this.dlD = new HashSet<>();
        this.dlv = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dlR = fVar;
    }

    private boolean aus() {
        return this.dlR != null && this.dlR.azS();
    }

    private void aut() {
        this.dla.registerListener(this.dlY);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        aut();
        this.dlI = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.dla.getPageContext());
        }
        this.mPullView.setTag(this.dla.getUniqueId());
        if (this.dlb == null) {
            this.dlb = (NoPressedRelativeLayout) this.dla.mRootView.findViewById(d.g.frs);
        }
        if (this.dld == null) {
            this.dld = this.dla.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.dlc == null) {
            this.dlc = (CoordinatorLayout) this.dla.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.dlt == null) {
            this.dlt = this.dla.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.dlN == null) {
            this.dlN = (CollapsingToolbarLayout) this.dla.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.dlM == null) {
            this.dlM = (FrsHeaderViewContainer) this.dla.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.dlH == null) {
            this.dlH = (ObservedChangeLinearLayout) this.dla.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.dlH.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.k.6
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dlN.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dla.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dla.aub()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dls == null) {
            this.dls = this.dla.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b avX = aVar.avX();
            if (avX != null) {
                avX.at(this.dls);
            }
        }
        if (this.dle == null) {
            this.dle = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dle.setOnClickListener(this.dlq);
            this.mBackImageView = (ImageView) this.dle.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dlf == null) {
            this.dlf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.dlf.setOnClickListener(this.dlq);
        }
        if (this.dlg == null) {
            this.dlg = new com.baidu.tieba.c.b(this.dla.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dlg.getView(), (View.OnClickListener) null);
            this.dlg.getView().setOnClickListener(this.dlq);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dla.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), d.C0142d.cp_bg_line_b);
        }
        if (this.bxI == null) {
            this.bxI = (BdSwipeRefreshLayout) this.dla.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.bxI.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.j(this.bxI, d.C0142d.cp_bg_line_c);
        }
        if (this.dll == null) {
            this.dll = (BdTypeRecyclerView) this.dla.mRootView.findViewById(d.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.7
            int dmb = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.dmb--;
                if (this.dmb == 0) {
                    k.this.dll.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.dmb++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.dll.setItemAnimator(defaultItemAnimator);
        this.dll.setLayoutManager(new LinearLayoutManager(this.dll.getContext()));
        this.dll.setScrollable(this.dla);
        this.dll.setFadingEdgeLength(0);
        this.dll.setOverScrollMode(2);
        this.dlb.setBottomOrderView(this.dll);
        this.dll.setOnTouchListener(this.dla.aWD);
        this.dll.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.8
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dlE != null) {
                    k.this.dlE.aQ(view);
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
        if (this.buU == null) {
            this.buU = new PbListView(this.dla.getPageContext().getPageActivity());
            this.buU.getView();
        }
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.setHeight(com.baidu.adp.lib.util.l.e(this.dla.getActivity(), d.e.tbds182));
        this.buU.AE();
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.setTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_cont_d));
        this.buU.dx(d.C0142d.cp_cont_e);
        this.dll.setOnSrollToBottomListener(this.dla);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dla.atY();
                if (k.this.dla != null && k.this.NY != null) {
                    k.this.dla.aud();
                    k.this.NY.setExpanded(true);
                    if (k.this.dlE != null) {
                        k.this.dlE.b(k.this.dkR, k.this.btu, false, true);
                    }
                }
            }
        });
        boolean zH = com.baidu.tbadk.core.util.ar.zF().zH();
        if (this.dlm == null) {
            this.dlm = aVar.a(this.dla, this.dll, zH);
        }
        cp(false);
        if (!z) {
            if (this.cPM == null) {
                this.cPM = new NoNetworkView(this.dla.getActivity());
                this.cPM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dlH.addView(this.cPM);
            }
            if (com.baidu.adp.lib.util.j.jr()) {
                this.cPM.setVisibility(8);
            } else {
                this.cPM.setVisibility(0);
            }
            this.cPM.onChangeSkinType(this.dla.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        auD();
        if (this.dly == null) {
            this.dly = aVar.c(this.dla, this.dlb);
        }
        if (this.dlz == null) {
            this.dlz = aVar.b(this.dla, this.dlb);
            fC(true);
        }
        if (this.dlF == null) {
            this.dlF = this.dla.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.dlG == null) {
            this.dlG = this.dla.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.dlE == null) {
            this.dlE = new com.baidu.tieba.play.m(this.dla.getPageContext(), this.dll);
        }
        this.dlE.setUniqueId(this.dla.getUniqueId());
        this.dlT = (NavigationBarCoverTip) this.dla.mRootView.findViewById(d.g.navigation_cover_tip);
        if (this.dlA == null) {
            this.dlA = new com.baidu.tieba.frs.vc.i(this.dla, this.dlT);
        }
        if (this.NY == null) {
            this.NY = (AppBarLayout) this.dla.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.NY.addOnOffsetChangedListener(this.dlV);
            this.dlO = true;
            this.dlP = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.NY.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dlL = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.dlS = (FrsMultiDelBottomMenuView) this.dla.mRootView.findViewById(d.g.frs_multi_delete_menu_view);
        this.dlS.setPageContext(this.dla.getPageContext());
        this.dln = (FloatingAnimationView) this.dla.mRootView.findViewById(d.g.redpacket_view);
        this.dln.setPageId(this.dla.getUniqueId());
        this.dlo = new com.baidu.tieba.c.c(this.dla.ahZ(), this.dln, 2);
    }

    public void fy(boolean z) {
        if (z && this.dlo != null) {
            this.dlo.aki();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.dlo != null) {
            this.dlo.a(mVar);
        }
    }

    private void auu() {
        ViewGroup.LayoutParams layoutParams;
        this.ckU = aus();
        if (this.dlM != null && (layoutParams = this.dlM.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.ckU) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds88) + aup(), 0, 0);
            }
            this.dlM.requestLayout();
        }
    }

    public void auv() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dlH != null) {
            auu();
            if (this.ckU) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dlF != null) {
                    this.dlF.setAlpha(1.0f);
                }
                if (this.dlG != null) {
                    this.dlG.setAlpha(1.0f);
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
    public void fz(boolean z) {
        if (z && this.dla != null && this.dla.atF() != null) {
            this.dla.atF().azW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int auw() {
        int i;
        if (this.NY == null) {
            return this.dlP;
        }
        if (this.dlP != -1) {
            return this.dlP;
        }
        int childCount = this.NY.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.NY.getChildAt(childCount);
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
        this.dlP = Math.max(0, this.NY.getTotalScrollRange() - Math.abs(i2));
        return this.dlP;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dlx != null && this.dlx.getLayoutParams() != null) {
            this.dlx.getLayoutParams().height = i;
            this.dlx.setLayoutParams(this.dlx.getLayoutParams());
        }
    }

    public void mv(String str) {
        if (this.dlA != null) {
            this.dlA.mv(str);
        }
    }

    public View aux() {
        return this.dlx;
    }

    public com.baidu.tieba.play.m auy() {
        return this.dlE;
    }

    public com.baidu.tieba.frs.entelechy.b.c auz() {
        return this.dlz;
    }

    public void fA(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.w.A(this.dla.atZ().bwe());
        if (this.dly != null) {
            this.dly.fA(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d auA() {
        return this.dly;
    }

    public void w(boolean z, boolean z2) {
        if (this.dlJ && this.dlz != null) {
            this.dlz.w(z, z2);
        }
    }

    public void fB(boolean z) {
        this.dlJ = z;
        if (!this.dlJ && this.dlz != null) {
            this.dlz.w(false, false);
        }
    }

    public void auB() {
        if (this.dlJ && this.dlz != null) {
            this.dlz.w(false, false);
        }
        this.dlf.setVisibility(8);
        fA(false);
        this.dll.setVisibility(8);
        this.dlM.setVisibility(8);
    }

    public void auC() {
        if (this.dlJ && this.dlz != null) {
            this.dlz.w(true, false);
        }
        this.dlf.setVisibility(0);
        fA(this.dla.aug());
        this.dll.setVisibility(0);
        this.dlM.setVisibility(0);
    }

    public void fC(boolean z) {
        if (this.dlz != null) {
            this.dlz.fY(z);
        }
    }

    private void auD() {
        if (this.dlB == null) {
            this.dlB = (GifView) this.dla.mRootView.findViewById(d.g.gif_real_time);
            this.dlC = (TbImageView) this.dla.mRootView.findViewById(d.g.tbimg_real_time);
            this.dlC.setPageId(this.dla.getUniqueId());
            this.dlB.setLayerType(1, null);
            this.dlC.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View auE() {
        return this.dle;
    }

    public void h(NoNetworkView.a aVar) {
        this.dhp = aVar;
        if (this.cPM != null) {
            this.cPM.a(this.dhp);
        }
    }

    public void cp(boolean z) {
        this.dkZ = z;
        if (z) {
            if (this.dlz != null) {
                this.dlz.awG();
                return;
            }
            return;
        }
        this.dll.getAdapter().notifyDataSetChanged();
        if (this.dlz != null) {
            this.dlz.awH();
        }
    }

    public void fD(boolean z) {
        if (this.dlz != null) {
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
        this.dll.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.dlm.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.dlm.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dlE != null) {
            this.dlE.destroy();
        }
        if (this.dlA != null) {
            this.dlA.onDestory();
        }
        if (this.dlS != null) {
            this.dlS.setPageContext(null);
        }
        this.dlm.onDestory();
        this.dll.setOnSrollToBottomListener(null);
        this.dll.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dlW);
        if (this.cRx != null) {
            this.cRx.onDestroy();
        }
        this.dlD.clear();
        if (this.dly != null) {
            this.dly.awI();
        }
        if (this.dlK != null) {
            this.dlK.avN();
        }
        if (this.dlo != null) {
            this.dlo.onDestroy();
        }
        if (this.dlT != null) {
            this.dlT.onDestroy();
        }
        if (this.dlS != null) {
            this.dlS.onDestroy();
        }
    }

    public boolean auF() {
        if (this.NY == null || this.dlL == null || !this.dlL.isSticky()) {
            return this.dly != null && this.dly.auF();
        }
        if (this.dll != null) {
            this.dll.setSelection(0);
        }
        this.dlL.expandedAppBarLayout(this.NY);
        return true;
    }

    public boolean aua() {
        return this.dkZ;
    }

    public void showListView() {
        this.dll.setVisibility(0);
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
            com.baidu.tbadk.core.i.tt().dc(str);
        }
    }

    public void auG() {
        if (this.dlm != null) {
            this.dlm.notifyDataSetChanged();
        }
    }

    public void ajF() {
        if (this.dlm instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dlm).ajF();
        }
    }

    private void auH() {
        if (this.dlp == null && this.dla.getPageContext() != null) {
            String[] strArr = {this.dla.getPageContext().getPageActivity().getString(d.k.take_photo), this.dla.getPageContext().getPageActivity().getString(d.k.album)};
            this.dlp = new com.baidu.tbadk.core.dialog.b(this.dla.getPageContext().getPageActivity());
            this.dlp.dF(this.dla.getPageContext().getPageActivity().getString(d.k.operation));
            this.dlp.a(strArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.frs.k.10
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dla.takePhoto();
                    } else if (i == 1 && k.this.dla.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.r(k.this.dla.getPageContext().getPageActivity());
                    }
                }
            });
            this.dlp.d(this.dla.getPageContext());
        }
    }

    public void auI() {
        auH();
        if (this.dlp != null) {
            this.dlp.xq();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.w.A(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dla != null && this.dla.atD() != null && this.dla.atD().ayX() == 0) {
                mVar.kt(this.dla.atD().azf());
            }
        }
        if (com.baidu.tbadk.core.util.w.z(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
                if (hVar instanceof bc) {
                    ((bc) hVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.dlm.b(arrayList, lVar);
        if (this.dlE != null) {
            this.dlE.b(this.dkR, this.btu, this.dlw, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dll;
    }

    public void auJ() {
        this.dlm.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dla.getPageContext(), 1);
        aVar.a(this.dll);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dla.getForumName());
        hashMap.put("forum_id", this.dla.getForumId());
        aVar.setParams(hashMap);
        aVar.K(wVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dly != null) {
            this.dly.awJ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        kl(TbadkCoreApplication.getInst().getSkinType());
        auW();
        if (this.dly != null) {
            this.dly.awK();
        }
    }

    public void release() {
        if (this.cPM != null && this.dhp != null) {
            this.cPM.b(this.dhp);
        }
    }

    public ImageView auK() {
        return this.dlf;
    }

    public View auL() {
        if (this.dlg != null) {
            return this.dlg.getView();
        }
        return null;
    }

    public void p(int i, boolean z) {
        if (this.dlg != null) {
            this.dlg.f(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dla, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dla.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dlC != null) {
            this.dlC.invalidate();
        }
        if (this.dlm != null) {
            this.dlm.awv();
            this.dlm.notifyDataSetChanged();
        }
        com.baidu.tbadk.n.a.a(this.dla.getPageContext(), this.dlb);
        kl(i);
        if (this.cPM != null) {
            this.cPM.onChangeSkinType(this.dla.getPageContext(), i);
        }
        if (this.buU != null) {
            this.buU.setTextColor(com.baidu.tbadk.core.util.am.getColor(d.C0142d.cp_cont_d));
            this.buU.dz(i);
        }
        auW();
        if (this.dlz != null) {
            this.dlz.onChangeSkinType(i);
        }
        if (this.dly != null) {
            this.dly.onChangeSkinType(i);
        }
        if (this.dlE != null) {
            this.dlE.b(this.dkR, this.btu, this.dlw, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.dlS != null) {
            this.dlS.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.j(this.bxI, d.C0142d.cp_bg_line_e);
    }

    private void kl(int i) {
        if (this.dla != null) {
            Pair<Integer, Integer> pair = this.dla.djF;
            if (pair != null) {
                a(i, pair);
            } else {
                km(i);
            }
        }
    }

    private void km(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.am.cS(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dla.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.am.e(this.dls, d.C0142d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), d.C0142d.cp_bg_line_b);
            int i2 = d.C0142d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.aq.zE().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.aq.zE().c(this.dlf, d.f.icon_topbar_search_n_svg, i2);
            if (this.dlg != null) {
                this.dlg.ja(i2);
                this.dlg.onChangeSkinType(i);
            }
        }
        UtilHelper.setStatusBarBackground(this.dlF, i);
        UtilHelper.setStatusBarBackground(this.dlG, i);
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dla.getPageContext(), i);
                com.baidu.tbadk.core.util.am.e(this.dls, d.C0142d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.am.j(this.mNavigationBar.getBottomLine(), d.C0142d.cp_bg_line_b);
                com.baidu.tbadk.core.util.am.c(this.mNavigationBar.mCenterText, d.C0142d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dlF, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.dlG, pair);
            int i2 = d.C0142d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.aq.zE().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.aq.zE().c(this.dlf, d.f.icon_topbar_search_n_svg, i2);
            if (this.dlg != null) {
                this.dlg.ja(i2);
                this.dlg.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.dll != null) {
            this.dll.setSelection(0);
        }
        if (this.NY != null) {
            this.NY.setExpanded(true);
        }
        if (this.bxI != null && this.bxI.isEnabled()) {
            this.bxI.setRefreshing(true);
        }
    }

    public void fE(boolean z) {
        if (z) {
            this.bxI.setRefreshing(false);
        } else {
            this.bxI.nX();
        }
    }

    public void fF(boolean z) {
        this.bxI.setEnabled(z);
    }

    public void fG(boolean z) {
        this.dlu = z;
        if (this.dlu) {
            this.buU.setText(this.dla.getResources().getString(d.k.load_more));
            if (this.dll.getChildAt(this.dll.getChildCount() - 1) == this.buU.getView()) {
                this.buU.AH();
                this.dla.Tf();
                return;
            }
            this.buU.AI();
            return;
        }
        this.buU.setText(this.dla.getResources().getString(d.k.load_more_must_after_delete));
        this.buU.AI();
    }

    public boolean auM() {
        if (this.dlu) {
            return false;
        }
        this.buU.setText(this.dla.getResources().getString(d.k.load_more_must_after_delete));
        this.buU.AI();
        return true;
    }

    public boolean auN() {
        return this.dlh != null && this.dlk.getVisibility() == 0;
    }

    public void auO() {
        if (this.dlh != null) {
            this.dli.setVisibility(0);
            this.dlk.setVisibility(8);
            this.dlj.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dlW, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bj bjVar) {
        if (this.dlh == null) {
            this.dlh = (ViewStub) this.dla.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.dlh.setVisibility(0);
            this.dli = (FrameLayout) this.dla.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.dlj = (TbImageView) this.dla.mRootView.findViewById(d.g.game_activity_egg);
            this.dlk = (TbImageView) this.dla.mRootView.findViewById(d.g.game_activity_egg_s);
            this.dlj.setPageId(this.dla.getUniqueId());
            this.dlk.setPageId(this.dla.getUniqueId());
            this.dlj.setDefaultBgResource(d.C0142d.common_color_10022);
            this.dlj.setDefaultResource(0);
            this.dlk.setDefaultBgResource(d.C0142d.common_color_10022);
            this.dlk.setDefaultResource(0);
            this.dli.setOnClickListener(this.dlq);
        }
        this.dli.setVisibility(0);
        String xd = bjVar.xd();
        String xe = bjVar.xe();
        this.dlj.startLoad(xd, 10, false);
        this.dlk.startLoad(xe, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dlW, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void auP() {
        if (this.dlh != null) {
            this.dli.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q auQ() {
        return this.dlm;
    }

    public ViewGroup adP() {
        return this.dlb;
    }

    public View auR() {
        return this.dlt;
    }

    public void kn(int i) {
        if (this.dld != null) {
            this.dld.setVisibility(i);
        }
    }

    public void auS() {
        if (com.baidu.tbadk.k.m.KK().KL()) {
            int lastVisiblePosition = this.dll.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dll.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dmh != null) {
                        com.baidu.tbadk.k.h perfLog = oVar.dmh.getPerfLog();
                        perfLog.fl(1000);
                        perfLog.aTJ = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dmh.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dmh.startLogPerf();
                    }
                    if (oVar.dmg != null && (oVar.dmg instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dmg;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fl(1000);
                                perfLog2.aTJ = true;
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

    public NavigationBar UW() {
        return this.mNavigationBar;
    }

    public void Ud() {
        this.mHasMore = true;
        this.dll.setNextPage(this.buU);
        if (this.dlv > 0) {
            this.buU.dA(this.dlv);
        }
        this.buU.setOnClickListener(null);
        this.buU.AH();
    }

    public void Ue() {
        this.mHasMore = false;
        this.dll.setNextPage(this.buU);
        if (this.dlv > 0) {
            this.buU.dA(this.dlv);
        }
        this.buU.setOnClickListener(null);
        this.buU.AI();
        this.buU.setText(this.dla.getResources().getString(d.k.list_has_no_more));
    }

    public void auT() {
        this.mHasMore = true;
        this.dll.setNextPage(this.buU);
        this.buU.setOnClickListener(this.dlq);
        if (this.dlv > 0) {
            this.buU.dA(this.dlv);
        }
        this.buU.AI();
        this.buU.setText(this.dla.getResources().getString(d.k.list_click_load_more));
    }

    public View auU() {
        if (this.buU == null) {
            return null;
        }
        return this.buU.getView();
    }

    public void ko(int i) {
        if (this.dlS != null) {
            this.dlS.setVisibility(i);
        }
    }

    public void kp(int i) {
        if (this.dlS != null) {
            this.dlS.setSelectNumber(i);
        }
    }

    public void Uf() {
        this.mHasMore = false;
        this.dll.setNextPage(null);
    }

    public boolean ajw() {
        return this.buU.getView().getParent() != null && this.mHasMore;
    }

    public void kq(int i) {
        this.dlv = i;
    }

    public void kr(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cRx == null) {
                    this.cRx = new CommonTipView(this.dla.getActivity());
                }
                this.cRx.setText(d.k.frs_login_tip);
                this.cRx.show((FrameLayout) auR(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fH(boolean z) {
        if (this.dlE != null) {
            if (z) {
                this.dlE.it(false);
                this.dlE.aED();
                return;
            }
            this.dlE.it(true);
            this.dlE.b(this.dkR, this.btu, this.dlw, true);
        }
    }

    public void ay(int i, int i2) {
        if (this.dlE != null) {
            this.dlE.a(i, i2, this.dlw, 1);
        }
    }

    public void az(int i, int i2) {
        this.dkR = i;
        this.btu = i2;
    }

    public void fI(boolean z) {
        this.dlw = z;
    }

    private void auV() {
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
            if (this.dlF != null) {
                this.dlF.setAlpha(alpha);
            }
            if (this.dlG != null) {
                this.dlG.setAlpha(alpha);
            }
            if (this.dls != null) {
                this.dls.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auW() {
        if (this.dla.djF == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.ckU) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.am.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.am.a(this.dlf, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.dlg != null) {
                    com.baidu.tbadk.core.util.am.a(this.dlg.akf(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.am.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.am.a(this.dlf, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.dlg != null) {
                    com.baidu.tbadk.core.util.am.a(this.dlg.akf(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            auV();
        }
    }

    public void fJ(boolean z) {
    }

    public void ks(int i) {
        if (this.dll != null && this.dll.getChildCount() >= 0) {
            if (this.dll.getFirstVisiblePosition() > 8) {
                this.dll.scrollToPosition(8);
            }
            this.dll.smoothScrollToPosition(i);
        }
    }

    public void auX() {
        a(this.dlI, this.dla.aub());
        if (this.dlm != null) {
            this.dlm.awz();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dlK == null) {
                this.dlK = new com.baidu.tieba.video.e(this.dla.getActivity(), this.dlb);
            }
            this.dlK.h(postWriteCallBackData);
        }
    }

    public void auY() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dlX && this.dla.getActivity() != null && this.dla.getPageContext() != null) {
            View view = null;
            if (this.dll != null && (headerViewsCount = this.dll.getHeaderViewsCount()) < this.dll.getChildCount()) {
                view = this.dll.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).X(0).F(true).G(false).E(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.12
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.i.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.k.frs_video_activity_guide_tip);
                        k.this.dla.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.e(k.this.dla.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.e(k.this.dla.getActivity(), d.e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c hy = dVar.hy();
                hy.C(false);
                hy.k(this.dla.getActivity());
                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hy != null) {
                            hy.dismiss();
                        }
                    }
                }, 4000L);
                this.dlX = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.dlS != null) {
            this.dlS.setDeleteCallback(aVar);
        }
    }

    public void auZ() {
        if (this.dlS != null) {
            this.dlS.auZ();
        }
    }

    public void Pp() {
        if (this.dlS != null) {
            this.dlS.Pp();
        }
    }

    public void W(String str, int i) {
        if (this.dlU == null) {
            this.dlU = new TextView(this.dla.getActivity());
            this.dlU.setGravity(19);
            this.dlU.setPadding(com.baidu.adp.lib.util.l.e(this.dla.getActivity(), d.e.ds34), 0, com.baidu.adp.lib.util.l.e(this.dla.getActivity(), d.e.ds34), 0);
            this.dlU.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.e(this.dla.getActivity(), d.e.tbds112)));
            this.dlU.setTextSize(0, com.baidu.adp.lib.util.l.e(this.dla.getActivity(), d.e.fontsize30));
            this.dlU.setMaxLines(2);
            this.dlU.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.dlU.setTextColor(ContextCompat.getColor(this.dla.getActivity(), d.C0142d.cp_cont_i));
        }
        this.dlT.setBackgroundColor(i);
        this.dlU.setText(str);
        this.dlT.a(this.dla.getActivity(), this.dlU, 5000);
    }
}
