package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private final FrsFragment gEE;
    private final FrsLoadMoreModel gEF;
    private final FrsSmartLoadMoreModel gEG;
    private final a gEH = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.gmj != null && c.this.gmj.getListView() != null) {
                List<m> data = c.this.gmj.getListView().getData();
                if (!v.isEmpty(data) && c.this.gmj.getListView().getAdapter() != null && ((m) v.remove(data, i)) != null) {
                    c.this.gmj.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.l gmj;
    private final FrsModelController gmz;

    /* loaded from: classes7.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.gEE = frsFragment;
        this.gEF = new FrsLoadMoreModel(frsFragment, kVar);
        this.gEG = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.gEG.a(this.gEH);
        this.gEF.a(this.gEH);
        this.gmj = frsFragment.bCk();
        this.gmz = frsFragment.bCf();
        this.gEG.setSortType(this.gmz.getSortType());
        this.gEF.setSortType(this.gmz.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.gmz != null) {
            boolean bHO = this.gEE.bCf().bHO();
            if (this.gmz.bHP()) {
                return this.gEG.a(z, bHO, arrayList, z3, z4);
            }
            return this.gEF.a(z, bHO, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.gmz != null) {
            if (this.gmz.bHP()) {
                this.gEG.resetData();
            } else {
                this.gEF.resetData();
            }
        }
    }

    public boolean cr(List<Long> list) {
        if (this.gmz == null || this.gmz.bHP()) {
            return false;
        }
        return this.gEF.cr(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.gmz != null && this.gmj != null && frsViewData != null) {
            this.gEE.gmo = System.currentTimeMillis();
            if (this.gmz.bHP()) {
                if (this.gEG.bCl() == 1 && !this.gmz.isLoading()) {
                    this.gEG.setSortType(this.gmz.getSortType());
                    this.gEG.bHw();
                    int pn = this.gEG.getPn();
                    this.gEG.setPn(pn);
                    this.gmz.tE(pn + 1);
                }
            } else if (this.gmz.bHG() == 1) {
                if (!this.gEF.isLoading && !this.gmz.isLoading()) {
                    int pn2 = this.gEF.getPn();
                    if (this.gEF.cr(frsViewData.getThreadListIds())) {
                        this.gEF.bHw();
                        this.gEF.setSortType(this.gmz.getSortType());
                        this.gEF.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.gEF.bCl() == 1) {
                        this.gEF.bHw();
                        this.gEF.setPn(pn2);
                        this.gmz.tE(pn2 + 1);
                        this.gEF.loadingDone = false;
                        this.gEF.loadIndex = 0;
                    }
                }
            } else if (!this.gmz.bHI()) {
                this.gmz.buj();
            }
        }
    }

    public int bCl() {
        if (this.gmz == null) {
            return -1;
        }
        if (this.gmz.bHP()) {
            return this.gEG.bCl();
        }
        return this.gEF.bCl();
    }

    public void setHasMore(int i) {
        if (this.gmz != null) {
            if (this.gmz.bHP()) {
                this.gEG.setHasMore(i);
            } else {
                this.gEF.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.gmz == null) {
            return 1;
        }
        if (this.gmz.bHP()) {
            return this.gEG.getPn();
        }
        return this.gEF.getPn();
    }

    public void setPn(int i) {
        if (this.gmz != null) {
            if (this.gmz.bHP()) {
                this.gEG.setPn(i);
            } else {
                this.gEF.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.gmz.bHP() ? this.gEG.getDataList() : this.gmz.bHK();
    }

    public FrsSmartLoadMoreModel bHz() {
        return this.gEG;
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.gmz.bHP()) {
                this.gEG.d(mVar);
            } else {
                this.gEF.d(mVar);
            }
        }
    }
}
