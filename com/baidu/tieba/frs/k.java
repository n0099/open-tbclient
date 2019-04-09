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
    private AppBarLayout Si;
    private PbListView dbs;
    private BdSwipeRefreshLayout dcF;
    private NoNetworkView eCf;
    private CommonTipView eGy;
    private com.baidu.adp.widget.ListView.k eHf;
    private ImageView era;
    private ImageView faA;
    private TextView faB;
    private ViewStub faC;
    private BdTypeRecyclerView faG;
    private com.baidu.tieba.frs.entelechy.a.z faH;
    private FloatingAnimationView faI;
    private com.baidu.tieba.c.c faJ;
    private View.OnClickListener faL;
    private View faM;
    private View faN;
    private int faP;
    private com.baidu.tieba.frs.vc.d faR;
    private com.baidu.tieba.frs.entelechy.b.c faS;
    private com.baidu.tieba.frs.vc.j faT;
    private GifView faU;
    private TbImageView faV;
    private HashSet<String> faW;
    private com.baidu.tieba.play.m faX;
    private FrsFragment fat;
    private View fax;
    private ImageView fay;
    private com.baidu.tieba.c.b faz;
    private ObservedChangeLinearLayout fba;
    private com.baidu.tieba.frs.entelechy.b.a fbb;
    private com.baidu.tieba.video.f fbc;
    private AppBarLayoutStickyBehavior fbd;
    private FrsHeaderViewContainer fbe;
    private CollapsingToolbarLayout fbf;
    private com.baidu.tieba.frs.vc.f fbj;
    private FrsMultiDelBottomMenuView fbk;
    private NavigationBarCoverTip fbl;
    private TextView fbm;
    private boolean fbr;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean fas = false;
    private NoPressedRelativeLayout fau = null;
    private CoordinatorLayout fav = null;
    private View faw = null;
    private FrameLayout faD = null;
    private TbImageView faE = null;
    private TbImageView faF = null;
    private com.baidu.tbadk.core.dialog.b faK = null;
    private NoNetworkView.a eWq = null;
    private boolean faO = true;
    private boolean mHasMore = true;
    private boolean faQ = false;
    private int fak = 0;
    private int cZV = 0;
    private View faY = null;
    private View faZ = null;
    private boolean dUM = false;
    private boolean bhV = true;
    private boolean fbg = true;
    private int fbh = -1;
    private int fbi = -1;
    private int fbn = 0;
    private int fbo = 0;
    private boolean mIsPrivateForum = false;
    private CustomMessageListener eHg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.eHf == null) {
                        k.this.eHf = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.eHf.a(k.this.faG, 2);
                } else if (k.this.eHf != null) {
                    k.this.eHf.pg();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fbp = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.5
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fbi != i && Math.abs(i) >= 0 && k.this.bdl() != -1) {
                if (Math.abs(i) >= k.this.bdl()) {
                    if (k.this.fbg) {
                        k.this.fbg = false;
                        k.this.iZ(k.this.fbg);
                    }
                } else if (!k.this.fbg) {
                    k.this.fbg = true;
                    k.this.iZ(k.this.fbg);
                }
                int bdh = k.this.bdh() + k.this.bdg() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bdh;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fbi - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.pU(Math.abs(bdh - totalScrollRange2));
                        if (k.this.faZ != null) {
                            k.this.faZ.setVisibility(0);
                        }
                    } else if (k.this.faZ != null) {
                        if (k.this.bdf() != UtilHelper.getStatusBarHeight()) {
                            k.this.pU(0);
                        }
                        k.this.faZ.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.dUM) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.je(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fbi = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable fbq = new Runnable() { // from class: com.baidu.tieba.frs.k.12
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.faC != null) {
                k.this.faD.setVisibility(0);
                k.this.faF.setVisibility(0);
                k.this.faE.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        if (this.fat != null && appBarLayout != null && this.fat.bcq() != null && this.fat.getPageContext() != null) {
            int bdg = bdg() + getNavigationBarHeight() + bdh();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bcq = this.fat.bcq();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fat.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.fat.getPageContext().getPageActivity());
            }
            if (totalScrollRange <= 0) {
                if (this.fbo != 2) {
                    bcq.rB(2);
                }
                this.fbo = 2;
            } else if (totalScrollRange > 0 && totalScrollRange <= bdg) {
                if (this.fbo != 1) {
                    bcq.rB(1);
                }
                this.fbo = 1;
            } else {
                if (this.fbo != 0) {
                    bcq.rB(0);
                }
                this.fbo = 0;
            }
        }
    }

    public ObservedChangeLinearLayout bdc() {
        return this.fba;
    }

    public View bdd() {
        return this.faY;
    }

    public View bde() {
        return this.faZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdf() {
        if (this.faY == null) {
            return 0;
        }
        return this.faY.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdg() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdh() {
        if (this.eCf == null || com.baidu.adp.lib.util.j.kY()) {
            return 0;
        }
        return this.eCf.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU(int i) {
        View bdd = bdd();
        View bde = bde();
        if (UtilHelper.canUseStyleImmersiveSticky() && bdd != null && bde != null && bdd.getLayoutParams() != null && bde.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = bdd.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            bdd.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bde.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bde.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.fat = null;
        this.faL = null;
        this.faP = 0;
        this.fat = frsFragment;
        this.faL = onClickListener;
        MessageManager.getInstance().registerListener(this.eHg);
        a(aVar, z);
        this.faW = new HashSet<>();
        this.faP = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fbj = fVar;
    }

    private boolean bdi() {
        return this.fbj != null && this.fbj.biW();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.fbb = aVar;
        View rootView = this.fat.getRootView();
        if (this.fau == null) {
            this.fau = (NoPressedRelativeLayout) rootView.findViewById(d.g.frs);
        }
        if (this.faw == null) {
            this.faw = rootView.findViewById(d.g.frs_content_container);
        }
        if (this.fav == null) {
            this.fav = (CoordinatorLayout) rootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.faN == null) {
            this.faN = rootView.findViewById(d.g.frs_list_content);
        }
        if (this.fbf == null) {
            this.fbf = (CollapsingToolbarLayout) rootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.fbe == null) {
            this.fbe = (FrsHeaderViewContainer) rootView.findViewById(d.g.header_view_container);
        }
        if (this.fba == null) {
            this.fba = (ObservedChangeLinearLayout) rootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.fba.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.6
                @Override // com.baidu.tbadk.widget.layout.e
                public void b(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fbf.setMinimumHeight(i2);
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
        if (this.fat.bcR()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.faM == null) {
            this.faM = rootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bfg = aVar.bfg();
            if (bfg != null) {
                bfg.bH(this.faM);
            }
        }
        if (this.fax == null) {
            this.fax = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fax.setOnClickListener(this.faL);
            this.mBackImageView = (ImageView) this.fax.findViewById(d.g.widget_navi_back_button);
        }
        if (this.fay == null) {
            this.fay = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.fay.setOnClickListener(this.faL);
        }
        if (this.faz == null) {
            this.faz = new com.baidu.tieba.c.b(this.fat.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.faz.getView(), (View.OnClickListener) null);
            this.era = this.faz.aSh();
            this.faz.getView().setOnClickListener(this.faL);
        }
        if (this.faA == null) {
            this.faA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_private_more, (View.OnClickListener) null);
            this.faA.setVisibility(8);
            this.faA.setOnClickListener(this.faL);
        }
        if (this.faB == null) {
            this.faB = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, d.h.frs_private_status, (View.OnClickListener) null);
            this.faB.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(d.f.icon_arrow12_white);
            int h = com.baidu.adp.lib.util.l.h(this.fat.getActivity(), d.e.tbds31);
            drawable.setBounds(0, 0, h, h);
            this.faB.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.al.g(this.faB, d.f.bg_frs_private_status_n, d.f.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.al.j(this.faB, d.C0277d.cp_btn_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.fat.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), d.C0277d.cp_bg_line_b);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.fat.getPageContext());
        }
        this.mPullView.setTag(this.fat.getUniqueId());
        if (this.dcF == null) {
            this.dcF = (BdSwipeRefreshLayout) rootView.findViewById(d.g.frs_pull_refresh_layout);
            this.dcF.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.l(this.dcF, d.C0277d.cp_bg_line_c);
        }
        if (this.faG == null) {
            this.faG = (BdTypeRecyclerView) rootView.findViewById(d.g.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.7
            int fbu = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.fbu--;
                if (this.fbu == 0) {
                    k.this.faG.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.fbu++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.faG.setItemAnimator(defaultItemAnimator);
        this.faG.setLayoutManager(new LinearLayoutManager(this.faG.getContext()) { // from class: com.baidu.tieba.frs.k.8
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eHf = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.eHf.a(this.faG, 2);
        }
        this.faG.setScrollable(this.fat);
        this.faG.setFadingEdgeLength(0);
        this.faG.setOverScrollMode(2);
        this.fau.setBottomOrderView(this.faG);
        this.faG.setOnTouchListener(this.fat.ccX);
        this.faG.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.faX != null) {
                    k.this.faX.cb(view);
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
        if (this.dbs == null) {
            this.dbs = new PbListView(this.fat.getPageContext().getPageActivity());
            this.dbs.getView();
        }
        this.dbs.ia(d.C0277d.cp_bg_line_e);
        this.dbs.setHeight(com.baidu.adp.lib.util.l.h(this.fat.getActivity(), d.e.tbds182));
        this.dbs.aew();
        this.dbs.setTextSize(d.e.tbfontsize33);
        this.dbs.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_d));
        this.dbs.hZ(d.C0277d.cp_cont_e);
        this.faG.setOnSrollToBottomListener(this.fat);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.fat.bcL();
                if (k.this.fat != null && k.this.Si != null) {
                    k.this.fat.bcT();
                    k.this.Si.setExpanded(true);
                    if (k.this.faX != null) {
                        k.this.faX.c(k.this.fak, k.this.cZV, false, true);
                    }
                }
            }
        });
        boolean ado = com.baidu.tbadk.core.util.ar.adm().ado();
        if (this.faH == null) {
            this.faH = aVar.a(this.fat, this.faG, ado);
        }
        fB(false);
        if (!z) {
            if (this.eCf == null) {
                this.eCf = new NoNetworkView(this.fat.getActivity());
                this.eCf.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fba.addView(this.eCf);
            }
            if (com.baidu.adp.lib.util.j.kM()) {
                this.eCf.setVisibility(8);
            } else {
                this.eCf.setVisibility(0);
            }
            this.eCf.onChangeSkinType(this.fat.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bds();
        if (this.faR == null) {
            this.faR = aVar.a(this.fat, this.fau);
            this.faR.b(this.fat.bcU());
        }
        if (this.faS == null) {
            this.faS = aVar.b(this.fat, this.fau);
            jc(true);
        }
        if (this.faY == null) {
            this.faY = rootView.findViewById(d.g.statebar_view);
        }
        if (this.faZ == null) {
            this.faZ = rootView.findViewById(d.g.statebar_view_holder);
        }
        if (this.faX == null) {
            this.faX = new com.baidu.tieba.play.m(this.fat.getPageContext(), this.faG);
        }
        this.faX.setUniqueId(this.fat.getUniqueId());
        this.fbl = (NavigationBarCoverTip) rootView.findViewById(d.g.navigation_cover_tip);
        if (this.faT == null) {
            this.faT = new com.baidu.tieba.frs.vc.j(this.fat, this.fbl);
        }
        if (this.Si == null) {
            this.Si = (AppBarLayout) rootView.findViewById(d.g.frs_app_bar_layout);
            this.Si.addOnOffsetChangedListener(this.fbp);
            this.fbg = true;
            this.fbh = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Si.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.fbd = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.fbk = (FrsMultiDelBottomMenuView) rootView.findViewById(d.g.frs_multi_delete_menu_view);
        this.fbk.setPageContext(this.fat.getPageContext());
        this.faI = (FloatingAnimationView) rootView.findViewById(d.g.redpacket_view);
        this.faI.setPageId(this.fat.getUniqueId());
        this.faJ = new com.baidu.tieba.c.c(this.fat.getTbPageContext(), this.faI, 2);
    }

    public void iY(boolean z) {
        if (z && this.faJ != null) {
            this.faJ.aSk();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.n nVar) {
        if (this.faJ != null) {
            this.faJ.a(nVar);
        }
    }

    private void bdj() {
        ViewGroup.LayoutParams layoutParams;
        this.dUM = bdi();
        if (this.fbe != null && (layoutParams = this.fbe.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.dUM) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds88) + bdg(), 0, 0);
            }
            this.fbe.requestLayout();
        }
    }

    public void bdk() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fba != null) {
            bdj();
            if (this.dUM) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.faY != null) {
                    this.faY.setAlpha(1.0f);
                }
                if (this.faZ != null) {
                    this.faZ.setAlpha(1.0f);
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
        if (z && this.fat != null && this.fat.bcp() != null) {
            this.fat.bcp().bjb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bdl() {
        int i;
        if (this.Si == null) {
            return this.fbh;
        }
        if (this.fbh != -1) {
            return this.fbh;
        }
        int childCount = this.Si.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Si.getChildAt(childCount);
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
        this.fbh = Math.max(0, this.Si.getTotalScrollRange() - Math.abs(i2));
        return this.fbh;
    }

    public void uX(String str) {
        if (this.faT != null) {
            this.faT.uX(str);
        }
    }

    public com.baidu.tieba.play.m bdm() {
        return this.faX;
    }

    public com.baidu.tieba.frs.entelechy.b.c bdn() {
        return this.faS;
    }

    public void ja(boolean z) {
        if (this.faR != null) {
            this.faR.ja(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bdo() {
        return this.faR;
    }

    public void D(boolean z, boolean z2) {
        if (this.bhV && this.faS != null) {
            this.faS.D(z, z2);
        }
    }

    public void jb(boolean z) {
        this.bhV = z;
        if (!this.bhV && this.faS != null) {
            this.faS.D(false, false);
        }
    }

    public void bdp() {
        if (this.bhV && this.faS != null) {
            this.faS.D(false, false);
        }
        this.fay.setVisibility(8);
        pV(8);
        this.faA.setVisibility(8);
        ja(false);
        this.faG.setVisibility(8);
        this.fbe.setVisibility(8);
    }

    public void bdq() {
        if (this.bhV && this.faS != null) {
            this.faS.D(true, false);
        }
        this.fay.setVisibility(0);
        pV(0);
        bdr();
        ja(this.fat.bcW());
        this.faG.setVisibility(0);
        this.fbe.setVisibility(0);
    }

    private void pV(int i) {
        if (this.faz != null) {
            this.faz.setVisibility(i);
        }
    }

    private void bdr() {
        if (this.mIsPrivateForum) {
            this.fay.setVisibility(8);
            this.faA.setVisibility(0);
            return;
        }
        this.fay.setVisibility(0);
        this.faA.setVisibility(8);
    }

    public void jc(boolean z) {
        if (this.faS != null) {
            this.faS.jD(z);
        }
    }

    private void bds() {
        if (this.faU == null) {
            View rootView = this.fat.getRootView();
            this.faU = (GifView) rootView.findViewById(d.g.gif_real_time);
            this.faV = (TbImageView) rootView.findViewById(d.g.tbimg_real_time);
            this.faV.setPageId(this.fat.getUniqueId());
            this.faU.setLayerType(1, null);
            this.faV.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bdt() {
        return this.fax;
    }

    public void h(NoNetworkView.a aVar) {
        this.eWq = aVar;
        if (this.eCf != null) {
            this.eCf.a(this.eWq);
        }
    }

    public void fB(boolean z) {
        this.fas = z;
        if (z) {
            if (this.faS != null) {
                this.faS.bfJ();
                return;
            }
            return;
        }
        this.faG.getAdapter().notifyDataSetChanged();
        if (this.faS != null) {
            this.faS.bfK();
        }
    }

    public void jd(boolean z) {
        if (this.faS != null) {
            if (z) {
                D(false, true);
            } else {
                D(false, false);
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
        this.faG.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        this.faH.setOnAdapterItemClickListener(sVar);
    }

    public void setForumName(String str) {
        this.faH.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eHg);
        if (this.faX != null) {
            this.faX.destroy();
        }
        if (this.faT != null) {
            this.faT.onDestory();
        }
        if (this.fbk != null) {
            this.fbk.setPageContext(null);
        }
        this.faH.onDestory();
        this.faG.setOnSrollToBottomListener(null);
        this.faG.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.fbq);
        if (this.eGy != null) {
            this.eGy.onDestroy();
        }
        this.faW.clear();
        if (this.faR != null) {
            this.faR.biN();
        }
        if (this.fbc != null) {
            this.fbc.beW();
        }
        if (this.faJ != null) {
            this.faJ.onDestroy();
        }
        if (this.fbl != null) {
            this.fbl.onDestroy();
        }
        if (this.fbk != null) {
            this.fbk.onDestroy();
        }
    }

    public boolean bdu() {
        if (this.Si == null || this.fbd == null || !this.fbd.isSticky()) {
            return this.faR != null && this.faR.bdu();
        }
        if (this.faG != null) {
            this.faG.setSelection(0);
        }
        this.fbd.expandedAppBarLayout(this.Si);
        return true;
    }

    public boolean bcQ() {
        return this.fas;
    }

    public void aOs() {
        this.faG.setVisibility(0);
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
            com.baidu.tbadk.core.i.Wv().kU(str);
        }
    }

    public void bdv() {
        if (this.faH != null) {
            this.faH.notifyDataSetChanged();
        }
    }

    public void Rs() {
        if (this.faH instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.faH).Rs();
        }
    }

    private void bdw() {
        if (this.faK == null && this.fat.getPageContext() != null) {
            String[] strArr = {this.fat.getPageContext().getPageActivity().getString(d.j.take_photo), this.fat.getPageContext().getPageActivity().getString(d.j.album)};
            this.faK = new com.baidu.tbadk.core.dialog.b(this.fat.getPageContext().getPageActivity());
            this.faK.lA(this.fat.getPageContext().getPageActivity().getString(d.j.operation));
            this.faK.a(strArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.frs.k.11
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.fat.takePhoto();
                    } else if (i == 1 && k.this.fat.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.U(k.this.fat.getPageContext().getPageActivity());
                    }
                }
            });
            this.faK.d(this.fat.getPageContext());
        }
    }

    public void bdx() {
        bdw();
        if (this.faK != null) {
            this.faK.aaZ();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.T(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            new ArrayList().add(mVar);
            if (this.fat != null && this.fat.bcn() != null && this.fat.bcn().bhG() == 0) {
                mVar.qe(this.fat.bcn().bhN());
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
        this.faH.b(switchThreadDataToThreadCardInfo, frsViewData);
        if (this.faX != null && this.fak != 0) {
            this.faX.c(this.fak, this.cZV, this.faQ, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.faG;
    }

    public void bdy() {
        this.faH.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fat.getPageContext(), 1);
        aVar.a(this.faG);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.fat.getForumName());
        hashMap.put("forum_id", this.fat.getForumId());
        aVar.setParams(hashMap);
        aVar.ai(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.faR != null) {
            this.faR.biO();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        pW(TbadkCoreApplication.getInst().getSkinType());
        if (this.faR != null) {
            this.faR.biP();
        }
    }

    public void release() {
        if (this.eCf != null && this.eWq != null) {
            this.eCf.b(this.eWq);
        }
    }

    public ImageView bdz() {
        return this.fay;
    }

    public ImageView bdA() {
        return this.faA;
    }

    public TextView bdB() {
        return this.faB;
    }

    public View bdC() {
        if (this.faz != null) {
            return this.faz.getView();
        }
        return null;
    }

    public void w(int i, boolean z) {
        if (this.faz != null) {
            this.faz.l(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fat, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fat.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.faV != null) {
            this.faV.invalidate();
        }
        if (this.faH != null) {
            this.faH.bfD();
            this.faH.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.fat.getPageContext(), this.fau);
        if (this.eCf != null) {
            this.eCf.onChangeSkinType(this.fat.getPageContext(), i);
        }
        if (this.dbs != null) {
            this.dbs.setTextColor(com.baidu.tbadk.core.util.al.getColor(d.C0277d.cp_cont_d));
            this.dbs.ib(i);
        }
        pW(i);
        if (this.faS != null) {
            this.faS.onChangeSkinType(i);
        }
        if (this.faR != null) {
            this.faR.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.fbk != null) {
            this.fbk.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.l(this.dcF, d.C0277d.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.l(this.faw, d.C0277d.cp_bg_line_d);
    }

    private void pW(int i) {
        if (this.fat != null) {
            pX(i);
        }
    }

    private void pX(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fat.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), d.C0277d.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.f(this.faM, d.C0277d.cp_bg_line_b, i);
        }
        com.baidu.tbadk.core.util.al.l(this.faY, d.C0277d.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.l(this.faZ, d.C0277d.cp_bg_line_d);
        je(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dUM) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.fbn != 0) {
                    com.baidu.tbadk.core.util.al.c(this.mBackImageView, d.f.icon_topbar_return_white_n, d.f.icon_topbar_return_white_s);
                    com.baidu.tbadk.core.util.al.c(this.fay, d.f.icon_common_search_white_n, d.f.icon_common_search_white_s);
                    com.baidu.tbadk.core.util.al.c(this.faA, d.f.icon_topbar_more_white_n, d.f.icon_topbar_more_white_s);
                    com.baidu.tbadk.core.util.al.c(this.era, d.f.icon_common_news_white_n, d.f.icon_common_news_white_s);
                    this.fbn = 0;
                }
            } else if (z || this.fbn != 1) {
                com.baidu.tbadk.core.util.al.c(this.mBackImageView, d.f.icon_topbar_return_n, d.f.icon_topbar_return_s);
                com.baidu.tbadk.core.util.al.c(this.fay, d.f.icon_common_search_n, d.f.icon_common_search_s);
                com.baidu.tbadk.core.util.al.c(this.faA, d.f.icon_topbar_more_n, d.f.icon_topbar_more_s);
                com.baidu.tbadk.core.util.al.c(this.era, d.f.icon_common_news_n, d.f.icon_common_news_s);
                this.fbn = 1;
            }
            bdD();
        }
    }

    private void bdD() {
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
                if (this.fay != null) {
                    this.fay.setAlpha(f);
                }
                if (this.era != null) {
                    this.era.setAlpha(f);
                }
                if (this.faA != null) {
                    this.faA.setAlpha(f);
                }
            }
            if (this.faB != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.faB.setAlpha(f2);
                this.faB.setClickable(f2 > 0.0f);
            }
            if (this.faY != null) {
                this.faY.setAlpha(alpha);
            }
            if (this.faZ != null) {
                this.faZ.setAlpha(alpha);
            }
            if (this.faM != null) {
                this.faM.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.faG != null) {
            this.faG.setSelection(0);
        }
        if (this.Si != null) {
            this.Si.setExpanded(true);
        }
        if (this.dcF != null && this.dcF.isEnabled()) {
            this.dcF.setRefreshing(true);
        }
    }

    public void jf(boolean z) {
        if (z) {
            this.dcF.setRefreshing(false);
        } else {
            this.dcF.pE();
        }
    }

    public void jg(boolean z) {
        this.dcF.setEnabled(z);
    }

    public void jh(boolean z) {
        this.faO = z;
        if (this.faO) {
            this.dbs.setText(this.fat.getResources().getString(d.j.load_more));
            if (this.faG.getChildAt(this.faG.getChildCount() - 1) == this.dbs.getView()) {
                this.dbs.aez();
                this.fat.aAZ();
                return;
            }
            this.dbs.aeA();
            return;
        }
        this.dbs.setText(this.fat.getResources().getString(d.j.load_more_must_after_delete));
        this.dbs.aeA();
    }

    public boolean bdE() {
        if (this.faO) {
            return false;
        }
        this.dbs.setText(this.fat.getResources().getString(d.j.load_more_must_after_delete));
        this.dbs.aeA();
        return true;
    }

    public boolean bdF() {
        return this.faC != null && this.faF.getVisibility() == 0;
    }

    public void bdG() {
        if (this.faC != null) {
            this.faD.setVisibility(0);
            this.faF.setVisibility(8);
            this.faE.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.fbq, 5000L);
        }
    }

    public void a(bn bnVar) {
        if (this.faC == null) {
            View rootView = this.fat.getRootView();
            this.faC = (ViewStub) rootView.findViewById(d.g.yule_game_egg_view_stub);
            this.faC.setVisibility(0);
            this.faD = (FrameLayout) rootView.findViewById(d.g.game_activity_egg_layout);
            this.faE = (TbImageView) rootView.findViewById(d.g.game_activity_egg);
            this.faF = (TbImageView) rootView.findViewById(d.g.game_activity_egg_s);
            this.faE.setPageId(this.fat.getUniqueId());
            this.faF.setPageId(this.fat.getUniqueId());
            this.faE.setDefaultBgResource(d.C0277d.common_color_10022);
            this.faE.setDefaultResource(0);
            this.faF.setDefaultBgResource(d.C0277d.common_color_10022);
            this.faF.setDefaultResource(0);
            this.faD.setOnClickListener(this.faL);
        }
        this.faD.setVisibility(0);
        String aaN = bnVar.aaN();
        String aaO = bnVar.aaO();
        this.faE.startLoad(aaN, 10, false);
        this.faF.startLoad(aaO, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.fbq, 5000L);
    }

    public void bdH() {
        if (this.faC != null && this.faD != null) {
            this.faD.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.z bdI() {
        return this.faH;
    }

    public RelativeLayout bdJ() {
        return this.fau;
    }

    public View bdK() {
        return this.faN;
    }

    public void pY(int i) {
        if (this.faw != null) {
            this.faw.setVisibility(i);
        }
    }

    public void bdL() {
        if (com.baidu.tbadk.o.m.apg().aph()) {
            int lastVisiblePosition = this.faG.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.faG.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fbF != null) {
                        com.baidu.tbadk.o.h perfLog = oVar.fbF.getPerfLog();
                        perfLog.jW(1000);
                        perfLog.cqp = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fbF.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fbF.startLogPerf();
                    }
                    if (oVar.fbE != null && (oVar.fbE instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fbE;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.o.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.jW(1000);
                                perfLog2.cqp = true;
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

    public NavigationBar aDm() {
        return this.mNavigationBar;
    }

    public void aCr() {
        this.mHasMore = true;
        this.faG.setNextPage(this.dbs);
        if (this.faP > 0) {
            this.dbs.ic(this.faP);
        }
        this.dbs.setOnClickListener(null);
        this.dbs.aez();
    }

    public void aCs() {
        this.mHasMore = false;
        this.faG.setNextPage(this.dbs);
        if (this.faP > 0) {
            this.dbs.ic(this.faP);
        }
        this.dbs.setOnClickListener(null);
        this.dbs.aeA();
        this.dbs.setText(this.fat.getResources().getString(d.j.list_has_no_more));
    }

    public void bdM() {
        this.mHasMore = true;
        this.faG.setNextPage(this.dbs);
        this.dbs.setOnClickListener(this.faL);
        if (this.faP > 0) {
            this.dbs.ic(this.faP);
        }
        this.dbs.aeA();
        this.dbs.setText(this.fat.getResources().getString(d.j.list_click_load_more));
    }

    public View bdN() {
        if (this.dbs == null) {
            return null;
        }
        return this.dbs.getView();
    }

    public void pZ(int i) {
        if (this.fbk != null) {
            this.fbk.setVisibility(i);
        }
    }

    public void qa(int i) {
        if (this.fbk != null) {
            this.fbk.setSelectNumber(i);
        }
    }

    public void aCt() {
        this.mHasMore = false;
        this.faG.setNextPage(null);
    }

    public boolean aRB() {
        return this.dbs.getView().getParent() != null && this.mHasMore;
    }

    public void qb(int i) {
        this.faP = i;
    }

    public void qc(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.eGy == null) {
                    this.eGy = new CommonTipView(this.fat.getActivity());
                }
                this.eGy.setText(d.j.frs_login_tip);
                this.eGy.show((FrameLayout) bdK(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void ji(boolean z) {
        if (this.faX != null) {
            boolean z2 = (this.fat == null || this.fat.bcq() == null || this.fat.bcq().bjs() == null) ? true : this.fat.bcq().bjs().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.faX.md(false);
                this.faX.bAR();
                return;
            }
            this.faX.md(true);
            this.faX.c(this.fak, this.cZV, this.faQ, true);
        }
    }

    public void bg(int i, int i2) {
        if (this.faX != null) {
            this.faX.a(i, i2, this.faQ, 1);
        }
    }

    public void bh(int i, int i2) {
        this.fak = i;
        this.cZV = i2;
    }

    public void jj(boolean z) {
        this.faQ = z;
    }

    public void qd(int i) {
        if (this.faG != null && this.faG.getChildCount() >= 0) {
            if (this.faG.getFirstVisiblePosition() > 8) {
                this.faG.scrollToPosition(8);
            }
            this.faG.smoothScrollToPosition(i);
        }
    }

    public void bdO() {
        a(this.fbb, this.fat.bcR());
        if (this.faH != null) {
            this.faH.bfA();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.fbc == null) {
                this.fbc = new com.baidu.tieba.video.f(this.fat.getActivity(), this.fau);
            }
            this.fbc.h(postWriteCallBackData);
        }
    }

    public void bdP() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.fbr && this.fat.getActivity() != null && this.fat.getPageContext() != null) {
            View view = null;
            if (this.faG != null && (headerViewsCount = this.faG.getHeaderViewsCount()) < this.faG.getChildCount()) {
                view = this.faG.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ae(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.fat.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.h(k.this.fat.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.h(k.this.fat.getActivity(), d.e.ds6);
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
                iT.n(this.fat.getActivity());
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (iT != null) {
                            iT.dismiss();
                        }
                    }
                }, 4000L);
                this.fbr = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.fbk != null) {
            this.fbk.setDeleteCallback(aVar);
        }
    }

    public void bdQ() {
        if (this.fbk != null) {
            this.fbk.bdQ();
        }
    }

    public void auR() {
        if (this.fbk != null) {
            this.fbk.auR();
        }
    }

    public void ax(String str, int i) {
        if (this.fbm == null) {
            this.fbm = new TextView(this.fat.getActivity());
            this.fbm.setGravity(19);
            this.fbm.setPadding(com.baidu.adp.lib.util.l.h(this.fat.getActivity(), d.e.ds34), 0, com.baidu.adp.lib.util.l.h(this.fat.getActivity(), d.e.ds34), 0);
            this.fbm.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.h(this.fat.getActivity(), d.e.tbds112)));
            this.fbm.setTextSize(0, com.baidu.adp.lib.util.l.h(this.fat.getActivity(), d.e.fontsize30));
            this.fbm.setMaxLines(2);
            this.fbm.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.fbm.setTextColor(ContextCompat.getColor(this.fat.getActivity(), d.C0277d.cp_btn_a));
        }
        this.fbl.setBackgroundColor(i);
        this.fbm.setText(str);
        this.fbl.a(this.fat.getActivity(), this.fbm, UIMsg.m_AppUI.MSG_APP_GPS);
    }

    public void setExpanded(boolean z) {
        if (this.Si != null) {
            this.Si.setExpanded(z);
        }
    }

    public void bdR() {
        if (this.Si != null && this.faG != null) {
            int count = this.faG.getCount();
            if (this.faG.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.Si.setExpanded(true, true);
            }
        }
    }

    public void bdS() {
        if (this.mPullView != null) {
            this.mPullView.aeJ();
        }
        startPullRefresh();
    }
}
