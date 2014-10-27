package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.QueryGroupCountLocalMessage;
import com.baidu.tieba.im.message.ResponseQueryGroupCountLocalMessage;
/* loaded from: classes.dex */
public class u implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        com.baidu.adp.lib.cache.t<byte[]> bc;
        if (customMessage == null || !(customMessage instanceof QueryGroupCountLocalMessage) || (bc = com.baidu.tbadk.core.a.a.kS().bc("tb.im_entergroup")) == null) {
            return null;
        }
        byte[] bArr = bc.get("p_enter_forum_group_info");
        ResponseQueryGroupCountLocalMessage responseQueryGroupCountLocalMessage = new ResponseQueryGroupCountLocalMessage();
        if (bArr != null) {
            try {
                responseQueryGroupCountLocalMessage.decodeInBackGround(2001114, bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseQueryGroupCountLocalMessage;
    }
}
