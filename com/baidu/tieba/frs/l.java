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
/* loaded from: classes7.dex */
public class l {
    private AppBarLayout Ck;
    private PbListView ehe;
    private BdSwipeRefreshLayout ejj;
    private ImageView fNa;
    private NoNetworkView fSu;
    private CommonTipView fXi;
    private com.baidu.adp.widget.ListView.k fYi;
    private FrsFragment gnW;
    private ObservedChangeLinearLayout goB;
    private com.baidu.tieba.frs.entelechy.b.a goC;
    private com.baidu.tieba.video.f goD;
    private AppBarLayoutStickyBehavior goE;
    private FrsHeaderViewContainer goF;
    private CollapsingToolbarLayout goG;
    private com.baidu.tieba.frs.vc.h goK;
    private FrsMultiDelBottomMenuView goL;
    private NavigationBarCoverTip goM;
    private TextView goN;
    private boolean goS;
    private View goa;
    private com.baidu.tieba.c.b gob;
    private ImageView goc;
    private TextView god;
    private ViewStub goe;
    private BdTypeRecyclerView goi;
    private com.baidu.tieba.frs.entelechy.a.af goj;
    private FloatingAnimationView gok;
    private com.baidu.tieba.c.c gol;
    private View.OnClickListener gon;
    private View goo;
    private View gop;
    private int gor;
    private com.baidu.tieba.frs.vc.d got;
    private com.baidu.tieba.frs.entelechy.b.c gou;
    private com.baidu.tieba.frs.vc.l gov;
    private GifView gow;
    private TbImageView gox;
    private HashSet<String> goy;
    private com.baidu.tieba.play.m goz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean gnV = false;
    private NoPressedRelativeLayout gnX = null;
    private CoordinatorLayout gnY = null;
    private View gnZ = null;
    private FrameLayout gof = null;
    private TbImageView gog = null;
    private TbImageView goh = null;
    private com.baidu.tbadk.core.dialog.b gom = null;
    private NoNetworkView.a gjI = null;
    private boolean goq = true;
    private boolean mHasMore = true;
    private boolean gos = false;
    private int gnN = 0;
    private int efM = 0;
    private View axK = null;
    private View goA = null;
    private boolean eHl = false;
    private boolean csH = true;
    private boolean goH = true;
    private int goI = -1;
    private int goJ = -1;
    private int goO = 0;
    private int goP = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener fYk = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (l.this.fYi == null) {
                        l.this.fYi = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    l.this.fYi.a(l.this.goi, 2);
                } else if (l.this.fYi != null) {
                    l.this.fYi.km();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener goQ = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.l.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            l.this.a(appBarLayout, i);
            if (l.this.goJ != i && Math.abs(i) >= 0 && l.this.bDe() != -1) {
                if (Math.abs(i) >= l.this.bDe()) {
                    if (l.this.goH) {
                        l.this.goH = false;
                        l.this.lh(l.this.goH);
                    }
                } else if (!l.this.goH) {
                    l.this.goH = true;
                    l.this.lh(l.this.goH);
                }
                int bDa = l.this.bDa() + l.this.bCZ() + l.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bDa;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && l.this.goJ - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        l.this.sB(Math.abs(bDa - totalScrollRange2));
                        if (l.this.goA != null) {
                            l.this.goA.setVisibility(0);
                        }
                    } else if (l.this.goA != null) {
                        if (l.this.bCY() != UtilHelper.getStatusBarHeight()) {
                            l.this.sB(0);
                        }
                        l.this.goA.setVisibility(8);
                    }
                    if (l.this.mNavigationBar != null) {
                        if (l.this.eHl) {
                            l.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            l.this.lm(false);
                        } else if (l.this.mNavigationBar.mCenterText != null) {
                            l.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    l.this.goJ = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable goR = new Runnable() { // from class: com.baidu.tieba.frs.l.13
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.goe != null) {
                l.this.gof.setVisibility(0);
                l.this.goh.setVisibility(0);
                l.this.gog.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.gnW != null && appBarLayout != null && this.gnW.bCi() != null && this.gnW.getPageContext() != null) {
            int bCZ = bCZ() + getNavigationBarHeight() + bDa();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bCi = this.gnW.bCi();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.gnW.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.gnW.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.gnZ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.gnW != null && this.gnW.bCp();
            if (totalScrollRange <= 0) {
                if (this.goP != 2) {
                    bCi.un(2);
                }
                this.goP = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bCZ) {
                if (this.goP != 1) {
                    bCi.un(1);
                }
                this.goP = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.goP != 0) {
                    bCi.un(0);
                }
                this.goP = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.gnW.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.gnZ.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bCW() {
        return this.goB;
    }

    public View xT() {
        return this.axK;
    }

    public View bCX() {
        return this.goA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCY() {
        if (this.axK == null) {
            return 0;
        }
        return this.axK.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCZ() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bDa() {
        if (this.fSu == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fSu.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB(int i) {
        View xT = xT();
        View bCX = bCX();
        if (UtilHelper.canUseStyleImmersiveSticky() && xT != null && bCX != null && xT.getLayoutParams() != null && bCX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = xT.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            xT.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bCX.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bCX.setLayoutParams(layoutParams2);
        }
    }

    public l(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.gnW = null;
        this.gon = null;
        this.gor = 0;
        this.gnW = frsFragment;
        this.gon = onClickListener;
        MessageManager.getInstance().registerListener(this.fYk);
        a(aVar, z);
        this.goy = new HashSet<>();
        this.gor = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.goK = hVar;
    }

    private boolean bDb() {
        return this.goK != null && this.goK.bJa();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.goC = aVar;
        View rootView = this.gnW.getRootView();
        if (this.gnX == null) {
            this.gnX = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.gnZ == null) {
            this.gnZ = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.gnY == null) {
            this.gnY = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.gop == null) {
            this.gop = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.goG == null) {
            this.goG = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.goF == null) {
            this.goF = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.goB == null) {
            this.goB = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.goB.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.l.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        l.this.goG.setMinimumHeight(i2);
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
        if (this.gnW.bCN()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.goo == null) {
            this.goo = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bFd = aVar.bFd();
            if (bFd != null) {
                bFd.bP(this.goo);
            }
        }
        if (this.goa == null) {
            this.goa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.goa.setOnClickListener(this.gon);
            this.mBackImageView = (ImageView) this.goa.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gob == null) {
            this.gob = new com.baidu.tieba.c.b(this.gnW.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gob.getView(), (View.OnClickListener) null);
            this.fNa = this.gob.buA();
            this.gob.getView().setOnClickListener(this.gon);
        }
        if (this.goc == null) {
            this.goc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.goc.setOnClickListener(this.gon);
        }
        if (this.god == null) {
            this.god = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.god.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.gnW.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.god.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.b(this.god, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.god, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.gnW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.gnW.getPageContext());
        }
        this.mPullView.setTag(this.gnW.getUniqueId());
        if (this.ejj == null) {
            this.ejj = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.ejj.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.ejj, R.color.cp_bg_line_c);
        }
        if (this.goi == null) {
            this.goi = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.l.8
            int goV = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.goV--;
                if (this.goV == 0) {
                    l.this.goi.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.goV++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.goi.setItemAnimator(defaultItemAnimator);
        this.goi.setLayoutManager(new LinearLayoutManager(this.goi.getContext()) { // from class: com.baidu.tieba.frs.l.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fYi = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.fYi.a(this.goi, 2);
        }
        this.goi.setScrollable(this.gnW);
        this.goi.setFadingEdgeLength(0);
        this.goi.setOverScrollMode(2);
        this.gnX.setBottomOrderView(this.goi);
        this.goi.setOnTouchListener(this.gnW.dnp);
        this.goi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.l.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (l.this.goz != null) {
                    l.this.goz.cl(view);
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
        if (this.ehe == null) {
            this.ehe = new PbListView(this.gnW.getPageContext().getPageActivity());
            this.ehe.getView();
        }
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.ehe.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gnW.getActivity(), R.dimen.tbds182));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.goi.setOnSrollToBottomListener(this.gnW);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.l.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.gnW.bCG();
                if (l.this.gnW != null && l.this.Ck != null) {
                    l.this.gnW.bCP();
                    l.this.Ck.setExpanded(true);
                    if (l.this.goz != null) {
                        l.this.goz.a(l.this.gnN, l.this.efM, false, true);
                    }
                }
            }
        });
        boolean aEr = com.baidu.tbadk.core.util.ar.aEq().aEr();
        if (this.goj == null) {
            this.goj = aVar.a(this.gnW, this.goi, aEr);
        }
        hn(false);
        if (!z) {
            if (this.fSu == null) {
                this.fSu = new NoNetworkView(this.gnW.getActivity());
                this.fSu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.goB.addView(this.fSu);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fSu.setVisibility(8);
            } else {
                this.fSu.setVisibility(0);
            }
            this.fSu.onChangeSkinType(this.gnW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bDl();
        if (this.got == null) {
            this.got = aVar.a(this.gnW, this.gnX);
            this.got.b(this.gnW.bCQ());
        }
        if (this.gou == null) {
            this.gou = aVar.b(this.gnW, this.gnX);
            lk(true);
        }
        if (this.axK == null) {
            this.axK = rootView.findViewById(R.id.statebar_view);
        }
        if (this.goA == null) {
            this.goA = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.goz == null) {
            this.goz = new com.baidu.tieba.play.m(this.gnW.getPageContext(), this.goi);
        }
        this.goz.setUniqueId(this.gnW.getUniqueId());
        this.goM = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.gov == null) {
            this.gov = new com.baidu.tieba.frs.vc.l(this.gnW, this.goM);
        }
        if (this.Ck == null) {
            this.Ck = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Ck.addOnOffsetChangedListener(this.goQ);
            this.goH = true;
            this.goI = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Ck.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.goE = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.goL = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.goL.setPageContext(this.gnW.getPageContext());
        this.gok = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.gok.setPageId(this.gnW.getUniqueId());
        this.gol = new com.baidu.tieba.c.c(this.gnW.getTbPageContext(), this.gok, 2);
    }

    public void lg(boolean z) {
        if (z && this.gol != null) {
            this.gol.aYl();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.gol != null) {
            this.gol.a(oVar);
        }
    }

    private void bDc() {
        ViewGroup.LayoutParams layoutParams;
        this.eHl = bDb();
        if (this.goF != null && (layoutParams = this.goF.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.eHl) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bCZ(), 0, 0);
            }
            this.goF.requestLayout();
        }
    }

    public void bDd() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.goB != null) {
            bDc();
            if (this.eHl) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.axK != null) {
                    this.axK.setAlpha(1.0f);
                }
                if (this.goA != null) {
                    this.goA.setAlpha(1.0f);
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
    public void lh(boolean z) {
        if (z && this.gnW != null && this.gnW.bCh() != null) {
            this.gnW.bCh().bJf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bDe() {
        int i;
        if (this.Ck == null) {
            return this.goI;
        }
        if (this.goI != -1) {
            return this.goI;
        }
        int childCount = this.Ck.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Ck.getChildAt(childCount);
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
        this.goI = Math.max(0, this.Ck.getTotalScrollRange() - Math.abs(i2));
        return this.goI;
    }

    public void AO(String str) {
        if (this.gov != null) {
            this.gov.AO(str);
        }
    }

    public com.baidu.tieba.play.m bDf() {
        return this.goz;
    }

    public com.baidu.tieba.frs.entelechy.b.c bDg() {
        return this.gou;
    }

    public void li(boolean z) {
        if (this.got != null) {
            this.got.li(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bDh() {
        return this.got;
    }

    public void K(boolean z, boolean z2) {
        if (this.csH && this.gou != null) {
            this.gou.K(z, z2);
        }
    }

    public void lj(boolean z) {
        this.csH = z;
        if (!this.csH && this.gou != null) {
            this.gou.K(false, false);
        }
    }

    public void bDi() {
        if (this.csH && this.gou != null) {
            this.gou.K(false, false);
        }
        sC(8);
        this.goc.setVisibility(8);
        li(false);
        this.goi.setVisibility(8);
        this.goF.setVisibility(8);
    }

    public void bDj() {
        if (this.csH && this.gou != null) {
            this.gou.K(true, false);
        }
        sC(0);
        bDk();
        li(this.gnW.bCS());
        this.goi.setVisibility(0);
        this.goF.setVisibility(0);
    }

    private void sC(int i) {
        if (this.gob != null) {
            this.gob.setVisibility(i);
        }
    }

    private void bDk() {
        this.goc.setVisibility(0);
    }

    public void lk(boolean z) {
        if (this.gou != null) {
            this.gou.lM(z);
        }
    }

    private void bDl() {
        if (this.gow == null) {
            View rootView = this.gnW.getRootView();
            this.gow = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.gox = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.gox.setPageId(this.gnW.getUniqueId());
            this.gow.setLayerType(1, null);
            this.gox.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bDm() {
        return this.goa;
    }

    public void g(NoNetworkView.a aVar) {
        this.gjI = aVar;
        if (this.fSu != null) {
            this.fSu.a(this.gjI);
        }
    }

    public void hn(boolean z) {
        this.gnV = z;
        if (z) {
            if (this.gou != null) {
                this.gou.bFH();
                return;
            }
            return;
        }
        this.goi.getAdapter().notifyDataSetChanged();
        if (this.gou != null) {
            this.gou.bFI();
        }
    }

    public void ll(boolean z) {
        if (this.gou != null) {
            if (z) {
                K(false, true);
            } else {
                K(false, false);
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
        this.goi.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.goj.a(sVar);
    }

    public void setForumName(String str) {
        this.goj.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fYk);
        if (this.goz != null) {
            this.goz.destroy();
        }
        if (this.gov != null) {
            this.gov.onDestory();
        }
        if (this.goL != null) {
            this.goL.setPageContext(null);
        }
        this.goj.onDestory();
        this.goi.setOnSrollToBottomListener(null);
        this.goi.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.goR);
        if (this.fXi != null) {
            this.fXi.onDestroy();
        }
        this.goy.clear();
        if (this.got != null) {
            this.got.bIK();
        }
        if (this.goD != null) {
            this.goD.bER();
        }
        if (this.gol != null) {
            this.gol.onDestroy();
        }
        if (this.goM != null) {
            this.goM.onDestroy();
        }
        if (this.goL != null) {
            this.goL.onDestroy();
        }
    }

    public boolean bDn() {
        if (this.Ck == null || this.goE == null || !this.goE.isSticky()) {
            return this.got != null && this.got.bDn();
        }
        if (this.goi != null) {
            this.goi.setSelection(0);
        }
        this.goE.expandedAppBarLayout(this.Ck);
        return true;
    }

    public boolean bCL() {
        return this.gnV;
    }

    public void bem() {
        this.goi.setVisibility(0);
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
            com.baidu.tbadk.core.i.axy().setForumNameForWaterImage(str);
        }
    }

    public void bDo() {
        if (this.goj != null) {
            this.goj.notifyDataSetChanged();
        }
    }

    public void aqx() {
        if (this.goj instanceof com.baidu.tieba.frs.entelechy.a.q) {
            ((com.baidu.tieba.frs.entelechy.a.q) this.goj).aqx();
        }
    }

    private void bDp() {
        if (this.gom == null && this.gnW.getPageContext() != null) {
            String[] strArr = {this.gnW.getPageContext().getPageActivity().getString(R.string.take_photo), this.gnW.getPageContext().getPageActivity().getString(R.string.album)};
            this.gom = new com.baidu.tbadk.core.dialog.b(this.gnW.getPageContext().getPageActivity());
            this.gom.sD(this.gnW.getPageContext().getPageActivity().getString(R.string.operation));
            this.gom.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.l.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        l.this.gnW.bCM();
                    } else if (i == 1 && l.this.gnW.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(l.this.gnW.getPageContext().getPageActivity());
                    }
                }
            });
            this.gom.d(this.gnW.getPageContext());
        }
    }

    public void bDq() {
        bDp();
        if (this.gom != null) {
            this.gom.aCq();
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
                if (this.gnW != null && this.gnW.bCf() != null && this.gnW.bCf().bHE() == 0) {
                    nVar.sL(this.gnW.bCf().bHL());
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
                        ((bi) mVar).cNb.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.goj.b(arrayList2, frsViewData);
            if (this.goz != null && this.gnN != 0) {
                this.goz.a(this.gnN, this.efM, this.gos, true);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.goi;
    }

    public void bDr() {
        this.goj.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gnW.getPageContext(), 1);
        aVar.a(this.goi);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.gnW.getForumName());
        hashMap.put("forum_id", this.gnW.getForumId());
        aVar.setParams(hashMap);
        aVar.am(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.got != null) {
            this.got.bIL();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        sD(TbadkCoreApplication.getInst().getSkinType());
        if (this.got != null) {
            this.got.bIM();
        }
    }

    public void release() {
        if (this.fSu != null && this.gjI != null) {
            this.fSu.b(this.gjI);
        }
    }

    public ImageView bDs() {
        return this.goc;
    }

    public TextView bDt() {
        return this.god;
    }

    public View bDu() {
        if (this.gob != null) {
            return this.gob.getView();
        }
        return null;
    }

    public void E(int i, boolean z) {
        if (this.gob != null) {
            this.gob.q(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.gnW, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gnW.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.gox != null) {
            this.gox.invalidate();
        }
        if (this.goj != null) {
            this.goj.bFB();
            this.goj.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.gnW.getPageContext(), this.gnX);
        if (this.fSu != null) {
            this.fSu.onChangeSkinType(this.gnW.getPageContext(), i);
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.ehe.changeSkin(i);
        }
        sD(i);
        if (this.gou != null) {
            this.gou.onChangeSkinType(i);
        }
        if (this.got != null) {
            this.got.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.goL != null) {
            this.goL.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.ejj, R.color.cp_bg_line_d);
        if (this.gnW != null && this.gnW.bCp()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gnZ, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gnZ, R.color.cp_bg_line_d);
        }
    }

    private void sD(int i) {
        if (this.gnW != null) {
            sE(i);
        }
    }

    private void sE(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gnW.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.goo, R.color.cp_bg_line_c, i);
            if (this.gob != null) {
                this.gob.onChangeSkinType(i);
            }
            if (this.goc != null) {
                SvgManager.aEp().a(this.goc, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.axK, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.goA, R.color.cp_bg_line_h);
        lm(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.eHl) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.goO != 0) {
                    SvgManager.aEp().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aEp().a(this.goc, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aEp().a(this.fNa, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.goO = 0;
                }
            } else if (z || this.goO != 1) {
                SvgManager.aEp().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aEp().a(this.goc, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aEp().a(this.fNa, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.goO = 1;
            }
            bDv();
        }
    }

    private void bDv() {
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
                if (this.fNa != null) {
                    this.fNa.setAlpha(f);
                }
                if (this.goc != null) {
                    this.goc.setAlpha(f);
                }
            }
            if (this.god != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.god.setAlpha(f2);
                this.god.setClickable(f2 > 0.0f);
            }
            if (this.axK != null) {
                this.axK.setAlpha(alpha);
            }
            if (this.goA != null) {
                this.goA.setAlpha(alpha);
            }
            if (this.goo != null) {
                this.goo.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.goi != null) {
            this.goi.setSelection(0);
        }
        if (this.Ck != null) {
            this.Ck.setExpanded(true);
        }
        if (this.ejj != null && this.ejj.isEnabled()) {
            this.ejj.setRefreshing(true);
        }
    }

    public void ln(boolean z) {
        if (z) {
            this.ejj.setRefreshing(false);
        } else {
            this.ejj.interruptRefresh();
        }
    }

    public void lo(boolean z) {
        this.ejj.setEnabled(z);
    }

    public void lp(boolean z) {
        this.goq = z;
        if (this.goq) {
            this.ehe.setText(this.gnW.getResources().getString(R.string.load_more));
            if (this.goi.getChildAt(this.goi.getChildCount() - 1) == this.ehe.getView()) {
                this.ehe.startLoadData();
                this.gnW.aZN();
                return;
            }
            this.ehe.endLoadData();
            return;
        }
        this.ehe.setText(this.gnW.getResources().getString(R.string.load_more_must_after_delete));
        this.ehe.endLoadData();
    }

    public boolean bDw() {
        if (this.goq) {
            return false;
        }
        this.ehe.setText(this.gnW.getResources().getString(R.string.load_more_must_after_delete));
        this.ehe.endLoadData();
        return true;
    }

    public boolean bDx() {
        return this.goe != null && this.goh.getVisibility() == 0;
    }

    public void bDy() {
        if (this.goe != null) {
            this.gof.setVisibility(0);
            this.goh.setVisibility(8);
            this.gog.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.goR, 5000L);
        }
    }

    public void a(bt btVar) {
        if (this.goe == null) {
            View rootView = this.gnW.getRootView();
            this.goe = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.goe.setVisibility(0);
            this.gof = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.gog = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.goh = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.gog.setPageId(this.gnW.getUniqueId());
            this.goh.setPageId(this.gnW.getUniqueId());
            this.gog.setDefaultBgResource(R.color.common_color_10022);
            this.gog.setDefaultResource(0);
            this.goh.setDefaultBgResource(R.color.common_color_10022);
            this.goh.setDefaultResource(0);
            this.gof.setOnClickListener(this.gon);
        }
        this.gof.setVisibility(0);
        String aCi = btVar.aCi();
        String aCj = btVar.aCj();
        this.gog.startLoad(aCi, 10, false);
        this.goh.startLoad(aCj, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.goR, 5000L);
    }

    public void bDz() {
        if (this.goe != null && this.gof != null) {
            this.gof.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.af bDA() {
        return this.goj;
    }

    public RelativeLayout bqY() {
        return this.gnX;
    }

    public View bDB() {
        return this.gop;
    }

    public void sF(int i) {
        if (this.gnZ != null) {
            this.gnZ.setVisibility(i);
        }
    }

    public void bDC() {
        if (com.baidu.tbadk.n.m.aOT().aOU()) {
            int lastVisiblePosition = this.goi.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.goi.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.gpg != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.gpg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dzs = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.gpg.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.gpg.startLogPerf();
                    }
                    if (pVar.gpf != null && (pVar.gpf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.gpf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dzs = true;
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

    public NavigationBar bcw() {
        return this.mNavigationBar;
    }

    public void bba() {
        this.mHasMore = true;
        this.goi.setNextPage(this.ehe);
        if (this.gor > 0) {
            this.ehe.showEmptyView(this.gor);
        }
        this.ehe.setOnClickListener(null);
        this.ehe.startLoadData();
    }

    public void bbb() {
        this.mHasMore = false;
        this.goi.setNextPage(this.ehe);
        if (this.gor > 0) {
            this.ehe.showEmptyView(this.gor);
        }
        this.ehe.setOnClickListener(null);
        this.ehe.endLoadData();
        this.ehe.setText(this.gnW.getResources().getString(R.string.list_has_no_more));
    }

    public void bDD() {
        this.mHasMore = true;
        this.goi.setNextPage(this.ehe);
        this.ehe.setOnClickListener(this.gon);
        if (this.gor > 0) {
            this.ehe.showEmptyView(this.gor);
        }
        this.ehe.endLoadData();
        this.ehe.setText(this.gnW.getResources().getString(R.string.list_click_load_more));
    }

    public View bDE() {
        if (this.ehe == null) {
            return null;
        }
        return this.ehe.getView();
    }

    public void sG(int i) {
        if (this.goL != null) {
            this.goL.setVisibility(i);
        }
    }

    public void sH(int i) {
        if (this.goL != null) {
            this.goL.setSelectNumber(i);
        }
    }

    public void bbc() {
        this.mHasMore = false;
        this.goi.setNextPage(null);
    }

    public boolean bDF() {
        return this.ehe.getView().getParent() != null && this.mHasMore;
    }

    public void sI(int i) {
        this.gor = i;
    }

    public void sJ(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.fXi == null) {
                    this.fXi = new CommonTipView(this.gnW.getActivity());
                }
                this.fXi.setText(R.string.frs_login_tip);
                this.fXi.b((FrameLayout) bDB(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void lq(boolean z) {
        this.mIsBackground = z;
        if (this.goz != null) {
            boolean z2 = (this.gnW == null || this.gnW.bCi() == null || this.gnW.bCi().bJv() == null) ? true : this.gnW.bCi().bJv().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.goz.oz(false);
                this.goz.cbq();
                return;
            }
            this.goz.oz(true);
            this.goz.a(this.gnN, this.efM, this.gos, true);
        }
    }

    public void bC(int i, int i2) {
        if (this.goz != null) {
            this.goz.a(i, i2, this.gos, 1);
        }
    }

    public void bD(int i, int i2) {
        this.gnN = i;
        this.efM = i2;
    }

    public void lr(boolean z) {
        this.gos = z;
    }

    public void sK(int i) {
        if (this.goi != null && this.goi.getChildCount() >= 0) {
            if (this.goi.getFirstVisiblePosition() > 8) {
                this.goi.scrollToPosition(8);
            }
            this.goi.smoothScrollToPosition(i);
        }
    }

    public void bDG() {
        a(this.goC, this.gnW.bCN());
        if (this.goj != null) {
            this.goj.bFy();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.goD == null) {
                this.goD = new com.baidu.tieba.video.f(this.gnW.getActivity(), this.gnX);
            }
            this.goD.h(postWriteCallBackData);
        }
    }

    public void bDH() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.goS && this.gnW.getActivity() != null && this.gnW.getPageContext() != null) {
            View view = null;
            if (this.goi != null && (headerViewsCount = this.goi.getHeaderViewsCount()) < this.goi.getChildCount()) {
                view = this.goi.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).J(0).F(true).G(false).E(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.l.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        l.this.gnW.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(l.this.gnW.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(l.this.gnW.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.l.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c fI = dVar.fI();
                fI.setShouldCheckLocInWindow(false);
                fI.show(this.gnW.getActivity());
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fI != null) {
                            fI.dismiss();
                        }
                    }
                }, 4000L);
                this.goS = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.goL != null) {
            this.goL.setDeleteCallback(aVar);
        }
    }

    public void bDI() {
        if (this.goL != null) {
            this.goL.bDI();
        }
    }

    public void aTV() {
        if (this.goL != null) {
            this.goL.aTV();
        }
    }

    public void aB(String str, int i) {
        if (this.goN == null) {
            this.goN = new TextView(this.gnW.getActivity());
            this.goN.setGravity(19);
            this.goN.setPadding(com.baidu.adp.lib.util.l.getDimens(this.gnW.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.gnW.getActivity(), R.dimen.ds34), 0);
            this.goN.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gnW.getActivity(), R.dimen.tbds112)));
            this.goN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gnW.getActivity(), R.dimen.fontsize30));
            this.goN.setMaxLines(2);
            this.goN.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.goN.setTextColor(ContextCompat.getColor(this.gnW.getActivity(), R.color.cp_cont_a));
        }
        this.goM.setBackgroundColor(i);
        this.goN.setText(str);
        this.goM.a(this.gnW.getActivity(), this.goN, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Ck != null) {
            this.Ck.setExpanded(z);
        }
    }

    public void bDJ() {
        if (this.mPullView != null) {
            this.mPullView.aFz();
        }
        startPullRefresh();
    }

    public void rl() {
        if (bDA() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bDA().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cNc != 0 && biVar.cNb != null && this.gnW.bCf() != null && this.gnW.bCf().bHj() != null) {
                            int[] imageWidthAndHeight = this.gnW.bCf().bHj().imageWidthAndHeight(biVar.cNb);
                            biVar.cNc = imageWidthAndHeight[0];
                            biVar.cNd = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.5
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.bDA().notifyDataSetChanged();
                        if (!l.this.mIsBackground) {
                            l.this.goz.a(l.this.gnN, l.this.efM, l.this.gos, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bDK() {
        if (this.got == null) {
            return false;
        }
        return this.got.bDK();
    }

    public Context getContext() {
        if (this.gnW == null) {
            return null;
        }
        return this.gnW.getTbPageContext().getPageActivity();
    }
}
