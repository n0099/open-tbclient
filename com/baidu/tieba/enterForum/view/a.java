package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.enterForum.data.f;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private View cUE;
    private BdListView cxp;
    private ViewEventCenter dgT;
    private final EnterForumFragment djk;
    private com.baidu.tieba.enterForum.a.a djl;
    private ForumHeaderView djm;
    private com.baidu.tieba.enterForum.model.c djn;
    private com.baidu.tieba.enterForum.multiConcern.a djo;
    private boolean djp;
    private List<f> djq;
    private CommonTipView djr;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.djk = enterForumFragment;
        this.dgT = viewEventCenter;
        this.djn = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.djo = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        aI(view);
        this.djl = new com.baidu.tieba.enterForum.a.a(this.djk.getPageContext(), this.dgT, recentlyVisitedForumModel);
        this.cxp.setAdapter((ListAdapter) this.djl);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aI(View view) {
        this.cxp = (BdListView) view.findViewById(e.g.listview);
        this.cxp.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.djk.getPageContext());
        this.mPullView.setTag(this.djk.getUniqueId());
        this.cxp.setPullRefresh(this.mPullView);
        this.djm = new ForumHeaderView(this.djk.getFragmentActivity());
        this.djm.setEventCenter(this.dgT);
        this.cxp.addHeaderView(this.djm);
        BdListViewHelper.a(this.djk.getPageContext().getPageActivity(), this.cxp, BdListViewHelper.HeadType.DEFAULT);
        this.cUE = new View(this.djk.getActivity());
        this.cUE.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.djk.getActivity(), e.C0200e.ds0)));
    }

    public View atz() {
        this.djm.lb(l.h(this.djk.getPageContext().getPageActivity(), e.C0200e.ds20));
        return BdListViewHelper.a(this.djk.getPageContext().getPageActivity(), this.cxp, BdListViewHelper.HeadType.TIP);
    }

    public void aH(View view) {
        this.djm.lb(l.h(this.djk.getPageContext().getPageActivity(), e.C0200e.ds10));
        this.cxp.removeHeaderView(view);
    }

    public void aJ(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.djk.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.djm != null) {
                        a.this.djm.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fP(this.djk.getPageContext().getContext().getResources().getDimensionPixelSize(e.C0200e.ds280));
        this.refreshView.hV(this.djk.getString(e.j.neterror));
        this.mRootView = view;
        this.refreshView.attachView(view, true);
        this.refreshView.MH();
        this.cxp.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cxp.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.I(this.djq);
    }

    public void b(f fVar) {
        this.djn.b(fVar);
    }

    public boolean atE() {
        return this.djp;
    }

    public BdListView atY() {
        return this.cxp;
    }

    public void atZ() {
        bk(this.djn.getDataList());
    }

    public void kZ(final int i) {
        this.djp = true;
        if (this.djn.atT() == null) {
            this.djn.createView();
            this.djn.atT().setVisibility(8);
        }
        ForumEditView atT = this.djn.atT();
        atT.onChangeSkinType(this.djk.getPageContext());
        if (atT.getParent() == null && this.djk.atw() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.djk.atq().getId());
            this.djk.atq().addView(atT);
            this.djk.atv();
        }
        this.djn.bh(this.djq);
        com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.la(i);
                com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.djn.atT() != null) {
                            a.this.djn.atT().setVisibility(0);
                            a.this.cxp.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean ata() {
        if (this.djl != null) {
            return this.djl.ata();
        }
        return false;
    }

    public void aua() {
        this.djp = false;
        this.cxp.setVisibility(0);
        if (this.djn.atT() != null && this.djk.atq() != null) {
            this.djk.atq().removeView(this.djn.atT());
            this.djn.atT().setVisibility(8);
        }
        this.djk.atv();
    }

    public void aub() {
        this.djp = true;
        this.cxp.setVisibility(8);
        if (this.djn.atT() != null) {
            this.djn.atT().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(int i) {
        if (this.djn.atT() != null && this.cxp != null && this.cxp.getChildCount() > 0) {
            int firstVisiblePosition = (this.cxp.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cxp.getChildAt(0);
            this.djn.atT().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cxp.startPullRefresh();
    }

    public void ph() {
        this.cxp.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public List<f> auc() {
        return this.djq;
    }

    public List<f> aud() {
        List<f> dataList = this.djn.getDataList();
        f fVar = (f) v.d(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            v.e(dataList, 0);
        }
        return dataList;
    }

    private List<com.baidu.tieba.enterForum.data.c> a(List list, boolean z, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        int i3 = 1;
        int i4 = 0;
        while (i4 < size && (i2 <= 0 || i3 < i2 * 2)) {
            com.baidu.tieba.enterForum.data.e eVar = new com.baidu.tieba.enterForum.data.e();
            com.baidu.tieba.enterForum.data.e eVar2 = new com.baidu.tieba.enterForum.data.e();
            if (i3 < size) {
                eVar = (com.baidu.tieba.enterForum.data.e) list.get(i4);
                eVar2 = (com.baidu.tieba.enterForum.data.e) list.get(i3);
                eVar.setType(i);
                eVar2.setType(i);
            } else if (i4 < size) {
                eVar = (com.baidu.tieba.enterForum.data.e) list.get(i4);
                eVar.setType(i);
                eVar2.setType(2);
            }
            arrayList.add(new com.baidu.tieba.enterForum.data.a(eVar, eVar2));
            int i5 = i4 + 2;
            i3 = i5 + 1;
            i4 = i5;
        }
        return arrayList;
    }

    public void notifyDataSetChanged() {
        this.djl.notifyDataSetChanged();
    }

    public void bk(List<f> list) {
        this.djq = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.I(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.djk.getPageContext().getResources().getString(e.j.my_attention_bar)));
            arrayList.addAll(a);
        } else {
            com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
            cVar2.setType(3);
            arrayList.add(cVar2);
        }
        com.baidu.tieba.enterForum.data.c cVar3 = new com.baidu.tieba.enterForum.data.c();
        cVar3.setType(2);
        arrayList.add(cVar3);
        hideNoDataView();
        this.djl.setData(arrayList);
        if (this.djp) {
            this.cxp.setVisibility(8);
            return;
        }
        aua();
        this.djm.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cxp.removeFooterView(this.cUE);
            this.cxp.addFooterView(this.cUE);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cxp.removeFooterView(this.cUE);
        }
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.djm != null) {
            this.djm.onChangeSkinType(this.djk.getPageContext());
        }
        if (this.djn.atT() != null && this.djn.atT().getVisibility() == 0) {
            this.djn.onChangeSkinType(this.djk.getPageContext());
        }
        if (this.djo.atX() != null) {
            this.djo.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.djm != null) {
            this.djm.setSearchHint(str);
        }
    }

    public void aue() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.djr == null) {
                this.djr = new CommonTipView(this.djk.getActivity());
            }
            this.djr.setText(e.j.enter_forum_login_tip);
            this.djr.show(this.djk.atq(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.djr != null) {
            this.djr.onDestroy();
        }
        if (this.djo != null) {
            this.djo.onDestroy();
        }
        if (this.djl != null) {
            this.djl.onDestroy();
        }
    }

    public void bl(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.djo.isShowing() && !v.I(list)) {
            this.djo.bj(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.djl != null) {
            this.djl.setPageUniqueId(bdUniqueId);
        }
    }
}
