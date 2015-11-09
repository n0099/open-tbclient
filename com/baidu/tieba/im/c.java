package com.baidu.tieba.im;

import com.baidu.tbadk.util.l;
/* loaded from: classes.dex */
class c extends l<Integer> {
    final /* synthetic */ b brb;
    private final /* synthetic */ boolean brc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.brb = bVar;
        this.brc = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Integer doInBackground() {
        if (!this.brc) {
            com.baidu.tieba.im.db.b.TU().TV();
        }
        return 0;
    }
}
