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
    private final q iId;
    private final FrsModelController iIw;
    private final FrsFragment jdH;
    private final FrsLoadMoreModel jdI;
    private final FrsSmartLoadMoreModel jdJ;
    private final a jdK = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.iId != null && c.this.iId.getListView() != null) {
                List<com.baidu.adp.widget.ListView.q> data = c.this.iId.getListView().getData();
                if (!y.isEmpty(data) && c.this.iId.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.q) y.remove(data, i)) != null) {
                    c.this.iId.getListView().getAdapter().notifyItemRemoved(i);
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
        this.jdH = frsFragment;
        this.jdI = new FrsLoadMoreModel(frsFragment, kVar);
        this.jdJ = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jdJ.a(this.jdK);
        this.jdI.a(this.jdK);
        this.iId = frsFragment.cxO();
        this.iIw = frsFragment.cxJ();
        this.jdJ.setSortType(this.iIw.getSortType());
        this.jdI.setSortType(this.iIw.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.iIw != null) {
            boolean cDZ = this.jdH.cxJ().cDZ();
            if (this.iIw.cEa()) {
                return this.jdJ.a(z, cDZ, arrayList, z3, z4);
            }
            return this.jdI.a(z, cDZ, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.iIw != null) {
            if (this.iIw.cEa()) {
                this.jdJ.resetData();
            } else {
                this.jdI.resetData();
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m41do(List<Long> list) {
        if (this.iIw == null || this.iIw.cEa()) {
            return false;
        }
        return this.jdI.m40do(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.iIw != null && this.iId != null && frsViewData != null) {
            this.jdH.iIj = System.currentTimeMillis();
            if (this.iIw.cEa()) {
                if (this.jdJ.cxP() == 1 && !this.iIw.isLoading()) {
                    this.jdJ.setSortType(this.iIw.getSortType());
                    this.jdJ.cDF();
                    int pn = this.jdJ.getPn();
                    this.jdJ.setPn(pn);
                    this.iIw.At(pn + 1);
                }
            } else if (this.iIw.cDQ() == 1) {
                if (!this.jdI.isLoading && !this.iIw.isLoading()) {
                    int pn2 = this.jdI.getPn();
                    if (this.jdI.m40do(frsViewData.getThreadListIds())) {
                        this.jdI.cDF();
                        this.jdI.setSortType(this.iIw.getSortType());
                        this.jdI.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.jdI.cxP() == 1) {
                        this.jdI.cDF();
                        this.jdI.setPn(pn2);
                        this.iIw.At(pn2 + 1);
                        this.jdI.loadingDone = false;
                        this.jdI.loadIndex = 0;
                    }
                }
            } else if (!this.iIw.cDS()) {
                this.iIw.coD();
            }
        }
    }

    public int cxP() {
        if (this.iIw == null) {
            return -1;
        }
        if (this.iIw.cEa()) {
            return this.jdJ.cxP();
        }
        return this.jdI.cxP();
    }

    public void setHasMore(int i) {
        if (this.iIw != null) {
            if (this.iIw.cEa()) {
                this.jdJ.setHasMore(i);
            } else {
                this.jdI.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.iIw == null) {
            return 1;
        }
        if (this.iIw.cEa()) {
            return this.jdJ.getPn();
        }
        return this.jdI.getPn();
    }

    public void setPn(int i) {
        if (this.iIw != null) {
            if (this.iIw.cEa()) {
                this.jdJ.setPn(i);
            } else {
                this.jdI.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iIw.cEa() ? this.jdJ.getDataList() : this.iIw.cDU();
    }

    public FrsSmartLoadMoreModel cDI() {
        return this.jdJ;
    }

    public void d(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar != null) {
            if (this.iIw.cEa()) {
                this.jdJ.d(qVar);
            } else {
                this.jdI.d(qVar);
            }
        }
    }
}
