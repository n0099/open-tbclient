package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ac;
/* loaded from: classes.dex */
class j implements CustomMessageTask.CustomRunnable<ac> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<ac> run(CustomMessage<ac> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.e.a(customMessage.getData().getContext());
        }
        return null;
    }
}
