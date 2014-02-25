package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bb;
/* loaded from: classes.dex */
public class an extends com.baidu.adp.a.d {
    public void a(int i) {
        bb bbVar = new bb();
        bbVar.a(i);
        com.baidu.tieba.im.messageCenter.e.a().a(bbVar);
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
