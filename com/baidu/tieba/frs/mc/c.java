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
    private final k dId;
    private final FrsModelController dIn;
    private final FrsFragment dZP;
    private final FrsLoadMoreModel dZQ;
    private final FrsSmartLoadMoreModel dZR;
    private final a dZS = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dId != null && c.this.dId.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dId.getListView().getData();
                if (!v.I(data) && c.this.dId.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.e(data, i)) != null) {
                    c.this.dId.getListView().getAdapter().notifyItemRemoved(i);
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
        this.dZP = frsFragment;
        this.dZQ = new FrsLoadMoreModel(frsFragment, iVar);
        this.dZR = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dZR.a(this.dZS);
        this.dZQ.a(this.dZS);
        this.dId = frsFragment.aAI();
        this.dIn = frsFragment.aAD();
        this.dZR.setSortType(this.dIn.abZ());
        this.dZQ.setSortType(this.dIn.abZ());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dIn != null) {
            boolean aGv = this.dZP.aAD().aGv();
            if (this.dIn.aGw()) {
                return this.dZR.a(z, aGv, arrayList, z3, z4);
            }
            return this.dZQ.a(z, aGv, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dIn != null) {
            if (this.dIn.aGw()) {
                this.dZR.resetData();
            } else {
                this.dZQ.resetData();
            }
        }
    }

    public boolean bO(List<Long> list) {
        if (this.dIn == null || this.dIn.aGw()) {
            return false;
        }
        return this.dZQ.bO(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dIn != null && this.dId != null && lVar != null) {
            this.dZP.dIe = System.currentTimeMillis();
            if (this.dIn.aGw()) {
                if (this.dZR.aAJ() == 1 && !this.dIn.Fi()) {
                    this.dZR.setSortType(this.dIn.abZ());
                    this.dZR.aGd();
                    int pn = this.dZR.getPn();
                    this.dZR.setPn(pn);
                    this.dIn.mX(pn + 1);
                }
            } else if (this.dIn.aGm() == 1) {
                if (!this.dZQ.isLoading && !this.dIn.Fi()) {
                    int pn2 = this.dZQ.getPn();
                    if (this.dZQ.bO(lVar.bBv())) {
                        this.dZQ.aGd();
                        this.dZQ.setSortType(this.dIn.abZ());
                        this.dZQ.a(com.baidu.adp.lib.g.b.d(str2, 0L), lVar.bBv(), str, pn2, lVar.isBrandForum);
                    } else if (this.dZQ.aAJ() == 1) {
                        this.dZQ.aGd();
                        this.dZQ.setPn(pn2);
                        this.dIn.mX(pn2 + 1);
                        this.dZQ.loadingDone = false;
                        this.dZQ.loadIndex = 0;
                    }
                }
            } else if (!this.dIn.aGp()) {
                this.dIn.aqN();
            }
        }
    }

    public int aAJ() {
        if (this.dIn == null) {
            return -1;
        }
        if (this.dIn.aGw()) {
            return this.dZR.aAJ();
        }
        return this.dZQ.aAJ();
    }

    public void setHasMore(int i) {
        if (this.dIn != null) {
            if (this.dIn.aGw()) {
                this.dZR.setHasMore(i);
            } else {
                this.dZQ.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dIn == null) {
            return 1;
        }
        if (this.dIn.aGw()) {
            return this.dZR.getPn();
        }
        return this.dZQ.getPn();
    }

    public void setPn(int i) {
        if (this.dIn != null) {
            if (this.dIn.aGw()) {
                this.dZR.setPn(i);
            } else {
                this.dZQ.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dIn.aGw() ? this.dZR.getDataList() : this.dIn.aGr();
    }

    public FrsSmartLoadMoreModel aGg() {
        return this.dZR;
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dIn.aGw()) {
                this.dZR.ab(bbVar);
            } else {
                this.dZQ.ab(bbVar);
            }
        }
    }
}
