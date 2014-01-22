package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.av;
import com.baidu.tieba.im.message.ck;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null || !(qVar instanceof av)) {
            return null;
        }
        com.baidu.tieba.b.a.a().i();
        ck ckVar = new ck();
        ckVar.e(-203);
        ckVar.a(qVar);
        ckVar.g(0);
        return ckVar;
    }
}
