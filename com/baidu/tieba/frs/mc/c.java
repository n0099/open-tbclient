package com.baidu.tieba.frs.mc;

import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final FrsFragment dAK;
    private final FrsLoadMoreModel dAL;
    private final FrsSmartLoadMoreModel dAM;
    private final a dAN = new a() { // from class: com.baidu.tieba.frs.mc.c.1
        @Override // com.baidu.tieba.frs.mc.c.a
        public void removeItem(int i) {
            if (c.this.djA != null && c.this.djA.getListView() != null) {
                List<com.baidu.adp.widget.ListView.h> data = c.this.djA.getListView().getData();
                if (!w.A(data) && c.this.djA.getListView().getAdapter() != null && ((com.baidu.adp.widget.ListView.h) w.e(data, i)) != null) {
                    c.this.djA.getListView().getAdapter().notifyItemRemoved(i);
                }
            }
        }
    };
    private final k djA;
    private final FrsModelController djL;

    /* loaded from: classes2.dex */
    public interface a {
        void removeItem(int i);
    }

    public c(FrsFragment frsFragment, i iVar) {
        if (frsFragment == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dAK = frsFragment;
        this.dAL = new FrsLoadMoreModel(frsFragment, iVar);
        this.dAM = new FrsSmartLoadMoreModel(frsFragment, iVar);
        this.dAM.a(this.dAN);
        this.dAL.a(this.dAN);
        this.djA = frsFragment.atI();
        this.djL = frsFragment.atD();
        this.dAM.setSortType(this.djL.Vb());
        this.dAL.setSortType(this.djL.Vb());
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        return a(z, z2, arrayList, eVar, false, z3);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.h> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3, boolean z4) {
        if (this.djL != null) {
            boolean azi = this.dAK.atD().azi();
            if (this.djL.azj()) {
                return this.dAM.a(z, azi, arrayList, z3, z4);
            }
            return this.dAL.a(z, azi, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.djL != null) {
            if (this.djL.azj()) {
                this.dAM.resetData();
            } else {
                this.dAL.resetData();
            }
        }
    }

    public boolean by(List<Long> list) {
        if (this.djL == null || this.djL.azj()) {
            return false;
        }
        return this.dAL.by(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.djL != null && this.djA != null && lVar != null) {
            this.dAK.djB = System.currentTimeMillis();
            if (this.djL.azj()) {
                if (this.dAM.atJ() == 1 && !this.djL.AO()) {
                    this.dAM.setSortType(this.djL.Vb());
                    this.dAM.ayQ();
                    int pn = this.dAM.getPn();
                    this.dAM.setPn(pn);
                    this.djL.le(pn + 1);
                }
            } else if (this.djL.ayZ() == 1) {
                if (!this.dAL.isLoading && !this.djL.AO()) {
                    int pn2 = this.dAL.getPn();
                    if (this.dAL.by(lVar.bvG())) {
                        this.dAL.ayQ();
                        this.dAL.setSortType(this.djL.Vb());
                        this.dAL.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.bvG(), str, pn2, lVar.isBrandForum);
                    } else if (this.dAL.atJ() == 1) {
                        this.dAL.ayQ();
                        this.dAL.setPn(pn2);
                        this.djL.le(pn2 + 1);
                        this.dAL.loadingDone = false;
                        this.dAL.loadIndex = 0;
                    }
                }
            } else if (!this.djL.azc()) {
                this.djL.ajN();
            }
        }
    }

    public int atJ() {
        if (this.djL == null) {
            return -1;
        }
        if (this.djL.azj()) {
            return this.dAM.atJ();
        }
        return this.dAL.atJ();
    }

    public void setHasMore(int i) {
        if (this.djL != null) {
            if (this.djL.azj()) {
                this.dAM.setHasMore(i);
            } else {
                this.dAL.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.djL == null) {
            return 1;
        }
        if (this.djL.azj()) {
            return this.dAM.getPn();
        }
        return this.dAL.getPn();
    }

    public void setPn(int i) {
        if (this.djL != null) {
            if (this.djL.azj()) {
                this.dAM.setPn(i);
            } else {
                this.dAL.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> getDataList() {
        return this.djL.azj() ? this.dAM.getDataList() : this.djL.aze();
    }

    public FrsSmartLoadMoreModel ayT() {
        return this.dAM;
    }

    public void Y(bc bcVar) {
        if (bcVar != null) {
            if (this.djL.azj()) {
                this.dAM.Y(bcVar);
            } else {
                this.dAL.Y(bcVar);
            }
        }
    }
}
