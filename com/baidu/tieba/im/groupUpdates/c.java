package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.at;
/* loaded from: classes.dex */
final class c implements com.baidu.adp.framework.task.a<at> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<at> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), UpdatesActivity.class);
            aVar.a().d().setFlags(268435456);
            aVar.a().f();
        }
        return null;
    }
}
