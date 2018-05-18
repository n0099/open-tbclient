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
    private final com.baidu.tieba.frs.i cYo;
    private final FrsModelController cYw;
    private final FrsFragment dof;
    private final FrsLoadMoreModel dog;
    private final FrsSmartLoadMoreModel doh;
    private final a doi = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.cYo != null && c.this.cYo.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.cYo.getListView().getData();
                if (!v.w(data) && c.this.cYo.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) v.d(data, i)) != null) {
                    c.this.cYo.getListView().getAdapter().notifyItemRemoved(i);
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
        this.dof = frsFragment;
        this.dog = new FrsLoadMoreModel(frsFragment, iVar);
        this.doh = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.doh.a(this.doi);
        this.dog.a(this.doi);
        this.cYo = frsFragment.apm();
        this.cYw = frsFragment.apg();
        this.doh.setSortType(this.cYw.Ri());
        this.dog.setSortType(this.cYw.Ri());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.cYw != null) {
            boolean aup = this.dof.apg().aup();
            if (this.cYw.auq()) {
                return this.doh.a(z, aup, arrayList, z3);
            }
            return this.dog.a(z, aup, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cYw != null) {
            if (this.cYw.auq()) {
                this.doh.resetData();
            } else {
                this.dog.resetData();
            }
        }
    }

    public boolean br(List<Long> list) {
        if (this.cYw == null || this.cYw.auq()) {
            return false;
        }
        return this.dog.br(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.cYw != null && this.cYo != null && lVar != null) {
            if (this.cYw.auq()) {
                if (this.doh.apn() == 1 && !this.cYw.wW()) {
                    this.doh.setSortType(this.cYw.Ri());
                    this.doh.atX();
                    int pn = this.doh.getPn();
                    this.doh.setPn(pn);
                    this.cYw.kQ(pn + 1);
                }
            } else if (this.cYw.aug() == 1) {
                if (!this.dog.isLoading && !this.cYw.wW()) {
                    int pn2 = this.dog.getPn();
                    if (this.dog.br(lVar.bqf())) {
                        this.dog.atX();
                        this.dog.setSortType(this.cYw.Ri());
                        this.dog.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.bqf(), str, pn2);
                    } else if (this.dog.apn() == 1) {
                        this.dog.atX();
                        this.dog.setPn(pn2);
                        this.cYw.kQ(pn2 + 1);
                        this.dog.loadingDone = false;
                        this.dog.loadIndex = 0;
                    }
                }
            } else if (!this.cYw.auj()) {
                this.cYw.agL();
            }
        }
    }

    public int apn() {
        if (this.cYw == null) {
            return -1;
        }
        if (this.cYw.auq()) {
            return this.doh.apn();
        }
        return this.dog.apn();
    }

    public void setHasMore(int i) {
        if (this.cYw != null) {
            if (this.cYw.auq()) {
                this.doh.setHasMore(i);
            } else {
                this.dog.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cYw == null) {
            return 1;
        }
        if (this.cYw.auq()) {
            return this.doh.getPn();
        }
        return this.dog.getPn();
    }

    public void setPn(int i) {
        if (this.cYw != null) {
            if (this.cYw.auq()) {
                this.doh.setPn(i);
            } else {
                this.dog.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.cYw.auq() ? this.doh.getDataList() : this.cYw.aul();
    }

    public FrsSmartLoadMoreModel aua() {
        return this.doh;
    }
}
