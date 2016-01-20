package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class n extends com.baidu.tbadk.util.m<Void> {
    final /* synthetic */ m bQk;
    private final /* synthetic */ CustomResponsedMessage bQl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, CustomResponsedMessage customResponsedMessage) {
        this.bQk = mVar;
        this.bQl = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Ha */
    public Void doInBackground() {
        if (this.bQl.getData() instanceof String) {
            f.iy((String) this.bQl.getData());
            return null;
        }
        return null;
    }
}
