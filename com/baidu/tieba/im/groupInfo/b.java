package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class b implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.b> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.b> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), ApplyJoinGroupActivity.class);
            aVar.a().f();
        }
        return null;
    }
}
