package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int gRi;
    private k hUw;
    private c.a ioa;
    private final FrsFragment iom;
    private int mPn;
    private int mSortType;
    private final ArrayList<q> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.gRi = -1;
        this.iom = frsFragment;
        setUniqueId(this.iom.getUniqueId());
        this.hUw = kVar;
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

    public int clT() {
        return this.gRi;
    }

    public void setHasMore(int i) {
        this.gRi = i;
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
            if (FrsFragment.hST != null) {
                this.mThreadList.addAll(FrsFragment.hST.getThreadList());
            }
            FrsFragment.hST = null;
        }
        if (y.isEmpty(arrayList)) {
            if (this.hUw != null) {
                this.hUw.a(this.mSortType, z2, 0, z, null, z3);
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
                if (!z4 || !(next instanceof com.baidu.tieba.frs.y)) {
                    if (!(next instanceof w)) {
                        if (e(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof bw) {
                            bw bwVar = (bw) next;
                            bwVar.hZ(true);
                            au(bwVar);
                            if ((bwVar.bga() == null || bwVar.bfc()) && g(bwVar.getId(), this.mThreadList)) {
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
            this.iom.cmw().addRecommendAppToThreadList(this.iom, true, arrayList2, this.mThreadList, this.iom.clN().csa());
            if (z2) {
                if (this.hUw != null) {
                    this.hUw.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                csp();
                q(this.mThreadList, arrayList2);
                cQ(arrayList2);
                aA(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void au(bw bwVar) {
        if (bwVar != null && this.iom != null && this.iom.cmw() != null && this.iom.cmw().getForum() != null) {
            bwVar.zs(this.iom.cmw().getForum().getFirst_class());
            bwVar.zt(this.iom.cmw().getForum().getSecond_class());
        }
    }

    private void cQ(List<q> list) {
        if (!y.isEmpty(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(q qVar) {
        if (qVar == null) {
            return false;
        }
        if (qVar instanceof com.baidu.tieba.tbadkCore.w) {
            return true;
        }
        if ((!(qVar instanceof bw) || ((bw) qVar).bez() != 2) && qVar.getType() != p.mdA) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<q> arrayList, int i) {
        int count;
        if (arrayList != null && (count = y.getCount(arrayList)) > i) {
            int max = Math.max(count - i, 30);
            int i2 = ((count - 20) - max) - 1;
            y.removeSubList(arrayList, i2, max + i2);
        }
    }

    public void csp() {
        if (!y.isEmpty(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<q> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof w) {
                    arrayList.add(next);
                }
            }
            if (!y.isEmpty(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void aA(ArrayList<q> arrayList) {
        if (!y.isEmpty(arrayList) && !y.isEmpty(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void aB(ArrayList<q> arrayList) {
        if (!y.isEmpty(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!y.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null) {
                        if (next.getType() == bw.ecR) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bw) && ((bw) next).beB() == 1) {
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
                            if (next2.getType() == bw.ecR) {
                                it2.remove();
                            } else if ((next2 instanceof bw) && ((bw) next2).beB() == 1) {
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
            if ((next instanceof bw) && str.equalsIgnoreCase(((bw) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<q> getDataList() {
        return this.mThreadList;
    }

    public void aC(ArrayList<q> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.gRi = -1;
        this.mPn = 1;
    }

    private void q(List<q> list, List<q> list2) {
        if (!y.isEmpty(list) && !y.isEmpty(list2)) {
            list2.add(new w());
        }
    }

    public void crG() {
        ArrayList<q> arrayList;
        int count = y.getCount(this.mThreadList) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    arrayList2.add(this.mThreadList.remove(20));
                    if (this.iom == null || this.iom.cmw() == null) {
                        arrayList = null;
                    } else {
                        arrayList = this.iom.cmw().switchThreadDataToThreadCardInfo(arrayList2);
                    }
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (this.ioa != null) {
                                this.ioa.removeItem(i3 + 20);
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
        this.ioa = aVar;
    }
}
