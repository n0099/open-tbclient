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
    private final FrsFragment jDI;
    private final FrsLoadMoreModel jDJ;
    private final FrsSmartLoadMoreModel jDK;
    private final a jDL = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.jfi != null && c.this.jfi.getListView() != null) {
                List<com.baidu.adp.widget.ListView.n> data = c.this.jfi.getListView().getData();
                if (!x.isEmpty(data) && c.this.jfi.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.n) x.remove(data, i)) != null) {
                    c.this.jfi.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController jfA;
    private final q jfi;

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.jDJ.setFunAdController(aVar);
        this.jDK.setFunAdController(aVar);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.jDI = frsFragment;
        this.jDJ = new FrsLoadMoreModel(frsFragment, kVar);
        this.jDK = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jDK.a(this.jDL);
        this.jDJ.a(this.jDL);
        this.jfi = frsFragment.cEZ();
        this.jfA = frsFragment.cEU();
        this.jDK.setSortType(this.jfA.getSortType());
        this.jDJ.setSortType(this.jfA.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.n> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.jfA != null) {
            boolean cMn = this.jDI.cEU().cMn();
            if (this.jfA.cMo()) {
                return this.jDK.a(z, cMn, arrayList, z3, z4);
            }
            return this.jDJ.a(z, cMn, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.jfA != null) {
            if (this.jfA.cMo()) {
                this.jDK.resetData();
            } else {
                this.jDJ.resetData();
            }
        }
    }

    public boolean dF(List<Long> list) {
        if (this.jfA == null || this.jfA.cMo()) {
            return false;
        }
        return this.jDJ.dF(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.jfA != null && this.jfi != null && frsViewData != null) {
            this.jDI.jfo = System.currentTimeMillis();
            if (this.jfA.cMo()) {
                if (this.jDK.cFa() == 1 && !this.jfA.isLoading()) {
                    this.jDK.setSortType(this.jfA.getSortType());
                    this.jDK.cLT();
                    int pn = this.jDK.getPn();
                    this.jDK.setPn(pn);
                    this.jfA.Bt(pn + 1);
                }
            } else if (this.jfA.cMe() == 1) {
                if (!this.jDJ.isLoading && !this.jfA.isLoading()) {
                    int pn2 = this.jDJ.getPn();
                    if (this.jDJ.dF(frsViewData.getThreadListIds())) {
                        this.jDJ.cLT();
                        this.jDJ.setSortType(this.jfA.getSortType());
                        this.jDJ.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.jDJ.cFa() == 1) {
                        this.jDJ.cLT();
                        this.jDJ.setPn(pn2);
                        this.jfA.Bt(pn2 + 1);
                        this.jDJ.loadingDone = false;
                        this.jDJ.loadIndex = 0;
                    }
                }
            } else if (!this.jfA.cMg()) {
                this.jfA.cvK();
            }
        }
    }

    public int cFa() {
        if (this.jfA == null) {
            return -1;
        }
        if (this.jfA.cMo()) {
            return this.jDK.cFa();
        }
        return this.jDJ.cFa();
    }

    public void setHasMore(int i) {
        if (this.jfA != null) {
            if (this.jfA.cMo()) {
                this.jDK.setHasMore(i);
            } else {
                this.jDJ.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.jfA == null) {
            return 1;
        }
        if (this.jfA.cMo()) {
            return this.jDK.getPn();
        }
        return this.jDJ.getPn();
    }

    public void setPn(int i) {
        if (this.jfA != null) {
            if (this.jfA.cMo()) {
                this.jDK.setPn(i);
            } else {
                this.jDJ.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> getDataList() {
        return this.jfA.cMo() ? this.jDK.getDataList() : this.jfA.cMi();
    }

    public FrsSmartLoadMoreModel cLW() {
        return this.jDK;
    }

    public void d(com.baidu.adp.widget.ListView.n nVar) {
        if (nVar != null) {
            if (this.jfA.cMo()) {
                this.jDK.d(nVar);
            } else {
                this.jDJ.d(nVar);
            }
        }
    }
}
