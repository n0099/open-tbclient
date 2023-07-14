package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class aga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final iga b;
    public final hga c;
    public final jga d;
    public final dga e;
    public final zfa f;
    public final cga g;
    public final bga h;
    public final yfa i;
    public final fga j;
    public final ega k;
    public final gga l;

    public aga(MainTabActivity mainTabActivity, pfa pfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = new iga(mainTabActivity, pfaVar);
        this.c = new hga(mainTabActivity, pfaVar);
        this.d = new jga();
        this.e = new dga(mainTabActivity, pfaVar);
        this.f = new zfa(mainTabActivity, pfaVar);
        this.g = new cga(mainTabActivity, pfaVar);
        this.h = new bga(mainTabActivity, pfaVar);
        this.i = new yfa(mainTabActivity, pfaVar);
        this.j = new fga(mainTabActivity, pfaVar);
        this.k = new ega(mainTabActivity);
        this.l = new gga(mainTabActivity);
    }

    public yfa a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (yfa) invokeV.objValue;
    }

    public zfa b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (zfa) invokeV.objValue;
    }

    public bga c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (bga) invokeV.objValue;
    }

    public cga d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (cga) invokeV.objValue;
    }

    public dga e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (dga) invokeV.objValue;
    }

    public ega f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.k;
        }
        return (ega) invokeV.objValue;
    }

    public fga g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return (fga) invokeV.objValue;
    }

    public hga h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (hga) invokeV.objValue;
    }

    public iga i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (iga) invokeV.objValue;
    }

    public jga j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (jga) invokeV.objValue;
    }

    public gga k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return (gga) invokeV.objValue;
    }
}
