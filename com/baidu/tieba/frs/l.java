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
    private PbListView eli;
    private BdSwipeRefreshLayout ens;
    private ImageView fPv;
    private NoNetworkView fUO;
    private CommonTipView fZi;
    private com.baidu.adp.widget.ListView.k gai;
    private FrsFragment gpX;
    private com.baidu.tieba.play.m gqA;
    private ObservedChangeLinearLayout gqC;
    private com.baidu.tieba.frs.entelechy.b.a gqD;
    private com.baidu.tieba.video.f gqE;
    private AppBarLayoutStickyBehavior gqF;
    private FrsHeaderViewContainer gqG;
    private CollapsingToolbarLayout gqH;
    private com.baidu.tieba.frs.vc.h gqL;
    private FrsMultiDelBottomMenuView gqM;
    private NavigationBarCoverTip gqN;
    private TextView gqO;
    private boolean gqT;
    private View gqb;
    private com.baidu.tieba.c.b gqc;
    private ImageView gqd;
    private TextView gqe;
    private ViewStub gqf;
    private BdTypeRecyclerView gqj;
    private com.baidu.tieba.frs.entelechy.a.af gqk;
    private FloatingAnimationView gql;
    private com.baidu.tieba.c.c gqm;
    private View.OnClickListener gqo;
    private View gqp;
    private View gqq;
    private int gqs;
    private com.baidu.tieba.frs.vc.d gqu;
    private com.baidu.tieba.frs.entelechy.b.c gqv;
    private com.baidu.tieba.frs.vc.l gqw;
    private GifView gqx;
    private TbImageView gqy;
    private HashSet<String> gqz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean gpW = false;
    private NoPressedRelativeLayout gpY = null;
    private CoordinatorLayout gpZ = null;
    private View gqa = null;
    private FrameLayout gqg = null;
    private TbImageView gqh = null;
    private TbImageView gqi = null;
    private com.baidu.tbadk.core.dialog.b gqn = null;
    private NoNetworkView.a glJ = null;
    private boolean gqr = true;
    private boolean mHasMore = true;
    private boolean gqt = false;
    private int gpO = 0;
    private int ejQ = 0;
    private View aCa = null;
    private View gqB = null;
    private boolean eLf = false;
    private boolean cwJ = true;
    private boolean gqI = true;
    private int gqJ = -1;
    private int gqK = -1;
    private int gqP = 0;
    private int gqQ = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener gak = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (l.this.gai == null) {
                        l.this.gai = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    l.this.gai.a(l.this.gqj, 2);
                } else if (l.this.gai != null) {
                    l.this.gai.kB();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener gqR = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.l.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            l.this.a(appBarLayout, i);
            if (l.this.gqK != i && Math.abs(i) >= 0 && l.this.bEH() != -1) {
                if (Math.abs(i) >= l.this.bEH()) {
                    if (l.this.gqI) {
                        l.this.gqI = false;
                        l.this.lk(l.this.gqI);
                    }
                } else if (!l.this.gqI) {
                    l.this.gqI = true;
                    l.this.lk(l.this.gqI);
                }
                int bED = l.this.bED() + l.this.bEC() + l.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bED;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && l.this.gqK - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        l.this.sH(Math.abs(bED - totalScrollRange2));
                        if (l.this.gqB != null) {
                            l.this.gqB.setVisibility(0);
                        }
                    } else if (l.this.gqB != null) {
                        if (l.this.bEB() != UtilHelper.getStatusBarHeight()) {
                            l.this.sH(0);
                        }
                        l.this.gqB.setVisibility(8);
                    }
                    if (l.this.mNavigationBar != null) {
                        if (l.this.eLf) {
                            l.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            l.this.lp(false);
                        } else if (l.this.mNavigationBar.mCenterText != null) {
                            l.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    l.this.gqK = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable gqS = new Runnable() { // from class: com.baidu.tieba.frs.l.13
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.gqf != null) {
                l.this.gqg.setVisibility(0);
                l.this.gqi.setVisibility(0);
                l.this.gqh.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.gpX != null && appBarLayout != null && this.gpX.bDL() != null && this.gpX.getPageContext() != null) {
            int bEC = bEC() + getNavigationBarHeight() + bED();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bDL = this.gpX.bDL();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.gpX.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.gpX.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.gqa.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.gpX != null && this.gpX.bDS();
            if (totalScrollRange <= 0) {
                if (this.gqQ != 2) {
                    bDL.ut(2);
                }
                this.gqQ = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bEC) {
                if (this.gqQ != 1) {
                    bDL.ut(1);
                }
                this.gqQ = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.gqQ != 0) {
                    bDL.ut(0);
                }
                this.gqQ = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.gpX.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.gqa.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bEz() {
        return this.gqC;
    }

    public View Ak() {
        return this.aCa;
    }

    public View bEA() {
        return this.gqB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEB() {
        if (this.aCa == null) {
            return 0;
        }
        return this.aCa.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEC() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bED() {
        if (this.fUO == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fUO.getHeight();
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
        View Ak = Ak();
        View bEA = bEA();
        if (UtilHelper.canUseStyleImmersiveSticky() && Ak != null && bEA != null && Ak.getLayoutParams() != null && bEA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Ak.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Ak.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bEA.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bEA.setLayoutParams(layoutParams2);
        }
    }

    public l(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.gpX = null;
        this.gqo = null;
        this.gqs = 0;
        this.gpX = frsFragment;
        this.gqo = onClickListener;
        MessageManager.getInstance().registerListener(this.gak);
        a(aVar, z);
        this.gqz = new HashSet<>();
        this.gqs = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.gqL = hVar;
    }

    private boolean bEE() {
        return this.gqL != null && this.gqL.bKC();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.gqD = aVar;
        View rootView = this.gpX.getRootView();
        if (this.gpY == null) {
            this.gpY = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.gqa == null) {
            this.gqa = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.gpZ == null) {
            this.gpZ = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.gqq == null) {
            this.gqq = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.gqH == null) {
            this.gqH = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.gqG == null) {
            this.gqG = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.gqC == null) {
            this.gqC = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.gqC.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.l.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        l.this.gqH.setMinimumHeight(i2);
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
        if (this.gpX.bEq()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.gqp == null) {
            this.gqp = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bGF = aVar.bGF();
            if (bGF != null) {
                bGF.bP(this.gqp);
            }
        }
        if (this.gqb == null) {
            this.gqb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gqb.setOnClickListener(this.gqo);
            this.mBackImageView = (ImageView) this.gqb.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gqc == null) {
            this.gqc = new com.baidu.tieba.c.b(this.gpX.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gqc.getView(), (View.OnClickListener) null);
            this.fPv = this.gqc.bwe();
            this.gqc.getView().setOnClickListener(this.gqo);
        }
        if (this.gqd == null) {
            this.gqd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.gqd.setOnClickListener(this.gqo);
        }
        if (this.gqe == null) {
            this.gqe = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.gqe.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.gpX.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.gqe.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.b(this.gqe, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gqe, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.gpX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.gpX.getPageContext());
        }
        this.mPullView.setTag(this.gpX.getUniqueId());
        if (this.ens == null) {
            this.ens = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.ens.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.ens, R.color.cp_bg_line_c);
        }
        if (this.gqj == null) {
            this.gqj = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.l.8
            int gqW = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.gqW--;
                if (this.gqW == 0) {
                    l.this.gqj.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.gqW++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.gqj.setItemAnimator(defaultItemAnimator);
        this.gqj.setLayoutManager(new LinearLayoutManager(this.gqj.getContext()) { // from class: com.baidu.tieba.frs.l.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gai = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.gai.a(this.gqj, 2);
        }
        this.gqj.setScrollable(this.gpX);
        this.gqj.setFadingEdgeLength(0);
        this.gqj.setOverScrollMode(2);
        this.gpY.setBottomOrderView(this.gqj);
        this.gqj.setOnTouchListener(this.gpX.drz);
        this.gqj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.l.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (l.this.gqA != null) {
                    l.this.gqA.cl(view);
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
        if (this.eli == null) {
            this.eli = new PbListView(this.gpX.getPageContext().getPageActivity());
            this.eli.getView();
        }
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.eli.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gpX.getActivity(), R.dimen.tbds182));
        this.eli.setLineGone();
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gqj.setOnSrollToBottomListener(this.gpX);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.l.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.gpX.bEj();
                if (l.this.gpX != null && l.this.CD != null) {
                    l.this.gpX.bEs();
                    l.this.CD.setExpanded(true);
                    if (l.this.gqA != null) {
                        l.this.gqA.a(l.this.gpO, l.this.ejQ, false, true);
                    }
                }
            }
        });
        boolean aGC = com.baidu.tbadk.core.util.ar.aGB().aGC();
        if (this.gqk == null) {
            this.gqk = aVar.a(this.gpX, this.gqj, aGC);
        }
        hu(false);
        if (!z) {
            if (this.fUO == null) {
                this.fUO = new NoNetworkView(this.gpX.getActivity());
                this.fUO.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.gqC.addView(this.fUO);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fUO.setVisibility(8);
            } else {
                this.fUO.setVisibility(0);
            }
            this.fUO.onChangeSkinType(this.gpX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bEO();
        if (this.gqu == null) {
            this.gqu = aVar.a(this.gpX, this.gpY);
            this.gqu.b(this.gpX.bEt());
        }
        if (this.gqv == null) {
            this.gqv = aVar.b(this.gpX, this.gpY);
            ln(true);
        }
        if (this.aCa == null) {
            this.aCa = rootView.findViewById(R.id.statebar_view);
        }
        if (this.gqB == null) {
            this.gqB = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.gqA == null) {
            this.gqA = new com.baidu.tieba.play.m(this.gpX.getPageContext(), this.gqj);
        }
        this.gqA.Ar(1);
        this.gqA.setUniqueId(this.gpX.getUniqueId());
        this.gqN = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.gqw == null) {
            this.gqw = new com.baidu.tieba.frs.vc.l(this.gpX, this.gqN);
        }
        if (this.CD == null) {
            this.CD = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.CD.addOnOffsetChangedListener(this.gqR);
            this.gqI = true;
            this.gqJ = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.gqF = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.gqM = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.gqM.setPageContext(this.gpX.getPageContext());
        this.gql = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.gql.setPageId(this.gpX.getUniqueId());
        this.gqm = new com.baidu.tieba.c.c(this.gpX.getTbPageContext(), this.gql, 2);
    }

    public void onPrimary(boolean z) {
        if (z && this.gqm != null) {
            this.gqm.baA();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.gqm != null) {
            this.gqm.a(oVar);
        }
    }

    private void bEF() {
        ViewGroup.LayoutParams layoutParams;
        this.eLf = bEE();
        if (this.gqG != null && (layoutParams = this.gqG.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.eLf) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bEC(), 0, 0);
            }
            this.gqG.requestLayout();
        }
    }

    public void bEG() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gqC != null) {
            bEF();
            if (this.eLf) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.aCa != null) {
                    this.aCa.setAlpha(1.0f);
                }
                if (this.gqB != null) {
                    this.gqB.setAlpha(1.0f);
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
        if (z && this.gpX != null && this.gpX.bDK() != null) {
            this.gpX.bDK().bKG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEH() {
        int i;
        if (this.CD == null) {
            return this.gqJ;
        }
        if (this.gqJ != -1) {
            return this.gqJ;
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
        this.gqJ = Math.max(0, this.CD.getTotalScrollRange() - Math.abs(i2));
        return this.gqJ;
    }

    public void Be(String str) {
        if (this.gqw != null) {
            this.gqw.Be(str);
        }
    }

    public com.baidu.tieba.play.m bEI() {
        return this.gqA;
    }

    public com.baidu.tieba.frs.entelechy.b.c bEJ() {
        return this.gqv;
    }

    public void ll(boolean z) {
        if (this.gqu != null) {
            this.gqu.ll(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bEK() {
        return this.gqu;
    }

    public void M(boolean z, boolean z2) {
        if (this.cwJ && this.gqv != null) {
            this.gqv.M(z, z2);
        }
    }

    public void lm(boolean z) {
        this.cwJ = z;
        if (!this.cwJ && this.gqv != null) {
            this.gqv.M(false, false);
        }
    }

    public void bEL() {
        if (this.cwJ && this.gqv != null) {
            this.gqv.M(false, false);
        }
        sI(8);
        this.gqd.setVisibility(8);
        ll(false);
        this.gqj.setVisibility(8);
        this.gqG.setVisibility(8);
    }

    public void bEM() {
        if (this.cwJ && this.gqv != null) {
            this.gqv.M(true, false);
        }
        sI(0);
        bEN();
        ll(this.gpX.bEv());
        this.gqj.setVisibility(0);
        this.gqG.setVisibility(0);
    }

    private void sI(int i) {
        if (this.gqc != null) {
            this.gqc.setVisibility(i);
        }
    }

    private void bEN() {
        this.gqd.setVisibility(0);
    }

    public void ln(boolean z) {
        if (this.gqv != null) {
            this.gqv.lP(z);
        }
    }

    private void bEO() {
        if (this.gqx == null) {
            View rootView = this.gpX.getRootView();
            this.gqx = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.gqy = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.gqy.setPageId(this.gpX.getUniqueId());
            this.gqx.setLayerType(1, null);
            this.gqy.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bEP() {
        return this.gqb;
    }

    public void g(NoNetworkView.a aVar) {
        this.glJ = aVar;
        if (this.fUO != null) {
            this.fUO.a(this.glJ);
        }
    }

    public void hu(boolean z) {
        this.gpW = z;
        if (z) {
            if (this.gqv != null) {
                this.gqv.bHj();
                return;
            }
            return;
        }
        this.gqj.getAdapter().notifyDataSetChanged();
        if (this.gqv != null) {
            this.gqv.bHk();
        }
    }

    public void lo(boolean z) {
        if (this.gqv != null) {
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
        this.gqj.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.gqk.a(sVar);
    }

    public void setForumName(String str) {
        this.gqk.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gak);
        if (this.gqA != null) {
            this.gqA.destroy();
        }
        if (this.gqw != null) {
            this.gqw.onDestory();
        }
        if (this.gqM != null) {
            this.gqM.setPageContext(null);
        }
        this.gqk.onDestory();
        this.gqj.setOnSrollToBottomListener(null);
        this.gqj.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.gqS);
        if (this.fZi != null) {
            this.fZi.onDestroy();
        }
        this.gqz.clear();
        if (this.gqu != null) {
            this.gqu.bKm();
        }
        if (this.gqE != null) {
            this.gqE.bGt();
        }
        if (this.gqm != null) {
            this.gqm.onDestroy();
        }
        if (this.gqN != null) {
            this.gqN.onDestroy();
        }
        if (this.gqM != null) {
            this.gqM.onDestroy();
        }
    }

    public boolean bEQ() {
        if (this.CD == null || this.gqF == null || !this.gqF.isSticky()) {
            return this.gqu != null && this.gqu.bEQ();
        }
        if (this.gqj != null) {
            this.gqj.setSelection(0);
        }
        this.gqF.expandedAppBarLayout(this.CD);
        return true;
    }

    public boolean bEo() {
        return this.gpW;
    }

    public void bgw() {
        this.gqj.setVisibility(0);
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
            com.baidu.tbadk.core.i.azM().setForumNameForWaterImage(str);
        }
    }

    public void bER() {
        if (this.gqk != null) {
            this.gqk.notifyDataSetChanged();
        }
    }

    public void asL() {
        if (this.gqk instanceof com.baidu.tieba.frs.entelechy.a.q) {
            ((com.baidu.tieba.frs.entelechy.a.q) this.gqk).asL();
        }
    }

    private void bES() {
        if (this.gqn == null && this.gpX.getPageContext() != null) {
            String[] strArr = {this.gpX.getPageContext().getPageActivity().getString(R.string.take_photo), this.gpX.getPageContext().getPageActivity().getString(R.string.album)};
            this.gqn = new com.baidu.tbadk.core.dialog.b(this.gpX.getPageContext().getPageActivity());
            this.gqn.sT(this.gpX.getPageContext().getPageActivity().getString(R.string.operation));
            this.gqn.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.l.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        l.this.gpX.bEp();
                    } else if (i == 1 && l.this.gpX.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(l.this.gpX.getPageContext().getPageActivity());
                    }
                }
            });
            this.gqn.d(this.gpX.getPageContext());
        }
    }

    public void bET() {
        bES();
        if (this.gqn != null) {
            this.gqn.aEB();
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
                if (this.gpX != null && this.gpX.bDI() != null && this.gpX.bDI().bJg() == 0) {
                    nVar.sR(this.gpX.bDI().bJn());
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
                        ((bi) mVar).cRe.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.gqk.b(arrayList2, frsViewData);
            if (this.gqA != null && this.gpO != 0) {
                this.gqA.a(this.gpO, this.ejQ, this.gqt, true);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gqj;
    }

    public void bEU() {
        this.gqk.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gpX.getPageContext(), 1);
        aVar.a(this.gqj);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.gpX.getForumName());
        hashMap.put("forum_id", this.gpX.getForumId());
        aVar.setParams(hashMap);
        aVar.ao(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.gqu != null) {
            this.gqu.bKn();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        sJ(TbadkCoreApplication.getInst().getSkinType());
        if (this.gqu != null) {
            this.gqu.bKo();
        }
    }

    public void release() {
        if (this.fUO != null && this.glJ != null) {
            this.fUO.b(this.glJ);
        }
    }

    public ImageView bEV() {
        return this.gqd;
    }

    public TextView bEW() {
        return this.gqe;
    }

    public View bEX() {
        if (this.gqc != null) {
            return this.gqc.getView();
        }
        return null;
    }

    public void D(int i, boolean z) {
        if (this.gqc != null) {
            this.gqc.r(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.gpX, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gpX.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.gqy != null) {
            this.gqy.invalidate();
        }
        if (this.gqk != null) {
            this.gqk.bHd();
            this.gqk.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.gpX.getPageContext(), this.gpY);
        if (this.fUO != null) {
            this.fUO.onChangeSkinType(this.gpX.getPageContext(), i);
        }
        if (this.eli != null) {
            this.eli.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.eli.changeSkin(i);
        }
        sJ(i);
        if (this.gqv != null) {
            this.gqv.onChangeSkinType(i);
        }
        if (this.gqu != null) {
            this.gqu.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gqM != null) {
            this.gqM.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.ens, R.color.cp_bg_line_d);
        if (this.gpX != null && this.gpX.bDS()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqa, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqa, R.color.cp_bg_line_d);
        }
    }

    private void sJ(int i) {
        if (this.gpX != null) {
            sK(i);
        }
    }

    private void sK(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gpX.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqp, R.color.cp_bg_line_c, i);
            if (this.gqc != null) {
                this.gqc.onChangeSkinType(i);
            }
            if (this.gqd != null) {
                SvgManager.aGA().a(this.gqd, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.aCa, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqB, R.color.cp_bg_line_h);
        lp(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.eLf) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.gqP != 0) {
                    SvgManager.aGA().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aGA().a(this.gqd, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aGA().a(this.fPv, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.gqP = 0;
                }
            } else if (z || this.gqP != 1) {
                SvgManager.aGA().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGA().a(this.gqd, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGA().a(this.fPv, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.gqP = 1;
            }
            bEY();
        }
    }

    private void bEY() {
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
                if (this.fPv != null) {
                    this.fPv.setAlpha(f);
                }
                if (this.gqd != null) {
                    this.gqd.setAlpha(f);
                }
            }
            if (this.gqe != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.gqe.setAlpha(f2);
                this.gqe.setClickable(f2 > 0.0f);
            }
            if (this.aCa != null) {
                this.aCa.setAlpha(alpha);
            }
            if (this.gqB != null) {
                this.gqB.setAlpha(alpha);
            }
            if (this.gqp != null) {
                this.gqp.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.gqj != null) {
            this.gqj.setSelection(0);
        }
        if (this.CD != null) {
            this.CD.setExpanded(true);
        }
        if (this.ens != null && this.ens.isEnabled()) {
            this.ens.setRefreshing(true);
        }
    }

    public void lq(boolean z) {
        if (z) {
            this.ens.setRefreshing(false);
        } else {
            this.ens.interruptRefresh();
        }
    }

    public void lr(boolean z) {
        this.ens.setEnabled(z);
    }

    public void ls(boolean z) {
        this.gqr = z;
        if (this.gqr) {
            this.eli.setText(this.gpX.getResources().getString(R.string.load_more));
            if (this.gqj.getChildAt(this.gqj.getChildCount() - 1) == this.eli.getView()) {
                this.eli.startLoadData();
                this.gpX.bcd();
                return;
            }
            this.eli.endLoadData();
            return;
        }
        this.eli.setText(this.gpX.getResources().getString(R.string.load_more_must_after_delete));
        this.eli.endLoadData();
    }

    public boolean bEZ() {
        if (this.gqr) {
            return false;
        }
        this.eli.setText(this.gpX.getResources().getString(R.string.load_more_must_after_delete));
        this.eli.endLoadData();
        return true;
    }

    public boolean bFa() {
        return this.gqf != null && this.gqi.getVisibility() == 0;
    }

    public void bFb() {
        if (this.gqf != null) {
            this.gqg.setVisibility(0);
            this.gqi.setVisibility(8);
            this.gqh.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.gqS, 5000L);
        }
    }

    public void a(bt btVar) {
        if (this.gqf == null) {
            View rootView = this.gpX.getRootView();
            this.gqf = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.gqf.setVisibility(0);
            this.gqg = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.gqh = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.gqi = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.gqh.setPageId(this.gpX.getUniqueId());
            this.gqi.setPageId(this.gpX.getUniqueId());
            this.gqh.setDefaultBgResource(R.color.common_color_10022);
            this.gqh.setDefaultResource(0);
            this.gqi.setDefaultBgResource(R.color.common_color_10022);
            this.gqi.setDefaultResource(0);
            this.gqg.setOnClickListener(this.gqo);
        }
        this.gqg.setVisibility(0);
        String aEt = btVar.aEt();
        String aEu = btVar.aEu();
        this.gqh.startLoad(aEt, 10, false);
        this.gqi.startLoad(aEu, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.gqS, 5000L);
    }

    public void bFc() {
        if (this.gqf != null && this.gqg != null) {
            this.gqg.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.af bFd() {
        return this.gqk;
    }

    public RelativeLayout bsC() {
        return this.gpY;
    }

    public View bFe() {
        return this.gqq;
    }

    public void sL(int i) {
        if (this.gqa != null) {
            this.gqa.setVisibility(i);
        }
    }

    public void bFf() {
        if (com.baidu.tbadk.n.m.aRj().aRk()) {
            int lastVisiblePosition = this.gqj.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gqj.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.grh != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.grh.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDu = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.grh.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.grh.startLogPerf();
                    }
                    if (pVar.grg != null && (pVar.grg instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.grg;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDu = true;
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

    public NavigationBar beJ() {
        return this.mNavigationBar;
    }

    public void bdp() {
        this.mHasMore = true;
        this.gqj.setNextPage(this.eli);
        if (this.gqs > 0) {
            this.eli.showEmptyView(this.gqs);
        }
        this.eli.setOnClickListener(null);
        this.eli.startLoadData();
    }

    public void bdq() {
        this.mHasMore = false;
        this.gqj.setNextPage(this.eli);
        if (this.gqs > 0) {
            this.eli.showEmptyView(this.gqs);
        }
        this.eli.setOnClickListener(null);
        this.eli.endLoadData();
        this.eli.setText(this.gpX.getResources().getString(R.string.list_has_no_more));
    }

    public void bFg() {
        this.mHasMore = true;
        this.gqj.setNextPage(this.eli);
        this.eli.setOnClickListener(this.gqo);
        if (this.gqs > 0) {
            this.eli.showEmptyView(this.gqs);
        }
        this.eli.endLoadData();
        this.eli.setText(this.gpX.getResources().getString(R.string.list_click_load_more));
    }

    public View bFh() {
        if (this.eli == null) {
            return null;
        }
        return this.eli.getView();
    }

    public void sM(int i) {
        if (this.gqM != null) {
            this.gqM.setVisibility(i);
        }
    }

    public void sN(int i) {
        if (this.gqM != null) {
            this.gqM.setSelectNumber(i);
        }
    }

    public void bdr() {
        this.mHasMore = false;
        this.gqj.setNextPage(null);
    }

    public boolean bFi() {
        return this.eli.getView().getParent() != null && this.mHasMore;
    }

    public void sO(int i) {
        this.gqs = i;
    }

    public void sP(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.fZi == null) {
                    this.fZi = new CommonTipView(this.gpX.getActivity());
                }
                this.fZi.setText(R.string.frs_login_tip);
                this.fZi.b((FrameLayout) bFe(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void lt(boolean z) {
        this.mIsBackground = z;
        if (this.gqA != null) {
            boolean z2 = (this.gpX == null || this.gpX.bDL() == null || this.gpX.bDL().bKW() == null) ? true : this.gpX.bDL().bKW().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.gqA.oB(false);
                this.gqA.ccR();
                return;
            }
            this.gqA.oB(true);
            this.gqA.a(this.gpO, this.ejQ, this.gqt, true);
        }
    }

    public void bD(int i, int i2) {
        if (this.gqA != null) {
            this.gqA.a(i, i2, this.gqt, 1);
        }
    }

    public void bE(int i, int i2) {
        this.gpO = i;
        this.ejQ = i2;
    }

    public void lu(boolean z) {
        this.gqt = z;
    }

    public void sQ(int i) {
        if (this.gqj != null && this.gqj.getChildCount() >= 0) {
            if (this.gqj.getFirstVisiblePosition() > 8) {
                this.gqj.scrollToPosition(8);
            }
            this.gqj.smoothScrollToPosition(i);
        }
    }

    public void bFj() {
        a(this.gqD, this.gpX.bEq());
        if (this.gqk != null) {
            this.gqk.bHa();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.gqE == null) {
                this.gqE = new com.baidu.tieba.video.f(this.gpX.getActivity(), this.gpY);
            }
            this.gqE.h(postWriteCallBackData);
        }
    }

    public void bFk() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.gqT && this.gpX.getActivity() != null && this.gpX.getPageContext() != null) {
            View view = null;
            if (this.gqj != null && (headerViewsCount = this.gqj.getHeaderViewsCount()) < this.gqj.getChildCount()) {
                view = this.gqj.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).M(0).F(true).G(false).E(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.l.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        l.this.gpX.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(l.this.gpX.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(l.this.gpX.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.l.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aFB().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c fI = dVar.fI();
                fI.setShouldCheckLocInWindow(false);
                fI.show(this.gpX.getActivity());
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fI != null) {
                            fI.dismiss();
                        }
                    }
                }, 4000L);
                this.gqT = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.gqM != null) {
            this.gqM.setDeleteCallback(aVar);
        }
    }

    public void bFl() {
        if (this.gqM != null) {
            this.gqM.bFl();
        }
    }

    public void aWl() {
        if (this.gqM != null) {
            this.gqM.aWl();
        }
    }

    public void az(String str, int i) {
        if (this.gqO == null) {
            this.gqO = new TextView(this.gpX.getActivity());
            this.gqO.setGravity(19);
            this.gqO.setPadding(com.baidu.adp.lib.util.l.getDimens(this.gpX.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.gpX.getActivity(), R.dimen.ds34), 0);
            this.gqO.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gpX.getActivity(), R.dimen.tbds112)));
            this.gqO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gpX.getActivity(), R.dimen.fontsize30));
            this.gqO.setMaxLines(2);
            this.gqO.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.gqO.setTextColor(ContextCompat.getColor(this.gpX.getActivity(), R.color.cp_cont_a));
        }
        this.gqN.setBackgroundColor(i);
        this.gqO.setText(str);
        this.gqN.a(this.gpX.getActivity(), this.gqO, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.CD != null) {
            this.CD.setExpanded(z);
        }
    }

    public void bFm() {
        if (this.mPullView != null) {
            this.mPullView.aHO();
        }
        startPullRefresh();
    }

    public void sm() {
        if (bFd() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bFd().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cRf != 0 && biVar.cRe != null && this.gpX.bDI() != null && this.gpX.bDI().bIK() != null) {
                            int[] imageWidthAndHeight = this.gpX.bDI().bIK().imageWidthAndHeight(biVar.cRe);
                            biVar.cRf = imageWidthAndHeight[0];
                            biVar.cRg = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.5
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.bFd().notifyDataSetChanged();
                        if (!l.this.mIsBackground) {
                            l.this.gqA.a(l.this.gpO, l.this.ejQ, l.this.gqt, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bFn() {
        if (this.gqu == null) {
            return false;
        }
        return this.gqu.bFn();
    }

    public Context getContext() {
        if (this.gpX == null) {
            return null;
        }
        return this.gpX.getTbPageContext().getPageActivity();
    }
}
