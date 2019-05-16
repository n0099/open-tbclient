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
    private final FrsFragment fGZ;
    private final FrsLoadMoreModel fHa;
    private final FrsSmartLoadMoreModel fHb;
    private final a fHc = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.foP != null && c.this.foP.getListView() != null) {
                List<m> data = c.this.foP.getListView().getData();
                if (!v.aa(data) && c.this.foP.getListView().getAdapter() != null && ((m) v.d(data, i)) != null) {
                    c.this.foP.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.k foP;
    private final FrsModelController fpg;

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fGZ = frsFragment;
        this.fHa = new FrsLoadMoreModel(frsFragment, kVar);
        this.fHb = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fHb.a(this.fHc);
        this.fHa.a(this.fHc);
        this.foP = frsFragment.bjM();
        this.fpg = frsFragment.bjH();
        this.fHb.setSortType(this.fpg.getSortType());
        this.fHa.setSortType(this.fpg.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.fpg != null) {
            boolean bpj = this.fGZ.bjH().bpj();
            if (this.fpg.bpk()) {
                return this.fHb.a(z, bpj, arrayList, z3, z4);
            }
            return this.fHa.a(z, bpj, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.fpg != null) {
            if (this.fpg.bpk()) {
                this.fHb.resetData();
            } else {
                this.fHa.resetData();
            }
        }
    }

    public boolean ci(List<Long> list) {
        if (this.fpg == null || this.fpg.bpk()) {
            return false;
        }
        return this.fHa.ci(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.fpg != null && this.foP != null && frsViewData != null) {
            this.fGZ.foU = System.currentTimeMillis();
            if (this.fpg.bpk()) {
                if (this.fHb.bjN() == 1 && !this.fpg.pu()) {
                    this.fHb.setSortType(this.fpg.getSortType());
                    this.fHb.boS();
                    int pn = this.fHb.getPn();
                    this.fHb.setPn(pn);
                    this.fpg.sd(pn + 1);
                }
            } else if (this.fpg.bpb() == 1) {
                if (!this.fHa.isLoading && !this.fpg.pu()) {
                    int pn2 = this.fHa.getPn();
                    if (this.fHa.ci(frsViewData.getThreadListIds())) {
                        this.fHa.boS();
                        this.fHa.setSortType(this.fpg.getSortType());
                        this.fHa.a(com.baidu.adp.lib.g.b.c(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fHa.bjN() == 1) {
                        this.fHa.boS();
                        this.fHa.setPn(pn2);
                        this.fpg.sd(pn2 + 1);
                        this.fHa.loadingDone = false;
                        this.fHa.loadIndex = 0;
                    }
                }
            } else if (!this.fpg.bpd()) {
                this.fpg.aYY();
            }
        }
    }

    public int bjN() {
        if (this.fpg == null) {
            return -1;
        }
        if (this.fpg.bpk()) {
            return this.fHb.bjN();
        }
        return this.fHa.bjN();
    }

    public void setHasMore(int i) {
        if (this.fpg != null) {
            if (this.fpg.bpk()) {
                this.fHb.setHasMore(i);
            } else {
                this.fHa.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.fpg == null) {
            return 1;
        }
        if (this.fpg.bpk()) {
            return this.fHb.getPn();
        }
        return this.fHa.getPn();
    }

    public void setPn(int i) {
        if (this.fpg != null) {
            if (this.fpg.bpk()) {
                this.fHb.setPn(i);
            } else {
                this.fHa.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.fpg.bpk() ? this.fHb.getDataList() : this.fpg.bpf();
    }

    public FrsSmartLoadMoreModel boV() {
        return this.fHb;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fpg.bpk()) {
                this.fHb.e(mVar);
            } else {
                this.fHa.e(mVar);
            }
        }
    }
}
