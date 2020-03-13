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
    private static boolean fZz = false;
    private View aDy;
    private ImageView dtB;
    private View eEG;
    private com.baidu.adp.lib.guide.c fPS;
    private com.baidu.tieba.enterForum.data.b fTC;
    private ViewEventCenter fTx;
    private int fWf;
    private int fYW;
    private int fZA;
    private e fZB;
    private int fZD;
    private g.c fZE;
    private View fZL;
    private float fZM;
    private final EnterForumFragment fZt;
    private BdListView fZu;
    private com.baidu.tieba.enterForum.a.a fZv;
    private List<com.baidu.tieba.enterForum.data.f> fZw;
    private CommonTipView fZx;
    private EnterForumAdView fZy;
    private Context mContext;
    private int mNavHeight;
    private h mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean isFirst = true;
    private boolean fZC = true;
    private g.c etR = new g.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.fZN) {
                com.baidu.tieba.s.c.cKb().z(b.this.fZt.getUniqueId());
                if (b.this.fZE != null) {
                    b.this.fZE.onListPullRefresh(z);
                }
                if (z && !b.this.fUg && b.this.fTC != null && b.this.fTC.fUg) {
                    if (b.this.fTC.fUi > 0) {
                        b.this.fZu.smoothScrollToPosition(0, 0, 0);
                        b.this.bzy();
                        return;
                    }
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fZu.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a fZF = new com.baidu.tbadk.task.a(2921422, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.fZN) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bzG();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921422, Boolean.valueOf(b.this.fZN));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int enO = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fZB.onScrollStateChanged(absListView, i);
            if (this.enO != i) {
                this.enO = i;
                if (this.enO == 1) {
                    if ((b.this.fTC == null || !b.this.fTC.fUg) && b.this.fZt != null && b.this.fZt.byo() != null) {
                        b.this.fZt.byo().bcN();
                    }
                    b.this.bzD();
                    return;
                }
                b.this.bzs();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fZt.isPrimary() && this.enO != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.fZu.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.fZu.getItemAtPosition(i4) == v.getItem(b.this.fZw, 0)) {
                            b.this.a(dVar, b.this.fZu.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fZB.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fZa = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void byG() {
            b.this.bzs();
        }
    };
    View.OnClickListener fZG = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fTC != null && b.this.fTC.fUg && b.this.fUg) {
                EnterForumAdView unused = b.this.fZy;
                EnterForumAdView.a(b.this.fZt.getUniqueId(), b.this.fZt.getContext());
            }
        }
    };
    private int fZH = 0;
    private int fZI = 0;
    boolean fUg = false;
    boolean fZJ = false;
    private Runnable fZK = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bzA();
        }
    };
    private boolean fZN = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bzs() {
        if (bzt()) {
            if (this.fZt != null && this.fZt.byo() != null) {
                this.fZt.byo().bcO();
            }
        } else if (this.fTC != null && this.fTC.fUg) {
            if (this.fZt != null && this.fZt.byo() != null) {
                this.fZt.byo().bcO();
            }
        } else if (this.fZt != null && this.fZt.byo() != null) {
            this.fZt.byo().bcN();
        }
    }

    private boolean bzt() {
        return this.fZu == null || this.fZu.getChildCount() == 0 || this.fZu.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fZt = enterForumFragment;
        this.fWf = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.fYW = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.fZD = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.fTx = viewEventCenter;
        bJ(view);
        this.fZv = new com.baidu.tieba.enterForum.a.a(this.fZt.getPageContext(), this.fTx, recentlyVisitedForumModel, enterForumModel, this);
        this.fZu.setAdapter((ListAdapter) this.fZv);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.mContext = view.getContext();
        this.fZB = new e();
        this.fZB.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.fZN) {
                    if (b.this.fZt.byo().byB() == 1) {
                        b.this.fZt.byo().e(absListView, 0, i2, 0, 0);
                    }
                    b.this.fZH = -i;
                    if (b.this.fUg) {
                        b.this.bzA();
                    } else if (b.this.fTC != null && b.this.fTC.fUg) {
                        b.this.bzu();
                    }
                }
            }
        });
        this.fZu = (BdListView) view.findViewById(R.id.listview);
        rZ(0);
        this.fZu.setBackgroundColor(0);
        this.fZu.setVerticalScrollBarEnabled(false);
        this.fZu.setOnScrollListener(this.mOnScrollListener);
        this.fZu.setFastScrollEnabled(false);
        this.fZu.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fZt.byo() != null) {
            this.fZt.byo().b(this.fZa);
            this.fZt.byo().a(this.fZa);
            this.fZt.byo().a(this);
        }
        this.mPullView = new h(this.fZt.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.fZI = i3;
                if (!b.this.fUg && b.this.fTC != null && b.this.fTC.fUg && !b.this.fZN) {
                    b.this.bzu();
                    if (i3 > b.this.fZD) {
                        b.this.fZI = 0;
                        b.this.bM(b.this.fZt.byo().getRootView());
                    }
                }
            }
        });
        this.mPullView.fS(true);
        this.mPullView.setListPullRefreshListener(this.etR);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fZt.getUniqueId());
        }
        this.fZu.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.fZt.getPageContext().getPageActivity());
        this.eEG = new View(this.fZt.getPageContext().getPageActivity());
        frameLayout.addView(this.eEG, new FrameLayout.LayoutParams(-1, this.fYW));
        this.fZu.getAdapter2().addHeaderView(frameLayout, 0);
        this.aDy = new View(this.fZt.getActivity());
        this.aDy.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.fZt.getActivity(), R.dimen.ds50)));
        this.aDy.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.fZG);
        this.mPullView.getView().setOnClickListener(this.fZG);
        this.eEG.setOnClickListener(this.fZG);
        bzE();
    }

    public void bK(View view) {
        this.fZy = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fZy != null) {
            bzu();
            this.fZy.setTag(this.fZt.getUniqueId());
            this.fZy.setAdData();
            this.fZy.setEventCenter(this.fTx);
            this.fZy.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzu() {
        if (!this.fZN && this.fZy != null) {
            ViewGroup.LayoutParams layoutParams = this.fZy.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bzv = bzv();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.fUg ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fZH + this.fZI) - bzv, 0, 0);
                this.fZy.setLayoutParams(layoutParams2);
                this.fZy.setAdViewHeight(layoutParams2.height - bzv);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzv() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bzw() {
        return this.fUg ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.fZH + this.fZI) - bzv();
    }

    private int bzx() {
        ViewGroup.LayoutParams layoutParams = this.fZy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bzy() {
        if (!this.fZN) {
            this.fUg = true;
            bzu();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.fZy != null) {
                if (!this.fZy.bzp()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.fZy.bzo()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            rZ(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.fZK);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.fZK, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ(int i) {
        if (!this.fZN) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fZu.getLayoutParams();
            marginLayoutParams.topMargin = ((this.fWf + i) - this.fYW) - (EnterForumDelegateStatic.fUX.byM() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.fZu.setLayoutParams(marginLayoutParams);
        }
    }

    private int bzz() {
        return (this.fWf - this.fYW) - (EnterForumDelegateStatic.fUX.byM() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzA() {
        this.fUg = false;
        bzu();
        rZ(0);
        if (this.fZJ) {
            this.fZu.completePullRefreshPostDelayed(0L);
        }
        this.fZJ = false;
    }

    public void bL(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.fZt.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.fZt.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.fZu.setVisibility(8);
        if (this.fZt.byo() != null) {
            this.fZt.byo().byC();
            this.fZt.byo().byD();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.fZu.setVisibility(0);
        if (this.fZt.byo() != null) {
            this.fZt.byo().byC();
            this.fZt.byo().byD();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.fZw);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fZw.remove(fVar);
        n(this.fZw, z);
        kO(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bzB() {
        return this.fZu;
    }

    public void startPullRefresh() {
        this.fZu.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.fUg) {
            this.fZJ = true;
            return;
        }
        this.fZJ = false;
        this.fZu.completePullRefreshPostDelayed(0L);
    }

    public void kO(boolean z) {
        this.fZv.notifyDataSetChanged();
        if (this.aDy != null && this.aDy.getLayoutParams() != null) {
            if (z) {
                this.aDy.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.aDy.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void n(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fZy.setAdData();
        EnterForumDelegateStatic.fUX.eN(this.mContext);
        this.fZw = list;
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
        this.fZv.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.fZu.removeFooterView(this.aDy);
            this.fZu.addFooterView(this.aDy);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.fZu.removeFooterView(this.aDy);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.aDy, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.fZE = cVar;
    }

    public void bzC() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.fZt != null && this.fZt.getActivity() != null && this.fZt.byn() != null) {
            if (this.fZx == null) {
                this.fZx = new CommonTipView(this.fZt.getActivity());
            }
            this.fZx.setText(R.string.enter_forum_login_tip);
            this.fZx.c(this.fZt.byn(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.fZt.isAdded() && this.fZt.isPrimary()) {
            this.fZF.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.fZF.getCmd());
            MessageManager.getInstance().registerTask(this.fZF);
            this.fZy.setAdData();
            fZz = false;
            if (this.fZv != null) {
                this.fZv.onPrimary();
                if (this.fZu != null) {
                    Object itemAtPosition = this.fZu.getItemAtPosition(this.fZu.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fZv.bxF();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.fZN) {
                this.fZy.requestFocus();
                this.fZy.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.fZF.getCmd());
        bzD();
    }

    public void onPause() {
        bzD();
    }

    public void onDestroy() {
        if (this.fZx != null) {
            this.fZx.onDestroy();
        }
        if (this.fZv != null) {
            this.fZv.onDestroy();
        }
        if (this.fZt != null && this.fZt.byo() != null) {
            this.fZt.byo().b(this.fZa);
        }
    }

    public void rK(int i) {
        this.fZv.rK(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fZv != null) {
            this.fZv.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bxE() {
        if (this.fZv == null) {
            return false;
        }
        return this.fZv.bxE();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fZz && this.fZt.getActivity() != null && this.fZt.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bxT() != 0 && !com.baidu.tbadk.core.sharedPref.b.aFD().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fZA = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aFD().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fZA = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fZz = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).M(0).F(true).G(false).E(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fZA);
                        b.this.fZt.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.fPS = dVar2.fI();
                this.fPS.setShouldCheckLocInWindow(false);
                this.fPS.setUseDirectOffset(true);
                this.fPS.show(this.fZt.getActivity());
                if (this.fZA == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fZA == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.fPS != null) {
                            b.this.fPS.dismiss();
                            b.this.fPS = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bzD() {
        if (this.fPS != null) {
            this.fPS.dismiss();
            this.fPS = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fTC = bVar;
        if (this.fZv != null) {
            this.fZv.setAdState(bVar);
        }
        if (bVar != null && bVar.fUg) {
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
        if (this.fZC != z) {
            this.fZC = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fZu.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.fZu.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.fZu.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.fZu.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fZy != null) {
            this.fZy.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fZy != null) {
            this.fZy.setRecentlyIsShow(z);
        }
    }

    private void bzE() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.fZL = new View(this.mContext);
        this.fZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.fZt.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.fZL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float fZQ = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fZM = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.fZM <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fZM) {
                            b.this.bzF();
                            if (this.fZQ < 50.0f) {
                                b.this.fZL.performClick();
                            }
                        } else {
                            b.this.bzG();
                        }
                        b.this.fZM = 0.0f;
                        this.fZQ = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.fZM) {
                            b.this.ax(motionEvent.getRawY() - b.this.fZM);
                            if (b.this.dtB != null) {
                                b.this.dtB.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.fZM) > this.fZQ) {
                            this.fZQ = Math.abs(motionEvent.getRawY() - b.this.fZM);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.fZM <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.fZM) {
                            b.this.bzF();
                        } else {
                            b.this.bzG();
                        }
                        b.this.fZM = 0.0f;
                        this.fZQ = 0.0f;
                        return true;
                }
            }
        });
        this.dtB = new ImageView(this.mContext);
        this.dtB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bzG();
            }
        });
    }

    public void bM(final View view) {
        if ((view instanceof FrameLayout) && !this.fZN) {
            this.mPullView.pause();
            this.fZN = true;
            this.fZy.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.dtB, R.drawable.icon_jinba_retract_n);
            final int bzx = bzx();
            ValueAnimator ofInt = ValueAnimator.ofInt(bzx, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.fZy != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fZy.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bzv();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.fZy.setLayoutParams(marginLayoutParams);
                            if (intValue / bzx < 0.2d) {
                                if (b.this.fZy.getParent() != b.this.fZy.getRootView() && (viewGroup = (ViewGroup) b.this.fZy.getRootView()) != null) {
                                    ((ViewGroup) b.this.fZy.getParent()).removeView(b.this.fZy);
                                    if (b.this.fZy.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.fZy, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.fZL);
                                    viewGroup.bringChildToFront(b.this.dtB);
                                }
                            } else if (b.this.fZy.getParent() == b.this.fZy.getRootView()) {
                                if (b.this.fZy.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.fZy.getRootView();
                                    ((ViewGroup) b.this.fZy.getParent()).removeView(b.this.fZy);
                                }
                                if (b.this.fZy.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.fZt.byq().addView(b.this.fZy, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.fZN = false;
                    b.this.rZ(((intValue - bzx) * 2) + 0);
                    b.this.fZN = true;
                    float abs = Math.abs(intValue / bzx);
                    b.this.fZu.setAlpha(abs);
                    View byF = b.this.fZt.byo().byF();
                    if (byF != null) {
                        byF.setAlpha(abs);
                    }
                    View findViewById = b.this.fZt.byq().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.fZy != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.fZy.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bzv();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.fZy.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.fZu.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.fZN = false;
                    b.this.rZ(0 - (bzx * 2));
                    b.this.fZN = true;
                    b.this.fZu.setVisibility(8);
                    b.this.fZL.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.fZL.getParent() == null) {
                        frameLayout.addView(b.this.fZL, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.dtB.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.dtB, layoutParams3);
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
            this.fZy.requestFocus();
            this.fZy.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(float f) {
        ViewGroup viewGroup;
        int bzw = bzw();
        float abs = Math.abs(bzw / (bzz() - bzw));
        int i = (int) f;
        if (this.fZy != null) {
            ViewGroup.LayoutParams layoutParams = this.fZy.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bzv();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.fZy.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.fZy.getParent() != this.fZy.getRootView() && (viewGroup = (ViewGroup) this.fZy.getRootView()) != null) {
                        ((ViewGroup) this.fZy.getParent()).removeView(this.fZy);
                        if (this.fZy.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.fZy, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.fZL);
                        viewGroup.bringChildToFront(this.dtB);
                    }
                } else if (this.fZy.getParent() == this.fZy.getRootView()) {
                    if (this.fZy.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.fZy.getRootView();
                        ((ViewGroup) this.fZy.getParent()).removeView(this.fZy);
                    }
                    if (this.fZy.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.fZt.byq().addView(this.fZy, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.fZu.setVisibility(0);
        this.fZN = false;
        rZ(((int) ((i * abs) - (bzw * abs))) * 2);
        this.fZN = true;
        float abs2 = Math.abs(i / bzw);
        this.fZu.setAlpha(abs2);
        View byF = this.fZt.byo().byF();
        if (byF != null) {
            byF.setAlpha(abs2);
        }
        View findViewById = this.fZt.byq().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzF() {
        if (this.dtB != null) {
            this.dtB.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bzx(), 0);
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
                b.this.fZu.completePullRefresh();
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
    public void bzG() {
        this.fZL.setEnabled(false);
        int bzw = bzw();
        Math.abs(bzw / (bzz() - bzw));
        this.dtB.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.fZy.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bzx(), bzw);
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
                    ViewGroup viewGroup = (ViewGroup) b.this.fZL.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.fZL);
                        viewGroup.removeView(b.this.dtB);
                    }
                    b.this.dtB.setVisibility(0);
                    b.this.fZN = false;
                    b.this.bzu();
                    b.this.fZI = 0;
                    b.this.rZ(0);
                    b.this.fZN = true;
                    b.this.mPullView.resume();
                    b.this.fZu.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.fZN = false;
                        }
                    }, 0L);
                    b.this.fZu.setVisibility(0);
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
        if (this.fZN) {
            bzG();
        }
    }
}
