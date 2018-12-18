package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes6.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int cDk;
    private i dJm;
    private c.a dZD;
    private final FrsFragment dZP;
    private int mPn;
    private int mSortType;
    private final ArrayList<h> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, i iVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.cDk = -1;
        this.dZP = frsFragment;
        setUniqueId(this.dZP.getUniqueId());
        this.dJm = iVar;
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

    public int aAJ() {
        return this.cDk;
    }

    public void setHasMore(int i) {
        this.cDk = i;
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
        if (v.I(arrayList)) {
            if (this.dJm != null) {
                this.dJm.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            if (z2) {
                aGH();
            }
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
                        } else if (next instanceof bb) {
                            bb bbVar = (bb) next;
                            bbVar.bc(true);
                            ac(bbVar);
                            if ((bbVar.AQ() == null || bbVar.Ae()) && f(bbVar.getId(), this.mThreadList)) {
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
                U(arrayList2);
            }
            this.dZP.aAZ().a(this.dZP, true, arrayList2, this.mThreadList, this.dZP.aAD().aGv());
            if (z2) {
                if (this.dJm != null) {
                    this.dJm.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                aGG();
                k(this.mThreadList, arrayList2);
                bP(arrayList2);
                T(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void ac(bb bbVar) {
        if (bbVar != null && this.dZP != null && this.dZP.aAZ() != null && this.dZP.aAZ().bgh() != null) {
            bbVar.eu(this.dZP.aAZ().bgh().getFirst_class());
            bbVar.ev(this.dZP.aAZ().bgh().getSecond_class());
        }
    }

    private void bP(List<h> list) {
        if (!v.I(list)) {
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
        if ((!(hVar instanceof bb) || ((bb) hVar).zB() != 2) && hVar.getType() != k.hjW) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<h> arrayList, int i) {
        int H;
        if (arrayList != null && (H = v.H(arrayList)) > i) {
            int max = Math.max(H - i, 30);
            int i2 = ((H - 20) - max) - 1;
            v.c(arrayList, i2, max + i2);
        }
    }

    public void aGG() {
        if (!v.I(this.mThreadList)) {
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
            if (!v.I(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void aGH() {
        int i;
        if (!v.I(this.mThreadList)) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= (this.mThreadList.size() > 30 ? 30 : this.mThreadList.size())) {
                    i = -1;
                    break;
                }
                h hVar = this.mThreadList.get(i);
                if ((hVar instanceof bb) && ((bb) hVar).zL()) {
                    break;
                }
                i2 = i + 1;
            }
            if (i >= 0) {
                this.mThreadList.remove(i);
            }
        }
    }

    public void T(ArrayList<h> arrayList) {
        if (!v.I(arrayList) && !v.I(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void U(ArrayList<h> arrayList) {
        if (!v.I(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.I(arrayList)) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null) {
                        if (next.getType() == bb.auD) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bb) && ((bb) next).zD() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof e) || (next instanceof f)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.I(arrayList2)) {
                if (!v.I(this.mThreadList)) {
                    Iterator<h> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        h next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bb.auD) {
                                it2.remove();
                            } else if ((next2 instanceof bb) && ((bb) next2).zD() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof e) || (next2 instanceof f)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!v.I(arrayList2)) {
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

    private boolean f(String str, ArrayList<h> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<h> it = arrayList.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if ((next instanceof bb) && str.equalsIgnoreCase(((bb) next).getTid())) {
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
        this.cDk = -1;
        this.mPn = 1;
    }

    private void k(List<h> list, List<h> list2) {
        if (!v.I(list) && !v.I(list2)) {
            long oH = a.aGB().oH(this.dZP.getForumName());
            p pVar = new p();
            if (oH > 0) {
                pVar.bU(oH);
            } else {
                pVar.bU(System.currentTimeMillis());
            }
            list2.add(pVar);
            a.aGB().o(this.dZP.getForumName(), System.currentTimeMillis());
        }
    }

    public void aGd() {
        int H = v.H(this.mThreadList) + 30;
        if (H > 300) {
            int i = H - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.mThreadList.remove(20);
                    if (this.dZD != null) {
                        this.dZD.removeItem(20);
                    }
                }
            }
        }
    }

    public void ab(bb bbVar) {
        if (bbVar != null && this.mThreadList != null) {
            this.mThreadList.remove(bbVar);
        }
    }

    public void a(c.a aVar) {
        this.dZD = aVar;
    }
}
