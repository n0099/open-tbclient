package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.n.e.n;
import c.a.s0.s.q.e2;
import c.a.t0.d1.r2.c;
import c.a.t0.d1.r2.k;
import c.a.t0.d1.u;
import c.a.t0.d1.w;
import c.a.t0.f1.a;
import c.a.t0.w3.g;
import c.a.t0.w3.h;
import c.a.t0.w3.m;
import c.a.t0.w3.r;
import c.a.t0.w3.z;
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
/* loaded from: classes12.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<n> f43694e;

    /* renamed from: f  reason: collision with root package name */
    public final FrsFragment f43695f;

    /* renamed from: g  reason: collision with root package name */
    public int f43696g;

    /* renamed from: h  reason: collision with root package name */
    public int f43697h;

    /* renamed from: i  reason: collision with root package name */
    public int f43698i;

    /* renamed from: j  reason: collision with root package name */
    public k f43699j;
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
        this.f43694e = new ArrayList<>();
        this.f43696g = 1;
        this.f43697h = -1;
        this.f43695f = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.f43699j = kVar;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43697h : invokeV.intValue;
    }

    public final void B(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f43694e.addAll(0, list);
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
                if ((next instanceof e2) && str.equalsIgnoreCase(((e2) next).v1())) {
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
            if (nVar instanceof z) {
                return true;
            }
            return ((nVar instanceof e2) && ((e2) nVar).s0() == 2) || nVar.getType() == r.f24999g;
        }
        return invokeL.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f43694e)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = this.f43694e.iterator();
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
        this.f43694e.removeAll(arrayList);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) || nVar == null || (arrayList = this.f43694e) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    public void H(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Iterator<n> it = this.f43694e.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if ((next instanceof e2) && TextUtils.equals(str, ((e2) next).v1())) {
                    it.remove();
                }
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f43694e.clear();
            this.f43697h = -1;
            this.f43696g = 1;
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
        if ((interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) && this.f43694e.size() == 0) {
            this.f43694e.addAll(arrayList);
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
        if (!(interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.f43694e)) {
            return;
        }
        this.f43694e.addAll(0, arrayList);
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
                    if (next.getType() == e2.b4) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof e2) && ((e2) next).k0() == 1) {
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
        if (!ListUtils.isEmpty(this.f43694e)) {
            Iterator<n> it2 = this.f43694e.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == e2.b4) {
                        it2.remove();
                    } else if ((next2 instanceof e2) && ((e2) next2).k0() == 1) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f43696g : invokeV.intValue;
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
            this.f43697h = i2;
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 <= this.f43696g) {
            return;
        }
        this.f43696g = i2;
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f43698i = i2;
        }
    }

    public final void w(e2 e2Var) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, e2Var) == null) || e2Var == null || (frsFragment = this.f43695f) == null || frsFragment.getFrsViewData() == null || this.f43695f.getFrsViewData().getForum() == null) {
            return;
        }
        e2Var.J3(this.f43695f.getFrsViewData().getForum().getFirst_class());
        e2Var.v4(this.f43695f.getFrsViewData().getForum().getSecond_class());
    }

    public void x() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (count = ListUtils.getCount(this.f43694e) + 30) <= 300) {
            return;
        }
        int i2 = count - 300;
        if (this.f43694e.size() > i2 + 20) {
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.f43694e.remove(20));
                ArrayList<n> arrayList2 = null;
                FrsFragment frsFragment = this.f43695f;
                if (frsFragment != null && frsFragment.getFrsViewData() != null) {
                    arrayList2 = this.f43695f.getFrsViewData().switchThreadDataToThreadCardInfo(arrayList);
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
            if (!z3 && this.f43694e.size() == 0) {
                m mVar = FrsFragment.cacheData;
                if (mVar != null) {
                    this.f43694e.addAll(mVar.getThreadList());
                }
                FrsFragment.cacheData = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                k kVar = this.f43699j;
                if (kVar != null) {
                    kVar.a(this.f43698i, z2, 0, z, null, z3);
                }
                return this.f43694e;
            }
            synchronized (this.f43694e) {
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
                                    e2Var.Z3(true);
                                    w(e2Var);
                                    if ((e2Var.S0() != null && !e2Var.p2()) || !C(e2Var.g0(), this.f43694e)) {
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
                        this.l.b(arrayList2, z2, this.f43695f.getFid());
                    }
                } else {
                    this.f43695f.getFrsViewData().addRecommendAppToThreadList(this.f43695f, true, arrayList2, this.f43694e, this.f43695f.getModelController().s0());
                }
                if (z2) {
                    if (this.f43699j != null) {
                        this.f43699j.a(this.f43698i, z2, i2, z, arrayList2, z3);
                    }
                    E();
                    J(this.f43694e, arrayList2);
                    B(arrayList2);
                    N(arrayList3);
                    F(this.f43694e, 300);
                } else {
                    this.f43694e.addAll(arrayList2);
                }
            }
            return this.f43694e;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<n> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f43694e : (ArrayList) invokeV.objValue;
    }
}
