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
    private final k dAn;
    private final FrsModelController dAx;
    private final FrsFragment dSf;
    private final FrsLoadMoreModel dSg;
    private final FrsSmartLoadMoreModel dSh;
    private final a dSi = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dAn != null && c.this.dAn.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dAn.getListView().getData();
                if (!v.J(data) && c.this.dAn.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.e(data, i)) != null) {
                    c.this.dAn.getListView().getAdapter().notifyItemRemoved(i);
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
        this.dSf = frsFragment;
        this.dSg = new FrsLoadMoreModel(frsFragment, iVar);
        this.dSh = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dSh.a(this.dSi);
        this.dSg.a(this.dSi);
        this.dAn = frsFragment.azA();
        this.dAx = frsFragment.azv();
        this.dSh.setSortType(this.dAx.aaI());
        this.dSg.setSortType(this.dAx.aaI());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dAx != null) {
            boolean aFn = this.dSf.azv().aFn();
            if (this.dAx.aFo()) {
                return this.dSh.a(z, aFn, arrayList, z3, z4);
            }
            return this.dSg.a(z, aFn, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dAx != null) {
            if (this.dAx.aFo()) {
                this.dSh.resetData();
            } else {
                this.dSg.resetData();
            }
        }
    }

    public boolean bO(List<Long> list) {
        if (this.dAx == null || this.dAx.aFo()) {
            return false;
        }
        return this.dSg.bO(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dAx != null && this.dAn != null && lVar != null) {
            this.dSf.dAo = System.currentTimeMillis();
            if (this.dAx.aFo()) {
                if (this.dSh.azB() == 1 && !this.dAx.DU()) {
                    this.dSh.setSortType(this.dAx.aaI());
                    this.dSh.aEV();
                    int pn = this.dSh.getPn();
                    this.dSh.setPn(pn);
                    this.dAx.mp(pn + 1);
                }
            } else if (this.dAx.aFe() == 1) {
                if (!this.dSg.isLoading && !this.dAx.DU()) {
                    int pn2 = this.dSg.getPn();
                    if (this.dSg.bO(lVar.bAg())) {
                        this.dSg.aEV();
                        this.dSg.setSortType(this.dAx.aaI());
                        this.dSg.a(com.baidu.adp.lib.g.b.d(str2, 0L), lVar.bAg(), str, pn2, lVar.isBrandForum);
                    } else if (this.dSg.azB() == 1) {
                        this.dSg.aEV();
                        this.dSg.setPn(pn2);
                        this.dAx.mp(pn2 + 1);
                        this.dSg.loadingDone = false;
                        this.dSg.loadIndex = 0;
                    }
                }
            } else if (!this.dAx.aFh()) {
                this.dAx.apz();
            }
        }
    }

    public int azB() {
        if (this.dAx == null) {
            return -1;
        }
        if (this.dAx.aFo()) {
            return this.dSh.azB();
        }
        return this.dSg.azB();
    }

    public void setHasMore(int i) {
        if (this.dAx != null) {
            if (this.dAx.aFo()) {
                this.dSh.setHasMore(i);
            } else {
                this.dSg.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dAx == null) {
            return 1;
        }
        if (this.dAx.aFo()) {
            return this.dSh.getPn();
        }
        return this.dSg.getPn();
    }

    public void setPn(int i) {
        if (this.dAx != null) {
            if (this.dAx.aFo()) {
                this.dSh.setPn(i);
            } else {
                this.dSg.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dAx.aFo() ? this.dSh.getDataList() : this.dAx.aFj();
    }

    public FrsSmartLoadMoreModel aEY() {
        return this.dSh;
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dAx.aFo()) {
                this.dSh.ab(bbVar);
            } else {
                this.dSg.ab(bbVar);
            }
        }
    }
}
