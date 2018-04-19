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
    private final com.baidu.tieba.frs.i cXk;
    private final FrsModelController cXs;
    private final FrsFragment dmZ;
    private final FrsLoadMoreModel dna;
    private final FrsSmartLoadMoreModel dnb;
    private final a dnc = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.cXk != null && c.this.cXk.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.cXk.getListView().getData();
                if (!v.w(data) && c.this.cXk.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.d(data, i)) != null) {
                    c.this.cXk.getListView().getAdapter().notifyItemRemoved(i);
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
        this.dmZ = frsFragment;
        this.dna = new FrsLoadMoreModel(frsFragment, iVar);
        this.dnb = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dnb.a(this.dnc);
        this.dna.a(this.dnc);
        this.cXk = frsFragment.apn();
        this.cXs = frsFragment.aph();
        this.dnb.setSortType(this.cXs.Rl());
        this.dna.setSortType(this.cXs.Rl());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cXs != null) {
            boolean auq = this.dmZ.aph().auq();
            if (this.cXs.aur()) {
                return this.dnb.a(z, auq, arrayList, z3);
            }
            return this.dna.a(z, auq, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cXs != null) {
            if (this.cXs.aur()) {
                this.dnb.resetData();
            } else {
                this.dna.resetData();
            }
        }
    }

    public boolean bo(List<Long> list) {
        if (this.cXs == null || this.cXs.aur()) {
            return false;
        }
        return this.dna.bo(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.cXs != null && this.cXk != null && lVar != null) {
            if (this.cXs.aur()) {
                if (this.dnb.apo() == 1 && !this.cXs.wX()) {
                    this.dnb.setSortType(this.cXs.Rl());
                    this.dnb.atY();
                    int pn = this.dnb.getPn();
                    this.dnb.setPn(pn);
                    this.cXs.kR(pn + 1);
                }
            } else if (this.cXs.auh() == 1) {
                if (!this.dna.isLoading && !this.cXs.wX()) {
                    int pn2 = this.dna.getPn();
                    if (this.dna.bo(lVar.bqh())) {
                        this.dna.atY();
                        this.dna.setSortType(this.cXs.Rl());
                        this.dna.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.bqh(), str, pn2);
                    } else if (this.dna.apo() == 1) {
                        this.dna.atY();
                        this.dna.setPn(pn2);
                        this.cXs.kR(pn2 + 1);
                        this.dna.loadingDone = false;
                        this.dna.loadIndex = 0;
                    }
                }
            } else if (!this.cXs.auk()) {
                this.cXs.agL();
            }
        }
    }

    public int apo() {
        if (this.cXs == null) {
            return -1;
        }
        if (this.cXs.aur()) {
            return this.dnb.apo();
        }
        return this.dna.apo();
    }

    public void setHasMore(int i) {
        if (this.cXs != null) {
            if (this.cXs.aur()) {
                this.dnb.setHasMore(i);
            } else {
                this.dna.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cXs == null) {
            return 1;
        }
        if (this.cXs.aur()) {
            return this.dnb.getPn();
        }
        return this.dna.getPn();
    }

    public void setPn(int i) {
        if (this.cXs != null) {
            if (this.cXs.aur()) {
                this.dnb.setPn(i);
            } else {
                this.dna.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.cXs.aur() ? this.dnb.getDataList() : this.cXs.aum();
    }

    public FrsSmartLoadMoreModel aub() {
        return this.dnb;
    }
}
