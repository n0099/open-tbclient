package com.baidu.tieba.frs.frsgood;

import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.tbadkCore.d;
/* loaded from: classes.dex */
class m implements db {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // com.baidu.tieba.frs.db
    public void a(dc dcVar) {
    }

    @Override // com.baidu.tieba.frs.db
    public void a(int i, int i2, de deVar) {
        this.aZp.aZn = i;
        if (!com.baidu.adp.lib.util.i.iO()) {
            this.aZp.b((d.a) null);
        } else {
            this.aZp.cg(false);
        }
    }

    @Override // com.baidu.tieba.frs.db
    public void init() {
    }

    @Override // com.baidu.tieba.frs.db
    public void KL() {
    }
}
