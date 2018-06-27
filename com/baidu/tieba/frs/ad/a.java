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
    private FrsADFragment dnm;
    private BdTypeRecyclerView dnn;
    private d dno;
    private l dnp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dnm = frsADFragment;
        this.dnn = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dno = new d(this.dnm.getPageContext(), c.dnC, this.dnm.getUniqueId());
        this.dnp = new l(this.dnm.getPageContext(), m.dmd);
        this.mAdapters.add(this.dno);
        this.mAdapters.add(this.dnp);
        this.dnn.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dnn.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dnn.getAdapter().notifyDataSetChanged();
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
