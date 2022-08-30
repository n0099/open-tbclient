package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ih0 implements mh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lh0 f;
    public final nh0 g;
    public final oh0 h;

    public ih0() {
        nh0 nh0Var;
        oh0 oh0Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = eh0.c().a();
        synchronized (eh0.class) {
            nh0Var = (nh0) ServiceManager.getService(nh0.b);
            nh0Var = nh0Var == null ? nh0.c : nh0Var;
        }
        this.g = nh0Var;
        synchronized (eh0.class) {
            oh0Var = (oh0) ServiceManager.getService(oh0.d);
            oh0Var = oh0Var == null ? oh0.e : oh0Var;
        }
        this.h = oh0Var;
    }

    @Override // com.baidu.tieba.lh0
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f.a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f.b() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.c() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f.d() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oh0
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h.e() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oh0
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h.f() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f.g() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nh0
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g.h() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f.i() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f.j() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f.k() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f.l() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f.m() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f.n() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f.o() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f.p() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String packageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f.packageName() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oh0
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.h.q() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    @NonNull
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f.r() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f.s() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f.t() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oh0
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.h.u() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.oh0
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.h.v() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f.w() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f.x() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lh0
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f.y() : invokeV.booleanValue;
    }
}
