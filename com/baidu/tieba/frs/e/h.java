package com.baidu.tieba.frs.e;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final au bRW;
    private final i bSh;
    private final FrsActivity bZY;
    private final com.baidu.tieba.frs.loadmore.a cgg;
    private final com.baidu.tieba.frs.g.c cgh;

    public h(FrsActivity frsActivity, t tVar) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bZY = frsActivity;
        this.cgg = new com.baidu.tieba.frs.loadmore.a(frsActivity, tVar);
        this.cgh = new com.baidu.tieba.frs.g.c(frsActivity, tVar);
        this.bRW = this.bZY.abZ();
        this.bSh = this.bZY.abS();
        this.cgh.setSortType(this.bSh.agy());
        this.cgg.setSortType(this.bSh.agy());
    }

    public ArrayList<v> a(boolean z, boolean z2, ArrayList<v> arrayList, com.baidu.tieba.tbadkCore.data.f fVar) {
        if (this.bSh != null) {
            boolean agB = this.bZY.abS().agB();
            if (this.bSh.agD()) {
                return this.cgh.a(z, agB, arrayList);
            }
            return this.cgg.a(z, agB, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.bSh != null) {
            if (this.bSh.agD()) {
                this.cgh.resetData();
            } else {
                this.cgg.resetData();
            }
        }
    }

    public boolean aA(List<Long> list) {
        if (this.bSh == null || this.bSh.agD()) {
            return false;
        }
        return this.cgg.aA(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.p pVar) {
        if (this.bSh != null && this.bRW != null && pVar != null) {
            if (this.bSh.agD()) {
                if (this.cgh.acb() == 1 && !this.bSh.wL()) {
                    this.cgh.setSortType(this.bSh.agy());
                    this.bRW.a(this.cgh.getDataList(), pVar);
                    int pn = this.cgh.getPn();
                    this.cgh.setPn(pn);
                    this.bSh.iq(pn + 1);
                }
            } else if (this.bSh.ags() == 1) {
                if (!this.cgg.aAG && !this.bSh.wL()) {
                    int pn2 = this.cgg.getPn();
                    if (this.cgg.aA(pVar.bkn())) {
                        this.bRW.a(this.cgg.afz(), pVar);
                        this.cgg.setSortType(this.bSh.agy());
                        this.cgg.a(com.baidu.adp.lib.h.b.c(str2, 0L), pVar.bkn(), str, pn2);
                    } else if (this.cgg.acb() == 1) {
                        this.bRW.a(this.cgg.afz(), pVar);
                        this.cgg.setPn(pn2);
                        this.bSh.iq(pn2 + 1);
                        this.cgg.ccS = false;
                        this.cgg.ccT = 0;
                    }
                }
            } else if (!this.bSh.agv()) {
                this.bSh.PU();
            }
        }
    }

    public int acb() {
        if (this.bSh == null) {
            return -1;
        }
        if (this.bSh.agD()) {
            return this.cgh.acb();
        }
        return this.cgg.acb();
    }

    public void setHasMore(int i) {
        if (this.bSh != null) {
            if (this.bSh.agD()) {
                this.cgh.setHasMore(i);
            } else {
                this.cgg.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.bSh == null) {
            return 1;
        }
        if (this.bSh.agD()) {
            return this.cgh.getPn();
        }
        return this.cgg.getPn();
    }

    public void setPn(int i) {
        if (this.bSh != null) {
            if (this.bSh.agD()) {
                this.cgh.setPn(i);
            } else {
                this.cgg.setPn(i);
            }
        }
    }
}
