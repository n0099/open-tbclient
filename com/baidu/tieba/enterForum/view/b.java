package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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
    private static boolean fbD = false;
    private com.baidu.adp.lib.guide.c eLO;
    private ViewEventCenter eVo;
    private com.baidu.tieba.enterForum.data.b eVt;
    private BdListView eeF;
    private View euX;
    private ForumHeaderView faF;
    private List<com.baidu.tieba.enterForum.data.f> fbA;
    private CommonTipView fbB;
    private EnterForumAdView fbC;
    private int fbE;
    private e fbF;
    private h.c fbH;
    private final EnterForumFragment fbx;
    private com.baidu.tieba.enterForum.a.a fby;
    private com.baidu.tieba.enterForum.multiConcern.a fbz;
    private Context mContext;
    private i mPullView;
    private View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private boolean isFirst = true;
    private boolean fbG = true;
    private h.c drD = new h.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            com.baidu.tieba.q.c.coo().x(b.this.fbx.getUniqueId());
            if (b.this.fbH != null) {
                b.this.fbH.er(z);
            }
            if (z && !b.this.eVV && b.this.eVt != null && b.this.eVt.eVV) {
                if (b.this.eVt.eVX > 0) {
                    b.this.eeF.smoothScrollToPosition(0, 0, 0);
                    b.this.bgS();
                    return;
                }
                b.this.eeF.smoothScrollToPosition(0, 0, 0);
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.4
        private int dpp = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.fbF.onScrollStateChanged(absListView, i);
            if (this.dpp != i) {
                this.dpp = i;
                if (this.dpp == 1) {
                    if ((b.this.eVt == null || !b.this.eVt.eVV) && b.this.fbx != null && b.this.fbx.bfK() != null) {
                        b.this.fbx.bfK().aJu();
                    }
                    b.this.bgW();
                    return;
                }
                b.this.bgP();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.fbx.isPrimary() && this.dpp != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.eeF.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.eeF.getItemAtPosition(i4) == v.c(b.this.fbA, 0)) {
                            b.this.a(dVar, b.this.eeF.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.fbF.onScroll(absListView, i, i2, i3);
        }
    };
    c.a fbi = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.5
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void bgc() {
            b.this.bgP();
        }
    };
    private int fbI = 0;
    private int fbJ = 0;
    boolean eVV = false;
    boolean fbK = false;
    private Runnable fbL = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.9
        @Override // java.lang.Runnable
        public void run() {
            b.this.bgT();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bgP() {
        if (bgQ()) {
            if (this.fbx != null && this.fbx.bfK() != null) {
                this.fbx.bfK().aJv();
            }
        } else if ((this.eVt == null || !this.eVt.eVV) && this.fbx != null && this.fbx.bfK() != null) {
            this.fbx.bfK().aJu();
        }
    }

    private boolean bgQ() {
        return this.eeF == null || this.eeF.getChildCount() == 0 || this.eeF.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.fbx = enterForumFragment;
        this.eVo = viewEventCenter;
        this.fbz = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bM(view);
        this.fby = new com.baidu.tieba.enterForum.a.a(this.fbx.getPageContext(), this.eVo, recentlyVisitedForumModel, enterForumModel, this);
        this.eeF.setAdapter((ListAdapter) this.fby);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bM(View view) {
        this.mContext = view.getContext();
        this.fbF = new e();
        this.fbF.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (b.this.eVV) {
                    b.this.bgT();
                } else if (b.this.eVt != null && b.this.eVt.eVV) {
                    b.this.fbI = -i;
                    b.this.bgR();
                }
            }
        });
        this.eeF = (BdListView) view.findViewById(R.id.listview);
        qI(0);
        this.eeF.setBackgroundColor(0);
        this.eeF.setVerticalScrollBarEnabled(false);
        this.eeF.setOnScrollListener(this.mOnScrollListener);
        this.eeF.setFastScrollEnabled(false);
        this.eeF.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.fbx != null && this.fbx.bfK() != null) {
            this.fbx.bfK().b(this.fbi);
            this.fbx.bfK().a(this.fbi);
            this.fbx.bfK().a(this);
        }
        this.mPullView = new i(this.fbx.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                if (!b.this.eVV && b.this.eVt != null && b.this.eVt.eVV) {
                    b.this.fbJ = i3;
                    b.this.bgR();
                }
            }
        });
        this.mPullView.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EnterForumAdView.a(b.this.fbx.getPageContext().getUniqueId(), b.this.fbx.getPageContext().getPageActivity());
            }
        });
        this.mPullView.setListPullRefreshListener(this.drD);
        this.mPullView.et(true);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.fbx.getUniqueId());
        }
        this.eeF.setPullRefresh(this.mPullView);
        this.faF = new ForumHeaderView(this.fbx.getFragmentActivity());
        this.eeF.addHeaderView(this.faF);
        this.euX = new View(this.fbx.getActivity());
        this.euX.setLayoutParams(new AbsListView.LayoutParams(-1, l.g(this.fbx.getActivity(), R.dimen.ds50)));
        this.euX.setBackgroundResource(R.color.cp_bg_line_d);
    }

    public void bN(View view) {
        this.fbC = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.fbC != null) {
            bgR();
            this.fbC.setTag(this.fbx.getUniqueId());
            this.fbC.setAdData();
            this.fbC.setEventCenter(this.eVo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgR() {
        if (this.fbC != null) {
            ViewGroup.LayoutParams layoutParams = this.fbC.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.eVV ? 0 : (this.fbI + this.fbJ) - dimensionPixelOffset, 0, 0);
                this.fbC.setLayoutParams(layoutParams2);
                this.fbC.setAdViewHeight(layoutParams2.height - dimensionPixelOffset);
            }
        }
    }

    public void bgS() {
        this.eVV = true;
        bgR();
        qI(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.ob());
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fbL);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.fbL, 3000L);
    }

    private void qI(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eeF.getLayoutParams();
        marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + i + this.eeF.getResources().getDimensionPixelOffset(R.dimen.tbds140);
        this.eeF.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgT() {
        this.eVV = false;
        bgR();
        qI(0);
        if (this.fbK) {
            this.eeF.completePullRefreshPostDelayed(0L);
        }
        this.fbK = false;
    }

    public void bO(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(this.fbx.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.faF != null) {
                        b.this.faF.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.qN(this.fbx.getString(R.string.neterror));
        this.mRootView = view;
        int dimensionPixelSize = this.fbx.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize += UtilHelper.getStatusBarHeight();
        }
        this.refreshView.kL(dimensionPixelSize);
        this.refreshView.attachView(view, false);
        this.refreshView.atI();
        this.eeF.setVisibility(8);
        if (this.fbx.bfK() != null) {
            this.fbx.bfK().bfZ();
            this.fbx.bfK().bga();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.eeF.setVisibility(0);
        if (this.fbx.bfK() != null) {
            this.fbx.bfK().bfZ();
            this.fbx.bfK().bga();
        }
    }

    public boolean isEmpty() {
        return v.aa(this.fbA);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.fbA.remove(fVar);
        j(this.fbA, z);
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.m.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView bgU() {
        return this.eeF;
    }

    public void startPullRefresh() {
        this.eeF.startPullRefresh();
    }

    public void oT() {
        if (this.eVV) {
            this.fbK = true;
            return;
        }
        this.fbK = false;
        this.eeF.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.fby.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.fbC.setAdData();
        this.fbA = list;
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
        this.fby.setData(arrayList);
        this.faF.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.eeF.removeFooterView(this.euX);
            this.eeF.addFooterView(this.euX);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.eeF.removeFooterView(this.euX);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.faF != null) {
            this.faF.onChangeSkinType();
        }
        if (this.fbz.bgt() != null) {
            this.fbz.onChangeSkinType();
        }
        am.k(this.euX, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.fbH = cVar;
    }

    public void setSearchHint(String str) {
        if (this.faF != null) {
            this.faF.setSearchHint(str);
        }
    }

    public void bgV() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("enter_forum_login_tip", true) && this.fbx != null && this.fbx.getActivity() != null && this.fbx.bfJ() != null) {
            if (this.fbB == null) {
                this.fbB = new CommonTipView(this.fbx.getActivity());
            }
            this.fbB.setText(R.string.enter_forum_login_tip);
            this.fbB.show(this.fbx.bfJ(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.fbx.isAdded() && this.fbx.isPrimary()) {
            this.fbC.setAdData();
            fbD = false;
            if (this.fby != null) {
                this.fby.onPrimary();
                if (this.eeF != null) {
                    Object itemAtPosition = this.eeF.getItemAtPosition(this.eeF.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.fby.bfc();
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
        bgW();
    }

    public void onPause() {
        bgW();
    }

    public void onDestroy() {
        if (this.fbB != null) {
            this.fbB.onDestroy();
        }
        if (this.fbz != null) {
            this.fbz.onDestroy();
        }
        if (this.fby != null) {
            this.fby.onDestroy();
        }
        if (this.fbx != null && this.fbx.bfK() != null) {
            this.fbx.bfK().b(this.fbi);
        }
    }

    public void qt(int i) {
        this.fby.qt(i);
    }

    public void bK(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.fbz.isShowing() && !v.aa(list)) {
            this.fbz.bG(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fby != null) {
            this.fby.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bfb() {
        if (this.fby == null) {
            return false;
        }
        return this.fby.bfb();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !fbD && this.fbx.getActivity() != null && this.fbx.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bfr() != 0 && !com.baidu.tbadk.core.sharedPref.b.ahO().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.fbE = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.ahO().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.fbE = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                fbD = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).X(0).U(true).V(false).T(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.11
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.fbE);
                        b.this.fbx.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                this.eLO = dVar2.hV();
                this.eLO.R(false);
                this.eLO.S(true);
                this.eLO.q(this.fbx.getActivity());
                if (this.fbE == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.fbE == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.eLO != null) {
                            b.this.eLO.dismiss();
                            b.this.eLO = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void bgW() {
        if (this.eLO != null) {
            this.eLO.dismiss();
            this.eLO = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eVt = bVar;
        if (this.fby != null) {
            this.fby.setAdState(bVar);
        }
        if (this.faF != null) {
            this.faF.setAdState(bVar);
        }
    }

    public void jv(boolean z) {
        if (this.fbG != z) {
            this.fbG = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eeF.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.eeF.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.eeF.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.eeF.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.fbC != null) {
            this.fbC.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.fbC != null) {
            this.fbC.setRecentlyIsShow(z);
        }
    }
}
