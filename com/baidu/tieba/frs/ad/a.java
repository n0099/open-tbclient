package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private FrsADFragment hKK;
    private BdTypeRecyclerView hKL;
    private d hKM;
    private q hKN;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hKK = frsADFragment;
        this.hKL = bdTypeRecyclerView;
        DS();
    }

    private void DS() {
        this.hKM = new d(this.hKK.getPageContext(), c.hLa, this.hKK.getUniqueId());
        this.hKN = new q(this.hKK.getPageContext(), r.hIV);
        this.aWf.add(this.hKM);
        this.aWf.add(this.hKN);
        cdP();
        this.hKL.addAdapters(this.aWf);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hKL.setData(arrayList);
    }

    private void cdP() {
        if (!x.isEmpty(this.aWf) && this.hKK != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar instanceof j) {
                    ((j) aVar).a(this.hKK.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hKL.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            if (aVar instanceof j) {
                ((j) aVar).release();
            }
        }
    }

    public void a(z zVar) {
        if (this.aWf != null && this.aWf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
                if (aVar != null && (aVar instanceof j)) {
                    aVar.a(zVar);
                }
            }
        }
    }
}
