package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final ax bMN;
    private final FrsModelController bMY;
    private final FrsActivity bTf;
    private final FrsLoadMoreModel bZm;
    private final FrsSmartLoadMoreModel bZn;

    public h(FrsActivity frsActivity, v vVar) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bTf = frsActivity;
        this.bZm = new FrsLoadMoreModel(frsActivity, vVar);
        this.bZn = new FrsSmartLoadMoreModel(frsActivity, vVar);
        this.bMN = this.bTf.YE();
        this.bMY = this.bTf.Yx();
        this.bZn.setSortType(this.bMY.acY());
        this.bZm.setSortType(this.bMY.acY());
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.bMY != null) {
            boolean adb = this.bTf.Yx().adb();
            if (this.bMY.adc()) {
                return this.bZn.a(z, adb, arrayList);
            }
            return this.bZm.a(z, adb, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.bMY != null) {
            if (this.bMY.adc()) {
                this.bZn.resetData();
            } else {
                this.bZm.resetData();
            }
        }
    }

    public boolean at(List<Long> list) {
        if (this.bMY == null || this.bMY.adc()) {
            return false;
        }
        return this.bZm.at(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bMY != null && this.bMN != null && nVar != null) {
            if (this.bMY.adc()) {
                if (this.bZn.YF() == 1 && !this.bMY.wN()) {
                    this.bZn.setSortType(this.bMY.acY());
                    this.bMN.a(this.bZn.getDataList(), nVar);
                    int pn = this.bZn.getPn();
                    this.bZn.setPn(pn);
                    this.bMY.ij(pn + 1);
                }
            } else if (this.bMY.acR() == 1) {
                if (!this.bZm.isLoading && !this.bMY.wN()) {
                    int pn2 = this.bZm.getPn();
                    if (this.bZm.at(nVar.bfE())) {
                        this.bMN.a(this.bZm.abU(), nVar);
                        this.bZm.setSortType(this.bMY.acY());
                        this.bZm.a(com.baidu.adp.lib.g.b.c(str2, 0L), nVar.bfE(), str, pn2);
                    } else if (this.bZm.YF() == 1) {
                        this.bMN.a(this.bZm.abU(), nVar);
                        this.bZm.setPn(pn2);
                        this.bMY.ij(pn2 + 1);
                        this.bZm.loadingDone = false;
                        this.bZm.loadIndex = 0;
                    }
                }
            } else if (!this.bMY.acU()) {
                this.bMY.TR();
            }
        }
    }

    public int YF() {
        if (this.bMY == null) {
            return -1;
        }
        if (this.bMY.adc()) {
            return this.bZn.YF();
        }
        return this.bZm.YF();
    }

    public void setHasMore(int i) {
        if (this.bMY != null) {
            if (this.bMY.adc()) {
                this.bZn.setHasMore(i);
            } else {
                this.bZm.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.bMY == null) {
            return 1;
        }
        if (this.bMY.adc()) {
            return this.bZn.getPn();
        }
        return this.bZm.getPn();
    }

    public void setPn(int i) {
        if (this.bMY != null) {
            if (this.bMY.adc()) {
                this.bZn.setPn(i);
            } else {
                this.bZm.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.bMY.adc() ? this.bZn.getDataList() : this.bMY.acW();
    }
}
