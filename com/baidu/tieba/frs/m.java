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
public class m {
    private AppBarLayout CD;
    private PbListView elM;
    private BdSwipeRefreshLayout enY;
    private ImageView fQs;
    private NoNetworkView fVM;
    private CommonTipView gaf;
    private com.baidu.adp.widget.ListView.k gbf;
    private FrsFragment gqW;
    private ObservedChangeLinearLayout grB;
    private com.baidu.tieba.frs.entelechy.b.a grC;
    private com.baidu.tieba.video.f grD;
    private AppBarLayoutStickyBehavior grE;
    private FrsHeaderViewContainer grF;
    private CollapsingToolbarLayout grG;
    private com.baidu.tieba.frs.vc.h grK;
    private FrsMultiDelBottomMenuView grL;
    private NavigationBarCoverTip grM;
    private TextView grN;
    private boolean grS;
    private View gra;
    private com.baidu.tieba.c.b grb;
    private ImageView grc;
    private TextView grd;
    private ViewStub gre;
    private BdTypeRecyclerView gri;
    private com.baidu.tieba.frs.entelechy.a.ai grj;
    private FloatingAnimationView grk;
    private com.baidu.tieba.c.c grl;
    private View.OnClickListener grn;
    private View gro;
    private View grp;
    private int grr;
    private com.baidu.tieba.frs.vc.d grt;
    private com.baidu.tieba.frs.entelechy.b.c gru;
    private com.baidu.tieba.frs.vc.l grv;
    private GifView grw;
    private TbImageView grx;
    private HashSet<String> gry;
    private com.baidu.tieba.play.m grz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean gqV = false;
    private NoPressedRelativeLayout gqX = null;
    private CoordinatorLayout gqY = null;
    private View gqZ = null;
    private FrameLayout grf = null;
    private TbImageView grg = null;
    private TbImageView grh = null;
    private com.baidu.tbadk.core.dialog.b grm = null;
    private NoNetworkView.a gmG = null;
    private boolean grq = true;
    private boolean mHasMore = true;
    private boolean grs = false;
    private int gqN = 0;
    private int eku = 0;
    private View aCq = null;
    private View grA = null;
    private boolean eLP = false;
    private boolean cwW = true;
    private boolean grH = true;
    private int grI = -1;
    private int grJ = -1;
    private int grO = 0;
    private int grP = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener gbh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.m.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (m.this.gbf == null) {
                        m.this.gbf = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    m.this.gbf.a(m.this.gri, 2);
                } else if (m.this.gbf != null) {
                    m.this.gbf.kB();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener grQ = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.m.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            m.this.a(appBarLayout, i);
            if (m.this.grJ != i && Math.abs(i) >= 0 && m.this.bEU() != -1) {
                if (Math.abs(i) >= m.this.bEU()) {
                    if (m.this.grH) {
                        m.this.grH = false;
                        m.this.lq(m.this.grH);
                    }
                } else if (!m.this.grH) {
                    m.this.grH = true;
                    m.this.lq(m.this.grH);
                }
                int bEQ = m.this.bEQ() + m.this.bEP() + m.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bEQ;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && m.this.grJ - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        m.this.sJ(Math.abs(bEQ - totalScrollRange2));
                        if (m.this.grA != null) {
                            m.this.grA.setVisibility(0);
                        }
                    } else if (m.this.grA != null) {
                        if (m.this.bEO() != UtilHelper.getStatusBarHeight()) {
                            m.this.sJ(0);
                        }
                        m.this.grA.setVisibility(8);
                    }
                    if (m.this.mNavigationBar != null) {
                        if (m.this.eLP) {
                            m.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            m.this.lv(false);
                        } else if (m.this.mNavigationBar.mCenterText != null) {
                            m.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    m.this.grJ = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable grR = new Runnable() { // from class: com.baidu.tieba.frs.m.13
        @Override // java.lang.Runnable
        public void run() {
            if (m.this.gre != null) {
                m.this.grf.setVisibility(0);
                m.this.grh.setVisibility(0);
                m.this.grg.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.gqW != null && appBarLayout != null && this.gqW.bDW() != null && this.gqW.getPageContext() != null) {
            int bEP = bEP() + getNavigationBarHeight() + bEQ();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bDW = this.gqW.bDW();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.gqW.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.gqW.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.gqZ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.gqW != null && this.gqW.bEd();
            if (totalScrollRange <= 0) {
                if (this.grP != 2) {
                    bDW.uA(2);
                }
                this.grP = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bEP) {
                if (this.grP != 1) {
                    bDW.uA(1);
                }
                this.grP = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.grP != 0) {
                    bDW.uA(0);
                }
                this.grP = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.gqW.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.gqZ.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bEM() {
        return this.grB;
    }

    public View At() {
        return this.aCq;
    }

    public View bEN() {
        return this.grA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEO() {
        if (this.aCq == null) {
            return 0;
        }
        return this.aCq.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEP() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEQ() {
        if (this.fVM == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fVM.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ(int i) {
        View At = At();
        View bEN = bEN();
        if (UtilHelper.canUseStyleImmersiveSticky() && At != null && bEN != null && At.getLayoutParams() != null && bEN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = At.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            At.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bEN.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bEN.setLayoutParams(layoutParams2);
        }
    }

    public m(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.gqW = null;
        this.grn = null;
        this.grr = 0;
        this.gqW = frsFragment;
        this.grn = onClickListener;
        MessageManager.getInstance().registerListener(this.gbh);
        a(aVar, z);
        this.gry = new HashSet<>();
        this.grr = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.grK = hVar;
    }

    private boolean bER() {
        return this.grK != null && this.grK.bKS();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.grC = aVar;
        View rootView = this.gqW.getRootView();
        if (this.gqX == null) {
            this.gqX = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.gqZ == null) {
            this.gqZ = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.gqY == null) {
            this.gqY = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.grp == null) {
            this.grp = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.grG == null) {
            this.grG = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.grF == null) {
            this.grF = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.grB == null) {
            this.grB = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.grB.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.m.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        m.this.grG.setMinimumHeight(i2);
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
        if (this.gqW.bEC()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.gro == null) {
            this.gro = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bGX = aVar.bGX();
            if (bGX != null) {
                bGX.bP(this.gro);
            }
        }
        if (this.gra == null) {
            this.gra = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gra.setOnClickListener(this.grn);
            this.mBackImageView = (ImageView) this.gra.findViewById(R.id.widget_navi_back_button);
        }
        if (this.grb == null) {
            this.grb = new com.baidu.tieba.c.b(this.gqW.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.grb.getView(), (View.OnClickListener) null);
            this.fQs = this.grb.bwm();
            this.grb.getView().setOnClickListener(this.grn);
        }
        if (this.grc == null) {
            this.grc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.grc.setOnClickListener(this.grn);
        }
        if (this.grd == null) {
            this.grd = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.grd.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.gqW.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.grd.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.c(this.grd, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.grd, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.gqW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.gqW.getPageContext());
        }
        this.mPullView.setTag(this.gqW.getUniqueId());
        if (this.enY == null) {
            this.enY = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.enY.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.enY, R.color.cp_bg_line_c);
        }
        if (this.gri == null) {
            this.gri = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.m.8
            int grV = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.grV--;
                if (this.grV == 0) {
                    m.this.gri.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.grV++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.gri.setItemAnimator(defaultItemAnimator);
        this.gri.setLayoutManager(new LinearLayoutManager(this.gri.getContext()) { // from class: com.baidu.tieba.frs.m.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gbf = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.gbf.a(this.gri, 2);
        }
        this.gri.setScrollable(this.gqW);
        this.gri.setFadingEdgeLength(0);
        this.gri.setOverScrollMode(2);
        this.gqX.setBottomOrderView(this.gri);
        this.gri.setOnTouchListener(this.gqW.dsa);
        this.gri.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.m.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (m.this.grz != null) {
                    m.this.grz.cl(view);
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
        if (this.elM == null) {
            this.elM = new PbListView(this.gqW.getPageContext().getPageActivity());
            this.elM.getView();
        }
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.elM.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gqW.getActivity(), R.dimen.tbds182));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gri.setOnSrollToBottomListener(this.gqW);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.m.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.gqW.bEv();
                if (m.this.gqW != null && m.this.CD != null) {
                    m.this.gqW.bEF();
                    m.this.CD.setExpanded(true);
                    if (m.this.grz != null) {
                        m.this.grz.a(m.this.gqN, m.this.eku, false, true);
                    }
                }
            }
        });
        boolean aGI = com.baidu.tbadk.core.util.ar.aGH().aGI();
        if (this.grj == null) {
            this.grj = aVar.a(this.gqW, this.gri, aGI);
        }
        hv(false);
        if (!z) {
            if (this.fVM == null) {
                this.fVM = new NoNetworkView(this.gqW.getActivity());
                this.fVM.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.grB.addView(this.fVM);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fVM.setVisibility(8);
            } else {
                this.fVM.setVisibility(0);
            }
            this.fVM.onChangeSkinType(this.gqW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bFb();
        if (this.grt == null) {
            this.grt = aVar.a(this.gqW, this.gqX);
            this.grt.b(this.gqW.bEG());
        }
        if (this.gru == null) {
            this.gru = aVar.b(this.gqW, this.gqX);
            lt(true);
        }
        if (this.aCq == null) {
            this.aCq = rootView.findViewById(R.id.statebar_view);
        }
        if (this.grA == null) {
            this.grA = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.grz == null) {
            this.grz = new com.baidu.tieba.play.m(this.gqW.getPageContext(), this.gri);
        }
        this.grz.Az(1);
        this.grz.setUniqueId(this.gqW.getUniqueId());
        this.grM = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.grv == null) {
            this.grv = new com.baidu.tieba.frs.vc.l(this.gqW, this.grM);
        }
        if (this.CD == null) {
            this.CD = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.CD.addOnOffsetChangedListener(this.grQ);
            this.grH = true;
            this.grI = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.CD.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.grE = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.grL = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.grL.setPageContext(this.gqW.getPageContext());
        this.grk = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.grk.setPageId(this.gqW.getUniqueId());
        this.grl = new com.baidu.tieba.c.c(this.gqW.getTbPageContext(), this.grk, 2);
    }

    public void onPrimary(boolean z) {
        if (z && this.grl != null) {
            this.grl.baH();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.grl != null) {
            this.grl.a(oVar);
        }
    }

    private void bES() {
        ViewGroup.LayoutParams layoutParams;
        this.eLP = bER();
        if (this.grF != null && (layoutParams = this.grF.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.eLP) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bEP(), 0, 0);
            }
            this.grF.requestLayout();
        }
    }

    public void bET() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.grB != null) {
            bES();
            if (this.eLP) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.aCq != null) {
                    this.aCq.setAlpha(1.0f);
                }
                if (this.grA != null) {
                    this.grA.setAlpha(1.0f);
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
    public void lq(boolean z) {
        if (z && this.gqW != null && this.gqW.bDV() != null) {
            this.gqW.bDV().bKW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bEU() {
        int i;
        if (this.CD == null) {
            return this.grI;
        }
        if (this.grI != -1) {
            return this.grI;
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
        this.grI = Math.max(0, this.CD.getTotalScrollRange() - Math.abs(i2));
        return this.grI;
    }

    public void Bg(String str) {
        if (this.grv != null) {
            this.grv.Bg(str);
        }
    }

    public com.baidu.tieba.play.m bEV() {
        return this.grz;
    }

    public com.baidu.tieba.frs.entelechy.b.c bEW() {
        return this.gru;
    }

    public void lr(boolean z) {
        if (this.grt != null) {
            this.grt.lr(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bEX() {
        return this.grt;
    }

    public void M(boolean z, boolean z2) {
        if (this.cwW && this.gru != null) {
            this.gru.M(z, z2);
        }
    }

    public void ls(boolean z) {
        this.cwW = z;
        if (!this.cwW && this.gru != null) {
            this.gru.M(false, false);
        }
    }

    public void bEY() {
        if (this.cwW && this.gru != null) {
            this.gru.M(false, false);
        }
        sK(8);
        this.grc.setVisibility(8);
        lr(false);
        this.gri.setVisibility(8);
        this.grF.setVisibility(8);
    }

    public void bEZ() {
        if (this.cwW && this.gru != null) {
            this.gru.M(true, false);
        }
        sK(0);
        bFa();
        lr(this.gqW.bEI());
        this.gri.setVisibility(0);
        this.grF.setVisibility(0);
    }

    private void sK(int i) {
        if (this.grb != null) {
            this.grb.setVisibility(i);
        }
    }

    private void bFa() {
        this.grc.setVisibility(0);
    }

    public void lt(boolean z) {
        if (this.gru != null) {
            this.gru.lU(z);
        }
    }

    private void bFb() {
        if (this.grw == null) {
            View rootView = this.gqW.getRootView();
            this.grw = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.grx = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.grx.setPageId(this.gqW.getUniqueId());
            this.grw.setLayerType(1, null);
            this.grx.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bFc() {
        return this.gra;
    }

    public void g(NoNetworkView.a aVar) {
        this.gmG = aVar;
        if (this.fVM != null) {
            this.fVM.a(this.gmG);
        }
    }

    public void hv(boolean z) {
        this.gqV = z;
        if (z) {
            if (this.gru != null) {
                this.gru.bHB();
                return;
            }
            return;
        }
        this.gri.getAdapter().notifyDataSetChanged();
        if (this.gru != null) {
            this.gru.bHC();
        }
    }

    public void lu(boolean z) {
        if (this.gru != null) {
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
        this.gri.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.grj.a(sVar);
    }

    public void setForumName(String str) {
        this.grj.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gbh);
        if (this.grz != null) {
            this.grz.destroy();
        }
        if (this.grv != null) {
            this.grv.onDestory();
        }
        if (this.grL != null) {
            this.grL.setPageContext(null);
        }
        this.grj.onDestory();
        this.gri.setOnSrollToBottomListener(null);
        this.gri.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.grR);
        if (this.gaf != null) {
            this.gaf.onDestroy();
        }
        this.gry.clear();
        if (this.grt != null) {
            this.grt.bKC();
        }
        if (this.grD != null) {
            this.grD.bGI();
        }
        if (this.grl != null) {
            this.grl.onDestroy();
        }
        if (this.grM != null) {
            this.grM.onDestroy();
        }
        if (this.grL != null) {
            this.grL.onDestroy();
        }
    }

    public boolean bFd() {
        if (this.CD == null || this.grE == null || !this.grE.isSticky()) {
            return this.grt != null && this.grt.bFd();
        }
        if (this.gri != null) {
            this.gri.setSelection(0);
        }
        this.grE.expandedAppBarLayout(this.CD);
        return true;
    }

    public boolean bEA() {
        return this.gqV;
    }

    public void bgE() {
        this.gri.setVisibility(0);
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
            com.baidu.tbadk.core.i.azR().setForumNameForWaterImage(str);
        }
    }

    public void bFe() {
        if (this.grj != null) {
            this.grj.notifyDataSetChanged();
        }
    }

    public void asQ() {
        if (this.grj instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.grj).asQ();
        }
    }

    private void bFf() {
        if (this.grm == null && this.gqW.getPageContext() != null) {
            String[] strArr = {this.gqW.getPageContext().getPageActivity().getString(R.string.take_photo), this.gqW.getPageContext().getPageActivity().getString(R.string.album)};
            this.grm = new com.baidu.tbadk.core.dialog.b(this.gqW.getPageContext().getPageActivity());
            this.grm.sS(this.gqW.getPageContext().getPageActivity().getString(R.string.operation));
            this.grm.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.m.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        m.this.gqW.bEB();
                    } else if (i == 1 && m.this.gqW.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(m.this.gqW.getPageContext().getPageActivity());
                    }
                }
            });
            this.grm.d(this.gqW.getPageContext());
        }
    }

    public void bFg() {
        bFf();
        if (this.grm != null) {
            this.grm.aEH();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.v.isEmpty(switchThreadDataToThreadCardInfo)) {
                o oVar = new o();
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
                arrayList3.add(oVar);
                if (this.gqW != null && this.gqW.bDT() != null && this.gqW.bDT().bJw() == 0) {
                    oVar.sT(this.gqW.bDT().bJD());
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
                        ((bi) mVar).cRt.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.grj.b(arrayList2, frsViewData);
            if (this.grz != null && this.gqN != 0) {
                this.grz.a(this.gqN, this.eku, this.grs, true);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gri;
    }

    public void bFh() {
        this.grj.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gqW.getPageContext(), 1);
        aVar.a(this.gri);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.gqW.getForumName());
        hashMap.put("forum_id", this.gqW.getForumId());
        aVar.setParams(hashMap);
        aVar.ao(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.grt != null) {
            this.grt.bKD();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        sL(TbadkCoreApplication.getInst().getSkinType());
        if (this.grt != null) {
            this.grt.bKE();
        }
    }

    public void release() {
        if (this.fVM != null && this.gmG != null) {
            this.fVM.b(this.gmG);
        }
    }

    public ImageView bFi() {
        return this.grc;
    }

    public TextView bFj() {
        return this.grd;
    }

    public View bFk() {
        if (this.grb != null) {
            return this.grb.getView();
        }
        return null;
    }

    public void D(int i, boolean z) {
        if (this.grb != null) {
            this.grb.r(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.gqW, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gqW.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.grx != null) {
            this.grx.invalidate();
        }
        if (this.grj != null) {
            this.grj.bHv();
            this.grj.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.gqW.getPageContext(), this.gqX);
        if (this.fVM != null) {
            this.fVM.onChangeSkinType(this.gqW.getPageContext(), i);
        }
        if (this.elM != null) {
            this.elM.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.elM.changeSkin(i);
        }
        sL(i);
        if (this.gru != null) {
            this.gru.onChangeSkinType(i);
        }
        if (this.grt != null) {
            this.grt.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grL != null) {
            this.grL.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.enY, R.color.cp_bg_line_d);
        if (this.gqW != null && this.gqW.bEd()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqZ, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gqZ, R.color.cp_bg_line_d);
        }
    }

    private void sL(int i) {
        if (this.gqW != null) {
            sM(i);
        }
    }

    private void sM(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gqW.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gro, R.color.cp_bg_line_c, i);
            if (this.grb != null) {
                this.grb.onChangeSkinType(i);
            }
            if (this.grc != null) {
                SvgManager.aGG().a(this.grc, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.aCq, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.grA, R.color.cp_bg_line_h);
        lv(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lv(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.eLP) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.grO != 0) {
                    SvgManager.aGG().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aGG().a(this.grc, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aGG().a(this.fQs, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.grO = 0;
                }
            } else if (z || this.grO != 1) {
                SvgManager.aGG().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGG().a(this.grc, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aGG().a(this.fQs, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.grO = 1;
            }
            bFl();
        }
    }

    private void bFl() {
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
                if (this.fQs != null) {
                    this.fQs.setAlpha(f);
                }
                if (this.grc != null) {
                    this.grc.setAlpha(f);
                }
            }
            if (this.grd != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.grd.setAlpha(f2);
                this.grd.setClickable(f2 > 0.0f);
            }
            if (this.aCq != null) {
                this.aCq.setAlpha(alpha);
            }
            if (this.grA != null) {
                this.grA.setAlpha(alpha);
            }
            if (this.gro != null) {
                this.gro.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.gri != null) {
            this.gri.setSelection(0);
        }
        if (this.CD != null) {
            this.CD.setExpanded(true);
        }
        if (this.enY != null && this.enY.isEnabled()) {
            this.enY.setRefreshing(true);
        }
    }

    public void lw(boolean z) {
        if (z) {
            this.enY.setRefreshing(false);
        } else {
            this.enY.interruptRefresh();
        }
    }

    public void lx(boolean z) {
        this.enY.setEnabled(z);
    }

    public void ly(boolean z) {
        this.grq = z;
        if (this.grq) {
            this.elM.setText(this.gqW.getResources().getString(R.string.load_more));
            if (this.gri.getChildAt(this.gri.getChildCount() - 1) == this.elM.getView()) {
                this.elM.startLoadData();
                this.gqW.bck();
                return;
            }
            this.elM.endLoadData();
            return;
        }
        this.elM.setText(this.gqW.getResources().getString(R.string.load_more_must_after_delete));
        this.elM.endLoadData();
    }

    public boolean bFm() {
        if (this.grq) {
            return false;
        }
        this.elM.setText(this.gqW.getResources().getString(R.string.load_more_must_after_delete));
        this.elM.endLoadData();
        return true;
    }

    public boolean bFn() {
        return this.gre != null && this.grh.getVisibility() == 0;
    }

    public void bFo() {
        if (this.gre != null) {
            this.grf.setVisibility(0);
            this.grh.setVisibility(8);
            this.grg.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.grR, 5000L);
        }
    }

    public void a(bt btVar) {
        if (this.gre == null) {
            View rootView = this.gqW.getRootView();
            this.gre = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.gre.setVisibility(0);
            this.grf = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.grg = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.grh = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.grg.setPageId(this.gqW.getUniqueId());
            this.grh.setPageId(this.gqW.getUniqueId());
            this.grg.setDefaultBgResource(R.color.common_color_10022);
            this.grg.setDefaultResource(0);
            this.grh.setDefaultBgResource(R.color.common_color_10022);
            this.grh.setDefaultResource(0);
            this.grf.setOnClickListener(this.grn);
        }
        this.grf.setVisibility(0);
        String aEz = btVar.aEz();
        String aEA = btVar.aEA();
        this.grg.startLoad(aEz, 10, false);
        this.grh.startLoad(aEA, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.grR, 5000L);
    }

    public void bFp() {
        if (this.gre != null && this.grf != null) {
            this.grf.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.ai bFq() {
        return this.grj;
    }

    public RelativeLayout bsL() {
        return this.gqX;
    }

    public View bFr() {
        return this.grp;
    }

    public void sN(int i) {
        if (this.gqZ != null) {
            this.gqZ.setVisibility(i);
        }
    }

    public void bFs() {
        if (com.baidu.tbadk.n.m.aRq().aRr()) {
            int lastVisiblePosition = this.gri.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gri.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof q)) {
                    q qVar = (q) childAt.getTag();
                    if (qVar.gsg != null) {
                        com.baidu.tbadk.n.h perfLog = qVar.gsg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dDW = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            qVar.gsg.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        qVar.gsg.startLogPerf();
                    }
                    if (qVar.gsf != null && (qVar.gsf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = qVar.gsf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dDW = true;
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

    public NavigationBar beR() {
        return this.mNavigationBar;
    }

    public void bdx() {
        this.mHasMore = true;
        this.gri.setNextPage(this.elM);
        if (this.grr > 0) {
            this.elM.showEmptyView(this.grr);
        }
        this.elM.setOnClickListener(null);
        this.elM.startLoadData();
    }

    public void bdy() {
        this.mHasMore = false;
        this.gri.setNextPage(this.elM);
        if (this.grr > 0) {
            this.elM.showEmptyView(this.grr);
        }
        this.elM.setOnClickListener(null);
        this.elM.endLoadData();
        this.elM.setText(this.gqW.getResources().getString(R.string.list_has_no_more));
    }

    public void bFt() {
        this.mHasMore = true;
        this.gri.setNextPage(this.elM);
        this.elM.setOnClickListener(this.grn);
        if (this.grr > 0) {
            this.elM.showEmptyView(this.grr);
        }
        this.elM.endLoadData();
        this.elM.setText(this.gqW.getResources().getString(R.string.list_click_load_more));
    }

    public View bFu() {
        if (this.elM == null) {
            return null;
        }
        return this.elM.getView();
    }

    public void sO(int i) {
        if (this.grL != null) {
            this.grL.setVisibility(i);
        }
    }

    public void sP(int i) {
        if (this.grL != null) {
            this.grL.setSelectNumber(i);
        }
    }

    public void bdz() {
        this.mHasMore = false;
        this.gri.setNextPage(null);
    }

    public boolean bFv() {
        return this.elM.getView().getParent() != null && this.mHasMore;
    }

    public void sQ(int i) {
        this.grr = i;
    }

    public void sR(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.gaf == null) {
                    this.gaf = new CommonTipView(this.gqW.getActivity());
                }
                this.gaf.setText(R.string.frs_login_tip);
                this.gaf.b((FrameLayout) bFr(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void lz(boolean z) {
        this.mIsBackground = z;
        if (this.grz != null) {
            boolean z2 = (this.gqW == null || this.gqW.bDW() == null || this.gqW.bDW().bLn() == null) ? true : this.gqW.bDW().bLn().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.grz.oH(false);
                this.grz.cdn();
                return;
            }
            this.grz.oH(true);
            this.grz.a(this.gqN, this.eku, this.grs, true);
        }
    }

    public void bE(int i, int i2) {
        if (this.grz != null) {
            this.grz.a(i, i2, this.grs, 1);
        }
    }

    public void bF(int i, int i2) {
        this.gqN = i;
        this.eku = i2;
    }

    public void lA(boolean z) {
        this.grs = z;
    }

    public void sS(int i) {
        if (this.gri != null && this.gri.getChildCount() >= 0) {
            if (this.gri.getFirstVisiblePosition() > 8) {
                this.gri.scrollToPosition(8);
            }
            this.gri.smoothScrollToPosition(i);
        }
    }

    public void bFw() {
        a(this.grC, this.gqW.bEC());
        if (this.grj != null) {
            this.grj.bHs();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.grD == null) {
                this.grD = new com.baidu.tieba.video.f(this.gqW.getActivity(), this.gqX);
            }
            this.grD.h(postWriteCallBackData);
        }
    }

    public void bFx() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.grS && this.gqW.getActivity() != null && this.gqW.getPageContext() != null) {
            View view = null;
            if (this.gri != null && (headerViewsCount = this.gri.getHeaderViewsCount()) < this.gri.getChildCount()) {
                view = this.gri.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).M(0).F(true).G(false).E(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.m.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        m.this.gqW.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(m.this.gqW.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(m.this.gqW.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.m.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c fI = dVar.fI();
                fI.setShouldCheckLocInWindow(false);
                fI.show(this.gqW.getActivity());
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.m.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fI != null) {
                            fI.dismiss();
                        }
                    }
                }, 4000L);
                this.grS = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.grL != null) {
            this.grL.setDeleteCallback(aVar);
        }
    }

    public void bFy() {
        if (this.grL != null) {
            this.grL.bFy();
        }
    }

    public void aWs() {
        if (this.grL != null) {
            this.grL.aWs();
        }
    }

    public void az(String str, int i) {
        if (this.grN == null) {
            this.grN = new TextView(this.gqW.getActivity());
            this.grN.setGravity(19);
            this.grN.setPadding(com.baidu.adp.lib.util.l.getDimens(this.gqW.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.gqW.getActivity(), R.dimen.ds34), 0);
            this.grN.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gqW.getActivity(), R.dimen.tbds112)));
            this.grN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gqW.getActivity(), R.dimen.fontsize30));
            this.grN.setMaxLines(2);
            this.grN.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.grN.setTextColor(ContextCompat.getColor(this.gqW.getActivity(), R.color.cp_cont_a));
        }
        this.grM.setBackgroundColor(i);
        this.grN.setText(str);
        this.grM.a(this.gqW.getActivity(), this.grN, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.CD != null) {
            this.CD.setExpanded(z);
        }
    }

    public void bFz() {
        if (this.mPullView != null) {
            this.mPullView.aHV();
        }
        startPullRefresh();
    }

    public void sr() {
        if (bFq() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bFq().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cRu != 0 && biVar.cRt != null && this.gqW.bDT() != null && this.gqW.bDT().bIZ() != null) {
                            int[] imageWidthAndHeight = this.gqW.bDT().bIZ().imageWidthAndHeight(biVar.cRt);
                            biVar.cRu = imageWidthAndHeight[0];
                            biVar.cRv = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.m.5
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.bFq().notifyDataSetChanged();
                        if (!m.this.mIsBackground) {
                            m.this.grz.a(m.this.gqN, m.this.eku, m.this.grs, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bFA() {
        if (this.grt == null) {
            return false;
        }
        return this.grt.bFA();
    }

    public Context getContext() {
        if (this.gqW == null) {
            return null;
        }
        return this.gqW.getTbPageContext().getPageActivity();
    }
}
