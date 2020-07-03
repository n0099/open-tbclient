package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final FrsModelController hAc;
    private final FrsFragment hUd;
    private final FrsLoadMoreModel hUe;
    private final FrsSmartLoadMoreModel hUf;
    private final a hUg = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.hzK != null && c.this.hzK.getListView() != null) {
                List<q> data = c.this.hzK.getListView().getData();
                if (!w.isEmpty(data) && c.this.hzK.getListView().getAdapter() != null && ((q) w.remove(data, i)) != null) {
                    c.this.hzK.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final p hzK;

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.hUd = frsFragment;
        this.hUe = new FrsLoadMoreModel(frsFragment, kVar);
        this.hUf = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.hUf.a(this.hUg);
        this.hUe.a(this.hUg);
        this.hzK = frsFragment.bXZ();
        this.hAc = frsFragment.bXU();
        this.hUf.setSortType(this.hAc.getSortType());
        this.hUe.setSortType(this.hAc.getSortType());
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.hAc != null) {
            boolean cdV = this.hUd.bXU().cdV();
            if (this.hAc.cdW()) {
                return this.hUf.a(z, cdV, arrayList, z3, z4);
            }
            return this.hUe.a(z, cdV, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.hAc != null) {
            if (this.hAc.cdW()) {
                this.hUf.resetData();
            } else {
                this.hUe.resetData();
            }
        }
    }

    public boolean cH(List<Long> list) {
        if (this.hAc == null || this.hAc.cdW()) {
            return false;
        }
        return this.hUe.cH(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.hAc != null && this.hzK != null && frsViewData != null) {
            this.hUd.hzQ = System.currentTimeMillis();
            if (this.hAc.cdW()) {
                if (this.hUf.bYa() == 1 && !this.hAc.isLoading()) {
                    this.hUf.setSortType(this.hAc.getSortType());
                    this.hUf.cdB();
                    int pn = this.hUf.getPn();
                    this.hUf.setPn(pn);
                    this.hAc.vz(pn + 1);
                }
            } else if (this.hAc.cdM() == 1) {
                if (!this.hUe.isLoading && !this.hAc.isLoading()) {
                    int pn2 = this.hUe.getPn();
                    if (this.hUe.cH(frsViewData.getThreadListIds())) {
                        this.hUe.cdB();
                        this.hUe.setSortType(this.hAc.getSortType());
                        this.hUe.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.hUe.bYa() == 1) {
                        this.hUe.cdB();
                        this.hUe.setPn(pn2);
                        this.hAc.vz(pn2 + 1);
                        this.hUe.loadingDone = false;
                        this.hUe.loadIndex = 0;
                    }
                }
            } else if (!this.hAc.cdO()) {
                this.hAc.bPk();
            }
        }
    }

    public int bYa() {
        if (this.hAc == null) {
            return -1;
        }
        if (this.hAc.cdW()) {
            return this.hUf.bYa();
        }
        return this.hUe.bYa();
    }

    public void setHasMore(int i) {
        if (this.hAc != null) {
            if (this.hAc.cdW()) {
                this.hUf.setHasMore(i);
            } else {
                this.hUe.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.hAc == null) {
            return 1;
        }
        if (this.hAc.cdW()) {
            return this.hUf.getPn();
        }
        return this.hUe.getPn();
    }

    public void setPn(int i) {
        if (this.hAc != null) {
            if (this.hAc.cdW()) {
                this.hUf.setPn(i);
            } else {
                this.hUe.setPn(i);
            }
        }
    }

    public ArrayList<q> getDataList() {
        return this.hAc.cdW() ? this.hUf.getDataList() : this.hAc.cdQ();
    }

    public FrsSmartLoadMoreModel cdE() {
        return this.hUf;
    }

    public void d(q qVar) {
        if (qVar != null) {
            if (this.hAc.cdW()) {
                this.hUf.d(qVar);
            } else {
                this.hUe.d(qVar);
            }
        }
    }
}
