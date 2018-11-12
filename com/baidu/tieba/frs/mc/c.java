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
    private final k dBE;
    private final FrsModelController dBO;
    private final FrsFragment dTm;
    private final FrsLoadMoreModel dTn;
    private final FrsSmartLoadMoreModel dTo;
    private final a dTp = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dBE != null && c.this.dBE.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dBE.getListView().getData();
                if (!v.I(data) && c.this.dBE.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.e(data, i)) != null) {
                    c.this.dBE.getListView().getAdapter().notifyItemRemoved(i);
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
        this.dTm = frsFragment;
        this.dTn = new FrsLoadMoreModel(frsFragment, iVar);
        this.dTo = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dTo.a(this.dTp);
        this.dTn.a(this.dTp);
        this.dBE = frsFragment.ayY();
        this.dBO = frsFragment.ayT();
        this.dTo.setSortType(this.dBO.aaT());
        this.dTn.setSortType(this.dBO.aaT());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dBO != null) {
            boolean aEJ = this.dTm.ayT().aEJ();
            if (this.dBO.aEK()) {
                return this.dTo.a(z, aEJ, arrayList, z3, z4);
            }
            return this.dTn.a(z, aEJ, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dBO != null) {
            if (this.dBO.aEK()) {
                this.dTo.resetData();
            } else {
                this.dTn.resetData();
            }
        }
    }

    public boolean bM(List<Long> list) {
        if (this.dBO == null || this.dBO.aEK()) {
            return false;
        }
        return this.dTn.bM(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dBO != null && this.dBE != null && lVar != null) {
            this.dTm.dBF = System.currentTimeMillis();
            if (this.dBO.aEK()) {
                if (this.dTo.ayZ() == 1 && !this.dBO.Ee()) {
                    this.dTo.setSortType(this.dBO.aaT());
                    this.dTo.aEr();
                    int pn = this.dTo.getPn();
                    this.dTo.setPn(pn);
                    this.dBO.mH(pn + 1);
                }
            } else if (this.dBO.aEA() == 1) {
                if (!this.dTn.isLoading && !this.dBO.Ee()) {
                    int pn2 = this.dTn.getPn();
                    if (this.dTn.bM(lVar.bzC())) {
                        this.dTn.aEr();
                        this.dTn.setSortType(this.dBO.aaT());
                        this.dTn.a(com.baidu.adp.lib.g.b.d(str2, 0L), lVar.bzC(), str, pn2, lVar.isBrandForum);
                    } else if (this.dTn.ayZ() == 1) {
                        this.dTn.aEr();
                        this.dTn.setPn(pn2);
                        this.dBO.mH(pn2 + 1);
                        this.dTn.loadingDone = false;
                        this.dTn.loadIndex = 0;
                    }
                }
            } else if (!this.dBO.aED()) {
                this.dBO.apa();
            }
        }
    }

    public int ayZ() {
        if (this.dBO == null) {
            return -1;
        }
        if (this.dBO.aEK()) {
            return this.dTo.ayZ();
        }
        return this.dTn.ayZ();
    }

    public void setHasMore(int i) {
        if (this.dBO != null) {
            if (this.dBO.aEK()) {
                this.dTo.setHasMore(i);
            } else {
                this.dTn.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dBO == null) {
            return 1;
        }
        if (this.dBO.aEK()) {
            return this.dTo.getPn();
        }
        return this.dTn.getPn();
    }

    public void setPn(int i) {
        if (this.dBO != null) {
            if (this.dBO.aEK()) {
                this.dTo.setPn(i);
            } else {
                this.dTn.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dBO.aEK() ? this.dTo.getDataList() : this.dBO.aEF();
    }

    public FrsSmartLoadMoreModel aEu() {
        return this.dTo;
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dBO.aEK()) {
                this.dTo.ab(bbVar);
            } else {
                this.dTn.ab(bbVar);
            }
        }
    }
}
