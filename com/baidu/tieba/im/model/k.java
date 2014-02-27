package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bj;
/* loaded from: classes.dex */
public final class k extends com.baidu.adp.a.d {
    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }

    public final void a(int i) {
        com.baidu.tieba.im.message.an anVar = new com.baidu.tieba.im.message.an();
        anVar.a(8);
        com.baidu.tieba.im.messageCenter.d.a().a(anVar);
    }

    public final void a(int i, boolean z) {
        bj bjVar = new bj();
        bjVar.a(z);
        bjVar.a(8);
        bjVar.a("");
        com.baidu.tieba.im.messageCenter.d.a().a(bjVar);
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }
}
