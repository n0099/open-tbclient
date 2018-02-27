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
    private BdListView cEY;
    private View ddo;
    private ViewEventCenter doJ;
    private final com.baidu.tieba.enterForum.home.a dqB;
    private com.baidu.tieba.enterForum.a.a dqC;
    private f dqD;
    private com.baidu.tieba.enterForum.model.c dqE;
    private com.baidu.tieba.enterForum.multiConcern.a dqF;
    private boolean dqG;
    private List<com.baidu.tieba.enterForum.data.f> dqH;
    private CommonTipView dqI;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.dqB = aVar;
        this.doJ = viewEventCenter;
        this.dqE = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.dqF = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().xl(), viewEventCenter);
        bI(view);
        this.dqC = new com.baidu.tieba.enterForum.a.a(this.dqB.getPageContext(), this.doJ);
        this.cEY.setAdapter((ListAdapter) this.dqC);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bI(View view) {
        this.cEY = (BdListView) view.findViewById(d.g.listview);
        this.cEY.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dqB.getPageContext());
        this.mPullView.setTag(this.dqB.getUniqueId());
        this.cEY.setPullRefresh(this.mPullView);
        this.dqD = new f(this.dqB.getFragmentActivity());
        this.dqD.setEventCenter(this.doJ);
        this.cEY.addHeaderView(this.dqD);
        BdListViewHelper.a(this.dqB.getPageContext().getPageActivity(), this.cEY, BdListViewHelper.HeadType.DEFAULT);
        this.ddo = new View(this.dqB.getActivity());
        this.ddo.setLayoutParams(new AbsListView.LayoutParams(-1, l.t(this.dqB.getActivity(), d.e.ds0)));
    }

    public View aqC() {
        this.dqD.mp(l.t(this.dqB.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.dqB.getPageContext().getPageActivity(), this.cEY, BdListViewHelper.HeadType.TIP);
    }

    public void bH(View view) {
        this.dqD.mp(l.t(this.dqB.getPageContext().getPageActivity(), d.e.ds10));
        this.cEY.removeHeaderView(view);
    }

    public void bJ(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dqB.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.dqD != null) {
                        b.this.dqD.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.ib(this.dqB.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gW(this.dqB.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.j(view, true);
        this.refreshView.MQ();
        this.cEY.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cEY.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.E(this.dqH);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.dqE.b(fVar);
    }

    public boolean aqH() {
        return this.dqG;
    }

    public BdListView aqZ() {
        return this.cEY;
    }

    public void ara() {
        aU(this.dqE.getDataList());
    }

    public void mn(final int i) {
        this.dqG = true;
        if (this.dqE.aqU() == null) {
            this.dqE.createView();
            this.dqE.aqU().setVisibility(8);
        }
        d aqU = this.dqE.aqU();
        aqU.onChangeSkinType(this.dqB.getPageContext());
        if (aqU.getParent() == null && this.dqB.aqz() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dqB.aqt().getId());
            this.dqB.aqt().addView(aqU);
            this.dqB.aqy();
        }
        this.dqE.aR(this.dqH);
        com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mo(i);
                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.dqE.aqU() != null) {
                            b.this.dqE.aqU().setVisibility(0);
                            b.this.cEY.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void arb() {
        this.dqG = false;
        this.cEY.setVisibility(0);
        if (this.dqE.aqU() != null && this.dqB.aqt() != null) {
            this.dqB.aqt().removeView(this.dqE.aqU());
            this.dqE.aqU().setVisibility(8);
        }
        this.dqB.aqy();
    }

    public void arc() {
        this.dqG = true;
        this.cEY.setVisibility(8);
        if (this.dqE.aqU() != null) {
            this.dqE.aqU().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(int i) {
        if (this.dqE.aqU() != null && this.cEY != null && this.cEY.getChildCount() > 0) {
            int firstVisiblePosition = (this.cEY.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cEY.getChildAt(0);
            this.dqE.aqU().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cEY.startPullRefresh();
    }

    public void sV() {
        this.cEY.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> ard() {
        return this.dqH;
    }

    public List<com.baidu.tieba.enterForum.data.f> are() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.dqE.getDataList();
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
        this.dqC.notifyDataSetChanged();
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
        this.dqH = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.D(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.aqh().getType() == 1 && aVar.aqi().getType() == 2) {
                z = false;
                if (v.E(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dqB.getPageContext().getResources().getString(d.j.my_attention_bar), z));
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
                this.dqC.setData(arrayList);
                if (!this.dqG) {
                    this.cEY.setVisibility(8);
                    return;
                }
                arb();
                this.dqD.setVisibility(0);
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
        this.dqC.setData(arrayList);
        if (!this.dqG) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cEY.removeFooterView(this.ddo);
            this.cEY.addFooterView(this.ddo);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cEY.removeFooterView(this.ddo);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.dqD != null) {
            this.dqD.onChangeSkinType(this.dqB.getPageContext());
        }
        if (this.dqE.aqU() != null && this.dqE.aqU().getVisibility() == 0) {
            this.dqE.onChangeSkinType(this.dqB.getPageContext());
        }
        if (this.dqF.aqY() != null) {
            this.dqF.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dqD != null) {
            this.dqD.setSearchHint(str);
        }
    }

    public void arf() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dqI == null) {
                this.dqI = new CommonTipView(this.dqB.getActivity());
            }
            this.dqI.setText(d.j.enter_forum_login_tip);
            this.dqI.show(this.dqB.aqt(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dqI != null) {
            this.dqI.onDestroy();
        }
        if (this.dqF != null) {
            this.dqF.onDestroy();
        }
    }

    public void aV(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dqF.isShowing() && !v.E(list)) {
            this.dqF.aT(list);
        }
    }
}
