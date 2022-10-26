package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class gv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public List b;
    public List c;
    public pv5 d;
    public List e;
    public boolean f;
    public String g;
    public String h;

    public gv5(ju5 ju5Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju5Var, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f = false;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = new ArrayList();
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.f = true;
        }
        this.g = str;
        this.h = str2;
        a(ju5Var);
    }

    public boolean a(ju5 ju5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ju5Var)) == null) {
            if (ju5Var == null) {
                return false;
            }
            boolean e = e(ju5Var.b);
            this.a = ju5Var.a;
            return e;
        }
        return invokeL.booleanValue;
    }

    public void g(pv5 pv5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, pv5Var) == null) {
            this.d = pv5Var;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = false;
            List list = this.b;
            if (list != null) {
                list.clear();
            }
            List list2 = this.c;
            if (list2 != null) {
                list2.clear();
            }
            List list3 = this.e;
            if (list3 != null) {
                list3.clear();
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final ArrayList c(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i += 2) {
                fu5 fu5Var = new fu5();
                st5 st5Var = new st5();
                st5Var.a = (SdkLiveInfoData) list.get(i);
                st5Var.f = true;
                st5Var.b = this.f;
                st5Var.c = this.g;
                st5Var.d = this.h;
                int i2 = i + 1;
                st5Var.e = i2;
                fu5Var.a = st5Var;
                if (i2 < size) {
                    st5 st5Var2 = new st5();
                    st5Var2.a = (SdkLiveInfoData) list.get(i2);
                    st5Var2.b = this.f;
                    st5Var2.c = this.g;
                    st5Var2.d = this.h;
                    st5Var2.e = i + 2;
                    fu5Var.b = st5Var2;
                    st5Var2.g = true;
                } else {
                    st5Var.f = false;
                    st5Var.h = true;
                }
                arrayList.add(fu5Var);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public List d() {
        InterceptResult invokeV;
        t26 t26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.e)) {
                arrayList.addAll(this.e);
            }
            pv5 pv5Var = this.d;
            if (pv5Var != null && (t26Var = pv5Var.a) != null && !ListUtils.isEmpty(t26Var.c())) {
                arrayList.add(0, this.d);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean e(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SdkLiveInfoData sdkLiveInfoData = (SdkLiveInfoData) it.next();
                if (sdkLiveInfoData != null) {
                    String str = sdkLiveInfoData.liveId;
                    if (!this.b.contains(str)) {
                        arrayList.add(sdkLiveInfoData);
                        this.b.add(str);
                    }
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return false;
            }
            this.c.addAll(arrayList);
            ArrayList c = c(this.c);
            this.e = c;
            if (ListUtils.isEmpty(c)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
