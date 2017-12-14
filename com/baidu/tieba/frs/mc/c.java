package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private final com.baidu.tieba.frs.j cHi;
    private final FrsModelController cHq;
    private final com.baidu.tieba.frs.g cOx;
    private final FrsLoadMoreModel cXK;
    private final FrsSmartLoadMoreModel cXL;

    public c(com.baidu.tieba.frs.g gVar, i iVar) {
        if (gVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cOx = gVar;
        this.cXK = new FrsLoadMoreModel(gVar, iVar);
        this.cXL = new FrsSmartLoadMoreModel(gVar, iVar);
        this.cHi = gVar.alo();
        this.cHq = gVar.alj();
        this.cXL.setSortType(this.cHq.Qt());
        this.cXK.setSortType(this.cHq.Qt());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cHq != null) {
            boolean aqe = this.cOx.alj().aqe();
            if (this.cHq.aqf()) {
                return this.cXL.a(z, aqe, arrayList, z3);
            }
            return this.cXK.a(z, aqe, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cHq != null) {
            if (this.cHq.aqf()) {
                this.cXL.resetData();
            } else {
                this.cXK.resetData();
            }
        }
    }

    public boolean bc(List<Long> list) {
        if (this.cHq == null || this.cHq.aqf()) {
            return false;
        }
        return this.cXK.bc(list);
    }

    public void a(String str, String str2, k kVar) {
        if (this.cHq != null && this.cHi != null && kVar != null) {
            if (this.cHq.aqf()) {
                if (this.cXL.alp() == 1 && !this.cHq.wA()) {
                    this.cXL.setSortType(this.cHq.Qt());
                    this.cHi.a(this.cXL.getDataList(), kVar);
                    int pn = this.cXL.getPn();
                    this.cXL.setPn(pn);
                    this.cHq.ks(pn + 1);
                }
            } else if (this.cHq.apV() == 1) {
                if (!this.cXK.isLoading && !this.cHq.wA()) {
                    int pn2 = this.cXK.getPn();
                    if (this.cXK.bc(kVar.bva())) {
                        this.cHi.a(this.cXK.aoA(), kVar);
                        this.cXK.setSortType(this.cHq.Qt());
                        this.cXK.a(com.baidu.adp.lib.g.b.c(str2, 0L), kVar.bva(), str, pn2);
                    } else if (this.cXK.alp() == 1) {
                        this.cHi.a(this.cXK.aoA(), kVar);
                        this.cXK.setPn(pn2);
                        this.cHq.ks(pn2 + 1);
                        this.cXK.loadingDone = false;
                        this.cXK.loadIndex = 0;
                    }
                }
            } else if (!this.cHq.apY()) {
                this.cHq.adr();
            }
        }
    }

    public int alp() {
        if (this.cHq == null) {
            return -1;
        }
        if (this.cHq.aqf()) {
            return this.cXL.alp();
        }
        return this.cXK.alp();
    }

    public void setHasMore(int i) {
        if (this.cHq != null) {
            if (this.cHq.aqf()) {
                this.cXL.setHasMore(i);
            } else {
                this.cXK.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cHq == null) {
            return 1;
        }
        if (this.cHq.aqf()) {
            return this.cXL.getPn();
        }
        return this.cXK.getPn();
    }

    public void setPn(int i) {
        if (this.cHq != null) {
            if (this.cHq.aqf()) {
                this.cXL.setPn(i);
            } else {
                this.cXK.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cHq.aqf() ? this.cXL.getDataList() : this.cHq.aqa();
    }

    public FrsSmartLoadMoreModel apP() {
        return this.cXL;
    }
}
