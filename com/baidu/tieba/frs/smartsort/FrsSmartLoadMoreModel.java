package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.frs.mc.j;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int bvQ;
    private j cjR;

    /* renamed from: com  reason: collision with root package name */
    private final com.baidu.tieba.frs.f f6com;
    private int mPn;
    private int mSortType;
    private final ArrayList<com.baidu.adp.widget.ListView.f> mThreadList;

    public FrsSmartLoadMoreModel(com.baidu.tieba.frs.f fVar, j jVar) {
        super(fVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bvQ = -1;
        this.f6com = fVar;
        setUniqueId(this.f6com.getUniqueId());
        this.cjR = jVar;
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

    public int afa() {
        return this.bvQ;
    }

    public void setHasMore(int i) {
        this.bvQ = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> a(boolean z, boolean z2, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        int i;
        if (u.v(arrayList)) {
            if (this.cjR != null) {
                this.cjR.a(this.mSortType, z2, 0, z, null);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
            ArrayList<com.baidu.adp.widget.ListView.f> arrayList3 = new ArrayList<>();
            Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof p)) {
                    if (f(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bl) {
                        bl blVar = (bl) next;
                        blVar.aq(true);
                        if ((blVar.sQ() == null || blVar.sc()) && e(blVar.getId(), this.mThreadList)) {
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
                N(arrayList2);
            }
            this.f6com.afr().a(this.f6com, true, arrayList2, this.mThreadList, this.f6com.aeU().aiH());
            if (z2) {
                if (this.cjR != null) {
                    this.cjR.a(this.mSortType, z2, i2, z, arrayList2);
                }
                aiR();
                k(this.mThreadList, arrayList2);
                aN(arrayList2);
                M(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void aN(List<com.baidu.adp.widget.ListView.f> list) {
        if (!u.v(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean f(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar instanceof com.baidu.tieba.tbadkCore.p) {
            return true;
        }
        return (fVar instanceof bl) && ((bl) fVar).rA() == 2;
    }

    private void a(ArrayList<com.baidu.adp.widget.ListView.f> arrayList, boolean z, int i) {
        int u;
        int i2;
        if (arrayList != null && (u = u.u(arrayList)) > i) {
            int max = Math.max(u - i, 30);
            if (z) {
                i2 = ((u - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            u.b(arrayList, i2, max + i2);
        }
    }

    public void aiR() {
        if (!u.v(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.baidu.adp.widget.ListView.f> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (f(next)) {
                    arrayList.add(next);
                } else if (next instanceof p) {
                    arrayList.add(next);
                }
            }
            if (!u.v(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void M(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!u.v(arrayList) && !u.v(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void N(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (!u.v(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!u.v(arrayList)) {
                Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next != null) {
                        if (next.getType() == bl.aam) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bl) && ((bl) next).rC() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!u.v(arrayList2)) {
                if (!u.v(this.mThreadList)) {
                    Iterator<com.baidu.adp.widget.ListView.f> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        com.baidu.adp.widget.ListView.f next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bl.aam) {
                                it2.remove();
                            } else if ((next2 instanceof bl) && ((bl) next2).rC() == 1) {
                                it2.remove();
                            }
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean e(String str, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.f next = it.next();
            if ((next instanceof bl) && str.equalsIgnoreCase(((bl) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> getDataList() {
        return this.mThreadList;
    }

    public void resetData() {
        this.mThreadList.clear();
        this.bvQ = -1;
        this.mPn = 1;
    }

    private void k(List<com.baidu.adp.widget.ListView.f> list, List<com.baidu.adp.widget.ListView.f> list2) {
        if (!u.v(list) && !u.v(list2)) {
            long kt = a.aiN().kt(this.f6com.getForumName());
            p pVar = new p();
            if (kt > 0) {
                pVar.bh(kt);
            } else {
                pVar.bh(System.currentTimeMillis());
            }
            list2.add(pVar);
            a.aiN().i(this.f6com.getForumName(), System.currentTimeMillis());
        }
    }
}
