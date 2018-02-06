package com.baidu.tieba.godSquare.model.req;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.godSquare.model.res.GodSquareCacheResponsedMsg;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GodSquareCacheRequestMsg)) {
            return null;
        }
        byte[] lw = new com.baidu.tieba.godSquare.model.a().lw(((GodSquareCacheRequestMsg) customMessage).cacheKey);
        GodSquareCacheResponsedMsg godSquareCacheResponsedMsg = new GodSquareCacheResponsedMsg();
        try {
            godSquareCacheResponsedMsg.decodeInBackGround(2016446, lw);
            return godSquareCacheResponsedMsg;
        } catch (Exception e) {
            e.printStackTrace();
            return godSquareCacheResponsedMsg;
        }
    }
}
