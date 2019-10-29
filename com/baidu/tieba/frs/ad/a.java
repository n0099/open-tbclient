package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private d fAa;
    private l fAb;
    private FrsADFragment fzY;
    private BdTypeRecyclerView fzZ;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fzY = frsADFragment;
        this.fzZ = bdTypeRecyclerView;
        sX();
    }

    private void sX() {
        this.fAa = new d(this.fzY.getPageContext(), c.fAo, this.fzY.getUniqueId());
        this.fAb = new l(this.fzY.getPageContext(), m.fyi);
        this.agQ.add(this.fAa);
        this.agQ.add(this.fAb);
        this.fzZ.addAdapters(this.agQ);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.fzZ.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.fzZ.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(s sVar) {
        if (this.agQ != null && this.agQ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(sVar);
                }
            }
        }
    }
}
