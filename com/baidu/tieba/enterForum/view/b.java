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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.d;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements EnterForumAdView.a {
    private static boolean hkj = false;
    private View bkf;
    private ImageView eqH;
    private View fIE;
    private com.baidu.adp.lib.guide.c gXe;
    private ViewEventCenter haL;
    private com.baidu.tieba.enterForum.data.c haQ;
    private int hdq;
    private int hhR;
    private final EnterForumFragment hkc;
    private BdListView hkd;
    private com.baidu.tieba.enterForum.a.a hke;
    private List<com.baidu.tieba.enterForum.data.f> hkf;
    private bh hkg;
    private CommonTipView hkh;
    private EnterForumAdView hki;
    private int hkk;
    private e hkl;
    private int hkn;
    private f.c hko;
    private View hku;
    private float hkv;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean hkm = true;
    private f.c fvV = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.hkw) {
                com.baidu.tieba.s.c.dgX().C(b.this.hkc.getUniqueId());
                if (b.this.hko != null) {
                    b.this.hko.onListPullRefresh(z);
                }
                if (z && !b.this.hbs && b.this.haQ != null && b.this.haQ.hbs) {
                    if (b.this.haQ.hbu > 0) {
                        b.this.hkd.smoothScrollToPosition(0, 0, 0);
                        b.this.bTt();
                        return;
                    }
                    com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hkd.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int fpM = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.hkl.onScrollStateChanged(absListView, i);
            if (this.fpM != i) {
                this.fpM = i;
                if (this.fpM == 1) {
                    if (b.this.haQ == null || !b.this.haQ.hbs) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.bTy();
                    return;
                }
                b.this.bTn();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.hkc.isPrimary() && this.fpM != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.hkd.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof t)) {
                        t tVar = (t) itemAtPosition;
                        if (tVar.getItemViewType() == 1 && b.this.hkd.getItemAtPosition(i4) == w.getItem(b.this.hkf, 0)) {
                            b.this.a(tVar, b.this.hkd.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.hkl.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener hkp = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.13
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.haQ != null && b.this.haQ.hbs && b.this.hbs) {
                EnterForumAdView unused = b.this.hki;
                EnterForumAdView.a(b.this.hkc.getUniqueId(), b.this.hkc.getContext());
            }
        }
    };
    private int hkq = 0;
    private int hkr = 0;
    boolean hbs = false;
    boolean hks = false;
    private Runnable hkt = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // java.lang.Runnable
        public void run() {
            b.this.bTv();
        }
    };
    private boolean hkw = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bTn() {
        if (bTo()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.haQ != null && this.haQ.hbs) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean bTo() {
        return this.hkd == null || this.hkd.getChildCount() == 0 || this.hkd.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.hkc = enterForumFragment;
        this.hdq = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.hhR = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.hkn = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.haL = viewEventCenter;
        bS(view);
        this.hke = new com.baidu.tieba.enterForum.a.a(this.hkc.getPageContext(), this.haL, recentlyVisitedForumModel, enterForumModel, this);
        this.hkd.setAdapter((ListAdapter) this.hke);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bS(View view) {
        this.mContext = view.getContext();
        this.hkl = new e();
        this.hkl.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.14
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.hkw) {
                    b.this.hkq = -i;
                    if (b.this.hbs) {
                        b.this.bTv();
                    } else if (b.this.haQ != null && b.this.haQ.hbs) {
                        b.this.bTp();
                    }
                }
            }
        });
        this.hkd = (BdListView) view.findViewById(R.id.listview);
        tG(0);
        this.hkd.setBackgroundColor(0);
        this.hkd.setVerticalScrollBarEnabled(false);
        this.hkd.setOnScrollListener(this.mOnScrollListener);
        this.hkd.setFastScrollEnabled(false);
        this.hkd.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.hkc.bRN() != null) {
            this.hkc.bRN().a(this);
        }
        this.mPullView = new g(this.hkc.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.15
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.hkr = i3;
                if (!b.this.hbs && b.this.haQ != null && b.this.haQ.hbs && !b.this.hkw) {
                    b.this.bTp();
                    if (i3 > b.this.hkn) {
                        b.this.hkr = 0;
                        b.this.bV(b.this.hkc.bRN().getRootView());
                    }
                }
            }
        });
        this.mPullView.ht(true);
        this.mPullView.setListPullRefreshListener(this.fvV);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.hkc.getUniqueId());
        }
        this.hkd.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.hkc.getPageContext().getPageActivity());
        this.fIE = new View(this.hkc.getPageContext().getPageActivity());
        frameLayout.addView(this.fIE, new FrameLayout.LayoutParams(-1, this.hhR));
        this.hkd.getAdapter2().addHeaderView(frameLayout, 0);
        this.bkf = new View(this.hkc.getActivity());
        this.bkf.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.hkc.getActivity(), R.dimen.ds50)));
        this.bkf.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.hkp);
        this.mPullView.getView().setOnClickListener(this.hkp);
        this.fIE.setOnClickListener(this.hkp);
        bTz();
    }

    public void bT(View view) {
        this.hki = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.hki != null) {
            bTp();
            this.hki.setTag(this.hkc.getUniqueId());
            this.hki.setAdData();
            this.hki.setEventCenter(this.haL);
            this.hki.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTp() {
        if (!this.hkw && this.hki != null) {
            ViewGroup.LayoutParams layoutParams = this.hki.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bTq = bTq();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.hbs ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hkq + this.hkr) - bTq, 0, 0);
                this.hki.setLayoutParams(layoutParams2);
                this.hki.setAdViewHeight(layoutParams2.height - bTq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bTq() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bTr() {
        return this.hbs ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.hkq + this.hkr) - bTq();
    }

    private int bTs() {
        ViewGroup.LayoutParams layoutParams = this.hki.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bTt() {
        if (!this.hkw) {
            this.hbs = true;
            bTp();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.hki != null) {
                if (!this.hki.bTk()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.hki.bTj()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            tG(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hkt);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.hkt, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tG(int i) {
        if (!this.hkw) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hkd.getLayoutParams();
            marginLayoutParams.topMargin = ((this.hdq + i) - this.hhR) - (EnterForumDelegateStatic.hck.bSr() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.hkd.setLayoutParams(marginLayoutParams);
        }
    }

    private int bTu() {
        return (this.hdq - this.hhR) - (EnterForumDelegateStatic.hck.bSr() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTv() {
        this.hbs = false;
        bTp();
        tG(0);
        if (this.hks) {
            this.hkd.completePullRefreshPostDelayed(0L);
        }
        this.hks = false;
    }

    public void bU(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.hkc.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.hkc.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.hkd.setVisibility(8);
        if (this.hkc.bRN() != null) {
            this.hkc.bRN().bSb();
            this.hkc.bRN().bSc();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.hkd.setVisibility(0);
        if (this.hkc.bRN() != null) {
            this.hkc.bRN().bSb();
            this.hkc.bRN().bSc();
        }
    }

    public boolean isEmpty() {
        return w.isEmpty(this.hkf);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.hkf.remove(fVar);
        a(this.hkf, this.hkg, z);
        mE(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bTw() {
        return this.hkd;
    }

    public void startPullRefresh() {
        this.hkd.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.hbs) {
            this.hks = true;
            return;
        }
        this.hks = false;
        this.hkd.completePullRefreshPostDelayed(0L);
    }

    public void mE(boolean z) {
        this.hke.notifyDataSetChanged();
        if (this.bkf != null && this.bkf.getLayoutParams() != null) {
            if (z) {
                this.bkf.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bkf.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bh bhVar, boolean z) {
        this.hki.setAdData();
        EnterForumDelegateStatic.hck.eI(this.mContext);
        this.hkf = list;
        this.hkg = bhVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !w.isEmpty(list);
        boolean z3 = !w.isEmpty(list);
        t tVar = new t();
        tVar.kq(4);
        arrayList.add(tVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(bhVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                t tVar2 = new t();
                tVar2.kq(11);
                arrayList.add(tVar2);
            } else {
                t tVar3 = new t();
                tVar3.kq(3);
                arrayList.add(tVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bi(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bhVar.aRv());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            t tVar4 = new t();
            tVar4.kq(5);
            arrayList.add(tVar4);
        }
        hideNoDataView();
        this.hke.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.hkd.removeFooterView(this.bkf);
            this.hkd.addFooterView(this.bkf);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.hkd.removeFooterView(this.bkf);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        an.setBackgroundResource(this.bkf, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.hko = cVar;
    }

    public void bTx() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.hkc != null && this.hkc.getActivity() != null && this.hkc.bRM() != null) {
            if (this.hkh == null) {
                this.hkh = new CommonTipView(this.hkc.getActivity());
            }
            this.hkh.setText(R.string.enter_forum_login_tip);
            this.hkh.c(this.hkc.bRM(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.hkc.isAdded() && this.hkc.isPrimary()) {
            hkj = false;
            if (this.hke != null) {
                this.hke.onPrimary();
                if (this.hkd != null) {
                    Object itemAtPosition = this.hkd.getItemAtPosition(this.hkd.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof t) && ((t) itemAtPosition).getItemViewType() == 5) {
                        this.hke.bQV();
                    }
                }
            }
            if (this.hkw) {
                this.hki.requestFocus();
                this.hki.requestFocusFromTouch();
                return;
            }
            return;
        }
        bTy();
    }

    public void onPause() {
        bTy();
    }

    public void onDestroy() {
        if (this.hkh != null) {
            this.hkh.onDestroy();
        }
        if (this.hke != null) {
            this.hke.onDestroy();
        }
    }

    public void tl(int i) {
        this.hke.tl(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.hke != null) {
            this.hke.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bQU() {
        if (this.hke == null) {
            return false;
        }
        return this.hke.bQU();
    }

    public void a(t tVar, View view) {
        if (TbadkCoreApplication.isLogin() && !hkj && this.hkc.getActivity() != null && this.hkc.getPageContext() != null && (tVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) tVar;
            if (fVar.isPrivateForum() != 0 && fVar.bRm() != 0 && !com.baidu.tbadk.core.sharedPref.b.aVP().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.hkk = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aVP().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.hkk = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                hkj = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).af(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.18
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.hkk);
                        b.this.hkc.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                dVar.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.19
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.gXe = dVar.kE();
                this.gXe.setShouldCheckLocInWindow(false);
                this.gXe.setUseDirectOffset(true);
                this.gXe.show(this.hkc.getActivity());
                if (this.hkk == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.hkk == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.gXe != null) {
                            b.this.gXe.dismiss();
                            b.this.gXe = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bTy() {
        if (this.gXe != null) {
            this.gXe.dismiss();
            this.gXe = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.haQ = cVar;
        if (this.hke != null) {
            this.hke.setAdState(cVar);
        }
        if (cVar != null && cVar.hbs) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.ms(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.ms(R.raw.lottie_common_pull_refresh);
    }

    public void mF(boolean z) {
        if (this.hkm != z) {
            this.hkm = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.hkd.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.hkd.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.hkd.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.hkd.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.hki != null) {
            this.hki.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.hki != null) {
            this.hki.setRecentlyIsShow(z);
        }
    }

    private void bTz() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.hku = new View(this.mContext);
        this.hku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.hkc.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.hku.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            private float hkz = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hkv = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.hkv <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hkv) {
                            b.this.bTA();
                            if (this.hkz < 50.0f) {
                                b.this.hku.performClick();
                            }
                        } else {
                            b.this.bTB();
                        }
                        b.this.hkv = 0.0f;
                        this.hkz = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.hkv) {
                            b.this.ah(motionEvent.getRawY() - b.this.hkv);
                            if (b.this.eqH != null) {
                                b.this.eqH.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.hkv) > this.hkz) {
                            this.hkz = Math.abs(motionEvent.getRawY() - b.this.hkv);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.hkv <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.hkv) {
                            b.this.bTA();
                        } else {
                            b.this.bTB();
                        }
                        b.this.hkv = 0.0f;
                        this.hkz = 0.0f;
                        return true;
                }
            }
        });
        this.eqH = new ImageView(this.mContext);
        this.eqH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bTB();
            }
        });
    }

    public void bV(final View view) {
        if ((view instanceof FrameLayout) && !this.hkw) {
            this.mPullView.pause();
            this.hkw = true;
            this.hki.getAdImageView().getLocationInWindow(new int[2]);
            an.setImageResource(this.eqH, R.drawable.icon_jinba_retract_n);
            final int bTs = bTs();
            ValueAnimator ofInt = ValueAnimator.ofInt(bTs, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.hki != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hki.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bTq();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.hki.setLayoutParams(marginLayoutParams);
                            if (intValue / bTs < 0.2d) {
                                if (b.this.hki.getParent() != b.this.hki.getRootView() && (viewGroup = (ViewGroup) b.this.hki.getRootView()) != null) {
                                    ((ViewGroup) b.this.hki.getParent()).removeView(b.this.hki);
                                    if (b.this.hki.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.hki, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.hku);
                                    viewGroup.bringChildToFront(b.this.eqH);
                                }
                            } else if (b.this.hki.getParent() == b.this.hki.getRootView()) {
                                if (b.this.hki.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.hki.getRootView();
                                    ((ViewGroup) b.this.hki.getParent()).removeView(b.this.hki);
                                }
                                if (b.this.hki.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.hkc.bRQ().addView(b.this.hki, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.hkw = false;
                    b.this.tG(((intValue - bTs) * 2) + 0);
                    b.this.hkw = true;
                    float abs = Math.abs(intValue / bTs);
                    b.this.hkd.setAlpha(abs);
                    View bSe = b.this.hkc.bRN().bSe();
                    if (bSe != null) {
                        bSe.setAlpha(abs);
                    }
                    View findViewById = b.this.hkc.bRQ().getRootView().findViewById(R.id.tabcontainer_wrapper);
                    if (findViewById != null) {
                        findViewById.setAlpha(abs);
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.hki != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.hki.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bTq();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.hki.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.hkd.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.hkw = false;
                    b.this.tG(0 - (bTs * 2));
                    b.this.hkw = true;
                    b.this.hkd.setVisibility(8);
                    b.this.hku.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.hku.getParent() == null) {
                        frameLayout.addView(b.this.hku, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.eqH.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.eqH, layoutParams3);
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
            this.hki.requestFocus();
            this.hki.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(float f) {
        ViewGroup viewGroup;
        int bTr = bTr();
        float abs = Math.abs(bTr / (bTu() - bTr));
        int i = (int) f;
        if (this.hki != null) {
            ViewGroup.LayoutParams layoutParams = this.hki.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bTq();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.hki.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.hki.getParent() != this.hki.getRootView() && (viewGroup = (ViewGroup) this.hki.getRootView()) != null) {
                        ((ViewGroup) this.hki.getParent()).removeView(this.hki);
                        if (this.hki.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.hki, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.hku);
                        viewGroup.bringChildToFront(this.eqH);
                    }
                } else if (this.hki.getParent() == this.hki.getRootView()) {
                    if (this.hki.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.hki.getRootView();
                        ((ViewGroup) this.hki.getParent()).removeView(this.hki);
                    }
                    if (this.hki.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.hkc.bRQ().addView(this.hki, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.hkd.setVisibility(0);
        this.hkw = false;
        tG(((int) ((i * abs) - (bTr * abs))) * 2);
        this.hkw = true;
        float abs2 = Math.abs(i / bTr);
        this.hkd.setAlpha(abs2);
        View bSe = this.hkc.bRN().bSe();
        if (bSe != null) {
            bSe.setAlpha(abs2);
        }
        View findViewById = this.hkc.bRQ().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTA() {
        if (this.eqH != null) {
            this.eqH.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bTs(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ah(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ah(0.0f);
                b.this.mPullView.resume();
                b.this.hkd.completePullRefresh();
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
    public void bTB() {
        this.hku.setEnabled(false);
        int bTr = bTr();
        Math.abs(bTr / (bTu() - bTr));
        this.eqH.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.hki.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bTs(), bTr);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ah(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass11());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$11  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass11 implements Animator.AnimatorListener {
        AnonymousClass11() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.11.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.hku.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.hku);
                        viewGroup.removeView(b.this.eqH);
                    }
                    b.this.eqH.setVisibility(0);
                    b.this.hkw = false;
                    b.this.bTp();
                    b.this.hkr = 0;
                    b.this.tG(0);
                    b.this.hkw = true;
                    b.this.mPullView.resume();
                    b.this.hkd.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.11.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.hkw = false;
                        }
                    }, 0L);
                    b.this.hkd.setVisibility(0);
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
        if (this.hkw) {
            bTB();
        }
    }
}
