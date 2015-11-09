package com.baidu.tieba.frs.frsgood;

import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.tbadkCore.e;
/* loaded from: classes.dex */
class m implements ec {
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(ed edVar) {
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(int i, int i2, ee eeVar) {
        this.baf.bad = i;
        if (!com.baidu.adp.lib.util.i.iN()) {
            this.baf.b((e.a) null);
        } else {
            this.baf.ck(false);
        }
    }

    @Override // com.baidu.tieba.frs.ec
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ec
    public void KG() {
    }
}
