package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tieba.frs.j.a;
/* loaded from: classes.dex */
class l implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bTa;
    private int aMQ = 0;
    private int aMP = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        com.baidu.tieba.frs.j.ai aiVar;
        int i4;
        com.baidu.tieba.frs.g.d dVar2;
        ch chVar;
        com.baidu.tieba.tbadkCore.data.f fVar;
        boolean z;
        ch chVar2;
        com.baidu.tieba.frs.j.n nVar;
        com.baidu.tieba.frs.g.d dVar3;
        com.baidu.tieba.frs.j.ai aiVar2;
        com.baidu.tieba.frs.j.ai aiVar3;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar4;
        com.baidu.tieba.frs.j.n nVar2;
        dVar = this.bTa.bSm;
        if (dVar != null) {
            dVar4 = this.bTa.bSm;
            nVar2 = this.bTa.bSi;
            dVar4.a(absListView, i, i2, i3, nVar2.ahE());
        }
        aVar = this.bTa.bSx;
        if (aVar != null) {
            aVar2 = this.bTa.bSx;
            aVar2.ahb();
        }
        aiVar = this.bTa.bSA;
        if (aiVar != null) {
            aiVar2 = this.bTa.bSA;
            aiVar2.a(absListView, i);
            aiVar3 = this.bTa.bSA;
            i4 = aiVar3.ahH();
        } else {
            i4 = 0;
        }
        dVar2 = this.bTa.bSp;
        if (dVar2 != null) {
            dVar3 = this.bTa.bSp;
            dVar3.agQ();
        }
        chVar = this.bTa.bSs;
        if (chVar != null) {
            chVar2 = this.bTa.bSs;
            nVar = this.bTa.bSi;
            chVar2.a(absListView, i + i4, i2, i3, nVar.ahE() - i4, this.bTa.ach());
        }
        if (this.bTa.bRX != null && this.bTa.bRW != null && this.bTa.bRW.ade() != null) {
            FrsActivity frsActivity = this.bTa;
            fVar = this.bTa.bRS;
            z = this.bTa.bRR;
            com.baidu.tieba.frs.utils.t.a(frsActivity, fVar, z, i, i2);
            this.aMQ = i;
            this.aMP = (i + i2) - 1;
            this.bTa.bRW.ai(this.aMQ, this.aMP);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.j.n nVar;
        com.baidu.tieba.frs.j.ai aiVar;
        int i2;
        ch chVar;
        boolean z;
        com.baidu.adp.widget.ListView.x xVar;
        ch chVar2;
        com.baidu.tieba.frs.j.ai aiVar2;
        com.baidu.tieba.frs.j.ai aiVar3;
        com.baidu.tieba.frs.j.n nVar2;
        nVar = this.bTa.bSi;
        if (nVar != null) {
            nVar2 = this.bTa.bSi;
            nVar2.setScrollState(i);
        }
        aiVar = this.bTa.bSA;
        if (aiVar != null) {
            aiVar2 = this.bTa.bSA;
            aiVar2.onScrollStateChanged(absListView, i);
            aiVar3 = this.bTa.bSA;
            i2 = aiVar3.ahH();
        } else {
            i2 = 0;
        }
        chVar = this.bTa.bSs;
        if (chVar != null) {
            chVar2 = this.bTa.bSs;
            chVar2.a(absListView, i, i2);
        }
        if (i == 2 || i == 1) {
            z = this.bTa.bSd;
            if (!z) {
                this.bTa.bSd = true;
                this.bTa.bRW.adh();
            }
        }
        if (this.bTa.bSe == null) {
            this.bTa.bSe = new com.baidu.tbadk.performanceLog.e();
            this.bTa.bSe.fg(1000);
        }
        if (i != 0) {
            this.bTa.bRW.a((com.baidu.adp.widget.ListView.x) null);
        } else {
            com.baidu.tieba.card.bx.Pl().cx(true);
            au auVar = this.bTa.bRW;
            xVar = this.bTa.bSY;
            auVar.a(xVar);
            this.bTa.bRW.ah(this.aMQ, this.aMP);
        }
        this.bTa.bSe.Gb();
        if (i == 0) {
            com.baidu.tieba.frs.utils.t.a(this.bTa.bRW, this.bTa.bRX, this.bTa.getForumId(), false, (com.baidu.tbadk.core.data.bk) null);
        }
    }
}
