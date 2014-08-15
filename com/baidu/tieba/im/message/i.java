package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class i implements CustomMessageTask.CustomRunnable<String> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_KD_MREAD, customMessage.getData());
        }
        return null;
    }
}
