package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class a implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.r> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.r> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), ImMessageCenterActivity.class);
            aVar.a().f();
        }
        return null;
    }
}
