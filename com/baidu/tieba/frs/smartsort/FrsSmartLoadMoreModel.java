package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.mc.x;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    private final r bTw;
    private x bUR;
    private int bmI;
    private int mPn;
    private int mSortType;
    private final ArrayList<v> mThreadList;

    public FrsSmartLoadMoreModel(r rVar, x xVar) {
        super(rVar.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bmI = -1;
        this.bTw = rVar;
        setUniqueId(this.bTw.getUniqueId());
        this.bUR = xVar;
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

    public int aae() {
        return this.bmI;
    }

    public void setHasMore(int i) {
        this.bmI = i;
    }

    public int getPn() {
        return this.mPn;
    }

    public void setPn(int i) {
        if (i > this.mPn) {
            this.mPn = i;
        }
    }

    public ArrayList<v> a(boolean z, boolean z2, ArrayList<v> arrayList) {
        if (com.baidu.tbadk.core.util.x.r(arrayList)) {
            if (this.bUR != null) {
                this.bUR.a(this.mSortType, z2, 0, z, null);
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
                if (!(next instanceof bg)) {
                    if (e(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bl) {
                        bl blVar = (bl) next;
                        blVar.aq(true);
                        if ((blVar.sD() != null && !blVar.rR()) || !e(blVar.getId(), this.mThreadList)) {
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
                L(arrayList2);
            }
            this.bTw.aau().a(this.bTw, true, arrayList2, this.mThreadList, this.bTw.ZY().ade());
            if (z2) {
                if (this.bUR != null) {
                    this.bUR.a(this.mSortType, z2, i, z, arrayList2);
                }
                adp();
                i(this.mThreadList, arrayList2);
                ar(arrayList2);
                K(arrayList3);
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

    private boolean e(v vVar) {
        if (vVar == null) {
            return false;
        }
        if (vVar instanceof u) {
            return true;
        }
        return (vVar instanceof bl) && ((bl) vVar).rq() == 2;
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

    public void adp() {
        if (!com.baidu.tbadk.core.util.x.r(this.mThreadList)) {
            ArrayList arrayList = new ArrayList();
            Iterator<v> it = this.mThreadList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (e(next)) {
                    arrayList.add(next);
                } else if (next instanceof bg) {
                    arrayList.add(next);
                }
            }
            if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
                this.mThreadList.removeAll(arrayList);
            }
        }
    }

    public void K(ArrayList<v> arrayList) {
        if (!com.baidu.tbadk.core.util.x.r(arrayList) && !com.baidu.tbadk.core.util.x.r(this.mThreadList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void L(ArrayList<v> arrayList) {
        if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
                Iterator<v> it = arrayList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next != null) {
                        if (next.getType() == bl.Yy) {
                            it.remove();
                            arrayList2.add(next);
                        } else if ((next instanceof bl) && ((bl) next).rs() == 1) {
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
                            if (next2.getType() == bl.Yy) {
                                it2.remove();
                            } else if ((next2 instanceof bl) && ((bl) next2).rs() == 1) {
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
            if ((next instanceof bl) && str.equalsIgnoreCase(((bl) next).getTid())) {
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
        this.bmI = -1;
        this.mPn = 1;
    }

    private void i(List<v> list, List<v> list2) {
        if (!com.baidu.tbadk.core.util.x.r(list) && !com.baidu.tbadk.core.util.x.r(list2)) {
            long jg = a.adl().jg(this.bTw.getForumName());
            bg bgVar = new bg();
            if (jg > 0) {
                bgVar.aR(jg);
            } else {
                bgVar.aR(System.currentTimeMillis());
            }
            list2.add(bgVar);
            a.adl().h(this.bTw.getForumName(), System.currentTimeMillis());
        }
    }
}
