package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class ac implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.l> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.l> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), FrsActivity.class);
            aVar.a().f();
        }
        return null;
    }
}
