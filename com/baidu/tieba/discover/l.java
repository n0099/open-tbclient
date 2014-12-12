package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements s {
    final /* synthetic */ a asV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.asV = aVar;
    }

    @Override // com.baidu.tieba.discover.s
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.asV.asI;
        bdListView.jJ();
        if (aVar != null) {
            if (!z) {
                this.asV.asP = true;
            } else {
                this.asV.asQ = true;
            }
            if (z2) {
                list = this.asV.asN;
                list.clear();
                list2 = this.asV.asO;
                list2.clear();
                if (aVar.CP() != null && !aVar.CP().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.CP()) {
                        if (dVar != null && dVar.CW() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.asV.asN;
                                if (list3.isEmpty()) {
                                    this.asV.asN = dVar.CW();
                                }
                            } else {
                                list4 = this.asV.asO;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.asV.a(aVar.CO());
                this.asV.bp(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.s
    public void CJ() {
        BdListView bdListView;
        bdListView = this.asV.asI;
        bdListView.jJ();
    }
}
