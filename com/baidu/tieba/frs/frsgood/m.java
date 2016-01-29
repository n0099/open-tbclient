package com.baidu.tieba.frs.frsgood;

import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fh;
import com.baidu.tieba.tbadkCore.d;
/* loaded from: classes.dex */
class m implements fe {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(ff ffVar) {
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(int i, int i2, fh fhVar) {
        this.bnm.bnk = i;
        if (!com.baidu.adp.lib.util.i.iZ()) {
            this.bnm.b((d.a) null);
        } else {
            this.bnm.cy(false);
        }
    }

    @Override // com.baidu.tieba.frs.fe
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fe
    public void Op() {
    }
}
