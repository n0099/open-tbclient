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
    private int dSu;
    private k fak;
    private c.a fqG;
    private final FrsFragment fqS;
    private int mPn;
    private int mSortType;
    private final ArrayList<m> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.dSu = -1;
        this.fqS = frsFragment;
        setUniqueId(this.fqS.getUniqueId());
        this.fak = kVar;
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

    public int bcv() {
        return this.dSu;
    }

    public void setHasMore(int i) {
        this.dSu = i;
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
            if (FrsFragment.eYW != null) {
                this.mThreadList.addAll(FrsFragment.eYW.getThreadList());
            }
            FrsFragment.eYW = null;
        }
        if (v.T(arrayList)) {
            if (this.fak != null) {
                this.fak.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            if (z2) {
                bii();
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
                            bgVar.dm(true);
                            ak(bgVar);
                            if ((bgVar.aai() == null || bgVar.Zo()) && e(bgVar.getId(), this.mThreadList)) {
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
                Y(arrayList2);
            }
            this.fqS.bcR().addRecommendAppToThreadList(this.fqS, true, arrayList2, this.mThreadList, this.fqS.bcp().bhS());
            if (z2) {
                if (this.fak != null) {
                    this.fak.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                bih();
                j(this.mThreadList, arrayList2);
                cf(arrayList2);
                X(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void ak(bg bgVar) {
        if (bgVar != null && this.fqS != null && this.fqS.bcR() != null && this.fqS.bcR().getForum() != null) {
            bgVar.lr(this.fqS.bcR().getForum().getFirst_class());
            bgVar.ls(this.fqS.bcR().getForum().getSecond_class());
        }
    }

    private void cf(List<m> list) {
        if (!v.T(list)) {
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
        if ((!(mVar instanceof bg) || ((bg) mVar).YM() != 2) && mVar.getType() != l.iEP) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<m> arrayList, int i) {
        int S;
        if (arrayList != null && (S = v.S(arrayList)) > i) {
            int max = Math.max(S - i, 30);
            int i2 = ((S - 20) - max) - 1;
            v.d(arrayList, i2, max + i2);
        }
    }

    public void bih() {
        if (!v.T(this.mThreadList)) {
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
            if (!v.T(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void bii() {
        int i;
        if (!v.T(this.mThreadList)) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= (this.mThreadList.size() > 30 ? 30 : this.mThreadList.size())) {
                    i = -1;
                    break;
                }
                m mVar = this.mThreadList.get(i);
                if ((mVar instanceof bg) && ((bg) mVar).YV()) {
                    break;
                }
                i2 = i + 1;
            }
            if (i >= 0) {
                this.mThreadList.remove(i);
            }
        }
    }

    public void X(ArrayList<m> arrayList) {
        if (!v.T(arrayList) && !v.T(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void Y(ArrayList<m> arrayList) {
        if (!v.T(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.T(arrayList)) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if (next != null) {
                        if (next.getType() == bg.bCA) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bg) && ((bg) next).YO() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof f) || (next instanceof g)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.T(arrayList2)) {
                if (!v.T(this.mThreadList)) {
                    Iterator<m> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        m next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bg.bCA) {
                                it2.remove();
                            } else if ((next2 instanceof bg) && ((bg) next2).YO() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof f) || (next2 instanceof g)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!v.T(arrayList2)) {
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

    private boolean e(String str, ArrayList<m> arrayList) {
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

    public void Z(ArrayList<m> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.dSu = -1;
        this.mPn = 1;
    }

    private void j(List<m> list, List<m> list2) {
        if (!v.T(list) && !v.T(list2)) {
            long vF = a.bic().vF(this.fqS.getForumName());
            p pVar = new p();
            if (vF > 0) {
                pVar.cE(vF);
            } else {
                pVar.cE(System.currentTimeMillis());
            }
            list2.add(pVar);
            a.bic().r(this.fqS.getForumName(), System.currentTimeMillis());
        }
    }

    public void bhB() {
        int S = v.S(this.mThreadList) + 30;
        if (S > 300) {
            int i = S - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    this.mThreadList.remove(20);
                    if (this.fqG != null) {
                        this.fqG.removeItem(20);
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
        this.fqG = aVar;
    }
}
