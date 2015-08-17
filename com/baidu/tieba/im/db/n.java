package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ m bth;
    private final /* synthetic */ CustomResponsedMessage bti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.bth = mVar;
        this.bti = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        if (this.bti.getData() instanceof String) {
            f.hB((String) this.bti.getData());
            return null;
        }
        return null;
    }
}
