package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class n extends s<Void> {
    final /* synthetic */ m cUO;
    private final /* synthetic */ CustomResponsedMessage cUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.cUO = mVar;
        this.cUP = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: LT */
    public Void doInBackground() {
        if (this.cUP.getData() instanceof String) {
            f.kl((String) this.cUP.getData());
            return null;
        }
        return null;
    }
}
