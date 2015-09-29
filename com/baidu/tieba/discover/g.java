package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.discover.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements u.a {
    final /* synthetic */ a aKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aKv = aVar;
    }

    @Override // com.baidu.tieba.discover.u.a
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aKv.aKe;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aKv.aKl = true;
            } else {
                this.aKv.aKm = true;
            }
            if (z2) {
                list = this.aKv.aKj;
                list.clear();
                list2 = this.aKv.aKk;
                list2.clear();
                if (aVar.HK() != null && !aVar.HK().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.HK()) {
                        if (dVar != null && dVar.HS() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aKv.aKj;
                                if (list3.isEmpty()) {
                                    this.aKv.aKj = dVar.HS();
                                }
                            } else {
                                list4 = this.aKv.aKk;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aKv.a(aVar.HJ());
                this.aKv.bE(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.u.a
    public void HE() {
        BdListView bdListView;
        bdListView = this.aKv.aKe;
        bdListView.completePullRefresh();
    }
}
