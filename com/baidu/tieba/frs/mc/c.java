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
    private final FrsFragment fMP;
    private final FrsLoadMoreModel fMQ;
    private final FrsSmartLoadMoreModel fMR;
    private final a fMS = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.fuo != null && c.this.fuo.getListView() != null) {
                List<m> data = c.this.fuo.getListView().getData();
                if (!v.aa(data) && c.this.fuo.getListView().getAdapter() != null && ((m) v.d(data, i)) != null) {
                    c.this.fuo.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController fuF;
    private final com.baidu.tieba.frs.k fuo;

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fMP = frsFragment;
        this.fMQ = new FrsLoadMoreModel(frsFragment, kVar);
        this.fMR = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fMR.a(this.fMS);
        this.fMQ.a(this.fMS);
        this.fuo = frsFragment.blY();
        this.fuF = frsFragment.blT();
        this.fMR.setSortType(this.fuF.getSortType());
        this.fMQ.setSortType(this.fuF.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.fuF != null) {
            boolean brC = this.fMP.blT().brC();
            if (this.fuF.brD()) {
                return this.fMR.a(z, brC, arrayList, z3, z4);
            }
            return this.fMQ.a(z, brC, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.fuF != null) {
            if (this.fuF.brD()) {
                this.fMR.resetData();
            } else {
                this.fMQ.resetData();
            }
        }
    }

    public boolean ci(List<Long> list) {
        if (this.fuF == null || this.fuF.brD()) {
            return false;
        }
        return this.fMQ.ci(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.fuF != null && this.fuo != null && frsViewData != null) {
            this.fMP.fut = System.currentTimeMillis();
            if (this.fuF.brD()) {
                if (this.fMR.blZ() == 1 && !this.fuF.pP()) {
                    this.fMR.setSortType(this.fuF.getSortType());
                    this.fMR.brl();
                    int pn = this.fMR.getPn();
                    this.fMR.setPn(pn);
                    this.fuF.sx(pn + 1);
                }
            } else if (this.fuF.bru() == 1) {
                if (!this.fMQ.isLoading && !this.fuF.pP()) {
                    int pn2 = this.fMQ.getPn();
                    if (this.fMQ.ci(frsViewData.getThreadListIds())) {
                        this.fMQ.brl();
                        this.fMQ.setSortType(this.fuF.getSortType());
                        this.fMQ.a(com.baidu.adp.lib.g.b.c(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fMQ.blZ() == 1) {
                        this.fMQ.brl();
                        this.fMQ.setPn(pn2);
                        this.fuF.sx(pn2 + 1);
                        this.fMQ.loadingDone = false;
                        this.fMQ.loadIndex = 0;
                    }
                }
            } else if (!this.fuF.brw()) {
                this.fuF.bbc();
            }
        }
    }

    public int blZ() {
        if (this.fuF == null) {
            return -1;
        }
        if (this.fuF.brD()) {
            return this.fMR.blZ();
        }
        return this.fMQ.blZ();
    }

    public void setHasMore(int i) {
        if (this.fuF != null) {
            if (this.fuF.brD()) {
                this.fMR.setHasMore(i);
            } else {
                this.fMQ.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.fuF == null) {
            return 1;
        }
        if (this.fuF.brD()) {
            return this.fMR.getPn();
        }
        return this.fMQ.getPn();
    }

    public void setPn(int i) {
        if (this.fuF != null) {
            if (this.fuF.brD()) {
                this.fMR.setPn(i);
            } else {
                this.fMQ.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.fuF.brD() ? this.fMR.getDataList() : this.fuF.bry();
    }

    public FrsSmartLoadMoreModel bro() {
        return this.fMR;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fuF.brD()) {
                this.fMR.e(mVar);
            } else {
                this.fMQ.e(mVar);
            }
        }
    }
}
