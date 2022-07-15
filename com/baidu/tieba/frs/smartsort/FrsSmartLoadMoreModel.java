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
import com.repackage.d9;
import com.repackage.dh8;
import com.repackage.gr6;
import com.repackage.ih8;
import com.repackage.jm6;
import com.repackage.md6;
import com.repackage.nn;
import com.repackage.od6;
import com.repackage.qh8;
import com.repackage.rm6;
import com.repackage.wg8;
import com.repackage.xg8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.AdMixFloor;
/* loaded from: classes3.dex */
public class FrsSmartLoadMoreModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<nn> a;
    public final FrsFragment b;
    public int c;
    public int d;
    public int e;
    public rm6 f;
    public jm6.b g;
    public gr6 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsSmartLoadMoreModel(FrsFragment frsFragment, rm6 rm6Var) {
        super(frsFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, rm6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
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
        this.f = rm6Var;
    }

    public final void A(ThreadData threadData) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || (frsFragment = this.b) == null || frsFragment.Q0() == null || this.b.Q0().getForum() == null) {
            return;
        }
        threadData.setFirstClassName(this.b.Q0().getForum().getFirst_class());
        threadData.setSecondClassName(this.b.Q0().getForum().getSecond_class());
    }

    public void B() {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (count = ListUtils.getCount(this.a) + 30) <= 300) {
            return;
        }
        int i = count - 300;
        if (this.a.size() > i + 20) {
            for (int i2 = 0; i2 < i; i2++) {
                ArrayList<nn> arrayList = new ArrayList<>();
                arrayList.add(this.a.remove(20));
                ArrayList<nn> arrayList2 = null;
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && frsFragment.Q0() != null) {
                    arrayList2 = this.b.Q0().switchThreadDataToThreadCardInfo(arrayList);
                }
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        jm6.b bVar = this.g;
                        if (bVar != null) {
                            bVar.removeItem(i3 + 20);
                        }
                    }
                }
            }
        }
    }

    public ArrayList<nn> C(boolean z, boolean z2, ArrayList<nn> arrayList, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (!z3 && this.a.size() == 0) {
                dh8 dh8Var = FrsFragment.g2;
                if (dh8Var != null) {
                    this.a.addAll(dh8Var.getThreadList());
                }
                FrsFragment.g2 = null;
            }
            if (ListUtils.isEmpty(arrayList)) {
                rm6 rm6Var = this.f;
                if (rm6Var != null) {
                    rm6Var.a(this.e, z2, 0, z, null, z3);
                }
                return this.a;
            }
            synchronized (this.a) {
                ArrayList<nn> arrayList2 = new ArrayList<>();
                ArrayList<nn> arrayList3 = new ArrayList<>();
                Iterator<nn> it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    nn next = it.next();
                    if (!z4 || !(next instanceof od6)) {
                        if (!(next instanceof md6)) {
                            if (H(next)) {
                                arrayList3.add(next);
                            } else {
                                if (next instanceof ThreadData) {
                                    ThreadData threadData = (ThreadData) next;
                                    threadData.setIsSmartFrsThread(true);
                                    A(threadData);
                                    if ((threadData.getRecomSource() != null && !threadData.isNeedCheckRepeat()) || !G(threadData.getId(), this.a)) {
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
                    S(arrayList2);
                }
                if (i != -1) {
                    if (i == 1) {
                        this.b.Q0().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.L0().w0());
                    } else if (i != 2) {
                        if (i != 3) {
                            if (gr6.d()) {
                                if (this.h != null) {
                                    this.h.b(arrayList2, z2, this.b.U());
                                }
                            } else {
                                this.b.Q0().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.L0().w0());
                            }
                        } else if (!ListUtils.isEmpty(list)) {
                            int intValue = list.get(0).ad_type.intValue();
                            if (intValue == 1) {
                                this.b.Q0().addRecommendAppToThreadList(this.b, true, arrayList2, this.a, this.b.L0().w0());
                            } else if (intValue == 2 && this.h != null) {
                                this.h.g(arrayList2, list, z2, this.b.U());
                            }
                        }
                    } else if (this.h != null) {
                        this.h.b(arrayList2, z2, this.b.U());
                    }
                }
                if (z2) {
                    if (this.f != null) {
                        this.f.a(this.e, z2, i2, z, arrayList2, z3);
                    }
                    I();
                    N(this.a, arrayList2);
                    F(arrayList2);
                    R(arrayList3);
                    J(this.a, 300);
                } else {
                    this.a.addAll(arrayList2);
                }
            }
            return this.a;
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<nn> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : invokeV.intValue;
    }

    public final void F(List<nn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.a.addAll(0, list);
    }

    public final boolean G(String str, ArrayList<nn> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, arrayList)) == null) {
            if (TextUtils.isEmpty(str) || arrayList == null) {
                return true;
            }
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if ((next instanceof ThreadData) && str.equalsIgnoreCase(((ThreadData) next).getTid())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean H(nn nnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, nnVar)) == null) {
            if (nnVar == null) {
                return false;
            }
            if (nnVar instanceof qh8) {
                return true;
            }
            return ((nnVar instanceof ThreadData) && ((ThreadData) nnVar).getIs_top() == 2) || nnVar.getType() == ih8.c;
        }
        return invokeL.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || ListUtils.isEmpty(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<nn> it = this.a.iterator();
        while (it.hasNext()) {
            nn next = it.next();
            if (H(next)) {
                arrayList.add(next);
            } else if (next instanceof md6) {
                arrayList.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.a.removeAll(arrayList);
    }

    public final void J(ArrayList<nn> arrayList, int i) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048585, this, arrayList, i) == null) || arrayList == null || (count = ListUtils.getCount(arrayList)) <= i) {
            return;
        }
        int max = Math.max(count - i, 30);
        int i2 = ((count - 20) - max) - 1;
        ListUtils.removeSubList(arrayList, i2, max + i2);
    }

    public void K(nn nnVar) {
        ArrayList<nn> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, nnVar) == null) || nnVar == null || (arrayList = this.a) == null) {
            return;
        }
        arrayList.remove(nnVar);
    }

    public void L(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Iterator<nn> it = this.a.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if ((next instanceof ThreadData) && TextUtils.equals(str, ((ThreadData) next).getTid())) {
                    it.remove();
                }
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.clear();
            this.d = -1;
            this.c = 1;
        }
    }

    public final void N(List<nn> list, List<nn> list2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, list, list2) == null) || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        list2.add(new md6());
    }

    public void O(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) && this.a.size() == 0) {
            this.a.addAll(arrayList);
        }
    }

    public void P(gr6 gr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gr6Var) == null) {
            this.h = gr6Var;
        }
    }

    public void Q(jm6.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public void R(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || ListUtils.isEmpty(this.a)) {
            return;
        }
        this.a.addAll(0, arrayList);
    }

    public void S(ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (!ListUtils.isEmpty(arrayList)) {
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
                if (next != null) {
                    if (next.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof ThreadData) && ((ThreadData) next).getIsLive() == 1) {
                        it.remove();
                        arrayList2.add(next);
                    } else if ((next instanceof wg8) || (next instanceof xg8)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        if (!ListUtils.isEmpty(this.a)) {
            Iterator<nn> it2 = this.a.iterator();
            while (it2.hasNext()) {
                nn next2 = it2.next();
                if (next2 != null) {
                    if (next2.getType() == ThreadData.TYPE_STAR_INTERVIEW) {
                        it2.remove();
                    } else if ((next2 instanceof ThreadData) && ((ThreadData) next2).getIsLive() == 1) {
                        it2.remove();
                    } else if ((next2 instanceof wg8) || (next2 instanceof xg8)) {
                        it2.remove();
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList2)) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                nn nnVar = (nn) it3.next();
                if (nnVar != null && ((nnVar instanceof wg8) || (nnVar instanceof xg8))) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.c : invokeV.intValue;
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

    public void setHasMore(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.d = i;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || i <= this.c) {
            return;
        }
        this.c = i;
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.e = i;
        }
    }
}
