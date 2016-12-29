package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class n extends s<Void> {
    final /* synthetic */ m cLq;
    private final /* synthetic */ CustomResponsedMessage cLr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.cLq = mVar;
        this.cLr = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Mu */
    public Void doInBackground() {
        if (this.cLr.getData() instanceof String) {
            f.kw((String) this.cLr.getData());
            return null;
        }
        return null;
    }
}
