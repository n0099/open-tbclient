package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tbadk.performanceLog.e;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity bzl;
    private int aMh = 0;
    private int aMg = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.frs.h.a aVar;
        com.baidu.tieba.frs.h.an anVar;
        int i4;
        com.baidu.tieba.frs.f.d dVar2;
        cg cgVar;
        cg cgVar2;
        com.baidu.tieba.frs.h.s sVar;
        com.baidu.tieba.frs.f.d dVar3;
        com.baidu.tieba.frs.h.an anVar2;
        com.baidu.tieba.frs.h.an anVar3;
        com.baidu.tieba.frs.h.a aVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar4;
        com.baidu.tieba.frs.h.s sVar2;
        dVar = this.bzl.byw;
        if (dVar != null) {
            dVar4 = this.bzl.byw;
            sVar2 = this.bzl.bys;
            dVar4.a(absListView, i, i2, i3, sVar2.acb());
        }
        aVar = this.bzl.byG;
        if (aVar != null) {
            aVar2 = this.bzl.byG;
            aVar2.abw();
        }
        anVar = this.bzl.byJ;
        if (anVar != null) {
            anVar2 = this.bzl.byJ;
            anVar2.a(absListView, i);
            anVar3 = this.bzl.byJ;
            i4 = anVar3.ace();
        } else {
            i4 = 0;
        }
        dVar2 = this.bzl.byz;
        if (dVar2 != null) {
            dVar3 = this.bzl.byz;
            dVar3.abl();
        }
        cgVar = this.bzl.byC;
        if (cgVar != null) {
            cgVar2 = this.bzl.byC;
            sVar = this.bzl.bys;
            cgVar2.a(absListView, i + i4, i2, i3, sVar.acb() - i4, this.bzl.Wv());
        }
        if (this.bzl.byh != null && this.bzl.byg != null && this.bzl.byg.Xu() != null) {
            this.aMh = i;
            this.aMg = (i + i2) - 1;
            this.bzl.byg.ad(this.aMh, this.aMg);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.h.s sVar;
        com.baidu.tieba.frs.h.an anVar;
        int i2;
        cg cgVar;
        boolean z;
        com.baidu.adp.widget.ListView.x xVar;
        cg cgVar2;
        com.baidu.tieba.frs.h.an anVar2;
        com.baidu.tieba.frs.h.an anVar3;
        com.baidu.tieba.frs.h.s sVar2;
        sVar = this.bzl.bys;
        if (sVar != null) {
            sVar2 = this.bzl.bys;
            sVar2.setScrollState(i);
        }
        anVar = this.bzl.byJ;
        if (anVar != null) {
            anVar2 = this.bzl.byJ;
            anVar2.onScrollStateChanged(absListView, i);
            anVar3 = this.bzl.byJ;
            i2 = anVar3.ace();
        } else {
            i2 = 0;
        }
        cgVar = this.bzl.byC;
        if (cgVar != null) {
            cgVar2 = this.bzl.byC;
            cgVar2.a(absListView, i, i2);
        }
        if (i == 2 || i == 1) {
            z = this.bzl.byn;
            if (!z) {
                this.bzl.byn = true;
                this.bzl.byg.Xx();
            }
        }
        if (this.bzl.byo == null) {
            this.bzl.byo = new e();
            this.bzl.byo.fg(1000);
        }
        if (i != 0) {
            this.bzl.byg.a((com.baidu.adp.widget.ListView.x) null);
        } else {
            com.baidu.tieba.card.bz.OH().cz(true);
            ax axVar = this.bzl.byg;
            xVar = this.bzl.bzj;
            axVar.a(xVar);
            this.bzl.byg.ac(this.aMh, this.aMg);
        }
        this.bzl.byo.FB();
        if (i == 0) {
            com.baidu.tieba.frs.utils.s.a(this.bzl.byg, this.bzl.byh, this.bzl.getForumId(), false, null);
        }
    }
}
