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
    private static boolean gIx = false;
    private View aXA;
    private ImageView dTO;
    private View fjC;
    private int gBN;
    private int gGp;
    private int gIB;
    private g.c gIC;
    private View gII;
    private float gIJ;
    private final EnterForumFragment gIq;
    private BdListView gIr;
    private com.baidu.tieba.enterForum.a.a gIs;
    private List<h> gIt;
    private l gIu;
    private CommonTipView gIv;
    private EnterForumAdView gIw;
    private int gIy;
    private e gIz;
    private com.baidu.adp.lib.guide.c gvo;
    private ViewEventCenter gyU;
    private com.baidu.tieba.enterForum.data.d gyZ;
    private Context mContext;
    private int mNavHeight;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean gIA = true;
    private g.c eXN = new g.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.gIK) {
                com.baidu.tieba.s.c.cVo().z(b.this.gIq.getUniqueId());
                if (b.this.gIC != null) {
                    b.this.gIC.onListPullRefresh(z);
                }
                if (z && !b.this.gzK && b.this.gyZ != null && b.this.gyZ.gzK) {
                    if (b.this.gyZ.gzM > 0) {
                        b.this.gIr.smoothScrollToPosition(0, 0, 0);
                        b.this.bJS();
                        return;
                    }
                    com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gIr.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int eRI = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.gIz.onScrollStateChanged(absListView, i);
            if (this.eRI != i) {
                this.eRI = i;
                if (this.eRI == 1) {
                    if (b.this.gyZ == null || !b.this.gyZ.gzK) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.bJX();
                    return;
                }
                b.this.bJM();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.gIq.isPrimary() && this.eRI != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.gIr.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.f)) {
                        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) itemAtPosition;
                        if (fVar.getType() == 1 && b.this.gIr.getItemAtPosition(i4) == v.getItem(b.this.gIt, 0)) {
                            b.this.a(fVar, b.this.gIr.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.gIz.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener gID = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gyZ != null && b.this.gyZ.gzK && b.this.gzK) {
                EnterForumAdView unused = b.this.gIw;
                EnterForumAdView.a(b.this.gIq.getUniqueId(), b.this.gIq.getContext());
            }
        }
    };
    private int gIE = 0;
    private int gIF = 0;
    boolean gzK = false;
    boolean gIG = false;
    private Runnable gIH = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // java.lang.Runnable
        public void run() {
            b.this.bJU();
        }
    };
    private boolean gIK = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bJM() {
        if (bJN()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.gyZ != null && this.gyZ.gzK) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean bJN() {
        return this.gIr == null || this.gIr.getChildCount() == 0 || this.gIr.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.gIq = enterForumFragment;
        this.gBN = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.gGp = com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.gIB = com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.gyU = viewEventCenter;
        bP(view);
        this.gIs = new com.baidu.tieba.enterForum.a.a(this.gIq.getPageContext(), this.gyU, recentlyVisitedForumModel, enterForumModel, this);
        this.gIr.setAdapter((ListAdapter) this.gIs);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bP(View view) {
        this.mContext = view.getContext();
        this.gIz = new e();
        this.gIz.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.14
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.gIK) {
                    b.this.gIE = -i;
                    if (b.this.gzK) {
                        b.this.bJU();
                    } else if (b.this.gyZ != null && b.this.gyZ.gzK) {
                        b.this.bJO();
                    }
                }
            }
        });
        this.gIr = (BdListView) view.findViewById(R.id.listview);
        sy(0);
        this.gIr.setBackgroundColor(0);
        this.gIr.setVerticalScrollBarEnabled(false);
        this.gIr.setOnScrollListener(this.mOnScrollListener);
        this.gIr.setFastScrollEnabled(false);
        this.gIr.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.gIq.bIo() != null) {
            this.gIq.bIo().a(this);
        }
        this.mPullView = new com.baidu.tbadk.core.view.h(this.gIq.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.15
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.gIF = i3;
                if (!b.this.gzK && b.this.gyZ != null && b.this.gyZ.gzK && !b.this.gIK) {
                    b.this.bJO();
                    if (i3 > b.this.gIB) {
                        b.this.gIF = 0;
                        b.this.bS(b.this.gIq.bIo().getRootView());
                    }
                }
            }
        });
        this.mPullView.gR(true);
        this.mPullView.setListPullRefreshListener(this.eXN);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.gIq.getUniqueId());
        }
        this.gIr.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.gIq.getPageContext().getPageActivity());
        this.fjC = new View(this.gIq.getPageContext().getPageActivity());
        frameLayout.addView(this.fjC, new FrameLayout.LayoutParams(-1, this.gGp));
        this.gIr.getAdapter2().addHeaderView(frameLayout, 0);
        this.aXA = new View(this.gIq.getActivity());
        this.aXA.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gIq.getActivity(), R.dimen.ds50)));
        this.aXA.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.gID);
        this.mPullView.getView().setOnClickListener(this.gID);
        this.fjC.setOnClickListener(this.gID);
        bJY();
    }

    public void bQ(View view) {
        this.gIw = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.gIw != null) {
            bJO();
            this.gIw.setTag(this.gIq.getUniqueId());
            this.gIw.setAdData();
            this.gIw.setEventCenter(this.gyU);
            this.gIw.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJO() {
        if (!this.gIK && this.gIw != null) {
            ViewGroup.LayoutParams layoutParams = this.gIw.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bJP = bJP();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.gzK ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gIE + this.gIF) - bJP, 0, 0);
                this.gIw.setLayoutParams(layoutParams2);
                this.gIw.setAdViewHeight(layoutParams2.height - bJP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bJP() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bJQ() {
        return this.gzK ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gIE + this.gIF) - bJP();
    }

    private int bJR() {
        ViewGroup.LayoutParams layoutParams = this.gIw.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bJS() {
        if (!this.gIK) {
            this.gzK = true;
            bJO();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.gIw != null) {
                if (!this.gIw.bJJ()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.gIw.bJI()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            sy(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.gIH);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.gIH, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sy(int i) {
        if (!this.gIK) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gIr.getLayoutParams();
            marginLayoutParams.topMargin = ((this.gBN + i) - this.gGp) - (EnterForumDelegateStatic.gAG.bIS() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.gIr.setLayoutParams(marginLayoutParams);
        }
    }

    private int bJT() {
        return (this.gBN - this.gGp) - (EnterForumDelegateStatic.gAG.bIS() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJU() {
        this.gzK = false;
        bJO();
        sy(0);
        if (this.gIG) {
            this.gIr.completePullRefreshPostDelayed(0L);
        }
        this.gIG = false;
    }

    public void bR(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.gIq.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.gIq.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.gIr.setVisibility(8);
        if (this.gIq.bIo() != null) {
            this.gIq.bIo().bIC();
            this.gIq.bIo().bID();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.gIr.setVisibility(0);
        if (this.gIq.bIo() != null) {
            this.gIq.bIo().bIC();
            this.gIq.bIo().bID();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.gIt);
    }

    public void a(h hVar, boolean z) {
        this.gIt.remove(hVar);
        a(this.gIt, this.gIu, z);
        lY(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bJV() {
        return this.gIr;
    }

    public void startPullRefresh() {
        this.gIr.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.gzK) {
            this.gIG = true;
            return;
        }
        this.gIG = false;
        this.gIr.completePullRefreshPostDelayed(0L);
    }

    public void lY(boolean z) {
        this.gIs.notifyDataSetChanged();
        if (this.aXA != null && this.aXA.getLayoutParams() != null) {
            if (z) {
                this.aXA.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.aXA.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<h> list, l lVar, boolean z) {
        this.gIw.setAdData();
        EnterForumDelegateStatic.gAG.es(this.mContext);
        this.gIt = list;
        this.gIu = lVar;
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
                arrayList.addAll(lVar.bHW());
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
        this.gIs.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.gIr.removeFooterView(this.aXA);
            this.gIr.addFooterView(this.aXA);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.gIr.removeFooterView(this.aXA);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.aXA, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.gIC = cVar;
    }

    public void bJW() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.gIq != null && this.gIq.getActivity() != null && this.gIq.bIn() != null) {
            if (this.gIv == null) {
                this.gIv = new CommonTipView(this.gIq.getActivity());
            }
            this.gIv.setText(R.string.enter_forum_login_tip);
            this.gIv.c(this.gIq.bIn(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.gIq.isAdded() && this.gIq.isPrimary()) {
            gIx = false;
            if (this.gIs != null) {
                this.gIs.onPrimary();
                if (this.gIr != null) {
                    Object itemAtPosition = this.gIr.getItemAtPosition(this.gIr.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.f) && ((com.baidu.tieba.enterForum.data.f) itemAtPosition).getType() == 5) {
                        this.gIs.bHu();
                    }
                }
            }
            if (this.gIK) {
                this.gIw.requestFocus();
                this.gIw.requestFocusFromTouch();
                return;
            }
            return;
        }
        bJX();
    }

    public void onPause() {
        bJX();
    }

    public void onDestroy() {
        if (this.gIv != null) {
            this.gIv.onDestroy();
        }
        if (this.gIs != null) {
            this.gIs.onDestroy();
        }
    }

    public void sd(int i) {
        this.gIs.sd(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gIs != null) {
            this.gIs.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bHt() {
        if (this.gIs == null) {
            return false;
        }
        return this.gIs.bHt();
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, View view) {
        if (TbadkCoreApplication.isLogin() && !gIx && this.gIq.getActivity() != null && this.gIq.getPageContext() != null && (fVar instanceof h)) {
            h hVar = (h) fVar;
            if (hVar.isPrivateForum() != 0 && hVar.bHK() != 0 && !com.baidu.tbadk.core.sharedPref.b.aNT().getString("enter_forum_new_forum_long_press_guide", "").equals(hVar.getId())) {
                this.gIy = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aNT().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.gIy = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                gIx = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).Y(0).ae(true).af(false).ad(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.18
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.gIy);
                        b.this.gIq.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.gvo = dVar.km();
                this.gvo.setShouldCheckLocInWindow(false);
                this.gvo.setUseDirectOffset(true);
                this.gvo.show(this.gIq.getActivity());
                if (this.gIy == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("enter_forum_new_forum_long_press_guide", hVar.getId());
                } else if (this.gIy == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.gvo != null) {
                            b.this.gvo.dismiss();
                            b.this.gvo = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bJX() {
        if (this.gvo != null) {
            this.gvo.dismiss();
            this.gvo = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gyZ = dVar;
        if (this.gIs != null) {
            this.gIs.setAdState(dVar);
        }
        if (dVar != null && dVar.gzK) {
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
        if (this.gIA != z) {
            this.gIA = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gIr.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.gIr.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.gIr.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.gIr.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.gIw != null) {
            this.gIw.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.gIw != null) {
            this.gIw.setRecentlyIsShow(z);
        }
    }

    private void bJY() {
        this.mNavHeight = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds240);
        this.gII = new View(this.mContext);
        this.gII.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.gIq.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.gII.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            private float gIN = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gIJ = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.gIJ <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gIJ) {
                            b.this.bJZ();
                            if (this.gIN < 50.0f) {
                                b.this.gII.performClick();
                            }
                        } else {
                            b.this.bKa();
                        }
                        b.this.gIJ = 0.0f;
                        this.gIN = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.gIJ) {
                            b.this.ah(motionEvent.getRawY() - b.this.gIJ);
                            if (b.this.dTO != null) {
                                b.this.dTO.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.gIJ) > this.gIN) {
                            this.gIN = Math.abs(motionEvent.getRawY() - b.this.gIJ);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.gIJ <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gIJ) {
                            b.this.bJZ();
                        } else {
                            b.this.bKa();
                        }
                        b.this.gIJ = 0.0f;
                        this.gIN = 0.0f;
                        return true;
                }
            }
        });
        this.dTO = new ImageView(this.mContext);
        this.dTO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bKa();
            }
        });
    }

    public void bS(final View view) {
        if ((view instanceof FrameLayout) && !this.gIK) {
            this.mPullView.pause();
            this.gIK = true;
            this.gIw.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.dTO, R.drawable.icon_jinba_retract_n);
            final int bJR = bJR();
            ValueAnimator ofInt = ValueAnimator.ofInt(bJR, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.gIw != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gIw.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bJP();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.gIw.setLayoutParams(marginLayoutParams);
                            if (intValue / bJR < 0.2d) {
                                if (b.this.gIw.getParent() != b.this.gIw.getRootView() && (viewGroup = (ViewGroup) b.this.gIw.getRootView()) != null) {
                                    ((ViewGroup) b.this.gIw.getParent()).removeView(b.this.gIw);
                                    if (b.this.gIw.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.gIw, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.gII);
                                    viewGroup.bringChildToFront(b.this.dTO);
                                }
                            } else if (b.this.gIw.getParent() == b.this.gIw.getRootView()) {
                                if (b.this.gIw.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.gIw.getRootView();
                                    ((ViewGroup) b.this.gIw.getParent()).removeView(b.this.gIw);
                                }
                                if (b.this.gIw.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.gIq.bIr().addView(b.this.gIw, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.gIK = false;
                    b.this.sy(((intValue - bJR) * 2) + 0);
                    b.this.gIK = true;
                    float abs = Math.abs(intValue / bJR);
                    b.this.gIr.setAlpha(abs);
                    View bIF = b.this.gIq.bIo().bIF();
                    if (bIF != null) {
                        bIF.setAlpha(abs);
                    }
                    View findViewById = b.this.gIq.bIr().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.gIw != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gIw.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bJP();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.gIw.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.gIr.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.gIK = false;
                    b.this.sy(0 - (bJR * 2));
                    b.this.gIK = true;
                    b.this.gIr.setVisibility(8);
                    b.this.gII.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.gII.getParent() == null) {
                        frameLayout.addView(b.this.gII, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.dTO.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.dTO, layoutParams3);
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
            this.gIw.requestFocus();
            this.gIw.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(float f) {
        ViewGroup viewGroup;
        int bJQ = bJQ();
        float abs = Math.abs(bJQ / (bJT() - bJQ));
        int i = (int) f;
        if (this.gIw != null) {
            ViewGroup.LayoutParams layoutParams = this.gIw.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bJP();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.gIw.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.gIw.getParent() != this.gIw.getRootView() && (viewGroup = (ViewGroup) this.gIw.getRootView()) != null) {
                        ((ViewGroup) this.gIw.getParent()).removeView(this.gIw);
                        if (this.gIw.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.gIw, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.gII);
                        viewGroup.bringChildToFront(this.dTO);
                    }
                } else if (this.gIw.getParent() == this.gIw.getRootView()) {
                    if (this.gIw.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.gIw.getRootView();
                        ((ViewGroup) this.gIw.getParent()).removeView(this.gIw);
                    }
                    if (this.gIw.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.gIq.bIr().addView(this.gIw, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.gIr.setVisibility(0);
        this.gIK = false;
        sy(((int) ((i * abs) - (bJQ * abs))) * 2);
        this.gIK = true;
        float abs2 = Math.abs(i / bJQ);
        this.gIr.setAlpha(abs2);
        View bIF = this.gIq.bIo().bIF();
        if (bIF != null) {
            bIF.setAlpha(abs2);
        }
        View findViewById = this.gIq.bIr().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        if (this.dTO != null) {
            this.dTO.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bJR(), 0);
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
                b.this.gIr.completePullRefresh();
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
    public void bKa() {
        this.gII.setEnabled(false);
        int bJQ = bJQ();
        Math.abs(bJQ / (bJT() - bJQ));
        this.dTO.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.gIw.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bJR(), bJQ);
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
                    ViewGroup viewGroup = (ViewGroup) b.this.gII.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.gII);
                        viewGroup.removeView(b.this.dTO);
                    }
                    b.this.dTO.setVisibility(0);
                    b.this.gIK = false;
                    b.this.bJO();
                    b.this.gIF = 0;
                    b.this.sy(0);
                    b.this.gIK = true;
                    b.this.mPullView.resume();
                    b.this.gIr.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.11.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gIK = false;
                        }
                    }, 0L);
                    b.this.gIr.setVisibility(0);
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
        if (this.gIK) {
            bKa();
        }
    }
}
