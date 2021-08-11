package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.k.e.n;
import c.a.o0.s.q.c2;
import c.a.p0.i3.g;
import c.a.p0.i3.h;
import c.a.p0.i3.m;
import c.a.p0.i3.q;
import c.a.p0.i3.x;
import c.a.p0.v0.e2.c;
import c.a.p0.v0.e2.k;
import c.a.p0.v0.u;
import c.a.p0.v0.w;
import c.a.p0.x0.a;
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
/* loaded from: classes7.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<n> f51254e;

    /* renamed from: f  reason: collision with root package name */
    public final FrsFragment f51255f;

    /* renamed from: g  reason: collision with root package name */
    public int f51256g;

    /* renamed from: h  reason: collision with root package name */
    public int f51257h;

    /* renamed from: i  reason: collision with root package name */
    public int f51258i;

    /* renamed from: j  reason: collision with root package name */
    public k f51259j;
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
        this.f51254e = new ArrayList<>();
        this.f51256g = 1;
        this.f51257h = -1;
        this.f51255f = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.f51259j = kVar;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51257h : invokeV.intValue;
    }

    public final void B(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f51254e.addAll(0, list);
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
                if ((next instanceof c2) && str.equalsIgnoreCase(((c2) next).q1())) {
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
            return ((nVar instanceof c2) && ((c2) nVar).p0() == 2) || nVar.getType() == q.f20148g;
        }
        return invokeL.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || ListUtils.isEmpty(this.f51254e)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = this.f51254e.iterator();
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
        this.f51254e.removeAll(arrayList);
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
        if (!(interceptable == null || interceptable.invokeL(1048582, this, nVar) == null) || nVar == null || (arrayList = this.f51254e) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f51254e.clear();
            this.f51257h = -1;
            this.f51256g = 1;
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
        if ((interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) && this.f51254e.size() == 0) {
            this.f51254e.addAll(arrayList);
        }
    }

    public void K(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void L(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.k = bVar;
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

    public void M(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.f51254e)) {
            return;
        }
        this.f51254e.addAll(0, arrayList);
    }

    public void N(ArrayList<n> arrayList) {
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
                    if (next.getType() == c2.P3) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof c2) && ((c2) next).j0() == 1) {
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
        if (!ListUtils.isEmpty(this.f51254e)) {
            Iterator<n> it2 = this.f51254e.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == c2.P3) {
                        it2.remove();
                    } else if ((next2 instanceof c2) && ((c2) next2).j0() == 1) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f51256g : invokeV.intValue;
    }

    public void setHasMore(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.f51257h = i2;
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 <= this.f51256g) {
            return;
        }
        this.f51256g = i2;
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f51258i = i2;
        }
    }

    public final void w(c2 c2Var) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, c2Var) == null) || c2Var == null || (frsFragment = this.f51255f) == null || frsFragment.getFrsViewData() == null || this.f51255f.getFrsViewData().getForum() == null) {
            return;
        }
        c2Var.y3(this.f51255f.getFrsViewData().getForum().getFirst_class());
        c2Var.h4(this.f51255f.getFrsViewData().getForum().getSecond_class());
    }

    public void x() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (count = ListUtils.getCount(this.f51254e) + 30) <= 300) {
            return;
        }
        int i2 = count - 300;
        if (this.f51254e.size() > i2 + 20) {
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.f51254e.remove(20));
                ArrayList<n> arrayList2 = null;
                FrsFragment frsFragment = this.f51255f;
                if (frsFragment != null && frsFragment.getFrsViewData() != null) {
                    arrayList2 = this.f51255f.getFrsViewData().switchThreadDataToThreadCardInfo(arrayList);
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
            if (!z3 && this.f51254e.size() == 0) {
                m mVar = FrsFragment.cacheData;
                if (mVar != null) {
                    this.f51254e.addAll(mVar.getThreadList());
                }
                FrsFragment.cacheData = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                k kVar = this.f51259j;
                if (kVar != null) {
                    kVar.a(this.f51258i, z2, 0, z, null, z3);
                }
                return this.f51254e;
            }
            synchronized (this.f51254e) {
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
                                if (next instanceof c2) {
                                    c2 c2Var = (c2) next;
                                    c2Var.M3(true);
                                    w(c2Var);
                                    if ((c2Var.P0() != null && !c2Var.i2()) || !C(c2Var.f0(), this.f51254e)) {
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
                    N(arrayList2);
                }
                if (a.d()) {
                    if (this.l != null) {
                        this.l.b(arrayList2, z2, this.f51255f.getFid());
                    }
                } else {
                    this.f51255f.getFrsViewData().addRecommendAppToThreadList(this.f51255f, true, arrayList2, this.f51254e, this.f51255f.getModelController().t0());
                }
                if (z2) {
                    if (this.f51259j != null) {
                        this.f51259j.a(this.f51258i, z2, i2, z, arrayList2, z3);
                    }
                    E();
                    I(this.f51254e, arrayList2);
                    B(arrayList2);
                    M(arrayList3);
                    F(this.f51254e, 300);
                } else {
                    this.f51254e.addAll(arrayList2);
                }
            }
            return this.f51254e;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<n> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f51254e : (ArrayList) invokeV.objValue;
    }
}
