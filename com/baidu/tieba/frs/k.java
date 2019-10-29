package com.baidu.tieba.frs;

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
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
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
/* loaded from: classes4.dex */
public class k {
    private AppBarLayout Aa;
    private PbListView dwJ;
    private BdSwipeRefreshLayout dyk;
    private ImageView eWb;
    private NoNetworkView fbw;
    private CommonTipView fgm;
    private com.baidu.adp.widget.ListView.k fhn;
    private View fxA;
    private int fxC;
    private com.baidu.tieba.frs.vc.d fxE;
    private com.baidu.tieba.frs.entelechy.b.c fxF;
    private com.baidu.tieba.frs.vc.j fxG;
    private GifView fxH;
    private TbImageView fxI;
    private HashSet<String> fxJ;
    private com.baidu.tieba.play.m fxK;
    private ObservedChangeLinearLayout fxM;
    private com.baidu.tieba.frs.entelechy.b.a fxN;
    private com.baidu.tieba.video.f fxO;
    private AppBarLayoutStickyBehavior fxP;
    private FrsHeaderViewContainer fxQ;
    private CollapsingToolbarLayout fxR;
    private com.baidu.tieba.frs.vc.f fxV;
    private FrsMultiDelBottomMenuView fxW;
    private NavigationBarCoverTip fxX;
    private TextView fxY;
    private FrsFragment fxh;
    private View fxl;
    private com.baidu.tieba.c.b fxm;
    private ImageView fxn;
    private TextView fxo;
    private ViewStub fxp;
    private BdTypeRecyclerView fxt;
    private com.baidu.tieba.frs.entelechy.a.aa fxu;
    private FloatingAnimationView fxv;
    private com.baidu.tieba.c.c fxw;
    private View.OnClickListener fxy;
    private View fxz;
    private boolean fyd;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean fxg = false;
    private NoPressedRelativeLayout fxi = null;
    private CoordinatorLayout fxj = null;
    private View fxk = null;
    private FrameLayout fxq = null;
    private TbImageView fxr = null;
    private TbImageView fxs = null;
    private com.baidu.tbadk.core.dialog.b fxx = null;
    private NoNetworkView.a fsT = null;
    private boolean fxB = true;
    private boolean mHasMore = true;
    private boolean fxD = false;
    private int fwY = 0;
    private int dvr = 0;
    private View apC = null;
    private View fxL = null;
    private boolean dRp = false;
    private boolean bHX = true;
    private boolean fxS = true;
    private int fxT = -1;
    private int fxU = -1;
    private int fxZ = 0;
    private int fya = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener fhp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.fhn == null) {
                        k.this.fhn = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.fhn.a(k.this.fxt, 2);
                } else if (k.this.fhn != null) {
                    k.this.fhn.jU();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fyb = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fxU != i && Math.abs(i) >= 0 && k.this.bkI() != -1) {
                if (Math.abs(i) >= k.this.bkI()) {
                    if (k.this.fxS) {
                        k.this.fxS = false;
                        k.this.jK(k.this.fxS);
                    }
                } else if (!k.this.fxS) {
                    k.this.fxS = true;
                    k.this.jK(k.this.fxS);
                }
                int bkE = k.this.bkE() + k.this.bkD() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bkE;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fxU - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.qr(Math.abs(bkE - totalScrollRange2));
                        if (k.this.fxL != null) {
                            k.this.fxL.setVisibility(0);
                        }
                    } else if (k.this.fxL != null) {
                        if (k.this.bkC() != UtilHelper.getStatusBarHeight()) {
                            k.this.qr(0);
                        }
                        k.this.fxL.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.dRp) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.jP(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fxU = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable fyc = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.fxp != null) {
                k.this.fxq.setVisibility(0);
                k.this.fxs.setVisibility(0);
                k.this.fxr.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.fxh != null && appBarLayout != null && this.fxh.bjN() != null && this.fxh.getPageContext() != null) {
            int bkD = bkD() + getNavigationBarHeight() + bkE();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bjN = this.fxh.bjN();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fxh.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.fxh.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.fxk.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.fxh != null && this.fxh.bjU();
            if (totalScrollRange <= 0) {
                if (this.fya != 2) {
                    bjN.sb(2);
                }
                this.fya = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bkD) {
                if (this.fya != 1) {
                    bjN.sb(1);
                }
                this.fya = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.fya != 0) {
                    bjN.sb(0);
                }
                this.fya = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.fxh.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.fxk.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bkA() {
        return this.fxM;
    }

    public View vE() {
        return this.apC;
    }

    public View bkB() {
        return this.fxL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkC() {
        if (this.apC == null) {
            return 0;
        }
        return this.apC.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkD() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkE() {
        if (this.fbw == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fbw.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(int i) {
        View vE = vE();
        View bkB = bkB();
        if (UtilHelper.canUseStyleImmersiveSticky() && vE != null && bkB != null && vE.getLayoutParams() != null && bkB.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = vE.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            vE.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bkB.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bkB.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.fxh = null;
        this.fxy = null;
        this.fxC = 0;
        this.fxh = frsFragment;
        this.fxy = onClickListener;
        MessageManager.getInstance().registerListener(this.fhp);
        a(aVar, z);
        this.fxJ = new HashSet<>();
        this.fxC = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxV = fVar;
    }

    private boolean bkF() {
        return this.fxV != null && this.fxV.bqx();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.fxN = aVar;
        View rootView = this.fxh.getRootView();
        if (this.fxi == null) {
            this.fxi = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.fxk == null) {
            this.fxk = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.fxj == null) {
            this.fxj = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.fxA == null) {
            this.fxA = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.fxR == null) {
            this.fxR = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.fxQ == null) {
            this.fxQ = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.fxM == null) {
            this.fxM = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fxM.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fxR.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) rootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.fxh.bkr()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.fxz == null) {
            this.fxz = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bmG = aVar.bmG();
            if (bmG != null) {
                bmG.bP(this.fxz);
            }
        }
        if (this.fxl == null) {
            this.fxl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fxl.setOnClickListener(this.fxy);
            this.mBackImageView = (ImageView) this.fxl.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fxm == null) {
            this.fxm = new com.baidu.tieba.c.b(this.fxh.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fxm.getView(), (View.OnClickListener) null);
            this.eWb = this.fxm.bcd();
            this.fxm.getView().setOnClickListener(this.fxy);
        }
        if (this.fxn == null) {
            this.fxn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.fxn.setOnClickListener(this.fxy);
        }
        if (this.fxo == null) {
            this.fxo = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.fxo.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.fxh.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.fxo.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.d(this.fxo, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.fxo, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.fxh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.fxh.getPageContext());
        }
        this.mPullView.setTag(this.fxh.getUniqueId());
        if (this.dyk == null) {
            this.dyk = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.dyk.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.dyk, R.color.cp_bg_line_c);
        }
        if (this.fxt == null) {
            this.fxt = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int fyg = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.fyg--;
                if (this.fyg == 0) {
                    k.this.fxt.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.fyg++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.fxt.setItemAnimator(defaultItemAnimator);
        this.fxt.setLayoutManager(new LinearLayoutManager(this.fxt.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fhn = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.fhn.a(this.fxt, 2);
        }
        this.fxt.setScrollable(this.fxh);
        this.fxt.setFadingEdgeLength(0);
        this.fxt.setOverScrollMode(2);
        this.fxi.setBottomOrderView(this.fxt);
        this.fxt.setOnTouchListener(this.fxh.cAp);
        this.fxt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.fxK != null) {
                    k.this.fxK.ck(view);
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
        if (this.dwJ == null) {
            this.dwJ = new PbListView(this.fxh.getPageContext().getPageActivity());
            this.dwJ.getView();
        }
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.dwJ.setHeight(com.baidu.adp.lib.util.l.getDimens(this.fxh.getActivity(), R.dimen.tbds182));
        this.dwJ.setLineGone();
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fxt.setOnSrollToBottomListener(this.fxh);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.fxh.bkl();
                if (k.this.fxh != null && k.this.Aa != null) {
                    k.this.fxh.bkt();
                    k.this.Aa.setExpanded(true);
                    if (k.this.fxK != null) {
                        k.this.fxK.c(k.this.fwY, k.this.dvr, false, true);
                    }
                }
            }
        });
        boolean isFrsShowBigImage = com.baidu.tbadk.core.util.ar.amO().isFrsShowBigImage();
        if (this.fxu == null) {
            this.fxu = aVar.a(this.fxh, this.fxt, isFrsShowBigImage);
        }
        fU(false);
        if (!z) {
            if (this.fbw == null) {
                this.fbw = new NoNetworkView(this.fxh.getActivity());
                this.fbw.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fxM.addView(this.fbw);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fbw.setVisibility(8);
            } else {
                this.fbw.setVisibility(0);
            }
            this.fbw.onChangeSkinType(this.fxh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bkP();
        if (this.fxE == null) {
            this.fxE = aVar.a(this.fxh, this.fxi);
            this.fxE.b(this.fxh.bku());
        }
        if (this.fxF == null) {
            this.fxF = aVar.b(this.fxh, this.fxi);
            jN(true);
        }
        if (this.apC == null) {
            this.apC = rootView.findViewById(R.id.statebar_view);
        }
        if (this.fxL == null) {
            this.fxL = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.fxK == null) {
            this.fxK = new com.baidu.tieba.play.m(this.fxh.getPageContext(), this.fxt);
        }
        this.fxK.setUniqueId(this.fxh.getUniqueId());
        this.fxX = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.fxG == null) {
            this.fxG = new com.baidu.tieba.frs.vc.j(this.fxh, this.fxX);
        }
        if (this.Aa == null) {
            this.Aa = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Aa.addOnOffsetChangedListener(this.fyb);
            this.fxS = true;
            this.fxT = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Aa.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.fxP = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.fxW = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.fxW.setPageContext(this.fxh.getPageContext());
        this.fxv = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.fxv.setPageId(this.fxh.getUniqueId());
        this.fxw = new com.baidu.tieba.c.c(this.fxh.getTbPageContext(), this.fxv, 2);
    }

    public void jJ(boolean z) {
        if (z && this.fxw != null) {
            this.fxw.aHJ();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.fxw != null) {
            this.fxw.a(oVar);
        }
    }

    private void bkG() {
        ViewGroup.LayoutParams layoutParams;
        this.dRp = bkF();
        if (this.fxQ != null && (layoutParams = this.fxQ.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.dRp) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bkD(), 0, 0);
            }
            this.fxQ.requestLayout();
        }
    }

    public void bkH() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fxM != null) {
            bkG();
            if (this.dRp) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.apC != null) {
                    this.apC.setAlpha(1.0f);
                }
                if (this.fxL != null) {
                    this.fxL.setAlpha(1.0f);
                }
                if (this.mNavigationBar.mCenterText != null) {
                    this.mNavigationBar.mCenterText.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jK(boolean z) {
        if (z && this.fxh != null && this.fxh.bjM() != null) {
            this.fxh.bjM().bqC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkI() {
        int i;
        if (this.Aa == null) {
            return this.fxT;
        }
        if (this.fxT != -1) {
            return this.fxT;
        }
        int childCount = this.Aa.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Aa.getChildAt(childCount);
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
        this.fxT = Math.max(0, this.Aa.getTotalScrollRange() - Math.abs(i2));
        return this.fxT;
    }

    public void vN(String str) {
        if (this.fxG != null) {
            this.fxG.vN(str);
        }
    }

    public com.baidu.tieba.play.m bkJ() {
        return this.fxK;
    }

    public com.baidu.tieba.frs.entelechy.b.c bkK() {
        return this.fxF;
    }

    public void jL(boolean z) {
        if (this.fxE != null) {
            this.fxE.jL(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bkL() {
        return this.fxE;
    }

    public void K(boolean z, boolean z2) {
        if (this.bHX && this.fxF != null) {
            this.fxF.K(z, z2);
        }
    }

    public void jM(boolean z) {
        this.bHX = z;
        if (!this.bHX && this.fxF != null) {
            this.fxF.K(false, false);
        }
    }

    public void bkM() {
        if (this.bHX && this.fxF != null) {
            this.fxF.K(false, false);
        }
        qs(8);
        this.fxn.setVisibility(8);
        jL(false);
        this.fxt.setVisibility(8);
        this.fxQ.setVisibility(8);
    }

    public void bkN() {
        if (this.bHX && this.fxF != null) {
            this.fxF.K(true, false);
        }
        qs(0);
        bkO();
        jL(this.fxh.bkw());
        this.fxt.setVisibility(0);
        this.fxQ.setVisibility(0);
    }

    private void qs(int i) {
        if (this.fxm != null) {
            this.fxm.setVisibility(i);
        }
    }

    private void bkO() {
        this.fxn.setVisibility(0);
    }

    public void jN(boolean z) {
        if (this.fxF != null) {
            this.fxF.kp(z);
        }
    }

    private void bkP() {
        if (this.fxH == null) {
            View rootView = this.fxh.getRootView();
            this.fxH = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.fxI = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.fxI.setPageId(this.fxh.getUniqueId());
            this.fxH.setLayerType(1, null);
            this.fxI.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bkQ() {
        return this.fxl;
    }

    public void h(NoNetworkView.a aVar) {
        this.fsT = aVar;
        if (this.fbw != null) {
            this.fbw.a(this.fsT);
        }
    }

    public void fU(boolean z) {
        this.fxg = z;
        if (z) {
            if (this.fxF != null) {
                this.fxF.bnj();
                return;
            }
            return;
        }
        this.fxt.getAdapter().notifyDataSetChanged();
        if (this.fxF != null) {
            this.fxF.bnk();
        }
    }

    public void jO(boolean z) {
        if (this.fxF != null) {
            if (z) {
                K(false, true);
            } else {
                K(false, false);
            }
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(h.d dVar) {
        this.mPullView.a(dVar);
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.fxt.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.fxu.a(sVar);
    }

    public void setForumName(String str) {
        this.fxu.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fhp);
        if (this.fxK != null) {
            this.fxK.destroy();
        }
        if (this.fxG != null) {
            this.fxG.onDestory();
        }
        if (this.fxW != null) {
            this.fxW.setPageContext(null);
        }
        this.fxu.onDestory();
        this.fxt.setOnSrollToBottomListener(null);
        this.fxt.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.fyc);
        if (this.fgm != null) {
            this.fgm.onDestroy();
        }
        this.fxJ.clear();
        if (this.fxE != null) {
            this.fxE.bqo();
        }
        if (this.fxO != null) {
            this.fxO.bmv();
        }
        if (this.fxw != null) {
            this.fxw.onDestroy();
        }
        if (this.fxX != null) {
            this.fxX.onDestroy();
        }
        if (this.fxW != null) {
            this.fxW.onDestroy();
        }
    }

    public boolean bkR() {
        if (this.Aa == null || this.fxP == null || !this.fxP.isSticky()) {
            return this.fxE != null && this.fxE.bkR();
        }
        if (this.fxt != null) {
            this.fxt.setSelection(0);
        }
        this.fxP.expandedAppBarLayout(this.Aa);
        return true;
    }

    public boolean bkq() {
        return this.fxg;
    }

    public void aMq() {
        this.fxt.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.mNavigationBar.getCenterTextTitleText())) {
            if (TextUtils.isEmpty(str)) {
                this.mNavigationBar.setCenterTextTitle("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.mNavigationBar.setCenterTextTitle(str2);
            com.baidu.tbadk.core.i.agq().setForumNameForWaterImage(str);
        }
    }

    public void bkS() {
        if (this.fxu != null) {
            this.fxu.notifyDataSetChanged();
        }
    }

    public void aaQ() {
        if (this.fxu instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.fxu).aaQ();
        }
    }

    private void bkT() {
        if (this.fxx == null && this.fxh.getPageContext() != null) {
            String[] strArr = {this.fxh.getPageContext().getPageActivity().getString(R.string.take_photo), this.fxh.getPageContext().getPageActivity().getString(R.string.album)};
            this.fxx = new com.baidu.tbadk.core.dialog.b(this.fxh.getPageContext().getPageActivity());
            this.fxx.no(this.fxh.getPageContext().getPageActivity().getString(R.string.operation));
            this.fxx.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.fxh.takePhoto();
                    } else if (i == 1 && k.this.fxh.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(k.this.fxh.getPageContext().getPageActivity());
                    }
                }
            });
            this.fxx.d(this.fxh.getPageContext());
        }
    }

    public void bkU() {
        bkT();
        if (this.fxx != null) {
            this.fxx.akP();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.isEmpty(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            if (this.fxh != null && this.fxh.bjK() != null && this.fxh.bjK().bpi() == 0) {
                mVar.qB(this.fxh.bjK().bpp());
            }
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null) {
            this.mIsPrivateForum = frsViewData.isPrivateForum();
        }
        if (com.baidu.tbadk.core.util.v.getCount(arrayList2) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList2.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar2 = arrayList2.get(i2);
                if (mVar2 instanceof bg) {
                    ((bg) mVar2).cbq.setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.fxu.b(arrayList2, frsViewData);
        if (this.fxK != null && this.fwY != 0) {
            this.fxK.c(this.fwY, this.dvr, this.fxD, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fxt;
    }

    public void bkV() {
        this.fxu.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fxh.getPageContext(), 1);
        aVar.a(this.fxt);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.fxh.getForumName());
        hashMap.put("forum_id", this.fxh.getForumId());
        aVar.setParams(hashMap);
        aVar.ag(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.fxE != null) {
            this.fxE.bqp();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        qt(TbadkCoreApplication.getInst().getSkinType());
        if (this.fxE != null) {
            this.fxE.bqq();
        }
    }

    public void release() {
        if (this.fbw != null && this.fsT != null) {
            this.fbw.b(this.fsT);
        }
    }

    public ImageView bkW() {
        return this.fxn;
    }

    public TextView bkX() {
        return this.fxo;
    }

    public View bkY() {
        if (this.fxm != null) {
            return this.fxm.getView();
        }
        return null;
    }

    public void C(int i, boolean z) {
        if (this.fxm != null) {
            this.fxm.m(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fxh, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fxh.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.fxI != null) {
            this.fxI.invalidate();
        }
        if (this.fxu != null) {
            this.fxu.bnd();
            this.fxu.notifyDataSetChanged();
        }
        com.baidu.tbadk.s.a.a(this.fxh.getPageContext(), this.fxi);
        if (this.fbw != null) {
            this.fbw.onChangeSkinType(this.fxh.getPageContext(), i);
        }
        if (this.dwJ != null) {
            this.dwJ.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.dwJ.changeSkin(i);
        }
        qt(i);
        if (this.fxF != null) {
            this.fxF.onChangeSkinType(i);
        }
        if (this.fxE != null) {
            this.fxE.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fxW != null) {
            this.fxW.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.dyk, R.color.cp_bg_line_d);
        if (this.fxh != null && this.fxh.bjU()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.fxk, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.fxk, R.color.cp_bg_line_d);
        }
    }

    private void qt(int i) {
        if (this.fxh != null) {
            qu(i);
        }
    }

    private void qu(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fxh.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.fxz, R.color.cp_bg_line_c, i);
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.apC, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.fxL, R.color.cp_bg_line_h);
        jP(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dRp) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.fxZ != 0) {
                    SvgManager.amN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.amN().a(this.fxn, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.amN().a(this.eWb, R.drawable.icon_pure_topbar_information_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.fxZ = 0;
                }
            } else if (z || this.fxZ != 1) {
                SvgManager.amN().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.amN().a(this.fxn, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.amN().a(this.eWb, R.drawable.icon_pure_topbar_information_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.fxZ = 1;
            }
            bkZ();
        }
    }

    private void bkZ() {
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
            if (this.mNavigationBar.mCenterText != null) {
                this.mNavigationBar.mCenterText.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.eWb != null) {
                    this.eWb.setAlpha(f);
                }
                if (this.fxn != null) {
                    this.fxn.setAlpha(f);
                }
            }
            if (this.fxo != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.fxo.setAlpha(f2);
                this.fxo.setClickable(f2 > 0.0f);
            }
            if (this.apC != null) {
                this.apC.setAlpha(alpha);
            }
            if (this.fxL != null) {
                this.fxL.setAlpha(alpha);
            }
            if (this.fxz != null) {
                this.fxz.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.fxt != null) {
            this.fxt.setSelection(0);
        }
        if (this.Aa != null) {
            this.Aa.setExpanded(true);
        }
        if (this.dyk != null && this.dyk.isEnabled()) {
            this.dyk.setRefreshing(true);
        }
    }

    public void jQ(boolean z) {
        if (z) {
            this.dyk.setRefreshing(false);
        } else {
            this.dyk.interruptRefresh();
        }
    }

    public void jR(boolean z) {
        this.dyk.setEnabled(z);
    }

    public void jS(boolean z) {
        this.fxB = z;
        if (this.fxB) {
            this.dwJ.setText(this.fxh.getResources().getString(R.string.load_more));
            if (this.fxt.getChildAt(this.fxt.getChildCount() - 1) == this.dwJ.getView()) {
                this.dwJ.startLoadData();
                this.fxh.aIW();
                return;
            }
            this.dwJ.endLoadData();
            return;
        }
        this.dwJ.setText(this.fxh.getResources().getString(R.string.load_more_must_after_delete));
        this.dwJ.endLoadData();
    }

    public boolean bla() {
        if (this.fxB) {
            return false;
        }
        this.dwJ.setText(this.fxh.getResources().getString(R.string.load_more_must_after_delete));
        this.dwJ.endLoadData();
        return true;
    }

    public boolean blb() {
        return this.fxp != null && this.fxs.getVisibility() == 0;
    }

    public void blc() {
        if (this.fxp != null) {
            this.fxq.setVisibility(0);
            this.fxs.setVisibility(8);
            this.fxr.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.fyc, 5000L);
        }
    }

    public void a(bo boVar) {
        if (this.fxp == null) {
            View rootView = this.fxh.getRootView();
            this.fxp = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.fxp.setVisibility(0);
            this.fxq = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.fxr = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.fxs = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.fxr.setPageId(this.fxh.getUniqueId());
            this.fxs.setPageId(this.fxh.getUniqueId());
            this.fxr.setDefaultBgResource(R.color.common_color_10022);
            this.fxr.setDefaultResource(0);
            this.fxs.setDefaultBgResource(R.color.common_color_10022);
            this.fxs.setDefaultResource(0);
            this.fxq.setOnClickListener(this.fxy);
        }
        this.fxq.setVisibility(0);
        String akH = boVar.akH();
        String akI = boVar.akI();
        this.fxr.startLoad(akH, 10, false);
        this.fxs.startLoad(akI, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.fyc, 5000L);
    }

    public void bld() {
        if (this.fxp != null && this.fxq != null) {
            this.fxq.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.aa ble() {
        return this.fxu;
    }

    public RelativeLayout aYd() {
        return this.fxi;
    }

    public View blf() {
        return this.fxA;
    }

    public void qv(int i) {
        if (this.fxk != null) {
            this.fxk.setVisibility(i);
        }
    }

    public void blg() {
        if (com.baidu.tbadk.p.m.awN().awO()) {
            int lastVisiblePosition = this.fxt.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fxt.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fyr != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.fyr.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.cLY = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fyr.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fyr.startLogPerf();
                    }
                    if (oVar.fyq != null && (oVar.fyq instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fyq;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.cLY = true;
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

    public NavigationBar aKR() {
        return this.mNavigationBar;
    }

    public void aKi() {
        this.mHasMore = true;
        this.fxt.setNextPage(this.dwJ);
        if (this.fxC > 0) {
            this.dwJ.showEmptyView(this.fxC);
        }
        this.dwJ.setOnClickListener(null);
        this.dwJ.startLoadData();
    }

    public void aKj() {
        this.mHasMore = false;
        this.fxt.setNextPage(this.dwJ);
        if (this.fxC > 0) {
            this.dwJ.showEmptyView(this.fxC);
        }
        this.dwJ.setOnClickListener(null);
        this.dwJ.endLoadData();
        this.dwJ.setText(this.fxh.getResources().getString(R.string.list_has_no_more));
    }

    public void blh() {
        this.mHasMore = true;
        this.fxt.setNextPage(this.dwJ);
        this.dwJ.setOnClickListener(this.fxy);
        if (this.fxC > 0) {
            this.dwJ.showEmptyView(this.fxC);
        }
        this.dwJ.endLoadData();
        this.dwJ.setText(this.fxh.getResources().getString(R.string.list_click_load_more));
    }

    public View bli() {
        if (this.dwJ == null) {
            return null;
        }
        return this.dwJ.getView();
    }

    public void qw(int i) {
        if (this.fxW != null) {
            this.fxW.setVisibility(i);
        }
    }

    public void qx(int i) {
        if (this.fxW != null) {
            this.fxW.setSelectNumber(i);
        }
    }

    public void aKk() {
        this.mHasMore = false;
        this.fxt.setNextPage(null);
    }

    public boolean bbw() {
        return this.dwJ.getView().getParent() != null && this.mHasMore;
    }

    public void qy(int i) {
        this.fxC = i;
    }

    public void qz(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.fgm == null) {
                    this.fgm = new CommonTipView(this.fxh.getActivity());
                }
                this.fgm.setText(R.string.frs_login_tip);
                this.fgm.b((FrameLayout) blf(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void jT(boolean z) {
        this.mIsBackground = z;
        if (this.fxK != null) {
            boolean z2 = (this.fxh == null || this.fxh.bjN() == null || this.fxh.bjN().bqU() == null) ? true : this.fxh.bjN().bqU().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.fxK.mY(false);
                this.fxK.bIW();
                return;
            }
            this.fxK.mY(true);
            this.fxK.c(this.fwY, this.dvr, this.fxD, true);
        }
    }

    public void bn(int i, int i2) {
        if (this.fxK != null) {
            this.fxK.a(i, i2, this.fxD, 1);
        }
    }

    public void bo(int i, int i2) {
        this.fwY = i;
        this.dvr = i2;
    }

    public void jU(boolean z) {
        this.fxD = z;
    }

    public void qA(int i) {
        if (this.fxt != null && this.fxt.getChildCount() >= 0) {
            if (this.fxt.getFirstVisiblePosition() > 8) {
                this.fxt.scrollToPosition(8);
            }
            this.fxt.smoothScrollToPosition(i);
        }
    }

    public void blj() {
        a(this.fxN, this.fxh.bkr());
        if (this.fxu != null) {
            this.fxu.bna();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.fxO == null) {
                this.fxO = new com.baidu.tieba.video.f(this.fxh.getActivity(), this.fxi);
            }
            this.fxO.h(postWriteCallBackData);
        }
    }

    public void blk() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.fyd && this.fxh.getActivity() != null && this.fxh.getPageContext() != null) {
            View view = null;
            if (this.fxt != null && (headerViewsCount = this.fxt.getHeaderViewsCount()) < this.fxt.getChildCount()) {
                view = this.fxt.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).I(0).B(true).C(false).A(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        k.this.fxh.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(k.this.fxh.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(k.this.fxh.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c fu = dVar.fu();
                fu.setShouldCheckLocInWindow(false);
                fu.show(this.fxh.getActivity());
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fu != null) {
                            fu.dismiss();
                        }
                    }
                }, 4000L);
                this.fyd = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.fxW != null) {
            this.fxW.setDeleteCallback(aVar);
        }
    }

    public void bll() {
        if (this.fxW != null) {
            this.fxW.bll();
        }
    }

    public void aBO() {
        if (this.fxW != null) {
            this.fxW.aBO();
        }
    }

    public void ar(String str, int i) {
        if (this.fxY == null) {
            this.fxY = new TextView(this.fxh.getActivity());
            this.fxY.setGravity(19);
            this.fxY.setPadding(com.baidu.adp.lib.util.l.getDimens(this.fxh.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.fxh.getActivity(), R.dimen.ds34), 0);
            this.fxY.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.fxh.getActivity(), R.dimen.tbds112)));
            this.fxY.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.fxh.getActivity(), R.dimen.fontsize30));
            this.fxY.setMaxLines(2);
            this.fxY.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.fxY.setTextColor(ContextCompat.getColor(this.fxh.getActivity(), R.color.cp_cont_a));
        }
        this.fxX.setBackgroundColor(i);
        this.fxY.setText(str);
        this.fxX.a(this.fxh.getActivity(), this.fxY, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Aa != null) {
            this.Aa.setExpanded(z);
        }
    }

    public void blm() {
        if (this.Aa != null && this.fxt != null) {
            int count = this.fxt.getCount();
            if (this.fxt.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.Aa.setExpanded(true, true);
            }
        }
    }

    public void bln() {
        if (this.mPullView != null) {
            this.mPullView.anQ();
        }
        startPullRefresh();
    }

    public void pC() {
        if (ble() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = ble().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bg) {
                        bg bgVar = (bg) mVar;
                        if (bgVar.cbr != 0 && bgVar.cbq != null && this.fxh.bjK() != null && this.fxh.bjK().boM() != null) {
                            int[] imageWidthAndHeight = this.fxh.bjK().boM().imageWidthAndHeight(bgVar.cbq);
                            bgVar.cbr = imageWidthAndHeight[0];
                            bgVar.cbs = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.5
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.ble().notifyDataSetChanged();
                        if (!k.this.mIsBackground) {
                            k.this.fxK.c(k.this.fwY, k.this.dvr, k.this.fxD, true);
                        }
                    }
                }, 500L);
            }
        }
    }
}
