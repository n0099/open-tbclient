package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.discover.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements u.a {
    final /* synthetic */ a aJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aJA = aVar;
    }

    @Override // com.baidu.tieba.discover.u.a
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aJA.aJj;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aJA.aJq = true;
            } else {
                this.aJA.aJr = true;
            }
            if (z2) {
                list = this.aJA.aJo;
                list.clear();
                list2 = this.aJA.aJp;
                list2.clear();
                if (aVar.HD() != null && !aVar.HD().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.HD()) {
                        if (dVar != null && dVar.HL() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aJA.aJo;
                                if (list3.isEmpty()) {
                                    this.aJA.aJo = dVar.HL();
                                }
                            } else {
                                list4 = this.aJA.aJp;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aJA.a(aVar.HC());
                this.aJA.bG(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.u.a
    public void Hx() {
        BdListView bdListView;
        bdListView = this.aJA.aJj;
        bdListView.completePullRefresh();
    }
}
