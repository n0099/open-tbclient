package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tieba.frs.f.a;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bGL;
    private int aLi = 0;
    private int aLh = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        com.baidu.tieba.frs.f.aq aqVar;
        int i4;
        com.baidu.tieba.frs.smartsort.c cVar;
        ce ceVar;
        ce ceVar2;
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        com.baidu.tieba.frs.f.aq aqVar2;
        com.baidu.tieba.frs.f.aq aqVar3;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.f.u uVar2;
        dVar = this.bGL.bFV;
        if (dVar != null) {
            dVar2 = this.bGL.bFV;
            uVar2 = this.bGL.bFR;
            dVar2.a(absListView, i, i2, i3, uVar2.adi());
        }
        aVar = this.bGL.bGf;
        if (aVar != null) {
            aVar2 = this.bGL.bGf;
            aVar2.acD();
        }
        aqVar = this.bGL.bGg;
        if (aqVar != null) {
            aqVar2 = this.bGL.bGg;
            aqVar2.a(absListView, i);
            aqVar3 = this.bGL.bGg;
            i4 = aqVar3.adn();
        } else {
            i4 = 0;
        }
        cVar = this.bGL.bFY;
        if (cVar != null) {
            cVar2 = this.bGL.bFY;
            cVar2.acs();
        }
        ceVar = this.bGL.bGb;
        if (ceVar != null) {
            ceVar2 = this.bGL.bGb;
            uVar = this.bGL.bFR;
            ceVar2.a(absListView, i + i4, i2, i3, uVar.adi() - i4, this.bGL.XM());
        }
        if (this.bGL.bFG != null && this.bGL.bFF != null && this.bGL.bFF.YH() != null) {
            this.aLi = i;
            this.aLh = (i + i2) - 1;
            this.bGL.bFF.ac(this.aLi, this.aLh);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.f.aq aqVar;
        int i2;
        ce ceVar;
        boolean z;
        com.baidu.adp.widget.ListView.x xVar;
        ce ceVar2;
        com.baidu.tieba.frs.f.aq aqVar2;
        com.baidu.tieba.frs.f.aq aqVar3;
        com.baidu.tieba.frs.f.u uVar2;
        uVar = this.bGL.bFR;
        if (uVar != null) {
            uVar2 = this.bGL.bFR;
            uVar2.setScrollState(i);
        }
        aqVar = this.bGL.bGg;
        if (aqVar != null) {
            aqVar2 = this.bGL.bGg;
            aqVar2.onScrollStateChanged(absListView, i);
            aqVar3 = this.bGL.bGg;
            i2 = aqVar3.adn();
        } else {
            i2 = 0;
        }
        ceVar = this.bGL.bGb;
        if (ceVar != null) {
            ceVar2 = this.bGL.bGb;
            ceVar2.a(absListView, i, i2);
        }
        if (i == 2 || i == 1) {
            z = this.bGL.bFM;
            if (!z) {
                this.bGL.bFM = true;
                this.bGL.bFF.YK();
            }
        }
        if (this.bGL.bFN == null) {
            this.bGL.bFN = new com.baidu.tbadk.performanceLog.e();
            this.bGL.bFN.fh(1000);
        }
        if (i != 0) {
            this.bGL.bFF.setOnAdapterItemLongClickListener(null);
        } else {
            com.baidu.tieba.card.cc.Rx().cN(true);
            ax axVar = this.bGL.bFF;
            xVar = this.bGL.bGJ;
            axVar.setOnAdapterItemLongClickListener(xVar);
            this.bGL.bFF.ab(this.aLi, this.aLh);
        }
        this.bGL.bFN.Fv();
        if (i == 0) {
            com.baidu.tieba.frs.utils.s.a(this.bGL.bFF, this.bGL.bFG, this.bGL.getForumId(), false, null);
        }
    }
}
