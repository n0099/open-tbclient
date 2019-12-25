package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private final FrsFragment gBu;
    private final FrsLoadMoreModel gBv;
    private final FrsSmartLoadMoreModel gBw;
    private final a gBx = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.gja != null && c.this.gja.getListView() != null) {
                List<m> data = c.this.gja.getListView().getData();
                if (!v.isEmpty(data) && c.this.gja.getListView().getAdapter() != null && ((m) v.remove(data, i)) != null) {
                    c.this.gja.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.l gja;
    private final FrsModelController gjp;

    /* loaded from: classes6.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.gBu = frsFragment;
        this.gBv = new FrsLoadMoreModel(frsFragment, kVar);
        this.gBw = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.gBw.a(this.gBx);
        this.gBv.a(this.gBx);
        this.gja = frsFragment.bBi();
        this.gjp = frsFragment.bBd();
        this.gBw.setSortType(this.gjp.getSortType());
        this.gBv.setSortType(this.gjp.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.gjp != null) {
            boolean bGM = this.gBu.bBd().bGM();
            if (this.gjp.bGN()) {
                return this.gBw.a(z, bGM, arrayList, z3, z4);
            }
            return this.gBv.a(z, bGM, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.gjp != null) {
            if (this.gjp.bGN()) {
                this.gBw.resetData();
            } else {
                this.gBv.resetData();
            }
        }
    }

    public boolean cr(List<Long> list) {
        if (this.gjp == null || this.gjp.bGN()) {
            return false;
        }
        return this.gBv.cr(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.gjp != null && this.gja != null && frsViewData != null) {
            this.gBu.gje = System.currentTimeMillis();
            if (this.gjp.bGN()) {
                if (this.gBw.bBj() == 1 && !this.gjp.isLoading()) {
                    this.gBw.setSortType(this.gjp.getSortType());
                    this.gBw.bGu();
                    int pn = this.gBw.getPn();
                    this.gBw.setPn(pn);
                    this.gjp.tz(pn + 1);
                }
            } else if (this.gjp.bGE() == 1) {
                if (!this.gBv.isLoading && !this.gjp.isLoading()) {
                    int pn2 = this.gBv.getPn();
                    if (this.gBv.cr(frsViewData.getThreadListIds())) {
                        this.gBv.bGu();
                        this.gBv.setSortType(this.gjp.getSortType());
                        this.gBv.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.gBv.bBj() == 1) {
                        this.gBv.bGu();
                        this.gBv.setPn(pn2);
                        this.gjp.tz(pn2 + 1);
                        this.gBv.loadingDone = false;
                        this.gBv.loadIndex = 0;
                    }
                }
            } else if (!this.gjp.bGG()) {
                this.gjp.bth();
            }
        }
    }

    public int bBj() {
        if (this.gjp == null) {
            return -1;
        }
        if (this.gjp.bGN()) {
            return this.gBw.bBj();
        }
        return this.gBv.bBj();
    }

    public void setHasMore(int i) {
        if (this.gjp != null) {
            if (this.gjp.bGN()) {
                this.gBw.setHasMore(i);
            } else {
                this.gBv.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.gjp == null) {
            return 1;
        }
        if (this.gjp.bGN()) {
            return this.gBw.getPn();
        }
        return this.gBv.getPn();
    }

    public void setPn(int i) {
        if (this.gjp != null) {
            if (this.gjp.bGN()) {
                this.gBw.setPn(i);
            } else {
                this.gBv.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.gjp.bGN() ? this.gBw.getDataList() : this.gjp.bGI();
    }

    public FrsSmartLoadMoreModel bGx() {
        return this.gBw;
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.gjp.bGN()) {
                this.gBw.d(mVar);
            } else {
                this.gBv.d(mVar);
            }
        }
    }
}
