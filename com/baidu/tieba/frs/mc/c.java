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
    private final FrsFragment jEV;
    private final FrsLoadMoreModel jEW;
    private final FrsSmartLoadMoreModel jEX;
    private final a jEY = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.jgv != null && c.this.jgv.getListView() != null) {
                List<com.baidu.adp.widget.ListView.n> data = c.this.jgv.getListView().getData();
                if (!y.isEmpty(data) && c.this.jgv.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.n) y.remove(data, i)) != null) {
                    c.this.jgv.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController jgN;
    private final q jgv;

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.jEW.setFunAdController(aVar);
        this.jEX.setFunAdController(aVar);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.jEV = frsFragment;
        this.jEW = new FrsLoadMoreModel(frsFragment, kVar);
        this.jEX = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jEX.a(this.jEY);
        this.jEW.a(this.jEY);
        this.jgv = frsFragment.cCB();
        this.jgN = frsFragment.cCw();
        this.jEX.setSortType(this.jgN.getSortType());
        this.jEW.setSortType(this.jgN.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.jgN != null) {
            boolean cJQ = this.jEV.cCw().cJQ();
            if (this.jgN.cJR()) {
                return this.jEX.a(z, cJQ, arrayList, z3, z4);
            }
            return this.jEW.a(z, cJQ, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.jgN != null) {
            if (this.jgN.cJR()) {
                this.jEX.resetData();
            } else {
                this.jEW.resetData();
            }
        }
    }

    public boolean dA(List<Long> list) {
        if (this.jgN == null || this.jgN.cJR()) {
            return false;
        }
        return this.jEW.dA(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.jgN != null && this.jgv != null && frsViewData != null) {
            this.jEV.jgB = System.currentTimeMillis();
            if (this.jgN.cJR()) {
                if (this.jEX.cCC() == 1 && !this.jgN.isLoading()) {
                    this.jEX.setSortType(this.jgN.getSortType());
                    this.jEX.cJw();
                    int pn = this.jEX.getPn();
                    this.jEX.setPn(pn);
                    this.jgN.Ab(pn + 1);
                }
            } else if (this.jgN.cJH() == 1) {
                if (!this.jEW.isLoading && !this.jgN.isLoading()) {
                    int pn2 = this.jEW.getPn();
                    if (this.jEW.dA(frsViewData.getThreadListIds())) {
                        this.jEW.cJw();
                        this.jEW.setSortType(this.jgN.getSortType());
                        long j = com.baidu.adp.lib.f.b.toLong(str2, 0L);
                        String str3 = "";
                        if (this.jgN.cJi() != null) {
                            str3 = com.baidu.tieba.recapp.a.y(this.jgN.cJi().getThreadList(), false);
                        }
                        this.jEW.a(j, frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, str3);
                    } else if (this.jEW.cCC() == 1) {
                        this.jEW.cJw();
                        this.jEW.setPn(pn2);
                        this.jgN.Ab(pn2 + 1);
                        this.jEW.loadingDone = false;
                        this.jEW.loadIndex = 0;
                    }
                }
            } else if (!this.jgN.cJJ()) {
                this.jgN.ctm();
            }
        }
    }

    public int cCC() {
        if (this.jgN == null) {
            return -1;
        }
        if (this.jgN.cJR()) {
            return this.jEX.cCC();
        }
        return this.jEW.cCC();
    }

    public void setHasMore(int i) {
        if (this.jgN != null) {
            if (this.jgN.cJR()) {
                this.jEX.setHasMore(i);
            } else {
                this.jEW.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.jgN == null) {
            return 1;
        }
        if (this.jgN.cJR()) {
            return this.jEX.getPn();
        }
        return this.jEW.getPn();
    }

    public void setPn(int i) {
        if (this.jgN != null) {
            if (this.jgN.cJR()) {
                this.jEX.setPn(i);
            } else {
                this.jEW.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.jgN.cJR() ? this.jEX.getDataList() : this.jgN.cJL();
    }

    public FrsSmartLoadMoreModel cJz() {
        return this.jEX;
    }

    public void d(com.baidu.adp.widget.ListView.n nVar) {
        if (nVar != null) {
            if (this.jgN.cJR()) {
                this.jEX.d(nVar);
            } else {
                this.jEW.d(nVar);
            }
        }
    }
}
