package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.an6;
import com.repackage.b9;
import com.repackage.dj8;
import com.repackage.ej8;
import com.repackage.in6;
import com.repackage.js6;
import com.repackage.kj8;
import com.repackage.pj8;
import com.repackage.sd6;
import com.repackage.ud6;
import com.repackage.uo;
import com.repackage.xj8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AdMixFloor;
/* loaded from: classes3.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<uo> a;
    public final FrsFragment b;
    public int c;
    public int d;
    public int e;
    public in6 f;
    public an6.b g;
    public js6 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSmartLoadMoreModel(FrsFragment frsFragment, in6 in6Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, in6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.c = 1;
        this.d = -1;
        this.b = frsFragment;
        setUniqueId(frsFragment.getUniqueId());
        this.f = in6Var;
    }

    public ArrayList<uo> A(boolean z, boolean z2, ArrayList<uo> arrayList, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (!z3 && this.a.size() == 0) {
                kj8 kj8Var = FrsFragment.b2;
                if (kj8Var != null) {
                    this.a.addAll(kj8Var.getThreadList());
                }
                FrsFragment.b2 = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                in6 in6Var = this.f;
                if (in6Var != null) {
                    in6Var.a(this.e, z2, 0, z, null, z3);
                }
                return this.a;
            }
            synchronized (this.a) {
                ArrayList<uo> arrayList2 = new ArrayList<>();
                ArrayList<uo> arrayList3 = new ArrayList<>();
                Iterator<uo> it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    uo next = it.next();
                    if (!z4 || !(next instanceof ud6)) {
                        if (!(next instanceof sd6)) {
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
                        this.b.g0().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.b0().u0());
                    } else if (i != 2) {
                        if (i != 3) {
                            if (js6.d()) {
                                if (this.h != null) {
                                    this.h.b(arrayList2, z2, this.b.z());
                                }
                            } else {
                                this.b.g0().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.b0().u0());
                            }
                        } else if (!ListUtils.isEmpty(list)) {
                            int intValue = list.get(0).ad_type.intValue();
                            if (intValue == 1) {
                                this.b.g0().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.b0().u0());
                            } else if (intValue == 2 && this.h != null) {
                                this.h.g(arrayList2, list, z2, this.b.z());
                            }
                        }
                    } else if (this.h != null) {
                        this.h.b(arrayList2, z2, this.b.z());
                    }
                }
                if (z2) {
                    if (this.f != null) {
                        this.f.a(this.e, z2, i2, z, arrayList2, z3);
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

    public ArrayList<uo> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : invokeV.intValue;
    }

    public final void D(List<uo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.addAll(0, list);
    }

    public final boolean E(String str, ArrayList<uo> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, arrayList)) == null) {
            if (TextUtils.isEmpty(str) || arrayList == null) {
                return true;
            }
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if ((next instanceof ThreadData) && str.equalsIgnoreCase(((ThreadData) next).getTid())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean F(uo uoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uoVar)) == null) {
            if (uoVar == null) {
                return false;
            }
            if (uoVar instanceof xj8) {
                return true;
            }
            return ((uoVar instanceof ThreadData) && ((ThreadData) uoVar).getIs_top() == 2) || uoVar.getType() == pj8.c;
        }
        return invokeL.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || ListUtils.isEmpty(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<uo> it = this.a.iterator();
        while (it.hasNext()) {
            uo next = it.next();
            if (F(next)) {
                arrayList.add(next);
            } else if (next instanceof sd6) {
                arrayList.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.a.removeAll(arrayList);
    }

    public final void H(ArrayList<uo> arrayList, int i) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, arrayList, i) == null) || arrayList == null || (count = ListUtils.getCount(arrayList)) <= i) {
            return;
        }
        int max = Math.max(count - i, 30);
        int i2 = ((count - 20) - max) - 1;
        ListUtils.removeSubList(arrayList, i2, max + i2);
    }

    public void I(uo uoVar) {
        ArrayList<uo> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uoVar) == null) || uoVar == null || (arrayList = this.a) == null) {
            return;
        }
        arrayList.remove(uoVar);
    }

    public void J(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            Iterator<uo> it = this.a.iterator();
            while (it.hasNext()) {
                uo next = it.next();
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
            this.d = -1;
            this.c = 1;
        }
    }

    public final void L(List<uo> list, List<uo> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, list, list2) == null) || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        list2.add(new sd6());
    }

    public void M(ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) && this.a.size() == 0) {
            this.a.addAll(arrayList);
        }
    }

    public void N(js6 js6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, js6Var) == null) {
            this.h = js6Var;
        }
    }

    public void O(an6.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public void P(ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.a)) {
            return;
        }
        this.a.addAll(0, arrayList);
    }

    public void Q(ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
                if (next != null) {
                    if (next.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof ThreadData) && ((ThreadData) next).getIsLive() == 1) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof dj8) || (next instanceof ej8)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        if (!ListUtils.isEmpty(this.a)) {
            Iterator<uo> it2 = this.a.iterator();
            while (it2.hasNext()) {
                uo next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it2.remove();
                    } else if ((next2 instanceof ThreadData) && ((ThreadData) next2).getIsLive() == 1) {
                        it2.remove();
                    } else if ((next2 instanceof dj8) || (next2 instanceof ej8)) {
                        it2.remove();
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList2)) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                uo uoVar = (uo) it3.next();
                if (uoVar != null && ((uoVar instanceof dj8) || (uoVar instanceof ej8))) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.c : invokeV.intValue;
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
            this.d = i;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || i <= this.c) {
            return;
        }
        this.c = i;
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.e = i;
        }
    }

    public final void y(ThreadData threadData) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, threadData) == null) || threadData == null || (frsFragment = this.b) == null || frsFragment.g0() == null || this.b.g0().getForum() == null) {
            return;
        }
        threadData.setFirstClassName(this.b.g0().getForum().getFirst_class());
        threadData.setSecondClassName(this.b.g0().getForum().getSecond_class());
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
                ArrayList<uo> arrayList = new ArrayList<>();
                arrayList.add(this.a.remove(20));
                ArrayList<uo> arrayList2 = null;
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && frsFragment.g0() != null) {
                    arrayList2 = this.b.g0().switchThreadDataToThreadCardInfo(arrayList);
                }
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        an6.b bVar = this.g;
                        if (bVar != null) {
                            bVar.removeItem(i3 + 20);
                        }
                    }
                }
            }
        }
    }
}
