package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ p aVC;
    private final /* synthetic */ CustomResponsedMessage aVD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, CustomResponsedMessage customResponsedMessage) {
        this.aVC = pVar;
        this.aVD = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        if (this.aVD.getData() instanceof String) {
            f.gb((String) this.aVD.getData());
            return null;
        }
        return null;
    }
}
