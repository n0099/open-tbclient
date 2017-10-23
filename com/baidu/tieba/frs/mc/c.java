package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private final FrsLoadMoreModel cED;
    private final FrsSmartLoadMoreModel cEE;
    private final com.baidu.tieba.frs.i cqh;
    private final FrsModelController cqq;
    private final com.baidu.tieba.frs.f cwW;

    public c(com.baidu.tieba.frs.f fVar, i iVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cwW = fVar;
        this.cED = new FrsLoadMoreModel(fVar, iVar);
        this.cEE = new FrsSmartLoadMoreModel(fVar, iVar);
        this.cqh = fVar.agP();
        this.cqq = fVar.agK();
        this.cEE.setSortType(this.cqq.OT());
        this.cED.setSortType(this.cqq.OT());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cqq != null) {
            boolean alb = this.cwW.agK().alb();
            if (this.cqq.alc()) {
                return this.cEE.a(z, alb, arrayList, z3);
            }
            return this.cED.a(z, alb, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cqq != null) {
            if (this.cqq.alc()) {
                this.cEE.resetData();
            } else {
                this.cED.resetData();
            }
        }
    }

    public boolean aO(List<Long> list) {
        if (this.cqq == null || this.cqq.alc()) {
            return false;
        }
        return this.cED.aO(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.i iVar) {
        if (this.cqq != null && this.cqh != null && iVar != null) {
            if (this.cqq.alc()) {
                if (this.cEE.agQ() == 1 && !this.cqq.ws()) {
                    this.cEE.setSortType(this.cqq.OT());
                    this.cqh.a(this.cEE.getDataList(), iVar);
                    int pn = this.cEE.getPn();
                    this.cEE.setPn(pn);
                    this.cqq.jB(pn + 1);
                }
            } else if (this.cqq.akS() == 1) {
                if (!this.cED.isLoading && !this.cqq.ws()) {
                    int pn2 = this.cED.getPn();
                    if (this.cED.aO(iVar.bpx())) {
                        this.cqh.a(this.cED.ajU(), iVar);
                        this.cED.setSortType(this.cqq.OT());
                        this.cED.a(com.baidu.adp.lib.g.b.c(str2, 0L), iVar.bpx(), str, pn2);
                    } else if (this.cED.agQ() == 1) {
                        this.cqh.a(this.cED.ajU(), iVar);
                        this.cED.setPn(pn2);
                        this.cqq.jB(pn2 + 1);
                        this.cED.loadingDone = false;
                        this.cED.loadIndex = 0;
                    }
                }
            } else if (!this.cqq.akV()) {
                this.cqq.Zc();
            }
        }
    }

    public int agQ() {
        if (this.cqq == null) {
            return -1;
        }
        if (this.cqq.alc()) {
            return this.cEE.agQ();
        }
        return this.cED.agQ();
    }

    public void setHasMore(int i) {
        if (this.cqq != null) {
            if (this.cqq.alc()) {
                this.cEE.setHasMore(i);
            } else {
                this.cED.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cqq == null) {
            return 1;
        }
        if (this.cqq.alc()) {
            return this.cEE.getPn();
        }
        return this.cED.getPn();
    }

    public void setPn(int i) {
        if (this.cqq != null) {
            if (this.cqq.alc()) {
                this.cEE.setPn(i);
            } else {
                this.cED.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cqq.alc() ? this.cEE.getDataList() : this.cqq.akX();
    }

    public FrsSmartLoadMoreModel akM() {
        return this.cEE;
    }
}
