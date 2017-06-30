package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.bh;
import com.baidu.tieba.frs.mc.aa;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int bqy;
    private final r cbE;
    private aa cda;
    private int mPn;
    private int mSortType;
    private final ArrayList<v> mThreadList;

    public FrsSmartLoadMoreModel(r rVar, aa aaVar) {
        super(rVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bqy = -1;
        this.cbE = rVar;
        setUniqueId(this.cbE.getUniqueId());
        this.cda = aaVar;
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

    public int adV() {
        return this.bqy;
    }

    public void setHasMore(int i) {
        this.bqy = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<v> a(boolean z, boolean z2, ArrayList<v> arrayList) {
        if (z.t(arrayList)) {
            if (this.cda != null) {
                this.cda.a(this.mSortType, z2, 0, z, null);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<v> arrayList2 = new ArrayList<>();
            ArrayList<v> arrayList3 = new ArrayList<>();
            Iterator<v> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                v next = it.next();
                if (!(next instanceof bh)) {
                    if (e(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bm) {
                        bm bmVar = (bm) next;
                        bmVar.aq(true);
                        if ((bmVar.sB() != null && !bmVar.rO()) || !e(bmVar.getId(), this.mThreadList)) {
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
                N(arrayList2);
            }
            this.cbE.aek().a(this.cbE, true, arrayList2, this.mThreadList, this.cbE.adP().agX());
            if (z2) {
                if (this.cda != null) {
                    this.cda.a(this.mSortType, z2, i, z, arrayList2);
                }
                ahh();
                j(this.mThreadList, arrayList2);
                aA(arrayList2);
                M(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void aA(List<v> list) {
        if (!z.t(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(v vVar) {
        if (vVar == null) {
            return false;
        }
        if (vVar instanceof u) {
            return true;
        }
        return (vVar instanceof bm) && ((bm) vVar).rm() == 2;
    }

    private void a(ArrayList<v> arrayList, boolean z, int i) {
        int s;
        int i2;
        if (arrayList != null && (s = z.s(arrayList)) > i) {
            int max = Math.max(s - i, 30);
            if (z) {
                i2 = ((s - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            z.b(arrayList, i2, max + i2);
        }
    }

    public void ahh() {
        if (!z.t(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<v> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof bh) {
                    arrayList.add(next);
                }
            }
            if (!z.t(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void M(ArrayList<v> arrayList) {
        if (!z.t(arrayList) && !z.t(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void N(ArrayList<v> arrayList) {
        if (!z.t(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!z.t(arrayList)) {
                Iterator<v> it = arrayList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next != null) {
                        if (next.getType() == bm.Yz) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bm) && ((bm) next).ro() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!z.t(arrayList2)) {
                if (!z.t(this.mThreadList)) {
                    Iterator<v> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        v next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bm.Yz) {
                                it2.remove();
                            } else if ((next2 instanceof bm) && ((bm) next2).ro() == 1) {
                                it2.remove();
                            }
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean e(String str, ArrayList<v> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<v> it = arrayList.iterator();
        while (it.hasNext()) {
            v next = it.next();
            if ((next instanceof bm) && str.equalsIgnoreCase(((bm) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<v> getDataList() {
        return this.mThreadList;
    }

    public void resetData() {
        this.mThreadList.clear();
        this.bqy = -1;
        this.mPn = 1;
    }

    private void j(List<v> list, List<v> list2) {
        if (!z.t(list) && !z.t(list2)) {
            long kd = a.ahd().kd(this.cbE.getForumName());
            bh bhVar = new bh();
            if (kd > 0) {
                bhVar.bf(kd);
            } else {
                bhVar.bf(System.currentTimeMillis());
            }
            list2.add(bhVar);
            a.ahd().h(this.cbE.getForumName(), System.currentTimeMillis());
        }
    }
}
