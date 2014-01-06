package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ap;
import com.baidu.tieba.im.message.by;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null || !(oVar instanceof ap)) {
            return null;
        }
        com.baidu.tieba.b.a.a().i();
        by byVar = new by();
        byVar.e(-203);
        byVar.a(oVar);
        byVar.g(0);
        return byVar;
    }
}
