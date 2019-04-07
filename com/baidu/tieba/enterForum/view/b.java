package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.guide.d;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.home.c;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private static boolean eGy = false;
    private BdListView dPI;
    private ViewEventCenter eAK;
    private ForumHeaderView eFI;
    private final EnterForumFragment eGt;
    private com.baidu.tieba.enterForum.a.a eGu;
    private com.baidu.tieba.enterForum.multiConcern.a eGv;
    private List<com.baidu.tieba.enterForum.data.d> eGw;
    private CommonTipView eGx;
    private int eGz;
    private View eoA;
    private com.baidu.adp.lib.guide.c erj;
    private Context mContext;
    private i mPullView;
    private View mRootView;
    private h refreshView;
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.1
        private int dcL = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (this.dcL != i) {
                this.dcL = i;
                if (this.dcL == 1) {
                    if (b.this.eGt != null && b.this.eGt.aWv() != null) {
                        b.this.eGt.aWv().aBB();
                    }
                    b.this.aXz();
                    return;
                }
                b.this.aXv();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.eGt.isPrimary() && this.dcL != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.dPI.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.b)) {
                        com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) itemAtPosition;
                        if (bVar.getType() == 1) {
                            b.this.a(b.this.eGu.aVT(), bVar);
                        }
                    }
                }
            }
        }
    };
    c.a eGl = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.2
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void aWJ() {
            b.this.aXv();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        if (aXw()) {
            if (this.eGt != null && this.eGt.aWv() != null) {
                this.eGt.aWv().aBC();
            }
        } else if (this.eGt != null && this.eGt.aWv() != null) {
            this.eGt.aWv().aBB();
        }
    }

    private boolean aXw() {
        return this.dPI == null || this.dPI.getChildCount() == 0 || this.dPI.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.eGt = enterForumFragment;
        this.eAK = viewEventCenter;
        this.eGv = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bD(view);
        this.eGu = new com.baidu.tieba.enterForum.a.a(this.eGt.getPageContext(), this.eAK, recentlyVisitedForumModel, enterForumModel);
        this.dPI.setAdapter((ListAdapter) this.eGu);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bD(View view) {
        this.mContext = view.getContext();
        this.dPI = (BdListView) view.findViewById(d.g.listview);
        this.dPI.setVerticalScrollBarEnabled(false);
        this.dPI.setOnScrollListener(this.mOnScrollListener);
        if (this.eGt != null && this.eGt.aWv() != null) {
            this.eGt.aWv().b(this.eGl);
            this.eGt.aWv().a(this.eGl);
        }
        this.mPullView = new i(this.eGt.getPageContext());
        if (this.mPullView != null) {
            this.mPullView.setTag(this.eGt.getUniqueId());
        }
        this.dPI.setPullRefresh(this.mPullView);
        this.eFI = new ForumHeaderView(this.eGt.getFragmentActivity());
        this.dPI.addHeaderView(this.eFI);
        this.eoA = new View(this.eGt.getActivity());
        this.eoA.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.eGt.getActivity(), d.e.ds0)));
    }

    public void bE(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.eGt.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.eFI != null) {
                        b.this.eFI.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.pp(this.eGt.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.any();
        this.dPI.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.dPI.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.T(this.eGw);
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, boolean z) {
        this.eGw.remove(dVar);
        j(this.eGw, z);
        notifyDataSetChanged();
    }

    public BdListView aXx() {
        return this.dPI;
    }

    public void startPullRefresh() {
        this.dPI.startPullRefresh();
    }

    public void pD() {
        this.dPI.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.eGu.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.d> list, boolean z) {
        this.eGw = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.b bVar = new com.baidu.tieba.enterForum.data.b();
        bVar.setType(4);
        arrayList.add(bVar);
        arrayList.add(new com.baidu.tieba.enterForum.data.c(this.mContext.getResources().getString(d.j.my_attention_bar), !v.T(list)));
        arrayList.addAll(list);
        if (v.T(list)) {
            com.baidu.tieba.enterForum.data.b bVar2 = new com.baidu.tieba.enterForum.data.b();
            bVar2.setType(3);
            arrayList.add(bVar2);
        }
        if (z) {
            com.baidu.tieba.enterForum.data.b bVar3 = new com.baidu.tieba.enterForum.data.b();
            bVar3.setType(5);
            arrayList.add(bVar3);
        }
        hideNoDataView();
        this.eGu.setData(arrayList);
        this.eFI.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.dPI.removeFooterView(this.eoA);
            this.dPI.addFooterView(this.eoA);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.dPI.removeFooterView(this.eoA);
        }
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.eFI != null) {
            this.eFI.onChangeSkinType();
        }
        if (this.eGv.aWZ() != null) {
            this.eGv.onChangeSkinType();
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setSearchHint(String str) {
        if (this.eFI != null) {
            this.eFI.setSearchHint(str);
        }
    }

    public void aXy() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true) && this.eGt != null && this.eGt.getActivity() != null && this.eGt.aWu() != null) {
            if (this.eGx == null) {
                this.eGx = new CommonTipView(this.eGt.getActivity());
            }
            this.eGx.setText(d.j.enter_forum_login_tip);
            this.eGx.show(this.eGt.aWu(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.eGt.isAdded() && this.eGt.isPrimary()) {
            eGy = false;
            if (this.eGu != null) {
                this.eGu.onPrimary();
                if (this.dPI != null) {
                    Object itemAtPosition = this.dPI.getItemAtPosition(this.dPI.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.b) && ((com.baidu.tieba.enterForum.data.b) itemAtPosition).getType() == 5) {
                        this.eGu.aVV();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        aXz();
    }

    public void onPause() {
        aXz();
    }

    public void onDestroy() {
        if (this.eGx != null) {
            this.eGx.onDestroy();
        }
        if (this.eGv != null) {
            this.eGv.onDestroy();
        }
        if (this.eGu != null) {
            this.eGu.onDestroy();
        }
        if (this.eGt != null && this.eGt.aWv() != null) {
            this.eGt.aWv().b(this.eGl);
        }
    }

    public void oX(int i) {
        this.eGu.oX(i);
    }

    public void bA(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.eGv.isShowing() && !v.T(list)) {
            this.eGv.bw(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eGu != null) {
            this.eGu.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean aVU() {
        if (this.eGu == null) {
            return false;
        }
        return this.eGu.aVU();
    }

    public void a(final int i, com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && !eGy && this.eGt.getActivity() != null && this.eGt.getPageContext() != null && (bVar instanceof com.baidu.tieba.enterForum.data.d)) {
            com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) bVar;
            if (dVar.isPrivateForum() != 0 && dVar.aWk() != 0 && !com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_new_forum_long_press_guide", "").equals(dVar.getId())) {
                this.eGz = d.j.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.eGz = d.j.forum_item_guide_tip;
            } else {
                return;
            }
            ObservedChangeLinearLayout aWu = this.eGt.aWu();
            if (aWu != null) {
                eGy = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(aWu).ae(0).ac(true).ad(false).ab(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(b.this.eGz);
                        b.this.eGt.getPageContext().getLayoutMode().onModeChanged(inflate);
                        return inflate;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iR() {
                        return 4;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int iS() {
                        return 16;
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getXOffset() {
                        return l.h(b.this.eGt.getPageContext().getPageActivity(), d.e.tbds180);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return l.h(b.this.eGt.getPageContext().getPageActivity(), d.e.tbds400) + i;
                    }
                });
                dVar2.b(new d.a() { // from class: com.baidu.tieba.enterForum.view.b.5
                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onShown() {
                    }

                    @Override // com.baidu.adp.lib.guide.d.a
                    public void onDismiss() {
                    }
                });
                this.erj = dVar2.iT();
                this.erj.Z(false);
                this.erj.aa(true);
                this.erj.n(this.eGt.getActivity());
                if (this.eGz == d.j.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("enter_forum_new_forum_long_press_guide", dVar.getId());
                } else if (this.eGz == d.j.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.erj != null) {
                            b.this.erj.dismiss();
                            b.this.erj = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void aXz() {
        if (this.erj != null) {
            this.erj.dismiss();
            this.erj = null;
        }
    }
}
