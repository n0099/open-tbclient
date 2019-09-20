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
    private final FrsFragment fOE;
    private final FrsLoadMoreModel fOF;
    private final FrsSmartLoadMoreModel fOG;
    private final a fOH = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.fwb != null && c.this.fwb.getListView() != null) {
                List<m> data = c.this.fwb.getListView().getData();
                if (!v.aa(data) && c.this.fwb.getListView().getAdapter() != null && ((m) v.d(data, i)) != null) {
                    c.this.fwb.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.k fwb;
    private final FrsModelController fws;

    /* loaded from: classes4.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.fOE = frsFragment;
        this.fOF = new FrsLoadMoreModel(frsFragment, kVar);
        this.fOG = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.fOG.a(this.fOH);
        this.fOF.a(this.fOH);
        this.fwb = frsFragment.bmJ();
        this.fws = frsFragment.bmE();
        this.fOG.setSortType(this.fws.getSortType());
        this.fOF.setSortType(this.fws.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.fws != null) {
            boolean bso = this.fOE.bmE().bso();
            if (this.fws.bsp()) {
                return this.fOG.a(z, bso, arrayList, z3, z4);
            }
            return this.fOF.a(z, bso, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.fws != null) {
            if (this.fws.bsp()) {
                this.fOG.resetData();
            } else {
                this.fOF.resetData();
            }
        }
    }

    public boolean ci(List<Long> list) {
        if (this.fws == null || this.fws.bsp()) {
            return false;
        }
        return this.fOF.ci(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.fws != null && this.fwb != null && frsViewData != null) {
            this.fOE.fwg = System.currentTimeMillis();
            if (this.fws.bsp()) {
                if (this.fOG.bmK() == 1 && !this.fws.pQ()) {
                    this.fOG.setSortType(this.fws.getSortType());
                    this.fOG.brW();
                    int pn = this.fOG.getPn();
                    this.fOG.setPn(pn);
                    this.fws.sB(pn + 1);
                }
            } else if (this.fws.bsg() == 1) {
                if (!this.fOF.isLoading && !this.fws.pQ()) {
                    int pn2 = this.fOF.getPn();
                    if (this.fOF.ci(frsViewData.getThreadListIds())) {
                        this.fOF.brW();
                        this.fOF.setSortType(this.fws.getSortType());
                        this.fOF.a(com.baidu.adp.lib.g.b.e(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.fOF.bmK() == 1) {
                        this.fOF.brW();
                        this.fOF.setPn(pn2);
                        this.fws.sB(pn2 + 1);
                        this.fOF.loadingDone = false;
                        this.fOF.loadIndex = 0;
                    }
                }
            } else if (!this.fws.bsi()) {
                this.fws.bbG();
            }
        }
    }

    public int bmK() {
        if (this.fws == null) {
            return -1;
        }
        if (this.fws.bsp()) {
            return this.fOG.bmK();
        }
        return this.fOF.bmK();
    }

    public void setHasMore(int i) {
        if (this.fws != null) {
            if (this.fws.bsp()) {
                this.fOG.setHasMore(i);
            } else {
                this.fOF.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.fws == null) {
            return 1;
        }
        if (this.fws.bsp()) {
            return this.fOG.getPn();
        }
        return this.fOF.getPn();
    }

    public void setPn(int i) {
        if (this.fws != null) {
            if (this.fws.bsp()) {
                this.fOG.setPn(i);
            } else {
                this.fOF.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.fws.bsp() ? this.fOG.getDataList() : this.fws.bsk();
    }

    public FrsSmartLoadMoreModel brZ() {
        return this.fOG;
    }

    public void e(m mVar) {
        if (mVar != null) {
            if (this.fws.bsp()) {
                this.fOG.e(mVar);
            } else {
                this.fOF.e(mVar);
            }
        }
    }
}
