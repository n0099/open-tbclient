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
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView bEd;
    private l dwv;
    private FrsCommonTabFragment dyO;
    private p dyP;
    private com.baidu.tieba.frs.entelechy.a.d dyQ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        a(frsCommonTabFragment, bdTypeRecyclerView);
        this.bEd = bdTypeRecyclerView;
    }

    public void a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dyO = frsCommonTabFragment;
        this.dyP = new p(frsCommonTabFragment.getPageContext(), bb.aka, this.dyO.getUniqueId());
        this.dyP.dyU = this.dyO.dyU;
        this.dyP.setFrom("c13010");
        this.dyQ = new com.baidu.tieba.frs.entelechy.a.d(frsCommonTabFragment.getPageContext(), bb.akf, this.dyO.getUniqueId());
        this.dyQ.dyU = this.dyO.dyU;
        this.dyQ.setFrom("c13010");
        this.dwv = new l(frsCommonTabFragment.getPageContext(), m.duQ);
        this.mAdapters.add(this.dyP);
        this.mAdapters.add(this.dyQ);
        this.mAdapters.add(this.dwv);
        bdTypeRecyclerView.addAdapters(this.mAdapters);
        ayG();
    }

    public void setData(ArrayList<h> arrayList) {
        this.bEd.setData(arrayList);
    }

    private void ayG() {
        if (this.dyO != null && !v.z(this.mAdapters)) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar instanceof com.baidu.tieba.frs.e.c) {
                    com.baidu.tieba.frs.e.c cVar = (com.baidu.tieba.frs.e.c) aVar;
                    if (cVar.azt() != null) {
                        cVar.azt().dLH = this.dyO.dyT;
                        cVar.azt().dLJ = this.dyO.forumId;
                        cVar.azt().dLK = this.dyO.tabId;
                    }
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.bEd.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }
}
