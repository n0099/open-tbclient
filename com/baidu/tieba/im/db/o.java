package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.v;
/* loaded from: classes.dex */
class o extends v<Void> {
    final /* synthetic */ n cVc;
    private final /* synthetic */ CustomResponsedMessage cVd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, CustomResponsedMessage customResponsedMessage) {
        this.cVc = nVar;
        this.cVd = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: KF */
    public Void doInBackground() {
        if (this.cVd.getData() instanceof String) {
            f.kG((String) this.cVd.getData());
            return null;
        }
        return null;
    }
}
