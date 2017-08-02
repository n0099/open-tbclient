package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private final com.baidu.tieba.frs.i chQ;
    private final FrsModelController chZ;
    private final com.baidu.tieba.frs.f cna;
    private final FrsLoadMoreModel ctg;
    private final FrsSmartLoadMoreModel cth;

    public d(com.baidu.tieba.frs.f fVar, j jVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cna = fVar;
        this.ctg = new FrsLoadMoreModel(fVar, jVar);
        this.cth = new FrsSmartLoadMoreModel(fVar, jVar);
        this.chQ = fVar.aeU();
        this.chZ = fVar.aeP();
        this.cth.setSortType(this.chZ.Oh());
        this.ctg.setSortType(this.chZ.Oh());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.chZ != null) {
            boolean aiv = this.cna.aeP().aiv();
            if (this.chZ.aiw()) {
                return this.cth.a(z, aiv, arrayList);
            }
            return this.ctg.a(z, aiv, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.chZ != null) {
            if (this.chZ.aiw()) {
                this.cth.resetData();
            } else {
                this.ctg.resetData();
            }
        }
    }

    public boolean aK(List<Long> list) {
        if (this.chZ == null || this.chZ.aiw()) {
            return false;
        }
        return this.ctg.aK(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.i iVar) {
        if (this.chZ != null && this.chQ != null && iVar != null) {
            if (this.chZ.aiw()) {
                if (this.cth.aeV() == 1 && !this.chZ.wT()) {
                    this.cth.setSortType(this.chZ.Oh());
                    this.chQ.a(this.cth.getDataList(), iVar);
                    int pn = this.cth.getPn();
                    this.cth.setPn(pn);
                    this.chZ.jc(pn + 1);
                }
            } else if (this.chZ.aim() == 1) {
                if (!this.ctg.isLoading && !this.chZ.wT()) {
                    int pn2 = this.ctg.getPn();
                    if (this.ctg.aK(iVar.bqA())) {
                        this.chQ.a(this.ctg.ahC(), iVar);
                        this.ctg.setSortType(this.chZ.Oh());
                        this.ctg.a(com.baidu.adp.lib.g.b.c(str2, 0L), iVar.bqA(), str, pn2);
                    } else if (this.ctg.aeV() == 1) {
                        this.chQ.a(this.ctg.ahC(), iVar);
                        this.ctg.setPn(pn2);
                        this.chZ.jc(pn2 + 1);
                        this.ctg.loadingDone = false;
                        this.ctg.loadIndex = 0;
                    }
                }
            } else if (!this.chZ.aip()) {
                this.chZ.XK();
            }
        }
    }

    public int aeV() {
        if (this.chZ == null) {
            return -1;
        }
        if (this.chZ.aiw()) {
            return this.cth.aeV();
        }
        return this.ctg.aeV();
    }

    public void setHasMore(int i) {
        if (this.chZ != null) {
            if (this.chZ.aiw()) {
                this.cth.setHasMore(i);
            } else {
                this.ctg.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.chZ == null) {
            return 1;
        }
        if (this.chZ.aiw()) {
            return this.cth.getPn();
        }
        return this.ctg.getPn();
    }

    public void setPn(int i) {
        if (this.chZ != null) {
            if (this.chZ.aiw()) {
                this.cth.setPn(i);
            } else {
                this.ctg.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.chZ.aiw() ? this.cth.getDataList() : this.chZ.air();
    }

    public FrsSmartLoadMoreModel aig() {
        return this.cth;
    }
}
