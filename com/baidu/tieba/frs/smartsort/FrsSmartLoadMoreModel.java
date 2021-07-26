package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.q0.h3.g;
import d.a.q0.h3.h;
import d.a.q0.h3.m;
import d.a.q0.h3.q;
import d.a.q0.h3.x;
import d.a.q0.u0.e2.c;
import d.a.q0.u0.e2.k;
import d.a.q0.u0.u;
import d.a.q0.u0.w;
import d.a.q0.w0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<n> f16069e;

    /* renamed from: f  reason: collision with root package name */
    public final FrsFragment f16070f;

    /* renamed from: g  reason: collision with root package name */
    public int f16071g;

    /* renamed from: h  reason: collision with root package name */
    public int f16072h;

    /* renamed from: i  reason: collision with root package name */
    public int f16073i;
    public k j;
    public c.b k;
    public a l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16069e = new ArrayList<>();
        this.f16071g = 1;
        this.f16072h = -1;
        this.f16070f = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.j = kVar;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16072h : invokeV.intValue;
    }

    public final void B(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f16069e.addAll(0, list);
    }

    public final boolean C(String str, ArrayList<n> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, arrayList)) == null) {
            if (TextUtils.isEmpty(str) || arrayList == null) {
                return true;
            }
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if ((next instanceof b2) && str.equalsIgnoreCase(((b2) next).o1())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean D(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            if (nVar instanceof x) {
                return true;
            }
            return ((nVar instanceof b2) && ((b2) nVar).n0() == 2) || nVar.getType() == q.f58751g;
        }
        return invokeL.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f16069e)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = this.f16069e.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (D(next)) {
                arrayList.add(next);
            } else if (next instanceof u) {
                arrayList.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.f16069e.removeAll(arrayList);
    }

    public final void F(ArrayList<n> arrayList, int i2) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, arrayList, i2) == null) || arrayList == null || (count = ListUtils.getCount(arrayList)) <= i2) {
            return;
        }
        int max = Math.max(count - i2, 30);
        int i3 = ((count - 20) - max) - 1;
        ListUtils.removeSubList(arrayList, i3, max + i3);
    }

    public void G(n nVar) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) || nVar == null || (arrayList = this.f16069e) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16069e.clear();
            this.f16072h = -1;
            this.f16071g = 1;
        }
    }

    public final void I(List<n> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2) == null) || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        list2.add(new u());
    }

    public void J(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) && this.f16069e.size() == 0) {
            this.f16069e.addAll(arrayList);
        }
    }

    public void K(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f16072h = i2;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void M(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void N(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.f16069e)) {
            return;
        }
        this.f16069e.addAll(0, arrayList);
    }

    public void O(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null) {
                    if (next.getType() == b2.N3) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof b2) && ((b2) next).h0() == 1) {
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
        if (!ListUtils.isEmpty(this.f16069e)) {
            Iterator<n> it2 = this.f16069e.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == b2.N3) {
                        it2.remove();
                    } else if ((next2 instanceof b2) && ((b2) next2).h0() == 1) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f16071g : invokeV.intValue;
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 <= this.f16071g) {
            return;
        }
        this.f16071g = i2;
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f16073i = i2;
        }
    }

    public final void w(b2 b2Var) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, b2Var) == null) || b2Var == null || (frsFragment = this.f16070f) == null || frsFragment.l0() == null || this.f16070f.l0().getForum() == null) {
            return;
        }
        b2Var.p3(this.f16070f.l0().getForum().getFirst_class());
        b2Var.Y3(this.f16070f.l0().getForum().getSecond_class());
    }

    public void x() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (count = ListUtils.getCount(this.f16069e) + 30) <= 300) {
            return;
        }
        int i2 = count - 300;
        if (this.f16069e.size() > i2 + 20) {
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.f16069e.remove(20));
                ArrayList<n> arrayList2 = null;
                FrsFragment frsFragment = this.f16070f;
                if (frsFragment != null && frsFragment.l0() != null) {
                    arrayList2 = this.f16070f.l0().switchThreadDataToThreadCardInfo(arrayList);
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

    public ArrayList<n> y(boolean z, boolean z2, ArrayList<n> arrayList, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (!z3 && this.f16069e.size() == 0) {
                m mVar = FrsFragment.b2;
                if (mVar != null) {
                    this.f16069e.addAll(mVar.getThreadList());
                }
                FrsFragment.b2 = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                k kVar = this.j;
                if (kVar != null) {
                    kVar.a(this.f16073i, z2, 0, z, null, z3);
                }
                return this.f16069e;
            }
            synchronized (this.f16069e) {
                ArrayList<n> arrayList2 = new ArrayList<>();
                ArrayList<n> arrayList3 = new ArrayList<>();
                Iterator<n> it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    n next = it.next();
                    if (!z4 || !(next instanceof w)) {
                        if (!(next instanceof u)) {
                            if (D(next)) {
                                arrayList3.add(next);
                            } else {
                                if (next instanceof b2) {
                                    b2 b2Var = (b2) next;
                                    b2Var.D3(true);
                                    w(b2Var);
                                    if ((b2Var.N0() != null && !b2Var.d2()) || !C(b2Var.d0(), this.f16069e)) {
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
                        this.l.b(arrayList2, z2, this.f16070f.A());
                    }
                } else {
                    this.f16070f.l0().addRecommendAppToThreadList(this.f16070f, true, arrayList2, this.f16069e, this.f16070f.g0().t0());
                }
                if (z2) {
                    if (this.j != null) {
                        this.j.a(this.f16073i, z2, i2, z, arrayList2, z3);
                    }
                    E();
                    I(this.f16069e, arrayList2);
                    B(arrayList2);
                    N(arrayList3);
                    F(this.f16069e, 300);
                } else {
                    this.f16069e.addAll(arrayList2);
                }
            }
            return this.f16069e;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<n> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f16069e : (ArrayList) invokeV.objValue;
    }
}
