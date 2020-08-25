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
/* loaded from: classes16.dex */
public class q {
    private AppBarLayout Xv;
    private NoNetworkView fCm;
    private PbListView fDW;
    private com.baidu.tieba.play.i hBL;
    private CommonTipView hCG;
    private com.baidu.adp.widget.ListView.n hDI;
    private View.OnClickListener hVB;
    private View hVC;
    private View hVD;
    private int hVF;
    private com.baidu.tieba.frs.vc.d hVH;
    private com.baidu.tieba.frs.entelechy.b.c hVI;
    private com.baidu.tieba.frs.vc.m hVJ;
    private GifView hVK;
    private TbImageView hVL;
    private HashSet<String> hVM;
    private ObservedChangeLinearLayout hVO;
    private com.baidu.tieba.frs.entelechy.b.a hVP;
    private com.baidu.tieba.video.f hVQ;
    private AppBarLayoutStickyBehavior hVR;
    private FrsHeaderViewContainer hVS;
    private CollapsingToolbarLayout hVT;
    private com.baidu.tieba.frs.vc.h hVX;
    private FrsMultiDelBottomMenuView hVY;
    private FrsMoveAreaBottomMenuView hVZ;
    private FrsFragment hVk;
    private View hVo;
    private com.baidu.tieba.c.d hVp;
    private ImageView hVq;
    private ImageView hVr;
    private TextView hVs;
    private ViewStub hVt;
    private BdTypeRecyclerView hVx;
    private com.baidu.tieba.frs.entelechy.a.al hVy;
    private com.baidu.tieba.frs.vc.k hVz;
    private NavigationBarCoverTip hWa;
    private TextView hWb;
    private TextView hWc;
    private boolean hWh;
    private ImageView hpy;
    private MessageRedDotView hpz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout hVl = null;
    private CoordinatorLayout hVm = null;
    private View hVn = null;
    private FrameLayout hVu = null;
    private TbImageView hVv = null;
    private TbImageView hVw = null;
    private com.baidu.tbadk.core.dialog.b hVA = null;
    private NoNetworkView.a hPZ = null;
    private boolean hVE = true;
    private boolean mHasMore = true;
    private boolean hVG = false;
    private int hUW = 0;
    private int fCF = 0;
    private View boC = null;
    private View hVN = null;
    private boolean ggT = false;
    private boolean dBG = true;
    private boolean hVU = true;
    private int hVV = -1;
    private int hVW = -1;
    private int hWd = 0;
    private int hWe = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener hDK = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.hDI == null) {
                        q.this.hDI = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.hDI.a(q.this.hVx, 2);
                } else if (q.this.hDI != null) {
                    q.this.hDI.rc();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hWf = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.hVz != null) {
                q.this.hVz.setInterceptScrollDown(i == 0);
            }
            if (q.this.hVW != i && Math.abs(i) >= 0 && q.this.cmU() != -1) {
                if (Math.abs(i) >= q.this.cmU()) {
                    if (q.this.hVU) {
                        q.this.hVU = false;
                        q.this.oj(q.this.hVU);
                    }
                } else if (!q.this.hVU) {
                    q.this.hVU = true;
                    q.this.oj(q.this.hVU);
                }
                int cmQ = q.this.cmQ() + q.this.cmP() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cmQ;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.hVW - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.wY(Math.abs(cmQ - totalScrollRange2));
                        if (q.this.hVN != null) {
                            q.this.hVN.setVisibility(0);
                        }
                    } else if (q.this.hVN != null) {
                        if (q.this.cmO() != UtilHelper.getStatusBarHeight()) {
                            q.this.wY(0);
                        }
                        q.this.hVN.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.ggT) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.oo(false);
                        } else if (q.this.hWc != null) {
                            q.this.hWc.setAlpha(abs);
                        }
                    }
                    q.this.hVW = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.hVz != null) {
                int ctG = q.this.hVz.ctG();
                int ctH = ctG - q.this.hVz.ctH();
                if (ctG > 0 && Math.abs(i) >= ctH) {
                    q.this.hVz.dismissLoading();
                }
            }
        }
    };
    private Runnable hWg = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.hVt != null) {
                q.this.hVu.setVisibility(0);
                q.this.hVw.setVisibility(0);
                q.this.hVv.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.hVk != null && appBarLayout != null && this.hVk.clQ() != null && this.hVk.getPageContext() != null) {
            int cmP = cmP() + getNavigationBarHeight() + cmQ();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController clQ = this.hVk.clQ();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.hVk.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.hVk.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.hVn.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.hVk != null && this.hVk.clX();
            if (totalScrollRange <= 0) {
                if (this.hWe != 2) {
                    clQ.yX(2);
                }
                this.hWe = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cmP) {
                if (this.hWe != 1) {
                    clQ.yX(1);
                }
                this.hWe = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.hWe != 0) {
                    clQ.yX(0);
                }
                this.hWe = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.hVk.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.hVn.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout cmM() {
        return this.hVO;
    }

    public View Ot() {
        return this.boC;
    }

    public View cmN() {
        return this.hVN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmO() {
        if (this.boC == null) {
            return 0;
        }
        return this.boC.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmP() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmQ() {
        if (this.fCm == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fCm.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY(int i) {
        View Ot = Ot();
        View cmN = cmN();
        if (UtilHelper.canUseStyleImmersiveSticky() && Ot != null && cmN != null && Ot.getLayoutParams() != null && cmN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Ot.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Ot.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cmN.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cmN.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.hVk = null;
        this.hVB = null;
        this.hVF = 0;
        this.hVk = frsFragment;
        this.hVB = onClickListener;
        MessageManager.getInstance().registerListener(this.hDK);
        a(aVar, z);
        this.hVM = new HashSet<>();
        this.hVF = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hVX = hVar;
    }

    private boolean cmR() {
        return this.hVX != null && this.hVX.cts();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.hVP = aVar;
        View rootView = this.hVk.getRootView();
        if (this.hVl == null) {
            this.hVl = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.hVn == null) {
            this.hVn = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.hVm == null) {
            this.hVm = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.hVD == null) {
            this.hVD = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.hVT == null) {
            this.hVT = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.hVS == null) {
            this.hVS = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.hVz == null) {
            this.hVz = new com.baidu.tieba.frs.vc.k(this.hVk);
        }
        if (this.hVO == null) {
            this.hVO = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.hVO.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.hVT.setMinimumHeight(i2);
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
        if (this.hVk.cmz()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.hVC == null) {
            this.hVC = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b cpn = aVar.cpn();
            if (cpn != null) {
                cpn.cg(this.hVC);
            }
        }
        if (this.hVo == null) {
            this.hVo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hVo.setOnClickListener(this.hVB);
            this.mBackImageView = (ImageView) this.hVo.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hVr == null) {
            this.hVr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bjq().a(this.hVr, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hVr.setOnClickListener(this.hVB);
        }
        if (this.hVp == null) {
            this.hVp = new com.baidu.tieba.c.d(this.hVk.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hVp.getView(), (View.OnClickListener) null);
            this.hpy = this.hVp.ccZ();
            this.hpz = this.hVp.cda();
            this.hVp.getView().setOnClickListener(this.hVB);
            this.hVp.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.hVq == null) {
            this.hVq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bjq().a(this.hVq, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hVq.setOnClickListener(this.hVB);
        }
        if (this.hVs == null) {
            this.hVs = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.hVs.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.hVk.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hVs.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.f(this.hVs, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.hVs, R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.hVk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.hVx == null) {
            this.hVx = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int hWk = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.hWk--;
                if (this.hWk == 0) {
                    q.this.hVx.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.hWk++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.hVx.setItemAnimator(defaultItemAnimator);
        this.hVx.setLayoutManager(new LinearLayoutManager(this.hVx.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hDI = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.hDI.a(this.hVx, 2);
        }
        this.hVx.setScrollable(this.hVk);
        this.hVx.setFadingEdgeLength(0);
        this.hVx.setOverScrollMode(2);
        this.hVl.setBottomOrderView(this.hVx);
        this.hVx.setOnTouchListener(this.hVk.eVD);
        this.hVx.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.hBL != null) {
                    q.this.hBL.cE(view);
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
        if (this.fDW == null) {
            this.fDW = new PbListView(this.hVk.getPageContext().getPageActivity());
            this.fDW.getView();
        }
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fDW.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hVk.getActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hVx.setOnSrollToBottomListener(this.hVk);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.hVk.cms();
                if (q.this.hVk != null && q.this.Xv != null) {
                    q.this.hVk.cmC();
                    q.this.Xv.setExpanded(true);
                    if (q.this.hBL != null) {
                        q.this.hBL.a(q.this.hUW, q.this.fCF, false, true);
                    }
                }
            }
        });
        boolean bjs = com.baidu.tbadk.core.util.au.bjr().bjs();
        if (this.hVy == null) {
            this.hVy = aVar.a(this.hVk, this.hVx, bjs);
        }
        if (this.hVz != null) {
            this.hVz.O(1, false);
        }
        if (!z) {
            if (this.fCm == null) {
                this.fCm = new NoNetworkView(this.hVk.getActivity());
                this.fCm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.hVO.addView(this.fCm);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fCm.setVisibility(8);
            } else {
                this.fCm.setVisibility(0);
            }
            this.fCm.onChangeSkinType(this.hVk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cnb();
        if (this.hVH == null) {
            this.hVH = aVar.a(this.hVk, this.hVl);
            this.hVH.b(this.hVk.cmD());
        }
        if (this.hVI == null) {
            this.hVI = aVar.b(this.hVk, this.hVl);
            om(true);
        }
        if (this.boC == null) {
            this.boC = rootView.findViewById(R.id.statebar_view);
        }
        if (this.hVN == null) {
            this.hVN = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.hBL == null) {
            this.hBL = new com.baidu.tieba.play.i(this.hVk.getPageContext(), this.hVx);
        }
        this.hBL.FH(1);
        this.hBL.setUniqueId(this.hVk.getUniqueId());
        this.hWa = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.hVJ == null) {
            this.hVJ = new com.baidu.tieba.frs.vc.m(this.hVk, this.hWa);
        }
        if (this.Xv == null) {
            this.Xv = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Xv.addOnOffsetChangedListener(this.hWf);
            this.hVU = true;
            this.hVV = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Xv.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.hVR = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.hVY = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.hVY.setPageContext(this.hVk.getPageContext());
        this.hVZ = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.hVZ.setPageContext(this.hVk.getPageContext());
        if (this.hWc == null) {
            this.hWc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hVk.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.hWc.setLayoutParams(layoutParams2);
            this.hWc.setPadding(0, 0, this.hVk.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.hWc.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
    }

    public void bJ(boolean z) {
        if (z) {
        }
    }

    private void cmS() {
        ViewGroup.LayoutParams layoutParams;
        this.ggT = cmR();
        if (this.hVS != null && (layoutParams = this.hVS.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.ggT) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cmP(), 0, 0);
            }
            this.hVS.requestLayout();
        }
    }

    public void cmT() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hVO != null) {
            cmS();
            if (this.ggT) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.boC != null) {
                    this.boC.setAlpha(1.0f);
                }
                if (this.hVN != null) {
                    this.hVN.setAlpha(1.0f);
                }
                if (this.hWc != null) {
                    this.hWc.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        if (z && this.hVk != null && this.hVk.clP() != null) {
            this.hVk.clP().ctx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmU() {
        int i;
        if (this.Xv == null) {
            return this.hVV;
        }
        if (this.hVV != -1) {
            return this.hVV;
        }
        int childCount = this.Xv.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Xv.getChildAt(childCount);
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
        this.hVV = Math.max(0, this.Xv.getTotalScrollRange() - Math.abs(i2));
        return this.hVV;
    }

    public void Iq(String str) {
        if (this.hVJ != null) {
            this.hVJ.Iq(str);
        }
    }

    public com.baidu.tieba.play.i cmV() {
        return this.hBL;
    }

    public com.baidu.tieba.frs.entelechy.b.c cmW() {
        return this.hVI;
    }

    public void ok(boolean z) {
        if (this.hVH != null) {
            if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                this.hVH.ok(false);
            } else {
                this.hVH.ok(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cmX() {
        return this.hVH;
    }

    public void U(boolean z, boolean z2) {
        if (this.dBG && this.hVI != null) {
            this.hVI.U(z, z2);
        }
    }

    public void ol(boolean z) {
        this.dBG = z;
        if (!this.dBG && this.hVI != null) {
            this.hVI.U(false, false);
        }
    }

    public void cmY() {
        if (this.dBG && this.hVI != null) {
            this.hVI.U(false, false);
        }
        wZ(8);
        this.hVr.setVisibility(8);
        this.hVq.setVisibility(8);
        ok(false);
        this.hVx.setVisibility(8);
        this.hVS.setVisibility(8);
    }

    public void cmZ() {
        if (this.dBG && this.hVI != null) {
            this.hVI.U(true, false);
        }
        wZ(0);
        cna();
        ok(this.hVk.cmF());
        this.hVx.setVisibility(0);
        this.hVS.setVisibility(0);
    }

    private void wZ(int i) {
        if (this.hVp != null) {
            this.hVp.setVisibility(i);
        }
    }

    private void cna() {
        this.hVr.setVisibility(0);
        this.hVq.setVisibility(0);
    }

    public void om(boolean z) {
        if (this.hVI != null) {
            this.hVI.oO(z);
        }
    }

    private void cnb() {
        if (this.hVK == null) {
            View rootView = this.hVk.getRootView();
            this.hVK = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.hVL = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.hVL.setPageId(this.hVk.getUniqueId());
            this.hVK.setLayerType(1, null);
            this.hVL.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cnc() {
        return this.hVo;
    }

    public void g(NoNetworkView.a aVar) {
        this.hPZ = aVar;
        if (this.fCm != null) {
            this.fCm.a(this.hPZ);
        }
    }

    public void on(boolean z) {
        if (this.hVI != null) {
            if (z) {
                U(false, true);
            } else {
                U(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hVx.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.hVy.a(abVar);
    }

    public void setForumName(String str) {
        this.hVy.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hDK);
        if (this.hBL != null) {
            this.hBL.destroy();
        }
        if (this.hVJ != null) {
            this.hVJ.onDestory();
        }
        if (this.hVY != null) {
            this.hVY.setPageContext(null);
        }
        if (this.hVZ != null) {
            this.hVZ.setPageContext(null);
        }
        this.hVy.onDestory();
        this.hVx.setOnSrollToBottomListener(null);
        this.hVx.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.hWg);
        if (this.hCG != null) {
            this.hCG.onDestroy();
        }
        this.hVM.clear();
        if (this.hVH != null) {
            this.hVH.ctc();
        }
        if (this.hVQ != null) {
            this.hVQ.coU();
        }
        if (this.hWa != null) {
            this.hWa.onDestroy();
        }
        if (this.hVY != null) {
            this.hVY.onDestroy();
        }
        if (this.hVz != null) {
            this.hVz.onDestroy();
        }
    }

    public boolean cnd() {
        if (this.Xv == null || this.hVR == null || !this.hVR.isSticky()) {
            return this.hVH != null && this.hVH.cnd();
        }
        if (this.hVx != null) {
            this.hVx.setSelection(0);
        }
        this.hVR.expandedAppBarLayout(this.Xv);
        return true;
    }

    public boolean cmx() {
        if (this.hVz == null) {
            return false;
        }
        return this.hVz.cmx();
    }

    public void bLs() {
        this.hVx.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.hWc.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.hWc.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.hWc.setText(str2);
            com.baidu.tbadk.core.k.bbM().setForumNameForWaterImage(str);
        }
    }

    public void cne() {
        if (this.hVy != null) {
            this.hVy.notifyDataSetChanged();
        }
    }

    public void aSD() {
        if (this.hVy instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.hVy).aSD();
        }
    }

    private void cnf() {
        if (this.hVA == null && this.hVk.getPageContext() != null) {
            String[] strArr = {this.hVk.getPageContext().getPageActivity().getString(R.string.take_photo), this.hVk.getPageContext().getPageActivity().getString(R.string.album)};
            this.hVA = new com.baidu.tbadk.core.dialog.b(this.hVk.getPageContext().getPageActivity());
            this.hVA.zA(this.hVk.getPageContext().getPageActivity().getString(R.string.operation));
            this.hVA.a(strArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.hVk.cmy();
                    } else if (i == 1 && q.this.hVk.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.hVk.getPageContext().getPageActivity());
                    }
                }
            });
            this.hVA.d(this.hVk.getPageContext());
        }
    }

    public void cng() {
        cnf();
        if (this.hVA != null) {
            this.hVA.bhi();
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
                if (this.hVk != null && this.hVk.clN() != null && this.hVk.clN().crP() == 0) {
                    sVar.xl(this.hVk.clN().crW());
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
                        ((bv) qVar).dUS.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.hVy.b(arrayList2, frsViewData);
            if (this.hBL != null && this.hUW != 0) {
                this.hBL.a(this.hUW, this.fCF, this.hVG, true);
            }
            if (this.hVk != null) {
                this.hVk.cmI();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.hVx;
    }

    public void cnh() {
        this.hVy.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hVk.getPageContext(), 1);
        aVar.a(this.hVx);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.hVk.getForumName());
        hashMap.put("forum_id", this.hVk.getForumId());
        aVar.setParams(hashMap);
        aVar.aw(adVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.hVH != null) {
            this.hVH.ctd();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        xa(TbadkCoreApplication.getInst().getSkinType());
        if (this.hVH != null) {
            this.hVH.cte();
        }
    }

    public void release() {
        if (this.fCm != null && this.hPZ != null) {
            this.fCm.b(this.hPZ);
        }
    }

    public ImageView cni() {
        return this.hVr;
    }

    public ImageView cnj() {
        return this.hVq;
    }

    public TextView cnk() {
        return this.hVs;
    }

    public View cnl() {
        if (this.hVp != null) {
            return this.hVp.getView();
        }
        return null;
    }

    public void N(int i, boolean z) {
        if (this.hVp != null) {
            this.hVp.x(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.hVk, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hVk.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.hVL != null) {
            this.hVL.invalidate();
        }
        if (this.hVy != null) {
            this.hVy.cpM();
            this.hVy.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.hVk.getPageContext(), this.hVl);
        if (this.fCm != null) {
            this.fCm.onChangeSkinType(this.hVk.getPageContext(), i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
            this.fDW.changeSkin(i);
        }
        if (this.hWc != null) {
            this.hWc.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
        xa(i);
        if (this.hVI != null) {
            this.hVI.onChangeSkinType(i);
        }
        if (this.hVH != null) {
            this.hVH.onChangeSkinType(i);
        }
        if (this.hVY != null) {
            this.hVY.onChangeSkinType();
        }
        if (this.hVZ != null) {
            this.hVZ.onChangeSkinType();
        }
        if (this.hVk != null && this.hVk.clX()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.hVn, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.hVn, R.color.cp_bg_line_d);
        }
    }

    private void xa(int i) {
        if (this.hVk != null) {
            xb(i);
        }
    }

    private void xb(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hVk.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.hVC, R.color.cp_bg_line_c, i);
            if (this.hVp != null) {
                this.hVp.onChangeSkinType(i);
            }
            if (this.hVr != null) {
                SvgManager.bjq().a(this.hVr, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hVq != null) {
                SvgManager.bjq().a(this.hVq, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.boC, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.hVN, R.color.cp_bg_line_h);
        oo(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.ggT) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.hWd != 0) {
                    SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(this.hVr, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(this.hpy, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(this.hVq, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.hWd = 0;
                }
            } else if (z || this.hWd != 1) {
                SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.hVr, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.hpy, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.hVq, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.hWd = 1;
            }
            cnm();
        }
    }

    private void cnm() {
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
            if (this.hWc != null) {
                this.hWc.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.hpy != null) {
                    this.hpy.setAlpha(f);
                }
                if (this.hpz != null) {
                    this.hpz.setAlpha(f);
                }
                if (this.hVr != null) {
                    this.hVr.setAlpha(f);
                }
                if (this.hVq != null) {
                    this.hVq.setAlpha(f);
                }
            }
            if (this.hVs != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.hVs.setAlpha(f2);
                this.hVs.setClickable(f2 > 0.0f);
            }
            if (this.boC != null) {
                this.boC.setAlpha(alpha);
            }
            if (this.hVN != null) {
                this.hVN.setAlpha(alpha);
            }
            if (this.hVC != null) {
                this.hVC.setAlpha(alpha);
            }
        }
    }

    public void bGd() {
        if (this.hVz != null) {
            this.hVz.bGd();
        }
    }

    public void op(boolean z) {
        if (this.hVz != null) {
            this.hVz.op(z);
        }
    }

    public void oq(boolean z) {
        this.hVE = z;
        if (this.hVE) {
            this.fDW.setText(this.hVk.getResources().getString(R.string.load_more));
            if (this.hVx.getChildAt(this.hVx.getChildCount() - 1) == this.fDW.getView()) {
                this.fDW.startLoadData();
                this.hVk.bFD();
                return;
            }
            this.fDW.endLoadData();
            return;
        }
        this.fDW.setText(this.hVk.getResources().getString(R.string.load_more_must_after_delete));
        this.fDW.endLoadData();
    }

    public boolean cnn() {
        if (this.hVE) {
            return false;
        }
        this.fDW.setText(this.hVk.getResources().getString(R.string.load_more_must_after_delete));
        this.fDW.endLoadData();
        return true;
    }

    public boolean cno() {
        return this.hVt != null && this.hVw.getVisibility() == 0;
    }

    public void cnp() {
        if (this.hVt != null) {
            this.hVu.setVisibility(0);
            this.hVw.setVisibility(8);
            this.hVv.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.hWg, 5000L);
        }
    }

    public void a(cg cgVar) {
        if (this.hVt == null) {
            View rootView = this.hVk.getRootView();
            this.hVt = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.hVt.setVisibility(0);
            this.hVu = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.hVv = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.hVw = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.hVv.setPageId(this.hVk.getUniqueId());
            this.hVw.setPageId(this.hVk.getUniqueId());
            this.hVv.setDefaultBgResource(R.color.common_color_10022);
            this.hVv.setDefaultResource(0);
            this.hVw.setDefaultBgResource(R.color.common_color_10022);
            this.hVw.setDefaultResource(0);
            this.hVu.setOnClickListener(this.hVB);
        }
        this.hVu.setVisibility(0);
        String bgV = cgVar.bgV();
        String bgW = cgVar.bgW();
        this.hVv.startLoad(bgV, 10, false);
        this.hVw.startLoad(bgW, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.hWg, 5000L);
    }

    public void cnq() {
        if (this.hVt != null && this.hVu != null) {
            this.hVu.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al cnr() {
        return this.hVy;
    }

    public RelativeLayout bZb() {
        return this.hVl;
    }

    public View cns() {
        return this.hVD;
    }

    public void xc(int i) {
        if (this.hVn != null) {
            this.hVn.setVisibility(i);
        }
    }

    public void cnt() {
        if (com.baidu.tbadk.n.m.bun().buo()) {
            int lastVisiblePosition = this.hVx.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hVx.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.hWu != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.hWu.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eRI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.hWu.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.hWu.startLogPerf();
                    }
                    if (uVar.hWt != null && (uVar.hWt instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.hWt;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eRI = true;
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

    public NavigationBar bJH() {
        return this.mNavigationBar;
    }

    public void bGR() {
        this.mHasMore = true;
        this.hVx.setNextPage(this.fDW);
        if (this.hVF > 0) {
            this.fDW.showEmptyView(this.hVF);
        }
        this.fDW.setOnClickListener(null);
        this.fDW.startLoadData();
    }

    public void bGS() {
        this.mHasMore = false;
        this.hVx.setNextPage(this.fDW);
        if (this.hVF > 0) {
            this.fDW.showEmptyView(this.hVF);
        }
        this.fDW.setOnClickListener(null);
        this.fDW.endLoadData();
        this.fDW.setText(this.hVk.getResources().getString(R.string.list_has_no_more));
    }

    public void cnu() {
        this.mHasMore = true;
        this.hVx.setNextPage(this.fDW);
        this.fDW.setOnClickListener(this.hVB);
        if (this.hVF > 0) {
            this.fDW.showEmptyView(this.hVF);
        }
        this.fDW.endLoadData();
        this.fDW.setText(this.hVk.getResources().getString(R.string.list_click_load_more));
    }

    public View cnv() {
        if (this.fDW == null) {
            return null;
        }
        return this.fDW.getView();
    }

    public void xd(int i) {
        if (this.hVY != null) {
            this.hVY.setVisibility(i);
        }
    }

    public void xe(int i) {
        if (this.hVY != null) {
            this.hVY.setSelectNumber(i);
        }
    }

    public void xf(int i) {
        if (this.hVZ != null) {
            this.hVZ.setVisibility(i);
        }
    }

    public void xg(int i) {
        if (this.hVZ != null) {
            this.hVZ.setMoveNumber(i);
        }
    }

    public boolean cnw() {
        return this.hVZ != null && this.hVZ.cuH();
    }

    public void cnx() {
        if (this.hVZ != null) {
            this.hVZ.cuI();
        }
    }

    public void bGT() {
        this.mHasMore = false;
        this.hVx.setNextPage(null);
    }

    public boolean cny() {
        return this.fDW.getView().getParent() != null && this.mHasMore;
    }

    public void xh(int i) {
        this.hVF = i;
    }

    public void xi(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.hCG == null) {
                    this.hCG = new CommonTipView(this.hVk.getActivity());
                }
                this.hCG.setText(R.string.frs_login_tip);
                this.hCG.b((FrameLayout) cns(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void or(boolean z) {
        this.mIsBackground = z;
        if (this.hBL != null) {
            boolean z2 = (this.hVk == null || this.hVk.clQ() == null || this.hVk.clQ().ctT() == null) ? true : this.hVk.clQ().ctT().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.hBL.rF(false);
                this.hBL.cNd();
                return;
            }
            this.hBL.rF(true);
            this.hBL.a(this.hUW, this.fCF, this.hVG, true);
        }
    }

    public void cg(int i, int i2) {
        if (this.hBL != null) {
            this.hBL.a(i, i2, this.hVG, 1);
        }
    }

    public void ch(int i, int i2) {
        this.hUW = i;
        this.fCF = i2;
    }

    public void os(boolean z) {
        this.hVG = z;
    }

    public void xj(int i) {
        if (this.hVx != null && this.hVx.getChildCount() >= 0) {
            if (this.hVx.getFirstVisiblePosition() > 8) {
                this.hVx.scrollToPosition(8);
            }
            this.hVx.smoothScrollToPosition(i);
        }
    }

    public void cnz() {
        a(this.hVP, this.hVk.cmz());
        if (this.hVy != null) {
            this.hVy.cpJ();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.hVQ == null) {
                this.hVQ = new com.baidu.tieba.video.f(this.hVk.getActivity(), this.hVl);
            }
            this.hVQ.i(postWriteCallBackData);
        }
    }

    public void cnA() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.hWh && this.hVk.getActivity() != null && this.hVk.getPageContext() != null) {
            View view = null;
            if (this.hVx != null && (headerViewsCount = this.hVx.getHeaderViewsCount()) < this.hVx.getChildCount()) {
                view = this.hVx.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aj(0).ag(true).ah(false).af(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.hVk.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.hVk.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.hVk.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c md = dVar.md();
                md.setShouldCheckLocInWindow(false);
                md.show(this.hVk.getActivity());
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (md != null) {
                            md.dismiss();
                        }
                    }
                }, 4000L);
                this.hWh = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.hVY != null) {
            this.hVY.setDeleteCallback(aVar);
        }
    }

    public void cnB() {
        if (this.hVY != null) {
            this.hVY.cnB();
        }
    }

    public void bAi() {
        if (this.hVY != null) {
            this.hVY.bAi();
        }
    }

    public void aL(String str, int i) {
        if (this.hWb == null) {
            this.hWb = new TextView(this.hVk.getActivity());
            this.hWb.setGravity(19);
            this.hWb.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hVk.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.hVk.getActivity(), R.dimen.ds34), 0);
            this.hWb.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hVk.getActivity(), R.dimen.tbds112)));
            this.hWb.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hVk.getActivity(), R.dimen.fontsize30));
            this.hWb.setMaxLines(2);
            this.hWb.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.hWb.setTextColor(ContextCompat.getColor(this.hVk.getActivity(), R.color.cp_cont_a));
        }
        this.hWa.setBackgroundColor(i);
        this.hWb.setText(str);
        this.hWa.a(this.hVk.getActivity(), this.hWb, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Xv != null) {
            this.Xv.setExpanded(z);
        }
    }

    public void cnC() {
        if (this.hVz != null) {
            this.hVz.startPullRefresh();
        }
    }

    public void EF() {
        if (cnr() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = cnr().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.eaP != 0 && bvVar.dUS != null && this.hVk.clN() != null && this.hVk.clN().crs() != null) {
                            int[] imageWidthAndHeight = bvVar.dUS.getImageWidthAndHeight();
                            bvVar.eaP = imageWidthAndHeight[0];
                            bvVar.eaQ = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cnr().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.hBL.a(q.this.hUW, q.this.fCF, q.this.hVG, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cnD() {
        if (this.hVH == null) {
            return false;
        }
        return this.hVH.cnD();
    }

    public Context getContext() {
        if (this.hVk == null) {
            return null;
        }
        return this.hVk.getTbPageContext().getPageActivity();
    }

    public void O(int i, boolean z) {
        if (this.hVz != null) {
            this.hVz.O(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.hVz != null) {
            this.hVz.startPullRefresh();
        }
    }

    public void cnE() {
        if (this.hVz != null) {
            this.hVz.cnE();
        }
    }

    public void cnF() {
        if (this.hVz != null) {
            this.hVz.cnF();
        }
    }

    public void a(au auVar) {
        if (this.hVz != null) {
            this.hVz.a(auVar);
        }
    }

    public void xk(int i) {
        if (this.hVz != null) {
            this.hVz.xk(i);
        }
    }
}
