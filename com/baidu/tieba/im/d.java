package com.baidu.tieba.im;

import com.baidu.tbadk.util.s;
/* loaded from: classes.dex */
class d extends s<Integer> {
    final /* synthetic */ c cLw;
    private final /* synthetic */ boolean cLx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cLw = cVar;
        this.cLx = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Integer doInBackground() {
        if (!this.cLx) {
            com.baidu.tieba.im.db.b.aqf().aqg();
        }
        return 0;
    }
}
