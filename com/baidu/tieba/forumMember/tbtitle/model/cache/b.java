package com.baidu.tieba.forumMember.tbtitle.model.cache;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.forumMember.tbtitle.model.req.GetLevelInfoReadCacheRequestMessage;
/* loaded from: classes5.dex */
public class b implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GetLevelInfoReadCacheRequestMessage)) {
            return null;
        }
        byte[] wd = new a().wd(((GetLevelInfoReadCacheRequestMessage) customMessage).getCacheKey());
        GetLevelInfoReadCacheResponsedMessage getLevelInfoReadCacheResponsedMessage = new GetLevelInfoReadCacheResponsedMessage();
        try {
            getLevelInfoReadCacheResponsedMessage.decodeInBackGround(2003007, wd);
            return getLevelInfoReadCacheResponsedMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return getLevelInfoReadCacheResponsedMessage;
        }
    }
}
