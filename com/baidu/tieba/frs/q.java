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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.cj;
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
    private AppBarLayout ZS;
    private PbListView gCf;
    private NoNetworkView gzT;
    private ImageView iCe;
    private MessageRedDotView iCf;
    private com.baidu.tieba.play.i iOh;
    private CommonTipView iPc;
    private com.baidu.adp.widget.ListView.l iQe;
    private FrsFragment jhE;
    private View jhI;
    private com.baidu.tieba.c.d jhJ;
    private ImageView jhK;
    private ImageView jhL;
    private TextView jhM;
    private ViewStub jhN;
    private BdTypeRecyclerView jhR;
    private com.baidu.tieba.frs.entelechy.adapter.al jhS;
    private com.baidu.tieba.frs.vc.k jhT;
    private View.OnClickListener jhV;
    private View jhW;
    private View jhX;
    private int jhZ;
    private boolean jiC;
    private com.baidu.tieba.frs.vc.d jib;
    private com.baidu.tieba.frs.entelechy.a.c jic;
    private com.baidu.tieba.frs.vc.m jie;
    private GifView jif;
    private TbImageView jig;
    private HashSet<String> jih;
    private ObservedChangeLinearLayout jij;
    private com.baidu.tieba.frs.entelechy.a.a jik;
    private com.baidu.tieba.video.e jil;
    private AppBarLayoutStickyBehavior jim;
    private FrsHeaderViewContainer jin;
    private CollapsingToolbarLayout jio;
    private com.baidu.tieba.frs.vc.h jis;
    private FrsMultiDelBottomMenuView jit;
    private FrsMoveAreaBottomMenuView jiu;
    private NavigationBarCoverTip jiv;
    private TextView jiw;
    private TextView jix;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout jhF = null;
    private CoordinatorLayout jhG = null;
    private View jhH = null;
    private FrameLayout jhO = null;
    private TbImageView jhP = null;
    private TbImageView jhQ = null;
    private com.baidu.tbadk.core.dialog.b jhU = null;
    private NoNetworkView.a jct = null;
    private boolean jhY = true;
    private boolean mHasMore = true;
    private boolean jia = false;
    private int jhq = 0;
    private int gAO = 0;
    private View bMl = null;
    private View jii = null;
    private boolean hkM = false;
    private boolean esx = true;
    private boolean jip = true;
    private int jiq = -1;
    private int jir = -1;
    private int jiy = 0;
    private int jiz = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener iQg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.iQe == null) {
                        q.this.iQe = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
                    }
                    q.this.iQe.a(q.this.jhR, 2);
                } else if (q.this.iQe != null) {
                    q.this.iQe.qL();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jiA = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.jhT != null) {
                q.this.jhT.setInterceptScrollDown(i == 0);
            }
            if (q.this.jir != i && Math.abs(i) >= 0 && q.this.cGd() != -1) {
                if (Math.abs(i) >= q.this.cGd()) {
                    if (q.this.jip) {
                        q.this.jip = false;
                        q.this.qv(q.this.jip);
                    }
                } else if (!q.this.jip) {
                    q.this.jip = true;
                    q.this.qv(q.this.jip);
                }
                int cFZ = q.this.cFZ() + q.this.cFY() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cFZ;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.jir - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.zZ(Math.abs(cFZ - totalScrollRange2));
                        if (q.this.jii != null) {
                            q.this.jii.setVisibility(0);
                        }
                    } else if (q.this.jii != null) {
                        if (q.this.cFX() != UtilHelper.getStatusBarHeight()) {
                            q.this.zZ(0);
                        }
                        q.this.jii.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.hkM) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.qA(false);
                        } else if (q.this.jix != null) {
                            q.this.jix.setAlpha(abs);
                        }
                    }
                    q.this.jir = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.jhT != null) {
                int cOc = q.this.jhT.cOc();
                int cOd = cOc - q.this.jhT.cOd();
                if (cOc > 0 && Math.abs(i) >= cOd) {
                    q.this.jhT.dismissLoading();
                }
            }
        }
    };
    private Runnable jiB = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.jhN != null) {
                q.this.jhO.setVisibility(0);
                q.this.jhQ.setVisibility(0);
                q.this.jhP.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.jhE != null && appBarLayout != null && this.jhE.cEY() != null && this.jhE.getPageContext() != null) {
            int cFY = cFY() + getNavigationBarHeight() + cFZ();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cEY = this.jhE.cEY();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.jhE.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.jhE.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.jhH.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.jhE != null && this.jhE.cFf();
            if (totalScrollRange <= 0) {
                if (this.jiz != 2) {
                    cEY.Cf(2);
                }
                this.jiz = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cFY) {
                if (this.jiz != 1) {
                    cEY.Cf(1);
                }
                this.jiz = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.jiz != 0) {
                    cEY.Cf(0);
                }
                this.jiz = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.jhE.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.jhH.setLayoutParams(marginLayoutParams);
            }
            Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i + "]");
        }
    }

    public ObservedChangeLinearLayout cFV() {
        return this.jij;
    }

    public View Wy() {
        return this.bMl;
    }

    public View cFW() {
        return this.jii;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cFX() {
        if (this.bMl == null) {
            return 0;
        }
        return this.bMl.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cFY() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cFZ() {
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
    public void zZ(int i) {
        View Wy = Wy();
        View cFW = cFW();
        if (UtilHelper.canUseStyleImmersiveSticky() && Wy != null && cFW != null && Wy.getLayoutParams() != null && cFW.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Wy.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Wy.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cFW.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cFW.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.a.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.jhE = null;
        this.jhV = null;
        this.jhZ = 0;
        this.jhE = frsFragment;
        this.jhV = onClickListener;
        MessageManager.getInstance().registerListener(this.iQg);
        a(aVar, z);
        this.jih = new HashSet<>();
        this.jhZ = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.jis = hVar;
    }

    private boolean cGa() {
        return this.jis != null && this.jis.cNJ();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.a.a aVar, boolean z) {
        boolean z2;
        this.jik = aVar;
        View rootView = this.jhE.getRootView();
        if (this.jhF == null) {
            this.jhF = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.jhH == null) {
            this.jhH = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.jhG == null) {
            this.jhG = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.jhX == null) {
            this.jhX = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.jio == null) {
            this.jio = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.jin == null) {
            this.jin = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.jhT == null) {
            this.jhT = new com.baidu.tieba.frs.vc.k(this.jhE);
        }
        if (this.jij == null) {
            this.jij = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jij.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.jio.setMinimumHeight(i2);
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
        if (this.jhE.cFI()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.jhW == null) {
            this.jhW = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.a.b cIx = aVar.cIx();
            if (cIx != null) {
                cIx.cX(this.jhW);
            }
        }
        if (this.jhI == null) {
            this.jhI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jhI.setOnClickListener(this.jhV);
            this.mBackImageView = (ImageView) this.jhI.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jhL == null) {
            this.jhL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bwr().a(this.jhL, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jhL.setOnClickListener(this.jhV);
        }
        if (this.jhJ == null) {
            this.jhJ = new com.baidu.tieba.c.d(this.jhE.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jhJ.getView(), (View.OnClickListener) null);
            this.iCe = this.jhJ.cwd();
            this.iCf = this.jhJ.cwe();
            this.iCf.setShadowEnabled(false);
            this.jhJ.getView().setOnClickListener(this.jhV);
            this.jhJ.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.jhK == null) {
            this.jhK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bwr().a(this.jhK, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jhK.setOnClickListener(this.jhV);
        }
        if (this.jhM == null) {
            this.jhM = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.jhM.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jhE.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jhM.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ao.l(this.jhM, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.jhM, R.color.CAM_X0101);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.jhE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.jhR == null) {
            this.jhR = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int jiF = 0;

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.jiF--;
                if (this.jiF == 0) {
                    q.this.jhR.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.jiF++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.jhR.setItemAnimator(defaultItemAnimator);
        this.jhR.setLayoutManager(new LinearLayoutManager(this.jhR.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iQe = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
            this.iQe.a(this.jhR, 2);
        }
        this.jhR.setScrollable(this.jhE);
        this.jhR.setFadingEdgeLength(0);
        this.jhR.setOverScrollMode(2);
        this.jhF.setBottomOrderView(this.jhR);
        this.jhR.setOnTouchListener(this.jhE.bTP);
        this.jhR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iOh != null) {
                    q.this.iOh.dv(view);
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
        this.jhR.setPadding(dimenPixelSize, this.jhR.getPaddingTop(), dimenPixelSize, this.jhR.getPaddingBottom());
        if (this.gCf == null) {
            this.gCf = new PbListView(this.jhE.getPageContext().getPageActivity());
            this.gCf.getView();
        }
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jhE.getActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0109));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jhR.setOnSrollToBottomListener(this.jhE);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.jhE.cFB();
                if (q.this.jhE != null && q.this.ZS != null) {
                    q.this.jhE.cFL();
                    q.this.ZS.setExpanded(true);
                    if (q.this.iOh != null) {
                        q.this.iOh.b(q.this.jhq, q.this.gAO, false, true);
                    }
                }
            }
        });
        boolean bwt = com.baidu.tbadk.core.util.au.bws().bwt();
        if (this.jhS == null) {
            this.jhS = aVar.a(this.jhE, this.jhR, bwt);
        }
        if (this.jhT != null) {
            this.jhT.Q(1, false);
        }
        if (!z) {
            if (this.gzT == null) {
                this.gzT = new NoNetworkView(this.jhE.getActivity());
                this.gzT.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.jij.addView(this.gzT);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gzT.setVisibility(8);
            } else {
                this.gzT.setVisibility(0);
            }
            this.gzT.onChangeSkinType(this.jhE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cGk();
        if (this.jib == null) {
            this.jib = aVar.a(this.jhE, this.jhF);
            this.jib.b(this.jhE.cFM());
        }
        if (this.jic == null) {
            this.jic = aVar.b(this.jhE, this.jhF);
            qy(true);
        }
        if (this.bMl == null) {
            this.bMl = rootView.findViewById(R.id.statebar_view);
        }
        if (this.jii == null) {
            this.jii = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iOh == null) {
            this.iOh = new com.baidu.tieba.play.i(this.jhE.getPageContext(), this.jhR);
        }
        this.iOh.ID(1);
        this.iOh.setUniqueId(this.jhE.getUniqueId());
        this.jiv = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.jie == null) {
            this.jie = new com.baidu.tieba.frs.vc.m(this.jhE, this.jiv);
        }
        if (this.ZS == null) {
            this.ZS = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.ZS.addOnOffsetChangedListener(this.jiA);
            this.jip = true;
            this.jiq = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.ZS.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.jim = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.jit = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.jit.setPageContext(this.jhE.getPageContext());
        this.jiu = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.jiu.setPageContext(this.jhE.getPageContext());
        if (this.jix == null) {
            this.jix = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jhE.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.jix.setLayoutParams(layoutParams2);
            this.jix.setPadding(0, 0, this.jhE.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.jix.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
        }
    }

    public void ca(boolean z) {
        if (z) {
        }
    }

    private void cGb() {
        ViewGroup.LayoutParams layoutParams;
        this.hkM = cGa();
        if (this.jin != null && (layoutParams = this.jin.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.hkM) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cFY(), 0, 0);
            }
            this.jin.requestLayout();
        }
    }

    public void cGc() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.jij != null) {
            cGb();
            if (this.hkM) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bMl != null) {
                    this.bMl.setAlpha(1.0f);
                }
                if (this.jii != null) {
                    this.jii.setAlpha(1.0f);
                }
                if (this.jix != null) {
                    this.jix.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(boolean z) {
        if (z && this.jhE != null && this.jhE.cEX() != null) {
            this.jhE.cEX().cNQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGd() {
        int i;
        if (this.ZS == null) {
            return this.jiq;
        }
        if (this.jiq != -1) {
            return this.jiq;
        }
        int childCount = this.ZS.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.ZS.getChildAt(childCount);
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
        this.jiq = Math.max(0, this.ZS.getTotalScrollRange() - Math.abs(i2));
        return this.jiq;
    }

    public void KH(String str) {
        if (this.jie != null) {
            this.jie.KH(str);
        }
    }

    public com.baidu.tieba.play.i cGe() {
        return this.iOh;
    }

    public com.baidu.tieba.frs.entelechy.a.c cGf() {
        return this.jic;
    }

    public void qw(boolean z) {
        if (this.jib != null) {
            if (com.baidu.tbadk.k.d.bGc().bGd()) {
                this.jib.qw(false);
            } else {
                this.jib.qw(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cGg() {
        return this.jib;
    }

    public void aa(boolean z, boolean z2) {
        if (this.esx && this.jic != null) {
            this.jic.aa(z, z2);
        }
    }

    public void qx(boolean z) {
        this.esx = z;
        if (!this.esx && this.jic != null) {
            this.jic.aa(false, false);
        }
    }

    public void cGh() {
        if (this.esx && this.jic != null) {
            this.jic.aa(false, false);
        }
        Aa(8);
        this.jhL.setVisibility(8);
        this.jhK.setVisibility(8);
        qw(false);
        this.jhR.setVisibility(8);
        this.jin.setVisibility(8);
    }

    public void cGi() {
        if (this.esx && this.jic != null) {
            this.jic.aa(true, false);
        }
        Aa(0);
        cGj();
        qw(this.jhE.cFO());
        this.jhR.setVisibility(0);
        this.jin.setVisibility(0);
    }

    private void Aa(int i) {
        if (this.jhJ != null) {
            this.jhJ.setVisibility(i);
        }
    }

    private void cGj() {
        this.jhL.setVisibility(0);
        this.jhK.setVisibility(0);
    }

    public void qy(boolean z) {
        if (this.jic != null) {
            this.jic.ra(z);
        }
    }

    private void cGk() {
        if (this.jif == null) {
            View rootView = this.jhE.getRootView();
            this.jif = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.jig = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.jig.setPageId(this.jhE.getUniqueId());
            this.jif.setLayerType(1, null);
            this.jig.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cGl() {
        return this.jhI;
    }

    public void g(NoNetworkView.a aVar) {
        this.jct = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jct);
        }
    }

    public void qz(boolean z) {
        if (this.jic != null) {
            if (z) {
                aa(false, true);
            } else {
                aa(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jhR.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.jhS.a(wVar);
    }

    public void setForumName(String str) {
        this.jhS.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iQg);
        if (this.iOh != null) {
            this.iOh.destroy();
        }
        if (this.jie != null) {
            this.jie.onDestory();
        }
        if (this.jit != null) {
            this.jit.setPageContext(null);
        }
        if (this.jiu != null) {
            this.jiu.setPageContext(null);
        }
        this.jhS.onDestory();
        this.jhR.setOnSrollToBottomListener(null);
        this.jhR.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.jiB);
        if (this.iPc != null) {
            this.iPc.onDestroy();
        }
        this.jih.clear();
        if (this.jib != null) {
            this.jib.cNv();
        }
        if (this.jil != null) {
            this.jil.cIc();
        }
        if (this.jiv != null) {
            this.jiv.onDestroy();
        }
        if (this.jit != null) {
            this.jit.onDestroy();
        }
        if (this.jhT != null) {
            this.jhT.onDestroy();
        }
    }

    public boolean cGm() {
        if (this.ZS == null || this.jim == null || !this.jim.isSticky()) {
            return this.jib != null && this.jib.cGm();
        }
        if (this.jhR != null) {
            this.jhR.setSelection(0);
        }
        this.jim.expandedAppBarLayout(this.ZS);
        return true;
    }

    public boolean cFG() {
        if (this.jhT == null) {
            return false;
        }
        return this.jhT.cFG();
    }

    public void caZ() {
        this.jhR.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.jix.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.jix.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.jix.setText(str2);
            com.baidu.tbadk.core.k.bov().setForumNameForWaterImage(str);
        }
    }

    public void cGn() {
        if (this.jhS != null) {
            this.jhS.notifyDataSetChanged();
        }
    }

    public void bfj() {
        if (this.jhS instanceof com.baidu.tieba.frs.entelechy.adapter.u) {
            ((com.baidu.tieba.frs.entelechy.adapter.u) this.jhS).bfj();
        }
    }

    private void cGo() {
        if (this.jhU == null && this.jhE.getPageContext() != null) {
            String[] strArr = {this.jhE.getPageContext().getPageActivity().getString(R.string.take_photo), this.jhE.getPageContext().getPageActivity().getString(R.string.album)};
            this.jhU = new com.baidu.tbadk.core.dialog.b(this.jhE.getPageContext().getPageActivity());
            this.jhU.Bp(this.jhE.getPageContext().getPageActivity().getString(R.string.operation));
            this.jhU.a(strArr, new b.InterfaceC0578b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.jhE.cFH();
                    } else if (i == 1 && q.this.jhE.getPageContext() != null) {
                        com.baidu.tbadk.core.util.an.getAlbumImage(q.this.jhE.getPageContext().getPageActivity());
                    }
                }
            });
            this.jhU.d(this.jhE.getPageContext());
        }
    }

    public void cGp() {
        cGo();
        if (this.jhU != null) {
            this.jhU.bua();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.n> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.x.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                s sVar = new s();
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList3 = new ArrayList<>();
                arrayList3.add(sVar);
                if (this.jhE != null && this.jhE.cEV() != null && this.jhE.cEV().cMd() == 0) {
                    sVar.Al(this.jhE.cEV().cMk());
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = switchThreadDataToThreadCardInfo;
            }
            if (com.baidu.tbadk.core.util.x.getCount(arrayList2) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.n nVar = arrayList2.get(i2);
                    if (nVar instanceof by) {
                        ((by) nVar).eMv.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.jhS.b(arrayList2, frsViewData);
            if (this.iOh != null && this.jhq != 0) {
                this.iOh.b(this.jhq, this.gAO, this.jia, true);
            }
            if (this.jhE != null) {
                this.jhE.cFR();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.jhR;
    }

    public void cGq() {
        this.jhS.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ae aeVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jhE.getPageContext(), 1);
        aVar.a(this.jhR);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.jhE.getForumName());
        hashMap.put("forum_id", this.jhE.getForumId());
        aVar.setParams(hashMap);
        aVar.aD(aeVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.jib != null) {
            this.jib.cNw();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        Ab(TbadkCoreApplication.getInst().getSkinType());
        if (this.jib != null) {
            this.jib.cNx();
        }
    }

    public void release() {
        if (this.gzT != null && this.jct != null) {
            this.gzT.b(this.jct);
        }
    }

    public ImageView cGr() {
        return this.jhL;
    }

    public ImageView cGs() {
        return this.jhK;
    }

    public TextView cGt() {
        return this.jhM;
    }

    public View cGu() {
        if (this.jhJ != null) {
            return this.jhJ.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.jhJ != null) {
            this.jhJ.z(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.jhE, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jhE.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.jig != null) {
            this.jig.invalidate();
        }
        if (this.jhS != null) {
            this.jhS.cJc();
            this.jhS.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.jhE.getPageContext(), this.jhF);
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(this.jhE.getPageContext(), i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.jix != null) {
            this.jix.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
        }
        Ab(i);
        if (this.jic != null) {
            this.jic.onChangeSkinType(i);
        }
        if (this.jib != null) {
            this.jib.onChangeSkinType(i);
        }
        if (this.jit != null) {
            this.jit.onChangeSkinType();
        }
        if (this.jiu != null) {
            this.jiu.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jhH, R.color.CAM_X0202);
    }

    private void Ab(int i) {
        if (this.jhE != null) {
            Ac(i);
        }
    }

    private void Ac(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jhE.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jhW, R.color.CAM_X0204, i);
            if (this.jhJ != null) {
                this.jhJ.onChangeSkinType(i);
            }
            if (this.jhL != null) {
                SvgManager.bwr().a(this.jhL, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jhK != null) {
                SvgManager.bwr().a(this.jhK, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.bMl, R.color.CAM_X0207);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jii, R.color.CAM_X0207);
        qA(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qA(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hkM) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.jiy != 0) {
                    SvgManager.bwr().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bwr().a(this.jhL, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.iCe.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
                    SvgManager.bwr().a(this.jhK, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.jiy = 0;
                }
            } else if (z || this.jiy != 1) {
                SvgManager.bwr().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bwr().a(this.jhL, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.iCe.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0106), (WebPManager.ResourceStateType) null));
                SvgManager.bwr().a(this.jhK, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.jiy = 1;
            }
            cGv();
        }
    }

    private void cGv() {
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
            if (this.jix != null) {
                this.jix.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.iCe != null) {
                    this.iCe.setAlpha(f);
                }
                if (this.jhE != null && this.jhE.cEY() != null && this.jiy == 1) {
                    this.jhE.cEY().aH(f);
                }
                if (this.iCf != null) {
                    this.iCf.setAlpha(f);
                }
                if (this.jhL != null) {
                    this.jhL.setAlpha(f);
                }
                if (this.jhK != null) {
                    this.jhK.setAlpha(f);
                }
            }
            if (this.jhM != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.jhM.setAlpha(f2);
                this.jhM.setClickable(f2 > 0.0f);
            }
            if (this.bMl != null) {
                this.bMl.setAlpha(alpha);
            }
            if (this.jii != null) {
                this.jii.setAlpha(alpha);
            }
            if (this.jhW != null) {
                this.jhW.setAlpha(alpha);
            }
        }
    }

    public void bUP() {
        if (this.jhT != null) {
            this.jhT.bUP();
        }
    }

    public void qB(boolean z) {
        if (this.jhT != null) {
            this.jhT.qB(z);
        }
    }

    public void qC(boolean z) {
        this.jhY = z;
        if (this.jhY) {
            this.gCf.setText(this.jhE.getResources().getString(R.string.load_more));
            if (this.jhR.getChildAt(this.jhR.getChildCount() - 1) == this.gCf.getView()) {
                this.gCf.startLoadData();
                this.jhE.bUq();
                return;
            }
            this.gCf.endLoadData();
            return;
        }
        this.gCf.setText(this.jhE.getResources().getString(R.string.load_more_must_after_delete));
        this.gCf.endLoadData();
    }

    public boolean cGw() {
        if (this.jhY) {
            return false;
        }
        this.gCf.setText(this.jhE.getResources().getString(R.string.load_more_must_after_delete));
        this.gCf.endLoadData();
        return true;
    }

    public boolean cGx() {
        return this.jhN != null && this.jhQ.getVisibility() == 0;
    }

    public void cGy() {
        if (this.jhN != null) {
            this.jhO.setVisibility(0);
            this.jhQ.setVisibility(8);
            this.jhP.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.jiB, 5000L);
        }
    }

    public void a(cj cjVar) {
        if (this.jhN == null) {
            View rootView = this.jhE.getRootView();
            this.jhN = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.jhN.setVisibility(0);
            this.jhO = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.jhP = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.jhQ = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.jhP.setPageId(this.jhE.getUniqueId());
            this.jhQ.setPageId(this.jhE.getUniqueId());
            this.jhP.setDefaultBgResource(R.color.common_color_10022);
            this.jhP.setDefaultResource(0);
            this.jhQ.setDefaultBgResource(R.color.common_color_10022);
            this.jhQ.setDefaultResource(0);
            this.jhO.setOnClickListener(this.jhV);
        }
        this.jhO.setVisibility(0);
        String btN = cjVar.btN();
        String btO = cjVar.btO();
        this.jhP.startLoad(btN, 10, false);
        this.jhQ.startLoad(btO, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.jiB, 5000L);
    }

    public void cGz() {
        if (this.jhN != null && this.jhO != null) {
            this.jhO.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.adapter.al cGA() {
        return this.jhS;
    }

    public RelativeLayout cqh() {
        return this.jhF;
    }

    public View cGB() {
        return this.jhX;
    }

    public void Ad(int i) {
        if (this.jhH != null) {
            this.jhH.setVisibility(i);
        }
    }

    public NavigationBar bYr() {
        return this.mNavigationBar;
    }

    public void Zh() {
        this.mHasMore = true;
        this.jhR.setNextPage(this.gCf);
        if (this.jhZ > 0) {
            this.gCf.showEmptyView(this.jhZ);
        }
        this.gCf.setOnClickListener(null);
        this.gCf.startLoadData();
    }

    public void Zi() {
        this.mHasMore = false;
        this.jhR.setNextPage(this.gCf);
        if (this.jhZ > 0) {
            this.gCf.showEmptyView(this.jhZ);
        }
        this.gCf.setOnClickListener(null);
        this.gCf.endLoadData();
        this.gCf.setText(this.jhE.getResources().getString(R.string.list_has_no_more));
    }

    public void cGC() {
        this.mHasMore = true;
        this.jhR.setNextPage(this.gCf);
        this.gCf.setOnClickListener(this.jhV);
        if (this.jhZ > 0) {
            this.gCf.showEmptyView(this.jhZ);
        }
        this.gCf.endLoadData();
        this.gCf.setText(this.jhE.getResources().getString(R.string.list_click_load_more));
    }

    public View cGD() {
        if (this.gCf == null) {
            return null;
        }
        return this.gCf.getView();
    }

    public void Ae(int i) {
        if (this.jit != null) {
            this.jit.setVisibility(i);
        }
    }

    public void Af(int i) {
        if (this.jit != null) {
            this.jit.setSelectNumber(i);
        }
    }

    public void Ag(int i) {
        if (this.jiu != null) {
            this.jiu.setVisibility(i);
        }
    }

    public void Ah(int i) {
        if (this.jiu != null) {
            this.jiu.setMoveNumber(i);
        }
    }

    public boolean cGE() {
        return this.jiu != null && this.jiu.cPf();
    }

    public void cGF() {
        if (this.jiu != null) {
            this.jiu.cPg();
        }
    }

    public void bVG() {
        this.mHasMore = false;
        this.jhR.setNextPage(null);
    }

    public boolean cGG() {
        return this.gCf.getView().getParent() != null && this.mHasMore;
    }

    public void Ai(int i) {
        this.jhZ = i;
    }

    public void Aj(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.iPc == null) {
                    this.iPc = new CommonTipView(this.jhE.getActivity());
                }
                this.iPc.setText(R.string.frs_login_tip);
                this.iPc.b((FrameLayout) cGB(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void qD(boolean z) {
        this.mIsBackground = z;
        if (this.iOh != null) {
            boolean z2 = (this.jhE == null || this.jhE.cEY() == null || this.jhE.cEY().cOr() == null) ? true : this.jhE.cEY().cOr().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iOh.tE(false);
                this.iOh.dew();
                return;
            }
            this.iOh.tE(true);
            this.iOh.b(this.jhq, this.gAO, this.jia, true);
        }
    }

    public void cp(int i, int i2) {
        if (this.iOh != null) {
            this.iOh.a(i, i2, this.jia, 1);
        }
    }

    public void cq(int i, int i2) {
        this.jhq = i;
        this.gAO = i2;
    }

    public void qE(boolean z) {
        this.jia = z;
    }

    public void cGH() {
        a(this.jik, this.jhE.cFI());
        if (this.jhS != null) {
            this.jhS.cIZ();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.jhE.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.jil == null) {
                this.jil = new com.baidu.tieba.video.e(this.jhE.getActivity(), this.jhF);
            }
            this.jil.l(postWriteCallBackData);
        }
    }

    public void cGI() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bvr().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.jiC && this.jhE.getActivity() != null && this.jhE.getPageContext() != null) {
            View view = null;
            if (this.jhR != null && (headerViewsCount = this.jhR.getHeaderViewsCount()) < this.jhR.getChildCount()) {
                view = this.jhR.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.jhE.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.jhE.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.jhE.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.bvr().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c lG = dVar.lG();
                lG.setShouldCheckLocInWindow(false);
                lG.show(this.jhE.getActivity());
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lG != null) {
                            lG.dismiss();
                        }
                    }
                }, 4000L);
                this.jiC = true;
            }
        }
    }

    public void b(e.a aVar) {
        if (this.jit != null) {
            this.jit.setDeleteCallback(aVar);
        }
    }

    public void cGJ() {
        if (this.jit != null) {
            this.jit.cGJ();
        }
    }

    public void bNJ() {
        if (this.jit != null) {
            this.jit.bNJ();
        }
    }

    public void aX(String str, int i) {
        if (this.jiw == null) {
            this.jiw = new TextView(this.jhE.getActivity());
            this.jiw.setGravity(19);
            this.jiw.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jhE.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.jhE.getActivity(), R.dimen.ds34), 0);
            this.jiw.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jhE.getActivity(), R.dimen.tbds112)));
            this.jiw.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.jhE.getActivity(), R.dimen.fontsize30));
            this.jiw.setMaxLines(2);
            this.jiw.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.jiw.setTextColor(ContextCompat.getColor(this.jhE.getActivity(), R.color.CAM_X0101));
        }
        this.jiv.setBackgroundColor(i);
        this.jiw.setText(str);
        this.jiv.a(this.jhE.getActivity(), this.jiw, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.ZS != null) {
            this.ZS.setExpanded(z);
        }
    }

    public void cGK() {
        if (this.jhT != null) {
            this.jhT.startPullRefresh();
        }
    }

    public void Hp() {
        if (cGA() != null) {
            List<com.baidu.adp.widget.ListView.n> datas = cGA().getDatas();
            if (!com.baidu.tbadk.core.util.x.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.n nVar : datas) {
                    if (nVar instanceof by) {
                        by byVar = (by) nVar;
                        if (byVar.eSI != 0 && byVar.eMv != null && this.jhE.cEV() != null && this.jhE.cEV().cLG() != null) {
                            int[] imageWidthAndHeight = byVar.eMv.getImageWidthAndHeight();
                            byVar.eSI = imageWidthAndHeight[0];
                            byVar.eSJ = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cGA().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iOh.b(q.this.jhq, q.this.gAO, q.this.jia, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cGL() {
        if (this.jib == null) {
            return false;
        }
        return this.jib.cGL();
    }

    public Context getContext() {
        if (this.jhE == null) {
            return null;
        }
        return this.jhE.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.jhT != null) {
            this.jhT.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.jhT != null) {
            this.jhT.startPullRefresh();
        }
    }

    public void cGM() {
        if (this.jhT != null) {
            this.jhT.cGM();
        }
    }

    public void cGN() {
        if (this.jhT != null) {
            this.jhT.cGN();
        }
    }

    public void a(aq aqVar) {
        if (this.jhT != null) {
            this.jhT.a(aqVar);
        }
    }

    public void Ak(int i) {
        if (this.jhT != null) {
            this.jhT.Ak(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cGO() {
        return this.jhT;
    }

    public boolean cGP() {
        if (this.jhT != null) {
            return this.jhT.cOg() instanceof FrsNewAreaFragment;
        }
        return false;
    }
}
