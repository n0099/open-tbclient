package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ p aYq;
    private final /* synthetic */ CustomResponsedMessage aYr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, CustomResponsedMessage customResponsedMessage) {
        this.aYq = pVar;
        this.aYr = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        if (this.aYr.getData() instanceof String) {
            f.gw((String) this.aYr.getData());
            return null;
        }
        return null;
    }
}
