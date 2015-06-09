package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ o bfr;
    private final /* synthetic */ CustomResponsedMessage bfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CustomResponsedMessage customResponsedMessage) {
        this.bfr = oVar;
        this.bfs = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        if (this.bfs.getData() instanceof String) {
            f.hc((String) this.bfs.getData());
            return null;
        }
        return null;
    }
}
