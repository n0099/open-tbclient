package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ap;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.a.b;
        BdListView l = aeVar.l();
        aeVar2 = this.a.b;
        ap.a(l, aeVar2.i().e(), 1, 0);
    }
}
