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
    private FrsADFragment fdA;
    private BdTypeRecyclerView fdB;
    private d fdC;
    private l fdD;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fdA = frsADFragment;
        this.fdB = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.fdC = new d(this.fdA.getPageContext(), c.fdQ, this.fdA.getUniqueId());
        this.fdD = new l(this.fdA.getPageContext(), m.fbJ);
        this.mAdapters.add(this.fdC);
        this.mAdapters.add(this.fdD);
        this.fdB.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.fdB.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.fdB.getAdapter().notifyDataSetChanged();
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
