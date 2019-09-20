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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
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
/* loaded from: classes4.dex */
public class b implements EnterForumAdView.a {
    private static boolean fdE = false;
    private ImageView ahO;
    private com.baidu.adp.lib.guide.c eNC;
    private ViewEventCenter eXb;
    private com.baidu.tieba.enterForum.data.b eXg;
    private int eZQ;
    private BdListView egw;
    private View ewO;
    private List<com.baidu.tieba.enterForum.data.f> fdA;
    private CommonTipView fdB;
    private EnterForumAdView fdC;
    private View fdD;
    private int fdF;
    private e fdG;
    private int fdI;
    private h.c fdJ;
    private View fdQ;
    private float fdR;
    private int fda;
    private final EnterForumFragment fdx;
    private com.baidu.tieba.enterForum.a.a fdy;
    private com.baidu.tieba.enterForum.multiConcern.a fdz;
    private Context mContext;
    private int mNavHeight;
    private i mPullView;
    private View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private boolean isFirst = true;
    private boolean fdH = true;
    private h.c dtw = new h.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            if (!b.this.fdS) {
                com.baidu.tieba.q.c.cpt().x(b.this.fdx.getUniqueId());
                if (b.this.fdJ != null) {
                    b.this.fdJ.eu(z);
                }
                if (z && !b.this.eXL && b.this.eXg != null && b.this.eXg.eXL) {
                    if (b.this.eXg.eXN > 0) {
                        b.this.egw.smoothScrollToPosition(0, 0, 0);
                        b.this.bhG();
                        return;
                    }
                    com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.egw.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a fdK = new com.baidu.tbadk.task.a(2921421, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.fdS) {
                com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bhO();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921421, Boolean.valueOf(b.this.fdS));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int drh = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fdG.onScrollStateChanged(absListView, i);
            if (this.drh != i) {
                this.drh = i;
                if (this.drh == 1) {
                    if ((b.this.eXg == null || !b.this.eXg.eXL) && b.this.fdx != null && b.this.fdx.bgq() != null) {
                        b.this.fdx.bgq().aKa();
                    }
                    b.this.bhL();
                    return;
                }
                b.this.bhA();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fdx.isPrimary() && this.drh != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.egw.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.egw.getItemAtPosition(i4) == v.c(b.this.fdA, 0)) {
                            b.this.a(dVar, b.this.egw.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fdG.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fdd = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void bgL() {
            b.this.bhA();
        }
    };
    View.OnClickListener fdL = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eXg != null && b.this.eXg.eXL && b.this.eXL) {
                EnterForumAdView unused = b.this.fdC;
                EnterForumAdView.a(b.this.fdx.getUniqueId(), b.this.fdx.getContext());
            }
        }
    };
    private int fdM = 0;
    private int fdN = 0;
    boolean eXL = false;
    boolean fdO = false;
    private Runnable fdP = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bhI();
        }
    };
    private boolean fdS = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bhA() {
        if (bhB()) {
            if (this.fdx != null && this.fdx.bgq() != null) {
                this.fdx.bgq().aKb();
            }
        } else if (this.eXg != null && this.eXg.eXL) {
            if (this.fdx != null && this.fdx.bgq() != null) {
                this.fdx.bgq().aKb();
            }
        } else if (this.fdx != null && this.fdx.bgq() != null) {
            this.fdx.bgq().aKa();
        }
    }

    private boolean bhB() {
        return this.egw == null || this.egw.getChildCount() == 0 || this.egw.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fdx = enterForumFragment;
        this.eZQ = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds264);
        this.fda = l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.fdI = l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.eXb = viewEventCenter;
        this.fdz = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bM(view);
        this.fdy = new com.baidu.tieba.enterForum.a.a(this.fdx.getPageContext(), this.eXb, recentlyVisitedForumModel, enterForumModel, this);
        this.egw.setAdapter((ListAdapter) this.fdy);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bM(View view) {
        this.mContext = view.getContext();
        this.fdG = new e();
        this.fdG.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.fdS) {
                    if (b.this.fdx.bgq().bgF() == 1) {
                        b.this.fdx.bgq().d(absListView, 0, i2, 0, 0);
                    }
                    b.this.fdM = -i;
                    if (b.this.eXL) {
                        b.this.bhI();
                    } else if (b.this.eXg != null && b.this.eXg.eXL) {
                        b.this.bhC();
                    }
                }
            }
        });
        this.egw = (BdListView) view.findViewById(R.id.listview);
        qN(0);
        this.egw.setBackgroundColor(0);
        this.egw.setVerticalScrollBarEnabled(false);
        this.egw.setOnScrollListener(this.mOnScrollListener);
        this.egw.setFastScrollEnabled(false);
        this.egw.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fdx.bgq() != null) {
            this.fdx.bgq().b(this.fdd);
            this.fdx.bgq().a(this.fdd);
            this.fdx.bgq().a(this);
        }
        this.mPullView = new i(this.fdx.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.fdN = i3;
                if (!b.this.eXL && b.this.eXg != null && b.this.eXg.eXL && !b.this.fdS) {
                    b.this.bhC();
                    if (i3 > b.this.fdI) {
                        b.this.fdN = 0;
                        b.this.bP(b.this.fdx.bgq().getRootView());
                    }
                }
            }
        });
        this.mPullView.ew(true);
        this.mPullView.setListPullRefreshListener(this.dtw);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fdx.getUniqueId());
        }
        this.egw.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.fdx.getPageContext().getPageActivity());
        this.fdD = new View(this.fdx.getPageContext().getPageActivity());
        frameLayout.addView(this.fdD, new FrameLayout.LayoutParams(-1, this.fda));
        this.egw.getAdapter2().addHeaderView(frameLayout, 0);
        this.ewO = new View(this.fdx.getActivity());
        this.ewO.setLayoutParams(new AbsListView.LayoutParams(-1, l.g(this.fdx.getActivity(), R.dimen.ds50)));
        this.ewO.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.fdL);
        this.mPullView.getView().setOnClickListener(this.fdL);
        this.fdD.setOnClickListener(this.fdL);
        bhM();
    }

    public void bN(View view) {
        this.fdC = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fdC != null) {
            bhC();
            this.fdC.setTag(this.fdx.getUniqueId());
            this.fdC.setAdData();
            this.fdC.setEventCenter(this.eXb);
            this.fdC.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhC() {
        if (!this.fdS && this.fdC != null) {
            ViewGroup.LayoutParams layoutParams = this.fdC.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bhD = bhD();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.eXL ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fdM + this.fdN) - bhD, 0, 0);
                this.fdC.setLayoutParams(layoutParams2);
                this.fdC.setAdViewHeight(layoutParams2.height - bhD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bhD() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bhE() {
        return this.eXL ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fdM + this.fdN) - bhD();
    }

    private int bhF() {
        ViewGroup.LayoutParams layoutParams = this.fdC.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bhG() {
        if (!this.fdS) {
            this.eXL = true;
            bhC();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.oc();
            if (this.fdC != null) {
                if (!this.fdC.bhv()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.fdC.bhu()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            qN(dimensionPixelOffset);
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fdP);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.fdP, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qN(int i) {
        if (!this.fdS) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.egw.getLayoutParams();
            marginLayoutParams.topMargin = ((this.eZQ + i) - this.fda) - (EnterForumDelegateStatic.eYF.bgR() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.egw.setLayoutParams(marginLayoutParams);
        }
    }

    private int bhH() {
        return (this.eZQ - this.fda) - (EnterForumDelegateStatic.eYF.bgR() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhI() {
        this.eXL = false;
        bhC();
        qN(0);
        if (this.fdO) {
            this.egw.completePullRefreshPostDelayed(0L);
        }
        this.fdO = false;
    }

    public void bO(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(this.fdx.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.qY(this.fdx.getString(R.string.neterror));
        this.mRootView = view;
        int dimensionPixelSize = this.fdx.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize += UtilHelper.getStatusBarHeight();
        }
        this.refreshView.kP(dimensionPixelSize);
        this.refreshView.attachView(view, false);
        this.refreshView.atW();
        this.egw.setVisibility(8);
        if (this.fdx.bgq() != null) {
            this.fdx.bgq().bgG();
            this.fdx.bgq().bgH();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.egw.setVisibility(0);
        if (this.fdx.bgq() != null) {
            this.fdx.bgq().bgG();
            this.fdx.bgq().bgH();
        }
    }

    public boolean isEmpty() {
        return v.aa(this.fdA);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fdA.remove(fVar);
        j(this.fdA, z);
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.m.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bhJ() {
        return this.egw;
    }

    public void startPullRefresh() {
        this.egw.startPullRefresh();
    }

    public void oU() {
        if (this.eXL) {
            this.fdO = true;
            return;
        }
        this.fdO = false;
        this.egw.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.fdy.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fdC.setAdData();
        EnterForumDelegateStatic.eYF.dE(this.mContext);
        this.fdA = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
        dVar.setType(4);
        arrayList.add(dVar);
        arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), !v.aa(list)));
        arrayList.addAll(list);
        if (v.aa(list)) {
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
        this.fdy.setData(arrayList);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.egw.removeFooterView(this.ewO);
            this.egw.addFooterView(this.ewO);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.egw.removeFooterView(this.ewO);
        }
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.fdz.bhc() != null) {
            this.fdz.onChangeSkinType();
        }
        am.k(this.ewO, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.fdJ = cVar;
    }

    public void bhK() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("enter_forum_login_tip", true) && this.fdx != null && this.fdx.getActivity() != null && this.fdx.bgp() != null) {
            if (this.fdB == null) {
                this.fdB = new CommonTipView(this.fdx.getActivity());
            }
            this.fdB.setText(R.string.enter_forum_login_tip);
            this.fdB.show(this.fdx.bgp(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.fdx.isAdded() && this.fdx.isPrimary()) {
            this.fdK.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.fdK.getCmd());
            MessageManager.getInstance().registerTask(this.fdK);
            this.fdC.setAdData();
            fdE = false;
            if (this.fdy != null) {
                this.fdy.onPrimary();
                if (this.egw != null) {
                    Object itemAtPosition = this.egw.getItemAtPosition(this.egw.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fdy.bfI();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.fdS) {
                this.fdC.requestFocus();
                this.fdC.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.fdK.getCmd());
        bhL();
    }

    public void onPause() {
        bhL();
    }

    public void onDestroy() {
        if (this.fdB != null) {
            this.fdB.onDestroy();
        }
        if (this.fdz != null) {
            this.fdz.onDestroy();
        }
        if (this.fdy != null) {
            this.fdy.onDestroy();
        }
        if (this.fdx != null && this.fdx.bgq() != null) {
            this.fdx.bgq().b(this.fdd);
        }
    }

    public void qx(int i) {
        this.fdy.qx(i);
    }

    public void bK(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.fdz.isShowing() && !v.aa(list)) {
            this.fdz.bG(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fdy != null) {
            this.fdy.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bfH() {
        if (this.fdy == null) {
            return false;
        }
        return this.fdy.bfH();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fdE && this.fdx.getActivity() != null && this.fdx.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bfX() != 0 && !com.baidu.tbadk.core.sharedPref.b.ahU().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fdF = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.ahU().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fdF = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fdE = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).X(0).U(true).V(false).T(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fdF);
                        b.this.fdx.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hT() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hU() {
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
                this.eNC = dVar2.hV();
                this.eNC.R(false);
                this.eNC.S(true);
                this.eNC.q(this.fdx.getActivity());
                if (this.fdF == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fdF == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.eNC != null) {
                            b.this.eNC.dismiss();
                            b.this.eNC = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bhL() {
        if (this.eNC != null) {
            this.eNC.dismiss();
            this.eNC = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eXg = bVar;
        if (this.fdy != null) {
            this.fdy.setAdState(bVar);
        }
        if (bVar != null && bVar.eXL) {
            this.mPullView.jc(R.raw.ad_refresh_load);
        } else {
            this.mPullView.jc(R.raw.refresh_load);
        }
    }

    public void jy(boolean z) {
        if (this.fdH != z) {
            this.fdH = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.egw.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.egw.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.egw.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.egw.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fdC != null) {
            this.fdC.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fdC != null) {
            this.fdC.setRecentlyIsShow(z);
        }
    }

    private void bhM() {
        this.mNavHeight = l.g(this.mContext, R.dimen.tbds240);
        this.fdQ = new View(this.mContext);
        this.fdQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.fdx.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.fdQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float fdV = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fdR = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.fdR <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fdR) {
                            b.this.bhN();
                            if (this.fdV < 50.0f) {
                                b.this.fdQ.performClick();
                            }
                        } else {
                            b.this.bhO();
                        }
                        b.this.fdR = 0.0f;
                        this.fdV = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.fdR) {
                            b.this.aF(motionEvent.getRawY() - b.this.fdR);
                            if (b.this.ahO != null) {
                                b.this.ahO.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.fdR) > this.fdV) {
                            this.fdV = Math.abs(motionEvent.getRawY() - b.this.fdR);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.fdR <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fdR) {
                            b.this.bhN();
                        } else {
                            b.this.bhO();
                        }
                        b.this.fdR = 0.0f;
                        this.fdV = 0.0f;
                        return true;
                }
            }
        });
        this.ahO = new ImageView(this.mContext);
        this.ahO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bhO();
            }
        });
    }

    public void bP(final View view) {
        if ((view instanceof FrameLayout) && !this.fdS) {
            this.mPullView.pause();
            this.fdS = true;
            this.fdC.getAdImageView().getLocationInWindow(new int[2]);
            am.c(this.ahO, (int) R.drawable.icon_jinba_retract_n);
            final int bhF = bhF();
            ValueAnimator ofInt = ValueAnimator.ofInt(bhF, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.fdC != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fdC.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bhD();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.fdC.setLayoutParams(marginLayoutParams);
                            if (intValue / bhF < 0.2d) {
                                if (b.this.fdC.getParent() != b.this.fdC.getRootView() && (viewGroup = (ViewGroup) b.this.fdC.getRootView()) != null) {
                                    ((ViewGroup) b.this.fdC.getParent()).removeView(b.this.fdC);
                                    if (b.this.fdC.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.fdC, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.fdQ);
                                    viewGroup.bringChildToFront(b.this.ahO);
                                }
                            } else if (b.this.fdC.getParent() == b.this.fdC.getRootView()) {
                                if (b.this.fdC.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.fdC.getRootView();
                                    ((ViewGroup) b.this.fdC.getParent()).removeView(b.this.fdC);
                                }
                                if (b.this.fdC.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.fdx.bgt().addView(b.this.fdC, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.fdS = false;
                    b.this.qN(((intValue - bhF) * 2) + 0);
                    b.this.fdS = true;
                    float abs = Math.abs(intValue / bhF);
                    b.this.egw.setAlpha(abs);
                    View bgK = b.this.fdx.bgq().bgK();
                    if (bgK != null) {
                        bgK.setAlpha(abs);
                    }
                    View findViewById = b.this.fdx.bgt().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.fdC != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fdC.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bhD();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.fdC.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.egw.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.oc(), 0, 0);
                    b.this.fdS = false;
                    b.this.qN(0 - (bhF * 2));
                    b.this.fdS = true;
                    b.this.egw.setVisibility(8);
                    b.this.fdQ.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.fdQ.getParent() == null) {
                        frameLayout.addView(b.this.fdQ, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.ahO.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.ahO, layoutParams3);
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
            this.fdC.requestFocus();
            this.fdC.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(float f) {
        ViewGroup viewGroup;
        int bhE = bhE();
        float abs = Math.abs(bhE / (bhH() - bhE));
        int i = (int) f;
        if (this.fdC != null) {
            ViewGroup.LayoutParams layoutParams = this.fdC.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bhD();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.fdC.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.fdC.getParent() != this.fdC.getRootView() && (viewGroup = (ViewGroup) this.fdC.getRootView()) != null) {
                        ((ViewGroup) this.fdC.getParent()).removeView(this.fdC);
                        if (this.fdC.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.fdC, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.fdQ);
                        viewGroup.bringChildToFront(this.ahO);
                    }
                } else if (this.fdC.getParent() == this.fdC.getRootView()) {
                    if (this.fdC.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.fdC.getRootView();
                        ((ViewGroup) this.fdC.getParent()).removeView(this.fdC);
                    }
                    if (this.fdC.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.fdx.bgt().addView(this.fdC, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.egw.setVisibility(0);
        this.fdS = false;
        qN(((int) ((i * abs) - (bhE * abs))) * 2);
        this.fdS = true;
        float abs2 = Math.abs(i / bhE);
        this.egw.setAlpha(abs2);
        View bgK = this.fdx.bgq().bgK();
        if (bgK != null) {
            bgK.setAlpha(abs2);
        }
        View findViewById = this.fdx.bgt().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhN() {
        if (this.ahO != null) {
            this.ahO.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bhF(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aF(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.aF(0.0f);
                b.this.mPullView.resume();
                b.this.egw.completePullRefresh();
                b.this.mPullView.setPadding(0, -b.this.mPullView.oc(), 0, 0);
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
    public void bhO() {
        this.fdQ.setEnabled(false);
        int bhE = bhE();
        Math.abs(bhE / (bhH() - bhE));
        this.ahO.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.fdC.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bhF(), bhE);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aF(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass14());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$14  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass14 implements Animator.AnimatorListener {
        AnonymousClass14() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.fdQ.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.fdQ);
                        viewGroup.removeView(b.this.ahO);
                    }
                    b.this.ahO.setVisibility(0);
                    b.this.fdS = false;
                    b.this.bhC();
                    b.this.fdN = 0;
                    b.this.qN(0);
                    b.this.fdS = true;
                    b.this.mPullView.resume();
                    b.this.egw.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.oc(), 0, 0);
                    com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fdS = false;
                        }
                    }, 0L);
                    b.this.egw.setVisibility(0);
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
        if (this.fdS) {
            bhO();
        }
    }
}
