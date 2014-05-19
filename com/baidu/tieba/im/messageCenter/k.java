package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.x;
/* loaded from: classes.dex */
class k implements CustomMessageTask.CustomRunnable<x> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<x> run(CustomMessage<x> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.e.a(customMessage.getData().getContext());
        }
        return null;
    }
}
