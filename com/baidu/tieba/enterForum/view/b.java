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
    private static boolean eGM = false;
    private BdListView dQr;
    private ViewEventCenter eAZ;
    private ForumHeaderView eFX;
    private final EnterForumFragment eGH;
    private com.baidu.tieba.enterForum.a.a eGI;
    private com.baidu.tieba.enterForum.multiConcern.a eGJ;
    private List<com.baidu.tieba.enterForum.data.d> eGK;
    private CommonTipView eGL;
    private int eGN;
    private View eoO;
    private com.baidu.adp.lib.guide.c ery;
    private Context mContext;
    private i mPullView;
    private View mRootView;
    private h refreshView;
    AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.view.b.1
        private int dcH = -1;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (this.dcH != i) {
                this.dcH = i;
                if (this.dcH == 1) {
                    if (b.this.eGH != null && b.this.eGH.aWx() != null) {
                        b.this.eGH.aWx().aBE();
                    }
                    b.this.aXC();
                    return;
                }
                b.this.aXy();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.eGH.isPrimary() && this.dcH != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.dQr.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.b)) {
                        com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) itemAtPosition;
                        if (bVar.getType() == 1) {
                            b.this.a(b.this.eGI.aVV(), bVar);
                        }
                    }
                }
            }
        }
    };
    c.a eGz = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.2
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void aWL() {
            b.this.aXy();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (aXz()) {
            if (this.eGH != null && this.eGH.aWx() != null) {
                this.eGH.aWx().aBF();
            }
        } else if (this.eGH != null && this.eGH.aWx() != null) {
            this.eGH.aWx().aBE();
        }
    }

    private boolean aXz() {
        return this.dQr == null || this.dQr.getChildCount() == 0 || this.dQr.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.eGH = enterForumFragment;
        this.eAZ = viewEventCenter;
        this.eGJ = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bD(view);
        this.eGI = new com.baidu.tieba.enterForum.a.a(this.eGH.getPageContext(), this.eAZ, recentlyVisitedForumModel, enterForumModel);
        this.dQr.setAdapter((ListAdapter) this.eGI);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bD(View view) {
        this.mContext = view.getContext();
        this.dQr = (BdListView) view.findViewById(d.g.listview);
        this.dQr.setVerticalScrollBarEnabled(false);
        this.dQr.setOnScrollListener(this.mOnScrollListener);
        if (this.eGH != null && this.eGH.aWx() != null) {
            this.eGH.aWx().b(this.eGz);
            this.eGH.aWx().a(this.eGz);
        }
        this.mPullView = new i(this.eGH.getPageContext());
        if (this.mPullView != null) {
            this.mPullView.setTag(this.eGH.getUniqueId());
        }
        this.dQr.setPullRefresh(this.mPullView);
        this.eFX = new ForumHeaderView(this.eGH.getFragmentActivity());
        this.dQr.addHeaderView(this.eFX);
        this.eoO = new View(this.eGH.getActivity());
        this.eoO.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.eGH.getActivity(), d.e.ds0)));
    }

    public void bE(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.eGH.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.eFX != null) {
                        b.this.eFX.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.po(this.eGH.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.anB();
        this.dQr.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.dQr.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.T(this.eGK);
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, boolean z) {
        this.eGK.remove(dVar);
        j(this.eGK, z);
        notifyDataSetChanged();
    }

    public BdListView aXA() {
        return this.dQr;
    }

    public void startPullRefresh() {
        this.dQr.startPullRefresh();
    }

    public void pD() {
        this.dQr.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.eGI.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.d> list, boolean z) {
        this.eGK = list;
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
        this.eGI.setData(arrayList);
        this.eFX.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.dQr.removeFooterView(this.eoO);
            this.dQr.addFooterView(this.eoO);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.dQr.removeFooterView(this.eoO);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.eFX != null) {
            this.eFX.onChangeSkinType();
        }
        if (this.eGJ.aXb() != null) {
            this.eGJ.onChangeSkinType();
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setSearchHint(String str) {
        if (this.eFX != null) {
            this.eFX.setSearchHint(str);
        }
    }

    public void aXB() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true) && this.eGH != null && this.eGH.getActivity() != null && this.eGH.aWw() != null) {
            if (this.eGL == null) {
                this.eGL = new CommonTipView(this.eGH.getActivity());
            }
            this.eGL.setText(d.j.enter_forum_login_tip);
            this.eGL.show(this.eGH.aWw(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.eGH.isAdded() && this.eGH.isPrimary()) {
            eGM = false;
            if (this.eGI != null) {
                this.eGI.onPrimary();
                if (this.dQr != null) {
                    Object itemAtPosition = this.dQr.getItemAtPosition(this.dQr.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.b) && ((com.baidu.tieba.enterForum.data.b) itemAtPosition).getType() == 5) {
                        this.eGI.aVX();
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        aXC();
    }

    public void onPause() {
        aXC();
    }

    public void onDestroy() {
        if (this.eGL != null) {
            this.eGL.onDestroy();
        }
        if (this.eGJ != null) {
            this.eGJ.onDestroy();
        }
        if (this.eGI != null) {
            this.eGI.onDestroy();
        }
        if (this.eGH != null && this.eGH.aWx() != null) {
            this.eGH.aWx().b(this.eGz);
        }
    }

    public void pb(int i) {
        this.eGI.pb(i);
    }

    public void bC(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.eGJ.isShowing() && !v.T(list)) {
            this.eGJ.by(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eGI != null) {
            this.eGI.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean aVW() {
        if (this.eGI == null) {
            return false;
        }
        return this.eGI.aVW();
    }

    public void a(final int i, com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && !eGM && this.eGH.getActivity() != null && this.eGH.getPageContext() != null && (bVar instanceof com.baidu.tieba.enterForum.data.d)) {
            com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) bVar;
            if (dVar.isPrivateForum() != 0 && dVar.aWm() != 0 && !com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_new_forum_long_press_guide", "").equals(dVar.getId())) {
                this.eGN = d.j.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.eGN = d.j.forum_item_guide_tip;
            } else {
                return;
            }
            ObservedChangeLinearLayout aWw = this.eGH.aWw();
            if (aWw != null) {
                eGM = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(aWw).af(0).ac(true).ad(false).ab(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(b.this.eGN);
                        b.this.eGH.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return l.h(b.this.eGH.getPageContext().getPageActivity(), d.e.tbds180);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return l.h(b.this.eGH.getPageContext().getPageActivity(), d.e.tbds400) + i;
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
                this.ery = dVar2.iT();
                this.ery.Z(false);
                this.ery.aa(true);
                this.ery.n(this.eGH.getActivity());
                if (this.eGN == d.j.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("enter_forum_new_forum_long_press_guide", dVar.getId());
                } else if (this.eGN == d.j.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.ery != null) {
                            b.this.ery.dismiss();
                            b.this.ery = null;
                        }
                    }
                }, 5000L);
            }
        }
    }

    public void aXC() {
        if (this.ery != null) {
            this.ery.dismiss();
            this.ery = null;
        }
    }
}
