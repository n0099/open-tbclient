package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.u;
import com.baidu.tieba.im.p;
/* loaded from: classes.dex */
final class i implements com.baidu.adp.framework.task.a<u> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<u> a(com.baidu.adp.framework.message.a<u> aVar) {
        if (aVar != null && aVar.a() != null) {
            p.a(aVar.a().c());
        }
        return null;
    }
}
