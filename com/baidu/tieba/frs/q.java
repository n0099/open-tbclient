package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.cg;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsMoveAreaBottomMenuView;
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes22.dex */
public class q {
    private AppBarLayout Yg;
    private NoNetworkView fRL;
    private PbListView fTv;
    private ImageView hLB;
    private MessageRedDotView hLC;
    private com.baidu.tieba.play.i hXO;
    private CommonTipView hYJ;
    private com.baidu.adp.widget.ListView.n hZL;
    private ViewStub irA;
    private BdTypeRecyclerView irE;
    private com.baidu.tieba.frs.entelechy.a.al irF;
    private com.baidu.tieba.frs.vc.k irG;
    private View.OnClickListener irI;
    private View irJ;
    private View irK;
    private int irM;
    private com.baidu.tieba.frs.vc.d irO;
    private com.baidu.tieba.frs.entelechy.b.c irP;
    private com.baidu.tieba.frs.vc.m irQ;
    private GifView irR;
    private TbImageView irS;
    private HashSet<String> irT;
    private ObservedChangeLinearLayout irV;
    private com.baidu.tieba.frs.entelechy.b.a irW;
    private com.baidu.tieba.video.f irX;
    private AppBarLayoutStickyBehavior irY;
    private FrsHeaderViewContainer irZ;
    private FrsFragment irr;
    private View irv;
    private com.baidu.tieba.c.d irw;
    private ImageView irx;
    private ImageView iry;
    private TextView irz;
    private CollapsingToolbarLayout isa;
    private com.baidu.tieba.frs.vc.h ise;
    private FrsMultiDelBottomMenuView isf;
    private FrsMoveAreaBottomMenuView isg;
    private NavigationBarCoverTip ish;
    private TextView isi;
    private TextView isj;
    private boolean iso;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout irs = null;
    private CoordinatorLayout irt = null;
    private View iru = null;
    private FrameLayout irB = null;
    private TbImageView irC = null;
    private TbImageView irD = null;
    private com.baidu.tbadk.core.dialog.b irH = null;
    private NoNetworkView.a ime = null;
    private boolean irL = true;
    private boolean mHasMore = true;
    private boolean irN = false;
    private int ird = 0;
    private int fSe = 0;
    private View bvC = null;
    private View irU = null;
    private boolean gyB = false;
    private boolean dPM = true;
    private boolean isb = true;
    private int isc = -1;
    private int isd = -1;
    private int isk = 0;
    private int isl = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener hZN = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.hZL == null) {
                        q.this.hZL = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.hZL.a(q.this.irE, 2);
                } else if (q.this.hZL != null) {
                    q.this.hZL.rh();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener ism = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.irG != null) {
                q.this.irG.setInterceptScrollDown(i == 0);
            }
            if (q.this.isd != i && Math.abs(i) >= 0 && q.this.ctF() != -1) {
                if (Math.abs(i) >= q.this.ctF()) {
                    if (q.this.isb) {
                        q.this.isb = false;
                        q.this.oW(q.this.isb);
                    }
                } else if (!q.this.isb) {
                    q.this.isb = true;
                    q.this.oW(q.this.isb);
                }
                int ctB = q.this.ctB() + q.this.ctA() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - ctB;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.isd - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.yd(Math.abs(ctB - totalScrollRange2));
                        if (q.this.irU != null) {
                            q.this.irU.setVisibility(0);
                        }
                    } else if (q.this.irU != null) {
                        if (q.this.ctz() != UtilHelper.getStatusBarHeight()) {
                            q.this.yd(0);
                        }
                        q.this.irU.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.gyB) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.pb(false);
                        } else if (q.this.isj != null) {
                            q.this.isj.setAlpha(abs);
                        }
                    }
                    q.this.isd = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.irG != null) {
                int cAw = q.this.irG.cAw();
                int cAx = cAw - q.this.irG.cAx();
                if (cAw > 0 && Math.abs(i) >= cAx) {
                    q.this.irG.dismissLoading();
                }
            }
        }
    };
    private Runnable isn = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.irA != null) {
                q.this.irB.setVisibility(0);
                q.this.irD.setVisibility(0);
                q.this.irC.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.irr != null && appBarLayout != null && this.irr.csB() != null && this.irr.getPageContext() != null) {
            int ctA = ctA() + getNavigationBarHeight() + ctB();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController csB = this.irr.csB();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.irr.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.irr.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.iru.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.irr != null && this.irr.csI();
            if (totalScrollRange <= 0) {
                if (this.isl != 2) {
                    csB.Ab(2);
                }
                this.isl = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= ctA) {
                if (this.isl != 1) {
                    csB.Ab(1);
                }
                this.isl = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.isl != 0) {
                    csB.Ab(0);
                }
                this.isl = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.irr.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.iru.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout ctx() {
        return this.irV;
    }

    public View Qb() {
        return this.bvC;
    }

    public View cty() {
        return this.irU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ctz() {
        if (this.bvC == null) {
            return 0;
        }
        return this.bvC.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ctA() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ctB() {
        if (this.fRL == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fRL.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yd(int i) {
        View Qb = Qb();
        View cty = cty();
        if (UtilHelper.canUseStyleImmersiveSticky() && Qb != null && cty != null && Qb.getLayoutParams() != null && cty.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Qb.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Qb.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cty.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cty.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.irr = null;
        this.irI = null;
        this.irM = 0;
        this.irr = frsFragment;
        this.irI = onClickListener;
        MessageManager.getInstance().registerListener(this.hZN);
        a(aVar, z);
        this.irT = new HashSet<>();
        this.irM = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.ise = hVar;
    }

    private boolean ctC() {
        return this.ise != null && this.ise.cAh();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.irW = aVar;
        View rootView = this.irr.getRootView();
        if (this.irs == null) {
            this.irs = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.iru == null) {
            this.iru = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.irt == null) {
            this.irt = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.irK == null) {
            this.irK = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.isa == null) {
            this.isa = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.irZ == null) {
            this.irZ = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.irG == null) {
            this.irG = new com.baidu.tieba.frs.vc.k(this.irr);
        }
        if (this.irV == null) {
            this.irV = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.irV.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.isa.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) rootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            this.mNavigationBar.setContentPaddingTop(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.irr.ctk()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.irJ == null) {
            this.irJ = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b cvY = aVar.cvY();
            if (cvY != null) {
                cvY.ct(this.irJ);
            }
        }
        if (this.irv == null) {
            this.irv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.irv.setOnClickListener(this.irI);
            this.mBackImageView = (ImageView) this.irv.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iry == null) {
            this.iry = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bmU().a(this.iry, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iry.setOnClickListener(this.irI);
        }
        if (this.irw == null) {
            this.irw = new com.baidu.tieba.c.d(this.irr.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.irw.getView(), (View.OnClickListener) null);
            this.hLB = this.irw.cjL();
            this.hLC = this.irw.cjM();
            this.irw.getView().setOnClickListener(this.irI);
            this.irw.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.irx == null) {
            this.irx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bmU().a(this.irx, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.irx.setOnClickListener(this.irI);
        }
        if (this.irz == null) {
            this.irz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.irz.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.irr.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.irz.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.f(this.irz, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.irz, R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.irr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.irE == null) {
            this.irE = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int isr = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.isr--;
                if (this.isr == 0) {
                    q.this.irE.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.isr++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.irE.setItemAnimator(defaultItemAnimator);
        this.irE.setLayoutManager(new LinearLayoutManager(this.irE.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hZL = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.hZL.a(this.irE, 2);
        }
        this.irE.setScrollable(this.irr);
        this.irE.setFadingEdgeLength(0);
        this.irE.setOverScrollMode(2);
        this.irs.setBottomOrderView(this.irE);
        this.irE.setOnTouchListener(this.irr.fkK);
        this.irE.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.hXO != null) {
                    q.this.hXO.cR(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        });
        if (this.fTv == null) {
            this.fTv = new PbListView(this.irr.getPageContext().getPageActivity());
            this.fTv.getView();
        }
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fTv.setHeight(com.baidu.adp.lib.util.l.getDimens(this.irr.getActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.irE.setOnSrollToBottomListener(this.irr);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.irr.ctd();
                if (q.this.irr != null && q.this.Yg != null) {
                    q.this.irr.ctn();
                    q.this.Yg.setExpanded(true);
                    if (q.this.hXO != null) {
                        q.this.hXO.a(q.this.ird, q.this.fSe, false, true);
                    }
                }
            }
        });
        boolean bmW = com.baidu.tbadk.core.util.au.bmV().bmW();
        if (this.irF == null) {
            this.irF = aVar.a(this.irr, this.irE, bmW);
        }
        if (this.irG != null) {
            this.irG.Q(1, false);
        }
        if (!z) {
            if (this.fRL == null) {
                this.fRL = new NoNetworkView(this.irr.getActivity());
                this.fRL.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.irV.addView(this.fRL);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fRL.setVisibility(8);
            } else {
                this.fRL.setVisibility(0);
            }
            this.fRL.onChangeSkinType(this.irr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ctM();
        if (this.irO == null) {
            this.irO = aVar.a(this.irr, this.irs);
            this.irO.b(this.irr.cto());
        }
        if (this.irP == null) {
            this.irP = aVar.b(this.irr, this.irs);
            oZ(true);
        }
        if (this.bvC == null) {
            this.bvC = rootView.findViewById(R.id.statebar_view);
        }
        if (this.irU == null) {
            this.irU = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.hXO == null) {
            this.hXO = new com.baidu.tieba.play.i(this.irr.getPageContext(), this.irE);
        }
        this.hXO.GO(1);
        this.hXO.setUniqueId(this.irr.getUniqueId());
        this.ish = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.irQ == null) {
            this.irQ = new com.baidu.tieba.frs.vc.m(this.irr, this.ish);
        }
        if (this.Yg == null) {
            this.Yg = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Yg.addOnOffsetChangedListener(this.ism);
            this.isb = true;
            this.isc = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Yg.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.irY = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.isf = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.isf.setPageContext(this.irr.getPageContext());
        this.isg = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.isg.setPageContext(this.irr.getPageContext());
        if (this.isj == null) {
            this.isj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.irr.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.isj.setLayoutParams(layoutParams2);
            this.isj.setPadding(0, 0, this.irr.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.isj.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
    }

    public void bO(boolean z) {
        if (z) {
        }
    }

    private void ctD() {
        ViewGroup.LayoutParams layoutParams;
        this.gyB = ctC();
        if (this.irZ != null && (layoutParams = this.irZ.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.gyB) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + ctA(), 0, 0);
            }
            this.irZ.requestLayout();
        }
    }

    public void ctE() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.irV != null) {
            ctD();
            if (this.gyB) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bvC != null) {
                    this.bvC.setAlpha(1.0f);
                }
                if (this.irU != null) {
                    this.irU.setAlpha(1.0f);
                }
                if (this.isj != null) {
                    this.isj.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(boolean z) {
        if (z && this.irr != null && this.irr.csA() != null) {
            this.irr.csA().cAm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ctF() {
        int i;
        if (this.Yg == null) {
            return this.isc;
        }
        if (this.isc != -1) {
            return this.isc;
        }
        int childCount = this.Yg.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Yg.getChildAt(childCount);
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
        this.isc = Math.max(0, this.Yg.getTotalScrollRange() - Math.abs(i2));
        return this.isc;
    }

    public void JB(String str) {
        if (this.irQ != null) {
            this.irQ.JB(str);
        }
    }

    public com.baidu.tieba.play.i ctG() {
        return this.hXO;
    }

    public com.baidu.tieba.frs.entelechy.b.c ctH() {
        return this.irP;
    }

    public void oX(boolean z) {
        if (this.irO != null) {
            if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                this.irO.oX(false);
            } else {
                this.irO.oX(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d ctI() {
        return this.irO;
    }

    public void V(boolean z, boolean z2) {
        if (this.dPM && this.irP != null) {
            this.irP.V(z, z2);
        }
    }

    public void oY(boolean z) {
        this.dPM = z;
        if (!this.dPM && this.irP != null) {
            this.irP.V(false, false);
        }
    }

    public void ctJ() {
        if (this.dPM && this.irP != null) {
            this.irP.V(false, false);
        }
        ye(8);
        this.iry.setVisibility(8);
        this.irx.setVisibility(8);
        oX(false);
        this.irE.setVisibility(8);
        this.irZ.setVisibility(8);
    }

    public void ctK() {
        if (this.dPM && this.irP != null) {
            this.irP.V(true, false);
        }
        ye(0);
        ctL();
        oX(this.irr.ctq());
        this.irE.setVisibility(0);
        this.irZ.setVisibility(0);
    }

    private void ye(int i) {
        if (this.irw != null) {
            this.irw.setVisibility(i);
        }
    }

    private void ctL() {
        this.iry.setVisibility(0);
        this.irx.setVisibility(0);
    }

    public void oZ(boolean z) {
        if (this.irP != null) {
            this.irP.pB(z);
        }
    }

    private void ctM() {
        if (this.irR == null) {
            View rootView = this.irr.getRootView();
            this.irR = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.irS = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.irS.setPageId(this.irr.getUniqueId());
            this.irR.setLayerType(1, null);
            this.irS.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ctN() {
        return this.irv;
    }

    public void g(NoNetworkView.a aVar) {
        this.ime = aVar;
        if (this.fRL != null) {
            this.fRL.a(this.ime);
        }
    }

    public void pa(boolean z) {
        if (this.irP != null) {
            if (z) {
                V(false, true);
            } else {
                V(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.irE.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.irF.a(abVar);
    }

    public void setForumName(String str) {
        this.irF.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hZN);
        if (this.hXO != null) {
            this.hXO.destroy();
        }
        if (this.irQ != null) {
            this.irQ.onDestory();
        }
        if (this.isf != null) {
            this.isf.setPageContext(null);
        }
        if (this.isg != null) {
            this.isg.setPageContext(null);
        }
        this.irF.onDestory();
        this.irE.setOnSrollToBottomListener(null);
        this.irE.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.isn);
        if (this.hYJ != null) {
            this.hYJ.onDestroy();
        }
        this.irT.clear();
        if (this.irO != null) {
            this.irO.czR();
        }
        if (this.irX != null) {
            this.irX.cvF();
        }
        if (this.ish != null) {
            this.ish.onDestroy();
        }
        if (this.isf != null) {
            this.isf.onDestroy();
        }
        if (this.irG != null) {
            this.irG.onDestroy();
        }
    }

    public boolean ctO() {
        if (this.Yg == null || this.irY == null || !this.irY.isSticky()) {
            return this.irO != null && this.irO.ctO();
        }
        if (this.irE != null) {
            this.irE.setSelection(0);
        }
        this.irY.expandedAppBarLayout(this.Yg);
        return true;
    }

    public boolean cti() {
        if (this.irG == null) {
            return false;
        }
        return this.irG.cti();
    }

    public void bPU() {
        this.irE.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.isj.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.isj.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.isj.setText(str2);
            com.baidu.tbadk.core.k.bfo().setForumNameForWaterImage(str);
        }
    }

    public void ctP() {
        if (this.irF != null) {
            this.irF.notifyDataSetChanged();
        }
    }

    public void aVY() {
        if (this.irF instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.irF).aVY();
        }
    }

    private void ctQ() {
        if (this.irH == null && this.irr.getPageContext() != null) {
            String[] strArr = {this.irr.getPageContext().getPageActivity().getString(R.string.take_photo), this.irr.getPageContext().getPageActivity().getString(R.string.album)};
            this.irH = new com.baidu.tbadk.core.dialog.b(this.irr.getPageContext().getPageActivity());
            this.irH.AI(this.irr.getPageContext().getPageActivity().getString(R.string.operation));
            this.irH.a(strArr, new b.InterfaceC0550b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.irr.ctj();
                    } else if (i == 1 && q.this.irr.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.irr.getPageContext().getPageActivity());
                    }
                }
            });
            this.irH.d(this.irr.getPageContext());
        }
    }

    public void ctR() {
        ctQ();
        if (this.irH != null) {
            this.irH.bkL();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.y.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                s sVar = new s();
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList3 = new ArrayList<>();
                arrayList3.add(sVar);
                if (this.irr != null && this.irr.csy() != null && this.irr.csy().cyC() == 0) {
                    sVar.yq(this.irr.csy().cyJ());
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = switchThreadDataToThreadCardInfo;
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.q qVar = arrayList2.get(i2);
                    if (qVar instanceof bv) {
                        ((bv) qVar).eji.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.irF.b(arrayList2, frsViewData);
            if (this.hXO != null && this.ird != 0) {
                this.hXO.a(this.ird, this.fSe, this.irN, true);
            }
            if (this.irr != null) {
                this.irr.ctt();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.irE;
    }

    public void ctS() {
        this.irF.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.irr.getPageContext(), 1);
        aVar.a(this.irE);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.irr.getForumName());
        hashMap.put("forum_id", this.irr.getForumId());
        aVar.setParams(hashMap);
        aVar.aB(adVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.irO != null) {
            this.irO.czS();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        yf(TbadkCoreApplication.getInst().getSkinType());
        if (this.irO != null) {
            this.irO.czT();
        }
    }

    public void release() {
        if (this.fRL != null && this.ime != null) {
            this.fRL.b(this.ime);
        }
    }

    public ImageView ctT() {
        return this.iry;
    }

    public ImageView ctU() {
        return this.irx;
    }

    public TextView ctV() {
        return this.irz;
    }

    public View ctW() {
        if (this.irw != null) {
            return this.irw.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.irw != null) {
            this.irw.A(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.irr, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.irr.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.irS != null) {
            this.irS.invalidate();
        }
        if (this.irF != null) {
            this.irF.cwx();
            this.irF.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.irr.getPageContext(), this.irs);
        if (this.fRL != null) {
            this.fRL.onChangeSkinType(this.irr.getPageContext(), i);
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
            this.fTv.changeSkin(i);
        }
        if (this.isj != null) {
            this.isj.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
        yf(i);
        if (this.irP != null) {
            this.irP.onChangeSkinType(i);
        }
        if (this.irO != null) {
            this.irO.onChangeSkinType(i);
        }
        if (this.isf != null) {
            this.isf.onChangeSkinType();
        }
        if (this.isg != null) {
            this.isg.onChangeSkinType();
        }
        if (this.irr != null && this.irr.csI()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iru, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iru, R.color.cp_bg_line_d);
        }
    }

    private void yf(int i) {
        if (this.irr != null) {
            yg(i);
        }
    }

    private void yg(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.irr.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.irJ, R.color.cp_bg_line_c, i);
            if (this.irw != null) {
                this.irw.onChangeSkinType(i);
            }
            if (this.iry != null) {
                SvgManager.bmU().a(this.iry, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.irx != null) {
                SvgManager.bmU().a(this.irx, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bvC, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.irU, R.color.cp_bg_line_h);
        pb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pb(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gyB) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.isk != 0) {
                    SvgManager.bmU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bmU().a(this.iry, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bmU().a(this.hLB, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bmU().a(this.irx, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.isk = 0;
                }
            } else if (z || this.isk != 1) {
                SvgManager.bmU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bmU().a(this.iry, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bmU().a(this.hLB, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bmU().a(this.irx, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.isk = 1;
            }
            ctX();
        }
    }

    private void ctX() {
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
            if (this.isj != null) {
                this.isj.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.hLB != null) {
                    this.hLB.setAlpha(f);
                }
                if (this.hLC != null) {
                    this.hLC.setAlpha(f);
                }
                if (this.iry != null) {
                    this.iry.setAlpha(f);
                }
                if (this.irx != null) {
                    this.irx.setAlpha(f);
                }
            }
            if (this.irz != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.irz.setAlpha(f2);
                this.irz.setClickable(f2 > 0.0f);
            }
            if (this.bvC != null) {
                this.bvC.setAlpha(alpha);
            }
            if (this.irU != null) {
                this.irU.setAlpha(alpha);
            }
            if (this.irJ != null) {
                this.irJ.setAlpha(alpha);
            }
        }
    }

    public void bKf() {
        if (this.irG != null) {
            this.irG.bKf();
        }
    }

    public void pc(boolean z) {
        if (this.irG != null) {
            this.irG.pc(z);
        }
    }

    public void pd(boolean z) {
        this.irL = z;
        if (this.irL) {
            this.fTv.setText(this.irr.getResources().getString(R.string.load_more));
            if (this.irE.getChildAt(this.irE.getChildCount() - 1) == this.fTv.getView()) {
                this.fTv.startLoadData();
                this.irr.bJG();
                return;
            }
            this.fTv.endLoadData();
            return;
        }
        this.fTv.setText(this.irr.getResources().getString(R.string.load_more_must_after_delete));
        this.fTv.endLoadData();
    }

    public boolean ctY() {
        if (this.irL) {
            return false;
        }
        this.fTv.setText(this.irr.getResources().getString(R.string.load_more_must_after_delete));
        this.fTv.endLoadData();
        return true;
    }

    public boolean ctZ() {
        return this.irA != null && this.irD.getVisibility() == 0;
    }

    public void cua() {
        if (this.irA != null) {
            this.irB.setVisibility(0);
            this.irD.setVisibility(8);
            this.irC.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.isn, 5000L);
        }
    }

    public void a(cg cgVar) {
        if (this.irA == null) {
            View rootView = this.irr.getRootView();
            this.irA = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.irA.setVisibility(0);
            this.irB = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.irC = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.irD = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.irC.setPageId(this.irr.getUniqueId());
            this.irD.setPageId(this.irr.getUniqueId());
            this.irC.setDefaultBgResource(R.color.common_color_10022);
            this.irC.setDefaultResource(0);
            this.irD.setDefaultBgResource(R.color.common_color_10022);
            this.irD.setDefaultResource(0);
            this.irB.setOnClickListener(this.irI);
        }
        this.irB.setVisibility(0);
        String bky = cgVar.bky();
        String bkz = cgVar.bkz();
        this.irC.startLoad(bky, 10, false);
        this.irD.startLoad(bkz, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.isn, 5000L);
    }

    public void cub() {
        if (this.irA != null && this.irB != null) {
            this.irB.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al cuc() {
        return this.irF;
    }

    public RelativeLayout cew() {
        return this.irs;
    }

    public View cud() {
        return this.irK;
    }

    public void yh(int i) {
        if (this.iru != null) {
            this.iru.setVisibility(i);
        }
    }

    public void cue() {
        if (com.baidu.tbadk.n.m.byc().byd()) {
            int lastVisiblePosition = this.irE.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.irE.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.isB != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.isB.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fgL = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.isB.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.isB.startLogPerf();
                    }
                    if (uVar.isA != null && (uVar.isA instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.isA;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fgL = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar bNC() {
        return this.mNavigationBar;
    }

    public void SI() {
        this.mHasMore = true;
        this.irE.setNextPage(this.fTv);
        if (this.irM > 0) {
            this.fTv.showEmptyView(this.irM);
        }
        this.fTv.setOnClickListener(null);
        this.fTv.startLoadData();
    }

    public void SJ() {
        this.mHasMore = false;
        this.irE.setNextPage(this.fTv);
        if (this.irM > 0) {
            this.fTv.showEmptyView(this.irM);
        }
        this.fTv.setOnClickListener(null);
        this.fTv.endLoadData();
        this.fTv.setText(this.irr.getResources().getString(R.string.list_has_no_more));
    }

    public void cuf() {
        this.mHasMore = true;
        this.irE.setNextPage(this.fTv);
        this.fTv.setOnClickListener(this.irI);
        if (this.irM > 0) {
            this.fTv.showEmptyView(this.irM);
        }
        this.fTv.endLoadData();
        this.fTv.setText(this.irr.getResources().getString(R.string.list_click_load_more));
    }

    public View cug() {
        if (this.fTv == null) {
            return null;
        }
        return this.fTv.getView();
    }

    public void yi(int i) {
        if (this.isf != null) {
            this.isf.setVisibility(i);
        }
    }

    public void yj(int i) {
        if (this.isf != null) {
            this.isf.setSelectNumber(i);
        }
    }

    public void yk(int i) {
        if (this.isg != null) {
            this.isg.setVisibility(i);
        }
    }

    public void yl(int i) {
        if (this.isg != null) {
            this.isg.setMoveNumber(i);
        }
    }

    public boolean cuh() {
        return this.isg != null && this.isg.cBy();
    }

    public void cui() {
        if (this.isg != null) {
            this.isg.cBz();
        }
    }

    public void bKU() {
        this.mHasMore = false;
        this.irE.setNextPage(null);
    }

    public boolean cuj() {
        return this.fTv.getView().getParent() != null && this.mHasMore;
    }

    public void ym(int i) {
        this.irM = i;
    }

    public void yn(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.hYJ == null) {
                    this.hYJ = new CommonTipView(this.irr.getActivity());
                }
                this.hYJ.setText(R.string.frs_login_tip);
                this.hYJ.b((FrameLayout) cud(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void pe(boolean z) {
        this.mIsBackground = z;
        if (this.hXO != null) {
            boolean z2 = (this.irr == null || this.irr.csB() == null || this.irr.csB().cAK() == null) ? true : this.irr.csB().cAK().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.hXO.sw(false);
                this.hXO.cUt();
                return;
            }
            this.hXO.sw(true);
            this.hXO.a(this.ird, this.fSe, this.irN, true);
        }
    }

    public void cj(int i, int i2) {
        if (this.hXO != null) {
            this.hXO.a(i, i2, this.irN, 1);
        }
    }

    public void ck(int i, int i2) {
        this.ird = i;
        this.fSe = i2;
    }

    public void pf(boolean z) {
        this.irN = z;
    }

    public void yo(int i) {
        if (this.irE != null && this.irE.getChildCount() >= 0) {
            if (this.irE.getFirstVisiblePosition() > 8) {
                this.irE.scrollToPosition(8);
            }
            this.irE.smoothScrollToPosition(i);
        }
    }

    public void cuk() {
        a(this.irW, this.irr.ctk());
        if (this.irF != null) {
            this.irF.cwu();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.irr.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.irX == null) {
                this.irX = new com.baidu.tieba.video.f(this.irr.getActivity(), this.irs);
            }
            this.irX.j(postWriteCallBackData);
        }
    }

    public void cul() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.iso && this.irr.getActivity() != null && this.irr.getPageContext() != null) {
            View view = null;
            if (this.irE != null && (headerViewsCount = this.irE.getHeaderViewsCount()) < this.irE.getChildCount()) {
                view = this.irE.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.irr.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getAnchor() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getFitPosition() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.getDimens(q.this.irr.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.irr.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mi = dVar.mi();
                mi.setShouldCheckLocInWindow(false);
                mi.show(this.irr.getActivity());
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mi != null) {
                            mi.dismiss();
                        }
                    }
                }, 4000L);
                this.iso = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.isf != null) {
            this.isf.setDeleteCallback(aVar);
        }
    }

    public void cum() {
        if (this.isf != null) {
            this.isf.cum();
        }
    }

    public void bEe() {
        if (this.isf != null) {
            this.isf.bEe();
        }
    }

    public void aM(String str, int i) {
        if (this.isi == null) {
            this.isi = new TextView(this.irr.getActivity());
            this.isi.setGravity(19);
            this.isi.setPadding(com.baidu.adp.lib.util.l.getDimens(this.irr.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.irr.getActivity(), R.dimen.ds34), 0);
            this.isi.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.irr.getActivity(), R.dimen.tbds112)));
            this.isi.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.irr.getActivity(), R.dimen.fontsize30));
            this.isi.setMaxLines(2);
            this.isi.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.isi.setTextColor(ContextCompat.getColor(this.irr.getActivity(), R.color.cp_cont_a));
        }
        this.ish.setBackgroundColor(i);
        this.isi.setText(str);
        this.ish.a(this.irr.getActivity(), this.isi, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Yg != null) {
            this.Yg.setExpanded(z);
        }
    }

    public void cun() {
        if (this.irG != null) {
            this.irG.startPullRefresh();
        }
    }

    public void FS() {
        if (cuc() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = cuc().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.epi != 0 && bvVar.eji != null && this.irr.csy() != null && this.irr.csy().cyf() != null) {
                            int[] imageWidthAndHeight = bvVar.eji.getImageWidthAndHeight();
                            bvVar.epi = imageWidthAndHeight[0];
                            bvVar.epj = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cuc().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.hXO.a(q.this.ird, q.this.fSe, q.this.irN, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cuo() {
        if (this.irO == null) {
            return false;
        }
        return this.irO.cuo();
    }

    public Context getContext() {
        if (this.irr == null) {
            return null;
        }
        return this.irr.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.irG != null) {
            this.irG.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.irG != null) {
            this.irG.startPullRefresh();
        }
    }

    public void cup() {
        if (this.irG != null) {
            this.irG.cup();
        }
    }

    public void cuq() {
        if (this.irG != null) {
            this.irG.cuq();
        }
    }

    public void a(au auVar) {
        if (this.irG != null) {
            this.irG.a(auVar);
        }
    }

    public void yp(int i) {
        if (this.irG != null) {
            this.irG.yp(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cur() {
        return this.irG;
    }
}
