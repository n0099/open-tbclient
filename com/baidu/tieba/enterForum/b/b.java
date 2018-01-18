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
    private BdListView cBd;
    private View dar;
    private ViewEventCenter dlJ;
    private f dnA;
    private com.baidu.tieba.enterForum.model.c dnB;
    private com.baidu.tieba.enterForum.multiConcern.a dnC;
    private boolean dnD;
    private List<com.baidu.tieba.enterForum.data.f> dnE;
    private CommonTipView dnF;
    private final com.baidu.tieba.enterForum.home.a dny;
    private com.baidu.tieba.enterForum.a.a dnz;
    private k mPullView;
    private View mRootView;
    private g refreshView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.dny = aVar;
        this.dlJ = viewEventCenter;
        this.dnB = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.dnC = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().wx(), viewEventCenter);
        bJ(view);
        this.dnz = new com.baidu.tieba.enterForum.a.a(this.dny.getPageContext(), this.dlJ);
        this.cBd.setAdapter((ListAdapter) this.dnz);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void bJ(View view) {
        this.cBd = (BdListView) view.findViewById(d.g.listview);
        this.cBd.setVerticalScrollBarEnabled(false);
        this.mPullView = new k(this.dny.getPageContext());
        this.mPullView.setTag(this.dny.getUniqueId());
        this.cBd.setPullRefresh(this.mPullView);
        this.dnA = new f(this.dny.getFragmentActivity());
        this.dnA.setEventCenter(this.dlJ);
        this.cBd.addHeaderView(this.dnA);
        BdListViewHelper.a(this.dny.getPageContext().getPageActivity(), this.cBd, BdListViewHelper.HeadType.DEFAULT);
        this.dar = new View(this.dny.getActivity());
        this.dar.setLayoutParams(new AbsListView.LayoutParams(-1, l.s(this.dny.getActivity(), d.e.ds0)));
    }

    public View apI() {
        this.dnA.ms(l.s(this.dny.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.dny.getPageContext().getPageActivity(), this.cBd, BdListViewHelper.HeadType.TIP);
    }

    public void bI(View view) {
        this.dnA.ms(l.s(this.dny.getPageContext().getPageActivity(), d.e.ds10));
        this.cBd.removeHeaderView(view);
    }

    public void bK(View view) {
        if (this.refreshView == null) {
            this.refreshView = new g(this.dny.getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    if (b.this.dnA != null) {
                        b.this.dnA.setVisibility(8);
                    }
                    b.this.startPullRefresh();
                }
            });
        }
        this.refreshView.id(this.dny.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.gF(this.dny.getString(d.j.neterror));
        this.mRootView = view;
        this.refreshView.j(view, true);
        this.refreshView.Mj();
        this.cBd.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.mRootView);
            this.refreshView = null;
            this.mRootView = null;
        }
        this.cBd.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.E(this.dnE);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.dnB.b(fVar);
    }

    public boolean apN() {
        return this.dnD;
    }

    public BdListView aqf() {
        return this.cBd;
    }

    public void aqg() {
        aS(this.dnB.getDataList());
    }

    public void mq(final int i) {
        this.dnD = true;
        if (this.dnB.aqa() == null) {
            this.dnB.createView();
            this.dnB.aqa().setVisibility(8);
        }
        d aqa = this.dnB.aqa();
        aqa.onChangeSkinType(this.dny.getPageContext());
        if (aqa.getParent() == null && this.dny.apF() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.dny.apz().getId());
            this.dny.apz().addView(aqa);
            this.dny.apE();
        }
        this.dnB.aP(this.dnE);
        com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.mr(i);
                com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.dnB.aqa() != null) {
                            b.this.dnB.aqa().setVisibility(0);
                            b.this.cBd.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void aqh() {
        this.dnD = false;
        this.cBd.setVisibility(0);
        if (this.dnB.aqa() != null && this.dny.apz() != null) {
            this.dny.apz().removeView(this.dnB.aqa());
            this.dnB.aqa().setVisibility(8);
        }
        this.dny.apE();
    }

    public void aqi() {
        this.dnD = true;
        this.cBd.setVisibility(8);
        if (this.dnB.aqa() != null) {
            this.dnB.aqa().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(int i) {
        if (this.dnB.aqa() != null && this.cBd != null && this.cBd.getChildCount() > 0) {
            int firstVisiblePosition = (this.cBd.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.cBd.getChildAt(0);
            this.dnB.aqa().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.cBd.startPullRefresh();
    }

    public void sV() {
        this.cBd.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> aqj() {
        return this.dnE;
    }

    public List<com.baidu.tieba.enterForum.data.f> aqk() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.dnB.getDataList();
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
        this.dnz.notifyDataSetChanged();
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
        this.dnE = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.D(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.apo().getType() == 1 && aVar.app().getType() == 2) {
                z = false;
                if (v.E(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.dny.getPageContext().getResources().getString(d.j.my_attention_bar), z));
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
                this.dnz.setData(arrayList);
                if (!this.dnD) {
                    this.cBd.setVisibility(8);
                    return;
                }
                aqh();
                this.dnA.setVisibility(0);
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
        this.dnz.setData(arrayList);
        if (!this.dnD) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.cBd.removeFooterView(this.dar);
            this.cBd.addFooterView(this.dar);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.cBd.removeFooterView(this.dar);
        }
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
        if (this.dnA != null) {
            this.dnA.onChangeSkinType(this.dny.getPageContext());
        }
        if (this.dnB.aqa() != null && this.dnB.aqa().getVisibility() == 0) {
            this.dnB.onChangeSkinType(this.dny.getPageContext());
        }
        if (this.dnC.aqe() != null) {
            this.dnC.onChangeSkinType();
        }
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.dnA != null) {
            this.dnA.setSearchHint(str);
        }
    }

    public void aql() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.dnF == null) {
                this.dnF = new CommonTipView(this.dny.getActivity());
            }
            this.dnF.setText(d.j.enter_forum_login_tip);
            this.dnF.show(this.dny.apz(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.dnF != null) {
            this.dnF.onDestroy();
        }
        if (this.dnC != null) {
            this.dnC.onDestroy();
        }
    }

    public void aT(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.dnC.isShowing() && !v.E(list)) {
            this.dnC.aR(list);
        }
    }
}
