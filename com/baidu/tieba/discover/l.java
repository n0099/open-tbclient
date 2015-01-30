package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements s {
    final /* synthetic */ a auc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.auc = aVar;
    }

    @Override // com.baidu.tieba.discover.s
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.auc.atO;
        bdListView.jI();
        if (aVar != null) {
            if (!z) {
                this.auc.atW = true;
            } else {
                this.auc.atX = true;
            }
            if (z2) {
                list = this.auc.atU;
                list.clear();
                list2 = this.auc.atV;
                list2.clear();
                if (aVar.Do() != null && !aVar.Do().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.Do()) {
                        if (dVar != null && dVar.Dv() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.auc.atU;
                                if (list3.isEmpty()) {
                                    this.auc.atU = dVar.Dv();
                                }
                            } else {
                                list4 = this.auc.atV;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.auc.a(aVar.Dn());
                this.auc.bs(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.s
    public void Di() {
        BdListView bdListView;
        bdListView = this.auc.atO;
        bdListView.jI();
    }
}
