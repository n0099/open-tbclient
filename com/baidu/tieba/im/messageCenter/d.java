package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeClearChatNotifyMessageConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements CustomMessageTask.CustomRunnable<InvokeClearChatNotifyMessageConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<InvokeClearChatNotifyMessageConfig> run(CustomMessage<InvokeClearChatNotifyMessageConfig> customMessage) {
        if (customMessage != null) {
            com.baidu.tieba.im.i.a(new e(this), new f(this));
        }
        return null;
    }
}
