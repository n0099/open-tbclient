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
public final class av extends es implements cv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ct d;
    public final et e;
    public final it f;
    public final lt g;
    public final gt h;
    public final bt i;
    public final ht j;
    public final dv k;
    public final lv l;

    public av(ct ctVar, et etVar, it itVar, lt ltVar, gt gtVar, bt btVar, ht htVar, dv dvVar, lv lvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ctVar, etVar, itVar, ltVar, gtVar, btVar, htVar, dvVar, lvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = ctVar;
        this.e = etVar;
        this.f = itVar;
        this.g = ltVar;
        this.h = gtVar;
        this.i = btVar;
        this.j = htVar;
        this.k = dvVar;
        this.l = lvVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ av(ct ctVar, et etVar, it itVar, lt ltVar, gt gtVar, bt btVar, ht htVar, dv dvVar, lv lvVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ctVar, etVar, itVar, ltVar, gtVar, btVar, htVar, r10, r11);
        ev evVar;
        nv nvVar;
        if ((i & 128) != 0) {
            evVar = new ev();
        } else {
            evVar = dvVar;
        }
        if ((i & 256) != 0) {
            nvVar = new nv();
        } else {
            nvVar = lvVar;
        }
    }

    @Override // com.baidu.tieba.ds
    public ht a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return (ht) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ds
    public it b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (it) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ds
    public bt c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (bt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cv
    public dv d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return (dv) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ds
    public lt e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (lt) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cv
    public lv f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (lv) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ds
    public et g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (et) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ds
    public ct h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (ct) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ds
    public gt i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (gt) invokeV.objValue;
    }
}
