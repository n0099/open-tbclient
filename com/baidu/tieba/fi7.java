package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fi7 extends oq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;
    public final BdUniqueId b;
    public final Boolean c;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof fi7) {
                fi7 fi7Var = (fi7) obj;
                return Intrinsics.areEqual(this.a, fi7Var.a) && Intrinsics.areEqual(this.b, fi7Var.b) && Intrinsics.areEqual(this.c, fi7Var.c);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            Boolean bool = this.c;
            return hashCode + (bool == null ? 0 : bool.hashCode());
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "H5HeightEvent(wrapper=" + this.a + ", uniqueId=" + this.b + ", success=" + this.c + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final double a;
        public final double b;
        public final double c;
        public final double d;
        public final double e;
        public final double f;

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual((Object) Double.valueOf(this.a), (Object) Double.valueOf(aVar.a)) && Intrinsics.areEqual((Object) Double.valueOf(this.b), (Object) Double.valueOf(aVar.b)) && Intrinsics.areEqual((Object) Double.valueOf(this.c), (Object) Double.valueOf(aVar.c)) && Intrinsics.areEqual((Object) Double.valueOf(this.d), (Object) Double.valueOf(aVar.d)) && Intrinsics.areEqual((Object) Double.valueOf(this.e), (Object) Double.valueOf(aVar.e)) && Intrinsics.areEqual((Object) Double.valueOf(this.f), (Object) Double.valueOf(aVar.f));
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (((((((((b.a(this.a) * 31) + b.a(this.b)) * 31) + b.a(this.c)) * 31) + b.a(this.d)) * 31) + b.a(this.e)) * 31) + b.a(this.f) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return "H5HeightWrapper(h5Height=" + this.a + ", naShowHeight=" + this.b + ", businessHeadHeight=" + this.c + ", businessHeadOffsetY=" + this.d + ", bounceOffset=" + this.e + ", tabCornerHeight=" + this.f + ')';
            }
            return (String) invokeV.objValue;
        }

        public a(double d, double d2, double d3, double d4, double d5, double d6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r4;
                Object[] objArr = {Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4), Double.valueOf(d5), Double.valueOf(d6)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d;
            this.b = d2;
            this.c = d3;
            this.d = d4;
            this.e = d5;
            this.f = d6;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ a(double d, double d2, double d3, double d4, double d5, double d6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, d2, d3, d4, r11, r13);
            double d7;
            double d8;
            if ((i & 16) != 0) {
                d7 = 0.0d;
            } else {
                d7 = d5;
            }
            if ((i & 32) != 0) {
                d8 = UtilHelper.getDimenPixelSize(R.dimen.tbds20);
            } else {
                d8 = d6;
            }
        }

        public final double a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e;
            }
            return invokeV.doubleValue;
        }

        public final double b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.c;
            }
            return invokeV.doubleValue;
        }

        public final double c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return invokeV.doubleValue;
        }

        public final double d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return invokeV.doubleValue;
        }

        public final double e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.b;
            }
            return invokeV.doubleValue;
        }

        public final double f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.f;
            }
            return invokeV.doubleValue;
        }
    }

    public fi7(a wrapper, BdUniqueId uniqueId, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wrapper, uniqueId, bool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        this.a = wrapper;
        this.b = uniqueId;
        this.c = bool;
    }

    public /* synthetic */ fi7(a aVar, BdUniqueId bdUniqueId, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, bdUniqueId, (i & 4) != 0 ? Boolean.TRUE : bool);
    }

    public final Boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (Boolean) invokeV.objValue;
    }

    public final BdUniqueId b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (a) invokeV.objValue;
    }
}
