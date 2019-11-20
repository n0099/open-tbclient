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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
    private PbListView dvS;
    private BdSwipeRefreshLayout dxt;
    private ImageView eVk;
    private NoNetworkView faF;
    private CommonTipView ffv;
    private com.baidu.adp.widget.ListView.k fgw;
    private BdTypeRecyclerView fwC;
    private com.baidu.tieba.frs.entelechy.a.aa fwD;
    private FloatingAnimationView fwE;
    private com.baidu.tieba.c.c fwF;
    private View.OnClickListener fwH;
    private View fwI;
    private View fwJ;
    private int fwL;
    private com.baidu.tieba.frs.vc.d fwN;
    private com.baidu.tieba.frs.entelechy.b.c fwO;
    private com.baidu.tieba.frs.vc.j fwP;
    private GifView fwQ;
    private TbImageView fwR;
    private HashSet<String> fwS;
    private com.baidu.tieba.play.m fwT;
    private ObservedChangeLinearLayout fwV;
    private com.baidu.tieba.frs.entelechy.b.a fwW;
    private com.baidu.tieba.video.f fwX;
    private AppBarLayoutStickyBehavior fwY;
    private FrsHeaderViewContainer fwZ;
    private FrsFragment fwq;
    private View fwu;
    private com.baidu.tieba.c.b fwv;
    private ImageView fww;
    private TextView fwx;
    private ViewStub fwy;
    private CollapsingToolbarLayout fxa;
    private com.baidu.tieba.frs.vc.f fxe;
    private FrsMultiDelBottomMenuView fxf;
    private NavigationBarCoverTip fxg;
    private TextView fxh;
    private boolean fxm;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.i mPullView;
    private int mSkinType;
    private AppBarLayout zA;
    private boolean fwp = false;
    private NoPressedRelativeLayout fwr = null;
    private CoordinatorLayout fws = null;
    private View fwt = null;
    private FrameLayout fwz = null;
    private TbImageView fwA = null;
    private TbImageView fwB = null;
    private com.baidu.tbadk.core.dialog.b fwG = null;
    private NoNetworkView.a fsc = null;
    private boolean fwK = true;
    private boolean mHasMore = true;
    private boolean fwM = false;
    private int fwh = 0;
    private int duA = 0;
    private View apj = null;
    private View fwU = null;
    private boolean dQy = false;
    private boolean bHg = true;
    private boolean fxb = true;
    private int fxc = -1;
    private int fxd = -1;
    private int fxi = 0;
    private int fxj = 0;
    private boolean mIsPrivateForum = false;
    private boolean mIsBackground = false;
    private CustomMessageListener fgy = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.k.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (k.this.fgw == null) {
                        k.this.fgw = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    k.this.fgw.a(k.this.fwC, 2);
                } else if (k.this.fgw != null) {
                    k.this.fgw.jU();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener fxk = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.k.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            k.this.a(appBarLayout, i);
            if (k.this.fxd != i && Math.abs(i) >= 0 && k.this.bkG() != -1) {
                if (Math.abs(i) >= k.this.bkG()) {
                    if (k.this.fxb) {
                        k.this.fxb = false;
                        k.this.jK(k.this.fxb);
                    }
                } else if (!k.this.fxb) {
                    k.this.fxb = true;
                    k.this.jK(k.this.fxb);
                }
                int bkC = k.this.bkC() + k.this.bkB() + k.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bkC;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && k.this.fxd - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        k.this.qq(Math.abs(bkC - totalScrollRange2));
                        if (k.this.fwU != null) {
                            k.this.fwU.setVisibility(0);
                        }
                    } else if (k.this.fwU != null) {
                        if (k.this.bkA() != UtilHelper.getStatusBarHeight()) {
                            k.this.qq(0);
                        }
                        k.this.fwU.setVisibility(8);
                    }
                    if (k.this.mNavigationBar != null) {
                        if (k.this.dQy) {
                            k.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            k.this.jP(false);
                        } else if (k.this.mNavigationBar.mCenterText != null) {
                            k.this.mNavigationBar.mCenterText.setAlpha(abs);
                        }
                    }
                    k.this.fxd = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                }
            }
        }
    };
    private Runnable fxl = new Runnable() { // from class: com.baidu.tieba.frs.k.13
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.fwy != null) {
                k.this.fwz.setVisibility(0);
                k.this.fwB.setVisibility(0);
                k.this.fwA.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.fwq != null && appBarLayout != null && this.fwq.bjL() != null && this.fwq.getPageContext() != null) {
            int bkB = bkB() + getNavigationBarHeight() + bkC();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bjL = this.fwq.bjL();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.fwq.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.fwq.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.fwt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.fwq != null && this.fwq.bjS();
            if (totalScrollRange <= 0) {
                if (this.fxj != 2) {
                    bjL.sa(2);
                }
                this.fxj = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bkB) {
                if (this.fxj != 1) {
                    bjL.sa(1);
                }
                this.fxj = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.fxj != 0) {
                    bjL.sa(0);
                }
                this.fxj = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.fwq.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.fwt.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bky() {
        return this.fwV;
    }

    public View vF() {
        return this.apj;
    }

    public View bkz() {
        return this.fwU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkA() {
        if (this.apj == null) {
            return 0;
        }
        return this.apj.getHeight();
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
        if (this.faF == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.faF.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq(int i) {
        View vF = vF();
        View bkz = bkz();
        if (UtilHelper.canUseStyleImmersiveSticky() && vF != null && bkz != null && vF.getLayoutParams() != null && bkz.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = vF.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            vF.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bkz.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bkz.setLayoutParams(layoutParams2);
        }
    }

    public k(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.f fVar) {
        this.fwq = null;
        this.fwH = null;
        this.fwL = 0;
        this.fwq = frsFragment;
        this.fwH = onClickListener;
        MessageManager.getInstance().registerListener(this.fgy);
        a(aVar, z);
        this.fwS = new HashSet<>();
        this.fwL = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.fxe = fVar;
    }

    private boolean bkD() {
        return this.fxe != null && this.fxe.bqv();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.fwW = aVar;
        View rootView = this.fwq.getRootView();
        if (this.fwr == null) {
            this.fwr = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.fwt == null) {
            this.fwt = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.fws == null) {
            this.fws = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.fwJ == null) {
            this.fwJ = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.fxa == null) {
            this.fxa = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.fwZ == null) {
            this.fwZ = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.fwV == null) {
            this.fwV = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.fwV.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.fxa.setMinimumHeight(i2);
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
        if (this.fwq.bkp()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.fwI == null) {
            this.fwI = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bmE = aVar.bmE();
            if (bmE != null) {
                bmE.bP(this.fwI);
            }
        }
        if (this.fwu == null) {
            this.fwu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.fwu.setOnClickListener(this.fwH);
            this.mBackImageView = (ImageView) this.fwu.findViewById(R.id.widget_navi_back_button);
        }
        if (this.fwv == null) {
            this.fwv = new com.baidu.tieba.c.b(this.fwq.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.fwv.getView(), (View.OnClickListener) null);
            this.eVk = this.fwv.bcb();
            this.fwv.getView().setOnClickListener(this.fwH);
        }
        if (this.fww == null) {
            this.fww = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_private_more, (View.OnClickListener) null);
            this.fww.setOnClickListener(this.fwH);
        }
        if (this.fwx == null) {
            this.fwx = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.fwx.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.fwq.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.fwx.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.d(this.fwx, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.fwx, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.fwq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.fwq.getPageContext());
        }
        this.mPullView.setTag(this.fwq.getUniqueId());
        if (this.dxt == null) {
            this.dxt = (BdSwipeRefreshLayout) rootView.findViewById(R.id.frs_pull_refresh_layout);
            this.dxt.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.dxt, R.color.cp_bg_line_c);
        }
        if (this.fwC == null) {
            this.fwC = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.k.8
            int fxp = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.fxp--;
                if (this.fxp == 0) {
                    k.this.fwC.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.fxp++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.fwC.setItemAnimator(defaultItemAnimator);
        this.fwC.setLayoutManager(new LinearLayoutManager(this.fwC.getContext()) { // from class: com.baidu.tieba.frs.k.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.fgw = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.fgw.a(this.fwC, 2);
        }
        this.fwC.setScrollable(this.fwq);
        this.fwC.setFadingEdgeLength(0);
        this.fwC.setOverScrollMode(2);
        this.fwr.setBottomOrderView(this.fwC);
        this.fwC.setOnTouchListener(this.fwq.czy);
        this.fwC.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.fwT != null) {
                    k.this.fwT.ck(view);
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
        if (this.dvS == null) {
            this.dvS = new PbListView(this.fwq.getPageContext().getPageActivity());
            this.dvS.getView();
        }
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.dvS.setHeight(com.baidu.adp.lib.util.l.getDimens(this.fwq.getActivity(), R.dimen.tbds182));
        this.dvS.setLineGone();
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fwC.setOnSrollToBottomListener(this.fwq);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.k.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.fwq.bkj();
                if (k.this.fwq != null && k.this.zA != null) {
                    k.this.fwq.bkr();
                    k.this.zA.setExpanded(true);
                    if (k.this.fwT != null) {
                        k.this.fwT.c(k.this.fwh, k.this.duA, false, true);
                    }
                }
            }
        });
        boolean isFrsShowBigImage = com.baidu.tbadk.core.util.ar.amM().isFrsShowBigImage();
        if (this.fwD == null) {
            this.fwD = aVar.a(this.fwq, this.fwC, isFrsShowBigImage);
        }
        fU(false);
        if (!z) {
            if (this.faF == null) {
                this.faF = new NoNetworkView(this.fwq.getActivity());
                this.faF.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.fwV.addView(this.faF);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.faF.setVisibility(8);
            } else {
                this.faF.setVisibility(0);
            }
            this.faF.onChangeSkinType(this.fwq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bkN();
        if (this.fwN == null) {
            this.fwN = aVar.a(this.fwq, this.fwr);
            this.fwN.b(this.fwq.bks());
        }
        if (this.fwO == null) {
            this.fwO = aVar.b(this.fwq, this.fwr);
            jN(true);
        }
        if (this.apj == null) {
            this.apj = rootView.findViewById(R.id.statebar_view);
        }
        if (this.fwU == null) {
            this.fwU = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.fwT == null) {
            this.fwT = new com.baidu.tieba.play.m(this.fwq.getPageContext(), this.fwC);
        }
        this.fwT.setUniqueId(this.fwq.getUniqueId());
        this.fxg = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.fwP == null) {
            this.fwP = new com.baidu.tieba.frs.vc.j(this.fwq, this.fxg);
        }
        if (this.zA == null) {
            this.zA = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.zA.addOnOffsetChangedListener(this.fxk);
            this.fxb = true;
            this.fxc = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.zA.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.fwY = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.fxf = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.fxf.setPageContext(this.fwq.getPageContext());
        this.fwE = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.fwE.setPageId(this.fwq.getUniqueId());
        this.fwF = new com.baidu.tieba.c.c(this.fwq.getTbPageContext(), this.fwE, 2);
    }

    public void jJ(boolean z) {
        if (z && this.fwF != null) {
            this.fwF.aHH();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.fwF != null) {
            this.fwF.a(oVar);
        }
    }

    private void bkE() {
        ViewGroup.LayoutParams layoutParams;
        this.dQy = bkD();
        if (this.fwZ != null && (layoutParams = this.fwZ.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.dQy) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bkB(), 0, 0);
            }
            this.fwZ.requestLayout();
        }
    }

    public void bkF() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fwV != null) {
            bkE();
            if (this.dQy) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.apj != null) {
                    this.apj.setAlpha(1.0f);
                }
                if (this.fwU != null) {
                    this.fwU.setAlpha(1.0f);
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
    public void jK(boolean z) {
        if (z && this.fwq != null && this.fwq.bjK() != null) {
            this.fwq.bjK().bqA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkG() {
        int i;
        if (this.zA == null) {
            return this.fxc;
        }
        if (this.fxc != -1) {
            return this.fxc;
        }
        int childCount = this.zA.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.zA.getChildAt(childCount);
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
        this.fxc = Math.max(0, this.zA.getTotalScrollRange() - Math.abs(i2));
        return this.fxc;
    }

    public void vN(String str) {
        if (this.fwP != null) {
            this.fwP.vN(str);
        }
    }

    public com.baidu.tieba.play.m bkH() {
        return this.fwT;
    }

    public com.baidu.tieba.frs.entelechy.b.c bkI() {
        return this.fwO;
    }

    public void jL(boolean z) {
        if (this.fwN != null) {
            this.fwN.jL(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bkJ() {
        return this.fwN;
    }

    public void K(boolean z, boolean z2) {
        if (this.bHg && this.fwO != null) {
            this.fwO.K(z, z2);
        }
    }

    public void jM(boolean z) {
        this.bHg = z;
        if (!this.bHg && this.fwO != null) {
            this.fwO.K(false, false);
        }
    }

    public void bkK() {
        if (this.bHg && this.fwO != null) {
            this.fwO.K(false, false);
        }
        qr(8);
        this.fww.setVisibility(8);
        jL(false);
        this.fwC.setVisibility(8);
        this.fwZ.setVisibility(8);
    }

    public void bkL() {
        if (this.bHg && this.fwO != null) {
            this.fwO.K(true, false);
        }
        qr(0);
        bkM();
        jL(this.fwq.bku());
        this.fwC.setVisibility(0);
        this.fwZ.setVisibility(0);
    }

    private void qr(int i) {
        if (this.fwv != null) {
            this.fwv.setVisibility(i);
        }
    }

    private void bkM() {
        this.fww.setVisibility(0);
    }

    public void jN(boolean z) {
        if (this.fwO != null) {
            this.fwO.kp(z);
        }
    }

    private void bkN() {
        if (this.fwQ == null) {
            View rootView = this.fwq.getRootView();
            this.fwQ = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.fwR = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.fwR.setPageId(this.fwq.getUniqueId());
            this.fwQ.setLayerType(1, null);
            this.fwR.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bkO() {
        return this.fwu;
    }

    public void h(NoNetworkView.a aVar) {
        this.fsc = aVar;
        if (this.faF != null) {
            this.faF.a(this.fsc);
        }
    }

    public void fU(boolean z) {
        this.fwp = z;
        if (z) {
            if (this.fwO != null) {
                this.fwO.bnh();
                return;
            }
            return;
        }
        this.fwC.getAdapter().notifyDataSetChanged();
        if (this.fwO != null) {
            this.fwO.bni();
        }
    }

    public void jO(boolean z) {
        if (this.fwO != null) {
            if (z) {
                K(false, true);
            } else {
                K(false, false);
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
        this.fwC.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.fwD.a(sVar);
    }

    public void setForumName(String str) {
        this.fwD.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fgy);
        if (this.fwT != null) {
            this.fwT.destroy();
        }
        if (this.fwP != null) {
            this.fwP.onDestory();
        }
        if (this.fxf != null) {
            this.fxf.setPageContext(null);
        }
        this.fwD.onDestory();
        this.fwC.setOnSrollToBottomListener(null);
        this.fwC.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.fxl);
        if (this.ffv != null) {
            this.ffv.onDestroy();
        }
        this.fwS.clear();
        if (this.fwN != null) {
            this.fwN.bqm();
        }
        if (this.fwX != null) {
            this.fwX.bmt();
        }
        if (this.fwF != null) {
            this.fwF.onDestroy();
        }
        if (this.fxg != null) {
            this.fxg.onDestroy();
        }
        if (this.fxf != null) {
            this.fxf.onDestroy();
        }
    }

    public boolean bkP() {
        if (this.zA == null || this.fwY == null || !this.fwY.isSticky()) {
            return this.fwN != null && this.fwN.bkP();
        }
        if (this.fwC != null) {
            this.fwC.setSelection(0);
        }
        this.fwY.expandedAppBarLayout(this.zA);
        return true;
    }

    public boolean bko() {
        return this.fwp;
    }

    public void aMo() {
        this.fwC.setVisibility(0);
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
            com.baidu.tbadk.core.i.ago().setForumNameForWaterImage(str);
        }
    }

    public void bkQ() {
        if (this.fwD != null) {
            this.fwD.notifyDataSetChanged();
        }
    }

    public void aaO() {
        if (this.fwD instanceof com.baidu.tieba.frs.entelechy.a.l) {
            ((com.baidu.tieba.frs.entelechy.a.l) this.fwD).aaO();
        }
    }

    private void bkR() {
        if (this.fwG == null && this.fwq.getPageContext() != null) {
            String[] strArr = {this.fwq.getPageContext().getPageActivity().getString(R.string.take_photo), this.fwq.getPageContext().getPageActivity().getString(R.string.album)};
            this.fwG = new com.baidu.tbadk.core.dialog.b(this.fwq.getPageContext().getPageActivity());
            this.fwG.no(this.fwq.getPageContext().getPageActivity().getString(R.string.operation));
            this.fwG.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.k.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.fwq.takePhoto();
                    } else if (i == 1 && k.this.fwq.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(k.this.fwq.getPageContext().getPageActivity());
                    }
                }
            });
            this.fwG.d(this.fwq.getPageContext());
        }
    }

    public void bkS() {
        bkR();
        if (this.fwG != null) {
            this.fwG.akN();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (com.baidu.tbadk.core.util.v.isEmpty(switchThreadDataToThreadCardInfo)) {
            m mVar = new m();
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
            arrayList3.add(mVar);
            if (this.fwq != null && this.fwq.bjI() != null && this.fwq.bjI().bpg() == 0) {
                mVar.qA(this.fwq.bjI().bpn());
            }
            arrayList2 = arrayList3;
        } else {
            arrayList2 = switchThreadDataToThreadCardInfo;
        }
        if (frsViewData != null) {
            this.mIsPrivateForum = frsViewData.isPrivateForum();
        }
        if (com.baidu.tbadk.core.util.v.getCount(arrayList2) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList2.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.m mVar2 = arrayList2.get(i2);
                if (mVar2 instanceof bg) {
                    ((bg) mVar2).caz.setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.fwD.b(arrayList2, frsViewData);
        if (this.fwT != null && this.fwh != 0) {
            this.fwT.c(this.fwh, this.duA, this.fwM, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fwC;
    }

    public void bkT() {
        this.fwD.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fwq.getPageContext(), 1);
        aVar.a(this.fwC);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.fwq.getForumName());
        hashMap.put("forum_id", this.fwq.getForumId());
        aVar.setParams(hashMap);
        aVar.ag(xVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.fwN != null) {
            this.fwN.bqn();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        qs(TbadkCoreApplication.getInst().getSkinType());
        if (this.fwN != null) {
            this.fwN.bqo();
        }
    }

    public void release() {
        if (this.faF != null && this.fsc != null) {
            this.faF.b(this.fsc);
        }
    }

    public ImageView bkU() {
        return this.fww;
    }

    public TextView bkV() {
        return this.fwx;
    }

    public View bkW() {
        if (this.fwv != null) {
            return this.fwv.getView();
        }
        return null;
    }

    public void C(int i, boolean z) {
        if (this.fwv != null) {
            this.fwv.m(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.fwq, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.fwq.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.fwR != null) {
            this.fwR.invalidate();
        }
        if (this.fwD != null) {
            this.fwD.bnb();
            this.fwD.notifyDataSetChanged();
        }
        com.baidu.tbadk.s.a.a(this.fwq.getPageContext(), this.fwr);
        if (this.faF != null) {
            this.faF.onChangeSkinType(this.fwq.getPageContext(), i);
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.dvS.changeSkin(i);
        }
        qs(i);
        if (this.fwO != null) {
            this.fwO.onChangeSkinType(i);
        }
        if (this.fwN != null) {
            this.fwN.onChangeSkinType(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fxf != null) {
            this.fxf.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.dxt, R.color.cp_bg_line_d);
        if (this.fwq != null && this.fwq.bjS()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.fwt, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.fwt, R.color.cp_bg_line_d);
        }
    }

    private void qs(int i) {
        if (this.fwq != null) {
            qt(i);
        }
    }

    private void qt(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fwq.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.fwI, R.color.cp_bg_line_c, i);
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.apj, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.fwU, R.color.cp_bg_line_h);
        jP(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.dQy) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.fxi != 0) {
                    SvgManager.amL().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.amL().a(this.fww, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.amL().a(this.eVk, R.drawable.icon_pure_topbar_information_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.fxi = 0;
                }
            } else if (z || this.fxi != 1) {
                SvgManager.amL().a(this.mBackImageView, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.amL().a(this.fww, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.amL().a(this.eVk, R.drawable.icon_pure_topbar_information_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.fxi = 1;
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
                if (this.eVk != null) {
                    this.eVk.setAlpha(f);
                }
                if (this.fww != null) {
                    this.fww.setAlpha(f);
                }
            }
            if (this.fwx != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.fwx.setAlpha(f2);
                this.fwx.setClickable(f2 > 0.0f);
            }
            if (this.apj != null) {
                this.apj.setAlpha(alpha);
            }
            if (this.fwU != null) {
                this.fwU.setAlpha(alpha);
            }
            if (this.fwI != null) {
                this.fwI.setAlpha(alpha);
            }
        }
    }

    public void startPullRefresh() {
        if (this.fwC != null) {
            this.fwC.setSelection(0);
        }
        if (this.zA != null) {
            this.zA.setExpanded(true);
        }
        if (this.dxt != null && this.dxt.isEnabled()) {
            this.dxt.setRefreshing(true);
        }
    }

    public void jQ(boolean z) {
        if (z) {
            this.dxt.setRefreshing(false);
        } else {
            this.dxt.interruptRefresh();
        }
    }

    public void jR(boolean z) {
        this.dxt.setEnabled(z);
    }

    public void jS(boolean z) {
        this.fwK = z;
        if (this.fwK) {
            this.dvS.setText(this.fwq.getResources().getString(R.string.load_more));
            if (this.fwC.getChildAt(this.fwC.getChildCount() - 1) == this.dvS.getView()) {
                this.dvS.startLoadData();
                this.fwq.aIU();
                return;
            }
            this.dvS.endLoadData();
            return;
        }
        this.dvS.setText(this.fwq.getResources().getString(R.string.load_more_must_after_delete));
        this.dvS.endLoadData();
    }

    public boolean bkY() {
        if (this.fwK) {
            return false;
        }
        this.dvS.setText(this.fwq.getResources().getString(R.string.load_more_must_after_delete));
        this.dvS.endLoadData();
        return true;
    }

    public boolean bkZ() {
        return this.fwy != null && this.fwB.getVisibility() == 0;
    }

    public void bla() {
        if (this.fwy != null) {
            this.fwz.setVisibility(0);
            this.fwB.setVisibility(8);
            this.fwA.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.fxl, 5000L);
        }
    }

    public void a(bo boVar) {
        if (this.fwy == null) {
            View rootView = this.fwq.getRootView();
            this.fwy = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.fwy.setVisibility(0);
            this.fwz = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.fwA = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.fwB = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.fwA.setPageId(this.fwq.getUniqueId());
            this.fwB.setPageId(this.fwq.getUniqueId());
            this.fwA.setDefaultBgResource(R.color.common_color_10022);
            this.fwA.setDefaultResource(0);
            this.fwB.setDefaultBgResource(R.color.common_color_10022);
            this.fwB.setDefaultResource(0);
            this.fwz.setOnClickListener(this.fwH);
        }
        this.fwz.setVisibility(0);
        String akF = boVar.akF();
        String akG = boVar.akG();
        this.fwA.startLoad(akF, 10, false);
        this.fwB.startLoad(akG, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.fxl, 5000L);
    }

    public void blb() {
        if (this.fwy != null && this.fwz != null) {
            this.fwz.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.aa blc() {
        return this.fwD;
    }

    public RelativeLayout aYb() {
        return this.fwr;
    }

    public View bld() {
        return this.fwJ;
    }

    public void qu(int i) {
        if (this.fwt != null) {
            this.fwt.setVisibility(i);
        }
    }

    public void ble() {
        if (com.baidu.tbadk.p.m.awL().awM()) {
            int lastVisiblePosition = this.fwC.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.fwC.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.fxA != null) {
                        com.baidu.tbadk.p.h perfLog = oVar.fxA.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.cLh = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.fxA.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.fxA.startLogPerf();
                    }
                    if (oVar.fxz != null && (oVar.fxz instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.fxz;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.p.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.cLh = true;
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

    public NavigationBar aKP() {
        return this.mNavigationBar;
    }

    public void aKg() {
        this.mHasMore = true;
        this.fwC.setNextPage(this.dvS);
        if (this.fwL > 0) {
            this.dvS.showEmptyView(this.fwL);
        }
        this.dvS.setOnClickListener(null);
        this.dvS.startLoadData();
    }

    public void aKh() {
        this.mHasMore = false;
        this.fwC.setNextPage(this.dvS);
        if (this.fwL > 0) {
            this.dvS.showEmptyView(this.fwL);
        }
        this.dvS.setOnClickListener(null);
        this.dvS.endLoadData();
        this.dvS.setText(this.fwq.getResources().getString(R.string.list_has_no_more));
    }

    public void blf() {
        this.mHasMore = true;
        this.fwC.setNextPage(this.dvS);
        this.dvS.setOnClickListener(this.fwH);
        if (this.fwL > 0) {
            this.dvS.showEmptyView(this.fwL);
        }
        this.dvS.endLoadData();
        this.dvS.setText(this.fwq.getResources().getString(R.string.list_click_load_more));
    }

    public View blg() {
        if (this.dvS == null) {
            return null;
        }
        return this.dvS.getView();
    }

    public void qv(int i) {
        if (this.fxf != null) {
            this.fxf.setVisibility(i);
        }
    }

    public void qw(int i) {
        if (this.fxf != null) {
            this.fxf.setSelectNumber(i);
        }
    }

    public void aKi() {
        this.mHasMore = false;
        this.fwC.setNextPage(null);
    }

    public boolean bbu() {
        return this.dvS.getView().getParent() != null && this.mHasMore;
    }

    public void qx(int i) {
        this.fwL = i;
    }

    public void qy(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.ffv == null) {
                    this.ffv = new CommonTipView(this.fwq.getActivity());
                }
                this.ffv.setText(R.string.frs_login_tip);
                this.ffv.b((FrameLayout) bld(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void jT(boolean z) {
        this.mIsBackground = z;
        if (this.fwT != null) {
            boolean z2 = (this.fwq == null || this.fwq.bjL() == null || this.fwq.bjL().bqS() == null) ? true : this.fwq.bjL().bqS().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.fwT.mY(false);
                this.fwT.bIU();
                return;
            }
            this.fwT.mY(true);
            this.fwT.c(this.fwh, this.duA, this.fwM, true);
        }
    }

    public void bl(int i, int i2) {
        if (this.fwT != null) {
            this.fwT.a(i, i2, this.fwM, 1);
        }
    }

    public void bm(int i, int i2) {
        this.fwh = i;
        this.duA = i2;
    }

    public void jU(boolean z) {
        this.fwM = z;
    }

    public void qz(int i) {
        if (this.fwC != null && this.fwC.getChildCount() >= 0) {
            if (this.fwC.getFirstVisiblePosition() > 8) {
                this.fwC.scrollToPosition(8);
            }
            this.fwC.smoothScrollToPosition(i);
        }
    }

    public void blh() {
        a(this.fwW, this.fwq.bkp());
        if (this.fwD != null) {
            this.fwD.bmY();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.fwX == null) {
                this.fwX = new com.baidu.tieba.video.f(this.fwq.getActivity(), this.fwr);
            }
            this.fwX.h(postWriteCallBackData);
        }
    }

    public void bli() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.fxm && this.fwq.getActivity() != null && this.fwq.getPageContext() != null) {
            View view = null;
            if (this.fwC != null && (headerViewsCount = this.fwC.getHeaderViewsCount()) < this.fwC.getChildCount()) {
                view = this.fwC.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).I(0).B(true).C(false).A(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        k.this.fwq.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(k.this.fwq.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(k.this.fwq.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c fu = dVar.fu();
                fu.setShouldCheckLocInWindow(false);
                fu.show(this.fwq.getActivity());
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (fu != null) {
                            fu.dismiss();
                        }
                    }
                }, 4000L);
                this.fxm = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.fxf != null) {
            this.fxf.setDeleteCallback(aVar);
        }
    }

    public void blj() {
        if (this.fxf != null) {
            this.fxf.blj();
        }
    }

    public void aBM() {
        if (this.fxf != null) {
            this.fxf.aBM();
        }
    }

    public void ar(String str, int i) {
        if (this.fxh == null) {
            this.fxh = new TextView(this.fwq.getActivity());
            this.fxh.setGravity(19);
            this.fxh.setPadding(com.baidu.adp.lib.util.l.getDimens(this.fwq.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.fwq.getActivity(), R.dimen.ds34), 0);
            this.fxh.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.fwq.getActivity(), R.dimen.tbds112)));
            this.fxh.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.fwq.getActivity(), R.dimen.fontsize30));
            this.fxh.setMaxLines(2);
            this.fxh.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.fxh.setTextColor(ContextCompat.getColor(this.fwq.getActivity(), R.color.cp_cont_a));
        }
        this.fxg.setBackgroundColor(i);
        this.fxh.setText(str);
        this.fxg.a(this.fwq.getActivity(), this.fxh, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.zA != null) {
            this.zA.setExpanded(z);
        }
    }

    public void blk() {
        if (this.zA != null && this.fwC != null) {
            int count = this.fwC.getCount();
            if (this.fwC.getFirstCompletelyVisiblePosition() == 0 && count <= 2) {
                this.zA.setExpanded(true, true);
            }
        }
    }

    public void bll() {
        if (this.mPullView != null) {
            this.mPullView.anO();
        }
        startPullRefresh();
    }

    public void pC() {
        if (blc() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = blc().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bg) {
                        bg bgVar = (bg) mVar;
                        if (bgVar.caA != 0 && bgVar.caz != null && this.fwq.bjI() != null && this.fwq.bjI().boK() != null) {
                            int[] imageWidthAndHeight = this.fwq.bjI().boK().imageWidthAndHeight(bgVar.caz);
                            bgVar.caA = imageWidthAndHeight[0];
                            bgVar.caB = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.5
                    @Override // java.lang.Runnable
                    public void run() {
                        k.this.blc().notifyDataSetChanged();
                        if (!k.this.mIsBackground) {
                            k.this.fwT.c(k.this.fwh, k.this.duA, k.this.fwM, true);
                        }
                    }
                }, 500L);
            }
        }
    }
}
