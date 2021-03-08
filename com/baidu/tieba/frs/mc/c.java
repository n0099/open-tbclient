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
    private final FrsFragment jGE;
    private final FrsLoadMoreModel jGF;
    private final FrsSmartLoadMoreModel jGG;
    private final a jGH = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.jif != null && c.this.jif.getListView() != null) {
                List<com.baidu.adp.widget.ListView.n> data = c.this.jif.getListView().getData();
                if (!y.isEmpty(data) && c.this.jif.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.n) y.remove(data, i)) != null) {
                    c.this.jif.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final q jif;
    private final FrsModelController jix;

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.jGF.setFunAdController(aVar);
        this.jGG.setFunAdController(aVar);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.jGE = frsFragment;
        this.jGF = new FrsLoadMoreModel(frsFragment, kVar);
        this.jGG = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jGG.a(this.jGH);
        this.jGF.a(this.jGH);
        this.jif = frsFragment.cCH();
        this.jix = frsFragment.cCC();
        this.jGG.setSortType(this.jix.getSortType());
        this.jGF.setSortType(this.jix.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.jix != null) {
            boolean cJW = this.jGE.cCC().cJW();
            if (this.jix.cJX()) {
                return this.jGG.a(z, cJW, arrayList, z3, z4);
            }
            return this.jGF.a(z, cJW, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.jix != null) {
            if (this.jix.cJX()) {
                this.jGG.resetData();
            } else {
                this.jGF.resetData();
            }
        }
    }

    public boolean dA(List<Long> list) {
        if (this.jix == null || this.jix.cJX()) {
            return false;
        }
        return this.jGF.dA(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.jix != null && this.jif != null && frsViewData != null) {
            this.jGE.jil = System.currentTimeMillis();
            if (this.jix.cJX()) {
                if (this.jGG.cCI() == 1 && !this.jix.isLoading()) {
                    this.jGG.setSortType(this.jix.getSortType());
                    this.jGG.cJC();
                    int pn = this.jGG.getPn();
                    this.jGG.setPn(pn);
                    this.jix.Ac(pn + 1);
                }
            } else if (this.jix.cJN() == 1) {
                if (!this.jGF.isLoading && !this.jix.isLoading()) {
                    int pn2 = this.jGF.getPn();
                    if (this.jGF.dA(frsViewData.getThreadListIds())) {
                        this.jGF.cJC();
                        this.jGF.setSortType(this.jix.getSortType());
                        long j = com.baidu.adp.lib.f.b.toLong(str2, 0L);
                        String str3 = "";
                        if (this.jix.cJo() != null) {
                            str3 = com.baidu.tieba.recapp.a.y(this.jix.cJo().getThreadList(), false);
                        }
                        this.jGF.a(j, frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, str3);
                    } else if (this.jGF.cCI() == 1) {
                        this.jGF.cJC();
                        this.jGF.setPn(pn2);
                        this.jix.Ac(pn2 + 1);
                        this.jGF.loadingDone = false;
                        this.jGF.loadIndex = 0;
                    }
                }
            } else if (!this.jix.cJP()) {
                this.jix.cts();
            }
        }
    }

    public int cCI() {
        if (this.jix == null) {
            return -1;
        }
        if (this.jix.cJX()) {
            return this.jGG.cCI();
        }
        return this.jGF.cCI();
    }

    public void setHasMore(int i) {
        if (this.jix != null) {
            if (this.jix.cJX()) {
                this.jGG.setHasMore(i);
            } else {
                this.jGF.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.jix == null) {
            return 1;
        }
        if (this.jix.cJX()) {
            return this.jGG.getPn();
        }
        return this.jGF.getPn();
    }

    public void setPn(int i) {
        if (this.jix != null) {
            if (this.jix.cJX()) {
                this.jGG.setPn(i);
            } else {
                this.jGF.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.jix.cJX() ? this.jGG.getDataList() : this.jix.cJR();
    }

    public FrsSmartLoadMoreModel cJF() {
        return this.jGG;
    }

    public void d(com.baidu.adp.widget.ListView.n nVar) {
        if (nVar != null) {
            if (this.jix.cJX()) {
                this.jGG.d(nVar);
            } else {
                this.jGF.d(nVar);
            }
        }
    }
}
