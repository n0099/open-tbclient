package com.baidu.tieba.im;

import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
class c extends m<Integer> {
    final /* synthetic */ b bGh;
    private final /* synthetic */ boolean bGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, boolean z) {
        this.bGh = bVar;
        this.bGi = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Integer doInBackground() {
        if (!this.bGi) {
            com.baidu.tieba.im.db.b.Xa().Xb();
        }
        return 0;
    }
}
