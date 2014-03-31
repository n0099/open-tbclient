package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
import com.baidu.tieba.im.message.ay;
/* loaded from: classes.dex */
public class w implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof ay)) {
            return null;
        }
        com.baidu.tbadk.core.c.b.a().i();
        return new ResponseSearchGroupLocalMessage(2001203);
    }
}
