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
    private BdListView bMi;
    private View chh;
    private ViewEventCenter csF;
    private com.baidu.tieba.enterForum.model.c cuA;
    private com.baidu.tieba.enterForum.multiConcern.a cuB;
    private boolean cuC;
    private List<com.baidu.tieba.enterForum.data.f> cuD;
    private CommonTipView cuE;
    private final com.baidu.tieba.enterForum.home.a cux;
    private com.baidu.tieba.enterForum.a.a cuy;
    private f cuz;
    private g mNoDataView;
    private i mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.cux = aVar;
        this.csF = viewEventCenter;
        this.cuA = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cuB = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oV(), viewEventCenter);
        at(view);
        this.cuy = new com.baidu.tieba.enterForum.a.a(this.cux.getPageContext(), this.csF);
        this.bMi.setAdapter((ListAdapter) this.cuy);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void at(View view) {
        this.bMi = (BdListView) view.findViewById(d.g.listview);
        this.bMi.setVerticalScrollBarEnabled(false);
        this.mPullView = new i(this.cux.getPageContext());
        this.mPullView.setTag(this.cux.getUniqueId());
        this.bMi.setPullRefresh(this.mPullView);
        this.cuz = new f(this.cux.getFragmentActivity());
        this.cuz.setEventCenter(this.csF);
        this.bMi.addHeaderView(this.cuz);
        BdListViewHelper.a(this.cux.getPageContext().getPageActivity(), this.bMi, BdListViewHelper.HeadType.DEFAULT);
        this.chh = new View(this.cux.getActivity());
        this.chh.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.cux.getActivity(), d.e.ds0)));
    }

    public View ahf() {
        this.cuz.jr(l.f(this.cux.getPageContext().getPageActivity(), d.e.ds20));
        return BdListViewHelper.a(this.cux.getPageContext().getPageActivity(), this.bMi, BdListViewHelper.HeadType.TIP);
    }

    public void as(View view) {
        this.cuz.jr(l.f(this.cux.getPageContext().getPageActivity(), d.e.ds10));
        this.bMi.removeHeaderView(view);
    }

    public void au(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cux.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.f.net_refresh_emotion, l.f(this.cux.getPageContext().getContext(), d.e.ds300), l.f(this.cux.getPageContext().getContext(), d.e.ds480), l.f(this.cux.getPageContext().getContext(), d.e.ds360)), NoDataViewFactory.d.af(this.cux.getString(d.j.neterror), this.cux.getString(d.j.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cux.getString(d.j.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.cuz.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.cux.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.bMi.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.bMi.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.w(this.cuD);
    }

    public void b(com.baidu.tieba.enterForum.data.f fVar) {
        this.cuA.b(fVar);
    }

    public boolean ahk() {
        return this.cuC;
    }

    public BdListView ahC() {
        return this.bMi;
    }

    public void ahD() {
        aJ(this.cuA.getDataList());
    }

    public void jp(final int i) {
        this.cuC = true;
        if (this.cuA.ahx() == null) {
            this.cuA.createView();
            this.cuA.ahx().setVisibility(8);
        }
        d ahx = this.cuA.ahx();
        ahx.onChangeSkinType(this.cux.getPageContext());
        if (ahx.getParent() == null && this.cux.ahc() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.cux.agW().getId());
            this.cux.agW().addView(ahx);
            this.cux.ahb();
        }
        this.cuA.aG(this.cuD);
        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.jq(i);
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.b.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.cuA.ahx() != null) {
                            b.this.cuA.ahx().setVisibility(0);
                            b.this.bMi.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void ahE() {
        this.cuC = false;
        this.bMi.setVisibility(0);
        if (this.cuA.ahx() != null && this.cux.agW() != null) {
            this.cux.agW().removeView(this.cuA.ahx());
            this.cuA.ahx().setVisibility(8);
        }
        this.cux.ahb();
    }

    public void ahF() {
        this.cuC = true;
        this.bMi.setVisibility(8);
        if (this.cuA.ahx() != null) {
            this.cuA.ahx().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq(int i) {
        if (this.cuA.ahx() != null && this.bMi != null && this.bMi.getChildCount() > 0) {
            int firstVisiblePosition = (this.bMi.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.bMi.getChildAt(0);
            this.cuA.ahx().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.bMi.startPullRefresh();
    }

    public void ahG() {
        this.bMi.completePullRefreshPostDelayed(2000L);
    }

    public List<com.baidu.tieba.enterForum.data.f> ahH() {
        return this.cuD;
    }

    public List<com.baidu.tieba.enterForum.data.f> ahI() {
        List<com.baidu.tieba.enterForum.data.f> dataList = this.cuA.getDataList();
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
        this.cuy.notifyDataSetChanged();
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
        this.cuD = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.data.c> a = a(list, false, 0, 0);
        if (v.v(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.data.a)) {
            com.baidu.tieba.enterForum.data.a aVar = (com.baidu.tieba.enterForum.data.a) a.get(0);
            if (aVar.agL().getType() == 1 && aVar.agM().getType() == 2) {
                z = false;
                if (v.w(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.data.d(this.cux.getPageContext().getResources().getString(d.j.my_attention_bar), z));
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
                this.cuy.setData(arrayList);
                if (!this.cuC) {
                    this.bMi.setVisibility(8);
                    return;
                }
                ahE();
                this.cuz.setVisibility(0);
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
        this.cuy.setData(arrayList);
        if (!this.cuC) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.bMi.removeFooterView(this.chh);
            this.bMi.addFooterView(this.chh);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.bMi.removeFooterView(this.chh);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.cuz != null) {
            this.cuz.onChangeSkinType(this.cux.getPageContext());
        }
        if (this.cuA.ahx() != null && this.cuA.ahx().getVisibility() == 0) {
            this.cuA.onChangeSkinType(this.cux.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cux.getPageContext(), i);
        }
        if (this.cuB.ahB() != null) {
            this.cuB.onChangeSkinType();
        }
    }

    public void a(h.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cuz != null) {
            this.cuz.setSearchHint(str);
        }
    }

    public void ahJ() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.cuE == null) {
                this.cuE = new CommonTipView(this.cux.getActivity());
            }
            this.cuE.setText(d.j.enter_forum_login_tip);
            this.cuE.show(this.cux.agW(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.cuE != null) {
            this.cuE.onDestroy();
        }
        if (this.cuB != null) {
            this.cuB.onDestroy();
        }
    }

    public void aK(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cuB.isShowing() && !v.w(list)) {
            this.cuB.aI(list);
        }
    }
}
