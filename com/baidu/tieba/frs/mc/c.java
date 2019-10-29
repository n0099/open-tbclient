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
    private final FrsFragment fNY;
    private final FrsLoadMoreModel fNZ;
    private final FrsSmartLoadMoreModel fOa;
    private final a fOb = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.fvo != null && c.this.fvo.getListView() != null) {
                List<m> data = c.this.fvo.getListView().getData();
                if (!v.isEmpty(data) && c.this.fvo.getListView().getAdapter() != null && ((m) v.remove(data, i)) != null) {
                    c.this.fvo.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController fvF;
    private final com.baidu.tieba.frs.k fvo;

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fNY = frsFragment;
        this.fNZ = new FrsLoadMoreModel(frsFragment, kVar);
        this.fOa = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fOa.a(this.fOb);
        this.fNZ.a(this.fOb);
        this.fvo = frsFragment.bjP();
        this.fvF = frsFragment.bjK();
        this.fOa.setSortType(this.fvF.getSortType());
        this.fNZ.setSortType(this.fvF.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.fvF != null) {
            boolean bps = this.fNY.bjK().bps();
            if (this.fvF.bpt()) {
                return this.fOa.a(z, bps, arrayList, z3, z4);
            }
            return this.fNZ.a(z, bps, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.fvF != null) {
            if (this.fvF.bpt()) {
                this.fOa.resetData();
            } else {
                this.fNZ.resetData();
            }
        }
    }

    public boolean cv(List<Long> list) {
        if (this.fvF == null || this.fvF.bpt()) {
            return false;
        }
        return this.fNZ.cv(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.fvF != null && this.fvo != null && frsViewData != null) {
            this.fNY.fvt = System.currentTimeMillis();
            if (this.fvF.bpt()) {
                if (this.fOa.bjQ() == 1 && !this.fvF.isLoading()) {
                    this.fOa.setSortType(this.fvF.getSortType());
                    this.fOa.bpa();
                    int pn = this.fOa.getPn();
                    this.fOa.setPn(pn);
                    this.fvF.ru(pn + 1);
                }
            } else if (this.fvF.bpk() == 1) {
                if (!this.fNZ.isLoading && !this.fvF.isLoading()) {
                    int pn2 = this.fNZ.getPn();
                    if (this.fNZ.cv(frsViewData.getThreadListIds())) {
                        this.fNZ.bpa();
                        this.fNZ.setSortType(this.fvF.getSortType());
                        this.fNZ.a(com.baidu.adp.lib.g.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fNZ.bjQ() == 1) {
                        this.fNZ.bpa();
                        this.fNZ.setPn(pn2);
                        this.fvF.ru(pn2 + 1);
                        this.fNZ.loadingDone = false;
                        this.fNZ.loadIndex = 0;
                    }
                }
            } else if (!this.fvF.bpm()) {
                this.fvF.bbL();
            }
        }
    }

    public int bjQ() {
        if (this.fvF == null) {
            return -1;
        }
        if (this.fvF.bpt()) {
            return this.fOa.bjQ();
        }
        return this.fNZ.bjQ();
    }

    public void setHasMore(int i) {
        if (this.fvF != null) {
            if (this.fvF.bpt()) {
                this.fOa.setHasMore(i);
            } else {
                this.fNZ.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.fvF == null) {
            return 1;
        }
        if (this.fvF.bpt()) {
            return this.fOa.getPn();
        }
        return this.fNZ.getPn();
    }

    public void setPn(int i) {
        if (this.fvF != null) {
            if (this.fvF.bpt()) {
                this.fOa.setPn(i);
            } else {
                this.fNZ.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.fvF.bpt() ? this.fOa.getDataList() : this.fvF.bpo();
    }

    public FrsSmartLoadMoreModel bpd() {
        return this.fOa;
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.fvF.bpt()) {
                this.fOa.d(mVar);
            } else {
                this.fNZ.d(mVar);
            }
        }
    }
}
