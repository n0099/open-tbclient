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
    private static boolean ffx = false;
    private ImageView aAU;
    private View aqJ;
    private View dKB;
    private com.baidu.adp.lib.guide.c eVs;
    private ViewEventCenter eYW;
    private com.baidu.tieba.enterForum.data.b eZb;
    private int fbK;
    private int feU;
    private int ffB;
    private h.c ffC;
    private View ffJ;
    private float ffK;
    private final EnterForumFragment ffq;
    private BdListView ffr;
    private com.baidu.tieba.enterForum.a.a ffs;
    private com.baidu.tieba.enterForum.multiConcern.a fft;
    private List<com.baidu.tieba.enterForum.data.f> ffu;
    private CommonTipView ffv;
    private EnterForumAdView ffw;
    private int ffy;
    private e ffz;
    private Context mContext;
    private int mNavHeight;
    private i mPullView;
    private View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private boolean isFirst = true;
    private boolean ffA = true;
    private h.c dDg = new h.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.ffL) {
                com.baidu.tieba.q.c.cni().y(b.this.ffq.getUniqueId());
                if (b.this.ffC != null) {
                    b.this.ffC.onListPullRefresh(z);
                }
                if (z && !b.this.eZG && b.this.eZb != null && b.this.eZb.eZG) {
                    if (b.this.eZb.eZI > 0) {
                        b.this.ffr.smoothScrollToPosition(0, 0, 0);
                        b.this.bfw();
                        return;
                    }
                    com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ffr.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a ffD = new com.baidu.tbadk.task.a(2921425, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.ffL) {
                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bfE();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921425, Boolean.valueOf(b.this.ffL));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int dxA = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.ffz.onScrollStateChanged(absListView, i);
            if (this.dxA != i) {
                this.dxA = i;
                if (this.dxA == 1) {
                    if ((b.this.eZb == null || !b.this.eZb.eZG) && b.this.ffq != null && b.this.ffq.bei() != null) {
                        b.this.ffq.bei().aJy();
                    }
                    b.this.bfB();
                    return;
                }
                b.this.bfq();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.ffq.isPrimary() && this.dxA != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.ffr.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.ffr.getItemAtPosition(i4) == v.getItem(b.this.ffu, 0)) {
                            b.this.a(dVar, b.this.ffr.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.ffz.onScroll(absListView, i, i2, i3);
        }
    };
    c.a feX = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void beC() {
            b.this.bfq();
        }
    };
    View.OnClickListener ffE = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.eZb != null && b.this.eZb.eZG && b.this.eZG) {
                EnterForumAdView unused = b.this.ffw;
                EnterForumAdView.a(b.this.ffq.getUniqueId(), b.this.ffq.getContext());
            }
        }
    };
    private int ffF = 0;
    private int ffG = 0;
    boolean eZG = false;
    boolean ffH = false;
    private Runnable ffI = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bfy();
        }
    };
    private boolean ffL = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bfq() {
        if (bfr()) {
            if (this.ffq != null && this.ffq.bei() != null) {
                this.ffq.bei().aJz();
            }
        } else if (this.eZb != null && this.eZb.eZG) {
            if (this.ffq != null && this.ffq.bei() != null) {
                this.ffq.bei().aJz();
            }
        } else if (this.ffq != null && this.ffq.bei() != null) {
            this.ffq.bei().aJy();
        }
    }

    private boolean bfr() {
        return this.ffr == null || this.ffr.getChildCount() == 0 || this.ffr.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.ffq = enterForumFragment;
        this.fbK = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds264);
        this.feU = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.ffB = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.eYW = viewEventCenter;
        this.fft = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bJ(view);
        this.ffs = new com.baidu.tieba.enterForum.a.a(this.ffq.getPageContext(), this.eYW, recentlyVisitedForumModel, enterForumModel, this);
        this.ffr.setAdapter((ListAdapter) this.ffs);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.mContext = view.getContext();
        this.ffz = new e();
        this.ffz.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.ffL) {
                    if (b.this.ffq.bei().bew() == 1) {
                        b.this.ffq.bei().e(absListView, 0, i2, 0, 0);
                    }
                    b.this.ffF = -i;
                    if (b.this.eZG) {
                        b.this.bfy();
                    } else if (b.this.eZb != null && b.this.eZb.eZG) {
                        b.this.bfs();
                    }
                }
            }
        });
        this.ffr = (BdListView) view.findViewById(R.id.listview);
        pI(0);
        this.ffr.setBackgroundColor(0);
        this.ffr.setVerticalScrollBarEnabled(false);
        this.ffr.setOnScrollListener(this.mOnScrollListener);
        this.ffr.setFastScrollEnabled(false);
        this.ffr.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.ffq.bei() != null) {
            this.ffq.bei().b(this.feX);
            this.ffq.bei().a(this.feX);
            this.ffq.bei().a(this);
        }
        this.mPullView = new i(this.ffq.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.ffG = i3;
                if (!b.this.eZG && b.this.eZb != null && b.this.eZb.eZG && !b.this.ffL) {
                    b.this.bfs();
                    if (i3 > b.this.ffB) {
                        b.this.ffG = 0;
                        b.this.bM(b.this.ffq.bei().getRootView());
                    }
                }
            }
        });
        this.mPullView.eu(true);
        this.mPullView.setListPullRefreshListener(this.dDg);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.ffq.getUniqueId());
        }
        this.ffr.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.ffq.getPageContext().getPageActivity());
        this.dKB = new View(this.ffq.getPageContext().getPageActivity());
        frameLayout.addView(this.dKB, new FrameLayout.LayoutParams(-1, this.feU));
        this.ffr.getAdapter2().addHeaderView(frameLayout, 0);
        this.aqJ = new View(this.ffq.getActivity());
        this.aqJ.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.ffq.getActivity(), R.dimen.ds50)));
        this.aqJ.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.ffE);
        this.mPullView.getView().setOnClickListener(this.ffE);
        this.dKB.setOnClickListener(this.ffE);
        bfC();
    }

    public void bK(View view) {
        this.ffw = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.ffw != null) {
            bfs();
            this.ffw.setTag(this.ffq.getUniqueId());
            this.ffw.setAdData();
            this.ffw.setEventCenter(this.eYW);
            this.ffw.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfs() {
        if (!this.ffL && this.ffw != null) {
            ViewGroup.LayoutParams layoutParams = this.ffw.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bft = bft();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.eZG ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.ffF + this.ffG) - bft, 0, 0);
                this.ffw.setLayoutParams(layoutParams2);
                this.ffw.setAdViewHeight(layoutParams2.height - bft);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bft() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bfu() {
        return this.eZG ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.ffF + this.ffG) - bft();
    }

    private int bfv() {
        ViewGroup.LayoutParams layoutParams = this.ffw.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bfw() {
        if (!this.ffL) {
            this.eZG = true;
            bfs();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.ffw != null) {
                if (!this.ffw.bfn()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.ffw.bfm()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            pI(dimensionPixelOffset);
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ffI);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.ffI, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI(int i) {
        if (!this.ffL) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ffr.getLayoutParams();
            marginLayoutParams.topMargin = ((this.fbK + i) - this.feU) - (EnterForumDelegateStatic.faz.beI() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.ffr.setLayoutParams(marginLayoutParams);
        }
    }

    private int bfx() {
        return (this.fbK - this.feU) - (EnterForumDelegateStatic.faz.beI() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfy() {
        this.eZG = false;
        bfs();
        pI(0);
        if (this.ffH) {
            this.ffr.completePullRefreshPostDelayed(0L);
        }
        this.ffH = false;
    }

    public void bL(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(this.ffq.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.setSubText(this.ffq.getString(R.string.neterror));
        this.mRootView = view;
        int dimensionPixelSize = this.ffq.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize += UtilHelper.getStatusBarHeight();
        }
        this.refreshView.kb(dimensionPixelSize);
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.ffr.setVisibility(8);
        if (this.ffq.bei() != null) {
            this.ffq.bei().bex();
            this.ffq.bei().bey();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.ffr.setVisibility(0);
        if (this.ffq.bei() != null) {
            this.ffq.bei().bex();
            this.ffq.bei().bey();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.ffu);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.ffu.remove(fVar);
        j(this.ffu, z);
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.m.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bfz() {
        return this.ffr;
    }

    public void startPullRefresh() {
        this.ffr.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.eZG) {
            this.ffH = true;
            return;
        }
        this.ffH = false;
        this.ffr.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.ffs.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.ffw.setAdData();
        EnterForumDelegateStatic.faz.dr(this.mContext);
        this.ffu = list;
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
        this.ffs.setData(arrayList);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.ffr.removeFooterView(this.aqJ);
            this.ffr.addFooterView(this.aqJ);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.ffr.removeFooterView(this.aqJ);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fft.beU() != null) {
            this.fft.onChangeSkinType();
        }
        am.setBackgroundResource(this.aqJ, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.ffC = cVar;
    }

    public void bfA() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.ffq != null && this.ffq.getActivity() != null && this.ffq.beh() != null) {
            if (this.ffv == null) {
                this.ffv = new CommonTipView(this.ffq.getActivity());
            }
            this.ffv.setText(R.string.enter_forum_login_tip);
            this.ffv.c(this.ffq.beh(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.ffq.isAdded() && this.ffq.isPrimary()) {
            this.ffD.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.ffD.getCmd());
            MessageManager.getInstance().registerTask(this.ffD);
            this.ffw.setAdData();
            ffx = false;
            if (this.ffs != null) {
                this.ffs.onPrimary();
                if (this.ffr != null) {
                    Object itemAtPosition = this.ffr.getItemAtPosition(this.ffr.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.ffs.bdA();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.ffL) {
                this.ffw.requestFocus();
                this.ffw.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.ffD.getCmd());
        bfB();
    }

    public void onPause() {
        bfB();
    }

    public void onDestroy() {
        if (this.ffv != null) {
            this.ffv.onDestroy();
        }
        if (this.fft != null) {
            this.fft.onDestroy();
        }
        if (this.ffs != null) {
            this.ffs.onDestroy();
        }
        if (this.ffq != null && this.ffq.bei() != null) {
            this.ffq.bei().b(this.feX);
        }
    }

    public void ps(int i) {
        this.ffs.ps(i);
    }

    public void bX(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.fft.isShowing() && !v.isEmpty(list)) {
            this.fft.bT(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ffs != null) {
            this.ffs.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bdz() {
        if (this.ffs == null) {
            return false;
        }
        return this.ffs.bdz();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !ffx && this.ffq.getActivity() != null && this.ffq.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bdP() != 0 && !com.baidu.tbadk.core.sharedPref.b.alP().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.ffy = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.alP().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.ffy = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                ffx = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).I(0).B(true).C(false).A(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.ffy);
                        b.this.ffq.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.eVs = dVar2.fu();
                this.eVs.setShouldCheckLocInWindow(false);
                this.eVs.setUseDirectOffset(true);
                this.eVs.show(this.ffq.getActivity());
                if (this.ffy == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.ffy == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.eVs != null) {
                            b.this.eVs.dismiss();
                            b.this.eVs = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bfB() {
        if (this.eVs != null) {
            this.eVs.dismiss();
            this.eVs = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eZb = bVar;
        if (this.ffs != null) {
            this.ffs.setAdState(bVar);
        }
        if (bVar != null && bVar.eZG) {
            this.mPullView.iO(R.raw.ad_refresh_load);
        } else {
            this.mPullView.iO(R.raw.refresh_load);
        }
    }

    public void jn(boolean z) {
        if (this.ffA != z) {
            this.ffA = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ffr.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.ffr.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.ffr.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.ffr.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.ffw != null) {
            this.ffw.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.ffw != null) {
            this.ffw.setRecentlyIsShow(z);
        }
    }

    private void bfC() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.ffJ = new View(this.mContext);
        this.ffJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.ffq.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.ffJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float ffO = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.ffK = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.ffK <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.ffK) {
                            b.this.bfD();
                            if (this.ffO < 50.0f) {
                                b.this.ffJ.performClick();
                            }
                        } else {
                            b.this.bfE();
                        }
                        b.this.ffK = 0.0f;
                        this.ffO = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.ffK) {
                            b.this.al(motionEvent.getRawY() - b.this.ffK);
                            if (b.this.aAU != null) {
                                b.this.aAU.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.ffK) > this.ffO) {
                            this.ffO = Math.abs(motionEvent.getRawY() - b.this.ffK);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.ffK <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.ffK) {
                            b.this.bfD();
                        } else {
                            b.this.bfE();
                        }
                        b.this.ffK = 0.0f;
                        this.ffO = 0.0f;
                        return true;
                }
            }
        });
        this.aAU = new ImageView(this.mContext);
        this.aAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bfE();
            }
        });
    }

    public void bM(final View view) {
        if ((view instanceof FrameLayout) && !this.ffL) {
            this.mPullView.pause();
            this.ffL = true;
            this.ffw.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.aAU, R.drawable.icon_jinba_retract_n);
            final int bfv = bfv();
            ValueAnimator ofInt = ValueAnimator.ofInt(bfv, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.ffw != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.ffw.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bft();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.ffw.setLayoutParams(marginLayoutParams);
                            if (intValue / bfv < 0.2d) {
                                if (b.this.ffw.getParent() != b.this.ffw.getRootView() && (viewGroup = (ViewGroup) b.this.ffw.getRootView()) != null) {
                                    ((ViewGroup) b.this.ffw.getParent()).removeView(b.this.ffw);
                                    if (b.this.ffw.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.ffw, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.ffJ);
                                    viewGroup.bringChildToFront(b.this.aAU);
                                }
                            } else if (b.this.ffw.getParent() == b.this.ffw.getRootView()) {
                                if (b.this.ffw.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.ffw.getRootView();
                                    ((ViewGroup) b.this.ffw.getParent()).removeView(b.this.ffw);
                                }
                                if (b.this.ffw.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.ffq.bek().addView(b.this.ffw, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.ffL = false;
                    b.this.pI(((intValue - bfv) * 2) + 0);
                    b.this.ffL = true;
                    float abs = Math.abs(intValue / bfv);
                    b.this.ffr.setAlpha(abs);
                    View beB = b.this.ffq.bei().beB();
                    if (beB != null) {
                        beB.setAlpha(abs);
                    }
                    View findViewById = b.this.ffq.bek().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.ffw != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.ffw.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bft();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.ffw.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.ffr.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.ffL = false;
                    b.this.pI(0 - (bfv * 2));
                    b.this.ffL = true;
                    b.this.ffr.setVisibility(8);
                    b.this.ffJ.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.ffJ.getParent() == null) {
                        frameLayout.addView(b.this.ffJ, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.aAU.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.aAU, layoutParams3);
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
            this.ffw.requestFocus();
            this.ffw.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(float f) {
        ViewGroup viewGroup;
        int bfu = bfu();
        float abs = Math.abs(bfu / (bfx() - bfu));
        int i = (int) f;
        if (this.ffw != null) {
            ViewGroup.LayoutParams layoutParams = this.ffw.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bft();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.ffw.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.ffw.getParent() != this.ffw.getRootView() && (viewGroup = (ViewGroup) this.ffw.getRootView()) != null) {
                        ((ViewGroup) this.ffw.getParent()).removeView(this.ffw);
                        if (this.ffw.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.ffw, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.ffJ);
                        viewGroup.bringChildToFront(this.aAU);
                    }
                } else if (this.ffw.getParent() == this.ffw.getRootView()) {
                    if (this.ffw.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.ffw.getRootView();
                        ((ViewGroup) this.ffw.getParent()).removeView(this.ffw);
                    }
                    if (this.ffw.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.ffq.bek().addView(this.ffw, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.ffr.setVisibility(0);
        this.ffL = false;
        pI(((int) ((i * abs) - (bfu * abs))) * 2);
        this.ffL = true;
        float abs2 = Math.abs(i / bfu);
        this.ffr.setAlpha(abs2);
        View beB = this.ffq.bei().beB();
        if (beB != null) {
            beB.setAlpha(abs2);
        }
        View findViewById = this.ffq.bek().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfD() {
        if (this.aAU != null) {
            this.aAU.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bfv(), 0);
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
                b.this.ffr.completePullRefresh();
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
    public void bfE() {
        this.ffJ.setEnabled(false);
        int bfu = bfu();
        Math.abs(bfu / (bfx() - bfu));
        this.aAU.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.ffw.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bfv(), bfu);
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
                    ViewGroup viewGroup = (ViewGroup) b.this.ffJ.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.ffJ);
                        viewGroup.removeView(b.this.aAU);
                    }
                    b.this.aAU.setVisibility(0);
                    b.this.ffL = false;
                    b.this.bfs();
                    b.this.ffG = 0;
                    b.this.pI(0);
                    b.this.ffL = true;
                    b.this.mPullView.resume();
                    b.this.ffr.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ffL = false;
                        }
                    }, 0L);
                    b.this.ffr.setVisibility(0);
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
        if (this.ffL) {
            bfE();
        }
    }
}
