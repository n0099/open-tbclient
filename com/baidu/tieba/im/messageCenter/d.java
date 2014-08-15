package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.InvokeOnAccountChangedMessageConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements CustomMessageTask.CustomRunnable<InvokeOnAccountChangedMessageConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<InvokeOnAccountChangedMessageConfig> run(CustomMessage<InvokeOnAccountChangedMessageConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            boolean isNull = StringUtils.isNull(customMessage.getData().mData);
            com.baidu.tieba.im.e.a(new e(this, isNull), new f(this, isNull));
        }
        return null;
    }
}
