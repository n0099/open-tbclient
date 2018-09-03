package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final FrsFragment dDt;
    private final FrsLoadMoreModel dDu;
    private final FrsSmartLoadMoreModel dDv;
    private final a dDw = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dmo != null && c.this.dmo.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dmo.getListView().getData();
                if (!w.z(data) && c.this.dmo.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) w.e(data, i)) != null) {
                    c.this.dmo.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final k dmo;
    private final FrsModelController dmz;

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, i iVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dDt = frsFragment;
        this.dDu = new FrsLoadMoreModel(frsFragment, iVar);
        this.dDv = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dDv.a(this.dDw);
        this.dDu.a(this.dDw);
        this.dmo = frsFragment.aul();
        this.dmz = frsFragment.aug();
        this.dDv.setSortType(this.dmz.Vo());
        this.dDu.setSortType(this.dmz.Vo());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dmz != null) {
            boolean azL = this.dDt.aug().azL();
            if (this.dmz.azM()) {
                return this.dDv.a(z, azL, arrayList, z3, z4);
            }
            return this.dDu.a(z, azL, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dmz != null) {
            if (this.dmz.azM()) {
                this.dDv.resetData();
            } else {
                this.dDu.resetData();
            }
        }
    }

    public boolean bx(List<Long> list) {
        if (this.dmz == null || this.dmz.azM()) {
            return false;
        }
        return this.dDu.bx(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dmz != null && this.dmo != null && lVar != null) {
            this.dDt.dmp = System.currentTimeMillis();
            if (this.dmz.azM()) {
                if (this.dDv.aum() == 1 && !this.dmz.AB()) {
                    this.dDv.setSortType(this.dmz.Vo());
                    this.dDv.azu();
                    int pn = this.dDv.getPn();
                    this.dDv.setPn(pn);
                    this.dmz.lp(pn + 1);
                }
            } else if (this.dmz.azC() == 1) {
                if (!this.dDu.isLoading && !this.dmz.AB()) {
                    int pn2 = this.dDu.getPn();
                    if (this.dDu.bx(lVar.bul())) {
                        this.dDu.azu();
                        this.dDu.setSortType(this.dmz.Vo());
                        this.dDu.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.bul(), str, pn2, lVar.isBrandForum);
                    } else if (this.dDu.aum() == 1) {
                        this.dDu.azu();
                        this.dDu.setPn(pn2);
                        this.dmz.lp(pn2 + 1);
                        this.dDu.loadingDone = false;
                        this.dDu.loadIndex = 0;
                    }
                }
            } else if (!this.dmz.azF()) {
                this.dmz.ako();
            }
        }
    }

    public int aum() {
        if (this.dmz == null) {
            return -1;
        }
        if (this.dmz.azM()) {
            return this.dDv.aum();
        }
        return this.dDu.aum();
    }

    public void setHasMore(int i) {
        if (this.dmz != null) {
            if (this.dmz.azM()) {
                this.dDv.setHasMore(i);
            } else {
                this.dDu.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dmz == null) {
            return 1;
        }
        if (this.dmz.azM()) {
            return this.dDv.getPn();
        }
        return this.dDu.getPn();
    }

    public void setPn(int i) {
        if (this.dmz != null) {
            if (this.dmz.azM()) {
                this.dDv.setPn(i);
            } else {
                this.dDu.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dmz.azM() ? this.dDv.getDataList() : this.dmz.azH();
    }

    public FrsSmartLoadMoreModel azx() {
        return this.dDv;
    }

    public void aa(bb bbVar) {
        if (bbVar != null) {
            if (this.dmz.azM()) {
                this.dDv.aa(bbVar);
            } else {
                this.dDu.aa(bbVar);
            }
        }
    }
}
