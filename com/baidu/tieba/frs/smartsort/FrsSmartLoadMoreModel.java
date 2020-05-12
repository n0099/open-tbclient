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
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private int fXo;
    private k gZM;
    private c.a hrc;
    private final FrsFragment hro;
    private int mPn;
    private int mSortType;
    private final ArrayList<m> mThreadList;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.fXo = -1;
        this.hro = frsFragment;
        setUniqueId(this.hro.getUniqueId());
        this.gZM = kVar;
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

    public int bOx() {
        return this.fXo;
    }

    public void setHasMore(int i) {
        this.fXo = i;
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
            if (FrsFragment.gYz != null) {
                this.mThreadList.addAll(FrsFragment.gYz.getThreadList());
            }
            FrsFragment.gYz = null;
        }
        if (v.isEmpty(arrayList)) {
            if (this.gZM != null) {
                this.gZM.a(this.mSortType, z2, 0, z, null, z3);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            if (z2) {
                bUo();
            }
            ArrayList<m> arrayList2 = new ArrayList<>();
            ArrayList<m> arrayList3 = new ArrayList<>();
            Iterator<m> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                m next = it.next();
                if (!z4 || !(next instanceof u)) {
                    if (!(next instanceof t)) {
                        if (e(next)) {
                            arrayList3.add(next);
                        } else if (next instanceof bj) {
                            bj bjVar = (bj) next;
                            bjVar.gz(true);
                            aw(bjVar);
                            if ((bjVar.aLV() == null || bjVar.aKZ()) && g(bjVar.getId(), this.mThreadList)) {
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
                au(arrayList2);
            }
            this.hro.bOX().addRecommendAppToThreadList(this.hro, true, arrayList2, this.mThreadList, this.hro.bOr().bUc());
            if (z2) {
                if (this.gZM != null) {
                    this.gZM.a(this.mSortType, z2, i2, z, arrayList2, z3);
                }
                bUn();
                l(this.mThreadList, arrayList2);
                cB(arrayList2);
                at(arrayList3);
                a(this.mThreadList, 300);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
        }
        return this.mThreadList;
    }

    private void aw(bj bjVar) {
        if (bjVar != null && this.hro != null && this.hro.bOX() != null && this.hro.bOX().getForum() != null) {
            bjVar.ub(this.hro.bOX().getForum().getFirst_class());
            bjVar.uc(this.hro.bOX().getForum().getSecond_class());
        }
    }

    private void cB(List<m> list) {
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
        if ((!(mVar instanceof bj) || ((bj) mVar).aKx() != 2) && mVar.getType() != o.kRg) {
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

    public void bUn() {
        if (!v.isEmpty(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<m> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof t) {
                    arrayList.add(next);
                }
            }
            if (!v.isEmpty(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void bUo() {
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
                if ((mVar instanceof bj) && ((bj) mVar).aKG()) {
                    break;
                }
                i2 = i + 1;
            }
            if (i >= 0) {
                this.mThreadList.remove(i);
            }
        }
    }

    public void at(ArrayList<m> arrayList) {
        if (!v.isEmpty(arrayList) && !v.isEmpty(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void au(ArrayList<m> arrayList) {
        if (!v.isEmpty(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!v.isEmpty(arrayList)) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if (next != null) {
                        if (next.getType() == bj.dsF) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bj) && ((bj) next).aKz() == 1) {
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
                            if (next2.getType() == bj.dsF) {
                                it2.remove();
                            } else if ((next2 instanceof bj) && ((bj) next2).aKz() == 1) {
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

    public void av(ArrayList<m> arrayList) {
        if (this.mThreadList.size() == 0) {
            this.mThreadList.addAll(arrayList);
        }
    }

    public void resetData() {
        this.mThreadList.clear();
        this.fXo = -1;
        this.mPn = 1;
    }

    private void l(List<m> list, List<m> list2) {
        if (!v.isEmpty(list) && !v.isEmpty(list2)) {
            list2.add(new t());
        }
    }

    public void bTJ() {
        ArrayList<m> arrayList;
        int count = v.getCount(this.mThreadList) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.mThreadList.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    arrayList2.add(this.mThreadList.remove(20));
                    if (this.hro == null || this.hro.bOX() == null) {
                        arrayList = null;
                    } else {
                        arrayList = this.hro.bOX().switchThreadDataToThreadCardInfo(arrayList2);
                    }
                    if (arrayList != null) {
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            if (this.hrc != null) {
                                this.hrc.removeItem(i3 + 20);
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
        this.hrc = aVar;
    }
}
