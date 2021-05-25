package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import d.a.c.j.e.n;
import d.a.m0.r.q.a2;
import d.a.n0.e3.g;
import d.a.n0.e3.h;
import d.a.n0.e3.m;
import d.a.n0.e3.q;
import d.a.n0.r0.e2.c;
import d.a.n0.r0.e2.k;
import d.a.n0.r0.v;
import d.a.n0.r0.x;
import d.a.n0.t0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<n> f15694e;

    /* renamed from: f  reason: collision with root package name */
    public final FrsFragment f15695f;

    /* renamed from: g  reason: collision with root package name */
    public int f15696g;

    /* renamed from: h  reason: collision with root package name */
    public int f15697h;

    /* renamed from: i  reason: collision with root package name */
    public int f15698i;
    public k j;
    public c.b k;
    public a l;

    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        this.f15694e = new ArrayList<>();
        this.f15696g = 1;
        this.f15697h = -1;
        this.f15695f = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.j = kVar;
    }

    public void A() {
        if (ListUtils.isEmpty(this.f15694e)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = this.f15694e.iterator();
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
        this.f15694e.removeAll(arrayList);
    }

    public final void B(ArrayList<n> arrayList, int i2) {
        int count;
        if (arrayList != null && (count = ListUtils.getCount(arrayList)) > i2) {
            int max = Math.max(count - i2, 30);
            int i3 = ((count - 20) - max) - 1;
            ListUtils.removeSubList(arrayList, i3, max + i3);
        }
    }

    public void C(n nVar) {
        ArrayList<n> arrayList;
        if (nVar == null || (arrayList = this.f15694e) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    public void D() {
        this.f15694e.clear();
        this.f15697h = -1;
        this.f15696g = 1;
    }

    public final void E(List<n> list, List<n> list2) {
        if (ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        list2.add(new v());
    }

    public void F(ArrayList<n> arrayList) {
        if (this.f15694e.size() == 0) {
            this.f15694e.addAll(arrayList);
        }
    }

    public void G(a aVar) {
        this.l = aVar;
    }

    public void H(int i2) {
        this.f15697h = i2;
    }

    public void I(c.b bVar) {
        this.k = bVar;
    }

    public void J(ArrayList<n> arrayList) {
        if (ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.f15694e)) {
            return;
        }
        this.f15694e.addAll(0, arrayList);
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
                    if (next.getType() == a2.C3) {
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
        if (!ListUtils.isEmpty(this.f15694e)) {
            Iterator<n> it2 = this.f15694e.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == a2.C3) {
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
        return this.f15696g;
    }

    public final void s(a2 a2Var) {
        FrsFragment frsFragment;
        if (a2Var == null || (frsFragment = this.f15695f) == null || frsFragment.g0() == null || this.f15695f.g0().getForum() == null) {
            return;
        }
        a2Var.y3(this.f15695f.g0().getForum().getFirst_class());
        a2Var.g4(this.f15695f.g0().getForum().getSecond_class());
    }

    public void setPn(int i2) {
        if (i2 > this.f15696g) {
            this.f15696g = i2;
        }
    }

    public void setSortType(int i2) {
        this.f15698i = i2;
    }

    public void t() {
        int count = ListUtils.getCount(this.f15694e) + 30;
        if (count > 300) {
            int i2 = count - 300;
            if (this.f15694e.size() > i2 + 20) {
                for (int i3 = 0; i3 < i2; i3++) {
                    ArrayList<n> arrayList = new ArrayList<>();
                    arrayList.add(this.f15694e.remove(20));
                    ArrayList<n> arrayList2 = null;
                    FrsFragment frsFragment = this.f15695f;
                    if (frsFragment != null && frsFragment.g0() != null) {
                        arrayList2 = this.f15695f.g0().switchThreadDataToThreadCardInfo(arrayList);
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

    public ArrayList<n> u(boolean z, boolean z2, ArrayList<n> arrayList, boolean z3, boolean z4) {
        if (!z3 && this.f15694e.size() == 0) {
            m mVar = FrsFragment.V1;
            if (mVar != null) {
                this.f15694e.addAll(mVar.getThreadList());
            }
            FrsFragment.V1 = null;
        }
        if (ListUtils.isEmpty(arrayList)) {
            k kVar = this.j;
            if (kVar != null) {
                kVar.a(this.f15698i, z2, 0, z, null, z3);
            }
            return this.f15694e;
        }
        synchronized (this.f15694e) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            ArrayList<n> arrayList3 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (!z4 || !(next instanceof x)) {
                    if (!(next instanceof v)) {
                        if (z(next)) {
                            arrayList3.add(next);
                        } else {
                            if (next instanceof a2) {
                                a2 a2Var = (a2) next;
                                a2Var.M3(true);
                                s(a2Var);
                                if ((a2Var.X0() != null && !a2Var.o2()) || !y(a2Var.o0(), this.f15694e)) {
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
                K(arrayList2);
            }
            if (a.d()) {
                if (this.l != null) {
                    this.l.b(arrayList2, z2, this.f15695f.F());
                }
            } else {
                this.f15695f.g0().addRecommendAppToThreadList(this.f15695f, true, arrayList2, this.f15694e, this.f15695f.b0().p0());
            }
            if (z2) {
                if (this.j != null) {
                    this.j.a(this.f15698i, z2, i2, z, arrayList2, z3);
                }
                A();
                E(this.f15694e, arrayList2);
                x(arrayList2);
                J(arrayList3);
                B(this.f15694e, 300);
            } else {
                this.f15694e.addAll(arrayList2);
            }
        }
        return this.f15694e;
    }

    public ArrayList<n> v() {
        return this.f15694e;
    }

    public int w() {
        return this.f15697h;
    }

    public final void x(List<n> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f15694e.addAll(0, list);
    }

    public final boolean y(String str, ArrayList<n> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return true;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if ((next instanceof a2) && str.equalsIgnoreCase(((a2) next).y1())) {
                return true;
            }
        }
        return false;
    }

    public final boolean z(n nVar) {
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof d.a.n0.e3.x) {
            return true;
        }
        return ((nVar instanceof a2) && ((a2) nVar).y0() == 2) || nVar.getType() == q.f54201g;
    }
}
