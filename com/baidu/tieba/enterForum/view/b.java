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
    private static boolean iQu = false;
    private View bMM;
    private ImageView fyc;
    private View gYn;
    private com.baidu.adp.lib.guide.c iDx;
    private ViewEventCenter iHa;
    private com.baidu.tieba.enterForum.data.c iHf;
    private int iJQ;
    private int iOd;
    private View iQG;
    private float iQH;
    private boolean iQJ;
    private final EnterForumFragment iQm;
    private BdListView iQn;
    private com.baidu.tieba.enterForum.adapter.a iQo;
    private List<com.baidu.tieba.enterForum.data.f> iQp;
    private bo iQq;
    private CommonTipView iQr;
    private EnterForumAdView iQs;
    private GuidePopupWindow iQt;
    private int iQv;
    private e iQw;
    private int iQy;
    private f.c iQz;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean iQx = true;
    private f.c gJi = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.iQI) {
                com.baidu.tieba.s.c.dMz().D(b.this.iQm.getUniqueId());
                if (b.this.iQz != null) {
                    b.this.iQz.onListPullRefresh(z);
                }
                if (z && !b.this.iHH && b.this.iHf != null && b.this.iHf.iHH) {
                    if (b.this.iHf.iHJ > 0) {
                        b.this.iQn.smoothScrollToPosition(0, 0, 0);
                        b.this.cxI();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iQn.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int gCX = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.iQw.onScrollStateChanged(absListView, i);
            if (this.gCX != i) {
                this.gCX = i;
                if (this.gCX == 1) {
                    if (b.this.iHf == null || !b.this.iHf.iHH) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cxN();
                    return;
                }
                b.this.cxA();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.iQm.isPrimary() && this.gCX != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.iQn.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof w)) {
                        w wVar = (w) itemAtPosition;
                        if (wVar.getItemViewType() == 1 && b.this.iQn.getItemAtPosition(i4) == y.getItem(b.this.iQp, 0)) {
                            b.this.a(wVar, b.this.iQn.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.iQw.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener iQA = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iHf != null && b.this.iHf.iHH && b.this.iHH) {
                EnterForumAdView unused = b.this.iQs;
                EnterForumAdView.a(b.this.iQm.getUniqueId(), b.this.iQm.getContext());
            }
        }
    };
    private int iQB = 0;
    private int iQC = 0;
    private CustomMessageListener iQD = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cxC();
        }
    };
    boolean iHH = false;
    boolean iQE = false;
    private Runnable iQF = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cxK();
        }
    };
    private boolean iQI = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cxA() {
        if (cxB()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.iHf != null && this.iHf.iHH) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cxB() {
        return this.iQn == null || this.iQn.getChildCount() == 0 || this.iQn.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.iQm = enterForumFragment;
        this.iJQ = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.iOd = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.iQy = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.iHa = viewEventCenter;
        cP(view);
        this.iQo = new com.baidu.tieba.enterForum.adapter.a(this.iQm.getPageContext(), this.iHa, recentlyVisitedForumModel, enterForumModel, this);
        this.iQn.setAdapter((ListAdapter) this.iQo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.iQt = new GuidePopupWindow(this.iQm.getFragmentActivity());
    }

    private void registerListener() {
        this.iQm.registerListener(this.iQD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxC() {
        if (cxD() && this.iQJ) {
            this.iQt.dWg();
            this.iQt.dWf();
            this.iQt.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.iQt, this.iQm.getFragmentActivity());
        }
    }

    private boolean cxD() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cP(View view) {
        this.mContext = view.getContext();
        this.iQw = new e();
        this.iQw.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.iQI) {
                    b.this.iQB = -i;
                    if (b.this.iHH) {
                        b.this.cxK();
                    } else if (b.this.iHf != null && b.this.iHf.iHH) {
                        b.this.cxE();
                    }
                }
            }
        });
        this.iQn = (BdListView) view.findViewById(R.id.listview);
        xS(0);
        this.iQn.setBackgroundColor(0);
        this.iQn.setVerticalScrollBarEnabled(false);
        this.iQn.setOnScrollListener(this.mOnScrollListener);
        this.iQn.setFastScrollEnabled(false);
        this.iQn.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        BdListView bdListView = this.iQn;
        BdListView.setPullRefreshRatio(1.0f);
        if (this.iQm.cwg() != null) {
            this.iQm.cwg().a(this);
        }
        this.mPullView = new g(this.iQm.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.iQC = i3;
                if (!b.this.iHH && b.this.iHf != null && b.this.iHf.iHH && !b.this.iQI) {
                    b.this.cxE();
                    if (i3 > b.this.iQy) {
                        b.this.iQC = 0;
                        b.this.cS(b.this.iQm.cwg().getRootView());
                    }
                }
            }
        });
        this.mPullView.jZ(true);
        this.mPullView.setListPullRefreshListener(this.gJi);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.iQm.getUniqueId());
        }
        this.iQn.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.iQm.getPageContext().getPageActivity());
        this.gYn = new View(this.iQm.getPageContext().getPageActivity());
        frameLayout.addView(this.gYn, new FrameLayout.LayoutParams(-1, this.iOd));
        this.iQn.getAdapter2().addHeaderView(frameLayout, 0);
        this.bMM = new View(this.iQm.getActivity());
        this.bMM.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.iQm.getActivity(), R.dimen.ds50)));
        this.bMM.setBackgroundResource(R.color.CAM_X0201);
        this.mPullView.setOnClickListener(this.iQA);
        this.mPullView.getView().setOnClickListener(this.iQA);
        this.gYn.setOnClickListener(this.iQA);
        cxO();
    }

    public void cQ(View view) {
        this.iQs = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.iQs != null) {
            cxE();
            this.iQs.setTag(this.iQm.getUniqueId());
            this.iQs.setAdData();
            this.iQs.setEventCenter(this.iHa);
            this.iQs.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxE() {
        if (!this.iQI && this.iQs != null) {
            ViewGroup.LayoutParams layoutParams = this.iQs.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cxF = cxF();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iHH ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iQB + this.iQC) - cxF, 0, 0);
                this.iQs.setLayoutParams(layoutParams2);
                this.iQs.setAdViewHeight(layoutParams2.height - cxF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxF() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cxG() {
        return this.iHH ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iQB + this.iQC) - cxF();
    }

    private int cxH() {
        ViewGroup.LayoutParams layoutParams = this.iQs.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cxI() {
        if (!this.iQI) {
            this.iHH = true;
            cxE();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.iQs != null) {
                if (!this.iQs.cxx()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.iQs.cxw()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            xS(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.iQF);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.iQF, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xS(int i) {
        if (!this.iQI) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iQn.getLayoutParams();
            marginLayoutParams.topMargin = ((this.iJQ + i) - this.iOd) - (EnterForumDelegateStatic.iIK.cwG() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.iQn.setLayoutParams(marginLayoutParams);
        }
    }

    private int cxJ() {
        return (this.iJQ - this.iOd) - (EnterForumDelegateStatic.iIK.cwG() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxK() {
        this.iHH = false;
        cxE();
        xS(0);
        if (this.iQE) {
            this.iQn.completePullRefreshPostDelayed(0L);
        }
        this.iQE = false;
    }

    public void cR(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.iQm.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.iQm.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.iQn.setVisibility(8);
        if (this.iQm.cwg() != null) {
            this.iQm.cwg().cwu();
            this.iQm.cwg().cwv();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.iQn.setVisibility(0);
        if (this.iQm.cwg() != null) {
            this.iQm.cwg().cwu();
            this.iQm.cwg().cwv();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.iQp);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.iQp.remove(fVar);
        a(this.iQp, this.iQq, z);
        qd(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cxL() {
        return this.iQn;
    }

    public void startPullRefresh() {
        this.iQn.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iHH) {
            this.iQE = true;
            return;
        }
        this.iQE = false;
        this.iQn.completePullRefreshPostDelayed(0L);
    }

    public void qd(boolean z) {
        this.iQo.notifyDataSetChanged();
        if (this.bMM != null && this.bMM.getLayoutParams() != null) {
            if (z) {
                this.bMM.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bMM.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bo boVar, boolean z) {
        this.iQs.setAdData();
        EnterForumDelegateStatic.iIK.gi(this.mContext);
        this.iQp = list;
        this.iQq = boVar;
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
        this.iQo.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.iQn.removeFooterView(this.bMM);
            this.iQn.addFooterView(this.bMM);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.iQn.removeFooterView(this.bMM);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.iQt != null) {
            this.iQt.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bMM, R.color.CAM_X0201);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.iQz = cVar;
    }

    public void cxM() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.iQm != null && this.iQm.getActivity() != null && this.iQm.cwf() != null) {
            if (this.iQr == null) {
                this.iQr = new CommonTipView(this.iQm.getActivity());
            }
            this.iQr.setText(R.string.enter_forum_login_tip);
            this.iQr.c(this.iQm.cwf(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.iQm.isAdded() && this.iQm.isPrimary()) {
            iQu = false;
            if (this.iQo != null) {
                this.iQo.onPrimary();
                if (this.iQn != null) {
                    Object itemAtPosition = this.iQn.getItemAtPosition(this.iQn.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof w) && ((w) itemAtPosition).getItemViewType() == 5) {
                        this.iQo.cva();
                    }
                }
            }
            if (this.iQI) {
                this.iQs.requestFocus();
                this.iQs.requestFocusFromTouch();
                return;
            }
            return;
        }
        cxN();
    }

    public void onPause() {
        cxN();
    }

    public void onDestroy() {
        if (this.iQr != null) {
            this.iQr.onDestroy();
        }
        if (this.iQo != null) {
            this.iQo.onDestroy();
        }
    }

    public void xx(int i) {
        this.iQo.xx(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iQo != null) {
            this.iQo.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cuZ() {
        if (this.iQo == null) {
            return false;
        }
        return this.iQo.cuZ();
    }

    public void a(w wVar, View view) {
        if (TbadkCoreApplication.isLogin() && !iQu && this.iQm.getActivity() != null && this.iQm.getPageContext() != null && (wVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) wVar;
            if (fVar.isPrivateForum() != 0 && fVar.cvr() != 0 && !com.baidu.tbadk.core.sharedPref.b.brQ().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.iQv = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.brQ().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.iQv = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                iQu = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.iQv);
                        b.this.iQm.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.iDx = dVar.lF();
                this.iDx.setShouldCheckLocInWindow(false);
                this.iDx.setUseDirectOffset(true);
                this.iDx.show(this.iQm.getActivity());
                if (this.iQv == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.iQv == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.iDx != null) {
                            b.this.iDx.dismiss();
                            b.this.iDx = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cxN() {
        if (this.iDx != null) {
            this.iDx.dismiss();
            this.iDx = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iHf = cVar;
        if (this.iQo != null) {
            this.iQo.setAdState(cVar);
        }
        if (cVar != null && cVar.iHH) {
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
        if (this.iQx != z) {
            this.iQx = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iQn.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.iQn.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.iQn.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.iQn.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.iQs != null) {
            this.iQs.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.iQs != null) {
            this.iQs.setRecentlyIsShow(z);
        }
    }

    private void cxO() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.iQG = new View(this.mContext);
        this.iQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.iQm.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.iQG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float iQM = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iQH = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.iQH <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iQH) {
                            b.this.cxP();
                            if (this.iQM < 50.0f) {
                                b.this.iQG.performClick();
                            }
                        } else {
                            b.this.cxQ();
                        }
                        b.this.iQH = 0.0f;
                        this.iQM = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.iQH) {
                            b.this.aJ(motionEvent.getRawY() - b.this.iQH);
                            if (b.this.fyc != null) {
                                b.this.fyc.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.iQH) > this.iQM) {
                            this.iQM = Math.abs(motionEvent.getRawY() - b.this.iQH);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.iQH <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iQH) {
                            b.this.cxP();
                        } else {
                            b.this.cxQ();
                        }
                        b.this.iQH = 0.0f;
                        this.iQM = 0.0f;
                        return true;
                }
            }
        });
        this.fyc = new ImageView(this.mContext);
        this.fyc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cxQ();
            }
        });
    }

    public void cS(final View view) {
        if ((view instanceof FrameLayout) && !this.iQI) {
            this.mPullView.pause();
            this.iQI = true;
            this.iQs.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.fyc, R.drawable.icon_jinba_retract_n);
            final int cxH = cxH();
            ValueAnimator ofInt = ValueAnimator.ofInt(cxH, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.iQs != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iQs.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cxF();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.iQs.setLayoutParams(marginLayoutParams);
                            if (intValue / cxH < 0.2d) {
                                if (b.this.iQs.getParent() != b.this.iQs.getRootView() && (viewGroup = (ViewGroup) b.this.iQs.getRootView()) != null) {
                                    ((ViewGroup) b.this.iQs.getParent()).removeView(b.this.iQs);
                                    if (b.this.iQs.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.iQs, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.iQG);
                                    viewGroup.bringChildToFront(b.this.fyc);
                                }
                            } else if (b.this.iQs.getParent() == b.this.iQs.getRootView()) {
                                if (b.this.iQs.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.iQs.getRootView();
                                    ((ViewGroup) b.this.iQs.getParent()).removeView(b.this.iQs);
                                }
                                if (b.this.iQs.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.iQm.cwj().addView(b.this.iQs, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.iQI = false;
                    b.this.xS(((intValue - cxH) * 2) + 0);
                    b.this.iQI = true;
                    float abs = Math.abs(intValue / cxH);
                    b.this.iQn.setAlpha(abs);
                    View cwx = b.this.iQm.cwg().cwx();
                    if (cwx != null) {
                        cwx.setAlpha(abs);
                    }
                    View findViewById = b.this.iQm.cwj().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.iQs != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iQs.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cxF();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.iQs.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.iQn.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.iQI = false;
                    b.this.xS(0 - (cxH * 2));
                    b.this.iQI = true;
                    b.this.iQn.setVisibility(8);
                    b.this.iQG.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.iQG.getParent() == null) {
                        frameLayout.addView(b.this.iQG, new FrameLayout.LayoutParams(-1, -1));
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
            this.iQs.requestFocus();
            this.iQs.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(float f) {
        ViewGroup viewGroup;
        int cxG = cxG();
        float abs = Math.abs(cxG / (cxJ() - cxG));
        int i = (int) f;
        if (this.iQs != null) {
            ViewGroup.LayoutParams layoutParams = this.iQs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cxF();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.iQs.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.iQs.getParent() != this.iQs.getRootView() && (viewGroup = (ViewGroup) this.iQs.getRootView()) != null) {
                        ((ViewGroup) this.iQs.getParent()).removeView(this.iQs);
                        if (this.iQs.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.iQs, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.iQG);
                        viewGroup.bringChildToFront(this.fyc);
                    }
                } else if (this.iQs.getParent() == this.iQs.getRootView()) {
                    if (this.iQs.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.iQs.getRootView();
                        ((ViewGroup) this.iQs.getParent()).removeView(this.iQs);
                    }
                    if (this.iQs.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.iQm.cwj().addView(this.iQs, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.iQn.setVisibility(0);
        this.iQI = false;
        xS(((int) ((i * abs) - (cxG * abs))) * 2);
        this.iQI = true;
        float abs2 = Math.abs(i / cxG);
        this.iQn.setAlpha(abs2);
        View cwx = this.iQm.cwg().cwx();
        if (cwx != null) {
            cwx.setAlpha(abs2);
        }
        View findViewById = this.iQm.cwj().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxP() {
        if (this.fyc != null) {
            this.fyc.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cxH(), 0);
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
                b.this.iQn.completePullRefresh();
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
    public void cxQ() {
        this.iQG.setEnabled(false);
        int cxG = cxG();
        Math.abs(cxG / (cxJ() - cxG));
        this.fyc.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.iQs.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cxH(), cxG);
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
                    ViewGroup viewGroup = (ViewGroup) b.this.iQG.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.iQG);
                        viewGroup.removeView(b.this.fyc);
                    }
                    b.this.fyc.setVisibility(0);
                    b.this.iQI = false;
                    b.this.cxE();
                    b.this.iQC = 0;
                    b.this.xS(0);
                    b.this.iQI = true;
                    b.this.mPullView.resume();
                    b.this.iQn.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iQI = false;
                        }
                    }, 0L);
                    b.this.iQn.setVisibility(0);
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
        if (this.iQI) {
            cxQ();
        }
    }

    public void b(com.baidu.tieba.enterForum.a.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cvI())) {
                this.iQJ = false;
            } else {
                this.iQJ = true;
            }
            this.iQt.setForumId(aVar.cvG());
            this.iQt.O(aVar.cvF(), aVar.cvH());
            this.iQt.gc(aVar.cvE());
            this.iQt.Ab(aVar.cvI());
        }
    }
}
