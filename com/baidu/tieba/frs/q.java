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
    private PbListView gAw;
    private NoNetworkView gyk;
    private ImageView iDv;
    private MessageRedDotView iDw;
    private com.baidu.tieba.play.i iPw;
    private CommonTipView iQr;
    private com.baidu.adp.widget.ListView.l iRt;
    private FrsFragment jiS;
    private View jiW;
    private com.baidu.tieba.c.d jiX;
    private ImageView jiY;
    private ImageView jiZ;
    private FrsHeaderViewContainer jjA;
    private CollapsingToolbarLayout jjB;
    private com.baidu.tieba.frs.vc.h jjF;
    private FrsMultiDelBottomMenuView jjG;
    private FrsMoveAreaBottomMenuView jjH;
    private NavigationBarCoverTip jjI;
    private TextView jjJ;
    private TextView jjK;
    private boolean jjP;
    private TextView jja;
    private ViewStub jjb;
    private BdTypeRecyclerView jjf;
    private com.baidu.tieba.frs.entelechy.adapter.al jjg;
    private com.baidu.tieba.frs.vc.k jjh;
    private View.OnClickListener jjj;
    private View jjk;
    private View jjl;
    private int jjn;
    private com.baidu.tieba.frs.vc.d jjp;
    private com.baidu.tieba.frs.entelechy.a.c jjq;
    private com.baidu.tieba.frs.vc.m jjr;
    private GifView jjs;
    private TbImageView jjt;
    private HashSet<String> jju;
    private ObservedChangeLinearLayout jjw;
    private com.baidu.tieba.frs.entelechy.a.a jjx;
    private com.baidu.tieba.video.e jjy;
    private AppBarLayoutStickyBehavior jjz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout jiT = null;
    private CoordinatorLayout jiU = null;
    private View jiV = null;
    private FrameLayout jjc = null;
    private TbImageView jjd = null;
    private TbImageView jje = null;
    private com.baidu.tbadk.core.dialog.b jji = null;
    private NoNetworkView.a jdH = null;
    private boolean jjm = true;
    private boolean mHasMore = true;
    private boolean jjo = false;
    private int jiE = 0;
    private int gzf = 0;
    private View bLj = null;
    private View jjv = null;
    private boolean hkJ = false;
    private boolean epQ = true;
    private boolean jjC = true;
    private int jjD = -1;
    private int jjE = -1;
    private int jjL = 0;
    private int jjM = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener iRv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.iRt == null) {
                        q.this.iRt = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
                    }
                    q.this.iRt.a(q.this.jjf, 2);
                } else if (q.this.iRt != null) {
                    q.this.iRt.qJ();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jjN = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.jjh != null) {
                q.this.jjh.setInterceptScrollDown(i == 0);
            }
            if (q.this.jjE != i && Math.abs(i) >= 0 && q.this.cDE() != -1) {
                if (Math.abs(i) >= q.this.cDE()) {
                    if (q.this.jjC) {
                        q.this.jjC = false;
                        q.this.qB(q.this.jjC);
                    }
                } else if (!q.this.jjC) {
                    q.this.jjC = true;
                    q.this.qB(q.this.jjC);
                }
                int cDA = q.this.cDA() + q.this.cDz() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cDA;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.jjE - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.yD(Math.abs(cDA - totalScrollRange2));
                        if (q.this.jjv != null) {
                            q.this.jjv.setVisibility(0);
                        }
                    } else if (q.this.jjv != null) {
                        if (q.this.cDy() != UtilHelper.getStatusBarHeight()) {
                            q.this.yD(0);
                        }
                        q.this.jjv.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.hkJ) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.qG(false);
                        } else if (q.this.jjK != null) {
                            q.this.jjK.setAlpha(abs);
                        }
                    }
                    q.this.jjE = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.jjh != null) {
                int cLF = q.this.jjh.cLF();
                int cLG = cLF - q.this.jjh.cLG();
                if (cLF > 0 && Math.abs(i) >= cLG) {
                    q.this.jjh.dismissLoading();
                }
            }
        }
    };
    private Runnable jjO = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.jjb != null) {
                q.this.jjc.setVisibility(0);
                q.this.jje.setVisibility(0);
                q.this.jjd.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.jiS != null && appBarLayout != null && this.jiS.cCz() != null && this.jiS.getPageContext() != null) {
            int cDz = cDz() + getNavigationBarHeight() + cDA();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cCz = this.jiS.cCz();
            ViewGroup.LayoutParams layoutParams = this.jiV.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.jiS != null && this.jiS.cCG();
            if (totalScrollRange <= 0) {
                if (this.jjM != 2) {
                    cCz.AJ(2);
                }
                this.jjM = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cDz) {
                if (this.jjM != 1) {
                    cCz.AJ(1);
                }
                this.jjM = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.jjM != 0) {
                    cCz.AJ(0);
                }
                this.jjM = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.jiS.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.jiV.setLayoutParams(marginLayoutParams);
            }
            Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i + "]");
        }
    }

    public ObservedChangeLinearLayout cDw() {
        return this.jjw;
    }

    public View Um() {
        return this.bLj;
    }

    public View cDx() {
        return this.jjv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDy() {
        if (this.bLj == null) {
            return 0;
        }
        return this.bLj.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDz() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDA() {
        if (this.gyk == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gyk.getHeight();
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
        View cDx = cDx();
        if (UtilHelper.canUseStyleImmersiveSticky() && Um != null && cDx != null && Um.getLayoutParams() != null && cDx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Um.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Um.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cDx.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cDx.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.a.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.jiS = null;
        this.jjj = null;
        this.jjn = 0;
        this.jiS = frsFragment;
        this.jjj = onClickListener;
        MessageManager.getInstance().registerListener(this.iRv);
        a(aVar, z);
        this.jju = new HashSet<>();
        this.jjn = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.jjF = hVar;
    }

    private boolean cDB() {
        return this.jjF != null && this.jjF.cLm();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.a.a aVar, boolean z) {
        boolean z2;
        this.jjx = aVar;
        View rootView = this.jiS.getRootView();
        if (this.jiT == null) {
            this.jiT = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.jiV == null) {
            this.jiV = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.jiU == null) {
            this.jiU = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.jjl == null) {
            this.jjl = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.jjB == null) {
            this.jjB = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.jjA == null) {
            this.jjA = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.jjh == null) {
            this.jjh = new com.baidu.tieba.frs.vc.k(this.jiS);
        }
        if (this.jjw == null) {
            this.jjw = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jjw.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.jjB.setMinimumHeight(i2);
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
        if (this.jiS.cDj()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.jjk == null) {
            this.jjk = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.a.b cFZ = aVar.cFZ();
            if (cFZ != null) {
                cFZ.cV(this.jjk);
            }
        }
        if (this.jiW == null) {
            this.jiW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jiW.setOnClickListener(this.jjj);
            this.mBackImageView = (ImageView) this.jiW.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jiZ == null) {
            this.jiZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bsR().a(this.jiZ, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jiZ.setOnClickListener(this.jjj);
        }
        if (this.jiX == null) {
            this.jiX = new com.baidu.tieba.c.d(this.jiS.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jiX.getView(), (View.OnClickListener) null);
            this.iDv = this.jiX.ctE();
            this.iDw = this.jiX.ctF();
            this.iDw.setShadowEnabled(false);
            this.jiX.getView().setOnClickListener(this.jjj);
            this.jiX.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.jiY == null) {
            this.jiY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bsR().a(this.jiY, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jiY.setOnClickListener(this.jjj);
        }
        if (this.jja == null) {
            this.jja = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.jja.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jiS.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jja.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.l(this.jja, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jja, R.color.CAM_X0101);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.jiS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.jjf == null) {
            this.jjf = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int jjS = 0;

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.jjS--;
                if (this.jjS == 0) {
                    q.this.jjf.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.jjS++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.jjf.setItemAnimator(defaultItemAnimator);
        this.jjf.setLayoutManager(new LinearLayoutManager(this.jjf.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iRt = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
            this.iRt.a(this.jjf, 2);
        }
        this.jjf.setScrollable(this.jiS);
        this.jjf.setFadingEdgeLength(0);
        this.jjf.setOverScrollMode(2);
        this.jiT.setBottomOrderView(this.jjf);
        this.jjf.setOnTouchListener(this.jiS.bST);
        this.jjf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iPw != null) {
                    q.this.iPw.dt(view);
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
        this.jjf.setPadding(dimenPixelSize, this.jjf.getPaddingTop(), dimenPixelSize, this.jjf.getPaddingBottom());
        if (this.gAw == null) {
            this.gAw = new PbListView(this.jiS.getPageContext().getPageActivity());
            this.gAw.getView();
        }
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jiS.getActivity(), R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jjf.setOnSrollToBottomListener(this.jiS);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.jiS.cDc();
                if (q.this.jiS != null && q.this.ZM != null) {
                    q.this.jiS.cDm();
                    q.this.ZM.setExpanded(true);
                    if (q.this.iPw != null) {
                        q.this.iPw.b(q.this.jiE, q.this.gzf, false, true);
                    }
                }
            }
        });
        boolean bsT = com.baidu.tbadk.core.util.av.bsS().bsT();
        if (this.jjg == null) {
            this.jjg = aVar.a(this.jiS, this.jjf, bsT);
        }
        if (this.jjh != null) {
            this.jjh.Q(1, false);
        }
        if (!z) {
            if (this.gyk == null) {
                this.gyk = new NoNetworkView(this.jiS.getActivity());
                this.gyk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.jjw.addView(this.gyk);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gyk.setVisibility(8);
            } else {
                this.gyk.setVisibility(0);
            }
            this.gyk.onChangeSkinType(this.jiS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cDL();
        if (this.jjp == null) {
            this.jjp = aVar.a(this.jiS, this.jiT);
            this.jjp.b(this.jiS.cDn());
        }
        if (this.jjq == null) {
            this.jjq = aVar.b(this.jiS, this.jiT);
            qE(true);
        }
        if (this.bLj == null) {
            this.bLj = rootView.findViewById(R.id.statebar_view);
        }
        if (this.jjv == null) {
            this.jjv = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iPw == null) {
            this.iPw = new com.baidu.tieba.play.i(this.jiS.getPageContext(), this.jjf);
        }
        this.iPw.Ho(1);
        this.iPw.setUniqueId(this.jiS.getUniqueId());
        this.jjI = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.jjr == null) {
            this.jjr = new com.baidu.tieba.frs.vc.m(this.jiS, this.jjI);
        }
        if (this.ZM == null) {
            this.ZM = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.ZM.addOnOffsetChangedListener(this.jjN);
            this.jjC = true;
            this.jjD = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.ZM.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.jjz = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.jjG = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.jjG.setPageContext(this.jiS.getPageContext());
        this.jjH = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.jjH.setPageContext(this.jiS.getPageContext());
        if (this.jjK == null) {
            this.jjK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jiS.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.jjK.setLayoutParams(layoutParams2);
            this.jjK.setPadding(0, 0, this.jiS.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.jjK.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
    }

    public void cb(boolean z) {
        if (z) {
        }
    }

    private void cDC() {
        ViewGroup.LayoutParams layoutParams;
        this.hkJ = cDB();
        if (this.jjA != null && (layoutParams = this.jjA.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.hkJ) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cDz(), 0, 0);
            }
            this.jjA.requestLayout();
        }
    }

    public void cDD() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.jjw != null) {
            cDC();
            if (this.hkJ) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bLj != null) {
                    this.bLj.setAlpha(1.0f);
                }
                if (this.jjv != null) {
                    this.jjv.setAlpha(1.0f);
                }
                if (this.jjK != null) {
                    this.jjK.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qB(boolean z) {
        if (z && this.jiS != null && this.jiS.cCy() != null) {
            this.jiS.cCy().cLt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cDE() {
        int i;
        if (this.ZM == null) {
            return this.jjD;
        }
        if (this.jjD != -1) {
            return this.jjD;
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
        this.jjD = Math.max(0, this.ZM.getTotalScrollRange() - Math.abs(i2));
        return this.jjD;
    }

    public void Ki(String str) {
        if (this.jjr != null) {
            this.jjr.Ki(str);
        }
    }

    public com.baidu.tieba.play.i cDF() {
        return this.iPw;
    }

    public com.baidu.tieba.frs.entelechy.a.c cDG() {
        return this.jjq;
    }

    public void qC(boolean z) {
        if (this.jjp != null) {
            if (com.baidu.tbadk.k.d.bCB().bCC()) {
                this.jjp.qC(false);
            } else {
                this.jjp.qC(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cDH() {
        return this.jjp;
    }

    public void aa(boolean z, boolean z2) {
        if (this.epQ && this.jjq != null) {
            this.jjq.aa(z, z2);
        }
    }

    public void qD(boolean z) {
        this.epQ = z;
        if (!this.epQ && this.jjq != null) {
            this.jjq.aa(false, false);
        }
    }

    public void cDI() {
        if (this.epQ && this.jjq != null) {
            this.jjq.aa(false, false);
        }
        yE(8);
        this.jiZ.setVisibility(8);
        this.jiY.setVisibility(8);
        qC(false);
        this.jjf.setVisibility(8);
        this.jjA.setVisibility(8);
    }

    public void cDJ() {
        if (this.epQ && this.jjq != null) {
            this.jjq.aa(true, false);
        }
        yE(0);
        cDK();
        qC(this.jiS.cDp());
        this.jjf.setVisibility(0);
        this.jjA.setVisibility(0);
    }

    private void yE(int i) {
        if (this.jiX != null) {
            this.jiX.setVisibility(i);
        }
    }

    private void cDK() {
        this.jiZ.setVisibility(0);
        this.jiY.setVisibility(0);
    }

    public void qE(boolean z) {
        if (this.jjq != null) {
            this.jjq.rg(z);
        }
    }

    private void cDL() {
        if (this.jjs == null) {
            View rootView = this.jiS.getRootView();
            this.jjs = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.jjt = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.jjt.setPageId(this.jiS.getUniqueId());
            this.jjs.setLayerType(1, null);
            this.jjt.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cDM() {
        return this.jiW;
    }

    public void g(NoNetworkView.a aVar) {
        this.jdH = aVar;
        if (this.gyk != null) {
            this.gyk.a(this.jdH);
        }
    }

    public void qF(boolean z) {
        if (this.jjq != null) {
            if (z) {
                aa(false, true);
            } else {
                aa(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jjf.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.jjg.a(wVar);
    }

    public void setForumName(String str) {
        this.jjg.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iRv);
        if (this.iPw != null) {
            this.iPw.destroy();
        }
        if (this.jjr != null) {
            this.jjr.onDestory();
        }
        if (this.jjG != null) {
            this.jjG.setPageContext(null);
        }
        if (this.jjH != null) {
            this.jjH.setPageContext(null);
        }
        this.jjg.onDestory();
        this.jjf.setOnSrollToBottomListener(null);
        this.jjf.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.jjO);
        if (this.iQr != null) {
            this.iQr.onDestroy();
        }
        this.jju.clear();
        if (this.jjp != null) {
            this.jjp.cKX();
        }
        if (this.jjy != null) {
            this.jjy.cFE();
        }
        if (this.jjI != null) {
            this.jjI.onDestroy();
        }
        if (this.jjG != null) {
            this.jjG.onDestroy();
        }
        if (this.jjh != null) {
            this.jjh.onDestroy();
        }
    }

    public boolean cDN() {
        if (this.ZM == null || this.jjz == null || !this.jjz.isSticky()) {
            return this.jjp != null && this.jjp.cDN();
        }
        if (this.jjf != null) {
            this.jjf.setSelection(0);
        }
        this.jjz.expandedAppBarLayout(this.ZM);
        return true;
    }

    public boolean cDh() {
        if (this.jjh == null) {
            return false;
        }
        return this.jjh.cDh();
    }

    public void bYo() {
        this.jjf.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.jjK.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.jjK.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.jjK.setText(str2);
            com.baidu.tbadk.core.k.bkT().setForumNameForWaterImage(str);
        }
    }

    public void cDO() {
        if (this.jjg != null) {
            this.jjg.notifyDataSetChanged();
        }
    }

    public void bbC() {
        if (this.jjg instanceof com.baidu.tieba.frs.entelechy.adapter.u) {
            ((com.baidu.tieba.frs.entelechy.adapter.u) this.jjg).bbC();
        }
    }

    private void cDP() {
        if (this.jji == null && this.jiS.getPageContext() != null) {
            String[] strArr = {this.jiS.getPageContext().getPageActivity().getString(R.string.take_photo), this.jiS.getPageContext().getPageActivity().getString(R.string.album)};
            this.jji = new com.baidu.tbadk.core.dialog.b(this.jiS.getPageContext().getPageActivity());
            this.jji.Av(this.jiS.getPageContext().getPageActivity().getString(R.string.operation));
            this.jji.a(strArr, new b.InterfaceC0558b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.jiS.cDi();
                    } else if (i == 1 && q.this.jiS.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.jiS.getPageContext().getPageActivity());
                    }
                }
            });
            this.jji.d(this.jiS.getPageContext());
        }
    }

    public void cDQ() {
        cDP();
        if (this.jji != null) {
            this.jji.bqz();
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
                if (this.jiS != null && this.jiS.cCw() != null && this.jiS.cCw().cJF() == 0) {
                    sVar.yP(this.jiS.cCw().cJM());
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
            this.jjg.b(arrayList2, frsViewData);
            if (this.iPw != null && this.jiE != 0) {
                this.iPw.b(this.jiE, this.gzf, this.jjo, true);
            }
            if (this.jiS != null) {
                this.jiS.cDs();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.jjf;
    }

    public void cDR() {
        this.jjg.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.af afVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jiS.getPageContext(), 1);
        aVar.a(this.jjf);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.jiS.getForumName());
        hashMap.put("forum_id", this.jiS.getForumId());
        aVar.setParams(hashMap);
        aVar.aD(afVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.jjp != null) {
            this.jjp.cKY();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        yF(TbadkCoreApplication.getInst().getSkinType());
        if (this.jjp != null) {
            this.jjp.cKZ();
        }
    }

    public void release() {
        if (this.gyk != null && this.jdH != null) {
            this.gyk.b(this.jdH);
        }
    }

    public ImageView cDS() {
        return this.jiZ;
    }

    public ImageView cDT() {
        return this.jiY;
    }

    public TextView cDU() {
        return this.jja;
    }

    public View cDV() {
        if (this.jiX != null) {
            return this.jiX.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.jiX != null) {
            this.jiX.z(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.jiS, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jiS.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.jjt != null) {
            this.jjt.invalidate();
        }
        if (this.jjg != null) {
            this.jjg.cGE();
            this.jjg.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.jiS.getPageContext(), this.jiT);
        if (this.gyk != null) {
            this.gyk.onChangeSkinType(this.jiS.getPageContext(), i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0109));
            this.gAw.changeSkin(i);
        }
        if (this.jjK != null) {
            this.jjK.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0105));
        }
        yF(i);
        if (this.jjq != null) {
            this.jjq.onChangeSkinType(i);
        }
        if (this.jjp != null) {
            this.jjp.onChangeSkinType(i);
        }
        if (this.jjG != null) {
            this.jjG.onChangeSkinType();
        }
        if (this.jjH != null) {
            this.jjH.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jiV, R.color.CAM_X0202);
    }

    private void yF(int i) {
        if (this.jiS != null) {
            yG(i);
        }
    }

    private void yG(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jiS.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jjk, R.color.CAM_X0204, i);
            if (this.jiX != null) {
                this.jiX.onChangeSkinType(i);
            }
            if (this.jiZ != null) {
                SvgManager.bsR().a(this.jiZ, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jiY != null) {
                SvgManager.bsR().a(this.jiY, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.bLj, R.color.CAM_X0207);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.jjv, R.color.CAM_X0207);
        qG(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hkJ) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.jjL != 0) {
                    SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bsR().a(this.jiZ, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iDv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
                    SvgManager.bsR().a(this.jiY, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.jjL = 0;
                }
            } else if (z || this.jjL != 1) {
                SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsR().a(this.jiZ, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iDv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0106), (WebPManager.ResourceStateType) null));
                SvgManager.bsR().a(this.jiY, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.jjL = 1;
            }
            cDW();
        }
    }

    private void cDW() {
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
            if (this.jjK != null) {
                this.jjK.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.iDv != null) {
                    this.iDv.setAlpha(f);
                }
                if (this.jiS != null && this.jiS.cCz() != null && this.jjL == 1) {
                    this.jiS.cCz().aK(f);
                }
                if (this.iDw != null) {
                    this.iDw.setAlpha(f);
                }
                if (this.jiZ != null) {
                    this.jiZ.setAlpha(f);
                }
                if (this.jiY != null) {
                    this.jiY.setAlpha(f);
                }
            }
            if (this.jja != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.jja.setAlpha(f2);
                this.jja.setClickable(f2 > 0.0f);
            }
            if (this.bLj != null) {
                this.bLj.setAlpha(alpha);
            }
            if (this.jjv != null) {
                this.jjv.setAlpha(alpha);
            }
            if (this.jjk != null) {
                this.jjk.setAlpha(alpha);
            }
        }
    }

    public void bRI() {
        if (this.jjh != null) {
            this.jjh.bRI();
        }
    }

    public void qH(boolean z) {
        if (this.jjh != null) {
            this.jjh.qH(z);
        }
    }

    public void qI(boolean z) {
        this.jjm = z;
        if (this.jjm) {
            this.gAw.setText(this.jiS.getResources().getString(R.string.load_more));
            if (this.jjf.getChildAt(this.jjf.getChildCount() - 1) == this.gAw.getView()) {
                this.gAw.startLoadData();
                this.jiS.bRj();
                return;
            }
            this.gAw.endLoadData();
            return;
        }
        this.gAw.setText(this.jiS.getResources().getString(R.string.load_more_must_after_delete));
        this.gAw.endLoadData();
    }

    public boolean cDX() {
        if (this.jjm) {
            return false;
        }
        this.gAw.setText(this.jiS.getResources().getString(R.string.load_more_must_after_delete));
        this.gAw.endLoadData();
        return true;
    }

    public boolean cDY() {
        return this.jjb != null && this.jje.getVisibility() == 0;
    }

    public void cDZ() {
        if (this.jjb != null) {
            this.jjc.setVisibility(0);
            this.jje.setVisibility(8);
            this.jjd.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.jjO, 5000L);
        }
    }

    public void a(cl clVar) {
        if (this.jjb == null) {
            View rootView = this.jiS.getRootView();
            this.jjb = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.jjb.setVisibility(0);
            this.jjc = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.jjd = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.jje = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.jjd.setPageId(this.jiS.getUniqueId());
            this.jje.setPageId(this.jiS.getUniqueId());
            this.jjd.setDefaultBgResource(R.color.common_color_10022);
            this.jjd.setDefaultResource(0);
            this.jje.setDefaultBgResource(R.color.common_color_10022);
            this.jje.setDefaultResource(0);
            this.jjc.setOnClickListener(this.jjj);
        }
        this.jjc.setVisibility(0);
        String bql = clVar.bql();
        String bqm = clVar.bqm();
        this.jjd.startLoad(bql, 10, false);
        this.jje.startLoad(bqm, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.jjO, 5000L);
    }

    public void cEa() {
        if (this.jjb != null && this.jjc != null) {
            this.jjc.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.adapter.al cEb() {
        return this.jjg;
    }

    public RelativeLayout cnu() {
        return this.jiT;
    }

    public View cEc() {
        return this.jjl;
    }

    public void yH(int i) {
        if (this.jiV != null) {
            this.jiV.setVisibility(i);
        }
    }

    public NavigationBar bVk() {
        return this.mNavigationBar;
    }

    public void WX() {
        this.mHasMore = true;
        this.jjf.setNextPage(this.gAw);
        if (this.jjn > 0) {
            this.gAw.showEmptyView(this.jjn);
        }
        this.gAw.setOnClickListener(null);
        this.gAw.startLoadData();
    }

    public void WY() {
        this.mHasMore = false;
        this.jjf.setNextPage(this.gAw);
        if (this.jjn > 0) {
            this.gAw.showEmptyView(this.jjn);
        }
        this.gAw.setOnClickListener(null);
        this.gAw.endLoadData();
        this.gAw.setText(this.jiS.getResources().getString(R.string.list_has_no_more));
    }

    public void cEd() {
        this.mHasMore = true;
        this.jjf.setNextPage(this.gAw);
        this.gAw.setOnClickListener(this.jjj);
        if (this.jjn > 0) {
            this.gAw.showEmptyView(this.jjn);
        }
        this.gAw.endLoadData();
        this.gAw.setText(this.jiS.getResources().getString(R.string.list_click_load_more));
    }

    public View cEe() {
        if (this.gAw == null) {
            return null;
        }
        return this.gAw.getView();
    }

    public void yI(int i) {
        if (this.jjG != null) {
            this.jjG.setVisibility(i);
        }
    }

    public void yJ(int i) {
        if (this.jjG != null) {
            this.jjG.setSelectNumber(i);
        }
    }

    public void yK(int i) {
        if (this.jjH != null) {
            this.jjH.setVisibility(i);
        }
    }

    public void yL(int i) {
        if (this.jjH != null) {
            this.jjH.setMoveNumber(i);
        }
    }

    public boolean cEf() {
        return this.jjH != null && this.jjH.cNj();
    }

    public void cEg() {
        if (this.jjH != null) {
            this.jjH.cNk();
        }
    }

    public void bSy() {
        this.mHasMore = false;
        this.jjf.setNextPage(null);
    }

    public boolean cEh() {
        return this.gAw.getView().getParent() != null && this.mHasMore;
    }

    public void yM(int i) {
        this.jjn = i;
    }

    public void yN(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.iQr == null) {
                    this.iQr = new CommonTipView(this.jiS.getActivity());
                }
                this.iQr.setText(R.string.frs_login_tip);
                this.iQr.b((FrameLayout) cEc(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void qJ(boolean z) {
        this.mIsBackground = z;
        if (this.iPw != null) {
            boolean z2 = (this.jiS == null || this.jiS.cCz() == null || this.jiS.cCz().cLU() == null) ? true : this.jiS.cCz().cLU().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iPw.tN(false);
                this.iPw.dcJ();
                return;
            }
            this.iPw.tN(true);
            this.iPw.b(this.jiE, this.gzf, this.jjo, true);
        }
    }

    public void cn(int i, int i2) {
        if (this.iPw != null) {
            this.iPw.a(i, i2, this.jjo, 1);
        }
    }

    public void co(int i, int i2) {
        this.jiE = i;
        this.gzf = i2;
    }

    public void qK(boolean z) {
        this.jjo = z;
    }

    public void cEi() {
        a(this.jjx, this.jiS.cDj());
        if (this.jjg != null) {
            this.jjg.cGB();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.jiS.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.jjy == null) {
                this.jjy = new com.baidu.tieba.video.e(this.jiS.getActivity(), this.jiT);
            }
            this.jjy.l(postWriteCallBackData);
        }
    }

    public void cEj() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.jjP && this.jiS.getActivity() != null && this.jiS.getPageContext() != null) {
            View view = null;
            if (this.jjf != null && (headerViewsCount = this.jjf.getHeaderViewsCount()) < this.jjf.getChildCount()) {
                view = this.jjf.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.jiS.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.jiS.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.jiS.getActivity(), R.dimen.ds6);
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
                lF.show(this.jiS.getActivity());
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lF != null) {
                            lF.dismiss();
                        }
                    }
                }, 4000L);
                this.jjP = true;
            }
        }
    }

    public void b(e.a aVar) {
        if (this.jjG != null) {
            this.jjG.setDeleteCallback(aVar);
        }
    }

    public void cEk() {
        if (this.jjG != null) {
            this.jjG.cEk();
        }
    }

    public void bKq() {
        if (this.jjG != null) {
            this.jjG.bKq();
        }
    }

    public void aX(String str, int i) {
        if (this.jjJ == null) {
            this.jjJ = new TextView(this.jiS.getActivity());
            this.jjJ.setGravity(19);
            this.jjJ.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jiS.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.jiS.getActivity(), R.dimen.ds34), 0);
            this.jjJ.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jiS.getActivity(), R.dimen.tbds112)));
            this.jjJ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.jiS.getActivity(), R.dimen.fontsize30));
            this.jjJ.setMaxLines(2);
            this.jjJ.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.jjJ.setTextColor(ContextCompat.getColor(this.jiS.getActivity(), R.color.CAM_X0101));
        }
        this.jjI.setBackgroundColor(i);
        this.jjJ.setText(str);
        this.jjI.a(this.jiS.getActivity(), this.jjJ, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.ZM != null) {
            this.ZM.setExpanded(z);
        }
    }

    public void cEl() {
        if (this.jjh != null) {
            this.jjh.startPullRefresh();
        }
    }

    public void EK() {
        if (cEb() != null) {
            List<com.baidu.adp.widget.ListView.n> datas = cEb().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.n nVar : datas) {
                    if (nVar instanceof ca) {
                        ca caVar = (ca) nVar;
                        if (caVar.eQj != 0 && caVar.eJQ != null && this.jiS.cCw() != null && this.jiS.cCw().cJi() != null) {
                            int[] imageWidthAndHeight = caVar.eJQ.getImageWidthAndHeight();
                            caVar.eQj = imageWidthAndHeight[0];
                            caVar.eQk = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cEb().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iPw.b(q.this.jiE, q.this.gzf, q.this.jjo, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cEm() {
        if (this.jjp == null) {
            return false;
        }
        return this.jjp.cEm();
    }

    public Context getContext() {
        if (this.jiS == null) {
            return null;
        }
        return this.jiS.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.jjh != null) {
            this.jjh.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.jjh != null) {
            this.jjh.startPullRefresh();
        }
    }

    public void cEn() {
        if (this.jjh != null) {
            this.jjh.cEn();
        }
    }

    public void cEo() {
        if (this.jjh != null) {
            this.jjh.cEo();
        }
    }

    public void a(aq aqVar) {
        if (this.jjh != null) {
            this.jjh.a(aqVar);
        }
    }

    public void yO(int i) {
        if (this.jjh != null) {
            this.jjh.yO(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cEp() {
        return this.jjh;
    }

    public boolean cEq() {
        if (this.jjh != null) {
            return this.jjh.cLJ() instanceof FrsNewAreaFragment;
        }
        return false;
    }
}
