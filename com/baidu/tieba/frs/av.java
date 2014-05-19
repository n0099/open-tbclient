package com.baidu.tieba.frs;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class av implements Runnable {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        cs csVar;
        g gVar;
        csVar = this.a.w;
        BdListView L = csVar.L();
        int uniqueId = this.a.getUniqueId();
        gVar = this.a.I;
        com.baidu.tbadk.core.util.ay.a(L, uniqueId, gVar.o() == 1 ? 13 : 14);
    }
}
