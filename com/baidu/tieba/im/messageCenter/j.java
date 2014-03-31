package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.x;
/* loaded from: classes.dex */
final class j implements com.baidu.adp.framework.task.a<x> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<x> a(com.baidu.adp.framework.message.a<x> aVar) {
        if (aVar != null && aVar.a() != null) {
            com.baidu.tieba.im.d.a.a().a(aVar.a().d().getIntArrayExtra("timeouts"));
        }
        return null;
    }
}
