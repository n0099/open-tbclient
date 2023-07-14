package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.aca;
import com.baidu.tieba.by7;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.gba;
import com.baidu.tieba.gr7;
import com.baidu.tieba.hba;
import com.baidu.tieba.ji7;
import com.baidu.tieba.l9;
import com.baidu.tieba.li7;
import com.baidu.tieba.nba;
import com.baidu.tieba.or7;
import com.baidu.tieba.sba;
import com.baidu.tieba.sra;
import com.baidu.tieba.yn;
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
    public final ArrayList<yn> a;
    public final FrsFragment b;
    public int c;
    public int d;
    public int e;
    public or7 f;
    public gr7.b g;
    public by7 h;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSmartLoadMoreModel(FrsFragment frsFragment, or7 or7Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, or7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
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
        this.f = or7Var;
    }

    public final void V(ThreadData threadData) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && (frsFragment = this.b) != null && frsFragment.c1() != null && this.b.c1().getForum() != null) {
            threadData.setFirstClassName(this.b.c1().getForum().getFirst_class());
            threadData.setSecondClassName(this.b.c1().getForum().getSecond_class());
        }
    }

    public void W() {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (count = ListUtils.getCount(this.a) + 30) > 300) {
            int i = count - 300;
            if (this.a.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<yn> arrayList = new ArrayList<>();
                    arrayList.add(this.a.remove(20));
                    ArrayList<yn> arrayList2 = null;
                    FrsFragment frsFragment = this.b;
                    if (frsFragment != null && frsFragment.c1() != null) {
                        arrayList2 = this.b.c1().switchThreadDataToThreadCardInfo(arrayList);
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            gr7.b bVar = this.g;
                            if (bVar != null) {
                                bVar.removeItem(i3 + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<yn> X(boolean z, boolean z2, ArrayList<yn> arrayList, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (!z3 && this.a.size() == 0) {
                nba nbaVar = FrsFragment.u2;
                if (nbaVar != null) {
                    this.a.addAll(nbaVar.getThreadList());
                }
                FrsFragment.u2 = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                or7 or7Var = this.f;
                if (or7Var != null) {
                    or7Var.a(this.e, z2, 0, z, null, z3);
                }
                return this.a;
            }
            synchronized (this.a) {
                ArrayList<yn> arrayList2 = new ArrayList<>();
                ArrayList<yn> arrayList3 = new ArrayList<>();
                Iterator<yn> it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    yn next = it.next();
                    if (!z4 || !(next instanceof li7)) {
                        if (!(next instanceof ji7)) {
                            if (c0(next)) {
                                arrayList3.add(next);
                            } else {
                                if (next instanceof ThreadData) {
                                    ThreadData threadData = (ThreadData) next;
                                    threadData.setIsSmartFrsThread(true);
                                    V(threadData);
                                    if ((threadData.getRecomSource() != null && !threadData.isNeedCheckRepeat()) || !b0(threadData.getId(), this.a)) {
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
                    n0(arrayList2);
                }
                this.b.c1().frsCurrentTabId = 1;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (by7.d()) {
                                    if (this.h != null) {
                                        this.h.b(arrayList2, z2, this.b.d0());
                                    }
                                } else {
                                    this.b.c1().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.V0().S0());
                                }
                            } else if (!ListUtils.isEmpty(list)) {
                                int intValue = list.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    this.b.c1().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.V0().S0());
                                } else if (intValue == 2 && this.h != null) {
                                    this.h.g(arrayList2, list, z2, this.b.d0());
                                }
                            }
                        } else if (this.h != null) {
                            this.h.b(arrayList2, z2, this.b.d0());
                        }
                    } else {
                        this.b.c1().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.V0().S0());
                    }
                }
                if (z2) {
                    if (this.f != null) {
                        this.f.a(this.e, z2, i2, z, arrayList2, z3);
                    }
                    d0();
                    i0(this.a, arrayList2);
                    a0(arrayList2);
                    m0(arrayList3);
                    e0(this.a, 300);
                } else {
                    this.a.addAll(arrayList2);
                }
            }
            return this.a;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<yn> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.clear();
            this.d = -1;
            this.c = 1;
        }
    }

    public final void a0(List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.addAll(0, list);
    }

    public void f0(yn ynVar) {
        ArrayList<yn> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, ynVar) == null) && ynVar != null && (arrayList = this.a) != null) {
            arrayList.remove(ynVar);
        }
    }

    public void j0(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) && this.a.size() == 0) {
            this.a.addAll(arrayList);
        }
    }

    public void k0(by7 by7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, by7Var) == null) {
            this.h = by7Var;
        }
    }

    public void l0(gr7.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public void m0(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, arrayList) == null) && !ListUtils.isEmpty(arrayList) && !ListUtils.isEmpty(this.a)) {
            this.a.addAll(0, arrayList);
        }
    }

    public void setHasMore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.d = i;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i) == null) && i > this.c) {
            this.c = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.e = i;
        }
    }

    public final boolean b0(String str, ArrayList<yn> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, arrayList)) == null) {
            if (TextUtils.isEmpty(str) || arrayList == null) {
                return true;
            }
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if ((next instanceof ThreadData) && str.equalsIgnoreCase(((ThreadData) next).getTid())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean c0(yn ynVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ynVar)) == null) {
            if (ynVar == null) {
                return false;
            }
            if (ynVar instanceof aca) {
                return true;
            }
            if ((!(ynVar instanceof ThreadData) || ((ThreadData) ynVar).getIs_top() != 2) && ynVar.getType() != sba.c && !(ynVar instanceof sra)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            Iterator<yn> it = this.a.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || ListUtils.isEmpty(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<yn> it = this.a.iterator();
        while (it.hasNext()) {
            yn next = it.next();
            if (c0(next)) {
                arrayList.add(next);
            } else if (next instanceof ji7) {
                arrayList.add(next);
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.a.removeAll(arrayList);
        }
    }

    public final void e0(ArrayList<yn> arrayList, int i) {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048586, this, arrayList, i) != null) || arrayList == null || (count = ListUtils.getCount(arrayList)) <= i) {
            return;
        }
        int max = Math.max(count - i, 30);
        int i2 = ((count - 20) - max) - 1;
        ListUtils.removeSubList(arrayList, i2, max + i2);
    }

    public final void i0(List<yn> list, List<yn> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, list, list2) == null) && !ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            list2.add(new ji7());
        }
    }

    public void n0(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, arrayList) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next != null) {
                    if (next.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof ThreadData) && ((ThreadData) next).getIsLive() == 1) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof gba) || (next instanceof hba)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        if (!ListUtils.isEmpty(this.a)) {
            Iterator<yn> it2 = this.a.iterator();
            while (it2.hasNext()) {
                yn next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it2.remove();
                    } else if ((next2 instanceof ThreadData) && ((ThreadData) next2).getIsLive() == 1) {
                        it2.remove();
                    } else if ((next2 instanceof gba) || (next2 instanceof hba)) {
                        it2.remove();
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList2)) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                yn ynVar = (yn) it3.next();
                if (ynVar != null && ((ynVar instanceof gba) || (ynVar instanceof hba))) {
                    it3.remove();
                }
            }
        }
        arrayList.addAll(0, arrayList2);
    }
}
