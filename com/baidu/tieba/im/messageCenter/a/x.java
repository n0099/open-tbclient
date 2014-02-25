package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.bb;
import com.baidu.tieba.im.message.ct;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar == null || !(sVar instanceof ct)) {
            return null;
        }
        ct ctVar = (ct) sVar;
        com.baidu.tieba.im.message.s o = ctVar.o();
        if (o != null && (o instanceof bb) && !ctVar.l()) {
            String sb = new StringBuilder(String.valueOf(((bb) o).b())).toString();
            com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.c.a.a().h();
            List<BaseGroupData> a = ctVar.a();
            if (a != null) {
                Iterator<BaseGroupData> it = a.iterator();
                while (it.hasNext()) {
                    h.a(sb, String.valueOf(it.next().getName()) + "(" + sb + ")");
                }
                return sVar;
            }
            return sVar;
        }
        return sVar;
    }
}
