package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final com.baidu.tieba.frs.r bTw;
    private final au bUa;
    private final FrsModelController bUj;
    private final FrsLoadMoreModel ced;
    private final FrsSmartLoadMoreModel cee;

    public h(com.baidu.tieba.frs.r rVar, x xVar) {
        if (rVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.bTw = rVar;
        this.ced = new FrsLoadMoreModel(rVar, xVar);
        this.cee = new FrsSmartLoadMoreModel(rVar, xVar);
        this.bUa = rVar.aad();
        this.bUj = rVar.ZY();
        this.cee.setSortType(this.bUj.adb());
        this.ced.setSortType(this.bUj.adb());
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.bUj != null) {
            boolean ade = this.bTw.ZY().ade();
            if (this.bUj.adf()) {
                return this.cee.a(z, ade, arrayList);
            }
            return this.ced.a(z, ade, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.bUj != null) {
            if (this.bUj.adf()) {
                this.cee.resetData();
            } else {
                this.ced.resetData();
            }
        }
    }

    public boolean aq(List<Long> list) {
        if (this.bUj == null || this.bUj.adf()) {
            return false;
        }
        return this.ced.aq(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bUj != null && this.bUa != null && nVar != null) {
            if (this.bUj.adf()) {
                if (this.cee.aae() == 1 && !this.bUj.wq()) {
                    this.cee.setSortType(this.bUj.adb());
                    this.bUa.a(this.cee.getDataList(), nVar);
                    int pn = this.cee.getPn();
                    this.cee.setPn(pn);
                    this.bUj.iG(pn + 1);
                }
            } else if (this.bUj.acU() == 1) {
                if (!this.ced.isLoading && !this.bUj.wq()) {
                    int pn2 = this.ced.getPn();
                    if (this.ced.aq(nVar.bgr())) {
                        this.bUa.a(this.ced.acB(), nVar);
                        this.ced.setSortType(this.bUj.adb());
                        this.ced.a(com.baidu.adp.lib.g.b.c(str2, 0L), nVar.bgr(), str, pn2);
                    } else if (this.ced.aae() == 1) {
                        this.bUa.a(this.ced.acB(), nVar);
                        this.ced.setPn(pn2);
                        this.bUj.iG(pn2 + 1);
                        this.ced.loadingDone = false;
                        this.ced.loadIndex = 0;
                    }
                }
            } else if (!this.bUj.acX()) {
                this.bUj.VL();
            }
        }
    }

    public int aae() {
        if (this.bUj == null) {
            return -1;
        }
        if (this.bUj.adf()) {
            return this.cee.aae();
        }
        return this.ced.aae();
    }

    public void setHasMore(int i) {
        if (this.bUj != null) {
            if (this.bUj.adf()) {
                this.cee.setHasMore(i);
            } else {
                this.ced.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.bUj == null) {
            return 1;
        }
        if (this.bUj.adf()) {
            return this.cee.getPn();
        }
        return this.ced.getPn();
    }

    public void setPn(int i) {
        if (this.bUj != null) {
            if (this.bUj.adf()) {
                this.cee.setPn(i);
            } else {
                this.ced.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.bUj.adf() ? this.cee.getDataList() : this.bUj.acZ();
    }

    public FrsSmartLoadMoreModel acP() {
        return this.cee;
    }
}
