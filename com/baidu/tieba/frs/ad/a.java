package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private FrsADFragment hrL;
    private BdTypeRecyclerView hrM;
    private d hrN;
    private o hrO;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hrL = frsADFragment;
        this.hrM = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.hrN = new d(this.hrL.getPageContext(), c.hsb, this.hrL.getUniqueId());
        this.hrO = new o(this.hrL.getPageContext(), p.hqd);
        this.aSj.add(this.hrN);
        this.aSj.add(this.hrO);
        bXd();
        this.hrM.addAdapters(this.aSj);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        this.hrM.setData(arrayList);
    }

    private void bXd() {
        if (!v.isEmpty(this.aSj) && this.hrL != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hrL.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hrM.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(x xVar) {
        if (this.aSj != null && this.aSj.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(xVar);
                }
            }
        }
    }
}
