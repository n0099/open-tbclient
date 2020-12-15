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
import android.util.Log;
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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.ci;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.NEGFeedBack.e;
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
    private AppBarLayout Zj;
    private NoNetworkView gpw;
    private PbListView grg;
    private com.baidu.tieba.play.i iBV;
    private CommonTipView iCQ;
    private com.baidu.adp.widget.ListView.n iDS;
    private TextView iVA;
    private ViewStub iVB;
    private BdTypeRecyclerView iVF;
    private com.baidu.tieba.frs.entelechy.a.am iVG;
    private com.baidu.tieba.frs.vc.k iVH;
    private View.OnClickListener iVJ;
    private View iVK;
    private View iVL;
    private int iVN;
    private com.baidu.tieba.frs.vc.d iVP;
    private com.baidu.tieba.frs.entelechy.b.c iVQ;
    private com.baidu.tieba.frs.vc.m iVR;
    private GifView iVS;
    private TbImageView iVT;
    private HashSet<String> iVU;
    private ObservedChangeLinearLayout iVW;
    private com.baidu.tieba.frs.entelechy.b.a iVX;
    private com.baidu.tieba.video.f iVY;
    private AppBarLayoutStickyBehavior iVZ;
    private FrsFragment iVs;
    private View iVw;
    private com.baidu.tieba.d.d iVx;
    private ImageView iVy;
    private ImageView iVz;
    private FrsHeaderViewContainer iWa;
    private CollapsingToolbarLayout iWb;
    private com.baidu.tieba.frs.vc.h iWf;
    private FrsMultiDelBottomMenuView iWg;
    private FrsMoveAreaBottomMenuView iWh;
    private NavigationBarCoverTip iWi;
    private TextView iWj;
    private TextView iWk;
    private boolean iWp;
    private ImageView ipK;
    private MessageRedDotView ipL;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout iVt = null;
    private CoordinatorLayout iVu = null;
    private View iVv = null;
    private FrameLayout iVC = null;
    private TbImageView iVD = null;
    private TbImageView iVE = null;
    private com.baidu.tbadk.core.dialog.b iVI = null;
    private NoNetworkView.a iQh = null;
    private boolean iVM = true;
    private boolean mHasMore = true;
    private boolean iVO = false;
    private int iVe = 0;
    private int gpP = 0;
    private View bHy = null;
    private View iVV = null;
    private boolean gYX = false;
    private boolean ejt = true;
    private boolean iWc = true;
    private int iWd = -1;
    private int iWe = -1;
    private int iWl = 0;
    private int iWm = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener iDU = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.iDS == null) {
                        q.this.iDS = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.iDS.a(q.this.iVF, 2);
                } else if (q.this.iDS != null) {
                    q.this.iDS.rj();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iWn = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.iVH != null) {
                q.this.iVH.setInterceptScrollDown(i == 0);
            }
            if (q.this.iWe != i && Math.abs(i) >= 0 && q.this.cDi() != -1) {
                if (Math.abs(i) >= q.this.cDi()) {
                    if (q.this.iWc) {
                        q.this.iWc = false;
                        q.this.pX(q.this.iWc);
                    }
                } else if (!q.this.iWc) {
                    q.this.iWc = true;
                    q.this.pX(q.this.iWc);
                }
                int cDe = q.this.cDe() + q.this.cDd() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cDe;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.iWe - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.zM(Math.abs(cDe - totalScrollRange2));
                        if (q.this.iVV != null) {
                            q.this.iVV.setVisibility(0);
                        }
                    } else if (q.this.iVV != null) {
                        if (q.this.cDc() != UtilHelper.getStatusBarHeight()) {
                            q.this.zM(0);
                        }
                        q.this.iVV.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.gYX) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.qc(false);
                        } else if (q.this.iWk != null) {
                            q.this.iWk.setAlpha(abs);
                        }
                    }
                    q.this.iWe = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.iVH != null) {
                int cLa = q.this.iVH.cLa();
                int cLb = cLa - q.this.iVH.cLb();
                if (cLa > 0 && Math.abs(i) >= cLb) {
                    q.this.iVH.dismissLoading();
                }
            }
        }
    };
    private Runnable iWo = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.iVB != null) {
                q.this.iVC.setVisibility(0);
                q.this.iVE.setVisibility(0);
                q.this.iVD.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.iVs != null && appBarLayout != null && this.iVs.cCd() != null && this.iVs.getPageContext() != null) {
            int cDd = cDd() + getNavigationBarHeight() + cDe();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cCd = this.iVs.cCd();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.iVs.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.iVs.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.iVv.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.iVs != null && this.iVs.cCk();
            if (totalScrollRange <= 0) {
                if (this.iWm != 2) {
                    cCd.BT(2);
                }
                this.iWm = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cDd) {
                if (this.iWm != 1) {
                    cCd.BT(1);
                }
                this.iWm = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.iWm != 0) {
                    cCd.BT(0);
                }
                this.iWm = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.iVs.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.iVv.setLayoutParams(marginLayoutParams);
            }
            Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i + "]");
        }
    }

    public ObservedChangeLinearLayout cDa() {
        return this.iVW;
    }

    public View Vv() {
        return this.bHy;
    }

    public View cDb() {
        return this.iVV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDc() {
        if (this.bHy == null) {
            return 0;
        }
        return this.bHy.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDd() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDe() {
        if (this.gpw == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gpw.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(int i) {
        View Vv = Vv();
        View cDb = cDb();
        if (UtilHelper.canUseStyleImmersiveSticky() && Vv != null && cDb != null && Vv.getLayoutParams() != null && cDb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Vv.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Vv.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cDb.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cDb.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.iVs = null;
        this.iVJ = null;
        this.iVN = 0;
        this.iVs = frsFragment;
        this.iVJ = onClickListener;
        MessageManager.getInstance().registerListener(this.iDU);
        a(aVar, z);
        this.iVU = new HashSet<>();
        this.iVN = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iWf = hVar;
    }

    private boolean cDf() {
        return this.iWf != null && this.iWf.cKI();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.iVX = aVar;
        View rootView = this.iVs.getRootView();
        if (this.iVt == null) {
            this.iVt = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.iVv == null) {
            this.iVv = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.iVu == null) {
            this.iVu = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.iVL == null) {
            this.iVL = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.iWb == null) {
            this.iWb = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.iWa == null) {
            this.iWa = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.iVH == null) {
            this.iVH = new com.baidu.tieba.frs.vc.k(this.iVs);
        }
        if (this.iVW == null) {
            this.iVW = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.iVW.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.iWb.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) rootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            this.mNavigationBar.setContentPaddingTop(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24));
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.iVs.cCN()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.iVK == null) {
            this.iVK = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b cFA = aVar.cFA();
            if (cFA != null) {
                cFA.cN(this.iVK);
            }
        }
        if (this.iVw == null) {
            this.iVw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iVw.setOnClickListener(this.iVJ);
            this.mBackImageView = (ImageView) this.iVw.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iVz == null) {
            this.iVz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.btW().a(this.iVz, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iVz.setOnClickListener(this.iVJ);
        }
        if (this.iVx == null) {
            this.iVx = new com.baidu.tieba.d.d(this.iVs.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iVx.getView(), (View.OnClickListener) null);
            this.ipK = this.iVx.ctj();
            this.ipL = this.iVx.ctk();
            this.ipL.setShadowEnabled(false);
            this.iVx.getView().setOnClickListener(this.iVJ);
            this.iVx.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.iVy == null) {
            this.iVy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.btW().a(this.iVy, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iVy.setOnClickListener(this.iVJ);
        }
        if (this.iVA == null) {
            this.iVA = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.iVA.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.iVs.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iVA.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.f(this.iVA, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iVA, R.color.CAM_X0101);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.iVs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.iVF == null) {
            this.iVF = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int iWs = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.iWs--;
                if (this.iWs == 0) {
                    q.this.iVF.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.iWs++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.iVF.setItemAnimator(defaultItemAnimator);
        this.iVF.setLayoutManager(new LinearLayoutManager(this.iVF.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iDS = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.iDS.a(this.iVF, 2);
        }
        this.iVF.setScrollable(this.iVs);
        this.iVF.setFadingEdgeLength(0);
        this.iVF.setOverScrollMode(2);
        this.iVt.setBottomOrderView(this.iVF);
        this.iVF.setOnTouchListener(this.iVs.fGd);
        this.iVF.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iBV != null) {
                    q.this.iBV.dl(view);
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
        if (!com.baidu.tbadk.a.d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.iVF.setPadding(dimenPixelSize, this.iVF.getPaddingTop(), dimenPixelSize, this.iVF.getPaddingBottom());
        }
        if (this.grg == null) {
            this.grg = new PbListView(this.iVs.getPageContext().getPageActivity());
            this.grg.getView();
        }
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iVs.getActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iVF.setOnSrollToBottomListener(this.iVs);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.iVs.cCG();
                if (q.this.iVs != null && q.this.Zj != null) {
                    q.this.iVs.cCQ();
                    q.this.Zj.setExpanded(true);
                    if (q.this.iBV != null) {
                        q.this.iBV.a(q.this.iVe, q.this.gpP, false, true);
                    }
                }
            }
        });
        boolean btY = com.baidu.tbadk.core.util.av.btX().btY();
        if (this.iVG == null) {
            this.iVG = aVar.a(this.iVs, this.iVF, btY);
        }
        if (this.iVH != null) {
            this.iVH.Q(1, false);
        }
        if (!z) {
            if (this.gpw == null) {
                this.gpw = new NoNetworkView(this.iVs.getActivity());
                this.gpw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.iVW.addView(this.gpw);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gpw.setVisibility(8);
            } else {
                this.gpw.setVisibility(0);
            }
            this.gpw.onChangeSkinType(this.iVs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cDp();
        if (this.iVP == null) {
            this.iVP = aVar.a(this.iVs, this.iVt);
            this.iVP.b(this.iVs.cCR());
        }
        if (this.iVQ == null) {
            this.iVQ = aVar.b(this.iVs, this.iVt);
            qa(true);
        }
        if (this.bHy == null) {
            this.bHy = rootView.findViewById(R.id.statebar_view);
        }
        if (this.iVV == null) {
            this.iVV = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iBV == null) {
            this.iBV = new com.baidu.tieba.play.i(this.iVs.getPageContext(), this.iVF);
        }
        this.iBV.IJ(1);
        this.iBV.setUniqueId(this.iVs.getUniqueId());
        this.iWi = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.iVR == null) {
            this.iVR = new com.baidu.tieba.frs.vc.m(this.iVs, this.iWi);
        }
        if (this.Zj == null) {
            this.Zj = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Zj.addOnOffsetChangedListener(this.iWn);
            this.iWc = true;
            this.iWd = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Zj.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.iVZ = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.iWg = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.iWg.setPageContext(this.iVs.getPageContext());
        this.iWh = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.iWh.setPageContext(this.iVs.getPageContext());
        if (this.iWk == null) {
            this.iWk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.iVs.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.iWk.setLayoutParams(layoutParams2);
            this.iWk.setPadding(0, 0, this.iVs.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.iWk.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
    }

    public void cb(boolean z) {
        if (z) {
        }
    }

    private void cDg() {
        ViewGroup.LayoutParams layoutParams;
        this.gYX = cDf();
        if (this.iWa != null && (layoutParams = this.iWa.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.gYX) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cDd(), 0, 0);
            }
            this.iWa.requestLayout();
        }
    }

    public void cDh() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.iVW != null) {
            cDg();
            if (this.gYX) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bHy != null) {
                    this.bHy.setAlpha(1.0f);
                }
                if (this.iVV != null) {
                    this.iVV.setAlpha(1.0f);
                }
                if (this.iWk != null) {
                    this.iWk.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(boolean z) {
        if (z && this.iVs != null && this.iVs.cCc() != null) {
            this.iVs.cCc().cKP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDi() {
        int i;
        if (this.Zj == null) {
            return this.iWd;
        }
        if (this.iWd != -1) {
            return this.iWd;
        }
        int childCount = this.Zj.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Zj.getChildAt(childCount);
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
        this.iWd = Math.max(0, this.Zj.getTotalScrollRange() - Math.abs(i2));
        return this.iWd;
    }

    public void KJ(String str) {
        if (this.iVR != null) {
            this.iVR.KJ(str);
        }
    }

    public com.baidu.tieba.play.i cDj() {
        return this.iBV;
    }

    public com.baidu.tieba.frs.entelechy.b.c cDk() {
        return this.iVQ;
    }

    public void pY(boolean z) {
        if (this.iVP != null) {
            if (com.baidu.tbadk.k.d.bDH().bDI()) {
                this.iVP.pY(false);
            } else {
                this.iVP.pY(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cDl() {
        return this.iVP;
    }

    public void Y(boolean z, boolean z2) {
        if (this.ejt && this.iVQ != null) {
            this.iVQ.Y(z, z2);
        }
    }

    public void pZ(boolean z) {
        this.ejt = z;
        if (!this.ejt && this.iVQ != null) {
            this.iVQ.Y(false, false);
        }
    }

    public void cDm() {
        if (this.ejt && this.iVQ != null) {
            this.iVQ.Y(false, false);
        }
        zN(8);
        this.iVz.setVisibility(8);
        this.iVy.setVisibility(8);
        pY(false);
        this.iVF.setVisibility(8);
        this.iWa.setVisibility(8);
    }

    public void cDn() {
        if (this.ejt && this.iVQ != null) {
            this.iVQ.Y(true, false);
        }
        zN(0);
        cDo();
        pY(this.iVs.cCT());
        this.iVF.setVisibility(0);
        this.iWa.setVisibility(0);
    }

    private void zN(int i) {
        if (this.iVx != null) {
            this.iVx.setVisibility(i);
        }
    }

    private void cDo() {
        this.iVz.setVisibility(0);
        this.iVy.setVisibility(0);
    }

    public void qa(boolean z) {
        if (this.iVQ != null) {
            this.iVQ.qC(z);
        }
    }

    private void cDp() {
        if (this.iVS == null) {
            View rootView = this.iVs.getRootView();
            this.iVS = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.iVT = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.iVT.setPageId(this.iVs.getUniqueId());
            this.iVS.setLayerType(1, null);
            this.iVT.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cDq() {
        return this.iVw;
    }

    public void g(NoNetworkView.a aVar) {
        this.iQh = aVar;
        if (this.gpw != null) {
            this.gpw.a(this.iQh);
        }
    }

    public void qb(boolean z) {
        if (this.iVQ != null) {
            if (z) {
                Y(false, true);
            } else {
                Y(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iVF.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.iVG.a(abVar);
    }

    public void setForumName(String str) {
        this.iVG.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iDU);
        if (this.iBV != null) {
            this.iBV.destroy();
        }
        if (this.iVR != null) {
            this.iVR.onDestory();
        }
        if (this.iWg != null) {
            this.iWg.setPageContext(null);
        }
        if (this.iWh != null) {
            this.iWh.setPageContext(null);
        }
        this.iVG.onDestory();
        this.iVF.setOnSrollToBottomListener(null);
        this.iVF.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.iWo);
        if (this.iCQ != null) {
            this.iCQ.onDestroy();
        }
        this.iVU.clear();
        if (this.iVP != null) {
            this.iVP.cKu();
        }
        if (this.iVY != null) {
            this.iVY.cFh();
        }
        if (this.iWi != null) {
            this.iWi.onDestroy();
        }
        if (this.iWg != null) {
            this.iWg.onDestroy();
        }
        if (this.iVH != null) {
            this.iVH.onDestroy();
        }
    }

    public boolean cDr() {
        if (this.Zj == null || this.iVZ == null || !this.iVZ.isSticky()) {
            return this.iVP != null && this.iVP.cDr();
        }
        if (this.iVF != null) {
            this.iVF.setSelection(0);
        }
        this.iVZ.expandedAppBarLayout(this.Zj);
        return true;
    }

    public boolean cCL() {
        if (this.iVH == null) {
            return false;
        }
        return this.iVH.cCL();
    }

    public void bYt() {
        this.iVF.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.iWk.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.iWk.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.iWk.setText(str2);
            com.baidu.tbadk.core.k.blV().setForumNameForWaterImage(str);
        }
    }

    public void cDs() {
        if (this.iVG != null) {
            this.iVG.notifyDataSetChanged();
        }
    }

    public void bcP() {
        if (this.iVG instanceof com.baidu.tieba.frs.entelechy.a.t) {
            ((com.baidu.tieba.frs.entelechy.a.t) this.iVG).bcP();
        }
    }

    private void cDt() {
        if (this.iVI == null && this.iVs.getPageContext() != null) {
            String[] strArr = {this.iVs.getPageContext().getPageActivity().getString(R.string.take_photo), this.iVs.getPageContext().getPageActivity().getString(R.string.album)};
            this.iVI = new com.baidu.tbadk.core.dialog.b(this.iVs.getPageContext().getPageActivity());
            this.iVI.Br(this.iVs.getPageContext().getPageActivity().getString(R.string.operation));
            this.iVI.a(strArr, new b.InterfaceC0586b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.iVs.cCM();
                    } else if (i == 1 && q.this.iVs.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.iVs.getPageContext().getPageActivity());
                    }
                }
            });
            this.iVI.d(this.iVs.getPageContext());
        }
    }

    public void cDu() {
        cDt();
        if (this.iVI != null) {
            this.iVI.brx();
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
                if (this.iVs != null && this.iVs.cCa() != null && this.iVs.cCa().cJc() == 0) {
                    sVar.zZ(this.iVs.cCa().cJj());
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
                    if (qVar instanceof bx) {
                        ((bx) qVar).eCR.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.iVG.b(arrayList2, frsViewData);
            if (this.iBV != null && this.iVe != 0) {
                this.iBV.a(this.iVe, this.gpP, this.iVO, true);
            }
            if (this.iVs != null) {
                this.iVs.cCW();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.iVF;
    }

    public void cDv() {
        this.iVG.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ae aeVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iVs.getPageContext(), 1);
        aVar.a(this.iVF);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.iVs.getForumName());
        hashMap.put("forum_id", this.iVs.getForumId());
        aVar.setParams(hashMap);
        aVar.aB(aeVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.iVP != null) {
            this.iVP.cKv();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        zO(TbadkCoreApplication.getInst().getSkinType());
        if (this.iVP != null) {
            this.iVP.cKw();
        }
    }

    public void release() {
        if (this.gpw != null && this.iQh != null) {
            this.gpw.b(this.iQh);
        }
    }

    public ImageView cDw() {
        return this.iVz;
    }

    public ImageView cDx() {
        return this.iVy;
    }

    public TextView cDy() {
        return this.iVA;
    }

    public View cDz() {
        if (this.iVx != null) {
            return this.iVx.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.iVx != null) {
            this.iVx.A(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.iVs, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iVs.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.iVT != null) {
            this.iVT.invalidate();
        }
        if (this.iVG != null) {
            this.iVG.cGc();
            this.iVG.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.iVs.getPageContext(), this.iVt);
        if (this.gpw != null) {
            this.gpw.onChangeSkinType(this.iVs.getPageContext(), i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
            this.grg.changeSkin(i);
        }
        if (this.iWk != null) {
            this.iWk.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
        zO(i);
        if (this.iVQ != null) {
            this.iVQ.onChangeSkinType(i);
        }
        if (this.iVP != null) {
            this.iVP.onChangeSkinType(i);
        }
        if (this.iWg != null) {
            this.iWg.onChangeSkinType();
        }
        if (this.iWh != null) {
            this.iWh.onChangeSkinType();
        }
        if (!com.baidu.tbadk.a.d.bkA()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVv, R.color.CAM_X0202);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVv, R.color.CAM_X0204);
        }
    }

    private void zO(int i) {
        if (this.iVs != null) {
            zP(i);
        }
    }

    private void zP(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iVs.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVK, R.color.CAM_X0204, i);
            if (this.iVx != null) {
                this.iVx.onChangeSkinType(i);
            }
            if (this.iVz != null) {
                SvgManager.btW().a(this.iVz, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iVy != null) {
                SvgManager.btW().a(this.iVy, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (com.baidu.tbadk.a.d.bkA()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bHy, R.color.CAM_X0208);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVV, R.color.CAM_X0208);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bHy, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVV, R.color.CAM_X0207);
        }
        qc(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gYX) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.iWl != 0) {
                    SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.btW().a(this.iVz, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.ipK.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
                    SvgManager.btW().a(this.iVy, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iWl = 0;
                }
            } else if (z || this.iWl != 1) {
                SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.btW().a(this.iVz, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.ipK.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0106), (WebPManager.ResourceStateType) null));
                SvgManager.btW().a(this.iVy, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iWl = 1;
            }
            cDA();
        }
    }

    private void cDA() {
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
            if (this.iWk != null) {
                this.iWk.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.ipK != null) {
                    this.ipK.setAlpha(f);
                }
                if (this.iVs != null && this.iVs.cCd() != null && this.iWl == 1) {
                    this.iVs.cCd().aF(f);
                }
                if (this.ipL != null) {
                    this.ipL.setAlpha(f);
                }
                if (this.iVz != null) {
                    this.iVz.setAlpha(f);
                }
                if (this.iVy != null) {
                    this.iVy.setAlpha(f);
                }
            }
            if (this.iVA != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.iVA.setAlpha(f2);
                this.iVA.setClickable(f2 > 0.0f);
            }
            if (this.bHy != null) {
                this.bHy.setAlpha(alpha);
            }
            if (this.iVV != null) {
                this.iVV.setAlpha(alpha);
            }
            if (this.iVK != null) {
                this.iVK.setAlpha(alpha);
            }
        }
    }

    public void bSm() {
        if (this.iVH != null) {
            this.iVH.bSm();
        }
    }

    public void qd(boolean z) {
        if (this.iVH != null) {
            this.iVH.qd(z);
        }
    }

    public void qe(boolean z) {
        this.iVM = z;
        if (this.iVM) {
            this.grg.setText(this.iVs.getResources().getString(R.string.load_more));
            if (this.iVF.getChildAt(this.iVF.getChildCount() - 1) == this.grg.getView()) {
                this.grg.startLoadData();
                this.iVs.bRN();
                return;
            }
            this.grg.endLoadData();
            return;
        }
        this.grg.setText(this.iVs.getResources().getString(R.string.load_more_must_after_delete));
        this.grg.endLoadData();
    }

    public boolean cDB() {
        if (this.iVM) {
            return false;
        }
        this.grg.setText(this.iVs.getResources().getString(R.string.load_more_must_after_delete));
        this.grg.endLoadData();
        return true;
    }

    public boolean cDC() {
        return this.iVB != null && this.iVE.getVisibility() == 0;
    }

    public void cDD() {
        if (this.iVB != null) {
            this.iVC.setVisibility(0);
            this.iVE.setVisibility(8);
            this.iVD.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.iWo, 5000L);
        }
    }

    public void a(ci ciVar) {
        if (this.iVB == null) {
            View rootView = this.iVs.getRootView();
            this.iVB = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.iVB.setVisibility(0);
            this.iVC = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.iVD = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.iVE = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.iVD.setPageId(this.iVs.getUniqueId());
            this.iVE.setPageId(this.iVs.getUniqueId());
            this.iVD.setDefaultBgResource(R.color.common_color_10022);
            this.iVD.setDefaultResource(0);
            this.iVE.setDefaultBgResource(R.color.common_color_10022);
            this.iVE.setDefaultResource(0);
            this.iVC.setOnClickListener(this.iVJ);
        }
        this.iVC.setVisibility(0);
        String brk = ciVar.brk();
        String brl = ciVar.brl();
        this.iVD.startLoad(brk, 10, false);
        this.iVE.startLoad(brl, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.iWo, 5000L);
    }

    public void cDE() {
        if (this.iVB != null && this.iVC != null) {
            this.iVC.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.am cDF() {
        return this.iVG;
    }

    public RelativeLayout cno() {
        return this.iVt;
    }

    public View cDG() {
        return this.iVL;
    }

    public void zQ(int i) {
        if (this.iVv != null) {
            this.iVv.setVisibility(i);
        }
    }

    public NavigationBar bVL() {
        return this.mNavigationBar;
    }

    public void XZ() {
        this.mHasMore = true;
        this.iVF.setNextPage(this.grg);
        if (this.iVN > 0) {
            this.grg.showEmptyView(this.iVN);
        }
        this.grg.setOnClickListener(null);
        this.grg.startLoadData();
    }

    public void Ya() {
        this.mHasMore = false;
        this.iVF.setNextPage(this.grg);
        if (this.iVN > 0) {
            this.grg.showEmptyView(this.iVN);
        }
        this.grg.setOnClickListener(null);
        this.grg.endLoadData();
        this.grg.setText(this.iVs.getResources().getString(R.string.list_has_no_more));
    }

    public void cDH() {
        this.mHasMore = true;
        this.iVF.setNextPage(this.grg);
        this.grg.setOnClickListener(this.iVJ);
        if (this.iVN > 0) {
            this.grg.showEmptyView(this.iVN);
        }
        this.grg.endLoadData();
        this.grg.setText(this.iVs.getResources().getString(R.string.list_click_load_more));
    }

    public View cDI() {
        if (this.grg == null) {
            return null;
        }
        return this.grg.getView();
    }

    public void zR(int i) {
        if (this.iWg != null) {
            this.iWg.setVisibility(i);
        }
    }

    public void zS(int i) {
        if (this.iWg != null) {
            this.iWg.setSelectNumber(i);
        }
    }

    public void zT(int i) {
        if (this.iWh != null) {
            this.iWh.setVisibility(i);
        }
    }

    public void zU(int i) {
        if (this.iWh != null) {
            this.iWh.setMoveNumber(i);
        }
    }

    public boolean cDJ() {
        return this.iWh != null && this.iWh.cMb();
    }

    public void cDK() {
        if (this.iWh != null) {
            this.iWh.cMc();
        }
    }

    public void bTb() {
        this.mHasMore = false;
        this.iVF.setNextPage(null);
    }

    public boolean cDL() {
        return this.grg.getView().getParent() != null && this.mHasMore;
    }

    public void zV(int i) {
        this.iVN = i;
    }

    public void zW(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.iCQ == null) {
                    this.iCQ = new CommonTipView(this.iVs.getActivity());
                }
                this.iCQ.setText(R.string.frs_login_tip);
                this.iCQ.b((FrameLayout) cDG(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void qf(boolean z) {
        this.mIsBackground = z;
        if (this.iBV != null) {
            boolean z2 = (this.iVs == null || this.iVs.cCd() == null || this.iVs.cCd().cLn() == null) ? true : this.iVs.cCd().cLn().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iBV.tC(false);
                this.iBV.deK();
                return;
            }
            this.iBV.tC(true);
            this.iBV.a(this.iVe, this.gpP, this.iVO, true);
        }
    }

    public void cr(int i, int i2) {
        if (this.iBV != null) {
            this.iBV.a(i, i2, this.iVO, 1);
        }
    }

    public void cs(int i, int i2) {
        this.iVe = i;
        this.gpP = i2;
    }

    public void qg(boolean z) {
        this.iVO = z;
    }

    public void zX(int i) {
        if (this.iVF != null && this.iVF.getChildCount() >= 0) {
            if (this.iVF.getFirstVisiblePosition() > 8) {
                this.iVF.scrollToPosition(8);
            }
            this.iVF.smoothScrollToPosition(i);
        }
    }

    public void cDM() {
        a(this.iVX, this.iVs.cCN());
        if (this.iVG != null) {
            this.iVG.cFZ();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.iVs.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.iVY == null) {
                this.iVY = new com.baidu.tieba.video.f(this.iVs.getActivity(), this.iVt);
            }
            this.iVY.j(postWriteCallBackData);
        }
    }

    public void cDN() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.iWp && this.iVs.getActivity() != null && this.iVs.getPageContext() != null) {
            View view = null;
            if (this.iVF != null && (headerViewsCount = this.iVF.getHeaderViewsCount()) < this.iVF.getChildCount()) {
                view = this.iVF.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ad(true).ae(false).ac(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.iVs.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.iVs.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.iVs.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mi = dVar.mi();
                mi.setShouldCheckLocInWindow(false);
                mi.show(this.iVs.getActivity());
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mi != null) {
                            mi.dismiss();
                        }
                    }
                }, 4000L);
                this.iWp = true;
            }
        }
    }

    public void b(e.a aVar) {
        if (this.iWg != null) {
            this.iWg.setDeleteCallback(aVar);
        }
    }

    public void cDO() {
        if (this.iWg != null) {
            this.iWg.cDO();
        }
    }

    public void bLq() {
        if (this.iWg != null) {
            this.iWg.bLq();
        }
    }

    public void aP(String str, int i) {
        if (this.iWj == null) {
            this.iWj = new TextView(this.iVs.getActivity());
            this.iWj.setGravity(19);
            this.iWj.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iVs.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.iVs.getActivity(), R.dimen.ds34), 0);
            this.iWj.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.iVs.getActivity(), R.dimen.tbds112)));
            this.iWj.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.iVs.getActivity(), R.dimen.fontsize30));
            this.iWj.setMaxLines(2);
            this.iWj.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.iWj.setTextColor(ContextCompat.getColor(this.iVs.getActivity(), R.color.CAM_X0101));
        }
        this.iWi.setBackgroundColor(i);
        this.iWj.setText(str);
        this.iWi.a(this.iVs.getActivity(), this.iWj, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Zj != null) {
            this.Zj.setExpanded(z);
        }
    }

    public void cDP() {
        if (this.iVH != null) {
            this.iVH.startPullRefresh();
        }
    }

    public void HO() {
        if (cDF() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = cDF().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bx) {
                        bx bxVar = (bx) qVar;
                        if (bxVar.eIP != 0 && bxVar.eCR != null && this.iVs.cCa() != null && this.iVs.cCa().cIF() != null) {
                            int[] imageWidthAndHeight = bxVar.eCR.getImageWidthAndHeight();
                            bxVar.eIP = imageWidthAndHeight[0];
                            bxVar.eIQ = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cDF().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iBV.a(q.this.iVe, q.this.gpP, q.this.iVO, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cDQ() {
        if (this.iVP == null) {
            return false;
        }
        return this.iVP.cDQ();
    }

    public Context getContext() {
        if (this.iVs == null) {
            return null;
        }
        return this.iVs.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.iVH != null) {
            this.iVH.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.iVH != null) {
            this.iVH.startPullRefresh();
        }
    }

    public void cDR() {
        if (this.iVH != null) {
            this.iVH.cDR();
        }
    }

    public void cDS() {
        if (this.iVH != null) {
            this.iVH.cDS();
        }
    }

    public void a(at atVar) {
        if (this.iVH != null) {
            this.iVH.a(atVar);
        }
    }

    public void zY(int i) {
        if (this.iVH != null) {
            this.iVH.zY(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cDT() {
        return this.iVH;
    }
}
