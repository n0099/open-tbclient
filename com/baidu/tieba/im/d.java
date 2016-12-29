package com.baidu.tieba.im;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class d extends s<Integer> {
    final /* synthetic */ c cEn;
    private final /* synthetic */ boolean cEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cEn = cVar;
        this.cEo = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Integer doInBackground() {
        if (!this.cEo) {
            com.baidu.tieba.im.db.b.aoY().aoZ();
        }
        return 0;
    }
}
