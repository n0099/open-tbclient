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
    private static boolean gXt = false;
    private View beU;
    private ImageView ehX;
    private View fxt;
    private com.baidu.adp.lib.guide.c gKk;
    private ViewEventCenter gNP;
    private com.baidu.tieba.enterForum.data.d gNU;
    private int gQH;
    private int gVi;
    private View gXE;
    private float gXF;
    private final EnterForumFragment gXm;
    private BdListView gXn;
    private com.baidu.tieba.enterForum.a.a gXo;
    private List<h> gXp;
    private l gXq;
    private CommonTipView gXr;
    private EnterForumAdView gXs;
    private int gXu;
    private e gXv;
    private int gXx;
    private f.c gXy;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean gXw = true;
    private f.c fkI = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.gXG) {
                com.baidu.tieba.s.c.dcI().C(b.this.gXm.getUniqueId());
                if (b.this.gXy != null) {
                    b.this.gXy.onListPullRefresh(z);
                }
                if (z && !b.this.gOF && b.this.gNU != null && b.this.gNU.gOF) {
                    if (b.this.gNU.gOH > 0) {
                        b.this.gXn.smoothScrollToPosition(0, 0, 0);
                        b.this.bQq();
                        return;
                    }
                    com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gXn.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int feB = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.gXv.onScrollStateChanged(absListView, i);
            if (this.feB != i) {
                this.feB = i;
                if (this.feB == 1) {
                    if (b.this.gNU == null || !b.this.gNU.gOF) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.bQv();
                    return;
                }
                b.this.bQk();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.gXm.isPrimary() && this.feB != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.gXn.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.f)) {
                        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) itemAtPosition;
                        if (fVar.getType() == 1 && b.this.gXn.getItemAtPosition(i4) == v.getItem(b.this.gXp, 0)) {
                            b.this.a(fVar, b.this.gXn.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.gXv.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener gXz = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gNU != null && b.this.gNU.gOF && b.this.gOF) {
                EnterForumAdView unused = b.this.gXs;
                EnterForumAdView.a(b.this.gXm.getUniqueId(), b.this.gXm.getContext());
            }
        }
    };
    private int gXA = 0;
    private int gXB = 0;
    boolean gOF = false;
    boolean gXC = false;
    private Runnable gXD = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // java.lang.Runnable
        public void run() {
            b.this.bQs();
        }
    };
    private boolean gXG = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bQk() {
        if (bQl()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.gNU != null && this.gNU.gOF) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean bQl() {
        return this.gXn == null || this.gXn.getChildCount() == 0 || this.gXn.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.gXm = enterForumFragment;
        this.gQH = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.gVi = com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.gXx = com.baidu.adp.lib.util.l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.gNP = viewEventCenter;
        bP(view);
        this.gXo = new com.baidu.tieba.enterForum.a.a(this.gXm.getPageContext(), this.gNP, recentlyVisitedForumModel, enterForumModel, this);
        this.gXn.setAdapter((ListAdapter) this.gXo);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bP(View view) {
        this.mContext = view.getContext();
        this.gXv = new e();
        this.gXv.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.14
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.gXG) {
                    b.this.gXA = -i;
                    if (b.this.gOF) {
                        b.this.bQs();
                    } else if (b.this.gNU != null && b.this.gNU.gOF) {
                        b.this.bQm();
                    }
                }
            }
        });
        this.gXn = (BdListView) view.findViewById(R.id.listview);
        tf(0);
        this.gXn.setBackgroundColor(0);
        this.gXn.setVerticalScrollBarEnabled(false);
        this.gXn.setOnScrollListener(this.mOnScrollListener);
        this.gXn.setFastScrollEnabled(false);
        this.gXn.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.gXm.bOK() != null) {
            this.gXm.bOK().a(this);
        }
        this.mPullView = new g(this.gXm.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.15
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.gXB = i3;
                if (!b.this.gOF && b.this.gNU != null && b.this.gNU.gOF && !b.this.gXG) {
                    b.this.bQm();
                    if (i3 > b.this.gXx) {
                        b.this.gXB = 0;
                        b.this.bS(b.this.gXm.bOK().getRootView());
                    }
                }
            }
        });
        this.mPullView.hk(true);
        this.mPullView.setListPullRefreshListener(this.fkI);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.gXm.getUniqueId());
        }
        this.gXn.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.gXm.getPageContext().getPageActivity());
        this.fxt = new View(this.gXm.getPageContext().getPageActivity());
        frameLayout.addView(this.fxt, new FrameLayout.LayoutParams(-1, this.gVi));
        this.gXn.getAdapter2().addHeaderView(frameLayout, 0);
        this.beU = new View(this.gXm.getActivity());
        this.beU.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(this.gXm.getActivity(), R.dimen.ds50)));
        this.beU.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.gXz);
        this.mPullView.getView().setOnClickListener(this.gXz);
        this.fxt.setOnClickListener(this.gXz);
        bQw();
    }

    public void bQ(View view) {
        this.gXs = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.gXs != null) {
            bQm();
            this.gXs.setTag(this.gXm.getUniqueId());
            this.gXs.setAdData();
            this.gXs.setEventCenter(this.gNP);
            this.gXs.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQm() {
        if (!this.gXG && this.gXs != null) {
            ViewGroup.LayoutParams layoutParams = this.gXs.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bQn = bQn();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.gOF ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gXA + this.gXB) - bQn, 0, 0);
                this.gXs.setLayoutParams(layoutParams2);
                this.gXs.setAdViewHeight(layoutParams2.height - bQn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bQn() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bQo() {
        return this.gOF ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gXA + this.gXB) - bQn();
    }

    private int bQp() {
        ViewGroup.LayoutParams layoutParams = this.gXs.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bQq() {
        if (!this.gXG) {
            this.gOF = true;
            bQm();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.gXs != null) {
                if (!this.gXs.bQh()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.gXs.bQg()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            tf(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.gXD);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.gXD, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf(int i) {
        if (!this.gXG) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gXn.getLayoutParams();
            marginLayoutParams.topMargin = ((this.gQH + i) - this.gVi) - (EnterForumDelegateStatic.gPB.bPo() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.gXn.setLayoutParams(marginLayoutParams);
        }
    }

    private int bQr() {
        return (this.gQH - this.gVi) - (EnterForumDelegateStatic.gPB.bPo() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQs() {
        this.gOF = false;
        bQm();
        tf(0);
        if (this.gXC) {
            this.gXn.completePullRefreshPostDelayed(0L);
        }
        this.gXC = false;
    }

    public void bR(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.gXm.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.gXm.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.gXn.setVisibility(8);
        if (this.gXm.bOK() != null) {
            this.gXm.bOK().bOY();
            this.gXm.bOK().bOZ();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.gXn.setVisibility(0);
        if (this.gXm.bOK() != null) {
            this.gXm.bOK().bOY();
            this.gXm.bOK().bOZ();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.gXp);
    }

    public void a(h hVar, boolean z) {
        this.gXp.remove(hVar);
        a(this.gXp, this.gXq, z);
        mt(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bQt() {
        return this.gXn;
    }

    public void startPullRefresh() {
        this.gXn.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.gOF) {
            this.gXC = true;
            return;
        }
        this.gXC = false;
        this.gXn.completePullRefreshPostDelayed(0L);
    }

    public void mt(boolean z) {
        this.gXo.notifyDataSetChanged();
        if (this.beU != null && this.beU.getLayoutParams() != null) {
            if (z) {
                this.beU.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.beU.getLayoutParams().height = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<h> list, l lVar, boolean z) {
        this.gXs.setAdData();
        EnterForumDelegateStatic.gPB.eH(this.mContext);
        this.gXp = list;
        this.gXq = lVar;
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
                arrayList.addAll(lVar.bOs());
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
        this.gXo.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.gXn.removeFooterView(this.beU);
            this.gXn.addFooterView(this.beU);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.gXn.removeFooterView(this.beU);
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
        this.gXy = cVar;
    }

    public void bQu() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.gXm != null && this.gXm.getActivity() != null && this.gXm.bOJ() != null) {
            if (this.gXr == null) {
                this.gXr = new CommonTipView(this.gXm.getActivity());
            }
            this.gXr.setText(R.string.enter_forum_login_tip);
            this.gXr.c(this.gXm.bOJ(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.gXm.isAdded() && this.gXm.isPrimary()) {
            gXt = false;
            if (this.gXo != null) {
                this.gXo.onPrimary();
                if (this.gXn != null) {
                    Object itemAtPosition = this.gXn.getItemAtPosition(this.gXn.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.f) && ((com.baidu.tieba.enterForum.data.f) itemAtPosition).getType() == 5) {
                        this.gXo.bNQ();
                    }
                }
            }
            if (this.gXG) {
                this.gXs.requestFocus();
                this.gXs.requestFocusFromTouch();
                return;
            }
            return;
        }
        bQv();
    }

    public void onPause() {
        bQv();
    }

    public void onDestroy() {
        if (this.gXr != null) {
            this.gXr.onDestroy();
        }
        if (this.gXo != null) {
            this.gXo.onDestroy();
        }
    }

    public void sK(int i) {
        this.gXo.sK(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gXo != null) {
            this.gXo.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bNP() {
        if (this.gXo == null) {
            return false;
        }
        return this.gXo.bNP();
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, View view) {
        if (TbadkCoreApplication.isLogin() && !gXt && this.gXm.getActivity() != null && this.gXm.getPageContext() != null && (fVar instanceof h)) {
            h hVar = (h) fVar;
            if (hVar.isPrivateForum() != 0 && hVar.bOg() != 0 && !com.baidu.tbadk.core.sharedPref.b.aTX().getString("enter_forum_new_forum_long_press_guide", "").equals(hVar.getId())) {
                this.gXu = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aTX().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.gXu = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                gXt = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).Z(0).ae(true).af(false).ad(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.18
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.gXu);
                        b.this.gXm.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.gKk = dVar.ko();
                this.gKk.setShouldCheckLocInWindow(false);
                this.gKk.setUseDirectOffset(true);
                this.gKk.show(this.gXm.getActivity());
                if (this.gXu == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("enter_forum_new_forum_long_press_guide", hVar.getId());
                } else if (this.gXu == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.gKk != null) {
                            b.this.gKk.dismiss();
                            b.this.gKk = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bQv() {
        if (this.gKk != null) {
            this.gKk.dismiss();
            this.gKk = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.d dVar) {
        this.gNU = dVar;
        if (this.gXo != null) {
            this.gXo.setAdState(dVar);
        }
        if (dVar != null && dVar.gOF) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.mb(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.mb(R.raw.lottie_common_pull_refresh);
    }

    public void mu(boolean z) {
        if (this.gXw != z) {
            this.gXw = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gXn.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.gXn.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.gXn.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.gXn.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.gXs != null) {
            this.gXs.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.gXs != null) {
            this.gXs.setRecentlyIsShow(z);
        }
    }

    private void bQw() {
        this.mNavHeight = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds240);
        this.gXE = new View(this.mContext);
        this.gXE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.gXm.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.gXE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            private float gXJ = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gXF = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.gXF <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gXF) {
                            b.this.bQx();
                            if (this.gXJ < 50.0f) {
                                b.this.gXE.performClick();
                            }
                        } else {
                            b.this.bQy();
                        }
                        b.this.gXF = 0.0f;
                        this.gXJ = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.gXF) {
                            b.this.af(motionEvent.getRawY() - b.this.gXF);
                            if (b.this.ehX != null) {
                                b.this.ehX.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.gXF) > this.gXJ) {
                            this.gXJ = Math.abs(motionEvent.getRawY() - b.this.gXF);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.gXF <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gXF) {
                            b.this.bQx();
                        } else {
                            b.this.bQy();
                        }
                        b.this.gXF = 0.0f;
                        this.gXJ = 0.0f;
                        return true;
                }
            }
        });
        this.ehX = new ImageView(this.mContext);
        this.ehX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bQy();
            }
        });
    }

    public void bS(final View view) {
        if ((view instanceof FrameLayout) && !this.gXG) {
            this.mPullView.pause();
            this.gXG = true;
            this.gXs.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.ehX, R.drawable.icon_jinba_retract_n);
            final int bQp = bQp();
            ValueAnimator ofInt = ValueAnimator.ofInt(bQp, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.gXs != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gXs.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bQn();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.gXs.setLayoutParams(marginLayoutParams);
                            if (intValue / bQp < 0.2d) {
                                if (b.this.gXs.getParent() != b.this.gXs.getRootView() && (viewGroup = (ViewGroup) b.this.gXs.getRootView()) != null) {
                                    ((ViewGroup) b.this.gXs.getParent()).removeView(b.this.gXs);
                                    if (b.this.gXs.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.gXs, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.gXE);
                                    viewGroup.bringChildToFront(b.this.ehX);
                                }
                            } else if (b.this.gXs.getParent() == b.this.gXs.getRootView()) {
                                if (b.this.gXs.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.gXs.getRootView();
                                    ((ViewGroup) b.this.gXs.getParent()).removeView(b.this.gXs);
                                }
                                if (b.this.gXs.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.gXm.bON().addView(b.this.gXs, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.gXG = false;
                    b.this.tf(((intValue - bQp) * 2) + 0);
                    b.this.gXG = true;
                    float abs = Math.abs(intValue / bQp);
                    b.this.gXn.setAlpha(abs);
                    View bPb = b.this.gXm.bOK().bPb();
                    if (bPb != null) {
                        bPb.setAlpha(abs);
                    }
                    View findViewById = b.this.gXm.bON().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.gXs != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gXs.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bQn();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.gXs.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.gXn.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.gXG = false;
                    b.this.tf(0 - (bQp * 2));
                    b.this.gXG = true;
                    b.this.gXn.setVisibility(8);
                    b.this.gXE.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.gXE.getParent() == null) {
                        frameLayout.addView(b.this.gXE, new FrameLayout.LayoutParams(-1, -1));
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
            this.gXs.requestFocus();
            this.gXs.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(float f) {
        ViewGroup viewGroup;
        int bQo = bQo();
        float abs = Math.abs(bQo / (bQr() - bQo));
        int i = (int) f;
        if (this.gXs != null) {
            ViewGroup.LayoutParams layoutParams = this.gXs.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bQn();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.gXs.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.gXs.getParent() != this.gXs.getRootView() && (viewGroup = (ViewGroup) this.gXs.getRootView()) != null) {
                        ((ViewGroup) this.gXs.getParent()).removeView(this.gXs);
                        if (this.gXs.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.gXs, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.gXE);
                        viewGroup.bringChildToFront(this.ehX);
                    }
                } else if (this.gXs.getParent() == this.gXs.getRootView()) {
                    if (this.gXs.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.gXs.getRootView();
                        ((ViewGroup) this.gXs.getParent()).removeView(this.gXs);
                    }
                    if (this.gXs.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.gXm.bON().addView(this.gXs, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.gXn.setVisibility(0);
        this.gXG = false;
        tf(((int) ((i * abs) - (bQo * abs))) * 2);
        this.gXG = true;
        float abs2 = Math.abs(i / bQo);
        this.gXn.setAlpha(abs2);
        View bPb = this.gXm.bOK().bPb();
        if (bPb != null) {
            bPb.setAlpha(abs2);
        }
        View findViewById = this.gXm.bON().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQx() {
        if (this.ehX != null) {
            this.ehX.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bQp(), 0);
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
                b.this.gXn.completePullRefresh();
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
    public void bQy() {
        this.gXE.setEnabled(false);
        int bQo = bQo();
        Math.abs(bQo / (bQr() - bQo));
        this.ehX.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.gXs.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bQp(), bQo);
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
                    ViewGroup viewGroup = (ViewGroup) b.this.gXE.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.gXE);
                        viewGroup.removeView(b.this.ehX);
                    }
                    b.this.ehX.setVisibility(0);
                    b.this.gXG = false;
                    b.this.bQm();
                    b.this.gXB = 0;
                    b.this.tf(0);
                    b.this.gXG = true;
                    b.this.mPullView.resume();
                    b.this.gXn.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.11.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gXG = false;
                        }
                    }, 0L);
                    b.this.gXn.setVisibility(0);
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
        if (this.gXG) {
            bQy();
        }
    }
}
