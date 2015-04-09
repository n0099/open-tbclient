package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements s {
    final /* synthetic */ a aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.aBS = aVar;
    }

    @Override // com.baidu.tieba.discover.s
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aBS.aBF;
        bdListView.mW();
        if (aVar != null) {
            if (!z) {
                this.aBS.aBM = true;
            } else {
                this.aBS.aBN = true;
            }
            if (z2) {
                list = this.aBS.aBK;
                list.clear();
                list2 = this.aBS.aBL;
                list2.clear();
                if (aVar.Gj() != null && !aVar.Gj().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.Gj()) {
                        if (dVar != null && dVar.Gq() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aBS.aBK;
                                if (list3.isEmpty()) {
                                    this.aBS.aBK = dVar.Gq();
                                }
                            } else {
                                list4 = this.aBS.aBL;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aBS.a(aVar.Gi());
                this.aBS.br(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.s
    public void Gb() {
        BdListView bdListView;
        bdListView = this.aBS.aBF;
        bdListView.mW();
    }
}
