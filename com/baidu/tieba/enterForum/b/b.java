package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private BdListView bMm;
    private View chl;
    private ViewEventCenter csJ;
    private final com.baidu.tieba.enterForum.home.a cuB;
    private com.baidu.tieba.enterForum.a.a cuC;
    private f cuD;
    private com.baidu.tieba.enterForum.model.c cuE;
    private com.baidu.tieba.enterForum.multiConcern.a cuF;
    private boolean cuG;
    private List<com.baidu.tieba.enterForum.data.f> cuH;
    private CommonTipView cuI;
    private g mNoDataView;
    private i mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.cuB = aVar;
        this.csJ = viewEventCenter;
        this.cuE = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cuF = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oV(), viewEventCenter);
        au(view);
        this.cuC = new com.baidu.tieba.enterForum.a.a(this.cuB.getPageContext(), this.csJ);
        this.bMm.setAdapter((ListAdapter) this.cuC);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void au(View view) {
        this.bMm = (BdListView) view.findViewById(d.g.listview);
        this.bMm.setVerticalScrollBarEnabled(false);
        this.mPullView = new i(this.cuB.getPageContext());
        this.mPullView.setTag(this.cuB.getUniqueId());
        this.bMm.setPullRefresh(this.mPullView);
        this.cuD = new f(this.cuB.getFragmentActivity());
        this.cuD.setEventCenter(this.csJ);
        this.bMm.addHeaderView(this.cuD);
        BdListViewHelper.a(this.cuB.getPageContext().getPageActivity(), this.bMm, BdListViewHelper.HeadType.DEFAULT);
        this.chl = new View(this.cuB.getActivity());
        this.chl.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.cuB.getActivity(), d.e.ds0)));
    }

    public View ahe() {
        this.cuD.jr(l.f(this.cuB.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cuB.getPageContext().getPageActivity(), this.bMm, BdListViewHelper.HeadType.TIP);
    }

    public void at(View view) {
        this.cuD.jr(l.f(this.cuB.getPageContext().getPageActivity(), d.e.ds10));
        this.bMm.removeHeaderView(view);
    }

    public void av(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cuB.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, l.f(this.cuB.getPageContext().getContext(), d.e.ds300), l.f(this.cuB.getPageContext().getContext(), d.e.ds480), l.f(this.cuB.getPageContext().getContext(), d.e.ds360)), NoDataViewFactory.d.af(this.cuB.getString(d.j.neterror), this.cuB.getString(d.j.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cuB.getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.cuD.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.cuB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bMm.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bMm.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.w(this.cuH);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.cuE.b(fVar);
    }

    public boolean ahj() {
        return this.cuG;
    }

    public BdListView ahB() {
        return this.bMm;
    }

    public void ahC() {
        aJ(this.cuE.getDataList());
    }

    public void jp(final int i) {
        this.cuG = true;
        if (this.cuE.ahw() == null) {
            this.cuE.createView();
            this.cuE.ahw().setVisibility(8);
        }
        d ahw = this.cuE.ahw();
        ahw.onChangeSkinType(this.cuB.getPageContext());
        if (ahw.getParent() == null && this.cuB.ahb() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cuB.agV().getId());
            this.cuB.agV().addView(ahw);
            this.cuB.aha();
        }
        this.cuE.aG(this.cuH);
        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.jq(i);
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.cuE.ahw() != null) {
                            b.this.cuE.ahw().setVisibility(0);
                            b.this.bMm.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void ahD() {
        this.cuG = false;
        this.bMm.setVisibility(0);
        if (this.cuE.ahw() != null && this.cuB.agV() != null) {
            this.cuB.agV().removeView(this.cuE.ahw());
            this.cuE.ahw().setVisibility(8);
        }
        this.cuB.aha();
    }

    public void ahE() {
        this.cuG = true;
        this.bMm.setVisibility(8);
        if (this.cuE.ahw() != null) {
            this.cuE.ahw().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(int i) {
        if (this.cuE.ahw() != null && this.bMm != null && this.bMm.getChildCount() > 0) {
            int firstVisiblePosition = (this.bMm.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bMm.getChildAt(0);
            this.cuE.ahw().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bMm.startPullRefresh();
    }

    public void ahF() {
        this.bMm.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> ahG() {
        return this.cuH;
    }

    public List<com.baidu.tieba.enterForum.data.f> ahH() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.cuE.getDataList();
        com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) v.c(dataList, 0);
        if (fVar != null && fVar.getType() == 1) {
            v.d(dataList, 0);
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
        this.cuC.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aJ(List<com.baidu.tieba.enterForum.data.f> list) {
        boolean z;
        this.cuH = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.v(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.agK().getType() == 1 && aVar.agL().getType() == 2) {
                z = false;
                if (v.w(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cuB.getPageContext().getResources().getString(d.j.my_attention_bar), z));
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
                this.cuC.setData(arrayList);
                if (!this.cuG) {
                    this.bMm.setVisibility(8);
                    return;
                }
                ahD();
                this.cuD.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.w(a)) {
        }
        com.baidu.tieba.enterForum.data.c cVar22 = new com.baidu.tieba.enterForum.data.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.cuC.setData(arrayList);
        if (!this.cuG) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bMm.removeFooterView(this.chl);
            this.bMm.addFooterView(this.chl);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bMm.removeFooterView(this.chl);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.cuD != null) {
            this.cuD.onChangeSkinType(this.cuB.getPageContext());
        }
        if (this.cuE.ahw() != null && this.cuE.ahw().getVisibility() == 0) {
            this.cuE.onChangeSkinType(this.cuB.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cuB.getPageContext(), i);
        }
        if (this.cuF.ahA() != null) {
            this.cuF.onChangeSkinType();
        }
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cuD != null) {
            this.cuD.setSearchHint(str);
        }
    }

    public void ahI() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cuI == null) {
                this.cuI = new CommonTipView(this.cuB.getActivity());
            }
            this.cuI.setText(d.j.enter_forum_login_tip);
            this.cuI.show(this.cuB.agV(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cuI != null) {
            this.cuI.onDestroy();
        }
        if (this.cuF != null) {
            this.cuF.onDestroy();
        }
    }

    public void aK(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cuF.isShowing() && !v.w(list)) {
            this.cuF.aI(list);
        }
    }
}
