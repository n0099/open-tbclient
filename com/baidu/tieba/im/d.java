package com.baidu.tieba.im;

import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
class d extends t<Integer> {
    final /* synthetic */ c cRZ;
    private final /* synthetic */ boolean cSa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, boolean z) {
        this.cRZ = cVar;
        this.cSa = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Integer doInBackground() {
        if (!this.cSa) {
            com.baidu.tieba.im.db.b.asd().ase();
        }
        return 0;
    }
}
