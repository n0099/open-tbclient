package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.ab;
/* loaded from: classes.dex */
class d implements ab {
    final /* synthetic */ b XC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.XC = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.c.b t = com.baidu.tbadk.mvc.g.a.t(bdListView);
        if (t != null) {
            t.setView(bdListView);
            this.XC.dispatchMvcEvent(t);
        }
    }
}
