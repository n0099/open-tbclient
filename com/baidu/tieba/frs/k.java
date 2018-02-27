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
    private AppBarLayout awI;
    private PbListView caY;
    private BdSwipeRefreshLayout cdP;
    private i dFD;
    private View dFH;
    private ImageView dFI;
    private com.baidu.tieba.d.b dFJ;
    private ViewStub dFK;
    private com.baidu.tieba.frs.entelechy.a.s dFP;
    private View.OnClickListener dFR;
    private View dFS;
    private View dFT;
    private int dFU;
    private View dFW;
    private com.baidu.tieba.frs.entelechy.b.d dFX;
    private com.baidu.tieba.frs.entelechy.b.c dFY;
    private com.baidu.tieba.frs.g.j dFZ;
    private GifView dGa;
    private TbImageView dGb;
    private HashSet<String> dGc;
    private com.baidu.tieba.play.m dGd;
    private ObservedChangeLinearLayout dGg;
    private com.baidu.tieba.frs.entelechy.b.a dGh;
    private com.baidu.tieba.video.e dGj;
    private AppBarLayoutStickyBehavior dGk;
    private FrsHeaderViewContainer dGl;
    private CollapsingToolbarLayout dGm;
    private com.baidu.tieba.frs.g.f dGq;
    private boolean dGt;
    private NoNetworkView dpi;
    private CommonTipView dqI;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dFC = false;
    private NoPressedRelativeLayout dFE = null;
    private CoordinatorLayout dFF = null;
    private View dFG = null;
    private FrameLayout dFL = null;
    private TbImageView dFM = null;
    private TbImageView dFN = null;
    private BdTypeRecyclerView dFO = null;
    private com.baidu.tbadk.core.dialog.b dFQ = null;
    private NoNetworkView.a dCs = null;
    private boolean mHasMore = true;
    private boolean dFV = false;
    private int dFw = 0;
    private int bZw = 0;
    private View dGe = null;
    private View dGf = null;
    private boolean cJv = false;
    private boolean dGi = true;
    private boolean dGn = true;
    private int dGo = -1;
    private int dGp = -1;
    private AppBarLayout.OnOffsetChangedListener dGr = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dGp != i && Math.abs(i) >= 0 && k.this.avB() != -1) {
                if (Math.abs(i) >= k.this.avB()) {
                    if (k.this.dGn) {
                        k.this.dGn = false;
                        k.this.fM(k.this.dGn);
                    }
                } else if (!k.this.dGn) {
                    k.this.dGn = true;
                    k.this.fM(k.this.dGn);
                }
                int avv = k.this.avv() + k.this.avt() + k.this.avw();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - avv;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dGp - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.mR(Math.abs(avv - totalScrollRange2));
                        if (k.this.dGf != null) {
                            k.this.dGf.setVisibility(0);
                        }
                    } else if (k.this.dGf != null) {
                        if (k.this.avt() != UtilHelper.getStatusBarHeight()) {
                            k.this.mR(0);
                        }
                        k.this.dGf.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null && k.this.cJv) {
                        k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                        k.this.awb();
                    }
                    k.this.dGp = i;
                }
            }
        }
    };
    private Runnable dGs = new Runnable() { // from class: com.baidu.tieba.frs.k.7
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dFK != null) {
                k.this.dFL.setVisibility(0);
                k.this.dFN.setVisibility(0);
                k.this.dFM.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dGu = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.awI.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout avq() {
        return this.dGg;
    }

    public View avr() {
        return this.dGe;
    }

    public View avs() {
        return this.dGf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avt() {
        if (this.dGe == null) {
            return 0;
        }
        return this.dGe.getHeight();
    }

    private int avu() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avv() {
        if (this.dpi == null || com.baidu.adp.lib.util.j.oJ()) {
            return 0;
        }
        return this.dpi.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avw() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(int i) {
        View avr = avr();
        View avs = avs();
        if (UtilHelper.canUseStyleImmersiveSticky() && avr != null && avs != null && avr.getLayoutParams() != null && avs.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = avr.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            avr.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = avs.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            avs.setLayoutParams(layoutParams2);
        }
    }

    public k(i iVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.g.f fVar) {
        this.dFD = null;
        this.dFR = null;
        this.dFU = 0;
        this.dFD = iVar;
        this.dFR = onClickListener;
        a(aVar, z);
        this.dGc = new HashSet<>();
        this.dFU = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dGq = fVar;
    }

    private boolean avx() {
        return this.dGq != null && this.dGq.aAg();
    }

    private void avy() {
        this.dFD.registerListener(this.dGu);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        avy();
        this.dGh = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dFD.getPageContext());
        }
        this.mPullView.setTag(this.dFD.getUniqueId());
        if (this.dFE == null) {
            this.dFE = (NoPressedRelativeLayout) this.dFD.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.t(this.dFE, d.C0141d.cp_bg_line_d);
        if (this.dFG == null) {
            this.dFG = this.dFD.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.dFF == null) {
            this.dFF = (CoordinatorLayout) this.dFD.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.dFT == null) {
            this.dFT = this.dFD.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.dGm == null) {
            this.dGm = (CollapsingToolbarLayout) this.dFD.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.dGl == null) {
            this.dGl = (FrsHeaderViewContainer) this.dFD.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.dGg == null) {
            this.dGg = (ObservedChangeLinearLayout) this.dFD.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.dGg.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.3
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dGm.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dFD.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dFD.avm()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dFS == null) {
            this.dFS = this.dFD.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b awU = aVar.awU();
            if (awU != null) {
                awU.bM(this.dFS);
            }
        }
        if (this.dFH == null) {
            this.dFH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dFH.setOnClickListener(this.dFR);
            this.mBackImageView = (ImageView) this.dFH.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dFI == null) {
            this.dFI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dFI.setOnClickListener(this.dFR);
        }
        if (this.dFJ == null) {
            this.dFJ = new com.baidu.tieba.d.b(this.dFD.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dFJ.getView(), (View.OnClickListener) null);
            this.dFJ.getView().setOnClickListener(this.dFR);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dFD.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
        }
        if (this.cdP == null) {
            this.cdP = (BdSwipeRefreshLayout) this.dFD.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.cdP.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.aj.t(this.cdP, d.C0141d.cp_bg_line_c);
        }
        if (this.dFO == null) {
            this.dFO = (BdTypeRecyclerView) this.dFD.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.dFO.getItemAnimator()).setSupportsChangeAnimations(false);
        this.dFO.setLayoutManager(new LinearLayoutManager(this.dFO.getContext()));
        this.dFO.setScrollable(this.dFD);
        this.dFO.setFadingEdgeLength(0);
        this.dFO.setOverScrollMode(2);
        this.dFE.setBottomOrderView(this.dFO);
        this.dFO.setOnTouchListener(this.dFD.bDk);
        this.dFO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dGd != null) {
                    k.this.dGd.cg(view);
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
        if (this.caY == null) {
            this.caY = new PbListView(this.dFD.getPageContext().getPageActivity());
            this.caY.getView();
        }
        this.caY.gw(d.C0141d.cp_bg_line_e);
        this.caY.setHeight(com.baidu.adp.lib.util.l.t(this.dFD.getActivity(), d.e.tbds182));
        this.caY.Ec();
        this.caY.setTextSize(d.e.tbfontsize33);
        this.caY.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_d));
        this.caY.gv(d.C0141d.cp_cont_e);
        this.dFO.setOnSrollToBottomListener(this.dFD);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dFD.avi();
                if (k.this.dFD != null && k.this.awI != null) {
                    k.this.dFD.avo();
                    k.this.awI.setExpanded(true);
                    if (k.this.dGd != null) {
                        k.this.dGd.d(k.this.dFw, k.this.bZw, false, true);
                    }
                }
            }
        });
        boolean Df = com.baidu.tbadk.core.util.ao.Dd().Df();
        if (this.dFP == null) {
            this.dFP = aVar.a(this.dFD, this.dFO, Df);
            if (this.dFP instanceof com.baidu.tieba.frs.entelechy.a.b) {
                ((com.baidu.tieba.frs.entelechy.a.b) this.dFP).setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
            }
        }
        cQ(false);
        if (!z) {
            if (this.dpi == null) {
                this.dpi = new NoNetworkView(this.dFD.getActivity());
                this.dpi.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dGg.addView(this.dpi);
            }
            if (com.baidu.adp.lib.util.j.ox()) {
                this.dpi.setVisibility(8);
            } else {
                this.dpi.setVisibility(0);
            }
            this.dpi.onChangeSkinType(this.dFD.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        avI();
        if (this.dFX == null) {
            this.dFX = aVar.c(this.dFD, this.dFE);
        }
        if (this.dFY == null) {
            this.dFY = aVar.b(this.dFD, this.dFE);
            fP(true);
        }
        if (this.dGe == null) {
            this.dGe = this.dFD.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.dGf == null) {
            this.dGf = this.dFD.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.dGd == null) {
            this.dGd = new com.baidu.tieba.play.m(this.dFD.getPageContext(), this.dFO);
        }
        this.dGd.setUniqueId(this.dFD.getUniqueId());
        if (this.dFZ == null) {
            this.dFZ = new com.baidu.tieba.frs.g.j(this.dFD, (NavigationBarCoverTip) this.dFD.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.awI == null) {
            this.awI = (AppBarLayout) this.dFD.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.awI.addOnOffsetChangedListener(this.dGr);
            this.dGn = true;
            this.dGo = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.awI.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dGk = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    private void avz() {
        ViewGroup.LayoutParams layoutParams;
        this.cJv = avx();
        if (this.dGl != null && (layoutParams = this.dGl.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cJv) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, avw() + avu(), 0, 0);
            }
            this.dGl.requestLayout();
        }
    }

    public void avA() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dGg != null) {
            avz();
            if (this.cJv) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dGe != null) {
                    this.dGe.setAlpha(1.0f);
                }
                if (this.dGf != null) {
                    this.dGf.setAlpha(1.0f);
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
        if (z && this.dFD != null && this.dFD.auP() != null) {
            this.dFD.auP().aAk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avB() {
        int i;
        if (this.awI == null) {
            return this.dGo;
        }
        if (this.dGo != -1) {
            return this.dGo;
        }
        int childCount = this.awI.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.awI.getChildAt(childCount);
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
        this.dGo = Math.max(0, this.awI.getTotalScrollRange() - Math.abs(i2));
        return this.dGo;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dFW != null && this.dFW.getLayoutParams() != null) {
            this.dFW.getLayoutParams().height = i;
            this.dFW.setLayoutParams(this.dFW.getLayoutParams());
        }
    }

    public void lI(String str) {
        if (this.dFZ != null) {
            this.dFZ.lI(str);
        }
    }

    public View avC() {
        return this.dFW;
    }

    public com.baidu.tieba.play.m avD() {
        return this.dGd;
    }

    public com.baidu.tieba.frs.entelechy.b.c avE() {
        return this.dFY;
    }

    public void fN(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.E(this.dFD.avk().bvz());
        if (this.dFX != null) {
            this.dFX.fN(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d avF() {
        return this.dFX;
    }

    public void y(boolean z, boolean z2) {
        if (this.dGi && this.dFY != null) {
            this.dFY.y(z, z2);
        }
    }

    public void fO(boolean z) {
        this.dGi = z;
        if (!this.dGi && this.dFY != null) {
            this.dFY.y(false, false);
        }
    }

    public void avG() {
        if (this.dGi && this.dFY != null) {
            this.dFY.y(false, false);
        }
        this.dFI.setVisibility(8);
        fN(false);
        this.dFO.setVisibility(8);
        this.dGl.setVisibility(8);
    }

    public void avH() {
        if (this.dGi && this.dFY != null) {
            this.dFY.y(true, false);
        }
        this.dFI.setVisibility(0);
        fN(true);
        this.dFO.setVisibility(0);
        this.dGl.setVisibility(0);
    }

    public void fP(boolean z) {
        if (this.dFY != null) {
            this.dFY.ge(z);
        }
    }

    private void avI() {
        if (this.dGa == null) {
            this.dGa = (GifView) this.dFD.mRootView.findViewById(d.g.gif_real_time);
            this.dGb = (TbImageView) this.dFD.mRootView.findViewById(d.g.tbimg_real_time);
            this.dGb.setPageId(this.dFD.getUniqueId());
            this.dGa.setLayerType(1, null);
            this.dGb.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View avJ() {
        return this.dFH;
    }

    public void h(NoNetworkView.a aVar) {
        this.dCs = aVar;
        if (this.dpi != null) {
            this.dpi.a(this.dCs);
        }
    }

    public void cQ(boolean z) {
        this.dFC = z;
        if (z) {
            if (this.dFY != null) {
                this.dFY.axy();
                return;
            }
            return;
        }
        this.dFO.getAdapter().notifyDataSetChanged();
        if (this.dFY != null) {
            this.dFY.axz();
        }
    }

    public void fQ(boolean z) {
        if (this.dFY != null) {
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
        this.dFO.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.o oVar) {
        this.dFP.setOnAdapterItemClickListener(oVar);
    }

    public void setForumName(String str) {
        this.dFP.setForumName(str);
        this.mForumName = str;
    }

    public void avK() {
        if (this.dFP instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dFP).setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        }
    }

    public void onDestroy() {
        if (this.dGd != null) {
            this.dGd.destroy();
        }
        if (this.dFZ != null) {
            this.dFZ.onDestory();
        }
        this.dFP.onDestory();
        this.dFO.setOnSrollToBottomListener(null);
        this.dFO.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dGs);
        if (this.dqI != null) {
            this.dqI.onDestroy();
        }
        this.dGc.clear();
        if (this.dFX != null) {
            this.dFX.axA();
        }
        if (this.dGj != null) {
            this.dGj.awO();
        }
    }

    public boolean avL() {
        if (this.awI == null || this.dGk == null || !this.dGk.isSticky()) {
            return this.dFX != null && this.dFX.avL();
        }
        if (this.dFO != null) {
            this.dFO.setSelection(0);
        }
        this.dGk.expandedAppBarLayout(this.awI);
        return true;
    }

    public boolean avl() {
        return this.dFC;
    }

    public void aij() {
        this.dFO.setVisibility(0);
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

    public void avM() {
        if (this.dFP != null) {
            this.dFP.notifyDataSetChanged();
        }
    }

    public void amC() {
        if (this.dFP instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dFP).amC();
        }
    }

    private void avN() {
        if (this.dFQ == null && this.dFD.getPageContext() != null) {
            String[] strArr = {this.dFD.getPageContext().getPageActivity().getString(d.j.take_photo), this.dFD.getPageContext().getPageActivity().getString(d.j.album)};
            this.dFQ = new com.baidu.tbadk.core.dialog.b(this.dFD.getPageContext().getPageActivity());
            this.dFQ.dl(this.dFD.getPageContext().getPageActivity().getString(d.j.operation));
            this.dFQ.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.frs.k.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dFD.takePhoto();
                    } else if (i == 1 && k.this.dFD.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.s(k.this.dFD.getPageContext().getPageActivity());
                    }
                }
            });
            this.dFQ.d(this.dFD.getPageContext());
        }
    }

    public void avO() {
        avN();
        if (this.dFQ != null) {
            this.dFQ.AX();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.E(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dFD != null && this.dFD.auN() != null && this.dFD.auN().azo() == 0) {
                mVar.mW(this.dFD.auN().azw());
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
        this.dFP.b(arrayList, lVar);
        if (this.dGd != null) {
            this.dGd.d(this.dFw, this.bZw, this.dFV, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dFO;
    }

    public void avP() {
        this.dFP.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dFD.getPageContext(), 1);
        aVar.a(this.dFO);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dFD.getForumName());
        hashMap.put("forum_id", this.dFD.getForumId());
        aVar.setParams(hashMap);
        aVar.aM(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dFX != null) {
            this.dFX.axB();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        if (this.dFX != null) {
            this.dFX.axC();
        }
    }

    public void release() {
        if (this.dpi != null && this.dCs != null) {
            this.dpi.b(this.dCs);
        }
    }

    public ImageView avQ() {
        return this.dFI;
    }

    public View avR() {
        if (this.dFJ != null) {
            return this.dFJ.getView();
        }
        return null;
    }

    public void E(int i, boolean z) {
        if (this.dFJ != null) {
            this.dFJ.j(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dFD, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dFD.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dGb != null) {
            this.dGb.invalidate();
        }
        if (this.dFP != null) {
            this.dFP.axn();
            this.dFP.notifyDataSetChanged();
        }
        this.dFD.getPageContext().getLayoutMode().aQ(i == 1);
        this.dFD.getPageContext().getLayoutMode().aM(this.dFE);
        if (this.dFE != null) {
            com.baidu.tbadk.core.util.aj.g(this.dFE, d.C0141d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dFD.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.aj.g(this.dFS, d.C0141d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
            com.baidu.tbadk.core.util.an.Dc().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
            com.baidu.tbadk.core.util.an.Dc().c(this.dFI, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            if (this.dFJ != null) {
                this.dFJ.onChangeSkinType(i);
            }
        }
        if (this.dGe != null) {
            this.dGe.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)).mutate());
        }
        if (this.dGf != null) {
            this.dGf.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)).mutate());
        }
        if (this.dpi != null) {
            this.dpi.onChangeSkinType(this.dFD.getPageContext(), i);
        }
        if (this.caY != null) {
            this.caY.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_d));
            this.caY.gx(i);
        }
        awb();
        if (this.dFY != null) {
            this.dFY.onChangeSkinType(i);
        }
        if (this.dFX != null) {
            this.dFX.onChangeSkinType(i);
        }
        if (this.dGd != null) {
            this.dGd.d(this.dFw, this.bZw, this.dFV, true);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.awI != null) {
            com.baidu.tbadk.core.util.aj.g(this.awI, d.C0141d.cp_bg_line_d, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.cdP, d.C0141d.cp_bg_line_c);
        com.baidu.tbadk.core.util.aj.t(this.dFO, d.C0141d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.dFO != null && this.dFO.getFirstVisiblePosition() != 0) {
            this.dFO.setSelection(0);
        }
        this.cdP.setRefreshing(true);
    }

    public void fR(boolean z) {
        if (z) {
            this.cdP.setRefreshing(false);
        } else {
            this.cdP.sW();
        }
    }

    public boolean avS() {
        return this.dFK != null && this.dFN.getVisibility() == 0;
    }

    public void avT() {
        if (this.dFK != null) {
            this.dFL.setVisibility(0);
            this.dFN.setVisibility(8);
            this.dFM.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dGs, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bl blVar) {
        if (this.dFK == null) {
            this.dFK = (ViewStub) this.dFD.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.dFK.setVisibility(0);
            this.dFL = (FrameLayout) this.dFD.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.dFM = (TbImageView) this.dFD.mRootView.findViewById(d.g.game_activity_egg);
            this.dFN = (TbImageView) this.dFD.mRootView.findViewById(d.g.game_activity_egg_s);
            this.dFM.setPageId(this.dFD.getUniqueId());
            this.dFN.setPageId(this.dFD.getUniqueId());
            this.dFM.setDefaultBgResource(d.C0141d.common_color_10022);
            this.dFM.setDefaultResource(0);
            this.dFN.setDefaultBgResource(d.C0141d.common_color_10022);
            this.dFN.setDefaultResource(0);
            this.dFL.setOnClickListener(this.dFR);
        }
        this.dFL.setVisibility(0);
        String AK = blVar.AK();
        String AL = blVar.AL();
        this.dFM.startLoad(AK, 10, false);
        this.dFN.startLoad(AL, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dGs, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void avU() {
        if (this.dFK != null) {
            this.dFL.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.s avV() {
        return this.dFP;
    }

    public ViewGroup aft() {
        return this.dFE;
    }

    public View avW() {
        return this.dFT;
    }

    public void mS(int i) {
        if (this.dFG != null) {
            this.dFG.setVisibility(i);
        }
    }

    public void avX() {
        if (com.baidu.tbadk.k.p.Ov().Ow()) {
            int lastVisiblePosition = this.dFO.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dFO.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dGC != null) {
                        com.baidu.tbadk.k.k perfLog = oVar.dGC.getPerfLog();
                        perfLog.ij(1000);
                        perfLog.bAn = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dGC.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dGC.startLogPerf();
                    }
                    if (oVar.dGB != null && (oVar.dGB instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dGB;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.ij(1000);
                                perfLog2.bAn = true;
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

    public NavigationBar avj() {
        return this.mNavigationBar;
    }

    public void XN() {
        this.mHasMore = true;
        this.dFO.setNextPage(this.caY);
        if (this.dFU > 0) {
            this.caY.gy(this.dFU);
        }
        this.caY.setOnClickListener(null);
        this.caY.Ef();
    }

    public void XO() {
        this.mHasMore = false;
        this.dFO.setNextPage(this.caY);
        if (this.dFU > 0) {
            this.caY.gy(this.dFU);
        }
        this.caY.setOnClickListener(null);
        this.caY.Eg();
        this.caY.setText(this.dFD.getResources().getString(d.j.list_no_more));
    }

    public void avY() {
        this.mHasMore = true;
        this.dFO.setNextPage(this.caY);
        this.caY.setOnClickListener(this.dFR);
        if (this.dFU > 0) {
            this.caY.gy(this.dFU);
        }
        this.caY.Eg();
        this.caY.setText(this.dFD.getResources().getString(d.j.list_click_load_more));
    }

    public View avZ() {
        if (this.caY == null) {
            return null;
        }
        return this.caY.getView();
    }

    public void XP() {
        this.mHasMore = false;
        this.dFO.setNextPage(null);
    }

    public boolean amt() {
        return this.caY.getView().getParent() != null && this.mHasMore;
    }

    public void mT(int i) {
        this.dFU = i;
    }

    public void mU(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dqI == null) {
                    this.dqI = new CommonTipView(this.dFD.getActivity());
                }
                this.dqI.setText(d.j.frs_login_tip);
                this.dqI.show((FrameLayout) avW(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fS(boolean z) {
        if (this.dGd != null) {
            if (z) {
                this.dGd.iz(false);
                this.dGd.aDZ();
                return;
            }
            this.dGd.iz(true);
            this.dGd.d(this.dFw, this.bZw, this.dFV, true);
        }
    }

    public void bu(int i, int i2) {
        if (this.dGd != null) {
            this.dGd.a(i, i2, this.dFV, 1);
        }
    }

    public void bv(int i, int i2) {
        this.dFw = i;
        this.bZw = i2;
    }

    public void fT(boolean z) {
        this.dFV = z;
    }

    private void awa() {
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
            if (this.dGe != null) {
                this.dGe.setAlpha(alpha);
            }
            if (this.dGf != null) {
                this.dGf.setAlpha(alpha);
            }
            if (this.dFS != null) {
                this.dFS.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awb() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cJv) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.aj.a(this.dFI, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.dFJ != null) {
                    com.baidu.tbadk.core.util.aj.a(this.dFJ.ane(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.dFI, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.dFJ != null) {
                    com.baidu.tbadk.core.util.aj.a(this.dFJ.ane(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            awa();
        }
    }

    public void fU(boolean z) {
    }

    public void mV(int i) {
        if (this.dFO != null && this.dFO.getChildCount() >= 0) {
            if (this.dFO.getFirstVisiblePosition() > 8) {
                this.dFO.scrollToPosition(8);
            }
            this.dFO.smoothScrollToPosition(i);
        }
    }

    public void awc() {
        a(this.dGh, this.dFD.avm());
        if (this.dFP != null) {
            this.dFP.axs();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dGj == null) {
                this.dGj = new com.baidu.tieba.video.e(this.dFD.getActivity(), this.dFE);
            }
            this.dGj.g(postWriteCallBackData);
        }
    }

    public void awd() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dGt && this.dFD.getActivity() != null && this.dFD.getPageContext() != null) {
            View view = null;
            if (this.dFO != null && (headerViewsCount = this.dFO.getHeaderViewsCount()) < this.dFO.getChildCount()) {
                view = this.dFO.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.aG(view).cW(0).ak(true).al(false).aj(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.8
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.dFD.getPageContext().getLayoutMode().aM(inflate);
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
                        return com.baidu.adp.lib.util.l.t(k.this.dFD.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.t(k.this.dFD.getActivity(), d.e.ds6);
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
                mD.l(this.dFD.getActivity());
                com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mD != null) {
                            mD.dismiss();
                        }
                    }
                }, 4000L);
                this.dGt = true;
            }
        }
    }
}
