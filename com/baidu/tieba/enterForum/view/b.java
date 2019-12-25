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
/* loaded from: classes6.dex */
public class b implements EnterForumAdView.a {
    private static boolean fUb = false;
    private View ayx;
    private ImageView doU;
    private View eyQ;
    private com.baidu.adp.lib.guide.c fJZ;
    private ViewEventCenter fNE;
    private com.baidu.tieba.enterForum.data.b fNJ;
    private int fQo;
    private final EnterForumFragment fTU;
    private BdListView fTV;
    private com.baidu.tieba.enterForum.a.a fTW;
    private com.baidu.tieba.enterForum.multiConcern.a fTX;
    private List<com.baidu.tieba.enterForum.data.f> fTY;
    private CommonTipView fTZ;
    private int fTx;
    private EnterForumAdView fUa;
    private int fUc;
    private e fUd;
    private int fUf;
    private g.c fUg;
    private View fUn;
    private float fUo;
    private Context mContext;
    private int mNavHeight;
    private h mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean isFirst = true;
    private boolean fUe = true;
    private g.c eoe = new g.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.fUp) {
                com.baidu.tieba.r.c.cHo().z(b.this.fTU.getUniqueId());
                if (b.this.fUg != null) {
                    b.this.fUg.onListPullRefresh(z);
                }
                if (z && !b.this.fOn && b.this.fNJ != null && b.this.fNJ.fOn) {
                    if (b.this.fNJ.fOp > 0) {
                        b.this.fTV.smoothScrollToPosition(0, 0, 0);
                        b.this.bwR();
                        return;
                    }
                    com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fTV.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a fUh = new com.baidu.tbadk.task.a(2921422, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.fUp) {
                com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bwZ();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921422, Boolean.valueOf(b.this.fUp));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int eiC = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fUd.onScrollStateChanged(absListView, i);
            if (this.eiC != i) {
                this.eiC = i;
                if (this.eiC == 1) {
                    if ((b.this.fNJ == null || !b.this.fNJ.fOn) && b.this.fTU != null && b.this.fTU.bvE() != null) {
                        b.this.fTU.bvE().aZW();
                    }
                    b.this.bwW();
                    return;
                }
                b.this.bwL();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fTU.isPrimary() && this.eiC != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.fTV.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.fTV.getItemAtPosition(i4) == v.getItem(b.this.fTY, 0)) {
                            b.this.a(dVar, b.this.fTV.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fUd.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fTB = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void bvW() {
            b.this.bwL();
        }
    };
    View.OnClickListener fUi = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fNJ != null && b.this.fNJ.fOn && b.this.fOn) {
                EnterForumAdView unused = b.this.fUa;
                EnterForumAdView.a(b.this.fTU.getUniqueId(), b.this.fTU.getContext());
            }
        }
    };
    private int fUj = 0;
    private int fUk = 0;
    boolean fOn = false;
    boolean fUl = false;
    private Runnable fUm = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bwT();
        }
    };
    private boolean fUp = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bwL() {
        if (bwM()) {
            if (this.fTU != null && this.fTU.bvE() != null) {
                this.fTU.bvE().aZX();
            }
        } else if (this.fNJ != null && this.fNJ.fOn) {
            if (this.fTU != null && this.fTU.bvE() != null) {
                this.fTU.bvE().aZX();
            }
        } else if (this.fTU != null && this.fTU.bvE() != null) {
            this.fTU.bvE().aZW();
        }
    }

    private boolean bwM() {
        return this.fTV == null || this.fTV.getChildCount() == 0 || this.fTV.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fTU = enterForumFragment;
        this.fQo = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.fTx = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.fUf = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.fNE = viewEventCenter;
        this.fTX = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bE(view);
        this.fTW = new com.baidu.tieba.enterForum.a.a(this.fTU.getPageContext(), this.fNE, recentlyVisitedForumModel, enterForumModel, this);
        this.fTV.setAdapter((ListAdapter) this.fTW);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bE(View view) {
        this.mContext = view.getContext();
        this.fUd = new e();
        this.fUd.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.fUp) {
                    if (b.this.fTU.bvE().bvR() == 1) {
                        b.this.fTU.bvE().e(absListView, 0, i2, 0, 0);
                    }
                    b.this.fUj = -i;
                    if (b.this.fOn) {
                        b.this.bwT();
                    } else if (b.this.fNJ != null && b.this.fNJ.fOn) {
                        b.this.bwN();
                    }
                }
            }
        });
        this.fTV = (BdListView) view.findViewById(R.id.listview);
        rO(0);
        this.fTV.setBackgroundColor(0);
        this.fTV.setVerticalScrollBarEnabled(false);
        this.fTV.setOnScrollListener(this.mOnScrollListener);
        this.fTV.setFastScrollEnabled(false);
        this.fTV.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fTU.bvE() != null) {
            this.fTU.bvE().b(this.fTB);
            this.fTU.bvE().a(this.fTB);
            this.fTU.bvE().a(this);
        }
        this.mPullView = new h(this.fTU.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.fUk = i3;
                if (!b.this.fOn && b.this.fNJ != null && b.this.fNJ.fOn && !b.this.fUp) {
                    b.this.bwN();
                    if (i3 > b.this.fUf) {
                        b.this.fUk = 0;
                        b.this.bH(b.this.fTU.bvE().getRootView());
                    }
                }
            }
        });
        this.mPullView.fG(true);
        this.mPullView.setListPullRefreshListener(this.eoe);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fTU.getUniqueId());
        }
        this.fTV.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.fTU.getPageContext().getPageActivity());
        this.eyQ = new View(this.fTU.getPageContext().getPageActivity());
        frameLayout.addView(this.eyQ, new FrameLayout.LayoutParams(-1, this.fTx));
        this.fTV.getAdapter2().addHeaderView(frameLayout, 0);
        this.ayx = new View(this.fTU.getActivity());
        this.ayx.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.fTU.getActivity(), R.dimen.ds50)));
        this.ayx.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.fUi);
        this.mPullView.getView().setOnClickListener(this.fUi);
        this.eyQ.setOnClickListener(this.fUi);
        bwX();
    }

    public void bF(View view) {
        this.fUa = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fUa != null) {
            bwN();
            this.fUa.setTag(this.fTU.getUniqueId());
            this.fUa.setAdData();
            this.fUa.setEventCenter(this.fNE);
            this.fUa.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwN() {
        if (!this.fUp && this.fUa != null) {
            ViewGroup.LayoutParams layoutParams = this.fUa.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bwO = bwO();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.fOn ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fUj + this.fUk) - bwO, 0, 0);
                this.fUa.setLayoutParams(layoutParams2);
                this.fUa.setAdViewHeight(layoutParams2.height - bwO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bwO() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bwP() {
        return this.fOn ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fUj + this.fUk) - bwO();
    }

    private int bwQ() {
        ViewGroup.LayoutParams layoutParams = this.fUa.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bwR() {
        if (!this.fUp) {
            this.fOn = true;
            bwN();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.fUa != null) {
                if (!this.fUa.bwI()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.fUa.bwH()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            rO(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.fUm);
            com.baidu.adp.lib.f.e.gy().postDelayed(this.fUm, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(int i) {
        if (!this.fUp) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fTV.getLayoutParams();
            marginLayoutParams.topMargin = ((this.fQo + i) - this.fTx) - (EnterForumDelegateStatic.fPf.bwc() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.fTV.setLayoutParams(marginLayoutParams);
        }
    }

    private int bwS() {
        return (this.fQo - this.fTx) - (EnterForumDelegateStatic.fPf.bwc() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwT() {
        this.fOn = false;
        bwN();
        rO(0);
        if (this.fUl) {
            this.fTV.completePullRefreshPostDelayed(0L);
        }
        this.fUl = false;
    }

    public void bG(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.fTU.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.fTU.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.fTV.setVisibility(8);
        if (this.fTU.bvE() != null) {
            this.fTU.bvE().bvS();
            this.fTU.bvE().bvT();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.fTV.setVisibility(0);
        if (this.fTU.bvE() != null) {
            this.fTU.bvE().bvS();
            this.fTU.bvE().bvT();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.fTY);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fTY.remove(fVar);
        k(this.fTY, z);
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bwU() {
        return this.fTV;
    }

    public void startPullRefresh() {
        this.fTV.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.fOn) {
            this.fUl = true;
            return;
        }
        this.fUl = false;
        this.fTV.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.fTW.notifyDataSetChanged();
    }

    public void k(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fUa.setAdData();
        EnterForumDelegateStatic.fPf.eK(this.mContext);
        this.fTY = list;
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
        this.fTW.setData(arrayList);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.fTV.removeFooterView(this.ayx);
            this.fTV.addFooterView(this.ayx);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.fTV.removeFooterView(this.ayx);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fTX.bwo() != null) {
            this.fTX.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.ayx, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.fUg = cVar;
    }

    public void bwV() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.fTU != null && this.fTU.getActivity() != null && this.fTU.bvD() != null) {
            if (this.fTZ == null) {
                this.fTZ = new CommonTipView(this.fTU.getActivity());
            }
            this.fTZ.setText(R.string.enter_forum_login_tip);
            this.fTZ.c(this.fTU.bvD(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.fTU.isAdded() && this.fTU.isPrimary()) {
            this.fUh.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.fUh.getCmd());
            MessageManager.getInstance().registerTask(this.fUh);
            this.fUa.setAdData();
            fUb = false;
            if (this.fTW != null) {
                this.fTW.onPrimary();
                if (this.fTV != null) {
                    Object itemAtPosition = this.fTV.getItemAtPosition(this.fTV.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fTW.buW();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.fUp) {
                this.fUa.requestFocus();
                this.fUa.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.fUh.getCmd());
        bwW();
    }

    public void onPause() {
        bwW();
    }

    public void onDestroy() {
        if (this.fTZ != null) {
            this.fTZ.onDestroy();
        }
        if (this.fTX != null) {
            this.fTX.onDestroy();
        }
        if (this.fTW != null) {
            this.fTW.onDestroy();
        }
        if (this.fTU != null && this.fTU.bvE() != null) {
            this.fTU.bvE().b(this.fTB);
        }
    }

    public void ry(int i) {
        this.fTW.ry(i);
    }

    public void bT(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.fTX.isShowing() && !v.isEmpty(list)) {
            this.fTX.bP(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fTW != null) {
            this.fTW.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean buV() {
        if (this.fTW == null) {
            return false;
        }
        return this.fTW.buV();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fUb && this.fTU.getActivity() != null && this.fTU.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bvl() != 0 && !com.baidu.tbadk.core.sharedPref.b.aCY().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fUc = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aCY().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fUc = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fUb = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).J(0).F(true).G(false).E(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fUc);
                        b.this.fTU.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.fJZ = dVar2.fI();
                this.fJZ.setShouldCheckLocInWindow(false);
                this.fJZ.setUseDirectOffset(true);
                this.fJZ.show(this.fTU.getActivity());
                if (this.fUc == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fUc == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.fJZ != null) {
                            b.this.fJZ.dismiss();
                            b.this.fJZ = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bwW() {
        if (this.fJZ != null) {
            this.fJZ.dismiss();
            this.fJZ = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fNJ = bVar;
        if (this.fTW != null) {
            this.fTW.setAdState(bVar);
        }
        if (bVar != null && bVar.fOn) {
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

    public void kz(boolean z) {
        if (this.fUe != z) {
            this.fUe = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fTV.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.fTV.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.fTV.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.fTV.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fUa != null) {
            this.fUa.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fUa != null) {
            this.fUa.setRecentlyIsShow(z);
        }
    }

    private void bwX() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.fUn = new View(this.mContext);
        this.fUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.fTU.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.fUn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float fUs = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fUo = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.fUo <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fUo) {
                            b.this.bwY();
                            if (this.fUs < 50.0f) {
                                b.this.fUn.performClick();
                            }
                        } else {
                            b.this.bwZ();
                        }
                        b.this.fUo = 0.0f;
                        this.fUs = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.fUo) {
                            b.this.az(motionEvent.getRawY() - b.this.fUo);
                            if (b.this.doU != null) {
                                b.this.doU.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.fUo) > this.fUs) {
                            this.fUs = Math.abs(motionEvent.getRawY() - b.this.fUo);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.fUo <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fUo) {
                            b.this.bwY();
                        } else {
                            b.this.bwZ();
                        }
                        b.this.fUo = 0.0f;
                        this.fUs = 0.0f;
                        return true;
                }
            }
        });
        this.doU = new ImageView(this.mContext);
        this.doU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bwZ();
            }
        });
    }

    public void bH(final View view) {
        if ((view instanceof FrameLayout) && !this.fUp) {
            this.mPullView.pause();
            this.fUp = true;
            this.fUa.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.doU, R.drawable.icon_jinba_retract_n);
            final int bwQ = bwQ();
            ValueAnimator ofInt = ValueAnimator.ofInt(bwQ, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.fUa != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fUa.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bwO();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.fUa.setLayoutParams(marginLayoutParams);
                            if (intValue / bwQ < 0.2d) {
                                if (b.this.fUa.getParent() != b.this.fUa.getRootView() && (viewGroup = (ViewGroup) b.this.fUa.getRootView()) != null) {
                                    ((ViewGroup) b.this.fUa.getParent()).removeView(b.this.fUa);
                                    if (b.this.fUa.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.fUa, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.fUn);
                                    viewGroup.bringChildToFront(b.this.doU);
                                }
                            } else if (b.this.fUa.getParent() == b.this.fUa.getRootView()) {
                                if (b.this.fUa.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.fUa.getRootView();
                                    ((ViewGroup) b.this.fUa.getParent()).removeView(b.this.fUa);
                                }
                                if (b.this.fUa.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.fTU.bvG().addView(b.this.fUa, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.fUp = false;
                    b.this.rO(((intValue - bwQ) * 2) + 0);
                    b.this.fUp = true;
                    float abs = Math.abs(intValue / bwQ);
                    b.this.fTV.setAlpha(abs);
                    View bvV = b.this.fTU.bvE().bvV();
                    if (bvV != null) {
                        bvV.setAlpha(abs);
                    }
                    View findViewById = b.this.fTU.bvG().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.fUa != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fUa.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bwO();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.fUa.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.fTV.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.fUp = false;
                    b.this.rO(0 - (bwQ * 2));
                    b.this.fUp = true;
                    b.this.fTV.setVisibility(8);
                    b.this.fUn.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.fUn.getParent() == null) {
                        frameLayout.addView(b.this.fUn, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.doU.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.doU, layoutParams3);
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
            this.fUa.requestFocus();
            this.fUa.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(float f) {
        ViewGroup viewGroup;
        int bwP = bwP();
        float abs = Math.abs(bwP / (bwS() - bwP));
        int i = (int) f;
        if (this.fUa != null) {
            ViewGroup.LayoutParams layoutParams = this.fUa.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bwO();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.fUa.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.fUa.getParent() != this.fUa.getRootView() && (viewGroup = (ViewGroup) this.fUa.getRootView()) != null) {
                        ((ViewGroup) this.fUa.getParent()).removeView(this.fUa);
                        if (this.fUa.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.fUa, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.fUn);
                        viewGroup.bringChildToFront(this.doU);
                    }
                } else if (this.fUa.getParent() == this.fUa.getRootView()) {
                    if (this.fUa.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.fUa.getRootView();
                        ((ViewGroup) this.fUa.getParent()).removeView(this.fUa);
                    }
                    if (this.fUa.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.fTU.bvG().addView(this.fUa, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.fTV.setVisibility(0);
        this.fUp = false;
        rO(((int) ((i * abs) - (bwP * abs))) * 2);
        this.fUp = true;
        float abs2 = Math.abs(i / bwP);
        this.fTV.setAlpha(abs2);
        View bvV = this.fTU.bvE().bvV();
        if (bvV != null) {
            bvV.setAlpha(abs2);
        }
        View findViewById = this.fTU.bvG().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwY() {
        if (this.doU != null) {
            this.doU.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bwQ(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.az(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.az(0.0f);
                b.this.mPullView.resume();
                b.this.fTV.completePullRefresh();
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
    public void bwZ() {
        this.fUn.setEnabled(false);
        int bwP = bwP();
        Math.abs(bwP / (bwS() - bwP));
        this.doU.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.fUa.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bwQ(), bwP);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.az(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass14());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$14  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass14 implements Animator.AnimatorListener {
        AnonymousClass14() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.fUn.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.fUn);
                        viewGroup.removeView(b.this.doU);
                    }
                    b.this.doU.setVisibility(0);
                    b.this.fUp = false;
                    b.this.bwN();
                    b.this.fUk = 0;
                    b.this.rO(0);
                    b.this.fUp = true;
                    b.this.mPullView.resume();
                    b.this.fTV.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fUp = false;
                        }
                    }, 0L);
                    b.this.fTV.setVisibility(0);
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
        if (this.fUp) {
            bwZ();
        }
    }
}
