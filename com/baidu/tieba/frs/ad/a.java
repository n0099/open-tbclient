package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private FrsADFragment jog;
    private BdTypeRecyclerView joh;
    private d joi;
    private r joj;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jog = frsADFragment;
        this.joh = bdTypeRecyclerView;
        Kz();
    }

    private void Kz() {
        this.joi = new d(this.jog.getPageContext(), c.jow, this.jog.getUniqueId());
        this.joj = new r(this.jog.getPageContext(), s.jlC);
        this.boS.add(this.joi);
        this.boS.add(this.joj);
        cFk();
        this.joh.addAdapters(this.boS);
    }

    public void setData(ArrayList<n> arrayList) {
        this.joh.setData(arrayList);
    }

    private void cFk() {
        if (!y.isEmpty(this.boS) && this.jog != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jog.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.joh.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(w wVar) {
        if (this.boS != null && this.boS.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(wVar);
                }
            }
        }
    }
}
