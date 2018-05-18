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
    private AppBarLayout HN;
    private PbListView blq;
    private BdSwipeRefreshLayout bog;
    private NoNetworkView cIH;
    private CommonTipView cKt;
    private FrsFragment cZJ;
    private View cZN;
    private ImageView cZO;
    private com.baidu.tieba.d.b cZP;
    private ViewStub cZQ;
    private com.baidu.tieba.frs.entelechy.a.q cZV;
    private View.OnClickListener cZX;
    private View cZY;
    private View cZZ;
    private boolean daB;
    private int daa;
    private View dac;
    private com.baidu.tieba.frs.entelechy.b.d dad;
    private com.baidu.tieba.frs.entelechy.b.c dae;
    private com.baidu.tieba.frs.vc.i daf;
    private GifView dag;
    private TbImageView dah;
    private HashSet<String> dai;
    private com.baidu.tieba.play.m daj;
    private ObservedChangeLinearLayout dam;
    private com.baidu.tieba.frs.entelechy.b.a dan;
    private com.baidu.tieba.video.e dap;
    private AppBarLayoutStickyBehavior daq;
    private FrsHeaderViewContainer dar;
    private CollapsingToolbarLayout das;
    private com.baidu.tieba.frs.vc.f dax;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.f mPullView;
    private int mSkinType;
    private boolean cZI = false;
    private NoPressedRelativeLayout cZK = null;
    private CoordinatorLayout cZL = null;
    private View cZM = null;
    private FrameLayout cZR = null;
    private TbImageView cZS = null;
    private TbImageView cZT = null;
    private BdTypeRecyclerView cZU = null;
    private com.baidu.tbadk.core.dialog.b cZW = null;
    private NoNetworkView.a cWl = null;
    private boolean mHasMore = true;
    private boolean dab = false;
    private int cZz = 0;
    private int bjP = 0;
    private View dak = null;
    private View dal = null;
    private boolean caA = false;
    private boolean dao = true;
    private boolean dau = true;
    private int dav = -1;
    private int daw = -1;
    private AppBarLayout.OnOffsetChangedListener daz = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.i.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i.this.daw != i && Math.abs(i) >= 0 && i.this.apZ() != -1) {
                if (Math.abs(i) >= i.this.apZ()) {
                    if (i.this.dau) {
                        i.this.dau = false;
                        i.this.fs(i.this.dau);
                    }
                } else if (!i.this.dau) {
                    i.this.dau = true;
                    i.this.fs(i.this.dau);
                }
                int apT = i.this.apT() + i.this.apS() + i.this.apU();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - apT;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && i.this.daw - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        i.this.kd(Math.abs(apT - totalScrollRange2));
                        if (i.this.dal != null) {
                            i.this.dal.setVisibility(0);
                        }
                    } else if (i.this.dal != null) {
                        if (i.this.apR() != UtilHelper.getStatusBarHeight()) {
                            i.this.kd(0);
                        }
                        i.this.dal.setVisibility(8);
                    }
                    if (i.this.mNavigationBar != null) {
                        if (i.this.caA) {
                            i.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            i.this.aqy();
                        } else if (i.this.mNavigationBar.mCenterText != null) {
                            i.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    i.this.daw = i;
                }
            }
        }
    };
    private Runnable daA = new Runnable() { // from class: com.baidu.tieba.frs.i.7
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.cZQ != null) {
                i.this.cZR.setVisibility(0);
                i.this.cZT.setVisibility(0);
                i.this.cZS.setVisibility(8);
            }
        }
    };
    private CustomMessageListener daC = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                i.this.HN.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout apO() {
        return this.dam;
    }

    public View apP() {
        return this.dak;
    }

    public View apQ() {
        return this.dal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apR() {
        if (this.dak == null) {
            return 0;
        }
        return this.dak.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apS() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apT() {
        if (this.cIH == null || com.baidu.adp.lib.util.j.gP()) {
            return 0;
        }
        return this.cIH.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apU() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(int i) {
        View apP = apP();
        View apQ = apQ();
        if (UtilHelper.canUseStyleImmersiveSticky() && apP != null && apQ != null && apP.getLayoutParams() != null && apQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = apP.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            apP.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = apQ.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            apQ.setLayoutParams(layoutParams2);
        }
    }

    public i(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.cZJ = null;
        this.cZX = null;
        this.daa = 0;
        this.cZJ = frsFragment;
        this.cZX = onClickListener;
        a(aVar, z);
        this.dai = new HashSet<>();
        this.daa = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dax = fVar;
    }

    private boolean apV() {
        return this.dax != null && this.dax.avd();
    }

    private void apW() {
        this.cZJ.registerListener(this.daC);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        apW();
        this.dan = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.cZJ.getPageContext());
        }
        this.mPullView.setTag(this.cZJ.getUniqueId());
        if (this.cZK == null) {
            this.cZK = (NoPressedRelativeLayout) this.cZJ.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.ak.j(this.cZK, d.C0126d.cp_bg_line_d);
        if (this.cZM == null) {
            this.cZM = this.cZJ.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.cZL == null) {
            this.cZL = (CoordinatorLayout) this.cZJ.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.cZZ == null) {
            this.cZZ = this.cZJ.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.das == null) {
            this.das = (CollapsingToolbarLayout) this.cZJ.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.dar == null) {
            this.dar = (FrsHeaderViewContainer) this.cZJ.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.dam == null) {
            this.dam = (ObservedChangeLinearLayout) this.cZJ.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.dam.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.i.3
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view2, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                        i.this.das.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.cZJ.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.cZJ.apF()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.cZY == null) {
            this.cZY = this.cZJ.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b arq = aVar.arq();
            if (arq != null) {
                arq.ar(this.cZY);
            }
        }
        if (this.cZN == null) {
            this.cZN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.cZN.setOnClickListener(this.cZX);
            this.mBackImageView = (ImageView) this.cZN.findViewById(d.g.widget_navi_back_button);
        }
        if (this.cZO == null) {
            this.cZO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.cZO.setOnClickListener(this.cZX);
        }
        if (this.cZP == null) {
            this.cZP = new com.baidu.tieba.d.b(this.cZJ.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cZP.getView(), (View.OnClickListener) null);
            this.cZP.getView().setOnClickListener(this.cZX);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.cZJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ak.j(this.mNavigationBar.getBottomLine(), d.C0126d.cp_bg_line_b);
        }
        if (this.bog == null) {
            this.bog = (BdSwipeRefreshLayout) this.cZJ.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.bog.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.ak.j(this.bog, d.C0126d.cp_bg_line_c);
        }
        if (this.cZU == null) {
            this.cZU = (BdTypeRecyclerView) this.cZJ.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.cZU.getItemAnimator()).setSupportsChangeAnimations(false);
        this.cZU.setLayoutManager(new LinearLayoutManager(this.cZU.getContext()));
        this.cZU.setScrollable(this.cZJ);
        this.cZU.setFadingEdgeLength(0);
        this.cZU.setOverScrollMode(2);
        this.cZK.setBottomOrderView(this.cZU);
        this.cZU.setOnTouchListener(this.cZJ.aNL);
        this.cZU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (i.this.daj != null) {
                    i.this.daj.aM(view2);
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
        if (this.blq == null) {
            this.blq = new PbListView(this.cZJ.getPageContext().getPageActivity());
            this.blq.getView();
        }
        this.blq.dv(d.C0126d.cp_bg_line_e);
        this.blq.setHeight(com.baidu.adp.lib.util.l.e(this.cZJ.getActivity(), d.e.tbds182));
        this.blq.wN();
        this.blq.setTextSize(d.e.tbfontsize33);
        this.blq.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_d));
        this.blq.du(d.C0126d.cp_cont_e);
        this.cZU.setOnSrollToBottomListener(this.cZJ);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                i.this.cZJ.apC();
                if (i.this.cZJ != null && i.this.HN != null) {
                    i.this.cZJ.apH();
                    i.this.HN.setExpanded(true);
                    if (i.this.daj != null) {
                        i.this.daj.b(i.this.cZz, i.this.bjP, false, true);
                    }
                }
            }
        });
        boolean vR = com.baidu.tbadk.core.util.ap.vP().vR();
        if (this.cZV == null) {
            this.cZV = aVar.a(this.cZJ, this.cZU, vR);
        }
        ch(false);
        if (!z) {
            if (this.cIH == null) {
                this.cIH = new NoNetworkView(this.cZJ.getActivity());
                this.cIH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dam.addView(this.cIH);
            }
            if (com.baidu.adp.lib.util.j.gD()) {
                this.cIH.setVisibility(8);
            } else {
                this.cIH.setVisibility(0);
            }
            this.cIH.onChangeSkinType(this.cZJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aqg();
        if (this.dad == null) {
            this.dad = aVar.c(this.cZJ, this.cZK);
        }
        if (this.dae == null) {
            this.dae = aVar.b(this.cZJ, this.cZK);
            fv(true);
        }
        if (this.dak == null) {
            this.dak = this.cZJ.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.dal == null) {
            this.dal = this.cZJ.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.daj == null) {
            this.daj = new com.baidu.tieba.play.m(this.cZJ.getPageContext(), this.cZU);
        }
        this.daj.setUniqueId(this.cZJ.getUniqueId());
        if (this.daf == null) {
            this.daf = new com.baidu.tieba.frs.vc.i(this.cZJ, (NavigationBarCoverTip) this.cZJ.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.HN == null) {
            this.HN = (AppBarLayout) this.cZJ.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.HN.addOnOffsetChangedListener(this.daz);
            this.dau = true;
            this.dav = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.HN.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.daq = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    private void apX() {
        ViewGroup.LayoutParams layoutParams;
        this.caA = apV();
        if (this.dar != null && (layoutParams = this.dar.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.caA) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, apU() + apS(), 0, 0);
            }
            this.dar.requestLayout();
        }
    }

    public void apY() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dam != null) {
            apX();
            if (this.caA) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dak != null) {
                    this.dak.setAlpha(1.0f);
                }
                if (this.dal != null) {
                    this.dal.setAlpha(1.0f);
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
    public void fs(boolean z) {
        if (z && this.cZJ != null && this.cZJ.apj() != null) {
            this.cZJ.apj().avh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int apZ() {
        int i;
        if (this.HN == null) {
            return this.dav;
        }
        if (this.dav != -1) {
            return this.dav;
        }
        int childCount = this.HN.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.HN.getChildAt(childCount);
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
        this.dav = Math.max(0, this.HN.getTotalScrollRange() - Math.abs(i2));
        return this.dav;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dac != null && this.dac.getLayoutParams() != null) {
            this.dac.getLayoutParams().height = i;
            this.dac.setLayoutParams(this.dac.getLayoutParams());
        }
    }

    public void lO(String str) {
        if (this.daf != null) {
            this.daf.lO(str);
        }
    }

    public View aqa() {
        return this.dac;
    }

    public com.baidu.tieba.play.m aqb() {
        return this.daj;
    }

    public com.baidu.tieba.frs.entelechy.b.c aqc() {
        return this.dae;
    }

    public void ft(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.w(this.cZJ.apD().bqE());
        if (this.dad != null) {
            this.dad.ft(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aqd() {
        return this.dad;
    }

    public void u(boolean z, boolean z2) {
        if (this.dao && this.dae != null) {
            this.dae.u(z, z2);
        }
    }

    public void fu(boolean z) {
        this.dao = z;
        if (!this.dao && this.dae != null) {
            this.dae.u(false, false);
        }
    }

    public void aqe() {
        if (this.dao && this.dae != null) {
            this.dae.u(false, false);
        }
        this.cZO.setVisibility(8);
        ft(false);
        this.cZU.setVisibility(8);
        this.dar.setVisibility(8);
    }

    public void aqf() {
        if (this.dao && this.dae != null) {
            this.dae.u(true, false);
        }
        this.cZO.setVisibility(0);
        ft(true);
        this.cZU.setVisibility(0);
        this.dar.setVisibility(0);
    }

    public void fv(boolean z) {
        if (this.dae != null) {
            this.dae.fL(z);
        }
    }

    private void aqg() {
        if (this.dag == null) {
            this.dag = (GifView) this.cZJ.mRootView.findViewById(d.g.gif_real_time);
            this.dah = (TbImageView) this.cZJ.mRootView.findViewById(d.g.tbimg_real_time);
            this.dah.setPageId(this.cZJ.getUniqueId());
            this.dag.setLayerType(1, null);
            this.dah.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aqh() {
        return this.cZN;
    }

    public void h(NoNetworkView.a aVar) {
        this.cWl = aVar;
        if (this.cIH != null) {
            this.cIH.a(this.cWl);
        }
    }

    public void ch(boolean z) {
        this.cZI = z;
        if (z) {
            if (this.dae != null) {
                this.dae.arX();
                return;
            }
            return;
        }
        this.cZU.getAdapter().notifyDataSetChanged();
        if (this.dae != null) {
            this.dae.arY();
        }
    }

    public void fw(boolean z) {
        if (this.dae != null) {
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
        this.cZU.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.cZV.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.cZV.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.daj != null) {
            this.daj.destroy();
        }
        if (this.daf != null) {
            this.daf.onDestory();
        }
        this.cZV.onDestory();
        this.cZU.setOnSrollToBottomListener(null);
        this.cZU.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.daA);
        if (this.cKt != null) {
            this.cKt.onDestroy();
        }
        this.dai.clear();
        if (this.dad != null) {
            this.dad.arZ();
        }
        if (this.dap != null) {
            this.dap.arf();
        }
    }

    public boolean aqi() {
        if (this.HN == null || this.daq == null || !this.daq.isSticky()) {
            return this.dad != null && this.dad.aqi();
        }
        if (this.cZU != null) {
            this.cZU.setSelection(0);
        }
        this.daq.expandedAppBarLayout(this.HN);
        return true;
    }

    public boolean apE() {
        return this.cZI;
    }

    public void showListView() {
        this.cZU.setVisibility(0);
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
            com.baidu.tbadk.core.i.pX().cC(str);
        }
    }

    public void aqj() {
        if (this.cZV != null) {
            this.cZV.notifyDataSetChanged();
        }
    }

    public void agD() {
        if (this.cZV instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.cZV).agD();
        }
    }

    private void aqk() {
        if (this.cZW == null && this.cZJ.getPageContext() != null) {
            String[] strArr = {this.cZJ.getPageContext().getPageActivity().getString(d.k.take_photo), this.cZJ.getPageContext().getPageActivity().getString(d.k.album)};
            this.cZW = new com.baidu.tbadk.core.dialog.b(this.cZJ.getPageContext().getPageActivity());
            this.cZW.dd(this.cZJ.getPageContext().getPageActivity().getString(d.k.operation));
            this.cZW.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.i.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.cZJ.takePhoto();
                    } else if (i == 1 && i.this.cZJ.getPageContext() != null) {
                        com.baidu.tbadk.core.util.aj.s(i.this.cZJ.getPageContext().getPageActivity());
                    }
                }
            });
            this.cZW.d(this.cZJ.getPageContext());
        }
    }

    public void aql() {
        aqk();
        if (this.cZW != null) {
            this.cZW.tF();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.v.w(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.cZJ != null && this.cZJ.apg() != null && this.cZJ.apg().aue() == 0) {
                kVar.ki(this.cZJ.apg().aum());
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
        this.cZV.b(arrayList, lVar);
        if (this.daj != null) {
            this.daj.b(this.cZz, this.bjP, this.dab, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.cZU;
    }

    public void aqm() {
        this.cZV.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cZJ.getPageContext(), 1);
        aVar.a(this.cZU);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.cZJ.getForumName());
        hashMap.put("forum_id", this.cZJ.getForumId());
        aVar.setParams(hashMap);
        aVar.H(wVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dad != null) {
            this.dad.asa();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        if (this.dad != null) {
            this.dad.asb();
        }
    }

    public void release() {
        if (this.cIH != null && this.cWl != null) {
            this.cIH.b(this.cWl);
        }
    }

    public ImageView aqn() {
        return this.cZO;
    }

    public View aqo() {
        if (this.cZP != null) {
            return this.cZP.getView();
        }
        return null;
    }

    public void q(int i, boolean z) {
        if (this.cZP != null) {
            this.cZP.f(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.cZJ, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.cZJ.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dah != null) {
            this.dah.invalidate();
        }
        if (this.cZV != null) {
            this.cZV.arM();
            this.cZV.notifyDataSetChanged();
        }
        this.cZJ.getPageContext().getLayoutMode().setNightMode(i == 1);
        this.cZJ.getPageContext().getLayoutMode().u(this.cZK);
        if (this.cZK != null) {
            com.baidu.tbadk.core.util.ak.e(this.cZK, d.C0126d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.ak.cP(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.cZJ.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.ak.e(this.cZY, d.C0126d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.ak.j(this.mNavigationBar.getBottomLine(), d.C0126d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ao.vO().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
            com.baidu.tbadk.core.util.ao.vO().c(this.cZO, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            if (this.cZP != null) {
                this.cZP.onChangeSkinType(i);
            }
        }
        if (this.dak != null) {
            this.dak.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ak.cP(d.f.s_navbar_bg)).mutate());
        }
        if (this.dal != null) {
            this.dal.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.ak.cP(d.f.s_navbar_bg)).mutate());
        }
        if (this.cIH != null) {
            this.cIH.onChangeSkinType(this.cZJ.getPageContext(), i);
        }
        if (this.blq != null) {
            this.blq.setTextColor(com.baidu.tbadk.core.util.ak.getColor(d.C0126d.cp_cont_d));
            this.blq.dw(i);
        }
        aqy();
        if (this.dae != null) {
            this.dae.onChangeSkinType(i);
        }
        if (this.dad != null) {
            this.dad.onChangeSkinType(i);
        }
        if (this.daj != null) {
            this.daj.b(this.cZz, this.bjP, this.dab, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.HN != null) {
            com.baidu.tbadk.core.util.ak.e(this.HN, d.C0126d.cp_bg_line_d, i);
        }
        com.baidu.tbadk.core.util.ak.j(this.bog, d.C0126d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ak.j(this.cZU, d.C0126d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.cZU != null && this.cZU.getFirstVisiblePosition() != 0) {
            this.cZU.setSelection(0);
        }
        if (this.HN != null) {
            this.HN.setExpanded(true);
        }
        this.bog.setRefreshing(true);
    }

    public void fx(boolean z) {
        if (z) {
            this.bog.setRefreshing(false);
        } else {
            this.bog.lh();
        }
    }

    public boolean aqp() {
        return this.cZQ != null && this.cZT.getVisibility() == 0;
    }

    public void aqq() {
        if (this.cZQ != null) {
            this.cZR.setVisibility(0);
            this.cZT.setVisibility(8);
            this.cZS.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.daA, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bk bkVar) {
        if (this.cZQ == null) {
            this.cZQ = (ViewStub) this.cZJ.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.cZQ.setVisibility(0);
            this.cZR = (FrameLayout) this.cZJ.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.cZS = (TbImageView) this.cZJ.mRootView.findViewById(d.g.game_activity_egg);
            this.cZT = (TbImageView) this.cZJ.mRootView.findViewById(d.g.game_activity_egg_s);
            this.cZS.setPageId(this.cZJ.getUniqueId());
            this.cZT.setPageId(this.cZJ.getUniqueId());
            this.cZS.setDefaultBgResource(d.C0126d.common_color_10022);
            this.cZS.setDefaultResource(0);
            this.cZT.setDefaultBgResource(d.C0126d.common_color_10022);
            this.cZT.setDefaultResource(0);
            this.cZR.setOnClickListener(this.cZX);
        }
        this.cZR.setVisibility(0);
        String ts = bkVar.ts();
        String tt = bkVar.tt();
        this.cZS.startLoad(ts, 10, false);
        this.cZT.startLoad(tt, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.daA, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void aqr() {
        if (this.cZQ != null) {
            this.cZR.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aqs() {
        return this.cZV;
    }

    public ViewGroup ZJ() {
        return this.cZK;
    }

    public View aqt() {
        return this.cZZ;
    }

    public void ke(int i) {
        if (this.cZM != null) {
            this.cZM.setVisibility(i);
        }
    }

    public void aqu() {
        if (com.baidu.tbadk.k.p.GY().GZ()) {
            int lastVisiblePosition = this.cZU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.cZU.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.daK != null) {
                        com.baidu.tbadk.k.k perfLog = mVar.daK.getPerfLog();
                        perfLog.fj(1000);
                        perfLog.aKN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.daK.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.daK.startLogPerf();
                    }
                    if (mVar.daJ != null && (mVar.daJ instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.daJ;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fj(1000);
                                perfLog2.aKN = true;
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

    public NavigationBar Rd() {
        return this.mNavigationBar;
    }

    public void Ql() {
        this.mHasMore = true;
        this.cZU.setNextPage(this.blq);
        if (this.daa > 0) {
            this.blq.dx(this.daa);
        }
        this.blq.setOnClickListener(null);
        this.blq.wQ();
    }

    public void Qm() {
        this.mHasMore = false;
        this.cZU.setNextPage(this.blq);
        if (this.daa > 0) {
            this.blq.dx(this.daa);
        }
        this.blq.setOnClickListener(null);
        this.blq.wR();
        this.blq.setText(this.cZJ.getResources().getString(d.k.list_no_more));
    }

    public void aqv() {
        this.mHasMore = true;
        this.cZU.setNextPage(this.blq);
        this.blq.setOnClickListener(this.cZX);
        if (this.daa > 0) {
            this.blq.dx(this.daa);
        }
        this.blq.wR();
        this.blq.setText(this.cZJ.getResources().getString(d.k.list_click_load_more));
    }

    public View aqw() {
        if (this.blq == null) {
            return null;
        }
        return this.blq.getView();
    }

    public void Qn() {
        this.mHasMore = false;
        this.cZU.setNextPage(null);
    }

    public boolean agu() {
        return this.blq.getView().getParent() != null && this.mHasMore;
    }

    public void kf(int i) {
        this.daa = i;
    }

    public void kg(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cKt == null) {
                    this.cKt = new CommonTipView(this.cZJ.getActivity());
                }
                this.cKt.setText(d.k.frs_login_tip);
                this.cKt.show((FrameLayout) aqt(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fy(boolean z) {
        if (this.daj != null) {
            if (z) {
                this.daj.id(false);
                this.daj.ayY();
                return;
            }
            this.daj.id(true);
            this.daj.b(this.cZz, this.bjP, this.dab, true);
        }
    }

    public void ax(int i, int i2) {
        if (this.daj != null) {
            this.daj.a(i, i2, this.dab, 1);
        }
    }

    public void ay(int i, int i2) {
        this.cZz = i;
        this.bjP = i2;
    }

    public void fz(boolean z) {
        this.dab = z;
    }

    private void aqx() {
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
            if (this.dak != null) {
                this.dak.setAlpha(alpha);
            }
            if (this.dal != null) {
                this.dal.setAlpha(alpha);
            }
            if (this.cZY != null) {
                this.cZY.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqy() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.caA) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.ak.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.ak.a(this.cZO, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.cZP != null) {
                    com.baidu.tbadk.core.util.ak.a(this.cZP.ahd(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.ak.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.ak.a(this.cZO, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.cZP != null) {
                    com.baidu.tbadk.core.util.ak.a(this.cZP.ahd(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            aqx();
        }
    }

    public void fA(boolean z) {
    }

    public void kh(int i) {
        if (this.cZU != null && this.cZU.getChildCount() >= 0) {
            if (this.cZU.getFirstVisiblePosition() > 8) {
                this.cZU.scrollToPosition(8);
            }
            this.cZU.smoothScrollToPosition(i);
        }
    }

    public void aqz() {
        a(this.dan, this.cZJ.apF());
        if (this.cZV != null) {
            this.cZV.arQ();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dap == null) {
                this.dap = new com.baidu.tieba.video.e(this.cZJ.getActivity(), this.cZK);
            }
            this.dap.h(postWriteCallBackData);
        }
    }

    public void aqA() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.daB && this.cZJ.getActivity() != null && this.cZJ.getPageContext() != null) {
            View view2 = null;
            if (this.cZU != null && (headerViewsCount = this.cZU.getHeaderViewsCount()) < this.cZU.getChildCount()) {
                view2 = this.cZU.getChildAt(headerViewsCount);
            }
            if (view2 != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view2).W(0).D(true).E(false).C(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.i.8
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.i.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.k.frs_video_activity_guide_tip);
                        i.this.cZJ.getPageContext().getLayoutMode().u(inflate);
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
                        return com.baidu.adp.lib.util.l.e(i.this.cZJ.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.e(i.this.cZJ.getActivity(), d.e.ds6);
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
                eH.l(this.cZJ.getActivity());
                com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eH != null) {
                            eH.dismiss();
                        }
                    }
                }, 4000L);
                this.daB = true;
            }
        }
    }
}
