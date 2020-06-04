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
    private FrsADFragment hrW;
    private BdTypeRecyclerView hrX;
    private d hrY;
    private o hrZ;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hrW = frsADFragment;
        this.hrX = bdTypeRecyclerView;
        CY();
    }

    private void CY() {
        this.hrY = new d(this.hrW.getPageContext(), c.hsm, this.hrW.getUniqueId());
        this.hrZ = new o(this.hrW.getPageContext(), p.hqo);
        this.aSj.add(this.hrY);
        this.aSj.add(this.hrZ);
        bXf();
        this.hrX.addAdapters(this.aSj);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.o> arrayList) {
        this.hrX.setData(arrayList);
    }

    private void bXf() {
        if (!v.isEmpty(this.aSj) && this.hrW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hrW.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hrX.getAdapter().notifyDataSetChanged();
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
