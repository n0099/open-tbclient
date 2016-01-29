package com.baidu.tieba.im;

import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
class d extends m<Integer> {
    final /* synthetic */ c bNx;
    private final /* synthetic */ boolean bNy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.bNx = cVar;
        this.bNy = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Integer doInBackground() {
        if (!this.bNy) {
            com.baidu.tieba.im.db.b.aaR().aaS();
        }
        return 0;
    }
}
