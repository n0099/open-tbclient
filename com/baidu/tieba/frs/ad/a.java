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
    private FrsADFragment fyX;
    private BdTypeRecyclerView fyY;
    private d fyZ;
    private l fza;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fyX = frsADFragment;
        this.fyY = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.fyZ = new d(this.fyX.getPageContext(), c.fzn, this.fyX.getUniqueId());
        this.fza = new l(this.fyX.getPageContext(), m.fxi);
        this.mAdapters.add(this.fyZ);
        this.mAdapters.add(this.fza);
        this.fyY.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.fyY.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.fyY.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void setOnAdapterItemClickListener(s sVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.setOnAdapterItemClickListener(sVar);
                }
            }
        }
    }
}
