package com.baidu.tieba;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.location.BDLocation;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.impl.nalib.encrypt.EncryptConstant;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tieba.bm3;
import com.baidu.tieba.u93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dm3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947709311, "Lcom/baidu/tieba/dm3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947709311, "Lcom/baidu/tieba/dm3;");
                return;
            }
        }
        a = wj1.a;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new SecretKeySpec((EncryptConstant.getPartRecommendAesKey() + "rtad@mic").getBytes(), "AES"), new IvParameterSpec((EncryptConstant.getPartRecommendAesIv() + "21248000").getBytes()));
                return Base64.encodeToString(cipher.doFinal(str.getBytes(IMAudioTransRequest.CHARSET)), 2);
            } catch (Exception e) {
                e.printStackTrace();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("info", "encrypt request param fail with exception : " + e.getMessage());
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                f(jSONObject.toString());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(bm3 bm3Var, cm3 cm3Var) {
        String str;
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, bm3Var, cm3Var) == null) && bm3Var != null && cm3Var != null) {
            if (TextUtils.isEmpty(cm3Var.a)) {
                str = "unknown";
            } else {
                str = cm3Var.a;
            }
            int i = 0;
            switch (str.hashCode()) {
                case -1395470197:
                    if (str.equals("bd09ll")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3017163:
                    if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 98175376:
                    if (str.equals("gcj02")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 113079775:
                    if (str.equals(CoordinateType.WGS84)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            i = -1;
                        } else {
                            i = 3;
                        }
                    } else {
                        i = 2;
                    }
                } else {
                    i = 1;
                }
            }
            bm3.c cVar = bm3Var.c;
            cVar.a = i;
            cVar.b = cm3Var.b;
            cVar.c = cm3Var.c;
        }
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String e = SwanAppNetworkUtils.e();
            if ("wifi".equals(e)) {
                return 1;
            }
            if ("2g".equals(e)) {
                return 2;
            }
            if ("3g".equals(e)) {
                return 3;
            }
            if ("4g".equals(e)) {
                return 4;
            }
            if ("5g".equals(e)) {
                return 5;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        TelephonyManager telephonyManager;
        String simOperator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (simOperator = telephonyManager.getSimOperator()) == null) {
                return 0;
            }
            if (!"46000".equals(simOperator) && !"46002".equals(simOperator) && !"46007".equals(simOperator)) {
                if ("46001".equals(simOperator)) {
                    return 3;
                }
                if (!"46003".equals(simOperator)) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (a) {
            Log.d("recommend", "reportInfoWhenResponseIsNull: " + str);
        }
        u93.b bVar = new u93.b(10003);
        bVar.i(str);
        bVar.h(m33.g0());
        bVar.m();
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
