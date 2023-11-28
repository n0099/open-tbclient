package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.er2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class er2<SelfT extends er2<SelfT>> extends hr2<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public long d;

    /* loaded from: classes5.dex */
    public static final class a extends er2<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a N1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (a) invokeV.objValue;
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

        @Override // com.baidu.tieba.dl3
        public /* bridge */ /* synthetic */ dl3 n() {
            N1();
            return this;
        }

        @Override // com.baidu.tieba.er2, com.baidu.tieba.kr2
        public /* bridge */ /* synthetic */ kr2 E(Bundle bundle) {
            return super.E(bundle);
        }

        @Override // com.baidu.tieba.er2, com.baidu.tieba.hr2
        public /* bridge */ /* synthetic */ hr2 R0(int i) {
            return super.R0(i);
        }

        @Override // com.baidu.tieba.er2, com.baidu.tieba.hr2
        public /* bridge */ /* synthetic */ hr2 w0(String str) {
            return super.w0(str);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947743876, "Lcom/baidu/tieba/er2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947743876, "Lcom/baidu/tieba/er2;");
                return;
            }
        }
        e = sm1.a;
    }

    public er2() {
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

    @Override // com.baidu.tieba.kr2
    public Bundle D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle D = super.D();
            k32.g(D);
            String I = I();
            if (!TextUtils.isEmpty(I)) {
                D.putString("mAppId", I);
            }
            return D;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hr2
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null && !TextUtils.isEmpty(g0.appId)) {
                return g0.appId;
            }
            return super.I();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hr2
    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null && !TextUtils.isEmpty(g0.appKey)) {
                return g0.appKey;
            }
            return super.J();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hr2
    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null && !TextUtils.isEmpty(g0.appName)) {
                return g0.appName;
            }
            return super.L();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hr2
    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null && !TextUtils.isEmpty(g0.iconUrl)) {
                return g0.iconUrl;
            }
            return super.R();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hr2
    public int e0() {
        InterceptResult invokeV;
        int orientation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                orientation = -1;
            } else {
                orientation = g0.getOrientation();
            }
            if (-1 >= orientation) {
                return super.e0();
            }
            return orientation;
        }
        return invokeV.intValue;
    }

    public String f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return "";
            }
            return g0.description;
        }
        return (String) invokeV.objValue;
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return 0;
            }
            return g0.appStatus;
        }
        return invokeV.intValue;
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return "";
            }
            return g0.statusDetail;
        }
        return (String) invokeV.objValue;
    }

    public String i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return "";
            }
            return g0.statusDesc;
        }
        return (String) invokeV.objValue;
    }

    public long j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return 0L;
            }
            return g0.pkgSize;
        }
        return invokeV.longValue;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public SwanAppBearInfo l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return null;
            }
            String str = g0.bearInfo;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new SwanAppBearInfo(str);
        }
        return (SwanAppBearInfo) invokeV.objValue;
    }

    public int q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return PMSConstants.PayProtected.NO_PAY_PROTECTED.type;
            }
            return g0.payProtected;
        }
        return invokeV.intValue;
    }

    public String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return null;
            }
            return g0.quickAppKey;
        }
        return (String) invokeV.objValue;
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return "";
            }
            return g0.resumeDate;
        }
        return (String) invokeV.objValue;
    }

    public String t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return "";
            }
            return g0.serviceCategory;
        }
        return (String) invokeV.objValue;
    }

    public String u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return "";
            }
            return g0.subjectInfo;
        }
        return (String) invokeV.objValue;
    }

    public long v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public int w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return 0;
            }
            return g0.type;
        }
        return invokeV.intValue;
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return "";
            }
            return String.valueOf(g0.versionCode);
        }
        return (String) invokeV.objValue;
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 == null) {
                return "";
            }
            return g0.versionName;
        }
        return (String) invokeV.objValue;
    }

    public static er2 e1(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            boolean z = e;
            return new a().L1(intent);
        }
        return (er2) invokeL.objValue;
    }

    public static String z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
                return str.substring(1);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public SelfT A1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null) {
                g0.description = str;
                return (SelfT) super.u0(str);
            }
            return (SelfT) n();
        }
        return (SelfT) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hr2
    /* renamed from: B1 */
    public SelfT w0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            super.w0(str);
            PMSAppInfo g0 = g0();
            if (g0 != null) {
                g0.appId = str;
                return (SelfT) super.w0(str);
            }
            return (SelfT) n();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT C1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null) {
                g0.appKey = str;
            }
            return (SelfT) super.x0(str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT D1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null) {
                g0.appName = str;
            }
            return (SelfT) super.y0(str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT E1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            super.F0(str);
            PMSAppInfo g0 = g0();
            if (g0 != null) {
                g0.iconUrl = str;
                return (SelfT) super.F0(str);
            }
            return (SelfT) n();
        }
        return (SelfT) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hr2
    /* renamed from: F1 */
    public SelfT R0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null) {
                g0.setOrientation(i);
                return (SelfT) super.R0(i);
            }
            return (SelfT) n();
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT G1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null) {
                g0.serviceCategory = str;
                return (SelfT) super.V0(str);
            }
            return (SelfT) n();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT H1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            PMSAppInfo g0 = g0();
            if (g0 != null) {
                g0.subjectInfo = str;
                return (SelfT) super.X0(str);
            }
            return (SelfT) n();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT I1(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            if (this.d < 1 && j > 0) {
                this.d = j;
                return (SelfT) super.Z0(j);
            }
            return (SelfT) n();
        }
        return (SelfT) invokeJ.objValue;
    }

    public static String m1(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, swanAppConfigData)) == null) {
            if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
                return null;
            }
            String f = zj3.f(str);
            if (o13.k(f)) {
                return zj3.i(str, ia3.b);
            }
            if (!swanAppConfigData.p(z93.b(f))) {
                return null;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static String n1(er2 er2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, er2Var, swanAppConfigData)) == null) {
            return m1(z1(er2Var.f0()), swanAppConfigData);
        }
        return (String) invokeLL.objValue;
    }

    public static String o1(String str, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, swanAppConfigData)) == null) {
            if (!TextUtils.isEmpty(str) && swanAppConfigData != null) {
                return m1(z1(p1(str)), swanAppConfigData);
            }
            if (e) {
                Log.d("SwanAppLaunchInfo", "getPageInfo ret null - " + str);
                return null;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String p1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parse = Uri.parse(str);
            String j = zj3.j(parse);
            if (TextUtils.isEmpty(j)) {
                if (e) {
                    Log.d("SwanAppLaunchInfo", "getPageInfo appId is null");
                }
                return null;
            }
            String n = zj3.n(j, parse, true);
            if (TextUtils.isEmpty(n)) {
                if (e) {
                    Log.d("SwanAppLaunchInfo", "getPageInfo no launchPath ");
                }
                return null;
            }
            String i = zj3.i(parse.getEncodedQuery(), ia3.b);
            if (e) {
                Log.d("SwanAppLaunchInfo", "query: " + i);
            }
            if (!TextUtils.isEmpty(i)) {
                n = n + "?" + i;
            }
            if (e) {
                Log.d("SwanAppLaunchInfo", "launch path - " + n);
            }
            return n;
        }
        return (String) invokeL.objValue;
    }

    public SelfT J1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            PMSAppInfo g0 = g0();
            if (!TextUtils.isEmpty(str) && g0 != null) {
                try {
                    g0.versionCode = Integer.parseInt(str);
                    return (SelfT) super.c1(str);
                } catch (NumberFormatException e2) {
                    if (e) {
                        e2.printStackTrace();
                    }
                }
            }
            return (SelfT) n();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT L1(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, intent)) == null) {
            if (intent == null) {
                return (SelfT) n();
            }
            E(intent.getExtras());
            if (gr2.a(intent)) {
                J0("1250000000000000");
                x("box_cold_launch", -1L);
            }
            return (SelfT) n();
        }
        return (SelfT) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kr2
    /* renamed from: M1 */
    public SelfT E(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bundle)) == null) {
            if (bundle == null) {
                return (SelfT) n();
            }
            k32.h(bundle);
            oz2.e().h(bundle);
            super.E(bundle);
            if (TextUtils.isEmpty(bundle.getString("mPage"))) {
                B("mPage");
            }
            return (SelfT) n();
        }
        return (SelfT) invokeL.objValue;
    }

    public String K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "SwanAppLaunchInfo{mAppId='" + I() + "', mAppKey='" + J() + "', mAppTitle='" + L() + "', pmsAppInfo is null='" + m0() + "', launchFrom='" + U() + "', launchScheme='" + X() + "', page='" + f0() + "', mErrorCode=" + g1() + ", mErrorDetail='" + h1() + "', mErrorMsg='" + i1() + "', mResumeDate='" + s1() + "', maxSwanVersion='" + a0() + "', minSwanVersion='" + b0() + "', mVersion='" + x1() + "', mType=" + w1() + ", extraData=" + Q() + ", isDebug=" + o0() + ", isLocalDebug=" + q0() + ", targetSwanVersion='" + l0() + "', swanCoreVersion=" + k0() + ", appFrameType=" + H() + ", consoleSwitch=" + n0() + ", orientation=" + e0() + ", versionCode='" + y1() + "', launchFlags=" + T() + ", swanAppStartTime=" + v1() + ", extStartTimestamp=" + O() + ", remoteDebug='" + h0() + "', extJSonObject=" + N() + ", launchId=" + W() + '}';
        }
        return (String) invokeV.objValue;
    }

    public JSONObject k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            String X = X();
            if (X != null) {
                String queryParameter = Uri.parse(X).getQueryParameter("_swaninfo");
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        return new JSONObject(queryParameter).optJSONObject("baidusearch");
                    } catch (JSONException e2) {
                        if (e) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }
}
