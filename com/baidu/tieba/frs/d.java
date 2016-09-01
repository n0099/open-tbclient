package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class d implements dh {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.bQp = frsActivity;
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
        bmVar = this.bQp.bPo;
        if (bmVar.abo() instanceof com.baidu.tieba.frs.tab.h) {
            bmVar10 = this.bQp.bPo;
            ((com.baidu.tieba.frs.tab.h) bmVar10.abo()).afa();
        }
        bVar = this.bQp.bPM;
        if (bVar != null) {
            pVar = this.bQp.bPC;
            bVar2 = this.bQp.bPM;
            pVar.eg(bVar2.ib(i));
        }
        e.a aVar = new e.a();
        if (dqVar != null) {
            aVar.isSuccess = dqVar.errCode == 0;
            aVar.errorCode = dqVar.errCode;
            aVar.errorMsg = dqVar.errMsg;
            if (aVar.isSuccess) {
                if (arrayList == null || arrayList.size() == 0) {
                    bmVar6 = this.bQp.bPo;
                    bmVar6.abP();
                } else if (dqVar.hasMore) {
                    bmVar9 = this.bQp.bPo;
                    bmVar9.abN();
                } else if (dqVar.bTI) {
                    bmVar8 = this.bQp.bPo;
                    bmVar8.abO();
                } else {
                    bmVar7 = this.bQp.bPo;
                    bmVar7.abP();
                }
            }
        } else {
            dqVar = new dq();
            dqVar.pn = 1;
            dqVar.hasMore = false;
            dqVar.bTI = false;
        }
        if (i == 1) {
            this.bQp.bPA = true;
            this.bQp.bPW.a(this.bQp.bPB.getType(), false, aVar);
        } else {
            if (dqVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar.errorCode) {
                    FrsActivity frsActivity = this.bQp;
                    bmVar3 = this.bQp.bPo;
                    frsActivity.showNetRefreshViewNoClick(bmVar3.getRootView(), aVar.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.bQp;
                    bmVar2 = this.bQp.bPo;
                    frsActivity2.showNetRefreshView(bmVar2.getRootView(), aVar.errorMsg, true);
                }
                this.bQp.setNetRefreshViewEmotionDefMarginTop();
            }
            this.bQp.aaF();
            bmVar4 = this.bQp.bPo;
            bmVar4.getListView().ku();
            if (this.bQp.aaV().adV() != null) {
                this.bQp.bPq = this.bQp.aaV().adV();
            }
            bmVar5 = this.bQp.bPo;
            bmVar5.dH(false);
        }
        dhVar = this.bQp.bQo;
        if (dhVar == null) {
            return;
        }
        dhVar2 = this.bQp.bQo;
        dhVar2.a(i, i2, dqVar, arrayList);
    }
}
