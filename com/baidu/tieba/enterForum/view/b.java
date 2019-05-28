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
import com.baidu.tbadk.core.util.al;
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
    private static boolean eWC = false;
    private com.baidu.adp.lib.guide.c eGS;
    private ViewEventCenter eQo;
    private com.baidu.tieba.enterForum.data.b eQt;
    private ForumHeaderView eVE;
    private CommonTipView eWA;
    private EnterForumAdView eWB;
    private int eWD;
    private e eWE;
    private h.c eWG;
    private final EnterForumFragment eWw;
    private com.baidu.tieba.enterForum.a.a eWx;
    private com.baidu.tieba.enterForum.multiConcern.a eWy;
    private List<com.baidu.tieba.enterForum.data.f> eWz;
    private BdListView eaj;
    private View epZ;
    private Context mContext;
    private i mPullView;
    private View mRootView;
    private com.baidu.tbadk.m.h refreshView;
    private boolean isFirst = true;
    private boolean eWF = true;
    private h.c dpv = new h.c() { // from class: com.baidu.tieba.enterForum.view.b.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            com.baidu.tieba.q.c.clv().x(b.this.eWw.getUniqueId());
            if (b.this.eWG != null) {
                b.this.eWG.en(z);
            }
            if (z && !b.this.eQV && b.this.eQt != null && b.this.eQt.eQV) {
                if (b.this.eQt.eQX > 0) {
                    b.this.eaj.smoothScrollToPosition(0, 0, 0);
                    b.this.beP();
                    return;
                }
                b.this.eaj.smoothScrollToPosition(0, 0, 0);
            }
        }
    };
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.4
        private int dnp = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            b.this.eWE.onScrollStateChanged(absListView, i);
            if (this.dnp != i) {
                this.dnp = i;
                if (this.dnp == 1) {
                    if ((b.this.eQt == null || !b.this.eQt.eQV) && b.this.eWw != null && b.this.eWw.bdI() != null) {
                        b.this.eWw.bdI().aHU();
                    }
                    b.this.beT();
                    return;
                }
                b.this.beM();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.eWw.isPrimary() && this.dnp != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.eaj.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d)) {
                        com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) itemAtPosition;
                        if (dVar.getType() == 1 && b.this.eaj.getItemAtPosition(i4) == v.c(b.this.eWz, 0)) {
                            b.this.a(dVar, b.this.eaj.getChildAt(i4).findViewById(R.id.forum_intro));
                        }
                    }
                }
            }
            b.this.eWE.onScroll(absListView, i, i2, i3);
        }
    };
    c.a eWh = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.5
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void bdZ() {
            b.this.beM();
        }
    };
    private int eWH = 0;
    private int eWI = 0;
    boolean eQV = false;
    boolean eWJ = false;
    private Runnable eWK = new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.9
        @Override // java.lang.Runnable
        public void run() {
            b.this.beQ();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void beM() {
        if (beN()) {
            if (this.eWw != null && this.eWw.bdI() != null) {
                this.eWw.bdI().aHV();
            }
        } else if ((this.eQt == null || !this.eQt.eQV) && this.eWw != null && this.eWw.bdI() != null) {
            this.eWw.bdI().aHU();
        }
    }

    private boolean beN() {
        return this.eaj == null || this.eaj.getChildCount() == 0 || this.eaj.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.eWw = enterForumFragment;
        this.eQo = viewEventCenter;
        this.eWy = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bK(view);
        this.eWx = new com.baidu.tieba.enterForum.a.a(this.eWw.getPageContext(), this.eQo, recentlyVisitedForumModel, enterForumModel, this);
        this.eaj.setAdapter((ListAdapter) this.eWx);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bK(View view) {
        this.mContext = view.getContext();
        this.eWE = new e();
        this.eWE.a(new e.b() { // from class: com.baidu.tieba.enterForum.view.b.6
            @Override // com.baidu.tieba.enterForum.view.e.b
            public void a(AbsListView absListView, int i, int i2) {
                if (b.this.eQV) {
                    b.this.beQ();
                } else if (b.this.eQt != null && b.this.eQt.eQV) {
                    b.this.eWH = -i;
                    b.this.beO();
                }
            }
        });
        this.eaj = (BdListView) view.findViewById(R.id.listview);
        qq(0);
        this.eaj.setBackgroundColor(0);
        this.eaj.setVerticalScrollBarEnabled(false);
        this.eaj.setOnScrollListener(this.mOnScrollListener);
        this.eaj.setFastScrollEnabled(false);
        this.eaj.setMaxHeight(this.mContext.getResources().getDisplayMetrics().heightPixels);
        if (this.eWw != null && this.eWw.bdI() != null) {
            this.eWw.bdI().b(this.eWh);
            this.eWw.bdI().a(this.eWh);
            this.eWw.bdI().a(this);
        }
        this.mPullView = new i(this.eWw.getPageContext());
        this.mPullView.a(new c.a() { // from class: com.baidu.tieba.enterForum.view.b.7
            @Override // com.baidu.adp.widget.ListView.c.a
            public void a(com.baidu.adp.widget.ListView.c cVar, int i, int i2, int i3, int i4) {
                if (!b.this.eQV && b.this.eQt != null && b.this.eQt.eQV) {
                    b.this.eWI = i3;
                    b.this.beO();
                }
            }
        });
        this.mPullView.getView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EnterForumAdView.a(b.this.eWw.getPageContext().getUniqueId(), b.this.eWw.getPageContext().getPageActivity());
            }
        });
        this.mPullView.setListPullRefreshListener(this.dpv);
        this.mPullView.ep(true);
        if (this.mPullView != null) {
            this.mPullView.setTag(this.eWw.getUniqueId());
        }
        this.eaj.setPullRefresh(this.mPullView);
        this.eVE = new ForumHeaderView(this.eWw.getFragmentActivity());
        this.eaj.addHeaderView(this.eVE);
        this.epZ = new View(this.eWw.getActivity());
        this.epZ.setLayoutParams(new AbsListView.LayoutParams(-1, l.g(this.eWw.getActivity(), R.dimen.ds50)));
        this.epZ.setBackgroundResource(R.color.cp_bg_line_d);
    }

    public void bL(View view) {
        this.eWB = (EnterForumAdView) view.getRootView().findViewById(R.id.enter_forum_ad);
        if (this.eWB != null) {
            beO();
            this.eWB.setTag(this.eWw.getUniqueId());
            this.eWB.setAdData();
            this.eWB.setEventCenter(this.eQo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beO() {
        if (this.eWB != null) {
            ViewGroup.LayoutParams layoutParams = this.eWB.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, this.eQV ? 0 : (this.eWH + this.eWI) - dimensionPixelOffset, 0, 0);
                this.eWB.setLayoutParams(layoutParams2);
                this.eWB.setAdViewHeight(layoutParams2.height - dimensionPixelOffset);
            }
        }
    }

    public void beP() {
        this.eQV = true;
        beO();
        qq(this.mContext.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.mPullView.nI());
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.eWK);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.eWK, 3000L);
    }

    private void qq(int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eaj.getLayoutParams();
        marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + i + this.eaj.getResources().getDimensionPixelOffset(R.dimen.tbds140);
        this.eaj.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beQ() {
        this.eQV = false;
        beO();
        qq(0);
        if (this.eWJ) {
            this.eaj.completePullRefreshPostDelayed(0L);
        }
        this.eWJ = false;
    }

    public void bM(View view) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.m.h(this.eWw.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.eVE != null) {
                        b.this.eVE.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.qx(this.eWw.getString(R.string.neterror));
        this.mRootView = view;
        int dimensionPixelSize = this.eWw.getResources().getDimensionPixelSize(R.dimen.ds88);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelSize += UtilHelper.getStatusBarHeight();
        }
        this.refreshView.kF(dimensionPixelSize);
        this.refreshView.attachView(view, false);
        this.refreshView.asB();
        this.eaj.setVisibility(8);
        if (this.eWw.bdI() != null) {
            this.eWw.bdI().bdW();
            this.eWw.bdI().bdX();
        }
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.eaj.setVisibility(0);
        if (this.eWw.bdI() != null) {
            this.eWw.bdI().bdW();
            this.eWw.bdI().bdX();
        }
    }

    public boolean isEmpty() {
        return v.aa(this.eWz);
    }

    public void a(com.baidu.tieba.enterForum.data.f fVar, boolean z) {
        this.eWz.remove(fVar);
        i(this.eWz, z);
        notifyDataSetChanged();
    }

    public com.baidu.tbadk.m.h getRefreshView() {
        return this.refreshView;
    }

    public BdListView beR() {
        return this.eaj;
    }

    public void startPullRefresh() {
        this.eaj.startPullRefresh();
    }

    public void oy() {
        if (this.eQV) {
            this.eWJ = true;
            return;
        }
        this.eWJ = false;
        this.eaj.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.eWx.notifyDataSetChanged();
    }

    public void i(List<com.baidu.tieba.enterForum.data.f> list, boolean z) {
        this.eWB.setAdData();
        this.eWz = list;
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
        this.eWx.setData(arrayList);
        this.eVE.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.eaj.removeFooterView(this.epZ);
            this.eaj.addFooterView(this.epZ);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.eaj.removeFooterView(this.epZ);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.eVE != null) {
            this.eVE.onChangeSkinType();
        }
        if (this.eWy.beq() != null) {
            this.eWy.onChangeSkinType();
        }
        al.k(this.epZ, R.color.cp_bg_line_d);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.eWG = cVar;
    }

    public void setSearchHint(String str) {
        if (this.eVE != null) {
            this.eVE.setSearchHint(str);
        }
    }

    public void beS() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("enter_forum_login_tip", true) && this.eWw != null && this.eWw.getActivity() != null && this.eWw.bdH() != null) {
            if (this.eWA == null) {
                this.eWA = new CommonTipView(this.eWw.getActivity());
            }
            this.eWA.setText(R.string.enter_forum_login_tip);
            this.eWA.show(this.eWw.bdH(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.eWw.isAdded() && this.eWw.isPrimary()) {
            this.eWB.setAdData();
            eWC = false;
            if (this.eWx != null) {
                this.eWx.onPrimary();
                if (this.eaj != null) {
                    Object itemAtPosition = this.eaj.getItemAtPosition(this.eaj.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.d) && ((com.baidu.tieba.enterForum.data.d) itemAtPosition).getType() == 5) {
                        this.eWx.bda();
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
        beT();
    }

    public void onPause() {
        beT();
    }

    public void onDestroy() {
        if (this.eWA != null) {
            this.eWA.onDestroy();
        }
        if (this.eWy != null) {
            this.eWy.onDestroy();
        }
        if (this.eWx != null) {
            this.eWx.onDestroy();
        }
        if (this.eWw != null && this.eWw.bdI() != null) {
            this.eWw.bdI().b(this.eWh);
        }
    }

    public void qb(int i) {
        this.eWx.qb(i);
    }

    public void bI(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.eWy.isShowing() && !v.aa(list)) {
            this.eWy.bE(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eWx != null) {
            this.eWx.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean bcZ() {
        if (this.eWx == null) {
            return false;
        }
        return this.eWx.bcZ();
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, View view) {
        if (TbadkCoreApplication.isLogin() && !eWC && this.eWw.getActivity() != null && this.eWw.getPageContext() != null && (dVar instanceof com.baidu.tieba.enterForum.data.f)) {
            com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
            if (fVar.isPrivateForum() != 0 && fVar.bdp() != 0 && !com.baidu.tbadk.core.sharedPref.b.agM().getString("enter_forum_new_forum_long_press_guide", "").equals(fVar.getId())) {
                this.eWD = R.string.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.agM().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.eWD = R.string.forum_item_guide_tip;
            } else {
                return;
            }
            if (view != null) {
                eWC = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(view).X(0).U(true).V(false).T(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.11
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(R.id.tips)).setText(b.this.eWD);
                        b.this.eWw.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hJ() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int hK() {
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
                this.eGS = dVar2.hL();
                this.eGS.R(false);
                this.eGS.S(true);
                this.eGS.n(this.eWw.getActivity());
                if (this.eWD == R.string.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putString("enter_forum_new_forum_long_press_guide", fVar.getId());
                } else if (this.eWD == R.string.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.eGS != null) {
                            b.this.eGS.dismiss();
                            b.this.eGS = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void beT() {
        if (this.eGS != null) {
            this.eGS.dismiss();
            this.eGS = null;
        }
    }

    public void setAdState(com.baidu.tieba.enterForum.data.b bVar) {
        this.eQt = bVar;
        if (this.eWx != null) {
            this.eWx.setAdState(bVar);
        }
        if (this.eVE != null) {
            this.eVE.setAdState(bVar);
        }
    }

    public void jl(boolean z) {
        if (this.eWF != z) {
            this.eWF = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eaj.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.eaj.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.eaj.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.eaj.setLayoutParams(marginLayoutParams);
        }
    }

    public void setRecentlyIsExtend(boolean z) {
        if (this.eWB != null) {
            this.eWB.setRecentlyIsExtend(z);
        }
    }

    public void setRecentlyIsShow(boolean z) {
        if (this.eWB != null) {
            this.eWB.setRecentlyIsShow(z);
        }
    }
}
