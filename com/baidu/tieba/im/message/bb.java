package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class bb implements com.baidu.adp.framework.task.a<String> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<String> a(com.baidu.adp.framework.message.a<String> aVar) {
        if (aVar != null && aVar.a() != null) {
            ba.a("kd_mread", aVar.a());
        }
        return null;
    }
}
