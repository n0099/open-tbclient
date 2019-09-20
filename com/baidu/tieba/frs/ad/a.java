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
    private FrsADFragment fAK;
    private BdTypeRecyclerView fAL;
    private d fAM;
    private l fAN;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fAK = frsADFragment;
        this.fAL = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.fAM = new d(this.fAK.getPageContext(), c.fBa, this.fAK.getUniqueId());
        this.fAN = new l(this.fAK.getPageContext(), m.fyV);
        this.mAdapters.add(this.fAM);
        this.mAdapters.add(this.fAN);
        this.fAL.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.fAL.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.fAL.getAdapter().notifyDataSetChanged();
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
