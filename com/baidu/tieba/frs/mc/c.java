package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final FrsFragment dKj;
    private final FrsLoadMoreModel dKk;
    private final FrsSmartLoadMoreModel dKl;
    private final a dKm = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.dsl != null && c.this.dsl.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.dsl.getListView().getData();
                if (!v.z(data) && c.this.dsl.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.e(data, i)) != null) {
                    c.this.dsl.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final k dsl;
    private final FrsModelController dsw;

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, i iVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dKj = frsFragment;
        this.dKk = new FrsLoadMoreModel(frsFragment, iVar);
        this.dKl = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dKl.a(this.dKm);
        this.dKk.a(this.dKm);
        this.dsl = frsFragment.awe();
        this.dsw = frsFragment.avZ();
        this.dKl.setSortType(this.dsw.Xb());
        this.dKk.setSortType(this.dsw.Xb());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.dsw != null) {
            boolean aBU = this.dKj.avZ().aBU();
            if (this.dsw.aBV()) {
                return this.dKl.a(z, aBU, arrayList, z3, z4);
            }
            return this.dKk.a(z, aBU, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dsw != null) {
            if (this.dsw.aBV()) {
                this.dKl.resetData();
            } else {
                this.dKk.resetData();
            }
        }
    }

    public boolean by(List<Long> list) {
        if (this.dsw == null || this.dsw.aBV()) {
            return false;
        }
        return this.dKk.by(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dsw != null && this.dsl != null && lVar != null) {
            this.dKj.dsm = System.currentTimeMillis();
            if (this.dsw.aBV()) {
                if (this.dKl.awf() == 1 && !this.dsw.BO()) {
                    this.dKl.setSortType(this.dsw.Xb());
                    this.dKl.aBC();
                    int pn = this.dKl.getPn();
                    this.dKl.setPn(pn);
                    this.dsw.lR(pn + 1);
                }
            } else if (this.dsw.aBL() == 1) {
                if (!this.dKk.isLoading && !this.dsw.BO()) {
                    int pn2 = this.dKk.getPn();
                    if (this.dKk.by(lVar.bwR())) {
                        this.dKk.aBC();
                        this.dKk.setSortType(this.dsw.Xb());
                        this.dKk.a(com.baidu.adp.lib.g.b.d(str2, 0L), lVar.bwR(), str, pn2, lVar.isBrandForum);
                    } else if (this.dKk.awf() == 1) {
                        this.dKk.aBC();
                        this.dKk.setPn(pn2);
                        this.dsw.lR(pn2 + 1);
                        this.dKk.loadingDone = false;
                        this.dKk.loadIndex = 0;
                    }
                }
            } else if (!this.dsw.aBO()) {
                this.dsw.alZ();
            }
        }
    }

    public int awf() {
        if (this.dsw == null) {
            return -1;
        }
        if (this.dsw.aBV()) {
            return this.dKl.awf();
        }
        return this.dKk.awf();
    }

    public void setHasMore(int i) {
        if (this.dsw != null) {
            if (this.dsw.aBV()) {
                this.dKl.setHasMore(i);
            } else {
                this.dKk.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dsw == null) {
            return 1;
        }
        if (this.dsw.aBV()) {
            return this.dKl.getPn();
        }
        return this.dKk.getPn();
    }

    public void setPn(int i) {
        if (this.dsw != null) {
            if (this.dsw.aBV()) {
                this.dKl.setPn(i);
            } else {
                this.dKk.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.dsw.aBV() ? this.dKl.getDataList() : this.dsw.aBQ();
    }

    public FrsSmartLoadMoreModel aBF() {
        return this.dKl;
    }

    public void ab(bb bbVar) {
        if (bbVar != null) {
            if (this.dsw.aBV()) {
                this.dKl.ab(bbVar);
            } else {
                this.dKk.ab(bbVar);
            }
        }
    }
}
