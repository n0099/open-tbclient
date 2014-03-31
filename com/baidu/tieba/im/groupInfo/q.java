package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* loaded from: classes.dex */
final class q implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ p a;
    private final /* synthetic */ ResponseGroupInfoMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, ResponseGroupInfoMessage responseGroupInfoMessage) {
        this.a = pVar;
        this.b = responseGroupInfoMessage;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        r rVar;
        com.baidu.tieba.im.model.l lVar;
        Boolean bool2 = bool;
        if (bool2 == null) {
            bool2 = false;
        }
        rVar = this.a.a.f;
        rVar.a(this.b.d(), bool2.booleanValue());
        lVar = this.a.a.g;
        lVar.a(bool2.booleanValue() ? false : true);
    }
}
