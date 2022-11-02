package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public class h66 implements Comparable<h66> {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public static final h66 j;
    public transient /* synthetic */ FieldHolder $fh;
    public i66 a;
    public ItemState b;
    public long c;
    public k86 d;
    public final b7<v66> e;
    public final k66 f;
    public final DrawState g;
    public int h;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final h66 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (h66) invokeV.objValue;
            }
            return h66.j;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947775713, "Lcom/baidu/tieba/h66;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947775713, "Lcom/baidu/tieba/h66;");
                return;
            }
        }
        i = new a(null);
        j = new h66(i66.p.c(), null, 2, null);
    }

    public h66(i66 data, DanmakuPlayer danmakuPlayer) {
        n66 m;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, danmakuPlayer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
        this.b = ItemState.Uninitialized;
        k86 k86Var = null;
        if (danmakuPlayer != null && (m = danmakuPlayer.m()) != null) {
            k86Var = m.w();
        }
        this.d = k86Var == null ? m66.h.a().f() : k86Var;
        this.e = new b7<>(0);
        this.f = new k66(this.d);
        this.g = new DrawState();
        this.h = -1;
    }

    public /* synthetic */ h66(i66 i66Var, DanmakuPlayer danmakuPlayer, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i66Var, (i2 & 2) != 0 ? null : danmakuPlayer);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.t();
            if (this.b.compareTo(ItemState.Measured) > 0) {
                this.b = ItemState.Measured;
            }
        }
    }

    public final b7<v66> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (b7) invokeV.objValue;
    }

    public final i66 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (i66) invokeV.objValue;
    }

    public final DrawState f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (DrawState) invokeV.objValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final ItemState i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (ItemState) invokeV.objValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.k() + this.f.a();
        }
        return invokeV.longValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f.b();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(h66 other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            return this.a.compareTo(other.a);
        }
        return invokeL.intValue;
    }

    public final void l(i66 i66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, i66Var) == null) {
            Intrinsics.checkNotNullParameter(i66Var, "<set-?>");
            this.a = i66Var;
        }
    }

    public final void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.c = j2;
        }
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.h = i2;
        }
    }

    public final void o(ItemState itemState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, itemState) == null) {
            Intrinsics.checkNotNullParameter(itemState, "<set-?>");
            this.b = itemState;
        }
    }

    public final void p(k86 k86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, k86Var) == null) {
            Intrinsics.checkNotNullParameter(k86Var, "<set-?>");
            this.d = k86Var;
        }
    }
}
