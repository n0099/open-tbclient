package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.InvokeClearChatNotifyMessageConfig;
import com.baidu.tieba.im.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements com.baidu.adp.framework.task.a<InvokeClearChatNotifyMessageConfig> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<InvokeClearChatNotifyMessageConfig> a(com.baidu.adp.framework.message.a<InvokeClearChatNotifyMessageConfig> aVar) {
        if (aVar != null) {
            s.a(new d(this), new e(this));
        }
        return null;
    }
}
