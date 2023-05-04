package com.baidu.tieba;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.privacy.PrivacyParamType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes4.dex */
public final class fc9 {
    public static /* synthetic */ Interceptable $ic;
    public static final fc9 a;
    public static final HashMap<String, String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947759469, "Lcom/baidu/tieba/fc9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947759469, "Lcom/baidu/tieba/fc9;");
                return;
            }
        }
        a = new fc9();
        b = MapsKt__MapsKt.hashMapOf(TuplesKt.to(HttpRequest.PHONE_IMEI, HttpRequest.PHONE_IMEI_REVERSAL), TuplesKt.to(HttpRequest.ANDROID_ID, HttpRequest.ANDROID_ID_REVERSAL), TuplesKt.to("model", "ledom"), TuplesKt.to("oaid", "diao"), TuplesKt.to(HttpRequest.OS_VERSION, "noisrev_so"), TuplesKt.to("brand", "dnarb"), TuplesKt.to(HttpRequest.UH, "hu"), TuplesKt.to("ut", "tu"));
    }

    public fc9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (PrivacyParamType.f() && PrivacyParamType.a() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (!PrivacyParamType.f() || PrivacyParamType.a() != 1) {
                return "0";
            }
            return "1";
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return a(TbadkCoreApplication.getInst().getAndroidId());
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return a(Build.BRAND);
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return a(TbadkCoreApplication.getInst().getImei());
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String g = ki.g();
            Intrinsics.checkNotNullExpressionValue(g, "getModel()");
            return a(g);
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            String lastCachedOid = PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst());
            Intrinsics.checkNotNullExpressionValue(lastCachedOid, "getLastCachedOid(TbadkCoreApplication.getInst())");
            return lastCachedOid;
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String k = ki.k();
            Intrinsics.checkNotNullExpressionValue(k, "getOsVersion()");
            return a(k);
        }
        return (String) invokeV.objValue;
    }

    @JvmStatic
    public static final String a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return "";
            }
            if (!PrivacyParamType.f()) {
                return str;
            }
            int a2 = PrivacyParamType.a();
            if (a2 != 1) {
                if (a2 == 2) {
                    return "";
                }
                return str;
            }
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] B64Encode = Base64Encoder.B64Encode(bytes);
            if (B64Encode == null) {
                return "";
            }
            return new String(B64Encode, Charsets.UTF_8);
        }
        return (String) invokeL.objValue;
    }

    @JvmStatic
    public static final String g(String key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, key)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (!PrivacyParamType.f()) {
                return key;
            }
            int a2 = PrivacyParamType.a();
            if (a2 != 1) {
                if (a2 == 2) {
                    return "";
                }
                return key;
            }
            String str = b.get(key);
            if (str != null) {
                return str;
            }
            return key;
        }
        return (String) invokeL.objValue;
    }
}
