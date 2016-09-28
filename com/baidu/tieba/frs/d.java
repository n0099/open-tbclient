package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements dh {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dq dqVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        bm bmVar;
        b bVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        dh dhVar;
        dh dhVar2;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        bm bmVar9;
        com.baidu.tieba.frs.i.p pVar;
        b bVar2;
        bm bmVar10;
        bmVar = this.bQi.bPi;
        if (bmVar.abA() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar10 = this.bQi.bPi;
            ((com.baidu.tieba.frs.tab.h) bmVar10.abA()).afo();
        }
        bVar = this.bQi.bPF;
        if (bVar != null) {
            pVar = this.bQi.bPu;
            bVar2 = this.bQi.bPF;
            pVar.eh(bVar2.mo14if(i));
        }
        e.a aVar = new e.a();
        if (dqVar != null) {
            aVar.isSuccess = dqVar.errCode == 0;
            aVar.errorCode = dqVar.errCode;
            aVar.errorMsg = dqVar.errMsg;
            if (aVar.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    bmVar6 = this.bQi.bPi;
                    bmVar6.acc();
                } else if (dqVar.hasMore) {
                    bmVar9 = this.bQi.bPi;
                    bmVar9.aca();
                } else if (dqVar.bTB) {
                    bmVar8 = this.bQi.bPi;
                    bmVar8.acb();
                } else {
                    bmVar7 = this.bQi.bPi;
                    bmVar7.acc();
                }
            }
        } else {
            dqVar = new dq();
            dqVar.pn = 1;
            dqVar.hasMore = false;
            dqVar.bTB = false;
        }
        if (i == 1) {
            this.bQi.bPs = true;
            this.bQi.bPP.a(this.bQi.bPt.getType(), false, aVar);
        } else {
            if (dqVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar.errorCode) {
                    FrsActivity frsActivity = this.bQi;
                    bmVar3 = this.bQi.bPi;
                    frsActivity.showNetRefreshViewNoClick(bmVar3.getRootView(), aVar.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.bQi;
                    bmVar2 = this.bQi.bPi;
                    frsActivity2.showNetRefreshView(bmVar2.getRootView(), aVar.errorMsg, true);
                }
                this.bQi.setNetRefreshViewEmotionDefMarginTop();
            }
            this.bQi.aaT();
            bmVar4 = this.bQi.bPi;
            bmVar4.abN().ku();
            if (this.bQi.abi().aek() != null) {
                this.bQi.bPk = this.bQi.abi().aek();
            }
            bmVar5 = this.bQi.bPi;
            bmVar5.dI(false);
        }
        dhVar = this.bQi.bQh;
        if (dhVar == null) {
            return;
        }
        dhVar2 = this.bQi.bQh;
        dhVar2.a(i, i2, dqVar, arrayList);
    }
}
