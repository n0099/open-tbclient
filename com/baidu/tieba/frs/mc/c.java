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
    private final k dKR;
    private final FrsModelController dLb;
    private final FrsFragment ecG;
    private final FrsLoadMoreModel ecH;
    private final FrsSmartLoadMoreModel ecI;
    private final a ecJ = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dKR != null && c.this.dKR.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dKR.getListView().getData();
                if (!v.I(data) && c.this.dKR.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.e(data, i)) != null) {
                    c.this.dKR.getListView().getAdapter().notifyItemRemoved(i);
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
        this.ecG = frsFragment;
        this.ecH = new FrsLoadMoreModel(frsFragment, iVar);
        this.ecI = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.ecI.a(this.ecJ);
        this.ecH.a(this.ecJ);
        this.dKR = frsFragment.aBx();
        this.dLb = frsFragment.aBs();
        this.ecI.setSortType(this.dLb.acb());
        this.ecH.setSortType(this.dLb.acb());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dLb != null) {
            boolean aHk = this.ecG.aBs().aHk();
            if (this.dLb.aHl()) {
                return this.ecI.a(z, aHk, arrayList, z3, z4);
            }
            return this.ecH.a(z, aHk, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dLb != null) {
            if (this.dLb.aHl()) {
                this.ecI.resetData();
            } else {
                this.ecH.resetData();
            }
        }
    }

    public boolean bP(List<Long> list) {
        if (this.dLb == null || this.dLb.aHl()) {
            return false;
        }
        return this.ecH.bP(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dLb != null && this.dKR != null && lVar != null) {
            this.ecG.dKS = System.currentTimeMillis();
            if (this.dLb.aHl()) {
                if (this.ecI.aBy() == 1 && !this.dLb.Fi()) {
                    this.ecI.setSortType(this.dLb.acb());
                    this.ecI.aGS();
                    int pn = this.ecI.getPn();
                    this.ecI.setPn(pn);
                    this.dLb.nk(pn + 1);
                }
            } else if (this.dLb.aHb() == 1) {
                if (!this.ecH.isLoading && !this.dLb.Fi()) {
                    int pn2 = this.ecH.getPn();
                    if (this.ecH.bP(lVar.bCn())) {
                        this.ecH.aGS();
                        this.ecH.setSortType(this.dLb.acb());
                        this.ecH.a(com.baidu.adp.lib.g.b.d(str2, 0L), lVar.bCn(), str, pn2, lVar.isBrandForum);
                    } else if (this.ecH.aBy() == 1) {
                        this.ecH.aGS();
                        this.ecH.setPn(pn2);
                        this.dLb.nk(pn2 + 1);
                        this.ecH.loadingDone = false;
                        this.ecH.loadIndex = 0;
                    }
                }
            } else if (!this.dLb.aHe()) {
                this.dLb.arC();
            }
        }
    }

    public int aBy() {
        if (this.dLb == null) {
            return -1;
        }
        if (this.dLb.aHl()) {
            return this.ecI.aBy();
        }
        return this.ecH.aBy();
    }

    public void setHasMore(int i) {
        if (this.dLb != null) {
            if (this.dLb.aHl()) {
                this.ecI.setHasMore(i);
            } else {
                this.ecH.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dLb == null) {
            return 1;
        }
        if (this.dLb.aHl()) {
            return this.ecI.getPn();
        }
        return this.ecH.getPn();
    }

    public void setPn(int i) {
        if (this.dLb != null) {
            if (this.dLb.aHl()) {
                this.ecI.setPn(i);
            } else {
                this.ecH.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dLb.aHl() ? this.ecI.getDataList() : this.dLb.aHg();
    }

    public FrsSmartLoadMoreModel aGV() {
        return this.ecI;
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dLb.aHl()) {
                this.ecI.ab(bbVar);
            } else {
                this.ecH.ab(bbVar);
            }
        }
    }
}
