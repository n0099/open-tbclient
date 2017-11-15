package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private final com.baidu.tieba.frs.f cFg;
    private final FrsLoadMoreModel cOk;
    private final FrsSmartLoadMoreModel cOl;
    private final com.baidu.tieba.frs.i cxU;
    private final FrsModelController cyd;

    public c(com.baidu.tieba.frs.f fVar, i iVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.cFg = fVar;
        this.cOk = new FrsLoadMoreModel(fVar, iVar);
        this.cOl = new FrsSmartLoadMoreModel(fVar, iVar);
        this.cxU = fVar.ajk();
        this.cyd = fVar.ajf();
        this.cOl.setSortType(this.cyd.Pj());
        this.cOk.setSortType(this.cyd.Pj());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cyd != null) {
            boolean aob = this.cFg.ajf().aob();
            if (this.cyd.aoc()) {
                return this.cOl.a(z, aob, arrayList, z3);
            }
            return this.cOk.a(z, aob, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cyd != null) {
            if (this.cyd.aoc()) {
                this.cOl.resetData();
            } else {
                this.cOk.resetData();
            }
        }
    }

    public boolean aQ(List<Long> list) {
        if (this.cyd == null || this.cyd.aoc()) {
            return false;
        }
        return this.cOk.aQ(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.j jVar) {
        if (this.cyd != null && this.cxU != null && jVar != null) {
            if (this.cyd.aoc()) {
                if (this.cOl.ajl() == 1 && !this.cyd.wz()) {
                    this.cOl.setSortType(this.cyd.Pj());
                    this.cxU.a(this.cOl.getDataList(), jVar);
                    int pn = this.cOl.getPn();
                    this.cOl.setPn(pn);
                    this.cyd.jS(pn + 1);
                }
            } else if (this.cyd.anS() == 1) {
                if (!this.cOk.isLoading && !this.cyd.wz()) {
                    int pn2 = this.cOk.getPn();
                    if (this.cOk.aQ(jVar.bsM())) {
                        this.cxU.a(this.cOk.amv(), jVar);
                        this.cOk.setSortType(this.cyd.Pj());
                        this.cOk.a(com.baidu.adp.lib.g.b.c(str2, 0L), jVar.bsM(), str, pn2);
                    } else if (this.cOk.ajl() == 1) {
                        this.cxU.a(this.cOk.amv(), jVar);
                        this.cOk.setPn(pn2);
                        this.cyd.jS(pn2 + 1);
                        this.cOk.loadingDone = false;
                        this.cOk.loadIndex = 0;
                    }
                }
            } else if (!this.cyd.anV()) {
                this.cyd.aby();
            }
        }
    }

    public int ajl() {
        if (this.cyd == null) {
            return -1;
        }
        if (this.cyd.aoc()) {
            return this.cOl.ajl();
        }
        return this.cOk.ajl();
    }

    public void setHasMore(int i) {
        if (this.cyd != null) {
            if (this.cyd.aoc()) {
                this.cOl.setHasMore(i);
            } else {
                this.cOk.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cyd == null) {
            return 1;
        }
        if (this.cyd.aoc()) {
            return this.cOl.getPn();
        }
        return this.cOk.getPn();
    }

    public void setPn(int i) {
        if (this.cyd != null) {
            if (this.cyd.aoc()) {
                this.cOl.setPn(i);
            } else {
                this.cOk.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cyd.aoc() ? this.cOl.getDataList() : this.cyd.anX();
    }

    public FrsSmartLoadMoreModel anM() {
        return this.cOl;
    }
}
