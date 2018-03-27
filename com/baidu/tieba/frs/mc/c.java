package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final k dEo;
    private final FrsModelController dEw;
    private final com.baidu.tieba.frs.i dSO;
    private final FrsLoadMoreModel dSP;
    private final FrsSmartLoadMoreModel dSQ;

    public c(com.baidu.tieba.frs.i iVar, i iVar2) {
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dSO = iVar;
        this.dSP = new FrsLoadMoreModel(iVar, iVar2);
        this.dSQ = new FrsSmartLoadMoreModel(iVar, iVar2);
        this.dEo = iVar.auT();
        this.dEw = iVar.auO();
        this.dSQ.setSortType(this.dEw.YM());
        this.dSP.setSortType(this.dEw.YM());
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.dEw != null) {
            boolean azB = this.dSO.auO().azB();
            if (this.dEw.azC()) {
                return this.dSQ.a(z, azB, arrayList, z3);
            }
            return this.dSP.a(z, azB, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dEw != null) {
            if (this.dEw.azC()) {
                this.dSQ.resetData();
            } else {
                this.dSP.resetData();
            }
        }
    }

    public boolean bv(List<Long> list) {
        if (this.dEw == null || this.dEw.azC()) {
            return false;
        }
        return this.dSP.bv(list);
    }

    public void a(String str, String str2, m mVar) {
        if (this.dEw != null && this.dEo != null && mVar != null) {
            if (this.dEw.azC()) {
                if (this.dSQ.auU() == 1 && !this.dEw.El()) {
                    this.dSQ.setSortType(this.dEw.YM());
                    this.dEo.a(this.dSQ.getDataList(), mVar);
                    int pn = this.dSQ.getPn();
                    this.dSQ.setPn(pn);
                    this.dEw.nD(pn + 1);
                }
            } else if (this.dEw.azs() == 1) {
                if (!this.dSP.isLoading && !this.dEw.El()) {
                    int pn2 = this.dSP.getPn();
                    if (this.dSP.bv(mVar.bvb())) {
                        this.dEo.a(this.dSP.azj(), mVar);
                        this.dSP.setSortType(this.dEw.YM());
                        this.dSP.a(com.baidu.adp.lib.g.b.c(str2, 0L), mVar.bvb(), str, pn2);
                    } else if (this.dSP.auU() == 1) {
                        this.dEo.a(this.dSP.azj(), mVar);
                        this.dSP.setPn(pn2);
                        this.dEw.nD(pn2 + 1);
                        this.dSP.loadingDone = false;
                        this.dSP.loadIndex = 0;
                    }
                }
            } else if (!this.dEw.azv()) {
                this.dEw.amN();
            }
        }
    }

    public int auU() {
        if (this.dEw == null) {
            return -1;
        }
        if (this.dEw.azC()) {
            return this.dSQ.auU();
        }
        return this.dSP.auU();
    }

    public void setHasMore(int i) {
        if (this.dEw != null) {
            if (this.dEw.azC()) {
                this.dSQ.setHasMore(i);
            } else {
                this.dSP.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dEw == null) {
            return 1;
        }
        if (this.dEw.azC()) {
            return this.dSQ.getPn();
        }
        return this.dSP.getPn();
    }

    public void setPn(int i) {
        if (this.dEw != null) {
            if (this.dEw.azC()) {
                this.dSQ.setPn(i);
            } else {
                this.dSP.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getDataList() {
        return this.dEw.azC() ? this.dSQ.getDataList() : this.dEw.azx();
    }

    public FrsSmartLoadMoreModel azm() {
        return this.dSQ;
    }
}
