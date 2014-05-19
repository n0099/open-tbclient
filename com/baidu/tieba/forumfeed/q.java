package com.baidu.tieba.forumfeed;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ba;
/* loaded from: classes.dex */
class q implements CustomMessageTask.CustomRunnable<ba> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ba> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), SingleForumFeedActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
