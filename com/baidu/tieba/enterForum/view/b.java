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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.v;
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
    private static boolean irZ = false;
    private View bDS;
    private ImageView fjp;
    private View gFf;
    private com.baidu.adp.lib.guide.c ieQ;
    private ViewEventCenter iiB;
    private com.baidu.tieba.enterForum.data.c iiG;
    private int ilq;
    private int ipI;
    private final EnterForumFragment irR;
    private BdListView irS;
    private com.baidu.tieba.enterForum.a.a irT;
    private List<com.baidu.tieba.enterForum.data.f> irU;
    private bk irV;
    private CommonTipView irW;
    private EnterForumAdView irX;
    private GuidePopupWindow irY;
    private int isa;
    private e isb;
    private int isd;
    private f.c ise;
    private View isl;
    private float ism;
    private boolean iso;
    private Context mContext;
    private int mNavHeight;
    private g mPullView;
    private View mRootView;
    private h refreshView;
    private boolean isc = true;
    private f.c grC = new f.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (!b.this.isn) {
                com.baidu.tieba.t.c.dIO().C(b.this.irR.getUniqueId());
                if (b.this.ise != null) {
                    b.this.ise.onListPullRefresh(z);
                }
                if (z && !b.this.iji && b.this.iiG != null && b.this.iiG.iji) {
                    if (b.this.iiG.ijk > 0) {
                        b.this.irS.smoothScrollToPosition(0, 0, 0);
                        b.this.csX();
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.irS.setSelection(0);
                        }
                    });
                }
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.12
        private int glw = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.isb.onScrollStateChanged(absListView, i);
            if (this.glw != i) {
                this.glw = i;
                if (this.glw == 1) {
                    if (b.this.iiG == null || !b.this.iiG.iji) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
                    }
                    b.this.ctc();
                    return;
                }
                b.this.csP();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.irR.isPrimary() && this.glw != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.irS.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof v)) {
                        v vVar = (v) itemAtPosition;
                        if (vVar.getItemViewType() == 1 && b.this.irS.getItemAtPosition(i4) == y.getItem(b.this.irU, 0)) {
                            b.this.a(vVar, b.this.irS.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.isb.onScroll(absListView, i, i2, i3);
        }
    };
    View.OnClickListener isf = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.14
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.iiG != null && b.this.iiG.iji && b.this.iji) {
                EnterForumAdView unused = b.this.irX;
                EnterForumAdView.a(b.this.irR.getUniqueId(), b.this.irR.getContext());
            }
        }
    };
    private int isg = 0;
    private int ish = 0;
    private CustomMessageListener isi = new CustomMessageListener(2921474) { // from class: com.baidu.tieba.enterForum.view.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.csR();
        }
    };
    boolean iji = false;
    boolean isj = false;
    private Runnable isk = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.18
        @Override // java.lang.Runnable
        public void run() {
            b.this.csZ();
        }
    };
    private boolean isn = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void csP() {
        if (csQ()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else if (this.iiG != null && this.iiG.iji) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, false));
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, true));
        }
    }

    public boolean csQ() {
        return this.irS == null || this.irS.getChildCount() == 0 || this.irS.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.irR = enterForumFragment;
        this.ilq = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.ipI = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.isd = l.getDimens(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.iiB = viewEventCenter;
        cA(view);
        this.irT = new com.baidu.tieba.enterForum.a.a(this.irR.getPageContext(), this.iiB, recentlyVisitedForumModel, enterForumModel, this);
        this.irS.setAdapter((ListAdapter) this.irT);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        registerListener();
        this.irY = new GuidePopupWindow(this.irR.getFragmentActivity());
    }

    private void registerListener() {
        this.irR.registerListener(this.isi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csR() {
        if (csS() && this.iso) {
            this.irY.dSD();
            this.irY.dSC();
            this.irY.setCancelable(false);
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("has_guide_popup_window_been_shown", true);
            com.baidu.adp.lib.f.g.showDialog(this.irY, this.irR.getFragmentActivity());
        }
    }

    private boolean csS() {
        return TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("has_guide_popup_window_been_shown", false);
    }

    private void cA(View view) {
        this.mContext = view.getContext();
        this.isb = new e();
        this.isb.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.16
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (!b.this.isn) {
                    b.this.isg = -i;
                    if (b.this.iji) {
                        b.this.csZ();
                    } else if (b.this.iiG != null && b.this.iiG.iji) {
                        b.this.csT();
                    }
                }
            }
        });
        this.irS = (BdListView) view.findViewById(R.id.listview);
        yw(0);
        this.irS.setBackgroundColor(0);
        this.irS.setVerticalScrollBarEnabled(false);
        this.irS.setOnScrollListener(this.mOnScrollListener);
        this.irS.setFastScrollEnabled(false);
        this.irS.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        BdListView bdListView = this.irS;
        BdListView.setPullRefreshRatio(1.0f);
        if (this.irR.crv() != null) {
            this.irR.crv().a(this);
        }
        this.mPullView = new g(this.irR.getPageContext());
        this.mPullView.a(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.17
            @Override // com.baidu.adp.widget.ListView.d.a
            public void a(com.baidu.adp.widget.ListView.d dVar, int i, int i2, int i3, int i4) {
                b.this.ish = i3;
                if (!b.this.iji && b.this.iiG != null && b.this.iiG.iji && !b.this.isn) {
                    b.this.csT();
                    if (i3 > b.this.isd) {
                        b.this.ish = 0;
                        b.this.cD(b.this.irR.crv().getRootView());
                    }
                }
            }
        });
        this.mPullView.jo(true);
        this.mPullView.setListPullRefreshListener(this.grC);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.irR.getUniqueId());
        }
        this.irS.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.irR.getPageContext().getPageActivity());
        this.gFf = new View(this.irR.getPageContext().getPageActivity());
        frameLayout.addView(this.gFf, new FrameLayout.LayoutParams(-1, this.ipI));
        this.irS.getAdapter2().addHeaderView(frameLayout, 0);
        this.bDS = new View(this.irR.getActivity());
        this.bDS.setLayoutParams(new AbsListView.LayoutParams(-1, l.getDimens(this.irR.getActivity(), R.dimen.ds50)));
        this.bDS.setBackgroundResource(R.color.CAM_X0201);
        this.mPullView.setOnClickListener(this.isf);
        this.mPullView.getView().setOnClickListener(this.isf);
        this.gFf.setOnClickListener(this.isf);
        ctd();
    }

    public void cB(View view) {
        this.irX = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.irX != null) {
            csT();
            this.irX.setTag(this.irR.getUniqueId());
            this.irX.setAdData();
            this.irX.setEventCenter(this.iiB);
            this.irX.setOnBackPressedListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csT() {
        if (!this.isn && this.irX != null) {
            ViewGroup.LayoutParams layoutParams = this.irX.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int csU = csU();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.iji ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.isg + this.ish) - csU, 0, 0);
                this.irX.setLayoutParams(layoutParams2);
                this.irX.setAdViewHeight(layoutParams2.height - csU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int csU() {
        return this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
    }

    private int csV() {
        return this.iji ? -this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds589) : (this.isg + this.ish) - csU();
    }

    private int csW() {
        ViewGroup.LayoutParams layoutParams = this.irX.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        }
        return 0;
    }

    public void csX() {
        if (!this.isn) {
            this.iji = true;
            csT();
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.getHeadContentHeight();
            if (this.irX != null) {
                if (!this.irX.csM()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
                } else if (!this.irX.csL()) {
                    dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
                }
            }
            yw(dimensionPixelOffset);
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.isk);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.isk, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        if (!this.isn) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.irS.getLayoutParams();
            marginLayoutParams.topMargin = ((this.ilq + i) - this.ipI) - (EnterForumDelegateStatic.ikl.crV() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
            this.irS.setLayoutParams(marginLayoutParams);
        }
    }

    private int csY() {
        return (this.ilq - this.ipI) - (EnterForumDelegateStatic.ikl.crV() != null ? this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds25) : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csZ() {
        this.iji = false;
        csT();
        yw(0);
        if (this.isj) {
            this.irS.completePullRefreshPostDelayed(0L);
        }
        this.isj = false;
    }

    public void cC(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.irR.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.mRootView = view;
        this.refreshView.setLayoutMargin(this.irR.getResources().getDimensionPixelSize(R.dimen.ds364));
        this.refreshView.attachView(view, false);
        this.refreshView.showRefreshButton();
        this.irS.setVisibility(8);
        if (this.irR.crv() != null) {
            this.irR.crv().crJ();
            this.irR.crv().crK();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.irS.setVisibility(0);
        if (this.irR.crv() != null) {
            this.irR.crv().crJ();
            this.irR.crv().crK();
        }
    }

    public boolean isEmpty() {
        return y.isEmpty(this.irU);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.irU.remove(fVar);
        a(this.irU, this.irV, z);
        pe(z);
    }

    public h getRefreshView() {
        return this.refreshView;
    }

    public BdListView cta() {
        return this.irS;
    }

    public void startPullRefresh() {
        this.irS.startPullRefresh();
    }

    public void completeRefresh() {
        if (this.iji) {
            this.isj = true;
            return;
        }
        this.isj = false;
        this.irS.completePullRefreshPostDelayed(0L);
    }

    public void pe(boolean z) {
        this.irT.notifyDataSetChanged();
        if (this.bDS != null && this.bDS.getLayoutParams() != null) {
            if (z) {
                this.bDS.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50);
                return;
            }
            this.bDS.getLayoutParams().height = l.getDimens(this.mContext, R.dimen.ds50) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        }
    }

    public void a(List<com.baidu.tieba.enterForum.data.f> list, bk bkVar, boolean z) {
        this.irX.setAdData();
        EnterForumDelegateStatic.ikl.fk(this.mContext);
        this.irU = list;
        this.irV = bkVar;
        ArrayList arrayList = new ArrayList();
        boolean z2 = !y.isEmpty(list);
        boolean z3 = !y.isEmpty(list);
        v vVar = new v();
        vVar.nP(4);
        arrayList.add(vVar);
        if (z3) {
            arrayList.add(new com.baidu.tieba.enterForum.data.a(true));
            arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            arrayList.addAll(list);
            arrayList.add(bkVar);
        } else {
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), z2));
            }
            if (TbadkApplication.isLogin()) {
                v vVar2 = new v();
                vVar2.nP(11);
                arrayList.add(vVar2);
            } else {
                v vVar3 = new v();
                vVar3.nP(3);
                arrayList.add(vVar3);
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new bl(this.mContext.getResources().getString(R.string.recommend_forum_title_vertical), true));
            }
            if (TbadkApplication.isLogin()) {
                arrayList.addAll(bkVar.bkI());
            }
            if (TbadkApplication.isLogin()) {
                arrayList.add(new com.baidu.tieba.enterForum.data.a(false));
            }
        }
        if (z) {
            v vVar4 = new v();
            vVar4.nP(5);
            arrayList.add(vVar4);
        }
        hideNoDataView();
        this.irT.setData(arrayList, z);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.irS.removeFooterView(this.bDS);
            this.irS.addFooterView(this.bDS);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.irS.removeFooterView(this.bDS);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
        if (this.irY != null) {
            this.irY.onChangeSkinType();
        }
        ap.setBackgroundResource(this.bDS, R.color.CAM_X0201);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.ise = cVar;
    }

    public void ctb() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, true) && this.irR != null && this.irR.getActivity() != null && this.irR.cru() != null) {
            if (this.irW == null) {
                this.irW = new CommonTipView(this.irR.getActivity());
            }
            this.irW.setText(R.string.enter_forum_login_tip);
            this.irW.c(this.irR.cru(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.ENTER_FORUM_LOGIN_TIP, false);
        }
    }

    public void onPrimary() {
        if (this.irR.isAdded() && this.irR.isPrimary()) {
            irZ = false;
            if (this.irT != null) {
                this.irT.onPrimary();
                if (this.irS != null) {
                    Object itemAtPosition = this.irS.getItemAtPosition(this.irS.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof v) && ((v) itemAtPosition).getItemViewType() == 5) {
                        this.irT.cqq();
                    }
                }
            }
            if (this.isn) {
                this.irX.requestFocus();
                this.irX.requestFocusFromTouch();
                return;
            }
            return;
        }
        ctc();
    }

    public void onPause() {
        ctc();
    }

    public void onDestroy() {
        if (this.irW != null) {
            this.irW.onDestroy();
        }
        if (this.irT != null) {
            this.irT.onDestroy();
        }
    }

    public void yb(int i) {
        this.irT.yb(i);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.irT != null) {
            this.irT.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean cqp() {
        if (this.irT == null) {
            return false;
        }
        return this.irT.cqp();
    }

    public void a(v vVar, View view) {
        if (TbadkCoreApplication.isLogin() && !irZ && this.irR.getActivity() != null && this.irR.getPageContext() != null && (vVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
            if (fVar.isPrivateForum() != 0 && fVar.cqH() != 0 && !com.baidu.tbadk.core.sharedPref.b.bpu().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.isa = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.bpu().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.isa = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                irZ = true;
                com.baidu.adp.lib.guide.d dVar = new com.baidu.adp.lib.guide.d();
                dVar.y(view).ak(0).af(true).ag(false).ae(true);
                dVar.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.20
                    @Override // com.baidu.adp.lib.guide.b
                    public View getView(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.isa);
                        b.this.irR.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.ieQ = dVar.mi();
                this.ieQ.setShouldCheckLocInWindow(false);
                this.ieQ.setUseDirectOffset(true);
                this.ieQ.show(this.irR.getActivity());
                if (this.isa == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.isa == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.ieQ != null) {
                            b.this.ieQ.dismiss();
                            b.this.ieQ = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void ctc() {
        if (this.ieQ != null) {
            this.ieQ.dismiss();
            this.ieQ = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.c cVar) {
        this.iiG = cVar;
        if (this.irT != null) {
            this.irT.setAdState(cVar);
        }
        if (cVar != null && cVar.iji) {
            if (this.mPullView.getView() != null) {
                this.mPullView.getView().setScaleX(0.5f);
                this.mPullView.getView().setScaleY(0.5f);
            }
            this.mPullView.qu(R.raw.ad_refresh_load);
            return;
        }
        if (this.mPullView.getView() != null) {
            this.mPullView.getView().setScaleX(1.0f);
            this.mPullView.getView().setScaleY(1.0f);
        }
        this.mPullView.qu(R.raw.lottie_common_pull_refresh);
    }

    public void pf(boolean z) {
        if (this.isc != z) {
            this.isc = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.irS.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.irS.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.irS.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.irS.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.irX != null) {
            this.irX.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.irX != null) {
            this.irX.setRecentlyIsShow(z);
        }
    }

    private void ctd() {
        this.mNavHeight = l.getDimens(this.mContext, R.dimen.tbds240);
        this.isl = new View(this.mContext);
        this.isl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EnterForumAdView.a(b.this.irR.getPageContext().getUniqueId(), b.this.mContext);
            }
        });
        this.isl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.enterForum.view.b.5
            private float isr = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.ism = motionEvent.getRawY();
                        return true;
                    case 1:
                        if (b.this.ism <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.ism) {
                            b.this.cte();
                            if (this.isr < 50.0f) {
                                b.this.isl.performClick();
                            }
                        } else {
                            b.this.ctf();
                        }
                        b.this.ism = 0.0f;
                        this.isr = 0.0f;
                        return true;
                    case 2:
                        if (motionEvent.getRawY() < b.this.ism) {
                            b.this.aD(motionEvent.getRawY() - b.this.ism);
                            if (b.this.fjp != null) {
                                b.this.fjp.setVisibility(8);
                            }
                        }
                        if (Math.abs(motionEvent.getRawY() - b.this.ism) > this.isr) {
                            this.isr = Math.abs(motionEvent.getRawY() - b.this.ism);
                            return true;
                        }
                        return true;
                    default:
                        if (b.this.ism <= (b.this.mContext.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= b.this.ism) {
                            b.this.cte();
                        } else {
                            b.this.ctf();
                        }
                        b.this.ism = 0.0f;
                        this.isr = 0.0f;
                        return true;
                }
            }
        });
        this.fjp = new ImageView(this.mContext);
        this.fjp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ctf();
            }
        });
    }

    public void cD(final View view) {
        if ((view instanceof FrameLayout) && !this.isn) {
            this.mPullView.pause();
            this.isn = true;
            this.irX.getAdImageView().getLocationInWindow(new int[2]);
            ap.setImageResource(this.fjp, R.drawable.icon_jinba_retract_n);
            final int csW = csW();
            ValueAnimator ofInt = ValueAnimator.ofInt(csW, 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup viewGroup;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.this.irX != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.irX.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            b.this.csU();
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.setMargins(0, intValue, 0, 0);
                            b.this.irX.setLayoutParams(marginLayoutParams);
                            if (intValue / csW < 0.2d) {
                                if (b.this.irX.getParent() != b.this.irX.getRootView() && (viewGroup = (ViewGroup) b.this.irX.getRootView()) != null) {
                                    ((ViewGroup) b.this.irX.getParent()).removeView(b.this.irX);
                                    if (b.this.irX.getParent() == null) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                        viewGroup.addView(b.this.irX, marginLayoutParams2);
                                    }
                                    viewGroup.bringChildToFront(b.this.isl);
                                    viewGroup.bringChildToFront(b.this.fjp);
                                }
                            } else if (b.this.irX.getParent() == b.this.irX.getRootView()) {
                                if (b.this.irX.getParent() != null) {
                                    ViewGroup viewGroup2 = (ViewGroup) b.this.irX.getRootView();
                                    ((ViewGroup) b.this.irX.getParent()).removeView(b.this.irX);
                                }
                                if (b.this.irX.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                    b.this.irR.cry().addView(b.this.irX, 0, marginLayoutParams3);
                                }
                            }
                        }
                    }
                    b.this.isn = false;
                    b.this.yw(((intValue - csW) * 2) + 0);
                    b.this.isn = true;
                    float abs = Math.abs(intValue / csW);
                    b.this.irS.setAlpha(abs);
                    View crM = b.this.irR.crv().crM();
                    if (crM != null) {
                        crM.setAlpha(abs);
                    }
                    View findViewById = b.this.irR.cry().getRootView().findViewById(R.id.tabcontainer_wrapper);
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
                    if (b.this.irX != null) {
                        ViewGroup.LayoutParams layoutParams = b.this.irX.getLayoutParams();
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            b.this.csU();
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams2.setMargins(0, 0, 0, 0);
                            b.this.irX.setLayoutParams(layoutParams2);
                        }
                    }
                    b.this.mPullView.resume();
                    b.this.irS.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    b.this.isn = false;
                    b.this.yw(0 - (csW * 2));
                    b.this.isn = true;
                    b.this.irS.setVisibility(8);
                    b.this.isl.setEnabled(true);
                    FrameLayout frameLayout = (FrameLayout) view;
                    if (b.this.isl.getParent() == null) {
                        frameLayout.addView(b.this.isl, new FrameLayout.LayoutParams(-1, -1));
                    }
                    if (b.this.fjp.getParent() == null) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams3.bottomMargin = b.this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                        layoutParams3.gravity = 81;
                        frameLayout.addView(b.this.fjp, layoutParams3);
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
            this.irX.requestFocus();
            this.irX.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(float f) {
        ViewGroup viewGroup;
        int csV = csV();
        float abs = Math.abs(csV / (csY() - csV));
        int i = (int) f;
        if (this.irX != null) {
            ViewGroup.LayoutParams layoutParams = this.irX.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                csU();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, i, 0, 0);
                this.irX.setLayoutParams(marginLayoutParams);
                if (Math.abs(marginLayoutParams.topMargin) < 0.2d * marginLayoutParams.height) {
                    if (this.irX.getParent() != this.irX.getRootView() && (viewGroup = (ViewGroup) this.irX.getRootView()) != null) {
                        ((ViewGroup) this.irX.getParent()).removeView(this.irX);
                        if (this.irX.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                            viewGroup.addView(this.irX, marginLayoutParams2);
                        }
                        viewGroup.bringChildToFront(this.isl);
                        viewGroup.bringChildToFront(this.fjp);
                    }
                } else if (this.irX.getParent() == this.irX.getRootView()) {
                    if (this.irX.getParent() != null) {
                        ViewGroup viewGroup2 = (ViewGroup) this.irX.getRootView();
                        ((ViewGroup) this.irX.getParent()).removeView(this.irX);
                    }
                    if (this.irX.getParent() == null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                        this.irR.cry().addView(this.irX, 0, marginLayoutParams3);
                    }
                }
            }
        }
        this.irS.setVisibility(0);
        this.isn = false;
        yw(((int) ((i * abs) - (csV * abs))) * 2);
        this.isn = true;
        float abs2 = Math.abs(i / csV);
        this.irS.setAlpha(abs2);
        View crM = this.irR.crv().crM();
        if (crM != null) {
            crM.setAlpha(abs2);
        }
        View findViewById = this.irR.cry().getRootView().findViewById(R.id.tabcontainer_wrapper);
        if (findViewById != null) {
            findViewById.setAlpha(abs2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cte() {
        if (this.fjp != null) {
            this.fjp.setVisibility(0);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(csW(), 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aD(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.enterForum.view.b.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.aD(0.0f);
                b.this.mPullView.resume();
                b.this.irS.completePullRefresh();
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
    public void ctf() {
        this.isl.setEnabled(false);
        int csV = csV();
        Math.abs(csV / (csY() - csV));
        this.fjp.setVisibility(8);
        int i = ((ViewGroup.MarginLayoutParams) this.irX.getLayoutParams()).topMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(csW(), csV);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.view.b.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.aD(((Integer) valueAnimator.getAnimatedValue()).intValue());
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
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) b.this.isl.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b.this.isl);
                        viewGroup.removeView(b.this.fjp);
                    }
                    b.this.fjp.setVisibility(0);
                    b.this.isn = false;
                    b.this.csT();
                    b.this.ish = 0;
                    b.this.yw(0);
                    b.this.isn = true;
                    b.this.mPullView.resume();
                    b.this.irS.completePullRefresh();
                    b.this.mPullView.setPadding(0, -b.this.mPullView.getHeadContentHeight(), 0, 0);
                    com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.13.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.isn = false;
                        }
                    }, 0L);
                    b.this.irS.setVisibility(0);
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
        if (this.isn) {
            ctf();
        }
    }

    public void b(com.baidu.tieba.enterForum.b.a.a aVar) {
        if (aVar != null) {
            if (StringUtils.isNull(aVar.cqY())) {
                this.iso = false;
            } else {
                this.iso = true;
            }
            this.irY.setForumId(aVar.cqW());
            this.irY.I(aVar.cqV(), aVar.cqX());
            this.irY.fW(aVar.cqU());
            this.irY.Aq(aVar.cqY());
        }
    }
}
