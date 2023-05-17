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
public final class fu extends jr implements hu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hs d;
    public final js e;
    public final ns f;
    public final qs g;
    public final ls h;
    public final gs i;
    public final ms j;
    public final iu k;
    public final qu l;

    public fu(hs hsVar, js jsVar, ns nsVar, qs qsVar, ls lsVar, gs gsVar, ms msVar, iu iuVar, qu quVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hsVar, jsVar, nsVar, qsVar, lsVar, gsVar, msVar, iuVar, quVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = hsVar;
        this.e = jsVar;
        this.f = nsVar;
        this.g = qsVar;
        this.h = lsVar;
        this.i = gsVar;
        this.j = msVar;
        this.k = iuVar;
        this.l = quVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ fu(hs hsVar, js jsVar, ns nsVar, qs qsVar, ls lsVar, gs gsVar, ms msVar, iu iuVar, qu quVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hsVar, jsVar, nsVar, qsVar, lsVar, gsVar, msVar, r10, r11);
        ju juVar;
        su suVar;
        if ((i & 128) != 0) {
            juVar = new ju();
        } else {
            juVar = iuVar;
        }
        if ((i & 256) != 0) {
            suVar = new su();
        } else {
            suVar = quVar;
        }
    }

    @Override // com.baidu.tieba.ir
    public ms a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ms) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ir
    public ns b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (ns) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ir
    public gs c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (gs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hu
    public iu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (iu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ir
    public qs e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (qs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hu
    public qu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (qu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ir
    public js g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (js) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ir
    public hs h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (hs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ir
    public ls i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (ls) invokeV.objValue;
    }
}
