package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements s {
    final /* synthetic */ a aBK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.aBK = aVar;
    }

    @Override // com.baidu.tieba.discover.s
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aBK.aBx;
        bdListView.mW();
        if (aVar != null) {
            if (!z) {
                this.aBK.aBE = true;
            } else {
                this.aBK.aBF = true;
            }
            if (z2) {
                list = this.aBK.aBC;
                list.clear();
                list2 = this.aBK.aBD;
                list2.clear();
                if (aVar.Gd() != null && !aVar.Gd().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.Gd()) {
                        if (dVar != null && dVar.Gk() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aBK.aBC;
                                if (list3.isEmpty()) {
                                    this.aBK.aBC = dVar.Gk();
                                }
                            } else {
                                list4 = this.aBK.aBD;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aBK.a(aVar.Gc());
                this.aBK.br(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.s
    public void FV() {
        BdListView bdListView;
        bdListView = this.aBK.aBx;
        bdListView.mW();
    }
}
