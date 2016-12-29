package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.d.t;
import com.baidu.tieba.tbadkCore.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.e<FrsActivity> {
    private int bId;
    private t byZ;
    private final FrsActivity bzH;
    private int mPn;
    private int mSortType;
    private final ArrayList<v> mThreadList;

    public c(FrsActivity frsActivity, t tVar) {
        super(frsActivity.getPageContext());
        this.mThreadList = new ArrayList<>();
        this.mPn = 1;
        this.bId = -1;
        this.bzH = frsActivity;
        this.byZ = tVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void setSortType(int i) {
        this.mSortType = i;
    }

    public int Wp() {
        return this.bId;
    }

    public void setHasMore(int i) {
        this.bId = i;
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
        int i = 0;
        if (x.t(arrayList)) {
            if (this.byZ != null) {
                this.byZ.a(this.mSortType, z2, 0, z, null);
            }
            return this.mThreadList;
        }
        synchronized (this.mThreadList) {
            ArrayList<v> arrayList2 = new ArrayList<>();
            ArrayList<v> arrayList3 = new ArrayList<>();
            Iterator<v> it = arrayList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (!(next instanceof bl)) {
                    if (d(next)) {
                        arrayList3.add(next);
                    } else if (next instanceof bg) {
                        bg bgVar = (bg) next;
                        bgVar.at(true);
                        if (!e(bgVar.getId(), this.mThreadList)) {
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
                b(arrayList2, this.mThreadList);
            }
            this.bzH.WF().a(this.bzH.getPageContext().getPageActivity(), arrayList2, this.mThreadList, this.bzH.Wh().aaY());
            if (z2) {
                I(this.mThreadList);
                if (this.byZ != null) {
                    this.byZ.a(this.mSortType, z2, i, z, arrayList2);
                }
                g(this.mThreadList, arrayList2);
                au(arrayList2);
                J(arrayList3);
            } else {
                this.mThreadList.addAll(arrayList2);
            }
            a(this.mThreadList, z2, 300);
        }
        return this.mThreadList;
    }

    private void au(List<v> list) {
        if (!x.t(list)) {
            this.mThreadList.addAll(0, list);
        }
    }

    private boolean d(v vVar) {
        if (vVar == null) {
            return false;
        }
        if (vVar instanceof z) {
            return true;
        }
        return (vVar instanceof bg) && ((bg) vVar).rA() == 2;
    }

    private void a(ArrayList<v> arrayList, boolean z, int i) {
        int s;
        int i2;
        if (arrayList != null && (s = x.s(arrayList)) > i) {
            int max = Math.max(s - i, 30);
            if (z) {
                i2 = ((s - 20) - max) - 1;
            } else {
                i2 = 20;
            }
            x.b(arrayList, i2, max + i2);
        }
    }

    public void I(ArrayList<v> arrayList) {
        if (!x.t(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<v> it = arrayList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (d(next)) {
                    arrayList2.add(next);
                } else if (next instanceof bl) {
                    arrayList2.add(next);
                }
            }
            if (!x.t(arrayList2)) {
                this.mThreadList.removeAll(arrayList2);
            }
        }
    }

    public void J(ArrayList<v> arrayList) {
        if (!x.t(arrayList)) {
            this.mThreadList.addAll(0, arrayList);
        }
    }

    public void b(ArrayList<v> arrayList, ArrayList<v> arrayList2) {
        if (!x.t(arrayList)) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<v> it = arrayList.iterator();
            while (it.hasNext()) {
                v next = it.next();
                if (next != null) {
                    if (next.getType() == bg.Uu) {
                        arrayList3.add(next);
                    } else if ((next instanceof bg) && ((bg) next).rC() == 1) {
                        arrayList4.add(next);
                    }
                }
            }
            if (!x.t(arrayList2)) {
                Iterator<v> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    v next2 = it2.next();
                    if (next2 != null) {
                        if (next2.getType() == bg.Uu) {
                            arrayList3.add(next2);
                        } else if ((next2 instanceof bg) && ((bg) next2).rC() == 1) {
                            arrayList4.add(next2);
                        }
                    }
                }
            }
            if (!x.t(arrayList4)) {
                if (!x.t(arrayList2)) {
                    arrayList2.removeAll(arrayList4);
                }
                arrayList.removeAll(arrayList4);
                arrayList.addAll(0, arrayList4);
            }
            if (!x.t(arrayList3)) {
                if (!x.t(arrayList2)) {
                    arrayList2.removeAll(arrayList3);
                }
                arrayList.removeAll(arrayList3);
                arrayList.addAll(0, arrayList3);
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
            if ((next instanceof bg) && str.equalsIgnoreCase(((bg) next).getTid())) {
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
        this.bId = -1;
        this.mPn = 1;
    }

    private void g(List<v> list, List<v> list2) {
        if (!x.t(list) && !x.t(list2)) {
            long iH = a.abf().iH(this.bzH.getForumName());
            bl blVar = new bl();
            if (iH > 0) {
                blVar.aT(iH);
            } else {
                blVar.aT(System.currentTimeMillis());
            }
            list2.add(blVar);
            a.abf().i(this.bzH.getForumName(), System.currentTimeMillis());
        }
    }
}
