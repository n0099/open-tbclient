package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes3.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof BawuTeamInfoReadCacheRequestMessage)) {
            return null;
        }
        byte[] mj = new d().mj(((BawuTeamInfoReadCacheRequestMessage) customMessage).getCacheKey());
        BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = new BawuTeamReadCacheResponseMessage();
        try {
            bawuTeamReadCacheResponseMessage.decodeInBackGround(2003005, mj);
            return bawuTeamReadCacheResponseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return bawuTeamReadCacheResponseMessage;
        }
    }
}
