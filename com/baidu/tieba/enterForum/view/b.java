package com.baidu.tieba.enterForum.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.d;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.enterForum.view.e;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.GuidePopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b implements EnterForumAdView.a {
    private static boolean irl = false;
    private View bFD;
    private ImageView fkh;
    private View gFy;
    private com.baidu.adp.lib.guide.c ieb;
    private ViewEventCenter ihN;
    private com.baidu.tieba.enterForum.data.c ihS;
    private int ikC;
    private int ioU;
    private boolean irA;
    private final EnterForumFragment ird;
    private BdListView ire;
    private com.baidu.tieba.enterForum.a.a irf;
    private List<com.baidu.tieba.enterForum.data.f> irg;
    private bj irh;
    private CommonTipView iri;
    private EnterForumAdView irj;
    private GuidePopupWindow irk;
    private int irm;
    private e irn;
    private int irp;
    private f.c irq;
    private View irx;
    private float iry;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean iro = true;
    private f.c grV = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.irz) {
                com.baidu.tieba.s.c.dIX().C(b.this.ird.getUniqueId());
                if (b.this.irq != null) {
                    b.this.irq.onListPullRefresh(z);
                }
                if (z && !b.this.iiu && b.this.ihS != null && b.this.ihS.iiu) {
                    if (b.this.ihS.iiw > 0) {
                        b.this.ire.smoothScrollToPosition(0, 0, 0);
                        b.this.ctu();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ire.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int glP = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.irn.onScrollStateChanged(absListView, i);
            if (this.glP != i) {
                this.glP = i;
                if (this.glP == 1) {
                    if (b.this.ihS == null || !b.this.ihS.iiu) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.ctz();
                    return;
                }
                b.this.ctm();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.ird.isPrimary() && this.glP != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.ire.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof u)) {
                        u uVar = (u) itemAtPosition;
                        if (uVar.getItemViewType() == 1 && b.this.ire.getItemAtPosition(i4) == y.getItem(b.this.irg, 0)) {
                            b.this.a(uVar, b.this.ire.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.irn.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener irr = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ihS != null && b.this.ihS.iiu && b.this.iiu) {
                EnterForumAdView unused = b.this.irj;
                EnterForumAdView.a(b.this.ird.getUniqueId(), b.this.ird.getContext());
            }
        }
    };
    private int irs = 0;
    private int irt = 0;
    private CustomMessageListener iru = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cto();
        }
    };
    boolean iiu = false;
    boolean irv = false;
    private Runnable irw = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.ctw();
        }
    };
    private boolean irz = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void ctm() {
        if (ctn()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.ihS != null && this.ihS.iiu) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean ctn() {
        return this.ire == null || this.ire.getChildCount() == 0 || this.ire.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.ird = enterForumFragment;
        this.ikC = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.ioU = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.irp = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.ihN = viewEventCenter;
        cw(view);
        this.irf = new com.baidu.tieba.enterForum.a.a(this.ird.getPageContext(), this.ihN, recentlyVisitedForumModel, enterForumModel, this);
        this.ire.setAdapter((ListAdapter) this.irf);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.irk = new GuidePopupWindow(this.ird.getFragmentActivity());
    }

    private void registerListener() {
        this.ird.registerListener(this.iru);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cto() {
        if (ctp() && this.irA) {
            this.irk.dSE();
            this.irk.dSD();
            this.irk.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.irk, this.ird.getFragmentActivity());
        }
    }

    private boolean ctp() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cw(View view) {
        this.mContext = view.getContext();
        this.irn = new e();
        this.irn.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.irz) {
                    b.this.irs = -i;
                    if (b.this.iiu) {
                        b.this.ctw();
                    } else if (b.this.ihS != null && b.this.ihS.iiu) {
                        b.this.ctq();
                    }
                }
            }
        });
        this.ire = (BdListView) view.findViewById(R.id.listview);
        xY(0);
        this.ire.setBackgroundColor(0);
        this.ire.setVerticalScrollBarEnabled(false);
        this.ire.setOnScrollListener(this.mOnScrollListener);
        this.ire.setFastScrollEnabled(false);
        this.ire.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.ird.crS() != null) {
            this.ird.crS().a(this);
        }
        this.mPullView = new g(this.ird.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.irt = i3;
                if (!b.this.iiu && b.this.ihS != null && b.this.ihS.iiu && !b.this.irz) {
                    b.this.ctq();
                    if (i3 > b.this.irp) {
                        b.this.irt = 0;
                        b.this.cz(b.this.ird.crS().getRootView());
                    }
                }
            }
        });
        this.mPullView.jn(true);
        this.mPullView.setListPullRefreshListener(this.grV);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.ird.getUniqueId());
        }
        this.ire.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.ird.getPageContext().getPageActivity());
        this.gFy = new View(this.ird.getPageContext().getPageActivity());
        frameLayout.addView(this.gFy, new FrameLayout.LayoutParams(-1, this.ioU));
        this.ire.getAdapter2().addHeaderView(frameLayout, 0);
        this.bFD = new View(this.ird.getActivity());
        this.bFD.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.ird.getActivity(), R.dimen.ds50)));
        this.bFD.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.irr);
        this.mPullView.getView().setOnClickListener(this.irr);
        this.gFy.setOnClickListener(this.irr);
        ctA();
    }

    public void cx(View view) {
        this.irj = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.irj != null) {
            ctq();
            this.irj.setTag(this.ird.getUniqueId());
            this.irj.setAdData();
            this.irj.setEventCenter(this.ihN);
            this.irj.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctq() {
        if (!this.irz && this.irj != null) {
            ViewGroup.LayoutParams layoutParams = this.irj.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int ctr = ctr();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iiu ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.irs + this.irt) - ctr, 0, 0);
                this.irj.setLayoutParams(layoutParams2);
                this.irj.setAdViewHeight(layoutParams2.height - ctr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ctr() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cts() {
        return this.iiu ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.irs + this.irt) - ctr();
    }

    private int ctt() {
        ViewGroup.LayoutParams layoutParams = this.irj.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void ctu() {
        if (!this.irz) {
            this.iiu = true;
            ctq();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.irj != null) {
                if (!this.irj.ctj()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.irj.cti()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            xY(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.irw);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.irw, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xY(int i) {
        if (!this.irz) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ire.getLayoutParams();
            marginLayoutParams.topMargin = ((this.ikC + i) - this.ioU) - (EnterForumDelegateStatic.ijx.css() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.ire.setLayoutParams(marginLayoutParams);
        }
    }

    private int ctv() {
        return (this.ikC - this.ioU) - (EnterForumDelegateStatic.ijx.css() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctw() {
        this.iiu = false;
        ctq();
        xY(0);
        if (this.irv) {
            this.ire.completePullRefreshPostDelayed(0L);
        }
        this.irv = false;
    }

    public void cy(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.ird.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.ird.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.ire.setVisibility(8);
        if (this.ird.crS() != null) {
            this.ird.crS().csg();
            this.ird.crS().csh();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.ire.setVisibility(0);
        if (this.ird.crS() != null) {
            this.ird.crS().csg();
            this.ird.crS().csh();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.irg);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.irg.remove(fVar);
        a(this.irg, this.irh, z);
        pb(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView ctx() {
        return this.ire;
    }

    public void startPullRefresh() {
        this.ire.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iiu) {
            this.irv = true;
            return;
        }
        this.irv = false;
        this.ire.completePullRefreshPostDelayed(0L);
    }

    public void pb(boolean z) {
        this.irf.notifyDataSetChanged();
        if (this.bFD != null && this.bFD.getLayoutParams() != null) {
            if (z) {
                this.bFD.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bFD.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar, boolean z) {
        this.irj.setAdData();
        EnterForumDelegateStatic.ijx.fk(this.mContext);
        this.irg = list;
        this.irh = bjVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        u uVar = new u();
        uVar.nT(4);
        arrayList.add(uVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(bjVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                u uVar2 = new u();
                uVar2.nT(11);
                arrayList.add(uVar2);
            } else {
                u uVar3 = new u();
                uVar3.nT(3);
                arrayList.add(uVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bk(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bjVar.blG());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            u uVar4 = new u();
            uVar4.nT(5);
            arrayList.add(uVar4);
        }
        hideNoDataView();
        this.irf.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.ire.removeFooterView(this.bFD);
            this.ire.addFooterView(this.bFD);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.ire.removeFooterView(this.bFD);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.irk != null) {
            this.irk.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bFD, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.irq = cVar;
    }

    public void cty() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.ird != null && this.ird.getActivity() != null && this.ird.crR() != null) {
            if (this.iri == null) {
                this.iri = new CommonTipView(this.ird.getActivity());
            }
            this.iri.setText(R.string.enter_forum_login_tip);
            this.iri.c(this.ird.crR(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.ird.isAdded() && this.ird.isPrimary()) {
            irl = false;
            if (this.irf != null) {
                this.irf.onPrimary();
                if (this.ire != null) {
                    Object itemAtPosition = this.ire.getItemAtPosition(this.ire.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof u) && ((u) itemAtPosition).getItemViewType() == 5) {
                        this.irf.cqN();
                    }
                }
            }
            if (this.irz) {
                this.irj.requestFocus();
                this.irj.requestFocusFromTouch();
                return;
            }
            return;
        }
        ctz();
    }

    public void onPause() {
        ctz();
    }

    public void onDestroy() {
        if (this.iri != null) {
            this.iri.onDestroy();
        }
        if (this.irf != null) {
            this.irf.onDestroy();
        }
    }

    public void xD(int i) {
        this.irf.xD(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.irf != null) {
            this.irf.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cqM() {
        if (this.irf == null) {
            return false;
        }
        return this.irf.cqM();
    }

    public void a(u uVar, View view) {
        if (TbadkCoreApplication.isLogin() && !irl && this.ird.getActivity() != null && this.ird.getPageContext() != null && (uVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
            if (fVar.isPrivateForum() != 0 && fVar.cre() != 0 && !com.baidu.tbadk.core.sharedPref.b.bqh().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.irm = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bqh().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.irm = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                irl = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.irm);
                        b.this.ird.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return 0;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return 0;
                    }
                });
                dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.ieb = dVar.mi();
                this.ieb.setShouldCheckLocInWindow(false);
                this.ieb.setUseDirectOffset(true);
                this.ieb.show(this.ird.getActivity());
                if (this.irm == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.irm == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.ieb != null) {
                            b.this.ieb.dismiss();
                            b.this.ieb = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void ctz() {
        if (this.ieb != null) {
            this.ieb.dismiss();
            this.ieb = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ihS = cVar;
        if (this.irf != null) {
            this.irf.setAdState(cVar);
        }
        if (cVar != null && cVar.iiu) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.pW(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.pW(R.raw.lottie_common_pull_refresh);
    }

    public void pc(boolean z) {
        if (this.iro != z) {
            this.iro = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ire.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.ire.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.ire.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.ire.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.irj != null) {
            this.irj.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.irj != null) {
            this.irj.setRecentlyIsShow(z);
        }
    }

    private void ctA() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.irx = new View(this.mContext);
        this.irx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.ird.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.irx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float irD = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iry = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.iry <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iry) {
                            b.this.ctB();
                            if (this.irD < 50.0f) {
                                b.this.irx.performClick();
                            }
                        } else {
                            b.this.ctC();
                        }
                        b.this.iry = 0.0f;
                        this.irD = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.iry) {
                            b.this.ax(motionEvent.getRawY() - b.this.iry);
                            if (b.this.fkh != null) {
                                b.this.fkh.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.iry) > this.irD) {
                            this.irD = Math.abs(motionEvent.getRawY() - b.this.iry);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.iry <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iry) {
                            b.this.ctB();
                        } else {
                            b.this.ctC();
                        }
                        b.this.iry = 0.0f;
                        this.irD = 0.0f;
                        return true;
                }
            }
        });
        this.fkh = new ImageView(this.mContext);
        this.fkh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ctC();
            }
        });
    }

    public void cz(final View view) {
        if ((view instanceof FrameLayout) && !this.irz) {
            this.mPullView.pause();
            this.irz = true;
            this.irj.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.fkh, R.drawable.icon_jinba_retract_n);
            final int ctt = ctt();
            ValueAnimator ofInt = ValueAnimator.ofInt(ctt, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.irj != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.irj.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.ctr();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.irj.setLayoutParams(marginLayoutParams);
                            if (intValue / ctt < 0.2d) {
                                if (b.this.irj.getParent() != b.this.irj.getRootView() && (viewGroup = (ViewGroup) b.this.irj.getRootView()) != null) {
                                    ((ViewGroup) b.this.irj.getParent()).removeView(b.this.irj);
                                    if (b.this.irj.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.irj, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.irx);
                                    viewGroup.bringChildToFront(b.this.fkh);
                                }
                            } else if (b.this.irj.getParent() == b.this.irj.getRootView()) {
                                if (b.this.irj.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.irj.getRootView();
                                    ((ViewGroup) b.this.irj.getParent()).removeView(b.this.irj);
                                }
                                if (b.this.irj.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.ird.crV().addView(b.this.irj, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.irz = false;
                    b.this.xY(((intValue - ctt) * 2) + 0);
                    b.this.irz = true;
                    float abs = Math.abs(intValue / ctt);
                    b.this.ire.setAlpha(abs);
                    View csj = b.this.ird.crS().csj();
                    if (csj != null) {
                        csj.setAlpha(abs);
                    }
                    View findViewById = b.this.ird.crV().getRootView().findViewById(R.id.tabcontainer_wrapper);
                    if (findViewById != null) {
                        findViewById.setAlpha(abs);
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.irj != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.irj.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.ctr();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.irj.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.ire.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.irz = false;
                    b.this.xY(0 - (ctt * 2));
                    b.this.irz = true;
                    b.this.ire.setVisibility(8);
                    b.this.irx.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.irx.getParent() == null) {
                        frameLayout.addView(b.this.irx, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.fkh.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.fkh, layoutParams3);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    onAnimationEnd(animator);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofInt.setDuration(300L);
            ofInt.start();
            this.irj.requestFocus();
            this.irj.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(float f) {
        ViewGroup viewGroup;
        int cts = cts();
        float abs = Math.abs(cts / (ctv() - cts));
        int i = (int) f;
        if (this.irj != null) {
            ViewGroup.LayoutParams layoutParams = this.irj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ctr();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.irj.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.irj.getParent() != this.irj.getRootView() && (viewGroup = (ViewGroup) this.irj.getRootView()) != null) {
                        ((ViewGroup) this.irj.getParent()).removeView(this.irj);
                        if (this.irj.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.irj, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.irx);
                        viewGroup.bringChildToFront(this.fkh);
                    }
                } else if (this.irj.getParent() == this.irj.getRootView()) {
                    if (this.irj.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.irj.getRootView();
                        ((ViewGroup) this.irj.getParent()).removeView(this.irj);
                    }
                    if (this.irj.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.ird.crV().addView(this.irj, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.ire.setVisibility(0);
        this.irz = false;
        xY(((int) ((i * abs) - (cts * abs))) * 2);
        this.irz = true;
        float abs2 = Math.abs(i / cts);
        this.ire.setAlpha(abs2);
        View csj = this.ird.crS().csj();
        if (csj != null) {
            csj.setAlpha(abs2);
        }
        View findViewById = this.ird.crV().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctB() {
        if (this.fkh != null) {
            this.fkh.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(ctt(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ax(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ax(0.0f);
                b.this.mPullView.resume();
                b.this.ire.completePullRefresh();
                b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctC() {
        this.irx.setEnabled(false);
        int cts = cts();
        Math.abs(cts / (ctv() - cts));
        this.fkh.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.irj.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(ctt(), cts);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ax(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass13());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$13  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass13 implements Animator.AnimatorListener {
        AnonymousClass13() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.irx.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.irx);
                        viewGroup.removeView(b.this.fkh);
                    }
                    b.this.fkh.setVisibility(0);
                    b.this.irz = false;
                    b.this.ctq();
                    b.this.irt = 0;
                    b.this.xY(0);
                    b.this.irz = true;
                    b.this.mPullView.resume();
                    b.this.ire.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.irz = false;
                        }
                    }, 0L);
                    b.this.ire.setVisibility(0);
                }
            });
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // com.baidu.tieba.enterForum.view.EnterForumAdView.a
    public void onBackPressed() {
        if (this.irz) {
            ctC();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.crv())) {
                this.irA = false;
            } else {
                this.irA = true;
            }
            this.irk.setForumId(aVar.crt());
            this.irk.I(aVar.crs(), aVar.cru());
            this.irk.fW(aVar.crr());
            this.irk.AV(aVar.crv());
        }
    }
}
