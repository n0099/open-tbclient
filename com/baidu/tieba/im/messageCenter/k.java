package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.z;
/* loaded from: classes.dex */
class k implements CustomMessageTask.CustomRunnable<z> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<z> run(CustomMessage<z> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.pushNotify.a.f().b(customMessage.getData().getIntent().getBooleanExtra("isNeedShowNotify", false), (com.baidu.tieba.im.a<Void>) null);
        }
        return null;
    }
}
