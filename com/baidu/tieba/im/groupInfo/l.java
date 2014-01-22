package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.br;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ br a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, br brVar) {
        this.b = kVar;
        this.a = brVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        m mVar;
        com.baidu.tieba.im.model.e eVar;
        if (bool == null) {
            bool = false;
        }
        mVar = this.b.a.f;
        mVar.a(this.a, bool.booleanValue());
        eVar = this.b.a.g;
        eVar.a(bool.booleanValue() ? false : true);
    }
}
