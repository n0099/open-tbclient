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
    private AppBarLayout Qj;
    private PbListView dnG;
    private BdSwipeRefreshLayout dpi;
    private ImageView eLE;
    private NoNetworkView eWV;
    private CommonTipView fbB;
    private com.baidu.adp.widget.ListView.k fcq;
    private FrsFragment fvH;
    private View fvL;
    private com.baidu.tieba.c.b fvM;
    private ImageView fvN;
    private TextView fvO;
    private ViewStub fvP;
    private BdTypeRecyclerView fvT;
    private com.baidu.tieba.frs.entelechy.a.aa fvU;
    private FloatingAnimationView fvV;
    private com.baidu.tieba.c.c fvW;
    private View.OnClickListener fvY;
    private View fvZ;
    private boolean fwE;
    private View fwa;
    private int fwc;
    private com.baidu.tieba.frs.vc.d fwe;
    private com.baidu.tieba.frs.entelechy.b.c fwf;
    private com.baidu.tieba.frs.vc.j fwg;
    private GifView fwh;
    private TbImageView fwi;
    private HashSet<String> fwj;
    private com.baidu.tieba.play.m fwk;
    private ObservedChangeLinearLayout fwn;
    private com.baidu.tieba.frs.entelechy.b.a fwo;
    private com.baidu.tieba.video.f fwp;
    private AppBarLayoutStickyBehavior fwq;
    private FrsHeaderViewContainer fwr;
    private CollapsingToolbarLayout fws;
    private com.baidu.tieba.frs.vc.f fww;
    private FrsMultiDelBottomMenuView fwx;
    private NavigationBarCoverTip fwy;
    private TextView fwz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean fvG = false;
    private NoPressedRelativeLayout fvI = null;
    private CoordinatorLayout fvJ = null;
    private View fvK = null;
    private FrameLayout fvQ = null;
    private TbImageView fvR = null;
    private TbImageView fvS = null;
    private com.baidu.tbadk.core.dialog.b fvX = null;
    private NoNetworkView.a fru = null;
    private boolean fwb = true;
    private boolean mHasMore = true;
    private boolean fwd = false;
    private int fvy = 0;
    private int dml = 0;
    private View fwl = null;
    private View fwm = null;
    private boolean ejQ = false;
    private boolean boN = true;
    private boolean fwt = true;
    private int fwu = -1;
    private int fwv = -1;
    private int fwA = 0;
    private int fwB = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener fcs = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.fcq == null) {
                        k.this.fcq = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.fcq.a(k.this.fvT, 2);
                } else if (k.this.fcq != null) {
                    k.this.fcq.ow();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fwC = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fwv != i && Math.abs(i) >= 0 && k.this.bmI() != -1) {
                if (Math.abs(i) >= k.this.bmI()) {
                    if (k.this.fwt) {
                        k.this.fwt = false;
                        k.this.jT(k.this.fwt);
                    }
                } else if (!k.this.fwt) {
                    k.this.fwt = true;
                    k.this.jT(k.this.fwt);
                }
                int bmE = k.this.bmE() + k.this.bmD() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bmE;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fwv - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.rt(Math.abs(bmE - totalScrollRange2));
                        if (k.this.fwm != null) {
                            k.this.fwm.setVisibility(0);
                        }
                    } else if (k.this.fwm != null) {
                        if (k.this.bmC() != UtilHelper.getStatusBarHeight()) {
                            k.this.rt(0);
                        }
                        k.this.fwm.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.ejQ) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.jY(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fwv = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable fwD = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.fvP != null) {
                k.this.fvQ.setVisibility(0);
                k.this.fvS.setVisibility(0);
                k.this.fvR.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        if (this.fvH != null && appBarLayout != null && this.fvH.blP() != null && this.fvH.getPageContext() != null) {
            int bmD = bmD() + getNavigationBarHeight() + bmE();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController blP = this.fvH.blP();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fvH.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.fvH.getPageContext().getPageActivity());
            }
            if (totalScrollRange <= 0) {
                if (this.fwB != 2) {
                    blP.tb(2);
                }
                this.fwB = 2;
            } else if (totalScrollRange > 0 && totalScrollRange <= bmD) {
                if (this.fwB != 1) {
                    blP.tb(1);
                }
                this.fwB = 1;
            } else {
                if (this.fwB != 0) {
                    blP.tb(0);
                }
                this.fwB = 0;
            }
        }
    }

    public ObservedChangeLinearLayout bmz() {
        return this.fwn;
    }

    public View bmA() {
        return this.fwl;
    }

    public View bmB() {
        return this.fwm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmC() {
        if (this.fwl == null) {
            return 0;
        }
        return this.fwl.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmD() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmE() {
        if (this.eWV == null || com.baidu.adp.lib.util.j.kc()) {
            return 0;
        }
        return this.eWV.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt(int i) {
        View bmA = bmA();
        View bmB = bmB();
        if (UtilHelper.canUseStyleImmersiveSticky() && bmA != null && bmB != null && bmA.getLayoutParams() != null && bmB.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = bmA.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            bmA.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bmB.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bmB.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.fvH = null;
        this.fvY = null;
        this.fwc = 0;
        this.fvH = frsFragment;
        this.fvY = onClickListener;
        MessageManager.getInstance().registerListener(this.fcs);
        a(aVar, z);
        this.fwj = new HashSet<>();
        this.fwc = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fww = fVar;
    }

    private boolean bmF() {
        return this.fww != null && this.fww.bsu();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.fwo = aVar;
        View rootView = this.fvH.getRootView();
        if (this.fvI == null) {
            this.fvI = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.fvK == null) {
            this.fvK = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.fvJ == null) {
            this.fvJ = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.fwa == null) {
            this.fwa = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.fws == null) {
            this.fws = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.fwr == null) {
            this.fwr = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.fwn == null) {
            this.fwn = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fwn.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fws.setMinimumHeight(i2);
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
        if (this.fvH.bmq()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.fvZ == null) {
            this.fvZ = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b boD = aVar.boD();
            if (boD != null) {
                boD.bR(this.fvZ);
            }
        }
        if (this.fvL == null) {
            this.fvL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fvL.setOnClickListener(this.fvY);
            this.mBackImageView = (ImageView) this.fvL.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fvM == null) {
            this.fvM = new com.baidu.tieba.c.b(this.fvH.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fvM.getView(), (View.OnClickListener) null);
            this.eLE = this.fvM.bbs();
            this.fvM.getView().setOnClickListener(this.fvY);
        }
        if (this.fvN == null) {
            this.fvN = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.fvN.setOnClickListener(this.fvY);
        }
        if (this.fvO == null) {
            this.fvO = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.fvO.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int g = com.baidu.adp.lib.util.l.g(this.fvH.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, g, g);
            this.fvO.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.j(this.fvO, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.j(this.fvO, R.color.cp_btn_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.fvH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.fvH.getPageContext());
        }
        this.mPullView.setTag(this.fvH.getUniqueId());
        if (this.dpi == null) {
            this.dpi = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.dpi.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.l(this.dpi, R.color.cp_bg_line_c);
        }
        if (this.fvT == null) {
            this.fvT = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int fwH = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.fwH--;
                if (this.fwH == 0) {
                    k.this.fvT.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.fwH++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.fvT.setItemAnimator(defaultItemAnimator);
        this.fvT.setLayoutManager(new LinearLayoutManager(this.fvT.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fcq = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.fcq.a(this.fvT, 2);
        }
        this.fvT.setScrollable(this.fvH);
        this.fvT.setFadingEdgeLength(0);
        this.fvT.setOverScrollMode(2);
        this.fvI.setBottomOrderView(this.fvT);
        this.fvT.setOnTouchListener(this.fvH.cmp);
        this.fvT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.fwk != null) {
                    k.this.fwk.cm(view);
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
        if (this.dnG == null) {
            this.dnG = new PbListView(this.fvH.getPageContext().getPageActivity());
            this.dnG.getView();
        }
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.setHeight(com.baidu.adp.lib.util.l.g(this.fvH.getActivity(), R.dimen.tbds182));
        this.dnG.akA();
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.dnG.iT(R.color.cp_cont_e);
        this.fvT.setOnSrollToBottomListener(this.fvH);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.fvH.bmk();
                if (k.this.fvH != null && k.this.Qj != null) {
                    k.this.fvH.bms();
                    k.this.Qj.setExpanded(true);
                    if (k.this.fwk != null) {
                        k.this.fwk.c(k.this.fvy, k.this.dml, false, true);
                    }
                }
            }
        });
        boolean ajq = com.baidu.tbadk.core.util.as.ajo().ajq();
        if (this.fvU == null) {
            this.fvU = aVar.a(this.fvH, this.fvT, ajq);
        }
        gc(false);
        if (!z) {
            if (this.eWV == null) {
                this.eWV = new NoNetworkView(this.fvH.getActivity());
                this.eWV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fwn.addView(this.eWV);
            }
            if (com.baidu.adp.lib.util.j.jQ()) {
                this.eWV.setVisibility(8);
            } else {
                this.eWV.setVisibility(0);
            }
            this.eWV.onChangeSkinType(this.fvH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bmP();
        if (this.fwe == null) {
            this.fwe = aVar.a(this.fvH, this.fvI);
            this.fwe.b(this.fvH.bmt());
        }
        if (this.fwf == null) {
            this.fwf = aVar.b(this.fvH, this.fvI);
            jW(true);
        }
        if (this.fwl == null) {
            this.fwl = rootView.findViewById(R.id.statebar_view);
        }
        if (this.fwm == null) {
            this.fwm = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.fwk == null) {
            this.fwk = new com.baidu.tieba.play.m(this.fvH.getPageContext(), this.fvT);
        }
        this.fwk.setUniqueId(this.fvH.getUniqueId());
        this.fwy = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.fwg == null) {
            this.fwg = new com.baidu.tieba.frs.vc.j(this.fvH, this.fwy);
        }
        if (this.Qj == null) {
            this.Qj = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Qj.addOnOffsetChangedListener(this.fwC);
            this.fwt = true;
            this.fwu = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Qj.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.fwq = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.fwx = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.fwx.setPageContext(this.fvH.getPageContext());
        this.fvV = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.fvV.setPageId(this.fvH.getUniqueId());
        this.fvW = new com.baidu.tieba.c.c(this.fvH.getTbPageContext(), this.fvV, 2);
    }

    public void jS(boolean z) {
        if (z && this.fvW != null) {
            this.fvW.aGQ();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.fvW != null) {
            this.fvW.a(oVar);
        }
    }

    private void bmG() {
        ViewGroup.LayoutParams layoutParams;
        this.ejQ = bmF();
        if (this.fwr != null && (layoutParams = this.fwr.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.ejQ) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bmD(), 0, 0);
            }
            this.fwr.requestLayout();
        }
    }

    public void bmH() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fwn != null) {
            bmG();
            if (this.ejQ) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.fwl != null) {
                    this.fwl.setAlpha(1.0f);
                }
                if (this.fwm != null) {
                    this.fwm.setAlpha(1.0f);
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
        if (z && this.fvH != null && this.fvH.blO() != null) {
            this.fvH.blO().bsz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmI() {
        int i;
        if (this.Qj == null) {
            return this.fwu;
        }
        if (this.fwu != -1) {
            return this.fwu;
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
        this.fwu = Math.max(0, this.Qj.getTotalScrollRange() - Math.abs(i2));
        return this.fwu;
    }

    public void wV(String str) {
        if (this.fwg != null) {
            this.fwg.wV(str);
        }
    }

    public com.baidu.tieba.play.m bmJ() {
        return this.fwk;
    }

    public com.baidu.tieba.frs.entelechy.b.c bmK() {
        return this.fwf;
    }

    public void jU(boolean z) {
        if (this.fwe != null) {
            this.fwe.jU(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bmL() {
        return this.fwe;
    }

    public void H(boolean z, boolean z2) {
        if (this.boN && this.fwf != null) {
            this.fwf.H(z, z2);
        }
    }

    public void jV(boolean z) {
        this.boN = z;
        if (!this.boN && this.fwf != null) {
            this.fwf.H(false, false);
        }
    }

    public void bmM() {
        if (this.boN && this.fwf != null) {
            this.fwf.H(false, false);
        }
        ru(8);
        this.fvN.setVisibility(8);
        jU(false);
        this.fvT.setVisibility(8);
        this.fwr.setVisibility(8);
    }

    public void bmN() {
        if (this.boN && this.fwf != null) {
            this.fwf.H(true, false);
        }
        ru(0);
        bmO();
        jU(this.fvH.bmv());
        this.fvT.setVisibility(0);
        this.fwr.setVisibility(0);
    }

    private void ru(int i) {
        if (this.fvM != null) {
            this.fvM.setVisibility(i);
        }
    }

    private void bmO() {
        this.fvN.setVisibility(0);
    }

    public void jW(boolean z) {
        if (this.fwf != null) {
            this.fwf.kz(z);
        }
    }

    private void bmP() {
        if (this.fwh == null) {
            View rootView = this.fvH.getRootView();
            this.fwh = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.fwi = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.fwi.setPageId(this.fvH.getUniqueId());
            this.fwh.setLayerType(1, null);
            this.fwi.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bmQ() {
        return this.fvL;
    }

    public void h(NoNetworkView.a aVar) {
        this.fru = aVar;
        if (this.eWV != null) {
            this.eWV.a(this.fru);
        }
    }

    public void gc(boolean z) {
        this.fvG = z;
        if (z) {
            if (this.fwf != null) {
                this.fwf.bpg();
                return;
            }
            return;
        }
        this.fvT.getAdapter().notifyDataSetChanged();
        if (this.fwf != null) {
            this.fwf.bph();
        }
    }

    public void jX(boolean z) {
        if (this.fwf != null) {
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
        this.fvT.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        this.fvU.setOnAdapterItemClickListener(sVar);
    }

    public void setForumName(String str) {
        this.fvU.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fcs);
        if (this.fwk != null) {
            this.fwk.destroy();
        }
        if (this.fwg != null) {
            this.fwg.onDestory();
        }
        if (this.fwx != null) {
            this.fwx.setPageContext(null);
        }
        this.fvU.onDestory();
        this.fvT.setOnSrollToBottomListener(null);
        this.fvT.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.fwD);
        if (this.fbB != null) {
            this.fbB.onDestroy();
        }
        this.fwj.clear();
        if (this.fwe != null) {
            this.fwe.bsl();
        }
        if (this.fwp != null) {
            this.fwp.bos();
        }
        if (this.fvW != null) {
            this.fvW.onDestroy();
        }
        if (this.fwy != null) {
            this.fwy.onDestroy();
        }
        if (this.fwx != null) {
            this.fwx.onDestroy();
        }
    }

    public boolean bmR() {
        if (this.Qj == null || this.fwq == null || !this.fwq.isSticky()) {
            return this.fwe != null && this.fwe.bmR();
        }
        if (this.fvT != null) {
            this.fvT.setSelection(0);
        }
        this.fwq.expandedAppBarLayout(this.Qj);
        return true;
    }

    public boolean bmp() {
        return this.fvG;
    }

    public void aVP() {
        this.fvT.setVisibility(0);
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

    public void bmS() {
        if (this.fvU != null) {
            this.fvU.notifyDataSetChanged();
        }
    }

    public void VX() {
        if (this.fvU instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.fvU).VX();
        }
    }

    private void bmT() {
        if (this.fvX == null && this.fvH.getPageContext() != null) {
            String[] strArr = {this.fvH.getPageContext().getPageActivity().getString(R.string.take_photo), this.fvH.getPageContext().getPageActivity().getString(R.string.album)};
            this.fvX = new com.baidu.tbadk.core.dialog.b(this.fvH.getPageContext().getPageActivity());
            this.fvX.mP(this.fvH.getPageContext().getPageActivity().getString(R.string.operation));
            this.fvX.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.fvH.takePhoto();
                    } else if (i == 1 && k.this.fvH.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.Z(k.this.fvH.getPageContext().getPageActivity());
                    }
                }
            });
            this.fvX.d(this.fvH.getPageContext());
        }
    }

    public void bmU() {
        bmT();
        if (this.fvX != null) {
            this.fvX.agL();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.aa(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            if (this.fvH != null && this.fvH.blM() != null && this.fvH.blM().brf() == 0) {
                mVar.rD(this.fvH.blM().brm());
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
        this.fvU.b(arrayList2, frsViewData);
        if (this.fwk != null && this.fvy != 0) {
            this.fwk.c(this.fvy, this.dml, this.fwd, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fvT;
    }

    public void bmV() {
        this.fvU.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fvH.getPageContext(), 1);
        aVar.a(this.fvT);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.fvH.getForumName());
        hashMap.put("forum_id", this.fvH.getForumId());
        aVar.setParams(hashMap);
        aVar.ak(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.fwe != null) {
            this.fwe.bsm();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        rv(TbadkCoreApplication.getInst().getSkinType());
        if (this.fwe != null) {
            this.fwe.bsn();
        }
    }

    public void release() {
        if (this.eWV != null && this.fru != null) {
            this.eWV.b(this.fru);
        }
    }

    public ImageView bmW() {
        return this.fvN;
    }

    public TextView bmX() {
        return this.fvO;
    }

    public View bmY() {
        if (this.fvM != null) {
            return this.fvM.getView();
        }
        return null;
    }

    public void D(int i, boolean z) {
        if (this.fvM != null) {
            this.fvM.l(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fvH, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fvH.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.fwi != null) {
            this.fwi.invalidate();
        }
        if (this.fvU != null) {
            this.fvU.bpa();
            this.fvU.notifyDataSetChanged();
        }
        com.baidu.tbadk.s.a.a(this.fvH.getPageContext(), this.fvI);
        if (this.eWV != null) {
            this.eWV.onChangeSkinType(this.fvH.getPageContext(), i);
        }
        if (this.dnG != null) {
            this.dnG.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.dnG.iV(i);
        }
        rv(i);
        if (this.fwf != null) {
            this.fwf.onChangeSkinType(i);
        }
        if (this.fwe != null) {
            this.fwe.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fwx != null) {
            this.fwx.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.l(this.dpi, R.color.cp_bg_line_e);
        com.baidu.tbadk.core.util.am.l(this.fvK, R.color.cp_bg_line_d);
    }

    private void rv(int i) {
        if (this.fvH != null) {
            rw(i);
        }
    }

    private void rw(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fvH.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.am.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.am.h(this.fvZ, R.color.cp_bg_line_b, i);
        }
        com.baidu.tbadk.core.util.am.l(this.fwl, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.am.l(this.fwm, R.color.cp_bg_line_d);
        jY(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.ejQ) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.fwA != 0) {
                    com.baidu.tbadk.core.util.am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
                    com.baidu.tbadk.core.util.am.c(this.fvN, (int) R.drawable.icon_topbar_more_white_n, (int) R.drawable.icon_topbar_more_white_s);
                    com.baidu.tbadk.core.util.am.c(this.eLE, (int) R.drawable.icon_common_news_white_n, (int) R.drawable.icon_common_news_white_s);
                    this.fwA = 0;
                }
            } else if (z || this.fwA != 1) {
                com.baidu.tbadk.core.util.am.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
                com.baidu.tbadk.core.util.am.c(this.fvN, (int) R.drawable.icon_topbar_more_n, (int) R.drawable.icon_topbar_more_s);
                com.baidu.tbadk.core.util.am.c(this.eLE, (int) R.drawable.icon_common_news_n, (int) R.drawable.icon_common_news_s);
                this.fwA = 1;
            }
            bmZ();
        }
    }

    private void bmZ() {
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
                if (this.eLE != null) {
                    this.eLE.setAlpha(f);
                }
                if (this.fvN != null) {
                    this.fvN.setAlpha(f);
                }
            }
            if (this.fvO != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.fvO.setAlpha(f2);
                this.fvO.setClickable(f2 > 0.0f);
            }
            if (this.fwl != null) {
                this.fwl.setAlpha(alpha);
            }
            if (this.fwm != null) {
                this.fwm.setAlpha(alpha);
            }
            if (this.fvZ != null) {
                this.fvZ.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.fvT != null) {
            this.fvT.setSelection(0);
        }
        if (this.Qj != null) {
            this.Qj.setExpanded(true);
        }
        if (this.dpi != null && this.dpi.isEnabled()) {
            this.dpi.setRefreshing(true);
        }
    }

    public void jZ(boolean z) {
        if (z) {
            this.dpi.setRefreshing(false);
        } else {
            this.dpi.oU();
        }
    }

    public void ka(boolean z) {
        this.dpi.setEnabled(z);
    }

    public void kb(boolean z) {
        this.fwb = z;
        if (this.fwb) {
            this.dnG.setText(this.fvH.getResources().getString(R.string.load_more));
            if (this.fvT.getChildAt(this.fvT.getChildCount() - 1) == this.dnG.getView()) {
                this.dnG.akD();
                this.fvH.aIQ();
                return;
            }
            this.dnG.akE();
            return;
        }
        this.dnG.setText(this.fvH.getResources().getString(R.string.load_more_must_after_delete));
        this.dnG.akE();
    }

    public boolean bna() {
        if (this.fwb) {
            return false;
        }
        this.dnG.setText(this.fvH.getResources().getString(R.string.load_more_must_after_delete));
        this.dnG.akE();
        return true;
    }

    public boolean bnb() {
        return this.fvP != null && this.fvS.getVisibility() == 0;
    }

    public void bnc() {
        if (this.fvP != null) {
            this.fvQ.setVisibility(0);
            this.fvS.setVisibility(8);
            this.fvR.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.fwD, 5000L);
        }
    }

    public void a(bn bnVar) {
        if (this.fvP == null) {
            View rootView = this.fvH.getRootView();
            this.fvP = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.fvP.setVisibility(0);
            this.fvQ = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.fvR = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.fvS = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.fvR.setPageId(this.fvH.getUniqueId());
            this.fvS.setPageId(this.fvH.getUniqueId());
            this.fvR.setDefaultBgResource(R.color.common_color_10022);
            this.fvR.setDefaultResource(0);
            this.fvS.setDefaultBgResource(R.color.common_color_10022);
            this.fvS.setDefaultResource(0);
            this.fvQ.setOnClickListener(this.fvY);
        }
        this.fvQ.setVisibility(0);
        String agz = bnVar.agz();
        String agA = bnVar.agA();
        this.fvR.startLoad(agz, 10, false);
        this.fvS.startLoad(agA, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.fwD, 5000L);
    }

    public void bnd() {
        if (this.fvP != null && this.fvQ != null) {
            this.fvQ.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.aa bne() {
        return this.fvU;
    }

    public RelativeLayout aXy() {
        return this.fvI;
    }

    public View bnf() {
        return this.fwa;
    }

    public void rx(int i) {
        if (this.fvK != null) {
            this.fvK.setVisibility(i);
        }
    }

    public void bng() {
        if (com.baidu.tbadk.p.m.avt().avu()) {
            int lastVisiblePosition = this.fvT.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fvT.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.eef != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.eef.getPerfLog();
                        perfLog.kQ(1000);
                        perfLog.czM = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.eef.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.eef.startLogPerf();
                    }
                    if (oVar.fwR != null && (oVar.fwR instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fwR;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kQ(1000);
                                perfLog2.czM = true;
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

    public NavigationBar aLh() {
        return this.mNavigationBar;
    }

    public void aKi() {
        this.mHasMore = true;
        this.fvT.setNextPage(this.dnG);
        if (this.fwc > 0) {
            this.dnG.iW(this.fwc);
        }
        this.dnG.setOnClickListener(null);
        this.dnG.akD();
    }

    public void aKj() {
        this.mHasMore = false;
        this.fvT.setNextPage(this.dnG);
        if (this.fwc > 0) {
            this.dnG.iW(this.fwc);
        }
        this.dnG.setOnClickListener(null);
        this.dnG.akE();
        this.dnG.setText(this.fvH.getResources().getString(R.string.list_has_no_more));
    }

    public void bnh() {
        this.mHasMore = true;
        this.fvT.setNextPage(this.dnG);
        this.dnG.setOnClickListener(this.fvY);
        if (this.fwc > 0) {
            this.dnG.iW(this.fwc);
        }
        this.dnG.akE();
        this.dnG.setText(this.fvH.getResources().getString(R.string.list_click_load_more));
    }

    public View bni() {
        if (this.dnG == null) {
            return null;
        }
        return this.dnG.getView();
    }

    public void ry(int i) {
        if (this.fwx != null) {
            this.fwx.setVisibility(i);
        }
    }

    public void rz(int i) {
        if (this.fwx != null) {
            this.fwx.setSelectNumber(i);
        }
    }

    public void aKk() {
        this.mHasMore = false;
        this.fvT.setNextPage(null);
    }

    public boolean baM() {
        return this.dnG.getView().getParent() != null && this.mHasMore;
    }

    public void rA(int i) {
        this.fwc = i;
    }

    public void rB(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("frs_login_tip", true)) {
                if (this.fbB == null) {
                    this.fbB = new CommonTipView(this.fvH.getActivity());
                }
                this.fbB.setText(R.string.frs_login_tip);
                this.fbB.show((FrameLayout) bnf(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void kc(boolean z) {
        this.mIsBackground = z;
        if (this.fwk != null) {
            boolean z2 = (this.fvH == null || this.fvH.blP() == null || this.fvH.blP().bsQ() == null) ? true : this.fvH.blP().bsQ().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.fwk.nh(false);
                this.fwk.bLm();
                return;
            }
            this.fwk.nh(true);
            this.fwk.c(this.fvy, this.dml, this.fwd, true);
        }
    }

    public void br(int i, int i2) {
        if (this.fwk != null) {
            this.fwk.a(i, i2, this.fwd, 1);
        }
    }

    public void bs(int i, int i2) {
        this.fvy = i;
        this.dml = i2;
    }

    public void kd(boolean z) {
        this.fwd = z;
    }

    public void rC(int i) {
        if (this.fvT != null && this.fvT.getChildCount() >= 0) {
            if (this.fvT.getFirstVisiblePosition() > 8) {
                this.fvT.scrollToPosition(8);
            }
            this.fvT.smoothScrollToPosition(i);
        }
    }

    public void bnj() {
        a(this.fwo, this.fvH.bmq());
        if (this.fvU != null) {
            this.fvU.boX();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.fwp == null) {
                this.fwp = new com.baidu.tieba.video.f(this.fvH.getActivity(), this.fvI);
            }
            this.fwp.h(postWriteCallBackData);
        }
    }

    public void bnk() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getLong("frs_video_activity_guide", 0L) == 0 && !this.fwE && this.fvH.getActivity() != null && this.fvH.getPageContext() != null) {
            View view = null;
            if (this.fvT != null && (headerViewsCount = this.fvT.getHeaderViewsCount()) < this.fvT.getChildCount()) {
                view = this.fvT.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).X(0).U(true).V(false).T(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        k.this.fvH.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.g(k.this.fvH.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.g(k.this.fvH.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c hV = dVar.hV();
                hV.R(false);
                hV.q(this.fvH.getActivity());
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hV != null) {
                            hV.dismiss();
                        }
                    }
                }, 4000L);
                this.fwE = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.fwx != null) {
            this.fwx.setDeleteCallback(aVar);
        }
    }

    public void bnl() {
        if (this.fwx != null) {
            this.fwx.bnl();
        }
    }

    public void aBn() {
        if (this.fwx != null) {
            this.fwx.aBn();
        }
    }

    public void au(String str, int i) {
        if (this.fwz == null) {
            this.fwz = new TextView(this.fvH.getActivity());
            this.fwz.setGravity(19);
            this.fwz.setPadding(com.baidu.adp.lib.util.l.g(this.fvH.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.g(this.fvH.getActivity(), R.dimen.ds34), 0);
            this.fwz.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.fvH.getActivity(), R.dimen.tbds112)));
            this.fwz.setTextSize(0, com.baidu.adp.lib.util.l.g(this.fvH.getActivity(), R.dimen.fontsize30));
            this.fwz.setMaxLines(2);
            this.fwz.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.fwz.setTextColor(ContextCompat.getColor(this.fvH.getActivity(), R.color.cp_btn_a));
        }
        this.fwy.setBackgroundColor(i);
        this.fwz.setText(str);
        this.fwy.a(this.fvH.getActivity(), this.fwz, UIMsg.m_AppUI.MSG_APP_GPS);
    }

    public void setExpanded(boolean z) {
        if (this.Qj != null) {
            this.Qj.setExpanded(z);
        }
    }

    public void bnm() {
        if (this.Qj != null && this.fvT != null) {
            int count = this.fvT.getCount();
            if (this.fvT.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.Qj.setExpanded(true, true);
            }
        }
    }

    public void bnn() {
        if (this.mPullView != null) {
            this.mPullView.akN();
        }
        startPullRefresh();
    }

    public void bno() {
        if (bne() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bne().getDatas();
            if (!com.baidu.tbadk.core.util.v.aa(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bf) {
                        bf bfVar = (bf) mVar;
                        if (bfVar.bJg != 0 && bfVar.threadData != null && this.fvH.blM() != null && this.fvH.blM().bqK() != null) {
                            int[] imageWidthAndHeight = this.fvH.blM().bqK().imageWidthAndHeight(bfVar.threadData);
                            bfVar.bJg = imageWidthAndHeight[0];
                            bfVar.bJh = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.5
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.bne().notifyDataSetChanged();
                        if (!k.this.mIsBackground) {
                            k.this.fwk.c(k.this.fvy, k.this.dml, k.this.fwd, true);
                        }
                    }
                }, 500L);
            }
        }
    }
}
