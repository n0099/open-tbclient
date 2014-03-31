package com.baidu.tieba.account;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class a implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.frameworkData.a> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.frameworkData.a> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), AccountActivity.class);
            aVar.a().f();
        }
        return null;
    }
}
