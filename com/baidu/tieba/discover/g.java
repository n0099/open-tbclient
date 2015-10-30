package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.discover.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements u.a {
    final /* synthetic */ a aKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aKG = aVar;
    }

    @Override // com.baidu.tieba.discover.u.a
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aKG.aKp;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aKG.aKw = true;
            } else {
                this.aKG.aKx = true;
            }
            if (z2) {
                list = this.aKG.aKu;
                list.clear();
                list2 = this.aKG.aKv;
                list2.clear();
                if (aVar.HG() != null && !aVar.HG().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.HG()) {
                        if (dVar != null && dVar.HO() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aKG.aKu;
                                if (list3.isEmpty()) {
                                    this.aKG.aKu = dVar.HO();
                                }
                            } else {
                                list4 = this.aKG.aKv;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aKG.a(aVar.HF());
                this.aKG.bE(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.u.a
    public void HA() {
        BdListView bdListView;
        bdListView = this.aKG.aKp;
        bdListView.completePullRefresh();
    }
}
