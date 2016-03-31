package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.p;
/* loaded from: classes.dex */
class n extends p<Void> {
    final /* synthetic */ m ceP;
    private final /* synthetic */ CustomResponsedMessage ceQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.ceP = mVar;
        this.ceQ = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        if (this.ceQ.getData() instanceof String) {
            f.ji((String) this.ceQ.getData());
            return null;
        }
        return null;
    }
}
