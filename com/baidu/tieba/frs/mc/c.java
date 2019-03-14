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
    private final com.baidu.tieba.frs.k eYS;
    private final FrsModelController eZj;
    private final FrsFragment fqS;
    private final FrsLoadMoreModel fqT;
    private final FrsSmartLoadMoreModel fqU;
    private final a fqV = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.eYS != null && c.this.eYS.getListView() != null) {
                List<m> data = c.this.eYS.getListView().getData();
                if (!v.T(data) && c.this.eYS.getListView().getAdapter() != null && ((m) v.d(data, i)) != null) {
                    c.this.eYS.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fqS = frsFragment;
        this.fqT = new FrsLoadMoreModel(frsFragment, kVar);
        this.fqU = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fqU.a(this.fqV);
        this.fqT.a(this.fqV);
        this.eYS = frsFragment.bcu();
        this.eZj = frsFragment.bcp();
        this.fqU.setSortType(this.eZj.getSortType());
        this.fqT.setSortType(this.eZj.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.eZj != null) {
            boolean bhS = this.fqS.bcp().bhS();
            if (this.eZj.bhT()) {
                return this.fqU.a(z, bhS, arrayList, z3, z4);
            }
            return this.fqT.a(z, bhS, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.eZj != null) {
            if (this.eZj.bhT()) {
                this.fqU.resetData();
            } else {
                this.fqT.resetData();
            }
        }
    }

    public boolean cd(List<Long> list) {
        if (this.eZj == null || this.eZj.bhT()) {
            return false;
        }
        return this.fqT.cd(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.eZj != null && this.eYS != null && frsViewData != null) {
            this.fqS.eYX = System.currentTimeMillis();
            if (this.eZj.bhT()) {
                if (this.fqU.bcv() == 1 && !this.eZj.qz()) {
                    this.fqU.setSortType(this.eZj.getSortType());
                    this.fqU.bhB();
                    int pn = this.fqU.getPn();
                    this.fqU.setPn(pn);
                    this.eZj.qZ(pn + 1);
                }
            } else if (this.eZj.bhK() == 1) {
                if (!this.fqT.isLoading && !this.eZj.qz()) {
                    int pn2 = this.fqT.getPn();
                    if (this.fqT.cd(frsViewData.getThreadListIds())) {
                        this.fqT.bhB();
                        this.fqT.setSortType(this.eZj.getSortType());
                        this.fqT.a(com.baidu.adp.lib.g.b.d(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fqT.bcv() == 1) {
                        this.fqT.bhB();
                        this.fqT.setPn(pn2);
                        this.eZj.qZ(pn2 + 1);
                        this.fqT.loadingDone = false;
                        this.fqT.loadIndex = 0;
                    }
                }
            } else if (!this.eZj.bhM()) {
                this.eZj.aRR();
            }
        }
    }

    public int bcv() {
        if (this.eZj == null) {
            return -1;
        }
        if (this.eZj.bhT()) {
            return this.fqU.bcv();
        }
        return this.fqT.bcv();
    }

    public void setHasMore(int i) {
        if (this.eZj != null) {
            if (this.eZj.bhT()) {
                this.fqU.setHasMore(i);
            } else {
                this.fqT.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.eZj == null) {
            return 1;
        }
        if (this.eZj.bhT()) {
            return this.fqU.getPn();
        }
        return this.fqT.getPn();
    }

    public void setPn(int i) {
        if (this.eZj != null) {
            if (this.eZj.bhT()) {
                this.fqU.setPn(i);
            } else {
                this.fqT.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.eZj.bhT() ? this.fqU.getDataList() : this.eZj.bhO();
    }

    public FrsSmartLoadMoreModel bhE() {
        return this.fqU;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.eZj.bhT()) {
                this.fqU.e(mVar);
            } else {
                this.fqT.e(mVar);
            }
        }
    }
}
