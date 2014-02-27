package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.util.ap;
/* loaded from: classes.dex */
final class r implements Runnable {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ae aeVar;
        ae aeVar2;
        aeVar = this.a.b;
        BdListView k = aeVar.k();
        aeVar2 = this.a.b;
        ap.a(k, aeVar2.h().e(), 1, 0);
    }
}
