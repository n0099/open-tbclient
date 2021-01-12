package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final q jaB;
    private final FrsModelController jaT;
    private final FrsFragment jzc;
    private final FrsLoadMoreModel jzd;
    private final FrsSmartLoadMoreModel jze;
    private final a jzf = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.jaB != null && c.this.jaB.getListView() != null) {
                List<com.baidu.adp.widget.ListView.n> data = c.this.jaB.getListView().getData();
                if (!x.isEmpty(data) && c.this.jaB.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.n) x.remove(data, i)) != null) {
                    c.this.jaB.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.jzd.setFunAdController(aVar);
        this.jze.setFunAdController(aVar);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.jzc = frsFragment;
        this.jzd = new FrsLoadMoreModel(frsFragment, kVar);
        this.jze = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jze.a(this.jzf);
        this.jzd.a(this.jzf);
        this.jaB = frsFragment.cBi();
        this.jaT = frsFragment.cBd();
        this.jze.setSortType(this.jaT.getSortType());
        this.jzd.setSortType(this.jaT.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.jaT != null) {
            boolean cIw = this.jzc.cBd().cIw();
            if (this.jaT.cIx()) {
                return this.jze.a(z, cIw, arrayList, z3, z4);
            }
            return this.jzd.a(z, cIw, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.jaT != null) {
            if (this.jaT.cIx()) {
                this.jze.resetData();
            } else {
                this.jzd.resetData();
            }
        }
    }

    public boolean dF(List<Long> list) {
        if (this.jaT == null || this.jaT.cIx()) {
            return false;
        }
        return this.jzd.dF(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.jaT != null && this.jaB != null && frsViewData != null) {
            this.jzc.jaH = System.currentTimeMillis();
            if (this.jaT.cIx()) {
                if (this.jze.cBj() == 1 && !this.jaT.isLoading()) {
                    this.jze.setSortType(this.jaT.getSortType());
                    this.jze.cIc();
                    int pn = this.jze.getPn();
                    this.jze.setPn(pn);
                    this.jaT.zN(pn + 1);
                }
            } else if (this.jaT.cIn() == 1) {
                if (!this.jzd.isLoading && !this.jaT.isLoading()) {
                    int pn2 = this.jzd.getPn();
                    if (this.jzd.dF(frsViewData.getThreadListIds())) {
                        this.jzd.cIc();
                        this.jzd.setSortType(this.jaT.getSortType());
                        this.jzd.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.jzd.cBj() == 1) {
                        this.jzd.cIc();
                        this.jzd.setPn(pn2);
                        this.jaT.zN(pn2 + 1);
                        this.jzd.loadingDone = false;
                        this.jzd.loadIndex = 0;
                    }
                }
            } else if (!this.jaT.cIp()) {
                this.jaT.crT();
            }
        }
    }

    public int cBj() {
        if (this.jaT == null) {
            return -1;
        }
        if (this.jaT.cIx()) {
            return this.jze.cBj();
        }
        return this.jzd.cBj();
    }

    public void setHasMore(int i) {
        if (this.jaT != null) {
            if (this.jaT.cIx()) {
                this.jze.setHasMore(i);
            } else {
                this.jzd.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.jaT == null) {
            return 1;
        }
        if (this.jaT.cIx()) {
            return this.jze.getPn();
        }
        return this.jzd.getPn();
    }

    public void setPn(int i) {
        if (this.jaT != null) {
            if (this.jaT.cIx()) {
                this.jze.setPn(i);
            } else {
                this.jzd.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.jaT.cIx() ? this.jze.getDataList() : this.jaT.cIr();
    }

    public FrsSmartLoadMoreModel cIf() {
        return this.jze;
    }

    public void d(com.baidu.adp.widget.ListView.n nVar) {
        if (nVar != null) {
            if (this.jaT.cIx()) {
                this.jze.d(nVar);
            } else {
                this.jzd.d(nVar);
            }
        }
    }
}
