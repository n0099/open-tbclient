package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.mc.v;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<FrsActivity> {
    private v bNI;
    private final FrsActivity bOq;
    private int bjb;
    private int mPn;
    private int mSortType;
    private final ArrayList<com.baidu.adp.widget.ListView.v> mThreadList;

    public FrsSmartLoadMoreModel(FrsActivity frsActivity, v vVar) {
        super(frsActivity.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bjb = -1;
        this.bOq = frsActivity;
        this.bNI = vVar;
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

    public int YF() {
        return this.bjb;
    }

    public void setHasMore(int i) {
        this.bjb = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (x.q(arrayList)) {
            if (this.bNI != null) {
                this.bNI.a(this.mSortType, z2, 0, z, null);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
            ArrayList<com.baidu.adp.widget.ListView.v> arrayList3 = new ArrayList<>();
            Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (!(next instanceof bj)) {
                    if (d(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof com.baidu.tbadk.core.data.bj) {
                        com.baidu.tbadk.core.data.bj bjVar = (com.baidu.tbadk.core.data.bj) next;
                        bjVar.as(true);
                        if ((bjVar.sX() != null && !bjVar.sn()) || !e(bjVar.getId(), this.mThreadList)) {
                            arrayList2.add(next);
                            i++;
                        }
                    } else {
                        arrayList2.add(next);
                        i++;
                    }
                }
            }
            if (z2) {
                K(arrayList2);
            }
            this.bOq.YV().a(this.bOq, true, arrayList2, this.mThreadList, this.bOq.Yx().adb());
            if (z2) {
                if (this.bNI != null) {
                    this.bNI.a(this.mSortType, z2, i, z, arrayList2);
                }
                adn();
                f(this.mThreadList, arrayList2);
                av(arrayList2);
                J(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void av(List<com.baidu.adp.widget.ListView.v> list) {
        if (!x.q(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean d(com.baidu.adp.widget.ListView.v vVar) {
        if (vVar == null) {
            return false;
        }
        if (vVar instanceof w) {
            return true;
        }
        return (vVar instanceof com.baidu.tbadk.core.data.bj) && ((com.baidu.tbadk.core.data.bj) vVar).rM() == 2;
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.v> arrayList, boolean z, int i) {
        int p;
        int i2;
        if (arrayList != null && (p = x.p(arrayList)) > i) {
            int max = Math.max(p - i, 30);
            if (z) {
                i2 = ((p - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            x.b(arrayList, i2, max + i2);
        }
    }

    public void adn() {
        if (!x.q(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.baidu.adp.widget.ListView.v> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (d(next)) {
                    arrayList.add(next);
                } else if (next instanceof bj) {
                    arrayList.add(next);
                }
            }
            if (!x.q(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void J(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (!x.q(arrayList) && !x.q(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void K(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (!x.q(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!x.q(arrayList)) {
                Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next != null) {
                        if (next.getType() == com.baidu.tbadk.core.data.bj.YT) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof com.baidu.tbadk.core.data.bj) && ((com.baidu.tbadk.core.data.bj) next).rO() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!x.q(arrayList2)) {
                if (!x.q(this.mThreadList)) {
                    Iterator<com.baidu.adp.widget.ListView.v> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        com.baidu.adp.widget.ListView.v next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == com.baidu.tbadk.core.data.bj.YT) {
                                it2.remove();
                            } else if ((next2 instanceof com.baidu.tbadk.core.data.bj) && ((com.baidu.tbadk.core.data.bj) next2).rO() == 1) {
                                it2.remove();
                            }
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean e(String str, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if ((next instanceof com.baidu.tbadk.core.data.bj) && str.equalsIgnoreCase(((com.baidu.tbadk.core.data.bj) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> getDataList() {
        return this.mThreadList;
    }

    public void resetData() {
        this.mThreadList.clear();
        this.bjb = -1;
        this.mPn = 1;
    }

    private void f(List<com.baidu.adp.widget.ListView.v> list, List<com.baidu.adp.widget.ListView.v> list2) {
        if (!x.q(list) && !x.q(list2)) {
            long iL = a.adj().iL(this.bOq.getForumName());
            bj bjVar = new bj();
            if (iL > 0) {
                bjVar.aP(iL);
            } else {
                bjVar.aP(System.currentTimeMillis());
            }
            list2.add(bjVar);
            a.adj().i(this.bOq.getForumName(), System.currentTimeMillis());
        }
    }
}
