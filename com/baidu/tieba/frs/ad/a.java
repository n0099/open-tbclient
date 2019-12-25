package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private FrsADFragment gnD;
    private BdTypeRecyclerView gnE;
    private d gnF;
    private m gnG;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gnD = frsADFragment;
        this.gnE = bdTypeRecyclerView;
        uR();
    }

    private void uR() {
        this.gnF = new d(this.gnD.getPageContext(), c.gnT, this.gnD.getUniqueId());
        this.gnG = new m(this.gnD.getPageContext(), n.glO);
        this.aoz.add(this.gnF);
        this.aoz.add(this.gnG);
        bDo();
        this.gnE.addAdapters(this.aoz);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.gnE.setData(arrayList);
    }

    private void bDo() {
        if (!v.isEmpty(this.aoz) && this.gnD != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gnD.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gnE.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(s sVar) {
        if (this.aoz != null && this.aoz.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(sVar);
                }
            }
        }
    }
}
