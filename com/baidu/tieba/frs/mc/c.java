package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final com.baidu.tieba.frs.i dKN;
    private final FrsLoadMoreModel dKO;
    private final FrsSmartLoadMoreModel dKP;
    private final k dwH;
    private final FrsModelController dwP;

    public c(com.baidu.tieba.frs.i iVar, i iVar2) {
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dKN = iVar;
        this.dKO = new FrsLoadMoreModel(iVar, iVar2);
        this.dKP = new FrsSmartLoadMoreModel(iVar, iVar2);
        this.dwH = iVar.asV();
        this.dwP = iVar.asQ();
        this.dKP.setSortType(this.dwP.XR());
        this.dKO.setSortType(this.dwP.XR());
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.dwP != null) {
            boolean axq = this.dKN.asQ().axq();
            if (this.dwP.axr()) {
                return this.dKP.a(z, axq, arrayList, z3);
            }
            return this.dKO.a(z, axq, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dwP != null) {
            if (this.dwP.axr()) {
                this.dKP.resetData();
            } else {
                this.dKO.resetData();
            }
        }
    }

    public boolean bv(List<Long> list) {
        if (this.dwP == null || this.dwP.axr()) {
            return false;
        }
        return this.dKO.bv(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dwP != null && this.dwH != null && lVar != null) {
            if (this.dwP.axr()) {
                if (this.dKP.asW() == 1 && !this.dwP.DY()) {
                    this.dKP.setSortType(this.dwP.XR());
                    this.dwH.a(this.dKP.getDataList(), lVar);
                    int pn = this.dKP.getPn();
                    this.dKP.setPn(pn);
                    this.dwP.nB(pn + 1);
                }
            } else if (this.dwP.axh() == 1) {
                if (!this.dKO.isLoading && !this.dwP.DY()) {
                    int pn2 = this.dKO.getPn();
                    if (this.dKO.bv(lVar.bAm())) {
                        this.dwH.a(this.dKO.awY(), lVar);
                        this.dKO.setSortType(this.dwP.XR());
                        this.dKO.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.bAm(), str, pn2);
                    } else if (this.dKO.asW() == 1) {
                        this.dwH.a(this.dKO.awY(), lVar);
                        this.dKO.setPn(pn2);
                        this.dwP.nB(pn2 + 1);
                        this.dKO.loadingDone = false;
                        this.dKO.loadIndex = 0;
                    }
                }
            } else if (!this.dwP.axk()) {
                this.dwP.akW();
            }
        }
    }

    public int asW() {
        if (this.dwP == null) {
            return -1;
        }
        if (this.dwP.axr()) {
            return this.dKP.asW();
        }
        return this.dKO.asW();
    }

    public void setHasMore(int i) {
        if (this.dwP != null) {
            if (this.dwP.axr()) {
                this.dKP.setHasMore(i);
            } else {
                this.dKO.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dwP == null) {
            return 1;
        }
        if (this.dwP.axr()) {
            return this.dKP.getPn();
        }
        return this.dKO.getPn();
    }

    public void setPn(int i) {
        if (this.dwP != null) {
            if (this.dwP.axr()) {
                this.dKP.setPn(i);
            } else {
                this.dKO.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getDataList() {
        return this.dwP.axr() ? this.dKP.getDataList() : this.dwP.axm();
    }

    public FrsSmartLoadMoreModel axb() {
        return this.dKP;
    }
}
