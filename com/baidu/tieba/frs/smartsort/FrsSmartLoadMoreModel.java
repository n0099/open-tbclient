package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private com.baidu.tieba.funad.a funAdController;
    private int hXn;
    private c.a jEJ;
    private final FrsFragment jEV;
    private k jie;
    private int mPn;
    private int mSortType;
    private final ArrayList<n> mThreadList;

    public void setFunAdController(com.baidu.tieba.funad.a aVar) {
        this.funAdController = aVar;
    }

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.hXn = -1;
        this.jEV = frsFragment;
        setUniqueId(this.jEV.getUniqueId());
        this.jie = kVar;
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

    public int cCC() {
        return this.hXn;
    }

    public void setHasMore(int i) {
        this.hXn = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<n> a(boolean z, boolean z2, ArrayList<n> arrayList, boolean z3, boolean z4) {
        int i;
        if (!z3 && this.mThreadList.size() == 0) {
            if (FrsFragment.jgz != null) {
                this.mThreadList.addAll(FrsFragment.jgz.getThreadList());
            }
            FrsFragment.jgz = null;
        }
        if (y.isEmpty(arrayList)) {
            if (this.jie != null) {
                this.jie.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            ArrayList<n> arrayList3 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (!z4 || !(next instanceof w)) {
                    if (!(next instanceof u)) {
                        if (e(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof cb) {
                            cb cbVar = (cb) next;
                            cbVar.jz(true);
                            ay(cbVar);
                            if ((cbVar.bpo() == null || cbVar.bon()) && g(cbVar.getId(), this.mThreadList)) {
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
                aB(arrayList2);
            }
            if (com.baidu.tieba.funad.a.cNu()) {
                if (this.funAdController != null) {
                    this.funAdController.r(arrayList2, z2);
                }
            } else {
                this.jEV.cDg().addRecommendAppToThreadList(this.jEV, true, arrayList2, this.mThreadList, this.jEV.cCw().cJQ());
            }
            if (z2) {
                if (this.jie != null) {
                    this.jie.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                cKg();
                w(this.mThreadList, arrayList2);
                dC(arrayList2);
                aA(arrayList3);
                b(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void ay(cb cbVar) {
        if (cbVar != null && this.jEV != null && this.jEV.cDg() != null && this.jEV.cDg().getForum() != null) {
            cbVar.An(this.jEV.cDg().getForum().getFirst_class());
            cbVar.Ao(this.jEV.cDg().getForum().getSecond_class());
        }
    }

    private void dC(List<n> list) {
        if (!y.isEmpty(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(n nVar) {
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof x) {
            return true;
        }
        if ((!(nVar instanceof cb) || ((cb) nVar).bnL() != 2) && nVar.getType() != q.nvG) {
            return false;
        }
        return true;
    }

    private void b(ArrayList<n> arrayList, int i) {
        int count;
        if (arrayList != null && (count = y.getCount(arrayList)) > i) {
            int max = Math.max(count - i, 30);
            int i2 = ((count - 20) - max) - 1;
            y.removeSubList(arrayList, i2, max + i2);
        }
    }

    public void cKg() {
        if (!y.isEmpty(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<n> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof u) {
                    arrayList.add(next);
                }
            }
            if (!y.isEmpty(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void aA(ArrayList<n> arrayList) {
        if (!y.isEmpty(arrayList) && !y.isEmpty(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void aB(ArrayList<n> arrayList) {
        if (!y.isEmpty(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!y.isEmpty(arrayList)) {
                Iterator<n> it = arrayList.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null) {
                        if (next.getType() == cb.eSp) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof cb) && ((cb) next).bnN() == 1) {
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
                    Iterator<n> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        n next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == cb.eSp) {
                                it2.remove();
                            } else if ((next2 instanceof cb) && ((cb) next2).bnN() == 1) {
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
                        n nVar = (n) it3.next();
                        if (nVar != null && ((nVar instanceof g) || (nVar instanceof h))) {
                            it3.remove();
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean g(String str, ArrayList<n> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof cb) && str.equalsIgnoreCase(((cb) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<n> getDataList() {
        return this.mThreadList;
    }

    public void aC(ArrayList<n> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.hXn = -1;
        this.mPn = 1;
    }

    private void w(List<n> list, List<n> list2) {
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            list2.add(new u());
        }
    }

    public void cJw() {
        ArrayList<n> arrayList;
        int count = y.getCount(this.mThreadList) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<n> arrayList2 = new ArrayList<>();
                    arrayList2.add(this.mThreadList.remove(20));
                    if (this.jEV == null || this.jEV.cDg() == null) {
                        arrayList = null;
                    } else {
                        arrayList = this.jEV.cDg().switchThreadDataToThreadCardInfo(arrayList2);
                    }
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (this.jEJ != null) {
                                this.jEJ.removeItem(i3 + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    public void d(n nVar) {
        if (nVar != null && this.mThreadList != null) {
            this.mThreadList.remove(nVar);
        }
    }

    public void a(c.a aVar) {
        this.jEJ = aVar;
    }
}
