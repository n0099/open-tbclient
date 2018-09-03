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
    private FrsADFragment dqe;
    private BdTypeRecyclerView dqf;
    private d dqg;
    private l dqh;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dqe = frsADFragment;
        this.dqf = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dqg = new d(this.dqe.getPageContext(), c.dqt, this.dqe.getUniqueId());
        this.dqh = new l(this.dqe.getPageContext(), m.doT);
        this.mAdapters.add(this.dqg);
        this.mAdapters.add(this.dqh);
        this.dqf.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dqf.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dqf.getAdapter().notifyDataSetChanged();
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
