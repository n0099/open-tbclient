package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private final FrsLoadMoreModel cDe;
    private final FrsSmartLoadMoreModel cDf;
    private final com.baidu.tieba.frs.i cpe;
    private final FrsModelController cpn;
    private final com.baidu.tieba.frs.f cvA;

    public d(com.baidu.tieba.frs.f fVar, j jVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cvA = fVar;
        this.cDe = new FrsLoadMoreModel(fVar, jVar);
        this.cDf = new FrsSmartLoadMoreModel(fVar, jVar);
        this.cpe = fVar.agN();
        this.cpn = fVar.agI();
        this.cDf.setSortType(this.cpn.OC());
        this.cDe.setSortType(this.cpn.OC());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cpn != null) {
            boolean akR = this.cvA.agI().akR();
            if (this.cpn.akS()) {
                return this.cDf.a(z, akR, arrayList, z3);
            }
            return this.cDe.a(z, akR, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cpn != null) {
            if (this.cpn.akS()) {
                this.cDf.resetData();
            } else {
                this.cDe.resetData();
            }
        }
    }

    public boolean aO(List<Long> list) {
        if (this.cpn == null || this.cpn.akS()) {
            return false;
        }
        return this.cDe.aO(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.i iVar) {
        if (this.cpn != null && this.cpe != null && iVar != null) {
            if (this.cpn.akS()) {
                if (this.cDf.agO() == 1 && !this.cpn.xa()) {
                    this.cDf.setSortType(this.cpn.OC());
                    this.cpe.a(this.cDf.getDataList(), iVar);
                    int pn = this.cDf.getPn();
                    this.cDf.setPn(pn);
                    this.cpn.js(pn + 1);
                }
            } else if (this.cpn.akI() == 1) {
                if (!this.cDe.isLoading && !this.cpn.xa()) {
                    int pn2 = this.cDe.getPn();
                    if (this.cDe.aO(iVar.bqx())) {
                        this.cpe.a(this.cDe.ajK(), iVar);
                        this.cDe.setSortType(this.cpn.OC());
                        this.cDe.a(com.baidu.adp.lib.g.b.c(str2, 0L), iVar.bqx(), str, pn2);
                    } else if (this.cDe.agO() == 1) {
                        this.cpe.a(this.cDe.ajK(), iVar);
                        this.cDe.setPn(pn2);
                        this.cpn.js(pn2 + 1);
                        this.cDe.loadingDone = false;
                        this.cDe.loadIndex = 0;
                    }
                }
            } else if (!this.cpn.akL()) {
                this.cpn.Zk();
            }
        }
    }

    public int agO() {
        if (this.cpn == null) {
            return -1;
        }
        if (this.cpn.akS()) {
            return this.cDf.agO();
        }
        return this.cDe.agO();
    }

    public void setHasMore(int i) {
        if (this.cpn != null) {
            if (this.cpn.akS()) {
                this.cDf.setHasMore(i);
            } else {
                this.cDe.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cpn == null) {
            return 1;
        }
        if (this.cpn.akS()) {
            return this.cDf.getPn();
        }
        return this.cDe.getPn();
    }

    public void setPn(int i) {
        if (this.cpn != null) {
            if (this.cpn.akS()) {
                this.cDf.setPn(i);
            } else {
                this.cDe.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cpn.akS() ? this.cDf.getDataList() : this.cpn.akN();
    }

    public FrsSmartLoadMoreModel akC() {
        return this.cDf;
    }
}
