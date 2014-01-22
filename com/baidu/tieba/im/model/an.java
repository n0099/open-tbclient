package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.av;
/* loaded from: classes.dex */
public class an extends com.baidu.adp.a.d {
    public void a(int i) {
        av avVar = new av();
        avVar.a(i);
        com.baidu.tieba.im.messageCenter.e.a().a(avVar);
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
