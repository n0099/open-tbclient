package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
class n extends t<Void> {
    final /* synthetic */ m daJ;
    private final /* synthetic */ CustomResponsedMessage daK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.daJ = mVar;
        this.daK = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Mt */
    public Void doInBackground() {
        if (this.daK.getData() instanceof String) {
            f.lG((String) this.daK.getData());
            return null;
        }
        return null;
    }
}
