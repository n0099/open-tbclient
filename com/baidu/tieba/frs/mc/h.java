package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private final az bOU;
    private final FrsModelController bPf;
    private final FrsActivity bVk;
    private final FrsLoadMoreModel cac;
    private final FrsSmartLoadMoreModel cad;

    public h(FrsActivity frsActivity, x xVar) {
        if (frsActivity == null) {
            throw new NullPointerException("FrsActivity is NullPointerException");
        }
        this.bVk = frsActivity;
        this.cac = new FrsLoadMoreModel(frsActivity, xVar);
        this.cad = new FrsSmartLoadMoreModel(frsActivity, xVar);
        this.bOU = this.bVk.aab();
        this.bPf = this.bVk.ZU();
        this.cad.setSortType(this.bPf.adT());
        this.cac.setSortType(this.bPf.adT());
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.bPf != null) {
            boolean adW = this.bVk.ZU().adW();
            if (this.bPf.adX()) {
                return this.cad.a(z, adW, arrayList);
            }
            return this.cac.a(z, adW, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.bPf != null) {
            if (this.bPf.adX()) {
                this.cad.resetData();
            } else {
                this.cac.resetData();
            }
        }
    }

    public boolean au(List<Long> list) {
        if (this.bPf == null || this.bPf.adX()) {
            return false;
        }
        return this.cac.au(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.bPf != null && this.bOU != null && nVar != null) {
            if (this.bPf.adX()) {
                if (this.cad.aac() == 1 && !this.bPf.xj()) {
                    this.cad.setSortType(this.bPf.adT());
                    this.bOU.a(this.cad.getDataList(), nVar);
                    int pn = this.cad.getPn();
                    this.cad.setPn(pn);
                    this.bPf.is(pn + 1);
                }
            } else if (this.bPf.adM() == 1) {
                if (!this.cac.isLoading && !this.bPf.xj()) {
                    int pn2 = this.cac.getPn();
                    if (this.cac.au(nVar.bhu())) {
                        this.bOU.a(this.cac.adr(), nVar);
                        this.cac.setSortType(this.bPf.adT());
                        this.cac.a(com.baidu.adp.lib.g.b.c(str2, 0L), nVar.bhu(), str, pn2);
                    } else if (this.cac.aac() == 1) {
                        this.bOU.a(this.cac.adr(), nVar);
                        this.cac.setPn(pn2);
                        this.bPf.is(pn2 + 1);
                        this.cac.loadingDone = false;
                        this.cac.loadIndex = 0;
                    }
                }
            } else if (!this.bPf.adP()) {
                this.bPf.Vq();
            }
        }
    }

    public int aac() {
        if (this.bPf == null) {
            return -1;
        }
        if (this.bPf.adX()) {
            return this.cad.aac();
        }
        return this.cac.aac();
    }

    public void setHasMore(int i) {
        if (this.bPf != null) {
            if (this.bPf.adX()) {
                this.cad.setHasMore(i);
            } else {
                this.cac.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.bPf == null) {
            return 1;
        }
        if (this.bPf.adX()) {
            return this.cad.getPn();
        }
        return this.cac.getPn();
    }

    public void setPn(int i) {
        if (this.bPf != null) {
            if (this.bPf.adX()) {
                this.cad.setPn(i);
            } else {
                this.cac.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.bPf.adX() ? this.cad.getDataList() : this.bPf.adR();
    }

    public FrsSmartLoadMoreModel adH() {
        return this.cad;
    }
}
