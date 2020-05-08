package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private FrsADFragment hcX;
    private BdTypeRecyclerView hcY;
    private d hcZ;
    private o hda;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hcX = frsADFragment;
        this.hcY = bdTypeRecyclerView;
        BB();
    }

    private void BB() {
        this.hcZ = new d(this.hcX.getPageContext(), c.hdn, this.hcX.getUniqueId());
        this.hda = new o(this.hcX.getPageContext(), p.hbp);
        this.aMj.add(this.hcZ);
        this.aMj.add(this.hda);
        bQG();
        this.hcY.addAdapters(this.aMj);
    }

    public void setData(ArrayList<m> arrayList) {
        this.hcY.setData(arrayList);
    }

    private void bQG() {
        if (!v.isEmpty(this.aMj) && this.hcX != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hcX.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hcY.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aMj != null && this.aMj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(vVar);
                }
            }
        }
    }
}
