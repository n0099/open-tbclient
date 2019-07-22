package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int egI;
    private c.a fLP;
    private final FrsFragment fMb;
    private k fvk;
    private int mPn;
    private int mSortType;
    private final ArrayList<m> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.egI = -1;
        this.fMb = frsFragment;
        setUniqueId(this.fMb.getUniqueId());
        this.fvk = kVar;
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

    public int blS() {
        return this.egI;
    }

    public void setHasMore(int i) {
        this.egI = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<m> a(boolean z, boolean z2, ArrayList<m> arrayList, boolean z3, boolean z4) {
        int i;
        if (!z3 && this.mThreadList.size() == 0) {
            if (FrsFragment.ftT != null) {
                this.mThreadList.addAll(FrsFragment.ftT.getThreadList());
            }
            FrsFragment.ftT = null;
        }
        if (v.aa(arrayList)) {
            if (this.fvk != null) {
                this.fvk.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            if (z2) {
                brA();
            }
            ArrayList<m> arrayList2 = new ArrayList<>();
            ArrayList<m> arrayList3 = new ArrayList<>();
            Iterator<m> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m next = it.next();
                if (!z4 || !(next instanceof q)) {
                    if (!(next instanceof p)) {
                        if (f(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof bg) {
                            bg bgVar = (bg) next;
                            bgVar.dL(true);
                            aj(bgVar);
                            if ((bgVar.afO() == null || bgVar.aeU()) && d(bgVar.getId(), this.mThreadList)) {
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
                ac(arrayList2);
            }
            this.fMb.bmo().addRecommendAppToThreadList(this.fMb, true, arrayList2, this.mThreadList, this.fMb.blM().brp());
            if (z2) {
                if (this.fvk != null) {
                    this.fvk.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                brz();
                j(this.mThreadList, arrayList2);
                cl(arrayList2);
                ab(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void aj(bg bgVar) {
        if (bgVar != null && this.fMb != null && this.fMb.bmo() != null && this.fMb.bmo().getForum() != null) {
            bgVar.mH(this.fMb.bmo().getForum().getFirst_class());
            bgVar.mI(this.fMb.bmo().getForum().getSecond_class());
        }
    }

    private void cl(List<m> list) {
        if (!v.aa(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean f(m mVar) {
        if (mVar == null) {
            return false;
        }
        if (mVar instanceof s) {
            return true;
        }
        if ((!(mVar instanceof bg) || ((bg) mVar).aes() != 2) && mVar.getType() != l.jdL) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<m> arrayList, int i) {
        int Z;
        if (arrayList != null && (Z = v.Z(arrayList)) > i) {
            int max = Math.max(Z - i, 30);
            int i2 = ((Z - 20) - max) - 1;
            v.d(arrayList, i2, max + i2);
        }
    }

    public void brz() {
        if (!v.aa(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<m> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (f(next)) {
                    arrayList.add(next);
                } else if (next instanceof p) {
                    arrayList.add(next);
                }
            }
            if (!v.aa(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void brA() {
        int i;
        if (!v.aa(this.mThreadList)) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= (this.mThreadList.size() > 30 ? 30 : this.mThreadList.size())) {
                    i = -1;
                    break;
                }
                m mVar = this.mThreadList.get(i);
                if ((mVar instanceof bg) && ((bg) mVar).aeB()) {
                    break;
                }
                i2 = i + 1;
            }
            if (i >= 0) {
                this.mThreadList.remove(i);
            }
        }
    }

    public void ab(ArrayList<m> arrayList) {
        if (!v.aa(arrayList) && !v.aa(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void ac(ArrayList<m> arrayList) {
        if (!v.aa(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.aa(arrayList)) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if (next != null) {
                        if (next.getType() == bg.bKV) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bg) && ((bg) next).aeu() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof f) || (next instanceof g)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.aa(arrayList2)) {
                if (!v.aa(this.mThreadList)) {
                    Iterator<m> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        m next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bg.bKV) {
                                it2.remove();
                            } else if ((next2 instanceof bg) && ((bg) next2).aeu() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof f) || (next2 instanceof g)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!v.aa(arrayList2)) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        m mVar = (m) it3.next();
                        if (mVar != null && ((mVar instanceof f) || (mVar instanceof g))) {
                            it3.remove();
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean d(String str, ArrayList<m> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if ((next instanceof bg) && str.equalsIgnoreCase(((bg) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<m> getDataList() {
        return this.mThreadList;
    }

    public void ad(ArrayList<m> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.egI = -1;
        this.mPn = 1;
    }

    private void j(List<m> list, List<m> list2) {
        if (!v.aa(list) && !v.aa(list2)) {
            list2.add(new p());
        }
    }

    public void bqY() {
        int Z = v.Z(this.mThreadList) + 30;
        if (Z > 300) {
            int i = Z - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.mThreadList.remove(20);
                    if (this.fLP != null) {
                        this.fLP.removeItem(20);
                    }
                }
            }
        }
    }

    public void e(m mVar) {
        if (mVar != null && this.mThreadList != null) {
            this.mThreadList.remove(mVar);
        }
    }

    public void a(c.a aVar) {
        this.fLP = aVar;
    }
}
