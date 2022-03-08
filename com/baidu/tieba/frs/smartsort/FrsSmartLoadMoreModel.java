package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.o.e.n;
import c.a.q0.r.r.e2;
import c.a.r0.d1.h2.c;
import c.a.r0.d1.h2.k;
import c.a.r0.d1.u;
import c.a.r0.d1.w;
import c.a.r0.f1.a;
import c.a.r0.y3.a0;
import c.a.r0.y3.g;
import c.a.r0.y3.h;
import c.a.r0.y3.s;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<n> f42364e;

    /* renamed from: f  reason: collision with root package name */
    public final FrsFragment f42365f;

    /* renamed from: g  reason: collision with root package name */
    public int f42366g;

    /* renamed from: h  reason: collision with root package name */
    public int f42367h;

    /* renamed from: i  reason: collision with root package name */
    public int f42368i;

    /* renamed from: j  reason: collision with root package name */
    public k f42369j;
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
        this.f42364e = new ArrayList<>();
        this.f42366g = 1;
        this.f42367h = -1;
        this.f42365f = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.f42369j = kVar;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f42367h : invokeV.intValue;
    }

    public final void B(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f42364e.addAll(0, list);
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
                if ((next instanceof e2) && str.equalsIgnoreCase(((e2) next).w1())) {
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
            if (nVar instanceof a0) {
                return true;
            }
            return ((nVar instanceof e2) && ((e2) nVar).t0() == 2) || nVar.getType() == s.f25192g;
        }
        return invokeL.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f42364e)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = this.f42364e.iterator();
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
        this.f42364e.removeAll(arrayList);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) || nVar == null || (arrayList = this.f42364e) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    public void H(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Iterator<n> it = this.f42364e.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if ((next instanceof e2) && TextUtils.equals(str, ((e2) next).w1())) {
                    it.remove();
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f42364e.clear();
            this.f42367h = -1;
            this.f42366g = 1;
        }
    }

    public final void J(List<n> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, list, list2) == null) || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        list2.add(new u());
    }

    public void K(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) && this.f42364e.size() == 0) {
            this.f42364e.addAll(arrayList);
        }
    }

    public void L(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void M(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void N(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.f42364e)) {
            return;
        }
        this.f42364e.addAll(0, arrayList);
    }

    public void O(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null) {
                    if (next.getType() == e2.c4) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof e2) && ((e2) next).l0() == 1) {
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
        if (!ListUtils.isEmpty(this.f42364e)) {
            Iterator<n> it2 = this.f42364e.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == e2.c4) {
                        it2.remove();
                    } else if ((next2 instanceof e2) && ((e2) next2).l0() == 1) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f42366g : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setHasMore(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f42367h = i2;
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 <= this.f42366g) {
            return;
        }
        this.f42366g = i2;
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f42368i = i2;
        }
    }

    public final void w(e2 e2Var) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, e2Var) == null) || e2Var == null || (frsFragment = this.f42365f) == null || frsFragment.getFrsViewData() == null || this.f42365f.getFrsViewData().getForum() == null) {
            return;
        }
        e2Var.K3(this.f42365f.getFrsViewData().getForum().getFirst_class());
        e2Var.w4(this.f42365f.getFrsViewData().getForum().getSecond_class());
    }

    public void x() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (count = ListUtils.getCount(this.f42364e) + 30) <= 300) {
            return;
        }
        int i2 = count - 300;
        if (this.f42364e.size() > i2 + 20) {
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.f42364e.remove(20));
                ArrayList<n> arrayList2 = null;
                FrsFragment frsFragment = this.f42365f;
                if (frsFragment != null && frsFragment.getFrsViewData() != null) {
                    arrayList2 = this.f42365f.getFrsViewData().switchThreadDataToThreadCardInfo(arrayList);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (!z3 && this.f42364e.size() == 0) {
                c.a.r0.y3.n nVar = FrsFragment.cacheData;
                if (nVar != null) {
                    this.f42364e.addAll(nVar.getThreadList());
                }
                FrsFragment.cacheData = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                k kVar = this.f42369j;
                if (kVar != null) {
                    kVar.a(this.f42368i, z2, 0, z, null, z3);
                }
                return this.f42364e;
            }
            synchronized (this.f42364e) {
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
                                if (next instanceof e2) {
                                    e2 e2Var = (e2) next;
                                    e2Var.a4(true);
                                    w(e2Var);
                                    if ((e2Var.T0() != null && !e2Var.q2()) || !C(e2Var.h0(), this.f42364e)) {
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
                        this.l.b(arrayList2, z2, this.f42365f.getFid());
                    }
                } else {
                    this.f42365f.getFrsViewData().addRecommendAppToThreadList(this.f42365f, true, arrayList2, this.f42364e, this.f42365f.getModelController().s0());
                }
                if (z2) {
                    if (this.f42369j != null) {
                        this.f42369j.a(this.f42368i, z2, i2, z, arrayList2, z3);
                    }
                    E();
                    J(this.f42364e, arrayList2);
                    B(arrayList2);
                    N(arrayList3);
                    F(this.f42364e, 300);
                } else {
                    this.f42364e.addAll(arrayList2);
                }
            }
            return this.f42364e;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<n> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f42364e : (ArrayList) invokeV.objValue;
    }
}
