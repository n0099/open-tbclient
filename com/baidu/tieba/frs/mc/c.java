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
    private final FrsFragment dSg;
    private final FrsLoadMoreModel dSh;
    private final FrsSmartLoadMoreModel dSi;
    private final a dSj = new a() { // from class: com.baidu.tieba.frs.mc.c.1
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
        this.dSg = frsFragment;
        this.dSh = new FrsLoadMoreModel(frsFragment, iVar);
        this.dSi = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dSi.a(this.dSj);
        this.dSh.a(this.dSj);
        this.dAn = frsFragment.azB();
        this.dAx = frsFragment.azw();
        this.dSi.setSortType(this.dAx.aaJ());
        this.dSh.setSortType(this.dAx.aaJ());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dAx != null) {
            boolean aFn = this.dSg.azw().aFn();
            if (this.dAx.aFo()) {
                return this.dSi.a(z, aFn, arrayList, z3, z4);
            }
            return this.dSh.a(z, aFn, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dAx != null) {
            if (this.dAx.aFo()) {
                this.dSi.resetData();
            } else {
                this.dSh.resetData();
            }
        }
    }

    public boolean bO(List<Long> list) {
        if (this.dAx == null || this.dAx.aFo()) {
            return false;
        }
        return this.dSh.bO(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dAx != null && this.dAn != null && lVar != null) {
            this.dSg.dAo = System.currentTimeMillis();
            if (this.dAx.aFo()) {
                if (this.dSi.azC() == 1 && !this.dAx.DU()) {
                    this.dSi.setSortType(this.dAx.aaJ());
                    this.dSi.aEV();
                    int pn = this.dSi.getPn();
                    this.dSi.setPn(pn);
                    this.dAx.mp(pn + 1);
                }
            } else if (this.dAx.aFe() == 1) {
                if (!this.dSh.isLoading && !this.dAx.DU()) {
                    int pn2 = this.dSh.getPn();
                    if (this.dSh.bO(lVar.bAg())) {
                        this.dSh.aEV();
                        this.dSh.setSortType(this.dAx.aaJ());
                        this.dSh.a(com.baidu.adp.lib.g.b.d(str2, 0L), lVar.bAg(), str, pn2, lVar.isBrandForum);
                    } else if (this.dSh.azC() == 1) {
                        this.dSh.aEV();
                        this.dSh.setPn(pn2);
                        this.dAx.mp(pn2 + 1);
                        this.dSh.loadingDone = false;
                        this.dSh.loadIndex = 0;
                    }
                }
            } else if (!this.dAx.aFh()) {
                this.dAx.apA();
            }
        }
    }

    public int azC() {
        if (this.dAx == null) {
            return -1;
        }
        if (this.dAx.aFo()) {
            return this.dSi.azC();
        }
        return this.dSh.azC();
    }

    public void setHasMore(int i) {
        if (this.dAx != null) {
            if (this.dAx.aFo()) {
                this.dSi.setHasMore(i);
            } else {
                this.dSh.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dAx == null) {
            return 1;
        }
        if (this.dAx.aFo()) {
            return this.dSi.getPn();
        }
        return this.dSh.getPn();
    }

    public void setPn(int i) {
        if (this.dAx != null) {
            if (this.dAx.aFo()) {
                this.dSi.setPn(i);
            } else {
                this.dSh.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dAx.aFo() ? this.dSi.getDataList() : this.dAx.aFj();
    }

    public FrsSmartLoadMoreModel aEY() {
        return this.dSi;
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dAx.aFo()) {
                this.dSi.ab(bbVar);
            } else {
                this.dSh.ab(bbVar);
            }
        }
    }
}
