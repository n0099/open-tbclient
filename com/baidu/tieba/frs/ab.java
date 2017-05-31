package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.f.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements AbsListView.OnScrollListener {
    final /* synthetic */ r bVb;
    private int bVc = 0;
    private int bVd = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(r rVar) {
        this.bVb = rVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tbadk.util.s sVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        a aVar;
        com.baidu.tieba.frs.smartsort.c cVar;
        cb cbVar;
        cb cbVar2;
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.smartsort.c cVar2;
        a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.f.u uVar2;
        com.baidu.tbadk.util.s sVar2;
        sVar = this.bVb.aJf;
        if (sVar != null && this.bVb.isPrimary()) {
            sVar2 = this.bVb.aJf;
            sVar2.a(absListView, this.bVc, i, i2, i3);
        }
        dVar = this.bVb.bUm;
        if (dVar != null) {
            dVar2 = this.bVb.bUm;
            uVar2 = this.bVb.bUk;
            dVar2.a(absListView, i, i2, i3, uVar2.aeh());
        }
        aVar = this.bVb.bUv;
        if (aVar != null) {
            aVar2 = this.bVb.bUv;
            aVar2.adF();
        }
        cVar = this.bVb.bUp;
        if (cVar != null) {
            cVar2 = this.bVb.bUp;
            cVar2.adr();
        }
        cbVar = this.bVb.bUr;
        if (cbVar != null) {
            cbVar2 = this.bVb.bUr;
            uVar = this.bVb.bUk;
            cbVar2.a(absListView, i, i2, i3, uVar.aeh(), false);
        }
        if (this.bVb.bTF != null && this.bVb.bUa != null && this.bVb.bUa.aaR() != null) {
            this.bVc = i;
            this.bVd = (i + i2) - 1;
            this.bVb.bUa.aj(this.bVc, this.bVd);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tbadk.util.s sVar;
        cb cbVar;
        boolean z;
        cb cbVar2;
        com.baidu.tbadk.util.s sVar2;
        com.baidu.tieba.frs.f.u uVar2;
        uVar = this.bVb.bUk;
        if (uVar != null) {
            uVar2 = this.bVb.bUk;
            uVar2.setScrollState(i);
        }
        sVar = this.bVb.aJf;
        if (sVar != null && this.bVb.isPrimary()) {
            sVar2 = this.bVb.aJf;
            sVar2.onScrollStateChanged(absListView, i);
        }
        cbVar = this.bVb.bUr;
        if (cbVar != null) {
            cbVar2 = this.bVb.bUr;
            cbVar2.a(absListView, i, 0);
        }
        if (i == 2 || i == 1) {
            z = this.bVb.bUf;
            if (!z) {
                this.bVb.bUf = true;
                this.bVb.bUa.aaT();
            }
        }
        if (this.bVb.bUg == null && !this.bVb.aaw()) {
            this.bVb.bUg = new com.baidu.tbadk.j.e();
            this.bVb.bUg.fb(1000);
        }
        if (i == 0) {
            cf.Uw().dt(true);
            this.bVb.bUa.ai(this.bVc, this.bVd);
        }
        if (this.bVb.bUg != null) {
            this.bVb.bUg.Fl();
        }
        if (i == 0) {
            com.baidu.tieba.frs.e.o.a(this.bVb.bUa, this.bVb.bTF, this.bVb.getForumId(), false, null);
        }
    }
}
