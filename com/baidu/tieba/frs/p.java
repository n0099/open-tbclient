package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tieba.frs.g.a;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bQa;
    private int aRl = 0;
    private int aRk = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bQa = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        com.baidu.tieba.frs.g.as asVar;
        int i4;
        com.baidu.tieba.frs.smartsort.c cVar;
        cg cgVar;
        cg cgVar2;
        com.baidu.tieba.frs.g.u uVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        com.baidu.tieba.frs.g.as asVar2;
        com.baidu.tieba.frs.g.as asVar3;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.g.u uVar2;
        dVar = this.bQa.bPk;
        if (dVar != null) {
            dVar2 = this.bQa.bPk;
            uVar2 = this.bQa.bPg;
            dVar2.a(absListView, i, i2, i3, uVar2.afe());
        }
        aVar = this.bQa.bPt;
        if (aVar != null) {
            aVar2 = this.bQa.bPt;
            aVar2.aez();
        }
        asVar = this.bQa.bPu;
        if (asVar != null) {
            asVar2 = this.bQa.bPu;
            asVar2.a(absListView, i);
            asVar3 = this.bQa.bPu;
            i4 = asVar3.afj();
        } else {
            i4 = 0;
        }
        cVar = this.bQa.bPn;
        if (cVar != null) {
            cVar2 = this.bQa.bPn;
            cVar2.ael();
        }
        cgVar = this.bQa.bPp;
        if (cgVar != null) {
            cgVar2 = this.bQa.bPp;
            uVar = this.bQa.bPg;
            cgVar2.a(absListView, i + i4, i2, i3, uVar.afe() - i4, this.bQa.aai());
        }
        if (this.bQa.bOV != null && this.bQa.bOU != null && this.bQa.bOU.abf() != null) {
            this.aRl = i;
            this.aRk = (i + i2) - 1;
            this.bQa.bOU.ai(this.aRl, this.aRk);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.g.u uVar;
        com.baidu.tieba.frs.g.as asVar;
        int i2;
        cg cgVar;
        boolean z;
        com.baidu.adp.widget.ListView.x xVar;
        cg cgVar2;
        com.baidu.tieba.frs.g.as asVar2;
        com.baidu.tieba.frs.g.as asVar3;
        com.baidu.tieba.frs.g.u uVar2;
        uVar = this.bQa.bPg;
        if (uVar != null) {
            uVar2 = this.bQa.bPg;
            uVar2.setScrollState(i);
        }
        asVar = this.bQa.bPu;
        if (asVar != null) {
            asVar2 = this.bQa.bPu;
            asVar2.onScrollStateChanged(absListView, i);
            asVar3 = this.bQa.bPu;
            i2 = asVar3.afj();
        } else {
            i2 = 0;
        }
        cgVar = this.bQa.bPp;
        if (cgVar != null) {
            cgVar2 = this.bQa.bPp;
            cgVar2.a(absListView, i, i2);
        }
        if (i == 2 || i == 1) {
            z = this.bQa.bPb;
            if (!z) {
                this.bQa.bPb = true;
                this.bQa.bOU.abi();
            }
        }
        if (this.bQa.bPc == null) {
            this.bQa.bPc = new com.baidu.tbadk.j.e();
            this.bQa.bPc.fe(1000);
        }
        if (i != 0) {
            this.bQa.bOU.setOnAdapterItemLongClickListener(null);
        } else {
            com.baidu.tieba.card.cc.TV().cZ(true);
            az azVar = this.bQa.bOU;
            xVar = this.bQa.bPY;
            azVar.setOnAdapterItemLongClickListener(xVar);
            this.bQa.bOU.ah(this.aRl, this.aRk);
        }
        this.bQa.bPc.Gn();
        if (i == 0) {
            com.baidu.tieba.frs.f.s.a(this.bQa.bOU, this.bQa.bOV, this.bQa.getForumId(), false, null);
        }
    }
}
