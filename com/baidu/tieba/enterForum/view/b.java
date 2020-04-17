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
    private static boolean gIr = false;
    private View aXv;
    private ImageView dTJ;
    private View fjx;
    private int gBH;
    private int gGj;
    private View gIC;
    private float gID;
    private final EnterForumFragment gIk;
    private BdListView gIl;
    private com.baidu.tieba.enterForum.a.a gIm;
    private List<h> gIn;
    private l gIo;
    private CommonTipView gIp;
    private EnterForumAdView gIq;
    private int gIs;
    private e gIt;
    private int gIv;
    private g.c gIw;
    private com.baidu.adp.lib.guide.c gvi;
    private ViewEventCenter gyO;
    private com.baidu.tieba.enterForum.data.d gyT;
    private Context mContext;
    private int mNavHeight;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean gIu = true;
    private g.c eXI = new g.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.gIE) {
                com.baidu.tieba.s.c.cVr().z(b.this.gIk.getUniqueId());
                if (b.this.gIw != null) {
                    b.this.gIw.onListPullRefresh(z);
                }
                if (z && !b.this.gzE && b.this.gyT != null && b.this.gyT.gzE) {
                    if (b.this.gyT.gzG > 0) {
                        b.this.gIl.smoothScrollToPosition(0, 0, 0);
                        b.this.bJU();
                        return;
                    }
                    com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gIl.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int eRD = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.gIt.onScrollStateChanged(absListView, i);
            if (this.eRD != i) {
                this.eRD = i;
                if (this.eRD == 1) {
                    if (b.this.gyT == null || !b.this.gyT.gzE) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.bJZ();
                    return;
                }
                b.this.bJO();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.gIk.isPrimary() && this.eRD != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.gIl.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.f)) {
                        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) itemAtPosition;
                        if (fVar.getType() == 1 && b.this.gIl.getItemAtPosition(i4) == v.getItem(b.this.gIn, 0)) {
                            b.this.a(fVar, b.this.gIl.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.gIt.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener gIx = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gyT != null && b.this.gyT.gzE && b.this.gzE) {
                EnterForumAdView unused = b.this.gIq;
                EnterForumAdView.a(b.this.gIk.getUniqueId(), b.this.gIk.getContext());
            }
        }
    };
    private int gIy = 0;
    private int gIz = 0;
    boolean gzE = false;
    boolean gIA = false;
    private Runnable gIB = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // java.lang.Runnable
        public void run() {
            b.this.bJW();
        }
    };
    private boolean gIE = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        if (bJP()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.gyT != null && this.gyT.gzE) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean bJP() {
        return this.gIl == null || this.gIl.getChildCount() == 0 || this.gIl.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.gIk = enterForumFragment;
        this.gBH = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.gGj = com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.gIv = com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.gyO = viewEventCenter;
        bP(view);
        this.gIm = new com.baidu.tieba.enterForum.a.a(this.gIk.getPageContext(), this.gyO, recentlyVisitedForumModel, enterForumModel, this);
        this.gIl.setAdapter((ListAdapter) this.gIm);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bP(View view) {
        this.mContext = view.getContext();
        this.gIt = new e();
        this.gIt.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.14
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.gIE) {
                    b.this.gIy = -i;
                    if (b.this.gzE) {
                        b.this.bJW();
                    } else if (b.this.gyT != null && b.this.gyT.gzE) {
                        b.this.bJQ();
                    }
                }
            }
        });
        this.gIl = (BdListView) view.findViewById(R.id.listview);
        sy(0);
        this.gIl.setBackgroundColor(0);
        this.gIl.setVerticalScrollBarEnabled(false);
        this.gIl.setOnScrollListener(this.mOnScrollListener);
        this.gIl.setFastScrollEnabled(false);
        this.gIl.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.gIk.bIq() != null) {
            this.gIk.bIq().a(this);
        }
        this.mPullView = new com.baidu.tbadk.core.view.h(this.gIk.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.15
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.gIz = i3;
                if (!b.this.gzE && b.this.gyT != null && b.this.gyT.gzE && !b.this.gIE) {
                    b.this.bJQ();
                    if (i3 > b.this.gIv) {
                        b.this.gIz = 0;
                        b.this.bS(b.this.gIk.bIq().getRootView());
                    }
                }
            }
        });
        this.mPullView.gR(true);
        this.mPullView.setListPullRefreshListener(this.eXI);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.gIk.getUniqueId());
        }
        this.gIl.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.gIk.getPageContext().getPageActivity());
        this.fjx = new View(this.gIk.getPageContext().getPageActivity());
        frameLayout.addView(this.fjx, new FrameLayout.LayoutParams(-1, this.gGj));
        this.gIl.getAdapter2().addHeaderView(frameLayout, 0);
        this.aXv = new View(this.gIk.getActivity());
        this.aXv.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gIk.getActivity(), R.dimen.ds50)));
        this.aXv.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.gIx);
        this.mPullView.getView().setOnClickListener(this.gIx);
        this.fjx.setOnClickListener(this.gIx);
        bKa();
    }

    public void bQ(View view) {
        this.gIq = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.gIq != null) {
            bJQ();
            this.gIq.setTag(this.gIk.getUniqueId());
            this.gIq.setAdData();
            this.gIq.setEventCenter(this.gyO);
            this.gIq.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJQ() {
        if (!this.gIE && this.gIq != null) {
            ViewGroup.LayoutParams layoutParams = this.gIq.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bJR = bJR();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.gzE ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gIy + this.gIz) - bJR, 0, 0);
                this.gIq.setLayoutParams(layoutParams2);
                this.gIq.setAdViewHeight(layoutParams2.height - bJR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJR() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bJS() {
        return this.gzE ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gIy + this.gIz) - bJR();
    }

    private int bJT() {
        ViewGroup.LayoutParams layoutParams = this.gIq.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bJU() {
        if (!this.gIE) {
            this.gzE = true;
            bJQ();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.gIq != null) {
                if (!this.gIq.bJL()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.gIq.bJK()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            sy(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gIB);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.gIB, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sy(int i) {
        if (!this.gIE) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gIl.getLayoutParams();
            marginLayoutParams.topMargin = ((this.gBH + i) - this.gGj) - (EnterForumDelegateStatic.gAA.bIU() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.gIl.setLayoutParams(marginLayoutParams);
        }
    }

    private int bJV() {
        return (this.gBH - this.gGj) - (EnterForumDelegateStatic.gAA.bIU() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJW() {
        this.gzE = false;
        bJQ();
        sy(0);
        if (this.gIA) {
            this.gIl.completePullRefreshPostDelayed(0L);
        }
        this.gIA = false;
    }

    public void bR(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.gIk.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.gIk.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.gIl.setVisibility(8);
        if (this.gIk.bIq() != null) {
            this.gIk.bIq().bIE();
            this.gIk.bIq().bIF();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.gIl.setVisibility(0);
        if (this.gIk.bIq() != null) {
            this.gIk.bIq().bIE();
            this.gIk.bIq().bIF();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.gIn);
    }

    public void a(h hVar, boolean z) {
        this.gIn.remove(hVar);
        a(this.gIn, this.gIo, z);
        lY(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bJX() {
        return this.gIl;
    }

    public void startPullRefresh() {
        this.gIl.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.gzE) {
            this.gIA = true;
            return;
        }
        this.gIA = false;
        this.gIl.completePullRefreshPostDelayed(0L);
    }

    public void lY(boolean z) {
        this.gIm.notifyDataSetChanged();
        if (this.aXv != null && this.aXv.getLayoutParams() != null) {
            if (z) {
                this.aXv.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.aXv.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<h> list, l lVar, boolean z) {
        this.gIq.setAdData();
        EnterForumDelegateStatic.gAA.eE(this.mContext);
        this.gIn = list;
        this.gIo = lVar;
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
                arrayList.addAll(lVar.bHY());
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
        this.gIm.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.gIl.removeFooterView(this.aXv);
            this.gIl.addFooterView(this.aXv);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.gIl.removeFooterView(this.aXv);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.aXv, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.gIw = cVar;
    }

    public void bJY() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.gIk != null && this.gIk.getActivity() != null && this.gIk.bIp() != null) {
            if (this.gIp == null) {
                this.gIp = new CommonTipView(this.gIk.getActivity());
            }
            this.gIp.setText(R.string.enter_forum_login_tip);
            this.gIp.c(this.gIk.bIp(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.gIk.isAdded() && this.gIk.isPrimary()) {
            gIr = false;
            if (this.gIm != null) {
                this.gIm.onPrimary();
                if (this.gIl != null) {
                    Object itemAtPosition = this.gIl.getItemAtPosition(this.gIl.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.f) && ((com.baidu.tieba.enterForum.data.f) itemAtPosition).getType() == 5) {
                        this.gIm.bHw();
                    }
                }
            }
            if (this.gIE) {
                this.gIq.requestFocus();
                this.gIq.requestFocusFromTouch();
                return;
            }
            return;
        }
        bJZ();
    }

    public void onPause() {
        bJZ();
    }

    public void onDestroy() {
        if (this.gIp != null) {
            this.gIp.onDestroy();
        }
        if (this.gIm != null) {
            this.gIm.onDestroy();
        }
    }

    public void sd(int i) {
        this.gIm.sd(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gIm != null) {
            this.gIm.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bHv() {
        if (this.gIm == null) {
            return false;
        }
        return this.gIm.bHv();
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, View view) {
        if (TbadkCoreApplication.isLogin() && !gIr && this.gIk.getActivity() != null && this.gIk.getPageContext() != null && (fVar instanceof h)) {
            h hVar = (h) fVar;
            if (hVar.isPrivateForum() != 0 && hVar.bHM() != 0 && !com.baidu.tbadk.core.sharedPref.b.aNV().getString("enter_forum_new_forum_long_press_guide", "").equals(hVar.getId())) {
                this.gIs = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aNV().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.gIs = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                gIr = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).Y(0).ae(true).af(false).ad(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.18
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.gIs);
                        b.this.gIk.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.gvi = dVar.km();
                this.gvi.setShouldCheckLocInWindow(false);
                this.gvi.setUseDirectOffset(true);
                this.gvi.show(this.gIk.getActivity());
                if (this.gIs == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putString("enter_forum_new_forum_long_press_guide", hVar.getId());
                } else if (this.gIs == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.gvi != null) {
                            b.this.gvi.dismiss();
                            b.this.gvi = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bJZ() {
        if (this.gvi != null) {
            this.gvi.dismiss();
            this.gvi = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gyT = dVar;
        if (this.gIm != null) {
            this.gIm.setAdState(dVar);
        }
        if (dVar != null && dVar.gzE) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.lx(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.lx(R.raw.lottie_common_pull_refresh);
    }

    public void lZ(boolean z) {
        if (this.gIu != z) {
            this.gIu = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gIl.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.gIl.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.gIl.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.gIl.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.gIq != null) {
            this.gIq.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.gIq != null) {
            this.gIq.setRecentlyIsShow(z);
        }
    }

    private void bKa() {
        this.mNavHeight = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds240);
        this.gIC = new View(this.mContext);
        this.gIC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.gIk.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.gIC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            private float gIH = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gID = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.gID <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gID) {
                            b.this.bKb();
                            if (this.gIH < 50.0f) {
                                b.this.gIC.performClick();
                            }
                        } else {
                            b.this.bKc();
                        }
                        b.this.gID = 0.0f;
                        this.gIH = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.gID) {
                            b.this.ah(motionEvent.getRawY() - b.this.gID);
                            if (b.this.dTJ != null) {
                                b.this.dTJ.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.gID) > this.gIH) {
                            this.gIH = Math.abs(motionEvent.getRawY() - b.this.gID);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.gID <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gID) {
                            b.this.bKb();
                        } else {
                            b.this.bKc();
                        }
                        b.this.gID = 0.0f;
                        this.gIH = 0.0f;
                        return true;
                }
            }
        });
        this.dTJ = new ImageView(this.mContext);
        this.dTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bKc();
            }
        });
    }

    public void bS(final View view) {
        if ((view instanceof FrameLayout) && !this.gIE) {
            this.mPullView.pause();
            this.gIE = true;
            this.gIq.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.dTJ, R.drawable.icon_jinba_retract_n);
            final int bJT = bJT();
            ValueAnimator ofInt = ValueAnimator.ofInt(bJT, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.gIq != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gIq.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bJR();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.gIq.setLayoutParams(marginLayoutParams);
                            if (intValue / bJT < 0.2d) {
                                if (b.this.gIq.getParent() != b.this.gIq.getRootView() && (viewGroup = (ViewGroup) b.this.gIq.getRootView()) != null) {
                                    ((ViewGroup) b.this.gIq.getParent()).removeView(b.this.gIq);
                                    if (b.this.gIq.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.gIq, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.gIC);
                                    viewGroup.bringChildToFront(b.this.dTJ);
                                }
                            } else if (b.this.gIq.getParent() == b.this.gIq.getRootView()) {
                                if (b.this.gIq.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.gIq.getRootView();
                                    ((ViewGroup) b.this.gIq.getParent()).removeView(b.this.gIq);
                                }
                                if (b.this.gIq.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.gIk.bIt().addView(b.this.gIq, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.gIE = false;
                    b.this.sy(((intValue - bJT) * 2) + 0);
                    b.this.gIE = true;
                    float abs = Math.abs(intValue / bJT);
                    b.this.gIl.setAlpha(abs);
                    View bIH = b.this.gIk.bIq().bIH();
                    if (bIH != null) {
                        bIH.setAlpha(abs);
                    }
                    View findViewById = b.this.gIk.bIt().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.gIq != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gIq.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bJR();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.gIq.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.gIl.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.gIE = false;
                    b.this.sy(0 - (bJT * 2));
                    b.this.gIE = true;
                    b.this.gIl.setVisibility(8);
                    b.this.gIC.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.gIC.getParent() == null) {
                        frameLayout.addView(b.this.gIC, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.dTJ.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.dTJ, layoutParams3);
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
            this.gIq.requestFocus();
            this.gIq.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(float f) {
        ViewGroup viewGroup;
        int bJS = bJS();
        float abs = Math.abs(bJS / (bJV() - bJS));
        int i = (int) f;
        if (this.gIq != null) {
            ViewGroup.LayoutParams layoutParams = this.gIq.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bJR();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.gIq.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.gIq.getParent() != this.gIq.getRootView() && (viewGroup = (ViewGroup) this.gIq.getRootView()) != null) {
                        ((ViewGroup) this.gIq.getParent()).removeView(this.gIq);
                        if (this.gIq.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.gIq, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.gIC);
                        viewGroup.bringChildToFront(this.dTJ);
                    }
                } else if (this.gIq.getParent() == this.gIq.getRootView()) {
                    if (this.gIq.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.gIq.getRootView();
                        ((ViewGroup) this.gIq.getParent()).removeView(this.gIq);
                    }
                    if (this.gIq.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.gIk.bIt().addView(this.gIq, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.gIl.setVisibility(0);
        this.gIE = false;
        sy(((int) ((i * abs) - (bJS * abs))) * 2);
        this.gIE = true;
        float abs2 = Math.abs(i / bJS);
        this.gIl.setAlpha(abs2);
        View bIH = this.gIk.bIq().bIH();
        if (bIH != null) {
            bIH.setAlpha(abs2);
        }
        View findViewById = this.gIk.bIt().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKb() {
        if (this.dTJ != null) {
            this.dTJ.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bJT(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ah(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ah(0.0f);
                b.this.mPullView.resume();
                b.this.gIl.completePullRefresh();
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
    public void bKc() {
        this.gIC.setEnabled(false);
        int bJS = bJS();
        Math.abs(bJS / (bJV() - bJS));
        this.dTJ.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.gIq.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bJT(), bJS);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ah(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.11.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.gIC.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.gIC);
                        viewGroup.removeView(b.this.dTJ);
                    }
                    b.this.dTJ.setVisibility(0);
                    b.this.gIE = false;
                    b.this.bJQ();
                    b.this.gIz = 0;
                    b.this.sy(0);
                    b.this.gIE = true;
                    b.this.mPullView.resume();
                    b.this.gIl.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.11.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gIE = false;
                        }
                    }, 0L);
                    b.this.gIl.setVisibility(0);
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
        if (this.gIE) {
            bKc();
        }
    }
}
