package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ao;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.framework.task.a<String> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<String> aVar) {
        CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2001110);
        if (aVar == null || !(aVar instanceof ao)) {
            return null;
        }
        com.baidu.tieba.im.db.c.a().b(((ao) aVar).a());
        return customResponsedMessage;
    }
}
