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
    private static boolean iSd = false;
    private View bOm;
    private ImageView fzB;
    private View gZW;
    private com.baidu.adp.lib.guide.c iFg;
    private ViewEventCenter iIJ;
    private com.baidu.tieba.enterForum.data.c iIO;
    private int iLz;
    private int iPM;
    private final EnterForumFragment iRV;
    private BdListView iRW;
    private com.baidu.tieba.enterForum.adapter.a iRX;
    private List<com.baidu.tieba.enterForum.data.f> iRY;
    private bo iRZ;
    private CommonTipView iSa;
    private EnterForumAdView iSb;
    private GuidePopupWindow iSc;
    private int iSe;
    private e iSf;
    private int iSh;
    private f.c iSi;
    private View iSp;
    private float iSq;
    private boolean iSs;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean iSg = true;
    private f.c gKR = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.iSr) {
                com.baidu.tieba.s.c.dMH().E(b.this.iRV.getUniqueId());
                if (b.this.iSi != null) {
                    b.this.iSi.onListPullRefresh(z);
                }
                if (z && !b.this.iJq && b.this.iIO != null && b.this.iIO.iJq) {
                    if (b.this.iIO.iJs > 0) {
                        b.this.iRW.smoothScrollToPosition(0, 0, 0);
                        b.this.cxO();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iRW.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int gEG = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.iSf.onScrollStateChanged(absListView, i);
            if (this.gEG != i) {
                this.gEG = i;
                if (this.gEG == 1) {
                    if (b.this.iIO == null || !b.this.iIO.iJq) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cxT();
                    return;
                }
                b.this.cxG();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.iRV.isPrimary() && this.gEG != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.iRW.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof w)) {
                        w wVar = (w) itemAtPosition;
                        if (wVar.getItemViewType() == 1 && b.this.iRW.getItemAtPosition(i4) == y.getItem(b.this.iRY, 0)) {
                            b.this.a(wVar, b.this.iRW.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.iSf.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener iSj = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iIO != null && b.this.iIO.iJq && b.this.iJq) {
                EnterForumAdView unused = b.this.iSb;
                EnterForumAdView.a(b.this.iRV.getUniqueId(), b.this.iRV.getContext());
            }
        }
    };
    private int iSk = 0;
    private int iSl = 0;
    private CustomMessageListener iSm = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cxI();
        }
    };
    boolean iJq = false;
    boolean iSn = false;
    private Runnable iSo = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cxQ();
        }
    };
    private boolean iSr = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cxG() {
        if (cxH()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.iIO != null && this.iIO.iJq) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cxH() {
        return this.iRW == null || this.iRW.getChildCount() == 0 || this.iRW.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.iRV = enterForumFragment;
        this.iLz = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.iPM = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.iSh = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.iIJ = viewEventCenter;
        cP(view);
        this.iRX = new com.baidu.tieba.enterForum.adapter.a(this.iRV.getPageContext(), this.iIJ, recentlyVisitedForumModel, enterForumModel, this);
        this.iRW.setAdapter((ListAdapter) this.iRX);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.iSc = new GuidePopupWindow(this.iRV.getFragmentActivity());
    }

    private void registerListener() {
        this.iRV.registerListener(this.iSm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxI() {
        if (cxJ() && this.iSs) {
            this.iSc.dWo();
            this.iSc.dWn();
            this.iSc.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.iSc, this.iRV.getFragmentActivity());
        }
    }

    private boolean cxJ() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cP(View view) {
        this.mContext = view.getContext();
        this.iSf = new e();
        this.iSf.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.iSr) {
                    b.this.iSk = -i;
                    if (b.this.iJq) {
                        b.this.cxQ();
                    } else if (b.this.iIO != null && b.this.iIO.iJq) {
                        b.this.cxK();
                    }
                }
            }
        });
        this.iRW = (BdListView) view.findViewById(R.id.listview);
        xT(0);
        this.iRW.setBackgroundColor(0);
        this.iRW.setVerticalScrollBarEnabled(false);
        this.iRW.setOnScrollListener(this.mOnScrollListener);
        this.iRW.setFastScrollEnabled(false);
        this.iRW.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        BdListView bdListView = this.iRW;
        BdListView.setPullRefreshRatio(1.0f);
        if (this.iRV.cwm() != null) {
            this.iRV.cwm().a(this);
        }
        this.mPullView = new g(this.iRV.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.iSl = i3;
                if (!b.this.iJq && b.this.iIO != null && b.this.iIO.iJq && !b.this.iSr) {
                    b.this.cxK();
                    if (i3 > b.this.iSh) {
                        b.this.iSl = 0;
                        b.this.cS(b.this.iRV.cwm().getRootView());
                    }
                }
            }
        });
        this.mPullView.jZ(true);
        this.mPullView.setListPullRefreshListener(this.gKR);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.iRV.getUniqueId());
        }
        this.iRW.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.iRV.getPageContext().getPageActivity());
        this.gZW = new View(this.iRV.getPageContext().getPageActivity());
        frameLayout.addView(this.gZW, new FrameLayout.LayoutParams(-1, this.iPM));
        this.iRW.getAdapter2().addHeaderView(frameLayout, 0);
        this.bOm = new View(this.iRV.getActivity());
        this.bOm.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.iRV.getActivity(), R.dimen.ds50)));
        this.bOm.setBackgroundResource(R.color.CAM_X0201);
        this.mPullView.setOnClickListener(this.iSj);
        this.mPullView.getView().setOnClickListener(this.iSj);
        this.gZW.setOnClickListener(this.iSj);
        cxU();
    }

    public void cQ(View view) {
        this.iSb = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.iSb != null) {
            cxK();
            this.iSb.setTag(this.iRV.getUniqueId());
            this.iSb.setAdData();
            this.iSb.setEventCenter(this.iIJ);
            this.iSb.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxK() {
        if (!this.iSr && this.iSb != null) {
            ViewGroup.LayoutParams layoutParams = this.iSb.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cxL = cxL();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iJq ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iSk + this.iSl) - cxL, 0, 0);
                this.iSb.setLayoutParams(layoutParams2);
                this.iSb.setAdViewHeight(layoutParams2.height - cxL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxL() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cxM() {
        return this.iJq ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iSk + this.iSl) - cxL();
    }

    private int cxN() {
        ViewGroup.LayoutParams layoutParams = this.iSb.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cxO() {
        if (!this.iSr) {
            this.iJq = true;
            cxK();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.iSb != null) {
                if (!this.iSb.cxD()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.iSb.cxC()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            xT(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.iSo);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.iSo, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xT(int i) {
        if (!this.iSr) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iRW.getLayoutParams();
            marginLayoutParams.topMargin = ((this.iLz + i) - this.iPM) - (EnterForumDelegateStatic.iKt.cwM() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.iRW.setLayoutParams(marginLayoutParams);
        }
    }

    private int cxP() {
        return (this.iLz - this.iPM) - (EnterForumDelegateStatic.iKt.cwM() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxQ() {
        this.iJq = false;
        cxK();
        xT(0);
        if (this.iSn) {
            this.iRW.completePullRefreshPostDelayed(0L);
        }
        this.iSn = false;
    }

    public void cR(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.iRV.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.iRV.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.iRW.setVisibility(8);
        if (this.iRV.cwm() != null) {
            this.iRV.cwm().cwA();
            this.iRV.cwm().cwB();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.iRW.setVisibility(0);
        if (this.iRV.cwm() != null) {
            this.iRV.cwm().cwA();
            this.iRV.cwm().cwB();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.iRY);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.iRY.remove(fVar);
        a(this.iRY, this.iRZ, z);
        qd(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cxR() {
        return this.iRW;
    }

    public void startPullRefresh() {
        this.iRW.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iJq) {
            this.iSn = true;
            return;
        }
        this.iSn = false;
        this.iRW.completePullRefreshPostDelayed(0L);
    }

    public void qd(boolean z) {
        this.iRX.notifyDataSetChanged();
        if (this.bOm != null && this.bOm.getLayoutParams() != null) {
            if (z) {
                this.bOm.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bOm.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bo boVar, boolean z) {
        this.iSb.setAdData();
        EnterForumDelegateStatic.iKt.gh(this.mContext);
        this.iRY = list;
        this.iRZ = boVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        w wVar = new w();
        wVar.mV(4);
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
                wVar2.mV(11);
                arrayList.add(wVar2);
            } else {
                w wVar3 = new w();
                wVar3.mV(3);
                arrayList.add(wVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bp(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(boVar.bmY());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            w wVar4 = new w();
            wVar4.mV(5);
            arrayList.add(wVar4);
        }
        hideNoDataView();
        this.iRX.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.iRW.removeFooterView(this.bOm);
            this.iRW.addFooterView(this.bOm);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.iRW.removeFooterView(this.bOm);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.iSc != null) {
            this.iSc.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bOm, R.color.CAM_X0201);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.iSi = cVar;
    }

    public void cxS() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.iRV != null && this.iRV.getActivity() != null && this.iRV.cwl() != null) {
            if (this.iSa == null) {
                this.iSa = new CommonTipView(this.iRV.getActivity());
            }
            this.iSa.setText(R.string.enter_forum_login_tip);
            this.iSa.c(this.iRV.cwl(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.iRV.isAdded() && this.iRV.isPrimary()) {
            iSd = false;
            if (this.iRX != null) {
                this.iRX.onPrimary();
                if (this.iRW != null) {
                    Object itemAtPosition = this.iRW.getItemAtPosition(this.iRW.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof w) && ((w) itemAtPosition).getItemViewType() == 5) {
                        this.iRX.cvg();
                    }
                }
            }
            if (this.iSr) {
                this.iSb.requestFocus();
                this.iSb.requestFocusFromTouch();
                return;
            }
            return;
        }
        cxT();
    }

    public void onPause() {
        cxT();
    }

    public void onDestroy() {
        if (this.iSa != null) {
            this.iSa.onDestroy();
        }
        if (this.iRX != null) {
            this.iRX.onDestroy();
        }
    }

    public void xy(int i) {
        this.iRX.xy(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iRX != null) {
            this.iRX.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cvf() {
        if (this.iRX == null) {
            return false;
        }
        return this.iRX.cvf();
    }

    public void a(w wVar, View view) {
        if (TbadkCoreApplication.isLogin() && !iSd && this.iRV.getActivity() != null && this.iRV.getPageContext() != null && (wVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) wVar;
            if (fVar.isPrivateForum() != 0 && fVar.cvx() != 0 && !com.baidu.tbadk.core.sharedPref.b.brR().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.iSe = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.brR().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.iSe = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                iSd = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.iSe);
                        b.this.iRV.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.iFg = dVar.lF();
                this.iFg.setShouldCheckLocInWindow(false);
                this.iFg.setUseDirectOffset(true);
                this.iFg.show(this.iRV.getActivity());
                if (this.iSe == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.iSe == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.iFg != null) {
                            b.this.iFg.dismiss();
                            b.this.iFg = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cxT() {
        if (this.iFg != null) {
            this.iFg.dismiss();
            this.iFg = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iIO = cVar;
        if (this.iRX != null) {
            this.iRX.setAdState(cVar);
        }
        if (cVar != null && cVar.iJq) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.pH(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.pH(R.raw.lottie_common_pull_refresh);
    }

    public void qe(boolean z) {
        if (this.iSg != z) {
            this.iSg = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iRW.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.iRW.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.iRW.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.iRW.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.iSb != null) {
            this.iSb.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.iSb != null) {
            this.iSb.setRecentlyIsShow(z);
        }
    }

    private void cxU() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.iSp = new View(this.mContext);
        this.iSp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.iRV.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.iSp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float iSv = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iSq = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.iSq <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iSq) {
                            b.this.cxV();
                            if (this.iSv < 50.0f) {
                                b.this.iSp.performClick();
                            }
                        } else {
                            b.this.cxW();
                        }
                        b.this.iSq = 0.0f;
                        this.iSv = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.iSq) {
                            b.this.aN(motionEvent.getRawY() - b.this.iSq);
                            if (b.this.fzB != null) {
                                b.this.fzB.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.iSq) > this.iSv) {
                            this.iSv = Math.abs(motionEvent.getRawY() - b.this.iSq);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.iSq <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iSq) {
                            b.this.cxV();
                        } else {
                            b.this.cxW();
                        }
                        b.this.iSq = 0.0f;
                        this.iSv = 0.0f;
                        return true;
                }
            }
        });
        this.fzB = new ImageView(this.mContext);
        this.fzB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cxW();
            }
        });
    }

    public void cS(final View view) {
        if ((view instanceof FrameLayout) && !this.iSr) {
            this.mPullView.pause();
            this.iSr = true;
            this.iSb.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.fzB, R.drawable.icon_jinba_retract_n);
            final int cxN = cxN();
            ValueAnimator ofInt = ValueAnimator.ofInt(cxN, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.iSb != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iSb.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cxL();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.iSb.setLayoutParams(marginLayoutParams);
                            if (intValue / cxN < 0.2d) {
                                if (b.this.iSb.getParent() != b.this.iSb.getRootView() && (viewGroup = (ViewGroup) b.this.iSb.getRootView()) != null) {
                                    ((ViewGroup) b.this.iSb.getParent()).removeView(b.this.iSb);
                                    if (b.this.iSb.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.iSb, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.iSp);
                                    viewGroup.bringChildToFront(b.this.fzB);
                                }
                            } else if (b.this.iSb.getParent() == b.this.iSb.getRootView()) {
                                if (b.this.iSb.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.iSb.getRootView();
                                    ((ViewGroup) b.this.iSb.getParent()).removeView(b.this.iSb);
                                }
                                if (b.this.iSb.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.iRV.cwp().addView(b.this.iSb, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.iSr = false;
                    b.this.xT(((intValue - cxN) * 2) + 0);
                    b.this.iSr = true;
                    float abs = Math.abs(intValue / cxN);
                    b.this.iRW.setAlpha(abs);
                    View cwD = b.this.iRV.cwm().cwD();
                    if (cwD != null) {
                        cwD.setAlpha(abs);
                    }
                    View findViewById = b.this.iRV.cwp().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.iSb != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iSb.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cxL();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.iSb.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.iRW.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.iSr = false;
                    b.this.xT(0 - (cxN * 2));
                    b.this.iSr = true;
                    b.this.iRW.setVisibility(8);
                    b.this.iSp.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.iSp.getParent() == null) {
                        frameLayout.addView(b.this.iSp, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.fzB.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.fzB, layoutParams3);
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
            this.iSb.requestFocus();
            this.iSb.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(float f) {
        ViewGroup viewGroup;
        int cxM = cxM();
        float abs = Math.abs(cxM / (cxP() - cxM));
        int i = (int) f;
        if (this.iSb != null) {
            ViewGroup.LayoutParams layoutParams = this.iSb.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cxL();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.iSb.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.iSb.getParent() != this.iSb.getRootView() && (viewGroup = (ViewGroup) this.iSb.getRootView()) != null) {
                        ((ViewGroup) this.iSb.getParent()).removeView(this.iSb);
                        if (this.iSb.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.iSb, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.iSp);
                        viewGroup.bringChildToFront(this.fzB);
                    }
                } else if (this.iSb.getParent() == this.iSb.getRootView()) {
                    if (this.iSb.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.iSb.getRootView();
                        ((ViewGroup) this.iSb.getParent()).removeView(this.iSb);
                    }
                    if (this.iSb.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.iRV.cwp().addView(this.iSb, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.iRW.setVisibility(0);
        this.iSr = false;
        xT(((int) ((i * abs) - (cxM * abs))) * 2);
        this.iSr = true;
        float abs2 = Math.abs(i / cxM);
        this.iRW.setAlpha(abs2);
        View cwD = this.iRV.cwm().cwD();
        if (cwD != null) {
            cwD.setAlpha(abs2);
        }
        View findViewById = this.iRV.cwp().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxV() {
        if (this.fzB != null) {
            this.fzB.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cxN(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aN(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.aN(0.0f);
                b.this.mPullView.resume();
                b.this.iRW.completePullRefresh();
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
    public void cxW() {
        this.iSp.setEnabled(false);
        int cxM = cxM();
        Math.abs(cxM / (cxP() - cxM));
        this.fzB.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.iSb.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cxN(), cxM);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aN(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
                    ViewGroup viewGroup = (ViewGroup) b.this.iSp.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.iSp);
                        viewGroup.removeView(b.this.fzB);
                    }
                    b.this.fzB.setVisibility(0);
                    b.this.iSr = false;
                    b.this.cxK();
                    b.this.iSl = 0;
                    b.this.xT(0);
                    b.this.iSr = true;
                    b.this.mPullView.resume();
                    b.this.iRW.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iSr = false;
                        }
                    }, 0L);
                    b.this.iRW.setVisibility(0);
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
        if (this.iSr) {
            cxW();
        }
    }

    public void b(com.baidu.tieba.enterForum.a.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cvO())) {
                this.iSs = false;
            } else {
                this.iSs = true;
            }
            this.iSc.setForumId(aVar.cvM());
            this.iSc.O(aVar.cvL(), aVar.cvN());
            this.iSc.gc(aVar.cvK());
            this.iSc.Ai(aVar.cvO());
        }
    }
}
