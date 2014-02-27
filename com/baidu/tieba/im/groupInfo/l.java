package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ca;
/* loaded from: classes.dex */
final class l implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ k a;
    private final /* synthetic */ ca b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, ca caVar) {
        this.a = kVar;
        this.b = caVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        m mVar;
        com.baidu.tieba.im.model.e eVar;
        Boolean bool2 = bool;
        if (bool2 == null) {
            bool2 = false;
        }
        mVar = this.a.a.f;
        mVar.a(this.b, bool2.booleanValue());
        eVar = this.a.a.g;
        eVar.a(bool2.booleanValue() ? false : true);
    }
}
