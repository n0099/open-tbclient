package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final com.baidu.tieba.frs.r cbE;
    private final av ccj;
    private final FrsModelController ccs;
    private final FrsLoadMoreModel cmq;
    private final FrsSmartLoadMoreModel cmr;

    public h(com.baidu.tieba.frs.r rVar, aa aaVar) {
        if (rVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cbE = rVar;
        this.cmq = new FrsLoadMoreModel(rVar, aaVar);
        this.cmr = new FrsSmartLoadMoreModel(rVar, aaVar);
        this.ccj = rVar.adU();
        this.ccs = rVar.adP();
        this.cmr.setSortType(this.ccs.agU());
        this.cmq.setSortType(this.ccs.agU());
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.ccs != null) {
            boolean agX = this.cbE.adP().agX();
            if (this.ccs.agY()) {
                return this.cmr.a(z, agX, arrayList);
            }
            return this.cmq.a(z, agX, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.ccs != null) {
            if (this.ccs.agY()) {
                this.cmr.resetData();
            } else {
                this.cmq.resetData();
            }
        }
    }

    public boolean az(List<Long> list) {
        if (this.ccs == null || this.ccs.agY()) {
            return false;
        }
        return this.cmq.az(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.ccs != null && this.ccj != null && nVar != null) {
            if (this.ccs.agY()) {
                if (this.cmr.adV() == 1 && !this.ccs.wI()) {
                    this.cmr.setSortType(this.ccs.agU());
                    this.ccj.a(this.cmr.getDataList(), nVar);
                    int pn = this.cmr.getPn();
                    this.cmr.setPn(pn);
                    this.ccs.iS(pn + 1);
                }
            } else if (this.ccs.agN() == 1) {
                if (!this.cmq.isLoading && !this.ccs.wI()) {
                    int pn2 = this.cmq.getPn();
                    if (this.cmq.az(nVar.bkF())) {
                        this.ccj.a(this.cmq.agt(), nVar);
                        this.cmq.setSortType(this.ccs.agU());
                        this.cmq.a(com.baidu.adp.lib.g.b.c(str2, 0L), nVar.bkF(), str, pn2);
                    } else if (this.cmq.adV() == 1) {
                        this.ccj.a(this.cmq.agt(), nVar);
                        this.cmq.setPn(pn2);
                        this.ccs.iS(pn2 + 1);
                        this.cmq.loadingDone = false;
                        this.cmq.loadIndex = 0;
                    }
                }
            } else if (!this.ccs.agQ()) {
                this.ccs.Xc();
            }
        }
    }

    public int adV() {
        if (this.ccs == null) {
            return -1;
        }
        if (this.ccs.agY()) {
            return this.cmr.adV();
        }
        return this.cmq.adV();
    }

    public void setHasMore(int i) {
        if (this.ccs != null) {
            if (this.ccs.agY()) {
                this.cmr.setHasMore(i);
            } else {
                this.cmq.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.ccs == null) {
            return 1;
        }
        if (this.ccs.agY()) {
            return this.cmr.getPn();
        }
        return this.cmq.getPn();
    }

    public void setPn(int i) {
        if (this.ccs != null) {
            if (this.ccs.agY()) {
                this.cmr.setPn(i);
            } else {
                this.cmq.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.ccs.agY() ? this.cmr.getDataList() : this.ccs.agS();
    }

    public FrsSmartLoadMoreModel agH() {
        return this.cmr;
    }
}
