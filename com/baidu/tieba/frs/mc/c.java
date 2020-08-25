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
/* loaded from: classes16.dex */
public class c {
    private final q hSP;
    private final FrsModelController hTi;
    private final FrsFragment iom;
    private final FrsLoadMoreModel ion;
    private final FrsSmartLoadMoreModel ioo;
    private final a iop = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.hSP != null && c.this.hSP.getListView() != null) {
                List<com.baidu.adp.widget.ListView.q> data = c.this.hSP.getListView().getData();
                if (!y.isEmpty(data) && c.this.hSP.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.q) y.remove(data, i)) != null) {
                    c.this.hSP.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.iom = frsFragment;
        this.ion = new FrsLoadMoreModel(frsFragment, kVar);
        this.ioo = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.ioo.a(this.iop);
        this.ion.a(this.iop);
        this.hSP = frsFragment.clS();
        this.hTi = frsFragment.clN();
        this.ioo.setSortType(this.hTi.getSortType());
        this.ion.setSortType(this.hTi.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.hTi != null) {
            boolean csa = this.iom.clN().csa();
            if (this.hTi.csb()) {
                return this.ioo.a(z, csa, arrayList, z3, z4);
            }
            return this.ion.a(z, csa, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.hTi != null) {
            if (this.hTi.csb()) {
                this.ioo.resetData();
            } else {
                this.ion.resetData();
            }
        }
    }

    public boolean cO(List<Long> list) {
        if (this.hTi == null || this.hTi.csb()) {
            return false;
        }
        return this.ion.cO(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.hTi != null && this.hSP != null && frsViewData != null) {
            this.iom.hSV = System.currentTimeMillis();
            if (this.hTi.csb()) {
                if (this.ioo.clT() == 1 && !this.hTi.isLoading()) {
                    this.ioo.setSortType(this.hTi.getSortType());
                    this.ioo.crG();
                    int pn = this.ioo.getPn();
                    this.ioo.setPn(pn);
                    this.hTi.yk(pn + 1);
                }
            } else if (this.hTi.crR() == 1) {
                if (!this.ion.isLoading && !this.hTi.isLoading()) {
                    int pn2 = this.ion.getPn();
                    if (this.ion.cO(frsViewData.getThreadListIds())) {
                        this.ion.crG();
                        this.ion.setSortType(this.hTi.getSortType());
                        this.ion.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.ion.clT() == 1) {
                        this.ion.crG();
                        this.ion.setPn(pn2);
                        this.hTi.yk(pn2 + 1);
                        this.ion.loadingDone = false;
                        this.ion.loadIndex = 0;
                    }
                }
            } else if (!this.hTi.crT()) {
                this.hTi.ccI();
            }
        }
    }

    public int clT() {
        if (this.hTi == null) {
            return -1;
        }
        if (this.hTi.csb()) {
            return this.ioo.clT();
        }
        return this.ion.clT();
    }

    public void setHasMore(int i) {
        if (this.hTi != null) {
            if (this.hTi.csb()) {
                this.ioo.setHasMore(i);
            } else {
                this.ion.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.hTi == null) {
            return 1;
        }
        if (this.hTi.csb()) {
            return this.ioo.getPn();
        }
        return this.ion.getPn();
    }

    public void setPn(int i) {
        if (this.hTi != null) {
            if (this.hTi.csb()) {
                this.ioo.setPn(i);
            } else {
                this.ion.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.hTi.csb() ? this.ioo.getDataList() : this.hTi.crV();
    }

    public FrsSmartLoadMoreModel crJ() {
        return this.ioo;
    }

    public void d(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar != null) {
            if (this.hTi.csb()) {
                this.ioo.d(qVar);
            } else {
                this.ion.d(qVar);
            }
        }
    }
}
