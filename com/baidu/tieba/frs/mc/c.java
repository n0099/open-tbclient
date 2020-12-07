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
    private final q iSV;
    private final FrsModelController iTn;
    private final FrsFragment jrk;
    private final FrsLoadMoreModel jrl;
    private final FrsSmartLoadMoreModel jrm;
    private final a jrn = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.iSV != null && c.this.iSV.getListView() != null) {
                List<com.baidu.adp.widget.ListView.q> data = c.this.iSV.getListView().getData();
                if (!y.isEmpty(data) && c.this.iSV.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.q) y.remove(data, i)) != null) {
                    c.this.iSV.getListView().getAdapter().notifyItemRemoved(i);
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
        this.jrk = frsFragment;
        this.jrl = new FrsLoadMoreModel(frsFragment, kVar);
        this.jrm = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jrm.a(this.jrn);
        this.jrl.a(this.jrn);
        this.iSV = frsFragment.cCe();
        this.iTn = frsFragment.cBZ();
        this.jrm.setSortType(this.iTn.getSortType());
        this.jrl.setSortType(this.iTn.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.iTn != null) {
            boolean cJm = this.jrk.cBZ().cJm();
            if (this.iTn.cJn()) {
                return this.jrm.a(z, cJm, arrayList, z3, z4);
            }
            return this.jrl.a(z, cJm, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.iTn != null) {
            if (this.iTn.cJn()) {
                this.jrm.resetData();
            } else {
                this.jrl.resetData();
            }
        }
    }

    public boolean dx(List<Long> list) {
        if (this.iTn == null || this.iTn.cJn()) {
            return false;
        }
        return this.jrl.dx(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.iTn != null && this.iSV != null && frsViewData != null) {
            this.jrk.iTb = System.currentTimeMillis();
            if (this.iTn.cJn()) {
                if (this.jrm.cCf() == 1 && !this.iTn.isLoading()) {
                    this.jrm.setSortType(this.iTn.getSortType());
                    this.jrm.cIS();
                    int pn = this.jrm.getPn();
                    this.jrm.setPn(pn);
                    this.iTn.Bh(pn + 1);
                }
            } else if (this.iTn.cJd() == 1) {
                if (!this.jrl.isLoading && !this.iTn.isLoading()) {
                    int pn2 = this.jrl.getPn();
                    if (this.jrl.dx(frsViewData.getThreadListIds())) {
                        this.jrl.cIS();
                        this.jrl.setSortType(this.iTn.getSortType());
                        this.jrl.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.jrl.cCf() == 1) {
                        this.jrl.cIS();
                        this.jrl.setPn(pn2);
                        this.iTn.Bh(pn2 + 1);
                        this.jrl.loadingDone = false;
                        this.jrl.loadIndex = 0;
                    }
                }
            } else if (!this.iTn.cJf()) {
                this.iTn.csQ();
            }
        }
    }

    public int cCf() {
        if (this.iTn == null) {
            return -1;
        }
        if (this.iTn.cJn()) {
            return this.jrm.cCf();
        }
        return this.jrl.cCf();
    }

    public void setHasMore(int i) {
        if (this.iTn != null) {
            if (this.iTn.cJn()) {
                this.jrm.setHasMore(i);
            } else {
                this.jrl.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.iTn == null) {
            return 1;
        }
        if (this.iTn.cJn()) {
            return this.jrm.getPn();
        }
        return this.jrl.getPn();
    }

    public void setPn(int i) {
        if (this.iTn != null) {
            if (this.iTn.cJn()) {
                this.jrm.setPn(i);
            } else {
                this.jrl.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iTn.cJn() ? this.jrm.getDataList() : this.iTn.cJh();
    }

    public FrsSmartLoadMoreModel cIV() {
        return this.jrm;
    }

    public void d(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar != null) {
            if (this.iTn.cJn()) {
                this.jrm.d(qVar);
            } else {
                this.jrl.d(qVar);
            }
        }
    }
}
