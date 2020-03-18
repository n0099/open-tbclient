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
    private final FrsFragment gHP;
    private final FrsLoadMoreModel gHQ;
    private final FrsSmartLoadMoreModel gHR;
    private final a gHS = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.gpj != null && c.this.gpj.getListView() != null) {
                List<com.baidu.adp.widget.ListView.m> data = c.this.gpj.getListView().getData();
                if (!v.isEmpty(data) && c.this.gpj.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.m) v.remove(data, i)) != null) {
                    c.this.gpj.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.m gpj;
    private final FrsModelController gpz;

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.gHP = frsFragment;
        this.gHQ = new FrsLoadMoreModel(frsFragment, kVar);
        this.gHR = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.gHR.a(this.gHS);
        this.gHQ.a(this.gHS);
        this.gpj = frsFragment.bDY();
        this.gpz = frsFragment.bDT();
        this.gHR.setSortType(this.gpz.getSortType());
        this.gHQ.setSortType(this.gpz.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.gpz != null) {
            boolean bJG = this.gHP.bDT().bJG();
            if (this.gpz.bJH()) {
                return this.gHR.a(z, bJG, arrayList, z3, z4);
            }
            return this.gHQ.a(z, bJG, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.gpz != null) {
            if (this.gpz.bJH()) {
                this.gHR.resetData();
            } else {
                this.gHQ.resetData();
            }
        }
    }

    public boolean cn(List<Long> list) {
        if (this.gpz == null || this.gpz.bJH()) {
            return false;
        }
        return this.gHQ.cn(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.gpz != null && this.gpj != null && frsViewData != null) {
            this.gHP.gpo = System.currentTimeMillis();
            if (this.gpz.bJH()) {
                if (this.gHR.bDZ() == 1 && !this.gpz.isLoading()) {
                    this.gHR.setSortType(this.gpz.getSortType());
                    this.gHR.bJn();
                    int pn = this.gHR.getPn();
                    this.gHR.setPn(pn);
                    this.gpz.tP(pn + 1);
                }
            } else if (this.gpz.bJy() == 1) {
                if (!this.gHQ.isLoading && !this.gpz.isLoading()) {
                    int pn2 = this.gHQ.getPn();
                    if (this.gHQ.cn(frsViewData.getThreadListIds())) {
                        this.gHQ.bJn();
                        this.gHQ.setSortType(this.gpz.getSortType());
                        this.gHQ.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.gHQ.bDZ() == 1) {
                        this.gHQ.bJn();
                        this.gHQ.setPn(pn2);
                        this.gpz.tP(pn2 + 1);
                        this.gHQ.loadingDone = false;
                        this.gHQ.loadIndex = 0;
                    }
                }
            } else if (!this.gpz.bJA()) {
                this.gpz.bvV();
            }
        }
    }

    public int bDZ() {
        if (this.gpz == null) {
            return -1;
        }
        if (this.gpz.bJH()) {
            return this.gHR.bDZ();
        }
        return this.gHQ.bDZ();
    }

    public void setHasMore(int i) {
        if (this.gpz != null) {
            if (this.gpz.bJH()) {
                this.gHR.setHasMore(i);
            } else {
                this.gHQ.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.gpz == null) {
            return 1;
        }
        if (this.gpz.bJH()) {
            return this.gHR.getPn();
        }
        return this.gHQ.getPn();
    }

    public void setPn(int i) {
        if (this.gpz != null) {
            if (this.gpz.bJH()) {
                this.gHR.setPn(i);
            } else {
                this.gHQ.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gpz.bJH() ? this.gHR.getDataList() : this.gpz.bJC();
    }

    public FrsSmartLoadMoreModel bJq() {
        return this.gHR;
    }

    public void d(com.baidu.adp.widget.ListView.m mVar) {
        if (mVar != null) {
            if (this.gpz.bJH()) {
                this.gHR.d(mVar);
            } else {
                this.gHQ.d(mVar);
            }
        }
    }
}
