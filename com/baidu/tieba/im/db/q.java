package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ p aYp;
    private final /* synthetic */ CustomResponsedMessage aYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, CustomResponsedMessage customResponsedMessage) {
        this.aYp = pVar;
        this.aYq = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        if (this.aYq.getData() instanceof String) {
            f.gt((String) this.aYq.getData());
            return null;
        }
        return null;
    }
}
