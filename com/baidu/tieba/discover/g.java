package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.discover.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements u.a {
    final /* synthetic */ a aLq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aLq = aVar;
    }

    @Override // com.baidu.tieba.discover.u.a
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aLq.aKZ;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aLq.aLg = true;
            } else {
                this.aLq.aLh = true;
            }
            if (z2) {
                list = this.aLq.aLe;
                list.clear();
                list2 = this.aLq.aLf;
                list2.clear();
                if (aVar.Ic() != null && !aVar.Ic().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.Ic()) {
                        if (dVar != null && dVar.Ik() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aLq.aLe;
                                if (list3.isEmpty()) {
                                    this.aLq.aLe = dVar.Ik();
                                }
                            } else {
                                list4 = this.aLq.aLf;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aLq.a(aVar.Ib());
                this.aLq.bC(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.u.a
    public void HW() {
        BdListView bdListView;
        bdListView = this.aLq.aKZ;
        bdListView.completePullRefresh();
    }
}
