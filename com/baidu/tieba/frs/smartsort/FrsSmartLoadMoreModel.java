package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.e3.g;
import d.a.n0.e3.h;
import d.a.n0.e3.m;
import d.a.n0.e3.q;
import d.a.n0.e3.x;
import d.a.n0.r0.e2.c;
import d.a.n0.r0.e2.k;
import d.a.n0.r0.v;
import d.a.n0.t0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<n> f15756e;

    /* renamed from: f  reason: collision with root package name */
    public final FrsFragment f15757f;

    /* renamed from: g  reason: collision with root package name */
    public int f15758g;

    /* renamed from: h  reason: collision with root package name */
    public int f15759h;

    /* renamed from: i  reason: collision with root package name */
    public int f15760i;
    public k j;
    public c.b k;
    public a l;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.f15756e = new ArrayList<>();
        this.f15758g = 1;
        this.f15759h = -1;
        this.f15757f = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.j = kVar;
    }

    public int A() {
        return this.f15759h;
    }

    public final void B(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f15756e.addAll(0, list);
    }

    public final boolean C(String str, ArrayList<n> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof a2) && str.equalsIgnoreCase(((a2) next).z1())) {
                return true;
            }
        }
        return false;
    }

    public final boolean D(n nVar) {
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof x) {
            return true;
        }
        return ((nVar instanceof a2) && ((a2) nVar).y0() == 2) || nVar.getType() == q.f57890g;
    }

    public void E() {
        if (ListUtils.isEmpty(this.f15756e)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = this.f15756e.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (D(next)) {
                arrayList.add(next);
            } else if (next instanceof v) {
                arrayList.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.f15756e.removeAll(arrayList);
    }

    public final void F(ArrayList<n> arrayList, int i2) {
        int count;
        if (arrayList != null && (count = ListUtils.getCount(arrayList)) > i2) {
            int max = Math.max(count - i2, 30);
            int i3 = ((count - 20) - max) - 1;
            ListUtils.removeSubList(arrayList, i3, max + i3);
        }
    }

    public void G(n nVar) {
        ArrayList<n> arrayList;
        if (nVar == null || (arrayList = this.f15756e) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    public void H() {
        this.f15756e.clear();
        this.f15759h = -1;
        this.f15758g = 1;
    }

    public final void I(List<n> list, List<n> list2) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        list2.add(new v());
    }

    public void J(ArrayList<n> arrayList) {
        if (this.f15756e.size() == 0) {
            this.f15756e.addAll(arrayList);
        }
    }

    public void K(a aVar) {
        this.l = aVar;
    }

    public void L(int i2) {
        this.f15759h = i2;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(c.b bVar) {
        this.k = bVar;
    }

    public void N(ArrayList<n> arrayList) {
        if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.f15756e)) {
            return;
        }
        this.f15756e.addAll(0, arrayList);
    }

    public void O(ArrayList<n> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null) {
                    if (next.getType() == a2.F3) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof a2) && ((a2) next).s0() == 1) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof g) || (next instanceof h)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f15756e)) {
            Iterator<n> it2 = this.f15756e.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == a2.F3) {
                        it2.remove();
                    } else if ((next2 instanceof a2) && ((a2) next2).s0() == 1) {
                        it2.remove();
                    } else if ((next2 instanceof g) || (next2 instanceof h)) {
                        it2.remove();
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList2)) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                n nVar = (n) it3.next();
                if (nVar != null && ((nVar instanceof g) || (nVar instanceof h))) {
                    it3.remove();
                }
            }
        }
        arrayList.addAll(0, arrayList2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public int getPn() {
        return this.f15758g;
    }

    public void setPn(int i2) {
        if (i2 > this.f15758g) {
            this.f15758g = i2;
        }
    }

    public void setSortType(int i2) {
        this.f15760i = i2;
    }

    public final void w(a2 a2Var) {
        FrsFragment frsFragment;
        if (a2Var == null || (frsFragment = this.f15757f) == null || frsFragment.j0() == null || this.f15757f.j0().getForum() == null) {
            return;
        }
        a2Var.z3(this.f15757f.j0().getForum().getFirst_class());
        a2Var.h4(this.f15757f.j0().getForum().getSecond_class());
    }

    public void x() {
        int count = ListUtils.getCount(this.f15756e) + 30;
        if (count > 300) {
            int i2 = count - 300;
            if (this.f15756e.size() > i2 + 20) {
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<n> arrayList = new ArrayList<>();
                    arrayList.add(this.f15756e.remove(20));
                    ArrayList<n> arrayList2 = null;
                    FrsFragment frsFragment = this.f15757f;
                    if (frsFragment != null && frsFragment.j0() != null) {
                        arrayList2 = this.f15757f.j0().switchThreadDataToThreadCardInfo(arrayList);
                    }
                    if (arrayList2 != null) {
                        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                            c.b bVar = this.k;
                            if (bVar != null) {
                                bVar.removeItem(i4 + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<n> y(boolean z, boolean z2, ArrayList<n> arrayList, boolean z3, boolean z4) {
        if (!z3 && this.f15756e.size() == 0) {
            m mVar = FrsFragment.V1;
            if (mVar != null) {
                this.f15756e.addAll(mVar.getThreadList());
            }
            FrsFragment.V1 = null;
        }
        if (ListUtils.isEmpty(arrayList)) {
            k kVar = this.j;
            if (kVar != null) {
                kVar.a(this.f15760i, z2, 0, z, null, z3);
            }
            return this.f15756e;
        }
        synchronized (this.f15756e) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            ArrayList<n> arrayList3 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (!z4 || !(next instanceof d.a.n0.r0.x)) {
                    if (!(next instanceof v)) {
                        if (D(next)) {
                            arrayList3.add(next);
                        } else {
                            if (next instanceof a2) {
                                a2 a2Var = (a2) next;
                                a2Var.N3(true);
                                w(a2Var);
                                if ((a2Var.Y0() != null && !a2Var.p2()) || !C(a2Var.o0(), this.f15756e)) {
                                    arrayList2.add(next);
                                }
                            } else {
                                arrayList2.add(next);
                            }
                            i2++;
                        }
                    }
                }
            }
            if (z2) {
                O(arrayList2);
            }
            if (a.d()) {
                if (this.l != null) {
                    this.l.b(arrayList2, z2, this.f15757f.G());
                }
            } else {
                this.f15757f.j0().addRecommendAppToThreadList(this.f15757f, true, arrayList2, this.f15756e, this.f15757f.e0().t0());
            }
            if (z2) {
                if (this.j != null) {
                    this.j.a(this.f15760i, z2, i2, z, arrayList2, z3);
                }
                E();
                I(this.f15756e, arrayList2);
                B(arrayList2);
                N(arrayList3);
                F(this.f15756e, 300);
            } else {
                this.f15756e.addAll(arrayList2);
            }
        }
        return this.f15756e;
    }

    public ArrayList<n> z() {
        return this.f15756e;
    }
}
