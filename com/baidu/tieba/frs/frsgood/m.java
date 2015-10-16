package com.baidu.tieba.frs.frsgood;

import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.tbadkCore.e;
/* loaded from: classes.dex */
class m implements ea {
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
        this.aZM.aZK = i;
        if (!com.baidu.adp.lib.util.i.iM()) {
            this.aZM.b((e.a) null);
        } else {
            this.aZM.ci(false);
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Ku() {
    }
}
