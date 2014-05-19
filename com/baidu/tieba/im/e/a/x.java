package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class x implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof QueryGroupCountLocalMessage)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().u().a("p_enter_forum_group_info");
        ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = new ResponseQueryGroupCountLocalMessage();
        if (a != null) {
            try {
                responseQueryGroupCountLocalMessage.decodeInBackGround(MessageTypes.CMD_REQUEST_GROUP_COUNT_LOCAL, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseQueryGroupCountLocalMessage;
    }
}
