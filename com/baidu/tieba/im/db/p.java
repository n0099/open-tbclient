package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ o bcM;
    private final /* synthetic */ CustomResponsedMessage bcN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CustomResponsedMessage customResponsedMessage) {
        this.bcM = oVar;
        this.bcN = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        if (this.bcN.getData() instanceof String) {
            f.gz((String) this.bcN.getData());
            return null;
        }
        return null;
    }
}
