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
    private final q iSX;
    private final FrsModelController iTp;
    private final FrsFragment jrm;
    private final FrsLoadMoreModel jrn;
    private final FrsSmartLoadMoreModel jro;
    private final a jrp = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.iSX != null && c.this.iSX.getListView() != null) {
                List<com.baidu.adp.widget.ListView.q> data = c.this.iSX.getListView().getData();
                if (!y.isEmpty(data) && c.this.iSX.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.q) y.remove(data, i)) != null) {
                    c.this.iSX.getListView().getAdapter().notifyItemRemoved(i);
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
        this.jrm = frsFragment;
        this.jrn = new FrsLoadMoreModel(frsFragment, kVar);
        this.jro = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jro.a(this.jrp);
        this.jrn.a(this.jrp);
        this.iSX = frsFragment.cCf();
        this.iTp = frsFragment.cCa();
        this.jro.setSortType(this.iTp.getSortType());
        this.jrn.setSortType(this.iTp.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.iTp != null) {
            boolean cJn = this.jrm.cCa().cJn();
            if (this.iTp.cJo()) {
                return this.jro.a(z, cJn, arrayList, z3, z4);
            }
            return this.jrn.a(z, cJn, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.iTp != null) {
            if (this.iTp.cJo()) {
                this.jro.resetData();
            } else {
                this.jrn.resetData();
            }
        }
    }

    public boolean dx(List<Long> list) {
        if (this.iTp == null || this.iTp.cJo()) {
            return false;
        }
        return this.jrn.dx(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.iTp != null && this.iSX != null && frsViewData != null) {
            this.jrm.iTd = System.currentTimeMillis();
            if (this.iTp.cJo()) {
                if (this.jro.cCg() == 1 && !this.iTp.isLoading()) {
                    this.jro.setSortType(this.iTp.getSortType());
                    this.jro.cIT();
                    int pn = this.jro.getPn();
                    this.jro.setPn(pn);
                    this.iTp.Bh(pn + 1);
                }
            } else if (this.iTp.cJe() == 1) {
                if (!this.jrn.isLoading && !this.iTp.isLoading()) {
                    int pn2 = this.jrn.getPn();
                    if (this.jrn.dx(frsViewData.getThreadListIds())) {
                        this.jrn.cIT();
                        this.jrn.setSortType(this.iTp.getSortType());
                        this.jrn.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.jrn.cCg() == 1) {
                        this.jrn.cIT();
                        this.jrn.setPn(pn2);
                        this.iTp.Bh(pn2 + 1);
                        this.jrn.loadingDone = false;
                        this.jrn.loadIndex = 0;
                    }
                }
            } else if (!this.iTp.cJg()) {
                this.iTp.csR();
            }
        }
    }

    public int cCg() {
        if (this.iTp == null) {
            return -1;
        }
        if (this.iTp.cJo()) {
            return this.jro.cCg();
        }
        return this.jrn.cCg();
    }

    public void setHasMore(int i) {
        if (this.iTp != null) {
            if (this.iTp.cJo()) {
                this.jro.setHasMore(i);
            } else {
                this.jrn.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.iTp == null) {
            return 1;
        }
        if (this.iTp.cJo()) {
            return this.jro.getPn();
        }
        return this.jrn.getPn();
    }

    public void setPn(int i) {
        if (this.iTp != null) {
            if (this.iTp.cJo()) {
                this.jro.setPn(i);
            } else {
                this.jrn.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iTp.cJo() ? this.jro.getDataList() : this.iTp.cJi();
    }

    public FrsSmartLoadMoreModel cIW() {
        return this.jro;
    }

    public void d(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar != null) {
            if (this.iTp.cJo()) {
                this.jro.d(qVar);
            } else {
                this.jrn.d(qVar);
            }
        }
    }
}
