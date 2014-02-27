package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.bb;
/* loaded from: classes.dex */
public final class an extends com.baidu.adp.a.d {
    public static void a(int i) {
        bb bbVar = new bb();
        bbVar.a(i);
        com.baidu.tieba.im.messageCenter.d.a().a(bbVar);
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        return false;
    }
}
