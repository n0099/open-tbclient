package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements g {
    final /* synthetic */ PingManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PingManager pingManager) {
        this.a = pingManager;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar != null) {
            if (nVar.t() == -11 && (nVar instanceof com.baidu.tieba.im.message.a)) {
                this.a.a((com.baidu.tieba.im.message.a) nVar);
            } else if (nVar.t() == 1003 && (nVar instanceof bz)) {
                this.a.a((bz) nVar);
            }
        }
    }
}
