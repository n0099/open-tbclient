package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
public class al extends com.baidu.adp.a.d {
    public void a(int i) {
        com.baidu.tieba.im.message.am amVar = new com.baidu.tieba.im.message.am();
        amVar.a(i);
        com.baidu.tieba.im.messageCenter.e.a().a(amVar);
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }
}
