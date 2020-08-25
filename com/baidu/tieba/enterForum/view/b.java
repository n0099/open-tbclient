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
    private static boolean hCJ = false;
    private View bqe;
    private ImageView eHA;
    private View fZX;
    private int hAs;
    private final EnterForumFragment hCB;
    private BdListView hCC;
    private com.baidu.tieba.enterForum.a.a hCD;
    private List<com.baidu.tieba.enterForum.data.f> hCE;
    private bj hCF;
    private CommonTipView hCG;
    private EnterForumAdView hCH;
    private GuidePopupWindow hCI;
    private int hCK;
    private e hCL;
    private int hCN;
    private f.c hCO;
    private View hCV;
    private float hCW;
    private boolean hCY;
    private com.baidu.adp.lib.guide.c hpA;
    private ViewEventCenter htj;
    private com.baidu.tieba.enterForum.data.c hto;
    private int hvY;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean hCM = true;
    private f.c fMu = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.hCX) {
                com.baidu.tieba.s.c.dvE().D(b.this.hCB.getUniqueId());
                if (b.this.hCO != null) {
                    b.this.hCO.onListPullRefresh(z);
                }
                if (z && !b.this.htQ && b.this.hto != null && b.this.hto.htQ) {
                    if (b.this.hto.htS > 0) {
                        b.this.hCC.smoothScrollToPosition(0, 0, 0);
                        b.this.cha();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hCC.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int fGp = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.hCL.onScrollStateChanged(absListView, i);
            if (this.fGp != i) {
                this.fGp = i;
                if (this.fGp == 1) {
                    if (b.this.hto == null || !b.this.hto.htQ) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.chf();
                    return;
                }
                b.this.cgS();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.hCB.isPrimary() && this.fGp != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.hCC.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof u)) {
                        u uVar = (u) itemAtPosition;
                        if (uVar.getItemViewType() == 1 && b.this.hCC.getItemAtPosition(i4) == y.getItem(b.this.hCE, 0)) {
                            b.this.a(uVar, b.this.hCC.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.hCL.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener hCP = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hto != null && b.this.hto.htQ && b.this.htQ) {
                EnterForumAdView unused = b.this.hCH;
                EnterForumAdView.a(b.this.hCB.getUniqueId(), b.this.hCB.getContext());
            }
        }
    };
    private int hCQ = 0;
    private int hCR = 0;
    private CustomMessageListener hCS = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cgU();
        }
    };
    boolean htQ = false;
    boolean hCT = false;
    private Runnable hCU = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.chc();
        }
    };
    private boolean hCX = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cgS() {
        if (cgT()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.hto != null && this.hto.htQ) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cgT() {
        return this.hCC == null || this.hCC.getChildCount() == 0 || this.hCC.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.hCB = enterForumFragment;
        this.hvY = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.hAs = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.hCN = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.htj = viewEventCenter;
        ca(view);
        this.hCD = new com.baidu.tieba.enterForum.a.a(this.hCB.getPageContext(), this.htj, recentlyVisitedForumModel, enterForumModel, this);
        this.hCC.setAdapter((ListAdapter) this.hCD);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.hCI = new GuidePopupWindow(this.hCB.getFragmentActivity());
    }

    private void registerListener() {
        this.hCB.registerListener(this.hCS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgU() {
        if (cgV() && this.hCY) {
            this.hCI.dFf();
            this.hCI.dFe();
            this.hCI.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.hCI, this.hCB.getFragmentActivity());
        }
    }

    private boolean cgV() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void ca(View view) {
        this.mContext = view.getContext();
        this.hCL = new e();
        this.hCL.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.hCX) {
                    b.this.hCQ = -i;
                    if (b.this.htQ) {
                        b.this.chc();
                    } else if (b.this.hto != null && b.this.hto.htQ) {
                        b.this.cgW();
                    }
                }
            }
        });
        this.hCC = (BdListView) view.findViewById(R.id.listview);
        wn(0);
        this.hCC.setBackgroundColor(0);
        this.hCC.setVerticalScrollBarEnabled(false);
        this.hCC.setOnScrollListener(this.mOnScrollListener);
        this.hCC.setFastScrollEnabled(false);
        this.hCC.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.hCB.cfw() != null) {
            this.hCB.cfw().a(this);
        }
        this.mPullView = new g(this.hCB.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.hCR = i3;
                if (!b.this.htQ && b.this.hto != null && b.this.hto.htQ && !b.this.hCX) {
                    b.this.cgW();
                    if (i3 > b.this.hCN) {
                        b.this.hCR = 0;
                        b.this.cd(b.this.hCB.cfw().getRootView());
                    }
                }
            }
        });
        this.mPullView.iv(true);
        this.mPullView.setListPullRefreshListener(this.fMu);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.hCB.getUniqueId());
        }
        this.hCC.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.hCB.getPageContext().getPageActivity());
        this.fZX = new View(this.hCB.getPageContext().getPageActivity());
        frameLayout.addView(this.fZX, new FrameLayout.LayoutParams(-1, this.hAs));
        this.hCC.getAdapter2().addHeaderView(frameLayout, 0);
        this.bqe = new View(this.hCB.getActivity());
        this.bqe.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.hCB.getActivity(), R.dimen.ds50)));
        this.bqe.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.hCP);
        this.mPullView.getView().setOnClickListener(this.hCP);
        this.fZX.setOnClickListener(this.hCP);
        chg();
    }

    public void cb(View view) {
        this.hCH = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.hCH != null) {
            cgW();
            this.hCH.setTag(this.hCB.getUniqueId());
            this.hCH.setAdData();
            this.hCH.setEventCenter(this.htj);
            this.hCH.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgW() {
        if (!this.hCX && this.hCH != null) {
            ViewGroup.LayoutParams layoutParams = this.hCH.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cgX = cgX();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.htQ ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hCQ + this.hCR) - cgX, 0, 0);
                this.hCH.setLayoutParams(layoutParams2);
                this.hCH.setAdViewHeight(layoutParams2.height - cgX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cgX() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cgY() {
        return this.htQ ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hCQ + this.hCR) - cgX();
    }

    private int cgZ() {
        ViewGroup.LayoutParams layoutParams = this.hCH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cha() {
        if (!this.hCX) {
            this.htQ = true;
            cgW();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.hCH != null) {
                if (!this.hCH.cgP()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.hCH.cgO()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            wn(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.hCU);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.hCU, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wn(int i) {
        if (!this.hCX) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hCC.getLayoutParams();
            marginLayoutParams.topMargin = ((this.hvY + i) - this.hAs) - (EnterForumDelegateStatic.huT.cfW() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.hCC.setLayoutParams(marginLayoutParams);
        }
    }

    private int chb() {
        return (this.hvY - this.hAs) - (EnterForumDelegateStatic.huT.cfW() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chc() {
        this.htQ = false;
        cgW();
        wn(0);
        if (this.hCT) {
            this.hCC.completePullRefreshPostDelayed(0L);
        }
        this.hCT = false;
    }

    public void cc(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.hCB.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.hCB.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.hCC.setVisibility(8);
        if (this.hCB.cfw() != null) {
            this.hCB.cfw().cfK();
            this.hCB.cfw().cfL();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.hCC.setVisibility(0);
        if (this.hCB.cfw() != null) {
            this.hCB.cfw().cfK();
            this.hCB.cfw().cfL();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.hCE);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.hCE.remove(fVar);
        a(this.hCE, this.hCF, z);
        nN(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView chd() {
        return this.hCC;
    }

    public void startPullRefresh() {
        this.hCC.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.htQ) {
            this.hCT = true;
            return;
        }
        this.hCT = false;
        this.hCC.completePullRefreshPostDelayed(0L);
    }

    public void nN(boolean z) {
        this.hCD.notifyDataSetChanged();
        if (this.bqe != null && this.bqe.getLayoutParams() != null) {
            if (z) {
                this.bqe.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bqe.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar, boolean z) {
        this.hCH.setAdData();
        EnterForumDelegateStatic.huT.eW(this.mContext);
        this.hCE = list;
        this.hCF = bjVar;
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
        this.hCD.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.hCC.removeFooterView(this.bqe);
            this.hCC.addFooterView(this.bqe);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.hCC.removeFooterView(this.bqe);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.hCI != null) {
            this.hCI.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bqe, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.hCO = cVar;
    }

    public void che() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.hCB != null && this.hCB.getActivity() != null && this.hCB.cfv() != null) {
            if (this.hCG == null) {
                this.hCG = new CommonTipView(this.hCB.getActivity());
            }
            this.hCG.setText(R.string.enter_forum_login_tip);
            this.hCG.c(this.hCB.cfv(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.hCB.isAdded() && this.hCB.isPrimary()) {
            hCJ = false;
            if (this.hCD != null) {
                this.hCD.onPrimary();
                if (this.hCC != null) {
                    Object itemAtPosition = this.hCC.getItemAtPosition(this.hCC.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof u) && ((u) itemAtPosition).getItemViewType() == 5) {
                        this.hCD.cet();
                    }
                }
            }
            if (this.hCX) {
                this.hCH.requestFocus();
                this.hCH.requestFocusFromTouch();
                return;
            }
            return;
        }
        chf();
    }

    public void onPause() {
        chf();
    }

    public void onDestroy() {
        if (this.hCG != null) {
            this.hCG.onDestroy();
        }
        if (this.hCD != null) {
            this.hCD.onDestroy();
        }
    }

    public void vS(int i) {
        this.hCD.vS(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hCD != null) {
            this.hCD.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean ces() {
        if (this.hCD == null) {
            return false;
        }
        return this.hCD.ces();
    }

    public void a(u uVar, View view) {
        if (TbadkCoreApplication.isLogin() && !hCJ && this.hCB.getActivity() != null && this.hCB.getPageContext() != null && (uVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
            if (fVar.isPrivateForum() != 0 && fVar.ceK() != 0 && !com.baidu.tbadk.core.sharedPref.b.bik().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.hCK = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bik().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.hCK = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                hCJ = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).aj(0).ag(true).ah(false).af(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.hCK);
                        b.this.hCB.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.hpA = dVar.md();
                this.hpA.setShouldCheckLocInWindow(false);
                this.hpA.setUseDirectOffset(true);
                this.hpA.show(this.hCB.getActivity());
                if (this.hCK == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.hCK == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.hpA != null) {
                            b.this.hpA.dismiss();
                            b.this.hpA = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void chf() {
        if (this.hpA != null) {
            this.hpA.dismiss();
            this.hpA = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hto = cVar;
        if (this.hCD != null) {
            this.hCD.setAdState(cVar);
        }
        if (cVar != null && cVar.htQ) {
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

    public void nO(boolean z) {
        if (this.hCM != z) {
            this.hCM = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hCC.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.hCC.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.hCC.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.hCC.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.hCH != null) {
            this.hCH.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.hCH != null) {
            this.hCH.setRecentlyIsShow(z);
        }
    }

    private void chg() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.hCV = new View(this.mContext);
        this.hCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.hCB.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.hCV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float hDb = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hCW = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.hCW <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hCW) {
                            b.this.chh();
                            if (this.hDb < 50.0f) {
                                b.this.hCV.performClick();
                            }
                        } else {
                            b.this.chi();
                        }
                        b.this.hCW = 0.0f;
                        this.hDb = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.hCW) {
                            b.this.an(motionEvent.getRawY() - b.this.hCW);
                            if (b.this.eHA != null) {
                                b.this.eHA.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.hCW) > this.hDb) {
                            this.hDb = Math.abs(motionEvent.getRawY() - b.this.hCW);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.hCW <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hCW) {
                            b.this.chh();
                        } else {
                            b.this.chi();
                        }
                        b.this.hCW = 0.0f;
                        this.hDb = 0.0f;
                        return true;
                }
            }
        });
        this.eHA = new ImageView(this.mContext);
        this.eHA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.chi();
            }
        });
    }

    public void cd(final View view) {
        if ((view instanceof FrameLayout) && !this.hCX) {
            this.mPullView.pause();
            this.hCX = true;
            this.hCH.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.eHA, R.drawable.icon_jinba_retract_n);
            final int cgZ = cgZ();
            ValueAnimator ofInt = ValueAnimator.ofInt(cgZ, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.hCH != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hCH.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cgX();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.hCH.setLayoutParams(marginLayoutParams);
                            if (intValue / cgZ < 0.2d) {
                                if (b.this.hCH.getParent() != b.this.hCH.getRootView() && (viewGroup = (ViewGroup) b.this.hCH.getRootView()) != null) {
                                    ((ViewGroup) b.this.hCH.getParent()).removeView(b.this.hCH);
                                    if (b.this.hCH.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.hCH, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.hCV);
                                    viewGroup.bringChildToFront(b.this.eHA);
                                }
                            } else if (b.this.hCH.getParent() == b.this.hCH.getRootView()) {
                                if (b.this.hCH.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.hCH.getRootView();
                                    ((ViewGroup) b.this.hCH.getParent()).removeView(b.this.hCH);
                                }
                                if (b.this.hCH.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.hCB.cfz().addView(b.this.hCH, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.hCX = false;
                    b.this.wn(((intValue - cgZ) * 2) + 0);
                    b.this.hCX = true;
                    float abs = Math.abs(intValue / cgZ);
                    b.this.hCC.setAlpha(abs);
                    View cfN = b.this.hCB.cfw().cfN();
                    if (cfN != null) {
                        cfN.setAlpha(abs);
                    }
                    View findViewById = b.this.hCB.cfz().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.hCH != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hCH.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cgX();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.hCH.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.hCC.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.hCX = false;
                    b.this.wn(0 - (cgZ * 2));
                    b.this.hCX = true;
                    b.this.hCC.setVisibility(8);
                    b.this.hCV.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.hCV.getParent() == null) {
                        frameLayout.addView(b.this.hCV, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.eHA.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.eHA, layoutParams3);
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
            this.hCH.requestFocus();
            this.hCH.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(float f) {
        ViewGroup viewGroup;
        int cgY = cgY();
        float abs = Math.abs(cgY / (chb() - cgY));
        int i = (int) f;
        if (this.hCH != null) {
            ViewGroup.LayoutParams layoutParams = this.hCH.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cgX();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.hCH.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.hCH.getParent() != this.hCH.getRootView() && (viewGroup = (ViewGroup) this.hCH.getRootView()) != null) {
                        ((ViewGroup) this.hCH.getParent()).removeView(this.hCH);
                        if (this.hCH.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.hCH, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.hCV);
                        viewGroup.bringChildToFront(this.eHA);
                    }
                } else if (this.hCH.getParent() == this.hCH.getRootView()) {
                    if (this.hCH.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.hCH.getRootView();
                        ((ViewGroup) this.hCH.getParent()).removeView(this.hCH);
                    }
                    if (this.hCH.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.hCB.cfz().addView(this.hCH, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.hCC.setVisibility(0);
        this.hCX = false;
        wn(((int) ((i * abs) - (cgY * abs))) * 2);
        this.hCX = true;
        float abs2 = Math.abs(i / cgY);
        this.hCC.setAlpha(abs2);
        View cfN = this.hCB.cfw().cfN();
        if (cfN != null) {
            cfN.setAlpha(abs2);
        }
        View findViewById = this.hCB.cfz().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chh() {
        if (this.eHA != null) {
            this.eHA.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cgZ(), 0);
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
                b.this.hCC.completePullRefresh();
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
    public void chi() {
        this.hCV.setEnabled(false);
        int cgY = cgY();
        Math.abs(cgY / (chb() - cgY));
        this.eHA.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.hCH.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cgZ(), cgY);
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
                    ViewGroup viewGroup = (ViewGroup) b.this.hCV.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.hCV);
                        viewGroup.removeView(b.this.eHA);
                    }
                    b.this.eHA.setVisibility(0);
                    b.this.hCX = false;
                    b.this.cgW();
                    b.this.hCR = 0;
                    b.this.wn(0);
                    b.this.hCX = true;
                    b.this.mPullView.resume();
                    b.this.hCC.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hCX = false;
                        }
                    }, 0L);
                    b.this.hCC.setVisibility(0);
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
        if (this.hCX) {
            chi();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cfb())) {
                this.hCY = false;
            } else {
                this.hCY = true;
            }
            this.hCI.setForumId(aVar.ceZ());
            this.hCI.J(aVar.ceY(), aVar.cfa());
            this.hCI.fu(aVar.ceX());
            this.hCI.zg(aVar.cfb());
        }
    }
}
