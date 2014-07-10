package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestHotLiveListLocalMessage;
import com.baidu.tieba.im.message.ResponseHotLiveListLocalMessage;
/* loaded from: classes.dex */
public class k implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestHotLiveListLocalMessage)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().i().a("live_" + String.valueOf(((RequestHotLiveListLocalMessage) customMessage).getType()));
        ResponseHotLiveListLocalMessage responseHotLiveListLocalMessage = new ResponseHotLiveListLocalMessage();
        try {
            responseHotLiveListLocalMessage.decodeInBackGround(2001205, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseHotLiveListLocalMessage;
    }
}
