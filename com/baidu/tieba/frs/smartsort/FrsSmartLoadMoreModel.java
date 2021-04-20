package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import d.b.c.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.d3.g;
import d.b.i0.d3.h;
import d.b.i0.d3.m;
import d.b.i0.d3.q;
import d.b.i0.q0.e2.c;
import d.b.i0.q0.e2.k;
import d.b.i0.q0.v;
import d.b.i0.q0.x;
import d.b.i0.s0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<n> f16253e;

    /* renamed from: f  reason: collision with root package name */
    public final FrsFragment f16254f;

    /* renamed from: g  reason: collision with root package name */
    public int f16255g;

    /* renamed from: h  reason: collision with root package name */
    public int f16256h;
    public int i;
    public k j;
    public c.b k;
    public a l;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.f16253e = new ArrayList<>();
        this.f16255g = 1;
        this.f16256h = -1;
        this.f16254f = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.j = kVar;
    }

    public void A() {
        if (ListUtils.isEmpty(this.f16253e)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = this.f16253e.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (z(next)) {
                arrayList.add(next);
            } else if (next instanceof v) {
                arrayList.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.f16253e.removeAll(arrayList);
    }

    public final void B(ArrayList<n> arrayList, int i) {
        int count;
        if (arrayList != null && (count = ListUtils.getCount(arrayList)) > i) {
            int max = Math.max(count - i, 30);
            int i2 = ((count - 20) - max) - 1;
            ListUtils.removeSubList(arrayList, i2, max + i2);
        }
    }

    public void C(n nVar) {
        ArrayList<n> arrayList;
        if (nVar == null || (arrayList = this.f16253e) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    public void D() {
        this.f16253e.clear();
        this.f16256h = -1;
        this.f16255g = 1;
    }

    public final void E(List<n> list, List<n> list2) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        list2.add(new v());
    }

    public void F(ArrayList<n> arrayList) {
        if (this.f16253e.size() == 0) {
            this.f16253e.addAll(arrayList);
        }
    }

    public void G(a aVar) {
        this.l = aVar;
    }

    public void H(int i) {
        this.f16256h = i;
    }

    public void I(c.b bVar) {
        this.k = bVar;
    }

    public void J(ArrayList<n> arrayList) {
        if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.f16253e)) {
            return;
        }
        this.f16253e.addAll(0, arrayList);
    }

    public void K(ArrayList<n> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null) {
                    if (next.getType() == a2.A3) {
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
        if (!ListUtils.isEmpty(this.f16253e)) {
            Iterator<n> it2 = this.f16253e.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == a2.A3) {
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
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public int getPn() {
        return this.f16255g;
    }

    public final void s(a2 a2Var) {
        FrsFragment frsFragment;
        if (a2Var == null || (frsFragment = this.f16254f) == null || frsFragment.S() == null || this.f16254f.S().getForum() == null) {
            return;
        }
        a2Var.v3(this.f16254f.S().getForum().getFirst_class());
        a2Var.d4(this.f16254f.S().getForum().getSecond_class());
    }

    public void setPn(int i) {
        if (i > this.f16255g) {
            this.f16255g = i;
        }
    }

    public void setSortType(int i) {
        this.i = i;
    }

    public void t() {
        int count = ListUtils.getCount(this.f16253e) + 30;
        if (count > 300) {
            int i = count - 300;
            if (this.f16253e.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<n> arrayList = new ArrayList<>();
                    arrayList.add(this.f16253e.remove(20));
                    ArrayList<n> arrayList2 = null;
                    FrsFragment frsFragment = this.f16254f;
                    if (frsFragment != null && frsFragment.S() != null) {
                        arrayList2 = this.f16254f.S().switchThreadDataToThreadCardInfo(arrayList);
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            c.b bVar = this.k;
                            if (bVar != null) {
                                bVar.removeItem(i3 + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<n> u(boolean z, boolean z2, ArrayList<n> arrayList, boolean z3, boolean z4) {
        if (!z3 && this.f16253e.size() == 0) {
            m mVar = FrsFragment.V1;
            if (mVar != null) {
                this.f16253e.addAll(mVar.getThreadList());
            }
            FrsFragment.V1 = null;
        }
        if (ListUtils.isEmpty(arrayList)) {
            k kVar = this.j;
            if (kVar != null) {
                kVar.a(this.i, z2, 0, z, null, z3);
            }
            return this.f16253e;
        }
        synchronized (this.f16253e) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            ArrayList<n> arrayList3 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (!z4 || !(next instanceof x)) {
                    if (!(next instanceof v)) {
                        if (z(next)) {
                            arrayList3.add(next);
                        } else {
                            if (next instanceof a2) {
                                a2 a2Var = (a2) next;
                                a2Var.J3(true);
                                s(a2Var);
                                if ((a2Var.W0() != null && !a2Var.m2()) || !y(a2Var.o0(), this.f16253e)) {
                                    arrayList2.add(next);
                                }
                            } else {
                                arrayList2.add(next);
                            }
                            i++;
                        }
                    }
                }
            }
            if (z2) {
                K(arrayList2);
            }
            if (a.d()) {
                if (this.l != null) {
                    this.l.b(arrayList2, z2, this.f16254f.V());
                }
            } else {
                this.f16254f.S().addRecommendAppToThreadList(this.f16254f, true, arrayList2, this.f16253e, this.f16254f.M().p0());
            }
            if (z2) {
                if (this.j != null) {
                    this.j.a(this.i, z2, i, z, arrayList2, z3);
                }
                A();
                E(this.f16253e, arrayList2);
                x(arrayList2);
                J(arrayList3);
                B(this.f16253e, 300);
            } else {
                this.f16253e.addAll(arrayList2);
            }
        }
        return this.f16253e;
    }

    public ArrayList<n> v() {
        return this.f16253e;
    }

    public int w() {
        return this.f16256h;
    }

    public final void x(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f16253e.addAll(0, list);
    }

    public final boolean y(String str, ArrayList<n> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof a2) && str.equalsIgnoreCase(((a2) next).w1())) {
                return true;
            }
        }
        return false;
    }

    public final boolean z(n nVar) {
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof d.b.i0.d3.x) {
            return true;
        }
        return ((nVar instanceof a2) && ((a2) nVar).x0() == 2) || nVar.getType() == q.f55016g;
    }
}
