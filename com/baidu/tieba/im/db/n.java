package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ m bwQ;
    private final /* synthetic */ CustomResponsedMessage bwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.bwQ = mVar;
        this.bwR = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gl */
    public Void doInBackground() {
        if (this.bwR.getData() instanceof String) {
            f.hO((String) this.bwR.getData());
            return null;
        }
        return null;
    }
}
