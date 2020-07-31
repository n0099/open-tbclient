package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    private final FrsModelController hFS;
    private final p hFz;
    private final FrsFragment iac;
    private final FrsLoadMoreModel iad;
    private final FrsSmartLoadMoreModel iae;
    private final a iaf = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.hFz != null && c.this.hFz.getListView() != null) {
                List<q> data = c.this.hFz.getListView().getData();
                if (!x.isEmpty(data) && c.this.hFz.getListView().getAdapter() != null && ((q) x.remove(data, i)) != null) {
                    c.this.hFz.getListView().getAdapter().notifyItemRemoved(i);
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
        this.iac = frsFragment;
        this.iad = new FrsLoadMoreModel(frsFragment, kVar);
        this.iae = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.iae.a(this.iaf);
        this.iad.a(this.iaf);
        this.hFz = frsFragment.cbw();
        this.hFS = frsFragment.cbr();
        this.iae.setSortType(this.hFS.getSortType());
        this.iad.setSortType(this.hFS.getSortType());
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.hFS != null) {
            boolean chv = this.iac.cbr().chv();
            if (this.hFS.chw()) {
                return this.iae.a(z, chv, arrayList, z3, z4);
            }
            return this.iad.a(z, chv, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.hFS != null) {
            if (this.hFS.chw()) {
                this.iae.resetData();
            } else {
                this.iad.resetData();
            }
        }
    }

    public boolean cM(List<Long> list) {
        if (this.hFS == null || this.hFS.chw()) {
            return false;
        }
        return this.iad.cM(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.hFS != null && this.hFz != null && frsViewData != null) {
            this.iac.hFF = System.currentTimeMillis();
            if (this.hFS.chw()) {
                if (this.iae.cbx() == 1 && !this.hFS.isLoading()) {
                    this.iae.setSortType(this.hFS.getSortType());
                    this.iae.chb();
                    int pn = this.iae.getPn();
                    this.iae.setPn(pn);
                    this.hFS.vR(pn + 1);
                }
            } else if (this.hFS.chm() == 1) {
                if (!this.iad.isLoading && !this.hFS.isLoading()) {
                    int pn2 = this.iad.getPn();
                    if (this.iad.cM(frsViewData.getThreadListIds())) {
                        this.iad.chb();
                        this.iad.setSortType(this.hFS.getSortType());
                        this.iad.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.iad.cbx() == 1) {
                        this.iad.chb();
                        this.iad.setPn(pn2);
                        this.hFS.vR(pn2 + 1);
                        this.iad.loadingDone = false;
                        this.iad.loadIndex = 0;
                    }
                }
            } else if (!this.hFS.cho()) {
                this.hFS.bSw();
            }
        }
    }

    public int cbx() {
        if (this.hFS == null) {
            return -1;
        }
        if (this.hFS.chw()) {
            return this.iae.cbx();
        }
        return this.iad.cbx();
    }

    public void setHasMore(int i) {
        if (this.hFS != null) {
            if (this.hFS.chw()) {
                this.iae.setHasMore(i);
            } else {
                this.iad.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.hFS == null) {
            return 1;
        }
        if (this.hFS.chw()) {
            return this.iae.getPn();
        }
        return this.iad.getPn();
    }

    public void setPn(int i) {
        if (this.hFS != null) {
            if (this.hFS.chw()) {
                this.iae.setPn(i);
            } else {
                this.iad.setPn(i);
            }
        }
    }

    public ArrayList<q> getDataList() {
        return this.hFS.chw() ? this.iae.getDataList() : this.hFS.chq();
    }

    public FrsSmartLoadMoreModel che() {
        return this.iae;
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.hFS.chw()) {
                this.iae.d(qVar);
            } else {
                this.iad.d(qVar);
            }
        }
    }
}
