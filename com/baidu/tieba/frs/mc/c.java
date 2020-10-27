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
/* loaded from: classes22.dex */
public class c {
    private final FrsModelController iBL;
    private final q iBs;
    private final FrsFragment iWX;
    private final FrsLoadMoreModel iWY;
    private final FrsSmartLoadMoreModel iWZ;
    private final a iXa = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.iBs != null && c.this.iBs.getListView() != null) {
                List<com.baidu.adp.widget.ListView.q> data = c.this.iBs.getListView().getData();
                if (!y.isEmpty(data) && c.this.iBs.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.q) y.remove(data, i)) != null) {
                    c.this.iBs.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.iWX = frsFragment;
        this.iWY = new FrsLoadMoreModel(frsFragment, kVar);
        this.iWZ = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.iWZ.a(this.iXa);
        this.iWY.a(this.iXa);
        this.iBs = frsFragment.cvK();
        this.iBL = frsFragment.cvF();
        this.iWZ.setSortType(this.iBL.getSortType());
        this.iWY.setSortType(this.iBL.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.iBL != null) {
            boolean cBU = this.iWX.cvF().cBU();
            if (this.iBL.cBV()) {
                return this.iWZ.a(z, cBU, arrayList, z3, z4);
            }
            return this.iWY.a(z, cBU, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.iBL != null) {
            if (this.iBL.cBV()) {
                this.iWZ.resetData();
            } else {
                this.iWY.resetData();
            }
        }
    }

    public boolean dg(List<Long> list) {
        if (this.iBL == null || this.iBL.cBV()) {
            return false;
        }
        return this.iWY.dg(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.iBL != null && this.iBs != null && frsViewData != null) {
            this.iWX.iBy = System.currentTimeMillis();
            if (this.iBL.cBV()) {
                if (this.iWZ.cvL() == 1 && !this.iBL.isLoading()) {
                    this.iWZ.setSortType(this.iBL.getSortType());
                    this.iWZ.cBA();
                    int pn = this.iWZ.getPn();
                    this.iWZ.setPn(pn);
                    this.iBL.zI(pn + 1);
                }
            } else if (this.iBL.cBL() == 1) {
                if (!this.iWY.isLoading && !this.iBL.isLoading()) {
                    int pn2 = this.iWY.getPn();
                    if (this.iWY.dg(frsViewData.getThreadListIds())) {
                        this.iWY.cBA();
                        this.iWY.setSortType(this.iBL.getSortType());
                        this.iWY.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.iWY.cvL() == 1) {
                        this.iWY.cBA();
                        this.iWY.setPn(pn2);
                        this.iBL.zI(pn2 + 1);
                        this.iWY.loadingDone = false;
                        this.iWY.loadIndex = 0;
                    }
                }
            } else if (!this.iBL.cBN()) {
                this.iBL.cmB();
            }
        }
    }

    public int cvL() {
        if (this.iBL == null) {
            return -1;
        }
        if (this.iBL.cBV()) {
            return this.iWZ.cvL();
        }
        return this.iWY.cvL();
    }

    public void setHasMore(int i) {
        if (this.iBL != null) {
            if (this.iBL.cBV()) {
                this.iWZ.setHasMore(i);
            } else {
                this.iWY.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.iBL == null) {
            return 1;
        }
        if (this.iBL.cBV()) {
            return this.iWZ.getPn();
        }
        return this.iWY.getPn();
    }

    public void setPn(int i) {
        if (this.iBL != null) {
            if (this.iBL.cBV()) {
                this.iWZ.setPn(i);
            } else {
                this.iWY.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iBL.cBV() ? this.iWZ.getDataList() : this.iBL.cBP();
    }

    public FrsSmartLoadMoreModel cBD() {
        return this.iWZ;
    }

    public void d(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar != null) {
            if (this.iBL.cBV()) {
                this.iWZ.d(qVar);
            } else {
                this.iWY.d(qVar);
            }
        }
    }
}
