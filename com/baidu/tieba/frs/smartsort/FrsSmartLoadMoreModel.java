package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.o.e.n;
import c.a.p0.a4.a0;
import c.a.p0.a4.g;
import c.a.p0.a4.h;
import c.a.p0.a4.s;
import c.a.p0.f1.h2.c;
import c.a.p0.f1.h2.k;
import c.a.p0.f1.u;
import c.a.p0.f1.w;
import c.a.p0.h1.a;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ThreadData;
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
import tbclient.AdMixFloor;
/* loaded from: classes5.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<n> a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsFragment f32831b;

    /* renamed from: c  reason: collision with root package name */
    public int f32832c;

    /* renamed from: d  reason: collision with root package name */
    public int f32833d;

    /* renamed from: e  reason: collision with root package name */
    public int f32834e;

    /* renamed from: f  reason: collision with root package name */
    public k f32835f;

    /* renamed from: g  reason: collision with root package name */
    public c.b f32836g;

    /* renamed from: h  reason: collision with root package name */
    public a f32837h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSmartLoadMoreModel(FrsFragment frsFragment, k kVar) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.f32832c = 1;
        this.f32833d = -1;
        this.f32831b = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.f32835f = kVar;
    }

    public ArrayList<n> A(boolean z, boolean z2, ArrayList<n> arrayList, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (!z3 && this.a.size() == 0) {
                c.a.p0.a4.n nVar = FrsFragment.b2;
                if (nVar != null) {
                    this.a.addAll(nVar.getThreadList());
                }
                FrsFragment.b2 = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                k kVar = this.f32835f;
                if (kVar != null) {
                    kVar.a(this.f32834e, z2, 0, z, null, z3);
                }
                return this.a;
            }
            synchronized (this.a) {
                ArrayList<n> arrayList2 = new ArrayList<>();
                ArrayList<n> arrayList3 = new ArrayList<>();
                Iterator<n> it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    n next = it.next();
                    if (!z4 || !(next instanceof w)) {
                        if (!(next instanceof u)) {
                            if (F(next)) {
                                arrayList3.add(next);
                            } else {
                                if (next instanceof ThreadData) {
                                    ThreadData threadData = (ThreadData) next;
                                    threadData.setIsSmartFrsThread(true);
                                    y(threadData);
                                    if ((threadData.getRecomSource() != null && !threadData.isNeedCheckRepeat()) || !E(threadData.getId(), this.a)) {
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
                    Q(arrayList2);
                }
                if (i != -1) {
                    if (i == 1) {
                        this.f32831b.f0().addRecommendAppToThreadList(this.f32831b, true, arrayList2, this.a, this.f32831b.b0().u0());
                    } else if (i != 2) {
                        if (i != 3) {
                            if (a.d()) {
                                if (this.f32837h != null) {
                                    this.f32837h.b(arrayList2, z2, this.f32831b.z());
                                }
                            } else {
                                this.f32831b.f0().addRecommendAppToThreadList(this.f32831b, true, arrayList2, this.a, this.f32831b.b0().u0());
                            }
                        } else if (!ListUtils.isEmpty(list)) {
                            int intValue = list.get(0).ad_type.intValue();
                            if (intValue == 1) {
                                this.f32831b.f0().addRecommendAppToThreadList(this.f32831b, true, arrayList2, this.a, this.f32831b.b0().u0());
                            } else if (intValue == 2 && this.f32837h != null) {
                                this.f32837h.g(arrayList2, list, z2, this.f32831b.z());
                            }
                        }
                    } else if (this.f32837h != null) {
                        this.f32837h.b(arrayList2, z2, this.f32831b.z());
                    }
                }
                if (z2) {
                    if (this.f32835f != null) {
                        this.f32835f.a(this.f32834e, z2, i2, z, arrayList2, z3);
                    }
                    G();
                    L(this.a, arrayList2);
                    D(arrayList2);
                    P(arrayList3);
                    H(this.a, 300);
                } else {
                    this.a.addAll(arrayList2);
                }
            }
            return this.a;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<n> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32833d : invokeV.intValue;
    }

    public final void D(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.addAll(0, list);
    }

    public final boolean E(String str, ArrayList<n> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, arrayList)) == null) {
            if (TextUtils.isEmpty(str) || arrayList == null) {
                return true;
            }
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if ((next instanceof ThreadData) && str.equalsIgnoreCase(((ThreadData) next).getTid())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean F(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            if (nVar instanceof a0) {
                return true;
            }
            return ((nVar instanceof ThreadData) && ((ThreadData) nVar).getIs_top() == 2) || nVar.getType() == s.f12379c;
        }
        return invokeL.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || ListUtils.isEmpty(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<n> it = this.a.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (F(next)) {
                arrayList.add(next);
            } else if (next instanceof u) {
                arrayList.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.a.removeAll(arrayList);
    }

    public final void H(ArrayList<n> arrayList, int i) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, arrayList, i) == null) || arrayList == null || (count = ListUtils.getCount(arrayList)) <= i) {
            return;
        }
        int max = Math.max(count - i, 30);
        int i2 = ((count - 20) - max) - 1;
        ListUtils.removeSubList(arrayList, i2, max + i2);
    }

    public void I(n nVar) {
        ArrayList<n> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null || (arrayList = this.a) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    public void J(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Iterator<n> it = this.a.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.a.clear();
            this.f32833d = -1;
            this.f32832c = 1;
        }
    }

    public final void L(List<n> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, list, list2) == null) || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        list2.add(new u());
    }

    public void M(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) && this.a.size() == 0) {
            this.a.addAll(arrayList);
        }
    }

    public void N(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f32837h = aVar;
        }
    }

    public void O(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.f32836g = bVar;
        }
    }

    public void P(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.a)) {
            return;
        }
        this.a.addAll(0, arrayList);
    }

    public void Q(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null) {
                    if (next.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof ThreadData) && ((ThreadData) next).getIsLive() == 1) {
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
        if (!ListUtils.isEmpty(this.a)) {
            Iterator<n> it2 = this.a.iterator();
            while (it2.hasNext()) {
                n next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it2.remove();
                    } else if ((next2 instanceof ThreadData) && ((ThreadData) next2).getIsLive() == 1) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f32832c : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setHasMore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.f32833d = i;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || i <= this.f32832c) {
            return;
        }
        this.f32832c = i;
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.f32834e = i;
        }
    }

    public final void y(ThreadData threadData) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, threadData) == null) || threadData == null || (frsFragment = this.f32831b) == null || frsFragment.f0() == null || this.f32831b.f0().getForum() == null) {
            return;
        }
        threadData.setFirstClassName(this.f32831b.f0().getForum().getFirst_class());
        threadData.setSecondClassName(this.f32831b.f0().getForum().getSecond_class());
    }

    public void z() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (count = ListUtils.getCount(this.a) + 30) <= 300) {
            return;
        }
        int i = count - 300;
        if (this.a.size() > i + 20) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<n> arrayList = new ArrayList<>();
                arrayList.add(this.a.remove(20));
                ArrayList<n> arrayList2 = null;
                FrsFragment frsFragment = this.f32831b;
                if (frsFragment != null && frsFragment.f0() != null) {
                    arrayList2 = this.f32831b.f0().switchThreadDataToThreadCardInfo(arrayList);
                }
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        c.b bVar = this.f32836g;
                        if (bVar != null) {
                            bVar.removeItem(i3 + 20);
                        }
                    }
                }
            }
        }
    }
}
