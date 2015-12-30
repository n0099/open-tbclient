package com.baidu.tieba.frs.frsgood;

import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ex;
import com.baidu.tieba.tbadkCore.e;
/* loaded from: classes.dex */
class m implements eu {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(ev evVar) {
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ex exVar) {
        this.bkp.bkn = i;
        if (!com.baidu.adp.lib.util.i.iQ()) {
            this.bkp.b((e.a) null);
        } else {
            this.bkp.cy(false);
        }
    }

    @Override // com.baidu.tieba.frs.eu
    public void init() {
    }

    @Override // com.baidu.tieba.frs.eu
    public void My() {
    }
}
