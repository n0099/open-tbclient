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
/* loaded from: classes9.dex */
public class b implements EnterForumAdView.a {
    private static boolean fZm = false;
    private View aDx;
    private ImageView dto;
    private View eEt;
    private com.baidu.adp.lib.guide.c fPF;
    private ViewEventCenter fTk;
    private com.baidu.tieba.enterForum.data.b fTp;
    private int fVS;
    private int fYJ;
    private final EnterForumFragment fZg;
    private BdListView fZh;
    private com.baidu.tieba.enterForum.a.a fZi;
    private List<com.baidu.tieba.enterForum.data.f> fZj;
    private CommonTipView fZk;
    private EnterForumAdView fZl;
    private int fZn;
    private e fZo;
    private int fZq;
    private g.c fZr;
    private View fZy;
    private float fZz;
    private Context mContext;
    private int mNavHeight;
    private h mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean isFirst = true;
    private boolean fZp = true;
    private g.c etE = new g.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.fZA) {
                com.baidu.tieba.s.c.cKa().z(b.this.fZg.getUniqueId());
                if (b.this.fZr != null) {
                    b.this.fZr.onListPullRefresh(z);
                }
                if (z && !b.this.fTT && b.this.fTp != null && b.this.fTp.fTT) {
                    if (b.this.fTp.fTV > 0) {
                        b.this.fZh.smoothScrollToPosition(0, 0, 0);
                        b.this.bzx();
                        return;
                    }
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fZh.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a fZs = new com.baidu.tbadk.task.a(2921422, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.fZA) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bzF();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921422, Boolean.valueOf(b.this.fZA));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int enB = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fZo.onScrollStateChanged(absListView, i);
            if (this.enB != i) {
                this.enB = i;
                if (this.enB == 1) {
                    if ((b.this.fTp == null || !b.this.fTp.fTT) && b.this.fZg != null && b.this.fZg.byn() != null) {
                        b.this.fZg.byn().bcM();
                    }
                    b.this.bzC();
                    return;
                }
                b.this.bzr();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fZg.isPrimary() && this.enB != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.fZh.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.fZh.getItemAtPosition(i4) == v.getItem(b.this.fZj, 0)) {
                            b.this.a(dVar, b.this.fZh.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fZo.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fYN = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void byF() {
            b.this.bzr();
        }
    };
    View.OnClickListener fZt = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fTp != null && b.this.fTp.fTT && b.this.fTT) {
                EnterForumAdView unused = b.this.fZl;
                EnterForumAdView.a(b.this.fZg.getUniqueId(), b.this.fZg.getContext());
            }
        }
    };
    private int fZu = 0;
    private int fZv = 0;
    boolean fTT = false;
    boolean fZw = false;
    private Runnable fZx = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bzz();
        }
    };
    private boolean fZA = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bzr() {
        if (bzs()) {
            if (this.fZg != null && this.fZg.byn() != null) {
                this.fZg.byn().bcN();
            }
        } else if (this.fTp != null && this.fTp.fTT) {
            if (this.fZg != null && this.fZg.byn() != null) {
                this.fZg.byn().bcN();
            }
        } else if (this.fZg != null && this.fZg.byn() != null) {
            this.fZg.byn().bcM();
        }
    }

    private boolean bzs() {
        return this.fZh == null || this.fZh.getChildCount() == 0 || this.fZh.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fZg = enterForumFragment;
        this.fVS = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.fYJ = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.fZq = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.fTk = viewEventCenter;
        bJ(view);
        this.fZi = new com.baidu.tieba.enterForum.a.a(this.fZg.getPageContext(), this.fTk, recentlyVisitedForumModel, enterForumModel, this);
        this.fZh.setAdapter((ListAdapter) this.fZi);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.mContext = view.getContext();
        this.fZo = new e();
        this.fZo.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.fZA) {
                    if (b.this.fZg.byn().byA() == 1) {
                        b.this.fZg.byn().e(absListView, 0, i2, 0, 0);
                    }
                    b.this.fZu = -i;
                    if (b.this.fTT) {
                        b.this.bzz();
                    } else if (b.this.fTp != null && b.this.fTp.fTT) {
                        b.this.bzt();
                    }
                }
            }
        });
        this.fZh = (BdListView) view.findViewById(R.id.listview);
        rZ(0);
        this.fZh.setBackgroundColor(0);
        this.fZh.setVerticalScrollBarEnabled(false);
        this.fZh.setOnScrollListener(this.mOnScrollListener);
        this.fZh.setFastScrollEnabled(false);
        this.fZh.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fZg.byn() != null) {
            this.fZg.byn().b(this.fYN);
            this.fZg.byn().a(this.fYN);
            this.fZg.byn().a(this);
        }
        this.mPullView = new h(this.fZg.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.fZv = i3;
                if (!b.this.fTT && b.this.fTp != null && b.this.fTp.fTT && !b.this.fZA) {
                    b.this.bzt();
                    if (i3 > b.this.fZq) {
                        b.this.fZv = 0;
                        b.this.bM(b.this.fZg.byn().getRootView());
                    }
                }
            }
        });
        this.mPullView.fS(true);
        this.mPullView.setListPullRefreshListener(this.etE);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fZg.getUniqueId());
        }
        this.fZh.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.fZg.getPageContext().getPageActivity());
        this.eEt = new View(this.fZg.getPageContext().getPageActivity());
        frameLayout.addView(this.eEt, new FrameLayout.LayoutParams(-1, this.fYJ));
        this.fZh.getAdapter2().addHeaderView(frameLayout, 0);
        this.aDx = new View(this.fZg.getActivity());
        this.aDx.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.fZg.getActivity(), R.dimen.ds50)));
        this.aDx.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.fZt);
        this.mPullView.getView().setOnClickListener(this.fZt);
        this.eEt.setOnClickListener(this.fZt);
        bzD();
    }

    public void bK(View view) {
        this.fZl = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fZl != null) {
            bzt();
            this.fZl.setTag(this.fZg.getUniqueId());
            this.fZl.setAdData();
            this.fZl.setEventCenter(this.fTk);
            this.fZl.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzt() {
        if (!this.fZA && this.fZl != null) {
            ViewGroup.LayoutParams layoutParams = this.fZl.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bzu = bzu();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.fTT ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fZu + this.fZv) - bzu, 0, 0);
                this.fZl.setLayoutParams(layoutParams2);
                this.fZl.setAdViewHeight(layoutParams2.height - bzu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzu() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bzv() {
        return this.fTT ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fZu + this.fZv) - bzu();
    }

    private int bzw() {
        ViewGroup.LayoutParams layoutParams = this.fZl.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bzx() {
        if (!this.fZA) {
            this.fTT = true;
            bzt();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.fZl != null) {
                if (!this.fZl.bzo()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.fZl.bzn()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            rZ(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fZx);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fZx, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ(int i) {
        if (!this.fZA) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fZh.getLayoutParams();
            marginLayoutParams.topMargin = ((this.fVS + i) - this.fYJ) - (EnterForumDelegateStatic.fUK.byL() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.fZh.setLayoutParams(marginLayoutParams);
        }
    }

    private int bzy() {
        return (this.fVS - this.fYJ) - (EnterForumDelegateStatic.fUK.byL() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzz() {
        this.fTT = false;
        bzt();
        rZ(0);
        if (this.fZw) {
            this.fZh.completePullRefreshPostDelayed(0L);
        }
        this.fZw = false;
    }

    public void bL(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.fZg.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.fZg.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.fZh.setVisibility(8);
        if (this.fZg.byn() != null) {
            this.fZg.byn().byB();
            this.fZg.byn().byC();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.fZh.setVisibility(0);
        if (this.fZg.byn() != null) {
            this.fZg.byn().byB();
            this.fZg.byn().byC();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.fZj);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fZj.remove(fVar);
        n(this.fZj, z);
        kO(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bzA() {
        return this.fZh;
    }

    public void startPullRefresh() {
        this.fZh.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.fTT) {
            this.fZw = true;
            return;
        }
        this.fZw = false;
        this.fZh.completePullRefreshPostDelayed(0L);
    }

    public void kO(boolean z) {
        this.fZi.notifyDataSetChanged();
        if (this.aDx != null && this.aDx.getLayoutParams() != null) {
            if (z) {
                this.aDx.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.aDx.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void n(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fZl.setAdData();
        EnterForumDelegateStatic.fUK.eN(this.mContext);
        this.fZj = list;
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
        this.fZi.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.fZh.removeFooterView(this.aDx);
            this.fZh.addFooterView(this.aDx);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.fZh.removeFooterView(this.aDx);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.aDx, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.fZr = cVar;
    }

    public void bzB() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.fZg != null && this.fZg.getActivity() != null && this.fZg.bym() != null) {
            if (this.fZk == null) {
                this.fZk = new CommonTipView(this.fZg.getActivity());
            }
            this.fZk.setText(R.string.enter_forum_login_tip);
            this.fZk.c(this.fZg.bym(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.fZg.isAdded() && this.fZg.isPrimary()) {
            this.fZs.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.fZs.getCmd());
            MessageManager.getInstance().registerTask(this.fZs);
            this.fZl.setAdData();
            fZm = false;
            if (this.fZi != null) {
                this.fZi.onPrimary();
                if (this.fZh != null) {
                    Object itemAtPosition = this.fZh.getItemAtPosition(this.fZh.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fZi.bxE();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.fZA) {
                this.fZl.requestFocus();
                this.fZl.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.fZs.getCmd());
        bzC();
    }

    public void onPause() {
        bzC();
    }

    public void onDestroy() {
        if (this.fZk != null) {
            this.fZk.onDestroy();
        }
        if (this.fZi != null) {
            this.fZi.onDestroy();
        }
        if (this.fZg != null && this.fZg.byn() != null) {
            this.fZg.byn().b(this.fYN);
        }
    }

    public void rK(int i) {
        this.fZi.rK(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fZi != null) {
            this.fZi.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bxD() {
        if (this.fZi == null) {
            return false;
        }
        return this.fZi.bxD();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fZm && this.fZg.getActivity() != null && this.fZg.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bxS() != 0 && !com.baidu.tbadk.core.sharedPref.b.aFD().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fZn = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aFD().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fZn = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fZm = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).M(0).F(true).G(false).E(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fZn);
                        b.this.fZg.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.fPF = dVar2.fI();
                this.fPF.setShouldCheckLocInWindow(false);
                this.fPF.setUseDirectOffset(true);
                this.fPF.show(this.fZg.getActivity());
                if (this.fZn == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fZn == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.fPF != null) {
                            b.this.fPF.dismiss();
                            b.this.fPF = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bzC() {
        if (this.fPF != null) {
            this.fPF.dismiss();
            this.fPF = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTp = bVar;
        if (this.fZi != null) {
            this.fZi.setAdState(bVar);
        }
        if (bVar != null && bVar.fTT) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.ll(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.ll(R.raw.lottie_common_pull_refresh);
    }

    public void kP(boolean z) {
        if (this.fZp != z) {
            this.fZp = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fZh.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.fZh.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.fZh.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.fZh.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fZl != null) {
            this.fZl.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fZl != null) {
            this.fZl.setRecentlyIsShow(z);
        }
    }

    private void bzD() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.fZy = new View(this.mContext);
        this.fZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.fZg.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.fZy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float fZD = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fZz = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.fZz <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fZz) {
                            b.this.bzE();
                            if (this.fZD < 50.0f) {
                                b.this.fZy.performClick();
                            }
                        } else {
                            b.this.bzF();
                        }
                        b.this.fZz = 0.0f;
                        this.fZD = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.fZz) {
                            b.this.ax(motionEvent.getRawY() - b.this.fZz);
                            if (b.this.dto != null) {
                                b.this.dto.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.fZz) > this.fZD) {
                            this.fZD = Math.abs(motionEvent.getRawY() - b.this.fZz);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.fZz <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fZz) {
                            b.this.bzE();
                        } else {
                            b.this.bzF();
                        }
                        b.this.fZz = 0.0f;
                        this.fZD = 0.0f;
                        return true;
                }
            }
        });
        this.dto = new ImageView(this.mContext);
        this.dto.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bzF();
            }
        });
    }

    public void bM(final View view) {
        if ((view instanceof FrameLayout) && !this.fZA) {
            this.mPullView.pause();
            this.fZA = true;
            this.fZl.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.dto, R.drawable.icon_jinba_retract_n);
            final int bzw = bzw();
            ValueAnimator ofInt = ValueAnimator.ofInt(bzw, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.fZl != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fZl.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bzu();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.fZl.setLayoutParams(marginLayoutParams);
                            if (intValue / bzw < 0.2d) {
                                if (b.this.fZl.getParent() != b.this.fZl.getRootView() && (viewGroup = (ViewGroup) b.this.fZl.getRootView()) != null) {
                                    ((ViewGroup) b.this.fZl.getParent()).removeView(b.this.fZl);
                                    if (b.this.fZl.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.fZl, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.fZy);
                                    viewGroup.bringChildToFront(b.this.dto);
                                }
                            } else if (b.this.fZl.getParent() == b.this.fZl.getRootView()) {
                                if (b.this.fZl.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.fZl.getRootView();
                                    ((ViewGroup) b.this.fZl.getParent()).removeView(b.this.fZl);
                                }
                                if (b.this.fZl.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.fZg.byp().addView(b.this.fZl, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.fZA = false;
                    b.this.rZ(((intValue - bzw) * 2) + 0);
                    b.this.fZA = true;
                    float abs = Math.abs(intValue / bzw);
                    b.this.fZh.setAlpha(abs);
                    View byE = b.this.fZg.byn().byE();
                    if (byE != null) {
                        byE.setAlpha(abs);
                    }
                    View findViewById = b.this.fZg.byp().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.fZl != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fZl.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bzu();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.fZl.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.fZh.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.fZA = false;
                    b.this.rZ(0 - (bzw * 2));
                    b.this.fZA = true;
                    b.this.fZh.setVisibility(8);
                    b.this.fZy.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.fZy.getParent() == null) {
                        frameLayout.addView(b.this.fZy, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.dto.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.dto, layoutParams3);
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
            this.fZl.requestFocus();
            this.fZl.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(float f) {
        ViewGroup viewGroup;
        int bzv = bzv();
        float abs = Math.abs(bzv / (bzy() - bzv));
        int i = (int) f;
        if (this.fZl != null) {
            ViewGroup.LayoutParams layoutParams = this.fZl.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bzu();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.fZl.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.fZl.getParent() != this.fZl.getRootView() && (viewGroup = (ViewGroup) this.fZl.getRootView()) != null) {
                        ((ViewGroup) this.fZl.getParent()).removeView(this.fZl);
                        if (this.fZl.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.fZl, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.fZy);
                        viewGroup.bringChildToFront(this.dto);
                    }
                } else if (this.fZl.getParent() == this.fZl.getRootView()) {
                    if (this.fZl.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.fZl.getRootView();
                        ((ViewGroup) this.fZl.getParent()).removeView(this.fZl);
                    }
                    if (this.fZl.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.fZg.byp().addView(this.fZl, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.fZh.setVisibility(0);
        this.fZA = false;
        rZ(((int) ((i * abs) - (bzv * abs))) * 2);
        this.fZA = true;
        float abs2 = Math.abs(i / bzv);
        this.fZh.setAlpha(abs2);
        View byE = this.fZg.byn().byE();
        if (byE != null) {
            byE.setAlpha(abs2);
        }
        View findViewById = this.fZg.byp().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzE() {
        if (this.dto != null) {
            this.dto.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bzw(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ax(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ax(0.0f);
                b.this.mPullView.resume();
                b.this.fZh.completePullRefresh();
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
    public void bzF() {
        this.fZy.setEnabled(false);
        int bzv = bzv();
        Math.abs(bzv / (bzy() - bzv));
        this.dto.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.fZl.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bzw(), bzv);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ax(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass14());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$14  reason: invalid class name */
    /* loaded from: classes9.dex */
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
                    ViewGroup viewGroup = (ViewGroup) b.this.fZy.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.fZy);
                        viewGroup.removeView(b.this.dto);
                    }
                    b.this.dto.setVisibility(0);
                    b.this.fZA = false;
                    b.this.bzt();
                    b.this.fZv = 0;
                    b.this.rZ(0);
                    b.this.fZA = true;
                    b.this.mPullView.resume();
                    b.this.fZh.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fZA = false;
                        }
                    }, 0L);
                    b.this.fZh.setVisibility(0);
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
        if (this.fZA) {
            bzF();
        }
    }
}
