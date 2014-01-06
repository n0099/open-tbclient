package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ap;
/* loaded from: classes.dex */
public class al extends com.baidu.adp.a.d {
    public void a(int i) {
        ap apVar = new ap();
        apVar.a(i);
        com.baidu.tieba.im.messageCenter.e.a().a(apVar);
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
