package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class x implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof QueryGroupCountLocalMessage)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().v().a("p_enter_forum_group_info");
        ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = new ResponseQueryGroupCountLocalMessage();
        if (a != null) {
            try {
                responseQueryGroupCountLocalMessage.decodeInBackGround(2001114, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseQueryGroupCountLocalMessage;
    }
}
