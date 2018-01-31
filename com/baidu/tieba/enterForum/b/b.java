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
    private BdListView cBq;
    private View daO;
    private ViewEventCenter dme;
    private final com.baidu.tieba.enterForum.home.a dnT;
    private com.baidu.tieba.enterForum.a.a dnU;
    private f dnV;
    private com.baidu.tieba.enterForum.model.c dnW;
    private com.baidu.tieba.enterForum.multiConcern.a dnX;
    private boolean dnY;
    private List<com.baidu.tieba.enterForum.data.f> dnZ;
    private CommonTipView doa;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.dnT = aVar;
        this.dme = viewEventCenter;
        this.dnW = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.dnX = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().wy(), viewEventCenter);
        bJ(view);
        this.dnU = new com.baidu.tieba.enterForum.a.a(this.dnT.getPageContext(), this.dme);
        this.cBq.setAdapter((ListAdapter) this.dnU);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.cBq = (BdListView) view.findViewById(d.g.listview);
        this.cBq.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dnT.getPageContext());
        this.mPullView.setTag(this.dnT.getUniqueId());
        this.cBq.setPullRefresh(this.mPullView);
        this.dnV = new f(this.dnT.getFragmentActivity());
        this.dnV.setEventCenter(this.dme);
        this.cBq.addHeaderView(this.dnV);
        BdListViewHelper.a(this.dnT.getPageContext().getPageActivity(), this.cBq, BdListViewHelper.HeadType.DEFAULT);
        this.daO = new View(this.dnT.getActivity());
        this.daO.setLayoutParams(new AbsListView.LayoutParams(-1, l.s(this.dnT.getActivity(), d.e.ds0)));
    }

    public View apN() {
        this.dnV.ms(l.s(this.dnT.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.dnT.getPageContext().getPageActivity(), this.cBq, BdListViewHelper.HeadType.TIP);
    }

    public void bI(View view) {
        this.dnV.ms(l.s(this.dnT.getPageContext().getPageActivity(), d.e.ds10));
        this.cBq.removeHeaderView(view);
    }

    public void bK(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dnT.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.dnV != null) {
                        b.this.dnV.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.id(this.dnT.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gM(this.dnT.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.j(view, true);
        this.refreshView.Ml();
        this.cBq.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cBq.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.E(this.dnZ);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.dnW.b(fVar);
    }

    public boolean apS() {
        return this.dnY;
    }

    public BdListView aqk() {
        return this.cBq;
    }

    public void aql() {
        aS(this.dnW.getDataList());
    }

    public void mq(final int i) {
        this.dnY = true;
        if (this.dnW.aqf() == null) {
            this.dnW.createView();
            this.dnW.aqf().setVisibility(8);
        }
        d aqf = this.dnW.aqf();
        aqf.onChangeSkinType(this.dnT.getPageContext());
        if (aqf.getParent() == null && this.dnT.apK() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dnT.apE().getId());
            this.dnT.apE().addView(aqf);
            this.dnT.apJ();
        }
        this.dnW.aP(this.dnZ);
        com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mr(i);
                com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.dnW.aqf() != null) {
                            b.this.dnW.aqf().setVisibility(0);
                            b.this.cBq.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void aqm() {
        this.dnY = false;
        this.cBq.setVisibility(0);
        if (this.dnW.aqf() != null && this.dnT.apE() != null) {
            this.dnT.apE().removeView(this.dnW.aqf());
            this.dnW.aqf().setVisibility(8);
        }
        this.dnT.apJ();
    }

    public void aqn() {
        this.dnY = true;
        this.cBq.setVisibility(8);
        if (this.dnW.aqf() != null) {
            this.dnW.aqf().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(int i) {
        if (this.dnW.aqf() != null && this.cBq != null && this.cBq.getChildCount() > 0) {
            int firstVisiblePosition = (this.cBq.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cBq.getChildAt(0);
            this.dnW.aqf().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cBq.startPullRefresh();
    }

    public void sW() {
        this.cBq.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> aqo() {
        return this.dnZ;
    }

    public List<com.baidu.tieba.enterForum.data.f> aqp() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.dnW.getDataList();
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
        this.dnU.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aS(List<com.baidu.tieba.enterForum.data.f> list) {
        boolean z;
        this.dnZ = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.D(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.apt().getType() == 1 && aVar.apu().getType() == 2) {
                z = false;
                if (v.E(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dnT.getPageContext().getResources().getString(d.j.my_attention_bar), z));
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
                this.dnU.setData(arrayList);
                if (!this.dnY) {
                    this.cBq.setVisibility(8);
                    return;
                }
                aqm();
                this.dnV.setVisibility(0);
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
        this.dnU.setData(arrayList);
        if (!this.dnY) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cBq.removeFooterView(this.daO);
            this.cBq.addFooterView(this.daO);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cBq.removeFooterView(this.daO);
        }
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
        if (this.dnV != null) {
            this.dnV.onChangeSkinType(this.dnT.getPageContext());
        }
        if (this.dnW.aqf() != null && this.dnW.aqf().getVisibility() == 0) {
            this.dnW.onChangeSkinType(this.dnT.getPageContext());
        }
        if (this.dnX.aqj() != null) {
            this.dnX.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dnV != null) {
            this.dnV.setSearchHint(str);
        }
    }

    public void aqq() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.doa == null) {
                this.doa = new CommonTipView(this.dnT.getActivity());
            }
            this.doa.setText(d.j.enter_forum_login_tip);
            this.doa.show(this.dnT.apE(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.doa != null) {
            this.doa.onDestroy();
        }
        if (this.dnX != null) {
            this.dnX.onDestroy();
        }
    }

    public void aT(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dnX.isShowing() && !v.E(list)) {
            this.dnX.aR(list);
        }
    }
}
