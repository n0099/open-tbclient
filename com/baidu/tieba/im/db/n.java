package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ m bxy;
    private final /* synthetic */ CustomResponsedMessage bxz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.bxy = mVar;
        this.bxz = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Ge */
    public Void doInBackground() {
        if (this.bxz.getData() instanceof String) {
            f.hQ((String) this.bxz.getData());
            return null;
        }
        return null;
    }
}
