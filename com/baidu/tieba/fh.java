package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.tts.jni.TtsLogLoad;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class fh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(HashMap<String, Object> hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, hashMap, str, str2) == null) && hashMap != null && str != null && str2 != null) {
            hashMap.put(str, str2);
        }
    }

    public static void b(StringBuilder sb, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sb, str, str2, Boolean.valueOf(z)}) == null) && sb != null && !TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                sb.append("&");
                sb.append(str);
                sb.append("=");
                if (z) {
                    str2 = URLEncoder.encode(str2, "utf-8");
                }
                sb.append(str2);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static String c(og ogVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ogVar)) == null) {
            if (ogVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ogVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ogVar.b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ogVar.c, "utf-8"));
                sb.append("&");
                sb.append(TtsLogLoad.KEY_OS);
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ogVar.q, "utf-8"));
                if (!TextUtils.isEmpty(ogVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ogVar.d, "utf-8"));
                }
                if (!TextUtils.isEmpty(ogVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ogVar.e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ogVar.k, "utf-8"));
                if (!TextUtils.isEmpty(ogVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ogVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(ogVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ogVar.f, "utf-8"));
                }
                if (!TextUtils.isEmpty(ogVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ogVar.i, "utf-8"));
                }
                if (!TextUtils.isEmpty(ogVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ogVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(ogVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ogVar.g, "utf-8"));
                }
                if (!TextUtils.isEmpty(ogVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ogVar.h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ogVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, og ogVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ogVar)) == null) {
            if (ogVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ogVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ogVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ogVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ogVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ogVar.q, z);
            b(sb, "from", ogVar.d, z);
            b(sb, "cfrom", ogVar.e, z);
            b(sb, "net_type", ogVar.p, z);
            b(sb, "cuid", ogVar.g, z);
            b(sb, "model", ogVar.k, z);
            if (TextUtils.isEmpty(ogVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ogVar.l, z);
            }
            b(sb, "un", ogVar.m, z);
            b(sb, "utbrand", ogVar.w, z);
            b(sb, "cuid_galaxy2", ogVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(ug ugVar, og ogVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ugVar, ogVar)) == null) {
            if (ugVar.p() != null && (ugVar.p().equals("omp") || ugVar.p().equals("mon"))) {
                return c(ogVar);
            }
            return d(true, ogVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, og ogVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ogVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ogVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ogVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ogVar.j);
            a(hashMap, "from", ogVar.d);
            a(hashMap, "net_type", ogVar.p);
            a(hashMap, "cuid", ogVar.g);
            a(hashMap, "cuid_galaxy2", ogVar.h);
            if (TextUtils.isEmpty(ogVar.l)) {
                ogVar.l = "0";
            }
            a(hashMap, "uid", ogVar.l);
            a(hashMap, "un", ogVar.m);
            a(hashMap, HttpRequest.BDUSS, ogVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ogVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, ogVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ogVar.z);
            a(hashMap, "cookie", ogVar.n);
            a(hashMap, "utbrand", ogVar.w);
            a(hashMap, "baiduapppb_ut", ogVar.x);
            a(hashMap, "user_agent", ogVar.y);
            a(hashMap, "active_timestamp", ogVar.A);
            a(hashMap, "first_install_time", ogVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ogVar.C);
            a(hashMap, "event_day", ogVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", ogVar.k);
                a(hashMap, "oaid", ogVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, ogVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, ogVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", ogVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
