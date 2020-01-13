package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private FrsADFragment gqM;
    private BdTypeRecyclerView gqN;
    private d gqO;
    private m gqP;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gqM = frsADFragment;
        this.gqN = bdTypeRecyclerView;
        vi();
    }

    private void vi() {
        this.gqO = new d(this.gqM.getPageContext(), c.grc, this.gqM.getUniqueId());
        this.gqP = new m(this.gqM.getPageContext(), n.goX);
        this.apl.add(this.gqO);
        this.apl.add(this.gqP);
        bEq();
        this.gqN.addAdapters(this.apl);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.gqN.setData(arrayList);
    }

    private void bEq() {
        if (!v.isEmpty(this.apl) && this.gqM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gqM.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gqN.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(s sVar) {
        if (this.apl != null && this.apl.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(sVar);
                }
            }
        }
    }
}
