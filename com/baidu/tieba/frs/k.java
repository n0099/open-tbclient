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
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbConfig;
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
    private AppBarLayout Sg;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private NoNetworkView eCx;
    private CommonTipView eGP;
    private com.baidu.adp.widget.ListView.k eHw;
    private ImageView ers;
    private FrsFragment faH;
    private View faL;
    private ImageView faM;
    private com.baidu.tieba.c.b faN;
    private ImageView faO;
    private TextView faP;
    private ViewStub faQ;
    private BdTypeRecyclerView faU;
    private com.baidu.tieba.frs.entelechy.a.z faV;
    private FloatingAnimationView faW;
    private com.baidu.tieba.c.c faX;
    private View.OnClickListener faZ;
    private TextView fbA;
    private boolean fbF;
    private View fba;
    private View fbb;
    private int fbd;
    private com.baidu.tieba.frs.vc.d fbf;
    private com.baidu.tieba.frs.entelechy.b.c fbg;
    private com.baidu.tieba.frs.vc.j fbh;
    private GifView fbi;
    private TbImageView fbj;
    private HashSet<String> fbk;
    private com.baidu.tieba.play.m fbl;
    private ObservedChangeLinearLayout fbo;
    private com.baidu.tieba.frs.entelechy.b.a fbp;
    private com.baidu.tieba.video.f fbq;
    private AppBarLayoutStickyBehavior fbr;
    private FrsHeaderViewContainer fbs;
    private CollapsingToolbarLayout fbt;
    private com.baidu.tieba.frs.vc.f fbx;
    private FrsMultiDelBottomMenuView fby;
    private NavigationBarCoverTip fbz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean faG = false;
    private NoPressedRelativeLayout faI = null;
    private CoordinatorLayout faJ = null;
    private View faK = null;
    private FrameLayout faR = null;
    private TbImageView faS = null;
    private TbImageView faT = null;
    private com.baidu.tbadk.core.dialog.b faY = null;
    private NoNetworkView.a eWE = null;
    private boolean fbc = true;
    private boolean mHasMore = true;
    private boolean fbe = false;
    private int fay = 0;
    private int cZV = 0;
    private View fbm = null;
    private View fbn = null;
    private boolean dVt = false;
    private boolean bhQ = true;
    private boolean fbu = true;
    private int fbv = -1;
    private int fbw = -1;
    private int fbB = 0;
    private int fbC = 0;
    private boolean mIsPrivateForum = false;
    private CustomMessageListener eHx = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.eHw == null) {
                        k.this.eHw = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.eHw.a(k.this.faU, 2);
                } else if (k.this.eHw != null) {
                    k.this.eHw.pg();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fbD = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.5
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fbw != i && Math.abs(i) >= 0 && k.this.bdo() != -1) {
                if (Math.abs(i) >= k.this.bdo()) {
                    if (k.this.fbu) {
                        k.this.fbu = false;
                        k.this.iZ(k.this.fbu);
                    }
                } else if (!k.this.fbu) {
                    k.this.fbu = true;
                    k.this.iZ(k.this.fbu);
                }
                int bdk = k.this.bdk() + k.this.bdj() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bdk;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fbw - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.pY(Math.abs(bdk - totalScrollRange2));
                        if (k.this.fbn != null) {
                            k.this.fbn.setVisibility(0);
                        }
                    } else if (k.this.fbn != null) {
                        if (k.this.bdi() != UtilHelper.getStatusBarHeight()) {
                            k.this.pY(0);
                        }
                        k.this.fbn.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.dVt) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.je(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fbw = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable fbE = new Runnable() { // from class: com.baidu.tieba.frs.k.12
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.faQ != null) {
                k.this.faR.setVisibility(0);
                k.this.faT.setVisibility(0);
                k.this.faS.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        if (this.faH != null && appBarLayout != null && this.faH.bct() != null && this.faH.getPageContext() != null) {
            int bdj = bdj() + getNavigationBarHeight() + bdk();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bct = this.faH.bct();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.faH.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.faH.getPageContext().getPageActivity());
            }
            if (totalScrollRange <= 0) {
                if (this.fbC != 2) {
                    bct.rF(2);
                }
                this.fbC = 2;
            } else if (totalScrollRange > 0 && totalScrollRange <= bdj) {
                if (this.fbC != 1) {
                    bct.rF(1);
                }
                this.fbC = 1;
            } else {
                if (this.fbC != 0) {
                    bct.rF(0);
                }
                this.fbC = 0;
            }
        }
    }

    public ObservedChangeLinearLayout bdf() {
        return this.fbo;
    }

    public View bdg() {
        return this.fbm;
    }

    public View bdh() {
        return this.fbn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdi() {
        if (this.fbm == null) {
            return 0;
        }
        return this.fbm.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdj() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdk() {
        if (this.eCx == null || com.baidu.adp.lib.util.j.kY()) {
            return 0;
        }
        return this.eCx.getHeight();
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
        View bdg = bdg();
        View bdh = bdh();
        if (UtilHelper.canUseStyleImmersiveSticky() && bdg != null && bdh != null && bdg.getLayoutParams() != null && bdh.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = bdg.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            bdg.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bdh.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bdh.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.faH = null;
        this.faZ = null;
        this.fbd = 0;
        this.faH = frsFragment;
        this.faZ = onClickListener;
        MessageManager.getInstance().registerListener(this.eHx);
        a(aVar, z);
        this.fbk = new HashSet<>();
        this.fbd = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fbx = fVar;
    }

    private boolean bdl() {
        return this.fbx != null && this.fbx.biZ();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.fbp = aVar;
        View rootView = this.faH.getRootView();
        if (this.faI == null) {
            this.faI = (NoPressedRelativeLayout) rootView.findViewById(d.g.frs);
        }
        if (this.faK == null) {
            this.faK = rootView.findViewById(d.g.frs_content_container);
        }
        if (this.faJ == null) {
            this.faJ = (CoordinatorLayout) rootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.fbb == null) {
            this.fbb = rootView.findViewById(d.g.frs_list_content);
        }
        if (this.fbt == null) {
            this.fbt = (CollapsingToolbarLayout) rootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.fbs == null) {
            this.fbs = (FrsHeaderViewContainer) rootView.findViewById(d.g.header_view_container);
        }
        if (this.fbo == null) {
            this.fbo = (ObservedChangeLinearLayout) rootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.fbo.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.6
                @Override // com.baidu.tbadk.widget.layout.e
                public void b(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fbt.setMinimumHeight(i2);
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
        if (this.faH.bcU()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.fba == null) {
            this.fba = rootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bfj = aVar.bfj();
            if (bfj != null) {
                bfj.bH(this.fba);
            }
        }
        if (this.faL == null) {
            this.faL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.faL.setOnClickListener(this.faZ);
            this.mBackImageView = (ImageView) this.faL.findViewById(d.g.widget_navi_back_button);
        }
        if (this.faM == null) {
            this.faM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.faM.setOnClickListener(this.faZ);
        }
        if (this.faN == null) {
            this.faN = new com.baidu.tieba.c.b(this.faH.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.faN.getView(), (View.OnClickListener) null);
            this.ers = this.faN.aSk();
            this.faN.getView().setOnClickListener(this.faZ);
        }
        if (this.faO == null) {
            this.faO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_private_more, (View.OnClickListener) null);
            this.faO.setVisibility(8);
            this.faO.setOnClickListener(this.faZ);
        }
        if (this.faP == null) {
            this.faP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, d.h.frs_private_status, (View.OnClickListener) null);
            this.faP.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_arrow12_white);
            int h = com.baidu.adp.lib.util.l.h(this.faH.getActivity(), d.e.tbds31);
            drawable.setBounds(0, 0, h, h);
            this.faP.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.al.g(this.faP, d.f.bg_frs_private_status_n, d.f.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.al.j(this.faP, d.C0236d.cp_btn_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.faH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), d.C0236d.cp_bg_line_b);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.faH.getPageContext());
        }
        this.mPullView.setTag(this.faH.getUniqueId());
        if (this.dcE == null) {
            this.dcE = (BdSwipeRefreshLayout) rootView.findViewById(d.g.frs_pull_refresh_layout);
            this.dcE.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.l(this.dcE, d.C0236d.cp_bg_line_c);
        }
        if (this.faU == null) {
            this.faU = (BdTypeRecyclerView) rootView.findViewById(d.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.7
            int fbI = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.fbI--;
                if (this.fbI == 0) {
                    k.this.faU.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.fbI++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.faU.setItemAnimator(defaultItemAnimator);
        this.faU.setLayoutManager(new LinearLayoutManager(this.faU.getContext()) { // from class: com.baidu.tieba.frs.k.8
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimLocalSwitchOn()) {
            this.eHw = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.eHw.a(this.faU, 2);
        }
        this.faU.setScrollable(this.faH);
        this.faU.setFadingEdgeLength(0);
        this.faU.setOverScrollMode(2);
        this.faI.setBottomOrderView(this.faU);
        this.faU.setOnTouchListener(this.faH.ccU);
        this.faU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.fbl != null) {
                    k.this.fbl.cb(view);
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
        if (this.dbr == null) {
            this.dbr = new PbListView(this.faH.getPageContext().getPageActivity());
            this.dbr.getView();
        }
        this.dbr.ib(d.C0236d.cp_bg_line_e);
        this.dbr.setHeight(com.baidu.adp.lib.util.l.h(this.faH.getActivity(), d.e.tbds182));
        this.dbr.aez();
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_d));
        this.dbr.ia(d.C0236d.cp_cont_e);
        this.faU.setOnSrollToBottomListener(this.faH);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.faH.bcO();
                if (k.this.faH != null && k.this.Sg != null) {
                    k.this.faH.bcW();
                    k.this.Sg.setExpanded(true);
                    if (k.this.fbl != null) {
                        k.this.fbl.c(k.this.fay, k.this.cZV, false, true);
                    }
                }
            }
        });
        boolean adr = com.baidu.tbadk.core.util.ar.adp().adr();
        if (this.faV == null) {
            this.faV = aVar.a(this.faH, this.faU, adr);
        }
        fB(false);
        if (!z) {
            if (this.eCx == null) {
                this.eCx = new NoNetworkView(this.faH.getActivity());
                this.eCx.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fbo.addView(this.eCx);
            }
            if (com.baidu.adp.lib.util.j.kM()) {
                this.eCx.setVisibility(8);
            } else {
                this.eCx.setVisibility(0);
            }
            this.eCx.onChangeSkinType(this.faH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bdv();
        if (this.fbf == null) {
            this.fbf = aVar.a(this.faH, this.faI);
            this.fbf.b(this.faH.bcX());
        }
        if (this.fbg == null) {
            this.fbg = aVar.b(this.faH, this.faI);
            jc(true);
        }
        if (this.fbm == null) {
            this.fbm = rootView.findViewById(d.g.statebar_view);
        }
        if (this.fbn == null) {
            this.fbn = rootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.fbl == null) {
            this.fbl = new com.baidu.tieba.play.m(this.faH.getPageContext(), this.faU);
        }
        this.fbl.setUniqueId(this.faH.getUniqueId());
        this.fbz = (NavigationBarCoverTip) rootView.findViewById(d.g.navigation_cover_tip);
        if (this.fbh == null) {
            this.fbh = new com.baidu.tieba.frs.vc.j(this.faH, this.fbz);
        }
        if (this.Sg == null) {
            this.Sg = (AppBarLayout) rootView.findViewById(d.g.frs_app_bar_layout);
            this.Sg.addOnOffsetChangedListener(this.fbD);
            this.fbu = true;
            this.fbv = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Sg.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.fbr = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.fby = (FrsMultiDelBottomMenuView) rootView.findViewById(d.g.frs_multi_delete_menu_view);
        this.fby.setPageContext(this.faH.getPageContext());
        this.faW = (FloatingAnimationView) rootView.findViewById(d.g.redpacket_view);
        this.faW.setPageId(this.faH.getUniqueId());
        this.faX = new com.baidu.tieba.c.c(this.faH.getTbPageContext(), this.faW, 2);
    }

    public void iY(boolean z) {
        if (z && this.faX != null) {
            this.faX.aSn();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        if (this.faX != null) {
            this.faX.a(nVar);
        }
    }

    private void bdm() {
        ViewGroup.LayoutParams layoutParams;
        this.dVt = bdl();
        if (this.fbs != null && (layoutParams = this.fbs.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.dVt) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds88) + bdj(), 0, 0);
            }
            this.fbs.requestLayout();
        }
    }

    public void bdn() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fbo != null) {
            bdm();
            if (this.dVt) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.fbm != null) {
                    this.fbm.setAlpha(1.0f);
                }
                if (this.fbn != null) {
                    this.fbn.setAlpha(1.0f);
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
        if (z && this.faH != null && this.faH.bcs() != null) {
            this.faH.bcs().bje();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdo() {
        int i;
        if (this.Sg == null) {
            return this.fbv;
        }
        if (this.fbv != -1) {
            return this.fbv;
        }
        int childCount = this.Sg.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Sg.getChildAt(childCount);
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
        this.fbv = Math.max(0, this.Sg.getTotalScrollRange() - Math.abs(i2));
        return this.fbv;
    }

    public void va(String str) {
        if (this.fbh != null) {
            this.fbh.va(str);
        }
    }

    public com.baidu.tieba.play.m bdp() {
        return this.fbl;
    }

    public com.baidu.tieba.frs.entelechy.b.c bdq() {
        return this.fbg;
    }

    public void ja(boolean z) {
        if (this.fbf != null) {
            this.fbf.ja(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bdr() {
        return this.fbf;
    }

    public void F(boolean z, boolean z2) {
        if (this.bhQ && this.fbg != null) {
            this.fbg.F(z, z2);
        }
    }

    public void jb(boolean z) {
        this.bhQ = z;
        if (!this.bhQ && this.fbg != null) {
            this.fbg.F(false, false);
        }
    }

    public void bds() {
        if (this.bhQ && this.fbg != null) {
            this.fbg.F(false, false);
        }
        this.faM.setVisibility(8);
        pZ(8);
        this.faO.setVisibility(8);
        ja(false);
        this.faU.setVisibility(8);
        this.fbs.setVisibility(8);
    }

    public void bdt() {
        if (this.bhQ && this.fbg != null) {
            this.fbg.F(true, false);
        }
        this.faM.setVisibility(0);
        pZ(0);
        bdu();
        ja(this.faH.bcZ());
        this.faU.setVisibility(0);
        this.fbs.setVisibility(0);
    }

    private void pZ(int i) {
        if (this.faN != null) {
            this.faN.setVisibility(i);
        }
    }

    private void bdu() {
        if (this.mIsPrivateForum) {
            this.faM.setVisibility(8);
            this.faO.setVisibility(0);
            return;
        }
        this.faM.setVisibility(0);
        this.faO.setVisibility(8);
    }

    public void jc(boolean z) {
        if (this.fbg != null) {
            this.fbg.jD(z);
        }
    }

    private void bdv() {
        if (this.fbi == null) {
            View rootView = this.faH.getRootView();
            this.fbi = (GifView) rootView.findViewById(d.g.gif_real_time);
            this.fbj = (TbImageView) rootView.findViewById(d.g.tbimg_real_time);
            this.fbj.setPageId(this.faH.getUniqueId());
            this.fbi.setLayerType(1, null);
            this.fbj.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bdw() {
        return this.faL;
    }

    public void h(NoNetworkView.a aVar) {
        this.eWE = aVar;
        if (this.eCx != null) {
            this.eCx.a(this.eWE);
        }
    }

    public void fB(boolean z) {
        this.faG = z;
        if (z) {
            if (this.fbg != null) {
                this.fbg.bfM();
                return;
            }
            return;
        }
        this.faU.getAdapter().notifyDataSetChanged();
        if (this.fbg != null) {
            this.fbg.bfN();
        }
    }

    public void jd(boolean z) {
        if (this.fbg != null) {
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
        this.faU.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(s sVar) {
        this.faV.setOnAdapterItemClickListener(sVar);
    }

    public void setForumName(String str) {
        this.faV.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eHx);
        if (this.fbl != null) {
            this.fbl.destroy();
        }
        if (this.fbh != null) {
            this.fbh.onDestory();
        }
        if (this.fby != null) {
            this.fby.setPageContext(null);
        }
        this.faV.onDestory();
        this.faU.setOnSrollToBottomListener(null);
        this.faU.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.fbE);
        if (this.eGP != null) {
            this.eGP.onDestroy();
        }
        this.fbk.clear();
        if (this.fbf != null) {
            this.fbf.biQ();
        }
        if (this.fbq != null) {
            this.fbq.beZ();
        }
        if (this.faX != null) {
            this.faX.onDestroy();
        }
        if (this.fbz != null) {
            this.fbz.onDestroy();
        }
        if (this.fby != null) {
            this.fby.onDestroy();
        }
    }

    public boolean bdx() {
        if (this.Sg == null || this.fbr == null || !this.fbr.isSticky()) {
            return this.fbf != null && this.fbf.bdx();
        }
        if (this.faU != null) {
            this.faU.setSelection(0);
        }
        this.fbr.expandedAppBarLayout(this.Sg);
        return true;
    }

    public boolean bcT() {
        return this.faG;
    }

    public void aOB() {
        this.faU.setVisibility(0);
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

    public void bdy() {
        if (this.faV != null) {
            this.faV.notifyDataSetChanged();
        }
    }

    public void Ru() {
        if (this.faV instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.faV).Ru();
        }
    }

    private void bdz() {
        if (this.faY == null && this.faH.getPageContext() != null) {
            String[] strArr = {this.faH.getPageContext().getPageActivity().getString(d.j.take_photo), this.faH.getPageContext().getPageActivity().getString(d.j.album)};
            this.faY = new com.baidu.tbadk.core.dialog.b(this.faH.getPageContext().getPageActivity());
            this.faY.lz(this.faH.getPageContext().getPageActivity().getString(d.j.operation));
            this.faY.a(strArr, new b.InterfaceC0191b() { // from class: com.baidu.tieba.frs.k.11
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.faH.takePhoto();
                    } else if (i == 1 && k.this.faH.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.U(k.this.faH.getPageContext().getPageActivity());
                    }
                }
            });
            this.faY.d(this.faH.getPageContext());
        }
    }

    public void bdA() {
        bdz();
        if (this.faY != null) {
            this.faY.abc();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.T(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            new ArrayList().add(mVar);
            if (this.faH != null && this.faH.bcq() != null && this.faH.bcq().bhJ() == 0) {
                mVar.qi(this.faH.bcq().bhQ());
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
        this.faV.b(switchThreadDataToThreadCardInfo, frsViewData);
        if (this.fbl != null && this.fay != 0) {
            this.fbl.c(this.fay, this.cZV, this.fbe, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.faU;
    }

    public void bdB() {
        this.faV.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.faH.getPageContext(), 1);
        aVar.a(this.faU);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.faH.getForumName());
        hashMap.put("forum_id", this.faH.getForumId());
        aVar.setParams(hashMap);
        aVar.ak(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.fbf != null) {
            this.fbf.biR();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        qa(TbadkCoreApplication.getInst().getSkinType());
        if (this.fbf != null) {
            this.fbf.biS();
        }
    }

    public void release() {
        if (this.eCx != null && this.eWE != null) {
            this.eCx.b(this.eWE);
        }
    }

    public ImageView bdC() {
        return this.faM;
    }

    public ImageView bdD() {
        return this.faO;
    }

    public TextView bdE() {
        return this.faP;
    }

    public View bdF() {
        if (this.faN != null) {
            return this.faN.getView();
        }
        return null;
    }

    public void w(int i, boolean z) {
        if (this.faN != null) {
            this.faN.l(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.faH, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.faH.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.fbj != null) {
            this.fbj.invalidate();
        }
        if (this.faV != null) {
            this.faV.bfG();
            this.faV.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.faH.getPageContext(), this.faI);
        if (this.eCx != null) {
            this.eCx.onChangeSkinType(this.faH.getPageContext(), i);
        }
        if (this.dbr != null) {
            this.dbr.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0236d.cp_cont_d));
            this.dbr.ic(i);
        }
        qa(i);
        if (this.fbg != null) {
            this.fbg.onChangeSkinType(i);
        }
        if (this.fbf != null) {
            this.fbf.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.fby != null) {
            this.fby.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.l(this.dcE, d.C0236d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.l(this.faK, d.C0236d.cp_bg_line_d);
    }

    private void qa(int i) {
        if (this.faH != null) {
            qb(i);
        }
    }

    private void qb(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.faH.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBarBgView(), d.C0236d.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), d.C0236d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.f(this.fba, d.C0236d.cp_bg_line_b, i);
        }
        com.baidu.tbadk.core.util.al.l(this.fbm, d.C0236d.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.l(this.fbn, d.C0236d.cp_bg_line_d);
        je(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dVt) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.fbB != 0) {
                    com.baidu.tbadk.core.util.al.c(this.mBackImageView, d.f.icon_topbar_return_white_n, d.f.icon_topbar_return_white_s);
                    com.baidu.tbadk.core.util.al.c(this.faM, d.f.icon_common_search_white_n, d.f.icon_common_search_white_s);
                    com.baidu.tbadk.core.util.al.c(this.faO, d.f.icon_topbar_more_white_n, d.f.icon_topbar_more_white_s);
                    com.baidu.tbadk.core.util.al.c(this.ers, d.f.icon_common_news_white_n, d.f.icon_common_news_white_s);
                    this.fbB = 0;
                }
            } else if (z || this.fbB != 1) {
                com.baidu.tbadk.core.util.al.c(this.mBackImageView, d.f.icon_topbar_return_n, d.f.icon_topbar_return_s);
                com.baidu.tbadk.core.util.al.c(this.faM, d.f.icon_common_search_n, d.f.icon_common_search_s);
                com.baidu.tbadk.core.util.al.c(this.faO, d.f.icon_topbar_more_n, d.f.icon_topbar_more_s);
                com.baidu.tbadk.core.util.al.c(this.ers, d.f.icon_common_news_n, d.f.icon_common_news_s);
                this.fbB = 1;
            }
            bdG();
        }
    }

    private void bdG() {
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
                if (this.faM != null) {
                    this.faM.setAlpha(f);
                }
                if (this.ers != null) {
                    this.ers.setAlpha(f);
                }
                if (this.faO != null) {
                    this.faO.setAlpha(f);
                }
            }
            if (this.faP != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.faP.setAlpha(f2);
                this.faP.setClickable(f2 > 0.0f);
            }
            if (this.fbm != null) {
                this.fbm.setAlpha(alpha);
            }
            if (this.fbn != null) {
                this.fbn.setAlpha(alpha);
            }
            if (this.fba != null) {
                this.fba.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.faU != null) {
            this.faU.setSelection(0);
        }
        if (this.Sg != null) {
            this.Sg.setExpanded(true);
        }
        if (this.dcE != null && this.dcE.isEnabled()) {
            this.dcE.setRefreshing(true);
        }
    }

    public void jf(boolean z) {
        if (z) {
            this.dcE.setRefreshing(false);
        } else {
            this.dcE.pE();
        }
    }

    public void jg(boolean z) {
        this.dcE.setEnabled(z);
    }

    public void jh(boolean z) {
        this.fbc = z;
        if (this.fbc) {
            this.dbr.setText(this.faH.getResources().getString(d.j.load_more));
            if (this.faU.getChildAt(this.faU.getChildCount() - 1) == this.dbr.getView()) {
                this.dbr.aeC();
                this.faH.aBd();
                return;
            }
            this.dbr.aeD();
            return;
        }
        this.dbr.setText(this.faH.getResources().getString(d.j.load_more_must_after_delete));
        this.dbr.aeD();
    }

    public boolean bdH() {
        if (this.fbc) {
            return false;
        }
        this.dbr.setText(this.faH.getResources().getString(d.j.load_more_must_after_delete));
        this.dbr.aeD();
        return true;
    }

    public boolean bdI() {
        return this.faQ != null && this.faT.getVisibility() == 0;
    }

    public void bdJ() {
        if (this.faQ != null) {
            this.faR.setVisibility(0);
            this.faT.setVisibility(8);
            this.faS.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.fbE, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bn bnVar) {
        if (this.faQ == null) {
            View rootView = this.faH.getRootView();
            this.faQ = (ViewStub) rootView.findViewById(d.g.yule_game_egg_view_stub);
            this.faQ.setVisibility(0);
            this.faR = (FrameLayout) rootView.findViewById(d.g.game_activity_egg_layout);
            this.faS = (TbImageView) rootView.findViewById(d.g.game_activity_egg);
            this.faT = (TbImageView) rootView.findViewById(d.g.game_activity_egg_s);
            this.faS.setPageId(this.faH.getUniqueId());
            this.faT.setPageId(this.faH.getUniqueId());
            this.faS.setDefaultBgResource(d.C0236d.common_color_10022);
            this.faS.setDefaultResource(0);
            this.faT.setDefaultBgResource(d.C0236d.common_color_10022);
            this.faT.setDefaultResource(0);
            this.faR.setOnClickListener(this.faZ);
        }
        this.faR.setVisibility(0);
        String aaQ = bnVar.aaQ();
        String aaR = bnVar.aaR();
        this.faS.startLoad(aaQ, 10, false);
        this.faT.startLoad(aaR, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.fbE, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void bdK() {
        if (this.faQ != null && this.faR != null) {
            this.faR.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.z bdL() {
        return this.faV;
    }

    public RelativeLayout bdM() {
        return this.faI;
    }

    public View bdN() {
        return this.fbb;
    }

    public void qc(int i) {
        if (this.faK != null) {
            this.faK.setVisibility(i);
        }
    }

    public void bdO() {
        if (com.baidu.tbadk.o.m.apl().apm()) {
            int lastVisiblePosition = this.faU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faU.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fbT != null) {
                        com.baidu.tbadk.o.h perfLog = oVar.fbT.getPerfLog();
                        perfLog.jX(1000);
                        perfLog.cqm = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fbT.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fbT.startLogPerf();
                    }
                    if (oVar.fbS != null && (oVar.fbS instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fbS;
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

    public NavigationBar aDq() {
        return this.mNavigationBar;
    }

    public void aCv() {
        this.mHasMore = true;
        this.faU.setNextPage(this.dbr);
        if (this.fbd > 0) {
            this.dbr.id(this.fbd);
        }
        this.dbr.setOnClickListener(null);
        this.dbr.aeC();
    }

    public void aCw() {
        this.mHasMore = false;
        this.faU.setNextPage(this.dbr);
        if (this.fbd > 0) {
            this.dbr.id(this.fbd);
        }
        this.dbr.setOnClickListener(null);
        this.dbr.aeD();
        this.dbr.setText(this.faH.getResources().getString(d.j.list_has_no_more));
    }

    public void bdP() {
        this.mHasMore = true;
        this.faU.setNextPage(this.dbr);
        this.dbr.setOnClickListener(this.faZ);
        if (this.fbd > 0) {
            this.dbr.id(this.fbd);
        }
        this.dbr.aeD();
        this.dbr.setText(this.faH.getResources().getString(d.j.list_click_load_more));
    }

    public View bdQ() {
        if (this.dbr == null) {
            return null;
        }
        return this.dbr.getView();
    }

    public void qd(int i) {
        if (this.fby != null) {
            this.fby.setVisibility(i);
        }
    }

    public void qe(int i) {
        if (this.fby != null) {
            this.fby.setSelectNumber(i);
        }
    }

    public void aCx() {
        this.mHasMore = false;
        this.faU.setNextPage(null);
    }

    public boolean aRE() {
        return this.dbr.getView().getParent() != null && this.mHasMore;
    }

    public void qf(int i) {
        this.fbd = i;
    }

    public void qg(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.eGP == null) {
                    this.eGP = new CommonTipView(this.faH.getActivity());
                }
                this.eGP.setText(d.j.frs_login_tip);
                this.eGP.show((FrameLayout) bdN(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void ji(boolean z) {
        if (this.fbl != null) {
            boolean z2 = (this.faH == null || this.faH.bct() == null || this.faH.bct().bjv() == null) ? true : this.faH.bct().bjv().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.fbl.md(false);
                this.fbl.bAV();
                return;
            }
            this.fbl.md(true);
            this.fbl.c(this.fay, this.cZV, this.fbe, true);
        }
    }

    public void bg(int i, int i2) {
        if (this.fbl != null) {
            this.fbl.a(i, i2, this.fbe, 1);
        }
    }

    public void bh(int i, int i2) {
        this.fay = i;
        this.cZV = i2;
    }

    public void jj(boolean z) {
        this.fbe = z;
    }

    public void qh(int i) {
        if (this.faU != null && this.faU.getChildCount() >= 0) {
            if (this.faU.getFirstVisiblePosition() > 8) {
                this.faU.scrollToPosition(8);
            }
            this.faU.smoothScrollToPosition(i);
        }
    }

    public void bdR() {
        a(this.fbp, this.faH.bcU());
        if (this.faV != null) {
            this.faV.bfD();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.fbq == null) {
                this.fbq = new com.baidu.tieba.video.f(this.faH.getActivity(), this.faI);
            }
            this.fbq.h(postWriteCallBackData);
        }
    }

    public void bdS() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.fbF && this.faH.getActivity() != null && this.faH.getPageContext() != null) {
            View view = null;
            if (this.faU != null && (headerViewsCount = this.faU.getHeaderViewsCount()) < this.faU.getChildCount()) {
                view = this.faU.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).af(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.faH.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.h(k.this.faH.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.faH.getActivity(), d.e.ds6);
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
                iT.n(this.faH.getActivity());
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iT != null) {
                            iT.dismiss();
                        }
                    }
                }, 4000L);
                this.fbF = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.fby != null) {
            this.fby.setDeleteCallback(aVar);
        }
    }

    public void bdT() {
        if (this.fby != null) {
            this.fby.bdT();
        }
    }

    public void auV() {
        if (this.fby != null) {
            this.fby.auV();
        }
    }

    public void ax(String str, int i) {
        if (this.fbA == null) {
            this.fbA = new TextView(this.faH.getActivity());
            this.fbA.setGravity(19);
            this.fbA.setPadding(com.baidu.adp.lib.util.l.h(this.faH.getActivity(), d.e.ds34), 0, com.baidu.adp.lib.util.l.h(this.faH.getActivity(), d.e.ds34), 0);
            this.fbA.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.faH.getActivity(), d.e.tbds112)));
            this.fbA.setTextSize(0, com.baidu.adp.lib.util.l.h(this.faH.getActivity(), d.e.fontsize30));
            this.fbA.setMaxLines(2);
            this.fbA.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.fbA.setTextColor(ContextCompat.getColor(this.faH.getActivity(), d.C0236d.cp_btn_a));
        }
        this.fbz.setBackgroundColor(i);
        this.fbA.setText(str);
        this.fbz.a(this.faH.getActivity(), this.fbA, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Sg != null) {
            this.Sg.setExpanded(z);
        }
    }

    public void bdU() {
        if (this.Sg != null && this.faU != null) {
            int count = this.faU.getCount();
            if (this.faU.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.Sg.setExpanded(true, true);
            }
        }
    }

    public void bdV() {
        if (this.mPullView != null) {
            this.mPullView.aeM();
        }
        startPullRefresh();
    }
}
