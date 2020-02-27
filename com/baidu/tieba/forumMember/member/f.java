package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes10.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (!(customMessage instanceof ForumMemberReadCacheRequestMessage)) {
            return null;
        }
        byte[] AT = new d().AT(((ForumMemberReadCacheRequestMessage) customMessage).getForumName());
        ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = new ForumMemberReadCacheResponseMessage();
        try {
            forumMemberReadCacheResponseMessage.decodeInBackGround(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE, AT);
            return forumMemberReadCacheResponseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return forumMemberReadCacheResponseMessage;
        }
    }
}
