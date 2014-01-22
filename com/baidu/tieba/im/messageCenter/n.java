package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.cr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements g {
    final /* synthetic */ PingManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PingManager pingManager) {
        this.a = pingManager;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null) {
            if (qVar.w() == -11 && (qVar instanceof com.baidu.tieba.im.message.a)) {
                this.a.a((com.baidu.tieba.im.message.a) qVar);
            } else if (qVar.w() == 1003 && (qVar instanceof cr)) {
                this.a.a((cr) qVar);
            }
        }
    }
}
