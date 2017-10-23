package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.b.g;
import com.baidu.tieba.view.CommonTipView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private View bQE;
    private BdListView byS;
    private ViewEventCenter cbZ;
    private final com.baidu.tieba.enterForum.home.a ccC;
    private com.baidu.tieba.enterForum.a.a cdU;
    private f cdV;
    private com.baidu.tieba.enterForum.model.c cdW;
    private com.baidu.tieba.enterForum.multiConcern.a cdX;
    private boolean cdY = false;
    private boolean cdZ;
    private List<g> cea;
    private CommonTipView ceb;
    private TextView cec;
    private com.baidu.tbadk.core.view.f mNoDataView;
    private h mPullView;

    public b(com.baidu.tieba.enterForum.home.a aVar, View view, ViewEventCenter viewEventCenter) {
        this.ccC = aVar;
        this.cbZ = viewEventCenter;
        this.cdW = new com.baidu.tieba.enterForum.model.c(aVar.getPageContext(), viewEventCenter);
        this.cdX = new com.baidu.tieba.enterForum.multiConcern.a(aVar.getPageContext(), aVar.getBaseFragmentActivity().oJ(), viewEventCenter);
        an(view);
        this.cdU = new com.baidu.tieba.enterForum.a.a(this.ccC.getPageContext(), this.cbZ);
        this.byS.setAdapter((ListAdapter) this.cdU);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    private void an(View view) {
        this.byS = (BdListView) view.findViewById(d.h.listview);
        this.byS.setVerticalScrollBarEnabled(false);
        this.mPullView = new h(this.ccC.getPageContext());
        this.mPullView.setTag(this.ccC.getUniqueId());
        this.byS.setPullRefresh(this.mPullView);
        this.cdV = new f(this.ccC.getFragmentActivity());
        this.cdV.setEventCenter(this.cbZ);
        this.byS.addHeaderView(this.cdV);
        this.cec = (TextView) BdListViewHelper.a(this.ccC.getPageContext().getPageActivity(), this.byS, BdListViewHelper.HeadType.DEFAULT);
        this.bQE = new View(this.ccC.getActivity());
        this.bQE.setLayoutParams(new AbsListView.LayoutParams(-1, l.f(this.ccC.getActivity(), d.f.ds0)));
    }

    public void ao(View view) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ccC.getPageContext().getContext(), view, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, d.g.net_refresh_emotion, l.f(this.ccC.getPageContext().getContext(), d.f.ds300), l.f(this.ccC.getPageContext().getContext(), d.f.ds480), l.f(this.ccC.getPageContext().getContext(), d.f.ds360)), NoDataViewFactory.d.af(this.ccC.getString(d.l.neterror), this.ccC.getString(d.l.refresh_view_title_text)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ccC.getString(d.l.refresh_view_button_text), new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.hideNoDataView();
                    b.this.cdV.setVisibility(8);
                    b.this.startPullRefresh();
                }
            })));
        }
        this.mNoDataView.onChangeSkinType(this.ccC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.byS.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
        this.byS.setVisibility(0);
    }

    public boolean isEmpty() {
        return v.u(this.cea);
    }

    public void b(g gVar) {
        this.cdW.b(gVar);
    }

    public void ej(boolean z) {
        this.cdY = z;
    }

    public boolean acU() {
        return this.cdZ;
    }

    public BdListView ado() {
        return this.byS;
    }

    public void adp() {
        av(this.cdW.getDataList());
    }

    public void iB(final int i) {
        this.cdZ = true;
        if (this.cdW.adh() == null) {
            this.cdW.adi();
            this.cdW.adh().setVisibility(8);
        }
        d adh = this.cdW.adh();
        adh.k(this.ccC.getPageContext());
        if (adh.getParent() == null && this.ccC.acN() != null) {
            new RelativeLayout.LayoutParams(-1, -1).addRule(3, this.ccC.acI().getId());
            this.ccC.acI().addView(adh);
            this.ccC.acM();
        }
        this.cdW.as(this.cea);
        com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.iC(i);
                com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.enterForum.c.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.cdW.adh() != null) {
                            b.this.cdW.adh().setVisibility(0);
                            b.this.byS.setVisibility(8);
                        }
                    }
                });
            }
        });
    }

    public void adq() {
        this.cdZ = false;
        this.byS.setVisibility(0);
        if (this.cdW.adh() != null && this.ccC.acI() != null) {
            this.ccC.acI().removeView(this.cdW.adh());
            this.cdW.adh().setVisibility(8);
        }
        this.ccC.acM();
    }

    public void adr() {
        this.cdZ = true;
        this.byS.setVisibility(8);
        if (this.cdW.adh() != null) {
            this.cdW.adh().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC(int i) {
        if (this.cdW.adh() != null && this.byS != null && this.byS.getChildCount() > 0) {
            int firstVisiblePosition = (this.byS.getFirstVisiblePosition() * 2) - 1;
            if (firstVisiblePosition < 0) {
                firstVisiblePosition = 0;
            }
            View childAt = this.byS.getChildAt(0);
            this.cdW.adh().setSelectionFromTop(firstVisiblePosition, childAt != null ? childAt.getTop() : 0);
        }
    }

    public void startPullRefresh() {
        this.byS.startPullRefresh();
    }

    public void ads() {
        this.byS.completePullRefreshPostDelayed(2000L);
    }

    public List<g> adt() {
        return this.cea;
    }

    public List<g> adu() {
        List<g> dataList = this.cdW.getDataList();
        g gVar = (g) v.c(dataList, 0);
        if (gVar != null && gVar.getType() == 1) {
            v.d(dataList, 0);
        }
        return dataList;
    }

    private List<com.baidu.tieba.enterForum.b.c> a(List list, boolean z, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        int size = list.size();
        int i3 = 1;
        int i4 = 0;
        while (i4 < size && (i2 <= 0 || i3 < i2 * 2)) {
            com.baidu.tieba.enterForum.b.e eVar = new com.baidu.tieba.enterForum.b.e();
            com.baidu.tieba.enterForum.b.e eVar2 = new com.baidu.tieba.enterForum.b.e();
            if (i3 < size) {
                eVar = (com.baidu.tieba.enterForum.b.e) list.get(i4);
                eVar2 = (com.baidu.tieba.enterForum.b.e) list.get(i3);
                eVar.setType(i);
                eVar2.setType(i);
            } else if (i4 < size) {
                eVar = (com.baidu.tieba.enterForum.b.e) list.get(i4);
                eVar.setType(i);
                eVar2.setType(2);
            }
            arrayList.add(new com.baidu.tieba.enterForum.b.a(eVar, eVar2));
            int i5 = i4 + 2;
            i3 = i5 + 1;
            i4 = i5;
        }
        return arrayList;
    }

    public void notifyDataSetChanged() {
        this.cdU.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void av(List<g> list) {
        boolean z;
        this.cea = list;
        ArrayList arrayList = new ArrayList();
        List<com.baidu.tieba.enterForum.b.c> a = a(list, false, 0, 0);
        if (v.t(a) == 1 && (a.get(0) instanceof com.baidu.tieba.enterForum.b.a)) {
            com.baidu.tieba.enterForum.b.a aVar = (com.baidu.tieba.enterForum.b.a) a.get(0);
            if (aVar.acw().getType() == 1 && aVar.acx().getType() == 2) {
                z = false;
                if (v.u(a)) {
                    arrayList.add(new com.baidu.tieba.enterForum.b.d(this.ccC.getPageContext().getResources().getString(d.l.my_attention_bar), z));
                    arrayList.addAll(a);
                } else {
                    com.baidu.tieba.enterForum.b.c cVar = new com.baidu.tieba.enterForum.b.c();
                    cVar.setType(3);
                    arrayList.add(cVar);
                }
                com.baidu.tieba.enterForum.b.c cVar2 = new com.baidu.tieba.enterForum.b.c();
                cVar2.setType(2);
                arrayList.add(cVar2);
                hideNoDataView();
                this.cdU.setData(arrayList);
                if (!this.cdZ) {
                    this.byS.setVisibility(8);
                    return;
                }
                adq();
                this.cdV.setVisibility(0);
                return;
            }
        }
        z = true;
        if (v.u(a)) {
        }
        com.baidu.tieba.enterForum.b.c cVar22 = new com.baidu.tieba.enterForum.b.c();
        cVar22.setType(2);
        arrayList.add(cVar22);
        hideNoDataView();
        this.cdU.setData(arrayList);
        if (!this.cdZ) {
        }
    }

    public void onChangeSkinType(int i) {
        if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
            this.byS.removeFooterView(this.bQE);
            this.byS.addFooterView(this.bQE);
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            this.byS.removeFooterView(this.bQE);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.cdV != null) {
            this.cdV.k(this.ccC.getPageContext());
        }
        if (this.cdW.adh() != null && this.cdW.adh().getVisibility() == 0) {
            this.cdW.k(this.ccC.getPageContext());
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ccC.getPageContext(), i);
        }
        if (this.cdX.adn() != null) {
            this.cdX.onChangeSkinType();
        }
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setSearchHint(String str) {
        if (this.cdV != null) {
            this.cdV.setSearchHint(str);
        }
    }

    public void adv() {
        if (TbadkCoreApplication.getCurrentAccount() == null && com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("enter_forum_login_tip", true)) {
            if (this.ceb == null) {
                this.ceb = new CommonTipView(this.ccC.getActivity());
            }
            this.ceb.setText(d.l.enter_forum_login_tip);
            this.ceb.a(this.ccC.acI(), TbadkCoreApplication.getInst().getSkinType());
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("enter_forum_login_tip", false);
        }
    }

    public void onDestroy() {
        if (this.ceb != null) {
            this.ceb.onDestroy();
        }
        if (this.cdX != null) {
            this.cdX.onDestroy();
        }
    }

    public void aw(List<com.baidu.tieba.enterForum.multiConcern.b> list) {
        if (!this.cdX.isShowing() && !v.u(list)) {
            this.cdX.au(list);
        }
    }
}
