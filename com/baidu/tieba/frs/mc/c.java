package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final FrsFragment gGR;
    private final FrsLoadMoreModel gGS;
    private final FrsSmartLoadMoreModel gGT;
    private final a gGU = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.goz != null && c.this.goz.getListView() != null) {
                List<m> data = c.this.goz.getListView().getData();
                if (!v.isEmpty(data) && c.this.goz.getListView().getAdapter() != null && ((m) v.remove(data, i)) != null) {
                    c.this.goz.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController goP;
    private final com.baidu.tieba.frs.l goz;

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.gGR = frsFragment;
        this.gGS = new FrsLoadMoreModel(frsFragment, kVar);
        this.gGT = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.gGT.a(this.gGU);
        this.gGS.a(this.gGU);
        this.goz = frsFragment.bDQ();
        this.goP = frsFragment.bDL();
        this.gGT.setSortType(this.goP.getSortType());
        this.gGS.setSortType(this.goP.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.goP != null) {
            boolean bJt = this.gGR.bDL().bJt();
            if (this.goP.bJu()) {
                return this.gGT.a(z, bJt, arrayList, z3, z4);
            }
            return this.gGS.a(z, bJt, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.goP != null) {
            if (this.goP.bJu()) {
                this.gGT.resetData();
            } else {
                this.gGS.resetData();
            }
        }
    }

    public boolean cn(List<Long> list) {
        if (this.goP == null || this.goP.bJu()) {
            return false;
        }
        return this.gGS.cn(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.goP != null && this.goz != null && frsViewData != null) {
            this.gGR.goE = System.currentTimeMillis();
            if (this.goP.bJu()) {
                if (this.gGT.bDR() == 1 && !this.goP.isLoading()) {
                    this.gGT.setSortType(this.goP.getSortType());
                    this.gGT.bJb();
                    int pn = this.gGT.getPn();
                    this.gGT.setPn(pn);
                    this.goP.tK(pn + 1);
                }
            } else if (this.goP.bJl() == 1) {
                if (!this.gGS.isLoading && !this.goP.isLoading()) {
                    int pn2 = this.gGS.getPn();
                    if (this.gGS.cn(frsViewData.getThreadListIds())) {
                        this.gGS.bJb();
                        this.gGS.setSortType(this.goP.getSortType());
                        this.gGS.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.gGS.bDR() == 1) {
                        this.gGS.bJb();
                        this.gGS.setPn(pn2);
                        this.goP.tK(pn2 + 1);
                        this.gGS.loadingDone = false;
                        this.gGS.loadIndex = 0;
                    }
                }
            } else if (!this.goP.bJn()) {
                this.goP.bvQ();
            }
        }
    }

    public int bDR() {
        if (this.goP == null) {
            return -1;
        }
        if (this.goP.bJu()) {
            return this.gGT.bDR();
        }
        return this.gGS.bDR();
    }

    public void setHasMore(int i) {
        if (this.goP != null) {
            if (this.goP.bJu()) {
                this.gGT.setHasMore(i);
            } else {
                this.gGS.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.goP == null) {
            return 1;
        }
        if (this.goP.bJu()) {
            return this.gGT.getPn();
        }
        return this.gGS.getPn();
    }

    public void setPn(int i) {
        if (this.goP != null) {
            if (this.goP.bJu()) {
                this.gGT.setPn(i);
            } else {
                this.gGS.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.goP.bJu() ? this.gGT.getDataList() : this.goP.bJp();
    }

    public FrsSmartLoadMoreModel bJe() {
        return this.gGT;
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.goP.bJu()) {
                this.gGT.d(mVar);
            } else {
                this.gGS.d(mVar);
            }
        }
    }
}
