package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final FrsModelController gYM;
    private final com.baidu.tieba.frs.n gYw;
    private final FrsFragment hro;
    private final FrsLoadMoreModel hrp;
    private final FrsSmartLoadMoreModel hrq;
    private final a hrr = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.gYw != null && c.this.gYw.getListView() != null) {
                List<com.baidu.adp.widget.ListView.m> data = c.this.gYw.getListView().getData();
                if (!v.isEmpty(data) && c.this.gYw.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.m) v.remove(data, i)) != null) {
                    c.this.gYw.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.hro = frsFragment;
        this.hrp = new FrsLoadMoreModel(frsFragment, kVar);
        this.hrq = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.hrq.a(this.hrr);
        this.hrp.a(this.hrr);
        this.gYw = frsFragment.bOv();
        this.gYM = frsFragment.bOq();
        this.hrq.setSortType(this.gYM.getSortType());
        this.hrp.setSortType(this.gYM.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.gYM != null) {
            boolean bUb = this.hro.bOq().bUb();
            if (this.gYM.bUc()) {
                return this.hrq.a(z, bUb, arrayList, z3, z4);
            }
            return this.hrp.a(z, bUb, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.gYM != null) {
            if (this.gYM.bUc()) {
                this.hrq.resetData();
            } else {
                this.hrp.resetData();
            }
        }
    }

    public boolean cz(List<Long> list) {
        if (this.gYM == null || this.gYM.bUc()) {
            return false;
        }
        return this.hrp.cz(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.gYM != null && this.gYw != null && frsViewData != null) {
            this.hro.gYB = System.currentTimeMillis();
            if (this.gYM.bUc()) {
                if (this.hrq.bOw() == 1 && !this.gYM.isLoading()) {
                    this.hrq.setSortType(this.gYM.getSortType());
                    this.hrq.bTI();
                    int pn = this.hrq.getPn();
                    this.hrq.setPn(pn);
                    this.gYM.un(pn + 1);
                }
            } else if (this.gYM.bTT() == 1) {
                if (!this.hrp.isLoading && !this.gYM.isLoading()) {
                    int pn2 = this.hrp.getPn();
                    if (this.hrp.cz(frsViewData.getThreadListIds())) {
                        this.hrp.bTI();
                        this.hrp.setSortType(this.gYM.getSortType());
                        this.hrp.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.hrp.bOw() == 1) {
                        this.hrp.bTI();
                        this.hrp.setPn(pn2);
                        this.gYM.un(pn2 + 1);
                        this.hrp.loadingDone = false;
                        this.hrp.loadIndex = 0;
                    }
                }
            } else if (!this.gYM.bTV()) {
                this.gYM.bFE();
            }
        }
    }

    public int bOw() {
        if (this.gYM == null) {
            return -1;
        }
        if (this.gYM.bUc()) {
            return this.hrq.bOw();
        }
        return this.hrp.bOw();
    }

    public void setHasMore(int i) {
        if (this.gYM != null) {
            if (this.gYM.bUc()) {
                this.hrq.setHasMore(i);
            } else {
                this.hrp.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.gYM == null) {
            return 1;
        }
        if (this.gYM.bUc()) {
            return this.hrq.getPn();
        }
        return this.hrp.getPn();
    }

    public void setPn(int i) {
        if (this.gYM != null) {
            if (this.gYM.bUc()) {
                this.hrq.setPn(i);
            } else {
                this.hrp.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gYM.bUc() ? this.hrq.getDataList() : this.gYM.bTX();
    }

    public FrsSmartLoadMoreModel bTL() {
        return this.hrq;
    }

    public void d(com.baidu.adp.widget.ListView.m mVar) {
        if (mVar != null) {
            if (this.gYM.bUc()) {
                this.hrq.d(mVar);
            } else {
                this.hrp.d(mVar);
            }
        }
    }
}
