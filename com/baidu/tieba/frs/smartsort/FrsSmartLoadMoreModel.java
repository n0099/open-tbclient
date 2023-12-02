package com.baidu.tieba.frs.smartsort;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.dva;
import com.baidu.tieba.e28;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.iva;
import com.baidu.tieba.pi;
import com.baidu.tieba.pva;
import com.baidu.tieba.qbb;
import com.baidu.tieba.rs7;
import com.baidu.tieba.ts7;
import com.baidu.tieba.w18;
import com.baidu.tieba.w88;
import com.baidu.tieba.wua;
import com.baidu.tieba.xua;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AdMixFloor;
/* loaded from: classes6.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<pi> a;
    public final FrsFragment b;
    public int c;
    public int d;
    public int e;
    public e28 f;
    public w18.b g;
    public w88 h;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSmartLoadMoreModel(FrsFragment frsFragment, e28 e28Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, e28Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
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
        this.f = e28Var;
    }

    public final void O(ThreadData threadData) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && (frsFragment = this.b) != null && frsFragment.Q1() != null && this.b.Q1().getForum() != null) {
            threadData.setFirstClassName(this.b.Q1().getForum().getFirst_class());
            threadData.setSecondClassName(this.b.Q1().getForum().getSecond_class());
        }
    }

    public void P() {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (count = ListUtils.getCount(this.a) + 30) > 300) {
            int i = count - 300;
            if (this.a.size() > i + 20) {
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<pi> arrayList = new ArrayList<>();
                    arrayList.add(this.a.remove(20));
                    ArrayList<pi> arrayList2 = null;
                    FrsFragment frsFragment = this.b;
                    if (frsFragment != null && frsFragment.Q1() != null) {
                        arrayList2 = this.b.Q1().switchThreadDataToThreadCardInfo(arrayList);
                    }
                    if (arrayList2 != null) {
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            w18.b bVar = this.g;
                            if (bVar != null) {
                                bVar.removeItem(i3 + 20);
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<pi> Q(boolean z, boolean z2, ArrayList<pi> arrayList, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (!z3 && this.a.size() == 0) {
                dva dvaVar = FrsFragment.x2;
                if (dvaVar != null) {
                    this.a.addAll(dvaVar.getThreadList());
                }
                FrsFragment.x2 = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                e28 e28Var = this.f;
                if (e28Var != null) {
                    e28Var.a(this.e, z2, 0, z, null, z3);
                }
                return this.a;
            }
            synchronized (this.a) {
                ArrayList<pi> arrayList2 = new ArrayList<>();
                ArrayList<pi> arrayList3 = new ArrayList<>();
                Iterator<pi> it = arrayList.iterator();
                int i2 = 0;
                while (true) {
                    boolean z6 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    pi next = it.next();
                    if (!z4 || !(next instanceof ts7)) {
                        if (!(next instanceof rs7)) {
                            if (V(next)) {
                                arrayList3.add(next);
                            } else {
                                if (next instanceof ThreadData) {
                                    ThreadData threadData = (ThreadData) next;
                                    threadData.setIsSmartFrsThread(true);
                                    O(threadData);
                                    if (threadData.getRecomSource() != null && !threadData.isNeedCheckRepeat()) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    ThreadData.RemoveDuplication removeDuplication = threadData.getremoveDuplicationFlag();
                                    if (removeDuplication != ThreadData.RemoveDuplication.NOT_NEED) {
                                        if (removeDuplication == ThreadData.RemoveDuplication.NEED) {
                                            z6 = false;
                                            z5 = false;
                                        } else {
                                            z6 = false;
                                        }
                                    }
                                    if (z6 || z5 || !U(threadData.getId(), this.a)) {
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
                    g0(arrayList2);
                }
                this.b.Q1().frsCurrentTabId = 1;
                if (i != -1) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (w88.d()) {
                                    if (this.h != null) {
                                        this.h.b(arrayList2, z2, this.b.C0());
                                    }
                                } else {
                                    this.b.Q1().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.J1().L0());
                                }
                            } else if (!ListUtils.isEmpty(list)) {
                                int intValue = list.get(0).ad_type.intValue();
                                if (intValue == 1) {
                                    this.b.Q1().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.J1().L0());
                                } else if (intValue == 2 && this.h != null) {
                                    this.h.g(arrayList2, list, z2, this.b.C0());
                                }
                            }
                        } else if (this.h != null) {
                            this.h.b(arrayList2, z2, this.b.C0());
                        }
                    } else {
                        this.b.Q1().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.J1().L0());
                    }
                }
                if (z2) {
                    if (this.f != null) {
                        this.f.a(this.e, z2, i2, z, arrayList2, z3);
                    }
                    W();
                    b0(this.a, arrayList2);
                    T(arrayList2);
                    f0(arrayList3);
                    X(this.a, 300);
                } else {
                    this.a.addAll(arrayList2);
                }
            }
            return this.a;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<pi> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.clear();
            this.d = -1;
            this.c = 1;
        }
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final void T(List<pi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.addAll(0, list);
    }

    public void Y(pi piVar) {
        ArrayList<pi> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, piVar) == null) && piVar != null && (arrayList = this.a) != null) {
            arrayList.remove(piVar);
        }
    }

    public void c0(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) && this.a.size() == 0) {
            this.a.addAll(arrayList);
        }
    }

    public void d0(w88 w88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, w88Var) == null) {
            this.h = w88Var;
        }
    }

    public void e0(w18.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public void f0(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, arrayList) == null) && !ListUtils.isEmpty(arrayList) && !ListUtils.isEmpty(this.a)) {
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

    public final boolean U(String str, ArrayList<pi> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, arrayList)) == null) {
            if (TextUtils.isEmpty(str) || arrayList == null) {
                return true;
            }
            Iterator<pi> it = arrayList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if ((next instanceof ThreadData) && str.equalsIgnoreCase(((ThreadData) next).getTid())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean V(pi piVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, piVar)) == null) {
            if (piVar == null) {
                return false;
            }
            if (piVar instanceof pva) {
                return true;
            }
            if ((!(piVar instanceof ThreadData) || ((ThreadData) piVar).getIs_top() != 2) && piVar.getType() != iva.c && !(piVar instanceof qbb)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void Z(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Iterator<pi> it = this.a.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || ListUtils.isEmpty(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<pi> it = this.a.iterator();
        while (it.hasNext()) {
            pi next = it.next();
            if (V(next)) {
                arrayList.add(next);
            } else if (next instanceof rs7) {
                arrayList.add(next);
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            this.a.removeAll(arrayList);
        }
    }

    public final void X(ArrayList<pi> arrayList, int i) {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048585, this, arrayList, i) != null) || arrayList == null || (count = ListUtils.getCount(arrayList)) <= i) {
            return;
        }
        int max = Math.max(count - i, 30);
        int i2 = ((count - 20) - max) - 1;
        ListUtils.removeSubList(arrayList, i2, max + i2);
    }

    public final void b0(List<pi> list, List<pi> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, list, list2) == null) && !ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
            list2.add(new rs7());
        }
    }

    public void g0(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, arrayList) != null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<pi> it = arrayList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if (next != null) {
                    if (next.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof ThreadData) && ((ThreadData) next).getIsLive() == 1) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof wua) || (next instanceof xua)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        if (!ListUtils.isEmpty(this.a)) {
            Iterator<pi> it2 = this.a.iterator();
            while (it2.hasNext()) {
                pi next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it2.remove();
                    } else if ((next2 instanceof ThreadData) && ((ThreadData) next2).getIsLive() == 1) {
                        it2.remove();
                    } else if ((next2 instanceof wua) || (next2 instanceof xua)) {
                        it2.remove();
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList2)) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                pi piVar = (pi) it3.next();
                if (piVar != null && ((piVar instanceof wua) || (piVar instanceof xua))) {
                    it3.remove();
                }
            }
        }
        arrayList.addAll(0, arrayList2);
    }
}
