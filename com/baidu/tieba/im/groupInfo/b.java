package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ApplyJoinGroupActivityConfig;
/* loaded from: classes.dex */
class b implements CustomMessageTask.CustomRunnable<ApplyJoinGroupActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ApplyJoinGroupActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), ApplyJoinGroupActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
