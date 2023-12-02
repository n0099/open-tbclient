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
/* loaded from: classes5.dex */
public class es6 implements Comparable<es6> {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public static final es6 j;
    public transient /* synthetic */ FieldHolder $fh;
    public fs6 a;
    public ItemState b;
    public long c;
    public hu6 d;
    public final h3<ss6> e;
    public final hs6 f;
    public final DrawState g;
    public int h;

    /* loaded from: classes5.dex */
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

        public final es6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (es6) invokeV.objValue;
            }
            return es6.j;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947744961, "Lcom/baidu/tieba/es6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947744961, "Lcom/baidu/tieba/es6;");
                return;
            }
        }
        i = new a(null);
        j = new es6(fs6.p.c(), null, 2, null);
    }

    public es6(fs6 data, DanmakuPlayer danmakuPlayer) {
        hu6 f;
        ks6 m;
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
        this.d = (danmakuPlayer == null || (m = danmakuPlayer.m()) == null || (f = m.x()) == null) ? js6.h.a().f() : f;
        this.e = new h3<>(0);
        this.f = new hs6(this.d);
        this.g = new DrawState();
        this.h = -1;
    }

    public /* synthetic */ es6(fs6 fs6Var, DanmakuPlayer danmakuPlayer, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fs6Var, (i2 & 2) != 0 ? null : danmakuPlayer);
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

    public final h3<ss6> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (h3) invokeV.objValue;
    }

    public final fs6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (fs6) invokeV.objValue;
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
            return this.a.l() + this.f.a();
        }
        return invokeV.longValue;
    }

    public final boolean l() {
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
    public int compareTo(es6 other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            return this.a.compareTo(other.a);
        }
        return invokeL.intValue;
    }

    public final void m(fs6 fs6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fs6Var) == null) {
            Intrinsics.checkNotNullParameter(fs6Var, "<set-?>");
            this.a = fs6Var;
        }
    }

    public final void n(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.c = j2;
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.h = i2;
        }
    }

    public final void p(ItemState itemState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, itemState) == null) {
            Intrinsics.checkNotNullParameter(itemState, "<set-?>");
            this.b = itemState;
        }
    }

    public final void q(hu6 hu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hu6Var) == null) {
            Intrinsics.checkNotNullParameter(hu6Var, "<set-?>");
            this.d = hu6Var;
        }
    }
}
