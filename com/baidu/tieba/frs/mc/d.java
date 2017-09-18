package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private final FrsLoadMoreModel cDW;
    private final FrsSmartLoadMoreModel cDX;
    private final com.baidu.tieba.frs.i cpW;
    private final FrsModelController cqf;
    private final com.baidu.tieba.frs.f cws;

    public d(com.baidu.tieba.frs.f fVar, j jVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cws = fVar;
        this.cDW = new FrsLoadMoreModel(fVar, jVar);
        this.cDX = new FrsSmartLoadMoreModel(fVar, jVar);
        this.cpW = fVar.agY();
        this.cqf = fVar.agT();
        this.cDX.setSortType(this.cqf.OE());
        this.cDW.setSortType(this.cqf.OE());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cqf != null) {
            boolean alc = this.cws.agT().alc();
            if (this.cqf.ald()) {
                return this.cDX.a(z, alc, arrayList, z3);
            }
            return this.cDW.a(z, alc, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cqf != null) {
            if (this.cqf.ald()) {
                this.cDX.resetData();
            } else {
                this.cDW.resetData();
            }
        }
    }

    public boolean aO(List<Long> list) {
        if (this.cqf == null || this.cqf.ald()) {
            return false;
        }
        return this.cDW.aO(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.i iVar) {
        if (this.cqf != null && this.cpW != null && iVar != null) {
            if (this.cqf.ald()) {
                if (this.cDX.agZ() == 1 && !this.cqf.xa()) {
                    this.cDX.setSortType(this.cqf.OE());
                    this.cpW.a(this.cDX.getDataList(), iVar);
                    int pn = this.cDX.getPn();
                    this.cDX.setPn(pn);
                    this.cqf.ju(pn + 1);
                }
            } else if (this.cqf.akT() == 1) {
                if (!this.cDW.isLoading && !this.cqf.xa()) {
                    int pn2 = this.cDW.getPn();
                    if (this.cDW.aO(iVar.bqI())) {
                        this.cpW.a(this.cDW.ajV(), iVar);
                        this.cDW.setSortType(this.cqf.OE());
                        this.cDW.a(com.baidu.adp.lib.g.b.c(str2, 0L), iVar.bqI(), str, pn2);
                    } else if (this.cDW.agZ() == 1) {
                        this.cpW.a(this.cDW.ajV(), iVar);
                        this.cDW.setPn(pn2);
                        this.cqf.ju(pn2 + 1);
                        this.cDW.loadingDone = false;
                        this.cDW.loadIndex = 0;
                    }
                }
            } else if (!this.cqf.akW()) {
                this.cqf.Zv();
            }
        }
    }

    public int agZ() {
        if (this.cqf == null) {
            return -1;
        }
        if (this.cqf.ald()) {
            return this.cDX.agZ();
        }
        return this.cDW.agZ();
    }

    public void setHasMore(int i) {
        if (this.cqf != null) {
            if (this.cqf.ald()) {
                this.cDX.setHasMore(i);
            } else {
                this.cDW.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cqf == null) {
            return 1;
        }
        if (this.cqf.ald()) {
            return this.cDX.getPn();
        }
        return this.cDW.getPn();
    }

    public void setPn(int i) {
        if (this.cqf != null) {
            if (this.cqf.ald()) {
                this.cDX.setPn(i);
            } else {
                this.cDW.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cqf.ald() ? this.cDX.getDataList() : this.cqf.akY();
    }

    public FrsSmartLoadMoreModel akN() {
        return this.cDX;
    }
}
