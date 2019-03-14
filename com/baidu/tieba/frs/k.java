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
import com.baidu.tieba.d;
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
/* loaded from: classes4.dex */
public class k {
    private AppBarLayout Sh;
    private PbListView dbn;
    private BdSwipeRefreshLayout dcA;
    private NoNetworkView eCt;
    private CommonTipView eGL;
    private com.baidu.adp.widget.ListView.k eHs;
    private ImageView ern;
    private FrsFragment faG;
    private View faK;
    private ImageView faL;
    private com.baidu.tieba.c.b faM;
    private ImageView faN;
    private TextView faO;
    private ViewStub faP;
    private BdTypeRecyclerView faT;
    private com.baidu.tieba.frs.entelechy.a.z faU;
    private FloatingAnimationView faV;
    private com.baidu.tieba.c.c faW;
    private View.OnClickListener faY;
    private View faZ;
    private boolean fbE;
    private View fba;
    private int fbc;
    private com.baidu.tieba.frs.vc.d fbe;
    private com.baidu.tieba.frs.entelechy.b.c fbf;
    private com.baidu.tieba.frs.vc.j fbg;
    private GifView fbh;
    private TbImageView fbi;
    private HashSet<String> fbj;
    private com.baidu.tieba.play.m fbk;
    private ObservedChangeLinearLayout fbn;
    private com.baidu.tieba.frs.entelechy.b.a fbo;
    private com.baidu.tieba.video.f fbp;
    private AppBarLayoutStickyBehavior fbq;
    private FrsHeaderViewContainer fbr;
    private CollapsingToolbarLayout fbs;
    private com.baidu.tieba.frs.vc.f fbw;
    private FrsMultiDelBottomMenuView fbx;
    private NavigationBarCoverTip fby;
    private TextView fbz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean faF = false;
    private NoPressedRelativeLayout faH = null;
    private CoordinatorLayout faI = null;
    private View faJ = null;
    private FrameLayout faQ = null;
    private TbImageView faR = null;
    private TbImageView faS = null;
    private com.baidu.tbadk.core.dialog.b faX = null;
    private NoNetworkView.a eWD = null;
    private boolean fbb = true;
    private boolean mHasMore = true;
    private boolean fbd = false;
    private int fax = 0;
    private int cZR = 0;
    private View fbl = null;
    private View fbm = null;
    private boolean dVp = false;
    private boolean bhR = true;
    private boolean fbt = true;
    private int fbu = -1;
    private int fbv = -1;
    private int fbA = 0;
    private int fbB = 0;
    private boolean mIsPrivateForum = false;
    private CustomMessageListener eHt = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.eHs == null) {
                        k.this.eHs = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.eHs.a(k.this.faT, 2);
                } else if (k.this.eHs != null) {
                    k.this.eHs.pg();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fbC = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.5
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fbv != i && Math.abs(i) >= 0 && k.this.bdn() != -1) {
                if (Math.abs(i) >= k.this.bdn()) {
                    if (k.this.fbt) {
                        k.this.fbt = false;
                        k.this.iZ(k.this.fbt);
                    }
                } else if (!k.this.fbt) {
                    k.this.fbt = true;
                    k.this.iZ(k.this.fbt);
                }
                int bdj = k.this.bdj() + k.this.bdi() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bdj;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fbv - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.pY(Math.abs(bdj - totalScrollRange2));
                        if (k.this.fbm != null) {
                            k.this.fbm.setVisibility(0);
                        }
                    } else if (k.this.fbm != null) {
                        if (k.this.bdh() != UtilHelper.getStatusBarHeight()) {
                            k.this.pY(0);
                        }
                        k.this.fbm.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.dVp) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.je(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fbv = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable fbD = new Runnable() { // from class: com.baidu.tieba.frs.k.12
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.faP != null) {
                k.this.faQ.setVisibility(0);
                k.this.faS.setVisibility(0);
                k.this.faR.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        if (this.faG != null && appBarLayout != null && this.faG.bcs() != null && this.faG.getPageContext() != null) {
            int bdi = bdi() + getNavigationBarHeight() + bdj();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bcs = this.faG.bcs();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.faG.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.faG.getPageContext().getPageActivity());
            }
            if (totalScrollRange <= 0) {
                if (this.fbB != 2) {
                    bcs.rF(2);
                }
                this.fbB = 2;
            } else if (totalScrollRange > 0 && totalScrollRange <= bdi) {
                if (this.fbB != 1) {
                    bcs.rF(1);
                }
                this.fbB = 1;
            } else {
                if (this.fbB != 0) {
                    bcs.rF(0);
                }
                this.fbB = 0;
            }
        }
    }

    public ObservedChangeLinearLayout bde() {
        return this.fbn;
    }

    public View bdf() {
        return this.fbl;
    }

    public View bdg() {
        return this.fbm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdh() {
        if (this.fbl == null) {
            return 0;
        }
        return this.fbl.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdi() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdj() {
        if (this.eCt == null || com.baidu.adp.lib.util.j.kY()) {
            return 0;
        }
        return this.eCt.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(int i) {
        View bdf = bdf();
        View bdg = bdg();
        if (UtilHelper.canUseStyleImmersiveSticky() && bdf != null && bdg != null && bdf.getLayoutParams() != null && bdg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = bdf.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            bdf.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bdg.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bdg.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.faG = null;
        this.faY = null;
        this.fbc = 0;
        this.faG = frsFragment;
        this.faY = onClickListener;
        MessageManager.getInstance().registerListener(this.eHt);
        a(aVar, z);
        this.fbj = new HashSet<>();
        this.fbc = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fbw = fVar;
    }

    private boolean bdk() {
        return this.fbw != null && this.fbw.biY();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.fbo = aVar;
        View rootView = this.faG.getRootView();
        if (this.faH == null) {
            this.faH = (NoPressedRelativeLayout) rootView.findViewById(d.g.frs);
        }
        if (this.faJ == null) {
            this.faJ = rootView.findViewById(d.g.frs_content_container);
        }
        if (this.faI == null) {
            this.faI = (CoordinatorLayout) rootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.fba == null) {
            this.fba = rootView.findViewById(d.g.frs_list_content);
        }
        if (this.fbs == null) {
            this.fbs = (CollapsingToolbarLayout) rootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.fbr == null) {
            this.fbr = (FrsHeaderViewContainer) rootView.findViewById(d.g.header_view_container);
        }
        if (this.fbn == null) {
            this.fbn = (ObservedChangeLinearLayout) rootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.fbn.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.6
                @Override // com.baidu.tbadk.widget.layout.e
                public void b(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fbs.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) rootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.faG.bcT()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.faZ == null) {
            this.faZ = rootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bfi = aVar.bfi();
            if (bfi != null) {
                bfi.bH(this.faZ);
            }
        }
        if (this.faK == null) {
            this.faK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.faK.setOnClickListener(this.faY);
            this.mBackImageView = (ImageView) this.faK.findViewById(d.g.widget_navi_back_button);
        }
        if (this.faL == null) {
            this.faL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.faL.setOnClickListener(this.faY);
        }
        if (this.faM == null) {
            this.faM = new com.baidu.tieba.c.b(this.faG.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.faM.getView(), (View.OnClickListener) null);
            this.ern = this.faM.aSj();
            this.faM.getView().setOnClickListener(this.faY);
        }
        if (this.faN == null) {
            this.faN = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_private_more, (View.OnClickListener) null);
            this.faN.setVisibility(8);
            this.faN.setOnClickListener(this.faY);
        }
        if (this.faO == null) {
            this.faO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, d.h.frs_private_status, (View.OnClickListener) null);
            this.faO.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_arrow12_white);
            int h = com.baidu.adp.lib.util.l.h(this.faG.getActivity(), d.e.tbds31);
            drawable.setBounds(0, 0, h, h);
            this.faO.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.al.g(this.faO, d.f.bg_frs_private_status_n, d.f.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.al.j(this.faO, d.C0277d.cp_btn_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.faG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), d.C0277d.cp_bg_line_b);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.faG.getPageContext());
        }
        this.mPullView.setTag(this.faG.getUniqueId());
        if (this.dcA == null) {
            this.dcA = (BdSwipeRefreshLayout) rootView.findViewById(d.g.frs_pull_refresh_layout);
            this.dcA.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.l(this.dcA, d.C0277d.cp_bg_line_c);
        }
        if (this.faT == null) {
            this.faT = (BdTypeRecyclerView) rootView.findViewById(d.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.7
            int fbH = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.fbH--;
                if (this.fbH == 0) {
                    k.this.faT.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.fbH++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.faT.setItemAnimator(defaultItemAnimator);
        this.faT.setLayoutManager(new LinearLayoutManager(this.faT.getContext()) { // from class: com.baidu.tieba.frs.k.8
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eHs = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.eHs.a(this.faT, 2);
        }
        this.faT.setScrollable(this.faG);
        this.faT.setFadingEdgeLength(0);
        this.faT.setOverScrollMode(2);
        this.faH.setBottomOrderView(this.faT);
        this.faT.setOnTouchListener(this.faG.ccU);
        this.faT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.fbk != null) {
                    k.this.fbk.cb(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        });
        if (this.dbn == null) {
            this.dbn = new PbListView(this.faG.getPageContext().getPageActivity());
            this.dbn.getView();
        }
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.setHeight(com.baidu.adp.lib.util.l.h(this.faG.getActivity(), d.e.tbds182));
        this.dbn.aez();
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_d));
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.faT.setOnSrollToBottomListener(this.faG);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.faG.bcN();
                if (k.this.faG != null && k.this.Sh != null) {
                    k.this.faG.bcV();
                    k.this.Sh.setExpanded(true);
                    if (k.this.fbk != null) {
                        k.this.fbk.c(k.this.fax, k.this.cZR, false, true);
                    }
                }
            }
        });
        boolean adr = com.baidu.tbadk.core.util.ar.adp().adr();
        if (this.faU == null) {
            this.faU = aVar.a(this.faG, this.faT, adr);
        }
        fB(false);
        if (!z) {
            if (this.eCt == null) {
                this.eCt = new NoNetworkView(this.faG.getActivity());
                this.eCt.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fbn.addView(this.eCt);
            }
            if (com.baidu.adp.lib.util.j.kM()) {
                this.eCt.setVisibility(8);
            } else {
                this.eCt.setVisibility(0);
            }
            this.eCt.onChangeSkinType(this.faG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bdu();
        if (this.fbe == null) {
            this.fbe = aVar.a(this.faG, this.faH);
            this.fbe.b(this.faG.bcW());
        }
        if (this.fbf == null) {
            this.fbf = aVar.b(this.faG, this.faH);
            jc(true);
        }
        if (this.fbl == null) {
            this.fbl = rootView.findViewById(d.g.statebar_view);
        }
        if (this.fbm == null) {
            this.fbm = rootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.fbk == null) {
            this.fbk = new com.baidu.tieba.play.m(this.faG.getPageContext(), this.faT);
        }
        this.fbk.setUniqueId(this.faG.getUniqueId());
        this.fby = (NavigationBarCoverTip) rootView.findViewById(d.g.navigation_cover_tip);
        if (this.fbg == null) {
            this.fbg = new com.baidu.tieba.frs.vc.j(this.faG, this.fby);
        }
        if (this.Sh == null) {
            this.Sh = (AppBarLayout) rootView.findViewById(d.g.frs_app_bar_layout);
            this.Sh.addOnOffsetChangedListener(this.fbC);
            this.fbt = true;
            this.fbu = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Sh.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.fbq = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.fbx = (FrsMultiDelBottomMenuView) rootView.findViewById(d.g.frs_multi_delete_menu_view);
        this.fbx.setPageContext(this.faG.getPageContext());
        this.faV = (FloatingAnimationView) rootView.findViewById(d.g.redpacket_view);
        this.faV.setPageId(this.faG.getUniqueId());
        this.faW = new com.baidu.tieba.c.c(this.faG.getTbPageContext(), this.faV, 2);
    }

    public void iY(boolean z) {
        if (z && this.faW != null) {
            this.faW.aSm();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        if (this.faW != null) {
            this.faW.a(nVar);
        }
    }

    private void bdl() {
        ViewGroup.LayoutParams layoutParams;
        this.dVp = bdk();
        if (this.fbr != null && (layoutParams = this.fbr.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.dVp) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds88) + bdi(), 0, 0);
            }
            this.fbr.requestLayout();
        }
    }

    public void bdm() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fbn != null) {
            bdl();
            if (this.dVp) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.fbl != null) {
                    this.fbl.setAlpha(1.0f);
                }
                if (this.fbm != null) {
                    this.fbm.setAlpha(1.0f);
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
    public void iZ(boolean z) {
        if (z && this.faG != null && this.faG.bcr() != null) {
            this.faG.bcr().bjd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdn() {
        int i;
        if (this.Sh == null) {
            return this.fbu;
        }
        if (this.fbu != -1) {
            return this.fbu;
        }
        int childCount = this.Sh.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Sh.getChildAt(childCount);
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
        this.fbu = Math.max(0, this.Sh.getTotalScrollRange() - Math.abs(i2));
        return this.fbu;
    }

    public void uY(String str) {
        if (this.fbg != null) {
            this.fbg.uY(str);
        }
    }

    public com.baidu.tieba.play.m bdo() {
        return this.fbk;
    }

    public com.baidu.tieba.frs.entelechy.b.c bdp() {
        return this.fbf;
    }

    public void ja(boolean z) {
        if (this.fbe != null) {
            this.fbe.ja(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bdq() {
        return this.fbe;
    }

    public void F(boolean z, boolean z2) {
        if (this.bhR && this.fbf != null) {
            this.fbf.F(z, z2);
        }
    }

    public void jb(boolean z) {
        this.bhR = z;
        if (!this.bhR && this.fbf != null) {
            this.fbf.F(false, false);
        }
    }

    public void bdr() {
        if (this.bhR && this.fbf != null) {
            this.fbf.F(false, false);
        }
        this.faL.setVisibility(8);
        pZ(8);
        this.faN.setVisibility(8);
        ja(false);
        this.faT.setVisibility(8);
        this.fbr.setVisibility(8);
    }

    public void bds() {
        if (this.bhR && this.fbf != null) {
            this.fbf.F(true, false);
        }
        this.faL.setVisibility(0);
        pZ(0);
        bdt();
        ja(this.faG.bcY());
        this.faT.setVisibility(0);
        this.fbr.setVisibility(0);
    }

    private void pZ(int i) {
        if (this.faM != null) {
            this.faM.setVisibility(i);
        }
    }

    private void bdt() {
        if (this.mIsPrivateForum) {
            this.faL.setVisibility(8);
            this.faN.setVisibility(0);
            return;
        }
        this.faL.setVisibility(0);
        this.faN.setVisibility(8);
    }

    public void jc(boolean z) {
        if (this.fbf != null) {
            this.fbf.jD(z);
        }
    }

    private void bdu() {
        if (this.fbh == null) {
            View rootView = this.faG.getRootView();
            this.fbh = (GifView) rootView.findViewById(d.g.gif_real_time);
            this.fbi = (TbImageView) rootView.findViewById(d.g.tbimg_real_time);
            this.fbi.setPageId(this.faG.getUniqueId());
            this.fbh.setLayerType(1, null);
            this.fbi.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bdv() {
        return this.faK;
    }

    public void h(NoNetworkView.a aVar) {
        this.eWD = aVar;
        if (this.eCt != null) {
            this.eCt.a(this.eWD);
        }
    }

    public void fB(boolean z) {
        this.faF = z;
        if (z) {
            if (this.fbf != null) {
                this.fbf.bfL();
                return;
            }
            return;
        }
        this.faT.getAdapter().notifyDataSetChanged();
        if (this.fbf != null) {
            this.fbf.bfM();
        }
    }

    public void jd(boolean z) {
        if (this.fbf != null) {
            if (z) {
                F(false, true);
            } else {
                F(false, false);
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
        this.faT.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        this.faU.setOnAdapterItemClickListener(sVar);
    }

    public void setForumName(String str) {
        this.faU.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eHt);
        if (this.fbk != null) {
            this.fbk.destroy();
        }
        if (this.fbg != null) {
            this.fbg.onDestory();
        }
        if (this.fbx != null) {
            this.fbx.setPageContext(null);
        }
        this.faU.onDestory();
        this.faT.setOnSrollToBottomListener(null);
        this.faT.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.fbD);
        if (this.eGL != null) {
            this.eGL.onDestroy();
        }
        this.fbj.clear();
        if (this.fbe != null) {
            this.fbe.biP();
        }
        if (this.fbp != null) {
            this.fbp.beY();
        }
        if (this.faW != null) {
            this.faW.onDestroy();
        }
        if (this.fby != null) {
            this.fby.onDestroy();
        }
        if (this.fbx != null) {
            this.fbx.onDestroy();
        }
    }

    public boolean bdw() {
        if (this.Sh == null || this.fbq == null || !this.fbq.isSticky()) {
            return this.fbe != null && this.fbe.bdw();
        }
        if (this.faT != null) {
            this.faT.setSelection(0);
        }
        this.fbq.expandedAppBarLayout(this.Sh);
        return true;
    }

    public boolean bcS() {
        return this.faF;
    }

    public void aOA() {
        this.faT.setVisibility(0);
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
            com.baidu.tbadk.core.i.Wy().kT(str);
        }
    }

    public void bdx() {
        if (this.faU != null) {
            this.faU.notifyDataSetChanged();
        }
    }

    public void Ru() {
        if (this.faU instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.faU).Ru();
        }
    }

    private void bdy() {
        if (this.faX == null && this.faG.getPageContext() != null) {
            String[] strArr = {this.faG.getPageContext().getPageActivity().getString(d.j.take_photo), this.faG.getPageContext().getPageActivity().getString(d.j.album)};
            this.faX = new com.baidu.tbadk.core.dialog.b(this.faG.getPageContext().getPageActivity());
            this.faX.lz(this.faG.getPageContext().getPageActivity().getString(d.j.operation));
            this.faX.a(strArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.frs.k.11
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.faG.takePhoto();
                    } else if (i == 1 && k.this.faG.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.U(k.this.faG.getPageContext().getPageActivity());
                    }
                }
            });
            this.faX.d(this.faG.getPageContext());
        }
    }

    public void bdz() {
        bdy();
        if (this.faX != null) {
            this.faX.abc();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.T(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            new ArrayList().add(mVar);
            if (this.faG != null && this.faG.bcp() != null && this.faG.bcp().bhI() == 0) {
                mVar.qi(this.faG.bcp().bhP());
            }
        }
        if (frsViewData != null) {
            this.mIsPrivateForum = frsViewData.isPrivateForum();
        }
        if (com.baidu.tbadk.core.util.v.S(switchThreadDataToThreadCardInfo) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= switchThreadDataToThreadCardInfo.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar2 = switchThreadDataToThreadCardInfo.get(i2);
                if (mVar2 instanceof bf) {
                    ((bf) mVar2).threadData.setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.faU.b(switchThreadDataToThreadCardInfo, frsViewData);
        if (this.fbk != null && this.fax != 0) {
            this.fbk.c(this.fax, this.cZR, this.fbd, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.faT;
    }

    public void bdA() {
        this.faU.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.faG.getPageContext(), 1);
        aVar.a(this.faT);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.faG.getForumName());
        hashMap.put("forum_id", this.faG.getForumId());
        aVar.setParams(hashMap);
        aVar.ak(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.fbe != null) {
            this.fbe.biQ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        qa(TbadkCoreApplication.getInst().getSkinType());
        if (this.fbe != null) {
            this.fbe.biR();
        }
    }

    public void release() {
        if (this.eCt != null && this.eWD != null) {
            this.eCt.b(this.eWD);
        }
    }

    public ImageView bdB() {
        return this.faL;
    }

    public ImageView bdC() {
        return this.faN;
    }

    public TextView bdD() {
        return this.faO;
    }

    public View bdE() {
        if (this.faM != null) {
            return this.faM.getView();
        }
        return null;
    }

    public void w(int i, boolean z) {
        if (this.faM != null) {
            this.faM.l(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.faG, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.faG.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.fbi != null) {
            this.fbi.invalidate();
        }
        if (this.faU != null) {
            this.faU.bfF();
            this.faU.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.faG.getPageContext(), this.faH);
        if (this.eCt != null) {
            this.eCt.onChangeSkinType(this.faG.getPageContext(), i);
        }
        if (this.dbn != null) {
            this.dbn.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_d));
            this.dbn.ic(i);
        }
        qa(i);
        if (this.fbf != null) {
            this.fbf.onChangeSkinType(i);
        }
        if (this.fbe != null) {
            this.fbe.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.fbx != null) {
            this.fbx.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.l(this.dcA, d.C0277d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.l(this.faJ, d.C0277d.cp_bg_line_d);
    }

    private void qa(int i) {
        if (this.faG != null) {
            qb(i);
        }
    }

    private void qb(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.faG.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), d.C0277d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.f(this.faZ, d.C0277d.cp_bg_line_b, i);
        }
        com.baidu.tbadk.core.util.al.l(this.fbl, d.C0277d.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.l(this.fbm, d.C0277d.cp_bg_line_d);
        je(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dVp) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.fbA != 0) {
                    com.baidu.tbadk.core.util.al.c(this.mBackImageView, d.f.icon_topbar_return_white_n, d.f.icon_topbar_return_white_s);
                    com.baidu.tbadk.core.util.al.c(this.faL, d.f.icon_common_search_white_n, d.f.icon_common_search_white_s);
                    com.baidu.tbadk.core.util.al.c(this.faN, d.f.icon_topbar_more_white_n, d.f.icon_topbar_more_white_s);
                    com.baidu.tbadk.core.util.al.c(this.ern, d.f.icon_common_news_white_n, d.f.icon_common_news_white_s);
                    this.fbA = 0;
                }
            } else if (z || this.fbA != 1) {
                com.baidu.tbadk.core.util.al.c(this.mBackImageView, d.f.icon_topbar_return_n, d.f.icon_topbar_return_s);
                com.baidu.tbadk.core.util.al.c(this.faL, d.f.icon_common_search_n, d.f.icon_common_search_s);
                com.baidu.tbadk.core.util.al.c(this.faN, d.f.icon_topbar_more_n, d.f.icon_topbar_more_s);
                com.baidu.tbadk.core.util.al.c(this.ern, d.f.icon_common_news_n, d.f.icon_common_news_s);
                this.fbA = 1;
            }
            bdF();
        }
    }

    private void bdF() {
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
                if (this.faL != null) {
                    this.faL.setAlpha(f);
                }
                if (this.ern != null) {
                    this.ern.setAlpha(f);
                }
                if (this.faN != null) {
                    this.faN.setAlpha(f);
                }
            }
            if (this.faO != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.faO.setAlpha(f2);
                this.faO.setClickable(f2 > 0.0f);
            }
            if (this.fbl != null) {
                this.fbl.setAlpha(alpha);
            }
            if (this.fbm != null) {
                this.fbm.setAlpha(alpha);
            }
            if (this.faZ != null) {
                this.faZ.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.faT != null) {
            this.faT.setSelection(0);
        }
        if (this.Sh != null) {
            this.Sh.setExpanded(true);
        }
        if (this.dcA != null && this.dcA.isEnabled()) {
            this.dcA.setRefreshing(true);
        }
    }

    public void jf(boolean z) {
        if (z) {
            this.dcA.setRefreshing(false);
        } else {
            this.dcA.pE();
        }
    }

    public void jg(boolean z) {
        this.dcA.setEnabled(z);
    }

    public void jh(boolean z) {
        this.fbb = z;
        if (this.fbb) {
            this.dbn.setText(this.faG.getResources().getString(d.j.load_more));
            if (this.faT.getChildAt(this.faT.getChildCount() - 1) == this.dbn.getView()) {
                this.dbn.aeC();
                this.faG.aBc();
                return;
            }
            this.dbn.aeD();
            return;
        }
        this.dbn.setText(this.faG.getResources().getString(d.j.load_more_must_after_delete));
        this.dbn.aeD();
    }

    public boolean bdG() {
        if (this.fbb) {
            return false;
        }
        this.dbn.setText(this.faG.getResources().getString(d.j.load_more_must_after_delete));
        this.dbn.aeD();
        return true;
    }

    public boolean bdH() {
        return this.faP != null && this.faS.getVisibility() == 0;
    }

    public void bdI() {
        if (this.faP != null) {
            this.faQ.setVisibility(0);
            this.faS.setVisibility(8);
            this.faR.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.fbD, 5000L);
        }
    }

    public void a(bn bnVar) {
        if (this.faP == null) {
            View rootView = this.faG.getRootView();
            this.faP = (ViewStub) rootView.findViewById(d.g.yule_game_egg_view_stub);
            this.faP.setVisibility(0);
            this.faQ = (FrameLayout) rootView.findViewById(d.g.game_activity_egg_layout);
            this.faR = (TbImageView) rootView.findViewById(d.g.game_activity_egg);
            this.faS = (TbImageView) rootView.findViewById(d.g.game_activity_egg_s);
            this.faR.setPageId(this.faG.getUniqueId());
            this.faS.setPageId(this.faG.getUniqueId());
            this.faR.setDefaultBgResource(d.C0277d.common_color_10022);
            this.faR.setDefaultResource(0);
            this.faS.setDefaultBgResource(d.C0277d.common_color_10022);
            this.faS.setDefaultResource(0);
            this.faQ.setOnClickListener(this.faY);
        }
        this.faQ.setVisibility(0);
        String aaQ = bnVar.aaQ();
        String aaR = bnVar.aaR();
        this.faR.startLoad(aaQ, 10, false);
        this.faS.startLoad(aaR, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.fbD, 5000L);
    }

    public void bdJ() {
        if (this.faP != null && this.faQ != null) {
            this.faQ.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.z bdK() {
        return this.faU;
    }

    public RelativeLayout bdL() {
        return this.faH;
    }

    public View bdM() {
        return this.fba;
    }

    public void qc(int i) {
        if (this.faJ != null) {
            this.faJ.setVisibility(i);
        }
    }

    public void bdN() {
        if (com.baidu.tbadk.o.m.apk().apl()) {
            int lastVisiblePosition = this.faT.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faT.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fbS != null) {
                        com.baidu.tbadk.o.h perfLog = oVar.fbS.getPerfLog();
                        perfLog.jX(1000);
                        perfLog.cqm = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fbS.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fbS.startLogPerf();
                    }
                    if (oVar.fbR != null && (oVar.fbR instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fbR;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.jX(1000);
                                perfLog2.cqm = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar aDp() {
        return this.mNavigationBar;
    }

    public void aCu() {
        this.mHasMore = true;
        this.faT.setNextPage(this.dbn);
        if (this.fbc > 0) {
            this.dbn.id(this.fbc);
        }
        this.dbn.setOnClickListener(null);
        this.dbn.aeC();
    }

    public void aCv() {
        this.mHasMore = false;
        this.faT.setNextPage(this.dbn);
        if (this.fbc > 0) {
            this.dbn.id(this.fbc);
        }
        this.dbn.setOnClickListener(null);
        this.dbn.aeD();
        this.dbn.setText(this.faG.getResources().getString(d.j.list_has_no_more));
    }

    public void bdO() {
        this.mHasMore = true;
        this.faT.setNextPage(this.dbn);
        this.dbn.setOnClickListener(this.faY);
        if (this.fbc > 0) {
            this.dbn.id(this.fbc);
        }
        this.dbn.aeD();
        this.dbn.setText(this.faG.getResources().getString(d.j.list_click_load_more));
    }

    public View bdP() {
        if (this.dbn == null) {
            return null;
        }
        return this.dbn.getView();
    }

    public void qd(int i) {
        if (this.fbx != null) {
            this.fbx.setVisibility(i);
        }
    }

    public void qe(int i) {
        if (this.fbx != null) {
            this.fbx.setSelectNumber(i);
        }
    }

    public void aCw() {
        this.mHasMore = false;
        this.faT.setNextPage(null);
    }

    public boolean aRD() {
        return this.dbn.getView().getParent() != null && this.mHasMore;
    }

    public void qf(int i) {
        this.fbc = i;
    }

    public void qg(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.eGL == null) {
                    this.eGL = new CommonTipView(this.faG.getActivity());
                }
                this.eGL.setText(d.j.frs_login_tip);
                this.eGL.show((FrameLayout) bdM(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void ji(boolean z) {
        if (this.fbk != null) {
            boolean z2 = (this.faG == null || this.faG.bcs() == null || this.faG.bcs().bju() == null) ? true : this.faG.bcs().bju().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.fbk.md(false);
                this.fbk.bAU();
                return;
            }
            this.fbk.md(true);
            this.fbk.c(this.fax, this.cZR, this.fbd, true);
        }
    }

    public void bg(int i, int i2) {
        if (this.fbk != null) {
            this.fbk.a(i, i2, this.fbd, 1);
        }
    }

    public void bh(int i, int i2) {
        this.fax = i;
        this.cZR = i2;
    }

    public void jj(boolean z) {
        this.fbd = z;
    }

    public void qh(int i) {
        if (this.faT != null && this.faT.getChildCount() >= 0) {
            if (this.faT.getFirstVisiblePosition() > 8) {
                this.faT.scrollToPosition(8);
            }
            this.faT.smoothScrollToPosition(i);
        }
    }

    public void bdQ() {
        a(this.fbo, this.faG.bcT());
        if (this.faU != null) {
            this.faU.bfC();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.fbp == null) {
                this.fbp = new com.baidu.tieba.video.f(this.faG.getActivity(), this.faH);
            }
            this.fbp.h(postWriteCallBackData);
        }
    }

    public void bdR() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.fbE && this.faG.getActivity() != null && this.faG.getPageContext() != null) {
            View view = null;
            if (this.faT != null && (headerViewsCount = this.faT.getHeaderViewsCount()) < this.faT.getChildCount()) {
                view = this.faT.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).af(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.faG.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iR() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iS() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.h(k.this.faG.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.faG.getActivity(), d.e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c iT = dVar.iT();
                iT.Z(false);
                iT.n(this.faG.getActivity());
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iT != null) {
                            iT.dismiss();
                        }
                    }
                }, 4000L);
                this.fbE = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.fbx != null) {
            this.fbx.setDeleteCallback(aVar);
        }
    }

    public void bdS() {
        if (this.fbx != null) {
            this.fbx.bdS();
        }
    }

    public void auU() {
        if (this.fbx != null) {
            this.fbx.auU();
        }
    }

    public void ax(String str, int i) {
        if (this.fbz == null) {
            this.fbz = new TextView(this.faG.getActivity());
            this.fbz.setGravity(19);
            this.fbz.setPadding(com.baidu.adp.lib.util.l.h(this.faG.getActivity(), d.e.ds34), 0, com.baidu.adp.lib.util.l.h(this.faG.getActivity(), d.e.ds34), 0);
            this.fbz.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.faG.getActivity(), d.e.tbds112)));
            this.fbz.setTextSize(0, com.baidu.adp.lib.util.l.h(this.faG.getActivity(), d.e.fontsize30));
            this.fbz.setMaxLines(2);
            this.fbz.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.fbz.setTextColor(ContextCompat.getColor(this.faG.getActivity(), d.C0277d.cp_btn_a));
        }
        this.fby.setBackgroundColor(i);
        this.fbz.setText(str);
        this.fby.a(this.faG.getActivity(), this.fbz, UIMsg.m_AppUI.MSG_APP_GPS);
    }

    public void setExpanded(boolean z) {
        if (this.Sh != null) {
            this.Sh.setExpanded(z);
        }
    }

    public void bdT() {
        if (this.Sh != null && this.faT != null) {
            int count = this.faT.getCount();
            if (this.faT.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.Sh.setExpanded(true, true);
            }
        }
    }

    public void bdU() {
        if (this.mPullView != null) {
            this.mPullView.aeM();
        }
        startPullRefresh();
    }
}
