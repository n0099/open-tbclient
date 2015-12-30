package com.baidu.tieba.enterForum.square;

import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements r.a {
    final /* synthetic */ b aVq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aVq = bVar;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        boolean z2;
        e eVar;
        a aVar;
        if (!i.iQ()) {
            aVar = this.aVq.aVm;
            aVar.KK();
            this.aVq.fw(n.j.neterror);
            return;
        }
        z2 = this.aVq.aVo;
        if (!z2) {
            eVar = this.aVq.aVl;
            eVar.sendMessage();
            this.aVq.aVo = true;
        }
    }
}
