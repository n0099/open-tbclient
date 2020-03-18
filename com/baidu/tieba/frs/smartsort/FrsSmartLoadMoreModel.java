package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.c;
import com.baidu.tieba.frs.mc.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int fsO;
    private c.a gHD;
    private final FrsFragment gHP;
    private k gqy;
    private int mPn;
    private int mSortType;
    private final ArrayList<m> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.fsO = -1;
        this.gHP = frsFragment;
        setUniqueId(this.gHP.getUniqueId());
        this.gqy = kVar;
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

    public int bDZ() {
        return this.fsO;
    }

    public void setHasMore(int i) {
        this.fsO = i;
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
            if (FrsFragment.gpm != null) {
                this.mThreadList.addAll(FrsFragment.gpm.getThreadList());
            }
            FrsFragment.gpm = null;
        }
        if (v.isEmpty(arrayList)) {
            if (this.gqy != null) {
                this.gqy.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            if (z2) {
                bJS();
            }
            ArrayList<m> arrayList2 = new ArrayList<>();
            ArrayList<m> arrayList3 = new ArrayList<>();
            Iterator<m> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m next = it.next();
                if (!z4 || !(next instanceof s)) {
                    if (!(next instanceof r)) {
                        if (e(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof bj) {
                            bj bjVar = (bj) next;
                            bjVar.fC(true);
                            av(bjVar);
                            if ((bjVar.aDJ() == null || bjVar.aCO()) && g(bjVar.getId(), this.mThreadList)) {
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
                as(arrayList2);
            }
            this.gHP.bEz().addRecommendAppToThreadList(this.gHP, true, arrayList2, this.mThreadList, this.gHP.bDT().bJG());
            if (z2) {
                if (this.gqy != null) {
                    this.gqy.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                bJR();
                l(this.mThreadList, arrayList2);
                cp(arrayList2);
                ar(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void av(bj bjVar) {
        if (bjVar != null && this.gHP != null && this.gHP.bEz() != null && this.gHP.bEz().getForum() != null) {
            bjVar.sK(this.gHP.bEz().getForum().getFirst_class());
            bjVar.sL(this.gHP.bEz().getForum().getSecond_class());
        }
    }

    private void cp(List<m> list) {
        if (!v.isEmpty(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean e(m mVar) {
        if (mVar == null) {
            return false;
        }
        if (mVar instanceof com.baidu.tieba.tbadkCore.v) {
            return true;
        }
        if ((!(mVar instanceof bj) || ((bj) mVar).aCm() != 2) && mVar.getType() != o.kgX) {
            return false;
        }
        return true;
    }

    private void a(ArrayList<m> arrayList, int i) {
        int count;
        if (arrayList != null && (count = v.getCount(arrayList)) > i) {
            int max = Math.max(count - i, 30);
            int i2 = ((count - 20) - max) - 1;
            v.removeSubList(arrayList, i2, max + i2);
        }
    }

    public void bJR() {
        if (!v.isEmpty(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<m> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof r) {
                    arrayList.add(next);
                }
            }
            if (!v.isEmpty(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void bJS() {
        int i;
        if (!v.isEmpty(this.mThreadList)) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= (this.mThreadList.size() > 30 ? 30 : this.mThreadList.size())) {
                    i = -1;
                    break;
                }
                m mVar = this.mThreadList.get(i);
                if ((mVar instanceof bj) && ((bj) mVar).aCv()) {
                    break;
                }
                i2 = i + 1;
            }
            if (i >= 0) {
                this.mThreadList.remove(i);
            }
        }
    }

    public void ar(ArrayList<m> arrayList) {
        if (!v.isEmpty(arrayList) && !v.isEmpty(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void as(ArrayList<m> arrayList) {
        if (!v.isEmpty(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.isEmpty(arrayList)) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if (next != null) {
                        if (next.getType() == bj.cTr) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bj) && ((bj) next).aCo() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof g) || (next instanceof h)) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!v.isEmpty(arrayList2)) {
                if (!v.isEmpty(this.mThreadList)) {
                    Iterator<m> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        m next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bj.cTr) {
                                it2.remove();
                            } else if ((next2 instanceof bj) && ((bj) next2).aCo() == 1) {
                                it2.remove();
                            } else if ((next2 instanceof g) || (next2 instanceof h)) {
                                it2.remove();
                            }
                        }
                    }
                }
                if (!v.isEmpty(arrayList2)) {
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        m mVar = (m) it3.next();
                        if (mVar != null && ((mVar instanceof g) || (mVar instanceof h))) {
                            it3.remove();
                        }
                    }
                }
                arrayList.addAll(0, arrayList2);
            }
        }
    }

    private boolean g(String str, ArrayList<m> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<m> it = arrayList.iterator();
        while (it.hasNext()) {
            m next = it.next();
            if ((next instanceof bj) && str.equalsIgnoreCase(((bj) next).getTid())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<m> getDataList() {
        return this.mThreadList;
    }

    public void at(ArrayList<m> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.fsO = -1;
        this.mPn = 1;
    }

    private void l(List<m> list, List<m> list2) {
        if (!v.isEmpty(list) && !v.isEmpty(list2)) {
            list2.add(new r());
        }
    }

    public void bJn() {
        ArrayList<m> arrayList;
        int count = v.getCount(this.mThreadList) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    arrayList2.add(this.mThreadList.remove(20));
                    if (this.gHP == null || this.gHP.bEz() == null) {
                        arrayList = null;
                    } else {
                        arrayList = this.gHP.bEz().switchThreadDataToThreadCardInfo(arrayList2);
                    }
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (this.gHD != null) {
                                this.gHD.removeItem(i3 + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    public void d(m mVar) {
        if (mVar != null && this.mThreadList != null) {
            this.mThreadList.remove(mVar);
        }
    }

    public void a(c.a aVar) {
        this.gHD = aVar;
    }
}
