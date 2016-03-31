package com.baidu.tieba.frs;

import android.widget.AbsListView;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class k implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.data.f fVar;
        com.baidu.tieba.tbadkCore.data.f fVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        com.baidu.tieba.tbadkCore.o oVar5;
        com.baidu.tieba.tbadkCore.data.f fVar3;
        boolean z;
        com.baidu.tieba.tbadkCore.data.f fVar4;
        boolean z2;
        aVar = this.blk.bkD;
        aVar.onScroll(absListView, i, i2, i3);
        oVar = this.blk.bkq;
        if (oVar != null && this.blk.bko != null && this.blk.bko.Sb() != null) {
            oVar2 = this.blk.bkq;
            int aSh = oVar2.aSh();
            int Rl = ((i + i2) - this.blk.bko.Sb().Rl()) - aSh;
            int i4 = (Rl - 1) + aSh;
            fVar = this.blk.bkl;
            if (fVar != null) {
                fVar2 = this.blk.bkl;
                int po = fVar2.po(Rl);
                if (po >= 0 && i4 >= 0) {
                    oVar3 = this.blk.bkq;
                    if (i4 < oVar3.getThreadList().size()) {
                        oVar4 = this.blk.bkq;
                        com.baidu.adp.widget.ListView.u uVar = oVar4.getThreadList().get(i4);
                        if (uVar instanceof com.baidu.tbadk.core.data.c) {
                            fVar4 = this.blk.bkl;
                            fVar4.c(Rl, 1, this.blk.forumId, po);
                            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a((com.baidu.tbadk.core.data.c) uVar, "show", this.blk.mPn);
                            z2 = this.blk.bkk;
                            a.bz("isCache", String.valueOf(z2));
                            com.baidu.tieba.recapp.report.b.aLC().a(a);
                            return;
                        }
                        oVar5 = this.blk.bkq;
                        ForumData avu = oVar5.avu();
                        fVar3 = this.blk.bkl;
                        fVar3.c(Rl, 2, this.blk.forumId, po);
                        com.baidu.tieba.recapp.report.a h = com.baidu.tieba.recapp.report.e.h("store", po, this.blk.mPn);
                        h.bz("page", "FRS");
                        z = this.blk.bkk;
                        h.bz("isCache", String.valueOf(z));
                        if (avu != null) {
                            h.bz("fid", avu.getId());
                            h.bz("fc1", avu.getFirst_class());
                            h.bz("fc2", avu.getSecond_class());
                        }
                        com.baidu.tieba.recapp.report.b.aLC().a(h);
                    }
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.c.a aVar;
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        com.baidu.tieba.frs.c.a aVar2;
        aVar = this.blk.bkD;
        if (aVar != null) {
            aVar2 = this.blk.bkD;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.blk.bkx;
            if (!z) {
                this.blk.bkx = true;
                this.blk.bko.Sf();
            }
        }
        if (this.blk.bky == null) {
            this.blk.bky = new com.baidu.tbadk.performanceLog.e();
            this.blk.bky.fh(1000);
        }
        if (i == 0) {
            cs csVar = this.blk.bko;
            wVar = this.blk.blg;
            csVar.a(wVar);
            this.blk.bko.cH(false);
            this.blk.Km = false;
        } else {
            this.blk.bko.a((com.baidu.adp.widget.ListView.w) null);
            this.blk.bko.cH(true);
            this.blk.Km = true;
        }
        this.blk.bky.GB();
    }
}
