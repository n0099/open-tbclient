package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.ac;
/* loaded from: classes.dex */
class d implements ac {
    final /* synthetic */ b adL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.adL = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.ac
    public void s(BdListView bdListView) {
        com.baidu.tbadk.mvc.c.b s = com.baidu.tbadk.mvc.h.a.s(bdListView);
        if (s != null) {
            s.setView(bdListView);
            this.adL.dispatchMvcEvent(s);
        }
    }
}
