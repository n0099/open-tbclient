package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class gu extends kr implements iu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final is d;
    public final ks e;
    public final os f;
    public final rs g;
    public final ms h;
    public final hs i;
    public final ns j;
    public final ju k;
    public final ru l;

    public gu(is isVar, ks ksVar, os osVar, rs rsVar, ms msVar, hs hsVar, ns nsVar, ju juVar, ru ruVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {isVar, ksVar, osVar, rsVar, msVar, hsVar, nsVar, juVar, ruVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = isVar;
        this.e = ksVar;
        this.f = osVar;
        this.g = rsVar;
        this.h = msVar;
        this.i = hsVar;
        this.j = nsVar;
        this.k = juVar;
        this.l = ruVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ gu(is isVar, ks ksVar, os osVar, rs rsVar, ms msVar, hs hsVar, ns nsVar, ju juVar, ru ruVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(isVar, ksVar, osVar, rsVar, msVar, hsVar, nsVar, r10, r11);
        ku kuVar;
        tu tuVar;
        if ((i & 128) != 0) {
            kuVar = new ku();
        } else {
            kuVar = juVar;
        }
        if ((i & 256) != 0) {
            tuVar = new tu();
        } else {
            tuVar = ruVar;
        }
    }

    @Override // com.baidu.tieba.jr
    public ns a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ns) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jr
    public os b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (os) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jr
    public hs c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (hs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu
    public ju d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (ju) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jr
    public rs e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (rs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu
    public ru f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (ru) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jr
    public ks g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (ks) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jr
    public is h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (is) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jr
    public ms i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (ms) invokeV.objValue;
    }
}
