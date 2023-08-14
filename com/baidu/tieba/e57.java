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
/* loaded from: classes5.dex */
public final class e57 extends t97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p57 c;
    public f77 d;
    public f77 e;
    public String f;
    public final ec7 g;
    public d77 h;
    public final Function1<d77, Unit> i;
    public final Function2<View, String, Unit> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947685410, "Lcom/baidu/tieba/e57;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947685410, "Lcom/baidu/tieba/e57;");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e57) {
                e57 e57Var = (e57) obj;
                return Intrinsics.areEqual(this.c, e57Var.c) && Intrinsics.areEqual(this.d, e57Var.d) && Intrinsics.areEqual(this.e, e57Var.e) && Intrinsics.areEqual(this.f, e57Var.f) && Intrinsics.areEqual(this.g, e57Var.g) && Intrinsics.areEqual(this.h, e57Var.h) && Intrinsics.areEqual(this.i, e57Var.i) && Intrinsics.areEqual(this.j, e57Var.j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int hashCode = this.c.hashCode() * 31;
            f77 f77Var = this.d;
            int hashCode2 = (hashCode + (f77Var == null ? 0 : f77Var.hashCode())) * 31;
            f77 f77Var2 = this.e;
            int hashCode3 = (hashCode2 + (f77Var2 == null ? 0 : f77Var2.hashCode())) * 31;
            String str = this.f;
            int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.g.hashCode()) * 31;
            d77 d77Var = this.h;
            return ((((hashCode4 + (d77Var != null ? d77Var.hashCode() : 0)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
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
    public e57(p57 headData, f77 f77Var, f77 f77Var2, String str, ec7 personAttentionUiState, d77 d77Var, Function1<? super d77, Unit> onStat, Function2<? super View, ? super String, Unit> onItemClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, f77Var, f77Var2, str, personAttentionUiState, d77Var, onStat, onItemClick};
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
        this.d = f77Var;
        this.e = f77Var2;
        this.f = str;
        this.g = personAttentionUiState;
        this.h = d77Var;
        this.i = onStat;
        this.j = onItemClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ e57(p57 p57Var, f77 f77Var, f77 f77Var2, String str, ec7 ec7Var, d77 d77Var, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(p57Var, r5, r6, r7, ec7Var, r9, r10, r11);
        f77 f77Var3;
        f77 f77Var4;
        String str2;
        d77 d77Var2;
        Function1<d77, Unit> function12;
        Function2<View, String, Unit> function22;
        if ((i & 2) != 0) {
            f77Var3 = null;
        } else {
            f77Var3 = f77Var;
        }
        if ((i & 4) != 0) {
            f77Var4 = null;
        } else {
            f77Var4 = f77Var2;
        }
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 32) != 0) {
            d77Var2 = null;
        } else {
            d77Var2 = d77Var;
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

    public final p57 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (p57) invokeV.objValue;
    }

    public final Function2<View, String, Unit> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function1<d77, Unit> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (Function1) invokeV.objValue;
    }

    public final ec7 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (ec7) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final d77 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (d77) invokeV.objValue;
    }

    public final f77 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (f77) invokeV.objValue;
    }

    public final f77 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (f77) invokeV.objValue;
    }
}
