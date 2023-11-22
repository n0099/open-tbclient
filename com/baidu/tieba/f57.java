package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tieba.feed.data.CardDataKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f57<T> implements x97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ab7<? extends Object>> a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;
    public final ThemeCardInUserData g;
    public final c67 h;
    public final Map<String, Object> i;
    public final a67 j;
    public final Function2<Context, f57<?>, Unit> k;
    public final Function2<Context, f57<?>, Unit> l;
    public Object m;
    public boolean n;
    public boolean o;
    public int p;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof f57) {
                f57 f57Var = (f57) obj;
                return Intrinsics.areEqual(this.a, f57Var.a) && Intrinsics.areEqual(this.b, f57Var.b) && this.c == f57Var.c && this.d == f57Var.d && Intrinsics.areEqual(this.e, f57Var.e) && Intrinsics.areEqual(this.f, f57Var.f) && Intrinsics.areEqual(this.g, f57Var.g) && Intrinsics.areEqual(this.h, f57Var.h) && Intrinsics.areEqual(this.i, f57Var.i) && Intrinsics.areEqual(this.j, f57Var.j) && Intrinsics.areEqual(this.k, f57Var.k) && Intrinsics.areEqual(this.l, f57Var.l);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            boolean z = this.c;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.d;
            int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
            String str = this.e;
            int hashCode2 = (i3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            ThemeCardInUserData themeCardInUserData = this.g;
            int hashCode4 = (hashCode3 + (themeCardInUserData == null ? 0 : themeCardInUserData.hashCode())) * 31;
            c67 c67Var = this.h;
            int hashCode5 = (hashCode4 + (c67Var == null ? 0 : c67Var.hashCode())) * 31;
            Map<String, Object> map = this.i;
            return ((((((hashCode5 + (map != null ? map.hashCode() : 0)) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "CardData(dataList=" + this.a + ", schema=" + this.b + ", isGreyMode=" + this.c + ", canMultiManage=" + this.d + ", threadId=" + this.e + ", userId=" + this.f + ", themeCardInUserData=" + this.g + ", feedbackData=" + this.h + ", appendixMap=" + this.i + ", feedExtraData=" + this.j + ", onCardClick=" + this.k + ", onAllClick=" + this.l + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public f57(List<ab7<? extends Object>> dataList, String schema, boolean z, boolean z2, String str, String str2, ThemeCardInUserData themeCardInUserData, c67 c67Var, Map<String, ? extends Object> map, a67 feedExtraData, Function2<? super Context, ? super f57<?>, Unit> onCardClick, Function2<? super Context, ? super f57<?>, Unit> onAllClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {dataList, schema, Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, themeCardInUserData, c67Var, map, feedExtraData, onCardClick, onAllClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        Intrinsics.checkNotNullParameter(onAllClick, "onAllClick");
        this.a = dataList;
        this.b = schema;
        this.c = z;
        this.d = z2;
        this.e = str;
        this.f = str2;
        this.g = themeCardInUserData;
        this.h = c67Var;
        this.i = map;
        this.j = feedExtraData;
        this.k = onCardClick;
        this.l = onAllClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ f57(List list, String str, boolean z, boolean z2, String str2, String str3, ThemeCardInUserData themeCardInUserData, c67 c67Var, Map map, a67 a67Var, Function2 function2, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, r6, r7, str2, str3, themeCardInUserData, c67Var, map, a67Var, r14, r15);
        boolean z3;
        boolean z4;
        Function2 function23;
        Function2 function24;
        Function2 function25;
        Function2 function26;
        if ((i & 4) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 8) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if ((i & 1024) != 0) {
            function26 = CardDataKt.a;
            function23 = function26;
        } else {
            function23 = function2;
        }
        if ((i & 2048) != 0) {
            function25 = CardDataKt.b;
            function24 = function25;
        } else {
            function24 = function22;
        }
    }

    public final Map<String, Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (Map) invokeV.objValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final List<ab7<? extends Object>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final a67 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (a67) invokeV.objValue;
    }

    public final c67 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (c67) invokeV.objValue;
    }

    public final Object g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return invokeV.objValue;
    }

    public final Function2<Context, f57<?>, Unit> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<Context, f57<?>, Unit> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return (Function2) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final ThemeCardInUserData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return (ThemeCardInUserData) invokeV.objValue;
    }

    public final String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x97
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            for (ab7<? extends Object> ab7Var : this.a) {
                if (ab7Var instanceof x97) {
                    ((x97) ab7Var).d(event);
                }
            }
            if (event instanceof g57) {
                boolean a = ((g57) event).a();
                this.n = a;
                if (!a) {
                    this.o = false;
                }
            }
        }
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.o = z;
        }
    }

    public final void s(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, obj) == null) {
            this.m = obj;
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.p = i;
        }
    }
}
