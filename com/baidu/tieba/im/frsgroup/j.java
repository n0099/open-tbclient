package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes3.dex */
public class j implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (!(customMessage instanceof FrsGroupReadCacheRequestMessage)) {
            return null;
        }
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = (FrsGroupReadCacheRequestMessage) customMessage;
        byte[] R = new c().R(frsGroupReadCacheRequestMessage.getType(), frsGroupReadCacheRequestMessage.getForumName());
        FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = new FrsGroupReadCacheResponseMessage();
        try {
            frsGroupReadCacheResponseMessage.decodeInBackGround(2001204, R);
            return frsGroupReadCacheResponseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return frsGroupReadCacheResponseMessage;
        }
    }
}
