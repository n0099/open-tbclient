package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final gv6 b;
    public final hv6 c;
    public final String d;
    public final int e;
    public final gv6 f;
    public final String g;
    public final String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public gv6 p;
    public String q;
    public gv6 r;
    public String s;
    public gv6 t;

    public fv6(int i, gv6 mainImage, hv6 titleTags, String leftIconBackgroundColor, int i2, gv6 leftIconImage, String leftIconTextColorString, String leftIconText) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), mainImage, titleTags, leftIconBackgroundColor, Integer.valueOf(i2), leftIconImage, leftIconTextColorString, leftIconText};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mainImage, "mainImage");
        Intrinsics.checkNotNullParameter(titleTags, "titleTags");
        Intrinsics.checkNotNullParameter(leftIconBackgroundColor, "leftIconBackgroundColor");
        Intrinsics.checkNotNullParameter(leftIconImage, "leftIconImage");
        Intrinsics.checkNotNullParameter(leftIconTextColorString, "leftIconTextColorString");
        Intrinsics.checkNotNullParameter(leftIconText, "leftIconText");
        this.a = i;
        this.b = mainImage;
        this.c = titleTags;
        this.d = leftIconBackgroundColor;
        this.e = i2;
        this.f = leftIconImage;
        this.g = leftIconTextColorString;
        this.h = leftIconText;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = new gv6(0, 0, null, 7, null);
        this.q = "";
        this.r = new gv6(0, 0, null, 7, null);
        this.s = "";
        this.t = new gv6(0, 0, null, 7, null);
    }

    public final hv6 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (hv6) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final gv6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.p;
        }
        return (gv6) invokeV.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public final gv6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.t;
        }
        return (gv6) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public final gv6 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.r;
        }
        return (gv6) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final gv6 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.f;
        }
        return (gv6) invokeV.objValue;
    }

    public final String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final gv6 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.b;
        }
        return (gv6) invokeV.objValue;
    }

    public final String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public final int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public final fv6 B(String leftIconSubText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, leftIconSubText)) == null) {
            Intrinsics.checkNotNullParameter(leftIconSubText, "leftIconSubText");
            this.m = leftIconSubText;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 C(String leftIconSubTextColorString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, leftIconSubTextColorString)) == null) {
            Intrinsics.checkNotNullParameter(leftIconSubTextColorString, "leftIconSubTextColorString");
            this.l = leftIconSubTextColorString;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 D(String rightButtonText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rightButtonText)) == null) {
            Intrinsics.checkNotNullParameter(rightButtonText, "rightButtonText");
            this.n = rightButtonText;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.i = str;
        }
    }

    public final fv6 F(String subtitleText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, subtitleText)) == null) {
            Intrinsics.checkNotNullParameter(subtitleText, "subtitleText");
            this.j = subtitleText;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 a(gv6 bottomLeftIconImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bottomLeftIconImage)) == null) {
            Intrinsics.checkNotNullParameter(bottomLeftIconImage, "bottomLeftIconImage");
            this.p = bottomLeftIconImage;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 b(String bottomLeftIconText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bottomLeftIconText)) == null) {
            Intrinsics.checkNotNullParameter(bottomLeftIconText, "bottomLeftIconText");
            this.q = bottomLeftIconText;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 c(gv6 bottomRightEndIconImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bottomRightEndIconImage)) == null) {
            Intrinsics.checkNotNullParameter(bottomRightEndIconImage, "bottomRightEndIconImage");
            this.t = bottomRightEndIconImage;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 d(String bottomRightIconText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bottomRightIconText)) == null) {
            Intrinsics.checkNotNullParameter(bottomRightIconText, "bottomRightIconText");
            this.s = bottomRightIconText;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 e(gv6 bottomRightStartIconImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bottomRightStartIconImage)) == null) {
            Intrinsics.checkNotNullParameter(bottomRightStartIconImage, "bottomRightStartIconImage");
            this.r = bottomRightStartIconImage;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 f(String descriptionOneLineText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, descriptionOneLineText)) == null) {
            Intrinsics.checkNotNullParameter(descriptionOneLineText, "descriptionOneLineText");
            this.o = descriptionOneLineText;
            return this;
        }
        return (fv6) invokeL.objValue;
    }

    public final fv6 g(String descriptionText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, descriptionText)) == null) {
            Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
            this.k = descriptionText;
            return this;
        }
        return (fv6) invokeL.objValue;
    }
}
