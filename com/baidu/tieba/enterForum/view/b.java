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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.c;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.enterForum.view.e;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements EnterForumAdView.a {
    private static boolean fXk = false;
    private View azg;
    private ImageView dpf;
    private View eAb;
    private com.baidu.adp.lib.guide.c fNi;
    private ViewEventCenter fQN;
    private com.baidu.tieba.enterForum.data.b fQS;
    private int fTx;
    private int fWG;
    private final EnterForumFragment fXd;
    private BdListView fXe;
    private com.baidu.tieba.enterForum.a.a fXf;
    private com.baidu.tieba.enterForum.multiConcern.a fXg;
    private List<com.baidu.tieba.enterForum.data.f> fXh;
    private CommonTipView fXi;
    private EnterForumAdView fXj;
    private int fXl;
    private e fXm;
    private int fXo;
    private g.c fXp;
    private View fXw;
    private float fXx;
    private Context mContext;
    private int mNavHeight;
    private h mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean isFirst = true;
    private boolean fXn = true;
    private g.c eps = new g.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.fXy) {
                com.baidu.tieba.r.c.cIs().z(b.this.fXd.getUniqueId());
                if (b.this.fXp != null) {
                    b.this.fXp.onListPullRefresh(z);
                }
                if (z && !b.this.fRw && b.this.fQS != null && b.this.fQS.fRw) {
                    if (b.this.fQS.fRy > 0) {
                        b.this.fXe.smoothScrollToPosition(0, 0, 0);
                        b.this.bxT();
                        return;
                    }
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fXe.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a fXq = new com.baidu.tbadk.task.a(2921422, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.fXy) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.byb();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921422, Boolean.valueOf(b.this.fXy));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int ejq = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fXm.onScrollStateChanged(absListView, i);
            if (this.ejq != i) {
                this.ejq = i;
                if (this.ejq == 1) {
                    if ((b.this.fQS == null || !b.this.fQS.fRw) && b.this.fXd != null && b.this.fXd.bwG() != null) {
                        b.this.fXd.bwG().bav();
                    }
                    b.this.bxY();
                    return;
                }
                b.this.bxN();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fXd.isPrimary() && this.ejq != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.fXe.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.fXe.getItemAtPosition(i4) == v.getItem(b.this.fXh, 0)) {
                            b.this.a(dVar, b.this.fXe.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fXm.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fWK = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void bwY() {
            b.this.bxN();
        }
    };
    View.OnClickListener fXr = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fQS != null && b.this.fQS.fRw && b.this.fRw) {
                EnterForumAdView unused = b.this.fXj;
                EnterForumAdView.a(b.this.fXd.getUniqueId(), b.this.fXd.getContext());
            }
        }
    };
    private int fXs = 0;
    private int fXt = 0;
    boolean fRw = false;
    boolean fXu = false;
    private Runnable fXv = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bxV();
        }
    };
    private boolean fXy = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bxN() {
        if (bxO()) {
            if (this.fXd != null && this.fXd.bwG() != null) {
                this.fXd.bwG().baw();
            }
        } else if (this.fQS != null && this.fQS.fRw) {
            if (this.fXd != null && this.fXd.bwG() != null) {
                this.fXd.bwG().baw();
            }
        } else if (this.fXd != null && this.fXd.bwG() != null) {
            this.fXd.bwG().bav();
        }
    }

    private boolean bxO() {
        return this.fXe == null || this.fXe.getChildCount() == 0 || this.fXe.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fXd = enterForumFragment;
        this.fTx = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.fWG = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.fXo = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.fQN = viewEventCenter;
        this.fXg = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bJ(view);
        this.fXf = new com.baidu.tieba.enterForum.a.a(this.fXd.getPageContext(), this.fQN, recentlyVisitedForumModel, enterForumModel, this);
        this.fXe.setAdapter((ListAdapter) this.fXf);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.mContext = view.getContext();
        this.fXm = new e();
        this.fXm.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.fXy) {
                    if (b.this.fXd.bwG().bwT() == 1) {
                        b.this.fXd.bwG().e(absListView, 0, i2, 0, 0);
                    }
                    b.this.fXs = -i;
                    if (b.this.fRw) {
                        b.this.bxV();
                    } else if (b.this.fQS != null && b.this.fQS.fRw) {
                        b.this.bxP();
                    }
                }
            }
        });
        this.fXe = (BdListView) view.findViewById(R.id.listview);
        rT(0);
        this.fXe.setBackgroundColor(0);
        this.fXe.setVerticalScrollBarEnabled(false);
        this.fXe.setOnScrollListener(this.mOnScrollListener);
        this.fXe.setFastScrollEnabled(false);
        this.fXe.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fXd.bwG() != null) {
            this.fXd.bwG().b(this.fWK);
            this.fXd.bwG().a(this.fWK);
            this.fXd.bwG().a(this);
        }
        this.mPullView = new h(this.fXd.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.fXt = i3;
                if (!b.this.fRw && b.this.fQS != null && b.this.fQS.fRw && !b.this.fXy) {
                    b.this.bxP();
                    if (i3 > b.this.fXo) {
                        b.this.fXt = 0;
                        b.this.bM(b.this.fXd.bwG().getRootView());
                    }
                }
            }
        });
        this.mPullView.fL(true);
        this.mPullView.setListPullRefreshListener(this.eps);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fXd.getUniqueId());
        }
        this.fXe.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.fXd.getPageContext().getPageActivity());
        this.eAb = new View(this.fXd.getPageContext().getPageActivity());
        frameLayout.addView(this.eAb, new FrameLayout.LayoutParams(-1, this.fWG));
        this.fXe.getAdapter2().addHeaderView(frameLayout, 0);
        this.azg = new View(this.fXd.getActivity());
        this.azg.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.fXd.getActivity(), R.dimen.ds50)));
        this.azg.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.fXr);
        this.mPullView.getView().setOnClickListener(this.fXr);
        this.eAb.setOnClickListener(this.fXr);
        bxZ();
    }

    public void bK(View view) {
        this.fXj = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fXj != null) {
            bxP();
            this.fXj.setTag(this.fXd.getUniqueId());
            this.fXj.setAdData();
            this.fXj.setEventCenter(this.fQN);
            this.fXj.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxP() {
        if (!this.fXy && this.fXj != null) {
            ViewGroup.LayoutParams layoutParams = this.fXj.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bxQ = bxQ();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.fRw ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fXs + this.fXt) - bxQ, 0, 0);
                this.fXj.setLayoutParams(layoutParams2);
                this.fXj.setAdViewHeight(layoutParams2.height - bxQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bxQ() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bxR() {
        return this.fRw ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fXs + this.fXt) - bxQ();
    }

    private int bxS() {
        ViewGroup.LayoutParams layoutParams = this.fXj.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bxT() {
        if (!this.fXy) {
            this.fRw = true;
            bxP();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.fXj != null) {
                if (!this.fXj.bxK()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.fXj.bxJ()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            rT(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fXv);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fXv, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT(int i) {
        if (!this.fXy) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fXe.getLayoutParams();
            marginLayoutParams.topMargin = ((this.fTx + i) - this.fWG) - (EnterForumDelegateStatic.fSo.bxe() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.fXe.setLayoutParams(marginLayoutParams);
        }
    }

    private int bxU() {
        return (this.fTx - this.fWG) - (EnterForumDelegateStatic.fSo.bxe() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxV() {
        this.fRw = false;
        bxP();
        rT(0);
        if (this.fXu) {
            this.fXe.completePullRefreshPostDelayed(0L);
        }
        this.fXu = false;
    }

    public void bL(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.fXd.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.fXd.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.fXe.setVisibility(8);
        if (this.fXd.bwG() != null) {
            this.fXd.bwG().bwU();
            this.fXd.bwG().bwV();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.fXe.setVisibility(0);
        if (this.fXd.bwG() != null) {
            this.fXd.bwG().bwU();
            this.fXd.bwG().bwV();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.fXh);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fXh.remove(fVar);
        m(this.fXh, z);
        kK(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bxW() {
        return this.fXe;
    }

    public void startPullRefresh() {
        this.fXe.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.fRw) {
            this.fXu = true;
            return;
        }
        this.fXu = false;
        this.fXe.completePullRefreshPostDelayed(0L);
    }

    public void kK(boolean z) {
        this.fXf.notifyDataSetChanged();
        if (this.azg != null && this.azg.getLayoutParams() != null) {
            if (z) {
                this.azg.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.azg.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void m(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fXj.setAdData();
        EnterForumDelegateStatic.fSo.eK(this.mContext);
        this.fXh = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
        dVar.setType(4);
        arrayList.add(dVar);
        arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), !v.isEmpty(list)));
        arrayList.addAll(list);
        if (v.isEmpty(list)) {
            com.baidu.tieba.enterForum.data.d dVar2 = new com.baidu.tieba.enterForum.data.d();
            dVar2.setType(3);
            arrayList.add(dVar2);
        }
        if (z) {
            com.baidu.tieba.enterForum.data.d dVar3 = new com.baidu.tieba.enterForum.data.d();
            dVar3.setType(5);
            arrayList.add(dVar3);
        }
        hideNoDataView();
        this.fXf.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.fXe.removeFooterView(this.azg);
            this.fXe.addFooterView(this.azg);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.fXe.removeFooterView(this.azg);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fXg.bxq() != null) {
            this.fXg.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.azg, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.fXp = cVar;
    }

    public void bxX() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.fXd != null && this.fXd.getActivity() != null && this.fXd.bwF() != null) {
            if (this.fXi == null) {
                this.fXi = new CommonTipView(this.fXd.getActivity());
            }
            this.fXi.setText(R.string.enter_forum_login_tip);
            this.fXi.c(this.fXd.bwF(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.fXd.isAdded() && this.fXd.isPrimary()) {
            this.fXq.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.fXq.getCmd());
            MessageManager.getInstance().registerTask(this.fXq);
            this.fXj.setAdData();
            fXk = false;
            if (this.fXf != null) {
                this.fXf.onPrimary();
                if (this.fXe != null) {
                    Object itemAtPosition = this.fXe.getItemAtPosition(this.fXe.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fXf.bvY();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.fXy) {
                this.fXj.requestFocus();
                this.fXj.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.fXq.getCmd());
        bxY();
    }

    public void onPause() {
        bxY();
    }

    public void onDestroy() {
        if (this.fXi != null) {
            this.fXi.onDestroy();
        }
        if (this.fXg != null) {
            this.fXg.onDestroy();
        }
        if (this.fXf != null) {
            this.fXf.onDestroy();
        }
        if (this.fXd != null && this.fXd.bwG() != null) {
            this.fXd.bwG().b(this.fWK);
        }
    }

    public void rD(int i) {
        this.fXf.rD(i);
    }

    public void bT(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.fXg.isShowing() && !v.isEmpty(list)) {
            this.fXg.bP(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fXf != null) {
            this.fXf.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bvX() {
        if (this.fXf == null) {
            return false;
        }
        return this.fXf.bvX();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fXk && this.fXd.getActivity() != null && this.fXd.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bwn() != 0 && !com.baidu.tbadk.core.sharedPref.b.aDr().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fXl = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aDr().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fXl = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fXk = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).J(0).F(true).G(false).E(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fXl);
                        b.this.fXd.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                dVar2.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.fNi = dVar2.fI();
                this.fNi.setShouldCheckLocInWindow(false);
                this.fNi.setUseDirectOffset(true);
                this.fNi.show(this.fXd.getActivity());
                if (this.fXl == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fXl == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.fNi != null) {
                            b.this.fNi.dismiss();
                            b.this.fNi = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bxY() {
        if (this.fNi != null) {
            this.fNi.dismiss();
            this.fNi = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fQS = bVar;
        if (this.fXf != null) {
            this.fXf.setAdState(bVar);
        }
        if (bVar != null && bVar.fRw) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.kU(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.kU(R.raw.lottie_common_pull_refresh);
    }

    public void kL(boolean z) {
        if (this.fXn != z) {
            this.fXn = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fXe.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.fXe.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.fXe.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.fXe.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fXj != null) {
            this.fXj.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fXj != null) {
            this.fXj.setRecentlyIsShow(z);
        }
    }

    private void bxZ() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.fXw = new View(this.mContext);
        this.fXw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.fXd.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.fXw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float fXB = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fXx = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.fXx <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fXx) {
                            b.this.bya();
                            if (this.fXB < 50.0f) {
                                b.this.fXw.performClick();
                            }
                        } else {
                            b.this.byb();
                        }
                        b.this.fXx = 0.0f;
                        this.fXB = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.fXx) {
                            b.this.ay(motionEvent.getRawY() - b.this.fXx);
                            if (b.this.dpf != null) {
                                b.this.dpf.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.fXx) > this.fXB) {
                            this.fXB = Math.abs(motionEvent.getRawY() - b.this.fXx);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.fXx <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fXx) {
                            b.this.bya();
                        } else {
                            b.this.byb();
                        }
                        b.this.fXx = 0.0f;
                        this.fXB = 0.0f;
                        return true;
                }
            }
        });
        this.dpf = new ImageView(this.mContext);
        this.dpf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.byb();
            }
        });
    }

    public void bM(final View view) {
        if ((view instanceof FrameLayout) && !this.fXy) {
            this.mPullView.pause();
            this.fXy = true;
            this.fXj.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.dpf, R.drawable.icon_jinba_retract_n);
            final int bxS = bxS();
            ValueAnimator ofInt = ValueAnimator.ofInt(bxS, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.fXj != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fXj.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bxQ();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.fXj.setLayoutParams(marginLayoutParams);
                            if (intValue / bxS < 0.2d) {
                                if (b.this.fXj.getParent() != b.this.fXj.getRootView() && (viewGroup = (ViewGroup) b.this.fXj.getRootView()) != null) {
                                    ((ViewGroup) b.this.fXj.getParent()).removeView(b.this.fXj);
                                    if (b.this.fXj.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.fXj, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.fXw);
                                    viewGroup.bringChildToFront(b.this.dpf);
                                }
                            } else if (b.this.fXj.getParent() == b.this.fXj.getRootView()) {
                                if (b.this.fXj.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.fXj.getRootView();
                                    ((ViewGroup) b.this.fXj.getParent()).removeView(b.this.fXj);
                                }
                                if (b.this.fXj.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.fXd.bwI().addView(b.this.fXj, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.fXy = false;
                    b.this.rT(((intValue - bxS) * 2) + 0);
                    b.this.fXy = true;
                    float abs = Math.abs(intValue / bxS);
                    b.this.fXe.setAlpha(abs);
                    View bwX = b.this.fXd.bwG().bwX();
                    if (bwX != null) {
                        bwX.setAlpha(abs);
                    }
                    View findViewById = b.this.fXd.bwI().getRootView().findViewById(R.id.tabcontainer_wrapper);
                    if (findViewById != null) {
                        findViewById.setAlpha(abs);
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.fXj != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fXj.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bxQ();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.fXj.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.fXe.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.fXy = false;
                    b.this.rT(0 - (bxS * 2));
                    b.this.fXy = true;
                    b.this.fXe.setVisibility(8);
                    b.this.fXw.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.fXw.getParent() == null) {
                        frameLayout.addView(b.this.fXw, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.dpf.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.dpf, layoutParams3);
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
            this.fXj.requestFocus();
            this.fXj.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(float f) {
        ViewGroup viewGroup;
        int bxR = bxR();
        float abs = Math.abs(bxR / (bxU() - bxR));
        int i = (int) f;
        if (this.fXj != null) {
            ViewGroup.LayoutParams layoutParams = this.fXj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bxQ();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.fXj.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.fXj.getParent() != this.fXj.getRootView() && (viewGroup = (ViewGroup) this.fXj.getRootView()) != null) {
                        ((ViewGroup) this.fXj.getParent()).removeView(this.fXj);
                        if (this.fXj.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.fXj, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.fXw);
                        viewGroup.bringChildToFront(this.dpf);
                    }
                } else if (this.fXj.getParent() == this.fXj.getRootView()) {
                    if (this.fXj.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.fXj.getRootView();
                        ((ViewGroup) this.fXj.getParent()).removeView(this.fXj);
                    }
                    if (this.fXj.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.fXd.bwI().addView(this.fXj, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.fXe.setVisibility(0);
        this.fXy = false;
        rT(((int) ((i * abs) - (bxR * abs))) * 2);
        this.fXy = true;
        float abs2 = Math.abs(i / bxR);
        this.fXe.setAlpha(abs2);
        View bwX = this.fXd.bwG().bwX();
        if (bwX != null) {
            bwX.setAlpha(abs2);
        }
        View findViewById = this.fXd.bwI().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bya() {
        if (this.dpf != null) {
            this.dpf.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bxS(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ay(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ay(0.0f);
                b.this.mPullView.resume();
                b.this.fXe.completePullRefresh();
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
    public void byb() {
        this.fXw.setEnabled(false);
        int bxR = bxR();
        Math.abs(bxR / (bxU() - bxR));
        this.dpf.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.fXj.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bxS(), bxR);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ay(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass14());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$14  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass14 implements Animator.AnimatorListener {
        AnonymousClass14() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.fXw.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.fXw);
                        viewGroup.removeView(b.this.dpf);
                    }
                    b.this.dpf.setVisibility(0);
                    b.this.fXy = false;
                    b.this.bxP();
                    b.this.fXt = 0;
                    b.this.rT(0);
                    b.this.fXy = true;
                    b.this.mPullView.resume();
                    b.this.fXe.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fXy = false;
                        }
                    }, 0L);
                    b.this.fXe.setVisibility(0);
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
        if (this.fXy) {
            byb();
        }
    }
}
