package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final FrsFragment hGd;
    private final FrsLoadMoreModel hGe;
    private final FrsSmartLoadMoreModel hGf;
    private final a hGg = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.hni != null && c.this.hni.getListView() != null) {
                List<o> data = c.this.hni.getListView().getData();
                if (!v.isEmpty(data) && c.this.hni.getListView().getAdapter() != null && ((o) v.remove(data, i)) != null) {
                    c.this.hni.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.n hni;
    private final FrsModelController hny;

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.hGd = frsFragment;
        this.hGe = new FrsLoadMoreModel(frsFragment, kVar);
        this.hGf = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.hGf.a(this.hGg);
        this.hGe.a(this.hGg);
        this.hni = frsFragment.bUR();
        this.hny = frsFragment.bUM();
        this.hGf.setSortType(this.hny.getSortType());
        this.hGe.setSortType(this.hny.getSortType());
    }

    public ArrayList<o> a(boolean z, boolean z2, ArrayList<o> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<o> a(boolean z, boolean z2, ArrayList<o> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.hny != null) {
            boolean caz = this.hGd.bUM().caz();
            if (this.hny.caA()) {
                return this.hGf.a(z, caz, arrayList, z3, z4);
            }
            return this.hGe.a(z, caz, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.hny != null) {
            if (this.hny.caA()) {
                this.hGf.resetData();
            } else {
                this.hGe.resetData();
            }
        }
    }

    public boolean cw(List<Long> list) {
        if (this.hny == null || this.hny.caA()) {
            return false;
        }
        return this.hGe.cw(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.hny != null && this.hni != null && frsViewData != null) {
            this.hGd.hnn = System.currentTimeMillis();
            if (this.hny.caA()) {
                if (this.hGf.bUS() == 1 && !this.hny.isLoading()) {
                    this.hGf.setSortType(this.hny.getSortType());
                    this.hGf.caf();
                    int pn = this.hGf.getPn();
                    this.hGf.setPn(pn);
                    this.hny.uS(pn + 1);
                }
            } else if (this.hny.caq() == 1) {
                if (!this.hGe.isLoading && !this.hny.isLoading()) {
                    int pn2 = this.hGe.getPn();
                    if (this.hGe.cw(frsViewData.getThreadListIds())) {
                        this.hGe.caf();
                        this.hGe.setSortType(this.hny.getSortType());
                        this.hGe.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.hGe.bUS() == 1) {
                        this.hGe.caf();
                        this.hGe.setPn(pn2);
                        this.hny.uS(pn2 + 1);
                        this.hGe.loadingDone = false;
                        this.hGe.loadIndex = 0;
                    }
                }
            } else if (!this.hny.cas()) {
                this.hny.bLY();
            }
        }
    }

    public int bUS() {
        if (this.hny == null) {
            return -1;
        }
        if (this.hny.caA()) {
            return this.hGf.bUS();
        }
        return this.hGe.bUS();
    }

    public void setHasMore(int i) {
        if (this.hny != null) {
            if (this.hny.caA()) {
                this.hGf.setHasMore(i);
            } else {
                this.hGe.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.hny == null) {
            return 1;
        }
        if (this.hny.caA()) {
            return this.hGf.getPn();
        }
        return this.hGe.getPn();
    }

    public void setPn(int i) {
        if (this.hny != null) {
            if (this.hny.caA()) {
                this.hGf.setPn(i);
            } else {
                this.hGe.setPn(i);
            }
        }
    }

    public ArrayList<o> getDataList() {
        return this.hny.caA() ? this.hGf.getDataList() : this.hny.cau();
    }

    public FrsSmartLoadMoreModel cai() {
        return this.hGf;
    }

    public void d(o oVar) {
        if (oVar != null) {
            if (this.hny.caA()) {
                this.hGf.d(oVar);
            } else {
                this.hGe.d(oVar);
            }
        }
    }
}
