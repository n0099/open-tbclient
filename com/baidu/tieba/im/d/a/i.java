package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.live.message.RequestHotLiveListLocalMessage;
import com.baidu.tbadk.live.message.ResponseHotLiveListLocalMessage;
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestHotLiveListLocalMessage)) {
            return null;
        }
        byte[] bArr = com.baidu.tbadk.core.a.a.kS().bc("tb.live_hotlist").get("live_" + String.valueOf(((RequestHotLiveListLocalMessage) customMessage).getType()));
        ResponseHotLiveListLocalMessage responseHotLiveListLocalMessage = new ResponseHotLiveListLocalMessage();
        try {
            responseHotLiveListLocalMessage.decodeInBackGround(2001214, bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseHotLiveListLocalMessage;
    }
}
