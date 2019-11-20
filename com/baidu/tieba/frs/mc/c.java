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
    private final FrsFragment fNh;
    private final FrsLoadMoreModel fNi;
    private final FrsSmartLoadMoreModel fNj;
    private final a fNk = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.fux != null && c.this.fux.getListView() != null) {
                List<m> data = c.this.fux.getListView().getData();
                if (!v.isEmpty(data) && c.this.fux.getListView().getAdapter() != null && ((m) v.remove(data, i)) != null) {
                    c.this.fux.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController fuO;
    private final com.baidu.tieba.frs.k fux;

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fNh = frsFragment;
        this.fNi = new FrsLoadMoreModel(frsFragment, kVar);
        this.fNj = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fNj.a(this.fNk);
        this.fNi.a(this.fNk);
        this.fux = frsFragment.bjN();
        this.fuO = frsFragment.bjI();
        this.fNj.setSortType(this.fuO.getSortType());
        this.fNi.setSortType(this.fuO.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.fuO != null) {
            boolean bpq = this.fNh.bjI().bpq();
            if (this.fuO.bpr()) {
                return this.fNj.a(z, bpq, arrayList, z3, z4);
            }
            return this.fNi.a(z, bpq, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.fuO != null) {
            if (this.fuO.bpr()) {
                this.fNj.resetData();
            } else {
                this.fNi.resetData();
            }
        }
    }

    public boolean cv(List<Long> list) {
        if (this.fuO == null || this.fuO.bpr()) {
            return false;
        }
        return this.fNi.cv(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.fuO != null && this.fux != null && frsViewData != null) {
            this.fNh.fuC = System.currentTimeMillis();
            if (this.fuO.bpr()) {
                if (this.fNj.bjO() == 1 && !this.fuO.isLoading()) {
                    this.fNj.setSortType(this.fuO.getSortType());
                    this.fNj.boY();
                    int pn = this.fNj.getPn();
                    this.fNj.setPn(pn);
                    this.fuO.rt(pn + 1);
                }
            } else if (this.fuO.bpi() == 1) {
                if (!this.fNi.isLoading && !this.fuO.isLoading()) {
                    int pn2 = this.fNi.getPn();
                    if (this.fNi.cv(frsViewData.getThreadListIds())) {
                        this.fNi.boY();
                        this.fNi.setSortType(this.fuO.getSortType());
                        this.fNi.a(com.baidu.adp.lib.g.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fNi.bjO() == 1) {
                        this.fNi.boY();
                        this.fNi.setPn(pn2);
                        this.fuO.rt(pn2 + 1);
                        this.fNi.loadingDone = false;
                        this.fNi.loadIndex = 0;
                    }
                }
            } else if (!this.fuO.bpk()) {
                this.fuO.bbJ();
            }
        }
    }

    public int bjO() {
        if (this.fuO == null) {
            return -1;
        }
        if (this.fuO.bpr()) {
            return this.fNj.bjO();
        }
        return this.fNi.bjO();
    }

    public void setHasMore(int i) {
        if (this.fuO != null) {
            if (this.fuO.bpr()) {
                this.fNj.setHasMore(i);
            } else {
                this.fNi.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.fuO == null) {
            return 1;
        }
        if (this.fuO.bpr()) {
            return this.fNj.getPn();
        }
        return this.fNi.getPn();
    }

    public void setPn(int i) {
        if (this.fuO != null) {
            if (this.fuO.bpr()) {
                this.fNj.setPn(i);
            } else {
                this.fNi.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.fuO.bpr() ? this.fNj.getDataList() : this.fuO.bpm();
    }

    public FrsSmartLoadMoreModel bpb() {
        return this.fNj;
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.fuO.bpr()) {
                this.fNj.d(mVar);
            } else {
                this.fNi.d(mVar);
            }
        }
    }
}
