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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.cg;
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
/* loaded from: classes21.dex */
public class q {
    private AppBarLayout XP;
    private NoNetworkView fFC;
    private PbListView fHm;
    private com.baidu.tieba.play.i hIT;
    private CommonTipView hJO;
    private com.baidu.adp.widget.ListView.n hKQ;
    private ImageView hwG;
    private MessageRedDotView hwH;
    private BdTypeRecyclerView icD;
    private com.baidu.tieba.frs.entelechy.a.al icE;
    private com.baidu.tieba.frs.vc.k icF;
    private View.OnClickListener icH;
    private View icI;
    private View icJ;
    private int icL;
    private com.baidu.tieba.frs.vc.d icN;
    private com.baidu.tieba.frs.entelechy.b.c icO;
    private com.baidu.tieba.frs.vc.m icP;
    private GifView icQ;
    private TbImageView icR;
    private HashSet<String> icS;
    private ObservedChangeLinearLayout icU;
    private com.baidu.tieba.frs.entelechy.b.a icV;
    private com.baidu.tieba.video.f icW;
    private AppBarLayoutStickyBehavior icX;
    private FrsHeaderViewContainer icY;
    private CollapsingToolbarLayout icZ;
    private FrsFragment icq;
    private View icu;
    private com.baidu.tieba.c.d icv;
    private ImageView icw;
    private ImageView icx;
    private TextView icy;
    private ViewStub icz;
    private com.baidu.tieba.frs.vc.h idd;
    private FrsMultiDelBottomMenuView ide;
    private FrsMoveAreaBottomMenuView idf;
    private NavigationBarCoverTip idg;
    private TextView idh;
    private TextView idi;
    private boolean ido;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private int mSkinType;
    private NoPressedRelativeLayout icr = null;
    private CoordinatorLayout ics = null;
    private View ict = null;
    private FrameLayout icA = null;
    private TbImageView icB = null;
    private TbImageView icC = null;
    private com.baidu.tbadk.core.dialog.b icG = null;
    private NoNetworkView.a hXf = null;
    private boolean icK = true;
    private boolean mHasMore = true;
    private boolean icM = false;
    private int icc = 0;
    private int fFV = 0;
    private View brO = null;
    private View icT = null;
    private boolean gki = false;
    private boolean dDL = true;
    private boolean ida = true;
    private int idb = -1;
    private int idc = -1;
    private int idj = 0;
    private int idk = 0;
    private boolean mIsBackground = false;
    private CustomMessageListener hKS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.frs.q.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (q.this.hKQ == null) {
                        q.this.hKQ = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
                    }
                    q.this.hKQ.a(q.this.icD, 2);
                } else if (q.this.hKQ != null) {
                    q.this.hKQ.rh();
                }
            }
        }
    };
    private AppBarLayout.OnOffsetChangedListener idm = new AppBarLayout.OnOffsetChangedListener() { // from class: com.baidu.tieba.frs.q.6
        @Override // android.support.design.widget.AppBarLayout.OnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            q.this.a(appBarLayout, i);
            if (q.this.icF != null) {
                q.this.icF.setInterceptScrollDown(i == 0);
            }
            if (q.this.idc != i && Math.abs(i) >= 0 && q.this.cqh() != -1) {
                if (Math.abs(i) >= q.this.cqh()) {
                    if (q.this.ida) {
                        q.this.ida = false;
                        q.this.or(q.this.ida);
                    }
                } else if (!q.this.ida) {
                    q.this.ida = true;
                    q.this.or(q.this.ida);
                }
                int cqd = q.this.cqd() + q.this.cqc() + q.this.getNavigationBarHeight();
                int totalScrollRange = appBarLayout.getTotalScrollRange() - cqd;
                int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i);
                if (totalScrollRange > 0) {
                    float abs = Math.abs(i * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && q.this.idc - i < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        q.this.xx(Math.abs(cqd - totalScrollRange2));
                        if (q.this.icT != null) {
                            q.this.icT.setVisibility(0);
                        }
                    } else if (q.this.icT != null) {
                        if (q.this.cqb() != UtilHelper.getStatusBarHeight()) {
                            q.this.xx(0);
                        }
                        q.this.icT.setVisibility(8);
                    }
                    if (q.this.mNavigationBar != null) {
                        if (q.this.gki) {
                            q.this.mNavigationBar.getBarBgView().setAlpha(abs);
                            q.this.ow(false);
                        } else if (q.this.idi != null) {
                            q.this.idi.setAlpha(abs);
                        }
                    }
                    q.this.idc = i;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, Integer.valueOf(i)));
                } else {
                    return;
                }
            }
            if (q.this.icF != null) {
                int cwZ = q.this.icF.cwZ();
                int cxa = cwZ - q.this.icF.cxa();
                if (cwZ > 0 && Math.abs(i) >= cxa) {
                    q.this.icF.dismissLoading();
                }
            }
        }
    };
    private Runnable idn = new Runnable() { // from class: com.baidu.tieba.frs.q.13
        @Override // java.lang.Runnable
        public void run() {
            if (q.this.icz != null) {
                q.this.icA.setVisibility(0);
                q.this.icC.setVisibility(0);
                q.this.icB.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppBarLayout appBarLayout, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.icq != null && appBarLayout != null && this.icq.cpd() != null && this.icq.getPageContext() != null) {
            int cqc = cqc() + getNavigationBarHeight() + cqd();
            int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i);
            FrsTabViewController cpd = this.icq.cpd();
            if (i == 0) {
                UtilHelper.changeStatusBarIconAndTextColor(true, this.icq.getPageContext().getPageActivity());
            } else {
                UtilHelper.changeStatusBarIconAndTextColor(false, this.icq.getPageContext().getPageActivity());
            }
            ViewGroup.LayoutParams layoutParams = this.ict.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            boolean z = this.icq != null && this.icq.cpk();
            if (totalScrollRange <= 0) {
                if (this.idk != 2) {
                    cpd.zv(2);
                }
                this.idk = 2;
                marginLayoutParams.topMargin = 0;
            } else if (totalScrollRange > 0 && totalScrollRange <= cqc) {
                if (this.idk != 1) {
                    cpd.zv(1);
                }
                this.idk = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                if (this.idk != 0) {
                    cpd.zv(0);
                }
                this.idk = 0;
                if (z) {
                    marginLayoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.icq.getActivity(), R.dimen.tbds_30);
                } else {
                    marginLayoutParams.topMargin = 0;
                }
            }
            if (z) {
                this.ict.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public ObservedChangeLinearLayout cpZ() {
        return this.icU;
    }

    public View OW() {
        return this.brO;
    }

    public View cqa() {
        return this.icT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqb() {
        if (this.brO == null) {
            return 0;
        }
        return this.brO.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqc() {
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return UtilHelper.getStatusBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqd() {
        if (this.fFC == null || com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return 0;
        }
        return this.fFC.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xx(int i) {
        View OW = OW();
        View cqa = cqa();
        if (UtilHelper.canUseStyleImmersiveSticky() && OW != null && cqa != null && OW.getLayoutParams() != null && cqa.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = OW.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight() - i;
            if (layoutParams.height < 0) {
                layoutParams.height = 0;
            }
            OW.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cqa.getLayoutParams();
            layoutParams2.height = i;
            if (layoutParams2.height > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            cqa.setLayoutParams(layoutParams2);
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z, com.baidu.tieba.frs.vc.h hVar) {
        this.icq = null;
        this.icH = null;
        this.icL = 0;
        this.icq = frsFragment;
        this.icH = onClickListener;
        MessageManager.getInstance().registerListener(this.hKS);
        a(aVar, z);
        this.icS = new HashSet<>();
        this.icL = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        this.idd = hVar;
    }

    private boolean cqe() {
        return this.idd != null && this.idd.cwK();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.icV = aVar;
        View rootView = this.icq.getRootView();
        if (this.icr == null) {
            this.icr = (NoPressedRelativeLayout) rootView.findViewById(R.id.frs);
        }
        if (this.ict == null) {
            this.ict = rootView.findViewById(R.id.frs_content_container);
        }
        if (this.ics == null) {
            this.ics = (CoordinatorLayout) rootView.findViewById(R.id.frs_nested_scroll_layout);
        }
        if (this.icJ == null) {
            this.icJ = rootView.findViewById(R.id.frs_list_content);
        }
        if (this.icZ == null) {
            this.icZ = (CollapsingToolbarLayout) rootView.findViewById(R.id.frs_collapse_layout);
        }
        if (this.icY == null) {
            this.icY = (FrsHeaderViewContainer) rootView.findViewById(R.id.header_view_container);
        }
        if (this.icF == null) {
            this.icF = new com.baidu.tieba.frs.vc.k(this.icq);
        }
        if (this.icU == null) {
            this.icU = (ObservedChangeLinearLayout) rootView.findViewById(R.id.navigation_bar_wrapperLayout);
            this.icU.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.q.7
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4 && i4 > 0) {
                        q.this.icZ.setMinimumHeight(i2);
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
        if (this.icq.cpM()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.icI == null) {
            this.icI = rootView.findViewById(R.id.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b csB = aVar.csB();
            if (csB != null) {
                csB.cp(this.icI);
            }
        }
        if (this.icu == null) {
            this.icu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.icu.setOnClickListener(this.icH);
            this.mBackImageView = (ImageView) this.icu.findViewById(R.id.widget_navi_back_button);
        }
        if (this.icx == null) {
            this.icx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_search_layout, (View.OnClickListener) null);
            SvgManager.bkl().a(this.icx, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.icx.setOnClickListener(this.icH);
        }
        if (this.icv == null) {
            this.icv = new com.baidu.tieba.c.d(this.icq.getPageContext().getPageActivity());
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.icv.getView(), (View.OnClickListener) null);
            this.hwG = this.icv.cgp();
            this.hwH = this.icv.cgq();
            this.icv.getView().setOnClickListener(this.icH);
            this.icv.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, false);
        }
        if (this.icw == null) {
            this.icw = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.frs_topbar_share_layout, (View.OnClickListener) null);
            SvgManager.bkl().a(this.icw, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.icw.setOnClickListener(this.icH);
        }
        if (this.icy == null) {
            this.icy = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.frs_private_status, (View.OnClickListener) null);
            this.icy.setVisibility(8);
            Drawable drawable = com.baidu.tbadk.core.util.ap.getDrawable(R.drawable.icon_arrow12_white);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.icq.getActivity(), R.dimen.tbds31);
            drawable.setBounds(0, 0, dimens, dimens);
            this.icy.setCompoundDrawables(null, null, drawable, null);
            com.baidu.tbadk.core.util.ap.f(this.icy, R.drawable.bg_frs_private_status_n, R.drawable.bg_frs_private_status_s);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.icy, R.color.cp_cont_a);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.icq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
        }
        if (this.icD == null) {
            this.icD = (BdTypeRecyclerView) rootView.findViewById(R.id.frs_lv_thread);
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator() { // from class: com.baidu.tieba.frs.q.8
            int idr = 0;

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
                super.onRemoveFinished(viewHolder);
                this.idr--;
                if (this.idr == 0) {
                    q.this.icD.getAdapter().notifyDataSetChanged();
                }
            }

            @Override // android.support.v7.widget.SimpleItemAnimator
            public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
                this.idr++;
                super.onRemoveStarting(viewHolder);
            }
        };
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.icD.setItemAnimator(defaultItemAnimator);
        this.icD.setLayoutManager(new LinearLayoutManager(this.icD.getContext()) { // from class: com.baidu.tieba.frs.q.9
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable th) {
                }
            }
        });
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hKQ = new com.baidu.adp.widget.ListView.n(new com.baidu.adp.widget.ListView.l());
            this.hKQ.a(this.icD, 2);
        }
        this.icD.setScrollable(this.icq);
        this.icD.setFadingEdgeLength(0);
        this.icD.setOverScrollMode(2);
        this.icr.setBottomOrderView(this.icD);
        this.icD.setOnTouchListener(this.icq.eYy);
        this.icD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.q.10
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (q.this.hIT != null) {
                    q.this.hIT.cN(view);
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
        if (this.fHm == null) {
            this.fHm = new PbListView(this.icq.getPageContext().getPageActivity());
            this.fHm.getView();
        }
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
        this.fHm.setHeight(com.baidu.adp.lib.util.l.getDimens(this.icq.getActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.icD.setOnSrollToBottomListener(this.icq);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.q.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                q.this.icq.cpF();
                if (q.this.icq != null && q.this.XP != null) {
                    q.this.icq.cpP();
                    q.this.XP.setExpanded(true);
                    if (q.this.hIT != null) {
                        q.this.hIT.a(q.this.icc, q.this.fFV, false, true);
                    }
                }
            }
        });
        boolean bkn = com.baidu.tbadk.core.util.au.bkm().bkn();
        if (this.icE == null) {
            this.icE = aVar.a(this.icq, this.icD, bkn);
        }
        if (this.icF != null) {
            this.icF.O(1, false);
        }
        if (!z) {
            if (this.fFC == null) {
                this.fFC = new NoNetworkView(this.icq.getActivity());
                this.fFC.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.icU.addView(this.fFC);
            }
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                this.fFC.setVisibility(8);
            } else {
                this.fFC.setVisibility(0);
            }
            this.fFC.onChangeSkinType(this.icq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        cqo();
        if (this.icN == null) {
            this.icN = aVar.a(this.icq, this.icr);
            this.icN.b(this.icq.cpQ());
        }
        if (this.icO == null) {
            this.icO = aVar.b(this.icq, this.icr);
            ou(true);
        }
        if (this.brO == null) {
            this.brO = rootView.findViewById(R.id.statebar_view);
        }
        if (this.icT == null) {
            this.icT = rootView.findViewById(R.id.statebar_view_holder);
        }
        if (this.hIT == null) {
            this.hIT = new com.baidu.tieba.play.i(this.icq.getPageContext(), this.icD);
        }
        this.hIT.Gi(1);
        this.hIT.setUniqueId(this.icq.getUniqueId());
        this.idg = (NavigationBarCoverTip) rootView.findViewById(R.id.navigation_cover_tip);
        if (this.icP == null) {
            this.icP = new com.baidu.tieba.frs.vc.m(this.icq, this.idg);
        }
        if (this.XP == null) {
            this.XP = (AppBarLayout) rootView.findViewById(R.id.frs_app_bar_layout);
            this.XP.addOnOffsetChangedListener(this.idm);
            this.ida = true;
            this.idb = -1;
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.XP.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.icX = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
        this.ide = (FrsMultiDelBottomMenuView) rootView.findViewById(R.id.frs_multi_delete_menu_view);
        this.ide.setPageContext(this.icq.getPageContext());
        this.idf = (FrsMoveAreaBottomMenuView) rootView.findViewById(R.id.frs_move_area_menu_view);
        this.idf.setPageContext(this.icq.getPageContext());
        if (this.idi == null) {
            this.idi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.icq.getResources().getDimension(R.dimen.ds20);
            layoutParams2.setMargins(0, dimension, dimension, dimension);
            this.idi.setLayoutParams(layoutParams2);
            this.idi.setPadding(0, 0, this.icq.getResources().getDimensionPixelSize(R.dimen.ds20), 0);
            this.idi.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
    }

    public void bL(boolean z) {
        if (z) {
        }
    }

    private void cqf() {
        ViewGroup.LayoutParams layoutParams;
        this.gki = cqe();
        if (this.icY != null && (layoutParams = this.icY.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            if (this.gki) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds88) + cqc(), 0, 0);
            }
            this.icY.requestLayout();
        }
    }

    public void cqg() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.icU != null) {
            cqf();
            if (this.gki) {
                this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                this.mNavigationBar.hideBottomLine();
            } else {
                if (this.brO != null) {
                    this.brO.setAlpha(1.0f);
                }
                if (this.icT != null) {
                    this.icT.setAlpha(1.0f);
                }
                if (this.idi != null) {
                    this.idi.setAlpha(0.0f);
                }
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.showBottomLine();
            }
            onChangeSkinType(this.mSkinType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void or(boolean z) {
        if (z && this.icq != null && this.icq.cpc() != null) {
            this.icq.cpc().cwP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqh() {
        int i;
        if (this.XP == null) {
            return this.idb;
        }
        if (this.idb != -1) {
            return this.idb;
        }
        int childCount = this.XP.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = this.XP.getChildAt(childCount);
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
        this.idb = Math.max(0, this.XP.getTotalScrollRange() - Math.abs(i2));
        return this.idb;
    }

    public void IO(String str) {
        if (this.icP != null) {
            this.icP.IO(str);
        }
    }

    public com.baidu.tieba.play.i cqi() {
        return this.hIT;
    }

    public com.baidu.tieba.frs.entelechy.b.c cqj() {
        return this.icO;
    }

    public void os(boolean z) {
        if (this.icN != null) {
            if (KuangFloatingFrsCopyLinkViewController.getInstance().isFloatCopyViewShow()) {
                this.icN.os(false);
            } else {
                this.icN.os(z);
            }
        }
    }

    public com.baidu.tieba.frs.vc.d cqk() {
        return this.icN;
    }

    public void W(boolean z, boolean z2) {
        if (this.dDL && this.icO != null) {
            this.icO.W(z, z2);
        }
    }

    public void ot(boolean z) {
        this.dDL = z;
        if (!this.dDL && this.icO != null) {
            this.icO.W(false, false);
        }
    }

    public void cql() {
        if (this.dDL && this.icO != null) {
            this.icO.W(false, false);
        }
        xy(8);
        this.icx.setVisibility(8);
        this.icw.setVisibility(8);
        os(false);
        this.icD.setVisibility(8);
        this.icY.setVisibility(8);
    }

    public void cqm() {
        if (this.dDL && this.icO != null) {
            this.icO.W(true, false);
        }
        xy(0);
        cqn();
        os(this.icq.cpS());
        this.icD.setVisibility(0);
        this.icY.setVisibility(0);
    }

    private void xy(int i) {
        if (this.icv != null) {
            this.icv.setVisibility(i);
        }
    }

    private void cqn() {
        this.icx.setVisibility(0);
        this.icw.setVisibility(0);
    }

    public void ou(boolean z) {
        if (this.icO != null) {
            this.icO.oW(z);
        }
    }

    private void cqo() {
        if (this.icQ == null) {
            View rootView = this.icq.getRootView();
            this.icQ = (GifView) rootView.findViewById(R.id.gif_real_time);
            this.icR = (TbImageView) rootView.findViewById(R.id.tbimg_real_time);
            this.icR.setPageId(this.icq.getUniqueId());
            this.icQ.setLayerType(1, null);
            this.icR.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View cqp() {
        return this.icu;
    }

    public void g(NoNetworkView.a aVar) {
        this.hXf = aVar;
        if (this.fFC != null) {
            this.fFC.a(this.hXf);
        }
    }

    public void ov(boolean z) {
        if (this.icO != null) {
            if (z) {
                W(false, true);
            } else {
                W(false, false);
            }
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.icD.addOnScrollListener(onScrollListener);
    }

    public void a(com.baidu.adp.widget.ListView.ab abVar) {
        this.icE.a(abVar);
    }

    public void setForumName(String str) {
        this.icE.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hKS);
        if (this.hIT != null) {
            this.hIT.destroy();
        }
        if (this.icP != null) {
            this.icP.onDestory();
        }
        if (this.ide != null) {
            this.ide.setPageContext(null);
        }
        if (this.idf != null) {
            this.idf.setPageContext(null);
        }
        this.icE.onDestory();
        this.icD.setOnSrollToBottomListener(null);
        this.icD.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.idn);
        if (this.hJO != null) {
            this.hJO.onDestroy();
        }
        this.icS.clear();
        if (this.icN != null) {
            this.icN.cwu();
        }
        if (this.icW != null) {
            this.icW.csi();
        }
        if (this.idg != null) {
            this.idg.onDestroy();
        }
        if (this.ide != null) {
            this.ide.onDestroy();
        }
        if (this.icF != null) {
            this.icF.onDestroy();
        }
    }

    public boolean cqq() {
        if (this.XP == null || this.icX == null || !this.icX.isSticky()) {
            return this.icN != null && this.icN.cqq();
        }
        if (this.icD != null) {
            this.icD.setSelection(0);
        }
        this.icX.expandedAppBarLayout(this.XP);
        return true;
    }

    public boolean cpK() {
        if (this.icF == null) {
            return false;
        }
        return this.icF.cpK();
    }

    public void bMD() {
        this.icD.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.idi.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.idi.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.idi.setText(str2);
            com.baidu.tbadk.core.k.bcG().setForumNameForWaterImage(str);
        }
    }

    public void cqr() {
        if (this.icE != null) {
            this.icE.notifyDataSetChanged();
        }
    }

    public void aTp() {
        if (this.icE instanceof com.baidu.tieba.frs.entelechy.a.s) {
            ((com.baidu.tieba.frs.entelechy.a.s) this.icE).aTp();
        }
    }

    private void cqs() {
        if (this.icG == null && this.icq.getPageContext() != null) {
            String[] strArr = {this.icq.getPageContext().getPageActivity().getString(R.string.take_photo), this.icq.getPageContext().getPageActivity().getString(R.string.album)};
            this.icG = new com.baidu.tbadk.core.dialog.b(this.icq.getPageContext().getPageActivity());
            this.icG.zW(this.icq.getPageContext().getPageActivity().getString(R.string.operation));
            this.icG.a(strArr, new b.InterfaceC0533b() { // from class: com.baidu.tieba.frs.q.12
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        q.this.icq.cpL();
                    } else if (i == 1 && q.this.icq.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ao.getAlbumImage(q.this.icq.getPageContext().getPageActivity());
                    }
                }
            });
            this.icG.d(this.icq.getPageContext());
        }
    }

    public void cqt() {
        cqs();
        if (this.icG != null) {
            this.icG.bic();
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
                if (this.icq != null && this.icq.cpa() != null && this.icq.cpa().cvf() == 0) {
                    sVar.xK(this.icq.cpa().cvm());
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
                    if (qVar instanceof bv) {
                        ((bv) qVar).dXg.setSmartFrsPosition(i2);
                    }
                    i = i2 + 1;
                }
            }
            this.icE.b(arrayList2, frsViewData);
            if (this.hIT != null && this.icc != 0) {
                this.hIT.a(this.icc, this.fFV, this.icM, true);
            }
            if (this.icq != null) {
                this.icq.cpV();
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.icD;
    }

    public void cqu() {
        this.icE.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.ad adVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.icq.getPageContext(), 1);
        aVar.a(this.icD);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.icq.getForumName());
        hashMap.put("forum_id", this.icq.getForumId());
        aVar.setParams(hashMap);
        aVar.ay(adVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.icN != null) {
            this.icN.cwv();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        xz(TbadkCoreApplication.getInst().getSkinType());
        if (this.icN != null) {
            this.icN.cww();
        }
    }

    public void release() {
        if (this.fFC != null && this.hXf != null) {
            this.fFC.b(this.hXf);
        }
    }

    public ImageView cqv() {
        return this.icx;
    }

    public ImageView cqw() {
        return this.icw;
    }

    public TextView cqx() {
        return this.icy;
    }

    public View cqy() {
        if (this.icv != null) {
            return this.icv.getView();
        }
        return null;
    }

    public void N(int i, boolean z) {
        if (this.icv != null) {
            this.icv.x(z, i);
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.icq, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.icq.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.icR != null) {
            this.icR.invalidate();
        }
        if (this.icE != null) {
            this.icE.cta();
            this.icE.notifyDataSetChanged();
        }
        com.baidu.tbadk.r.a.a(this.icq.getPageContext(), this.icr);
        if (this.fFC != null) {
            this.fFC.onChangeSkinType(this.icq.getPageContext(), i);
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_d));
            this.fHm.changeSkin(i);
        }
        if (this.idi != null) {
            this.idi.setTextColor(com.baidu.tbadk.core.util.ap.getColor(R.color.cp_cont_b));
        }
        xz(i);
        if (this.icO != null) {
            this.icO.onChangeSkinType(i);
        }
        if (this.icN != null) {
            this.icN.onChangeSkinType(i);
        }
        if (this.ide != null) {
            this.ide.onChangeSkinType();
        }
        if (this.idf != null) {
            this.idf.onChangeSkinType();
        }
        if (this.icq != null && this.icq.cpk()) {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ict, R.color.transparent);
        } else {
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ict, R.color.cp_bg_line_d);
        }
    }

    private void xz(int i) {
        if (this.icq != null) {
            xA(i);
        }
    }

    private void xA(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.icq.getPageContext(), i);
            if (this.mNavigationBar.getBackground() != null && this.mNavigationBar.getBackground().mutate() != null) {
                this.mNavigationBar.getBackground().mutate().setAlpha(0);
            }
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.mNavigationBar.getBottomLine(), R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.icI, R.color.cp_bg_line_c, i);
            if (this.icv != null) {
                this.icv.onChangeSkinType(i);
            }
            if (this.icx != null) {
                SvgManager.bkl().a(this.icx, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.icw != null) {
                SvgManager.bkl().a(this.icw, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.brO, R.color.cp_bg_line_h);
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.icT, R.color.cp_bg_line_h);
        ow(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ow(boolean z) {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null && this.gki) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (z || this.idj != 0) {
                    SvgManager.bkl().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bkl().a(this.icx, R.drawable.icon_pure_topbar_search44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bkl().a(this.hwG, R.drawable.icon_pure_topbar_information44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    SvgManager.bkl().a(this.icw, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                    this.idj = 0;
                }
            } else if (z || this.idj != 1) {
                SvgManager.bkl().a(this.mBackImageView, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bkl().a(this.icx, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bkl().a(this.hwG, R.drawable.icon_pure_topbar_information44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.bkl().a(this.icw, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.idj = 1;
            }
            cqz();
        }
    }

    private void cqz() {
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
            if (this.idi != null) {
                this.idi.setAlpha(alpha);
            }
            if (f >= 0.0f && f <= 1.0f) {
                if (this.mBackImageView != null) {
                    this.mBackImageView.setAlpha(f);
                }
                if (this.hwG != null) {
                    this.hwG.setAlpha(f);
                }
                if (this.hwH != null) {
                    this.hwH.setAlpha(f);
                }
                if (this.icx != null) {
                    this.icx.setAlpha(f);
                }
                if (this.icw != null) {
                    this.icw.setAlpha(f);
                }
            }
            if (this.icy != null) {
                float f2 = 1.0f - (alpha * 2.0f);
                this.icy.setAlpha(f2);
                this.icy.setClickable(f2 > 0.0f);
            }
            if (this.brO != null) {
                this.brO.setAlpha(alpha);
            }
            if (this.icT != null) {
                this.icT.setAlpha(alpha);
            }
            if (this.icI != null) {
                this.icI.setAlpha(alpha);
            }
        }
    }

    public void bHu() {
        if (this.icF != null) {
            this.icF.bHu();
        }
    }

    public void ox(boolean z) {
        if (this.icF != null) {
            this.icF.ox(z);
        }
    }

    public void oy(boolean z) {
        this.icK = z;
        if (this.icK) {
            this.fHm.setText(this.icq.getResources().getString(R.string.load_more));
            if (this.icD.getChildAt(this.icD.getChildCount() - 1) == this.fHm.getView()) {
                this.fHm.startLoadData();
                this.icq.bGU();
                return;
            }
            this.fHm.endLoadData();
            return;
        }
        this.fHm.setText(this.icq.getResources().getString(R.string.load_more_must_after_delete));
        this.fHm.endLoadData();
    }

    public boolean cqA() {
        if (this.icK) {
            return false;
        }
        this.fHm.setText(this.icq.getResources().getString(R.string.load_more_must_after_delete));
        this.fHm.endLoadData();
        return true;
    }

    public boolean cqB() {
        return this.icz != null && this.icC.getVisibility() == 0;
    }

    public void cqC() {
        if (this.icz != null) {
            this.icA.setVisibility(0);
            this.icC.setVisibility(8);
            this.icB.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.idn, 5000L);
        }
    }

    public void a(cg cgVar) {
        if (this.icz == null) {
            View rootView = this.icq.getRootView();
            this.icz = (ViewStub) rootView.findViewById(R.id.yule_game_egg_view_stub);
            this.icz.setVisibility(0);
            this.icA = (FrameLayout) rootView.findViewById(R.id.game_activity_egg_layout);
            this.icB = (TbImageView) rootView.findViewById(R.id.game_activity_egg);
            this.icC = (TbImageView) rootView.findViewById(R.id.game_activity_egg_s);
            this.icB.setPageId(this.icq.getUniqueId());
            this.icC.setPageId(this.icq.getUniqueId());
            this.icB.setDefaultBgResource(R.color.common_color_10022);
            this.icB.setDefaultResource(0);
            this.icC.setDefaultBgResource(R.color.common_color_10022);
            this.icC.setDefaultResource(0);
            this.icA.setOnClickListener(this.icH);
        }
        this.icA.setVisibility(0);
        String bhP = cgVar.bhP();
        String bhQ = cgVar.bhQ();
        this.icB.startLoad(bhP, 10, false);
        this.icC.startLoad(bhQ, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.idn, 5000L);
    }

    public void cqD() {
        if (this.icz != null && this.icA != null) {
            this.icA.setVisibility(8);
        }
    }

    public com.baidu.tieba.frs.entelechy.a.al cqE() {
        return this.icE;
    }

    public RelativeLayout caY() {
        return this.icr;
    }

    public View cqF() {
        return this.icJ;
    }

    public void xB(int i) {
        if (this.ict != null) {
            this.ict.setVisibility(i);
        }
    }

    public void cqG() {
        if (com.baidu.tbadk.n.m.bvs().bvt()) {
            int lastVisiblePosition = this.icD.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.icD.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof u)) {
                    u uVar = (u) childAt.getTag();
                    if (uVar.idE != null) {
                        com.baidu.tbadk.n.h perfLog = uVar.idE.getPerfLog();
                        perfLog.setSubType(1000);
                        perfLog.eUD = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            uVar.idE.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        uVar.idE.startLogPerf();
                    }
                    if (uVar.idD != null && (uVar.idD instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = uVar.idD;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.n.h perfLog2 = tbImageView.getPerfLog();
                                perfLog2.setSubType(1000);
                                perfLog2.eUD = true;
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

    public NavigationBar bKS() {
        return this.mNavigationBar;
    }

    public void bIi() {
        this.mHasMore = true;
        this.icD.setNextPage(this.fHm);
        if (this.icL > 0) {
            this.fHm.showEmptyView(this.icL);
        }
        this.fHm.setOnClickListener(null);
        this.fHm.startLoadData();
    }

    public void bIj() {
        this.mHasMore = false;
        this.icD.setNextPage(this.fHm);
        if (this.icL > 0) {
            this.fHm.showEmptyView(this.icL);
        }
        this.fHm.setOnClickListener(null);
        this.fHm.endLoadData();
        this.fHm.setText(this.icq.getResources().getString(R.string.list_has_no_more));
    }

    public void cqH() {
        this.mHasMore = true;
        this.icD.setNextPage(this.fHm);
        this.fHm.setOnClickListener(this.icH);
        if (this.icL > 0) {
            this.fHm.showEmptyView(this.icL);
        }
        this.fHm.endLoadData();
        this.fHm.setText(this.icq.getResources().getString(R.string.list_click_load_more));
    }

    public View cqI() {
        if (this.fHm == null) {
            return null;
        }
        return this.fHm.getView();
    }

    public void xC(int i) {
        if (this.ide != null) {
            this.ide.setVisibility(i);
        }
    }

    public void xD(int i) {
        if (this.ide != null) {
            this.ide.setSelectNumber(i);
        }
    }

    public void xE(int i) {
        if (this.idf != null) {
            this.idf.setVisibility(i);
        }
    }

    public void xF(int i) {
        if (this.idf != null) {
            this.idf.setMoveNumber(i);
        }
    }

    public boolean cqJ() {
        return this.idf != null && this.idf.cyb();
    }

    public void cqK() {
        if (this.idf != null) {
            this.idf.cyc();
        }
    }

    public void bIk() {
        this.mHasMore = false;
        this.icD.setNextPage(null);
    }

    public boolean cqL() {
        return this.fHm.getView().getParent() != null && this.mHasMore;
    }

    public void xG(int i) {
        this.icL = i;
    }

    public void xH(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true)) {
                if (this.hJO == null) {
                    this.hJO = new CommonTipView(this.icq.getActivity());
                }
                this.hJO.setText(R.string.frs_login_tip);
                this.hJO.b((FrameLayout) cqF(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, false);
            }
        }
    }

    public void oz(boolean z) {
        this.mIsBackground = z;
        if (this.hIT != null) {
            boolean z2 = (this.icq == null || this.icq.cpd() == null || this.icq.cpd().cxn() == null) ? true : this.icq.cpd().cxn().fragment instanceof FrsAllThreadFragment;
            if (z || !z2) {
                this.hIT.rP(false);
                this.hIT.cQJ();
                return;
            }
            this.hIT.rP(true);
            this.hIT.a(this.icc, this.fFV, this.icM, true);
        }
    }

    public void cj(int i, int i2) {
        if (this.hIT != null) {
            this.hIT.a(i, i2, this.icM, 1);
        }
    }

    public void ck(int i, int i2) {
        this.icc = i;
        this.fFV = i2;
    }

    public void oA(boolean z) {
        this.icM = z;
    }

    public void xI(int i) {
        if (this.icD != null && this.icD.getChildCount() >= 0) {
            if (this.icD.getFirstVisiblePosition() > 8) {
                this.icD.scrollToPosition(8);
            }
            this.icD.smoothScrollToPosition(i);
        }
    }

    public void cqM() {
        a(this.icV, this.icq.cpM());
        if (this.icE != null) {
            this.icE.csX();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(this.icq.getTbPageContext(), postWriteCallBackData);
                return;
            }
            if (this.icW == null) {
                this.icW = new com.baidu.tieba.video.f(this.icq.getActivity(), this.icr);
            }
            this.icW.j(postWriteCallBackData);
        }
    }

    public void cqN() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 0L) == 0 && !this.ido && this.icq.getActivity() != null && this.icq.getPageContext() != null) {
            View view = null;
            if (this.icD != null && (headerViewsCount = this.icD.getHeaderViewsCount()) < this.icD.getChildCount()) {
                view = this.icD.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.q.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(R.string.frs_video_activity_guide_tip);
                        q.this.icq.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return com.baidu.adp.lib.util.l.getDimens(q.this.icq.getActivity(), R.dimen.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.getDimens(q.this.icq.getActivity(), R.dimen.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.q.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.FRS_VIDEO_ACTIVITY_GUIDE, 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mh = dVar.mh();
                mh.setShouldCheckLocInWindow(false);
                mh.show(this.icq.getActivity());
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mh != null) {
                            mh.dismiss();
                        }
                    }
                }, 4000L);
                this.ido = true;
            }
        }
    }

    public void b(d.a aVar) {
        if (this.ide != null) {
            this.ide.setDeleteCallback(aVar);
        }
    }

    public void cqO() {
        if (this.ide != null) {
            this.ide.cqO();
        }
    }

    public void bBs() {
        if (this.ide != null) {
            this.ide.bBs();
        }
    }

    public void aL(String str, int i) {
        if (this.idh == null) {
            this.idh = new TextView(this.icq.getActivity());
            this.idh.setGravity(19);
            this.idh.setPadding(com.baidu.adp.lib.util.l.getDimens(this.icq.getActivity(), R.dimen.ds34), 0, com.baidu.adp.lib.util.l.getDimens(this.icq.getActivity(), R.dimen.ds34), 0);
            this.idh.setLayoutParams(new ViewGroup.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.icq.getActivity(), R.dimen.tbds112)));
            this.idh.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(this.icq.getActivity(), R.dimen.fontsize30));
            this.idh.setMaxLines(2);
            this.idh.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.idh.setTextColor(ContextCompat.getColor(this.icq.getActivity(), R.color.cp_cont_a));
        }
        this.idg.setBackgroundColor(i);
        this.idh.setText(str);
        this.idg.a(this.icq.getActivity(), this.idh, 5000);
    }

    public void setExpanded(boolean z) {
        if (this.XP != null) {
            this.XP.setExpanded(z);
        }
    }

    public void cqP() {
        if (this.icF != null) {
            this.icF.startPullRefresh();
        }
    }

    public void EW() {
        if (cqE() != null) {
            List<com.baidu.adp.widget.ListView.q> datas = cqE().getDatas();
            if (!com.baidu.tbadk.core.util.y.isEmpty(datas)) {
                for (com.baidu.adp.widget.ListView.q qVar : datas) {
                    if (qVar instanceof bv) {
                        bv bvVar = (bv) qVar;
                        if (bvVar.edd != 0 && bvVar.dXg != null && this.icq.cpa() != null && this.icq.cpa().cuI() != null) {
                            int[] imageWidthAndHeight = bvVar.dXg.getImageWidthAndHeight();
                            bvVar.edd = imageWidthAndHeight[0];
                            bvVar.ede = imageWidthAndHeight[1];
                        }
                    }
                }
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.q.5
                    @Override // java.lang.Runnable
                    public void run() {
                        q.this.cqE().notifyDataSetChanged();
                        if (!q.this.mIsBackground) {
                            q.this.hIT.a(q.this.icc, q.this.fFV, q.this.icM, true);
                        }
                    }
                }, 500L);
            }
        }
    }

    public boolean cqQ() {
        if (this.icN == null) {
            return false;
        }
        return this.icN.cqQ();
    }

    public Context getContext() {
        if (this.icq == null) {
            return null;
        }
        return this.icq.getTbPageContext().getPageActivity();
    }

    public void O(int i, boolean z) {
        if (this.icF != null) {
            this.icF.O(i, z);
        }
    }

    public void startPullRefresh() {
        if (this.icF != null) {
            this.icF.startPullRefresh();
        }
    }

    public void cqR() {
        if (this.icF != null) {
            this.icF.cqR();
        }
    }

    public void cqS() {
        if (this.icF != null) {
            this.icF.cqS();
        }
    }

    public void a(au auVar) {
        if (this.icF != null) {
            this.icF.a(auVar);
        }
    }

    public void xJ(int i) {
        if (this.icF != null) {
            this.icF.xJ(i);
        }
    }

    public com.baidu.tieba.frs.vc.k cqT() {
        return this.icF;
    }
}
