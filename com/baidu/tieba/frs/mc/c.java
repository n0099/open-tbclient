package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final com.baidu.tieba.frs.i dhC;
    private final FrsModelController dhN;
    private final FrsFragment dxw;
    private final FrsLoadMoreModel dxx;
    private final FrsSmartLoadMoreModel dxy;
    private final a dxz = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dhC != null && c.this.dhC.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dhC.getListView().getData();
                if (!w.z(data) && c.this.dhC.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) w.d(data, i)) != null) {
                    c.this.dhC.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, i iVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dxw = frsFragment;
        this.dxx = new FrsLoadMoreModel(frsFragment, iVar);
        this.dxy = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dxy.a(this.dxz);
        this.dxx.a(this.dxz);
        this.dhC = frsFragment.atr();
        this.dhN = frsFragment.atm();
        this.dxy.setSortType(this.dhN.UG());
        this.dxx.setSortType(this.dhN.UG());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dhN != null) {
            boolean ayC = this.dxw.atm().ayC();
            if (this.dhN.ayD()) {
                return this.dxy.a(z, ayC, arrayList, z3, z4);
            }
            return this.dxx.a(z, ayC, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dhN != null) {
            if (this.dhN.ayD()) {
                this.dxy.resetData();
            } else {
                this.dxx.resetData();
            }
        }
    }

    public boolean bu(List<Long> list) {
        if (this.dhN == null || this.dhN.ayD()) {
            return false;
        }
        return this.dxx.bu(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dhN != null && this.dhC != null && lVar != null) {
            this.dxw.dhD = System.currentTimeMillis();
            if (this.dhN.ayD()) {
                if (this.dxy.ats() == 1 && !this.dhN.Ax()) {
                    this.dxy.setSortType(this.dhN.UG());
                    this.dxy.ayk();
                    int pn = this.dxy.getPn();
                    this.dxy.setPn(pn);
                    this.dhN.kX(pn + 1);
                }
            } else if (this.dhN.ayt() == 1) {
                if (!this.dxx.isLoading && !this.dhN.Ax()) {
                    int pn2 = this.dxx.getPn();
                    if (this.dxx.bu(lVar.bvg())) {
                        this.dxx.ayk();
                        this.dxx.setSortType(this.dhN.UG());
                        this.dxx.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.bvg(), str, pn2);
                    } else if (this.dxx.ats() == 1) {
                        this.dxx.ayk();
                        this.dxx.setPn(pn2);
                        this.dhN.kX(pn2 + 1);
                        this.dxx.loadingDone = false;
                        this.dxx.loadIndex = 0;
                    }
                }
            } else if (!this.dhN.ayw()) {
                this.dhN.akt();
            }
        }
    }

    public int ats() {
        if (this.dhN == null) {
            return -1;
        }
        if (this.dhN.ayD()) {
            return this.dxy.ats();
        }
        return this.dxx.ats();
    }

    public void setHasMore(int i) {
        if (this.dhN != null) {
            if (this.dhN.ayD()) {
                this.dxy.setHasMore(i);
            } else {
                this.dxx.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dhN == null) {
            return 1;
        }
        if (this.dhN.ayD()) {
            return this.dxy.getPn();
        }
        return this.dxx.getPn();
    }

    public void setPn(int i) {
        if (this.dhN != null) {
            if (this.dhN.ayD()) {
                this.dxy.setPn(i);
            } else {
                this.dxx.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dhN.ayD() ? this.dxy.getDataList() : this.dhN.ayy();
    }

    public FrsSmartLoadMoreModel ayn() {
        return this.dxy;
    }
}
