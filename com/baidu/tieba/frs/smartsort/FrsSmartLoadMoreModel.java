package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bj;
import com.baidu.tieba.frs.mc.s;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<FrsActivity> {
    private s bGz;
    private final FrsActivity bHh;
    private int bco;
    private int mPn;
    private int mSortType;
    private final ArrayList<v> mThreadList;

    public FrsSmartLoadMoreModel(FrsActivity frsActivity, s sVar) {
        super(frsActivity.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bco = -1;
        this.bHh = frsActivity;
        this.bGz = sVar;
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

    public int XG() {
        return this.bco;
    }

    public void setHasMore(int i) {
        this.bco = i;
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
        if (w.s(arrayList)) {
            if (this.bGz != null) {
                this.bGz.a(this.mSortType, z2, 0, z, null);
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
                if (!(next instanceof bj)) {
                    if (d(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bh) {
                        bh bhVar = (bh) next;
                        bhVar.at(true);
                        if (!e(bhVar.getId(), this.mThreadList)) {
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
                b(arrayList2, this.mThreadList);
            }
            this.bHh.XW().a(this.bHh, true, arrayList2, this.mThreadList, this.bHh.Xy().ace());
            if (z2) {
                K(this.mThreadList);
                if (this.bGz != null) {
                    this.bGz.a(this.mSortType, z2, i, z, arrayList2);
                }
                e(this.mThreadList, arrayList2);
                ay(arrayList2);
                L(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void ay(List<v> list) {
        if (!w.s(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean d(v vVar) {
        if (vVar == null) {
            return false;
        }
        if (vVar instanceof x) {
            return true;
        }
        return (vVar instanceof bh) && ((bh) vVar).rs() == 2;
    }

    private void a(ArrayList<v> arrayList, boolean z, int i) {
        int r;
        int i2;
        if (arrayList != null && (r = w.r(arrayList)) > i) {
            int max = Math.max(r - i, 30);
            if (z) {
                i2 = ((r - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            w.b(arrayList, i2, max + i2);
        }
    }

    public void K(ArrayList<v> arrayList) {
        if (!w.s(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<v> it = arrayList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (d(next)) {
                    arrayList2.add(next);
                } else if (next instanceof bj) {
                    arrayList2.add(next);
                }
            }
            if (!w.s(arrayList2)) {
                this.mThreadList.removeAll(arrayList2);
            }
        }
    }

    public void L(ArrayList<v> arrayList) {
        if (!w.s(arrayList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void b(ArrayList<v> arrayList, ArrayList<v> arrayList2) {
        if (!w.s(arrayList)) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<v> it = arrayList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (next != null) {
                    if (next.getType() == bh.TH) {
                        arrayList3.add(next);
                    } else if ((next instanceof bh) && ((bh) next).ru() == 1) {
                        arrayList4.add(next);
                    }
                }
            }
            if (!w.s(arrayList2)) {
                Iterator<v> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    v next2 = it2.next();
                    if (next2 != null) {
                        if (next2.getType() == bh.TH) {
                            arrayList3.add(next2);
                        } else if ((next2 instanceof bh) && ((bh) next2).ru() == 1) {
                            arrayList4.add(next2);
                        }
                    }
                }
            }
            if (!w.s(arrayList4)) {
                if (!w.s(arrayList2)) {
                    arrayList2.removeAll(arrayList4);
                }
                arrayList.removeAll(arrayList4);
                arrayList.addAll(0, arrayList4);
            }
            if (!w.s(arrayList3)) {
                if (!w.s(arrayList2)) {
                    arrayList2.removeAll(arrayList3);
                }
                arrayList.removeAll(arrayList3);
                arrayList.addAll(0, arrayList3);
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
            if ((next instanceof bh) && str.equalsIgnoreCase(((bh) next).getTid())) {
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
        this.bco = -1;
        this.mPn = 1;
    }

    private void e(List<v> list, List<v> list2) {
        if (!w.s(list) && !w.s(list2)) {
            long iU = a.acm().iU(this.bHh.getForumName());
            bj bjVar = new bj();
            if (iU > 0) {
                bjVar.aP(iU);
            } else {
                bjVar.aP(System.currentTimeMillis());
            }
            list2.add(bjVar);
            a.acm().i(this.bHh.getForumName(), System.currentTimeMillis());
        }
    }
}
