package com.baidu.tieba.frs.commontab;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeRecyclerView bMI;
    private l dEw;
    private FrsCommonTabFragment dGO;
    private p dGP;
    private com.baidu.tieba.frs.entelechy.a.d dGQ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsCommonTabFragment, bdTypeRecyclerView);
        this.bMI = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dGO = frsCommonTabFragment;
        this.dGP = new p(frsCommonTabFragment.getPageContext(), bb.aoV, this.dGO.getUniqueId());
        this.dGP.dGU = this.dGO.dGU;
        this.dGP.setFrom("c13010");
        this.dGQ = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bb.apa, this.dGO.getUniqueId());
        this.dGQ.dGU = this.dGO.dGU;
        this.dGQ.setFrom("c13010");
        this.dEw = new l(frsCommonTabFragment.getPageContext(), m.dCR);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dGQ);
        this.mAdapters.add(this.dEw);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        aCa();
    }

    public void setData(ArrayList<h> arrayList) {
        this.bMI.setData(arrayList);
    }

    private void aCa() {
        if (this.dGO != null && !v.J(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.aCN() != null) {
                        cVar.aCN().dTD = this.dGO.dGT;
                        cVar.aCN().dTF = this.dGO.forumId;
                        cVar.aCN().dTG = this.dGO.tabId;
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.bMI.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }
}
