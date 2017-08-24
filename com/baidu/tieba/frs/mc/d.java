package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private final com.baidu.tieba.frs.i cjL;
    private final FrsModelController cjU;
    private final com.baidu.tieba.frs.f coV;
    private final FrsLoadMoreModel cwE;
    private final FrsSmartLoadMoreModel cwF;

    public d(com.baidu.tieba.frs.f fVar, j jVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.coV = fVar;
        this.cwE = new FrsLoadMoreModel(fVar, jVar);
        this.cwF = new FrsSmartLoadMoreModel(fVar, jVar);
        this.cjL = fVar.afp();
        this.cjU = fVar.afk();
        this.cwF.setSortType(this.cjU.Om());
        this.cwE.setSortType(this.cjU.Om());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.cjU != null) {
            boolean aji = this.coV.afk().aji();
            if (this.cjU.ajj()) {
                return this.cwF.a(z, aji, arrayList);
            }
            return this.cwE.a(z, aji, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cjU != null) {
            if (this.cjU.ajj()) {
                this.cwF.resetData();
            } else {
                this.cwE.resetData();
            }
        }
    }

    public boolean aK(List<Long> list) {
        if (this.cjU == null || this.cjU.ajj()) {
            return false;
        }
        return this.cwE.aK(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.i iVar) {
        if (this.cjU != null && this.cjL != null && iVar != null) {
            if (this.cjU.ajj()) {
                if (this.cwF.afq() == 1 && !this.cjU.xc()) {
                    this.cwF.setSortType(this.cjU.Om());
                    this.cjL.a(this.cwF.getDataList(), iVar);
                    int pn = this.cwF.getPn();
                    this.cwF.setPn(pn);
                    this.cjU.je(pn + 1);
                }
            } else if (this.cjU.aiZ() == 1) {
                if (!this.cwE.isLoading && !this.cjU.xc()) {
                    int pn2 = this.cwE.getPn();
                    if (this.cwE.aK(iVar.bri())) {
                        this.cjL.a(this.cwE.ahY(), iVar);
                        this.cwE.setSortType(this.cjU.Om());
                        this.cwE.a(com.baidu.adp.lib.g.b.d(str2, 0L), iVar.bri(), str, pn2);
                    } else if (this.cwE.afq() == 1) {
                        this.cjL.a(this.cwE.ahY(), iVar);
                        this.cwE.setPn(pn2);
                        this.cjU.je(pn2 + 1);
                        this.cwE.loadingDone = false;
                        this.cwE.loadIndex = 0;
                    }
                }
            } else if (!this.cjU.ajc()) {
                this.cjU.Yh();
            }
        }
    }

    public int afq() {
        if (this.cjU == null) {
            return -1;
        }
        if (this.cjU.ajj()) {
            return this.cwF.afq();
        }
        return this.cwE.afq();
    }

    public void setHasMore(int i) {
        if (this.cjU != null) {
            if (this.cjU.ajj()) {
                this.cwF.setHasMore(i);
            } else {
                this.cwE.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cjU == null) {
            return 1;
        }
        if (this.cjU.ajj()) {
            return this.cwF.getPn();
        }
        return this.cwE.getPn();
    }

    public void setPn(int i) {
        if (this.cjU != null) {
            if (this.cjU.ajj()) {
                this.cwF.setPn(i);
            } else {
                this.cwE.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cjU.ajj() ? this.cwF.getDataList() : this.cjU.aje();
    }

    public FrsSmartLoadMoreModel aiT() {
        return this.cwF;
    }
}
