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
public final class b57 extends r87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l57 c;
    public n67 d;
    public n67 e;
    public String f;
    public final pa7 g;
    public m67 h;
    public final Function1<m67, Unit> i;
    public final Function2<View, String, Unit> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947596037, "Lcom/baidu/tieba/b57;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947596037, "Lcom/baidu/tieba/b57;");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b57) {
                b57 b57Var = (b57) obj;
                return Intrinsics.areEqual(this.c, b57Var.c) && Intrinsics.areEqual(this.d, b57Var.d) && Intrinsics.areEqual(this.e, b57Var.e) && Intrinsics.areEqual(this.f, b57Var.f) && Intrinsics.areEqual(this.g, b57Var.g) && Intrinsics.areEqual(this.h, b57Var.h) && Intrinsics.areEqual(this.i, b57Var.i) && Intrinsics.areEqual(this.j, b57Var.j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int hashCode = this.c.hashCode() * 31;
            n67 n67Var = this.d;
            int hashCode2 = (hashCode + (n67Var == null ? 0 : n67Var.hashCode())) * 31;
            n67 n67Var2 = this.e;
            int hashCode3 = (hashCode2 + (n67Var2 == null ? 0 : n67Var2.hashCode())) * 31;
            String str = this.f;
            int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.g.hashCode()) * 31;
            m67 m67Var = this.h;
            return ((((hashCode4 + (m67Var != null ? m67Var.hashCode() : 0)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
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
    public b57(l57 headData, n67 n67Var, n67 n67Var2, String str, pa7 personAttentionUiState, m67 m67Var, Function1<? super m67, Unit> onStat, Function2<? super View, ? super String, Unit> onItemClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, n67Var, n67Var2, str, personAttentionUiState, m67Var, onStat, onItemClick};
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
        this.d = n67Var;
        this.e = n67Var2;
        this.f = str;
        this.g = personAttentionUiState;
        this.h = m67Var;
        this.i = onStat;
        this.j = onItemClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ b57(l57 l57Var, n67 n67Var, n67 n67Var2, String str, pa7 pa7Var, m67 m67Var, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l57Var, r5, r6, r7, pa7Var, r9, r10, r11);
        n67 n67Var3;
        n67 n67Var4;
        String str2;
        m67 m67Var2;
        Function1<m67, Unit> function12;
        Function2<View, String, Unit> function22;
        if ((i & 2) != 0) {
            n67Var3 = null;
        } else {
            n67Var3 = n67Var;
        }
        if ((i & 4) != 0) {
            n67Var4 = null;
        } else {
            n67Var4 = n67Var2;
        }
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 32) != 0) {
            m67Var2 = null;
        } else {
            m67Var2 = m67Var;
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

    public final l57 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (l57) invokeV.objValue;
    }

    public final Function2<View, String, Unit> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function1<m67, Unit> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (Function1) invokeV.objValue;
    }

    public final pa7 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (pa7) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final m67 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (m67) invokeV.objValue;
    }

    public final n67 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (n67) invokeV.objValue;
    }

    public final n67 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (n67) invokeV.objValue;
    }
}
