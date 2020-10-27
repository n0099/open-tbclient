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
    private static boolean ilm = false;
    private View bzs;
    private ImageView feo;
    private View gzK;
    private com.baidu.adp.lib.guide.c hYa;
    private ViewEventCenter ibM;
    private com.baidu.tieba.enterForum.data.c ibR;
    private int ieF;
    private int iiV;
    private boolean ilB;
    private final EnterForumFragment ile;
    private BdListView ilf;
    private com.baidu.tieba.enterForum.a.a ilg;
    private List<com.baidu.tieba.enterForum.data.f> ilh;
    private bj ili;
    private CommonTipView ilj;
    private EnterForumAdView ilk;
    private GuidePopupWindow ill;
    private int iln;
    private e ilo;
    private int ilq;
    private f.c ilr;
    private View ily;
    private float ilz;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean ilp = true;
    private f.c gmi = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.ilA) {
                com.baidu.tieba.s.c.dGv().C(b.this.ile.getUniqueId());
                if (b.this.ilr != null) {
                    b.this.ilr.onListPullRefresh(z);
                }
                if (z && !b.this.ict && b.this.ibR != null && b.this.ibR.ict) {
                    if (b.this.ibR.icv > 0) {
                        b.this.ilf.smoothScrollToPosition(0, 0, 0);
                        b.this.cqT();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ilf.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int gga = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.ilo.onScrollStateChanged(absListView, i);
            if (this.gga != i) {
                this.gga = i;
                if (this.gga == 1) {
                    if (b.this.ibR == null || !b.this.ibR.ict) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.cqY();
                    return;
                }
                b.this.cqL();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.ile.isPrimary() && this.gga != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.ilf.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof u)) {
                        u uVar = (u) itemAtPosition;
                        if (uVar.getItemViewType() == 1 && b.this.ilf.getItemAtPosition(i4) == y.getItem(b.this.ilh, 0)) {
                            b.this.a(uVar, b.this.ilf.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.ilo.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener ils = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.ibR != null && b.this.ibR.ict && b.this.ict) {
                EnterForumAdView unused = b.this.ilk;
                EnterForumAdView.a(b.this.ile.getUniqueId(), b.this.ile.getContext());
            }
        }
    };
    private int ilt = 0;
    private int ilu = 0;
    private CustomMessageListener ilv = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cqN();
        }
    };
    boolean ict = false;
    boolean ilw = false;
    private Runnable ilx = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.cqV();
        }
    };
    private boolean ilA = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void cqL() {
        if (cqM()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.ibR != null && this.ibR.ict) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean cqM() {
        return this.ilf == null || this.ilf.getChildCount() == 0 || this.ilf.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.ile = enterForumFragment;
        this.ieF = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.iiV = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.ilq = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.ibM = viewEventCenter;
        cr(view);
        this.ilg = new com.baidu.tieba.enterForum.a.a(this.ile.getPageContext(), this.ibM, recentlyVisitedForumModel, enterForumModel, this);
        this.ilf.setAdapter((ListAdapter) this.ilg);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.ill = new GuidePopupWindow(this.ile.getFragmentActivity());
    }

    private void registerListener() {
        this.ile.registerListener(this.ilv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqN() {
        if (cqO() && this.ilB) {
            this.ill.dQc();
            this.ill.dQb();
            this.ill.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.ill, this.ile.getFragmentActivity());
        }
    }

    private boolean cqO() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cr(View view) {
        this.mContext = view.getContext();
        this.ilo = new e();
        this.ilo.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.ilA) {
                    b.this.ilt = -i;
                    if (b.this.ict) {
                        b.this.cqV();
                    } else if (b.this.ibR != null && b.this.ibR.ict) {
                        b.this.cqP();
                    }
                }
            }
        });
        this.ilf = (BdListView) view.findViewById(R.id.listview);
        xL(0);
        this.ilf.setBackgroundColor(0);
        this.ilf.setVerticalScrollBarEnabled(false);
        this.ilf.setOnScrollListener(this.mOnScrollListener);
        this.ilf.setFastScrollEnabled(false);
        this.ilf.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.ile.cpr() != null) {
            this.ile.cpr().a(this);
        }
        this.mPullView = new g(this.ile.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.ilu = i3;
                if (!b.this.ict && b.this.ibR != null && b.this.ibR.ict && !b.this.ilA) {
                    b.this.cqP();
                    if (i3 > b.this.ilq) {
                        b.this.ilu = 0;
                        b.this.cu(b.this.ile.cpr().getRootView());
                    }
                }
            }
        });
        this.mPullView.je(true);
        this.mPullView.setListPullRefreshListener(this.gmi);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.ile.getUniqueId());
        }
        this.ilf.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.ile.getPageContext().getPageActivity());
        this.gzK = new View(this.ile.getPageContext().getPageActivity());
        frameLayout.addView(this.gzK, new FrameLayout.LayoutParams(-1, this.iiV));
        this.ilf.getAdapter2().addHeaderView(frameLayout, 0);
        this.bzs = new View(this.ile.getActivity());
        this.bzs.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.ile.getActivity(), R.dimen.ds50)));
        this.bzs.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.ils);
        this.mPullView.getView().setOnClickListener(this.ils);
        this.gzK.setOnClickListener(this.ils);
        cqZ();
    }

    public void cs(View view) {
        this.ilk = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.ilk != null) {
            cqP();
            this.ilk.setTag(this.ile.getUniqueId());
            this.ilk.setAdData();
            this.ilk.setEventCenter(this.ibM);
            this.ilk.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqP() {
        if (!this.ilA && this.ilk != null) {
            ViewGroup.LayoutParams layoutParams = this.ilk.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int cqQ = cqQ();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.ict ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.ilt + this.ilu) - cqQ, 0, 0);
                this.ilk.setLayoutParams(layoutParams2);
                this.ilk.setAdViewHeight(layoutParams2.height - cqQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cqQ() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int cqR() {
        return this.ict ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.ilt + this.ilu) - cqQ();
    }

    private int cqS() {
        ViewGroup.LayoutParams layoutParams = this.ilk.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void cqT() {
        if (!this.ilA) {
            this.ict = true;
            cqP();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.ilk != null) {
                if (!this.ilk.cqI()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.ilk.cqH()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            xL(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ilx);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.ilx, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(int i) {
        if (!this.ilA) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilf.getLayoutParams();
            marginLayoutParams.topMargin = ((this.ieF + i) - this.iiV) - (EnterForumDelegateStatic.idA.cpR() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.ilf.setLayoutParams(marginLayoutParams);
        }
    }

    private int cqU() {
        return (this.ieF - this.iiV) - (EnterForumDelegateStatic.idA.cpR() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqV() {
        this.ict = false;
        cqP();
        xL(0);
        if (this.ilw) {
            this.ilf.completePullRefreshPostDelayed(0L);
        }
        this.ilw = false;
    }

    public void ct(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.ile.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.ile.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.ilf.setVisibility(8);
        if (this.ile.cpr() != null) {
            this.ile.cpr().cpF();
            this.ile.cpr().cpG();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.ilf.setVisibility(0);
        if (this.ile.cpr() != null) {
            this.ile.cpr().cpF();
            this.ile.cpr().cpG();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.ilh);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.ilh.remove(fVar);
        a(this.ilh, this.ili, z);
        oS(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cqW() {
        return this.ilf;
    }

    public void startPullRefresh() {
        this.ilf.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.ict) {
            this.ilw = true;
            return;
        }
        this.ilw = false;
        this.ilf.completePullRefreshPostDelayed(0L);
    }

    public void oS(boolean z) {
        this.ilg.notifyDataSetChanged();
        if (this.bzs != null && this.bzs.getLayoutParams() != null) {
            if (z) {
                this.bzs.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bzs.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bj bjVar, boolean z) {
        this.ilk.setAdData();
        EnterForumDelegateStatic.idA.fk(this.mContext);
        this.ilh = list;
        this.ili = bjVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        u uVar = new u();
        uVar.nJ(4);
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
                uVar2.nJ(11);
                arrayList.add(uVar2);
            } else {
                u uVar3 = new u();
                uVar3.nJ(3);
                arrayList.add(uVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bk(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bjVar.bjg());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            u uVar4 = new u();
            uVar4.nJ(5);
            arrayList.add(uVar4);
        }
        hideNoDataView();
        this.ilg.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.ilf.removeFooterView(this.bzs);
            this.ilf.addFooterView(this.bzs);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.ilf.removeFooterView(this.bzs);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.ill != null) {
            this.ill.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bzs, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.ilr = cVar;
    }

    public void cqX() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.ile != null && this.ile.getActivity() != null && this.ile.cpq() != null) {
            if (this.ilj == null) {
                this.ilj = new CommonTipView(this.ile.getActivity());
            }
            this.ilj.setText(R.string.enter_forum_login_tip);
            this.ilj.c(this.ile.cpq(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.ile.isAdded() && this.ile.isPrimary()) {
            ilm = false;
            if (this.ilg != null) {
                this.ilg.onPrimary();
                if (this.ilf != null) {
                    Object itemAtPosition = this.ilf.getItemAtPosition(this.ilf.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof u) && ((u) itemAtPosition).getItemViewType() == 5) {
                        this.ilg.com();
                    }
                }
            }
            if (this.ilA) {
                this.ilk.requestFocus();
                this.ilk.requestFocusFromTouch();
                return;
            }
            return;
        }
        cqY();
    }

    public void onPause() {
        cqY();
    }

    public void onDestroy() {
        if (this.ilj != null) {
            this.ilj.onDestroy();
        }
        if (this.ilg != null) {
            this.ilg.onDestroy();
        }
    }

    public void xq(int i) {
        this.ilg.xq(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ilg != null) {
            this.ilg.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean col() {
        if (this.ilg == null) {
            return false;
        }
        return this.ilg.col();
    }

    public void a(u uVar, View view) {
        if (TbadkCoreApplication.isLogin() && !ilm && this.ile.getActivity() != null && this.ile.getPageContext() != null && (uVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
            if (fVar.isPrivateForum() != 0 && fVar.coD() != 0 && !com.baidu.tbadk.core.sharedPref.b.bnH().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.iln = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bnH().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.iln = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                ilm = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.iln);
                        b.this.ile.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.hYa = dVar.mi();
                this.hYa.setShouldCheckLocInWindow(false);
                this.hYa.setUseDirectOffset(true);
                this.hYa.show(this.ile.getActivity());
                if (this.iln == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.iln == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.hYa != null) {
                            b.this.hYa.dismiss();
                            b.this.hYa = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void cqY() {
        if (this.hYa != null) {
            this.hYa.dismiss();
            this.hYa = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.ibR = cVar;
        if (this.ilg != null) {
            this.ilg.setAdState(cVar);
        }
        if (cVar != null && cVar.ict) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.pM(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.pM(R.raw.lottie_common_pull_refresh);
    }

    public void oT(boolean z) {
        if (this.ilp != z) {
            this.ilp = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilf.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.ilf.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.ilf.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.ilf.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.ilk != null) {
            this.ilk.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.ilk != null) {
            this.ilk.setRecentlyIsShow(z);
        }
    }

    private void cqZ() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.ily = new View(this.mContext);
        this.ily.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.ile.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.ily.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float ilE = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.ilz = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.ilz <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.ilz) {
                            b.this.cra();
                            if (this.ilE < 50.0f) {
                                b.this.ily.performClick();
                            }
                        } else {
                            b.this.crb();
                        }
                        b.this.ilz = 0.0f;
                        this.ilE = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.ilz) {
                            b.this.av(motionEvent.getRawY() - b.this.ilz);
                            if (b.this.feo != null) {
                                b.this.feo.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.ilz) > this.ilE) {
                            this.ilE = Math.abs(motionEvent.getRawY() - b.this.ilz);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.ilz <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.ilz) {
                            b.this.cra();
                        } else {
                            b.this.crb();
                        }
                        b.this.ilz = 0.0f;
                        this.ilE = 0.0f;
                        return true;
                }
            }
        });
        this.feo = new ImageView(this.mContext);
        this.feo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.crb();
            }
        });
    }

    public void cu(final View view) {
        if ((view instanceof FrameLayout) && !this.ilA) {
            this.mPullView.pause();
            this.ilA = true;
            this.ilk.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.feo, R.drawable.icon_jinba_retract_n);
            final int cqS = cqS();
            ValueAnimator ofInt = ValueAnimator.ofInt(cqS, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.ilk != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.ilk.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.cqQ();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.ilk.setLayoutParams(marginLayoutParams);
                            if (intValue / cqS < 0.2d) {
                                if (b.this.ilk.getParent() != b.this.ilk.getRootView() && (viewGroup = (ViewGroup) b.this.ilk.getRootView()) != null) {
                                    ((ViewGroup) b.this.ilk.getParent()).removeView(b.this.ilk);
                                    if (b.this.ilk.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.ilk, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.ily);
                                    viewGroup.bringChildToFront(b.this.feo);
                                }
                            } else if (b.this.ilk.getParent() == b.this.ilk.getRootView()) {
                                if (b.this.ilk.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.ilk.getRootView();
                                    ((ViewGroup) b.this.ilk.getParent()).removeView(b.this.ilk);
                                }
                                if (b.this.ilk.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.ile.cpu().addView(b.this.ilk, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.ilA = false;
                    b.this.xL(((intValue - cqS) * 2) + 0);
                    b.this.ilA = true;
                    float abs = Math.abs(intValue / cqS);
                    b.this.ilf.setAlpha(abs);
                    View cpI = b.this.ile.cpr().cpI();
                    if (cpI != null) {
                        cpI.setAlpha(abs);
                    }
                    View findViewById = b.this.ile.cpu().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.ilk != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.ilk.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.cqQ();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.ilk.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.ilf.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.ilA = false;
                    b.this.xL(0 - (cqS * 2));
                    b.this.ilA = true;
                    b.this.ilf.setVisibility(8);
                    b.this.ily.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.ily.getParent() == null) {
                        frameLayout.addView(b.this.ily, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.feo.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.feo, layoutParams3);
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
            this.ilk.requestFocus();
            this.ilk.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(float f) {
        ViewGroup viewGroup;
        int cqR = cqR();
        float abs = Math.abs(cqR / (cqU() - cqR));
        int i = (int) f;
        if (this.ilk != null) {
            ViewGroup.LayoutParams layoutParams = this.ilk.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                cqQ();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.ilk.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.ilk.getParent() != this.ilk.getRootView() && (viewGroup = (ViewGroup) this.ilk.getRootView()) != null) {
                        ((ViewGroup) this.ilk.getParent()).removeView(this.ilk);
                        if (this.ilk.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.ilk, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.ily);
                        viewGroup.bringChildToFront(this.feo);
                    }
                } else if (this.ilk.getParent() == this.ilk.getRootView()) {
                    if (this.ilk.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.ilk.getRootView();
                        ((ViewGroup) this.ilk.getParent()).removeView(this.ilk);
                    }
                    if (this.ilk.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.ile.cpu().addView(this.ilk, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.ilf.setVisibility(0);
        this.ilA = false;
        xL(((int) ((i * abs) - (cqR * abs))) * 2);
        this.ilA = true;
        float abs2 = Math.abs(i / cqR);
        this.ilf.setAlpha(abs2);
        View cpI = this.ile.cpr().cpI();
        if (cpI != null) {
            cpI.setAlpha(abs2);
        }
        View findViewById = this.ile.cpu().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cra() {
        if (this.feo != null) {
            this.feo.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(cqS(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.av(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.av(0.0f);
                b.this.mPullView.resume();
                b.this.ilf.completePullRefresh();
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
    public void crb() {
        this.ily.setEnabled(false);
        int cqR = cqR();
        Math.abs(cqR / (cqU() - cqR));
        this.feo.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.ilk.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(cqS(), cqR);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.av(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
                    ViewGroup viewGroup = (ViewGroup) b.this.ily.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.ily);
                        viewGroup.removeView(b.this.feo);
                    }
                    b.this.feo.setVisibility(0);
                    b.this.ilA = false;
                    b.this.cqP();
                    b.this.ilu = 0;
                    b.this.xL(0);
                    b.this.ilA = true;
                    b.this.mPullView.resume();
                    b.this.ilf.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ilA = false;
                        }
                    }, 0L);
                    b.this.ilf.setVisibility(0);
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
        if (this.ilA) {
            crb();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.coU())) {
                this.ilB = false;
            } else {
                this.ilB = true;
            }
            this.ill.setForumId(aVar.coS());
            this.ill.H(aVar.coR(), aVar.coT());
            this.ill.fO(aVar.coQ());
            this.ill.AH(aVar.coU());
        }
    }
}
