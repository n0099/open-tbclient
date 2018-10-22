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
    private View cTy;
    private BdListView cwi;
    private ViewEventCenter dfO;
    private final EnterForumFragment dif;
    private com.baidu.tieba.enterForum.a.a dig;
    private ForumHeaderView dih;
    private com.baidu.tieba.enterForum.model.c dii;
    private com.baidu.tieba.enterForum.multiConcern.a dij;
    private boolean dik;
    private List<f> dil;
    private CommonTipView dim;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.dif = enterForumFragment;
        this.dfO = viewEventCenter;
        this.dii = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.dij = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        aG(view);
        this.dig = new com.baidu.tieba.enterForum.a.a(this.dif.getPageContext(), this.dfO, recentlyVisitedForumModel);
        this.cwi.setAdapter((ListAdapter) this.dig);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aG(View view) {
        this.cwi = (BdListView) view.findViewById(e.g.listview);
        this.cwi.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dif.getPageContext());
        this.mPullView.setTag(this.dif.getUniqueId());
        this.cwi.setPullRefresh(this.mPullView);
        this.dih = new ForumHeaderView(this.dif.getFragmentActivity());
        this.dih.setEventCenter(this.dfO);
        this.cwi.addHeaderView(this.dih);
        BdListViewHelper.a(this.dif.getPageContext().getPageActivity(), this.cwi, BdListViewHelper.HeadType.DEFAULT);
        this.cTy = new View(this.dif.getActivity());
        this.cTy.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.dif.getActivity(), e.C0175e.ds0)));
    }

    public View aua() {
        this.dih.kJ(l.h(this.dif.getPageContext().getPageActivity(), e.C0175e.ds20));
        return BdListViewHelper.a(this.dif.getPageContext().getPageActivity(), this.cwi, BdListViewHelper.HeadType.TIP);
    }

    public void aF(View view) {
        this.dih.kJ(l.h(this.dif.getPageContext().getPageActivity(), e.C0175e.ds10));
        this.cwi.removeHeaderView(view);
    }

    public void aH(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dif.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.dih != null) {
                        a.this.dih.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fB(this.dif.getPageContext().getContext().getResources().getDimensionPixelSize(e.C0175e.ds280));
        this.refreshView.hU(this.dif.getString(e.j.neterror));
        this.mRootView = view;
        this.refreshView.c(view, true);
        this.refreshView.My();
        this.cwi.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.ad(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cwi.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.J(this.dil);
    }

    public void b(f fVar) {
        this.dii.b(fVar);
    }

    public boolean auf() {
        return this.dik;
    }

    public BdListView auA() {
        return this.cwi;
    }

    public void auB() {
        bm(this.dii.getDataList());
    }

    public void kH(final int i) {
        this.dik = true;
        if (this.dii.auv() == null) {
            this.dii.createView();
            this.dii.auv().setVisibility(8);
        }
        ForumEditView auv = this.dii.auv();
        auv.onChangeSkinType(this.dif.getPageContext());
        if (auv.getParent() == null && this.dif.atX() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dif.atR().getId());
            this.dif.atR().addView(auv);
            this.dif.atW();
        }
        this.dii.bj(this.dil);
        com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.kI(i);
                com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.dii.auv() != null) {
                            a.this.dii.auv().setVisibility(0);
                            a.this.cwi.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean atB() {
        if (this.dig != null) {
            return this.dig.atB();
        }
        return false;
    }

    public void auC() {
        this.dik = false;
        this.cwi.setVisibility(0);
        if (this.dii.auv() != null && this.dif.atR() != null) {
            this.dif.atR().removeView(this.dii.auv());
            this.dii.auv().setVisibility(8);
        }
        this.dif.atW();
    }

    public void auD() {
        this.dik = true;
        this.cwi.setVisibility(8);
        if (this.dii.auv() != null) {
            this.dii.auv().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kI(int i) {
        if (this.dii.auv() != null && this.cwi != null && this.cwi.getChildCount() > 0) {
            int firstVisiblePosition = (this.cwi.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cwi.getChildAt(0);
            this.dii.auv().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cwi.startPullRefresh();
    }

    public void pj() {
        this.cwi.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public List<f> auE() {
        return this.dil;
    }

    public List<f> auF() {
        List<f> dataList = this.dii.getDataList();
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
        this.dig.notifyDataSetChanged();
    }

    public void bm(List<f> list) {
        this.dil = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.J(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dif.getPageContext().getResources().getString(e.j.my_attention_bar)));
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
        this.dig.setData(arrayList);
        if (this.dik) {
            this.cwi.setVisibility(8);
            return;
        }
        auC();
        this.dih.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cwi.removeFooterView(this.cTy);
            this.cwi.addFooterView(this.cTy);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cwi.removeFooterView(this.cTy);
        }
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.dih != null) {
            this.dih.onChangeSkinType(this.dif.getPageContext());
        }
        if (this.dii.auv() != null && this.dii.auv().getVisibility() == 0) {
            this.dii.onChangeSkinType(this.dif.getPageContext());
        }
        if (this.dij.auz() != null) {
            this.dij.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dih != null) {
            this.dih.setSearchHint(str);
        }
    }

    public void auG() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dim == null) {
                this.dim = new CommonTipView(this.dif.getActivity());
            }
            this.dim.setText(e.j.enter_forum_login_tip);
            this.dim.show(this.dif.atR(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dim != null) {
            this.dim.onDestroy();
        }
        if (this.dij != null) {
            this.dij.onDestroy();
        }
        if (this.dig != null) {
            this.dig.onDestroy();
        }
    }

    public void bn(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dij.isShowing() && !v.J(list)) {
            this.dij.bl(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dig != null) {
            this.dig.setPageUniqueId(bdUniqueId);
        }
    }
}
