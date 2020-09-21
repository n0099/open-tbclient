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
/* loaded from: classes21.dex */
public class b implements EnterForumAdView.a {
    private static boolean hJR = false;
    private View btr;
    private ImageView eJL;
    private View gdp;
    private ViewEventCenter hAu;
    private com.baidu.tieba.enterForum.data.c hAz;
    private int hDi;
    private int hHA;
    private final EnterForumFragment hJJ;
    private BdListView hJK;
    private com.baidu.tieba.enterForum.a.a hJL;
    private List<com.baidu.tieba.enterForum.data.f> hJM;
    private bj hJN;
    private CommonTipView hJO;
    private EnterForumAdView hJP;
    private GuidePopupWindow hJQ;
    private int hJS;
    private e hJT;
    private int hJV;
    private f.c hJW;
    private View hKd;
    private float hKe;
    private boolean hKg;
    private com.baidu.adp.lib.guide.c hwI;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean hJU = true;
    private f.c fPM = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.hKf) {
                com.baidu.tieba.s.c.dzC().C(b.this.hJJ.getUniqueId());
                if (b.this.hJW != null) {
                    b.this.hJW.onListPullRefresh(z);
                }
                if (z && !b.this.hBb && b.this.hAz != null && b.this.hAz.hBb) {
                    if (b.this.hAz.hBd > 0) {
                        b.this.hJK.smoothScrollToPosition(0, 0, 0);
                        b.this.ckq();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hJK.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int fJF = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.hJT.onScrollStateChanged(absListView, i);
            if (this.fJF != i) {
                this.fJF = i;
                if (this.fJF == 1) {
                    if (b.this.hAz == null || !b.this.hAz.hBb) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.ckv();
                    return;
                }
                b.this.cki();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.hJJ.isPrimary() && this.fJF != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.hJK.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof u)) {
                        u uVar = (u) itemAtPosition;
                        if (uVar.getItemViewType() == 1 && b.this.hJK.getItemAtPosition(i4) == y.getItem(b.this.hJM, 0)) {
                            b.this.a(uVar, b.this.hJK.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.hJT.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener hJX = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.hAz != null && b.this.hAz.hBb && b.this.hBb) {
                EnterForumAdView unused = b.this.hJP;
                EnterForumAdView.a(b.this.hJJ.getUniqueId(), b.this.hJJ.getContext());
            }
        }
    };
    private int hJY = 0;
    private int hJZ = 0;
    private CustomMessageListener hKa = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ckk();
        }
    };
    boolean hBb = false;
    boolean hKb = false;
    private Runnable hKc = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cks();
        }
    };
    private boolean hKf = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cki() {
        if (ckj()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.hAz != null && this.hAz.hBb) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean ckj() {
        return this.hJK == null || this.hJK.getChildCount() == 0 || this.hJK.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.hJJ = enterForumFragment;
        this.hDi = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.hHA = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.hJV = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.hAu = viewEventCenter;
        cj(view);
        this.hJL = new com.baidu.tieba.enterForum.a.a(this.hJJ.getPageContext(), this.hAu, recentlyVisitedForumModel, enterForumModel, this);
        this.hJK.setAdapter((ListAdapter) this.hJL);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.hJQ = new GuidePopupWindow(this.hJJ.getFragmentActivity());
    }

    private void registerListener() {
        this.hJJ.registerListener(this.hKa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckk() {
        if (ckl() && this.hKg) {
            this.hJQ.dJi();
            this.hJQ.dJh();
            this.hJQ.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.hJQ, this.hJJ.getFragmentActivity());
        }
    }

    private boolean ckl() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cj(View view) {
        this.mContext = view.getContext();
        this.hJT = new e();
        this.hJT.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.hKf) {
                    b.this.hJY = -i;
                    if (b.this.hBb) {
                        b.this.cks();
                    } else if (b.this.hAz != null && b.this.hAz.hBb) {
                        b.this.ckm();
                    }
                }
            }
        });
        this.hJK = (BdListView) view.findViewById(R.id.listview);
        wM(0);
        this.hJK.setBackgroundColor(0);
        this.hJK.setVerticalScrollBarEnabled(false);
        this.hJK.setOnScrollListener(this.mOnScrollListener);
        this.hJK.setFastScrollEnabled(false);
        this.hJK.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.hJJ.ciO() != null) {
            this.hJJ.ciO().a(this);
        }
        this.mPullView = new g(this.hJJ.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.hJZ = i3;
                if (!b.this.hBb && b.this.hAz != null && b.this.hAz.hBb && !b.this.hKf) {
                    b.this.ckm();
                    if (i3 > b.this.hJV) {
                        b.this.hJZ = 0;
                        b.this.cm(b.this.hJJ.ciO().getRootView());
                    }
                }
            }
        });
        this.mPullView.it(true);
        this.mPullView.setListPullRefreshListener(this.fPM);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.hJJ.getUniqueId());
        }
        this.hJK.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.hJJ.getPageContext().getPageActivity());
        this.gdp = new View(this.hJJ.getPageContext().getPageActivity());
        frameLayout.addView(this.gdp, new FrameLayout.LayoutParams(-1, this.hHA));
        this.hJK.getAdapter2().addHeaderView(frameLayout, 0);
        this.btr = new View(this.hJJ.getActivity());
        this.btr.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.hJJ.getActivity(), R.dimen.ds50)));
        this.btr.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.hJX);
        this.mPullView.getView().setOnClickListener(this.hJX);
        this.gdp.setOnClickListener(this.hJX);
        ckw();
    }

    public void ck(View view) {
        this.hJP = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.hJP != null) {
            ckm();
            this.hJP.setTag(this.hJJ.getUniqueId());
            this.hJP.setAdData();
            this.hJP.setEventCenter(this.hAu);
            this.hJP.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckm() {
        if (!this.hKf && this.hJP != null) {
            ViewGroup.LayoutParams layoutParams = this.hJP.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int ckn = ckn();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.hBb ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hJY + this.hJZ) - ckn, 0, 0);
                this.hJP.setLayoutParams(layoutParams2);
                this.hJP.setAdViewHeight(layoutParams2.height - ckn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ckn() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cko() {
        return this.hBb ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hJY + this.hJZ) - ckn();
    }

    private int ckp() {
        ViewGroup.LayoutParams layoutParams = this.hJP.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void ckq() {
        if (!this.hKf) {
            this.hBb = true;
            ckm();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.hJP != null) {
                if (!this.hJP.ckf()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.hJP.cke()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            wM(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.hKc);
            com.baidu.adp.lib.f.e.mX().postDelayed(this.hKc, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(int i) {
        if (!this.hKf) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hJK.getLayoutParams();
            marginLayoutParams.topMargin = ((this.hDi + i) - this.hHA) - (EnterForumDelegateStatic.hCe.cjo() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.hJK.setLayoutParams(marginLayoutParams);
        }
    }

    private int ckr() {
        return (this.hDi - this.hHA) - (EnterForumDelegateStatic.hCe.cjo() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cks() {
        this.hBb = false;
        ckm();
        wM(0);
        if (this.hKb) {
            this.hJK.completePullRefreshPostDelayed(0L);
        }
        this.hKb = false;
    }

    public void cl(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.hJJ.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.hJJ.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.hJK.setVisibility(8);
        if (this.hJJ.ciO() != null) {
            this.hJJ.ciO().cjc();
            this.hJJ.ciO().cjd();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.hJK.setVisibility(0);
        if (this.hJJ.ciO() != null) {
            this.hJJ.ciO().cjc();
            this.hJJ.ciO().cjd();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.hJM);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.hJM.remove(fVar);
        a(this.hJM, this.hJN, z);
        nV(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView ckt() {
        return this.hJK;
    }

    public void startPullRefresh() {
        this.hJK.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.hBb) {
            this.hKb = true;
            return;
        }
        this.hKb = false;
        this.hJK.completePullRefreshPostDelayed(0L);
    }

    public void nV(boolean z) {
        this.hJL.notifyDataSetChanged();
        if (this.btr != null && this.btr.getLayoutParams() != null) {
            if (z) {
                this.btr.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.btr.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar, boolean z) {
        this.hJP.setAdData();
        EnterForumDelegateStatic.hCe.fc(this.mContext);
        this.hJM = list;
        this.hJN = bjVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        u uVar = new u();
        uVar.nb(4);
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
                uVar2.nb(11);
                arrayList.add(uVar2);
            } else {
                u uVar3 = new u();
                uVar3.nb(3);
                arrayList.add(uVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bk(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bjVar.beE());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            u uVar4 = new u();
            uVar4.nb(5);
            arrayList.add(uVar4);
        }
        hideNoDataView();
        this.hJL.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.hJK.removeFooterView(this.btr);
            this.hJK.addFooterView(this.btr);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.hJK.removeFooterView(this.btr);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.hJQ != null) {
            this.hJQ.onChangeSkinType();
        }
        ap.setBackgroundResource(this.btr, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.hJW = cVar;
    }

    public void cku() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.hJJ != null && this.hJJ.getActivity() != null && this.hJJ.ciN() != null) {
            if (this.hJO == null) {
                this.hJO = new CommonTipView(this.hJJ.getActivity());
            }
            this.hJO.setText(R.string.enter_forum_login_tip);
            this.hJO.c(this.hJJ.ciN(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.hJJ.isAdded() && this.hJJ.isPrimary()) {
            hJR = false;
            if (this.hJL != null) {
                this.hJL.onPrimary();
                if (this.hJK != null) {
                    Object itemAtPosition = this.hJK.getItemAtPosition(this.hJK.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof u) && ((u) itemAtPosition).getItemViewType() == 5) {
                        this.hJL.chJ();
                    }
                }
            }
            if (this.hKf) {
                this.hJP.requestFocus();
                this.hJP.requestFocusFromTouch();
                return;
            }
            return;
        }
        ckv();
    }

    public void onPause() {
        ckv();
    }

    public void onDestroy() {
        if (this.hJO != null) {
            this.hJO.onDestroy();
        }
        if (this.hJL != null) {
            this.hJL.onDestroy();
        }
    }

    public void wr(int i) {
        this.hJL.wr(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hJL != null) {
            this.hJL.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean chI() {
        if (this.hJL == null) {
            return false;
        }
        return this.hJL.chI();
    }

    public void a(u uVar, View view) {
        if (TbadkCoreApplication.isLogin() && !hJR && this.hJJ.getActivity() != null && this.hJJ.getPageContext() != null && (uVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
            if (fVar.isPrivateForum() != 0 && fVar.cia() != 0 && !com.baidu.tbadk.core.sharedPref.b.bjf().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.hJS = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bjf().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.hJS = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                hJR = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.hJS);
                        b.this.hJJ.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.hwI = dVar.mh();
                this.hwI.setShouldCheckLocInWindow(false);
                this.hwI.setUseDirectOffset(true);
                this.hwI.show(this.hJJ.getActivity());
                if (this.hJS == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.hJS == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.hwI != null) {
                            b.this.hwI.dismiss();
                            b.this.hwI = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void ckv() {
        if (this.hwI != null) {
            this.hwI.dismiss();
            this.hwI = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.hAz = cVar;
        if (this.hJL != null) {
            this.hJL.setAdState(cVar);
        }
        if (cVar != null && cVar.hBb) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.pc(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.pc(R.raw.lottie_common_pull_refresh);
    }

    public void nW(boolean z) {
        if (this.hJU != z) {
            this.hJU = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hJK.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.hJK.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.hJK.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.hJK.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.hJP != null) {
            this.hJP.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.hJP != null) {
            this.hJP.setRecentlyIsShow(z);
        }
    }

    private void ckw() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.hKd = new View(this.mContext);
        this.hKd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.hJJ.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.hKd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float hKj = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hKe = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.hKe <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hKe) {
                            b.this.ckx();
                            if (this.hKj < 50.0f) {
                                b.this.hKd.performClick();
                            }
                        } else {
                            b.this.cky();
                        }
                        b.this.hKe = 0.0f;
                        this.hKj = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.hKe) {
                            b.this.an(motionEvent.getRawY() - b.this.hKe);
                            if (b.this.eJL != null) {
                                b.this.eJL.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.hKe) > this.hKj) {
                            this.hKj = Math.abs(motionEvent.getRawY() - b.this.hKe);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.hKe <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hKe) {
                            b.this.ckx();
                        } else {
                            b.this.cky();
                        }
                        b.this.hKe = 0.0f;
                        this.hKj = 0.0f;
                        return true;
                }
            }
        });
        this.eJL = new ImageView(this.mContext);
        this.eJL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cky();
            }
        });
    }

    public void cm(final View view) {
        if ((view instanceof FrameLayout) && !this.hKf) {
            this.mPullView.pause();
            this.hKf = true;
            this.hJP.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.eJL, R.drawable.icon_jinba_retract_n);
            final int ckp = ckp();
            ValueAnimator ofInt = ValueAnimator.ofInt(ckp, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.hJP != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hJP.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.ckn();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.hJP.setLayoutParams(marginLayoutParams);
                            if (intValue / ckp < 0.2d) {
                                if (b.this.hJP.getParent() != b.this.hJP.getRootView() && (viewGroup = (ViewGroup) b.this.hJP.getRootView()) != null) {
                                    ((ViewGroup) b.this.hJP.getParent()).removeView(b.this.hJP);
                                    if (b.this.hJP.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.hJP, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.hKd);
                                    viewGroup.bringChildToFront(b.this.eJL);
                                }
                            } else if (b.this.hJP.getParent() == b.this.hJP.getRootView()) {
                                if (b.this.hJP.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.hJP.getRootView();
                                    ((ViewGroup) b.this.hJP.getParent()).removeView(b.this.hJP);
                                }
                                if (b.this.hJP.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.hJJ.ciR().addView(b.this.hJP, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.hKf = false;
                    b.this.wM(((intValue - ckp) * 2) + 0);
                    b.this.hKf = true;
                    float abs = Math.abs(intValue / ckp);
                    b.this.hJK.setAlpha(abs);
                    View cjf = b.this.hJJ.ciO().cjf();
                    if (cjf != null) {
                        cjf.setAlpha(abs);
                    }
                    View findViewById = b.this.hJJ.ciR().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.hJP != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hJP.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.ckn();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.hJP.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.hJK.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.hKf = false;
                    b.this.wM(0 - (ckp * 2));
                    b.this.hKf = true;
                    b.this.hJK.setVisibility(8);
                    b.this.hKd.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.hKd.getParent() == null) {
                        frameLayout.addView(b.this.hKd, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.eJL.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.eJL, layoutParams3);
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
            this.hJP.requestFocus();
            this.hJP.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(float f) {
        ViewGroup viewGroup;
        int cko = cko();
        float abs = Math.abs(cko / (ckr() - cko));
        int i = (int) f;
        if (this.hJP != null) {
            ViewGroup.LayoutParams layoutParams = this.hJP.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ckn();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.hJP.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.hJP.getParent() != this.hJP.getRootView() && (viewGroup = (ViewGroup) this.hJP.getRootView()) != null) {
                        ((ViewGroup) this.hJP.getParent()).removeView(this.hJP);
                        if (this.hJP.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.hJP, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.hKd);
                        viewGroup.bringChildToFront(this.eJL);
                    }
                } else if (this.hJP.getParent() == this.hJP.getRootView()) {
                    if (this.hJP.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.hJP.getRootView();
                        ((ViewGroup) this.hJP.getParent()).removeView(this.hJP);
                    }
                    if (this.hJP.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.hJJ.ciR().addView(this.hJP, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.hJK.setVisibility(0);
        this.hKf = false;
        wM(((int) ((i * abs) - (cko * abs))) * 2);
        this.hKf = true;
        float abs2 = Math.abs(i / cko);
        this.hJK.setAlpha(abs2);
        View cjf = this.hJJ.ciO().cjf();
        if (cjf != null) {
            cjf.setAlpha(abs2);
        }
        View findViewById = this.hJJ.ciR().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckx() {
        if (this.eJL != null) {
            this.eJL.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(ckp(), 0);
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
                b.this.hJK.completePullRefresh();
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
    public void cky() {
        this.hKd.setEnabled(false);
        int cko = cko();
        Math.abs(cko / (ckr() - cko));
        this.eJL.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.hJP.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(ckp(), cko);
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
    /* loaded from: classes21.dex */
    public class AnonymousClass13 implements Animator.AnimatorListener {
        AnonymousClass13() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.hKd.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.hKd);
                        viewGroup.removeView(b.this.eJL);
                    }
                    b.this.eJL.setVisibility(0);
                    b.this.hKf = false;
                    b.this.ckm();
                    b.this.hJZ = 0;
                    b.this.wM(0);
                    b.this.hKf = true;
                    b.this.mPullView.resume();
                    b.this.hJK.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hKf = false;
                        }
                    }, 0L);
                    b.this.hJK.setVisibility(0);
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
        if (this.hKf) {
            cky();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cir())) {
                this.hKg = false;
            } else {
                this.hKg = true;
            }
            this.hJQ.setForumId(aVar.cip());
            this.hJQ.G(aVar.cio(), aVar.ciq());
            this.hJQ.fD(aVar.cin());
            this.hJQ.zC(aVar.cir());
        }
    }
}
