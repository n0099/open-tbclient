package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int bGf;
    private final com.baidu.tieba.frs.f cFg;
    private i cyQ;
    private int mPn;
    private int mSortType;
    private final ArrayList<com.baidu.adp.widget.ListView.f> mThreadList;

    public FrsSmartLoadMoreModel(com.baidu.tieba.frs.f fVar, i iVar) {
        super(fVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bGf = -1;
        this.cFg = fVar;
        setUniqueId(this.cFg.getUniqueId());
        this.cyQ = iVar;
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

    public int ajl() {
        return this.bGf;
    }

    public void setHasMore(int i) {
        this.bGf = i;
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
            if (this.cyQ != null) {
                this.cyQ.a(this.mSortType, z2, 0, z, null, z3);
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
                        bhVar.an(true);
                        if ((bhVar.sG() == null || bhVar.rR()) && e(bhVar.getId(), this.mThreadList)) {
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
                O(arrayList2);
            }
            this.cFg.ajB().a(this.cFg, true, arrayList2, this.mThreadList, this.cFg.ajf().aob());
            if (z2) {
                if (this.cyQ != null) {
                    this.cyQ.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                aol();
                j(this.mThreadList, arrayList2);
                aX(arrayList2);
                N(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void aX(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.v(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean f(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar instanceof q) {
            return true;
        }
        return (fVar instanceof bh) && ((bh) fVar).ro() == 2;
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

    public void aol() {
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

    public void N(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!v.v(arrayList) && !v.v(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void O(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!v.v(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.v(arrayList)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null) {
                        if (next.getType() == bh.ZB) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bh) && ((bh) next).rq() == 1) {
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
                            if (next2.getType() == bh.ZB) {
                                it2.remove();
                            } else if ((next2 instanceof bh) && ((bh) next2).rq() == 1) {
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
        this.bGf = -1;
        this.mPn = 1;
    }

    private void j(List<com.baidu.adp.widget.ListView.f> list, List<com.baidu.adp.widget.ListView.f> list2) {
        if (!v.v(list) && !v.v(list2)) {
            long lr = a.aoh().lr(this.cFg.getForumName());
            p pVar = new p();
            if (lr > 0) {
                pVar.bf(lr);
            } else {
                pVar.bf(System.currentTimeMillis());
            }
            list2.add(pVar);
            a.aoh().k(this.cFg.getForumName(), System.currentTimeMillis());
        }
    }
}
