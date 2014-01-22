package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.av;
import com.baidu.tieba.im.message.ck;
import com.baidu.tieba.im.message.cr;
import java.util.List;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null || !(qVar instanceof av)) {
            return null;
        }
        List<com.baidu.adp.lib.cache.t<String>> a = com.baidu.adp.lib.g.j.a(com.baidu.tieba.b.a.a().h());
        ck ckVar = new ck();
        ckVar.e(-202);
        ckVar.a(qVar);
        ckVar.b(a);
        return ckVar;
    }
}
