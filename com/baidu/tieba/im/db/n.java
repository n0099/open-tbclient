package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class n extends s<Void> {
    final /* synthetic */ m cSy;
    private final /* synthetic */ CustomResponsedMessage cSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.cSy = mVar;
        this.cSz = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Li */
    public Void doInBackground() {
        if (this.cSz.getData() instanceof String) {
            f.kK((String) this.cSz.getData());
            return null;
        }
        return null;
    }
}
