package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ o bfq;
    private final /* synthetic */ CustomResponsedMessage bfr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CustomResponsedMessage customResponsedMessage) {
        this.bfq = oVar;
        this.bfr = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        if (this.bfr.getData() instanceof String) {
            f.hc((String) this.bfr.getData());
            return null;
        }
        return null;
    }
}
