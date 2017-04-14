package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class o extends s<Void> {
    final /* synthetic */ n cTl;
    private final /* synthetic */ CustomResponsedMessage cTm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, CustomResponsedMessage customResponsedMessage) {
        this.cTl = nVar;
        this.cTm = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Mw */
    public Void doInBackground() {
        if (this.cTm.getData() instanceof String) {
            f.kr((String) this.cTm.getData());
            return null;
        }
        return null;
    }
}
