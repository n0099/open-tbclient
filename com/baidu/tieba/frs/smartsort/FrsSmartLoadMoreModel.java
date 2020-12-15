package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int hKZ;
    private k iUE;
    private c.a jra;
    private final FrsFragment jrm;
    private int mPn;
    private int mSortType;
    private final ArrayList<q> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.hKZ = -1;
        this.jrm = frsFragment;
        setUniqueId(this.jrm.getUniqueId());
        this.iUE = kVar;
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

    public int cCg() {
        return this.hKZ;
    }

    public void setHasMore(int i) {
        this.hKZ = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<q> a(boolean z, boolean z2, ArrayList<q> arrayList, boolean z3, boolean z4) {
        int i;
        if (!z3 && this.mThreadList.size() == 0) {
            if (FrsFragment.iTb != null) {
                this.mThreadList.addAll(FrsFragment.iTb.getThreadList());
            }
            FrsFragment.iTb = null;
        }
        if (y.isEmpty(arrayList)) {
            if (this.iUE != null) {
                this.iUE.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<q> arrayList2 = new ArrayList<>();
            ArrayList<q> arrayList3 = new ArrayList<>();
            Iterator<q> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                q next = it.next();
                if (!z4 || !(next instanceof x)) {
                    if (!(next instanceof v)) {
                        if (e(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof by) {
                            by byVar = (by) next;
                            byVar.jf(true);
                            ax(byVar);
                            if ((byVar.bqn() == null || byVar.bpn()) && g(byVar.getId(), this.mThreadList)) {
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
            }
            if (z2) {
                aH(arrayList2);
            }
            this.jrm.cCK().addRecommendAppToThreadList(this.jrm, true, arrayList2, this.mThreadList, this.jrm.cCa().cJn());
            if (z2) {
                if (this.iUE != null) {
                    this.iUE.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                cJD();
                u(this.mThreadList, arrayList2);
                dz(arrayList2);
                aG(arrayList3);
                b(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void ax(by byVar) {
        if (byVar != null && this.jrm != null && this.jrm.cCK() != null && this.jrm.cCK().getForum() != null) {
            byVar.Bj(this.jrm.cCK().getForum().getFirst_class());
            byVar.Bk(this.jrm.cCK().getForum().getSecond_class());
        }
    }

    private void dz(List<q> list) {
        if (!y.isEmpty(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(q qVar) {
        if (qVar == null) {
            return false;
        }
        if (qVar instanceof com.baidu.tieba.tbadkCore.x) {
            return true;
        }
        if ((!(qVar instanceof by) || ((by) qVar).boK() != 2) && qVar.getType() != com.baidu.tieba.tbadkCore.q.nkx) {
            return false;
        }
        return true;
    }

    private void b(ArrayList<q> arrayList, int i) {
        int count;
        if (arrayList != null && (count = y.getCount(arrayList)) > i) {
            int max = Math.max(count - i, 30);
            int i2 = ((count - 20) - max) - 1;
            y.removeSubList(arrayList, i2, max + i2);
        }
    }

    public void cJD() {
        if (!y.isEmpty(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<q> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof v) {
                    arrayList.add(next);
                }
            }
            if (!y.isEmpty(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void aG(ArrayList<q> arrayList) {
        if (!y.isEmpty(arrayList) && !y.isEmpty(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void aH(ArrayList<q> arrayList) {
        if (!y.isEmpty(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!y.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null) {
                        if (next.getType() == by.eKU) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof by) && ((by) next).boM() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof g) || (next instanceof h)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!y.isEmpty(arrayList2)) {
                if (!y.isEmpty(this.mThreadList)) {
                    Iterator<q> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        q next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == by.eKU) {
                                it2.remove();
                            } else if ((next2 instanceof by) && ((by) next2).boM() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof g) || (next2 instanceof h)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!y.isEmpty(arrayList2)) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        q qVar = (q) it3.next();
                        if (qVar != null && ((qVar instanceof g) || (qVar instanceof h))) {
                            it3.remove();
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean g(String str, ArrayList<q> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<q> it = arrayList.iterator();
        while (it.hasNext()) {
            q next = it.next();
            if ((next instanceof by) && str.equalsIgnoreCase(((by) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<q> getDataList() {
        return this.mThreadList;
    }

    public void aI(ArrayList<q> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.hKZ = -1;
        this.mPn = 1;
    }

    private void u(List<q> list, List<q> list2) {
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            list2.add(new v());
        }
    }

    public void cIT() {
        ArrayList<q> arrayList;
        int count = y.getCount(this.mThreadList) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    arrayList2.add(this.mThreadList.remove(20));
                    if (this.jrm == null || this.jrm.cCK() == null) {
                        arrayList = null;
                    } else {
                        arrayList = this.jrm.cCK().switchThreadDataToThreadCardInfo(arrayList2);
                    }
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (this.jra != null) {
                                this.jra.removeItem(i3 + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    public void d(q qVar) {
        if (qVar != null && this.mThreadList != null) {
            this.mThreadList.remove(qVar);
        }
    }

    public void a(c.a aVar) {
        this.jra = aVar;
    }
}
