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
    private final FrsFragment iae;
    private final FrsLoadMoreModel iaf;
    private final FrsSmartLoadMoreModel iag;
    private final a iah = new a() { // from class: com.baidu.tieba.frs.mc.c.1
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
        this.iae = frsFragment;
        this.iaf = new FrsLoadMoreModel(frsFragment, kVar);
        this.iag = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.iag.a(this.iah);
        this.iaf.a(this.iah);
        this.hFz = frsFragment.cbw();
        this.hFS = frsFragment.cbr();
        this.iag.setSortType(this.hFS.getSortType());
        this.iaf.setSortType(this.hFS.getSortType());
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.hFS != null) {
            boolean chv = this.iae.cbr().chv();
            if (this.hFS.chw()) {
                return this.iag.a(z, chv, arrayList, z3, z4);
            }
            return this.iaf.a(z, chv, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.hFS != null) {
            if (this.hFS.chw()) {
                this.iag.resetData();
            } else {
                this.iaf.resetData();
            }
        }
    }

    public boolean cM(List<Long> list) {
        if (this.hFS == null || this.hFS.chw()) {
            return false;
        }
        return this.iaf.cM(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.hFS != null && this.hFz != null && frsViewData != null) {
            this.iae.hFF = System.currentTimeMillis();
            if (this.hFS.chw()) {
                if (this.iag.cbx() == 1 && !this.hFS.isLoading()) {
                    this.iag.setSortType(this.hFS.getSortType());
                    this.iag.chb();
                    int pn = this.iag.getPn();
                    this.iag.setPn(pn);
                    this.hFS.vR(pn + 1);
                }
            } else if (this.hFS.chm() == 1) {
                if (!this.iaf.isLoading && !this.hFS.isLoading()) {
                    int pn2 = this.iaf.getPn();
                    if (this.iaf.cM(frsViewData.getThreadListIds())) {
                        this.iaf.chb();
                        this.iaf.setSortType(this.hFS.getSortType());
                        this.iaf.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.iaf.cbx() == 1) {
                        this.iaf.chb();
                        this.iaf.setPn(pn2);
                        this.hFS.vR(pn2 + 1);
                        this.iaf.loadingDone = false;
                        this.iaf.loadIndex = 0;
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
            return this.iag.cbx();
        }
        return this.iaf.cbx();
    }

    public void setHasMore(int i) {
        if (this.hFS != null) {
            if (this.hFS.chw()) {
                this.iag.setHasMore(i);
            } else {
                this.iaf.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.hFS == null) {
            return 1;
        }
        if (this.hFS.chw()) {
            return this.iag.getPn();
        }
        return this.iaf.getPn();
    }

    public void setPn(int i) {
        if (this.hFS != null) {
            if (this.hFS.chw()) {
                this.iag.setPn(i);
            } else {
                this.iaf.setPn(i);
            }
        }
    }

    public ArrayList<q> getDataList() {
        return this.hFS.chw() ? this.iag.getDataList() : this.hFS.chq();
    }

    public FrsSmartLoadMoreModel che() {
        return this.iag;
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.hFS.chw()) {
                this.iag.d(qVar);
            } else {
                this.iaf.d(qVar);
            }
        }
    }
}
