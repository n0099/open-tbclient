package com.baidu.tieba.im.groupInfo;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class n implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.o> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.o> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), GroupInfoActivity.class);
            int intExtra = aVar.a().d().getIntExtra("requestCode", -1);
            if (intExtra != -1) {
                aVar.a().b(intExtra);
            } else {
                aVar.a().f();
            }
        }
        return null;
    }
}
