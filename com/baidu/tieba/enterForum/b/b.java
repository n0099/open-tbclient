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
    private BdListView cFb;
    private View ddr;
    private ViewEventCenter doM;
    private final com.baidu.tieba.enterForum.home.a dqE;
    private com.baidu.tieba.enterForum.a.a dqF;
    private f dqG;
    private com.baidu.tieba.enterForum.model.c dqH;
    private com.baidu.tieba.enterForum.multiConcern.a dqI;
    private boolean dqJ;
    private List<com.baidu.tieba.enterForum.data.f> dqK;
    private CommonTipView dqL;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.dqE = aVar;
        this.doM = viewEventCenter;
        this.dqH = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.dqI = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().xl(), viewEventCenter);
        bI(view);
        this.dqF = new com.baidu.tieba.enterForum.a.a(this.dqE.getPageContext(), this.doM);
        this.cFb.setAdapter((ListAdapter) this.dqF);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bI(View view) {
        this.cFb = (BdListView) view.findViewById(d.g.listview);
        this.cFb.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dqE.getPageContext());
        this.mPullView.setTag(this.dqE.getUniqueId());
        this.cFb.setPullRefresh(this.mPullView);
        this.dqG = new f(this.dqE.getFragmentActivity());
        this.dqG.setEventCenter(this.doM);
        this.cFb.addHeaderView(this.dqG);
        BdListViewHelper.a(this.dqE.getPageContext().getPageActivity(), this.cFb, BdListViewHelper.HeadType.DEFAULT);
        this.ddr = new View(this.dqE.getActivity());
        this.ddr.setLayoutParams(new AbsListView.LayoutParams(-1, l.t(this.dqE.getActivity(), d.e.ds0)));
    }

    public View aqD() {
        this.dqG.mp(l.t(this.dqE.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.dqE.getPageContext().getPageActivity(), this.cFb, BdListViewHelper.HeadType.TIP);
    }

    public void bH(View view) {
        this.dqG.mp(l.t(this.dqE.getPageContext().getPageActivity(), d.e.ds10));
        this.cFb.removeHeaderView(view);
    }

    public void bJ(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dqE.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.dqG != null) {
                        b.this.dqG.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.ib(this.dqE.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gW(this.dqE.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.j(view, true);
        this.refreshView.MR();
        this.cFb.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cFb.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.E(this.dqK);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.dqH.b(fVar);
    }

    public boolean aqI() {
        return this.dqJ;
    }

    public BdListView ara() {
        return this.cFb;
    }

    public void arb() {
        aU(this.dqH.getDataList());
    }

    public void mn(final int i) {
        this.dqJ = true;
        if (this.dqH.aqV() == null) {
            this.dqH.createView();
            this.dqH.aqV().setVisibility(8);
        }
        d aqV = this.dqH.aqV();
        aqV.onChangeSkinType(this.dqE.getPageContext());
        if (aqV.getParent() == null && this.dqE.aqA() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dqE.aqu().getId());
            this.dqE.aqu().addView(aqV);
            this.dqE.aqz();
        }
        this.dqH.aR(this.dqK);
        com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mo(i);
                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.dqH.aqV() != null) {
                            b.this.dqH.aqV().setVisibility(0);
                            b.this.cFb.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void arc() {
        this.dqJ = false;
        this.cFb.setVisibility(0);
        if (this.dqH.aqV() != null && this.dqE.aqu() != null) {
            this.dqE.aqu().removeView(this.dqH.aqV());
            this.dqH.aqV().setVisibility(8);
        }
        this.dqE.aqz();
    }

    public void ard() {
        this.dqJ = true;
        this.cFb.setVisibility(8);
        if (this.dqH.aqV() != null) {
            this.dqH.aqV().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(int i) {
        if (this.dqH.aqV() != null && this.cFb != null && this.cFb.getChildCount() > 0) {
            int firstVisiblePosition = (this.cFb.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cFb.getChildAt(0);
            this.dqH.aqV().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cFb.startPullRefresh();
    }

    public void sV() {
        this.cFb.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> are() {
        return this.dqK;
    }

    public List<com.baidu.tieba.enterForum.data.f> arf() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.dqH.getDataList();
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
        this.dqF.notifyDataSetChanged();
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
        this.dqK = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.D(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.aqi().getType() == 1 && aVar.aqj().getType() == 2) {
                z = false;
                if (v.E(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dqE.getPageContext().getResources().getString(d.j.my_attention_bar), z));
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
                this.dqF.setData(arrayList);
                if (!this.dqJ) {
                    this.cFb.setVisibility(8);
                    return;
                }
                arc();
                this.dqG.setVisibility(0);
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
        this.dqF.setData(arrayList);
        if (!this.dqJ) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cFb.removeFooterView(this.ddr);
            this.cFb.addFooterView(this.ddr);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cFb.removeFooterView(this.ddr);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.dqG != null) {
            this.dqG.onChangeSkinType(this.dqE.getPageContext());
        }
        if (this.dqH.aqV() != null && this.dqH.aqV().getVisibility() == 0) {
            this.dqH.onChangeSkinType(this.dqE.getPageContext());
        }
        if (this.dqI.aqZ() != null) {
            this.dqI.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dqG != null) {
            this.dqG.setSearchHint(str);
        }
    }

    public void arg() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dqL == null) {
                this.dqL = new CommonTipView(this.dqE.getActivity());
            }
            this.dqL.setText(d.j.enter_forum_login_tip);
            this.dqL.show(this.dqE.aqu(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dqL != null) {
            this.dqL.onDestroy();
        }
        if (this.dqI != null) {
            this.dqI.onDestroy();
        }
    }

    public void aV(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dqI.isShowing() && !v.E(list)) {
            this.dqI.aT(list);
        }
    }
}
