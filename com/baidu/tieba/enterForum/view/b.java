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
/* loaded from: classes16.dex */
public class b implements EnterForumAdView.a {
    private static boolean hCP = false;
    private View bqh;
    private ImageView eHE;
    private View gab;
    private int hAy;
    private final EnterForumFragment hCH;
    private BdListView hCI;
    private com.baidu.tieba.enterForum.a.a hCJ;
    private List<com.baidu.tieba.enterForum.data.f> hCK;
    private bj hCL;
    private CommonTipView hCM;
    private EnterForumAdView hCN;
    private GuidePopupWindow hCO;
    private int hCQ;
    private e hCR;
    private int hCT;
    private f.c hCU;
    private View hDb;
    private float hDc;
    private boolean hDe;
    private com.baidu.adp.lib.guide.c hpE;
    private ViewEventCenter htp;
    private com.baidu.tieba.enterForum.data.c htu;
    private int hwe;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean hCS = true;
    private f.c fMy = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.hDd) {
                com.baidu.tieba.s.c.dvJ().D(b.this.hCH.getUniqueId());
                if (b.this.hCU != null) {
                    b.this.hCU.onListPullRefresh(z);
                }
                if (z && !b.this.htW && b.this.htu != null && b.this.htu.htW) {
                    if (b.this.htu.htY > 0) {
                        b.this.hCI.smoothScrollToPosition(0, 0, 0);
                        b.this.chb();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hCI.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int fGt = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.hCR.onScrollStateChanged(absListView, i);
            if (this.fGt != i) {
                this.fGt = i;
                if (this.fGt == 1) {
                    if (b.this.htu == null || !b.this.htu.htW) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.chg();
                    return;
                }
                b.this.cgT();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.hCH.isPrimary() && this.fGt != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.hCI.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof u)) {
                        u uVar = (u) itemAtPosition;
                        if (uVar.getItemViewType() == 1 && b.this.hCI.getItemAtPosition(i4) == y.getItem(b.this.hCK, 0)) {
                            b.this.a(uVar, b.this.hCI.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.hCR.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener hCV = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.htu != null && b.this.htu.htW && b.this.htW) {
                EnterForumAdView unused = b.this.hCN;
                EnterForumAdView.a(b.this.hCH.getUniqueId(), b.this.hCH.getContext());
            }
        }
    };
    private int hCW = 0;
    private int hCX = 0;
    private CustomMessageListener hCY = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cgV();
        }
    };
    boolean htW = false;
    boolean hCZ = false;
    private Runnable hDa = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.chd();
        }
    };
    private boolean hDd = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cgT() {
        if (cgU()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.htu != null && this.htu.htW) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cgU() {
        return this.hCI == null || this.hCI.getChildCount() == 0 || this.hCI.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.hCH = enterForumFragment;
        this.hwe = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.hAy = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.hCT = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.htp = viewEventCenter;
        ca(view);
        this.hCJ = new com.baidu.tieba.enterForum.a.a(this.hCH.getPageContext(), this.htp, recentlyVisitedForumModel, enterForumModel, this);
        this.hCI.setAdapter((ListAdapter) this.hCJ);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.hCO = new GuidePopupWindow(this.hCH.getFragmentActivity());
    }

    private void registerListener() {
        this.hCH.registerListener(this.hCY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgV() {
        if (cgW() && this.hDe) {
            this.hCO.dFo();
            this.hCO.dFn();
            this.hCO.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.hCO, this.hCH.getFragmentActivity());
        }
    }

    private boolean cgW() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void ca(View view) {
        this.mContext = view.getContext();
        this.hCR = new e();
        this.hCR.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.hDd) {
                    b.this.hCW = -i;
                    if (b.this.htW) {
                        b.this.chd();
                    } else if (b.this.htu != null && b.this.htu.htW) {
                        b.this.cgX();
                    }
                }
            }
        });
        this.hCI = (BdListView) view.findViewById(R.id.listview);
        wn(0);
        this.hCI.setBackgroundColor(0);
        this.hCI.setVerticalScrollBarEnabled(false);
        this.hCI.setOnScrollListener(this.mOnScrollListener);
        this.hCI.setFastScrollEnabled(false);
        this.hCI.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.hCH.cfx() != null) {
            this.hCH.cfx().a(this);
        }
        this.mPullView = new g(this.hCH.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.hCX = i3;
                if (!b.this.htW && b.this.htu != null && b.this.htu.htW && !b.this.hDd) {
                    b.this.cgX();
                    if (i3 > b.this.hCT) {
                        b.this.hCX = 0;
                        b.this.cd(b.this.hCH.cfx().getRootView());
                    }
                }
            }
        });
        this.mPullView.iw(true);
        this.mPullView.setListPullRefreshListener(this.fMy);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.hCH.getUniqueId());
        }
        this.hCI.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.hCH.getPageContext().getPageActivity());
        this.gab = new View(this.hCH.getPageContext().getPageActivity());
        frameLayout.addView(this.gab, new FrameLayout.LayoutParams(-1, this.hAy));
        this.hCI.getAdapter2().addHeaderView(frameLayout, 0);
        this.bqh = new View(this.hCH.getActivity());
        this.bqh.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.hCH.getActivity(), R.dimen.ds50)));
        this.bqh.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.hCV);
        this.mPullView.getView().setOnClickListener(this.hCV);
        this.gab.setOnClickListener(this.hCV);
        chh();
    }

    public void cb(View view) {
        this.hCN = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.hCN != null) {
            cgX();
            this.hCN.setTag(this.hCH.getUniqueId());
            this.hCN.setAdData();
            this.hCN.setEventCenter(this.htp);
            this.hCN.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgX() {
        if (!this.hDd && this.hCN != null) {
            ViewGroup.LayoutParams layoutParams = this.hCN.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cgY = cgY();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.htW ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hCW + this.hCX) - cgY, 0, 0);
                this.hCN.setLayoutParams(layoutParams2);
                this.hCN.setAdViewHeight(layoutParams2.height - cgY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cgY() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cgZ() {
        return this.htW ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hCW + this.hCX) - cgY();
    }

    private int cha() {
        ViewGroup.LayoutParams layoutParams = this.hCN.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void chb() {
        if (!this.hDd) {
            this.htW = true;
            cgX();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.hCN != null) {
                if (!this.hCN.cgQ()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.hCN.cgP()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            wn(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.hDa);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.hDa, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wn(int i) {
        if (!this.hDd) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hCI.getLayoutParams();
            marginLayoutParams.topMargin = ((this.hwe + i) - this.hAy) - (EnterForumDelegateStatic.huZ.cfX() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.hCI.setLayoutParams(marginLayoutParams);
        }
    }

    private int chc() {
        return (this.hwe - this.hAy) - (EnterForumDelegateStatic.huZ.cfX() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chd() {
        this.htW = false;
        cgX();
        wn(0);
        if (this.hCZ) {
            this.hCI.completePullRefreshPostDelayed(0L);
        }
        this.hCZ = false;
    }

    public void cc(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.hCH.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.hCH.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.hCI.setVisibility(8);
        if (this.hCH.cfx() != null) {
            this.hCH.cfx().cfL();
            this.hCH.cfx().cfM();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.hCI.setVisibility(0);
        if (this.hCH.cfx() != null) {
            this.hCH.cfx().cfL();
            this.hCH.cfx().cfM();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.hCK);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.hCK.remove(fVar);
        a(this.hCK, this.hCL, z);
        nP(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView che() {
        return this.hCI;
    }

    public void startPullRefresh() {
        this.hCI.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.htW) {
            this.hCZ = true;
            return;
        }
        this.hCZ = false;
        this.hCI.completePullRefreshPostDelayed(0L);
    }

    public void nP(boolean z) {
        this.hCJ.notifyDataSetChanged();
        if (this.bqh != null && this.bqh.getLayoutParams() != null) {
            if (z) {
                this.bqh.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bqh.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar, boolean z) {
        this.hCN.setAdData();
        EnterForumDelegateStatic.huZ.eW(this.mContext);
        this.hCK = list;
        this.hCL = bjVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        u uVar = new u();
        uVar.mQ(4);
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
                uVar2.mQ(11);
                arrayList.add(uVar2);
            } else {
                u uVar3 = new u();
                uVar3.mQ(3);
                arrayList.add(uVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bk(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bjVar.bdK());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            u uVar4 = new u();
            uVar4.mQ(5);
            arrayList.add(uVar4);
        }
        hideNoDataView();
        this.hCJ.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.hCI.removeFooterView(this.bqh);
            this.hCI.addFooterView(this.bqh);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.hCI.removeFooterView(this.bqh);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.hCO != null) {
            this.hCO.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bqh, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.hCU = cVar;
    }

    public void chf() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.hCH != null && this.hCH.getActivity() != null && this.hCH.cfw() != null) {
            if (this.hCM == null) {
                this.hCM = new CommonTipView(this.hCH.getActivity());
            }
            this.hCM.setText(R.string.enter_forum_login_tip);
            this.hCM.c(this.hCH.cfw(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.hCH.isAdded() && this.hCH.isPrimary()) {
            hCP = false;
            if (this.hCJ != null) {
                this.hCJ.onPrimary();
                if (this.hCI != null) {
                    Object itemAtPosition = this.hCI.getItemAtPosition(this.hCI.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof u) && ((u) itemAtPosition).getItemViewType() == 5) {
                        this.hCJ.ceu();
                    }
                }
            }
            if (this.hDd) {
                this.hCN.requestFocus();
                this.hCN.requestFocusFromTouch();
                return;
            }
            return;
        }
        chg();
    }

    public void onPause() {
        chg();
    }

    public void onDestroy() {
        if (this.hCM != null) {
            this.hCM.onDestroy();
        }
        if (this.hCJ != null) {
            this.hCJ.onDestroy();
        }
    }

    public void vS(int i) {
        this.hCJ.vS(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hCJ != null) {
            this.hCJ.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cet() {
        if (this.hCJ == null) {
            return false;
        }
        return this.hCJ.cet();
    }

    public void a(u uVar, View view) {
        if (TbadkCoreApplication.isLogin() && !hCP && this.hCH.getActivity() != null && this.hCH.getPageContext() != null && (uVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
            if (fVar.isPrivateForum() != 0 && fVar.ceL() != 0 && !com.baidu.tbadk.core.sharedPref.b.bik().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.hCQ = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bik().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.hCQ = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                hCP = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aj(0).ag(true).ah(false).af(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.hCQ);
                        b.this.hCH.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.hpE = dVar.md();
                this.hpE.setShouldCheckLocInWindow(false);
                this.hpE.setUseDirectOffset(true);
                this.hpE.show(this.hCH.getActivity());
                if (this.hCQ == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.hCQ == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.hpE != null) {
                            b.this.hpE.dismiss();
                            b.this.hpE = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void chg() {
        if (this.hpE != null) {
            this.hpE.dismiss();
            this.hpE = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.htu = cVar;
        if (this.hCJ != null) {
            this.hCJ.setAdState(cVar);
        }
        if (cVar != null && cVar.htW) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.oQ(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.oQ(R.raw.lottie_common_pull_refresh);
    }

    public void nQ(boolean z) {
        if (this.hCS != z) {
            this.hCS = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hCI.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.hCI.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.hCI.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.hCI.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.hCN != null) {
            this.hCN.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.hCN != null) {
            this.hCN.setRecentlyIsShow(z);
        }
    }

    private void chh() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.hDb = new View(this.mContext);
        this.hDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.hCH.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.hDb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float hDh = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hDc = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.hDc <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hDc) {
                            b.this.chi();
                            if (this.hDh < 50.0f) {
                                b.this.hDb.performClick();
                            }
                        } else {
                            b.this.chj();
                        }
                        b.this.hDc = 0.0f;
                        this.hDh = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.hDc) {
                            b.this.an(motionEvent.getRawY() - b.this.hDc);
                            if (b.this.eHE != null) {
                                b.this.eHE.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.hDc) > this.hDh) {
                            this.hDh = Math.abs(motionEvent.getRawY() - b.this.hDc);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.hDc <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hDc) {
                            b.this.chi();
                        } else {
                            b.this.chj();
                        }
                        b.this.hDc = 0.0f;
                        this.hDh = 0.0f;
                        return true;
                }
            }
        });
        this.eHE = new ImageView(this.mContext);
        this.eHE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.chj();
            }
        });
    }

    public void cd(final View view) {
        if ((view instanceof FrameLayout) && !this.hDd) {
            this.mPullView.pause();
            this.hDd = true;
            this.hCN.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.eHE, R.drawable.icon_jinba_retract_n);
            final int cha = cha();
            ValueAnimator ofInt = ValueAnimator.ofInt(cha, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.hCN != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hCN.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cgY();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.hCN.setLayoutParams(marginLayoutParams);
                            if (intValue / cha < 0.2d) {
                                if (b.this.hCN.getParent() != b.this.hCN.getRootView() && (viewGroup = (ViewGroup) b.this.hCN.getRootView()) != null) {
                                    ((ViewGroup) b.this.hCN.getParent()).removeView(b.this.hCN);
                                    if (b.this.hCN.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.hCN, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.hDb);
                                    viewGroup.bringChildToFront(b.this.eHE);
                                }
                            } else if (b.this.hCN.getParent() == b.this.hCN.getRootView()) {
                                if (b.this.hCN.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.hCN.getRootView();
                                    ((ViewGroup) b.this.hCN.getParent()).removeView(b.this.hCN);
                                }
                                if (b.this.hCN.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.hCH.cfA().addView(b.this.hCN, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.hDd = false;
                    b.this.wn(((intValue - cha) * 2) + 0);
                    b.this.hDd = true;
                    float abs = Math.abs(intValue / cha);
                    b.this.hCI.setAlpha(abs);
                    View cfO = b.this.hCH.cfx().cfO();
                    if (cfO != null) {
                        cfO.setAlpha(abs);
                    }
                    View findViewById = b.this.hCH.cfA().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.hCN != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hCN.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cgY();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.hCN.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.hCI.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.hDd = false;
                    b.this.wn(0 - (cha * 2));
                    b.this.hDd = true;
                    b.this.hCI.setVisibility(8);
                    b.this.hDb.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.hDb.getParent() == null) {
                        frameLayout.addView(b.this.hDb, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.eHE.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.eHE, layoutParams3);
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
            this.hCN.requestFocus();
            this.hCN.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(float f) {
        ViewGroup viewGroup;
        int cgZ = cgZ();
        float abs = Math.abs(cgZ / (chc() - cgZ));
        int i = (int) f;
        if (this.hCN != null) {
            ViewGroup.LayoutParams layoutParams = this.hCN.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cgY();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.hCN.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.hCN.getParent() != this.hCN.getRootView() && (viewGroup = (ViewGroup) this.hCN.getRootView()) != null) {
                        ((ViewGroup) this.hCN.getParent()).removeView(this.hCN);
                        if (this.hCN.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.hCN, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.hDb);
                        viewGroup.bringChildToFront(this.eHE);
                    }
                } else if (this.hCN.getParent() == this.hCN.getRootView()) {
                    if (this.hCN.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.hCN.getRootView();
                        ((ViewGroup) this.hCN.getParent()).removeView(this.hCN);
                    }
                    if (this.hCN.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.hCH.cfA().addView(this.hCN, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.hCI.setVisibility(0);
        this.hDd = false;
        wn(((int) ((i * abs) - (cgZ * abs))) * 2);
        this.hDd = true;
        float abs2 = Math.abs(i / cgZ);
        this.hCI.setAlpha(abs2);
        View cfO = this.hCH.cfx().cfO();
        if (cfO != null) {
            cfO.setAlpha(abs2);
        }
        View findViewById = this.hCH.cfA().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chi() {
        if (this.eHE != null) {
            this.eHE.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cha(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.an(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.an(0.0f);
                b.this.mPullView.resume();
                b.this.hCI.completePullRefresh();
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
    public void chj() {
        this.hDb.setEnabled(false);
        int cgZ = cgZ();
        Math.abs(cgZ / (chc() - cgZ));
        this.eHE.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.hCN.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cha(), cgZ);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.an(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass13());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$13  reason: invalid class name */
    /* loaded from: classes16.dex */
    public class AnonymousClass13 implements Animator.AnimatorListener {
        AnonymousClass13() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.hDb.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.hDb);
                        viewGroup.removeView(b.this.eHE);
                    }
                    b.this.eHE.setVisibility(0);
                    b.this.hDd = false;
                    b.this.cgX();
                    b.this.hCX = 0;
                    b.this.wn(0);
                    b.this.hDd = true;
                    b.this.mPullView.resume();
                    b.this.hCI.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hDd = false;
                        }
                    }, 0L);
                    b.this.hCI.setVisibility(0);
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
        if (this.hDd) {
            chj();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cfc())) {
                this.hDe = false;
            } else {
                this.hDe = true;
            }
            this.hCO.setForumId(aVar.cfa());
            this.hCO.J(aVar.ceZ(), aVar.cfb());
            this.hCO.fu(aVar.ceY());
            this.hCO.zh(aVar.cfc());
        }
    }
}
