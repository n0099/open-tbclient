package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class w implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        com.baidu.adp.lib.cache.t<byte[]> a;
        if (customMessage == null || !(customMessage instanceof QueryGroupCountLocalMessage) || (a = com.baidu.tbadk.core.a.a.a().a("tb.im_entergroup")) == null) {
            return null;
        }
        byte[] a2 = a.a("p_enter_forum_group_info");
        ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = new ResponseQueryGroupCountLocalMessage();
        if (a2 != null) {
            try {
                responseQueryGroupCountLocalMessage.decodeInBackGround(2001114, a2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseQueryGroupCountLocalMessage;
    }
}
