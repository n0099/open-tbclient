package com.baidu.tieba;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(List<? extends pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, list) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) instanceof bw9) {
                    int i2 = i + 1;
                    if (i2 < list.size() && l(list.get(i2))) {
                        ((ow9) list.get(i2)).l(-BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds28));
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static final int g(BdTypeListView bdTypeListView) {
        InterceptResult invokeL;
        List<pi> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bdTypeListView)) == null) {
            if (bdTypeListView != null) {
                list = bdTypeListView.getData();
            } else {
                list = null;
            }
            if (list != null) {
                int size = bdTypeListView.getData().size();
                for (int i = 0; i < size; i++) {
                    pi piVar = bdTypeListView.getData().get(i);
                    Intrinsics.checkNotNullExpressionValue(piVar, "mListView.data[i]");
                    if (Intrinsics.areEqual(piVar.getType(), nw9.g)) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static final mwa b(ArrayList<pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Iterator<pi> it = list.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if (next instanceof mwa) {
                    mwa mwaVar = (mwa) next;
                    if (mwaVar.L() == 1) {
                        return mwaVar;
                    }
                }
            }
            return null;
        }
        return (mwa) invokeL.objValue;
    }

    public static final boolean c(mwa mwaVar, ArrayList<pi> list, boolean z, mwa mwaVar2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{mwaVar, list, Boolean.valueOf(z), mwaVar2, Boolean.valueOf(z2)})) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            if (mwaVar == null) {
                if (mwaVar2 != null && !z2) {
                    ListUtils.add(list, 0, mwaVar2);
                } else {
                    mwa mwaVar3 = new mwa();
                    mwaVar3.Z0(1);
                    ListUtils.add(list, 0, mwaVar3);
                }
                return true;
            } else if (!z) {
                return false;
            } else {
                ListUtils.add(list, 0, mwaVar);
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static final int d(zv9 data, ArrayList<pi> list, boolean z, boolean z2, PbFragment mPbFragment) {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{data, list, Boolean.valueOf(z), Boolean.valueOf(z2), mPbFragment})) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(mPbFragment, "mPbFragment");
            if (!z && !ListUtils.isEmpty(data.I()) && list.size() > 0) {
                if (mPbFragment.l0() != null && mPbFragment.l0().b1()) {
                    return -1;
                }
                if (mPbFragment.i7() != null && mPbFragment.i7().X0()) {
                    return -1;
                }
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        pi piVar = list.get(i);
                        Intrinsics.checkNotNullExpressionValue(piVar, "list[i]");
                        pi piVar2 = piVar;
                        if (piVar2 instanceof mwa) {
                            mwa mwaVar = (mwa) piVar2;
                            if (mwaVar.L() == 1 && mwaVar.O == 0) {
                                z3 = true;
                                break;
                            }
                        }
                        i++;
                    } else {
                        z3 = false;
                        i = -1;
                        break;
                    }
                }
                if (!z3) {
                    if (data.y0()) {
                        return 0;
                    }
                    return -1;
                }
                return i + 1;
            } else if (data.y0() && z2) {
                return 0;
            } else {
                return -1;
            }
        }
        return invokeCommon.intValue;
    }

    @Nullable
    public static final List<pi> e(zv9 data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.W() == null || ListUtils.isEmpty(data.W().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<mwa> list = data.W().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                mwa mwaVar = list.get(i);
                if (mwaVar != null) {
                    mwaVar.g0 = true;
                    mwaVar.P = true;
                    arrayList.add(mwaVar);
                }
            }
            if (ListUtils.getCount(data.W().b) > 2) {
                pi piVar = (pi) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (piVar instanceof mwa) {
                    ((mwa) piVar).P = false;
                }
                arrayList.add(new f6a());
            } else {
                pi piVar2 = (pi) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (piVar2 instanceof mwa) {
                    ((mwa) piVar2).P = true;
                }
            }
            arrayList.add(0, new nw9(nw9.h));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static final int f(zv9 data, ArrayList<pi> list) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, data, list)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            if (ListUtils.isEmpty(data.I()) || ListUtils.isEmpty(list) || ListUtils.getItem(data.I(), 0) == null) {
                return 0;
            }
            int size = list.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    pi piVar = list.get(i);
                    Intrinsics.checkNotNullExpressionValue(piVar, "list[i]");
                    pi piVar2 = piVar;
                    if (piVar2 instanceof mwa) {
                        mwa mwaVar = (mwa) piVar2;
                        if (mwaVar.L() == 1 && mwaVar.O == 0) {
                            z = true;
                            break;
                        }
                    }
                    i++;
                } else {
                    z = false;
                    i = 0;
                    break;
                }
            }
            if (!z) {
                return 0;
            }
            return i + 1;
        }
        return invokeLL.intValue;
    }

    public static final int h(zv9 data, ArrayList<pi> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, data, arrayList, z)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.I() == null || data.F() == null || data.I().size() == 0 || data.R() == null || arrayList == null || !data.F().H1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z && data.I().get(0) != null && data.I().get(0).L() == 1) {
                return 1;
            }
            if ((z || size != 0) && (z || data.B() == null || data.B().a() != data.B().h())) {
                return -1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public static final int i(zv9 data, ArrayList<pi> list, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, data, list, z)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            if (data.I() == null || data.G() == null || data.I().size() == 0 || data.R() == null || !data.G().H1()) {
                return -1;
            }
            int size = list.size();
            if (z && data.I().get(0) != null && data.I().get(0).L() == 1) {
                return 1;
            }
            if ((z || size != 0) && (z || data.B() == null || data.B().a() != data.B().h())) {
                return -1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public static final int j(zv9 data, ArrayList<pi> list, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, data, list, z)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            if (!ListUtils.isEmpty(data.I()) && list.size() > 0) {
                if (z && data.I().get(0) != null && data.I().get(0).L() == 1) {
                    return 1;
                }
                if ((!z || data.l() == null) && z) {
                    return -1;
                }
                return 0;
            } else if (!data.y0()) {
                return -1;
            } else {
                return 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public static final int k(zv9 data, ArrayList<pi> list, boolean z) {
        InterceptResult invokeLLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, data, list, z)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(list, "list");
            int i = -1;
            if (data.B() == null) {
                return -1;
            }
            int i2 = 0;
            if (data.B().c() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            int size = list.size();
            if (!z2 || !z) {
                return -1;
            }
            while (true) {
                if (i2 >= size) {
                    break;
                }
                pi piVar = list.get(i2);
                Intrinsics.checkNotNullExpressionValue(piVar, "list[i]");
                if (piVar instanceof nw9) {
                    i = i2 + 1;
                    break;
                }
                i2++;
            }
            if (data.M() == 4) {
                return i + 1;
            }
            return i;
        }
        return invokeLLZ.intValue;
    }

    public static final boolean l(pi piVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, piVar)) == null) {
            if (piVar instanceof ow9) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
