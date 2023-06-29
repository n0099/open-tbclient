package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class id5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("funny_sprite_support_text")
    public final String a;
    @SerializedName("funny_sprite_loop_time")
    public final Integer b;
    @SerializedName("funny_sprite_bubble_text_length")
    public final Integer c;
    @SerializedName("funny_sprite_bubble_text_line_number")
    public final Integer d;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof id5) {
                id5 id5Var = (id5) obj;
                return Intrinsics.areEqual(this.a, id5Var.a) && Intrinsics.areEqual(this.b, id5Var.b) && Intrinsics.areEqual(this.c, id5Var.c) && Intrinsics.areEqual(this.d, id5Var.d);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String str = this.a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.b;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.c;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.d;
            return hashCode3 + (num3 != null ? num3.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "FunnySpriteConfig(funnySpriteSupportText=" + this.a + ", funnySpriteLoopTime=" + this.b + ", funnySpriteBubbleTextLength=" + this.c + ", funnySpriteBubbleTextLineLimit=" + this.d + ')';
        }
        return (String) invokeV.objValue;
    }

    public final Integer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (Integer) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
