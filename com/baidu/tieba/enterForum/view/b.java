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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.d;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.enterForum.view.e;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.GuidePopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b implements EnterForumAdView.a {
    private static boolean iCR = false;
    private View bJa;
    private ImageView fqN;
    private View gOg;
    private int iAA;
    private final EnterForumFragment iCJ;
    private BdListView iCK;
    private com.baidu.tieba.enterForum.a.a iCL;
    private List<com.baidu.tieba.enterForum.data.f> iCM;
    private bl iCN;
    private CommonTipView iCO;
    private EnterForumAdView iCP;
    private GuidePopupWindow iCQ;
    private int iCS;
    private e iCT;
    private int iCV;
    private f.c iCW;
    private View iDd;
    private float iDe;
    private boolean iDg;
    private com.baidu.adp.lib.guide.c ipK;
    private ViewEventCenter itu;
    private com.baidu.tieba.enterForum.data.c itz;
    private int iwk;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean iCU = true;
    private f.c gzL = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.iDf) {
                com.baidu.tieba.t.c.dOe().C(b.this.iCJ.getUniqueId());
                if (b.this.iCW != null) {
                    b.this.iCW.onListPullRefresh(z);
                }
                if (z && !b.this.iub && b.this.itz != null && b.this.itz.iub) {
                    if (b.this.itz.iud > 0) {
                        b.this.iCK.smoothScrollToPosition(0, 0, 0);
                        b.this.cxm();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iCK.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int gtF = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.iCT.onScrollStateChanged(absListView, i);
            if (this.gtF != i) {
                this.gtF = i;
                if (this.gtF == 1) {
                    if (b.this.itz == null || !b.this.itz.iub) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cxr();
                    return;
                }
                b.this.cxe();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.iCJ.isPrimary() && this.gtF != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.iCK.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof v)) {
                        v vVar = (v) itemAtPosition;
                        if (vVar.getItemViewType() == 1 && b.this.iCK.getItemAtPosition(i4) == y.getItem(b.this.iCM, 0)) {
                            b.this.a(vVar, b.this.iCK.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.iCT.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener iCX = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.itz != null && b.this.itz.iub && b.this.iub) {
                EnterForumAdView unused = b.this.iCP;
                EnterForumAdView.a(b.this.iCJ.getUniqueId(), b.this.iCJ.getContext());
            }
        }
    };
    private int iCY = 0;
    private int iCZ = 0;
    private CustomMessageListener iDa = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cxg();
        }
    };
    boolean iub = false;
    boolean iDb = false;
    private Runnable iDc = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cxo();
        }
    };
    private boolean iDf = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cxe() {
        if (cxf()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.itz != null && this.itz.iub) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cxf() {
        return this.iCK == null || this.iCK.getChildCount() == 0 || this.iCK.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.iCJ = enterForumFragment;
        this.iwk = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.iAA = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.iCV = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.itu = viewEventCenter;
        cH(view);
        this.iCL = new com.baidu.tieba.enterForum.a.a(this.iCJ.getPageContext(), this.itu, recentlyVisitedForumModel, enterForumModel, this);
        this.iCK.setAdapter((ListAdapter) this.iCL);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.iCQ = new GuidePopupWindow(this.iCJ.getFragmentActivity());
    }

    private void registerListener() {
        this.iCJ.registerListener(this.iDa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxg() {
        if (cxh() && this.iDg) {
            this.iCQ.dXX();
            this.iCQ.dXW();
            this.iCQ.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.iCQ, this.iCJ.getFragmentActivity());
        }
    }

    private boolean cxh() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cH(View view) {
        this.mContext = view.getContext();
        this.iCT = new e();
        this.iCT.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.iDf) {
                    b.this.iCY = -i;
                    if (b.this.iub) {
                        b.this.cxo();
                    } else if (b.this.itz != null && b.this.itz.iub) {
                        b.this.cxi();
                    }
                }
            }
        });
        this.iCK = (BdListView) view.findViewById(R.id.listview);
        zb(0);
        this.iCK.setBackgroundColor(0);
        this.iCK.setVerticalScrollBarEnabled(false);
        this.iCK.setOnScrollListener(this.mOnScrollListener);
        this.iCK.setFastScrollEnabled(false);
        this.iCK.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        BdListView bdListView = this.iCK;
        BdListView.setPullRefreshRatio(1.0f);
        if (this.iCJ.cvK() != null) {
            this.iCJ.cvK().a(this);
        }
        this.mPullView = new g(this.iCJ.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.iCZ = i3;
                if (!b.this.iub && b.this.itz != null && b.this.itz.iub && !b.this.iDf) {
                    b.this.cxi();
                    if (i3 > b.this.iCV) {
                        b.this.iCZ = 0;
                        b.this.cK(b.this.iCJ.cvK().getRootView());
                    }
                }
            }
        });
        this.mPullView.jE(true);
        this.mPullView.setListPullRefreshListener(this.gzL);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.iCJ.getUniqueId());
        }
        this.iCK.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.iCJ.getPageContext().getPageActivity());
        this.gOg = new View(this.iCJ.getPageContext().getPageActivity());
        frameLayout.addView(this.gOg, new FrameLayout.LayoutParams(-1, this.iAA));
        this.iCK.getAdapter2().addHeaderView(frameLayout, 0);
        this.bJa = new View(this.iCJ.getActivity());
        this.bJa.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.iCJ.getActivity(), R.dimen.ds50)));
        this.bJa.setBackgroundResource(R.color.CAM_X0201);
        this.mPullView.setOnClickListener(this.iCX);
        this.mPullView.getView().setOnClickListener(this.iCX);
        this.gOg.setOnClickListener(this.iCX);
        cxs();
    }

    public void cI(View view) {
        this.iCP = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.iCP != null) {
            cxi();
            this.iCP.setTag(this.iCJ.getUniqueId());
            this.iCP.setAdData();
            this.iCP.setEventCenter(this.itu);
            this.iCP.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxi() {
        if (!this.iDf && this.iCP != null) {
            ViewGroup.LayoutParams layoutParams = this.iCP.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cxj = cxj();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iub ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iCY + this.iCZ) - cxj, 0, 0);
                this.iCP.setLayoutParams(layoutParams2);
                this.iCP.setAdViewHeight(layoutParams2.height - cxj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxj() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cxk() {
        return this.iub ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iCY + this.iCZ) - cxj();
    }

    private int cxl() {
        ViewGroup.LayoutParams layoutParams = this.iCP.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cxm() {
        if (!this.iDf) {
            this.iub = true;
            cxi();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.iCP != null) {
                if (!this.iCP.cxb()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.iCP.cxa()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            zb(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iDc);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.iDc, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb(int i) {
        if (!this.iDf) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iCK.getLayoutParams();
            marginLayoutParams.topMargin = ((this.iwk + i) - this.iAA) - (EnterForumDelegateStatic.ive.cwk() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.iCK.setLayoutParams(marginLayoutParams);
        }
    }

    private int cxn() {
        return (this.iwk - this.iAA) - (EnterForumDelegateStatic.ive.cwk() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxo() {
        this.iub = false;
        cxi();
        zb(0);
        if (this.iDb) {
            this.iCK.completePullRefreshPostDelayed(0L);
        }
        this.iDb = false;
    }

    public void cJ(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.iCJ.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.iCJ.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.iCK.setVisibility(8);
        if (this.iCJ.cvK() != null) {
            this.iCJ.cvK().cvY();
            this.iCJ.cvK().cvZ();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.iCK.setVisibility(0);
        if (this.iCJ.cvK() != null) {
            this.iCJ.cvK().cvY();
            this.iCJ.cvK().cvZ();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.iCM);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.iCM.remove(fVar);
        a(this.iCM, this.iCN, z);
        pA(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cxp() {
        return this.iCK;
    }

    public void startPullRefresh() {
        this.iCK.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iub) {
            this.iDb = true;
            return;
        }
        this.iDb = false;
        this.iCK.completePullRefreshPostDelayed(0L);
    }

    public void pA(boolean z) {
        this.iCL.notifyDataSetChanged();
        if (this.bJa != null && this.bJa.getLayoutParams() != null) {
            if (z) {
                this.bJa.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bJa.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bl blVar, boolean z) {
        this.iCP.setAdData();
        EnterForumDelegateStatic.ive.fQ(this.mContext);
        this.iCM = list;
        this.iCN = blVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        v vVar = new v();
        vVar.on(4);
        arrayList.add(vVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(blVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                v vVar2 = new v();
                vVar2.on(11);
                arrayList.add(vVar2);
            } else {
                v vVar3 = new v();
                vVar3.on(3);
                arrayList.add(vVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bm(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(blVar.bnV());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            v vVar4 = new v();
            vVar4.on(5);
            arrayList.add(vVar4);
        }
        hideNoDataView();
        this.iCL.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.iCK.removeFooterView(this.bJa);
            this.iCK.addFooterView(this.bJa);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.iCK.removeFooterView(this.bJa);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.iCQ != null) {
            this.iCQ.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bJa, R.color.CAM_X0201);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.iCW = cVar;
    }

    public void cxq() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.iCJ != null && this.iCJ.getActivity() != null && this.iCJ.cvJ() != null) {
            if (this.iCO == null) {
                this.iCO = new CommonTipView(this.iCJ.getActivity());
            }
            this.iCO.setText(R.string.enter_forum_login_tip);
            this.iCO.c(this.iCJ.cvJ(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.iCJ.isAdded() && this.iCJ.isPrimary()) {
            iCR = false;
            if (this.iCL != null) {
                this.iCL.onPrimary();
                if (this.iCK != null) {
                    Object itemAtPosition = this.iCK.getItemAtPosition(this.iCK.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof v) && ((v) itemAtPosition).getItemViewType() == 5) {
                        this.iCL.cuE();
                    }
                }
            }
            if (this.iDf) {
                this.iCP.requestFocus();
                this.iCP.requestFocusFromTouch();
                return;
            }
            return;
        }
        cxr();
    }

    public void onPause() {
        cxr();
    }

    public void onDestroy() {
        if (this.iCO != null) {
            this.iCO.onDestroy();
        }
        if (this.iCL != null) {
            this.iCL.onDestroy();
        }
    }

    public void yG(int i) {
        this.iCL.yG(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iCL != null) {
            this.iCL.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cuD() {
        if (this.iCL == null) {
            return false;
        }
        return this.iCL.cuD();
    }

    public void a(v vVar, View view) {
        if (TbadkCoreApplication.isLogin() && !iCR && this.iCJ.getActivity() != null && this.iCJ.getPageContext() != null && (vVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
            if (fVar.isPrivateForum() != 0 && fVar.cuV() != 0 && !com.baidu.tbadk.core.sharedPref.b.bsO().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.iCS = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bsO().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.iCS = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                iCR = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ad(true).ae(false).ac(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.iCS);
                        b.this.iCJ.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.ipK = dVar.mi();
                this.ipK.setShouldCheckLocInWindow(false);
                this.ipK.setUseDirectOffset(true);
                this.ipK.show(this.iCJ.getActivity());
                if (this.iCS == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.iCS == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.ipK != null) {
                            b.this.ipK.dismiss();
                            b.this.ipK = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cxr() {
        if (this.ipK != null) {
            this.ipK.dismiss();
            this.ipK = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.itz = cVar;
        if (this.iCL != null) {
            this.iCL.setAdState(cVar);
        }
        if (cVar != null && cVar.iub) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.qV(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.qV(R.raw.lottie_common_pull_refresh);
    }

    public void pB(boolean z) {
        if (this.iCU != z) {
            this.iCU = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iCK.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.iCK.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.iCK.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.iCK.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.iCP != null) {
            this.iCP.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.iCP != null) {
            this.iCP.setRecentlyIsShow(z);
        }
    }

    private void cxs() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.iDd = new View(this.mContext);
        this.iDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.iCJ.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.iDd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float iDj = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iDe = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.iDe <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iDe) {
                            b.this.cxt();
                            if (this.iDj < 50.0f) {
                                b.this.iDd.performClick();
                            }
                        } else {
                            b.this.cxu();
                        }
                        b.this.iDe = 0.0f;
                        this.iDj = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.iDe) {
                            b.this.aE(motionEvent.getRawY() - b.this.iDe);
                            if (b.this.fqN != null) {
                                b.this.fqN.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.iDe) > this.iDj) {
                            this.iDj = Math.abs(motionEvent.getRawY() - b.this.iDe);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.iDe <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iDe) {
                            b.this.cxt();
                        } else {
                            b.this.cxu();
                        }
                        b.this.iDe = 0.0f;
                        this.iDj = 0.0f;
                        return true;
                }
            }
        });
        this.fqN = new ImageView(this.mContext);
        this.fqN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cxu();
            }
        });
    }

    public void cK(final View view) {
        if ((view instanceof FrameLayout) && !this.iDf) {
            this.mPullView.pause();
            this.iDf = true;
            this.iCP.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.fqN, R.drawable.icon_jinba_retract_n);
            final int cxl = cxl();
            ValueAnimator ofInt = ValueAnimator.ofInt(cxl, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.iCP != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iCP.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cxj();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.iCP.setLayoutParams(marginLayoutParams);
                            if (intValue / cxl < 0.2d) {
                                if (b.this.iCP.getParent() != b.this.iCP.getRootView() && (viewGroup = (ViewGroup) b.this.iCP.getRootView()) != null) {
                                    ((ViewGroup) b.this.iCP.getParent()).removeView(b.this.iCP);
                                    if (b.this.iCP.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.iCP, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.iDd);
                                    viewGroup.bringChildToFront(b.this.fqN);
                                }
                            } else if (b.this.iCP.getParent() == b.this.iCP.getRootView()) {
                                if (b.this.iCP.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.iCP.getRootView();
                                    ((ViewGroup) b.this.iCP.getParent()).removeView(b.this.iCP);
                                }
                                if (b.this.iCP.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.iCJ.cvN().addView(b.this.iCP, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.iDf = false;
                    b.this.zb(((intValue - cxl) * 2) + 0);
                    b.this.iDf = true;
                    float abs = Math.abs(intValue / cxl);
                    b.this.iCK.setAlpha(abs);
                    View cwb = b.this.iCJ.cvK().cwb();
                    if (cwb != null) {
                        cwb.setAlpha(abs);
                    }
                    View findViewById = b.this.iCJ.cvN().getRootView().findViewById(R.id.tabcontainer_wrapper);
                    if (findViewById != null) {
                        findViewById.setAlpha(abs);
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.iCP != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iCP.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cxj();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.iCP.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.iCK.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.iDf = false;
                    b.this.zb(0 - (cxl * 2));
                    b.this.iDf = true;
                    b.this.iCK.setVisibility(8);
                    b.this.iDd.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.iDd.getParent() == null) {
                        frameLayout.addView(b.this.iDd, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.fqN.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.fqN, layoutParams3);
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
            this.iCP.requestFocus();
            this.iCP.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(float f) {
        ViewGroup viewGroup;
        int cxk = cxk();
        float abs = Math.abs(cxk / (cxn() - cxk));
        int i = (int) f;
        if (this.iCP != null) {
            ViewGroup.LayoutParams layoutParams = this.iCP.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cxj();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.iCP.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.iCP.getParent() != this.iCP.getRootView() && (viewGroup = (ViewGroup) this.iCP.getRootView()) != null) {
                        ((ViewGroup) this.iCP.getParent()).removeView(this.iCP);
                        if (this.iCP.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.iCP, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.iDd);
                        viewGroup.bringChildToFront(this.fqN);
                    }
                } else if (this.iCP.getParent() == this.iCP.getRootView()) {
                    if (this.iCP.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.iCP.getRootView();
                        ((ViewGroup) this.iCP.getParent()).removeView(this.iCP);
                    }
                    if (this.iCP.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.iCJ.cvN().addView(this.iCP, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.iCK.setVisibility(0);
        this.iDf = false;
        zb(((int) ((i * abs) - (cxk * abs))) * 2);
        this.iDf = true;
        float abs2 = Math.abs(i / cxk);
        this.iCK.setAlpha(abs2);
        View cwb = this.iCJ.cvK().cwb();
        if (cwb != null) {
            cwb.setAlpha(abs2);
        }
        View findViewById = this.iCJ.cvN().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxt() {
        if (this.fqN != null) {
            this.fqN.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cxl(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aE(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.aE(0.0f);
                b.this.mPullView.resume();
                b.this.iCK.completePullRefresh();
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
    public void cxu() {
        this.iDd.setEnabled(false);
        int cxk = cxk();
        Math.abs(cxk / (cxn() - cxk));
        this.fqN.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.iCP.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cxl(), cxk);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aE(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass13());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$13  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass13 implements Animator.AnimatorListener {
        AnonymousClass13() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.iDd.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.iDd);
                        viewGroup.removeView(b.this.fqN);
                    }
                    b.this.fqN.setVisibility(0);
                    b.this.iDf = false;
                    b.this.cxi();
                    b.this.iCZ = 0;
                    b.this.zb(0);
                    b.this.iDf = true;
                    b.this.mPullView.resume();
                    b.this.iCK.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iDf = false;
                        }
                    }, 0L);
                    b.this.iCK.setVisibility(0);
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
        if (this.iDf) {
            cxu();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cvm())) {
                this.iDg = false;
            } else {
                this.iDg = true;
            }
            this.iCQ.setForumId(aVar.cvk());
            this.iCQ.H(aVar.cvj(), aVar.cvl());
            this.iCQ.gk(aVar.cvi());
            this.iCQ.AX(aVar.cvm());
        }
    }
}
