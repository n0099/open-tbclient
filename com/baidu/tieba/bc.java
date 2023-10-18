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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class bc {
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

    public static String c(kb kbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, kbVar)) == null) {
            if (kbVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(kbVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(kbVar.b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(kbVar.c, "utf-8"));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(kbVar.q, "utf-8"));
                if (!TextUtils.isEmpty(kbVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(kbVar.d, "utf-8"));
                }
                if (!TextUtils.isEmpty(kbVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(kbVar.e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(kbVar.k, "utf-8"));
                if (!TextUtils.isEmpty(kbVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(kbVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(kbVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(kbVar.f, "utf-8"));
                }
                if (!TextUtils.isEmpty(kbVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(kbVar.i, "utf-8"));
                }
                if (!TextUtils.isEmpty(kbVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(kbVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(kbVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(kbVar.g, "utf-8"));
                }
                if (!TextUtils.isEmpty(kbVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(kbVar.h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(kbVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, kb kbVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, kbVar)) == null) {
            if (kbVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", kbVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, kbVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, kbVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, kbVar.j, z);
            b(sb, HttpConstants.OS_VERSION, kbVar.q, z);
            b(sb, "from", kbVar.d, z);
            b(sb, "cfrom", kbVar.e, z);
            b(sb, "net_type", kbVar.p, z);
            b(sb, "cuid", kbVar.g, z);
            b(sb, "model", kbVar.k, z);
            if (TextUtils.isEmpty(kbVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", kbVar.l, z);
            }
            b(sb, "un", kbVar.m, z);
            b(sb, "utbrand", kbVar.w, z);
            b(sb, "cuid_galaxy2", kbVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(qb qbVar, kb kbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, qbVar, kbVar)) == null) {
            if (qbVar.p() != null && (qbVar.p().equals("omp") || qbVar.p().equals("mon"))) {
                return c(kbVar);
            }
            return d(true, kbVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, kb kbVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, kbVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", kbVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, kbVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, kbVar.j);
            a(hashMap, "from", kbVar.d);
            a(hashMap, "net_type", kbVar.p);
            a(hashMap, "cuid", kbVar.g);
            a(hashMap, "cuid_galaxy2", kbVar.h);
            if (TextUtils.isEmpty(kbVar.l)) {
                kbVar.l = "0";
            }
            a(hashMap, "uid", kbVar.l);
            a(hashMap, "un", kbVar.m);
            a(hashMap, HttpRequest.BDUSS, kbVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", kbVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, kbVar.s);
            a(hashMap, TiebaStatic.Params.BDID, kbVar.z);
            a(hashMap, "cookie", kbVar.n);
            a(hashMap, "utbrand", kbVar.w);
            a(hashMap, "baiduapppb_ut", kbVar.x);
            a(hashMap, "user_agent", kbVar.y);
            a(hashMap, "active_timestamp", kbVar.A);
            a(hashMap, "first_install_time", kbVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, kbVar.C);
            a(hashMap, "event_day", kbVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", kbVar.k);
                a(hashMap, "oaid", kbVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, kbVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, kbVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", kbVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
