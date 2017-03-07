package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tieba.frs.f.a;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bNU;
    private int aQT = 0;
    private int aQS = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bNU = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        com.baidu.tieba.frs.f.as asVar;
        int i4;
        com.baidu.tieba.frs.smartsort.c cVar;
        ce ceVar;
        ce ceVar2;
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        com.baidu.tieba.frs.f.as asVar2;
        com.baidu.tieba.frs.f.as asVar3;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.f.u uVar2;
        dVar = this.bNU.bNd;
        if (dVar != null) {
            dVar2 = this.bNU.bNd;
            uVar2 = this.bNU.bMZ;
            dVar2.a(absListView, i, i2, i3, uVar2.aei());
        }
        aVar = this.bNU.bNn;
        if (aVar != null) {
            aVar2 = this.bNU.bNn;
            aVar2.adD();
        }
        asVar = this.bNU.bNo;
        if (asVar != null) {
            asVar2 = this.bNU.bNo;
            asVar2.a(absListView, i);
            asVar3 = this.bNU.bNo;
            i4 = asVar3.aen();
        } else {
            i4 = 0;
        }
        cVar = this.bNU.bNg;
        if (cVar != null) {
            cVar2 = this.bNU.bNg;
            cVar2.adq();
        }
        ceVar = this.bNU.bNj;
        if (ceVar != null) {
            ceVar2 = this.bNU.bNj;
            uVar = this.bNU.bMZ;
            ceVar2.a(absListView, i + i4, i2, i3, uVar.aei() - i4, this.bNU.YL());
        }
        if (this.bNU.bMO != null && this.bNU.bMN != null && this.bNU.bMN.ZG() != null) {
            this.aQT = i;
            this.aQS = (i + i2) - 1;
            this.bNU.bMN.ai(this.aQT, this.aQS);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.f.as asVar;
        int i2;
        ce ceVar;
        boolean z;
        com.baidu.adp.widget.ListView.x xVar;
        ce ceVar2;
        com.baidu.tieba.frs.f.as asVar2;
        com.baidu.tieba.frs.f.as asVar3;
        com.baidu.tieba.frs.f.u uVar2;
        uVar = this.bNU.bMZ;
        if (uVar != null) {
            uVar2 = this.bNU.bMZ;
            uVar2.setScrollState(i);
        }
        asVar = this.bNU.bNo;
        if (asVar != null) {
            asVar2 = this.bNU.bNo;
            asVar2.onScrollStateChanged(absListView, i);
            asVar3 = this.bNU.bNo;
            i2 = asVar3.aen();
        } else {
            i2 = 0;
        }
        ceVar = this.bNU.bNj;
        if (ceVar != null) {
            ceVar2 = this.bNU.bNj;
            ceVar2.a(absListView, i, i2);
        }
        if (i == 2 || i == 1) {
            z = this.bNU.bMU;
            if (!z) {
                this.bNU.bMU = true;
                this.bNU.bMN.ZJ();
            }
        }
        if (this.bNU.bMV == null) {
            this.bNU.bMV = new com.baidu.tbadk.performanceLog.e();
            this.bNU.bMV.fb(1000);
        }
        if (i != 0) {
            this.bNU.bMN.setOnAdapterItemLongClickListener(null);
        } else {
            com.baidu.tieba.card.cc.Sv().cN(true);
            ax axVar = this.bNU.bMN;
            xVar = this.bNU.bNS;
            axVar.setOnAdapterItemLongClickListener(xVar);
            this.bNU.bMN.ah(this.aQT, this.aQS);
        }
        this.bNU.bMV.FP();
        if (i == 0) {
            com.baidu.tieba.frs.utils.s.a(this.bNU.bMN, this.bNU.bMO, this.bNU.getForumId(), false, null);
        }
    }
}
