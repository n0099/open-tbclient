package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private FrsADFragment dws;
    private BdTypeRecyclerView dwt;
    private d dwu;
    private l dwv;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dws = frsADFragment;
        this.dwt = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dwu = new d(this.dws.getPageContext(), c.dwH, this.dws.getUniqueId());
        this.dwv = new l(this.dws.getPageContext(), m.duQ);
        this.mAdapters.add(this.dwu);
        this.mAdapters.add(this.dwv);
        this.dwt.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dwt.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dwt.getAdapter().notifyDataSetChanged();
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
