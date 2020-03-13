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
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
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
public class l {
    private AppBarLayout CD;
    private PbListView elw;
    private BdSwipeRefreshLayout enH;
    private ImageView fPK;
    private NoNetworkView fVd;
    private CommonTipView fZx;
    private com.baidu.adp.widget.ListView.k gax;
    private FloatingAnimationView gqA;
    private com.baidu.tieba.c.c gqB;
    private View.OnClickListener gqD;
    private View gqE;
    private View gqF;
    private int gqH;
    private com.baidu.tieba.frs.vc.d gqJ;
    private com.baidu.tieba.frs.entelechy.b.c gqK;
    private com.baidu.tieba.frs.vc.l gqL;
    private GifView gqM;
    private TbImageView gqN;
    private HashSet<String> gqO;
    private com.baidu.tieba.play.m gqP;
    private ObservedChangeLinearLayout gqR;
    private com.baidu.tieba.frs.entelechy.b.a gqS;
    private com.baidu.tieba.video.f gqT;
    private AppBarLayoutStickyBehavior gqU;
    private FrsHeaderViewContainer gqV;
    private CollapsingToolbarLayout gqW;
    private FrsFragment gqm;
    private View gqq;
    private com.baidu.tieba.c.b gqr;
    private ImageView gqs;
    private TextView gqt;
    private ViewStub gqu;
    private BdTypeRecyclerView gqy;
    private com.baidu.tieba.frs.entelechy.a.af gqz;
    private com.baidu.tieba.frs.vc.h gra;
    private FrsMultiDelBottomMenuView grb;
    private NavigationBarCoverTip grc;
    private TextView grd;
    private boolean gri;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean gql = false;
    private NoPressedRelativeLayout gqn = null;
    private CoordinatorLayout gqo = null;
    private View gqp = null;
    private FrameLayout gqv = null;
    private TbImageView gqw = null;
    private TbImageView gqx = null;
    private com.baidu.tbadk.core.dialog.b gqC = null;
    private NoNetworkView.a glY = null;
    private boolean gqG = true;
    private boolean mHasMore = true;
    private boolean gqI = false;
    private int gqd = 0;
    private int eke = 0;
    private View aCc = null;
    private View gqQ = null;
    private boolean eLt = false;
    private boolean cwL = true;
    private boolean gqX = true;
    private int gqY = -1;
    private int gqZ = -1;
    private int gre = 0;
    private int grf = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener gaz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (l.this.gax == null) {
                        l.this.gax = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    l.this.gax.a(l.this.gqy, 2);
                } else if (l.this.gax != null) {
                    l.this.gax.kB();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener grg = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.l.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            l.this.a(appBarLayout, i);
            if (l.this.gqZ != i && Math.abs(i) >= 0 && l.this.bEK() != -1) {
                if (Math.abs(i) >= l.this.bEK()) {
                    if (l.this.gqX) {
                        l.this.gqX = false;
                        l.this.lk(l.this.gqX);
                    }
                } else if (!l.this.gqX) {
                    l.this.gqX = true;
                    l.this.lk(l.this.gqX);
                }
                int bEG = l.this.bEG() + l.this.bEF() + l.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bEG;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && l.this.gqZ - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        l.this.sH(Math.abs(bEG - totalScrollRange2));
                        if (l.this.gqQ != null) {
                            l.this.gqQ.setVisibility(0);
                        }
                    } else if (l.this.gqQ != null) {
                        if (l.this.bEE() != UtilHelper.getStatusBarHeight()) {
                            l.this.sH(0);
                        }
                        l.this.gqQ.setVisibility(8);
                    }
                    if (l.this.mNavigationBar != null) {
                        if (l.this.eLt) {
                            l.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            l.this.lp(false);
                        } else if (l.this.mNavigationBar.mCenterText != null) {
                            l.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    l.this.gqZ = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable grh = new Runnable() { // from class: com.baidu.tieba.frs.l.13
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.gqu != null) {
                l.this.gqv.setVisibility(0);
                l.this.gqx.setVisibility(0);
                l.this.gqw.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.gqm != null && appBarLayout != null && this.gqm.bDO() != null && this.gqm.getPageContext() != null) {
            int bEF = bEF() + getNavigationBarHeight() + bEG();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bDO = this.gqm.bDO();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.gqm.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.gqm.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.gqp.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.gqm != null && this.gqm.bDV();
            if (totalScrollRange <= 0) {
                if (this.grf != 2) {
                    bDO.ut(2);
                }
                this.grf = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bEF) {
                if (this.grf != 1) {
                    bDO.ut(1);
                }
                this.grf = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.grf != 0) {
                    bDO.ut(0);
                }
                this.grf = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.gqm.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.gqp.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bEC() {
        return this.gqR;
    }

    public View Am() {
        return this.aCc;
    }

    public View bED() {
        return this.gqQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEE() {
        if (this.aCc == null) {
            return 0;
        }
        return this.aCc.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEF() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEG() {
        if (this.fVd == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fVd.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH(int i) {
        View Am = Am();
        View bED = bED();
        if (UtilHelper.canUseStyleImmersiveSticky() && Am != null && bED != null && Am.getLayoutParams() != null && bED.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Am.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Am.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bED.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bED.setLayoutParams(layoutParams2);
        }
    }

    public l(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.gqm = null;
        this.gqD = null;
        this.gqH = 0;
        this.gqm = frsFragment;
        this.gqD = onClickListener;
        MessageManager.getInstance().registerListener(this.gaz);
        a(aVar, z);
        this.gqO = new HashSet<>();
        this.gqH = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.gra = hVar;
    }

    private boolean bEH() {
        return this.gra != null && this.gra.bKF();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.gqS = aVar;
        View rootView = this.gqm.getRootView();
        if (this.gqn == null) {
            this.gqn = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.gqp == null) {
            this.gqp = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.gqo == null) {
            this.gqo = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.gqF == null) {
            this.gqF = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.gqW == null) {
            this.gqW = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.gqV == null) {
            this.gqV = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.gqR == null) {
            this.gqR = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.gqR.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.l.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        l.this.gqW.setMinimumHeight(i2);
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
        if (this.gqm.bEt()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.gqE == null) {
            this.gqE = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bGI = aVar.bGI();
            if (bGI != null) {
                bGI.bP(this.gqE);
            }
        }
        if (this.gqq == null) {
            this.gqq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gqq.setOnClickListener(this.gqD);
            this.mBackImageView = (ImageView) this.gqq.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gqr == null) {
            this.gqr = new com.baidu.tieba.c.b(this.gqm.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gqr.getView(), (View.OnClickListener) null);
            this.fPK = this.gqr.bwh();
            this.gqr.getView().setOnClickListener(this.gqD);
        }
        if (this.gqs == null) {
            this.gqs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.gqs.setOnClickListener(this.gqD);
        }
        if (this.gqt == null) {
            this.gqt = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.gqt.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.gqm.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.gqt.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.c(this.gqt, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gqt, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.gqm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.gqm.getPageContext());
        }
        this.mPullView.setTag(this.gqm.getUniqueId());
        if (this.enH == null) {
            this.enH = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.enH.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.enH, R.color.cp_bg_line_c);
        }
        if (this.gqy == null) {
            this.gqy = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.l.8
            int grl = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.grl--;
                if (this.grl == 0) {
                    l.this.gqy.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.grl++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.gqy.setItemAnimator(defaultItemAnimator);
        this.gqy.setLayoutManager(new LinearLayoutManager(this.gqy.getContext()) { // from class: com.baidu.tieba.frs.l.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gax = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.gax.a(this.gqy, 2);
        }
        this.gqy.setScrollable(this.gqm);
        this.gqy.setFadingEdgeLength(0);
        this.gqy.setOverScrollMode(2);
        this.gqn.setBottomOrderView(this.gqy);
        this.gqy.setOnTouchListener(this.gqm.drN);
        this.gqy.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.l.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (l.this.gqP != null) {
                    l.this.gqP.cl(view);
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
        if (this.elw == null) {
            this.elw = new PbListView(this.gqm.getPageContext().getPageActivity());
            this.elw.getView();
        }
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.elw.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gqm.getActivity(), R.dimen.tbds182));
        this.elw.setLineGone();
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gqy.setOnSrollToBottomListener(this.gqm);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.l.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.gqm.bEm();
                if (l.this.gqm != null && l.this.CD != null) {
                    l.this.gqm.bEv();
                    l.this.CD.setExpanded(true);
                    if (l.this.gqP != null) {
                        l.this.gqP.a(l.this.gqd, l.this.eke, false, true);
                    }
                }
            }
        });
        boolean aGE = com.baidu.tbadk.core.util.ar.aGD().aGE();
        if (this.gqz == null) {
            this.gqz = aVar.a(this.gqm, this.gqy, aGE);
        }
        hu(false);
        if (!z) {
            if (this.fVd == null) {
                this.fVd = new NoNetworkView(this.gqm.getActivity());
                this.fVd.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.gqR.addView(this.fVd);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fVd.setVisibility(8);
            } else {
                this.fVd.setVisibility(0);
            }
            this.fVd.onChangeSkinType(this.gqm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bER();
        if (this.gqJ == null) {
            this.gqJ = aVar.a(this.gqm, this.gqn);
            this.gqJ.b(this.gqm.bEw());
        }
        if (this.gqK == null) {
            this.gqK = aVar.b(this.gqm, this.gqn);
            ln(true);
        }
        if (this.aCc == null) {
            this.aCc = rootView.findViewById(R.id.statebar_view);
        }
        if (this.gqQ == null) {
            this.gqQ = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.gqP == null) {
            this.gqP = new com.baidu.tieba.play.m(this.gqm.getPageContext(), this.gqy);
        }
        this.gqP.Ar(1);
        this.gqP.setUniqueId(this.gqm.getUniqueId());
        this.grc = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.gqL == null) {
            this.gqL = new com.baidu.tieba.frs.vc.l(this.gqm, this.grc);
        }
        if (this.CD == null) {
            this.CD = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.CD.addOnOffsetChangedListener(this.grg);
            this.gqX = true;
            this.gqY = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.gqU = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.grb = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.grb.setPageContext(this.gqm.getPageContext());
        this.gqA = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.gqA.setPageId(this.gqm.getUniqueId());
        this.gqB = new com.baidu.tieba.c.c(this.gqm.getTbPageContext(), this.gqA, 2);
    }

    public void onPrimary(boolean z) {
        if (z && this.gqB != null) {
            this.gqB.baD();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.gqB != null) {
            this.gqB.a(oVar);
        }
    }

    private void bEI() {
        ViewGroup.LayoutParams layoutParams;
        this.eLt = bEH();
        if (this.gqV != null && (layoutParams = this.gqV.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.eLt) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bEF(), 0, 0);
            }
            this.gqV.requestLayout();
        }
    }

    public void bEJ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gqR != null) {
            bEI();
            if (this.eLt) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.aCc != null) {
                    this.aCc.setAlpha(1.0f);
                }
                if (this.gqQ != null) {
                    this.gqQ.setAlpha(1.0f);
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
    public void lk(boolean z) {
        if (z && this.gqm != null && this.gqm.bDN() != null) {
            this.gqm.bDN().bKJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEK() {
        int i;
        if (this.CD == null) {
            return this.gqY;
        }
        if (this.gqY != -1) {
            return this.gqY;
        }
        int childCount = this.CD.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.CD.getChildAt(childCount);
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
        this.gqY = Math.max(0, this.CD.getTotalScrollRange() - Math.abs(i2));
        return this.gqY;
    }

    public void Bf(String str) {
        if (this.gqL != null) {
            this.gqL.Bf(str);
        }
    }

    public com.baidu.tieba.play.m bEL() {
        return this.gqP;
    }

    public com.baidu.tieba.frs.entelechy.b.c bEM() {
        return this.gqK;
    }

    public void ll(boolean z) {
        if (this.gqJ != null) {
            this.gqJ.ll(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bEN() {
        return this.gqJ;
    }

    public void M(boolean z, boolean z2) {
        if (this.cwL && this.gqK != null) {
            this.gqK.M(z, z2);
        }
    }

    public void lm(boolean z) {
        this.cwL = z;
        if (!this.cwL && this.gqK != null) {
            this.gqK.M(false, false);
        }
    }

    public void bEO() {
        if (this.cwL && this.gqK != null) {
            this.gqK.M(false, false);
        }
        sI(8);
        this.gqs.setVisibility(8);
        ll(false);
        this.gqy.setVisibility(8);
        this.gqV.setVisibility(8);
    }

    public void bEP() {
        if (this.cwL && this.gqK != null) {
            this.gqK.M(true, false);
        }
        sI(0);
        bEQ();
        ll(this.gqm.bEy());
        this.gqy.setVisibility(0);
        this.gqV.setVisibility(0);
    }

    private void sI(int i) {
        if (this.gqr != null) {
            this.gqr.setVisibility(i);
        }
    }

    private void bEQ() {
        this.gqs.setVisibility(0);
    }

    public void ln(boolean z) {
        if (this.gqK != null) {
            this.gqK.lP(z);
        }
    }

    private void bER() {
        if (this.gqM == null) {
            View rootView = this.gqm.getRootView();
            this.gqM = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.gqN = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.gqN.setPageId(this.gqm.getUniqueId());
            this.gqM.setLayerType(1, null);
            this.gqN.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bES() {
        return this.gqq;
    }

    public void g(NoNetworkView.a aVar) {
        this.glY = aVar;
        if (this.fVd != null) {
            this.fVd.a(this.glY);
        }
    }

    public void hu(boolean z) {
        this.gql = z;
        if (z) {
            if (this.gqK != null) {
                this.gqK.bHm();
                return;
            }
            return;
        }
        this.gqy.getAdapter().notifyDataSetChanged();
        if (this.gqK != null) {
            this.gqK.bHn();
        }
    }

    public void lo(boolean z) {
        if (this.gqK != null) {
            if (z) {
                M(false, true);
            } else {
                M(false, false);
            }
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void a(g.d dVar) {
        this.mPullView.a(dVar);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.gqy.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.gqz.a(sVar);
    }

    public void setForumName(String str) {
        this.gqz.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gaz);
        if (this.gqP != null) {
            this.gqP.destroy();
        }
        if (this.gqL != null) {
            this.gqL.onDestory();
        }
        if (this.grb != null) {
            this.grb.setPageContext(null);
        }
        this.gqz.onDestory();
        this.gqy.setOnSrollToBottomListener(null);
        this.gqy.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.grh);
        if (this.fZx != null) {
            this.fZx.onDestroy();
        }
        this.gqO.clear();
        if (this.gqJ != null) {
            this.gqJ.bKp();
        }
        if (this.gqT != null) {
            this.gqT.bGw();
        }
        if (this.gqB != null) {
            this.gqB.onDestroy();
        }
        if (this.grc != null) {
            this.grc.onDestroy();
        }
        if (this.grb != null) {
            this.grb.onDestroy();
        }
    }

    public boolean bET() {
        if (this.CD == null || this.gqU == null || !this.gqU.isSticky()) {
            return this.gqJ != null && this.gqJ.bET();
        }
        if (this.gqy != null) {
            this.gqy.setSelection(0);
        }
        this.gqU.expandedAppBarLayout(this.CD);
        return true;
    }

    public boolean bEr() {
        return this.gql;
    }

    public void bgz() {
        this.gqy.setVisibility(0);
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
            com.baidu.tbadk.core.i.azO().setForumNameForWaterImage(str);
        }
    }

    public void bEU() {
        if (this.gqz != null) {
            this.gqz.notifyDataSetChanged();
        }
    }

    public void asN() {
        if (this.gqz instanceof com.baidu.tieba.frs.entelechy.a.q) {
            ((com.baidu.tieba.frs.entelechy.a.q) this.gqz).asN();
        }
    }

    private void bEV() {
        if (this.gqC == null && this.gqm.getPageContext() != null) {
            String[] strArr = {this.gqm.getPageContext().getPageActivity().getString(R.string.take_photo), this.gqm.getPageContext().getPageActivity().getString(R.string.album)};
            this.gqC = new com.baidu.tbadk.core.dialog.b(this.gqm.getPageContext().getPageActivity());
            this.gqC.sT(this.gqm.getPageContext().getPageActivity().getString(R.string.operation));
            this.gqC.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.l.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        l.this.gqm.bEs();
                    } else if (i == 1 && l.this.gqm.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(l.this.gqm.getPageContext().getPageActivity());
                    }
                }
            });
            this.gqC.d(this.gqm.getPageContext());
        }
    }

    public void bEW() {
        bEV();
        if (this.gqC != null) {
            this.gqC.aED();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.v.isEmpty(switchThreadDataToThreadCardInfo)) {
                n nVar = new n();
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
                arrayList3.add(nVar);
                if (this.gqm != null && this.gqm.bDL() != null && this.gqm.bDL().bJj() == 0) {
                    nVar.sR(this.gqm.bDL().bJq());
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = switchThreadDataToThreadCardInfo;
            }
            this.mIsPrivateForum = frsViewData.isPrivateForum();
            if (com.baidu.tbadk.core.util.v.getCount(arrayList2) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = arrayList2.get(i2);
                    if (mVar instanceof bi) {
                        ((bi) mVar).cRg.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.gqz.b(arrayList2, frsViewData);
            if (this.gqP != null && this.gqd != 0) {
                this.gqP.a(this.gqd, this.eke, this.gqI, true);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gqy;
    }

    public void bEX() {
        this.gqz.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gqm.getPageContext(), 1);
        aVar.a(this.gqy);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.gqm.getForumName());
        hashMap.put("forum_id", this.gqm.getForumId());
        aVar.setParams(hashMap);
        aVar.ao(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.gqJ != null) {
            this.gqJ.bKq();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        sJ(TbadkCoreApplication.getInst().getSkinType());
        if (this.gqJ != null) {
            this.gqJ.bKr();
        }
    }

    public void release() {
        if (this.fVd != null && this.glY != null) {
            this.fVd.b(this.glY);
        }
    }

    public ImageView bEY() {
        return this.gqs;
    }

    public TextView bEZ() {
        return this.gqt;
    }

    public View bFa() {
        if (this.gqr != null) {
            return this.gqr.getView();
        }
        return null;
    }

    public void D(int i, boolean z) {
        if (this.gqr != null) {
            this.gqr.r(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.gqm, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gqm.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.gqN != null) {
            this.gqN.invalidate();
        }
        if (this.gqz != null) {
            this.gqz.bHg();
            this.gqz.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.gqm.getPageContext(), this.gqn);
        if (this.fVd != null) {
            this.fVd.onChangeSkinType(this.gqm.getPageContext(), i);
        }
        if (this.elw != null) {
            this.elw.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.elw.changeSkin(i);
        }
        sJ(i);
        if (this.gqK != null) {
            this.gqK.onChangeSkinType(i);
        }
        if (this.gqJ != null) {
            this.gqJ.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grb != null) {
            this.grb.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.enH, R.color.cp_bg_line_d);
        if (this.gqm != null && this.gqm.bDV()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqp, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqp, R.color.cp_bg_line_d);
        }
    }

    private void sJ(int i) {
        if (this.gqm != null) {
            sK(i);
        }
    }

    private void sK(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gqm.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqE, R.color.cp_bg_line_c, i);
            if (this.gqr != null) {
                this.gqr.onChangeSkinType(i);
            }
            if (this.gqs != null) {
                SvgManager.aGC().a(this.gqs, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.aCc, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqQ, R.color.cp_bg_line_h);
        lp(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.eLt) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.gre != 0) {
                    SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aGC().a(this.gqs, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aGC().a(this.fPK, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.gre = 0;
                }
            } else if (z || this.gre != 1) {
                SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGC().a(this.gqs, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGC().a(this.fPK, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.gre = 1;
            }
            bFb();
        }
    }

    private void bFb() {
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
                if (this.fPK != null) {
                    this.fPK.setAlpha(f);
                }
                if (this.gqs != null) {
                    this.gqs.setAlpha(f);
                }
            }
            if (this.gqt != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.gqt.setAlpha(f2);
                this.gqt.setClickable(f2 > 0.0f);
            }
            if (this.aCc != null) {
                this.aCc.setAlpha(alpha);
            }
            if (this.gqQ != null) {
                this.gqQ.setAlpha(alpha);
            }
            if (this.gqE != null) {
                this.gqE.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.gqy != null) {
            this.gqy.setSelection(0);
        }
        if (this.CD != null) {
            this.CD.setExpanded(true);
        }
        if (this.enH != null && this.enH.isEnabled()) {
            this.enH.setRefreshing(true);
        }
    }

    public void lq(boolean z) {
        if (z) {
            this.enH.setRefreshing(false);
        } else {
            this.enH.interruptRefresh();
        }
    }

    public void lr(boolean z) {
        this.enH.setEnabled(z);
    }

    public void ls(boolean z) {
        this.gqG = z;
        if (this.gqG) {
            this.elw.setText(this.gqm.getResources().getString(R.string.load_more));
            if (this.gqy.getChildAt(this.gqy.getChildCount() - 1) == this.elw.getView()) {
                this.elw.startLoadData();
                this.gqm.bcg();
                return;
            }
            this.elw.endLoadData();
            return;
        }
        this.elw.setText(this.gqm.getResources().getString(R.string.load_more_must_after_delete));
        this.elw.endLoadData();
    }

    public boolean bFc() {
        if (this.gqG) {
            return false;
        }
        this.elw.setText(this.gqm.getResources().getString(R.string.load_more_must_after_delete));
        this.elw.endLoadData();
        return true;
    }

    public boolean bFd() {
        return this.gqu != null && this.gqx.getVisibility() == 0;
    }

    public void bFe() {
        if (this.gqu != null) {
            this.gqv.setVisibility(0);
            this.gqx.setVisibility(8);
            this.gqw.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.grh, 5000L);
        }
    }

    public void a(bt btVar) {
        if (this.gqu == null) {
            View rootView = this.gqm.getRootView();
            this.gqu = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.gqu.setVisibility(0);
            this.gqv = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.gqw = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.gqx = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.gqw.setPageId(this.gqm.getUniqueId());
            this.gqx.setPageId(this.gqm.getUniqueId());
            this.gqw.setDefaultBgResource(R.color.common_color_10022);
            this.gqw.setDefaultResource(0);
            this.gqx.setDefaultBgResource(R.color.common_color_10022);
            this.gqx.setDefaultResource(0);
            this.gqv.setOnClickListener(this.gqD);
        }
        this.gqv.setVisibility(0);
        String aEv = btVar.aEv();
        String aEw = btVar.aEw();
        this.gqw.startLoad(aEv, 10, false);
        this.gqx.startLoad(aEw, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.grh, 5000L);
    }

    public void bFf() {
        if (this.gqu != null && this.gqv != null) {
            this.gqv.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.af bFg() {
        return this.gqz;
    }

    public RelativeLayout bsF() {
        return this.gqn;
    }

    public View bFh() {
        return this.gqF;
    }

    public void sL(int i) {
        if (this.gqp != null) {
            this.gqp.setVisibility(i);
        }
    }

    public void bFi() {
        if (com.baidu.tbadk.n.m.aRm().aRn()) {
            int lastVisiblePosition = this.gqy.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gqy.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grw != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grw.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDI = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grw.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grw.startLogPerf();
                    }
                    if (pVar.grv != null && (pVar.grv instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.grv;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDI = true;
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

    public NavigationBar beM() {
        return this.mNavigationBar;
    }

    public void bds() {
        this.mHasMore = true;
        this.gqy.setNextPage(this.elw);
        if (this.gqH > 0) {
            this.elw.showEmptyView(this.gqH);
        }
        this.elw.setOnClickListener(null);
        this.elw.startLoadData();
    }

    public void bdt() {
        this.mHasMore = false;
        this.gqy.setNextPage(this.elw);
        if (this.gqH > 0) {
            this.elw.showEmptyView(this.gqH);
        }
        this.elw.setOnClickListener(null);
        this.elw.endLoadData();
        this.elw.setText(this.gqm.getResources().getString(R.string.list_has_no_more));
    }

    public void bFj() {
        this.mHasMore = true;
        this.gqy.setNextPage(this.elw);
        this.elw.setOnClickListener(this.gqD);
        if (this.gqH > 0) {
            this.elw.showEmptyView(this.gqH);
        }
        this.elw.endLoadData();
        this.elw.setText(this.gqm.getResources().getString(R.string.list_click_load_more));
    }

    public View bFk() {
        if (this.elw == null) {
            return null;
        }
        return this.elw.getView();
    }

    public void sM(int i) {
        if (this.grb != null) {
            this.grb.setVisibility(i);
        }
    }

    public void sN(int i) {
        if (this.grb != null) {
            this.grb.setSelectNumber(i);
        }
    }

    public void bdu() {
        this.mHasMore = false;
        this.gqy.setNextPage(null);
    }

    public boolean bFl() {
        return this.elw.getView().getParent() != null && this.mHasMore;
    }

    public void sO(int i) {
        this.gqH = i;
    }

    public void sP(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.fZx == null) {
                    this.fZx = new CommonTipView(this.gqm.getActivity());
                }
                this.fZx.setText(R.string.frs_login_tip);
                this.fZx.b((FrameLayout) bFh(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void lt(boolean z) {
        this.mIsBackground = z;
        if (this.gqP != null) {
            boolean z2 = (this.gqm == null || this.gqm.bDO() == null || this.gqm.bDO().bKZ() == null) ? true : this.gqm.bDO().bKZ().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.gqP.oB(false);
                this.gqP.ccU();
                return;
            }
            this.gqP.oB(true);
            this.gqP.a(this.gqd, this.eke, this.gqI, true);
        }
    }

    public void bD(int i, int i2) {
        if (this.gqP != null) {
            this.gqP.a(i, i2, this.gqI, 1);
        }
    }

    public void bE(int i, int i2) {
        this.gqd = i;
        this.eke = i2;
    }

    public void lu(boolean z) {
        this.gqI = z;
    }

    public void sQ(int i) {
        if (this.gqy != null && this.gqy.getChildCount() >= 0) {
            if (this.gqy.getFirstVisiblePosition() > 8) {
                this.gqy.scrollToPosition(8);
            }
            this.gqy.smoothScrollToPosition(i);
        }
    }

    public void bFm() {
        a(this.gqS, this.gqm.bEt());
        if (this.gqz != null) {
            this.gqz.bHd();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.gqT == null) {
                this.gqT = new com.baidu.tieba.video.f(this.gqm.getActivity(), this.gqn);
            }
            this.gqT.h(postWriteCallBackData);
        }
    }

    public void bFn() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.gri && this.gqm.getActivity() != null && this.gqm.getPageContext() != null) {
            View view = null;
            if (this.gqy != null && (headerViewsCount = this.gqy.getHeaderViewsCount()) < this.gqy.getChildCount()) {
                view = this.gqy.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).M(0).F(true).G(false).E(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.l.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        l.this.gqm.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(l.this.gqm.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(l.this.gqm.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.l.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c fI = dVar.fI();
                fI.setShouldCheckLocInWindow(false);
                fI.show(this.gqm.getActivity());
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fI != null) {
                            fI.dismiss();
                        }
                    }
                }, 4000L);
                this.gri = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.grb != null) {
            this.grb.setDeleteCallback(aVar);
        }
    }

    public void bFo() {
        if (this.grb != null) {
            this.grb.bFo();
        }
    }

    public void aWo() {
        if (this.grb != null) {
            this.grb.aWo();
        }
    }

    public void az(String str, int i) {
        if (this.grd == null) {
            this.grd = new TextView(this.gqm.getActivity());
            this.grd.setGravity(19);
            this.grd.setPadding(com.baidu.adp.lib.util.l.getDimens(this.gqm.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.gqm.getActivity(), R.dimen.ds34), 0);
            this.grd.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gqm.getActivity(), R.dimen.tbds112)));
            this.grd.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gqm.getActivity(), R.dimen.fontsize30));
            this.grd.setMaxLines(2);
            this.grd.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.grd.setTextColor(ContextCompat.getColor(this.gqm.getActivity(), R.color.cp_cont_a));
        }
        this.grc.setBackgroundColor(i);
        this.grd.setText(str);
        this.grc.a(this.gqm.getActivity(), this.grd, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.CD != null) {
            this.CD.setExpanded(z);
        }
    }

    public void bFp() {
        if (this.mPullView != null) {
            this.mPullView.aHR();
        }
        startPullRefresh();
    }

    public void sm() {
        if (bFg() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bFg().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cRh != 0 && biVar.cRg != null && this.gqm.bDL() != null && this.gqm.bDL().bIN() != null) {
                            int[] imageWidthAndHeight = this.gqm.bDL().bIN().imageWidthAndHeight(biVar.cRg);
                            biVar.cRh = imageWidthAndHeight[0];
                            biVar.cRi = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.5
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.bFg().notifyDataSetChanged();
                        if (!l.this.mIsBackground) {
                            l.this.gqP.a(l.this.gqd, l.this.eke, l.this.gqI, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bFq() {
        if (this.gqJ == null) {
            return false;
        }
        return this.gqJ.bFq();
    }

    public Context getContext() {
        if (this.gqm == null) {
            return null;
        }
        return this.gqm.getTbPageContext().getPageActivity();
    }
}
