package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class v implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof com.baidu.tieba.im.message.w)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.c.b.a().s().a("p_enter_forum_group_info");
        ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = new ResponseQueryGroupCountLocalMessage();
        if (a != null) {
            try {
                responseQueryGroupCountLocalMessage.a(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseQueryGroupCountLocalMessage;
    }
}
