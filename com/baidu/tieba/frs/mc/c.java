package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private final com.baidu.tieba.frs.j cHm;
    private final FrsModelController cHu;
    private final com.baidu.tieba.frs.g cOB;
    private final FrsLoadMoreModel cXO;
    private final FrsSmartLoadMoreModel cXP;

    public c(com.baidu.tieba.frs.g gVar, i iVar) {
        if (gVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cOB = gVar;
        this.cXO = new FrsLoadMoreModel(gVar, iVar);
        this.cXP = new FrsSmartLoadMoreModel(gVar, iVar);
        this.cHm = gVar.aln();
        this.cHu = gVar.ali();
        this.cXP.setSortType(this.cHu.Qt());
        this.cXO.setSortType(this.cHu.Qt());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cHu != null) {
            boolean aqe = this.cOB.ali().aqe();
            if (this.cHu.aqf()) {
                return this.cXP.a(z, aqe, arrayList, z3);
            }
            return this.cXO.a(z, aqe, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cHu != null) {
            if (this.cHu.aqf()) {
                this.cXP.resetData();
            } else {
                this.cXO.resetData();
            }
        }
    }

    public boolean bc(List<Long> list) {
        if (this.cHu == null || this.cHu.aqf()) {
            return false;
        }
        return this.cXO.bc(list);
    }

    public void a(String str, String str2, k kVar) {
        if (this.cHu != null && this.cHm != null && kVar != null) {
            if (this.cHu.aqf()) {
                if (this.cXP.alo() == 1 && !this.cHu.wA()) {
                    this.cXP.setSortType(this.cHu.Qt());
                    this.cHm.a(this.cXP.getDataList(), kVar);
                    int pn = this.cXP.getPn();
                    this.cXP.setPn(pn);
                    this.cHu.ks(pn + 1);
                }
            } else if (this.cHu.apV() == 1) {
                if (!this.cXO.isLoading && !this.cHu.wA()) {
                    int pn2 = this.cXO.getPn();
                    if (this.cXO.bc(kVar.bva())) {
                        this.cHm.a(this.cXO.aoA(), kVar);
                        this.cXO.setSortType(this.cHu.Qt());
                        this.cXO.a(com.baidu.adp.lib.g.b.c(str2, 0L), kVar.bva(), str, pn2);
                    } else if (this.cXO.alo() == 1) {
                        this.cHm.a(this.cXO.aoA(), kVar);
                        this.cXO.setPn(pn2);
                        this.cHu.ks(pn2 + 1);
                        this.cXO.loadingDone = false;
                        this.cXO.loadIndex = 0;
                    }
                }
            } else if (!this.cHu.apY()) {
                this.cHu.adq();
            }
        }
    }

    public int alo() {
        if (this.cHu == null) {
            return -1;
        }
        if (this.cHu.aqf()) {
            return this.cXP.alo();
        }
        return this.cXO.alo();
    }

    public void setHasMore(int i) {
        if (this.cHu != null) {
            if (this.cHu.aqf()) {
                this.cXP.setHasMore(i);
            } else {
                this.cXO.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cHu == null) {
            return 1;
        }
        if (this.cHu.aqf()) {
            return this.cXP.getPn();
        }
        return this.cXO.getPn();
    }

    public void setPn(int i) {
        if (this.cHu != null) {
            if (this.cHu.aqf()) {
                this.cXP.setPn(i);
            } else {
                this.cXO.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cHu.aqf() ? this.cXP.getDataList() : this.cHu.aqa();
    }

    public FrsSmartLoadMoreModel apP() {
        return this.cXP;
    }
}
