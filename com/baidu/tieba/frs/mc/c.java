package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private final FrsLoadMoreModel cEP;
    private final FrsSmartLoadMoreModel cEQ;
    private final FrsModelController cqC;
    private final com.baidu.tieba.frs.i cqt;
    private final com.baidu.tieba.frs.f cxi;

    public c(com.baidu.tieba.frs.f fVar, i iVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cxi = fVar;
        this.cEP = new FrsLoadMoreModel(fVar, iVar);
        this.cEQ = new FrsSmartLoadMoreModel(fVar, iVar);
        this.cqt = fVar.agU();
        this.cqC = fVar.agP();
        this.cEQ.setSortType(this.cqC.OZ());
        this.cEP.setSortType(this.cqC.OZ());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cqC != null) {
            boolean alg = this.cxi.agP().alg();
            if (this.cqC.alh()) {
                return this.cEQ.a(z, alg, arrayList, z3);
            }
            return this.cEP.a(z, alg, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cqC != null) {
            if (this.cqC.alh()) {
                this.cEQ.resetData();
            } else {
                this.cEP.resetData();
            }
        }
    }

    public boolean aO(List<Long> list) {
        if (this.cqC == null || this.cqC.alh()) {
            return false;
        }
        return this.cEP.aO(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.i iVar) {
        if (this.cqC != null && this.cqt != null && iVar != null) {
            if (this.cqC.alh()) {
                if (this.cEQ.agV() == 1 && !this.cqC.wz()) {
                    this.cEQ.setSortType(this.cqC.OZ());
                    this.cqt.a(this.cEQ.getDataList(), iVar);
                    int pn = this.cEQ.getPn();
                    this.cEQ.setPn(pn);
                    this.cqC.jC(pn + 1);
                }
            } else if (this.cqC.akX() == 1) {
                if (!this.cEP.isLoading && !this.cqC.wz()) {
                    int pn2 = this.cEP.getPn();
                    if (this.cEP.aO(iVar.bpF())) {
                        this.cqt.a(this.cEP.ajZ(), iVar);
                        this.cEP.setSortType(this.cqC.OZ());
                        this.cEP.a(com.baidu.adp.lib.g.b.c(str2, 0L), iVar.bpF(), str, pn2);
                    } else if (this.cEP.agV() == 1) {
                        this.cqt.a(this.cEP.ajZ(), iVar);
                        this.cEP.setPn(pn2);
                        this.cqC.jC(pn2 + 1);
                        this.cEP.loadingDone = false;
                        this.cEP.loadIndex = 0;
                    }
                }
            } else if (!this.cqC.ala()) {
                this.cqC.Zg();
            }
        }
    }

    public int agV() {
        if (this.cqC == null) {
            return -1;
        }
        if (this.cqC.alh()) {
            return this.cEQ.agV();
        }
        return this.cEP.agV();
    }

    public void setHasMore(int i) {
        if (this.cqC != null) {
            if (this.cqC.alh()) {
                this.cEQ.setHasMore(i);
            } else {
                this.cEP.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cqC == null) {
            return 1;
        }
        if (this.cqC.alh()) {
            return this.cEQ.getPn();
        }
        return this.cEP.getPn();
    }

    public void setPn(int i) {
        if (this.cqC != null) {
            if (this.cqC.alh()) {
                this.cEQ.setPn(i);
            } else {
                this.cEP.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cqC.alh() ? this.cEQ.getDataList() : this.cqC.alc();
    }

    public FrsSmartLoadMoreModel akR() {
        return this.cEQ;
    }
}
