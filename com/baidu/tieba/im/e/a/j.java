package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsLocalMessage;
import com.baidu.tieba.im.message.af;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof af)) {
            return null;
        }
        af afVar = (af) aVar;
        byte[] a = com.baidu.tbadk.core.c.b.a().e().a("pb_" + afVar.c() + "_" + afVar.b());
        ResponseFrsGroupsLocalMessage responseFrsGroupsLocalMessage = new ResponseFrsGroupsLocalMessage();
        try {
            responseFrsGroupsLocalMessage.a(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseFrsGroupsLocalMessage;
    }
}
