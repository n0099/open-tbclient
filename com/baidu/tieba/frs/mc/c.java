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
    private final FrsFragment gGD;
    private final FrsLoadMoreModel gGE;
    private final FrsSmartLoadMoreModel gGF;
    private final a gGG = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.gok != null && c.this.gok.getListView() != null) {
                List<m> data = c.this.gok.getListView().getData();
                if (!v.isEmpty(data) && c.this.gok.getListView().getAdapter() != null && ((m) v.remove(data, i)) != null) {
                    c.this.gok.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController goA;
    private final com.baidu.tieba.frs.l gok;

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.gGD = frsFragment;
        this.gGE = new FrsLoadMoreModel(frsFragment, kVar);
        this.gGF = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.gGF.a(this.gGG);
        this.gGE.a(this.gGG);
        this.gok = frsFragment.bDN();
        this.goA = frsFragment.bDI();
        this.gGF.setSortType(this.goA.getSortType());
        this.gGE.setSortType(this.goA.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.goA != null) {
            boolean bJq = this.gGD.bDI().bJq();
            if (this.goA.bJr()) {
                return this.gGF.a(z, bJq, arrayList, z3, z4);
            }
            return this.gGE.a(z, bJq, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.goA != null) {
            if (this.goA.bJr()) {
                this.gGF.resetData();
            } else {
                this.gGE.resetData();
            }
        }
    }

    public boolean cn(List<Long> list) {
        if (this.goA == null || this.goA.bJr()) {
            return false;
        }
        return this.gGE.cn(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.goA != null && this.gok != null && frsViewData != null) {
            this.gGD.gop = System.currentTimeMillis();
            if (this.goA.bJr()) {
                if (this.gGF.bDO() == 1 && !this.goA.isLoading()) {
                    this.gGF.setSortType(this.goA.getSortType());
                    this.gGF.bIY();
                    int pn = this.gGF.getPn();
                    this.gGF.setPn(pn);
                    this.goA.tK(pn + 1);
                }
            } else if (this.goA.bJi() == 1) {
                if (!this.gGE.isLoading && !this.goA.isLoading()) {
                    int pn2 = this.gGE.getPn();
                    if (this.gGE.cn(frsViewData.getThreadListIds())) {
                        this.gGE.bIY();
                        this.gGE.setSortType(this.goA.getSortType());
                        this.gGE.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.gGE.bDO() == 1) {
                        this.gGE.bIY();
                        this.gGE.setPn(pn2);
                        this.goA.tK(pn2 + 1);
                        this.gGE.loadingDone = false;
                        this.gGE.loadIndex = 0;
                    }
                }
            } else if (!this.goA.bJk()) {
                this.goA.bvN();
            }
        }
    }

    public int bDO() {
        if (this.goA == null) {
            return -1;
        }
        if (this.goA.bJr()) {
            return this.gGF.bDO();
        }
        return this.gGE.bDO();
    }

    public void setHasMore(int i) {
        if (this.goA != null) {
            if (this.goA.bJr()) {
                this.gGF.setHasMore(i);
            } else {
                this.gGE.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.goA == null) {
            return 1;
        }
        if (this.goA.bJr()) {
            return this.gGF.getPn();
        }
        return this.gGE.getPn();
    }

    public void setPn(int i) {
        if (this.goA != null) {
            if (this.goA.bJr()) {
                this.gGF.setPn(i);
            } else {
                this.gGE.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.goA.bJr() ? this.gGF.getDataList() : this.goA.bJm();
    }

    public FrsSmartLoadMoreModel bJb() {
        return this.gGF;
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.goA.bJr()) {
                this.gGF.d(mVar);
            } else {
                this.gGE.d(mVar);
            }
        }
    }
}
