package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.m<Void> {
    final /* synthetic */ m bUm;
    private final /* synthetic */ CustomResponsedMessage bUn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.bUm = mVar;
        this.bUn = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        if (this.bUn.getData() instanceof String) {
            f.iz((String) this.bUn.getData());
            return null;
        }
        return null;
    }
}
