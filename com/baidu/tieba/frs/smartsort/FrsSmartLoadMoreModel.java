package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int cfZ;
    private i diI;
    private c.a dxk;
    private final FrsFragment dxw;
    private int mPn;
    private int mSortType;
    private final ArrayList<h> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, i iVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.cfZ = -1;
        this.dxw = frsFragment;
        setUniqueId(this.dxw.getUniqueId());
        this.diI = iVar;
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

    public int ats() {
        return this.cfZ;
    }

    public void setHasMore(int i) {
        this.cfZ = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<h> a(boolean z, boolean z2, ArrayList<h> arrayList, boolean z3, boolean z4) {
        int i;
        if (w.z(arrayList)) {
            if (this.diI != null) {
                this.diI.a(this.mSortType, z2, 0, z, null, z3);
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
                if (!z4 || !(next instanceof o)) {
                    if (!(next instanceof n)) {
                        if (e(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof bd) {
                            bd bdVar = (bd) next;
                            bdVar.at(true);
                            U(bdVar);
                            if ((bdVar.wt() == null || bdVar.vI()) && e(bdVar.getId(), this.mThreadList)) {
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
                P(arrayList2);
            }
            this.dxw.atI().a(this.dxw, true, arrayList2, this.mThreadList, this.dxw.atm().ayC());
            if (z2) {
                if (this.diI != null) {
                    this.diI.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                ayN();
                k(this.mThreadList, arrayList2);
                bv(arrayList2);
                O(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void U(bd bdVar) {
        if (bdVar != null && this.dxw != null && this.dxw.atI() != null && this.dxw.atI().bam() != null) {
            bdVar.du(this.dxw.atI().bam().getFirst_class());
            bdVar.dv(this.dxw.atI().bam().getSecond_class());
        }
    }

    private void bv(List<h> list) {
        if (!w.z(list)) {
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
        if ((!(hVar instanceof bd) || ((bd) hVar).vh() != 2) && hVar.getType() != k.gHG) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<h> arrayList, int i) {
        int y;
        if (arrayList != null && (y = w.y(arrayList)) > i) {
            int max = Math.max(y - i, 30);
            int i2 = ((y - 20) - max) - 1;
            w.b(arrayList, i2, max + i2);
        }
    }

    public void ayN() {
        if (!w.z(this.mThreadList)) {
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
            if (!w.z(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void O(ArrayList<h> arrayList) {
        if (!w.z(arrayList) && !w.z(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void P(ArrayList<h> arrayList) {
        if (!w.z(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!w.z(arrayList)) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null) {
                        if (next.getType() == bd.ajb) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bd) && ((bd) next).vj() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof e) || (next instanceof f)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!w.z(arrayList2)) {
                if (!w.z(this.mThreadList)) {
                    Iterator<h> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        h next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bd.ajb) {
                                it2.remove();
                            } else if ((next2 instanceof bd) && ((bd) next2).vj() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof e) || (next2 instanceof f)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!w.z(arrayList2)) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        h hVar = (h) it3.next();
                        if (hVar != null && ((hVar instanceof e) || (hVar instanceof f))) {
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
        this.cfZ = -1;
        this.mPn = 1;
    }

    private void k(List<h> list, List<h> list2) {
        if (!w.z(list) && !w.z(list2)) {
            long mX = a.ayI().mX(this.dxw.getForumName());
            n nVar = new n();
            if (mX > 0) {
                nVar.setReadTime(mX);
            } else {
                nVar.setReadTime(System.currentTimeMillis());
            }
            list2.add(nVar);
            a.ayI().l(this.dxw.getForumName(), System.currentTimeMillis());
        }
    }

    public void ayk() {
        int y = w.y(this.mThreadList) + 30;
        if (y > 300) {
            int i = y - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.mThreadList.remove(20);
                    if (this.dxk != null) {
                        this.dxk.removeItem(20);
                    }
                }
            }
        }
    }

    public void a(c.a aVar) {
        this.dxk = aVar;
    }
}
