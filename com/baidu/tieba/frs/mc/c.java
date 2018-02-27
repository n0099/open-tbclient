package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final k dEl;
    private final FrsModelController dEt;
    private final com.baidu.tieba.frs.i dSJ;
    private final FrsLoadMoreModel dSK;
    private final FrsSmartLoadMoreModel dSL;

    public c(com.baidu.tieba.frs.i iVar, i iVar2) {
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dSJ = iVar;
        this.dSK = new FrsLoadMoreModel(iVar, iVar2);
        this.dSL = new FrsSmartLoadMoreModel(iVar, iVar2);
        this.dEl = iVar.auS();
        this.dEt = iVar.auN();
        this.dSL.setSortType(this.dEt.YL());
        this.dSK.setSortType(this.dEt.YL());
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.dEt != null) {
            boolean azz = this.dSJ.auN().azz();
            if (this.dEt.azA()) {
                return this.dSL.a(z, azz, arrayList, z3);
            }
            return this.dSK.a(z, azz, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dEt != null) {
            if (this.dEt.azA()) {
                this.dSL.resetData();
            } else {
                this.dSK.resetData();
            }
        }
    }

    public boolean bv(List<Long> list) {
        if (this.dEt == null || this.dEt.azA()) {
            return false;
        }
        return this.dSK.bv(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dEt != null && this.dEl != null && lVar != null) {
            if (this.dEt.azA()) {
                if (this.dSL.auT() == 1 && !this.dEt.Ek()) {
                    this.dSL.setSortType(this.dEt.YL());
                    this.dEl.a(this.dSL.getDataList(), lVar);
                    int pn = this.dSL.getPn();
                    this.dSL.setPn(pn);
                    this.dEt.nD(pn + 1);
                }
            } else if (this.dEt.azq() == 1) {
                if (!this.dSK.isLoading && !this.dEt.Ek()) {
                    int pn2 = this.dSK.getPn();
                    if (this.dSK.bv(lVar.buY())) {
                        this.dEl.a(this.dSK.azh(), lVar);
                        this.dSK.setSortType(this.dEt.YL());
                        this.dSK.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.buY(), str, pn2);
                    } else if (this.dSK.auT() == 1) {
                        this.dEl.a(this.dSK.azh(), lVar);
                        this.dSK.setPn(pn2);
                        this.dEt.nD(pn2 + 1);
                        this.dSK.loadingDone = false;
                        this.dSK.loadIndex = 0;
                    }
                }
            } else if (!this.dEt.azt()) {
                this.dEt.amM();
            }
        }
    }

    public int auT() {
        if (this.dEt == null) {
            return -1;
        }
        if (this.dEt.azA()) {
            return this.dSL.auT();
        }
        return this.dSK.auT();
    }

    public void setHasMore(int i) {
        if (this.dEt != null) {
            if (this.dEt.azA()) {
                this.dSL.setHasMore(i);
            } else {
                this.dSK.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dEt == null) {
            return 1;
        }
        if (this.dEt.azA()) {
            return this.dSL.getPn();
        }
        return this.dSK.getPn();
    }

    public void setPn(int i) {
        if (this.dEt != null) {
            if (this.dEt.azA()) {
                this.dSL.setPn(i);
            } else {
                this.dSK.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getDataList() {
        return this.dEt.azA() ? this.dSL.getDataList() : this.dEt.azv();
    }

    public FrsSmartLoadMoreModel azk() {
        return this.dSL;
    }
}
