package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.y;
/* loaded from: classes.dex */
class d implements y {
    final /* synthetic */ b amz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.amz = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.y
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.c.b r = com.baidu.tbadk.mvc.h.a.r(bdListView);
        if (r != null) {
            r.setView(bdListView);
            this.amz.dispatchMvcEvent(r);
        }
    }
}
