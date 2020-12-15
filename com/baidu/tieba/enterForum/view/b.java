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
    private static boolean iCT = false;
    private View bJa;
    private ImageView fqN;
    private View gOi;
    private int iAC;
    private final EnterForumFragment iCL;
    private BdListView iCM;
    private com.baidu.tieba.enterForum.a.a iCN;
    private List<com.baidu.tieba.enterForum.data.f> iCO;
    private bl iCP;
    private CommonTipView iCQ;
    private EnterForumAdView iCR;
    private GuidePopupWindow iCS;
    private int iCU;
    private e iCV;
    private int iCX;
    private f.c iCY;
    private View iDf;
    private float iDg;
    private boolean iDi;
    private com.baidu.adp.lib.guide.c ipM;
    private com.baidu.tieba.enterForum.data.c itB;
    private ViewEventCenter itw;
    private int iwm;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean iCW = true;
    private f.c gzN = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.iDh) {
                com.baidu.tieba.t.c.dOf().C(b.this.iCL.getUniqueId());
                if (b.this.iCY != null) {
                    b.this.iCY.onListPullRefresh(z);
                }
                if (z && !b.this.iud && b.this.itB != null && b.this.itB.iud) {
                    if (b.this.itB.iuf > 0) {
                        b.this.iCM.smoothScrollToPosition(0, 0, 0);
                        b.this.cxn();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iCM.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int gtH = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.iCV.onScrollStateChanged(absListView, i);
            if (this.gtH != i) {
                this.gtH = i;
                if (this.gtH == 1) {
                    if (b.this.itB == null || !b.this.itB.iud) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cxs();
                    return;
                }
                b.this.cxf();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.iCL.isPrimary() && this.gtH != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.iCM.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof v)) {
                        v vVar = (v) itemAtPosition;
                        if (vVar.getItemViewType() == 1 && b.this.iCM.getItemAtPosition(i4) == y.getItem(b.this.iCO, 0)) {
                            b.this.a(vVar, b.this.iCM.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.iCV.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener iCZ = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.itB != null && b.this.itB.iud && b.this.iud) {
                EnterForumAdView unused = b.this.iCR;
                EnterForumAdView.a(b.this.iCL.getUniqueId(), b.this.iCL.getContext());
            }
        }
    };
    private int iDa = 0;
    private int iDb = 0;
    private CustomMessageListener iDc = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cxh();
        }
    };
    boolean iud = false;
    boolean iDd = false;
    private Runnable iDe = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cxp();
        }
    };
    private boolean iDh = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cxf() {
        if (cxg()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.itB != null && this.itB.iud) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cxg() {
        return this.iCM == null || this.iCM.getChildCount() == 0 || this.iCM.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.iCL = enterForumFragment;
        this.iwm = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.iAC = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.iCX = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.itw = viewEventCenter;
        cH(view);
        this.iCN = new com.baidu.tieba.enterForum.a.a(this.iCL.getPageContext(), this.itw, recentlyVisitedForumModel, enterForumModel, this);
        this.iCM.setAdapter((ListAdapter) this.iCN);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.iCS = new GuidePopupWindow(this.iCL.getFragmentActivity());
    }

    private void registerListener() {
        this.iCL.registerListener(this.iDc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxh() {
        if (cxi() && this.iDi) {
            this.iCS.dXY();
            this.iCS.dXX();
            this.iCS.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.iCS, this.iCL.getFragmentActivity());
        }
    }

    private boolean cxi() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cH(View view) {
        this.mContext = view.getContext();
        this.iCV = new e();
        this.iCV.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.iDh) {
                    b.this.iDa = -i;
                    if (b.this.iud) {
                        b.this.cxp();
                    } else if (b.this.itB != null && b.this.itB.iud) {
                        b.this.cxj();
                    }
                }
            }
        });
        this.iCM = (BdListView) view.findViewById(R.id.listview);
        zb(0);
        this.iCM.setBackgroundColor(0);
        this.iCM.setVerticalScrollBarEnabled(false);
        this.iCM.setOnScrollListener(this.mOnScrollListener);
        this.iCM.setFastScrollEnabled(false);
        this.iCM.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        BdListView bdListView = this.iCM;
        BdListView.setPullRefreshRatio(1.0f);
        if (this.iCL.cvL() != null) {
            this.iCL.cvL().a(this);
        }
        this.mPullView = new g(this.iCL.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.iDb = i3;
                if (!b.this.iud && b.this.itB != null && b.this.itB.iud && !b.this.iDh) {
                    b.this.cxj();
                    if (i3 > b.this.iCX) {
                        b.this.iDb = 0;
                        b.this.cK(b.this.iCL.cvL().getRootView());
                    }
                }
            }
        });
        this.mPullView.jE(true);
        this.mPullView.setListPullRefreshListener(this.gzN);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.iCL.getUniqueId());
        }
        this.iCM.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.iCL.getPageContext().getPageActivity());
        this.gOi = new View(this.iCL.getPageContext().getPageActivity());
        frameLayout.addView(this.gOi, new FrameLayout.LayoutParams(-1, this.iAC));
        this.iCM.getAdapter2().addHeaderView(frameLayout, 0);
        this.bJa = new View(this.iCL.getActivity());
        this.bJa.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.iCL.getActivity(), R.dimen.ds50)));
        this.bJa.setBackgroundResource(R.color.CAM_X0201);
        this.mPullView.setOnClickListener(this.iCZ);
        this.mPullView.getView().setOnClickListener(this.iCZ);
        this.gOi.setOnClickListener(this.iCZ);
        cxt();
    }

    public void cI(View view) {
        this.iCR = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.iCR != null) {
            cxj();
            this.iCR.setTag(this.iCL.getUniqueId());
            this.iCR.setAdData();
            this.iCR.setEventCenter(this.itw);
            this.iCR.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxj() {
        if (!this.iDh && this.iCR != null) {
            ViewGroup.LayoutParams layoutParams = this.iCR.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cxk = cxk();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iud ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iDa + this.iDb) - cxk, 0, 0);
                this.iCR.setLayoutParams(layoutParams2);
                this.iCR.setAdViewHeight(layoutParams2.height - cxk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cxk() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cxl() {
        return this.iud ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iDa + this.iDb) - cxk();
    }

    private int cxm() {
        ViewGroup.LayoutParams layoutParams = this.iCR.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cxn() {
        if (!this.iDh) {
            this.iud = true;
            cxj();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.iCR != null) {
                if (!this.iCR.cxc()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.iCR.cxb()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            zb(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iDe);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.iDe, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb(int i) {
        if (!this.iDh) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iCM.getLayoutParams();
            marginLayoutParams.topMargin = ((this.iwm + i) - this.iAC) - (EnterForumDelegateStatic.ivg.cwl() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.iCM.setLayoutParams(marginLayoutParams);
        }
    }

    private int cxo() {
        return (this.iwm - this.iAC) - (EnterForumDelegateStatic.ivg.cwl() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxp() {
        this.iud = false;
        cxj();
        zb(0);
        if (this.iDd) {
            this.iCM.completePullRefreshPostDelayed(0L);
        }
        this.iDd = false;
    }

    public void cJ(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.iCL.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.iCL.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.iCM.setVisibility(8);
        if (this.iCL.cvL() != null) {
            this.iCL.cvL().cvZ();
            this.iCL.cvL().cwa();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.iCM.setVisibility(0);
        if (this.iCL.cvL() != null) {
            this.iCL.cvL().cvZ();
            this.iCL.cvL().cwa();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.iCO);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.iCO.remove(fVar);
        a(this.iCO, this.iCP, z);
        pA(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cxq() {
        return this.iCM;
    }

    public void startPullRefresh() {
        this.iCM.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iud) {
            this.iDd = true;
            return;
        }
        this.iDd = false;
        this.iCM.completePullRefreshPostDelayed(0L);
    }

    public void pA(boolean z) {
        this.iCN.notifyDataSetChanged();
        if (this.bJa != null && this.bJa.getLayoutParams() != null) {
            if (z) {
                this.bJa.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bJa.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bl blVar, boolean z) {
        this.iCR.setAdData();
        EnterForumDelegateStatic.ivg.fQ(this.mContext);
        this.iCO = list;
        this.iCP = blVar;
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
        this.iCN.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.iCM.removeFooterView(this.bJa);
            this.iCM.addFooterView(this.bJa);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.iCM.removeFooterView(this.bJa);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.iCS != null) {
            this.iCS.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bJa, R.color.CAM_X0201);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.iCY = cVar;
    }

    public void cxr() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.iCL != null && this.iCL.getActivity() != null && this.iCL.cvK() != null) {
            if (this.iCQ == null) {
                this.iCQ = new CommonTipView(this.iCL.getActivity());
            }
            this.iCQ.setText(R.string.enter_forum_login_tip);
            this.iCQ.c(this.iCL.cvK(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.iCL.isAdded() && this.iCL.isPrimary()) {
            iCT = false;
            if (this.iCN != null) {
                this.iCN.onPrimary();
                if (this.iCM != null) {
                    Object itemAtPosition = this.iCM.getItemAtPosition(this.iCM.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof v) && ((v) itemAtPosition).getItemViewType() == 5) {
                        this.iCN.cuF();
                    }
                }
            }
            if (this.iDh) {
                this.iCR.requestFocus();
                this.iCR.requestFocusFromTouch();
                return;
            }
            return;
        }
        cxs();
    }

    public void onPause() {
        cxs();
    }

    public void onDestroy() {
        if (this.iCQ != null) {
            this.iCQ.onDestroy();
        }
        if (this.iCN != null) {
            this.iCN.onDestroy();
        }
    }

    public void yG(int i) {
        this.iCN.yG(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iCN != null) {
            this.iCN.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cuE() {
        if (this.iCN == null) {
            return false;
        }
        return this.iCN.cuE();
    }

    public void a(v vVar, View view) {
        if (TbadkCoreApplication.isLogin() && !iCT && this.iCL.getActivity() != null && this.iCL.getPageContext() != null && (vVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
            if (fVar.isPrivateForum() != 0 && fVar.cuW() != 0 && !com.baidu.tbadk.core.sharedPref.b.bsO().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.iCU = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bsO().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.iCU = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                iCT = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ad(true).ae(false).ac(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.iCU);
                        b.this.iCL.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.ipM = dVar.mi();
                this.ipM.setShouldCheckLocInWindow(false);
                this.ipM.setUseDirectOffset(true);
                this.ipM.show(this.iCL.getActivity());
                if (this.iCU == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.iCU == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.ipM != null) {
                            b.this.ipM.dismiss();
                            b.this.ipM = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cxs() {
        if (this.ipM != null) {
            this.ipM.dismiss();
            this.ipM = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.itB = cVar;
        if (this.iCN != null) {
            this.iCN.setAdState(cVar);
        }
        if (cVar != null && cVar.iud) {
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
        if (this.iCW != z) {
            this.iCW = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iCM.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.iCM.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.iCM.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.iCM.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.iCR != null) {
            this.iCR.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.iCR != null) {
            this.iCR.setRecentlyIsShow(z);
        }
    }

    private void cxt() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.iDf = new View(this.mContext);
        this.iDf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.iCL.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.iDf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float iDl = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iDg = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.iDg <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iDg) {
                            b.this.cxu();
                            if (this.iDl < 50.0f) {
                                b.this.iDf.performClick();
                            }
                        } else {
                            b.this.cxv();
                        }
                        b.this.iDg = 0.0f;
                        this.iDl = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.iDg) {
                            b.this.aE(motionEvent.getRawY() - b.this.iDg);
                            if (b.this.fqN != null) {
                                b.this.fqN.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.iDg) > this.iDl) {
                            this.iDl = Math.abs(motionEvent.getRawY() - b.this.iDg);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.iDg <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iDg) {
                            b.this.cxu();
                        } else {
                            b.this.cxv();
                        }
                        b.this.iDg = 0.0f;
                        this.iDl = 0.0f;
                        return true;
                }
            }
        });
        this.fqN = new ImageView(this.mContext);
        this.fqN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cxv();
            }
        });
    }

    public void cK(final View view) {
        if ((view instanceof FrameLayout) && !this.iDh) {
            this.mPullView.pause();
            this.iDh = true;
            this.iCR.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.fqN, R.drawable.icon_jinba_retract_n);
            final int cxm = cxm();
            ValueAnimator ofInt = ValueAnimator.ofInt(cxm, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.iCR != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iCR.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cxk();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.iCR.setLayoutParams(marginLayoutParams);
                            if (intValue / cxm < 0.2d) {
                                if (b.this.iCR.getParent() != b.this.iCR.getRootView() && (viewGroup = (ViewGroup) b.this.iCR.getRootView()) != null) {
                                    ((ViewGroup) b.this.iCR.getParent()).removeView(b.this.iCR);
                                    if (b.this.iCR.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.iCR, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.iDf);
                                    viewGroup.bringChildToFront(b.this.fqN);
                                }
                            } else if (b.this.iCR.getParent() == b.this.iCR.getRootView()) {
                                if (b.this.iCR.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.iCR.getRootView();
                                    ((ViewGroup) b.this.iCR.getParent()).removeView(b.this.iCR);
                                }
                                if (b.this.iCR.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.iCL.cvO().addView(b.this.iCR, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.iDh = false;
                    b.this.zb(((intValue - cxm) * 2) + 0);
                    b.this.iDh = true;
                    float abs = Math.abs(intValue / cxm);
                    b.this.iCM.setAlpha(abs);
                    View cwc = b.this.iCL.cvL().cwc();
                    if (cwc != null) {
                        cwc.setAlpha(abs);
                    }
                    View findViewById = b.this.iCL.cvO().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.iCR != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iCR.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cxk();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.iCR.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.iCM.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.iDh = false;
                    b.this.zb(0 - (cxm * 2));
                    b.this.iDh = true;
                    b.this.iCM.setVisibility(8);
                    b.this.iDf.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.iDf.getParent() == null) {
                        frameLayout.addView(b.this.iDf, new FrameLayout.LayoutParams(-1, -1));
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
            this.iCR.requestFocus();
            this.iCR.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(float f) {
        ViewGroup viewGroup;
        int cxl = cxl();
        float abs = Math.abs(cxl / (cxo() - cxl));
        int i = (int) f;
        if (this.iCR != null) {
            ViewGroup.LayoutParams layoutParams = this.iCR.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cxk();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.iCR.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.iCR.getParent() != this.iCR.getRootView() && (viewGroup = (ViewGroup) this.iCR.getRootView()) != null) {
                        ((ViewGroup) this.iCR.getParent()).removeView(this.iCR);
                        if (this.iCR.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.iCR, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.iDf);
                        viewGroup.bringChildToFront(this.fqN);
                    }
                } else if (this.iCR.getParent() == this.iCR.getRootView()) {
                    if (this.iCR.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.iCR.getRootView();
                        ((ViewGroup) this.iCR.getParent()).removeView(this.iCR);
                    }
                    if (this.iCR.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.iCL.cvO().addView(this.iCR, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.iCM.setVisibility(0);
        this.iDh = false;
        zb(((int) ((i * abs) - (cxl * abs))) * 2);
        this.iDh = true;
        float abs2 = Math.abs(i / cxl);
        this.iCM.setAlpha(abs2);
        View cwc = this.iCL.cvL().cwc();
        if (cwc != null) {
            cwc.setAlpha(abs2);
        }
        View findViewById = this.iCL.cvO().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxu() {
        if (this.fqN != null) {
            this.fqN.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cxm(), 0);
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
                b.this.iCM.completePullRefresh();
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
    public void cxv() {
        this.iDf.setEnabled(false);
        int cxl = cxl();
        Math.abs(cxl / (cxo() - cxl));
        this.fqN.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.iCR.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cxm(), cxl);
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
                    ViewGroup viewGroup = (ViewGroup) b.this.iDf.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.iDf);
                        viewGroup.removeView(b.this.fqN);
                    }
                    b.this.fqN.setVisibility(0);
                    b.this.iDh = false;
                    b.this.cxj();
                    b.this.iDb = 0;
                    b.this.zb(0);
                    b.this.iDh = true;
                    b.this.mPullView.resume();
                    b.this.iCM.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iDh = false;
                        }
                    }, 0L);
                    b.this.iCM.setVisibility(0);
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
        if (this.iDh) {
            cxv();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cvn())) {
                this.iDi = false;
            } else {
                this.iDi = true;
            }
            this.iCS.setForumId(aVar.cvl());
            this.iCS.H(aVar.cvk(), aVar.cvm());
            this.iCS.gk(aVar.cvj());
            this.iCS.AX(aVar.cvn());
        }
    }
}
