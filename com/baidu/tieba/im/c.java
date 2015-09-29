package com.baidu.tieba.im;

import com.baidu.tbadk.util.l;
/* loaded from: classes.dex */
class c extends l<Integer> {
    final /* synthetic */ b bqm;
    private final /* synthetic */ boolean bqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.bqm = bVar;
        this.bqn = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Integer doInBackground() {
        if (!this.bqn) {
            com.baidu.tieba.im.db.b.TD().TE();
        }
        return 0;
    }
}
