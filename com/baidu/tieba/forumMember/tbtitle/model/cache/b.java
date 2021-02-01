package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoReadCacheRequestMessage;
/* loaded from: classes8.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GetLevelInfoReadCacheRequestMessage)) {
            return null;
        }
        byte[] JU = new a().JU(((GetLevelInfoReadCacheRequestMessage) customMessage).getCacheKey());
        GetLevelInfoReadCacheResponsedMessage getLevelInfoReadCacheResponsedMessage = new GetLevelInfoReadCacheResponsedMessage();
        try {
            getLevelInfoReadCacheResponsedMessage.decodeInBackGround(CmdConfigCustom.CMD_GET_LEVEL_INFO_CACHE, JU);
            return getLevelInfoReadCacheResponsedMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return getLevelInfoReadCacheResponsedMessage;
        }
    }
}
