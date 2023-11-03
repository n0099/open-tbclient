package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class dy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final boolean c;
    public final int d;
    public final String e;
    public final int f;
    public final Drawable g;
    public final Drawable h;
    public final Drawable i;
    public final float j;
    public final int k;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof dy0) {
                    dy0 dy0Var = (dy0) obj;
                    return Intrinsics.areEqual(this.a, dy0Var.a) && Intrinsics.areEqual(this.b, dy0Var.b) && this.c == dy0Var.c && this.d == dy0Var.d && Intrinsics.areEqual(this.e, dy0Var.e) && this.f == dy0Var.f && Intrinsics.areEqual(this.g, dy0Var.g) && Intrinsics.areEqual(this.h, dy0Var.h) && Intrinsics.areEqual(this.i, dy0Var.i) && Float.compare(this.j, dy0Var.j) == 0 && this.k == dy0Var.k;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z = this.c;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (((hashCode2 + i) * 31) + this.d) * 31;
            String str3 = this.e;
            int hashCode3 = (((i2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f) * 31;
            Drawable drawable = this.g;
            int hashCode4 = (hashCode3 + (drawable != null ? drawable.hashCode() : 0)) * 31;
            Drawable drawable2 = this.h;
            int hashCode5 = (hashCode4 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
            Drawable drawable3 = this.i;
            return ((((hashCode5 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + Float.floatToIntBits(this.j)) * 31) + this.k;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "NadRichTextParams(type=" + this.a + ", mainText=" + this.b + ", isMainTextBold=" + this.c + ", mainTextColor=" + this.d + ", linkText=" + this.e + ", linkTextColor=" + this.f + ", linkIcon=" + this.g + ", downloadLinkIcon=" + this.h + ", downloadCompleteLinkIcon=" + this.i + ", singleLineDisplayWidth=" + this.j + ", maxLines=" + this.k + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public dy0(String type, String mainText, boolean z, int i, String linkText, int i2, Drawable drawable, Drawable drawable2, Drawable drawable3, float f, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {type, mainText, Boolean.valueOf(z), Integer.valueOf(i), linkText, Integer.valueOf(i2), drawable, drawable2, drawable3, Float.valueOf(f), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        Intrinsics.checkNotNullParameter(linkText, "linkText");
        this.a = type;
        this.b = mainText;
        this.c = z;
        this.d = i;
        this.e = linkText;
        this.f = i2;
        this.g = drawable;
        this.h = drawable2;
        this.i = drawable3;
        this.j = f;
        this.k = i3;
    }

    public final Drawable a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (Drawable) invokeV.objValue;
    }

    public final Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (Drawable) invokeV.objValue;
    }

    public final Drawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (Drawable) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return invokeV.floatValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }
}
