package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private final k dLB;
    private final FrsModelController dLL;
    private final FrsFragment edn;
    private final FrsLoadMoreModel edo;
    private final FrsSmartLoadMoreModel edp;
    private final a edq = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dLB != null && c.this.dLB.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dLB.getListView().getData();
                if (!v.I(data) && c.this.dLB.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.e(data, i)) != null) {
                    c.this.dLB.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, i iVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.edn = frsFragment;
        this.edo = new FrsLoadMoreModel(frsFragment, iVar);
        this.edp = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.edp.a(this.edq);
        this.edo.a(this.edq);
        this.dLB = frsFragment.aBU();
        this.dLL = frsFragment.aBP();
        this.edp.setSortType(this.dLL.acy());
        this.edo.setSortType(this.dLL.acy());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dLL != null) {
            boolean aHH = this.edn.aBP().aHH();
            if (this.dLL.aHI()) {
                return this.edp.a(z, aHH, arrayList, z3, z4);
            }
            return this.edo.a(z, aHH, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dLL != null) {
            if (this.dLL.aHI()) {
                this.edp.resetData();
            } else {
                this.edo.resetData();
            }
        }
    }

    public boolean bQ(List<Long> list) {
        if (this.dLL == null || this.dLL.aHI()) {
            return false;
        }
        return this.edo.bQ(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dLL != null && this.dLB != null && lVar != null) {
            this.edn.dLC = System.currentTimeMillis();
            if (this.dLL.aHI()) {
                if (this.edp.aBV() == 1 && !this.dLL.Fv()) {
                    this.edp.setSortType(this.dLL.acy());
                    this.edp.aHp();
                    int pn = this.edp.getPn();
                    this.edp.setPn(pn);
                    this.dLL.nl(pn + 1);
                }
            } else if (this.dLL.aHy() == 1) {
                if (!this.edo.isLoading && !this.dLL.Fv()) {
                    int pn2 = this.edo.getPn();
                    if (this.edo.bQ(lVar.bCW())) {
                        this.edo.aHp();
                        this.edo.setSortType(this.dLL.acy());
                        this.edo.a(com.baidu.adp.lib.g.b.d(str2, 0L), lVar.bCW(), str, pn2, lVar.isBrandForum);
                    } else if (this.edo.aBV() == 1) {
                        this.edo.aHp();
                        this.edo.setPn(pn2);
                        this.dLL.nl(pn2 + 1);
                        this.edo.loadingDone = false;
                        this.edo.loadIndex = 0;
                    }
                }
            } else if (!this.dLL.aHB()) {
                this.dLL.asa();
            }
        }
    }

    public int aBV() {
        if (this.dLL == null) {
            return -1;
        }
        if (this.dLL.aHI()) {
            return this.edp.aBV();
        }
        return this.edo.aBV();
    }

    public void setHasMore(int i) {
        if (this.dLL != null) {
            if (this.dLL.aHI()) {
                this.edp.setHasMore(i);
            } else {
                this.edo.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dLL == null) {
            return 1;
        }
        if (this.dLL.aHI()) {
            return this.edp.getPn();
        }
        return this.edo.getPn();
    }

    public void setPn(int i) {
        if (this.dLL != null) {
            if (this.dLL.aHI()) {
                this.edp.setPn(i);
            } else {
                this.edo.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dLL.aHI() ? this.edp.getDataList() : this.dLL.aHD();
    }

    public FrsSmartLoadMoreModel aHs() {
        return this.edp;
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dLL.aHI()) {
                this.edp.ab(bbVar);
            } else {
                this.edo.ab(bbVar);
            }
        }
    }
}
