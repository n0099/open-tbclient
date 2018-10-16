package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private FrsADFragment dEt;
    private BdTypeRecyclerView dEu;
    private d dEv;
    private l dEw;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dEt = frsADFragment;
        this.dEu = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dEv = new d(this.dEt.getPageContext(), c.dEI, this.dEt.getUniqueId());
        this.dEw = new l(this.dEt.getPageContext(), m.dCR);
        this.mAdapters.add(this.dEv);
        this.mAdapters.add(this.dEw);
        this.dEu.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dEu.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dEu.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
    }
}
