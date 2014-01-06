package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements g {
    final /* synthetic */ PingManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PingManager pingManager) {
        this.a = pingManager;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null) {
            if (oVar.u() == -11 && (oVar instanceof com.baidu.tieba.im.message.a)) {
                this.a.a((com.baidu.tieba.im.message.a) oVar);
            } else if (oVar.u() == 1003 && (oVar instanceof cc)) {
                this.a.a((cc) oVar);
            }
        }
    }
}
