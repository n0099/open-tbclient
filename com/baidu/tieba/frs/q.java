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
    private AppBarLayout Yh;
    private NoNetworkView gbO;
    private PbListView gdy;
    private ImageView hXY;
    private MessageRedDotView hXZ;
    private FrsFragment iDN;
    private View iDR;
    private com.baidu.tieba.c.d iDS;
    private ImageView iDT;
    private ImageView iDU;
    private TextView iDV;
    private ViewStub iDW;
    private com.baidu.tieba.frs.vc.h iEA;
    private FrsMultiDelBottomMenuView iEB;
    private FrsMoveAreaBottomMenuView iEC;
    private NavigationBarCoverTip iED;
    private TextView iEE;
    private TextView iEF;
    private boolean iEK;
    private BdTypeRecyclerView iEa;
    private com.baidu.tieba.frs.entelechy.a.al iEb;
    private com.baidu.tieba.frs.vc.k iEc;
    private View.OnClickListener iEe;
    private View iEf;
    private View iEg;
    private int iEi;
    private com.baidu.tieba.frs.vc.d iEk;
    private com.baidu.tieba.frs.entelechy.b.c iEl;
    private com.baidu.tieba.frs.vc.m iEm;
    private GifView iEn;
    private TbImageView iEo;
    private HashSet<String> iEp;
    private ObservedChangeLinearLayout iEr;
    private com.baidu.tieba.frs.entelechy.b.a iEs;
    private com.baidu.tieba.video.f iEt;
    private AppBarLayoutStickyBehavior iEu;
    private FrsHeaderViewContainer iEv;
    private CollapsingToolbarLayout iEw;
    private com.baidu.tieba.play.i iko;
    private CommonTipView ilj;
    private com.baidu.adp.widget.ListView.n imm;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout iDO = null;
    private CoordinatorLayout iDP = null;
    private View iDQ = null;
    private FrameLayout iDX = null;
    private TbImageView iDY = null;
    private TbImageView iDZ = null;
    private com.baidu.tbadk.core.dialog.b iEd = null;
    private NoNetworkView.a iyC = null;
    private boolean iEh = true;
    private boolean mHasMore = true;
    private boolean iEj = false;
    private int iDz = 0;
    private int gch = 0;
    private View bxQ = null;
    private View iEq = null;
    private boolean gKp = false;
    private boolean dYj = true;
    private boolean iEx = true;
    private int iEy = -1;
    private int iEz = -1;
    private int iEG = 0;
    private int iEH = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener imo = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.imm == null) {
                        q.this.imm = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.imm.a(q.this.iEa, 2);
                } else if (q.this.imm != null) {
                    q.this.imm.rh();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iEI = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.iEc != null) {
                q.this.iEc.setInterceptScrollDown(i == 0);
            }
            if (q.this.iEz != i && Math.abs(i) >= 0 && q.this.cwM() != -1) {
                if (Math.abs(i) >= q.this.cwM()) {
                    if (q.this.iEx) {
                        q.this.iEx = false;
                        q.this.po(q.this.iEx);
                    }
                } else if (!q.this.iEx) {
                    q.this.iEx = true;
                    q.this.po(q.this.iEx);
                }
                int cwI = q.this.cwI() + q.this.cwH() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cwI;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.iEz - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.yw(Math.abs(cwI - totalScrollRange2));
                        if (q.this.iEq != null) {
                            q.this.iEq.setVisibility(0);
                        }
                    } else if (q.this.iEq != null) {
                        if (q.this.cwG() != UtilHelper.getStatusBarHeight()) {
                            q.this.yw(0);
                        }
                        q.this.iEq.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.gKp) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.pt(false);
                        } else if (q.this.iEF != null) {
                            q.this.iEF.setAlpha(abs);
                        }
                    }
                    q.this.iEz = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.iEc != null) {
                int cDD = q.this.iEc.cDD();
                int cDE = cDD - q.this.iEc.cDE();
                if (cDD > 0 && Math.abs(i) >= cDE) {
                    q.this.iEc.dismissLoading();
                }
            }
        }
    };
    private Runnable iEJ = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.iDW != null) {
                q.this.iDX.setVisibility(0);
                q.this.iDZ.setVisibility(0);
                q.this.iDY.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.iDN != null && appBarLayout != null && this.iDN.cvI() != null && this.iDN.getPageContext() != null) {
            int cwH = cwH() + getNavigationBarHeight() + cwI();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cvI = this.iDN.cvI();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.iDN.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.iDN.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.iDQ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.iDN != null && this.iDN.cvP();
            if (totalScrollRange <= 0) {
                if (this.iEH != 2) {
                    cvI.Au(2);
                }
                this.iEH = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cwH) {
                if (this.iEH != 1) {
                    cvI.Au(1);
                }
                this.iEH = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.iEH != 0) {
                    cvI.Au(0);
                }
                this.iEH = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.iDN.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.iDQ.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout cwE() {
        return this.iEr;
    }

    public View QW() {
        return this.bxQ;
    }

    public View cwF() {
        return this.iEq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cwG() {
        if (this.bxQ == null) {
            return 0;
        }
        return this.bxQ.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cwH() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cwI() {
        if (this.gbO == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gbO.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        View QW = QW();
        View cwF = cwF();
        if (UtilHelper.canUseStyleImmersiveSticky() && QW != null && cwF != null && QW.getLayoutParams() != null && cwF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = QW.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            QW.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cwF.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cwF.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.iDN = null;
        this.iEe = null;
        this.iEi = 0;
        this.iDN = frsFragment;
        this.iEe = onClickListener;
        MessageManager.getInstance().registerListener(this.imo);
        a(aVar, z);
        this.iEp = new HashSet<>();
        this.iEi = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iEA = hVar;
    }

    private boolean cwJ() {
        return this.iEA != null && this.iEA.cDo();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.iEs = aVar;
        View rootView = this.iDN.getRootView();
        if (this.iDO == null) {
            this.iDO = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.iDQ == null) {
            this.iDQ = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.iDP == null) {
            this.iDP = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.iEg == null) {
            this.iEg = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.iEw == null) {
            this.iEw = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.iEv == null) {
            this.iEv = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.iEc == null) {
            this.iEc = new com.baidu.tieba.frs.vc.k(this.iDN);
        }
        if (this.iEr == null) {
            this.iEr = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.iEr.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.iEw.setMinimumHeight(i2);
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
        if (this.iDN.cwr()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.iEf == null) {
            this.iEf = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b czf = aVar.czf();
            if (czf != null) {
                czf.cx(this.iEf);
            }
        }
        if (this.iDR == null) {
            this.iDR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iDR.setOnClickListener(this.iEe);
            this.mBackImageView = (ImageView) this.iDR.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iDU == null) {
            this.iDU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.boN().a(this.iDU, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iDU.setOnClickListener(this.iEe);
        }
        if (this.iDS == null) {
            this.iDS = new com.baidu.tieba.c.d(this.iDN.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iDS.getView(), (View.OnClickListener) null);
            this.hXY = this.iDS.cmS();
            this.hXZ = this.iDS.cmT();
            this.iDS.getView().setOnClickListener(this.iEe);
            this.iDS.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.iDT == null) {
            this.iDT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.boN().a(this.iDT, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iDT.setOnClickListener(this.iEe);
        }
        if (this.iDV == null) {
            this.iDV = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.iDV.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.iDN.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iDV.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.f(this.iDV, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iDV, R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.iDN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.iEa == null) {
            this.iEa = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int iEN = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.iEN--;
                if (this.iEN == 0) {
                    q.this.iEa.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.iEN++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.iEa.setItemAnimator(defaultItemAnimator);
        this.iEa.setLayoutManager(new LinearLayoutManager(this.iEa.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.imm = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.imm.a(this.iEa, 2);
        }
        this.iEa.setScrollable(this.iDN);
        this.iEa.setFadingEdgeLength(0);
        this.iEa.setOverScrollMode(2);
        this.iDO.setBottomOrderView(this.iEa);
        this.iEa.setOnTouchListener(this.iDN.ftj);
        this.iEa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iko != null) {
                    q.this.iko.cV(view);
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
        if (this.gdy == null) {
            this.gdy = new PbListView(this.iDN.getPageContext().getPageActivity());
            this.gdy.getView();
        }
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.gdy.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iDN.getActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iEa.setOnSrollToBottomListener(this.iDN);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.iDN.cwk();
                if (q.this.iDN != null && q.this.Yh != null) {
                    q.this.iDN.cwu();
                    q.this.Yh.setExpanded(true);
                    if (q.this.iko != null) {
                        q.this.iko.a(q.this.iDz, q.this.gch, false, true);
                    }
                }
            }
        });
        boolean boP = com.baidu.tbadk.core.util.au.boO().boP();
        if (this.iEb == null) {
            this.iEb = aVar.a(this.iDN, this.iEa, boP);
        }
        if (this.iEc != null) {
            this.iEc.Q(1, false);
        }
        if (!z) {
            if (this.gbO == null) {
                this.gbO = new NoNetworkView(this.iDN.getActivity());
                this.gbO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.iEr.addView(this.gbO);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gbO.setVisibility(8);
            } else {
                this.gbO.setVisibility(0);
            }
            this.gbO.onChangeSkinType(this.iDN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cwT();
        if (this.iEk == null) {
            this.iEk = aVar.a(this.iDN, this.iDO);
            this.iEk.b(this.iDN.cwv());
        }
        if (this.iEl == null) {
            this.iEl = aVar.b(this.iDN, this.iDO);
            pr(true);
        }
        if (this.bxQ == null) {
            this.bxQ = rootView.findViewById(R.id.statebar_view);
        }
        if (this.iEq == null) {
            this.iEq = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iko == null) {
            this.iko = new com.baidu.tieba.play.i(this.iDN.getPageContext(), this.iEa);
        }
        this.iko.Hh(1);
        this.iko.setUniqueId(this.iDN.getUniqueId());
        this.iED = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.iEm == null) {
            this.iEm = new com.baidu.tieba.frs.vc.m(this.iDN, this.iED);
        }
        if (this.Yh == null) {
            this.Yh = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Yh.addOnOffsetChangedListener(this.iEI);
            this.iEx = true;
            this.iEy = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Yh.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.iEu = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.iEB = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.iEB.setPageContext(this.iDN.getPageContext());
        this.iEC = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.iEC.setPageContext(this.iDN.getPageContext());
        if (this.iEF == null) {
            this.iEF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.iDN.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.iEF.setLayoutParams(layoutParams2);
            this.iEF.setPadding(0, 0, this.iDN.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.iEF.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
    }

    public void bP(boolean z) {
        if (z) {
        }
    }

    private void cwK() {
        ViewGroup.LayoutParams layoutParams;
        this.gKp = cwJ();
        if (this.iEv != null && (layoutParams = this.iEv.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.gKp) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cwH(), 0, 0);
            }
            this.iEv.requestLayout();
        }
    }

    public void cwL() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.iEr != null) {
            cwK();
            if (this.gKp) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bxQ != null) {
                    this.bxQ.setAlpha(1.0f);
                }
                if (this.iEq != null) {
                    this.iEq.setAlpha(1.0f);
                }
                if (this.iEF != null) {
                    this.iEF.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void po(boolean z) {
        if (z && this.iDN != null && this.iDN.cvH() != null) {
            this.iDN.cvH().cDt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cwM() {
        int i;
        if (this.Yh == null) {
            return this.iEy;
        }
        if (this.iEy != -1) {
            return this.iEy;
        }
        int childCount = this.Yh.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Yh.getChildAt(childCount);
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
        this.iEy = Math.max(0, this.Yh.getTotalScrollRange() - Math.abs(i2));
        return this.iEy;
    }

    public void Ka(String str) {
        if (this.iEm != null) {
            this.iEm.Ka(str);
        }
    }

    public com.baidu.tieba.play.i cwN() {
        return this.iko;
    }

    public com.baidu.tieba.frs.entelechy.b.c cwO() {
        return this.iEl;
    }

    public void pp(boolean z) {
        if (this.iEk != null) {
            if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                this.iEk.pp(false);
            } else {
                this.iEk.pp(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cwP() {
        return this.iEk;
    }

    public void Y(boolean z, boolean z2) {
        if (this.dYj && this.iEl != null) {
            this.iEl.Y(z, z2);
        }
    }

    public void pq(boolean z) {
        this.dYj = z;
        if (!this.dYj && this.iEl != null) {
            this.iEl.Y(false, false);
        }
    }

    public void cwQ() {
        if (this.dYj && this.iEl != null) {
            this.iEl.Y(false, false);
        }
        yx(8);
        this.iDU.setVisibility(8);
        this.iDT.setVisibility(8);
        pp(false);
        this.iEa.setVisibility(8);
        this.iEv.setVisibility(8);
    }

    public void cwR() {
        if (this.dYj && this.iEl != null) {
            this.iEl.Y(true, false);
        }
        yx(0);
        cwS();
        pp(this.iDN.cwx());
        this.iEa.setVisibility(0);
        this.iEv.setVisibility(0);
    }

    private void yx(int i) {
        if (this.iDS != null) {
            this.iDS.setVisibility(i);
        }
    }

    private void cwS() {
        this.iDU.setVisibility(0);
        this.iDT.setVisibility(0);
    }

    public void pr(boolean z) {
        if (this.iEl != null) {
            this.iEl.pT(z);
        }
    }

    private void cwT() {
        if (this.iEn == null) {
            View rootView = this.iDN.getRootView();
            this.iEn = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.iEo = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.iEo.setPageId(this.iDN.getUniqueId());
            this.iEn.setLayerType(1, null);
            this.iEo.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cwU() {
        return this.iDR;
    }

    public void g(NoNetworkView.a aVar) {
        this.iyC = aVar;
        if (this.gbO != null) {
            this.gbO.a(this.iyC);
        }
    }

    public void ps(boolean z) {
        if (this.iEl != null) {
            if (z) {
                Y(false, true);
            } else {
                Y(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iEa.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.iEb.a(abVar);
    }

    public void setForumName(String str) {
        this.iEb.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.imo);
        if (this.iko != null) {
            this.iko.destroy();
        }
        if (this.iEm != null) {
            this.iEm.onDestory();
        }
        if (this.iEB != null) {
            this.iEB.setPageContext(null);
        }
        if (this.iEC != null) {
            this.iEC.setPageContext(null);
        }
        this.iEb.onDestory();
        this.iEa.setOnSrollToBottomListener(null);
        this.iEa.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.iEJ);
        if (this.ilj != null) {
            this.ilj.onDestroy();
        }
        this.iEp.clear();
        if (this.iEk != null) {
            this.iEk.cCY();
        }
        if (this.iEt != null) {
            this.iEt.cyM();
        }
        if (this.iED != null) {
            this.iED.onDestroy();
        }
        if (this.iEB != null) {
            this.iEB.onDestroy();
        }
        if (this.iEc != null) {
            this.iEc.onDestroy();
        }
    }

    public boolean cwV() {
        if (this.Yh == null || this.iEu == null || !this.iEu.isSticky()) {
            return this.iEk != null && this.iEk.cwV();
        }
        if (this.iEa != null) {
            this.iEa.setSelection(0);
        }
        this.iEu.expandedAppBarLayout(this.Yh);
        return true;
    }

    public boolean cwp() {
        if (this.iEc == null) {
            return false;
        }
        return this.iEc.cwp();
    }

    public void bSR() {
        this.iEa.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.iEF.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.iEF.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.iEF.setText(str2);
            com.baidu.tbadk.core.k.bhh().setForumNameForWaterImage(str);
        }
    }

    public void cwW() {
        if (this.iEb != null) {
            this.iEb.notifyDataSetChanged();
        }
    }

    public void aXR() {
        if (this.iEb instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.iEb).aXR();
        }
    }

    private void cwX() {
        if (this.iEd == null && this.iDN.getPageContext() != null) {
            String[] strArr = {this.iDN.getPageContext().getPageActivity().getString(R.string.take_photo), this.iDN.getPageContext().getPageActivity().getString(R.string.album)};
            this.iEd = new com.baidu.tbadk.core.dialog.b(this.iDN.getPageContext().getPageActivity());
            this.iEd.Bb(this.iDN.getPageContext().getPageActivity().getString(R.string.operation));
            this.iEd.a(strArr, new b.InterfaceC0564b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.iDN.cwq();
                    } else if (i == 1 && q.this.iDN.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.iDN.getPageContext().getPageActivity());
                    }
                }
            });
            this.iEd.d(this.iDN.getPageContext());
        }
    }

    public void cwY() {
        cwX();
        if (this.iEd != null) {
            this.iEd.bmE();
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
                if (this.iDN != null && this.iDN.cvF() != null && this.iDN.cvF().cBJ() == 0) {
                    sVar.yJ(this.iDN.cvF().cBQ());
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
                        ((bv) qVar).erH.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.iEb.b(arrayList2, frsViewData);
            if (this.iko != null && this.iDz != 0) {
                this.iko.a(this.iDz, this.gch, this.iEj, true);
            }
            if (this.iDN != null) {
                this.iDN.cwA();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.iEa;
    }

    public void cwZ() {
        this.iEb.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iDN.getPageContext(), 1);
        aVar.a(this.iEa);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.iDN.getForumName());
        hashMap.put("forum_id", this.iDN.getForumId());
        aVar.setParams(hashMap);
        aVar.aB(adVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.iEk != null) {
            this.iEk.cCZ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        yy(TbadkCoreApplication.getInst().getSkinType());
        if (this.iEk != null) {
            this.iEk.cDa();
        }
    }

    public void release() {
        if (this.gbO != null && this.iyC != null) {
            this.gbO.b(this.iyC);
        }
    }

    public ImageView cxa() {
        return this.iDU;
    }

    public ImageView cxb() {
        return this.iDT;
    }

    public TextView cxc() {
        return this.iDV;
    }

    public View cxd() {
        if (this.iDS != null) {
            return this.iDS.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.iDS != null) {
            this.iDS.A(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.iDN, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iDN.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.iEo != null) {
            this.iEo.invalidate();
        }
        if (this.iEb != null) {
            this.iEb.czE();
            this.iEb.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.iDN.getPageContext(), this.iDO);
        if (this.gbO != null) {
            this.gbO.onChangeSkinType(this.iDN.getPageContext(), i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
            this.gdy.changeSkin(i);
        }
        if (this.iEF != null) {
            this.iEF.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
        yy(i);
        if (this.iEl != null) {
            this.iEl.onChangeSkinType(i);
        }
        if (this.iEk != null) {
            this.iEk.onChangeSkinType(i);
        }
        if (this.iEB != null) {
            this.iEB.onChangeSkinType();
        }
        if (this.iEC != null) {
            this.iEC.onChangeSkinType();
        }
        if (this.iDN != null && this.iDN.cvP()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iDQ, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iDQ, R.color.cp_bg_line_d);
        }
    }

    private void yy(int i) {
        if (this.iDN != null) {
            yz(i);
        }
    }

    private void yz(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iDN.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iEf, R.color.cp_bg_line_c, i);
            if (this.iDS != null) {
                this.iDS.onChangeSkinType(i);
            }
            if (this.iDU != null) {
                SvgManager.boN().a(this.iDU, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iDT != null) {
                SvgManager.boN().a(this.iDT, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bxQ, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iEq, R.color.cp_bg_line_h);
        pt(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gKp) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.iEG != 0) {
                    SvgManager.boN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.boN().a(this.iDU, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.boN().a(this.hXY, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.boN().a(this.iDT, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iEG = 0;
                }
            } else if (z || this.iEG != 1) {
                SvgManager.boN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.boN().a(this.iDU, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.boN().a(this.hXY, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.boN().a(this.iDT, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iEG = 1;
            }
            cxe();
        }
    }

    private void cxe() {
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
            if (this.iEF != null) {
                this.iEF.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.hXY != null) {
                    this.hXY.setAlpha(f);
                }
                if (this.hXZ != null) {
                    this.hXZ.setAlpha(f);
                }
                if (this.iDU != null) {
                    this.iDU.setAlpha(f);
                }
                if (this.iDT != null) {
                    this.iDT.setAlpha(f);
                }
            }
            if (this.iDV != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.iDV.setAlpha(f2);
                this.iDV.setClickable(f2 > 0.0f);
            }
            if (this.bxQ != null) {
                this.bxQ.setAlpha(alpha);
            }
            if (this.iEq != null) {
                this.iEq.setAlpha(alpha);
            }
            if (this.iEf != null) {
                this.iEf.setAlpha(alpha);
            }
        }
    }

    public void bMH() {
        if (this.iEc != null) {
            this.iEc.bMH();
        }
    }

    public void pu(boolean z) {
        if (this.iEc != null) {
            this.iEc.pu(z);
        }
    }

    public void pv(boolean z) {
        this.iEh = z;
        if (this.iEh) {
            this.gdy.setText(this.iDN.getResources().getString(R.string.load_more));
            if (this.iEa.getChildAt(this.iEa.getChildCount() - 1) == this.gdy.getView()) {
                this.gdy.startLoadData();
                this.iDN.bMi();
                return;
            }
            this.gdy.endLoadData();
            return;
        }
        this.gdy.setText(this.iDN.getResources().getString(R.string.load_more_must_after_delete));
        this.gdy.endLoadData();
    }

    public boolean cxf() {
        if (this.iEh) {
            return false;
        }
        this.gdy.setText(this.iDN.getResources().getString(R.string.load_more_must_after_delete));
        this.gdy.endLoadData();
        return true;
    }

    public boolean cxg() {
        return this.iDW != null && this.iDZ.getVisibility() == 0;
    }

    public void cxh() {
        if (this.iDW != null) {
            this.iDX.setVisibility(0);
            this.iDZ.setVisibility(8);
            this.iDY.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.iEJ, 5000L);
        }
    }

    public void a(cg cgVar) {
        if (this.iDW == null) {
            View rootView = this.iDN.getRootView();
            this.iDW = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.iDW.setVisibility(0);
            this.iDX = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.iDY = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.iDZ = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.iDY.setPageId(this.iDN.getUniqueId());
            this.iDZ.setPageId(this.iDN.getUniqueId());
            this.iDY.setDefaultBgResource(R.color.common_color_10022);
            this.iDY.setDefaultResource(0);
            this.iDZ.setDefaultBgResource(R.color.common_color_10022);
            this.iDZ.setDefaultResource(0);
            this.iDX.setOnClickListener(this.iEe);
        }
        this.iDX.setVisibility(0);
        String bmr = cgVar.bmr();
        String bms = cgVar.bms();
        this.iDY.startLoad(bmr, 10, false);
        this.iDZ.startLoad(bms, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.iEJ, 5000L);
    }

    public void cxi() {
        if (this.iDW != null && this.iDX != null) {
            this.iDX.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al cxj() {
        return this.iEb;
    }

    public RelativeLayout chy() {
        return this.iDO;
    }

    public View cxk() {
        return this.iEg;
    }

    public void yA(int i) {
        if (this.iDQ != null) {
            this.iDQ.setVisibility(i);
        }
    }

    public void cxl() {
        if (com.baidu.tbadk.n.m.bzV().bzW()) {
            int lastVisiblePosition = this.iEa.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iEa.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.iEX != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.iEX.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fpk = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.iEX.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.iEX.startLogPerf();
                    }
                    if (uVar.iEW != null && (uVar.iEW instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.iEW;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fpk = true;
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

    public NavigationBar bQh() {
        return this.mNavigationBar;
    }

    public void TI() {
        this.mHasMore = true;
        this.iEa.setNextPage(this.gdy);
        if (this.iEi > 0) {
            this.gdy.showEmptyView(this.iEi);
        }
        this.gdy.setOnClickListener(null);
        this.gdy.startLoadData();
    }

    public void TJ() {
        this.mHasMore = false;
        this.iEa.setNextPage(this.gdy);
        if (this.iEi > 0) {
            this.gdy.showEmptyView(this.iEi);
        }
        this.gdy.setOnClickListener(null);
        this.gdy.endLoadData();
        this.gdy.setText(this.iDN.getResources().getString(R.string.list_has_no_more));
    }

    public void cxm() {
        this.mHasMore = true;
        this.iEa.setNextPage(this.gdy);
        this.gdy.setOnClickListener(this.iEe);
        if (this.iEi > 0) {
            this.gdy.showEmptyView(this.iEi);
        }
        this.gdy.endLoadData();
        this.gdy.setText(this.iDN.getResources().getString(R.string.list_click_load_more));
    }

    public View cxn() {
        if (this.gdy == null) {
            return null;
        }
        return this.gdy.getView();
    }

    public void yB(int i) {
        if (this.iEB != null) {
            this.iEB.setVisibility(i);
        }
    }

    public void yC(int i) {
        if (this.iEB != null) {
            this.iEB.setSelectNumber(i);
        }
    }

    public void yD(int i) {
        if (this.iEC != null) {
            this.iEC.setVisibility(i);
        }
    }

    public void yE(int i) {
        if (this.iEC != null) {
            this.iEC.setMoveNumber(i);
        }
    }

    public boolean cxo() {
        return this.iEC != null && this.iEC.cEF();
    }

    public void cxp() {
        if (this.iEC != null) {
            this.iEC.cEG();
        }
    }

    public void bNw() {
        this.mHasMore = false;
        this.iEa.setNextPage(null);
    }

    public boolean cxq() {
        return this.gdy.getView().getParent() != null && this.mHasMore;
    }

    public void yF(int i) {
        this.iEi = i;
    }

    public void yG(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.ilj == null) {
                    this.ilj = new CommonTipView(this.iDN.getActivity());
                }
                this.ilj.setText(R.string.frs_login_tip);
                this.ilj.b((FrameLayout) cxk(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void pw(boolean z) {
        this.mIsBackground = z;
        if (this.iko != null) {
            boolean z2 = (this.iDN == null || this.iDN.cvI() == null || this.iDN.cvI().cDR() == null) ? true : this.iDN.cvI().cDR().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iko.sO(false);
                this.iko.cXA();
                return;
            }
            this.iko.sO(true);
            this.iko.a(this.iDz, this.gch, this.iEj, true);
        }
    }

    public void cl(int i, int i2) {
        if (this.iko != null) {
            this.iko.a(i, i2, this.iEj, 1);
        }
    }

    public void cm(int i, int i2) {
        this.iDz = i;
        this.gch = i2;
    }

    public void px(boolean z) {
        this.iEj = z;
    }

    public void yH(int i) {
        if (this.iEa != null && this.iEa.getChildCount() >= 0) {
            if (this.iEa.getFirstVisiblePosition() > 8) {
                this.iEa.scrollToPosition(8);
            }
            this.iEa.smoothScrollToPosition(i);
        }
    }

    public void cxr() {
        a(this.iEs, this.iDN.cwr());
        if (this.iEb != null) {
            this.iEb.czB();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.iDN.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.iEt == null) {
                this.iEt = new com.baidu.tieba.video.f(this.iDN.getActivity(), this.iDO);
            }
            this.iEt.j(postWriteCallBackData);
        }
    }

    public void cxs() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.iEK && this.iDN.getActivity() != null && this.iDN.getPageContext() != null) {
            View view = null;
            if (this.iEa != null && (headerViewsCount = this.iEa.getHeaderViewsCount()) < this.iEa.getChildCount()) {
                view = this.iEa.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.iDN.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.iDN.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.iDN.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mi = dVar.mi();
                mi.setShouldCheckLocInWindow(false);
                mi.show(this.iDN.getActivity());
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mi != null) {
                            mi.dismiss();
                        }
                    }
                }, 4000L);
                this.iEK = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.iEB != null) {
            this.iEB.setDeleteCallback(aVar);
        }
    }

    public void cxt() {
        if (this.iEB != null) {
            this.iEB.cxt();
        }
    }

    public void bFX() {
        if (this.iEB != null) {
            this.iEB.bFX();
        }
    }

    public void aN(String str, int i) {
        if (this.iEE == null) {
            this.iEE = new TextView(this.iDN.getActivity());
            this.iEE.setGravity(19);
            this.iEE.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iDN.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.iDN.getActivity(), R.dimen.ds34), 0);
            this.iEE.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.iDN.getActivity(), R.dimen.tbds112)));
            this.iEE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.iDN.getActivity(), R.dimen.fontsize30));
            this.iEE.setMaxLines(2);
            this.iEE.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.iEE.setTextColor(ContextCompat.getColor(this.iDN.getActivity(), R.color.cp_cont_a));
        }
        this.iED.setBackgroundColor(i);
        this.iEE.setText(str);
        this.iED.a(this.iDN.getActivity(), this.iEE, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Yh != null) {
            this.Yh.setExpanded(z);
        }
    }

    public void cxu() {
        if (this.iEc != null) {
            this.iEc.startPullRefresh();
        }
    }

    public void Gh() {
        if (cxj() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = cxj().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.exG != 0 && bvVar.erH != null && this.iDN.cvF() != null && this.iDN.cvF().cBm() != null) {
                            int[] imageWidthAndHeight = bvVar.erH.getImageWidthAndHeight();
                            bvVar.exG = imageWidthAndHeight[0];
                            bvVar.exH = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cxj().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iko.a(q.this.iDz, q.this.gch, q.this.iEj, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cxv() {
        if (this.iEk == null) {
            return false;
        }
        return this.iEk.cxv();
    }

    public Context getContext() {
        if (this.iDN == null) {
            return null;
        }
        return this.iDN.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.iEc != null) {
            this.iEc.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.iEc != null) {
            this.iEc.startPullRefresh();
        }
    }

    public void cxw() {
        if (this.iEc != null) {
            this.iEc.cxw();
        }
    }

    public void cxx() {
        if (this.iEc != null) {
            this.iEc.cxx();
        }
    }

    public void a(au auVar) {
        if (this.iEc != null) {
            this.iEc.a(auVar);
        }
    }

    public void yI(int i) {
        if (this.iEc != null) {
            this.iEc.yI(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cxy() {
        return this.iEc;
    }
}
