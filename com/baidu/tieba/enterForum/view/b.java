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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.h;
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
    private static boolean hYM = false;
    private View bxe;
    private ImageView eVS;
    private View gpF;
    private com.baidu.adp.lib.guide.c hLD;
    private ViewEventCenter hPp;
    private com.baidu.tieba.enterForum.data.c hPu;
    private int hSe;
    private int hWv;
    private final EnterForumFragment hYE;
    private BdListView hYF;
    private com.baidu.tieba.enterForum.a.a hYG;
    private List<com.baidu.tieba.enterForum.data.f> hYH;
    private bj hYI;
    private CommonTipView hYJ;
    private EnterForumAdView hYK;
    private GuidePopupWindow hYL;
    private int hYN;
    private e hYO;
    private int hYQ;
    private f.c hYR;
    private View hYY;
    private float hYZ;
    private boolean hZb;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean hYP = true;
    private f.c gce = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.hZa) {
                com.baidu.tieba.s.c.dDn().C(b.this.hYE.getUniqueId());
                if (b.this.hYR != null) {
                    b.this.hYR.onListPullRefresh(z);
                }
                if (z && !b.this.hPW && b.this.hPu != null && b.this.hPu.hPW) {
                    if (b.this.hPu.hPY > 0) {
                        b.this.hYF.smoothScrollToPosition(0, 0, 0);
                        b.this.cnM();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hYF.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int fVW = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.hYO.onScrollStateChanged(absListView, i);
            if (this.fVW != i) {
                this.fVW = i;
                if (this.fVW == 1) {
                    if (b.this.hPu == null || !b.this.hPu.hPW) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cnR();
                    return;
                }
                b.this.cnE();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.hYE.isPrimary() && this.fVW != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.hYF.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof u)) {
                        u uVar = (u) itemAtPosition;
                        if (uVar.getItemViewType() == 1 && b.this.hYF.getItemAtPosition(i4) == y.getItem(b.this.hYH, 0)) {
                            b.this.a(uVar, b.this.hYF.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.hYO.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener hYS = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hPu != null && b.this.hPu.hPW && b.this.hPW) {
                EnterForumAdView unused = b.this.hYK;
                EnterForumAdView.a(b.this.hYE.getUniqueId(), b.this.hYE.getContext());
            }
        }
    };
    private int hYT = 0;
    private int hYU = 0;
    private CustomMessageListener hYV = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cnG();
        }
    };
    boolean hPW = false;
    boolean hYW = false;
    private Runnable hYX = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cnO();
        }
    };
    private boolean hZa = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnE() {
        if (cnF()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.hPu != null && this.hPu.hPW) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cnF() {
        return this.hYF == null || this.hYF.getChildCount() == 0 || this.hYF.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.hYE = enterForumFragment;
        this.hSe = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.hWv = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.hYQ = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.hPp = viewEventCenter;
        cn(view);
        this.hYG = new com.baidu.tieba.enterForum.a.a(this.hYE.getPageContext(), this.hPp, recentlyVisitedForumModel, enterForumModel, this);
        this.hYF.setAdapter((ListAdapter) this.hYG);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.hYL = new GuidePopupWindow(this.hYE.getFragmentActivity());
    }

    private void registerListener() {
        this.hYE.registerListener(this.hYV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnG() {
        if (cnH() && this.hZb) {
            this.hYL.dMU();
            this.hYL.dMT();
            this.hYL.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.hYL, this.hYE.getFragmentActivity());
        }
    }

    private boolean cnH() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.blO().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cn(View view) {
        this.mContext = view.getContext();
        this.hYO = new e();
        this.hYO.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.hZa) {
                    b.this.hYT = -i;
                    if (b.this.hPW) {
                        b.this.cnO();
                    } else if (b.this.hPu != null && b.this.hPu.hPW) {
                        b.this.cnI();
                    }
                }
            }
        });
        this.hYF = (BdListView) view.findViewById(R.id.listview);
        xs(0);
        this.hYF.setBackgroundColor(0);
        this.hYF.setVerticalScrollBarEnabled(false);
        this.hYF.setOnScrollListener(this.mOnScrollListener);
        this.hYF.setFastScrollEnabled(false);
        this.hYF.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.hYE.cmk() != null) {
            this.hYE.cmk().a(this);
        }
        this.mPullView = new g(this.hYE.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.hYU = i3;
                if (!b.this.hPW && b.this.hPu != null && b.this.hPu.hPW && !b.this.hZa) {
                    b.this.cnI();
                    if (i3 > b.this.hYQ) {
                        b.this.hYU = 0;
                        b.this.cq(b.this.hYE.cmk().getRootView());
                    }
                }
            }
        });
        this.mPullView.iR(true);
        this.mPullView.setListPullRefreshListener(this.gce);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.hYE.getUniqueId());
        }
        this.hYF.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.hYE.getPageContext().getPageActivity());
        this.gpF = new View(this.hYE.getPageContext().getPageActivity());
        frameLayout.addView(this.gpF, new FrameLayout.LayoutParams(-1, this.hWv));
        this.hYF.getAdapter2().addHeaderView(frameLayout, 0);
        this.bxe = new View(this.hYE.getActivity());
        this.bxe.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.hYE.getActivity(), R.dimen.ds50)));
        this.bxe.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.hYS);
        this.mPullView.getView().setOnClickListener(this.hYS);
        this.gpF.setOnClickListener(this.hYS);
        cnS();
    }

    public void co(View view) {
        this.hYK = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.hYK != null) {
            cnI();
            this.hYK.setTag(this.hYE.getUniqueId());
            this.hYK.setAdData();
            this.hYK.setEventCenter(this.hPp);
            this.hYK.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnI() {
        if (!this.hZa && this.hYK != null) {
            ViewGroup.LayoutParams layoutParams = this.hYK.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cnJ = cnJ();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.hPW ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hYT + this.hYU) - cnJ, 0, 0);
                this.hYK.setLayoutParams(layoutParams2);
                this.hYK.setAdViewHeight(layoutParams2.height - cnJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cnJ() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cnK() {
        return this.hPW ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hYT + this.hYU) - cnJ();
    }

    private int cnL() {
        ViewGroup.LayoutParams layoutParams = this.hYK.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cnM() {
        if (!this.hZa) {
            this.hPW = true;
            cnI();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.hYK != null) {
                if (!this.hYK.cnB()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.hYK.cnA()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            xs(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.hYX);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.hYX, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xs(int i) {
        if (!this.hZa) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hYF.getLayoutParams();
            marginLayoutParams.topMargin = ((this.hSe + i) - this.hWv) - (EnterForumDelegateStatic.hQZ.cmK() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.hYF.setLayoutParams(marginLayoutParams);
        }
    }

    private int cnN() {
        return (this.hSe - this.hWv) - (EnterForumDelegateStatic.hQZ.cmK() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnO() {
        this.hPW = false;
        cnI();
        xs(0);
        if (this.hYW) {
            this.hYF.completePullRefreshPostDelayed(0L);
        }
        this.hYW = false;
    }

    public void cp(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.hYE.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.hYE.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.hYF.setVisibility(8);
        if (this.hYE.cmk() != null) {
            this.hYE.cmk().cmy();
            this.hYE.cmk().cmz();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.hYF.setVisibility(0);
        if (this.hYE.cmk() != null) {
            this.hYE.cmk().cmy();
            this.hYE.cmk().cmz();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.hYH);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.hYH.remove(fVar);
        a(this.hYH, this.hYI, z);
        oA(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cnP() {
        return this.hYF;
    }

    public void startPullRefresh() {
        this.hYF.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.hPW) {
            this.hYW = true;
            return;
        }
        this.hYW = false;
        this.hYF.completePullRefreshPostDelayed(0L);
    }

    public void oA(boolean z) {
        this.hYG.notifyDataSetChanged();
        if (this.bxe != null && this.bxe.getLayoutParams() != null) {
            if (z) {
                this.bxe.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bxe.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar, boolean z) {
        this.hYK.setAdData();
        EnterForumDelegateStatic.hQZ.fj(this.mContext);
        this.hYH = list;
        this.hYI = bjVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        u uVar = new u();
        uVar.ny(4);
        arrayList.add(uVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(bjVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                u uVar2 = new u();
                uVar2.ny(11);
                arrayList.add(uVar2);
            } else {
                u uVar3 = new u();
                uVar3.ny(3);
                arrayList.add(uVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bk(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bjVar.bhn());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            u uVar4 = new u();
            uVar4.ny(5);
            arrayList.add(uVar4);
        }
        hideNoDataView();
        this.hYG.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.hYF.removeFooterView(this.bxe);
            this.hYF.addFooterView(this.bxe);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.hYF.removeFooterView(this.bxe);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.hYL != null) {
            this.hYL.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bxe, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.hYR = cVar;
    }

    public void cnQ() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.blO().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.hYE != null && this.hYE.getActivity() != null && this.hYE.cmj() != null) {
            if (this.hYJ == null) {
                this.hYJ = new CommonTipView(this.hYE.getActivity());
            }
            this.hYJ.setText(R.string.enter_forum_login_tip);
            this.hYJ.c(this.hYE.cmj(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.hYE.isAdded() && this.hYE.isPrimary()) {
            hYM = false;
            if (this.hYG != null) {
                this.hYG.onPrimary();
                if (this.hYF != null) {
                    Object itemAtPosition = this.hYF.getItemAtPosition(this.hYF.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof u) && ((u) itemAtPosition).getItemViewType() == 5) {
                        this.hYG.clf();
                    }
                }
            }
            if (this.hZa) {
                this.hYK.requestFocus();
                this.hYK.requestFocusFromTouch();
                return;
            }
            return;
        }
        cnR();
    }

    public void onPause() {
        cnR();
    }

    public void onDestroy() {
        if (this.hYJ != null) {
            this.hYJ.onDestroy();
        }
        if (this.hYG != null) {
            this.hYG.onDestroy();
        }
    }

    public void wX(int i) {
        this.hYG.wX(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hYG != null) {
            this.hYG.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cle() {
        if (this.hYG == null) {
            return false;
        }
        return this.hYG.cle();
    }

    public void a(u uVar, View view) {
        if (TbadkCoreApplication.isLogin() && !hYM && this.hYE.getActivity() != null && this.hYE.getPageContext() != null && (uVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
            if (fVar.isPrivateForum() != 0 && fVar.clw() != 0 && !com.baidu.tbadk.core.sharedPref.b.blO().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.hYN = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.blO().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.hYN = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                hYM = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.hYN);
                        b.this.hYE.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.hLD = dVar.mi();
                this.hLD.setShouldCheckLocInWindow(false);
                this.hLD.setUseDirectOffset(true);
                this.hLD.show(this.hYE.getActivity());
                if (this.hYN == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.hYN == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.blO().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.hLD != null) {
                            b.this.hLD.dismiss();
                            b.this.hLD = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cnR() {
        if (this.hLD != null) {
            this.hLD.dismiss();
            this.hLD = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hPu = cVar;
        if (this.hYG != null) {
            this.hYG.setAdState(cVar);
        }
        if (cVar != null && cVar.hPW) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.pB(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.pB(R.raw.lottie_common_pull_refresh);
    }

    public void oB(boolean z) {
        if (this.hYP != z) {
            this.hYP = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hYF.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.hYF.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.hYF.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.hYF.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.hYK != null) {
            this.hYK.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.hYK != null) {
            this.hYK.setRecentlyIsShow(z);
        }
    }

    private void cnS() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.hYY = new View(this.mContext);
        this.hYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.hYE.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.hYY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float hZe = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hYZ = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.hYZ <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hYZ) {
                            b.this.cnT();
                            if (this.hZe < 50.0f) {
                                b.this.hYY.performClick();
                            }
                        } else {
                            b.this.cnU();
                        }
                        b.this.hYZ = 0.0f;
                        this.hZe = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.hYZ) {
                            b.this.at(motionEvent.getRawY() - b.this.hYZ);
                            if (b.this.eVS != null) {
                                b.this.eVS.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.hYZ) > this.hZe) {
                            this.hZe = Math.abs(motionEvent.getRawY() - b.this.hYZ);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.hYZ <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hYZ) {
                            b.this.cnT();
                        } else {
                            b.this.cnU();
                        }
                        b.this.hYZ = 0.0f;
                        this.hZe = 0.0f;
                        return true;
                }
            }
        });
        this.eVS = new ImageView(this.mContext);
        this.eVS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cnU();
            }
        });
    }

    public void cq(final View view) {
        if ((view instanceof FrameLayout) && !this.hZa) {
            this.mPullView.pause();
            this.hZa = true;
            this.hYK.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.eVS, R.drawable.icon_jinba_retract_n);
            final int cnL = cnL();
            ValueAnimator ofInt = ValueAnimator.ofInt(cnL, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.hYK != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hYK.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cnJ();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.hYK.setLayoutParams(marginLayoutParams);
                            if (intValue / cnL < 0.2d) {
                                if (b.this.hYK.getParent() != b.this.hYK.getRootView() && (viewGroup = (ViewGroup) b.this.hYK.getRootView()) != null) {
                                    ((ViewGroup) b.this.hYK.getParent()).removeView(b.this.hYK);
                                    if (b.this.hYK.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.hYK, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.hYY);
                                    viewGroup.bringChildToFront(b.this.eVS);
                                }
                            } else if (b.this.hYK.getParent() == b.this.hYK.getRootView()) {
                                if (b.this.hYK.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.hYK.getRootView();
                                    ((ViewGroup) b.this.hYK.getParent()).removeView(b.this.hYK);
                                }
                                if (b.this.hYK.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.hYE.cmn().addView(b.this.hYK, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.hZa = false;
                    b.this.xs(((intValue - cnL) * 2) + 0);
                    b.this.hZa = true;
                    float abs = Math.abs(intValue / cnL);
                    b.this.hYF.setAlpha(abs);
                    View cmB = b.this.hYE.cmk().cmB();
                    if (cmB != null) {
                        cmB.setAlpha(abs);
                    }
                    View findViewById = b.this.hYE.cmn().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.hYK != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hYK.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cnJ();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.hYK.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.hYF.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.hZa = false;
                    b.this.xs(0 - (cnL * 2));
                    b.this.hZa = true;
                    b.this.hYF.setVisibility(8);
                    b.this.hYY.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.hYY.getParent() == null) {
                        frameLayout.addView(b.this.hYY, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.eVS.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.eVS, layoutParams3);
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
            this.hYK.requestFocus();
            this.hYK.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(float f) {
        ViewGroup viewGroup;
        int cnK = cnK();
        float abs = Math.abs(cnK / (cnN() - cnK));
        int i = (int) f;
        if (this.hYK != null) {
            ViewGroup.LayoutParams layoutParams = this.hYK.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cnJ();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.hYK.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.hYK.getParent() != this.hYK.getRootView() && (viewGroup = (ViewGroup) this.hYK.getRootView()) != null) {
                        ((ViewGroup) this.hYK.getParent()).removeView(this.hYK);
                        if (this.hYK.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.hYK, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.hYY);
                        viewGroup.bringChildToFront(this.eVS);
                    }
                } else if (this.hYK.getParent() == this.hYK.getRootView()) {
                    if (this.hYK.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.hYK.getRootView();
                        ((ViewGroup) this.hYK.getParent()).removeView(this.hYK);
                    }
                    if (this.hYK.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.hYE.cmn().addView(this.hYK, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.hYF.setVisibility(0);
        this.hZa = false;
        xs(((int) ((i * abs) - (cnK * abs))) * 2);
        this.hZa = true;
        float abs2 = Math.abs(i / cnK);
        this.hYF.setAlpha(abs2);
        View cmB = this.hYE.cmk().cmB();
        if (cmB != null) {
            cmB.setAlpha(abs2);
        }
        View findViewById = this.hYE.cmn().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnT() {
        if (this.eVS != null) {
            this.eVS.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cnL(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.at(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.at(0.0f);
                b.this.mPullView.resume();
                b.this.hYF.completePullRefresh();
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
    public void cnU() {
        this.hYY.setEnabled(false);
        int cnK = cnK();
        Math.abs(cnK / (cnN() - cnK));
        this.eVS.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.hYK.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cnL(), cnK);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.at(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
                    ViewGroup viewGroup = (ViewGroup) b.this.hYY.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.hYY);
                        viewGroup.removeView(b.this.eVS);
                    }
                    b.this.eVS.setVisibility(0);
                    b.this.hZa = false;
                    b.this.cnI();
                    b.this.hYU = 0;
                    b.this.xs(0);
                    b.this.hZa = true;
                    b.this.mPullView.resume();
                    b.this.hYF.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hZa = false;
                        }
                    }, 0L);
                    b.this.hYF.setVisibility(0);
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
        if (this.hZa) {
            cnU();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.clN())) {
                this.hZb = false;
            } else {
                this.hZb = true;
            }
            this.hYL.setForumId(aVar.clL());
            this.hYL.G(aVar.clK(), aVar.clM());
            this.hYL.fG(aVar.clJ());
            this.hYL.Ao(aVar.clN());
        }
    }
}
