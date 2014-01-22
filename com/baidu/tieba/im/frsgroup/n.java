package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.an;
/* loaded from: classes.dex */
class n implements Runnable {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ac acVar;
        ac acVar2;
        acVar = this.a.b;
        BdListView l = acVar.l();
        acVar2 = this.a.b;
        an.a(l, acVar2.i().e(), 1, 0);
    }
}
