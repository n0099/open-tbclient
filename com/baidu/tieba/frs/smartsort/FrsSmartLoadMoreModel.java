package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int gmi;
    private c.a hFR;
    private final FrsFragment hGd;
    private k hoA;
    private int mPn;
    private int mSortType;
    private final ArrayList<o> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.gmi = -1;
        this.hGd = frsFragment;
        setUniqueId(this.hGd.getUniqueId());
        this.hoA = kVar;
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

    public int bUS() {
        return this.gmi;
    }

    public void setHasMore(int i) {
        this.gmi = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<o> a(boolean z, boolean z2, ArrayList<o> arrayList, boolean z3, boolean z4) {
        int i;
        if (!z3 && this.mThreadList.size() == 0) {
            if (FrsFragment.hnl != null) {
                this.mThreadList.addAll(FrsFragment.hnl.getThreadList());
            }
            FrsFragment.hnl = null;
        }
        if (v.isEmpty(arrayList)) {
            if (this.hoA != null) {
                this.hoA.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            if (z2) {
                caL();
            }
            ArrayList<o> arrayList2 = new ArrayList<>();
            ArrayList<o> arrayList3 = new ArrayList<>();
            Iterator<o> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                o next = it.next();
                if (!z4 || !(next instanceof u)) {
                    if (!(next instanceof t)) {
                        if (e(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof bk) {
                            bk bkVar = (bk) next;
                            bkVar.gR(true);
                            ax(bkVar);
                            if ((bkVar.aRU() == null || bkVar.aQW()) && g(bkVar.getId(), this.mThreadList)) {
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
            this.hGd.bVs().addRecommendAppToThreadList(this.hGd, true, arrayList2, this.mThreadList, this.hGd.bUM().caz());
            if (z2) {
                if (this.hoA != null) {
                    this.hoA.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                caK();
                m(this.mThreadList, arrayList2);
                cy(arrayList2);
                at(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void ax(bk bkVar) {
        if (bkVar != null && this.hGd != null && this.hGd.bVs() != null && this.hGd.bVs().getForum() != null) {
            bkVar.vH(this.hGd.bVs().getForum().getFirst_class());
            bkVar.vI(this.hGd.bVs().getForum().getSecond_class());
        }
    }

    private void cy(List<o> list) {
        if (!v.isEmpty(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (oVar instanceof com.baidu.tieba.tbadkCore.v) {
            return true;
        }
        if ((!(oVar instanceof bk) || ((bk) oVar).aQs() != 2) && oVar.getType() != com.baidu.tieba.tbadkCore.o.ljw) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<o> arrayList, int i) {
        int count;
        if (arrayList != null && (count = v.getCount(arrayList)) > i) {
            int max = Math.max(count - i, 30);
            int i2 = ((count - 20) - max) - 1;
            v.removeSubList(arrayList, i2, max + i2);
        }
    }

    public void caK() {
        if (!v.isEmpty(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<o> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof t) {
                    arrayList.add(next);
                }
            }
            if (!v.isEmpty(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void caL() {
        int i;
        if (!v.isEmpty(this.mThreadList)) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= (this.mThreadList.size() > 30 ? 30 : this.mThreadList.size())) {
                    i = -1;
                    break;
                }
                o oVar = this.mThreadList.get(i);
                if ((oVar instanceof bk) && ((bk) oVar).aQB()) {
                    break;
                }
                i2 = i + 1;
            }
            if (i >= 0) {
                this.mThreadList.remove(i);
            }
        }
    }

    public void at(ArrayList<o> arrayList) {
        if (!v.isEmpty(arrayList) && !v.isEmpty(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void au(ArrayList<o> arrayList) {
        if (!v.isEmpty(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.isEmpty(arrayList)) {
                Iterator<o> it = arrayList.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if (next != null) {
                        if (next.getType() == bk.dGz) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bk) && ((bk) next).aQu() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof g) || (next instanceof h)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.isEmpty(arrayList2)) {
                if (!v.isEmpty(this.mThreadList)) {
                    Iterator<o> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        o next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bk.dGz) {
                                it2.remove();
                            } else if ((next2 instanceof bk) && ((bk) next2).aQu() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof g) || (next2 instanceof h)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!v.isEmpty(arrayList2)) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        o oVar = (o) it3.next();
                        if (oVar != null && ((oVar instanceof g) || (oVar instanceof h))) {
                            it3.remove();
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean g(String str, ArrayList<o> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<o> it = arrayList.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if ((next instanceof bk) && str.equalsIgnoreCase(((bk) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<o> getDataList() {
        return this.mThreadList;
    }

    public void av(ArrayList<o> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.gmi = -1;
        this.mPn = 1;
    }

    private void m(List<o> list, List<o> list2) {
        if (!v.isEmpty(list) && !v.isEmpty(list2)) {
            list2.add(new t());
        }
    }

    public void caf() {
        ArrayList<o> arrayList;
        int count = v.getCount(this.mThreadList) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<o> arrayList2 = new ArrayList<>();
                    arrayList2.add(this.mThreadList.remove(20));
                    if (this.hGd == null || this.hGd.bVs() == null) {
                        arrayList = null;
                    } else {
                        arrayList = this.hGd.bVs().switchThreadDataToThreadCardInfo(arrayList2);
                    }
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (this.hFR != null) {
                                this.hFR.removeItem(i3 + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    public void d(o oVar) {
        if (oVar != null && this.mThreadList != null) {
            this.mThreadList.remove(oVar);
        }
    }

    public void a(c.a aVar) {
        this.hFR = aVar;
    }
}
