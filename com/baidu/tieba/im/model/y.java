package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class y extends com.baidu.adp.a.e {
    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(int i) {
        com.baidu.tbadk.core.message.c cVar = new com.baidu.tbadk.core.message.c();
        cVar.d(8);
        super.sendMessage(cVar);
    }

    public final void a(int i, boolean z) {
        com.baidu.tbadk.core.message.d dVar = new com.baidu.tbadk.core.message.d();
        dVar.a(z);
        dVar.d(8);
        dVar.a("");
        super.sendMessage(dVar);
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }
}
