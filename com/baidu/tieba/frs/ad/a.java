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
    private FrsADFragment dOW;
    private BdTypeRecyclerView dOX;
    private d dOY;
    private l dOZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dOW = frsADFragment;
        this.dOX = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dOY = new d(this.dOW.getPageContext(), c.dPl, this.dOW.getUniqueId());
        this.dOZ = new l(this.dOW.getPageContext(), m.dNu);
        this.mAdapters.add(this.dOY);
        this.mAdapters.add(this.dOZ);
        this.dOX.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dOX.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dOX.getAdapter().notifyDataSetChanged();
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
