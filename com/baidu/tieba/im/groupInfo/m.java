package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ResponseGroupInfoMessage f1695a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, ResponseGroupInfoMessage responseGroupInfoMessage) {
        this.b = lVar;
        this.f1695a = responseGroupInfoMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        n nVar;
        com.baidu.tieba.im.model.c cVar;
        if (bool == null) {
            bool = false;
        }
        nVar = this.b.f1694a.f;
        nVar.a(this.f1695a, bool.booleanValue());
        cVar = this.b.f1694a.g;
        cVar.a(bool.booleanValue() ? false : true);
    }
}
