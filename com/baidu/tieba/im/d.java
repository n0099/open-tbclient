package com.baidu.tieba.im;

import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
class d extends m<Integer> {
    final /* synthetic */ c bJO;
    private final /* synthetic */ boolean bJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.bJO = cVar;
        this.bJP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Integer doInBackground() {
        if (!this.bJP) {
            com.baidu.tieba.im.db.b.Yg().Yh();
        }
        return 0;
    }
}
