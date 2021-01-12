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
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private static boolean iKy = false;
    private View bJc;
    private ImageView fvM;
    private View gVp;
    private ViewEventCenter iBc;
    private com.baidu.tieba.enterForum.data.c iBh;
    private int iDS;
    private int iIh;
    private e iKA;
    private int iKC;
    private f.c iKD;
    private View iKK;
    private float iKL;
    private boolean iKN;
    private final EnterForumFragment iKq;
    private BdListView iKr;
    private com.baidu.tieba.enterForum.adapter.a iKs;
    private List<com.baidu.tieba.enterForum.data.f> iKt;
    private bm iKu;
    private CommonTipView iKv;
    private EnterForumAdView iKw;
    private GuidePopupWindow iKx;
    private int iKz;
    private com.baidu.adp.lib.guide.c ixz;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean iKB = true;
    private f.c gGk = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.iKM) {
                com.baidu.tieba.s.c.dKg().C(b.this.iKq.getUniqueId());
                if (b.this.iKD != null) {
                    b.this.iKD.onListPullRefresh(z);
                }
                if (z && !b.this.iBJ && b.this.iBh != null && b.this.iBh.iBJ) {
                    if (b.this.iBh.iBL > 0) {
                        b.this.iKr.smoothScrollToPosition(0, 0, 0);
                        b.this.cwp();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iKr.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int gzZ = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.iKA.onScrollStateChanged(absListView, i);
            if (this.gzZ != i) {
                this.gzZ = i;
                if (this.gzZ == 1) {
                    if (b.this.iBh == null || !b.this.iBh.iBJ) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cwu();
                    return;
                }
                b.this.cwh();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.iKq.isPrimary() && this.gzZ != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.iKr.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof v)) {
                        v vVar = (v) itemAtPosition;
                        if (vVar.getItemViewType() == 1 && b.this.iKr.getItemAtPosition(i4) == x.getItem(b.this.iKt, 0)) {
                            b.this.a(vVar, b.this.iKr.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.iKA.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener iKE = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iBh != null && b.this.iBh.iBJ && b.this.iBJ) {
                EnterForumAdView unused = b.this.iKw;
                EnterForumAdView.a(b.this.iKq.getUniqueId(), b.this.iKq.getContext());
            }
        }
    };
    private int iKF = 0;
    private int iKG = 0;
    private CustomMessageListener iKH = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cwj();
        }
    };
    boolean iBJ = false;
    boolean iKI = false;
    private Runnable iKJ = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cwr();
        }
    };
    private boolean iKM = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cwh() {
        if (cwi()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.iBh != null && this.iBh.iBJ) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cwi() {
        return this.iKr == null || this.iKr.getChildCount() == 0 || this.iKr.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.iKq = enterForumFragment;
        this.iDS = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.iIh = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.iKC = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.iBc = viewEventCenter;
        cR(view);
        this.iKs = new com.baidu.tieba.enterForum.adapter.a(this.iKq.getPageContext(), this.iBc, recentlyVisitedForumModel, enterForumModel, this);
        this.iKr.setAdapter((ListAdapter) this.iKs);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.iKx = new GuidePopupWindow(this.iKq.getFragmentActivity());
    }

    private void registerListener() {
        this.iKq.registerListener(this.iKH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwj() {
        if (cwk() && this.iKN) {
            this.iKx.dTK();
            this.iKx.dTJ();
            this.iKx.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.iKx, this.iKq.getFragmentActivity());
        }
    }

    private boolean cwk() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cR(View view) {
        this.mContext = view.getContext();
        this.iKA = new e();
        this.iKA.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.iKM) {
                    b.this.iKF = -i;
                    if (b.this.iBJ) {
                        b.this.cwr();
                    } else if (b.this.iBh != null && b.this.iBh.iBJ) {
                        b.this.cwl();
                    }
                }
            }
        });
        this.iKr = (BdListView) view.findViewById(R.id.listview);
        xI(0);
        this.iKr.setBackgroundColor(0);
        this.iKr.setVerticalScrollBarEnabled(false);
        this.iKr.setOnScrollListener(this.mOnScrollListener);
        this.iKr.setFastScrollEnabled(false);
        this.iKr.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        BdListView bdListView = this.iKr;
        BdListView.setPullRefreshRatio(1.0f);
        if (this.iKq.cuN() != null) {
            this.iKq.cuN().a(this);
        }
        this.mPullView = new g(this.iKq.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.iKG = i3;
                if (!b.this.iBJ && b.this.iBh != null && b.this.iBh.iBJ && !b.this.iKM) {
                    b.this.cwl();
                    if (i3 > b.this.iKC) {
                        b.this.iKG = 0;
                        b.this.cU(b.this.iKq.cuN().getRootView());
                    }
                }
            }
        });
        this.mPullView.jW(true);
        this.mPullView.setListPullRefreshListener(this.gGk);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.iKq.getUniqueId());
        }
        this.iKr.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.iKq.getPageContext().getPageActivity());
        this.gVp = new View(this.iKq.getPageContext().getPageActivity());
        frameLayout.addView(this.gVp, new FrameLayout.LayoutParams(-1, this.iIh));
        this.iKr.getAdapter2().addHeaderView(frameLayout, 0);
        this.bJc = new View(this.iKq.getActivity());
        this.bJc.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.iKq.getActivity(), R.dimen.ds50)));
        this.bJc.setBackgroundResource(R.color.CAM_X0201);
        this.mPullView.setOnClickListener(this.iKE);
        this.mPullView.getView().setOnClickListener(this.iKE);
        this.gVp.setOnClickListener(this.iKE);
        cwv();
    }

    public void cS(View view) {
        this.iKw = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.iKw != null) {
            cwl();
            this.iKw.setTag(this.iKq.getUniqueId());
            this.iKw.setAdData();
            this.iKw.setEventCenter(this.iBc);
            this.iKw.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwl() {
        if (!this.iKM && this.iKw != null) {
            ViewGroup.LayoutParams layoutParams = this.iKw.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cwm = cwm();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iBJ ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iKF + this.iKG) - cwm, 0, 0);
                this.iKw.setLayoutParams(layoutParams2);
                this.iKw.setAdViewHeight(layoutParams2.height - cwm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cwm() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cwn() {
        return this.iBJ ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iKF + this.iKG) - cwm();
    }

    private int cwo() {
        ViewGroup.LayoutParams layoutParams = this.iKw.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cwp() {
        if (!this.iKM) {
            this.iBJ = true;
            cwl();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.iKw != null) {
                if (!this.iKw.cwe()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.iKw.cwd()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            xI(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.iKJ);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.iKJ, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xI(int i) {
        if (!this.iKM) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iKr.getLayoutParams();
            marginLayoutParams.topMargin = ((this.iDS + i) - this.iIh) - (EnterForumDelegateStatic.iCM.cvn() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.iKr.setLayoutParams(marginLayoutParams);
        }
    }

    private int cwq() {
        return (this.iDS - this.iIh) - (EnterForumDelegateStatic.iCM.cvn() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwr() {
        this.iBJ = false;
        cwl();
        xI(0);
        if (this.iKI) {
            this.iKr.completePullRefreshPostDelayed(0L);
        }
        this.iKI = false;
    }

    public void cT(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.iKq.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.iKq.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.iKr.setVisibility(8);
        if (this.iKq.cuN() != null) {
            this.iKq.cuN().cvb();
            this.iKq.cuN().cvc();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.iKr.setVisibility(0);
        if (this.iKq.cuN() != null) {
            this.iKq.cuN().cvb();
            this.iKq.cuN().cvc();
        }
    }

    public boolean isEmpty() {
        return x.isEmpty(this.iKt);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.iKt.remove(fVar);
        a(this.iKt, this.iKu, z);
        pT(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cws() {
        return this.iKr;
    }

    public void startPullRefresh() {
        this.iKr.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iBJ) {
            this.iKI = true;
            return;
        }
        this.iKI = false;
        this.iKr.completePullRefreshPostDelayed(0L);
    }

    public void pT(boolean z) {
        this.iKs.notifyDataSetChanged();
        if (this.bJc != null && this.bJc.getLayoutParams() != null) {
            if (z) {
                this.bJc.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bJc.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bm bmVar, boolean z) {
        this.iKw.setAdData();
        EnterForumDelegateStatic.iCM.gh(this.mContext);
        this.iKt = list;
        this.iKu = bmVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !x.isEmpty(list);
        boolean z3 = !x.isEmpty(list);
        v vVar = new v();
        vVar.mR(4);
        arrayList.add(vVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(bmVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                v vVar2 = new v();
                vVar2.mR(11);
                arrayList.add(vVar2);
            } else {
                v vVar3 = new v();
                vVar3.mR(3);
                arrayList.add(vVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bn(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bmVar.bmD());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            v vVar4 = new v();
            vVar4.mR(5);
            arrayList.add(vVar4);
        }
        hideNoDataView();
        this.iKs.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.iKr.removeFooterView(this.bJc);
            this.iKr.addFooterView(this.bJc);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.iKr.removeFooterView(this.bJc);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.iKx != null) {
            this.iKx.onChangeSkinType();
        }
        ao.setBackgroundResource(this.bJc, R.color.CAM_X0201);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.iKD = cVar;
    }

    public void cwt() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.iKq != null && this.iKq.getActivity() != null && this.iKq.cuM() != null) {
            if (this.iKv == null) {
                this.iKv = new CommonTipView(this.iKq.getActivity());
            }
            this.iKv.setText(R.string.enter_forum_login_tip);
            this.iKv.c(this.iKq.cuM(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.iKq.isAdded() && this.iKq.isPrimary()) {
            iKy = false;
            if (this.iKs != null) {
                this.iKs.onPrimary();
                if (this.iKr != null) {
                    Object itemAtPosition = this.iKr.getItemAtPosition(this.iKr.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof v) && ((v) itemAtPosition).getItemViewType() == 5) {
                        this.iKs.ctH();
                    }
                }
            }
            if (this.iKM) {
                this.iKw.requestFocus();
                this.iKw.requestFocusFromTouch();
                return;
            }
            return;
        }
        cwu();
    }

    public void onPause() {
        cwu();
    }

    public void onDestroy() {
        if (this.iKv != null) {
            this.iKv.onDestroy();
        }
        if (this.iKs != null) {
            this.iKs.onDestroy();
        }
    }

    public void xn(int i) {
        this.iKs.xn(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iKs != null) {
            this.iKs.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean ctG() {
        if (this.iKs == null) {
            return false;
        }
        return this.iKs.ctG();
    }

    public void a(v vVar, View view) {
        if (TbadkCoreApplication.isLogin() && !iKy && this.iKq.getActivity() != null && this.iKq.getPageContext() != null && (vVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
            if (fVar.isPrivateForum() != 0 && fVar.ctY() != 0 && !com.baidu.tbadk.core.sharedPref.b.brx().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.iKz = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.brx().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.iKz = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                iKy = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.iKz);
                        b.this.iKq.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.ixz = dVar.lG();
                this.ixz.setShouldCheckLocInWindow(false);
                this.ixz.setUseDirectOffset(true);
                this.ixz.show(this.iKq.getActivity());
                if (this.iKz == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.iKz == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.brx().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.ixz != null) {
                            b.this.ixz.dismiss();
                            b.this.ixz = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cwu() {
        if (this.ixz != null) {
            this.ixz.dismiss();
            this.ixz = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iBh = cVar;
        if (this.iKs != null) {
            this.iKs.setAdState(cVar);
        }
        if (cVar != null && cVar.iBJ) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.pB(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.pB(R.raw.lottie_common_pull_refresh);
    }

    public void pU(boolean z) {
        if (this.iKB != z) {
            this.iKB = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iKr.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.iKr.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.iKr.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.iKr.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.iKw != null) {
            this.iKw.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.iKw != null) {
            this.iKw.setRecentlyIsShow(z);
        }
    }

    private void cwv() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.iKK = new View(this.mContext);
        this.iKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.iKq.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.iKK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float iKQ = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iKL = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.iKL <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iKL) {
                            b.this.cww();
                            if (this.iKQ < 50.0f) {
                                b.this.iKK.performClick();
                            }
                        } else {
                            b.this.cwx();
                        }
                        b.this.iKL = 0.0f;
                        this.iKQ = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.iKL) {
                            b.this.aG(motionEvent.getRawY() - b.this.iKL);
                            if (b.this.fvM != null) {
                                b.this.fvM.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.iKL) > this.iKQ) {
                            this.iKQ = Math.abs(motionEvent.getRawY() - b.this.iKL);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.iKL <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iKL) {
                            b.this.cww();
                        } else {
                            b.this.cwx();
                        }
                        b.this.iKL = 0.0f;
                        this.iKQ = 0.0f;
                        return true;
                }
            }
        });
        this.fvM = new ImageView(this.mContext);
        this.fvM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cwx();
            }
        });
    }

    public void cU(final View view) {
        if ((view instanceof FrameLayout) && !this.iKM) {
            this.mPullView.pause();
            this.iKM = true;
            this.iKw.getAdImageView().getLocationInWindow(new int[2]);
            ao.setImageResource(this.fvM, R.drawable.icon_jinba_retract_n);
            final int cwo = cwo();
            ValueAnimator ofInt = ValueAnimator.ofInt(cwo, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.iKw != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iKw.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cwm();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.iKw.setLayoutParams(marginLayoutParams);
                            if (intValue / cwo < 0.2d) {
                                if (b.this.iKw.getParent() != b.this.iKw.getRootView() && (viewGroup = (ViewGroup) b.this.iKw.getRootView()) != null) {
                                    ((ViewGroup) b.this.iKw.getParent()).removeView(b.this.iKw);
                                    if (b.this.iKw.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.iKw, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.iKK);
                                    viewGroup.bringChildToFront(b.this.fvM);
                                }
                            } else if (b.this.iKw.getParent() == b.this.iKw.getRootView()) {
                                if (b.this.iKw.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.iKw.getRootView();
                                    ((ViewGroup) b.this.iKw.getParent()).removeView(b.this.iKw);
                                }
                                if (b.this.iKw.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.iKq.cuQ().addView(b.this.iKw, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.iKM = false;
                    b.this.xI(((intValue - cwo) * 2) + 0);
                    b.this.iKM = true;
                    float abs = Math.abs(intValue / cwo);
                    b.this.iKr.setAlpha(abs);
                    View cve = b.this.iKq.cuN().cve();
                    if (cve != null) {
                        cve.setAlpha(abs);
                    }
                    View findViewById = b.this.iKq.cuQ().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.iKw != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iKw.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cwm();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.iKw.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.iKr.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.iKM = false;
                    b.this.xI(0 - (cwo * 2));
                    b.this.iKM = true;
                    b.this.iKr.setVisibility(8);
                    b.this.iKK.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.iKK.getParent() == null) {
                        frameLayout.addView(b.this.iKK, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.fvM.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.fvM, layoutParams3);
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
            this.iKw.requestFocus();
            this.iKw.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        ViewGroup viewGroup;
        int cwn = cwn();
        float abs = Math.abs(cwn / (cwq() - cwn));
        int i = (int) f;
        if (this.iKw != null) {
            ViewGroup.LayoutParams layoutParams = this.iKw.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cwm();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.iKw.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.iKw.getParent() != this.iKw.getRootView() && (viewGroup = (ViewGroup) this.iKw.getRootView()) != null) {
                        ((ViewGroup) this.iKw.getParent()).removeView(this.iKw);
                        if (this.iKw.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.iKw, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.iKK);
                        viewGroup.bringChildToFront(this.fvM);
                    }
                } else if (this.iKw.getParent() == this.iKw.getRootView()) {
                    if (this.iKw.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.iKw.getRootView();
                        ((ViewGroup) this.iKw.getParent()).removeView(this.iKw);
                    }
                    if (this.iKw.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.iKq.cuQ().addView(this.iKw, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.iKr.setVisibility(0);
        this.iKM = false;
        xI(((int) ((i * abs) - (cwn * abs))) * 2);
        this.iKM = true;
        float abs2 = Math.abs(i / cwn);
        this.iKr.setAlpha(abs2);
        View cve = this.iKq.cuN().cve();
        if (cve != null) {
            cve.setAlpha(abs2);
        }
        View findViewById = this.iKq.cuQ().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cww() {
        if (this.fvM != null) {
            this.fvM.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cwo(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aG(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.aG(0.0f);
                b.this.mPullView.resume();
                b.this.iKr.completePullRefresh();
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
    public void cwx() {
        this.iKK.setEnabled(false);
        int cwn = cwn();
        Math.abs(cwn / (cwq() - cwn));
        this.fvM.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.iKw.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cwo(), cwn);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aG(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.iKK.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.iKK);
                        viewGroup.removeView(b.this.fvM);
                    }
                    b.this.fvM.setVisibility(0);
                    b.this.iKM = false;
                    b.this.cwl();
                    b.this.iKG = 0;
                    b.this.xI(0);
                    b.this.iKM = true;
                    b.this.mPullView.resume();
                    b.this.iKr.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iKM = false;
                        }
                    }, 0L);
                    b.this.iKr.setVisibility(0);
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
        if (this.iKM) {
            cwx();
        }
    }

    public void b(com.baidu.tieba.enterForum.a.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cup())) {
                this.iKN = false;
            } else {
                this.iKN = true;
            }
            this.iKx.setForumId(aVar.cun());
            this.iKx.K(aVar.cum(), aVar.cuo());
            this.iKx.ge(aVar.cul());
            this.iKx.zK(aVar.cup());
        }
    }
}
