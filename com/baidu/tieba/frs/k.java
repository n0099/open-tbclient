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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.view.FrsBottomVoiceView;
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
    private AppBarLayout awJ;
    private PbListView cbb;
    private BdSwipeRefreshLayout cdS;
    private i dFH;
    private View dFL;
    private ImageView dFM;
    private com.baidu.tieba.d.b dFN;
    private ViewStub dFO;
    private com.baidu.tieba.frs.entelechy.a.s dFT;
    private View.OnClickListener dFV;
    private FrsBottomVoiceView dFW;
    private View dFX;
    private View dFY;
    private int dFZ;
    private View dGb;
    private com.baidu.tieba.frs.entelechy.b.d dGc;
    private com.baidu.tieba.frs.entelechy.b.c dGd;
    private com.baidu.tieba.frs.g.j dGe;
    private GifView dGf;
    private TbImageView dGg;
    private HashSet<String> dGh;
    private com.baidu.tieba.play.m dGi;
    private ObservedChangeLinearLayout dGl;
    private com.baidu.tieba.frs.entelechy.b.a dGm;
    private com.baidu.tieba.video.e dGo;
    private AppBarLayoutStickyBehavior dGp;
    private FrsHeaderViewContainer dGq;
    private CollapsingToolbarLayout dGr;
    private com.baidu.tieba.frs.g.f dGv;
    private boolean dGy;
    private NoNetworkView dpl;
    private CommonTipView dqL;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.k mPullView;
    private int mSkinType;
    private boolean dFG = false;
    private NoPressedRelativeLayout dFI = null;
    private CoordinatorLayout dFJ = null;
    private View dFK = null;
    private FrameLayout dFP = null;
    private TbImageView dFQ = null;
    private TbImageView dFR = null;
    private BdTypeRecyclerView dFS = null;
    private com.baidu.tbadk.core.dialog.b dFU = null;
    private NoNetworkView.a dCv = null;
    private boolean mHasMore = true;
    private boolean dGa = false;
    private int dFA = 0;
    private int bZz = 0;
    private View dGj = null;
    private View dGk = null;
    private boolean cJy = false;
    private boolean dGn = true;
    private boolean dGs = true;
    private int dGt = -1;
    private int dGu = -1;
    private AppBarLayout.OnOffsetChangedListener dGw = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.1
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            if (k.this.dGu != i && Math.abs(i) >= 0 && k.this.avC() != -1) {
                if (Math.abs(i) >= k.this.avC()) {
                    if (k.this.dGs) {
                        k.this.dGs = false;
                        k.this.fM(k.this.dGs);
                    }
                } else if (!k.this.dGs) {
                    k.this.dGs = true;
                    k.this.fM(k.this.dGs);
                }
                int avw = k.this.avw() + k.this.avu() + k.this.avx();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - avw;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.dGu - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.mR(Math.abs(avw - totalScrollRange2));
                        if (k.this.dGk != null) {
                            k.this.dGk.setVisibility(0);
                        }
                    } else if (k.this.dGk != null) {
                        if (k.this.avu() != UtilHelper.getStatusBarHeight()) {
                            k.this.mR(0);
                        }
                        k.this.dGk.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null && k.this.cJy) {
                        k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                        k.this.awd();
                    }
                    k.this.dGu = i;
                }
            }
        }
    };
    private Runnable dGx = new Runnable() { // from class: com.baidu.tieba.frs.k.7
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dFO != null) {
                k.this.dFP.setVisibility(0);
                k.this.dFR.setVisibility(0);
                k.this.dFQ.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dGz = new CustomMessageListener(2003020) { // from class: com.baidu.tieba.frs.k.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.awJ.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout avr() {
        return this.dGl;
    }

    public View avs() {
        return this.dGj;
    }

    public View avt() {
        return this.dGk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avu() {
        if (this.dGj == null) {
            return 0;
        }
        return this.dGj.getHeight();
    }

    private int avv() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avw() {
        if (this.dpl == null || com.baidu.adp.lib.util.j.oJ()) {
            return 0;
        }
        return this.dpl.getHeight();
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
        this.dFH = null;
        this.dFV = null;
        this.dFZ = 0;
        this.dFH = iVar;
        this.dFV = onClickListener;
        a(aVar, z);
        this.dGh = new HashSet<>();
        this.dFZ = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.dGv = fVar;
    }

    private boolean avy() {
        return this.dGv != null && this.dGv.aAi();
    }

    private void avz() {
        this.dFH.registerListener(this.dGz);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        avz();
        this.dGm = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.dFH.getPageContext());
        }
        this.mPullView.setTag(this.dFH.getUniqueId());
        if (this.dFI == null) {
            this.dFI = (NoPressedRelativeLayout) this.dFH.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.t(this.dFI, d.C0141d.cp_bg_line_d);
        if (this.dFK == null) {
            this.dFK = this.dFH.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.dFJ == null) {
            this.dFJ = (CoordinatorLayout) this.dFH.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.dFY == null) {
            this.dFY = this.dFH.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.dGr == null) {
            this.dGr = (CollapsingToolbarLayout) this.dFH.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.dGq == null) {
            this.dGq = (FrsHeaderViewContainer) this.dFH.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.dGl == null) {
            this.dGl = (ObservedChangeLinearLayout) this.dFH.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.dGl.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.3
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        k.this.dGr.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dFH.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dFH.avn()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dFW == null) {
            this.dFW = (FrsBottomVoiceView) this.dFH.mRootView.findViewById(d.g.frs_bottom_voice_view);
            this.dFW.setTag(this.dFH.getUniqueId());
        }
        if (this.dFX == null) {
            this.dFX = this.dFH.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b awW = aVar.awW();
            if (awW != null) {
                awW.bM(this.dFX);
            }
        }
        if (this.dFL == null) {
            this.dFL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dFL.setOnClickListener(this.dFV);
            this.mBackImageView = (ImageView) this.dFL.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dFM == null) {
            this.dFM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dFM.setOnClickListener(this.dFV);
        }
        if (this.dFN == null) {
            this.dFN = new com.baidu.tieba.d.b(this.dFH.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dFN.getView(), (View.OnClickListener) null);
            this.dFN.getView().setOnClickListener(this.dFV);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dFH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
        }
        if (this.cdS == null) {
            this.cdS = (BdSwipeRefreshLayout) this.dFH.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.cdS.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.aj.t(this.cdS, d.C0141d.cp_bg_line_c);
        }
        if (this.dFS == null) {
            this.dFS = (BdTypeRecyclerView) this.dFH.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.dFS.getItemAnimator()).setSupportsChangeAnimations(false);
        this.dFS.setLayoutManager(new LinearLayoutManager(this.dFS.getContext()));
        this.dFS.setScrollable(this.dFH);
        this.dFS.setFadingEdgeLength(0);
        this.dFS.setOverScrollMode(2);
        this.dFI.setBottomOrderView(this.dFS);
        this.dFS.setOnTouchListener(this.dFH.bDn);
        this.dFS.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dGi != null) {
                    k.this.dGi.cg(view);
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
        if (this.cbb == null) {
            this.cbb = new PbListView(this.dFH.getPageContext().getPageActivity());
            this.cbb.getView();
        }
        this.cbb.gw(d.C0141d.cp_bg_line_e);
        this.cbb.setHeight(com.baidu.adp.lib.util.l.t(this.dFH.getActivity(), d.e.tbds182));
        this.cbb.Ed();
        this.cbb.setTextSize(d.e.tbfontsize33);
        this.cbb.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_d));
        this.cbb.gv(d.C0141d.cp_cont_e);
        this.dFS.setOnSrollToBottomListener(this.dFH);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dFH.avj();
                if (k.this.dFH != null && k.this.awJ != null) {
                    k.this.dFH.avp();
                    k.this.awJ.setExpanded(true);
                    if (k.this.dGi != null) {
                        k.this.dGi.d(k.this.dFA, k.this.bZz, false, true);
                    }
                }
            }
        });
        boolean Dg = com.baidu.tbadk.core.util.ao.De().Dg();
        if (this.dFT == null) {
            this.dFT = aVar.a(this.dFH, this.dFS, Dg);
            if (this.dFT instanceof com.baidu.tieba.frs.entelechy.a.b) {
                ((com.baidu.tieba.frs.entelechy.a.b) this.dFT).setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
            }
        }
        cQ(false);
        if (!z) {
            if (this.dpl == null) {
                this.dpl = new NoNetworkView(this.dFH.getActivity());
                this.dpl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dGl.addView(this.dpl);
            }
            if (com.baidu.adp.lib.util.j.ox()) {
                this.dpl.setVisibility(8);
            } else {
                this.dpl.setVisibility(0);
            }
            this.dpl.onChangeSkinType(this.dFH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        avK();
        if (this.dGc == null) {
            this.dGc = aVar.c(this.dFH, this.dFI);
        }
        if (this.dGd == null) {
            this.dGd = aVar.b(this.dFH, this.dFI);
            fP(true);
        }
        if (this.dGj == null) {
            this.dGj = this.dFH.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.dGk == null) {
            this.dGk = this.dFH.mRootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.dGi == null) {
            this.dGi = new com.baidu.tieba.play.m(this.dFH.getPageContext(), this.dFS);
        }
        this.dGi.setUniqueId(this.dFH.getUniqueId());
        if (this.dGe == null) {
            this.dGe = new com.baidu.tieba.frs.g.j(this.dFH, (NavigationBarCoverTip) this.dFH.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.awJ == null) {
            this.awJ = (AppBarLayout) this.dFH.mRootView.findViewById(d.g.frs_app_bar_layout);
            this.awJ.addOnOffsetChangedListener(this.dGw);
            this.dGs = true;
            this.dGt = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.awJ.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dGp = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    private void avA() {
        ViewGroup.LayoutParams layoutParams;
        this.cJy = avy();
        if (this.dGq != null && (layoutParams = this.dGq.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.cJy) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, avx() + avv(), 0, 0);
            }
            this.dGq.requestLayout();
        }
    }

    public void avB() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dGl != null) {
            avA();
            if (this.cJy) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.dGj != null) {
                    this.dGj.setAlpha(1.0f);
                }
                if (this.dGk != null) {
                    this.dGk.setAlpha(1.0f);
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
        if (z && this.dFH != null && this.dFH.auQ() != null) {
            this.dFH.auQ().aAm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int avC() {
        int i;
        if (this.awJ == null) {
            return this.dGt;
        }
        if (this.dGt != -1) {
            return this.dGt;
        }
        int childCount = this.awJ.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.awJ.getChildAt(childCount);
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
        this.dGt = Math.max(0, this.awJ.getTotalScrollRange() - Math.abs(i2));
        return this.dGt;
    }

    public void setHeaderViewHeight(int i) {
        if (this.dGb != null && this.dGb.getLayoutParams() != null) {
            this.dGb.getLayoutParams().height = i;
            this.dGb.setLayoutParams(this.dGb.getLayoutParams());
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.l lVar) {
        this.dFW.setVoiceManager(this.dFH.getVoiceManager());
        this.dFW.setData(lVar);
        this.dFW.gD(com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_activity_switch_" + ((this.dFH.avl() == null || this.dFH.avl().bvI() == null) ? 0L : this.dFH.avl().bvI().buJ()), false));
    }

    public boolean avD() {
        VoiceManager voiceManager = this.dFW.getVoiceManager();
        if (voiceManager == null) {
            return false;
        }
        return voiceManager.isPlaying(this.dFW.getVoiceModel());
    }

    public void lI(String str) {
        if (this.dGe != null) {
            this.dGe.lI(str);
        }
    }

    public View avE() {
        return this.dGb;
    }

    public com.baidu.tieba.play.m avF() {
        return this.dGi;
    }

    public com.baidu.tieba.frs.entelechy.b.c avG() {
        return this.dGd;
    }

    public void fN(boolean z) {
        boolean z2 = z && com.baidu.tbadk.core.util.v.E(this.dFH.avl().bvC());
        if (this.dGc != null) {
            this.dGc.fN(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d avH() {
        return this.dGc;
    }

    public void y(boolean z, boolean z2) {
        if (this.dGn && this.dGd != null) {
            this.dGd.y(z, z2);
        }
    }

    public void fO(boolean z) {
        this.dGn = z;
        if (!this.dGn && this.dGd != null) {
            this.dGd.y(false, false);
        }
    }

    public void avI() {
        if (this.dGn && this.dGd != null) {
            this.dGd.y(false, false);
        }
        this.dFM.setVisibility(8);
        fN(false);
        this.dFS.setVisibility(8);
        this.dGq.setVisibility(8);
    }

    public void avJ() {
        if (this.dGn && this.dGd != null) {
            this.dGd.y(true, false);
        }
        this.dFM.setVisibility(0);
        fN(true);
        this.dFS.setVisibility(0);
        this.dGq.setVisibility(0);
    }

    public void fP(boolean z) {
        if (this.dGd != null) {
            this.dGd.ge(z);
        }
    }

    private void avK() {
        if (this.dGf == null) {
            this.dGf = (GifView) this.dFH.mRootView.findViewById(d.g.gif_real_time);
            this.dGg = (TbImageView) this.dFH.mRootView.findViewById(d.g.tbimg_real_time);
            this.dGg.setPageId(this.dFH.getUniqueId());
            this.dGf.setLayerType(1, null);
            this.dGg.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View avL() {
        return this.dFL;
    }

    public void h(NoNetworkView.a aVar) {
        this.dCv = aVar;
        if (this.dpl != null) {
            this.dpl.a(this.dCv);
        }
    }

    public void cQ(boolean z) {
        this.dFG = z;
        if (z) {
            if (this.dGd != null) {
                this.dGd.axA();
                return;
            }
            return;
        }
        this.dFS.getAdapter().notifyDataSetChanged();
        if (this.dGd != null) {
            this.dGd.axB();
        }
    }

    public void fQ(boolean z) {
        if (this.dGd != null) {
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
        this.dFS.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.o oVar) {
        this.dFT.setOnAdapterItemClickListener(oVar);
    }

    public void setForumName(String str) {
        this.dFT.setForumName(str);
        this.mForumName = str;
    }

    public void avM() {
        if (this.dFT instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dFT).setCardShowType(TbadkCoreApplication.getInst().getCardShowType());
        }
    }

    public void onDestroy() {
        if (this.dGi != null) {
            this.dGi.destroy();
        }
        if (this.dGe != null) {
            this.dGe.onDestory();
        }
        this.dFT.onDestory();
        this.dFS.setOnSrollToBottomListener(null);
        this.dFS.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dGx);
        if (this.dqL != null) {
            this.dqL.onDestroy();
        }
        this.dGh.clear();
        this.dFW.onDestroy();
        if (this.dGc != null) {
            this.dGc.axC();
        }
        if (this.dGo != null) {
            this.dGo.awQ();
        }
    }

    public boolean avN() {
        if (this.awJ == null || this.dGp == null || !this.dGp.isSticky()) {
            return this.dGc != null && this.dGc.avN();
        }
        if (this.dFS != null) {
            this.dFS.setSelection(0);
        }
        this.dGp.expandedAppBarLayout(this.awJ);
        return true;
    }

    public boolean avm() {
        return this.dFG;
    }

    public void aik() {
        this.dFS.setVisibility(0);
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

    public void avO() {
        if (this.dFT != null) {
            this.dFT.notifyDataSetChanged();
        }
    }

    public void amD() {
        if (this.dFT instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dFT).amD();
        }
    }

    private void avP() {
        if (this.dFU == null && this.dFH.getPageContext() != null) {
            String[] strArr = {this.dFH.getPageContext().getPageActivity().getString(d.j.take_photo), this.dFH.getPageContext().getPageActivity().getString(d.j.album)};
            this.dFU = new com.baidu.tbadk.core.dialog.b(this.dFH.getPageContext().getPageActivity());
            this.dFU.dl(this.dFH.getPageContext().getPageActivity().getString(d.j.operation));
            this.dFU.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.frs.k.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dFH.takePhoto();
                    } else if (i == 1 && k.this.dFH.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.s(k.this.dFH.getPageContext().getPageActivity());
                    }
                }
            });
            this.dFU.d(this.dFH.getPageContext());
        }
    }

    public void avQ() {
        avP();
        if (this.dFU != null) {
            this.dFU.AY();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.m mVar) {
        boolean z = false;
        if (com.baidu.tbadk.core.util.v.E(arrayList)) {
            m mVar2 = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar2);
            if (this.dFH != null && this.dFH.auO() != null && this.dFH.auO().azq() == 0) {
                mVar2.mW(this.dFH.auO().azy());
            }
        }
        if (com.baidu.tbadk.core.util.v.D(arrayList) > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                com.baidu.adp.widget.ListView.i iVar = arrayList.get(i);
                if (iVar instanceof bd) {
                    ((bd) iVar).setSmartFrsPosition(i);
                }
            }
        }
        com.baidu.tieba.frs.entelechy.b.d dVar = this.dGc;
        if (mVar != null && mVar.bvI() != null && mVar.bvI().getType() == 1) {
            z = true;
        }
        dVar.gf(z);
        this.dFT.b(arrayList, mVar);
        if (this.dGi != null) {
            this.dGi.d(this.dFA, this.bZz, this.dGa, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dFS;
    }

    public void avR() {
        this.dFT.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dFH.getPageContext(), 1);
        aVar.a(this.dFS);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dFH.getForumName());
        hashMap.put("forum_id", this.dFH.getForumId());
        aVar.setParams(hashMap);
        aVar.aM(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.dGc != null) {
            this.dGc.axD();
        }
        if (this.dFW != null) {
            this.dFW.onPause();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        if (this.dGc != null) {
            this.dGc.axE();
        }
        if (this.dFW != null) {
            this.dFW.onResume();
        }
    }

    public void release() {
        if (this.dpl != null && this.dCv != null) {
            this.dpl.b(this.dCv);
        }
    }

    public ImageView avS() {
        return this.dFM;
    }

    public View avT() {
        if (this.dFN != null) {
            return this.dFN.getView();
        }
        return null;
    }

    public void E(int i, boolean z) {
        if (this.dFN != null) {
            this.dFN.j(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dFH, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dFH.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.dGg != null) {
            this.dGg.invalidate();
        }
        if (this.dFT != null) {
            this.dFT.axp();
            this.dFT.notifyDataSetChanged();
        }
        this.dFH.getPageContext().getLayoutMode().aQ(i == 1);
        this.dFH.getPageContext().getLayoutMode().aM(this.dFI);
        if (this.dFI != null) {
            com.baidu.tbadk.core.util.aj.g(this.dFI, d.C0141d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg));
            this.mNavigationBar.onChangeSkinType(this.dFH.getPageContext(), i);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(bitmapDrawable.mutate());
            com.baidu.tbadk.core.util.aj.g(this.dFX, d.C0141d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0141d.cp_bg_line_b);
            com.baidu.tbadk.core.util.an.Dd().c(this.mBackImageView, d.f.icon_topbar_return_n_svg, d.f.select_topbar_icon_color_tint);
            com.baidu.tbadk.core.util.an.Dd().c(this.dFM, d.f.icon_topbar_search_n_svg, d.f.select_topbar_icon_color_tint);
            if (this.dFN != null) {
                this.dFN.onChangeSkinType(i);
            }
        }
        if (this.dGj != null) {
            this.dGj.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)).mutate());
        }
        if (this.dGk != null) {
            this.dGk.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fP(d.f.s_navbar_bg)).mutate());
        }
        if (this.dpl != null) {
            this.dpl.onChangeSkinType(this.dFH.getPageContext(), i);
        }
        if (this.cbb != null) {
            this.cbb.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0141d.cp_cont_d));
            this.cbb.gx(i);
        }
        awd();
        if (this.dGd != null) {
            this.dGd.onChangeSkinType(i);
        }
        if (this.dGc != null) {
            this.dGc.onChangeSkinType(i);
        }
        if (this.dGi != null) {
            this.dGi.d(this.dFA, this.bZz, this.dGa, true);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.awJ != null) {
            com.baidu.tbadk.core.util.aj.g(this.awJ, d.C0141d.cp_bg_line_d, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.cdS, d.C0141d.cp_bg_line_c);
        com.baidu.tbadk.core.util.aj.t(this.dFS, d.C0141d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.dFS != null && this.dFS.getFirstVisiblePosition() != 0) {
            this.dFS.setSelection(0);
        }
        if (this.awJ != null) {
            this.awJ.setExpanded(true);
        }
        this.cdS.setRefreshing(true);
    }

    public void fR(boolean z) {
        if (z) {
            this.cdS.setRefreshing(false);
        } else {
            this.cdS.sW();
        }
    }

    public boolean avU() {
        return this.dFO != null && this.dFR.getVisibility() == 0;
    }

    public void avV() {
        if (this.dFO != null) {
            this.dFP.setVisibility(0);
            this.dFR.setVisibility(8);
            this.dFQ.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dGx, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bl blVar) {
        if (this.dFO == null) {
            this.dFO = (ViewStub) this.dFH.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.dFO.setVisibility(0);
            this.dFP = (FrameLayout) this.dFH.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.dFQ = (TbImageView) this.dFH.mRootView.findViewById(d.g.game_activity_egg);
            this.dFR = (TbImageView) this.dFH.mRootView.findViewById(d.g.game_activity_egg_s);
            this.dFQ.setPageId(this.dFH.getUniqueId());
            this.dFR.setPageId(this.dFH.getUniqueId());
            this.dFQ.setDefaultBgResource(d.C0141d.common_color_10022);
            this.dFQ.setDefaultResource(0);
            this.dFR.setDefaultBgResource(d.C0141d.common_color_10022);
            this.dFR.setDefaultResource(0);
            this.dFP.setOnClickListener(this.dFV);
        }
        this.dFP.setVisibility(0);
        String AL = blVar.AL();
        String AM = blVar.AM();
        this.dFQ.startLoad(AL, 10, false);
        this.dFR.startLoad(AM, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dGx, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void avW() {
        if (this.dFO != null) {
            this.dFP.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.s avX() {
        return this.dFT;
    }

    public ViewGroup afu() {
        return this.dFI;
    }

    public View avY() {
        return this.dFY;
    }

    public void mS(int i) {
        if (this.dFK != null) {
            this.dFK.setVisibility(i);
        }
    }

    public void avZ() {
        if (com.baidu.tbadk.k.p.Ow().Ox()) {
            int lastVisiblePosition = this.dFS.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dFS.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dGH != null) {
                        com.baidu.tbadk.k.k perfLog = oVar.dGH.getPerfLog();
                        perfLog.ij(1000);
                        perfLog.bAq = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dGH.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dGH.startLogPerf();
                    }
                    if (oVar.dGG != null && (oVar.dGG instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dGG;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.k perfLog2 = tbImageView.getPerfLog();
                                perfLog2.ij(1000);
                                perfLog2.bAq = true;
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
        this.dFS.setNextPage(this.cbb);
        if (this.dFZ > 0) {
            this.cbb.gy(this.dFZ);
        }
        this.cbb.setOnClickListener(null);
        this.cbb.Eg();
    }

    public void XP() {
        this.mHasMore = false;
        this.dFS.setNextPage(this.cbb);
        if (this.dFZ > 0) {
            this.cbb.gy(this.dFZ);
        }
        this.cbb.setOnClickListener(null);
        this.cbb.Eh();
        this.cbb.setText(this.dFH.getResources().getString(d.j.list_no_more));
    }

    public void awa() {
        this.mHasMore = true;
        this.dFS.setNextPage(this.cbb);
        this.cbb.setOnClickListener(this.dFV);
        if (this.dFZ > 0) {
            this.cbb.gy(this.dFZ);
        }
        this.cbb.Eh();
        this.cbb.setText(this.dFH.getResources().getString(d.j.list_click_load_more));
    }

    public View awb() {
        if (this.cbb == null) {
            return null;
        }
        return this.cbb.getView();
    }

    public void XQ() {
        this.mHasMore = false;
        this.dFS.setNextPage(null);
    }

    public boolean amu() {
        return this.cbb.getView().getParent() != null && this.mHasMore;
    }

    public void mT(int i) {
        this.dFZ = i;
    }

    public void mU(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dqL == null) {
                    this.dqL = new CommonTipView(this.dFH.getActivity());
                }
                this.dqL.setText(d.j.frs_login_tip);
                this.dqL.show((FrameLayout) avY(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fS(boolean z) {
        if (this.dGi != null) {
            if (z) {
                this.dGi.iE(false);
                this.dGi.aEa();
                return;
            }
            this.dGi.iE(true);
            this.dGi.d(this.dFA, this.bZz, this.dGa, true);
        }
    }

    public void bu(int i, int i2) {
        if (this.dGi != null) {
            this.dGi.a(i, i2, this.dGa, 1);
        }
    }

    public void bv(int i, int i2) {
        this.dFA = i;
        this.bZz = i2;
    }

    public void fT(boolean z) {
        this.dGa = z;
    }

    private void awc() {
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
            if (this.dGj != null) {
                this.dGj.setAlpha(alpha);
            }
            if (this.dGk != null) {
                this.dGk.setAlpha(alpha);
            }
            if (this.dFX != null) {
                this.dFX.setAlpha(alpha);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awd() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.cJy) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                com.baidu.tbadk.core.util.aj.a(this.dFM, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                if (this.dFN != null) {
                    com.baidu.tbadk.core.util.aj.a(this.dFN.anf(), d.f.icon_topbar_white_remind, d.f.icon_topbar_white_remind);
                }
            } else {
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.dFM, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (this.dFN != null) {
                    com.baidu.tbadk.core.util.aj.a(this.dFN.anf(), d.f.icon_topbar_remind, d.f.icon_topbar_remind);
                }
            }
            awc();
        }
    }

    public void fU(boolean z) {
    }

    public void mV(int i) {
        if (this.dFS != null && this.dFS.getChildCount() >= 0) {
            if (this.dFS.getFirstVisiblePosition() > 8) {
                this.dFS.scrollToPosition(8);
            }
            this.dFS.smoothScrollToPosition(i);
        }
    }

    public void awe() {
        a(this.dGm, this.dFH.avn());
        if (this.dFT != null) {
            this.dFT.axu();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dGo == null) {
                this.dGo = new com.baidu.tieba.video.e(this.dFH.getActivity(), this.dFI);
            }
            this.dGo.g(postWriteCallBackData);
        }
    }

    public void awf() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dGy && this.dFH.getActivity() != null && this.dFH.getPageContext() != null) {
            View view = null;
            if (this.dFS != null && (headerViewsCount = this.dFS.getHeaderViewsCount()) < this.dFS.getChildCount()) {
                view = this.dFS.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.aG(view).cW(0).ak(true).al(false).aj(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.8
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.dFH.getPageContext().getLayoutMode().aM(inflate);
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
                        return com.baidu.adp.lib.util.l.t(k.this.dFH.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.t(k.this.dFH.getActivity(), d.e.ds6);
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
                mD.l(this.dFH.getActivity());
                com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mD != null) {
                            mD.dismiss();
                        }
                    }
                }, 4000L);
                this.dGy = true;
            }
        }
    }
}
