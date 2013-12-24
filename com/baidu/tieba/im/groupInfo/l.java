package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.be;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ be a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, be beVar) {
        this.b = kVar;
        this.a = beVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        m mVar;
        com.baidu.tieba.im.model.d dVar;
        if (bool == null) {
            bool = false;
        }
        mVar = this.b.a.f;
        mVar.a(this.a, bool.booleanValue());
        dVar = this.b.a.g;
        dVar.a(bool.booleanValue() ? false : true);
    }
}
