package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tieba.frs.g.a;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bNJ;
    private int aRj = 0;
    private int aRi = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
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
        dVar = this.bNJ.bMT;
        if (dVar != null) {
            dVar2 = this.bNJ.bMT;
            uVar2 = this.bNJ.bMP;
            dVar2.a(absListView, i, i2, i3, uVar2.aed());
        }
        aVar = this.bNJ.bNc;
        if (aVar != null) {
            aVar2 = this.bNJ.bNc;
            aVar2.ady();
        }
        asVar = this.bNJ.bNd;
        if (asVar != null) {
            asVar2 = this.bNJ.bNd;
            asVar2.a(absListView, i);
            asVar3 = this.bNJ.bNd;
            i4 = asVar3.aei();
        } else {
            i4 = 0;
        }
        cVar = this.bNJ.bMW;
        if (cVar != null) {
            cVar2 = this.bNJ.bMW;
            cVar2.adk();
        }
        cgVar = this.bNJ.bMY;
        if (cgVar != null) {
            cgVar2 = this.bNJ.bMY;
            uVar = this.bNJ.bMP;
            cgVar2.a(absListView, i + i4, i2, i3, uVar.aed() - i4, this.bNJ.Zh());
        }
        if (this.bNJ.bME != null && this.bNJ.bMD != null && this.bNJ.bMD.aae() != null) {
            this.aRj = i;
            this.aRi = (i + i2) - 1;
            this.bNJ.bMD.ai(this.aRj, this.aRi);
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
        uVar = this.bNJ.bMP;
        if (uVar != null) {
            uVar2 = this.bNJ.bMP;
            uVar2.setScrollState(i);
        }
        asVar = this.bNJ.bNd;
        if (asVar != null) {
            asVar2 = this.bNJ.bNd;
            asVar2.onScrollStateChanged(absListView, i);
            asVar3 = this.bNJ.bNd;
            i2 = asVar3.aei();
        } else {
            i2 = 0;
        }
        cgVar = this.bNJ.bMY;
        if (cgVar != null) {
            cgVar2 = this.bNJ.bMY;
            cgVar2.a(absListView, i, i2);
        }
        if (i == 2 || i == 1) {
            z = this.bNJ.bMK;
            if (!z) {
                this.bNJ.bMK = true;
                this.bNJ.bMD.aah();
            }
        }
        if (this.bNJ.bML == null) {
            this.bNJ.bML = new com.baidu.tbadk.j.e();
            this.bNJ.bML.fe(1000);
        }
        if (i != 0) {
            this.bNJ.bMD.setOnAdapterItemLongClickListener(null);
        } else {
            com.baidu.tieba.card.cc.ST().cP(true);
            az azVar = this.bNJ.bMD;
            xVar = this.bNJ.bNH;
            azVar.setOnAdapterItemLongClickListener(xVar);
            this.bNJ.bMD.ah(this.aRj, this.aRi);
        }
        this.bNJ.bML.Gn();
        if (i == 0) {
            com.baidu.tieba.frs.f.s.a(this.bNJ.bMD, this.bNJ.bME, this.bNJ.getForumId(), false, null);
        }
    }
}
