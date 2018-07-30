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
    private final FrsFragment dDw;
    private final FrsLoadMoreModel dDx;
    private final FrsSmartLoadMoreModel dDy;
    private final a dDz = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dmq != null && c.this.dmq.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dmq.getListView().getData();
                if (!w.z(data) && c.this.dmq.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) w.e(data, i)) != null) {
                    c.this.dmq.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController dmB;
    private final k dmq;

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, i iVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dDw = frsFragment;
        this.dDx = new FrsLoadMoreModel(frsFragment, iVar);
        this.dDy = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dDy.a(this.dDz);
        this.dDx.a(this.dDz);
        this.dmq = frsFragment.aum();
        this.dmB = frsFragment.auh();
        this.dDy.setSortType(this.dmB.Vk());
        this.dDx.setSortType(this.dmB.Vk());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dmB != null) {
            boolean azO = this.dDw.auh().azO();
            if (this.dmB.azP()) {
                return this.dDy.a(z, azO, arrayList, z3, z4);
            }
            return this.dDx.a(z, azO, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dmB != null) {
            if (this.dmB.azP()) {
                this.dDy.resetData();
            } else {
                this.dDx.resetData();
            }
        }
    }

    public boolean bx(List<Long> list) {
        if (this.dmB == null || this.dmB.azP()) {
            return false;
        }
        return this.dDx.bx(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dmB != null && this.dmq != null && lVar != null) {
            this.dDw.dmr = System.currentTimeMillis();
            if (this.dmB.azP()) {
                if (this.dDy.aun() == 1 && !this.dmB.AE()) {
                    this.dDy.setSortType(this.dmB.Vk());
                    this.dDy.azw();
                    int pn = this.dDy.getPn();
                    this.dDy.setPn(pn);
                    this.dmB.lp(pn + 1);
                }
            } else if (this.dmB.azF() == 1) {
                if (!this.dDx.isLoading && !this.dmB.AE()) {
                    int pn2 = this.dDx.getPn();
                    if (this.dDx.bx(lVar.buk())) {
                        this.dDx.azw();
                        this.dDx.setSortType(this.dmB.Vk());
                        this.dDx.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.buk(), str, pn2, lVar.isBrandForum);
                    } else if (this.dDx.aun() == 1) {
                        this.dDx.azw();
                        this.dDx.setPn(pn2);
                        this.dmB.lp(pn2 + 1);
                        this.dDx.loadingDone = false;
                        this.dDx.loadIndex = 0;
                    }
                }
            } else if (!this.dmB.azI()) {
                this.dmB.akm();
            }
        }
    }

    public int aun() {
        if (this.dmB == null) {
            return -1;
        }
        if (this.dmB.azP()) {
            return this.dDy.aun();
        }
        return this.dDx.aun();
    }

    public void setHasMore(int i) {
        if (this.dmB != null) {
            if (this.dmB.azP()) {
                this.dDy.setHasMore(i);
            } else {
                this.dDx.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dmB == null) {
            return 1;
        }
        if (this.dmB.azP()) {
            return this.dDy.getPn();
        }
        return this.dDx.getPn();
    }

    public void setPn(int i) {
        if (this.dmB != null) {
            if (this.dmB.azP()) {
                this.dDy.setPn(i);
            } else {
                this.dDx.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dmB.azP() ? this.dDy.getDataList() : this.dmB.azK();
    }

    public FrsSmartLoadMoreModel azz() {
        return this.dDy;
    }

    public void aa(bb bbVar) {
        if (bbVar != null) {
            if (this.dmB.azP()) {
                this.dDy.aa(bbVar);
            } else {
                this.dDx.aa(bbVar);
            }
        }
    }
}
