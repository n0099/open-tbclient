package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ah ahVar;
        ah ahVar2;
        ahVar = this.a.b;
        BdListView i = ahVar.i();
        ahVar2 = this.a.b;
        com.baidu.tbadk.core.util.ae.a(i, ahVar2.f().e(), 1, 0);
    }
}
