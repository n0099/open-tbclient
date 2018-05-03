package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final com.baidu.tieba.frs.i cXh;
    private final FrsModelController cXp;
    private final FrsFragment dmW;
    private final FrsLoadMoreModel dmX;
    private final FrsSmartLoadMoreModel dmY;
    private final a dmZ = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.cXh != null && c.this.cXh.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.cXh.getListView().getData();
                if (!v.w(data) && c.this.cXh.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.d(data, i)) != null) {
                    c.this.cXh.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, i iVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dmW = frsFragment;
        this.dmX = new FrsLoadMoreModel(frsFragment, iVar);
        this.dmY = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dmY.a(this.dmZ);
        this.dmX.a(this.dmZ);
        this.cXh = frsFragment.apn();
        this.cXp = frsFragment.aph();
        this.dmY.setSortType(this.cXp.Rl());
        this.dmX.setSortType(this.cXp.Rl());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cXp != null) {
            boolean auq = this.dmW.aph().auq();
            if (this.cXp.aur()) {
                return this.dmY.a(z, auq, arrayList, z3);
            }
            return this.dmX.a(z, auq, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cXp != null) {
            if (this.cXp.aur()) {
                this.dmY.resetData();
            } else {
                this.dmX.resetData();
            }
        }
    }

    public boolean bo(List<Long> list) {
        if (this.cXp == null || this.cXp.aur()) {
            return false;
        }
        return this.dmX.bo(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.cXp != null && this.cXh != null && lVar != null) {
            if (this.cXp.aur()) {
                if (this.dmY.apo() == 1 && !this.cXp.wX()) {
                    this.dmY.setSortType(this.cXp.Rl());
                    this.dmY.atY();
                    int pn = this.dmY.getPn();
                    this.dmY.setPn(pn);
                    this.cXp.kR(pn + 1);
                }
            } else if (this.cXp.auh() == 1) {
                if (!this.dmX.isLoading && !this.cXp.wX()) {
                    int pn2 = this.dmX.getPn();
                    if (this.dmX.bo(lVar.bqh())) {
                        this.dmX.atY();
                        this.dmX.setSortType(this.cXp.Rl());
                        this.dmX.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.bqh(), str, pn2);
                    } else if (this.dmX.apo() == 1) {
                        this.dmX.atY();
                        this.dmX.setPn(pn2);
                        this.cXp.kR(pn2 + 1);
                        this.dmX.loadingDone = false;
                        this.dmX.loadIndex = 0;
                    }
                }
            } else if (!this.cXp.auk()) {
                this.cXp.agL();
            }
        }
    }

    public int apo() {
        if (this.cXp == null) {
            return -1;
        }
        if (this.cXp.aur()) {
            return this.dmY.apo();
        }
        return this.dmX.apo();
    }

    public void setHasMore(int i) {
        if (this.cXp != null) {
            if (this.cXp.aur()) {
                this.dmY.setHasMore(i);
            } else {
                this.dmX.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cXp == null) {
            return 1;
        }
        if (this.cXp.aur()) {
            return this.dmY.getPn();
        }
        return this.dmX.getPn();
    }

    public void setPn(int i) {
        if (this.cXp != null) {
            if (this.cXp.aur()) {
                this.dmY.setPn(i);
            } else {
                this.dmX.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.cXp.aur() ? this.dmY.getDataList() : this.cXp.aum();
    }

    public FrsSmartLoadMoreModel aub() {
        return this.dmY;
    }
}
