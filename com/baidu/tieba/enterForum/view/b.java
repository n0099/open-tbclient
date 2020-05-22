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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.c;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.l;
import com.baidu.tieba.enterForum.data.m;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.enterForum.view.e;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements EnterForumAdView.a {
    private static boolean gXi = false;
    private View beU;
    private ImageView ehX;
    private View fxi;
    private com.baidu.adp.lib.guide.c gJZ;
    private ViewEventCenter gNE;
    private com.baidu.tieba.enterForum.data.d gNJ;
    private int gQw;
    private int gUX;
    private final EnterForumFragment gXb;
    private BdListView gXc;
    private com.baidu.tieba.enterForum.a.a gXd;
    private List<h> gXe;
    private l gXf;
    private CommonTipView gXg;
    private EnterForumAdView gXh;
    private int gXj;
    private e gXk;
    private int gXm;
    private f.c gXn;
    private View gXt;
    private float gXu;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean gXl = true;
    private f.c fkx = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.gXv) {
                com.baidu.tieba.s.c.dct().C(b.this.gXb.getUniqueId());
                if (b.this.gXn != null) {
                    b.this.gXn.onListPullRefresh(z);
                }
                if (z && !b.this.gOu && b.this.gNJ != null && b.this.gNJ.gOu) {
                    if (b.this.gNJ.gOw > 0) {
                        b.this.gXc.smoothScrollToPosition(0, 0, 0);
                        b.this.bQo();
                        return;
                    }
                    com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gXc.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int feq = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.gXk.onScrollStateChanged(absListView, i);
            if (this.feq != i) {
                this.feq = i;
                if (this.feq == 1) {
                    if (b.this.gNJ == null || !b.this.gNJ.gOu) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.bQt();
                    return;
                }
                b.this.bQi();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.gXb.isPrimary() && this.feq != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.gXc.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.f)) {
                        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) itemAtPosition;
                        if (fVar.getType() == 1 && b.this.gXc.getItemAtPosition(i4) == v.getItem(b.this.gXe, 0)) {
                            b.this.a(fVar, b.this.gXc.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.gXk.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener gXo = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gNJ != null && b.this.gNJ.gOu && b.this.gOu) {
                EnterForumAdView unused = b.this.gXh;
                EnterForumAdView.a(b.this.gXb.getUniqueId(), b.this.gXb.getContext());
            }
        }
    };
    private int gXp = 0;
    private int gXq = 0;
    boolean gOu = false;
    boolean gXr = false;
    private Runnable gXs = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // java.lang.Runnable
        public void run() {
            b.this.bQq();
        }
    };
    private boolean gXv = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bQi() {
        if (bQj()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.gNJ != null && this.gNJ.gOu) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean bQj() {
        return this.gXc == null || this.gXc.getChildCount() == 0 || this.gXc.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.gXb = enterForumFragment;
        this.gQw = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.gUX = com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.gXm = com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.gNE = viewEventCenter;
        bP(view);
        this.gXd = new com.baidu.tieba.enterForum.a.a(this.gXb.getPageContext(), this.gNE, recentlyVisitedForumModel, enterForumModel, this);
        this.gXc.setAdapter((ListAdapter) this.gXd);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bP(View view) {
        this.mContext = view.getContext();
        this.gXk = new e();
        this.gXk.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.14
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.gXv) {
                    b.this.gXp = -i;
                    if (b.this.gOu) {
                        b.this.bQq();
                    } else if (b.this.gNJ != null && b.this.gNJ.gOu) {
                        b.this.bQk();
                    }
                }
            }
        });
        this.gXc = (BdListView) view.findViewById(R.id.listview);
        td(0);
        this.gXc.setBackgroundColor(0);
        this.gXc.setVerticalScrollBarEnabled(false);
        this.gXc.setOnScrollListener(this.mOnScrollListener);
        this.gXc.setFastScrollEnabled(false);
        this.gXc.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.gXb.bOI() != null) {
            this.gXb.bOI().a(this);
        }
        this.mPullView = new g(this.gXb.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.15
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.gXq = i3;
                if (!b.this.gOu && b.this.gNJ != null && b.this.gNJ.gOu && !b.this.gXv) {
                    b.this.bQk();
                    if (i3 > b.this.gXm) {
                        b.this.gXq = 0;
                        b.this.bS(b.this.gXb.bOI().getRootView());
                    }
                }
            }
        });
        this.mPullView.hk(true);
        this.mPullView.setListPullRefreshListener(this.fkx);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.gXb.getUniqueId());
        }
        this.gXc.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.gXb.getPageContext().getPageActivity());
        this.fxi = new View(this.gXb.getPageContext().getPageActivity());
        frameLayout.addView(this.fxi, new FrameLayout.LayoutParams(-1, this.gUX));
        this.gXc.getAdapter2().addHeaderView(frameLayout, 0);
        this.beU = new View(this.gXb.getActivity());
        this.beU.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gXb.getActivity(), R.dimen.ds50)));
        this.beU.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.gXo);
        this.mPullView.getView().setOnClickListener(this.gXo);
        this.fxi.setOnClickListener(this.gXo);
        bQu();
    }

    public void bQ(View view) {
        this.gXh = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.gXh != null) {
            bQk();
            this.gXh.setTag(this.gXb.getUniqueId());
            this.gXh.setAdData();
            this.gXh.setEventCenter(this.gNE);
            this.gXh.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQk() {
        if (!this.gXv && this.gXh != null) {
            ViewGroup.LayoutParams layoutParams = this.gXh.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bQl = bQl();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.gOu ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gXp + this.gXq) - bQl, 0, 0);
                this.gXh.setLayoutParams(layoutParams2);
                this.gXh.setAdViewHeight(layoutParams2.height - bQl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bQl() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bQm() {
        return this.gOu ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gXp + this.gXq) - bQl();
    }

    private int bQn() {
        ViewGroup.LayoutParams layoutParams = this.gXh.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bQo() {
        if (!this.gXv) {
            this.gOu = true;
            bQk();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.gXh != null) {
                if (!this.gXh.bQf()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.gXh.bQe()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            td(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gXs);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.gXs, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(int i) {
        if (!this.gXv) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gXc.getLayoutParams();
            marginLayoutParams.topMargin = ((this.gQw + i) - this.gUX) - (EnterForumDelegateStatic.gPq.bPm() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.gXc.setLayoutParams(marginLayoutParams);
        }
    }

    private int bQp() {
        return (this.gQw - this.gUX) - (EnterForumDelegateStatic.gPq.bPm() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQq() {
        this.gOu = false;
        bQk();
        td(0);
        if (this.gXr) {
            this.gXc.completePullRefreshPostDelayed(0L);
        }
        this.gXr = false;
    }

    public void bR(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.gXb.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.gXb.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.gXc.setVisibility(8);
        if (this.gXb.bOI() != null) {
            this.gXb.bOI().bOW();
            this.gXb.bOI().bOX();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.gXc.setVisibility(0);
        if (this.gXb.bOI() != null) {
            this.gXb.bOI().bOW();
            this.gXb.bOI().bOX();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.gXe);
    }

    public void a(h hVar, boolean z) {
        this.gXe.remove(hVar);
        a(this.gXe, this.gXf, z);
        mt(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bQr() {
        return this.gXc;
    }

    public void startPullRefresh() {
        this.gXc.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.gOu) {
            this.gXr = true;
            return;
        }
        this.gXr = false;
        this.gXc.completePullRefreshPostDelayed(0L);
    }

    public void mt(boolean z) {
        this.gXd.notifyDataSetChanged();
        if (this.beU != null && this.beU.getLayoutParams() != null) {
            if (z) {
                this.beU.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.beU.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<h> list, l lVar, boolean z) {
        this.gXh.setAdData();
        EnterForumDelegateStatic.gPq.eH(this.mContext);
        this.gXe = list;
        this.gXf = lVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !v.isEmpty(list);
        boolean z3 = !v.isEmpty(list);
        com.baidu.tieba.enterForum.data.f fVar = new com.baidu.tieba.enterForum.data.f();
        fVar.setType(4);
        arrayList.add(fVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.b(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.g(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(lVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.g(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                com.baidu.tieba.enterForum.data.f fVar2 = new com.baidu.tieba.enterForum.data.f();
                fVar2.setType(11);
                arrayList.add(fVar2);
            } else {
                com.baidu.tieba.enterForum.data.f fVar3 = new com.baidu.tieba.enterForum.data.f();
                fVar3.setType(3);
                arrayList.add(fVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new m(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(lVar.bOq());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.b(false));
            }
        }
        if (z) {
            com.baidu.tieba.enterForum.data.f fVar4 = new com.baidu.tieba.enterForum.data.f();
            fVar4.setType(5);
            arrayList.add(fVar4);
        }
        hideNoDataView();
        this.gXd.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.gXc.removeFooterView(this.beU);
            this.gXc.addFooterView(this.beU);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.gXc.removeFooterView(this.beU);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.beU, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.gXn = cVar;
    }

    public void bQs() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.gXb != null && this.gXb.getActivity() != null && this.gXb.bOH() != null) {
            if (this.gXg == null) {
                this.gXg = new CommonTipView(this.gXb.getActivity());
            }
            this.gXg.setText(R.string.enter_forum_login_tip);
            this.gXg.c(this.gXb.bOH(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.gXb.isAdded() && this.gXb.isPrimary()) {
            gXi = false;
            if (this.gXd != null) {
                this.gXd.onPrimary();
                if (this.gXc != null) {
                    Object itemAtPosition = this.gXc.getItemAtPosition(this.gXc.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.f) && ((com.baidu.tieba.enterForum.data.f) itemAtPosition).getType() == 5) {
                        this.gXd.bNO();
                    }
                }
            }
            if (this.gXv) {
                this.gXh.requestFocus();
                this.gXh.requestFocusFromTouch();
                return;
            }
            return;
        }
        bQt();
    }

    public void onPause() {
        bQt();
    }

    public void onDestroy() {
        if (this.gXg != null) {
            this.gXg.onDestroy();
        }
        if (this.gXd != null) {
            this.gXd.onDestroy();
        }
    }

    public void sI(int i) {
        this.gXd.sI(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gXd != null) {
            this.gXd.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bNN() {
        if (this.gXd == null) {
            return false;
        }
        return this.gXd.bNN();
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, View view) {
        if (TbadkCoreApplication.isLogin() && !gXi && this.gXb.getActivity() != null && this.gXb.getPageContext() != null && (fVar instanceof h)) {
            h hVar = (h) fVar;
            if (hVar.isPrivateForum() != 0 && hVar.bOe() != 0 && !com.baidu.tbadk.core.sharedPref.b.aTX().getString("enter_forum_new_forum_long_press_guide", "").equals(hVar.getId())) {
                this.gXj = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aTX().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.gXj = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                gXi = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).Z(0).ae(true).af(false).ad(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.18
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.gXj);
                        b.this.gXb.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.19
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.gJZ = dVar.ko();
                this.gJZ.setShouldCheckLocInWindow(false);
                this.gJZ.setUseDirectOffset(true);
                this.gJZ.show(this.gXb.getActivity());
                if (this.gXj == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("enter_forum_new_forum_long_press_guide", hVar.getId());
                } else if (this.gXj == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.gJZ != null) {
                            b.this.gJZ.dismiss();
                            b.this.gJZ = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bQt() {
        if (this.gJZ != null) {
            this.gJZ.dismiss();
            this.gJZ = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gNJ = dVar;
        if (this.gXd != null) {
            this.gXd.setAdState(dVar);
        }
        if (dVar != null && dVar.gOu) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.lZ(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.lZ(R.raw.lottie_common_pull_refresh);
    }

    public void mu(boolean z) {
        if (this.gXl != z) {
            this.gXl = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gXc.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.gXc.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.gXc.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.gXc.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.gXh != null) {
            this.gXh.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.gXh != null) {
            this.gXh.setRecentlyIsShow(z);
        }
    }

    private void bQu() {
        this.mNavHeight = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds240);
        this.gXt = new View(this.mContext);
        this.gXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.gXb.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.gXt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            private float gXy = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gXu = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.gXu <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gXu) {
                            b.this.bQv();
                            if (this.gXy < 50.0f) {
                                b.this.gXt.performClick();
                            }
                        } else {
                            b.this.bQw();
                        }
                        b.this.gXu = 0.0f;
                        this.gXy = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.gXu) {
                            b.this.af(motionEvent.getRawY() - b.this.gXu);
                            if (b.this.ehX != null) {
                                b.this.ehX.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.gXu) > this.gXy) {
                            this.gXy = Math.abs(motionEvent.getRawY() - b.this.gXu);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.gXu <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gXu) {
                            b.this.bQv();
                        } else {
                            b.this.bQw();
                        }
                        b.this.gXu = 0.0f;
                        this.gXy = 0.0f;
                        return true;
                }
            }
        });
        this.ehX = new ImageView(this.mContext);
        this.ehX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bQw();
            }
        });
    }

    public void bS(final View view) {
        if ((view instanceof FrameLayout) && !this.gXv) {
            this.mPullView.pause();
            this.gXv = true;
            this.gXh.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.ehX, R.drawable.icon_jinba_retract_n);
            final int bQn = bQn();
            ValueAnimator ofInt = ValueAnimator.ofInt(bQn, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.gXh != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gXh.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bQl();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.gXh.setLayoutParams(marginLayoutParams);
                            if (intValue / bQn < 0.2d) {
                                if (b.this.gXh.getParent() != b.this.gXh.getRootView() && (viewGroup = (ViewGroup) b.this.gXh.getRootView()) != null) {
                                    ((ViewGroup) b.this.gXh.getParent()).removeView(b.this.gXh);
                                    if (b.this.gXh.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.gXh, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.gXt);
                                    viewGroup.bringChildToFront(b.this.ehX);
                                }
                            } else if (b.this.gXh.getParent() == b.this.gXh.getRootView()) {
                                if (b.this.gXh.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.gXh.getRootView();
                                    ((ViewGroup) b.this.gXh.getParent()).removeView(b.this.gXh);
                                }
                                if (b.this.gXh.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.gXb.bOL().addView(b.this.gXh, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.gXv = false;
                    b.this.td(((intValue - bQn) * 2) + 0);
                    b.this.gXv = true;
                    float abs = Math.abs(intValue / bQn);
                    b.this.gXc.setAlpha(abs);
                    View bOZ = b.this.gXb.bOI().bOZ();
                    if (bOZ != null) {
                        bOZ.setAlpha(abs);
                    }
                    View findViewById = b.this.gXb.bOL().getRootView().findViewById(R.id.tabcontainer_wrapper);
                    if (findViewById != null) {
                        findViewById.setAlpha(abs);
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.gXh != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gXh.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bQl();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.gXh.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.gXc.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.gXv = false;
                    b.this.td(0 - (bQn * 2));
                    b.this.gXv = true;
                    b.this.gXc.setVisibility(8);
                    b.this.gXt.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.gXt.getParent() == null) {
                        frameLayout.addView(b.this.gXt, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.ehX.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.ehX, layoutParams3);
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
            this.gXh.requestFocus();
            this.gXh.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(float f) {
        ViewGroup viewGroup;
        int bQm = bQm();
        float abs = Math.abs(bQm / (bQp() - bQm));
        int i = (int) f;
        if (this.gXh != null) {
            ViewGroup.LayoutParams layoutParams = this.gXh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bQl();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.gXh.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.gXh.getParent() != this.gXh.getRootView() && (viewGroup = (ViewGroup) this.gXh.getRootView()) != null) {
                        ((ViewGroup) this.gXh.getParent()).removeView(this.gXh);
                        if (this.gXh.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.gXh, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.gXt);
                        viewGroup.bringChildToFront(this.ehX);
                    }
                } else if (this.gXh.getParent() == this.gXh.getRootView()) {
                    if (this.gXh.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.gXh.getRootView();
                        ((ViewGroup) this.gXh.getParent()).removeView(this.gXh);
                    }
                    if (this.gXh.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.gXb.bOL().addView(this.gXh, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.gXc.setVisibility(0);
        this.gXv = false;
        td(((int) ((i * abs) - (bQm * abs))) * 2);
        this.gXv = true;
        float abs2 = Math.abs(i / bQm);
        this.gXc.setAlpha(abs2);
        View bOZ = this.gXb.bOI().bOZ();
        if (bOZ != null) {
            bOZ.setAlpha(abs2);
        }
        View findViewById = this.gXb.bOL().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQv() {
        if (this.ehX != null) {
            this.ehX.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bQn(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.af(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.af(0.0f);
                b.this.mPullView.resume();
                b.this.gXc.completePullRefresh();
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
    public void bQw() {
        this.gXt.setEnabled(false);
        int bQm = bQm();
        Math.abs(bQm / (bQp() - bQm));
        this.ehX.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.gXh.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bQn(), bQm);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.af(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass11());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$11  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass11 implements Animator.AnimatorListener {
        AnonymousClass11() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.11.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.gXt.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.gXt);
                        viewGroup.removeView(b.this.ehX);
                    }
                    b.this.ehX.setVisibility(0);
                    b.this.gXv = false;
                    b.this.bQk();
                    b.this.gXq = 0;
                    b.this.td(0);
                    b.this.gXv = true;
                    b.this.mPullView.resume();
                    b.this.gXc.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.11.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gXv = false;
                        }
                    }, 0L);
                    b.this.gXc.setVisibility(0);
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
        if (this.gXv) {
            bQw();
        }
    }
}
