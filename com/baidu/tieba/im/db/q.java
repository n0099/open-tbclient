package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ p aVo;
    private final /* synthetic */ CustomResponsedMessage aVp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, CustomResponsedMessage customResponsedMessage) {
        this.aVo = pVar;
        this.aVp = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        if (this.aVp.getData() instanceof String) {
            f.gb((String) this.aVp.getData());
            return null;
        }
        return null;
    }
}
