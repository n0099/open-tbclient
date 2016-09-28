package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.b;
/* loaded from: classes.dex */
class ad implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public boolean b(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.bi biVar;
        com.baidu.tbadk.core.data.bi biVar2;
        com.baidu.tbadk.core.data.bi biVar3;
        com.baidu.tbadk.core.data.bi biVar4;
        com.baidu.tbadk.core.data.bi biVar5;
        com.baidu.tbadk.core.data.bi biVar6;
        bm bmVar;
        com.baidu.tbadk.core.data.bi biVar7;
        if (bdUniqueId == null) {
            return false;
        }
        if (vVar instanceof com.baidu.tbadk.core.data.bi) {
            this.bQi.aLV = (com.baidu.tbadk.core.data.bi) vVar;
            biVar = this.bQi.aLV;
            if (!biVar.isPhotoLiveThread()) {
                biVar2 = this.bQi.aLV;
                if (!(biVar2 instanceof com.baidu.tbadk.core.data.at)) {
                    biVar3 = this.bQi.aLV;
                    if (biVar3 instanceof b) {
                        biVar7 = this.bQi.aLV;
                        if (((b) biVar7).Pp != null) {
                            return false;
                        }
                    }
                    FrsActivity frsActivity = this.bQi;
                    biVar4 = this.bQi.aLV;
                    frsActivity.mThreadId = biVar4.getId();
                    biVar5 = this.bQi.aLV;
                    String rT = biVar5.rT();
                    if (rT == null || rT.equals("")) {
                        this.bQi.bPg = false;
                    } else {
                        this.bQi.bPg = true;
                    }
                    FrsActivity frsActivity2 = this.bQi;
                    biVar6 = this.bQi.aLV;
                    frsActivity2.e(biVar6);
                    bmVar = this.bQi.bPi;
                    bmVar.abI();
                }
            }
        }
        return true;
    }
}
