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
        this.gYw = frsFragment.bOw();
        this.gYM = frsFragment.bOr();
        this.hrq.setSortType(this.gYM.getSortType());
        this.hrp.setSortType(this.gYM.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.gYM != null) {
            boolean bUc = this.hro.bOr().bUc();
            if (this.gYM.bUd()) {
                return this.hrq.a(z, bUc, arrayList, z3, z4);
            }
            return this.hrp.a(z, bUc, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.gYM != null) {
            if (this.gYM.bUd()) {
                this.hrq.resetData();
            } else {
                this.hrp.resetData();
            }
        }
    }

    public boolean cz(List<Long> list) {
        if (this.gYM == null || this.gYM.bUd()) {
            return false;
        }
        return this.hrp.cz(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.gYM != null && this.gYw != null && frsViewData != null) {
            this.hro.gYB = System.currentTimeMillis();
            if (this.gYM.bUd()) {
                if (this.hrq.bOx() == 1 && !this.gYM.isLoading()) {
                    this.hrq.setSortType(this.gYM.getSortType());
                    this.hrq.bTJ();
                    int pn = this.hrq.getPn();
                    this.hrq.setPn(pn);
                    this.gYM.un(pn + 1);
                }
            } else if (this.gYM.bTU() == 1) {
                if (!this.hrp.isLoading && !this.gYM.isLoading()) {
                    int pn2 = this.hrp.getPn();
                    if (this.hrp.cz(frsViewData.getThreadListIds())) {
                        this.hrp.bTJ();
                        this.hrp.setSortType(this.gYM.getSortType());
                        this.hrp.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.hrp.bOx() == 1) {
                        this.hrp.bTJ();
                        this.hrp.setPn(pn2);
                        this.gYM.un(pn2 + 1);
                        this.hrp.loadingDone = false;
                        this.hrp.loadIndex = 0;
                    }
                }
            } else if (!this.gYM.bTW()) {
                this.gYM.bFF();
            }
        }
    }

    public int bOx() {
        if (this.gYM == null) {
            return -1;
        }
        if (this.gYM.bUd()) {
            return this.hrq.bOx();
        }
        return this.hrp.bOx();
    }

    public void setHasMore(int i) {
        if (this.gYM != null) {
            if (this.gYM.bUd()) {
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
        if (this.gYM.bUd()) {
            return this.hrq.getPn();
        }
        return this.hrp.getPn();
    }

    public void setPn(int i) {
        if (this.gYM != null) {
            if (this.gYM.bUd()) {
                this.hrq.setPn(i);
            } else {
                this.hrp.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> getDataList() {
        return this.gYM.bUd() ? this.hrq.getDataList() : this.gYM.bTY();
    }

    public FrsSmartLoadMoreModel bTM() {
        return this.hrq;
    }

    public void d(com.baidu.adp.widget.ListView.m mVar) {
        if (mVar != null) {
            if (this.gYM.bUd()) {
                this.hrq.d(mVar);
            } else {
                this.hrp.d(mVar);
            }
        }
    }
}
