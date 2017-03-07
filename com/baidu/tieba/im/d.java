package com.baidu.tieba.im;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class d extends s<Integer> {
    final /* synthetic */ c cNK;
    private final /* synthetic */ boolean cNL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cNK = cVar;
        this.cNL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Integer doInBackground() {
        if (!this.cNL) {
            com.baidu.tieba.im.db.b.apz().apA();
        }
        return 0;
    }
}
