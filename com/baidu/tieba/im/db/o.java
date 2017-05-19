package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.v;
/* loaded from: classes.dex */
class o extends v<Void> {
    final /* synthetic */ n cPE;
    private final /* synthetic */ CustomResponsedMessage cPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, CustomResponsedMessage customResponsedMessage) {
        this.cPE = nVar;
        this.cPF = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: LK */
    public Void doInBackground() {
        if (this.cPF.getData() instanceof String) {
            f.kw((String) this.cPF.getData());
            return null;
        }
        return null;
    }
}
