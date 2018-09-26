package com.baidu.tieba.enterForum.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
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
/* loaded from: classes2.dex */
public class a {
    private View cLf;
    private ViewEventCenter cXw;
    private final EnterForumFragment cZQ;
    private com.baidu.tieba.enterForum.a.a cZR;
    private ForumHeaderView cZS;
    private com.baidu.tieba.enterForum.model.c cZT;
    private com.baidu.tieba.enterForum.multiConcern.a cZU;
    private boolean cZV;
    private List<f> cZW;
    private CommonTipView cZX;
    private BdListView cnE;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public a(EnterForumFragment enterForumFragment, View view, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel) {
        this.cZQ = enterForumFragment;
        this.cXw = viewEventCenter;
        this.cZT = new com.baidu.tieba.enterForum.model.c(enterForumFragment.getPageContext(), viewEventCenter);
        this.cZU = new com.baidu.tieba.enterForum.multiConcern.a(enterForumFragment.getPageContext(), enterForumFragment.getBaseFragmentActivity().getActivityRootView(), viewEventCenter);
        aG(view);
        this.cZR = new com.baidu.tieba.enterForum.a.a(this.cZQ.getPageContext(), this.cXw, recentlyVisitedForumModel);
        this.cnE.setAdapter((ListAdapter) this.cZR);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void aG(View view) {
        this.cnE = (BdListView) view.findViewById(e.g.listview);
        this.cnE.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.cZQ.getPageContext());
        this.mPullView.setTag(this.cZQ.getUniqueId());
        this.cnE.setPullRefresh(this.mPullView);
        this.cZS = new ForumHeaderView(this.cZQ.getFragmentActivity());
        this.cZS.setEventCenter(this.cXw);
        this.cnE.addHeaderView(this.cZS);
        BdListViewHelper.a(this.cZQ.getPageContext().getPageActivity(), this.cnE, BdListViewHelper.HeadType.DEFAULT);
        this.cLf = new View(this.cZQ.getActivity());
        this.cLf.setLayoutParams(new AbsListView.LayoutParams(-1, l.h(this.cZQ.getActivity(), e.C0141e.ds0)));
    }

    public View aqD() {
        this.cZS.kl(l.h(this.cZQ.getPageContext().getPageActivity(), e.C0141e.ds20));
        return BdListViewHelper.a(this.cZQ.getPageContext().getPageActivity(), this.cnE, BdListViewHelper.HeadType.TIP);
    }

    public void aF(View view) {
        this.cZS.kl(l.h(this.cZQ.getPageContext().getPageActivity(), e.C0141e.ds10));
        this.cnE.removeHeaderView(view);
    }

    public void aH(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.cZQ.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.hideNoDataView();
                    if (a.this.cZS != null) {
                        a.this.cZS.setVisibility(8);
                    }
                    a.this.startPullRefresh();
                }
            });
        }
        this.refreshView.fs(this.cZQ.getPageContext().getContext().getResources().getDimensionPixelSize(e.C0141e.ds280));
        this.refreshView.hG(this.cZQ.getString(e.j.neterror));
        this.mRootView = view;
        this.refreshView.c(view, true);
        this.refreshView.KA();
        this.cnE.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.ad(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cnE.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.z(this.cZW);
    }

    public void b(f fVar) {
        this.cZT.b(fVar);
    }

    public boolean aqI() {
        return this.cZV;
    }

    public BdListView ard() {
        return this.cnE;
    }

    public void are() {
        aW(this.cZT.getDataList());
    }

    public void kj(final int i) {
        this.cZV = true;
        if (this.cZT.aqY() == null) {
            this.cZT.createView();
            this.cZT.aqY().setVisibility(8);
        }
        ForumEditView aqY = this.cZT.aqY();
        aqY.onChangeSkinType(this.cZQ.getPageContext());
        if (aqY.getParent() == null && this.cZQ.aqA() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cZQ.aqu().getId());
            this.cZQ.aqu().addView(aqY);
            this.cZQ.aqz();
        }
        this.cZT.aT(this.cZW);
        com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.kk(i);
                com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.enterForum.view.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.cZT.aqY() != null) {
                            a.this.cZT.aqY().setVisibility(0);
                            a.this.cnE.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public boolean aqe() {
        if (this.cZR != null) {
            return this.cZR.aqe();
        }
        return false;
    }

    public void arf() {
        this.cZV = false;
        this.cnE.setVisibility(0);
        if (this.cZT.aqY() != null && this.cZQ.aqu() != null) {
            this.cZQ.aqu().removeView(this.cZT.aqY());
            this.cZT.aqY().setVisibility(8);
        }
        this.cZQ.aqz();
    }

    public void arg() {
        this.cZV = true;
        this.cnE.setVisibility(8);
        if (this.cZT.aqY() != null) {
            this.cZT.aqY().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(int i) {
        if (this.cZT.aqY() != null && this.cnE != null && this.cnE.getChildCount() > 0) {
            int firstVisiblePosition = (this.cnE.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cnE.getChildAt(0);
            this.cZT.aqY().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cnE.startPullRefresh();
    }

    public void pb() {
        this.cnE.completePullRefreshPostDelayed(2000L);
    }

    public List<f> arh() {
        return this.cZW;
    }

    public List<f> ari() {
        List<f> dataList = this.cZT.getDataList();
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
        this.cZR.notifyDataSetChanged();
    }

    public void aW(List<f> list) {
        this.cZW = list;
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
        cVar.setType(4);
        arrayList.add(cVar);
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (!v.z(a)) {
            arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cZQ.getPageContext().getResources().getString(e.j.my_attention_bar)));
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
        this.cZR.setData(arrayList);
        if (this.cZV) {
            this.cnE.setVisibility(8);
            return;
        }
        arf();
        this.cZS.setVisibility(0);
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cnE.removeFooterView(this.cLf);
            this.cnE.addFooterView(this.cLf);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cnE.removeFooterView(this.cLf);
        }
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.cZS != null) {
            this.cZS.onChangeSkinType(this.cZQ.getPageContext());
        }
        if (this.cZT.aqY() != null && this.cZT.aqY().getVisibility() == 0) {
            this.cZT.onChangeSkinType(this.cZQ.getPageContext());
        }
        if (this.cZU.arc() != null) {
            this.cZU.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cZS != null) {
            this.cZS.setSearchHint(str);
        }
    }

    public void arj() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cZX == null) {
                this.cZX = new CommonTipView(this.cZQ.getActivity());
            }
            this.cZX.setText(e.j.enter_forum_login_tip);
            this.cZX.show(this.cZQ.aqu(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cZX != null) {
            this.cZX.onDestroy();
        }
        if (this.cZU != null) {
            this.cZU.onDestroy();
        }
        if (this.cZR != null) {
            this.cZR.onDestroy();
        }
    }

    public void aX(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cZU.isShowing() && !v.z(list)) {
            this.cZU.aV(list);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.cZR != null) {
            this.cZR.setPageUniqueId(bdUniqueId);
        }
    }
}
