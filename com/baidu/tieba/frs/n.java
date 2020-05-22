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
    private NoNetworkView fan;
    private PbListView fbY;
    private ImageView gJR;
    private MessageRedDotView gJS;
    private com.baidu.tieba.play.m gWm;
    private CommonTipView gXg;
    private com.baidu.adp.widget.ListView.m gYf;
    private com.baidu.tieba.frs.vc.d hpA;
    private com.baidu.tieba.frs.entelechy.b.c hpB;
    private com.baidu.tieba.frs.vc.m hpC;
    private GifView hpD;
    private TbImageView hpE;
    private HashSet<String> hpF;
    private ObservedChangeLinearLayout hpH;
    private com.baidu.tieba.frs.entelechy.b.a hpI;
    private com.baidu.tieba.video.f hpJ;
    private AppBarLayoutStickyBehavior hpK;
    private FrsHeaderViewContainer hpL;
    private CollapsingToolbarLayout hpM;
    private com.baidu.tieba.frs.vc.h hpQ;
    private FrsMultiDelBottomMenuView hpR;
    private NavigationBarCoverTip hpS;
    private TextView hpT;
    private TextView hpU;
    private boolean hpZ;
    private FrsFragment hpb;
    private View hpf;
    private com.baidu.tieba.c.b hpg;
    private ImageView hph;
    private ImageView hpi;
    private TextView hpj;
    private ViewStub hpk;
    private BdTypeRecyclerView hpo;
    private com.baidu.tieba.frs.entelechy.a.ai hpp;
    private com.baidu.tieba.frs.vc.k hpq;
    private FloatingAnimationView hpr;
    private com.baidu.tieba.c.c hps;
    private View.OnClickListener hpu;
    private View hpv;
    private View hpw;
    private int hpy;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout hpc = null;
    private CoordinatorLayout hpd = null;
    private View hpe = null;
    private FrameLayout hpl = null;
    private TbImageView hpm = null;
    private TbImageView hpn = null;
    private com.baidu.tbadk.core.dialog.b hpt = null;
    private NoNetworkView.a hkE = null;
    private boolean hpx = true;
    private boolean mHasMore = true;
    private boolean hpz = false;
    private int hoQ = 0;
    private int faG = 0;
    private View bdq = null;
    private View hpG = null;
    private boolean fEh = false;
    private boolean dgY = true;
    private boolean hpN = true;
    private int hpO = -1;
    private int hpP = -1;
    private int hpV = 0;
    private int hpW = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener gYh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (n.this.gYf == null) {
                        n.this.gYf = new com.baidu.adp.widget.ListView.m(new com.baidu.adp.widget.ListView.k());
                    }
                    n.this.gYf.a(n.this.hpo, 2);
                } else if (n.this.gYf != null) {
                    n.this.gYf.pl();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hpX = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.n.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            n.this.a(appBarLayout, i);
            if (n.this.hpq != null) {
                n.this.hpq.setInterceptScrollDown(i == 0);
            }
            if (n.this.hpP != i && Math.abs(i) >= 0 && n.this.bVP() != -1) {
                if (Math.abs(i) >= n.this.bVP()) {
                    if (n.this.hpN) {
                        n.this.hpN = false;
                        n.this.mP(n.this.hpN);
                    }
                } else if (!n.this.hpN) {
                    n.this.hpN = true;
                    n.this.mP(n.this.hpN);
                }
                int bVL = n.this.bVL() + n.this.bVK() + n.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bVL;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && n.this.hpP - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        n.this.tM(Math.abs(bVL - totalScrollRange2));
                        if (n.this.hpG != null) {
                            n.this.hpG.setVisibility(0);
                        }
                    } else if (n.this.hpG != null) {
                        if (n.this.bVJ() != UtilHelper.getStatusBarHeight()) {
                            n.this.tM(0);
                        }
                        n.this.hpG.setVisibility(8);
                    }
                    if (n.this.mNavigationBar != null) {
                        if (n.this.fEh) {
                            n.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            n.this.mU(false);
                        } else if (n.this.hpU != null) {
                            n.this.hpU.setAlpha(abs);
                        }
                    }
                    n.this.hpP = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (n.this.hpq != null) {
                int ccc = n.this.hpq.ccc();
                int ccd = ccc - n.this.hpq.ccd();
                if (ccc > 0 && Math.abs(i) >= ccd) {
                    n.this.hpq.dismissLoading();
                }
            }
        }
    };
    private Runnable hpY = new Runnable() { // from class: com.baidu.tieba.frs.n.13
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.hpk != null) {
                n.this.hpl.setVisibility(0);
                n.this.hpn.setVisibility(0);
                n.this.hpm.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.hpb != null && appBarLayout != null && this.hpb.bUP() != null && this.hpb.getPageContext() != null) {
            int bVK = bVK() + getNavigationBarHeight() + bVL();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bUP = this.hpb.bUP();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.hpb.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.hpb.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.hpe.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.hpb != null && this.hpb.bUW();
            if (totalScrollRange <= 0) {
                if (this.hpW != 2) {
                    bUP.vE(2);
                }
                this.hpW = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bVK) {
                if (this.hpW != 1) {
                    bUP.vE(1);
                }
                this.hpW = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.hpW != 0) {
                    bUP.vE(0);
                }
                this.hpW = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.hpb.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.hpe.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bVH() {
        return this.hpH;
    }

    public View Hh() {
        return this.bdq;
    }

    public View bVI() {
        return this.hpG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVJ() {
        if (this.bdq == null) {
            return 0;
        }
        return this.bdq.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVK() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVL() {
        if (this.fan == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fan.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM(int i) {
        View Hh = Hh();
        View bVI = bVI();
        if (UtilHelper.canUseStyleImmersiveSticky() && Hh != null && bVI != null && Hh.getLayoutParams() != null && bVI.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Hh.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Hh.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bVI.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bVI.setLayoutParams(layoutParams2);
        }
    }

    public n(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.hpb = null;
        this.hpu = null;
        this.hpy = 0;
        this.hpb = frsFragment;
        this.hpu = onClickListener;
        MessageManager.getInstance().registerListener(this.gYh);
        a(aVar, z);
        this.hpF = new HashSet<>();
        this.hpy = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hpQ = hVar;
    }

    private boolean bVM() {
        return this.hpQ != null && this.hpQ.cbO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v22, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.hpI = aVar;
        View rootView = this.hpb.getRootView();
        if (this.hpc == null) {
            this.hpc = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.hpe == null) {
            this.hpe = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.hpd == null) {
            this.hpd = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.hpw == null) {
            this.hpw = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.hpM == null) {
            this.hpM = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.hpL == null) {
            this.hpL = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.hpq == null) {
            this.hpq = new com.baidu.tieba.frs.vc.k(this.hpb);
        }
        if (this.hpH == null) {
            this.hpH = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.hpH.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.n.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        n.this.hpM.setMinimumHeight(i2);
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
        if (this.hpb.bVv()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.hpv == null) {
            this.hpv = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bXT = aVar.bXT();
            if (bXT != null) {
                bXT.bX(this.hpv);
            }
        }
        if (this.hpf == null) {
            this.hpf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hpf.setOnClickListener(this.hpu);
            this.mBackImageView = (ImageView) this.hpf.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hpi == null) {
            this.hpi = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.aUV().a(this.hpi, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hpi.setOnClickListener(this.hpu);
        }
        if (this.hpg == null) {
            this.hpg = new com.baidu.tieba.c.b(this.hpb.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hpg.getView(), (View.OnClickListener) null);
            this.gJR = this.hpg.bMp();
            this.gJS = this.hpg.bMq();
            this.hpg.getView().setOnClickListener(this.hpu);
            this.hpg.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.hph == null) {
            this.hph = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.aUV().a(this.hph, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hph.setOnClickListener(this.hpu);
        }
        if (this.hpj == null) {
            this.hpj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.hpj.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.hpb.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hpj.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.e(this.hpj, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hpj, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.hpb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.hpo == null) {
            this.hpo = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.n.8
            int hqc = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.hqc--;
                if (this.hqc == 0) {
                    n.this.hpo.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.hqc++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.hpo.setItemAnimator(defaultItemAnimator);
        this.hpo.setLayoutManager(new LinearLayoutManager(this.hpo.getContext()) { // from class: com.baidu.tieba.frs.n.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gYf = new com.baidu.adp.widget.ListView.m(new com.baidu.adp.widget.ListView.k());
            this.gYf.a(this.hpo, 2);
        }
        this.hpo.setScrollable(this.hpb);
        this.hpo.setFadingEdgeLength(0);
        this.hpo.setOverScrollMode(2);
        this.hpc.setBottomOrderView(this.hpo);
        this.hpo.setOnTouchListener(this.hpb.evw);
        this.hpo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.n.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (n.this.gWm != null) {
                    n.this.gWm.ct(view);
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
        if (this.fbY == null) {
            this.fbY = new PbListView(this.hpb.getPageContext().getPageActivity());
            this.fbY.getView();
        }
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fbY.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hpb.getActivity(), R.dimen.tbds182));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hpo.setOnSrollToBottomListener(this.hpb);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.n.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.hpb.bVo();
                if (n.this.hpb != null && n.this.Wr != null) {
                    n.this.hpb.bVy();
                    n.this.Wr.setExpanded(true);
                    if (n.this.gWm != null) {
                        n.this.gWm.a(n.this.hoQ, n.this.faG, false, true);
                    }
                }
            }
        });
        boolean aUX = com.baidu.tbadk.core.util.ar.aUW().aUX();
        if (this.hpp == null) {
            this.hpp = aVar.a(this.hpb, this.hpo, aUX);
        }
        if (this.hpq != null) {
            this.hpq.K(1, false);
        }
        if (!z) {
            if (this.fan == null) {
                this.fan = new NoNetworkView(this.hpb.getActivity());
                this.fan.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.hpH.addView(this.fan);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fan.setVisibility(8);
            } else {
                this.fan.setVisibility(0);
            }
            this.fan.onChangeSkinType(this.hpb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bVW();
        if (this.hpA == null) {
            this.hpA = aVar.a(this.hpb, this.hpc);
            this.hpA.b(this.hpb.bVz());
        }
        if (this.hpB == null) {
            this.hpB = aVar.b(this.hpb, this.hpc);
            mS(true);
        }
        if (this.bdq == null) {
            this.bdq = rootView.findViewById(R.id.statebar_view);
        }
        if (this.hpG == null) {
            this.hpG = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.gWm == null) {
            this.gWm = new com.baidu.tieba.play.m(this.hpb.getPageContext(), this.hpo);
        }
        this.gWm.BJ(1);
        this.gWm.setUniqueId(this.hpb.getUniqueId());
        this.hpS = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.hpC == null) {
            this.hpC = new com.baidu.tieba.frs.vc.m(this.hpb, this.hpS);
        }
        if (this.Wr == null) {
            this.Wr = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Wr.addOnOffsetChangedListener(this.hpX);
            this.hpN = true;
            this.hpO = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Wr.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.hpK = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.hpR = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.hpR.setPageContext(this.hpb.getPageContext());
        this.hpr = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.hpr.setPageId(this.hpb.getUniqueId());
        this.hps = new com.baidu.tieba.c.c(this.hpb.getTbPageContext(), this.hpr, 2);
        if (this.hpU == null) {
            this.hpU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hpb.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.hpU.setLayoutParams(layoutParams2);
            this.hpU.setPadding(0, 0, this.hpb.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.hpU.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
        }
    }

    public void bB(boolean z) {
        if (z && this.hps != null) {
            this.hps.aJZ();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.p pVar) {
        if (this.hps != null) {
            this.hps.a(pVar);
        }
    }

    private void bVN() {
        ViewGroup.LayoutParams layoutParams;
        this.fEh = bVM();
        if (this.hpL != null && (layoutParams = this.hpL.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.fEh) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bVK(), 0, 0);
            }
            this.hpL.requestLayout();
        }
    }

    public void bVO() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hpH != null) {
            bVN();
            if (this.fEh) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bdq != null) {
                    this.bdq.setAlpha(1.0f);
                }
                if (this.hpG != null) {
                    this.hpG.setAlpha(1.0f);
                }
                if (this.hpU != null) {
                    this.hpU.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(boolean z) {
        if (z && this.hpb != null && this.hpb.bUO() != null) {
            this.hpb.bUO().cbT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bVP() {
        int i;
        if (this.Wr == null) {
            return this.hpO;
        }
        if (this.hpO != -1) {
            return this.hpO;
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
        this.hpO = Math.max(0, this.Wr.getTotalScrollRange() - Math.abs(i2));
        return this.hpO;
    }

    public void ED(String str) {
        if (this.hpC != null) {
            this.hpC.ED(str);
        }
    }

    public com.baidu.tieba.play.m bVQ() {
        return this.gWm;
    }

    public com.baidu.tieba.frs.entelechy.b.c bVR() {
        return this.hpB;
    }

    public void mQ(boolean z) {
        if (this.hpA != null) {
            this.hpA.mQ(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bVS() {
        return this.hpA;
    }

    public void P(boolean z, boolean z2) {
        if (this.dgY && this.hpB != null) {
            this.hpB.P(z, z2);
        }
    }

    public void mR(boolean z) {
        this.dgY = z;
        if (!this.dgY && this.hpB != null) {
            this.hpB.P(false, false);
        }
    }

    public void bVT() {
        if (this.dgY && this.hpB != null) {
            this.hpB.P(false, false);
        }
        tN(8);
        this.hpi.setVisibility(8);
        this.hph.setVisibility(8);
        mQ(false);
        this.hpo.setVisibility(8);
        this.hpL.setVisibility(8);
    }

    public void bVU() {
        if (this.dgY && this.hpB != null) {
            this.hpB.P(true, false);
        }
        tN(0);
        bVV();
        mQ(this.hpb.bVB());
        this.hpo.setVisibility(0);
        this.hpL.setVisibility(0);
    }

    private void tN(int i) {
        if (this.hpg != null) {
            this.hpg.setVisibility(i);
        }
    }

    private void bVV() {
        this.hpi.setVisibility(0);
        this.hph.setVisibility(0);
    }

    public void mS(boolean z) {
        if (this.hpB != null) {
            this.hpB.nt(z);
        }
    }

    private void bVW() {
        if (this.hpD == null) {
            View rootView = this.hpb.getRootView();
            this.hpD = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.hpE = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.hpE.setPageId(this.hpb.getUniqueId());
            this.hpD.setLayerType(1, null);
            this.hpE.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bVX() {
        return this.hpf;
    }

    public void g(NoNetworkView.a aVar) {
        this.hkE = aVar;
        if (this.fan != null) {
            this.fan.a(this.hkE);
        }
    }

    public void mT(boolean z) {
        if (this.hpB != null) {
            if (z) {
                P(false, true);
            } else {
                P(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hpo.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.x xVar) {
        this.hpp.a(xVar);
    }

    public void setForumName(String str) {
        this.hpp.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gYh);
        if (this.gWm != null) {
            this.gWm.destroy();
        }
        if (this.hpC != null) {
            this.hpC.onDestory();
        }
        if (this.hpR != null) {
            this.hpR.setPageContext(null);
        }
        this.hpp.onDestory();
        this.hpo.setOnSrollToBottomListener(null);
        this.hpo.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.hpY);
        if (this.gXg != null) {
            this.gXg.onDestroy();
        }
        this.hpF.clear();
        if (this.hpA != null) {
            this.hpA.cby();
        }
        if (this.hpJ != null) {
            this.hpJ.bXE();
        }
        if (this.hps != null) {
            this.hps.onDestroy();
        }
        if (this.hpS != null) {
            this.hpS.onDestroy();
        }
        if (this.hpR != null) {
            this.hpR.onDestroy();
        }
        if (this.hpq != null) {
            this.hpq.onDestroy();
        }
    }

    public boolean bVY() {
        if (this.Wr == null || this.hpK == null || !this.hpK.isSticky()) {
            return this.hpA != null && this.hpA.bVY();
        }
        if (this.hpo != null) {
            this.hpo.setSelection(0);
        }
        this.hpK.expandedAppBarLayout(this.Wr);
        return true;
    }

    public boolean bVt() {
        if (this.hpq == null) {
            return false;
        }
        return this.hpq.bVt();
    }

    public void bvM() {
        this.hpo.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.hpU.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.hpU.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.hpU.setText(str2);
            com.baidu.tbadk.core.k.aNQ().setForumNameForWaterImage(str);
        }
    }

    public void bVZ() {
        if (this.hpp != null) {
            this.hpp.notifyDataSetChanged();
        }
    }

    public void aES() {
        if (this.hpp instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.hpp).aES();
        }
    }

    private void bWa() {
        if (this.hpt == null && this.hpb.getPageContext() != null) {
            String[] strArr = {this.hpb.getPageContext().getPageActivity().getString(R.string.take_photo), this.hpb.getPageContext().getPageActivity().getString(R.string.album)};
            this.hpt = new com.baidu.tbadk.core.dialog.b(this.hpb.getPageContext().getPageActivity());
            this.hpt.vP(this.hpb.getPageContext().getPageActivity().getString(R.string.operation));
            this.hpt.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.n.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        n.this.hpb.bVu();
                    } else if (i == 1 && n.this.hpb.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(n.this.hpb.getPageContext().getPageActivity());
                    }
                }
            });
            this.hpt.d(this.hpb.getPageContext());
        }
    }

    public void bWb() {
        bWa();
        if (this.hpt != null) {
            this.hpt.aSU();
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
                if (this.hpb != null && this.hpb.bUM() != null && this.hpb.bUM().cao() == 0) {
                    pVar.tX(this.hpb.bUM().cav());
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
            this.hpp.b(arrayList2, frsViewData);
            if (this.gWm != null && this.hoQ != 0) {
                this.gWm.a(this.hoQ, this.faG, this.hpz, true);
            }
            if (this.hpb != null) {
                this.hpb.bVD();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.hpo;
    }

    public void bWc() {
        this.hpp.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hpb.getPageContext(), 1);
        aVar.a(this.hpo);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.hpb.getForumName());
        hashMap.put("forum_id", this.hpb.getForumId());
        aVar.setParams(hashMap);
        aVar.at(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.hpA != null) {
            this.hpA.cbz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        tO(TbadkCoreApplication.getInst().getSkinType());
        if (this.hpA != null) {
            this.hpA.cbA();
        }
    }

    public void release() {
        if (this.fan != null && this.hkE != null) {
            this.fan.b(this.hkE);
        }
    }

    public ImageView bWd() {
        return this.hpi;
    }

    public ImageView bWe() {
        return this.hph;
    }

    public TextView bWf() {
        return this.hpj;
    }

    public View bWg() {
        if (this.hpg != null) {
            return this.hpg.getView();
        }
        return null;
    }

    public void J(int i, boolean z) {
        if (this.hpg != null) {
            this.hpg.v(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.hpb, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hpb.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.hpE != null) {
            this.hpE.invalidate();
        }
        if (this.hpp != null) {
            this.hpp.bYr();
            this.hpp.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.hpb.getPageContext(), this.hpc);
        if (this.fan != null) {
            this.fan.onChangeSkinType(this.hpb.getPageContext(), i);
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.fbY.changeSkin(i);
        }
        if (this.hpU != null) {
            this.hpU.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
        }
        tO(i);
        if (this.hpB != null) {
            this.hpB.onChangeSkinType(i);
        }
        if (this.hpA != null) {
            this.hpA.onChangeSkinType(i);
        }
        if (this.hpR != null) {
            this.hpR.onChangeSkinType();
        }
        if (this.hpb != null && this.hpb.bUW()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpe, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpe, R.color.cp_bg_line_d);
        }
    }

    private void tO(int i) {
        if (this.hpb != null) {
            tP(i);
        }
    }

    private void tP(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hpb.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpv, R.color.cp_bg_line_c, i);
            if (this.hpg != null) {
                this.hpg.onChangeSkinType(i);
            }
            if (this.hpi != null) {
                SvgManager.aUV().a(this.hpi, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hph != null) {
                SvgManager.aUV().a(this.hph, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.bdq, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpG, R.color.cp_bg_line_h);
        mU(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fEh) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.hpV != 0) {
                    SvgManager.aUV().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUV().a(this.hpi, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUV().a(this.gJR, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aUV().a(this.hph, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.hpV = 0;
                }
            } else if (z || this.hpV != 1) {
                SvgManager.aUV().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUV().a(this.hpi, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUV().a(this.gJR, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aUV().a(this.hph, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.hpV = 1;
            }
            bWh();
        }
    }

    private void bWh() {
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
            if (this.hpU != null) {
                this.hpU.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.gJR != null) {
                    this.gJR.setAlpha(f);
                }
                if (this.gJS != null) {
                    this.gJS.setAlpha(f);
                }
                if (this.hpi != null) {
                    this.hpi.setAlpha(f);
                }
                if (this.hph != null) {
                    this.hph.setAlpha(f);
                }
            }
            if (this.hpj != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.hpj.setAlpha(f2);
                this.hpj.setClickable(f2 > 0.0f);
            }
            if (this.bdq != null) {
                this.bdq.setAlpha(alpha);
            }
            if (this.hpG != null) {
                this.hpG.setAlpha(alpha);
            }
            if (this.hpv != null) {
                this.hpv.setAlpha(alpha);
            }
        }
    }

    public void bqV() {
        if (this.hpq != null) {
            this.hpq.bqV();
        }
    }

    public void mV(boolean z) {
        if (this.hpq != null) {
            this.hpq.mV(z);
        }
    }

    public void mW(boolean z) {
        this.hpx = z;
        if (this.hpx) {
            this.fbY.setText(this.hpb.getResources().getString(R.string.load_more));
            if (this.hpo.getChildAt(this.hpo.getChildCount() - 1) == this.fbY.getView()) {
                this.fbY.startLoadData();
                this.hpb.bqv();
                return;
            }
            this.fbY.endLoadData();
            return;
        }
        this.fbY.setText(this.hpb.getResources().getString(R.string.load_more_must_after_delete));
        this.fbY.endLoadData();
    }

    public boolean bWi() {
        if (this.hpx) {
            return false;
        }
        this.fbY.setText(this.hpb.getResources().getString(R.string.load_more_must_after_delete));
        this.fbY.endLoadData();
        return true;
    }

    public boolean bWj() {
        return this.hpk != null && this.hpn.getVisibility() == 0;
    }

    public void bWk() {
        if (this.hpk != null) {
            this.hpl.setVisibility(0);
            this.hpn.setVisibility(8);
            this.hpm.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.hpY, 5000L);
        }
    }

    public void a(bu buVar) {
        if (this.hpk == null) {
            View rootView = this.hpb.getRootView();
            this.hpk = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.hpk.setVisibility(0);
            this.hpl = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.hpm = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.hpn = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.hpm.setPageId(this.hpb.getUniqueId());
            this.hpn.setPageId(this.hpb.getUniqueId());
            this.hpm.setDefaultBgResource(R.color.common_color_10022);
            this.hpm.setDefaultResource(0);
            this.hpn.setDefaultBgResource(R.color.common_color_10022);
            this.hpn.setDefaultResource(0);
            this.hpl.setOnClickListener(this.hpu);
        }
        this.hpl.setVisibility(0);
        String aSM = buVar.aSM();
        String aSN = buVar.aSN();
        this.hpm.startLoad(aSM, 10, false);
        this.hpn.startLoad(aSN, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.hpY, 5000L);
    }

    public void bWl() {
        if (this.hpk != null && this.hpl != null) {
            this.hpl.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.ai bWm() {
        return this.hpp;
    }

    public RelativeLayout bIL() {
        return this.hpc;
    }

    public View bWn() {
        return this.hpw;
    }

    public void tQ(int i) {
        if (this.hpe != null) {
            this.hpe.setVisibility(i);
        }
    }

    public void bWo() {
        if (com.baidu.tbadk.n.m.bfI().bfJ()) {
            int lastVisiblePosition = this.hpo.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hpo.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hqm != null) {
                        com.baidu.tbadk.n.h perfLog = rVar.hqm.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.erV = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hqm.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hqm.startLogPerf();
                    }
                    if (rVar.hql != null && (rVar.hql instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hql;
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

    public NavigationBar btY() {
        return this.mNavigationBar;
    }

    public void brK() {
        this.mHasMore = true;
        this.hpo.setNextPage(this.fbY);
        if (this.hpy > 0) {
            this.fbY.showEmptyView(this.hpy);
        }
        this.fbY.setOnClickListener(null);
        this.fbY.startLoadData();
    }

    public void brL() {
        this.mHasMore = false;
        this.hpo.setNextPage(this.fbY);
        if (this.hpy > 0) {
            this.fbY.showEmptyView(this.hpy);
        }
        this.fbY.setOnClickListener(null);
        this.fbY.endLoadData();
        this.fbY.setText(this.hpb.getResources().getString(R.string.list_has_no_more));
    }

    public void bWp() {
        this.mHasMore = true;
        this.hpo.setNextPage(this.fbY);
        this.fbY.setOnClickListener(this.hpu);
        if (this.hpy > 0) {
            this.fbY.showEmptyView(this.hpy);
        }
        this.fbY.endLoadData();
        this.fbY.setText(this.hpb.getResources().getString(R.string.list_click_load_more));
    }

    public View bWq() {
        if (this.fbY == null) {
            return null;
        }
        return this.fbY.getView();
    }

    public void tR(int i) {
        if (this.hpR != null) {
            this.hpR.setVisibility(i);
        }
    }

    public void tS(int i) {
        if (this.hpR != null) {
            this.hpR.setSelectNumber(i);
        }
    }

    public void brM() {
        this.mHasMore = false;
        this.hpo.setNextPage(null);
    }

    public boolean bWr() {
        return this.fbY.getView().getParent() != null && this.mHasMore;
    }

    public void tT(int i) {
        this.hpy = i;
    }

    public void tU(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.gXg == null) {
                    this.gXg = new CommonTipView(this.hpb.getActivity());
                }
                this.gXg.setText(R.string.frs_login_tip);
                this.gXg.b((FrameLayout) bWn(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void mX(boolean z) {
        this.mIsBackground = z;
        if (this.gWm != null) {
            boolean z2 = (this.hpb == null || this.hpb.bUP() == null || this.hpb.bUP().cco() == null) ? true : this.hpb.bUP().cco().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.gWm.qi(false);
                this.gWm.cuo();
                return;
            }
            this.gWm.qi(true);
            this.gWm.a(this.hoQ, this.faG, this.hpz, true);
        }
    }

    public void bP(int i, int i2) {
        if (this.gWm != null) {
            this.gWm.a(i, i2, this.hpz, 1);
        }
    }

    public void bQ(int i, int i2) {
        this.hoQ = i;
        this.faG = i2;
    }

    public void mY(boolean z) {
        this.hpz = z;
    }

    public void tV(int i) {
        if (this.hpo != null && this.hpo.getChildCount() >= 0) {
            if (this.hpo.getFirstVisiblePosition() > 8) {
                this.hpo.scrollToPosition(8);
            }
            this.hpo.smoothScrollToPosition(i);
        }
    }

    public void bWs() {
        a(this.hpI, this.hpb.bVv());
        if (this.hpp != null) {
            this.hpp.bYo();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.hpJ == null) {
                this.hpJ = new com.baidu.tieba.video.f(this.hpb.getActivity(), this.hpc);
            }
            this.hpJ.h(postWriteCallBackData);
        }
    }

    public void bWt() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.hpZ && this.hpb.getActivity() != null && this.hpb.getPageContext() != null) {
            View view = null;
            if (this.hpo != null && (headerViewsCount = this.hpo.getHeaderViewsCount()) < this.hpo.getChildCount()) {
                view = this.hpo.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).Z(0).ae(true).af(false).ad(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.n.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        n.this.hpb.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(n.this.hpb.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(n.this.hpb.getActivity(), R.dimen.ds6);
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
                ko.show(this.hpb.getActivity());
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.n.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ko != null) {
                            ko.dismiss();
                        }
                    }
                }, 4000L);
                this.hpZ = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.hpR != null) {
            this.hpR.setDeleteCallback(aVar);
        }
    }

    public void bWu() {
        if (this.hpR != null) {
            this.hpR.bWu();
        }
    }

    public void bkO() {
        if (this.hpR != null) {
            this.hpR.bkO();
        }
    }

    public void aK(String str, int i) {
        if (this.hpT == null) {
            this.hpT = new TextView(this.hpb.getActivity());
            this.hpT.setGravity(19);
            this.hpT.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hpb.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.hpb.getActivity(), R.dimen.ds34), 0);
            this.hpT.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hpb.getActivity(), R.dimen.tbds112)));
            this.hpT.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hpb.getActivity(), R.dimen.fontsize30));
            this.hpT.setMaxLines(2);
            this.hpT.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.hpT.setTextColor(ContextCompat.getColor(this.hpb.getActivity(), R.color.cp_cont_a));
        }
        this.hpS.setBackgroundColor(i);
        this.hpT.setText(str);
        this.hpS.a(this.hpb.getActivity(), this.hpT, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Wr != null) {
            this.Wr.setExpanded(z);
        }
    }

    public void bWv() {
        if (this.hpq != null) {
            this.hpq.startPullRefresh();
        }
    }

    public void ya() {
        if (bWm() != null) {
            List<com.baidu.adp.widget.ListView.o> datas = bWm().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.o oVar : datas) {
                    if (oVar instanceof bj) {
                        bj bjVar = (bj) oVar;
                        if (bjVar.dEB != 0 && bjVar.dEA != null && this.hpb.bUM() != null && this.hpb.bUM().bZR() != null) {
                            int[] imageWidthAndHeight = this.hpb.bUM().bZR().imageWidthAndHeight(bjVar.dEA);
                            bjVar.dEB = imageWidthAndHeight[0];
                            bjVar.dEC = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.n.5
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.bWm().notifyDataSetChanged();
                        if (!n.this.mIsBackground) {
                            n.this.gWm.a(n.this.hoQ, n.this.faG, n.this.hpz, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bWw() {
        if (this.hpA == null) {
            return false;
        }
        return this.hpA.bWw();
    }

    public Context getContext() {
        if (this.hpb == null) {
            return null;
        }
        return this.hpb.getTbPageContext().getPageActivity();
    }

    public void K(int i, boolean z) {
        if (this.hpq != null) {
            this.hpq.K(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.hpq != null) {
            this.hpq.startPullRefresh();
        }
    }

    public void bWx() {
        if (this.hpq != null) {
            this.hpq.bWx();
        }
    }

    public void bWy() {
        if (this.hpq != null) {
            this.hpq.bWy();
        }
    }

    public void a(an anVar) {
        if (this.hpq != null) {
            this.hpq.a(anVar);
        }
    }

    public void tW(int i) {
        if (this.hpq != null) {
            this.hpq.tW(i);
        }
    }
}
