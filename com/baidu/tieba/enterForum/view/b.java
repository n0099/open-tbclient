package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.e;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static boolean fcc = false;
    private com.baidu.adp.lib.guide.c eLV;
    private com.baidu.tieba.enterForum.data.b eVA;
    private ViewEventCenter eVv;
    private int eYk;
    private BdListView eeM;
    private View eve;
    private final EnterForumFragment fbW;
    private com.baidu.tieba.enterForum.a.a fbX;
    private com.baidu.tieba.enterForum.multiConcern.a fbY;
    private List<com.baidu.tieba.enterForum.data.f> fbZ;
    private int fbu;
    private CommonTipView fca;
    private EnterForumAdView fcb;
    private int fcd;
    private e fce;
    private h.c fcg;
    private Context mContext;
    private i mPullView;
    private View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private boolean isFirst = true;
    private boolean fcf = true;
    private h.c drK = new h.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            com.baidu.tieba.q.c.coG().x(b.this.fbW.getUniqueId());
            if (b.this.fcg != null) {
                b.this.fcg.er(z);
            }
            if (z && !b.this.eWf && b.this.eVA != null && b.this.eVA.eWf) {
                if (b.this.eVA.eWh > 0) {
                    b.this.eeM.smoothScrollToPosition(0, 0, 0);
                    b.this.bgZ();
                    return;
                }
                b.this.eeM.smoothScrollToPosition(0, 0, 0);
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.4
        private int dpw = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fce.onScrollStateChanged(absListView, i);
            if (this.dpw != i) {
                this.dpw = i;
                if (this.dpw == 1) {
                    if ((b.this.eVA == null || !b.this.eVA.eWf) && b.this.fbW != null && b.this.fbW.bfM() != null) {
                        b.this.fbW.bfM().aJw();
                    }
                    b.this.bhd();
                    return;
                }
                b.this.bgW();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fbW.isPrimary() && this.dpw != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.eeM.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.eeM.getItemAtPosition(i4) == v.c(b.this.fbZ, 0)) {
                            b.this.a(dVar, b.this.eeM.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fce.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fbx = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.5
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void bgf() {
            b.this.bgW();
        }
    };
    private int fch = 0;
    private int fci = 0;
    boolean eWf = false;
    boolean fcj = false;
    private Runnable fck = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.9
        @Override // java.lang.Runnable
        public void run() {
            b.this.bha();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bgW() {
        if (bgX()) {
            if (this.fbW != null && this.fbW.bfM() != null) {
                this.fbW.bfM().aJx();
            }
        } else if (this.eVA != null && this.eVA.eWf) {
            if (this.fbW != null && this.fbW.bfM() != null) {
                this.fbW.bfM().aJx();
            }
        } else if (this.fbW != null && this.fbW.bfM() != null) {
            this.fbW.bfM().aJw();
        }
    }

    private boolean bgX() {
        return this.eeM == null || this.eeM.getChildCount() == 0 || this.eeM.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fbW = enterForumFragment;
        this.eYk = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds240);
        this.fbu = l.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.eVv = viewEventCenter;
        this.fbY = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bN(view);
        this.fbX = new com.baidu.tieba.enterForum.a.a(this.fbW.getPageContext(), this.eVv, recentlyVisitedForumModel, enterForumModel, this);
        this.eeM.setAdapter((ListAdapter) this.fbX);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bN(View view) {
        this.mContext = view.getContext();
        this.fce = new e();
        this.fce.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (b.this.fbW.bfM().bga() == 1) {
                    b.this.fbW.bfM().d(absListView, 0, i2, 0, 0);
                }
                b.this.fch = -i;
                if (b.this.eWf) {
                    b.this.bha();
                } else if (b.this.eVA != null && b.this.eVA.eWf) {
                    b.this.bgY();
                }
            }
        });
        this.eeM = (BdListView) view.findViewById(R.id.listview);
        qK(0);
        this.eeM.setBackgroundColor(0);
        this.eeM.setVerticalScrollBarEnabled(false);
        this.eeM.setOnScrollListener(this.mOnScrollListener);
        this.eeM.setFastScrollEnabled(false);
        this.eeM.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fbW.bfM() != null) {
            this.fbW.bfM().b(this.fbx);
            this.fbW.bfM().a(this.fbx);
            this.fbW.bfM().a(this);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (b.this.eVA != null && b.this.eVA.eWf) {
                    EnterForumAdView unused = b.this.fcb;
                    EnterForumAdView.a(b.this.fbW.getUniqueId(), b.this.fbW.getContext());
                }
            }
        };
        this.mPullView = new i(this.fbW.getPageContext());
        this.mPullView.setOnClickListener(onClickListener);
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.8
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                b.this.fci = i3;
                if (!b.this.eWf && b.this.eVA != null && b.this.eVA.eWf) {
                    b.this.bgY();
                    if (i3 > 300) {
                        b.this.fcb.bM(b.this.fbW.bfM().getRootView());
                    }
                }
            }
        });
        this.mPullView.setListPullRefreshListener(this.drK);
        this.mPullView.et(true);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fbW.getUniqueId());
        }
        this.eeM.setPullRefresh(this.mPullView);
        FrameLayout frameLayout = new FrameLayout(this.fbW.getPageContext().getPageActivity());
        View view2 = new View(this.fbW.getPageContext().getPageActivity());
        view2.setOnClickListener(onClickListener);
        frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, this.fbu));
        this.eeM.getAdapter2().addHeaderView(frameLayout, 0);
        this.eve = new View(this.fbW.getActivity());
        this.eve.setLayoutParams(new AbsListView.LayoutParams(-1, l.g(this.fbW.getActivity(), R.dimen.ds50)));
        this.eve.setBackgroundResource(R.color.cp_bg_line_d);
    }

    public void bO(View view) {
        this.fcb = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fcb != null) {
            bgY();
            this.fcb.setTag(this.fbW.getUniqueId());
            this.fcb.setAdData();
            this.fcb.setEventCenter(this.eVv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgY() {
        if (this.fcb != null) {
            ViewGroup.LayoutParams layoutParams = this.fcb.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds934);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.eWf ? 0 : (this.fch + this.fci) - dimensionPixelOffset, 0, 0);
                this.fcb.setLayoutParams(layoutParams2);
                this.fcb.setAdViewHeight(layoutParams2.height - dimensionPixelOffset);
            }
        }
    }

    public void bgZ() {
        this.eWf = true;
        bgY();
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.ob();
        if (this.fcb != null) {
            if (!this.fcb.bgR()) {
                dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.fcb.bgQ()) {
                dimensionPixelOffset += this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
        }
        qK(dimensionPixelOffset);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fck);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.fck, 3000L);
    }

    private void qK(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eeM.getLayoutParams();
        marginLayoutParams.topMargin = ((this.eYk + i) - this.fbu) - this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds24);
        this.eeM.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bha() {
        this.eWf = false;
        bgY();
        qK(0);
        if (this.fcj) {
            this.eeM.completePullRefreshPostDelayed(0L);
        }
        this.fcj = false;
    }

    public void bP(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(this.fbW.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.qN(this.fbW.getString(R.string.neterror));
        this.mRootView = view;
        int dimensionPixelSize = this.fbW.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize += UtilHelper.getStatusBarHeight();
        }
        this.refreshView.kM(dimensionPixelSize);
        this.refreshView.attachView(view, false);
        this.refreshView.atK();
        this.eeM.setVisibility(8);
        if (this.fbW.bfM() != null) {
            this.fbW.bfM().bgb();
            this.fbW.bfM().bgc();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.eeM.setVisibility(0);
        if (this.fbW.bfM() != null) {
            this.fbW.bfM().bgb();
            this.fbW.bfM().bgc();
        }
    }

    public boolean isEmpty() {
        return v.aa(this.fbZ);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fbZ.remove(fVar);
        j(this.fbZ, z);
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.m.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bhb() {
        return this.eeM;
    }

    public void startPullRefresh() {
        this.eeM.startPullRefresh();
    }

    public void oT() {
        if (this.eWf) {
            this.fcj = true;
            return;
        }
        this.fcj = false;
        this.eeM.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.fbX.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fcb.setAdData();
        EnterForumDelegateStatic.eWZ.dD(this.mContext);
        this.fbZ = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.d dVar = new com.baidu.tieba.enterForum.data.d();
        dVar.setType(4);
        arrayList.add(dVar);
        arrayList.add(new com.baidu.tieba.enterForum.data.e(this.mContext.getResources().getString(R.string.my_attention_bar), !v.aa(list)));
        arrayList.addAll(list);
        if (v.aa(list)) {
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
        this.fbX.setData(arrayList);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.eeM.removeFooterView(this.eve);
            this.eeM.addFooterView(this.eve);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.eeM.removeFooterView(this.eve);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fbY.bgw() != null) {
            this.fbY.onChangeSkinType();
        }
        am.k(this.eve, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.fcg = cVar;
    }

    public void bhc() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("enter_forum_login_tip", true) && this.fbW != null && this.fbW.getActivity() != null && this.fbW.bfL() != null) {
            if (this.fca == null) {
                this.fca = new CommonTipView(this.fbW.getActivity());
            }
            this.fca.setText(R.string.enter_forum_login_tip);
            this.fca.show(this.fbW.bfL(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.fbW.isAdded() && this.fbW.isPrimary()) {
            this.fcb.setAdData();
            fcc = false;
            if (this.fbX != null) {
                this.fbX.onPrimary();
                if (this.eeM != null) {
                    Object itemAtPosition = this.eeM.getItemAtPosition(this.eeM.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fbX.bfe();
                    }
                }
            }
            if (this.isFirst) {
                startPullRefresh();
                this.isFirst = false;
                return;
            }
            return;
        }
        bhd();
    }

    public void onPause() {
        bhd();
    }

    public void onDestroy() {
        if (this.fca != null) {
            this.fca.onDestroy();
        }
        if (this.fbY != null) {
            this.fbY.onDestroy();
        }
        if (this.fbX != null) {
            this.fbX.onDestroy();
        }
        if (this.fbW != null && this.fbW.bfM() != null) {
            this.fbW.bfM().b(this.fbx);
        }
    }

    public void qu(int i) {
        this.fbX.qu(i);
    }

    public void bK(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.fbY.isShowing() && !v.aa(list)) {
            this.fbY.bG(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fbX != null) {
            this.fbX.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bfd() {
        if (this.fbX == null) {
            return false;
        }
        return this.fbX.bfd();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fcc && this.fbW.getActivity() != null && this.fbW.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bft() != 0 && !com.baidu.tbadk.core.sharedPref.b.ahQ().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fcd = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fcd = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fcc = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).X(0).U(true).V(false).T(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.11
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fcd);
                        b.this.fbW.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hT() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hU() {
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
                dVar2.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.2
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.eLV = dVar2.hV();
                this.eLV.R(false);
                this.eLV.S(true);
                this.eLV.q(this.fbW.getActivity());
                if (this.fcd == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fcd == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.eLV != null) {
                            b.this.eLV.dismiss();
                            b.this.eLV = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bhd() {
        if (this.eLV != null) {
            this.eLV.dismiss();
            this.eLV = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eVA = bVar;
        if (this.fbX != null) {
            this.fbX.setAdState(bVar);
        }
        if (bVar != null && bVar.eWf) {
            this.mPullView.iZ(R.raw.ad_refresh_load);
        } else {
            this.mPullView.iZ(R.raw.refresh_load);
        }
    }

    public void jv(boolean z) {
        if (this.fcf != z) {
            this.fcf = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eeM.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.eeM.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.eeM.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.eeM.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fcb != null) {
            this.fcb.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fcb != null) {
            this.fcb.setRecentlyIsShow(z);
        }
    }
}
