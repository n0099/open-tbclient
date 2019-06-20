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
    private final FrsFragment fHd;
    private final FrsLoadMoreModel fHe;
    private final FrsSmartLoadMoreModel fHf;
    private final a fHg = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.foQ != null && c.this.foQ.getListView() != null) {
                List<m> data = c.this.foQ.getListView().getData();
                if (!v.aa(data) && c.this.foQ.getListView().getAdapter() != null && ((m) v.d(data, i)) != null) {
                    c.this.foQ.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.k foQ;
    private final FrsModelController fph;

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fHd = frsFragment;
        this.fHe = new FrsLoadMoreModel(frsFragment, kVar);
        this.fHf = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fHf.a(this.fHg);
        this.fHe.a(this.fHg);
        this.foQ = frsFragment.bjP();
        this.fph = frsFragment.bjK();
        this.fHf.setSortType(this.fph.getSortType());
        this.fHe.setSortType(this.fph.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.fph != null) {
            boolean bpo = this.fHd.bjK().bpo();
            if (this.fph.bpp()) {
                return this.fHf.a(z, bpo, arrayList, z3, z4);
            }
            return this.fHe.a(z, bpo, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.fph != null) {
            if (this.fph.bpp()) {
                this.fHf.resetData();
            } else {
                this.fHe.resetData();
            }
        }
    }

    public boolean ci(List<Long> list) {
        if (this.fph == null || this.fph.bpp()) {
            return false;
        }
        return this.fHe.ci(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.fph != null && this.foQ != null && frsViewData != null) {
            this.fHd.foV = System.currentTimeMillis();
            if (this.fph.bpp()) {
                if (this.fHf.bjQ() == 1 && !this.fph.pu()) {
                    this.fHf.setSortType(this.fph.getSortType());
                    this.fHf.boX();
                    int pn = this.fHf.getPn();
                    this.fHf.setPn(pn);
                    this.fph.sd(pn + 1);
                }
            } else if (this.fph.bpg() == 1) {
                if (!this.fHe.isLoading && !this.fph.pu()) {
                    int pn2 = this.fHe.getPn();
                    if (this.fHe.ci(frsViewData.getThreadListIds())) {
                        this.fHe.boX();
                        this.fHe.setSortType(this.fph.getSortType());
                        this.fHe.a(com.baidu.adp.lib.g.b.c(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fHe.bjQ() == 1) {
                        this.fHe.boX();
                        this.fHe.setPn(pn2);
                        this.fph.sd(pn2 + 1);
                        this.fHe.loadingDone = false;
                        this.fHe.loadIndex = 0;
                    }
                }
            } else if (!this.fph.bpi()) {
                this.fph.aZb();
            }
        }
    }

    public int bjQ() {
        if (this.fph == null) {
            return -1;
        }
        if (this.fph.bpp()) {
            return this.fHf.bjQ();
        }
        return this.fHe.bjQ();
    }

    public void setHasMore(int i) {
        if (this.fph != null) {
            if (this.fph.bpp()) {
                this.fHf.setHasMore(i);
            } else {
                this.fHe.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.fph == null) {
            return 1;
        }
        if (this.fph.bpp()) {
            return this.fHf.getPn();
        }
        return this.fHe.getPn();
    }

    public void setPn(int i) {
        if (this.fph != null) {
            if (this.fph.bpp()) {
                this.fHf.setPn(i);
            } else {
                this.fHe.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.fph.bpp() ? this.fHf.getDataList() : this.fph.bpk();
    }

    public FrsSmartLoadMoreModel bpa() {
        return this.fHf;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fph.bpp()) {
                this.fHf.e(mVar);
            } else {
                this.fHe.e(mVar);
            }
        }
    }
}
