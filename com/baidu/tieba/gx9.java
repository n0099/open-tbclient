package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class gx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public String b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public Function0<Unit> h;
    public View.OnClickListener i;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof gx9) {
                gx9 gx9Var = (gx9) obj;
                return this.a == gx9Var.a && Intrinsics.areEqual(this.b, gx9Var.b) && this.c == gx9Var.c && this.d == gx9Var.d && this.e == gx9Var.e && this.f == gx9Var.f && this.g == gx9Var.g && Intrinsics.areEqual(this.h, gx9Var.h) && Intrinsics.areEqual(this.i, gx9Var.i);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = ((((((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            boolean z = this.f;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.g;
            int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
            Function0<Unit> function0 = this.h;
            int hashCode2 = (i3 + (function0 == null ? 0 : function0.hashCode())) * 31;
            View.OnClickListener onClickListener = this.i;
            return hashCode2 + (onClickListener != null ? onClickListener.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "FeedbackButtonState(iconResId=" + this.a + ", text=" + this.b + ", borderColorInt=" + this.c + ", backgroundColorInt=" + this.d + ", textColorResId=" + this.e + ", needPlay=" + this.f + ", isLooping=" + this.g + ", onDynamicAnimEndListener=" + this.h + ", onClickListener=" + this.i + ')';
        }
        return (String) invokeV.objValue;
    }

    public gx9(int i, String text, int i2, int i3, int i4, boolean z, boolean z2, Function0<Unit> function0, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), text, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2), function0, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = i;
        this.b = text;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = z;
        this.g = z2;
        this.h = function0;
        this.i = onClickListener;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ gx9(int i, String str, int i2, int i3, int i4, boolean z, boolean z2, Function0 function0, View.OnClickListener onClickListener, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3, i4, r9, r10, r11, r12);
        boolean z3;
        boolean z4;
        Function0 function02;
        View.OnClickListener onClickListener2;
        if ((i5 & 32) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i5 & 64) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if ((i5 & 128) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        if ((i5 & 256) != 0) {
            onClickListener2 = null;
        } else {
            onClickListener2 = onClickListener;
        }
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final View.OnClickListener e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public final Function0<Unit> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (Function0) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public final void k(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, function0) == null) {
            this.h = function0;
        }
    }
}
