package com.baidu.tieba.homepage.listview;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.listview.card.discover.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aRI = new ArrayList();
    private BdTypeListView aRs;
    private TbPageContext<BaseFragmentActivity> mContext;

    public b(TbPageContext<BaseFragmentActivity> tbPageContext, BdTypeListView bdTypeListView) {
        this.mContext = tbPageContext;
        this.aRs = bdTypeListView;
        a(this.aRs);
    }

    private void a(BdTypeListView bdTypeListView) {
        if (bdTypeListView != null) {
            com.baidu.tieba.homepage.listview.card.h.a aVar = new com.baidu.tieba.homepage.listview.card.h.a(this.mContext, com.baidu.tieba.homepage.listview.card.h.b.bBv);
            com.baidu.tieba.homepage.listview.card.g.a aVar2 = new com.baidu.tieba.homepage.listview.card.g.a(this.mContext, com.baidu.tieba.homepage.listview.card.g.b.bAT);
            com.baidu.tieba.homepage.listview.card.c.a aVar3 = new com.baidu.tieba.homepage.listview.card.c.a(this.mContext, com.baidu.tieba.homepage.listview.card.c.d.bzT);
            com.baidu.tieba.homepage.listview.card.b.a aVar4 = new com.baidu.tieba.homepage.listview.card.b.a(this.mContext, com.baidu.tieba.homepage.listview.card.b.b.bzu);
            com.baidu.tieba.homepage.listview.card.f.a aVar5 = new com.baidu.tieba.homepage.listview.card.f.a(this.mContext, com.baidu.tieba.homepage.listview.card.f.b.bAC);
            com.baidu.tieba.homepage.listview.card.discover.a aVar6 = new com.baidu.tieba.homepage.listview.card.discover.a(this.mContext, h.byX);
            com.baidu.tieba.homepage.listview.card.j.a aVar7 = new com.baidu.tieba.homepage.listview.card.j.a(this.mContext, com.baidu.tieba.homepage.listview.card.j.b.bBX);
            com.baidu.tieba.homepage.listview.card.d.a aVar8 = new com.baidu.tieba.homepage.listview.card.d.a(this.mContext, com.baidu.tieba.homepage.listview.card.d.b.bAf);
            com.baidu.tieba.homepage.listview.card.e.a aVar9 = new com.baidu.tieba.homepage.listview.card.e.a(this.mContext, com.baidu.tieba.homepage.listview.card.e.b.bAm);
            com.baidu.tieba.homepage.listview.card.i.a aVar10 = new com.baidu.tieba.homepage.listview.card.i.a(this.mContext, com.baidu.tieba.homepage.listview.card.i.b.bBN);
            this.aRI.add(aVar);
            this.aRI.add(aVar3);
            this.aRI.add(aVar2);
            this.aRI.add(aVar4);
            this.aRI.add(aVar5);
            this.aRI.add(aVar6);
            this.aRI.add(aVar7);
            this.aRI.add(aVar8);
            this.aRI.add(aVar9);
            this.aRI.add(aVar10);
            bdTypeListView.g(this.aRI);
        }
    }

    private boolean c(u uVar) {
        if (uVar == null || uVar.getType() == null || this.aRI == null) {
            return false;
        }
        for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
            if (aVar != null && uVar.getType().equals(aVar.getType())) {
                return true;
            }
        }
        return false;
    }

    public void aN(List<u> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (u uVar : list) {
                if (!c(uVar)) {
                    arrayList.add(uVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public void J(ArrayList<u> arrayList) {
        if (y.k(this.aRI) != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aRI) {
                if (aVar instanceof a) {
                    ((a) aVar).aRB = true;
                }
            }
        }
        if (this.aRs != null) {
            this.aRs.setData(arrayList);
        }
    }

    public void notifyDataSetChanged() {
        if (this.aRs != null && (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
        }
    }
}
