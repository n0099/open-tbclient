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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.c;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.enterForum.view.e;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements EnterForumAdView.a {
    private static boolean gah = false;
    private View aDM;
    private ImageView dtO;
    private View eFc;
    private com.baidu.adp.lib.guide.c fQA;
    private ViewEventCenter fUg;
    private com.baidu.tieba.enterForum.data.b fUl;
    private int fWN;
    private int fZE;
    private final EnterForumFragment gab;
    private BdListView gac;
    private com.baidu.tieba.enterForum.a.a gad;
    private List<com.baidu.tieba.enterForum.data.f> gae;
    private CommonTipView gaf;
    private EnterForumAdView gag;
    private int gai;
    private e gaj;
    private int gal;
    private g.c gam;
    private View gat;
    private float gau;
    private Context mContext;
    private int mNavHeight;
    private h mPullView;
    private View mRootView;
    private com.baidu.tbadk.k.h refreshView;
    private boolean isFirst = true;
    private boolean gak = true;
    private g.c eun = new g.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.gav) {
                com.baidu.tieba.s.c.cKv().z(b.this.gab.getUniqueId());
                if (b.this.gam != null) {
                    b.this.gam.onListPullRefresh(z);
                }
                if (z && !b.this.fUP && b.this.fUl != null && b.this.fUl.fUP) {
                    if (b.this.fUl.fUR > 0) {
                        b.this.gac.smoothScrollToPosition(0, 0, 0);
                        b.this.bzE();
                        return;
                    }
                    com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gac.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    private com.baidu.tbadk.task.a gan = new com.baidu.tbadk.task.a(2921422, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.enterForum.view.b.12
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<Boolean> customMessage) {
            if (b.this.gav) {
                com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bzM();
                    }
                });
            }
            return new CustomResponsedMessage<>(2921422, Boolean.valueOf(b.this.gav));
        }
    });
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.15
        private int eog = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.gaj.onScrollStateChanged(absListView, i);
            if (this.eog != i) {
                this.eog = i;
                if (this.eog == 1) {
                    if ((b.this.fUl == null || !b.this.fUl.fUP) && b.this.gab != null && b.this.gab.byu() != null) {
                        b.this.gab.byu().bcR();
                    }
                    b.this.bzJ();
                    return;
                }
                b.this.bzy();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.gab.isPrimary() && this.eog != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.gac.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.gac.getItemAtPosition(i4) == v.getItem(b.this.gae, 0)) {
                            b.this.a(dVar, b.this.gac.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.gaj.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fZI = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.16
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void byM() {
            b.this.bzy();
        }
    };
    View.OnClickListener gao = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fUl != null && b.this.fUl.fUP && b.this.fUP) {
                EnterForumAdView unused = b.this.gag;
                EnterForumAdView.a(b.this.gab.getUniqueId(), b.this.gab.getContext());
            }
        }
    };
    private int gap = 0;
    private int gaq = 0;
    boolean fUP = false;
    boolean gar = false;
    private Runnable gas = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.20
        @Override // java.lang.Runnable
        public void run() {
            b.this.bzG();
        }
    };
    private boolean gav = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void bzy() {
        if (bzz()) {
            if (this.gab != null && this.gab.byu() != null) {
                this.gab.byu().bcS();
            }
        } else if (this.fUl != null && this.fUl.fUP) {
            if (this.gab != null && this.gab.byu() != null) {
                this.gab.byu().bcS();
            }
        } else if (this.gab != null && this.gab.byu() != null) {
            this.gab.byu().bcR();
        }
    }

    private boolean bzz() {
        return this.gac == null || this.gac.getChildCount() == 0 || this.gac.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.gab = enterForumFragment;
        this.fWN = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.fZE = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.gal = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.fUg = viewEventCenter;
        bJ(view);
        this.gad = new com.baidu.tieba.enterForum.a.a(this.gab.getPageContext(), this.fUg, recentlyVisitedForumModel, enterForumModel, this);
        this.gac.setAdapter((ListAdapter) this.gad);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.mContext = view.getContext();
        this.gaj = new e();
        this.gaj.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.18
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.gav) {
                    if (b.this.gab.byu().byH() == 1) {
                        b.this.gab.byu().e(absListView, 0, i2, 0, 0);
                    }
                    b.this.gap = -i;
                    if (b.this.fUP) {
                        b.this.bzG();
                    } else if (b.this.fUl != null && b.this.fUl.fUP) {
                        b.this.bzA();
                    }
                }
            }
        });
        this.gac = (BdListView) view.findViewById(R.id.listview);
        sb(0);
        this.gac.setBackgroundColor(0);
        this.gac.setVerticalScrollBarEnabled(false);
        this.gac.setOnScrollListener(this.mOnScrollListener);
        this.gac.setFastScrollEnabled(false);
        this.gac.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.gab.byu() != null) {
            this.gab.byu().b(this.fZI);
            this.gab.byu().a(this.fZI);
            this.gab.byu().a(this);
        }
        this.mPullView = new h(this.gab.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.19
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.gaq = i3;
                if (!b.this.fUP && b.this.fUl != null && b.this.fUl.fUP && !b.this.gav) {
                    b.this.bzA();
                    if (i3 > b.this.gal) {
                        b.this.gaq = 0;
                        b.this.bM(b.this.gab.byu().getRootView());
                    }
                }
            }
        });
        this.mPullView.fT(true);
        this.mPullView.setListPullRefreshListener(this.eun);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.gab.getUniqueId());
        }
        this.gac.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.gab.getPageContext().getPageActivity());
        this.eFc = new View(this.gab.getPageContext().getPageActivity());
        frameLayout.addView(this.eFc, new FrameLayout.LayoutParams(-1, this.fZE));
        this.gac.getAdapter2().addHeaderView(frameLayout, 0);
        this.aDM = new View(this.gab.getActivity());
        this.aDM.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.gab.getActivity(), R.dimen.ds50)));
        this.aDM.setBackgroundResource(R.color.cp_bg_line_d);
        this.mPullView.setOnClickListener(this.gao);
        this.mPullView.getView().setOnClickListener(this.gao);
        this.eFc.setOnClickListener(this.gao);
        bzK();
    }

    public void bK(View view) {
        this.gag = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.gag != null) {
            bzA();
            this.gag.setTag(this.gab.getUniqueId());
            this.gag.setAdData();
            this.gag.setEventCenter(this.fUg);
            this.gag.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzA() {
        if (!this.gav && this.gag != null) {
            ViewGroup.LayoutParams layoutParams = this.gag.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int bzB = bzB();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.fUP ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gap + this.gaq) - bzB, 0, 0);
                this.gag.setLayoutParams(layoutParams2);
                this.gag.setAdViewHeight(layoutParams2.height - bzB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bzB() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int bzC() {
        return this.fUP ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.gap + this.gaq) - bzB();
    }

    private int bzD() {
        ViewGroup.LayoutParams layoutParams = this.gag.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void bzE() {
        if (!this.gav) {
            this.fUP = true;
            bzA();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.gag != null) {
                if (!this.gag.bzv()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.gag.bzu()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            sb(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.gas);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.gas, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        if (!this.gav) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gac.getLayoutParams();
            marginLayoutParams.topMargin = ((this.fWN + i) - this.fZE) - (EnterForumDelegateStatic.fVG.byS() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.gac.setLayoutParams(marginLayoutParams);
        }
    }

    private int bzF() {
        return (this.fWN - this.fZE) - (EnterForumDelegateStatic.fVG.byS() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzG() {
        this.fUP = false;
        bzA();
        sb(0);
        if (this.gar) {
            this.gac.completePullRefreshPostDelayed(0L);
        }
        this.gar = false;
    }

    public void bL(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.k.h(this.gab.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.gab.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.gac.setVisibility(8);
        if (this.gab.byu() != null) {
            this.gab.byu().byI();
            this.gab.byu().byJ();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.gac.setVisibility(0);
        if (this.gab.byu() != null) {
            this.gab.byu().byI();
            this.gab.byu().byJ();
        }
    }

    public boolean isEmpty() {
        return v.isEmpty(this.gae);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.gae.remove(fVar);
        n(this.gae, z);
        kT(z);
    }

    public com.baidu.tbadk.k.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bzH() {
        return this.gac;
    }

    public void startPullRefresh() {
        this.gac.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.fUP) {
            this.gar = true;
            return;
        }
        this.gar = false;
        this.gac.completePullRefreshPostDelayed(0L);
    }

    public void kT(boolean z) {
        this.gad.notifyDataSetChanged();
        if (this.aDM != null && this.aDM.getLayoutParams() != null) {
            if (z) {
                this.aDM.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.aDM.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void n(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.gag.setAdData();
        EnterForumDelegateStatic.fVG.eM(this.mContext);
        this.gae = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
        dVar.setType(4);
        arrayList.add(dVar);
        arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), !v.isEmpty(list)));
        arrayList.addAll(list);
        if (v.isEmpty(list)) {
            com.baidu.tieba.enterForum.data.d dVar2 = new com.baidu.tieba.enterForum.data.d();
            dVar2.setType(3);
            arrayList.add(dVar2);
        }
        if (z) {
            com.baidu.tieba.enterForum.data.d dVar3 = new com.baidu.tieba.enterForum.data.d();
            dVar3.setType(5);
            arrayList.add(dVar3);
        }
        hideNoDataView();
        this.gad.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.gac.removeFooterView(this.aDM);
            this.gac.addFooterView(this.aDM);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.gac.removeFooterView(this.aDM);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        am.setBackgroundResource(this.aDM, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.gam = cVar;
    }

    public void bzI() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.gab != null && this.gab.getActivity() != null && this.gab.byt() != null) {
            if (this.gaf == null) {
                this.gaf = new CommonTipView(this.gab.getActivity());
            }
            this.gaf.setText(R.string.enter_forum_login_tip);
            this.gaf.c(this.gab.byt(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.gab.isAdded() && this.gab.isPrimary()) {
            this.gan.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().unRegisterTask(this.gan.getCmd());
            MessageManager.getInstance().registerTask(this.gan);
            this.gag.setAdData();
            gah = false;
            if (this.gad != null) {
                this.gad.onPrimary();
                if (this.gac != null) {
                    Object itemAtPosition = this.gac.getItemAtPosition(this.gac.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.gad.bxK();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
            }
            if (this.gav) {
                this.gag.requestFocus();
                this.gag.requestFocusFromTouch();
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterTask(this.gan.getCmd());
        bzJ();
    }

    public void onPause() {
        bzJ();
    }

    public void onDestroy() {
        if (this.gaf != null) {
            this.gaf.onDestroy();
        }
        if (this.gad != null) {
            this.gad.onDestroy();
        }
        if (this.gab != null && this.gab.byu() != null) {
            this.gab.byu().b(this.fZI);
        }
    }

    public void rM(int i) {
        this.gad.rM(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gad != null) {
            this.gad.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bxJ() {
        if (this.gad == null) {
            return false;
        }
        return this.gad.bxJ();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !gah && this.gab.getActivity() != null && this.gab.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bxY() != 0 && !com.baidu.tbadk.core.sharedPref.b.aFH().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.gai = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.aFH().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.gai = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                gah = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).M(0).F(true).G(false).E(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.gai);
                        b.this.gab.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                dVar2.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.fQA = dVar2.fI();
                this.fQA.setShouldCheckLocInWindow(false);
                this.fQA.setUseDirectOffset(true);
                this.fQA.show(this.gab.getActivity());
                if (this.gai == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.gai == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.fQA != null) {
                            b.this.fQA.dismiss();
                            b.this.fQA = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bzJ() {
        if (this.fQA != null) {
            this.fQA.dismiss();
            this.fQA = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.fUl = bVar;
        if (this.gad != null) {
            this.gad.setAdState(bVar);
        }
        if (bVar != null && bVar.fUP) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.ll(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.ll(R.raw.lottie_common_pull_refresh);
    }

    public void kU(boolean z) {
        if (this.gak != z) {
            this.gak = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gac.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.gac.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.gac.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.gac.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.gag != null) {
            this.gag.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.gag != null) {
            this.gag.setRecentlyIsShow(z);
        }
    }

    private void bzK() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.gat = new View(this.mContext);
        this.gat.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.gab.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.gat.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            private float gay = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gau = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.gau <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gau) {
                            b.this.bzL();
                            if (this.gay < 50.0f) {
                                b.this.gat.performClick();
                            }
                        } else {
                            b.this.bzM();
                        }
                        b.this.gau = 0.0f;
                        this.gay = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.gau) {
                            b.this.ax(motionEvent.getRawY() - b.this.gau);
                            if (b.this.dtO != null) {
                                b.this.dtO.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.gau) > this.gay) {
                            this.gay = Math.abs(motionEvent.getRawY() - b.this.gau);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.gau <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.gau) {
                            b.this.bzL();
                        } else {
                            b.this.bzM();
                        }
                        b.this.gau = 0.0f;
                        this.gay = 0.0f;
                        return true;
                }
            }
        });
        this.dtO = new ImageView(this.mContext);
        this.dtO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bzM();
            }
        });
    }

    public void bM(final View view) {
        if ((view instanceof FrameLayout) && !this.gav) {
            this.mPullView.pause();
            this.gav = true;
            this.gag.getAdImageView().getLocationInWindow(new int[2]);
            am.setImageResource(this.dtO, R.drawable.icon_jinba_retract_n);
            final int bzD = bzD();
            ValueAnimator ofInt = ValueAnimator.ofInt(bzD, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.gag != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gag.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.bzB();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.gag.setLayoutParams(marginLayoutParams);
                            if (intValue / bzD < 0.2d) {
                                if (b.this.gag.getParent() != b.this.gag.getRootView() && (viewGroup = (ViewGroup) b.this.gag.getRootView()) != null) {
                                    ((ViewGroup) b.this.gag.getParent()).removeView(b.this.gag);
                                    if (b.this.gag.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.gag, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.gat);
                                    viewGroup.bringChildToFront(b.this.dtO);
                                }
                            } else if (b.this.gag.getParent() == b.this.gag.getRootView()) {
                                if (b.this.gag.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.gag.getRootView();
                                    ((ViewGroup) b.this.gag.getParent()).removeView(b.this.gag);
                                }
                                if (b.this.gag.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.gab.byw().addView(b.this.gag, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.gav = false;
                    b.this.sb(((intValue - bzD) * 2) + 0);
                    b.this.gav = true;
                    float abs = Math.abs(intValue / bzD);
                    b.this.gac.setAlpha(abs);
                    View byL = b.this.gab.byu().byL();
                    if (byL != null) {
                        byL.setAlpha(abs);
                    }
                    View findViewById = b.this.gab.byw().getRootView().findViewById(R.id.tabcontainer_wrapper);
                    if (findViewById != null) {
                        findViewById.setAlpha(abs);
                    }
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.9
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (b.this.gag != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.gag.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.bzB();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.gag.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.gac.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.gav = false;
                    b.this.sb(0 - (bzD * 2));
                    b.this.gav = true;
                    b.this.gac.setVisibility(8);
                    b.this.gat.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.gat.getParent() == null) {
                        frameLayout.addView(b.this.gat, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.dtO.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.dtO, layoutParams3);
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
            this.gag.requestFocus();
            this.gag.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(float f) {
        ViewGroup viewGroup;
        int bzC = bzC();
        float abs = Math.abs(bzC / (bzF() - bzC));
        int i = (int) f;
        if (this.gag != null) {
            ViewGroup.LayoutParams layoutParams = this.gag.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                bzB();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.gag.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.gag.getParent() != this.gag.getRootView() && (viewGroup = (ViewGroup) this.gag.getRootView()) != null) {
                        ((ViewGroup) this.gag.getParent()).removeView(this.gag);
                        if (this.gag.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.gag, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.gat);
                        viewGroup.bringChildToFront(this.dtO);
                    }
                } else if (this.gag.getParent() == this.gag.getRootView()) {
                    if (this.gag.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.gag.getRootView();
                        ((ViewGroup) this.gag.getParent()).removeView(this.gag);
                    }
                    if (this.gag.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.gab.byw().addView(this.gag, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.gac.setVisibility(0);
        this.gav = false;
        sb(((int) ((i * abs) - (bzC * abs))) * 2);
        this.gav = true;
        float abs2 = Math.abs(i / bzC);
        this.gac.setAlpha(abs2);
        View byL = this.gab.byu().byL();
        if (byL != null) {
            byL.setAlpha(abs2);
        }
        View findViewById = this.gab.byw().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzL() {
        if (this.dtO != null) {
            this.dtO.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(bzD(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ax(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ax(0.0f);
                b.this.mPullView.resume();
                b.this.gac.completePullRefresh();
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
    public void bzM() {
        this.gat.setEnabled(false);
        int bzC = bzC();
        Math.abs(bzC / (bzF() - bzC));
        this.dtO.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.gag.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(bzD(), bzC);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.ax(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnonymousClass14());
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.enterForum.view.b$14  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass14 implements Animator.AnimatorListener {
        AnonymousClass14() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.gat.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.gat);
                        viewGroup.removeView(b.this.dtO);
                    }
                    b.this.dtO.setVisibility(0);
                    b.this.gav = false;
                    b.this.bzA();
                    b.this.gaq = 0;
                    b.this.sb(0);
                    b.this.gav = true;
                    b.this.mPullView.resume();
                    b.this.gac.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.14.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.gav = false;
                        }
                    }, 0L);
                    b.this.gac.setVisibility(0);
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
        if (this.gav) {
            bzM();
        }
    }
}
