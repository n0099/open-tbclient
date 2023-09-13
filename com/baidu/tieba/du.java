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
public final class du extends hr implements fu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fs d;
    public final hs e;
    public final ls f;
    public final os g;
    public final js h;
    public final es i;
    public final ks j;
    public final gu k;
    public final ou l;

    public du(fs fsVar, hs hsVar, ls lsVar, os osVar, js jsVar, es esVar, ks ksVar, gu guVar, ou ouVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fsVar, hsVar, lsVar, osVar, jsVar, esVar, ksVar, guVar, ouVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = fsVar;
        this.e = hsVar;
        this.f = lsVar;
        this.g = osVar;
        this.h = jsVar;
        this.i = esVar;
        this.j = ksVar;
        this.k = guVar;
        this.l = ouVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ du(fs fsVar, hs hsVar, ls lsVar, os osVar, js jsVar, es esVar, ks ksVar, gu guVar, ou ouVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fsVar, hsVar, lsVar, osVar, jsVar, esVar, ksVar, r10, r11);
        hu huVar;
        qu quVar;
        if ((i & 128) != 0) {
            huVar = new hu();
        } else {
            huVar = guVar;
        }
        if ((i & 256) != 0) {
            quVar = new qu();
        } else {
            quVar = ouVar;
        }
    }

    @Override // com.baidu.tieba.gr
    public ks a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ks) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gr
    public ls b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (ls) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gr
    public es c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (es) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fu
    public gu d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (gu) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gr
    public os e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (os) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fu
    public ou f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (ou) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gr
    public hs g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (hs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gr
    public fs h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (fs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gr
    public js i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (js) invokeV.objValue;
    }
}
