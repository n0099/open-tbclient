package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class cu extends gr implements eu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final es d;
    public final gs e;
    public final ks f;
    public final ns g;
    public final is h;
    public final ds i;
    public final js j;
    public final fu k;
    public final nu l;

    public cu(es esVar, gs gsVar, ks ksVar, ns nsVar, is isVar, ds dsVar, js jsVar, fu fuVar, nu nuVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {esVar, gsVar, ksVar, nsVar, isVar, dsVar, jsVar, fuVar, nuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = esVar;
        this.e = gsVar;
        this.f = ksVar;
        this.g = nsVar;
        this.h = isVar;
        this.i = dsVar;
        this.j = jsVar;
        this.k = fuVar;
        this.l = nuVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ cu(es esVar, gs gsVar, ks ksVar, ns nsVar, is isVar, ds dsVar, js jsVar, fu fuVar, nu nuVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(esVar, gsVar, ksVar, nsVar, isVar, dsVar, jsVar, r10, r11);
        gu guVar;
        pu puVar;
        if ((i & 128) != 0) {
            guVar = new gu();
        } else {
            guVar = fuVar;
        }
        if ((i & 256) != 0) {
            puVar = new pu();
        } else {
            puVar = nuVar;
        }
    }

    @Override // com.baidu.tieba.fr
    public js a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (js) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fr
    public ks b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (ks) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fr
    public ds c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (ds) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eu
    public fu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (fu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fr
    public ns e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (ns) invokeV.objValue;
    }

    @Override // com.baidu.tieba.eu
    public nu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (nu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fr
    public gs g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (gs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fr
    public es h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (es) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fr
    public is i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (is) invokeV.objValue;
    }
}
