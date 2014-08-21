package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class cj implements CustomMessageTask.CustomRunnable<com.baidu.tbadk.core.atomData.s> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.core.atomData.s> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), FrsImageActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
