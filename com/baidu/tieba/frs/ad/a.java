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
    private FrsADFragment fdn;
    private BdTypeRecyclerView fdo;
    private d fdp;
    private l fdq;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fdn = frsADFragment;
        this.fdo = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.fdp = new d(this.fdn.getPageContext(), c.fdD, this.fdn.getUniqueId());
        this.fdq = new l(this.fdn.getPageContext(), m.fbw);
        this.mAdapters.add(this.fdp);
        this.mAdapters.add(this.fdq);
        this.fdo.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.fdo.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.fdo.getAdapter().notifyDataSetChanged();
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
