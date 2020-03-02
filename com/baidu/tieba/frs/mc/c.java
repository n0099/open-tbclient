package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private final FrsFragment gGF;
    private final FrsLoadMoreModel gGG;
    private final FrsSmartLoadMoreModel gGH;
    private final a gGI = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.gom != null && c.this.gom.getListView() != null) {
                List<m> data = c.this.gom.getListView().getData();
                if (!v.isEmpty(data) && c.this.gom.getListView().getAdapter() != null && ((m) v.remove(data, i)) != null) {
                    c.this.gom.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final FrsModelController goC;
    private final com.baidu.tieba.frs.l gom;

    /* loaded from: classes9.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, k kVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.gGF = frsFragment;
        this.gGG = new FrsLoadMoreModel(frsFragment, kVar);
        this.gGH = new FrsSmartLoadMoreModel(frsFragment, kVar);
        this.gGH.a(this.gGI);
        this.gGG.a(this.gGI);
        this.gom = frsFragment.bDP();
        this.goC = frsFragment.bDK();
        this.gGH.setSortType(this.goC.getSortType());
        this.gGG.setSortType(this.goC.getSortType());
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3) {
        return a(z, z2, arrayList, fVar, false, z3);
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, com.baidu.tieba.tbadkCore.data.f fVar, boolean z3, boolean z4) {
        if (this.goC != null) {
            boolean bJs = this.gGF.bDK().bJs();
            if (this.goC.bJt()) {
                return this.gGH.a(z, bJs, arrayList, z3, z4);
            }
            return this.gGG.a(z, bJs, z2, arrayList, fVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.goC != null) {
            if (this.goC.bJt()) {
                this.gGH.resetData();
            } else {
                this.gGG.resetData();
            }
        }
    }

    public boolean cn(List<Long> list) {
        if (this.goC == null || this.goC.bJt()) {
            return false;
        }
        return this.gGG.cn(list);
    }

    public void a(String str, String str2, FrsViewData frsViewData) {
        if (this.goC != null && this.gom != null && frsViewData != null) {
            this.gGF.gor = System.currentTimeMillis();
            if (this.goC.bJt()) {
                if (this.gGH.bDQ() == 1 && !this.goC.isLoading()) {
                    this.gGH.setSortType(this.goC.getSortType());
                    this.gGH.bJa();
                    int pn = this.gGH.getPn();
                    this.gGH.setPn(pn);
                    this.goC.tK(pn + 1);
                }
            } else if (this.goC.bJk() == 1) {
                if (!this.gGG.isLoading && !this.goC.isLoading()) {
                    int pn2 = this.gGG.getPn();
                    if (this.gGG.cn(frsViewData.getThreadListIds())) {
                        this.gGG.bJa();
                        this.gGG.setSortType(this.goC.getSortType());
                        this.gGG.a(com.baidu.adp.lib.f.b.toLong(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum);
                    } else if (this.gGG.bDQ() == 1) {
                        this.gGG.bJa();
                        this.gGG.setPn(pn2);
                        this.goC.tK(pn2 + 1);
                        this.gGG.loadingDone = false;
                        this.gGG.loadIndex = 0;
                    }
                }
            } else if (!this.goC.bJm()) {
                this.goC.bvP();
            }
        }
    }

    public int bDQ() {
        if (this.goC == null) {
            return -1;
        }
        if (this.goC.bJt()) {
            return this.gGH.bDQ();
        }
        return this.gGG.bDQ();
    }

    public void setHasMore(int i) {
        if (this.goC != null) {
            if (this.goC.bJt()) {
                this.gGH.setHasMore(i);
            } else {
                this.gGG.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.goC == null) {
            return 1;
        }
        if (this.goC.bJt()) {
            return this.gGH.getPn();
        }
        return this.gGG.getPn();
    }

    public void setPn(int i) {
        if (this.goC != null) {
            if (this.goC.bJt()) {
                this.gGH.setPn(i);
            } else {
                this.gGG.setPn(i);
            }
        }
    }

    public ArrayList<m> getDataList() {
        return this.goC.bJt() ? this.gGH.getDataList() : this.goC.bJo();
    }

    public FrsSmartLoadMoreModel bJd() {
        return this.gGH;
    }

    public void d(m mVar) {
        if (mVar != null) {
            if (this.goC.bJt()) {
                this.gGH.d(mVar);
            } else {
                this.gGG.d(mVar);
            }
        }
    }
}
