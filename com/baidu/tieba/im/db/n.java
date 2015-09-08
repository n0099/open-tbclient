package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ m btN;
    private final /* synthetic */ CustomResponsedMessage btO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.btN = mVar;
        this.btO = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Gr */
    public Void doInBackground() {
        if (this.btO.getData() instanceof String) {
            f.hK((String) this.btO.getData());
            return null;
        }
        return null;
    }
}
