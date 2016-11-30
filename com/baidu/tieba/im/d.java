package com.baidu.tieba.im;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class d extends s<Integer> {
    final /* synthetic */ c cZb;
    private final /* synthetic */ boolean cZc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cZb = cVar;
        this.cZc = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Integer doInBackground() {
        if (!this.cZc) {
            com.baidu.tieba.im.db.b.auz().auA();
        }
        return 0;
    }
}
