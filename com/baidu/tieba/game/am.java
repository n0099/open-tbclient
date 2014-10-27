package com.baidu.tieba.game;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class am implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (!(customMessage instanceof RequestGameCenterLocalMessage)) {
            return null;
        }
        byte[] bArr = com.baidu.tbadk.core.a.a.kS().bc("tb.game_center_home").get("game_center_cache");
        ResponseGameCenterLocalMessage responseGameCenterLocalMessage = new ResponseGameCenterLocalMessage();
        try {
            responseGameCenterLocalMessage.decodeInBackGround(2001224, bArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseGameCenterLocalMessage;
    }
}
