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
    private static boolean eGz = false;
    private BdListView dPJ;
    private ViewEventCenter eAL;
    private ForumHeaderView eFJ;
    private int eGA;
    private final EnterForumFragment eGu;
    private com.baidu.tieba.enterForum.a.a eGv;
    private com.baidu.tieba.enterForum.multiConcern.a eGw;
    private List<com.baidu.tieba.enterForum.data.d> eGx;
    private CommonTipView eGy;
    private View eoB;
    private com.baidu.adp.lib.guide.c erk;
    private Context mContext;
    private i mPullView;
    private View mRootView;
    private h refreshView;
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.1
        private int dcM = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (this.dcM != i) {
                this.dcM = i;
                if (this.dcM == 1) {
                    if (b.this.eGu != null && b.this.eGu.aWv() != null) {
                        b.this.eGu.aWv().aBB();
                    }
                    b.this.aXz();
                    return;
                }
                b.this.aXv();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.eGu.isPrimary() && this.dcM != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.dPJ.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.b)) {
                        com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) itemAtPosition;
                        if (bVar.getType() == 1) {
                            b.this.a(b.this.eGv.aVT(), bVar);
                        }
                    }
                }
            }
        }
    };
    c.a eGm = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.2
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void aWJ() {
            b.this.aXv();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aXv() {
        if (aXw()) {
            if (this.eGu != null && this.eGu.aWv() != null) {
                this.eGu.aWv().aBC();
            }
        } else if (this.eGu != null && this.eGu.aWv() != null) {
            this.eGu.aWv().aBB();
        }
    }

    private boolean aXw() {
        return this.dPJ == null || this.dPJ.getChildCount() == 0 || this.dPJ.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.eGu = enterForumFragment;
        this.eAL = viewEventCenter;
        this.eGw = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bD(view);
        this.eGv = new com.baidu.tieba.enterForum.a.a(this.eGu.getPageContext(), this.eAL, recentlyVisitedForumModel, enterForumModel);
        this.dPJ.setAdapter((ListAdapter) this.eGv);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bD(View view) {
        this.mContext = view.getContext();
        this.dPJ = (BdListView) view.findViewById(d.g.listview);
        this.dPJ.setVerticalScrollBarEnabled(false);
        this.dPJ.setOnScrollListener(this.mOnScrollListener);
        if (this.eGu != null && this.eGu.aWv() != null) {
            this.eGu.aWv().b(this.eGm);
            this.eGu.aWv().a(this.eGm);
        }
        this.mPullView = new i(this.eGu.getPageContext());
        if (this.mPullView != null) {
            this.mPullView.setTag(this.eGu.getUniqueId());
        }
        this.dPJ.setPullRefresh(this.mPullView);
        this.eFJ = new ForumHeaderView(this.eGu.getFragmentActivity());
        this.dPJ.addHeaderView(this.eFJ);
        this.eoB = new View(this.eGu.getActivity());
        this.eoB.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.eGu.getActivity(), d.e.ds0)));
    }

    public void bE(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.eGu.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.eFJ != null) {
                        b.this.eFJ.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.pp(this.eGu.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.any();
        this.dPJ.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.dPJ.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.T(this.eGx);
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, boolean z) {
        this.eGx.remove(dVar);
        j(this.eGx, z);
        notifyDataSetChanged();
    }

    public BdListView aXx() {
        return this.dPJ;
    }

    public void startPullRefresh() {
        this.dPJ.startPullRefresh();
    }

    public void pD() {
        this.dPJ.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.eGv.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.d> list, boolean z) {
        this.eGx = list;
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
        this.eGv.setData(arrayList);
        this.eFJ.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.dPJ.removeFooterView(this.eoB);
            this.dPJ.addFooterView(this.eoB);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.dPJ.removeFooterView(this.eoB);
        }
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.eFJ != null) {
            this.eFJ.onChangeSkinType();
        }
        if (this.eGw.aWZ() != null) {
            this.eGw.onChangeSkinType();
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setSearchHint(String str) {
        if (this.eFJ != null) {
            this.eFJ.setSearchHint(str);
        }
    }

    public void aXy() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true) && this.eGu != null && this.eGu.getActivity() != null && this.eGu.aWu() != null) {
            if (this.eGy == null) {
                this.eGy = new CommonTipView(this.eGu.getActivity());
            }
            this.eGy.setText(d.j.enter_forum_login_tip);
            this.eGy.show(this.eGu.aWu(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.eGu.isAdded() && this.eGu.isPrimary()) {
            eGz = false;
            if (this.eGv != null) {
                this.eGv.onPrimary();
                if (this.dPJ != null) {
                    Object itemAtPosition = this.dPJ.getItemAtPosition(this.dPJ.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.b) && ((com.baidu.tieba.enterForum.data.b) itemAtPosition).getType() == 5) {
                        this.eGv.aVV();
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
        if (this.eGy != null) {
            this.eGy.onDestroy();
        }
        if (this.eGw != null) {
            this.eGw.onDestroy();
        }
        if (this.eGv != null) {
            this.eGv.onDestroy();
        }
        if (this.eGu != null && this.eGu.aWv() != null) {
            this.eGu.aWv().b(this.eGm);
        }
    }

    public void oX(int i) {
        this.eGv.oX(i);
    }

    public void bA(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.eGw.isShowing() && !v.T(list)) {
            this.eGw.bw(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eGv != null) {
            this.eGv.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean aVU() {
        if (this.eGv == null) {
            return false;
        }
        return this.eGv.aVU();
    }

    public void a(final int i, com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && !eGz && this.eGu.getActivity() != null && this.eGu.getPageContext() != null && (bVar instanceof com.baidu.tieba.enterForum.data.d)) {
            com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) bVar;
            if (dVar.isPrivateForum() != 0 && dVar.aWk() != 0 && !com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_new_forum_long_press_guide", "").equals(dVar.getId())) {
                this.eGA = d.j.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.eGA = d.j.forum_item_guide_tip;
            } else {
                return;
            }
            ObservedChangeLinearLayout aWu = this.eGu.aWu();
            if (aWu != null) {
                eGz = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(aWu).ae(0).ac(true).ad(false).ab(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(b.this.eGA);
                        b.this.eGu.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return l.h(b.this.eGu.getPageContext().getPageActivity(), d.e.tbds180);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return l.h(b.this.eGu.getPageContext().getPageActivity(), d.e.tbds400) + i;
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
                this.erk = dVar2.iT();
                this.erk.Z(false);
                this.erk.aa(true);
                this.erk.n(this.eGu.getActivity());
                if (this.eGA == d.j.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("enter_forum_new_forum_long_press_guide", dVar.getId());
                } else if (this.eGA == d.j.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.erk != null) {
                            b.this.erk.dismiss();
                            b.this.erk = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void aXz() {
        if (this.erk != null) {
            this.erk.dismiss();
            this.erk = null;
        }
    }
}
