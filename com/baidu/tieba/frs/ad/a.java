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
    private FrsADFragment ftC;
    private BdTypeRecyclerView ftD;
    private d ftE;
    private l ftF;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ftC = frsADFragment;
        this.ftD = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.ftE = new d(this.ftC.getPageContext(), c.ftS, this.ftC.getUniqueId());
        this.ftF = new l(this.ftC.getPageContext(), m.frM);
        this.mAdapters.add(this.ftE);
        this.mAdapters.add(this.ftF);
        this.ftD.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.ftD.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.ftD.getAdapter().notifyDataSetChanged();
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
