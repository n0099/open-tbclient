package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements g {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        if (sVar != null) {
            if (sVar.w() != -11 || !(sVar instanceof com.baidu.tieba.im.message.a)) {
                if (sVar.w() != 1003 || !(sVar instanceof da)) {
                    return;
                }
                this.a.a((da) sVar);
                return;
            }
            this.a.a((com.baidu.tieba.im.message.a) sVar);
        }
    }
}
