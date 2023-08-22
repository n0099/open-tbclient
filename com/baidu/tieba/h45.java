package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.UniversalLabel;
/* loaded from: classes6.dex */
public final class h45 {
    public static /* synthetic */ Interceptable $ic;
    public static final a h;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947773760, "Lcom/baidu/tieba/h45;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947773760, "Lcom/baidu/tieba/h45;");
                return;
            }
        }
        h = new a(null);
    }

    @JvmStatic
    public static final h45 g(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? h.a(jSONObject) : (h45) invokeL.objValue;
    }

    @JvmStatic
    public static final h45 h(UniversalLabel universalLabel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, universalLabel)) == null) ? h.b(universalLabel) : (h45) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h45) {
                h45 h45Var = (h45) obj;
                return Intrinsics.areEqual(this.a, h45Var.a) && Intrinsics.areEqual(this.b, h45Var.b) && Intrinsics.areEqual(this.c, h45Var.c) && Intrinsics.areEqual(this.d, h45Var.d) && Intrinsics.areEqual(this.e, h45Var.e) && Intrinsics.areEqual(this.f, h45Var.f) && this.g == h45Var.g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "UniversalLabelInfo(labelId=" + this.a + ", labelText=" + this.b + ", textColor=" + this.c + ", textColorBlack=" + this.d + ", backgroundColor=" + this.e + ", backgroundColorBlack=" + this.f + ", roundRadius=" + this.g + ')';
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
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

        @JvmStatic
        public final h45 a(JSONObject label) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, label)) == null) {
                Intrinsics.checkNotNullParameter(label, "label");
                String optString = label.optString("label_id");
                Intrinsics.checkNotNullExpressionValue(optString, "label.optString(\"label_id\")");
                String optString2 = label.optString("label_text");
                Intrinsics.checkNotNullExpressionValue(optString2, "label.optString(\"label_text\")");
                String optString3 = label.optString("text_color'");
                Intrinsics.checkNotNullExpressionValue(optString3, "label.optString(\"text_color'\")");
                String optString4 = label.optString("text_color_black");
                Intrinsics.checkNotNullExpressionValue(optString4, "label.optString(\"text_color_black\")");
                String optString5 = label.optString("background_color");
                Intrinsics.checkNotNullExpressionValue(optString5, "label.optString(\"background_color\")");
                String optString6 = label.optString("background_color_black");
                Intrinsics.checkNotNullExpressionValue(optString6, "label.optString(\"background_color_black\")");
                return new h45(optString, optString2, optString3, optString4, optString5, optString6, label.optInt("round_radius"));
            }
            return (h45) invokeL.objValue;
        }

        @JvmStatic
        public final h45 b(UniversalLabel label) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, label)) == null) {
                Intrinsics.checkNotNullParameter(label, "label");
                String str = label.label_id;
                Intrinsics.checkNotNullExpressionValue(str, "label.label_id");
                String str2 = label.label_text;
                Intrinsics.checkNotNullExpressionValue(str2, "label.label_text");
                String str3 = label.text_color;
                Intrinsics.checkNotNullExpressionValue(str3, "label.text_color");
                String str4 = label.text_color_black;
                Intrinsics.checkNotNullExpressionValue(str4, "label.text_color_black");
                String str5 = label.background_color;
                Intrinsics.checkNotNullExpressionValue(str5, "label.background_color");
                String str6 = label.background_color_black;
                Intrinsics.checkNotNullExpressionValue(str6, "label.background_color_black");
                Integer num = label.round_radius;
                Intrinsics.checkNotNullExpressionValue(num, "label.round_radius");
                return new h45(str, str2, str3, str4, str5, str6, num.intValue());
            }
            return (h45) invokeL.objValue;
        }
    }

    public h45(String labelId, String labelText, String textColor, String textColorBlack, String backgroundColor, String backgroundColorBlack, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {labelId, labelText, textColor, textColorBlack, backgroundColor, backgroundColorBlack, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(labelId, "labelId");
        Intrinsics.checkNotNullParameter(labelText, "labelText");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(textColorBlack, "textColorBlack");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(backgroundColorBlack, "backgroundColorBlack");
        this.a = labelId;
        this.b = labelText;
        this.c = textColor;
        this.d = textColorBlack;
        this.e = backgroundColor;
        this.f = backgroundColorBlack;
        this.g = i;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }
}
