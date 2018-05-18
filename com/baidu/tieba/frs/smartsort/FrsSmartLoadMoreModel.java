package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int bXW;
    private i cZq;
    private c.a dnT;
    private final FrsFragment dof;
    private int mPn;
    private int mSortType;
    private final ArrayList<h> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, i iVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bXW = -1;
        this.dof = frsFragment;
        setUniqueId(this.dof.getUniqueId());
        this.cZq = iVar;
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

    public int apn() {
        return this.bXW;
    }

    public void setHasMore(int i) {
        this.bXW = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<h> a(boolean z, boolean z2, ArrayList<h> arrayList, boolean z3) {
        int i;
        if (v.w(arrayList)) {
            if (this.cZq != null) {
                this.cZq.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<h> arrayList2 = new ArrayList<>();
            ArrayList<h> arrayList3 = new ArrayList<>();
            Iterator<h> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                h next = it.next();
                if (!(next instanceof n)) {
                    if (e(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bd) {
                        bd bdVar = (bd) next;
                        bdVar.aq(true);
                        U(bdVar);
                        if ((bdVar.sW() == null || bdVar.sl()) && e(bdVar.getId(), this.mThreadList)) {
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
                Q(arrayList2);
            }
            this.dof.apD().a(this.dof, true, arrayList2, this.mThreadList, this.dof.apg().aup());
            if (z2) {
                if (this.cZq != null) {
                    this.cZq.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                auA();
                j(this.mThreadList, arrayList2);
                bs(arrayList2);
                P(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void U(bd bdVar) {
        if (bdVar != null && this.dof != null && this.dof.apD() != null && this.dof.apD().aVq() != null) {
            bdVar.cV(this.dof.apD().aVq().getFirst_class());
            bdVar.cW(this.dof.apD().aVq().getSecond_class());
        }
    }

    private void bs(List<h> list) {
        if (!v.w(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(h hVar) {
        if (hVar == null) {
            return false;
        }
        if (hVar instanceof s) {
            return true;
        }
        if ((!(hVar instanceof bd) || ((bd) hVar).rK() != 2) && hVar.getType() != k.gwh) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<h> arrayList, int i) {
        int v;
        if (arrayList != null && (v = v.v(arrayList)) > i) {
            int max = Math.max(v - i, 30);
            int i2 = ((v - 20) - max) - 1;
            v.b(arrayList, i2, max + i2);
        }
    }

    public void auA() {
        if (!v.w(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<h> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof n) {
                    arrayList.add(next);
                }
            }
            if (!v.w(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void P(ArrayList<h> arrayList) {
        if (!v.w(arrayList) && !v.w(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void Q(ArrayList<h> arrayList) {
        if (!v.w(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.w(arrayList)) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null) {
                        if (next.getType() == bd.aaW) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bd) && ((bd) next).rM() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof com.baidu.tieba.tbadkCore.e) || (next instanceof com.baidu.tieba.tbadkCore.f)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.w(arrayList2)) {
                if (!v.w(this.mThreadList)) {
                    Iterator<h> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        h next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bd.aaW) {
                                it2.remove();
                            } else if ((next2 instanceof bd) && ((bd) next2).rM() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof com.baidu.tieba.tbadkCore.e) || (next2 instanceof com.baidu.tieba.tbadkCore.f)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!v.w(arrayList2)) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        h hVar = (h) it3.next();
                        if (hVar != null && ((hVar instanceof com.baidu.tieba.tbadkCore.e) || (hVar instanceof com.baidu.tieba.tbadkCore.f))) {
                            it3.remove();
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean e(String str, ArrayList<h> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if ((next instanceof bd) && str.equalsIgnoreCase(((bd) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<h> getDataList() {
        return this.mThreadList;
    }

    public void resetData() {
        this.mThreadList.clear();
        this.bXW = -1;
        this.mPn = 1;
    }

    private void j(List<h> list, List<h> list2) {
        if (!v.w(list) && !v.w(list2)) {
            long mp = a.auv().mp(this.dof.getForumName());
            n nVar = new n();
            if (mp > 0) {
                nVar.setReadTime(mp);
            } else {
                nVar.setReadTime(System.currentTimeMillis());
            }
            list2.add(nVar);
            a.auv().l(this.dof.getForumName(), System.currentTimeMillis());
        }
    }

    public void atX() {
        int v = v.v(this.mThreadList) + 30;
        if (v > 300) {
            int i = v - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.mThreadList.remove(20);
                    if (this.dnT != null) {
                        this.dnT.removeItem(20);
                    }
                }
            }
        }
    }

    public void a(c.a aVar) {
        this.dnT = aVar;
    }
}
