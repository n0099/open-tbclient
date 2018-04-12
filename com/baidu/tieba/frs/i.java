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
    private NoNetworkView cHB;
    private CommonTipView cJn;
    private FrsFragment cYF;
    private View cYJ;
    private ImageView cYK;
    private com.baidu.tieba.d.b cYL;
    private ViewStub cYM;
    private com.baidu.tieba.frs.entelechy.a.q cYR;
    private View.OnClickListener cYT;
    private View cYU;
    private View cYV;
    private int cYW;
    private View cYY;
    private com.baidu.tieba.frs.entelechy.b.d cYZ;
    private com.baidu.tieba.frs.entelechy.b.c cZa;
    private com.baidu.tieba.frs.vc.i cZb;
    private GifView cZc;
    private TbImageView cZd;
    private HashSet<String> cZe;
    private com.baidu.tieba.play.m cZf;
    private ObservedChangeLinearLayout cZi;
    private com.baidu.tieba.frs.entelechy.b.a cZj;
    private com.baidu.tieba.video.e cZl;
    private AppBarLayoutStickyBehavior cZm;
    private FrsHeaderViewContainer cZn;
    private CollapsingToolbarLayout cZo;
    private com.baidu.tieba.frs.vc.f cZs;
    private boolean cZv;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private int mSkinType;
    private boolean cYE = false;
    private NoPressedRelativeLayout cYG = null;
    private CoordinatorLayout cYH = null;
    private View cYI = null;
    private FrameLayout cYN = null;
    private TbImageView cYO = null;
    private TbImageView cYP = null;
    private BdTypeRecyclerView cYQ = null;
    private com.baidu.tbadk.core.dialog.b cYS = null;
    private NoNetworkView.a cVh = null;
    private boolean mHasMore = true;
    private boolean cYX = false;
    private int cYv = 0;
    private int bjz = 0;
    private View cZg = null;
    private View cZh = null;
    private boolean bZI = false;
    private boolean cZk = true;
    private boolean cZp = true;
    private int cZq = -1;
    private int cZr = -1;
    private AppBarLayout.OnOffsetChangedListener cZt = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.i.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i.this.cZr != i && Math.abs(i) >= 0 && i.this.aqa() != -1) {
                if (Math.abs(i) >= i.this.aqa()) {
                    if (i.this.cZp) {
                        i.this.cZp = false;
                        i.this.fr(i.this.cZp);
                    }
                } else if (!i.this.cZp) {
                    i.this.cZp = true;
                    i.this.fr(i.this.cZp);
                }
                int apU = i.this.apU() + i.this.apT() + i.this.apV();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - apU;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && i.this.cZr - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        i.this.kf(Math.abs(apU - totalScrollRange2));
                        if (i.this.cZh != null) {
                            i.this.cZh.setVisibility(0);
                        }
                    } else if (i.this.cZh != null) {
                        if (i.this.apS() != UtilHelper.getStatusBarHeight()) {
                            i.this.kf(0);
                        }
                        i.this.cZh.setVisibility(8);
                    }
                    if (i.this.mNavigationBar != null) {
                        if (i.this.bZI) {
                            i.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            i.this.aqz();
                        } else if (i.this.mNavigationBar.mCenterText != null) {
                            i.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    i.this.cZr = i;
                }
            }
        }
    };
    private Runnable cZu = new Runnable() { // from class: com.baidu.tieba.frs.i.7
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cYM != null) {
                i.this.cYN.setVisibility(0);
                i.this.cYP.setVisibility(0);
                i.this.cYO.setVisibility(8);
            }
        }
    };
    private CustomMessageListener cZw = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                i.this.HR.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout apP() {
        return this.cZi;
    }

    public View apQ() {
        return this.cZg;
    }

    public View apR() {
        return this.cZh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apS() {
        if (this.cZg == null) {
            return 0;
        }
        return this.cZg.getHeight();
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
        if (this.cHB == null || com.baidu.adp.lib.util.j.gP()) {
            return 0;
        }
        return this.cHB.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apV() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(int i) {
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
        this.cYF = null;
        this.cYT = null;
        this.cYW = 0;
        this.cYF = frsFragment;
        this.cYT = onClickListener;
        a(aVar, z);
        this.cZe = new HashSet<>();
        this.cYW = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.cZs = fVar;
    }

    private boolean apW() {
        return this.cZs != null && this.cZs.ave();
    }

    private void apX() {
        this.cYF.registerListener(this.cZw);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        apX();
        this.cZj = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.cYF.getPageContext());
        }
        this.mPullView.setTag(this.cYF.getUniqueId());
        if (this.cYG == null) {
            this.cYG = (NoPressedRelativeLayout) this.cYF.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.ak.j(this.cYG, d.C0126d.cp_bg_line_d);
        if (this.cYI == null) {
            this.cYI = this.cYF.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.cYH == null) {
            this.cYH = (CoordinatorLayout) this.cYF.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.cYV == null) {
            this.cYV = this.cYF.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.cZo == null) {
            this.cZo = (CollapsingToolbarLayout) this.cYF.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.cZn == null) {
            this.cZn = (FrsHeaderViewContainer) this.cYF.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.cZi == null) {
            this.cZi = (ObservedChangeLinearLayout) this.cYF.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.cZi.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.i.3
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view2, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                        i.this.cZo.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cYF.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cYF.apG()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cYU == null) {
            this.cYU = this.cYF.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b arr = aVar.arr();
            if (arr != null) {
                arr.ar(this.cYU);
            }
        }
        if (this.cYJ == null) {
            this.cYJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cYJ.setOnClickListener(this.cYT);
            this.mBackImageView = (ImageView) this.cYJ.findViewById(d.g.widget_navi_back_button);
        }
        if (this.cYK == null) {
            this.cYK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.cYK.setOnClickListener(this.cYT);
        }
        if (this.cYL == null) {
            this.cYL = new com.baidu.tieba.d.b(this.cYF.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cYL.getView(), (View.OnClickListener) null);
            this.cYL.getView().setOnClickListener(this.cYT);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cYF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ak.j(this.mNavigationBar.getBottomLine(), d.C0126d.cp_bg_line_b);
        }
        if (this.bnR == null) {
            this.bnR = (BdSwipeRefreshLayout) this.cYF.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.bnR.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.ak.j(this.bnR, d.C0126d.cp_bg_line_c);
        }
        if (this.cYQ == null) {
            this.cYQ = (BdTypeRecyclerView) this.cYF.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.cYQ.getItemAnimator()).setSupportsChangeAnimations(false);
        this.cYQ.setLayoutManager(new LinearLayoutManager(this.cYQ.getContext()));
        this.cYQ.setScrollable(this.cYF);
        this.cYQ.setFadingEdgeLength(0);
        this.cYQ.setOverScrollMode(2);
        this.cYG.setBottomOrderView(this.cYQ);
        this.cYQ.setOnTouchListener(this.cYF.aNK);
        this.cYQ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (i.this.cZf != null) {
                    i.this.cZf.aM(view2);
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
            this.blb = new PbListView(this.cYF.getPageContext().getPageActivity());
            this.blb.getView();
        }
        this.blb.dv(d.C0126d.cp_bg_line_e);
        this.blb.setHeight(com.baidu.adp.lib.util.l.e(this.cYF.getActivity(), d.e.tbds182));
        this.blb.wO();
        this.blb.setTextSize(d.e.tbfontsize33);
        this.blb.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_d));
        this.blb.du(d.C0126d.cp_cont_e);
        this.cYQ.setOnSrollToBottomListener(this.cYF);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.cYF.apD();
                if (i.this.cYF != null && i.this.HR != null) {
                    i.this.cYF.apI();
                    i.this.HR.setExpanded(true);
                    if (i.this.cZf != null) {
                        i.this.cZf.b(i.this.cYv, i.this.bjz, false, true);
                    }
                }
            }
        });
        boolean vS = com.baidu.tbadk.core.util.ap.vQ().vS();
        if (this.cYR == null) {
            this.cYR = aVar.a(this.cYF, this.cYQ, vS);
        }
        ch(false);
        if (!z) {
            if (this.cHB == null) {
                this.cHB = new NoNetworkView(this.cYF.getActivity());
                this.cHB.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.cZi.addView(this.cHB);
            }
            if (com.baidu.adp.lib.util.j.gD()) {
                this.cHB.setVisibility(8);
            } else {
                this.cHB.setVisibility(0);
            }
            this.cHB.onChangeSkinType(this.cYF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aqh();
        if (this.cYZ == null) {
            this.cYZ = aVar.c(this.cYF, this.cYG);
        }
        if (this.cZa == null) {
            this.cZa = aVar.b(this.cYF, this.cYG);
            fu(true);
        }
        if (this.cZg == null) {
            this.cZg = this.cYF.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.cZh == null) {
            this.cZh = this.cYF.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.cZf == null) {
            this.cZf = new com.baidu.tieba.play.m(this.cYF.getPageContext(), this.cYQ);
        }
        this.cZf.setUniqueId(this.cYF.getUniqueId());
        if (this.cZb == null) {
            this.cZb = new com.baidu.tieba.frs.vc.i(this.cYF, (NavigationBarCoverTip) this.cYF.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.HR == null) {
            this.HR = (AppBarLayout) this.cYF.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.HR.addOnOffsetChangedListener(this.cZt);
            this.cZp = true;
            this.cZq = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.HR.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.cZm = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    private void apY() {
        ViewGroup.LayoutParams layoutParams;
        this.bZI = apW();
        if (this.cZn != null && (layoutParams = this.cZn.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.bZI) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, apV() + apT(), 0, 0);
            }
            this.cZn.requestLayout();
        }
    }

    public void apZ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cZi != null) {
            apY();
            if (this.bZI) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.cZg != null) {
                    this.cZg.setAlpha(1.0f);
                }
                if (this.cZh != null) {
                    this.cZh.setAlpha(1.0f);
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
        if (z && this.cYF != null && this.cYF.apk() != null) {
            this.cYF.apk().avi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aqa() {
        int i;
        if (this.HR == null) {
            return this.cZq;
        }
        if (this.cZq != -1) {
            return this.cZq;
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
        this.cZq = Math.max(0, this.HR.getTotalScrollRange() - Math.abs(i2));
        return this.cZq;
    }

    public void setHeaderViewHeight(int i) {
        if (this.cYY != null && this.cYY.getLayoutParams() != null) {
            this.cYY.getLayoutParams().height = i;
            this.cYY.setLayoutParams(this.cYY.getLayoutParams());
        }
    }

    public void lL(String str) {
        if (this.cZb != null) {
            this.cZb.lL(str);
        }
    }

    public View aqb() {
        return this.cYY;
    }

    public com.baidu.tieba.play.m aqc() {
        return this.cZf;
    }

    public com.baidu.tieba.frs.entelechy.b.c aqd() {
        return this.cZa;
    }

    public void fs(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.w(this.cYF.apE().bqG());
        if (this.cYZ != null) {
            this.cYZ.fs(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aqe() {
        return this.cYZ;
    }

    public void u(boolean z, boolean z2) {
        if (this.cZk && this.cZa != null) {
            this.cZa.u(z, z2);
        }
    }

    public void ft(boolean z) {
        this.cZk = z;
        if (!this.cZk && this.cZa != null) {
            this.cZa.u(false, false);
        }
    }

    public void aqf() {
        if (this.cZk && this.cZa != null) {
            this.cZa.u(false, false);
        }
        this.cYK.setVisibility(8);
        fs(false);
        this.cYQ.setVisibility(8);
        this.cZn.setVisibility(8);
    }

    public void aqg() {
        if (this.cZk && this.cZa != null) {
            this.cZa.u(true, false);
        }
        this.cYK.setVisibility(0);
        fs(true);
        this.cYQ.setVisibility(0);
        this.cZn.setVisibility(0);
    }

    public void fu(boolean z) {
        if (this.cZa != null) {
            this.cZa.fK(z);
        }
    }

    private void aqh() {
        if (this.cZc == null) {
            this.cZc = (GifView) this.cYF.mRootView.findViewById(d.g.gif_real_time);
            this.cZd = (TbImageView) this.cYF.mRootView.findViewById(d.g.tbimg_real_time);
            this.cZd.setPageId(this.cYF.getUniqueId());
            this.cZc.setLayerType(1, null);
            this.cZd.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aqi() {
        return this.cYJ;
    }

    public void h(NoNetworkView.a aVar) {
        this.cVh = aVar;
        if (this.cHB != null) {
            this.cHB.a(this.cVh);
        }
    }

    public void ch(boolean z) {
        this.cYE = z;
        if (z) {
            if (this.cZa != null) {
                this.cZa.arY();
                return;
            }
            return;
        }
        this.cYQ.getAdapter().notifyDataSetChanged();
        if (this.cZa != null) {
            this.cZa.arZ();
        }
    }

    public void fv(boolean z) {
        if (this.cZa != null) {
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
        this.cYQ.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.cYR.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.cYR.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.cZf != null) {
            this.cZf.destroy();
        }
        if (this.cZb != null) {
            this.cZb.onDestory();
        }
        this.cYR.onDestory();
        this.cYQ.setOnSrollToBottomListener(null);
        this.cYQ.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.cZu);
        if (this.cJn != null) {
            this.cJn.onDestroy();
        }
        this.cZe.clear();
        if (this.cYZ != null) {
            this.cYZ.asa();
        }
        if (this.cZl != null) {
            this.cZl.arg();
        }
    }

    public boolean aqj() {
        if (this.HR == null || this.cZm == null || !this.cZm.isSticky()) {
            return this.cYZ != null && this.cYZ.aqj();
        }
        if (this.cYQ != null) {
            this.cYQ.setSelection(0);
        }
        this.cZm.expandedAppBarLayout(this.HR);
        return true;
    }

    public boolean apF() {
        return this.cYE;
    }

    public void showListView() {
        this.cYQ.setVisibility(0);
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
        if (this.cYR != null) {
            this.cYR.notifyDataSetChanged();
        }
    }

    public void agD() {
        if (this.cYR instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cYR).agD();
        }
    }

    private void aql() {
        if (this.cYS == null && this.cYF.getPageContext() != null) {
            String[] strArr = {this.cYF.getPageContext().getPageActivity().getString(d.k.take_photo), this.cYF.getPageContext().getPageActivity().getString(d.k.album)};
            this.cYS = new com.baidu.tbadk.core.dialog.b(this.cYF.getPageContext().getPageActivity());
            this.cYS.dd(this.cYF.getPageContext().getPageActivity().getString(d.k.operation));
            this.cYS.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.i.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.cYF.takePhoto();
                    } else if (i == 1 && i.this.cYF.getPageContext() != null) {
                        com.baidu.tbadk.core.util.aj.s(i.this.cYF.getPageContext().getPageActivity());
                    }
                }
            });
            this.cYS.d(this.cYF.getPageContext());
        }
    }

    public void aqm() {
        aql();
        if (this.cYS != null) {
            this.cYS.tG();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.w(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.cYF != null && this.cYF.aph() != null && this.cYF.aph().auf() == 0) {
                kVar.kk(this.cYF.aph().aun());
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
        this.cYR.b(arrayList, lVar);
        if (this.cZf != null) {
            this.cZf.b(this.cYv, this.bjz, this.cYX, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.cYQ;
    }

    public void aqn() {
        this.cYR.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cYF.getPageContext(), 1);
        aVar.a(this.cYQ);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cYF.getForumName());
        hashMap.put("forum_id", this.cYF.getForumId());
        aVar.setParams(hashMap);
        aVar.H(wVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.cYZ != null) {
            this.cYZ.asb();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        if (this.cYZ != null) {
            this.cYZ.asc();
        }
    }

    public void release() {
        if (this.cHB != null && this.cVh != null) {
            this.cHB.b(this.cVh);
        }
    }

    public ImageView aqo() {
        return this.cYK;
    }

    public View aqp() {
        if (this.cYL != null) {
            return this.cYL.getView();
        }
        return null;
    }

    public void q(int i, boolean z) {
        if (this.cYL != null) {
            this.cYL.f(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cYF, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cYF.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.cZd != null) {
            this.cZd.invalidate();
        }
        if (this.cYR != null) {
            this.cYR.arN();
            this.cYR.notifyDataSetChanged();
        }
        this.cYF.getPageContext().getLayoutMode().setNightMode(i == 1);
        this.cYF.getPageContext().getLayoutMode().u(this.cYG);
        if (this.cYG != null) {
            com.baidu.tbadk.core.util.ak.e(this.cYG, d.C0126d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.ak.cP(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.cYF.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.ak.e(this.cYU, d.C0126d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ak.j(this.mNavigationBar.getBottomLine(), d.C0126d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ao.vP().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
            com.baidu.tbadk.core.util.ao.vP().c(this.cYK, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            if (this.cYL != null) {
                this.cYL.onChangeSkinType(i);
            }
        }
        if (this.cZg != null) {
            this.cZg.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ak.cP(d.f.s_navbar_bg)).mutate());
        }
        if (this.cZh != null) {
            this.cZh.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ak.cP(d.f.s_navbar_bg)).mutate());
        }
        if (this.cHB != null) {
            this.cHB.onChangeSkinType(this.cYF.getPageContext(), i);
        }
        if (this.blb != null) {
            this.blb.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_d));
            this.blb.dw(i);
        }
        aqz();
        if (this.cZa != null) {
            this.cZa.onChangeSkinType(i);
        }
        if (this.cYZ != null) {
            this.cYZ.onChangeSkinType(i);
        }
        if (this.cZf != null) {
            this.cZf.b(this.cYv, this.bjz, this.cYX, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.HR != null) {
            com.baidu.tbadk.core.util.ak.e(this.HR, d.C0126d.cp_bg_line_d, i);
        }
        com.baidu.tbadk.core.util.ak.j(this.bnR, d.C0126d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ak.j(this.cYQ, d.C0126d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.cYQ != null && this.cYQ.getFirstVisiblePosition() != 0) {
            this.cYQ.setSelection(0);
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
        return this.cYM != null && this.cYP.getVisibility() == 0;
    }

    public void aqr() {
        if (this.cYM != null) {
            this.cYN.setVisibility(0);
            this.cYP.setVisibility(8);
            this.cYO.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.cZu, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bk bkVar) {
        if (this.cYM == null) {
            this.cYM = (ViewStub) this.cYF.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.cYM.setVisibility(0);
            this.cYN = (FrameLayout) this.cYF.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.cYO = (TbImageView) this.cYF.mRootView.findViewById(d.g.game_activity_egg);
            this.cYP = (TbImageView) this.cYF.mRootView.findViewById(d.g.game_activity_egg_s);
            this.cYO.setPageId(this.cYF.getUniqueId());
            this.cYP.setPageId(this.cYF.getUniqueId());
            this.cYO.setDefaultBgResource(d.C0126d.common_color_10022);
            this.cYO.setDefaultResource(0);
            this.cYP.setDefaultBgResource(d.C0126d.common_color_10022);
            this.cYP.setDefaultResource(0);
            this.cYN.setOnClickListener(this.cYT);
        }
        this.cYN.setVisibility(0);
        String tt = bkVar.tt();
        String tu = bkVar.tu();
        this.cYO.startLoad(tt, 10, false);
        this.cYP.startLoad(tu, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.cZu, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void aqs() {
        if (this.cYM != null) {
            this.cYN.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aqt() {
        return this.cYR;
    }

    public ViewGroup ZG() {
        return this.cYG;
    }

    public View aqu() {
        return this.cYV;
    }

    public void kg(int i) {
        if (this.cYI != null) {
            this.cYI.setVisibility(i);
        }
    }

    public void aqv() {
        if (com.baidu.tbadk.k.p.Ha().Hb()) {
            int lastVisiblePosition = this.cYQ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cYQ.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.cZE != null) {
                        com.baidu.tbadk.k.k perfLog = mVar.cZE.getPerfLog();
                        perfLog.fj(1000);
                        perfLog.aKM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.cZE.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.cZE.startLogPerf();
                    }
                    if (mVar.cZD != null && (mVar.cZD instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.cZD;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fj(1000);
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
        this.cYQ.setNextPage(this.blb);
        if (this.cYW > 0) {
            this.blb.dx(this.cYW);
        }
        this.blb.setOnClickListener(null);
        this.blb.wR();
    }

    public void Qp() {
        this.mHasMore = false;
        this.cYQ.setNextPage(this.blb);
        if (this.cYW > 0) {
            this.blb.dx(this.cYW);
        }
        this.blb.setOnClickListener(null);
        this.blb.wS();
        this.blb.setText(this.cYF.getResources().getString(d.k.list_no_more));
    }

    public void aqw() {
        this.mHasMore = true;
        this.cYQ.setNextPage(this.blb);
        this.blb.setOnClickListener(this.cYT);
        if (this.cYW > 0) {
            this.blb.dx(this.cYW);
        }
        this.blb.wS();
        this.blb.setText(this.cYF.getResources().getString(d.k.list_click_load_more));
    }

    public View aqx() {
        if (this.blb == null) {
            return null;
        }
        return this.blb.getView();
    }

    public void Qq() {
        this.mHasMore = false;
        this.cYQ.setNextPage(null);
    }

    public boolean agu() {
        return this.blb.getView().getParent() != null && this.mHasMore;
    }

    public void kh(int i) {
        this.cYW = i;
    }

    public void ki(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cJn == null) {
                    this.cJn = new CommonTipView(this.cYF.getActivity());
                }
                this.cJn.setText(d.k.frs_login_tip);
                this.cJn.show((FrameLayout) aqu(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fx(boolean z) {
        if (this.cZf != null) {
            if (z) {
                this.cZf.ic(false);
                this.cZf.aza();
                return;
            }
            this.cZf.ic(true);
            this.cZf.b(this.cYv, this.bjz, this.cYX, true);
        }
    }

    public void ay(int i, int i2) {
        if (this.cZf != null) {
            this.cZf.a(i, i2, this.cYX, 1);
        }
    }

    public void az(int i, int i2) {
        this.cYv = i;
        this.bjz = i2;
    }

    public void fy(boolean z) {
        this.cYX = z;
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
            if (this.cZg != null) {
                this.cZg.setAlpha(alpha);
            }
            if (this.cZh != null) {
                this.cZh.setAlpha(alpha);
            }
            if (this.cYU != null) {
                this.cYU.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqz() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.bZI) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.ak.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.ak.a(this.cYK, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.cYL != null) {
                    com.baidu.tbadk.core.util.ak.a(this.cYL.ahd(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.ak.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.ak.a(this.cYK, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.cYL != null) {
                    com.baidu.tbadk.core.util.ak.a(this.cYL.ahd(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            aqy();
        }
    }

    public void fz(boolean z) {
    }

    public void kj(int i) {
        if (this.cYQ != null && this.cYQ.getChildCount() >= 0) {
            if (this.cYQ.getFirstVisiblePosition() > 8) {
                this.cYQ.scrollToPosition(8);
            }
            this.cYQ.smoothScrollToPosition(i);
        }
    }

    public void aqA() {
        a(this.cZj, this.cYF.apG());
        if (this.cYR != null) {
            this.cYR.arR();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.cZl == null) {
                this.cZl = new com.baidu.tieba.video.e(this.cYF.getActivity(), this.cYG);
            }
            this.cZl.h(postWriteCallBackData);
        }
    }

    public void aqB() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.cZv && this.cYF.getActivity() != null && this.cYF.getPageContext() != null) {
            View view2 = null;
            if (this.cYQ != null && (headerViewsCount = this.cYQ.getHeaderViewsCount()) < this.cYQ.getChildCount()) {
                view2 = this.cYQ.getChildAt(headerViewsCount);
            }
            if (view2 != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view2).W(0).D(true).E(false).C(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.i.8
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.i.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.k.frs_video_activity_guide_tip);
                        i.this.cYF.getPageContext().getLayoutMode().u(inflate);
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
                        return com.baidu.adp.lib.util.l.e(i.this.cYF.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.e(i.this.cYF.getActivity(), d.e.ds6);
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
                eH.l(this.cYF.getActivity());
                com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eH != null) {
                            eH.dismiss();
                        }
                    }
                }, 4000L);
                this.cZv = true;
            }
        }
    }
}
