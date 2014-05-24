package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.RequestMyLiveListLocalMessage;
import com.baidu.tieba.im.message.ResponseMyLiveListLocalMessage;
/* loaded from: classes.dex */
public class m implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestMyLiveListLocalMessage)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().h().a("mylive_" + String.valueOf(((RequestMyLiveListLocalMessage) customMessage).getType()));
        ResponseMyLiveListLocalMessage responseMyLiveListLocalMessage = new ResponseMyLiveListLocalMessage();
        try {
            responseMyLiveListLocalMessage.decodeInBackGround(MessageTypes.CMD_QUERY_MYLIVE_LOCAL, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMyLiveListLocalMessage;
    }
}
