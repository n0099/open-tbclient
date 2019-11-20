package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes5.dex */
public class j implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (!(customMessage instanceof FrsGroupReadCacheRequestMessage)) {
            return null;
        }
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = (FrsGroupReadCacheRequestMessage) customMessage;
        byte[] an = new c().an(frsGroupReadCacheRequestMessage.getType(), frsGroupReadCacheRequestMessage.getForumName());
        FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = new FrsGroupReadCacheResponseMessage();
        try {
            frsGroupReadCacheResponseMessage.decodeInBackGround(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, an);
            return frsGroupReadCacheResponseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return frsGroupReadCacheResponseMessage;
        }
    }
}
