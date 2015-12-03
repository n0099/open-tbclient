package com.baidu.tieba.frs.frsgood;

import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.tbadkCore.e;
/* loaded from: classes.dex */
class m implements et {
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsGoodActivity frsGoodActivity) {
        this.bgy = frsGoodActivity;
    }

    @Override // com.baidu.tieba.frs.et
    public void a(eu euVar) {
    }

    @Override // com.baidu.tieba.frs.et
    public void a(int i, int i2, ew ewVar) {
        this.bgy.bgw = i;
        if (!com.baidu.adp.lib.util.i.iP()) {
            this.bgy.b((e.a) null);
        } else {
            this.bgy.cx(false);
        }
    }

    @Override // com.baidu.tieba.frs.et
    public void init() {
    }

    @Override // com.baidu.tieba.frs.et
    public void Mf() {
    }
}
