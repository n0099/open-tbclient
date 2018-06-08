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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
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
public class i {
    private AppBarLayout NW;
    private PbListView btv;
    private BdSwipeRefreshLayout bwm;
    private NoNetworkView cRO;
    private CommonTipView cTz;
    private FrsFragment diZ;
    private HashSet<String> djA;
    private com.baidu.tieba.play.m djB;
    private ObservedChangeLinearLayout djE;
    private com.baidu.tieba.frs.entelechy.b.a djF;
    private com.baidu.tieba.video.e djH;
    private AppBarLayoutStickyBehavior djI;
    private FrsHeaderViewContainer djJ;
    private CollapsingToolbarLayout djK;
    private com.baidu.tieba.frs.vc.f djO;
    private boolean djR;
    private View djd;
    private ImageView dje;
    private com.baidu.tieba.c.b djf;
    private ViewStub djg;
    private com.baidu.tieba.frs.entelechy.a.q djl;
    private FloatingAnimationView djm;
    private com.baidu.tieba.c.c djn;
    private View.OnClickListener djp;
    private View djq;
    private View djr;
    private int djs;
    private View dju;
    private com.baidu.tieba.frs.entelechy.b.d djv;
    private com.baidu.tieba.frs.entelechy.b.c djw;
    private com.baidu.tieba.frs.vc.i djx;
    private GifView djy;
    private TbImageView djz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.g mPullView;
    private int mSkinType;
    private boolean diY = false;
    private NoPressedRelativeLayout dja = null;
    private CoordinatorLayout djb = null;
    private View djc = null;
    private FrameLayout djh = null;
    private TbImageView dji = null;
    private TbImageView djj = null;
    private BdTypeRecyclerView djk = null;
    private com.baidu.tbadk.core.dialog.b djo = null;
    private NoNetworkView.a dfy = null;
    private boolean mHasMore = true;
    private boolean djt = false;
    private int diQ = 0;
    private int brT = 0;
    private View djC = null;
    private View djD = null;
    private boolean ciE = false;
    private boolean djG = true;
    private boolean djL = true;
    private int djM = -1;
    private int djN = -1;
    private AppBarLayout.OnOffsetChangedListener djP = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.i.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (i.this.djN != i && Math.abs(i) >= 0 && i.this.aue() != -1) {
                if (Math.abs(i) >= i.this.aue()) {
                    if (i.this.djL) {
                        i.this.djL = false;
                        i.this.fx(i.this.djL);
                    }
                } else if (!i.this.djL) {
                    i.this.djL = true;
                    i.this.fx(i.this.djL);
                }
                int atY = i.this.atY() + i.this.atX() + i.this.atZ();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - atY;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && i.this.djN - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        i.this.kg(Math.abs(atY - totalScrollRange2));
                        if (i.this.djD != null) {
                            i.this.djD.setVisibility(0);
                        }
                    } else if (i.this.djD != null) {
                        if (i.this.atW() != UtilHelper.getStatusBarHeight()) {
                            i.this.kg(0);
                        }
                        i.this.djD.setVisibility(8);
                    }
                    if (i.this.mNavigationBar != null) {
                        if (i.this.ciE) {
                            i.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            i.this.auD();
                        } else if (i.this.mNavigationBar.mCenterText != null) {
                            i.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    i.this.djN = i;
                }
            }
        }
    };
    private Runnable djQ = new Runnable() { // from class: com.baidu.tieba.frs.i.7
        @Override // java.lang.Runnable
        public void run() {
            if (i.this.djg != null) {
                i.this.djh.setVisibility(0);
                i.this.djj.setVisibility(0);
                i.this.dji.setVisibility(8);
            }
        }
    };
    private CustomMessageListener djS = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                i.this.NW.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout atT() {
        return this.djE;
    }

    public View atU() {
        return this.djC;
    }

    public View atV() {
        return this.djD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int atW() {
        if (this.djC == null) {
            return 0;
        }
        return this.djC.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int atX() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int atY() {
        if (this.cRO == null || com.baidu.adp.lib.util.j.jD()) {
            return 0;
        }
        return this.cRO.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int atZ() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kg(int i) {
        View atU = atU();
        View atV = atV();
        if (UtilHelper.canUseStyleImmersiveSticky() && atU != null && atV != null && atU.getLayoutParams() != null && atV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = atU.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            atU.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = atV.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            atV.setLayoutParams(layoutParams2);
        }
    }

    public i(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.diZ = null;
        this.djp = null;
        this.djs = 0;
        this.diZ = frsFragment;
        this.djp = onClickListener;
        a(aVar, z);
        this.djA = new HashSet<>();
        this.djs = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.djO = fVar;
    }

    private boolean aua() {
        return this.djO != null && this.djO.azm();
    }

    private void aub() {
        this.diZ.registerListener(this.djS);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        aub();
        this.djF = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.diZ.getPageContext());
        }
        this.mPullView.setTag(this.diZ.getUniqueId());
        if (this.dja == null) {
            this.dja = (NoPressedRelativeLayout) this.diZ.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.al.j(this.dja, d.C0141d.cp_bg_line_d);
        if (this.djc == null) {
            this.djc = this.diZ.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.djb == null) {
            this.djb = (CoordinatorLayout) this.diZ.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.djr == null) {
            this.djr = this.diZ.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.djK == null) {
            this.djK = (CollapsingToolbarLayout) this.diZ.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.djJ == null) {
            this.djJ = (FrsHeaderViewContainer) this.diZ.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.djE == null) {
            this.djE = (ObservedChangeLinearLayout) this.diZ.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.djE.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.frs.i.3
                @Override // com.baidu.tbadk.widget.layout.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        i.this.setHeaderViewHeight(i2);
                        i.this.djK.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.diZ.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.diZ.atK()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.djq == null) {
            this.djq = this.diZ.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b avv = aVar.avv();
            if (avv != null) {
                avv.ar(this.djq);
            }
        }
        if (this.djd == null) {
            this.djd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.djd.setOnClickListener(this.djp);
            this.mBackImageView = (ImageView) this.djd.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dje == null) {
            this.dje = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_search, (View.OnClickListener) null);
            this.dje.setOnClickListener(this.djp);
        }
        if (this.djf == null) {
            this.djf = new com.baidu.tieba.c.b(this.diZ.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.djf.getView(), (View.OnClickListener) null);
            this.djf.getView().setOnClickListener(this.djp);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.diZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
        }
        if (this.bwm == null) {
            this.bwm = (BdSwipeRefreshLayout) this.diZ.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.bwm.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.j(this.bwm, d.C0141d.cp_bg_line_c);
        }
        if (this.djk == null) {
            this.djk = (BdTypeRecyclerView) this.diZ.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.djk.getItemAnimator()).setSupportsChangeAnimations(false);
        this.djk.setLayoutManager(new LinearLayoutManager(this.djk.getContext()));
        this.djk.setScrollable(this.diZ);
        this.djk.setFadingEdgeLength(0);
        this.djk.setOverScrollMode(2);
        this.dja.setBottomOrderView(this.djk);
        this.djk.setOnTouchListener(this.diZ.aVI);
        this.djk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.i.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (i.this.djB != null) {
                    i.this.djB.aP(view);
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
        if (this.btv == null) {
            this.btv = new PbListView(this.diZ.getPageContext().getPageActivity());
            this.btv.getView();
        }
        this.btv.dx(d.C0141d.cp_bg_line_e);
        this.btv.setHeight(com.baidu.adp.lib.util.l.e(this.diZ.getActivity(), d.e.tbds182));
        this.btv.Ao();
        this.btv.setTextSize(d.e.tbfontsize33);
        this.btv.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_cont_d));
        this.btv.dw(d.C0141d.cp_cont_e);
        this.djk.setOnSrollToBottomListener(this.diZ);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.i.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i.this.diZ.atH();
                if (i.this.diZ != null && i.this.NW != null) {
                    i.this.diZ.atM();
                    i.this.NW.setExpanded(true);
                    if (i.this.djB != null) {
                        i.this.djB.b(i.this.diQ, i.this.brT, false, true);
                    }
                }
            }
        });
        boolean zs = com.baidu.tbadk.core.util.aq.zq().zs();
        if (this.djl == null) {
            this.djl = aVar.a(this.diZ, this.djk, zs);
        }
        cm(false);
        if (!z) {
            if (this.cRO == null) {
                this.cRO = new NoNetworkView(this.diZ.getActivity());
                this.cRO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.djE.addView(this.cRO);
            }
            if (com.baidu.adp.lib.util.j.jr()) {
                this.cRO.setVisibility(8);
            } else {
                this.cRO.setVisibility(0);
            }
            this.cRO.onChangeSkinType(this.diZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        aul();
        if (this.djv == null) {
            this.djv = aVar.c(this.diZ, this.dja);
        }
        if (this.djw == null) {
            this.djw = aVar.b(this.diZ, this.dja);
            fA(true);
        }
        if (this.djC == null) {
            this.djC = this.diZ.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.djD == null) {
            this.djD = this.diZ.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.djB == null) {
            this.djB = new com.baidu.tieba.play.m(this.diZ.getPageContext(), this.djk);
        }
        this.djB.setUniqueId(this.diZ.getUniqueId());
        if (this.djx == null) {
            this.djx = new com.baidu.tieba.frs.vc.i(this.diZ, (NavigationBarCoverTip) this.diZ.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.NW == null) {
            this.NW = (AppBarLayout) this.diZ.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.NW.addOnOffsetChangedListener(this.djP);
            this.djL = true;
            this.djM = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.NW.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.djI = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.djm = (FloatingAnimationView) this.diZ.mRootView.findViewById(d.g.redpacket_view);
        this.djm.setPageId(this.diZ.getUniqueId());
        this.djn = new com.baidu.tieba.c.c(this.diZ.aiH(), this.djm, 2);
    }

    public void fw(boolean z) {
        if (z && this.djn != null) {
            this.djn.akO();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.m mVar) {
        if (this.djn != null) {
            this.djn.a(mVar);
        }
    }

    private void auc() {
        ViewGroup.LayoutParams layoutParams;
        this.ciE = aua();
        if (this.djJ != null && (layoutParams = this.djJ.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.ciE) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, atZ() + atX(), 0, 0);
            }
            this.djJ.requestLayout();
        }
    }

    public void aud() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.djE != null) {
            auc();
            if (this.ciE) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.djC != null) {
                    this.djC.setAlpha(1.0f);
                }
                if (this.djD != null) {
                    this.djD.setAlpha(1.0f);
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
    public void fx(boolean z) {
        if (z && this.diZ != null && this.diZ.ato() != null) {
            this.diZ.ato().azq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aue() {
        int i;
        if (this.NW == null) {
            return this.djM;
        }
        if (this.djM != -1) {
            return this.djM;
        }
        int childCount = this.NW.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.NW.getChildAt(childCount);
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
        this.djM = Math.max(0, this.NW.getTotalScrollRange() - Math.abs(i2));
        return this.djM;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dju != null && this.dju.getLayoutParams() != null) {
            this.dju.getLayoutParams().height = i;
            this.dju.setLayoutParams(this.dju.getLayoutParams());
        }
    }

    public void mv(String str) {
        if (this.djx != null) {
            this.djx.mv(str);
        }
    }

    public View auf() {
        return this.dju;
    }

    public com.baidu.tieba.play.m aug() {
        return this.djB;
    }

    public com.baidu.tieba.frs.entelechy.b.c auh() {
        return this.djw;
    }

    public void fy(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.w.z(this.diZ.atI().bvE());
        if (this.djv != null) {
            this.djv.fy(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aui() {
        return this.djv;
    }

    public void u(boolean z, boolean z2) {
        if (this.djG && this.djw != null) {
            this.djw.u(z, z2);
        }
    }

    public void fz(boolean z) {
        this.djG = z;
        if (!this.djG && this.djw != null) {
            this.djw.u(false, false);
        }
    }

    public void auj() {
        if (this.djG && this.djw != null) {
            this.djw.u(false, false);
        }
        this.dje.setVisibility(8);
        fy(false);
        this.djk.setVisibility(8);
        this.djJ.setVisibility(8);
    }

    public void auk() {
        if (this.djG && this.djw != null) {
            this.djw.u(true, false);
        }
        this.dje.setVisibility(0);
        fy(true);
        this.djk.setVisibility(0);
        this.djJ.setVisibility(0);
    }

    public void fA(boolean z) {
        if (this.djw != null) {
            this.djw.fQ(z);
        }
    }

    private void aul() {
        if (this.djy == null) {
            this.djy = (GifView) this.diZ.mRootView.findViewById(d.g.gif_real_time);
            this.djz = (TbImageView) this.diZ.mRootView.findViewById(d.g.tbimg_real_time);
            this.djz.setPageId(this.diZ.getUniqueId());
            this.djy.setLayerType(1, null);
            this.djz.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View aum() {
        return this.djd;
    }

    public void h(NoNetworkView.a aVar) {
        this.dfy = aVar;
        if (this.cRO != null) {
            this.cRO.a(this.dfy);
        }
    }

    public void cm(boolean z) {
        this.diY = z;
        if (z) {
            if (this.djw != null) {
                this.djw.awc();
                return;
            }
            return;
        }
        this.djk.getAdapter().notifyDataSetChanged();
        if (this.djw != null) {
            this.djw.awd();
        }
    }

    public void fB(boolean z) {
        if (this.djw != null) {
            if (z) {
                u(false, true);
            } else {
                u(false, false);
            }
        }
    }

    public void a(f.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(f.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(f.a aVar) {
        this.mPullView.a(aVar);
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.djk.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.n nVar) {
        this.djl.setOnAdapterItemClickListener(nVar);
    }

    public void setForumName(String str) {
        this.djl.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.djB != null) {
            this.djB.destroy();
        }
        if (this.djx != null) {
            this.djx.onDestory();
        }
        this.djl.onDestory();
        this.djk.setOnSrollToBottomListener(null);
        this.djk.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.djQ);
        if (this.cTz != null) {
            this.cTz.onDestroy();
        }
        this.djA.clear();
        if (this.djv != null) {
            this.djv.awe();
        }
        if (this.djH != null) {
            this.djH.avk();
        }
        if (this.djn != null) {
            this.djn.onDestroy();
        }
    }

    public boolean aun() {
        if (this.NW == null || this.djI == null || !this.djI.isSticky()) {
            return this.djv != null && this.djv.aun();
        }
        if (this.djk != null) {
            this.djk.setSelection(0);
        }
        this.djI.expandedAppBarLayout(this.NW);
        return true;
    }

    public boolean atJ() {
        return this.diY;
    }

    public void showListView() {
        this.djk.setVisibility(0);
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
            com.baidu.tbadk.core.i.tt().da(str);
        }
    }

    public void auo() {
        if (this.djl != null) {
            this.djl.notifyDataSetChanged();
        }
    }

    public void akl() {
        if (this.djl instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.djl).akl();
        }
    }

    private void aup() {
        if (this.djo == null && this.diZ.getPageContext() != null) {
            String[] strArr = {this.diZ.getPageContext().getPageActivity().getString(d.k.take_photo), this.diZ.getPageContext().getPageActivity().getString(d.k.album)};
            this.djo = new com.baidu.tbadk.core.dialog.b(this.diZ.getPageContext().getPageActivity());
            this.djo.dC(this.diZ.getPageContext().getPageActivity().getString(d.k.operation));
            this.djo.a(strArr, new b.InterfaceC0103b() { // from class: com.baidu.tieba.frs.i.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        i.this.diZ.takePhoto();
                    } else if (i == 1 && i.this.diZ.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.r(i.this.diZ.getPageContext().getPageActivity());
                    }
                }
            });
            this.djo.d(this.diZ.getPageContext());
        }
    }

    public void auq() {
        aup();
        if (this.djo != null) {
            this.djo.xd();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (com.baidu.tbadk.core.util.w.z(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
            if (this.diZ != null && this.diZ.atm() != null && this.diZ.atm().ayr() == 0) {
                kVar.kn(this.diZ.atm().ayz());
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
                if (hVar instanceof bd) {
                    ((bd) hVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.djl.b(arrayList, lVar);
        if (this.djB != null) {
            this.djB.b(this.diQ, this.brT, this.djt, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.djk;
    }

    public void aur() {
        this.djl.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.w wVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.diZ.getPageContext(), 1);
        aVar.a(this.djk);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.diZ.getForumName());
        hashMap.put("forum_id", this.diZ.getForumId());
        aVar.setParams(hashMap);
        aVar.K(wVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.djv != null) {
            this.djv.awf();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        kh(TbadkCoreApplication.getInst().getSkinType());
        if (this.djv != null) {
            this.djv.awg();
        }
    }

    public void release() {
        if (this.cRO != null && this.dfy != null) {
            this.cRO.b(this.dfy);
        }
    }

    public ImageView aus() {
        return this.dje;
    }

    public View aut() {
        if (this.djf != null) {
            return this.djf.getView();
        }
        return null;
    }

    public void q(int i, boolean z) {
        if (this.djf != null) {
            this.djf.f(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.diZ, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.diZ.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.djz != null) {
            this.djz.invalidate();
        }
        if (this.djl != null) {
            this.djl.avR();
            this.djl.notifyDataSetChanged();
        }
        com.baidu.tbadk.n.a.a(this.diZ.getPageContext(), this.dja);
        kh(i);
        if (this.cRO != null) {
            this.cRO.onChangeSkinType(this.diZ.getPageContext(), i);
        }
        if (this.btv != null) {
            this.btv.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0141d.cp_cont_d));
            this.btv.dy(i);
        }
        auD();
        if (this.djw != null) {
            this.djw.onChangeSkinType(i);
        }
        if (this.djv != null) {
            this.djv.onChangeSkinType(i);
        }
        if (this.djB != null) {
            this.djB.b(this.diQ, this.brT, this.djt, true);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        com.baidu.tbadk.core.util.al.e(this.NW, d.C0141d.cp_bg_line_d, i);
        com.baidu.tbadk.core.util.al.e(this.dja, d.C0141d.cp_bg_line_d, i);
        com.baidu.tbadk.core.util.al.j(this.bwm, d.C0141d.cp_bg_line_c);
        com.baidu.tbadk.core.util.al.j(this.djk, d.C0141d.cp_bg_line_e);
    }

    private void kh(int i) {
        if (this.diZ != null) {
            Pair<Integer, Integer> pair = this.diZ.dhH;
            if (pair != null) {
                a(i, pair);
            } else {
                ki(i);
            }
        }
    }

    private void ki(int i) {
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.al.cR(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.diZ.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.al.e(this.djq, d.C0141d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
            int i2 = d.C0141d.select_topbar_icon_color_tint;
            com.baidu.tbadk.core.util.ap.zp().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.zp().c(this.dje, d.f.icon_topbar_search_n_svg, i2);
            if (this.djf != null) {
                this.djf.jc(i2);
                this.djf.onChangeSkinType(i);
            }
        }
        if (this.djC != null) {
            this.djC.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.al.cR(d.f.s_navbar_bg)).mutate());
        }
        if (this.djD != null) {
            this.djD.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.al.cR(d.f.s_navbar_bg)).mutate());
        }
    }

    private boolean a(int i, Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.diZ.getPageContext(), i);
                com.baidu.tbadk.core.util.al.e(this.djq, d.C0141d.cp_bg_line_b, i);
                com.baidu.tbadk.core.util.al.j(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
                com.baidu.tbadk.core.util.al.c(this.mNavigationBar.mCenterText, d.C0141d.cp_cont_i, 1);
            }
            com.baidu.tieba.frs.worldcup.b.a(this.mNavigationBar, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.djC, pair);
            com.baidu.tieba.frs.worldcup.b.a(this.djD, pair);
            int i2 = d.C0141d.select_topbar_icon_white_color_tint;
            com.baidu.tbadk.core.util.ap.zp().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, i2);
            com.baidu.tbadk.core.util.ap.zp().c(this.dje, d.f.icon_topbar_search_n_svg, i2);
            if (this.djf != null) {
                this.djf.jc(i2);
                this.djf.onChangeSkinType(i);
                return true;
            }
            return true;
        }
        return false;
    }

    public void startPullRefresh() {
        if (this.djk != null) {
            this.djk.setSelection(0);
        }
        if (this.NW != null) {
            this.NW.setExpanded(true);
        }
        this.bwm.setRefreshing(true);
    }

    public void fC(boolean z) {
        if (z) {
            this.bwm.setRefreshing(false);
        } else {
            this.bwm.nX();
        }
    }

    public boolean auu() {
        return this.djg != null && this.djj.getVisibility() == 0;
    }

    public void auv() {
        if (this.djg != null) {
            this.djh.setVisibility(0);
            this.djj.setVisibility(8);
            this.dji.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.djQ, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bk bkVar) {
        if (this.djg == null) {
            this.djg = (ViewStub) this.diZ.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.djg.setVisibility(0);
            this.djh = (FrameLayout) this.diZ.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.dji = (TbImageView) this.diZ.mRootView.findViewById(d.g.game_activity_egg);
            this.djj = (TbImageView) this.diZ.mRootView.findViewById(d.g.game_activity_egg_s);
            this.dji.setPageId(this.diZ.getUniqueId());
            this.djj.setPageId(this.diZ.getUniqueId());
            this.dji.setDefaultBgResource(d.C0141d.common_color_10022);
            this.dji.setDefaultResource(0);
            this.djj.setDefaultBgResource(d.C0141d.common_color_10022);
            this.djj.setDefaultResource(0);
            this.djh.setOnClickListener(this.djp);
        }
        this.djh.setVisibility(0);
        String wQ = bkVar.wQ();
        String wR = bkVar.wR();
        this.dji.startLoad(wQ, 10, false);
        this.djj.startLoad(wR, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.djQ, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void auw() {
        if (this.djg != null) {
            this.djh.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.q aux() {
        return this.djl;
    }

    public ViewGroup adh() {
        return this.dja;
    }

    public View auy() {
        return this.djr;
    }

    public void kj(int i) {
        if (this.djc != null) {
            this.djc.setVisibility(i);
        }
    }

    public void auz() {
        if (com.baidu.tbadk.k.m.Ks().Kt()) {
            int lastVisiblePosition = this.djk.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.djk.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof m)) {
                    m mVar = (m) childAt.getTag();
                    if (mVar.dka != null) {
                        com.baidu.tbadk.k.h perfLog = mVar.dka.getPerfLog();
                        perfLog.fk(1000);
                        perfLog.aSN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            mVar.dka.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        mVar.dka.startLogPerf();
                    }
                    if (mVar.djZ != null && (mVar.djZ instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = mVar.djZ;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.fk(1000);
                                perfLog2.aSN = true;
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

    public NavigationBar UB() {
        return this.mNavigationBar;
    }

    public void TJ() {
        this.mHasMore = true;
        this.djk.setNextPage(this.btv);
        if (this.djs > 0) {
            this.btv.dz(this.djs);
        }
        this.btv.setOnClickListener(null);
        this.btv.Ar();
    }

    public void TK() {
        this.mHasMore = false;
        this.djk.setNextPage(this.btv);
        if (this.djs > 0) {
            this.btv.dz(this.djs);
        }
        this.btv.setOnClickListener(null);
        this.btv.As();
        this.btv.setText(this.diZ.getResources().getString(d.k.list_no_more));
    }

    public void auA() {
        this.mHasMore = true;
        this.djk.setNextPage(this.btv);
        this.btv.setOnClickListener(this.djp);
        if (this.djs > 0) {
            this.btv.dz(this.djs);
        }
        this.btv.As();
        this.btv.setText(this.diZ.getResources().getString(d.k.list_click_load_more));
    }

    public View auB() {
        if (this.btv == null) {
            return null;
        }
        return this.btv.getView();
    }

    public void TL() {
        this.mHasMore = false;
        this.djk.setNextPage(null);
    }

    public boolean akc() {
        return this.btv.getView().getParent() != null && this.mHasMore;
    }

    public void kk(int i) {
        this.djs = i;
    }

    public void kl(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.cTz == null) {
                    this.cTz = new CommonTipView(this.diZ.getActivity());
                }
                this.cTz.setText(d.k.frs_login_tip);
                this.cTz.show((FrameLayout) auy(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fD(boolean z) {
        if (this.djB != null) {
            if (z) {
                this.djB.ij(false);
                this.djB.aDT();
                return;
            }
            this.djB.ij(true);
            this.djB.b(this.diQ, this.brT, this.djt, true);
        }
    }

    public void az(int i, int i2) {
        if (this.djB != null) {
            this.djB.a(i, i2, this.djt, 1);
        }
    }

    public void aA(int i, int i2) {
        this.diQ = i;
        this.brT = i2;
    }

    public void fE(boolean z) {
        this.djt = z;
    }

    private void auC() {
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
            if (this.djC != null) {
                this.djC.setAlpha(alpha);
            }
            if (this.djD != null) {
                this.djD.setAlpha(alpha);
            }
            if (this.djq != null) {
                this.djq.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auD() {
        if (this.diZ.dhH == null && this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.ciE) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.al.a(this.dje, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.djf != null) {
                    com.baidu.tbadk.core.util.al.a(this.djf.akL(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.al.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.al.a(this.dje, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.djf != null) {
                    com.baidu.tbadk.core.util.al.a(this.djf.akL(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            auC();
        }
    }

    public void fF(boolean z) {
    }

    public void km(int i) {
        if (this.djk != null && this.djk.getChildCount() >= 0) {
            if (this.djk.getFirstVisiblePosition() > 8) {
                this.djk.scrollToPosition(8);
            }
            this.djk.smoothScrollToPosition(i);
        }
    }

    public void auE() {
        a(this.djF, this.diZ.atK());
        if (this.djl != null) {
            this.djl.avV();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.djH == null) {
                this.djH = new com.baidu.tieba.video.e(this.diZ.getActivity(), this.dja);
            }
            this.djH.h(postWriteCallBackData);
        }
    }

    public void auF() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.djR && this.diZ.getActivity() != null && this.diZ.getPageContext() != null) {
            View view = null;
            if (this.djk != null && (headerViewsCount = this.djk.getHeaderViewsCount()) < this.djk.getChildCount()) {
                view = this.djk.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.o(view).X(0).F(true).G(false).E(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.i.8
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.i.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.k.frs_video_activity_guide_tip);
                        i.this.diZ.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.e(i.this.diZ.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.e(i.this.diZ.getActivity(), d.e.ds6);
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
                final com.baidu.adp.lib.guide.c hy = dVar.hy();
                hy.C(false);
                hy.k(this.diZ.getActivity());
                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.i.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hy != null) {
                            hy.dismiss();
                        }
                    }
                }, 4000L);
                this.djR = true;
            }
        }
    }
}
