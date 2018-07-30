package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bb;
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
    private int cjR;
    private c.a dDk;
    private final FrsFragment dDw;
    private i dnz;
    private int mPn;
    private int mSortType;
    private final ArrayList<h> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, i iVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.cjR = -1;
        this.dDw = frsFragment;
        setUniqueId(this.dDw.getUniqueId());
        this.dnz = iVar;
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

    public int aun() {
        return this.cjR;
    }

    public void setHasMore(int i) {
        this.cjR = i;
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
            if (this.dnz != null) {
                this.dnz.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            if (z2) {
                aAa();
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
                            bbVar.ar(true);
                            ab(bbVar);
                            if ((bbVar.ws() == null || bbVar.vH()) && e(bbVar.getId(), this.mThreadList)) {
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
            this.dDw.auD().a(this.dDw, true, arrayList2, this.mThreadList, this.dDw.auh().azO());
            if (z2) {
                if (this.dnz != null) {
                    this.dnz.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                azZ();
                k(this.mThreadList, arrayList2);
                by(arrayList2);
                U(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void ab(bb bbVar) {
        if (bbVar != null && this.dDw != null && this.dDw.auD() != null && this.dDw.auD().aZl() != null) {
            bbVar.du(this.dDw.auD().aZl().getFirst_class());
            bbVar.dv(this.dDw.auD().aZl().getSecond_class());
        }
    }

    private void by(List<h> list) {
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
        if ((!(hVar instanceof bb) || ((bb) hVar).vf() != 2) && hVar.getType() != k.gMD) {
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

    public void azZ() {
        if (!w.z(this.mThreadList)) {
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
            if (!w.z(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void aAa() {
        int i;
        if (!w.z(this.mThreadList)) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= (this.mThreadList.size() > 30 ? 30 : this.mThreadList.size())) {
                    i = -1;
                    break;
                }
                h hVar = this.mThreadList.get(i);
                if ((hVar instanceof bb) && ((bb) hVar).vp()) {
                    break;
                }
                i2 = i + 1;
            }
            if (i >= 0) {
                this.mThreadList.remove(i);
            }
        }
    }

    public void U(ArrayList<h> arrayList) {
        if (!w.z(arrayList) && !w.z(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void V(ArrayList<h> arrayList) {
        if (!w.z(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!w.z(arrayList)) {
                Iterator<h> it = arrayList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null) {
                        if (next.getType() == bb.aiT) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bb) && ((bb) next).vh() == 1) {
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
                            if (next2.getType() == bb.aiT) {
                                it2.remove();
                            } else if ((next2 instanceof bb) && ((bb) next2).vh() == 1) {
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
        this.cjR = -1;
        this.mPn = 1;
    }

    private void k(List<h> list, List<h> list2) {
        if (!w.z(list) && !w.z(list2)) {
            long mW = a.azU().mW(this.dDw.getForumName());
            p pVar = new p();
            if (mW > 0) {
                pVar.bG(mW);
            } else {
                pVar.bG(System.currentTimeMillis());
            }
            list2.add(pVar);
            a.azU().l(this.dDw.getForumName(), System.currentTimeMillis());
        }
    }

    public void azw() {
        int y = w.y(this.mThreadList) + 30;
        if (y > 300) {
            int i = y - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.mThreadList.remove(20);
                    if (this.dDk != null) {
                        this.dDk.removeItem(20);
                    }
                }
            }
        }
    }

    public void aa(bb bbVar) {
        if (bbVar != null && this.mThreadList != null) {
            this.mThreadList.remove(bbVar);
        }
    }

    public void a(c.a aVar) {
        this.dDk = aVar;
    }
}
