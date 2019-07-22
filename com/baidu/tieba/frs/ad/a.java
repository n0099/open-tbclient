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
    private d fyA;
    private l fyB;
    private FrsADFragment fyy;
    private BdTypeRecyclerView fyz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fyy = frsADFragment;
        this.fyz = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.fyA = new d(this.fyy.getPageContext(), c.fyO, this.fyy.getUniqueId());
        this.fyB = new l(this.fyy.getPageContext(), m.fwJ);
        this.mAdapters.add(this.fyA);
        this.mAdapters.add(this.fyB);
        this.fyz.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.fyz.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.fyz.getAdapter().notifyDataSetChanged();
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
