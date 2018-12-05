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
    private FrsADFragment dMi;
    private BdTypeRecyclerView dMj;
    private d dMk;
    private l dMl;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dMi = frsADFragment;
        this.dMj = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dMk = new d(this.dMi.getPageContext(), c.dMx, this.dMi.getUniqueId());
        this.dMl = new l(this.dMi.getPageContext(), m.dKG);
        this.mAdapters.add(this.dMk);
        this.mAdapters.add(this.dMl);
        this.dMj.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dMj.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dMj.getAdapter().notifyDataSetChanged();
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
