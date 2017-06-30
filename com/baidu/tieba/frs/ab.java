package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tieba.frs.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements AbsListView.OnScrollListener {
    final /* synthetic */ r cdl;
    private int cdm = 0;
    private int baJ = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.cdl = rVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tbadk.util.t tVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        com.baidu.tieba.frs.smartsort.c cVar;
        cc ccVar;
        cc ccVar2;
        com.baidu.tieba.frs.f.m mVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.f.m mVar2;
        com.baidu.tbadk.util.t tVar2;
        tVar = this.cdl.aKu;
        if (tVar != null && this.cdl.isPrimary()) {
            tVar2 = this.cdl.aKu;
            tVar2.a(absListView, this.cdm, i, i2, i3);
        }
        dVar = this.cdl.ccu;
        if (dVar != null) {
            dVar2 = this.cdl.ccu;
            mVar2 = this.cdl.cct;
            dVar2.a(absListView, i, i2, i3, mVar2.ahV());
        }
        aVar = this.cdl.ccD;
        if (aVar != null) {
            aVar2 = this.cdl.ccD;
            aVar2.ahy();
        }
        cVar = this.cdl.ccx;
        if (cVar != null) {
            cVar2 = this.cdl.ccx;
            cVar2.ahj();
        }
        ccVar = this.cdl.ccz;
        if (ccVar != null) {
            ccVar2 = this.cdl.ccz;
            mVar = this.cdl.cct;
            ccVar2.a(absListView, i, i2, i3, mVar.ahV(), false);
        }
        if (this.cdl.cbN != null && this.cdl.ccj != null && this.cdl.ccj.aeI() != null) {
            this.cdm = i;
            this.baJ = (i + i2) - 1;
            this.cdl.ccj.ap(this.cdm, this.baJ);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.f.m mVar;
        com.baidu.tbadk.util.t tVar;
        cc ccVar;
        boolean z;
        cc ccVar2;
        com.baidu.tbadk.util.t tVar2;
        com.baidu.tieba.frs.f.m mVar2;
        mVar = this.cdl.cct;
        if (mVar != null) {
            mVar2 = this.cdl.cct;
            mVar2.setScrollState(i);
        }
        tVar = this.cdl.aKu;
        if (tVar != null && this.cdl.isPrimary()) {
            tVar2 = this.cdl.aKu;
            tVar2.onScrollStateChanged(absListView, i);
        }
        ccVar = this.cdl.ccz;
        if (ccVar != null) {
            ccVar2 = this.cdl.ccz;
            ccVar2.a(absListView, i, 0);
        }
        if (i == 2 || i == 1) {
            z = this.cdl.cco;
            if (!z) {
                this.cdl.cco = true;
                this.cdl.ccj.aeK();
            }
        }
        if (this.cdl.ccp == null && !this.cdl.aem()) {
            this.cdl.ccp = new com.baidu.tbadk.j.e();
            this.cdl.ccp.fd(1000);
        }
        if (i == 0) {
            com.baidu.tieba.card.cf.VN().dv(true);
            this.cdl.ccj.ao(this.cdm, this.baJ);
        }
        if (this.cdl.ccp != null) {
            this.cdl.ccp.FI();
        }
        if (i == 0) {
            com.baidu.tieba.frs.e.o.a(this.cdl.ccj, this.cdl.cbN, this.cdl.getForumId(), false, null);
        }
    }
}
