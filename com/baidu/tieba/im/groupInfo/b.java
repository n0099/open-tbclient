package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class b implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.c> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.atomData.c> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), ApplyJoinGroupActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
