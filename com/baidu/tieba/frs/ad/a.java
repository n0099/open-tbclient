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
    private FrsADFragment dFJ;
    private BdTypeRecyclerView dFK;
    private d dFL;
    private l dFM;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dFJ = frsADFragment;
        this.dFK = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dFL = new d(this.dFJ.getPageContext(), c.dFY, this.dFJ.getUniqueId());
        this.dFM = new l(this.dFJ.getPageContext(), m.dEh);
        this.mAdapters.add(this.dFL);
        this.mAdapters.add(this.dFM);
        this.dFK.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dFK.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dFK.getAdapter().notifyDataSetChanged();
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
