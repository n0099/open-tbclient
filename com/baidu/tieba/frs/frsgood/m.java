package com.baidu.tieba.frs.frsgood;

import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fq;
import com.baidu.tieba.tbadkCore.d;
/* loaded from: classes.dex */
class m implements fo {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(fp fpVar) {
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(int i, int i2, fq fqVar) {
        this.bsj.bsh = i;
        if (!com.baidu.adp.lib.util.i.jf()) {
            this.bsj.b((d.a) null);
        } else {
            this.bsj.cK(false);
        }
    }

    @Override // com.baidu.tieba.frs.fo
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fo
    public void Qe() {
    }
}
