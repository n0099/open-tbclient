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
    private static boolean fZk = false;
    private View aDw;
    private ImageView dtn;
    private View eEs;
    private com.baidu.adp.lib.guide.c fPD;
    private ViewEventCenter fTi;
    private com.baidu.tieba.enterForum.data.b fTn;
    private int fVQ;
    private int fYH;
    private final EnterForumFragment fZe;
    private BdListView fZf;
    private com.baidu.tieba.enterForum.a.a fZg;
    private List<com.baidu.tieba.enterForum.data.f> fZh;
    private CommonTipView fZi;
    private EnterForumAdView fZj;
    private int fZl;
    private e fZm;
    private int fZo;
    private g.c fZp;
    private View fZw;
    private float fZx;
    private Context mContext;
    private int mNavHeight;
    private h mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean isFirst = true;
    private boolean fZn = true;
    private g.c etD = new g.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.fZy) {
                com.baidu.tieba.s.c.cJY().z(b.this.fZe.getUniqueId());
                if (b.this.fZp != null) {
                    b.this.fZp.onListPullRefresh(z);
                }
                if (z && !b.this.fTR && b.this.fTn != null && b.this.fTn.fTR) {
                    if (b.this.fTn.fTT > 0) {
                        b.this.fZf.smoothScrollToPosition(0, 0, 0);
                        b.this.bzv();
                        return;
                    }
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fZf.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a fZq = new com.baidu.tbadk.task.a(2921422, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.fZy) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bzD();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921422, Boolean.valueOf(b.this.fZy));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int enA = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fZm.onScrollStateChanged(absListView, i);
            if (this.enA != i) {
                this.enA = i;
                if (this.enA == 1) {
                    if ((b.this.fTn == null || !b.this.fTn.fTR) && b.this.fZe != null && b.this.fZe.byl() != null) {
                        b.this.fZe.byl().bcK();
                    }
                    b.this.bzA();
                    return;
                }
                b.this.bzp();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fZe.isPrimary() && this.enA != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.fZf.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.fZf.getItemAtPosition(i4) == v.getItem(b.this.fZh, 0)) {
                            b.this.a(dVar, b.this.fZf.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fZm.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fYL = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void byD() {
            b.this.bzp();
        }
    };
    View.OnClickListener fZr = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fTn != null && b.this.fTn.fTR && b.this.fTR) {
                EnterForumAdView unused = b.this.fZj;
                EnterForumAdView.a(b.this.fZe.getUniqueId(), b.this.fZe.getContext());
            }
        }
    };
    private int fZs = 0;
    private int fZt = 0;
    boolean fTR = false;
    boolean fZu = false;
    private Runnable fZv = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bzx();
        }
    };
    private boolean fZy = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bzp() {
        if (bzq()) {
            if (this.fZe != null && this.fZe.byl() != null) {
                this.fZe.byl().bcL();
            }
        } else if (this.fTn != null && this.fTn.fTR) {
            if (this.fZe != null && this.fZe.byl() != null) {
                this.fZe.byl().bcL();
            }
        } else if (this.fZe != null && this.fZe.byl() != null) {
            this.fZe.byl().bcK();
        }
    }

    private boolean bzq() {
        return this.fZf == null || this.fZf.getChildCount() == 0 || this.fZf.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fZe = enterForumFragment;
        this.fVQ = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.fYH = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.fZo = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.fTi = viewEventCenter;
        bJ(view);
        this.fZg = new com.baidu.tieba.enterForum.a.a(this.fZe.getPageContext(), this.fTi, recentlyVisitedForumModel, enterForumModel, this);
        this.fZf.setAdapter((ListAdapter) this.fZg);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.mContext = view.getContext();
        this.fZm = new e();
        this.fZm.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.fZy) {
                    if (b.this.fZe.byl().byy() == 1) {
                        b.this.fZe.byl().e(absListView, 0, i2, 0, 0);
                    }
                    b.this.fZs = -i;
                    if (b.this.fTR) {
                        b.this.bzx();
                    } else if (b.this.fTn != null && b.this.fTn.fTR) {
                        b.this.bzr();
                    }
                }
            }
        });
        this.fZf = (BdListView) view.findViewById(R.id.listview);
        rZ(0);
        this.fZf.setBackgroundColor(0);
        this.fZf.setVerticalScrollBarEnabled(false);
        this.fZf.setOnScrollListener(this.mOnScrollListener);
        this.fZf.setFastScrollEnabled(false);
        this.fZf.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fZe.byl() != null) {
            this.fZe.byl().b(this.fYL);
            this.fZe.byl().a(this.fYL);
            this.fZe.byl().a(this);
        }
        this.mPullView = new h(this.fZe.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.fZt = i3;
                if (!b.this.fTR && b.this.fTn != null && b.this.fTn.fTR && !b.this.fZy) {
                    b.this.bzr();
                    if (i3 > b.this.fZo) {
                        b.this.fZt = 0;
                        b.this.bM(b.this.fZe.byl().getRootView());
                    }
                }
            }
        });
        this.mPullView.fS(true);
        this.mPullView.setListPullRefreshListener(this.etD);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fZe.getUniqueId());
        }
        this.fZf.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.fZe.getPageContext().getPageActivity());
        this.eEs = new View(this.fZe.getPageContext().getPageActivity());
        frameLayout.addView(this.eEs, new FrameLayout.LayoutParams(-1, this.fYH));
        this.fZf.getAdapter2().addHeaderView(frameLayout, 0);
        this.aDw = new View(this.fZe.getActivity());
        this.aDw.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.fZe.getActivity(), R.dimen.ds50)));
        this.aDw.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.fZr);
        this.mPullView.getView().setOnClickListener(this.fZr);
        this.eEs.setOnClickListener(this.fZr);
        bzB();
    }

    public void bK(View view) {
        this.fZj = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fZj != null) {
            bzr();
            this.fZj.setTag(this.fZe.getUniqueId());
            this.fZj.setAdData();
            this.fZj.setEventCenter(this.fTi);
            this.fZj.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzr() {
        if (!this.fZy && this.fZj != null) {
            ViewGroup.LayoutParams layoutParams = this.fZj.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bzs = bzs();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.fTR ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fZs + this.fZt) - bzs, 0, 0);
                this.fZj.setLayoutParams(layoutParams2);
                this.fZj.setAdViewHeight(layoutParams2.height - bzs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzs() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bzt() {
        return this.fTR ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fZs + this.fZt) - bzs();
    }

    private int bzu() {
        ViewGroup.LayoutParams layoutParams = this.fZj.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bzv() {
        if (!this.fZy) {
            this.fTR = true;
            bzr();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.fZj != null) {
                if (!this.fZj.bzm()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.fZj.bzl()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            rZ(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fZv);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fZv, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ(int i) {
        if (!this.fZy) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fZf.getLayoutParams();
            marginLayoutParams.topMargin = ((this.fVQ + i) - this.fYH) - (EnterForumDelegateStatic.fUI.byJ() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.fZf.setLayoutParams(marginLayoutParams);
        }
    }

    private int bzw() {
        return (this.fVQ - this.fYH) - (EnterForumDelegateStatic.fUI.byJ() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzx() {
        this.fTR = false;
        bzr();
        rZ(0);
        if (this.fZu) {
            this.fZf.completePullRefreshPostDelayed(0L);
        }
        this.fZu = false;
    }

    public void bL(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.fZe.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.fZe.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.fZf.setVisibility(8);
        if (this.fZe.byl() != null) {
            this.fZe.byl().byz();
            this.fZe.byl().byA();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.fZf.setVisibility(0);
        if (this.fZe.byl() != null) {
            this.fZe.byl().byz();
            this.fZe.byl().byA();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.fZh);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fZh.remove(fVar);
        n(this.fZh, z);
        kO(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bzy() {
        return this.fZf;
    }

    public void startPullRefresh() {
        this.fZf.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.fTR) {
            this.fZu = true;
            return;
        }
        this.fZu = false;
        this.fZf.completePullRefreshPostDelayed(0L);
    }

    public void kO(boolean z) {
        this.fZg.notifyDataSetChanged();
        if (this.aDw != null && this.aDw.getLayoutParams() != null) {
            if (z) {
                this.aDw.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.aDw.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void n(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fZj.setAdData();
        EnterForumDelegateStatic.fUI.eN(this.mContext);
        this.fZh = list;
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
        this.fZg.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.fZf.removeFooterView(this.aDw);
            this.fZf.addFooterView(this.aDw);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.fZf.removeFooterView(this.aDw);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.aDw, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.fZp = cVar;
    }

    public void bzz() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.fZe != null && this.fZe.getActivity() != null && this.fZe.byk() != null) {
            if (this.fZi == null) {
                this.fZi = new CommonTipView(this.fZe.getActivity());
            }
            this.fZi.setText(R.string.enter_forum_login_tip);
            this.fZi.c(this.fZe.byk(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.fZe.isAdded() && this.fZe.isPrimary()) {
            this.fZq.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.fZq.getCmd());
            MessageManager.getInstance().registerTask(this.fZq);
            this.fZj.setAdData();
            fZk = false;
            if (this.fZg != null) {
                this.fZg.onPrimary();
                if (this.fZf != null) {
                    Object itemAtPosition = this.fZf.getItemAtPosition(this.fZf.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fZg.bxC();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.fZy) {
                this.fZj.requestFocus();
                this.fZj.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.fZq.getCmd());
        bzA();
    }

    public void onPause() {
        bzA();
    }

    public void onDestroy() {
        if (this.fZi != null) {
            this.fZi.onDestroy();
        }
        if (this.fZg != null) {
            this.fZg.onDestroy();
        }
        if (this.fZe != null && this.fZe.byl() != null) {
            this.fZe.byl().b(this.fYL);
        }
    }

    public void rK(int i) {
        this.fZg.rK(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fZg != null) {
            this.fZg.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bxB() {
        if (this.fZg == null) {
            return false;
        }
        return this.fZg.bxB();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fZk && this.fZe.getActivity() != null && this.fZe.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bxQ() != 0 && !com.baidu.tbadk.core.sharedPref.b.aFB().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fZl = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aFB().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fZl = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fZk = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).M(0).F(true).G(false).E(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fZl);
                        b.this.fZe.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.fPD = dVar2.fI();
                this.fPD.setShouldCheckLocInWindow(false);
                this.fPD.setUseDirectOffset(true);
                this.fPD.show(this.fZe.getActivity());
                if (this.fZl == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aFB().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fZl == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aFB().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.fPD != null) {
                            b.this.fPD.dismiss();
                            b.this.fPD = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bzA() {
        if (this.fPD != null) {
            this.fPD.dismiss();
            this.fPD = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTn = bVar;
        if (this.fZg != null) {
            this.fZg.setAdState(bVar);
        }
        if (bVar != null && bVar.fTR) {
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
        if (this.fZn != z) {
            this.fZn = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fZf.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.fZf.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.fZf.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.fZf.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fZj != null) {
            this.fZj.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fZj != null) {
            this.fZj.setRecentlyIsShow(z);
        }
    }

    private void bzB() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.fZw = new View(this.mContext);
        this.fZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.fZe.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.fZw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float fZB = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fZx = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.fZx <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fZx) {
                            b.this.bzC();
                            if (this.fZB < 50.0f) {
                                b.this.fZw.performClick();
                            }
                        } else {
                            b.this.bzD();
                        }
                        b.this.fZx = 0.0f;
                        this.fZB = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.fZx) {
                            b.this.ax(motionEvent.getRawY() - b.this.fZx);
                            if (b.this.dtn != null) {
                                b.this.dtn.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.fZx) > this.fZB) {
                            this.fZB = Math.abs(motionEvent.getRawY() - b.this.fZx);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.fZx <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fZx) {
                            b.this.bzC();
                        } else {
                            b.this.bzD();
                        }
                        b.this.fZx = 0.0f;
                        this.fZB = 0.0f;
                        return true;
                }
            }
        });
        this.dtn = new ImageView(this.mContext);
        this.dtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bzD();
            }
        });
    }

    public void bM(final View view) {
        if ((view instanceof FrameLayout) && !this.fZy) {
            this.mPullView.pause();
            this.fZy = true;
            this.fZj.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.dtn, R.drawable.icon_jinba_retract_n);
            final int bzu = bzu();
            ValueAnimator ofInt = ValueAnimator.ofInt(bzu, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.fZj != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fZj.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bzs();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.fZj.setLayoutParams(marginLayoutParams);
                            if (intValue / bzu < 0.2d) {
                                if (b.this.fZj.getParent() != b.this.fZj.getRootView() && (viewGroup = (ViewGroup) b.this.fZj.getRootView()) != null) {
                                    ((ViewGroup) b.this.fZj.getParent()).removeView(b.this.fZj);
                                    if (b.this.fZj.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.fZj, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.fZw);
                                    viewGroup.bringChildToFront(b.this.dtn);
                                }
                            } else if (b.this.fZj.getParent() == b.this.fZj.getRootView()) {
                                if (b.this.fZj.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.fZj.getRootView();
                                    ((ViewGroup) b.this.fZj.getParent()).removeView(b.this.fZj);
                                }
                                if (b.this.fZj.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.fZe.byn().addView(b.this.fZj, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.fZy = false;
                    b.this.rZ(((intValue - bzu) * 2) + 0);
                    b.this.fZy = true;
                    float abs = Math.abs(intValue / bzu);
                    b.this.fZf.setAlpha(abs);
                    View byC = b.this.fZe.byl().byC();
                    if (byC != null) {
                        byC.setAlpha(abs);
                    }
                    View findViewById = b.this.fZe.byn().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.fZj != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fZj.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bzs();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.fZj.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.fZf.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.fZy = false;
                    b.this.rZ(0 - (bzu * 2));
                    b.this.fZy = true;
                    b.this.fZf.setVisibility(8);
                    b.this.fZw.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.fZw.getParent() == null) {
                        frameLayout.addView(b.this.fZw, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.dtn.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.dtn, layoutParams3);
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
            this.fZj.requestFocus();
            this.fZj.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(float f) {
        ViewGroup viewGroup;
        int bzt = bzt();
        float abs = Math.abs(bzt / (bzw() - bzt));
        int i = (int) f;
        if (this.fZj != null) {
            ViewGroup.LayoutParams layoutParams = this.fZj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bzs();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.fZj.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.fZj.getParent() != this.fZj.getRootView() && (viewGroup = (ViewGroup) this.fZj.getRootView()) != null) {
                        ((ViewGroup) this.fZj.getParent()).removeView(this.fZj);
                        if (this.fZj.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.fZj, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.fZw);
                        viewGroup.bringChildToFront(this.dtn);
                    }
                } else if (this.fZj.getParent() == this.fZj.getRootView()) {
                    if (this.fZj.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.fZj.getRootView();
                        ((ViewGroup) this.fZj.getParent()).removeView(this.fZj);
                    }
                    if (this.fZj.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.fZe.byn().addView(this.fZj, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.fZf.setVisibility(0);
        this.fZy = false;
        rZ(((int) ((i * abs) - (bzt * abs))) * 2);
        this.fZy = true;
        float abs2 = Math.abs(i / bzt);
        this.fZf.setAlpha(abs2);
        View byC = this.fZe.byl().byC();
        if (byC != null) {
            byC.setAlpha(abs2);
        }
        View findViewById = this.fZe.byn().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzC() {
        if (this.dtn != null) {
            this.dtn.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bzu(), 0);
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
                b.this.fZf.completePullRefresh();
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
    public void bzD() {
        this.fZw.setEnabled(false);
        int bzt = bzt();
        Math.abs(bzt / (bzw() - bzt));
        this.dtn.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.fZj.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bzu(), bzt);
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
                    ViewGroup viewGroup = (ViewGroup) b.this.fZw.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.fZw);
                        viewGroup.removeView(b.this.dtn);
                    }
                    b.this.dtn.setVisibility(0);
                    b.this.fZy = false;
                    b.this.bzr();
                    b.this.fZt = 0;
                    b.this.rZ(0);
                    b.this.fZy = true;
                    b.this.mPullView.resume();
                    b.this.fZf.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fZy = false;
                        }
                    }, 0L);
                    b.this.fZf.setVisibility(0);
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
        if (this.fZy) {
            bzD();
        }
    }
}
