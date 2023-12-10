package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
/* loaded from: classes6.dex */
public final class hra implements jua {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ora a;
    public final mra b;
    public final pra c;
    public final nra d;
    public final ira e;
    public final kra f;
    public final jra g;
    public final HashMap<mua, HashMap<kua, mua>> h;

    public hra() {
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
        this.a = new ora();
        this.b = new mra();
        this.c = new pra();
        this.d = new nra();
        new qra();
        this.e = new ira();
        this.f = new kra();
        new lra();
        this.g = new jra();
        this.h = MapsKt__MapsKt.hashMapOf(new Pair(a(), MapsKt__MapsKt.hashMapOf(new Pair(this.e, this.b))), new Pair(this.b, MapsKt__MapsKt.hashMapOf(new Pair(this.f, this.c))), new Pair(this.c, MapsKt__MapsKt.hashMapOf(new Pair(this.g, this.d))), new Pair(this.d, MapsKt__MapsKt.hashMapOf(new Pair(this.e, this.b))));
    }

    public final ira b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (ira) invokeV.objValue;
    }

    public final mra c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (mra) invokeV.objValue;
    }

    public final nra d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (nra) invokeV.objValue;
    }

    public final jra e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (jra) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jua
    /* renamed from: f */
    public ora a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (ora) invokeV.objValue;
    }

    public final kra g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (kra) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jua
    public HashMap<mua, HashMap<kua, mua>> getMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (HashMap) invokeV.objValue;
    }

    public final pra h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (pra) invokeV.objValue;
    }
}
