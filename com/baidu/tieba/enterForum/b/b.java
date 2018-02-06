package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private BdListView cFk;
    private View ddB;
    private ViewEventCenter doV;
    private final com.baidu.tieba.enterForum.home.a dqN;
    private com.baidu.tieba.enterForum.a.a dqO;
    private f dqP;
    private com.baidu.tieba.enterForum.model.c dqQ;
    private com.baidu.tieba.enterForum.multiConcern.a dqR;
    private boolean dqS;
    private List<com.baidu.tieba.enterForum.data.f> dqT;
    private CommonTipView dqU;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.dqN = aVar;
        this.doV = viewEventCenter;
        this.dqQ = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.dqR = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().xl(), viewEventCenter);
        bI(view);
        this.dqO = new com.baidu.tieba.enterForum.a.a(this.dqN.getPageContext(), this.doV);
        this.cFk.setAdapter((ListAdapter) this.dqO);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bI(View view) {
        this.cFk = (BdListView) view.findViewById(d.g.listview);
        this.cFk.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dqN.getPageContext());
        this.mPullView.setTag(this.dqN.getUniqueId());
        this.cFk.setPullRefresh(this.mPullView);
        this.dqP = new f(this.dqN.getFragmentActivity());
        this.dqP.setEventCenter(this.doV);
        this.cFk.addHeaderView(this.dqP);
        BdListViewHelper.a(this.dqN.getPageContext().getPageActivity(), this.cFk, BdListViewHelper.HeadType.DEFAULT);
        this.ddB = new View(this.dqN.getActivity());
        this.ddB.setLayoutParams(new AbsListView.LayoutParams(-1, l.t(this.dqN.getActivity(), d.e.ds0)));
    }

    public View aqD() {
        this.dqP.mp(l.t(this.dqN.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.dqN.getPageContext().getPageActivity(), this.cFk, BdListViewHelper.HeadType.TIP);
    }

    public void bH(View view) {
        this.dqP.mp(l.t(this.dqN.getPageContext().getPageActivity(), d.e.ds10));
        this.cFk.removeHeaderView(view);
    }

    public void bJ(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dqN.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.dqP != null) {
                        b.this.dqP.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.ib(this.dqN.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gW(this.dqN.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.j(view, true);
        this.refreshView.MR();
        this.cFk.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cFk.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.E(this.dqT);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.dqQ.b(fVar);
    }

    public boolean aqI() {
        return this.dqS;
    }

    public BdListView ara() {
        return this.cFk;
    }

    public void arb() {
        aU(this.dqQ.getDataList());
    }

    public void mn(final int i) {
        this.dqS = true;
        if (this.dqQ.aqV() == null) {
            this.dqQ.createView();
            this.dqQ.aqV().setVisibility(8);
        }
        d aqV = this.dqQ.aqV();
        aqV.onChangeSkinType(this.dqN.getPageContext());
        if (aqV.getParent() == null && this.dqN.aqA() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dqN.aqu().getId());
            this.dqN.aqu().addView(aqV);
            this.dqN.aqz();
        }
        this.dqQ.aR(this.dqT);
        com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mo(i);
                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.dqQ.aqV() != null) {
                            b.this.dqQ.aqV().setVisibility(0);
                            b.this.cFk.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void arc() {
        this.dqS = false;
        this.cFk.setVisibility(0);
        if (this.dqQ.aqV() != null && this.dqN.aqu() != null) {
            this.dqN.aqu().removeView(this.dqQ.aqV());
            this.dqQ.aqV().setVisibility(8);
        }
        this.dqN.aqz();
    }

    public void ard() {
        this.dqS = true;
        this.cFk.setVisibility(8);
        if (this.dqQ.aqV() != null) {
            this.dqQ.aqV().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(int i) {
        if (this.dqQ.aqV() != null && this.cFk != null && this.cFk.getChildCount() > 0) {
            int firstVisiblePosition = (this.cFk.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cFk.getChildAt(0);
            this.dqQ.aqV().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cFk.startPullRefresh();
    }

    public void sV() {
        this.cFk.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> are() {
        return this.dqT;
    }

    public List<com.baidu.tieba.enterForum.data.f> arf() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.dqQ.getDataList();
        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) v.f(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            v.g(dataList, 0);
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
        this.dqO.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aU(List<com.baidu.tieba.enterForum.data.f> list) {
        boolean z;
        this.dqT = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.D(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.aqi().getType() == 1 && aVar.aqj().getType() == 2) {
                z = false;
                if (v.E(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dqN.getPageContext().getResources().getString(d.j.my_attention_bar), z));
                    arrayList.addAll(a);
                } else {
                    com.baidu.tieba.enterForum.data.c cVar = new com.baidu.tieba.enterForum.data.c();
                    cVar.setType(3);
                    arrayList.add(cVar);
                }
                com.baidu.tieba.enterForum.data.c cVar2 = new com.baidu.tieba.enterForum.data.c();
                cVar2.setType(2);
                arrayList.add(cVar2);
                hideNoDataView();
                this.dqO.setData(arrayList);
                if (!this.dqS) {
                    this.cFk.setVisibility(8);
                    return;
                }
                arc();
                this.dqP.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.E(a)) {
        }
        com.baidu.tieba.enterForum.data.c cVar22 = new com.baidu.tieba.enterForum.data.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.dqO.setData(arrayList);
        if (!this.dqS) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cFk.removeFooterView(this.ddB);
            this.cFk.addFooterView(this.ddB);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cFk.removeFooterView(this.ddB);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.dqP != null) {
            this.dqP.onChangeSkinType(this.dqN.getPageContext());
        }
        if (this.dqQ.aqV() != null && this.dqQ.aqV().getVisibility() == 0) {
            this.dqQ.onChangeSkinType(this.dqN.getPageContext());
        }
        if (this.dqR.aqZ() != null) {
            this.dqR.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dqP != null) {
            this.dqP.setSearchHint(str);
        }
    }

    public void arg() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dqU == null) {
                this.dqU = new CommonTipView(this.dqN.getActivity());
            }
            this.dqU.setText(d.j.enter_forum_login_tip);
            this.dqU.show(this.dqN.aqu(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dqU != null) {
            this.dqU.onDestroy();
        }
        if (this.dqR != null) {
            this.dqR.onDestroy();
        }
    }

    public void aV(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dqR.isShowing() && !v.E(list)) {
            this.dqR.aT(list);
        }
    }
}
