package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public final class bp extends com.baidu.adp.a.e {
    public final void a(int i) {
        com.baidu.tieba.im.message.az azVar = new com.baidu.tieba.im.message.az();
        azVar.d(i);
        super.sendMessage(azVar);
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
