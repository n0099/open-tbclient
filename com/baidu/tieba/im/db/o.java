package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.w;
/* loaded from: classes.dex */
class o extends w<Void> {
    private final /* synthetic */ CustomResponsedMessage aZE;
    final /* synthetic */ n dcZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, CustomResponsedMessage customResponsedMessage) {
        this.dcZ = nVar;
        this.aZE = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: Ld */
    public Void doInBackground() {
        if (this.aZE.getData() instanceof String) {
            f.lE((String) this.aZE.getData());
            return null;
        }
        return null;
    }
}
