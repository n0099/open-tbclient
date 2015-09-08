package com.baidu.tieba.frs.frsgood;

import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.tbadkCore.e;
/* loaded from: classes.dex */
class m implements dh {
    final /* synthetic */ FrsGoodActivity aZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsGoodActivity frsGoodActivity) {
        this.aZI = frsGoodActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(di diVar) {
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dj djVar) {
        this.aZI.aZG = i;
        if (!com.baidu.adp.lib.util.i.iL()) {
            this.aZI.b((e.a) null);
        } else {
            this.aZI.cl(false);
        }
    }

    @Override // com.baidu.tieba.frs.dh
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dh
    public void Kz() {
    }
}
