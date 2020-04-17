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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bt;
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
/* loaded from: classes9.dex */
public class n {
    private AppBarLayout VZ;
    private PbListView ePm;
    private NoNetworkView gAG;
    private com.baidu.tieba.play.m gHv;
    private CommonTipView gIp;
    private com.baidu.adp.widget.ListView.k gJn;
    private ImageView gva;
    private MessageRedDotView gvb;
    private View.OnClickListener haA;
    private View haB;
    private View haC;
    private int haE;
    private com.baidu.tieba.frs.vc.d haG;
    private com.baidu.tieba.frs.entelechy.b.c haH;
    private com.baidu.tieba.frs.vc.m haI;
    private GifView haJ;
    private TbImageView haK;
    private HashSet<String> haL;
    private ObservedChangeLinearLayout haN;
    private com.baidu.tieba.frs.entelechy.b.a haO;
    private com.baidu.tieba.video.f haP;
    private AppBarLayoutStickyBehavior haQ;
    private FrsHeaderViewContainer haR;
    private CollapsingToolbarLayout haS;
    private com.baidu.tieba.frs.vc.h haW;
    private FrsMultiDelBottomMenuView haX;
    private NavigationBarCoverTip haY;
    private TextView haZ;
    private FrsFragment hah;
    private View hal;
    private com.baidu.tieba.c.b ham;
    private ImageView han;
    private ImageView hao;
    private TextView hap;
    private ViewStub haq;
    private BdTypeRecyclerView hau;
    private com.baidu.tieba.frs.entelechy.a.ai hav;
    private com.baidu.tieba.frs.vc.k haw;
    private FloatingAnimationView hax;
    private com.baidu.tieba.c.c hay;
    private TextView hba;
    private boolean hbf;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout hai = null;
    private CoordinatorLayout haj = null;
    private View hak = null;
    private FrameLayout har = null;
    private TbImageView has = null;
    private TbImageView hat = null;
    private com.baidu.tbadk.core.dialog.b haz = null;
    private NoNetworkView.a gVM = null;
    private boolean haD = true;
    private boolean mHasMore = true;
    private boolean haF = false;
    private int gZW = 0;
    private int eNU = 0;
    private View aVX = null;
    private View haM = null;
    private boolean fqi = false;
    private boolean cVS = true;
    private boolean haT = true;
    private int haU = -1;
    private int haV = -1;
    private int hbb = 0;
    private int hbc = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener gJp = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.n.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (n.this.gJn == null) {
                        n.this.gJn = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
                    }
                    n.this.gJn.a(n.this.hau, 2);
                } else if (n.this.gJn != null) {
                    n.this.gJn.pf();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener hbd = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.n.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            n.this.a(appBarLayout, i);
            if (n.this.haw != null) {
                n.this.haw.setInterceptScrollDown(i == 0);
            }
            if (n.this.haV != i && Math.abs(i) >= 0 && n.this.bPu() != -1) {
                if (Math.abs(i) >= n.this.bPu()) {
                    if (n.this.haT) {
                        n.this.haT = false;
                        n.this.mu(n.this.haT);
                    }
                } else if (!n.this.haT) {
                    n.this.haT = true;
                    n.this.mu(n.this.haT);
                }
                int bPq = n.this.bPq() + n.this.bPp() + n.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - bPq;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && n.this.haV - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        n.this.th(Math.abs(bPq - totalScrollRange2));
                        if (n.this.haM != null) {
                            n.this.haM.setVisibility(0);
                        }
                    } else if (n.this.haM != null) {
                        if (n.this.bPo() != UtilHelper.getStatusBarHeight()) {
                            n.this.th(0);
                        }
                        n.this.haM.setVisibility(8);
                    }
                    if (n.this.mNavigationBar != null) {
                        if (n.this.fqi) {
                            n.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            n.this.mz(false);
                        } else if (n.this.hba != null) {
                            n.this.hba.setAlpha(abs);
                        }
                    }
                    n.this.haV = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (n.this.haw != null) {
                int bVF = n.this.haw.bVF();
                int bVG = bVF - n.this.haw.bVG();
                if (bVF > 0 && Math.abs(i) >= bVG) {
                    n.this.haw.aqh();
                }
            }
        }
    };
    private Runnable hbe = new Runnable() { // from class: com.baidu.tieba.frs.n.13
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.haq != null) {
                n.this.har.setVisibility(0);
                n.this.hat.setVisibility(0);
                n.this.has.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.hah != null && appBarLayout != null && this.hah.bOv() != null && this.hah.getPageContext() != null) {
            int bPp = bPp() + getNavigationBarHeight() + bPq();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController bOv = this.hah.bOv();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.hah.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.hah.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.hak.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.hah != null && this.hah.bOC();
            if (totalScrollRange <= 0) {
                if (this.hbc != 2) {
                    bOv.uY(2);
                }
                this.hbc = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= bPp) {
                if (this.hbc != 1) {
                    bOv.uY(1);
                }
                this.hbc = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.hbc != 0) {
                    bOv.uY(0);
                }
                this.hbc = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.hah.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.hak.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout bPm() {
        return this.haN;
    }

    public View Fr() {
        return this.aVX;
    }

    public View bPn() {
        return this.haM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPo() {
        if (this.aVX == null) {
            return 0;
        }
        return this.aVX.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPp() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPq() {
        if (this.gAG == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.gAG.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        View Fr = Fr();
        View bPn = bPn();
        if (UtilHelper.canUseStyleImmersiveSticky() && Fr != null && bPn != null && Fr.getLayoutParams() != null && bPn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = Fr.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            Fr.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = bPn.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            bPn.setLayoutParams(layoutParams2);
        }
    }

    public n(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.hah = null;
        this.haA = null;
        this.haE = 0;
        this.hah = frsFragment;
        this.haA = onClickListener;
        MessageManager.getInstance().registerListener(this.gJp);
        a(aVar, z);
        this.haL = new HashSet<>();
        this.haE = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.haW = hVar;
    }

    private boolean bPr() {
        return this.haW != null && this.haW.bVs();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v22, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.haO = aVar;
        View rootView = this.hah.getRootView();
        if (this.hai == null) {
            this.hai = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.hak == null) {
            this.hak = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.haj == null) {
            this.haj = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.haC == null) {
            this.haC = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.haS == null) {
            this.haS = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.haR == null) {
            this.haR = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.haw == null) {
            this.haw = new com.baidu.tieba.frs.vc.k(this.hah);
        }
        if (this.haN == null) {
            this.haN = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.haN.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.n.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        n.this.haS.setMinimumHeight(i2);
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
        if (this.hah.bPb()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.haB == null) {
            this.haB = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b bRy = aVar.bRy();
            if (bRy != null) {
                bRy.bX(this.haB);
            }
        }
        if (this.hal == null) {
            this.hal = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.hal.setOnClickListener(this.haA);
            this.mBackImageView = (ImageView) this.hal.findViewById(R.id.widget_navi_back_button);
        }
        if (this.hao == null) {
            this.hao = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.aOU().a(this.hao, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.hao.setOnClickListener(this.haA);
        }
        if (this.ham == null) {
            this.ham = new com.baidu.tieba.c.b(this.hah.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ham.getView(), (View.OnClickListener) null);
            this.gva = this.ham.bFX();
            this.gvb = this.ham.bFY();
            this.ham.getView().setOnClickListener(this.haA);
            this.ham.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.han == null) {
            this.han = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.aOU().a(this.han, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.han.setOnClickListener(this.haA);
        }
        if (this.hap == null) {
            this.hap = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.hap.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.am.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.hah.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hap.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.am.c(this.hap, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.hap, (int) R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.hah.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.hau == null) {
            this.hau = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.n.8
            int hbi = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.hbi--;
                if (this.hbi == 0) {
                    n.this.hau.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.hbi++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.hau.setItemAnimator(defaultItemAnimator);
        this.hau.setLayoutManager(new LinearLayoutManager(this.hau.getContext()) { // from class: com.baidu.tieba.frs.n.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.gJn = new com.baidu.adp.widget.ListView.k(new com.baidu.adp.widget.ListView.i());
            this.gJn.a(this.hau, 2);
        }
        this.hau.setScrollable(this.hah);
        this.hau.setFadingEdgeLength(0);
        this.hau.setOverScrollMode(2);
        this.hai.setBottomOrderView(this.hau);
        this.hau.setOnTouchListener(this.hah.dRW);
        this.hau.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.n.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (n.this.gHv != null) {
                    n.this.gHv.ct(view);
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
        if (this.ePm == null) {
            this.ePm = new PbListView(this.hah.getPageContext().getPageActivity());
            this.ePm.getView();
        }
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.ePm.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hah.getActivity(), R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hau.setOnSrollToBottomListener(this.hah);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.n.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.hah.bOU();
                if (n.this.hah != null && n.this.VZ != null) {
                    n.this.hah.bPe();
                    n.this.VZ.setExpanded(true);
                    if (n.this.gHv != null) {
                        n.this.gHv.a(n.this.gZW, n.this.eNU, false, true);
                    }
                }
            }
        });
        boolean aOW = com.baidu.tbadk.core.util.ar.aOV().aOW();
        if (this.hav == null) {
            this.hav = aVar.a(this.hah, this.hau, aOW);
        }
        if (this.haw != null) {
            this.haw.H(1, false);
        }
        if (!z) {
            if (this.gAG == null) {
                this.gAG = new NoNetworkView(this.hah.getActivity());
                this.gAG.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.haN.addView(this.gAG);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.gAG.setVisibility(8);
            } else {
                this.gAG.setVisibility(0);
            }
            this.gAG.onChangeSkinType(this.hah.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        bPB();
        if (this.haG == null) {
            this.haG = aVar.a(this.hah, this.hai);
            this.haG.b(this.hah.bPf());
        }
        if (this.haH == null) {
            this.haH = aVar.b(this.hah, this.hai);
            mx(true);
        }
        if (this.aVX == null) {
            this.aVX = rootView.findViewById(R.id.statebar_view);
        }
        if (this.haM == null) {
            this.haM = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.gHv == null) {
            this.gHv = new com.baidu.tieba.play.m(this.hah.getPageContext(), this.hau);
        }
        this.gHv.AZ(1);
        this.gHv.setUniqueId(this.hah.getUniqueId());
        this.haY = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.haI == null) {
            this.haI = new com.baidu.tieba.frs.vc.m(this.hah, this.haY);
        }
        if (this.VZ == null) {
            this.VZ = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.VZ.addOnOffsetChangedListener(this.hbd);
            this.haT = true;
            this.haU = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.VZ.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.haQ = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.haX = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.haX.setPageContext(this.hah.getPageContext());
        this.hax = (FloatingAnimationView) rootView.findViewById(R.id.redpacket_view);
        this.hax.setPageId(this.hah.getUniqueId());
        this.hay = new com.baidu.tieba.c.c(this.hah.getTbPageContext(), this.hax, 2);
        if (this.hba == null) {
            this.hba = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.hah.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.hba.setLayoutParams(layoutParams2);
            this.hba.setPadding(0, 0, this.hah.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.hba.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
        }
    }

    public void jb(boolean z) {
        if (z && this.hay != null) {
            this.hay.biK();
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (this.hay != null) {
            this.hay.a(oVar);
        }
    }

    private void bPs() {
        ViewGroup.LayoutParams layoutParams;
        this.fqi = bPr();
        if (this.haR != null && (layoutParams = this.haR.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.fqi) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + bPp(), 0, 0);
            }
            this.haR.requestLayout();
        }
    }

    public void bPt() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.haN != null) {
            bPs();
            if (this.fqi) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.aVX != null) {
                    this.aVX.setAlpha(1.0f);
                }
                if (this.haM != null) {
                    this.haM.setAlpha(1.0f);
                }
                if (this.hba != null) {
                    this.hba.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mu(boolean z) {
        if (z && this.hah != null && this.hah.bOu() != null) {
            this.hah.bOu().bVw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bPu() {
        int i;
        if (this.VZ == null) {
            return this.haU;
        }
        if (this.haU != -1) {
            return this.haU;
        }
        int childCount = this.VZ.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.VZ.getChildAt(childCount);
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
        this.haU = Math.max(0, this.VZ.getTotalScrollRange() - Math.abs(i2));
        return this.haU;
    }

    public void CR(String str) {
        if (this.haI != null) {
            this.haI.CR(str);
        }
    }

    public com.baidu.tieba.play.m bPv() {
        return this.gHv;
    }

    public com.baidu.tieba.frs.entelechy.b.c bPw() {
        return this.haH;
    }

    public void mv(boolean z) {
        if (this.haG != null) {
            this.haG.mv(z);
        }
    }

    public com.baidu.tieba.frs.vc.d bPx() {
        return this.haG;
    }

    public void M(boolean z, boolean z2) {
        if (this.cVS && this.haH != null) {
            this.haH.M(z, z2);
        }
    }

    public void mw(boolean z) {
        this.cVS = z;
        if (!this.cVS && this.haH != null) {
            this.haH.M(false, false);
        }
    }

    public void bPy() {
        if (this.cVS && this.haH != null) {
            this.haH.M(false, false);
        }
        ti(8);
        this.hao.setVisibility(8);
        this.han.setVisibility(8);
        mv(false);
        this.hau.setVisibility(8);
        this.haR.setVisibility(8);
    }

    public void bPz() {
        if (this.cVS && this.haH != null) {
            this.haH.M(true, false);
        }
        ti(0);
        bPA();
        mv(this.hah.bPh());
        this.hau.setVisibility(0);
        this.haR.setVisibility(0);
    }

    private void ti(int i) {
        if (this.ham != null) {
            this.ham.setVisibility(i);
        }
    }

    private void bPA() {
        this.hao.setVisibility(0);
        this.han.setVisibility(0);
    }

    public void mx(boolean z) {
        if (this.haH != null) {
            this.haH.mY(z);
        }
    }

    private void bPB() {
        if (this.haJ == null) {
            View rootView = this.hah.getRootView();
            this.haJ = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.haK = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.haK.setPageId(this.hah.getUniqueId());
            this.haJ.setLayerType(1, null);
            this.haK.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View bPC() {
        return this.hal;
    }

    public void g(NoNetworkView.a aVar) {
        this.gVM = aVar;
        if (this.gAG != null) {
            this.gAG.a(this.gVM);
        }
    }

    public void my(boolean z) {
        if (this.haH != null) {
            if (z) {
                M(false, true);
            } else {
                M(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hau.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.hav.a(vVar);
    }

    public void setForumName(String str) {
        this.hav.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gJp);
        if (this.gHv != null) {
            this.gHv.destroy();
        }
        if (this.haI != null) {
            this.haI.onDestory();
        }
        if (this.haX != null) {
            this.haX.setPageContext(null);
        }
        this.hav.onDestory();
        this.hau.setOnSrollToBottomListener(null);
        this.hau.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.hbe);
        if (this.gIp != null) {
            this.gIp.onDestroy();
        }
        this.haL.clear();
        if (this.haG != null) {
            this.haG.bVc();
        }
        if (this.haP != null) {
            this.haP.bRj();
        }
        if (this.hay != null) {
            this.hay.onDestroy();
        }
        if (this.haY != null) {
            this.haY.onDestroy();
        }
        if (this.haX != null) {
            this.haX.onDestroy();
        }
        if (this.haw != null) {
            this.haw.onDestroy();
        }
    }

    public boolean bPD() {
        if (this.VZ == null || this.haQ == null || !this.haQ.isSticky()) {
            return this.haG != null && this.haG.bPD();
        }
        if (this.hau != null) {
            this.hau.setSelection(0);
        }
        this.haQ.expandedAppBarLayout(this.VZ);
        return true;
    }

    public boolean bOZ() {
        if (this.haw == null) {
            return false;
        }
        return this.haw.bOZ();
    }

    public void bpV() {
        this.hau.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.hba.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.hba.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.hba.setText(str2);
            com.baidu.tbadk.core.i.aIe().setForumNameForWaterImage(str);
        }
    }

    public void bPE() {
        if (this.hav != null) {
            this.hav.notifyDataSetChanged();
        }
    }

    public void aBa() {
        if (this.hav instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.hav).aBa();
        }
    }

    private void bPF() {
        if (this.haz == null && this.hah.getPageContext() != null) {
            String[] strArr = {this.hah.getPageContext().getPageActivity().getString(R.string.take_photo), this.hah.getPageContext().getPageActivity().getString(R.string.album)};
            this.haz = new com.baidu.tbadk.core.dialog.b(this.hah.getPageContext().getPageActivity());
            this.haz.ug(this.hah.getPageContext().getPageActivity().getString(R.string.operation));
            this.haz.a(strArr, new b.a() { // from class: com.baidu.tieba.frs.n.12
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        n.this.hah.bPa();
                    } else if (i == 1 && n.this.hah.getPageContext() != null) {
                        com.baidu.tbadk.core.util.al.getAlbumImage(n.this.hah.getPageContext().getPageActivity());
                    }
                }
            });
            this.haz.d(this.hah.getPageContext());
        }
    }

    public void bPG() {
        bPF();
        if (this.haz != null) {
            this.haz.aMV();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.m> arrayList, FrsViewData frsViewData) {
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList2;
        if (frsViewData != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (com.baidu.tbadk.core.util.v.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
                p pVar = new p();
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList3 = new ArrayList<>();
                arrayList3.add(pVar);
                if (this.hah != null && this.hah.bOs() != null && this.hah.bOs().bTT() == 0) {
                    pVar.ts(this.hah.bOs().bUa());
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = switchThreadDataToThreadCardInfo;
            }
            if (com.baidu.tbadk.core.util.v.getCount(arrayList2) > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList2.size()) {
                        break;
                    }
                    com.baidu.adp.widget.ListView.m mVar = arrayList2.get(i2);
                    if (mVar instanceof bi) {
                        ((bi) mVar).dqA.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.hav.b(arrayList2, frsViewData);
            if (this.gHv != null && this.gZW != 0) {
                this.gHv.a(this.gZW, this.eNU, this.haF, true);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.hau;
    }

    public void bPH() {
        this.hav.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.y yVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hah.getPageContext(), 1);
        aVar.a(this.hau);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.hah.getForumName());
        hashMap.put("forum_id", this.hah.getForumId());
        aVar.setParams(hashMap);
        aVar.ao(yVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.haG != null) {
            this.haG.bVd();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        tj(TbadkCoreApplication.getInst().getSkinType());
        if (this.haG != null) {
            this.haG.bVe();
        }
    }

    public void release() {
        if (this.gAG != null && this.gVM != null) {
            this.gAG.b(this.gVM);
        }
    }

    public ImageView bPI() {
        return this.hao;
    }

    public ImageView bPJ() {
        return this.han;
    }

    public TextView bPK() {
        return this.hap;
    }

    public View bPL() {
        if (this.ham != null) {
            return this.ham.getView();
        }
        return null;
    }

    public void G(int i, boolean z) {
        if (this.ham != null) {
            this.ham.s(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.hah, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.hah.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.haK != null) {
            this.haK.invalidate();
        }
        if (this.hav != null) {
            this.hav.bRW();
            this.hav.notifyDataSetChanged();
        }
        com.baidu.tbadk.q.a.a(this.hah.getPageContext(), this.hai);
        if (this.gAG != null) {
            this.gAG.onChangeSkinType(this.hah.getPageContext(), i);
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_d));
            this.ePm.changeSkin(i);
        }
        if (this.hba != null) {
            this.hba.setTextColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_cont_b));
        }
        tj(i);
        if (this.haH != null) {
            this.haH.onChangeSkinType(i);
        }
        if (this.haG != null) {
            this.haG.onChangeSkinType(i);
        }
        if (this.haX != null) {
            this.haX.onChangeSkinType();
        }
        if (this.hah != null && this.hah.bOC()) {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hak, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.hak, R.color.cp_bg_line_d);
        }
    }

    private void tj(int i) {
        if (this.hah != null) {
            tk(i);
        }
    }

    private void tk(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hah.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.haB, R.color.cp_bg_line_c, i);
            if (this.ham != null) {
                this.ham.onChangeSkinType(i);
            }
            if (this.hao != null) {
                SvgManager.aOU().a(this.hao, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.han != null) {
                SvgManager.aOU().a(this.han, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.aVX, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this.haM, R.color.cp_bg_line_h);
        mz(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.fqi) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.hbb != 0) {
                    SvgManager.aOU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aOU().a(this.hao, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aOU().a(this.gva, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.aOU().a(this.han, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.hbb = 0;
                }
            } else if (z || this.hbb != 1) {
                SvgManager.aOU().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOU().a(this.hao, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOU().a(this.gva, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.aOU().a(this.han, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.hbb = 1;
            }
            bPM();
        }
    }

    private void bPM() {
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
            if (this.hba != null) {
                this.hba.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.gva != null) {
                    this.gva.setAlpha(f);
                }
                if (this.gvb != null) {
                    this.gvb.setAlpha(f);
                }
                if (this.hao != null) {
                    this.hao.setAlpha(f);
                }
                if (this.han != null) {
                    this.han.setAlpha(f);
                }
            }
            if (this.hap != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.hap.setAlpha(f2);
                this.hap.setClickable(f2 > 0.0f);
            }
            if (this.aVX != null) {
                this.aVX.setAlpha(alpha);
            }
            if (this.haM != null) {
                this.haM.setAlpha(alpha);
            }
            if (this.haB != null) {
                this.haB.setAlpha(alpha);
            }
        }
    }

    public void blz() {
        if (this.haw != null) {
            this.haw.blz();
        }
    }

    public void mA(boolean z) {
        if (this.haw != null) {
            this.haw.mA(z);
        }
    }

    public void mB(boolean z) {
        this.haD = z;
        if (this.haD) {
            this.ePm.setText(this.hah.getResources().getString(R.string.load_more));
            if (this.hau.getChildAt(this.hau.getChildCount() - 1) == this.ePm.getView()) {
                this.ePm.startLoadData();
                this.hah.blb();
                return;
            }
            this.ePm.endLoadData();
            return;
        }
        this.ePm.setText(this.hah.getResources().getString(R.string.load_more_must_after_delete));
        this.ePm.endLoadData();
    }

    public boolean bPN() {
        if (this.haD) {
            return false;
        }
        this.ePm.setText(this.hah.getResources().getString(R.string.load_more_must_after_delete));
        this.ePm.endLoadData();
        return true;
    }

    public boolean bPO() {
        return this.haq != null && this.hat.getVisibility() == 0;
    }

    public void bPP() {
        if (this.haq != null) {
            this.har.setVisibility(0);
            this.hat.setVisibility(8);
            this.has.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.hbe, 5000L);
        }
    }

    public void a(bt btVar) {
        if (this.haq == null) {
            View rootView = this.hah.getRootView();
            this.haq = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.haq.setVisibility(0);
            this.har = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.has = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.hat = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.has.setPageId(this.hah.getUniqueId());
            this.hat.setPageId(this.hah.getUniqueId());
            this.has.setDefaultBgResource(R.color.common_color_10022);
            this.has.setDefaultResource(0);
            this.hat.setDefaultBgResource(R.color.common_color_10022);
            this.hat.setDefaultResource(0);
            this.har.setOnClickListener(this.haA);
        }
        this.har.setVisibility(0);
        String aMN = btVar.aMN();
        String aMO = btVar.aMO();
        this.has.startLoad(aMN, 10, false);
        this.hat.startLoad(aMO, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.hbe, 5000L);
    }

    public void bPQ() {
        if (this.haq != null && this.har != null) {
            this.har.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.ai bPR() {
        return this.hav;
    }

    public RelativeLayout bCt() {
        return this.hai;
    }

    public View bPS() {
        return this.haC;
    }

    public void tl(int i) {
        if (this.hak != null) {
            this.hak.setVisibility(i);
        }
    }

    public void bPT() {
        if (com.baidu.tbadk.n.m.aZA().aZB()) {
            int lastVisiblePosition = this.hau.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.hau.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof r)) {
                    r rVar = (r) childAt.getTag();
                    if (rVar.hbs != null) {
                        com.baidu.tbadk.n.h perfLog = rVar.hbs.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.edD = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            rVar.hbs.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        rVar.hbs.startLogPerf();
                    }
                    if (rVar.hbr != null && (rVar.hbr instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = rVar.hbr;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.edD = true;
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

    public NavigationBar boh() {
        return this.mNavigationBar;
    }

    public void bmo() {
        this.mHasMore = true;
        this.hau.setNextPage(this.ePm);
        if (this.haE > 0) {
            this.ePm.showEmptyView(this.haE);
        }
        this.ePm.setOnClickListener(null);
        this.ePm.startLoadData();
    }

    public void bmp() {
        this.mHasMore = false;
        this.hau.setNextPage(this.ePm);
        if (this.haE > 0) {
            this.ePm.showEmptyView(this.haE);
        }
        this.ePm.setOnClickListener(null);
        this.ePm.endLoadData();
        this.ePm.setText(this.hah.getResources().getString(R.string.list_has_no_more));
    }

    public void bPU() {
        this.mHasMore = true;
        this.hau.setNextPage(this.ePm);
        this.ePm.setOnClickListener(this.haA);
        if (this.haE > 0) {
            this.ePm.showEmptyView(this.haE);
        }
        this.ePm.endLoadData();
        this.ePm.setText(this.hah.getResources().getString(R.string.list_click_load_more));
    }

    public View bPV() {
        if (this.ePm == null) {
            return null;
        }
        return this.ePm.getView();
    }

    public void tm(int i) {
        if (this.haX != null) {
            this.haX.setVisibility(i);
        }
    }

    public void tn(int i) {
        if (this.haX != null) {
            this.haX.setSelectNumber(i);
        }
    }

    public void bmq() {
        this.mHasMore = false;
        this.hau.setNextPage(null);
    }

    public boolean bPW() {
        return this.ePm.getView().getParent() != null && this.mHasMore;
    }

    public void to(int i) {
        this.haE = i;
    }

    public void tp(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.gIp == null) {
                    this.gIp = new CommonTipView(this.hah.getActivity());
                }
                this.gIp.setText(R.string.frs_login_tip);
                this.gIp.b((FrameLayout) bPS(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void mC(boolean z) {
        this.mIsBackground = z;
        if (this.gHv != null) {
            boolean z2 = (this.hah == null || this.hah.bOv() == null || this.hah.bOv().bVR() == null) ? true : this.hah.bOv().bVR().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.gHv.pL(false);
                this.gHv.cnO();
                return;
            }
            this.gHv.pL(true);
            this.gHv.a(this.gZW, this.eNU, this.haF, true);
        }
    }

    public void bK(int i, int i2) {
        if (this.gHv != null) {
            this.gHv.a(i, i2, this.haF, 1);
        }
    }

    public void bL(int i, int i2) {
        this.gZW = i;
        this.eNU = i2;
    }

    public void mD(boolean z) {
        this.haF = z;
    }

    public void tq(int i) {
        if (this.hau != null && this.hau.getChildCount() >= 0) {
            if (this.hau.getFirstVisiblePosition() > 8) {
                this.hau.scrollToPosition(8);
            }
            this.hau.smoothScrollToPosition(i);
        }
    }

    public void bPX() {
        a(this.haO, this.hah.bPb());
        if (this.hav != null) {
            this.hav.bRT();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.haP == null) {
                this.haP = new com.baidu.tieba.video.f(this.hah.getActivity(), this.hai);
            }
            this.haP.h(postWriteCallBackData);
        }
    }

    public void bPY() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.hbf && this.hah.getActivity() != null && this.hah.getPageContext() != null) {
            View view = null;
            if (this.hau != null && (headerViewsCount = this.hau.getHeaderViewsCount()) < this.hau.getChildCount()) {
                view = this.hau.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).Y(0).ae(true).af(false).ad(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.n.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        n.this.hah.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(n.this.hah.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(n.this.hah.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.n.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c km = dVar.km();
                km.setShouldCheckLocInWindow(false);
                km.show(this.hah.getActivity());
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.n.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (km != null) {
                            km.dismiss();
                        }
                    }
                }, 4000L);
                this.hbf = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.haX != null) {
            this.haX.setDeleteCallback(aVar);
        }
    }

    public void bPZ() {
        if (this.haX != null) {
            this.haX.bPZ();
        }
    }

    public void beD() {
        if (this.haX != null) {
            this.haX.beD();
        }
    }

    public void aJ(String str, int i) {
        if (this.haZ == null) {
            this.haZ = new TextView(this.hah.getActivity());
            this.haZ.setGravity(19);
            this.haZ.setPadding(com.baidu.adp.lib.util.l.getDimens(this.hah.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.hah.getActivity(), R.dimen.ds34), 0);
            this.haZ.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.hah.getActivity(), R.dimen.tbds112)));
            this.haZ.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.hah.getActivity(), R.dimen.fontsize30));
            this.haZ.setMaxLines(2);
            this.haZ.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.haZ.setTextColor(ContextCompat.getColor(this.hah.getActivity(), R.color.cp_cont_a));
        }
        this.haY.setBackgroundColor(i);
        this.haZ.setText(str);
        this.haY.a(this.hah.getActivity(), this.haZ, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.VZ != null) {
            this.VZ.setExpanded(z);
        }
    }

    public void bQa() {
        if (this.haw != null) {
            this.haw.startPullRefresh();
        }
    }

    public void wK() {
        if (bPR() != null) {
            List<com.baidu.adp.widget.ListView.m> datas = bPR().getDatas();
            if (!com.baidu.tbadk.core.util.v.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.m mVar : datas) {
                    if (mVar instanceof bi) {
                        bi biVar = (bi) mVar;
                        if (biVar.dqB != 0 && biVar.dqA != null && this.hah.bOs() != null && this.hah.bOs().bTw() != null) {
                            int[] imageWidthAndHeight = this.hah.bOs().bTw().imageWidthAndHeight(biVar.dqA);
                            biVar.dqB = imageWidthAndHeight[0];
                            biVar.dqC = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.n.5
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.bPR().notifyDataSetChanged();
                        if (!n.this.mIsBackground) {
                            n.this.gHv.a(n.this.gZW, n.this.eNU, n.this.haF, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean bQb() {
        if (this.haG == null) {
            return false;
        }
        return this.haG.bQb();
    }

    public Context getContext() {
        if (this.hah == null) {
            return null;
        }
        return this.hah.getTbPageContext().getPageActivity();
    }

    public void H(int i, boolean z) {
        if (this.haw != null) {
            this.haw.H(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.haw != null) {
            this.haw.startPullRefresh();
        }
    }

    public void bQc() {
        if (this.haw != null) {
            this.haw.bQc();
        }
    }

    public void bQd() {
        if (this.haw != null) {
            this.haw.bQd();
        }
    }

    public void a(an anVar) {
        if (this.haw != null) {
            this.haw.a(anVar);
        }
    }

    public void tr(int i) {
        if (this.haw != null) {
            this.haw.tr(i);
        }
    }
}
