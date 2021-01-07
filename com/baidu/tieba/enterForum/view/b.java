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
import com.baidu.adp.widget.ListView.c;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes2.dex */
public class b implements EnterForumAdView.a {
    private static boolean iPf = false;
    private View bNO;
    private ImageView fAu;
    private View gZV;
    private com.baidu.adp.lib.guide.c iCg;
    private ViewEventCenter iFJ;
    private com.baidu.tieba.enterForum.data.c iFO;
    private int iIz;
    private int iMO;
    private final EnterForumFragment iOX;
    private BdListView iOY;
    private com.baidu.tieba.enterForum.adapter.a iOZ;
    private List<com.baidu.tieba.enterForum.data.f> iPa;
    private bm iPb;
    private CommonTipView iPc;
    private EnterForumAdView iPd;
    private GuidePopupWindow iPe;
    private int iPg;
    private e iPh;
    private int iPj;
    private f.c iPk;
    private View iPr;
    private float iPs;
    private boolean iPu;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean iPi = true;
    private f.c gKQ = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.iPt) {
                com.baidu.tieba.s.c.dNY().C(b.this.iOX.getUniqueId());
                if (b.this.iPk != null) {
                    b.this.iPk.onListPullRefresh(z);
                }
                if (z && !b.this.iGq && b.this.iFO != null && b.this.iFO.iGq) {
                    if (b.this.iFO.iGs > 0) {
                        b.this.iOY.smoothScrollToPosition(0, 0, 0);
                        b.this.cAh();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iOY.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int gEG = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.iPh.onScrollStateChanged(absListView, i);
            if (this.gEG != i) {
                this.gEG = i;
                if (this.gEG == 1) {
                    if (b.this.iFO == null || !b.this.iFO.iGq) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cAm();
                    return;
                }
                b.this.czZ();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.iOX.isPrimary() && this.gEG != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.iOY.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof v)) {
                        v vVar = (v) itemAtPosition;
                        if (vVar.getItemViewType() == 1 && b.this.iOY.getItemAtPosition(i4) == x.getItem(b.this.iPa, 0)) {
                            b.this.a(vVar, b.this.iOY.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.iPh.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener iPl = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iFO != null && b.this.iFO.iGq && b.this.iGq) {
                EnterForumAdView unused = b.this.iPd;
                EnterForumAdView.a(b.this.iOX.getUniqueId(), b.this.iOX.getContext());
            }
        }
    };
    private int iPm = 0;
    private int iPn = 0;
    private CustomMessageListener iPo = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cAb();
        }
    };
    boolean iGq = false;
    boolean iPp = false;
    private Runnable iPq = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cAj();
        }
    };
    private boolean iPt = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void czZ() {
        if (cAa()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.iFO != null && this.iFO.iGq) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cAa() {
        return this.iOY == null || this.iOY.getChildCount() == 0 || this.iOY.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.iOX = enterForumFragment;
        this.iIz = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.iMO = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.iPj = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.iFJ = viewEventCenter;
        cR(view);
        this.iOZ = new com.baidu.tieba.enterForum.adapter.a(this.iOX.getPageContext(), this.iFJ, recentlyVisitedForumModel, enterForumModel, this);
        this.iOY.setAdapter((ListAdapter) this.iOZ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.iPe = new GuidePopupWindow(this.iOX.getFragmentActivity());
    }

    private void registerListener() {
        this.iOX.registerListener(this.iPo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAb() {
        if (cAc() && this.iPu) {
            this.iPe.dXC();
            this.iPe.dXB();
            this.iPe.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.iPe, this.iOX.getFragmentActivity());
        }
    }

    private boolean cAc() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cR(View view) {
        this.mContext = view.getContext();
        this.iPh = new e();
        this.iPh.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.iPt) {
                    b.this.iPm = -i;
                    if (b.this.iGq) {
                        b.this.cAj();
                    } else if (b.this.iFO != null && b.this.iFO.iGq) {
                        b.this.cAd();
                    }
                }
            }
        });
        this.iOY = (BdListView) view.findViewById(R.id.listview);
        zo(0);
        this.iOY.setBackgroundColor(0);
        this.iOY.setVerticalScrollBarEnabled(false);
        this.iOY.setOnScrollListener(this.mOnScrollListener);
        this.iOY.setFastScrollEnabled(false);
        this.iOY.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        BdListView bdListView = this.iOY;
        BdListView.setPullRefreshRatio(1.0f);
        if (this.iOX.cyF() != null) {
            this.iOX.cyF().a(this);
        }
        this.mPullView = new g(this.iOX.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.iPn = i3;
                if (!b.this.iGq && b.this.iFO != null && b.this.iFO.iGq && !b.this.iPt) {
                    b.this.cAd();
                    if (i3 > b.this.iPj) {
                        b.this.iPn = 0;
                        b.this.cU(b.this.iOX.cyF().getRootView());
                    }
                }
            }
        });
        this.mPullView.ka(true);
        this.mPullView.setListPullRefreshListener(this.gKQ);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.iOX.getUniqueId());
        }
        this.iOY.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.iOX.getPageContext().getPageActivity());
        this.gZV = new View(this.iOX.getPageContext().getPageActivity());
        frameLayout.addView(this.gZV, new FrameLayout.LayoutParams(-1, this.iMO));
        this.iOY.getAdapter2().addHeaderView(frameLayout, 0);
        this.bNO = new View(this.iOX.getActivity());
        this.bNO.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.iOX.getActivity(), R.dimen.ds50)));
        this.bNO.setBackgroundResource(R.color.CAM_X0201);
        this.mPullView.setOnClickListener(this.iPl);
        this.mPullView.getView().setOnClickListener(this.iPl);
        this.gZV.setOnClickListener(this.iPl);
        cAn();
    }

    public void cS(View view) {
        this.iPd = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.iPd != null) {
            cAd();
            this.iPd.setTag(this.iOX.getUniqueId());
            this.iPd.setAdData();
            this.iPd.setEventCenter(this.iFJ);
            this.iPd.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAd() {
        if (!this.iPt && this.iPd != null) {
            ViewGroup.LayoutParams layoutParams = this.iPd.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cAe = cAe();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iGq ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iPm + this.iPn) - cAe, 0, 0);
                this.iPd.setLayoutParams(layoutParams2);
                this.iPd.setAdViewHeight(layoutParams2.height - cAe);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cAe() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cAf() {
        return this.iGq ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.iPm + this.iPn) - cAe();
    }

    private int cAg() {
        ViewGroup.LayoutParams layoutParams = this.iPd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cAh() {
        if (!this.iPt) {
            this.iGq = true;
            cAd();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.iPd != null) {
                if (!this.iPd.czW()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.iPd.czV()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            zo(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.iPq);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.iPq, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo(int i) {
        if (!this.iPt) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iOY.getLayoutParams();
            marginLayoutParams.topMargin = ((this.iIz + i) - this.iMO) - (EnterForumDelegateStatic.iHt.czf() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.iOY.setLayoutParams(marginLayoutParams);
        }
    }

    private int cAi() {
        return (this.iIz - this.iMO) - (EnterForumDelegateStatic.iHt.czf() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAj() {
        this.iGq = false;
        cAd();
        zo(0);
        if (this.iPp) {
            this.iOY.completePullRefreshPostDelayed(0L);
        }
        this.iPp = false;
    }

    public void cT(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.iOX.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.iOX.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.iOY.setVisibility(8);
        if (this.iOX.cyF() != null) {
            this.iOX.cyF().cyT();
            this.iOX.cyF().cyU();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.iOY.setVisibility(0);
        if (this.iOX.cyF() != null) {
            this.iOX.cyF().cyT();
            this.iOX.cyF().cyU();
        }
    }

    public boolean isEmpty() {
        return x.isEmpty(this.iPa);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.iPa.remove(fVar);
        a(this.iPa, this.iPb, z);
        pX(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cAk() {
        return this.iOY;
    }

    public void startPullRefresh() {
        this.iOY.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iGq) {
            this.iPp = true;
            return;
        }
        this.iPp = false;
        this.iOY.completePullRefreshPostDelayed(0L);
    }

    public void pX(boolean z) {
        this.iOZ.notifyDataSetChanged();
        if (this.bNO != null && this.bNO.getLayoutParams() != null) {
            if (z) {
                this.bNO.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bNO.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bm bmVar, boolean z) {
        this.iPd.setAdData();
        EnterForumDelegateStatic.iHt.gj(this.mContext);
        this.iPa = list;
        this.iPb = bmVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !x.isEmpty(list);
        boolean z3 = !x.isEmpty(list);
        v vVar = new v();
        vVar.ox(4);
        arrayList.add(vVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(bmVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                v vVar2 = new v();
                vVar2.ox(11);
                arrayList.add(vVar2);
            } else {
                v vVar3 = new v();
                vVar3.ox(3);
                arrayList.add(vVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bn(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bmVar.bqx());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            v vVar4 = new v();
            vVar4.ox(5);
            arrayList.add(vVar4);
        }
        hideNoDataView();
        this.iOZ.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.iOY.removeFooterView(this.bNO);
            this.iOY.addFooterView(this.bNO);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.iOY.removeFooterView(this.bNO);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.iPe != null) {
            this.iPe.onChangeSkinType();
        }
        ao.setBackgroundResource(this.bNO, R.color.CAM_X0201);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.iPk = cVar;
    }

    public void cAl() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.iOX != null && this.iOX.getActivity() != null && this.iOX.cyE() != null) {
            if (this.iPc == null) {
                this.iPc = new CommonTipView(this.iOX.getActivity());
            }
            this.iPc.setText(R.string.enter_forum_login_tip);
            this.iPc.c(this.iOX.cyE(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.iOX.isAdded() && this.iOX.isPrimary()) {
            iPf = false;
            if (this.iOZ != null) {
                this.iOZ.onPrimary();
                if (this.iOY != null) {
                    Object itemAtPosition = this.iOY.getItemAtPosition(this.iOY.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof v) && ((v) itemAtPosition).getItemViewType() == 5) {
                        this.iOZ.cxz();
                    }
                }
            }
            if (this.iPt) {
                this.iPd.requestFocus();
                this.iPd.requestFocusFromTouch();
                return;
            }
            return;
        }
        cAm();
    }

    public void onPause() {
        cAm();
    }

    public void onDestroy() {
        if (this.iPc != null) {
            this.iPc.onDestroy();
        }
        if (this.iOZ != null) {
            this.iOZ.onDestroy();
        }
    }

    public void yT(int i) {
        this.iOZ.yT(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.iOZ != null) {
            this.iOZ.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cxy() {
        if (this.iOZ == null) {
            return false;
        }
        return this.iOZ.cxy();
    }

    public void a(v vVar, View view) {
        if (TbadkCoreApplication.isLogin() && !iPf && this.iOX.getActivity() != null && this.iOX.getPageContext() != null && (vVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
            if (fVar.isPrivateForum() != 0 && fVar.cxQ() != 0 && !com.baidu.tbadk.core.sharedPref.b.bvr().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.iPg = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bvr().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.iPg = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                iPf = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).an(0).ac(true).ad(false).ab(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.iPg);
                        b.this.iOX.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.iCg = dVar.lG();
                this.iCg.setShouldCheckLocInWindow(false);
                this.iCg.setUseDirectOffset(true);
                this.iCg.show(this.iOX.getActivity());
                if (this.iPg == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bvr().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.iPg == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bvr().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.iCg != null) {
                            b.this.iCg.dismiss();
                            b.this.iCg = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cAm() {
        if (this.iCg != null) {
            this.iCg.dismiss();
            this.iCg = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iFO = cVar;
        if (this.iOZ != null) {
            this.iOZ.setAdState(cVar);
        }
        if (cVar != null && cVar.iGq) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.rh(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.rh(R.raw.lottie_common_pull_refresh);
    }

    public void pY(boolean z) {
        if (this.iPi != z) {
            this.iPi = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iOY.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.iOY.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.iOY.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.iOY.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.iPd != null) {
            this.iPd.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.iPd != null) {
            this.iPd.setRecentlyIsShow(z);
        }
    }

    private void cAn() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.iPr = new View(this.mContext);
        this.iPr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.iOX.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.iPr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float iPx = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iPs = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.iPs <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iPs) {
                            b.this.cAo();
                            if (this.iPx < 50.0f) {
                                b.this.iPr.performClick();
                            }
                        } else {
                            b.this.cAp();
                        }
                        b.this.iPs = 0.0f;
                        this.iPx = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.iPs) {
                            b.this.aG(motionEvent.getRawY() - b.this.iPs);
                            if (b.this.fAu != null) {
                                b.this.fAu.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.iPs) > this.iPx) {
                            this.iPx = Math.abs(motionEvent.getRawY() - b.this.iPs);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.iPs <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.iPs) {
                            b.this.cAo();
                        } else {
                            b.this.cAp();
                        }
                        b.this.iPs = 0.0f;
                        this.iPx = 0.0f;
                        return true;
                }
            }
        });
        this.fAu = new ImageView(this.mContext);
        this.fAu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cAp();
            }
        });
    }

    public void cU(final View view) {
        if ((view instanceof FrameLayout) && !this.iPt) {
            this.mPullView.pause();
            this.iPt = true;
            this.iPd.getAdImageView().getLocationInWindow(new int[2]);
            ao.setImageResource(this.fAu, R.drawable.icon_jinba_retract_n);
            final int cAg = cAg();
            ValueAnimator ofInt = ValueAnimator.ofInt(cAg, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.iPd != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iPd.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cAe();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.iPd.setLayoutParams(marginLayoutParams);
                            if (intValue / cAg < 0.2d) {
                                if (b.this.iPd.getParent() != b.this.iPd.getRootView() && (viewGroup = (ViewGroup) b.this.iPd.getRootView()) != null) {
                                    ((ViewGroup) b.this.iPd.getParent()).removeView(b.this.iPd);
                                    if (b.this.iPd.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.iPd, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.iPr);
                                    viewGroup.bringChildToFront(b.this.fAu);
                                }
                            } else if (b.this.iPd.getParent() == b.this.iPd.getRootView()) {
                                if (b.this.iPd.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.iPd.getRootView();
                                    ((ViewGroup) b.this.iPd.getParent()).removeView(b.this.iPd);
                                }
                                if (b.this.iPd.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.iOX.cyI().addView(b.this.iPd, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.iPt = false;
                    b.this.zo(((intValue - cAg) * 2) + 0);
                    b.this.iPt = true;
                    float abs = Math.abs(intValue / cAg);
                    b.this.iOY.setAlpha(abs);
                    View cyW = b.this.iOX.cyF().cyW();
                    if (cyW != null) {
                        cyW.setAlpha(abs);
                    }
                    View findViewById = b.this.iOX.cyI().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.iPd != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.iPd.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cAe();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.iPd.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.iOY.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.iPt = false;
                    b.this.zo(0 - (cAg * 2));
                    b.this.iPt = true;
                    b.this.iOY.setVisibility(8);
                    b.this.iPr.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.iPr.getParent() == null) {
                        frameLayout.addView(b.this.iPr, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.fAu.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.fAu, layoutParams3);
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
            this.iPd.requestFocus();
            this.iPd.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        ViewGroup viewGroup;
        int cAf = cAf();
        float abs = Math.abs(cAf / (cAi() - cAf));
        int i = (int) f;
        if (this.iPd != null) {
            ViewGroup.LayoutParams layoutParams = this.iPd.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cAe();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.iPd.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.iPd.getParent() != this.iPd.getRootView() && (viewGroup = (ViewGroup) this.iPd.getRootView()) != null) {
                        ((ViewGroup) this.iPd.getParent()).removeView(this.iPd);
                        if (this.iPd.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.iPd, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.iPr);
                        viewGroup.bringChildToFront(this.fAu);
                    }
                } else if (this.iPd.getParent() == this.iPd.getRootView()) {
                    if (this.iPd.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.iPd.getRootView();
                        ((ViewGroup) this.iPd.getParent()).removeView(this.iPd);
                    }
                    if (this.iPd.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.iOX.cyI().addView(this.iPd, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.iOY.setVisibility(0);
        this.iPt = false;
        zo(((int) ((i * abs) - (cAf * abs))) * 2);
        this.iPt = true;
        float abs2 = Math.abs(i / cAf);
        this.iOY.setAlpha(abs2);
        View cyW = this.iOX.cyF().cyW();
        if (cyW != null) {
            cyW.setAlpha(abs2);
        }
        View findViewById = this.iOX.cyI().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAo() {
        if (this.fAu != null) {
            this.fAu.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cAg(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aG(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.aG(0.0f);
                b.this.mPullView.resume();
                b.this.iOY.completePullRefresh();
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
    public void cAp() {
        this.iPr.setEnabled(false);
        int cAf = cAf();
        Math.abs(cAf / (cAi() - cAf));
        this.fAu.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.iPd.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cAg(), cAf);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aG(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass13());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$13  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass13 implements Animator.AnimatorListener {
        AnonymousClass13() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.iPr.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.iPr);
                        viewGroup.removeView(b.this.fAu);
                    }
                    b.this.fAu.setVisibility(0);
                    b.this.iPt = false;
                    b.this.cAd();
                    b.this.iPn = 0;
                    b.this.zo(0);
                    b.this.iPt = true;
                    b.this.mPullView.resume();
                    b.this.iOY.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.iPt = false;
                        }
                    }, 0L);
                    b.this.iOY.setVisibility(0);
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
        if (this.iPt) {
            cAp();
        }
    }

    public void b(com.baidu.tieba.enterForum.a.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cyh())) {
                this.iPu = false;
            } else {
                this.iPu = true;
            }
            this.iPe.setForumId(aVar.cyf());
            this.iPe.K(aVar.cye(), aVar.cyg());
            this.iPe.ge(aVar.cyd());
            this.iPe.AV(aVar.cyh());
        }
    }
}
