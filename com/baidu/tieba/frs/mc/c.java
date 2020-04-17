package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final FrsModelController gYG;
    private final com.baidu.tieba.frs.n gYq;
    private final FrsFragment hri;
    private final FrsLoadMoreModel hrj;
    private final FrsSmartLoadMoreModel hrk;
    private final a hrl = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.gYq != null && c.this.gYq.getListView() != null) {
                List<com.baidu.adp.widget.ListView.m> data = c.this.gYq.getListView().getData();
                if (!v.isEmpty(data) && c.this.gYq.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.m) v.remove(data, i)) != null) {
                    c.this.gYq.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.hri = frsFragment;
        this.hrj = new FrsLoadMoreModel(frsFragment, kVar);
        this.hrk = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.hrk.a(this.hrl);
        this.hrj.a(this.hrl);
        this.gYq = frsFragment.bOx();
        this.gYG = frsFragment.bOs();
        this.hrk.setSortType(this.gYG.getSortType());
        this.hrj.setSortType(this.gYG.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.gYG != null) {
            boolean bUd = this.hri.bOs().bUd();
            if (this.gYG.bUe()) {
                return this.hrk.a(z, bUd, arrayList, z3, z4);
            }
            return this.hrj.a(z, bUd, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.gYG != null) {
            if (this.gYG.bUe()) {
                this.hrk.resetData();
            } else {
                this.hrj.resetData();
            }
        }
    }

    public boolean cz(List<Long> list) {
        if (this.gYG == null || this.gYG.bUe()) {
            return false;
        }
        return this.hrj.cz(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.gYG != null && this.gYq != null && frsViewData != null) {
            this.hri.gYv = System.currentTimeMillis();
            if (this.gYG.bUe()) {
                if (this.hrk.bOy() == 1 && !this.gYG.isLoading()) {
                    this.hrk.setSortType(this.gYG.getSortType());
                    this.hrk.bTK();
                    int pn = this.hrk.getPn();
                    this.hrk.setPn(pn);
                    this.gYG.un(pn + 1);
                }
            } else if (this.gYG.bTV() == 1) {
                if (!this.hrj.isLoading && !this.gYG.isLoading()) {
                    int pn2 = this.hrj.getPn();
                    if (this.hrj.cz(frsViewData.getThreadListIds())) {
                        this.hrj.bTK();
                        this.hrj.setSortType(this.gYG.getSortType());
                        this.hrj.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.hrj.bOy() == 1) {
                        this.hrj.bTK();
                        this.hrj.setPn(pn2);
                        this.gYG.un(pn2 + 1);
                        this.hrj.loadingDone = false;
                        this.hrj.loadIndex = 0;
                    }
                }
            } else if (!this.gYG.bTX()) {
                this.gYG.bFG();
            }
        }
    }

    public int bOy() {
        if (this.gYG == null) {
            return -1;
        }
        if (this.gYG.bUe()) {
            return this.hrk.bOy();
        }
        return this.hrj.bOy();
    }

    public void setHasMore(int i) {
        if (this.gYG != null) {
            if (this.gYG.bUe()) {
                this.hrk.setHasMore(i);
            } else {
                this.hrj.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.gYG == null) {
            return 1;
        }
        if (this.gYG.bUe()) {
            return this.hrk.getPn();
        }
        return this.hrj.getPn();
    }

    public void setPn(int i) {
        if (this.gYG != null) {
            if (this.gYG.bUe()) {
                this.hrk.setPn(i);
            } else {
                this.hrj.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gYG.bUe() ? this.hrk.getDataList() : this.gYG.bTZ();
    }

    public FrsSmartLoadMoreModel bTN() {
        return this.hrk;
    }

    public void d(com.baidu.adp.widget.ListView.m mVar) {
        if (mVar != null) {
            if (this.gYG.bUe()) {
                this.hrk.d(mVar);
            } else {
                this.hrj.d(mVar);
            }
        }
    }
}
