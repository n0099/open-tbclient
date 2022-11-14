package com.baidu.tieba;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class fp2<SelfT extends fp2<SelfT>> extends ip2<SelfT> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public Pair<String, JSONObject> b;

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771745, "Lcom/baidu/tieba/fp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771745, "Lcom/baidu/tieba/fp2;");
                return;
            }
        }
        c = pk1.a;
    }

    public fp2() {
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

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return n("launch_app_download_url");
        }
        return (String) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return i("appFrameType");
        }
        return invokeV.intValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return o("mAppId", "");
        }
        return (String) invokeV.objValue;
    }

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return n("mAppKey");
        }
        return (String) invokeV.objValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return n("launch_app_open_url");
        }
        return (String) invokeV.objValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return n("mAppTitle");
        }
        return (String) invokeV.objValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return n("mClickId");
        }
        return (String) invokeV.objValue;
    }

    public long N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return k("last_start_timestamp");
        }
        return invokeV.longValue;
    }

    public ExtensionCore O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return (ExtensionCore) m("extensionCore");
        }
        return (ExtensionCore) invokeV.objValue;
    }

    public Bundle P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return f("mExtraData");
        }
        return (Bundle) invokeV.objValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return n("app_icon_url");
        }
        return (String) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return e("cts_launch_mode", false);
        }
        return invokeV.booleanValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return j("launchFlags", 0);
        }
        return invokeV.intValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return n("mFrom");
        }
        return (String) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return n("mFromLast");
        }
        return (String) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return n("launch_id");
        }
        return (String) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return n("launchScheme");
        }
        return (String) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return n("local_debug_ws_host");
        }
        return (String) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return n("local_debug_ws_port");
        }
        return (String) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return n("max_swan_version");
        }
        return (String) invokeV.objValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return n("min_swan_version");
        }
        return (String) invokeV.objValue;
    }

    public long b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return l("navigate_bar_color_key", 2147483648L);
        }
        return invokeV.longValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return n("notInHistory");
        }
        return (String) invokeV.objValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            int j = j("appFrameOrientation", -1);
            if (-1 >= j) {
                return -1;
            }
            return j;
        }
        return invokeV.intValue;
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return n("mPage");
        }
        return (String) invokeV.objValue;
    }

    public PMSAppInfo f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return (PMSAppInfo) m("pms_db_info_onload");
        }
        return (PMSAppInfo) invokeV.objValue;
    }

    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return n("remoteDebugUrl");
        }
        return (String) invokeV.objValue;
    }

    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return n("swan_app_sub_root_path");
        }
        return (String) invokeV.objValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return n("mSubscribeWithoutClick");
        }
        return (String) invokeV.objValue;
    }

    public SwanCoreVersion j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return (SwanCoreVersion) m("swanCoreVersion");
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return n("targetSwanVersion");
        }
        return (String) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (c("pms_db_info_onload") && f0() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return e("console_switch", false);
        }
        return invokeV.booleanValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return e("mIsDebug", false);
        }
        return invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return e("swan_app_independent", false);
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return e("local_debug_switch", false);
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public Bundle s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            Bundle P = P();
            if (P == null) {
                Bundle bundle = new Bundle();
                D0(bundle);
                return bundle;
            }
            return P;
        }
        return (Bundle) invokeV.objValue;
    }

    public SelfT A0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            return (SelfT) t("mIsDebug", z);
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT B0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            return (SelfT) x("last_start_timestamp", j);
        }
        return (SelfT) invokeJ.objValue;
    }

    public SelfT C0(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, extensionCore)) == null) {
            return (SelfT) y("extensionCore", extensionCore);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT D0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bundle)) == null) {
            return (SelfT) u("mExtraData", bundle);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return H0(i | S());
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT E0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            z("app_icon_url", str);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT F0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            return (SelfT) t("swan_app_independent", z);
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT G0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            t("cts_launch_mode", z);
            return (SelfT) a();
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT H0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            return (SelfT) w("launchFlags", i);
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT I0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            z("mFromLast", T());
            return (SelfT) z("mFrom", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT J0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return (SelfT) z("launch_id", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT K0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            return (SelfT) z("launchScheme", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT L0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
            return (SelfT) t("local_debug_switch", z);
        }
        return (SelfT) invokeZ.objValue;
    }

    public SelfT M0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            return (SelfT) z("local_debug_ws_host", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT N0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            return (SelfT) z("local_debug_ws_port", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT O0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048601, this, j)) == null) {
            if (2147483648L != j) {
                x("navigate_bar_color_key", j);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeJ.objValue;
    }

    public SelfT P0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            return (SelfT) z("notInHistory", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT Q0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            return (SelfT) w("appFrameOrientation", i);
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT R0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            return (SelfT) z("mPage", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT S0(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, pMSAppInfo)) == null) {
            return (SelfT) y("pms_db_info_onload", pMSAppInfo);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT T0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            return (SelfT) z("remoteDebugUrl", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT U0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT V0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            return (SelfT) z("swan_app_sub_root_path", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT W0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT X0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            return (SelfT) z("mSubscribeWithoutClick", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT Y0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048621, this, j)) == null) {
            return (SelfT) a();
        }
        return (SelfT) invokeJ.objValue;
    }

    public SelfT Z0(SwanCoreVersion swanCoreVersion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, swanCoreVersion)) == null) {
            return (SelfT) y("swanCoreVersion", swanCoreVersion);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT a1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            return (SelfT) z("targetSwanVersion", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT b1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT c1(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, pMSAppInfo)) == null) {
            if (pMSAppInfo != null) {
                y("pms_db_info_updated", pMSAppInfo);
                if (!l0()) {
                    S0(pMSAppInfo);
                }
            }
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT t0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) {
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT u0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048648, this, i)) == null) {
            return (SelfT) w("appFrameType", i);
        }
        return (SelfT) invokeI.objValue;
    }

    public SelfT v0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, str)) == null) {
            z("mAppId", str);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT w0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) {
            z("mAppKey", str);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT x0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, str)) == null) {
            z("mAppTitle", str);
            return (SelfT) a();
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT y0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, str)) == null) {
            return (SelfT) z("mClickId", str);
        }
        return (SelfT) invokeL.objValue;
    }

    public SelfT z0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048653, this, z)) == null) {
            return (SelfT) t("console_switch", z);
        }
        return (SelfT) invokeZ.objValue;
    }

    public JSONObject M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            String W = W();
            Pair<String, JSONObject> pair = this.b;
            if (pair != null && TextUtils.equals((CharSequence) pair.first, W)) {
                return (JSONObject) this.b.second;
            }
            this.b = null;
            if (TextUtils.isEmpty(W)) {
                this.b = null;
                return null;
            }
            String queryParameter = Uri.parse(W).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    this.b = new Pair<>(W, new JSONObject(queryParameter).optJSONObject("ext"));
                } catch (JSONException e) {
                    if (c) {
                        e.printStackTrace();
                    }
                }
            }
            Pair<String, JSONObject> pair2 = this.b;
            if (pair2 == null) {
                return null;
            }
            return (JSONObject) pair2.second;
        }
        return (JSONObject) invokeV.objValue;
    }

    public SelfT q0(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048644, this, str, j)) == null) {
            s0().putLong(str, j);
            return (SelfT) a();
        }
        return (SelfT) invokeLJ.objValue;
    }

    public SelfT r0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048645, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                s0().putString(str, str2);
            }
            return (SelfT) a();
        }
        return (SelfT) invokeLL.objValue;
    }
}
