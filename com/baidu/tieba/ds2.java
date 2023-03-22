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
public class ds2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715046, "Lcom/baidu/tieba/ds2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715046, "Lcom/baidu/tieba/ds2;");
                return;
            }
        }
        a = do1.a;
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public static String a(r62 r62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r62Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (r62Var != null) {
                try {
                    jSONObject.put("containerId", r62Var.getContainerId());
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
            String b = b(ne2.U().T());
            t42.k("SwanAppNativeSwanUtils", "getEnvVariables extensionAvailable:" + gj2.r(b));
            jSONObject.put("sdkExtension", b);
            jSONObject.put("gameSdkExtension", b(br2.i().s()));
            jSONObject.put("isDebugSdk", a);
            if ((r62Var instanceof NgWebView) && ((NgWebView) r62Var).isSwanWebMode()) {
                jSONObject.put("ctsEnabled", hg3.a().getInt("aiapps_web_mode_cts_use_key", 0));
            }
            String string = hg3.a().getString("ctsUrl", "");
            if (!TextUtils.isEmpty(string) && s33.s()) {
                jSONObject.put("ctsJsAddress", new JSONObject(string));
            }
            String i = ar2.o().i();
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("hostName", i);
            }
            jSONObject.put(Constants.PARAM_PLATFORM, "android");
            JSONObject a2 = zg3.a();
            a2.put("swanswitch_common_sys_info_binding", true);
            a2.put("swanswitch_ab_sync_auth", true);
            jSONObject.put("abTestSwitch", a2);
            jSONObject.put("userDataPath", qj2.USER_DATA_PATH);
            jSONObject.put("preloadId", ne2.U().a0());
            jSONObject.put("isBaiduSeries", SwanAppAllianceLoginHelper.d.h());
            jSONObject.put("ttsExtractJSUrl", ck4.b().a());
            jSONObject.put("coreJSPath", ne2.U().c0());
            if (dx1.d()) {
                jSONObject.put("pendingList", new JSONArray((Collection) oz1.d()));
            }
            jSONObject.put("swanNativeVersion", eo1.a());
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
