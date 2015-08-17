package com.baidu.tieba.frs;

import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
class a implements dc {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dc
    public void a(int i, int i2, df dfVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        bl blVar;
        int i3;
        int i4;
        com.baidu.tieba.frs.c.n nVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        com.baidu.tieba.frs.c.n nVar2;
        com.baidu.tieba.frs.c.n nVar3;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.frs.c.a aVar2;
        com.baidu.tieba.frs.c.a aVar3;
        bl blVar5;
        com.baidu.tieba.frs.c.n nVar4;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        bl blVar9;
        int i5;
        int i6;
        bl blVar10;
        bl blVar11;
        d.a aVar4 = new d.a();
        if (dfVar != null) {
            aVar4.isSuccess = dfVar.errCode == 0;
            aVar4.errorCode = dfVar.errCode;
            aVar4.errorMsg = dfVar.errMsg;
            if (arrayList == null || arrayList.size() == 0) {
                blVar7 = this.this$0.aUw;
                blVar7.Mq();
            } else if (dfVar.hasMore) {
                blVar11 = this.this$0.aUw;
                blVar11.Mo();
            } else if (dfVar.aYJ) {
                blVar9 = this.this$0.aUw;
                i5 = FrsActivity.aUj;
                int size = arrayList.size();
                i6 = FrsActivity.aUk;
                blVar9.fr(i5 - (size * i6));
                blVar10 = this.this$0.aUw;
                blVar10.Mp();
            } else {
                blVar8 = this.this$0.aUw;
                blVar8.Mq();
            }
        } else {
            dfVar = new df();
            dfVar.pn = 1;
            dfVar.hasMore = false;
            dfVar.aYJ = false;
            if (arrayList != null) {
                blVar = this.this$0.aUw;
                i3 = FrsActivity.aUj;
                int size2 = arrayList.size();
                i4 = FrsActivity.aUk;
                blVar.fr(i3 - (size2 * i4));
            }
        }
        nVar = this.this$0.aUL;
        if (!nVar.Z(i, i2)) {
            aVar2 = this.this$0.aUM;
            if (aVar2.NI()) {
                n.a aVar5 = new n.a();
                aVar3 = this.this$0.aUM;
                if (aVar3.NK()) {
                    blVar6 = this.this$0.aUw;
                    aVar5.bbI = blVar6.getListView().getHeaderViewsCount() - 2;
                } else {
                    blVar5 = this.this$0.aUw;
                    aVar5.bbI = blVar5.getListView().getHeaderViewsCount() - 1;
                }
                aVar5.top = 0;
                nVar4 = this.this$0.aUL;
                nVar4.a(i, i2, aVar5);
            }
        }
        if (i == 1) {
            com.baidu.tieba.tbadkCore.q qVar = this.this$0.aUV;
            aVar = this.this$0.aUK;
            qVar.a(aVar.getType(), false, aVar4);
        } else {
            if (dfVar.errCode != 0 || arrayList == null || arrayList.size() == 0) {
                if (340001 == aVar4.errorCode) {
                    FrsActivity frsActivity = this.this$0;
                    blVar3 = this.this$0.aUw;
                    frsActivity.showNetRefreshViewNoClick(blVar3.getRootView(), aVar4.errorMsg, true);
                } else {
                    FrsActivity frsActivity2 = this.this$0;
                    blVar2 = this.this$0.aUw;
                    frsActivity2.showNetRefreshView(blVar2.getRootView(), aVar4.errorMsg, true);
                }
            }
            blVar4 = this.this$0.aUw;
            blVar4.ca(false);
            if (this.this$0.Lz().MS() != null) {
                this.this$0.aUy = this.this$0.Lz().MS();
            }
            this.this$0.Lp();
        }
        nVar2 = this.this$0.aUL;
        if (nVar2.NP() != null) {
            nVar3 = this.this$0.aUL;
            nVar3.NP().a(i, i2, dfVar, arrayList);
        }
    }
}
