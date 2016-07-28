package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
class n extends t<Void> {
    final /* synthetic */ m cNF;
    private final /* synthetic */ CustomResponsedMessage cNG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.cNF = mVar;
        this.cNG = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Jn */
    public Void doInBackground() {
        if (this.cNG.getData() instanceof String) {
            f.kK((String) this.cNG.getData());
            return null;
        }
        return null;
    }
}
