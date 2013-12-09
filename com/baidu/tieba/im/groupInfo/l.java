package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ResponseGroupInfoMessage f1753a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, ResponseGroupInfoMessage responseGroupInfoMessage) {
        this.b = kVar;
        this.f1753a = responseGroupInfoMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        m mVar;
        com.baidu.tieba.im.model.c cVar;
        if (bool == null) {
            bool = false;
        }
        mVar = this.b.f1752a.f;
        mVar.a(this.f1753a, bool.booleanValue());
        cVar = this.b.f1752a.g;
        cVar.a(bool.booleanValue() ? false : true);
    }
}
