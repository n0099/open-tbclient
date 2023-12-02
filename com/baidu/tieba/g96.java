package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class g96 {
    public static /* synthetic */ Interceptable $ic = null;
    public static long f = 604800000;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<pi> b;
    public List<pi> c;
    public List<pi> d;
    public List<pi> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947748805, "Lcom/baidu/tieba/g96;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947748805, "Lcom/baidu/tieba/g96;");
        }
    }

    public g96(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<pi> list = this.c;
            if (list != null) {
                list.clear();
            }
            List<pi> list2 = this.d;
            if (list2 != null) {
                list2.clear();
            }
            List<pi> list3 = this.e;
            if (list3 != null) {
                list3.clear();
            }
            List<pi> list4 = this.b;
            if (list4 != null) {
                list4.clear();
            }
        }
    }

    public List<pi> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final List<pi> b(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaLiveTabMyConcernResponse)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                if (!ListUtils.isEmpty(this.d) && k(alaLiveTabMyConcernResponse)) {
                    arrayList.add(new c96());
                }
                if (!ListUtils.isEmpty(this.d)) {
                    oa6 oa6Var = new oa6();
                    oa6Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c08, Integer.valueOf(alaLiveTabMyConcernResponse.followCloseNum));
                    arrayList.add(oa6Var);
                }
                if (!ListUtils.isEmpty(this.d)) {
                    for (pi piVar : this.d) {
                        arrayList.add(piVar);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<pi> g(List<pi> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                int size = list.size();
                for (int i = 0; i < size; i += 3) {
                    e96 e96Var = new e96();
                    d86 d86Var = new d86();
                    d86Var.d = (ThreadData) list.get(i);
                    e96Var.a = d86Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        d86 d86Var2 = new d86();
                        d86Var2.d = (ThreadData) list.get(i2);
                        e96Var.b = d86Var2;
                    }
                    int i3 = i + 2;
                    if (i3 < size) {
                        d86 d86Var3 = new d86();
                        d86Var3.d = (ThreadData) list.get(i3);
                        e96Var.c = d86Var3;
                    }
                    arrayList.add(e96Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final List<pi> c(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (alaLiveTabMyConcernResponse == null) {
                return arrayList;
            }
            if (alaLiveTabMyConcernResponse.followStatus != 1) {
                oa6 oa6Var = new oa6();
                oa6Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c09, Integer.valueOf(alaLiveTabMyConcernResponse.totalFollowCount));
                arrayList.add(oa6Var);
            }
            if (!ListUtils.isEmpty(this.c)) {
                arrayList.addAll(f());
            } else if (z) {
                na6 na6Var = new na6();
                na6Var.a = alaLiveTabMyConcernResponse.followStatus;
                arrayList.add(na6Var);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public void e(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048580, this, alaLiveTabMyConcernResponse, z) != null) || alaLiveTabMyConcernResponse == null) {
            return;
        }
        if (z) {
            this.b.clear();
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followList)) {
            this.c.addAll(alaLiveTabMyConcernResponse.followList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.followCloseList)) {
            this.d.addAll(alaLiveTabMyConcernResponse.followCloseList);
        }
        if (!ListUtils.isEmpty(alaLiveTabMyConcernResponse.recommendList)) {
            this.e.addAll(alaLiveTabMyConcernResponse.recommendList);
        }
        this.b = i(alaLiveTabMyConcernResponse, z);
    }

    public final List<pi> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                oa6 oa6Var = new oa6();
                oa6Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c0d);
                arrayList.add(oa6Var);
                arrayList.addAll(g(this.e));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<pi> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.c)) {
                int size = this.c.size();
                for (int i = 0; i < size; i += 2) {
                    u86 u86Var = new u86();
                    d86 d86Var = new d86();
                    d86Var.d = (ThreadData) this.c.get(i);
                    d86Var.f = true;
                    u86Var.a = d86Var;
                    int i2 = i + 1;
                    if (i2 < size) {
                        d86 d86Var2 = new d86();
                        d86Var2.d = (ThreadData) this.c.get(i2);
                        u86Var.b = d86Var2;
                        d86Var2.g = true;
                    } else {
                        d86Var.f = false;
                        d86Var.h = true;
                    }
                    int i3 = size % 2;
                    if ((i3 == 0 && i == size - 2) || (i3 != 0 && i == size - 1)) {
                        u86Var.c = true;
                    }
                    arrayList.add(u86Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<pi> i(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveTabMyConcernResponse, z)) == null) {
            ArrayList arrayList = new ArrayList();
            List<pi> c = c(alaLiveTabMyConcernResponse, z);
            if (!ListUtils.isEmpty(c)) {
                arrayList.addAll(c);
            }
            List<pi> b = b(alaLiveTabMyConcernResponse);
            if (!ListUtils.isEmpty(b)) {
                arrayList.addAll(b);
            }
            List<pi> d = d();
            if (!ListUtils.isEmpty(d)) {
                arrayList.addAll(d);
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public void j(Class<? extends BaseCardInfo> cls) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, cls) != null) || ListUtils.isEmpty(this.b)) {
            return;
        }
        for (int size = this.b.size() - 1; size >= 0; size--) {
            pi piVar = (pi) ListUtils.getItem(this.b, size);
            if (piVar != null && piVar.getClass().equals(cls)) {
                this.b.remove(size);
            }
        }
    }

    public final boolean k(AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, alaLiveTabMyConcernResponse)) == null) {
            if (alaLiveTabMyConcernResponse == null) {
                return false;
            }
            if (System.currentTimeMillis() - AlaSharedPrefHelper.getInstance().getLong(AlaSharedPrefConfig.ALA_LIVE_TAB_NOTIFICATION_CLOSE_LAST_TIME, 0L) > f) {
                z = true;
            } else {
                z = false;
            }
            if (alaLiveTabMyConcernResponse.followStatus == 1 || f96.a(this.a) || !z) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
