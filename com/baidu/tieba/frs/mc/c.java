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
    private final FrsFragment fHa;
    private final FrsLoadMoreModel fHb;
    private final FrsSmartLoadMoreModel fHc;
    private final a fHd = new a() { // from class: com.baidu.tieba.frs.mc.c.1
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
        this.fHa = frsFragment;
        this.fHb = new FrsLoadMoreModel(frsFragment, kVar);
        this.fHc = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fHc.a(this.fHd);
        this.fHb.a(this.fHd);
        this.foQ = frsFragment.bjP();
        this.fph = frsFragment.bjK();
        this.fHc.setSortType(this.fph.getSortType());
        this.fHb.setSortType(this.fph.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.fph != null) {
            boolean bpm = this.fHa.bjK().bpm();
            if (this.fph.bpn()) {
                return this.fHc.a(z, bpm, arrayList, z3, z4);
            }
            return this.fHb.a(z, bpm, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.fph != null) {
            if (this.fph.bpn()) {
                this.fHc.resetData();
            } else {
                this.fHb.resetData();
            }
        }
    }

    public boolean ci(List<Long> list) {
        if (this.fph == null || this.fph.bpn()) {
            return false;
        }
        return this.fHb.ci(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.fph != null && this.foQ != null && frsViewData != null) {
            this.fHa.foV = System.currentTimeMillis();
            if (this.fph.bpn()) {
                if (this.fHc.bjQ() == 1 && !this.fph.pu()) {
                    this.fHc.setSortType(this.fph.getSortType());
                    this.fHc.boV();
                    int pn = this.fHc.getPn();
                    this.fHc.setPn(pn);
                    this.fph.sd(pn + 1);
                }
            } else if (this.fph.bpe() == 1) {
                if (!this.fHb.isLoading && !this.fph.pu()) {
                    int pn2 = this.fHb.getPn();
                    if (this.fHb.ci(frsViewData.getThreadListIds())) {
                        this.fHb.boV();
                        this.fHb.setSortType(this.fph.getSortType());
                        this.fHb.a(com.baidu.adp.lib.g.b.c(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fHb.bjQ() == 1) {
                        this.fHb.boV();
                        this.fHb.setPn(pn2);
                        this.fph.sd(pn2 + 1);
                        this.fHb.loadingDone = false;
                        this.fHb.loadIndex = 0;
                    }
                }
            } else if (!this.fph.bpg()) {
                this.fph.aZb();
            }
        }
    }

    public int bjQ() {
        if (this.fph == null) {
            return -1;
        }
        if (this.fph.bpn()) {
            return this.fHc.bjQ();
        }
        return this.fHb.bjQ();
    }

    public void setHasMore(int i) {
        if (this.fph != null) {
            if (this.fph.bpn()) {
                this.fHc.setHasMore(i);
            } else {
                this.fHb.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.fph == null) {
            return 1;
        }
        if (this.fph.bpn()) {
            return this.fHc.getPn();
        }
        return this.fHb.getPn();
    }

    public void setPn(int i) {
        if (this.fph != null) {
            if (this.fph.bpn()) {
                this.fHc.setPn(i);
            } else {
                this.fHb.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.fph.bpn() ? this.fHc.getDataList() : this.fph.bpi();
    }

    public FrsSmartLoadMoreModel boY() {
        return this.fHc;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fph.bpn()) {
                this.fHc.e(mVar);
            } else {
                this.fHb.e(mVar);
            }
        }
    }
}
