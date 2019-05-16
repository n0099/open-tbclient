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
    private FrsADFragment ftB;
    private BdTypeRecyclerView ftC;
    private d ftD;
    private l ftE;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ftB = frsADFragment;
        this.ftC = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.ftD = new d(this.ftB.getPageContext(), c.ftR, this.ftB.getUniqueId());
        this.ftE = new l(this.ftB.getPageContext(), m.frL);
        this.mAdapters.add(this.ftD);
        this.mAdapters.add(this.ftE);
        this.ftC.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.ftC.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.ftC.getAdapter().notifyDataSetChanged();
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
