package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.av;
import com.baidu.tieba.im.message.ck;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar) {
        if (qVar == null || !(qVar instanceof ck)) {
            return null;
        }
        ck ckVar = (ck) qVar;
        com.baidu.tieba.im.message.q n = ckVar.n();
        if (n != null && (n instanceof av) && !ckVar.k()) {
            String str = ((av) n).b() + "";
            com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
            List<BaseGroupData> a = ckVar.a();
            if (a != null) {
                Iterator<BaseGroupData> it = a.iterator();
                while (it.hasNext()) {
                    h.a(str, it.next().getName() + "(" + str + ")");
                }
                return qVar;
            }
            return qVar;
        }
        return qVar;
    }
}
