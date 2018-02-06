package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bl;
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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class k {
    private AppBarLayout awR;
    private PbListView cbk;
    private BdSwipeRefreshLayout ceb;
    private i dFP;
    private View dFT;
    private ImageView dFU;
    private com.baidu.tieba.d.b dFV;
    private ViewStub dFW;
    private com.baidu.tieba.frs.g.f dGC;
    private boolean dGF;
    private com.baidu.tieba.frs.entelechy.a.s dGb;
    private View.OnClickListener dGd;
    private View dGe;
    private View dGf;
    private int dGg;
    private View dGi;
    private com.baidu.tieba.frs.entelechy.b.d dGj;
    private com.baidu.tieba.frs.entelechy.b.c dGk;
    private com.baidu.tieba.frs.g.j dGl;
    private GifView dGm;
    private TbImageView dGn;
    private HashSet<String> dGo;
    private com.baidu.tieba.play.m dGp;
    private ObservedChangeLinearLayout dGs;
    private com.baidu.tieba.frs.entelechy.b.a dGt;
    private com.baidu.tieba.video.e dGv;
    private AppBarLayoutStickyBehavior dGw;
    private FrsHeaderViewContainer dGx;
    private CollapsingToolbarLayout dGy;
    private NoNetworkView dpu;
    private CommonTipView dqU;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dFO = false;
    private NoPressedRelativeLayout dFQ = null;
    private CoordinatorLayout dFR = null;
    private View dFS = null;
    private FrameLayout dFX = null;
    private TbImageView dFY = null;
    private TbImageView dFZ = null;
    private BdTypeRecyclerView dGa = null;
    private com.baidu.tbadk.core.dialog.b dGc = null;
    private NoNetworkView.a dCE = null;
    private boolean mHasMore = true;
    private boolean dGh = false;
    private int dFI = 0;
    private int bZI = 0;
    private View dGq = null;
    private View dGr = null;
    private boolean cJH = false;
    private boolean dGu = true;
    private boolean dGz = true;
    private int dGA = -1;
    private int dGB = -1;
    private AppBarLayout.OnOffsetChangedListener dGD = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dGB != i && Math.abs(i) >= 0 && k.this.avC() != -1) {
                if (Math.abs(i) >= k.this.avC()) {
                    if (k.this.dGz) {
                        k.this.dGz = false;
                        k.this.fM(k.this.dGz);
                    }
                } else if (!k.this.dGz) {
                    k.this.dGz = true;
                    k.this.fM(k.this.dGz);
                }
                int avw = k.this.avw() + k.this.avu() + k.this.avx();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - avw;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dGB - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.mR(Math.abs(avw - totalScrollRange2));
                        if (k.this.dGr != null) {
                            k.this.dGr.setVisibility(0);
                        }
                    } else if (k.this.dGr != null) {
                        if (k.this.avu() != UtilHelper.getStatusBarHeight()) {
                            k.this.mR(0);
                        }
                        k.this.dGr.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null && k.this.cJH) {
                        k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                        k.this.awc();
                    }
                    k.this.dGB = i;
                }
            }
        }
    };
    private Runnable dGE = new Runnable() { // from class: com.baidu.tieba.frs.k.7
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dFW != null) {
                k.this.dFX.setVisibility(0);
                k.this.dFZ.setVisibility(0);
                k.this.dFY.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dGG = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.awR.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout avr() {
        return this.dGs;
    }

    public View avs() {
        return this.dGq;
    }

    public View avt() {
        return this.dGr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avu() {
        if (this.dGq == null) {
            return 0;
        }
        return this.dGq.getHeight();
    }

    private int avv() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avw() {
        if (this.dpu == null || com.baidu.adp.lib.util.j.oJ()) {
            return 0;
        }
        return this.dpu.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avx() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(int i) {
        View avs = avs();
        View avt = avt();
        if (UtilHelper.canUseStyleImmersiveSticky() && avs != null && avt != null && avs.getLayoutParams() != null && avt.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = avs.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            avs.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = avt.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            avt.setLayoutParams(layoutParams2);
        }
    }

    public k(i iVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.g.f fVar) {
        this.dFP = null;
        this.dGd = null;
        this.dGg = 0;
        this.dFP = iVar;
        this.dGd = onClickListener;
        a(aVar, z);
        this.dGo = new HashSet<>();
        this.dGg = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dGC = fVar;
    }

    private boolean avy() {
        return this.dGC != null && this.dGC.aAh();
    }

    private void avz() {
        this.dFP.registerListener(this.dGG);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        avz();
        this.dGt = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dFP.getPageContext());
        }
        this.mPullView.setTag(this.dFP.getUniqueId());
        if (this.dFQ == null) {
            this.dFQ = (NoPressedRelativeLayout) this.dFP.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.t(this.dFQ, d.C0140d.cp_bg_line_d);
        if (this.dFS == null) {
            this.dFS = this.dFP.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.dFR == null) {
            this.dFR = (CoordinatorLayout) this.dFP.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.dGf == null) {
            this.dGf = this.dFP.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.dGy == null) {
            this.dGy = (CollapsingToolbarLayout) this.dFP.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.dGx == null) {
            this.dGx = (FrsHeaderViewContainer) this.dFP.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.dGs == null) {
            this.dGs = (ObservedChangeLinearLayout) this.dFP.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.dGs.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.3
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dGy.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dFP.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dFP.avn()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dGe == null) {
            this.dGe = this.dFP.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b awV = aVar.awV();
            if (awV != null) {
                awV.bM(this.dGe);
            }
        }
        if (this.dFT == null) {
            this.dFT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dFT.setOnClickListener(this.dGd);
            this.mBackImageView = (ImageView) this.dFT.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dFU == null) {
            this.dFU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dFU.setOnClickListener(this.dGd);
        }
        if (this.dFV == null) {
            this.dFV = new com.baidu.tieba.d.b(this.dFP.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dFV.getView(), (View.OnClickListener) null);
            this.dFV.getView().setOnClickListener(this.dGd);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dFP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
        }
        if (this.ceb == null) {
            this.ceb = (BdSwipeRefreshLayout) this.dFP.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.ceb.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.aj.t(this.ceb, d.C0140d.cp_bg_line_c);
        }
        if (this.dGa == null) {
            this.dGa = (BdTypeRecyclerView) this.dFP.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.dGa.getItemAnimator()).setSupportsChangeAnimations(false);
        this.dGa.setLayoutManager(new LinearLayoutManager(this.dGa.getContext()));
        this.dGa.setScrollable(this.dFP);
        this.dGa.setFadingEdgeLength(0);
        this.dGa.setOverScrollMode(2);
        this.dFQ.setBottomOrderView(this.dGa);
        this.dGa.setOnTouchListener(this.dFP.bDx);
        this.dGa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dGp != null) {
                    k.this.dGp.cg(view);
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
        if (this.cbk == null) {
            this.cbk = new PbListView(this.dFP.getPageContext().getPageActivity());
            this.cbk.getView();
        }
        this.cbk.gw(d.C0140d.cp_bg_line_e);
        this.cbk.setHeight(com.baidu.adp.lib.util.l.t(this.dFP.getActivity(), d.e.tbds182));
        this.cbk.Ed();
        this.cbk.setTextSize(d.e.tbfontsize33);
        this.cbk.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_cont_d));
        this.cbk.gv(d.C0140d.cp_cont_e);
        this.dGa.setOnSrollToBottomListener(this.dFP);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dFP.avj();
                if (k.this.dFP != null && k.this.awR != null) {
                    k.this.dFP.avp();
                    k.this.awR.setExpanded(true);
                    if (k.this.dGp != null) {
                        k.this.dGp.d(k.this.dFI, k.this.bZI, false, true);
                    }
                }
            }
        });
        boolean Dg = com.baidu.tbadk.core.util.ao.De().Dg();
        if (this.dGb == null) {
            this.dGb = aVar.a(this.dFP, this.dGa, Dg);
            if (this.dGb instanceof com.baidu.tieba.frs.entelechy.a.b) {
                ((com.baidu.tieba.frs.entelechy.a.b) this.dGb).setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
            }
        }
        cQ(false);
        if (!z) {
            if (this.dpu == null) {
                this.dpu = new NoNetworkView(this.dFP.getActivity());
                this.dpu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dGs.addView(this.dpu);
            }
            if (com.baidu.adp.lib.util.j.ox()) {
                this.dpu.setVisibility(8);
            } else {
                this.dpu.setVisibility(0);
            }
            this.dpu.onChangeSkinType(this.dFP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        avJ();
        if (this.dGj == null) {
            this.dGj = aVar.c(this.dFP, this.dFQ);
        }
        if (this.dGk == null) {
            this.dGk = aVar.b(this.dFP, this.dFQ);
            fP(true);
        }
        if (this.dGq == null) {
            this.dGq = this.dFP.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.dGr == null) {
            this.dGr = this.dFP.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.dGp == null) {
            this.dGp = new com.baidu.tieba.play.m(this.dFP.getPageContext(), this.dGa);
        }
        this.dGp.setUniqueId(this.dFP.getUniqueId());
        if (this.dGl == null) {
            this.dGl = new com.baidu.tieba.frs.g.j(this.dFP, (NavigationBarCoverTip) this.dFP.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.awR == null) {
            this.awR = (AppBarLayout) this.dFP.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.awR.addOnOffsetChangedListener(this.dGD);
            this.dGz = true;
            this.dGA = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.awR.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dGw = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    private void avA() {
        ViewGroup.LayoutParams layoutParams;
        this.cJH = avy();
        if (this.dGx != null && (layoutParams = this.dGx.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cJH) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, avx() + avv(), 0, 0);
            }
            this.dGx.requestLayout();
        }
    }

    public void avB() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dGs != null) {
            avA();
            if (this.cJH) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dGq != null) {
                    this.dGq.setAlpha(1.0f);
                }
                if (this.dGr != null) {
                    this.dGr.setAlpha(1.0f);
                }
                if (this.mNavigationBar.mCenterText != null) {
                    this.mNavigationBar.mCenterText.setAlpha(1.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(boolean z) {
        if (z && this.dFP != null && this.dFP.auQ() != null) {
            this.dFP.auQ().aAl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avC() {
        int i;
        if (this.awR == null) {
            return this.dGA;
        }
        if (this.dGA != -1) {
            return this.dGA;
        }
        int childCount = this.awR.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.awR.getChildAt(childCount);
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
        this.dGA = Math.max(0, this.awR.getTotalScrollRange() - Math.abs(i2));
        return this.dGA;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dGi != null && this.dGi.getLayoutParams() != null) {
            this.dGi.getLayoutParams().height = i;
            this.dGi.setLayoutParams(this.dGi.getLayoutParams());
        }
    }

    public void lI(String str) {
        if (this.dGl != null) {
            this.dGl.lI(str);
        }
    }

    public View avD() {
        return this.dGi;
    }

    public com.baidu.tieba.play.m avE() {
        return this.dGp;
    }

    public com.baidu.tieba.frs.entelechy.b.c avF() {
        return this.dGk;
    }

    public void fN(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.E(this.dFP.avl().bvA());
        if (this.dGj != null) {
            this.dGj.fN(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d avG() {
        return this.dGj;
    }

    public void y(boolean z, boolean z2) {
        if (this.dGu && this.dGk != null) {
            this.dGk.y(z, z2);
        }
    }

    public void fO(boolean z) {
        this.dGu = z;
        if (!this.dGu && this.dGk != null) {
            this.dGk.y(false, false);
        }
    }

    public void avH() {
        if (this.dGu && this.dGk != null) {
            this.dGk.y(false, false);
        }
        this.dFU.setVisibility(8);
        fN(false);
        this.dGa.setVisibility(8);
        this.dGx.setVisibility(8);
    }

    public void avI() {
        if (this.dGu && this.dGk != null) {
            this.dGk.y(true, false);
        }
        this.dFU.setVisibility(0);
        fN(true);
        this.dGa.setVisibility(0);
        this.dGx.setVisibility(0);
    }

    public void fP(boolean z) {
        if (this.dGk != null) {
            this.dGk.ge(z);
        }
    }

    private void avJ() {
        if (this.dGm == null) {
            this.dGm = (GifView) this.dFP.mRootView.findViewById(d.g.gif_real_time);
            this.dGn = (TbImageView) this.dFP.mRootView.findViewById(d.g.tbimg_real_time);
            this.dGn.setPageId(this.dFP.getUniqueId());
            this.dGm.setLayerType(1, null);
            this.dGn.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View avK() {
        return this.dFT;
    }

    public void h(NoNetworkView.a aVar) {
        this.dCE = aVar;
        if (this.dpu != null) {
            this.dpu.a(this.dCE);
        }
    }

    public void cQ(boolean z) {
        this.dFO = z;
        if (z) {
            if (this.dGk != null) {
                this.dGk.axz();
                return;
            }
            return;
        }
        this.dGa.getAdapter().notifyDataSetChanged();
        if (this.dGk != null) {
            this.dGk.axA();
        }
    }

    public void fQ(boolean z) {
        if (this.dGk != null) {
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
        this.dGa.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.o oVar) {
        this.dGb.setOnAdapterItemClickListener(oVar);
    }

    public void setForumName(String str) {
        this.dGb.setForumName(str);
        this.mForumName = str;
    }

    public void avL() {
        if (this.dGb instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dGb).setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        }
    }

    public void onDestroy() {
        if (this.dGp != null) {
            this.dGp.destroy();
        }
        if (this.dGl != null) {
            this.dGl.onDestory();
        }
        this.dGb.onDestory();
        this.dGa.setOnSrollToBottomListener(null);
        this.dGa.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dGE);
        if (this.dqU != null) {
            this.dqU.onDestroy();
        }
        this.dGo.clear();
        if (this.dGj != null) {
            this.dGj.axB();
        }
        if (this.dGv != null) {
            this.dGv.awP();
        }
    }

    public boolean avM() {
        if (this.awR == null || this.dGw == null || !this.dGw.isSticky()) {
            return this.dGj != null && this.dGj.avM();
        }
        if (this.dGa != null) {
            this.dGa.setSelection(0);
        }
        this.dGw.expandedAppBarLayout(this.awR);
        return true;
    }

    public boolean avm() {
        return this.dFO;
    }

    public void aik() {
        this.dGa.setVisibility(0);
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
            com.baidu.tbadk.core.i.xo().cK(str);
        }
    }

    public void avN() {
        if (this.dGb != null) {
            this.dGb.notifyDataSetChanged();
        }
    }

    public void amD() {
        if (this.dGb instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dGb).amD();
        }
    }

    private void avO() {
        if (this.dGc == null && this.dFP.getPageContext() != null) {
            String[] strArr = {this.dFP.getPageContext().getPageActivity().getString(d.j.take_photo), this.dFP.getPageContext().getPageActivity().getString(d.j.album)};
            this.dGc = new com.baidu.tbadk.core.dialog.b(this.dFP.getPageContext().getPageActivity());
            this.dGc.dl(this.dFP.getPageContext().getPageActivity().getString(d.j.operation));
            this.dGc.a(strArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.frs.k.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dFP.takePhoto();
                    } else if (i == 1 && k.this.dFP.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.s(k.this.dFP.getPageContext().getPageActivity());
                    }
                }
            });
            this.dGc.d(this.dFP.getPageContext());
        }
    }

    public void avP() {
        avO();
        if (this.dGc != null) {
            this.dGc.AX();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.E(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dFP != null && this.dFP.auO() != null && this.dFP.auO().azp() == 0) {
                mVar.mW(this.dFP.auO().azx());
            }
        }
        if (com.baidu.tbadk.core.util.v.D(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
                if (iVar instanceof bd) {
                    ((bd) iVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.dGb.b(arrayList, lVar);
        if (this.dGp != null) {
            this.dGp.d(this.dFI, this.bZI, this.dGh, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dGa;
    }

    public void avQ() {
        this.dGb.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dFP.getPageContext(), 1);
        aVar.a(this.dGa);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dFP.getForumName());
        hashMap.put("forum_id", this.dFP.getForumId());
        aVar.setParams(hashMap);
        aVar.aM(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dGj != null) {
            this.dGj.axC();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        if (this.dGj != null) {
            this.dGj.axD();
        }
    }

    public void release() {
        if (this.dpu != null && this.dCE != null) {
            this.dpu.b(this.dCE);
        }
    }

    public ImageView avR() {
        return this.dFU;
    }

    public View avS() {
        if (this.dFV != null) {
            return this.dFV.getView();
        }
        return null;
    }

    public void E(int i, boolean z) {
        if (this.dFV != null) {
            this.dFV.j(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dFP, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dFP.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dGn != null) {
            this.dGn.invalidate();
        }
        if (this.dGb != null) {
            this.dGb.axo();
            this.dGb.notifyDataSetChanged();
        }
        this.dFP.getPageContext().getLayoutMode().aQ(i == 1);
        this.dFP.getPageContext().getLayoutMode().aM(this.dFQ);
        if (this.dFQ != null) {
            com.baidu.tbadk.core.util.aj.g(this.dFQ, d.C0140d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dFP.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.aj.g(this.dGe, d.C0140d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0140d.cp_bg_line_b);
            com.baidu.tbadk.core.util.an.Dd().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
            com.baidu.tbadk.core.util.an.Dd().c(this.dFU, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            if (this.dFV != null) {
                this.dFV.onChangeSkinType(i);
            }
        }
        if (this.dGq != null) {
            this.dGq.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)).mutate());
        }
        if (this.dGr != null) {
            this.dGr.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)).mutate());
        }
        if (this.dpu != null) {
            this.dpu.onChangeSkinType(this.dFP.getPageContext(), i);
        }
        if (this.cbk != null) {
            this.cbk.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0140d.cp_cont_d));
            this.cbk.gx(i);
        }
        awc();
        if (this.dGk != null) {
            this.dGk.onChangeSkinType(i);
        }
        if (this.dGj != null) {
            this.dGj.onChangeSkinType(i);
        }
        if (this.dGp != null) {
            this.dGp.d(this.dFI, this.bZI, this.dGh, true);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.awR != null) {
            com.baidu.tbadk.core.util.aj.g(this.awR, d.C0140d.cp_bg_line_d, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.ceb, d.C0140d.cp_bg_line_c);
        com.baidu.tbadk.core.util.aj.t(this.dGa, d.C0140d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.dGa != null && this.dGa.getFirstVisiblePosition() != 0) {
            this.dGa.setSelection(0);
        }
        this.ceb.setRefreshing(true);
    }

    public void fR(boolean z) {
        if (z) {
            this.ceb.setRefreshing(false);
        } else {
            this.ceb.sW();
        }
    }

    public boolean avT() {
        return this.dFW != null && this.dFZ.getVisibility() == 0;
    }

    public void avU() {
        if (this.dFW != null) {
            this.dFX.setVisibility(0);
            this.dFZ.setVisibility(8);
            this.dFY.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dGE, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bl blVar) {
        if (this.dFW == null) {
            this.dFW = (ViewStub) this.dFP.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.dFW.setVisibility(0);
            this.dFX = (FrameLayout) this.dFP.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.dFY = (TbImageView) this.dFP.mRootView.findViewById(d.g.game_activity_egg);
            this.dFZ = (TbImageView) this.dFP.mRootView.findViewById(d.g.game_activity_egg_s);
            this.dFY.setPageId(this.dFP.getUniqueId());
            this.dFZ.setPageId(this.dFP.getUniqueId());
            this.dFY.setDefaultBgResource(d.C0140d.common_color_10022);
            this.dFY.setDefaultResource(0);
            this.dFZ.setDefaultBgResource(d.C0140d.common_color_10022);
            this.dFZ.setDefaultResource(0);
            this.dFX.setOnClickListener(this.dGd);
        }
        this.dFX.setVisibility(0);
        String AK = blVar.AK();
        String AL = blVar.AL();
        this.dFY.startLoad(AK, 10, false);
        this.dFZ.startLoad(AL, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dGE, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void avV() {
        if (this.dFW != null) {
            this.dFX.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.s avW() {
        return this.dGb;
    }

    public ViewGroup afu() {
        return this.dFQ;
    }

    public View avX() {
        return this.dGf;
    }

    public void mS(int i) {
        if (this.dFS != null) {
            this.dFS.setVisibility(i);
        }
    }

    public void avY() {
        if (com.baidu.tbadk.k.p.Ow().Ox()) {
            int lastVisiblePosition = this.dGa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dGa.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dGO != null) {
                        com.baidu.tbadk.k.k perfLog = oVar.dGO.getPerfLog();
                        perfLog.ij(1000);
                        perfLog.bAA = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dGO.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dGO.startLogPerf();
                    }
                    if (oVar.dGN != null && (oVar.dGN instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dGN;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.ij(1000);
                                perfLog2.bAA = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    public void XO() {
        this.mHasMore = true;
        this.dGa.setNextPage(this.cbk);
        if (this.dGg > 0) {
            this.cbk.gy(this.dGg);
        }
        this.cbk.setOnClickListener(null);
        this.cbk.Eg();
    }

    public void XP() {
        this.mHasMore = false;
        this.dGa.setNextPage(this.cbk);
        if (this.dGg > 0) {
            this.cbk.gy(this.dGg);
        }
        this.cbk.setOnClickListener(null);
        this.cbk.Eh();
        this.cbk.setText(this.dFP.getResources().getString(d.j.list_no_more));
    }

    public void avZ() {
        this.mHasMore = true;
        this.dGa.setNextPage(this.cbk);
        this.cbk.setOnClickListener(this.dGd);
        if (this.dGg > 0) {
            this.cbk.gy(this.dGg);
        }
        this.cbk.Eh();
        this.cbk.setText(this.dFP.getResources().getString(d.j.list_click_load_more));
    }

    public View awa() {
        if (this.cbk == null) {
            return null;
        }
        return this.cbk.getView();
    }

    public void XQ() {
        this.mHasMore = false;
        this.dGa.setNextPage(null);
    }

    public boolean amu() {
        return this.cbk.getView().getParent() != null && this.mHasMore;
    }

    public void mT(int i) {
        this.dGg = i;
    }

    public void mU(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dqU == null) {
                    this.dqU = new CommonTipView(this.dFP.getActivity());
                }
                this.dqU.setText(d.j.frs_login_tip);
                this.dqU.show((FrameLayout) avX(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fS(boolean z) {
        if (this.dGp != null) {
            if (z) {
                this.dGp.iz(false);
                this.dGp.aEa();
                return;
            }
            this.dGp.iz(true);
            this.dGp.d(this.dFI, this.bZI, this.dGh, true);
        }
    }

    public void bu(int i, int i2) {
        if (this.dGp != null) {
            this.dGp.a(i, i2, this.dGh, 1);
        }
    }

    public void bv(int i, int i2) {
        this.dFI = i;
        this.bZI = i2;
    }

    public void fT(boolean z) {
        this.dGh = z;
    }

    private void awb() {
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
            if (this.dGq != null) {
                this.dGq.setAlpha(alpha);
            }
            if (this.dGr != null) {
                this.dGr.setAlpha(alpha);
            }
            if (this.dGe != null) {
                this.dGe.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awc() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cJH) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.aj.a(this.dFU, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.dFV != null) {
                    com.baidu.tbadk.core.util.aj.a(this.dFV.anf(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.dFU, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.dFV != null) {
                    com.baidu.tbadk.core.util.aj.a(this.dFV.anf(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            awb();
        }
    }

    public void fU(boolean z) {
    }

    public void mV(int i) {
        if (this.dGa != null && this.dGa.getChildCount() >= 0) {
            if (this.dGa.getFirstVisiblePosition() > 8) {
                this.dGa.scrollToPosition(8);
            }
            this.dGa.smoothScrollToPosition(i);
        }
    }

    public void awd() {
        a(this.dGt, this.dFP.avn());
        if (this.dGb != null) {
            this.dGb.axt();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dGv == null) {
                this.dGv = new com.baidu.tieba.video.e(this.dFP.getActivity(), this.dFQ);
            }
            this.dGv.g(postWriteCallBackData);
        }
    }

    public void awe() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dGF && this.dFP.getActivity() != null && this.dFP.getPageContext() != null) {
            View view = null;
            if (this.dGa != null && (headerViewsCount = this.dGa.getHeaderViewsCount()) < this.dGa.getChildCount()) {
                view = this.dGa.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.aG(view).cW(0).ak(true).al(false).aj(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.8
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.dFP.getPageContext().getLayoutMode().aM(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int mB() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int mC() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.t(k.this.dFP.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.t(k.this.dFP.getActivity(), d.e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.9
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void bL() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mD = dVar.mD();
                mD.ah(false);
                mD.l(this.dFP.getActivity());
                com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mD != null) {
                            mD.dismiss();
                        }
                    }
                }, 4000L);
                this.dGF = true;
            }
        }
    }
}
