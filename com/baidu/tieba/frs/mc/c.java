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
    private final com.baidu.tieba.frs.k eYT;
    private final FrsModelController eZk;
    private final FrsFragment fqT;
    private final FrsLoadMoreModel fqU;
    private final FrsSmartLoadMoreModel fqV;
    private final a fqW = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.eYT != null && c.this.eYT.getListView() != null) {
                List<m> data = c.this.eYT.getListView().getData();
                if (!v.T(data) && c.this.eYT.getListView().getAdapter() != null && ((m) v.d(data, i)) != null) {
                    c.this.eYT.getListView().getAdapter().notifyItemRemoved(i);
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
        this.fqT = frsFragment;
        this.fqU = new FrsLoadMoreModel(frsFragment, kVar);
        this.fqV = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fqV.a(this.fqW);
        this.fqU.a(this.fqW);
        this.eYT = frsFragment.bcv();
        this.eZk = frsFragment.bcq();
        this.fqV.setSortType(this.eZk.getSortType());
        this.fqU.setSortType(this.eZk.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.eZk != null) {
            boolean bhT = this.fqT.bcq().bhT();
            if (this.eZk.bhU()) {
                return this.fqV.a(z, bhT, arrayList, z3, z4);
            }
            return this.fqU.a(z, bhT, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.eZk != null) {
            if (this.eZk.bhU()) {
                this.fqV.resetData();
            } else {
                this.fqU.resetData();
            }
        }
    }

    public boolean cd(List<Long> list) {
        if (this.eZk == null || this.eZk.bhU()) {
            return false;
        }
        return this.fqU.cd(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.eZk != null && this.eYT != null && frsViewData != null) {
            this.fqT.eYY = System.currentTimeMillis();
            if (this.eZk.bhU()) {
                if (this.fqV.bcw() == 1 && !this.eZk.qz()) {
                    this.fqV.setSortType(this.eZk.getSortType());
                    this.fqV.bhC();
                    int pn = this.fqV.getPn();
                    this.fqV.setPn(pn);
                    this.eZk.qZ(pn + 1);
                }
            } else if (this.eZk.bhL() == 1) {
                if (!this.fqU.isLoading && !this.eZk.qz()) {
                    int pn2 = this.fqU.getPn();
                    if (this.fqU.cd(frsViewData.getThreadListIds())) {
                        this.fqU.bhC();
                        this.fqU.setSortType(this.eZk.getSortType());
                        this.fqU.a(com.baidu.adp.lib.g.b.d(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fqU.bcw() == 1) {
                        this.fqU.bhC();
                        this.fqU.setPn(pn2);
                        this.eZk.qZ(pn2 + 1);
                        this.fqU.loadingDone = false;
                        this.fqU.loadIndex = 0;
                    }
                }
            } else if (!this.eZk.bhN()) {
                this.eZk.aRS();
            }
        }
    }

    public int bcw() {
        if (this.eZk == null) {
            return -1;
        }
        if (this.eZk.bhU()) {
            return this.fqV.bcw();
        }
        return this.fqU.bcw();
    }

    public void setHasMore(int i) {
        if (this.eZk != null) {
            if (this.eZk.bhU()) {
                this.fqV.setHasMore(i);
            } else {
                this.fqU.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.eZk == null) {
            return 1;
        }
        if (this.eZk.bhU()) {
            return this.fqV.getPn();
        }
        return this.fqU.getPn();
    }

    public void setPn(int i) {
        if (this.eZk != null) {
            if (this.eZk.bhU()) {
                this.fqV.setPn(i);
            } else {
                this.fqU.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.eZk.bhU() ? this.fqV.getDataList() : this.eZk.bhP();
    }

    public FrsSmartLoadMoreModel bhF() {
        return this.fqV;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.eZk.bhU()) {
                this.fqV.e(mVar);
            } else {
                this.fqU.e(mVar);
            }
        }
    }
}
