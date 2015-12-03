package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.m<Void> {
    final /* synthetic */ m bME;
    private final /* synthetic */ CustomResponsedMessage bMF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.bME = mVar;
        this.bMF = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        if (this.bMF.getData() instanceof String) {
            f.il((String) this.bMF.getData());
            return null;
        }
        return null;
    }
}
