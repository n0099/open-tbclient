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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bn;
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
    private AppBarLayout PQ;
    private PbListView dlY;
    private BdSwipeRefreshLayout dni;
    private ImageView eGI;
    private NoNetworkView eRV;
    private CommonTipView eWA;
    private com.baidu.adp.widget.ListView.k eXp;
    private FrsFragment fqJ;
    private View fqN;
    private com.baidu.tieba.c.b fqO;
    private ImageView fqP;
    private TextView fqQ;
    private ViewStub fqR;
    private BdTypeRecyclerView fqV;
    private com.baidu.tieba.frs.entelechy.a.aa fqW;
    private FloatingAnimationView fqX;
    private com.baidu.tieba.c.c fqY;
    private FrsMultiDelBottomMenuView frA;
    private NavigationBarCoverTip frB;
    private TextView frC;
    private boolean frH;
    private View.OnClickListener fra;
    private View frb;
    private View frc;
    private int fre;
    private com.baidu.tieba.frs.vc.d frg;
    private com.baidu.tieba.frs.entelechy.b.c frh;
    private com.baidu.tieba.frs.vc.j fri;
    private GifView frj;
    private TbImageView frk;
    private HashSet<String> frl;
    private com.baidu.tieba.play.m frm;
    private ObservedChangeLinearLayout frp;
    private com.baidu.tieba.frs.entelechy.b.a frq;
    private com.baidu.tieba.video.f frr;
    private AppBarLayoutStickyBehavior frt;
    private FrsHeaderViewContainer fru;
    private CollapsingToolbarLayout frv;
    private com.baidu.tieba.frs.vc.f frz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean fqI = false;
    private NoPressedRelativeLayout fqK = null;
    private CoordinatorLayout fqL = null;
    private View fqM = null;
    private FrameLayout fqS = null;
    private TbImageView fqT = null;
    private TbImageView fqU = null;
    private com.baidu.tbadk.core.dialog.b fqZ = null;
    private NoNetworkView.a fmv = null;
    private boolean frd = true;
    private boolean mHasMore = true;
    private boolean frf = false;
    private int fqA = 0;
    private int dkD = 0;
    private View frn = null;
    private View fro = null;
    private boolean efm = false;
    private boolean boa = true;
    private boolean frw = true;
    private int frx = -1;
    private int fry = -1;
    private int frD = 0;
    private int frE = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener eXr = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.eXp == null) {
                        k.this.eXp = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.eXp.a(k.this.fqV, 2);
                } else if (k.this.eXp != null) {
                    k.this.eXp.oa();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener frF = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fry != i && Math.abs(i) >= 0 && k.this.bkG() != -1) {
                if (Math.abs(i) >= k.this.bkG()) {
                    if (k.this.frw) {
                        k.this.frw = false;
                        k.this.jJ(k.this.frw);
                    }
                } else if (!k.this.frw) {
                    k.this.frw = true;
                    k.this.jJ(k.this.frw);
                }
                int bkC = k.this.bkC() + k.this.bkB() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bkC;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fry - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.rb(Math.abs(bkC - totalScrollRange2));
                        if (k.this.fro != null) {
                            k.this.fro.setVisibility(0);
                        }
                    } else if (k.this.fro != null) {
                        if (k.this.bkA() != UtilHelper.getStatusBarHeight()) {
                            k.this.rb(0);
                        }
                        k.this.fro.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.efm) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.jO(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fry = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable frG = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.fqR != null) {
                k.this.fqS.setVisibility(0);
                k.this.fqU.setVisibility(0);
                k.this.fqT.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        if (this.fqJ != null && appBarLayout != null && this.fqJ.bjN() != null && this.fqJ.getPageContext() != null) {
            int bkB = bkB() + getNavigationBarHeight() + bkC();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bjN = this.fqJ.bjN();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fqJ.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.fqJ.getPageContext().getPageActivity());
            }
            if (totalScrollRange <= 0) {
                if (this.frE != 2) {
                    bjN.sJ(2);
                }
                this.frE = 2;
            } else if (totalScrollRange > 0 && totalScrollRange <= bkB) {
                if (this.frE != 1) {
                    bjN.sJ(1);
                }
                this.frE = 1;
            } else {
                if (this.frE != 0) {
                    bjN.sJ(0);
                }
                this.frE = 0;
            }
        }
    }

    public ObservedChangeLinearLayout bkx() {
        return this.frp;
    }

    public View bky() {
        return this.frn;
    }

    public View bkz() {
        return this.fro;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkA() {
        if (this.frn == null) {
            return 0;
        }
        return this.frn.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkB() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkC() {
        if (this.eRV == null || com.baidu.adp.lib.util.j.jS()) {
            return 0;
        }
        return this.eRV.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rb(int i) {
        View bky = bky();
        View bkz = bkz();
        if (UtilHelper.canUseStyleImmersiveSticky() && bky != null && bkz != null && bky.getLayoutParams() != null && bkz.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = bky.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            bky.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bkz.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bkz.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.fqJ = null;
        this.fra = null;
        this.fre = 0;
        this.fqJ = frsFragment;
        this.fra = onClickListener;
        MessageManager.getInstance().registerListener(this.eXr);
        a(aVar, z);
        this.frl = new HashSet<>();
        this.fre = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.frz = fVar;
    }

    private boolean bkD() {
        return this.frz != null && this.frz.bqt();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.frq = aVar;
        View rootView = this.fqJ.getRootView();
        if (this.fqK == null) {
            this.fqK = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.fqM == null) {
            this.fqM = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.fqL == null) {
            this.fqL = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.frc == null) {
            this.frc = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.frv == null) {
            this.frv = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.fru == null) {
            this.fru = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.frp == null) {
            this.frp = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.frp.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.frv.setMinimumHeight(i2);
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
        if (this.fqJ.bko()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.frb == null) {
            this.frb = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bmC = aVar.bmC();
            if (bmC != null) {
                bmC.bP(this.frb);
            }
        }
        if (this.fqN == null) {
            this.fqN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fqN.setOnClickListener(this.fra);
            this.mBackImageView = (ImageView) this.fqN.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fqO == null) {
            this.fqO = new com.baidu.tieba.c.b(this.fqJ.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fqO.getView(), (View.OnClickListener) null);
            this.eGI = this.fqO.aZt();
            this.fqO.getView().setOnClickListener(this.fra);
        }
        if (this.fqP == null) {
            this.fqP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.fqP.setOnClickListener(this.fra);
        }
        if (this.fqQ == null) {
            this.fqQ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.fqQ.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_arrow12_white);
            int g = com.baidu.adp.lib.util.l.g(this.fqJ.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, g, g);
            this.fqQ.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.al.j(this.fqQ, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.al.j(this.fqQ, R.color.cp_btn_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.fqJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.fqJ.getPageContext());
        }
        this.mPullView.setTag(this.fqJ.getUniqueId());
        if (this.dni == null) {
            this.dni = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.dni.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.l(this.dni, R.color.cp_bg_line_c);
        }
        if (this.fqV == null) {
            this.fqV = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int frK = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.frK--;
                if (this.frK == 0) {
                    k.this.fqV.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.frK++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.fqV.setItemAnimator(defaultItemAnimator);
        this.fqV.setLayoutManager(new LinearLayoutManager(this.fqV.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eXp = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.eXp.a(this.fqV, 2);
        }
        this.fqV.setScrollable(this.fqJ);
        this.fqV.setFadingEdgeLength(0);
        this.fqV.setOverScrollMode(2);
        this.fqK.setBottomOrderView(this.fqV);
        this.fqV.setOnTouchListener(this.fqJ.clc);
        this.fqV.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.frm != null) {
                    k.this.frm.cj(view);
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
        if (this.dlY == null) {
            this.dlY = new PbListView(this.fqJ.getPageContext().getPageActivity());
            this.dlY.getView();
        }
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.setHeight(com.baidu.adp.lib.util.l.g(this.fqJ.getActivity(), R.dimen.tbds182));
        this.dlY.ajv();
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_d));
        this.dlY.iN(R.color.cp_cont_e);
        this.fqV.setOnSrollToBottomListener(this.fqJ);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.fqJ.bki();
                if (k.this.fqJ != null && k.this.PQ != null) {
                    k.this.fqJ.bkq();
                    k.this.PQ.setExpanded(true);
                    if (k.this.frm != null) {
                        k.this.frm.c(k.this.fqA, k.this.dkD, false, true);
                    }
                }
            }
        });
        boolean ain = com.baidu.tbadk.core.util.ar.ail().ain();
        if (this.fqW == null) {
            this.fqW = aVar.a(this.fqJ, this.fqV, ain);
        }
        fY(false);
        if (!z) {
            if (this.eRV == null) {
                this.eRV = new NoNetworkView(this.fqJ.getActivity());
                this.eRV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.frp.addView(this.eRV);
            }
            if (com.baidu.adp.lib.util.j.jG()) {
                this.eRV.setVisibility(8);
            } else {
                this.eRV.setVisibility(0);
            }
            this.eRV.onChangeSkinType(this.fqJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bkN();
        if (this.frg == null) {
            this.frg = aVar.a(this.fqJ, this.fqK);
            this.frg.b(this.fqJ.bkr());
        }
        if (this.frh == null) {
            this.frh = aVar.b(this.fqJ, this.fqK);
            jM(true);
        }
        if (this.frn == null) {
            this.frn = rootView.findViewById(R.id.statebar_view);
        }
        if (this.fro == null) {
            this.fro = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.frm == null) {
            this.frm = new com.baidu.tieba.play.m(this.fqJ.getPageContext(), this.fqV);
        }
        this.frm.setUniqueId(this.fqJ.getUniqueId());
        this.frB = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.fri == null) {
            this.fri = new com.baidu.tieba.frs.vc.j(this.fqJ, this.frB);
        }
        if (this.PQ == null) {
            this.PQ = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.PQ.addOnOffsetChangedListener(this.frF);
            this.frw = true;
            this.frx = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.PQ.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.frt = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.frA = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.frA.setPageContext(this.fqJ.getPageContext());
        this.fqX = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.fqX.setPageId(this.fqJ.getUniqueId());
        this.fqY = new com.baidu.tieba.c.c(this.fqJ.getTbPageContext(), this.fqX, 2);
    }

    public void jI(boolean z) {
        if (z && this.fqY != null) {
            this.fqY.aFu();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.fqY != null) {
            this.fqY.a(oVar);
        }
    }

    private void bkE() {
        ViewGroup.LayoutParams layoutParams;
        this.efm = bkD();
        if (this.fru != null && (layoutParams = this.fru.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.efm) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bkB(), 0, 0);
            }
            this.fru.requestLayout();
        }
    }

    public void bkF() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.frp != null) {
            bkE();
            if (this.efm) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.frn != null) {
                    this.frn.setAlpha(1.0f);
                }
                if (this.fro != null) {
                    this.fro.setAlpha(1.0f);
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
    public void jJ(boolean z) {
        if (z && this.fqJ != null && this.fqJ.bjM() != null) {
            this.fqJ.bjM().bqy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkG() {
        int i;
        if (this.PQ == null) {
            return this.frx;
        }
        if (this.frx != -1) {
            return this.frx;
        }
        int childCount = this.PQ.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.PQ.getChildAt(childCount);
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
        this.frx = Math.max(0, this.PQ.getTotalScrollRange() - Math.abs(i2));
        return this.frx;
    }

    public void wq(String str) {
        if (this.fri != null) {
            this.fri.wq(str);
        }
    }

    public com.baidu.tieba.play.m bkH() {
        return this.frm;
    }

    public com.baidu.tieba.frs.entelechy.b.c bkI() {
        return this.frh;
    }

    public void jK(boolean z) {
        if (this.frg != null) {
            this.frg.jK(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bkJ() {
        return this.frg;
    }

    public void E(boolean z, boolean z2) {
        if (this.boa && this.frh != null) {
            this.frh.E(z, z2);
        }
    }

    public void jL(boolean z) {
        this.boa = z;
        if (!this.boa && this.frh != null) {
            this.frh.E(false, false);
        }
    }

    public void bkK() {
        if (this.boa && this.frh != null) {
            this.frh.E(false, false);
        }
        rc(8);
        this.fqP.setVisibility(8);
        jK(false);
        this.fqV.setVisibility(8);
        this.fru.setVisibility(8);
    }

    public void bkL() {
        if (this.boa && this.frh != null) {
            this.frh.E(true, false);
        }
        rc(0);
        bkM();
        jK(this.fqJ.bkt());
        this.fqV.setVisibility(0);
        this.fru.setVisibility(0);
    }

    private void rc(int i) {
        if (this.fqO != null) {
            this.fqO.setVisibility(i);
        }
    }

    private void bkM() {
        this.fqP.setVisibility(0);
    }

    public void jM(boolean z) {
        if (this.frh != null) {
            this.frh.kp(z);
        }
    }

    private void bkN() {
        if (this.frj == null) {
            View rootView = this.fqJ.getRootView();
            this.frj = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.frk = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.frk.setPageId(this.fqJ.getUniqueId());
            this.frj.setLayerType(1, null);
            this.frk.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bkO() {
        return this.fqN;
    }

    public void h(NoNetworkView.a aVar) {
        this.fmv = aVar;
        if (this.eRV != null) {
            this.eRV.a(this.fmv);
        }
    }

    public void fY(boolean z) {
        this.fqI = z;
        if (z) {
            if (this.frh != null) {
                this.frh.bnf();
                return;
            }
            return;
        }
        this.fqV.getAdapter().notifyDataSetChanged();
        if (this.frh != null) {
            this.frh.bng();
        }
    }

    public void jN(boolean z) {
        if (this.frh != null) {
            if (z) {
                E(false, true);
            } else {
                E(false, false);
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
        this.fqV.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        this.fqW.setOnAdapterItemClickListener(sVar);
    }

    public void setForumName(String str) {
        this.fqW.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eXr);
        if (this.frm != null) {
            this.frm.destroy();
        }
        if (this.fri != null) {
            this.fri.onDestory();
        }
        if (this.frA != null) {
            this.frA.setPageContext(null);
        }
        this.fqW.onDestory();
        this.fqV.setOnSrollToBottomListener(null);
        this.fqV.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.frG);
        if (this.eWA != null) {
            this.eWA.onDestroy();
        }
        this.frl.clear();
        if (this.frg != null) {
            this.frg.bqk();
        }
        if (this.frr != null) {
            this.frr.bmr();
        }
        if (this.fqY != null) {
            this.fqY.onDestroy();
        }
        if (this.frB != null) {
            this.frB.onDestroy();
        }
        if (this.frA != null) {
            this.frA.onDestroy();
        }
    }

    public boolean bkP() {
        if (this.PQ == null || this.frt == null || !this.frt.isSticky()) {
            return this.frg != null && this.frg.bkP();
        }
        if (this.fqV != null) {
            this.fqV.setSelection(0);
        }
        this.frt.expandedAppBarLayout(this.PQ);
        return true;
    }

    public boolean bkn() {
        return this.fqI;
    }

    public void aUH() {
        this.fqV.setVisibility(0);
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
            com.baidu.tbadk.core.i.abb().lY(str);
        }
    }

    public void bkQ() {
        if (this.fqW != null) {
            this.fqW.notifyDataSetChanged();
        }
    }

    public void Ve() {
        if (this.fqW instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.fqW).Ve();
        }
    }

    private void bkR() {
        if (this.fqZ == null && this.fqJ.getPageContext() != null) {
            String[] strArr = {this.fqJ.getPageContext().getPageActivity().getString(R.string.take_photo), this.fqJ.getPageContext().getPageActivity().getString(R.string.album)};
            this.fqZ = new com.baidu.tbadk.core.dialog.b(this.fqJ.getPageContext().getPageActivity());
            this.fqZ.mE(this.fqJ.getPageContext().getPageActivity().getString(R.string.operation));
            this.fqZ.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.fqJ.takePhoto();
                    } else if (i == 1 && k.this.fqJ.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.W(k.this.fqJ.getPageContext().getPageActivity());
                    }
                }
            });
            this.fqZ.d(this.fqJ.getPageContext());
        }
    }

    public void bkS() {
        bkR();
        if (this.fqZ != null) {
            this.fqZ.afJ();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.aa(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            if (this.fqJ != null && this.fqJ.bjK() != null && this.fqJ.bjK().bpe() == 0) {
                mVar.rl(this.fqJ.bjK().bpl());
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
                if (mVar2 instanceof bf) {
                    ((bf) mVar2).threadData.setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.fqW.b(arrayList2, frsViewData);
        if (this.frm != null && this.fqA != 0) {
            this.frm.c(this.fqA, this.dkD, this.frf, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fqV;
    }

    public void bkT() {
        this.fqW.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fqJ.getPageContext(), 1);
        aVar.a(this.fqV);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.fqJ.getForumName());
        hashMap.put("forum_id", this.fqJ.getForumId());
        aVar.setParams(hashMap);
        aVar.ak(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.frg != null) {
            this.frg.bql();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        rd(TbadkCoreApplication.getInst().getSkinType());
        if (this.frg != null) {
            this.frg.bqm();
        }
    }

    public void release() {
        if (this.eRV != null && this.fmv != null) {
            this.eRV.b(this.fmv);
        }
    }

    public ImageView bkU() {
        return this.fqP;
    }

    public TextView bkV() {
        return this.fqQ;
    }

    public View bkW() {
        if (this.fqO != null) {
            return this.fqO.getView();
        }
        return null;
    }

    public void B(int i, boolean z) {
        if (this.fqO != null) {
            this.fqO.l(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fqJ, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fqJ.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.frk != null) {
            this.frk.invalidate();
        }
        if (this.fqW != null) {
            this.fqW.bmZ();
            this.fqW.notifyDataSetChanged();
        }
        com.baidu.tbadk.s.a.a(this.fqJ.getPageContext(), this.fqK);
        if (this.eRV != null) {
            this.eRV.onChangeSkinType(this.fqJ.getPageContext(), i);
        }
        if (this.dlY != null) {
            this.dlY.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_d));
            this.dlY.iP(i);
        }
        rd(i);
        if (this.frh != null) {
            this.frh.onChangeSkinType(i);
        }
        if (this.frg != null) {
            this.frg.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.frA != null) {
            this.frA.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.l(this.dni, R.color.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.l(this.fqM, R.color.cp_bg_line_d);
    }

    private void rd(int i) {
        if (this.fqJ != null) {
            re(i);
        }
    }

    private void re(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fqJ.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.h(this.frb, R.color.cp_bg_line_b, i);
        }
        com.baidu.tbadk.core.util.al.l(this.frn, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.l(this.fro, R.color.cp_bg_line_d);
        jO(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jO(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.efm) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.frD != 0) {
                    com.baidu.tbadk.core.util.al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
                    com.baidu.tbadk.core.util.al.c(this.fqP, (int) R.drawable.icon_topbar_more_white_n, (int) R.drawable.icon_topbar_more_white_s);
                    com.baidu.tbadk.core.util.al.c(this.eGI, (int) R.drawable.icon_common_news_white_n, (int) R.drawable.icon_common_news_white_s);
                    this.frD = 0;
                }
            } else if (z || this.frD != 1) {
                com.baidu.tbadk.core.util.al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
                com.baidu.tbadk.core.util.al.c(this.fqP, (int) R.drawable.icon_topbar_more_n, (int) R.drawable.icon_topbar_more_s);
                com.baidu.tbadk.core.util.al.c(this.eGI, (int) R.drawable.icon_common_news_n, (int) R.drawable.icon_common_news_s);
                this.frD = 1;
            }
            bkX();
        }
    }

    private void bkX() {
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
                if (this.eGI != null) {
                    this.eGI.setAlpha(f);
                }
                if (this.fqP != null) {
                    this.fqP.setAlpha(f);
                }
            }
            if (this.fqQ != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.fqQ.setAlpha(f2);
                this.fqQ.setClickable(f2 > 0.0f);
            }
            if (this.frn != null) {
                this.frn.setAlpha(alpha);
            }
            if (this.fro != null) {
                this.fro.setAlpha(alpha);
            }
            if (this.frb != null) {
                this.frb.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.fqV != null) {
            this.fqV.setSelection(0);
        }
        if (this.PQ != null) {
            this.PQ.setExpanded(true);
        }
        if (this.dni != null && this.dni.isEnabled()) {
            this.dni.setRefreshing(true);
        }
    }

    public void jP(boolean z) {
        if (z) {
            this.dni.setRefreshing(false);
        } else {
            this.dni.oz();
        }
    }

    public void jQ(boolean z) {
        this.dni.setEnabled(z);
    }

    public void jR(boolean z) {
        this.frd = z;
        if (this.frd) {
            this.dlY.setText(this.fqJ.getResources().getString(R.string.load_more));
            if (this.fqV.getChildAt(this.fqV.getChildCount() - 1) == this.dlY.getView()) {
                this.dlY.ajy();
                this.fqJ.aHt();
                return;
            }
            this.dlY.ajz();
            return;
        }
        this.dlY.setText(this.fqJ.getResources().getString(R.string.load_more_must_after_delete));
        this.dlY.ajz();
    }

    public boolean bkY() {
        if (this.frd) {
            return false;
        }
        this.dlY.setText(this.fqJ.getResources().getString(R.string.load_more_must_after_delete));
        this.dlY.ajz();
        return true;
    }

    public boolean bkZ() {
        return this.fqR != null && this.fqU.getVisibility() == 0;
    }

    public void bla() {
        if (this.fqR != null) {
            this.fqS.setVisibility(0);
            this.fqU.setVisibility(8);
            this.fqT.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.frG, 5000L);
        }
    }

    public void a(bn bnVar) {
        if (this.fqR == null) {
            View rootView = this.fqJ.getRootView();
            this.fqR = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.fqR.setVisibility(0);
            this.fqS = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.fqT = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.fqU = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.fqT.setPageId(this.fqJ.getUniqueId());
            this.fqU.setPageId(this.fqJ.getUniqueId());
            this.fqT.setDefaultBgResource(R.color.common_color_10022);
            this.fqT.setDefaultResource(0);
            this.fqU.setDefaultBgResource(R.color.common_color_10022);
            this.fqU.setDefaultResource(0);
            this.fqS.setOnClickListener(this.fra);
        }
        this.fqS.setVisibility(0);
        String afx = bnVar.afx();
        String afy = bnVar.afy();
        this.fqT.startLoad(afx, 10, false);
        this.fqU.startLoad(afy, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.frG, 5000L);
    }

    public void blb() {
        if (this.fqR != null && this.fqS != null) {
            this.fqS.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.aa blc() {
        return this.fqW;
    }

    public RelativeLayout bld() {
        return this.fqK;
    }

    public View ble() {
        return this.frc;
    }

    public void rf(int i) {
        if (this.fqM != null) {
            this.fqM.setVisibility(i);
        }
    }

    public void blf() {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            int lastVisiblePosition = this.fqV.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fqV.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.frV != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.frV.getPerfLog();
                        perfLog.kK(1000);
                        perfLog.cyw = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.frV.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.frV.startLogPerf();
                    }
                    if (oVar.frU != null && (oVar.frU instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.frU;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kK(1000);
                                perfLog2.cyw = true;
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

    public NavigationBar aJC() {
        return this.mNavigationBar;
    }

    public void aIH() {
        this.mHasMore = true;
        this.fqV.setNextPage(this.dlY);
        if (this.fre > 0) {
            this.dlY.iQ(this.fre);
        }
        this.dlY.setOnClickListener(null);
        this.dlY.ajy();
    }

    public void aII() {
        this.mHasMore = false;
        this.fqV.setNextPage(this.dlY);
        if (this.fre > 0) {
            this.dlY.iQ(this.fre);
        }
        this.dlY.setOnClickListener(null);
        this.dlY.ajz();
        this.dlY.setText(this.fqJ.getResources().getString(R.string.list_has_no_more));
    }

    public void blg() {
        this.mHasMore = true;
        this.fqV.setNextPage(this.dlY);
        this.dlY.setOnClickListener(this.fra);
        if (this.fre > 0) {
            this.dlY.iQ(this.fre);
        }
        this.dlY.ajz();
        this.dlY.setText(this.fqJ.getResources().getString(R.string.list_click_load_more));
    }

    public View blh() {
        if (this.dlY == null) {
            return null;
        }
        return this.dlY.getView();
    }

    public void rg(int i) {
        if (this.frA != null) {
            this.frA.setVisibility(i);
        }
    }

    public void rh(int i) {
        if (this.frA != null) {
            this.frA.setSelectNumber(i);
        }
    }

    public void aIJ() {
        this.mHasMore = false;
        this.fqV.setNextPage(null);
    }

    public boolean aYN() {
        return this.dlY.getView().getParent() != null && this.mHasMore;
    }

    public void ri(int i) {
        this.fre = i;
    }

    public void rj(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("frs_login_tip", true)) {
                if (this.eWA == null) {
                    this.eWA = new CommonTipView(this.fqJ.getActivity());
                }
                this.eWA.setText(R.string.frs_login_tip);
                this.eWA.show((FrameLayout) ble(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void jS(boolean z) {
        this.mIsBackground = z;
        if (this.frm != null) {
            boolean z2 = (this.fqJ == null || this.fqJ.bjN() == null || this.fqJ.bjN().bqP() == null) ? true : this.fqJ.bjN().bqP().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.frm.mT(false);
                this.frm.bIF();
                return;
            }
            this.frm.mT(true);
            this.frm.c(this.fqA, this.dkD, this.frf, true);
        }
    }

    public void bm(int i, int i2) {
        if (this.frm != null) {
            this.frm.a(i, i2, this.frf, 1);
        }
    }

    public void bn(int i, int i2) {
        this.fqA = i;
        this.dkD = i2;
    }

    public void jT(boolean z) {
        this.frf = z;
    }

    public void rk(int i) {
        if (this.fqV != null && this.fqV.getChildCount() >= 0) {
            if (this.fqV.getFirstVisiblePosition() > 8) {
                this.fqV.scrollToPosition(8);
            }
            this.fqV.smoothScrollToPosition(i);
        }
    }

    public void bli() {
        a(this.frq, this.fqJ.bko());
        if (this.fqW != null) {
            this.fqW.bmW();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.frr == null) {
                this.frr = new com.baidu.tieba.video.f(this.fqJ.getActivity(), this.fqK);
            }
            this.frr.h(postWriteCallBackData);
        }
    }

    public void blj() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.agM().getLong("frs_video_activity_guide", 0L) == 0 && !this.frH && this.fqJ.getActivity() != null && this.fqJ.getPageContext() != null) {
            View view = null;
            if (this.fqV != null && (headerViewsCount = this.fqV.getHeaderViewsCount()) < this.fqV.getChildCount()) {
                view = this.fqV.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).X(0).U(true).V(false).T(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        k.this.fqJ.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hJ() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hK() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.g(k.this.fqJ.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.g(k.this.fqJ.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.agM().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c hL = dVar.hL();
                hL.R(false);
                hL.n(this.fqJ.getActivity());
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hL != null) {
                            hL.dismiss();
                        }
                    }
                }, 4000L);
                this.frH = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.frA != null) {
            this.frA.setDeleteCallback(aVar);
        }
    }

    public void blk() {
        if (this.frA != null) {
            this.frA.blk();
        }
    }

    public void azZ() {
        if (this.frA != null) {
            this.frA.azZ();
        }
    }

    public void at(String str, int i) {
        if (this.frC == null) {
            this.frC = new TextView(this.fqJ.getActivity());
            this.frC.setGravity(19);
            this.frC.setPadding(com.baidu.adp.lib.util.l.g(this.fqJ.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.g(this.fqJ.getActivity(), R.dimen.ds34), 0);
            this.frC.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.fqJ.getActivity(), R.dimen.tbds112)));
            this.frC.setTextSize(0, com.baidu.adp.lib.util.l.g(this.fqJ.getActivity(), R.dimen.fontsize30));
            this.frC.setMaxLines(2);
            this.frC.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.frC.setTextColor(ContextCompat.getColor(this.fqJ.getActivity(), R.color.cp_btn_a));
        }
        this.frB.setBackgroundColor(i);
        this.frC.setText(str);
        this.frB.a(this.fqJ.getActivity(), this.frC, UIMsg.m_AppUI.MSG_APP_GPS);
    }

    public void setExpanded(boolean z) {
        if (this.PQ != null) {
            this.PQ.setExpanded(z);
        }
    }

    public void bll() {
        if (this.PQ != null && this.fqV != null) {
            int count = this.fqV.getCount();
            if (this.fqV.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.PQ.setExpanded(true, true);
            }
        }
    }

    public void blm() {
        if (this.mPullView != null) {
            this.mPullView.ajI();
        }
        startPullRefresh();
    }

    public void bln() {
        if (blc() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = blc().getDatas();
            if (!com.baidu.tbadk.core.util.v.aa(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bf) {
                        bf bfVar = (bf) mVar;
                        if (bfVar.bIg != 0 && bfVar.threadData != null && this.fqJ.bjK() != null && this.fqJ.bjK().boJ() != null) {
                            int[] imageWidthAndHeight = this.fqJ.bjK().boJ().imageWidthAndHeight(bfVar.threadData);
                            bfVar.bIg = imageWidthAndHeight[0];
                            bfVar.bIh = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.5
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.blc().notifyDataSetChanged();
                        if (!k.this.mIsBackground) {
                            k.this.frm.c(k.this.fqA, k.this.dkD, k.this.frf, true);
                        }
                    }
                }, 500L);
            }
        }
    }
}
