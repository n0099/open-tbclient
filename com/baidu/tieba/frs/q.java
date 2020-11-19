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
import com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.ch;
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
/* loaded from: classes21.dex */
public class q {
    private AppBarLayout Ym;
    private NoNetworkView ghk;
    private PbListView giV;
    private View iKB;
    private com.baidu.tieba.d.d iKC;
    private ImageView iKD;
    private ImageView iKE;
    private TextView iKF;
    private ViewStub iKG;
    private BdTypeRecyclerView iKK;
    private com.baidu.tieba.frs.entelechy.a.al iKL;
    private com.baidu.tieba.frs.vc.k iKM;
    private View.OnClickListener iKO;
    private View iKP;
    private View iKQ;
    private int iKS;
    private com.baidu.tieba.frs.vc.d iKU;
    private com.baidu.tieba.frs.entelechy.b.c iKV;
    private com.baidu.tieba.frs.vc.m iKW;
    private GifView iKX;
    private TbImageView iKY;
    private HashSet<String> iKZ;
    private FrsFragment iKx;
    private ObservedChangeLinearLayout iLb;
    private com.baidu.tieba.frs.entelechy.b.a iLc;
    private com.baidu.tieba.video.f iLd;
    private AppBarLayoutStickyBehavior iLe;
    private FrsHeaderViewContainer iLf;
    private CollapsingToolbarLayout iLg;
    private com.baidu.tieba.frs.vc.h iLk;
    private FrsMultiDelBottomMenuView iLl;
    private FrsMoveAreaBottomMenuView iLm;
    private NavigationBarCoverTip iLn;
    private TextView iLo;
    private TextView iLp;
    private boolean iLu;
    private ImageView ieO;
    private MessageRedDotView ieP;
    private CommonTipView irW;
    private com.baidu.tieba.play.i irb;
    private com.baidu.adp.widget.ListView.n isY;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout iKy = null;
    private CoordinatorLayout iKz = null;
    private View iKA = null;
    private FrameLayout iKH = null;
    private TbImageView iKI = null;
    private TbImageView iKJ = null;
    private com.baidu.tbadk.core.dialog.b iKN = null;
    private NoNetworkView.a iFn = null;
    private boolean iKR = true;
    private boolean mHasMore = true;
    private boolean iKT = false;
    private int iKj = 0;
    private int ghD = 0;
    private View bCq = null;
    private View iLa = null;
    private boolean gPI = false;
    private boolean ecs = true;
    private boolean iLh = true;
    private int iLi = -1;
    private int iLj = -1;
    private int iLq = 0;
    private int iLr = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener ita = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.isY == null) {
                        q.this.isY = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.isY.a(q.this.iKK, 2);
                } else if (q.this.isY != null) {
                    q.this.isY.rh();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iLs = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.iKM != null) {
                q.this.iKM.setInterceptScrollDown(i == 0);
            }
            if (q.this.iLj != i && Math.abs(i) >= 0 && q.this.cyQ() != -1) {
                if (Math.abs(i) >= q.this.cyQ()) {
                    if (q.this.iLh) {
                        q.this.iLh = false;
                        q.this.pA(q.this.iLh);
                    }
                } else if (!q.this.iLh) {
                    q.this.iLh = true;
                    q.this.pA(q.this.iLh);
                }
                int cyM = q.this.cyM() + q.this.cyL() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cyM;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.iLj - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.zh(Math.abs(cyM - totalScrollRange2));
                        if (q.this.iLa != null) {
                            q.this.iLa.setVisibility(0);
                        }
                    } else if (q.this.iLa != null) {
                        if (q.this.cyK() != UtilHelper.getStatusBarHeight()) {
                            q.this.zh(0);
                        }
                        q.this.iLa.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.gPI) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.pF(false);
                        } else if (q.this.iLp != null) {
                            q.this.iLp.setAlpha(abs);
                        }
                    }
                    q.this.iLj = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.iKM != null) {
                int cFJ = q.this.iKM.cFJ();
                int cFK = cFJ - q.this.iKM.cFK();
                if (cFJ > 0 && Math.abs(i) >= cFK) {
                    q.this.iKM.dismissLoading();
                }
            }
        }
    };
    private Runnable iLt = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.iKG != null) {
                q.this.iKH.setVisibility(0);
                q.this.iKJ.setVisibility(0);
                q.this.iKI.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.iKx != null && appBarLayout != null && this.iKx.cxM() != null && this.iKx.getPageContext() != null) {
            int cyL = cyL() + getNavigationBarHeight() + cyM();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cxM = this.iKx.cxM();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.iKx.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.iKx.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.iKA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.iKx != null && this.iKx.cxT();
            if (totalScrollRange <= 0) {
                if (this.iLr != 2) {
                    cxM.Bf(2);
                }
                this.iLr = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cyL) {
                if (this.iLr != 1) {
                    cxM.Bf(1);
                }
                this.iLr = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.iLr != 0) {
                    cxM.Bf(0);
                }
                this.iLr = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.iKx.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.iKA.setLayoutParams(marginLayoutParams);
            }
            Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i + "]");
        }
    }

    public ObservedChangeLinearLayout cyI() {
        return this.iLb;
    }

    public View SV() {
        return this.bCq;
    }

    public View cyJ() {
        return this.iLa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cyK() {
        if (this.bCq == null) {
            return 0;
        }
        return this.bCq.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cyL() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cyM() {
        if (this.ghk == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.ghk.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(int i) {
        View SV = SV();
        View cyJ = cyJ();
        if (UtilHelper.canUseStyleImmersiveSticky() && SV != null && cyJ != null && SV.getLayoutParams() != null && cyJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = SV.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            SV.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cyJ.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cyJ.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.iKx = null;
        this.iKO = null;
        this.iKS = 0;
        this.iKx = frsFragment;
        this.iKO = onClickListener;
        MessageManager.getInstance().registerListener(this.ita);
        a(aVar, z);
        this.iKZ = new HashSet<>();
        this.iKS = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iLk = hVar;
    }

    private boolean cyN() {
        return this.iLk != null && this.iLk.cFu();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.iLc = aVar;
        View rootView = this.iKx.getRootView();
        if (this.iKy == null) {
            this.iKy = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.iKA == null) {
            this.iKA = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.iKz == null) {
            this.iKz = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.iKQ == null) {
            this.iKQ = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.iLg == null) {
            this.iLg = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.iLf == null) {
            this.iLf = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.iKM == null) {
            this.iKM = new com.baidu.tieba.frs.vc.k(this.iKx);
        }
        if (this.iLb == null) {
            this.iLb = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.iLb.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.iLg.setMinimumHeight(i2);
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
        if (this.iKx.cyv()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.iKP == null) {
            this.iKP = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b cBj = aVar.cBj();
            if (cBj != null) {
                cBj.cG(this.iKP);
            }
        }
        if (this.iKB == null) {
            this.iKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iKB.setOnClickListener(this.iKO);
            this.mBackImageView = (ImageView) this.iKB.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iKE == null) {
            this.iKE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bqB().a(this.iKE, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iKE.setOnClickListener(this.iKO);
        }
        if (this.iKC == null) {
            this.iKC = new com.baidu.tieba.d.d(this.iKx.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iKC.getView(), (View.OnClickListener) null);
            this.ieO = this.iKC.coU();
            this.ieP = this.iKC.coV();
            this.ieP.setShadowEnabled(false);
            this.iKC.getView().setOnClickListener(this.iKO);
            this.iKC.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.iKD == null) {
            this.iKD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bqB().a(this.iKD, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iKD.setOnClickListener(this.iKO);
        }
        if (this.iKF == null) {
            this.iKF = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.iKF.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.iKx.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iKF.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.g(this.iKF, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iKF, R.color.CAM_X0101);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.iKx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.iKK == null) {
            this.iKK = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int iLx = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.iLx--;
                if (this.iLx == 0) {
                    q.this.iKK.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.iLx++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.iKK.setItemAnimator(defaultItemAnimator);
        this.iKK.setLayoutManager(new LinearLayoutManager(this.iKK.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isY = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.isY.a(this.iKK, 2);
        }
        this.iKK.setScrollable(this.iKx);
        this.iKK.setFadingEdgeLength(0);
        this.iKK.setOverScrollMode(2);
        this.iKy.setBottomOrderView(this.iKK);
        this.iKK.setOnTouchListener(this.iKx.fyo);
        this.iKK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.irb != null) {
                    q.this.irb.de(view);
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
        if (!com.baidu.tbadk.a.d.bhw()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.iKK.setPadding(dimenPixelSize, this.iKK.getPaddingTop(), dimenPixelSize, this.iKK.getPaddingBottom());
        }
        if (this.giV == null) {
            this.giV = new PbListView(this.iKx.getPageContext().getPageActivity());
            this.giV.getView();
        }
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iKx.getActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iKK.setOnSrollToBottomListener(this.iKx);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.iKx.cyo();
                if (q.this.iKx != null && q.this.Ym != null) {
                    q.this.iKx.cyy();
                    q.this.Ym.setExpanded(true);
                    if (q.this.irb != null) {
                        q.this.irb.a(q.this.iKj, q.this.ghD, false, true);
                    }
                }
            }
        });
        boolean bqD = com.baidu.tbadk.core.util.av.bqC().bqD();
        if (this.iKL == null) {
            this.iKL = aVar.a(this.iKx, this.iKK, bqD);
        }
        if (this.iKM != null) {
            this.iKM.Q(1, false);
        }
        if (!z) {
            if (this.ghk == null) {
                this.ghk = new NoNetworkView(this.iKx.getActivity());
                this.ghk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.iLb.addView(this.ghk);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.ghk.setVisibility(8);
            } else {
                this.ghk.setVisibility(0);
            }
            this.ghk.onChangeSkinType(this.iKx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cyX();
        if (this.iKU == null) {
            this.iKU = aVar.a(this.iKx, this.iKy);
            this.iKU.b(this.iKx.cyz());
        }
        if (this.iKV == null) {
            this.iKV = aVar.b(this.iKx, this.iKy);
            pD(true);
        }
        if (this.bCq == null) {
            this.bCq = rootView.findViewById(R.id.statebar_view);
        }
        if (this.iLa == null) {
            this.iLa = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.irb == null) {
            this.irb = new com.baidu.tieba.play.i(this.iKx.getPageContext(), this.iKK);
        }
        this.irb.HS(1);
        this.irb.setUniqueId(this.iKx.getUniqueId());
        this.iLn = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.iKW == null) {
            this.iKW = new com.baidu.tieba.frs.vc.m(this.iKx, this.iLn);
        }
        if (this.Ym == null) {
            this.Ym = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Ym.addOnOffsetChangedListener(this.iLs);
            this.iLh = true;
            this.iLi = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Ym.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.iLe = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.iLl = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.iLl.setPageContext(this.iKx.getPageContext());
        this.iLm = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.iLm.setPageContext(this.iKx.getPageContext());
        if (this.iLp == null) {
            this.iLp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.iKx.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.iLp.setLayoutParams(layoutParams2);
            this.iLp.setPadding(0, 0, this.iKx.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.iLp.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
    }

    public void bS(boolean z) {
        if (z) {
        }
    }

    private void cyO() {
        ViewGroup.LayoutParams layoutParams;
        this.gPI = cyN();
        if (this.iLf != null && (layoutParams = this.iLf.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.gPI) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cyL(), 0, 0);
            }
            this.iLf.requestLayout();
        }
    }

    public void cyP() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.iLb != null) {
            cyO();
            if (this.gPI) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bCq != null) {
                    this.bCq.setAlpha(1.0f);
                }
                if (this.iLa != null) {
                    this.iLa.setAlpha(1.0f);
                }
                if (this.iLp != null) {
                    this.iLp.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(boolean z) {
        if (z && this.iKx != null && this.iKx.cxL() != null) {
            this.iKx.cxL().cFz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cyQ() {
        int i;
        if (this.Ym == null) {
            return this.iLi;
        }
        if (this.iLi != -1) {
            return this.iLi;
        }
        int childCount = this.Ym.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Ym.getChildAt(childCount);
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
        this.iLi = Math.max(0, this.Ym.getTotalScrollRange() - Math.abs(i2));
        return this.iLi;
    }

    public void JS(String str) {
        if (this.iKW != null) {
            this.iKW.JS(str);
        }
    }

    public com.baidu.tieba.play.i cyR() {
        return this.irb;
    }

    public com.baidu.tieba.frs.entelechy.b.c cyS() {
        return this.iKV;
    }

    public void pB(boolean z) {
        if (this.iKU != null) {
            if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                this.iKU.pB(false);
            } else {
                this.iKU.pB(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cyT() {
        return this.iKU;
    }

    public void Y(boolean z, boolean z2) {
        if (this.ecs && this.iKV != null) {
            this.iKV.Y(z, z2);
        }
    }

    public void pC(boolean z) {
        this.ecs = z;
        if (!this.ecs && this.iKV != null) {
            this.iKV.Y(false, false);
        }
    }

    public void cyU() {
        if (this.ecs && this.iKV != null) {
            this.iKV.Y(false, false);
        }
        zi(8);
        this.iKE.setVisibility(8);
        this.iKD.setVisibility(8);
        pB(false);
        this.iKK.setVisibility(8);
        this.iLf.setVisibility(8);
    }

    public void cyV() {
        if (this.ecs && this.iKV != null) {
            this.iKV.Y(true, false);
        }
        zi(0);
        cyW();
        pB(this.iKx.cyB());
        this.iKK.setVisibility(0);
        this.iLf.setVisibility(0);
    }

    private void zi(int i) {
        if (this.iKC != null) {
            this.iKC.setVisibility(i);
        }
    }

    private void cyW() {
        this.iKE.setVisibility(0);
        this.iKD.setVisibility(0);
    }

    public void pD(boolean z) {
        if (this.iKV != null) {
            this.iKV.qf(z);
        }
    }

    private void cyX() {
        if (this.iKX == null) {
            View rootView = this.iKx.getRootView();
            this.iKX = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.iKY = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.iKY.setPageId(this.iKx.getUniqueId());
            this.iKX.setLayerType(1, null);
            this.iKY.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cyY() {
        return this.iKB;
    }

    public void g(NoNetworkView.a aVar) {
        this.iFn = aVar;
        if (this.ghk != null) {
            this.ghk.a(this.iFn);
        }
    }

    public void pE(boolean z) {
        if (this.iKV != null) {
            if (z) {
                Y(false, true);
            } else {
                Y(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iKK.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.iKL.a(abVar);
    }

    public void setForumName(String str) {
        this.iKL.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ita);
        if (this.irb != null) {
            this.irb.destroy();
        }
        if (this.iKW != null) {
            this.iKW.onDestory();
        }
        if (this.iLl != null) {
            this.iLl.setPageContext(null);
        }
        if (this.iLm != null) {
            this.iLm.setPageContext(null);
        }
        this.iKL.onDestory();
        this.iKK.setOnSrollToBottomListener(null);
        this.iKK.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.iLt);
        if (this.irW != null) {
            this.irW.onDestroy();
        }
        this.iKZ.clear();
        if (this.iKU != null) {
            this.iKU.cFe();
        }
        if (this.iLd != null) {
            this.iLd.cAQ();
        }
        if (this.iLn != null) {
            this.iLn.onDestroy();
        }
        if (this.iLl != null) {
            this.iLl.onDestroy();
        }
        if (this.iKM != null) {
            this.iKM.onDestroy();
        }
    }

    public boolean cyZ() {
        if (this.Ym == null || this.iLe == null || !this.iLe.isSticky()) {
            return this.iKU != null && this.iKU.cyZ();
        }
        if (this.iKK != null) {
            this.iKK.setSelection(0);
        }
        this.iLe.expandedAppBarLayout(this.Ym);
        return true;
    }

    public boolean cyt() {
        if (this.iKM == null) {
            return false;
        }
        return this.iKM.cyt();
    }

    public void bUJ() {
        this.iKK.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.iLp.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.iLp.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.iLp.setText(str2);
            com.baidu.tbadk.core.k.biL().setForumNameForWaterImage(str);
        }
    }

    public void cza() {
        if (this.iKL != null) {
            this.iKL.notifyDataSetChanged();
        }
    }

    public void aZK() {
        if (this.iKL instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.iKL).aZK();
        }
    }

    private void czb() {
        if (this.iKN == null && this.iKx.getPageContext() != null) {
            String[] strArr = {this.iKx.getPageContext().getPageActivity().getString(R.string.take_photo), this.iKx.getPageContext().getPageActivity().getString(R.string.album)};
            this.iKN = new com.baidu.tbadk.core.dialog.b(this.iKx.getPageContext().getPageActivity());
            this.iKN.AK(this.iKx.getPageContext().getPageActivity().getString(R.string.operation));
            this.iKN.a(strArr, new b.InterfaceC0574b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.iKx.cyu();
                    } else if (i == 1 && q.this.iKx.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.iKx.getPageContext().getPageActivity());
                    }
                }
            });
            this.iKN.d(this.iKx.getPageContext());
        }
    }

    public void czc() {
        czb();
        if (this.iKN != null) {
            this.iKN.boi();
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
                if (this.iKx != null && this.iKx.cxJ() != null && this.iKx.cxJ().cDO() == 0) {
                    sVar.zu(this.iKx.cxJ().cDV());
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
                    if (qVar instanceof bw) {
                        ((bw) qVar).evQ.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.iKL.b(arrayList2, frsViewData);
            if (this.irb != null && this.iKj != 0) {
                this.irb.a(this.iKj, this.ghD, this.iKT, true);
            }
            if (this.iKx != null) {
                this.iKx.cyE();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.iKK;
    }

    public void czd() {
        this.iKL.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ae aeVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iKx.getPageContext(), 1);
        aVar.a(this.iKK);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.iKx.getForumName());
        hashMap.put("forum_id", this.iKx.getForumId());
        aVar.setParams(hashMap);
        aVar.aB(aeVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.iKU != null) {
            this.iKU.cFf();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        zj(TbadkCoreApplication.getInst().getSkinType());
        if (this.iKU != null) {
            this.iKU.cFg();
        }
    }

    public void release() {
        if (this.ghk != null && this.iFn != null) {
            this.ghk.b(this.iFn);
        }
    }

    public ImageView cze() {
        return this.iKE;
    }

    public ImageView czf() {
        return this.iKD;
    }

    public TextView czg() {
        return this.iKF;
    }

    public View czh() {
        if (this.iKC != null) {
            return this.iKC.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.iKC != null) {
            this.iKC.A(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.iKx, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iKx.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.iKY != null) {
            this.iKY.invalidate();
        }
        if (this.iKL != null) {
            this.iKL.cBI();
            this.iKL.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.iKx.getPageContext(), this.iKy);
        if (this.ghk != null) {
            this.ghk.onChangeSkinType(this.iKx.getPageContext(), i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
            this.giV.changeSkin(i);
        }
        if (this.iLp != null) {
            this.iLp.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
        zj(i);
        if (this.iKV != null) {
            this.iKV.onChangeSkinType(i);
        }
        if (this.iKU != null) {
            this.iKU.onChangeSkinType(i);
        }
        if (this.iLl != null) {
            this.iLl.onChangeSkinType();
        }
        if (this.iLm != null) {
            this.iLm.onChangeSkinType();
        }
        if (!com.baidu.tbadk.a.d.bhw()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iKA, R.color.CAM_X0202);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iKA, R.color.CAM_X0204);
        }
    }

    private void zj(int i) {
        if (this.iKx != null) {
            zk(i);
        }
    }

    private void zk(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iKx.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iKP, R.color.CAM_X0204, i);
            if (this.iKC != null) {
                this.iKC.onChangeSkinType(i);
            }
            if (this.iKE != null) {
                SvgManager.bqB().a(this.iKE, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iKD != null) {
                SvgManager.bqB().a(this.iKD, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (com.baidu.tbadk.a.d.bhw()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bCq, R.color.CAM_X0208);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iLa, R.color.CAM_X0208);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bCq, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iLa, R.color.CAM_X0207);
        }
        pF(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gPI) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.iLq != 0) {
                    SvgManager.bqB().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bqB().a(this.iKE, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.ieO.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
                    SvgManager.bqB().a(this.iKD, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iLq = 0;
                }
            } else if (z || this.iLq != 1) {
                SvgManager.bqB().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bqB().a(this.iKE, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.ieO.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0106), (WebPManager.ResourceStateType) null));
                SvgManager.bqB().a(this.iKD, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iLq = 1;
            }
            czi();
        }
    }

    private void czi() {
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
            if (this.iLp != null) {
                this.iLp.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.ieO != null) {
                    this.ieO.setAlpha(f);
                }
                if (this.iKx != null && this.iKx.cxM() != null && this.iLq == 1) {
                    this.iKx.cxM().aE(f);
                }
                if (this.ieP != null) {
                    this.ieP.setAlpha(f);
                }
                if (this.iKE != null) {
                    this.iKE.setAlpha(f);
                }
                if (this.iKD != null) {
                    this.iKD.setAlpha(f);
                }
            }
            if (this.iKF != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.iKF.setAlpha(f2);
                this.iKF.setClickable(f2 > 0.0f);
            }
            if (this.bCq != null) {
                this.bCq.setAlpha(alpha);
            }
            if (this.iLa != null) {
                this.iLa.setAlpha(alpha);
            }
            if (this.iKP != null) {
                this.iKP.setAlpha(alpha);
            }
        }
    }

    public void bOA() {
        if (this.iKM != null) {
            this.iKM.bOA();
        }
    }

    public void pG(boolean z) {
        if (this.iKM != null) {
            this.iKM.pG(z);
        }
    }

    public void pH(boolean z) {
        this.iKR = z;
        if (this.iKR) {
            this.giV.setText(this.iKx.getResources().getString(R.string.load_more));
            if (this.iKK.getChildAt(this.iKK.getChildCount() - 1) == this.giV.getView()) {
                this.giV.startLoadData();
                this.iKx.bOb();
                return;
            }
            this.giV.endLoadData();
            return;
        }
        this.giV.setText(this.iKx.getResources().getString(R.string.load_more_must_after_delete));
        this.giV.endLoadData();
    }

    public boolean czj() {
        if (this.iKR) {
            return false;
        }
        this.giV.setText(this.iKx.getResources().getString(R.string.load_more_must_after_delete));
        this.giV.endLoadData();
        return true;
    }

    public boolean czk() {
        return this.iKG != null && this.iKJ.getVisibility() == 0;
    }

    public void czl() {
        if (this.iKG != null) {
            this.iKH.setVisibility(0);
            this.iKJ.setVisibility(8);
            this.iKI.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.iLt, 5000L);
        }
    }

    public void a(ch chVar) {
        if (this.iKG == null) {
            View rootView = this.iKx.getRootView();
            this.iKG = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.iKG.setVisibility(0);
            this.iKH = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.iKI = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.iKJ = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.iKI.setPageId(this.iKx.getUniqueId());
            this.iKJ.setPageId(this.iKx.getUniqueId());
            this.iKI.setDefaultBgResource(R.color.common_color_10022);
            this.iKI.setDefaultResource(0);
            this.iKJ.setDefaultBgResource(R.color.common_color_10022);
            this.iKJ.setDefaultResource(0);
            this.iKH.setOnClickListener(this.iKO);
        }
        this.iKH.setVisibility(0);
        String bnV = chVar.bnV();
        String bnW = chVar.bnW();
        this.iKI.startLoad(bnV, 10, false);
        this.iKJ.startLoad(bnW, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.iLt, 5000L);
    }

    public void czm() {
        if (this.iKG != null && this.iKH != null) {
            this.iKH.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al czn() {
        return this.iKL;
    }

    public RelativeLayout cjt() {
        return this.iKy;
    }

    public View czo() {
        return this.iKQ;
    }

    public void zl(int i) {
        if (this.iKA != null) {
            this.iKA.setVisibility(i);
        }
    }

    public void czp() {
        if (com.baidu.tbadk.n.m.bBK().isSmallFlow()) {
            int lastVisiblePosition = this.iKK.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iKK.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.iLH != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.iLH.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fup = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.iLH.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.iLH.startLogPerf();
                    }
                    if (uVar.iLG != null && (uVar.iLG instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.iLG;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fup = true;
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

    public NavigationBar bSa() {
        return this.mNavigationBar;
    }

    public void Vz() {
        this.mHasMore = true;
        this.iKK.setNextPage(this.giV);
        if (this.iKS > 0) {
            this.giV.showEmptyView(this.iKS);
        }
        this.giV.setOnClickListener(null);
        this.giV.startLoadData();
    }

    public void VA() {
        this.mHasMore = false;
        this.iKK.setNextPage(this.giV);
        if (this.iKS > 0) {
            this.giV.showEmptyView(this.iKS);
        }
        this.giV.setOnClickListener(null);
        this.giV.endLoadData();
        this.giV.setText(this.iKx.getResources().getString(R.string.list_has_no_more));
    }

    public void czq() {
        this.mHasMore = true;
        this.iKK.setNextPage(this.giV);
        this.giV.setOnClickListener(this.iKO);
        if (this.iKS > 0) {
            this.giV.showEmptyView(this.iKS);
        }
        this.giV.endLoadData();
        this.giV.setText(this.iKx.getResources().getString(R.string.list_click_load_more));
    }

    public View czr() {
        if (this.giV == null) {
            return null;
        }
        return this.giV.getView();
    }

    public void zm(int i) {
        if (this.iLl != null) {
            this.iLl.setVisibility(i);
        }
    }

    public void zn(int i) {
        if (this.iLl != null) {
            this.iLl.setSelectNumber(i);
        }
    }

    public void zo(int i) {
        if (this.iLm != null) {
            this.iLm.setVisibility(i);
        }
    }

    public void zp(int i) {
        if (this.iLm != null) {
            this.iLm.setMoveNumber(i);
        }
    }

    public boolean czs() {
        return this.iLm != null && this.iLm.cGL();
    }

    public void czt() {
        if (this.iLm != null) {
            this.iLm.cGM();
        }
    }

    public void bPp() {
        this.mHasMore = false;
        this.iKK.setNextPage(null);
    }

    public boolean czu() {
        return this.giV.getView().getParent() != null && this.mHasMore;
    }

    public void zq(int i) {
        this.iKS = i;
    }

    public void zr(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.irW == null) {
                    this.irW = new CommonTipView(this.iKx.getActivity());
                }
                this.irW.setText(R.string.frs_login_tip);
                this.irW.b((FrameLayout) czo(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void pI(boolean z) {
        this.mIsBackground = z;
        if (this.irb != null) {
            boolean z2 = (this.iKx == null || this.iKx.cxM() == null || this.iKx.cxM().cFX() == null) ? true : this.iKx.cxM().cFX().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.irb.ta(false);
                this.irb.cZy();
                return;
            }
            this.irb.ta(true);
            this.irb.a(this.iKj, this.ghD, this.iKT, true);
        }
    }

    public void cn(int i, int i2) {
        if (this.irb != null) {
            this.irb.a(i, i2, this.iKT, 1);
        }
    }

    public void co(int i, int i2) {
        this.iKj = i;
        this.ghD = i2;
    }

    public void pJ(boolean z) {
        this.iKT = z;
    }

    public void zs(int i) {
        if (this.iKK != null && this.iKK.getChildCount() >= 0) {
            if (this.iKK.getFirstVisiblePosition() > 8) {
                this.iKK.scrollToPosition(8);
            }
            this.iKK.smoothScrollToPosition(i);
        }
    }

    public void czv() {
        a(this.iLc, this.iKx.cyv());
        if (this.iKL != null) {
            this.iKL.cBF();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.iKx.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.iLd == null) {
                this.iLd = new com.baidu.tieba.video.f(this.iKx.getActivity(), this.iKy);
            }
            this.iLd.j(postWriteCallBackData);
        }
    }

    public void czw() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.iLu && this.iKx.getActivity() != null && this.iKx.getPageContext() != null) {
            View view = null;
            if (this.iKK != null && (headerViewsCount = this.iKK.getHeaderViewsCount()) < this.iKK.getChildCount()) {
                view = this.iKK.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.iKx.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.iKx.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.iKx.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mi = dVar.mi();
                mi.setShouldCheckLocInWindow(false);
                mi.show(this.iKx.getActivity());
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mi != null) {
                            mi.dismiss();
                        }
                    }
                }, 4000L);
                this.iLu = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.iLl != null) {
            this.iLl.setDeleteCallback(aVar);
        }
    }

    public void czx() {
        if (this.iLl != null) {
            this.iLl.czx();
        }
    }

    public void bHP() {
        if (this.iLl != null) {
            this.iLl.bHP();
        }
    }

    public void aO(String str, int i) {
        if (this.iLo == null) {
            this.iLo = new TextView(this.iKx.getActivity());
            this.iLo.setGravity(19);
            this.iLo.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iKx.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.iKx.getActivity(), R.dimen.ds34), 0);
            this.iLo.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.iKx.getActivity(), R.dimen.tbds112)));
            this.iLo.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.iKx.getActivity(), R.dimen.fontsize30));
            this.iLo.setMaxLines(2);
            this.iLo.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.iLo.setTextColor(ContextCompat.getColor(this.iKx.getActivity(), R.color.CAM_X0101));
        }
        this.iLn.setBackgroundColor(i);
        this.iLo.setText(str);
        this.iLn.a(this.iKx.getActivity(), this.iLo, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Ym != null) {
            this.Ym.setExpanded(z);
        }
    }

    public void czy() {
        if (this.iKM != null) {
            this.iKM.startPullRefresh();
        }
    }

    public void FZ() {
        if (czn() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = czn().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bw) {
                        bw bwVar = (bw) qVar;
                        if (bwVar.eBO != 0 && bwVar.evQ != null && this.iKx.cxJ() != null && this.iKx.cxJ().cDr() != null) {
                            int[] imageWidthAndHeight = bwVar.evQ.getImageWidthAndHeight();
                            bwVar.eBO = imageWidthAndHeight[0];
                            bwVar.eBP = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.czn().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.irb.a(q.this.iKj, q.this.ghD, q.this.iKT, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean czz() {
        if (this.iKU == null) {
            return false;
        }
        return this.iKU.czz();
    }

    public Context getContext() {
        if (this.iKx == null) {
            return null;
        }
        return this.iKx.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.iKM != null) {
            this.iKM.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.iKM != null) {
            this.iKM.startPullRefresh();
        }
    }

    public void czA() {
        if (this.iKM != null) {
            this.iKM.czA();
        }
    }

    public void czB() {
        if (this.iKM != null) {
            this.iKM.czB();
        }
    }

    public void a(au auVar) {
        if (this.iKM != null) {
            this.iKM.a(auVar);
        }
    }

    public void zt(int i) {
        if (this.iKM != null) {
            this.iKM.zt(i);
        }
    }

    public com.baidu.tieba.frs.vc.k czC() {
        return this.iKM;
    }
}
