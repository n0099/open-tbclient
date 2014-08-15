package com.baidu.tieba.game;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class af implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (!(customMessage instanceof RequestGameCenterLocalMessage)) {
            return null;
        }
        byte[] a = com.baidu.tbadk.core.a.a.a().a("tb.game_center_home").a("game_center_cache");
        ResponseGameCenterLocalMessage responseGameCenterLocalMessage = new ResponseGameCenterLocalMessage();
        try {
            responseGameCenterLocalMessage.decodeInBackGround(2001224, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseGameCenterLocalMessage;
    }
}
