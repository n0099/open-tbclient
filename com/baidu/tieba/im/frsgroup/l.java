package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ai;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        aa aaVar;
        aa aaVar2;
        aaVar = this.a.b;
        BdListView l = aaVar.l();
        aaVar2 = this.a.b;
        ai.a(l, aaVar2.i().e(), 1, 0);
    }
}
