package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private com.baidu.tieba.funad.a funAdController;
    private int hSE;
    private k jcj;
    private c.a jyQ;
    private final FrsFragment jzc;
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
        this.hSE = -1;
        this.jzc = frsFragment;
        setUniqueId(this.jzc.getUniqueId());
        this.jcj = kVar;
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

    public int cBj() {
        return this.hSE;
    }

    public void setHasMore(int i) {
        this.hSE = i;
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
            if (FrsFragment.jaF != null) {
                this.mThreadList.addAll(FrsFragment.jaF.getThreadList());
            }
            FrsFragment.jaF = null;
        }
        if (x.isEmpty(arrayList)) {
            if (this.jcj != null) {
                this.jcj.a(this.mSortType, z2, 0, z, null, z3);
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
                        } else if (next instanceof bz) {
                            bz bzVar = (bz) next;
                            bzVar.jx(true);
                            ax(bzVar);
                            if ((bzVar.boW() == null || bzVar.bnU()) && g(bzVar.getId(), this.mThreadList)) {
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
                aC(arrayList2);
            }
            if (com.baidu.tieba.funad.a.cLz()) {
                if (this.funAdController != null) {
                    this.funAdController.q(arrayList2, z2);
                }
            } else {
                this.jzc.cBN().addRecommendAppToThreadList(this.jzc, true, arrayList2, this.mThreadList, this.jzc.cBd().cIw());
            }
            if (z2) {
                if (this.jcj != null) {
                    this.jcj.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                cIM();
                x(this.mThreadList, arrayList2);
                dH(arrayList2);
                aB(arrayList3);
                b(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void ax(bz bzVar) {
        if (bzVar != null && this.jzc != null && this.jzc.cBN() != null && this.jzc.cBN().getForum() != null) {
            bzVar.zW(this.jzc.cBN().getForum().getFirst_class());
            bzVar.zX(this.jzc.cBN().getForum().getSecond_class());
        }
    }

    private void dH(List<n> list) {
        if (!x.isEmpty(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(n nVar) {
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof com.baidu.tieba.tbadkCore.x) {
            return true;
        }
        if ((!(nVar instanceof bz) || ((bz) nVar).bns() != 2) && nVar.getType() != q.nlx) {
            return false;
        }
        return true;
    }

    private void b(ArrayList<n> arrayList, int i) {
        int count;
        if (arrayList != null && (count = x.getCount(arrayList)) > i) {
            int max = Math.max(count - i, 30);
            int i2 = ((count - 20) - max) - 1;
            x.removeSubList(arrayList, i2, max + i2);
        }
    }

    public void cIM() {
        if (!x.isEmpty(this.mThreadList)) {
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
            if (!x.isEmpty(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void aB(ArrayList<n> arrayList) {
        if (!x.isEmpty(arrayList) && !x.isEmpty(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void aC(ArrayList<n> arrayList) {
        if (!x.isEmpty(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!x.isEmpty(arrayList)) {
                Iterator<n> it = arrayList.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null) {
                        if (next.getType() == bz.eQd) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bz) && ((bz) next).bnu() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof g) || (next instanceof h)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!x.isEmpty(arrayList2)) {
                if (!x.isEmpty(this.mThreadList)) {
                    Iterator<n> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        n next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bz.eQd) {
                                it2.remove();
                            } else if ((next2 instanceof bz) && ((bz) next2).bnu() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof g) || (next2 instanceof h)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!x.isEmpty(arrayList2)) {
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
            if ((next instanceof bz) && str.equalsIgnoreCase(((bz) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<n> getDataList() {
        return this.mThreadList;
    }

    public void aD(ArrayList<n> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.hSE = -1;
        this.mPn = 1;
    }

    private void x(List<n> list, List<n> list2) {
        if (!x.isEmpty(list) && !x.isEmpty(list2)) {
            list2.add(new u());
        }
    }

    public void cIc() {
        ArrayList<n> arrayList;
        int count = x.getCount(this.mThreadList) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<n> arrayList2 = new ArrayList<>();
                    arrayList2.add(this.mThreadList.remove(20));
                    if (this.jzc == null || this.jzc.cBN() == null) {
                        arrayList = null;
                    } else {
                        arrayList = this.jzc.cBN().switchThreadDataToThreadCardInfo(arrayList2);
                    }
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (this.jyQ != null) {
                                this.jyQ.removeItem(i3 + 20);
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
        this.jyQ = aVar;
    }
}
