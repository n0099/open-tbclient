package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final FrsFragment jEH;
    private final FrsLoadMoreModel jEI;
    private final FrsSmartLoadMoreModel jEJ;
    private final a jEK = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.jgh != null && c.this.jgh.getListView() != null) {
                List<com.baidu.adp.widget.ListView.n> data = c.this.jgh.getListView().getData();
                if (!y.isEmpty(data) && c.this.jgh.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.n) y.remove(data, i)) != null) {
                    c.this.jgh.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final q jgh;
    private final FrsModelController jgz;

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.jEI.setFunAdController(aVar);
        this.jEJ.setFunAdController(aVar);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.jEH = frsFragment;
        this.jEI = new FrsLoadMoreModel(frsFragment, kVar);
        this.jEJ = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jEJ.a(this.jEK);
        this.jEI.a(this.jEK);
        this.jgh = frsFragment.cCu();
        this.jgz = frsFragment.cCp();
        this.jEJ.setSortType(this.jgz.getSortType());
        this.jEI.setSortType(this.jgz.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.jgz != null) {
            boolean cJJ = this.jEH.cCp().cJJ();
            if (this.jgz.cJK()) {
                return this.jEJ.a(z, cJJ, arrayList, z3, z4);
            }
            return this.jEI.a(z, cJJ, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.jgz != null) {
            if (this.jgz.cJK()) {
                this.jEJ.resetData();
            } else {
                this.jEI.resetData();
            }
        }
    }

    public boolean dA(List<Long> list) {
        if (this.jgz == null || this.jgz.cJK()) {
            return false;
        }
        return this.jEI.dA(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.jgz != null && this.jgh != null && frsViewData != null) {
            this.jEH.jgn = System.currentTimeMillis();
            if (this.jgz.cJK()) {
                if (this.jEJ.cCv() == 1 && !this.jgz.isLoading()) {
                    this.jEJ.setSortType(this.jgz.getSortType());
                    this.jEJ.cJp();
                    int pn = this.jEJ.getPn();
                    this.jEJ.setPn(pn);
                    this.jgz.Ab(pn + 1);
                }
            } else if (this.jgz.cJA() == 1) {
                if (!this.jEI.isLoading && !this.jgz.isLoading()) {
                    int pn2 = this.jEI.getPn();
                    if (this.jEI.dA(frsViewData.getThreadListIds())) {
                        this.jEI.cJp();
                        this.jEI.setSortType(this.jgz.getSortType());
                        long j = com.baidu.adp.lib.f.b.toLong(str2, 0L);
                        String str3 = "";
                        if (this.jgz.cJb() != null) {
                            str3 = com.baidu.tieba.recapp.a.y(this.jgz.cJb().getThreadList(), false);
                        }
                        this.jEI.a(j, frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, str3);
                    } else if (this.jEI.cCv() == 1) {
                        this.jEI.cJp();
                        this.jEI.setPn(pn2);
                        this.jgz.Ab(pn2 + 1);
                        this.jEI.loadingDone = false;
                        this.jEI.loadIndex = 0;
                    }
                }
            } else if (!this.jgz.cJC()) {
                this.jgz.ctf();
            }
        }
    }

    public int cCv() {
        if (this.jgz == null) {
            return -1;
        }
        if (this.jgz.cJK()) {
            return this.jEJ.cCv();
        }
        return this.jEI.cCv();
    }

    public void setHasMore(int i) {
        if (this.jgz != null) {
            if (this.jgz.cJK()) {
                this.jEJ.setHasMore(i);
            } else {
                this.jEI.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.jgz == null) {
            return 1;
        }
        if (this.jgz.cJK()) {
            return this.jEJ.getPn();
        }
        return this.jEI.getPn();
    }

    public void setPn(int i) {
        if (this.jgz != null) {
            if (this.jgz.cJK()) {
                this.jEJ.setPn(i);
            } else {
                this.jEI.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.jgz.cJK() ? this.jEJ.getDataList() : this.jgz.cJE();
    }

    public FrsSmartLoadMoreModel cJs() {
        return this.jEJ;
    }

    public void d(com.baidu.adp.widget.ListView.n nVar) {
        if (nVar != null) {
            if (this.jgz.cJK()) {
                this.jEJ.d(nVar);
            } else {
                this.jEI.d(nVar);
            }
        }
    }
}
