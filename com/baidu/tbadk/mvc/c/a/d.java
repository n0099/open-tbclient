package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.y;
/* loaded from: classes.dex */
class d implements y {
    final /* synthetic */ b anK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.anK = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.y
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.c.b u = com.baidu.tbadk.mvc.h.a.u(bdListView);
        if (u != null) {
            u.setView(bdListView);
            this.anK.dispatchMvcEvent(u);
        }
    }
}
