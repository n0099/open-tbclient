package com.baidu.tbadk;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.HashMap;
/* loaded from: classes.dex */
final class p implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.frameworkData.a> {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<com.baidu.tbadk.core.frameworkData.a> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.frameworkData.a> aVar) {
        HashMap hashMap;
        if (aVar != null && aVar.a() != null) {
            com.baidu.tbadk.core.frameworkData.a a = aVar.a();
            hashMap = this.a.H;
            Class<?> cls = (Class) hashMap.get(a.getClass());
            if (cls != null) {
                a.d().setClass(aVar.a().c(), cls);
                a.e();
            }
        }
        return null;
    }
}
