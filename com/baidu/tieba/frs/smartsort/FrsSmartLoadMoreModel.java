package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.i;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int cik;
    private final FrsFragment dAK;
    private c.a dAy;
    private i dkJ;
    private int mPn;
    private int mSortType;
    private final ArrayList<h> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, i iVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.cik = -1;
        this.dAK = frsFragment;
        setUniqueId(this.dAK.getUniqueId());
        this.dkJ = iVar;
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

    public int atJ() {
        return this.cik;
    }

    public void setHasMore(int i) {
        this.cik = i;
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
        if (w.A(arrayList)) {
            if (this.dkJ != null) {
                this.dkJ.a(this.mSortType, z2, 0, z, null, z3);
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
                if (!z4 || !(next instanceof q)) {
                    if (!(next instanceof p)) {
                        if (e(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof bc) {
                            bc bcVar = (bc) next;
                            bcVar.au(true);
                            Z(bcVar);
                            if ((bcVar.wD() == null || bcVar.vS()) && e(bcVar.getId(), this.mThreadList)) {
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
                V(arrayList2);
            }
            this.dAK.atZ().a(this.dAK, true, arrayList2, this.mThreadList, this.dAK.atD().azi());
            if (z2) {
                if (this.dkJ != null) {
                    this.dkJ.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                azt();
                k(this.mThreadList, arrayList2);
                bz(arrayList2);
                U(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void Z(bc bcVar) {
        if (bcVar != null && this.dAK != null && this.dAK.atZ() != null && this.dAK.atZ().baT() != null) {
            bcVar.dx(this.dAK.atZ().baT().getFirst_class());
            bcVar.dy(this.dAK.atZ().baT().getSecond_class());
        }
    }

    private void bz(List<h> list) {
        if (!w.A(list)) {
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
        if ((!(hVar instanceof bc) || ((bc) hVar).vr() != 2) && hVar.getType() != k.gLF) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<h> arrayList, int i) {
        int z;
        if (arrayList != null && (z = w.z(arrayList)) > i) {
            int max = Math.max(z - i, 30);
            int i2 = ((z - 20) - max) - 1;
            w.b(arrayList, i2, max + i2);
        }
    }

    public void azt() {
        if (!w.A(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<h> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof p) {
                    arrayList.add(next);
                }
            }
            if (!w.A(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void U(ArrayList<h> arrayList) {
        if (!w.A(arrayList) && !w.A(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void V(ArrayList<h> arrayList) {
        if (!w.A(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!w.A(arrayList)) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null) {
                        if (next.getType() == bc.ajw) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bc) && ((bc) next).vt() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof e) || (next instanceof f)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!w.A(arrayList2)) {
                if (!w.A(this.mThreadList)) {
                    Iterator<h> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        h next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bc.ajw) {
                                it2.remove();
                            } else if ((next2 instanceof bc) && ((bc) next2).vt() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof e) || (next2 instanceof f)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!w.A(arrayList2)) {
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
            if ((next instanceof bc) && str.equalsIgnoreCase(((bc) next).getTid())) {
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
        this.cik = -1;
        this.mPn = 1;
    }

    private void k(List<h> list, List<h> list2) {
        if (!w.A(list) && !w.A(list2)) {
            long mX = a.azo().mX(this.dAK.getForumName());
            p pVar = new p();
            if (mX > 0) {
                pVar.setReadTime(mX);
            } else {
                pVar.setReadTime(System.currentTimeMillis());
            }
            list2.add(pVar);
            a.azo().l(this.dAK.getForumName(), System.currentTimeMillis());
        }
    }

    public void ayQ() {
        int z = w.z(this.mThreadList) + 30;
        if (z > 300) {
            int i = z - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.mThreadList.remove(20);
                    if (this.dAy != null) {
                        this.dAy.removeItem(20);
                    }
                }
            }
        }
    }

    public void Y(bc bcVar) {
        if (bcVar != null && this.mThreadList != null) {
            this.mThreadList.remove(bcVar);
        }
    }

    public void a(c.a aVar) {
        this.dAy = aVar;
    }
}
