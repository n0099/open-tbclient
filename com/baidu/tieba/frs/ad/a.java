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
    private FrsADFragment dPG;
    private BdTypeRecyclerView dPH;
    private d dPI;
    private l dPJ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dPG = frsADFragment;
        this.dPH = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dPI = new d(this.dPG.getPageContext(), c.dPV, this.dPG.getUniqueId());
        this.dPJ = new l(this.dPG.getPageContext(), m.dOe);
        this.mAdapters.add(this.dPI);
        this.mAdapters.add(this.dPJ);
        this.dPH.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dPH.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dPH.getAdapter().notifyDataSetChanged();
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
