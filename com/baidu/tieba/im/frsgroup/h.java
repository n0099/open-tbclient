package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class h implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        com.baidu.tieba.im.model.k kVar;
        com.baidu.tieba.im.model.k kVar2;
        int i;
        BdListView bdListView;
        kVar = this.a.c;
        if (!kVar.h() || !z) {
            kVar2 = this.a.c;
            if (kVar2.g() == 2) {
                i = this.a.k;
                if (i == com.baidu.adp.lib.util.i.a()) {
                    bdListView = this.a.e;
                    bdListView.b();
                    this.a.a(com.baidu.tieba.im.j.frsgroup_hot_cannot_refresh_tip);
                    return;
                }
            }
            this.a.a();
            return;
        }
        this.a.a(false);
    }
}
