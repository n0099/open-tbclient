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
import com.baidu.tbadk.TbConfig;
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
    private static boolean eGQ = false;
    private BdListView dQv;
    private ViewEventCenter eBd;
    private final EnterForumFragment eGL;
    private com.baidu.tieba.enterForum.a.a eGM;
    private com.baidu.tieba.enterForum.multiConcern.a eGN;
    private List<com.baidu.tieba.enterForum.data.d> eGO;
    private CommonTipView eGP;
    private int eGR;
    private ForumHeaderView eGb;
    private View eoS;
    private com.baidu.adp.lib.guide.c erC;
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
                    if (b.this.eGL != null && b.this.eGL.aWx() != null) {
                        b.this.eGL.aWx().aBE();
                    }
                    b.this.aXC();
                    return;
                }
                b.this.aXy();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (b.this.eGL.isPrimary() && this.dcL != 1 && i == 0) {
                for (int i4 = i; i4 < i + i2; i4++) {
                    Object itemAtPosition = b.this.dQv.getItemAtPosition(i4);
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.b)) {
                        com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) itemAtPosition;
                        if (bVar.getType() == 1) {
                            b.this.a(b.this.eGM.aVV(), bVar);
                        }
                    }
                }
            }
        }
    };
    c.a eGD = new c.a() { // from class: com.baidu.tieba.enterForum.view.b.2
        @Override // com.baidu.tieba.enterForum.home.c.a
        public void aWL() {
            b.this.aXy();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (aXz()) {
            if (this.eGL != null && this.eGL.aWx() != null) {
                this.eGL.aWx().aBF();
            }
        } else if (this.eGL != null && this.eGL.aWx() != null) {
            this.eGL.aWx().aBE();
        }
    }

    private boolean aXz() {
        return this.dQv == null || this.dQv.getChildCount() == 0 || this.dQv.getChildAt(0).getTop() == 0;
    }

    public b(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        this.eGL = enterForumFragment;
        this.eBd = viewEventCenter;
        this.eGN = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        bD(view);
        this.eGM = new com.baidu.tieba.enterForum.a.a(this.eGL.getPageContext(), this.eBd, recentlyVisitedForumModel, enterForumModel);
        this.dQv.setAdapter((ListAdapter) this.eGM);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bD(View view) {
        this.mContext = view.getContext();
        this.dQv = (BdListView) view.findViewById(d.g.listview);
        this.dQv.setVerticalScrollBarEnabled(false);
        this.dQv.setOnScrollListener(this.mOnScrollListener);
        if (this.eGL != null && this.eGL.aWx() != null) {
            this.eGL.aWx().b(this.eGD);
            this.eGL.aWx().a(this.eGD);
        }
        this.mPullView = new i(this.eGL.getPageContext());
        if (this.mPullView != null) {
            this.mPullView.setTag(this.eGL.getUniqueId());
        }
        this.dQv.setPullRefresh(this.mPullView);
        this.eGb = new ForumHeaderView(this.eGL.getFragmentActivity());
        this.dQv.addHeaderView(this.eGb);
        this.eoS = new View(this.eGL.getActivity());
        this.eoS.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.eGL.getActivity(), d.e.ds0)));
    }

    public void bE(View view) {
        if (this.refreshView == null) {
            this.refreshView = new h(this.eGL.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.b.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.eGb != null) {
                        b.this.eGb.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.po(this.eGL.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.anC();
        this.dQv.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.dQv.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.T(this.eGO);
    }

    public void a(com.baidu.tieba.enterForum.data.d dVar, boolean z) {
        this.eGO.remove(dVar);
        j(this.eGO, z);
        notifyDataSetChanged();
    }

    public BdListView aXA() {
        return this.dQv;
    }

    public void startPullRefresh() {
        this.dQv.startPullRefresh();
    }

    public void pD() {
        this.dQv.completePullRefreshPostDelayed(0L);
    }

    public void notifyDataSetChanged() {
        this.eGM.notifyDataSetChanged();
    }

    public void j(List<com.baidu.tieba.enterForum.data.d> list, boolean z) {
        this.eGO = list;
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
        this.eGM.setData(arrayList);
        this.eGb.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.dQv.removeFooterView(this.eoS);
            this.dQv.addFooterView(this.eoS);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.dQv.removeFooterView(this.eoS);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.eGb != null) {
            this.eGb.onChangeSkinType();
        }
        if (this.eGN.aXb() != null) {
            this.eGN.onChangeSkinType();
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void setSearchHint(String str) {
        if (this.eGb != null) {
            this.eGb.setSearchHint(str);
        }
    }

    public void aXB() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true) && this.eGL != null && this.eGL.getActivity() != null && this.eGL.aWw() != null) {
            if (this.eGP == null) {
                this.eGP = new CommonTipView(this.eGL.getActivity());
            }
            this.eGP.setText(d.j.enter_forum_login_tip);
            this.eGP.show(this.eGL.aWw(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onPrimary() {
        if (this.eGL.isAdded() && this.eGL.isPrimary()) {
            eGQ = false;
            if (this.eGM != null) {
                this.eGM.onPrimary();
                if (this.dQv != null) {
                    Object itemAtPosition = this.dQv.getItemAtPosition(this.dQv.getLastVisiblePosition());
                    if (itemAtPosition != null && (itemAtPosition instanceof com.baidu.tieba.enterForum.data.b) && ((com.baidu.tieba.enterForum.data.b) itemAtPosition).getType() == 5) {
                        this.eGM.aVX();
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
        if (this.eGP != null) {
            this.eGP.onDestroy();
        }
        if (this.eGN != null) {
            this.eGN.onDestroy();
        }
        if (this.eGM != null) {
            this.eGM.onDestroy();
        }
        if (this.eGL != null && this.eGL.aWx() != null) {
            this.eGL.aWx().b(this.eGD);
        }
    }

    public void pb(int i) {
        this.eGM.pb(i);
    }

    public void bC(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.eGN.isShowing() && !v.T(list)) {
            this.eGN.by(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.eGM != null) {
            this.eGM.setPageUniqueId(bdUniqueId);
        }
    }

    public boolean aVW() {
        if (this.eGM == null) {
            return false;
        }
        return this.eGM.aVW();
    }

    public void a(final int i, com.baidu.tieba.enterForum.data.b bVar) {
        if (TbadkCoreApplication.isLogin() && !eGQ && this.eGL.getActivity() != null && this.eGL.getPageContext() != null && (bVar instanceof com.baidu.tieba.enterForum.data.d)) {
            com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) bVar;
            if (dVar.isPrivateForum() != 0 && dVar.aWm() != 0 && !com.baidu.tbadk.core.sharedPref.b.getInstance().getString("enter_forum_new_forum_long_press_guide", "").equals(dVar.getId())) {
                this.eGR = d.j.create_forum_guide_tip;
            } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("enter_forum_long_press_guide", 0L) == 0) {
                this.eGR = d.j.forum_item_guide_tip;
            } else {
                return;
            }
            ObservedChangeLinearLayout aWw = this.eGL.aWw();
            if (aWw != null) {
                eGQ = true;
                com.baidu.adp.lib.guide.d dVar2 = new com.baidu.adp.lib.guide.d();
                dVar2.y(aWw).af(0).ac(true).ad(false).ab(true);
                dVar2.a(new com.baidu.adp.lib.guide.b() { // from class: com.baidu.tieba.enterForum.view.b.4
                    @Override // com.baidu.adp.lib.guide.b
                    public View a(LayoutInflater layoutInflater) {
                        View inflate = layoutInflater.inflate(d.h.tips_blue_left_up, (ViewGroup) null);
                        ((TextView) inflate.findViewById(d.g.tips)).setText(b.this.eGR);
                        b.this.eGL.getPageContext().getLayoutMode().onModeChanged(inflate);
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
                        return l.h(b.this.eGL.getPageContext().getPageActivity(), d.e.tbds180);
                    }

                    @Override // com.baidu.adp.lib.guide.b
                    public int getYOffset() {
                        return l.h(b.this.eGL.getPageContext().getPageActivity(), d.e.tbds400) + i;
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
                this.erC = dVar2.iT();
                this.erC.Z(false);
                this.erC.aa(true);
                this.erC.n(this.eGL.getActivity());
                if (this.eGR == d.j.create_forum_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putString("enter_forum_new_forum_long_press_guide", dVar.getId());
                } else if (this.eGR == d.j.forum_item_guide_tip) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("enter_forum_long_press_guide", 1L);
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.enterForum.view.b.6
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.erC != null) {
                            b.this.erC.dismiss();
                            b.this.erC = null;
                        }
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void aXC() {
        if (this.erC != null) {
            this.erC.dismiss();
            this.erC = null;
        }
    }
}
