package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.ae;
/* loaded from: classes.dex */
class k implements CustomMessageTask.CustomRunnable<ae> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<ae> run(CustomMessage<ae> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.pushNotify.a.i().b(customMessage.getData().getIntent().getBooleanExtra("isNeedShowNotify", false), (com.baidu.tieba.im.a<Void>) null);
        }
        return null;
    }
}
