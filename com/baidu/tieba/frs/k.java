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
    private AppBarLayout PR;
    private PbListView dlX;
    private BdSwipeRefreshLayout dnh;
    private ImageView eGH;
    private NoNetworkView eRU;
    private CommonTipView eWz;
    private com.baidu.adp.widget.ListView.k eXo;
    private FrsFragment fqI;
    private View fqM;
    private com.baidu.tieba.c.b fqN;
    private ImageView fqO;
    private TextView fqP;
    private ViewStub fqQ;
    private BdTypeRecyclerView fqU;
    private com.baidu.tieba.frs.entelechy.a.aa fqV;
    private FloatingAnimationView fqW;
    private com.baidu.tieba.c.c fqX;
    private View.OnClickListener fqZ;
    private NavigationBarCoverTip frA;
    private TextView frB;
    private boolean frG;
    private View fra;
    private View frb;
    private int frd;
    private com.baidu.tieba.frs.vc.d frf;
    private com.baidu.tieba.frs.entelechy.b.c frg;
    private com.baidu.tieba.frs.vc.j frh;
    private GifView fri;
    private TbImageView frj;
    private HashSet<String> frk;
    private com.baidu.tieba.play.m frl;
    private ObservedChangeLinearLayout fro;
    private com.baidu.tieba.frs.entelechy.b.a frp;
    private com.baidu.tieba.video.f frq;
    private AppBarLayoutStickyBehavior frr;
    private FrsHeaderViewContainer frt;
    private CollapsingToolbarLayout fru;
    private com.baidu.tieba.frs.vc.f fry;
    private FrsMultiDelBottomMenuView frz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private boolean fqH = false;
    private NoPressedRelativeLayout fqJ = null;
    private CoordinatorLayout fqK = null;
    private View fqL = null;
    private FrameLayout fqR = null;
    private TbImageView fqS = null;
    private TbImageView fqT = null;
    private com.baidu.tbadk.core.dialog.b fqY = null;
    private NoNetworkView.a fmu = null;
    private boolean frc = true;
    private boolean mHasMore = true;
    private boolean fre = false;
    private int fqz = 0;
    private int dkC = 0;
    private View frm = null;
    private View frn = null;
    private boolean efl = false;
    private boolean boa = true;
    private boolean frv = true;
    private int frw = -1;
    private int frx = -1;
    private int frC = 0;
    private int frD = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener eXq = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.eXo == null) {
                        k.this.eXo = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.eXo.a(k.this.fqU, 2);
                } else if (k.this.eXo != null) {
                    k.this.eXo.oa();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener frE = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.frx != i && Math.abs(i) >= 0 && k.this.bkD() != -1) {
                if (Math.abs(i) >= k.this.bkD()) {
                    if (k.this.frv) {
                        k.this.frv = false;
                        k.this.jJ(k.this.frv);
                    }
                } else if (!k.this.frv) {
                    k.this.frv = true;
                    k.this.jJ(k.this.frv);
                }
                int bkz = k.this.bkz() + k.this.bky() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bkz;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.frx - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.rb(Math.abs(bkz - totalScrollRange2));
                        if (k.this.frn != null) {
                            k.this.frn.setVisibility(0);
                        }
                    } else if (k.this.frn != null) {
                        if (k.this.bkx() != UtilHelper.getStatusBarHeight()) {
                            k.this.rb(0);
                        }
                        k.this.frn.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.efl) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.jO(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.frx = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable frF = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.fqQ != null) {
                k.this.fqR.setVisibility(0);
                k.this.fqT.setVisibility(0);
                k.this.fqS.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        if (this.fqI != null && appBarLayout != null && this.fqI.bjK() != null && this.fqI.getPageContext() != null) {
            int bky = bky() + getNavigationBarHeight() + bkz();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bjK = this.fqI.bjK();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fqI.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.fqI.getPageContext().getPageActivity());
            }
            if (totalScrollRange <= 0) {
                if (this.frD != 2) {
                    bjK.sJ(2);
                }
                this.frD = 2;
            } else if (totalScrollRange > 0 && totalScrollRange <= bky) {
                if (this.frD != 1) {
                    bjK.sJ(1);
                }
                this.frD = 1;
            } else {
                if (this.frD != 0) {
                    bjK.sJ(0);
                }
                this.frD = 0;
            }
        }
    }

    public ObservedChangeLinearLayout bku() {
        return this.fro;
    }

    public View bkv() {
        return this.frm;
    }

    public View bkw() {
        return this.frn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkx() {
        if (this.frm == null) {
            return 0;
        }
        return this.frm.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bky() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkz() {
        if (this.eRU == null || com.baidu.adp.lib.util.j.jS()) {
            return 0;
        }
        return this.eRU.getHeight();
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
        View bkv = bkv();
        View bkw = bkw();
        if (UtilHelper.canUseStyleImmersiveSticky() && bkv != null && bkw != null && bkv.getLayoutParams() != null && bkw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = bkv.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            bkv.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bkw.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bkw.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.fqI = null;
        this.fqZ = null;
        this.frd = 0;
        this.fqI = frsFragment;
        this.fqZ = onClickListener;
        MessageManager.getInstance().registerListener(this.eXq);
        a(aVar, z);
        this.frk = new HashSet<>();
        this.frd = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fry = fVar;
    }

    private boolean bkA() {
        return this.fry != null && this.fry.bqo();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.frp = aVar;
        View rootView = this.fqI.getRootView();
        if (this.fqJ == null) {
            this.fqJ = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.fqL == null) {
            this.fqL = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.fqK == null) {
            this.fqK = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.frb == null) {
            this.frb = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.fru == null) {
            this.fru = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.frt == null) {
            this.frt = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.fro == null) {
            this.fro = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fro.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void c(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fru.setMinimumHeight(i2);
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
        if (this.fqI.bkl()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.fra == null) {
            this.fra = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bmz = aVar.bmz();
            if (bmz != null) {
                bmz.bP(this.fra);
            }
        }
        if (this.fqM == null) {
            this.fqM = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fqM.setOnClickListener(this.fqZ);
            this.mBackImageView = (ImageView) this.fqM.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fqN == null) {
            this.fqN = new com.baidu.tieba.c.b(this.fqI.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fqN.getView(), (View.OnClickListener) null);
            this.eGH = this.fqN.aZq();
            this.fqN.getView().setOnClickListener(this.fqZ);
        }
        if (this.fqO == null) {
            this.fqO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.fqO.setOnClickListener(this.fqZ);
        }
        if (this.fqP == null) {
            this.fqP = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.fqP.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.al.getDrawable(R.drawable.icon_arrow12_white);
            int g = com.baidu.adp.lib.util.l.g(this.fqI.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, g, g);
            this.fqP.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.al.j(this.fqP, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.al.j(this.fqP, R.color.cp_btn_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.fqI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.fqI.getPageContext());
        }
        this.mPullView.setTag(this.fqI.getUniqueId());
        if (this.dnh == null) {
            this.dnh = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.dnh.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.al.l(this.dnh, R.color.cp_bg_line_c);
        }
        if (this.fqU == null) {
            this.fqU = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int frJ = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.frJ--;
                if (this.frJ == 0) {
                    k.this.fqU.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.frJ++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.fqU.setItemAnimator(defaultItemAnimator);
        this.fqU.setLayoutManager(new LinearLayoutManager(this.fqU.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.eXo = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.eXo.a(this.fqU, 2);
        }
        this.fqU.setScrollable(this.fqI);
        this.fqU.setFadingEdgeLength(0);
        this.fqU.setOverScrollMode(2);
        this.fqJ.setBottomOrderView(this.fqU);
        this.fqU.setOnTouchListener(this.fqI.clb);
        this.fqU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.frl != null) {
                    k.this.frl.cj(view);
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
        if (this.dlX == null) {
            this.dlX = new PbListView(this.fqI.getPageContext().getPageActivity());
            this.dlX.getView();
        }
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.setHeight(com.baidu.adp.lib.util.l.g(this.fqI.getActivity(), R.dimen.tbds182));
        this.dlX.ajv();
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_d));
        this.dlX.iN(R.color.cp_cont_e);
        this.fqU.setOnSrollToBottomListener(this.fqI);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.fqI.bkf();
                if (k.this.fqI != null && k.this.PR != null) {
                    k.this.fqI.bkn();
                    k.this.PR.setExpanded(true);
                    if (k.this.frl != null) {
                        k.this.frl.c(k.this.fqz, k.this.dkC, false, true);
                    }
                }
            }
        });
        boolean ain = com.baidu.tbadk.core.util.ar.ail().ain();
        if (this.fqV == null) {
            this.fqV = aVar.a(this.fqI, this.fqU, ain);
        }
        fY(false);
        if (!z) {
            if (this.eRU == null) {
                this.eRU = new NoNetworkView(this.fqI.getActivity());
                this.eRU.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fro.addView(this.eRU);
            }
            if (com.baidu.adp.lib.util.j.jG()) {
                this.eRU.setVisibility(8);
            } else {
                this.eRU.setVisibility(0);
            }
            this.eRU.onChangeSkinType(this.fqI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bkK();
        if (this.frf == null) {
            this.frf = aVar.a(this.fqI, this.fqJ);
            this.frf.b(this.fqI.bko());
        }
        if (this.frg == null) {
            this.frg = aVar.b(this.fqI, this.fqJ);
            jM(true);
        }
        if (this.frm == null) {
            this.frm = rootView.findViewById(R.id.statebar_view);
        }
        if (this.frn == null) {
            this.frn = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.frl == null) {
            this.frl = new com.baidu.tieba.play.m(this.fqI.getPageContext(), this.fqU);
        }
        this.frl.setUniqueId(this.fqI.getUniqueId());
        this.frA = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.frh == null) {
            this.frh = new com.baidu.tieba.frs.vc.j(this.fqI, this.frA);
        }
        if (this.PR == null) {
            this.PR = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.PR.addOnOffsetChangedListener(this.frE);
            this.frv = true;
            this.frw = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.PR.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.frr = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.frz = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.frz.setPageContext(this.fqI.getPageContext());
        this.fqW = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.fqW.setPageId(this.fqI.getUniqueId());
        this.fqX = new com.baidu.tieba.c.c(this.fqI.getTbPageContext(), this.fqW, 2);
    }

    public void jI(boolean z) {
        if (z && this.fqX != null) {
            this.fqX.aFr();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.fqX != null) {
            this.fqX.a(oVar);
        }
    }

    private void bkB() {
        ViewGroup.LayoutParams layoutParams;
        this.efl = bkA();
        if (this.frt != null && (layoutParams = this.frt.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.efl) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bky(), 0, 0);
            }
            this.frt.requestLayout();
        }
    }

    public void bkC() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fro != null) {
            bkB();
            if (this.efl) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.frm != null) {
                    this.frm.setAlpha(1.0f);
                }
                if (this.frn != null) {
                    this.frn.setAlpha(1.0f);
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
        if (z && this.fqI != null && this.fqI.bjJ() != null) {
            this.fqI.bjJ().bqt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkD() {
        int i;
        if (this.PR == null) {
            return this.frw;
        }
        if (this.frw != -1) {
            return this.frw;
        }
        int childCount = this.PR.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.PR.getChildAt(childCount);
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
        this.frw = Math.max(0, this.PR.getTotalScrollRange() - Math.abs(i2));
        return this.frw;
    }

    public void wr(String str) {
        if (this.frh != null) {
            this.frh.wr(str);
        }
    }

    public com.baidu.tieba.play.m bkE() {
        return this.frl;
    }

    public com.baidu.tieba.frs.entelechy.b.c bkF() {
        return this.frg;
    }

    public void jK(boolean z) {
        if (this.frf != null) {
            this.frf.jK(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bkG() {
        return this.frf;
    }

    public void E(boolean z, boolean z2) {
        if (this.boa && this.frg != null) {
            this.frg.E(z, z2);
        }
    }

    public void jL(boolean z) {
        this.boa = z;
        if (!this.boa && this.frg != null) {
            this.frg.E(false, false);
        }
    }

    public void bkH() {
        if (this.boa && this.frg != null) {
            this.frg.E(false, false);
        }
        rc(8);
        this.fqO.setVisibility(8);
        jK(false);
        this.fqU.setVisibility(8);
        this.frt.setVisibility(8);
    }

    public void bkI() {
        if (this.boa && this.frg != null) {
            this.frg.E(true, false);
        }
        rc(0);
        bkJ();
        jK(this.fqI.bkq());
        this.fqU.setVisibility(0);
        this.frt.setVisibility(0);
    }

    private void rc(int i) {
        if (this.fqN != null) {
            this.fqN.setVisibility(i);
        }
    }

    private void bkJ() {
        this.fqO.setVisibility(0);
    }

    public void jM(boolean z) {
        if (this.frg != null) {
            this.frg.kp(z);
        }
    }

    private void bkK() {
        if (this.fri == null) {
            View rootView = this.fqI.getRootView();
            this.fri = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.frj = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.frj.setPageId(this.fqI.getUniqueId());
            this.fri.setLayerType(1, null);
            this.frj.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bkL() {
        return this.fqM;
    }

    public void h(NoNetworkView.a aVar) {
        this.fmu = aVar;
        if (this.eRU != null) {
            this.eRU.a(this.fmu);
        }
    }

    public void fY(boolean z) {
        this.fqH = z;
        if (z) {
            if (this.frg != null) {
                this.frg.bnc();
                return;
            }
            return;
        }
        this.fqU.getAdapter().notifyDataSetChanged();
        if (this.frg != null) {
            this.frg.bnd();
        }
    }

    public void jN(boolean z) {
        if (this.frg != null) {
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
        this.fqU.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.s sVar) {
        this.fqV.setOnAdapterItemClickListener(sVar);
    }

    public void setForumName(String str) {
        this.fqV.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eXq);
        if (this.frl != null) {
            this.frl.destroy();
        }
        if (this.frh != null) {
            this.frh.onDestory();
        }
        if (this.frz != null) {
            this.frz.setPageContext(null);
        }
        this.fqV.onDestory();
        this.fqU.setOnSrollToBottomListener(null);
        this.fqU.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.frF);
        if (this.eWz != null) {
            this.eWz.onDestroy();
        }
        this.frk.clear();
        if (this.frf != null) {
            this.frf.bqf();
        }
        if (this.frq != null) {
            this.frq.bmo();
        }
        if (this.fqX != null) {
            this.fqX.onDestroy();
        }
        if (this.frA != null) {
            this.frA.onDestroy();
        }
        if (this.frz != null) {
            this.frz.onDestroy();
        }
    }

    public boolean bkM() {
        if (this.PR == null || this.frr == null || !this.frr.isSticky()) {
            return this.frf != null && this.frf.bkM();
        }
        if (this.fqU != null) {
            this.fqU.setSelection(0);
        }
        this.frr.expandedAppBarLayout(this.PR);
        return true;
    }

    public boolean bkk() {
        return this.fqH;
    }

    public void aUE() {
        this.fqU.setVisibility(0);
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
            com.baidu.tbadk.core.i.abb().lZ(str);
        }
    }

    public void bkN() {
        if (this.fqV != null) {
            this.fqV.notifyDataSetChanged();
        }
    }

    public void Ve() {
        if (this.fqV instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.fqV).Ve();
        }
    }

    private void bkO() {
        if (this.fqY == null && this.fqI.getPageContext() != null) {
            String[] strArr = {this.fqI.getPageContext().getPageActivity().getString(R.string.take_photo), this.fqI.getPageContext().getPageActivity().getString(R.string.album)};
            this.fqY = new com.baidu.tbadk.core.dialog.b(this.fqI.getPageContext().getPageActivity());
            this.fqY.mF(this.fqI.getPageContext().getPageActivity().getString(R.string.operation));
            this.fqY.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.fqI.takePhoto();
                    } else if (i == 1 && k.this.fqI.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ak.W(k.this.fqI.getPageContext().getPageActivity());
                    }
                }
            });
            this.fqY.d(this.fqI.getPageContext());
        }
    }

    public void bkP() {
        bkO();
        if (this.fqY != null) {
            this.fqY.afJ();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.aa(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            if (this.fqI != null && this.fqI.bjH() != null && this.fqI.bjH().boZ() == 0) {
                mVar.rl(this.fqI.bjH().bpg());
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
        this.fqV.b(arrayList2, frsViewData);
        if (this.frl != null && this.fqz != 0) {
            this.frl.c(this.fqz, this.dkC, this.fre, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fqU;
    }

    public void bkQ() {
        this.fqV.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fqI.getPageContext(), 1);
        aVar.a(this.fqU);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.fqI.getForumName());
        hashMap.put("forum_id", this.fqI.getForumId());
        aVar.setParams(hashMap);
        aVar.ak(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
    }

    public void onPause() {
        if (this.frf != null) {
            this.frf.bqg();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void onResume() {
        rd(TbadkCoreApplication.getInst().getSkinType());
        if (this.frf != null) {
            this.frf.bqh();
        }
    }

    public void release() {
        if (this.eRU != null && this.fmu != null) {
            this.eRU.b(this.fmu);
        }
    }

    public ImageView bkR() {
        return this.fqO;
    }

    public TextView bkS() {
        return this.fqP;
    }

    public View bkT() {
        if (this.fqN != null) {
            return this.fqN.getView();
        }
        return null;
    }

    public void B(int i, boolean z) {
        if (this.fqN != null) {
            this.fqN.l(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fqI, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fqI.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        if (this.frj != null) {
            this.frj.invalidate();
        }
        if (this.fqV != null) {
            this.fqV.bmW();
            this.fqV.notifyDataSetChanged();
        }
        com.baidu.tbadk.s.a.a(this.fqI.getPageContext(), this.fqJ);
        if (this.eRU != null) {
            this.eRU.onChangeSkinType(this.fqI.getPageContext(), i);
        }
        if (this.dlX != null) {
            this.dlX.setTextColor(com.baidu.tbadk.core.util.al.getColor(R.color.cp_cont_d));
            this.dlX.iP(i);
        }
        rd(i);
        if (this.frg != null) {
            this.frg.onChangeSkinType(i);
        }
        if (this.frf != null) {
            this.frf.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.frz != null) {
            this.frz.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.al.l(this.dnh, R.color.cp_bg_line_e);
        com.baidu.tbadk.core.util.al.l(this.fqL, R.color.cp_bg_line_d);
    }

    private void rd(int i) {
        if (this.fqI != null) {
            re(i);
        }
    }

    private void re(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fqI.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
            com.baidu.tbadk.core.util.al.l(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_b);
            com.baidu.tbadk.core.util.al.h(this.fra, R.color.cp_bg_line_b, i);
        }
        com.baidu.tbadk.core.util.al.l(this.frm, R.color.cp_bg_line_d);
        com.baidu.tbadk.core.util.al.l(this.frn, R.color.cp_bg_line_d);
        jO(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jO(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.efl) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.frC != 0) {
                    com.baidu.tbadk.core.util.al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_white_n, (int) R.drawable.icon_topbar_return_white_s);
                    com.baidu.tbadk.core.util.al.c(this.fqO, (int) R.drawable.icon_topbar_more_white_n, (int) R.drawable.icon_topbar_more_white_s);
                    com.baidu.tbadk.core.util.al.c(this.eGH, (int) R.drawable.icon_common_news_white_n, (int) R.drawable.icon_common_news_white_s);
                    this.frC = 0;
                }
            } else if (z || this.frC != 1) {
                com.baidu.tbadk.core.util.al.c(this.mBackImageView, (int) R.drawable.icon_topbar_return_n, (int) R.drawable.icon_topbar_return_s);
                com.baidu.tbadk.core.util.al.c(this.fqO, (int) R.drawable.icon_topbar_more_n, (int) R.drawable.icon_topbar_more_s);
                com.baidu.tbadk.core.util.al.c(this.eGH, (int) R.drawable.icon_common_news_n, (int) R.drawable.icon_common_news_s);
                this.frC = 1;
            }
            bkU();
        }
    }

    private void bkU() {
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
                if (this.eGH != null) {
                    this.eGH.setAlpha(f);
                }
                if (this.fqO != null) {
                    this.fqO.setAlpha(f);
                }
            }
            if (this.fqP != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.fqP.setAlpha(f2);
                this.fqP.setClickable(f2 > 0.0f);
            }
            if (this.frm != null) {
                this.frm.setAlpha(alpha);
            }
            if (this.frn != null) {
                this.frn.setAlpha(alpha);
            }
            if (this.fra != null) {
                this.fra.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.fqU != null) {
            this.fqU.setSelection(0);
        }
        if (this.PR != null) {
            this.PR.setExpanded(true);
        }
        if (this.dnh != null && this.dnh.isEnabled()) {
            this.dnh.setRefreshing(true);
        }
    }

    public void jP(boolean z) {
        if (z) {
            this.dnh.setRefreshing(false);
        } else {
            this.dnh.oz();
        }
    }

    public void jQ(boolean z) {
        this.dnh.setEnabled(z);
    }

    public void jR(boolean z) {
        this.frc = z;
        if (this.frc) {
            this.dlX.setText(this.fqI.getResources().getString(R.string.load_more));
            if (this.fqU.getChildAt(this.fqU.getChildCount() - 1) == this.dlX.getView()) {
                this.dlX.ajy();
                this.fqI.aHq();
                return;
            }
            this.dlX.ajz();
            return;
        }
        this.dlX.setText(this.fqI.getResources().getString(R.string.load_more_must_after_delete));
        this.dlX.ajz();
    }

    public boolean bkV() {
        if (this.frc) {
            return false;
        }
        this.dlX.setText(this.fqI.getResources().getString(R.string.load_more_must_after_delete));
        this.dlX.ajz();
        return true;
    }

    public boolean bkW() {
        return this.fqQ != null && this.fqT.getVisibility() == 0;
    }

    public void bkX() {
        if (this.fqQ != null) {
            this.fqR.setVisibility(0);
            this.fqT.setVisibility(8);
            this.fqS.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.frF, 5000L);
        }
    }

    public void a(bn bnVar) {
        if (this.fqQ == null) {
            View rootView = this.fqI.getRootView();
            this.fqQ = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.fqQ.setVisibility(0);
            this.fqR = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.fqS = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.fqT = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.fqS.setPageId(this.fqI.getUniqueId());
            this.fqT.setPageId(this.fqI.getUniqueId());
            this.fqS.setDefaultBgResource(R.color.common_color_10022);
            this.fqS.setDefaultResource(0);
            this.fqT.setDefaultBgResource(R.color.common_color_10022);
            this.fqT.setDefaultResource(0);
            this.fqR.setOnClickListener(this.fqZ);
        }
        this.fqR.setVisibility(0);
        String afx = bnVar.afx();
        String afy = bnVar.afy();
        this.fqS.startLoad(afx, 10, false);
        this.fqT.startLoad(afy, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.frF, 5000L);
    }

    public void bkY() {
        if (this.fqQ != null && this.fqR != null) {
            this.fqR.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.aa bkZ() {
        return this.fqV;
    }

    public RelativeLayout bla() {
        return this.fqJ;
    }

    public View blb() {
        return this.frb;
    }

    public void rf(int i) {
        if (this.fqL != null) {
            this.fqL.setVisibility(i);
        }
    }

    public void blc() {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            int lastVisiblePosition = this.fqU.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fqU.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.frU != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.frU.getPerfLog();
                        perfLog.kK(1000);
                        perfLog.cyv = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.frU.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.frU.startLogPerf();
                    }
                    if (oVar.frT != null && (oVar.frT instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.frT;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.kK(1000);
                                perfLog2.cyv = true;
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

    public NavigationBar aJz() {
        return this.mNavigationBar;
    }

    public void aIE() {
        this.mHasMore = true;
        this.fqU.setNextPage(this.dlX);
        if (this.frd > 0) {
            this.dlX.iQ(this.frd);
        }
        this.dlX.setOnClickListener(null);
        this.dlX.ajy();
    }

    public void aIF() {
        this.mHasMore = false;
        this.fqU.setNextPage(this.dlX);
        if (this.frd > 0) {
            this.dlX.iQ(this.frd);
        }
        this.dlX.setOnClickListener(null);
        this.dlX.ajz();
        this.dlX.setText(this.fqI.getResources().getString(R.string.list_has_no_more));
    }

    public void bld() {
        this.mHasMore = true;
        this.fqU.setNextPage(this.dlX);
        this.dlX.setOnClickListener(this.fqZ);
        if (this.frd > 0) {
            this.dlX.iQ(this.frd);
        }
        this.dlX.ajz();
        this.dlX.setText(this.fqI.getResources().getString(R.string.list_click_load_more));
    }

    public View ble() {
        if (this.dlX == null) {
            return null;
        }
        return this.dlX.getView();
    }

    public void rg(int i) {
        if (this.frz != null) {
            this.frz.setVisibility(i);
        }
    }

    public void rh(int i) {
        if (this.frz != null) {
            this.frz.setSelectNumber(i);
        }
    }

    public void aIG() {
        this.mHasMore = false;
        this.fqU.setNextPage(null);
    }

    public boolean aYK() {
        return this.dlX.getView().getParent() != null && this.mHasMore;
    }

    public void ri(int i) {
        this.frd = i;
    }

    public void rj(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("frs_login_tip", true)) {
                if (this.eWz == null) {
                    this.eWz = new CommonTipView(this.fqI.getActivity());
                }
                this.eWz.setText(R.string.frs_login_tip);
                this.eWz.show((FrameLayout) blb(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void jS(boolean z) {
        this.mIsBackground = z;
        if (this.frl != null) {
            boolean z2 = (this.fqI == null || this.fqI.bjK() == null || this.fqI.bjK().bqK() == null) ? true : this.fqI.bjK().bqK().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.frl.mS(false);
                this.frl.bIB();
                return;
            }
            this.frl.mS(true);
            this.frl.c(this.fqz, this.dkC, this.fre, true);
        }
    }

    public void bm(int i, int i2) {
        if (this.frl != null) {
            this.frl.a(i, i2, this.fre, 1);
        }
    }

    public void bn(int i, int i2) {
        this.fqz = i;
        this.dkC = i2;
    }

    public void jT(boolean z) {
        this.fre = z;
    }

    public void rk(int i) {
        if (this.fqU != null && this.fqU.getChildCount() >= 0) {
            if (this.fqU.getFirstVisiblePosition() > 8) {
                this.fqU.scrollToPosition(8);
            }
            this.fqU.smoothScrollToPosition(i);
        }
    }

    public void blf() {
        a(this.frp, this.fqI.bkl());
        if (this.fqV != null) {
            this.fqV.bmT();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.frq == null) {
                this.frq = new com.baidu.tieba.video.f(this.fqI.getActivity(), this.fqJ);
            }
            this.frq.h(postWriteCallBackData);
        }
    }

    public void blg() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.agM().getLong("frs_video_activity_guide", 0L) == 0 && !this.frG && this.fqI.getActivity() != null && this.fqI.getPageContext() != null) {
            View view = null;
            if (this.fqU != null && (headerViewsCount = this.fqU.getHeaderViewsCount()) < this.fqU.getChildCount()) {
                view = this.fqU.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).X(0).U(true).V(false).T(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        k.this.fqI.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.g(k.this.fqI.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.g(k.this.fqI.getActivity(), R.dimen.ds6);
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
                hL.n(this.fqI.getActivity());
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (hL != null) {
                            hL.dismiss();
                        }
                    }
                }, 4000L);
                this.frG = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.frz != null) {
            this.frz.setDeleteCallback(aVar);
        }
    }

    public void blh() {
        if (this.frz != null) {
            this.frz.blh();
        }
    }

    public void azW() {
        if (this.frz != null) {
            this.frz.azW();
        }
    }

    public void at(String str, int i) {
        if (this.frB == null) {
            this.frB = new TextView(this.fqI.getActivity());
            this.frB.setGravity(19);
            this.frB.setPadding(com.baidu.adp.lib.util.l.g(this.fqI.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.g(this.fqI.getActivity(), R.dimen.ds34), 0);
            this.frB.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.g(this.fqI.getActivity(), R.dimen.tbds112)));
            this.frB.setTextSize(0, com.baidu.adp.lib.util.l.g(this.fqI.getActivity(), R.dimen.fontsize30));
            this.frB.setMaxLines(2);
            this.frB.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.frB.setTextColor(ContextCompat.getColor(this.fqI.getActivity(), R.color.cp_btn_a));
        }
        this.frA.setBackgroundColor(i);
        this.frB.setText(str);
        this.frA.a(this.fqI.getActivity(), this.frB, UIMsg.m_AppUI.MSG_APP_GPS);
    }

    public void setExpanded(boolean z) {
        if (this.PR != null) {
            this.PR.setExpanded(z);
        }
    }

    public void bli() {
        if (this.PR != null && this.fqU != null) {
            int count = this.fqU.getCount();
            if (this.fqU.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.PR.setExpanded(true, true);
            }
        }
    }

    public void blj() {
        if (this.mPullView != null) {
            this.mPullView.ajI();
        }
        startPullRefresh();
    }

    public void blk() {
        if (bkZ() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bkZ().getDatas();
            if (!com.baidu.tbadk.core.util.v.aa(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bf) {
                        bf bfVar = (bf) mVar;
                        if (bfVar.bIf != 0 && bfVar.threadData != null && this.fqI.bjH() != null && this.fqI.bjH().boF() != null) {
                            int[] imageWidthAndHeight = this.fqI.bjH().boF().imageWidthAndHeight(bfVar.threadData);
                            bfVar.bIf = imageWidthAndHeight[0];
                            bfVar.bIg = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.5
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.bkZ().notifyDataSetChanged();
                        if (!k.this.mIsBackground) {
                            k.this.frl.c(k.this.fqz, k.this.dkC, k.this.fre, true);
                        }
                    }
                }, 500L);
            }
        }
    }
}
