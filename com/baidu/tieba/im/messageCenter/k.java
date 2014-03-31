package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.w;
/* loaded from: classes.dex */
final class k implements com.baidu.adp.framework.task.a<w> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<w> a(com.baidu.adp.framework.message.a<w> aVar) {
        if (aVar != null && aVar.a() != null) {
            com.baidu.tieba.im.pushNotify.a.d().b(aVar.a().d().getBooleanExtra("isNeedShowNotify", false), null);
        }
        return null;
    }
}
