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
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private static boolean hpS = false;
    private View bkz;
    private ImageView ewZ;
    private View fNZ;
    private com.baidu.adp.lib.guide.c hcJ;
    private ViewEventCenter hgq;
    private com.baidu.tieba.enterForum.data.c hgv;
    private int hja;
    private int hnB;
    private final EnterForumFragment hpK;
    private BdListView hpL;
    private com.baidu.tieba.enterForum.a.a hpM;
    private List<com.baidu.tieba.enterForum.data.f> hpN;
    private bi hpO;
    private CommonTipView hpP;
    private EnterForumAdView hpQ;
    private GuidePopupWindow hpR;
    private int hpT;
    private e hpU;
    private int hpW;
    private f.c hpX;
    private View hqe;
    private float hqf;
    private boolean hqh;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean hpV = true;
    private f.c fBc = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.hqg) {
                com.baidu.tieba.s.c.dkh().D(b.this.hpK.getUniqueId());
                if (b.this.hpX != null) {
                    b.this.hpX.onListPullRefresh(z);
                }
                if (z && !b.this.hgX && b.this.hgv != null && b.this.hgv.hgX) {
                    if (b.this.hgv.hgZ > 0) {
                        b.this.hpL.smoothScrollToPosition(0, 0, 0);
                        b.this.bWN();
                        return;
                    }
                    com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hpL.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int fuW = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.hpU.onScrollStateChanged(absListView, i);
            if (this.fuW != i) {
                this.fuW = i;
                if (this.fuW == 1) {
                    if (b.this.hgv == null || !b.this.hgv.hgX) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.bWS();
                    return;
                }
                b.this.bWF();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.hpK.isPrimary() && this.fuW != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.hpL.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof t)) {
                        t tVar = (t) itemAtPosition;
                        if (tVar.getItemViewType() == 1 && b.this.hpL.getItemAtPosition(i4) == x.getItem(b.this.hpN, 0)) {
                            b.this.a(tVar, b.this.hpL.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.hpU.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener hpY = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hgv != null && b.this.hgv.hgX && b.this.hgX) {
                EnterForumAdView unused = b.this.hpQ;
                EnterForumAdView.a(b.this.hpK.getUniqueId(), b.this.hpK.getContext());
            }
        }
    };
    private int hpZ = 0;
    private int hqa = 0;
    private CustomMessageListener hqb = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bWH();
        }
    };
    boolean hgX = false;
    boolean hqc = false;
    private Runnable hqd = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.bWP();
        }
    };
    private boolean hqg = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bWF() {
        if (bWG()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.hgv != null && this.hgv.hgX) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean bWG() {
        return this.hpL == null || this.hpL.getChildCount() == 0 || this.hpL.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.hpK = enterForumFragment;
        this.hja = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.hnB = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.hpW = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.hgq = viewEventCenter;
        bY(view);
        this.hpM = new com.baidu.tieba.enterForum.a.a(this.hpK.getPageContext(), this.hgq, recentlyVisitedForumModel, enterForumModel, this);
        this.hpL.setAdapter((ListAdapter) this.hpM);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.hpR = new GuidePopupWindow(this.hpK.getFragmentActivity());
    }

    private void registerListener() {
        this.hpK.registerListener(this.hqb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWH() {
        if (bWI() && this.hqh) {
            this.hpR.dtK();
            this.hpR.dtJ();
            this.hpR.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.hpR, this.hpK.getFragmentActivity());
        }
    }

    private boolean bWI() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void bY(View view) {
        this.mContext = view.getContext();
        this.hpU = new e();
        this.hpU.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.hqg) {
                    b.this.hpZ = -i;
                    if (b.this.hgX) {
                        b.this.bWP();
                    } else if (b.this.hgv != null && b.this.hgv.hgX) {
                        b.this.bWJ();
                    }
                }
            }
        });
        this.hpL = (BdListView) view.findViewById(R.id.listview);
        tY(0);
        this.hpL.setBackgroundColor(0);
        this.hpL.setVerticalScrollBarEnabled(false);
        this.hpL.setOnScrollListener(this.mOnScrollListener);
        this.hpL.setFastScrollEnabled(false);
        this.hpL.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.hpK.bVf() != null) {
            this.hpK.bVf().a(this);
        }
        this.mPullView = new g(this.hpK.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.hqa = i3;
                if (!b.this.hgX && b.this.hgv != null && b.this.hgv.hgX && !b.this.hqg) {
                    b.this.bWJ();
                    if (i3 > b.this.hpW) {
                        b.this.hqa = 0;
                        b.this.cb(b.this.hpK.bVf().getRootView());
                    }
                }
            }
        });
        this.mPullView.hY(true);
        this.mPullView.setListPullRefreshListener(this.fBc);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.hpK.getUniqueId());
        }
        this.hpL.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.hpK.getPageContext().getPageActivity());
        this.fNZ = new View(this.hpK.getPageContext().getPageActivity());
        frameLayout.addView(this.fNZ, new FrameLayout.LayoutParams(-1, this.hnB));
        this.hpL.getAdapter2().addHeaderView(frameLayout, 0);
        this.bkz = new View(this.hpK.getActivity());
        this.bkz.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.hpK.getActivity(), R.dimen.ds50)));
        this.bkz.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.hpY);
        this.mPullView.getView().setOnClickListener(this.hpY);
        this.fNZ.setOnClickListener(this.hpY);
        bWT();
    }

    public void bZ(View view) {
        this.hpQ = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.hpQ != null) {
            bWJ();
            this.hpQ.setTag(this.hpK.getUniqueId());
            this.hpQ.setAdData();
            this.hpQ.setEventCenter(this.hgq);
            this.hpQ.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWJ() {
        if (!this.hqg && this.hpQ != null) {
            ViewGroup.LayoutParams layoutParams = this.hpQ.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bWK = bWK();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.hgX ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hpZ + this.hqa) - bWK, 0, 0);
                this.hpQ.setLayoutParams(layoutParams2);
                this.hpQ.setAdViewHeight(layoutParams2.height - bWK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bWK() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bWL() {
        return this.hgX ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hpZ + this.hqa) - bWK();
    }

    private int bWM() {
        ViewGroup.LayoutParams layoutParams = this.hpQ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bWN() {
        if (!this.hqg) {
            this.hgX = true;
            bWJ();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.hpQ != null) {
                if (!this.hpQ.bWC()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.hpQ.bWB()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            tY(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hqd);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.hqd, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tY(int i) {
        if (!this.hqg) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hpL.getLayoutParams();
            marginLayoutParams.topMargin = ((this.hja + i) - this.hnB) - (EnterForumDelegateStatic.hhT.bVJ() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.hpL.setLayoutParams(marginLayoutParams);
        }
    }

    private int bWO() {
        return (this.hja - this.hnB) - (EnterForumDelegateStatic.hhT.bVJ() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWP() {
        this.hgX = false;
        bWJ();
        tY(0);
        if (this.hqc) {
            this.hpL.completePullRefreshPostDelayed(0L);
        }
        this.hqc = false;
    }

    public void ca(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.hpK.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.hpK.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.hpL.setVisibility(8);
        if (this.hpK.bVf() != null) {
            this.hpK.bVf().bVt();
            this.hpK.bVf().bVu();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.hpL.setVisibility(0);
        if (this.hpK.bVf() != null) {
            this.hpK.bVf().bVt();
            this.hpK.bVf().bVu();
        }
    }

    public boolean isEmpty() {
        return x.isEmpty(this.hpN);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.hpN.remove(fVar);
        a(this.hpN, this.hpO, z);
        nj(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bWQ() {
        return this.hpL;
    }

    public void startPullRefresh() {
        this.hpL.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.hgX) {
            this.hqc = true;
            return;
        }
        this.hqc = false;
        this.hpL.completePullRefreshPostDelayed(0L);
    }

    public void nj(boolean z) {
        this.hpM.notifyDataSetChanged();
        if (this.bkz != null && this.bkz.getLayoutParams() != null) {
            if (z) {
                this.bkz.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bkz.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bi biVar, boolean z) {
        this.hpQ.setAdData();
        EnterForumDelegateStatic.hhT.eM(this.mContext);
        this.hpN = list;
        this.hpO = biVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !x.isEmpty(list);
        boolean z3 = !x.isEmpty(list);
        t tVar = new t();
        tVar.kK(4);
        arrayList.add(tVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(biVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                t tVar2 = new t();
                tVar2.kK(11);
                arrayList.add(tVar2);
            } else {
                t tVar3 = new t();
                tVar3.kK(3);
                arrayList.add(tVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bj(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(biVar.aVr());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            t tVar4 = new t();
            tVar4.kK(5);
            arrayList.add(tVar4);
        }
        hideNoDataView();
        this.hpM.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.hpL.removeFooterView(this.bkz);
            this.hpL.addFooterView(this.bkz);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.hpL.removeFooterView(this.bkz);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.hpR != null) {
            this.hpR.onChangeSkinType();
        }
        ao.setBackgroundResource(this.bkz, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.hpX = cVar;
    }

    public void bWR() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.hpK != null && this.hpK.getActivity() != null && this.hpK.bVe() != null) {
            if (this.hpP == null) {
                this.hpP = new CommonTipView(this.hpK.getActivity());
            }
            this.hpP.setText(R.string.enter_forum_login_tip);
            this.hpP.c(this.hpK.bVe(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.hpK.isAdded() && this.hpK.isPrimary()) {
            hpS = false;
            if (this.hpM != null) {
                this.hpM.onPrimary();
                if (this.hpL != null) {
                    Object itemAtPosition = this.hpL.getItemAtPosition(this.hpL.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof t) && ((t) itemAtPosition).getItemViewType() == 5) {
                        this.hpM.bUh();
                    }
                }
            }
            if (this.hqg) {
                this.hpQ.requestFocus();
                this.hpQ.requestFocusFromTouch();
                return;
            }
            return;
        }
        bWS();
    }

    public void onPause() {
        bWS();
    }

    public void onDestroy() {
        if (this.hpP != null) {
            this.hpP.onDestroy();
        }
        if (this.hpM != null) {
            this.hpM.onDestroy();
        }
    }

    public void tD(int i) {
        this.hpM.tD(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hpM != null) {
            this.hpM.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bUg() {
        if (this.hpM == null) {
            return false;
        }
        return this.hpM.bUg();
    }

    public void a(t tVar, View view) {
        if (TbadkCoreApplication.isLogin() && !hpS && this.hpK.getActivity() != null && this.hpK.getPageContext() != null && (tVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) tVar;
            if (fVar.isPrivateForum() != 0 && fVar.bUz() != 0 && !com.baidu.tbadk.core.sharedPref.b.aZP().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.hpT = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aZP().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.hpT = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                hpS = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ah(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.hpT);
                        b.this.hpK.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.hcJ = dVar.kE();
                this.hcJ.setShouldCheckLocInWindow(false);
                this.hcJ.setUseDirectOffset(true);
                this.hcJ.show(this.hpK.getActivity());
                if (this.hpT == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.hpT == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.hcJ != null) {
                            b.this.hcJ.dismiss();
                            b.this.hcJ = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bWS() {
        if (this.hcJ != null) {
            this.hcJ.dismiss();
            this.hcJ = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hgv = cVar;
        if (this.hpM != null) {
            this.hpM.setAdState(cVar);
        }
        if (cVar != null && cVar.hgX) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.mL(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.mL(R.raw.lottie_common_pull_refresh);
    }

    public void nk(boolean z) {
        if (this.hpV != z) {
            this.hpV = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hpL.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.hpL.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.hpL.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.hpL.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.hpQ != null) {
            this.hpQ.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.hpQ != null) {
            this.hpQ.setRecentlyIsShow(z);
        }
    }

    private void bWT() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.hqe = new View(this.mContext);
        this.hqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.hpK.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.hqe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float hqk = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hqf = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.hqf <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hqf) {
                            b.this.bWU();
                            if (this.hqk < 50.0f) {
                                b.this.hqe.performClick();
                            }
                        } else {
                            b.this.bWV();
                        }
                        b.this.hqf = 0.0f;
                        this.hqk = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.hqf) {
                            b.this.ah(motionEvent.getRawY() - b.this.hqf);
                            if (b.this.ewZ != null) {
                                b.this.ewZ.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.hqf) > this.hqk) {
                            this.hqk = Math.abs(motionEvent.getRawY() - b.this.hqf);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.hqf <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hqf) {
                            b.this.bWU();
                        } else {
                            b.this.bWV();
                        }
                        b.this.hqf = 0.0f;
                        this.hqk = 0.0f;
                        return true;
                }
            }
        });
        this.ewZ = new ImageView(this.mContext);
        this.ewZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bWV();
            }
        });
    }

    public void cb(final View view) {
        if ((view instanceof FrameLayout) && !this.hqg) {
            this.mPullView.pause();
            this.hqg = true;
            this.hpQ.getAdImageView().getLocationInWindow(new int[2]);
            ao.setImageResource(this.ewZ, R.drawable.icon_jinba_retract_n);
            final int bWM = bWM();
            ValueAnimator ofInt = ValueAnimator.ofInt(bWM, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.hpQ != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hpQ.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bWK();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.hpQ.setLayoutParams(marginLayoutParams);
                            if (intValue / bWM < 0.2d) {
                                if (b.this.hpQ.getParent() != b.this.hpQ.getRootView() && (viewGroup = (ViewGroup) b.this.hpQ.getRootView()) != null) {
                                    ((ViewGroup) b.this.hpQ.getParent()).removeView(b.this.hpQ);
                                    if (b.this.hpQ.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.hpQ, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.hqe);
                                    viewGroup.bringChildToFront(b.this.ewZ);
                                }
                            } else if (b.this.hpQ.getParent() == b.this.hpQ.getRootView()) {
                                if (b.this.hpQ.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.hpQ.getRootView();
                                    ((ViewGroup) b.this.hpQ.getParent()).removeView(b.this.hpQ);
                                }
                                if (b.this.hpQ.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.hpK.bVi().addView(b.this.hpQ, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.hqg = false;
                    b.this.tY(((intValue - bWM) * 2) + 0);
                    b.this.hqg = true;
                    float abs = Math.abs(intValue / bWM);
                    b.this.hpL.setAlpha(abs);
                    View bVw = b.this.hpK.bVf().bVw();
                    if (bVw != null) {
                        bVw.setAlpha(abs);
                    }
                    View findViewById = b.this.hpK.bVi().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.hpQ != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hpQ.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bWK();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.hpQ.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.hpL.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.hqg = false;
                    b.this.tY(0 - (bWM * 2));
                    b.this.hqg = true;
                    b.this.hpL.setVisibility(8);
                    b.this.hqe.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.hqe.getParent() == null) {
                        frameLayout.addView(b.this.hqe, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.ewZ.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.ewZ, layoutParams3);
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
            this.hpQ.requestFocus();
            this.hpQ.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(float f) {
        ViewGroup viewGroup;
        int bWL = bWL();
        float abs = Math.abs(bWL / (bWO() - bWL));
        int i = (int) f;
        if (this.hpQ != null) {
            ViewGroup.LayoutParams layoutParams = this.hpQ.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bWK();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.hpQ.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.hpQ.getParent() != this.hpQ.getRootView() && (viewGroup = (ViewGroup) this.hpQ.getRootView()) != null) {
                        ((ViewGroup) this.hpQ.getParent()).removeView(this.hpQ);
                        if (this.hpQ.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.hpQ, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.hqe);
                        viewGroup.bringChildToFront(this.ewZ);
                    }
                } else if (this.hpQ.getParent() == this.hpQ.getRootView()) {
                    if (this.hpQ.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.hpQ.getRootView();
                        ((ViewGroup) this.hpQ.getParent()).removeView(this.hpQ);
                    }
                    if (this.hpQ.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.hpK.bVi().addView(this.hpQ, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.hpL.setVisibility(0);
        this.hqg = false;
        tY(((int) ((i * abs) - (bWL * abs))) * 2);
        this.hqg = true;
        float abs2 = Math.abs(i / bWL);
        this.hpL.setAlpha(abs2);
        View bVw = this.hpK.bVf().bVw();
        if (bVw != null) {
            bVw.setAlpha(abs2);
        }
        View findViewById = this.hpK.bVi().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWU() {
        if (this.ewZ != null) {
            this.ewZ.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bWM(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ah(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ah(0.0f);
                b.this.mPullView.resume();
                b.this.hpL.completePullRefresh();
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
    public void bWV() {
        this.hqe.setEnabled(false);
        int bWL = bWL();
        Math.abs(bWL / (bWO() - bWL));
        this.ewZ.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.hpQ.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bWM(), bWL);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ah(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.hqe.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.hqe);
                        viewGroup.removeView(b.this.ewZ);
                    }
                    b.this.ewZ.setVisibility(0);
                    b.this.hqg = false;
                    b.this.bWJ();
                    b.this.hqa = 0;
                    b.this.tY(0);
                    b.this.hqg = true;
                    b.this.mPullView.resume();
                    b.this.hpL.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hqg = false;
                        }
                    }, 0L);
                    b.this.hpL.setVisibility(0);
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
        if (this.hqg) {
            bWV();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.bUT())) {
                this.hqh = false;
            } else {
                this.hqh = true;
            }
            this.hpR.setForumId(aVar.bUR());
            this.hpR.J(aVar.bUQ(), aVar.bUS());
            this.hpR.fm(aVar.bUP());
            this.hpR.wS(aVar.bUT());
        }
    }
}
