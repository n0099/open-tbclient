package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private final com.baidu.tieba.frs.i ciX;
    private final FrsModelController cjg;

    /* renamed from: com  reason: collision with root package name */
    private final com.baidu.tieba.frs.f f4com;
    private final FrsLoadMoreModel cuA;
    private final FrsSmartLoadMoreModel cuB;

    public d(com.baidu.tieba.frs.f fVar, j jVar) {
        if (fVar == null) {
            throw new NullPointerException("FrsFragment is NullPointerException");
        }
        this.f4com = fVar;
        this.cuA = new FrsLoadMoreModel(fVar, jVar);
        this.cuB = new FrsSmartLoadMoreModel(fVar, jVar);
        this.ciX = fVar.aeZ();
        this.cjg = fVar.aeU();
        this.cuB.setSortType(this.cjg.Om());
        this.cuA.setSortType(this.cjg.Om());
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.cjg != null) {
            boolean aiH = this.f4com.aeU().aiH();
            if (this.cjg.aiI()) {
                return this.cuB.a(z, aiH, arrayList);
            }
            return this.cuA.a(z, aiH, z2, arrayList, eVar);
        }
        return arrayList;
    }

    public void resetData() {
        if (this.cjg != null) {
            if (this.cjg.aiI()) {
                this.cuB.resetData();
            } else {
                this.cuA.resetData();
            }
        }
    }

    public boolean aK(List<Long> list) {
        if (this.cjg == null || this.cjg.aiI()) {
            return false;
        }
        return this.cuA.aK(list);
    }

    public void a(String str, String str2, com.baidu.tieba.tbadkCore.i iVar) {
        if (this.cjg != null && this.ciX != null && iVar != null) {
            if (this.cjg.aiI()) {
                if (this.cuB.afa() == 1 && !this.cjg.xc()) {
                    this.cuB.setSortType(this.cjg.Om());
                    this.ciX.a(this.cuB.getDataList(), iVar);
                    int pn = this.cuB.getPn();
                    this.cuB.setPn(pn);
                    this.cjg.jc(pn + 1);
                }
            } else if (this.cjg.aiy() == 1) {
                if (!this.cuA.isLoading && !this.cjg.xc()) {
                    int pn2 = this.cuA.getPn();
                    if (this.cuA.aK(iVar.bqH())) {
                        this.ciX.a(this.cuA.ahJ(), iVar);
                        this.cuA.setSortType(this.cjg.Om());
                        this.cuA.a(com.baidu.adp.lib.g.b.d(str2, 0L), iVar.bqH(), str, pn2);
                    } else if (this.cuA.afa() == 1) {
                        this.ciX.a(this.cuA.ahJ(), iVar);
                        this.cuA.setPn(pn2);
                        this.cjg.jc(pn2 + 1);
                        this.cuA.loadingDone = false;
                        this.cuA.loadIndex = 0;
                    }
                }
            } else if (!this.cjg.aiB()) {
                this.cjg.XP();
            }
        }
    }

    public int afa() {
        if (this.cjg == null) {
            return -1;
        }
        if (this.cjg.aiI()) {
            return this.cuB.afa();
        }
        return this.cuA.afa();
    }

    public void setHasMore(int i) {
        if (this.cjg != null) {
            if (this.cjg.aiI()) {
                this.cuB.setHasMore(i);
            } else {
                this.cuA.setHasMore(i);
            }
        }
    }

    public int getPn() {
        if (this.cjg == null) {
            return 1;
        }
        if (this.cjg.aiI()) {
            return this.cuB.getPn();
        }
        return this.cuA.getPn();
    }

    public void setPn(int i) {
        if (this.cjg != null) {
            if (this.cjg.aiI()) {
                this.cuB.setPn(i);
            } else {
                this.cuA.setPn(i);
            }
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.cjg.aiI() ? this.cuB.getDataList() : this.cjg.aiD();
    }

    public FrsSmartLoadMoreModel ais() {
        return this.cuB;
    }
}
