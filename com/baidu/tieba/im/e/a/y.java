package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
import com.baidu.tieba.im.message.ax;
/* loaded from: classes.dex */
public class y implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof ax)) {
            return null;
        }
        long b = ((ax) aVar).b();
        ResponseSearchGroupLocalMessage responseSearchGroupLocalMessage = new ResponseSearchGroupLocalMessage(2001204);
        responseSearchGroupLocalMessage.a(aVar);
        responseSearchGroupLocalMessage.a(0);
        responseSearchGroupLocalMessage.a(b);
        String sb = new StringBuilder(String.valueOf(b)).toString();
        com.baidu.adp.lib.cache.s<String> h = com.baidu.tbadk.core.c.b.a().h();
        h.a(sb, h.a(sb));
        return responseSearchGroupLocalMessage;
    }
}
