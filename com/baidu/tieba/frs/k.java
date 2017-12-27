package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
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
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class k {
    private AppBarLayout awQ;
    private PbListView bYK;
    private NoNetworkView dhH;
    private CommonTipView dje;
    private i dxW;
    private com.baidu.tieba.video.e dyB;
    private AppBarLayoutStickyBehavior dyC;
    private FrsHeaderViewContainer dyD;
    private CollapsingToolbarLayout dyE;
    private boolean dyG;
    private View dya;
    private ImageView dyb;
    private ViewStub dyc;
    private u dyh;
    private BdSwipeRefreshLayout dyi;
    private View.OnClickListener dyk;
    private View dyl;
    private View dym;
    private int dyn;
    private View dyp;
    private com.baidu.tieba.frs.entelechy.b.d dyq;
    private com.baidu.tieba.frs.entelechy.b.c dyr;
    private com.baidu.tieba.frs.f.j dys;
    private GifView dyt;
    private TbImageView dyu;
    private HashSet<String> dyv;
    private com.baidu.tieba.play.m dyw;
    private ObservedChangeLinearLayout dyy;
    private com.baidu.tieba.frs.entelechy.b.a dyz;
    private ImageView mBackImageView;
    public String mForumName;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.j mPullView;
    private View mStatusBarView;
    private boolean dxV = false;
    private NoPressedRelativeLayout dxX = null;
    private CoordinatorLayout dxY = null;
    private View dxZ = null;
    private FrameLayout dyd = null;
    private TbImageView dye = null;
    private TbImageView dyf = null;
    private BdTypeRecyclerView dyg = null;
    private com.baidu.tbadk.core.dialog.b dyj = null;
    private NoNetworkView.a duP = null;
    private boolean mHasMore = true;
    private boolean dyo = false;
    private int dxP = 0;
    private int bXk = 0;
    private View dyx = null;
    private boolean cFo = true;
    private boolean dyA = true;
    private Runnable dyF = new Runnable() { // from class: com.baidu.tieba.frs.k.5
        @Override // java.lang.Runnable
        public void run() {
            if (k.this.dyc != null) {
                k.this.dyd.setVisibility(0);
                k.this.dyf.setVisibility(0);
                k.this.dye.setVisibility(8);
            }
        }
    };
    private CustomMessageListener dyH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER) { // from class: com.baidu.tieba.frs.k.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                k.this.awQ.setExpanded(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };

    public ObservedChangeLinearLayout att() {
        return this.dyy;
    }

    public View atu() {
        return this.dyx;
    }

    public k(i iVar, View.OnClickListener onClickListener, com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        this.dxW = null;
        this.dyk = null;
        this.dyn = 0;
        this.dxW = iVar;
        this.dyk = onClickListener;
        a(aVar, z);
        this.dyv = new HashSet<>();
        this.dyn = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.dxW.registerListener(this.dyH);
    }

    private void a(com.baidu.tieba.frs.entelechy.b.a aVar, boolean z) {
        boolean z2;
        this.dyz = aVar;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.j(this.dxW.getPageContext());
        }
        this.mPullView.setTag(this.dxW.getUniqueId());
        if (this.dxX == null) {
            this.dxX = (NoPressedRelativeLayout) this.dxW.mRootView.findViewById(d.g.frs);
        }
        com.baidu.tbadk.core.util.aj.t(this.dxX, d.C0108d.cp_bg_line_d);
        if (this.dxZ == null) {
            this.dxZ = this.dxW.mRootView.findViewById(d.g.frs_content_container);
        }
        if (this.dxY == null) {
            this.dxY = (CoordinatorLayout) this.dxW.mRootView.findViewById(d.g.frs_nested_scroll_layout);
        }
        if (this.dym == null) {
            this.dym = this.dxW.mRootView.findViewById(d.g.frs_list_content);
        }
        if (this.dyE == null) {
            this.dyE = (CollapsingToolbarLayout) this.dxW.mRootView.findViewById(d.g.frs_collapse_layout);
        }
        if (this.dyD == null) {
            this.dyD = (FrsHeaderViewContainer) this.dxW.mRootView.findViewById(d.g.header_view_container);
        }
        if (this.dyy == null) {
            this.dyy = (ObservedChangeLinearLayout) this.dxW.mRootView.findViewById(d.g.navigation_bar_wrapperLayout);
            this.dyy.setOnSizeChangeListener(new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.frs.k.1
                @Override // com.baidu.tbadk.widget.layout.e
                public void d(View view, int i, int i2, int i3, int i4) {
                    if (i2 != i4) {
                        k.this.setHeaderViewHeight(i2);
                        ViewGroup.LayoutParams layoutParams = k.this.dyD.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, i2, 0, 0);
                            k.this.dyD.requestLayout();
                        }
                        k.this.dyE.setMinimumHeight(i2);
                    }
                }
            });
        }
        if (this.mNavigationBar == null) {
            this.mNavigationBar = (NavigationBar) this.dxW.mRootView.findViewById(d.g.view_navigation_bar);
            this.mNavigationBar.showBottomLine();
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.dxW.atq()) {
            this.mNavigationBar.setVisibility(8);
        }
        if (this.dyl == null) {
            this.dyl = this.dxW.mRootView.findViewById(d.g.frs_navi_line);
            com.baidu.tieba.frs.entelechy.b.b auO = aVar.auO();
            if (auO != null) {
                auO.bL(this.dyl);
            }
        }
        if (this.dya == null) {
            this.dya = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.dya.setOnClickListener(this.dyk);
            this.mBackImageView = (ImageView) this.dya.findViewById(d.g.widget_navi_back_button);
        }
        if (this.dyb == null) {
            this.dyb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_search, (View.OnClickListener) null);
            this.dyb.setOnClickListener(this.dyk);
        }
        if (z2) {
            this.mNavigationBar.onChangeSkinType(this.dxW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0108d.cp_bg_line_b);
        }
        if (this.dyi == null) {
            this.dyi = (BdSwipeRefreshLayout) this.dxW.mRootView.findViewById(d.g.frs_pull_refresh_layout);
            this.dyi.setProgressView(this.mPullView);
            com.baidu.tbadk.core.util.aj.t(this.dyi, d.C0108d.cp_bg_line_c);
        }
        if (this.dyg == null) {
            this.dyg = (BdTypeRecyclerView) this.dxW.mRootView.findViewById(d.g.frs_lv_thread);
        }
        ((DefaultItemAnimator) this.dyg.getItemAnimator()).setSupportsChangeAnimations(false);
        this.dyg.setLayoutManager(new LinearLayoutManager(this.dyg.getContext()));
        this.dyg.setScrollable(this.dxW);
        this.dyg.setFadingEdgeLength(0);
        this.dyg.setOverScrollMode(2);
        this.dxX.setBottomOrderView(this.dyg);
        this.dyg.setOnTouchListener(this.dxW.bBc);
        this.dyg.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.k.2
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (k.this.dyw != null) {
                    k.this.dyw.cf(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(d.g.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(d.g.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        });
        if (this.bYK == null) {
            this.bYK = new PbListView(this.dxW.getPageContext().getPageActivity());
            this.bYK.getView();
        }
        this.bYK.gx(d.C0108d.cp_bg_line_e);
        this.bYK.setHeight(com.baidu.adp.lib.util.l.s(this.dxW.getActivity(), d.e.tbds182));
        this.bYK.DQ();
        this.bYK.setTextSize(d.e.tbfontsize33);
        this.bYK.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_d));
        this.bYK.gw(d.C0108d.cp_cont_e);
        this.dyg.setOnSrollToBottomListener(this.dxW);
        this.mNavigationBar.setOnTouchListener(new t(new t.a() { // from class: com.baidu.tieba.frs.k.3
            @Override // com.baidu.tieba.tbadkCore.t.a
            public void atX() {
                k.this.dxW.atl();
            }

            @Override // com.baidu.tieba.tbadkCore.t.a
            public void atY() {
                if (k.this.dxW != null && k.this.awQ != null) {
                    k.this.dxW.ats();
                    k.this.awQ.setExpanded(true);
                    if (k.this.dyw != null) {
                        k.this.dyw.c(k.this.dxP, k.this.bXk, false, true);
                    }
                }
            }
        }));
        boolean CU = com.baidu.tbadk.core.util.an.CS().CU();
        if (this.dyh == null) {
            this.dyh = aVar.a(this.dxW, this.dyg, CU);
        }
        cN(false);
        if (!z) {
            if (this.dhH == null) {
                this.dhH = new NoNetworkView(this.dxW.getActivity());
                this.dhH.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                this.dyy.addView(this.dhH);
            }
            if (com.baidu.adp.lib.util.j.ow()) {
                this.dhH.setVisibility(8);
            } else {
                this.dhH.setVisibility(0);
            }
            this.dhH.onChangeSkinType(this.dxW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        atB();
        if (this.dyq == null) {
            this.dyq = aVar.c(this.dxW, this.dxX);
        }
        if (this.dyr == null) {
            this.dyr = aVar.b(this.dxW, this.dxX);
            fA(true);
        }
        if (this.dyx == null) {
            this.dyx = this.dxW.mRootView.findViewById(d.g.statebar_view);
        }
        if (this.dyw == null) {
            this.dyw = new com.baidu.tieba.play.m(this.dxW.getPageContext(), this.dyg);
        }
        this.dyw.setUniqueId(this.dxW.getUniqueId());
        if (this.dys == null) {
            this.dys = new com.baidu.tieba.frs.f.j(this.dxW, (NavigationBarCoverTip) this.dxW.mRootView.findViewById(d.g.navigation_cover_tip));
        }
        if (this.awQ == null) {
            this.awQ = (AppBarLayout) this.dxW.mRootView.findViewById(d.g.frs_app_bar_layout);
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.awQ.getLayoutParams();
            if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                this.dyC = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
            }
        }
    }

    public void setHeaderViewHeight(int i) {
        if (this.dyp != null && this.dyp.getLayoutParams() != null) {
            this.dyp.getLayoutParams().height = i;
            this.dyp.setLayoutParams(this.dyp.getLayoutParams());
        }
    }

    public void lk(String str) {
        if (this.dys != null) {
            this.dys.lk(str);
        }
    }

    public View atv() {
        return this.dyp;
    }

    public com.baidu.tieba.play.m atw() {
        return this.dyw;
    }

    public com.baidu.tieba.frs.entelechy.b.c atx() {
        return this.dyr;
    }

    public void fy(boolean z) {
        boolean z2 = z && v.G(this.dxW.atn().bAN());
        if (this.dyq != null) {
            this.dyq.fy(z2);
        }
    }

    public com.baidu.tieba.frs.entelechy.b.d aty() {
        return this.dyq;
    }

    public void x(boolean z, boolean z2) {
        if (this.dyA && this.dyr != null) {
            this.dyr.x(z, z2);
        }
    }

    public void fz(boolean z) {
        this.dyA = z;
        if (!this.dyA && this.dyr != null) {
            this.dyr.x(false, false);
        }
    }

    public void atz() {
        if (this.dyA && this.dyr != null) {
            this.dyr.x(false, false);
        }
        this.dyb.setVisibility(8);
        fy(false);
        this.dyg.setVisibility(8);
        this.dyD.setVisibility(8);
    }

    public void atA() {
        if (this.dyA && this.dyr != null) {
            this.dyr.x(true, false);
        }
        this.dyb.setVisibility(0);
        fy(true);
        this.dyg.setVisibility(0);
        this.dyD.setVisibility(0);
    }

    public void fA(boolean z) {
        if (this.dyr != null) {
            this.dyr.fQ(z);
        }
    }

    private void atB() {
        if (this.dyt == null) {
            this.dyt = (GifView) this.dxW.mRootView.findViewById(d.g.gif_real_time);
            this.dyu = (TbImageView) this.dxW.mRootView.findViewById(d.g.tbimg_real_time);
            this.dyu.setPageId(this.dxW.getUniqueId());
            this.dyt.setLayerType(1, null);
            this.dyu.setLayerType(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View atC() {
        return this.dya;
    }

    public void h(NoNetworkView.a aVar) {
        this.duP = aVar;
        if (this.dhH != null) {
            this.dhH.a(this.duP);
        }
    }

    public void cN(boolean z) {
        this.dxV = z;
        if (z) {
            if (this.dyr != null) {
                this.dyr.avs();
                return;
            }
            return;
        }
        this.dyg.getAdapter().notifyDataSetChanged();
        if (this.dyr != null) {
            this.dyr.avt();
        }
    }

    public void fB(boolean z) {
        if (this.dyr != null) {
            if (z) {
                x(false, true);
            } else {
                x(false, false);
            }
        }
    }

    public void a(i.b bVar) {
        this.mPullView.a(bVar);
    }

    public void a(i.c cVar) {
        this.mPullView.a(cVar);
    }

    public void a(i.a aVar) {
        this.mPullView.a(aVar);
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.dyg.addOnScrollListener(onScrollListener);
    }

    public void setOnAdapterItemClickListener(com.baidu.adp.widget.ListView.o oVar) {
        this.dyh.setOnAdapterItemClickListener(oVar);
    }

    public void setForumName(String str) {
        this.dyh.setForumName(str);
        this.mForumName = str;
    }

    public void onDestroy() {
        if (this.dyw != null) {
            this.dyw.destroy();
        }
        if (this.dys != null) {
            this.dys.onDestory();
        }
        this.dyh.onDestory();
        this.dyg.setOnSrollToBottomListener(null);
        this.dyg.setScrollable(null);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.dyF);
        if (this.dje != null) {
            this.dje.onDestroy();
        }
        this.dyv.clear();
        if (this.dyq != null) {
            this.dyq.avu();
        }
        if (this.dyx != null) {
            this.dyx.setBackgroundDrawable(null);
        }
        if (this.dyB != null) {
            this.dyB.auK();
        }
    }

    public boolean atD() {
        if (this.awQ == null || this.dyC == null || !this.dyC.isSticky()) {
            return this.dyq != null && this.dyq.atD();
        }
        if (this.dyg != null) {
            this.dyg.setSelection(0);
        }
        this.dyC.expandedAppBarLayout(this.awQ);
        return true;
    }

    public boolean ato() {
        return this.dxV;
    }

    public void WZ() {
        this.dyg.setVisibility(0);
    }

    public void setTitle(String str) {
        String str2;
        if (TextUtils.isEmpty(this.mNavigationBar.getCenterTextTitleText())) {
            if (TextUtils.isEmpty(str)) {
                this.mNavigationBar.setCenterTextTitle("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.mNavigationBar.setCenterTextTitle(str2);
            com.baidu.tbadk.core.i.wB().cz(str);
        }
    }

    public void atE() {
        if (this.dyh != null) {
            this.dyh.notifyDataSetChanged();
        }
    }

    public void akL() {
        if (this.dyh instanceof com.baidu.tieba.frs.entelechy.a.b) {
            ((com.baidu.tieba.frs.entelechy.a.b) this.dyh).akL();
        }
    }

    private void atF() {
        if (this.dyj == null && this.dxW.getPageContext() != null) {
            String[] strArr = {this.dxW.getPageContext().getPageActivity().getString(d.j.take_photo), this.dxW.getPageContext().getPageActivity().getString(d.j.album)};
            this.dyj = new com.baidu.tbadk.core.dialog.b(this.dxW.getPageContext().getPageActivity());
            this.dyj.da(this.dxW.getPageContext().getPageActivity().getString(d.j.operation));
            this.dyj.a(strArr, new b.InterfaceC0074b() { // from class: com.baidu.tieba.frs.k.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        k.this.dxW.atp();
                    } else if (i == 1 && k.this.dxW.getPageContext() != null) {
                        com.baidu.tbadk.core.util.ai.r(k.this.dxW.getPageContext().getPageActivity());
                    }
                }
            });
            this.dyj.d(this.dxW.getPageContext());
        }
    }

    public void atG() {
        atF();
        if (this.dyj != null) {
            this.dyj.AL();
        }
    }

    public void a(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.l lVar) {
        if (v.G(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
            if (this.dxW != null && this.dxW.asQ() != null && this.dxW.asQ().axf() == 0) {
                mVar.mV(this.dxW.asQ().axn());
            }
        }
        if (v.F(arrayList) > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i iVar = arrayList.get(i2);
                if (iVar instanceof be) {
                    ((be) iVar).setSmartFrsPosition(i2);
                }
                i = i2 + 1;
            }
        }
        this.dyh.b(arrayList, lVar);
        if (this.dyw != null) {
            this.dyw.c(this.dxP, this.bXk, this.dyo, true);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dyg;
    }

    public void atH() {
        this.dyh.notifyDataSetChanged();
    }

    public void a(com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dxW.getPageContext(), 1);
        aVar.a(this.dyg);
        HashMap hashMap = new HashMap();
        hashMap.put("forum_name", this.dxW.getForumName());
        hashMap.put("forum_id", this.dxW.getForumId());
        aVar.setParams(hashMap);
        aVar.aM(vVar);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
    }

    public void onPause() {
        if (this.dyq != null) {
            this.dyq.avv();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN));
    }

    public void onResume() {
        if (this.dyq != null) {
            this.dyq.avw();
        }
    }

    public void release() {
        if (this.dhH != null && this.duP != null) {
            this.dhH.b(this.duP);
        }
    }

    public ImageView atI() {
        return this.dyb;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.InjectPlugin.b.b bVar = new com.baidu.tieba.InjectPlugin.b.b(this.dxW, 4);
        bVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_FEED_AD_PLUGIN_OPERATE, bVar));
        com.baidu.tieba.InjectPlugin.b.a aVar = new com.baidu.tieba.InjectPlugin.b.a(this.dxW.getPageContext(), 4);
        aVar.setSkinType(i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_BANNER_AD_PLUGIN_OPERATE, aVar));
        if (this.dyu != null) {
            this.dyu.invalidate();
        }
        if (this.dyh != null) {
            this.dyh.avh();
            this.dyh.notifyDataSetChanged();
        }
        this.dxW.getPageContext().getLayoutMode().aM(i == 1);
        this.dxW.getPageContext().getLayoutMode().aM(this.dxX);
        if (this.dxX != null) {
            com.baidu.tbadk.core.util.aj.g(this.dxX, d.C0108d.cp_bg_line_d, i);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dxW.getPageContext(), i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fR(d.f.s_navbar_bg)));
            com.baidu.tbadk.core.util.aj.g(this.dyl, d.C0108d.cp_bg_line_b, i);
            com.baidu.tbadk.core.util.aj.t(this.mNavigationBar.getBottomLine(), d.C0108d.cp_bg_line_b);
        }
        if (this.mStatusBarView != null) {
            this.mStatusBarView.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.aj.fR(d.f.s_navbar_bg)));
        }
        if (this.dhH != null) {
            this.dhH.onChangeSkinType(this.dxW.getPageContext(), i);
        }
        if (this.bYK != null) {
            this.bYK.setTextColor(com.baidu.tbadk.core.util.aj.getColor(d.C0108d.cp_cont_d));
            this.bYK.gy(i);
        }
        fF(false);
        if (this.dyr != null) {
            this.dyr.onChangeSkinType(i);
        }
        if (this.dyq != null) {
            this.dyq.onChangeSkinType(i);
        }
        if (this.dyx != null) {
            UtilHelper.setStatusBarBackground(this.dyx, i);
        }
        if (this.dyw != null) {
            this.dyw.c(this.dxP, this.bXk, this.dyo, true);
        }
        if (this.mPullView != null) {
            this.mPullView.gy(i);
        }
        com.baidu.tbadk.core.util.aj.t(this.dyi, d.C0108d.cp_bg_line_c);
        com.baidu.tbadk.core.util.aj.t(this.dyg, d.C0108d.cp_bg_line_e);
    }

    public void startPullRefresh() {
        if (this.dyg != null && this.dyg.getFirstVisiblePosition() != 0) {
            this.dyg.setSelection(0);
        }
        this.dyi.setRefreshing(true);
    }

    public void fC(boolean z) {
        if (z) {
            this.dyi.setRefreshing(false);
        } else {
            this.dyi.sW();
        }
    }

    public boolean atJ() {
        return this.dyc != null && this.dyf.getVisibility() == 0;
    }

    public void atK() {
        if (this.dyc != null) {
            this.dyd.setVisibility(0);
            this.dyf.setVisibility(8);
            this.dye.setVisibility(0);
            TbadkCoreApplication.getInst().handler.postDelayed(this.dyF, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    public void a(bm bmVar) {
        if (this.dyc == null) {
            this.dyc = (ViewStub) this.dxW.mRootView.findViewById(d.g.yule_game_egg_view_stub);
            this.dyc.setVisibility(0);
            this.dyd = (FrameLayout) this.dxW.mRootView.findViewById(d.g.game_activity_egg_layout);
            this.dye = (TbImageView) this.dxW.mRootView.findViewById(d.g.game_activity_egg);
            this.dyf = (TbImageView) this.dxW.mRootView.findViewById(d.g.game_activity_egg_s);
            this.dye.setPageId(this.dxW.getUniqueId());
            this.dyf.setPageId(this.dxW.getUniqueId());
            this.dye.setDefaultBgResource(d.C0108d.common_color_10022);
            this.dye.setDefaultResource(0);
            this.dyf.setDefaultBgResource(d.C0108d.common_color_10022);
            this.dyf.setDefaultResource(0);
            this.dyd.setOnClickListener(this.dyk);
        }
        this.dyd.setVisibility(0);
        String Ay = bmVar.Ay();
        String Az = bmVar.Az();
        this.dye.startLoad(Ay, 10, false);
        this.dyf.startLoad(Az, 10, false);
        TbadkCoreApplication.getInst().handler.postDelayed(this.dyF, TbConfig.NOTIFY_SOUND_INTERVAL);
    }

    public void atL() {
        if (this.dyc != null) {
            this.dyd.setVisibility(8);
        }
    }

    public u atM() {
        return this.dyh;
    }

    public ViewGroup aey() {
        return this.dxX;
    }

    public View atN() {
        return this.dym;
    }

    public void mR(int i) {
        if (this.dxZ != null) {
            this.dxZ.setVisibility(i);
        }
    }

    public void atO() {
        if (com.baidu.tbadk.k.r.Oa().Ob()) {
            int lastVisiblePosition = this.dyg.getLastVisiblePosition();
            for (int i = 0; i <= lastVisiblePosition; i++) {
                View childAt = this.dyg.getChildAt(i);
                if (childAt != null && (childAt instanceof View) && childAt.getTag() != null && (childAt.getTag() instanceof o)) {
                    o oVar = (o) childAt.getTag();
                    if (oVar.dyP != null) {
                        com.baidu.tbadk.k.l perfLog = oVar.dyP.getPerfLog();
                        perfLog.iq(1000);
                        perfLog.bye = true;
                        if (lastVisiblePosition == i) {
                            int[] iArr = new int[2];
                            oVar.dyP.getLocationOnScreen(iArr);
                            if (iArr[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
                            }
                        }
                        oVar.dyP.startLogPerf();
                    }
                    if (oVar.dyO != null && (oVar.dyO instanceof ViewGroup)) {
                        FrsCommonImageLayout frsCommonImageLayout = oVar.dyO;
                        for (int i2 = 0; i2 < frsCommonImageLayout.getChildCount(); i2++) {
                            View childAt2 = frsCommonImageLayout.getChildAt(i2);
                            if (childAt2 instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt2;
                                com.baidu.tbadk.k.l perfLog2 = tbImageView.getPerfLog();
                                perfLog2.iq(1000);
                                perfLog2.bye = true;
                                if (lastVisiblePosition == i) {
                                    int[] iArr2 = new int[2];
                                    childAt2.getLocationOnScreen(iArr2);
                                    if (iArr2[1] > com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext())) {
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

    public NavigationBar atm() {
        return this.mNavigationBar;
    }

    public void atP() {
        this.mHasMore = true;
        this.dyg.setNextPage(this.bYK);
        if (this.dyn > 0) {
            this.bYK.gz(this.dyn);
        }
        this.bYK.setOnClickListener(null);
        this.bYK.DT();
    }

    public void atQ() {
        this.mHasMore = false;
        this.dyg.setNextPage(this.bYK);
        if (this.dyn > 0) {
            this.bYK.gz(this.dyn);
        }
        this.bYK.setOnClickListener(null);
        this.bYK.DU();
        this.bYK.setText(this.dxW.getResources().getString(d.j.list_no_more));
    }

    public void atR() {
        this.mHasMore = true;
        this.dyg.setNextPage(this.bYK);
        this.bYK.setOnClickListener(this.dyk);
        if (this.dyn > 0) {
            this.bYK.gz(this.dyn);
        }
        this.bYK.DU();
        this.bYK.setText(this.dxW.getResources().getString(d.j.list_click_load_more));
    }

    public View atS() {
        if (this.bYK == null) {
            return null;
        }
        return this.bYK.getView();
    }

    public void akM() {
        this.mHasMore = false;
        this.dyg.setNextPage(null);
    }

    public boolean akC() {
        return this.bYK.getView().getParent() != null && this.mHasMore;
    }

    public void mS(int i) {
        this.dyn = i;
    }

    public void mT(int i) {
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i == 3 || i == 6) && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_login_tip", true)) {
                if (this.dje == null) {
                    this.dje = new CommonTipView(this.dxW.getActivity());
                }
                this.dje.setText(d.j.frs_login_tip);
                this.dje.show((FrameLayout) atN(), TbadkCoreApplication.getInst().getSkinType());
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", false);
            }
        }
    }

    public void fD(boolean z) {
        if (this.dyw != null) {
            if (z) {
                this.dyw.ii(false);
                this.dyw.aCw();
                return;
            }
            this.dyw.ii(true);
            this.dyw.c(this.dxP, this.bXk, this.dyo, true);
        }
    }

    public void bw(int i, int i2) {
        if (this.dyw != null) {
            this.dyw.a(i, i2, this.dyo, 1);
        }
    }

    public void bx(int i, int i2) {
        this.dxP = i;
        this.bXk = i2;
    }

    public void fE(boolean z) {
        this.dyo = z;
    }

    public void atT() {
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.mNavigationBar.setmBackImageViewBg(d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
            com.baidu.tbadk.core.util.aj.s(this.mBackImageView, d.f.frs_star_navigation_bg);
        }
    }

    private void atU() {
        float f;
        if (this.mNavigationBar != null) {
            float alpha = this.mNavigationBar.getBarBgView() != null ? this.mNavigationBar.getBarBgView().getAlpha() : 0.0f;
            if (this.mNavigationBar.mTextTitle != null) {
                this.mNavigationBar.mTextTitle.setAlpha(alpha);
            }
            if (alpha < 0.5f) {
                f = 1.0f - (alpha * 2.0f);
            } else {
                f = (alpha * 2.0f) - 1.0f;
            }
            if (f >= 0.0f && f <= 1.0f && this.mBackImageView != null) {
                this.mBackImageView.setAlpha(f);
            }
        }
    }

    private void fF(boolean z) {
        boolean i = com.baidu.tieba.frs.f.f.i(this.dxW.atn());
        boolean h = com.baidu.tieba.frs.f.f.h(this.dxW.atn());
        if (this.mNavigationBar != null && this.mNavigationBar.getBarBgView() != null) {
            if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
                if (!z || !this.cFo) {
                    this.cFo = true;
                    com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.btn_sml_back_selector_s, d.f.btn_sml_back_selector_s);
                    com.baidu.tbadk.core.util.aj.a(this.dyb, d.f.icon_sml_search_bg, d.f.icon_sml_search_bg);
                    if (i && !h) {
                        com.baidu.tbadk.core.util.aj.s(this.mBackImageView, d.f.frs_star_navigation_bg);
                    }
                }
            } else if (!z || this.cFo) {
                this.cFo = false;
                com.baidu.tbadk.core.util.aj.a(this.mBackImageView, d.f.icon_return_bg_s, d.f.icon_return_bg);
                com.baidu.tbadk.core.util.aj.a(this.dyb, d.f.icon_search_bg_s, d.f.icon_search_bg);
                if (i) {
                    this.mBackImageView.setBackgroundDrawable(null);
                }
            }
        }
        atU();
    }

    public void fG(boolean z) {
    }

    public void mU(int i) {
        if (this.dyg != null && this.dyg.getChildCount() >= 0) {
            if (this.dyg.getFirstVisiblePosition() > 8) {
                this.dyg.scrollToPosition(8);
            }
            this.dyg.smoothScrollToPosition(i);
        }
    }

    public void atV() {
        a(this.dyz, this.dxW.atq());
        if (this.dyh != null) {
            this.dyh.avm();
        }
    }

    public void c(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (this.dyB == null) {
                this.dyB = new com.baidu.tieba.video.e(this.dxW.getActivity(), this.dxX);
            }
            this.dyB.g(postWriteCallBackData);
        }
    }

    public void atW() {
        int headerViewsCount;
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("frs_video_activity_guide", 0L) == 0 && !this.dyG && this.dxW.getActivity() != null && this.dxW.getPageContext() != null) {
            View view = null;
            if (this.dyg != null && (headerViewsCount = this.dyg.getHeaderViewsCount()) < this.dyg.getChildCount()) {
                view = this.dyg.getChildAt(headerViewsCount);
            }
            if (view != null) {
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.aG(view).cW(0).ag(true).ah(false).af(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.frs.k.6
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(d.j.frs_video_activity_guide_tip);
                        k.this.dxW.getPageContext().getLayoutMode().aM(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int mA() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int mB() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return com.baidu.adp.lib.util.l.s(k.this.dxW.getActivity(), d.e.ds10);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return -com.baidu.adp.lib.util.l.s(k.this.dxW.getActivity(), d.e.ds6);
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.frs.k.7
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void bL() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("frs_video_activity_guide", 1L);
                    }
                });
                final com.baidu.adp.lib.guide.c mC = dVar.mC();
                mC.ae(false);
                mC.j(this.dxW.getActivity());
                com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.k.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (mC != null) {
                            mC.dismiss();
                        }
                    }
                }, 4000L);
                this.dyG = true;
            }
        }
    }
}
