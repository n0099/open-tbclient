package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public final class g87<T> implements pb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<pc7<? extends Object>> a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final Map<String, Object> f;
    public final Function2<Context, g87<?>, Unit> g;
    public Object h;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof g87) {
                g87 g87Var = (g87) obj;
                return Intrinsics.areEqual(this.a, g87Var.a) && Intrinsics.areEqual(this.b, g87Var.b) && this.c == g87Var.c && Intrinsics.areEqual(this.d, g87Var.d) && Intrinsics.areEqual(this.e, g87Var.e) && Intrinsics.areEqual(this.f, g87Var.f) && Intrinsics.areEqual(this.g, g87Var.g);
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
            String str = this.d;
            int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.e;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Map<String, Object> map = this.f;
            return ((hashCode3 + (map != null ? map.hashCode() : 0)) * 31) + this.g.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "CardData(dataList=" + this.a + ", schema=" + this.b + ", isGreyMode=" + this.c + ", threadId=" + this.d + ", userId=" + this.e + ", appendixMap=" + this.f + ", onCardClick=" + this.g + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public g87(List<pc7<? extends Object>> dataList, String schema, boolean z, String str, String str2, Map<String, ? extends Object> map, Function2<? super Context, ? super g87<?>, Unit> onCardClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataList, schema, Boolean.valueOf(z), str, str2, map, onCardClick};
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
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        this.a = dataList;
        this.b = schema;
        this.c = z;
        this.d = str;
        this.e = str2;
        this.f = map;
        this.g = onCardClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g87(List list, String str, boolean z, String str2, String str3, Map map, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, r4, str2, str3, map, r8);
        boolean z2;
        Function2 function22;
        Function2 function23;
        if ((i & 4) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i & 64) != 0) {
            function23 = CardDataKt.a;
            function22 = function23;
        } else {
            function22 = function2;
        }
    }

    public final Map<String, Object> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (Map) invokeV.objValue;
    }

    public final List<pc7<? extends Object>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final Object c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return invokeV.objValue;
    }

    public final Function2<Context, g87<?>, Unit> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (Function2) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb7
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            for (pc7<? extends Object> pc7Var : this.a) {
                if (pc7Var instanceof pb7) {
                    ((pb7) pc7Var).d(event);
                }
            }
        }
    }

    public final void j(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, obj) == null) {
            this.h = obj;
        }
    }
}
