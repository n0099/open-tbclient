package com.baidu.tieba.frs.d;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final FrsActivity bFI;
    private final com.baidu.tieba.frs.loadmore.a bLP;
    private final com.baidu.tieba.frs.f.c bLQ;
    private final ax byg;
    private final i byr;

    public h(FrsActivity frsActivity, t tVar) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bFI = frsActivity;
        this.bLP = new com.baidu.tieba.frs.loadmore.a(frsActivity, tVar);
        this.bLQ = new com.baidu.tieba.frs.f.c(frsActivity, tVar);
        this.byg = this.bFI.Wo();
        this.byr = this.bFI.Wh();
        this.bLQ.setSortType(this.byr.aaV());
        this.bLP.setSortType(this.byr.aaV());
    }

    public ArrayList<v> a(boolean z, boolean z2, ArrayList<v> arrayList, com.baidu.tieba.tbadkCore.data.f fVar) {
        if (this.byr != null) {
            boolean aaY = this.bFI.Wh().aaY();
            if (this.byr.aaZ()) {
                return this.bLQ.a(z, aaY, arrayList);
            }
            return this.bLP.a(z, aaY, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.byr != null) {
            if (this.byr.aaZ()) {
                this.bLQ.resetData();
            } else {
                this.bLP.resetData();
            }
        }
    }

    public boolean as(List<Long> list) {
        if (this.byr == null || this.byr.aaZ()) {
            return false;
        }
        return this.bLP.as(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.o oVar) {
        if (this.byr != null && this.byg != null && oVar != null) {
            if (this.byr.aaZ()) {
                if (this.bLQ.Wp() == 1 && !this.byr.wv()) {
                    this.bLQ.setSortType(this.byr.aaV());
                    this.byg.a(this.bLQ.getDataList(), oVar);
                    int pn = this.bLQ.getPn();
                    this.bLQ.setPn(pn);
                    this.byr.hA(pn + 1);
                }
            } else if (this.byr.aaO() == 1) {
                if (!this.bLP.aAd && !this.byr.wv()) {
                    int pn2 = this.bLP.getPn();
                    if (this.bLP.as(oVar.bed())) {
                        this.byg.a(this.bLP.ZU(), oVar);
                        this.bLP.setSortType(this.byr.aaV());
                        this.bLP.a(com.baidu.adp.lib.h.b.c(str2, 0L), oVar.bed(), str, pn2);
                    } else if (this.bLP.Wp() == 1) {
                        this.byg.a(this.bLP.ZU(), oVar);
                        this.bLP.setPn(pn2);
                        this.byr.hA(pn2 + 1);
                        this.bLP.bIz = false;
                        this.bLP.bIA = 0;
                    }
                }
            } else if (!this.byr.aaR()) {
                this.byr.Pt();
            }
        }
    }

    public int Wp() {
        if (this.byr == null) {
            return -1;
        }
        if (this.byr.aaZ()) {
            return this.bLQ.Wp();
        }
        return this.bLP.Wp();
    }

    public void setHasMore(int i) {
        if (this.byr != null) {
            if (this.byr.aaZ()) {
                this.bLQ.setHasMore(i);
            } else {
                this.bLP.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.byr == null) {
            return 1;
        }
        if (this.byr.aaZ()) {
            return this.bLQ.getPn();
        }
        return this.bLP.getPn();
    }

    public void setPn(int i) {
        if (this.byr != null) {
            if (this.byr.aaZ()) {
                this.bLQ.setPn(i);
            } else {
                this.bLP.setPn(i);
            }
        }
    }

    public ArrayList<v> getDataList() {
        return this.byr.aaZ() ? this.bLQ.getDataList() : this.byr.aaT();
    }
}
