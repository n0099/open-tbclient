package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class o extends s<Void> {
    final /* synthetic */ n cVC;
    private final /* synthetic */ CustomResponsedMessage cVD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, CustomResponsedMessage customResponsedMessage) {
        this.cVC = nVar;
        this.cVD = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Mw */
    public Void doInBackground() {
        if (this.cVD.getData() instanceof String) {
            f.ks((String) this.cVD.getData());
            return null;
        }
        return null;
    }
}
