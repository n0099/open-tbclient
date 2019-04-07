package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private final com.baidu.tieba.frs.k eYE;
    private final FrsModelController eYV;
    private final FrsFragment fqE;
    private final FrsLoadMoreModel fqF;
    private final FrsSmartLoadMoreModel fqG;
    private final a fqH = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.eYE != null && c.this.eYE.getListView() != null) {
                List<m> data = c.this.eYE.getListView().getData();
                if (!v.T(data) && c.this.eYE.getListView().getAdapter() != null && ((m) v.d(data, i)) != null) {
                    c.this.eYE.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fqE = frsFragment;
        this.fqF = new FrsLoadMoreModel(frsFragment, kVar);
        this.fqG = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fqG.a(this.fqH);
        this.fqF.a(this.fqH);
        this.eYE = frsFragment.bcs();
        this.eYV = frsFragment.bcn();
        this.fqG.setSortType(this.eYV.getSortType());
        this.fqF.setSortType(this.eYV.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.eYV != null) {
            boolean bhQ = this.fqE.bcn().bhQ();
            if (this.eYV.bhR()) {
                return this.fqG.a(z, bhQ, arrayList, z3, z4);
            }
            return this.fqF.a(z, bhQ, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.eYV != null) {
            if (this.eYV.bhR()) {
                this.fqG.resetData();
            } else {
                this.fqF.resetData();
            }
        }
    }

    public boolean ca(List<Long> list) {
        if (this.eYV == null || this.eYV.bhR()) {
            return false;
        }
        return this.fqF.ca(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.eYV != null && this.eYE != null && frsViewData != null) {
            this.fqE.eYJ = System.currentTimeMillis();
            if (this.eYV.bhR()) {
                if (this.fqG.bct() == 1 && !this.eYV.qz()) {
                    this.fqG.setSortType(this.eYV.getSortType());
                    this.fqG.bhz();
                    int pn = this.fqG.getPn();
                    this.fqG.setPn(pn);
                    this.eYV.qV(pn + 1);
                }
            } else if (this.eYV.bhI() == 1) {
                if (!this.fqF.isLoading && !this.eYV.qz()) {
                    int pn2 = this.fqF.getPn();
                    if (this.fqF.ca(frsViewData.getThreadListIds())) {
                        this.fqF.bhz();
                        this.fqF.setSortType(this.eYV.getSortType());
                        this.fqF.a(com.baidu.adp.lib.g.b.d(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fqF.bct() == 1) {
                        this.fqF.bhz();
                        this.fqF.setPn(pn2);
                        this.eYV.qV(pn2 + 1);
                        this.fqF.loadingDone = false;
                        this.fqF.loadIndex = 0;
                    }
                }
            } else if (!this.eYV.bhK()) {
                this.eYV.aRP();
            }
        }
    }

    public int bct() {
        if (this.eYV == null) {
            return -1;
        }
        if (this.eYV.bhR()) {
            return this.fqG.bct();
        }
        return this.fqF.bct();
    }

    public void setHasMore(int i) {
        if (this.eYV != null) {
            if (this.eYV.bhR()) {
                this.fqG.setHasMore(i);
            } else {
                this.fqF.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.eYV == null) {
            return 1;
        }
        if (this.eYV.bhR()) {
            return this.fqG.getPn();
        }
        return this.fqF.getPn();
    }

    public void setPn(int i) {
        if (this.eYV != null) {
            if (this.eYV.bhR()) {
                this.fqG.setPn(i);
            } else {
                this.fqF.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.eYV.bhR() ? this.fqG.getDataList() : this.eYV.bhM();
    }

    public FrsSmartLoadMoreModel bhC() {
        return this.fqG;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.eYV.bhR()) {
                this.fqG.e(mVar);
            } else {
                this.fqF.e(mVar);
            }
        }
    }
}
