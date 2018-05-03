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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.e;
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
public class i {
    private AppBarLayout HR;
    private PbListView blb;
    private BdSwipeRefreshLayout bnR;
    private NoNetworkView cHy;
    private CommonTipView cJk;
    private FrsFragment cYC;
    private View cYG;
    private ImageView cYH;
    private com.baidu.tieba.d.b cYI;
    private ViewStub cYJ;
    private com.baidu.tieba.frs.entelechy.a.q cYO;
    private View.OnClickListener cYQ;
    private View cYR;
    private View cYS;
    private int cYT;
    private View cYV;
    private com.baidu.tieba.frs.entelechy.b.d cYW;
    private com.baidu.tieba.frs.entelechy.b.c cYX;
    private com.baidu.tieba.frs.vc.i cYY;
    private GifView cYZ;
    private TbImageView cZa;
    private HashSet<String> cZb;
    private com.baidu.tieba.play.m cZc;
    private ObservedChangeLinearLayout cZf;
    private com.baidu.tieba.frs.entelechy.b.a cZg;
    private com.baidu.tieba.video.e cZi;
    private AppBarLayoutStickyBehavior cZj;
    private FrsHeaderViewContainer cZk;
    private CollapsingToolbarLayout cZl;
    private com.baidu.tieba.frs.vc.f cZp;
    private boolean cZs;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private int mSkinType;
    private boolean cYB = false;
    private NoPressedRelativeLayout cYD = null;
    private CoordinatorLayout cYE = null;
    private View cYF = null;
    private FrameLayout cYK = null;
    private TbImageView cYL = null;
    private TbImageView cYM = null;
    private BdTypeRecyclerView cYN = null;
    private com.baidu.tbadk.core.dialog.b cYP = null;
    private NoNetworkView.a cVe = null;
    private boolean mHasMore = true;
    private boolean cYU = false;
    private int cYs = 0;
    private int bjz = 0;
    private View cZd = null;
    private View cZe = null;
    private boolean bZF = false;
    private boolean cZh = true;
    private boolean cZm = true;
    private int cZn = -1;
    private int cZo = -1;
    private AppBarLayout.OnOffsetChangedListener cZq = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.i.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i.this.cZo != i && Math.abs(i) >= 0 && i.this.aqa() != -1) {
                if (Math.abs(i) >= i.this.aqa()) {
                    if (i.this.cZm) {
                        i.this.cZm = false;
                        i.this.fr(i.this.cZm);
                    }
                } else if (!i.this.cZm) {
                    i.this.cZm = true;
                    i.this.fr(i.this.cZm);
                }
                int apU = i.this.apU() + i.this.apT() + i.this.apV();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - apU;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && i.this.cZo - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        i.this.ke(Math.abs(apU - totalScrollRange2));
                        if (i.this.cZe != null) {
                            i.this.cZe.setVisibility(0);
                        }
                    } else if (i.this.cZe != null) {
                        if (i.this.apS() != UtilHelper.getStatusBarHeight()) {
                            i.this.ke(0);
                        }
                        i.this.cZe.setVisibility(8);
                    }
                    if (i.this.mNavigationBar != null) {
                        if (i.this.bZF) {
                            i.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            i.this.aqz();
                        } else if (i.this.mNavigationBar.mCenterText != null) {
                            i.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    i.this.cZo = i;
                }
            }
        }
    };
    private Runnable cZr = new Runnable() { // from class: com.baidu.tieba.frs.i.7
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cYJ != null) {
                i.this.cYK.setVisibility(0);
                i.this.cYM.setVisibility(0);
                i.this.cYL.setVisibility(8);
            }
        }
    };
    private CustomMessageListener cZt = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                i.this.HR.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout apP() {
        return this.cZf;
    }

    public View apQ() {
        return this.cZd;
    }

    public View apR() {
        return this.cZe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apS() {
        if (this.cZd == null) {
            return 0;
        }
        return this.cZd.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apT() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apU() {
        if (this.cHy == null || com.baidu.adp.lib.util.j.gP()) {
            return 0;
        }
        return this.cHy.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apV() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ke(int i) {
        View apQ = apQ();
        View apR = apR();
        if (UtilHelper.canUseStyleImmersiveSticky() && apQ != null && apR != null && apQ.getLayoutParams() != null && apR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = apQ.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            apQ.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = apR.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            apR.setLayoutParams(layoutParams2);
        }
    }

    public i(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.cYC = null;
        this.cYQ = null;
        this.cYT = 0;
        this.cYC = frsFragment;
        this.cYQ = onClickListener;
        a(aVar, z);
        this.cZb = new HashSet<>();
        this.cYT = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.cZp = fVar;
    }

    private boolean apW() {
        return this.cZp != null && this.cZp.ave();
    }

    private void apX() {
        this.cYC.registerListener(this.cZt);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        apX();
        this.cZg = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.cYC.getPageContext());
        }
        this.mPullView.setTag(this.cYC.getUniqueId());
        if (this.cYD == null) {
            this.cYD = (NoPressedRelativeLayout) this.cYC.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.ak.j(this.cYD, d.C0126d.cp_bg_line_d);
        if (this.cYF == null) {
            this.cYF = this.cYC.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.cYE == null) {
            this.cYE = (CoordinatorLayout) this.cYC.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.cYS == null) {
            this.cYS = this.cYC.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.cZl == null) {
            this.cZl = (CollapsingToolbarLayout) this.cYC.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.cZk == null) {
            this.cZk = (FrsHeaderViewContainer) this.cYC.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.cZf == null) {
            this.cZf = (ObservedChangeLinearLayout) this.cYC.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.cZf.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.i.3
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view2, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                        i.this.cZl.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cYC.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cYC.apG()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cYR == null) {
            this.cYR = this.cYC.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b arr = aVar.arr();
            if (arr != null) {
                arr.ar(this.cYR);
            }
        }
        if (this.cYG == null) {
            this.cYG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cYG.setOnClickListener(this.cYQ);
            this.mBackImageView = (ImageView) this.cYG.findViewById(d.g.widget_navi_back_button);
        }
        if (this.cYH == null) {
            this.cYH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.cYH.setOnClickListener(this.cYQ);
        }
        if (this.cYI == null) {
            this.cYI = new com.baidu.tieba.d.b(this.cYC.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cYI.getView(), (View.OnClickListener) null);
            this.cYI.getView().setOnClickListener(this.cYQ);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cYC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ak.j(this.mNavigationBar.getBottomLine(), d.C0126d.cp_bg_line_b);
        }
        if (this.bnR == null) {
            this.bnR = (BdSwipeRefreshLayout) this.cYC.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.bnR.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.ak.j(this.bnR, d.C0126d.cp_bg_line_c);
        }
        if (this.cYN == null) {
            this.cYN = (BdTypeRecyclerView) this.cYC.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.cYN.getItemAnimator()).setSupportsChangeAnimations(false);
        this.cYN.setLayoutManager(new LinearLayoutManager(this.cYN.getContext()));
        this.cYN.setScrollable(this.cYC);
        this.cYN.setFadingEdgeLength(0);
        this.cYN.setOverScrollMode(2);
        this.cYD.setBottomOrderView(this.cYN);
        this.cYN.setOnTouchListener(this.cYC.aNK);
        this.cYN.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (i.this.cZc != null) {
                    i.this.cZc.aM(view2);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
            }
        });
        if (this.blb == null) {
            this.blb = new PbListView(this.cYC.getPageContext().getPageActivity());
            this.blb.getView();
        }
        this.blb.du(d.C0126d.cp_bg_line_e);
        this.blb.setHeight(com.baidu.adp.lib.util.l.e(this.cYC.getActivity(), d.e.tbds182));
        this.blb.wO();
        this.blb.setTextSize(d.e.tbfontsize33);
        this.blb.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_d));
        this.blb.dt(d.C0126d.cp_cont_e);
        this.cYN.setOnSrollToBottomListener(this.cYC);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.cYC.apD();
                if (i.this.cYC != null && i.this.HR != null) {
                    i.this.cYC.apI();
                    i.this.HR.setExpanded(true);
                    if (i.this.cZc != null) {
                        i.this.cZc.b(i.this.cYs, i.this.bjz, false, true);
                    }
                }
            }
        });
        boolean vS = com.baidu.tbadk.core.util.ap.vQ().vS();
        if (this.cYO == null) {
            this.cYO = aVar.a(this.cYC, this.cYN, vS);
        }
        ch(false);
        if (!z) {
            if (this.cHy == null) {
                this.cHy = new NoNetworkView(this.cYC.getActivity());
                this.cHy.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.cZf.addView(this.cHy);
            }
            if (com.baidu.adp.lib.util.j.gD()) {
                this.cHy.setVisibility(8);
            } else {
                this.cHy.setVisibility(0);
            }
            this.cHy.onChangeSkinType(this.cYC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aqh();
        if (this.cYW == null) {
            this.cYW = aVar.c(this.cYC, this.cYD);
        }
        if (this.cYX == null) {
            this.cYX = aVar.b(this.cYC, this.cYD);
            fu(true);
        }
        if (this.cZd == null) {
            this.cZd = this.cYC.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.cZe == null) {
            this.cZe = this.cYC.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.cZc == null) {
            this.cZc = new com.baidu.tieba.play.m(this.cYC.getPageContext(), this.cYN);
        }
        this.cZc.setUniqueId(this.cYC.getUniqueId());
        if (this.cYY == null) {
            this.cYY = new com.baidu.tieba.frs.vc.i(this.cYC, (NavigationBarCoverTip) this.cYC.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.HR == null) {
            this.HR = (AppBarLayout) this.cYC.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.HR.addOnOffsetChangedListener(this.cZq);
            this.cZm = true;
            this.cZn = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.HR.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.cZj = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    private void apY() {
        ViewGroup.LayoutParams layoutParams;
        this.bZF = apW();
        if (this.cZk != null && (layoutParams = this.cZk.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.bZF) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, apV() + apT(), 0, 0);
            }
            this.cZk.requestLayout();
        }
    }

    public void apZ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cZf != null) {
            apY();
            if (this.bZF) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.cZd != null) {
                    this.cZd.setAlpha(1.0f);
                }
                if (this.cZe != null) {
                    this.cZe.setAlpha(1.0f);
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
    public void fr(boolean z) {
        if (z && this.cYC != null && this.cYC.apk() != null) {
            this.cYC.apk().avi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aqa() {
        int i;
        if (this.HR == null) {
            return this.cZn;
        }
        if (this.cZn != -1) {
            return this.cZn;
        }
        int childCount = this.HR.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.HR.getChildAt(childCount);
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
        this.cZn = Math.max(0, this.HR.getTotalScrollRange() - Math.abs(i2));
        return this.cZn;
    }

    public void setHeaderViewHeight(int i) {
        if (this.cYV != null && this.cYV.getLayoutParams() != null) {
            this.cYV.getLayoutParams().height = i;
            this.cYV.setLayoutParams(this.cYV.getLayoutParams());
        }
    }

    public void lL(String str) {
        if (this.cYY != null) {
            this.cYY.lL(str);
        }
    }

    public View aqb() {
        return this.cYV;
    }

    public com.baidu.tieba.play.m aqc() {
        return this.cZc;
    }

    public com.baidu.tieba.frs.entelechy.b.c aqd() {
        return this.cYX;
    }

    public void fs(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.w(this.cYC.apE().bqG());
        if (this.cYW != null) {
            this.cYW.fs(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aqe() {
        return this.cYW;
    }

    public void u(boolean z, boolean z2) {
        if (this.cZh && this.cYX != null) {
            this.cYX.u(z, z2);
        }
    }

    public void ft(boolean z) {
        this.cZh = z;
        if (!this.cZh && this.cYX != null) {
            this.cYX.u(false, false);
        }
    }

    public void aqf() {
        if (this.cZh && this.cYX != null) {
            this.cYX.u(false, false);
        }
        this.cYH.setVisibility(8);
        fs(false);
        this.cYN.setVisibility(8);
        this.cZk.setVisibility(8);
    }

    public void aqg() {
        if (this.cZh && this.cYX != null) {
            this.cYX.u(true, false);
        }
        this.cYH.setVisibility(0);
        fs(true);
        this.cYN.setVisibility(0);
        this.cZk.setVisibility(0);
    }

    public void fu(boolean z) {
        if (this.cYX != null) {
            this.cYX.fK(z);
        }
    }

    private void aqh() {
        if (this.cYZ == null) {
            this.cYZ = (GifView) this.cYC.mRootView.findViewById(d.g.gif_real_time);
            this.cZa = (TbImageView) this.cYC.mRootView.findViewById(d.g.tbimg_real_time);
            this.cZa.setPageId(this.cYC.getUniqueId());
            this.cYZ.setLayerType(1, null);
            this.cZa.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aqi() {
        return this.cYG;
    }

    public void h(NoNetworkView.a aVar) {
        this.cVe = aVar;
        if (this.cHy != null) {
            this.cHy.a(this.cVe);
        }
    }

    public void ch(boolean z) {
        this.cYB = z;
        if (z) {
            if (this.cYX != null) {
                this.cYX.arY();
                return;
            }
            return;
        }
        this.cYN.getAdapter().notifyDataSetChanged();
        if (this.cYX != null) {
            this.cYX.arZ();
        }
    }

    public void fv(boolean z) {
        if (this.cYX != null) {
            if (z) {
                u(false, true);
            } else {
                u(false, false);
            }
        }
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(e.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(e.a aVar) {
        this.mPullView.a(aVar);
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.cYN.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.cYO.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.cYO.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.cZc != null) {
            this.cZc.destroy();
        }
        if (this.cYY != null) {
            this.cYY.onDestory();
        }
        this.cYO.onDestory();
        this.cYN.setOnSrollToBottomListener(null);
        this.cYN.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cZr);
        if (this.cJk != null) {
            this.cJk.onDestroy();
        }
        this.cZb.clear();
        if (this.cYW != null) {
            this.cYW.asa();
        }
        if (this.cZi != null) {
            this.cZi.arg();
        }
    }

    public boolean aqj() {
        if (this.HR == null || this.cZj == null || !this.cZj.isSticky()) {
            return this.cYW != null && this.cYW.aqj();
        }
        if (this.cYN != null) {
            this.cYN.setSelection(0);
        }
        this.cZj.expandedAppBarLayout(this.HR);
        return true;
    }

    public boolean apF() {
        return this.cYB;
    }

    public void showListView() {
        this.cYN.setVisibility(0);
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
            com.baidu.tbadk.core.i.pY().cC(str);
        }
    }

    public void aqk() {
        if (this.cYO != null) {
            this.cYO.notifyDataSetChanged();
        }
    }

    public void agD() {
        if (this.cYO instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cYO).agD();
        }
    }

    private void aql() {
        if (this.cYP == null && this.cYC.getPageContext() != null) {
            String[] strArr = {this.cYC.getPageContext().getPageActivity().getString(d.k.take_photo), this.cYC.getPageContext().getPageActivity().getString(d.k.album)};
            this.cYP = new com.baidu.tbadk.core.dialog.b(this.cYC.getPageContext().getPageActivity());
            this.cYP.dd(this.cYC.getPageContext().getPageActivity().getString(d.k.operation));
            this.cYP.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.i.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.cYC.takePhoto();
                    } else if (i == 1 && i.this.cYC.getPageContext() != null) {
                        com.baidu.tbadk.core.util.aj.s(i.this.cYC.getPageContext().getPageActivity());
                    }
                }
            });
            this.cYP.d(this.cYC.getPageContext());
        }
    }

    public void aqm() {
        aql();
        if (this.cYP != null) {
            this.cYP.tG();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.w(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.cYC != null && this.cYC.aph() != null && this.cYC.aph().auf() == 0) {
                kVar.kj(this.cYC.aph().aun());
            }
        }
        if (com.baidu.tbadk.core.util.v.v(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h hVar = arrayList.get(i2);
                if (hVar instanceof bd) {
                    ((bd) hVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.cYO.b(arrayList, lVar);
        if (this.cZc != null) {
            this.cZc.b(this.cYs, this.bjz, this.cYU, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.cYN;
    }

    public void aqn() {
        this.cYO.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cYC.getPageContext(), 1);
        aVar.a(this.cYN);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cYC.getForumName());
        hashMap.put("forum_id", this.cYC.getForumId());
        aVar.setParams(hashMap);
        aVar.H(wVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.cYW != null) {
            this.cYW.asb();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        if (this.cYW != null) {
            this.cYW.asc();
        }
    }

    public void release() {
        if (this.cHy != null && this.cVe != null) {
            this.cHy.b(this.cVe);
        }
    }

    public ImageView aqo() {
        return this.cYH;
    }

    public View aqp() {
        if (this.cYI != null) {
            return this.cYI.getView();
        }
        return null;
    }

    public void q(int i, boolean z) {
        if (this.cYI != null) {
            this.cYI.f(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cYC, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cYC.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.cZa != null) {
            this.cZa.invalidate();
        }
        if (this.cYO != null) {
            this.cYO.arN();
            this.cYO.notifyDataSetChanged();
        }
        this.cYC.getPageContext().getLayoutMode().setNightMode(i == 1);
        this.cYC.getPageContext().getLayoutMode().u(this.cYD);
        if (this.cYD != null) {
            com.baidu.tbadk.core.util.ak.e(this.cYD, d.C0126d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.ak.cO(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.cYC.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.ak.e(this.cYR, d.C0126d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ak.j(this.mNavigationBar.getBottomLine(), d.C0126d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ao.vP().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
            com.baidu.tbadk.core.util.ao.vP().c(this.cYH, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            if (this.cYI != null) {
                this.cYI.onChangeSkinType(i);
            }
        }
        if (this.cZd != null) {
            this.cZd.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ak.cO(d.f.s_navbar_bg)).mutate());
        }
        if (this.cZe != null) {
            this.cZe.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ak.cO(d.f.s_navbar_bg)).mutate());
        }
        if (this.cHy != null) {
            this.cHy.onChangeSkinType(this.cYC.getPageContext(), i);
        }
        if (this.blb != null) {
            this.blb.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_d));
            this.blb.dv(i);
        }
        aqz();
        if (this.cYX != null) {
            this.cYX.onChangeSkinType(i);
        }
        if (this.cYW != null) {
            this.cYW.onChangeSkinType(i);
        }
        if (this.cZc != null) {
            this.cZc.b(this.cYs, this.bjz, this.cYU, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        if (this.HR != null) {
            com.baidu.tbadk.core.util.ak.e(this.HR, d.C0126d.cp_bg_line_d, i);
        }
        com.baidu.tbadk.core.util.ak.j(this.bnR, d.C0126d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ak.j(this.cYN, d.C0126d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.cYN != null && this.cYN.getFirstVisiblePosition() != 0) {
            this.cYN.setSelection(0);
        }
        if (this.HR != null) {
            this.HR.setExpanded(true);
        }
        this.bnR.setRefreshing(true);
    }

    public void fw(boolean z) {
        if (z) {
            this.bnR.setRefreshing(false);
        } else {
            this.bnR.li();
        }
    }

    public boolean aqq() {
        return this.cYJ != null && this.cYM.getVisibility() == 0;
    }

    public void aqr() {
        if (this.cYJ != null) {
            this.cYK.setVisibility(0);
            this.cYM.setVisibility(8);
            this.cYL.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.cZr, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bk bkVar) {
        if (this.cYJ == null) {
            this.cYJ = (ViewStub) this.cYC.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.cYJ.setVisibility(0);
            this.cYK = (FrameLayout) this.cYC.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.cYL = (TbImageView) this.cYC.mRootView.findViewById(d.g.game_activity_egg);
            this.cYM = (TbImageView) this.cYC.mRootView.findViewById(d.g.game_activity_egg_s);
            this.cYL.setPageId(this.cYC.getUniqueId());
            this.cYM.setPageId(this.cYC.getUniqueId());
            this.cYL.setDefaultBgResource(d.C0126d.common_color_10022);
            this.cYL.setDefaultResource(0);
            this.cYM.setDefaultBgResource(d.C0126d.common_color_10022);
            this.cYM.setDefaultResource(0);
            this.cYK.setOnClickListener(this.cYQ);
        }
        this.cYK.setVisibility(0);
        String tt = bkVar.tt();
        String tu = bkVar.tu();
        this.cYL.startLoad(tt, 10, false);
        this.cYM.startLoad(tu, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cZr, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void aqs() {
        if (this.cYJ != null) {
            this.cYK.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aqt() {
        return this.cYO;
    }

    public ViewGroup ZG() {
        return this.cYD;
    }

    public View aqu() {
        return this.cYS;
    }

    public void kf(int i) {
        if (this.cYF != null) {
            this.cYF.setVisibility(i);
        }
    }

    public void aqv() {
        if (com.baidu.tbadk.k.p.Ha().Hb()) {
            int lastVisiblePosition = this.cYN.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cYN.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.cZB != null) {
                        com.baidu.tbadk.k.k perfLog = mVar.cZB.getPerfLog();
                        perfLog.fi(1000);
                        perfLog.aKM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.cZB.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.cZB.startLogPerf();
                    }
                    if (mVar.cZA != null && (mVar.cZA instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.cZA;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fi(1000);
                                perfLog2.aKM = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar Rg() {
        return this.mNavigationBar;
    }

    public void Qo() {
        this.mHasMore = true;
        this.cYN.setNextPage(this.blb);
        if (this.cYT > 0) {
            this.blb.dw(this.cYT);
        }
        this.blb.setOnClickListener(null);
        this.blb.wR();
    }

    public void Qp() {
        this.mHasMore = false;
        this.cYN.setNextPage(this.blb);
        if (this.cYT > 0) {
            this.blb.dw(this.cYT);
        }
        this.blb.setOnClickListener(null);
        this.blb.wS();
        this.blb.setText(this.cYC.getResources().getString(d.k.list_no_more));
    }

    public void aqw() {
        this.mHasMore = true;
        this.cYN.setNextPage(this.blb);
        this.blb.setOnClickListener(this.cYQ);
        if (this.cYT > 0) {
            this.blb.dw(this.cYT);
        }
        this.blb.wS();
        this.blb.setText(this.cYC.getResources().getString(d.k.list_click_load_more));
    }

    public View aqx() {
        if (this.blb == null) {
            return null;
        }
        return this.blb.getView();
    }

    public void Qq() {
        this.mHasMore = false;
        this.cYN.setNextPage(null);
    }

    public boolean agu() {
        return this.blb.getView().getParent() != null && this.mHasMore;
    }

    public void kg(int i) {
        this.cYT = i;
    }

    public void kh(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cJk == null) {
                    this.cJk = new CommonTipView(this.cYC.getActivity());
                }
                this.cJk.setText(d.k.frs_login_tip);
                this.cJk.show((FrameLayout) aqu(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fx(boolean z) {
        if (this.cZc != null) {
            if (z) {
                this.cZc.ic(false);
                this.cZc.aza();
                return;
            }
            this.cZc.ic(true);
            this.cZc.b(this.cYs, this.bjz, this.cYU, true);
        }
    }

    public void ax(int i, int i2) {
        if (this.cZc != null) {
            this.cZc.a(i, i2, this.cYU, 1);
        }
    }

    public void ay(int i, int i2) {
        this.cYs = i;
        this.bjz = i2;
    }

    public void fy(boolean z) {
        this.cYU = z;
    }

    private void aqy() {
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
            if (this.cZd != null) {
                this.cZd.setAlpha(alpha);
            }
            if (this.cZe != null) {
                this.cZe.setAlpha(alpha);
            }
            if (this.cYR != null) {
                this.cYR.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqz() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.bZF) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.ak.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.ak.a(this.cYH, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.cYI != null) {
                    com.baidu.tbadk.core.util.ak.a(this.cYI.ahd(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.ak.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.ak.a(this.cYH, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.cYI != null) {
                    com.baidu.tbadk.core.util.ak.a(this.cYI.ahd(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            aqy();
        }
    }

    public void fz(boolean z) {
    }

    public void ki(int i) {
        if (this.cYN != null && this.cYN.getChildCount() >= 0) {
            if (this.cYN.getFirstVisiblePosition() > 8) {
                this.cYN.scrollToPosition(8);
            }
            this.cYN.smoothScrollToPosition(i);
        }
    }

    public void aqA() {
        a(this.cZg, this.cYC.apG());
        if (this.cYO != null) {
            this.cYO.arR();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.cZi == null) {
                this.cZi = new com.baidu.tieba.video.e(this.cYC.getActivity(), this.cYD);
            }
            this.cZi.h(postWriteCallBackData);
        }
    }

    public void aqB() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.cZs && this.cYC.getActivity() != null && this.cYC.getPageContext() != null) {
            View view2 = null;
            if (this.cYN != null && (headerViewsCount = this.cYN.getHeaderViewsCount()) < this.cYN.getChildCount()) {
                view2 = this.cYN.getChildAt(headerViewsCount);
            }
            if (view2 != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view2).W(0).D(true).E(false).C(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.i.8
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.i.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.k.frs_video_activity_guide_tip);
                        i.this.cYC.getPageContext().getLayoutMode().u(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eF() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int eG() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.e(i.this.cYC.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.e(i.this.cYC.getActivity(), d.e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.i.9
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c eH = dVar.eH();
                eH.A(false);
                eH.l(this.cYC.getActivity());
                com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eH != null) {
                            eH.dismiss();
                        }
                    }
                }, 4000L);
                this.cZs = true;
            }
        }
    }
}
