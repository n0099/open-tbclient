package com.baidu.tieba.forumfeed;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.bv;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<bv> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<bv> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), SingleForumFeedActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
