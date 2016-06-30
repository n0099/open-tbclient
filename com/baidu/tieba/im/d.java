package com.baidu.tieba.im;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class d extends s<Integer> {
    final /* synthetic */ c cDE;
    private final /* synthetic */ boolean cDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cDE = cVar;
        this.cDF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Integer doInBackground() {
        if (!this.cDF) {
            com.baidu.tieba.im.db.b.amE().amF();
        }
        return 0;
    }
}
