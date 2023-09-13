package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class es0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a g;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public final fr0 e;
    public final List<fs0> f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947744775, "Lcom/baidu/tieba/es0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947744775, "Lcom/baidu/tieba/es0;");
                return;
            }
        }
        g = new a(null);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof es0) {
                    es0 es0Var = (es0) obj;
                    return Intrinsics.areEqual(this.a, es0Var.a) && Intrinsics.areEqual(this.b, es0Var.b) && this.c == es0Var.c && Intrinsics.areEqual(this.d, es0Var.d) && Intrinsics.areEqual(this.e, es0Var.e) && Intrinsics.areEqual(this.f, es0Var.f);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c) * 31;
            String str3 = this.d;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            fr0 fr0Var = this.e;
            int hashCode4 = (hashCode3 + (fr0Var != null ? fr0Var.hashCode() : 0)) * 31;
            List<fs0> list = this.f;
            return hashCode4 + (list != null ? list.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "ImageInfoData(imageStyle=" + this.a + ", url=" + this.b + ", chargeDuration=" + this.c + ", scrollChargeSwitch=" + this.d + ", downloadData=" + this.e + ", imageList=" + this.f + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final es0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString("image_info_style", "0");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(\"image_info_style\", \"0\")");
                    String optString2 = jSONObject.optString("url");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"url\")");
                    int optInt = jSONObject.optInt("image_style_charge_duration");
                    String optString3 = jSONObject.optString("image_style_scroll_charge_switch");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"image_style_scroll_charge_switch\")");
                    return new es0(optString, optString2, optInt, optString3, fr0.c(jSONObject.optJSONObject("ad_download")), es0.g.b(jSONObject.optJSONArray("images")));
                }
                return null;
            }
            return (es0) invokeL.objValue;
        }

        public final List<fs0> b(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
                if (jSONArray != null && jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        fs0 a = fs0.c.a(jSONArray.optJSONObject(i));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                    return arrayList;
                }
                return new ArrayList();
            }
            return (List) invokeL.objValue;
        }
    }

    public es0(String imageStyle, String url, int i, String scrollChargeSwitch, fr0 fr0Var, List<fs0> imageList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageStyle, url, Integer.valueOf(i), scrollChargeSwitch, fr0Var, imageList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(imageStyle, "imageStyle");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(scrollChargeSwitch, "scrollChargeSwitch");
        Intrinsics.checkNotNullParameter(imageList, "imageList");
        this.a = imageStyle;
        this.b = url;
        this.c = i;
        this.d = scrollChargeSwitch;
        this.e = fr0Var;
        this.f = imageList;
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.c;
            if (i <= 0) {
                return 0L;
            }
            return TimeUnit.SECONDS.toMillis(i);
        }
        return invokeV.longValue;
    }

    public final fr0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (fr0) invokeV.objValue;
    }

    public final List<fs0> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return Intrinsics.areEqual(this.a, "1");
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return Intrinsics.areEqual(this.a, "0");
        }
        return invokeV.booleanValue;
    }
}
