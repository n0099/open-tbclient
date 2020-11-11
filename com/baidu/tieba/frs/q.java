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
    private NoNetworkView ghD;
    private PbListView gjo;
    private FrsFragment iJK;
    private View iJO;
    private com.baidu.tieba.c.d iJP;
    private ImageView iJQ;
    private ImageView iJR;
    private TextView iJS;
    private ViewStub iJT;
    private BdTypeRecyclerView iJX;
    private com.baidu.tieba.frs.entelechy.a.al iJY;
    private com.baidu.tieba.frs.vc.k iJZ;
    private NavigationBarCoverTip iKA;
    private TextView iKB;
    private TextView iKC;
    private boolean iKH;
    private View.OnClickListener iKb;
    private View iKc;
    private View iKd;
    private int iKf;
    private com.baidu.tieba.frs.vc.d iKh;
    private com.baidu.tieba.frs.entelechy.b.c iKi;
    private com.baidu.tieba.frs.vc.m iKj;
    private GifView iKk;
    private TbImageView iKl;
    private HashSet<String> iKm;
    private ObservedChangeLinearLayout iKo;
    private com.baidu.tieba.frs.entelechy.b.a iKp;
    private com.baidu.tieba.video.f iKq;
    private AppBarLayoutStickyBehavior iKr;
    private FrsHeaderViewContainer iKs;
    private CollapsingToolbarLayout iKt;
    private com.baidu.tieba.frs.vc.h iKx;
    private FrsMultiDelBottomMenuView iKy;
    private FrsMoveAreaBottomMenuView iKz;
    private ImageView idZ;
    private MessageRedDotView iea;
    private com.baidu.tieba.play.i iqn;
    private CommonTipView iri;
    private com.baidu.adp.widget.ListView.n isk;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout iJL = null;
    private CoordinatorLayout iJM = null;
    private View iJN = null;
    private FrameLayout iJU = null;
    private TbImageView iJV = null;
    private TbImageView iJW = null;
    private com.baidu.tbadk.core.dialog.b iKa = null;
    private NoNetworkView.a iEz = null;
    private boolean iKe = true;
    private boolean mHasMore = true;
    private boolean iKg = false;
    private int iJw = 0;
    private int ghW = 0;
    private View bEb = null;
    private View iKn = null;
    private boolean gQb = false;
    private boolean eea = true;
    private boolean iKu = true;
    private int iKv = -1;
    private int iKw = -1;
    private int iKD = 0;
    private int iKE = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener ism = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.isk == null) {
                        q.this.isk = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.isk.a(q.this.iJX, 2);
                } else if (q.this.isk != null) {
                    q.this.isk.rh();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iKF = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.iJZ != null) {
                q.this.iJZ.setInterceptScrollDown(i == 0);
            }
            if (q.this.iKw != i && Math.abs(i) >= 0 && q.this.czn() != -1) {
                if (Math.abs(i) >= q.this.czn()) {
                    if (q.this.iKu) {
                        q.this.iKu = false;
                        q.this.px(q.this.iKu);
                    }
                } else if (!q.this.iKu) {
                    q.this.iKu = true;
                    q.this.px(q.this.iKu);
                }
                int czj = q.this.czj() + q.this.czi() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - czj;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.iKw - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.yJ(Math.abs(czj - totalScrollRange2));
                        if (q.this.iKn != null) {
                            q.this.iKn.setVisibility(0);
                        }
                    } else if (q.this.iKn != null) {
                        if (q.this.czh() != UtilHelper.getStatusBarHeight()) {
                            q.this.yJ(0);
                        }
                        q.this.iKn.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.gQb) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.pC(false);
                        } else if (q.this.iKC != null) {
                            q.this.iKC.setAlpha(abs);
                        }
                    }
                    q.this.iKw = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.iJZ != null) {
                int cGe = q.this.iJZ.cGe();
                int cGf = cGe - q.this.iJZ.cGf();
                if (cGe > 0 && Math.abs(i) >= cGf) {
                    q.this.iJZ.dismissLoading();
                }
            }
        }
    };
    private Runnable iKG = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.iJT != null) {
                q.this.iJU.setVisibility(0);
                q.this.iJW.setVisibility(0);
                q.this.iJV.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.iJK != null && appBarLayout != null && this.iJK.cyj() != null && this.iJK.getPageContext() != null) {
            int czi = czi() + getNavigationBarHeight() + czj();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cyj = this.iJK.cyj();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.iJK.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.iJK.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.iJN.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.iJK != null && this.iJK.cyq();
            if (totalScrollRange <= 0) {
                if (this.iKE != 2) {
                    cyj.AH(2);
                }
                this.iKE = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= czi) {
                if (this.iKE != 1) {
                    cyj.AH(1);
                }
                this.iKE = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.iKE != 0) {
                    cyj.AH(0);
                }
                this.iKE = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.iJK.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.iJN.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout czf() {
        return this.iKo;
    }

    public View TE() {
        return this.bEb;
    }

    public View czg() {
        return this.iKn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czh() {
        if (this.bEb == null) {
            return 0;
        }
        return this.bEb.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czi() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czj() {
        if (this.ghD == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.ghD.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yJ(int i) {
        View TE = TE();
        View czg = czg();
        if (UtilHelper.canUseStyleImmersiveSticky() && TE != null && czg != null && TE.getLayoutParams() != null && czg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = TE.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            TE.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = czg.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            czg.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.iJK = null;
        this.iKb = null;
        this.iKf = 0;
        this.iJK = frsFragment;
        this.iKb = onClickListener;
        MessageManager.getInstance().registerListener(this.ism);
        a(aVar, z);
        this.iKm = new HashSet<>();
        this.iKf = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iKx = hVar;
    }

    private boolean czk() {
        return this.iKx != null && this.iKx.cFP();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.iKp = aVar;
        View rootView = this.iJK.getRootView();
        if (this.iJL == null) {
            this.iJL = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.iJN == null) {
            this.iJN = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.iJM == null) {
            this.iJM = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.iKd == null) {
            this.iKd = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.iKt == null) {
            this.iKt = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.iKs == null) {
            this.iKs = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.iJZ == null) {
            this.iJZ = new com.baidu.tieba.frs.vc.k(this.iJK);
        }
        if (this.iKo == null) {
            this.iKo = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.iKo.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.iKt.setMinimumHeight(i2);
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
        if (this.iJK.cyS()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.iKc == null) {
            this.iKc = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b cBG = aVar.cBG();
            if (cBG != null) {
                cBG.cC(this.iKc);
            }
        }
        if (this.iJO == null) {
            this.iJO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iJO.setOnClickListener(this.iKb);
            this.mBackImageView = (ImageView) this.iJO.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iJR == null) {
            this.iJR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.brn().a(this.iJR, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iJR.setOnClickListener(this.iKb);
        }
        if (this.iJP == null) {
            this.iJP = new com.baidu.tieba.c.d(this.iJK.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iJP.getView(), (View.OnClickListener) null);
            this.idZ = this.iJP.cpt();
            this.iea = this.iJP.cpu();
            this.iJP.getView().setOnClickListener(this.iKb);
            this.iJP.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.iJQ == null) {
            this.iJQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.brn().a(this.iJQ, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iJQ.setOnClickListener(this.iKb);
        }
        if (this.iJS == null) {
            this.iJS = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.iJS.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.iJK.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iJS.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.f(this.iJS, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iJS, R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.iJK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.iJX == null) {
            this.iJX = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int iKK = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.iKK--;
                if (this.iKK == 0) {
                    q.this.iJX.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.iKK++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.iJX.setItemAnimator(defaultItemAnimator);
        this.iJX.setLayoutManager(new LinearLayoutManager(this.iJX.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isk = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.isk.a(this.iJX, 2);
        }
        this.iJX.setScrollable(this.iJK);
        this.iJX.setFadingEdgeLength(0);
        this.iJX.setOverScrollMode(2);
        this.iJL.setBottomOrderView(this.iJX);
        this.iJX.setOnTouchListener(this.iJK.fzb);
        this.iJX.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iqn != null) {
                    q.this.iqn.da(view);
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
        if (this.gjo == null) {
            this.gjo = new PbListView(this.iJK.getPageContext().getPageActivity());
            this.gjo.getView();
        }
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.gjo.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iJK.getActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iJX.setOnSrollToBottomListener(this.iJK);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.iJK.cyL();
                if (q.this.iJK != null && q.this.Yh != null) {
                    q.this.iJK.cyV();
                    q.this.Yh.setExpanded(true);
                    if (q.this.iqn != null) {
                        q.this.iqn.a(q.this.iJw, q.this.ghW, false, true);
                    }
                }
            }
        });
        boolean brp = com.baidu.tbadk.core.util.au.bro().brp();
        if (this.iJY == null) {
            this.iJY = aVar.a(this.iJK, this.iJX, brp);
        }
        if (this.iJZ != null) {
            this.iJZ.Q(1, false);
        }
        if (!z) {
            if (this.ghD == null) {
                this.ghD = new NoNetworkView(this.iJK.getActivity());
                this.ghD.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.iKo.addView(this.ghD);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.ghD.setVisibility(8);
            } else {
                this.ghD.setVisibility(0);
            }
            this.ghD.onChangeSkinType(this.iJK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        czu();
        if (this.iKh == null) {
            this.iKh = aVar.a(this.iJK, this.iJL);
            this.iKh.b(this.iJK.cyW());
        }
        if (this.iKi == null) {
            this.iKi = aVar.b(this.iJK, this.iJL);
            pA(true);
        }
        if (this.bEb == null) {
            this.bEb = rootView.findViewById(R.id.statebar_view);
        }
        if (this.iKn == null) {
            this.iKn = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iqn == null) {
            this.iqn = new com.baidu.tieba.play.i(this.iJK.getPageContext(), this.iJX);
        }
        this.iqn.Hu(1);
        this.iqn.setUniqueId(this.iJK.getUniqueId());
        this.iKA = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.iKj == null) {
            this.iKj = new com.baidu.tieba.frs.vc.m(this.iJK, this.iKA);
        }
        if (this.Yh == null) {
            this.Yh = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Yh.addOnOffsetChangedListener(this.iKF);
            this.iKu = true;
            this.iKv = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Yh.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.iKr = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.iKy = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.iKy.setPageContext(this.iJK.getPageContext());
        this.iKz = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.iKz.setPageContext(this.iJK.getPageContext());
        if (this.iKC == null) {
            this.iKC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.iJK.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.iKC.setLayoutParams(layoutParams2);
            this.iKC.setPadding(0, 0, this.iJK.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.iKC.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
    }

    public void bQ(boolean z) {
        if (z) {
        }
    }

    private void czl() {
        ViewGroup.LayoutParams layoutParams;
        this.gQb = czk();
        if (this.iKs != null && (layoutParams = this.iKs.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.gQb) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + czi(), 0, 0);
            }
            this.iKs.requestLayout();
        }
    }

    public void czm() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.iKo != null) {
            czl();
            if (this.gQb) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bEb != null) {
                    this.bEb.setAlpha(1.0f);
                }
                if (this.iKn != null) {
                    this.iKn.setAlpha(1.0f);
                }
                if (this.iKC != null) {
                    this.iKC.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void px(boolean z) {
        if (z && this.iJK != null && this.iJK.cyi() != null) {
            this.iJK.cyi().cFU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czn() {
        int i;
        if (this.Yh == null) {
            return this.iKv;
        }
        if (this.iKv != -1) {
            return this.iKv;
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
        this.iKv = Math.max(0, this.Yh.getTotalScrollRange() - Math.abs(i2));
        return this.iKv;
    }

    public void Kr(String str) {
        if (this.iKj != null) {
            this.iKj.Kr(str);
        }
    }

    public com.baidu.tieba.play.i czo() {
        return this.iqn;
    }

    public com.baidu.tieba.frs.entelechy.b.c czp() {
        return this.iKi;
    }

    public void py(boolean z) {
        if (this.iKh != null) {
            if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                this.iKh.py(false);
            } else {
                this.iKh.py(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d czq() {
        return this.iKh;
    }

    public void Y(boolean z, boolean z2) {
        if (this.eea && this.iKi != null) {
            this.iKi.Y(z, z2);
        }
    }

    public void pz(boolean z) {
        this.eea = z;
        if (!this.eea && this.iKi != null) {
            this.iKi.Y(false, false);
        }
    }

    public void czr() {
        if (this.eea && this.iKi != null) {
            this.iKi.Y(false, false);
        }
        yK(8);
        this.iJR.setVisibility(8);
        this.iJQ.setVisibility(8);
        py(false);
        this.iJX.setVisibility(8);
        this.iKs.setVisibility(8);
    }

    public void czs() {
        if (this.eea && this.iKi != null) {
            this.iKi.Y(true, false);
        }
        yK(0);
        czt();
        py(this.iJK.cyY());
        this.iJX.setVisibility(0);
        this.iKs.setVisibility(0);
    }

    private void yK(int i) {
        if (this.iJP != null) {
            this.iJP.setVisibility(i);
        }
    }

    private void czt() {
        this.iJR.setVisibility(0);
        this.iJQ.setVisibility(0);
    }

    public void pA(boolean z) {
        if (this.iKi != null) {
            this.iKi.qc(z);
        }
    }

    private void czu() {
        if (this.iKk == null) {
            View rootView = this.iJK.getRootView();
            this.iKk = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.iKl = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.iKl.setPageId(this.iJK.getUniqueId());
            this.iKk.setLayerType(1, null);
            this.iKl.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View czv() {
        return this.iJO;
    }

    public void g(NoNetworkView.a aVar) {
        this.iEz = aVar;
        if (this.ghD != null) {
            this.ghD.a(this.iEz);
        }
    }

    public void pB(boolean z) {
        if (this.iKi != null) {
            if (z) {
                Y(false, true);
            } else {
                Y(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iJX.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.iJY.a(abVar);
    }

    public void setForumName(String str) {
        this.iJY.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ism);
        if (this.iqn != null) {
            this.iqn.destroy();
        }
        if (this.iKj != null) {
            this.iKj.onDestory();
        }
        if (this.iKy != null) {
            this.iKy.setPageContext(null);
        }
        if (this.iKz != null) {
            this.iKz.setPageContext(null);
        }
        this.iJY.onDestory();
        this.iJX.setOnSrollToBottomListener(null);
        this.iJX.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.iKG);
        if (this.iri != null) {
            this.iri.onDestroy();
        }
        this.iKm.clear();
        if (this.iKh != null) {
            this.iKh.cFz();
        }
        if (this.iKq != null) {
            this.iKq.cBn();
        }
        if (this.iKA != null) {
            this.iKA.onDestroy();
        }
        if (this.iKy != null) {
            this.iKy.onDestroy();
        }
        if (this.iJZ != null) {
            this.iJZ.onDestroy();
        }
    }

    public boolean czw() {
        if (this.Yh == null || this.iKr == null || !this.iKr.isSticky()) {
            return this.iKh != null && this.iKh.czw();
        }
        if (this.iJX != null) {
            this.iJX.setSelection(0);
        }
        this.iKr.expandedAppBarLayout(this.Yh);
        return true;
    }

    public boolean cyQ() {
        if (this.iJZ == null) {
            return false;
        }
        return this.iJZ.cyQ();
    }

    public void bVq() {
        this.iJX.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.iKC.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.iKC.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.iKC.setText(str2);
            com.baidu.tbadk.core.k.bjH().setForumNameForWaterImage(str);
        }
    }

    public void czx() {
        if (this.iJY != null) {
            this.iJY.notifyDataSetChanged();
        }
    }

    public void bar() {
        if (this.iJY instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.iJY).bar();
        }
    }

    private void czy() {
        if (this.iKa == null && this.iJK.getPageContext() != null) {
            String[] strArr = {this.iJK.getPageContext().getPageActivity().getString(R.string.take_photo), this.iJK.getPageContext().getPageActivity().getString(R.string.album)};
            this.iKa = new com.baidu.tbadk.core.dialog.b(this.iJK.getPageContext().getPageActivity());
            this.iKa.Bp(this.iJK.getPageContext().getPageActivity().getString(R.string.operation));
            this.iKa.a(strArr, new b.InterfaceC0576b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.iJK.cyR();
                    } else if (i == 1 && q.this.iJK.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.iJK.getPageContext().getPageActivity());
                    }
                }
            });
            this.iKa.d(this.iJK.getPageContext());
        }
    }

    public void czz() {
        czy();
        if (this.iKa != null) {
            this.iKa.bpe();
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
                if (this.iJK != null && this.iJK.cyg() != null && this.iJK.cyg().cEk() == 0) {
                    sVar.yW(this.iJK.cyg().cEr());
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
                        ((bv) qVar).exA.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.iJY.b(arrayList2, frsViewData);
            if (this.iqn != null && this.iJw != 0) {
                this.iqn.a(this.iJw, this.ghW, this.iKg, true);
            }
            if (this.iJK != null) {
                this.iJK.czb();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.iJX;
    }

    public void czA() {
        this.iJY.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iJK.getPageContext(), 1);
        aVar.a(this.iJX);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.iJK.getForumName());
        hashMap.put("forum_id", this.iJK.getForumId());
        aVar.setParams(hashMap);
        aVar.aB(adVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.iKh != null) {
            this.iKh.cFA();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        yL(TbadkCoreApplication.getInst().getSkinType());
        if (this.iKh != null) {
            this.iKh.cFB();
        }
    }

    public void release() {
        if (this.ghD != null && this.iEz != null) {
            this.ghD.b(this.iEz);
        }
    }

    public ImageView czB() {
        return this.iJR;
    }

    public ImageView czC() {
        return this.iJQ;
    }

    public TextView czD() {
        return this.iJS;
    }

    public View czE() {
        if (this.iJP != null) {
            return this.iJP.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.iJP != null) {
            this.iJP.A(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.iJK, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iJK.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.iKl != null) {
            this.iKl.invalidate();
        }
        if (this.iJY != null) {
            this.iJY.cCf();
            this.iJY.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.iJK.getPageContext(), this.iJL);
        if (this.ghD != null) {
            this.ghD.onChangeSkinType(this.iJK.getPageContext(), i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
            this.gjo.changeSkin(i);
        }
        if (this.iKC != null) {
            this.iKC.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
        yL(i);
        if (this.iKi != null) {
            this.iKi.onChangeSkinType(i);
        }
        if (this.iKh != null) {
            this.iKh.onChangeSkinType(i);
        }
        if (this.iKy != null) {
            this.iKy.onChangeSkinType();
        }
        if (this.iKz != null) {
            this.iKz.onChangeSkinType();
        }
        if (this.iJK != null && this.iJK.cyq()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iJN, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iJN, R.color.cp_bg_line_d);
        }
    }

    private void yL(int i) {
        if (this.iJK != null) {
            yM(i);
        }
    }

    private void yM(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iJK.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iKc, R.color.cp_bg_line_c, i);
            if (this.iJP != null) {
                this.iJP.onChangeSkinType(i);
            }
            if (this.iJR != null) {
                SvgManager.brn().a(this.iJR, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iJQ != null) {
                SvgManager.brn().a(this.iJQ, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bEb, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iKn, R.color.cp_bg_line_h);
        pC(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gQb) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.iKD != 0) {
                    SvgManager.brn().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.brn().a(this.iJR, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.brn().a(this.idZ, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.brn().a(this.iJQ, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iKD = 0;
                }
            } else if (z || this.iKD != 1) {
                SvgManager.brn().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.brn().a(this.iJR, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.brn().a(this.idZ, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.brn().a(this.iJQ, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iKD = 1;
            }
            czF();
        }
    }

    private void czF() {
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
            if (this.iKC != null) {
                this.iKC.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.idZ != null) {
                    this.idZ.setAlpha(f);
                }
                if (this.iea != null) {
                    this.iea.setAlpha(f);
                }
                if (this.iJR != null) {
                    this.iJR.setAlpha(f);
                }
                if (this.iJQ != null) {
                    this.iJQ.setAlpha(f);
                }
            }
            if (this.iJS != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.iJS.setAlpha(f2);
                this.iJS.setClickable(f2 > 0.0f);
            }
            if (this.bEb != null) {
                this.bEb.setAlpha(alpha);
            }
            if (this.iKn != null) {
                this.iKn.setAlpha(alpha);
            }
            if (this.iKc != null) {
                this.iKc.setAlpha(alpha);
            }
        }
    }

    public void bPh() {
        if (this.iJZ != null) {
            this.iJZ.bPh();
        }
    }

    public void pD(boolean z) {
        if (this.iJZ != null) {
            this.iJZ.pD(z);
        }
    }

    public void pE(boolean z) {
        this.iKe = z;
        if (this.iKe) {
            this.gjo.setText(this.iJK.getResources().getString(R.string.load_more));
            if (this.iJX.getChildAt(this.iJX.getChildCount() - 1) == this.gjo.getView()) {
                this.gjo.startLoadData();
                this.iJK.bOI();
                return;
            }
            this.gjo.endLoadData();
            return;
        }
        this.gjo.setText(this.iJK.getResources().getString(R.string.load_more_must_after_delete));
        this.gjo.endLoadData();
    }

    public boolean czG() {
        if (this.iKe) {
            return false;
        }
        this.gjo.setText(this.iJK.getResources().getString(R.string.load_more_must_after_delete));
        this.gjo.endLoadData();
        return true;
    }

    public boolean czH() {
        return this.iJT != null && this.iJW.getVisibility() == 0;
    }

    public void czI() {
        if (this.iJT != null) {
            this.iJU.setVisibility(0);
            this.iJW.setVisibility(8);
            this.iJV.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.iKG, 5000L);
        }
    }

    public void a(cg cgVar) {
        if (this.iJT == null) {
            View rootView = this.iJK.getRootView();
            this.iJT = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.iJT.setVisibility(0);
            this.iJU = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.iJV = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.iJW = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.iJV.setPageId(this.iJK.getUniqueId());
            this.iJW.setPageId(this.iJK.getUniqueId());
            this.iJV.setDefaultBgResource(R.color.common_color_10022);
            this.iJV.setDefaultResource(0);
            this.iJW.setDefaultBgResource(R.color.common_color_10022);
            this.iJW.setDefaultResource(0);
            this.iJU.setOnClickListener(this.iKb);
        }
        this.iJU.setVisibility(0);
        String boR = cgVar.boR();
        String boS = cgVar.boS();
        this.iJV.startLoad(boR, 10, false);
        this.iJW.startLoad(boS, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.iKG, 5000L);
    }

    public void czJ() {
        if (this.iJT != null && this.iJU != null) {
            this.iJU.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al czK() {
        return this.iJY;
    }

    public RelativeLayout cka() {
        return this.iJL;
    }

    public View czL() {
        return this.iKd;
    }

    public void yN(int i) {
        if (this.iJN != null) {
            this.iJN.setVisibility(i);
        }
    }

    public void czM() {
        if (com.baidu.tbadk.n.m.bCu().bCv()) {
            int lastVisiblePosition = this.iJX.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.iJX.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.iKU != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.iKU.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.fvf = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.iKU.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.iKU.startLogPerf();
                    }
                    if (uVar.iKT != null && (uVar.iKT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.iKT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.fvf = true;
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

    public NavigationBar bSH() {
        return this.mNavigationBar;
    }

    public void Wi() {
        this.mHasMore = true;
        this.iJX.setNextPage(this.gjo);
        if (this.iKf > 0) {
            this.gjo.showEmptyView(this.iKf);
        }
        this.gjo.setOnClickListener(null);
        this.gjo.startLoadData();
    }

    public void Wj() {
        this.mHasMore = false;
        this.iJX.setNextPage(this.gjo);
        if (this.iKf > 0) {
            this.gjo.showEmptyView(this.iKf);
        }
        this.gjo.setOnClickListener(null);
        this.gjo.endLoadData();
        this.gjo.setText(this.iJK.getResources().getString(R.string.list_has_no_more));
    }

    public void czN() {
        this.mHasMore = true;
        this.iJX.setNextPage(this.gjo);
        this.gjo.setOnClickListener(this.iKb);
        if (this.iKf > 0) {
            this.gjo.showEmptyView(this.iKf);
        }
        this.gjo.endLoadData();
        this.gjo.setText(this.iJK.getResources().getString(R.string.list_click_load_more));
    }

    public View czO() {
        if (this.gjo == null) {
            return null;
        }
        return this.gjo.getView();
    }

    public void yO(int i) {
        if (this.iKy != null) {
            this.iKy.setVisibility(i);
        }
    }

    public void yP(int i) {
        if (this.iKy != null) {
            this.iKy.setSelectNumber(i);
        }
    }

    public void yQ(int i) {
        if (this.iKz != null) {
            this.iKz.setVisibility(i);
        }
    }

    public void yR(int i) {
        if (this.iKz != null) {
            this.iKz.setMoveNumber(i);
        }
    }

    public boolean czP() {
        return this.iKz != null && this.iKz.cHg();
    }

    public void czQ() {
        if (this.iKz != null) {
            this.iKz.cHh();
        }
    }

    public void bPW() {
        this.mHasMore = false;
        this.iJX.setNextPage(null);
    }

    public boolean czR() {
        return this.gjo.getView().getParent() != null && this.mHasMore;
    }

    public void yS(int i) {
        this.iKf = i;
    }

    public void yT(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.iri == null) {
                    this.iri = new CommonTipView(this.iJK.getActivity());
                }
                this.iri.setText(R.string.frs_login_tip);
                this.iri.b((FrameLayout) czL(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void pF(boolean z) {
        this.mIsBackground = z;
        if (this.iqn != null) {
            boolean z2 = (this.iJK == null || this.iJK.cyj() == null || this.iJK.cyj().cGs() == null) ? true : this.iJK.cyj().cGs().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iqn.sX(false);
                this.iqn.dab();
                return;
            }
            this.iqn.sX(true);
            this.iqn.a(this.iJw, this.ghW, this.iKg, true);
        }
    }

    public void cn(int i, int i2) {
        if (this.iqn != null) {
            this.iqn.a(i, i2, this.iKg, 1);
        }
    }

    public void co(int i, int i2) {
        this.iJw = i;
        this.ghW = i2;
    }

    public void pG(boolean z) {
        this.iKg = z;
    }

    public void yU(int i) {
        if (this.iJX != null && this.iJX.getChildCount() >= 0) {
            if (this.iJX.getFirstVisiblePosition() > 8) {
                this.iJX.scrollToPosition(8);
            }
            this.iJX.smoothScrollToPosition(i);
        }
    }

    public void czS() {
        a(this.iKp, this.iJK.cyS());
        if (this.iJY != null) {
            this.iJY.cCc();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.iJK.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.iKq == null) {
                this.iKq = new com.baidu.tieba.video.f(this.iJK.getActivity(), this.iJL);
            }
            this.iKq.j(postWriteCallBackData);
        }
    }

    public void czT() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.iKH && this.iJK.getActivity() != null && this.iJK.getPageContext() != null) {
            View view = null;
            if (this.iJX != null && (headerViewsCount = this.iJX.getHeaderViewsCount()) < this.iJX.getChildCount()) {
                view = this.iJX.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.iJK.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.iJK.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.iJK.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mi = dVar.mi();
                mi.setShouldCheckLocInWindow(false);
                mi.show(this.iJK.getActivity());
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mi != null) {
                            mi.dismiss();
                        }
                    }
                }, 4000L);
                this.iKH = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.iKy != null) {
            this.iKy.setDeleteCallback(aVar);
        }
    }

    public void czU() {
        if (this.iKy != null) {
            this.iKy.czU();
        }
    }

    public void bIw() {
        if (this.iKy != null) {
            this.iKy.bIw();
        }
    }

    public void aP(String str, int i) {
        if (this.iKB == null) {
            this.iKB = new TextView(this.iJK.getActivity());
            this.iKB.setGravity(19);
            this.iKB.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iJK.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.iJK.getActivity(), R.dimen.ds34), 0);
            this.iKB.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.iJK.getActivity(), R.dimen.tbds112)));
            this.iKB.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.iJK.getActivity(), R.dimen.fontsize30));
            this.iKB.setMaxLines(2);
            this.iKB.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.iKB.setTextColor(ContextCompat.getColor(this.iJK.getActivity(), R.color.cp_cont_a));
        }
        this.iKA.setBackgroundColor(i);
        this.iKB.setText(str);
        this.iKA.a(this.iJK.getActivity(), this.iKB, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Yh != null) {
            this.Yh.setExpanded(z);
        }
    }

    public void czV() {
        if (this.iJZ != null) {
            this.iJZ.startPullRefresh();
        }
    }

    public void GI() {
        if (czK() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = czK().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.eDx != 0 && bvVar.exA != null && this.iJK.cyg() != null && this.iJK.cyg().cDN() != null) {
                            int[] imageWidthAndHeight = bvVar.exA.getImageWidthAndHeight();
                            bvVar.eDx = imageWidthAndHeight[0];
                            bvVar.eDy = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.czK().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iqn.a(q.this.iJw, q.this.ghW, q.this.iKg, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean czW() {
        if (this.iKh == null) {
            return false;
        }
        return this.iKh.czW();
    }

    public Context getContext() {
        if (this.iJK == null) {
            return null;
        }
        return this.iJK.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.iJZ != null) {
            this.iJZ.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.iJZ != null) {
            this.iJZ.startPullRefresh();
        }
    }

    public void czX() {
        if (this.iJZ != null) {
            this.iJZ.czX();
        }
    }

    public void czY() {
        if (this.iJZ != null) {
            this.iJZ.czY();
        }
    }

    public void a(au auVar) {
        if (this.iJZ != null) {
            this.iJZ.a(auVar);
        }
    }

    public void yV(int i) {
        if (this.iJZ != null) {
            this.iJZ.yV(i);
        }
    }

    public com.baidu.tieba.frs.vc.k czZ() {
        return this.iJZ;
    }
}
