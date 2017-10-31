package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private final com.baidu.tieba.frs.f cEN;
    private final FrsLoadMoreModel cNQ;
    private final FrsSmartLoadMoreModel cNR;
    private final com.baidu.tieba.frs.i cxB;
    private final FrsModelController cxK;

    public c(com.baidu.tieba.frs.f fVar, i iVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cEN = fVar;
        this.cNQ = new FrsLoadMoreModel(fVar, iVar);
        this.cNR = new FrsSmartLoadMoreModel(fVar, iVar);
        this.cxB = fVar.aiW();
        this.cxK = fVar.aiR();
        this.cNR.setSortType(this.cxK.OY());
        this.cNQ.setSortType(this.cxK.OY());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cxK != null) {
            boolean anM = this.cEN.aiR().anM();
            if (this.cxK.anN()) {
                return this.cNR.a(z, anM, arrayList, z3);
            }
            return this.cNQ.a(z, anM, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cxK != null) {
            if (this.cxK.anN()) {
                this.cNR.resetData();
            } else {
                this.cNQ.resetData();
            }
        }
    }

    public boolean aQ(List<Long> list) {
        if (this.cxK == null || this.cxK.anN()) {
            return false;
        }
        return this.cNQ.aQ(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.j jVar) {
        if (this.cxK != null && this.cxB != null && jVar != null) {
            if (this.cxK.anN()) {
                if (this.cNR.aiX() == 1 && !this.cxK.wz()) {
                    this.cNR.setSortType(this.cxK.OY());
                    this.cxB.a(this.cNR.getDataList(), jVar);
                    int pn = this.cNR.getPn();
                    this.cNR.setPn(pn);
                    this.cxK.jT(pn + 1);
                }
            } else if (this.cxK.anD() == 1) {
                if (!this.cNQ.isLoading && !this.cxK.wz()) {
                    int pn2 = this.cNQ.getPn();
                    if (this.cNQ.aQ(jVar.bsB())) {
                        this.cxB.a(this.cNQ.amh(), jVar);
                        this.cNQ.setSortType(this.cxK.OY());
                        this.cNQ.a(com.baidu.adp.lib.g.b.c(str2, 0L), jVar.bsB(), str, pn2);
                    } else if (this.cNQ.aiX() == 1) {
                        this.cxB.a(this.cNQ.amh(), jVar);
                        this.cNQ.setPn(pn2);
                        this.cxK.jT(pn2 + 1);
                        this.cNQ.loadingDone = false;
                        this.cNQ.loadIndex = 0;
                    }
                }
            } else if (!this.cxK.anG()) {
                this.cxK.abm();
            }
        }
    }

    public int aiX() {
        if (this.cxK == null) {
            return -1;
        }
        if (this.cxK.anN()) {
            return this.cNR.aiX();
        }
        return this.cNQ.aiX();
    }

    public void setHasMore(int i) {
        if (this.cxK != null) {
            if (this.cxK.anN()) {
                this.cNR.setHasMore(i);
            } else {
                this.cNQ.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cxK == null) {
            return 1;
        }
        if (this.cxK.anN()) {
            return this.cNR.getPn();
        }
        return this.cNQ.getPn();
    }

    public void setPn(int i) {
        if (this.cxK != null) {
            if (this.cxK.anN()) {
                this.cNR.setPn(i);
            } else {
                this.cNQ.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cxK.anN() ? this.cNR.getDataList() : this.cxK.anI();
    }

    public FrsSmartLoadMoreModel anx() {
        return this.cNR;
    }
}
