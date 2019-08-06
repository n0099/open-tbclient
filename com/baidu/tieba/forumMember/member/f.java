package com.baidu.tieba.forumMember.member;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes5.dex */
public class f implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (!(customMessage instanceof ForumMemberReadCacheRequestMessage)) {
            return null;
        }
        byte[] wJ = new d().wJ(((ForumMemberReadCacheRequestMessage) customMessage).getForumName());
        ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = new ForumMemberReadCacheResponseMessage();
        try {
            forumMemberReadCacheResponseMessage.decodeInBackGround(2003009, wJ);
            return forumMemberReadCacheResponseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return forumMemberReadCacheResponseMessage;
        }
    }
}
