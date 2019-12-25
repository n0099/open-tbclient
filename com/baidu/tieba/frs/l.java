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
/* loaded from: classes6.dex */
public class l {
    private AppBarLayout Cf;
    private PbListView egU;
    private BdSwipeRefreshLayout eiv;
    private ImageView fJR;
    private NoNetworkView fPl;
    private CommonTipView fTZ;
    private com.baidu.adp.widget.ListView.k fUZ;
    private FrsFragment gkN;
    private View gkR;
    private com.baidu.tieba.c.b gkS;
    private ImageView gkT;
    private TextView gkU;
    private ViewStub gkV;
    private BdTypeRecyclerView gkZ;
    private com.baidu.tieba.frs.vc.h glB;
    private FrsMultiDelBottomMenuView glC;
    private NavigationBarCoverTip glD;
    private TextView glE;
    private boolean glJ;
    private com.baidu.tieba.frs.entelechy.a.af gla;
    private FloatingAnimationView glb;
    private com.baidu.tieba.c.c glc;
    private View.OnClickListener gle;
    private View glf;
    private View glg;
    private int gli;
    private com.baidu.tieba.frs.vc.d glk;
    private com.baidu.tieba.frs.entelechy.b.c gll;
    private com.baidu.tieba.frs.vc.l glm;
    private GifView gln;
    private TbImageView glo;
    private HashSet<String> glp;
    private com.baidu.tieba.play.m glq;
    private ObservedChangeLinearLayout gls;
    private com.baidu.tieba.frs.entelechy.b.a glt;
    private com.baidu.tieba.video.f glu;
    private AppBarLayoutStickyBehavior glv;
    private FrsHeaderViewContainer glw;
    private CollapsingToolbarLayout glx;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.h mPullView;
    private int mSkinType;
    private boolean gkM = false;
    private NoPressedRelativeLayout gkO = null;
    private CoordinatorLayout gkP = null;
    private View gkQ = null;
    private FrameLayout gkW = null;
    private TbImageView gkX = null;
    private TbImageView gkY = null;
    private com.baidu.tbadk.core.dialog.b gld = null;
    private NoNetworkView.a ggy = null;
    private boolean glh = true;
    private boolean mHasMore = true;
    private boolean glj = false;
    private int gkE = 0;
    private int efC = 0;
    private View axb = null;
    private View glr = null;
    private boolean eGb = false;
    private boolean csw = true;
    private boolean gly = true;
    private int glz = -1;
    private int glA = -1;
    private int glF = 0;
    private int glG = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener fVb = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.l.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (l.this.fUZ == null) {
                        l.this.fUZ = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    l.this.fUZ.a(l.this.gkZ, 2);
                } else if (l.this.fUZ != null) {
                    l.this.fUZ.kl();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener glH = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.l.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            l.this.a(appBarLayout, i);
            if (l.this.glA != i && Math.abs(i) >= 0 && l.this.bCc() != -1) {
                if (Math.abs(i) >= l.this.bCc()) {
                    if (l.this.gly) {
                        l.this.gly = false;
                        l.this.kW(l.this.gly);
                    }
                } else if (!l.this.gly) {
                    l.this.gly = true;
                    l.this.kW(l.this.gly);
                }
                int bBY = l.this.bBY() + l.this.bBX() + l.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bBY;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && l.this.glA - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        l.this.sw(Math.abs(bBY - totalScrollRange2));
                        if (l.this.glr != null) {
                            l.this.glr.setVisibility(0);
                        }
                    } else if (l.this.glr != null) {
                        if (l.this.bBW() != UtilHelper.getStatusBarHeight()) {
                            l.this.sw(0);
                        }
                        l.this.glr.setVisibility(8);
                    }
                    if (l.this.mNavigationBar != null) {
                        if (l.this.eGb) {
                            l.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            l.this.lb(false);
                        } else if (l.this.mNavigationBar.mCenterText != null) {
                            l.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    l.this.glA = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable glI = new Runnable() { // from class: com.baidu.tieba.frs.l.13
        @Override // java.lang.Runnable
        public void run() {
            if (l.this.gkV != null) {
                l.this.gkW.setVisibility(0);
                l.this.gkY.setVisibility(0);
                l.this.gkX.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.gkN != null && appBarLayout != null && this.gkN.bBg() != null && this.gkN.getPageContext() != null) {
            int bBX = bBX() + getNavigationBarHeight() + bBY();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bBg = this.gkN.bBg();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.gkN.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.gkN.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.gkQ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.gkN != null && this.gkN.bBn();
            if (totalScrollRange <= 0) {
                if (this.glG != 2) {
                    bBg.ui(2);
                }
                this.glG = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bBX) {
                if (this.glG != 1) {
                    bBg.ui(1);
                }
                this.glG = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.glG != 0) {
                    bBg.ui(0);
                }
                this.glG = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.gkN.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.gkQ.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bBU() {
        return this.gls;
    }

    public View xD() {
        return this.axb;
    }

    public View bBV() {
        return this.glr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBW() {
        if (this.axb == null) {
            return 0;
        }
        return this.axb.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBX() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bBY() {
        if (this.fPl == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fPl.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw(int i) {
        View xD = xD();
        View bBV = bBV();
        if (UtilHelper.canUseStyleImmersiveSticky() && xD != null && bBV != null && xD.getLayoutParams() != null && bBV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = xD.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            xD.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bBV.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bBV.setLayoutParams(layoutParams2);
        }
    }

    public l(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.gkN = null;
        this.gle = null;
        this.gli = 0;
        this.gkN = frsFragment;
        this.gle = onClickListener;
        MessageManager.getInstance().registerListener(this.fVb);
        a(aVar, z);
        this.glp = new HashSet<>();
        this.gli = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.glB = hVar;
    }

    private boolean bBZ() {
        return this.glB != null && this.glB.bHY();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.glt = aVar;
        View rootView = this.gkN.getRootView();
        if (this.gkO == null) {
            this.gkO = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.gkQ == null) {
            this.gkQ = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.gkP == null) {
            this.gkP = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.glg == null) {
            this.glg = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.glx == null) {
            this.glx = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.glw == null) {
            this.glw = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.gls == null) {
            this.gls = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.gls.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.l.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        l.this.glx.setMinimumHeight(i2);
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
        if (this.gkN.bBL()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.glf == null) {
            this.glf = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bEb = aVar.bEb();
            if (bEb != null) {
                bEb.bK(this.glf);
            }
        }
        if (this.gkR == null) {
            this.gkR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.gkR.setOnClickListener(this.gle);
            this.mBackImageView = (ImageView) this.gkR.findViewById(R.id.widget_navi_back_button);
        }
        if (this.gkS == null) {
            this.gkS = new com.baidu.tieba.c.b(this.gkN.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gkS.getView(), (View.OnClickListener) null);
            this.fJR = this.gkS.bty();
            this.gkS.getView().setOnClickListener(this.gle);
        }
        if (this.gkT == null) {
            this.gkT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.gkT.setOnClickListener(this.gle);
        }
        if (this.gkU == null) {
            this.gkU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.gkU.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.gkN.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.gkU.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.b(this.gkU, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.gkU, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.gkN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.gkN.getPageContext());
        }
        this.mPullView.setTag(this.gkN.getUniqueId());
        if (this.eiv == null) {
            this.eiv = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.eiv.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.eiv, R.color.cp_bg_line_c);
        }
        if (this.gkZ == null) {
            this.gkZ = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.l.8
            int glM = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.glM--;
                if (this.glM == 0) {
                    l.this.gkZ.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.glM++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.gkZ.setItemAnimator(defaultItemAnimator);
        this.gkZ.setLayoutManager(new LinearLayoutManager(this.gkZ.getContext()) { // from class: com.baidu.tieba.frs.l.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fUZ = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.fUZ.a(this.gkZ, 2);
        }
        this.gkZ.setScrollable(this.gkN);
        this.gkZ.setFadingEdgeLength(0);
        this.gkZ.setOverScrollMode(2);
        this.gkO.setBottomOrderView(this.gkZ);
        this.gkZ.setOnTouchListener(this.gkN.dne);
        this.gkZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.l.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (l.this.glq != null) {
                    l.this.glq.cg(view);
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
        if (this.egU == null) {
            this.egU = new PbListView(this.gkN.getPageContext().getPageActivity());
            this.egU.getView();
        }
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.egU.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gkN.getActivity(), R.dimen.tbds182));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gkZ.setOnSrollToBottomListener(this.gkN);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.l.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.this.gkN.bBE();
                if (l.this.gkN != null && l.this.Cf != null) {
                    l.this.gkN.bBN();
                    l.this.Cf.setExpanded(true);
                    if (l.this.glq != null) {
                        l.this.glq.a(l.this.gkE, l.this.efC, false, true);
                    }
                }
            }
        });
        boolean aDY = com.baidu.tbadk.core.util.ar.aDX().aDY();
        if (this.gla == null) {
            this.gla = aVar.a(this.gkN, this.gkZ, aDY);
        }
        hi(false);
        if (!z) {
            if (this.fPl == null) {
                this.fPl = new NoNetworkView(this.gkN.getActivity());
                this.fPl.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.gls.addView(this.fPl);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fPl.setVisibility(8);
            } else {
                this.fPl.setVisibility(0);
            }
            this.fPl.onChangeSkinType(this.gkN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bCj();
        if (this.glk == null) {
            this.glk = aVar.a(this.gkN, this.gkO);
            this.glk.b(this.gkN.bBO());
        }
        if (this.gll == null) {
            this.gll = aVar.b(this.gkN, this.gkO);
            kZ(true);
        }
        if (this.axb == null) {
            this.axb = rootView.findViewById(R.id.statebar_view);
        }
        if (this.glr == null) {
            this.glr = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.glq == null) {
            this.glq = new com.baidu.tieba.play.m(this.gkN.getPageContext(), this.gkZ);
        }
        this.glq.setUniqueId(this.gkN.getUniqueId());
        this.glD = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.glm == null) {
            this.glm = new com.baidu.tieba.frs.vc.l(this.gkN, this.glD);
        }
        if (this.Cf == null) {
            this.Cf = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Cf.addOnOffsetChangedListener(this.glH);
            this.gly = true;
            this.glz = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Cf.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.glv = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.glC = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.glC.setPageContext(this.gkN.getPageContext());
        this.glb = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.glb.setPageId(this.gkN.getUniqueId());
        this.glc = new com.baidu.tieba.c.c(this.gkN.getTbPageContext(), this.glb, 2);
    }

    public void kV(boolean z) {
        if (z && this.glc != null) {
            this.glc.aXR();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.glc != null) {
            this.glc.a(oVar);
        }
    }

    private void bCa() {
        ViewGroup.LayoutParams layoutParams;
        this.eGb = bBZ();
        if (this.glw != null && (layoutParams = this.glw.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.eGb) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bBX(), 0, 0);
            }
            this.glw.requestLayout();
        }
    }

    public void bCb() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gls != null) {
            bCa();
            if (this.eGb) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.axb != null) {
                    this.axb.setAlpha(1.0f);
                }
                if (this.glr != null) {
                    this.glr.setAlpha(1.0f);
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
    public void kW(boolean z) {
        if (z && this.gkN != null && this.gkN.bBf() != null) {
            this.gkN.bBf().bId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCc() {
        int i;
        if (this.Cf == null) {
            return this.glz;
        }
        if (this.glz != -1) {
            return this.glz;
        }
        int childCount = this.Cf.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Cf.getChildAt(childCount);
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
        this.glz = Math.max(0, this.Cf.getTotalScrollRange() - Math.abs(i2));
        return this.glz;
    }

    public void AE(String str) {
        if (this.glm != null) {
            this.glm.AE(str);
        }
    }

    public com.baidu.tieba.play.m bCd() {
        return this.glq;
    }

    public com.baidu.tieba.frs.entelechy.b.c bCe() {
        return this.gll;
    }

    public void kX(boolean z) {
        if (this.glk != null) {
            this.glk.kX(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bCf() {
        return this.glk;
    }

    public void K(boolean z, boolean z2) {
        if (this.csw && this.gll != null) {
            this.gll.K(z, z2);
        }
    }

    public void kY(boolean z) {
        this.csw = z;
        if (!this.csw && this.gll != null) {
            this.gll.K(false, false);
        }
    }

    public void bCg() {
        if (this.csw && this.gll != null) {
            this.gll.K(false, false);
        }
        sx(8);
        this.gkT.setVisibility(8);
        kX(false);
        this.gkZ.setVisibility(8);
        this.glw.setVisibility(8);
    }

    public void bCh() {
        if (this.csw && this.gll != null) {
            this.gll.K(true, false);
        }
        sx(0);
        bCi();
        kX(this.gkN.bBQ());
        this.gkZ.setVisibility(0);
        this.glw.setVisibility(0);
    }

    private void sx(int i) {
        if (this.gkS != null) {
            this.gkS.setVisibility(i);
        }
    }

    private void bCi() {
        this.gkT.setVisibility(0);
    }

    public void kZ(boolean z) {
        if (this.gll != null) {
            this.gll.lB(z);
        }
    }

    private void bCj() {
        if (this.gln == null) {
            View rootView = this.gkN.getRootView();
            this.gln = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.glo = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.glo.setPageId(this.gkN.getUniqueId());
            this.gln.setLayerType(1, null);
            this.glo.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bCk() {
        return this.gkR;
    }

    public void g(NoNetworkView.a aVar) {
        this.ggy = aVar;
        if (this.fPl != null) {
            this.fPl.a(this.ggy);
        }
    }

    public void hi(boolean z) {
        this.gkM = z;
        if (z) {
            if (this.gll != null) {
                this.gll.bEF();
                return;
            }
            return;
        }
        this.gkZ.getAdapter().notifyDataSetChanged();
        if (this.gll != null) {
            this.gll.bEG();
        }
    }

    public void la(boolean z) {
        if (this.gll != null) {
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
        this.gkZ.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.gla.a(sVar);
    }

    public void setForumName(String str) {
        this.gla.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fVb);
        if (this.glq != null) {
            this.glq.destroy();
        }
        if (this.glm != null) {
            this.glm.onDestory();
        }
        if (this.glC != null) {
            this.glC.setPageContext(null);
        }
        this.gla.onDestory();
        this.gkZ.setOnSrollToBottomListener(null);
        this.gkZ.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.glI);
        if (this.fTZ != null) {
            this.fTZ.onDestroy();
        }
        this.glp.clear();
        if (this.glk != null) {
            this.glk.bHI();
        }
        if (this.glu != null) {
            this.glu.bDP();
        }
        if (this.glc != null) {
            this.glc.onDestroy();
        }
        if (this.glD != null) {
            this.glD.onDestroy();
        }
        if (this.glC != null) {
            this.glC.onDestroy();
        }
    }

    public boolean bCl() {
        if (this.Cf == null || this.glv == null || !this.glv.isSticky()) {
            return this.glk != null && this.glk.bCl();
        }
        if (this.gkZ != null) {
            this.gkZ.setSelection(0);
        }
        this.glv.expandedAppBarLayout(this.Cf);
        return true;
    }

    public boolean bBJ() {
        return this.gkM;
    }

    public void bdR() {
        this.gkZ.setVisibility(0);
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
            com.baidu.tbadk.core.i.axf().setForumNameForWaterImage(str);
        }
    }

    public void bCm() {
        if (this.gla != null) {
            this.gla.notifyDataSetChanged();
        }
    }

    public void aqe() {
        if (this.gla instanceof com.baidu.tieba.frs.entelechy.a.q) {
            ((com.baidu.tieba.frs.entelechy.a.q) this.gla).aqe();
        }
    }

    private void bCn() {
        if (this.gld == null && this.gkN.getPageContext() != null) {
            String[] strArr = {this.gkN.getPageContext().getPageActivity().getString(R.string.take_photo), this.gkN.getPageContext().getPageActivity().getString(R.string.album)};
            this.gld = new com.baidu.tbadk.core.dialog.b(this.gkN.getPageContext().getPageActivity());
            this.gld.sA(this.gkN.getPageContext().getPageActivity().getString(R.string.operation));
            this.gld.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.l.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        l.this.gkN.bBK();
                    } else if (i == 1 && l.this.gkN.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(l.this.gkN.getPageContext().getPageActivity());
                    }
                }
            });
            this.gld.d(this.gkN.getPageContext());
        }
    }

    public void bCo() {
        bCn();
        if (this.gld != null) {
            this.gld.aBX();
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
                if (this.gkN != null && this.gkN.bBd() != null && this.gkN.bBd().bGC() == 0) {
                    nVar.sG(this.gkN.bBd().bGJ());
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
                        ((bi) mVar).cMR.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.gla.b(arrayList2, frsViewData);
            if (this.glq != null && this.gkE != 0) {
                this.glq.a(this.gkE, this.efC, this.glj, true);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gkZ;
    }

    public void bCp() {
        this.gla.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gkN.getPageContext(), 1);
        aVar.a(this.gkZ);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.gkN.getForumName());
        hashMap.put("forum_id", this.gkN.getForumId());
        aVar.setParams(hashMap);
        aVar.am(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.glk != null) {
            this.glk.bHJ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        sy(TbadkCoreApplication.getInst().getSkinType());
        if (this.glk != null) {
            this.glk.bHK();
        }
    }

    public void release() {
        if (this.fPl != null && this.ggy != null) {
            this.fPl.b(this.ggy);
        }
    }

    public ImageView bCq() {
        return this.gkT;
    }

    public TextView bCr() {
        return this.gkU;
    }

    public View bCs() {
        if (this.gkS != null) {
            return this.gkS.getView();
        }
        return null;
    }

    public void E(int i, boolean z) {
        if (this.gkS != null) {
            this.gkS.p(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.gkN, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.gkN.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.glo != null) {
            this.glo.invalidate();
        }
        if (this.gla != null) {
            this.gla.bEz();
            this.gla.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.gkN.getPageContext(), this.gkO);
        if (this.fPl != null) {
            this.fPl.onChangeSkinType(this.gkN.getPageContext(), i);
        }
        if (this.egU != null) {
            this.egU.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.egU.changeSkin(i);
        }
        sy(i);
        if (this.gll != null) {
            this.gll.onChangeSkinType(i);
        }
        if (this.glk != null) {
            this.glk.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.glC != null) {
            this.glC.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.eiv, R.color.cp_bg_line_d);
        if (this.gkN != null && this.gkN.bBn()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gkQ, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.gkQ, R.color.cp_bg_line_d);
        }
    }

    private void sy(int i) {
        if (this.gkN != null) {
            sz(i);
        }
    }

    private void sz(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gkN.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.glf, R.color.cp_bg_line_c, i);
            if (this.gkS != null) {
                this.gkS.onChangeSkinType(i);
            }
            if (this.gkT != null) {
                SvgManager.aDW().a(this.gkT, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.axb, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.glr, R.color.cp_bg_line_h);
        lb(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lb(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.eGb) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.glF != 0) {
                    SvgManager.aDW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aDW().a(this.gkT, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aDW().a(this.fJR, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.glF = 0;
                }
            } else if (z || this.glF != 1) {
                SvgManager.aDW().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aDW().a(this.gkT, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aDW().a(this.fJR, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.glF = 1;
            }
            bCt();
        }
    }

    private void bCt() {
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
                if (this.fJR != null) {
                    this.fJR.setAlpha(f);
                }
                if (this.gkT != null) {
                    this.gkT.setAlpha(f);
                }
            }
            if (this.gkU != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.gkU.setAlpha(f2);
                this.gkU.setClickable(f2 > 0.0f);
            }
            if (this.axb != null) {
                this.axb.setAlpha(alpha);
            }
            if (this.glr != null) {
                this.glr.setAlpha(alpha);
            }
            if (this.glf != null) {
                this.glf.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.gkZ != null) {
            this.gkZ.setSelection(0);
        }
        if (this.Cf != null) {
            this.Cf.setExpanded(true);
        }
        if (this.eiv != null && this.eiv.isEnabled()) {
            this.eiv.setRefreshing(true);
        }
    }

    public void lc(boolean z) {
        if (z) {
            this.eiv.setRefreshing(false);
        } else {
            this.eiv.interruptRefresh();
        }
    }

    public void ld(boolean z) {
        this.eiv.setEnabled(z);
    }

    public void le(boolean z) {
        this.glh = z;
        if (this.glh) {
            this.egU.setText(this.gkN.getResources().getString(R.string.load_more));
            if (this.gkZ.getChildAt(this.gkZ.getChildCount() - 1) == this.egU.getView()) {
                this.egU.startLoadData();
                this.gkN.aZs();
                return;
            }
            this.egU.endLoadData();
            return;
        }
        this.egU.setText(this.gkN.getResources().getString(R.string.load_more_must_after_delete));
        this.egU.endLoadData();
    }

    public boolean bCu() {
        if (this.glh) {
            return false;
        }
        this.egU.setText(this.gkN.getResources().getString(R.string.load_more_must_after_delete));
        this.egU.endLoadData();
        return true;
    }

    public boolean bCv() {
        return this.gkV != null && this.gkY.getVisibility() == 0;
    }

    public void bCw() {
        if (this.gkV != null) {
            this.gkW.setVisibility(0);
            this.gkY.setVisibility(8);
            this.gkX.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.glI, 5000L);
        }
    }

    public void a(bt btVar) {
        if (this.gkV == null) {
            View rootView = this.gkN.getRootView();
            this.gkV = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.gkV.setVisibility(0);
            this.gkW = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.gkX = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.gkY = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.gkX.setPageId(this.gkN.getUniqueId());
            this.gkY.setPageId(this.gkN.getUniqueId());
            this.gkX.setDefaultBgResource(R.color.common_color_10022);
            this.gkX.setDefaultResource(0);
            this.gkY.setDefaultBgResource(R.color.common_color_10022);
            this.gkY.setDefaultResource(0);
            this.gkW.setOnClickListener(this.gle);
        }
        this.gkW.setVisibility(0);
        String aBP = btVar.aBP();
        String aBQ = btVar.aBQ();
        this.gkX.startLoad(aBP, 10, false);
        this.gkY.startLoad(aBQ, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.glI, 5000L);
    }

    public void bCx() {
        if (this.gkV != null && this.gkW != null) {
            this.gkW.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.af bCy() {
        return this.gla;
    }

    public RelativeLayout bpX() {
        return this.gkO;
    }

    public View bCz() {
        return this.glg;
    }

    public void sA(int i) {
        if (this.gkQ != null) {
            this.gkQ.setVisibility(i);
        }
    }

    public void bCA() {
        if (com.baidu.tbadk.n.m.aOA().aOB()) {
            int lastVisiblePosition = this.gkZ.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.gkZ.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof p)) {
                    p pVar = (p) childAt.getTag();
                    if (pVar.glX != null) {
                        com.baidu.tbadk.n.h perfLog = pVar.glX.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.dzk = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            pVar.glX.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        pVar.glX.startLogPerf();
                    }
                    if (pVar.glW != null && (pVar.glW instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = pVar.glW;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.dzk = true;
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

    public NavigationBar bcb() {
        return this.mNavigationBar;
    }

    public void baF() {
        this.mHasMore = true;
        this.gkZ.setNextPage(this.egU);
        if (this.gli > 0) {
            this.egU.showEmptyView(this.gli);
        }
        this.egU.setOnClickListener(null);
        this.egU.startLoadData();
    }

    public void baG() {
        this.mHasMore = false;
        this.gkZ.setNextPage(this.egU);
        if (this.gli > 0) {
            this.egU.showEmptyView(this.gli);
        }
        this.egU.setOnClickListener(null);
        this.egU.endLoadData();
        this.egU.setText(this.gkN.getResources().getString(R.string.list_has_no_more));
    }

    public void bCB() {
        this.mHasMore = true;
        this.gkZ.setNextPage(this.egU);
        this.egU.setOnClickListener(this.gle);
        if (this.gli > 0) {
            this.egU.showEmptyView(this.gli);
        }
        this.egU.endLoadData();
        this.egU.setText(this.gkN.getResources().getString(R.string.list_click_load_more));
    }

    public View bCC() {
        if (this.egU == null) {
            return null;
        }
        return this.egU.getView();
    }

    public void sB(int i) {
        if (this.glC != null) {
            this.glC.setVisibility(i);
        }
    }

    public void sC(int i) {
        if (this.glC != null) {
            this.glC.setSelectNumber(i);
        }
    }

    public void baH() {
        this.mHasMore = false;
        this.gkZ.setNextPage(null);
    }

    public boolean bCD() {
        return this.egU.getView().getParent() != null && this.mHasMore;
    }

    public void sD(int i) {
        this.gli = i;
    }

    public void sE(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.fTZ == null) {
                    this.fTZ = new CommonTipView(this.gkN.getActivity());
                }
                this.fTZ.setText(R.string.frs_login_tip);
                this.fTZ.b((FrameLayout) bCz(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void lf(boolean z) {
        this.mIsBackground = z;
        if (this.glq != null) {
            boolean z2 = (this.gkN == null || this.gkN.bBg() == null || this.gkN.bBg().bIt() == null) ? true : this.gkN.bBg().bIt().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.glq.on(false);
                this.glq.cah();
                return;
            }
            this.glq.on(true);
            this.glq.a(this.gkE, this.efC, this.glj, true);
        }
    }

    public void bD(int i, int i2) {
        if (this.glq != null) {
            this.glq.a(i, i2, this.glj, 1);
        }
    }

    public void bE(int i, int i2) {
        this.gkE = i;
        this.efC = i2;
    }

    public void lg(boolean z) {
        this.glj = z;
    }

    public void sF(int i) {
        if (this.gkZ != null && this.gkZ.getChildCount() >= 0) {
            if (this.gkZ.getFirstVisiblePosition() > 8) {
                this.gkZ.scrollToPosition(8);
            }
            this.gkZ.smoothScrollToPosition(i);
        }
    }

    public void bCE() {
        a(this.glt, this.gkN.bBL());
        if (this.gla != null) {
            this.gla.bEw();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.glu == null) {
                this.glu = new com.baidu.tieba.video.f(this.gkN.getActivity(), this.gkO);
            }
            this.glu.h(postWriteCallBackData);
        }
    }

    public void bCF() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.glJ && this.gkN.getActivity() != null && this.gkN.getPageContext() != null) {
            View view = null;
            if (this.gkZ != null && (headerViewsCount = this.gkZ.getHeaderViewsCount()) < this.gkZ.getChildCount()) {
                view = this.gkZ.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).J(0).F(true).G(false).E(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.l.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        l.this.gkN.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(l.this.gkN.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(l.this.gkN.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.l.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c fI = dVar.fI();
                fI.setShouldCheckLocInWindow(false);
                fI.show(this.gkN.getActivity());
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fI != null) {
                            fI.dismiss();
                        }
                    }
                }, 4000L);
                this.glJ = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.glC != null) {
            this.glC.setDeleteCallback(aVar);
        }
    }

    public void bCG() {
        if (this.glC != null) {
            this.glC.bCG();
        }
    }

    public void aTB() {
        if (this.glC != null) {
            this.glC.aTB();
        }
    }

    public void aA(String str, int i) {
        if (this.glE == null) {
            this.glE = new TextView(this.gkN.getActivity());
            this.glE.setGravity(19);
            this.glE.setPadding(com.baidu.adp.lib.util.l.getDimens(this.gkN.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.gkN.getActivity(), R.dimen.ds34), 0);
            this.glE.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gkN.getActivity(), R.dimen.tbds112)));
            this.glE.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.gkN.getActivity(), R.dimen.fontsize30));
            this.glE.setMaxLines(2);
            this.glE.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.glE.setTextColor(ContextCompat.getColor(this.gkN.getActivity(), R.color.cp_cont_a));
        }
        this.glD.setBackgroundColor(i);
        this.glE.setText(str);
        this.glD.a(this.gkN.getActivity(), this.glE, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Cf != null) {
            this.Cf.setExpanded(z);
        }
    }

    public void bCH() {
        if (this.mPullView != null) {
            this.mPullView.aFg();
        }
        startPullRefresh();
    }

    public void qZ() {
        if (bCy() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bCy().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.cMS != 0 && biVar.cMR != null && this.gkN.bBd() != null && this.gkN.bBd().bGh() != null) {
                            int[] imageWidthAndHeight = this.gkN.bBd().bGh().imageWidthAndHeight(biVar.cMR);
                            biVar.cMS = imageWidthAndHeight[0];
                            biVar.cMT = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.l.5
                    @Override // java.lang.Runnable
                    public void run() {
                        l.this.bCy().notifyDataSetChanged();
                        if (!l.this.mIsBackground) {
                            l.this.glq.a(l.this.gkE, l.this.efC, l.this.glj, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bCI() {
        if (this.glk == null) {
            return false;
        }
        return this.glk.bCI();
    }

    public Context getContext() {
        if (this.gkN == null) {
            return null;
        }
        return this.gkN.getTbPageContext().getPageActivity();
    }
}
