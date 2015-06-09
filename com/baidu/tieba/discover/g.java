package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements x {
    final /* synthetic */ a aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aDT = aVar;
    }

    @Override // com.baidu.tieba.discover.x
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aDT.aDC;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aDT.aDJ = true;
            } else {
                this.aDT.aDK = true;
            }
            if (z2) {
                list = this.aDT.aDH;
                list.clear();
                list2 = this.aDT.aDI;
                list2.clear();
                if (aVar.Hn() != null && !aVar.Hn().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.Hn()) {
                        if (dVar != null && dVar.Hv() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aDT.aDH;
                                if (list3.isEmpty()) {
                                    this.aDT.aDH = dVar.Hv();
                                }
                            } else {
                                list4 = this.aDT.aDI;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aDT.a(aVar.Hm());
                this.aDT.bA(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.x
    public void Hf() {
        BdListView bdListView;
        bdListView = this.aDT.aDC;
        bdListView.completePullRefresh();
    }
}
