package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.mc.x;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<FrsActivity> {
    private x bNx;
    private final FrsActivity bOf;
    private int biU;
    private int buQ;
    private int mSortType;
    private final ArrayList<v> mThreadList;

    public FrsSmartLoadMoreModel(FrsActivity frsActivity, x xVar) {
        super(frsActivity.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.buQ = 1;
        this.biU = -1;
        this.bOf = frsActivity;
        this.bNx = xVar;
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

    public int Zb() {
        return this.biU;
    }

    public void setHasMore(int i) {
        this.biU = i;
    }

    public int getPn() {
        return this.buQ;
    }

    public void setPn(int i) {
        if (i > this.buQ) {
            this.buQ = i;
        }
    }

    public ArrayList<v> a(boolean z, boolean z2, ArrayList<v> arrayList) {
        if (com.baidu.tbadk.core.util.x.q(arrayList)) {
            if (this.bNx != null) {
                this.bNx.a(this.mSortType, z2, 0, z, null);
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
                if (!(next instanceof bl)) {
                    if (d(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bi) {
                        bi biVar = (bi) next;
                        biVar.au(true);
                        if ((biVar.tv() != null && !biVar.sL()) || !e(biVar.getId(), this.mThreadList)) {
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
                K(arrayList2);
            }
            this.bOf.Zr().a(this.bOf, true, arrayList2, this.mThreadList, this.bOf.YT().acV());
            if (z2) {
                if (this.bNx != null) {
                    this.bNx.a(this.mSortType, z2, i, z, arrayList2);
                }
                adh();
                f(this.mThreadList, arrayList2);
                au(arrayList2);
                J(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void au(List<v> list) {
        if (!com.baidu.tbadk.core.util.x.q(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean d(v vVar) {
        if (vVar == null) {
            return false;
        }
        if (vVar instanceof w) {
            return true;
        }
        return (vVar instanceof bi) && ((bi) vVar).sk() == 2;
    }

    private void a(ArrayList<v> arrayList, boolean z, int i) {
        int p;
        int i2;
        if (arrayList != null && (p = com.baidu.tbadk.core.util.x.p(arrayList)) > i) {
            int max = Math.max(p - i, 30);
            if (z) {
                i2 = ((p - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            com.baidu.tbadk.core.util.x.b(arrayList, i2, max + i2);
        }
    }

    public void adh() {
        if (!com.baidu.tbadk.core.util.x.q(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<v> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (d(next)) {
                    arrayList.add(next);
                } else if (next instanceof bl) {
                    arrayList.add(next);
                }
            }
            if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void J(ArrayList<v> arrayList) {
        if (!com.baidu.tbadk.core.util.x.q(arrayList) && !com.baidu.tbadk.core.util.x.q(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void K(ArrayList<v> arrayList) {
        if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
                Iterator<v> it = arrayList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next != null) {
                        if (next.getType() == bi.Zj) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bi) && ((bi) next).sm() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!com.baidu.tbadk.core.util.x.q(arrayList2)) {
                if (!com.baidu.tbadk.core.util.x.q(this.mThreadList)) {
                    Iterator<v> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        v next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bi.Zj) {
                                it2.remove();
                            } else if ((next2 instanceof bi) && ((bi) next2).sm() == 1) {
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
            if ((next instanceof bi) && str.equalsIgnoreCase(((bi) next).getTid())) {
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
        this.biU = -1;
        this.buQ = 1;
    }

    private void f(List<v> list, List<v> list2) {
        if (!com.baidu.tbadk.core.util.x.q(list) && !com.baidu.tbadk.core.util.x.q(list2)) {
            long iQ = a.add().iQ(this.bOf.getForumName());
            bl blVar = new bl();
            if (iQ > 0) {
                blVar.aP(iQ);
            } else {
                blVar.aP(System.currentTimeMillis());
            }
            list2.add(blVar);
            a.add().i(this.bOf.getForumName(), System.currentTimeMillis());
        }
    }
}
