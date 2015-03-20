package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ o bcw;
    private final /* synthetic */ CustomResponsedMessage bcx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CustomResponsedMessage customResponsedMessage) {
        this.bcw = oVar;
        this.bcx = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        if (this.bcx.getData() instanceof String) {
            f.gw((String) this.bcx.getData());
            return null;
        }
        return null;
    }
}
