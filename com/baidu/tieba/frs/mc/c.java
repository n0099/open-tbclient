package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class c {
    private final FrsFragment iKB;
    private final FrsLoadMoreModel iKC;
    private final FrsSmartLoadMoreModel iKD;
    private final a iKE = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.ioW != null && c.this.ioW.getListView() != null) {
                List<q> data = c.this.ioW.getListView().getData();
                if (!y.isEmpty(data) && c.this.ioW.getListView().getAdapter() != null && ((q) y.remove(data, i)) != null) {
                    c.this.ioW.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final com.baidu.tieba.frs.q ioW;
    private final FrsModelController ipp;

    /* loaded from: classes22.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.iKB = frsFragment;
        this.iKC = new FrsLoadMoreModel(frsFragment, kVar);
        this.iKD = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.iKD.a(this.iKE);
        this.iKC.a(this.iKE);
        this.ioW = frsFragment.csD();
        this.ipp = frsFragment.csy();
        this.iKD.setSortType(this.ipp.getSortType());
        this.iKC.setSortType(this.ipp.getSortType());
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.ipp != null) {
            boolean cyN = this.iKB.csy().cyN();
            if (this.ipp.cyO()) {
                return this.iKD.a(z, cyN, arrayList, z3, z4);
            }
            return this.iKC.a(z, cyN, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.ipp != null) {
            if (this.ipp.cyO()) {
                this.iKD.resetData();
            } else {
                this.iKC.resetData();
            }
        }
    }

    public boolean cX(List<Long> list) {
        if (this.ipp == null || this.ipp.cyO()) {
            return false;
        }
        return this.iKC.cX(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.ipp != null && this.ioW != null && frsViewData != null) {
            this.iKB.ipc = System.currentTimeMillis();
            if (this.ipp.cyO()) {
                if (this.iKD.csE() == 1 && !this.ipp.isLoading()) {
                    this.iKD.setSortType(this.ipp.getSortType());
                    this.iKD.cyt();
                    int pn = this.iKD.getPn();
                    this.iKD.setPn(pn);
                    this.ipp.zp(pn + 1);
                }
            } else if (this.ipp.cyE() == 1) {
                if (!this.iKC.isLoading && !this.ipp.isLoading()) {
                    int pn2 = this.iKC.getPn();
                    if (this.iKC.cX(frsViewData.getThreadListIds())) {
                        this.iKC.cyt();
                        this.iKC.setSortType(this.ipp.getSortType());
                        this.iKC.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.iKC.csE() == 1) {
                        this.iKC.cyt();
                        this.iKC.setPn(pn2);
                        this.ipp.zp(pn2 + 1);
                        this.iKC.loadingDone = false;
                        this.iKC.loadIndex = 0;
                    }
                }
            } else if (!this.ipp.cyG()) {
                this.ipp.cju();
            }
        }
    }

    public int csE() {
        if (this.ipp == null) {
            return -1;
        }
        if (this.ipp.cyO()) {
            return this.iKD.csE();
        }
        return this.iKC.csE();
    }

    public void setHasMore(int i) {
        if (this.ipp != null) {
            if (this.ipp.cyO()) {
                this.iKD.setHasMore(i);
            } else {
                this.iKC.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.ipp == null) {
            return 1;
        }
        if (this.ipp.cyO()) {
            return this.iKD.getPn();
        }
        return this.iKC.getPn();
    }

    public void setPn(int i) {
        if (this.ipp != null) {
            if (this.ipp.cyO()) {
                this.iKD.setPn(i);
            } else {
                this.iKC.setPn(i);
            }
        }
    }

    public ArrayList<q> getDataList() {
        return this.ipp.cyO() ? this.iKD.getDataList() : this.ipp.cyI();
    }

    public FrsSmartLoadMoreModel cyw() {
        return this.iKD;
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.ipp.cyO()) {
                this.iKD.d(qVar);
            } else {
                this.iKC.d(qVar);
            }
        }
    }
}
