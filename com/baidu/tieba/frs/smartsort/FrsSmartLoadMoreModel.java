package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int cHk;
    private i dFz;
    private final com.baidu.tieba.frs.i dSV;
    private int mPn;
    private int mSortType;
    private final ArrayList<com.baidu.adp.widget.ListView.i> mThreadList;

    public FrsSmartLoadMoreModel(com.baidu.tieba.frs.i iVar, i iVar2) {
        super(iVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.cHk = -1;
        this.dSV = iVar;
        setUniqueId(this.dSV.getUniqueId());
        this.dFz = iVar2;
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

    public int auU() {
        return this.cHk;
    }

    public void setHasMore(int i) {
        this.cHk = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z3) {
        int i;
        if (v.E(arrayList)) {
            if (this.dFz != null) {
                this.dFz.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
            ArrayList<com.baidu.adp.widget.ListView.i> arrayList3 = new ArrayList<>();
            Iterator<com.baidu.adp.widget.ListView.i> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof r)) {
                    if (e(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bd) {
                        bd bdVar = (bd) next;
                        bdVar.aY(true);
                        if ((bdVar.Av() == null || bdVar.zL()) && e(bdVar.getId(), this.mThreadList)) {
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
            this.dSV.avl().a(this.dSV, true, arrayList2, this.mThreadList, this.dSV.auO().azA());
            if (z2) {
                if (this.dFz != null) {
                    this.dFz.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                azK();
                j(this.mThreadList, arrayList2);
                bw(arrayList2);
                O(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void bw(List<com.baidu.adp.widget.ListView.i> list) {
        if (!v.E(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(com.baidu.adp.widget.ListView.i iVar) {
        if (iVar == null) {
            return false;
        }
        if (iVar instanceof s) {
            return true;
        }
        if ((!(iVar instanceof bd) || ((bd) iVar).zi() != 2) && iVar.getType() != k.gZC) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.i> arrayList, boolean z, int i) {
        int D;
        int i2;
        if (arrayList != null && (D = v.D(arrayList)) > i) {
            int max = Math.max(D - i, 30);
            if (z) {
                i2 = ((D - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            v.c(arrayList, i2, max + i2);
        }
    }

    public void azK() {
        if (!v.E(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.baidu.adp.widget.ListView.i> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof r) {
                    arrayList.add(next);
                }
            }
            if (!v.E(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void O(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (!v.E(arrayList) && !v.E(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void P(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (!v.E(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.E(arrayList)) {
                Iterator<com.baidu.adp.widget.ListView.i> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.i next = it.next();
                    if (next != null) {
                        if (next.getType() == bd.aPI) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bd) && ((bd) next).zk() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof com.baidu.tieba.tbadkCore.e) || (next instanceof com.baidu.tieba.tbadkCore.f)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.E(arrayList2)) {
                if (!v.E(this.mThreadList)) {
                    Iterator<com.baidu.adp.widget.ListView.i> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        com.baidu.adp.widget.ListView.i next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bd.aPI) {
                                it2.remove();
                            } else if ((next2 instanceof bd) && ((bd) next2).zk() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof com.baidu.tieba.tbadkCore.e) || (next2 instanceof com.baidu.tieba.tbadkCore.f)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!v.E(arrayList2)) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) it3.next();
                        if (iVar != null && ((iVar instanceof com.baidu.tieba.tbadkCore.e) || (iVar instanceof com.baidu.tieba.tbadkCore.f))) {
                            it3.remove();
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean e(String str, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.i next = it.next();
            if ((next instanceof bd) && str.equalsIgnoreCase(((bd) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> getDataList() {
        return this.mThreadList;
    }

    public void resetData() {
        this.mThreadList.clear();
        this.cHk = -1;
        this.mPn = 1;
    }

    private void j(List<com.baidu.adp.widget.ListView.i> list, List<com.baidu.adp.widget.ListView.i> list2) {
        if (!v.E(list) && !v.E(list2)) {
            long mk = a.azG().mk(this.dSV.getForumName());
            r rVar = new r();
            if (mk > 0) {
                rVar.bE(mk);
            } else {
                rVar.bE(System.currentTimeMillis());
            }
            list2.add(rVar);
            a.azG().l(this.dSV.getForumName(), System.currentTimeMillis());
        }
    }
}
