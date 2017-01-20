package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final ax bFF;
    private final FrsModelController bFQ;
    private final FrsActivity bLZ;
    private final FrsLoadMoreModel bSe;
    private final FrsSmartLoadMoreModel bSf;

    public h(FrsActivity frsActivity, s sVar) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bLZ = frsActivity;
        this.bSe = new FrsLoadMoreModel(frsActivity, sVar);
        this.bSf = new FrsSmartLoadMoreModel(frsActivity, sVar);
        this.bFF = this.bLZ.XF();
        this.bFQ = this.bLZ.Xy();
        this.bSf.setSortType(this.bFQ.acb());
        this.bSe.setSortType(this.bFQ.acb());
    }

    public ArrayList<v> a(boolean z, boolean z2, ArrayList<v> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.bFQ != null) {
            boolean ace = this.bLZ.Xy().ace();
            if (this.bFQ.acf()) {
                return this.bSf.a(z, ace, arrayList);
            }
            return this.bSe.a(z, ace, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.bFQ != null) {
            if (this.bFQ.acf()) {
                this.bSf.resetData();
            } else {
                this.bSe.resetData();
            }
        }
    }

    public boolean aw(List<Long> list) {
        if (this.bFQ == null || this.bFQ.acf()) {
            return false;
        }
        return this.bSe.aw(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bFQ != null && this.bFF != null && nVar != null) {
            if (this.bFQ.acf()) {
                if (this.bSf.XG() == 1 && !this.bFQ.wq()) {
                    this.bSf.setSortType(this.bFQ.acb());
                    this.bFF.a(this.bSf.getDataList(), nVar);
                    int pn = this.bSf.getPn();
                    this.bSf.setPn(pn);
                    this.bFQ.in(pn + 1);
                }
            } else if (this.bFQ.abU() == 1) {
                if (!this.bSe.isLoading && !this.bFQ.wq()) {
                    int pn2 = this.bSe.getPn();
                    if (this.bSe.aw(nVar.bfR())) {
                        this.bFF.a(this.bSe.aaX(), nVar);
                        this.bSe.setSortType(this.bFQ.acb());
                        this.bSe.a(com.baidu.adp.lib.g.b.c(str2, 0L), nVar.bfR(), str, pn2);
                    } else if (this.bSe.XG() == 1) {
                        this.bFF.a(this.bSe.aaX(), nVar);
                        this.bSe.setPn(pn2);
                        this.bFQ.in(pn2 + 1);
                        this.bSe.loadingDone = false;
                        this.bSe.loadIndex = 0;
                    }
                }
            } else if (!this.bFQ.abX()) {
                this.bFQ.SQ();
            }
        }
    }

    public int XG() {
        if (this.bFQ == null) {
            return -1;
        }
        if (this.bFQ.acf()) {
            return this.bSf.XG();
        }
        return this.bSe.XG();
    }

    public void setHasMore(int i) {
        if (this.bFQ != null) {
            if (this.bFQ.acf()) {
                this.bSf.setHasMore(i);
            } else {
                this.bSe.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.bFQ == null) {
            return 1;
        }
        if (this.bFQ.acf()) {
            return this.bSf.getPn();
        }
        return this.bSe.getPn();
    }

    public void setPn(int i) {
        if (this.bFQ != null) {
            if (this.bFQ.acf()) {
                this.bSf.setPn(i);
            } else {
                this.bSe.setPn(i);
            }
        }
    }

    public ArrayList<v> getDataList() {
        return this.bFQ.acf() ? this.bSf.getDataList() : this.bFQ.abZ();
    }
}
