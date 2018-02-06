package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final FrsModelController dEF;
    private final k dEx;
    private final com.baidu.tieba.frs.i dSV;
    private final FrsLoadMoreModel dSW;
    private final FrsSmartLoadMoreModel dSX;

    public c(com.baidu.tieba.frs.i iVar, i iVar2) {
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dSV = iVar;
        this.dSW = new FrsLoadMoreModel(iVar, iVar2);
        this.dSX = new FrsSmartLoadMoreModel(iVar, iVar2);
        this.dEx = iVar.auT();
        this.dEF = iVar.auO();
        this.dSX.setSortType(this.dEF.YM());
        this.dSW.setSortType(this.dEF.YM());
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.dEF != null) {
            boolean azA = this.dSV.auO().azA();
            if (this.dEF.azB()) {
                return this.dSX.a(z, azA, arrayList, z3);
            }
            return this.dSW.a(z, azA, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dEF != null) {
            if (this.dEF.azB()) {
                this.dSX.resetData();
            } else {
                this.dSW.resetData();
            }
        }
    }

    public boolean bv(List<Long> list) {
        if (this.dEF == null || this.dEF.azB()) {
            return false;
        }
        return this.dSW.bv(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dEF != null && this.dEx != null && lVar != null) {
            if (this.dEF.azB()) {
                if (this.dSX.auU() == 1 && !this.dEF.El()) {
                    this.dSX.setSortType(this.dEF.YM());
                    this.dEx.a(this.dSX.getDataList(), lVar);
                    int pn = this.dSX.getPn();
                    this.dSX.setPn(pn);
                    this.dEF.nD(pn + 1);
                }
            } else if (this.dEF.azr() == 1) {
                if (!this.dSW.isLoading && !this.dEF.El()) {
                    int pn2 = this.dSW.getPn();
                    if (this.dSW.bv(lVar.buZ())) {
                        this.dEx.a(this.dSW.azi(), lVar);
                        this.dSW.setSortType(this.dEF.YM());
                        this.dSW.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.buZ(), str, pn2);
                    } else if (this.dSW.auU() == 1) {
                        this.dEx.a(this.dSW.azi(), lVar);
                        this.dSW.setPn(pn2);
                        this.dEF.nD(pn2 + 1);
                        this.dSW.loadingDone = false;
                        this.dSW.loadIndex = 0;
                    }
                }
            } else if (!this.dEF.azu()) {
                this.dEF.amN();
            }
        }
    }

    public int auU() {
        if (this.dEF == null) {
            return -1;
        }
        if (this.dEF.azB()) {
            return this.dSX.auU();
        }
        return this.dSW.auU();
    }

    public void setHasMore(int i) {
        if (this.dEF != null) {
            if (this.dEF.azB()) {
                this.dSX.setHasMore(i);
            } else {
                this.dSW.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dEF == null) {
            return 1;
        }
        if (this.dEF.azB()) {
            return this.dSX.getPn();
        }
        return this.dSW.getPn();
    }

    public void setPn(int i) {
        if (this.dEF != null) {
            if (this.dEF.azB()) {
                this.dSX.setPn(i);
            } else {
                this.dSW.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getDataList() {
        return this.dEF.azB() ? this.dSX.getDataList() : this.dEF.azw();
    }

    public FrsSmartLoadMoreModel azl() {
        return this.dSX;
    }
}
