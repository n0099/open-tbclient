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
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bu;
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
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.FloatingAnimationView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class n {
    private AppBarLayout Wr;
    private NoNetworkView fay;
    private PbListView fcj;
    private ImageView gKc;
    private MessageRedDotView gKd;
    private com.baidu.tieba.play.m gWx;
    private CommonTipView gXr;
    private com.baidu.adp.widget.ListView.m gYq;
    private com.baidu.tieba.frs.entelechy.a.ai hpA;
    private com.baidu.tieba.frs.vc.k hpB;
    private FloatingAnimationView hpC;
    private com.baidu.tieba.c.c hpD;
    private View.OnClickListener hpF;
    private View hpG;
    private View hpH;
    private int hpJ;
    private com.baidu.tieba.frs.vc.d hpL;
    private com.baidu.tieba.frs.entelechy.b.c hpM;
    private com.baidu.tieba.frs.vc.m hpN;
    private GifView hpO;
    private TbImageView hpP;
    private HashSet<String> hpQ;
    private ObservedChangeLinearLayout hpS;
    private com.baidu.tieba.frs.entelechy.b.a hpT;
    private com.baidu.tieba.video.f hpU;
    private AppBarLayoutStickyBehavior hpV;
    private FrsHeaderViewContainer hpW;
    private CollapsingToolbarLayout hpX;
    private FrsFragment hpm;
    private View hpq;
    private com.baidu.tieba.c.b hpr;
    private ImageView hps;
    private ImageView hpt;
    private TextView hpu;
    private ViewStub hpv;
    private BdTypeRecyclerView hpz;
    private com.baidu.tieba.frs.vc.h hqb;
    private FrsMultiDelBottomMenuView hqc;
    private NavigationBarCoverTip hqd;
    private TextView hqe;
    private TextView hqf;
    private boolean hqk;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout hpn = null;
    private CoordinatorLayout hpo = null;
    private View hpp = null;
    private FrameLayout hpw = null;
    private TbImageView hpx = null;
    private TbImageView hpy = null;
    private com.baidu.tbadk.core.dialog.b hpE = null;
    private NoNetworkView.a hkP = null;
    private boolean hpI = true;
    private boolean mHasMore = true;
    private boolean hpK = false;
    private int hpb = 0;
    private int faR = 0;
    private View bdq = null;
    private View hpR = null;
    private boolean fEs = false;
    private boolean dgY = true;
    private boolean hpY = true;
    private int hpZ = -1;
    private int hqa = -1;
    private int hqg = 0;
    private int hqh = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener gYs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (n.this.gYq == null) {
                        n.this.gYq = new com.baidu.adp.widget.ListView.m(new com.baidu.adp.widget.ListView.k());
                    }
                    n.this.gYq.a(n.this.hpz, 2);
                } else if (n.this.gYq != null) {
                    n.this.gYq.pl();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hqi = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.n.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            n.this.a(appBarLayout, i);
            if (n.this.hpB != null) {
                n.this.hpB.setInterceptScrollDown(i == 0);
            }
            if (n.this.hqa != i && Math.abs(i) >= 0 && n.this.bVR() != -1) {
                if (Math.abs(i) >= n.this.bVR()) {
                    if (n.this.hpY) {
                        n.this.hpY = false;
                        n.this.mP(n.this.hpY);
                    }
                } else if (!n.this.hpY) {
                    n.this.hpY = true;
                    n.this.mP(n.this.hpY);
                }
                int bVN = n.this.bVN() + n.this.bVM() + n.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bVN;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && n.this.hqa - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        n.this.tO(Math.abs(bVN - totalScrollRange2));
                        if (n.this.hpR != null) {
                            n.this.hpR.setVisibility(0);
                        }
                    } else if (n.this.hpR != null) {
                        if (n.this.bVL() != UtilHelper.getStatusBarHeight()) {
                            n.this.tO(0);
                        }
                        n.this.hpR.setVisibility(8);
                    }
                    if (n.this.mNavigationBar != null) {
                        if (n.this.fEs) {
                            n.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            n.this.mU(false);
                        } else if (n.this.hqf != null) {
                            n.this.hqf.setAlpha(abs);
                        }
                    }
                    n.this.hqa = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (n.this.hpB != null) {
                int cck = n.this.hpB.cck();
                int ccl = cck - n.this.hpB.ccl();
                if (cck > 0 && Math.abs(i) >= ccl) {
                    n.this.hpB.dismissLoading();
                }
            }
        }
    };
    private Runnable hqj = new Runnable() { // from class: com.baidu.tieba.frs.n.13
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.hpv != null) {
                n.this.hpw.setVisibility(0);
                n.this.hpy.setVisibility(0);
                n.this.hpx.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.hpm != null && appBarLayout != null && this.hpm.bUR() != null && this.hpm.getPageContext() != null) {
            int bVM = bVM() + getNavigationBarHeight() + bVN();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bUR = this.hpm.bUR();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.hpm.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.hpm.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.hpp.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.hpm != null && this.hpm.bUY();
            if (totalScrollRange <= 0) {
                if (this.hqh != 2) {
                    bUR.vG(2);
                }
                this.hqh = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bVM) {
                if (this.hqh != 1) {
                    bUR.vG(1);
                }
                this.hqh = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.hqh != 0) {
                    bUR.vG(0);
                }
                this.hqh = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.hpm.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.hpp.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bVJ() {
        return this.hpS;
    }

    public View Hh() {
        return this.bdq;
    }

    public View bVK() {
        return this.hpR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVL() {
        if (this.bdq == null) {
            return 0;
        }
        return this.bdq.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVM() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVN() {
        if (this.fay == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fay.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(int i) {
        View Hh = Hh();
        View bVK = bVK();
        if (UtilHelper.canUseStyleImmersiveSticky() && Hh != null && bVK != null && Hh.getLayoutParams() != null && bVK.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Hh.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Hh.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bVK.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bVK.setLayoutParams(layoutParams2);
        }
    }

    public n(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.hpm = null;
        this.hpF = null;
        this.hpJ = 0;
        this.hpm = frsFragment;
        this.hpF = onClickListener;
        MessageManager.getInstance().registerListener(this.gYs);
        a(aVar, z);
        this.hpQ = new HashSet<>();
        this.hpJ = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hqb = hVar;
    }

    private boolean bVO() {
        return this.hqb != null && this.hqb.cbW();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v22, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.hpT = aVar;
        View rootView = this.hpm.getRootView();
        if (this.hpn == null) {
            this.hpn = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.hpp == null) {
            this.hpp = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.hpo == null) {
            this.hpo = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.hpH == null) {
            this.hpH = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.hpX == null) {
            this.hpX = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.hpW == null) {
            this.hpW = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.hpB == null) {
            this.hpB = new com.baidu.tieba.frs.vc.k(this.hpm);
        }
        if (this.hpS == null) {
            this.hpS = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.hpS.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.n.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        n.this.hpX.setMinimumHeight(i2);
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
        if (this.hpm.bVx()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.hpG == null) {
            this.hpG = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bXW = aVar.bXW();
            if (bXW != null) {
                bXW.bX(this.hpG);
            }
        }
        if (this.hpq == null) {
            this.hpq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hpq.setOnClickListener(this.hpF);
            this.mBackImageView = (ImageView) this.hpq.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hpt == null) {
            this.hpt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.aUW().a(this.hpt, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hpt.setOnClickListener(this.hpF);
        }
        if (this.hpr == null) {
            this.hpr = new com.baidu.tieba.c.b(this.hpm.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hpr.getView(), (View.OnClickListener) null);
            this.gKc = this.hpr.bMr();
            this.gKd = this.hpr.bMs();
            this.hpr.getView().setOnClickListener(this.hpF);
            this.hpr.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.hps == null) {
            this.hps = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.aUW().a(this.hps, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hps.setOnClickListener(this.hpF);
        }
        if (this.hpu == null) {
            this.hpu = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.hpu.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.hpm.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hpu.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.e(this.hpu, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hpu, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.hpm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.hpz == null) {
            this.hpz = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.n.8
            int hqn = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.hqn--;
                if (this.hqn == 0) {
                    n.this.hpz.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.hqn++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.hpz.setItemAnimator(defaultItemAnimator);
        this.hpz.setLayoutManager(new LinearLayoutManager(this.hpz.getContext()) { // from class: com.baidu.tieba.frs.n.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gYq = new com.baidu.adp.widget.ListView.m(new com.baidu.adp.widget.ListView.k());
            this.gYq.a(this.hpz, 2);
        }
        this.hpz.setScrollable(this.hpm);
        this.hpz.setFadingEdgeLength(0);
        this.hpz.setOverScrollMode(2);
        this.hpn.setBottomOrderView(this.hpz);
        this.hpz.setOnTouchListener(this.hpm.evw);
        this.hpz.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.n.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (n.this.gWx != null) {
                    n.this.gWx.ct(view);
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
        if (this.fcj == null) {
            this.fcj = new PbListView(this.hpm.getPageContext().getPageActivity());
            this.fcj.getView();
        }
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fcj.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hpm.getActivity(), R.dimen.tbds182));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hpz.setOnSrollToBottomListener(this.hpm);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.n.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.hpm.bVq();
                if (n.this.hpm != null && n.this.Wr != null) {
                    n.this.hpm.bVA();
                    n.this.Wr.setExpanded(true);
                    if (n.this.gWx != null) {
                        n.this.gWx.a(n.this.hpb, n.this.faR, false, true);
                    }
                }
            }
        });
        boolean aUY = com.baidu.tbadk.core.util.ar.aUX().aUY();
        if (this.hpA == null) {
            this.hpA = aVar.a(this.hpm, this.hpz, aUY);
        }
        if (this.hpB != null) {
            this.hpB.K(1, false);
        }
        if (!z) {
            if (this.fay == null) {
                this.fay = new NoNetworkView(this.hpm.getActivity());
                this.fay.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.hpS.addView(this.fay);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fay.setVisibility(8);
            } else {
                this.fay.setVisibility(0);
            }
            this.fay.onChangeSkinType(this.hpm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bVY();
        if (this.hpL == null) {
            this.hpL = aVar.a(this.hpm, this.hpn);
            this.hpL.b(this.hpm.bVB());
        }
        if (this.hpM == null) {
            this.hpM = aVar.b(this.hpm, this.hpn);
            mS(true);
        }
        if (this.bdq == null) {
            this.bdq = rootView.findViewById(R.id.statebar_view);
        }
        if (this.hpR == null) {
            this.hpR = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.gWx == null) {
            this.gWx = new com.baidu.tieba.play.m(this.hpm.getPageContext(), this.hpz);
        }
        this.gWx.BL(1);
        this.gWx.setUniqueId(this.hpm.getUniqueId());
        this.hqd = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.hpN == null) {
            this.hpN = new com.baidu.tieba.frs.vc.m(this.hpm, this.hqd);
        }
        if (this.Wr == null) {
            this.Wr = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Wr.addOnOffsetChangedListener(this.hqi);
            this.hpY = true;
            this.hpZ = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Wr.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.hpV = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.hqc = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.hqc.setPageContext(this.hpm.getPageContext());
        this.hpC = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.hpC.setPageId(this.hpm.getUniqueId());
        this.hpD = new com.baidu.tieba.c.c(this.hpm.getTbPageContext(), this.hpC, 2);
        if (this.hqf == null) {
            this.hqf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hpm.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.hqf.setLayoutParams(layoutParams2);
            this.hqf.setPadding(0, 0, this.hpm.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.hqf.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
        }
    }

    public void bB(boolean z) {
        if (z && this.hpD != null) {
            this.hpD.aJZ();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.p pVar) {
        if (this.hpD != null) {
            this.hpD.a(pVar);
        }
    }

    private void bVP() {
        ViewGroup.LayoutParams layoutParams;
        this.fEs = bVO();
        if (this.hpW != null && (layoutParams = this.hpW.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.fEs) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bVM(), 0, 0);
            }
            this.hpW.requestLayout();
        }
    }

    public void bVQ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hpS != null) {
            bVP();
            if (this.fEs) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bdq != null) {
                    this.bdq.setAlpha(1.0f);
                }
                if (this.hpR != null) {
                    this.hpR.setAlpha(1.0f);
                }
                if (this.hqf != null) {
                    this.hqf.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(boolean z) {
        if (z && this.hpm != null && this.hpm.bUQ() != null) {
            this.hpm.bUQ().ccb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVR() {
        int i;
        if (this.Wr == null) {
            return this.hpZ;
        }
        if (this.hpZ != -1) {
            return this.hpZ;
        }
        int childCount = this.Wr.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Wr.getChildAt(childCount);
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
        this.hpZ = Math.max(0, this.Wr.getTotalScrollRange() - Math.abs(i2));
        return this.hpZ;
    }

    public void ED(String str) {
        if (this.hpN != null) {
            this.hpN.ED(str);
        }
    }

    public com.baidu.tieba.play.m bVS() {
        return this.gWx;
    }

    public com.baidu.tieba.frs.entelechy.b.c bVT() {
        return this.hpM;
    }

    public void mQ(boolean z) {
        if (this.hpL != null) {
            this.hpL.mQ(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bVU() {
        return this.hpL;
    }

    public void P(boolean z, boolean z2) {
        if (this.dgY && this.hpM != null) {
            this.hpM.P(z, z2);
        }
    }

    public void mR(boolean z) {
        this.dgY = z;
        if (!this.dgY && this.hpM != null) {
            this.hpM.P(false, false);
        }
    }

    public void bVV() {
        if (this.dgY && this.hpM != null) {
            this.hpM.P(false, false);
        }
        tP(8);
        this.hpt.setVisibility(8);
        this.hps.setVisibility(8);
        mQ(false);
        this.hpz.setVisibility(8);
        this.hpW.setVisibility(8);
    }

    public void bVW() {
        if (this.dgY && this.hpM != null) {
            this.hpM.P(true, false);
        }
        tP(0);
        bVX();
        mQ(this.hpm.bVD());
        this.hpz.setVisibility(0);
        this.hpW.setVisibility(0);
    }

    private void tP(int i) {
        if (this.hpr != null) {
            this.hpr.setVisibility(i);
        }
    }

    private void bVX() {
        this.hpt.setVisibility(0);
        this.hps.setVisibility(0);
    }

    public void mS(boolean z) {
        if (this.hpM != null) {
            this.hpM.nt(z);
        }
    }

    private void bVY() {
        if (this.hpO == null) {
            View rootView = this.hpm.getRootView();
            this.hpO = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.hpP = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.hpP.setPageId(this.hpm.getUniqueId());
            this.hpO.setLayerType(1, null);
            this.hpP.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bVZ() {
        return this.hpq;
    }

    public void g(NoNetworkView.a aVar) {
        this.hkP = aVar;
        if (this.fay != null) {
            this.fay.a(this.hkP);
        }
    }

    public void mT(boolean z) {
        if (this.hpM != null) {
            if (z) {
                P(false, true);
            } else {
                P(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hpz.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.hpA.a(xVar);
    }

    public void setForumName(String str) {
        this.hpA.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gYs);
        if (this.gWx != null) {
            this.gWx.destroy();
        }
        if (this.hpN != null) {
            this.hpN.onDestory();
        }
        if (this.hqc != null) {
            this.hqc.setPageContext(null);
        }
        this.hpA.onDestory();
        this.hpz.setOnSrollToBottomListener(null);
        this.hpz.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.hqj);
        if (this.gXr != null) {
            this.gXr.onDestroy();
        }
        this.hpQ.clear();
        if (this.hpL != null) {
            this.hpL.cbG();
        }
        if (this.hpU != null) {
            this.hpU.bXG();
        }
        if (this.hpD != null) {
            this.hpD.onDestroy();
        }
        if (this.hqd != null) {
            this.hqd.onDestroy();
        }
        if (this.hqc != null) {
            this.hqc.onDestroy();
        }
        if (this.hpB != null) {
            this.hpB.onDestroy();
        }
    }

    public boolean bWa() {
        if (this.Wr == null || this.hpV == null || !this.hpV.isSticky()) {
            return this.hpL != null && this.hpL.bWa();
        }
        if (this.hpz != null) {
            this.hpz.setSelection(0);
        }
        this.hpV.expandedAppBarLayout(this.Wr);
        return true;
    }

    public boolean bVv() {
        if (this.hpB == null) {
            return false;
        }
        return this.hpB.bVv();
    }

    public void bvO() {
        this.hpz.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.hqf.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.hqf.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.hqf.setText(str2);
            com.baidu.tbadk.core.k.aNQ().setForumNameForWaterImage(str);
        }
    }

    public void bWb() {
        if (this.hpA != null) {
            this.hpA.notifyDataSetChanged();
        }
    }

    public void aES() {
        if (this.hpA instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.hpA).aES();
        }
    }

    private void bWc() {
        if (this.hpE == null && this.hpm.getPageContext() != null) {
            String[] strArr = {this.hpm.getPageContext().getPageActivity().getString(R.string.take_photo), this.hpm.getPageContext().getPageActivity().getString(R.string.album)};
            this.hpE = new com.baidu.tbadk.core.dialog.b(this.hpm.getPageContext().getPageActivity());
            this.hpE.vP(this.hpm.getPageContext().getPageActivity().getString(R.string.operation));
            this.hpE.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.n.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        n.this.hpm.bVw();
                    } else if (i == 1 && n.this.hpm.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(n.this.hpm.getPageContext().getPageActivity());
                    }
                }
            });
            this.hpE.d(this.hpm.getPageContext());
        }
    }

    public void bWd() {
        bWc();
        if (this.hpE != null) {
            this.hpE.aSU();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.o> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.o> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.o> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.v.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                p pVar = new p();
                ArrayList<com.baidu.adp.widget.ListView.o> arrayList3 = new ArrayList<>();
                arrayList3.add(pVar);
                if (this.hpm != null && this.hpm.bUO() != null && this.hpm.bUO().caw() == 0) {
                    pVar.tZ(this.hpm.bUO().caD());
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = switchThreadDataToThreadCardInfo;
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList2) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.o oVar = arrayList2.get(i2);
                    if (oVar instanceof bj) {
                        ((bj) oVar).dEA.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.hpA.b(arrayList2, frsViewData);
            if (this.gWx != null && this.hpb != 0) {
                this.gWx.a(this.hpb, this.faR, this.hpK, true);
            }
            if (this.hpm != null) {
                this.hpm.bVF();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.hpz;
    }

    public void bWe() {
        this.hpA.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hpm.getPageContext(), 1);
        aVar.a(this.hpz);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.hpm.getForumName());
        hashMap.put("forum_id", this.hpm.getForumId());
        aVar.setParams(hashMap);
        aVar.at(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.hpL != null) {
            this.hpL.cbH();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        tQ(TbadkCoreApplication.getInst().getSkinType());
        if (this.hpL != null) {
            this.hpL.cbI();
        }
    }

    public void release() {
        if (this.fay != null && this.hkP != null) {
            this.fay.b(this.hkP);
        }
    }

    public ImageView bWf() {
        return this.hpt;
    }

    public ImageView bWg() {
        return this.hps;
    }

    public TextView bWh() {
        return this.hpu;
    }

    public View bWi() {
        if (this.hpr != null) {
            return this.hpr.getView();
        }
        return null;
    }

    public void J(int i, boolean z) {
        if (this.hpr != null) {
            this.hpr.v(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.hpm, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hpm.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.hpP != null) {
            this.hpP.invalidate();
        }
        if (this.hpA != null) {
            this.hpA.bYu();
            this.hpA.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.hpm.getPageContext(), this.hpn);
        if (this.fay != null) {
            this.fay.onChangeSkinType(this.hpm.getPageContext(), i);
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.fcj.changeSkin(i);
        }
        if (this.hqf != null) {
            this.hqf.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
        }
        tQ(i);
        if (this.hpM != null) {
            this.hpM.onChangeSkinType(i);
        }
        if (this.hpL != null) {
            this.hpL.onChangeSkinType(i);
        }
        if (this.hqc != null) {
            this.hqc.onChangeSkinType();
        }
        if (this.hpm != null && this.hpm.bUY()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpp, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpp, R.color.cp_bg_line_d);
        }
    }

    private void tQ(int i) {
        if (this.hpm != null) {
            tR(i);
        }
    }

    private void tR(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hpm.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpG, R.color.cp_bg_line_c, i);
            if (this.hpr != null) {
                this.hpr.onChangeSkinType(i);
            }
            if (this.hpt != null) {
                SvgManager.aUW().a(this.hpt, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hps != null) {
                SvgManager.aUW().a(this.hps, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.bdq, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpR, R.color.cp_bg_line_h);
        mU(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fEs) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.hqg != 0) {
                    SvgManager.aUW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUW().a(this.hpt, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUW().a(this.gKc, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUW().a(this.hps, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.hqg = 0;
                }
            } else if (z || this.hqg != 1) {
                SvgManager.aUW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUW().a(this.hpt, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUW().a(this.gKc, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUW().a(this.hps, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.hqg = 1;
            }
            bWj();
        }
    }

    private void bWj() {
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
            if (this.hqf != null) {
                this.hqf.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.gKc != null) {
                    this.gKc.setAlpha(f);
                }
                if (this.gKd != null) {
                    this.gKd.setAlpha(f);
                }
                if (this.hpt != null) {
                    this.hpt.setAlpha(f);
                }
                if (this.hps != null) {
                    this.hps.setAlpha(f);
                }
            }
            if (this.hpu != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.hpu.setAlpha(f2);
                this.hpu.setClickable(f2 > 0.0f);
            }
            if (this.bdq != null) {
                this.bdq.setAlpha(alpha);
            }
            if (this.hpR != null) {
                this.hpR.setAlpha(alpha);
            }
            if (this.hpG != null) {
                this.hpG.setAlpha(alpha);
            }
        }
    }

    public void bqX() {
        if (this.hpB != null) {
            this.hpB.bqX();
        }
    }

    public void mV(boolean z) {
        if (this.hpB != null) {
            this.hpB.mV(z);
        }
    }

    public void mW(boolean z) {
        this.hpI = z;
        if (this.hpI) {
            this.fcj.setText(this.hpm.getResources().getString(R.string.load_more));
            if (this.hpz.getChildAt(this.hpz.getChildCount() - 1) == this.fcj.getView()) {
                this.fcj.startLoadData();
                this.hpm.bqx();
                return;
            }
            this.fcj.endLoadData();
            return;
        }
        this.fcj.setText(this.hpm.getResources().getString(R.string.load_more_must_after_delete));
        this.fcj.endLoadData();
    }

    public boolean bWk() {
        if (this.hpI) {
            return false;
        }
        this.fcj.setText(this.hpm.getResources().getString(R.string.load_more_must_after_delete));
        this.fcj.endLoadData();
        return true;
    }

    public boolean bWl() {
        return this.hpv != null && this.hpy.getVisibility() == 0;
    }

    public void bWm() {
        if (this.hpv != null) {
            this.hpw.setVisibility(0);
            this.hpy.setVisibility(8);
            this.hpx.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.hqj, 5000L);
        }
    }

    public void a(bu buVar) {
        if (this.hpv == null) {
            View rootView = this.hpm.getRootView();
            this.hpv = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.hpv.setVisibility(0);
            this.hpw = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.hpx = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.hpy = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.hpx.setPageId(this.hpm.getUniqueId());
            this.hpy.setPageId(this.hpm.getUniqueId());
            this.hpx.setDefaultBgResource(R.color.common_color_10022);
            this.hpx.setDefaultResource(0);
            this.hpy.setDefaultBgResource(R.color.common_color_10022);
            this.hpy.setDefaultResource(0);
            this.hpw.setOnClickListener(this.hpF);
        }
        this.hpw.setVisibility(0);
        String aSM = buVar.aSM();
        String aSN = buVar.aSN();
        this.hpx.startLoad(aSM, 10, false);
        this.hpy.startLoad(aSN, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.hqj, 5000L);
    }

    public void bWn() {
        if (this.hpv != null && this.hpw != null) {
            this.hpw.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.ai bWo() {
        return this.hpA;
    }

    public RelativeLayout bIN() {
        return this.hpn;
    }

    public View bWp() {
        return this.hpH;
    }

    public void tS(int i) {
        if (this.hpp != null) {
            this.hpp.setVisibility(i);
        }
    }

    public void bWq() {
        if (com.baidu.tbadk.n.m.bfJ().bfK()) {
            int lastVisiblePosition = this.hpz.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hpz.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hqx != null) {
                        com.baidu.tbadk.n.h perfLog = rVar.hqx.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.erV = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hqx.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hqx.startLogPerf();
                    }
                    if (rVar.hqw != null && (rVar.hqw instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hqw;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.erV = true;
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

    public NavigationBar bua() {
        return this.mNavigationBar;
    }

    public void brM() {
        this.mHasMore = true;
        this.hpz.setNextPage(this.fcj);
        if (this.hpJ > 0) {
            this.fcj.showEmptyView(this.hpJ);
        }
        this.fcj.setOnClickListener(null);
        this.fcj.startLoadData();
    }

    public void brN() {
        this.mHasMore = false;
        this.hpz.setNextPage(this.fcj);
        if (this.hpJ > 0) {
            this.fcj.showEmptyView(this.hpJ);
        }
        this.fcj.setOnClickListener(null);
        this.fcj.endLoadData();
        this.fcj.setText(this.hpm.getResources().getString(R.string.list_has_no_more));
    }

    public void bWr() {
        this.mHasMore = true;
        this.hpz.setNextPage(this.fcj);
        this.fcj.setOnClickListener(this.hpF);
        if (this.hpJ > 0) {
            this.fcj.showEmptyView(this.hpJ);
        }
        this.fcj.endLoadData();
        this.fcj.setText(this.hpm.getResources().getString(R.string.list_click_load_more));
    }

    public View bWs() {
        if (this.fcj == null) {
            return null;
        }
        return this.fcj.getView();
    }

    public void tT(int i) {
        if (this.hqc != null) {
            this.hqc.setVisibility(i);
        }
    }

    public void tU(int i) {
        if (this.hqc != null) {
            this.hqc.setSelectNumber(i);
        }
    }

    public void brO() {
        this.mHasMore = false;
        this.hpz.setNextPage(null);
    }

    public boolean bWt() {
        return this.fcj.getView().getParent() != null && this.mHasMore;
    }

    public void tV(int i) {
        this.hpJ = i;
    }

    public void tW(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.gXr == null) {
                    this.gXr = new CommonTipView(this.hpm.getActivity());
                }
                this.gXr.setText(R.string.frs_login_tip);
                this.gXr.b((FrameLayout) bWp(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void mX(boolean z) {
        this.mIsBackground = z;
        if (this.gWx != null) {
            boolean z2 = (this.hpm == null || this.hpm.bUR() == null || this.hpm.bUR().ccw() == null) ? true : this.hpm.bUR().ccw().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.gWx.qi(false);
                this.gWx.cux();
                return;
            }
            this.gWx.qi(true);
            this.gWx.a(this.hpb, this.faR, this.hpK, true);
        }
    }

    public void bP(int i, int i2) {
        if (this.gWx != null) {
            this.gWx.a(i, i2, this.hpK, 1);
        }
    }

    public void bQ(int i, int i2) {
        this.hpb = i;
        this.faR = i2;
    }

    public void mY(boolean z) {
        this.hpK = z;
    }

    public void tX(int i) {
        if (this.hpz != null && this.hpz.getChildCount() >= 0) {
            if (this.hpz.getFirstVisiblePosition() > 8) {
                this.hpz.scrollToPosition(8);
            }
            this.hpz.smoothScrollToPosition(i);
        }
    }

    public void bWu() {
        a(this.hpT, this.hpm.bVx());
        if (this.hpA != null) {
            this.hpA.bYr();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.hpU == null) {
                this.hpU = new com.baidu.tieba.video.f(this.hpm.getActivity(), this.hpn);
            }
            this.hpU.h(postWriteCallBackData);
        }
    }

    public void bWv() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.hqk && this.hpm.getActivity() != null && this.hpm.getPageContext() != null) {
            View view = null;
            if (this.hpz != null && (headerViewsCount = this.hpz.getHeaderViewsCount()) < this.hpz.getChildCount()) {
                view = this.hpz.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).Z(0).ae(true).af(false).ad(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.n.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        n.this.hpm.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(n.this.hpm.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(n.this.hpm.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.n.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c ko = dVar.ko();
                ko.setShouldCheckLocInWindow(false);
                ko.show(this.hpm.getActivity());
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.n.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ko != null) {
                            ko.dismiss();
                        }
                    }
                }, 4000L);
                this.hqk = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.hqc != null) {
            this.hqc.setDeleteCallback(aVar);
        }
    }

    public void bWw() {
        if (this.hqc != null) {
            this.hqc.bWw();
        }
    }

    public void bkQ() {
        if (this.hqc != null) {
            this.hqc.bkQ();
        }
    }

    public void aK(String str, int i) {
        if (this.hqe == null) {
            this.hqe = new TextView(this.hpm.getActivity());
            this.hqe.setGravity(19);
            this.hqe.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hpm.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.hpm.getActivity(), R.dimen.ds34), 0);
            this.hqe.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hpm.getActivity(), R.dimen.tbds112)));
            this.hqe.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hpm.getActivity(), R.dimen.fontsize30));
            this.hqe.setMaxLines(2);
            this.hqe.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.hqe.setTextColor(ContextCompat.getColor(this.hpm.getActivity(), R.color.cp_cont_a));
        }
        this.hqd.setBackgroundColor(i);
        this.hqe.setText(str);
        this.hqd.a(this.hpm.getActivity(), this.hqe, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Wr != null) {
            this.Wr.setExpanded(z);
        }
    }

    public void bWx() {
        if (this.hpB != null) {
            this.hpB.startPullRefresh();
        }
    }

    public void ya() {
        if (bWo() != null) {
            List<com.baidu.adp.widget.ListView.o> datas = bWo().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.o oVar : datas) {
                    if (oVar instanceof bj) {
                        bj bjVar = (bj) oVar;
                        if (bjVar.dEB != 0 && bjVar.dEA != null && this.hpm.bUO() != null && this.hpm.bUO().bZZ() != null) {
                            int[] imageWidthAndHeight = this.hpm.bUO().bZZ().imageWidthAndHeight(bjVar.dEA);
                            bjVar.dEB = imageWidthAndHeight[0];
                            bjVar.dEC = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.n.5
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.bWo().notifyDataSetChanged();
                        if (!n.this.mIsBackground) {
                            n.this.gWx.a(n.this.hpb, n.this.faR, n.this.hpK, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bWy() {
        if (this.hpL == null) {
            return false;
        }
        return this.hpL.bWy();
    }

    public Context getContext() {
        if (this.hpm == null) {
            return null;
        }
        return this.hpm.getTbPageContext().getPageActivity();
    }

    public void K(int i, boolean z) {
        if (this.hpB != null) {
            this.hpB.K(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.hpB != null) {
            this.hpB.startPullRefresh();
        }
    }

    public void bWz() {
        if (this.hpB != null) {
            this.hpB.bWz();
        }
    }

    public void bWA() {
        if (this.hpB != null) {
            this.hpB.bWA();
        }
    }

    public void a(an anVar) {
        if (this.hpB != null) {
            this.hpB.a(anVar);
        }
    }

    public void tY(int i) {
        if (this.hpB != null) {
            this.hpB.tY(i);
        }
    }
}
