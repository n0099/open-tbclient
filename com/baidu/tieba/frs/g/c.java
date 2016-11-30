package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.e.t;
import com.baidu.tieba.tbadkCore.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e<FrsActivity> {
    private t bSO;
    private final FrsActivity bTA;
    private int ccx;
    private int mPn;
    private int mSortType;
    private final ArrayList<v> mThreadList;

    public c(FrsActivity frsActivity, t tVar) {
        super(frsActivity.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.ccx = -1;
        this.bTA = frsActivity;
        this.bSO = tVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public int acb() {
        return this.ccx;
    }

    public void setHasMore(int i) {
        this.ccx = i;
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
        int i = 0;
        if (x.t(arrayList)) {
            if (this.bSO != null) {
                this.bSO.a(this.mSortType, z2, 0, z, null);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<v> arrayList2 = new ArrayList<>();
            ArrayList<v> arrayList3 = new ArrayList<>();
            Iterator<v> it = arrayList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (!(next instanceof bi)) {
                    if (c(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bk) {
                        if (!e(((bk) next).getId(), this.mThreadList)) {
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
                R(this.mThreadList);
                if (this.bSO != null) {
                    this.bSO.a(this.mSortType, z2, i, z, arrayList2);
                }
                h(this.mThreadList, arrayList2);
                aC(arrayList2);
                agN();
                S(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void aC(List<v> list) {
        if (!x.t(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean c(v vVar) {
        if (vVar == null) {
            return false;
        }
        if (vVar instanceof aa) {
            return true;
        }
        return (vVar instanceof bk) && ((bk) vVar).rL() == 2;
    }

    private void a(ArrayList<v> arrayList, boolean z, int i) {
        int s;
        int i2;
        if (arrayList != null && (s = x.s(arrayList)) > i) {
            int max = Math.max(s - i, 30);
            if (z) {
                i2 = ((s - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            x.b(arrayList, i2, max + i2);
        }
    }

    public void R(ArrayList<v> arrayList) {
        if (!x.t(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<v> it = arrayList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (c(next)) {
                    arrayList2.add(next);
                } else if (next instanceof bi) {
                    arrayList2.add(next);
                }
            }
            if (!x.t(arrayList2)) {
                this.mThreadList.removeAll(arrayList2);
            }
        }
    }

    public void S(ArrayList<v> arrayList) {
        if (!x.t(arrayList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void agN() {
        ArrayList<v> arrayList = this.mThreadList;
        if (!x.t(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator<v> it = arrayList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (next != null) {
                    if (next.getType() == bk.UW) {
                        arrayList2.add(next);
                    } else if ((next instanceof bk) && ((bk) next).rN() == 1) {
                        arrayList3.add(next);
                    }
                }
            }
            if (!x.t(arrayList3)) {
                arrayList.removeAll(arrayList3);
                arrayList.addAll(0, arrayList3);
            }
            if (!x.t(arrayList2)) {
                arrayList.removeAll(arrayList2);
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
            if ((next instanceof bk) && str.equalsIgnoreCase(((bk) next).getTid())) {
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
        this.ccx = -1;
        this.mPn = 1;
    }

    private void h(List<v> list, List<v> list2) {
        if (!x.t(list) && !x.t(list2)) {
            long kd = a.agJ().kd(this.bTA.getForumName());
            bi biVar = new bi();
            if (kd > 0) {
                biVar.bg(kd);
            } else {
                biVar.bg(System.currentTimeMillis());
            }
            list2.add(biVar);
            a.agJ().i(this.bTA.getForumName(), System.currentTimeMillis());
        }
    }
}
