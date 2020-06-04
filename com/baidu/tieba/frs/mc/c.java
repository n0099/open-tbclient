package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final FrsFragment hGQ;
    private final FrsLoadMoreModel hGR;
    private final FrsSmartLoadMoreModel hGS;
    private final a hGT = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.hnt != null && c.this.hnt.getListView() != null) {
                List<o> data = c.this.hnt.getListView().getData();
                if (!v.isEmpty(data) && c.this.hnt.getListView().getAdapter() != null && ((o) v.remove(data, i)) != null) {
                    c.this.hnt.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController hnJ;
    private final com.baidu.tieba.frs.n hnt;

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.hGQ = frsFragment;
        this.hGR = new FrsLoadMoreModel(frsFragment, kVar);
        this.hGS = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.hGS.a(this.hGT);
        this.hGR.a(this.hGT);
        this.hnt = frsFragment.bUT();
        this.hnJ = frsFragment.bUO();
        this.hGS.setSortType(this.hnJ.getSortType());
        this.hGR.setSortType(this.hnJ.getSortType());
    }

    public ArrayList<o> a(boolean z, boolean z2, ArrayList<o> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<o> a(boolean z, boolean z2, ArrayList<o> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.hnJ != null) {
            boolean caH = this.hGQ.bUO().caH();
            if (this.hnJ.caI()) {
                return this.hGS.a(z, caH, arrayList, z3, z4);
            }
            return this.hGR.a(z, caH, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.hnJ != null) {
            if (this.hnJ.caI()) {
                this.hGS.resetData();
            } else {
                this.hGR.resetData();
            }
        }
    }

    public boolean cx(List<Long> list) {
        if (this.hnJ == null || this.hnJ.caI()) {
            return false;
        }
        return this.hGR.cx(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.hnJ != null && this.hnt != null && frsViewData != null) {
            this.hGQ.hny = System.currentTimeMillis();
            if (this.hnJ.caI()) {
                if (this.hGS.bUU() == 1 && !this.hnJ.isLoading()) {
                    this.hGS.setSortType(this.hnJ.getSortType());
                    this.hGS.can();
                    int pn = this.hGS.getPn();
                    this.hGS.setPn(pn);
                    this.hnJ.uU(pn + 1);
                }
            } else if (this.hnJ.cay() == 1) {
                if (!this.hGR.isLoading && !this.hnJ.isLoading()) {
                    int pn2 = this.hGR.getPn();
                    if (this.hGR.cx(frsViewData.getThreadListIds())) {
                        this.hGR.can();
                        this.hGR.setSortType(this.hnJ.getSortType());
                        this.hGR.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.hGR.bUU() == 1) {
                        this.hGR.can();
                        this.hGR.setPn(pn2);
                        this.hnJ.uU(pn2 + 1);
                        this.hGR.loadingDone = false;
                        this.hGR.loadIndex = 0;
                    }
                }
            } else if (!this.hnJ.caA()) {
                this.hnJ.bMa();
            }
        }
    }

    public int bUU() {
        if (this.hnJ == null) {
            return -1;
        }
        if (this.hnJ.caI()) {
            return this.hGS.bUU();
        }
        return this.hGR.bUU();
    }

    public void setHasMore(int i) {
        if (this.hnJ != null) {
            if (this.hnJ.caI()) {
                this.hGS.setHasMore(i);
            } else {
                this.hGR.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.hnJ == null) {
            return 1;
        }
        if (this.hnJ.caI()) {
            return this.hGS.getPn();
        }
        return this.hGR.getPn();
    }

    public void setPn(int i) {
        if (this.hnJ != null) {
            if (this.hnJ.caI()) {
                this.hGS.setPn(i);
            } else {
                this.hGR.setPn(i);
            }
        }
    }

    public ArrayList<o> getDataList() {
        return this.hnJ.caI() ? this.hGS.getDataList() : this.hnJ.caC();
    }

    public FrsSmartLoadMoreModel caq() {
        return this.hGS;
    }

    public void d(o oVar) {
        if (oVar != null) {
            if (this.hnJ.caI()) {
                this.hGS.d(oVar);
            } else {
                this.hGR.d(oVar);
            }
        }
    }
}
