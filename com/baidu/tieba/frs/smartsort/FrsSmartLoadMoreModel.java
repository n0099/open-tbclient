package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int gzh;
    private k hBl;
    private c.a hTR;
    private final FrsFragment hUd;
    private int mPn;
    private int mSortType;
    private final ArrayList<q> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.gzh = -1;
        this.hUd = frsFragment;
        setUniqueId(this.hUd.getUniqueId());
        this.hBl = kVar;
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

    public int bYa() {
        return this.gzh;
    }

    public void setHasMore(int i) {
        this.gzh = i;
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
            if (FrsFragment.hzO != null) {
                this.mThreadList.addAll(FrsFragment.hzO.getThreadList());
            }
            FrsFragment.hzO = null;
        }
        if (w.isEmpty(arrayList)) {
            if (this.hBl != null) {
                this.hBl.a(this.mSortType, z2, 0, z, null, z3);
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
                        } else if (next instanceof bu) {
                            bu buVar = (bu) next;
                            buVar.gZ(true);
                            ax(buVar);
                            if ((buVar.aTL() == null || buVar.aSN()) && g(buVar.getId(), this.mThreadList)) {
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
                au(arrayList2);
            }
            this.hUd.bYB().addRecommendAppToThreadList(this.hUd, true, arrayList2, this.mThreadList, this.hUd.bXU().cdV());
            if (z2) {
                if (this.hBl != null) {
                    this.hBl.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                cel();
                n(this.mThreadList, arrayList2);
                cJ(arrayList2);
                at(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void ax(bu buVar) {
        if (buVar != null && this.hUd != null && this.hUd.bYB() != null && this.hUd.bYB().getForum() != null) {
            buVar.vX(this.hUd.bYB().getForum().getFirst_class());
            buVar.vY(this.hUd.bYB().getForum().getSecond_class());
        }
    }

    private void cJ(List<q> list) {
        if (!w.isEmpty(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(q qVar) {
        if (qVar == null) {
            return false;
        }
        if (qVar instanceof com.baidu.tieba.tbadkCore.v) {
            return true;
        }
        if ((!(qVar instanceof bu) || ((bu) qVar).aSk() != 2) && qVar.getType() != o.lEz) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<q> arrayList, int i) {
        int count;
        if (arrayList != null && (count = w.getCount(arrayList)) > i) {
            int max = Math.max(count - i, 30);
            int i2 = ((count - 20) - max) - 1;
            w.removeSubList(arrayList, i2, max + i2);
        }
    }

    public void cel() {
        if (!w.isEmpty(this.mThreadList)) {
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
            if (!w.isEmpty(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void at(ArrayList<q> arrayList) {
        if (!w.isEmpty(arrayList) && !w.isEmpty(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void au(ArrayList<q> arrayList) {
        if (!w.isEmpty(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!w.isEmpty(arrayList)) {
                Iterator<q> it = arrayList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null) {
                        if (next.getType() == bu.dNk) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bu) && ((bu) next).aSm() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof g) || (next instanceof h)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!w.isEmpty(arrayList2)) {
                if (!w.isEmpty(this.mThreadList)) {
                    Iterator<q> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        q next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bu.dNk) {
                                it2.remove();
                            } else if ((next2 instanceof bu) && ((bu) next2).aSm() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof g) || (next2 instanceof h)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!w.isEmpty(arrayList2)) {
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
            if ((next instanceof bu) && str.equalsIgnoreCase(((bu) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<q> getDataList() {
        return this.mThreadList;
    }

    public void av(ArrayList<q> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.gzh = -1;
        this.mPn = 1;
    }

    private void n(List<q> list, List<q> list2) {
        if (!w.isEmpty(list) && !w.isEmpty(list2)) {
            list2.add(new v());
        }
    }

    public void cdB() {
        ArrayList<q> arrayList;
        int count = w.getCount(this.mThreadList) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    arrayList2.add(this.mThreadList.remove(20));
                    if (this.hUd == null || this.hUd.bYB() == null) {
                        arrayList = null;
                    } else {
                        arrayList = this.hUd.bYB().switchThreadDataToThreadCardInfo(arrayList2);
                    }
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (this.hTR != null) {
                                this.hTR.removeItem(i3 + 20);
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
        this.hTR = aVar;
    }
}
