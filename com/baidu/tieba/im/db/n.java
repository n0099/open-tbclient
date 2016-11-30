package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class n extends s<Void> {
    final /* synthetic */ m dgv;
    private final /* synthetic */ CustomResponsedMessage dgw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.dgv = mVar;
        this.dgw = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Nb */
    public Void doInBackground() {
        if (this.dgw.getData() instanceof String) {
            f.lT((String) this.dgw.getData());
            return null;
        }
        return null;
    }
}
