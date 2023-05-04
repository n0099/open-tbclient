package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.SocialUiStateKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class cy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kz6 a;
    public lz6 b;
    public final Function1<kz6, Unit> c;
    public final Function3<Context, kz6, lz6, Boolean> d;
    public final Function1<kz6, Unit> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947691145, "Lcom/baidu/tieba/cy6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947691145, "Lcom/baidu/tieba/cy6;");
        }
    }

    @JvmOverloads
    public cy6(kz6 data, lz6 statData, Function1<? super kz6, Unit> onShareClick, Function3<? super Context, ? super kz6, ? super lz6, Boolean> onCommentClick, Function1<? super kz6, Unit> onPraiseClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, statData, onShareClick, onCommentClick, onPraiseClick};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(statData, "statData");
        Intrinsics.checkNotNullParameter(onShareClick, "onShareClick");
        Intrinsics.checkNotNullParameter(onCommentClick, "onCommentClick");
        Intrinsics.checkNotNullParameter(onPraiseClick, "onPraiseClick");
        this.a = data;
        this.b = statData;
        this.c = onShareClick;
        this.d = onCommentClick;
        this.e = onPraiseClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ cy6(kz6 kz6Var, lz6 lz6Var, Function1 function1, Function3 function3, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kz6Var, r0, r1, r2, r3);
        lz6 lz6Var2;
        Function1 function13;
        Function3 function32;
        Function1 function14;
        if ((i & 2) != 0) {
            lz6Var2 = new lz6(null, null, null, 7, null);
        } else {
            lz6Var2 = lz6Var;
        }
        if ((i & 4) != 0) {
            function13 = SocialUiStateKt.a;
        } else {
            function13 = function1;
        }
        if ((i & 8) != 0) {
            function32 = SocialUiStateKt.b;
        } else {
            function32 = function3;
        }
        if ((i & 16) != 0) {
            function14 = SocialUiStateKt.c;
        } else {
            function14 = function12;
        }
    }

    public final kz6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (kz6) invokeV.objValue;
    }

    public final Function3<Context, kz6, lz6, Boolean> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (Function3) invokeV.objValue;
    }

    public final Function1<kz6, Unit> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (Function1) invokeV.objValue;
    }

    public final Function1<kz6, Unit> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (Function1) invokeV.objValue;
    }

    public final lz6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (lz6) invokeV.objValue;
    }
}
