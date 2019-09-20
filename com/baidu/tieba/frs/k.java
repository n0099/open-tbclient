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
    private AppBarLayout Qi;
    private PbListView dpz;
    private BdSwipeRefreshLayout dra;
    private ImageView eNu;
    private NoNetworkView eYL;
    private CommonTipView fdB;
    private com.baidu.adp.widget.ListView.k feD;
    private FrsFragment fxT;
    private View fxX;
    private com.baidu.tieba.c.b fxY;
    private ImageView fxZ;
    private com.baidu.tieba.frs.entelechy.b.a fyA;
    private com.baidu.tieba.video.f fyB;
    private AppBarLayoutStickyBehavior fyC;
    private FrsHeaderViewContainer fyD;
    private CollapsingToolbarLayout fyE;
    private com.baidu.tieba.frs.vc.f fyI;
    private FrsMultiDelBottomMenuView fyJ;
    private NavigationBarCoverTip fyK;
    private TextView fyL;
    private boolean fyQ;
    private TextView fya;
    private ViewStub fyb;
    private BdTypeRecyclerView fyf;
    private com.baidu.tieba.frs.entelechy.a.aa fyg;
    private FloatingAnimationView fyh;
    private com.baidu.tieba.c.c fyi;
    private View.OnClickListener fyk;
    private View fyl;
    private View fym;
    private int fyo;
    private com.baidu.tieba.frs.vc.d fyq;
    private com.baidu.tieba.frs.entelechy.b.c fyr;
    private com.baidu.tieba.frs.vc.j fys;
    private GifView fyt;
    private TbImageView fyu;
    private HashSet<String> fyv;
    private com.baidu.tieba.play.m fyw;
    private ObservedChangeLinearLayout fyz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean fxS = false;
    private NoPressedRelativeLayout fxU = null;
    private CoordinatorLayout fxV = null;
    private View fxW = null;
    private FrameLayout fyc = null;
    private TbImageView fyd = null;
    private TbImageView fye = null;
    private com.baidu.tbadk.core.dialog.b fyj = null;
    private NoNetworkView.a ftG = null;
    private boolean fyn = true;
    private boolean mHasMore = true;
    private boolean fyp = false;
    private int fxK = 0;
    private int dof = 0;
    private View fyx = null;
    private View fyy = null;
    private boolean elH = false;
    private boolean bpl = true;
    private boolean fyF = true;
    private int fyG = -1;
    private int fyH = -1;
    private int fyM = 0;
    private int fyN = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener feF = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.feD == null) {
                        k.this.feD = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.feD.a(k.this.fyf, 2);
                } else if (k.this.feD != null) {
                    k.this.feD.ox();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fyO = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fyH != i && Math.abs(i) >= 0 && k.this.bnD() != -1) {
                if (Math.abs(i) >= k.this.bnD()) {
                    if (k.this.fyF) {
                        k.this.fyF = false;
                        k.this.jW(k.this.fyF);
                    }
                } else if (!k.this.fyF) {
                    k.this.fyF = true;
                    k.this.jW(k.this.fyF);
                }
                int bnz = k.this.bnz() + k.this.bny() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bnz;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fyH - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.ry(Math.abs(bnz - totalScrollRange2));
                        if (k.this.fyy != null) {
                            k.this.fyy.setVisibility(0);
                        }
                    } else if (k.this.fyy != null) {
                        if (k.this.bnx() != UtilHelper.getStatusBarHeight()) {
                            k.this.ry(0);
                        }
                        k.this.fyy.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.elH) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.kb(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fyH = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable fyP = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.fyb != null) {
                k.this.fyc.setVisibility(0);
                k.this.fye.setVisibility(0);
                k.this.fyd.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.fxT != null && appBarLayout != null && this.fxT.bmH() != null && this.fxT.getPageContext() != null) {
            int bny = bny() + getNavigationBarHeight() + bnz();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bmH = this.fxT.bmH();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fxT.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.fxT.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.fxW.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.fxT != null && this.fxT.bmO();
            if (totalScrollRange <= 0) {
                if (this.fyN != 2) {
                    bmH.th(2);
                }
                this.fyN = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bny) {
                if (this.fyN != 1) {
                    bmH.th(1);
                }
                this.fyN = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.fyN != 0) {
                    bmH.th(0);
                }
                this.fyN = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.fxT.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.fxW.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bnu() {
        return this.fyz;
    }

    public View bnv() {
        return this.fyx;
    }

    public View bnw() {
        return this.fyy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bnx() {
        if (this.fyx == null) {
            return 0;
        }
        return this.fyx.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bny() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bnz() {
        if (this.eYL == null || com.baidu.adp.lib.util.j.kc()) {
            return 0;
        }
        return this.eYL.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry(int i) {
        View bnv = bnv();
        View bnw = bnw();
        if (UtilHelper.canUseStyleImmersiveSticky() && bnv != null && bnw != null && bnv.getLayoutParams() != null && bnw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = bnv.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            bnv.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bnw.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bnw.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.fxT = null;
        this.fyk = null;
        this.fyo = 0;
        this.fxT = frsFragment;
        this.fyk = onClickListener;
        MessageManager.getInstance().registerListener(this.feF);
        a(aVar, z);
        this.fyv = new HashSet<>();
        this.fyo = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fyI = fVar;
    }

    private boolean bnA() {
        return this.fyI != null && this.fyI.btu();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.fyA = aVar;
        View rootView = this.fxT.getRootView();
        if (this.fxU == null) {
            this.fxU = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.fxW == null) {
            this.fxW = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.fxV == null) {
            this.fxV = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.fym == null) {
            this.fym = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.fyE == null) {
            this.fyE = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.fyD == null) {
            this.fyD = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.fyz == null) {
            this.fyz = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fyz.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fyE.setMinimumHeight(i2);
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
        if (this.fxT.bnl()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.fyl == null) {
            this.fyl = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bpB = aVar.bpB();
            if (bpB != null) {
                bpB.bS(this.fyl);
            }
        }
        if (this.fxX == null) {
            this.fxX = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fxX.setOnClickListener(this.fyk);
            this.mBackImageView = (ImageView) this.fxX.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fxY == null) {
            this.fxY = new com.baidu.tieba.c.b(this.fxT.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fxY.getView(), (View.OnClickListener) null);
            this.eNu = this.fxY.bbY();
            this.fxY.getView().setOnClickListener(this.fyk);
        }
        if (this.fxZ == null) {
            this.fxZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.fxZ.setOnClickListener(this.fyk);
        }
        if (this.fya == null) {
            this.fya = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.fya.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int g = com.baidu.adp.lib.util.l.g(this.fxT.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, g, g);
            this.fya.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.i(this.fya, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.j(this.fya, R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.fxT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.fxT.getPageContext());
        }
        this.mPullView.setTag(this.fxT.getUniqueId());
        if (this.dra == null) {
            this.dra = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.dra.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.l(this.dra, R.color.cp_bg_line_c);
        }
        if (this.fyf == null) {
            this.fyf = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int fyT = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.fyT--;
                if (this.fyT == 0) {
                    k.this.fyf.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.fyT++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.fyf.setItemAnimator(defaultItemAnimator);
        this.fyf.setLayoutManager(new LinearLayoutManager(this.fyf.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.feD = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.feD.a(this.fyf, 2);
        }
        this.fyf.setScrollable(this.fxT);
        this.fyf.setFadingEdgeLength(0);
        this.fyf.setOverScrollMode(2);
        this.fxU.setBottomOrderView(this.fyf);
        this.fyf.setOnTouchListener(this.fxT.cnr);
        this.fyf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.fyw != null) {
                    k.this.fyw.cn(view);
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
        if (this.dpz == null) {
            this.dpz = new PbListView(this.fxT.getPageContext().getPageActivity());
            this.dpz.getView();
        }
        this.dpz.iX(R.color.cp_bg_line_d);
        this.dpz.setHeight(com.baidu.adp.lib.util.l.g(this.fxT.getActivity(), R.dimen.tbds182));
        this.dpz.akO();
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.dpz.iW(R.color.cp_cont_e);
        this.fyf.setOnSrollToBottomListener(this.fxT);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.fxT.bnf();
                if (k.this.fxT != null && k.this.Qi != null) {
                    k.this.fxT.bnn();
                    k.this.Qi.setExpanded(true);
                    if (k.this.fyw != null) {
                        k.this.fyw.c(k.this.fxK, k.this.dof, false, true);
                    }
                }
            }
        });
        boolean ajy = com.baidu.tbadk.core.util.ar.ajw().ajy();
        if (this.fyg == null) {
            this.fyg = aVar.a(this.fxT, this.fyf, ajy);
        }
        gf(false);
        if (!z) {
            if (this.eYL == null) {
                this.eYL = new NoNetworkView(this.fxT.getActivity());
                this.eYL.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fyz.addView(this.eYL);
            }
            if (com.baidu.adp.lib.util.j.jQ()) {
                this.eYL.setVisibility(8);
            } else {
                this.eYL.setVisibility(0);
            }
            this.eYL.onChangeSkinType(this.fxT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bnK();
        if (this.fyq == null) {
            this.fyq = aVar.a(this.fxT, this.fxU);
            this.fyq.b(this.fxT.bno());
        }
        if (this.fyr == null) {
            this.fyr = aVar.b(this.fxT, this.fxU);
            jZ(true);
        }
        if (this.fyx == null) {
            this.fyx = rootView.findViewById(R.id.statebar_view);
        }
        if (this.fyy == null) {
            this.fyy = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.fyw == null) {
            this.fyw = new com.baidu.tieba.play.m(this.fxT.getPageContext(), this.fyf);
        }
        this.fyw.setUniqueId(this.fxT.getUniqueId());
        this.fyK = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.fys == null) {
            this.fys = new com.baidu.tieba.frs.vc.j(this.fxT, this.fyK);
        }
        if (this.Qi == null) {
            this.Qi = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Qi.addOnOffsetChangedListener(this.fyO);
            this.fyF = true;
            this.fyG = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Qi.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.fyC = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.fyJ = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.fyJ.setPageContext(this.fxT.getPageContext());
        this.fyh = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.fyh.setPageId(this.fxT.getUniqueId());
        this.fyi = new com.baidu.tieba.c.c(this.fxT.getTbPageContext(), this.fyh, 2);
    }

    public void jV(boolean z) {
        if (z && this.fyi != null) {
            this.fyi.aHw();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.fyi != null) {
            this.fyi.a(oVar);
        }
    }

    private void bnB() {
        ViewGroup.LayoutParams layoutParams;
        this.elH = bnA();
        if (this.fyD != null && (layoutParams = this.fyD.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.elH) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bny(), 0, 0);
            }
            this.fyD.requestLayout();
        }
    }

    public void bnC() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fyz != null) {
            bnB();
            if (this.elH) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.fyx != null) {
                    this.fyx.setAlpha(1.0f);
                }
                if (this.fyy != null) {
                    this.fyy.setAlpha(1.0f);
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
    public void jW(boolean z) {
        if (z && this.fxT != null && this.fxT.bmG() != null) {
            this.fxT.bmG().btz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bnD() {
        int i;
        if (this.Qi == null) {
            return this.fyG;
        }
        if (this.fyG != -1) {
            return this.fyG;
        }
        int childCount = this.Qi.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Qi.getChildAt(childCount);
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
        this.fyG = Math.max(0, this.Qi.getTotalScrollRange() - Math.abs(i2));
        return this.fyG;
    }

    public void xv(String str) {
        if (this.fys != null) {
            this.fys.xv(str);
        }
    }

    public com.baidu.tieba.play.m bnE() {
        return this.fyw;
    }

    public com.baidu.tieba.frs.entelechy.b.c bnF() {
        return this.fyr;
    }

    public void jX(boolean z) {
        if (this.fyq != null) {
            this.fyq.jX(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bnG() {
        return this.fyq;
    }

    public void H(boolean z, boolean z2) {
        if (this.bpl && this.fyr != null) {
            this.fyr.H(z, z2);
        }
    }

    public void jY(boolean z) {
        this.bpl = z;
        if (!this.bpl && this.fyr != null) {
            this.fyr.H(false, false);
        }
    }

    public void bnH() {
        if (this.bpl && this.fyr != null) {
            this.fyr.H(false, false);
        }
        rz(8);
        this.fxZ.setVisibility(8);
        jX(false);
        this.fyf.setVisibility(8);
        this.fyD.setVisibility(8);
    }

    public void bnI() {
        if (this.bpl && this.fyr != null) {
            this.fyr.H(true, false);
        }
        rz(0);
        bnJ();
        jX(this.fxT.bnq());
        this.fyf.setVisibility(0);
        this.fyD.setVisibility(0);
    }

    private void rz(int i) {
        if (this.fxY != null) {
            this.fxY.setVisibility(i);
        }
    }

    private void bnJ() {
        this.fxZ.setVisibility(0);
    }

    public void jZ(boolean z) {
        if (this.fyr != null) {
            this.fyr.kC(z);
        }
    }

    private void bnK() {
        if (this.fyt == null) {
            View rootView = this.fxT.getRootView();
            this.fyt = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.fyu = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.fyu.setPageId(this.fxT.getUniqueId());
            this.fyt.setLayerType(1, null);
            this.fyu.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bnL() {
        return this.fxX;
    }

    public void h(NoNetworkView.a aVar) {
        this.ftG = aVar;
        if (this.eYL != null) {
            this.eYL.a(this.ftG);
        }
    }

    public void gf(boolean z) {
        this.fxS = z;
        if (z) {
            if (this.fyr != null) {
                this.fyr.bqe();
                return;
            }
            return;
        }
        this.fyf.getAdapter().notifyDataSetChanged();
        if (this.fyr != null) {
            this.fyr.bqf();
        }
    }

    public void ka(boolean z) {
        if (this.fyr != null) {
            if (z) {
                H(false, true);
            } else {
                H(false, false);
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
        this.fyf.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        this.fyg.setOnAdapterItemClickListener(sVar);
    }

    public void setForumName(String str) {
        this.fyg.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.feF);
        if (this.fyw != null) {
            this.fyw.destroy();
        }
        if (this.fys != null) {
            this.fys.onDestory();
        }
        if (this.fyJ != null) {
            this.fyJ.setPageContext(null);
        }
        this.fyg.onDestory();
        this.fyf.setOnSrollToBottomListener(null);
        this.fyf.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.fyP);
        if (this.fdB != null) {
            this.fdB.onDestroy();
        }
        this.fyv.clear();
        if (this.fyq != null) {
            this.fyq.btl();
        }
        if (this.fyB != null) {
            this.fyB.bpq();
        }
        if (this.fyi != null) {
            this.fyi.onDestroy();
        }
        if (this.fyK != null) {
            this.fyK.onDestroy();
        }
        if (this.fyJ != null) {
            this.fyJ.onDestroy();
        }
    }

    public boolean bnM() {
        if (this.Qi == null || this.fyC == null || !this.fyC.isSticky()) {
            return this.fyq != null && this.fyq.bnM();
        }
        if (this.fyf != null) {
            this.fyf.setSelection(0);
        }
        this.fyC.expandedAppBarLayout(this.Qi);
        return true;
    }

    public boolean bnk() {
        return this.fxS;
    }

    public void aWv() {
        this.fyf.setVisibility(0);
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
            com.baidu.tbadk.core.i.ace().mk(str);
        }
    }

    public void bnN() {
        if (this.fyg != null) {
            this.fyg.notifyDataSetChanged();
        }
    }

    public void Wb() {
        if (this.fyg instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.fyg).Wb();
        }
    }

    private void bnO() {
        if (this.fyj == null && this.fxT.getPageContext() != null) {
            String[] strArr = {this.fxT.getPageContext().getPageActivity().getString(R.string.take_photo), this.fxT.getPageContext().getPageActivity().getString(R.string.album)};
            this.fyj = new com.baidu.tbadk.core.dialog.b(this.fxT.getPageContext().getPageActivity());
            this.fyj.mR(this.fxT.getPageContext().getPageActivity().getString(R.string.operation));
            this.fyj.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.fxT.takePhoto();
                    } else if (i == 1 && k.this.fxT.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.Z(k.this.fxT.getPageContext().getPageActivity());
                    }
                }
            });
            this.fyj.d(this.fxT.getPageContext());
        }
    }

    public void bnP() {
        bnO();
        if (this.fyj != null) {
            this.fyj.agR();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.aa(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            if (this.fxT != null && this.fxT.bmE() != null && this.fxT.bmE().bse() == 0) {
                mVar.rI(this.fxT.bmE().bsl());
            }
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null) {
            this.mIsPrivateForum = frsViewData.isPrivateForum();
        }
        if (com.baidu.tbadk.core.util.v.Z(arrayList2) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList2.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar2 = arrayList2.get(i2);
                if (mVar2 instanceof bg) {
                    ((bg) mVar2).threadData.setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.fyg.b(arrayList2, frsViewData);
        if (this.fyw != null && this.fxK != 0) {
            this.fyw.c(this.fxK, this.dof, this.fyp, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fyf;
    }

    public void bnQ() {
        this.fyg.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fxT.getPageContext(), 1);
        aVar.a(this.fyf);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.fxT.getForumName());
        hashMap.put("forum_id", this.fxT.getForumId());
        aVar.setParams(hashMap);
        aVar.ak(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.fyq != null) {
            this.fyq.btm();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        rA(TbadkCoreApplication.getInst().getSkinType());
        if (this.fyq != null) {
            this.fyq.btn();
        }
    }

    public void release() {
        if (this.eYL != null && this.ftG != null) {
            this.eYL.b(this.ftG);
        }
    }

    public ImageView bnR() {
        return this.fxZ;
    }

    public TextView bnS() {
        return this.fya;
    }

    public View bnT() {
        if (this.fxY != null) {
            return this.fxY.getView();
        }
        return null;
    }

    public void E(int i, boolean z) {
        if (this.fxY != null) {
            this.fxY.l(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fxT, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fxT.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.fyu != null) {
            this.fyu.invalidate();
        }
        if (this.fyg != null) {
            this.fyg.bpY();
            this.fyg.notifyDataSetChanged();
        }
        com.baidu.tbadk.s.a.a(this.fxT.getPageContext(), this.fxU);
        if (this.eYL != null) {
            this.eYL.onChangeSkinType(this.fxT.getPageContext(), i);
        }
        if (this.dpz != null) {
            this.dpz.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.dpz.iY(i);
        }
        rA(i);
        if (this.fyr != null) {
            this.fyr.onChangeSkinType(i);
        }
        if (this.fyq != null) {
            this.fyq.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.fyJ != null) {
            this.fyJ.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.l(this.dra, R.color.cp_bg_line_d);
        if (this.fxT != null && this.fxT.bmO()) {
            com.baidu.tbadk.core.util.am.l(this.fxW, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.l(this.fxW, R.color.cp_bg_line_d);
        }
    }

    private void rA(int i) {
        if (this.fxT != null) {
            rB(i);
        }
    }

    private void rB(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fxT.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.h(this.fyl, R.color.cp_bg_line_c, i);
        }
        com.baidu.tbadk.core.util.am.l(this.fyx, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.l(this.fyy, R.color.cp_bg_line_h);
        kb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.elH) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.fyM != 0) {
                    SvgManager.ajv().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.ajv().a(this.fxZ, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.ajv().a(this.eNu, R.drawable.icon_pure_topbar_information_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.fyM = 0;
                }
            } else if (z || this.fyM != 1) {
                SvgManager.ajv().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.ajv().a(this.fxZ, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.ajv().a(this.eNu, R.drawable.icon_pure_topbar_information_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.fyM = 1;
            }
            bnU();
        }
    }

    private void bnU() {
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
                if (this.eNu != null) {
                    this.eNu.setAlpha(f);
                }
                if (this.fxZ != null) {
                    this.fxZ.setAlpha(f);
                }
            }
            if (this.fya != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.fya.setAlpha(f2);
                this.fya.setClickable(f2 > 0.0f);
            }
            if (this.fyx != null) {
                this.fyx.setAlpha(alpha);
            }
            if (this.fyy != null) {
                this.fyy.setAlpha(alpha);
            }
            if (this.fyl != null) {
                this.fyl.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.fyf != null) {
            this.fyf.setSelection(0);
        }
        if (this.Qi != null) {
            this.Qi.setExpanded(true);
        }
        if (this.dra != null && this.dra.isEnabled()) {
            this.dra.setRefreshing(true);
        }
    }

    public void kc(boolean z) {
        if (z) {
            this.dra.setRefreshing(false);
        } else {
            this.dra.oV();
        }
    }

    public void kd(boolean z) {
        this.dra.setEnabled(z);
    }

    public void ke(boolean z) {
        this.fyn = z;
        if (this.fyn) {
            this.dpz.setText(this.fxT.getResources().getString(R.string.load_more));
            if (this.fyf.getChildAt(this.fyf.getChildCount() - 1) == this.dpz.getView()) {
                this.dpz.akR();
                this.fxT.aJw();
                return;
            }
            this.dpz.akS();
            return;
        }
        this.dpz.setText(this.fxT.getResources().getString(R.string.load_more_must_after_delete));
        this.dpz.akS();
    }

    public boolean bnV() {
        if (this.fyn) {
            return false;
        }
        this.dpz.setText(this.fxT.getResources().getString(R.string.load_more_must_after_delete));
        this.dpz.akS();
        return true;
    }

    public boolean bnW() {
        return this.fyb != null && this.fye.getVisibility() == 0;
    }

    public void bnX() {
        if (this.fyb != null) {
            this.fyc.setVisibility(0);
            this.fye.setVisibility(8);
            this.fyd.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.fyP, 5000L);
        }
    }

    public void a(bo boVar) {
        if (this.fyb == null) {
            View rootView = this.fxT.getRootView();
            this.fyb = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.fyb.setVisibility(0);
            this.fyc = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.fyd = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.fye = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.fyd.setPageId(this.fxT.getUniqueId());
            this.fye.setPageId(this.fxT.getUniqueId());
            this.fyd.setDefaultBgResource(R.color.common_color_10022);
            this.fyd.setDefaultResource(0);
            this.fye.setDefaultBgResource(R.color.common_color_10022);
            this.fye.setDefaultResource(0);
            this.fyc.setOnClickListener(this.fyk);
        }
        this.fyc.setVisibility(0);
        String agF = boVar.agF();
        String agG = boVar.agG();
        this.fyd.startLoad(agF, 10, false);
        this.fye.startLoad(agG, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.fyP, 5000L);
    }

    public void bnY() {
        if (this.fyb != null && this.fyc != null) {
            this.fyc.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.aa bnZ() {
        return this.fyg;
    }

    public RelativeLayout aYe() {
        return this.fxU;
    }

    public View boa() {
        return this.fym;
    }

    public void rC(int i) {
        if (this.fxW != null) {
            this.fxW.setVisibility(i);
        }
    }

    public void bob() {
        if (com.baidu.tbadk.p.m.avH().avI()) {
            int lastVisiblePosition = this.fyf.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fyf.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.efW != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.efW.getPerfLog();
                        perfLog.kU(1000);
                        perfLog.cAP = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.efW.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.efW.startLogPerf();
                    }
                    if (oVar.fzd != null && (oVar.fzd instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fzd;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kU(1000);
                                perfLog2.cAP = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar aLN() {
        return this.mNavigationBar;
    }

    public void aKO() {
        this.mHasMore = true;
        this.fyf.setNextPage(this.dpz);
        if (this.fyo > 0) {
            this.dpz.iZ(this.fyo);
        }
        this.dpz.setOnClickListener(null);
        this.dpz.akR();
    }

    public void aKP() {
        this.mHasMore = false;
        this.fyf.setNextPage(this.dpz);
        if (this.fyo > 0) {
            this.dpz.iZ(this.fyo);
        }
        this.dpz.setOnClickListener(null);
        this.dpz.akS();
        this.dpz.setText(this.fxT.getResources().getString(R.string.list_has_no_more));
    }

    public void boc() {
        this.mHasMore = true;
        this.fyf.setNextPage(this.dpz);
        this.dpz.setOnClickListener(this.fyk);
        if (this.fyo > 0) {
            this.dpz.iZ(this.fyo);
        }
        this.dpz.akS();
        this.dpz.setText(this.fxT.getResources().getString(R.string.list_click_load_more));
    }

    public View bod() {
        if (this.dpz == null) {
            return null;
        }
        return this.dpz.getView();
    }

    public void rD(int i) {
        if (this.fyJ != null) {
            this.fyJ.setVisibility(i);
        }
    }

    public void rE(int i) {
        if (this.fyJ != null) {
            this.fyJ.setSelectNumber(i);
        }
    }

    public void aKQ() {
        this.mHasMore = false;
        this.fyf.setNextPage(null);
    }

    public boolean bbs() {
        return this.dpz.getView().getParent() != null && this.mHasMore;
    }

    public void rF(int i) {
        this.fyo = i;
    }

    public void rG(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("frs_login_tip", true)) {
                if (this.fdB == null) {
                    this.fdB = new CommonTipView(this.fxT.getActivity());
                }
                this.fdB.setText(R.string.frs_login_tip);
                this.fdB.show((FrameLayout) boa(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void kf(boolean z) {
        this.mIsBackground = z;
        if (this.fyw != null) {
            boolean z2 = (this.fxT == null || this.fxT.bmH() == null || this.fxT.bmH().btR() == null) ? true : this.fxT.bmH().btR().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.fyw.nk(false);
                this.fyw.bMn();
                return;
            }
            this.fyw.nk(true);
            this.fyw.c(this.fxK, this.dof, this.fyp, true);
        }
    }

    public void br(int i, int i2) {
        if (this.fyw != null) {
            this.fyw.a(i, i2, this.fyp, 1);
        }
    }

    public void bs(int i, int i2) {
        this.fxK = i;
        this.dof = i2;
    }

    public void kg(boolean z) {
        this.fyp = z;
    }

    public void rH(int i) {
        if (this.fyf != null && this.fyf.getChildCount() >= 0) {
            if (this.fyf.getFirstVisiblePosition() > 8) {
                this.fyf.scrollToPosition(8);
            }
            this.fyf.smoothScrollToPosition(i);
        }
    }

    public void boe() {
        a(this.fyA, this.fxT.bnl());
        if (this.fyg != null) {
            this.fyg.bpV();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.fyB == null) {
                this.fyB = new com.baidu.tieba.video.f(this.fxT.getActivity(), this.fxU);
            }
            this.fyB.h(postWriteCallBackData);
        }
    }

    public void bof() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getLong("frs_video_activity_guide", 0L) == 0 && !this.fyQ && this.fxT.getActivity() != null && this.fxT.getPageContext() != null) {
            View view = null;
            if (this.fyf != null && (headerViewsCount = this.fyf.getHeaderViewsCount()) < this.fyf.getChildCount()) {
                view = this.fyf.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).X(0).U(true).V(false).T(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        k.this.fxT.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hT() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hU() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.g(k.this.fxT.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.g(k.this.fxT.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c hV = dVar.hV();
                hV.R(false);
                hV.q(this.fxT.getActivity());
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hV != null) {
                            hV.dismiss();
                        }
                    }
                }, 4000L);
                this.fyQ = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.fyJ != null) {
            this.fyJ.setDeleteCallback(aVar);
        }
    }

    public void bog() {
        if (this.fyJ != null) {
            this.fyJ.bog();
        }
    }

    public void aBD() {
        if (this.fyJ != null) {
            this.fyJ.aBD();
        }
    }

    public void aw(String str, int i) {
        if (this.fyL == null) {
            this.fyL = new TextView(this.fxT.getActivity());
            this.fyL.setGravity(19);
            this.fyL.setPadding(com.baidu.adp.lib.util.l.g(this.fxT.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.g(this.fxT.getActivity(), R.dimen.ds34), 0);
            this.fyL.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.fxT.getActivity(), R.dimen.tbds112)));
            this.fyL.setTextSize(0, com.baidu.adp.lib.util.l.g(this.fxT.getActivity(), R.dimen.fontsize30));
            this.fyL.setMaxLines(2);
            this.fyL.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.fyL.setTextColor(ContextCompat.getColor(this.fxT.getActivity(), R.color.cp_cont_a));
        }
        this.fyK.setBackgroundColor(i);
        this.fyL.setText(str);
        this.fyK.a(this.fxT.getActivity(), this.fyL, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Qi != null) {
            this.Qi.setExpanded(z);
        }
    }

    public void boh() {
        if (this.Qi != null && this.fyf != null) {
            int count = this.fyf.getCount();
            if (this.fyf.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.Qi.setExpanded(true, true);
            }
        }
    }

    public void boi() {
        if (this.mPullView != null) {
            this.mPullView.alb();
        }
        startPullRefresh();
    }

    public void boj() {
        if (bnZ() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bnZ().getDatas();
            if (!com.baidu.tbadk.core.util.v.aa(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bg) {
                        bg bgVar = (bg) mVar;
                        if (bgVar.bJJ != 0 && bgVar.threadData != null && this.fxT.bmE() != null && this.fxT.bmE().brI() != null) {
                            int[] imageWidthAndHeight = this.fxT.bmE().brI().imageWidthAndHeight(bgVar.threadData);
                            bgVar.bJJ = imageWidthAndHeight[0];
                            bgVar.bJK = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.5
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.bnZ().notifyDataSetChanged();
                        if (!k.this.mIsBackground) {
                            k.this.fyw.c(k.this.fxK, k.this.dof, k.this.fyp, true);
                        }
                    }
                }, 500L);
            }
        }
    }
}
