package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.discover.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements t.a {
    final /* synthetic */ a aRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aRT = aVar;
    }

    @Override // com.baidu.tieba.discover.t.a
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aRT.aRC;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aRT.aRJ = true;
            } else {
                this.aRT.aRK = true;
            }
            if (z2) {
                list = this.aRT.aRH;
                list.clear();
                list2 = this.aRT.aRI;
                list2.clear();
                if (aVar.Jn() != null && !aVar.Jn().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.Jn()) {
                        if (dVar != null && dVar.Jv() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aRT.aRH;
                                if (list3.isEmpty()) {
                                    this.aRT.aRH = dVar.Jv();
                                }
                            } else {
                                list4 = this.aRT.aRI;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aRT.a(aVar.Jm());
                this.aRT.bS(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.t.a
    public void Jh() {
        BdListView bdListView;
        bdListView = this.aRT.aRC;
        bdListView.completePullRefresh();
    }
}
