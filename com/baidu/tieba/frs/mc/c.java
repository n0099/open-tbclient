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
    private final k dLA;
    private final FrsModelController dLK;
    private final FrsFragment edm;
    private final FrsLoadMoreModel edn;
    private final FrsSmartLoadMoreModel edo;
    private final a edp = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dLA != null && c.this.dLA.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dLA.getListView().getData();
                if (!v.I(data) && c.this.dLA.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.e(data, i)) != null) {
                    c.this.dLA.getListView().getAdapter().notifyItemRemoved(i);
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
        this.edm = frsFragment;
        this.edn = new FrsLoadMoreModel(frsFragment, iVar);
        this.edo = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.edo.a(this.edp);
        this.edn.a(this.edp);
        this.dLA = frsFragment.aBU();
        this.dLK = frsFragment.aBP();
        this.edo.setSortType(this.dLK.acy());
        this.edn.setSortType(this.dLK.acy());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dLK != null) {
            boolean aHH = this.edm.aBP().aHH();
            if (this.dLK.aHI()) {
                return this.edo.a(z, aHH, arrayList, z3, z4);
            }
            return this.edn.a(z, aHH, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dLK != null) {
            if (this.dLK.aHI()) {
                this.edo.resetData();
            } else {
                this.edn.resetData();
            }
        }
    }

    public boolean bQ(List<Long> list) {
        if (this.dLK == null || this.dLK.aHI()) {
            return false;
        }
        return this.edn.bQ(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dLK != null && this.dLA != null && lVar != null) {
            this.edm.dLB = System.currentTimeMillis();
            if (this.dLK.aHI()) {
                if (this.edo.aBV() == 1 && !this.dLK.Fv()) {
                    this.edo.setSortType(this.dLK.acy());
                    this.edo.aHp();
                    int pn = this.edo.getPn();
                    this.edo.setPn(pn);
                    this.dLK.nl(pn + 1);
                }
            } else if (this.dLK.aHy() == 1) {
                if (!this.edn.isLoading && !this.dLK.Fv()) {
                    int pn2 = this.edn.getPn();
                    if (this.edn.bQ(lVar.bCW())) {
                        this.edn.aHp();
                        this.edn.setSortType(this.dLK.acy());
                        this.edn.a(com.baidu.adp.lib.g.b.d(str2, 0L), lVar.bCW(), str, pn2, lVar.isBrandForum);
                    } else if (this.edn.aBV() == 1) {
                        this.edn.aHp();
                        this.edn.setPn(pn2);
                        this.dLK.nl(pn2 + 1);
                        this.edn.loadingDone = false;
                        this.edn.loadIndex = 0;
                    }
                }
            } else if (!this.dLK.aHB()) {
                this.dLK.asa();
            }
        }
    }

    public int aBV() {
        if (this.dLK == null) {
            return -1;
        }
        if (this.dLK.aHI()) {
            return this.edo.aBV();
        }
        return this.edn.aBV();
    }

    public void setHasMore(int i) {
        if (this.dLK != null) {
            if (this.dLK.aHI()) {
                this.edo.setHasMore(i);
            } else {
                this.edn.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dLK == null) {
            return 1;
        }
        if (this.dLK.aHI()) {
            return this.edo.getPn();
        }
        return this.edn.getPn();
    }

    public void setPn(int i) {
        if (this.dLK != null) {
            if (this.dLK.aHI()) {
                this.edo.setPn(i);
            } else {
                this.edn.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dLK.aHI() ? this.edo.getDataList() : this.dLK.aHD();
    }

    public FrsSmartLoadMoreModel aHs() {
        return this.edo;
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dLK.aHI()) {
                this.edo.ab(bbVar);
            } else {
                this.edn.ab(bbVar);
            }
        }
    }
}
