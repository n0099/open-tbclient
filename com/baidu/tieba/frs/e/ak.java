package com.baidu.tieba.frs.e;

import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ca;
/* loaded from: classes.dex */
class ak implements Runnable {
    final /* synthetic */ aj cbS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.cbS = ajVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ag agVar;
        at atVar;
        ag agVar2;
        ca caVar;
        ag agVar3;
        at atVar2;
        ag agVar4;
        ca caVar2;
        agVar = this.cbS.cbR;
        atVar = agVar.bOn;
        if (atVar.Zw() != null) {
            agVar2 = this.cbS.cbR;
            caVar = agVar2.bYD;
            if (caVar != null) {
                agVar3 = this.cbS.cbR;
                atVar2 = agVar3.bOn;
                if (atVar2.Zw().getVisibility() != 0) {
                    agVar4 = this.cbS.cbR;
                    caVar2 = agVar4.bYD;
                    caVar2.Gy();
                }
            }
        }
    }
}
