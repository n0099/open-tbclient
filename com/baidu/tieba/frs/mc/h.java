package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final az bMD;
    private final FrsModelController bMO;
    private final FrsActivity bST;
    private final FrsLoadMoreModel bXL;
    private final FrsSmartLoadMoreModel bXM;

    public h(FrsActivity frsActivity, x xVar) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bST = frsActivity;
        this.bXL = new FrsLoadMoreModel(frsActivity, xVar);
        this.bXM = new FrsSmartLoadMoreModel(frsActivity, xVar);
        this.bMD = this.bST.Za();
        this.bMO = this.bST.YT();
        this.bXM.setSortType(this.bMO.acS());
        this.bXL.setSortType(this.bMO.acS());
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.bMO != null) {
            boolean acV = this.bST.YT().acV();
            if (this.bMO.acW()) {
                return this.bXM.a(z, acV, arrayList);
            }
            return this.bXL.a(z, acV, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.bMO != null) {
            if (this.bMO.acW()) {
                this.bXM.resetData();
            } else {
                this.bXL.resetData();
            }
        }
    }

    public boolean at(List<Long> list) {
        if (this.bMO == null || this.bMO.acW()) {
            return false;
        }
        return this.bXL.at(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bMO != null && this.bMD != null && nVar != null) {
            if (this.bMO.acW()) {
                if (this.bXM.Zb() == 1 && !this.bMO.xj()) {
                    this.bXM.setSortType(this.bMO.acS());
                    this.bMD.a(this.bXM.getDataList(), nVar);
                    int pn = this.bXM.getPn();
                    this.bXM.setPn(pn);
                    this.bMO.im(pn + 1);
                }
            } else if (this.bMO.acL() == 1) {
                if (!this.bXL.isLoading && !this.bMO.xj()) {
                    int pn2 = this.bXL.getPn();
                    if (this.bXL.at(nVar.bgs())) {
                        this.bMD.a(this.bXL.acq(), nVar);
                        this.bXL.setSortType(this.bMO.acS());
                        this.bXL.a(com.baidu.adp.lib.g.b.c(str2, 0L), nVar.bgs(), str, pn2);
                    } else if (this.bXL.Zb() == 1) {
                        this.bMD.a(this.bXL.acq(), nVar);
                        this.bXL.setPn(pn2);
                        this.bMO.im(pn2 + 1);
                        this.bXL.loadingDone = false;
                        this.bXL.loadIndex = 0;
                    }
                }
            } else if (!this.bMO.acO()) {
                this.bMO.Up();
            }
        }
    }

    public int Zb() {
        if (this.bMO == null) {
            return -1;
        }
        if (this.bMO.acW()) {
            return this.bXM.Zb();
        }
        return this.bXL.Zb();
    }

    public void setHasMore(int i) {
        if (this.bMO != null) {
            if (this.bMO.acW()) {
                this.bXM.setHasMore(i);
            } else {
                this.bXL.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.bMO == null) {
            return 1;
        }
        if (this.bMO.acW()) {
            return this.bXM.getPn();
        }
        return this.bXL.getPn();
    }

    public void setPn(int i) {
        if (this.bMO != null) {
            if (this.bMO.acW()) {
                this.bXM.setPn(i);
            } else {
                this.bXL.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.bMO.acW() ? this.bXM.getDataList() : this.bMO.acQ();
    }

    public FrsSmartLoadMoreModel acG() {
        return this.bXM;
    }
}
