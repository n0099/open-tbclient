package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.mc.j;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int bxs;
    private j cpY;
    private final com.baidu.tieba.frs.f cvA;
    private int mPn;
    private int mSortType;
    private final ArrayList<com.baidu.adp.widget.ListView.f> mThreadList;

    public FrsSmartLoadMoreModel(com.baidu.tieba.frs.f fVar, j jVar) {
        super(fVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bxs = -1;
        this.cvA = fVar;
        setUniqueId(this.cvA.getUniqueId());
        this.cpY = jVar;
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

    public int agO() {
        return this.bxs;
    }

    public void setHasMore(int i) {
        this.bxs = i;
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
        if (v.v(arrayList)) {
            if (this.cpY != null) {
                this.cpY.a(this.mSortType, z2, 0, z, null, z3);
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
                    } else if (next instanceof bj) {
                        bj bjVar = (bj) next;
                        bjVar.aq(true);
                        if ((bjVar.sM() == null || bjVar.rY()) && e(bjVar.getId(), this.mThreadList)) {
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
            this.cvA.ahf().a(this.cvA, true, arrayList2, this.mThreadList, this.cvA.agI().akR());
            if (z2) {
                if (this.cpY != null) {
                    this.cpY.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                alb();
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
        if (!v.v(list)) {
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
        return (fVar instanceof bj) && ((bj) fVar).rw() == 2;
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z, int i) {
        int u;
        int i2;
        if (arrayList != null && (u = v.u(arrayList)) > i) {
            int max = Math.max(u - i, 30);
            if (z) {
                i2 = ((u - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            v.b(arrayList, i2, max + i2);
        }
    }

    public void alb() {
        if (!v.v(this.mThreadList)) {
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
            if (!v.v(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void M(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!v.v(arrayList) && !v.v(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void N(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!v.v(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.v(arrayList)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null) {
                        if (next.getType() == bj.Zs) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bj) && ((bj) next).ry() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.v(arrayList2)) {
                if (!v.v(this.mThreadList)) {
                    Iterator<com.baidu.adp.widget.ListView.f> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        com.baidu.adp.widget.ListView.f next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bj.Zs) {
                                it2.remove();
                            } else if ((next2 instanceof bj) && ((bj) next2).ry() == 1) {
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
            if ((next instanceof bj) && str.equalsIgnoreCase(((bj) next).getTid())) {
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
        this.bxs = -1;
        this.mPn = 1;
    }

    private void i(List<com.baidu.adp.widget.ListView.f> list, List<com.baidu.adp.widget.ListView.f> list2) {
        if (!v.v(list) && !v.v(list2)) {
            long kQ = a.akX().kQ(this.cvA.getForumName());
            p pVar = new p();
            if (kQ > 0) {
                pVar.bh(kQ);
            } else {
                pVar.bh(System.currentTimeMillis());
            }
            list2.add(pVar);
            a.akX().j(this.cvA.getForumName(), System.currentTimeMillis());
        }
    }
}
