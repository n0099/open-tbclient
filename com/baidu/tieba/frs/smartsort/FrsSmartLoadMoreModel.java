package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.mc.x;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private final r bNK;
    private x bPd;
    private int blB;
    private int bxg;
    private int mSortType;
    private final ArrayList<v> mThreadList;

    public FrsSmartLoadMoreModel(r rVar, x xVar) {
        super(rVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.bxg = 1;
        this.blB = -1;
        this.bNK = rVar;
        setUniqueId(this.bNK.getUniqueId());
        this.bPd = xVar;
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

    public int Za() {
        return this.blB;
    }

    public void setHasMore(int i) {
        this.blB = i;
    }

    public int getPn() {
        return this.bxg;
    }

    public void setPn(int i) {
        if (i > this.bxg) {
            this.bxg = i;
        }
    }

    public ArrayList<v> a(boolean z, boolean z2, ArrayList<v> arrayList) {
        if (com.baidu.tbadk.core.util.x.r(arrayList)) {
            if (this.bPd != null) {
                this.bPd.a(this.mSortType, z2, 0, z, null);
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
                if (!(next instanceof bf)) {
                    if (d(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bk) {
                        bk bkVar = (bk) next;
                        bkVar.ar(true);
                        if ((bkVar.sF() != null && !bkVar.rV()) || !e(bkVar.getId(), this.mThreadList)) {
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
            this.bNK.Zq().a(this.bNK.getPageContext(), true, arrayList2, this.mThreadList, this.bNK.YU().aca());
            if (z2) {
                if (this.bPd != null) {
                    this.bPd.a(this.mSortType, z2, i, z, arrayList2);
                }
                acl();
                g(this.mThreadList, arrayList2);
                ar(arrayList2);
                J(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void ar(List<v> list) {
        if (!com.baidu.tbadk.core.util.x.r(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean d(v vVar) {
        if (vVar == null) {
            return false;
        }
        if (vVar instanceof u) {
            return true;
        }
        return (vVar instanceof bk) && ((bk) vVar).ru() == 2;
    }

    private void a(ArrayList<v> arrayList, boolean z, int i) {
        int q;
        int i2;
        if (arrayList != null && (q = com.baidu.tbadk.core.util.x.q(arrayList)) > i) {
            int max = Math.max(q - i, 30);
            if (z) {
                i2 = ((q - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            com.baidu.tbadk.core.util.x.b(arrayList, i2, max + i2);
        }
    }

    public void acl() {
        if (!com.baidu.tbadk.core.util.x.r(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<v> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (d(next)) {
                    arrayList.add(next);
                } else if (next instanceof bf) {
                    arrayList.add(next);
                }
            }
            if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void J(ArrayList<v> arrayList) {
        if (!com.baidu.tbadk.core.util.x.r(arrayList) && !com.baidu.tbadk.core.util.x.r(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void K(ArrayList<v> arrayList) {
        if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
                Iterator<v> it = arrayList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next != null) {
                        if (next.getType() == bk.YC) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bk) && ((bk) next).rw() == 1) {
                            it.remove();
                            arrayList2.add(next);
                        }
                    }
                }
            }
            if (!com.baidu.tbadk.core.util.x.r(arrayList2)) {
                if (!com.baidu.tbadk.core.util.x.r(this.mThreadList)) {
                    Iterator<v> it2 = this.mThreadList.iterator();
                    while (it2.hasNext()) {
                        v next2 = it2.next();
                        if (next2 != null) {
                            if (next2.getType() == bk.YC) {
                                it2.remove();
                            } else if ((next2 instanceof bk) && ((bk) next2).rw() == 1) {
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
            if ((next instanceof bk) && str.equalsIgnoreCase(((bk) next).getTid())) {
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
        this.blB = -1;
        this.bxg = 1;
    }

    private void g(List<v> list, List<v> list2) {
        if (!com.baidu.tbadk.core.util.x.r(list) && !com.baidu.tbadk.core.util.x.r(list2)) {
            long iY = a.ach().iY(this.bNK.getForumName());
            bf bfVar = new bf();
            if (iY > 0) {
                bfVar.aO(iY);
            } else {
                bfVar.aO(System.currentTimeMillis());
            }
            list2.add(bfVar);
            a.ach().i(this.bNK.getForumName(), System.currentTimeMillis());
        }
    }
}
