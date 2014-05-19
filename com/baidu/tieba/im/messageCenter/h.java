package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeOnAccountChangedMessageConfig;
/* loaded from: classes.dex */
class h implements CustomMessageTask.CustomRunnable<InvokeOnAccountChangedMessageConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<InvokeOnAccountChangedMessageConfig> run(CustomMessage<InvokeOnAccountChangedMessageConfig> customMessage) {
        if (customMessage != null) {
            com.baidu.tieba.im.i.a(new i(this), new j(this));
        }
        return null;
    }
}
