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
    private AppBarLayout Xx;
    private NoNetworkView fCq;
    private PbListView fEa;
    private com.baidu.tieba.play.i hBR;
    private CommonTipView hCM;
    private com.baidu.adp.widget.ListView.n hDO;
    private BdTypeRecyclerView hVD;
    private com.baidu.tieba.frs.entelechy.a.al hVE;
    private com.baidu.tieba.frs.vc.k hVF;
    private View.OnClickListener hVH;
    private View hVI;
    private View hVJ;
    private int hVL;
    private com.baidu.tieba.frs.vc.d hVN;
    private com.baidu.tieba.frs.entelechy.b.c hVO;
    private com.baidu.tieba.frs.vc.m hVP;
    private GifView hVQ;
    private TbImageView hVR;
    private HashSet<String> hVS;
    private ObservedChangeLinearLayout hVU;
    private com.baidu.tieba.frs.entelechy.b.a hVV;
    private com.baidu.tieba.video.f hVW;
    private AppBarLayoutStickyBehavior hVX;
    private FrsHeaderViewContainer hVY;
    private CollapsingToolbarLayout hVZ;
    private FrsFragment hVq;
    private View hVu;
    private com.baidu.tieba.c.d hVv;
    private ImageView hVw;
    private ImageView hVx;
    private TextView hVy;
    private ViewStub hVz;
    private com.baidu.tieba.frs.vc.h hWd;
    private FrsMultiDelBottomMenuView hWe;
    private FrsMoveAreaBottomMenuView hWf;
    private NavigationBarCoverTip hWg;
    private TextView hWh;
    private TextView hWi;
    private boolean hWn;
    private ImageView hpC;
    private MessageRedDotView hpD;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout hVr = null;
    private CoordinatorLayout hVs = null;
    private View hVt = null;
    private FrameLayout hVA = null;
    private TbImageView hVB = null;
    private TbImageView hVC = null;
    private com.baidu.tbadk.core.dialog.b hVG = null;
    private NoNetworkView.a hQf = null;
    private boolean hVK = true;
    private boolean mHasMore = true;
    private boolean hVM = false;
    private int hVc = 0;
    private int fCJ = 0;
    private View boF = null;
    private View hVT = null;
    private boolean ggX = false;
    private boolean dBK = true;
    private boolean hWa = true;
    private int hWb = -1;
    private int hWc = -1;
    private int hWj = 0;
    private int hWk = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener hDQ = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.hDO == null) {
                        q.this.hDO = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.hDO.a(q.this.hVD, 2);
                } else if (q.this.hDO != null) {
                    q.this.hDO.rc();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hWl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.hVF != null) {
                q.this.hVF.setInterceptScrollDown(i == 0);
            }
            if (q.this.hWc != i && Math.abs(i) >= 0 && q.this.cmV() != -1) {
                if (Math.abs(i) >= q.this.cmV()) {
                    if (q.this.hWa) {
                        q.this.hWa = false;
                        q.this.ol(q.this.hWa);
                    }
                } else if (!q.this.hWa) {
                    q.this.hWa = true;
                    q.this.ol(q.this.hWa);
                }
                int cmR = q.this.cmR() + q.this.cmQ() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cmR;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.hWc - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.wY(Math.abs(cmR - totalScrollRange2));
                        if (q.this.hVT != null) {
                            q.this.hVT.setVisibility(0);
                        }
                    } else if (q.this.hVT != null) {
                        if (q.this.cmP() != UtilHelper.getStatusBarHeight()) {
                            q.this.wY(0);
                        }
                        q.this.hVT.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.ggX) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.oq(false);
                        } else if (q.this.hWi != null) {
                            q.this.hWi.setAlpha(abs);
                        }
                    }
                    q.this.hWc = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.hVF != null) {
                int ctH = q.this.hVF.ctH();
                int ctI = ctH - q.this.hVF.ctI();
                if (ctH > 0 && Math.abs(i) >= ctI) {
                    q.this.hVF.dismissLoading();
                }
            }
        }
    };
    private Runnable hWm = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.hVz != null) {
                q.this.hVA.setVisibility(0);
                q.this.hVC.setVisibility(0);
                q.this.hVB.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.hVq != null && appBarLayout != null && this.hVq.clR() != null && this.hVq.getPageContext() != null) {
            int cmQ = cmQ() + getNavigationBarHeight() + cmR();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController clR = this.hVq.clR();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.hVq.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.hVq.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.hVt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.hVq != null && this.hVq.clY();
            if (totalScrollRange <= 0) {
                if (this.hWk != 2) {
                    clR.yX(2);
                }
                this.hWk = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cmQ) {
                if (this.hWk != 1) {
                    clR.yX(1);
                }
                this.hWk = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.hWk != 0) {
                    clR.yX(0);
                }
                this.hWk = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.hVq.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.hVt.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout cmN() {
        return this.hVU;
    }

    public View Ot() {
        return this.boF;
    }

    public View cmO() {
        return this.hVT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmP() {
        if (this.boF == null) {
            return 0;
        }
        return this.boF.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmQ() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmR() {
        if (this.fCq == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fCq.getHeight();
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
        View cmO = cmO();
        if (UtilHelper.canUseStyleImmersiveSticky() && Ot != null && cmO != null && Ot.getLayoutParams() != null && cmO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Ot.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Ot.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cmO.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cmO.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.hVq = null;
        this.hVH = null;
        this.hVL = 0;
        this.hVq = frsFragment;
        this.hVH = onClickListener;
        MessageManager.getInstance().registerListener(this.hDQ);
        a(aVar, z);
        this.hVS = new HashSet<>();
        this.hVL = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hWd = hVar;
    }

    private boolean cmS() {
        return this.hWd != null && this.hWd.ctt();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.hVV = aVar;
        View rootView = this.hVq.getRootView();
        if (this.hVr == null) {
            this.hVr = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.hVt == null) {
            this.hVt = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.hVs == null) {
            this.hVs = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.hVJ == null) {
            this.hVJ = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.hVZ == null) {
            this.hVZ = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.hVY == null) {
            this.hVY = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.hVF == null) {
            this.hVF = new com.baidu.tieba.frs.vc.k(this.hVq);
        }
        if (this.hVU == null) {
            this.hVU = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.hVU.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.hVZ.setMinimumHeight(i2);
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
        if (this.hVq.cmA()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.hVI == null) {
            this.hVI = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b cpo = aVar.cpo();
            if (cpo != null) {
                cpo.cg(this.hVI);
            }
        }
        if (this.hVu == null) {
            this.hVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hVu.setOnClickListener(this.hVH);
            this.mBackImageView = (ImageView) this.hVu.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hVx == null) {
            this.hVx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bjq().a(this.hVx, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hVx.setOnClickListener(this.hVH);
        }
        if (this.hVv == null) {
            this.hVv = new com.baidu.tieba.c.d(this.hVq.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hVv.getView(), (View.OnClickListener) null);
            this.hpC = this.hVv.cda();
            this.hpD = this.hVv.cdb();
            this.hVv.getView().setOnClickListener(this.hVH);
            this.hVv.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.hVw == null) {
            this.hVw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bjq().a(this.hVw, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hVw.setOnClickListener(this.hVH);
        }
        if (this.hVy == null) {
            this.hVy = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.hVy.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.hVq.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hVy.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.f(this.hVy, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.hVy, R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.hVq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.hVD == null) {
            this.hVD = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int hWq = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.hWq--;
                if (this.hWq == 0) {
                    q.this.hVD.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.hWq++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.hVD.setItemAnimator(defaultItemAnimator);
        this.hVD.setLayoutManager(new LinearLayoutManager(this.hVD.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hDO = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.hDO.a(this.hVD, 2);
        }
        this.hVD.setScrollable(this.hVq);
        this.hVD.setFadingEdgeLength(0);
        this.hVD.setOverScrollMode(2);
        this.hVr.setBottomOrderView(this.hVD);
        this.hVD.setOnTouchListener(this.hVq.eVH);
        this.hVD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.hBR != null) {
                    q.this.hBR.cE(view);
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
        if (this.fEa == null) {
            this.fEa = new PbListView(this.hVq.getPageContext().getPageActivity());
            this.fEa.getView();
        }
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fEa.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hVq.getActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hVD.setOnSrollToBottomListener(this.hVq);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.hVq.cmt();
                if (q.this.hVq != null && q.this.Xx != null) {
                    q.this.hVq.cmD();
                    q.this.Xx.setExpanded(true);
                    if (q.this.hBR != null) {
                        q.this.hBR.a(q.this.hVc, q.this.fCJ, false, true);
                    }
                }
            }
        });
        boolean bjs = com.baidu.tbadk.core.util.au.bjr().bjs();
        if (this.hVE == null) {
            this.hVE = aVar.a(this.hVq, this.hVD, bjs);
        }
        if (this.hVF != null) {
            this.hVF.O(1, false);
        }
        if (!z) {
            if (this.fCq == null) {
                this.fCq = new NoNetworkView(this.hVq.getActivity());
                this.fCq.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.hVU.addView(this.fCq);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fCq.setVisibility(8);
            } else {
                this.fCq.setVisibility(0);
            }
            this.fCq.onChangeSkinType(this.hVq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cnc();
        if (this.hVN == null) {
            this.hVN = aVar.a(this.hVq, this.hVr);
            this.hVN.b(this.hVq.cmE());
        }
        if (this.hVO == null) {
            this.hVO = aVar.b(this.hVq, this.hVr);
            oo(true);
        }
        if (this.boF == null) {
            this.boF = rootView.findViewById(R.id.statebar_view);
        }
        if (this.hVT == null) {
            this.hVT = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.hBR == null) {
            this.hBR = new com.baidu.tieba.play.i(this.hVq.getPageContext(), this.hVD);
        }
        this.hBR.FH(1);
        this.hBR.setUniqueId(this.hVq.getUniqueId());
        this.hWg = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.hVP == null) {
            this.hVP = new com.baidu.tieba.frs.vc.m(this.hVq, this.hWg);
        }
        if (this.Xx == null) {
            this.Xx = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Xx.addOnOffsetChangedListener(this.hWl);
            this.hWa = true;
            this.hWb = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Xx.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.hVX = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.hWe = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.hWe.setPageContext(this.hVq.getPageContext());
        this.hWf = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.hWf.setPageContext(this.hVq.getPageContext());
        if (this.hWi == null) {
            this.hWi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hVq.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.hWi.setLayoutParams(layoutParams2);
            this.hWi.setPadding(0, 0, this.hVq.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.hWi.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
    }

    public void bJ(boolean z) {
        if (z) {
        }
    }

    private void cmT() {
        ViewGroup.LayoutParams layoutParams;
        this.ggX = cmS();
        if (this.hVY != null && (layoutParams = this.hVY.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.ggX) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cmQ(), 0, 0);
            }
            this.hVY.requestLayout();
        }
    }

    public void cmU() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hVU != null) {
            cmT();
            if (this.ggX) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.boF != null) {
                    this.boF.setAlpha(1.0f);
                }
                if (this.hVT != null) {
                    this.hVT.setAlpha(1.0f);
                }
                if (this.hWi != null) {
                    this.hWi.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(boolean z) {
        if (z && this.hVq != null && this.hVq.clQ() != null) {
            this.hVq.clQ().cty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmV() {
        int i;
        if (this.Xx == null) {
            return this.hWb;
        }
        if (this.hWb != -1) {
            return this.hWb;
        }
        int childCount = this.Xx.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Xx.getChildAt(childCount);
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
        this.hWb = Math.max(0, this.Xx.getTotalScrollRange() - Math.abs(i2));
        return this.hWb;
    }

    public void Ir(String str) {
        if (this.hVP != null) {
            this.hVP.Ir(str);
        }
    }

    public com.baidu.tieba.play.i cmW() {
        return this.hBR;
    }

    public com.baidu.tieba.frs.entelechy.b.c cmX() {
        return this.hVO;
    }

    public void om(boolean z) {
        if (this.hVN != null) {
            if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                this.hVN.om(false);
            } else {
                this.hVN.om(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cmY() {
        return this.hVN;
    }

    public void U(boolean z, boolean z2) {
        if (this.dBK && this.hVO != null) {
            this.hVO.U(z, z2);
        }
    }

    public void on(boolean z) {
        this.dBK = z;
        if (!this.dBK && this.hVO != null) {
            this.hVO.U(false, false);
        }
    }

    public void cmZ() {
        if (this.dBK && this.hVO != null) {
            this.hVO.U(false, false);
        }
        wZ(8);
        this.hVx.setVisibility(8);
        this.hVw.setVisibility(8);
        om(false);
        this.hVD.setVisibility(8);
        this.hVY.setVisibility(8);
    }

    public void cna() {
        if (this.dBK && this.hVO != null) {
            this.hVO.U(true, false);
        }
        wZ(0);
        cnb();
        om(this.hVq.cmG());
        this.hVD.setVisibility(0);
        this.hVY.setVisibility(0);
    }

    private void wZ(int i) {
        if (this.hVv != null) {
            this.hVv.setVisibility(i);
        }
    }

    private void cnb() {
        this.hVx.setVisibility(0);
        this.hVw.setVisibility(0);
    }

    public void oo(boolean z) {
        if (this.hVO != null) {
            this.hVO.oQ(z);
        }
    }

    private void cnc() {
        if (this.hVQ == null) {
            View rootView = this.hVq.getRootView();
            this.hVQ = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.hVR = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.hVR.setPageId(this.hVq.getUniqueId());
            this.hVQ.setLayerType(1, null);
            this.hVR.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cnd() {
        return this.hVu;
    }

    public void g(NoNetworkView.a aVar) {
        this.hQf = aVar;
        if (this.fCq != null) {
            this.fCq.a(this.hQf);
        }
    }

    public void op(boolean z) {
        if (this.hVO != null) {
            if (z) {
                U(false, true);
            } else {
                U(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hVD.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.hVE.a(abVar);
    }

    public void setForumName(String str) {
        this.hVE.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hDQ);
        if (this.hBR != null) {
            this.hBR.destroy();
        }
        if (this.hVP != null) {
            this.hVP.onDestory();
        }
        if (this.hWe != null) {
            this.hWe.setPageContext(null);
        }
        if (this.hWf != null) {
            this.hWf.setPageContext(null);
        }
        this.hVE.onDestory();
        this.hVD.setOnSrollToBottomListener(null);
        this.hVD.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.hWm);
        if (this.hCM != null) {
            this.hCM.onDestroy();
        }
        this.hVS.clear();
        if (this.hVN != null) {
            this.hVN.ctd();
        }
        if (this.hVW != null) {
            this.hVW.coV();
        }
        if (this.hWg != null) {
            this.hWg.onDestroy();
        }
        if (this.hWe != null) {
            this.hWe.onDestroy();
        }
        if (this.hVF != null) {
            this.hVF.onDestroy();
        }
    }

    public boolean cne() {
        if (this.Xx == null || this.hVX == null || !this.hVX.isSticky()) {
            return this.hVN != null && this.hVN.cne();
        }
        if (this.hVD != null) {
            this.hVD.setSelection(0);
        }
        this.hVX.expandedAppBarLayout(this.Xx);
        return true;
    }

    public boolean cmy() {
        if (this.hVF == null) {
            return false;
        }
        return this.hVF.cmy();
    }

    public void bLt() {
        this.hVD.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.hWi.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.hWi.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.hWi.setText(str2);
            com.baidu.tbadk.core.k.bbM().setForumNameForWaterImage(str);
        }
    }

    public void cnf() {
        if (this.hVE != null) {
            this.hVE.notifyDataSetChanged();
        }
    }

    public void aSD() {
        if (this.hVE instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.hVE).aSD();
        }
    }

    private void cng() {
        if (this.hVG == null && this.hVq.getPageContext() != null) {
            String[] strArr = {this.hVq.getPageContext().getPageActivity().getString(R.string.take_photo), this.hVq.getPageContext().getPageActivity().getString(R.string.album)};
            this.hVG = new com.baidu.tbadk.core.dialog.b(this.hVq.getPageContext().getPageActivity());
            this.hVG.zB(this.hVq.getPageContext().getPageActivity().getString(R.string.operation));
            this.hVG.a(strArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.hVq.cmz();
                    } else if (i == 1 && q.this.hVq.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.hVq.getPageContext().getPageActivity());
                    }
                }
            });
            this.hVG.d(this.hVq.getPageContext());
        }
    }

    public void cnh() {
        cng();
        if (this.hVG != null) {
            this.hVG.bhi();
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
                if (this.hVq != null && this.hVq.clO() != null && this.hVq.clO().crQ() == 0) {
                    sVar.xl(this.hVq.clO().crX());
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
                        ((bv) qVar).dUW.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.hVE.b(arrayList2, frsViewData);
            if (this.hBR != null && this.hVc != 0) {
                this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
            }
            if (this.hVq != null) {
                this.hVq.cmJ();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.hVD;
    }

    public void cni() {
        this.hVE.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hVq.getPageContext(), 1);
        aVar.a(this.hVD);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.hVq.getForumName());
        hashMap.put("forum_id", this.hVq.getForumId());
        aVar.setParams(hashMap);
        aVar.aw(adVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.hVN != null) {
            this.hVN.cte();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        xa(TbadkCoreApplication.getInst().getSkinType());
        if (this.hVN != null) {
            this.hVN.ctf();
        }
    }

    public void release() {
        if (this.fCq != null && this.hQf != null) {
            this.fCq.b(this.hQf);
        }
    }

    public ImageView cnj() {
        return this.hVx;
    }

    public ImageView cnk() {
        return this.hVw;
    }

    public TextView cnl() {
        return this.hVy;
    }

    public View cnm() {
        if (this.hVv != null) {
            return this.hVv.getView();
        }
        return null;
    }

    public void N(int i, boolean z) {
        if (this.hVv != null) {
            this.hVv.x(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.hVq, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hVq.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.hVR != null) {
            this.hVR.invalidate();
        }
        if (this.hVE != null) {
            this.hVE.cpN();
            this.hVE.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.hVq.getPageContext(), this.hVr);
        if (this.fCq != null) {
            this.fCq.onChangeSkinType(this.hVq.getPageContext(), i);
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
            this.fEa.changeSkin(i);
        }
        if (this.hWi != null) {
            this.hWi.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
        xa(i);
        if (this.hVO != null) {
            this.hVO.onChangeSkinType(i);
        }
        if (this.hVN != null) {
            this.hVN.onChangeSkinType(i);
        }
        if (this.hWe != null) {
            this.hWe.onChangeSkinType();
        }
        if (this.hWf != null) {
            this.hWf.onChangeSkinType();
        }
        if (this.hVq != null && this.hVq.clY()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.hVt, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.hVt, R.color.cp_bg_line_d);
        }
    }

    private void xa(int i) {
        if (this.hVq != null) {
            xb(i);
        }
    }

    private void xb(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hVq.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.hVI, R.color.cp_bg_line_c, i);
            if (this.hVv != null) {
                this.hVv.onChangeSkinType(i);
            }
            if (this.hVx != null) {
                SvgManager.bjq().a(this.hVx, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hVw != null) {
                SvgManager.bjq().a(this.hVw, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.boF, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.hVT, R.color.cp_bg_line_h);
        oq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.ggX) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.hWj != 0) {
                    SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(this.hVx, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(this.hpC, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bjq().a(this.hVw, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.hWj = 0;
                }
            } else if (z || this.hWj != 1) {
                SvgManager.bjq().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.hVx, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.hpC, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bjq().a(this.hVw, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.hWj = 1;
            }
            cnn();
        }
    }

    private void cnn() {
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
            if (this.hWi != null) {
                this.hWi.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.hpC != null) {
                    this.hpC.setAlpha(f);
                }
                if (this.hpD != null) {
                    this.hpD.setAlpha(f);
                }
                if (this.hVx != null) {
                    this.hVx.setAlpha(f);
                }
                if (this.hVw != null) {
                    this.hVw.setAlpha(f);
                }
            }
            if (this.hVy != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.hVy.setAlpha(f2);
                this.hVy.setClickable(f2 > 0.0f);
            }
            if (this.boF != null) {
                this.boF.setAlpha(alpha);
            }
            if (this.hVT != null) {
                this.hVT.setAlpha(alpha);
            }
            if (this.hVI != null) {
                this.hVI.setAlpha(alpha);
            }
        }
    }

    public void bGe() {
        if (this.hVF != null) {
            this.hVF.bGe();
        }
    }

    public void or(boolean z) {
        if (this.hVF != null) {
            this.hVF.or(z);
        }
    }

    public void os(boolean z) {
        this.hVK = z;
        if (this.hVK) {
            this.fEa.setText(this.hVq.getResources().getString(R.string.load_more));
            if (this.hVD.getChildAt(this.hVD.getChildCount() - 1) == this.fEa.getView()) {
                this.fEa.startLoadData();
                this.hVq.bFE();
                return;
            }
            this.fEa.endLoadData();
            return;
        }
        this.fEa.setText(this.hVq.getResources().getString(R.string.load_more_must_after_delete));
        this.fEa.endLoadData();
    }

    public boolean cno() {
        if (this.hVK) {
            return false;
        }
        this.fEa.setText(this.hVq.getResources().getString(R.string.load_more_must_after_delete));
        this.fEa.endLoadData();
        return true;
    }

    public boolean cnp() {
        return this.hVz != null && this.hVC.getVisibility() == 0;
    }

    public void cnq() {
        if (this.hVz != null) {
            this.hVA.setVisibility(0);
            this.hVC.setVisibility(8);
            this.hVB.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.hWm, 5000L);
        }
    }

    public void a(cg cgVar) {
        if (this.hVz == null) {
            View rootView = this.hVq.getRootView();
            this.hVz = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.hVz.setVisibility(0);
            this.hVA = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.hVB = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.hVC = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.hVB.setPageId(this.hVq.getUniqueId());
            this.hVC.setPageId(this.hVq.getUniqueId());
            this.hVB.setDefaultBgResource(R.color.common_color_10022);
            this.hVB.setDefaultResource(0);
            this.hVC.setDefaultBgResource(R.color.common_color_10022);
            this.hVC.setDefaultResource(0);
            this.hVA.setOnClickListener(this.hVH);
        }
        this.hVA.setVisibility(0);
        String bgV = cgVar.bgV();
        String bgW = cgVar.bgW();
        this.hVB.startLoad(bgV, 10, false);
        this.hVC.startLoad(bgW, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.hWm, 5000L);
    }

    public void cnr() {
        if (this.hVz != null && this.hVA != null) {
            this.hVA.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al cns() {
        return this.hVE;
    }

    public RelativeLayout bZc() {
        return this.hVr;
    }

    public View cnt() {
        return this.hVJ;
    }

    public void xc(int i) {
        if (this.hVt != null) {
            this.hVt.setVisibility(i);
        }
    }

    public void cnu() {
        if (com.baidu.tbadk.n.m.buo().bup()) {
            int lastVisiblePosition = this.hVD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hVD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.hWA != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.hWA.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eRM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.hWA.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.hWA.startLogPerf();
                    }
                    if (uVar.hWz != null && (uVar.hWz instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.hWz;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eRM = true;
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

    public NavigationBar bJI() {
        return this.mNavigationBar;
    }

    public void bGS() {
        this.mHasMore = true;
        this.hVD.setNextPage(this.fEa);
        if (this.hVL > 0) {
            this.fEa.showEmptyView(this.hVL);
        }
        this.fEa.setOnClickListener(null);
        this.fEa.startLoadData();
    }

    public void bGT() {
        this.mHasMore = false;
        this.hVD.setNextPage(this.fEa);
        if (this.hVL > 0) {
            this.fEa.showEmptyView(this.hVL);
        }
        this.fEa.setOnClickListener(null);
        this.fEa.endLoadData();
        this.fEa.setText(this.hVq.getResources().getString(R.string.list_has_no_more));
    }

    public void cnv() {
        this.mHasMore = true;
        this.hVD.setNextPage(this.fEa);
        this.fEa.setOnClickListener(this.hVH);
        if (this.hVL > 0) {
            this.fEa.showEmptyView(this.hVL);
        }
        this.fEa.endLoadData();
        this.fEa.setText(this.hVq.getResources().getString(R.string.list_click_load_more));
    }

    public View cnw() {
        if (this.fEa == null) {
            return null;
        }
        return this.fEa.getView();
    }

    public void xd(int i) {
        if (this.hWe != null) {
            this.hWe.setVisibility(i);
        }
    }

    public void xe(int i) {
        if (this.hWe != null) {
            this.hWe.setSelectNumber(i);
        }
    }

    public void xf(int i) {
        if (this.hWf != null) {
            this.hWf.setVisibility(i);
        }
    }

    public void xg(int i) {
        if (this.hWf != null) {
            this.hWf.setMoveNumber(i);
        }
    }

    public boolean cnx() {
        return this.hWf != null && this.hWf.cuI();
    }

    public void cny() {
        if (this.hWf != null) {
            this.hWf.cuJ();
        }
    }

    public void bGU() {
        this.mHasMore = false;
        this.hVD.setNextPage(null);
    }

    public boolean cnz() {
        return this.fEa.getView().getParent() != null && this.mHasMore;
    }

    public void xh(int i) {
        this.hVL = i;
    }

    public void xi(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.hCM == null) {
                    this.hCM = new CommonTipView(this.hVq.getActivity());
                }
                this.hCM.setText(R.string.frs_login_tip);
                this.hCM.b((FrameLayout) cnt(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void ot(boolean z) {
        this.mIsBackground = z;
        if (this.hBR != null) {
            boolean z2 = (this.hVq == null || this.hVq.clR() == null || this.hVq.clR().ctU() == null) ? true : this.hVq.clR().ctU().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.hBR.rH(false);
                this.hBR.cNe();
                return;
            }
            this.hBR.rH(true);
            this.hBR.a(this.hVc, this.fCJ, this.hVM, true);
        }
    }

    public void cg(int i, int i2) {
        if (this.hBR != null) {
            this.hBR.a(i, i2, this.hVM, 1);
        }
    }

    public void ch(int i, int i2) {
        this.hVc = i;
        this.fCJ = i2;
    }

    public void ou(boolean z) {
        this.hVM = z;
    }

    public void xj(int i) {
        if (this.hVD != null && this.hVD.getChildCount() >= 0) {
            if (this.hVD.getFirstVisiblePosition() > 8) {
                this.hVD.scrollToPosition(8);
            }
            this.hVD.smoothScrollToPosition(i);
        }
    }

    public void cnA() {
        a(this.hVV, this.hVq.cmA());
        if (this.hVE != null) {
            this.hVE.cpK();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.hVW == null) {
                this.hVW = new com.baidu.tieba.video.f(this.hVq.getActivity(), this.hVr);
            }
            this.hVW.i(postWriteCallBackData);
        }
    }

    public void cnB() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.hWn && this.hVq.getActivity() != null && this.hVq.getPageContext() != null) {
            View view = null;
            if (this.hVD != null && (headerViewsCount = this.hVD.getHeaderViewsCount()) < this.hVD.getChildCount()) {
                view = this.hVD.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aj(0).ag(true).ah(false).af(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.hVq.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.hVq.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.hVq.getActivity(), R.dimen.ds6);
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
                md.show(this.hVq.getActivity());
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (md != null) {
                            md.dismiss();
                        }
                    }
                }, 4000L);
                this.hWn = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.hWe != null) {
            this.hWe.setDeleteCallback(aVar);
        }
    }

    public void cnC() {
        if (this.hWe != null) {
            this.hWe.cnC();
        }
    }

    public void bAj() {
        if (this.hWe != null) {
            this.hWe.bAj();
        }
    }

    public void aL(String str, int i) {
        if (this.hWh == null) {
            this.hWh = new TextView(this.hVq.getActivity());
            this.hWh.setGravity(19);
            this.hWh.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hVq.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.hVq.getActivity(), R.dimen.ds34), 0);
            this.hWh.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hVq.getActivity(), R.dimen.tbds112)));
            this.hWh.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hVq.getActivity(), R.dimen.fontsize30));
            this.hWh.setMaxLines(2);
            this.hWh.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.hWh.setTextColor(ContextCompat.getColor(this.hVq.getActivity(), R.color.cp_cont_a));
        }
        this.hWg.setBackgroundColor(i);
        this.hWh.setText(str);
        this.hWg.a(this.hVq.getActivity(), this.hWh, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Xx != null) {
            this.Xx.setExpanded(z);
        }
    }

    public void cnD() {
        if (this.hVF != null) {
            this.hVF.startPullRefresh();
        }
    }

    public void EF() {
        if (cns() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = cns().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.eaT != 0 && bvVar.dUW != null && this.hVq.clO() != null && this.hVq.clO().crt() != null) {
                            int[] imageWidthAndHeight = bvVar.dUW.getImageWidthAndHeight();
                            bvVar.eaT = imageWidthAndHeight[0];
                            bvVar.eaU = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cns().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.hBR.a(q.this.hVc, q.this.fCJ, q.this.hVM, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cnE() {
        if (this.hVN == null) {
            return false;
        }
        return this.hVN.cnE();
    }

    public Context getContext() {
        if (this.hVq == null) {
            return null;
        }
        return this.hVq.getTbPageContext().getPageActivity();
    }

    public void O(int i, boolean z) {
        if (this.hVF != null) {
            this.hVF.O(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.hVF != null) {
            this.hVF.startPullRefresh();
        }
    }

    public void cnF() {
        if (this.hVF != null) {
            this.hVF.cnF();
        }
    }

    public void cnG() {
        if (this.hVF != null) {
            this.hVF.cnG();
        }
    }

    public void a(au auVar) {
        if (this.hVF != null) {
            this.hVF.a(auVar);
        }
    }

    public void xk(int i) {
        if (this.hVF != null) {
            this.hVF.xk(i);
        }
    }
}
