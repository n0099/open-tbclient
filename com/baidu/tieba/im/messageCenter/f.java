package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.InvokeOnAccountChangedMessageConfig;
import com.baidu.tieba.im.s;
/* loaded from: classes.dex */
final class f implements com.baidu.adp.framework.task.a<InvokeOnAccountChangedMessageConfig> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<InvokeOnAccountChangedMessageConfig> a(com.baidu.adp.framework.message.a<InvokeOnAccountChangedMessageConfig> aVar) {
        if (aVar != null) {
            s.a(new g(this), new h(this));
        }
        return null;
    }
}
