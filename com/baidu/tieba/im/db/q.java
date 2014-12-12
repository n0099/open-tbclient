package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ p aWU;
    private final /* synthetic */ CustomResponsedMessage aWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, CustomResponsedMessage customResponsedMessage) {
        this.aWU = pVar;
        this.aWV = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        if (this.aWV.getData() instanceof String) {
            f.gr((String) this.aWV.getData());
            return null;
        }
        return null;
    }
}
