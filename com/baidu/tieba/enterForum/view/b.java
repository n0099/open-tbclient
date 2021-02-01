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
import com.baidu.adp.widget.ListView.c;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
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
/* loaded from: classes2.dex */
public class b implements EnterForumAdView.a {
    private static boolean iQg = false;
    private View bMM;
    private ImageView fyc;
    private View gXZ;
    private com.baidu.adp.lib.guide.c iDj;
    private ViewEventCenter iGM;
    private com.baidu.tieba.enterForum.data.c iGR;
    private int iJC;
    private int iNP;
    private final EnterForumFragment iPY;
    private BdListView iPZ;
    private com.baidu.tieba.enterForum.adapter.a iQa;
    private List<com.baidu.tieba.enterForum.data.f> iQb;
    private bo iQc;
    private CommonTipView iQd;
    private EnterForumAdView iQe;
    private GuidePopupWindow iQf;
    private int iQh;
    private e iQi;
    private int iQk;
    private f.c iQl;
    private View iQs;
    private float iQt;
    private boolean iQv;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean iQj = true;
    private f.c gIU = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.iQu) {
                com.baidu.tieba.s.c.dMr().D(b.this.iPY.getUniqueId());
                if (b.this.iQl != null) {
                    b.this.iQl.onListPullRefresh(z);
                }
                if (z && !b.this.iHt && b.this.iGR != null && b.this.iGR.iHt) {
                    if (b.this.iGR.iHv > 0) {
                        b.this.iPZ.smoothScrollToPosition(0, 0, 0);
                        b.this.cxB();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iPZ.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int gCJ = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.iQi.onScrollStateChanged(absListView, i);
            if (this.gCJ != i) {
                this.gCJ = i;
                if (this.gCJ == 1) {
                    if (b.this.iGR == null || !b.this.iGR.iHt) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cxG();
                    return;
                }
                b.this.cxt();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.iPY.isPrimary() && this.gCJ != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.iPZ.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof w)) {
                        w wVar = (w) itemAtPosition;
                        if (wVar.getItemViewType() == 1 && b.this.iPZ.getItemAtPosition(i4) == y.getItem(b.this.iQb, 0)) {
                            b.this.a(wVar, b.this.iPZ.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.iQi.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener iQm = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iGR != null && b.this.iGR.iHt && b.this.iHt) {
                EnterForumAdView unused = b.this.iQe;
                EnterForumAdView.a(b.this.iPY.getUniqueId(), b.this.iPY.getContext());
            }
        }
    };
    private int iQn = 0;
    private int iQo = 0;
    private CustomMessageListener iQp = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cxv();
        }
    };
    boolean iHt = false;
    boolean iQq = false;
    private Runnable iQr = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cxD();
        }
    };
    private boolean iQu = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cxt() {
        if (cxu()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.iGR != null && this.iGR.iHt) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cxu() {
        return this.iPZ == null || this.iPZ.getChildCount() == 0 || this.iPZ.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.iPY = enterForumFragment;
        this.iJC = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.iNP = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.iQk = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.iGM = viewEventCenter;
        cP(view);
        this.iQa = new com.baidu.tieba.enterForum.adapter.a(this.iPY.getPageContext(), this.iGM, recentlyVisitedForumModel, enterForumModel, this);
        this.iPZ.setAdapter((ListAdapter) this.iQa);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.iQf = new GuidePopupWindow(this.iPY.getFragmentActivity());
    }

    private void registerListener() {
        this.iPY.registerListener(this.iQp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxv() {
        if (cxw() && this.iQv) {
            this.iQf.dVY();
            this.iQf.dVX();
            this.iQf.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.iQf, this.iPY.getFragmentActivity());
        }
    }

    private boolean cxw() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cP(View view) {
        this.mContext = view.getContext();
        this.iQi = new e();
        this.iQi.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.iQu) {
                    b.this.iQn = -i;
                    if (b.this.iHt) {
                        b.this.cxD();
                    } else if (b.this.iGR != null && b.this.iGR.iHt) {
                        b.this.cxx();
                    }
                }
            }
        });
        this.iPZ = (BdListView) view.findViewById(R.id.listview);
        xS(0);
        this.iPZ.setBackgroundColor(0);
        this.iPZ.setVerticalScrollBarEnabled(false);
        this.iPZ.setOnScrollListener(this.mOnScrollListener);
        this.iPZ.setFastScrollEnabled(false);
        this.iPZ.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        BdListView bdListView = this.iPZ;
        BdListView.setPullRefreshRatio(1.0f);
        if (this.iPY.cvZ() != null) {
            this.iPY.cvZ().a(this);
        }
        this.mPullView = new g(this.iPY.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.iQo = i3;
                if (!b.this.iHt && b.this.iGR != null && b.this.iGR.iHt && !b.this.iQu) {
                    b.this.cxx();
                    if (i3 > b.this.iQk) {
                        b.this.iQo = 0;
                        b.this.cS(b.this.iPY.cvZ().getRootView());
                    }
                }
            }
        });
        this.mPullView.jZ(true);
        this.mPullView.setListPullRefreshListener(this.gIU);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.iPY.getUniqueId());
        }
        this.iPZ.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.iPY.getPageContext().getPageActivity());
        this.gXZ = new View(this.iPY.getPageContext().getPageActivity());
        frameLayout.addView(this.gXZ, new FrameLayout.LayoutParams(-1, this.iNP));
        this.iPZ.getAdapter2().addHeaderView(frameLayout, 0);
        this.bMM = new View(this.iPY.getActivity());
        this.bMM.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.iPY.getActivity(), R.dimen.ds50)));
        this.bMM.setBackgroundResource(R.color.CAM_X0201);
        this.mPullView.setOnClickListener(this.iQm);
        this.mPullView.getView().setOnClickListener(this.iQm);
        this.gXZ.setOnClickListener(this.iQm);
        cxH();
    }

    public void cQ(View view) {
        this.iQe = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.iQe != null) {
            cxx();
            this.iQe.setTag(this.iPY.getUniqueId());
            this.iQe.setAdData();
            this.iQe.setEventCenter(this.iGM);
            this.iQe.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxx() {
        if (!this.iQu && this.iQe != null) {
            ViewGroup.LayoutParams layoutParams = this.iQe.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cxy = cxy();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iHt ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iQn + this.iQo) - cxy, 0, 0);
                this.iQe.setLayoutParams(layoutParams2);
                this.iQe.setAdViewHeight(layoutParams2.height - cxy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxy() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cxz() {
        return this.iHt ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iQn + this.iQo) - cxy();
    }

    private int cxA() {
        ViewGroup.LayoutParams layoutParams = this.iQe.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cxB() {
        if (!this.iQu) {
            this.iHt = true;
            cxx();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.iQe != null) {
                if (!this.iQe.cxq()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.iQe.cxp()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            xS(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.iQr);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.iQr, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xS(int i) {
        if (!this.iQu) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iPZ.getLayoutParams();
            marginLayoutParams.topMargin = ((this.iJC + i) - this.iNP) - (EnterForumDelegateStatic.iIw.cwz() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.iPZ.setLayoutParams(marginLayoutParams);
        }
    }

    private int cxC() {
        return (this.iJC - this.iNP) - (EnterForumDelegateStatic.iIw.cwz() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxD() {
        this.iHt = false;
        cxx();
        xS(0);
        if (this.iQq) {
            this.iPZ.completePullRefreshPostDelayed(0L);
        }
        this.iQq = false;
    }

    public void cR(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.iPY.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.iPY.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.iPZ.setVisibility(8);
        if (this.iPY.cvZ() != null) {
            this.iPY.cvZ().cwn();
            this.iPY.cvZ().cwo();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.iPZ.setVisibility(0);
        if (this.iPY.cvZ() != null) {
            this.iPY.cvZ().cwn();
            this.iPY.cvZ().cwo();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.iQb);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.iQb.remove(fVar);
        a(this.iQb, this.iQc, z);
        qd(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cxE() {
        return this.iPZ;
    }

    public void startPullRefresh() {
        this.iPZ.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iHt) {
            this.iQq = true;
            return;
        }
        this.iQq = false;
        this.iPZ.completePullRefreshPostDelayed(0L);
    }

    public void qd(boolean z) {
        this.iQa.notifyDataSetChanged();
        if (this.bMM != null && this.bMM.getLayoutParams() != null) {
            if (z) {
                this.bMM.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bMM.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bo boVar, boolean z) {
        this.iQe.setAdData();
        EnterForumDelegateStatic.iIw.gi(this.mContext);
        this.iQb = list;
        this.iQc = boVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        w wVar = new w();
        wVar.mU(4);
        arrayList.add(wVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(boVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                w wVar2 = new w();
                wVar2.mU(11);
                arrayList.add(wVar2);
            } else {
                w wVar3 = new w();
                wVar3.mU(3);
                arrayList.add(wVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bp(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(boVar.bmW());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            w wVar4 = new w();
            wVar4.mU(5);
            arrayList.add(wVar4);
        }
        hideNoDataView();
        this.iQa.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.iPZ.removeFooterView(this.bMM);
            this.iPZ.addFooterView(this.bMM);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.iPZ.removeFooterView(this.bMM);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.iQf != null) {
            this.iQf.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bMM, R.color.CAM_X0201);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.iQl = cVar;
    }

    public void cxF() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.iPY != null && this.iPY.getActivity() != null && this.iPY.cvY() != null) {
            if (this.iQd == null) {
                this.iQd = new CommonTipView(this.iPY.getActivity());
            }
            this.iQd.setText(R.string.enter_forum_login_tip);
            this.iQd.c(this.iPY.cvY(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.iPY.isAdded() && this.iPY.isPrimary()) {
            iQg = false;
            if (this.iQa != null) {
                this.iQa.onPrimary();
                if (this.iPZ != null) {
                    Object itemAtPosition = this.iPZ.getItemAtPosition(this.iPZ.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof w) && ((w) itemAtPosition).getItemViewType() == 5) {
                        this.iQa.cuT();
                    }
                }
            }
            if (this.iQu) {
                this.iQe.requestFocus();
                this.iQe.requestFocusFromTouch();
                return;
            }
            return;
        }
        cxG();
    }

    public void onPause() {
        cxG();
    }

    public void onDestroy() {
        if (this.iQd != null) {
            this.iQd.onDestroy();
        }
        if (this.iQa != null) {
            this.iQa.onDestroy();
        }
    }

    public void xx(int i) {
        this.iQa.xx(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iQa != null) {
            this.iQa.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cuS() {
        if (this.iQa == null) {
            return false;
        }
        return this.iQa.cuS();
    }

    public void a(w wVar, View view) {
        if (TbadkCoreApplication.isLogin() && !iQg && this.iPY.getActivity() != null && this.iPY.getPageContext() != null && (wVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) wVar;
            if (fVar.isPrivateForum() != 0 && fVar.cvk() != 0 && !com.baidu.tbadk.core.sharedPref.b.brQ().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.iQh = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.brQ().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.iQh = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                iQg = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.iQh);
                        b.this.iPY.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.iDj = dVar.lF();
                this.iDj.setShouldCheckLocInWindow(false);
                this.iDj.setUseDirectOffset(true);
                this.iDj.show(this.iPY.getActivity());
                if (this.iQh == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.iQh == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.iDj != null) {
                            b.this.iDj.dismiss();
                            b.this.iDj = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cxG() {
        if (this.iDj != null) {
            this.iDj.dismiss();
            this.iDj = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iGR = cVar;
        if (this.iQa != null) {
            this.iQa.setAdState(cVar);
        }
        if (cVar != null && cVar.iHt) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.pG(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.pG(R.raw.lottie_common_pull_refresh);
    }

    public void qe(boolean z) {
        if (this.iQj != z) {
            this.iQj = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iPZ.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.iPZ.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.iPZ.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.iPZ.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.iQe != null) {
            this.iQe.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.iQe != null) {
            this.iQe.setRecentlyIsShow(z);
        }
    }

    private void cxH() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.iQs = new View(this.mContext);
        this.iQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.iPY.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.iQs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float iQy = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iQt = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.iQt <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iQt) {
                            b.this.cxI();
                            if (this.iQy < 50.0f) {
                                b.this.iQs.performClick();
                            }
                        } else {
                            b.this.cxJ();
                        }
                        b.this.iQt = 0.0f;
                        this.iQy = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.iQt) {
                            b.this.aJ(motionEvent.getRawY() - b.this.iQt);
                            if (b.this.fyc != null) {
                                b.this.fyc.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.iQt) > this.iQy) {
                            this.iQy = Math.abs(motionEvent.getRawY() - b.this.iQt);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.iQt <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iQt) {
                            b.this.cxI();
                        } else {
                            b.this.cxJ();
                        }
                        b.this.iQt = 0.0f;
                        this.iQy = 0.0f;
                        return true;
                }
            }
        });
        this.fyc = new ImageView(this.mContext);
        this.fyc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cxJ();
            }
        });
    }

    public void cS(final View view) {
        if ((view instanceof FrameLayout) && !this.iQu) {
            this.mPullView.pause();
            this.iQu = true;
            this.iQe.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.fyc, R.drawable.icon_jinba_retract_n);
            final int cxA = cxA();
            ValueAnimator ofInt = ValueAnimator.ofInt(cxA, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.iQe != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iQe.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cxy();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.iQe.setLayoutParams(marginLayoutParams);
                            if (intValue / cxA < 0.2d) {
                                if (b.this.iQe.getParent() != b.this.iQe.getRootView() && (viewGroup = (ViewGroup) b.this.iQe.getRootView()) != null) {
                                    ((ViewGroup) b.this.iQe.getParent()).removeView(b.this.iQe);
                                    if (b.this.iQe.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.iQe, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.iQs);
                                    viewGroup.bringChildToFront(b.this.fyc);
                                }
                            } else if (b.this.iQe.getParent() == b.this.iQe.getRootView()) {
                                if (b.this.iQe.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.iQe.getRootView();
                                    ((ViewGroup) b.this.iQe.getParent()).removeView(b.this.iQe);
                                }
                                if (b.this.iQe.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.iPY.cwc().addView(b.this.iQe, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.iQu = false;
                    b.this.xS(((intValue - cxA) * 2) + 0);
                    b.this.iQu = true;
                    float abs = Math.abs(intValue / cxA);
                    b.this.iPZ.setAlpha(abs);
                    View cwq = b.this.iPY.cvZ().cwq();
                    if (cwq != null) {
                        cwq.setAlpha(abs);
                    }
                    View findViewById = b.this.iPY.cwc().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.iQe != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iQe.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cxy();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.iQe.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.iPZ.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.iQu = false;
                    b.this.xS(0 - (cxA * 2));
                    b.this.iQu = true;
                    b.this.iPZ.setVisibility(8);
                    b.this.iQs.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.iQs.getParent() == null) {
                        frameLayout.addView(b.this.iQs, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.fyc.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.fyc, layoutParams3);
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
            this.iQe.requestFocus();
            this.iQe.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(float f) {
        ViewGroup viewGroup;
        int cxz = cxz();
        float abs = Math.abs(cxz / (cxC() - cxz));
        int i = (int) f;
        if (this.iQe != null) {
            ViewGroup.LayoutParams layoutParams = this.iQe.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cxy();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.iQe.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.iQe.getParent() != this.iQe.getRootView() && (viewGroup = (ViewGroup) this.iQe.getRootView()) != null) {
                        ((ViewGroup) this.iQe.getParent()).removeView(this.iQe);
                        if (this.iQe.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.iQe, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.iQs);
                        viewGroup.bringChildToFront(this.fyc);
                    }
                } else if (this.iQe.getParent() == this.iQe.getRootView()) {
                    if (this.iQe.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.iQe.getRootView();
                        ((ViewGroup) this.iQe.getParent()).removeView(this.iQe);
                    }
                    if (this.iQe.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.iPY.cwc().addView(this.iQe, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.iPZ.setVisibility(0);
        this.iQu = false;
        xS(((int) ((i * abs) - (cxz * abs))) * 2);
        this.iQu = true;
        float abs2 = Math.abs(i / cxz);
        this.iPZ.setAlpha(abs2);
        View cwq = this.iPY.cvZ().cwq();
        if (cwq != null) {
            cwq.setAlpha(abs2);
        }
        View findViewById = this.iPY.cwc().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxI() {
        if (this.fyc != null) {
            this.fyc.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cxA(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aJ(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.aJ(0.0f);
                b.this.mPullView.resume();
                b.this.iPZ.completePullRefresh();
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
    public void cxJ() {
        this.iQs.setEnabled(false);
        int cxz = cxz();
        Math.abs(cxz / (cxC() - cxz));
        this.fyc.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.iQe.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cxA(), cxz);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aJ(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass13());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$13  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass13 implements Animator.AnimatorListener {
        AnonymousClass13() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.iQs.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.iQs);
                        viewGroup.removeView(b.this.fyc);
                    }
                    b.this.fyc.setVisibility(0);
                    b.this.iQu = false;
                    b.this.cxx();
                    b.this.iQo = 0;
                    b.this.xS(0);
                    b.this.iQu = true;
                    b.this.mPullView.resume();
                    b.this.iPZ.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iQu = false;
                        }
                    }, 0L);
                    b.this.iPZ.setVisibility(0);
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
        if (this.iQu) {
            cxJ();
        }
    }

    public void b(com.baidu.tieba.enterForum.a.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cvB())) {
                this.iQv = false;
            } else {
                this.iQv = true;
            }
            this.iQf.setForumId(aVar.cvz());
            this.iQf.O(aVar.cvy(), aVar.cvA());
            this.iQf.gc(aVar.cvx());
            this.iQf.Ab(aVar.cvB());
        }
    }
}
