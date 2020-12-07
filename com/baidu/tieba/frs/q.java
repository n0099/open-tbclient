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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.ci;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes22.dex */
public class q {
    private AppBarLayout Zj;
    private NoNetworkView gpu;
    private PbListView gre;
    private com.baidu.tieba.play.i iBT;
    private CommonTipView iCO;
    private com.baidu.adp.widget.ListView.n iDQ;
    private BdTypeRecyclerView iVD;
    private com.baidu.tieba.frs.entelechy.a.am iVE;
    private com.baidu.tieba.frs.vc.k iVF;
    private View.OnClickListener iVH;
    private View iVI;
    private View iVJ;
    private int iVL;
    private com.baidu.tieba.frs.vc.d iVN;
    private com.baidu.tieba.frs.entelechy.b.c iVO;
    private com.baidu.tieba.frs.vc.m iVP;
    private GifView iVQ;
    private TbImageView iVR;
    private HashSet<String> iVS;
    private ObservedChangeLinearLayout iVU;
    private com.baidu.tieba.frs.entelechy.b.a iVV;
    private com.baidu.tieba.video.f iVW;
    private AppBarLayoutStickyBehavior iVX;
    private FrsHeaderViewContainer iVY;
    private CollapsingToolbarLayout iVZ;
    private FrsFragment iVq;
    private View iVu;
    private com.baidu.tieba.d.d iVv;
    private ImageView iVw;
    private ImageView iVx;
    private TextView iVy;
    private ViewStub iVz;
    private com.baidu.tieba.frs.vc.h iWd;
    private FrsMultiDelBottomMenuView iWe;
    private FrsMoveAreaBottomMenuView iWf;
    private NavigationBarCoverTip iWg;
    private TextView iWh;
    private TextView iWi;
    private boolean iWn;
    private ImageView ipI;
    private MessageRedDotView ipJ;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout iVr = null;
    private CoordinatorLayout iVs = null;
    private View iVt = null;
    private FrameLayout iVA = null;
    private TbImageView iVB = null;
    private TbImageView iVC = null;
    private com.baidu.tbadk.core.dialog.b iVG = null;
    private NoNetworkView.a iQf = null;
    private boolean iVK = true;
    private boolean mHasMore = true;
    private boolean iVM = false;
    private int iVc = 0;
    private int gpN = 0;
    private View bHy = null;
    private View iVT = null;
    private boolean gYV = false;
    private boolean ejt = true;
    private boolean iWa = true;
    private int iWb = -1;
    private int iWc = -1;
    private int iWj = 0;
    private int iWk = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener iDS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.iDQ == null) {
                        q.this.iDQ = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.iDQ.a(q.this.iVD, 2);
                } else if (q.this.iDQ != null) {
                    q.this.iDQ.rj();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener iWl = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.iVF != null) {
                q.this.iVF.setInterceptScrollDown(i == 0);
            }
            if (q.this.iWc != i && Math.abs(i) >= 0 && q.this.cDh() != -1) {
                if (Math.abs(i) >= q.this.cDh()) {
                    if (q.this.iWa) {
                        q.this.iWa = false;
                        q.this.pX(q.this.iWa);
                    }
                } else if (!q.this.iWa) {
                    q.this.iWa = true;
                    q.this.pX(q.this.iWa);
                }
                int cDd = q.this.cDd() + q.this.cDc() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cDd;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.iWc - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.zM(Math.abs(cDd - totalScrollRange2));
                        if (q.this.iVT != null) {
                            q.this.iVT.setVisibility(0);
                        }
                    } else if (q.this.iVT != null) {
                        if (q.this.cDb() != UtilHelper.getStatusBarHeight()) {
                            q.this.zM(0);
                        }
                        q.this.iVT.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.gYV) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.qc(false);
                        } else if (q.this.iWi != null) {
                            q.this.iWi.setAlpha(abs);
                        }
                    }
                    q.this.iWc = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.iVF != null) {
                int cKZ = q.this.iVF.cKZ();
                int cLa = cKZ - q.this.iVF.cLa();
                if (cKZ > 0 && Math.abs(i) >= cLa) {
                    q.this.iVF.dismissLoading();
                }
            }
        }
    };
    private Runnable iWm = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.iVz != null) {
                q.this.iVA.setVisibility(0);
                q.this.iVC.setVisibility(0);
                q.this.iVB.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.iVq != null && appBarLayout != null && this.iVq.cCc() != null && this.iVq.getPageContext() != null) {
            int cDc = cDc() + getNavigationBarHeight() + cDd();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cCc = this.iVq.cCc();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.iVq.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.iVq.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.iVt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.iVq != null && this.iVq.cCj();
            if (totalScrollRange <= 0) {
                if (this.iWk != 2) {
                    cCc.BT(2);
                }
                this.iWk = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cDc) {
                if (this.iWk != 1) {
                    cCc.BT(1);
                }
                this.iWk = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.iWk != 0) {
                    cCc.BT(0);
                }
                this.iWk = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.iVq.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.iVt.setLayoutParams(marginLayoutParams);
            }
            Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i + "]");
        }
    }

    public ObservedChangeLinearLayout cCZ() {
        return this.iVU;
    }

    public View Vv() {
        return this.bHy;
    }

    public View cDa() {
        return this.iVT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDb() {
        if (this.bHy == null) {
            return 0;
        }
        return this.bHy.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDc() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDd() {
        if (this.gpu == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gpu.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(int i) {
        View Vv = Vv();
        View cDa = cDa();
        if (UtilHelper.canUseStyleImmersiveSticky() && Vv != null && cDa != null && Vv.getLayoutParams() != null && cDa.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Vv.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Vv.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cDa.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cDa.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.iVq = null;
        this.iVH = null;
        this.iVL = 0;
        this.iVq = frsFragment;
        this.iVH = onClickListener;
        MessageManager.getInstance().registerListener(this.iDS);
        a(aVar, z);
        this.iVS = new HashSet<>();
        this.iVL = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.iWd = hVar;
    }

    private boolean cDe() {
        return this.iWd != null && this.iWd.cKH();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.iVV = aVar;
        View rootView = this.iVq.getRootView();
        if (this.iVr == null) {
            this.iVr = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.iVt == null) {
            this.iVt = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.iVs == null) {
            this.iVs = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.iVJ == null) {
            this.iVJ = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.iVZ == null) {
            this.iVZ = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.iVY == null) {
            this.iVY = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.iVF == null) {
            this.iVF = new com.baidu.tieba.frs.vc.k(this.iVq);
        }
        if (this.iVU == null) {
            this.iVU = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.iVU.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.iVZ.setMinimumHeight(i2);
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
        if (this.iVq.cCM()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.iVI == null) {
            this.iVI = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b cFz = aVar.cFz();
            if (cFz != null) {
                cFz.cN(this.iVI);
            }
        }
        if (this.iVu == null) {
            this.iVu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iVu.setOnClickListener(this.iVH);
            this.mBackImageView = (ImageView) this.iVu.findViewById(R.id.widget_navi_back_button);
        }
        if (this.iVx == null) {
            this.iVx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.btW().a(this.iVx, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iVx.setOnClickListener(this.iVH);
        }
        if (this.iVv == null) {
            this.iVv = new com.baidu.tieba.d.d(this.iVq.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.iVv.getView(), (View.OnClickListener) null);
            this.ipI = this.iVv.cti();
            this.ipJ = this.iVv.ctj();
            this.ipJ.setShadowEnabled(false);
            this.iVv.getView().setOnClickListener(this.iVH);
            this.iVv.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.iVw == null) {
            this.iVw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.btW().a(this.iVw, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iVw.setOnClickListener(this.iVH);
        }
        if (this.iVy == null) {
            this.iVy = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.iVy.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.iVq.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.iVy.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.f(this.iVy, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.iVy, R.color.CAM_X0101);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.iVq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.iVD == null) {
            this.iVD = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int iWq = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.iWq--;
                if (this.iWq == 0) {
                    q.this.iVD.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.iWq++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.iVD.setItemAnimator(defaultItemAnimator);
        this.iVD.setLayoutManager(new LinearLayoutManager(this.iVD.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iDQ = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.iDQ.a(this.iVD, 2);
        }
        this.iVD.setScrollable(this.iVq);
        this.iVD.setFadingEdgeLength(0);
        this.iVD.setOverScrollMode(2);
        this.iVr.setBottomOrderView(this.iVD);
        this.iVD.setOnTouchListener(this.iVq.fGd);
        this.iVD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iBT != null) {
                    q.this.iBT.dl(view);
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
        if (!com.baidu.tbadk.a.d.bkA()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.iVD.setPadding(dimenPixelSize, this.iVD.getPaddingTop(), dimenPixelSize, this.iVD.getPaddingBottom());
        }
        if (this.gre == null) {
            this.gre = new PbListView(this.iVq.getPageContext().getPageActivity());
            this.gre.getView();
        }
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iVq.getActivity(), R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.iVD.setOnSrollToBottomListener(this.iVq);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.iVq.cCF();
                if (q.this.iVq != null && q.this.Zj != null) {
                    q.this.iVq.cCP();
                    q.this.Zj.setExpanded(true);
                    if (q.this.iBT != null) {
                        q.this.iBT.a(q.this.iVc, q.this.gpN, false, true);
                    }
                }
            }
        });
        boolean btY = com.baidu.tbadk.core.util.av.btX().btY();
        if (this.iVE == null) {
            this.iVE = aVar.a(this.iVq, this.iVD, btY);
        }
        if (this.iVF != null) {
            this.iVF.Q(1, false);
        }
        if (!z) {
            if (this.gpu == null) {
                this.gpu = new NoNetworkView(this.iVq.getActivity());
                this.gpu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.iVU.addView(this.gpu);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gpu.setVisibility(8);
            } else {
                this.gpu.setVisibility(0);
            }
            this.gpu.onChangeSkinType(this.iVq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cDo();
        if (this.iVN == null) {
            this.iVN = aVar.a(this.iVq, this.iVr);
            this.iVN.b(this.iVq.cCQ());
        }
        if (this.iVO == null) {
            this.iVO = aVar.b(this.iVq, this.iVr);
            qa(true);
        }
        if (this.bHy == null) {
            this.bHy = rootView.findViewById(R.id.statebar_view);
        }
        if (this.iVT == null) {
            this.iVT = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iBT == null) {
            this.iBT = new com.baidu.tieba.play.i(this.iVq.getPageContext(), this.iVD);
        }
        this.iBT.IJ(1);
        this.iBT.setUniqueId(this.iVq.getUniqueId());
        this.iWg = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.iVP == null) {
            this.iVP = new com.baidu.tieba.frs.vc.m(this.iVq, this.iWg);
        }
        if (this.Zj == null) {
            this.Zj = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.Zj.addOnOffsetChangedListener(this.iWl);
            this.iWa = true;
            this.iWb = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Zj.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.iVX = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.iWe = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.iWe.setPageContext(this.iVq.getPageContext());
        this.iWf = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.iWf.setPageContext(this.iVq.getPageContext());
        if (this.iWi == null) {
            this.iWi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.iVq.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.iWi.setLayoutParams(layoutParams2);
            this.iWi.setPadding(0, 0, this.iVq.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.iWi.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
    }

    public void cb(boolean z) {
        if (z) {
        }
    }

    private void cDf() {
        ViewGroup.LayoutParams layoutParams;
        this.gYV = cDe();
        if (this.iVY != null && (layoutParams = this.iVY.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.gYV) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cDc(), 0, 0);
            }
            this.iVY.requestLayout();
        }
    }

    public void cDg() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.iVU != null) {
            cDf();
            if (this.gYV) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bHy != null) {
                    this.bHy.setAlpha(1.0f);
                }
                if (this.iVT != null) {
                    this.iVT.setAlpha(1.0f);
                }
                if (this.iWi != null) {
                    this.iWi.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(boolean z) {
        if (z && this.iVq != null && this.iVq.cCb() != null) {
            this.iVq.cCb().cKO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDh() {
        int i;
        if (this.Zj == null) {
            return this.iWb;
        }
        if (this.iWb != -1) {
            return this.iWb;
        }
        int childCount = this.Zj.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.Zj.getChildAt(childCount);
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
        this.iWb = Math.max(0, this.Zj.getTotalScrollRange() - Math.abs(i2));
        return this.iWb;
    }

    public void KJ(String str) {
        if (this.iVP != null) {
            this.iVP.KJ(str);
        }
    }

    public com.baidu.tieba.play.i cDi() {
        return this.iBT;
    }

    public com.baidu.tieba.frs.entelechy.b.c cDj() {
        return this.iVO;
    }

    public void pY(boolean z) {
        if (this.iVN != null) {
            if (com.baidu.tbadk.k.d.bDH().bDI()) {
                this.iVN.pY(false);
            } else {
                this.iVN.pY(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cDk() {
        return this.iVN;
    }

    public void Y(boolean z, boolean z2) {
        if (this.ejt && this.iVO != null) {
            this.iVO.Y(z, z2);
        }
    }

    public void pZ(boolean z) {
        this.ejt = z;
        if (!this.ejt && this.iVO != null) {
            this.iVO.Y(false, false);
        }
    }

    public void cDl() {
        if (this.ejt && this.iVO != null) {
            this.iVO.Y(false, false);
        }
        zN(8);
        this.iVx.setVisibility(8);
        this.iVw.setVisibility(8);
        pY(false);
        this.iVD.setVisibility(8);
        this.iVY.setVisibility(8);
    }

    public void cDm() {
        if (this.ejt && this.iVO != null) {
            this.iVO.Y(true, false);
        }
        zN(0);
        cDn();
        pY(this.iVq.cCS());
        this.iVD.setVisibility(0);
        this.iVY.setVisibility(0);
    }

    private void zN(int i) {
        if (this.iVv != null) {
            this.iVv.setVisibility(i);
        }
    }

    private void cDn() {
        this.iVx.setVisibility(0);
        this.iVw.setVisibility(0);
    }

    public void qa(boolean z) {
        if (this.iVO != null) {
            this.iVO.qC(z);
        }
    }

    private void cDo() {
        if (this.iVQ == null) {
            View rootView = this.iVq.getRootView();
            this.iVQ = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.iVR = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.iVR.setPageId(this.iVq.getUniqueId());
            this.iVQ.setLayerType(1, null);
            this.iVR.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cDp() {
        return this.iVu;
    }

    public void g(NoNetworkView.a aVar) {
        this.iQf = aVar;
        if (this.gpu != null) {
            this.gpu.a(this.iQf);
        }
    }

    public void qb(boolean z) {
        if (this.iVO != null) {
            if (z) {
                Y(false, true);
            } else {
                Y(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iVD.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.iVE.a(abVar);
    }

    public void setForumName(String str) {
        this.iVE.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iDS);
        if (this.iBT != null) {
            this.iBT.destroy();
        }
        if (this.iVP != null) {
            this.iVP.onDestory();
        }
        if (this.iWe != null) {
            this.iWe.setPageContext(null);
        }
        if (this.iWf != null) {
            this.iWf.setPageContext(null);
        }
        this.iVE.onDestory();
        this.iVD.setOnSrollToBottomListener(null);
        this.iVD.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.iWm);
        if (this.iCO != null) {
            this.iCO.onDestroy();
        }
        this.iVS.clear();
        if (this.iVN != null) {
            this.iVN.cKt();
        }
        if (this.iVW != null) {
            this.iVW.cFg();
        }
        if (this.iWg != null) {
            this.iWg.onDestroy();
        }
        if (this.iWe != null) {
            this.iWe.onDestroy();
        }
        if (this.iVF != null) {
            this.iVF.onDestroy();
        }
    }

    public boolean cDq() {
        if (this.Zj == null || this.iVX == null || !this.iVX.isSticky()) {
            return this.iVN != null && this.iVN.cDq();
        }
        if (this.iVD != null) {
            this.iVD.setSelection(0);
        }
        this.iVX.expandedAppBarLayout(this.Zj);
        return true;
    }

    public boolean cCK() {
        if (this.iVF == null) {
            return false;
        }
        return this.iVF.cCK();
    }

    public void bYs() {
        this.iVD.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.iWi.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.iWi.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.iWi.setText(str2);
            com.baidu.tbadk.core.k.blV().setForumNameForWaterImage(str);
        }
    }

    public void cDr() {
        if (this.iVE != null) {
            this.iVE.notifyDataSetChanged();
        }
    }

    public void bcP() {
        if (this.iVE instanceof com.baidu.tieba.frs.entelechy.a.t) {
            ((com.baidu.tieba.frs.entelechy.a.t) this.iVE).bcP();
        }
    }

    private void cDs() {
        if (this.iVG == null && this.iVq.getPageContext() != null) {
            String[] strArr = {this.iVq.getPageContext().getPageActivity().getString(R.string.take_photo), this.iVq.getPageContext().getPageActivity().getString(R.string.album)};
            this.iVG = new com.baidu.tbadk.core.dialog.b(this.iVq.getPageContext().getPageActivity());
            this.iVG.Br(this.iVq.getPageContext().getPageActivity().getString(R.string.operation));
            this.iVG.a(strArr, new b.InterfaceC0586b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.iVq.cCL();
                    } else if (i == 1 && q.this.iVq.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.iVq.getPageContext().getPageActivity());
                    }
                }
            });
            this.iVG.d(this.iVq.getPageContext());
        }
    }

    public void cDt() {
        cDs();
        if (this.iVG != null) {
            this.iVG.brx();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.y.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                s sVar = new s();
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList3 = new ArrayList<>();
                arrayList3.add(sVar);
                if (this.iVq != null && this.iVq.cBZ() != null && this.iVq.cBZ().cJb() == 0) {
                    sVar.zZ(this.iVq.cBZ().cJi());
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
                    com.baidu.adp.widget.ListView.q qVar = arrayList2.get(i2);
                    if (qVar instanceof bx) {
                        ((bx) qVar).eCR.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.iVE.b(arrayList2, frsViewData);
            if (this.iBT != null && this.iVc != 0) {
                this.iBT.a(this.iVc, this.gpN, this.iVM, true);
            }
            if (this.iVq != null) {
                this.iVq.cCV();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.iVD;
    }

    public void cDu() {
        this.iVE.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ae aeVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iVq.getPageContext(), 1);
        aVar.a(this.iVD);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.iVq.getForumName());
        hashMap.put("forum_id", this.iVq.getForumId());
        aVar.setParams(hashMap);
        aVar.aB(aeVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.iVN != null) {
            this.iVN.cKu();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        zO(TbadkCoreApplication.getInst().getSkinType());
        if (this.iVN != null) {
            this.iVN.cKv();
        }
    }

    public void release() {
        if (this.gpu != null && this.iQf != null) {
            this.gpu.b(this.iQf);
        }
    }

    public ImageView cDv() {
        return this.iVx;
    }

    public ImageView cDw() {
        return this.iVw;
    }

    public TextView cDx() {
        return this.iVy;
    }

    public View cDy() {
        if (this.iVv != null) {
            return this.iVv.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.iVv != null) {
            this.iVv.A(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.iVq, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.iVq.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.iVR != null) {
            this.iVR.invalidate();
        }
        if (this.iVE != null) {
            this.iVE.cGb();
            this.iVE.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.iVq.getPageContext(), this.iVr);
        if (this.gpu != null) {
            this.gpu.onChangeSkinType(this.iVq.getPageContext(), i);
        }
        if (this.gre != null) {
            this.gre.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
            this.gre.changeSkin(i);
        }
        if (this.iWi != null) {
            this.iWi.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
        zO(i);
        if (this.iVO != null) {
            this.iVO.onChangeSkinType(i);
        }
        if (this.iVN != null) {
            this.iVN.onChangeSkinType(i);
        }
        if (this.iWe != null) {
            this.iWe.onChangeSkinType();
        }
        if (this.iWf != null) {
            this.iWf.onChangeSkinType();
        }
        if (!com.baidu.tbadk.a.d.bkA()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVt, R.color.CAM_X0202);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVt, R.color.CAM_X0204);
        }
    }

    private void zO(int i) {
        if (this.iVq != null) {
            zP(i);
        }
    }

    private void zP(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iVq.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVI, R.color.CAM_X0204, i);
            if (this.iVv != null) {
                this.iVv.onChangeSkinType(i);
            }
            if (this.iVx != null) {
                SvgManager.btW().a(this.iVx, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.iVw != null) {
                SvgManager.btW().a(this.iVw, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (com.baidu.tbadk.a.d.bkA()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bHy, R.color.CAM_X0208);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVT, R.color.CAM_X0208);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bHy, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.iVT, R.color.CAM_X0207);
        }
        qc(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gYV) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.iWj != 0) {
                    SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.btW().a(this.iVx, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.ipI.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
                    SvgManager.btW().a(this.iVw, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iWj = 0;
                }
            } else if (z || this.iWj != 1) {
                SvgManager.btW().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.btW().a(this.iVx, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.ipI.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0106), (WebPManager.ResourceStateType) null));
                SvgManager.btW().a(this.iVw, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iWj = 1;
            }
            cDz();
        }
    }

    private void cDz() {
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
            if (this.iWi != null) {
                this.iWi.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.ipI != null) {
                    this.ipI.setAlpha(f);
                }
                if (this.iVq != null && this.iVq.cCc() != null && this.iWj == 1) {
                    this.iVq.cCc().aF(f);
                }
                if (this.ipJ != null) {
                    this.ipJ.setAlpha(f);
                }
                if (this.iVx != null) {
                    this.iVx.setAlpha(f);
                }
                if (this.iVw != null) {
                    this.iVw.setAlpha(f);
                }
            }
            if (this.iVy != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.iVy.setAlpha(f2);
                this.iVy.setClickable(f2 > 0.0f);
            }
            if (this.bHy != null) {
                this.bHy.setAlpha(alpha);
            }
            if (this.iVT != null) {
                this.iVT.setAlpha(alpha);
            }
            if (this.iVI != null) {
                this.iVI.setAlpha(alpha);
            }
        }
    }

    public void bSl() {
        if (this.iVF != null) {
            this.iVF.bSl();
        }
    }

    public void qd(boolean z) {
        if (this.iVF != null) {
            this.iVF.qd(z);
        }
    }

    public void qe(boolean z) {
        this.iVK = z;
        if (this.iVK) {
            this.gre.setText(this.iVq.getResources().getString(R.string.load_more));
            if (this.iVD.getChildAt(this.iVD.getChildCount() - 1) == this.gre.getView()) {
                this.gre.startLoadData();
                this.iVq.bRM();
                return;
            }
            this.gre.endLoadData();
            return;
        }
        this.gre.setText(this.iVq.getResources().getString(R.string.load_more_must_after_delete));
        this.gre.endLoadData();
    }

    public boolean cDA() {
        if (this.iVK) {
            return false;
        }
        this.gre.setText(this.iVq.getResources().getString(R.string.load_more_must_after_delete));
        this.gre.endLoadData();
        return true;
    }

    public boolean cDB() {
        return this.iVz != null && this.iVC.getVisibility() == 0;
    }

    public void cDC() {
        if (this.iVz != null) {
            this.iVA.setVisibility(0);
            this.iVC.setVisibility(8);
            this.iVB.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.iWm, 5000L);
        }
    }

    public void a(ci ciVar) {
        if (this.iVz == null) {
            View rootView = this.iVq.getRootView();
            this.iVz = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.iVz.setVisibility(0);
            this.iVA = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.iVB = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.iVC = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.iVB.setPageId(this.iVq.getUniqueId());
            this.iVC.setPageId(this.iVq.getUniqueId());
            this.iVB.setDefaultBgResource(R.color.common_color_10022);
            this.iVB.setDefaultResource(0);
            this.iVC.setDefaultBgResource(R.color.common_color_10022);
            this.iVC.setDefaultResource(0);
            this.iVA.setOnClickListener(this.iVH);
        }
        this.iVA.setVisibility(0);
        String brk = ciVar.brk();
        String brl = ciVar.brl();
        this.iVB.startLoad(brk, 10, false);
        this.iVC.startLoad(brl, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.iWm, 5000L);
    }

    public void cDD() {
        if (this.iVz != null && this.iVA != null) {
            this.iVA.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.am cDE() {
        return this.iVE;
    }

    public RelativeLayout cnn() {
        return this.iVr;
    }

    public View cDF() {
        return this.iVJ;
    }

    public void zQ(int i) {
        if (this.iVt != null) {
            this.iVt.setVisibility(i);
        }
    }

    public NavigationBar bVK() {
        return this.mNavigationBar;
    }

    public void XZ() {
        this.mHasMore = true;
        this.iVD.setNextPage(this.gre);
        if (this.iVL > 0) {
            this.gre.showEmptyView(this.iVL);
        }
        this.gre.setOnClickListener(null);
        this.gre.startLoadData();
    }

    public void Ya() {
        this.mHasMore = false;
        this.iVD.setNextPage(this.gre);
        if (this.iVL > 0) {
            this.gre.showEmptyView(this.iVL);
        }
        this.gre.setOnClickListener(null);
        this.gre.endLoadData();
        this.gre.setText(this.iVq.getResources().getString(R.string.list_has_no_more));
    }

    public void cDG() {
        this.mHasMore = true;
        this.iVD.setNextPage(this.gre);
        this.gre.setOnClickListener(this.iVH);
        if (this.iVL > 0) {
            this.gre.showEmptyView(this.iVL);
        }
        this.gre.endLoadData();
        this.gre.setText(this.iVq.getResources().getString(R.string.list_click_load_more));
    }

    public View cDH() {
        if (this.gre == null) {
            return null;
        }
        return this.gre.getView();
    }

    public void zR(int i) {
        if (this.iWe != null) {
            this.iWe.setVisibility(i);
        }
    }

    public void zS(int i) {
        if (this.iWe != null) {
            this.iWe.setSelectNumber(i);
        }
    }

    public void zT(int i) {
        if (this.iWf != null) {
            this.iWf.setVisibility(i);
        }
    }

    public void zU(int i) {
        if (this.iWf != null) {
            this.iWf.setMoveNumber(i);
        }
    }

    public boolean cDI() {
        return this.iWf != null && this.iWf.cMa();
    }

    public void cDJ() {
        if (this.iWf != null) {
            this.iWf.cMb();
        }
    }

    public void bTa() {
        this.mHasMore = false;
        this.iVD.setNextPage(null);
    }

    public boolean cDK() {
        return this.gre.getView().getParent() != null && this.mHasMore;
    }

    public void zV(int i) {
        this.iVL = i;
    }

    public void zW(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.iCO == null) {
                    this.iCO = new CommonTipView(this.iVq.getActivity());
                }
                this.iCO.setText(R.string.frs_login_tip);
                this.iCO.b((FrameLayout) cDF(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void qf(boolean z) {
        this.mIsBackground = z;
        if (this.iBT != null) {
            boolean z2 = (this.iVq == null || this.iVq.cCc() == null || this.iVq.cCc().cLm() == null) ? true : this.iVq.cCc().cLm().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iBT.tC(false);
                this.iBT.deJ();
                return;
            }
            this.iBT.tC(true);
            this.iBT.a(this.iVc, this.gpN, this.iVM, true);
        }
    }

    public void cr(int i, int i2) {
        if (this.iBT != null) {
            this.iBT.a(i, i2, this.iVM, 1);
        }
    }

    public void cs(int i, int i2) {
        this.iVc = i;
        this.gpN = i2;
    }

    public void qg(boolean z) {
        this.iVM = z;
    }

    public void zX(int i) {
        if (this.iVD != null && this.iVD.getChildCount() >= 0) {
            if (this.iVD.getFirstVisiblePosition() > 8) {
                this.iVD.scrollToPosition(8);
            }
            this.iVD.smoothScrollToPosition(i);
        }
    }

    public void cDL() {
        a(this.iVV, this.iVq.cCM());
        if (this.iVE != null) {
            this.iVE.cFY();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.iVq.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.iVW == null) {
                this.iVW = new com.baidu.tieba.video.f(this.iVq.getActivity(), this.iVr);
            }
            this.iVW.j(postWriteCallBackData);
        }
    }

    public void cDM() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.iWn && this.iVq.getActivity() != null && this.iVq.getPageContext() != null) {
            View view = null;
            if (this.iVD != null && (headerViewsCount = this.iVD.getHeaderViewsCount()) < this.iVD.getChildCount()) {
                view = this.iVD.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ad(true).ae(false).ac(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.iVq.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.iVq.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.iVq.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mi = dVar.mi();
                mi.setShouldCheckLocInWindow(false);
                mi.show(this.iVq.getActivity());
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mi != null) {
                            mi.dismiss();
                        }
                    }
                }, 4000L);
                this.iWn = true;
            }
        }
    }

    public void b(e.a aVar) {
        if (this.iWe != null) {
            this.iWe.setDeleteCallback(aVar);
        }
    }

    public void cDN() {
        if (this.iWe != null) {
            this.iWe.cDN();
        }
    }

    public void bLp() {
        if (this.iWe != null) {
            this.iWe.bLp();
        }
    }

    public void aP(String str, int i) {
        if (this.iWh == null) {
            this.iWh = new TextView(this.iVq.getActivity());
            this.iWh.setGravity(19);
            this.iWh.setPadding(com.baidu.adp.lib.util.l.getDimens(this.iVq.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.iVq.getActivity(), R.dimen.ds34), 0);
            this.iWh.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.iVq.getActivity(), R.dimen.tbds112)));
            this.iWh.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.iVq.getActivity(), R.dimen.fontsize30));
            this.iWh.setMaxLines(2);
            this.iWh.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.iWh.setTextColor(ContextCompat.getColor(this.iVq.getActivity(), R.color.CAM_X0101));
        }
        this.iWg.setBackgroundColor(i);
        this.iWh.setText(str);
        this.iWg.a(this.iVq.getActivity(), this.iWh, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.Zj != null) {
            this.Zj.setExpanded(z);
        }
    }

    public void cDO() {
        if (this.iVF != null) {
            this.iVF.startPullRefresh();
        }
    }

    public void HO() {
        if (cDE() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = cDE().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bx) {
                        bx bxVar = (bx) qVar;
                        if (bxVar.eIP != 0 && bxVar.eCR != null && this.iVq.cBZ() != null && this.iVq.cBZ().cIE() != null) {
                            int[] imageWidthAndHeight = bxVar.eCR.getImageWidthAndHeight();
                            bxVar.eIP = imageWidthAndHeight[0];
                            bxVar.eIQ = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cDE().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iBT.a(q.this.iVc, q.this.gpN, q.this.iVM, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cDP() {
        if (this.iVN == null) {
            return false;
        }
        return this.iVN.cDP();
    }

    public Context getContext() {
        if (this.iVq == null) {
            return null;
        }
        return this.iVq.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.iVF != null) {
            this.iVF.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.iVF != null) {
            this.iVF.startPullRefresh();
        }
    }

    public void cDQ() {
        if (this.iVF != null) {
            this.iVF.cDQ();
        }
    }

    public void cDR() {
        if (this.iVF != null) {
            this.iVF.cDR();
        }
    }

    public void a(at atVar) {
        if (this.iVF != null) {
            this.iVF.a(atVar);
        }
    }

    public void zY(int i) {
        if (this.iVF != null) {
            this.iVF.zY(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cDS() {
        return this.iVF;
    }
}
