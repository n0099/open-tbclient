package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
import com.baidu.tieba.feed.helper.CommonOnClickKt;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i57 extends pb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z57 c;
    public g87 d;
    public g87 e;
    public String f;
    public final he7 g;
    public e87 h;
    public final Function1<e87, Unit> i;
    public final Function2<View, String, Unit> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947804574, "Lcom/baidu/tieba/i57;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947804574, "Lcom/baidu/tieba/i57;");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i57) {
                i57 i57Var = (i57) obj;
                return Intrinsics.areEqual(this.c, i57Var.c) && Intrinsics.areEqual(this.d, i57Var.d) && Intrinsics.areEqual(this.e, i57Var.e) && Intrinsics.areEqual(this.f, i57Var.f) && Intrinsics.areEqual(this.g, i57Var.g) && Intrinsics.areEqual(this.h, i57Var.h) && Intrinsics.areEqual(this.i, i57Var.i) && Intrinsics.areEqual(this.j, i57Var.j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int hashCode = this.c.hashCode() * 31;
            g87 g87Var = this.d;
            int hashCode2 = (hashCode + (g87Var == null ? 0 : g87Var.hashCode())) * 31;
            g87 g87Var2 = this.e;
            int hashCode3 = (hashCode2 + (g87Var2 == null ? 0 : g87Var2.hashCode())) * 31;
            String str = this.f;
            int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.g.hashCode()) * 31;
            e87 e87Var = this.h;
            return ((((hashCode4 + (e87Var != null ? e87Var.hashCode() : 0)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "RecommendPersonAttentionCardUiState(headData=" + this.c + ", userName=" + this.d + ", userDesc=" + this.e + ", schema=" + this.f + ", personAttentionUiState=" + this.g + ", statData=" + this.h + ", onStat=" + this.i + ", onItemClick=" + this.j + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public i57(z57 headData, g87 g87Var, g87 g87Var2, String str, he7 personAttentionUiState, e87 e87Var, Function1<? super e87, Unit> onStat, Function2<? super View, ? super String, Unit> onItemClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, g87Var, g87Var2, str, personAttentionUiState, e87Var, onStat, onItemClick};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(headData, "headData");
        Intrinsics.checkNotNullParameter(personAttentionUiState, "personAttentionUiState");
        Intrinsics.checkNotNullParameter(onStat, "onStat");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        this.c = headData;
        this.d = g87Var;
        this.e = g87Var2;
        this.f = str;
        this.g = personAttentionUiState;
        this.h = e87Var;
        this.i = onStat;
        this.j = onItemClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ i57(z57 z57Var, g87 g87Var, g87 g87Var2, String str, he7 he7Var, e87 e87Var, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z57Var, r5, r6, r7, he7Var, r9, r10, r11);
        g87 g87Var3;
        g87 g87Var4;
        String str2;
        e87 e87Var2;
        Function1<e87, Unit> function12;
        Function2<View, String, Unit> function22;
        if ((i & 2) != 0) {
            g87Var3 = null;
        } else {
            g87Var3 = g87Var;
        }
        if ((i & 4) != 0) {
            g87Var4 = null;
        } else {
            g87Var4 = g87Var2;
        }
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 32) != 0) {
            e87Var2 = null;
        } else {
            e87Var2 = e87Var;
        }
        if ((i & 64) != 0) {
            function12 = CardUiStateKt.b();
        } else {
            function12 = function1;
        }
        if ((i & 128) != 0) {
            function22 = CommonOnClickKt.b();
        } else {
            function22 = function2;
        }
    }

    public final z57 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (z57) invokeV.objValue;
    }

    public final Function2<View, String, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function1<e87, Unit> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (Function1) invokeV.objValue;
    }

    public final he7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (he7) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final e87 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (e87) invokeV.objValue;
    }

    public final g87 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (g87) invokeV.objValue;
    }

    public final g87 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (g87) invokeV.objValue;
    }
}
