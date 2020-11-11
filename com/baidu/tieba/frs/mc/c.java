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
    private final FrsModelController iHI;
    private final q iHp;
    private final FrsFragment jcU;
    private final FrsLoadMoreModel jcV;
    private final FrsSmartLoadMoreModel jcW;
    private final a jcX = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.iHp != null && c.this.iHp.getListView() != null) {
                List<com.baidu.adp.widget.ListView.q> data = c.this.iHp.getListView().getData();
                if (!y.isEmpty(data) && c.this.iHp.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.q) y.remove(data, i)) != null) {
                    c.this.iHp.getListView().getAdapter().notifyItemRemoved(i);
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
        this.jcU = frsFragment;
        this.jcV = new FrsLoadMoreModel(frsFragment, kVar);
        this.jcW = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.jcW.a(this.jcX);
        this.jcV.a(this.jcX);
        this.iHp = frsFragment.cyl();
        this.iHI = frsFragment.cyg();
        this.jcW.setSortType(this.iHI.getSortType());
        this.jcV.setSortType(this.iHI.getSortType());
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.q> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.iHI != null) {
            boolean cEv = this.jcU.cyg().cEv();
            if (this.iHI.cEw()) {
                return this.jcW.a(z, cEv, arrayList, z3, z4);
            }
            return this.jcV.a(z, cEv, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.iHI != null) {
            if (this.iHI.cEw()) {
                this.jcW.resetData();
            } else {
                this.jcV.resetData();
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m41do(List<Long> list) {
        if (this.iHI == null || this.iHI.cEw()) {
            return false;
        }
        return this.jcV.m40do(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
        if (this.iHI != null && this.iHp != null && frsViewData != null) {
            this.jcU.iHv = System.currentTimeMillis();
            if (this.iHI.cEw()) {
                if (this.jcW.cym() == 1 && !this.iHI.isLoading()) {
                    this.jcW.setSortType(this.iHI.getSortType());
                    this.jcW.cEb();
                    int pn = this.jcW.getPn();
                    this.jcW.setPn(pn);
                    this.iHI.zV(pn + 1);
                }
            } else if (this.iHI.cEm() == 1) {
                if (!this.jcV.isLoading && !this.iHI.isLoading()) {
                    int pn2 = this.jcV.getPn();
                    if (this.jcV.m40do(frsViewData.getThreadListIds())) {
                        this.jcV.cEb();
                        this.jcV.setSortType(this.iHI.getSortType());
                        this.jcV.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.jcV.cym() == 1) {
                        this.jcV.cEb();
                        this.jcV.setPn(pn2);
                        this.iHI.zV(pn2 + 1);
                        this.jcV.loadingDone = false;
                        this.jcV.loadIndex = 0;
                    }
                }
            } else if (!this.iHI.cEo()) {
                this.iHI.cpc();
            }
        }
    }

    public int cym() {
        if (this.iHI == null) {
            return -1;
        }
        if (this.iHI.cEw()) {
            return this.jcW.cym();
        }
        return this.jcV.cym();
    }

    public void setHasMore(int i) {
        if (this.iHI != null) {
            if (this.iHI.cEw()) {
                this.jcW.setHasMore(i);
            } else {
                this.jcV.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.iHI == null) {
            return 1;
        }
        if (this.iHI.cEw()) {
            return this.jcW.getPn();
        }
        return this.jcV.getPn();
    }

    public void setPn(int i) {
        if (this.iHI != null) {
            if (this.iHI.cEw()) {
                this.jcW.setPn(i);
            } else {
                this.jcV.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> getDataList() {
        return this.iHI.cEw() ? this.jcW.getDataList() : this.iHI.cEq();
    }

    public FrsSmartLoadMoreModel cEe() {
        return this.jcW;
    }

    public void d(com.baidu.adp.widget.ListView.q qVar) {
        if (qVar != null) {
            if (this.iHI.cEw()) {
                this.jcW.d(qVar);
            } else {
                this.jcV.d(qVar);
            }
        }
    }
}
