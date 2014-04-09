package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
import com.baidu.tieba.im.message.ax;
import java.util.List;
/* loaded from: classes.dex */
public class x implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof ax)) {
            return null;
        }
        List<com.baidu.adp.lib.cache.t<String>> a = com.baidu.adp.lib.util.l.a(com.baidu.tbadk.core.c.b.a().h());
        ResponseSearchGroupLocalMessage responseSearchGroupLocalMessage = new ResponseSearchGroupLocalMessage();
        responseSearchGroupLocalMessage.a(a);
        return responseSearchGroupLocalMessage;
    }
}
