package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class u implements Runnable {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah ahVar;
        ah ahVar2;
        ahVar = this.a.b;
        BdListView k = ahVar.k();
        ahVar2 = this.a.b;
        com.baidu.tbadk.core.util.ac.a(k, ahVar2.h().e(), 1, 0);
    }
}
