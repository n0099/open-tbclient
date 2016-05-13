package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class n extends s<Void> {
    final /* synthetic */ m cfv;
    private final /* synthetic */ CustomResponsedMessage cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.cfv = mVar;
        this.cfw = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Iq */
    public Void doInBackground() {
        if (this.cfw.getData() instanceof String) {
            f.jk((String) this.cfw.getData());
            return null;
        }
        return null;
    }
}
