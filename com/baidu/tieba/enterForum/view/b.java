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
    private static boolean fgo = false;
    private ImageView aBm;
    private View arb;
    private View dLs;
    private com.baidu.adp.lib.guide.c eWj;
    private ViewEventCenter eZN;
    private com.baidu.tieba.enterForum.data.b eZS;
    private int fcB;
    private int ffL;
    private View fgA;
    private float fgB;
    private final EnterForumFragment fgh;
    private BdListView fgi;
    private com.baidu.tieba.enterForum.a.a fgj;
    private com.baidu.tieba.enterForum.multiConcern.a fgk;
    private List<com.baidu.tieba.enterForum.data.f> fgl;
    private CommonTipView fgm;
    private EnterForumAdView fgn;
    private int fgp;
    private e fgq;
    private int fgs;
    private h.c fgt;
    private Context mContext;
    private int mNavHeight;
    private i mPullView;
    private View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private boolean isFirst = true;
    private boolean fgr = true;
    private h.c dDX = new h.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.fgC) {
                com.baidu.tieba.q.c.cnk().y(b.this.fgh.getUniqueId());
                if (b.this.fgt != null) {
                    b.this.fgt.onListPullRefresh(z);
                }
                if (z && !b.this.fax && b.this.eZS != null && b.this.eZS.fax) {
                    if (b.this.eZS.faz > 0) {
                        b.this.fgi.smoothScrollToPosition(0, 0, 0);
                        b.this.bfy();
                        return;
                    }
                    com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fgi.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a fgu = new com.baidu.tbadk.task.a(2921425, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.fgC) {
                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bfG();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921425, Boolean.valueOf(b.this.fgC));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int dyr = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fgq.onScrollStateChanged(absListView, i);
            if (this.dyr != i) {
                this.dyr = i;
                if (this.dyr == 1) {
                    if ((b.this.eZS == null || !b.this.eZS.fax) && b.this.fgh != null && b.this.fgh.bek() != null) {
                        b.this.fgh.bek().aJA();
                    }
                    b.this.bfD();
                    return;
                }
                b.this.bfs();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fgh.isPrimary() && this.dyr != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.fgi.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.fgi.getItemAtPosition(i4) == v.getItem(b.this.fgl, 0)) {
                            b.this.a(dVar, b.this.fgi.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fgq.onScroll(absListView, i, i2, i3);
        }
    };
    c.a ffO = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void beE() {
            b.this.bfs();
        }
    };
    View.OnClickListener fgv = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eZS != null && b.this.eZS.fax && b.this.fax) {
                EnterForumAdView unused = b.this.fgn;
                EnterForumAdView.a(b.this.fgh.getUniqueId(), b.this.fgh.getContext());
            }
        }
    };
    private int fgw = 0;
    private int fgx = 0;
    boolean fax = false;
    boolean fgy = false;
    private Runnable fgz = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bfA();
        }
    };
    private boolean fgC = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bfs() {
        if (bft()) {
            if (this.fgh != null && this.fgh.bek() != null) {
                this.fgh.bek().aJB();
            }
        } else if (this.eZS != null && this.eZS.fax) {
            if (this.fgh != null && this.fgh.bek() != null) {
                this.fgh.bek().aJB();
            }
        } else if (this.fgh != null && this.fgh.bek() != null) {
            this.fgh.bek().aJA();
        }
    }

    private boolean bft() {
        return this.fgi == null || this.fgi.getChildCount() == 0 || this.fgi.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fgh = enterForumFragment;
        this.fcB = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds264);
        this.ffL = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.fgs = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.eZN = viewEventCenter;
        this.fgk = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bJ(view);
        this.fgj = new com.baidu.tieba.enterForum.a.a(this.fgh.getPageContext(), this.eZN, recentlyVisitedForumModel, enterForumModel, this);
        this.fgi.setAdapter((ListAdapter) this.fgj);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.mContext = view.getContext();
        this.fgq = new e();
        this.fgq.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.fgC) {
                    if (b.this.fgh.bek().bey() == 1) {
                        b.this.fgh.bek().e(absListView, 0, i2, 0, 0);
                    }
                    b.this.fgw = -i;
                    if (b.this.fax) {
                        b.this.bfA();
                    } else if (b.this.eZS != null && b.this.eZS.fax) {
                        b.this.bfu();
                    }
                }
            }
        });
        this.fgi = (BdListView) view.findViewById(R.id.listview);
        pJ(0);
        this.fgi.setBackgroundColor(0);
        this.fgi.setVerticalScrollBarEnabled(false);
        this.fgi.setOnScrollListener(this.mOnScrollListener);
        this.fgi.setFastScrollEnabled(false);
        this.fgi.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fgh.bek() != null) {
            this.fgh.bek().b(this.ffO);
            this.fgh.bek().a(this.ffO);
            this.fgh.bek().a(this);
        }
        this.mPullView = new i(this.fgh.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.fgx = i3;
                if (!b.this.fax && b.this.eZS != null && b.this.eZS.fax && !b.this.fgC) {
                    b.this.bfu();
                    if (i3 > b.this.fgs) {
                        b.this.fgx = 0;
                        b.this.bM(b.this.fgh.bek().getRootView());
                    }
                }
            }
        });
        this.mPullView.eu(true);
        this.mPullView.setListPullRefreshListener(this.dDX);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fgh.getUniqueId());
        }
        this.fgi.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.fgh.getPageContext().getPageActivity());
        this.dLs = new View(this.fgh.getPageContext().getPageActivity());
        frameLayout.addView(this.dLs, new FrameLayout.LayoutParams(-1, this.ffL));
        this.fgi.getAdapter2().addHeaderView(frameLayout, 0);
        this.arb = new View(this.fgh.getActivity());
        this.arb.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.fgh.getActivity(), R.dimen.ds50)));
        this.arb.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.fgv);
        this.mPullView.getView().setOnClickListener(this.fgv);
        this.dLs.setOnClickListener(this.fgv);
        bfE();
    }

    public void bK(View view) {
        this.fgn = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fgn != null) {
            bfu();
            this.fgn.setTag(this.fgh.getUniqueId());
            this.fgn.setAdData();
            this.fgn.setEventCenter(this.eZN);
            this.fgn.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfu() {
        if (!this.fgC && this.fgn != null) {
            ViewGroup.LayoutParams layoutParams = this.fgn.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bfv = bfv();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.fax ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fgw + this.fgx) - bfv, 0, 0);
                this.fgn.setLayoutParams(layoutParams2);
                this.fgn.setAdViewHeight(layoutParams2.height - bfv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bfv() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bfw() {
        return this.fax ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fgw + this.fgx) - bfv();
    }

    private int bfx() {
        ViewGroup.LayoutParams layoutParams = this.fgn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bfy() {
        if (!this.fgC) {
            this.fax = true;
            bfu();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.fgn != null) {
                if (!this.fgn.bfp()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.fgn.bfo()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            pJ(dimensionPixelOffset);
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.fgz);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.fgz, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(int i) {
        if (!this.fgC) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fgi.getLayoutParams();
            marginLayoutParams.topMargin = ((this.fcB + i) - this.ffL) - (EnterForumDelegateStatic.fbq.beK() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.fgi.setLayoutParams(marginLayoutParams);
        }
    }

    private int bfz() {
        return (this.fcB - this.ffL) - (EnterForumDelegateStatic.fbq.beK() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfA() {
        this.fax = false;
        bfu();
        pJ(0);
        if (this.fgy) {
            this.fgi.completePullRefreshPostDelayed(0L);
        }
        this.fgy = false;
    }

    public void bL(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(this.fgh.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.setSubText(this.fgh.getString(R.string.neterror));
        this.mRootView = view;
        int dimensionPixelSize = this.fgh.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize += UtilHelper.getStatusBarHeight();
        }
        this.refreshView.kc(dimensionPixelSize);
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.fgi.setVisibility(8);
        if (this.fgh.bek() != null) {
            this.fgh.bek().bez();
            this.fgh.bek().beA();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.fgi.setVisibility(0);
        if (this.fgh.bek() != null) {
            this.fgh.bek().bez();
            this.fgh.bek().beA();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.fgl);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fgl.remove(fVar);
        j(this.fgl, z);
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.m.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bfB() {
        return this.fgi;
    }

    public void startPullRefresh() {
        this.fgi.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.fax) {
            this.fgy = true;
            return;
        }
        this.fgy = false;
        this.fgi.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.fgj.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fgn.setAdData();
        EnterForumDelegateStatic.fbq.dr(this.mContext);
        this.fgl = list;
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
        this.fgj.setData(arrayList);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.fgi.removeFooterView(this.arb);
            this.fgi.addFooterView(this.arb);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.fgi.removeFooterView(this.arb);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fgk.beW() != null) {
            this.fgk.onChangeSkinType();
        }
        am.setBackgroundResource(this.arb, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.fgt = cVar;
    }

    public void bfC() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.fgh != null && this.fgh.getActivity() != null && this.fgh.bej() != null) {
            if (this.fgm == null) {
                this.fgm = new CommonTipView(this.fgh.getActivity());
            }
            this.fgm.setText(R.string.enter_forum_login_tip);
            this.fgm.c(this.fgh.bej(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.fgh.isAdded() && this.fgh.isPrimary()) {
            this.fgu.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.fgu.getCmd());
            MessageManager.getInstance().registerTask(this.fgu);
            this.fgn.setAdData();
            fgo = false;
            if (this.fgj != null) {
                this.fgj.onPrimary();
                if (this.fgi != null) {
                    Object itemAtPosition = this.fgi.getItemAtPosition(this.fgi.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fgj.bdC();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.fgC) {
                this.fgn.requestFocus();
                this.fgn.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.fgu.getCmd());
        bfD();
    }

    public void onPause() {
        bfD();
    }

    public void onDestroy() {
        if (this.fgm != null) {
            this.fgm.onDestroy();
        }
        if (this.fgk != null) {
            this.fgk.onDestroy();
        }
        if (this.fgj != null) {
            this.fgj.onDestroy();
        }
        if (this.fgh != null && this.fgh.bek() != null) {
            this.fgh.bek().b(this.ffO);
        }
    }

    public void pt(int i) {
        this.fgj.pt(i);
    }

    public void bX(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.fgk.isShowing() && !v.isEmpty(list)) {
            this.fgk.bT(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fgj != null) {
            this.fgj.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bdB() {
        if (this.fgj == null) {
            return false;
        }
        return this.fgj.bdB();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fgo && this.fgh.getActivity() != null && this.fgh.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bdR() != 0 && !com.baidu.tbadk.core.sharedPref.b.alR().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fgp = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.alR().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fgp = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fgo = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).I(0).B(true).C(false).A(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fgp);
                        b.this.fgh.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.eWj = dVar2.fu();
                this.eWj.setShouldCheckLocInWindow(false);
                this.eWj.setUseDirectOffset(true);
                this.eWj.show(this.fgh.getActivity());
                if (this.fgp == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fgp == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.eWj != null) {
                            b.this.eWj.dismiss();
                            b.this.eWj = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bfD() {
        if (this.eWj != null) {
            this.eWj.dismiss();
            this.eWj = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eZS = bVar;
        if (this.fgj != null) {
            this.fgj.setAdState(bVar);
        }
        if (bVar != null && bVar.fax) {
            this.mPullView.iP(R.raw.ad_refresh_load);
        } else {
            this.mPullView.iP(R.raw.refresh_load);
        }
    }

    public void jn(boolean z) {
        if (this.fgr != z) {
            this.fgr = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fgi.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.fgi.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.fgi.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.fgi.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fgn != null) {
            this.fgn.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fgn != null) {
            this.fgn.setRecentlyIsShow(z);
        }
    }

    private void bfE() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.fgA = new View(this.mContext);
        this.fgA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.fgh.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.fgA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float fgF = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fgB = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.fgB <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fgB) {
                            b.this.bfF();
                            if (this.fgF < 50.0f) {
                                b.this.fgA.performClick();
                            }
                        } else {
                            b.this.bfG();
                        }
                        b.this.fgB = 0.0f;
                        this.fgF = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.fgB) {
                            b.this.al(motionEvent.getRawY() - b.this.fgB);
                            if (b.this.aBm != null) {
                                b.this.aBm.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.fgB) > this.fgF) {
                            this.fgF = Math.abs(motionEvent.getRawY() - b.this.fgB);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.fgB <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fgB) {
                            b.this.bfF();
                        } else {
                            b.this.bfG();
                        }
                        b.this.fgB = 0.0f;
                        this.fgF = 0.0f;
                        return true;
                }
            }
        });
        this.aBm = new ImageView(this.mContext);
        this.aBm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bfG();
            }
        });
    }

    public void bM(final View view) {
        if ((view instanceof FrameLayout) && !this.fgC) {
            this.mPullView.pause();
            this.fgC = true;
            this.fgn.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.aBm, R.drawable.icon_jinba_retract_n);
            final int bfx = bfx();
            ValueAnimator ofInt = ValueAnimator.ofInt(bfx, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.fgn != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fgn.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bfv();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.fgn.setLayoutParams(marginLayoutParams);
                            if (intValue / bfx < 0.2d) {
                                if (b.this.fgn.getParent() != b.this.fgn.getRootView() && (viewGroup = (ViewGroup) b.this.fgn.getRootView()) != null) {
                                    ((ViewGroup) b.this.fgn.getParent()).removeView(b.this.fgn);
                                    if (b.this.fgn.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.fgn, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.fgA);
                                    viewGroup.bringChildToFront(b.this.aBm);
                                }
                            } else if (b.this.fgn.getParent() == b.this.fgn.getRootView()) {
                                if (b.this.fgn.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.fgn.getRootView();
                                    ((ViewGroup) b.this.fgn.getParent()).removeView(b.this.fgn);
                                }
                                if (b.this.fgn.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.fgh.bem().addView(b.this.fgn, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.fgC = false;
                    b.this.pJ(((intValue - bfx) * 2) + 0);
                    b.this.fgC = true;
                    float abs = Math.abs(intValue / bfx);
                    b.this.fgi.setAlpha(abs);
                    View beD = b.this.fgh.bek().beD();
                    if (beD != null) {
                        beD.setAlpha(abs);
                    }
                    View findViewById = b.this.fgh.bem().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.fgn != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fgn.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bfv();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.fgn.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.fgi.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.fgC = false;
                    b.this.pJ(0 - (bfx * 2));
                    b.this.fgC = true;
                    b.this.fgi.setVisibility(8);
                    b.this.fgA.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.fgA.getParent() == null) {
                        frameLayout.addView(b.this.fgA, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.aBm.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.aBm, layoutParams3);
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
            this.fgn.requestFocus();
            this.fgn.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(float f) {
        ViewGroup viewGroup;
        int bfw = bfw();
        float abs = Math.abs(bfw / (bfz() - bfw));
        int i = (int) f;
        if (this.fgn != null) {
            ViewGroup.LayoutParams layoutParams = this.fgn.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bfv();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.fgn.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.fgn.getParent() != this.fgn.getRootView() && (viewGroup = (ViewGroup) this.fgn.getRootView()) != null) {
                        ((ViewGroup) this.fgn.getParent()).removeView(this.fgn);
                        if (this.fgn.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.fgn, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.fgA);
                        viewGroup.bringChildToFront(this.aBm);
                    }
                } else if (this.fgn.getParent() == this.fgn.getRootView()) {
                    if (this.fgn.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.fgn.getRootView();
                        ((ViewGroup) this.fgn.getParent()).removeView(this.fgn);
                    }
                    if (this.fgn.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.fgh.bem().addView(this.fgn, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.fgi.setVisibility(0);
        this.fgC = false;
        pJ(((int) ((i * abs) - (bfw * abs))) * 2);
        this.fgC = true;
        float abs2 = Math.abs(i / bfw);
        this.fgi.setAlpha(abs2);
        View beD = this.fgh.bek().beD();
        if (beD != null) {
            beD.setAlpha(abs2);
        }
        View findViewById = this.fgh.bem().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfF() {
        if (this.aBm != null) {
            this.aBm.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bfx(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.al(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.al(0.0f);
                b.this.mPullView.resume();
                b.this.fgi.completePullRefresh();
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
    public void bfG() {
        this.fgA.setEnabled(false);
        int bfw = bfw();
        Math.abs(bfw / (bfz() - bfw));
        this.aBm.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.fgn.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bfx(), bfw);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.al(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.fgA.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.fgA);
                        viewGroup.removeView(b.this.aBm);
                    }
                    b.this.aBm.setVisibility(0);
                    b.this.fgC = false;
                    b.this.bfu();
                    b.this.fgx = 0;
                    b.this.pJ(0);
                    b.this.fgC = true;
                    b.this.mPullView.resume();
                    b.this.fgi.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fgC = false;
                        }
                    }, 0L);
                    b.this.fgi.setVisibility(0);
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
        if (this.fgC) {
            bfG();
        }
    }
}
