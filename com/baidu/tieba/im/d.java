package com.baidu.tieba.im;

import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
class d extends t<Integer> {
    final /* synthetic */ c cGt;
    private final /* synthetic */ boolean cGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cGt = cVar;
        this.cGu = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Integer doInBackground() {
        if (!this.cGu) {
            com.baidu.tieba.im.db.b.ano().anp();
        }
        return 0;
    }
}
