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
    private AppBarLayout ZM;
    private PbListView gAi;
    private NoNetworkView gxW;
    private ImageView iDh;
    private MessageRedDotView iDi;
    private com.baidu.tieba.play.i iPi;
    private CommonTipView iQd;
    private com.baidu.adp.widget.ListView.l iRf;
    private FrsFragment jiE;
    private View jiI;
    private com.baidu.tieba.c.d jiJ;
    private ImageView jiK;
    private ImageView jiL;
    private TextView jiM;
    private ViewStub jiN;
    private BdTypeRecyclerView jiR;
    private com.baidu.tieba.frs.entelechy.adapter.al jiS;
    private com.baidu.tieba.frs.vc.k jiT;
    private View.OnClickListener jiV;
    private View jiW;
    private View jiX;
    private int jiZ;
    private boolean jjB;
    private com.baidu.tieba.frs.vc.d jjb;
    private com.baidu.tieba.frs.entelechy.a.c jjc;
    private com.baidu.tieba.frs.vc.m jjd;
    private GifView jje;
    private TbImageView jjf;
    private HashSet<String> jjg;
    private ObservedChangeLinearLayout jji;
    private com.baidu.tieba.frs.entelechy.a.a jjj;
    private com.baidu.tieba.video.e jjk;
    private AppBarLayoutStickyBehavior jjl;
    private FrsHeaderViewContainer jjm;
    private CollapsingToolbarLayout jjn;
    private com.baidu.tieba.frs.vc.h jjr;
    private FrsMultiDelBottomMenuView jjs;
    private FrsMoveAreaBottomMenuView jjt;
    private NavigationBarCoverTip jju;
    private TextView jjv;
    private TextView jjw;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout jiF = null;
    private CoordinatorLayout jiG = null;
    private View jiH = null;
    private FrameLayout jiO = null;
    private TbImageView jiP = null;
    private TbImageView jiQ = null;
    private com.baidu.tbadk.core.dialog.b jiU = null;
    private NoNetworkView.a jdt = null;
    private boolean jiY = true;
    private boolean mHasMore = true;
    private boolean jja = false;
    private int jiq = 0;
    private int gyR = 0;
    private View bLj = null;
    private View jjh = null;
    private boolean hkv = false;
    private boolean epQ = true;
    private boolean jjo = true;
    private int jjp = -1;
    private int jjq = -1;
    private int jjx = 0;
    private int jjy = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener iRh = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.iRf == null) {
                        q.this.iRf = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
                    }
                    q.this.iRf.a(q.this.jiR, 2);
                } else if (q.this.iRf != null) {
                    q.this.iRf.qJ();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jjz = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.jiT != null) {
                q.this.jiT.setInterceptScrollDown(i == 0);
            }
            if (q.this.jjq != i && Math.abs(i) >= 0 && q.this.cDx() != -1) {
                if (Math.abs(i) >= q.this.cDx()) {
                    if (q.this.jjo) {
                        q.this.jjo = false;
                        q.this.qB(q.this.jjo);
                    }
                } else if (!q.this.jjo) {
                    q.this.jjo = true;
                    q.this.qB(q.this.jjo);
                }
                int cDt = q.this.cDt() + q.this.cDs() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cDt;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.jjq - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.yD(Math.abs(cDt - totalScrollRange2));
                        if (q.this.jjh != null) {
                            q.this.jjh.setVisibility(0);
                        }
                    } else if (q.this.jjh != null) {
                        if (q.this.cDr() != UtilHelper.getStatusBarHeight()) {
                            q.this.yD(0);
                        }
                        q.this.jjh.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.hkv) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.qG(false);
                        } else if (q.this.jjw != null) {
                            q.this.jjw.setAlpha(abs);
                        }
                    }
                    q.this.jjq = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.jiT != null) {
                int cLy = q.this.jiT.cLy();
                int cLz = cLy - q.this.jiT.cLz();
                if (cLy > 0 && Math.abs(i) >= cLz) {
                    q.this.jiT.dismissLoading();
                }
            }
        }
    };
    private Runnable jjA = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.jiN != null) {
                q.this.jiO.setVisibility(0);
                q.this.jiQ.setVisibility(0);
                q.this.jiP.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.jiE != null && appBarLayout != null && this.jiE.cCs() != null && this.jiE.getPageContext() != null) {
            int cDs = cDs() + getNavigationBarHeight() + cDt();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cCs = this.jiE.cCs();
            ViewGroup.LayoutParams layoutParams = this.jiH.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.jiE != null && this.jiE.cCz();
            if (totalScrollRange <= 0) {
                if (this.jjy != 2) {
                    cCs.AJ(2);
                }
                this.jjy = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cDs) {
                if (this.jjy != 1) {
                    cCs.AJ(1);
                }
                this.jjy = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.jjy != 0) {
                    cCs.AJ(0);
                }
                this.jjy = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.jiE.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.jiH.setLayoutParams(marginLayoutParams);
            }
            Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i + "]");
        }
    }

    public ObservedChangeLinearLayout cDp() {
        return this.jji;
    }

    public View Um() {
        return this.bLj;
    }

    public View cDq() {
        return this.jjh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDr() {
        if (this.bLj == null) {
            return 0;
        }
        return this.bLj.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDs() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDt() {
        if (this.gxW == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gxW.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(int i) {
        View Um = Um();
        View cDq = cDq();
        if (UtilHelper.canUseStyleImmersiveSticky() && Um != null && cDq != null && Um.getLayoutParams() != null && cDq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Um.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Um.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cDq.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cDq.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.a.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.jiE = null;
        this.jiV = null;
        this.jiZ = 0;
        this.jiE = frsFragment;
        this.jiV = onClickListener;
        MessageManager.getInstance().registerListener(this.iRh);
        a(aVar, z);
        this.jjg = new HashSet<>();
        this.jiZ = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.jjr = hVar;
    }

    private boolean cDu() {
        return this.jjr != null && this.jjr.cLf();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.a.a aVar, boolean z) {
        boolean z2;
        this.jjj = aVar;
        View rootView = this.jiE.getRootView();
        if (this.jiF == null) {
            this.jiF = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.jiH == null) {
            this.jiH = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.jiG == null) {
            this.jiG = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.jiX == null) {
            this.jiX = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.jjn == null) {
            this.jjn = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.jjm == null) {
            this.jjm = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.jiT == null) {
            this.jiT = new com.baidu.tieba.frs.vc.k(this.jiE);
        }
        if (this.jji == null) {
            this.jji = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jji.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.jjn.setMinimumHeight(i2);
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
        if (this.jiE.cDc()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.jiW == null) {
            this.jiW = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.a.b cFS = aVar.cFS();
            if (cFS != null) {
                cFS.cV(this.jiW);
            }
        }
        if (this.jiI == null) {
            this.jiI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jiI.setOnClickListener(this.jiV);
            this.mBackImageView = (ImageView) this.jiI.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jiL == null) {
            this.jiL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bsR().a(this.jiL, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jiL.setOnClickListener(this.jiV);
        }
        if (this.jiJ == null) {
            this.jiJ = new com.baidu.tieba.c.d(this.jiE.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jiJ.getView(), (View.OnClickListener) null);
            this.iDh = this.jiJ.ctx();
            this.iDi = this.jiJ.cty();
            this.iDi.setShadowEnabled(false);
            this.jiJ.getView().setOnClickListener(this.jiV);
            this.jiJ.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.jiK == null) {
            this.jiK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bsR().a(this.jiK, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jiK.setOnClickListener(this.jiV);
        }
        if (this.jiM == null) {
            this.jiM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.jiM.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jiE.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jiM.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.l(this.jiM, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jiM, R.color.CAM_X0101);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.jiE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.jiR == null) {
            this.jiR = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int jjE = 0;

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.jjE--;
                if (this.jjE == 0) {
                    q.this.jiR.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.jjE++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.jiR.setItemAnimator(defaultItemAnimator);
        this.jiR.setLayoutManager(new LinearLayoutManager(this.jiR.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iRf = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
            this.iRf.a(this.jiR, 2);
        }
        this.jiR.setScrollable(this.jiE);
        this.jiR.setFadingEdgeLength(0);
        this.jiR.setOverScrollMode(2);
        this.jiF.setBottomOrderView(this.jiR);
        this.jiR.setOnTouchListener(this.jiE.bST);
        this.jiR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iPi != null) {
                    q.this.iPi.dt(view);
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
        this.jiR.setPadding(dimenPixelSize, this.jiR.getPaddingTop(), dimenPixelSize, this.jiR.getPaddingBottom());
        if (this.gAi == null) {
            this.gAi = new PbListView(this.jiE.getPageContext().getPageActivity());
            this.gAi.getView();
        }
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jiE.getActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jiR.setOnSrollToBottomListener(this.jiE);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.jiE.cCV();
                if (q.this.jiE != null && q.this.ZM != null) {
                    q.this.jiE.cDf();
                    q.this.ZM.setExpanded(true);
                    if (q.this.iPi != null) {
                        q.this.iPi.b(q.this.jiq, q.this.gyR, false, true);
                    }
                }
            }
        });
        boolean bsT = com.baidu.tbadk.core.util.av.bsS().bsT();
        if (this.jiS == null) {
            this.jiS = aVar.a(this.jiE, this.jiR, bsT);
        }
        if (this.jiT != null) {
            this.jiT.Q(1, false);
        }
        if (!z) {
            if (this.gxW == null) {
                this.gxW = new NoNetworkView(this.jiE.getActivity());
                this.gxW.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.jji.addView(this.gxW);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gxW.setVisibility(8);
            } else {
                this.gxW.setVisibility(0);
            }
            this.gxW.onChangeSkinType(this.jiE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cDE();
        if (this.jjb == null) {
            this.jjb = aVar.a(this.jiE, this.jiF);
            this.jjb.b(this.jiE.cDg());
        }
        if (this.jjc == null) {
            this.jjc = aVar.b(this.jiE, this.jiF);
            qE(true);
        }
        if (this.bLj == null) {
            this.bLj = rootView.findViewById(R.id.statebar_view);
        }
        if (this.jjh == null) {
            this.jjh = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iPi == null) {
            this.iPi = new com.baidu.tieba.play.i(this.jiE.getPageContext(), this.jiR);
        }
        this.iPi.Ho(1);
        this.iPi.setUniqueId(this.jiE.getUniqueId());
        this.jju = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.jjd == null) {
            this.jjd = new com.baidu.tieba.frs.vc.m(this.jiE, this.jju);
        }
        if (this.ZM == null) {
            this.ZM = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.ZM.addOnOffsetChangedListener(this.jjz);
            this.jjo = true;
            this.jjp = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.ZM.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.jjl = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.jjs = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.jjs.setPageContext(this.jiE.getPageContext());
        this.jjt = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.jjt.setPageContext(this.jiE.getPageContext());
        if (this.jjw == null) {
            this.jjw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jiE.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.jjw.setLayoutParams(layoutParams2);
            this.jjw.setPadding(0, 0, this.jiE.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.jjw.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
    }

    public void cb(boolean z) {
        if (z) {
        }
    }

    private void cDv() {
        ViewGroup.LayoutParams layoutParams;
        this.hkv = cDu();
        if (this.jjm != null && (layoutParams = this.jjm.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.hkv) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cDs(), 0, 0);
            }
            this.jjm.requestLayout();
        }
    }

    public void cDw() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.jji != null) {
            cDv();
            if (this.hkv) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bLj != null) {
                    this.bLj.setAlpha(1.0f);
                }
                if (this.jjh != null) {
                    this.jjh.setAlpha(1.0f);
                }
                if (this.jjw != null) {
                    this.jjw.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(boolean z) {
        if (z && this.jiE != null && this.jiE.cCr() != null) {
            this.jiE.cCr().cLm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDx() {
        int i;
        if (this.ZM == null) {
            return this.jjp;
        }
        if (this.jjp != -1) {
            return this.jjp;
        }
        int childCount = this.ZM.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.ZM.getChildAt(childCount);
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
        this.jjp = Math.max(0, this.ZM.getTotalScrollRange() - Math.abs(i2));
        return this.jjp;
    }

    public void Kh(String str) {
        if (this.jjd != null) {
            this.jjd.Kh(str);
        }
    }

    public com.baidu.tieba.play.i cDy() {
        return this.iPi;
    }

    public com.baidu.tieba.frs.entelechy.a.c cDz() {
        return this.jjc;
    }

    public void qC(boolean z) {
        if (this.jjb != null) {
            if (com.baidu.tbadk.k.d.bCB().bCC()) {
                this.jjb.qC(false);
            } else {
                this.jjb.qC(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cDA() {
        return this.jjb;
    }

    public void aa(boolean z, boolean z2) {
        if (this.epQ && this.jjc != null) {
            this.jjc.aa(z, z2);
        }
    }

    public void qD(boolean z) {
        this.epQ = z;
        if (!this.epQ && this.jjc != null) {
            this.jjc.aa(false, false);
        }
    }

    public void cDB() {
        if (this.epQ && this.jjc != null) {
            this.jjc.aa(false, false);
        }
        yE(8);
        this.jiL.setVisibility(8);
        this.jiK.setVisibility(8);
        qC(false);
        this.jiR.setVisibility(8);
        this.jjm.setVisibility(8);
    }

    public void cDC() {
        if (this.epQ && this.jjc != null) {
            this.jjc.aa(true, false);
        }
        yE(0);
        cDD();
        qC(this.jiE.cDi());
        this.jiR.setVisibility(0);
        this.jjm.setVisibility(0);
    }

    private void yE(int i) {
        if (this.jiJ != null) {
            this.jiJ.setVisibility(i);
        }
    }

    private void cDD() {
        this.jiL.setVisibility(0);
        this.jiK.setVisibility(0);
    }

    public void qE(boolean z) {
        if (this.jjc != null) {
            this.jjc.rg(z);
        }
    }

    private void cDE() {
        if (this.jje == null) {
            View rootView = this.jiE.getRootView();
            this.jje = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.jjf = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.jjf.setPageId(this.jiE.getUniqueId());
            this.jje.setLayerType(1, null);
            this.jjf.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cDF() {
        return this.jiI;
    }

    public void g(NoNetworkView.a aVar) {
        this.jdt = aVar;
        if (this.gxW != null) {
            this.gxW.a(this.jdt);
        }
    }

    public void qF(boolean z) {
        if (this.jjc != null) {
            if (z) {
                aa(false, true);
            } else {
                aa(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jiR.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.jiS.a(wVar);
    }

    public void setForumName(String str) {
        this.jiS.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iRh);
        if (this.iPi != null) {
            this.iPi.destroy();
        }
        if (this.jjd != null) {
            this.jjd.onDestory();
        }
        if (this.jjs != null) {
            this.jjs.setPageContext(null);
        }
        if (this.jjt != null) {
            this.jjt.setPageContext(null);
        }
        this.jiS.onDestory();
        this.jiR.setOnSrollToBottomListener(null);
        this.jiR.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.jjA);
        if (this.iQd != null) {
            this.iQd.onDestroy();
        }
        this.jjg.clear();
        if (this.jjb != null) {
            this.jjb.cKQ();
        }
        if (this.jjk != null) {
            this.jjk.cFx();
        }
        if (this.jju != null) {
            this.jju.onDestroy();
        }
        if (this.jjs != null) {
            this.jjs.onDestroy();
        }
        if (this.jiT != null) {
            this.jiT.onDestroy();
        }
    }

    public boolean cDG() {
        if (this.ZM == null || this.jjl == null || !this.jjl.isSticky()) {
            return this.jjb != null && this.jjb.cDG();
        }
        if (this.jiR != null) {
            this.jiR.setSelection(0);
        }
        this.jjl.expandedAppBarLayout(this.ZM);
        return true;
    }

    public boolean cDa() {
        if (this.jiT == null) {
            return false;
        }
        return this.jiT.cDa();
    }

    public void bYh() {
        this.jiR.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.jjw.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.jjw.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.jjw.setText(str2);
            com.baidu.tbadk.core.k.bkT().setForumNameForWaterImage(str);
        }
    }

    public void cDH() {
        if (this.jiS != null) {
            this.jiS.notifyDataSetChanged();
        }
    }

    public void bbC() {
        if (this.jiS instanceof com.baidu.tieba.frs.entelechy.adapter.u) {
            ((com.baidu.tieba.frs.entelechy.adapter.u) this.jiS).bbC();
        }
    }

    private void cDI() {
        if (this.jiU == null && this.jiE.getPageContext() != null) {
            String[] strArr = {this.jiE.getPageContext().getPageActivity().getString(R.string.take_photo), this.jiE.getPageContext().getPageActivity().getString(R.string.album)};
            this.jiU = new com.baidu.tbadk.core.dialog.b(this.jiE.getPageContext().getPageActivity());
            this.jiU.Av(this.jiE.getPageContext().getPageActivity().getString(R.string.operation));
            this.jiU.a(strArr, new b.InterfaceC0558b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.jiE.cDb();
                    } else if (i == 1 && q.this.jiE.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.jiE.getPageContext().getPageActivity());
                    }
                }
            });
            this.jiU.d(this.jiE.getPageContext());
        }
    }

    public void cDJ() {
        cDI();
        if (this.jiU != null) {
            this.jiU.bqz();
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
                if (this.jiE != null && this.jiE.cCp() != null && this.jiE.cCp().cJy() == 0) {
                    sVar.yP(this.jiE.cCp().cJF());
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
                        ((ca) nVar).eJQ.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.jiS.b(arrayList2, frsViewData);
            if (this.iPi != null && this.jiq != 0) {
                this.iPi.b(this.jiq, this.gyR, this.jja, true);
            }
            if (this.jiE != null) {
                this.jiE.cDl();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.jiR;
    }

    public void cDK() {
        this.jiS.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jiE.getPageContext(), 1);
        aVar.a(this.jiR);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.jiE.getForumName());
        hashMap.put("forum_id", this.jiE.getForumId());
        aVar.setParams(hashMap);
        aVar.aD(afVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.jjb != null) {
            this.jjb.cKR();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        yF(TbadkCoreApplication.getInst().getSkinType());
        if (this.jjb != null) {
            this.jjb.cKS();
        }
    }

    public void release() {
        if (this.gxW != null && this.jdt != null) {
            this.gxW.b(this.jdt);
        }
    }

    public ImageView cDL() {
        return this.jiL;
    }

    public ImageView cDM() {
        return this.jiK;
    }

    public TextView cDN() {
        return this.jiM;
    }

    public View cDO() {
        if (this.jiJ != null) {
            return this.jiJ.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.jiJ != null) {
            this.jiJ.z(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.jiE, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jiE.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.jjf != null) {
            this.jjf.invalidate();
        }
        if (this.jiS != null) {
            this.jiS.cGx();
            this.jiS.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.jiE.getPageContext(), this.jiF);
        if (this.gxW != null) {
            this.gxW.onChangeSkinType(this.jiE.getPageContext(), i);
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
            this.gAi.changeSkin(i);
        }
        if (this.jjw != null) {
            this.jjw.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
        yF(i);
        if (this.jjc != null) {
            this.jjc.onChangeSkinType(i);
        }
        if (this.jjb != null) {
            this.jjb.onChangeSkinType(i);
        }
        if (this.jjs != null) {
            this.jjs.onChangeSkinType();
        }
        if (this.jjt != null) {
            this.jjt.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jiH, R.color.CAM_X0202);
    }

    private void yF(int i) {
        if (this.jiE != null) {
            yG(i);
        }
    }

    private void yG(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jiE.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jiW, R.color.CAM_X0204, i);
            if (this.jiJ != null) {
                this.jiJ.onChangeSkinType(i);
            }
            if (this.jiL != null) {
                SvgManager.bsR().a(this.jiL, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jiK != null) {
                SvgManager.bsR().a(this.jiK, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bLj, R.color.CAM_X0207);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jjh, R.color.CAM_X0207);
        qG(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hkv) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.jjx != 0) {
                    SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bsR().a(this.jiL, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iDh.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
                    SvgManager.bsR().a(this.jiK, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.jjx = 0;
                }
            } else if (z || this.jjx != 1) {
                SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsR().a(this.jiL, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iDh.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0106), (WebPManager.ResourceStateType) null));
                SvgManager.bsR().a(this.jiK, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.jjx = 1;
            }
            cDP();
        }
    }

    private void cDP() {
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
            if (this.jjw != null) {
                this.jjw.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.iDh != null) {
                    this.iDh.setAlpha(f);
                }
                if (this.jiE != null && this.jiE.cCs() != null && this.jjx == 1) {
                    this.jiE.cCs().aK(f);
                }
                if (this.iDi != null) {
                    this.iDi.setAlpha(f);
                }
                if (this.jiL != null) {
                    this.jiL.setAlpha(f);
                }
                if (this.jiK != null) {
                    this.jiK.setAlpha(f);
                }
            }
            if (this.jiM != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.jiM.setAlpha(f2);
                this.jiM.setClickable(f2 > 0.0f);
            }
            if (this.bLj != null) {
                this.bLj.setAlpha(alpha);
            }
            if (this.jjh != null) {
                this.jjh.setAlpha(alpha);
            }
            if (this.jiW != null) {
                this.jiW.setAlpha(alpha);
            }
        }
    }

    public void bRB() {
        if (this.jiT != null) {
            this.jiT.bRB();
        }
    }

    public void qH(boolean z) {
        if (this.jiT != null) {
            this.jiT.qH(z);
        }
    }

    public void qI(boolean z) {
        this.jiY = z;
        if (this.jiY) {
            this.gAi.setText(this.jiE.getResources().getString(R.string.load_more));
            if (this.jiR.getChildAt(this.jiR.getChildCount() - 1) == this.gAi.getView()) {
                this.gAi.startLoadData();
                this.jiE.bRc();
                return;
            }
            this.gAi.endLoadData();
            return;
        }
        this.gAi.setText(this.jiE.getResources().getString(R.string.load_more_must_after_delete));
        this.gAi.endLoadData();
    }

    public boolean cDQ() {
        if (this.jiY) {
            return false;
        }
        this.gAi.setText(this.jiE.getResources().getString(R.string.load_more_must_after_delete));
        this.gAi.endLoadData();
        return true;
    }

    public boolean cDR() {
        return this.jiN != null && this.jiQ.getVisibility() == 0;
    }

    public void cDS() {
        if (this.jiN != null) {
            this.jiO.setVisibility(0);
            this.jiQ.setVisibility(8);
            this.jiP.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.jjA, 5000L);
        }
    }

    public void a(cl clVar) {
        if (this.jiN == null) {
            View rootView = this.jiE.getRootView();
            this.jiN = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.jiN.setVisibility(0);
            this.jiO = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.jiP = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.jiQ = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.jiP.setPageId(this.jiE.getUniqueId());
            this.jiQ.setPageId(this.jiE.getUniqueId());
            this.jiP.setDefaultBgResource(R.color.common_color_10022);
            this.jiP.setDefaultResource(0);
            this.jiQ.setDefaultBgResource(R.color.common_color_10022);
            this.jiQ.setDefaultResource(0);
            this.jiO.setOnClickListener(this.jiV);
        }
        this.jiO.setVisibility(0);
        String bql = clVar.bql();
        String bqm = clVar.bqm();
        this.jiP.startLoad(bql, 10, false);
        this.jiQ.startLoad(bqm, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.jjA, 5000L);
    }

    public void cDT() {
        if (this.jiN != null && this.jiO != null) {
            this.jiO.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.adapter.al cDU() {
        return this.jiS;
    }

    public RelativeLayout cnn() {
        return this.jiF;
    }

    public View cDV() {
        return this.jiX;
    }

    public void yH(int i) {
        if (this.jiH != null) {
            this.jiH.setVisibility(i);
        }
    }

    public NavigationBar bVd() {
        return this.mNavigationBar;
    }

    public void WX() {
        this.mHasMore = true;
        this.jiR.setNextPage(this.gAi);
        if (this.jiZ > 0) {
            this.gAi.showEmptyView(this.jiZ);
        }
        this.gAi.setOnClickListener(null);
        this.gAi.startLoadData();
    }

    public void WY() {
        this.mHasMore = false;
        this.jiR.setNextPage(this.gAi);
        if (this.jiZ > 0) {
            this.gAi.showEmptyView(this.jiZ);
        }
        this.gAi.setOnClickListener(null);
        this.gAi.endLoadData();
        this.gAi.setText(this.jiE.getResources().getString(R.string.list_has_no_more));
    }

    public void cDW() {
        this.mHasMore = true;
        this.jiR.setNextPage(this.gAi);
        this.gAi.setOnClickListener(this.jiV);
        if (this.jiZ > 0) {
            this.gAi.showEmptyView(this.jiZ);
        }
        this.gAi.endLoadData();
        this.gAi.setText(this.jiE.getResources().getString(R.string.list_click_load_more));
    }

    public View cDX() {
        if (this.gAi == null) {
            return null;
        }
        return this.gAi.getView();
    }

    public void yI(int i) {
        if (this.jjs != null) {
            this.jjs.setVisibility(i);
        }
    }

    public void yJ(int i) {
        if (this.jjs != null) {
            this.jjs.setSelectNumber(i);
        }
    }

    public void yK(int i) {
        if (this.jjt != null) {
            this.jjt.setVisibility(i);
        }
    }

    public void yL(int i) {
        if (this.jjt != null) {
            this.jjt.setMoveNumber(i);
        }
    }

    public boolean cDY() {
        return this.jjt != null && this.jjt.cNc();
    }

    public void cDZ() {
        if (this.jjt != null) {
            this.jjt.cNd();
        }
    }

    public void bSr() {
        this.mHasMore = false;
        this.jiR.setNextPage(null);
    }

    public boolean cEa() {
        return this.gAi.getView().getParent() != null && this.mHasMore;
    }

    public void yM(int i) {
        this.jiZ = i;
    }

    public void yN(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.iQd == null) {
                    this.iQd = new CommonTipView(this.jiE.getActivity());
                }
                this.iQd.setText(R.string.frs_login_tip);
                this.iQd.b((FrameLayout) cDV(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void qJ(boolean z) {
        this.mIsBackground = z;
        if (this.iPi != null) {
            boolean z2 = (this.jiE == null || this.jiE.cCs() == null || this.jiE.cCs().cLN() == null) ? true : this.jiE.cCs().cLN().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iPi.tN(false);
                this.iPi.dcC();
                return;
            }
            this.iPi.tN(true);
            this.iPi.b(this.jiq, this.gyR, this.jja, true);
        }
    }

    public void cm(int i, int i2) {
        if (this.iPi != null) {
            this.iPi.a(i, i2, this.jja, 1);
        }
    }

    public void cn(int i, int i2) {
        this.jiq = i;
        this.gyR = i2;
    }

    public void qK(boolean z) {
        this.jja = z;
    }

    public void cEb() {
        a(this.jjj, this.jiE.cDc());
        if (this.jiS != null) {
            this.jiS.cGu();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.jiE.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.jjk == null) {
                this.jjk = new com.baidu.tieba.video.e(this.jiE.getActivity(), this.jiF);
            }
            this.jjk.l(postWriteCallBackData);
        }
    }

    public void cEc() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.jjB && this.jiE.getActivity() != null && this.jiE.getPageContext() != null) {
            View view = null;
            if (this.jiR != null && (headerViewsCount = this.jiR.getHeaderViewsCount()) < this.jiR.getChildCount()) {
                view = this.jiR.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.jiE.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.jiE.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.jiE.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c lF = dVar.lF();
                lF.setShouldCheckLocInWindow(false);
                lF.show(this.jiE.getActivity());
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lF != null) {
                            lF.dismiss();
                        }
                    }
                }, 4000L);
                this.jjB = true;
            }
        }
    }

    public void b(e.a aVar) {
        if (this.jjs != null) {
            this.jjs.setDeleteCallback(aVar);
        }
    }

    public void cEd() {
        if (this.jjs != null) {
            this.jjs.cEd();
        }
    }

    public void bKl() {
        if (this.jjs != null) {
            this.jjs.bKl();
        }
    }

    public void aX(String str, int i) {
        if (this.jjv == null) {
            this.jjv = new TextView(this.jiE.getActivity());
            this.jjv.setGravity(19);
            this.jjv.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jiE.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.jiE.getActivity(), R.dimen.ds34), 0);
            this.jjv.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jiE.getActivity(), R.dimen.tbds112)));
            this.jjv.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.jiE.getActivity(), R.dimen.fontsize30));
            this.jjv.setMaxLines(2);
            this.jjv.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.jjv.setTextColor(ContextCompat.getColor(this.jiE.getActivity(), R.color.CAM_X0101));
        }
        this.jju.setBackgroundColor(i);
        this.jjv.setText(str);
        this.jju.a(this.jiE.getActivity(), this.jjv, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.ZM != null) {
            this.ZM.setExpanded(z);
        }
    }

    public void cEe() {
        if (this.jiT != null) {
            this.jiT.startPullRefresh();
        }
    }

    public void EK() {
        if (cDU() != null) {
            List<com.baidu.adp.widget.ListView.n> datas = cDU().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.n nVar : datas) {
                    if (nVar instanceof ca) {
                        ca caVar = (ca) nVar;
                        if (caVar.eQj != 0 && caVar.eJQ != null && this.jiE.cCp() != null && this.jiE.cCp().cJb() != null) {
                            int[] imageWidthAndHeight = caVar.eJQ.getImageWidthAndHeight();
                            caVar.eQj = imageWidthAndHeight[0];
                            caVar.eQk = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cDU().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iPi.b(q.this.jiq, q.this.gyR, q.this.jja, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cEf() {
        if (this.jjb == null) {
            return false;
        }
        return this.jjb.cEf();
    }

    public Context getContext() {
        if (this.jiE == null) {
            return null;
        }
        return this.jiE.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.jiT != null) {
            this.jiT.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.jiT != null) {
            this.jiT.startPullRefresh();
        }
    }

    public void cEg() {
        if (this.jiT != null) {
            this.jiT.cEg();
        }
    }

    public void cEh() {
        if (this.jiT != null) {
            this.jiT.cEh();
        }
    }

    public void a(aq aqVar) {
        if (this.jiT != null) {
            this.jiT.a(aqVar);
        }
    }

    public void yO(int i) {
        if (this.jiT != null) {
            this.jiT.yO(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cEi() {
        return this.jiT;
    }

    public boolean cEj() {
        if (this.jiT != null) {
            return this.jiT.cLC() instanceof FrsNewAreaFragment;
        }
        return false;
    }
}
