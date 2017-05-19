package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final com.baidu.tieba.frs.r bNK;
    private final at bOn;
    private final FrsModelController bOw;
    private final FrsLoadMoreModel bXS;
    private final FrsSmartLoadMoreModel bXT;

    public h(com.baidu.tieba.frs.r rVar, x xVar) {
        if (rVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.bNK = rVar;
        this.bXS = new FrsLoadMoreModel(rVar, xVar);
        this.bXT = new FrsSmartLoadMoreModel(rVar, xVar);
        this.bOn = rVar.YZ();
        this.bOw = rVar.YU();
        this.bXT.setSortType(this.bOw.abX());
        this.bXS.setSortType(this.bOw.abX());
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.bOw != null) {
            boolean aca = this.bNK.YU().aca();
            if (this.bOw.acb()) {
                return this.bXT.a(z, aca, arrayList);
            }
            return this.bXS.a(z, aca, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.bOw != null) {
            if (this.bOw.acb()) {
                this.bXT.resetData();
            } else {
                this.bXS.resetData();
            }
        }
    }

    public boolean aq(List<Long> list) {
        if (this.bOw == null || this.bOw.acb()) {
            return false;
        }
        return this.bXS.aq(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bOw != null && this.bOn != null && nVar != null) {
            if (this.bOw.acb()) {
                if (this.bXT.Za() == 1 && !this.bOw.wu()) {
                    this.bXT.setSortType(this.bOw.abX());
                    this.bOn.a(this.bXT.getDataList(), nVar);
                    int pn = this.bXT.getPn();
                    this.bXT.setPn(pn);
                    this.bOw.ii(pn + 1);
                }
            } else if (this.bOw.abQ() == 1) {
                if (!this.bXS.isLoading && !this.bOw.wu()) {
                    int pn2 = this.bXS.getPn();
                    if (this.bXS.aq(nVar.beW())) {
                        this.bOn.a(this.bXS.abx(), nVar);
                        this.bXS.setSortType(this.bOw.abX());
                        this.bXS.a(com.baidu.adp.lib.g.b.c(str2, 0L), nVar.beW(), str, pn2);
                    } else if (this.bXS.Za() == 1) {
                        this.bOn.a(this.bXS.abx(), nVar);
                        this.bXS.setPn(pn2);
                        this.bOw.ii(pn2 + 1);
                        this.bXS.loadingDone = false;
                        this.bXS.loadIndex = 0;
                    }
                }
            } else if (!this.bOw.abT()) {
                this.bOw.UJ();
            }
        }
    }

    public int Za() {
        if (this.bOw == null) {
            return -1;
        }
        if (this.bOw.acb()) {
            return this.bXT.Za();
        }
        return this.bXS.Za();
    }

    public void setHasMore(int i) {
        if (this.bOw != null) {
            if (this.bOw.acb()) {
                this.bXT.setHasMore(i);
            } else {
                this.bXS.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.bOw == null) {
            return 1;
        }
        if (this.bOw.acb()) {
            return this.bXT.getPn();
        }
        return this.bXS.getPn();
    }

    public void setPn(int i) {
        if (this.bOw != null) {
            if (this.bOw.acb()) {
                this.bXT.setPn(i);
            } else {
                this.bXS.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.bOw.acb() ? this.bXT.getDataList() : this.bOw.abV();
    }

    public FrsSmartLoadMoreModel abL() {
        return this.bXT;
    }
}
