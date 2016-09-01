package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
class n extends t<Void> {
    final /* synthetic */ m cZk;
    private final /* synthetic */ CustomResponsedMessage cZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.cZk = mVar;
        this.cZl = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: LP */
    public Void doInBackground() {
        if (this.cZl.getData() instanceof String) {
            f.lt((String) this.cZl.getData());
            return null;
        }
        return null;
    }
}
