package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final k dBi;
    private final FrsModelController dBq;
    private final com.baidu.tieba.frs.i dPp;
    private final FrsLoadMoreModel dPq;
    private final FrsSmartLoadMoreModel dPr;

    public c(com.baidu.tieba.frs.i iVar, i iVar2) {
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dPp = iVar;
        this.dPq = new FrsLoadMoreModel(iVar, iVar2);
        this.dPr = new FrsSmartLoadMoreModel(iVar, iVar2);
        this.dBi = iVar.atY();
        this.dBq = iVar.atT();
        this.dPr.setSortType(this.dBq.XF());
        this.dPq.setSortType(this.dBq.XF());
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.dBq != null) {
            boolean ayt = this.dPp.atT().ayt();
            if (this.dBq.ayu()) {
                return this.dPr.a(z, ayt, arrayList, z3);
            }
            return this.dPq.a(z, ayt, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dBq != null) {
            if (this.dBq.ayu()) {
                this.dPr.resetData();
            } else {
                this.dPq.resetData();
            }
        }
    }

    public boolean bt(List<Long> list) {
        if (this.dBq == null || this.dBq.ayu()) {
            return false;
        }
        return this.dPq.bt(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dBq != null && this.dBi != null && lVar != null) {
            if (this.dBq.ayu()) {
                if (this.dPr.atZ() == 1 && !this.dBq.DP()) {
                    this.dPr.setSortType(this.dBq.XF());
                    this.dBi.a(this.dPr.getDataList(), lVar);
                    int pn = this.dPr.getPn();
                    this.dPr.setPn(pn);
                    this.dBq.nE(pn + 1);
                }
            } else if (this.dBq.ayk() == 1) {
                if (!this.dPq.isLoading && !this.dBq.DP()) {
                    int pn2 = this.dPq.getPn();
                    if (this.dPq.bt(lVar.btI())) {
                        this.dBi.a(this.dPq.ayb(), lVar);
                        this.dPq.setSortType(this.dBq.XF());
                        this.dPq.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.btI(), str, pn2);
                    } else if (this.dPq.atZ() == 1) {
                        this.dBi.a(this.dPq.ayb(), lVar);
                        this.dPq.setPn(pn2);
                        this.dBq.nE(pn2 + 1);
                        this.dPq.loadingDone = false;
                        this.dPq.loadIndex = 0;
                    }
                }
            } else if (!this.dBq.ayn()) {
                this.dBq.alZ();
            }
        }
    }

    public int atZ() {
        if (this.dBq == null) {
            return -1;
        }
        if (this.dBq.ayu()) {
            return this.dPr.atZ();
        }
        return this.dPq.atZ();
    }

    public void setHasMore(int i) {
        if (this.dBq != null) {
            if (this.dBq.ayu()) {
                this.dPr.setHasMore(i);
            } else {
                this.dPq.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dBq == null) {
            return 1;
        }
        if (this.dBq.ayu()) {
            return this.dPr.getPn();
        }
        return this.dPq.getPn();
    }

    public void setPn(int i) {
        if (this.dBq != null) {
            if (this.dBq.ayu()) {
                this.dPr.setPn(i);
            } else {
                this.dPq.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getDataList() {
        return this.dBq.ayu() ? this.dPr.getDataList() : this.dBq.ayp();
    }

    public FrsSmartLoadMoreModel aye() {
        return this.dPr;
    }
}
