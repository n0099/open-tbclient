package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ah;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<ah> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<ah> run(CustomMessage<ah> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.c.a(customMessage.getData().getContext());
        }
        return null;
    }
}
