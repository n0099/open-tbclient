package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class n extends s<Void> {
    final /* synthetic */ m cKP;
    private final /* synthetic */ CustomResponsedMessage cKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.cKP = mVar;
        this.cKQ = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Jo */
    public Void doInBackground() {
        if (this.cKQ.getData() instanceof String) {
            f.kD((String) this.cKQ.getData());
            return null;
        }
        return null;
    }
}
