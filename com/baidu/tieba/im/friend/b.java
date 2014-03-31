package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class b implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.q> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<com.baidu.tbadk.core.b.q> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.q> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), IMBlackListActivity.class);
            aVar.a().f();
        }
        return null;
    }
}
