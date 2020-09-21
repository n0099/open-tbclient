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
/* loaded from: classes21.dex */
public class c {
    private final q hZV;
    private final FrsModelController iao;
    private final FrsFragment ivI;
    private final FrsLoadMoreModel ivJ;
    private final FrsSmartLoadMoreModel ivK;
    private final a ivL = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.hZV != null && c.this.hZV.getListView() != null) {
                List<com.baidu.adp.widget.ListView.q> data = c.this.hZV.getListView().getData();
                if (!y.isEmpty(data) && c.this.hZV.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.q) y.remove(data, i)) != null) {
                    c.this.hZV.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.ivI = frsFragment;
        this.ivJ = new FrsLoadMoreModel(frsFragment, kVar);
        this.ivK = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.ivK.a(this.ivL);
        this.ivJ.a(this.ivL);
        this.hZV = frsFragment.cpf();
        this.iao = frsFragment.cpa();
        this.ivK.setSortType(this.iao.getSortType());
        this.ivJ.setSortType(this.iao.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.iao != null) {
            boolean cvq = this.ivI.cpa().cvq();
            if (this.iao.cvr()) {
                return this.ivK.a(z, cvq, arrayList, z3, z4);
            }
            return this.ivJ.a(z, cvq, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.iao != null) {
            if (this.iao.cvr()) {
                this.ivK.resetData();
            } else {
                this.ivJ.resetData();
            }
        }
    }

    public boolean cU(List<Long> list) {
        if (this.iao == null || this.iao.cvr()) {
            return false;
        }
        return this.ivJ.cU(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.iao != null && this.hZV != null && frsViewData != null) {
            this.ivI.iab = System.currentTimeMillis();
            if (this.iao.cvr()) {
                if (this.ivK.cpg() == 1 && !this.iao.isLoading()) {
                    this.ivK.setSortType(this.iao.getSortType());
                    this.ivK.cuW();
                    int pn = this.ivK.getPn();
                    this.ivK.setPn(pn);
                    this.iao.yJ(pn + 1);
                }
            } else if (this.iao.cvh() == 1) {
                if (!this.ivJ.isLoading && !this.iao.isLoading()) {
                    int pn2 = this.ivJ.getPn();
                    if (this.ivJ.cU(frsViewData.getThreadListIds())) {
                        this.ivJ.cuW();
                        this.ivJ.setSortType(this.iao.getSortType());
                        this.ivJ.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.ivJ.cpg() == 1) {
                        this.ivJ.cuW();
                        this.ivJ.setPn(pn2);
                        this.iao.yJ(pn2 + 1);
                        this.ivJ.loadingDone = false;
                        this.ivJ.loadIndex = 0;
                    }
                }
            } else if (!this.iao.cvj()) {
                this.iao.cfY();
            }
        }
    }

    public int cpg() {
        if (this.iao == null) {
            return -1;
        }
        if (this.iao.cvr()) {
            return this.ivK.cpg();
        }
        return this.ivJ.cpg();
    }

    public void setHasMore(int i) {
        if (this.iao != null) {
            if (this.iao.cvr()) {
                this.ivK.setHasMore(i);
            } else {
                this.ivJ.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.iao == null) {
            return 1;
        }
        if (this.iao.cvr()) {
            return this.ivK.getPn();
        }
        return this.ivJ.getPn();
    }

    public void setPn(int i) {
        if (this.iao != null) {
            if (this.iao.cvr()) {
                this.ivK.setPn(i);
            } else {
                this.ivJ.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iao.cvr() ? this.ivK.getDataList() : this.iao.cvl();
    }

    public FrsSmartLoadMoreModel cuZ() {
        return this.ivK;
    }

    public void d(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar != null) {
            if (this.iao.cvr()) {
                this.ivK.d(qVar);
            } else {
                this.ivJ.d(qVar);
            }
        }
    }
}
