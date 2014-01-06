package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ap;
import com.baidu.tieba.im.message.by;
import com.baidu.tieba.im.message.cc;
import java.util.List;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null || !(oVar instanceof ap)) {
            return null;
        }
        List<com.baidu.adp.lib.cache.t<String>> a = com.baidu.adp.lib.h.j.a(com.baidu.tieba.b.a.a().h());
        by byVar = new by();
        byVar.e(-202);
        byVar.a(oVar);
        byVar.b(a);
        return byVar;
    }
}
