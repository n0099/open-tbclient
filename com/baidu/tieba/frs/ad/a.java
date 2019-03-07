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
    private FrsADFragment fdB;
    private BdTypeRecyclerView fdC;
    private d fdD;
    private l fdE;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fdB = frsADFragment;
        this.fdC = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.fdD = new d(this.fdB.getPageContext(), c.fdR, this.fdB.getUniqueId());
        this.fdE = new l(this.fdB.getPageContext(), m.fbK);
        this.mAdapters.add(this.fdD);
        this.mAdapters.add(this.fdE);
        this.fdC.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.fdC.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.fdC.getAdapter().notifyDataSetChanged();
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
