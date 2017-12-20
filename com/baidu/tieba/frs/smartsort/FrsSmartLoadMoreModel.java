package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int bOj;
    private i cIe;
    private final g cOx;
    private int mPn;
    private int mSortType;
    private final ArrayList<com.baidu.adp.widget.ListView.f> mThreadList;

    public FrsSmartLoadMoreModel(g gVar, i iVar) {
        super(gVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bOj = -1;
        this.cOx = gVar;
        setUniqueId(this.cOx.getUniqueId());
        this.cIe = iVar;
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

    public int alo() {
        return this.bOj;
    }

    public void setHasMore(int i) {
        this.bOj = i;
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
        if (v.w(arrayList)) {
            if (this.cIe != null) {
                this.cIe.a(this.mSortType, z2, 0, z, null, z3);
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
                if (!(next instanceof q)) {
                    if (f(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bd) {
                        bd bdVar = (bd) next;
                        bdVar.an(true);
                        if ((bdVar.sH() == null || bdVar.rT()) && e(bdVar.getId(), this.mThreadList)) {
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
                P(arrayList2);
            }
            this.cOx.alE().a(this.cOx, true, arrayList2, this.mThreadList, this.cOx.ali().aqd());
            if (z2) {
                if (this.cIe != null) {
                    this.cIe.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                aqn();
                k(this.mThreadList, arrayList2);
                bj(arrayList2);
                O(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void bj(List<com.baidu.adp.widget.ListView.f> list) {
        if (!v.w(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean f(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar instanceof r) {
            return true;
        }
        if ((!(fVar instanceof bd) || ((bd) fVar).rq() != 2) && fVar.getType() != j.gAx) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z, int i) {
        int v;
        int i2;
        if (arrayList != null && (v = v.v(arrayList)) > i) {
            int max = Math.max(v - i, 30);
            if (z) {
                i2 = ((v - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            v.b(arrayList, i2, max + i2);
        }
    }

    public void aqn() {
        if (!v.w(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.baidu.adp.widget.ListView.f> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (f(next)) {
                    arrayList.add(next);
                } else if (next instanceof q) {
                    arrayList.add(next);
                }
            }
            if (!v.w(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void O(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!v.w(arrayList) && !v.w(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void P(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!v.w(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.w(arrayList)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null) {
                        if (next.getType() == bd.ZO) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bd) && ((bd) next).rs() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if (next instanceof com.baidu.tieba.tbadkCore.e) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.w(arrayList2)) {
                if (!v.w(this.mThreadList)) {
                    Iterator<com.baidu.adp.widget.ListView.f> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        com.baidu.adp.widget.ListView.f next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bd.ZO) {
                                it2.remove();
                            } else if ((next2 instanceof bd) && ((bd) next2).rs() == 1) {
                                it2.remove();
                            } else if (next2 instanceof com.baidu.tieba.tbadkCore.e) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!v.w(arrayList2)) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) it3.next();
                        if (fVar != null && (fVar instanceof com.baidu.tieba.tbadkCore.e)) {
                            it3.remove();
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
            if ((next instanceof bd) && str.equalsIgnoreCase(((bd) next).getTid())) {
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
        this.bOj = -1;
        this.mPn = 1;
    }

    private void k(List<com.baidu.adp.widget.ListView.f> list, List<com.baidu.adp.widget.ListView.f> list2) {
        if (!v.w(list) && !v.w(list2)) {
            long lz = a.aqj().lz(this.cOx.getForumName());
            q qVar = new q();
            if (lz > 0) {
                qVar.bn(lz);
            } else {
                qVar.bn(System.currentTimeMillis());
            }
            list2.add(qVar);
            a.aqj().m(this.cOx.getForumName(), System.currentTimeMillis());
        }
    }
}
