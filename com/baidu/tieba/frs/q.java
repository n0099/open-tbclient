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
    private AppBarLayout ZQ;
    private NoNetworkView gvm;
    private PbListView gxy;
    private com.baidu.tieba.play.i iJA;
    private CommonTipView iKv;
    private com.baidu.adp.widget.ListView.l iLx;
    private ImageView ixx;
    private MessageRedDotView ixy;
    private FrsFragment jcX;
    private ObservedChangeLinearLayout jdB;
    private com.baidu.tieba.frs.entelechy.a.a jdC;
    private com.baidu.tieba.video.e jdD;
    private AppBarLayoutStickyBehavior jdE;
    private FrsHeaderViewContainer jdF;
    private CollapsingToolbarLayout jdG;
    private com.baidu.tieba.frs.vc.h jdK;
    private FrsMultiDelBottomMenuView jdL;
    private FrsMoveAreaBottomMenuView jdM;
    private NavigationBarCoverTip jdN;
    private TextView jdO;
    private TextView jdP;
    private boolean jdU;
    private View jdb;
    private com.baidu.tieba.c.d jdc;
    private ImageView jdd;
    private ImageView jde;
    private TextView jdf;
    private ViewStub jdg;
    private BdTypeRecyclerView jdk;
    private com.baidu.tieba.frs.entelechy.adapter.al jdl;
    private com.baidu.tieba.frs.vc.k jdm;
    private View.OnClickListener jdo;
    private View jdp;
    private View jdq;
    private int jds;
    private com.baidu.tieba.frs.vc.d jdu;
    private com.baidu.tieba.frs.entelechy.a.c jdv;
    private com.baidu.tieba.frs.vc.m jdw;
    private GifView jdx;
    private TbImageView jdy;
    private HashSet<String> jdz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout jcY = null;
    private CoordinatorLayout jcZ = null;
    private View jda = null;
    private FrameLayout jdh = null;
    private TbImageView jdi = null;
    private TbImageView jdj = null;
    private com.baidu.tbadk.core.dialog.b jdn = null;
    private NoNetworkView.a iXM = null;
    private boolean jdr = true;
    private boolean mHasMore = true;
    private boolean jdt = false;
    private int jcJ = 0;
    private int gwh = 0;
    private View bHz = null;
    private View jdA = null;
    private boolean hgf = false;
    private boolean enJ = true;
    private boolean jdH = true;
    private int jdI = -1;
    private int jdJ = -1;
    private int jdQ = 0;
    private int jdR = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener iLz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.iLx == null) {
                        q.this.iLx = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
                    }
                    q.this.iLx.a(q.this.jdk, 2);
                } else if (q.this.iLx != null) {
                    q.this.iLx.qL();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener jdS = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.jdm != null) {
                q.this.jdm.setInterceptScrollDown(i == 0);
            }
            if (q.this.jdJ != i && Math.abs(i) >= 0 && q.this.cCl() != -1) {
                if (Math.abs(i) >= q.this.cCl()) {
                    if (q.this.jdH) {
                        q.this.jdH = false;
                        q.this.qr(q.this.jdH);
                    }
                } else if (!q.this.jdH) {
                    q.this.jdH = true;
                    q.this.qr(q.this.jdH);
                }
                int cCh = q.this.cCh() + q.this.cCg() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cCh;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.jdJ - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.yt(Math.abs(cCh - totalScrollRange2));
                        if (q.this.jdA != null) {
                            q.this.jdA.setVisibility(0);
                        }
                    } else if (q.this.jdA != null) {
                        if (q.this.cCf() != UtilHelper.getStatusBarHeight()) {
                            q.this.yt(0);
                        }
                        q.this.jdA.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.hgf) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.qw(false);
                        } else if (q.this.jdP != null) {
                            q.this.jdP.setAlpha(abs);
                        }
                    }
                    q.this.jdJ = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.jdm != null) {
                int cKk = q.this.jdm.cKk();
                int cKl = cKk - q.this.jdm.cKl();
                if (cKk > 0 && Math.abs(i) >= cKl) {
                    q.this.jdm.dismissLoading();
                }
            }
        }
    };
    private Runnable jdT = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.jdg != null) {
                q.this.jdh.setVisibility(0);
                q.this.jdj.setVisibility(0);
                q.this.jdi.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.jcX != null && appBarLayout != null && this.jcX.cBg() != null && this.jcX.getPageContext() != null) {
            int cCg = cCg() + getNavigationBarHeight() + cCh();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cBg = this.jcX.cBg();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.jcX.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.jcX.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.jda.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.jcX != null && this.jcX.cBn();
            if (totalScrollRange <= 0) {
                if (this.jdR != 2) {
                    cBg.Az(2);
                }
                this.jdR = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cCg) {
                if (this.jdR != 1) {
                    cBg.Az(1);
                }
                this.jdR = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.jdR != 0) {
                    cBg.Az(0);
                }
                this.jdR = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.jcX.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.jda.setLayoutParams(marginLayoutParams);
            }
            Log.d("FrsMainView", "changeTabState() called with: leftSpace = [" + totalScrollRange + "], verticalOffset = [" + i + "]");
        }
    }

    public ObservedChangeLinearLayout cCd() {
        return this.jdB;
    }

    public View SF() {
        return this.bHz;
    }

    public View cCe() {
        return this.jdA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cCf() {
        if (this.bHz == null) {
            return 0;
        }
        return this.bHz.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cCg() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cCh() {
        if (this.gvm == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gvm.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(int i) {
        View SF = SF();
        View cCe = cCe();
        if (UtilHelper.canUseStyleImmersiveSticky() && SF != null && cCe != null && SF.getLayoutParams() != null && cCe.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = SF.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            SF.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cCe.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cCe.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.a.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.jcX = null;
        this.jdo = null;
        this.jds = 0;
        this.jcX = frsFragment;
        this.jdo = onClickListener;
        MessageManager.getInstance().registerListener(this.iLz);
        a(aVar, z);
        this.jdz = new HashSet<>();
        this.jds = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.jdK = hVar;
    }

    private boolean cCi() {
        return this.jdK != null && this.jdK.cJR();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v26, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.a.a aVar, boolean z) {
        boolean z2;
        this.jdC = aVar;
        View rootView = this.jcX.getRootView();
        if (this.jcY == null) {
            this.jcY = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.jda == null) {
            this.jda = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.jcZ == null) {
            this.jcZ = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.jdq == null) {
            this.jdq = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.jdG == null) {
            this.jdG = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.jdF == null) {
            this.jdF = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.jdm == null) {
            this.jdm = new com.baidu.tieba.frs.vc.k(this.jcX);
        }
        if (this.jdB == null) {
            this.jdB = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.jdB.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void f(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.jdG.setMinimumHeight(i2);
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
        if (this.jcX.cBQ()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.jdp == null) {
            this.jdp = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.a.b cEF = aVar.cEF();
            if (cEF != null) {
                cEF.cX(this.jdp);
            }
        }
        if (this.jdb == null) {
            this.jdb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jdb.setOnClickListener(this.jdo);
            this.mBackImageView = (ImageView) this.jdb.findViewById(R.id.widget_navi_back_button);
        }
        if (this.jde == null) {
            this.jde = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bsx().a(this.jde, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jde.setOnClickListener(this.jdo);
        }
        if (this.jdc == null) {
            this.jdc = new com.baidu.tieba.c.d(this.jcX.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jdc.getView(), (View.OnClickListener) null);
            this.ixx = this.jdc.csl();
            this.ixy = this.jdc.csm();
            this.ixy.setShadowEnabled(false);
            this.jdc.getView().setOnClickListener(this.jdo);
            this.jdc.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
        }
        if (this.jdd == null) {
            this.jdd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bsx().a(this.jdd, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.jdd.setOnClickListener(this.jdo);
        }
        if (this.jdf == null) {
            this.jdf = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.jdf.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jcX.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.jdf.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ao.l(this.jdf, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.jdf, R.color.CAM_X0101);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.jcX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
        }
        if (this.jdk == null) {
            this.jdk = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int jdX = 0;

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.jdX--;
                if (this.jdX == 0) {
                    q.this.jdk.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // androidx.recyclerview.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.jdX++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.jdk.setItemAnimator(defaultItemAnimator);
        this.jdk.setLayoutManager(new LinearLayoutManager(this.jdk.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iLx = new com.baidu.adp.widget.ListView.l(new com.baidu.adp.widget.ListView.j());
            this.iLx.a(this.jdk, 2);
        }
        this.jdk.setScrollable(this.jcX);
        this.jdk.setFadingEdgeLength(0);
        this.jdk.setOverScrollMode(2);
        this.jcY.setBottomOrderView(this.jdk);
        this.jdk.setOnTouchListener(this.jcX.bPd);
        this.jdk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.iJA != null) {
                    q.this.iJA.dv(view);
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
        this.jdk.setPadding(dimenPixelSize, this.jdk.getPaddingTop(), dimenPixelSize, this.jdk.getPaddingBottom());
        if (this.gxy == null) {
            this.gxy = new PbListView(this.jcX.getPageContext().getPageActivity());
            this.gxy.getView();
        }
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jcX.getActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0109));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.jdk.setOnSrollToBottomListener(this.jcX);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.jcX.cBJ();
                if (q.this.jcX != null && q.this.ZQ != null) {
                    q.this.jcX.cBT();
                    q.this.ZQ.setExpanded(true);
                    if (q.this.iJA != null) {
                        q.this.iJA.b(q.this.jcJ, q.this.gwh, false, true);
                    }
                }
            }
        });
        boolean bsz = com.baidu.tbadk.core.util.au.bsy().bsz();
        if (this.jdl == null) {
            this.jdl = aVar.a(this.jcX, this.jdk, bsz);
        }
        if (this.jdm != null) {
            this.jdm.Q(1, false);
        }
        if (!z) {
            if (this.gvm == null) {
                this.gvm = new NoNetworkView(this.jcX.getActivity());
                this.gvm.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.jdB.addView(this.gvm);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gvm.setVisibility(8);
            } else {
                this.gvm.setVisibility(0);
            }
            this.gvm.onChangeSkinType(this.jcX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cCs();
        if (this.jdu == null) {
            this.jdu = aVar.a(this.jcX, this.jcY);
            this.jdu.b(this.jcX.cBU());
        }
        if (this.jdv == null) {
            this.jdv = aVar.b(this.jcX, this.jcY);
            qu(true);
        }
        if (this.bHz == null) {
            this.bHz = rootView.findViewById(R.id.statebar_view);
        }
        if (this.jdA == null) {
            this.jdA = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.iJA == null) {
            this.iJA = new com.baidu.tieba.play.i(this.jcX.getPageContext(), this.jdk);
        }
        this.iJA.GW(1);
        this.iJA.setUniqueId(this.jcX.getUniqueId());
        this.jdN = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.jdw == null) {
            this.jdw = new com.baidu.tieba.frs.vc.m(this.jcX, this.jdN);
        }
        if (this.ZQ == null) {
            this.ZQ = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.ZQ.addOnOffsetChangedListener(this.jdS);
            this.jdH = true;
            this.jdI = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.ZQ.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.jdE = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.jdL = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.jdL.setPageContext(this.jcX.getPageContext());
        this.jdM = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.jdM.setPageContext(this.jcX.getPageContext());
        if (this.jdP == null) {
            this.jdP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.jcX.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.jdP.setLayoutParams(layoutParams2);
            this.jdP.setPadding(0, 0, this.jcX.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.jdP.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
        }
    }

    public void bW(boolean z) {
        if (z) {
        }
    }

    private void cCj() {
        ViewGroup.LayoutParams layoutParams;
        this.hgf = cCi();
        if (this.jdF != null && (layoutParams = this.jdF.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.hgf) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cCg(), 0, 0);
            }
            this.jdF.requestLayout();
        }
    }

    public void cCk() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.jdB != null) {
            cCj();
            if (this.hgf) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.bHz != null) {
                    this.bHz.setAlpha(1.0f);
                }
                if (this.jdA != null) {
                    this.jdA.setAlpha(1.0f);
                }
                if (this.jdP != null) {
                    this.jdP.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(boolean z) {
        if (z && this.jcX != null && this.jcX.cBf() != null) {
            this.jcX.cBf().cJY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cCl() {
        int i;
        if (this.ZQ == null) {
            return this.jdI;
        }
        if (this.jdI != -1) {
            return this.jdI;
        }
        int childCount = this.ZQ.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.ZQ.getChildAt(childCount);
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
        this.jdI = Math.max(0, this.ZQ.getTotalScrollRange() - Math.abs(i2));
        return this.jdI;
    }

    public void Jw(String str) {
        if (this.jdw != null) {
            this.jdw.Jw(str);
        }
    }

    public com.baidu.tieba.play.i cCm() {
        return this.iJA;
    }

    public com.baidu.tieba.frs.entelechy.a.c cCn() {
        return this.jdv;
    }

    public void qs(boolean z) {
        if (this.jdu != null) {
            if (com.baidu.tbadk.k.d.bCj().bCk()) {
                this.jdu.qs(false);
            } else {
                this.jdu.qs(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cCo() {
        return this.jdu;
    }

    public void aa(boolean z, boolean z2) {
        if (this.enJ && this.jdv != null) {
            this.jdv.aa(z, z2);
        }
    }

    public void qt(boolean z) {
        this.enJ = z;
        if (!this.enJ && this.jdv != null) {
            this.jdv.aa(false, false);
        }
    }

    public void cCp() {
        if (this.enJ && this.jdv != null) {
            this.jdv.aa(false, false);
        }
        yu(8);
        this.jde.setVisibility(8);
        this.jdd.setVisibility(8);
        qs(false);
        this.jdk.setVisibility(8);
        this.jdF.setVisibility(8);
    }

    public void cCq() {
        if (this.enJ && this.jdv != null) {
            this.jdv.aa(true, false);
        }
        yu(0);
        cCr();
        qs(this.jcX.cBW());
        this.jdk.setVisibility(0);
        this.jdF.setVisibility(0);
    }

    private void yu(int i) {
        if (this.jdc != null) {
            this.jdc.setVisibility(i);
        }
    }

    private void cCr() {
        this.jde.setVisibility(0);
        this.jdd.setVisibility(0);
    }

    public void qu(boolean z) {
        if (this.jdv != null) {
            this.jdv.qW(z);
        }
    }

    private void cCs() {
        if (this.jdx == null) {
            View rootView = this.jcX.getRootView();
            this.jdx = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.jdy = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.jdy.setPageId(this.jcX.getUniqueId());
            this.jdx.setLayerType(1, null);
            this.jdy.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cCt() {
        return this.jdb;
    }

    public void g(NoNetworkView.a aVar) {
        this.iXM = aVar;
        if (this.gvm != null) {
            this.gvm.a(this.iXM);
        }
    }

    public void qv(boolean z) {
        if (this.jdv != null) {
            if (z) {
                aa(false, true);
            } else {
                aa(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jdk.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.w wVar) {
        this.jdl.a(wVar);
    }

    public void setForumName(String str) {
        this.jdl.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iLz);
        if (this.iJA != null) {
            this.iJA.destroy();
        }
        if (this.jdw != null) {
            this.jdw.onDestory();
        }
        if (this.jdL != null) {
            this.jdL.setPageContext(null);
        }
        if (this.jdM != null) {
            this.jdM.setPageContext(null);
        }
        this.jdl.onDestory();
        this.jdk.setOnSrollToBottomListener(null);
        this.jdk.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.jdT);
        if (this.iKv != null) {
            this.iKv.onDestroy();
        }
        this.jdz.clear();
        if (this.jdu != null) {
            this.jdu.cJD();
        }
        if (this.jdD != null) {
            this.jdD.cEk();
        }
        if (this.jdN != null) {
            this.jdN.onDestroy();
        }
        if (this.jdL != null) {
            this.jdL.onDestroy();
        }
        if (this.jdm != null) {
            this.jdm.onDestroy();
        }
    }

    public boolean cCu() {
        if (this.ZQ == null || this.jdE == null || !this.jdE.isSticky()) {
            return this.jdu != null && this.jdu.cCu();
        }
        if (this.jdk != null) {
            this.jdk.setSelection(0);
        }
        this.jdE.expandedAppBarLayout(this.ZQ);
        return true;
    }

    public boolean cBO() {
        if (this.jdm == null) {
            return false;
        }
        return this.jdm.cBO();
    }

    public void bXh() {
        this.jdk.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.jdP.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.jdP.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.jdP.setText(str2);
            com.baidu.tbadk.core.k.bkB().setForumNameForWaterImage(str);
        }
    }

    public void cCv() {
        if (this.jdl != null) {
            this.jdl.notifyDataSetChanged();
        }
    }

    public void bbp() {
        if (this.jdl instanceof com.baidu.tieba.frs.entelechy.adapter.u) {
            ((com.baidu.tieba.frs.entelechy.adapter.u) this.jdl).bbp();
        }
    }

    private void cCw() {
        if (this.jdn == null && this.jcX.getPageContext() != null) {
            String[] strArr = {this.jcX.getPageContext().getPageActivity().getString(R.string.take_photo), this.jcX.getPageContext().getPageActivity().getString(R.string.album)};
            this.jdn = new com.baidu.tbadk.core.dialog.b(this.jcX.getPageContext().getPageActivity());
            this.jdn.Ae(this.jcX.getPageContext().getPageActivity().getString(R.string.operation));
            this.jdn.a(strArr, new b.InterfaceC0561b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.jcX.cBP();
                    } else if (i == 1 && q.this.jcX.getPageContext() != null) {
                        com.baidu.tbadk.core.util.an.getAlbumImage(q.this.jcX.getPageContext().getPageActivity());
                    }
                }
            });
            this.jdn.d(this.jcX.getPageContext());
        }
    }

    public void cCx() {
        cCw();
        if (this.jdn != null) {
            this.jdn.bqg();
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
                if (this.jcX != null && this.jcX.cBd() != null && this.jcX.cBd().cIl() == 0) {
                    sVar.yF(this.jcX.cBd().cIs());
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
                        ((by) nVar).eHK.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.jdl.b(arrayList2, frsViewData);
            if (this.iJA != null && this.jcJ != 0) {
                this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
            }
            if (this.jcX != null) {
                this.jcX.cBZ();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.jdk;
    }

    public void cCy() {
        this.jdl.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ae aeVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jcX.getPageContext(), 1);
        aVar.a(this.jdk);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.jcX.getForumName());
        hashMap.put("forum_id", this.jcX.getForumId());
        aVar.setParams(hashMap);
        aVar.aD(aeVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.jdu != null) {
            this.jdu.cJE();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        yv(TbadkCoreApplication.getInst().getSkinType());
        if (this.jdu != null) {
            this.jdu.cJF();
        }
    }

    public void release() {
        if (this.gvm != null && this.iXM != null) {
            this.gvm.b(this.iXM);
        }
    }

    public ImageView cCz() {
        return this.jde;
    }

    public ImageView cCA() {
        return this.jdd;
    }

    public TextView cCB() {
        return this.jdf;
    }

    public View cCC() {
        if (this.jdc != null) {
            return this.jdc.getView();
        }
        return null;
    }

    public void P(int i, boolean z) {
        if (this.jdc != null) {
            this.jdc.z(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.jcX, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.jcX.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.jdy != null) {
            this.jdy.invalidate();
        }
        if (this.jdl != null) {
            this.jdl.cFk();
            this.jdl.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.jcX.getPageContext(), this.jcY);
        if (this.gvm != null) {
            this.gvm.onChangeSkinType(this.jcX.getPageContext(), i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0109));
            this.gxy.changeSkin(i);
        }
        if (this.jdP != null) {
            this.jdP.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
        }
        yv(i);
        if (this.jdv != null) {
            this.jdv.onChangeSkinType(i);
        }
        if (this.jdu != null) {
            this.jdu.onChangeSkinType(i);
        }
        if (this.jdL != null) {
            this.jdL.onChangeSkinType();
        }
        if (this.jdM != null) {
            this.jdM.onChangeSkinType();
        }
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jda, R.color.CAM_X0202);
    }

    private void yv(int i) {
        if (this.jcX != null) {
            yw(i);
        }
    }

    private void yw(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jcX.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jdp, R.color.CAM_X0204, i);
            if (this.jdc != null) {
                this.jdc.onChangeSkinType(i);
            }
            if (this.jde != null) {
                SvgManager.bsx().a(this.jde, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.jdd != null) {
                SvgManager.bsx().a(this.jdd, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.bHz, R.color.CAM_X0207);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jdA, R.color.CAM_X0207);
        qw(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qw(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hgf) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.jdQ != 0) {
                    SvgManager.bsx().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bsx().a(this.jde, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.ixx.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0101), (WebPManager.ResourceStateType) null));
                    SvgManager.bsx().a(this.jdd, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.jdQ = 0;
                }
            } else if (z || this.jdQ != 1) {
                SvgManager.bsx().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bsx().a(this.jde, R.drawable.ic_icon_pure_topbar_search40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.ixx.setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_information40, com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0106), (WebPManager.ResourceStateType) null));
                SvgManager.bsx().a(this.jdd, R.drawable.ic_icon_pure_topbar_share40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.jdQ = 1;
            }
            cCD();
        }
    }

    private void cCD() {
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
            if (this.jdP != null) {
                this.jdP.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.ixx != null) {
                    this.ixx.setAlpha(f);
                }
                if (this.jcX != null && this.jcX.cBg() != null && this.jdQ == 1) {
                    this.jcX.cBg().aH(f);
                }
                if (this.ixy != null) {
                    this.ixy.setAlpha(f);
                }
                if (this.jde != null) {
                    this.jde.setAlpha(f);
                }
                if (this.jdd != null) {
                    this.jdd.setAlpha(f);
                }
            }
            if (this.jdf != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.jdf.setAlpha(f2);
                this.jdf.setClickable(f2 > 0.0f);
            }
            if (this.bHz != null) {
                this.bHz.setAlpha(alpha);
            }
            if (this.jdA != null) {
                this.jdA.setAlpha(alpha);
            }
            if (this.jdp != null) {
                this.jdp.setAlpha(alpha);
            }
        }
    }

    public void bQX() {
        if (this.jdm != null) {
            this.jdm.bQX();
        }
    }

    public void qx(boolean z) {
        if (this.jdm != null) {
            this.jdm.qx(z);
        }
    }

    public void qy(boolean z) {
        this.jdr = z;
        if (this.jdr) {
            this.gxy.setText(this.jcX.getResources().getString(R.string.load_more));
            if (this.jdk.getChildAt(this.jdk.getChildCount() - 1) == this.gxy.getView()) {
                this.gxy.startLoadData();
                this.jcX.bQy();
                return;
            }
            this.gxy.endLoadData();
            return;
        }
        this.gxy.setText(this.jcX.getResources().getString(R.string.load_more_must_after_delete));
        this.gxy.endLoadData();
    }

    public boolean cCE() {
        if (this.jdr) {
            return false;
        }
        this.gxy.setText(this.jcX.getResources().getString(R.string.load_more_must_after_delete));
        this.gxy.endLoadData();
        return true;
    }

    public boolean cCF() {
        return this.jdg != null && this.jdj.getVisibility() == 0;
    }

    public void cCG() {
        if (this.jdg != null) {
            this.jdh.setVisibility(0);
            this.jdj.setVisibility(8);
            this.jdi.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.jdT, 5000L);
        }
    }

    public void a(cj cjVar) {
        if (this.jdg == null) {
            View rootView = this.jcX.getRootView();
            this.jdg = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.jdg.setVisibility(0);
            this.jdh = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.jdi = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.jdj = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.jdi.setPageId(this.jcX.getUniqueId());
            this.jdj.setPageId(this.jcX.getUniqueId());
            this.jdi.setDefaultBgResource(R.color.common_color_10022);
            this.jdi.setDefaultResource(0);
            this.jdj.setDefaultBgResource(R.color.common_color_10022);
            this.jdj.setDefaultResource(0);
            this.jdh.setOnClickListener(this.jdo);
        }
        this.jdh.setVisibility(0);
        String bpT = cjVar.bpT();
        String bpU = cjVar.bpU();
        this.jdi.startLoad(bpT, 10, false);
        this.jdj.startLoad(bpU, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.jdT, 5000L);
    }

    public void cCH() {
        if (this.jdg != null && this.jdh != null) {
            this.jdh.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.adapter.al cCI() {
        return this.jdl;
    }

    public RelativeLayout cmp() {
        return this.jcY;
    }

    public View cCJ() {
        return this.jdq;
    }

    public void yx(int i) {
        if (this.jda != null) {
            this.jda.setVisibility(i);
        }
    }

    public NavigationBar bUz() {
        return this.mNavigationBar;
    }

    public void Vo() {
        this.mHasMore = true;
        this.jdk.setNextPage(this.gxy);
        if (this.jds > 0) {
            this.gxy.showEmptyView(this.jds);
        }
        this.gxy.setOnClickListener(null);
        this.gxy.startLoadData();
    }

    public void Vp() {
        this.mHasMore = false;
        this.jdk.setNextPage(this.gxy);
        if (this.jds > 0) {
            this.gxy.showEmptyView(this.jds);
        }
        this.gxy.setOnClickListener(null);
        this.gxy.endLoadData();
        this.gxy.setText(this.jcX.getResources().getString(R.string.list_has_no_more));
    }

    public void cCK() {
        this.mHasMore = true;
        this.jdk.setNextPage(this.gxy);
        this.gxy.setOnClickListener(this.jdo);
        if (this.jds > 0) {
            this.gxy.showEmptyView(this.jds);
        }
        this.gxy.endLoadData();
        this.gxy.setText(this.jcX.getResources().getString(R.string.list_click_load_more));
    }

    public View cCL() {
        if (this.gxy == null) {
            return null;
        }
        return this.gxy.getView();
    }

    public void yy(int i) {
        if (this.jdL != null) {
            this.jdL.setVisibility(i);
        }
    }

    public void yz(int i) {
        if (this.jdL != null) {
            this.jdL.setSelectNumber(i);
        }
    }

    public void yA(int i) {
        if (this.jdM != null) {
            this.jdM.setVisibility(i);
        }
    }

    public void yB(int i) {
        if (this.jdM != null) {
            this.jdM.setMoveNumber(i);
        }
    }

    public boolean cCM() {
        return this.jdM != null && this.jdM.cLn();
    }

    public void cCN() {
        if (this.jdM != null) {
            this.jdM.cLo();
        }
    }

    public void bRO() {
        this.mHasMore = false;
        this.jdk.setNextPage(null);
    }

    public boolean cCO() {
        return this.gxy.getView().getParent() != null && this.mHasMore;
    }

    public void yC(int i) {
        this.jds = i;
    }

    public void yD(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.iKv == null) {
                    this.iKv = new CommonTipView(this.jcX.getActivity());
                }
                this.iKv.setText(R.string.frs_login_tip);
                this.iKv.b((FrameLayout) cCJ(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void qz(boolean z) {
        this.mIsBackground = z;
        if (this.iJA != null) {
            boolean z2 = (this.jcX == null || this.jcX.cBg() == null || this.jcX.cBg().cKz() == null) ? true : this.jcX.cBg().cKz().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.iJA.tA(false);
                this.iJA.daE();
                return;
            }
            this.iJA.tA(true);
            this.iJA.b(this.jcJ, this.gwh, this.jdt, true);
        }
    }

    public void cp(int i, int i2) {
        if (this.iJA != null) {
            this.iJA.a(i, i2, this.jdt, 1);
        }
    }

    public void cq(int i, int i2) {
        this.jcJ = i;
        this.gwh = i2;
    }

    public void qA(boolean z) {
        this.jdt = z;
    }

    public void cCP() {
        a(this.jdC, this.jcX.cBQ());
        if (this.jdl != null) {
            this.jdl.cFh();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.jcX.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.jdD == null) {
                this.jdD = new com.baidu.tieba.video.e(this.jcX.getActivity(), this.jcY);
            }
            this.jdD.l(postWriteCallBackData);
        }
    }

    public void cCQ() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.jdU && this.jcX.getActivity() != null && this.jcX.getPageContext() != null) {
            View view = null;
            if (this.jdk != null && (headerViewsCount = this.jdk.getHeaderViewsCount()) < this.jdk.getChildCount()) {
                view = this.jdk.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.jcX.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.jcX.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.jcX.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c lG = dVar.lG();
                lG.setShouldCheckLocInWindow(false);
                lG.show(this.jcX.getActivity());
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lG != null) {
                            lG.dismiss();
                        }
                    }
                }, 4000L);
                this.jdU = true;
            }
        }
    }

    public void b(e.a aVar) {
        if (this.jdL != null) {
            this.jdL.setDeleteCallback(aVar);
        }
    }

    public void cCR() {
        if (this.jdL != null) {
            this.jdL.cCR();
        }
    }

    public void bJR() {
        if (this.jdL != null) {
            this.jdL.bJR();
        }
    }

    public void aX(String str, int i) {
        if (this.jdO == null) {
            this.jdO = new TextView(this.jcX.getActivity());
            this.jdO.setGravity(19);
            this.jdO.setPadding(com.baidu.adp.lib.util.l.getDimens(this.jcX.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.jcX.getActivity(), R.dimen.ds34), 0);
            this.jdO.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.jcX.getActivity(), R.dimen.tbds112)));
            this.jdO.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.jcX.getActivity(), R.dimen.fontsize30));
            this.jdO.setMaxLines(2);
            this.jdO.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.jdO.setTextColor(ContextCompat.getColor(this.jcX.getActivity(), R.color.CAM_X0101));
        }
        this.jdN.setBackgroundColor(i);
        this.jdO.setText(str);
        this.jdN.a(this.jcX.getActivity(), this.jdO, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.ZQ != null) {
            this.ZQ.setExpanded(z);
        }
    }

    public void cCS() {
        if (this.jdm != null) {
            this.jdm.startPullRefresh();
        }
    }

    public void Du() {
        if (cCI() != null) {
            List<com.baidu.adp.widget.ListView.n> datas = cCI().getDatas();
            if (!com.baidu.tbadk.core.util.x.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.n nVar : datas) {
                    if (nVar instanceof by) {
                        by byVar = (by) nVar;
                        if (byVar.eNX != 0 && byVar.eHK != null && this.jcX.cBd() != null && this.jcX.cBd().cHO() != null) {
                            int[] imageWidthAndHeight = byVar.eHK.getImageWidthAndHeight();
                            byVar.eNX = imageWidthAndHeight[0];
                            byVar.eNY = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cCI().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.iJA.b(q.this.jcJ, q.this.gwh, q.this.jdt, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cCT() {
        if (this.jdu == null) {
            return false;
        }
        return this.jdu.cCT();
    }

    public Context getContext() {
        if (this.jcX == null) {
            return null;
        }
        return this.jcX.getTbPageContext().getPageActivity();
    }

    public void Q(int i, boolean z) {
        if (this.jdm != null) {
            this.jdm.Q(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.jdm != null) {
            this.jdm.startPullRefresh();
        }
    }

    public void cCU() {
        if (this.jdm != null) {
            this.jdm.cCU();
        }
    }

    public void cCV() {
        if (this.jdm != null) {
            this.jdm.cCV();
        }
    }

    public void a(aq aqVar) {
        if (this.jdm != null) {
            this.jdm.a(aqVar);
        }
    }

    public void yE(int i) {
        if (this.jdm != null) {
            this.jdm.yE(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cCW() {
        return this.jdm;
    }

    public boolean cCX() {
        if (this.jdm != null) {
            return this.jdm.cKo() instanceof FrsNewAreaFragment;
        }
        return false;
    }
}
