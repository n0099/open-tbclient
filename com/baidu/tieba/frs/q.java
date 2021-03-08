package com.baidu.tieba.frs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cl;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsMoveAreaBottomMenuView;
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class q {
    private AppBarLayout abf;
    private PbListView gCf;
    private NoNetworkView gzT;
    private ImageView iFe;
    private MessageRedDotView iFf;
    private com.baidu.tieba.play.i iRf;
    private CommonTipView iSa;
    private com.baidu.adp.widget.ListView.l iTc;
    private FrsFragment jkB;
    private View jkF;
    private com.baidu.tieba.c.d jkG;
    private ImageView jkH;
    private ImageView jkI;
    private TextView jkJ;
    private ViewStub jkK;
    private BdTypeRecyclerView jkO;
    private com.baidu.tieba.frs.entelechy.adapter.al jkP;
    private com.baidu.tieba.frs.vc.k jkQ;
    private View.OnClickListener jkS;
    private View jkT;
    private View jkU;
    private int jkW;
    private com.baidu.tieba.frs.vc.d jkY;
    private com.baidu.tieba.frs.entelechy.a.c jkZ;
    private com.baidu.tieba.frs.vc.m jla;
    private GifView jlb;
    private TbImageView jlc;
    private HashSet<String> jld;
    private ObservedChangeLinearLayout jlf;
    private com.baidu.tieba.frs.entelechy.a.a jlg;
    private com.baidu.tieba.video.e jlh;
    private AppBarLayoutStickyBehavior jli;
    private FrsHeaderViewContainer jlj;
    private CollapsingToolbarLayout jlk;
    private com.baidu.tieba.frs.vc.h jlo;
    private FrsMultiDelBottomMenuView jlp;
    private FrsMoveAreaBottomMenuView jlq;
    private NavigationBarCoverTip jlr;
    private TextView jls;
    private TextView jlt;
    private boolean jly;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout jkC = null;
    private CoordinatorLayout jkD = null;
    private View jkE = null;
    private FrameLayout jkL = null;
    private TbImageView jkM = null;
    private TbImageView jkN = null;
    private com.baidu.tbadk.core.dialog.b jkR = null;
    private NoNetworkView.a jfq = null;
    private boolean jkV = true;
    private boolean mHasMore = true;
    private boolean jkX = false;
    private int jkn = 0;
    private int gAO = 0;
    private View bMJ = null;
    private View jle = null;
    private boolean hms = false;
    private boolean ers = true;
    private boolean jll = true;
    private int jlm = -1;
    private int jln = -1;
    private int jlu = 0;
    private int jlv = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener iTe = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.iTc == null) {
                        q.this.iTc = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
                    }
                    q.this.iTc.a(q.this.jkO, 2);
                } else if (q.this.iTc != null) {
                    q.this.iTc.qJ();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jlw = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.jkQ != null) {
                q.this.jkQ.setInterceptScrollDown(i == 0);
            }
            if (q.this.jln != i && Math.abs(i) >= 0 && q.this.cDK() != -1) {
                if (Math.abs(i) >= q.this.cDK()) {
                    if (q.this.jll) {
                        q.this.jll = false;
                        q.this.qB(q.this.jll);
                    }
                } else if (!q.this.jll) {
                    q.this.jll = true;
                    q.this.qB(q.this.jll);
                }
                int cDG = q.this.cDG() + q.this.cDF() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cDG;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.jln - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.yE(Math.abs(cDG - totalScrollRange2));
                        if (q.this.jle != null) {
                            q.this.jle.setVisibility(0);
                        }
                    } else if (q.this.jle != null) {
                        if (q.this.cDE() != UtilHelper.getStatusBarHeight()) {
                            q.this.yE(0);
                        }
                        q.this.jle.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.hms) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.qG(false);
                        } else if (q.this.jlt != null) {
                            q.this.jlt.setAlpha(abs);
                        }
                    }
                    q.this.jln = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.jkQ != null) {
                int cLL = q.this.jkQ.cLL();
                int cLM = cLL - q.this.jkQ.cLM();
                if (cLL > 0 && Math.abs(i) >= cLM) {
                    q.this.jkQ.dismissLoading();
                }
            }
        }
    };
    private Runnable jlx = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.jkK != null) {
                q.this.jkL.setVisibility(0);
                q.this.jkN.setVisibility(0);
                q.this.jkM.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.jkB != null && appBarLayout != null && this.jkB.cCF() != null && this.jkB.getPageContext() != null) {
            int cDF = cDF() + getNavigationBarHeight() + cDG();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cCF = this.jkB.cCF();
            ViewGroup.LayoutParams layoutParams = this.jkE.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.jkB != null && this.jkB.cCM();
            if (totalScrollRange <= 0) {
                if (this.jlv != 2) {
                    cCF.AK(2);
                }
                this.jlv = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cDF) {
                if (this.jlv != 1) {
                    cCF.AK(1);
                }
                this.jlv = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.jlv != 0) {
                    cCF.AK(0);
                }
                this.jlv = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.jkB.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.jkE.setLayoutParams(marginLayoutParams);
            }
            Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i + "]");
        }
    }

    public ObservedChangeLinearLayout cDC() {
        return this.jlf;
    }

    public View Up() {
        return this.bMJ;
    }

    public View cDD() {
        return this.jle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDE() {
        if (this.bMJ == null) {
            return 0;
        }
        return this.bMJ.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDF() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDG() {
        if (this.gzT == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gzT.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE(int i) {
        View Up = Up();
        View cDD = cDD();
        if (UtilHelper.canUseStyleImmersiveSticky() && Up != null && cDD != null && Up.getLayoutParams() != null && cDD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Up.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Up.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cDD.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cDD.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.a.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.jkB = null;
        this.jkS = null;
        this.jkW = 0;
        this.jkB = frsFragment;
        this.jkS = onClickListener;
        MessageManager.getInstance().registerListener(this.iTe);
        a(aVar, z);
        this.jld = new HashSet<>();
        this.jkW = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.jlo = hVar;
    }

    private boolean cDH() {
        return this.jlo != null && this.jlo.cLs();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.a.a aVar, boolean z) {
        boolean z2;
        this.jlg = aVar;
        View rootView = this.jkB.getRootView();
        if (this.jkC == null) {
            this.jkC = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.jkE == null) {
            this.jkE = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.jkD == null) {
            this.jkD = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.jkU == null) {
            this.jkU = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.jlk == null) {
            this.jlk = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.jlj == null) {
            this.jlj = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.jkQ == null) {
            this.jkQ = new com.baidu.tieba.frs.vc.k(this.jkB);
        }
        if (this.jlf == null) {
            this.jlf = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jlf.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.jlk.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) rootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            this.mNavigationBar.setContentPaddingTop(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds24));
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.jkB.cDp()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.jkT == null) {
            this.jkT = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.a.b cGf = aVar.cGf();
            if (cGf != null) {
                cGf.cV(this.jkT);
            }
        }
        if (this.jkF == null) {
            this.jkF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jkF.setOnClickListener(this.jkS);
            this.mBackImageView = (ImageView) this.jkF.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jkI == null) {
            this.jkI = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bsU().a(this.jkI, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jkI.setOnClickListener(this.jkS);
        }
        if (this.jkG == null) {
            this.jkG = new com.baidu.tieba.c.d(this.jkB.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jkG.getView(), (View.OnClickListener) null);
            this.iFe = this.jkG.ctK();
            this.iFf = this.jkG.ctL();
            this.iFf.setShadowEnabled(false);
            this.jkG.getView().setOnClickListener(this.jkS);
            this.jkG.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.jkH == null) {
            this.jkH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bsU().a(this.jkH, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jkH.setOnClickListener(this.jkS);
        }
        if (this.jkJ == null) {
            this.jkJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.jkJ.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jkB.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jkJ.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.l(this.jkJ, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jkJ, R.color.CAM_X0101);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.jkB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.jkO == null) {
            this.jkO = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int jlB = 0;

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.jlB--;
                if (this.jlB == 0) {
                    q.this.jkO.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.jlB++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.jkO.setItemAnimator(defaultItemAnimator);
        this.jkO.setLayoutManager(new LinearLayoutManager(this.jkO.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iTc = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
            this.iTc.a(this.jkO, 2);
        }
        this.jkO.setScrollable(this.jkB);
        this.jkO.setFadingEdgeLength(0);
        this.jkO.setOverScrollMode(2);
        this.jkC.setBottomOrderView(this.jkO);
        this.jkO.setOnTouchListener(this.jkB.bUt);
        this.jkO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iRf != null) {
                    q.this.iRf.dt(view);
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
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.jkO.setPadding(dimenPixelSize, this.jkO.getPaddingTop(), dimenPixelSize, this.jkO.getPaddingBottom());
        if (this.gCf == null) {
            this.gCf = new PbListView(this.jkB.getPageContext().getPageActivity());
            this.gCf.getView();
        }
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jkB.getActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jkO.setOnSrollToBottomListener(this.jkB);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.jkB.cDi();
                if (q.this.jkB != null && q.this.abf != null) {
                    q.this.jkB.cDs();
                    q.this.abf.setExpanded(true);
                    if (q.this.iRf != null) {
                        q.this.iRf.b(q.this.jkn, q.this.gAO, false, true);
                    }
                }
            }
        });
        boolean bsW = com.baidu.tbadk.core.util.av.bsV().bsW();
        if (this.jkP == null) {
            this.jkP = aVar.a(this.jkB, this.jkO, bsW);
        }
        if (this.jkQ != null) {
            this.jkQ.Q(1, false);
        }
        if (!z) {
            if (this.gzT == null) {
                this.gzT = new NoNetworkView(this.jkB.getActivity());
                this.gzT.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.jlf.addView(this.gzT);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gzT.setVisibility(8);
            } else {
                this.gzT.setVisibility(0);
            }
            this.gzT.onChangeSkinType(this.jkB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cDR();
        if (this.jkY == null) {
            this.jkY = aVar.a(this.jkB, this.jkC);
            this.jkY.b(this.jkB.cDt());
        }
        if (this.jkZ == null) {
            this.jkZ = aVar.b(this.jkB, this.jkC);
            qE(true);
        }
        if (this.bMJ == null) {
            this.bMJ = rootView.findViewById(R.id.statebar_view);
        }
        if (this.jle == null) {
            this.jle = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iRf == null) {
            this.iRf = new com.baidu.tieba.play.i(this.jkB.getPageContext(), this.jkO);
        }
        this.iRf.Hr(1);
        this.iRf.setUniqueId(this.jkB.getUniqueId());
        this.jlr = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.jla == null) {
            this.jla = new com.baidu.tieba.frs.vc.m(this.jkB, this.jlr);
        }
        if (this.abf == null) {
            this.abf = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.abf.addOnOffsetChangedListener(this.jlw);
            this.jll = true;
            this.jlm = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.abf.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.jli = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.jlp = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.jlp.setPageContext(this.jkB.getPageContext());
        this.jlq = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.jlq.setPageContext(this.jkB.getPageContext());
        if (this.jlt == null) {
            this.jlt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jkB.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.jlt.setLayoutParams(layoutParams2);
            this.jlt.setPadding(0, 0, this.jkB.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.jlt.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
    }

    public void cb(boolean z) {
        if (z) {
        }
    }

    private void cDI() {
        ViewGroup.LayoutParams layoutParams;
        this.hms = cDH();
        if (this.jlj != null && (layoutParams = this.jlj.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.hms) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cDF(), 0, 0);
            }
            this.jlj.requestLayout();
        }
    }

    public void cDJ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.jlf != null) {
            cDI();
            if (this.hms) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bMJ != null) {
                    this.bMJ.setAlpha(1.0f);
                }
                if (this.jle != null) {
                    this.jle.setAlpha(1.0f);
                }
                if (this.jlt != null) {
                    this.jlt.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(boolean z) {
        if (z && this.jkB != null && this.jkB.cCE() != null) {
            this.jkB.cCE().cLz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDK() {
        int i;
        if (this.abf == null) {
            return this.jlm;
        }
        if (this.jlm != -1) {
            return this.jlm;
        }
        int childCount = this.abf.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.abf.getChildAt(childCount);
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
        this.jlm = Math.max(0, this.abf.getTotalScrollRange() - Math.abs(i2));
        return this.jlm;
    }

    public void Kr(String str) {
        if (this.jla != null) {
            this.jla.Kr(str);
        }
    }

    public com.baidu.tieba.play.i cDL() {
        return this.iRf;
    }

    public com.baidu.tieba.frs.entelechy.a.c cDM() {
        return this.jkZ;
    }

    public void qC(boolean z) {
        if (this.jkY != null) {
            if (com.baidu.tbadk.k.d.bCE().bCF()) {
                this.jkY.qC(false);
            } else {
                this.jkY.qC(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cDN() {
        return this.jkY;
    }

    public void aa(boolean z, boolean z2) {
        if (this.ers && this.jkZ != null) {
            this.jkZ.aa(z, z2);
        }
    }

    public void qD(boolean z) {
        this.ers = z;
        if (!this.ers && this.jkZ != null) {
            this.jkZ.aa(false, false);
        }
    }

    public void cDO() {
        if (this.ers && this.jkZ != null) {
            this.jkZ.aa(false, false);
        }
        yF(8);
        this.jkI.setVisibility(8);
        this.jkH.setVisibility(8);
        qC(false);
        this.jkO.setVisibility(8);
        this.jlj.setVisibility(8);
    }

    public void cDP() {
        if (this.ers && this.jkZ != null) {
            this.jkZ.aa(true, false);
        }
        yF(0);
        cDQ();
        qC(this.jkB.cDv());
        this.jkO.setVisibility(0);
        this.jlj.setVisibility(0);
    }

    private void yF(int i) {
        if (this.jkG != null) {
            this.jkG.setVisibility(i);
        }
    }

    private void cDQ() {
        this.jkI.setVisibility(0);
        this.jkH.setVisibility(0);
    }

    public void qE(boolean z) {
        if (this.jkZ != null) {
            this.jkZ.rg(z);
        }
    }

    private void cDR() {
        if (this.jlb == null) {
            View rootView = this.jkB.getRootView();
            this.jlb = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.jlc = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.jlc.setPageId(this.jkB.getUniqueId());
            this.jlb.setLayerType(1, null);
            this.jlc.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cDS() {
        return this.jkF;
    }

    public void g(NoNetworkView.a aVar) {
        this.jfq = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jfq);
        }
    }

    public void qF(boolean z) {
        if (this.jkZ != null) {
            if (z) {
                aa(false, true);
            } else {
                aa(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jkO.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.jkP.a(wVar);
    }

    public void setForumName(String str) {
        this.jkP.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iTe);
        if (this.iRf != null) {
            this.iRf.destroy();
        }
        if (this.jla != null) {
            this.jla.onDestory();
        }
        if (this.jlp != null) {
            this.jlp.setPageContext(null);
        }
        if (this.jlq != null) {
            this.jlq.setPageContext(null);
        }
        this.jkP.onDestory();
        this.jkO.setOnSrollToBottomListener(null);
        this.jkO.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.jlx);
        if (this.iSa != null) {
            this.iSa.onDestroy();
        }
        this.jld.clear();
        if (this.jkY != null) {
            this.jkY.cLd();
        }
        if (this.jlh != null) {
            this.jlh.cFK();
        }
        if (this.jlr != null) {
            this.jlr.onDestroy();
        }
        if (this.jlp != null) {
            this.jlp.onDestroy();
        }
        if (this.jkQ != null) {
            this.jkQ.onDestroy();
        }
    }

    public boolean cDT() {
        if (this.abf == null || this.jli == null || !this.jli.isSticky()) {
            return this.jkY != null && this.jkY.cDT();
        }
        if (this.jkO != null) {
            this.jkO.setSelection(0);
        }
        this.jli.expandedAppBarLayout(this.abf);
        return true;
    }

    public boolean cDn() {
        if (this.jkQ == null) {
            return false;
        }
        return this.jkQ.cDn();
    }

    public void bYu() {
        this.jkO.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.jlt.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.jlt.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.jlt.setText(str2);
            com.baidu.tbadk.core.k.bkV().setForumNameForWaterImage(str);
        }
    }

    public void cDU() {
        if (this.jkP != null) {
            this.jkP.notifyDataSetChanged();
        }
    }

    public void bbE() {
        if (this.jkP instanceof com.baidu.tieba.frs.entelechy.adapter.u) {
            ((com.baidu.tieba.frs.entelechy.adapter.u) this.jkP).bbE();
        }
    }

    private void cDV() {
        if (this.jkR == null && this.jkB.getPageContext() != null) {
            String[] strArr = {this.jkB.getPageContext().getPageActivity().getString(R.string.take_photo), this.jkB.getPageContext().getPageActivity().getString(R.string.album)};
            this.jkR = new com.baidu.tbadk.core.dialog.b(this.jkB.getPageContext().getPageActivity());
            this.jkR.AC(this.jkB.getPageContext().getPageActivity().getString(R.string.operation));
            this.jkR.a(strArr, new b.InterfaceC0564b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.jkB.cDo();
                    } else if (i == 1 && q.this.jkB.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.jkB.getPageContext().getPageActivity());
                    }
                }
            });
            this.jkR.d(this.jkB.getPageContext());
        }
    }

    public void cDW() {
        cDV();
        if (this.jkR != null) {
            this.jkR.bqB();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.y.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                s sVar = new s();
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList3 = new ArrayList<>();
                arrayList3.add(sVar);
                if (this.jkB != null && this.jkB.cCC() != null && this.jkB.cCC().cJL() == 0) {
                    sVar.yQ(this.jkB.cCC().cJS());
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = switchThreadDataToThreadCardInfo;
            }
            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.n nVar = arrayList2.get(i2);
                    if (nVar instanceof ca) {
                        ((ca) nVar).eLr.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.jkP.b(arrayList2, frsViewData);
            if (this.iRf != null && this.jkn != 0) {
                this.iRf.b(this.jkn, this.gAO, this.jkX, true);
            }
            if (this.jkB != null) {
                this.jkB.cDy();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.jkO;
    }

    public void cDX() {
        this.jkP.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jkB.getPageContext(), 1);
        aVar.a(this.jkO);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.jkB.getForumName());
        hashMap.put("forum_id", this.jkB.getForumId());
        aVar.setParams(hashMap);
        aVar.aF(afVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.jkY != null) {
            this.jkY.cLe();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        yG(TbadkCoreApplication.getInst().getSkinType());
        if (this.jkY != null) {
            this.jkY.cLf();
        }
    }

    public void release() {
        if (this.gzT != null && this.jfq != null) {
            this.gzT.b(this.jfq);
        }
    }

    public ImageView cDY() {
        return this.jkI;
    }

    public ImageView cDZ() {
        return this.jkH;
    }

    public TextView cEa() {
        return this.jkJ;
    }

    public View cEb() {
        if (this.jkG != null) {
            return this.jkG.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.jkG != null) {
            this.jkG.z(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.jkB, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jkB.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.jlc != null) {
            this.jlc.invalidate();
        }
        if (this.jkP != null) {
            this.jkP.cGK();
            this.jkP.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.jkB.getPageContext(), this.jkC);
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(this.jkB.getPageContext(), i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.jlt != null) {
            this.jlt.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
        yG(i);
        if (this.jkZ != null) {
            this.jkZ.onChangeSkinType(i);
        }
        if (this.jkY != null) {
            this.jkY.onChangeSkinType(i);
        }
        if (this.jlp != null) {
            this.jlp.onChangeSkinType();
        }
        if (this.jlq != null) {
            this.jlq.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jkE, R.color.CAM_X0202);
    }

    private void yG(int i) {
        if (this.jkB != null) {
            yH(i);
        }
    }

    private void yH(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jkB.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jkT, R.color.CAM_X0204, i);
            if (this.jkG != null) {
                this.jkG.onChangeSkinType(i);
            }
            if (this.jkI != null) {
                SvgManager.bsU().a(this.jkI, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jkH != null) {
                SvgManager.bsU().a(this.jkH, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bMJ, R.color.CAM_X0207);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jle, R.color.CAM_X0207);
        qG(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hms) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.jlu != 0) {
                    SvgManager.bsU().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bsU().a(this.jkI, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iFe.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
                    SvgManager.bsU().a(this.jkH, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.jlu = 0;
                }
            } else if (z || this.jlu != 1) {
                SvgManager.bsU().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsU().a(this.jkI, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iFe.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0106), (WebPManager.ResourceStateType) null));
                SvgManager.bsU().a(this.jkH, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.jlu = 1;
            }
            cEc();
        }
    }

    private void cEc() {
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
            if (this.jlt != null) {
                this.jlt.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.iFe != null) {
                    this.iFe.setAlpha(f);
                }
                if (this.jkB != null && this.jkB.cCF() != null && this.jlu == 1) {
                    this.jkB.cCF().aO(f);
                }
                if (this.iFf != null) {
                    this.iFf.setAlpha(f);
                }
                if (this.jkI != null) {
                    this.jkI.setAlpha(f);
                }
                if (this.jkH != null) {
                    this.jkH.setAlpha(f);
                }
            }
            if (this.jkJ != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.jkJ.setAlpha(f2);
                this.jkJ.setClickable(f2 > 0.0f);
            }
            if (this.bMJ != null) {
                this.bMJ.setAlpha(alpha);
            }
            if (this.jle != null) {
                this.jle.setAlpha(alpha);
            }
            if (this.jkT != null) {
                this.jkT.setAlpha(alpha);
            }
        }
    }

    public void bRO() {
        if (this.jkQ != null) {
            this.jkQ.bRO();
        }
    }

    public void qH(boolean z) {
        if (this.jkQ != null) {
            this.jkQ.qH(z);
        }
    }

    public void qI(boolean z) {
        this.jkV = z;
        if (this.jkV) {
            this.gCf.setText(this.jkB.getResources().getString(R.string.load_more));
            if (this.jkO.getChildAt(this.jkO.getChildCount() - 1) == this.gCf.getView()) {
                this.gCf.startLoadData();
                this.jkB.bRp();
                return;
            }
            this.gCf.endLoadData();
            return;
        }
        this.gCf.setText(this.jkB.getResources().getString(R.string.load_more_must_after_delete));
        this.gCf.endLoadData();
    }

    public boolean cEd() {
        if (this.jkV) {
            return false;
        }
        this.gCf.setText(this.jkB.getResources().getString(R.string.load_more_must_after_delete));
        this.gCf.endLoadData();
        return true;
    }

    public boolean cEe() {
        return this.jkK != null && this.jkN.getVisibility() == 0;
    }

    public void cEf() {
        if (this.jkK != null) {
            this.jkL.setVisibility(0);
            this.jkN.setVisibility(8);
            this.jkM.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.jlx, 5000L);
        }
    }

    public void a(cl clVar) {
        if (this.jkK == null) {
            View rootView = this.jkB.getRootView();
            this.jkK = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.jkK.setVisibility(0);
            this.jkL = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.jkM = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.jkN = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.jkM.setPageId(this.jkB.getUniqueId());
            this.jkN.setPageId(this.jkB.getUniqueId());
            this.jkM.setDefaultBgResource(R.color.common_color_10022);
            this.jkM.setDefaultResource(0);
            this.jkN.setDefaultBgResource(R.color.common_color_10022);
            this.jkN.setDefaultResource(0);
            this.jkL.setOnClickListener(this.jkS);
        }
        this.jkL.setVisibility(0);
        String bqn = clVar.bqn();
        String bqo = clVar.bqo();
        this.jkM.startLoad(bqn, 10, false);
        this.jkN.startLoad(bqo, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.jlx, 5000L);
    }

    public void cEg() {
        if (this.jkK != null && this.jkL != null) {
            this.jkL.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.adapter.al cEh() {
        return this.jkP;
    }

    public RelativeLayout cnA() {
        return this.jkC;
    }

    public View cEi() {
        return this.jkU;
    }

    public void yI(int i) {
        if (this.jkE != null) {
            this.jkE.setVisibility(i);
        }
    }

    public NavigationBar bVq() {
        return this.mNavigationBar;
    }

    public void Xa() {
        this.mHasMore = true;
        this.jkO.setNextPage(this.gCf);
        if (this.jkW > 0) {
            this.gCf.showEmptyView(this.jkW);
        }
        this.gCf.setOnClickListener(null);
        this.gCf.startLoadData();
    }

    public void Xb() {
        this.mHasMore = false;
        this.jkO.setNextPage(this.gCf);
        if (this.jkW > 0) {
            this.gCf.showEmptyView(this.jkW);
        }
        this.gCf.setOnClickListener(null);
        this.gCf.endLoadData();
        this.gCf.setText(this.jkB.getResources().getString(R.string.list_has_no_more));
    }

    public void cEj() {
        this.mHasMore = true;
        this.jkO.setNextPage(this.gCf);
        this.gCf.setOnClickListener(this.jkS);
        if (this.jkW > 0) {
            this.gCf.showEmptyView(this.jkW);
        }
        this.gCf.endLoadData();
        this.gCf.setText(this.jkB.getResources().getString(R.string.list_click_load_more));
    }

    public View cEk() {
        if (this.gCf == null) {
            return null;
        }
        return this.gCf.getView();
    }

    public void yJ(int i) {
        if (this.jlp != null) {
            this.jlp.setVisibility(i);
        }
    }

    public void yK(int i) {
        if (this.jlp != null) {
            this.jlp.setSelectNumber(i);
        }
    }

    public void yL(int i) {
        if (this.jlq != null) {
            this.jlq.setVisibility(i);
        }
    }

    public void yM(int i) {
        if (this.jlq != null) {
            this.jlq.setMoveNumber(i);
        }
    }

    public boolean cEl() {
        return this.jlq != null && this.jlq.cNp();
    }

    public void cEm() {
        if (this.jlq != null) {
            this.jlq.cNq();
        }
    }

    public void bSE() {
        this.mHasMore = false;
        this.jkO.setNextPage(null);
    }

    public boolean cEn() {
        return this.gCf.getView().getParent() != null && this.mHasMore;
    }

    public void yN(int i) {
        this.jkW = i;
    }

    public void yO(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.iSa == null) {
                    this.iSa = new CommonTipView(this.jkB.getActivity());
                }
                this.iSa.setText(R.string.frs_login_tip);
                this.iSa.b((FrameLayout) cEi(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void qJ(boolean z) {
        this.mIsBackground = z;
        if (this.iRf != null) {
            boolean z2 = (this.jkB == null || this.jkB.cCF() == null || this.jkB.cCF().cMa() == null) ? true : this.jkB.cCF().cMa().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iRf.tN(false);
                this.iRf.dcS();
                return;
            }
            this.iRf.tN(true);
            this.iRf.b(this.jkn, this.gAO, this.jkX, true);
        }
    }

    public void cn(int i, int i2) {
        if (this.iRf != null) {
            this.iRf.a(i, i2, this.jkX, 1);
        }
    }

    public void co(int i, int i2) {
        this.jkn = i;
        this.gAO = i2;
    }

    public void qK(boolean z) {
        this.jkX = z;
    }

    public void cEo() {
        a(this.jlg, this.jkB.cDp());
        if (this.jkP != null) {
            this.jkP.cGH();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.jkB.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.jlh == null) {
                this.jlh = new com.baidu.tieba.video.e(this.jkB.getActivity(), this.jkC);
            }
            this.jlh.l(postWriteCallBackData);
        }
    }

    public void cEp() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.jly && this.jkB.getActivity() != null && this.jkB.getPageContext() != null) {
            View view = null;
            if (this.jkO != null && (headerViewsCount = this.jkO.getHeaderViewsCount()) < this.jkO.getChildCount()) {
                view = this.jkO.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.jkB.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.jkB.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.jkB.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c lF = dVar.lF();
                lF.setShouldCheckLocInWindow(false);
                lF.show(this.jkB.getActivity());
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lF != null) {
                            lF.dismiss();
                        }
                    }
                }, 4000L);
                this.jly = true;
            }
        }
    }

    public void b(e.a aVar) {
        if (this.jlp != null) {
            this.jlp.setDeleteCallback(aVar);
        }
    }

    public void cEq() {
        if (this.jlp != null) {
            this.jlp.cEq();
        }
    }

    public void bKu() {
        if (this.jlp != null) {
            this.jlp.bKu();
        }
    }

    public void aY(String str, int i) {
        if (this.jls == null) {
            this.jls = new TextView(this.jkB.getActivity());
            this.jls.setGravity(19);
            this.jls.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jkB.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.jkB.getActivity(), R.dimen.ds34), 0);
            this.jls.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jkB.getActivity(), R.dimen.tbds112)));
            this.jls.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.jkB.getActivity(), R.dimen.fontsize30));
            this.jls.setMaxLines(2);
            this.jls.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.jls.setTextColor(ContextCompat.getColor(this.jkB.getActivity(), R.color.CAM_X0101));
        }
        this.jlr.setBackgroundColor(i);
        this.jls.setText(str);
        this.jlr.a(this.jkB.getActivity(), this.jls, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.abf != null) {
            this.abf.setExpanded(z);
        }
    }

    public void cEr() {
        if (this.jkQ != null) {
            this.jkQ.startPullRefresh();
        }
    }

    public void EN() {
        if (cEh() != null) {
            List<com.baidu.adp.widget.ListView.n> datas = cEh().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.n nVar : datas) {
                    if (nVar instanceof ca) {
                        ca caVar = (ca) nVar;
                        if (caVar.eRK != 0 && caVar.eLr != null && this.jkB.cCC() != null && this.jkB.cCC().cJo() != null) {
                            int[] imageWidthAndHeight = caVar.eLr.getImageWidthAndHeight();
                            caVar.eRK = imageWidthAndHeight[0];
                            caVar.eRL = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cEh().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iRf.b(q.this.jkn, q.this.gAO, q.this.jkX, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cEs() {
        if (this.jkY == null) {
            return false;
        }
        return this.jkY.cEs();
    }

    public Context getContext() {
        if (this.jkB == null) {
            return null;
        }
        return this.jkB.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.jkQ != null) {
            this.jkQ.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.jkQ != null) {
            this.jkQ.startPullRefresh();
        }
    }

    public void cEt() {
        if (this.jkQ != null) {
            this.jkQ.cEt();
        }
    }

    public void cEu() {
        if (this.jkQ != null) {
            this.jkQ.cEu();
        }
    }

    public void a(aq aqVar) {
        if (this.jkQ != null) {
            this.jkQ.a(aqVar);
        }
    }

    public void yP(int i) {
        if (this.jkQ != null) {
            this.jkQ.yP(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cEv() {
        return this.jkQ;
    }

    public boolean cEw() {
        if (this.jkQ != null) {
            return this.jkQ.cLP() instanceof FrsNewAreaFragment;
        }
        return false;
    }
}
