package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private final com.baidu.tieba.frs.i cHa;
    private final FrsModelController cHi;
    private final com.baidu.tieba.frs.f cOm;
    private final FrsSmartLoadMoreModel cXA;
    private final FrsLoadMoreModel cXz;

    public c(com.baidu.tieba.frs.f fVar, i iVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cOm = fVar;
        this.cXz = new FrsLoadMoreModel(fVar, iVar);
        this.cXA = new FrsSmartLoadMoreModel(fVar, iVar);
        this.cHa = fVar.ale();
        this.cHi = fVar.akZ();
        this.cXA.setSortType(this.cHi.Qt());
        this.cXz.setSortType(this.cHi.Qt());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cHi != null) {
            boolean apV = this.cOm.akZ().apV();
            if (this.cHi.apW()) {
                return this.cXA.a(z, apV, arrayList, z3);
            }
            return this.cXz.a(z, apV, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cHi != null) {
            if (this.cHi.apW()) {
                this.cXA.resetData();
            } else {
                this.cXz.resetData();
            }
        }
    }

    public boolean bc(List<Long> list) {
        if (this.cHi == null || this.cHi.apW()) {
            return false;
        }
        return this.cXz.bc(list);
    }

    public void a(String str, String str2, k kVar) {
        if (this.cHi != null && this.cHa != null && kVar != null) {
            if (this.cHi.apW()) {
                if (this.cXA.alf() == 1 && !this.cHi.wC()) {
                    this.cXA.setSortType(this.cHi.Qt());
                    this.cHa.a(this.cXA.getDataList(), kVar);
                    int pn = this.cXA.getPn();
                    this.cXA.setPn(pn);
                    this.cHi.kq(pn + 1);
                }
            } else if (this.cHi.apM() == 1) {
                if (!this.cXz.isLoading && !this.cHi.wC()) {
                    int pn2 = this.cXz.getPn();
                    if (this.cXz.bc(kVar.but())) {
                        this.cHa.a(this.cXz.aor(), kVar);
                        this.cXz.setSortType(this.cHi.Qt());
                        this.cXz.a(com.baidu.adp.lib.g.b.c(str2, 0L), kVar.but(), str, pn2);
                    } else if (this.cXz.alf() == 1) {
                        this.cHa.a(this.cXz.aor(), kVar);
                        this.cXz.setPn(pn2);
                        this.cHi.kq(pn2 + 1);
                        this.cXz.loadingDone = false;
                        this.cXz.loadIndex = 0;
                    }
                }
            } else if (!this.cHi.apP()) {
                this.cHi.adh();
            }
        }
    }

    public int alf() {
        if (this.cHi == null) {
            return -1;
        }
        if (this.cHi.apW()) {
            return this.cXA.alf();
        }
        return this.cXz.alf();
    }

    public void setHasMore(int i) {
        if (this.cHi != null) {
            if (this.cHi.apW()) {
                this.cXA.setHasMore(i);
            } else {
                this.cXz.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cHi == null) {
            return 1;
        }
        if (this.cHi.apW()) {
            return this.cXA.getPn();
        }
        return this.cXz.getPn();
    }

    public void setPn(int i) {
        if (this.cHi != null) {
            if (this.cHi.apW()) {
                this.cXA.setPn(i);
            } else {
                this.cXz.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cHi.apW() ? this.cXA.getDataList() : this.cHi.apR();
    }

    public FrsSmartLoadMoreModel apG() {
        return this.cXA;
    }
}
