package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.discover.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements t.a {
    final /* synthetic */ a aOb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aOb = aVar;
    }

    @Override // com.baidu.tieba.discover.t.a
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aOb.aNK;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aOb.aNR = true;
            } else {
                this.aOb.aNS = true;
            }
            if (z2) {
                list = this.aOb.aNP;
                list.clear();
                list2 = this.aOb.aNQ;
                list2.clear();
                if (aVar.IW() != null && !aVar.IW().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.IW()) {
                        if (dVar != null && dVar.Je() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aOb.aNP;
                                if (list3.isEmpty()) {
                                    this.aOb.aNP = dVar.Je();
                                }
                            } else {
                                list4 = this.aOb.aNQ;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aOb.a(aVar.IV());
                this.aOb.bR(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.t.a
    public void IQ() {
        BdListView bdListView;
        bdListView = this.aOb.aNK;
        bdListView.completePullRefresh();
    }
}
