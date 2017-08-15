package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private final com.baidu.tieba.frs.i cjK;
    private final FrsModelController cjT;
    private final com.baidu.tieba.frs.f coU;
    private final FrsLoadMoreModel cwE;
    private final FrsSmartLoadMoreModel cwF;

    public d(com.baidu.tieba.frs.f fVar, j jVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.coU = fVar;
        this.cwE = new FrsLoadMoreModel(fVar, jVar);
        this.cwF = new FrsSmartLoadMoreModel(fVar, jVar);
        this.cjK = fVar.afv();
        this.cjT = fVar.afq();
        this.cwF.setSortType(this.cjT.Om());
        this.cwE.setSortType(this.cjT.Om());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.cjT != null) {
            boolean ajo = this.coU.afq().ajo();
            if (this.cjT.ajp()) {
                return this.cwF.a(z, ajo, arrayList);
            }
            return this.cwE.a(z, ajo, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cjT != null) {
            if (this.cjT.ajp()) {
                this.cwF.resetData();
            } else {
                this.cwE.resetData();
            }
        }
    }

    public boolean aK(List<Long> list) {
        if (this.cjT == null || this.cjT.ajp()) {
            return false;
        }
        return this.cwE.aK(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.i iVar) {
        if (this.cjT != null && this.cjK != null && iVar != null) {
            if (this.cjT.ajp()) {
                if (this.cwF.afw() == 1 && !this.cjT.xc()) {
                    this.cwF.setSortType(this.cjT.Om());
                    this.cjK.a(this.cwF.getDataList(), iVar);
                    int pn = this.cwF.getPn();
                    this.cwF.setPn(pn);
                    this.cjT.je(pn + 1);
                }
            } else if (this.cjT.ajf() == 1) {
                if (!this.cwE.isLoading && !this.cjT.xc()) {
                    int pn2 = this.cwE.getPn();
                    if (this.cwE.aK(iVar.brp())) {
                        this.cjK.a(this.cwE.aie(), iVar);
                        this.cwE.setSortType(this.cjT.Om());
                        this.cwE.a(com.baidu.adp.lib.g.b.d(str2, 0L), iVar.brp(), str, pn2);
                    } else if (this.cwE.afw() == 1) {
                        this.cjK.a(this.cwE.aie(), iVar);
                        this.cwE.setPn(pn2);
                        this.cjT.je(pn2 + 1);
                        this.cwE.loadingDone = false;
                        this.cwE.loadIndex = 0;
                    }
                }
            } else if (!this.cjT.aji()) {
                this.cjT.Yk();
            }
        }
    }

    public int afw() {
        if (this.cjT == null) {
            return -1;
        }
        if (this.cjT.ajp()) {
            return this.cwF.afw();
        }
        return this.cwE.afw();
    }

    public void setHasMore(int i) {
        if (this.cjT != null) {
            if (this.cjT.ajp()) {
                this.cwF.setHasMore(i);
            } else {
                this.cwE.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cjT == null) {
            return 1;
        }
        if (this.cjT.ajp()) {
            return this.cwF.getPn();
        }
        return this.cwE.getPn();
    }

    public void setPn(int i) {
        if (this.cjT != null) {
            if (this.cjT.ajp()) {
                this.cwF.setPn(i);
            } else {
                this.cwE.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cjT.ajp() ? this.cwF.getDataList() : this.cjT.ajk();
    }

    public FrsSmartLoadMoreModel aiZ() {
        return this.cwF;
    }
}
