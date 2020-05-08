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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bt;
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
    private AppBarLayout Wc;
    private PbListView ePr;
    private NoNetworkView gAM;
    private com.baidu.tieba.play.m gHB;
    private CommonTipView gIv;
    private com.baidu.adp.widget.ListView.k gJt;
    private ImageView gvg;
    private MessageRedDotView gvh;
    private BdTypeRecyclerView haA;
    private com.baidu.tieba.frs.entelechy.a.ai haB;
    private com.baidu.tieba.frs.vc.k haC;
    private FloatingAnimationView haD;
    private com.baidu.tieba.c.c haE;
    private View.OnClickListener haG;
    private View haH;
    private View haI;
    private int haK;
    private com.baidu.tieba.frs.vc.d haM;
    private com.baidu.tieba.frs.entelechy.b.c haN;
    private com.baidu.tieba.frs.vc.m haO;
    private GifView haP;
    private TbImageView haQ;
    private HashSet<String> haR;
    private ObservedChangeLinearLayout haT;
    private com.baidu.tieba.frs.entelechy.b.a haU;
    private com.baidu.tieba.video.f haV;
    private AppBarLayoutStickyBehavior haW;
    private FrsHeaderViewContainer haX;
    private CollapsingToolbarLayout haY;
    private FrsFragment han;
    private View har;
    private com.baidu.tieba.c.b has;
    private ImageView hat;
    private ImageView hau;
    private TextView hav;
    private ViewStub haw;
    private com.baidu.tieba.frs.vc.h hbc;
    private FrsMultiDelBottomMenuView hbd;
    private NavigationBarCoverTip hbe;
    private TextView hbf;
    private TextView hbg;
    private boolean hbl;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout hao = null;
    private CoordinatorLayout hap = null;
    private View haq = null;
    private FrameLayout hax = null;
    private TbImageView hay = null;
    private TbImageView haz = null;
    private com.baidu.tbadk.core.dialog.b haF = null;
    private NoNetworkView.a gVS = null;
    private boolean haJ = true;
    private boolean mHasMore = true;
    private boolean haL = false;
    private int hac = 0;
    private int eNZ = 0;
    private View aWc = null;
    private View haS = null;
    private boolean fqn = false;
    private boolean cVX = true;
    private boolean haZ = true;
    private int hba = -1;
    private int hbb = -1;
    private int hbh = 0;
    private int hbi = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener gJv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (n.this.gJt == null) {
                        n.this.gJt = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    n.this.gJt.a(n.this.haA, 2);
                } else if (n.this.gJt != null) {
                    n.this.gJt.pf();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hbj = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.n.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            n.this.a(appBarLayout, i);
            if (n.this.haC != null) {
                n.this.haC.setInterceptScrollDown(i == 0);
            }
            if (n.this.hbb != i && Math.abs(i) >= 0 && n.this.bPs() != -1) {
                if (Math.abs(i) >= n.this.bPs()) {
                    if (n.this.haZ) {
                        n.this.haZ = false;
                        n.this.mu(n.this.haZ);
                    }
                } else if (!n.this.haZ) {
                    n.this.haZ = true;
                    n.this.mu(n.this.haZ);
                }
                int bPo = n.this.bPo() + n.this.bPn() + n.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bPo;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && n.this.hbb - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        n.this.th(Math.abs(bPo - totalScrollRange2));
                        if (n.this.haS != null) {
                            n.this.haS.setVisibility(0);
                        }
                    } else if (n.this.haS != null) {
                        if (n.this.bPm() != UtilHelper.getStatusBarHeight()) {
                            n.this.th(0);
                        }
                        n.this.haS.setVisibility(8);
                    }
                    if (n.this.mNavigationBar != null) {
                        if (n.this.fqn) {
                            n.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            n.this.mz(false);
                        } else if (n.this.hbg != null) {
                            n.this.hbg.setAlpha(abs);
                        }
                    }
                    n.this.hbb = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (n.this.haC != null) {
                int bVD = n.this.haC.bVD();
                int bVE = bVD - n.this.haC.bVE();
                if (bVD > 0 && Math.abs(i) >= bVE) {
                    n.this.haC.aqg();
                }
            }
        }
    };
    private Runnable hbk = new Runnable() { // from class: com.baidu.tieba.frs.n.13
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.haw != null) {
                n.this.hax.setVisibility(0);
                n.this.haz.setVisibility(0);
                n.this.hay.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.han != null && appBarLayout != null && this.han.bOt() != null && this.han.getPageContext() != null) {
            int bPn = bPn() + getNavigationBarHeight() + bPo();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bOt = this.han.bOt();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.han.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.han.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.haq.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.han != null && this.han.bOA();
            if (totalScrollRange <= 0) {
                if (this.hbi != 2) {
                    bOt.uY(2);
                }
                this.hbi = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bPn) {
                if (this.hbi != 1) {
                    bOt.uY(1);
                }
                this.hbi = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.hbi != 0) {
                    bOt.uY(0);
                }
                this.hbi = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.han.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.haq.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bPk() {
        return this.haT;
    }

    public View Fq() {
        return this.aWc;
    }

    public View bPl() {
        return this.haS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPm() {
        if (this.aWc == null) {
            return 0;
        }
        return this.aWc.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPn() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPo() {
        if (this.gAM == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gAM.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        View Fq = Fq();
        View bPl = bPl();
        if (UtilHelper.canUseStyleImmersiveSticky() && Fq != null && bPl != null && Fq.getLayoutParams() != null && bPl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Fq.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Fq.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bPl.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bPl.setLayoutParams(layoutParams2);
        }
    }

    public n(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.han = null;
        this.haG = null;
        this.haK = 0;
        this.han = frsFragment;
        this.haG = onClickListener;
        MessageManager.getInstance().registerListener(this.gJv);
        a(aVar, z);
        this.haR = new HashSet<>();
        this.haK = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hbc = hVar;
    }

    private boolean bPp() {
        return this.hbc != null && this.hbc.bVq();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v22, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.haU = aVar;
        View rootView = this.han.getRootView();
        if (this.hao == null) {
            this.hao = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.haq == null) {
            this.haq = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.hap == null) {
            this.hap = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.haI == null) {
            this.haI = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.haY == null) {
            this.haY = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.haX == null) {
            this.haX = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.haC == null) {
            this.haC = new com.baidu.tieba.frs.vc.k(this.han);
        }
        if (this.haT == null) {
            this.haT = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.haT.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.n.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        n.this.haY.setMinimumHeight(i2);
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
        if (this.han.bOZ()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.haH == null) {
            this.haH = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bRw = aVar.bRw();
            if (bRw != null) {
                bRw.bX(this.haH);
            }
        }
        if (this.har == null) {
            this.har = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.har.setOnClickListener(this.haG);
            this.mBackImageView = (ImageView) this.har.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hau == null) {
            this.hau = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.aOR().a(this.hau, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hau.setOnClickListener(this.haG);
        }
        if (this.has == null) {
            this.has = new com.baidu.tieba.c.b(this.han.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.has.getView(), (View.OnClickListener) null);
            this.gvg = this.has.bFV();
            this.gvh = this.has.bFW();
            this.has.getView().setOnClickListener(this.haG);
            this.has.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.hat == null) {
            this.hat = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.aOR().a(this.hat, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hat.setOnClickListener(this.haG);
        }
        if (this.hav == null) {
            this.hav = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.hav.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.han.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hav.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.c(this.hav, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hav, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.han.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.haA == null) {
            this.haA = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.n.8
            int hbo = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.hbo--;
                if (this.hbo == 0) {
                    n.this.haA.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.hbo++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.haA.setItemAnimator(defaultItemAnimator);
        this.haA.setLayoutManager(new LinearLayoutManager(this.haA.getContext()) { // from class: com.baidu.tieba.frs.n.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gJt = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.gJt.a(this.haA, 2);
        }
        this.haA.setScrollable(this.han);
        this.haA.setFadingEdgeLength(0);
        this.haA.setOverScrollMode(2);
        this.hao.setBottomOrderView(this.haA);
        this.haA.setOnTouchListener(this.han.dSb);
        this.haA.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.n.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (n.this.gHB != null) {
                    n.this.gHB.ct(view);
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
        if (this.ePr == null) {
            this.ePr = new PbListView(this.han.getPageContext().getPageActivity());
            this.ePr.getView();
        }
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.ePr.setHeight(com.baidu.adp.lib.util.l.getDimens(this.han.getActivity(), R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.haA.setOnSrollToBottomListener(this.han);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.n.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.han.bOS();
                if (n.this.han != null && n.this.Wc != null) {
                    n.this.han.bPc();
                    n.this.Wc.setExpanded(true);
                    if (n.this.gHB != null) {
                        n.this.gHB.a(n.this.hac, n.this.eNZ, false, true);
                    }
                }
            }
        });
        boolean aOT = com.baidu.tbadk.core.util.ar.aOS().aOT();
        if (this.haB == null) {
            this.haB = aVar.a(this.han, this.haA, aOT);
        }
        if (this.haC != null) {
            this.haC.H(1, false);
        }
        if (!z) {
            if (this.gAM == null) {
                this.gAM = new NoNetworkView(this.han.getActivity());
                this.gAM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.haT.addView(this.gAM);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gAM.setVisibility(8);
            } else {
                this.gAM.setVisibility(0);
            }
            this.gAM.onChangeSkinType(this.han.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bPz();
        if (this.haM == null) {
            this.haM = aVar.a(this.han, this.hao);
            this.haM.b(this.han.bPd());
        }
        if (this.haN == null) {
            this.haN = aVar.b(this.han, this.hao);
            mx(true);
        }
        if (this.aWc == null) {
            this.aWc = rootView.findViewById(R.id.statebar_view);
        }
        if (this.haS == null) {
            this.haS = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.gHB == null) {
            this.gHB = new com.baidu.tieba.play.m(this.han.getPageContext(), this.haA);
        }
        this.gHB.AZ(1);
        this.gHB.setUniqueId(this.han.getUniqueId());
        this.hbe = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.haO == null) {
            this.haO = new com.baidu.tieba.frs.vc.m(this.han, this.hbe);
        }
        if (this.Wc == null) {
            this.Wc = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Wc.addOnOffsetChangedListener(this.hbj);
            this.haZ = true;
            this.hba = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Wc.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.haW = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.hbd = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.hbd.setPageContext(this.han.getPageContext());
        this.haD = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.haD.setPageId(this.han.getUniqueId());
        this.haE = new com.baidu.tieba.c.c(this.han.getTbPageContext(), this.haD, 2);
        if (this.hbg == null) {
            this.hbg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.han.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.hbg.setLayoutParams(layoutParams2);
            this.hbg.setPadding(0, 0, this.han.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.hbg.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
        }
    }

    public void jb(boolean z) {
        if (z && this.haE != null) {
            this.haE.biI();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.haE != null) {
            this.haE.a(oVar);
        }
    }

    private void bPq() {
        ViewGroup.LayoutParams layoutParams;
        this.fqn = bPp();
        if (this.haX != null && (layoutParams = this.haX.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.fqn) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bPn(), 0, 0);
            }
            this.haX.requestLayout();
        }
    }

    public void bPr() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.haT != null) {
            bPq();
            if (this.fqn) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.aWc != null) {
                    this.aWc.setAlpha(1.0f);
                }
                if (this.haS != null) {
                    this.haS.setAlpha(1.0f);
                }
                if (this.hbg != null) {
                    this.hbg.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mu(boolean z) {
        if (z && this.han != null && this.han.bOs() != null) {
            this.han.bOs().bVu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPs() {
        int i;
        if (this.Wc == null) {
            return this.hba;
        }
        if (this.hba != -1) {
            return this.hba;
        }
        int childCount = this.Wc.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Wc.getChildAt(childCount);
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
        this.hba = Math.max(0, this.Wc.getTotalScrollRange() - Math.abs(i2));
        return this.hba;
    }

    public void CU(String str) {
        if (this.haO != null) {
            this.haO.CU(str);
        }
    }

    public com.baidu.tieba.play.m bPt() {
        return this.gHB;
    }

    public com.baidu.tieba.frs.entelechy.b.c bPu() {
        return this.haN;
    }

    public void mv(boolean z) {
        if (this.haM != null) {
            this.haM.mv(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bPv() {
        return this.haM;
    }

    public void M(boolean z, boolean z2) {
        if (this.cVX && this.haN != null) {
            this.haN.M(z, z2);
        }
    }

    public void mw(boolean z) {
        this.cVX = z;
        if (!this.cVX && this.haN != null) {
            this.haN.M(false, false);
        }
    }

    public void bPw() {
        if (this.cVX && this.haN != null) {
            this.haN.M(false, false);
        }
        ti(8);
        this.hau.setVisibility(8);
        this.hat.setVisibility(8);
        mv(false);
        this.haA.setVisibility(8);
        this.haX.setVisibility(8);
    }

    public void bPx() {
        if (this.cVX && this.haN != null) {
            this.haN.M(true, false);
        }
        ti(0);
        bPy();
        mv(this.han.bPf());
        this.haA.setVisibility(0);
        this.haX.setVisibility(0);
    }

    private void ti(int i) {
        if (this.has != null) {
            this.has.setVisibility(i);
        }
    }

    private void bPy() {
        this.hau.setVisibility(0);
        this.hat.setVisibility(0);
    }

    public void mx(boolean z) {
        if (this.haN != null) {
            this.haN.mY(z);
        }
    }

    private void bPz() {
        if (this.haP == null) {
            View rootView = this.han.getRootView();
            this.haP = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.haQ = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.haQ.setPageId(this.han.getUniqueId());
            this.haP.setLayerType(1, null);
            this.haQ.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bPA() {
        return this.har;
    }

    public void g(NoNetworkView.a aVar) {
        this.gVS = aVar;
        if (this.gAM != null) {
            this.gAM.a(this.gVS);
        }
    }

    public void my(boolean z) {
        if (this.haN != null) {
            if (z) {
                M(false, true);
            } else {
                M(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.haA.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.haB.a(vVar);
    }

    public void setForumName(String str) {
        this.haB.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gJv);
        if (this.gHB != null) {
            this.gHB.destroy();
        }
        if (this.haO != null) {
            this.haO.onDestory();
        }
        if (this.hbd != null) {
            this.hbd.setPageContext(null);
        }
        this.haB.onDestory();
        this.haA.setOnSrollToBottomListener(null);
        this.haA.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.hbk);
        if (this.gIv != null) {
            this.gIv.onDestroy();
        }
        this.haR.clear();
        if (this.haM != null) {
            this.haM.bVa();
        }
        if (this.haV != null) {
            this.haV.bRh();
        }
        if (this.haE != null) {
            this.haE.onDestroy();
        }
        if (this.hbe != null) {
            this.hbe.onDestroy();
        }
        if (this.hbd != null) {
            this.hbd.onDestroy();
        }
        if (this.haC != null) {
            this.haC.onDestroy();
        }
    }

    public boolean bPB() {
        if (this.Wc == null || this.haW == null || !this.haW.isSticky()) {
            return this.haM != null && this.haM.bPB();
        }
        if (this.haA != null) {
            this.haA.setSelection(0);
        }
        this.haW.expandedAppBarLayout(this.Wc);
        return true;
    }

    public boolean bOX() {
        if (this.haC == null) {
            return false;
        }
        return this.haC.bOX();
    }

    public void bpT() {
        this.haA.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.hbg.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.hbg.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.hbg.setText(str2);
            com.baidu.tbadk.core.i.aIc().setForumNameForWaterImage(str);
        }
    }

    public void bPC() {
        if (this.haB != null) {
            this.haB.notifyDataSetChanged();
        }
    }

    public void aBa() {
        if (this.haB instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.haB).aBa();
        }
    }

    private void bPD() {
        if (this.haF == null && this.han.getPageContext() != null) {
            String[] strArr = {this.han.getPageContext().getPageActivity().getString(R.string.take_photo), this.han.getPageContext().getPageActivity().getString(R.string.album)};
            this.haF = new com.baidu.tbadk.core.dialog.b(this.han.getPageContext().getPageActivity());
            this.haF.uj(this.han.getPageContext().getPageActivity().getString(R.string.operation));
            this.haF.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.n.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        n.this.han.bOY();
                    } else if (i == 1 && n.this.han.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(n.this.han.getPageContext().getPageActivity());
                    }
                }
            });
            this.haF.d(this.han.getPageContext());
        }
    }

    public void bPE() {
        bPD();
        if (this.haF != null) {
            this.haF.aMT();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.v.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                p pVar = new p();
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
                arrayList3.add(pVar);
                if (this.han != null && this.han.bOq() != null && this.han.bOq().bTR() == 0) {
                    pVar.ts(this.han.bOq().bTY());
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
                    com.baidu.adp.widget.ListView.m mVar = arrayList2.get(i2);
                    if (mVar instanceof bi) {
                        ((bi) mVar).dqE.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.haB.b(arrayList2, frsViewData);
            if (this.gHB != null && this.hac != 0) {
                this.gHB.a(this.hac, this.eNZ, this.haL, true);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.haA;
    }

    public void bPF() {
        this.haB.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.han.getPageContext(), 1);
        aVar.a(this.haA);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.han.getForumName());
        hashMap.put("forum_id", this.han.getForumId());
        aVar.setParams(hashMap);
        aVar.ap(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.haM != null) {
            this.haM.bVb();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        tj(TbadkCoreApplication.getInst().getSkinType());
        if (this.haM != null) {
            this.haM.bVc();
        }
    }

    public void release() {
        if (this.gAM != null && this.gVS != null) {
            this.gAM.b(this.gVS);
        }
    }

    public ImageView bPG() {
        return this.hau;
    }

    public ImageView bPH() {
        return this.hat;
    }

    public TextView bPI() {
        return this.hav;
    }

    public View bPJ() {
        if (this.has != null) {
            return this.has.getView();
        }
        return null;
    }

    public void G(int i, boolean z) {
        if (this.has != null) {
            this.has.s(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.han, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.han.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.haQ != null) {
            this.haQ.invalidate();
        }
        if (this.haB != null) {
            this.haB.bRU();
            this.haB.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.han.getPageContext(), this.hao);
        if (this.gAM != null) {
            this.gAM.onChangeSkinType(this.han.getPageContext(), i);
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.ePr.changeSkin(i);
        }
        if (this.hbg != null) {
            this.hbg.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
        }
        tj(i);
        if (this.haN != null) {
            this.haN.onChangeSkinType(i);
        }
        if (this.haM != null) {
            this.haM.onChangeSkinType(i);
        }
        if (this.hbd != null) {
            this.hbd.onChangeSkinType();
        }
        if (this.han != null && this.han.bOA()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.haq, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.haq, R.color.cp_bg_line_d);
        }
    }

    private void tj(int i) {
        if (this.han != null) {
            tk(i);
        }
    }

    private void tk(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.han.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.haH, R.color.cp_bg_line_c, i);
            if (this.has != null) {
                this.has.onChangeSkinType(i);
            }
            if (this.hau != null) {
                SvgManager.aOR().a(this.hau, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hat != null) {
                SvgManager.aOR().a(this.hat, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.aWc, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.haS, R.color.cp_bg_line_h);
        mz(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fqn) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.hbh != 0) {
                    SvgManager.aOR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aOR().a(this.hau, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aOR().a(this.gvg, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aOR().a(this.hat, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.hbh = 0;
                }
            } else if (z || this.hbh != 1) {
                SvgManager.aOR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOR().a(this.hau, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOR().a(this.gvg, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOR().a(this.hat, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.hbh = 1;
            }
            bPK();
        }
    }

    private void bPK() {
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
            if (this.hbg != null) {
                this.hbg.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.gvg != null) {
                    this.gvg.setAlpha(f);
                }
                if (this.gvh != null) {
                    this.gvh.setAlpha(f);
                }
                if (this.hau != null) {
                    this.hau.setAlpha(f);
                }
                if (this.hat != null) {
                    this.hat.setAlpha(f);
                }
            }
            if (this.hav != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.hav.setAlpha(f2);
                this.hav.setClickable(f2 > 0.0f);
            }
            if (this.aWc != null) {
                this.aWc.setAlpha(alpha);
            }
            if (this.haS != null) {
                this.haS.setAlpha(alpha);
            }
            if (this.haH != null) {
                this.haH.setAlpha(alpha);
            }
        }
    }

    public void blx() {
        if (this.haC != null) {
            this.haC.blx();
        }
    }

    public void mA(boolean z) {
        if (this.haC != null) {
            this.haC.mA(z);
        }
    }

    public void mB(boolean z) {
        this.haJ = z;
        if (this.haJ) {
            this.ePr.setText(this.han.getResources().getString(R.string.load_more));
            if (this.haA.getChildAt(this.haA.getChildCount() - 1) == this.ePr.getView()) {
                this.ePr.startLoadData();
                this.han.bkZ();
                return;
            }
            this.ePr.endLoadData();
            return;
        }
        this.ePr.setText(this.han.getResources().getString(R.string.load_more_must_after_delete));
        this.ePr.endLoadData();
    }

    public boolean bPL() {
        if (this.haJ) {
            return false;
        }
        this.ePr.setText(this.han.getResources().getString(R.string.load_more_must_after_delete));
        this.ePr.endLoadData();
        return true;
    }

    public boolean bPM() {
        return this.haw != null && this.haz.getVisibility() == 0;
    }

    public void bPN() {
        if (this.haw != null) {
            this.hax.setVisibility(0);
            this.haz.setVisibility(8);
            this.hay.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.hbk, 5000L);
        }
    }

    public void a(bt btVar) {
        if (this.haw == null) {
            View rootView = this.han.getRootView();
            this.haw = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.haw.setVisibility(0);
            this.hax = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.hay = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.haz = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.hay.setPageId(this.han.getUniqueId());
            this.haz.setPageId(this.han.getUniqueId());
            this.hay.setDefaultBgResource(R.color.common_color_10022);
            this.hay.setDefaultResource(0);
            this.haz.setDefaultBgResource(R.color.common_color_10022);
            this.haz.setDefaultResource(0);
            this.hax.setOnClickListener(this.haG);
        }
        this.hax.setVisibility(0);
        String aML = btVar.aML();
        String aMM = btVar.aMM();
        this.hay.startLoad(aML, 10, false);
        this.haz.startLoad(aMM, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.hbk, 5000L);
    }

    public void bPO() {
        if (this.haw != null && this.hax != null) {
            this.hax.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.ai bPP() {
        return this.haB;
    }

    public RelativeLayout bCr() {
        return this.hao;
    }

    public View bPQ() {
        return this.haI;
    }

    public void tl(int i) {
        if (this.haq != null) {
            this.haq.setVisibility(i);
        }
    }

    public void bPR() {
        if (com.baidu.tbadk.n.m.aZy().aZz()) {
            int lastVisiblePosition = this.haA.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.haA.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hby != null) {
                        com.baidu.tbadk.n.h perfLog = rVar.hby.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.edI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hby.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hby.startLogPerf();
                    }
                    if (rVar.hbx != null && (rVar.hbx instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hbx;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.edI = true;
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

    public NavigationBar bof() {
        return this.mNavigationBar;
    }

    public void bmm() {
        this.mHasMore = true;
        this.haA.setNextPage(this.ePr);
        if (this.haK > 0) {
            this.ePr.showEmptyView(this.haK);
        }
        this.ePr.setOnClickListener(null);
        this.ePr.startLoadData();
    }

    public void bmn() {
        this.mHasMore = false;
        this.haA.setNextPage(this.ePr);
        if (this.haK > 0) {
            this.ePr.showEmptyView(this.haK);
        }
        this.ePr.setOnClickListener(null);
        this.ePr.endLoadData();
        this.ePr.setText(this.han.getResources().getString(R.string.list_has_no_more));
    }

    public void bPS() {
        this.mHasMore = true;
        this.haA.setNextPage(this.ePr);
        this.ePr.setOnClickListener(this.haG);
        if (this.haK > 0) {
            this.ePr.showEmptyView(this.haK);
        }
        this.ePr.endLoadData();
        this.ePr.setText(this.han.getResources().getString(R.string.list_click_load_more));
    }

    public View bPT() {
        if (this.ePr == null) {
            return null;
        }
        return this.ePr.getView();
    }

    public void tm(int i) {
        if (this.hbd != null) {
            this.hbd.setVisibility(i);
        }
    }

    public void tn(int i) {
        if (this.hbd != null) {
            this.hbd.setSelectNumber(i);
        }
    }

    public void bmo() {
        this.mHasMore = false;
        this.haA.setNextPage(null);
    }

    public boolean bPU() {
        return this.ePr.getView().getParent() != null && this.mHasMore;
    }

    public void to(int i) {
        this.haK = i;
    }

    public void tp(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.gIv == null) {
                    this.gIv = new CommonTipView(this.han.getActivity());
                }
                this.gIv.setText(R.string.frs_login_tip);
                this.gIv.b((FrameLayout) bPQ(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void mC(boolean z) {
        this.mIsBackground = z;
        if (this.gHB != null) {
            boolean z2 = (this.han == null || this.han.bOt() == null || this.han.bOt().bVP() == null) ? true : this.han.bOt().bVP().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.gHB.pL(false);
                this.gHB.cnL();
                return;
            }
            this.gHB.pL(true);
            this.gHB.a(this.hac, this.eNZ, this.haL, true);
        }
    }

    public void bK(int i, int i2) {
        if (this.gHB != null) {
            this.gHB.a(i, i2, this.haL, 1);
        }
    }

    public void bL(int i, int i2) {
        this.hac = i;
        this.eNZ = i2;
    }

    public void mD(boolean z) {
        this.haL = z;
    }

    public void tq(int i) {
        if (this.haA != null && this.haA.getChildCount() >= 0) {
            if (this.haA.getFirstVisiblePosition() > 8) {
                this.haA.scrollToPosition(8);
            }
            this.haA.smoothScrollToPosition(i);
        }
    }

    public void bPV() {
        a(this.haU, this.han.bOZ());
        if (this.haB != null) {
            this.haB.bRR();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.haV == null) {
                this.haV = new com.baidu.tieba.video.f(this.han.getActivity(), this.hao);
            }
            this.haV.h(postWriteCallBackData);
        }
    }

    public void bPW() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.hbl && this.han.getActivity() != null && this.han.getPageContext() != null) {
            View view = null;
            if (this.haA != null && (headerViewsCount = this.haA.getHeaderViewsCount()) < this.haA.getChildCount()) {
                view = this.haA.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).Y(0).ae(true).af(false).ad(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.n.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        n.this.han.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(n.this.han.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(n.this.han.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.n.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c km = dVar.km();
                km.setShouldCheckLocInWindow(false);
                km.show(this.han.getActivity());
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.n.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (km != null) {
                            km.dismiss();
                        }
                    }
                }, 4000L);
                this.hbl = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.hbd != null) {
            this.hbd.setDeleteCallback(aVar);
        }
    }

    public void bPX() {
        if (this.hbd != null) {
            this.hbd.bPX();
        }
    }

    public void beB() {
        if (this.hbd != null) {
            this.hbd.beB();
        }
    }

    public void aJ(String str, int i) {
        if (this.hbf == null) {
            this.hbf = new TextView(this.han.getActivity());
            this.hbf.setGravity(19);
            this.hbf.setPadding(com.baidu.adp.lib.util.l.getDimens(this.han.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.han.getActivity(), R.dimen.ds34), 0);
            this.hbf.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.han.getActivity(), R.dimen.tbds112)));
            this.hbf.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.han.getActivity(), R.dimen.fontsize30));
            this.hbf.setMaxLines(2);
            this.hbf.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.hbf.setTextColor(ContextCompat.getColor(this.han.getActivity(), R.color.cp_cont_a));
        }
        this.hbe.setBackgroundColor(i);
        this.hbf.setText(str);
        this.hbe.a(this.han.getActivity(), this.hbf, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Wc != null) {
            this.Wc.setExpanded(z);
        }
    }

    public void bPY() {
        if (this.haC != null) {
            this.haC.startPullRefresh();
        }
    }

    public void wJ() {
        if (bPP() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bPP().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.dqF != 0 && biVar.dqE != null && this.han.bOq() != null && this.han.bOq().bTu() != null) {
                            int[] imageWidthAndHeight = this.han.bOq().bTu().imageWidthAndHeight(biVar.dqE);
                            biVar.dqF = imageWidthAndHeight[0];
                            biVar.dqG = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.n.5
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.bPP().notifyDataSetChanged();
                        if (!n.this.mIsBackground) {
                            n.this.gHB.a(n.this.hac, n.this.eNZ, n.this.haL, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bPZ() {
        if (this.haM == null) {
            return false;
        }
        return this.haM.bPZ();
    }

    public Context getContext() {
        if (this.han == null) {
            return null;
        }
        return this.han.getTbPageContext().getPageActivity();
    }

    public void H(int i, boolean z) {
        if (this.haC != null) {
            this.haC.H(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.haC != null) {
            this.haC.startPullRefresh();
        }
    }

    public void bQa() {
        if (this.haC != null) {
            this.haC.bQa();
        }
    }

    public void bQb() {
        if (this.haC != null) {
            this.haC.bQb();
        }
    }

    public void a(an anVar) {
        if (this.haC != null) {
            this.haC.a(anVar);
        }
    }

    public void tr(int i) {
        if (this.haC != null) {
            this.haC.tr(i);
        }
    }
}
