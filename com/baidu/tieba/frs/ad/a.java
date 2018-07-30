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
    private FrsADFragment dqg;
    private BdTypeRecyclerView dqh;
    private d dqi;
    private l dqj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dqg = frsADFragment;
        this.dqh = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dqi = new d(this.dqg.getPageContext(), c.dqv, this.dqg.getUniqueId());
        this.dqj = new l(this.dqg.getPageContext(), m.doV);
        this.mAdapters.add(this.dqi);
        this.mAdapters.add(this.dqj);
        this.dqh.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dqh.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dqh.getAdapter().notifyDataSetChanged();
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
