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
import com.baidu.tbadk.KuangFloatingFrsCopyLinkViewController;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.cf;
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
/* loaded from: classes16.dex */
public class p {
    private AppBarLayout WP;
    private NoNetworkView fqQ;
    private PbListView fsC;
    private FrsFragment hHU;
    private View hHY;
    private com.baidu.tieba.c.d hHZ;
    private com.baidu.tieba.video.f hIA;
    private AppBarLayoutStickyBehavior hIB;
    private FrsHeaderViewContainer hIC;
    private CollapsingToolbarLayout hID;
    private com.baidu.tieba.frs.vc.h hIH;
    private FrsMultiDelBottomMenuView hII;
    private FrsMoveAreaBottomMenuView hIJ;
    private NavigationBarCoverTip hIK;
    private TextView hIL;
    private TextView hIM;
    private boolean hIR;
    private ImageView hIa;
    private ImageView hIb;
    private TextView hIc;
    private ViewStub hId;
    private BdTypeRecyclerView hIh;
    private com.baidu.tieba.frs.entelechy.a.al hIi;
    private com.baidu.tieba.frs.vc.k hIj;
    private View.OnClickListener hIl;
    private View hIm;
    private View hIn;
    private int hIp;
    private com.baidu.tieba.frs.vc.d hIr;
    private com.baidu.tieba.frs.entelechy.b.c hIs;
    private com.baidu.tieba.frs.vc.m hIt;
    private GifView hIu;
    private TbImageView hIv;
    private HashSet<String> hIw;
    private ObservedChangeLinearLayout hIy;
    private com.baidu.tieba.frs.entelechy.b.a hIz;
    private ImageView hcH;
    private MessageRedDotView hcI;
    private com.baidu.tieba.play.i hoU;
    private CommonTipView hpP;
    private com.baidu.adp.widget.ListView.n hqR;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout hHV = null;
    private CoordinatorLayout hHW = null;
    private View hHX = null;
    private FrameLayout hIe = null;
    private TbImageView hIf = null;
    private TbImageView hIg = null;
    private com.baidu.tbadk.core.dialog.b hIk = null;
    private NoNetworkView.a hCK = null;
    private boolean hIo = true;
    private boolean mHasMore = true;
    private boolean hIq = false;
    private int hHG = 0;
    private int frk = 0;
    private View biX = null;
    private View hIx = null;
    private boolean fUU = false;
    private boolean drF = true;
    private boolean hIE = true;
    private int hIF = -1;
    private int hIG = -1;
    private int hIN = 0;
    private int hIO = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener hqT = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.p.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (p.this.hqR == null) {
                        p.this.hqR = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    p.this.hqR.a(p.this.hIh, 2);
                } else if (p.this.hqR != null) {
                    p.this.hqR.pD();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hIP = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.p.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            p.this.a(appBarLayout, i);
            if (p.this.hIj != null) {
                p.this.hIj.setInterceptScrollDown(i == 0);
            }
            if (p.this.hIG != i && Math.abs(i) >= 0 && p.this.ccx() != -1) {
                if (Math.abs(i) >= p.this.ccx()) {
                    if (p.this.hIE) {
                        p.this.hIE = false;
                        p.this.nF(p.this.hIE);
                    }
                } else if (!p.this.hIE) {
                    p.this.hIE = true;
                    p.this.nF(p.this.hIE);
                }
                int cct = p.this.cct() + p.this.ccs() + p.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cct;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && p.this.hIG - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        p.this.uJ(Math.abs(cct - totalScrollRange2));
                        if (p.this.hIx != null) {
                            p.this.hIx.setVisibility(0);
                        }
                    } else if (p.this.hIx != null) {
                        if (p.this.ccr() != UtilHelper.getStatusBarHeight()) {
                            p.this.uJ(0);
                        }
                        p.this.hIx.setVisibility(8);
                    }
                    if (p.this.mNavigationBar != null) {
                        if (p.this.fUU) {
                            p.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            p.this.nK(false);
                        } else if (p.this.hIM != null) {
                            p.this.hIM.setAlpha(abs);
                        }
                    }
                    p.this.hIG = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (p.this.hIj != null) {
                int cjc = p.this.hIj.cjc();
                int cjd = cjc - p.this.hIj.cjd();
                if (cjc > 0 && Math.abs(i) >= cjd) {
                    p.this.hIj.dismissLoading();
                }
            }
        }
    };
    private Runnable hIQ = new Runnable() { // from class: com.baidu.tieba.frs.p.13
        @Override // java.lang.Runnable
        public void run() {
            if (p.this.hId != null) {
                p.this.hIe.setVisibility(0);
                p.this.hIg.setVisibility(0);
                p.this.hIf.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.hHU != null && appBarLayout != null && this.hHU.cbu() != null && this.hHU.getPageContext() != null) {
            int ccs = ccs() + getNavigationBarHeight() + cct();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cbu = this.hHU.cbu();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.hHU.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.hHU.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.hHX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.hHU != null && this.hHU.cbB();
            if (totalScrollRange <= 0) {
                if (this.hIO != 2) {
                    cbu.wD(2);
                }
                this.hIO = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= ccs) {
                if (this.hIO != 1) {
                    cbu.wD(1);
                }
                this.hIO = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.hIO != 0) {
                    cbu.wD(0);
                }
                this.hIO = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.hHU.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.hHX.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout ccp() {
        return this.hIy;
    }

    public View IA() {
        return this.biX;
    }

    public View ccq() {
        return this.hIx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ccr() {
        if (this.biX == null) {
            return 0;
        }
        return this.biX.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ccs() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cct() {
        if (this.fqQ == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fqQ.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uJ(int i) {
        View IA = IA();
        View ccq = ccq();
        if (UtilHelper.canUseStyleImmersiveSticky() && IA != null && ccq != null && IA.getLayoutParams() != null && ccq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = IA.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            IA.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = ccq.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            ccq.setLayoutParams(layoutParams2);
        }
    }

    public p(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.hHU = null;
        this.hIl = null;
        this.hIp = 0;
        this.hHU = frsFragment;
        this.hIl = onClickListener;
        MessageManager.getInstance().registerListener(this.hqT);
        a(aVar, z);
        this.hIw = new HashSet<>();
        this.hIp = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.hIH = hVar;
    }

    private boolean ccu() {
        return this.hIH != null && this.hIH.ciO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.hIz = aVar;
        View rootView = this.hHU.getRootView();
        if (this.hHV == null) {
            this.hHV = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.hHX == null) {
            this.hHX = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.hHW == null) {
            this.hHW = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.hIn == null) {
            this.hIn = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.hID == null) {
            this.hID = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.hIC == null) {
            this.hIC = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.hIj == null) {
            this.hIj = new com.baidu.tieba.frs.vc.k(this.hHU);
        }
        if (this.hIy == null) {
            this.hIy = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.hIy.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.p.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        p.this.hID.setMinimumHeight(i2);
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
        if (this.hHU.ccc()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.hIm == null) {
            this.hIm = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b ceJ = aVar.ceJ();
            if (ceJ != null) {
                ceJ.ce(this.hIm);
            }
        }
        if (this.hHY == null) {
            this.hHY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hHY.setOnClickListener(this.hIl);
            this.mBackImageView = (ImageView) this.hHY.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hIb == null) {
            this.hIb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.baR().a(this.hIb, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hIb.setOnClickListener(this.hIl);
        }
        if (this.hHZ == null) {
            this.hHZ = new com.baidu.tieba.c.d(this.hHU.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hHZ.getView(), (View.OnClickListener) null);
            this.hcH = this.hHZ.bSN();
            this.hcI = this.hHZ.bSO();
            this.hHZ.getView().setOnClickListener(this.hIl);
            this.hHZ.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.hIa == null) {
            this.hIa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.baR().a(this.hIa, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hIa.setOnClickListener(this.hIl);
        }
        if (this.hIc == null) {
            this.hIc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.hIc.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ao.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.hHU.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hIc.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ao.g(this.hIc, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.hIc, R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.hHU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.hIh == null) {
            this.hIh = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.p.8
            int hIU = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.hIU--;
                if (this.hIU == 0) {
                    p.this.hIh.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.hIU++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.hIh.setItemAnimator(defaultItemAnimator);
        this.hIh.setLayoutManager(new LinearLayoutManager(this.hIh.getContext()) { // from class: com.baidu.tieba.frs.p.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hqR = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.hqR.a(this.hIh, 2);
        }
        this.hIh.setScrollable(this.hHU);
        this.hIh.setFadingEdgeLength(0);
        this.hIh.setOverScrollMode(2);
        this.hHV.setBottomOrderView(this.hIh);
        this.hIh.setOnTouchListener(this.hHU.eKY);
        this.hIh.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.p.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (p.this.hoU != null) {
                    p.this.hoU.cA(view);
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
        if (this.fsC == null) {
            this.fsC = new PbListView(this.hHU.getPageContext().getPageActivity());
            this.fsC.getView();
        }
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fsC.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hHU.getActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_d));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hIh.setOnSrollToBottomListener(this.hHU);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.p.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                p.this.hHU.cbV();
                if (p.this.hHU != null && p.this.WP != null) {
                    p.this.hHU.ccf();
                    p.this.WP.setExpanded(true);
                    if (p.this.hoU != null) {
                        p.this.hoU.a(p.this.hHG, p.this.frk, false, true);
                    }
                }
            }
        });
        boolean baT = com.baidu.tbadk.core.util.at.baS().baT();
        if (this.hIi == null) {
            this.hIi = aVar.a(this.hHU, this.hIh, baT);
        }
        if (this.hIj != null) {
            this.hIj.M(1, false);
        }
        if (!z) {
            if (this.fqQ == null) {
                this.fqQ = new NoNetworkView(this.hHU.getActivity());
                this.fqQ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.hIy.addView(this.fqQ);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fqQ.setVisibility(8);
            } else {
                this.fqQ.setVisibility(0);
            }
            this.fqQ.onChangeSkinType(this.hHU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        ccE();
        if (this.hIr == null) {
            this.hIr = aVar.a(this.hHU, this.hHV);
            this.hIr.b(this.hHU.ccg());
        }
        if (this.hIs == null) {
            this.hIs = aVar.b(this.hHU, this.hHV);
            nI(true);
        }
        if (this.biX == null) {
            this.biX = rootView.findViewById(R.id.statebar_view);
        }
        if (this.hIx == null) {
            this.hIx = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.hoU == null) {
            this.hoU = new com.baidu.tieba.play.i(this.hHU.getPageContext(), this.hIh);
        }
        this.hoU.Dm(1);
        this.hoU.setUniqueId(this.hHU.getUniqueId());
        this.hIK = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.hIt == null) {
            this.hIt = new com.baidu.tieba.frs.vc.m(this.hHU, this.hIK);
        }
        if (this.WP == null) {
            this.WP = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.WP.addOnOffsetChangedListener(this.hIP);
            this.hIE = true;
            this.hIF = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.WP.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.hIB = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.hII = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.hII.setPageContext(this.hHU.getPageContext());
        this.hIJ = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.hIJ.setPageContext(this.hHU.getPageContext());
        if (this.hIM == null) {
            this.hIM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hHU.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.hIM.setLayoutParams(layoutParams2);
            this.hIM.setPadding(0, 0, this.hHU.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.hIM.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_b));
        }
    }

    public void bE(boolean z) {
        if (z) {
        }
    }

    private void ccv() {
        ViewGroup.LayoutParams layoutParams;
        this.fUU = ccu();
        if (this.hIC != null && (layoutParams = this.hIC.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.fUU) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + ccs(), 0, 0);
            }
            this.hIC.requestLayout();
        }
    }

    public void ccw() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.hIy != null) {
            ccv();
            if (this.fUU) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.biX != null) {
                    this.biX.setAlpha(1.0f);
                }
                if (this.hIx != null) {
                    this.hIx.setAlpha(1.0f);
                }
                if (this.hIM != null) {
                    this.hIM.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nF(boolean z) {
        if (z && this.hHU != null && this.hHU.cbt() != null) {
            this.hHU.cbt().ciT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ccx() {
        int i;
        if (this.WP == null) {
            return this.hIF;
        }
        if (this.hIF != -1) {
            return this.hIF;
        }
        int childCount = this.WP.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.WP.getChildAt(childCount);
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
        this.hIF = Math.max(0, this.WP.getTotalScrollRange() - Math.abs(i2));
        return this.hIF;
    }

    public void FP(String str) {
        if (this.hIt != null) {
            this.hIt.FP(str);
        }
    }

    public com.baidu.tieba.play.i ccy() {
        return this.hoU;
    }

    public com.baidu.tieba.frs.entelechy.b.c ccz() {
        return this.hIs;
    }

    public void nG(boolean z) {
        if (this.hIr != null) {
            if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                this.hIr.nG(false);
            } else {
                this.hIr.nG(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d ccA() {
        return this.hIr;
    }

    public void Q(boolean z, boolean z2) {
        if (this.drF && this.hIs != null) {
            this.hIs.Q(z, z2);
        }
    }

    public void nH(boolean z) {
        this.drF = z;
        if (!this.drF && this.hIs != null) {
            this.hIs.Q(false, false);
        }
    }

    public void ccB() {
        if (this.drF && this.hIs != null) {
            this.hIs.Q(false, false);
        }
        uK(8);
        this.hIb.setVisibility(8);
        this.hIa.setVisibility(8);
        nG(false);
        this.hIh.setVisibility(8);
        this.hIC.setVisibility(8);
    }

    public void ccC() {
        if (this.drF && this.hIs != null) {
            this.hIs.Q(true, false);
        }
        uK(0);
        ccD();
        nG(this.hHU.cci());
        this.hIh.setVisibility(0);
        this.hIC.setVisibility(0);
    }

    private void uK(int i) {
        if (this.hHZ != null) {
            this.hHZ.setVisibility(i);
        }
    }

    private void ccD() {
        this.hIb.setVisibility(0);
        this.hIa.setVisibility(0);
    }

    public void nI(boolean z) {
        if (this.hIs != null) {
            this.hIs.ok(z);
        }
    }

    private void ccE() {
        if (this.hIu == null) {
            View rootView = this.hHU.getRootView();
            this.hIu = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.hIv = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.hIv.setPageId(this.hHU.getUniqueId());
            this.hIu.setLayerType(1, null);
            this.hIv.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View ccF() {
        return this.hHY;
    }

    public void g(NoNetworkView.a aVar) {
        this.hCK = aVar;
        if (this.fqQ != null) {
            this.fqQ.a(this.hCK);
        }
    }

    public void nJ(boolean z) {
        if (this.hIs != null) {
            if (z) {
                Q(false, true);
            } else {
                Q(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hIh.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.z zVar) {
        this.hIi.a(zVar);
    }

    public void setForumName(String str) {
        this.hIi.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hqT);
        if (this.hoU != null) {
            this.hoU.destroy();
        }
        if (this.hIt != null) {
            this.hIt.onDestory();
        }
        if (this.hII != null) {
            this.hII.setPageContext(null);
        }
        if (this.hIJ != null) {
            this.hIJ.setPageContext(null);
        }
        this.hIi.onDestory();
        this.hIh.setOnSrollToBottomListener(null);
        this.hIh.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.hIQ);
        if (this.hpP != null) {
            this.hpP.onDestroy();
        }
        this.hIw.clear();
        if (this.hIr != null) {
            this.hIr.ciy();
        }
        if (this.hIA != null) {
            this.hIA.ceq();
        }
        if (this.hIK != null) {
            this.hIK.onDestroy();
        }
        if (this.hII != null) {
            this.hII.onDestroy();
        }
        if (this.hIj != null) {
            this.hIj.onDestroy();
        }
    }

    public boolean ccG() {
        if (this.WP == null || this.hIB == null || !this.hIB.isSticky()) {
            return this.hIr != null && this.hIr.ccG();
        }
        if (this.hIh != null) {
            this.hIh.setSelection(0);
        }
        this.hIB.expandedAppBarLayout(this.WP);
        return true;
    }

    public boolean cca() {
        if (this.hIj == null) {
            return false;
        }
        return this.hIj.cca();
    }

    public void bBY() {
        this.hIh.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.hIM.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.hIM.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.hIM.setText(str2);
            com.baidu.tbadk.core.k.aTv().setForumNameForWaterImage(str);
        }
    }

    public void ccH() {
        if (this.hIi != null) {
            this.hIi.notifyDataSetChanged();
        }
    }

    public void aJP() {
        if (this.hIi instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.hIi).aJP();
        }
    }

    private void ccI() {
        if (this.hIk == null && this.hHU.getPageContext() != null) {
            String[] strArr = {this.hHU.getPageContext().getPageActivity().getString(R.string.take_photo), this.hHU.getPageContext().getPageActivity().getString(R.string.album)};
            this.hIk = new com.baidu.tbadk.core.dialog.b(this.hHU.getPageContext().getPageActivity());
            this.hIk.xm(this.hHU.getPageContext().getPageActivity().getString(R.string.operation));
            this.hIk.a(strArr, new b.InterfaceC0492b() { // from class: com.baidu.tieba.frs.p.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        p.this.hHU.ccb();
                    } else if (i == 1 && p.this.hHU.getPageContext() != null) {
                        com.baidu.tbadk.core.util.an.getAlbumImage(p.this.hHU.getPageContext().getPageActivity());
                    }
                }
            });
            this.hIk.d(this.hHU.getPageContext());
        }
    }

    public void ccJ() {
        ccI();
        if (this.hIk != null) {
            this.hIk.aYN();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.q> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.q> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.x.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                r rVar = new r();
                ArrayList<com.baidu.adp.widget.ListView.q> arrayList3 = new ArrayList<>();
                arrayList3.add(rVar);
                if (this.hHU != null && this.hHU.cbr() != null && this.hHU.cbr().chk() == 0) {
                    rVar.uW(this.hHU.cbr().chr());
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
                    com.baidu.adp.widget.ListView.q qVar = arrayList2.get(i2);
                    if (qVar instanceof bu) {
                        ((bu) qVar).dLK.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.hIi.b(arrayList2, frsViewData);
            if (this.hoU != null && this.hHG != 0) {
                this.hoU.a(this.hHG, this.frk, this.hIq, true);
            }
            if (this.hHU != null) {
                this.hHU.ccl();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.hIh;
    }

    public void ccK() {
        this.hIi.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ac acVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hHU.getPageContext(), 1);
        aVar.a(this.hIh);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.hHU.getForumName());
        hashMap.put("forum_id", this.hHU.getForumId());
        aVar.setParams(hashMap);
        aVar.au(acVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.hIr != null) {
            this.hIr.ciz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        uL(TbadkCoreApplication.getInst().getSkinType());
        if (this.hIr != null) {
            this.hIr.ciA();
        }
    }

    public void release() {
        if (this.fqQ != null && this.hCK != null) {
            this.fqQ.b(this.hCK);
        }
    }

    public ImageView ccL() {
        return this.hIb;
    }

    public ImageView ccM() {
        return this.hIa;
    }

    public TextView ccN() {
        return this.hIc;
    }

    public View ccO() {
        if (this.hHZ != null) {
            return this.hHZ.getView();
        }
        return null;
    }

    public void L(int i, boolean z) {
        if (this.hHZ != null) {
            this.hHZ.x(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.hHU, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hHU.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.hIv != null) {
            this.hIv.invalidate();
        }
        if (this.hIi != null) {
            this.hIi.cfh();
            this.hIi.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.hHU.getPageContext(), this.hHV);
        if (this.fqQ != null) {
            this.fqQ.onChangeSkinType(this.hHU.getPageContext(), i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_d));
            this.fsC.changeSkin(i);
        }
        if (this.hIM != null) {
            this.hIM.setTextColor(com.baidu.tbadk.core.util.ao.getColor(R.color.cp_cont_b));
        }
        uL(i);
        if (this.hIs != null) {
            this.hIs.onChangeSkinType(i);
        }
        if (this.hIr != null) {
            this.hIr.onChangeSkinType(i);
        }
        if (this.hII != null) {
            this.hII.onChangeSkinType();
        }
        if (this.hIJ != null) {
            this.hIJ.onChangeSkinType();
        }
        if (this.hHU != null && this.hHU.cbB()) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.hHX, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.hHX, R.color.cp_bg_line_d);
        }
    }

    private void uL(int i) {
        if (this.hHU != null) {
            uM(i);
        }
    }

    private void uM(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hHU.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.hIm, R.color.cp_bg_line_c, i);
            if (this.hHZ != null) {
                this.hHZ.onChangeSkinType(i);
            }
            if (this.hIb != null) {
                SvgManager.baR().a(this.hIb, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.hIa != null) {
                SvgManager.baR().a(this.hIa, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.biX, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.hIx, R.color.cp_bg_line_h);
        nK(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nK(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fUU) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.hIN != 0) {
                    SvgManager.baR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(this.hIb, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(this.hcH, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.baR().a(this.hIa, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.hIN = 0;
                }
            } else if (z || this.hIN != 1) {
                SvgManager.baR().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.baR().a(this.hIb, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.baR().a(this.hcH, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.baR().a(this.hIa, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.hIN = 1;
            }
            ccP();
        }
    }

    private void ccP() {
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
            if (this.hIM != null) {
                this.hIM.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.hcH != null) {
                    this.hcH.setAlpha(f);
                }
                if (this.hcI != null) {
                    this.hcI.setAlpha(f);
                }
                if (this.hIb != null) {
                    this.hIb.setAlpha(f);
                }
                if (this.hIa != null) {
                    this.hIa.setAlpha(f);
                }
            }
            if (this.hIc != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.hIc.setAlpha(f2);
                this.hIc.setClickable(f2 > 0.0f);
            }
            if (this.biX != null) {
                this.biX.setAlpha(alpha);
            }
            if (this.hIx != null) {
                this.hIx.setAlpha(alpha);
            }
            if (this.hIm != null) {
                this.hIm.setAlpha(alpha);
            }
        }
    }

    public void bxe() {
        if (this.hIj != null) {
            this.hIj.bxe();
        }
    }

    public void nL(boolean z) {
        if (this.hIj != null) {
            this.hIj.nL(z);
        }
    }

    public void nM(boolean z) {
        this.hIo = z;
        if (this.hIo) {
            this.fsC.setText(this.hHU.getResources().getString(R.string.load_more));
            if (this.hIh.getChildAt(this.hIh.getChildCount() - 1) == this.fsC.getView()) {
                this.fsC.startLoadData();
                this.hHU.bwE();
                return;
            }
            this.fsC.endLoadData();
            return;
        }
        this.fsC.setText(this.hHU.getResources().getString(R.string.load_more_must_after_delete));
        this.fsC.endLoadData();
    }

    public boolean ccQ() {
        if (this.hIo) {
            return false;
        }
        this.fsC.setText(this.hHU.getResources().getString(R.string.load_more_must_after_delete));
        this.fsC.endLoadData();
        return true;
    }

    public boolean ccR() {
        return this.hId != null && this.hIg.getVisibility() == 0;
    }

    public void ccS() {
        if (this.hId != null) {
            this.hIe.setVisibility(0);
            this.hIg.setVisibility(8);
            this.hIf.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.hIQ, 5000L);
        }
    }

    public void a(cf cfVar) {
        if (this.hId == null) {
            View rootView = this.hHU.getRootView();
            this.hId = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.hId.setVisibility(0);
            this.hIe = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.hIf = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.hIg = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.hIf.setPageId(this.hHU.getUniqueId());
            this.hIg.setPageId(this.hHU.getUniqueId());
            this.hIf.setDefaultBgResource(R.color.common_color_10022);
            this.hIf.setDefaultResource(0);
            this.hIg.setDefaultBgResource(R.color.common_color_10022);
            this.hIg.setDefaultResource(0);
            this.hIe.setOnClickListener(this.hIl);
        }
        this.hIe.setVisibility(0);
        String aYA = cfVar.aYA();
        String aYB = cfVar.aYB();
        this.hIf.startLoad(aYA, 10, false);
        this.hIg.startLoad(aYB, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.hIQ, 5000L);
    }

    public void ccT() {
        if (this.hId != null && this.hIe != null) {
            this.hIe.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al ccU() {
        return this.hIi;
    }

    public RelativeLayout bPb() {
        return this.hHV;
    }

    public View ccV() {
        return this.hIn;
    }

    public void uN(int i) {
        if (this.hHX != null) {
            this.hHX.setVisibility(i);
        }
    }

    public void ccW() {
        if (com.baidu.tbadk.n.m.blA().blB()) {
            int lastVisiblePosition = this.hIh.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hIh.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof t)) {
                    t tVar = (t) childAt.getTag();
                    if (tVar.hJe != null) {
                        com.baidu.tbadk.n.h perfLog = tVar.hJe.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eHc = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            tVar.hJe.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        tVar.hJe.startLogPerf();
                    }
                    if (tVar.hJd != null && (tVar.hJd instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = tVar.hJd;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eHc = true;
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

    public NavigationBar bAm() {
        return this.mNavigationBar;
    }

    public void bxS() {
        this.mHasMore = true;
        this.hIh.setNextPage(this.fsC);
        if (this.hIp > 0) {
            this.fsC.showEmptyView(this.hIp);
        }
        this.fsC.setOnClickListener(null);
        this.fsC.startLoadData();
    }

    public void bxT() {
        this.mHasMore = false;
        this.hIh.setNextPage(this.fsC);
        if (this.hIp > 0) {
            this.fsC.showEmptyView(this.hIp);
        }
        this.fsC.setOnClickListener(null);
        this.fsC.endLoadData();
        this.fsC.setText(this.hHU.getResources().getString(R.string.list_has_no_more));
    }

    public void ccX() {
        this.mHasMore = true;
        this.hIh.setNextPage(this.fsC);
        this.fsC.setOnClickListener(this.hIl);
        if (this.hIp > 0) {
            this.fsC.showEmptyView(this.hIp);
        }
        this.fsC.endLoadData();
        this.fsC.setText(this.hHU.getResources().getString(R.string.list_click_load_more));
    }

    public View ccY() {
        if (this.fsC == null) {
            return null;
        }
        return this.fsC.getView();
    }

    public void uO(int i) {
        if (this.hII != null) {
            this.hII.setVisibility(i);
        }
    }

    public void uP(int i) {
        if (this.hII != null) {
            this.hII.setSelectNumber(i);
        }
    }

    public void uQ(int i) {
        if (this.hIJ != null) {
            this.hIJ.setVisibility(i);
        }
    }

    public void uR(int i) {
        if (this.hIJ != null) {
            this.hIJ.setMoveNumber(i);
        }
    }

    public boolean ccZ() {
        return this.hIJ != null && this.hIJ.ckd();
    }

    public void cda() {
        if (this.hIJ != null) {
            this.hIJ.cke();
        }
    }

    public void bxU() {
        this.mHasMore = false;
        this.hIh.setNextPage(null);
    }

    public boolean cdb() {
        return this.fsC.getView().getParent() != null && this.mHasMore;
    }

    public void uS(int i) {
        this.hIp = i;
    }

    public void uT(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.hpP == null) {
                    this.hpP = new CommonTipView(this.hHU.getActivity());
                }
                this.hpP.setText(R.string.frs_login_tip);
                this.hpP.b((FrameLayout) ccV(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void nN(boolean z) {
        this.mIsBackground = z;
        if (this.hoU != null) {
            boolean z2 = (this.hHU == null || this.hHU.cbu() == null || this.hHU.cbu().cjp() == null) ? true : this.hHU.cbu().cjp().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.hoU.qZ(false);
                this.hoU.cCl();
                return;
            }
            this.hoU.qZ(true);
            this.hoU.a(this.hHG, this.frk, this.hIq, true);
        }
    }

    public void bY(int i, int i2) {
        if (this.hoU != null) {
            this.hoU.a(i, i2, this.hIq, 1);
        }
    }

    public void bZ(int i, int i2) {
        this.hHG = i;
        this.frk = i2;
    }

    public void nO(boolean z) {
        this.hIq = z;
    }

    public void uU(int i) {
        if (this.hIh != null && this.hIh.getChildCount() >= 0) {
            if (this.hIh.getFirstVisiblePosition() > 8) {
                this.hIh.scrollToPosition(8);
            }
            this.hIh.smoothScrollToPosition(i);
        }
    }

    public void cdc() {
        a(this.hIz, this.hHU.ccc());
        if (this.hIi != null) {
            this.hIi.cfe();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.hIA == null) {
                this.hIA = new com.baidu.tieba.video.f(this.hHU.getActivity(), this.hHV);
            }
            this.hIA.h(postWriteCallBackData);
        }
    }

    public void cdd() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.hIR && this.hHU.getActivity() != null && this.hHU.getPageContext() != null) {
            View view = null;
            if (this.hIh != null && (headerViewsCount = this.hIh.getHeaderViewsCount()) < this.hIh.getChildCount()) {
                view = this.hIh.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ah(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.p.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        p.this.hHU.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(p.this.hHU.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(p.this.hHU.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.p.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c kE = dVar.kE();
                kE.setShouldCheckLocInWindow(false);
                kE.show(this.hHU.getActivity());
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.p.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (kE != null) {
                            kE.dismiss();
                        }
                    }
                }, 4000L);
                this.hIR = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.hII != null) {
            this.hII.setDeleteCallback(aVar);
        }
    }

    public void cde() {
        if (this.hII != null) {
            this.hII.cde();
        }
    }

    public void brl() {
        if (this.hII != null) {
            this.hII.brl();
        }
    }

    public void aI(String str, int i) {
        if (this.hIL == null) {
            this.hIL = new TextView(this.hHU.getActivity());
            this.hIL.setGravity(19);
            this.hIL.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hHU.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.hHU.getActivity(), R.dimen.ds34), 0);
            this.hIL.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hHU.getActivity(), R.dimen.tbds112)));
            this.hIL.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hHU.getActivity(), R.dimen.fontsize30));
            this.hIL.setMaxLines(2);
            this.hIL.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.hIL.setTextColor(ContextCompat.getColor(this.hHU.getActivity(), R.color.cp_cont_a));
        }
        this.hIK.setBackgroundColor(i);
        this.hIL.setText(str);
        this.hIK.a(this.hHU.getActivity(), this.hIL, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.WP != null) {
            this.WP.setExpanded(z);
        }
    }

    public void cdf() {
        if (this.hIj != null) {
            this.hIj.startPullRefresh();
        }
    }

    public void zc() {
        if (ccU() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = ccU().getDatas();
            if (!com.baidu.tbadk.core.util.x.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bu) {
                        bu buVar = (bu) qVar;
                        if (buVar.dRu != 0 && buVar.dLK != null && this.hHU.cbr() != null && this.hHU.cbr().cgN() != null) {
                            int[] imageWidthAndHeight = buVar.dLK.getImageWidthAndHeight();
                            buVar.dRu = imageWidthAndHeight[0];
                            buVar.dRv = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.p.5
                    @Override // java.lang.Runnable
                    public void run() {
                        p.this.ccU().notifyDataSetChanged();
                        if (!p.this.mIsBackground) {
                            p.this.hoU.a(p.this.hHG, p.this.frk, p.this.hIq, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cdg() {
        if (this.hIr == null) {
            return false;
        }
        return this.hIr.cdg();
    }

    public Context getContext() {
        if (this.hHU == null) {
            return null;
        }
        return this.hHU.getTbPageContext().getPageActivity();
    }

    public void M(int i, boolean z) {
        if (this.hIj != null) {
            this.hIj.M(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.hIj != null) {
            this.hIj.startPullRefresh();
        }
    }

    public void cdh() {
        if (this.hIj != null) {
            this.hIj.cdh();
        }
    }

    public void cdi() {
        if (this.hIj != null) {
            this.hIj.cdi();
        }
    }

    public void a(as asVar) {
        if (this.hIj != null) {
            this.hIj.a(asVar);
        }
    }

    public void uV(int i) {
        if (this.hIj != null) {
            this.hIj.uV(i);
        }
    }
}
