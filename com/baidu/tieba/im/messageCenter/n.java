package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements g {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        if (sVar != null) {
            if (sVar.w() == -11 && (sVar instanceof com.baidu.tieba.im.message.a)) {
                m.a(this.a, (com.baidu.tieba.im.message.a) sVar);
            } else if (sVar.w() == 1003 && (sVar instanceof da)) {
                m.a(this.a, (da) sVar);
            }
        }
    }
}
