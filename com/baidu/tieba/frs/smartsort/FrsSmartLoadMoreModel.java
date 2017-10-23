package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int bzE;
    private i crb;
    private final com.baidu.tieba.frs.f cwW;
    private int mPn;
    private int mSortType;
    private final ArrayList<com.baidu.adp.widget.ListView.f> mThreadList;

    public FrsSmartLoadMoreModel(com.baidu.tieba.frs.f fVar, i iVar) {
        super(fVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bzE = -1;
        this.cwW = fVar;
        setUniqueId(this.cwW.getUniqueId());
        this.crb = iVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public int agQ() {
        return this.bzE;
    }

    public void setHasMore(int i) {
        this.bzE = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z3) {
        int i;
        if (v.u(arrayList)) {
            if (this.crb != null) {
                this.crb.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
            ArrayList<com.baidu.adp.widget.ListView.f> arrayList3 = new ArrayList<>();
            Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof p)) {
                    if (f(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bh) {
                        bh bhVar = (bh) next;
                        bhVar.ap(true);
                        if ((bhVar.sz() == null || bhVar.rL()) && e(bhVar.getId(), this.mThreadList)) {
                            i = i2;
                        } else {
                            arrayList2.add(next);
                            i = i2 + 1;
                        }
                        i2 = i;
                    } else {
                        arrayList2.add(next);
                        i2++;
                    }
                }
            }
            if (z2) {
                N(arrayList2);
            }
            this.cwW.ahf().a(this.cwW, true, arrayList2, this.mThreadList, this.cwW.agK().alb());
            if (z2) {
                if (this.crb != null) {
                    this.crb.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                all();
                i(this.mThreadList, arrayList2);
                aU(arrayList2);
                M(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void aU(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.u(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean f(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar instanceof com.baidu.tieba.tbadkCore.p) {
            return true;
        }
        return (fVar instanceof bh) && ((bh) fVar).rj() == 2;
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z, int i) {
        int t;
        int i2;
        if (arrayList != null && (t = v.t(arrayList)) > i) {
            int max = Math.max(t - i, 30);
            if (z) {
                i2 = ((t - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            v.b(arrayList, i2, max + i2);
        }
    }

    public void all() {
        if (!v.u(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.baidu.adp.widget.ListView.f> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (f(next)) {
                    arrayList.add(next);
                } else if (next instanceof p) {
                    arrayList.add(next);
                }
            }
            if (!v.u(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void M(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!v.u(arrayList) && !v.u(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void N(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!v.u(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.u(arrayList)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null) {
                        if (next.getType() == bh.Zg) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bh) && ((bh) next).rl() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.u(arrayList2)) {
                if (!v.u(this.mThreadList)) {
                    Iterator<com.baidu.adp.widget.ListView.f> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        com.baidu.adp.widget.ListView.f next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bh.Zg) {
                                it2.remove();
                            } else if ((next2 instanceof bh) && ((bh) next2).rl() == 1) {
                                it2.remove();
                            }
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean e(String str, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bh) && str.equalsIgnoreCase(((bh) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.mThreadList;
    }

    public void resetData() {
        this.mThreadList.clear();
        this.bzE = -1;
        this.mPn = 1;
    }

    private void i(List<com.baidu.adp.widget.ListView.f> list, List<com.baidu.adp.widget.ListView.f> list2) {
        if (!v.u(list) && !v.u(list2)) {
            long kO = a.alh().kO(this.cwW.getForumName());
            p pVar = new p();
            if (kO > 0) {
                pVar.bf(kO);
            } else {
                pVar.bf(System.currentTimeMillis());
            }
            list2.add(pVar);
            a.alh().j(this.cwW.getForumName(), System.currentTimeMillis());
        }
    }
}
