package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private final k dBD;
    private final FrsModelController dBL;
    private final com.baidu.tieba.frs.i dPK;
    private final FrsLoadMoreModel dPL;
    private final FrsSmartLoadMoreModel dPM;

    public c(com.baidu.tieba.frs.i iVar, i iVar2) {
        if (iVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.dPK = iVar;
        this.dPL = new FrsLoadMoreModel(iVar, iVar2);
        this.dPM = new FrsSmartLoadMoreModel(iVar, iVar2);
        this.dBD = iVar.aud();
        this.dBL = iVar.atY();
        this.dPM.setSortType(this.dBL.XH());
        this.dPL.setSortType(this.dBL.XH());
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        return a(z, z2, arrayList, eVar, false);
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, com.baidu.tieba.tbadkCore.data.e eVar, boolean z3) {
        if (this.dBL != null) {
            boolean ayy = this.dPK.atY().ayy();
            if (this.dBL.ayz()) {
                return this.dPM.a(z, ayy, arrayList, z3);
            }
            return this.dPL.a(z, ayy, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.dBL != null) {
            if (this.dBL.ayz()) {
                this.dPM.resetData();
            } else {
                this.dPL.resetData();
            }
        }
    }

    public boolean bt(List<Long> list) {
        if (this.dBL == null || this.dBL.ayz()) {
            return false;
        }
        return this.dPL.bt(list);
    }

    public void a(String str, String str2, l lVar) {
        if (this.dBL != null && this.dBD != null && lVar != null) {
            if (this.dBL.ayz()) {
                if (this.dPM.aue() == 1 && !this.dBL.DR()) {
                    this.dPM.setSortType(this.dBL.XH());
                    this.dBD.a(this.dPM.getDataList(), lVar);
                    int pn = this.dPM.getPn();
                    this.dPM.setPn(pn);
                    this.dBL.nE(pn + 1);
                }
            } else if (this.dBL.ayp() == 1) {
                if (!this.dPL.isLoading && !this.dBL.DR()) {
                    int pn2 = this.dPL.getPn();
                    if (this.dPL.bt(lVar.btK())) {
                        this.dBD.a(this.dPL.ayg(), lVar);
                        this.dPL.setSortType(this.dBL.XH());
                        this.dPL.a(com.baidu.adp.lib.g.b.c(str2, 0L), lVar.btK(), str, pn2);
                    } else if (this.dPL.aue() == 1) {
                        this.dBD.a(this.dPL.ayg(), lVar);
                        this.dPL.setPn(pn2);
                        this.dBL.nE(pn2 + 1);
                        this.dPL.loadingDone = false;
                        this.dPL.loadIndex = 0;
                    }
                }
            } else if (!this.dBL.ays()) {
                this.dBL.ame();
            }
        }
    }

    public int aue() {
        if (this.dBL == null) {
            return -1;
        }
        if (this.dBL.ayz()) {
            return this.dPM.aue();
        }
        return this.dPL.aue();
    }

    public void setHasMore(int i) {
        if (this.dBL != null) {
            if (this.dBL.ayz()) {
                this.dPM.setHasMore(i);
            } else {
                this.dPL.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.dBL == null) {
            return 1;
        }
        if (this.dBL.ayz()) {
            return this.dPM.getPn();
        }
        return this.dPL.getPn();
    }

    public void setPn(int i) {
        if (this.dBL != null) {
            if (this.dBL.ayz()) {
                this.dPM.setPn(i);
            } else {
                this.dPL.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getDataList() {
        return this.dBL.ayz() ? this.dPM.getDataList() : this.dBL.ayu();
    }

    public FrsSmartLoadMoreModel ayj() {
        return this.dPM;
    }
}
