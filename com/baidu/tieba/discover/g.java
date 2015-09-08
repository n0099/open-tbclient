package com.baidu.tieba.discover;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.discover.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements u.a {
    final /* synthetic */ a aLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.aLD = aVar;
    }

    @Override // com.baidu.tieba.discover.u.a
    public void a(boolean z, com.baidu.tieba.discover.data.a aVar, boolean z2) {
        BdListView bdListView;
        List list;
        List list2;
        List list3;
        List list4;
        bdListView = this.aLD.aLm;
        bdListView.completePullRefresh();
        if (aVar != null) {
            if (!z) {
                this.aLD.aLt = true;
            } else {
                this.aLD.aLu = true;
            }
            if (z2) {
                list = this.aLD.aLr;
                list.clear();
                list2 = this.aLD.aLs;
                list2.clear();
                if (aVar.HQ() != null && !aVar.HQ().isEmpty()) {
                    for (com.baidu.tieba.discover.data.d dVar : aVar.HQ()) {
                        if (dVar != null && dVar.HY() != null) {
                            if (dVar.getType() == 1) {
                                list3 = this.aLD.aLr;
                                if (list3.isEmpty()) {
                                    this.aLD.aLr = dVar.HY();
                                }
                            } else {
                                list4 = this.aLD.aLs;
                                list4.add(dVar);
                            }
                        }
                    }
                }
                this.aLD.a(aVar.HP());
                this.aLD.bH(true);
            }
        }
    }

    @Override // com.baidu.tieba.discover.u.a
    public void HK() {
        BdListView bdListView;
        bdListView = this.aLD.aLm;
        bdListView.completePullRefresh();
    }
}
