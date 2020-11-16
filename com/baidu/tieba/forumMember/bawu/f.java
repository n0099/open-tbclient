package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes22.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof BawuTeamInfoReadCacheRequestMessage)) {
            return null;
        }
        byte[] JH = new d().JH(((BawuTeamInfoReadCacheRequestMessage) customMessage).getCacheKey());
        BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = new BawuTeamReadCacheResponseMessage();
        try {
            bawuTeamReadCacheResponseMessage.decodeInBackGround(CmdConfigCustom.CMD_BAWU_TEAM_INFO_CACHE, JH);
            return bawuTeamReadCacheResponseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return bawuTeamReadCacheResponseMessage;
        }
    }
}
