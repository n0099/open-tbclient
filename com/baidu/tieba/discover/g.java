package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements x {
    final /* synthetic */ a aDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aDS = aVar;
    }

    @Override // com.baidu.tieba.discover.x
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aDS.aDB;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aDS.aDI = true;
            } else {
                this.aDS.aDJ = true;
            }
            if (z2) {
                list = this.aDS.aDG;
                list.clear();
                list2 = this.aDS.aDH;
                list2.clear();
                if (aVar.Hm() != null && !aVar.Hm().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.Hm()) {
                        if (dVar != null && dVar.Hu() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aDS.aDG;
                                if (list3.isEmpty()) {
                                    this.aDS.aDG = dVar.Hu();
                                }
                            } else {
                                list4 = this.aDS.aDH;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aDS.a(aVar.Hl());
                this.aDS.bA(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.x
    public void He() {
        BdListView bdListView;
        bdListView = this.aDS.aDB;
        bdListView.completePullRefresh();
    }
}
