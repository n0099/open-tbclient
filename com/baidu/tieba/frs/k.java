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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.dialog.b;
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
    private AppBarLayout Qj;
    private PbListView dnN;
    private BdSwipeRefreshLayout dpp;
    private ImageView eLL;
    private NoNetworkView eXf;
    private com.baidu.adp.widget.ListView.k fcQ;
    private CommonTipView fca;
    private int fwB;
    private com.baidu.tieba.frs.vc.d fwD;
    private com.baidu.tieba.frs.entelechy.b.c fwE;
    private com.baidu.tieba.frs.vc.j fwF;
    private GifView fwG;
    private TbImageView fwH;
    private HashSet<String> fwI;
    private com.baidu.tieba.play.m fwJ;
    private ObservedChangeLinearLayout fwM;
    private com.baidu.tieba.frs.entelechy.b.a fwN;
    private com.baidu.tieba.video.f fwO;
    private AppBarLayoutStickyBehavior fwP;
    private FrsHeaderViewContainer fwQ;
    private CollapsingToolbarLayout fwR;
    private com.baidu.tieba.frs.vc.f fwV;
    private FrsMultiDelBottomMenuView fwW;
    private NavigationBarCoverTip fwX;
    private TextView fwY;
    private FrsFragment fwg;
    private View fwk;
    private com.baidu.tieba.c.b fwl;
    private ImageView fwm;
    private TextView fwn;
    private ViewStub fwo;
    private BdTypeRecyclerView fws;
    private com.baidu.tieba.frs.entelechy.a.aa fwt;
    private FloatingAnimationView fwu;
    private com.baidu.tieba.c.c fwv;
    private View.OnClickListener fwx;
    private View fwy;
    private View fwz;
    private boolean fxd;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean fwf = false;
    private NoPressedRelativeLayout fwh = null;
    private CoordinatorLayout fwi = null;
    private View fwj = null;
    private FrameLayout fwp = null;
    private TbImageView fwq = null;
    private TbImageView fwr = null;
    private com.baidu.tbadk.core.dialog.b fww = null;
    private NoNetworkView.a frT = null;
    private boolean fwA = true;
    private boolean mHasMore = true;
    private boolean fwC = false;
    private int fvX = 0;
    private int dms = 0;
    private View fwK = null;
    private View fwL = null;
    private boolean ejX = false;
    private boolean boN = true;
    private boolean fwS = true;
    private int fwT = -1;
    private int fwU = -1;
    private int fwZ = 0;
    private int fxa = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener fcS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.fcQ == null) {
                        k.this.fcQ = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.fcQ.a(k.this.fws, 2);
                } else if (k.this.fcQ != null) {
                    k.this.fcQ.ow();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fxb = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fwU != i && Math.abs(i) >= 0 && k.this.bmS() != -1) {
                if (Math.abs(i) >= k.this.bmS()) {
                    if (k.this.fwS) {
                        k.this.fwS = false;
                        k.this.jT(k.this.fwS);
                    }
                } else if (!k.this.fwS) {
                    k.this.fwS = true;
                    k.this.jT(k.this.fwS);
                }
                int bmO = k.this.bmO() + k.this.bmN() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bmO;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fwU - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.rv(Math.abs(bmO - totalScrollRange2));
                        if (k.this.fwL != null) {
                            k.this.fwL.setVisibility(0);
                        }
                    } else if (k.this.fwL != null) {
                        if (k.this.bmM() != UtilHelper.getStatusBarHeight()) {
                            k.this.rv(0);
                        }
                        k.this.fwL.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.ejX) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.jY(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fwU = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable fxc = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.fwo != null) {
                k.this.fwp.setVisibility(0);
                k.this.fwr.setVisibility(0);
                k.this.fwq.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.fwg != null && appBarLayout != null && this.fwg.blW() != null && this.fwg.getPageContext() != null) {
            int bmN = bmN() + getNavigationBarHeight() + bmO();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController blW = this.fwg.blW();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fwg.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.fwg.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.fwj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.fwg != null && this.fwg.bmd();
            if (totalScrollRange <= 0) {
                if (this.fxa != 2) {
                    blW.td(2);
                }
                this.fxa = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bmN) {
                if (this.fxa != 1) {
                    blW.td(1);
                }
                this.fxa = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.fxa != 0) {
                    blW.td(0);
                }
                this.fxa = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.g(this.fwg.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.fwj.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bmJ() {
        return this.fwM;
    }

    public View bmK() {
        return this.fwK;
    }

    public View bmL() {
        return this.fwL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmM() {
        if (this.fwK == null) {
            return 0;
        }
        return this.fwK.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmN() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmO() {
        if (this.eXf == null || com.baidu.adp.lib.util.j.kc()) {
            return 0;
        }
        return this.eXf.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv(int i) {
        View bmK = bmK();
        View bmL = bmL();
        if (UtilHelper.canUseStyleImmersiveSticky() && bmK != null && bmL != null && bmK.getLayoutParams() != null && bmL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = bmK.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            bmK.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bmL.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bmL.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.fwg = null;
        this.fwx = null;
        this.fwB = 0;
        this.fwg = frsFragment;
        this.fwx = onClickListener;
        MessageManager.getInstance().registerListener(this.fcS);
        a(aVar, z);
        this.fwI = new HashSet<>();
        this.fwB = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fwV = fVar;
    }

    private boolean bmP() {
        return this.fwV != null && this.fwV.bsH();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.fwN = aVar;
        View rootView = this.fwg.getRootView();
        if (this.fwh == null) {
            this.fwh = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.fwj == null) {
            this.fwj = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.fwi == null) {
            this.fwi = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.fwz == null) {
            this.fwz = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.fwR == null) {
            this.fwR = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.fwQ == null) {
            this.fwQ = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.fwM == null) {
            this.fwM = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fwM.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fwR.setMinimumHeight(i2);
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
        if (this.fwg.bmA()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.fwy == null) {
            this.fwy = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b boQ = aVar.boQ();
            if (boQ != null) {
                boQ.bS(this.fwy);
            }
        }
        if (this.fwk == null) {
            this.fwk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fwk.setOnClickListener(this.fwx);
            this.mBackImageView = (ImageView) this.fwk.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fwl == null) {
            this.fwl = new com.baidu.tieba.c.b(this.fwg.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fwl.getView(), (View.OnClickListener) null);
            this.eLL = this.fwl.bbu();
            this.fwl.getView().setOnClickListener(this.fwx);
        }
        if (this.fwm == null) {
            this.fwm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.fwm.setOnClickListener(this.fwx);
        }
        if (this.fwn == null) {
            this.fwn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.fwn.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int g = com.baidu.adp.lib.util.l.g(this.fwg.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, g, g);
            this.fwn.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.i(this.fwn, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.j(this.fwn, R.color.cp_btn_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.fwg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.fwg.getPageContext());
        }
        this.mPullView.setTag(this.fwg.getUniqueId());
        if (this.dpp == null) {
            this.dpp = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.dpp.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.l(this.dpp, R.color.cp_bg_line_c);
        }
        if (this.fws == null) {
            this.fws = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int fxg = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.fxg--;
                if (this.fxg == 0) {
                    k.this.fws.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.fxg++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.fws.setItemAnimator(defaultItemAnimator);
        this.fws.setLayoutManager(new LinearLayoutManager(this.fws.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fcQ = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.fcQ.a(this.fws, 2);
        }
        this.fws.setScrollable(this.fwg);
        this.fws.setFadingEdgeLength(0);
        this.fws.setOverScrollMode(2);
        this.fwh.setBottomOrderView(this.fws);
        this.fws.setOnTouchListener(this.fwg.cmw);
        this.fws.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.fwJ != null) {
                    k.this.fwJ.cn(view);
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
        if (this.dnN == null) {
            this.dnN = new PbListView(this.fwg.getPageContext().getPageActivity());
            this.dnN.getView();
        }
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.setHeight(com.baidu.adp.lib.util.l.g(this.fwg.getActivity(), R.dimen.tbds182));
        this.dnN.akC();
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.dnN.iT(R.color.cp_cont_e);
        this.fws.setOnSrollToBottomListener(this.fwg);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.fwg.bmu();
                if (k.this.fwg != null && k.this.Qj != null) {
                    k.this.fwg.bmC();
                    k.this.Qj.setExpanded(true);
                    if (k.this.fwJ != null) {
                        k.this.fwJ.c(k.this.fvX, k.this.dms, false, true);
                    }
                }
            }
        });
        boolean ajs = com.baidu.tbadk.core.util.as.ajq().ajs();
        if (this.fwt == null) {
            this.fwt = aVar.a(this.fwg, this.fws, ajs);
        }
        gc(false);
        if (!z) {
            if (this.eXf == null) {
                this.eXf = new NoNetworkView(this.fwg.getActivity());
                this.eXf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fwM.addView(this.eXf);
            }
            if (com.baidu.adp.lib.util.j.jQ()) {
                this.eXf.setVisibility(8);
            } else {
                this.eXf.setVisibility(0);
            }
            this.eXf.onChangeSkinType(this.fwg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bmZ();
        if (this.fwD == null) {
            this.fwD = aVar.a(this.fwg, this.fwh);
            this.fwD.b(this.fwg.bmD());
        }
        if (this.fwE == null) {
            this.fwE = aVar.b(this.fwg, this.fwh);
            jW(true);
        }
        if (this.fwK == null) {
            this.fwK = rootView.findViewById(R.id.statebar_view);
        }
        if (this.fwL == null) {
            this.fwL = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.fwJ == null) {
            this.fwJ = new com.baidu.tieba.play.m(this.fwg.getPageContext(), this.fws);
        }
        this.fwJ.setUniqueId(this.fwg.getUniqueId());
        this.fwX = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.fwF == null) {
            this.fwF = new com.baidu.tieba.frs.vc.j(this.fwg, this.fwX);
        }
        if (this.Qj == null) {
            this.Qj = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Qj.addOnOffsetChangedListener(this.fxb);
            this.fwS = true;
            this.fwT = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Qj.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.fwP = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.fwW = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.fwW.setPageContext(this.fwg.getPageContext());
        this.fwu = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.fwu.setPageId(this.fwg.getUniqueId());
        this.fwv = new com.baidu.tieba.c.c(this.fwg.getTbPageContext(), this.fwu, 2);
    }

    public void jS(boolean z) {
        if (z && this.fwv != null) {
            this.fwv.aGS();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.fwv != null) {
            this.fwv.a(oVar);
        }
    }

    private void bmQ() {
        ViewGroup.LayoutParams layoutParams;
        this.ejX = bmP();
        if (this.fwQ != null && (layoutParams = this.fwQ.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.ejX) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bmN(), 0, 0);
            }
            this.fwQ.requestLayout();
        }
    }

    public void bmR() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fwM != null) {
            bmQ();
            if (this.ejX) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.fwK != null) {
                    this.fwK.setAlpha(1.0f);
                }
                if (this.fwL != null) {
                    this.fwL.setAlpha(1.0f);
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
    public void jT(boolean z) {
        if (z && this.fwg != null && this.fwg.blV() != null) {
            this.fwg.blV().bsM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmS() {
        int i;
        if (this.Qj == null) {
            return this.fwT;
        }
        if (this.fwT != -1) {
            return this.fwT;
        }
        int childCount = this.Qj.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Qj.getChildAt(childCount);
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
        this.fwT = Math.max(0, this.Qj.getTotalScrollRange() - Math.abs(i2));
        return this.fwT;
    }

    public void wW(String str) {
        if (this.fwF != null) {
            this.fwF.wW(str);
        }
    }

    public com.baidu.tieba.play.m bmT() {
        return this.fwJ;
    }

    public com.baidu.tieba.frs.entelechy.b.c bmU() {
        return this.fwE;
    }

    public void jU(boolean z) {
        if (this.fwD != null) {
            this.fwD.jU(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bmV() {
        return this.fwD;
    }

    public void H(boolean z, boolean z2) {
        if (this.boN && this.fwE != null) {
            this.fwE.H(z, z2);
        }
    }

    public void jV(boolean z) {
        this.boN = z;
        if (!this.boN && this.fwE != null) {
            this.fwE.H(false, false);
        }
    }

    public void bmW() {
        if (this.boN && this.fwE != null) {
            this.fwE.H(false, false);
        }
        rw(8);
        this.fwm.setVisibility(8);
        jU(false);
        this.fws.setVisibility(8);
        this.fwQ.setVisibility(8);
    }

    public void bmX() {
        if (this.boN && this.fwE != null) {
            this.fwE.H(true, false);
        }
        rw(0);
        bmY();
        jU(this.fwg.bmF());
        this.fws.setVisibility(0);
        this.fwQ.setVisibility(0);
    }

    private void rw(int i) {
        if (this.fwl != null) {
            this.fwl.setVisibility(i);
        }
    }

    private void bmY() {
        this.fwm.setVisibility(0);
    }

    public void jW(boolean z) {
        if (this.fwE != null) {
            this.fwE.kz(z);
        }
    }

    private void bmZ() {
        if (this.fwG == null) {
            View rootView = this.fwg.getRootView();
            this.fwG = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.fwH = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.fwH.setPageId(this.fwg.getUniqueId());
            this.fwG.setLayerType(1, null);
            this.fwH.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bna() {
        return this.fwk;
    }

    public void h(NoNetworkView.a aVar) {
        this.frT = aVar;
        if (this.eXf != null) {
            this.eXf.a(this.frT);
        }
    }

    public void gc(boolean z) {
        this.fwf = z;
        if (z) {
            if (this.fwE != null) {
                this.fwE.bpt();
                return;
            }
            return;
        }
        this.fws.getAdapter().notifyDataSetChanged();
        if (this.fwE != null) {
            this.fwE.bpu();
        }
    }

    public void jX(boolean z) {
        if (this.fwE != null) {
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
        this.fws.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        this.fwt.setOnAdapterItemClickListener(sVar);
    }

    public void setForumName(String str) {
        this.fwt.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fcS);
        if (this.fwJ != null) {
            this.fwJ.destroy();
        }
        if (this.fwF != null) {
            this.fwF.onDestory();
        }
        if (this.fwW != null) {
            this.fwW.setPageContext(null);
        }
        this.fwt.onDestory();
        this.fws.setOnSrollToBottomListener(null);
        this.fws.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.fxc);
        if (this.fca != null) {
            this.fca.onDestroy();
        }
        this.fwI.clear();
        if (this.fwD != null) {
            this.fwD.bsy();
        }
        if (this.fwO != null) {
            this.fwO.boF();
        }
        if (this.fwv != null) {
            this.fwv.onDestroy();
        }
        if (this.fwX != null) {
            this.fwX.onDestroy();
        }
        if (this.fwW != null) {
            this.fwW.onDestroy();
        }
    }

    public boolean bnb() {
        if (this.Qj == null || this.fwP == null || !this.fwP.isSticky()) {
            return this.fwD != null && this.fwD.bnb();
        }
        if (this.fws != null) {
            this.fws.setSelection(0);
        }
        this.fwP.expandedAppBarLayout(this.Qj);
        return true;
    }

    public boolean bmz() {
        return this.fwf;
    }

    public void aVR() {
        this.fws.setVisibility(0);
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
            com.baidu.tbadk.core.i.aca().mi(str);
        }
    }

    public void bnc() {
        if (this.fwt != null) {
            this.fwt.notifyDataSetChanged();
        }
    }

    public void VX() {
        if (this.fwt instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.fwt).VX();
        }
    }

    private void bnd() {
        if (this.fww == null && this.fwg.getPageContext() != null) {
            String[] strArr = {this.fwg.getPageContext().getPageActivity().getString(R.string.take_photo), this.fwg.getPageContext().getPageActivity().getString(R.string.album)};
            this.fww = new com.baidu.tbadk.core.dialog.b(this.fwg.getPageContext().getPageActivity());
            this.fww.mP(this.fwg.getPageContext().getPageActivity().getString(R.string.operation));
            this.fww.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.fwg.takePhoto();
                    } else if (i == 1 && k.this.fwg.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.Z(k.this.fwg.getPageContext().getPageActivity());
                    }
                }
            });
            this.fww.d(this.fwg.getPageContext());
        }
    }

    public void bne() {
        bnd();
        if (this.fww != null) {
            this.fww.agN();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.aa(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            if (this.fwg != null && this.fwg.blT() != null && this.fwg.blT().brs() == 0) {
                mVar.rF(this.fwg.blT().brz());
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
        this.fwt.b(arrayList2, frsViewData);
        if (this.fwJ != null && this.fvX != 0) {
            this.fwJ.c(this.fvX, this.dms, this.fwC, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fws;
    }

    public void bnf() {
        this.fwt.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fwg.getPageContext(), 1);
        aVar.a(this.fws);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.fwg.getForumName());
        hashMap.put("forum_id", this.fwg.getForumId());
        aVar.setParams(hashMap);
        aVar.ak(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.fwD != null) {
            this.fwD.bsz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        rx(TbadkCoreApplication.getInst().getSkinType());
        if (this.fwD != null) {
            this.fwD.bsA();
        }
    }

    public void release() {
        if (this.eXf != null && this.frT != null) {
            this.eXf.b(this.frT);
        }
    }

    public ImageView bng() {
        return this.fwm;
    }

    public TextView bnh() {
        return this.fwn;
    }

    public View bni() {
        if (this.fwl != null) {
            return this.fwl.getView();
        }
        return null;
    }

    public void D(int i, boolean z) {
        if (this.fwl != null) {
            this.fwl.l(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fwg, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fwg.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.fwH != null) {
            this.fwH.invalidate();
        }
        if (this.fwt != null) {
            this.fwt.bpn();
            this.fwt.notifyDataSetChanged();
        }
        com.baidu.tbadk.s.a.a(this.fwg.getPageContext(), this.fwh);
        if (this.eXf != null) {
            this.eXf.onChangeSkinType(this.fwg.getPageContext(), i);
        }
        if (this.dnN != null) {
            this.dnN.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.dnN.iV(i);
        }
        rx(i);
        if (this.fwE != null) {
            this.fwE.onChangeSkinType(i);
        }
        if (this.fwD != null) {
            this.fwD.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fwW != null) {
            this.fwW.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.l(this.dpp, R.color.cp_bg_line_e);
        if (this.fwg != null && this.fwg.bmd()) {
            com.baidu.tbadk.core.util.am.l(this.fwj, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.l(this.fwj, R.color.cp_bg_line_d);
        }
    }

    private void rx(int i) {
        if (this.fwg != null) {
            ry(i);
        }
    }

    private void ry(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fwg.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.am.h(this.fwy, R.color.cp_bg_line_b, i);
        }
        com.baidu.tbadk.core.util.am.l(this.fwK, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.am.l(this.fwL, R.color.cp_bg_line_d);
        jY(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.ejX) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.fwZ != 0) {
                    com.baidu.tbadk.core.util.am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
                    com.baidu.tbadk.core.util.am.c(this.fwm, (int) R.drawable.icon_topbar_more_white_n, (int) R.drawable.icon_topbar_more_white_s);
                    com.baidu.tbadk.core.util.am.c(this.eLL, (int) R.drawable.icon_common_news_white_n, (int) R.drawable.icon_common_news_white_s);
                    this.fwZ = 0;
                }
            } else if (z || this.fwZ != 1) {
                com.baidu.tbadk.core.util.am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
                com.baidu.tbadk.core.util.am.c(this.fwm, (int) R.drawable.icon_topbar_more_n, (int) R.drawable.icon_topbar_more_s);
                com.baidu.tbadk.core.util.am.c(this.eLL, (int) R.drawable.icon_common_news_n, (int) R.drawable.icon_common_news_s);
                this.fwZ = 1;
            }
            bnj();
        }
    }

    private void bnj() {
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
                if (this.eLL != null) {
                    this.eLL.setAlpha(f);
                }
                if (this.fwm != null) {
                    this.fwm.setAlpha(f);
                }
            }
            if (this.fwn != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.fwn.setAlpha(f2);
                this.fwn.setClickable(f2 > 0.0f);
            }
            if (this.fwK != null) {
                this.fwK.setAlpha(alpha);
            }
            if (this.fwL != null) {
                this.fwL.setAlpha(alpha);
            }
            if (this.fwy != null) {
                this.fwy.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.fws != null) {
            this.fws.setSelection(0);
        }
        if (this.Qj != null) {
            this.Qj.setExpanded(true);
        }
        if (this.dpp != null && this.dpp.isEnabled()) {
            this.dpp.setRefreshing(true);
        }
    }

    public void jZ(boolean z) {
        if (z) {
            this.dpp.setRefreshing(false);
        } else {
            this.dpp.oU();
        }
    }

    public void ka(boolean z) {
        this.dpp.setEnabled(z);
    }

    public void kb(boolean z) {
        this.fwA = z;
        if (this.fwA) {
            this.dnN.setText(this.fwg.getResources().getString(R.string.load_more));
            if (this.fws.getChildAt(this.fws.getChildCount() - 1) == this.dnN.getView()) {
                this.dnN.akF();
                this.fwg.aIS();
                return;
            }
            this.dnN.akG();
            return;
        }
        this.dnN.setText(this.fwg.getResources().getString(R.string.load_more_must_after_delete));
        this.dnN.akG();
    }

    public boolean bnk() {
        if (this.fwA) {
            return false;
        }
        this.dnN.setText(this.fwg.getResources().getString(R.string.load_more_must_after_delete));
        this.dnN.akG();
        return true;
    }

    public boolean bnl() {
        return this.fwo != null && this.fwr.getVisibility() == 0;
    }

    public void bnm() {
        if (this.fwo != null) {
            this.fwp.setVisibility(0);
            this.fwr.setVisibility(8);
            this.fwq.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.fxc, 5000L);
        }
    }

    public void a(bo boVar) {
        if (this.fwo == null) {
            View rootView = this.fwg.getRootView();
            this.fwo = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.fwo.setVisibility(0);
            this.fwp = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.fwq = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.fwr = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.fwq.setPageId(this.fwg.getUniqueId());
            this.fwr.setPageId(this.fwg.getUniqueId());
            this.fwq.setDefaultBgResource(R.color.common_color_10022);
            this.fwq.setDefaultResource(0);
            this.fwr.setDefaultBgResource(R.color.common_color_10022);
            this.fwr.setDefaultResource(0);
            this.fwp.setOnClickListener(this.fwx);
        }
        this.fwp.setVisibility(0);
        String agB = boVar.agB();
        String agC = boVar.agC();
        this.fwq.startLoad(agB, 10, false);
        this.fwr.startLoad(agC, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.fxc, 5000L);
    }

    public void bnn() {
        if (this.fwo != null && this.fwp != null) {
            this.fwp.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.aa bno() {
        return this.fwt;
    }

    public RelativeLayout aXA() {
        return this.fwh;
    }

    public View bnp() {
        return this.fwz;
    }

    public void rz(int i) {
        if (this.fwj != null) {
            this.fwj.setVisibility(i);
        }
    }

    public void bnq() {
        if (com.baidu.tbadk.p.m.avv().avw()) {
            int lastVisiblePosition = this.fws.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fws.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.eem != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.eem.getPerfLog();
                        perfLog.kR(1000);
                        perfLog.czT = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.eem.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.eem.startLogPerf();
                    }
                    if (oVar.fxq != null && (oVar.fxq instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fxq;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kR(1000);
                                perfLog2.czT = true;
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

    public NavigationBar aLj() {
        return this.mNavigationBar;
    }

    public void aKk() {
        this.mHasMore = true;
        this.fws.setNextPage(this.dnN);
        if (this.fwB > 0) {
            this.dnN.iW(this.fwB);
        }
        this.dnN.setOnClickListener(null);
        this.dnN.akF();
    }

    public void aKl() {
        this.mHasMore = false;
        this.fws.setNextPage(this.dnN);
        if (this.fwB > 0) {
            this.dnN.iW(this.fwB);
        }
        this.dnN.setOnClickListener(null);
        this.dnN.akG();
        this.dnN.setText(this.fwg.getResources().getString(R.string.list_has_no_more));
    }

    public void bnr() {
        this.mHasMore = true;
        this.fws.setNextPage(this.dnN);
        this.dnN.setOnClickListener(this.fwx);
        if (this.fwB > 0) {
            this.dnN.iW(this.fwB);
        }
        this.dnN.akG();
        this.dnN.setText(this.fwg.getResources().getString(R.string.list_click_load_more));
    }

    public View bns() {
        if (this.dnN == null) {
            return null;
        }
        return this.dnN.getView();
    }

    public void rA(int i) {
        if (this.fwW != null) {
            this.fwW.setVisibility(i);
        }
    }

    public void rB(int i) {
        if (this.fwW != null) {
            this.fwW.setSelectNumber(i);
        }
    }

    public void aKm() {
        this.mHasMore = false;
        this.fws.setNextPage(null);
    }

    public boolean baO() {
        return this.dnN.getView().getParent() != null && this.mHasMore;
    }

    public void rC(int i) {
        this.fwB = i;
    }

    public void rD(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("frs_login_tip", true)) {
                if (this.fca == null) {
                    this.fca = new CommonTipView(this.fwg.getActivity());
                }
                this.fca.setText(R.string.frs_login_tip);
                this.fca.show((FrameLayout) bnp(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void kc(boolean z) {
        this.mIsBackground = z;
        if (this.fwJ != null) {
            boolean z2 = (this.fwg == null || this.fwg.blW() == null || this.fwg.blW().btd() == null) ? true : this.fwg.blW().btd().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.fwJ.nh(false);
                this.fwJ.bLA();
                return;
            }
            this.fwJ.nh(true);
            this.fwJ.c(this.fvX, this.dms, this.fwC, true);
        }
    }

    public void br(int i, int i2) {
        if (this.fwJ != null) {
            this.fwJ.a(i, i2, this.fwC, 1);
        }
    }

    public void bs(int i, int i2) {
        this.fvX = i;
        this.dms = i2;
    }

    public void kd(boolean z) {
        this.fwC = z;
    }

    public void rE(int i) {
        if (this.fws != null && this.fws.getChildCount() >= 0) {
            if (this.fws.getFirstVisiblePosition() > 8) {
                this.fws.scrollToPosition(8);
            }
            this.fws.smoothScrollToPosition(i);
        }
    }

    public void bnt() {
        a(this.fwN, this.fwg.bmA());
        if (this.fwt != null) {
            this.fwt.bpk();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.fwO == null) {
                this.fwO = new com.baidu.tieba.video.f(this.fwg.getActivity(), this.fwh);
            }
            this.fwO.h(postWriteCallBackData);
        }
    }

    public void bnu() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("frs_video_activity_guide", 0L) == 0 && !this.fxd && this.fwg.getActivity() != null && this.fwg.getPageContext() != null) {
            View view = null;
            if (this.fws != null && (headerViewsCount = this.fws.getHeaderViewsCount()) < this.fws.getChildCount()) {
                view = this.fws.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).X(0).U(true).V(false).T(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        k.this.fwg.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.g(k.this.fwg.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.g(k.this.fwg.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c hV = dVar.hV();
                hV.R(false);
                hV.q(this.fwg.getActivity());
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hV != null) {
                            hV.dismiss();
                        }
                    }
                }, 4000L);
                this.fxd = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.fwW != null) {
            this.fwW.setDeleteCallback(aVar);
        }
    }

    public void bnv() {
        if (this.fwW != null) {
            this.fwW.bnv();
        }
    }

    public void aBp() {
        if (this.fwW != null) {
            this.fwW.aBp();
        }
    }

    public void au(String str, int i) {
        if (this.fwY == null) {
            this.fwY = new TextView(this.fwg.getActivity());
            this.fwY.setGravity(19);
            this.fwY.setPadding(com.baidu.adp.lib.util.l.g(this.fwg.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.g(this.fwg.getActivity(), R.dimen.ds34), 0);
            this.fwY.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.fwg.getActivity(), R.dimen.tbds112)));
            this.fwY.setTextSize(0, com.baidu.adp.lib.util.l.g(this.fwg.getActivity(), R.dimen.fontsize30));
            this.fwY.setMaxLines(2);
            this.fwY.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.fwY.setTextColor(ContextCompat.getColor(this.fwg.getActivity(), R.color.cp_btn_a));
        }
        this.fwX.setBackgroundColor(i);
        this.fwY.setText(str);
        this.fwX.a(this.fwg.getActivity(), this.fwY, UIMsg.m_AppUI.MSG_APP_GPS);
    }

    public void setExpanded(boolean z) {
        if (this.Qj != null) {
            this.Qj.setExpanded(z);
        }
    }

    public void bnw() {
        if (this.Qj != null && this.fws != null) {
            int count = this.fws.getCount();
            if (this.fws.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.Qj.setExpanded(true, true);
            }
        }
    }

    public void bnx() {
        if (this.mPullView != null) {
            this.mPullView.akP();
        }
        startPullRefresh();
    }

    public void bny() {
        if (bno() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bno().getDatas();
            if (!com.baidu.tbadk.core.util.v.aa(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bg) {
                        bg bgVar = (bg) mVar;
                        if (bgVar.bJl != 0 && bgVar.threadData != null && this.fwg.blT() != null && this.fwg.blT().bqX() != null) {
                            int[] imageWidthAndHeight = this.fwg.blT().bqX().imageWidthAndHeight(bgVar.threadData);
                            bgVar.bJl = imageWidthAndHeight[0];
                            bgVar.bJm = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.5
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.bno().notifyDataSetChanged();
                        if (!k.this.mIsBackground) {
                            k.this.fwJ.c(k.this.fvX, k.this.dms, k.this.fwC, true);
                        }
                    }
                }, 500L);
            }
        }
    }
}
