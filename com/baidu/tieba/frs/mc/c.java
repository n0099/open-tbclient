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
    private final FrsFragment fMb;
    private final FrsLoadMoreModel fMc;
    private final FrsSmartLoadMoreModel fMd;
    private final a fMe = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.ftP != null && c.this.ftP.getListView() != null) {
                List<m> data = c.this.ftP.getListView().getData();
                if (!v.aa(data) && c.this.ftP.getListView().getAdapter() != null && ((m) v.d(data, i)) != null) {
                    c.this.ftP.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.k ftP;
    private final FrsModelController fug;

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fMb = frsFragment;
        this.fMc = new FrsLoadMoreModel(frsFragment, kVar);
        this.fMd = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fMd.a(this.fMe);
        this.fMc.a(this.fMe);
        this.ftP = frsFragment.blR();
        this.fug = frsFragment.blM();
        this.fMd.setSortType(this.fug.getSortType());
        this.fMc.setSortType(this.fug.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.fug != null) {
            boolean brp = this.fMb.blM().brp();
            if (this.fug.brq()) {
                return this.fMd.a(z, brp, arrayList, z3, z4);
            }
            return this.fMc.a(z, brp, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.fug != null) {
            if (this.fug.brq()) {
                this.fMd.resetData();
            } else {
                this.fMc.resetData();
            }
        }
    }

    public boolean cj(List<Long> list) {
        if (this.fug == null || this.fug.brq()) {
            return false;
        }
        return this.fMc.cj(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.fug != null && this.ftP != null && frsViewData != null) {
            this.fMb.ftU = System.currentTimeMillis();
            if (this.fug.brq()) {
                if (this.fMd.blS() == 1 && !this.fug.pP()) {
                    this.fMd.setSortType(this.fug.getSortType());
                    this.fMd.bqY();
                    int pn = this.fMd.getPn();
                    this.fMd.setPn(pn);
                    this.fug.sv(pn + 1);
                }
            } else if (this.fug.brh() == 1) {
                if (!this.fMc.isLoading && !this.fug.pP()) {
                    int pn2 = this.fMc.getPn();
                    if (this.fMc.cj(frsViewData.getThreadListIds())) {
                        this.fMc.bqY();
                        this.fMc.setSortType(this.fug.getSortType());
                        this.fMc.a(com.baidu.adp.lib.g.b.c(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fMc.blS() == 1) {
                        this.fMc.bqY();
                        this.fMc.setPn(pn2);
                        this.fug.sv(pn2 + 1);
                        this.fMc.loadingDone = false;
                        this.fMc.loadIndex = 0;
                    }
                }
            } else if (!this.fug.brj()) {
                this.fug.bba();
            }
        }
    }

    public int blS() {
        if (this.fug == null) {
            return -1;
        }
        if (this.fug.brq()) {
            return this.fMd.blS();
        }
        return this.fMc.blS();
    }

    public void setHasMore(int i) {
        if (this.fug != null) {
            if (this.fug.brq()) {
                this.fMd.setHasMore(i);
            } else {
                this.fMc.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.fug == null) {
            return 1;
        }
        if (this.fug.brq()) {
            return this.fMd.getPn();
        }
        return this.fMc.getPn();
    }

    public void setPn(int i) {
        if (this.fug != null) {
            if (this.fug.brq()) {
                this.fMd.setPn(i);
            } else {
                this.fMc.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.fug.brq() ? this.fMd.getDataList() : this.fug.brl();
    }

    public FrsSmartLoadMoreModel brb() {
        return this.fMd;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fug.brq()) {
                this.fMd.e(mVar);
            } else {
                this.fMc.e(mVar);
            }
        }
    }
}
