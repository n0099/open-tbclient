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
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private FrsADFragment fzh;
    private BdTypeRecyclerView fzi;
    private d fzj;
    private l fzk;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.fzh = frsADFragment;
        this.fzi = bdTypeRecyclerView;
        sY();
    }

    private void sY() {
        this.fzj = new d(this.fzh.getPageContext(), c.fzx, this.fzh.getUniqueId());
        this.fzk = new l(this.fzh.getPageContext(), m.fxr);
        this.agy.add(this.fzj);
        this.agy.add(this.fzk);
        this.fzi.addAdapters(this.agy);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.fzi.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.fzi.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(s sVar) {
        if (this.agy != null && this.agy.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(sVar);
                }
            }
        }
    }
}
