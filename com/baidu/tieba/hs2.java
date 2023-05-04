package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hs2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947834210, "Lcom/baidu/tieba/hs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947834210, "Lcom/baidu/tieba/hs2;");
                return;
            }
        }
        a = ho1.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(v62 v62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, v62Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (v62Var != null) {
                try {
                    jSONObject.put("containerId", v62Var.getContainerId());
                    jSONObject.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, BdZeusUtil.isWebkitLoaded());
                } catch (JSONException e) {
                    if (!a) {
                        e.printStackTrace();
                    } else {
                        throw new RuntimeException(e);
                    }
                }
            }
            jSONObject.put("scheme", SchemeConfig.getSchemeHead());
            String b = b(re2.U().T());
            x42.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + kj2.r(b));
            jSONObject.put("sdkExtension", b);
            jSONObject.put("gameSdkExtension", b(fr2.i().s()));
            jSONObject.put("isDebugSdk", a);
            if ((v62Var instanceof NgWebView) && ((NgWebView) v62Var).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", lg3.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = lg3.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && w33.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = er2.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = dh3.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", uj2.USER_DATA_PATH);
            jSONObject.put("preloadId", re2.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.d.h());
            jSONObject.put("ttsExtractJSUrl", gk4.b().a());
            jSONObject.put("coreJSPath", re2.U().c0());
            if (hx1.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) sz1.d()));
            }
            jSONObject.put("swanNativeVersion", io1.a());
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return "";
            }
            return jSONObject2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(ExtensionCore extensionCore) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, extensionCore)) == null) {
            if (extensionCore != null && !TextUtils.isEmpty(extensionCore.extensionCorePath)) {
                return extensionCore.extensionCorePath;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
