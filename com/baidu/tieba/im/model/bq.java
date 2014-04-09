package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class bq extends com.baidu.adp.a.e {
    public final void a(int i) {
        com.baidu.tieba.im.message.ay ayVar = new com.baidu.tieba.im.message.ay();
        ayVar.d(i);
        super.sendMessage(ayVar);
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
