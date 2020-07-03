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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.ce;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.NEGFeedBack.d;
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
/* loaded from: classes9.dex */
public class p {
    private AppBarLayout WW;
    private NoNetworkView flI;
    private PbListView fnt;
    private ImageView gXc;
    private MessageRedDotView gXd;
    private FrsFragment hBW;
    private ObservedChangeLinearLayout hCA;
    private com.baidu.tieba.frs.entelechy.b.a hCB;
    private com.baidu.tieba.video.g hCC;
    private AppBarLayoutStickyBehavior hCD;
    private FrsHeaderViewContainer hCE;
    private CollapsingToolbarLayout hCF;
    private com.baidu.tieba.frs.vc.h hCJ;
    private FrsMultiDelBottomMenuView hCK;
    private FrsMoveAreaBottomMenuView hCL;
    private NavigationBarCoverTip hCM;
    private TextView hCN;
    private TextView hCO;
    private boolean hCT;
    private View hCa;
    private com.baidu.tieba.c.d hCb;
    private ImageView hCc;
    private ImageView hCd;
    private TextView hCe;
    private ViewStub hCf;
    private BdTypeRecyclerView hCj;
    private com.baidu.tieba.frs.entelechy.a.al hCk;
    private com.baidu.tieba.frs.vc.k hCl;
    private View.OnClickListener hCn;
    private View hCo;
    private View hCp;
    private int hCr;
    private com.baidu.tieba.frs.vc.d hCt;
    private com.baidu.tieba.frs.entelechy.b.c hCu;
    private com.baidu.tieba.frs.vc.m hCv;
    private GifView hCw;
    private TbImageView hCx;
    private HashSet<String> hCy;
    private com.baidu.tieba.play.m hjm;
    private CommonTipView hkh;
    private com.baidu.adp.widget.ListView.n hlg;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout hBX = null;
    private CoordinatorLayout hBY = null;
    private View hBZ = null;
    private FrameLayout hCg = null;
    private TbImageView hCh = null;
    private TbImageView hCi = null;
    private com.baidu.tbadk.core.dialog.b hCm = null;
    private NoNetworkView.a hwW = null;
    private boolean hCq = true;
    private boolean mHasMore = true;
    private boolean hCs = false;
    private int hBI = 0;
    private int fmb = 0;
    private View biD = null;
    private View hCz = null;
    private boolean fPB = false;
    private boolean dlK = true;
    private boolean hCG = true;
    private int hCH = -1;
    private int hCI = -1;
    private int hCP = 0;
    private int hCQ = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener hli = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (p.this.hlg == null) {
                        p.this.hlg = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    p.this.hlg.a(p.this.hCj, 2);
                } else if (p.this.hlg != null) {
                    p.this.hlg.pC();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hCR = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.p.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            p.this.a(appBarLayout, i);
            if (p.this.hCl != null) {
                p.this.hCl.setInterceptScrollDown(i == 0);
            }
            if (p.this.hCI != i && Math.abs(i) >= 0 && p.this.bYZ() != -1) {
                if (Math.abs(i) >= p.this.bYZ()) {
                    if (p.this.hCG) {
                        p.this.hCG = false;
                        p.this.na(p.this.hCG);
                    }
                } else if (!p.this.hCG) {
                    p.this.hCG = true;
                    p.this.na(p.this.hCG);
                }
                int bYV = p.this.bYV() + p.this.bYU() + p.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bYV;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && p.this.hCI - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        p.this.ur(Math.abs(bYV - totalScrollRange2));
                        if (p.this.hCz != null) {
                            p.this.hCz.setVisibility(0);
                        }
                    } else if (p.this.hCz != null) {
                        if (p.this.bYT() != UtilHelper.getStatusBarHeight()) {
                            p.this.ur(0);
                        }
                        p.this.hCz.setVisibility(8);
                    }
                    if (p.this.mNavigationBar != null) {
                        if (p.this.fPB) {
                            p.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            p.this.nf(false);
                        } else if (p.this.hCO != null) {
                            p.this.hCO.setAlpha(abs);
                        }
                    }
                    p.this.hCI = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (p.this.hCl != null) {
                int cfC = p.this.hCl.cfC();
                int cfD = cfC - p.this.hCl.cfD();
                if (cfC > 0 && Math.abs(i) >= cfD) {
                    p.this.hCl.dismissLoading();
                }
            }
        }
    };
    private Runnable hCS = new Runnable() { // from class: com.baidu.tieba.frs.p.13
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.hCf != null) {
                p.this.hCg.setVisibility(0);
                p.this.hCi.setVisibility(0);
                p.this.hCh.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.hBW != null && appBarLayout != null && this.hBW.bXX() != null && this.hBW.getPageContext() != null) {
            int bYU = bYU() + getNavigationBarHeight() + bYV();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bXX = this.hBW.bXX();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.hBW.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.hBW.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.hBZ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.hBW != null && this.hBW.bYe();
            if (totalScrollRange <= 0) {
                if (this.hCQ != 2) {
                    bXX.wl(2);
                }
                this.hCQ = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bYU) {
                if (this.hCQ != 1) {
                    bXX.wl(1);
                }
                this.hCQ = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.hCQ != 0) {
                    bXX.wl(0);
                }
                this.hCQ = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.hBW.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.hBZ.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bYR() {
        return this.hCA;
    }

    public View Iu() {
        return this.biD;
    }

    public View bYS() {
        return this.hCz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bYT() {
        if (this.biD == null) {
            return 0;
        }
        return this.biD.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bYU() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bYV() {
        if (this.flI == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.flI.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur(int i) {
        View Iu = Iu();
        View bYS = bYS();
        if (UtilHelper.canUseStyleImmersiveSticky() && Iu != null && bYS != null && Iu.getLayoutParams() != null && bYS.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Iu.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Iu.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bYS.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bYS.setLayoutParams(layoutParams2);
        }
    }

    public p(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.hBW = null;
        this.hCn = null;
        this.hCr = 0;
        this.hBW = frsFragment;
        this.hCn = onClickListener;
        MessageManager.getInstance().registerListener(this.hli);
        a(aVar, z);
        this.hCy = new HashSet<>();
        this.hCr = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hCJ = hVar;
    }

    private boolean bYW() {
        return this.hCJ != null && this.hCJ.cfo();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.hCB = aVar;
        View rootView = this.hBW.getRootView();
        if (this.hBX == null) {
            this.hBX = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.hBZ == null) {
            this.hBZ = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.hBY == null) {
            this.hBY = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.hCp == null) {
            this.hCp = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.hCF == null) {
            this.hCF = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.hCE == null) {
            this.hCE = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.hCl == null) {
            this.hCl = new com.baidu.tieba.frs.vc.k(this.hBW);
        }
        if (this.hCA == null) {
            this.hCA = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.hCA.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.p.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        p.this.hCF.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) rootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            this.mNavigationBar.setContentPaddingTop(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds20));
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.hBW.bYE()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.hCo == null) {
            this.hCo = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b cbk = aVar.cbk();
            if (cbk != null) {
                cbk.bY(this.hCo);
            }
        }
        if (this.hCa == null) {
            this.hCa = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hCa.setOnClickListener(this.hCn);
            this.mBackImageView = (ImageView) this.hCa.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hCd == null) {
            this.hCd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.aWQ().a(this.hCd, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hCd.setOnClickListener(this.hCn);
        }
        if (this.hCb == null) {
            this.hCb = new com.baidu.tieba.c.d(this.hBW.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hCb.getView(), (View.OnClickListener) null);
            this.gXc = this.hCb.bPB();
            this.gXd = this.hCb.bPC();
            this.hCb.getView().setOnClickListener(this.hCn);
            this.hCb.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.hCc == null) {
            this.hCc = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.aWQ().a(this.hCc, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hCc.setOnClickListener(this.hCn);
        }
        if (this.hCe == null) {
            this.hCe = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.hCe.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.an.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.hBW.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hCe.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.an.e(this.hCe, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.hCe, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.hBW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.hCj == null) {
            this.hCj = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.p.8
            int hCW = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.hCW--;
                if (this.hCW == 0) {
                    p.this.hCj.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.hCW++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.hCj.setItemAnimator(defaultItemAnimator);
        this.hCj.setLayoutManager(new LinearLayoutManager(this.hCj.getContext()) { // from class: com.baidu.tieba.frs.p.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hlg = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.hlg.a(this.hCj, 2);
        }
        this.hCj.setScrollable(this.hBW);
        this.hCj.setFadingEdgeLength(0);
        this.hCj.setOverScrollMode(2);
        this.hBX.setBottomOrderView(this.hCj);
        this.hCj.setOnTouchListener(this.hBW.eEC);
        this.hCj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.p.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (p.this.hjm != null) {
                    p.this.hjm.cu(view);
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
        if (this.fnt == null) {
            this.fnt = new PbListView(this.hBW.getPageContext().getPageActivity());
            this.fnt.getView();
        }
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fnt.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hBW.getActivity(), R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_cont_d));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hCj.setOnSrollToBottomListener(this.hBW);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.p.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p.this.hBW.bYx();
                if (p.this.hBW != null && p.this.WW != null) {
                    p.this.hBW.bYH();
                    p.this.WW.setExpanded(true);
                    if (p.this.hjm != null) {
                        p.this.hjm.a(p.this.hBI, p.this.fmb, false, true);
                    }
                }
            }
        });
        boolean aWS = com.baidu.tbadk.core.util.as.aWR().aWS();
        if (this.hCk == null) {
            this.hCk = aVar.a(this.hBW, this.hCj, aWS);
        }
        if (this.hCl != null) {
            this.hCl.M(1, false);
        }
        if (!z) {
            if (this.flI == null) {
                this.flI = new NoNetworkView(this.hBW.getActivity());
                this.flI.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.hCA.addView(this.flI);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.flI.setVisibility(8);
            } else {
                this.flI.setVisibility(0);
            }
            this.flI.onChangeSkinType(this.hBW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bZg();
        if (this.hCt == null) {
            this.hCt = aVar.a(this.hBW, this.hBX);
            this.hCt.b(this.hBW.bYI());
        }
        if (this.hCu == null) {
            this.hCu = aVar.b(this.hBW, this.hBX);
            nd(true);
        }
        if (this.biD == null) {
            this.biD = rootView.findViewById(R.id.statebar_view);
        }
        if (this.hCz == null) {
            this.hCz = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.hjm == null) {
            this.hjm = new com.baidu.tieba.play.m(this.hBW.getPageContext(), this.hCj);
        }
        this.hjm.CN(1);
        this.hjm.setUniqueId(this.hBW.getUniqueId());
        this.hCM = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.hCv == null) {
            this.hCv = new com.baidu.tieba.frs.vc.m(this.hBW, this.hCM);
        }
        if (this.WW == null) {
            this.WW = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.WW.addOnOffsetChangedListener(this.hCR);
            this.hCG = true;
            this.hCH = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.WW.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.hCD = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.hCK = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.hCK.setPageContext(this.hBW.getPageContext());
        this.hCL = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.hCL.setPageContext(this.hBW.getPageContext());
        if (this.hCO == null) {
            this.hCO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hBW.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.hCO.setLayoutParams(layoutParams2);
            this.hCO.setPadding(0, 0, this.hBW.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.hCO.setTextColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_cont_b));
        }
    }

    public void bB(boolean z) {
        if (z) {
        }
    }

    private void bYX() {
        ViewGroup.LayoutParams layoutParams;
        this.fPB = bYW();
        if (this.hCE != null && (layoutParams = this.hCE.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.fPB) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bYU(), 0, 0);
            }
            this.hCE.requestLayout();
        }
    }

    public void bYY() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hCA != null) {
            bYX();
            if (this.fPB) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.biD != null) {
                    this.biD.setAlpha(1.0f);
                }
                if (this.hCz != null) {
                    this.hCz.setAlpha(1.0f);
                }
                if (this.hCO != null) {
                    this.hCO.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(boolean z) {
        if (z && this.hBW != null && this.hBW.bXW() != null) {
            this.hBW.bXW().cft();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bYZ() {
        int i;
        if (this.WW == null) {
            return this.hCH;
        }
        if (this.hCH != -1) {
            return this.hCH;
        }
        int childCount = this.WW.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.WW.getChildAt(childCount);
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
        this.hCH = Math.max(0, this.WW.getTotalScrollRange() - Math.abs(i2));
        return this.hCH;
    }

    public void Fe(String str) {
        if (this.hCv != null) {
            this.hCv.Fe(str);
        }
    }

    public com.baidu.tieba.play.m bZa() {
        return this.hjm;
    }

    public com.baidu.tieba.frs.entelechy.b.c bZb() {
        return this.hCu;
    }

    public void nb(boolean z) {
        if (this.hCt != null) {
            this.hCt.nb(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bZc() {
        return this.hCt;
    }

    public void P(boolean z, boolean z2) {
        if (this.dlK && this.hCu != null) {
            this.hCu.P(z, z2);
        }
    }

    public void nc(boolean z) {
        this.dlK = z;
        if (!this.dlK && this.hCu != null) {
            this.hCu.P(false, false);
        }
    }

    public void bZd() {
        if (this.dlK && this.hCu != null) {
            this.hCu.P(false, false);
        }
        us(8);
        this.hCd.setVisibility(8);
        this.hCc.setVisibility(8);
        nb(false);
        this.hCj.setVisibility(8);
        this.hCE.setVisibility(8);
    }

    public void bZe() {
        if (this.dlK && this.hCu != null) {
            this.hCu.P(true, false);
        }
        us(0);
        bZf();
        nb(this.hBW.bYK());
        this.hCj.setVisibility(0);
        this.hCE.setVisibility(0);
    }

    private void us(int i) {
        if (this.hCb != null) {
            this.hCb.setVisibility(i);
        }
    }

    private void bZf() {
        this.hCd.setVisibility(0);
        this.hCc.setVisibility(0);
    }

    public void nd(boolean z) {
        if (this.hCu != null) {
            this.hCu.nF(z);
        }
    }

    private void bZg() {
        if (this.hCw == null) {
            View rootView = this.hBW.getRootView();
            this.hCw = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.hCx = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.hCx.setPageId(this.hBW.getUniqueId());
            this.hCw.setLayerType(1, null);
            this.hCx.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bZh() {
        return this.hCa;
    }

    public void g(NoNetworkView.a aVar) {
        this.hwW = aVar;
        if (this.flI != null) {
            this.flI.a(this.hwW);
        }
    }

    public void ne(boolean z) {
        if (this.hCu != null) {
            if (z) {
                P(false, true);
            } else {
                P(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hCj.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.hCk.a(zVar);
    }

    public void setForumName(String str) {
        this.hCk.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hli);
        if (this.hjm != null) {
            this.hjm.destroy();
        }
        if (this.hCv != null) {
            this.hCv.onDestory();
        }
        if (this.hCK != null) {
            this.hCK.setPageContext(null);
        }
        if (this.hCL != null) {
            this.hCL.setPageContext(null);
        }
        this.hCk.onDestory();
        this.hCj.setOnSrollToBottomListener(null);
        this.hCj.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.hCS);
        if (this.hkh != null) {
            this.hkh.onDestroy();
        }
        this.hCy.clear();
        if (this.hCt != null) {
            this.hCt.ceY();
        }
        if (this.hCC != null) {
            this.hCC.caR();
        }
        if (this.hCM != null) {
            this.hCM.onDestroy();
        }
        if (this.hCK != null) {
            this.hCK.onDestroy();
        }
        if (this.hCl != null) {
            this.hCl.onDestroy();
        }
    }

    public boolean bZi() {
        if (this.WW == null || this.hCD == null || !this.hCD.isSticky()) {
            return this.hCt != null && this.hCt.bZi();
        }
        if (this.hCj != null) {
            this.hCj.setSelection(0);
        }
        this.hCD.expandedAppBarLayout(this.WW);
        return true;
    }

    public boolean bYC() {
        if (this.hCl == null) {
            return false;
        }
        return this.hCl.bYC();
    }

    public void byJ() {
        this.hCj.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.hCO.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.hCO.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.hCO.setText(str2);
            com.baidu.tbadk.core.k.aPA().setForumNameForWaterImage(str);
        }
    }

    public void bZj() {
        if (this.hCk != null) {
            this.hCk.notifyDataSetChanged();
        }
    }

    public void aFY() {
        if (this.hCk instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.hCk).aFY();
        }
    }

    private void bZk() {
        if (this.hCm == null && this.hBW.getPageContext() != null) {
            String[] strArr = {this.hBW.getPageContext().getPageActivity().getString(R.string.take_photo), this.hBW.getPageContext().getPageActivity().getString(R.string.album)};
            this.hCm = new com.baidu.tbadk.core.dialog.b(this.hBW.getPageContext().getPageActivity());
            this.hCm.wf(this.hBW.getPageContext().getPageActivity().getString(R.string.operation));
            this.hCm.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.p.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        p.this.hBW.bYD();
                    } else if (i == 1 && p.this.hBW.getPageContext() != null) {
                        com.baidu.tbadk.core.util.am.getAlbumImage(p.this.hBW.getPageContext().getPageActivity());
                    }
                }
            });
            this.hCm.d(this.hBW.getPageContext());
        }
    }

    public void bZl() {
        bZk();
        if (this.hCm != null) {
            this.hCm.aUO();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.w.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                r rVar = new r();
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList3 = new ArrayList<>();
                arrayList3.add(rVar);
                if (this.hBW != null && this.hBW.bXU() != null && this.hBW.bXU().cdK() == 0) {
                    rVar.uE(this.hBW.bXU().cdR());
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = switchThreadDataToThreadCardInfo;
            }
            if (com.baidu.tbadk.core.util.w.getCount(arrayList2) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.q qVar = arrayList2.get(i2);
                    if (qVar instanceof bt) {
                        ((bt) qVar).dLi.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.hCk.b(arrayList2, frsViewData);
            if (this.hjm != null && this.hBI != 0) {
                this.hjm.a(this.hBI, this.fmb, this.hCs, true);
            }
            if (this.hBW != null) {
                this.hBW.bYN();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.hCj;
    }

    public void bZm() {
        this.hCk.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ab abVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hBW.getPageContext(), 1);
        aVar.a(this.hCj);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.hBW.getForumName());
        hashMap.put("forum_id", this.hBW.getForumId());
        aVar.setParams(hashMap);
        aVar.au(abVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.hCt != null) {
            this.hCt.ceZ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        ut(TbadkCoreApplication.getInst().getSkinType());
        if (this.hCt != null) {
            this.hCt.cfa();
        }
    }

    public void release() {
        if (this.flI != null && this.hwW != null) {
            this.flI.b(this.hwW);
        }
    }

    public ImageView bZn() {
        return this.hCd;
    }

    public ImageView bZo() {
        return this.hCc;
    }

    public TextView bZp() {
        return this.hCe;
    }

    public View bZq() {
        if (this.hCb != null) {
            return this.hCb.getView();
        }
        return null;
    }

    public void L(int i, boolean z) {
        if (this.hCb != null) {
            this.hCb.x(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.hBW, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hBW.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.hCx != null) {
            this.hCx.invalidate();
        }
        if (this.hCk != null) {
            this.hCk.cbI();
            this.hCk.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.hBW.getPageContext(), this.hBX);
        if (this.flI != null) {
            this.flI.onChangeSkinType(this.hBW.getPageContext(), i);
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_cont_d));
            this.fnt.changeSkin(i);
        }
        if (this.hCO != null) {
            this.hCO.setTextColor(com.baidu.tbadk.core.util.an.getColor(R.color.cp_cont_b));
        }
        ut(i);
        if (this.hCu != null) {
            this.hCu.onChangeSkinType(i);
        }
        if (this.hCt != null) {
            this.hCt.onChangeSkinType(i);
        }
        if (this.hCK != null) {
            this.hCK.onChangeSkinType();
        }
        if (this.hCL != null) {
            this.hCL.onChangeSkinType();
        }
        if (this.hBW != null && this.hBW.bYe()) {
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.hBZ, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.hBZ, R.color.cp_bg_line_d);
        }
    }

    private void ut(int i) {
        if (this.hBW != null) {
            uu(i);
        }
    }

    private void uu(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hBW.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.hCo, R.color.cp_bg_line_c, i);
            if (this.hCb != null) {
                this.hCb.onChangeSkinType(i);
            }
            if (this.hCd != null) {
                SvgManager.aWQ().a(this.hCd, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hCc != null) {
                SvgManager.aWQ().a(this.hCc, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.an.setBackgroundColor(this.biD, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.an.setBackgroundColor(this.hCz, R.color.cp_bg_line_h);
        nf(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nf(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fPB) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.hCP != 0) {
                    SvgManager.aWQ().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aWQ().a(this.hCd, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aWQ().a(this.gXc, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aWQ().a(this.hCc, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.hCP = 0;
                }
            } else if (z || this.hCP != 1) {
                SvgManager.aWQ().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aWQ().a(this.hCd, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aWQ().a(this.gXc, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aWQ().a(this.hCc, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.hCP = 1;
            }
            bZr();
        }
    }

    private void bZr() {
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
            if (this.hCO != null) {
                this.hCO.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.gXc != null) {
                    this.gXc.setAlpha(f);
                }
                if (this.gXd != null) {
                    this.gXd.setAlpha(f);
                }
                if (this.hCd != null) {
                    this.hCd.setAlpha(f);
                }
                if (this.hCc != null) {
                    this.hCc.setAlpha(f);
                }
            }
            if (this.hCe != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.hCe.setAlpha(f2);
                this.hCe.setClickable(f2 > 0.0f);
            }
            if (this.biD != null) {
                this.biD.setAlpha(alpha);
            }
            if (this.hCz != null) {
                this.hCz.setAlpha(alpha);
            }
            if (this.hCo != null) {
                this.hCo.setAlpha(alpha);
            }
        }
    }

    public void btU() {
        if (this.hCl != null) {
            this.hCl.btU();
        }
    }

    public void ng(boolean z) {
        if (this.hCl != null) {
            this.hCl.ng(z);
        }
    }

    public void nh(boolean z) {
        this.hCq = z;
        if (this.hCq) {
            this.fnt.setText(this.hBW.getResources().getString(R.string.load_more));
            if (this.hCj.getChildAt(this.hCj.getChildCount() - 1) == this.fnt.getView()) {
                this.fnt.startLoadData();
                this.hBW.btu();
                return;
            }
            this.fnt.endLoadData();
            return;
        }
        this.fnt.setText(this.hBW.getResources().getString(R.string.load_more_must_after_delete));
        this.fnt.endLoadData();
    }

    public boolean bZs() {
        if (this.hCq) {
            return false;
        }
        this.fnt.setText(this.hBW.getResources().getString(R.string.load_more_must_after_delete));
        this.fnt.endLoadData();
        return true;
    }

    public boolean bZt() {
        return this.hCf != null && this.hCi.getVisibility() == 0;
    }

    public void bZu() {
        if (this.hCf != null) {
            this.hCg.setVisibility(0);
            this.hCi.setVisibility(8);
            this.hCh.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.hCS, 5000L);
        }
    }

    public void a(ce ceVar) {
        if (this.hCf == null) {
            View rootView = this.hBW.getRootView();
            this.hCf = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.hCf.setVisibility(0);
            this.hCg = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.hCh = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.hCi = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.hCh.setPageId(this.hBW.getUniqueId());
            this.hCi.setPageId(this.hBW.getUniqueId());
            this.hCh.setDefaultBgResource(R.color.common_color_10022);
            this.hCh.setDefaultResource(0);
            this.hCi.setDefaultBgResource(R.color.common_color_10022);
            this.hCi.setDefaultResource(0);
            this.hCg.setOnClickListener(this.hCn);
        }
        this.hCg.setVisibility(0);
        String aUG = ceVar.aUG();
        String aUH = ceVar.aUH();
        this.hCh.startLoad(aUG, 10, false);
        this.hCi.startLoad(aUH, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.hCS, 5000L);
    }

    public void bZv() {
        if (this.hCf != null && this.hCg != null) {
            this.hCg.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al bZw() {
        return this.hCk;
    }

    public RelativeLayout bLS() {
        return this.hBX;
    }

    public View bZx() {
        return this.hCp;
    }

    public void uv(int i) {
        if (this.hBZ != null) {
            this.hBZ.setVisibility(i);
        }
    }

    public void bZy() {
        if (com.baidu.tbadk.n.m.bhP().bhQ()) {
            int lastVisiblePosition = this.hCj.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hCj.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof t)) {
                    t tVar = (t) childAt.getTag();
                    if (tVar.hDg != null) {
                        com.baidu.tbadk.n.h perfLog = tVar.hDg.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eAN = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            tVar.hDg.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        tVar.hDg.startLogPerf();
                    }
                    if (tVar.hDf != null && (tVar.hDf instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = tVar.hDf;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eAN = true;
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

    public NavigationBar bwV() {
        return this.mNavigationBar;
    }

    public void buI() {
        this.mHasMore = true;
        this.hCj.setNextPage(this.fnt);
        if (this.hCr > 0) {
            this.fnt.showEmptyView(this.hCr);
        }
        this.fnt.setOnClickListener(null);
        this.fnt.startLoadData();
    }

    public void buJ() {
        this.mHasMore = false;
        this.hCj.setNextPage(this.fnt);
        if (this.hCr > 0) {
            this.fnt.showEmptyView(this.hCr);
        }
        this.fnt.setOnClickListener(null);
        this.fnt.endLoadData();
        this.fnt.setText(this.hBW.getResources().getString(R.string.list_has_no_more));
    }

    public void bZz() {
        this.mHasMore = true;
        this.hCj.setNextPage(this.fnt);
        this.fnt.setOnClickListener(this.hCn);
        if (this.hCr > 0) {
            this.fnt.showEmptyView(this.hCr);
        }
        this.fnt.endLoadData();
        this.fnt.setText(this.hBW.getResources().getString(R.string.list_click_load_more));
    }

    public View bZA() {
        if (this.fnt == null) {
            return null;
        }
        return this.fnt.getView();
    }

    public void uw(int i) {
        if (this.hCK != null) {
            this.hCK.setVisibility(i);
        }
    }

    public void ux(int i) {
        if (this.hCK != null) {
            this.hCK.setSelectNumber(i);
        }
    }

    public void uy(int i) {
        if (this.hCL != null) {
            this.hCL.setVisibility(i);
        }
    }

    public void uz(int i) {
        if (this.hCL != null) {
            this.hCL.setMoveNumber(i);
        }
    }

    public boolean bZB() {
        return this.hCL != null && this.hCL.cgD();
    }

    public void bZC() {
        if (this.hCL != null) {
            this.hCL.cgE();
        }
    }

    public void buK() {
        this.mHasMore = false;
        this.hCj.setNextPage(null);
    }

    public boolean bZD() {
        return this.fnt.getView().getParent() != null && this.mHasMore;
    }

    public void uA(int i) {
        this.hCr = i;
    }

    public void uB(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.hkh == null) {
                    this.hkh = new CommonTipView(this.hBW.getActivity());
                }
                this.hkh.setText(R.string.frs_login_tip);
                this.hkh.b((FrameLayout) bZx(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void ni(boolean z) {
        this.mIsBackground = z;
        if (this.hjm != null) {
            boolean z2 = (this.hBW == null || this.hBW.bXX() == null || this.hBW.bXX().cfP() == null) ? true : this.hBW.bXX().cfP().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.hjm.qs(false);
                this.hjm.cym();
                return;
            }
            this.hjm.qs(true);
            this.hjm.a(this.hBI, this.fmb, this.hCs, true);
        }
    }

    public void bV(int i, int i2) {
        if (this.hjm != null) {
            this.hjm.a(i, i2, this.hCs, 1);
        }
    }

    public void bW(int i, int i2) {
        this.hBI = i;
        this.fmb = i2;
    }

    public void nj(boolean z) {
        this.hCs = z;
    }

    public void uC(int i) {
        if (this.hCj != null && this.hCj.getChildCount() >= 0) {
            if (this.hCj.getFirstVisiblePosition() > 8) {
                this.hCj.scrollToPosition(8);
            }
            this.hCj.smoothScrollToPosition(i);
        }
    }

    public void bZE() {
        a(this.hCB, this.hBW.bYE());
        if (this.hCk != null) {
            this.hCk.cbF();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.hCC == null) {
                this.hCC = new com.baidu.tieba.video.g(this.hBW.getActivity(), this.hBX);
            }
            this.hCC.h(postWriteCallBackData);
        }
    }

    public void bZF() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.hCT && this.hBW.getActivity() != null && this.hBW.getPageContext() != null) {
            View view = null;
            if (this.hCj != null && (headerViewsCount = this.hCj.getHeaderViewsCount()) < this.hCj.getChildCount()) {
                view = this.hCj.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).af(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.p.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        p.this.hBW.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(p.this.hBW.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(p.this.hBW.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.p.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c kE = dVar.kE();
                kE.setShouldCheckLocInWindow(false);
                kE.show(this.hBW.getActivity());
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.p.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (kE != null) {
                            kE.dismiss();
                        }
                    }
                }, 4000L);
                this.hCT = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.hCK != null) {
            this.hCK.setDeleteCallback(aVar);
        }
    }

    public void bZG() {
        if (this.hCK != null) {
            this.hCK.bZG();
        }
    }

    public void bnp() {
        if (this.hCK != null) {
            this.hCK.bnp();
        }
    }

    public void aJ(String str, int i) {
        if (this.hCN == null) {
            this.hCN = new TextView(this.hBW.getActivity());
            this.hCN.setGravity(19);
            this.hCN.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hBW.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.hBW.getActivity(), R.dimen.ds34), 0);
            this.hCN.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hBW.getActivity(), R.dimen.tbds112)));
            this.hCN.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hBW.getActivity(), R.dimen.fontsize30));
            this.hCN.setMaxLines(2);
            this.hCN.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.hCN.setTextColor(ContextCompat.getColor(this.hBW.getActivity(), R.color.cp_cont_a));
        }
        this.hCM.setBackgroundColor(i);
        this.hCN.setText(str);
        this.hCM.a(this.hBW.getActivity(), this.hCN, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.WW != null) {
            this.WW.setExpanded(z);
        }
    }

    public void bZH() {
        if (this.hCl != null) {
            this.hCl.startPullRefresh();
        }
    }

    public void yA() {
        if (bZw() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = bZw().getDatas();
            if (!com.baidu.tbadk.core.util.w.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bt) {
                        bt btVar = (bt) qVar;
                        if (btVar.dLj != 0 && btVar.dLi != null && this.hBW.bXU() != null && this.hBW.bXU().cdn() != null) {
                            int[] imageWidthAndHeight = this.hBW.bXU().cdn().imageWidthAndHeight(btVar.dLi);
                            btVar.dLj = imageWidthAndHeight[0];
                            btVar.dLk = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.p.5
                    @Override // java.lang.Runnable
                    public void run() {
                        p.this.bZw().notifyDataSetChanged();
                        if (!p.this.mIsBackground) {
                            p.this.hjm.a(p.this.hBI, p.this.fmb, p.this.hCs, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bZI() {
        if (this.hCt == null) {
            return false;
        }
        return this.hCt.bZI();
    }

    public Context getContext() {
        if (this.hBW == null) {
            return null;
        }
        return this.hBW.getTbPageContext().getPageActivity();
    }

    public void M(int i, boolean z) {
        if (this.hCl != null) {
            this.hCl.M(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.hCl != null) {
            this.hCl.startPullRefresh();
        }
    }

    public void bZJ() {
        if (this.hCl != null) {
            this.hCl.bZJ();
        }
    }

    public void bZK() {
        if (this.hCl != null) {
            this.hCl.bZK();
        }
    }

    public void a(as asVar) {
        if (this.hCl != null) {
            this.hCl.a(asVar);
        }
    }

    public void uD(int i) {
        if (this.hCl != null) {
            this.hCl.uD(i);
        }
    }
}
