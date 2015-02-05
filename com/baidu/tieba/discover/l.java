package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements s {
    final /* synthetic */ a atZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.atZ = aVar;
    }

    @Override // com.baidu.tieba.discover.s
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.atZ.atL;
        bdListView.jB();
        if (aVar != null) {
            if (!z) {
                this.atZ.atT = true;
            } else {
                this.atZ.atU = true;
            }
            if (z2) {
                list = this.atZ.atR;
                list.clear();
                list2 = this.atZ.atS;
                list2.clear();
                if (aVar.Di() != null && !aVar.Di().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.Di()) {
                        if (dVar != null && dVar.Dp() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.atZ.atR;
                                if (list3.isEmpty()) {
                                    this.atZ.atR = dVar.Dp();
                                }
                            } else {
                                list4 = this.atZ.atS;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.atZ.a(aVar.Dh());
                this.atZ.bs(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.s
    public void Dc() {
        BdListView bdListView;
        bdListView = this.atZ.atL;
        bdListView.jB();
    }
}
