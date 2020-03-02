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
    private PbListView elj;
    private BdSwipeRefreshLayout ent;
    private ImageView fPx;
    private NoNetworkView fUQ;
    private CommonTipView fZk;
    private com.baidu.adp.widget.ListView.k gak;
    private FrsFragment gpZ;
    private TbImageView gqA;
    private HashSet<String> gqB;
    private com.baidu.tieba.play.m gqC;
    private ObservedChangeLinearLayout gqE;
    private com.baidu.tieba.frs.entelechy.b.a gqF;
    private com.baidu.tieba.video.f gqG;
    private AppBarLayoutStickyBehavior gqH;
    private FrsHeaderViewContainer gqI;
    private CollapsingToolbarLayout gqJ;
    private com.baidu.tieba.frs.vc.h gqN;
    private FrsMultiDelBottomMenuView gqO;
    private NavigationBarCoverTip gqP;
    private TextView gqQ;
    private boolean gqV;
    private View gqd;
    private com.baidu.tieba.c.b gqe;
    private ImageView gqf;
    private TextView gqg;
    private ViewStub gqh;
    private BdTypeRecyclerView gql;
    private com.baidu.tieba.frs.entelechy.a.af gqm;
    private FloatingAnimationView gqn;
    private com.baidu.tieba.c.c gqo;
    private View.OnClickListener gqq;
    private View gqr;
    private View gqs;
    private int gqu;
    private com.baidu.tieba.frs.vc.d gqw;
    private com.baidu.tieba.frs.entelechy.b.c gqx;
    private com.baidu.tieba.frs.vc.l gqy;
    private GifView gqz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean gpY = false;
    private NoPressedRelativeLayout gqa = null;
    private CoordinatorLayout gqb = null;
    private View gqc = null;
    private FrameLayout gqi = null;
    private TbImageView gqj = null;
    private TbImageView gqk = null;
    private com.baidu.tbadk.core.dialog.b gqp = null;
    private NoNetworkView.a glL = null;
    private boolean gqt = true;
    private boolean mHasMore = true;
    private boolean gqv = false;
    private int gpQ = 0;
    private int ejR = 0;
    private View aCb = null;
    private View gqD = null;
    private boolean eLg = false;
    private boolean cwK = true;
    private boolean gqK = true;
    private int gqL = -1;
    private int gqM = -1;
    private int gqR = 0;
    private int gqS = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener gam = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (l.this.gak == null) {
                        l.this.gak = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    l.this.gak.a(l.this.gql, 2);
                } else if (l.this.gak != null) {
                    l.this.gak.kB();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener gqT = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.l.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            l.this.a(appBarLayout, i);
            if (l.this.gqM != i && Math.abs(i) >= 0 && l.this.bEJ() != -1) {
                if (Math.abs(i) >= l.this.bEJ()) {
                    if (l.this.gqK) {
                        l.this.gqK = false;
                        l.this.lk(l.this.gqK);
                    }
                } else if (!l.this.gqK) {
                    l.this.gqK = true;
                    l.this.lk(l.this.gqK);
                }
                int bEF = l.this.bEF() + l.this.bEE() + l.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bEF;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && l.this.gqM - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        l.this.sH(Math.abs(bEF - totalScrollRange2));
                        if (l.this.gqD != null) {
                            l.this.gqD.setVisibility(0);
                        }
                    } else if (l.this.gqD != null) {
                        if (l.this.bED() != UtilHelper.getStatusBarHeight()) {
                            l.this.sH(0);
                        }
                        l.this.gqD.setVisibility(8);
                    }
                    if (l.this.mNavigationBar != null) {
                        if (l.this.eLg) {
                            l.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            l.this.lp(false);
                        } else if (l.this.mNavigationBar.mCenterText != null) {
                            l.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    l.this.gqM = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable gqU = new Runnable() { // from class: com.baidu.tieba.frs.l.13
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.gqh != null) {
                l.this.gqi.setVisibility(0);
                l.this.gqk.setVisibility(0);
                l.this.gqj.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.gpZ != null && appBarLayout != null && this.gpZ.bDN() != null && this.gpZ.getPageContext() != null) {
            int bEE = bEE() + getNavigationBarHeight() + bEF();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bDN = this.gpZ.bDN();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.gpZ.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.gpZ.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.gqc.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.gpZ != null && this.gpZ.bDU();
            if (totalScrollRange <= 0) {
                if (this.gqS != 2) {
                    bDN.ut(2);
                }
                this.gqS = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bEE) {
                if (this.gqS != 1) {
                    bDN.ut(1);
                }
                this.gqS = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.gqS != 0) {
                    bDN.ut(0);
                }
                this.gqS = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.gpZ.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.gqc.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bEB() {
        return this.gqE;
    }

    public View Am() {
        return this.aCb;
    }

    public View bEC() {
        return this.gqD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bED() {
        if (this.aCb == null) {
            return 0;
        }
        return this.aCb.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEE() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEF() {
        if (this.fUQ == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fUQ.getHeight();
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
        View bEC = bEC();
        if (UtilHelper.canUseStyleImmersiveSticky() && Am != null && bEC != null && Am.getLayoutParams() != null && bEC.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Am.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Am.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bEC.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bEC.setLayoutParams(layoutParams2);
        }
    }

    public l(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.gpZ = null;
        this.gqq = null;
        this.gqu = 0;
        this.gpZ = frsFragment;
        this.gqq = onClickListener;
        MessageManager.getInstance().registerListener(this.gam);
        a(aVar, z);
        this.gqB = new HashSet<>();
        this.gqu = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.gqN = hVar;
    }

    private boolean bEG() {
        return this.gqN != null && this.gqN.bKE();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.gqF = aVar;
        View rootView = this.gpZ.getRootView();
        if (this.gqa == null) {
            this.gqa = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.gqc == null) {
            this.gqc = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.gqb == null) {
            this.gqb = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.gqs == null) {
            this.gqs = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.gqJ == null) {
            this.gqJ = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.gqI == null) {
            this.gqI = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.gqE == null) {
            this.gqE = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.gqE.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.l.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        l.this.gqJ.setMinimumHeight(i2);
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
        if (this.gpZ.bEs()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.gqr == null) {
            this.gqr = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bGH = aVar.bGH();
            if (bGH != null) {
                bGH.bP(this.gqr);
            }
        }
        if (this.gqd == null) {
            this.gqd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gqd.setOnClickListener(this.gqq);
            this.mBackImageView = (ImageView) this.gqd.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gqe == null) {
            this.gqe = new com.baidu.tieba.c.b(this.gpZ.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gqe.getView(), (View.OnClickListener) null);
            this.fPx = this.gqe.bwg();
            this.gqe.getView().setOnClickListener(this.gqq);
        }
        if (this.gqf == null) {
            this.gqf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.gqf.setOnClickListener(this.gqq);
        }
        if (this.gqg == null) {
            this.gqg = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.gqg.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.gpZ.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.gqg.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.b(this.gqg, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gqg, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.gpZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.gpZ.getPageContext());
        }
        this.mPullView.setTag(this.gpZ.getUniqueId());
        if (this.ent == null) {
            this.ent = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.ent.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.ent, R.color.cp_bg_line_c);
        }
        if (this.gql == null) {
            this.gql = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.l.8
            int gqY = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.gqY--;
                if (this.gqY == 0) {
                    l.this.gql.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.gqY++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.gql.setItemAnimator(defaultItemAnimator);
        this.gql.setLayoutManager(new LinearLayoutManager(this.gql.getContext()) { // from class: com.baidu.tieba.frs.l.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gak = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.gak.a(this.gql, 2);
        }
        this.gql.setScrollable(this.gpZ);
        this.gql.setFadingEdgeLength(0);
        this.gql.setOverScrollMode(2);
        this.gqa.setBottomOrderView(this.gql);
        this.gql.setOnTouchListener(this.gpZ.drA);
        this.gql.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.l.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (l.this.gqC != null) {
                    l.this.gqC.cl(view);
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
        if (this.elj == null) {
            this.elj = new PbListView(this.gpZ.getPageContext().getPageActivity());
            this.elj.getView();
        }
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.elj.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gpZ.getActivity(), R.dimen.tbds182));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gql.setOnSrollToBottomListener(this.gpZ);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.l.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.gpZ.bEl();
                if (l.this.gpZ != null && l.this.CD != null) {
                    l.this.gpZ.bEu();
                    l.this.CD.setExpanded(true);
                    if (l.this.gqC != null) {
                        l.this.gqC.a(l.this.gpQ, l.this.ejR, false, true);
                    }
                }
            }
        });
        boolean aGE = com.baidu.tbadk.core.util.ar.aGD().aGE();
        if (this.gqm == null) {
            this.gqm = aVar.a(this.gpZ, this.gql, aGE);
        }
        hu(false);
        if (!z) {
            if (this.fUQ == null) {
                this.fUQ = new NoNetworkView(this.gpZ.getActivity());
                this.fUQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.gqE.addView(this.fUQ);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fUQ.setVisibility(8);
            } else {
                this.fUQ.setVisibility(0);
            }
            this.fUQ.onChangeSkinType(this.gpZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bEQ();
        if (this.gqw == null) {
            this.gqw = aVar.a(this.gpZ, this.gqa);
            this.gqw.b(this.gpZ.bEv());
        }
        if (this.gqx == null) {
            this.gqx = aVar.b(this.gpZ, this.gqa);
            ln(true);
        }
        if (this.aCb == null) {
            this.aCb = rootView.findViewById(R.id.statebar_view);
        }
        if (this.gqD == null) {
            this.gqD = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.gqC == null) {
            this.gqC = new com.baidu.tieba.play.m(this.gpZ.getPageContext(), this.gql);
        }
        this.gqC.Ar(1);
        this.gqC.setUniqueId(this.gpZ.getUniqueId());
        this.gqP = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.gqy == null) {
            this.gqy = new com.baidu.tieba.frs.vc.l(this.gpZ, this.gqP);
        }
        if (this.CD == null) {
            this.CD = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.CD.addOnOffsetChangedListener(this.gqT);
            this.gqK = true;
            this.gqL = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.gqH = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.gqO = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.gqO.setPageContext(this.gpZ.getPageContext());
        this.gqn = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.gqn.setPageId(this.gpZ.getUniqueId());
        this.gqo = new com.baidu.tieba.c.c(this.gpZ.getTbPageContext(), this.gqn, 2);
    }

    public void onPrimary(boolean z) {
        if (z && this.gqo != null) {
            this.gqo.baC();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.gqo != null) {
            this.gqo.a(oVar);
        }
    }

    private void bEH() {
        ViewGroup.LayoutParams layoutParams;
        this.eLg = bEG();
        if (this.gqI != null && (layoutParams = this.gqI.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.eLg) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bEE(), 0, 0);
            }
            this.gqI.requestLayout();
        }
    }

    public void bEI() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gqE != null) {
            bEH();
            if (this.eLg) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.aCb != null) {
                    this.aCb.setAlpha(1.0f);
                }
                if (this.gqD != null) {
                    this.gqD.setAlpha(1.0f);
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
        if (z && this.gpZ != null && this.gpZ.bDM() != null) {
            this.gpZ.bDM().bKI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEJ() {
        int i;
        if (this.CD == null) {
            return this.gqL;
        }
        if (this.gqL != -1) {
            return this.gqL;
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
        this.gqL = Math.max(0, this.CD.getTotalScrollRange() - Math.abs(i2));
        return this.gqL;
    }

    public void Be(String str) {
        if (this.gqy != null) {
            this.gqy.Be(str);
        }
    }

    public com.baidu.tieba.play.m bEK() {
        return this.gqC;
    }

    public com.baidu.tieba.frs.entelechy.b.c bEL() {
        return this.gqx;
    }

    public void ll(boolean z) {
        if (this.gqw != null) {
            this.gqw.ll(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bEM() {
        return this.gqw;
    }

    public void M(boolean z, boolean z2) {
        if (this.cwK && this.gqx != null) {
            this.gqx.M(z, z2);
        }
    }

    public void lm(boolean z) {
        this.cwK = z;
        if (!this.cwK && this.gqx != null) {
            this.gqx.M(false, false);
        }
    }

    public void bEN() {
        if (this.cwK && this.gqx != null) {
            this.gqx.M(false, false);
        }
        sI(8);
        this.gqf.setVisibility(8);
        ll(false);
        this.gql.setVisibility(8);
        this.gqI.setVisibility(8);
    }

    public void bEO() {
        if (this.cwK && this.gqx != null) {
            this.gqx.M(true, false);
        }
        sI(0);
        bEP();
        ll(this.gpZ.bEx());
        this.gql.setVisibility(0);
        this.gqI.setVisibility(0);
    }

    private void sI(int i) {
        if (this.gqe != null) {
            this.gqe.setVisibility(i);
        }
    }

    private void bEP() {
        this.gqf.setVisibility(0);
    }

    public void ln(boolean z) {
        if (this.gqx != null) {
            this.gqx.lP(z);
        }
    }

    private void bEQ() {
        if (this.gqz == null) {
            View rootView = this.gpZ.getRootView();
            this.gqz = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.gqA = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.gqA.setPageId(this.gpZ.getUniqueId());
            this.gqz.setLayerType(1, null);
            this.gqA.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bER() {
        return this.gqd;
    }

    public void g(NoNetworkView.a aVar) {
        this.glL = aVar;
        if (this.fUQ != null) {
            this.fUQ.a(this.glL);
        }
    }

    public void hu(boolean z) {
        this.gpY = z;
        if (z) {
            if (this.gqx != null) {
                this.gqx.bHl();
                return;
            }
            return;
        }
        this.gql.getAdapter().notifyDataSetChanged();
        if (this.gqx != null) {
            this.gqx.bHm();
        }
    }

    public void lo(boolean z) {
        if (this.gqx != null) {
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
        this.gql.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.gqm.a(sVar);
    }

    public void setForumName(String str) {
        this.gqm.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gam);
        if (this.gqC != null) {
            this.gqC.destroy();
        }
        if (this.gqy != null) {
            this.gqy.onDestory();
        }
        if (this.gqO != null) {
            this.gqO.setPageContext(null);
        }
        this.gqm.onDestory();
        this.gql.setOnSrollToBottomListener(null);
        this.gql.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.gqU);
        if (this.fZk != null) {
            this.fZk.onDestroy();
        }
        this.gqB.clear();
        if (this.gqw != null) {
            this.gqw.bKo();
        }
        if (this.gqG != null) {
            this.gqG.bGv();
        }
        if (this.gqo != null) {
            this.gqo.onDestroy();
        }
        if (this.gqP != null) {
            this.gqP.onDestroy();
        }
        if (this.gqO != null) {
            this.gqO.onDestroy();
        }
    }

    public boolean bES() {
        if (this.CD == null || this.gqH == null || !this.gqH.isSticky()) {
            return this.gqw != null && this.gqw.bES();
        }
        if (this.gql != null) {
            this.gql.setSelection(0);
        }
        this.gqH.expandedAppBarLayout(this.CD);
        return true;
    }

    public boolean bEq() {
        return this.gpY;
    }

    public void bgy() {
        this.gql.setVisibility(0);
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

    public void bET() {
        if (this.gqm != null) {
            this.gqm.notifyDataSetChanged();
        }
    }

    public void asN() {
        if (this.gqm instanceof com.baidu.tieba.frs.entelechy.a.q) {
            ((com.baidu.tieba.frs.entelechy.a.q) this.gqm).asN();
        }
    }

    private void bEU() {
        if (this.gqp == null && this.gpZ.getPageContext() != null) {
            String[] strArr = {this.gpZ.getPageContext().getPageActivity().getString(R.string.take_photo), this.gpZ.getPageContext().getPageActivity().getString(R.string.album)};
            this.gqp = new com.baidu.tbadk.core.dialog.b(this.gpZ.getPageContext().getPageActivity());
            this.gqp.sT(this.gpZ.getPageContext().getPageActivity().getString(R.string.operation));
            this.gqp.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.l.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        l.this.gpZ.bEr();
                    } else if (i == 1 && l.this.gpZ.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(l.this.gpZ.getPageContext().getPageActivity());
                    }
                }
            });
            this.gqp.d(this.gpZ.getPageContext());
        }
    }

    public void bEV() {
        bEU();
        if (this.gqp != null) {
            this.gqp.aED();
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
                if (this.gpZ != null && this.gpZ.bDK() != null && this.gpZ.bDK().bJi() == 0) {
                    nVar.sR(this.gpZ.bDK().bJp());
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
                        ((bi) mVar).cRf.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.gqm.b(arrayList2, frsViewData);
            if (this.gqC != null && this.gpQ != 0) {
                this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gql;
    }

    public void bEW() {
        this.gqm.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gpZ.getPageContext(), 1);
        aVar.a(this.gql);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.gpZ.getForumName());
        hashMap.put("forum_id", this.gpZ.getForumId());
        aVar.setParams(hashMap);
        aVar.ao(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.gqw != null) {
            this.gqw.bKp();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        sJ(TbadkCoreApplication.getInst().getSkinType());
        if (this.gqw != null) {
            this.gqw.bKq();
        }
    }

    public void release() {
        if (this.fUQ != null && this.glL != null) {
            this.fUQ.b(this.glL);
        }
    }

    public ImageView bEX() {
        return this.gqf;
    }

    public TextView bEY() {
        return this.gqg;
    }

    public View bEZ() {
        if (this.gqe != null) {
            return this.gqe.getView();
        }
        return null;
    }

    public void D(int i, boolean z) {
        if (this.gqe != null) {
            this.gqe.r(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.gpZ, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gpZ.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.gqA != null) {
            this.gqA.invalidate();
        }
        if (this.gqm != null) {
            this.gqm.bHf();
            this.gqm.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.gpZ.getPageContext(), this.gqa);
        if (this.fUQ != null) {
            this.fUQ.onChangeSkinType(this.gpZ.getPageContext(), i);
        }
        if (this.elj != null) {
            this.elj.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.elj.changeSkin(i);
        }
        sJ(i);
        if (this.gqx != null) {
            this.gqx.onChangeSkinType(i);
        }
        if (this.gqw != null) {
            this.gqw.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gqO != null) {
            this.gqO.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.ent, R.color.cp_bg_line_d);
        if (this.gpZ != null && this.gpZ.bDU()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqc, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqc, R.color.cp_bg_line_d);
        }
    }

    private void sJ(int i) {
        if (this.gpZ != null) {
            sK(i);
        }
    }

    private void sK(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gpZ.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqr, R.color.cp_bg_line_c, i);
            if (this.gqe != null) {
                this.gqe.onChangeSkinType(i);
            }
            if (this.gqf != null) {
                SvgManager.aGC().a(this.gqf, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.aCb, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqD, R.color.cp_bg_line_h);
        lp(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.eLg) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.gqR != 0) {
                    SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aGC().a(this.gqf, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aGC().a(this.fPx, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.gqR = 0;
                }
            } else if (z || this.gqR != 1) {
                SvgManager.aGC().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGC().a(this.gqf, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGC().a(this.fPx, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.gqR = 1;
            }
            bFa();
        }
    }

    private void bFa() {
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
                if (this.fPx != null) {
                    this.fPx.setAlpha(f);
                }
                if (this.gqf != null) {
                    this.gqf.setAlpha(f);
                }
            }
            if (this.gqg != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.gqg.setAlpha(f2);
                this.gqg.setClickable(f2 > 0.0f);
            }
            if (this.aCb != null) {
                this.aCb.setAlpha(alpha);
            }
            if (this.gqD != null) {
                this.gqD.setAlpha(alpha);
            }
            if (this.gqr != null) {
                this.gqr.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.gql != null) {
            this.gql.setSelection(0);
        }
        if (this.CD != null) {
            this.CD.setExpanded(true);
        }
        if (this.ent != null && this.ent.isEnabled()) {
            this.ent.setRefreshing(true);
        }
    }

    public void lq(boolean z) {
        if (z) {
            this.ent.setRefreshing(false);
        } else {
            this.ent.interruptRefresh();
        }
    }

    public void lr(boolean z) {
        this.ent.setEnabled(z);
    }

    public void ls(boolean z) {
        this.gqt = z;
        if (this.gqt) {
            this.elj.setText(this.gpZ.getResources().getString(R.string.load_more));
            if (this.gql.getChildAt(this.gql.getChildCount() - 1) == this.elj.getView()) {
                this.elj.startLoadData();
                this.gpZ.bcf();
                return;
            }
            this.elj.endLoadData();
            return;
        }
        this.elj.setText(this.gpZ.getResources().getString(R.string.load_more_must_after_delete));
        this.elj.endLoadData();
    }

    public boolean bFb() {
        if (this.gqt) {
            return false;
        }
        this.elj.setText(this.gpZ.getResources().getString(R.string.load_more_must_after_delete));
        this.elj.endLoadData();
        return true;
    }

    public boolean bFc() {
        return this.gqh != null && this.gqk.getVisibility() == 0;
    }

    public void bFd() {
        if (this.gqh != null) {
            this.gqi.setVisibility(0);
            this.gqk.setVisibility(8);
            this.gqj.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.gqU, 5000L);
        }
    }

    public void a(bt btVar) {
        if (this.gqh == null) {
            View rootView = this.gpZ.getRootView();
            this.gqh = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.gqh.setVisibility(0);
            this.gqi = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.gqj = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.gqk = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.gqj.setPageId(this.gpZ.getUniqueId());
            this.gqk.setPageId(this.gpZ.getUniqueId());
            this.gqj.setDefaultBgResource(R.color.common_color_10022);
            this.gqj.setDefaultResource(0);
            this.gqk.setDefaultBgResource(R.color.common_color_10022);
            this.gqk.setDefaultResource(0);
            this.gqi.setOnClickListener(this.gqq);
        }
        this.gqi.setVisibility(0);
        String aEv = btVar.aEv();
        String aEw = btVar.aEw();
        this.gqj.startLoad(aEv, 10, false);
        this.gqk.startLoad(aEw, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.gqU, 5000L);
    }

    public void bFe() {
        if (this.gqh != null && this.gqi != null) {
            this.gqi.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.af bFf() {
        return this.gqm;
    }

    public RelativeLayout bsE() {
        return this.gqa;
    }

    public View bFg() {
        return this.gqs;
    }

    public void sL(int i) {
        if (this.gqc != null) {
            this.gqc.setVisibility(i);
        }
    }

    public void bFh() {
        if (com.baidu.tbadk.n.m.aRl().aRm()) {
            int lastVisiblePosition = this.gql.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gql.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grj != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grj.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grj.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grj.startLogPerf();
                    }
                    if (pVar.gri != null && (pVar.gri instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.gri;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDv = true;
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

    public NavigationBar beL() {
        return this.mNavigationBar;
    }

    public void bdr() {
        this.mHasMore = true;
        this.gql.setNextPage(this.elj);
        if (this.gqu > 0) {
            this.elj.showEmptyView(this.gqu);
        }
        this.elj.setOnClickListener(null);
        this.elj.startLoadData();
    }

    public void bds() {
        this.mHasMore = false;
        this.gql.setNextPage(this.elj);
        if (this.gqu > 0) {
            this.elj.showEmptyView(this.gqu);
        }
        this.elj.setOnClickListener(null);
        this.elj.endLoadData();
        this.elj.setText(this.gpZ.getResources().getString(R.string.list_has_no_more));
    }

    public void bFi() {
        this.mHasMore = true;
        this.gql.setNextPage(this.elj);
        this.elj.setOnClickListener(this.gqq);
        if (this.gqu > 0) {
            this.elj.showEmptyView(this.gqu);
        }
        this.elj.endLoadData();
        this.elj.setText(this.gpZ.getResources().getString(R.string.list_click_load_more));
    }

    public View bFj() {
        if (this.elj == null) {
            return null;
        }
        return this.elj.getView();
    }

    public void sM(int i) {
        if (this.gqO != null) {
            this.gqO.setVisibility(i);
        }
    }

    public void sN(int i) {
        if (this.gqO != null) {
            this.gqO.setSelectNumber(i);
        }
    }

    public void bdt() {
        this.mHasMore = false;
        this.gql.setNextPage(null);
    }

    public boolean bFk() {
        return this.elj.getView().getParent() != null && this.mHasMore;
    }

    public void sO(int i) {
        this.gqu = i;
    }

    public void sP(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.fZk == null) {
                    this.fZk = new CommonTipView(this.gpZ.getActivity());
                }
                this.fZk.setText(R.string.frs_login_tip);
                this.fZk.b((FrameLayout) bFg(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void lt(boolean z) {
        this.mIsBackground = z;
        if (this.gqC != null) {
            boolean z2 = (this.gpZ == null || this.gpZ.bDN() == null || this.gpZ.bDN().bKY() == null) ? true : this.gpZ.bDN().bKY().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.gqC.oB(false);
                this.gqC.ccT();
                return;
            }
            this.gqC.oB(true);
            this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
        }
    }

    public void bD(int i, int i2) {
        if (this.gqC != null) {
            this.gqC.a(i, i2, this.gqv, 1);
        }
    }

    public void bE(int i, int i2) {
        this.gpQ = i;
        this.ejR = i2;
    }

    public void lu(boolean z) {
        this.gqv = z;
    }

    public void sQ(int i) {
        if (this.gql != null && this.gql.getChildCount() >= 0) {
            if (this.gql.getFirstVisiblePosition() > 8) {
                this.gql.scrollToPosition(8);
            }
            this.gql.smoothScrollToPosition(i);
        }
    }

    public void bFl() {
        a(this.gqF, this.gpZ.bEs());
        if (this.gqm != null) {
            this.gqm.bHc();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.gqG == null) {
                this.gqG = new com.baidu.tieba.video.f(this.gpZ.getActivity(), this.gqa);
            }
            this.gqG.h(postWriteCallBackData);
        }
    }

    public void bFm() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.gqV && this.gpZ.getActivity() != null && this.gpZ.getPageContext() != null) {
            View view = null;
            if (this.gql != null && (headerViewsCount = this.gql.getHeaderViewsCount()) < this.gql.getChildCount()) {
                view = this.gql.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).M(0).F(true).G(false).E(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.l.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        l.this.gpZ.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(l.this.gpZ.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(l.this.gpZ.getActivity(), R.dimen.ds6);
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
                fI.show(this.gpZ.getActivity());
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fI != null) {
                            fI.dismiss();
                        }
                    }
                }, 4000L);
                this.gqV = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.gqO != null) {
            this.gqO.setDeleteCallback(aVar);
        }
    }

    public void bFn() {
        if (this.gqO != null) {
            this.gqO.bFn();
        }
    }

    public void aWn() {
        if (this.gqO != null) {
            this.gqO.aWn();
        }
    }

    public void az(String str, int i) {
        if (this.gqQ == null) {
            this.gqQ = new TextView(this.gpZ.getActivity());
            this.gqQ.setGravity(19);
            this.gqQ.setPadding(com.baidu.adp.lib.util.l.getDimens(this.gpZ.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.gpZ.getActivity(), R.dimen.ds34), 0);
            this.gqQ.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gpZ.getActivity(), R.dimen.tbds112)));
            this.gqQ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gpZ.getActivity(), R.dimen.fontsize30));
            this.gqQ.setMaxLines(2);
            this.gqQ.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.gqQ.setTextColor(ContextCompat.getColor(this.gpZ.getActivity(), R.color.cp_cont_a));
        }
        this.gqP.setBackgroundColor(i);
        this.gqQ.setText(str);
        this.gqP.a(this.gpZ.getActivity(), this.gqQ, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.CD != null) {
            this.CD.setExpanded(z);
        }
    }

    public void bFo() {
        if (this.mPullView != null) {
            this.mPullView.aHQ();
        }
        startPullRefresh();
    }

    public void sm() {
        if (bFf() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bFf().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cRg != 0 && biVar.cRf != null && this.gpZ.bDK() != null && this.gpZ.bDK().bIM() != null) {
                            int[] imageWidthAndHeight = this.gpZ.bDK().bIM().imageWidthAndHeight(biVar.cRf);
                            biVar.cRg = imageWidthAndHeight[0];
                            biVar.cRh = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.5
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.bFf().notifyDataSetChanged();
                        if (!l.this.mIsBackground) {
                            l.this.gqC.a(l.this.gpQ, l.this.ejR, l.this.gqv, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bFp() {
        if (this.gqw == null) {
            return false;
        }
        return this.gqw.bFp();
    }

    public Context getContext() {
        if (this.gpZ == null) {
            return null;
        }
        return this.gpZ.getTbPageContext().getPageActivity();
    }
}
