package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tieba.frs.e.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements AbsListView.OnScrollListener {
    final /* synthetic */ r bPn;
    private int aRG = 0;
    private int aRF = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.bPn = rVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tbadk.util.s sVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        com.baidu.tieba.frs.smartsort.c cVar;
        ca caVar;
        ca caVar2;
        com.baidu.tieba.frs.e.u uVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.e.u uVar2;
        com.baidu.tbadk.util.s sVar2;
        sVar = this.bPn.aJs;
        if (sVar != null && this.bPn.isPrimary()) {
            sVar2 = this.bPn.aJs;
            sVar2.a(absListView, this.aRG, i, i2, i3);
        }
        dVar = this.bPn.bOz;
        if (dVar != null) {
            dVar2 = this.bPn.bOz;
            uVar2 = this.bPn.bOx;
            dVar2.a(absListView, i, i2, i3, uVar2.ade());
        }
        aVar = this.bPn.bOI;
        if (aVar != null) {
            aVar2 = this.bPn.bOI;
            aVar2.acC();
        }
        cVar = this.bPn.bOC;
        if (cVar != null) {
            cVar2 = this.bPn.bOC;
            cVar2.acn();
        }
        caVar = this.bPn.bOE;
        if (caVar != null) {
            caVar2 = this.bPn.bOE;
            uVar = this.bPn.bOx;
            caVar2.a(absListView, i, i2, i3, uVar.ade(), false);
        }
        if (this.bPn.bNT != null && this.bPn.bOn != null && this.bPn.bOn.ZO() != null) {
            this.aRG = i;
            this.aRF = (i + i2) - 1;
            this.bPn.bOn.aj(this.aRG, this.aRF);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.e.u uVar;
        com.baidu.tbadk.util.s sVar;
        ca caVar;
        boolean z;
        ca caVar2;
        com.baidu.tbadk.util.s sVar2;
        com.baidu.tieba.frs.e.u uVar2;
        uVar = this.bPn.bOx;
        if (uVar != null) {
            uVar2 = this.bPn.bOx;
            uVar2.setScrollState(i);
        }
        sVar = this.bPn.aJs;
        if (sVar != null && this.bPn.isPrimary()) {
            sVar2 = this.bPn.aJs;
            sVar2.onScrollStateChanged(absListView, i);
        }
        caVar = this.bPn.bOE;
        if (caVar != null) {
            caVar2 = this.bPn.bOE;
            caVar2.a(absListView, i, 0);
        }
        if (i == 2 || i == 1) {
            z = this.bPn.bOs;
            if (!z) {
                this.bPn.bOs = true;
                this.bPn.bOn.ZR();
            }
        }
        if (this.bPn.bOt == null && !this.bPn.Zt()) {
            this.bPn.bOt = new com.baidu.tbadk.j.e();
            this.bPn.bOt.fa(1000);
        }
        if (i == 0) {
            com.baidu.tieba.card.ca.To().dc(true);
            this.bPn.bOn.ai(this.aRG, this.aRF);
        }
        if (this.bPn.bOt != null) {
            this.bPn.bOt.Fr();
        }
        if (i == 0) {
            com.baidu.tieba.frs.d.o.a(this.bPn.bOn, this.bPn.bNT, this.bPn.getForumId(), false, null);
        }
    }
}
