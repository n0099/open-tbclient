package com.baidu.tieba.enterForum.square;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements q.a {
    final /* synthetic */ b aRA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aRA = bVar;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        e eVar;
        a aVar;
        if (!i.iP()) {
            aVar = this.aRA.aRw;
            aVar.Kr();
            this.aRA.fB(n.i.neterror);
            return;
        }
        z2 = this.aRA.aRy;
        if (!z2) {
            eVar = this.aRA.aRv;
            eVar.sendMessage();
            this.aRA.aRy = true;
        }
    }
}
